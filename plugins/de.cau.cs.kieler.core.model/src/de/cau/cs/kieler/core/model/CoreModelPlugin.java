/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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
package de.cau.cs.kieler.core.model;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.internal.statushandlers.StatusHandlerDescriptor;
import org.eclipse.ui.internal.statushandlers.StatusHandlerRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.statushandlers.AbstractStatusHandler;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osgi.framework.BundleContext;

import de.cau.cs.kieler.core.model.util.ModelErrorHandler;
import de.cau.cs.kieler.core.ui.errorhandler.GenericErrorHandler;
import de.cau.cs.kieler.core.ui.errorhandler.GenericErrorHandler.StatusListener;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author mim
 */
@SuppressWarnings("restriction")
public class CoreModelPlugin extends AbstractUIPlugin {

    /** The plug-in ID. **/
    public static final String PLUGIN_ID = "de.cau.cs.kieler.core.model";

    /** The shared instance. **/
    private static CoreModelPlugin plugin;

    private static ModelErrorHandler errorHandler;

    /** Logging instance. **/
    private ILog logger;

    /**
     * The constructor.
     */
    public CoreModelPlugin() {
        logger = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        logger = getLog();
        GraphicalFrameworkService.start();
        errorHandler = new ModelErrorHandler();
        addErrorListener(errorHandler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop(final BundleContext context) throws Exception {
        removeErrorListener(errorHandler);
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance.
     * 
     * @return the shared instance
     */
    public static CoreModelPlugin getDefault() {
        return plugin;
    }

    /**
     * Creates a warning message for the CoreModel plug-in.
     * 
     * @param message
     *            The warning to log
     */
    public void logWarning(final String message) {
        if (logger != null) {
            logger.log(new Status(IStatus.WARNING, CoreModelPlugin.PLUGIN_ID,
                    message));
        }
    }

    /**
     * Creates an error message for the CoreModel plug-in.
     * 
     * @param message
     *            The error message
     */
    public void logError(final String message) {
        if (logger != null) {
            logger.log(new Status(IStatus.ERROR, CoreModelPlugin.PLUGIN_ID,
                    message));
        }
    }

    /**
     * Creates an info message for the CoreModel plug-in.
     * 
     * @param message
     *            The info message
     */
    public void logInfo(final String message) {
        if (logger != null) {
            logger.log(new Status(IStatus.INFO, CoreModelPlugin.PLUGIN_ID,
                    message));
        }
    }

    /**
     * Getter for KIELERs generic error errorHandler.
     * 
     * @return the error errorHandler or null
     */
    public static GenericErrorHandler getErrorHandler() {
        try {
            StatusHandlerDescriptor desc = StatusHandlerRegistry.getDefault()
                    .getDefaultHandlerDescriptor();
            if (desc != null) {
                AbstractStatusHandler handler = desc.getStatusHandler();
                if (handler instanceof GenericErrorHandler) {
                    return (GenericErrorHandler) handler;
                }
            }
        } catch (CoreException exception) {
            StatusManager.getManager().handle(exception, PLUGIN_ID);
        } catch (IllegalStateException exception) {
            // the workbench has not been initialized yet
            StatusManager.getManager().handle(new Status(Status.ERROR, PLUGIN_ID,
                    "Unable to retrieve the generic error handler.", exception));
        }
        return null;
    }

    /**
     * Add a new listener to the generic error errorHandler.
     * 
     * @param listener
     *            the new listener
     */
    public static void addErrorListener(final StatusListener listener) {
        GenericErrorHandler handler = getErrorHandler();
        if (handler != null) {
            handler.addListener(listener);
        }
    }

    /**
     * Remove a listener from the generic error errorHandler.
     * 
     * @param listener
     *            the new listener
     */
    public static void removeErrorListener(final StatusListener listener) {
        GenericErrorHandler handler = getErrorHandler();
        if (handler != null) {
            handler.removeListener(listener);
        }
    }
}
