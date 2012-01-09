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

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.sim.kiem.KiemInitializationException;

/**
 * Implements a service to write ESO files. This class can take a list of maps,
 * containing the input and output variables in each step of a simulation
 * and generates a valid ESO file. If the output file already exists, it is
 * presumed that it already contains one or more traces. In that case, a reset
 * statement is added and the current trace is appended.
 * 
 * @author Sebastian Schäfer - ssc AT informatik.uni-kiel.de
 * @kieler.rating 2011-11-29 red
 *
 */
public class TraceWriter {
    /** Stores the input signals of a trace */
    private List<HashMap<String, Object>> inputs;
    
    /** Stores the output signals of a trace */
    private List<HashMap<String, Object>> outputs;
    
    /** Stores the state information generated by the simulation */
    private List<HashMap<String, Object>> specialSignals;
    
    /** Name of the file the trace shall be written to */
    private String filename;
    
    /** 
     * Prepare the writer to write a trace to a specified output file.
     * 
     * @param trace The internal trace representation to be written
     * @param filename The filename the trace shall be written to
     */
    public TraceWriter(List<HashMap<String, Object>> inputs, List<HashMap<String, Object>> outputs, List<HashMap<String, Object>> specialSignals, String filename) {
        this.inputs = inputs;
        this.outputs = outputs;
        this.specialSignals = specialSignals;
        this.filename = filename;
    }
    
    /**
     * Actually start writing the output file. If the file already exists, a new trace
     * is appended to it.
     * 
     * @throws KiemInitializationException
     *          when either the size of the input and out signal lists do not match or
     *          when an error during writing the file occurs
     * 
     */
    public void doWrite() throws KiemInitializationException {
        try {
            PrintWriter outWriter = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
            
            if(inputs.size() != outputs.size()) {
                throw new KiemInitializationException("The number of steps for input (" + inputs.size() + ") and output (" + outputs.size() + ") signals and state information does not match", true, null);
            }
            
            outWriter.println("! reset;");
            for(int i = 0; i < inputs.size(); i++) {
                outWriter.println(getSignalString(inputs.get(i)));
                outWriter.println(getOutputSignalString(outputs.get(i)));
                outWriter.println(getSpecialString(specialSignals.get(i)));
                outWriter.println(";");
            }
            
            outWriter.close();
        } catch (IOException e) {
            throw new KiemInitializationException("An error occurred when writing ESO trace file", true, e);
        }
    }
    
    /**
     * @param hashMap
     * @return
     */
    private String getSpecialString(HashMap<String, Object> signals) {
        String retval = "";
        Iterator<String> it = signals.keySet().iterator();
        
        while(it.hasNext()) {
            String key = it.next();
            Object value = signals.get(key);
            
            retval += "%% " + key + " : " + value.toString() + "\n";
        }
        
        return retval;
    }

    /**
     * Convert a signal map to a string representation as it is needed for an ESO file
     * 
     * @param map the map of input signals
     * @return the String representation of the input signal map
     */
    private String getSignalString(Map<String, Object> map) {
        String retval = "";
        
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        
        while(it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            
            if(entry.getValue() == null) {
                retval += entry.getKey() + " ";
            } else {
                retval += entry.getKey() + " (" + entry.getValue().toString() + ") ";
            }
        }
        return retval;
    }
    
    /**
     * Convert an output signal map to a string representation as it is needed for an ESO file
     * 
     * @see getSignalString()
     * @param map the map of output signals
     * @return the String representation of the output signal map
     */
    private String getOutputSignalString(Map<String, Object> map) {
        return "% Output: " + getSignalString(map);
    }
    

}