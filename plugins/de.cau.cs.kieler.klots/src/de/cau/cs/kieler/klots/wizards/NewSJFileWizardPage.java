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
package de.cau.cs.kieler.klots.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

import de.cau.cs.kieler.klots.util.KlotsConstants;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (java).
 * 
 * @author root
 */
public class NewSJFileWizardPage extends WizardPage {
    
    private static final int LAYOUT_NR_CELL_COLUMNS = 3;
    private static final int LAYOUT_VERTICAL_SPACING = 9;
    
    private Text containerText;
    private Text fileText;
    private ISelection selection;

    
    
    /**
     * Constructor for SampleNewWizardPage.
     * 
     * @param selection 
     */
    public NewSJFileWizardPage(final ISelection selection) {
        super("NewSJFileWizardPage");
        setTitle("Create a new Embedded Synchronous Java (SJ) file");
        setDescription("Creates a new Embedded Synchronous Java (SJ) file");
        this.selection = selection;
    }

    
    
    /**
     * {@inheritDoc}
     */
    public void createControl(final Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = LAYOUT_NR_CELL_COLUMNS;
        layout.verticalSpacing = LAYOUT_VERTICAL_SPACING;
        Label label = new Label(container, SWT.NULL);
        label.setText("&Project:");

        containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        containerText.setLayoutData(gd);
        containerText.addModifyListener(new ModifyListener() {
            public void modifyText(final ModifyEvent e) {
                dialogChanged();
            }
        });

        Button button = new Button(container, SWT.PUSH);
        button.setText("Browse...");
        button.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(final SelectionEvent e) {
                handleBrowse();
            }
        });
        label = new Label(container, SWT.NULL);
        label.setText("&File name:");

        fileText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        fileText.setLayoutData(gd);
        fileText.addModifyListener(new ModifyListener() {
            public void modifyText(final ModifyEvent e) {
                dialogChanged();
            }
        });
        initialize();
        dialogChanged();
        setControl(container);
    }

    
    
    /**
     * Tests if the current workbench selection is a suitable container to use.
     */
    private void initialize() {
        if (selection != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
            IStructuredSelection ssel = (IStructuredSelection) selection;
            if (ssel.size() > 1) {
                return;
            }
            Object obj = ssel.getFirstElement();

            if (obj instanceof IPackageFragment) {
                try {
                    obj = ((IPackageFragment) obj).getCorrespondingResource();
                } catch (JavaModelException e) {
                    e.printStackTrace();
                }
            }

            if (obj instanceof IResource) {
                IContainer container;
                if (obj instanceof IContainer) {
                    container = (IContainer) obj;
                } else {
                    container = ((IResource) obj).getParent();
                }
                containerText.setText(container.getFullPath().toString());
            }
        }
        fileText.setText("SJFile." + KlotsConstants.SJ_FILE_NAME_EXTENSION);
    }

    
    
    /**
     * Uses the standard container selection dialog to choose the new value for
     * the container field.
     */
    private void handleBrowse() {
        ContainerSelectionDialog dialog = new ContainerSelectionDialog(
                getShell(),
                ResourcesPlugin.getWorkspace().getRoot(),
                false,
                "Select a parent SJ project");
        if (dialog.open() == ContainerSelectionDialog.OK) {
            Object[] result = dialog.getResult();
            if (result.length == 1) {
                containerText.setText(((Path) result[0]).toString());
            }
        }
    }

    
    
    /**
     * Ensures that both text fields are set.
     */
    private void dialogChanged() {
        IResource container =
            ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(getContainerName()));
        String fileName = getFileName();
        
        if (getContainerName().length() == 0) {
            updateStatus("Parent SJ project must be specified");
            return;
        }
        if (container == null || (container.getType() & (IResource.PROJECT | IResource.FOLDER)) == 0) {
            updateStatus("Parent SJ project and parent package must exist");
            return;
        }
        if (!getContainerName().contains(Path.SEPARATOR + "src" + Path.SEPARATOR)) {
            updateStatus("A new file can only be created inside a package in the src folder");
            return;
        }
        if (getContainerName().endsWith(Path.SEPARATOR + "src")
                || getContainerName().endsWith(Path.SEPARATOR + "src" + Path.SEPARATOR)) {
            updateStatus("A package must be specified");
            return;
        }
        if (!container.isAccessible()) {
            updateStatus("Project must be writable");
            return;
        }
        if (fileName.length() == 0) {
            updateStatus("File name must be specified");
            return;
        }
        if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
            updateStatus("File name must be valid");
            return;
        }
        int dotLoc = fileName.lastIndexOf('.');
        if (dotLoc != -1) {
            String ext = fileName.substring(dotLoc + 1);
            if (!ext.equalsIgnoreCase(KlotsConstants.SJ_FILE_NAME_EXTENSION)) {
                updateStatus("File extension must be \"" + KlotsConstants.SJ_FILE_NAME_EXTENSION + "\"");
                return;
            }
        }
        updateStatus(null);
    }

    
    
    private void updateStatus(final String message) {
        setErrorMessage(message);
        setPageComplete(message == null);
    }

    
    
    /**
     * @return String 
     */
    public String getContainerName() {
        return containerText.getText();
    }
    
    
    
    /**
     * @param name  
     */
    public void setContainerName(final String name) {
        containerText.setText(name);
    }

    
    
    /**
     * @return String 
     */
    public String getFileName() {
        return fileText.getText();
    }
    
}