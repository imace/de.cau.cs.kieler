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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.core.model.gmf.triggers.DiffStateTrigger;
import de.cau.cs.kieler.sim.esi.EsiFile;
import de.cau.cs.kieler.sim.esi.ISignal;
import de.cau.cs.kieler.sim.esi.ITick;
import de.cau.cs.kieler.sim.esi.ITrace;
import de.cau.cs.kieler.sim.esi.ITraceProvider;
import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.KiemPlugin;
import de.cau.cs.kieler.sim.kiem.internal.AbstractDataComponent;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyException;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeBool;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeEditor;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeFile;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeInt;
import de.cau.cs.kieler.sim.kiem.ui.datacomponent.JSONObjectSimulationDataComponent;

/**
 * This component implements a component to validate signal and state information generated in a
 * simulation against pre-recorded values. If the validation fails, the simulation is stopped and
 * the error is visualized in the SyncChart. Additionally, an explanatory error message is
 * displayed. This component does not provide any means to record or replay signal and state
 * information, refer to {@link DataRecordingComponent} and {@link DataReplayComponent}
 * 
 * @author Sebastian Schäfer - ssc AT informatik.uni-kiel.de
 * @kieler.rating 2011-11-29 red
 * 
 */
public class DataValidationComponent extends JSONObjectSimulationDataComponent implements
        IJSONObjectDataComponent {
    /** The single trace out of a ESI/ESO file the simulation shall be validated against */
    private ITrace trace = null;
    
    /** The name of the ESI/ESO file the trace shall be read/written from/to */
    private String filename = "";

    /** Shall we use state information? */
    private boolean useState = false;

    /** Shall we ignore signals generated by the simulation but not present in the ESO file? */
    private boolean ignoreAdditionalSignals = false;

    /** The currently active diagram editor */
    private DiagramEditor editor;

    /** Are we operating in training mode, i. e. generate an ESO file */
    private boolean trainingMode;
    
    /** A map of all values of all output signals in each step */
    private List<HashMap<String, Object>> recOutputs;
    
    /** A map of all values of all special signals in each step */
    private List<HashMap<String, Object>> recSpecialSignals;
    
    /** A map if all values of all input signals in each step.
     * Pushed here by the DataReplayComponent
     */
    private List<HashMap<String, Object>> recInputs;

    /** A list of special signals from the properties like a state signal that will be compared differently than
     * regular signals and are found in special comments in the ESO file
     */
    private Set<String> specialSignals;

    /**
     * Initialize the data component. Open an existing ESO file, read the expected signal and state
     * information and store it internally
     * 
     * @throws KiemInitializationException
     *             thrown when reading the file fails
     */
    @Override
    public void initialize() throws KiemInitializationException {
        KiemProperty[] properties = this.getProperties();
        
        recOutputs = new LinkedList<HashMap<String, Object>>();
        recSpecialSignals = new LinkedList<HashMap<String, Object>>();

        editor = (DiagramEditor) getActivePage().getActiveEditor();

        // Check whether an ESI/ESO file was provided
        try {
            checkProperties(properties);
        } catch (KiemPropertyException e) {
            throw new KiemInitializationException(
                    "The replay file provided is not an .esi or .eso file", true, e);
        }

        // load properties
        int tracenum = 0;
        specialSignals = new HashSet<String>();
        for (KiemProperty prop : properties) {
            System.out.println(prop.getKey());
            if (prop.getKey().equals("ESI/ESO trace file")) {
                System.out.println("Got filename: " + prop.getValue());
                System.out.println("And as filepath: " + prop.getFilePath());
                filename = prop.getValue();
            } else if (prop.getKey().equals("Trace to replay")) {
                tracenum = prop.getValueAsInt();
            } else if (prop.getKey().equals("Validate extra information")) {
                useState = prop.getValueAsBoolean();
            } else if (prop.getKey().equals("Ignore additionally generated signals")) {
                ignoreAdditionalSignals = prop.getValueAsBoolean();
            } else if (prop.getKey().equals("Training mode")) {
                trainingMode = prop.getValueAsBoolean();
            } else if (prop.getKey().equals("Extra information signals")) {
                System.out.println("Generating set of special signals");
                System.out.println("Value: " + prop.getValue());
                specialSignals = makeSet(prop.getValue().split(","));
            }
        }
        
        System.out.println("Special signals: " + specialSignals);

        // Read the file

        if(!trainingMode) {
            ITraceProvider tracefile = new EsiFile();
            
            try {
                List<ITrace> tracelist = tracefile.loadTrace(filename);
        
                try {
                    trace = tracelist.get(tracenum);
                } catch (IndexOutOfBoundsException e) {
                    throw new KiemInitializationException("The trace file does not contain a trace number "
                            + tracenum, true, e);
                }
        
                /*
                if (trace.current().getState() == null && useState == true) {
                    useState = false;
                    throw new KiemInitializationException(
                            "The trace file does not contain state information. "
                                    + "This validation run will not compare states!", false, null);
                }*/
            } catch(KiemInitializationException e) {
                trainingMode = true;
                //throw new KiemInitializationException("Trace file is empty or does not exist. Switching to training mode.", false, e);
            }
        }
    }

    /**
     * @param split
     * @return
     */
    private Set<String> makeSet(String[] split) {
        HashSet<String> retval = new HashSet<String>();
        
        for(int i = 0; i < split.length; i++) {
            retval.add(split[i]);
        }
        
        return retval;
    }

    /**
     * Wrapup this component. This component does not have anything to wrap up.
     * 
     * @throws KiemInitializationException
     *             never thrown
     */
    @Override
    public void wrapup() throws KiemInitializationException {
        if(trainingMode) {
            /*String filename = "";
            
            KiemProperty[] properties = getProperties();
            for(KiemProperty prop : properties) {
                if(prop.getKey().equals("Output file")) {
                    filename = prop.getFilePath();
                }
            }*/
            
            // Get input signals from ReplayComponent

            
            System.out.println("Going to write to file: " + filename);
                        
            if(recInputs == null) {
                System.out.println("Validation component: inp is null");
            }
            TraceWriter writer = new TraceWriter(recInputs, recOutputs, recSpecialSignals, filename);
            writer.doWrite();

        }
        
        if (DiffStateTrigger.getInstance() != null) {
            DiffStateTrigger.getInstance().synchronizedStep(null, null, editor);
        }

    }

    /**
     * This component may not be skipped so we tell KIEM that we also produce data, though we
     * actually do not.
     */
    @Override
    public boolean isProducer() {
        return true;
    }

    /**
     * Tell KIEM that this component does observe data.
     * 
     */
    @Override
    public boolean isObserver() {
        return true;
    }

    /**
     * Tell KIEM that we are not a delta observer
     */
    @Override
    public boolean isDeltaObserver() {
        return false;
    }

    /**
     * Provide a list of properties to KIEM so the user can configure this component.
     * 
     * @return the list of properties this component offers
     */
    @Override
    public KiemProperty[] provideProperties() {
        KiemProperty[] properties = new KiemProperty[7];
        properties[0] = new KiemProperty("Model editor", new KiemPropertyTypeEditor());
        properties[1] = new KiemProperty("ESI/ESO trace file", new KiemPropertyTypeFile());
        properties[2] = new KiemProperty("Trace number to replay", new KiemPropertyTypeInt(), 0);
        properties[3] = new KiemProperty("Validate extra information", true);
        properties[4] = new KiemProperty("Extra information signals", "state");
        properties[5] = new KiemProperty("Ignore additionally generated signals",
                new KiemPropertyTypeBool(), 0);
        properties[6] = new KiemProperty("Training mode", false);

        return properties;
    }

    /**
     * Take a step in the simulation. The component reads its internal state and compares the signal
     * and possibly state information from the ESO file to the signals and state information
     * generated by the simulation.
     * 
     * @throws KiemExecutionException
     *             when the JSON object with signals from ESI/ESO file could not be built.
     */
    @Override
    public JSONObject step(JSONObject obj) throws KiemExecutionException {
        if(trainingMode) {
            addSignalsToRecording(obj);
        } else {
            if(trace.hasNext()) {
                ITick tick = trace.next();
                List<ISignal> signals = tick.getOutputs();
                Map<String, String> special = tick.getExtraInfos();
                
                if(useState) {
                    Iterator<String> it = special.keySet().iterator();
                    
                    while(it.hasNext()) {
                        String key = it.next();
                        String value = special.get(key);
                        
                        diffSpecial(key, value, obj);
                    }
                        
                }
                diffSignals(signals, obj);
            }
        }
        
        return null;
    }
            

    /**
     * @param obj
     */
    private void addSignalsToRecording(JSONObject obj) {
        @SuppressWarnings("unchecked") // necessary because the JSON library does not return a parameterized Iterator
        Iterator<String> keys = obj.keys();
        
        HashMap<String, Object> signals = new HashMap<String, Object>();
        HashMap<String, Object> extraInfo = new HashMap<String, Object>();
        
        while(keys.hasNext()) {
            String key = keys.next();
            System.out.println("Key: " + key + ", isSpecialSignal: " + isSpecialSignal(key));
            try {
                if(!isSpecialSignal(key) && obj.getJSONObject(key).getBoolean("present")) {
                    Object val = obj.getJSONObject(key).opt("value");
                    signals.put(key, val);
                }
                if(isSpecialSignal(key)) {
                    Object val = obj.get(key);
                    extraInfo.put(key, val);
                }
            } catch(JSONException e) {
                e.printStackTrace();
            }
        }
        
        recOutputs.add(signals);
        recSpecialSignals.add(extraInfo);
    }

    /**
     * @param key
     * @return
     */
    private boolean isSpecialSignal(String key) {
        return specialSignals.contains(key);
    }

    // TODO: JavaDoc documentation
    private void diffSpecial(String key, String value, JSONObject obj) throws KiemExecutionException {
        String simValue = obj.optString(key);
        if (simValue == null) {
            throw new KiemExecutionException(
                    "The simulation step did not generate an extra signal \"" + key + "\". "
                            + "No validation for this signal will take place in this step!", false,
                    null);
        } else {
            if (!simValue.equals(value)) {
                List<EObject> isStates = getStates(simValue);
                List<EObject> shallStates = getStates(value);

                // Get meaningful names for the states
                String stateName = shallStates.get(shallStates.size() - 1).toString();
                String simStateName = isStates.get(shallStates.size() - 1).toString();

                // Colorize the diagram
                if (DiffStateTrigger.getInstance() != null) {
                    DiffStateTrigger.getInstance().synchronizedStep(isStates,
                            shallStates, editor);
                }

                // Display an error message
                throw new KiemExecutionException(
                        "Validation error: The simulation should provide an extra info representing " + stateName
                                + " but it actually provided " + simStateName, false, null);
            }
        }
    }

    /**
     * Generate a List of the states contained in the parameter string
     * 
     * @param stateString
     *            the string of states to be converted into a List
     * @return a List of states
     */
    private List<EObject> getStates(String stateString) {
        List<EObject> retval = new ArrayList<EObject>();
        String[] states = stateString.replaceAll("\\s", "").split(",");
        for (String state : states) {
            retval.add(editor.getDiagram().getElement().eResource().getEObject(state));
        }
        return retval;
    }

    private void diffSignals(List<ISignal> recSignals, JSONObject simData)
            throws KiemExecutionException {
        Iterator<ISignal> recSignalIt = recSignals.iterator();

        while (recSignalIt.hasNext()) {
            ISignal recSignal = recSignalIt.next();

            try {
                JSONObject simSignal = simData.getJSONObject(recSignal.getName());
                if (simSignal.getString("present").equals("false")) {
                    throw new KiemExecutionException("Validation error: Signal \""
                            + recSignal.getName() + "\" is not present, but it should be.", false,
                            null);
                }

                if (recSignal.isValued()) {
                    String simValue = simSignal.optString("value");
                    if (simValue.equals("")) {
                        throw new KiemExecutionException("Validation error: Signal \""
                                + recSignal.getName()
                                + "\" is recorded as a valued signal with value \""
                                + recSignal.getValue()
                                + "\" but is not a valued signal in the simulation", true, null);
                    } else if (!simSignal.getString("value").equals(recSignal.getValue())) {
                        throw new KiemExecutionException("Validation error: Signal \""
                                + recSignal.getName() + "\" is recorded with value \""
                                + recSignal.getValue() + "\" but was simulated with value \""
                                + simValue + "\"", false, null);
                    }
                }

                recSignalIt.remove();

            } catch (JSONException e) {
                throw new KiemExecutionException("Validation error: The recorded signal \""
                        + recSignal.getName() + "\" was not generated in the simulation", false,
                        null);
            }
        }

        if (!ignoreAdditionalSignals) {
            if (!recSignals.isEmpty()) {
                String excessSignals = "";
                Iterator<ISignal> it = recSignals.iterator();
                while (it.hasNext()) {
                    excessSignals += "\"" + it.next().getName() + "\"";
                    if (it.hasNext()) {
                        excessSignals += ", ";
                    }
                }

                throw new KiemExecutionException("Validation error: The signal(s) " + excessSignals
                        + " were not recorded, but generated in the simulation", false, null);
            }
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
            if (prop.getKey().equals("ESI/ESO trace file")) {
                if (!(prop.getValue().toLowerCase().endsWith(".esi") || prop.getValue()
                        .toLowerCase().endsWith(".eso"))) {
                    throw new KiemPropertyException(
                            "The replay file provided is not a .esi or .eso file");
                }
            }
        }
    }

    /**
     * Receive the inputs signals for each step from the replay component.
     * These signals will be pushed here during the wrapup of that component.
     * 
     * @param recInputs the recorded input signals
     */
    public void putInputs(List<HashMap<String, Object>> recInputs) {
        if(recInputs == null) {
            System.out.println("Got null from replay component!");
        }
        System.out.println("Receiving inputs from replay component");
        this.recInputs = recInputs;
    }
    
    /**
     * Return a well-defined component ID, so that this component can be identified
     * by the replay component which will push (part) of its data here.
     * 
     * {@inheritDoc}
     */
    @Override
    public String getDataComponentId() {
        return "de.cau.cs.kieler.sim.kart.DataValidationComponent";
    }
}
