/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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
package de.cau.cs.kieler.klodd.orthogonal.structures.slimgraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Section of a slim graph.
 * <p>
 * TODO: Change the whole concept of subgraphs! This approach here is not good.
 * 
 * @author msp
 */
public class KGraphSection {

    /** nodes of this graph section, sorted by their creation number. */
    private List<KSlimNode> nodes = new ArrayList<KSlimNode>();
    /** list of edges that were removed. */
    private List<KSlimEdge> removedEdges = new LinkedList<KSlimEdge>();

    /**
     * Returns the nodes.
     * 
     * @return the nodes
     */
    public List<KSlimNode> getNodes() {
        return nodes;
    }

    /**
     * Sorts the nodes of this graph section. This method must be called prior
     * to any use of <code>contains(TSMNode)</code>.
     */
    public void sortNodes() {
        Collections.sort(nodes);
    }

    /**
     * Checks whether this graph section contains the given node by performing a
     * binary search in the sorted list of contained nodes.
     * 
     * @param node node to lookup
     * @return true if the given node is contained in <code>nodes</code>
     */
    public boolean contains(final KSlimNode node) {
        int start = 0, end = nodes.size(), pos;
        while (start != end) {
            pos = start + (end - start) / 2;
            int currentNr = nodes.get(pos).getId();
            if (node.getId() < currentNr) {
                end = pos;
            } else if (node.getId() > currentNr) {
                start = pos + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the given edge from the incidence lists of its source and target.
     * 
     * @param edgeEntry edge entry to remove from this graph section
     */
    public void removeEdge(final KSlimNode.IncEntry edgeEntry) {
        edgeEntry.getEdge().getSource().getIncidence().remove(edgeEntry);
        edgeEntry.getEdge().getTarget().getIncidence().remove(edgeEntry);
        removedEdges.add(edgeEntry.getEdge());
    }

    /**
     * Restores all edges that were removed.
     */
    public void restoreEdges() {
        for (KSlimEdge edge : removedEdges) {
            edge.connectNodes();
        }
        removedEdges.clear();
    }

}
