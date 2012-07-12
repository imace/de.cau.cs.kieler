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

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.util.KlotsConstants;

/**
 * This is a sample new wizard. Its role is to create a new file 
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace 
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "java". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 * 
 * @author root
 */

public class NewPOJFileWizard extends Wizard implements INewWizard {

    /**
     * 
     */
    public static final String ID = "de.cau.cs.kieler.klots.editor.NewEmbeddedJavaFileWizard";

    // the OS specific file separator char, e.g. '/' or '\'
    //private static final String OS_FILE_SEPARATOR = System.getProperty("file.separator");

    private NewPOJFileWizardPage page;
    private ISelection selection;

    
    
    /**
     * Constructor for SampleNewWizard.
     */
    public NewPOJFileWizard() {
        super();
        setNeedsProgressMonitor(true);
    }

    
    
    /**
     * Adding the page to the wizard.
     */
    public void addPages() {
        page = new NewPOJFileWizardPage(selection);
        addPage(page);
    }

    
    
    /**
     * This method is called when 'Finish' button is pressed in
     * the wizard. We will create an operation and run it
     * using wizard as execution context.
     * 
     * @return boolean 
     */
    public boolean performFinish() {
        final String containerName = page.getContainerName();
        final String fileName = page.getFileName();
        IRunnableWithProgress op = new IRunnableWithProgress() {
            public void run(final IProgressMonitor monitor) throws InvocationTargetException {
                try {
                    doFinish(containerName, fileName, monitor);
                } catch (CoreException e) {
                    throw new InvocationTargetException(e);
                } finally {
                    monitor.done();
                }
            }
        };
        try {
            getContainer().run(true, false, op);
        } catch (InterruptedException e) {
            return false;
        } catch (InvocationTargetException e) {
            Throwable realException = e.getTargetException();
            MessageDialog.openError(getShell(), "Error", realException.getMessage());
            return false;
        }
        return true;
    }

    
    
    /**
     * The worker method. It will find the container, create the
     * file if missing or just replace its contents, and open
     * the editor on the newly created file.
     */
    private void doFinish(final String containerName, final String fileName,
           final IProgressMonitor monitor) throws CoreException {
        // create a sample file
        monitor.beginTask("Creating " + fileName, 2);
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IResource resource = root.findMember(new Path(containerName));
        if (!resource.exists() || !(resource instanceof IContainer)) {
            throwCoreException("Embedded Java project \"" + containerName + "\" does not exist.");
        }
        IContainer container = (IContainer) resource;
        final IFile file = container.getFile(new Path(fileName));
        try {
            InputStream stream = openContentStream(containerName, fileName);
            if (file.exists()) {
                file.setContents(stream, true, true, monitor);
            } else {
                file.create(stream, true, monitor);
            }
            stream.close();
//            PlatformUI.getWorkbench().getEditorRegistry().setDefaultEditor(fileName, KlotsEditor.ID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        monitor.worked(1);
        monitor.setTaskName("Opening file for editing...");
        getShell().getDisplay().asyncExec(new Runnable() {
            public void run() {
                IWorkbenchPage wPage =
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                try {
                    IDE.openEditor(wPage, file, KlotsPlugin.getKlotsEditorID(), true);
                    //IDE.openEditor(page, file, true);
                } catch (PartInitException e) {
                    e.printStackTrace();
                }
            }
        });
        monitor.worked(1);
    }

    
    
    /**
     * We will initialize file contents with a sample text.
     * 
     * @param projectName 
     * @param fileName 
     * @return InputStream 
     */
    protected static InputStream openContentStream(final String projectName, final String fileName) {
        try {
            String templatesPath = KlotsPlugin.getDefault().getBundle().getEntry(
                    "/" + KlotsConstants.KLOTS_TEMPLATES_FOLDER_NAME).getPath();
            InputStream resourceStream = NewPOJFileWizard.class.getResourceAsStream(
                    templatesPath + KlotsConstants.KLOTS_TEMPLATES_NEW_EMBEDDED_JAVA_FILE_NAME);
            // adjust package and class tags
            BufferedReader projectFile = new BufferedReader(new InputStreamReader(resourceStream));
            String projectFileContent = "";
            String projectFileLine = "";
            while ((projectFileLine = projectFile.readLine()) != null) {
                if (projectFileLine.contains(KlotsConstants.KLOTS_TEMPLATES_CLASS_TAG)) {
                    projectFileLine = projectFileLine.replace(KlotsConstants.KLOTS_TEMPLATES_CLASS_TAG,
                            fileName.replace(
                                    "." + KlotsConstants.EMBEDDED_JAVA_FILE_NAME_EXTENSION, ""));
                }
                if (projectFileLine.contains(KlotsConstants.KLOTS_TEMPLATES_PACKAGE_TAG)) {
                    String packageName = projectName.replaceFirst(".*/src/", "");  // note the second '/'
                    // if the file is not in a package, ignore the 'package <A PACKAGE>' line
                    if (packageName.equals(projectName) || packageName.equals("")) {
                        projectFileLine = "";
                        continue;
                    }
                    packageName = packageName.replace('/', '.');
                    projectFileLine = projectFileLine.replace(
                            KlotsConstants.KLOTS_TEMPLATES_PACKAGE_TAG, packageName);
                }
                projectFileContent += projectFileLine + "\n";
            }
            projectFile.close();
            resourceStream = new ByteArrayInputStream(projectFileContent.getBytes());
            return resourceStream;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
    
    private void throwCoreException(final String message) throws CoreException {
        IStatus status =
            new Status(IStatus.ERROR, "NewEmbeddedJavaFileWizard", IStatus.OK, message, null);
        throw new CoreException(status);
    }

    
    
    /**
     * {@inheritDoc}
     */
    public void init(final IWorkbench workbench, final IStructuredSelection sel) {
        this.selection = sel;
    }
    
}