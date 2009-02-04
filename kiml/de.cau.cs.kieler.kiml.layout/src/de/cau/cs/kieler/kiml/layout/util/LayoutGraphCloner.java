package de.cau.cs.kieler.kiml.layout.util;

import java.util.HashMap;
import java.util.Map;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.*;


/**
 * Utility class that can be used to clone a layout graph.
 * 
 * @author msp
 */
public class LayoutGraphCloner {
	
	/**
	 * Clones a layout graph.
	 * 
	 * @param layoutGraph layout graph to clone
	 * @return clone
	 */
	public static KLayoutGraph cloneLayoutGraph(KLayoutGraph layoutGraph) {
		if (layoutGraph == null)
			return null;
		else {
			Map<KLayoutNode, KLayoutNode> nodeMap = new HashMap<KLayoutNode, KLayoutNode>();
			Map<KLayoutPort, KLayoutPort> portMap = new HashMap<KLayoutPort, KLayoutPort>();
			Map<KLayoutEdge, KLayoutEdge> edgeMap = new HashMap<KLayoutEdge, KLayoutEdge>();
			KLayoutGraph clone = (KLayoutGraph)cloneLayoutNode(layoutGraph,
					nodeMap, portMap, edgeMap, true);
			return clone;
		}
	}
	
	/**
	 * Clones a layout node.
	 * 
	 * @param layoutNode layout node to clone
	 * @param layoutNodeMap mapping of layout nodes to their clones
	 * @param portMap mapping of ports to their clones
	 * @param edgeMap mapping of edges to their clones
	 * @param topNode if true, a KLayoutGraph will be created instead of
	 *     a KLayoutNode
	 * @return clone
	 */
	private static KLayoutNode cloneLayoutNode(KLayoutNode layoutNode,
			Map<KLayoutNode, KLayoutNode> layoutNodeMap, Map<KLayoutPort, KLayoutPort> portMap,
			Map<KLayoutEdge, KLayoutEdge> edgeMap, boolean topNode) {
		if (layoutNode == null)
			return null;
		else {
			KLayoutNode clone;
			if (topNode)
				clone = KimlLayoutGraphFactory.eINSTANCE.createKLayoutGraph();
			else
				clone = KimlLayoutGraphFactory.eINSTANCE.createKLayoutNode();
			layoutNodeMap.put(layoutNode, clone);
			clone.setIdString(new String(layoutNode.getIdString()));
			clone.setLabel(cloneLayoutNodeLabel(layoutNode.getLabel()));
			clone.setLayout(cloneLayoutNodeLayout(layoutNode.getLayout()));
			for (KLayoutPort port : layoutNode.getPorts()) {
				KLayoutPort portClone = clonePort(port);
				portMap.put(port, portClone);
				clone.getPorts().add(portClone);
			}
			for (KLayoutNode sublayoutNode : layoutNode.getChildNodes()) {
				clone.getChildNodes().add(cloneLayoutNode(sublayoutNode,
						layoutNodeMap, portMap, edgeMap, false));
			}
			for (KLayoutEdge edge : layoutNode.getIncomingEdges()) {
				if (!edgeMap.containsKey(edge)
						&& (edge.getSource() == null
						|| layoutNodeMap.containsKey(edge.getSource()))) {
					KLayoutEdge edgeClone = cloneEdge(edge, layoutNodeMap, portMap);
					edgeMap.put(edge, edgeClone);
				}
			}
			for (KLayoutEdge edge : layoutNode.getOutgoingEdges()) {
				if (!edgeMap.containsKey(edge)
						&& (edge.getTarget() == null
						|| layoutNodeMap.containsKey(edge.getTarget()))) {
					KLayoutEdge edgeClone = cloneEdge(edge, layoutNodeMap, portMap);
					edgeMap.put(edge, edgeClone);
				}
			}
			return clone;
		}
	}
	
	/**
	 * Clones a layout node label.
	 * 
	 * @param layoutNodeLabel layout node label to be cloned
	 * @return clone
	 */
	private static KNodeLabel cloneLayoutNodeLabel(KNodeLabel layoutNodeLabel) {
		if (layoutNodeLabel == null)
			return null;
		else {
			KNodeLabel clone = KimlLayoutGraphFactory.eINSTANCE.createKNodeLabel();
			clone.setLabelLayout(cloneLayoutNodeLabelLayout(layoutNodeLabel.getLabelLayout()));
			clone.setText(new String(layoutNodeLabel.getText()));
			return clone;
		}
	}
	
	/**
	 * Clones a layout node label layout.
	 * 
	 * @param layoutNodeLabelLayout layout node label layout to be cloned
	 * @return clone
	 */
	private static KNodeLabelLayout cloneLayoutNodeLabelLayout(KNodeLabelLayout layoutNodeLabelLayout) {
		if (layoutNodeLabelLayout == null)
			return null;
		else {
			KNodeLabelLayout clone = KimlLayoutGraphFactory.eINSTANCE.createKNodeLabelLayout();
			clone.setLabelPlacement(layoutNodeLabelLayout.getLabelPlacement());
			clone.setLocation(clonePoint(layoutNodeLabelLayout.getLocation()));
			clone.setSize(cloneDimension(layoutNodeLabelLayout.getSize()));
			clone.setUseLayout(layoutNodeLabelLayout.isUseLayout());
			return clone;
		}
	}
	
	/**
	 * Clones a point.
	 * 
	 * @param point point to be cloned
	 * @return clone
	 */
	private static KPoint clonePoint(KPoint point) {
		if (point == null)
			return null;
		else {
			KPoint clone = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
			clone.setX(point.getX());
			clone.setY(point.getY());
			return clone;
		}
	}
	
	/**
	 * Clones a dimension.
	 * 
	 * @param dimension dimension to be cloned
	 * @return clone
	 */
	private static KDimension cloneDimension(KDimension dimension) {
		if (dimension == null)
			return null;
		else {
			KDimension clone = KimlLayoutGraphFactory.eINSTANCE.createKDimension();
			clone.setHeight(dimension.getHeight());
			clone.setWidth(dimension.getWidth());
			return clone;
		}
	}
	
	/**
	 * Clones a layout node layout.
	 * 
	 * @param layoutNodeLayout layout node layout to be cloned
	 * @return clone
	 */
	private static KNodeLayout cloneLayoutNodeLayout(KNodeLayout layoutNodeLayout) {
		if (layoutNodeLayout == null)
			return null;
		else {
			KNodeLayout clone = KimlLayoutGraphFactory.eINSTANCE.createKNodeLayout();
			clone.setInsets(cloneInsets(layoutNodeLayout.getInsets()));
			clone.setLayouterName(layoutNodeLayout.getLayouterName());
			clone.setLayoutType(layoutNodeLayout.getLayoutType());
			clone.setLocation(clonePoint(layoutNodeLayout.getLocation()));
			clone.setSize(cloneDimension(layoutNodeLayout.getSize()));
			clone.setUseLayout(layoutNodeLayout.isUseLayout());
			clone.getLayoutOptions().addAll(layoutNodeLayout.getLayoutOptions());
			return clone;
		}
	}
	
	/**
	 * Clones insets.
	 * 
	 * @param insets insets to be cloned
	 * @return clone
	 */
	private static KInsets cloneInsets(KInsets insets) {
		if (insets == null)
			return null;
		else {
			KInsets clone = KimlLayoutGraphFactory.eINSTANCE.createKInsets();
			clone.setBottom(insets.getBottom());
			clone.setLeft(insets.getLeft());
			clone.setRight(insets.getRight());
			clone.setTop(insets.getTop());
			return clone;
		}
	}
	
	/**
	 * Clones a port.
	 * 
	 * @param port port to be cloned
	 * @return clone
	 */
	private static KLayoutPort clonePort(KLayoutPort port) {
		if (port == null)
			return null;
		else {
			KLayoutPort clone = KimlLayoutGraphFactory.eINSTANCE.createKLayoutPort();
			clone.setLabel(clonePortLabel(port.getLabel()));
			clone.setLayout(clonePortLayout(port.getLayout()));
			clone.setType(port.getType());
			return clone;
		}
	}
	
	/**
	 * Clones a port label.
	 * 
	 * @param portLabel port label to be cloned
	 * @return clone
	 */
	private static KPortLabel clonePortLabel(KPortLabel portLabel) {
		if (portLabel == null)
			return null;
		else {
			KPortLabel clone = KimlLayoutGraphFactory.eINSTANCE.createKPortLabel();
			clone.setLabelLayout(clonePortLabelLayout(portLabel.getLabelLayout()));
			clone.setText(new String(portLabel.getText()));
			return clone;
		}
	}
	
	/**
	 * Clones a port label layout.
	 * 
	 * @param portLabelLayout port label layout to be cloned
	 * @return clone
	 */
	private static KPortLabelLayout clonePortLabelLayout(KPortLabelLayout portLabelLayout) {
		if (portLabelLayout == null)
			return null;
		else {
			KPortLabelLayout clone = KimlLayoutGraphFactory.eINSTANCE.createKPortLabelLayout();
			clone.setLocation(clonePoint(portLabelLayout.getLocation()));
			clone.setSize(cloneDimension(portLabelLayout.getSize()));
			clone.setUseLayout(portLabelLayout.isUseLayout());
			return clone;
		}
	}
	
	/**
	 * Clones a port layout.
	 * 
	 * @param portLayout port layout to be cloned
	 * @return clone
	 */
	private static KPortLayout clonePortLayout(KPortLayout portLayout) {
		if (portLayout == null)
			return null;
		else {
			KPortLayout clone = KimlLayoutGraphFactory.eINSTANCE.createKPortLayout();
			clone.setLocation(clonePoint(portLayout.getLocation()));
			clone.setPlacement(portLayout.getPlacement());
			clone.setSize(cloneDimension(portLayout.getSize()));
			clone.setUseLayout(portLayout.isUseLayout());
			return clone;
		}
	}
	
	/**
	 * Clones an edge.
	 * 
	 * @param edge edge to be cloned
	 * @param layoutNodeMap mapping of layout nodes to their clones
	 * @param portMap mapping of ports to their clones
	 * @return clone
	 */
	private static KLayoutEdge cloneEdge(KLayoutEdge edge,
			Map<KLayoutNode, KLayoutNode> layoutNodeMap, Map<KLayoutPort, KLayoutPort> portMap) {
		if (edge == null)
			return null;
		else {
			KLayoutEdge clone = KimlLayoutGraphFactory.eINSTANCE.createKLayoutEdge();
			clone.setLayout(cloneEdgeLayout(edge.getLayout()));
			for (KEdgeLabel edgeLabel : edge.getLabel()) {
				clone.getLabel().add(cloneEdgeLabel(edgeLabel));
			}
			clone.setSource(layoutNodeMap.get(edge.getSource()));
			clone.setTarget(layoutNodeMap.get(edge.getTarget()));
			KLayoutPort sourcePort = portMap.get(edge.getSourcePort());
			clone.setSourcePort(sourcePort);
			if (sourcePort != null)
				sourcePort.getEdges().add(clone);
			KLayoutPort targetPort = portMap.get(edge.getTargetPort());
			clone.setTargetPort(targetPort);
			if (targetPort != null)
				targetPort.getEdges().add(clone);
			return clone;
		}
	}
	
	/**
	 * Clones an edge layout.
	 * 
	 * @param edgeLayout edge layout to be cloned
	 * @return clone
	 */
	private static KEdgeLayout cloneEdgeLayout(KEdgeLayout edgeLayout) {
		if (edgeLayout == null)
			return null;
		else {
			KEdgeLayout clone = KimlLayoutGraphFactory.eINSTANCE.createKEdgeLayout();
			clone.setEdgeType(edgeLayout.getEdgeType());
			clone.setSourcePoint(clonePoint(edgeLayout.getSourcePoint()));
			clone.setTargetPoint(clonePoint(edgeLayout.getTargetPoint()));
			clone.setUseLayout(edgeLayout.isUseLayout());
			for (KPoint point : edgeLayout.getGridPoints()) {
				clone.getGridPoints().add(clonePoint(point));
			}
			return clone;
		}
	}
	
	/**
	 * Clones an edge label.
	 * 
	 * @param edgeLabel edge label to be cloned
	 * @return clone
	 */
	private static KEdgeLabel cloneEdgeLabel(KEdgeLabel edgeLabel) {
		if (edgeLabel == null)
			return null;
		else {
			KEdgeLabel clone = KimlLayoutGraphFactory.eINSTANCE.createKEdgeLabel();
			clone.setLabelLayout(cloneEdgeLabelLayout(edgeLabel.getLabelLayout()));
			clone.setText(new String(edgeLabel.getText()));
			return clone;
		}
	}
	
	/**
	 * Clones an edge label layout.
	 * 
	 * @param edgeLabelLayout edge label layout to be cloned
	 * @return clone
	 */
	private static KEdgeLabelLayout cloneEdgeLabelLayout(KEdgeLabelLayout edgeLabelLayout) {
		if (edgeLabelLayout == null)
			return null;
		else {
			KEdgeLabelLayout clone = KimlLayoutGraphFactory.eINSTANCE.createKEdgeLabelLayout();
			clone.setLabelPlacement(edgeLabelLayout.getLabelPlacement());
			clone.setLocation(clonePoint(edgeLabelLayout.getLocation()));
			clone.setSize(cloneDimension(edgeLabelLayout.getSize()));
			clone.setUseLayout(edgeLabelLayout.isUseLayout());
			return clone;
		}
	}

}
