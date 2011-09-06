/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klighd.combinations;

import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.core.kivi.AbstractCombination;
import de.cau.cs.kieler.core.kivi.triggers.EffectTrigger.EffectTriggerState;
import de.cau.cs.kieler.core.ui.util.MonitoredOperation;
import de.cau.cs.kieler.core.util.Maybe;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;
import de.cau.cs.kieler.kiml.ui.diagram.LayoutCombination;
import de.cau.cs.kieler.klighd.effects.KlighdDiagramEffect;
import de.cau.cs.kieler.klighd.effects.KlighdLayoutEffect;
import de.cau.cs.kieler.klighd.views.DiagramViewPart;
import de.cau.cs.kieler.klighd.views.DiagramViewUtil;

/**
 * A combination for applying automatic layout on a KLighD view after a {@code KlighdDiagramEffect}.
 * 
 * @author mri
 */
public class KlighdAutomaticLayoutCombination extends AbstractCombination {

    /**
     * Applies automatic layout to a KLighD view after it has been created or updated using the
     * {@code KlighdDiagramEffect}.
     * 
     * @param state
     *            the effect trigger state for the {@code KlighdDiagramEffect}
     */
    public void execute(final EffectTriggerState<KlighdDiagramEffect> state) {
        final KlighdDiagramEffect diagramEffect = state.getEffect();
        if (diagramEffect.getViewer() != null) {
            // find the view the effect is referencing
            final Maybe<DiagramViewPart> view = Maybe.create();
            MonitoredOperation.runInUI(new Runnable() {
                public void run() {
                    view.set(DiagramViewUtil.getView(diagramEffect.getId()));
                }
            }, true);
            // schedule the layout effect if the view could be found
            if (view.get() != null) {
                IPreferenceStore preferenceStore = getPreferenceStore();
                boolean animate = preferenceStore.getBoolean(LayoutCombination.ANIMATE);
                boolean zoom = preferenceStore.getBoolean(LayoutCombination.ZOOM_TO_FIT);
                boolean progressBar = preferenceStore.getBoolean(LayoutCombination.PROGRESS_BAR);
                schedule(new KlighdLayoutEffect(view.get(), diagramEffect.getViewer(), zoom,
                        progressBar, false, animate));
            }
        }
    }

    /**
     * Return the preference store for the KIML UI plugin.
     * 
     * @return the preference store
     */
    private static IPreferenceStore getPreferenceStore() {
        return KimlUiPlugin.getDefault().getPreferenceStore();
    }

}
