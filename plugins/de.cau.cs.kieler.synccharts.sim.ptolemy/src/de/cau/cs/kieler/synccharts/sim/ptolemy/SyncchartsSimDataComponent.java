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

package de.cau.cs.kieler.synccharts.sim.ptolemy;

import java.io.File;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowContextDefaultImpl;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.internal.core.Workflow;
import org.eclipse.emf.mwe.utils.Reader;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.util.BundleUtility;
import org.eclipse.xtend.XtendComponent;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Bundle;

import de.cau.cs.kieler.core.model.validation.ValidationManager;
import de.cau.cs.kieler.core.ui.KielerProgressMonitor;
import de.cau.cs.kieler.sim.kiem.JSONSignalValues;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.ui.datacomponent.JSONObjectSimulationDataComponent;
import de.cau.cs.kieler.synccharts.Region;
import de.cau.cs.kieler.synccharts.sim.ptolemy.oaw.MomlWriter;

/**
 * The class SimpleRailCtrl DataComponent implements a KIELER Execution Manager
 * DataComponent. <BR>
 * Within its {@link #initialize()} method it performs the model2model Xtend
 * transformation to create a semantically equivalent but executable Ptolemy
 * model out of the SimpleRailCtrl EMF model instance. It also loads the Ptolemy
 * model within a PtolemyExecutor and adapts the port and host for connecting to
 * the model railway simulation engine. <BR>
 * Within its {@link #step(JSONObject)} method it then triggers a step of the
 * PtolemyExecutor. Because this is done asynchronously the triggering of a
 * consecutive step may lead to an KiemExecutionError be thrown that was
 * initially the consequence of the last (async) call to the step method of the
 * PtolemyExecutor.
 * 
 * @author Christian Motika - cmot AT informatik.uni-kiel.de
 */
@SuppressWarnings("restriction")
public class SyncchartsSimDataComponent extends
        JSONObjectSimulationDataComponent {

    /** The Ptolemy Executor */
    private ExecutePtolemyModel PTOEXE;

    /** The Ptolemy model. */
    private Resource ptolemyModel;

    // -------------------------------------------------------------------------

    /**
     * Instantiates a new SimpleRailCtrl DataComponent for the KIELER Execution
     * Manager.
     */
    public SyncchartsSimDataComponent() {
    }

    // -----------------------------------------------------------------------------
    // -----------------------------------------------------------------------------
    class M2MProgressMonitor implements ProgressMonitor {

        private KielerProgressMonitor kielerProgressMonitor;
        private int numberOfComponents = 1;
        private int numberOfComponentsDone = 0;

        public M2MProgressMonitor(
                final KielerProgressMonitor kielerProgressMonitorParam,
                final int numberOfComponentsParam) {
            kielerProgressMonitor = kielerProgressMonitorParam;
            numberOfComponents = numberOfComponentsParam;
            numberOfComponentsDone = 0;
        }

        public void beginTask(final String name, final int totalWork) {
            kielerProgressMonitor.begin(name, numberOfComponents);
        }

        public void done() {
            // is called by the workflow wrapper
        }

        public void finished(final Object element, final Object context) {
        }

        public void internalWorked(final double work) {
        }

        public boolean isCanceled() {
            return (kielerProgressMonitor.isCanceled());
        }

        public void postTask(final Object element, final Object context) {
            kielerProgressMonitor.worked(numberOfComponentsDone);
            numberOfComponentsDone++;
        }

        public void preTask(final Object element, final Object context) {
            // kielerProgressMonitor.begin(element.toString(), 1);
            kielerProgressMonitor.worked(numberOfComponentsDone);
        }

        public void setCanceled(final boolean value) {
        }

        public void setTaskName(final String name) {
        }

        public void started(final Object element, final Object context) {
        }

        public void subTask(final String name) {
            kielerProgressMonitor.subTask(UNKNOWN);
        }

        public void worked(final int work) {
            kielerProgressMonitor.worked(work);
        }

    }

    // -----------------------------------------------------------------------------
    // -----------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.cau.cs.kieler.sim.kiem.extension.IJSONObjectDataComponent#step(de.cau.cs.kieler.sim.kiem
     * .json.JSONObject)
     */
    @Override
    public JSONObject doStep(final JSONObject jSONObject)
            throws KiemExecutionException {

        SyncchartsSimPtolemyPlugin.DEBUG("Step in Ptolemy Model...");

        // the return object to construct
        JSONObject returnObj = new JSONObject();

        // contains the current state
        String currentState = "";

        try {
            // set current input data
            PTOEXE.setData(jSONObject);

            // perform an synchronous step in PtolemyExecutor
            PTOEXE.executionStep();

            // get the current states
            currentState = PTOEXE.getCurrentState();
        } catch (Exception e) {
            throw (new KiemExecutionException(
                    "Ptolemy Model cannot make a step.\n\n"
                            + "Please ensure that all simulation warnings in the "
                            + "respective Eclipse Problems View have been cleared. If"
                            + " all warings have been cleared and still 'unknown "
                            + " inputs remain', possibly your model is not constructive.\n\n",
                    true, e));
        }

        // get the output present signals
        String[] presentSignals = PTOEXE.getModelOutputPresentSignals();
        for (int c = 0; c < presentSignals.length; c++) {
            String signalName = presentSignals[c];
            SyncchartsSimPtolemyPlugin.DEBUG("Present:" + signalName);
            try {
                JSONObject signalObject = JSONSignalValues.newValue(true);
                try {
                    returnObj.accumulate(signalName, signalObject);
                } catch (Exception e) {
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        // get the output absent signals
        String[] absentSignals = PTOEXE.getModelOutputAbsentSignals();
        for (int c = 0; c < absentSignals.length; c++) {
            String signalName = absentSignals[c];
            SyncchartsSimPtolemyPlugin.DEBUG("Absent:" + signalName);
            try {
                JSONObject signalObject = JSONSignalValues.newValue(false);
                try {
                    returnObj.accumulate(signalName, signalObject);
                } catch (Exception e) {
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        SyncchartsSimPtolemyPlugin.DEBUG(returnObj.toString());

        // the stateName is the second KIEM property
        String stateName = this.getProperties()[1].getValue();

        try {
            returnObj.accumulate(stateName, currentState);
        } catch (Exception e) {
        }
        return returnObj;
    }

    // -------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see de.cau.cs.kieler.sim.kiem.ui.datacomponent.JSONObjectSimulationDataComponent #
     * doModel2ModelTransform(de.cau.cs.kieler.core.ui.KielerProgressMonitor)
     */
    @Override
    public void doModel2ModelTransform(final KielerProgressMonitor monitor)
            throws Exception {
        // "generated.moml";
        int randomNumber = 0;
        try {
            randomNumber = super.getInputEditor().getEditorInput().hashCode();
        } catch (Exception e) {
            // if no editor input, an exception will be raised anyways
        }

        ResourceSet resourceSet = new ResourceSetImpl();
        URI fileUri = URI.createFileURI(new File("generated" + randomNumber
                + ".moml").getAbsolutePath());
        ptolemyModel = resourceSet.createResource(fileUri);

        // Workflow
        Workflow workflow = new Workflow();

        // EMF reader
        Reader emfReader = new Reader();
        emfReader.setUri(this.getInputModel());
        emfReader.setModelSlot("emfmodel");
        // DO NOT USE THE SAME INPUT RESOUCRCE SET
        // OTHERWISE WE MAY CHANGE THE INPUT MODEL!
        // emfReader.setResourceSet(this.getInputResourceSet());
        // emfReader.setResourceSet(ptolemyModel.getResourceSet());

        // MOML writer
        MomlWriter momlWriter = new MomlWriter();
        momlWriter.setUri(ptolemyModel.getURI().toString());
        momlWriter.setResourceSet(ptolemyModel.getResourceSet());
        momlWriter.setModelSlot("momlmodel");

        // Meta models
        EmfMetaModel metaModel0 = new EmfMetaModel(
                de.cau.cs.kieler.core.kexpressions.KExpressionsPackage.eINSTANCE);
        EmfMetaModel metaModel1 = new EmfMetaModel(
                de.cau.cs.kieler.synccharts.SyncchartsPackage.eINSTANCE);
        EmfMetaModel metaModel2 = new EmfMetaModel(
                org.ptolemy.moml.MomlPackage.eINSTANCE);

        // XtendComponent
        XtendComponent xtendComponent = new XtendComponent();
        xtendComponent.addMetaModel(metaModel0);
        xtendComponent.addMetaModel(metaModel1);
        xtendComponent.addMetaModel(metaModel2);
        xtendComponent.setInvoke("synccharts2moml::transform(emfmodel)");
        xtendComponent.setOutputSlot("momlmodel");

        // workflow
        WorkflowContext wfx = new WorkflowContextDefaultImpl();
        Issues issues = new org.eclipse.emf.mwe.core.issues.IssuesImpl();
        M2MProgressMonitor m2mMonitor = new M2MProgressMonitor(monitor, 3);

        workflow.addComponent(emfReader);
        workflow.addComponent(xtendComponent);
        workflow.addComponent(momlWriter);
        // workflow.invoke(wfx, (ProgressMonitor)monitor.subTask(80), issues);
        workflow.invoke(wfx, m2mMonitor, issues);

        SyncchartsSimPtolemyPlugin.DEBUG(xtendComponent.getLogMessage());
        SyncchartsSimPtolemyPlugin.DEBUG(issues.getInfos().toString());
        SyncchartsSimPtolemyPlugin.DEBUG(issues.getIssues().toString());
        SyncchartsSimPtolemyPlugin.DEBUG(issues.getWarnings().toString());
        SyncchartsSimPtolemyPlugin.DEBUG(issues.getErrors().toString());
    }

    // -------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see de.cau.cs.kieler.sim.kiem.ui.datacomponent.JSONObjectSimulationDataComponent
     * #checkModelValidation (org.eclipse.emf.ecore.EObject)
     */
    @Override
    public boolean checkModelValidation(final EObject rootEObject) {
        // Enable KlePto checks in possibly open GMF SyncCharts editor
        ValidationManager
                .enableCheck("de.cau.cs.kieler.synccharts.KleptoChecks");
        ValidationManager.validateActiveEditor();

        // We don't want a dependency to synccharts diagram (custom) for
        // validation
        // because we might want to simulate head less!!!
        // Check if the model conforms to all check files and no warnings left!
        Diagnostician diagnostician = Diagnostician.INSTANCE;
        Region syncChart = (de.cau.cs.kieler.synccharts.Region) rootEObject;
        Diagnostic diagnostic = diagnostician.validate(syncChart);
        int serenity = diagnostic.getSeverity();
        boolean ok = (serenity == Diagnostic.OK);

        return ok;
    }

    // -------------------------------------------------------------------------

    @Override
    public JSONObject doProvideInitialVariables()
            throws KiemInitializationException {
        // do the initialization prior to providing the interface keys
        // this may rise an exception
        PTOEXE = null;
        System.gc();

        loadAndExecuteModel();

        JSONObject returnObj = new JSONObject();

        String[] keys = null;
        keys = PTOEXE.getInterfaceSignals();

        try {
            loadAndExecuteModel();
            keys = PTOEXE.getInterfaceSignals();
            for (String key : keys) {
                returnObj.accumulate(key, JSONSignalValues.newValue(false));
            }
        } catch (Exception e) {
            throw new KiemInitializationException(
                    "Ptolemy Model could not be generated\n\n"
                            + "Please ensure that all simulation warnings in the "
                            + "respective Eclipse Problems View have been cleared.\n\n",
                    true, e);
        }
        return returnObj;
    }

    // -------------------------------------------------------------------------

    @Override
    public URL resolveBundelFile(final String relativePath) {
        Bundle bundle = Platform
                .getBundle(SyncchartsSimPtolemyPlugin.PLUGIN_ID);
        if (!BundleUtility.isReady(bundle)) {
            return null;
        }
        URL fullPathString = BundleUtility.find(bundle, relativePath);
        return fullPathString;
    }

    // -------------------------------------------------------------------------

    public void loadAndExecuteModel() throws KiemInitializationException {
        String ptolemyModelFile = ptolemyModel.getURI().toFileString();

        SyncchartsSimPtolemyPlugin.DEBUG("Now creating Ptolemy Model ..."
                + ptolemyModel);

        SyncchartsSimPtolemyPlugin.DEBUG("Now loading Ptolemy Model..."
                + ptolemyModelFile);
        // load the Ptolemy Model
        PTOEXE = new ExecutePtolemyModel(ptolemyModelFile);
        SyncchartsSimPtolemyPlugin.DEBUG("Now initializing Ptolemy Model...");
        PTOEXE.executionInitialize();
        SyncchartsSimPtolemyPlugin.DEBUG("Now executing Ptolemy Model...");
    }

    // -------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see de.cau.cs.kieler.sim.kiem.extension.IDataComponent#initialize()
     */
    @Override
    public void initialize() throws KiemInitializationException {
    }

    // -------------------------------------------------------------------------
    @Override
    public void bringProblemsViewToFront() {
        try {
            IWorkbenchWindow window = PlatformUI.getWorkbench()
                    .getActiveWorkbenchWindow();
            if (window != null) {
                IWorkbenchPage page = window.getActivePage();
                if (page != null) {
                    IViewPart vP = page
                            .showView(org.eclipse.ui.IPageLayout.ID_PROBLEM_VIEW);
                    vP.setFocus();
                }
            }
        } catch (Exception e) {
            // FIXME: Evil catch block, fix this :P
            e.printStackTrace();
        }
    }

    // -------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see de.cau.cs.kieler.sim.kiem.extension.IDataComponent#wrapup()
     */
    public void wrapup() {
        // stop the model and unlink the PtolemyExecutor thread
        try {
            PTOEXE.executionStop();
        } catch (Exception e) {
            // we expect no serious errors here
        }
        PTOEXE = null;
        System.gc();
    }

    // -------------------------------------------------------------------------

    /**
     * Do provide an additional property to set the state name.
     * 
     * @return the kiem property[]
     */
    @Override
    public KiemProperty[] doProvideProperties() {
        KiemProperty[] properties = new KiemProperty[1];
        properties[0] = new KiemProperty("State Name", "state");
        return properties;
    }

    // -------------------------------------------------------------------------
}
