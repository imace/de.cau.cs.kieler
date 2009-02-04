package de.cau.cs.kieler.klodd.core.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement;


/**
 * Utility class with static methods for the internally used layout graph
 * structure.
 * 
 * @author msp
 */
public class LayoutGraphs {
	
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
	public static KLayoutPort[] sortPortsByPosition(final List<KLayoutPort> ports,
			KLayoutOption layoutDirection, boolean forward) {
		KLayoutPort[] portArray = ports.toArray(new KLayoutPort[0]);
		if (forward) {
			if (layoutDirection == KLayoutOption.VERTICAL) {
				// sort for forward vertical layout
				Arrays.sort(portArray, new Comparator<KLayoutPort>() {
					public int compare(KLayoutPort port1, KLayoutPort port2) {
						KPortPlacement port1Place = port1.getLayout().getPlacement();
						KPortPlacement port2Place = port2.getLayout().getPlacement();
						KPoint port1Loc = port1.getLayout().getLocation();
						KPoint port2Loc = port2.getLayout().getLocation();
						
						switch (port1Place) {
						case WEST:
							if (port2Place == KPortPlacement.WEST)
								return Float.compare(port1Loc.getY(), port2Loc.getY());
							else return -1;
						case SOUTH:
							if (port2Place == KPortPlacement.WEST)
								return 1;
							if (port2Place == KPortPlacement.SOUTH)
								return Float.compare(port1Loc.getX(), port2Loc.getX());
							else return -1;
						case EAST:
							if (port2Place == KPortPlacement.WEST
								|| port2Place == KPortPlacement.SOUTH)
								return 1;
							if (port2Place == KPortPlacement.EAST)
								return Float.compare(port2Loc.getY(), port1Loc.getY());
							else return -1;
						case NORTH:
							if (port2Place == KPortPlacement.WEST
								|| port2Place == KPortPlacement.SOUTH
								|| port2Place == KPortPlacement.EAST)
								return 1;
							if (port2Place == KPortPlacement.NORTH)
								return Float.compare(port2Loc.getX(), port1Loc.getX());
							else return -1;
						default:
							return -1;
						}
					}
				});
			}
			else {
				// sort for forward horizontal layout
				Arrays.sort(portArray, new Comparator<KLayoutPort>() {
					public int compare(KLayoutPort port1, KLayoutPort port2) {
						KPortPlacement port1Place = port1.getLayout().getPlacement();
						KPortPlacement port2Place = port2.getLayout().getPlacement();
						KPoint port1Loc = port1.getLayout().getLocation();
						KPoint port2Loc = port2.getLayout().getLocation();
						
						switch (port1Place) {
						case NORTH:
							if (port2Place == KPortPlacement.NORTH)
								return Float.compare(port1Loc.getX(), port2Loc.getX());
							else return -1;
						case EAST:
							if (port2Place == KPortPlacement.NORTH)
								return 1;
							if (port2Place == KPortPlacement.EAST)
								return Float.compare(port1Loc.getY(), port2Loc.getY());
							else return -1;
						case SOUTH:
							if (port2Place == KPortPlacement.NORTH
								|| port2Place == KPortPlacement.EAST)
								return 1;
							if (port2Place == KPortPlacement.SOUTH)
								return Float.compare(port2Loc.getX(), port1Loc.getX());
							else return -1;
						case WEST:
							if (port2Place == KPortPlacement.NORTH
								|| port2Place == KPortPlacement.EAST
								|| port2Place == KPortPlacement.SOUTH)
								return 1;
							if (port2Place == KPortPlacement.WEST)
								return Float.compare(port2Loc.getY(), port1Loc.getY());
							else return -1;
						default:
							return -1;
						}
					}
				});
			}
		}
		else {
			if (layoutDirection == KLayoutOption.VERTICAL) {
				// sort for backwards vertical layout
				Arrays.sort(portArray, new Comparator<KLayoutPort>() {
					public int compare(KLayoutPort port1, KLayoutPort port2) {
						KPortPlacement port1Place = port1.getLayout().getPlacement();
						KPortPlacement port2Place = port2.getLayout().getPlacement();
						KPoint port1Loc = port1.getLayout().getLocation();
						KPoint port2Loc = port2.getLayout().getLocation();
						
						switch (port1Place) {
						case WEST:
							if (port2Place == KPortPlacement.WEST)
								return Float.compare(port2Loc.getY(), port1Loc.getY());
							else return -1;
						case NORTH:
							if (port2Place == KPortPlacement.WEST)
								return 1;
							if (port2Place == KPortPlacement.NORTH)
								return Float.compare(port1Loc.getX(), port2Loc.getX());
							else return -1;
						case EAST:
							if (port2Place == KPortPlacement.WEST
								|| port2Place == KPortPlacement.NORTH)
								return 1;
							if (port2Place == KPortPlacement.EAST)
								return Float.compare(port1Loc.getY(), port2Loc.getY());
							else return -1;
						case SOUTH:
							if (port2Place == KPortPlacement.WEST
								|| port2Place == KPortPlacement.NORTH
								|| port2Place == KPortPlacement.EAST)
								return 1;
							if (port2Place == KPortPlacement.SOUTH)
								return Float.compare(port2Loc.getX(), port1Loc.getX());
							else return -1;
						default:
							return -1;
						}
					}
				});
			}
			else {
				// sort for backwards horizontal layout
				Arrays.sort(portArray, new Comparator<KLayoutPort>() {
					public int compare(KLayoutPort port1, KLayoutPort port2) {
						KPortPlacement port1Place = port1.getLayout().getPlacement();
						KPortPlacement port2Place = port2.getLayout().getPlacement();
						KPoint port1Loc = port1.getLayout().getLocation();
						KPoint port2Loc = port2.getLayout().getLocation();
						
						switch (port1Place) {
						case NORTH:
							if (port2Place == KPortPlacement.NORTH)
								return Float.compare(port2Loc.getX(), port1Loc.getX());
							else return -1;
						case WEST:
							if (port2Place == KPortPlacement.NORTH)
								return 1;
							if (port2Place == KPortPlacement.WEST)
								return Float.compare(port1Loc.getY(), port2Loc.getY());
							else return -1;
						case SOUTH:
							if (port2Place == KPortPlacement.NORTH
								|| port2Place == KPortPlacement.WEST)
								return 1;
							if (port2Place == KPortPlacement.SOUTH)
								return Float.compare(port1Loc.getX(), port2Loc.getX());
							else return -1;
						case EAST:
							if (port2Place == KPortPlacement.NORTH
								|| port2Place == KPortPlacement.WEST
								|| port2Place == KPortPlacement.SOUTH)
								return 1;
							if (port2Place == KPortPlacement.EAST)
								return Float.compare(port2Loc.getY(), port1Loc.getY());
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
	 * @param nodeSize size of the corresponding layout node
	 * @param layoutDirection layout direction: HORIZONTAL or VERTICAL
	 * @param forward if true, ports are put clockwise on the node's border,
	 *     else counter-clockwise; only valid if not symmetric
	 * @param symmetric if true, ports are put on the node's border depending
	 *     on the layout direction
	 */
	public static void positionPortsByOrder(KLayoutPort[] ports, KDimension nodeSize,
			KLayoutOption layoutDirection, boolean forward, boolean symmetric) {
		// determine number of ports on each side
		int northTotal = 0, eastTotal = 0, southTotal = 0, westTotal = 0;
		for (KLayoutPort port : ports) {
			switch (port.getLayout().getPlacement()) {
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
		float nodeWidth = nodeSize.getWidth();
		float nodeHeight = nodeSize.getHeight();
		float northDist = nodeWidth / (northTotal + 1);
		float eastDist = nodeHeight / (eastTotal + 1);
		float southDist = nodeWidth / (southTotal + 1);
		float westDist = nodeHeight / (westTotal + 1);
		
		// determine starting points and increments for each side
		float northCur, eastCur, southCur, westCur;
		if (symmetric) {
			if (layoutDirection == KLayoutOption.VERTICAL) {
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
		for (KLayoutPort port : ports) {
			KPoint portLocation = port.getLayout().getLocation();
			KDimension portSize = port.getLayout().getSize();
			switch (port.getLayout().getPlacement()) {
			case NORTH:
				portLocation.setX(northCur);
				portLocation.setY(-portSize.getHeight());
				northCur += northDist;
				break;
			case EAST:
				portLocation.setX(nodeWidth);
				portLocation.setY(eastCur);
				eastCur += eastDist;
				break;
			case SOUTH:
				portLocation.setX(southCur);
				portLocation.setY(nodeHeight);
				southCur += southDist;
				break;
			case WEST:
				portLocation.setX(-portSize.getWidth());
				portLocation.setY(westCur);
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
	public static void resizeNode(KLayoutNode node) {
		KNodeLayout nodeLayout = node.getLayout();
		float minWidth = nodeLayout.getInsets().getLeft() + nodeLayout.getInsets().getRight();
		float minHeight = nodeLayout.getInsets().getTop() + nodeLayout.getInsets().getBottom();
		KNodeLabelLayout labelLayout = node.getLabel().getLabelLayout();
		if (labelLayout != null) {
			minWidth += labelLayout.getSize().getWidth();
			minHeight += labelLayout.getSize().getHeight();
		}
		
		float minNorth = MIN_PORT_DISTANCE, minEast = MIN_PORT_DISTANCE,
			minSouth = MIN_PORT_DISTANCE, minWest = MIN_PORT_DISTANCE;
		for (KLayoutPort port : node.getPorts()) {
			switch (port.getLayout().getPlacement()) {
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
		
		nodeLayout.getSize().setWidth(Math.max(minWidth,
				Math.max(minNorth, minSouth)));
		nodeLayout.getSize().setHeight(Math.max(minHeight,
				Math.max(minEast, minWest)));
	}

}
