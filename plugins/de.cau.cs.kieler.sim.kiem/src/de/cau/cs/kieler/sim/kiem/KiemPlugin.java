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

package de.cau.cs.kieler.sim.kiem;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISaveablePart2;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osgi.framework.BundleContext;

import de.cau.cs.kieler.sim.kiem.data.DataComponentEx;
import de.cau.cs.kieler.sim.kiem.data.KiemProperty;
import de.cau.cs.kieler.sim.kiem.execution.Execution;
import de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONStringDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.DataComponent;
import de.cau.cs.kieler.sim.kiem.extension.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.extension.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.views.KiemView;

/**
 * This activator class controls the life cycle of the KiemPlugin. It also provides the access to
 * the one and only instance of this class and hence a way to access the execution thread. For the
 * execution thread it allows to access the KiemView for updating or refreshing the table or the
 * step information text field.
 * 
 * @author Christian Motika - cmot AT informatik.uni-kiel.de
 * 
 */
public class KiemPlugin extends AbstractUIPlugin {

    /**
     * The Constant AIMED_STEP_DURATION_DEFAULT. Default value of the AimedStepDuration text field
     * in ms.
     */
    public static final int AIMED_STEP_DURATION_DEFAULT = 500;

    /**
     * The Constant AIMED_STEP_DURATION_MIN. Minimum value of the AimedStepDuration text field in
     * ms.
     */
    public static final int AIMED_STEP_DURATION_MIN = 1;

    /**
     * The Constant AIMED_STEP_DURATION_MAX. Maximum value of the AimedStepDuration text field in
     * ms.
     */
    public static final int AIMED_STEP_DURATION_MAX = 3600000;

    /** The Constant PLUGIN_ID. */
    public static final String PLUGIN_ID = "de.cau.cs.kieler.sim.kiem";

    /** The shared instance. */
    private static KiemPlugin plugin;

    /** List of available dataProducers and dataObservers. */
    private List<DataComponent> dataComponentList;

    /** List of selected dataComponentEx's (modified by KiemView). */
    private List<DataComponentEx> dataComponentExList;

    /** Execution object. */
    private Execution execution;

    /** Execution thread. */
    private Thread executionThread;

    /** Current value of the aimed step duration in ms. */
    private int aimedStepDuration;

    /** The KIEM view instance. */
    private KiemView kIEMViewInstance;

    // -------------------------------------------------------------------------

    /**
     * The constructor if the KIEM plug-in. A default DataComponentExList is created. It contains
     * all DataComponents in the default order ({@link #getDefaultComponentExList()}). The execution
     * is null by default. The KIEMViewInstance is set, in the constructor of the.
     * 
     * @see de.cau.cs.kieler.sim.kiem.views.KiemView
     */
    public KiemPlugin() {
        dataComponentList = this.getDataComponentList();
        dataComponentExList = getDefaultComponentExList();
        execution = null;
        aimedStepDuration = AIMED_STEP_DURATION_DEFAULT;
        kIEMViewInstance = null;
    }

    // -------------------------------------------------------------------------
    
    /**
     * Sets the execution.
     * 
     * @param executionParam
     *            the new execution
     */
    public void setExecution(final Execution executionParam) {
        this.execution = executionParam;
    }
    
    // -------------------------------------------------------------------------
    
    /**
     * Gets the execution.
     * 
     * @return the execution
     */
    public Execution getExecution() {
        return this.execution;
    }
    
    // -------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(final BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    // -------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(final BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    // -------------------------------------------------------------------------

    /**
     * Returns the shared instance of the KIEM plug-in. This is mainly used by the execution thread
     * to access the view of the KIELER Execution Manager or the other way round.
     * 
     * @return the one and only shared instance of this KIEM plug-in
     */
    public static KiemPlugin getDefault() {
        return plugin;
    }

    // -------------------------------------------------------------------------

    /** The file editor input to open. */
    private IEditorInput editorInputToOpen;

    /**
     * Opens an Execution File (*.execution) and tries to update the dataComponentListEx according
     * to this file. If the components or properties loaded do not exist in the environment (e.g.,
     * the according plug-ins where not loaded) then an error message will bring this to the user's
     * attention. <BR>
     * <BR>
     * This method is called from the KiemProxyEditor that acts as a proxy for passing the
     * editoInput from the Workbench to the KiemView.
     * 
     * @param editorInput
     *            the file editor input to open
     */
    public void openFile(final IEditorInput editorInput) {
        if (!(editorInput instanceof IFileEditorInput)) {
            throw new RuntimeException("Invalid Input: Must be IFileEditorInput");
        }

        this.editorInputToOpen = editorInput;

        Display.getDefault().syncExec(new Runnable() {
            @SuppressWarnings("unchecked")
            public void run() {
                // probe if execution is running
                if (execution != null) {
                    // stop any running execution
                    KiemPlugin.getDefault().execution.stopExecutionSync();
                    // showError(Messages.ErrorOpenDuringExecution,
                    // PLUGIN_ID,
                    // null);
                    // return;
                }

                if (kIEMViewInstance.promptToSaveOnClose() == ISaveablePart2.NO) {
                    // safely clear (w/ calling DataComponent destructors)
                    clearDataComponentExList();
                    // temporary list only
                    List<DataComponentEx> dataComponentExListTemp = null;
                    // try to load the components into a temporary list
                    try {
                        String fileString = ((IFileEditorInput) editorInputToOpen)
                                                        .getFile().getFullPath().toOSString();
                        URI fileURI = URI.createFileURI(fileString);
                        //resolve relative workspace paths
                        URIConverter uriConverter = new ExtensibleURIConverterImpl();
                        InputStream inputStream = uriConverter.createInputStream(fileURI);
                        
                        ObjectInputStream in = new ObjectInputStream(inputStream);
                        Object object;
                        try {
                            object = in.readObject();
                            if (object instanceof List<?>) {
                                dataComponentExListTemp = (List<DataComponentEx>) object;
                            }
                        } catch (ClassNotFoundException e) {
                            showError(null, null, e);
                            // e.printStackTrace();
                        }
                        in.close();
                        
                        inputStream.close();

                        // restore (full) DataComponentExList from
                        // temporary list, this for example contains
                        // no component because these are transient
                        // and not serializable
                        if (dataComponentExListTemp != null) {
                            restoreDataComponentListEx(dataComponentExListTemp);
                        }
                    } catch (IOException e) {
                        showError(null, null, e);
                        e.printStackTrace();
                    }
                    // update the KiemView table
                    kIEMViewInstance.updateViewAsync();
                    // reset the KIEM view (in cases it hangs because
                    // of faulty components)
                    kIEMViewInstance.setAllEnabled(true);
                    kIEMViewInstance.updateEnabledEnabledDisabledUpDownAddDelete();
                    kIEMViewInstance.updateViewAsync();
                    // update the current file, dirty flag
                    kIEMViewInstance.setCurrentFile(((IFileEditorInput) editorInputToOpen)
                            .getFile().getFullPath());
                    kIEMViewInstance.setDirty(false);
                    kIEMViewInstance.checkForSingleEnabledMaster(false);
                }
            }
        });
    }

    // -------------------------------------------------------------------------

    /**
     * Updates the view of the KiemView table asynchronously. This method is used to update the
     * KiemView table from within the execution thread.
     */
    public void updateViewAsync() {
        if (this.kIEMViewInstance != null) {
            this.kIEMViewInstance.updateViewAsync();

        }
    }

    /**
     * Updates the steps in the Step text field asynchronously. This method is used to update the
     * KiemView steps from within the execution thread.
     */
    public void updateStepsAsync() {
        if (this.kIEMViewInstance != null) {
            this.kIEMViewInstance.updateStepsAsync();

        }
    }

    // -------------------------------------------------------------------------

    /**
     * Sets the view focus to the KiemView instance. This method is called by the AimedStepDuration
     * text field if the used wants to leave its focus by pressing [ENTER].
     */
    public void setViewFocus() {
        if (this.kIEMViewInstance != null) {
            this.kIEMViewInstance.setFocus();
        }
    }

    // -------------------------------------------------------------------------

    /**
     * Sets the KIEM view instance. This method is called by the constructor of the Class
     * {@link de.cau.cs.kieler.sim.kiem.views.KiemView} so that this plug-in (or the execution
     * thread) is able to trigger updates on the view.
     * 
     * @param kIEMViewInstanceParam
     *            the one and only KiemView instance
     */
    public void setKIEMViewInstance(final KiemView kIEMViewInstanceParam) {
        this.kIEMViewInstance = kIEMViewInstanceParam;
    }

    // -------------------------------------------------------------------------

    /**
     * Gets the currently set aimed step duration.
     * 
     * @return the aimed step duration
     */
    public int getAimedStepDuration() {
        return this.aimedStepDuration;
    }

    // -------------------------------------------------------------------------

    /**
     * Sets the aimed step duration. This method sets the aimed step duration and also passes-on the
     * value to the execution thread if that exists.
     * 
     * @param aimedStepDurationi
     *            the new aimed step duration
     */
    public void setAimedStepDuration(final int aimedStepDurationi) {
        this.aimedStepDuration = aimedStepDurationi;
        // if executing, also update current delay
        if (execution != null) {
            this.execution.setAimedStepDuration(aimedStepDuration);
        }
    }

    // -------------------------------------------------------------------------

    // /**
    // * Extracts the selection of the Project Explorer. This method is not
    // * used in the current implementation but may be used in the future.
    // *
    // */
    // public IResource extractSelection(ISelection sel) {
    // if (!(sel instanceof IStructuredSelection))
    // return null;
    // IStructuredSelection ss = (IStructuredSelection) sel;
    // Object element = ss.getFirstElement();
    // if (element instanceof IResource)
    // return (IResource) element;
    // if (!(element instanceof IAdaptable))
    // return null;
    // IAdaptable adaptable = (IAdaptable)element;
    // Object adapter = adaptable.getAdapter(IResource.class);
    // return (IResource) adapter;
    // }

    // -------------------------------------------------------------------------

    /**
     * Tries to restore the data component list. If an item was not found it will be deleted and an
     * error message is shown.
     * 
     * @param dataComponentExListParam
     *            a temporary (partial) DataComponentExList to restore the full one from
     */
    public void restoreDataComponentListEx(final List<DataComponentEx> dataComponentExListParam) {
        List<DataComponent> dataComponentListTmp = getDataComponentList();

        for (int c = 0; c < dataComponentExListParam.size(); c++) {
            DataComponentEx dataComponentEx = dataComponentExListParam.get(c);
            String componentId = dataComponentEx.getComponentId();
            KiemProperty[] properties = dataComponentEx.getProperties();

            boolean componentRestored = false;

            for (int cc = 0; cc < dataComponentListTmp.size(); cc++) {
                DataComponent dataComponent = dataComponentListTmp.get(cc);
                String vglComponentId = dataComponent.getDataComponentId();

                if (vglComponentId.equals(componentId)) {
                    // restore KIEM property type first
                    if (properties != null) {
                        for (int ccc = 0; ccc < properties.length; ccc++) {
                            properties[ccc].setType(dataComponent.getProperties()[ccc].getType());
                        }
                    }
                    // we found the component ... now restore it
                    DataComponentEx addedDataComponentEx = this
                            .addTodataComponentExList(dataComponent);
                    // set the loaded properties
                    addedDataComponentEx.setProperties(properties);
                    // set enabled disabled
                    addedDataComponentEx.setEnabled(dataComponentEx.isEnabled());
                    // everything restored correctly
                    componentRestored = true;
                    break;
                } // end if
            } // next cc

            if (!componentRestored) {
                this.showWarning(Messages.mWarningLoadingDataComponent.replace("%COMPONENTNAME",
                        componentId), null, null);
            } // end if - failed

        } // next c
    }

    // -------------------------------------------------------------------------

    /**
     * This initializes the DataComponentList with all registered and loaded plug-ins that extend
     * the following two extension points:<BR>
     * - {@link de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent}<BR>
     * - {@link de.cau.cs.kieler.sim.kiem.extension.JSONStringDataComponent}<BR>
     * If a DataComponent is registered but cannot be instantiated because of an error this will
     * result in a warning only so that all other fully functional DataComponents are still loaded.
     * This method remembers its list thru the whole life-cycle of this plug-in and always returns
     * the same list. All DataComponents that cannot be instantiated due to errors will not occur in
     * the list.
     * 
     * @return the DataComponentList
     */
    public List<DataComponent> getDataComponentList() {
        if (dataComponentList != null) {
            return dataComponentList;
        }
        // suggest calling the garbage collector
        System.gc();
        // get the available interfaces and initialize them
        IConfigurationElement[] jsonComponents = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(Messages.extensionPointIDjsoncomponent);

        IConfigurationElement[] stringComponents = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(Messages.extensionPointIDstringcomponent);

        dataComponentList = new ArrayList<DataComponent>(jsonComponents.length
                + stringComponents.length);

        for (int i = 0; i < jsonComponents.length; i++) {
            try {
                JSONObjectDataComponent dataComponent = (JSONObjectDataComponent) jsonComponents[i]
                        .createExecutableExtension("class");
                dataComponent.setConfigurationElemenet(jsonComponents[i]);
                dataComponentList.add(dataComponent);
                // System.out.println(jsonComponents[i]);
            } catch (Exception e) {
                // throw new RuntimeException
                // ("Error at loading a KIEM data component plugin");
                this.showWarning(Messages.mWarningLoadingDataComponent.replace("%COMPONENTNAME",
                        jsonComponents[i].getContributor().getName()), null, e);
            }
        }
        for (int i = 0; i < stringComponents.length; i++) {
            try {
                JSONStringDataComponent dataComponent = (JSONStringDataComponent) stringComponents[i]
                        .createExecutableExtension("class");
                dataComponent.setConfigurationElemenet(stringComponents[i]);
                dataComponentList.add(dataComponent);
                // System.out.println(dataComponent.getName());
            } catch (Exception e) {
                // throw new RuntimeException
                // ("Error at loading a KIEM data component plugin");
                this.showWarning(Messages.mWarningLoadingDataComponent.replace("%COMPONENTNAME",
                        stringComponents[i].getContributor().getName()), null, e);
            }
        }
        return dataComponentList;
    }

    // -------------------------------------------------------------------------

    /**
     * Initializes the Execution. This is one of the heart-methods of this plug-in. It does the
     * following tasks: <BR>
     * <BR>
     * (1) Check if there are any (enabled) DataProducers or DataConsumers.<BR>
     * (2) Check if all DataComponent's properties are set correctly<BR>
     * (3) Grab all interface variables provided by the DataComponents.<BR>
     * (4) Distribute the union of all the variables to all DataComponents.<BR>
     * (5) Initialize the DataComponents<BR>
     * (6) Create an run the Execution thread<BR>
     * <BR>
     * This method returns true if the execution is successfully initialized or if the execution
     * thread already exists, hence the {@link #execution} is not null.
     * 
     * @return true, if successful
     */
    public boolean initExecution() {
        if (this.execution != null) {
            return true;
        }

        this.kIEMViewInstance.setAllEnabled(false);
        // count all (enabled) data producer and Observer
        int countEnabledProducer = 0;
        int countEnabledObserver = 0;
        for (int c = 0; c < dataComponentExList.size(); c++) {
            DataComponentEx dataComponentEx = dataComponentExList.get(c);
            if (dataComponentEx.isEnabled()) {
                if (dataComponentEx.isProducer()) {
                    countEnabledProducer++;
                }
                if (dataComponentEx.isObserver()) {
                    countEnabledObserver++;
                }
            } // end if enabled
        } // next c
        if (countEnabledProducer < 1) {
            this.kIEMViewInstance.setAllEnabled(true);
            this.showError(Messages.mErrorNoDataProducer, KiemPlugin.PLUGIN_ID, null);
            return false;
        } else if (countEnabledObserver < 1) {
            this.kIEMViewInstance.setAllEnabled(true);
            showError(Messages.mErrorNoDataObserver, KiemPlugin.PLUGIN_ID, null);
            return false;
        }

        // now check if properties are OK hence no KiemPropertyError is thrown
        for (int c = 0; c < dataComponentExList.size(); c++) {
            DataComponentEx dataComponentEx = dataComponentExList.get(c);
            KiemProperty[] properties = dataComponentEx.getProperties();
            try {
                dataComponentEx.checkProperties(properties);
            } catch (Exception e) {
                this.kIEMViewInstance.setAllEnabled(true);
                this.showError(e.getMessage(), dataComponentEx.getDataComponent()
                        .getConfigurationElement().getContributor().getName(), e);
                return false;
            }
        }

        // get all InterfaceKeys from (enabled) data producer
        // and combine them into globalInterfaceKeys
        List<String> globalInterfaceKeys = new LinkedList<String>();
        for (int c = 0; c < dataComponentExList.size(); c++) {
            DataComponentEx dataComponentEx = dataComponentExList.get(c);
            if (dataComponentEx.isEnabled()) {

                try {
                    String[] localInterfaceKeys = dataComponentEx.provideInterfaceKeys();
                    if (localInterfaceKeys != null) {
                        for (int cc = 0; cc < localInterfaceKeys.length; cc++) {
                            String localInterfaceVariable = localInterfaceKeys[cc];
                            globalInterfaceKeys.add(localInterfaceVariable);
                        } // next cc
                    } // end if not null
                } catch (Exception e) {
                    this.kIEMViewInstance.setAllEnabled(true);
                    KiemPlugin.getDefault().handleComponentError(
                            dataComponentEx.getDataComponent(), e);
                    return false;
                }

            } // if enabled
        } // next c

        // distribute union of InterfaceKeys to all enabled components
        for (int c = 0; c < dataComponentExList.size(); c++) {
            DataComponentEx dataComponentEx = dataComponentExList.get(c);
            if (dataComponentEx.isEnabled()) {
                dataComponentEx.setInterfaceKeys((String[]) globalInterfaceKeys
                        .toArray(new String[0]));
            } // end if enabled
        } // next c

        // initialize all (enabled) data producer and Observer
        for (int c = 0; c < dataComponentExList.size(); c++) {
            DataComponentEx dataComponentEx = dataComponentExList.get(c);
            if (dataComponentEx.isEnabled()) {
                try {
                    dataComponentEx.getDataComponent().initialize();
                } catch (Exception e) {
                    this.kIEMViewInstance.setAllEnabled(true);
                    e.printStackTrace();
                    KiemPlugin.getDefault().handleComponentError(
                            dataComponentEx.getDataComponent(), e);
                    return false;
                }
            } // end if enabled
        } // next c

        // now create and run the execution thread
        this.execution = new Execution(dataComponentExList);
        // take the last set delay
        this.execution.setAimedStepDuration(this.getAimedStepDuration());
        this.executionThread = new Thread(this.execution);
        this.executionThread.start();

        this.kIEMViewInstance.setAllEnabled(true);
        return true;
    }

    // -------------------------------------------------------------------------

    /**
     * Add a DataComponent instance to the {@link #dataComponentExList}. This will clone the
     * DataComponent and add an executable extension. It then creates a new DataComponentEx instance
     * that encapsulates the just created DataComponent (and offers additional information and
     * methods). The latter will be added then to the DataComponentList.
     * 
     * @param component
     *            the component
     * 
     * @return the added dataComponentEx component
     */
    public DataComponentEx addTodataComponentExList(final DataComponent component) {
        // suggest calling the garbage collector
        System.gc();
        IConfigurationElement componentConfigEle = component.getConfigurationElement();
        DataComponent componentClone;
        try {
            componentClone = (DataComponent) componentConfigEle.createExecutableExtension("class");
            componentClone.setConfigurationElemenet(componentConfigEle);

            DataComponentEx dataComponentEx = new DataComponentEx(componentClone);
            this.dataComponentExList.add(dataComponentEx);
            return dataComponentEx;
        } catch (CoreException e) {
            e.printStackTrace();
        }
        return null;
    }

    // -------------------------------------------------------------------------

    /**
     * Returns the default ComponentExList. This will contain all registered DataComponents that
     * extend one the following extension points:<BR>
     * - {@link de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent}<BR>
     * - {@link de.cau.cs.kieler.sim.kiem.extension.JSONStringDataComponent}<BR>
     * They will be ordered in the "natural" way, meaning that the (pure) data producers are
     * scheduled before the data observer & producers which are themselves scheduled before the
     * (pure) data observers. Although DataComponents may be multiple instantiable, by default,
     * there will be exactly one instance per DataComponent in the list.
     * 
     * @return the default DataComponentExList
     */
    public List<DataComponentEx> getDefaultComponentExList() {
        // suggest calling the garbage collector
        System.gc();
        List<DataComponent> list = this.getDataComponentList();
        List<DataComponentEx> returnList = new LinkedList<DataComponentEx>();
        // first add initialization components
        for (int c = 0; c < list.size(); c++) {
            DataComponent dataComponent = (DataComponent) list.get(c);
            DataComponentEx dataComponentEx = new DataComponentEx(dataComponent);
            if ((!dataComponentEx.isProducer()) && !dataComponentEx.isObserver()) {
                returnList.add(dataComponentEx);
            }
        }
        // then add pure producer
        for (int c = 0; c < list.size(); c++) {
            DataComponent dataComponent = (DataComponent) list.get(c);
            DataComponentEx dataComponentEx = new DataComponentEx(dataComponent);
            if (dataComponentEx.isProducerOnly()) {
                returnList.add(dataComponentEx);
            }
        }
        // then add observer & producer
        for (int c = 0; c < list.size(); c++) {
            DataComponent dataComponent = (DataComponent) list.get(c);
            DataComponentEx dataComponentEx = new DataComponentEx(dataComponent);
            if (dataComponentEx.isProducerObserver()) {
                returnList.add(dataComponentEx);
            }
        }
        // then add pure observer
        for (int c = 0; c < list.size(); c++) {
            DataComponent dataComponent = (DataComponent) list.get(c);
            DataComponentEx dataComponentEx = new DataComponentEx(dataComponent);
            if (dataComponentEx.isObserverOnly()) {
                returnList.add(dataComponentEx);
            }
        }
        return returnList;
    }

    // -------------------------------------------------------------------------

    /**
     * Safely clear DataComponentExList and call DataComponent destructors.
     */
    public void clearDataComponentExList() {
        if (this.dataComponentExList == null) {
            return;
        }
        while (this.dataComponentExList.size() > 0) {
            DataComponentEx dataComponentEx = dataComponentExList.get(0);
            dataComponentEx.getDataComponent()._DataComponent();
            dataComponentExList.remove(dataComponentEx);
        }
        // suggest calling the garbage collector
        System.gc();
    }

    // -------------------------------------------------------------------------

    /**
     * Returns the current DataComponentEx-List that is held by the KIEM plug-in directly. Any
     * modification on this list is persistent in this one and only plug-in instance. The
     * DataComponentExList holds a list of DataComponents, selected from all registered (and loaded)
     * plug-ins that extend the following extension points:<BR>
     * - {@link de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent}<BR>
     * - {@link de.cau.cs.kieler.sim.kiem.extension.JSONStringDataComponent}<BR>
     * 
     * @return the DataComponentExList
     */
    public List<DataComponentEx> getDataComponentExList() {
        return this.dataComponentExList;
    }

    // -------------------------------------------------------------------------

    /**
     * This method handles errors or warnings within the execution of DataComponents. It
     * specifically handles the following two types or errors:<BR>
     * - {@link KiemExecutionException}<BR>
     * - {@link KiemExecutionException}<BR>
     * If the mustStop flag is set, then the execution is immediately stopped. Note that all threads
     * will be advised to stop in the
     * {@link de.cau.cs.kieler.sim.kiem.execution.Execution#errorTerminate()} method. But there is
     * no guarantee that they really stop. The links to these threads will be cut down, so that
     * there is the possibility of zombie threads.
     * 
     * @param dataComponent
     *            the DataComponent that caused the error or warning
     * @param exception
     *            the Exception if any, or null
     */
    public void handleComponentError(final DataComponent dataComponent, final Exception exception) {

        boolean mustStop = false;

        // check if mustStop flag is set
        if (exception instanceof KiemExecutionException) {
            mustStop = ((KiemExecutionException) exception).isMustStop();
        } else if (exception instanceof KiemInitializationException) {
            mustStop = ((KiemInitializationException) exception).isMustStop();
        }

        // show error or warning message dialog
        if (mustStop) {
            // first terminate the execution
            KiemPlugin.getDefault().execution.errorTerminate();
            // then show modal error dialog
            KiemPlugin.getDefault().showError(null, dataComponent.getPluginId(), exception);
        } else {
            // show non modal warning dialog
            KiemPlugin.getDefault().showWarning(null, dataComponent.getPluginId(), exception);
        }

    }

    // -------------------------------------------------------------------------

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
     */
    public void showWarning(final String textMessage, final String pluginID,
            final Exception exception) {
        try {
            String message = "";

            if (textMessage != null) {
                message = textMessage + message;
                // exception = null;
            } else if (exception != null) {
                message = exception.getMessage() + message;
                // exception = null;
            }

            // do not post the same message twice
            if ((exception != null) && (textMessage != null)
                    && (exception.getMessage().startsWith(textMessage))) {
                message = "" + pluginID + "";
            } else {
                message += " (" + pluginID + ")";
            }

            String pluginID2 = null;
            if (pluginID == null) {
                pluginID2 = KiemPlugin.PLUGIN_ID;
            } else {
                pluginID2 = pluginID;
            }

            IStatus status = new Status(IStatus.WARNING, pluginID2, IStatus.WARNING, message,
                    exception);

            StatusAdapter statusAdapter = new StatusAdapter(status);
            statusAdapter.setProperty(IStatusAdapterConstants.TIMESTAMP_PROPERTY, System
                    .currentTimeMillis());

            // use status manager (log and show)
            StatusManager.getManager()
                    .handle(statusAdapter, StatusManager.LOG | StatusManager.SHOW);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // -------------------------------------------------------------------------

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
     */
    public void showError(final String textMessage, final String pluginID, final Exception exception) {
        try {
            String message = "";

            if (textMessage != null) {
                message = textMessage + message;
                // exception = null;
            } else if (exception != null) {
                message = exception.getMessage() + message;
                // exception = null;
            }

            // do not post the same message twice
            if ((exception != null) && (textMessage != null)
                    && (exception.getMessage().startsWith(textMessage))) {
                message = "" + pluginID + "";
            } else {
                message += " (" + pluginID + ")";
            }

            String pluginID2 = null;
            if (pluginID == null) {
                pluginID2 = KiemPlugin.PLUGIN_ID;
            } else {
                pluginID2 = pluginID;
            }

            IStatus status = new Status(IStatus.ERROR, pluginID2, IStatus.ERROR, message, exception);

            StatusAdapter statusAdapter = new StatusAdapter(status);
            statusAdapter.setProperty(IStatusAdapterConstants.TIMESTAMP_PROPERTY, System
                    .currentTimeMillis());

            // use status manager (log and show)
            // BLOCK = modal window, force the user to act!
            StatusManager.getManager().handle(statusAdapter,
                    StatusManager.BLOCK | StatusManager.LOG | StatusManager.SHOW);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
