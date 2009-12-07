/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.xkev;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 *  
 * @author Stephan Knauer (skn) - skn[at]informatik.uni-kiel.de
 *  
 */
public class Activator extends AbstractUIPlugin {

    /**
     * The plug-in ID.
     */
    public static final String PLUGIN_ID = "de.cau.cs.kieler.xkev";

    /**
     *  The shared instance.
     */
    private static Activator plugin;

    /**
     * The constructor.
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance.
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

    /**
     * Returns an image descriptor for the image file at the given plug-in relative path.
     * 
     * @param path
     *            the path
     * @return the image descriptor
     */
    public ImageDescriptor getImageDescriptor(final String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }
    
    /**
     * Reports an error message to the eclipse Error Log.
     * @param message The message that describes the error.
     */
    public static void reportErrorMessage(final String message) {
        Status myStatus = new Status(IStatus.ERROR, PLUGIN_ID, message);
        StatusManager.getManager().handle(myStatus, StatusManager.LOG);
    }
    
    /**
     * Reports an error message to the eclipse Error Log, with an exception e.
     * @param message The message that describes the error.
     * @param e The exception which should be reported.
     */
    public static void reportErrorMessage(final String message, final Exception e) {
        Status myStatus = new Status(IStatus.ERROR, PLUGIN_ID, message, e);
        StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
    }
    
    /**
     * Only logs messages for debugging. (use Eclipse -consoleLog) for displaying debug messages.
     * @param message The message that describes the error.
     */
    public static void reportDebugMessage(final String message) {
        Status myStatus = new Status(IStatus.INFO, PLUGIN_ID, message);
        StatusManager.getManager().handle(myStatus, StatusManager.LOG);
    }

    /**
     * Only logs messages for debugging. (use Eclipse -consoleLog) for displaying debug messages.
     * @param message The message that describes the error.
     */
    public static void reportInfoMessage(final String message) {
        Status myStatus = new Status(IStatus.INFO, PLUGIN_ID, message);
        StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
        StatusManager.getManager().handle(myStatus, StatusManager.LOG);
    }    
    
}
