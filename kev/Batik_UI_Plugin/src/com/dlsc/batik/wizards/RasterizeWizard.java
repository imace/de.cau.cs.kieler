/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.dlsc.batik.wizards;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.dlsc.batik.viewer.BatikUIPlugin;
import com.dlsc.batik.viewer.Messages;
/**
 * Standard workbench wizard for exporting resources from the workspace to the
 * local file system.
 * <p>
 * This class may be instantiated and used without further configuration; this
 * class is not intended to be subclassed.
 * </p>
 * <p>
 * Example:
 * 
 * <pre>
 *  IWizard wizard = new FileSystemExportWizard();
 *  wizard.init(workbench, selection);
 *  WizardDialog dialog = new WizardDialog(shell, wizard);
 *  dialog.open();
 * </pre>
 * 
 * During the call to <code>open</code>, the wizard dialog is presented to
 * the user. When the user hits Finish, the user-selected workspace resources
 * are exported to the user-specified location in the local file system, the
 * dialog closes, and the call to <code>open</code> returns.
 * </p>
 */
public class RasterizeWizard extends Wizard implements IExportWizard {
	private IStructuredSelection selection;
	private RasterizeWizardPage1 mainPage;
	private RasterizeWizardPage2 optionsPage;
	/**
	 * Creates a wizard for exporting workspace resources to the local file
	 * system.
	 */
	public RasterizeWizard() {
		BatikUIPlugin plugin = BatikUIPlugin.getDefault();		
		IDialogSettings workbenchSettings = plugin.getDialogSettings();
		
		IDialogSettings section = workbenchSettings
				.getSection("RasterFileSystemExportWizard");//$NON-NLS-1$
		if (section == null)
			section = workbenchSettings.addNewSection("RasterFileSystemExportWizard");//$NON-NLS-1$
		setDialogSettings(section);
	}
	/*
	 * (non-Javadoc) Method declared on IWizard.
	 */
	public void addPages() {
		super.addPages();
		mainPage = new RasterizeWizardPage1(selection);
		optionsPage = new RasterizeWizardPage2();
		addPage(mainPage);
		addPage(optionsPage);
	}
	/**
	 * Returns the image descriptor with the given relative path.
	 */
	private ImageDescriptor getImageDescriptor(String relativePath) {
		String iconPath = "icons/full/";//$NON-NLS-1$	
		try {
			AbstractUIPlugin plugin = BatikUIPlugin.getDefault();
			URL installURL = plugin.getBundle().getEntry("/"); //$NON-NLS-1$
			URL url = new URL(installURL, iconPath + relativePath);
			return ImageDescriptor.createFromURL(url);
		} catch (MalformedURLException e) {
			// Should not happen
			return null;
		}
	}
	/*
	 * (non-Javadoc) Method declared on IWorkbenchWizard.
	 */
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		this.selection = currentSelection;
		List selectedResources = IDE.computeSelectedResources(currentSelection);
		if (!selectedResources.isEmpty()) {
			this.selection = new StructuredSelection(selectedResources);
		}
		// look it up if current selection (after resource adapting) is empty
		if (selection.isEmpty() && workbench.getActiveWorkbenchWindow() != null) {
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
					.getActivePage();
			if (page != null) {
				IEditorPart currentEditor = page.getActiveEditor();
				if (currentEditor != null) {
					Object selectedResource = currentEditor.getEditorInput()
							.getAdapter(IResource.class);
					if (selectedResource != null) {
						selection = new StructuredSelection(selectedResource);
					}
				}
			}
		}
		setWindowTitle(Messages.getString("RasterizeWizard.EXPORT")); //$NON-NLS-1$
		setDefaultPageImageDescriptor(getImageDescriptor("wizban/exportdir_wiz.gif"));//$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}
	/*
	 * (non-Javadoc) Method declared on IWizard.
	 */
	public boolean performFinish() {
		try {
			LinkedList options = optionsPage.getOptions();
			String suffix = optionsPage.getSuffix();
			return mainPage.finish(options,suffix);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
