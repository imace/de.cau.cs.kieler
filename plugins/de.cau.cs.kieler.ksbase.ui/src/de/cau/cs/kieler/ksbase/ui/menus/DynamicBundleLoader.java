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
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.packageadmin.PackageAdmin;

import de.cau.cs.kieler.ksbase.core.EditorTransformationSettings;
import de.cau.cs.kieler.ksbase.ui.KSBasEUIPlugin;

/**
 * The dynamic bundle loader class. This class contains lists of bundles which
 * are loaded when a specific editor is activated. The bundle data is generated
 * by the {@link DynamicMenuContributions} class.
 * 
 * @author mim
 * 
 * @kieler.rating 2009-12-15 proposed yellow
 */
public final class DynamicBundleLoader implements IWindowListener, IPageListener, IPartListener {

    /** Instance of this class. **/
    public static final DynamicBundleLoader INSTANCE = new DynamicBundleLoader();

    /** List of bundles waiting for activation. **/
    private HashMap<EditorTransformationSettings, URI> waitingBundles;

    /** List of activated bundles. **/
    private HashMap<EditorTransformationSettings, Bundle> activeBundles;

    /** Private constructor. **/
    private DynamicBundleLoader() {
        waitingBundles = new HashMap<EditorTransformationSettings, URI>();
        activeBundles = new HashMap<EditorTransformationSettings, Bundle>();
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
            checkForWaitingEditor(editor.getEditorId());
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
        // Fast fail when there are not bundles to check
        if (waitingBundles.size() == 0) {
            return;
        }
        HashMap<EditorTransformationSettings, Bundle> installedBundles = new HashMap<EditorTransformationSettings, Bundle>();
        for (Entry<EditorTransformationSettings, URI> entry : waitingBundles.entrySet()) {
            EditorTransformationSettings editor = entry.getKey();
            if (editor.getEditorId().equals(activeEditor)) {
                // Create bundle with jar archive
                Bundle bundle = null;
                if (editor.getContributor() != null) {
                    bundle = ContributorFactoryOSGi.resolve(editor.getContributor());
                } else {
                    // Ok the contributor is null, so we are using the KSBasE-UI
                    // contribution
                    bundle = KSBasEUIPlugin.getDefault().getBundle();
                }

                String editorDiagramName = bundle.getSymbolicName() + "." + editor.getEditorId()
                        + ".generated";
                try {
                    // To avoid %20 exceptions in paths:
                    String val = entry.getValue().toString().replace("%20", " ");

                    URL url = new URL("reference:" + val);

                    InputStream in = url.openStream();
                    String className = PackageAdmin.class.getName();
                    // FIXME: haf: context might be null after the next line
                    // However, when stepping through this via Debug mode, it is
                    // usually not
                    // So this seems to be a severe concurrency issue
                    if (bundle.getState() != Bundle.ACTIVE && bundle.getState() == Bundle.RESOLVED) {
                        // System.out.println("starting");
                        bundle.start();
                    }
                    BundleContext context = bundle.getBundleContext();
                    Bundle[] existing = null;
                    ServiceReference ref = context.getServiceReference(className);
                    PackageAdmin admin = (PackageAdmin) bundle.getBundleContext().getService(ref);
                    // Does the bundle we are about to load is alreay
                    // existing ?
                    existing = admin.getBundles(editorDiagramName, null);
                    // only load if this hasn't been loaded before
                    if (existing == null || existing.length == 0) {
                        Bundle b = KSBasEUIPlugin.getDefault().getBundle().getBundleContext()
                                .installBundle(editorDiagramName, in);
                        // b.start();
                        // Activating bundle with package admin service
                        // System.out.println("Bundle state : " + b.getState());
                        if (b.getState() != Bundle.STARTING) {
                            if (b.getState() == Bundle.INSTALLED) {
                                // System.out.println("resolving");
                                boolean res = admin.resolveBundles(new Bundle[] { b });
                                if (!res) {
                                    KSBasEUIPlugin.getDefault()
                                            .logError(
                                                    "Bundle " + b.getBundleId()
                                                            + " could not be resolved.");
                                }
                            }
                            if (b.getState() == Bundle.RESOLVED) {
                                // System.out.println("starting");
                                b.start();
                            }
                        }
                        installedBundles.put(editor, b);
                    } else {
                        installedBundles.put(editor, null);
                    }

                } catch (MalformedURLException e) {
                    KSBasEUIPlugin.getDefault()
                            .logError("Bundle could not be loaded: Invalid URI.");
                } catch (IOException e) {
                    KSBasEUIPlugin.getDefault().logError(
                            "Bundle could not be loaded: Error while reading.");
                } catch (BundleException e) {
                    KSBasEUIPlugin.getDefault().logError(
                            "Bundle could not be loaded: Invalid bundle.");
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
        if (window.getActivePage() != null && window.getActivePage().getActiveEditor() != null) {
            String activeEditor = window.getActivePage().getActiveEditor().getClass()
                    .getCanonicalName();
            checkForWaitingEditor(activeEditor);
        }
    }

    /**
     * A window has been opened. If the editor has an active page and editor the
     * bundles are checked
     * 
     * @param window
     *            The opened window
     */
    public void windowOpened(final IWorkbenchWindow window) {
        if (window.getActivePage() != null && window.getActivePage().getActiveEditor() != null) {
            String activeEditor = window.getActivePage().getActiveEditor().getClass()
                    .getCanonicalName();
            checkForWaitingEditor(activeEditor);
            window.getActivePage().addPartListener(DynamicBundleLoader.INSTANCE);

        }
    }

    /**
     * A page has been activated so we are checking the active editor Id.
     * 
     * @param page
     *            The activated page
     */
    public void pageActivated(final IWorkbenchPage page) {
        if (page.getActiveEditor() != null) {
            checkForWaitingEditor(page.getActiveEditor().getEditorSite().getId());
        }
    }

    /**
     * A page has been opened so we are checking the active editor Id.
     * 
     * @param page
     *            The opened page
     */
    public void pageOpened(final IWorkbenchPage page) {
        if (page.getActiveEditor() != null) {
            checkForWaitingEditor(page.getActiveEditor().getEditorSite().getId());
        }
    }

    /**
     * A workbench part has been activated so we are checking the site Id.
     * 
     * @param part
     *            The activated part
     */
    public void partActivated(final IWorkbenchPart part) {
        if (part.getSite().getId() != null) {
            checkForWaitingEditor(part.getSite().getId());
        }
    }

    /**
     * A part has been opened, so we are checking the site id.
     * 
     * @param part
     *            The opened part
     */
    public void partOpened(final IWorkbenchPart part) {
        if (part.getSite().getId() != null) {
            checkForWaitingEditor(part.getSite().getId());
        }
    }

    /**
     * A part has been brought to top. We are ignoring this event.
     * 
     * @param part
     *            The top part.
     */
    public void partBroughtToTop(final IWorkbenchPart part) {
        // Ignore
    }

    /**
     * A part has been closed. We are ignoring this event.
     * 
     * @param part
     *            The closed part
     */
    public void partClosed(final IWorkbenchPart part) {
        // Ignore
    }

    /**
     * A part has been deactivated. We are ignoring this event
     * 
     * @param part
     *            The deactivated part.
     */
    public void partDeactivated(final IWorkbenchPart part) {
        // Ignore
    }

    /**
     * A page has been closed. We are ignoring this event.
     * 
     * @param page
     *            The closed page
     */
    public void pageClosed(final IWorkbenchPage page) {
        // Ignored
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

}
