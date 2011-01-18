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

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

import de.cau.cs.kieler.core.ui.util.ComboHistoryManager;


/**
 * A wizard page that allows the user to choose files to import from the file system.
 * Optionally, a target group may allow the user to choose a target folder in the
 * workspace to import to.
 * 
 * @author cds
 */
public class FileSystemResourcesPage extends ResourceTreeAndListPage {
    
    /**
     * Provides the folder tree to the resource selection group.
     * 
     * @author cds
     */
    private static class FolderContentProvider implements ITreeContentProvider {
        /**
         * {@inheritDoc}
         */
        public void dispose() {
            // Nothing to be done here
        }
        
        /**
         * {@inheritDoc}
         */
        public void inputChanged(final Viewer viewer, final Object oldInput,
                final Object newInput) {
        }
        
        /**
         * {@inheritDoc}
         */
        public Object[] getElements(final Object inputElement) {
            if (inputElement instanceof ExtendedFileSystemElement) {
                return getChildren(inputElement);
            } else {
                return new Object[0];
            }
        }
        
        /**
         * {@inheritDoc}
         */
        public Object[] getChildren(final Object parentElement) {
            if (parentElement instanceof ExtendedFileSystemElement) {
                ExtendedFileSystemElement folderElement = (ExtendedFileSystemElement) parentElement;
                
                // Check if we have already visited this element
                if (!folderElement.isVisited()) {
                    File folder = folderElement.getFile();
                    File[] items = folder.listFiles();
                    
                    if (items != null) {
                        for (File item : items) {
                            new ExtendedFileSystemElement(item, folderElement);
                        }
                    }
                    
                    // We have now visited this element
                    folderElement.visit();
                }

                return folderElement.getFolders().getChildren();
            } else {
                return new Object[0];
            }
        }
        
        /**
         * {@inheritDoc}
         */
        public Object getParent(final Object element) {
            if (element instanceof ExtendedFileSystemElement) {
                return ((ExtendedFileSystemElement) element).getParent();
            } else {
                return null;
            }
        }
        
        /**
         * {@inheritDoc}
         */
        public boolean hasChildren(final Object element) {
            if (element instanceof ExtendedFileSystemElement) {
                // Check if we already know if this element has children
                ExtendedFileSystemElement folder = (ExtendedFileSystemElement) element;
                
                if (folder.isVisited()) {
                    return folder.isDirectory() && folder.getFolders().size() > 0;
                }
            }
            
            // For performance reason, every folder has children until we know better
            return true;
        }
    }
    
    
    /**
     * Provides the file list to the resource selection group. Only Ptolemy2 diagram
     * files are provided.
     * 
     * @author cds
     */
    private static class FileContentProvider implements ITreeContentProvider {
        /**
         * {@inheritDoc}
         */
        public void dispose() {
            // Nothing to be done here.
        }

        /**
         * {@inheritDoc}
         */
        public void inputChanged(final Viewer viewer, final Object oldInput,
                final Object newInput) {
            
            // Nothing to be done here
        }

        /**
         * {@inheritDoc}
         */
        public Object[] getElements(final Object inputElement) {
            if (inputElement instanceof ExtendedFileSystemElement) {
                ExtendedFileSystemElement folderElement = (ExtendedFileSystemElement) inputElement;
                
                // Check if we have already visited this element
                if (!folderElement.isVisited()) {
                    File folder = folderElement.getFile();
                    File[] items = folder.listFiles();
                    
                    if (items != null) {
                        for (File item : items) {
                            new ExtendedFileSystemElement(item, folderElement);
                        }
                    }
                    
                    // We have now visited this element
                    folderElement.visit();
                }

                return folderElement.getFiles().getChildren();
            } else {
                return new Object[0];
            }
        }

        /**
         * {@inheritDoc}
         */
        public Object[] getChildren(final Object parentElement) {
            return new Object[0];
        }

        /**
         * {@inheritDoc}
         */
        public Object getParent(final Object element) {
            return null;
        }

        /**
         * {@inheritDoc}
         */
        public boolean hasChildren(final Object element) {
            return false;
        }
        
    }
    
    
    // CONSTANTS
    private static final String SETT_SOURCE_DIR_HISTORY = ".sourceDir.history";
    private static final String SETT_TARGET_DIR_HISTORY = ".targetDir.history";
    
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
    private ComboHistoryManager sourceComboHistoryManager;
    private ComboHistoryManager targetComboHistoryManager;
    private DirectoryDialog directoryDialog;
    
    
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
    public FileSystemResourcesPage(final String pageName, final boolean workspaceTargetGroup,
            final String[] fileExtensions) {
        
        super(pageName);
        
        setTitle("Import from file system");
        setMessage("Select the files to import from the local file system.");
        
        showTargetGroup = workspaceTargetGroup;
        
        // Save extensions
        if (fileExtensions != null) {
            extensions = new String[fileExtensions.length];
            
            for (int i = 0; i < fileExtensions.length; i++) {
                extensions[i] = "." + fileExtensions[i].toLowerCase();
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
    public List<File> getFiles(final IProgressMonitor monitor) {
        Collection<Object> selection = getSelectedElements(monitor);
        List<File> files = new ArrayList<File>(selection.size());
        
        // Extract the files from all selection elements
        for (Object o : selection) {
            ExtendedFileSystemElement element = (ExtendedFileSystemElement) o;
            files.add(element.getFile());
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
    // Resources Group
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected ITreeContentProvider getResourceTreeContentProvider() {
        return new FolderContentProvider();
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
                    
                    String name =
                        ((ExtendedFileSystemElement) element).getFile().getName().toLowerCase();
                    
                    // Iterate through the list of allowed file filters
                    for (String extension : extensions) {
                        if (name.endsWith(extension)) {
                            return true;
                        }
                    }
                    
                    return false;
                }
            } };
        } else {
            return new ViewerFilter[0];
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ITreeContentProvider getResourceListContentProvider() {
        return new FileContentProvider();
    }
    

    ///////////////////////////////////////////////////////////////////////////////
    // Source Group
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected Composite createSourceGroup(final Composite parent) {
        // The default source group is fine for us
        Composite sourceGroup = createDefaultSourceGroup(parent,
                "From directory:",
                "Browse...");
        
        sourceComboHistoryManager = new ComboHistoryManager(getSourceGroupCombo(), HISTORY_SIZE);
        
        // Prepare the directory dialog used by the browse button
        directoryDialog = new DirectoryDialog(parent.getShell(), SWT.SAVE | SWT.SHEET);
        directoryDialog.setText("Select Directory");
        directoryDialog.setMessage("Select a directory to import from.");
        
        return sourceGroup;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void applyNewSource(final String text) {
        applyNewRootDir(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doBrowseSource() {
        applyNewRootDir(directoryDialog.open());
    }
    
    /**
     * Tries to apply the given directory as the new root directory. Also adds
     * it to the combo box's history.
     * 
     * @param newDir the new root directory.
     */
    private void applyNewRootDir(final String newDir) {
        if (newDir == null || newDir.trim().length() == 0) {
            return;
        }

        // Check if this is a directory
        File folder = new File(newDir);
        if (folder.exists() && folder.isDirectory()) {
            // Create a new ExtendedFileSystemElement
            ExtendedFileSystemElement newRoot = new ExtendedFileSystemElement(folder, null);
            
            // Update the combo box history and set its text
            sourceComboHistoryManager.recordAndDisplay(newDir);
            
            setResourceTreeInput(newRoot);
        } else {
            setResourceTreeInput(null);
        }
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
                "Into folder:",
                "Browse...");
        
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
                "Select a folder to import into.");
        dialog.setTitle("Select Workspace Folder");
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
            setErrorMessage("Select at least one file.");
            return false;
        }
        
        // The user may have to select a target
        if (showTargetGroup) {
            if (getTargetGroupCombo().getText().trim().length() == 0) {
                setErrorMessage("Specify a target folder.");
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
        sourceComboHistoryManager.saveHistory(getDialogSettings(),
                getName() + SETT_SOURCE_DIR_HISTORY);
        
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
        sourceComboHistoryManager.restoreHistory(getDialogSettings(),
                getName() + SETT_SOURCE_DIR_HISTORY);
        
        if (showTargetGroup) {
            targetComboHistoryManager.restoreHistory(getDialogSettings(),
                    getName() + SETT_TARGET_DIR_HISTORY);
        }
    }
}