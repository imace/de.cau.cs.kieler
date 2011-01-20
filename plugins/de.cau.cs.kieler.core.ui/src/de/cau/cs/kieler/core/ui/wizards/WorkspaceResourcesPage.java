/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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

package de.cau.cs.kieler.core.ui.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

import de.cau.cs.kieler.core.ui.Messages;
import de.cau.cs.kieler.core.ui.util.ComboHistoryManager;


/**
 * A wizard page that allows the user to choose files to import from the workspace.
 * Optionally, a target group may allow the user to choose a target folder in the
 * workspace to import to.
 * 
 * @author cds
 */
public class WorkspaceResourcesPage extends ResourceTreeAndListPage {
    
    // CONSTANTS
    private static final String SETT_TARGET_DIR_HISTORY = ".targetDir.history"; //$NON-NLS-1$
    
    private static final int HISTORY_SIZE = 15;
    
    // VARIABLES
    /**
     * Whether the target group should be shown.
     */
    private boolean showTargetGroup = false;
    
    /**
     * Array of allowed file name extensions. Lower case with preceding dot.
     */
    private String[] extensions = null;
    
    // UI WIDGETS
    private ComboHistoryManager targetComboHistoryManager;
    
    
    /**
     * Constructs a new instance with the given name.
     * 
     * @param pageName name of the page. Used as part of the IDs the dialog
     *                 settings are saved as.
     * @param workspaceTargetGroup if {@code true}, a target group is created
     *                             where the user can select a folder in the
     *                             workspace to import to.
     * @param fileExtensions array of allowed file name extensions without
     *                       preceding dot. May be {@code null}.
     */
    public WorkspaceResourcesPage(final String pageName, final boolean workspaceTargetGroup,
            final String[] fileExtensions) {
        
        super(pageName);
        
        setTitle(Messages.WorkspaceResourcesPage_title);
        setMessage(Messages.WorkspaceResourcesPage_message);
        
        showTargetGroup = workspaceTargetGroup;
        
        // Save extensions
        if (fileExtensions != null) {
            extensions = new String[fileExtensions.length];
            
            for (int i = 0; i < fileExtensions.length; i++) {
                extensions[i] = fileExtensions[i].toLowerCase(); //$NON-NLS-1$
            }
        }
        
        // Initially, this page is incomplete
        setPageComplete(false);
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////
    // Result Extraction
    
    /**
     * Returns the selected files. This is a potentially long-running operation.
     * 
     * @param monitor progress monitor. May be {@code null}.
     * @return the list of selected files.
     */
    public List<IResource> getResources(final IProgressMonitor monitor) {
        Collection<Object> selection = getSelectedElements(monitor);
        List<IResource> files = new ArrayList<IResource>(selection.size());
        
        // Extract the files from all selection elements
        for (Object o : selection) {
            files.add((IResource) o);
        }
        
        return files;
    }
    
    /**
     * Returns the target container path entered by the user. The container might
     * not exist yet.
     * 
     * @return the container to import to.
     */
    public IPath getTargetContainerPath() {
        String s = getTargetGroupCombo().getText();
        IPath path = new Path(s);
        
        if (s.length() > 0) {
            path = path.makeAbsolute();
        }
        
        return path;
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////
    // UI Stuff
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void initializeControls() {
        setResourceTreeInput(ResourcesPlugin.getWorkspace().getRoot());
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////
    // Resources Group
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected ViewerFilter[] getResourceTreeFilters() {
        return new ViewerFilter[] {new ViewerFilter() {
            @Override
            public boolean select(final Viewer viewer, final Object parentElement,
                    final Object element) {
                
                return element instanceof IContainer;
            }
        } };
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected ViewerFilter[] getResourceListFilters() {
        if (extensions != null) {
            return new ViewerFilter[] {new ViewerFilter() {
                @Override
                public boolean select(final Viewer viewer, final Object parentElement,
                        final Object element) {
                    
                    if (element instanceof IFile) {
                        IFile file = (IFile) element;
                        String fileExtension = file.getFileExtension();
                        
                        // Iterate through the list of allowed file filters
                        for (String ext : extensions) {
                            if (fileExtension.equalsIgnoreCase(ext)) {
                                return true;
                            }
                        }
                    }
                    
                    return false;
                }
            } };
        } else {
            return new ViewerFilter[0];
        }
    }
    

    ///////////////////////////////////////////////////////////////////////////////
    // Source Group

    /**
     * {@inheritDoc}
     */
    @Override
    protected Composite createSourceGroup(final Composite parent) {
        // We don't need a source group
        return null;
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////
    // Target Group

    /**
     * {@inheritDoc}
     */
    @Override
    protected Composite createTargetGroup(final Composite parent) {
        if (!showTargetGroup) {
            return null;
        }
        
        // The default target group is fine for us
        Composite targetGroup = createDefaultTargetGroup(parent,
                Messages.WorkspaceResourcesPage_targetGroup_text,
                Messages.WorkspaceResourcesPage_targetGroup_browse);
        
        targetComboHistoryManager = new ComboHistoryManager(getTargetGroupCombo(), HISTORY_SIZE);
        
        return targetGroup;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void applyNewTarget(final String text) {
        // Manage history
        targetComboHistoryManager.recordAndDisplay(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doBrowseTarget() {
        // Find the current container, if any
        IPath currentPath = getTargetContainerPath();
        IContainer currentContainer = null;
        
        if (currentPath != null) {
            IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
            IResource resource = workspaceRoot.findMember(currentPath);
            
            if (resource instanceof IContainer) {
                currentContainer = (IContainer) resource;
            }
        }
        
        // Find a new container
        ContainerSelectionDialog dialog = new ContainerSelectionDialog(
                getShell(),
                currentContainer,
                true,
                Messages.WorkspaceResourcesPage_containerSelectionDialog_message);
        dialog.setTitle(Messages.WorkspaceResourcesPage_containerSelectionDialog_title);
        dialog.showClosedProjects(false);
        
        if (dialog.open() == Dialog.OK) {
            Object[] result = dialog.getResult();
            
            if (result != null && result.length == 1) {
                IPath newPath = (IPath) result[0];
                targetComboHistoryManager.recordAndDisplay(newPath.makeRelative().toString());
            }
        }
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////
    // Options Group

    /**
     * {@inheritDoc}
     */
    @Override
    protected Composite createOptionsGroup(final Composite parent) {
        // No options group
        return null;
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////
    // Validation

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean doValidate() {
        super.doValidate();
        
        // The user has to select at least something
        if (!isAnythingSelected()) {
            setErrorMessage(Messages.WorkspaceResourcesPage_errors_noFileSelected);
            return false;
        }
        
        // The user may have to select a target
        if (showTargetGroup) {
            if (getTargetGroupCombo().getText().trim().length() == 0) {
                setErrorMessage(Messages.WorkspaceResourcesPage_errors_noTargetSelected);
                return false;
            }
        }
        
        return true;
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////
    // Dialog Settings

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveDialogSettings() {
        if (showTargetGroup) {
            targetComboHistoryManager.saveHistory(getDialogSettings(),
                    getName() + SETT_TARGET_DIR_HISTORY);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void restoreDialogSettings() {
        if (showTargetGroup) {
            targetComboHistoryManager.restoreHistory(getDialogSettings(),
                    getName() + SETT_TARGET_DIR_HISTORY);
        }
    }
}
