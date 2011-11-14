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

import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PerspectiveAdapter;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import de.cau.cs.kieler.klots.editor.KlotsEditor;
import de.cau.cs.kieler.klots.util.ColorProvider;
import de.cau.cs.kieler.klots.util.KlotsConstants;
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
            System.err.println("====== EXCEPTION WHILE TRYING TO SET SYSTEM PROPERTY 'nxt.home' ======");
            e.printStackTrace();
            System.err.println("======================================================================");
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

}