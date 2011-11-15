/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
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
package de.cau.cs.kieler.klots.kiemdatacomponents;

import java.util.Iterator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;

import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.util.KlotsConstants;
import de.cau.cs.kieler.klots.views.SJInstructionsData;
import de.cau.cs.kieler.klots.views.SJInstructionsDataList;


/**
 * @author root
 *
 */
public class SJInstructionsViewNXTDataObserver extends JSONObjectDataComponent
                                               implements IJSONObjectDataComponent {

    // CHECKSTYLEOFF LineLength
    
    /** The id of the view for KIEM. */
    private static final String SJ_INSTRUCTIONS_VIEW_ID = "de.cau.cs.kieler.klots.view.SJInstructionsView";
    private static final String SIGNAL_TABLE_VIEW_ID = "de.cau.cs.kieler.sim.table.view";
    
    // CHECKSTYLEON LineLength

    /**
     * The Constant EYE_CATCH_DELAY. Let the user eye-catch the table entries and delay the update
     * 80ms.
     */
    private static final int EYE_CATCH_DELAY = 80;

    
    
    /**
     * Instantiates a new observer DataComponent.
     */
    public SJInstructionsViewNXTDataObserver() {
    }

    
    
    /**
     * {@inheritDoc}
     */
    public JSONObject step(final JSONObject jSONObject) {
        SJInstructionsDataList instrList = SJInstructionsDataList.getInstance();
        instrList.clear();

        try {
            JSONArray jArray = jSONObject.getJSONArray(KlotsConstants.JSON_EXECUTION_TRACE_TAG);
            System.out.println("####>>>> jArray, length=" + jArray.length() + " : " + jArray.toString());
            JSONObject instr = new JSONObject();
            JSONObject instrInside = new JSONObject();
            JSONArray instrParams = new JSONArray();
            String jSONKey = "";
            for (int i = 2; i < jArray.length() - 2; i++) {
                instr = jArray.getJSONObject(i);
                System.out.println("####>>>> instr, i=" + i + " : " + instr.toString());
                SJInstructionsData instrData = new SJInstructionsData(instrList);
                for (Iterator<?> iter = instr.keys(); iter.hasNext();) {
                    jSONKey = (String) iter.next();
                }

//                if (jSONKey.equals("present")) {
//                    // fixme: find a way to deal with 'present' hidden in 'awaitDone'
//                    continue;
//                }

                instrData.setInstructionsName(jSONKey);
                instrInside = instr.getJSONObject(jSONKey);
                instrData.setLabel(instrInside.getString(KlotsConstants.JSON_LABEL_TAG));
                instrData.setPrio(instrInside.getInt(KlotsConstants.JSON_PRIORITY_TAG));
                if (instrInside.has(KlotsConstants.JSON_RETURN_VALUE_TAG)) {
                    instrData.setRetval(instrInside.getBoolean(KlotsConstants.JSON_RETURN_VALUE_TAG));
                }
                if (instrInside.has(KlotsConstants.JSON_INITIAL_EXECUTION_TAG)) {
                    instrData.setInitialExecution(
                            instrInside.getBoolean(KlotsConstants.JSON_INITIAL_EXECUTION_TAG));
                }
                if (instrInside.has(KlotsConstants.JSON_PARAMETER_TAG)) {
                    instrParams = instrInside.getJSONArray(KlotsConstants.JSON_PARAMETER_TAG);
                    instrData.setParam(instrParams.toString());
                }
                System.out.println("####>>>> INSTRUCTION DATA: " + instrData.toString());
                instrList.add(instrData);
            }
        } catch (JSONException e) {
            System.out.println("INSTRUCTIONS VIEW OBSERVER STEP ERROR: JSON Object is:\n"
                    + jSONObject.toString());
            e.printStackTrace();
        }

        // update view
        instrList.updateViewAsync();

        // Slow down so that user can eye-catch all changes!
        try {
            Thread.sleep(EYE_CATCH_DELAY);
        } catch (Exception e) {
            // does not matter if we update a little faster
        }

        return null;
    }

    
    
    private boolean broughtToFront;

    /**
     * This method brings the Table view to the front.
     */
    public void bringToFront() {
        broughtToFront = false;
        final int sleepTime = 100;
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                // bring view to the front (lazy loading)
                try {
                    IWorkbenchWindow window =
                        KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow();
                    IViewPart vP = window.getActivePage().showView(SIGNAL_TABLE_VIEW_ID);
                    vP.setFocus();
                    vP = window.getActivePage().showView(SJ_INSTRUCTIONS_VIEW_ID);
                    vP.setFocus();
                    // set done flag
                    broughtToFront = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        while (!broughtToFront) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * {@inheritDoc}
     */
    public void initialize() {
        // bring SJ instructions view to front
        bringToFront();

        // update the view
        //SJInstructionsDataList.getInstance().updateViewAsync();
    }

    

    /**
     * {@inheritDoc}
     */
    public boolean isObserver() {
        return true;
    }


    
    /**
     * {@inheritDoc}
     */
    public boolean isProducer() {
        return false;
    }


    
    /**
     * {@inheritDoc}
     */
    public boolean isHistoryObserver() {
        return true;
    }



    /**
     * {@inheritDoc}
     */
    public void wrapup() {
        SJInstructionsDataList instrList = SJInstructionsDataList.getInstance();
        instrList.clear();
        instrList.updateViewAsync();
    }

}