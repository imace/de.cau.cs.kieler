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
package de.cau.cs.kieler.sim.esi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.sim.esi.esi.signal;
import de.cau.cs.kieler.sim.esi.esi.tick;
import de.cau.cs.kieler.sim.esi.esi.trace;
import de.cau.cs.kieler.sim.esi.esi.tracelist;
import de.cau.cs.kieler.sim.kiem.IAutomatedProducer;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONSignalValues;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeBool;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeEditor;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeFile;

/**
 * Data-component to read traces in esi format.
 * 
 * @author ctr
 */
public class EsoComponent extends JSONObjectDataComponent implements IAutomatedProducer {

    private tracelist tracelist = null;
    private Iterator<trace> iTrace;
    private Iterator<tick> iTick;

    private String traceFile = "";

    private int pos = 0;

    private boolean isValid;

    /**
     * {@inheritDoc}
     */
    public JSONObject step(final JSONObject input) throws KiemExecutionException {
        trace trace;
        tick tick;
        JSONObject res = new JSONObject();
        if (tracelist != null) {

            if (!iTick.hasNext() && iTrace.hasNext()) {
                trace = iTrace.next();
                iTick = trace.getTicks().iterator();
            }
            if (iTick.hasNext()) {
                tick = iTick.next();

                boolean valid = true;
                try {
                    // Everything in the trace is emitted
                    for (signal sig : tick.getInput()) {
                        if (input.has(sig.getName())) {
                            Object obj = input.get(sig.getName());
                            if (!JSONSignalValues.isPresent(obj)) {
                                valid = false;
                                break;
                            }
                            if (sig.isValued()) {
                                if ((Integer) (JSONSignalValues.getSignalValue(obj)) != sig
                                        .getVal()) {
                                    valid = false;
                                    break;
                                }
                            }
                        } else {
                            valid = false;
                            break;
                        }
                    }

                    /** TODO:Everything emitted is in the trace */
                    // Iterator<String> key = input.keys();
                    // while (key.hasNext()) {
                    //                     
                    // JSONObject obj = input.getJSONObject(key.next());
                    // if (JSONSignalValues.isSignalValue(obj)) {
                    // if (JSONSignalValues.isPresent(obj) &&
                    // !tick.getInput().contains(key)) {
                    // valid = false;
                    // break;
                    // } else {
                    // if (tick.getInput().contains(key)) {
                    // valid = false;
                    // break;
                    // }
                    //
                    // }
                    // }
                    // }
                    isValid = isValid && valid;
                    res.accumulate("valid", JSONSignalValues.newValue(pos, valid));

                } catch (JSONException e) {
                    throw new KiemExecutionException("Error building JSON Object", false, e);
                }
            }
            pos++;
        }

        return res;
    }

    // --------------------------------------------------------------------------
    // additional methods
    /** {@inheritDoc} */
    @Override
    public JSONObject provideInitialVariables() throws KiemInitializationException {
        JSONObject res = new JSONObject();
        try {
            res.accumulate("valid", JSONSignalValues.newValue(true));
        } catch (JSONException e) {
            throw new KiemInitializationException("JSON error", true, e);
        }
        return res;
    }

    /** {@inheritDoc} */
    public void initialize() throws KiemInitializationException {
        pos = 0;
        if (tracelist == null) {
            tracelist = Helper.loadTrace(getClass(), traceFile);
            iTrace = tracelist.getTraces().iterator();
            iTick = iTrace.next().getTicks().iterator();
        }else{
        }
    }

    /** {@inheritDoc} */
    public boolean isProducer() {
        return true;
    }

    /** {@inheritDoc} */
    public boolean isObserver() {
        return true;
    }

    @Override
    public KiemProperty[] provideProperties() {
        String editorName = "";
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        if (page != null) {
            IEditorReference[] editors = page.getEditorReferences();
            if (editors != null) {
                for (IEditorReference e : editors) {
                    IEditorPart ed = e.getEditor(false);
                    if (ed instanceof XtextEditor) {
                        editorName = e.getTitle() + " (" + e.getId() + ")";
                        break;
                    }

                }
            }
        }

        KiemProperty[] properties = new KiemProperty[2];
        properties[0] = new KiemProperty("Input File", new KiemPropertyTypeFile(),
                "/home/ctr/runtime-EclipseApplication/test/abro.esi");
        properties[1] = new KiemProperty("Input Editor", new KiemPropertyTypeEditor(), editorName);
        return properties;
    }

    /** {@inheritDoc} */
    public void wrapup() {
        tracelist = null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean wantsAnotherRun() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public List<KiemProperty> produceInformation() {
        List<KiemProperty> res = new LinkedList<KiemProperty>();
        res.add(new KiemProperty("valid", new KiemPropertyTypeBool(), String.valueOf(isValid)));
        return res;
    }

    /**
     * {@inheritDoc}
     */
    public void setParameters(final List<KiemProperty> properties) {
        String trace = null;
        for (KiemProperty p : properties) {
            if (p.getKey().equals("TRACE")) {
                trace = p.getValue();
            }
        }
        if (trace != null) {
            traceFile = trace;
        }

    }

    /**
     * {@inheritDoc}
     */
    public boolean wantsNextStep() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public int wantsMoreRuns() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public int wantsMoreSteps() {
        return 0;
    }
}
