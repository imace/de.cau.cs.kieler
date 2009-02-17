package de.cau.cs.kieler.klodd.hierarchical.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement;
import de.cau.cs.kieler.klodd.hierarchical.modules.ILayerwiseEdgePlacer;
import de.cau.cs.kieler.klodd.hierarchical.structures.*;


/**
 * Layerwise edge placer implementation that sorts the edges and gives
 * them slot ranks according to the result.
 * 
 * @author msp
 */
public class SortingLayerwiseEdgePlacer extends AbstractAlgorithm implements
		ILayerwiseEdgePlacer {

	/**
	 * 
	 */
	private class SortableRoutingSlot extends RoutingSlot {
		public boolean outgoingAtStart = false, outgoingAtEnd = false;
	}
	
	/** minimal distance of two edges to make them feasible in the same
	 *  routing layer */
	private static final float EDGE_DIST = 2.0f;
	
	/** map of layer elements to their corresponding routing slots */
	private Map<Object, RoutingSlot> slotMap = new LinkedHashMap<Object, RoutingSlot>();
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		slotMap.clear();
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.ILayerwiseEdgePlacer#placeEdges(de.cau.cs.kieler.klodd.hierarchical.structures.Layer)
	 */
	public int placeEdges(Layer layer, float minDist) {
		KLayoutOption layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		
		// determine number of outgoing connections for each port
		Map<Object, Integer> outgoing = new HashMap<Object, Integer>();
		for (LayerElement element : layer.getElements()) {
			// count outgoing connections
			for (LayerConnection connection : element.getOutgoingConnections()) {
				Object key = connection.getSourcePort();
				if (key == null)
					key = element;
				Integer value = outgoing.get(key);
				if (value == null) {
					outgoing.put(key, Integer.valueOf(1));
				}
				else {
					outgoing.put(key, Integer.valueOf(value.intValue() + 1));
				}
			}
		}
		
		// create routing slots for each port
		for (LayerElement element : layer.getElements()) {
			for (LayerConnection connection : element.getOutgoingConnections()) {
				// choose source or target port for routing
				Object key = connection.getSourcePort();
				if (key == null)
					key = element;
				Integer sourceValue = outgoing.get(key);
				if (sourceValue == null || sourceValue.intValue() <= 1) {
					key = connection.getTargetPort();
					if (key == null)
						key = connection.getTargetElement();
				}
				
				// determine source and target positions
				float sourcePos = connection.calcSourcePos(minDist);
				float targetPos = connection.calcTargetPos(minDist);
				if (layer.rank == 0) {
					KPortPlacement placement = connection.getSourcePort().getLayout().getPlacement();
					if (layoutDirection == KLayoutOption.VERTICAL) {
						if (placement == KPortPlacement.WEST) {
							sourcePos = 0.0f;
						}
						else if (placement == KPortPlacement.EAST) {
							sourcePos = layer.crosswiseDim;
						}
						else if (placement == KPortPlacement.SOUTH) {
							sourcePos = layer.crosswiseDim;
						}
					}
					else {
						if (placement == KPortPlacement.NORTH) {
							sourcePos = 0.0f;
						}
						else if (placement == KPortPlacement.SOUTH) {
							sourcePos = layer.crosswiseDim;
						}
						else if (placement == KPortPlacement.EAST) {
							sourcePos = layer.crosswiseDim;
						}
					}
				}
				else if (layer.height == 1) {
					KPortPlacement placement = connection.getTargetPort().getLayout().getPlacement();
					if (layoutDirection == KLayoutOption.VERTICAL) {
						if (placement == KPortPlacement.WEST) {
							targetPos = 0.0f;
						}
						else if (placement == KPortPlacement.EAST) {
							targetPos = layer.crosswiseDim;
						}
						else if (placement == KPortPlacement.NORTH) {
							targetPos = layer.crosswiseDim;
						}
					}
					else {
						if (placement == KPortPlacement.NORTH) {
							targetPos = 0.0f;
						}
						else if (placement == KPortPlacement.SOUTH) {
							targetPos = layer.crosswiseDim;
						}
						else if (placement == KPortPlacement.WEST) {
							targetPos = layer.crosswiseDim;
						}
					}
				}
				float startPos = Math.min(sourcePos, targetPos) - EDGE_DIST;
				float endPos  = Math.max(sourcePos, targetPos) + EDGE_DIST;
				
				// get routing slot and insert connection area
				SortableRoutingSlot slot = (SortableRoutingSlot)slotMap.get(key);
				if (slot == null) {
					slot = new SortableRoutingSlot();
					if (targetPos <= sourcePos)
						slot.outgoingAtStart = true;
					if (targetPos >= sourcePos)
						slot.outgoingAtEnd = true;
					slot.start = startPos;
					slot.end = endPos;
					slotMap.put(key, slot);
				}
				else {
					if (startPos < slot.start) {
						if (targetPos <= sourcePos)
							slot.outgoingAtStart = true;
						else
							slot.outgoingAtStart = false;
					}
					if (endPos > slot.end) {
						if (targetPos >= sourcePos)
							slot.outgoingAtEnd = true;
						else
							slot.outgoingAtEnd = false;
					}
					slot.start = Math.min(slot.start, startPos);
					slot.end = Math.max(slot.end, endPos);
				}
			}
		}
		
		// sort all routing slots
		List<List<RoutingSlot>> routingLayers = new LinkedList<List<RoutingSlot>>();
		RoutingSlot[] sortedSlots = slotMap.values().toArray(new RoutingSlot[0]);
		Arrays.sort(sortedSlots, new Comparator<RoutingSlot>() {
			public int compare(RoutingSlot s1, RoutingSlot s2) {
				SortableRoutingSlot slot1 = (SortableRoutingSlot)s1;
				SortableRoutingSlot slot2 = (SortableRoutingSlot)s2;
				if (slot1.outgoingAtStart && !slot2.outgoingAtStart
						&& slot1.start == slot2.start)
					return 1;
				else if (slot2.outgoingAtStart && !slot1.outgoingAtStart
						&& slot1.start == slot2.start)
					return -1;
				else if (slot1.outgoingAtEnd && !slot2.outgoingAtEnd
						&& slot1.end == slot2.end)
					return 1;
				else if (slot2.outgoingAtEnd && !slot1.outgoingAtEnd
						&& slot1.end == slot2.end)
					return -1;
				else if (slot1.outgoingAtStart && slot1.start > slot2.start)
					return 1;
				else if (slot2.outgoingAtStart && slot2.start > slot1.start)
					return -1;
				else if (slot1.outgoingAtEnd && slot1.end < slot2.end)
					return 1;
				else if (slot2.outgoingAtEnd && slot2.end < slot1.end)
					return -1;
				else if (!slot1.outgoingAtStart && slot1.start > slot2.start)
					return -1;
				else if (!slot2.outgoingAtStart && slot2.start > slot1.start)
					return 1;
				else if (!slot1.outgoingAtEnd && slot1.end < slot2.end)
					return -1;
				else if (!slot2.outgoingAtEnd && slot2.end < slot1.end)
					return 1;
				else
					return 0;
			}
		});
		// assign ranks to each routing slot
		int slotRanks = 0;
		for (RoutingSlot slot : sortedSlots) {
			int rank = routingLayers.size();
			ListIterator<List<RoutingSlot>> routingLayerIter = routingLayers.listIterator(routingLayers.size());
			List<RoutingSlot> lastLayer = null;
			while (routingLayerIter.hasPrevious()) {
				List<RoutingSlot> routingLayer = routingLayerIter.previous();
				boolean feasible = true;
				for (RoutingSlot layerSlot : routingLayer) {
					if (slot.start < layerSlot.end && slot.end > layerSlot.start) {
						feasible = false;
						break;
					}
				}
				if (!feasible)
					break;
				lastLayer = routingLayer;
				rank--;
			}
			if (lastLayer != null) {
				slot.rank = rank;
				lastLayer.add(slot);
			}
			else {
				slot.rank = routingLayers.size();
				List<RoutingSlot> routingLayer = new LinkedList<RoutingSlot>();
				routingLayer.add(slot);
				routingLayers.add(routingLayer);
				slotRanks++;
			}
		}
		
		return slotRanks;
	}

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.ILayerwiseEdgePlacer#getSlotMap()
	 */
	public Map<Object, RoutingSlot> getSlotMap() {
		return slotMap;
	}

}
