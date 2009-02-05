package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.core.util.Pair;
import de.cau.cs.kieler.klodd.orthogonal.modules.ICompacter;
import de.cau.cs.kieler.klodd.orthogonal.structures.*;

/**
 * Compacter implementation that normalizes the graph and executes
 * another compacter for normalized orthogonal representations.
 * 
 * @author msp
 */
public class NormalizingCompacter extends AbstractAlgorithm implements
		ICompacter {

	/** the embedded compacter for normalized orthogonal representations */
	private ICompacter normalizedCompacter;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		normalizedCompacter.reset();
	}
	
	/**
	 * Creates a normalizing compacter based on the given compacter,
	 * which should work on a normalized orthogonal representation.
	 * 
	 * @param normalizedCompacter compacter that expects a normalized
	 *     orthogonal representation
	 */
	public NormalizingCompacter(ICompacter normalizedCompacter) {
		this.normalizedCompacter = normalizedCompacter;
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.ICompacter#compact(de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph)
	 */
	public void compact(TSMGraph graph) {
		// create a normalized version of the input graph
		TSMGraph normalizedGraph = createNormalizedGraph(graph);
		// execute the embedded compacter
		normalizedCompacter.compact(normalizedGraph);
		// transform abstract metrics to concrete metrics
		transformMetrics(graph, normalizedGraph);
	}
	
	/**
	 * Descriptor class for ports.
	 */
	private class PortDescriptor {
		/** list of dummy nodes that were created for the related port */
		List<TSMNode> nodes = new LinkedList<TSMNode>();
		/** number of edges going left */
		int leftEdges = 0;
		/** number of edges without bends */
		int straightEdges = 0;
		/** number of edges going right */
		int rightEdges = 0;
	}
	
	/**
	 * Creates a normalized version of the input graph.
	 * 
	 * @param inputGraph graph with orthogonal representation
	 * @return new graph with normalized orthogonal representation
	 */
	private TSMGraph createNormalizedGraph(TSMGraph inputGraph) {
		TSMGraph normalizedGraph = new TSMGraph();
		Map<Object, PortDescriptor> portMap = new HashMap<Object, PortDescriptor>();
		int[] sourceRank = new int[inputGraph.edges.size()];
		int[] targetRank = new int[inputGraph.edges.size()];
		
		// process the nodes of the graph 
		for (TSMNode node : inputGraph.nodes) {
			if (node.type == TSMNode.Type.LAYOUT) {
				TSMNode.Side currentSide = TSMNode.Side.UNDEFINED;
				TSMNode currentNode = null;
				TSMNode.Side startingSide = TSMNode.Side.UNDEFINED;
				TSMNode startingNode = null;
				int edgeRank = 0;
				for (TSMNode.IncEntry edgeEntry : node.incidence) {
					KLayoutPort port = (edgeEntry.type == TSMNode.IncEntry.Type.OUT
							? edgeEntry.edge.layoutEdge.getSourcePort()
							: edgeEntry.edge.layoutEdge.getTargetPort());
					PortDescriptor portDescriptor = portMap.get(port);
					
					// create dummy nodes for ports and corners
					if (portDescriptor == null) {
						edgeRank = 0;
						TSMNode.Side newSide = edgeEntry.side();
						TSMNode newNode = new TSMNode(normalizedGraph,
								TSMNode.Type.NORM_PORT, port);
						if (startingSide == TSMNode.Side.UNDEFINED) {
							startingSide = newSide;
							startingNode = newNode;
						}
						else {
							if (edgeEntry.isFirstEdge())
								currentNode = addCornerNodes(normalizedGraph,
										currentNode, node, currentSide, newSide);
							TSMEdge newEdge = new TSMEdge(normalizedGraph,
									currentNode, newNode);
							newEdge.connectNodes();
							newEdge.sourceSide = newSide.right();
							newEdge.targetSide = newEdge.sourceSide.opposed();
						}
						portDescriptor = new PortDescriptor();
						portDescriptor.nodes.add(newNode);
						portMap.put(port, portDescriptor);
						currentNode = newNode;
						currentSide = newSide;
					}
					
					// count the number of edges going left and right
					List<TSMEdge.Bend> bends = edgeEntry.edge.bends;
					if (bends.isEmpty())
						portDescriptor.straightEdges++;
					else {
						if (edgeEntry.type == TSMNode.IncEntry.Type.OUT
								&& bends.get(0).type == TSMEdge.Bend.Type.LEFT
								|| edgeEntry.type == TSMNode.IncEntry.Type.IN
								&& bends.get(bends.size()-1).type == TSMEdge.Bend.Type.RIGHT)
							portDescriptor.leftEdges++;
						else
							portDescriptor.rightEdges++;
					}
					
					// determine the port rank of the current edge
					if (edgeEntry.type == TSMNode.IncEntry.Type.OUT)
						sourceRank[edgeEntry.edge.id] = edgeRank;
					else
						targetRank[edgeEntry.edge.id] = edgeRank;
					edgeRank++;
				}
				
				// add remaining corners
				if (startingSide != currentSide) {
					currentNode = addCornerNodes(normalizedGraph,
							currentNode, node, currentSide, startingSide);
				}
				if (startingNode != null) {
					TSMEdge newEdge = new TSMEdge(normalizedGraph,
							currentNode, startingNode);
					newEdge.connectNodes();
					newEdge.sourceSide = startingSide.right();
					newEdge.targetSide = newEdge.sourceSide.opposed();
				}
			}
			else if (node.type == TSMNode.Type.CROSSING) {
				// handle dummy nodes of edge crossings
				TSMNode dummyNode = new TSMNode(normalizedGraph,
						TSMNode.Type.CROSSING, node);
				PortDescriptor portDescriptor = new PortDescriptor();
				portDescriptor.nodes.add(dummyNode);
				portMap.put(node, portDescriptor);
			}
			else assert false;
		}
		
		// process the edges of the graph
		for (TSMEdge edge : inputGraph.edges) {
			// determine attachment point at source
			TSMNode currentNode = null, targetNode = null;
			boolean sourceBendConsumed = false, targetBendConsumed = false;
			if (edge.source.type == TSMNode.Type.LAYOUT) {
				PortDescriptor portDescriptor = portMap.get(edge
						.layoutEdge.getSourcePort());
				Pair<TSMNode, Boolean> endpointResult = getEndpointNode(
						normalizedGraph, edge, portDescriptor,
						sourceRank[edge.id], true);
				currentNode = endpointResult.first;
				sourceBendConsumed = endpointResult.second;
			}
			else if (edge.source.type == TSMNode.Type.CROSSING) {
				PortDescriptor portDescriptor = portMap.get(edge.source);
				currentNode = portDescriptor.nodes.get(0);
			}
			
			// determine attachment point at target
			if (edge.target.type == TSMNode.Type.LAYOUT) {
				PortDescriptor portDescriptor = portMap.get(edge
						.layoutEdge.getTargetPort());
				Pair<TSMNode, Boolean> endpointResult = getEndpointNode(
						normalizedGraph, edge, portDescriptor,
						targetRank[edge.id], false);
				targetNode = endpointResult.first;
				targetBendConsumed = endpointResult.second;
			}
			else if (edge.target.type == TSMNode.Type.CROSSING) {
				PortDescriptor portDescriptor = portMap.get(edge.target);
				targetNode = portDescriptor.nodes.get(0);
			}
			
			// create dummy nodes for remaining bends
			TSMNode.Side currentSide = (sourceBendConsumed
					? (edge.bends.get(0).type == TSMEdge.Bend.Type.LEFT
					? edge.sourceSide.left()
					: edge.sourceSide.right())
					: edge.sourceSide);
			ListIterator<TSMEdge.Bend> bendIter = edge.bends.listIterator();
			if (sourceBendConsumed)
				bendIter.next();
			int targetIndex = targetBendConsumed ? edge.bends.size() - 1
					: edge.bends.size();
			while (bendIter.nextIndex() < targetIndex) {
				TSMEdge.Bend bend = bendIter.next();
				TSMNode newNode = new TSMNode(normalizedGraph,
						TSMNode.Type.BEND, edge);
				TSMEdge newEdge = new TSMEdge(normalizedGraph,
						currentNode, newNode, edge.layoutEdge);
				newEdge.connectNodes();
				newEdge.sourceSide = currentSide;
				newEdge.targetSide = currentSide.opposed();
				currentNode = newNode;
				currentSide = (bend.type == TSMEdge.Bend.Type.LEFT
						? currentSide.left() : currentSide.right());
			}
			TSMEdge newEdge = new TSMEdge(normalizedGraph,
					currentNode, targetNode, edge.layoutEdge);
			newEdge.connectNodes();
			newEdge.sourceSide = currentSide;
			newEdge.targetSide = currentSide.opposed();
		}
		
		return normalizedGraph;
	}
	
	/**
	 * Adds dummy nodes for all corners between the start side and
	 * the end side.
	 * 
	 * @param graph graph to which new nodes are added
	 * @param currentNode node to which the first new node is connected
	 * @param origNode the original node for which dummy nodes are created
	 * @param startSide start side of the original node
	 * @param endSide end side of the original node
	 * @return the last newly created node
	 */
	private TSMNode addCornerNodes(TSMGraph graph, TSMNode currentNode,
			TSMNode origNode, TSMNode.Side startSide, TSMNode.Side endSide) {
		TSMNode.Side currentSide = startSide;
		TSMNode newNode;
		TSMEdge newEdge;
		do {
			TSMNode.Type cornerType;
			switch (currentSide) {
			case NORTH:
				cornerType = TSMNode.Type.NORM_NE;
				break;
			case EAST:
				cornerType = TSMNode.Type.NORM_SE;
				break;
			case SOUTH:
				cornerType = TSMNode.Type.NORM_SW;
				break;
			case WEST:
				cornerType = TSMNode.Type.NORM_NW;
				break;
			default:
				throw new IllegalStateException("Illegal value: " + currentSide);
			}
			newNode = new TSMNode(graph, cornerType, origNode);
			newEdge = new TSMEdge(graph, currentNode, newNode);
			newEdge.connectNodes();
			newEdge.sourceSide = currentSide.right();
			newEdge.targetSide = newEdge.sourceSide.opposed();
			currentNode = newNode;
			currentSide = currentSide.right();
		} while (currentSide != endSide);
		return currentNode;
	}
	
	/**
	 * Determines a node to attach the endpoint of an edge.
	 * 
	 * @param graph the graph to which new nodes and edges are added
	 * @param edge the edge to be attached.
	 * @param portDescriptor port descriptor for the endpoint
	 * @param rank rank of the given edge inside its port
	 * @param source if true, the source endpoint is attached, else
	 *     the target endpoint is attached
	 * @return a node that can be used to attach the rest of the edge,
	 *     and a boolean value showing whether the edge bend at the
	 *     endpoint was consumed
	 */
	private Pair<TSMNode, Boolean> getEndpointNode(TSMGraph graph,
			TSMEdge edge, PortDescriptor portDescriptor, int rank,
			boolean source) {
		int nodeIndex;
		boolean bendConsumed = false;
		// TODO try to achieve a better merging of edges of the same port
		if (edge.bends.isEmpty())
			nodeIndex = Math.max(portDescriptor.leftEdges,
					portDescriptor.rightEdges);
		else if (source && edge.bends.get(0).type == TSMEdge.Bend.Type.LEFT
				|| !source && edge.bends.get(edge.bends.size() - 1).type
				== TSMEdge.Bend.Type.RIGHT)
			nodeIndex = rank + 1;
		else
			nodeIndex = portDescriptor.leftEdges + portDescriptor.straightEdges
					+ portDescriptor.rightEdges - rank;
		if (edge.bends.size() == 1 && nodeIndex == Math.max(
				portDescriptor.leftEdges, portDescriptor.rightEdges)
				&& portDescriptor.leftEdges != portDescriptor.rightEdges)
			nodeIndex--;
		else
			bendConsumed = true;
		
		// add new nodes if needed
		for (int i = portDescriptor.nodes.size() - 1; i < nodeIndex; i++) {
			TSMNode newNode = new TSMNode(graph, TSMNode.Type.BEND, edge);
			TSMEdge newEdge = new TSMEdge(graph, portDescriptor.nodes.get(i),
					newNode, edge.layoutEdge);
			newEdge.connectNodes();
			newEdge.sourceSide = source ? edge.sourceSide : edge.targetSide;
			newEdge.targetSide = newEdge.sourceSide.opposed();
			portDescriptor.nodes.add(newNode);
		}
		return new Pair<TSMNode, Boolean>(portDescriptor.nodes.get(nodeIndex),
				new Boolean(bendConsumed));
	}
	
	/**
	 * Transforms the abstract metrics of the normalized graph to concrete
	 * metrics of the original graph.
	 * 
	 * @param origGraph the original graph
	 * @param normalizedGraph the normalized graph
	 */
	private void transformMetrics(TSMGraph origGraph, TSMGraph normalizedGraph) {
		// TODO transform metrics
	}

}
