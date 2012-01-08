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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.signals.JSONSignalValues;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.klots.KlotsConnectionException;
import de.cau.cs.kieler.klots.util.KlotsConsole;
import de.cau.cs.kieler.klots.util.KlotsConstants;
import de.cau.cs.kieler.klots.util.NXTCommunicator;

/**
 * @author root
 *
 */
public class NXTDataDistributor extends JSONObjectDataComponent implements IJSONObjectDataComponent {

    private static KlotsConsole console = KlotsConsole.getInstance();
    private NXTCommunicator comm;

    

    /**
     * {@inheritDoc}
     */
    public void initialize() throws KiemInitializationException {
        console.clear();
        comm = NXTCommunicator.getInstance();
        String msg = "";
        try {
            msg = comm.receiveMessage().toString();
        } catch (KlotsConnectionException e) {
            e.printStackTrace();
            throw new KiemInitializationException("Connection Error!", true, e);
        }
        if (msg.startsWith("[{" + KlotsConstants.SYNCHRONIZED_COMMAND_KEY)) {
            console.println(msg);
        } else {
            console.println("ERROR while trying to synchronize with the NXT: " + msg);
        }
    }

    

    /**
     * {@inheritDoc}
     */
    public void wrapup() throws KiemInitializationException {
        comm.sendMessage(KlotsConstants.STOP_COMMAND_KEY);
        comm.closeTransmission(true);
    }


    
    /**
     * {@inheritDoc}
     */
    public boolean isProducer() {
        return true;
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
    public JSONObject step(final JSONObject jSONObject) throws KiemExecutionException {

        // --------------------------- producer -----------------------------
        String msg = "";
        try {
            String jSONKey = "";
            for (Iterator<?> iter = jSONObject.keys(); iter.hasNext();) {
                jSONKey = (String) iter.next();
                if (JSONSignalValues.isPresent(jSONObject.get(jSONKey))) {
                    if (JSONSignalValues.isSignalValue(jSONObject.get(jSONKey))) {
                        msg += jSONKey + KlotsConstants.COMMA_STRING
                        + JSONSignalValues.getSignalValue(jSONObject.get(jSONKey))
                        + KlotsConstants.SEMICOLON_STRING;
                    } else {
                        msg += jSONKey + KlotsConstants.SEMICOLON_STRING;
                    }
                }
            }
            if (msg.length() > 0) {
                msg = msg.substring(0, msg.length() - 1);
            }
        } catch (JSONException e) {
            console.println("PRODUCER ERROR: " + e.getMessage());
        }
        comm.sendMessage(KlotsConstants.STEP_COMMAND_KEY + KlotsConstants.MESSAGE_LINE_DELIMITER + msg);

        // --------------------------- observer -----------------------------
        StringBuffer buffer = new StringBuffer();
        try {
            buffer = comm.receiveMessage();
        } catch (KlotsConnectionException e) {
            e.printStackTrace();
            throw new KiemExecutionException("Connection Error!", true, e);
        }
        System.out.println("====;;;;;;;==== RECEIVED MESSAGE BUFFER = >" + buffer.toString() + "<");

        // remote console print processing
        int start = 0;
        int end = 0;
        while (start >= 0) {
            start = buffer.indexOf("{" + KlotsConstants.PRINT_TAG, end);
            if (start >= 0) {
                end = buffer.indexOf("},", start);
                console.println("REMOTE PRINT: "
                        + buffer.substring(1 + start + KlotsConstants.PRINT_TAG.length(), end)
                        .replaceFirst(KlotsConstants.MESSAGE_NEW_LINE, ""));
                buffer.replace(start, end + 2, "");
                System.out.println("====;;;;;;;==== MESSAGE BUFFER AFTER PRINT = >"
                        + buffer.toString() + "<");
                end = start;
            }
        }

        try {
            JSONArray received = new JSONArray(buffer.toString());
            JSONObject returnObj = new JSONObject();
            String s = buffer.toString();
            s = s.substring(1, s.length() - 1);
            returnObj.put(KlotsConstants.JSON_EXECUTION_TRACE_TAG, received);

            JSONObject signals = received.getJSONObject(received.length() - 2);
            if (signals.has(KlotsConstants.JSON_SIGNALS_TAG)) {
                JSONObject tmp = new JSONObject();
                String key;
                JSONArray sig = signals.getJSONArray(KlotsConstants.JSON_SIGNALS_TAG);
                for (int i = 0; i < sig.length(); i++) {
                    tmp = sig.getJSONObject(i);
                    Iterator<?> iter = tmp.keys();
                    key = (String) iter.next();
                    returnObj.accumulate(key, tmp.get(key));
                }
            } else {
                System.err.println("NXTDataDistributor: EORROR! > No return signals part at the expected"
                        + "line number in the received JSON object! Got >" + signals.toString()
                        + "< instead!");
            }
            System.out.println("#######>>>> NXTDataDistributor returns JSON object >"
                    + returnObj.toString() + "<");
            return returnObj;
        } catch (JSONException e) {
            console.println("OBSERVER ERROR: " + e.getMessage());
        }
        return null;
    }

}