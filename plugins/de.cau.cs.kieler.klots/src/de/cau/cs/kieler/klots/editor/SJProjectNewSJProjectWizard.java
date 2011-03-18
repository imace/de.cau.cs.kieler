package de.cau.cs.kieler.klots.editor;

import java.io.IOException;
import java.io.InputStream;
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

/**
 * Creates a new project containing folders and files for use with an
 * Example.com enterprise web site.
 * 
 * @author Nathan A. Good &lt;mail@nathanagood.com&gt;
 * 
 */
public class SJProjectNewSJProjectWizard extends Wizard implements INewWizard,
		IExecutableExtension {

	PathLibrary pathLibrary = PathLibrary.getInstance();
	
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
				"NewExampleComSiteProject");
		wizardPage.setDescription("Enter a progect name.");
		wizardPage.setTitle("Create an Embedded SJ Project");
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
	void createProject(IProjectDescription description, IProject proj,
			IProgressMonitor monitor) throws CoreException,
			OperationCanceledException {
		try {

			monitor.beginTask("", 2000);

			proj.create(description, new SubProgressMonitor(monitor, 1000));

			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}

			proj.open(IResource.BACKGROUND_REFRESH, new SubProgressMonitor(
					monitor, 1000));

			/*
			 * Okay, now we have the project and we can do more things with it
			 * before updating the perspective.
			 */
			IContainer container = (IContainer) proj;

			/* Add an XHTML file */
//			addFileToProject(container, new Path("index.html"),
//					SJProjectNewFileWizard.openContentStream("Welcome to "
//							+ proj.getName()), monitor);
//			addFileToProject(container, new Path("testFile.js"),
//					SJProjectNewFileWizard.openContentStream(), monitor );
//
//			/* Add the style folder and the site.css file to it */
//			final IFolder styleFolder = container.getFolder(new Path("styles"));
//			styleFolder.create(true, true, monitor);
//			
//			InputStream resourceStream = this.getClass().getResourceAsStream(
//			"./EmbeddedABRO.resource");
//
//			addFileToProject(container, new Path(styleFolder.getName()
//					+ Path.SEPARATOR + "EmbABRO.js"),
//					resourceStream, monitor);
//
//			resourceStream.close();
			
			// ##############################################################
			
			String sjPath = ".." + Path.SEPARATOR + ".." + Path.SEPARATOR +
			".." + Path.SEPARATOR + ".." + Path.SEPARATOR +
			".." + Path.SEPARATOR + ".." + Path.SEPARATOR +
			"sj_templates" + Path.SEPARATOR + "sj" + Path.SEPARATOR + "";
			String dest = "sj" + Path.SEPARATOR + "";
			
			final IFolder sjFolder = container.getFolder(new Path("sj"));
			sjFolder.create(true, true, monitor);
			InputStream resStream = this.getClass().getResourceAsStream(sjPath + "CombinationFunction.java");
			System.out.println("$$$$$$$$$$ RESOURCE PATH: " + this.getClass().getResource(sjPath + "CombinationFunction.java").getPath());
			addFileToProject(container, new Path(dest + "CombinationFunction.java"), resStream, monitor); 
			resStream = this.getClass().getResourceAsStream(sjPath + "CombinationFunction.java");
			addFileToProject(container, new Path(dest + "CombinationFunction.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "CombinationFunction$1.java");
			addFileToProject(container, new Path(dest + "CombinationFunction$1.java"), resStream, monitor);			
			resStream = this.getClass().getResourceAsStream(sjPath + "CombinationFunction$2.java");
			addFileToProject(container, new Path(dest + "CombinationFunction$2.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "CombinationFunction$3.java");
			addFileToProject(container, new Path(dest + "CombinationFunction$3.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "CombinationFunction$4.java");
			addFileToProject(container, new Path(dest + "CombinationFunction$4.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "EmbeddedPCLogger.java");
			addFileToProject(container, new Path(dest + "EmbeddedPCLogger.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "EmbeddedSJProgram.java");
			addFileToProject(container, new Path(dest + "EmbeddedSJProgram.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "Signal.java");
			addFileToProject(container, new Path(dest + "Signal.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "SignalConverter.java");
			addFileToProject(container, new Path(dest + "SignalConverter.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "SimpleLogger.java");
			addFileToProject(container, new Path(dest + "SimpleLogger.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "SJLogger.java");
			addFileToProject(container, new Path(dest + "SJLogger.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "SJLogger$LogMsgTyp.java");
			addFileToProject(container, new Path(dest + "SJLogger$LogMsgTyp.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "SJThread.java");
			addFileToProject(container, new Path(dest + "SJThread.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "ValuedSignal.java");
			addFileToProject(container, new Path(dest + "ValuedSignal.java"), resStream, monitor);
			final IFolder sjExceptionsFolder = container.getFolder(new Path("sj" + Path.SEPARATOR + "exceptions"));
			sjExceptionsFolder.create(true, true, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "exceptions" + Path.SEPARATOR + "CausalityException.java");
			addFileToProject(container, new Path(dest + "exceptions" + Path.SEPARATOR + "CausalityException.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "exceptions" + Path.SEPARATOR + "CurTickAlreadyDoneException.java");
			addFileToProject(container, new Path(dest + "exceptions" + Path.SEPARATOR + "CurTickAlreadyDoneException.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "exceptions" + Path.SEPARATOR + "CurTickNotDoneException.java");
			addFileToProject(container, new Path(dest + "exceptions" + Path.SEPARATOR + "CurTickNotDoneException.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "exceptions" + Path.SEPARATOR + "NoPreSignalException.java");
			addFileToProject(container, new Path(dest + "exceptions" + Path.SEPARATOR + "NoPreSignalException.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "exceptions" + Path.SEPARATOR + "PriorityException.java");
			addFileToProject(container, new Path(dest + "exceptions" + Path.SEPARATOR + "PriorityException.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "exceptions" + Path.SEPARATOR + "ProgramAlreadyTerminatedException.java");
			addFileToProject(container, new Path(dest + "exceptions" + Path.SEPARATOR + "ProgramAlreadyTerminatedException.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "exceptions" + Path.SEPARATOR + "SignalAlreadyDeclaredException.java");
			addFileToProject(container, new Path(dest + "exceptions" + Path.SEPARATOR + "SignalAlreadyDeclaredException.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "exceptions" + Path.SEPARATOR + "SignalNotDeclaredException.java");
			addFileToProject(container, new Path(dest + "exceptions" + Path.SEPARATOR + "SignalNotDeclaredException.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "exceptions" + Path.SEPARATOR + "ThreadException.java");
			addFileToProject(container, new Path(dest + "exceptions" + Path.SEPARATOR + "ThreadException.java"), resStream, monitor);
			final IFolder sjUtilFolder = container.getFolder(new Path("sj" + Path.SEPARATOR + "util"));
			sjUtilFolder.create(true, true, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "util" + Path.SEPARATOR + "AbstractCollection.java");
			addFileToProject(container, new Path(dest + "util" + Path.SEPARATOR + "AbstractCollection.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "util" + Path.SEPARATOR + "AbstractCollection$1.java");
			addFileToProject(container, new Path(dest + "util" + Path.SEPARATOR + "AbstractCollection$1.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "util" + Path.SEPARATOR + "AbstractCollection$Iter.java");
			addFileToProject(container, new Path(dest + "util" + Path.SEPARATOR + "AbstractCollection$Iter.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "util" + Path.SEPARATOR + "ContainerWithLink.java");
			addFileToProject(container, new Path(dest + "util" + Path.SEPARATOR + "ContainerWithLink.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "util" + Path.SEPARATOR + "LinkedList.java");
			addFileToProject(container, new Path(dest + "util" + Path.SEPARATOR + "LinkedList.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "util" + Path.SEPARATOR + "PriorityQueue.java");
			addFileToProject(container, new Path(dest + "util" + Path.SEPARATOR + "PriorityQueue.java"), resStream, monitor);
			final IFolder sjExamplesFolder = container.getFolder(new Path("sj" + Path.SEPARATOR + "examples"));
			sjExamplesFolder.create(true, true, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "examples" + Path.SEPARATOR + "EmbeddedABRO.java");
			addFileToProject(container, new Path(dest + "examples" + Path.SEPARATOR + "EmbeddedABRO.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "examples" + Path.SEPARATOR + "EmbeddedABROMain.java");
			addFileToProject(container, new Path(dest + "examples" + Path.SEPARATOR + "EmbeddedABROMain.java"), resStream, monitor);
			resStream = this.getClass().getResourceAsStream(sjPath + "examples" + Path.SEPARATOR + "EmbeddedABROMain2.java");
			addFileToProject(container, new Path(dest + "examples" + Path.SEPARATOR + "EmbeddedABROMain2.java"), resStream, monitor);
			resStream.close();
			
			// ##############################################################

			// GET NEW PROJECT PATH
			IFile file = container.getFile(new Path("./SJProjectNewSJProjectWizard.java"));
			String projectPath = file.getLocationURI().getPath();
			projectPath = projectPath.substring(0, projectPath.lastIndexOf('/'));
			String projectName = projectPath.substring( projectPath.lastIndexOf('/')+1, projectPath.length() );
			pathLibrary.addToLibrary(projectName, new Path(projectPath).toOSString() );
			System.out.println("###>>> FILE PATH SET TO: " + pathLibrary.getProjectPath(projectName));
			
			// ##############################################################
			
//			System.out.println("!!!! -> PATH = " + System.getProperty("user.dir"));
//			URL url = this.getClass().getResource("./");
//			System.out.println("!!!! -> PATH2 = " + url);
//			System.out.println("!!!! -> PATH3 = " + url.getPath());
//			Path path = new Path("./");
//			System.out.println("!!!! -> PATH4 = " + path.toOSString());
//			
//			/*
//			 * Add the images folder, which is an official Exmample.com standard
//			 * for static web projects.
//			 */
//			IFolder imageFolder = container.getFolder(new Path("images"));
//			imageFolder.create(true, true, monitor);
			
		} catch (IOException ioe) {
			IStatus status = new Status(IStatus.ERROR, "NewFileWizard", IStatus.OK,
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

		if (file.exists()) {
			file.setContents(contentStream, true, true, monitor);
		} else {
			file.create(contentStream, true, monitor);
		}
	}

}
