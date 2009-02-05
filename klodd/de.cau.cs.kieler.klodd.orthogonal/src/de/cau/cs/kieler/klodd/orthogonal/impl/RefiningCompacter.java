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
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		refinedCompacter.reset();
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
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.ICompacter#compact(de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph)
	 */
	public void compact(TSMGraph graph) {
		// refine the internal faces
		ListIterator<TSMFace> faceIter = graph.faces.listIterator();
		while (faceIter.hasNext()) {
			TSMFace nextFace = faceIter.next();
			List<RefinementEdge> refinements = getRefinements(nextFace);
			List<TSMFace> newFaces = applyRefinements(graph, refinements, false);
			for (TSMFace newFace : newFaces)
				faceIter.add(newFace);
		}
		// build the external frame
		TSMFace oldExternalFace = buildExternalFrame(graph);
		// refine the external face
		List<RefinementEdge> refinements = getRefinements(oldExternalFace);
		List<TSMFace> newFaces = applyRefinements(graph, refinements, true);
		graph.faces.addAll(newFaces);
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
						entryIter.previousIndex() < 0 ? border.size() - 1
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
					refinementEdges.add(new RefinementEdge(
							currentEntry.secondNode(), side1.opposed(),
							frontEdge, true));
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
	 * @param external indicates whether the former external face is
	 *     processed
	 * @return list of newly created faces
	 */
	private List<TSMFace> applyRefinements(TSMGraph graph,
			List<RefinementEdge> refinements, boolean external) {
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
		return oldExternal;
	}

}
