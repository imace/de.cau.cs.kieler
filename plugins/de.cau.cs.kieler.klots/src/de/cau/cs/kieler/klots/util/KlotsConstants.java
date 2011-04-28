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
package de.cau.cs.kieler.klots.util;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;


/**
 * @author root
 *
 */
public interface KlotsConstants {
    
    // CHECKSTYLEOFF LineLength

    public static final String SIGNALS_TAG = "SIGNALS";
    public static final String INSTRUCTION_TAG = "INSTRUCTION";
    public static final String TICK_INFO_TAG = "TICK_INFO";
    public static final String PROGRAM_INFO_TAG = "PROGRAM_INFO";

    public static final String PRINT_START_COMMAND_KEY = "PRINT_START:";
    public static final String PRINT_END_COMMAND_KEY = ":PRINT_END";
    public static final String PRINT_TAG = "PRINT:";

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

    public static final String SJ_FILE_NAME_EXTENSION = "java";


    // SJ INSTRUCTION MARKER ID & ATTRIBUTES
    public static final String SJ_INSTRUCTION_MARKER_ID = "de.cau.cs.kieler.klots.editor.instructionMarker";
    public static final String SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_NAME = "instructionName";
    public static final String SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_LABEL = "instructionLabel";
    public static final String SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_START = "instructionStart";
    public static final String SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_END = "instructionEnd";

    // HIGHLIGHT COLORS
    // black
    public static final Color FOREGROUND_STANDARD_COLOR = new Color(Display.getDefault(), 0, 0, 0);
    // white
    public static final Color BACKGROUND_STANDARD_COLOR = new Color(Display.getDefault(), 255, 255, 255);

    // dark orange
    public static final Color ALREADY_DONE_MICROSTEP_FOREGROUND_COLOR = new Color(Display.getDefault(), 255, 140, 0);
    // eclipse standard selected line background color
    public static final Color ALREADY_DONE_MICROSTEP_BACKGROUND_COLOR = new Color(Display.getDefault(), 232, 242, 254);
    // red
    public static final Color ACTIVE_MICROSTEP_FOREGROUND_COLOR = new Color(Display.getDefault(), 255, 0, 0);
    // eclipse standard selected line background color
    public static final Color ACTIVE_MICROSTEP_BACKGROUND_COLOR = new Color(Display.getDefault(), 232, 242, 254);
    // dark green
    public static final Color YET_TO_BE_DONE_MICROSTEP_FOREGROUND_COLOR = new Color(Display.getDefault(), 0, 100, 0);
    // misty rose
    public static final Color YET_TO_BE_DONE_MICROSTEP_BACKGROUND_COLOR = new Color(Display.getDefault(), 255, 228, 225);

    // SJ instructions
    public static final String[][] sjInstructionsMap = {
        // normal instructions
        {"abort", "abort"},
        {"awaitDone", "awaitDoneCB"},
        {"fork", "fork"},
        {"forke", "forkEB"},
        {"goto", "gotoB"},
        {"halt", "haltCB"},
        {"joinDone", "joinDoneCB"},
        {"pause", "pauseB"},
        {"prio", "prioB"},
        {"suspend", "suspend"},
        {"term", "termB"},
        {"trans", "transB"},
        // signal instructions
        {"present", "isPresent"},
        {"emit", "emit"},
        {"sustain", "sustainCB"},
        {"pre", "pre"}};
    public static final int sjInstructionsMapSize = 16;
    public static final String LABEL_ENUM_NAME = "enum StateLabel";
    public static final String LABEL_CASE_NAME = "case ";
    public static final String SIGNAL_DECLARATION_NAME = "addSignals(";
    public static final String TICK_METHOD_NAME = "public void tick()";

    public static final String EMPTY_STRING = "";
    public static final char SPACE_CHAR = ' ';
    public static final String SPACE_STRING = " ";
    public static final char COLON_CHAR = ':';
    public static final String COLON_STRING = ":";
    public static final char SEMICOLON_CHAR = ';';
    public static final String SEMICOLON_STRING = ";";
    public static final char COMMA_CHAR = ',';
    public static final String COMMA_STRING = ",";
    public static final char QUOTE_SIGN_CHAR = '"';
    public static final String QUOTE_SIGN_STRING = "\"";
    public static final char SJ_INSTRUCTION_START_BRACKET_CHAR = '(';
    public static final String SJ_INSTRUCTION_START_BRACKET_STRING = "(";
    public static final char SJ_INSTRUCTION_END_BRACKET_CHAR = ')';
    public static final String SJ_INSTRUCTION_END_BRACKET_STRING = ")";
    public static final String MULTI_LINE_COMMENT_START = "/*";
    public static final String MULTI_LINE_COMMENT_END = "*/";
    public static final String SINGLE_LINE_COMMENT_START = "//";
    public static final String SINGLE_LINE_COMMENT_END = "\n";
    public static final char STRING_START_CHAR = '\"';
    public static final String STRING_START_STRING = "\"";
    public static final char STRING_END_CHAR = '\"';
    public static final String STRING_END_STRING = "\"";

    // CHECKSTYLEON LineLength

}
