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
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.framework.internal.core.Framework;
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
 * The dynamic bundle loader class. This class contains lists of bundles which are loaded when a
 * specific editor is activated. The bundle data is generated by the
 * {@link DynamicMenuContributions} class.
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
     * @param editor The editor to add
     * @param bundlePath The URI to the bundle path
     */
    public void addBundle(final EditorTransformationSettings editor, final URI bundlePath) {
        // System.out.println("adding " + editor.getEditor() + " to queue");
        waitingBundles.put(editor, bundlePath);
    }

    /**
     * Activates all pending bundles without caring of active editors. This is used for debugging
     * purposes while the open editor bug is fixed.
     * 
     */
    public void activateAllEditors() {
        for (EditorTransformationSettings editor : waitingBundles.keySet().toArray(
            new EditorTransformationSettings[waitingBundles.keySet().size()])) {
            checkForWaitingEditor(editor.getEditorId());
        }
    }

    /**
     * Checks if a given editor has pending activations. It will load and activate dynamic bundles
     * that contribute the buttons and menu commands for the editor.
     * 
     * The method is marked as synchronized to avoid concurrent modification exceptions when two
     * events appear at the same time.
     * 
     * @param activeEditor The editor class name to check
     */
    public synchronized void checkForWaitingEditor(final String activeEditor) {
        // Fast fail when there are not bundles to check
        if (waitingBundles.size() == 0) {
            return;
        }
        HashMap<EditorTransformationSettings, Bundle> installedBundles = new HashMap<EditorTransformationSettings, Bundle>();         // SUPPRESS CHECKSTYLE MaximumLineLength
        for (Entry<EditorTransformationSettings, URI> entry : waitingBundles.entrySet()) {
            EditorTransformationSettings editor = entry.getKey();
            if (editor.getEditorId().equals(activeEditor)) {
                // Create bundle with jar archive
                // haf: the bundle is the contributing one, e.g. de.cau.cs.kieler.synccharts.ksbase
                Bundle bundle = null;
                if (editor.getContributor() != null) {
                    bundle = ContributorFactoryOSGi.resolve(editor.getContributor());
                } else {
                    // Ok the contributor is null, so we are using the KSBasE-UI
                    // contribution
                    bundle = KSBasEUIPlugin.getDefault().getBundle();
                }

                try {
                    // Does the bundle we are about to load is alreay existing ?
                    PackageAdmin admin = getPackageAdmin(bundle);
                    // FIXME: cmot: is this right?
                    // de.cau.cs.kieler.synccharts.ksbase.de.cau.cs.kieler.synccharts.diagram.part.SyncchartsDiagramEditorID.generated
                    String editorDiagramName = bundle.getSymbolicName() + "."
                        + editor.getEditorId() + ".generated";
                    Bundle[] existing = admin.getBundles(editorDiagramName, null);
                    // only load if this hasn't been loaded before
                    Bundle dynamicBundle;
                    if (existing == null || existing.length == 0) {
                        // To avoid %20 exceptions in paths:
                        String val = entry.getValue().toString().replace("%20", " ");
                        // FIXME: cmot: is this right?
                        // reference:file:/X:/dop_eclipse/runtime-New_configuration2/.metadata/.plugins/de.cau.cs.kieler.ksbase.ui/de.cau.cs.kieler.synccharts.diagram.part.SyncchartsDiagramEditorID.jar
                        URL url = new URL("reference:" + val);
                        InputStream in = url.openStream();
                        dynamicBundle = KSBasEUIPlugin.getDefault().getBundle().getBundleContext()
                            .installBundle(editorDiagramName, in);
                    } else {
                        dynamicBundle = existing[0];
                    }
                    // Activating bundle with package admin service
                    if ((dynamicBundle.getState() != Bundle.STARTING)
                        && (dynamicBundle.getState() != Bundle.ACTIVE)) {
                        if (dynamicBundle.getState() == Bundle.INSTALLED) {
                            boolean res = admin.resolveBundles(new Bundle[] { dynamicBundle });
                            if (!res) {
                                // resolving may fail if dependencies cannot be resolved
                                KSBasEUIPlugin.getDefault().logError(
                                    "KSBasE: Bundle " + dynamicBundle.getBundleId()
                                        + " could not be resolved. "
                                        + "Corresponding KSBasE actions won't be available. "
                                        + "Most likely not all dependencies could be resolved.");
                            }
                        }
                        if (dynamicBundle.getState() == Bundle.RESOLVED) {
                            System.out.println("starting");
                            dynamicBundle.start();
                        }
                    }
                    if (dynamicBundle.getState() == Bundle.ACTIVE) {
                        installedBundles.put(editor, dynamicBundle);
                    } else {
                        // this is the error case, this should not happen
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
     * Return the singleton PackageAdmin class that is part of the osgi Framework. It can be used to
     * find and resolve bundles. Extracted this private method to separate concerns with starting
     * the contributed bundle. FIXME: there should be a better way to get the singleton
     * PackageAdmin. Here we use one already existing plug-in to get the PackageAdmin indirectly. Is
     * there a way to ask the Framework directly for the admin? Or is there maybe a better solution
     * to find and resolve plugins than the package admin?
     * 
     * @author haf
     * 
     * @param bundle the context bundle
     * @return the singleton PackageAdmin
     * @throws BundleException
     */
    private PackageAdmin getPackageAdmin(final Bundle bundle) throws BundleException {
        // TODO: to simplify this part, find another way to get the singleton PackageAdmin
        String className = PackageAdmin.class.getName();
        // have to start the bundle if it hasn't before. Otherwise the context might be null
        if (bundle.getState() != Bundle.ACTIVE && bundle.getState() == Bundle.RESOLVED) {
            bundle.start();
        }
        PackageAdmin admin = (PackageAdmin) bundle.getBundleContext().getService(
            bundle.getBundleContext().getServiceReference(className));
        return admin;
    }

    /**
     * A window has been activated. If the editor has an active page and editor the bundles are
     * checked
     * 
     * @param window The activated window
     */
    public void windowActivated(final IWorkbenchWindow window) {
        if (window.getActivePage() != null && window.getActivePage().getActiveEditor() != null) {
            String activeEditor = window.getActivePage().getActiveEditor().getClass()
                .getCanonicalName();
            checkForWaitingEditor(activeEditor);
        }
    }

    /**
     * A window has been opened. If the editor has an active page and editor the bundles are checked
     * 
     * @param window The opened window
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
     * @param page The activated page
     */
    public void pageActivated(final IWorkbenchPage page) {
        if (page.getActiveEditor() != null) {
            checkForWaitingEditor(page.getActiveEditor().getEditorSite().getId());
        }
    }

    /**
     * A page has been opened so we are checking the active editor Id.
     * 
     * @param page The opened page
     */
    public void pageOpened(final IWorkbenchPage page) {
        if (page.getActiveEditor() != null) {
            checkForWaitingEditor(page.getActiveEditor().getEditorSite().getId());
        }
    }

    /**
     * A workbench part has been activated so we are checking the site Id.
     * 
     * @param part The activated part
     */
    public void partActivated(final IWorkbenchPart part) {
        if (part.getSite().getId() != null) {
            checkForWaitingEditor(part.getSite().getId());
        }
    }

    /**
     * A part has been opened, so we are checking the site id.
     * 
     * @param part The opened part
     */
    public void partOpened(final IWorkbenchPart part) {
        if (part.getSite().getId() != null) {
            checkForWaitingEditor(part.getSite().getId());
        }
    }

    /**
     * A part has been brought to top. We are ignoring this event.
     * 
     * @param part The top part.
     */
    public void partBroughtToTop(final IWorkbenchPart part) {
        // Ignore
    }

    /**
     * A part has been closed. We are ignoring this event.
     * 
     * @param part The closed part
     */
    public void partClosed(final IWorkbenchPart part) {
        // Ignore
    }

    /**
     * A part has been deactivated. We are ignoring this event
     * 
     * @param part The deactivated part.
     */
    public void partDeactivated(final IWorkbenchPart part) {
        // Ignore
    }

    /**
     * A page has been closed. We are ignoring this event.
     * 
     * @param page The closed page
     */
    public void pageClosed(final IWorkbenchPage page) {
        // Ignored
    }

    /**
     * A window has been closed. We are ignoring this event
     * 
     * @param window The closed window
     */
    public void windowClosed(final IWorkbenchWindow window) {
        // Nothing
    }

    /**
     * A window has been deactivated. We are ignoring this event
     * 
     * @param window The deactivated window
     */
    public void windowDeactivated(final IWorkbenchWindow window) {
        // Nothing
    }

}
