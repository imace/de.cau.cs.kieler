/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.layout.util;

import java.util.HashMap;
import java.util.Map;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.slimgraph.*;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;

/**
 * Class that converts a KIML layout graph into a KIELER slim graph.
 * 
 * @author msp
 */
public class GraphConverter extends AbstractAlgorithm {

	/** map of layout nodes and ports to KIELER nodes */
	private Map<Object, KSlimNode> nodeMap = new HashMap<Object, KSlimNode>();
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.core.alg.AbstractAlgorithm#reset()
	 */
	public void reset() {
		super.reset();
		nodeMap.clear();
	}
	
	/**
	 * Converts a given layout graph into a KIELER graph. Each node
	 * contains a reference to the corresponding layout node, and each
	 * edge contains a reference to the corresponding layout edge.
	 * 
	 * @param parentNode parent node to be converted
	 * @param includePorts if true, the external ports of the parent node
	 *     will also be added as nodes
	 * @return a graph which consists of the child nodes
	 */
	public KSlimGraph convertGraph(KLayoutNode parentNode, boolean includePorts) {
		getMonitor().begin("Graph conversion", 1);
		KSlimGraph kGraph = new KSlimGraph();
		
		// convert nodes
		for (KLayoutNode child : parentNode.getChildNodes()) {
			KSlimNode newNode = new KSlimNode(kGraph, child);
			nodeMap.put(child, newNode);
		}
		
		// convert edges
		for (KLayoutNode child : parentNode.getChildNodes()) {
			for (KLayoutEdge layoutEdge : child.getOutgoingEdges()) {
				KLayoutNode targetNode = layoutEdge.getTarget();
				if (targetNode != null) {
					KSlimEdge newEdge = new KSlimEdge(kGraph, nodeMap.get(child),
							nodeMap.get(targetNode), layoutEdge);
					newEdge.connectNodes();
				}
			}
		}
		
		if (includePorts) {
			// convert external ports
			for (KLayoutPort port : parentNode.getPorts()) {
				KSlimNode newNode = new KSlimNode(kGraph, port);
				nodeMap.put(port, newNode);
			}
			
			// convert edges to external ports
			for (KLayoutPort port : parentNode.getPorts()) {
				for (KLayoutEdge layoutEdge : port.getEdges()) {
					KLayoutNode source = layoutEdge.getSource();
					KLayoutNode target = layoutEdge.getTarget();
					if (layoutEdge.getSourcePort() == port
							&& target != null
							&& target.getParentNode() == parentNode) {
						KSlimEdge newEdge = new KSlimEdge(kGraph, nodeMap.get(port),
								nodeMap.get(target), layoutEdge);
						newEdge.connectNodes();
					}
					else if (layoutEdge.getTargetPort() == port
							&& source != null
							&& source.getParentNode() == parentNode) {
						KSlimEdge newEdge = new KSlimEdge(kGraph, nodeMap.get(source),
								nodeMap.get(port), layoutEdge);
						newEdge.connectNodes();
					}
				}
			}
		}
		
		getMonitor().done();
		return kGraph;
	}
	
}
