/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
 * 
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by + Christian-Albrechts-University of Kiel + Department of Computer Science +
 * Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL). See the file
 * epl-v10.html for the license text.
 */

package de.cau.cs.kieler.xkev.extension.dataobserver;

import java.util.Iterator;

import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.dom.svg.SVGOMPathElement;
import org.apache.batik.dom.svg.SVGOMSVGElement;
import org.eclipse.ui.PartInitException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGAnimateMotionElement;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGPathElement;

import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import org.json.JSONException;
import org.json.JSONObject;
import de.cau.cs.kieler.xkev.Activator;
import de.cau.cs.kieler.xkev.mapping.SVGElement;
import de.cau.cs.kieler.xkev.mapping.SVGFile;
import de.cau.cs.kieler.xkev.views.EclipseJSVGCanvas;
import de.cau.cs.kieler.xkev.views.KevView;

/**
 * @author Stephan Knauer (skn) - skn[at]informatik.uni-kiel.de
 * 
 */
public class XKevDataObserver extends JSONObjectDataComponent implements IJSONObjectDataComponent {

    /** Sets the sleep time for the step-method. */
    private static final int SLEEP_TIME = 100;
       
    /**
     * Applies the JSON data to the SVG document.
     * 
     * @param jSONObject
     *            The actual JSONObject, returned by the ExecutionManager.
     * @return null Here we don't need to return a JSON object, because the KEV-view is an observer
     *         only now.
     * @see de.cau.cs.kieler.sim.kiem.extension.IJSONObjectDataComponent#step(de.cau.cs.kieler.sim.kiem.json.JSONObject)
     * @see JSONObject, ExecutionManager
     * 
     */
    public JSONObject step(final JSONObject jSONObject) {
        if (Activator.getCurrentMapAnimation() != null) {
            Activator.getCurrentMapAnimation().doAnimations(jSONObject);
        }
        try {
            // For refreshing the svg document, we only need to be called every 100 ms.
            // TODO: Should be changable in the Kev properties view
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            Activator.reportErrorMessage("Error during sleeping in the KEV step-method.", e);
        }
        return null;// Return null because it's only an observer right now.
    }

    /**
     * Sets the initial values for the KIEM data table with the SVG element id's from mapping file
     * as JSON keys.
     * @return The JSONObject with all SVG element id's of the current mapping file.
     */
    public JSONObject provideInitialVariables() {
        JSONObject jsonObject = new JSONObject();
        SVGFile mappingFile = null;
        if (Activator.getCurrentMapAnimation() != null) {
            mappingFile = Activator.getCurrentMapAnimation().getMappingFile();
            if (mappingFile != null) {
                // Get the svgElement iterator of the current mappingfile
                Iterator<SVGElement> elementIterator = Activator.getCurrentMapAnimation()
                        .getMappingFile().getSvgElement().iterator();
                try {
                    while (elementIterator.hasNext()) {
                        jsonObject.put(elementIterator.next().getId(), "");
                    }
                    return jsonObject;
                } catch (JSONException e) {
                    // Something went wrong with inserting the json key value pairs
                }
            }
        }
        return null;
    }

    /**
     * Disables the load button during execution and creates the KEV-view if it's not already done.
     * @throws KiemInitializationException An exception which raises if the KEV-view can't be created.
     */
    public void initialize() throws KiemInitializationException {
        Activator.setExecutionManagerStatus(true);
        // If KevView doesn't exists try to create it.
        if (Activator.getKevView() == null) {
            // Let's try to initialize the xKEV view and open it.
            try {
                Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage()
                        .showView(KevView.ID);
            } catch (PartInitException e) {
                Activator.reportErrorMessage("KevView can't be initialized!");
            }
        } else {
            // Disable OpenWizardButton during execution
            Activator.getKevView().disableButton(3);

        }
        // Only go one, if a valid svg document already exists.
        if (EclipseJSVGCanvas.getInstance().getSVGDocument() == null) {
            // Reactivate the button, because the execution will be stopped.
            Activator.getKevView().enableButton(1);
            throw new KiemInitializationException(
                    "No svg file was loaded! Please select a valid mapping file before execution.",
                    true, null);
        } else {
            // Update the composite uri path for refreshing the canvas if button is pressed
            // Activator.getKevView().getComposite().setSVGURI(java.net.URI.create(EclipseJSVGCanvas.getInstance().getSVGDocument().getURL()));
        }
        
    }

    /**
     * Tells the ExecutionManager that the KEV-view is an observer.
     * 
     * @see de.cau.cs.kieler.sim.kiem.extension.IDataComponent#isObserver()
     * @see ExecutionManager
     * @return true, because the KEV-view is an observer.
     */
    public boolean isObserver() {
        // The Kev plugin is momentarily an observer only.
        return true;
    }

    /**
     * Tells the ExecutionManager that the KEV-view is not a producer.
     * 
     * @see de.cau.cs.kieler.sim.kiem.extension.IDataComponent#isProducer()
     * @return false, because the KEV-view is not a producer.
     */
    public boolean isProducer() {
        // The Kev plugin is momentarily an observer only.
        return false;
    }

    /**
     * Tells the ExecutionManager to store all data for an eventually history playback.
     * @return true, because KEV-view should be able the show history steps.
     */
    public boolean isHistoryObserver() {
        return true;
    }

    /**
     * Sets the running status of the ExecutionManager to false an enables the open wizard button. 
     * 
     * @see de.cau.cs.kieler.sim.kiem.extension.IDataComponent#wrapup()
     * @see Activator
     */
    public void wrapup() {
        // Set the isRunning flag to false when the execution terminates.
        Activator.setExecutionManagerStatus(false);
        // Kev icon openwizard action should be reactivated after execution has fished.
        // But only if the KevView is visible
        if (Activator.getKevView() != null) {
            Activator.getKevView().enableButton(3);
        }
    }

}
