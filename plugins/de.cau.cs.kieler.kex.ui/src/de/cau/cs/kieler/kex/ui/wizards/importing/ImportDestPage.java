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
package de.cau.cs.kieler.kex.ui.wizards.importing;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.dialogs.WizardResourceImportPage;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;

@SuppressWarnings("restriction")
public class ImportDestPage extends WizardResourceImportPage {

    private static final String INIT_PROJECT = "kieler_examples";

    private Button openImports;

    protected ImportDestPage(String name, IStructuredSelection selection) {
        super(name, selection);
        super.setDescription("Set destination location for imported examples.");
    }

    @Override
    public String getDescription() {
        return "Set destination location for imported examples.";
    }

    @Override
    protected ITreeContentProvider getFolderProvider() {
        return null;
    }

    @Override
    protected ITreeContentProvider getFileProvider() {
        return null;
    }

    @Override
    protected void createSourceGroup(Composite parent) {
        // no sources
    }

    @Override
    protected void createOptionsGroupButtons(Group optionsGroup) {
        openImports = new Button(optionsGroup, SWT.CHECK);
        openImports.setText("Open examples after import.");
        openImports.setEnabled(true);
    }

    /**
     * Creates the import location group with label, textfield and button.
     * 
     * @param parent
     *            , {@link Composite}
     */
    @Override
    public void createControl(Composite parent) {
        Group topGroup = new Group(parent, SWT.NONE);
        topGroup.setLayout(new GridLayout());
        topGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        topGroup.setText("Set Destination");
        super.createControl(topGroup);
        if (super.getContainerFullPath() == null) {
            super.setContainerFieldValue(INIT_PROJECT);
            super.setPageComplete(true);
        }
    }

    /**
     * getter for resource path.
     * 
     * @return {@link IPath}
     */
    @Override
    public IPath getResourcePath() {
        return super.getResourcePath();

    }

    @Override
    protected boolean determinePageCompletion() {
        boolean complete = validateSourceGroup() && myValidateDestinationGroup()
                && validateOptionsGroup();

        // Avoid draw flicker by not clearing the error
        // message unless all is valid.
        if (complete) {
            setErrorMessage(null);
        }

        return complete;
    }

    private boolean myValidateDestinationGroup() {
        IPath containerPath = getContainerFullPath();
        if (containerPath == null) {
            setMessage(IDEWorkbenchMessages.WizardImportPage_specifyFolder);
            return false;
        }

        // If the container exist, validate it
        IContainer container = getSpecifiedContainer();
        if (container == null) {
            // If it exists but is not valid then abort
            if (IDEWorkbenchPlugin.getPluginWorkspace().getRoot().exists(getContainerFullPath())) {
                return false;
            }

            // if it is does not exist be sure the project does
            IWorkspace workspace = IDEWorkbenchPlugin.getPluginWorkspace();
            IPath projectPath = containerPath.removeLastSegments(containerPath.segmentCount() - 1);

            if (workspace.getRoot().exists(projectPath)) {
                return true;
            }
            setMessage(IDEWorkbenchMessages.WizardImportPage_projectNotExist,
                    IMessageProvider.WARNING);
            return false;
        }
        if (!container.isAccessible()) {
            setMessage(IDEWorkbenchMessages.WizardImportPage_folderMustExist,
                    IMessageProvider.WARNING);
            return false;
        }
        if (container.getLocationURI() == null) {
            if (container.isLinked()) {
                setErrorMessage(IDEWorkbenchMessages.WizardImportPage_undefinedPathVariable);
            } else {
                setErrorMessage(IDEWorkbenchMessages.WizardImportPage_containerNotExist);
            }
            return false;
        }

        if (sourceConflictsWithDestination(containerPath)) {
            setErrorMessage(getSourceConflictMessage());
            return false;
        }

        if (container instanceof IWorkspaceRoot) {
            setMessage(IDEWorkbenchMessages.WizardImportPage_specifyProject,
                    IMessageProvider.WARNING);
            return false;
        }
        return true;

    }

    public boolean openImports() {
        return openImports.isEnabled();
    }
}