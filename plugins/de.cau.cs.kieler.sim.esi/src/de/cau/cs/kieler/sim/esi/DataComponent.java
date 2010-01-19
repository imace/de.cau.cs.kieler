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

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.IAntlrParser;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.core.editor.XtextEditor;

import com.google.inject.Injector;

import de.cau.cs.kieler.sim.esi.esi.signal;
import de.cau.cs.kieler.sim.esi.esi.tick;
import de.cau.cs.kieler.sim.esi.esi.trace;
import de.cau.cs.kieler.sim.esi.esi.tracelist;
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
public class DataComponent extends JSONObjectDataComponent {

    private tracelist tracelist = null;
    private XtextEditor editor = null;
    private Iterator<trace> iTrace;
    private Iterator<tick> iTick;

    private int pos = 0;
    private int len = 0;

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
                AbstractNode node = NodeUtil.getNodeAdapter(tick).getParserNode();
                pos = node.getTotalOffset();
                len = node.getLength();
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
        // pos = "! reset".length();
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
        properties[0] = new KiemProperty("Input File", new KiemPropertyTypeFile(),
                "/home/ctr/runtime-EclipseApplication/test/abro.esi");
        properties[1] = new KiemProperty("Input Editor", new KiemPropertyTypeEditor(), editorName);
        return properties;
    }

    /** {@inheritDoc} */
    public void wrapup() {
        tracelist = null;
        editor = null;
    }

    @Override
    public JSONObject provideInitialVariables() throws KiemInitializationException {
        JSONObject signals = new JSONObject();

        ISetup setup = new EsiStandaloneSetup();
        Injector injector = setup.createInjectorAndDoEMFRegistration();
        XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
        rs.setClasspathURIContext(getClass());

        IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
        // setup.doSetup();
        URI uri = URI.createURI("de.cau.cs.kieler.sim.esi");// Activator.PLUGIN_ID);
        XtextResource resource = (XtextResource) resourceFactory.createResource(uri);
        rs.getResources().add(resource);

        InputStream in;
        try {
            IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                    .getActivePage();
            IEditorReference[] editors = page.getEditorReferences();
            editor = null;
            String name = getProperties()[1].getValue();
            if (editors != null) {
                for (IEditorReference e : editors) {
                    if (name.equals(e.getTitle() + " (" + e.getId() + ")")) {
                        IEditorPart ed = e.getEditor(false);
                        if (ed instanceof XtextEditor) {
                            editor = (XtextEditor) ed;
                            break;
                        }

                    }
                }
            }

            if (editor != null) {
                FileEditorInput input = (FileEditorInput) editor.getEditorInput();
                if (input.exists()) {
                    IFile file = input.getFile();
                    in = file.getContents();

                    // resource=(XtextResource) editor. . .getResource();
                } else {
                    throw new KiemInitializationException("Editor input not found", true, null);
                }
            } else {
                in = new FileInputStream(getProperties()[0].getValue());
            }

            Injector inj = new EsiStandaloneSetup().createInjectorAndDoEMFRegistration();
            IAntlrParser parser = inj.getInstance(IAntlrParser.class);
            IParseResult parseResult = parser.parse(in);
            if (!parseResult.getParseErrors().isEmpty()) {
                throw new KiemInitializationException("Parse error", true, null);
            }
            tracelist = (tracelist) parseResult.getRootASTElement();
            // tracelist = (tracelist) resource.getParseResult().getRootASTElement();
            iTrace = tracelist.getTraces().iterator();
            iTick = iTrace.next().getTicks().iterator();
        } catch (FileNotFoundException e) {
            throw new KiemInitializationException("File not found", false, e);
        } catch (Exception e) {
            throw new KiemInitializationException("Unknown error", false, e);
        }

        /*
         * try { if (tracelist != null) { for (trace trace : tracelist.getTraces()) { for (tick tick
         * : trace.getTicks()) { for (signal s : tick.getInput()) { signals.accumulate(s.getName(),
         * JSONSignalValues.newValue("", false)); } for (signal s : tick.getOutput()) {
         * signals.accumulate(s.getName(), JSONSignalValues.newValue("", false)); } } } } } catch
         * (JSONException e) { throw new KiemInitializationException("Error building JSON object",
         * false, e); }
         */
        return signals;
    }

}
