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
package de.cau.cs.kieler.krep.evalbench.ui;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.cau.cs.kieler.krep.evalbench.Activator;

/**
 * Preference page for general EvalBench preferences.
 * 
 * @author msp, ctr
 */
public class VerifyPreferencePage extends FieldEditorPreferencePage implements
        IWorkbenchPreferencePage {

    /** Path to the benchmark for automatic verification. */
    public static final String BENCHMARK_PATH = "EvalBench.benchmark_path";

    /**
     * Regular expression to express, which files in the Benchmark path are
     * actual benchmarks.
     */
    public static final String BENCHMARK_FILES = "Evalbench.benchmark_files";

    /** Shall signal names be case sensitive? */
    public static final String CASE_SENSITIVE = "Evalbench.case_sensitive";

    /** file to safe verification results. */
    public static final String VERIFY_LOG = "Evalbench.verify_log";

    /** continue Verification even after a failure occurred. */
    public static final String IGNORE_INVALID = "Evalbench.ignore_invalid";

    /**
     * Sets up the preference page.
     */
    public VerifyPreferencePage() {
        super(FieldEditorPreferencePage.GRID);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    public void init(IWorkbench workbench) {
        // set the preference store
        IPreferenceStore preferenceStore = Activator.getDefault()
                .getPreferenceStore();
        setPreferenceStore(preferenceStore);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors
     * ()
     */
    @Override
    protected void createFieldEditors() {

        FieldEditor fieldEditor = new DirectoryFieldEditor(BENCHMARK_PATH,
                "Path the benchmarks:", getFieldEditorParent());
        addField(fieldEditor);

        fieldEditor = new StringFieldEditor(BENCHMARK_FILES,
                "Regular expression to describe benchmark directories:",
                getFieldEditorParent());
        addField(fieldEditor);

        fieldEditor = new BooleanFieldEditor(CASE_SENSITIVE,
                "signals are case sensitve", getFieldEditorParent());
        addField(fieldEditor);

        FileFieldEditor log = new FileFieldEditor(VERIFY_LOG,
                "log File for verification results", getFieldEditorParent());
        String[] extensions = { "*.log" };
        log.setFileExtensions(extensions);
        addField(fieldEditor);

        fieldEditor = new BooleanFieldEditor(IGNORE_INVALID,
                "continue verify run after mismatch as detected",
                getFieldEditorParent());
        addField(fieldEditor);

        adjustGridLayout();
    }

}
