/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui.caaa.l10n;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Image bundle for this plugin
 * 
 * @author <a href="mailto:cwu@informatik.uni-kiel.de">Christoph Wulf</a>
 * @author <a href="mailto:jhed@informatik.uni-kiel.de">Johannes Hedtrich</a> 
 */
public class CaaaPluginImages {

	/**
	 * The icons root directory.
	 */
	private static final String PREFIX_ROOT = "icons/obj16/"; //$NON-NLS-1$

	public static final ImageDescriptor DESC_AUTO_ARRANGE_ALL = create(PREFIX_ROOT
			+ "auto_arrange_all.png"); //$NON-NLS-1$

	/**
	 * Creates the image descriptor from the filename given.
	 * 
	 * @param imageName
	 *            the full filename of the image
	 * @return the new image descriptor
	 */
	private static ImageDescriptor create(String imageName) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(
				"de.cau.cs.kieler.kiml.ui", imageName);
	}
}
