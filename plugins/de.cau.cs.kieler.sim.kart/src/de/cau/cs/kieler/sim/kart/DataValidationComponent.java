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

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.ui.IEditorInput;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.core.model.gmf.triggers.DiffStateTrigger;
import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.sim.esi.EsiFile;
import de.cau.cs.kieler.sim.esi.ISignal;
import de.cau.cs.kieler.sim.esi.ITick;
import de.cau.cs.kieler.sim.esi.ITrace;
import de.cau.cs.kieler.sim.esi.ITraceProvider;
import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.KiemEvent;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyException;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeBool;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeFile;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeInt;
import de.cau.cs.kieler.sim.kiem.ui.datacomponent.JSONObjectSimulationDataComponent;
import de.cau.cs.kieler.synccharts.Scope;

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
    /** The number of the current step */
    private int step = 0;
    
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

    /**
     * A map if all values of all input signals in each step. Pushed here by the DataReplayComponent
     */
    private List<HashMap<String, Object>> recInputs = new LinkedList<HashMap<String, Object>>();

    /**
     * A list of special signals from the properties like a state signal that will be compared
     * differently than regular signals and are found in special comments in the ESO file
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
        recInputs = new LinkedList<HashMap<String, Object>>();

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
            if (prop.getKey().equals("ESI/ESO trace file")) {
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
                specialSignals = makeSet(prop.getValue().split(","));
            }
        }

        // Read the file

        if (!trainingMode) {
            ITraceProvider tracefile = new EsiFile();

            try {
                List<ITrace> tracelist = tracefile.loadTrace(filename);

                try {
                    trace = tracelist.get(tracenum);
                } catch (IndexOutOfBoundsException e) {
                    throw new KiemInitializationException(
                            "The trace file does not contain a trace number " + tracenum, true, e);
                }

                /*
                 * if (trace.current().getState() == null && useState == true) { useState = false;
                 * throw new KiemInitializationException(
                 * "The trace file does not contain state information. " +
                 * "This validation run will not compare states!", false, null); }
                 */
            } catch (KiemInitializationException e) {
                trainingMode = true;
                // FIXME: Although the mustStop param is set to false, execution is aborted.
                throw new KiemInitializationException(
                        "Trace file is empty or does not exist. Switching to training mode.",
                        false, e);
            }
        }
    }

    /**
     * @param split
     * @return
     */
    private Set<String> makeSet(String[] split) {
        HashSet<String> retval = new HashSet<String>();

        for (int i = 0; i < split.length; i++) {
            retval.add(split[i]);
        }

        return retval;
    }

    /**
     * Wrapup this component. This component does not have anything to wrap up.
     * 
     * @throws KiemInitializationException
     *             when {@link #removeInputFromOutput(List, List)} throws it
     */
    public void wrapup() throws KiemInitializationException {
        if (trainingMode) {
            // we rather do this when recording, seems more logical
            // we would need to do it there anyway, to ensure correct validation
            // removeInputFromOutput(recInputs, recOutputs);
            TraceWriter writer = new TraceWriter(recInputs, recOutputs, recSpecialSignals, filename);
            writer.doWrite();

        }

        if (DiffStateTrigger.getInstance() != null) {
            DiffStateTrigger.getInstance().synchronizedStep(null, null, editor);
        }
    }

    /**
     * Removes the input signals from the map of output signals. This is necessary for writing
     * ESI/ESO files, as the input signals may not appear in the list of output signals, although
     * they are present in the simulation and thus recorded as an output signal. The list of maps
     * given as parameter {outputSignals} will be modified by this method.
     * 
     * @param inputSignals
     *            the list of maps of input signals
     * @param outputSignals
     *            the list of maps of output signals
     * @throws KiemInitializationException
     *             when the length of the input and output signals lists differs
     * @deprecated no longer necessary and unused
     */
    private void removeInputFromOutput(List<HashMap<String, Object>> inputSignals,
            List<HashMap<String, Object>> outputSignals) throws KiemInitializationException {
        if (inputSignals.size() != outputSignals.size()) {
            throw new KiemInitializationException(
                    "The number of steps recorded for input and output signals differs! "
                            + "Cannot remove input signals from list of output signals", true, null);
        } else {
            for (int i = 0; i < inputSignals.size(); i++) {
                for (String signal : inputSignals.get(i).keySet()) {
                    outputSignals.get(i).remove(signal);
                }
            }
        }
    }
    
    /**
     * Sets the step number according to the button the user pressed. This is needed to
     * correctly handle history steps or jumps.
     */
    @SuppressWarnings("unchecked")
    @Override 
    public void notifyEvent(KiemEvent event) {
        System.out.println("Got an event with types: " + event.getEventCodesAsList());
        if(event.isEvent(KiemEvent.STEP_INFO) && event.getInfo() instanceof Pair) {
            step = ((Pair<Long, Long>) event.getInfo()).getFirst().intValue();
        }
    }
    
    /**
     * Return the types of events this component listens to
     */
    @Override
    public KiemEvent provideEventOfInterest() {
        int[] events = {KiemEvent.STEP_INFO};
        KiemEvent event = new KiemEvent(events);
        return event;
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
     * Tell KIEM that we are also interested in history data
     */
    @Override
    public boolean isHistoryObserver() {
        return true;
    }

    /**
     * Tell KIEM that we are *not* a delta observer
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
    public KiemProperty[] doProvideProperties() {
        String[] exts = { "*.eso", "*.esi" };
        String[] extNames = { "ESO", "ESI" };

        KiemPropertyTypeFile fileProperty = new KiemPropertyTypeFile(true);
        fileProperty.setFilterExts(exts);
        fileProperty.setFilterNames(extNames);

        String filename = null;
        try {
            /*
             * The try block is necessary to suppress NPEs and other exception when we are either
             * running in headless mode or there are no editor opened. Below, you will see that a
             * filename is only proposed if this try block succeeds. We have to use absolute file
             * paths here, because the KiemPropertyTypeFile dialog only returns absolute paths. I do
             * not want to change that for fear that something else breaks.
             */
            URI resource = ((DiagramEditor) getActivePage().getActiveEditor()).getDiagram()
                    .eResource().getURI().trimFileExtension().appendFileExtension("eso");
            URI absFile = CommonPlugin.resolve(resource);
            filename = absFile.toFileString();
        } catch (Exception e) {
            // do nothing
        }

        KiemProperty[] properties = new KiemProperty[6];
        properties[0] = new KiemProperty("ESI/ESO trace file", fileProperty);
        if (filename != null) {
            fileProperty.setValue(properties[0], filename);
        }
        properties[1] = new KiemProperty("Trace number to replay", new KiemPropertyTypeInt(), 0);
        properties[2] = new KiemProperty("Validate extra information", true);
        properties[3] = new KiemProperty("Extra information signals", "state");
        properties[4] = new KiemProperty("Ignore additionally generated signals", false);
        properties[5] = new KiemProperty("Training mode", false);

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
    public JSONObject doStep(JSONObject obj) throws KiemExecutionException {
        Map<String, Object> outputSignals = convertAndRecordSignals(obj);
        
        System.out.println("Validating step number " + step);

        if (!trainingMode && trace.getSize() >= (step - 1)) {
            ITick tick = trace.get(step - 1);
            List<ISignal> signals = tick.getOutputs();

            Map<String, String> special = tick.getExtraInfos();

            if (useState) {
                Iterator<String> it = special.keySet().iterator();

                while (it.hasNext()) {
                    String key = it.next();
                    String value = special.get(key);

                    diffSpecial(key, value, obj);
                }

            }

            diffSignals(signals, outputSignals);
        }

        return null;
    }

    /**
     * Converts a JSON object representing the simulation's signals to a map and records the signals
     * internally. Input and special signals are automatically stripped from the returned map, thus
     * a map of true output signals, i. e. those that only became present after executing the
     * {@link DataReplayComponent}, is returned.
     * 
     * @param obj
     *            the JSON object representing the simulation's signals
     * @return the map of true output signals
     */
    private HashMap<String, Object> convertAndRecordSignals(JSONObject obj) {
        @SuppressWarnings("unchecked")
        // necessary because the JSON library does not return a parameterized Iterator
        Iterator<String> keys = obj.keys();

        HashMap<String, Object> signals = new HashMap<String, Object>();
        HashMap<String, Object> extraInfo = new HashMap<String, Object>();

        HashMap<String, Object> inputs = new HashMap<String, Object>();
        if (recInputs.size() > 0) {
            recInputs.get(recInputs.size() - 1);
        }

        while (keys.hasNext()) {
            String key = keys.next();
            try {
                if (!inputs.containsKey(key) && !isSpecialSignal(key)
                        && obj.getJSONObject(key).getBoolean("present")) {
                    Object val = obj.getJSONObject(key).opt("value");
                    signals.put(key, val);
                }
                if (isSpecialSignal(key)) {
                    Object val = obj.get(key);
                    extraInfo.put(key, val);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        recOutputs.add(signals);
        recSpecialSignals.add(extraInfo);

        return signals;
    }

    /**
     * @param key
     * @return
     */
    private boolean isSpecialSignal(String key) {
        return specialSignals.contains(key);
    }

    // TODO: JavaDoc documentation
    private void diffSpecial(String key, String value, JSONObject obj)
            throws KiemExecutionException {
        
        // undo effects from previous step
        if (DiffStateTrigger.getInstance() != null) {
            DiffStateTrigger.getInstance().synchronizedStep(null, null,
                    editor);
        }
        
        String simValue = obj.optString(key);
        if (simValue == null) {
            throw new KiemExecutionException("Validation error", false, new ValidationException(
                    "The simulation step did not generate a variable \"" + key + "\". "
                            + "No validation for this signal will take place in this step!"));
        } else {
            if (!simValue.equals(value)) {
                if (key.equals("state")) {
                
                    List<EObject> isStates = getStates(simValue);
                    List<EObject> shallStates = getStates(value);

                    // Colorize the diagram
                    if (DiffStateTrigger.getInstance() != null) {
                        DiffStateTrigger.getInstance().synchronizedStep(isStates, shallStates,
                                editor);
                    }

                    // Get meaningful names for the states
                    String stateNamesTree = buildTree(new Tree(null), shallStates).toString();
                    String simStateNamesTree = buildTree(new Tree(null), isStates).toString();
                    
                    if(!isHistoryStep()) {
                        // Display an error message
                        String errorMessage = "Validation error: The simulation's active states should be:\n"
                                + stateNamesTree
                                + "\nbut the states actually active are:\n"
                                + simStateNamesTree;
                        
                        throw new KiemExecutionException("Validation error", false,
                                new ValidationException(errorMessage));
                    }
                } else if(!isHistoryStep()) {
                    throw new KiemExecutionException("Validation error", false,
                            new ValidationException(
                                    "Validation error: The simulation should provide a variable \""
                                            + key + "\" with a value of \"" + value
                                            + "\", but it actually generated the value \""
                                            + simValue + "\"."));
                }
            }
        }
    }

    /**
     * Build a tree-like list of states with indentations.
     * Indirect descent, i. e. one or more nodes between two states in the list
     * is not displayed. The descendant node will be displayed as a direct child
     * of its ancestor.
     * 
     * @param root MUST ALWAYS be {@code new Tree(null)}
     *        states list of states that shall be put in the tree structure
     * @return
     */
    private Tree buildTree(Tree root, List<EObject> states) {
        while(!states.isEmpty()) {
            EObject itemObject = states.get(0);
            states.remove(0);
            
            if(itemObject instanceof Scope) {
                boolean breakIf = false;
                Scope item = (Scope) itemObject;
                Tree itemTree = new Tree(item);
                
                while(item.eContainer() != null) {
                    if(states.contains(item.eContainer())) {
                        states.remove(item.eContainer());
                        Tree parentTree = new Tree((Scope) item.eContainer());
                        parentTree.addChild(itemTree);
                        itemTree = parentTree;
                    }
                    else {
                        Tree parentTree = root.findValue((Scope) item.eContainer());
                        if(parentTree != null) {
                            parentTree.addChild(itemTree);
                            breakIf = true;
                            break;
                        }
                    }
                    item = (Scope) item.eContainer();
                }
                
                if(!breakIf) {
                    root.addChild(itemTree);
                }

            }
        }
                
        return root;
    }

    /**
     * Create a hyphened list of states out of a list.
     * 
     * @param stateList A list of states
     * @deprecated Output is now organized as a tree: {@link buildTree()}
     * @return The list of the names of the states, one per line, preceded by a hyphen
     */
    private String getActiveStateNames(List<EObject> stateList) {
        String retval = "";

        for (EObject state : stateList) {
            if (state instanceof Scope) {
                retval += "- " + ((Scope) state).getLabel() + "\n";
            }
        }
        return retval;
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

    private void diffSignals(List<ISignal> recSignals, Map<String, Object> simSignals)
            throws KiemExecutionException {
        Iterator<ISignal> it = recSignals.iterator();
        while (it.hasNext()) {
            ISignal recSignal = it.next();
            // presence
            if (!simSignals.containsKey(recSignal.getName())) {
                throw new KiemExecutionException("Validation error", false,
                        new ValidationException("Validation error: Signal \"" + recSignal.getName()
                                + "\" is not present, but it should be."));
            }

            // value
            if (recSignal.isValued()
                    && !(recSignal.getValue() == simSignals.get(recSignal.getName()))) {
                throw new KiemExecutionException(
                        "Validation error",
                        false,
                        new ValidationException(
                                "Validation error: Signal \""
                                        + recSignal.getName()
                                        + "\" was recorded as a valued signal with value \""
                                        + recSignal.getValue()
                                        + "\" but "
                                        + ((simSignals.get(recSignal.getName()) == null) ? "is not a valued signal in the simulation."
                                                : ("was simulatated with value \""
                                                        + recSignal.getValue() + "\"."))));
            }

            it.remove();
        }

        // additional signals
        if (!ignoreAdditionalSignals && !recSignals.isEmpty()) {
            String excessSignals = "";
            Iterator<ISignal> it2 = recSignals.iterator();
            while (it2.hasNext()) {
                excessSignals += "\"" + it2.next().getName() + "\"";

                if (it2.hasNext()) {
                    excessSignals += ", ";
                }
            }

            throw new KiemExecutionException("Validation error", false, new ValidationException(
                    "Validation error: The signal(s) " + excessSignals
                            + " were not recorded, but generated in the simulation"));
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
     * Receive the inputs signals for a step from the replay component. These signals will be pushed
     * here during a step of that component. They are aggregated internally and used for writing an
     * ESI/ESO file during wrapup, when in training mode.
     * 
     * @param signals
     *            the recorded input signals
     */
    public void putInputs(final HashMap<String, Object> signals) {
        this.recInputs.add(signals);
    }

    /**
     * Return a well-defined component ID, so that this component can be identified by the replay
     * component which will push (part) of its data here.
     * 
     * {@inheritDoc}
     */
    @Override
    public String getDataComponentId() {
        return "de.cau.cs.kieler.sim.kart.DataValidationComponent";
    }
    
    private class Tree {
        private Scope value;
        private List<Tree> children;
        
        public Tree(Scope value) {
            this.value = value;
            children = new LinkedList<Tree>();
        }
        
        public Scope getValue() {
            return value;
        }
        
        public void setValue(Scope value) {
            this.value = value;
        }

        public Tree findValue(Scope find) {
            Tree retval = null;
            if(value != null && value.equals(find)) {
                retval = this;
            }
            else {
                for(Tree child : children) {
                    retval = child.findValue(find);
                    break;
                }
            }
            return retval;
        }
        
        public void addChild(Tree child) {
            this.children.add(child);
        }
        
        public String toString() {
            return toString("");
        }
        
        public String toString(String indent) {
            String retval = "";
            if(value != null) {
                retval = indent + "- " + getValue().getLabel() + "\n";
            }
            for(Tree child : children) {
                retval += child.toString(indent + "  ");
            }
            return retval;
        }
    }
}
