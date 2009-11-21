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

import org.apache.batik.swing.JSVGCanvas;

import de.cau.cs.kieler.sim.kiem.extension.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.extension.KiemInitializationException;
import de.cau.cs.kieler.sim.kiem.json.JSONException;
import de.cau.cs.kieler.sim.kiem.json.JSONObject;
import de.cau.cs.kieler.xkev.mapping.animations.Animations;
import de.cau.cs.kieler.xkev.mapping.animations.MapAnimations;

/**
 * A simple Example for changing the color of the Trafficlight.svg.
 * 
 * @author Stephan Knauer (skn) - skn[at]informatik.uni-kiel.de
 * 
 */
public class Example_03 extends JSONObjectDataComponent implements IJSONObjectDataComponent {

    private boolean flag = true;
    private int counter = 0;
    private MapAnimations mapAnimation;
    
    public Example_03() {
        // TODO Auto-generated method stu
    }

    @Override
    public JSONObject step(JSONObject JSONobject) throws KiemExecutionException {
        // TODO The new JSON Data must be connected with
        // the old SVG-Graphic and updated afterwards
        
        try {
            if (!((String) JSONobject.get("Ampelknopf")).isEmpty() && JSONobject.getBoolean("Ampelknopf")) {
                flag = !flag;
            }
            if (flag) {
                JSONobject.put("pRed", "on");
                JSONobject.put("pGreen", "off");
            } else {
                JSONobject.put("pRed", "off");
                JSONobject.put("pGreen", "on");
            }
            switch (counter) {
            case 0: JSONobject.put("cRed", "on"); 
                    JSONobject.put("cYellow", "off");
                    JSONobject.put("cGreen", "off");
                    break;
            case 1: JSONobject.put("cRed", "on"); 
                    JSONobject.put("cYellow", "on");
                    JSONobject.put("cGreen", "off");
                    break;
            case 2: JSONobject.put("cRed", "off");
                    JSONobject.put("cYellow", "off");
                    JSONobject.put("cGreen", "on");
                    break;
            case 3: JSONobject.put("cRed", "off");
                    JSONobject.put("cGreen", "off");
                    JSONobject.put("cYellow", "on");
                    counter = -1;
                    break;
            }
            counter++;

        
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mapAnimation.doAnimation(JSONobject);
        //Now the SVG graphic needs to be refreshed
        //mapAnimation.getJSVGCanvas().setSVGDocument(mapAnimation.getSVGDocument());
        mapAnimation.updateSVGGraphik();
        return null;// Because it's only an Observer right now
    }

    @Override
    public void initialize() throws KiemInitializationException {
        // TODO Auto-generated method stub
        mapAnimation = new MapAnimations("Trafficlight.mapping", true);
    }

    @Override
    public boolean isObserver() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isProducer() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void wrapup() throws KiemInitializationException {
        // TODO Auto-generated method stub

    }

    // @Override
    // public boolean isMaster() {
    // return true;
    // }

}
