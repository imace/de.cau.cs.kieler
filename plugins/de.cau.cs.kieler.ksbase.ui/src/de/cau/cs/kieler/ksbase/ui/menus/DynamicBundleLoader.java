/**
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
 * 
 *****************************************************************************/
package de.cau.cs.kieler.ksbase.ui.menus;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.core.runtime.ContributorFactoryOSGi;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.packageadmin.PackageAdmin;

import de.cau.cs.kieler.ksbase.core.EditorTransformationSettings;

/**
 * The dynamic bundle loader class. This class contains lists of bundles which
 * are loaded when a specific editor is activated. The bundle data is generated
 * by the {@link DynamicMenuContributions} class.
 * 
 * @author Michael Matzen - mim AT informatik.uni-kiel.de
 * 
 */
public final class DynamicBundleLoader implements IWindowListener, IPartListener {

    /** Instance of this class. **/
    public static final DynamicBundleLoader INSTANCE = new DynamicBundleLoader();

    /** List of bundles waiting for activation. **/
    private HashMap<EditorTransformationSettings, URI> waitingBundles;

    /** List of activated bundles. **/
    private HashMap<EditorTransformationSettings, Bundle> activeBundles;

    /** Is the part listener already registered ? **/
    private boolean isPartListener;

    /** Private constructor. **/
    private DynamicBundleLoader() {
        waitingBundles = new HashMap<EditorTransformationSettings, URI>();
        activeBundles = new HashMap<EditorTransformationSettings, Bundle>();
        isPartListener = false;
    }

    /**
     * Adding a bundle to the queue.
     * 
     * @param editor
     *            The editor to add
     * @param bundlePath
     *            The URI to the bundle path
     */
    public void addBundle(final EditorTransformationSettings editor, final URI bundlePath) {
        // System.out.println("adding " + editor.getEditor() + " to queue");
        waitingBundles.put(editor, bundlePath);
    }

    /**
     * Activates all pending bundles without caring of active editors. This is
     * used for debugging purposes while the open editor bug is fixed.
     * 
     */
    public void activateAllEditors() {
        for (EditorTransformationSettings editor : waitingBundles.keySet().toArray(
                new EditorTransformationSettings[waitingBundles.keySet().size()])) {
            checkForWaitingEditor(editor.getEditor());
        }
    }

    /**
     * Checks if a given editor has pending activations.
     * 
     * The method is marked as synchronized to avoid concurrent modification
     * exceptions when two events appear at the same time.
     * 
     * @param activeEditor
     *            The editor class name to check
     */
    public synchronized void checkForWaitingEditor(final String activeEditor) {
        // System.out.println("Checking for " + activeEditor);
        HashMap<EditorTransformationSettings, Bundle> installedBundles =
                new HashMap<EditorTransformationSettings, Bundle>();

        for (Entry<EditorTransformationSettings, URI> entry : waitingBundles.entrySet()) {
            EditorTransformationSettings editor = entry.getKey();
            if (editor.getEditor().equals(activeEditor)) {
                // Create bundle with jar archive
                Bundle bundle = ContributorFactoryOSGi.resolve(editor.getContributor());
                // System.out.println("activating ksbase for" + activeEditor);
                String editorDiagramName = "";
                if (editor.getEditor().contains(".")) {
                    editorDiagramName =
                            editor.getEditor().substring(editor.getEditor().lastIndexOf(".") + 1);
                } else {
                    editorDiagramName = editor.getEditor();
                }

                try {
                    // To avoid %20 exceptions in paths
                    String val = entry.getValue().toString().replace("%20", " ");
                    URL url = new URL("reference:" + val);

                    InputStream in = url.openStream();

                    Bundle b = bundle.getBundleContext().installBundle(editorDiagramName, in);
                    // b.start();
                    // Activating bundle with package admin service
                    ServiceReference ref =
                            bundle.getBundleContext().getServiceReference(
                                    PackageAdmin.class.getName());
                    PackageAdmin admin = (PackageAdmin) bundle.getBundleContext().getService(ref);

                    boolean res = admin.resolveBundles(new Bundle[] {b });
                    if (!res) {
                        System.out.println("Error while resolving bundle " + b);
                    }
                    installedBundles.put(editor, b);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BundleException e) {
                    e.printStackTrace();
                }
            }

        }
        // remove installed bundles from map
        for (Entry<EditorTransformationSettings, Bundle> entry : installedBundles.entrySet()) {
            activeBundles.put(entry.getKey(), entry.getValue());
            waitingBundles.remove(entry.getKey());
        }

    }

    /**
     * A window has been activated. If the editor has an active page and editor
     * the bundles are checked
     * 
     * @param window
     *            The activated window
     */
    public void windowActivated(final IWorkbenchWindow window) {
        // System.out.println("window act");
        if (window.getActivePage() != null && window.getActivePage().getActiveEditor() != null) {
            String activeEditor =
                    window.getActivePage().getActiveEditor().getClass().getCanonicalName();
            checkForWaitingEditor(activeEditor);
        }
    }

    /**
     * A window has been closed. We are ignoring this event
     * 
     * @param window
     *            The closed window
     */
    public void windowClosed(final IWorkbenchWindow window) {
        // Nothing
    }

    /**
     * A window has been deactivated. We are ignoring this event
     * 
     * @param window
     *            The deactivated window
     */
    public void windowDeactivated(final IWorkbenchWindow window) {
        // Nothing
    }

    /**
     * A window has been opened. If the editor has an active page and editor the
     * bundles are checked
     * 
     * @param window
     *            The opened window
     */
    public void windowOpened(final IWorkbenchWindow window) {
        // System.out.println("win open");
        if (window.getActivePage() != null && window.getActivePage().getActiveEditor() != null) {
            String activeEditor =
                    window.getActivePage().getActiveEditor().getClass().getCanonicalName();
            checkForWaitingEditor(activeEditor);
            // If the part listener is not activated, do it now:
            if (!isPartListener) {
                window.getActivePage().addPartListener(this);
            }
        }
    }

    /**
     * A workbench part has been activated and needs to be checked against the
     * waiting editors.
     * 
     * @param part
     *            The activated part.
     */
    public void partActivated(final IWorkbenchPart part) {
        // System.out.println("part act");
        if (part.getClass() != null && part.getClass().getCanonicalName() != null) {
            checkForWaitingEditor(part.getClass().getCanonicalName());
        }
    }

    /**
     * A workbench part has been brought to top. We are ignoring this event.
     * 
     * @param part
     *            The activated part.
     */
    public void partBroughtToTop(final IWorkbenchPart part) {
        // Nothing
    }

    /**
     * A workbench part has been closed. We are ignoring this event.
     * 
     * @param part
     *            The closed part
     */
    public void partClosed(final IWorkbenchPart part) {
        // Nothing
    }

    /**
     * A workbench part has been deactivated. We are ignoring this event.
     * 
     * @param part
     *            The deactivated part
     */
    public void partDeactivated(final IWorkbenchPart part) {
        // Nothing
    }

    /**
     * A workbench part has been opened. We are checking the opened part against
     * the waiting bundles
     * 
     * @param part
     *            The opened part
     */

    public void partOpened(final IWorkbenchPart part) {
        // System.out.println("part open");
        if (part.getClass() != null && part.getClass().getCanonicalName() != null) {
            checkForWaitingEditor(part.getClass().getCanonicalName());
        }
    }

}
