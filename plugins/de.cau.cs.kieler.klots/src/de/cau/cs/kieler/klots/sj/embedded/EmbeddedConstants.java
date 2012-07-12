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
package de.cau.cs.kieler.klots.sj.embedded;

/**
 * The Interface EmbeddedConstants.
 *
 * @author ybe
 */
public final class EmbeddedConstants {
    
    /** The Constant USB_CONNECTION. */
    public static final int USB_CONNECTION = 1;
    
    /** The Constant BLUETOOTH_CONNECTION. */
    public static final int BLUETOOTH_CONNECTION = 2;

    /** The Constant SIGNALS_TAG. */
    public static final String SIGNALS_TAG = "SIGNALS";
    
    /** The Constant INSTRUCTION_TAG. */
    public static final String INSTRUCTION_TAG = "INSTRUCTION";
    
    /** The Constant TICK_INFO_TAG. */
    public static final String TICK_INFO_TAG = "TICK_INFO";
    
    /** The Constant PROGRAM_INFO_TAG. */
    public static final String PROGRAM_INFO_TAG = "PROGRAM_INFO";

    /** The Constant PRINT_START_COMMAND_KEY. */
    public static final String PRINT_START_COMMAND_KEY = "PRINT_START:";
    
    /** The Constant PRINT_END_COMMAND_KEY. */
    public static final String PRINT_END_COMMAND_KEY = ":PRINT_END";

    /** The Constant EMBEDDED_JAVA_PROGRAM_MODE_COMMAND_KEY. */
    public static final String EMBEDDED_JAVA_PROGRAM_MODE_COMMAND_KEY = "EMBEDDED_JAVA";
    
    /** The Constant EMBEDDED_SJ_PROGRAM_MODE_COMMAND_KEY. */
    public static final String EMBEDDED_SJ_PROGRAM_MODE_COMMAND_KEY = "EMBEDDED_SJ";
    
    /** The Constant SYNCHRONIZED_COMMAND_KEY. */
    public static final String SYNCHRONIZED_COMMAND_KEY = "SYNCHRONIZED";
    
    /** The Constant STEP_COMMAND_KEY. */
    public static final String STEP_COMMAND_KEY = "STEP";
    
    /** The Constant STOP_COMMAND_KEY. */
    public static final String STOP_COMMAND_KEY = "STOP";
    
    /** The Constant END_OF_MESSAGE_COMMAND_KEY. */
    public static final String END_OF_MESSAGE_COMMAND_KEY = "EOT";
    
    /** The Constant END_OF_TRANSMISSION_COMMAND_KEY. */
    public static final String END_OF_TRANSMISSION_COMMAND_KEY = "END_OF_TRANSMISSION";
    
    /** The Constant MESSAGE_LINE_DELIMITER. */
    public static final String MESSAGE_LINE_DELIMITER = "\n";
    
    /** The Constant MESSAGE_NEW_LINE. */
    public static final String MESSAGE_NEW_LINE = "NEW_LINE";

    /** The Constant JSON_EXECUTION_TRACE_TAG. */
    public static final String JSON_EXECUTION_TRACE_TAG = "executionTrace";
    
    /** The Constant JSON_SIGNALS_TAG. */
    public static final String JSON_SIGNALS_TAG = "signals";
    
    /** The Constant JSON_LABEL_TAG. */
    public static final String JSON_LABEL_TAG = "label";
    
    /** The Constant JSON_PRIORITY_TAG. */
    public static final String JSON_PRIORITY_TAG = "prio";
    
    /** The Constant JSON_PARAMETER_TAG. */
    public static final String JSON_PARAMETER_TAG = "param";
    
    /** The Constant JSON_RETURN_VALUE_TAG. */
    public static final String JSON_RETURN_VALUE_TAG = "retval";
    
    /** The Constant JSON_INITIAL_EXECUTION_TAG. */
    public static final String JSON_INITIAL_EXECUTION_TAG = "initialExcecution";


    /** The Constant EMPTY_STRING. */
    public static final String EMPTY_STRING = "";
    
    /** The Constant NULL_STRING. */
    public static final String NULL_STRING = "null";
    
    /** The Constant SPACE_CHAR. */
    public static final char SPACE_CHAR = ' ';
    
    /** The Constant SPACE_STRING. */
    public static final String SPACE_STRING = " ";
    
    /** The Constant COLON_CHAR. */
    public static final char COLON_CHAR = ':';
    
    /** The Constant COLON_STRING. */
    public static final String COLON_STRING = ":";
    
    /** The Constant SEMICOLON_CHAR. */
    public static final char SEMICOLON_CHAR = ';';
    
    /** The Constant SEMICOLON_STRING. */
    public static final String SEMICOLON_STRING = ";";
    
    /** The Constant COMMA_CHAR. */
    public static final char COMMA_CHAR = ',';
    
    /** The Constant COMMA_STRING. */
    public static final String COMMA_STRING = ",";

    
    /**
     * The constructor is hidden cause this class should not be instantiated.
     */
    private EmbeddedConstants() {
    }
}