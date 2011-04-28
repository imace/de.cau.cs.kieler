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
 * @author root
 *
 */
public interface EmbeddedConstants {

    public static final String SIGNALS_TAG = "SIGNALS";
    public static final String INSTRUCTION_TAG = "INSTRUCTION";
    public static final String TICK_INFO_TAG = "TICK_INFO";
    public static final String PROGRAM_INFO_TAG = "PROGRAM_INFO";

    public static final String PRINT_START_COMMAND_KEY = "PRINT_START:";
    public static final String PRINT_END_COMMAND_KEY = ":PRINT_END";

    public static final String STANDALONE_PROGRAM_MODE_COMMAND_KEY = "STANDALONE";
    public static final String SYNCHRONIZED_COMMAND_KEY = "SYNCHRONIZED";
    public static final String STEP_COMMAND_KEY = "STEP";
    public static final String STOP_COMMAND_KEY = "STOP";
    public static final String END_OF_MESSAGE_COMMAND_KEY = "EOT";
    public static final String END_OF_TRANSMISSION_COMMAND_KEY = "END_OF_TRANSMISSION";
    public static final String MESSAGE_LINE_DELIMITER = "\n";
    public static final String MESSAGE_NEW_LINE = "NEW_LINE";

    public static final String JSON_EXECUTION_TRACE_TAG = "executionTrace";
    public static final String JSON_SIGNALS_TAG = "signals";
    public static final String JSON_LABEL_TAG = "label";
    public static final String JSON_PRIORITY_TAG = "prio";
    public static final String JSON_PARAMETER_TAG = "param";
    public static final String JSON_RETURN_VALUE_TAG = "retval";
    public static final String JSON_INITIAL_EXECUTION_TAG = "initialExcecution";


    public static final String EMPTY_STRING = "";
    public static final String NULL_STRING = "null";
    public static final char SPACE_CHAR = ' ';
    public static final String SPACE_STRING = " ";
    public static final char COLON_CHAR = ':';
    public static final String COLON_STRING = ":";
    public static final char SEMICOLON_CHAR = ';';
    public static final String SEMICOLON_STRING = ";";
    public static final char COMMA_CHAR = ',';
    public static final String COMMA_STRING = ",";

}