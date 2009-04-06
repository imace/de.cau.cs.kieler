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
package de.cau.cs.kieler.kiml.layout.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.options.LayoutDirection;
import de.cau.cs.kieler.kiml.layout.options.LayoutOptions;
import de.cau.cs.kieler.kiml.layout.options.PortSide;

/**
 * Utility class with static methods for the internally used layout graph
 * structure.
 * 
 * @author msp
 */
public class LayoutGraphUtil {
	
	/** minimal distance of two ports on each side of a node */
	private static final float MIN_PORT_DISTANCE = 16.0f;
	
	/**
	 * Sorts a given list of ports and returns the result as an array.
	 * 
	 * @param ports list of ports
	 * @param layoutDirection layout direction: HORIZONTAL or VERTICAL
	 * @param forward if true, ranks are determined for a forward layer sweep,
	 *     else for a backwards layer sweep
	 * @return a sorted array
	 */
	public static KPort[] sortPortsByPosition(final List<KPort> ports,
			LayoutDirection layoutDirection, boolean forward) {
		KPort[] portArray = ports.toArray(new KPort[0]);
		if (forward) {
			if (layoutDirection == LayoutDirection.VERTICAL) {
				// sort for forward vertical layout
				Arrays.sort(portArray, new Comparator<KPort>() {
					public int compare(KPort port1, KPort port2) {
					    KShapeLayout port1Layout = KimlLayoutUtil.getShapeLayout(port1);
					    KShapeLayout port2Layout = KimlLayoutUtil.getShapeLayout(port2);
						PortSide port1Place = LayoutOptions.getPortSide(port1Layout);
						PortSide port2Place = LayoutOptions.getPortSide(port2Layout);
						
						switch (port1Place) {
						case WEST:
							if (port2Place == PortSide.WEST)
								return Float.compare(port1Layout.getYpos(), port2Layout.getYpos());
							else return -1;
						case SOUTH:
							if (port2Place == PortSide.WEST)
								return 1;
							if (port2Place == PortSide.SOUTH)
								return Float.compare(port1Layout.getXpos(), port2Layout.getXpos());
							else return -1;
						case EAST:
							if (port2Place == PortSide.WEST
								|| port2Place == PortSide.SOUTH)
								return 1;
							if (port2Place == PortSide.EAST)
								return Float.compare(port2Layout.getYpos(), port1Layout.getYpos());
							else return -1;
						case NORTH:
							if (port2Place == PortSide.WEST
								|| port2Place == PortSide.SOUTH
								|| port2Place == PortSide.EAST)
								return 1;
							if (port2Place == PortSide.NORTH)
								return Float.compare(port2Layout.getXpos(), port1Layout.getXpos());
							else return -1;
						default:
							return -1;
						}
					}
				});
			}
			else {
				// sort for forward horizontal layout
				Arrays.sort(portArray, new Comparator<KPort>() {
					public int compare(KPort port1, KPort port2) {
					    KShapeLayout port1Layout = KimlLayoutUtil.getShapeLayout(port1);
                        KShapeLayout port2Layout = KimlLayoutUtil.getShapeLayout(port2);
                        PortSide port1Place = LayoutOptions.getPortSide(port1Layout);
					    PortSide port2Place = LayoutOptions.getPortSide(port2Layout);
						
						switch (port1Place) {
						case NORTH:
							if (port2Place == PortSide.NORTH)
								return Float.compare(port1Layout.getXpos(), port2Layout.getXpos());
							else return -1;
						case EAST:
							if (port2Place == PortSide.NORTH)
								return 1;
							if (port2Place == PortSide.EAST)
								return Float.compare(port1Layout.getYpos(), port2Layout.getYpos());
							else return -1;
						case SOUTH:
							if (port2Place == PortSide.NORTH
								|| port2Place == PortSide.EAST)
								return 1;
							if (port2Place == PortSide.SOUTH)
								return Float.compare(port2Layout.getXpos(), port1Layout.getXpos());
							else return -1;
						case WEST:
							if (port2Place == PortSide.NORTH
								|| port2Place == PortSide.EAST
								|| port2Place == PortSide.SOUTH)
								return 1;
							if (port2Place == PortSide.WEST)
								return Float.compare(port2Layout.getYpos(), port1Layout.getYpos());
							else return -1;
						default:
							return -1;
						}
					}
				});
			}
		}
		else {
			if (layoutDirection == LayoutDirection.VERTICAL) {
				// sort for backwards vertical layout
				Arrays.sort(portArray, new Comparator<KPort>() {
					public int compare(KPort port1, KPort port2) {
					    KShapeLayout port1Layout = KimlLayoutUtil.getShapeLayout(port1);
                        KShapeLayout port2Layout = KimlLayoutUtil.getShapeLayout(port2);
                        PortSide port1Place = LayoutOptions.getPortSide(port1Layout);
					    PortSide port2Place = LayoutOptions.getPortSide(port2Layout);
						
						switch (port1Place) {
						case WEST:
							if (port2Place == PortSide.WEST)
								return Float.compare(port2Layout.getYpos(), port1Layout.getYpos());
							else return -1;
						case NORTH:
							if (port2Place == PortSide.WEST)
								return 1;
							if (port2Place == PortSide.NORTH)
								return Float.compare(port1Layout.getXpos(), port2Layout.getXpos());
							else return -1;
						case EAST:
							if (port2Place == PortSide.WEST
								|| port2Place == PortSide.NORTH)
								return 1;
							if (port2Place == PortSide.EAST)
								return Float.compare(port1Layout.getYpos(), port2Layout.getYpos());
							else return -1;
						case SOUTH:
							if (port2Place == PortSide.WEST
								|| port2Place == PortSide.NORTH
								|| port2Place == PortSide.EAST)
								return 1;
							if (port2Place == PortSide.SOUTH)
								return Float.compare(port2Layout.getXpos(), port1Layout.getXpos());
							else return -1;
						default:
							return -1;
						}
					}
				});
			}
			else {
				// sort for backwards horizontal layout
				Arrays.sort(portArray, new Comparator<KPort>() {
					public int compare(KPort port1, KPort port2) {
					    KShapeLayout port1Layout = KimlLayoutUtil.getShapeLayout(port1);
                        KShapeLayout port2Layout = KimlLayoutUtil.getShapeLayout(port2);
                        PortSide port1Place = LayoutOptions.getPortSide(port1Layout);
					    PortSide port2Place = LayoutOptions.getPortSide(port2Layout);
						
						switch (port1Place) {
						case NORTH:
							if (port2Place == PortSide.NORTH)
								return Float.compare(port2Layout.getXpos(), port1Layout.getXpos());
							else return -1;
						case WEST:
							if (port2Place == PortSide.NORTH)
								return 1;
							if (port2Place == PortSide.WEST)
								return Float.compare(port1Layout.getYpos(), port2Layout.getYpos());
							else return -1;
						case SOUTH:
							if (port2Place == PortSide.NORTH
								|| port2Place == PortSide.WEST)
								return 1;
							if (port2Place == PortSide.SOUTH)
								return Float.compare(port1Layout.getXpos(), port2Layout.getXpos());
							else return -1;
						case EAST:
							if (port2Place == PortSide.NORTH
								|| port2Place == PortSide.WEST
								|| port2Place == PortSide.SOUTH)
								return 1;
							if (port2Place == PortSide.EAST)
								return Float.compare(port2Layout.getYpos(), port1Layout.getYpos());
							else return -1;
						default:
							return -1;
						}
					}
				});
			}			
		}
		
		return portArray;
	}
	
	/**
	 * Determines the position of some ports by their order inside the given
	 * array.
	 * 
	 * @param ports array of ports to position
	 * @param nodeWidth width of the corresponding layout node
	 * @param nodeHeight height of the corresponding layout node
	 * @param layoutDirection layout direction: HORIZONTAL or VERTICAL
	 * @param forward if true, ports are put clockwise on the node's border,
	 *     else counter-clockwise; only valid if not symmetric
	 * @param symmetric if true, ports are put on the node's border depending
	 *     on the layout direction
	 */
	public static void positionPortsByOrder(KPort[] ports, float nodeWidth,
	        float nodeHeight, LayoutDirection layoutDirection,
	        boolean forward, boolean symmetric) {
		// determine number of ports on each side
		int northTotal = 0, eastTotal = 0, southTotal = 0, westTotal = 0;
		for (KPort port : ports) {
			switch (LayoutOptions.getPortSide(
			        KimlLayoutUtil.getLayoutData(port))) {
			case NORTH:
				northTotal++;
				break;
			case EAST:
				eastTotal++;
				break;
			case SOUTH:
				southTotal++;
				break;
			case WEST:
				westTotal++;
				break;
			}
		}
		
		// determine distance between two ports on each side
		float northDist = nodeWidth / (northTotal + 1);
		float eastDist = nodeHeight / (eastTotal + 1);
		float southDist = nodeWidth / (southTotal + 1);
		float westDist = nodeHeight / (westTotal + 1);
		
		// determine starting points and increments for each side
		float northCur, eastCur, southCur, westCur;
		if (symmetric) {
			if (layoutDirection == LayoutDirection.VERTICAL) {
				// layout ports for vertical flow
				northCur = northDist;
				eastCur = nodeHeight - eastDist;
				eastDist = -eastDist;
				southCur = southDist;
				westCur = nodeHeight - westDist;
				westDist = -westDist;
			}
			else {
				// layout ports for horizontal flow
				northCur = nodeWidth - northDist;
				northDist = -northDist;
				eastCur = eastDist;
				southCur = nodeWidth - southDist;
				southDist = -southDist;
				westCur = westDist;
			}
		}
		else {
			if (forward) {
				// layout ports clockwise
				northCur = northDist;
				eastCur = eastDist;
				southCur = nodeWidth - southDist;
				southDist = -southDist;
				westCur = nodeHeight - westDist;
				westDist = -westDist;
			}
			else {
				// layout ports counter-clockwise
				northCur = nodeWidth - northDist;
				northDist = -northDist;
				eastCur = nodeHeight - eastDist;
				eastDist = -eastDist;
				southCur = southDist;
				westCur = westDist;
			}
		}
		
		// calculate new position for each port
		for (KPort port : ports) {
		    KShapeLayout shapeLayout = KimlLayoutUtil.getShapeLayout(port);
			switch (LayoutOptions.getPortSide(shapeLayout)) {
			case NORTH:
			    shapeLayout.setXpos(northCur);
			    shapeLayout.setYpos(-shapeLayout.getHeight());
				northCur += northDist;
				break;
			case EAST:
			    shapeLayout.setXpos(nodeWidth);
			    shapeLayout.setYpos(eastCur);
				eastCur += eastDist;
				break;
			case SOUTH:
			    shapeLayout.setXpos(southCur);
			    shapeLayout.setYpos(nodeHeight);
				southCur += southDist;
				break;
			case WEST:
			    shapeLayout.setXpos(-shapeLayout.getWidth());
			    shapeLayout.setYpos(westCur);
				westCur += westDist;
				break;
			}
		}
	}
	
	/**
	 * Determines positions of a sorted set of points by placing them
	 * with equal distances.
	 * 
	 * @param points list of points
	 * @param minPos minimal position for placing
	 * @param maxPos maximal position for placing
	 * @param offset offset to be added to positions
	 * @param vertical if true, the vertical position is processed, else
	 *     the horizontal position is processed
	 * @param forward if true, ports are placed from the minimum to the
	 *     maximum position
	 */
	public static void placePoints(List<KPoint> points, float minPos, float maxPos,
			float offset, boolean vertical, boolean forward) {
		float dist = (maxPos - minPos) / (points.size() + 1);
		float pos;
		if (forward) {
			pos = minPos + offset;
		}
		else {
			pos = maxPos + offset;
			dist = -dist;
		}
		
		if (vertical) {
			for (KPoint point : points) {
				pos += dist;
				point.setY(pos);
			}
		}
		else {
			for (KPoint point : points) {
				pos += dist;
				point.setX(pos);
			}
		}
	}
	
	/**
	 * Sets the size of a given node, depending on the number of ports
	 * on each side, the insets and the label.
	 * 
	 * @param node
	 */
	public static void resizeNode(KNode node) {
	    KShapeLayout nodeLayout = KimlLayoutUtil.getShapeLayout(node);
	    KInsets insets = LayoutOptions.getInsets(nodeLayout);
		float minWidth = insets.getLeft() + insets.getRight();
		float minHeight = insets.getTop() + insets.getBottom();
		KShapeLayout labelLayout = KimlLayoutUtil.getShapeLayout(node.getLabel());
		if (labelLayout != null) {
			minWidth += labelLayout.getWidth();
			minHeight += labelLayout.getHeight();
		}
		
		float minNorth = MIN_PORT_DISTANCE, minEast = MIN_PORT_DISTANCE,
			minSouth = MIN_PORT_DISTANCE, minWest = MIN_PORT_DISTANCE;
		for (KPort port : node.getPorts()) {
			switch (LayoutOptions.getPortSide(
                    KimlLayoutUtil.getLayoutData(port))) {
			case NORTH:
				minNorth += MIN_PORT_DISTANCE;
				break;
			case EAST:
				minEast += MIN_PORT_DISTANCE;
				break;
			case SOUTH:
				minSouth += MIN_PORT_DISTANCE;
				break;
			case WEST:
				minWest += MIN_PORT_DISTANCE;
				break;
			}
		}
		
		nodeLayout.setWidth(Math.max(minWidth,
				Math.max(minNorth, minSouth)));
		nodeLayout.setHeight(Math.max(minHeight,
				Math.max(minEast, minWest)));
	}

}
