/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klots;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import de.cau.cs.kieler.klots.views.SJInstructionsView;

/**
 * 
 * @author ybe
 */
public class KlotsPlugin extends AbstractUIPlugin {
	/** The Constant PLUGIN_ID. */
	public static final String PLUGIN_ID = "de.cau.cs.kieler.klots";
	
	/** The plugin. */
	private static KlotsPlugin plugin;

	/**
	 * The constructor of the ABRO plug-in.
	 */
	public KlotsPlugin() {
	}

	/**
	 * {@inheritDoc}
	 */
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * {@inheritDoc}
	 */
	public void stop(final BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance of this plug-in.
	 * 
	 * @return the shared instance
	 */
	public static KlotsPlugin getDefault() {
		return plugin;
	}

	/**
	 * @return SJInstructionsView the SJ instructions view instance.
	 */
	public static SJInstructionsView getSJInstructionsView() {
		return de.cau.cs.kieler.klots.views.SJInstructionsView.getInstance();
	}

	/**
	 * @return String the KLOTS editor ID.
	 */
	public static String getKlotsEditorID() {
		return de.cau.cs.kieler.klots.editor.KlotsEditor.ID;
	}

}