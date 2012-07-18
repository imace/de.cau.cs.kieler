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
package de.cau.cs.kieler.klighd.xtext;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import de.cau.cs.kieler.core.kivi.AbstractCombination;

// SUPPRESS CHECKSTYLE NEXT LineLength
import de.cau.cs.kieler.core.model.xtext.triggers.XtextBasedEditorActivationChangeTrigger.XtextModelChangeState;
// SUPPRESS CHECKSTYLE NEXT LineLength
import de.cau.cs.kieler.core.model.xtext.triggers.XtextBasedEditorActivationChangeTrigger.XtextModelChangeState.EventType;
import de.cau.cs.kieler.klighd.effects.KlighdCloseDiagramEffect;
import de.cau.cs.kieler.klighd.effects.KlighdUpdateDiagramEffect;

/**
 * A combination for initializing/refreshing of KLighD views of Xtext-based models.
 * Views initiated by this combination are shared with {@link VisualizeChosenElementCombination}
 * since they use the compute the (secondary) view ids the same way.
 * 
 * @author chsch
 */
public class UpdateXtextModelKLighDCombination extends AbstractCombination {

    /**
     * The execute method revealed and invoked by KIVi.
     * 
     * @param state
     *            A {@link de.cau.cs.kieler.core.kivi.ITriggerState} carrying the necessary
     *            information.
     */
    public void execute(final XtextModelChangeState state) {
        String id = state.getEditorInputPath().toPortableString().replace(":", "");
          // the replacement is needed since the secondary view ids seem to be required
          //  to be free of ':', which will be violated on windows determining them this way. 
        
        if (state.getEventType().equals(EventType.CLOSED)) {
            this.schedule(new KlighdCloseDiagramEffect(id));
        } else {
            XtextResource resource = state.getResource();
            if (resource == null || IterableExtensions.isNullOrEmpty(resource.getContents())) {
                return;
            }
            this.schedule(new KlighdUpdateDiagramEffect(id, state.getEditorInputPath().lastSegment(),
                    resource.getContents().get(0), state.getEditor()));
        }
    }
}
