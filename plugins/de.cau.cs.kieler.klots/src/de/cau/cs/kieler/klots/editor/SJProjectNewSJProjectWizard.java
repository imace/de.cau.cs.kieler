package de.cau.cs.kieler.klots.editor;

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


public class SJProjectNewSJProjectWizard extends Wizard implements INewWizard,
		IExecutableExtension {

	public final static String ID = "de.cau.cs.kieler.klots.editor.SJEditorNewSJProjectWizard";
	
	// the OS specific file separator char, e.g. '/' or '\'
	private final String OS_FILE_SEPARATOR = System.getProperty("file.separator");
	// the OS specific path separator char, e.g. ':' or ';'
	private final String OS_PATH_SEPARATOR = System.getProperty("path.separator");
	
	/*
	 * Use the WizardNewProjectCreationPage, which is provided by the Eclipse
	 * framework.
	 */
	private WizardNewProjectCreationPage wizardPage;

	private IConfigurationElement config;

	private IWorkbench workbench;

	private IStructuredSelection selection;

	private IProject project;

	/**
	 * Constructor
	 */
	public SJProjectNewSJProjectWizard() {
		super();
	}

	public void addPages() {
		/*
		 * Unlike the custom new wizard, we just add the pre-defined one and
		 * don't necessarily define our own.
		 */
		wizardPage = new WizardNewProjectCreationPage(
				"NewEmbeddedSJProject");
		wizardPage.setDescription("Enter a project name.");
		wizardPage.setTitle("Create a new Embedded SJ Project");
		addPage(wizardPage);
	}

	@Override
	public boolean performFinish() {

		if (project != null) {
			return true;
		}

		final IProject projectHandle = wizardPage.getProjectHandle();

		URI projectURI = (!wizardPage.useDefaults()) ? wizardPage
				.getLocationURI() : null;

		IWorkspace workspace = ResourcesPlugin.getWorkspace();

		final IProjectDescription desc = workspace
				.newProjectDescription(projectHandle.getName());

		desc.setLocationURI(projectURI);

		/*
		 * Just like the NewFileWizard, but this time with an operation object
		 * that modifies workspaces.
		 */
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
			protected void execute(IProgressMonitor monitor)
					throws CoreException {
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
			MessageDialog.openError(getShell(), "Error", realException
					.getMessage());
			return false;
		}

		project = projectHandle;

		if (project == null) {
			return false;
		}

		BasicNewProjectResourceWizard.updatePerspective(config);
		BasicNewProjectResourceWizard.selectAndReveal(project, workbench
				.getActiveWorkbenchWindow());

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
	void createProject(IProjectDescription description, IProject proj, IProgressMonitor monitor)
			throws CoreException, OperationCanceledException {
		try {
			String projectName = description.getName();
			monitor.beginTask("", 2000);
			proj.create(description, new SubProgressMonitor(monitor, 1000));
			if( monitor.isCanceled() ) {
				throw new OperationCanceledException();
			}
			proj.open(IResource.BACKGROUND_REFRESH, new SubProgressMonitor(monitor, 1000));

			/*
			 * Okay, now we have the project and we can do more things with it
			 * before updating the perspective.
			 */
			IContainer container = (IContainer) proj;
			
			String templatesPath = ".." + OS_FILE_SEPARATOR + ".." + OS_FILE_SEPARATOR +
			".." + OS_FILE_SEPARATOR + ".." + OS_FILE_SEPARATOR + ".." + OS_FILE_SEPARATOR +
			".." + OS_FILE_SEPARATOR + ".." + OS_FILE_SEPARATOR +
			"sj_templates" + OS_FILE_SEPARATOR + "";
			String examplesPath = "src" + OS_FILE_SEPARATOR + "examples";
			System.out.println("???????????>>>>>>>>>>> templates path = >" + templatesPath + "<");
			
			// FIXME: see if you can use IResource.copy() to copy all template files!
			// add src and bin folders, also add examples package to src
			final IFolder srcFolder = container.getFolder(new Path("src"));
			srcFolder.create(true, true, monitor);
			final IFolder binFolder = container.getFolder(new Path("bin"));
			binFolder.create(true, true, monitor);
			final IFolder examplesFolder = container.getFolder(new Path(examplesPath));
			examplesFolder.create(true, true, monitor);
			
			System.out.println("???????????>>>>>>>>>>>> src folder full path = >" + srcFolder.getLocation() + "<");
			
			InputStream resourceStream = this.getClass().getResourceAsStream(templatesPath + "embeddedSJ.jar");
			System.out.println("$$$$$$$$$$ EMBEDDED SJ PATH: " + this.getClass().getResource(templatesPath + "embeddedSJ.jar").getPath());
			addFileToProject(container, new Path("embeddedSJ.jar"), resourceStream, monitor);
			
			// --------------------------------------------------------------
			// XXX: NEW!
			resourceStream = this.getClass().getResourceAsStream(templatesPath + Path.SEPARATOR + "lejos" + Path.SEPARATOR + "classes.jar");
			addFileToProject(container, new Path("classes.jar"), resourceStream, monitor);
			// --------------------------------------------------------------
			
			resourceStream = this.getClass().getResourceAsStream(templatesPath + "EmbeddedABRO.java");
			addFileToProject(container, new Path(examplesPath + Path.SEPARATOR + "EmbeddedABRO.java"), resourceStream, monitor);
			
			// add the .execution file
			resourceStream = this.getClass().getResourceAsStream(templatesPath + "embeddedSJ.execution");
			addFileToProject(container, new Path("embeddedSJ.execution"), resourceStream, monitor);
			
			// add the .classpath file
			resourceStream = this.getClass().getResourceAsStream(templatesPath + ".classpath.resource");
			addFileToProject(container, new Path(".classpath"), resourceStream, monitor);
			
			resourceStream = this.getClass().getResourceAsStream(templatesPath + ".project.resource");
			
			// put the name of the new project in the .project file
			BufferedReader projectFile = new BufferedReader(new InputStreamReader(resourceStream));
			String projectFileContent = "";
			String projectFileLine = "";
			while( (projectFileLine = projectFile.readLine()) != null ) {
				if( projectFileLine.equals("<name></name>") ) {
					projectFileLine = "<name>" + projectName + "</name>";
				}
				projectFileContent += projectFileLine + "\n";
			}
			projectFile.close();
			resourceStream = new ByteArrayInputStream( projectFileContent.getBytes() );
			
			// add the adjusted .project file
			addFileToProject(container, new Path(".project"), resourceStream, monitor);
			
			resourceStream.close();		
			
		} catch(IOException ioe) {
			IStatus status = new Status(IStatus.ERROR, "NewSJProjectWizard", IStatus.OK,
					ioe.getLocalizedMessage(), null);
			System.out.println(ioe.getStackTrace());
			throw new CoreException(status);
		} finally {
			monitor.done();
		}
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		this.workbench = workbench;
	}

	
	/**
	 * Sets the initialization data for the wizard.
	 */
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		this.config = config;
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
	private void addFileToProject(IContainer container, Path path,
			InputStream contentStream, IProgressMonitor monitor)
			throws CoreException {
		final IFile file = container.getFile(path);

		if( file.exists() ) {
			file.setContents(contentStream, true, true, monitor);
		} else {
			file.create(contentStream, true, monitor);
		}
	}

}
