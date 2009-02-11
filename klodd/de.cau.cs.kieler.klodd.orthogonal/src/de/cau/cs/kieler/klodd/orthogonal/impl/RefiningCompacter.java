package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.orthogonal.modules.ICompacter;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;

/**
 * Compacter implementation that refines the graph and executes
 * another compacter for refined orthogonal representations. This
 * compacter expects a normalized orthogonal representation as input.
 * 
 * @author msp
 */
public class RefiningCompacter extends AbstractAlgorithm implements ICompacter {
	
	/**
	 * Structure that describes the needed data for addition of an edge
	 * for refinement of the graph.
	 */
	private static class RefinementEdge {
		/** source node for the new edge */
		TSMNode source;
		/** side at the source node for the new edge */
		TSMNode.Side sourceSide;
		/** edge which is split to create the target node */
		TSMEdge targetEdge;
		/** indicates whether the target is forward for the crossed face */
		boolean targetForward;
		/** side of external frame on which the target edge lies */
		TSMNode.Side externalSide = TSMNode.Side.UNDEFINED;
		
		/**
		 * Creates a refinement edge with given values.
		 * 
		 * @param source source node for the new edge
		 * @param sourceSide side at the source node for the new edge
		 * @param targetEdge edge which is split to create the target node
		 * @param targetForward indicates whether the target is forward
		 *     for the crossed face
		 */
		RefinementEdge(TSMNode source, TSMNode.Side sourceSide,
				TSMEdge targetEdge, boolean targetForward) {
			this.source = source;
			this.sourceSide = sourceSide;
			this.targetEdge = targetEdge;
			this.targetForward = targetForward;
		}
	}
	
	/** the embedded compacter for refined orthogonal representations */
	private ICompacter refinedCompacter;
	
	/** edge for the external refinement frame on north side */
	private TSMEdge northFrame;
	/** edge for the external refinement frame on east side */
	private TSMEdge eastFrame;
	/** edge for the external refinement frame on south side */
	private TSMEdge southFrame;
	/** edge for the external refinement frame on west side */
	private TSMEdge westFrame;
	/** indicates whether an edge connecting the external frame with the
	 *  contained graph has already been inserted */
	private boolean frameConnected = false;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		refinedCompacter.reset();
		frameConnected = false;
	}
	
	/**
	 * Creates a refining compacter based on the given compacter,
	 * which should work on a refined orthogonal representation.
	 * 
	 * @param refinedCompacter compacter that expects a refined
	 *     orthogonal representation
	 */
	public RefiningCompacter(ICompacter refinedCompacter) {
		this.refinedCompacter = refinedCompacter;
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.ICompacter#compact(de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph, float)
	 */
	public void compact(TSMGraph graph, float minDist) {
		// refine the internal faces
		ListIterator<TSMFace> faceIter = graph.faces.listIterator();
		while (faceIter.hasNext()) {
			TSMFace nextFace = faceIter.next();
			List<RefinementEdge> refinements = getRefinements(nextFace);
			List<TSMFace> newFaces = applyRefinements(graph, refinements);
			for (TSMFace newFace : newFaces)
				faceIter.add(newFace);
		}
		// build the external frame
		TSMFace oldExternalFace = buildExternalFrame(graph);
		// refine the external face
		List<RefinementEdge> refinements = getRefinements(oldExternalFace);
		List<TSMFace> newFaces = applyRefinements(graph, refinements);
		graph.faces.addAll(newFaces);
		
		// execute the embedded compacter
		refinedCompacter.compact(graph, minDist);
	}

	/**
	 * Creates refinement edges for the given face.
	 * 
	 * @param face face to be processed
	 * @return list of refinement edges
	 */
	private List<RefinementEdge> getRefinements(TSMFace face) {
		// !! the graph is assumed to be connected here !!
		List<TSMFace.BorderEntry> border = face.borders.get(0);
		List<RefinementEdge> refinementEdges = new LinkedList<RefinementEdge>();
		
		TSMFace.BorderEntry currentEntry = border.get(border.size() - 1);
		ListIterator<TSMFace.BorderEntry> entryIter = border.listIterator();
		while (entryIter.hasNext()) {
			TSMFace.BorderEntry nextEntry = entryIter.next();
			TSMNode.Side side1 = currentEntry.secondSide();
			TSMNode.Side side2 = nextEntry.firstSide();
			if (side1 == side2.left()) {
				// found a left turn, add refinement edge
				TSMFace.BorderEntry frontEntry = getFrontEdge(border,
						entryIter.previousIndex() < 1 ? border.size() - 1
						: entryIter.previousIndex() - 1);
				if (frontEntry == null) {
					TSMEdge frontEdge = null;
					switch (side1.opposed()) {
					case NORTH:
						frontEdge = northFrame;
						break;
					case EAST:
						frontEdge = eastFrame;
						break;
					case SOUTH:
						frontEdge = southFrame;
						break;
					case WEST:
						frontEdge = westFrame;
						break;
					}
					RefinementEdge refinementEdge = new RefinementEdge(
							currentEntry.secondNode(), side1.opposed(),
							frontEdge, true);
					refinementEdge.externalSide = side1.opposed();
					refinementEdges.add(refinementEdge);
				}
				else {
					refinementEdges.add(new RefinementEdge(
							currentEntry.secondNode(), side1.opposed(),
							frontEntry.edge, frontEntry.forward));
				}
			}
			currentEntry = nextEntry;
		}
		
		return refinementEdges;
	}
	
	/**
	 * Determines the front edge for the given position in the border.
	 * 
	 * @param border border in which the front edge shall be found
	 * @param startIndex index of the starting edge in the border
	 * @return border entry containing the front edge, or null if there
	 *     is no front edge
	 */
	private TSMFace.BorderEntry getFrontEdge(List<TSMFace.BorderEntry> border,
			int startIndex) {
		ListIterator<TSMFace.BorderEntry> entryIter = border
				.listIterator(startIndex);
		TSMFace.BorderEntry currentEntry = entryIter.next();
		int cornerSum = 0;
		while (entryIter.nextIndex() != startIndex) {
			if (!entryIter.hasNext())
				entryIter = border.listIterator();
			TSMFace.BorderEntry nextEntry = entryIter.next();
			TSMNode.Side side1 = currentEntry.secondSide();
			TSMNode.Side side2 = nextEntry.firstSide();
			if (side1 == side2.left())
				cornerSum--;
			else if (side1 == side2.right())
				cornerSum++;
			if (cornerSum == 1)
				return nextEntry;
			currentEntry = nextEntry;
		}
		return null;
	}
	
	/**
	 * Applies a set of refinements to the given graph.
	 * 
	 * @param graph graph to which new nodes and edges are added
	 * @param refinements list of refinement edges
	 * @return list of newly created faces
	 */
	private List<TSMFace> applyRefinements(TSMGraph graph,
			List<RefinementEdge> refinements) {
		List<TSMFace> newFaces = new LinkedList<TSMFace>();
		for (RefinementEdge refinementEdge : refinements) {
			// create new node and insert it into the border
			TSMNode newNode = new TSMNode(graph, TSMNode.Type.REFINEMENT);
			TSMEdge edge1 = refinementEdge.targetEdge;
			TSMNode oldNode2;
			TSMEdge edge2;
			if (refinementEdge.targetForward) {
				oldNode2 = edge1.target;
				edge1.target = newNode;
				edge2 = new TSMEdge(graph, newNode, oldNode2, edge1.layoutEdge);
			}
			else {
				oldNode2 = edge1.source;
				edge1.source = newNode;
				edge2 = new TSMEdge(graph, oldNode2, newNode, edge1.layoutEdge);
			}
			ListIterator<TSMNode.IncEntry> oldNode2Iter = oldNode2.getIterator(
					edge1, !refinementEdge.targetForward);
			oldNode2Iter.remove();
			oldNode2Iter.add(new TSMNode.IncEntry(edge2,
					refinementEdge.targetForward ? TSMNode.IncEntry.Type.IN
					: TSMNode.IncEntry.Type.OUT));
			newNode.incidence.add(new TSMNode.IncEntry(edge1,
					refinementEdge.targetForward ? TSMNode.IncEntry.Type.IN
							: TSMNode.IncEntry.Type.OUT));
			newNode.incidence.add(new TSMNode.IncEntry(edge2,
					refinementEdge.targetForward ? TSMNode.IncEntry.Type.OUT
							: TSMNode.IncEntry.Type.IN));
			edge2.sourceSide = edge1.sourceSide;
			edge2.targetSide = edge1.targetSide;
			
			// update faces left and right of edge1
			edge2.leftFace = edge1.leftFace;
			edge2.rightFace = edge1.rightFace;
			TSMFace currentFace = refinementEdge.targetForward
					? edge1.rightFace : edge1.leftFace;
			if (refinementEdge.externalSide == TSMNode.Side.UNDEFINED
					|| frameConnected) {
				ListIterator<TSMFace.BorderEntry> currentFaceIter = currentFace 
						.getIterator(edge1, refinementEdge.targetForward);
				currentFaceIter.add(new TSMFace.BorderEntry(edge2,
						refinementEdge.targetForward));
			}
			TSMFace opposedFace = refinementEdge.targetForward
					? edge1.leftFace : edge1.rightFace;
			ListIterator<TSMFace.BorderEntry> opposedFaceIter = opposedFace
					.getIterator(edge1, !refinementEdge.targetForward);
			opposedFaceIter.previous();
			opposedFaceIter.add(new TSMFace.BorderEntry(edge2,
					!refinementEdge.targetForward));
			
			// insert edge and add new face
			TSMFace newFace = insertEdge(graph, refinementEdge, currentFace,
					newNode, edge2);
			if (newFace != null)
				newFaces.add(newFace);
		}
		return newFaces;
	}
	
	/**
	 * Creates a new edge and inserts it into the graph, updating the
	 * related faces.
	 * 
	 * @param graph graph to which the new edge is added
	 * @param refinementEdge refinement edge for which the new edge is added
	 * @param face face which is crossed by the new edge
	 * @param targetNode target node of the new edge
	 * @param nextEdge the next edge for the border at the right of the
	 *     new edge
	 * @return a newly created face, or null if none was created
	 */
	private TSMFace insertEdge(TSMGraph graph, RefinementEdge refinementEdge,
			TSMFace face, TSMNode targetNode, TSMEdge nextEdge) {
		// add edge to the graph
		TSMEdge newEdge = new TSMEdge(graph, refinementEdge.source, targetNode);
		newEdge.connectNodes(refinementEdge.sourceSide,
				refinementEdge.sourceSide.opposed());
		
		if (refinementEdge.externalSide != TSMNode.Side.UNDEFINED
				&& !frameConnected) {
			// connect the external frame with the contained graph
			ListIterator<TSMFace.BorderEntry> faceIter = getIteratorFor(face,
					refinementEdge.source, refinementEdge.sourceSide.opposed());
			faceIter.add(new TSMFace.BorderEntry(newEdge, true));
			faceIter.add(new TSMFace.BorderEntry(nextEdge, true));
			switch (refinementEdge.externalSide) {
			case NORTH:
				faceIter.add(new TSMFace.BorderEntry(eastFrame, true));
				faceIter.add(new TSMFace.BorderEntry(southFrame, true));
				faceIter.add(new TSMFace.BorderEntry(westFrame, true));
				break;
			case EAST:
				faceIter.add(new TSMFace.BorderEntry(southFrame, true));
				faceIter.add(new TSMFace.BorderEntry(westFrame, true));
				faceIter.add(new TSMFace.BorderEntry(northFrame, true));
				break;
			case SOUTH:
				faceIter.add(new TSMFace.BorderEntry(westFrame, true));
				faceIter.add(new TSMFace.BorderEntry(northFrame, true));
				faceIter.add(new TSMFace.BorderEntry(eastFrame, true));
				break;
			case WEST:
				faceIter.add(new TSMFace.BorderEntry(northFrame, true));
				faceIter.add(new TSMFace.BorderEntry(eastFrame, true));
				faceIter.add(new TSMFace.BorderEntry(southFrame, true));
				break;
			}
			faceIter.add(new TSMFace.BorderEntry(refinementEdge.targetEdge, true));
			faceIter.add(new TSMFace.BorderEntry(newEdge, false));
			newEdge.leftFace = face;
			newEdge.rightFace = face;
			frameConnected = true;
			return null;
		}
		else {
			// split the crossed face
			TSMFace newFace = new TSMFace(graph, false);
			List<TSMFace.BorderEntry> newBorder = new LinkedList<TSMFace.BorderEntry>();
			ListIterator<TSMFace.BorderEntry> faceIter = getIteratorFor(face,
					refinementEdge.source, refinementEdge.sourceSide.opposed());
			int targetIndex = face.getIterator(refinementEdge.targetEdge,
					refinementEdge.targetForward).nextIndex();
			int nextIndex = faceIter.nextIndex();
			while (nextIndex != targetIndex) {
				if (!faceIter.hasNext()) {
					faceIter = face.borders.get(0).listIterator();
					nextIndex = 0;
				}
				TSMFace.BorderEntry nextEntry = faceIter.next();
				newBorder.add(new TSMFace.BorderEntry(nextEntry));
				faceIter.remove();
				if (nextEntry.forward)
					nextEntry.edge.rightFace = newFace;
				else
					nextEntry.edge.leftFace = newFace;
				nextIndex++;
			}
			faceIter.add(new TSMFace.BorderEntry(newEdge, true));
			newBorder.add(new TSMFace.BorderEntry(newEdge, false));
			newEdge.leftFace = newFace;
			newEdge.rightFace = face;
			newFace.borders.add(newBorder);
			return newFace;
		}
	}
	
	/**
	 * Gets an iterator over border entries of the given face pointing
	 * at the given node.
	 * 
	 * @param face face for which the iterator shall be created
	 * @param node node that is searched
	 * @param side side of the node at which the preceding edge is incident
	 * @return an iterator pointing at <code>node</code>, or null if the
	 *     node was not found
	 */
	private ListIterator<TSMFace.BorderEntry> getIteratorFor(TSMFace face,
			TSMNode node, TSMNode.Side side) {
		for (List<TSMFace.BorderEntry> border : face.borders) {
			ListIterator<TSMFace.BorderEntry> entryIter = border.listIterator();
			while (entryIter.hasNext()) {
				TSMFace.BorderEntry nextEntry = entryIter.next();
				if (nextEntry.forward && nextEntry.edge.target.id == node.id
							&& nextEntry.edge.targetSide == side
							|| !nextEntry.forward && nextEntry.edge.source.id
							== node.id && nextEntry.edge.sourceSide == side)
						return entryIter;
			}
		}
		return null;
	}
	
	/**
	 * Builds the external frame of the refined graph.
	 * 
	 * @param graph graph that is being refined
	 * @return the old external face of the graph
	 */
	private TSMFace buildExternalFrame(TSMGraph graph) {
		TSMFace oldExternal = graph.externalFace;
		TSMFace newExternal = new TSMFace(graph, false);
		List<TSMFace.BorderEntry> newBorder = new LinkedList<TSMFace.BorderEntry>();
		newExternal.borders.add(newBorder);
		graph.externalFace = newExternal;
		graph.faces.add(oldExternal);
		TSMNode neNode = new TSMNode(graph, TSMNode.Type.REFINEMENT);
		TSMNode seNode = new TSMNode(graph, TSMNode.Type.REFINEMENT);
		TSMNode swNode = new TSMNode(graph, TSMNode.Type.REFINEMENT);
		TSMNode nwNode = new TSMNode(graph, TSMNode.Type.REFINEMENT);
		northFrame = new TSMEdge(graph, nwNode, neNode);
		northFrame.connectNodes();
		northFrame.leftFace = newExternal;
		northFrame.rightFace = oldExternal;
		eastFrame = new TSMEdge(graph, neNode, seNode);
		eastFrame.connectNodes();
		eastFrame.leftFace = newExternal;
		eastFrame.rightFace = oldExternal;
		southFrame = new TSMEdge(graph, seNode, swNode);
		southFrame.connectNodes();
		southFrame.leftFace = newExternal;
		southFrame.rightFace = oldExternal;
		westFrame = new TSMEdge(graph, swNode, nwNode);
		westFrame.connectNodes();
		westFrame.leftFace = newExternal;
		westFrame.rightFace = oldExternal;
		newBorder.add(new TSMFace.BorderEntry(westFrame, false));
		newBorder.add(new TSMFace.BorderEntry(southFrame, false));
		newBorder.add(new TSMFace.BorderEntry(eastFrame, false));
		newBorder.add(new TSMFace.BorderEntry(northFrame, false));
		return oldExternal;
	}

}
