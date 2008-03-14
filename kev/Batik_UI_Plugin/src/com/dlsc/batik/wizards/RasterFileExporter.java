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
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

// TODO: repair
//import org.apache.batik.apps.rasterizer.Main;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;

/**
 * Helper class for exporting resources to the file system.
 */
class RasterFileExporter {
	private String format = RasterFormat.JPEG;
	private LinkedList optionsList;
	private String suffix;
	
	public RasterFileExporter(String f) {
		format = f;
	}
	
	public void setOptions(LinkedList options) {
		optionsList = options;
	}
	
	public void setSuffix(String str) {
		suffix = str;
	}
	
	/**
	 * Creates the specified file system directory at <code>destinationPath</code>.
	 * This creates a new file system directory.
	 */
	public void createFolder(IPath destinationPath) {
		boolean success = new File(destinationPath.toOSString()).mkdir();
		trace("Folder creation successful: " + success);
	}
	/**
	 * Writes the passed resource to the specified location recursively
	 */
	public void write(IResource resource, IPath destinationPath)
			throws CoreException, IOException {
		trace("Writing RESOURCE to path: " + destinationPath.toString());
		if (resource.getType() == IResource.FILE)
			writeFile((IFile) resource, destinationPath);
		else
			writeChildren((IContainer) resource, destinationPath);
	}
	/**
	 * Exports the passed container's children
	 */
	protected void writeChildren(IContainer folder, IPath destinationPath)
			throws CoreException, IOException {
		if (folder.isAccessible()) {
			IResource[] children = folder.members();
			for (int i = 0; i < children.length; i++) {
				IResource child = children[i];
				writeResource(child, destinationPath.append(child.getName()));
			}
		}
	}
	protected void writeFile(IFile file, IPath destinationPath)
			throws IOException, CoreException {
		trace("Writing FILE to path: " + destinationPath.toString());
				
		try {
			Thread.currentThread().setContextClassLoader(getClass().getClassLoader());

			LinkedList clonedList = (LinkedList) optionsList.clone();
			
			clonedList.add("-d"); //$NON-NLS-1$
			clonedList.add(destinationPath.removeFileExtension().toOSString() + suffix);
			clonedList.add(file.getRawLocation().toString());
			
			int s = clonedList.size();
			String[] args = new String[s];
			for (int i=0;i<s;i++) {
				args[i] = (String) clonedList.get(i);
				trace(args[i]);
			}
			
//			Main main = new Main(args);
//			main.execute();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	/**
	 * Writes the passed resource to the specified location recursively
	 */
	protected void writeResource(IResource resource, IPath destinationPath)
			throws CoreException, IOException {
		if (resource.getType() == IResource.FILE)
			writeFile((IFile) resource, destinationPath);
		else {
			createFolder(destinationPath);
			writeChildren((IContainer) resource, destinationPath);
		}
	}
	
	private static void trace(String s) {
		String option = Platform.getDebugOption("com.dlsc.batik.ui/debug/rasterizing");
		if (option != null && option.equals("true")) { //$NON-NLS-1$
			System.out.println(s);
		}
	}

}
