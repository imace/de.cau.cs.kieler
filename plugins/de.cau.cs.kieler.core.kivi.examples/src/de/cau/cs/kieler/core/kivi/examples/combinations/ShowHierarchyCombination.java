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
package de.cau.cs.kieler.core.kivi.examples.combinations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import de.cau.cs.kieler.core.kivi.AbstractCombination;
import de.cau.cs.kieler.core.kivi.examples.KiViExamplesPlugin;
import de.cau.cs.kieler.core.kivi.menu.KiviMenuContributionService;
import de.cau.cs.kieler.core.kivi.menu.ButtonTrigger.ButtonState;
import de.cau.cs.kieler.core.model.effects.HighlightEffect;

/**
 * Color the levels of hierarchy.
 * 
 * @author mmu
 */
public class ShowHierarchyCombination extends AbstractCombination {

    private static final String ID = "de.cau.cs.kieler.core.model.showhierarchy";

    private final static String[] editorIDs = { 
        "de.cau.cs.kieler.synccharts.diagram.part.SyncchartsDiagramEditorID",
        "de.cau.cs.kieler.kaom.diagram.part.KaomDiagramEditorID"};
    
    private DiagramEditor editor;

    /**
     * Default Constructor defining the button. 
     */
    public ShowHierarchyCombination() {
        ImageDescriptor icon = KiViExamplesPlugin.imageDescriptorFromPlugin(
                KiViExamplesPlugin.PLUGIN_ID, "icons/rainbow.png");

        KiviMenuContributionService.INSTANCE.addToolbarButton(this, ID,
                "Show Hierarchy", "Colorize hierarchical objects to make the hierarchy structure clearer.", icon,
                SWT.CHECK, null, editorIDs);
    }
    
    /**
     * Color the levels of hierarchy.
     * 
     * @param button
     *            kivi button trigger
     */
    public void execute(final ButtonState button/*
                                                 * , final SelectionState selection
                                                 * enables editing in color, causes some overhead
                                                 */) {
        if (ID.equals(button.getButtonId()) && button.getEditor() instanceof DiagramEditor) {
            if (button.isPushedIn()) {
                editor = (DiagramEditor) button.getEditor();
                EObject root = editor.getDiagram().getElement();
                int maxLevel = getDepth(root, 0);
                paintRecursively(root, 0, maxLevel);
            }
        } else {
            doNothing();
        }
    }

    private int getDepth(final EObject element, final int current) {
        int level = 0;
        for (EObject child : element.eContents()) {
            int childLevel = getDepth(child, current + 1);
            if (childLevel > level) {
                level = childLevel;
            }
        }
        return level + 1;
    }

    private void paintRecursively(final EObject element, final int level, final int maxLevel) {
        for (EObject child : element.eContents()) {
            paintRecursively(child, level + 1, maxLevel);
        }
        if (level > 0) {
            HighlightEffect effect = new HighlightEffect(element, editor, new Color(null, new RGB(
                    360.0f / (maxLevel + 1) * level, 1.0f, 0.9f)));
            effect.setChangeWidth(false);
            schedule(effect);
        }
    }
}
