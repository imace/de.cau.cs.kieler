/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Christoph Wulf, cwu@informatik.uni-kiel.de
 *         Johannes Hedtrich, jhed@informatik.uni-kiel.de
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.ui.caaa.l10n;

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
				"edu.unikiel.rtsys.kieler.kiml.ui", imageName);
	}
}
