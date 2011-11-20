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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PerspectiveAdapter;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osgi.framework.BundleContext;

import de.cau.cs.kieler.klots.editor.KlotsEditor;
import de.cau.cs.kieler.klots.util.ColorProvider;
import de.cau.cs.kieler.klots.util.KlotsConstants;
import de.cau.cs.kieler.klots.views.SJInstructionsView;
import de.cau.cs.kieler.sim.kiem.KiemPlugin;

/**
 * 
 * @author ybe
 */
public class KlotsPlugin extends AbstractUIPlugin {
    
    /** The Constant PLUGIN_ID. */
    public static final String PLUGIN_ID = "de.cau.cs.kieler.klots";

    /** The plugin. */
    private static KlotsPlugin plugin;
    
    
    /** The color provider. */
    private static ColorProvider colorProvider;
    /**
     * The system editor for Embedded Java files (currently *.java files)
     * before the KLOTS perspective has been activated.
     */
    private static IEditorDescriptor systemEmbeddedJavaFileEditor;
    /**
     * The system editor for Synchronous Java (SJ) files (currently *.java files)
     * before the KLOTS perspective has been activated.
     */
    private static IEditorDescriptor systemSJFileEditor;

    
    
    /**
     * The constructor of the ABRO plug-in.
     */
    public KlotsPlugin() {
    }


        
    /**
     * {@inheritDoc}
     */
    public void start(final BundleContext context) throws Exception {
        System.out.println("\n#######################################################################");
        System.out.println("######################## STARTING KLOTS PLUGIN ########################");
        System.out.println("#######################################################################\n");
        super.start(context);
        plugin = this;
        // create color provider
        colorProvider = new ColorProvider(getPreferenceStore());
        // add KLOTS perspective listener
        addKlotsPerspectiveListener();
        
        String nxjHome = Platform.getInstallLocation().getURL().getPath();
        try {
            String prevVal = System.setProperty("nxj.home", nxjHome);
            System.out.println("|%|%|%|%|%|%|%|%| >>> setting 'nxj.home' to: >" + nxjHome + "<");
            System.out.println("|%|%|%|%|%|%|%|%| >>> previous value ot 'nxj.home': >" + prevVal + "<");
        } catch (SecurityException e) {
            System.err.println("===== EXCEPTION WHILE TRYING TO SET SYSTEM PROPERTY 'nxt.home' =====");
            e.printStackTrace();
            System.err.println("====================================================================");
        }
    }



    /**
     * {@inheritDoc}
     */
    public void stop(final BundleContext context) throws Exception {
        plugin = null;
        // dispose color provider
        colorProvider.dispose();
        super.stop(context);
        System.out.println("\n#######################################################################");
        System.out.println("######################## KLOTS PLUGIN STOPPED #########################");
        System.out.println("#######################################################################\n");
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
     * @return ColorProvider the color provider.
     */
    public static ColorProvider getColorProvider() {
        return colorProvider;
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
    
    
    
    /**
     * Adds a new KLOTS perspective listener.
     */
    private void addKlotsPerspectiveListener() {
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().addPerspectiveListener(
                new PerspectiveAdapter() {
                    public void perspectiveActivated(final IWorkbenchPage page,
                            final IPerspectiveDescriptor perspective) {
                        super.perspectiveActivated(page, perspective);
                        if (perspective.getId().equals(KlotsPerspective.ID)) {
                            System.out.println("|%|%|%|%|%|%|%|%| >>> Setting the default editor for "
                                    + "Embedded Java files (*."
                                    + KlotsConstants.EMBEDDED_JAVA_FILE_NAME_EXTENSION + ") "
                                    + "and SJ files (*." + KlotsConstants.SJ_FILE_NAME_EXTENSION + ") "
                                    + "to be the to be the KLOTS Editor: " + KlotsEditor.ID + "!");
                            if (systemEmbeddedJavaFileEditor == null) {
                                systemEmbeddedJavaFileEditor = PlatformUI.getWorkbench()
                                        .getEditorRegistry().getDefaultEditor("*."
                                            + KlotsConstants.EMBEDDED_JAVA_FILE_NAME_EXTENSION);
                            }
                            if (systemSJFileEditor == null) {
                                systemSJFileEditor = PlatformUI.getWorkbench().getEditorRegistry()
                                        .getDefaultEditor("*." + KlotsConstants.SJ_FILE_NAME_EXTENSION);
                            }
                            PlatformUI.getWorkbench().getEditorRegistry().setDefaultEditor(
                                    "*." + KlotsConstants.EMBEDDED_JAVA_FILE_NAME_EXTENSION,
                                    KlotsEditor.ID);
                            PlatformUI.getWorkbench().getEditorRegistry().setDefaultEditor(
                                    "*." + KlotsConstants.SJ_FILE_NAME_EXTENSION,
                                    KlotsEditor.ID);
                        }
                        
                    }
                    public void perspectiveDeactivated(final IWorkbenchPage page,
                            final IPerspectiveDescriptor perspective) {
                        super.perspectiveActivated(page, perspective);
                        if (perspective.getId().equals(KlotsPerspective.ID)) {
                            System.out.println("|%|%|%|%|%|%|%|%| >>> Setting the default editors for "
                                    + "Embedded Java files (*."
                                    + KlotsConstants.EMBEDDED_JAVA_FILE_NAME_EXTENSION + ") "
                                    + "and SJ files (*." + KlotsConstants.SJ_FILE_NAME_EXTENSION + ") "
                                    + "to be the system default editors: "
                                    + systemEmbeddedJavaFileEditor.getId() + " and "
                                    + systemSJFileEditor.getId() + "!");
                            PlatformUI.getWorkbench().getEditorRegistry().setDefaultEditor(
                                    "*." + KlotsConstants.EMBEDDED_JAVA_FILE_NAME_EXTENSION,
                                    systemEmbeddedJavaFileEditor.getId());
                            PlatformUI.getWorkbench().getEditorRegistry().setDefaultEditor(
                                    "*." + KlotsConstants.SJ_FILE_NAME_EXTENSION,
                                    systemSJFileEditor.getId());
                            systemEmbeddedJavaFileEditor = null;
                            systemSJFileEditor = null;
                        }
                    }
                }
        );
    }
    
    
    
    // ############################################################################################

    private String getErrorWarningMessage(final String textMessage, final String pluginID,
                                          final Exception exception) {
        String message = "";

        if (textMessage != null) {
            message = textMessage + message;
        } else if (exception != null) {
            message = exception.getMessage() + message;
        }

        // do not post the same message twice
        if ((exception != null) && (textMessage != null)
            && (exception.getMessage().startsWith(textMessage))) {
            message = "" + pluginID + "";
        } else {
            message += " (" + pluginID + ")";
        }
        return message;
    }

    
    
    private String getPluginID(final String textMessage, final String pluginID,
            final Exception exception) {
        String pluginID2 = null;
        if (pluginID == null) {
            pluginID2 = KiemPlugin.PLUGIN_ID;
        } else {
            pluginID2 = pluginID;
        }
        return pluginID2;
    }


    
    /**
     * Shows a warning dialog using the StatusAdapter. This dialog will *NOT* be modal, so that the
     * user is notified but the current work is not interrupted. <BR>
     * Additionally the information will be logged in the error log so that the user has the
     * opportunity to e.g., access the error stack trace. The plug-in id is required, textMessage
     * and exception are optional.
     * 
     * @param textMessage
     *            the text message
     * @param pluginID
     *            the plug-in id
     * @param exception
     *            the exception
     * @param silent
     *            the silent tag indicates that only logging occurs, no message dialog is displayed
     */
    public void showWarning(final String textMessage, final String pluginID,
                            final Exception exception, final boolean silent) {
        try {
            String message = getErrorWarningMessage(textMessage, pluginID, exception);
            String pluginID2 = getPluginID(textMessage, pluginID, exception);

            IStatus status;
            if ((exception == null) || (exception instanceof RuntimeException)) {
                status = new Status(IStatus.WARNING, pluginID2, IStatus.WARNING, message, exception);
            } else {
                try {
                    status = new Status(
                            IStatus.WARNING, pluginID2, IStatus.WARNING, message, exception.getCause());
                } catch (Exception e) {
                    status = new Status(
                            IStatus.WARNING, pluginID2, IStatus.WARNING, message, exception);
                }
            }

            StatusAdapter statusAdapter = new StatusAdapter(status);
            statusAdapter.setProperty(
                    IStatusAdapterConstants.TIMESTAMP_PROPERTY, System.currentTimeMillis());

            // use status manager (log and (optionally) show)
            if (!silent) {
                StatusManager.getManager().handle(
                        statusAdapter, StatusManager.LOG | StatusManager.SHOW);
            } else {
                StatusManager.getManager().handle(statusAdapter, StatusManager.LOG);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
    /**
     * Shows an error dialog using the StatusAdapter. This dialog will be modal, so that the user
     * has to click OK to end it. Additionally the information will be logged in the error log so
     * that the user has the opportunity to e.g., access the error stack trace. The plug-in id is
     * required, textMessage and exception are optional.
     * 
     * @param textMessage
     *            the optional text message
     * @param pluginID
     *            the plug-in id
     * @param exception
     *            the exception if any, null otherwise
     * @param silent
     *            the silent tag indicates that only logging occurs, no message dialog is displayed
     */
    public void showError(final String textMessage, final String pluginID,
                          final Exception exception, final boolean silent) {
        try {
            String message = getErrorWarningMessage(textMessage, pluginID, exception);
            String pluginID2 = getPluginID(textMessage, pluginID, exception);

            IStatus status;
            if ((exception == null) || (exception instanceof RuntimeException)) {
                status = new Status(IStatus.ERROR, pluginID2, IStatus.ERROR, message, exception);
            } else {
                try {
                    status = new Status(
                            IStatus.ERROR, pluginID2, IStatus.ERROR, message, exception.getCause());
                } catch (Exception e) {
                    status = new Status(IStatus.ERROR, pluginID2, IStatus.ERROR, message, exception);
                }
            }

            StatusAdapter statusAdapter = new StatusAdapter(status);
            statusAdapter.setProperty(
                    IStatusAdapterConstants.TIMESTAMP_PROPERTY, System.currentTimeMillis());

            // use status manager (log and show)
            // BLOCK = modal window, force the user to act!
            // use status manager (log and (optionally) show)
            if (!silent) {
                StatusManager.getManager().handle(
                        statusAdapter, StatusManager.BLOCK | StatusManager.LOG | StatusManager.SHOW);
            } else {
                StatusManager.getManager().handle(statusAdapter, StatusManager.LOG);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}