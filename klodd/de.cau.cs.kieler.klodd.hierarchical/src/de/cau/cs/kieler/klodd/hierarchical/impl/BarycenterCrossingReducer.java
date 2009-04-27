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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.kiml.layout.options.PortConstraints;
import de.cau.cs.kieler.klodd.hierarchical.modules.ISingleLayerCrossingReducer;
import de.cau.cs.kieler.klodd.hierarchical.structures.*;


/**
 * Implementation of the barycenter method for the 2-layer crossing reduction
 * problem.
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Sp&ouml;nemann</a>
 */
public class BarycenterCrossingReducer extends AbstractAlgorithm implements
		ISingleLayerCrossingReducer {

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.ISingleLayerCrossingReducer#reduceCrossings(de.cau.cs.kieler.klodd.hierarchical.structures.Layer, de.cau.cs.kieler.klodd.hierarchical.structures.Layer, boolean)
	 */
	public void reduceCrossings(Layer layer, boolean forward) {
		getMonitor().begin("Barycenter method", 1);
		
		Map<LayerElement, Double> abstractRanks = new HashMap<LayerElement, Double>();
		for (LayerElement element : layer.getElements()) {
			if (element.getPortConstraints() == PortConstraints.FIXED_POS
			        || element.getPortConstraints() == PortConstraints.FIXED_ORDER) {
				// the ports of the current element are fixed
				List<Integer> rankList = element.getConnectionRanks(forward);
				double barycenter = calcBarycenter(rankList);
				if (barycenter < 0.0)
					barycenter = element.rank;
				abstractRanks.put(element, Double.valueOf(barycenter));
			}
			else {
				// ports are not fixed, find an order for the ports
				Map<KPort, List<Integer>> portRanks = element
						.getConnectionRanksByPort(forward);
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
						abstractPortRanks.put(port, Double.valueOf(barycenter));
					}
				}
				if (ports.isEmpty()) {
					// elements with no connections should stay where they are
					abstractRanks.put(element, Double.valueOf(element.rank));
				}
				else {
					element.sortPorts(abstractPortRanks, forward);
					abstractRanks.put(element, Double.valueOf(sum / ports.size()));
				}
			}
		}
		layer.sortAbstract(abstractRanks);
		
		getMonitor().done();
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.klodd.hierarchical.modules.ISingleLayerCrossingReducer#reduceCrossings(de.cau.cs.kieler.klodd.hierarchical.structures.Layer, de.cau.cs.kieler.klodd.hierarchical.structures.Layer, de.cau.cs.kieler.klodd.hierarchical.structures.Layer, boolean)
	 */
	public void reduceCrossings(Layer layer) {
		getMonitor().begin("Barycenter method", 1);
		
		Map<LayerElement, Double> abstractRanks = new HashMap<LayerElement, Double>();
		for (LayerElement element : layer.getElements()) {
			if (element.getPortConstraints() == PortConstraints.FIXED_POS) {
				// the ports of the current element are fixed
				double bary1 = calcBarycenter(element.getConnectionRanks(true));
				double bary2 = calcBarycenter(element.getConnectionRanks(false));
				double barycenter = mergeBarycenters(bary1, bary2);
				if (barycenter < 0.0)
					barycenter = element.rank;
				abstractRanks.put(element, Double.valueOf(barycenter));
			}
			else {
				// ports are not fixed, find an order for the ports
				Map<KPort, List<Integer>> forwardRanks = element
						.getConnectionRanksByPort(true);
				Map<KPort, List<Integer>> backwardsRanks = element
				        .getConnectionRanksByPort(false);
				Map<KPort, Double> abstractForward = new HashMap<KPort, Double>();
				Map<KPort, Double> abstractBackwards = new HashMap<KPort, Double>();
                List<KPort> ports = new LinkedList<KPort>(forwardRanks.keySet());
				double sum = 0.0;
				ListIterator<KPort> portsIter = ports.listIterator();
				while (portsIter.hasNext()) {
					KPort port = portsIter.next();
					double bary1 = calcBarycenter(forwardRanks.get(port));
	                double bary2 = calcBarycenter(backwardsRanks.get(port));
	                double barycenter = mergeBarycenters(bary1, bary2);
					if (barycenter < 0.0) {
						portsIter.remove();
					}
					else {
						sum += barycenter;
						if (bary1 >= 0.0)
						    abstractForward.put(port, Double.valueOf(bary1));
						if (bary2 >= 0.0)
						    abstractBackwards.put(port, Double.valueOf(bary2));
					}
				}
				if (ports.isEmpty()) {
					// elements with no connections should stay where they are
					abstractRanks.put(element, Double.valueOf(element.rank));
				}
				else {
					element.sortPorts(abstractForward, abstractBackwards);
					abstractRanks.put(element, Double.valueOf(sum / ports.size()));
				}
			}
		}
		layer.sortAbstract(abstractRanks);
		
		getMonitor().done();
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
	 * Merges two barycenter values, considering special cases.
	 * 
	 * @param b1 first value
	 * @param b2 second value
	 * @return merged barycenter value
	 */
	private double mergeBarycenters(double b1, double b2) {
		if (b1 == -1.0 && b2 == -1.0)
			return -1.0;
		else if (b1 == -1.0)
			return b2;
		else if (b2 == -1.0)
			return b1;
		else
			return (b1 + b2) / 2;
	}

}
