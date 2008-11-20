package edu.unikiel.rtsys.klodd.core.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_PLACEMENT;

/**
 * Utility class with static methods for the internally used layout graph
 * structure.
 * 
 * @author msp
 */
public class LayoutGraphs {
	
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
			LAYOUT_OPTION layoutDirection, boolean forward) {
		KPort[] portArray = ports.toArray(new KPort[0]);
		if (forward) {
			if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
				// sort for forward vertical layout
				Arrays.sort(portArray, new Comparator<KPort>() {
					public int compare(KPort port1, KPort port2) {
						PORT_PLACEMENT port1Place = port1.getLayout().getPlacement();
						PORT_PLACEMENT port2Place = port2.getLayout().getPlacement();
						KPoint port1Loc = port1.getLayout().getLocation();
						KPoint port2Loc = port2.getLayout().getLocation();
						
						switch (port1Place) {
						case WEST:
							if (port2Place == PORT_PLACEMENT.WEST)
								return Float.compare(port1Loc.getY(), port2Loc.getY());
							else return -1;
						case SOUTH:
							if (port2Place == PORT_PLACEMENT.WEST)
								return 1;
							if (port2Place == PORT_PLACEMENT.SOUTH)
								return Float.compare(port1Loc.getX(), port2Loc.getX());
							else return -1;
						case EAST:
							if (port2Place == PORT_PLACEMENT.WEST
								|| port2Place == PORT_PLACEMENT.SOUTH)
								return 1;
							if (port2Place == PORT_PLACEMENT.EAST)
								return Float.compare(port2Loc.getY(), port1Loc.getY());
							else return -1;
						case NORTH:
							if (port2Place == PORT_PLACEMENT.WEST
								|| port2Place == PORT_PLACEMENT.SOUTH
								|| port2Place == PORT_PLACEMENT.EAST)
								return 1;
							if (port2Place == PORT_PLACEMENT.NORTH)
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
				Arrays.sort(portArray, new Comparator<KPort>() {
					public int compare(KPort port1, KPort port2) {
						PORT_PLACEMENT port1Place = port1.getLayout().getPlacement();
						PORT_PLACEMENT port2Place = port2.getLayout().getPlacement();
						KPoint port1Loc = port1.getLayout().getLocation();
						KPoint port2Loc = port2.getLayout().getLocation();
						
						switch (port1Place) {
						case NORTH:
							if (port2Place == PORT_PLACEMENT.NORTH)
								return Float.compare(port1Loc.getX(), port2Loc.getX());
							else return -1;
						case EAST:
							if (port2Place == PORT_PLACEMENT.NORTH)
								return 1;
							if (port2Place == PORT_PLACEMENT.EAST)
								return Float.compare(port1Loc.getY(), port2Loc.getY());
							else return -1;
						case SOUTH:
							if (port2Place == PORT_PLACEMENT.NORTH
								|| port2Place == PORT_PLACEMENT.EAST)
								return 1;
							if (port2Place == PORT_PLACEMENT.SOUTH)
								return Float.compare(port2Loc.getX(), port1Loc.getX());
							else return -1;
						case WEST:
							if (port2Place == PORT_PLACEMENT.NORTH
								|| port2Place == PORT_PLACEMENT.EAST
								|| port2Place == PORT_PLACEMENT.SOUTH)
								return 1;
							if (port2Place == PORT_PLACEMENT.WEST)
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
			if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
				// sort for backwards vertical layout
				Arrays.sort(portArray, new Comparator<KPort>() {
					public int compare(KPort port1, KPort port2) {
						PORT_PLACEMENT port1Place = port1.getLayout().getPlacement();
						PORT_PLACEMENT port2Place = port2.getLayout().getPlacement();
						KPoint port1Loc = port1.getLayout().getLocation();
						KPoint port2Loc = port2.getLayout().getLocation();
						
						switch (port1Place) {
						case WEST:
							if (port2Place == PORT_PLACEMENT.WEST)
								return Float.compare(port2Loc.getY(), port1Loc.getY());
							else return -1;
						case NORTH:
							if (port2Place == PORT_PLACEMENT.WEST)
								return 1;
							if (port2Place == PORT_PLACEMENT.NORTH)
								return Float.compare(port1Loc.getX(), port2Loc.getX());
							else return -1;
						case EAST:
							if (port2Place == PORT_PLACEMENT.WEST
								|| port2Place == PORT_PLACEMENT.NORTH)
								return 1;
							if (port2Place == PORT_PLACEMENT.EAST)
								return Float.compare(port1Loc.getY(), port2Loc.getY());
							else return -1;
						case SOUTH:
							if (port2Place == PORT_PLACEMENT.WEST
								|| port2Place == PORT_PLACEMENT.NORTH
								|| port2Place == PORT_PLACEMENT.EAST)
								return 1;
							if (port2Place == PORT_PLACEMENT.SOUTH)
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
				Arrays.sort(portArray, new Comparator<KPort>() {
					public int compare(KPort port1, KPort port2) {
						PORT_PLACEMENT port1Place = port1.getLayout().getPlacement();
						PORT_PLACEMENT port2Place = port2.getLayout().getPlacement();
						KPoint port1Loc = port1.getLayout().getLocation();
						KPoint port2Loc = port2.getLayout().getLocation();
						
						switch (port1Place) {
						case NORTH:
							if (port2Place == PORT_PLACEMENT.NORTH)
								return Float.compare(port2Loc.getX(), port1Loc.getX());
							else return -1;
						case WEST:
							if (port2Place == PORT_PLACEMENT.NORTH)
								return 1;
							if (port2Place == PORT_PLACEMENT.WEST)
								return Float.compare(port1Loc.getY(), port2Loc.getY());
							else return -1;
						case SOUTH:
							if (port2Place == PORT_PLACEMENT.NORTH
								|| port2Place == PORT_PLACEMENT.WEST)
								return 1;
							if (port2Place == PORT_PLACEMENT.SOUTH)
								return Float.compare(port1Loc.getX(), port2Loc.getX());
							else return -1;
						case EAST:
							if (port2Place == PORT_PLACEMENT.NORTH
								|| port2Place == PORT_PLACEMENT.WEST
								|| port2Place == PORT_PLACEMENT.SOUTH)
								return 1;
							if (port2Place == PORT_PLACEMENT.EAST)
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
	 * @param nodeSize size of the corresponding node group
	 * @param layoutDirection layout direction: HORIZONTAL or VERTICAL
	 * @param forward if true, ports are put clockwise on the node's border,
	 *     else counter-clockwise; only valid if not symmetric
	 * @param symmetric if true, ports are put on the node's border depending
	 *     on the layout direction
	 */
	public static void positionPortsByOrder(KPort[] ports, KDimension nodeSize,
			LAYOUT_OPTION layoutDirection, boolean forward, boolean symmetric) {
		// determine number of ports on each side
		int northTotal = 0, eastTotal = 0, southTotal = 0, westTotal = 0;
		for (KPort port : ports) {
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
			if (layoutDirection == LAYOUT_OPTION.VERTICAL) {
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
			KPoint portLocation = port.getLayout().getLocation();
			KDimension portSize = port.getLayout().getSize();
			switch (port.getLayout().getPlacement()) {
			case NORTH:
				portLocation.setX(northCur - portSize.getWidth());
				portLocation.setY(-portSize.getHeight());
				northCur += northDist;
				break;
			case EAST:
				portLocation.setX(nodeWidth - portSize.getWidth());
				portLocation.setY(eastCur - portSize.getHeight());
				eastCur += eastDist;
				break;
			case SOUTH:
				portLocation.setX(southCur - portSize.getWidth());
				portLocation.setY(nodeHeight - portSize.getHeight());
				southCur += southDist;
				break;
			case WEST:
				portLocation.setX(-portSize.getWidth());
				portLocation.setY(westCur - portSize.getHeight());
				westCur += westDist;
				break;
			}
		}
	}

}
