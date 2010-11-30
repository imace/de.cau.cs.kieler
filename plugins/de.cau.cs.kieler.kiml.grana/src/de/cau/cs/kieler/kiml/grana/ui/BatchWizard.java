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
package de.cau.cs.kieler.kiml.grana.ui;

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;

/**
 * The batch wizard lets the user select any number of diagram files and starts
 * a job which opens the diagrams, applies automatic layout, performs all
 * currently selected graph analyses and saves the results to a file.
 * 
 * @author mri
 */
public class BatchWizard extends Wizard {

    /** the wizard title. */
    private static final String TITLE = "Initialize a batch graph analysis";

    /** the initial selection. */
    private IStructuredSelection selection = null;
    /** the file selection page. */
    private BatchFileSelectionPage fileSelectionPage;
    /** the result file page. */
    private BatchResultFilePage resultFilePage;

    /** the selected files. */
    private List<IPath> selectedFiles;
    /** the 'layout before analysis' option. */
    private boolean layoutBeforeAnalysis;
    /** the result file. */
    private IPath resultFile;

    /**
     * Constructs a BatchWizard without initial file selection.
     */
    public BatchWizard() {
        super();
        setWindowTitle(TITLE);
    }

    /**
     * Constructs a BatchWizard with initial file selection.
     * 
     * @param initialSelection
     *            the selection
     */
    public BatchWizard(final IStructuredSelection initialSelection) {
        super();
        setWindowTitle(TITLE);
        selection = initialSelection;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPages() {
        fileSelectionPage = new BatchFileSelectionPage(selection);
        resultFilePage = new BatchResultFilePage();
        addPage(fileSelectionPage);
        addPage(resultFilePage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean performFinish() {
        fileSelectionPage.savePreferences();
        resultFilePage.savePreferences();
        selectedFiles = fileSelectionPage.getSelectedFiles();
        layoutBeforeAnalysis = fileSelectionPage.getLayoutBeforeAnalysis();
        resultFile = resultFilePage.getResultFile();
        return true;
    }

    /**
     * Returns the list of selected files.
     * 
     * @return the list of selected files
     */
    public List<IPath> getSelectedFiles() {
        return selectedFiles;
    }

    /**
     * Returns the value of the 'layout before analysis' option.
     * 
     * @return true if 'layout before analysis' has been activated
     */
    public boolean getLayoutBeforeAnalysis() {
        return layoutBeforeAnalysis;
    }

    /**
     * Returns the selected result file.
     * 
     * @return the result file
     */
    public IPath getResultFile() {
        return resultFile;
    }
}
