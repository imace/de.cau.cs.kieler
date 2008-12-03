package edu.unikiel.rtsys.kieler.kiml.layout.util;

import java.util.HashMap;
import java.util.Map;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.*;

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
			KLayoutGraph clone = KimlLayoutGraphFactory.eINSTANCE.createKLayoutGraph();
			Map<KNodeGroup, KNodeGroup> nodeGroupMap = new HashMap<KNodeGroup, KNodeGroup>();
			Map<KPort, KPort> portMap = new HashMap<KPort, KPort>();
			Map<KEdge, KEdge> edgeMap = new HashMap<KEdge, KEdge>();
			clone.setTopGroup(cloneNodeGroup(layoutGraph.getTopGroup(),
					nodeGroupMap, portMap, edgeMap));
			return clone;
		}
	}
	
	/**
	 * Clones a node group.
	 * 
	 * @param nodeGroup node group to clone
	 * @param nodeGroupMap mapping of node groups to their clones
	 * @param portMap mapping of ports to their clones
	 * @param edgeMap mapping of edges to their clones
	 * @return clone
	 */
	private static KNodeGroup cloneNodeGroup(KNodeGroup nodeGroup,
			Map<KNodeGroup, KNodeGroup> nodeGroupMap, Map<KPort, KPort> portMap,
			Map<KEdge, KEdge> edgeMap) {
		if (nodeGroup == null)
			return null;
		else {
			KNodeGroup clone = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroup();
			nodeGroupMap.put(nodeGroup, clone);
			clone.setIdString(new String(nodeGroup.getIdString()));
			clone.setLabel(cloneNodeGroupLabel(nodeGroup.getLabel()));
			clone.setLayout(cloneNodeGroupLayout(nodeGroup.getLayout()));
			for (KPort port : nodeGroup.getPorts()) {
				KPort portClone = clonePort(port);
				portMap.put(port, portClone);
				clone.getPorts().add(portClone);
			}
			for (KNodeGroup subNodeGroup : nodeGroup.getSubNodeGroups()) {
				clone.getSubNodeGroups().add(cloneNodeGroup(subNodeGroup,
						nodeGroupMap, portMap, edgeMap));
			}
			for (KEdge edge : nodeGroup.getIncomingEdges()) {
				if (!edgeMap.containsKey(edge)
						&& (edge.getSource() == null
						|| nodeGroupMap.containsKey(edge.getSource()))) {
					KEdge edgeClone = cloneEdge(edge, nodeGroupMap, portMap);
					edgeMap.put(edge, edgeClone);
				}
			}
			for (KEdge edge : nodeGroup.getOutgoingEdges()) {
				if (!edgeMap.containsKey(edge)
						&& (edge.getTarget() == null
						|| nodeGroupMap.containsKey(edge.getTarget()))) {
					KEdge edgeClone = cloneEdge(edge, nodeGroupMap, portMap);
					edgeMap.put(edge, edgeClone);
				}
			}
			return clone;
		}
	}
	
	/**
	 * Clones a node group label.
	 * 
	 * @param nodeGroupLabel node group label to be cloned
	 * @return clone
	 */
	private static KNodeGroupLabel cloneNodeGroupLabel(KNodeGroupLabel nodeGroupLabel) {
		if (nodeGroupLabel == null)
			return null;
		else {
			KNodeGroupLabel clone = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroupLabel();
			clone.setLabelLayout(cloneNodeGroupLabelLayout(nodeGroupLabel.getLabelLayout()));
			clone.setText(new String(nodeGroupLabel.getText()));
			return clone;
		}
	}
	
	/**
	 * Clones a node group label layout.
	 * 
	 * @param nodeGroupLabelLayout node group label layout to be cloned
	 * @return clone
	 */
	private static KNodeGroupLabelLayout cloneNodeGroupLabelLayout(KNodeGroupLabelLayout nodeGroupLabelLayout) {
		if (nodeGroupLabelLayout == null)
			return null;
		else {
			KNodeGroupLabelLayout clone = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroupLabelLayout();
			clone.setLabelPlacement(nodeGroupLabelLayout.getLabelPlacement());
			clone.setLocation(clonePoint(nodeGroupLabelLayout.getLocation()));
			clone.setSize(cloneDimension(nodeGroupLabelLayout.getSize()));
			clone.setUseLayout(nodeGroupLabelLayout.isUseLayout());
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
	 * Clones a node group layout.
	 * 
	 * @param nodeGroupLayout node group layout to be cloned
	 * @return clone
	 */
	private static KNodeGroupLayout cloneNodeGroupLayout(KNodeGroupLayout nodeGroupLayout) {
		if (nodeGroupLayout == null)
			return null;
		else {
			KNodeGroupLayout clone = KimlLayoutGraphFactory.eINSTANCE.createKNodeGroupLayout();
			clone.setInsets(cloneInsets(nodeGroupLayout.getInsets()));
			clone.setLayouterName(nodeGroupLayout.getLayouterName());
			clone.setLayoutType(nodeGroupLayout.getLayoutType());
			clone.setLocation(clonePoint(nodeGroupLayout.getLocation()));
			clone.setSize(cloneDimension(nodeGroupLayout.getSize()));
			clone.setUseLayout(nodeGroupLayout.isUseLayout());
			clone.getLayoutOptions().addAll(nodeGroupLayout.getLayoutOptions());
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
	private static KPort clonePort(KPort port) {
		if (port == null)
			return null;
		else {
			KPort clone = KimlLayoutGraphFactory.eINSTANCE.createKPort();
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
	 * @param nodeGroupMap mapping of node groups to their clones
	 * @param portMap mapping of ports to their clones
	 * @return clone
	 */
	private static KEdge cloneEdge(KEdge edge,
			Map<KNodeGroup, KNodeGroup> nodeGroupMap, Map<KPort, KPort> portMap) {
		if (edge == null)
			return null;
		else {
			KEdge clone = KimlLayoutGraphFactory.eINSTANCE.createKEdge();
			clone.setLayout(cloneEdgeLayout(edge.getLayout()));
			for (KEdgeLabel edgeLabel : edge.getLabel()) {
				clone.getLabel().add(cloneEdgeLabel(edgeLabel));
			}
			clone.setSource(nodeGroupMap.get(edge.getSource()));
			clone.setTarget(nodeGroupMap.get(edge.getTarget()));
			KPort sourcePort = portMap.get(edge.getSourcePort());
			clone.setSourcePort(sourcePort);
			if (sourcePort != null)
				sourcePort.getEdges().add(clone);
			KPort targetPort = portMap.get(edge.getTargetPort());
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
