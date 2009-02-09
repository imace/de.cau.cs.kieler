package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.core.util.Pair;
import de.cau.cs.kieler.klodd.orthogonal.impl.DualGraphBuilder.ExternalFaceDetector;
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
	/** mapping of nodes or edge bends to their first normalization node */
	private Map<Object, TSMNode> startNodeMap = new HashMap<Object, TSMNode>();
	/** mapping of nodes to their last normalization node (lower right corner) */
	private Map<Object, TSMNode> endNodeMap = new HashMap<Object, TSMNode>();
	/** minimal distance between elements */
	private float minDist;
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		normalizedCompacter.reset();
		startNodeMap.clear();
		endNodeMap.clear();
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
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.orthogonal.modules.ICompacter#compact(de.cau.cs.kieler.klodd.orthogonal.structures.TSMGraph, float)
	 */
	public void compact(TSMGraph graph, float minDist) {
		this.minDist = minDist;
		// create a normalized version of the input graph
		TSMGraph normalizedGraph = createNormalizedGraph(graph);
		// build dual graph for the normalized graph
		buildDualGraph(normalizedGraph);
		// execute the embedded compacter
		normalizedCompacter.compact(normalizedGraph, minDist);
		// transform abstract metrics to concrete metrics
		transformMetrics(graph);
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
							newEdge.connectNodes(newSide.right(), newSide.left());
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
					newEdge.connectNodes(startingSide.right(), startingSide.left());
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
				// add the new node for normalization
				TSMEdge.Bend bend = bendIter.next();
				TSMNode newNode = new TSMNode(normalizedGraph,
						TSMNode.Type.BEND, edge);
				TSMEdge newEdge = new TSMEdge(normalizedGraph,
						currentNode, newNode, edge.layoutEdge);
				newEdge.connectNodes(currentSide, currentSide.opposed());
				
				// register the new node
				startNodeMap.put(bend, newNode);
				
				currentNode = newNode;
				currentSide = (bend.type == TSMEdge.Bend.Type.LEFT
						? currentSide.left() : currentSide.right());
			}
			TSMEdge newEdge = new TSMEdge(normalizedGraph,
					currentNode, targetNode, edge.layoutEdge);
			newEdge.connectNodes(currentSide, currentSide.opposed());
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
			// add the new node and a new edge
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
			newEdge.connectNodes(currentSide.right(), currentSide.left());
			
			// register the new normalization node
			switch (cornerType) {
			case NORM_NW:
				startNodeMap.put(origNode, newNode);
				break;
			case NORM_SE:
				endNodeMap.put(origNode, newNode);
				break;
			}
			
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
			TSMNode.Side newSide = source ? edge.sourceSide : edge.targetSide;
			newEdge.connectNodes(newSide, newSide.opposed());
			portDescriptor.nodes.add(newNode);
		}
		return new Pair<TSMNode, Boolean>(portDescriptor.nodes.get(nodeIndex),
				new Boolean(bendConsumed));
	}
	
	/**
	 * Builds the dual graph of the given normalized graph using
	 * a dual graph builder algorithm.
	 * 
	 * @param normalizedGraph normalized graph to process
	 */
	private void buildDualGraph(TSMGraph normalizedGraph) {
		DualGraphBuilder dualGraphBuilder = new DualGraphBuilder();
		dualGraphBuilder.buildDual(normalizedGraph, new ExternalFaceDetector() {
			public boolean isExternal(List<TSMFace.BorderEntry> border) {
				int cornerSum = 0;
				TSMFace.BorderEntry currentEntry = border.get(border.size() - 1);
				for (TSMFace.BorderEntry nextEntry : border) {
					TSMNode.Side side1 = currentEntry.secondSide();
					TSMNode.Side side2 = nextEntry.firstSide();
					if (side1 == side2.left())
						cornerSum--;
					else if (side1 == side2.right())
						cornerSum++;
					currentEntry = nextEntry;
				}
				return cornerSum == -4;
			}
		});
	}
	
	/**
	 * Transforms the abstract metrics of the normalized graph to concrete
	 * metrics of the original graph.
	 * 
	 * @param origGraph the original graph
	 */
	private void transformMetrics(TSMGraph origGraph) {
		// create pool of nodes and edge bends
		List<Object> compactables = new LinkedList<Object>();
		compactables.addAll(origGraph.nodes);
		for (TSMEdge edge : origGraph.edges) {
			ListIterator<TSMEdge.Bend> bendIter = edge.bends.listIterator(1);
			while (bendIter.nextIndex() < edge.bends.size() - 1)
				compactables.add(bendIter.next());
		}
		
		// transform horizontal positions
		origGraph.width = transformMetrics(compactables, origGraph, true);
		// transform vertical positions
		origGraph.height = transformMetrics(compactables, origGraph, false);
		
		// set proper coordinates for the first and the last bend of each edge
		for (TSMEdge edge : origGraph.edges) {
			int bendsCount = edge.bends.size();
			if (bendsCount > 0) {
				// set source bend
				TSMEdge.Bend sourceBend = edge.bends.get(0);
				if (edge.sourceSide == TSMNode.Side.NORTH
						|| edge.sourceSide == TSMNode.Side.SOUTH) {
					sourceBend.xpos = edge.source.concrXpos;
					if (edge.source.type == TSMNode.Type.LAYOUT
							&& edge.layoutEdge.getSourcePort() != null) {
						KPortLayout portLayout = edge.layoutEdge.getSourcePort().getLayout();
						sourceBend.xpos += portLayout.getLocation().getX()
								+ portLayout.getSize().getWidth() / 2;
					}
					if (bendsCount > 1)
						sourceBend.ypos = edge.bends.get(1).ypos;
				}
				else {
					sourceBend.ypos = edge.source.concrYpos;
					if (edge.source.type == TSMNode.Type.LAYOUT
							&& edge.layoutEdge.getSourcePort() != null) {
						KPortLayout portLayout = edge.layoutEdge.getSourcePort().getLayout();
						sourceBend.ypos += portLayout.getLocation().getY()
								+ portLayout.getSize().getHeight() / 2;
					}
					if (bendsCount > 1)
						sourceBend.xpos = edge.bends.get(1).xpos;
				}
				
				// set target bend
				TSMEdge.Bend targetBend = edge.bends.get(bendsCount - 1);
				if (edge.targetSide == TSMNode.Side.EAST
						|| edge.targetSide == TSMNode.Side.WEST) {
					targetBend.ypos = edge.target.concrYpos;
					if (edge.target.type == TSMNode.Type.LAYOUT
							&& edge.layoutEdge.getTargetPort() != null) {
						KPortLayout portLayout = edge.layoutEdge.getTargetPort().getLayout();
						targetBend.ypos += portLayout.getLocation().getY()
								+ portLayout.getSize().getHeight() / 2;
					}
					if (bendsCount > 1)
						sourceBend.xpos = edge.bends.get(bendsCount-2).xpos;
				}
				else {
					targetBend.xpos = edge.target.concrXpos;
					if (edge.target.type == TSMNode.Type.LAYOUT
							&& edge.layoutEdge.getTargetPort() != null) {
						KPortLayout portLayout = edge.layoutEdge.getTargetPort().getLayout();
						targetBend.xpos += portLayout.getLocation().getX()
								+ portLayout.getSize().getWidth() / 2;
					}
					if (bendsCount > 1)
						sourceBend.ypos = edge.bends.get(bendsCount-2).ypos;
				}
			}
		}
	}
	
	/**
	 * Transforms horizontal or vertical metrics for a given list of
	 * compactable elements.
	 * 
	 * @param compactables list of compactable elements, i.e. nodes or
	 *     edge bends
	 * @param graph the original graph
	 * @param horizontal indicates whether horizontal or vertical compaction
	 *     is performed
	 * @return the total width or height of the graph
	 */
	private float transformMetrics(List<Object> compactables, TSMGraph graph,
			final boolean horizontal) {
		// sort compactable elements by their abstract position
		Collections.sort(compactables, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				int pos1 = getPos(o1, true);
				int pos2 = getPos(o2, true);
				if (pos1 == pos2) {
					int lastpos1 = getPos(o1, false);
					int lastpos2 = getPos(o2, false);
					return lastpos2 - lastpos1;
				}
				else
					return pos1 - pos2;
			}
			/*
			 * Returns the abstract position of a node or edge bend.
			 * @param obj node or an edge bend transformed into a normalized node
			 * @param first if true, the first position of a node is returned,
			 *     which is the position of the upper left corner
			 * @return abstract position, or -1 if the last position of a bend
			 *     is requested
			 */
			int getPos(Object obj, boolean first) {
				if (first)
					return horizontal ? startNodeMap.get(obj).abstrXpos
							: startNodeMap.get(obj).abstrYpos;
				else if (obj instanceof TSMNode)
					return horizontal ? endNodeMap.get(obj).abstrXpos
							: endNodeMap.get(obj).abstrYpos;
				else return -1;
			}
		});
		
		// initialize concrete positions array
		int abstrSize = horizontal ? (int)graph.width : (int)graph.height;
		float[] concrPos = new float[abstrSize];
		for (int i = 1; i < abstrSize; i++)
			concrPos[i] = -1;
		
		// set concrete positions for all compactable elements
		int lastPos = 0;
		for (Object obj : compactables) {
			int abstrPos = horizontal ? startNodeMap.get(obj).abstrXpos
					: startNodeMap.get(obj).abstrYpos;
			if (abstrPos > lastPos) {
				int lastWrittenPos = abstrPos - 1;
				while (concrPos[lastWrittenPos] < 0)
					lastWrittenPos--;
				if (concrPos[abstrPos] < concrPos[lastWrittenPos] + minDist)
					concrPos[abstrPos] = concrPos[lastWrittenPos] + minDist;
				lastPos = abstrPos;
			}
			if (obj instanceof TSMNode) {
				TSMNode node = (TSMNode)obj;
				if (node.type == TSMNode.Type.LAYOUT) {
					int endPos = horizontal ? endNodeMap.get(obj).abstrXpos
							: endNodeMap.get(obj).abstrYpos;
					KLayoutNode layoutNode = (KLayoutNode)node.object;
					float size = horizontal ? layoutNode.getLayout().getSize().getWidth()
							: layoutNode.getLayout().getSize().getHeight();
					assert endPos - abstrPos > 0;
					float stepSize = size / (endPos - abstrPos);
					float currentStep = concrPos[abstrPos];
					for (int i = abstrPos + 1; i <= endPos; i++) {
						currentStep += stepSize;
						concrPos[i] = Math.max(concrPos[i], currentStep);
					}
				}
				if (horizontal)
					node.concrXpos = concrPos[abstrPos];
				else
					node.concrYpos = concrPos[abstrPos];
			}
			else if (obj instanceof TSMEdge.Bend) {
				TSMEdge.Bend edgeBend = (TSMEdge.Bend)obj;
				if (horizontal)
					edgeBend.xpos = concrPos[abstrPos];
				else
					edgeBend.ypos = concrPos[abstrPos];
			}
		}
		
		// determine total size
		for (int i = abstrSize - 1; i >= 0; i--) {
			if (concrPos[i] > 0)
				return concrPos[i] + minDist;
		}
		return 0.0f;
	}

}
