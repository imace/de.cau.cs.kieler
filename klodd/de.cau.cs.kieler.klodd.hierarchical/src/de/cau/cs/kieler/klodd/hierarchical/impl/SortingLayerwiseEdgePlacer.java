/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klodd.hierarchical.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.kiml.layout.options.LayoutDirection;
import de.cau.cs.kieler.kiml.layout.options.LayoutOptions;
import de.cau.cs.kieler.kiml.layout.options.PortSide;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;
import de.cau.cs.kieler.klodd.hierarchical.modules.ILayerwiseEdgePlacer;
import de.cau.cs.kieler.klodd.hierarchical.structures.*;


/**
 * Layerwise edge placer implementation that sorts the edges and gives
 * them slot ranks according to the result.
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Sp&ouml;nemann</a>
 */
public class SortingLayerwiseEdgePlacer extends AbstractAlgorithm implements
		ILayerwiseEdgePlacer {

    /**
     * Routing slot used for sorting.
     */
    private class SortableRoutingSlot extends RoutingSlot
        implements Comparable<RoutingSlot> {
        
        /** positions of line segments going to the preceding layer */
        List<Float> sourcePosis = new LinkedList<Float>();
        /** positions of line segments going to the next layer */
        List<Float> targetPosis = new LinkedList<Float>();
        
        /* (non-Javadoc)
         * @see java.lang.Comparable#compareTo(java.lang.Object)
         */
        public int compareTo(RoutingSlot o) {
            SortableRoutingSlot other = (SortableRoutingSlot)o;
            // compare number of conflicts for both variants
            int conflicts1 = countConflicts(this.targetPosis, other.sourcePosis);
            int conflicts2 = countConflicts(other.targetPosis, this.sourcePosis);
            if (conflicts1 > conflicts2)
                return 1;
            else if (conflicts1 < conflicts2)
                return -1;
            else {
                // compare number of crossings for both variants
                int crossings1 = countCrossings(this.targetPosis, other.start, other.end)
                        + countCrossings(other.sourcePosis, this.start, this.end);
                int crossings2 = countCrossings(other.targetPosis, this.start, this.end)
                        + countCrossings(this.sourcePosis, other.start, other.end);
                return crossings1 > crossings2 ? 1
                        : (crossings1 < crossings2 ? -1 : 0);
            }
        }
    }
	
	/** factor for the minimal distance value for edge spacing */
	private static final float EDGE_DIST_FACT = 0.25f;
	
	/** map of layer elements to their corresponding routing slots */
	private Map<Object, RoutingSlot> slotMap = new LinkedHashMap<Object, RoutingSlot>();
	/** minimal distance for edge spacing */
	private float edgeSpacing;
	
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
		getMonitor().begin("Edge routing (layer " + layer.rank + ")", 1);
		LayoutDirection layoutDirection = layer.getLayeredGraph().getLayoutDirection();
		this.edgeSpacing = minDist * EDGE_DIST_FACT;
		
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
					PortSide placement = LayoutOptions.getPortSide(
					        KimlLayoutUtil.getShapeLayout(connection.getSourcePort()));
					if (layoutDirection == LayoutDirection.VERTICAL) {
						if (placement == PortSide.WEST) {
							sourcePos = 0.0f;
						}
						else if (placement == PortSide.EAST) {
							sourcePos = layer.crosswiseDim;
						}
						else if (placement == PortSide.SOUTH) {
							sourcePos = layer.crosswiseDim;
						}
					}
					else {
						if (placement == PortSide.NORTH) {
							sourcePos = 0.0f;
						}
						else if (placement == PortSide.SOUTH) {
							sourcePos = layer.crosswiseDim;
						}
						else if (placement == PortSide.EAST) {
							sourcePos = layer.crosswiseDim;
						}
					}
				}
				else if (layer.height == 1) {
					PortSide placement = LayoutOptions.getPortSide(
                            KimlLayoutUtil.getShapeLayout(connection.getTargetPort()));
					if (layoutDirection == LayoutDirection.VERTICAL) {
						if (placement == PortSide.WEST) {
							targetPos = 0.0f;
						}
						else if (placement == PortSide.EAST) {
							targetPos = layer.crosswiseDim;
						}
						else if (placement == PortSide.NORTH) {
							targetPos = layer.crosswiseDim;
						}
					}
					else {
						if (placement == PortSide.NORTH) {
							targetPos = 0.0f;
						}
						else if (placement == PortSide.SOUTH) {
							targetPos = layer.crosswiseDim;
						}
						else if (placement == PortSide.WEST) {
							targetPos = layer.crosswiseDim;
						}
					}
				}
				float startPos = Math.min(sourcePos, targetPos);
				float endPos  = Math.max(sourcePos, targetPos);
				
                // get routing slot and insert connection area
                SortableRoutingSlot slot = (SortableRoutingSlot)slotMap.get(key);
                if (slot == null) {
                    slot = new SortableRoutingSlot();
                    slot.start = startPos;
                    slot.end = endPos;
                    slot.sourcePosis.add(Float.valueOf(sourcePos));
                    slot.targetPosis.add(Float.valueOf(targetPos));
                    slotMap.put(key, slot);
                }
                else {
                    slot.start = Math.min(slot.start, startPos);
                    slot.end = Math.max(slot.end, endPos);
                    insertSorted(slot.sourcePosis, sourcePos);
                    insertSorted(slot.targetPosis, targetPos);
                }
			}
		}
		
		// sort all routing slots using insert sort
		List<List<RoutingSlot>> routingLayers = new LinkedList<List<RoutingSlot>>();
		Collection<RoutingSlot> unsortedSlots = slotMap.values();
		List<SortableRoutingSlot> sortedSlots = new LinkedList<SortableRoutingSlot>();
		for (RoutingSlot slot : unsortedSlots) {
		    ListIterator<SortableRoutingSlot> slotIter = sortedSlots.listIterator();
		    while (slotIter.hasNext()) {
		        if (slotIter.next().compareTo(slot) > 0) {
		            slotIter.previous();
		            break;
		        }
		    }
		    slotIter.add((SortableRoutingSlot)slot);
		}
		
		
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
					if (slot.start < layerSlot.end + edgeSpacing
					        && slot.end > layerSlot.start - edgeSpacing) {
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
		
		getMonitor().done();
		return slotRanks;
	}

	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.ILayerwiseEdgePlacer#getSlotMap()
	 */
	public Map<Object, RoutingSlot> getSlotMap() {
		return slotMap;
	}
	
	/**
     * Inserts a given value into a sorted list.
     * 
     * @param list sorted list
     * @param value value to insert
     */
    private void insertSorted(List<Float> list, float value) {
        ListIterator<Float> listIter = list.listIterator();
        while (listIter.hasNext()) {
            if (listIter.next() <= value) {
                listIter.previous();
                break;
            }
        }
        listIter.add(Float.valueOf(value));
    }
    
    /**
     * Counts the number of crossings for a given list of positions.
     * 
     * @param posis sorted list of positions
     * @param start start of the critical area
     * @param end end of the critical area
     * @return number of positions in the critical area
     */
    private int countCrossings(List<Float> posis,
            float start, float end) {
        int crossings = 0;
        for (float pos : posis) {
            if (pos > end)
                break;
            else if (pos >= start)
                crossings++;
        }
        return crossings;
    }
    
    /**
     * Counts the number of conflicts for the given lists of positions.
     * 
     * @param posis1 sorted list of positions
     * @param posis2 sorted list of positions
     * @return number of positions that overlap
     */
    private int countConflicts(List<Float> posis1, List<Float> posis2) {
        int conflicts = 0;
        if (!posis1.isEmpty() && !posis2.isEmpty()) {
            Iterator<Float> iter1 = posis1.iterator();
            Iterator<Float> iter2 = posis2.iterator();
            float pos1 = iter1.next();
            float pos2 = iter2.next();
            boolean hasMore = true;
            do {
                if (pos1 > pos2 - edgeSpacing && pos1 < pos2 + edgeSpacing)
                    conflicts++;
                if (pos1 <= pos2 && iter1.hasNext())
                    pos1 = iter1.next();
                else if (pos2 <= pos1 && iter2.hasNext())
                    pos2 = iter2.next();
                else hasMore = false;
            } while (hasMore);
        }
        return conflicts;
    }

}
