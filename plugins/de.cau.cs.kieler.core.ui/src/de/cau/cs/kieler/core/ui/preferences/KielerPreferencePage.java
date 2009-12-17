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
package de.cau.cs.kieler.core.ui.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.cau.cs.kieler.core.ui.CoreUIPlugin;

/**
 * Main preference page for the KIELER project. All subprojects should put their
 * preference pages into this page.
 * 
 * @author msp
 */
public class KielerPreferencePage extends FieldEditorPreferencePage
        implements IWorkbenchPreferencePage {

    /**
     * Creates a KIELER preference page.
     */
    public KielerPreferencePage() {
        super(GRID);
        setDescription("Main preference page for the KIELER project");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void createFieldEditors() {
        // FIXME no KIELER-wide preferences yet; empty pages are not allowed
        // according to Eclipse conventions
    }

    /**
     * {@inheritDoc}
     */
    public void init(final IWorkbench workbench) {
        setPreferenceStore(CoreUIPlugin.getDefault().getPreferenceStore());
    }

}
