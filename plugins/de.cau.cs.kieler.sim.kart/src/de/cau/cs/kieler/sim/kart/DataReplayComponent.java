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
package de.cau.cs.kieler.sim.kart;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.sim.esi.EsiFile;
import de.cau.cs.kieler.sim.esi.ISignal;
import de.cau.cs.kieler.sim.esi.ITick;
import de.cau.cs.kieler.sim.esi.ITrace;
import de.cau.cs.kieler.sim.esi.ITraceProvider;
import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.signals.JSONSignalValues;
import de.cau.cs.kieler.sim.kiem.IKiemEventListener;
import de.cau.cs.kieler.sim.kiem.KiemEvent;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyException;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeFile;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeInt;
import de.cau.cs.kieler.sim.kiem.ui.datacomponent.JSONObjectSimulationDataComponent;

/**
 * Implements a data component for KIEM that reads a ESI/ESO trace file and in each step of the
 * simulation replays the corresponding signals. This component also offers a training mode to
 * write ESO files in conjunction with the {@link DataValidationComponent}.
 * 
 * @author Sebastian Schäfer - ssc AT informatik.uni-kiel.de
 * @kieler.rating 2011-11-24 red
 */
public class DataReplayComponent extends JSONObjectSimulationDataComponent implements
        IJSONObjectDataComponent, IKiemEventListener {
    /** The number of the current step */
    private static volatile long step;
    
    /** Name of the ESO file to be replayed/recorded from/to. */
    private String filename;
    
    /** Name of the variable that will be used to communicate with the validation component */
    private String configVarName;
    
    /** Name of the variable that will be used to communicate the values of output signals and
     * variables to the validation component.
     */
    private String outputVarName;
    
    /** Name of the variable under which all signals injected into the simulation by components
     * in front of this component will be saved. These will be regarded as input signals when
     * writing an ESO file.
     */
    private String prevInputVarName;

    /** The single trace out of a ESI/ESO file that shall be replayed */
    private ITrace trace;
    
    /** Are we in training mode, i. e. recording, or not */
    private boolean trainingMode;
    
    /**
     * Initializes the component by reading the whole ESI/ESO file and saves it internally for
     * replay.
     * 
     * @throws KiemInitializationException
     *             thrown when reading the file fails
     */
    public void initialize() throws KiemInitializationException {
        KiemProperty[] properties = this.getProperties();
        trace = null;
        filename = "";
        int tracenum = 0;
        step = 0;
        configVarName = "";
        outputVarName = "";
        prevInputVarName = "";

        // load properties
        for (KiemProperty prop : properties) {
            if (prop.getKey().equals(Constants.ESOFILE)) {
                filename = prop.getValue();
            } else if (prop.getKey().equals(Constants.TRACENUM)) {
                tracenum = prop.getValueAsInt();
            } else if (prop.getKey().equals(Constants.TRAINMODE)) {
                trainingMode = prop.getValueAsBoolean();
            } else if (prop.getKey().equals(Constants.CONFIGVAR)) {
                configVarName = prop.getValue();
            } else if (prop.getKey().equals(Constants.OUTPUTVAR)) {
                outputVarName = prop.getValue();
            } else if (prop.getKey().equals(Constants.PREVINVAR)) {
                prevInputVarName = prop.getValue();
            }
        }

        if(!trainingMode) {
            //Read the file
            ITraceProvider tracefile = new EsiFile();
            try {
                List<ITrace> tracelist = tracefile.loadTrace(filename);
        
                try {
                    trace = tracelist.get(tracenum);
                } catch (IndexOutOfBoundsException e) {
                    throw new KiemInitializationException(Constants.ERR_NOTRACE
                            + tracenum, true, e);
                }
            } catch(KiemInitializationException e) {
                throw new KiemInitializationException(Constants.ERR_READ, true, e);
            }
        }
    }

    /**
     * Wrapup the data component and revert the internal state, here this means do nothing.
     * 
     * @throws KiemInitializationException
     *             never thrown
     */
    public void wrapup() throws KiemInitializationException {
        
    }
    
    /**
     * Sets the step number according to the button the user pressed. This is needed to correctly
     * handle history steps or jumps.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void notifyEvent(KiemEvent event) {
        if (event.isEvent(KiemEvent.STEP_INFO) && event.getInfo() instanceof Pair) {
            step = ((Pair<Long, Long>) event.getInfo()).getFirst().longValue();
        }
    }

    /**
     * Return the types of events this component listens to
     * 
     * @return the event types, currently only {@code KiemEvent.STEP_INFO}
     */
    @Override
    public KiemEvent provideEventOfInterest() {
        int[] events = { KiemEvent.STEP_INFO };
        KiemEvent event = new KiemEvent(events);
        return event;
    }

    /**
     * Tell KIEM that this component does produce data.
     * 
     * @return always true
     */
    public boolean isProducer() {
        return true;
    }

    /**
     * Tell KIEM that this component does observe data.
     * 
     * @return always true
     */
    @Override
    public boolean isObserver() {
        return true;
    }
    
    /**
     * Tell KIEM that we are a delta observer.
     * 
     * @return always true
     */
    @Override
    public boolean isDeltaObserver() {
        return true;
    }

    /**
     * Take a step in the simulation by reading the internal state and providing the
     * signals read from the ESI/ESO file to the simulation engine.
     * 
     * @return data that shall be injected into the simulation
     * @throws KiemExecutionException 
     *          when the JSON object with signals from ESI/ESO file could not be built.
     */
    @Override
    public JSONObject doStep(JSONObject obj) throws KiemExecutionException {
        JSONObject retval = new JSONObject();

        if(!trainingMode && trace.getSize() > (step - 1)) {
            loadInputs(retval);
            loadOutputs(retval);
        }

        loadPreviousInputSignals(obj, retval);
        loadValConfigVars(retval);

        // inject signals into simulation
        return retval;
    }

    /**
     * Extract input signals from an ESO file and prepare them for injection into the simulation
     * 
     * @return the signals that shall be injected
     * @throws KiemExecutionException when building the JSONObject fails
     */
    private void loadInputs(JSONObject retval) throws KiemExecutionException {
        JSONObject prevSignals = new JSONObject();
        System.out.println("XX Step: " + step);
        ITick tick = trace.get(step - 1);

        Iterator<ISignal> signals = tick.getInputs().iterator();

        // Add signals from the trace to the simulation
        try {
            while (signals.hasNext()) {
                ISignal signal = signals.next();
                if (signal.isValued()) {
                    retval.accumulate(signal.getName(), JSONSignalValues.newValue(signal.getValue(), true));
                    prevSignals.accumulate(signal.getName(), JSONSignalValues.newValue(signal.getValue(), true));
                }
                else {
                    retval.accumulate(signal.getName(), JSONSignalValues.newValue(true));
                    prevSignals.accumulate(signal.getName(), JSONSignalValues.newValue(true));
                }
            }
            retval.accumulate(prevInputVarName, prevSignals);
        } catch (JSONException e) {
            throw new KiemExecutionException(
                    Constants.ERR_JSON, true, e);
        }
    }
    
    /**
     * Gather the input signals generated by components which were executed prior to this and
     * prepare them for submission to the validation component. This information is needed to:
     * 
     * (a) distinguish between input and output during validation
     * (b) to generate a list of input signals when writing an ESO file
     * 
     * @param json the data pool JSON object
     * @param retval the JSON object that will be injected into the simulation
     * @throws KiemExecutionException when adding to {@code retval} fails.
     */
    private void loadPreviousInputSignals(JSONObject json, JSONObject retval) throws KiemExecutionException {
        JSONObject prevSignals = retval.optJSONObject(prevInputVarName);
        retval.remove(prevInputVarName);
        if(prevSignals == null) {
            prevSignals = new JSONObject();
        }
        
        String[] fieldNames = JSONObject.getNames(json);
        for (String field : fieldNames) {
            try {
                Object obj = json.get(field);
                
                if(obj instanceof JSONObject && JSONSignalValues.isSignalValue(obj) && !retval.has(field)) {
                    prevSignals.accumulate(field, obj);
                }
            } catch (JSONException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        try {
            retval.accumulate(prevInputVarName, prevSignals);
        } catch (JSONException e) {
            throw new KiemExecutionException("Error during gathering previous input signals", true, e);
        }
    }
    
    /**
     * Load output signals and variables from ESO trace and prepare them for injection into the
     * data pool. This data will later on be used by the validation component.
     * 
     * @param json the JSON object the output data will be added to
     * @throws KiemExecutionException when adding to the JSON object fails
     */
    private void loadOutputs(JSONObject json) throws KiemExecutionException {
        ITick curTick = trace.get(step - 1);
        Iterator<ISignal> outputSignals = curTick.getOutputs().iterator();
        JSONObject value = new JSONObject();
        
        // Add output signals
        try {
            while (outputSignals.hasNext()) {
                ISignal outputSignal = outputSignals.next();
                if (outputSignal.isValued()) {
                    value.accumulate(outputSignal.getName(), JSONSignalValues.newValue(outputSignal.getValue(), true));
                } else {
                    value.accumulate(outputSignal.getName(), JSONSignalValues.newValue(true));
                }
            }
        
            // Add variables
            Iterator<Entry<String,String>> variables = curTick.getExtraInfos().entrySet().iterator();
            
            while (variables.hasNext()) {
                    Entry<String,String> variable = variables.next();
                    value.accumulate(variable.getKey(), variable.getValue());
            }
            
            json.accumulate(outputVarName, value);
        } catch (JSONException e) {
            throw new KiemExecutionException(Constants.ERR_JSON, true, e);
        }
    }
    
    /**
     * Prepare the current configuration of the replay component for addition to the data pool.
     * This configuration will be used by the validation component, so we save several properties there
     * and most properties will always be in sync (e. g. training mode).
     * 
     * @param json The JSONObject the configuration variables will be added to
     * @throws KiemExecutionException when adding to the JSON object fails
     */
    private void loadValConfigVars(JSONObject json) throws KiemExecutionException {
        JSONObject value = new JSONObject();
        
        try {
            value.accumulate(Constants.VAR_TRAINMODE, trainingMode);
            value.accumulate(Constants.VAR_ESOFILE, filename);
            if(!trainingMode && trace.getSize() <= (step - 1)) {
                value.accumulate(Constants.VAR_EOT, true);
            } else {
                value.accumulate(Constants.VAR_EOT, false);
            }
            
            json.accumulate(configVarName, value);
        } catch (JSONException e) {
            throw new KiemExecutionException(Constants.ERR_JSON, true, e);
        }
    }

    /**
     * Provide a list of properties to KIEM so the user can configure this component.
     * 
     * @return the properties
     */
    @Override
    public KiemProperty[] doProvideProperties() {
        KiemPropertyTypeFile fileProperty = new KiemPropertyTypeFile(true);
        fileProperty.setFilterExts(Constants.FILEEXTS);
        fileProperty.setFilterNames(Constants.FILEEXTNAMES);
        
        String filename = null;
        try {
            /*
             * Try creating a default file name.
             * The try block is necessary to suppress NPEs and other exceptions when we are either
             * running in headless mode or there are no editor opened. Below, you will see that a
             * filename is only proposed if this try block succeeds. We have to use absolute file
             * paths here, because the KiemPropertyTypeFile dialog only returns absolute paths. I do
             * not want to change that for fear that something else breaks.
             */
            URI resource = ((DiagramEditor) getActivePage().getActiveEditor()).getDiagram()
                    .eResource().getURI().trimFileExtension().appendFileExtension("eso");
            URI absFile = CommonPlugin.resolve(resource);
            filename = absFile.toFileString();
        } catch(Exception e) {
            // do nothing
        }
        
        KiemProperty[] properties = new KiemProperty[6];
        properties[0] = new KiemProperty(Constants.ESOFILE, fileProperty);
        if(filename != null) {
            fileProperty.setValue(properties[0], filename);
        }

        properties[1] = new KiemProperty(Constants.TRACENUM, new KiemPropertyTypeInt(), 0);
        properties[2] = new KiemProperty(Constants.TRAINMODE, false);
        properties[3] = new KiemProperty(Constants.CONFIGVAR, Constants.DEF_CONFIGVAR);
        properties[4] = new KiemProperty(Constants.OUTPUTVAR, Constants.DEF_OUTPUTVAR);
        properties[5] = new KiemProperty(Constants.PREVINVAR, Constants.DEF_PREVINVAR);

        return properties;
    }

    /**
     * Check whether the user actually selected an ESO file or messed up. This does not
     * actually try to read the file, it just checks for the correct extension.
     * 
     * @throws KiemPropertyException
     *             when the user messed up and did not select an ESI or ESO file
     */
    @Override
    public void checkProperties(KiemProperty[] properties) throws KiemPropertyException {
        for (KiemProperty prop : properties) {
            if (prop.getKey().equals(Constants.ESOFILE)) {
                if (!(prop.getValue().toLowerCase().endsWith(".esi") || prop.getValue()
                        .toLowerCase().endsWith(".eso"))) {
                    throw new KiemPropertyException(
                            Constants.ERR_NOTESO);
                }
            }
        }
    }
}
