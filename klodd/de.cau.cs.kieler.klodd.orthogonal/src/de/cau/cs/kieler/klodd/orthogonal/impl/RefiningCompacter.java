package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.graph.KEdge;
import de.cau.cs.kieler.core.graph.KFace;
import de.cau.cs.kieler.core.graph.KGraph;
import de.cau.cs.kieler.core.graph.KNode;
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
		KNode.Side sourceSide;
		/** edge which is split to create the target node */
		TSMEdge targetEdge;
		/** indicates whether the target is forward for the crossed face */
		boolean targetForward;
		/** side of external frame on which the target edge lies */
		KNode.Side externalSide = KNode.Side.UNDEFINED;
		
		/**
		 * Creates a refinement edge with given values.
		 * 
		 * @param source source node for the new edge
		 * @param sourceSide side at the source node for the new edge
		 * @param targetEdge edge which is split to create the target node
		 * @param targetForward indicates whether the target is forward
		 *     for the crossed face
		 */
		RefinementEdge(TSMNode source, KNode.Side sourceSide,
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
	public void compact(KGraph graph, float minDist) {
		getMonitor().begin("Refined compaction", 1);
		
		// refine the internal faces
		ListIterator<KFace> faceIter = graph.faces.listIterator();
		while (faceIter.hasNext()) {
			KFace nextFace = faceIter.next();
			List<RefinementEdge> refinements = getRefinements(nextFace);
			List<KFace> newFaces = applyRefinements(graph, refinements);
			for (KFace newFace : newFaces)
				faceIter.add(newFace);
		}
		// build the external frame
		KFace oldExternalFace = buildExternalFrame(graph);
		// refine the external face
		List<RefinementEdge> refinements = getRefinements(oldExternalFace);
		List<KFace> newFaces = applyRefinements(graph, refinements);
		graph.faces.addAll(newFaces);
		
		// execute the embedded compacter
		refinedCompacter.reset(getMonitor().subTask(1));
		refinedCompacter.compact(graph, minDist);
		getMonitor().done();
	}

	/**
	 * Creates refinement edges for the given face.
	 * 
	 * @param face face to be processed
	 * @return list of refinement edges
	 */
	private List<RefinementEdge> getRefinements(KFace face) {
		// !! the graph is assumed to be connected here !!
		List<KFace.BorderEntry> border = face.borders.get(0);
		List<RefinementEdge> refinementEdges = new LinkedList<RefinementEdge>();
		
		KFace.BorderEntry currentEntry = border.get(border.size() - 1);
		ListIterator<KFace.BorderEntry> entryIter = border.listIterator();
		while (entryIter.hasNext()) {
			KFace.BorderEntry nextEntry = entryIter.next();
			KNode.Side side1 = currentEntry.secondSide();
			KNode.Side side2 = nextEntry.firstSide();
			if (side1 == side2.left() || side1 == side2) {
				// found a left turn, add refinement edge
				KFace.BorderEntry frontEntry = getFrontEdge(border,
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
							(TSMNode)currentEntry.secondNode(), side1.opposed(),
							frontEdge, true);
					refinementEdge.externalSide = side1.opposed();
					refinementEdges.add(refinementEdge);
				}
				else {
					refinementEdges.add(new RefinementEdge(
							(TSMNode)currentEntry.secondNode(), side1.opposed(),
							(TSMEdge)frontEntry.edge, frontEntry.forward));
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
	private KFace.BorderEntry getFrontEdge(List<KFace.BorderEntry> border,
			int startIndex) {
		ListIterator<KFace.BorderEntry> entryIter = border
				.listIterator(startIndex);
		KFace.BorderEntry currentEntry = entryIter.next();
		int cornerSum = 0;
		while (entryIter.nextIndex() != startIndex) {
			if (!entryIter.hasNext())
				entryIter = border.listIterator();
			KFace.BorderEntry nextEntry = entryIter.next();
			KNode.Side side1 = currentEntry.secondSide();
			KNode.Side side2 = nextEntry.firstSide();
			if (side1 == side2.left())
				cornerSum--;
			else if (side1 == side2.right())
				cornerSum++;
			else if (side1 == side2)
				cornerSum -= 2;
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
	private List<KFace> applyRefinements(KGraph graph,
			List<RefinementEdge> refinements) {
		List<KFace> newFaces = new LinkedList<KFace>();
		for (RefinementEdge refinementEdge : refinements) {
			// look for the right target edge
			while (!containsNode(refinementEdge.targetEdge,
					refinementEdge.targetForward, refinementEdge.source))
				refinementEdge.targetEdge = refinementEdge.targetEdge.nextEdge;
			
			// create new node and insert it into the border
			KNode newNode = new TSMNode(graph, TSMNode.Type.REFINEMENT);
			TSMEdge edge1 = refinementEdge.targetEdge;
			KNode oldNode2;
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
			ListIterator<KNode.IncEntry> oldNode2Iter = oldNode2.getIterator(
					edge1, !refinementEdge.targetForward);
			oldNode2Iter.remove();
			oldNode2Iter.add(new KNode.IncEntry(edge2,
					refinementEdge.targetForward ? KNode.IncEntry.Type.IN
					: KNode.IncEntry.Type.OUT));
			newNode.incidence.add(new KNode.IncEntry(edge1,
					refinementEdge.targetForward ? KNode.IncEntry.Type.IN
							: KNode.IncEntry.Type.OUT));
			newNode.incidence.add(new KNode.IncEntry(edge2,
					refinementEdge.targetForward ? KNode.IncEntry.Type.OUT
							: KNode.IncEntry.Type.IN));
			edge2.sourceSide = edge1.sourceSide;
			edge2.targetSide = edge1.targetSide;
			
			// update links of chains of split edges 
			edge2.nextEdge = edge1.nextEdge;
			if (edge2.nextEdge != null)
				edge2.nextEdge.previousEdge = edge2;
			edge2.previousEdge = edge1;
			edge1.nextEdge = edge2;
			
			// update faces left and right of edge1
			edge2.leftFace = edge1.leftFace;
			edge2.rightFace = edge1.rightFace;
			KFace currentFace = refinementEdge.targetForward
					? edge1.rightFace : edge1.leftFace;
			if (refinementEdge.externalSide == KNode.Side.UNDEFINED
					|| frameConnected) {
				ListIterator<KFace.BorderEntry> currentFaceIter = currentFace 
						.getIterator(edge1, refinementEdge.targetForward);
				currentFaceIter.add(new KFace.BorderEntry(edge2,
						refinementEdge.targetForward));
			}
			KFace opposedFace = refinementEdge.targetForward
					? edge1.leftFace : edge1.rightFace;
			ListIterator<KFace.BorderEntry> opposedFaceIter = opposedFace
					.getIterator(edge1, !refinementEdge.targetForward);
			opposedFaceIter.previous();
			opposedFaceIter.add(new KFace.BorderEntry(edge2,
					!refinementEdge.targetForward));
			
			// insert edge and add new face
			KFace newFace = insertEdge(graph, refinementEdge, currentFace,
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
	private KFace insertEdge(KGraph graph, RefinementEdge refinementEdge,
			KFace face, KNode targetNode, KEdge nextEdge) {
		// add edge to the graph
		KEdge newEdge = new KEdge(graph, refinementEdge.source, targetNode);
		newEdge.connectNodes(refinementEdge.sourceSide,
				refinementEdge.sourceSide.opposed());
		
		if (refinementEdge.externalSide != KNode.Side.UNDEFINED
				&& !frameConnected) {
			// connect the external frame with the contained graph
			ListIterator<KFace.BorderEntry> faceIter = getIteratorFor(face,
					refinementEdge.source, refinementEdge.sourceSide.opposed());
			faceIter.add(new KFace.BorderEntry(newEdge, true));
			faceIter.add(new KFace.BorderEntry(nextEdge, true));
			switch (refinementEdge.externalSide) {
			case NORTH:
				faceIter.add(new KFace.BorderEntry(eastFrame, true));
				faceIter.add(new KFace.BorderEntry(southFrame, true));
				faceIter.add(new KFace.BorderEntry(westFrame, true));
				break;
			case EAST:
				faceIter.add(new KFace.BorderEntry(southFrame, true));
				faceIter.add(new KFace.BorderEntry(westFrame, true));
				faceIter.add(new KFace.BorderEntry(northFrame, true));
				break;
			case SOUTH:
				faceIter.add(new KFace.BorderEntry(westFrame, true));
				faceIter.add(new KFace.BorderEntry(northFrame, true));
				faceIter.add(new KFace.BorderEntry(eastFrame, true));
				break;
			case WEST:
				faceIter.add(new KFace.BorderEntry(northFrame, true));
				faceIter.add(new KFace.BorderEntry(eastFrame, true));
				faceIter.add(new KFace.BorderEntry(southFrame, true));
				break;
			}
			faceIter.add(new KFace.BorderEntry(refinementEdge.targetEdge, true));
			faceIter.add(new KFace.BorderEntry(newEdge, false));
			newEdge.leftFace = face;
			newEdge.rightFace = face;
			frameConnected = true;
			return null;
		}
		else {
			// split the crossed face
			KFace newFace = new KFace(graph, false);
			List<KFace.BorderEntry> newBorder = new LinkedList<KFace.BorderEntry>();
			ListIterator<KFace.BorderEntry> faceIter = getIteratorFor(face,
					refinementEdge.source, refinementEdge.sourceSide.opposed());
			int targetIndex = face.getIterator(refinementEdge.targetEdge,
					refinementEdge.targetForward).nextIndex();
			int nextIndex = faceIter.nextIndex();
			while (nextIndex != targetIndex) {
				if (!faceIter.hasNext()) {
					faceIter = face.borders.get(0).listIterator();
					nextIndex = 0;
				}
				KFace.BorderEntry nextEntry = faceIter.next();
				newBorder.add(new KFace.BorderEntry(nextEntry));
				faceIter.remove();
				if (nextEntry.forward)
					nextEntry.edge.rightFace = newFace;
				else
					nextEntry.edge.leftFace = newFace;
				nextIndex++;
			}
			faceIter.add(new KFace.BorderEntry(newEdge, true));
			newBorder.add(new KFace.BorderEntry(newEdge, false));
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
	private ListIterator<KFace.BorderEntry> getIteratorFor(KFace face,
			KNode node, KNode.Side side) {
		for (List<KFace.BorderEntry> border : face.borders) {
			ListIterator<KFace.BorderEntry> entryIter = border.listIterator();
			while (entryIter.hasNext()) {
				KFace.BorderEntry nextEntry = entryIter.next();
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
	 * Checks whether the face bordered by the given edge contains the given
	 * node.
	 * 
	 * @param edge edge on the border
	 * @param forward indicates whether the edge is forward on the border
	 * @param node node to look up
	 * @return true if the corresponding face contains the node
	 */
	private boolean containsNode(KEdge edge, boolean forward, KNode node) {
		KFace face = forward ? edge.rightFace : edge.leftFace;
		for (List<KFace.BorderEntry> border : face.borders) {
			for (KFace.BorderEntry borderEntry : border) {
				if (borderEntry.edge.source.id == node.id
						|| borderEntry.edge.target.id == node.id)
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Builds the external frame of the refined graph.
	 * 
	 * @param graph graph that is being refined
	 * @return the old external face of the graph
	 */
	private KFace buildExternalFrame(KGraph graph) {
		KFace oldExternal = graph.externalFace;
		KFace newExternal = new KFace(graph, false);
		List<KFace.BorderEntry> newBorder = new LinkedList<KFace.BorderEntry>();
		newExternal.borders.add(newBorder);
		graph.externalFace = newExternal;
		graph.faces.add(oldExternal);
		KNode neNode = new TSMNode(graph, TSMNode.Type.REFINEMENT);
		KNode seNode = new TSMNode(graph, TSMNode.Type.REFINEMENT);
		KNode swNode = new TSMNode(graph, TSMNode.Type.REFINEMENT);
		KNode nwNode = new TSMNode(graph, TSMNode.Type.REFINEMENT);
		northFrame = new TSMEdge(graph, nwNode, neNode);
		northFrame.connectNodes();
		northFrame.leftFace = newExternal;
		northFrame.rightFace = oldExternal;
		northFrame.sourceSide = KNode.Side.EAST;
		northFrame.targetSide = KNode.Side.WEST;
		eastFrame = new TSMEdge(graph, neNode, seNode);
		eastFrame.connectNodes();
		eastFrame.leftFace = newExternal;
		eastFrame.rightFace = oldExternal;
		eastFrame.sourceSide = KNode.Side.SOUTH;
		eastFrame.targetSide = KNode.Side.NORTH;
		southFrame = new TSMEdge(graph, seNode, swNode);
		southFrame.connectNodes();
		southFrame.leftFace = newExternal;
		southFrame.rightFace = oldExternal;
		southFrame.sourceSide = KNode.Side.WEST;
		southFrame.targetSide = KNode.Side.EAST;
		westFrame = new TSMEdge(graph, swNode, nwNode);
		westFrame.connectNodes();
		westFrame.leftFace = newExternal;
		westFrame.rightFace = oldExternal;
		westFrame.sourceSide = KNode.Side.NORTH;
		westFrame.targetSide = KNode.Side.SOUTH;
		newBorder.add(new KFace.BorderEntry(westFrame, false));
		newBorder.add(new KFace.BorderEntry(southFrame, false));
		newBorder.add(new KFace.BorderEntry(eastFrame, false));
		newBorder.add(new KFace.BorderEntry(northFrame, false));
		return oldExternal;
	}

}
