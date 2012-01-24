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
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.json.JSONObject;

import de.cau.cs.kieler.core.util.Pair;
import de.cau.cs.kieler.sim.esi.EsiFile;
import de.cau.cs.kieler.sim.esi.ISignal;
import de.cau.cs.kieler.sim.esi.ITick;
import de.cau.cs.kieler.sim.esi.ITrace;
import de.cau.cs.kieler.sim.esi.ITraceProvider;
import de.cau.cs.kieler.sim.kart.engine.DefaultValidationEngine;
import de.cau.cs.kieler.sim.kart.engine.IValidationEngine;
import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.KiemEvent;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyException;
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
    /*
     * Strings used for properties
     */
    private static final String ESOFILE = "ESI/ESO trace file";
    private static final String TRACENUM = "Trace number to replay";
    private static final String VALEXTRA = "Validate extra information";
    private static final String EXTRAVARS = "Extra information signals";
    private static final String STATEVAR = "State variable";
    private static final String IGNOREEXTRA = "Ignore additionally generated signals";
    private static final String TRAINMODE = "Training mode";
    
    public static final String COMPONENTID = "de.cau.cs.kieler.sim.kart.DataValidationComponent";

    /** The number of the current step */
    private long step = 0;

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
     * The validation engine that will be used to validate signal and variable information
     */
    private IValidationEngine valEngine;

    /**
     * The name of the variable used for state information.
     */
    private String stateVariable;

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
            if (prop.getKey().equals(ESOFILE)) {
                filename = prop.getValue();
            } else if (prop.getKey().equals(TRACENUM)) {
                tracenum = prop.getValueAsInt();
            } else if (prop.getKey().equals(VALEXTRA)) {
                useState = prop.getValueAsBoolean();
            } else if (prop.getKey().equals(IGNOREEXTRA)) {
                ignoreAdditionalSignals = prop.getValueAsBoolean();
            } else if (prop.getKey().equals(TRAINMODE)) {
                trainingMode = prop.getValueAsBoolean();
            } else if (prop.getKey().equals(EXTRAVARS)) {
                specialSignals = Utilities.makeSet(prop.getValue().split(","));
            } else if (prop.getKey().equals(STATEVAR)) {
                stateVariable = prop.getValue();
                specialSignals.add(stateVariable);
            }
        }

        // Read the file

        if (!trainingMode) {
            ITraceProvider tracefile = new EsiFile();

            try {
                valEngine = new DefaultValidationEngine(editor, ignoreAdditionalSignals,
                        stateVariable);
                List<ITrace> tracelist = tracefile.loadTrace(filename);
                try {
                    trace = tracelist.get(tracenum);
                } catch (IndexOutOfBoundsException e) {
                    throw new KiemInitializationException(
                            "The trace file does not contain a trace number " + tracenum, true, e);
                }
            } catch (KiemInitializationException e) {
                trainingMode = true;
                throw new KiemInitializationException(
                        "Trace file is empty or does not exist. Switching to training mode.",
                        false, e);
            }
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
            TraceWriter writer = new TraceWriter(recInputs, recOutputs, recSpecialSignals, filename);
            writer.doWrite();
        }

        Utilities.visualizeStates(null, null, editor);
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
            System.out.println("New step " + step);
        }
    }

    /**
     * Return the types of events this component listens to
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

        KiemProperty[] properties = new KiemProperty[7];
        properties[0] = new KiemProperty(ESOFILE, fileProperty);
        if (filename != null) {
            fileProperty.setValue(properties[0], filename);
        }
        properties[1] = new KiemProperty(TRACENUM, new KiemPropertyTypeInt(), 0);
        properties[2] = new KiemProperty(VALEXTRA, true);
        properties[3] = new KiemProperty(EXTRAVARS);
        properties[4] = new KiemProperty(STATEVAR, "state");
        properties[5] = new KiemProperty(IGNOREEXTRA, false);
        properties[6] = new KiemProperty(TRAINMODE, false);

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
        Map<String, Object> outputSignals = Utilities.convertAndRecordSignals(obj, recInputs,
                recOutputs, recSpecialSignals, specialSignals);
        
        System.out.println("Doing step " + step);

        if (!trainingMode && trace.getSize() >= (step - 1)) {
            ITick tick = trace.get(step - 1);
            List<ISignal> signals = tick.getOutputs();

            Map<String, String> special = tick.getExtraInfos();

            if (useState) {
                Iterator<String> it = special.keySet().iterator();

                while (it.hasNext()) {
                    String key = it.next();
                    String value = special.get(key);

                    valEngine.validateVariable(key, value, obj.optString(key), isHistoryStep());
                }
            }

            valEngine.validateSignals(signals, outputSignals, isHistoryStep(), step);
        }

        return null;
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
        System.out.println("Input signals received: " + signals);
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
        return COMPONENTID;
    }
}
