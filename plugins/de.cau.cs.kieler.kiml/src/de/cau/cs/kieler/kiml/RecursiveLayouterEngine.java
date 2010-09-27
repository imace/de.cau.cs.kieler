/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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
package de.cau.cs.kieler.kiml;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.util.IDebugCanvas;

/**
 * Performs layout in a graph with hierarchy by executing a layout provider on
 * each level of the hierarchy. This is done recursively from the leafs to the
 * root of the nodes in the graph, using size information from lower levels in
 * the levels above.
 * 
 * @kieler.rating 2009-12-11 proposed yellow msp
 * @author ars
 */
public class RecursiveLayouterEngine {

    /** the last used layout provider. */
    private AbstractLayoutProvider lastLayoutProvider;
    /** the debug canvas to use. */
    private IDebugCanvas debugCanvas;

    /**
     * Creates a recursive layouter engine with the given debug canvas.
     * 
     * @param thedebugCanvas the debug canvas to use
     */
    public RecursiveLayouterEngine(final IDebugCanvas thedebugCanvas) {
        this.debugCanvas = thedebugCanvas;
    }
    
    /**
     * Performs recursive layout on the given layout graph.
     * 
     * @param layoutGraph instance of a layout graph
     * @param progressMonitor monitor to which progress of the layout algorithms is reported
     * @param layoutAncestors if true, layout is not only performed for the selected
     *         node, but also for its ancestors
     * @throws KielerException if a layout algorithm fails
     */
    public void layout(final KNode layoutGraph, final IKielerProgressMonitor progressMonitor,
            final boolean layoutAncestors)
            throws KielerException {
        lastLayoutProvider = null;
        int nodeCount = countNodes(layoutGraph);
        String label = "Recursive graph layout";
        if (layoutGraph.getLabel().getText() != null) {
            label += " (" + layoutGraph.getLabel().getText() + ")";
        }
        progressMonitor.begin(label, nodeCount);
        
        // perform recursive layout of the whole substructure of the given node
        layoutRecursively(layoutGraph, progressMonitor);
        
        // optionally layout the path of ancestors
        if (layoutAncestors) {
            KNode parent = layoutGraph.getParent();
            while (parent != null) {
                if (progressMonitor.isCanceled()) {
                    break;
                }
                lastLayoutProvider = LayoutServices.getInstance().getLayoutProvider(parent);
                lastLayoutProvider.doLayout(parent, progressMonitor.subTask(0));
                checkLayout(parent);
                parent = parent.getParent();
            }
        }
        
        progressMonitor.done();
    }

    /**
     * Recursive function to enable layout of hierarchy. The leafs are laid out
     * first to use their layout information in the levels above.
     * 
     * @param layoutNode the node with children to be laid out
     * @param progressMonitor monitor used to keep track of progress
     * @throws KielerException if one of the layout providers fails
     */
    private void layoutRecursively(final KNode layoutNode,
            final IKielerProgressMonitor progressMonitor)
            throws KielerException {
        if (!layoutNode.getChildren().isEmpty()) {
            AbstractLayoutProvider layoutProvider = LayoutServices.getInstance()
                    .getLayoutProvider(layoutNode);
            // if the layout provider supports hierarchy, it is expected to layout the children
            int nodeCount;
            if (layoutProvider.supportsHierarchy(layoutNode)) {
                nodeCount = countNodes(layoutNode);
            } else {
                nodeCount = layoutNode.getChildren().size();
                for (KNode child : layoutNode.getChildren()) {
                    layoutRecursively(child, progressMonitor);
                    if (progressMonitor.isCanceled()) {
                        return;
                    }
                }
            }

            // perform layout on the current hierarchy level
            lastLayoutProvider = layoutProvider;
            layoutProvider.setDebugCanvas(debugCanvas);
            layoutProvider.doLayout(layoutNode, progressMonitor.subTask(nodeCount));
            checkLayout(layoutNode);
        }
    }
    
    /**
     * Check and correct the layout result for the given node.
     * 
     * @param layoutNode a node for which layout has been performed
     */
    private void checkLayout(final KNode layoutNode) {
        // check the new size of the parent node
        KShapeLayout parentLayout = layoutNode.getData(KShapeLayout.class);
        float minWidth = parentLayout.getProperty(LayoutOptions.MIN_WIDTH);
        if (parentLayout.getWidth() < minWidth) {
            parentLayout.setWidth(minWidth);
        }
        float minHeight = parentLayout.getProperty(LayoutOptions.MIN_HEIGHT);
        if (parentLayout.getHeight() < minHeight) {
            parentLayout.setHeight(minHeight);
        }
        parentLayout.setProperty(LayoutOptions.FIXED_SIZE, true);
    }

    /**
     * Determines the total number of layout nodes in the given layout graph.
     * 
     * @param layoutNode parent layout node to examine
     * @return total number of child layout nodes
     */
    private int countNodes(final KNode layoutNode) {
        int count = layoutNode.getChildren().size();
        for (KNode childNode : layoutNode.getChildren()) {
            if (!childNode.getChildren().isEmpty()) {
                count += countNodes(childNode);
            }
        }
        return count;
    }

    /**
     * Returns the last layout provider that was used by the layouter engine.
     * This can be used to check the source of error if an exception is caught
     * during layout.
     * 
     * @return the last used layout provider, or {@code null} if there is none
     */
    public AbstractLayoutProvider getLastLayoutProvider() {
        return lastLayoutProvider;
    }

}
