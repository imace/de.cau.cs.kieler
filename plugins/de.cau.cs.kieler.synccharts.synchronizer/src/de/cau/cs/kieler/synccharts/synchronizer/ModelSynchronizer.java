package de.cau.cs.kieler.synccharts.synchronizer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.State;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.xtext.util.Strings;

import de.cau.cs.kieler.core.expressions.ExpressionsPackage;
import de.cau.cs.kieler.core.expressions.ValuedObject;
import de.cau.cs.kieler.synccharts.SyncchartsPackage;

public class ModelSynchronizer implements IStartup {

    public static String MSG_MATCH_FAILED = "Comparison of match model failed.";
    public static String MSG_JOB_IS_RUNNING = "Active editor cannot be changed while synchronizer is running.";
    public static String MSG_NO_ACTIVE_EDITOR = "A valid active editor cannot be determined.";
    public static String MSG_XTEXT_REFRESH_FAILED = "The Xtext editor could not be refreshed successfully.";
    public static String MSG_LABEL_SERIALIZATION_FAILED = "Transition labels could not be serialized properly.";
    
    public static int RESOLVE_TRANSITION_TARGETS = 0xABCD;

    public static ModelSynchronizer INSTANCE = null;

    private static Boolean DEBUGMatch = false;
    private static Boolean DEBUGDiff = true;
    private static Boolean DEBUGPassive = false;


    private Map<String, Object> matchOptions = null;

    private IWorkbenchPage workbenchPage = null;

//    private IEditorPart activeEditor = null;

    private SyncChartsEditorActivationListener editorActivationListener = null;

    private boolean active = false;

    private ModelSynchronizerJob synchronizer = new ModelSynchronizerJob();

    public ModelSynchronizer() {
        if (INSTANCE == null)
            INSTANCE = this;
        this.matchOptions = new HashMap<String, Object>();
        this.matchOptions.put(MatchOptions.OPTION_DISTINCT_METAMODELS, false);

        this.editorActivationListener = new SyncChartsEditorActivationListener();
        this.editorActivationListener.installModelChangeListener(this.modelChangeListener);

        ICommandService service = (ICommandService) PlatformUI.getWorkbench().getService(
                ICommandService.class);
        State s = service.getCommand("de.cau.cs.kieler.synccharts.synchronizer.Activate").getState(
                "org.eclipse.ui.commands.toggleState");
        this.active = (Boolean) s.getValue();

    }

    public void setActive(boolean isActive) {
        // System.out.println("Synchro " + (isActive?"activated":"deactivated"));
        this.active = isActive;
    }

    // ------------------------------------------------------------------------

    private EContentAdapter modelChangeListener = new EContentAdapter() {

        public void notifyChanged(Notification notification) {
//            if (notification.getNotifier() instanceof Transition) {
//                System.out.println("T  " + ((EObject) notification.getNotifier()).eResource() + "  " + notification.getEventType() + "  " + notification.getFeature());
//                if (((EObject) notification.getNotifier()).eResource().getURI().trimFragment().toString().endsWith("test3.kits")) {
//                    System.out.println("HIER");
//                }
//            } else {
//                System.out.println(notification.getNotifier() + "  " + notification.getEventType() + "  " + notification.getFeature());
//            }
            if (notification == null) {
                return;
            }
            if (notification.getEventType() != Notification.REMOVING_ADAPTER
                    && notification.getEventType() != Notification.RESOLVE) {
                if (ModelSynchronizer.this.active) {
                    ModelSynchronizer.this.synchronizer.schedule(1000L);
                }
            }
            super.notifyChanged(notification);
        }
    };
    
    public static EContentAdapter getModelChangeListener() {
        return INSTANCE.modelChangeListener;
    }
    

    /**
     * this method will be called from the ModelChangeTriggerListener
     * 
     * @param event
     */
    public void triggerModelChangeListener(ResourceSetChangeEvent event) {
        for (Notification n : event.getNotifications()) {
//             System.out.println("Notifier = " + n.getNotifier() + n.getFeature());
            
            // drop a few notifications that don't care semantic information
            if (ExpressionsPackage.eINSTANCE.getValuedObject().isInstance(n.getNewValue())
                    && Strings.isEmpty(((ValuedObject) n.getNewValue()).getName())) {
                continue;
            }
            if (n.getFeature().equals(SyncchartsPackage.eINSTANCE.getAction_Label())) {
                continue;
            }
//             System.out.println("Trigger");
            this.modelChangeListener.notifyChanged(n);
        }
    }

    // ------------------------------------------------------------------------

    public void earlyStartup() {
        // System.out.println("Register... " + PlatformUI.getWorkbench()
        // + " " + PlatformUI.getWorkbench().getWorkbenchWindows()[0]
        // .getActivePage());

        PlatformUI.getWorkbench().addWindowListener(workbenchListener);

        this.workbenchPage = PlatformUI.getWorkbench().getWorkbenchWindows()[0].getActivePage();
        this.workbenchPage.addPartListener(this.editorActivationListener);

        IWorkbenchPart activePart = this.workbenchPage.getActivePart();
        IEditorPart activeEditor = this.workbenchPage.getActiveEditor();

        // hack if an editor is initially open and active
        if (activePart != null && activeEditor != null && activePart == activeEditor) {
            this.editorActivationListener.partActivated(this.workbenchPage.getActiveEditor());
        }
    }

    // ------------------------------------------------------------------------

    private IWindowListener workbenchListener = new IWindowListener() {

        public void windowOpened(IWorkbenchWindow window) {
            this.windowActivated(window);
        }

        public void windowDeactivated(IWorkbenchWindow window) {
            // System.out.println("Window deactivated " + window.getActivePage());
            ModelSynchronizer.this.synchronizer.cancel();
            ModelSynchronizer.this.workbenchPage = null;
        }

        public void windowClosed(IWorkbenchWindow window) {
        }

        public void windowActivated(IWorkbenchWindow window) {
            // System.out.println("Page...  " + window.getActivePage());
            ModelSynchronizer.this.workbenchPage = window.getActivePage();
            window.getActivePage().addPartListener(ModelSynchronizer.this.editorActivationListener);
        }
    };

    public IWorkbenchPage getWorkbenchPage() {
        return this.workbenchPage;
    }

    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------

    public static void dumpMatch(EObject model, OutputStream stream) {
        if (DEBUGMatch) {
            try {
                ResourceSetImpl set = new ResourceSetImpl();
                set.getResourceFactoryRegistry()
                        .getExtensionToFactoryMap()
                        .put(Resource.Factory.Registry.DEFAULT_EXTENSION,
                                new XMIResourceFactoryImpl());

                String path = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString()
                        + "/test/match.xmi";
                // System.out.println("File: "+path);
                Resource test = set.createResource(URI.createFileURI(path));
                test.getContents().add(model);
                test.save(System.out, Collections.EMPTY_MAP);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void dumpDiff(EObject model, OutputStream stream) {
        if (DEBUGDiff || false) {
            try {
                ResourceSetImpl set = new ResourceSetImpl();
                set.getResourceFactoryRegistry()
                        .getExtensionToFactoryMap()
                        .put(Resource.Factory.Registry.DEFAULT_EXTENSION,
                                new XMIResourceFactoryImpl());

                String path = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString()
                        + "/test/diff.xmi";
                // System.out.println("File: "+path);
                Resource test = set.createResource(URI.createFileURI(path));
                test.getContents().add(model);
                test.save(System.out, Collections.EMPTY_MAP);
                test.getContents().remove(model);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void dumpPassive(EObject model, OutputStream stream) {
        if (DEBUGPassive || false) {
            try {
                ResourceSetImpl set = new ResourceSetImpl();
                set.getResourceFactoryRegistry()
                        .getExtensionToFactoryMap()
                        .put(Resource.Factory.Registry.DEFAULT_EXTENSION,
                                new XMIResourceFactoryImpl());

                String path = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString()
                        + "/test/diff.xmi";
                // System.out.println("File: "+path);
                Resource test = set.createResource(URI.createFileURI(path));
                test.getContents().add(model);
                test.save(System.out, Collections.EMPTY_MAP);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
