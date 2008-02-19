/*
 * Created on 08.03.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dlsc.batik.wizards;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.osgi.framework.Bundle;

import com.dlsc.batik.viewer.BatikUIPlugin;
import com.dlsc.batik.viewer.Messages;

/**
 * @author dlemmermann
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SampleProjectWizard extends Wizard implements INewWizard {
	private SampleProjectWizardPage page;
	
	/**
	 * 
	 */
	public SampleProjectWizard() {
		super();
		addPage(page = new SampleProjectWizardPage());
		page.setInitialProjectName(Messages.getString("SampleProjectWizard.INITIAL_PROJECT_NAME")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#performFinish()
	 */
	public boolean performFinish() {
		final IProject handle = page.getProjectHandle();
		try {
			getContainer().run(false,false, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					try {
						handle.create(null,monitor);
						handle.open(monitor);
						loadSamples(handle,monitor);
					} catch (CoreException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (Exception e) {
			page.setErrorMessage(e.getLocalizedMessage());
			return false;
		}
		return true;
	}

	private void loadSamples(IProject project, IProgressMonitor monitor) throws Exception {
		Bundle bundle = BatikUIPlugin.getDefault().getBundle();
		Path path = new Path("samples"); //$NON-NLS-1$
		URL url = Platform.find(bundle, path);
		url = Platform.resolve(url);
		File file = new File(url.getFile());
		int max = countFiles(file,0);
		monitor.beginTask(Messages.getString("SampleProjectWizard.TASK_NAME"),max); //$NON-NLS-1$
		loadSampleDir(file,project,monitor);
	}
	
	private int countFiles(File file, int count) {
		File[] children = file.listFiles();
		if (children != null) {
			int l = children.length;
			for (int i=0;i<l;i++) {
				if (children[i].isDirectory()) {
					count = countFiles(children[i],count);
				} else {
					count++;
				}
			}
		}
		
		return  count;
	}
	
	/**
	 * @param file
	 * @param project
	 */
	private void loadSampleDir(File dir, IContainer project, IProgressMonitor monitor) throws Exception {
		File[] files = dir.listFiles();
		if (files != null) {
			int l = files.length;
			for (int i=0;i<l;i++) {
				String name = files[i].getName();
				if (files[i].isDirectory()) {
					IFolder folder = project.getFolder(new Path(name));
					folder.create(true,true,null);
					loadSampleDir(files[i],folder,monitor);
				} else {
					InputStream stream = new FileInputStream(files[i]);
					IFile f = project.getFile(new Path(name));
					f.create(stream,true,null);
					monitor.worked(1);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
	}
}
