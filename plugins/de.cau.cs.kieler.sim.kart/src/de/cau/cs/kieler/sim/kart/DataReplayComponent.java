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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.sim.esi.EsiFile;
import de.cau.cs.kieler.sim.esi.ISignal;
import de.cau.cs.kieler.sim.esi.ITick;
import de.cau.cs.kieler.sim.esi.ITrace;
import de.cau.cs.kieler.sim.esi.ITraceProvider;
import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.signals.JSONSignalValues;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.KiemPlugin;
import de.cau.cs.kieler.sim.kiem.internal.DataComponentWrapper;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyException;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeFile;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeInt;
import de.cau.cs.kieler.sim.kiem.ui.datacomponent.JSONObjectSimulationDataComponent;

/**
 * Implements a data component for KIEM that reads a ESI/ESO trace file and in each step of the
 * simulation replays the corresponding signals. This component does not provide a training mode to
 * write ESO trace files, please use the {@link DataRecordingComponent} to do this.
 * 
 * @author Sebastian Schäfer - ssc AT informatik.uni-kiel.de
 * @kieler.rating 2011-11-24 red
 */
public class DataReplayComponent extends JSONObjectSimulationDataComponent implements
        IJSONObjectDataComponent {

    /** The single trace out of a ESI/ESO file that shall be replayed */
    private ITrace trace = null;
    
    /** Are we in training mode, i. e. recording, or not */
    private boolean trainingMode;
    
    /** The validation component input signals will be sent to when in training mode */
    private DataValidationComponent valComponent = null;

    /**
     * Initialize the data component. Reads the whole ESI/ESO file and saves it internally for
     * replay.
     * 
     * @throws KiemInitializationException
     *             thrown when reading the file fails
     */
    public void initialize() throws KiemInitializationException {
        KiemProperty[] properties = this.getProperties();

        // Check whether an ESI/ESO file was provided
        try {
            checkProperties(properties);
        } catch (KiemPropertyException e) {
            throw new KiemInitializationException(
                    "The replay file provided is not an .esi or .eso file", true, e);
        }

        // load properties
        String filename = "";
        int tracenum = 0;
        for (KiemProperty prop : properties) {
            if (prop.getKey().equals("ESI/ESO trace file")) {
                filename = prop.getValue();
            }
            if (prop.getKey().equals("Trace to replay")) {
                tracenum = prop.getValueAsInt();
            }
            if (prop.getKey().equals("Training mode")) {
                trainingMode = prop.getValueAsBoolean();
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
                    throw new KiemInitializationException("The trace file does not contain a trace number "
                            + tracenum, true, e);
                }
            } catch(KiemInitializationException e) {
                trainingMode = true;
                //throw new KiemInitializationException("Trace file is empty or does not exist. Switching to training mode", false, e);
            }
        }
    }

    /**
     * Wrapup the data component and revert the internal state.
     * 
     * @throws KiemInitializationException
     *             never thrown
     */
    public void wrapup() throws KiemInitializationException {
        
    }

    /**
     * Tell KIEM that this component does produce data.
     * 
     */
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
     * Take a step in the simulation. The component reads its internal state and provides the
     * signals read from the ESI/ESO file to the simulation engine.
     * 
     * @throws KiemExecutionException 
     *          when the JSON object with signals from ESI/ESO file could not be built.
     */
    @Override
    public JSONObject doStep(JSONObject obj) throws KiemExecutionException {
        JSONObject retval = null;

              
        if(!trainingMode) {
            retval = genInputs();
        }
        
        addInputs(obj, retval);
        
        // inject signals into simulation
        return retval;
    }

    /**
     * Pushes signals currently present in the simulation (i. e. input signals)
     * to the DataValidation component which is thus able to differentiate between
     * input and output signals.
     * This method takes two JSONObjects as parameters. It extracts the actual signals
     * from both and sends a union of those two sets to the validation component.
     * 
     * @param obj First set of signals
     * @param obj2 Second set of signals
     */
    private void addInputs(JSONObject obj, JSONObject obj2) {
        if(valComponent == null) {
            // TODO: Retrieve the actual instance of the active DataValidationComponent, not some fucked up new one.
            List<DataComponentWrapper> comps = KiemPlugin.getDefault().getDataComponentWrapperList();
            valComponent = null;
            for(DataComponentWrapper comp : comps) {
                if(comp.getDataComponent().getDataComponentId().equals(DataValidationComponent.COMPONENTID)) {
                    valComponent = (DataValidationComponent) comp.getDataComponent();
                }
            }
        }
        
        final HashMap<String, Object> signals = new HashMap<String, Object>();
        
        if(obj != null) {
            @SuppressWarnings("unchecked") // necessary because the JSON library does not return a parameterized Iterator
            Iterator<String> keys = obj.keys();
    
            while(keys.hasNext()) {
                String key = keys.next();
                try {
                    if(obj.getJSONObject(key).getBoolean("present")) {
                        Object val = obj.getJSONObject(key).opt("value");
                        signals.put(key, val);
                    }
                } catch(JSONException e) {
                    // we catched a special signal, which is not a JSON object.
                    // simply do nothing
                }
            }
        }
        
        if(obj2 != null) {
            @SuppressWarnings("unchecked") // necessary because the JSON library does not return a parameterized Iterator
            Iterator<String> keys = obj2.keys();
    
            while(keys.hasNext()) {
                String key = keys.next();
                try {
                    if(obj2.getJSONObject(key).getBoolean("present") && !signals.containsKey(key)) {
                        Object val = obj2.getJSONObject(key).opt("value");
                        signals.put(key, val);
                    }
                } catch(JSONException e) {
                    // we catched a special signal, which is not a JSON object.
                    // simply do nothing
                }
            }
        }
        valComponent.putInputs(signals);
    }

    /**
     * Extract input signals from ESO file and prepare them for injection into the simulation
     * 
     * @return the signals that shall be injected
     * @throws KiemExecutionException when building the JSONObject fails
     */
    public JSONObject genInputs() throws KiemExecutionException {
        JSONObject retval = new JSONObject();

        // Proceed to the next step in the trace file
        if (trace.hasNext()) {
            ITick tick = trace.next();
            Iterator<ISignal> signals = tick.getInputs().iterator();

            // Add signals from the trace to the simulation
            try {
                while (signals.hasNext()) {
                    ISignal signal = signals.next();
                    if (signal.isValued()) {
                        retval.accumulate(signal.getName(), JSONSignalValues.newValue(signal.getValue(), true));
                    }
                    else {
                        retval.accumulate(signal.getName(), JSONSignalValues.newValue(true));
                    }
                }
            } catch (JSONException e) {
                throw new KiemExecutionException(
                        "Could not build JSON object with signals read from ESI/ESO file", true, e);
            }
        }
        
        return retval;
    }

    /**
     * Provide a list of properties to KIEM so the user can configure this component.
     * 
     * @return the properties
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
        
        KiemProperty[] properties = new KiemProperty[3];
        //properties[0] = new KiemProperty("Model editor", new KiemPropertyTypeEditor());
        properties[0] = new KiemProperty("ESI/ESO trace file", fileProperty);
        if(filename != null) {
            fileProperty.setValue(properties[0], filename);
        }

        properties[1] = new KiemProperty("Trace to replay", new KiemPropertyTypeInt(), 0);
        properties[2] = new KiemProperty("Training mode", false);

        return properties;
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
}
