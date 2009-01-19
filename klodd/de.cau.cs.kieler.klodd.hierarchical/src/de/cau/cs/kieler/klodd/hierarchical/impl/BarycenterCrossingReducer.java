package de.cau.cs.kieler.klodd.hierarchical.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPort;
import de.cau.cs.kieler.klodd.core.algorithms.AbstractAlgorithm;
import de.cau.cs.kieler.klodd.hierarchical.modules.ISingleLayerCrossingReducer;
import de.cau.cs.kieler.klodd.hierarchical.structures.*;


/**
 * Implementation of the barycenter method for the 2-layer crossing reduction
 * problem.
 * 
 * @author msp
 */
public class BarycenterCrossingReducer extends AbstractAlgorithm implements
		ISingleLayerCrossingReducer {

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.ISingleLayerCrossingReducer#reduceCrossings(de.cau.cs.kieler.klodd.hierarchical.structures.Layer, de.cau.cs.kieler.klodd.hierarchical.structures.Layer, boolean)
	 */
	public void reduceCrossings(Layer layer, boolean forward) {
		Map<LayerElement, Double> abstractRanks = new HashMap<LayerElement, Double>();
		for (LayerElement element : layer.getElements()) {
			if (element.arePortsFixed()) {
				// the ports of the current element are fixed
				List<Integer> rankList = element.getConnectionRanks(forward);
				double barycenter = calcBarycenter(rankList);
				abstractRanks.put(element, new Double(barycenter));
			}
			else {
				// ports are not fixed, find an order for the ports
				Map<KPort, List<Integer>> portRanks = element.getConnectionRanksByPort(forward);
				Map<KPort, Double> abstractPortRanks = new HashMap<KPort, Double>();
				List<KPort> ports = new LinkedList<KPort>(portRanks.keySet());
				double sum = 0.0;
				ListIterator<KPort> portsIter = ports.listIterator();
				while (portsIter.hasNext()) {
					KPort port = portsIter.next();
					List<Integer> rankList = portRanks.get(port);
					double barycenter = calcBarycenter(rankList);
					if (barycenter < 0.0) {
						portsIter.remove();
					}
					else {
						sum += barycenter;
						abstractPortRanks.put(port, new Double(barycenter));
					}
				}
				if (ports.isEmpty()) {
					// elements with no connections are put together on one side
					abstractRanks.put(element, new Double(-1.0));
				}
				else {
					element.sortPorts(abstractPortRanks, forward, false);
					abstractRanks.put(element, new Double(sum / ports.size()));
				}
			}
		}
		layer.sortAbstract(abstractRanks);
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.ISingleLayerCrossingReducer#reduceCrossings(de.cau.cs.kieler.klodd.hierarchical.structures.Layer, de.cau.cs.kieler.klodd.hierarchical.structures.Layer, de.cau.cs.kieler.klodd.hierarchical.structures.Layer, boolean)
	 */
	public void reduceCrossings(Layer layer) {
		Map<LayerElement, Double> abstractRanks = new HashMap<LayerElement, Double>();
		for (LayerElement element : layer.getElements()) {
			if (element.arePortsFixed()) {
				// the ports of the current element are fixed
				double barycenter = calcBarycenter(element.getConnectionRanks(true),
						element.getConnectionRanks(false));
				abstractRanks.put(element, new Double(barycenter));
			}
			else {
				// ports are not fixed, find an order for the ports
				Map<KPort, List<Integer>> forwardRanks = element.getConnectionRanksByPort(true);
				Map<KPort, List<Integer>> backwardsRanks = element.getConnectionRanksByPort(false);
				Map<KPort, Double> abstractPortRanks = new HashMap<KPort, Double>();
				List<KPort> ports = new LinkedList<KPort>(forwardRanks.keySet());
				double sum = 0.0;
				ListIterator<KPort> portsIter = ports.listIterator();
				while (portsIter.hasNext()) {
					KPort port = portsIter.next();
					double barycenter = calcBarycenter(forwardRanks.get(port),
							backwardsRanks.get(port));
					if (barycenter < 0.0) {
						portsIter.remove();
					}
					else {
						sum += barycenter;
						abstractPortRanks.put(port, new Double(barycenter));
					}
				}
				if (ports.isEmpty()) {
					// elements with no connections are put together on one side
					abstractRanks.put(element, new Double(-1.0));
				}
				else {
					element.sortPorts(abstractPortRanks, false, true);
					abstractRanks.put(element, new Double(sum / ports.size()));
				}
			}
		}
		layer.sortAbstract(abstractRanks);
	}

	/**
	 * Calculates the barycenter of a list of ranks.
	 * 
	 * @param ranks list of ranks
	 * @return barycenter value
	 */
	private double calcBarycenter(List<Integer> ranks) {
		if (ranks.isEmpty()) {
			return -1.0;
		}
		else {
			int rankSum = 0;
			for (int rank : ranks)
				rankSum += rank;
			return (double)rankSum / ranks.size();
		}
	}
	
	/**
	 * Calculates the barycenter of two given lists of ranks,
	 * which may be empty.
	 * 
	 * @param forwardRanks list of forward ranks
	 * @param backwardsRanks list of backwards ranks
	 * @return barycenter value
	 */
	private double calcBarycenter(List<Integer> forwardRanks,
			List<Integer> backwardsRanks) {
		double forwardValue = -1.0, backwardsValue = -1.0;
		if (!forwardRanks.isEmpty())
			forwardValue = calcBarycenter(forwardRanks);
		if (!backwardsRanks.isEmpty())
			backwardsValue = calcBarycenter(backwardsRanks);
		
		// determine the center of both values
		if (forwardValue == -1.0 && backwardsValue == -1.0)
			return -1.0;
		else if (forwardValue == -1.0)
			return backwardsValue;
		else if (backwardsValue == -1.0)
			return forwardValue;
		else
			return (forwardValue + backwardsValue) / 2;
	}

}
