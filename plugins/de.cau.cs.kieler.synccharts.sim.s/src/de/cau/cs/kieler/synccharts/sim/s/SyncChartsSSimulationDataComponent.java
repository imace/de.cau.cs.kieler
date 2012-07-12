/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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
package de.cau.cs.kieler.synccharts.sim.s;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.core.kexpressions.Signal;
import de.cau.cs.kieler.core.ui.ProgressMonitorAdapter;
import de.cau.cs.kieler.s.s.Program;
import de.cau.cs.kieler.s.sim.sc.SSCSimulationDataComponent;
import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeFile;
import de.cau.cs.kieler.sim.kiem.ui.datacomponent.JSONObjectSimulationDataComponent;
import de.cau.cs.kieler.sim.kiem.util.KiemUtil;
import de.cau.cs.kieler.sim.signals.JSONSignalValues;

import de.cau.cs.kieler.synccharts.codegen.s.xtend.Synccharts2S;
import de.cau.cs.kieler.synccharts.sim.s.xtend.SyncCharts2Simulation;

import de.cau.cs.kieler.synccharts.Region;

/**
 * The SimulationDataComponent for simulating S code with and without visualization.
 * 
 * @author cmot
 */
public class SyncChartsSSimulationDataComponent extends JSONObjectSimulationDataComponent implements
        IJSONObjectDataComponent {

    /** The SyncChart is the considered model to simulate. */
    private Region myModel = null;

    /** The list of output signals including the ones used for the visualization. */
    private LinkedList<String> outputSignalList = null;

    /** The Constant NUMBER_OF_TASKS for model transformation and code generation. */
    private static final int NUMBER_OF_TASKS = 10;

    private static final int KIEM_PROPERTY_FULLDEBUGMODE = 3;

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkModelValidation(final EObject rootEObject)
            throws KiemInitializationException {
        if (!(rootEObject instanceof Region)) {
            throw new KiemInitializationException(
                    "SyncCharts Simulator can only be used with a SyncCharts editor.\n\n", true,
                    null);
        }

        return true;
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public void initialize() throws KiemInitializationException {
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public JSONObject doStep(final JSONObject jSONObject) throws KiemExecutionException {
        // The return object to construct
        JSONObject returnObj = new JSONObject();
        //
        // // Collect active statements
        // String activeStatements = "";
        // StringBuffer activeStatementsBuf = new StringBuffer();
        //
        // if (!scExecution.isStarted()) {
        // throw new KiemExecutionException("No S simulation is running", true, null);
        // }
        // try {
        //
        // scExecution.getExecutionInterfaceToSC().write(jSONObject.toString() + "\n");
        // scExecution.getExecutionInterfaceToSC().flush();
        // while (scExecution.getExecutionInterfaceError().ready()) {
        // // Error output, if any
        // System.out.print(scExecution.getExecutionInterfaceError().read());
        // }
        //
        // String receivedMessage = scExecution.getExecutionInterfaceFromSC().readLine();
        //
        // if (receivedMessage != null) {
        // JSONObject sSignalOutput = new JSONObject(receivedMessage);
        // JSONArray sSignalOutputArray = sSignalOutput.names();
        //
        // if (sSignalOutputArray != null) {
        // // First add auxiliary signals
        // for (int i = 0; i < sSignalOutputArray.length(); i++) {
        // String sSignalOutputName = sSignalOutputArray.getString(i);
        // boolean sSignalIsPresent = JSONSignalValues.isPresent(sSignalOutput
        // .getJSONObject(sSignalOutputName));
        //
        // // Test if the output variable is an auxiliary signal
        // // that is only there to mark the current S statement
        // // in full_simulation mode of the simulator.
        // //
        // // These auxiliary signals must be encapsulated in a state variable.
        // if (sSignalOutputName.startsWith(SSimSCPlugin.AUXILIARY_VARIABLE_TAG)
        // && sSignalIsPresent) {
        // try {
        // String statementWithoutAuxiliaryVariableTag = sSignalOutputName
        // .substring(SSimSCPlugin.AUXILIARY_VARIABLE_TAG.length());
        //
        // // Insert a "," if not the first statement
        // if (activeStatementsBuf.length() != 0) {
        // activeStatementsBuf.append(",");
        // }
        //
        // activeStatementsBuf.append(statementWithoutAuxiliaryVariableTag);
        //
        // } catch (Exception e) {
        // // ignore error
        // }
        //
        // }
        //
        // }
        // }
        // activeStatements = activeStatementsBuf.toString();
        //
        // // Then add normal output signals
        // for (String outputSignal : outputSignalList) {
        // if (sSignalOutput.has(outputSignal)) {
        //
        // // retrieve jsonSignal
        // JSONObject jsonSignal = sSignalOutput.getJSONObject(outputSignal);
        // boolean sSignalIsPresent = JSONSignalValues.isPresent(jsonSignal);
        //
        // if (jsonSignal.has("value")) {
        // Object value = jsonSignal.get("value");
        // // valued signals
        // returnObj.accumulate(outputSignal,
        // JSONSignalValues.newValue(value, true));
        // } else {
        // // pure signals
        // returnObj.accumulate(outputSignal,
        // JSONSignalValues.newValue(sSignalIsPresent));
        // }
        // } else {
        // returnObj.accumulate(outputSignal, JSONSignalValues.newValue(false));
        // }
        // }
        // } else {
        // throw new KiemExecutionException("No S simulation is running", true, null);
        //
        // }
        //
        // // Finally accumulate all active Statements (activeStatements)
        // // under the statementName
        // String statementName = this.getProperties()[1].getValue();
        // returnObj.accumulate(statementName, activeStatements);
        //
        // } catch (IOException e) {
        // System.err.println(e.getMessage());
        // scExecution.stopExecution();
        // } catch (JSONException e) {
        // e.printStackTrace();
        // scExecution.stopExecution();
        // }
        //
        return returnObj;
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public boolean isObserver() {
        return true;
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public boolean isProducer() {
        return true;
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public KiemProperty[] doProvideProperties() {
        final int nProperties = 3;
        KiemProperty[] properties = new KiemProperty[nProperties];
        properties[0] = new KiemProperty("State Name", "statement");
        properties[1] = new KiemProperty("Transition Name", "transition");

        properties[2] = new KiemProperty("Full Debug Mode", true);

        return properties;
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public void wrapup() throws KiemInitializationException {
        // scExecution.stopExecution();
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public void doModel2ModelTransform(final ProgressMonitorAdapter monitor)
            throws KiemInitializationException {
        monitor.begin("S Simulation", NUMBER_OF_TASKS);

        String compile = "";

        try {
            // get active editor
            myModel = (Region) this.getModelRootElement();

            if (myModel == null) {
                throw new KiemInitializationException(
                        "Cannot simulate active editor using the S Simulator", true, null);
            }

            if (this.getModelRootElement().eResource() == null) {
                throw new KiemInitializationException(
                        "The active editor has must be saved in order to simulate the S program."
                                + " Volatile resources cannot be simulated.", true, null);
            }

            // Make a copy of the S program in case it was from
            // an active Editor

            URI syncChartOutput = URI.createURI("");
            URI sOutput = URI.createURI("");
            URI scOutput = URI.createURI("");
            // By default there is no additional transformation necessary
            Region transformedModel = myModel;

            // Calculate output path for possible S-m2m
            // FileEditorInput editorInput = (FileEditorInput) editorPart.getEditorInput();
            String inputPathString = this.getModelFilePath().toString();
            URI input = URI.createPlatformResourceURI(inputPathString, true);
            syncChartOutput = URI.createURI(input.toString());

            // If 'Full Debug Mode' is turned on then the user wants to have
            // also states visualized.
            // Hence some pre-processing is needed and done by the
            // Esterl2Simulation Xtend2 model transformation
            if (this.getProperties()[KIEM_PROPERTY_FULLDEBUGMODE].getValueAsBoolean()) {
                // Try to load SyncCharts model
                // 'Full Debug Mode' is turned ON
                // SyncCharts2Simulation transform =
                // Guice.createInjector().getInstance(SyncCharts2Simulation.class);
                // transformedModel = transform.transform2Simulation(myModel);
                transformedModel = (new SyncCharts2Simulation()).transform2Simulation(myModel);

                // Because we transformed the S program we need to save a different file
                // and pass this new file to the SC simulation instead.
                syncChartOutput = syncChartOutput.trimFragment();
                syncChartOutput = syncChartOutput.trimFileExtension().appendFileExtension(
                        "simulation.kixs");

                try {
                    // Write out copy/transformation of syncchart program
                    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
                    Map<String, Object> m = reg.getExtensionToFactoryMap();
                    m.put("daform", new XMIResourceFactoryImpl());
                    ResourceSet resSet = new ResourceSetImpl();
                    Resource resource = resSet.createResource(syncChartOutput);
                    resource.getContents().add(transformedModel);
                    resource.save(Collections.EMPTY_MAP);
                } catch (IOException e) {
                    throw new KiemInitializationException("Cannot write output SyncChart file.",
                            true, null);
                }
            }

            // Transform SyncChart into S code
            Program program = new Synccharts2S().transform(transformedModel);

            // Calculate outout path
            sOutput = URI.createURI(input.toString());
            sOutput = sOutput.trimFragment();
            sOutput = sOutput.trimFileExtension().appendFileExtension("s");

            try {
                // Write out S program
                Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
                Map<String, Object> m = reg.getExtensionToFactoryMap();
                m.put("daform", new XMIResourceFactoryImpl());
                ResourceSet resSet = new ResourceSetImpl();
                Resource resource = resSet.createResource(sOutput);
                resource.getContents().add(program);
                resource.save(Collections.EMPTY_MAP);
            } catch (IOException e) {
                throw new KiemInitializationException("Cannot write output S file.", true, null);
            }
            
            
            //SSCSimulationDataComponent
            

            // // Calculate output path for SC-m2t
            // scOutput = URI.createURI(input.toString());
            // scOutput = scOutput.trimFragment();
            // scOutput = scOutput.trimFileExtension().appendFileExtension("c");
            //
            // // Set a random output folder for the compiled files
            // String outputFolder = KiemUtil.generateRandomTempOutputFolder();
            //
            // // Generate SC code
            // IPath scOutputPath = new Path(scOutput.toPlatformString(false));
            // IFile scOutputFile = KiemUtil.convertIPathToIFile(scOutputPath);
            // String scOutputString = KiemUtil.getAbsoluteFilePath(scOutputFile);
            // S2SCPlugin.generateSCCode(transformedProgram, scOutputString, outputFolder);
            //
            // // Compile
            // scExecution = new SCExecution(outputFolder);
            // LinkedList<String> generatedSCFiles = new LinkedList<String>();
            // generatedSCFiles.add(scOutputString);
            // scExecution.compile(generatedSCFiles);
        } catch (RuntimeException e) {
            throw new KiemInitializationException("Error compiling S program:\n\n "
                    + e.getMessage() + "\n\n" + compile, true, e);
            // } catch (IOException e) {
            // throw new KiemInitializationException("Error compiling S program:\n\n "
            // + e.getMessage() + "\n\n" + compile, true, e);
            // } catch (InterruptedException e) {
            // throw new KiemInitializationException("Error compiling S program:\n\n "
            // + e.getMessage() + "\n\n" + compile, true, e);
        }
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public JSONObject doProvideInitialVariables() throws KiemInitializationException {
        //
        // // start execution of compiled program
        // if (scExecution.isCompiled()) {
        // try {
        // scExecution.startExecution();
        // } catch (IOException e) {
        // throw new KiemInitializationException(
        // "S program could not be started sucessfully.\n\n", true, e);
        // }
        // } else {
        // throw new KiemInitializationException("S program was not compiled sucessfully.\n\n",
        // true, null);
        // }
        //
        // if (!scExecution.isStarted()) {
        // throw new KiemInitializationException(
        // "Error running S program. Compiled simulation does not exist.\n", true, null);
        // }

        // Build the list of interface output signals
        outputSignalList = new LinkedList<String>();
        JSONObject res = new JSONObject();
        // try {
        // if (myModel != null && myModel.getSignals() != null) {
        // for (Signal signal : myModel.getSignals()) {
        // if (signal.isIsInput()) {
        // res.accumulate(signal.getName(), JSONSignalValues.newValue(false));
        // }
        // if (signal.isIsOutput()) {
        // String signalName = signal.getName();
        // if (!signalName.startsWith(SSimSCPlugin.AUXILIARY_VARIABLE_TAG)) {
        // res.accumulate(signalName, JSONSignalValues.newValue(false));
        // outputSignalList.add(signalName);
        // }
        // }
        // }
        // }
        // } catch (JSONException e) {
        // // ignore
        // }
        return res;
    }

    // -------------------------------------------------------------------------

    /**
     * Checks whether the system is based on windows.
     * 
     * @return true, if is windows
     */
    public static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf("win") >= 0);
    }

    // -------------------------------------------------------------------------
}
