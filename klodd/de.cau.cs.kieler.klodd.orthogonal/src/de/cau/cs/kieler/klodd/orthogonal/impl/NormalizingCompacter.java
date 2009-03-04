package de.cau.cs.kieler.klodd.orthogonal.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.graph.KEdge;
import de.cau.cs.kieler.core.graph.KFace;
import de.cau.cs.kieler.core.graph.KGraph;
import de.cau.cs.kieler.core.graph.KNode;
import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout;
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
	public void compact(KGraph graph, float minDist) {
		getMonitor().begin("Normalizing compaction", 1);
		
		this.minDist = minDist;
		// create a normalized version of the input graph
		KGraph normalizedGraph = createNormalizedGraph(graph);
		// build dual graph for the normalized graph
		buildDualGraph(normalizedGraph);
		// execute the embedded compacter
		normalizedCompacter.reset(getMonitor().subTask(1));
		normalizedCompacter.compact(normalizedGraph, minDist);
		// transform abstract metrics to concrete metrics
		transformMetrics(graph, (int)normalizedGraph.width,
				(int)normalizedGraph.height);
		
		getMonitor().done();
	}
	
	/**
	 * Descriptor class for ports.
	 */
	private static class PortDescriptor {
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
	private KGraph createNormalizedGraph(KGraph inputGraph) {
		KGraph normalizedGraph = new KGraph();
		Map<Object, PortDescriptor> portMap = new HashMap<Object, PortDescriptor>();
		int[] sourceRank = new int[inputGraph.edges.size()];
		int[] targetRank = new int[inputGraph.edges.size()];
		
		// process the nodes of the graph 
		for (KNode node : inputGraph.nodes) {
			TSMNode tsmNode = (TSMNode)node;
			if (tsmNode.type == TSMNode.Type.LAYOUT) {
				KNode.Side currentSide = KNode.Side.UNDEFINED;
				TSMNode currentNode = null;
				KNode.Side startingSide = KNode.Side.UNDEFINED;
				boolean changedSide = false;
				KNode startingNode = null;
				int edgeRank = 0;
				for (KNode.IncEntry edgeEntry : node.incidence) {
					KLayoutPort port = (edgeEntry.type == KNode.IncEntry.Type.OUT
							? ((TSMEdge)edgeEntry.edge).layoutEdge.getSourcePort()
							: ((TSMEdge)edgeEntry.edge).layoutEdge.getTargetPort());
					PortDescriptor portDescriptor = portMap.get(port);
					
					// create dummy nodes for ports and corners
					if (portDescriptor == null) {
						edgeRank = 0;
						KNode.Side newSide = edgeEntry.side();
						TSMNode newNode = new TSMNode(normalizedGraph,
								TSMNode.Type.NORM_PORT, port);
						if (startingSide == KNode.Side.UNDEFINED) {
							startingSide = newSide;
							startingNode = newNode;
						}
						else {
							if (currentSide != newSide) {
								currentNode = addCornerNodes(normalizedGraph,
										currentNode, (TSMNode)node,
										currentSide, newSide);
								changedSide = true;
							}
							KEdge newEdge = new KEdge(normalizedGraph,
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
					List<KEdge.Bend> bends = edgeEntry.edge.bends;
					if (bends.isEmpty())
						portDescriptor.straightEdges++;
					else {
						if (edgeEntry.type == KNode.IncEntry.Type.OUT
								&& bends.get(0).type == KEdge.Bend.Type.LEFT
								|| edgeEntry.type == KNode.IncEntry.Type.IN
								&& bends.get(bends.size()-1).type == KEdge.Bend.Type.RIGHT)
							portDescriptor.leftEdges++;
						else
							portDescriptor.rightEdges++;
					}
					
					// determine the port rank of the current edge
					if (edgeEntry.type == KNode.IncEntry.Type.OUT)
						sourceRank[edgeEntry.edge.id] = edgeRank;
					else
						targetRank[edgeEntry.edge.id] = edgeRank;
					edgeRank++;
				}
				
				// add remaining corners
				if (currentSide == KNode.Side.UNDEFINED) {
					currentSide = KNode.Side.NORTH;
					startingSide = currentSide;
				}
				if (startingSide != currentSide || !changedSide) {
					currentNode = addCornerNodes(normalizedGraph,
							currentNode, (TSMNode)node, currentSide, startingSide);
				}
				if (startingNode != null) {
					KEdge newEdge = new KEdge(normalizedGraph,
							currentNode, startingNode);
					newEdge.connectNodes(startingSide.right(), startingSide.left());
				}
			}
			else if (tsmNode.type == TSMNode.Type.CROSSING) {
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
		for (KEdge edge : inputGraph.edges) {
			TSMEdge tsmEdge = (TSMEdge)edge;
			// determine attachment point at source
			TSMNode currentNode = null, targetNode = null;
			boolean sourceBendConsumed = false, targetBendConsumed = false;
			if (((TSMNode)edge.source).type == TSMNode.Type.LAYOUT) {
				PortDescriptor portDescriptor = portMap.get(tsmEdge
						.layoutEdge.getSourcePort());
				Pair<TSMNode, Boolean> endpointResult = getEndpointNode(
						normalizedGraph, edge, portDescriptor,
						sourceRank[edge.id], true);
				currentNode = (TSMNode)endpointResult.first;
				sourceBendConsumed = endpointResult.second;
			}
			else if (((TSMNode)edge.source).type == TSMNode.Type.CROSSING) {
				PortDescriptor portDescriptor = portMap.get(edge.source);
				currentNode = (TSMNode)portDescriptor.nodes.get(0);
			}
			// register the new node
			if (sourceBendConsumed)
				startNodeMap.put(edge.bends.get(0), currentNode);
			
			// determine attachment point at target
			if (((TSMNode)edge.target).type == TSMNode.Type.LAYOUT) {
				PortDescriptor portDescriptor = portMap.get(tsmEdge
						.layoutEdge.getTargetPort());
				Pair<TSMNode, Boolean> endpointResult = getEndpointNode(
						normalizedGraph, edge, portDescriptor,
						targetRank[edge.id], false);
				targetNode = endpointResult.first;
				targetBendConsumed = endpointResult.second;
			}
			else if (((TSMNode)edge.target).type == TSMNode.Type.CROSSING) {
				PortDescriptor portDescriptor = portMap.get(edge.target);
				targetNode = portDescriptor.nodes.get(0);
			}
			// register the new node
			if (targetBendConsumed)
				startNodeMap.put(edge.bends.get(edge.bends.size() - 1),
						targetNode);
			
			// create dummy nodes for remaining bends
			KNode.Side currentSide = (sourceBendConsumed
					? (edge.bends.get(0).type == KEdge.Bend.Type.LEFT
					? edge.sourceSide.left()
					: edge.sourceSide.right())
					: edge.sourceSide);
			ListIterator<KEdge.Bend> bendIter = edge.bends.listIterator();
			if (sourceBendConsumed)
				bendIter.next();
			int targetIndex = targetBendConsumed ? edge.bends.size() - 1
					: edge.bends.size();
			while (bendIter.nextIndex() < targetIndex) {
				// add the new node for normalization
				KEdge.Bend bend = bendIter.next();
				TSMNode newNode = new TSMNode(normalizedGraph,
						TSMNode.Type.BEND, edge);
				KEdge newEdge = new TSMEdge(normalizedGraph,
						currentNode, newNode, tsmEdge.layoutEdge);
				newEdge.connectNodes(currentSide, currentSide.opposed());
				
				// register the new node
				startNodeMap.put(bend, newNode);
				
				currentNode = newNode;
				currentSide = (bend.type == KEdge.Bend.Type.LEFT
						? currentSide.left() : currentSide.right());
			}
			KEdge newEdge = new TSMEdge(normalizedGraph,
					currentNode, targetNode, tsmEdge.layoutEdge);
			newEdge.connectNodes(currentSide, currentSide.opposed());
		}
		
		return normalizedGraph;
	}
	
	/**
	 * Adds dummy nodes for all corners between the start side and
	 * the end side.
	 * 
	 * @param graph graph to which new nodes are added
	 * @param currentNode node to which the first new node is connected,
	 *     or null if no normalization node was built for the given node
	 * @param origNode the original node for which dummy nodes are created
	 * @param startSide start side of the original node
	 * @param endSide end side of the original node
	 * @return the last newly created node
	 */
	private TSMNode addCornerNodes(KGraph graph, TSMNode currentNode,
			TSMNode origNode, KNode.Side startSide, KNode.Side endSide) {
		KNode.Side currentSide = startSide;
		TSMNode newNode, startNode = null;
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
			if (currentNode == null)
				startNode = currentNode;
			else {
				KEdge newEdge = new TSMEdge(graph, currentNode, newNode);
				newEdge.connectNodes(currentSide.right(), currentSide.left());
			}
			
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
		if (startNode != null) {
			KEdge newEdge = new KEdge(graph, currentNode, startNode);
			newEdge.connectNodes(currentSide.left(), currentSide.opposed());
		}
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
	private Pair<TSMNode, Boolean> getEndpointNode(KGraph graph,
			KEdge edge, PortDescriptor portDescriptor, int rank,
			boolean source) {
		int nodeIndex;
		boolean bendConsumed = false;
		// TODO try to achieve a better merging of edges of the same port
		if (edge.bends.isEmpty())
			nodeIndex = Math.max(portDescriptor.leftEdges,
					portDescriptor.rightEdges);
		else if (source && edge.bends.get(0).type == KEdge.Bend.Type.LEFT
				|| !source && edge.bends.get(edge.bends.size() - 1).type
				== KEdge.Bend.Type.RIGHT)
			nodeIndex = rank + 1;
		else
			nodeIndex = portDescriptor.leftEdges + portDescriptor.straightEdges
					+ portDescriptor.rightEdges - rank;
		
		if (edge.bends.size() == 1 && nodeIndex == Math.max(
				portDescriptor.leftEdges, portDescriptor.rightEdges)
				&& portDescriptor.leftEdges != portDescriptor.rightEdges)
			nodeIndex--;
		else if (!edge.bends.isEmpty())
			bendConsumed = true;
		
		// add new nodes if needed
		for (int i = portDescriptor.nodes.size() - 1; i < nodeIndex; i++) {
			TSMNode newNode = new TSMNode(graph, TSMNode.Type.BEND, edge);
			KEdge newEdge = new TSMEdge(graph, portDescriptor.nodes.get(i),
					newNode, ((TSMEdge)edge).layoutEdge);
			KNode.Side newSide = source ? edge.sourceSide : edge.targetSide;
			newEdge.connectNodes(newSide, newSide.opposed());
			portDescriptor.nodes.add(newNode);
		}
		return new Pair<TSMNode, Boolean>(portDescriptor.nodes.get(nodeIndex),
				Boolean.valueOf(bendConsumed));
	}
	
	/**
	 * Builds the dual graph of the given normalized graph using
	 * a dual graph builder algorithm.
	 * 
	 * @param normalizedGraph normalized graph to process
	 */
	private void buildDualGraph(KGraph normalizedGraph) {
		DualGraphBuilder dualGraphBuilder = new DualGraphBuilder();
		dualGraphBuilder.buildDual(normalizedGraph, new ExternalFaceDetector() {
			public boolean isExternal(List<KFace.BorderEntry> border) {
				int cornerSum = 0;
				KFace.BorderEntry currentEntry = border.get(border.size() - 1);
				for (KFace.BorderEntry nextEntry : border) {
					KNode.Side side1 = currentEntry.secondSide();
					KNode.Side side2 = nextEntry.firstSide();
					if (side1 == side2.left())
						cornerSum--;
					else if (side1 == side2.right())
						cornerSum++;
					else if (side1 == side2)
						cornerSum -= 2;
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
	private void transformMetrics(KGraph origGraph, int abstrWidth,
			int abstrHeight) {
		// create pool of nodes and edge bends
		List<Object> compactables = new LinkedList<Object>();
		compactables.addAll(origGraph.nodes);
		for (KEdge edge : origGraph.edges) {
			compactables.addAll(edge.bends);
		}
		
		// transform horizontal positions
		origGraph.width = transformMetrics(compactables, origGraph, true,
				abstrWidth);
		// transform vertical positions
		origGraph.height = transformMetrics(compactables, origGraph, false,
				abstrHeight);
		
		// set proper coordinates for the first and the last bend of each edge
		for (KEdge edge : origGraph.edges) {
			int bendsCount = edge.bends.size();
			if (bendsCount > 0) {
				TSMEdge tsmEdge = (TSMEdge)edge;
				// set source bend
				KEdge.Bend sourceBend = edge.bends.get(0);
				if (edge.sourceSide == KNode.Side.NORTH
						|| edge.sourceSide == KNode.Side.SOUTH) {
					sourceBend.xpos = edge.source.xpos;
					if (((TSMNode)edge.source).type == TSMNode.Type.LAYOUT
							&& tsmEdge.layoutEdge.getSourcePort() != null) {
						KPortLayout portLayout = tsmEdge.layoutEdge
								.getSourcePort().getLayout();
						sourceBend.xpos += portLayout.getLocation().getX()
								+ portLayout.getSize().getWidth() / 2;
					}
				} else {
					sourceBend.ypos = edge.source.ypos;
					if (((TSMNode)edge.source).type == TSMNode.Type.LAYOUT
							&& tsmEdge.layoutEdge.getSourcePort() != null) {
						KPortLayout portLayout = tsmEdge.layoutEdge
								.getSourcePort().getLayout();
						sourceBend.ypos += portLayout.getLocation().getY()
								+ portLayout.getSize().getHeight() / 2;
					}
				}

				// set target bend
				KEdge.Bend targetBend = edge.bends.get(bendsCount - 1);
				if (edge.targetSide == KNode.Side.EAST
						|| edge.targetSide == KNode.Side.WEST) {
					targetBend.ypos = edge.target.ypos;
					if (((TSMNode)edge.target).type == TSMNode.Type.LAYOUT
							&& tsmEdge.layoutEdge.getTargetPort() != null) {
						KPortLayout portLayout = tsmEdge.layoutEdge
								.getTargetPort().getLayout();
						targetBend.ypos += portLayout.getLocation().getY()
								+ portLayout.getSize().getHeight() / 2;
					}
				} else {
					targetBend.xpos = edge.target.xpos;
					if (((TSMNode)edge.target).type == TSMNode.Type.LAYOUT
							&& tsmEdge.layoutEdge.getTargetPort() != null) {
						KPortLayout portLayout = tsmEdge.layoutEdge
								.getTargetPort().getLayout();
						targetBend.xpos += portLayout.getLocation().getX()
								+ portLayout.getSize().getWidth() / 2;
					}
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
	private float transformMetrics(List<Object> compactables, KGraph graph,
			final boolean horizontal, int abstrSize) {
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
				else if (obj instanceof KNode)
					return horizontal ? endNodeMap.get(obj).abstrXpos
							: endNodeMap.get(obj).abstrYpos;
				else return -1;
			}
		});
		
		// initialize concrete positions array
		float[] concrPos = new float[abstrSize];
		for (int i = 1; i < abstrSize; i++)
			concrPos[i] = -1;
		
		// set concrete positions for all compactable elements
		float maxPos = 0.0f;
		int lastPos = 0;
		for (Object obj : compactables) {
			int abstrPos = horizontal ? startNodeMap.get(obj).abstrXpos
					: startNodeMap.get(obj).abstrYpos;
			if (abstrPos > lastPos) {
				int lastWrittenPos = abstrPos - 1;
				while (concrPos[lastWrittenPos] < 0)
					lastWrittenPos--;
				if (concrPos[abstrPos] < concrPos[lastWrittenPos] + minDist) {
					concrPos[abstrPos] = concrPos[lastWrittenPos] + minDist;
					maxPos = Math.max(maxPos, concrPos[abstrPos]);
				}
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
					maxPos = Math.max(maxPos, concrPos[endPos]);
				}
				if (horizontal)
					node.xpos = concrPos[abstrPos];
				else
					node.ypos = concrPos[abstrPos];
			}
			else if (obj instanceof KEdge.Bend) {
				KEdge.Bend edgeBend = (KEdge.Bend)obj;
				if (horizontal)
					edgeBend.xpos = concrPos[abstrPos];
				else
					edgeBend.ypos = concrPos[abstrPos];
			}
		}
		return maxPos + minDist;
	}

}
