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

import java.util.List;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KFloatOption;
import de.cau.cs.kieler.core.kgraph.KGraphFactory;
import de.cau.cs.kieler.core.kgraph.KIntOption;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KOption;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KLayoutData;
import de.cau.cs.kieler.kiml.layout.options.LayoutOptions;
import de.cau.cs.kieler.kiml.layout.options.LayoutType;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider;
import de.cau.cs.kieler.kiml.layout.util.alg.BoxPlacer;
import de.cau.cs.kieler.kiml.layout.util.alg.BoxSorter;

/**
 * A layout algorithm that does not take edges into account, but
 * treats all nodes as isolated boxes.
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Sp&ouml;nemann</a>
 */
public class BoxLayoutProvider extends AbstractLayoutProvider {

    /** collection name for utility layout providers */
    public static final String COLLECTION_NAME = "Utility";
    /** name of this layout provider */
    public static final String LAYOUTER_NAME = "Box Layout";
    /** layout option for priority of nodes */
    public static final String PRIORITY_OPTION = "box.priority";
    
    /** default value for spacing between boxes */
    private final static float DEFAULT_SPACING = 15.0f;
    
    /**
     * Sets the priority of the given layout data. Nodes with higher
     * assigned priorities are placed before nodes with lower
     * priority. Default for nodes with no priority is 0.
     * 
     * @param layoutData layout data to process
     * @param priority priority value for the corresponding node
     */
    public static void setPriority(KLayoutData layoutData,
            int priority) {
        KIntOption priorityOption = (KIntOption)layoutData.getOption(
                PRIORITY_OPTION);
        if (priorityOption == null) {
            priorityOption = KGraphFactory.eINSTANCE.createKIntOption();
            priorityOption.setKey(PRIORITY_OPTION);
            layoutData.getOptions().add(priorityOption);
        }
        priorityOption.setValue(priority);
    }
    
    /**
     * Retrieves the assigned priority value for a given layout
     * data.
     * 
     * @param layoutData layout data to process
     * @return the assigned priority, or 0 if no priority is assigned
     */
    public static int getPriority(KLayoutData layoutData) {
        KIntOption priorityOption = (KIntOption)layoutData.getOption(
                PRIORITY_OPTION);
        if (priorityOption == null)
            return 0;
        else
            return priorityOption.getValue();
    }
    
    /** the algorithm used to sort boxes */
    private BoxSorter boxSorter = new BoxSorter();
    /** the algorithm used to place boxes */
    private BoxPlacer boxPlacer = new BoxPlacer();
    
    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#doLayout(de.cau.cs.kieler.core.kgraph.KNode, de.cau.cs.kieler.kiml.layout.services.IKielerProgressMonitor)
     */
    public void doLayout(KNode layoutNode,
            IKielerProgressMonitor progressMonitor) throws KielerException {
        progressMonitor.begin("Box layout", 20);
        // set option for minimal spacing
        float spacing = LayoutOptions.getMinSpacing(
                KimlLayoutUtil.getShapeLayout(layoutNode));
        if (Float.isNaN(spacing)) {
            KOption spacingOption = getDefault(LayoutOptions.MIN_SPACING);
            if (spacingOption instanceof KFloatOption)
                spacing = ((KFloatOption)spacingOption).getValue();
            else
                spacing = DEFAULT_SPACING;
        }
        
        // sort boxes according to priority and size
        boxSorter.reset(progressMonitor.subTask(10));
        List<KNode> sortedBoxes = boxSorter.sort(layoutNode);
        // place boxes on the plane
        boxPlacer.reset(progressMonitor.subTask(10));
        boxPlacer.placeBoxes(sortedBoxes, layoutNode, spacing);
        
        progressMonitor.done();
    }
    
    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getCollection()
     */
    public String getCollection() {
        return COLLECTION_NAME;
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getName()
     */
    public String getName() {
        return LAYOUTER_NAME;
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider#getType()
     */
    public LayoutType getType() {
        return LayoutType.OTHER;
    }

}
