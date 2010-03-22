package de.cau.cs.kieler.core.ui.examplewizard.wizard;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;
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

import de.cau.cs.kieler.core.ui.examplewizard.util.Example;
import de.cau.cs.kieler.core.ui.examplewizard.util.ExampleFile;

/**
 * TODO Comments
 * 
 * 
 */
public class ExampleNewWizard extends Wizard implements INewWizard {

	/** The BundleChooserPage */
	private BundleChooserPage bundleChooser;

	/** The ExampleChooserPage */
	private ExampleChooserPage exampleChooser;

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
		setWindowTitle("Example Wizard");
		this.bundleChooser = new BundleChooserPage();
		addPage(this.bundleChooser);
		this.exampleChooser = new ExampleChooserPage();
		addPage(this.exampleChooser);
	}

	/**
	 * This method is called when 'Finish' button is pressed in the wizard. We
	 * will create an operation and run it using wizard as execution context.
	 */
	public boolean performFinish() {
		final String projectName = bundleChooser.getProjectName();
		final List<Example> examples = exampleChooser.getSelectedExamples();

		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					doFinish(projectName, examples, monitor);
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
	private void doFinish(String projectName, List<Example> examples,
			IProgressMonitor monitor) throws CoreException {
		try {
			// create a sample file
			monitor.beginTask("Creating examples", 2);

			// getting the project
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject(projectName);
			project.create(monitor);
			project.open(monitor);

			// installing the examples
			for (Example example : examples) {
				project.setPersistentProperty(new QualifiedName(example.getId(), "Example"), example.getVersion());
				List<ExampleFile> files = example.getFiles();
				// getting ZIP file
				String packageName = example.getPackageName();
				URL url = new URL(packageName);
				final IFile tempZip = project.getFile("temp.zip");
				tempZip.create(url.openStream(), true, null);
				ZipFile zipFile = new ZipFile(new File(tempZip.getLocation()
						.toOSString()));
				// installing files
				for (ExampleFile exampleFile : files) {
					ZipEntry zipEntry = zipFile.getEntry(exampleFile.getFile());
					if (zipEntry != null) {
						String target = exampleFile.getTargetFolder();
						if (target != null && !target.equals("")) {
							target = "/" + target;
							IFolder folder = project.getFolder(target);
							if (!folder.exists()) {
								folder.create(true, true, null);
							}
						} else {
							target = "";
						}
						target += "/" + exampleFile.getFile();
						final IFile newFile = project.getFile(target);
						newFile.create(zipFile.getInputStream(zipEntry), true,
								monitor);

						// Code has problem, files not shown...
						if (exampleFile.isShowInDefaultEditor()) {
							getShell().getDisplay().asyncExec(new Runnable() {
								public void run() {
									IWorkbenchPage page = PlatformUI
											.getWorkbench()
											.getActiveWorkbenchWindow()
											.getActivePage();
									try {
										IDE.openEditor(page, newFile, true);
									} catch (PartInitException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							});
						}
					}
				}
				zipFile.close();
				tempZip.delete(true, null);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
	}
}