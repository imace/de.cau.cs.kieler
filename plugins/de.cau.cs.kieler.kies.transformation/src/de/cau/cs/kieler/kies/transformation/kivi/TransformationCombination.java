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
package de.cau.cs.kieler.kies.transformation.kivi;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;

import de.cau.cs.kieler.core.kivi.AbstractCombination;
import de.cau.cs.kieler.core.kivi.triggers.EffectTrigger.EffectTriggerState;
import de.cau.cs.kieler.core.ui.util.EditorUtils;
import de.cau.cs.kieler.core.util.Maybe;
import de.cau.cs.kieler.kies.transformation.kivi.TransformationTrigger.TransformationState;
import de.cau.cs.kieler.kiml.ui.layout.LayoutEffect;
import de.cau.cs.kieler.synccharts.diagram.part.SyncchartsDiagramEditor;

/**
 * @author uru
 * 
 */
public class TransformationCombination extends AbstractCombination {

    private TransformationEffect effect;

    /**
     * executes this combination.
     * 
     * @param descriptor
     *            the descriptor containing information about the transformation.
     * @param transformationTrigger
     *            used to determine if the transformation was already executed and the result can be
     *            retrieved.
     */
    public void execute(final TransformationState descriptor,
            final EffectTriggerState<TransformationEffect> transformationTrigger) {

        if (transformationTrigger.getSequenceNumber() > descriptor.getSequenceNumber()) {
            System.out.println("effect has been executed" + effect.getResult());
        } else {
            System.out.println("standard execution");
            // start the transformation
            effect = new TransformationEffect(descriptor.getXtendFacade(),
                    descriptor.getTransformationName(), descriptor.getParameters(),
                    descriptor.getEditingDomain());
            effect.schedule();

            DiagramEditor activeEditor = getActiveEditor();
            if (activeEditor instanceof SyncchartsDiagramEditor) {
                // refresh GMF edit policies
                RefreshGMFElementsEffect gmfEffect = new RefreshGMFElementsEffect(
                        (SyncchartsDiagramEditor) activeEditor);
                gmfEffect.schedule();

                // apply automatic layout by triggering the trigger (null layouts whole diagram)
                LayoutEffect layoutEffect = new LayoutEffect(activeEditor, null);
                layoutEffect.schedule();
            }
        }
    }

    private DiagramEditor getActiveEditor() {
        final Maybe<DiagramEditor> maybe = new Maybe<DiagramEditor>();
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                IEditorPart editor = EditorUtils.getLastActiveEditor();
                if (editor instanceof DiagramEditor) {
                    maybe.set((DiagramEditor) editor);
                }
            }
        });
        return maybe.get();
    }
}