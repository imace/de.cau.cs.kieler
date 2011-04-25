package de.cau.cs.kieler.klots.editor;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.operation.*;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;
import java.io.*;

import org.eclipse.ui.*;
import org.eclipse.ui.ide.IDE;

import de.cau.cs.kieler.klots.KlotsPlugin;

/**
 * This is a sample new wizard. Its role is to create a new file 
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace 
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "java". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 */

public class SJProjectNewFileWizard extends Wizard implements INewWizard {
	
	public final static String ID = "de.cau.cs.kieler.klots.editor.SJEditorNewFileWizard"; 
	
	// the OS specific file separator char, e.g. '/' or '\'
	private final static String OS_FILE_SEPARATOR = System.getProperty("file.separator");
	
	private SJEditorNewFileWizardPage page;
	private ISelection selection;

	/**
	 * Constructor for SampleNewWizard.
	 */
	public SJProjectNewFileWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new SJEditorNewFileWizardPage(selection);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		final String containerName = page.getContainerName();
		final String fileName = page.getFileName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
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

	private void doFinish(
		String containerName,
		String fileName,
		IProgressMonitor monitor)
		throws CoreException {
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(new Path(containerName));
		if (!resource.exists() || !(resource instanceof IContainer)) {
			throwCoreException("SJ project \"" + containerName + "\" does not exist.");
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
		} catch (IOException e) {
		}
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page =
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, KlotsPlugin.getSJEditorID(), true);
					//IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
	}
	
	
	/**
	 * We will initialize file contents with a sample text.
	 */

	protected static InputStream openContentStream(String projectName, String fileName) {
		try {
			String templatesPath = ".." + OS_FILE_SEPARATOR + ".." + OS_FILE_SEPARATOR +
			".." + OS_FILE_SEPARATOR + ".." + OS_FILE_SEPARATOR + ".." + OS_FILE_SEPARATOR +
			".." + OS_FILE_SEPARATOR + ".." + OS_FILE_SEPARATOR +
			"sj_templates" + OS_FILE_SEPARATOR + "";
			InputStream resourceStream = NewPOJFileWizard.class.getResourceAsStream(templatesPath + "SJTemplate.java");
			// adjust package and class tags
			BufferedReader projectFile = new BufferedReader(new InputStreamReader(resourceStream));
			String projectFileContent = "";
			String projectFileLine = "";
			while( (projectFileLine = projectFile.readLine()) != null ) {
				if( projectFileLine.contains("<CLASS>") ) {
					projectFileLine = projectFileLine.replace( "<CLASS>", fileName.replace(".java", "") );
				}
				if( projectFileLine.contains("<PACKAGE>") ) {
					String packageName = projectName.replaceFirst(".*/src/", "");
					packageName = packageName.replace('/', '.');
					projectFileLine = projectFileLine.replace( "<PACKAGE>", packageName );
				}
				projectFileContent += projectFileLine + "\n";
			}
			projectFile.close();
			resourceStream = new ByteArrayInputStream( projectFileContent.getBytes() );
			return resourceStream;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, "NewSJFileWizard", IStatus.OK, message, null);
		throw new CoreException(status);
	}

	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}