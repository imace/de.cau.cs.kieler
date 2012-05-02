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
package de.cau.cs.kieler.kiml.export.wizards;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;

import de.cau.cs.kieler.kiml.export.handlers.GraphFileHandler;

/**
 * A wizard for Exporting graphs from workspace.
 * 
 * @author wah
 */
public class ExportGraphWizard extends Wizard implements IExportWizard {

    /** the page from which to select the workspace source files and the target folder. */
    private ExportGraphWorkspaceSourcesPage workspaceSourcesPage;
    /** the selection the import wizard was called on. */
    private IStructuredSelection selection;



    /**
     * Constructs a graph Export wizard.
     */
    public ExportGraphWizard() {
        super();

    }

    /**
     * {@inheritDoc}
     */
    public void addPages() {
        workspaceSourcesPage = new ExportGraphWorkspaceSourcesPage(selection);
        addPage(workspaceSourcesPage);
    }

    /**
     * {@inheritDoc}
     */
    public IWizardPage getStartingPage() {
        // determine the starting page
        return workspaceSourcesPage;
    }

    /**
     * {@inheritDoc}
     */
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle(Messages.ExportGraphWizard_title);
        this.selection = selection;
        setNeedsProgressMonitor(true);

    }

    /**
     * {@inheritDoc}
     */
    public boolean performFinish() {
        if (!checkTargetDirectory()) {
            return false;
        }

        if (!targetFilesHandler()) {
            return false;
        }

        workspaceSourcesPage.close();

        return true;
    }

    /**
     * if target file exists then ask for replace, ignore or cancel.
     * 
     * @return true if ignore or replace and false if cancel
     */
    private boolean targetFilesHandler() {
        // for all selected files
        for (File sourceFile : workspaceSourcesPage.getSourceFiles(null)) {
            // get the target format selected from the user
            String targetFormat = workspaceSourcesPage.getTargetFormat();

            GraphFileHandler graphFileHandler = new GraphFileHandler(sourceFile, targetFormat,
                    workspaceSourcesPage.getTargetWorksapceDirectory());

            if (graphFileHandler.getAbsoluteTargetFile().exists()) {

                String[] dialogButtonLabels = { "Ignore", "Replace", "Cancel" };
                MessageDialog msgd = new MessageDialog(null, "Confirm", null, "A file named '"
                        + graphFileHandler.getWorkspaceTargetFile().getName()
                        + "' already exists in '"
                        + workspaceSourcesPage.getTargetWorksapceDirectory()
                        + "'. Do you want to replace it?", 0, dialogButtonLabels, 0);

                switch (msgd.open()) {
                case 2:// Cancel
                    return false;

                case 1:// Replace
                    exportGraph(graphFileHandler);
                    break;

                default:
                    ;// Ignore;

                }
            } else {
                exportGraph(graphFileHandler);
            }
        }
        return true;
    }

    /**
     * Export the graph with the new format in the target directory.
     * 
     * @param sourceFile
     * @param targetFile
     * @param targetFormat
     */
    private void exportGraph(final GraphFileHandler graphFileHandler) {
        // TODO read source file
        try {
            graphFileHandler.getKGraph();
            // TODO if source format equal to target format then copy file else convert
            Writer writer = new FileWriter(graphFileHandler.getAbsoluteTargetFile());
            writer.write("test graph");
            writer.close();
        } catch (Throwable exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }
    }

    /**
     * If target directory exists then return true. If not then ask to create it.
     * 
     * 
     * @return return true if target directory is ready, false otherwise
     */
    private boolean checkTargetDirectory() {
        IPath targetPath = ResourcesPlugin.getWorkspace().getRoot().getLocation()
                .append(workspaceSourcesPage.getTargetWorksapceDirectory());
        if (new File(targetPath.toString()).exists()) {
            return true;
        } else {
            if (MessageDialog.openConfirm(null,
                    Messages.ExportGraphWizard_title_createTargetFolder, workspaceSourcesPage
                            .getTargetWorksapceDirectory().toString()
                            + " "
                            + Messages.ExportGraphWizard_question_createTargetFolder)) {
                return createTargetDirectory();
            } else {
                return false;
            }

        }
    }

    /**
     * create the target directory if not exists.
     * 
     * @return true if success false otherwise
     */
    private boolean createTargetDirectory() {
        IPath targetPath = ResourcesPlugin.getWorkspace().getRoot().getLocation()
                .append(workspaceSourcesPage.getTargetWorksapceDirectory());
        return new File(targetPath.toString()).mkdirs();
    }

    
}
