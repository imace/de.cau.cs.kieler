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
 * 
 *****************************************************************************/
package de.cau.cs.kieler.kiml.ui.layout;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;

import de.cau.cs.kieler.core.kgraph.KGraphElement;
import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.kiml.klayoutdata.KLayoutData;
import de.cau.cs.kieler.kiml.klayoutdata.KLayoutDataPackage;
import de.cau.cs.kieler.kiml.options.LayoutOptions;

/**
 * Request for automatic layout on a set of edit parts of a diagram.
 * 
 * @kieler.rating 2009-12-11 proposed yellow msp
 * @author msp
 */
public class ApplyLayoutRequest extends Request {

    /** the request type used to apply layout. */
    public static final String REQ_APPLY_LAYOUT = "apply layout";
    
    /** list of layout graph elements and the corresponding edit parts. */
    private List<Pair<KGraphElement, GraphicalEditPart>> mappingList
            = new LinkedList<Pair<KGraphElement, GraphicalEditPart>>();
    
    /**
     * Creates a request to apply layout.
     */
    public ApplyLayoutRequest() {
        super(REQ_APPLY_LAYOUT);
    }

    /**
     * Adds the given graph element and edit part to the request. Graph elements
     * for which the NO_LAYOUT option is active are not included.
     * 
     * @param element graph element with layout data
     * @param editPart the corresponding edit part
     */
    public void addElement(final KGraphElement element, final GraphicalEditPart editPart) {
        KLayoutData layoutData = (KLayoutData) element.getData(
                KLayoutDataPackage.eINSTANCE.getKLayoutData());
        if (layoutData == null || !LayoutOptions.getBoolean(layoutData, LayoutOptions.NO_LAYOUT)) {
            mappingList.add(new Pair<KGraphElement, GraphicalEditPart>(element, editPart));
        }
    }
    
    /**
     * Returns a list of the graph elements and edit parts of this request.
     * 
     * @return a list with graph elements and corresponding edit parts
     */
    public List<Pair<KGraphElement, GraphicalEditPart>> getElements() {
        return mappingList;
    }
    
}
