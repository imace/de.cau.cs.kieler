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

import de.cau.cs.kieler.sim.kiem.extension.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.extension.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.json.JSONArray;
import de.cau.cs.kieler.sim.kiem.json.JSONException;
import de.cau.cs.kieler.sim.kiem.json.JSONObject;
import de.cau.cs.kieler.xkev.mapping.animations.MapAnimations;

/**
 * A simple Example for changing the color of the Trafficlight.svg.
 * 
 * @author Stephan Knauer (skn) - skn[at]informatik.uni-kiel.de
 * 
 */
public class Example_01 extends JSONObjectDataComponent implements IJSONObjectDataComponent {

    private boolean flag = true;
    private int counter = 0;
    private MapAnimations mapAnimation;
    private JSONArray jsonArray;
    
    public Example_01() {
        // TODO Auto-generated method stu
    }

    public JSONObject step(JSONObject JSONobject) throws KiemExecutionException {
        // TODO The new JSON Data must be connected with
        // the old SVG-Graphic and updated afterwards

        try {
            if (!((String) JSONobject.get("Ampelknopf")).isEmpty() && JSONobject.getBoolean("Ampelknopf")) {
                flag = !flag;
            }
            jsonArray = new JSONArray();
            if (flag) {
                jsonArray.put("on");jsonArray.put("off");
                JSONobject.put("pLight", jsonArray);
            } else {
                jsonArray.put("off");jsonArray.put("on");
                JSONobject.put("pLight", jsonArray);
            }
            jsonArray = new JSONArray();
            switch (counter) {
            case 0: jsonArray.put("on");jsonArray.put("off");jsonArray.put("off");
                    JSONobject.put("cLight", jsonArray); 
                    break;
            case 1: jsonArray.put("on");jsonArray.put("on");jsonArray.put("off");
                    JSONobject.put("cLight", jsonArray);
                    break;
            case 2: jsonArray.put("off");jsonArray.put("off");jsonArray.put("on");
                    JSONobject.put("cLight", jsonArray);                    
                    break;
            case 3: jsonArray.put("off");jsonArray.put("on");jsonArray.put("off");
                    JSONobject.put("cLight", jsonArray);
                    counter = -1;
                    break;
            }
            counter++;
            mapAnimation.doAnimations(JSONobject);
            
            
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Now the SVG graphic needs to be refreshed
        //mapAnimation.getJSVGCanvas().setSVGDocument(mapAnimation.getSVGDocument());
        //mapAnimation.updateSVGGraphik();
        return null;// Because it's only an Observer right now
    }

    public void initialize() throws KiemInitializationException {
        // TODO Auto-generated method stub
        mapAnimation = new MapAnimations("Trafficlight_array.mapping", true);
    }

    public boolean isObserver() {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean isProducer() {
        // TODO Auto-generated method stub
        return false;
    }

    public void wrapup() throws KiemInitializationException {
        // TODO Auto-generated method stub
        counter = 0;
    }

    // public boolean isMaster() {
    // return true;
    // }

}
