package de.cau.cs.kieler.core.ui.examplewizard.wizard;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import de.cau.cs.kieler.core.ui.examplewizard.datacollector.ExampleExtensionPointDataRetriever;
import de.cau.cs.kieler.core.ui.examplewizard.util.Example;
import de.cau.cs.kieler.core.ui.examplewizard.util.ExampleFile;

/**
 * TODO Comment
 * 
 *
 */

public class ExampleNewWizard extends Wizard implements INewWizard {
	private ExampleNewWizardPage page;

	/**
	 * Constructor for ExampleNewWizard.
	 */
	public ExampleNewWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new ExampleNewWizardPage();
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in the wizard. We
	 * will create an operation and run it using wizard as execution context.
	 */
	public boolean performFinish() {
		final String projectName = page.getProjectName();
		final String id = page.getSelectedExampleID();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					doFinish(projectName, id, monitor);
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
			MessageDialog.openError(getShell(), "Error", realException
					.getMessage());
			return false;
		}

		return true;
	}

	/**
	 * The worker method. It will find the container, create the file if missing
	 * or just replace its contents, and open the editor on the newly created
	 * file.
	 */

	private void doFinish(String projectName, String id,
			IProgressMonitor monitor) throws CoreException {

		// create a sample file
		monitor.beginTask("Creating " + id, 2);
		List<Example> examples = ExampleExtensionPointDataRetriever.INSTANCE.getExamples();
		Example example = null;
		for (Example ex : examples) {
			if (ex.getId().equals(id)) {
				example = ex;
			}
		}

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		IProject project = root.getProject(projectName);
		project.create(monitor);
		project.open(monitor);

		List<ExampleFile> files = example.getFiles();
		for (ExampleFile f : files) {
			URL url = f.getURL();
			try {
				String[] path = url.getPath().split("/");
				InputStream stream = url.openStream();
				final IFile file = project.getFile(path[path.length - 1]);
				file.create(stream, true, monitor);
				stream.close();
				if (f.isShowInDefaultEditor()) {
					getShell().getDisplay().asyncExec(new Runnable() {
						public void run() {
							IWorkbenchPage page = PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getActivePage();
							try {
								IDE.openEditor(page, file, true);
							} catch (PartInitException e) {
							}
						}
					});
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (example.getAction() != null) {
			example.getAction().action();
		}

		/*
		 * 
		 * IResource resource = root.findMember(new Path(projectName)); if
		 * (!resource.exists() || !(resource instanceof IContainer)) {
		 * throwCoreException("Container \"" + projectName +
		 * "\" does not exist."); } IContainer container = (IContainer)
		 * resource; final IFile file = container.getFile(new Path(id)); try {
		 * InputStream stream = openContentStream(); if (file.exists()) {
		 * file.setContents(stream, true, true, monitor); } else {
		 * file.create(stream, true, monitor); } stream.close(); } catch
		 * (IOException e) { } monitor.worked(1);
		 * monitor.setTaskName("Opening file for editing...");
		 * getShell().getDisplay().asyncExec(new Runnable() { public void run()
		 * { IWorkbenchPage page = PlatformUI.getWorkbench()
		 * .getActiveWorkbenchWindow().getActivePage(); try {
		 * IDE.openEditor(page, file, true); } catch (PartInitException e) { } }
		 * }); monitor.worked(1);
		 */
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

}