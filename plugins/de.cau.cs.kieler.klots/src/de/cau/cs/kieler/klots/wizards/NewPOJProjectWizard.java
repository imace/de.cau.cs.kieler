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
import java.net.URI;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.util.KlotsConstants;


/**
 * @author root
 *
 */
public class NewPOJProjectWizard extends Wizard implements INewWizard, IExecutableExtension {

    /**
     * 
     */
    public static final String ID = "de.cau.cs.kieler.klots.editor.NewEmbeddedJavaProjectWizard";

    // the OS specific file separator char, e.g. '/' or '\'
    private static final String OS_FILE_SEPARATOR = System.getProperty("file.separator");
    
    private static final int CREATE_PROJECT_TASK_TOTAL_TIME = 2000;

    /*
     * Use the WizardNewProjectCreationPage, which is provided by the Eclipse
     * framework.
     */
    private WizardNewProjectCreationPage wizardPage;
    private IConfigurationElement config;
    private IWorkbench workbench;
    private IProject project;

    
    /**
     * Constructor.
     */
    public NewPOJProjectWizard() {
        super();
    }

    
    
    /**
     * {@inheritDoc}
     */
    public void addPages() {
        /*
         * Unlike the custom new wizard, we just add the pre-defined one and
         * don't necessarily define our own.
         */
        wizardPage = new WizardNewProjectCreationPage(
        "NewEmbeddedJavaProject");
        wizardPage.setDescription("Enter a project name.");
        wizardPage.setTitle("Create a new Embedded Java Project");
        addPage(wizardPage);
    }

    
    
    @Override
    public boolean performFinish() {
        if (project != null) {
            return true;
        }
        final IProject projectHandle = wizardPage.getProjectHandle();
        URI projectURI = (!wizardPage.useDefaults()) ? wizardPage.getLocationURI() : null;
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final IProjectDescription desc = workspace.newProjectDescription(projectHandle.getName());
        desc.setLocationURI(projectURI);
        
        /*
         * Just like the NewFileWizard, but this time with an operation object
         * that modifies workspaces.
         */
        WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
            protected void execute(final IProgressMonitor monitor) throws CoreException {
                createProject(desc, projectHandle, monitor);
                }
            };
            
            /*
             * This isn't as robust as the code in the BasicNewProjectResourceWizard
             * class. Consider beefing this up to improve error handling.
             */
            try {
                getContainer().run(true, true, op);
            } catch (InterruptedException e) {
                return false;
            } catch (InvocationTargetException e) {
                Throwable realException = e.getTargetException();
                MessageDialog.openError(getShell(), "Error", realException.getMessage());
                return false;
            }
            
            project = projectHandle;
            if (project == null) {
                return false;
            }
            BasicNewProjectResourceWizard.updatePerspective(config);
            BasicNewProjectResourceWizard.selectAndReveal(project, workbench.getActiveWorkbenchWindow());
            
            return true;
    }

    
    
    /**
     * This creates the project in the workspace.
     * 
     * @param description
     * @param projectHandle
     * @param monitor
     * @throws CoreException
     * @throws OperationCanceledException
     */
    void createProject(final IProjectDescription description, final IProject proj,
            final IProgressMonitor monitor) throws CoreException {
        try {
            String projectName = description.getName();
            monitor.beginTask("", CREATE_PROJECT_TASK_TOTAL_TIME);
            proj.create(description,
                    new SubProgressMonitor(monitor, CREATE_PROJECT_TASK_TOTAL_TIME / 2));
            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }
            proj.open(IResource.BACKGROUND_REFRESH,
                    new SubProgressMonitor(monitor, CREATE_PROJECT_TASK_TOTAL_TIME / 2));

            /*
             * Okay, now we have the project and we can do more things with it
             * before updating the perspective.
             */
            IContainer container = (IContainer) proj;
            String templatesPath = KlotsPlugin.getDefault().getBundle().getEntry(
                    "/" + KlotsConstants.KLOTS_TEMPLATES_FOLDER_NAME).getPath();
            String examplesPath = "src" + OS_FILE_SEPARATOR + "examples";
            String projectSettingsPath = ".settings";
            System.out.println("???????????>>>>>>>>>>> templates path = >" + templatesPath + "<");

            // add src, bin and .settings folders, also add examples package to src
            final IFolder srcFolder = container.getFolder(new Path("src"));
            srcFolder.create(true, true, monitor);
            final IFolder binFolder = container.getFolder(new Path("bin"));
            binFolder.create(true, true, monitor);
            final IFolder projectSettingsFolder = container.getFolder(new Path(projectSettingsPath));
            projectSettingsFolder.create(true, true, monitor);
            final IFolder examplesFolder = container.getFolder(new Path(examplesPath));
            examplesFolder.create(true, true, monitor);

            System.out.println(
                    "???????????>>>>>>>>>>>> src folder full path = >" + srcFolder.getLocation() + "<");
            
            // add embeddedJava.jar
            InputStream resourceStream = this.getClass().getResourceAsStream(
                    templatesPath + KlotsConstants.KLOTS_TEMPLATES_EMBEDDED_JAVA_JAR_NAME);
            System.out.println("$$$$$$$$$$ EMBEDDED JAVA PATH: " + this.getClass().getResource(
                    templatesPath + KlotsConstants.KLOTS_TEMPLATES_EMBEDDED_JAVA_JAR_NAME).getPath());
            addFileToProject(container, new Path(KlotsConstants.KLOTS_TEMPLATES_EMBEDDED_JAVA_JAR_NAME),
                    resourceStream, monitor);
            
            // add lejos' classes.jar
            resourceStream = this.getClass().getResourceAsStream(
                    templatesPath + KlotsConstants.KLOTS_TEMPLATES_LEJOS_FOLDER_NAME
                    + Path.SEPARATOR + KlotsConstants.KLOTS_TEMPLATES_LEJOS_CLASSES_JAR_NAME);
            addFileToProject(container, new Path(KlotsConstants.KLOTS_TEMPLATES_LEJOS_CLASSES_JAR_NAME),
                    resourceStream, monitor);

            // add the .classpath file
            resourceStream = this.getClass().getResourceAsStream(
                    templatesPath + KlotsConstants.KLOTS_TEMPLATES_EMBEDDED_JAVA_CLASSPATH_FILE_NAME);
            addFileToProject(container, new Path(".classpath"), resourceStream, monitor);

            // add the .project file
            resourceStream = this.getClass().getResourceAsStream(
                    templatesPath + KlotsConstants.KLOTS_TEMPLATES_PROJECT_FILE_NAME);
            // put the name of the new project in the .project file
            BufferedReader projectFile = new BufferedReader(new InputStreamReader(resourceStream));
            String projectFileContent = "";
            String projectFileLine = "";
            while ((projectFileLine = projectFile.readLine()) != null) {
                if (projectFileLine.contains(KlotsConstants.KLOTS_TEMPLATES_PROJECT_FILE_NAME_OPEN_TAG
                        + KlotsConstants.KLOTS_TEMPLATES_PROJECT_FILE_NAME_CLOSE_TAG)) {
                    projectFileLine = projectFileLine.replace(
                            KlotsConstants.KLOTS_TEMPLATES_PROJECT_FILE_NAME_OPEN_TAG
                            + KlotsConstants.KLOTS_TEMPLATES_PROJECT_FILE_NAME_CLOSE_TAG,
                            KlotsConstants.KLOTS_TEMPLATES_PROJECT_FILE_NAME_OPEN_TAG + projectName
                            + KlotsConstants.KLOTS_TEMPLATES_PROJECT_FILE_NAME_CLOSE_TAG);
                }
                projectFileContent += projectFileLine + "\n";
            }
            projectFile.close();
            resourceStream = new ByteArrayInputStream(projectFileContent.getBytes());
            // add the adjusted .project file
            addFileToProject(container, new Path(".project"), resourceStream, monitor);
            
            // add project settings file ./settings/org.eclipse.jdt.core.prefs
            resourceStream = this.getClass().getResourceAsStream(
                    templatesPath + KlotsConstants.KLOTS_TEMPLATES_PROJECT_SETTINGS_FILE_NAME);
            addFileToProject(container,
                    new Path(projectSettingsPath + Path.SEPARATOR + "org.eclipse.jdt.core.prefs"),
                    resourceStream, monitor);

            resourceStream.close();

        } catch (IOException ioe) {
            IStatus status = new Status(IStatus.ERROR, "NewEmbeddedJavaProjectWizard", IStatus.OK,
                    ioe.getLocalizedMessage(), null);
            System.out.println(ioe.getStackTrace());
            throw new CoreException(status);
        } finally {
            monitor.done();
        }
    }


    
    /**
     * {@inheritDoc}
     */
    public void init(final IWorkbench wb, final IStructuredSelection sel) {
        this.workbench = wb;
    }


    
    /**
     * {@inheritDoc}
     */
    public void setInitializationData(final IConfigurationElement conf,
            final String propertyName, final Object data) throws CoreException {
        this.config = conf;
    }


    
    /**
     * Adds a new file to the project.
     * 
     * @param container 
     * @param path 
     * @param contentStream 
     * @param monitor 
     * @throws CoreException 
     */
    private void addFileToProject(final IContainer container, final Path path,
            final InputStream contentStream, final IProgressMonitor monitor) throws CoreException {
        final IFile file = container.getFile(path);
        if (file.exists()) {
            file.setContents(contentStream, true, true, monitor);
        } else {
            file.create(contentStream, true, monitor);
        }
    }

}