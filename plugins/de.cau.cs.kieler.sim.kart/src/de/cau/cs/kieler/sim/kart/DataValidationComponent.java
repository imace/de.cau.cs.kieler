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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.sim.kart.engine.DefaultValidationEngine;
import de.cau.cs.kieler.sim.kart.engine.IValidationEngine;
import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.KiemEvent;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyException;
import de.cau.cs.kieler.sim.kiem.ui.datacomponent.JSONObjectSimulationDataComponent;
import de.cau.cs.kieler.sim.signals.JSONSignalValues;

/**
 * This component implements a KIEM data component to validate signal and state information
 * generated in a simulation against pre-recorded values. If the validation fails, the simulation is
 * stopped and the error is visualized in the SyncChart. Additionally, an explanatory error message
 * is displayed. This component does not provide any means to record or replay signal and state
 * information, refer to {@link DataRecordingComponent} and {@link DataReplayComponent}
 * 
 * @author Sebastian Schäfer - ssc AT informatik.uni-kiel.de
 * @kieler.rating 2011-11-29 red
 * 
 */
public class DataValidationComponent extends JSONObjectSimulationDataComponent implements
        IJSONObjectDataComponent {
    /** The number of the current step */
    private long step;

    /** The name of the ESI/ESO file the trace shall be read/written from/to */
    private String filename;

    /** Shall we ignore signals generated by the simulation but not present in the ESO file? */
    private boolean ignoreAdditionalSignals;

    /** The currently active diagram editor */
    private DiagramEditor editor;

    /** Are we operating in training mode, i. e. generate an ESO file */
    private boolean trainingMode;

    /** A map of all values of all previously recorded output signals in each step */
    private List<HashMap<String, Object>> esoOutputs;

    /** A map of all values of all previously recorded special signals in each step */
    private List<HashMap<String, String>> esoVariables;
    
    /** In training mode, this list will hold all simulated output signals and their values
     * for each step
     */
    private List<HashMap<String, Object>> simOutputs;
    
    /** In training mode, this list will hold all simulated output variables and their values
     * for each step
     */
    private List<HashMap<String, String>> simVariables;

    /**
     * A map f all values of all simulated or recorded input signals in each step. Pushed here by
     * the DataReplayComponent
     */
    private List<HashMap<String, Object>> recInputs;

    /**
     * A list of special signals from the properties like a state signal that will be compared
     * differently than regular signals and are found in special comments in the ESO file
     */
    private Set<Pair<String, String>> variables;

    /**
     * The validation engine that will be used to validate signal and variable information
     */
    private IValidationEngine valEngine;

    /** Name of the variable the replay component will give us our configuration through */
    private String configVarName;

    /**
     * Name of the variable the replay component will give us the values of the output signals and
     * variables through
     */
    private String outputVarName;
    
    /** Name of the variable under which all signals injected into the simulation by components
     * in front of this component will be saved. These will be regarded as input signals when
     * writing an ESO file.
     */
    private String prevInputVar;
    
    /** Name of the variable used to communicate information about erroneous signals */
    private String errSignalVar;
    
    /** Set to true when the end of the trace is reached. At this point no further validation will
     * take place
     */
    private boolean eot;

    /**
     * Initialize the data component. Open an existing ESO file, read the expected signal and state
     * information and store it internally
     * 
     * @throws KiemInitializationException
     *             thrown when reading the file fails
     */
    @Override
    public void initialize() throws KiemInitializationException {
        step = 0;
        eot = false;
        filename = "";
        ignoreAdditionalSignals = false;
        configVarName = Constants.DEF_CONFIGVAR;
        outputVarName = Constants.DEF_OUTPUTVAR;
        prevInputVar = Constants.DEF_PREVINVAR;
        errSignalVar = Constants.DEF_SIGNALVAR;
        variables = Utilities.makeSetOfPairs(Constants.DEF_VALVAR);

        KiemProperty[] properties = this.getProperties();

        esoOutputs = new LinkedList<HashMap<String, Object>>();
        esoVariables = new LinkedList<HashMap<String, String>>();
        simOutputs = new LinkedList<HashMap<String, Object>>();
        simVariables = new LinkedList<HashMap<String,String>>();
        recInputs = new LinkedList<HashMap<String, Object>>();

        editor = (DiagramEditor) getActivePage().getActiveEditor();

        // load properties
        variables = new HashSet<Pair<String, String>>();
        for (KiemProperty prop : properties) {
            if (prop.getKey().equals(Constants.IGNOREEXTRA)) {
                ignoreAdditionalSignals = prop.getValueAsBoolean();
            } else if (prop.getKey().equals(Constants.VALVAR)) {
                variables = Utilities.makeSetOfPairs(prop.getValue());
            } else if (prop.getKey().equals(Constants.CONFIGVAR)) {
                configVarName = prop.getValue();
            } else if (prop.getKey().equals(Constants.OUTPUTVAR)) {
                outputVarName = prop.getValue();
            } else if (prop.getKey().equals(Constants.PREVINVAR)) {
                prevInputVar = prop.getValue();
            } else if (prop.getKey().equals(Constants.SIGNALVAR)) {
                errSignalVar = prop.getValue();
            }
        }

        // Read the file

        if (!trainingMode) {
            valEngine = new DefaultValidationEngine(editor, ignoreAdditionalSignals);
        }
    }

    /**
     * Wrapup this component. This writes an ESO file in training mode and always resets the state
     * visualization.
     * 
     * @throws KiemInitializationException
     *             when TraceWriter.doWrite() throws it
     */
    public void wrapup() throws KiemInitializationException {
        if (trainingMode) {
            TraceWriter writer = new TraceWriter(recInputs, simOutputs, simVariables, filename);
            writer.doWrite();
        }
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
     * This component may not be skipped so we tell KIEM that we also produce data, though we
     * actually do not.
     * 
     * @return always true
     */
    @Override
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
     * Tell KIEM that we are also interested in history data
     * 
     * @return always true
     */
    @Override
    public boolean isHistoryObserver() {
        return true;
    }

    /**
     * Tell KIEM that we are *not* a delta observer
     * 
     * @return always false
     */
    @Override
    public boolean isDeltaObserver() {
        return true;
    }

    /**
     * Provide a list of properties to KIEM so the user can configure this component.
     * 
     * @return the list of properties this component offers
     */
    @Override
    public KiemProperty[] doProvideProperties() {
        KiemProperty[] properties = new KiemProperty[6];
        properties[0] = new KiemProperty(Constants.CONFIGVAR, Constants.DEF_CONFIGVAR);
        properties[1] = new KiemProperty(Constants.OUTPUTVAR, Constants.DEF_OUTPUTVAR);
        properties[2] = new KiemProperty(Constants.PREVINVAR, Constants.DEF_PREVINVAR);
        properties[3] = new KiemProperty(Constants.VALVAR, Constants.DEF_VALVAR);
        properties[4] = new KiemProperty(Constants.SIGNALVAR, Constants.DEF_SIGNALVAR);
        properties[5] = new KiemProperty(Constants.IGNOREEXTRA, false);

        return properties;
    }

    /**
     * Take a step in the simulation. The component reads its internal state and compares the signal
     * and possibly state information from the ESO file to the signals and state information
     * generated by the simulation.
     * 
     * @return always {@code null}
     * @throws KiemExecutionException
     *             when the JSON object with signals from ESI/ESO file could not be built.
     */
    @Override
    public JSONObject doStep(JSONObject obj) throws KiemExecutionException {
        updateConfiguration(obj);
        if(!eot) {
            getEsoData(obj);
            recordDataPool(obj);
        }
        
        JSONObject retval = null;
        if (!trainingMode && !eot) {
            retval = new JSONObject();
    
            for (Pair<String, String> variable : variables) {
                valEngine.validateVariable(variable,
                        esoVariables.get((int) step - 1).get(variable.getFirst()),
                        obj.optString(variable.getFirst()), isHistoryStep(), retval);
            }
            
            valEngine.validateSignals(esoOutputs.get((int) step - 1), simOutputs.get((int) step - 1), isHistoryStep(), errSignalVar, retval);
        }
        return retval;
    }
    
    /**
     * Update the internal configuration with values received from the replay component
     * through the data pool.
     * 
     * @param json the data pool JSON object
     * @throws KiemExecutionException when reading the JSON object fails
     */
    private void updateConfiguration(JSONObject json) throws KiemExecutionException {
        try {
            JSONObject config = json.getJSONObject(configVarName);
            filename = (String) config.get(Constants.VAR_ESOFILE);
            trainingMode = ((Boolean) config.get(Constants.VAR_TRAINMODE)).booleanValue();
            eot = ((Boolean) config.get(Constants.VAR_EOT)).booleanValue();
        } catch (JSONException e) {
            throw new KiemExecutionException("Could not update configuration", true, e);
        }
    }
    
    private void recordDataPool(JSONObject json) throws KiemExecutionException {
        String[] fieldNames = JSONObject.getNames(json);
        HashMap<String,Object> signals = new HashMap<String,Object>();
        HashMap<String,String> vars = new HashMap<String,String>();
        
        for(String field : fieldNames) {
            try {
                Object obj = json.get(field);
                if(obj instanceof JSONObject && JSONSignalValues.isSignalValue(obj)) {
                    // it's a signal
                    if(JSONSignalValues.isPresent(obj) && !recInputs.get((int) step - 1).containsKey(field)) {
                        signals.put(field, JSONSignalValues.getSignalValue(obj));
                    }
                } else {
                    // we do not want to record our internal variables to the ESO file, that
                    // would most definitely bite us in the ass during replay. We also do not
                    // want variables with no value in the ESO file.
                    if(!( field.equals(configVarName)
                       || field.equals(outputVarName)
                       || field.equals(prevInputVar)
                       || obj.toString().isEmpty())) {
                        vars.put(field, obj.toString());
                    }
                }
            } catch (JSONException e) {
                throw new KiemExecutionException("Cannot read data pool", true, e);
            }
        }
        
        simOutputs.add(signals);
        simVariables.add(vars);
    }
    
    private void getEsoData(JSONObject json) throws KiemExecutionException {
        try {
            /*
             * Record previous input signals
             */
            HashMap<String,Object> inputSignals = new HashMap<String,Object>();
            JSONObject prevInput = json.getJSONObject(prevInputVar);
            
            // this is necessary because the JSON library return an unparameterized Iterator.
            @SuppressWarnings("unchecked")
            Iterator<String> keys = prevInput.keys();
            
            while(keys.hasNext()) {
                String key = keys.next();
                if(JSONSignalValues.isPresent(prevInput.opt(key))) {
                    inputSignals.put(key, JSONSignalValues.getSignalValue(prevInput.opt(key)));
                }
            }
            recInputs.add(inputSignals);
            
            if(!trainingMode) {
                /*
                 * Record output signals and variables
                 */
                HashMap<String,Object> outputSignals = new HashMap<String,Object>();
                HashMap<String,String> outputVariables = new HashMap<String,String>();
                JSONObject output = json.getJSONObject(outputVarName);
                
                // again, this is necessary because the JSON library returns an unparameterized Iterator.
                @SuppressWarnings("unchecked")
                Iterator<String> outputKeys = output.keys();
                
                while(outputKeys.hasNext()) {
                    String outputKey = outputKeys.next();
                    
                    try {
                        JSONObject outputSignal = output.getJSONObject(outputKey);
                        if(outputSignal.has("present") && outputSignal.getBoolean("present") == true) {
                            // it actually is a present signal
                            outputSignals.put(outputKey, outputSignal.opt("value"));
                        }
                    } catch (JSONException e) {
                        // it probably is a variable
                        outputVariables.put(outputKey, output.optString(outputKey));
                    }
                }
                
                esoOutputs.add(outputSignals);
                esoVariables.add(outputVariables);
            }
        } catch(JSONException e) {
            throw new KiemExecutionException(Constants.ERR_JSON, true, e);
        }
    }

    /**
     * Check whether the user actually selected an ESI or ESO file or messed up. This does not
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
                    throw new KiemPropertyException(Constants.ERR_NOTESO);
                }
            }
        }
    }
}
