/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.views.properties.IPropertySheetEntry;

import de.cau.cs.kieler.kiml.layout.LayoutOptionData;
import de.cau.cs.kieler.kiml.layout.LayoutProviderData;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;
import de.cau.cs.kieler.kiml.ui.layout.EclipseLayoutServices;

/**
 * An action that sets the selected layout option as default for all instances of a
 * diagram type.
 *
 * @kieler.rating 2010-01-26 proposed yellow msp
 * @author msp
 */
public class DiagramTypeDefaultAction extends Action {

    /** an identifier for the action. */
    public static final String ACTION_ID = "kieler.diagram.type.default";

    /** the icon used for this action. */
    private static ImageDescriptor icon = KimlUiPlugin.getImageDescriptor(
            "icons/menu16/apply2diagramType.gif");

    /** the layout view that created this action. */
    private LayoutViewPart layoutView;
    
    /**
     * Creates a diagram type default action.
     * 
     * @param thelayoutView the layout view that created this action
     * @param text user friendly text
     */
    public DiagramTypeDefaultAction(final LayoutViewPart thelayoutView, final String text) {
        super(text, icon);
        this.layoutView = thelayoutView;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        String diagramType = layoutView.getCurrentDiagramType();
        if (diagramType != null) {
            for (IPropertySheetEntry entry : layoutView.getSelection()) {
                setDefault(diagramType, entry);
            }
        }
    }
    
    /**
     * Sets the layout option of the given property sheet entry as default for
     * the given diagram type.
     * 
     * @param diagramType a diagram type identifier
     * @param entry a property sheet entry
     */
    private void setDefault(final String diagramType, final IPropertySheetEntry entry) {
        LayoutOptionData optionData = null;
        for (LayoutProviderData providerData : layoutView.getCurrentProviderData()) {
            optionData = EclipseLayoutServices.getInstance().getOptionData(providerData,
                    entry.getDisplayName());
            if (optionData != null) {
                break;
            }
        }
        if (optionData != null) {
            EclipseLayoutServices.getInstance().storeOption(diagramType,
                    optionData, entry.getValueAsString());
        }
    }
    
}
