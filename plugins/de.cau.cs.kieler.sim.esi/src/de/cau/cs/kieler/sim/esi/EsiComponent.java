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

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.core.editor.XtextEditor;

import de.cau.cs.kieler.sim.esi.esi.signal;
import de.cau.cs.kieler.sim.esi.esi.tick;
import de.cau.cs.kieler.sim.esi.esi.trace;
import de.cau.cs.kieler.sim.esi.esi.tracelist;
import de.cau.cs.kieler.sim.kiem.IAutomatedProducer;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONSignalValues;
import de.cau.cs.kieler.sim.kiem.properties.KiemProperty;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeEditor;
import de.cau.cs.kieler.sim.kiem.properties.KiemPropertyTypeFile;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Data-component to read traces in esi format.
 * 
 * @author ctr
 */
public class EsiComponent extends JSONObjectDataComponent implements IAutomatedProducer {

    private tracelist tracelist = null;
    private Iterator<trace> iTrace;
    private Iterator<tick> iTick;

    private int iteration = 0;
    private String traceFile = ""; 
    

    /**
     * {@inheritDoc}
     */
    public JSONObject step(final JSONObject input) throws KiemExecutionException {
        trace trace;
        tick tick;
        JSONObject res = new JSONObject();
        if (tracelist != null) {
            if (!iTick.hasNext() && iTrace.hasNext()) {
                // pos += "! reset".length();
                trace = iTrace.next();
                iTick = trace.getTicks().iterator();
            }
            if (iTick.hasNext()) {
                tick = iTick.next();
                // AbstractNode node = NodeUtil.getNodeAdapter(tick).getParserNode();
                try {
                    for (signal s : tick.getInput()) {
                        if (s.isValued()) {
                            res
                                    .accumulate(s.getName(), JSONSignalValues.newValue(s.getVal(),
                                            true));
                        } else {
                            res.accumulate(s.getName(), JSONSignalValues.newValue(true));
                        }
                    }
                } catch (JSONException e) {
                    throw new KiemExecutionException("Error building JSON Object", false, e);
                }
            }
        }

        return res;
    }

    // --------------------------------------------------------------------------
    // additional methods

    /** {@inheritDoc} */
    public void initialize() {
    }

    /** {@inheritDoc} */
    public boolean isProducer() {
        return true;
    }

    /** {@inheritDoc} */
    public boolean isObserver() {
        return false;
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
        properties[0] = new KiemProperty("Input File", new KiemPropertyTypeFile(), traceFile);
        properties[1] = new KiemProperty("Input Editor", new KiemPropertyTypeEditor(), editorName);
        return properties;
    }

    /** {@inheritDoc} */
    public void wrapup() {
        tracelist = null;
    }

    @Override
    public JSONObject provideInitialVariables() throws KiemInitializationException {
        JSONObject signals = new JSONObject();
        tracelist = Helper.loadTrace(getClass(), getProperties()[0].getValue(), getProperties()[0]
                .getValue());
        
        iTrace = tracelist.getTraces().iterator();
        //iTrace +=iteration;
        iTick = iTrace.next().getTicks().iterator();

        HashSet<String> sigs = new HashSet<String>();
        try {
            for (trace trace : tracelist.getTraces()) {
                for (tick tick : trace.getTicks()) {
                    for (signal s : tick.getInput()) {
                        if (!sigs.contains(s.getName())) {
                            sigs.add(s.getName());
                            signals.accumulate(s.getName(), JSONSignalValues.newValue(false));
                        }
                    }
                    for (signal s : tick.getOutput()) {
                        if (!sigs.contains(s.getName())) {
                            sigs.add(s.getName());
                            signals.accumulate(s.getName(), JSONSignalValues.newValue(false));
                        }

                    }
                }
            }
        } catch (JSONException e) {
            // ignore
        }

        return signals;
    }

    /**
     * {@inheritDoc}
     */
    public boolean wantsAnotherRun() {
        return iTrace.hasNext();
    }

    /**
     * {@inheritDoc}
     */
    public List<KiemProperty> produceInformation() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void setParameters(List<KiemProperty> properties) {
        String model = null;
        for (KiemProperty p : properties) {
            if (p.getKey().equals(MODEL_FILE)) {
                model = p.getValue();
            } else if (p.getKey().equals(ITERATION)) {
                iteration = Integer.parseInt(p.getValue());
            }
        }
        if (model != null) {
            IPath path = Path.fromOSString(model);
            path.removeFileExtension();
            path.addFileExtension("esi");
            traceFile = path.toOSString();
            // IWorkspaceRoot ws = ResourcesPlugin.getWorkspace().getRoot();
            // IFolder s = ws.getFolder(path);
            // s.
            properties.add(new KiemProperty("TRACE", traceFile));
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean wantsNextStep() {
        return iTick.hasNext();
    }
}
