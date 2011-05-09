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
package de.cau.cs.kieler.klay.info;

import de.cau.cs.kieler.core.kivi.AbstractCombination;
import de.cau.cs.kieler.kiml.ui.layout.DiagramLayoutManager;
import de.cau.cs.kieler.kiml.ui.layout.LayoutEffect;

/**
 * Combination for updating the KIML Viewer when layout actions are performed.
 * 
 * @author soh
 */
public class UpdateViewerCombination extends AbstractCombination {

    /**
     * Update the viewer.
     * 
     * @param layoutEffect the layout effect that was just performed
     */
    public void execute(final LayoutEffect layoutEffect) {
        DiagramLayoutManager manager = layoutEffect.getManager();
        schedule(new UpdateViewerEffect(manager.getLayoutGraph(), manager.getProgressMonitor()));
    }
    
}