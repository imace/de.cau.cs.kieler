/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
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

package de.cau.cs.kieler.xkev.extension.dataobserver;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.Workbench;

import de.cau.cs.kieler.sim.kiem.extension.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.extension.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.json.JSONException;
import de.cau.cs.kieler.sim.kiem.json.JSONObject;
import de.cau.cs.kieler.xkev.Activator;
import de.cau.cs.kieler.xkev.mapping.SVGElement;
import de.cau.cs.kieler.xkev.mapping.SVGFile;
import de.cau.cs.kieler.xkev.views.EclipseJSVGCanvas;
import de.cau.cs.kieler.xkev.views.KevComposite;
import de.cau.cs.kieler.xkev.views.KevView;

/**
 * @author Stephan Knauer (skn) - skn[at]informatik.uni-kiel.de
 *
 */
public class XKevDataObserver extends JSONObjectDataComponent implements IJSONObjectDataComponent {

    
    private KevView kevView = null;
    private KevComposite kevComposite = null;
    
    
    /* (non-Javadoc)
     * @see de.cau.cs.kieler.sim.kiem.extension.IJSONObjectDataComponent#step(de.cau.cs.kieler.sim.kiem.json.JSONObject)
     */
    public JSONObject step(JSONObject jSONObject) throws KiemExecutionException {
        if (Activator.getCurrentMapAnimation() != null) {
            Activator.getCurrentMapAnimation().doAnimations(jSONObject);
        }
        try {
            //For refreshing the svg document, we only need to be called every 100 ms.
            //TODO: Should be changable in the Kev properties view
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;//Return null because it's only an observer right now.
    }

    /**
     * Sets the initial values for the kiem data table with the svg element id's from mapping file as json keys.
     */
    @Override
    public JSONObject provideInitialVariables() throws KiemInitializationException {
        JSONObject jsonObject = new JSONObject();
        SVGFile mappingFile = null;
        if (Activator.getCurrentMapAnimation() != null) {
            mappingFile = Activator.getCurrentMapAnimation().getMappingFile();
            if (mappingFile != null) {
                //Get the svgElement iterator of the current mappingfile
                Iterator<SVGElement> elementIterator = Activator.getCurrentMapAnimation().getMappingFile().getSvgElement().iterator();
                try {
                    while (elementIterator.hasNext()) {
                        jsonObject.put(elementIterator.next().getId(), "");
                    }
                    return jsonObject; 
                } catch (JSONException e) {
                    //Something went wrong with inserting the json key value pairs
                }
            }
        }
        return null;
    }
    
    
    
    
    /**
     * Disables the load button during execution and creates the kev view if it's not already done.
     */
    public void initialize() throws KiemInitializationException {
        Activator.setExecutionManagerStatus(true);
        //If KevView doesn't exists try to create it.
        if (Activator.getKevView() == null) {
            //Let's try to initialize the xKEV view and open it.
            try {
                Workbench.getInstance().getActiveWorkbenchWindow().getActivePage().showView(KevView.ID);
            } catch (PartInitException e) {
                Activator.reportErrorMessage("KevView can't be initialized!");
            }
        } else {
            //Disable OpenWizardButton during execution
            Activator.getKevView().disableButton();
            
        }
        //Only go one, if a valid svg document already exists.
        if (EclipseJSVGCanvas.getInstance().getSVGDocument() == null) {
            //Reactivate the button, because the execution will be stopped.
            Activator.getKevView().enableButton();
            throw new KiemInitializationException("No svg file was loaded! Please select a valid mapping file before execution.", true, null);
        } else {
            //Update the composite uri path for refreshing the canvas if button is pressed
            //Activator.getKevView().getComposite().setSVGURI(java.net.URI.create(EclipseJSVGCanvas.getInstance().getSVGDocument().getURL()));
        }
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.sim.kiem.extension.IDataComponent#isObserver()
     */
    public boolean isObserver() {
        //The Kev plugin is momentarily an observer only. 
        return true;
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.sim.kiem.extension.IDataComponent#isProducer()
     */
    public boolean isProducer() {
        //The Kev plugin is momentarily an observer only.
        return false;
    }

    public boolean isHistoryObserver() {
        return true;
    }
    
    
    /* (non-Javadoc)
     * @see de.cau.cs.kieler.sim.kiem.extension.IDataComponent#wrapup()
     */
    public void wrapup() throws KiemInitializationException {
        //Set the isRunning flag to false when the execution terminates.
        Activator.setExecutionManagerStatus(false);
        //Kev icon openwizard action should be reactivated after execution has fished.
        //But only if the KevView is visible
        if (Activator.getKevView() != null) {
            Activator.getKevView().enableButton(); 
        }
    }
    
    
    
    

}
