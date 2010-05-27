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
package de.cau.cs.kieler.core.model.preferences;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.cau.cs.kieler.core.model.CoreModelPlugin;
import de.cau.cs.kieler.core.model.util.MarkerHandler;

/**
 * @author soh
 */
public class ValidationManagerPreferencePage extends FieldEditorPreferencePage
        implements IWorkbenchPreferencePage {

    private List<BooleanFieldEditor> editors = new LinkedList<BooleanFieldEditor>();

    /**
     * Creates a KIELER preference page.
     */
    public ValidationManagerPreferencePage() {
        super(GRID);
        setDescription("Preference page for the Validation Manager");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void createFieldEditors() {
        Set<String> files = MarkerHandler.getRegisteredFiles();

        for (String file : files) {
            BooleanFieldEditor enablementFE = new BooleanFieldEditor(
                    MarkerHandler.PREFERENCE_PREFIX + file, file,
                    getFieldEditorParent());
            super.addField(enablementFE);
            editors.add(enablementFE);
        }

    }

    @Override
    public boolean performOk() {
        if (!super.performOk()) {
            return false;
        }

        for (BooleanFieldEditor bfe : editors) {
            String key = bfe.getLabelText();
            Boolean value = bfe.getBooleanValue();
            MarkerHandler.setEnabled(key, value);
        }
        MarkerHandler.refreshChecks();
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public void init(final IWorkbench workbench) {
        setPreferenceStore(CoreModelPlugin.getDefault().getPreferenceStore());
        Set<String> files = MarkerHandler.getRegisteredFiles();
        IPreferenceStore store = getPreferenceStore();

        for (String file : files) {
            String key = MarkerHandler.PREFERENCE_PREFIX + file;
            Boolean value = MarkerHandler.isEnabled(file);
            if (store.contains(key)) {
                Boolean storeValue = store.getBoolean(key);
                if (value != storeValue) {
                    MarkerHandler.setEnabled(file, storeValue);
                }
            } else {
                store.setValue(key, value);
            }
        }
    }
}
