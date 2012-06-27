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
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;


// TODO: Auto-generated Javadoc
/**
 * The Class KlotsConstants.
 *
 * @author root
 */
public final class KlotsConstants {
    
    // CHECKSTYLEOFF LineLength
    
    /** The Constant KLOTS_SHORT_NAME. */
    public static final String KLOTS_SHORT_NAME = "KLOTS";
    
    /** The Constant KLOTS_FULL_NAME. */
    public static final String KLOTS_FULL_NAME = "KIELER LEGO On-line Testing System";
    
    /** The Constant KLOTS_TEMPLATES_FOLDER_NAME. */
    public static final String KLOTS_TEMPLATES_FOLDER_NAME = "templates";
    
    /** The Constant KLOTS_TEMPLATES_LEJOS_FOLDER_NAME. */
    public static final String KLOTS_TEMPLATES_LEJOS_FOLDER_NAME = "lejos";
    
    /** The Constant KLOTS_TEMPLATES_EMBEDDED_SJ_JAR_NAME. */
    public static final String KLOTS_TEMPLATES_EMBEDDED_SJ_JAR_NAME = "embeddedSJ.jar";
    
    /** The Constant KLOTS_TEMPLATES_EMBEDDED_JAVA_JAR_NAME. */
    public static final String KLOTS_TEMPLATES_EMBEDDED_JAVA_JAR_NAME = "embeddedJava.jar";
    
    /** The Constant KLOTS_TEMPLATES_LEJOS_CLASSES_JAR_NAME. */
    public static final String KLOTS_TEMPLATES_LEJOS_CLASSES_JAR_NAME = "classes.jar";
    
    /** The Constant KLOTS_TEMPLATES_LEJOS_FIRMWARE_FILE_NAME. */
    public static final String KLOTS_TEMPLATES_LEJOS_FIRMWARE_FILE_NAME = "lejos_nxt_rom.bin";
    
    /** The Constant KLOTS_TEMPLATES_LEJOS_FIRMWARE_MENU_FILE_NAME. */
    public static final String KLOTS_TEMPLATES_LEJOS_FIRMWARE_MENU_FILE_NAME = "StartUpText.bin";
    
    /** The Constant KLOTS_TEMPLATES_EMBEDDED_JAVA_CLASSPATH_FILE_NAME. */
    public static final String KLOTS_TEMPLATES_EMBEDDED_JAVA_CLASSPATH_FILE_NAME = "classpathEmbeddedJava.template";
    
    /** The Constant KLOTS_TEMPLATES_EMBEDDED_SJ_CLASSPATH_FILE_NAME. */
    public static final String KLOTS_TEMPLATES_EMBEDDED_SJ_CLASSPATH_FILE_NAME = "classpathSJ.template";
    
    /** The Constant KLOTS_TEMPLATES_PROJECT_FILE_NAME. */
    public static final String KLOTS_TEMPLATES_PROJECT_FILE_NAME = "project.template";
    
    /** The Constant KLOTS_TEMPLATES_PROJECT_SETTINGS_FILE_NAME. */
    public static final String KLOTS_TEMPLATES_PROJECT_SETTINGS_FILE_NAME = "org.eclipse.jdt.core.prefs.template";
    
    /** The Constant KLOTS_TEMPLATES_NEW_EMBEDDED_JAVA_FILE_NAME. */
    public static final String KLOTS_TEMPLATES_NEW_EMBEDDED_JAVA_FILE_NAME = "NewPOJFile.template";
    
    /** The Constant KLOTS_TEMPLATES_NEW_EMBEDDED_SJ_FILE_NAME. */
    public static final String KLOTS_TEMPLATES_NEW_EMBEDDED_SJ_FILE_NAME = "NewSJFile.template";
    
    /** The Constant KLOTS_TEMPLATES_PROJECT_FILE_NAME_OPEN_TAG. */
    public static final String KLOTS_TEMPLATES_PROJECT_FILE_NAME_OPEN_TAG = "<name>";
    
    /** The Constant KLOTS_TEMPLATES_PROJECT_FILE_NAME_CLOSE_TAG. */
    public static final String KLOTS_TEMPLATES_PROJECT_FILE_NAME_CLOSE_TAG = "</name>";
    
    /** The Constant KLOTS_TEMPLATES_PACKAGE_TAG. */
    public static final String KLOTS_TEMPLATES_PACKAGE_TAG = "<PACKAGE>";
    
    /** The Constant KLOTS_TEMPLATES_CLASS_TAG. */
    public static final String KLOTS_TEMPLATES_CLASS_TAG = "<CLASS>";

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
    
    /** The Constant PRINT_TAG. */
    public static final String PRINT_TAG = "PRINT:";

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

    /** The Constant SJ_FILE_NAME_EXTENSION. */
    public static final String SJ_FILE_NAME_EXTENSION = "java";
    
    /** The Constant EMBEDDED_JAVA_FILE_NAME_EXTENSION. */
    public static final String EMBEDDED_JAVA_FILE_NAME_EXTENSION = "java";


    // SJ INSTRUCTION MARKER ID & ATTRIBUTES
    /** The Constant SJ_INSTRUCTION_MARKER_ID. */
    public static final String SJ_INSTRUCTION_MARKER_ID = "de.cau.cs.kieler.klots.editor.instructionMarker";
    
    /** The Constant SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_NAME. */
    public static final String SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_NAME = "instructionName";
    
    /** The Constant SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_LABEL. */
    public static final String SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_LABEL = "instructionLabel";
    
    /** The Constant SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_START. */
    public static final String SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_START = "instructionStart";
    
    /** The Constant SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_END. */
    public static final String SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_END = "instructionEnd";

    // HIGHLIGHT COLORS
    /** The Constant COLORS_NUMBER. */
    public static final int COLORS_NUMBER = 8;
    // black
    /** The Constant COLOR_RGB_FOREGROUND_STANDARD. */
    public static final RGB COLOR_RGB_FOREGROUND_STANDARD =                 new RGB(0, 0, 0);
    // white
    /** The Constant COLOR_RGB_BACKGROUND_STANDARD. */
    public static final RGB COLOR_RGB_BACKGROUND_STANDARD =                 new RGB(255, 255, 255);
    // dark orange
    /** The Constant COLOR_RGB_FOREGROUND_ALREADY_DONE_MICROSTEP. */
    public static final RGB COLOR_RGB_FOREGROUND_ALREADY_DONE_MICROSTEP =   new RGB(0, 0, 0); //(255, 140,   0);
    // dark sea green 1 //eclipse standard selected line background color
    /** The Constant COLOR_RGB_BACKGROUND_ALREADY_DONE_MICROSTEP. */
    public static final RGB COLOR_RGB_BACKGROUND_ALREADY_DONE_MICROSTEP =   new RGB(193, 255, 193); //(232, 242, 254);
    // red
    /** The Constant COLOR_RGB_FOREGROUND_ACTIVE_MICROSTEP. */
    public static final RGB COLOR_RGB_FOREGROUND_ACTIVE_MICROSTEP =         new RGB(0, 0, 0); //(255,   0,   0);
    // light sky blue 1 //eclipse standard selected line background color
    /** The Constant COLOR_RGB_BACKGROUND_ACTIVE_MICROSTEP. */
    public static final RGB COLOR_RGB_BACKGROUND_ACTIVE_MICROSTEP =         new RGB(176, 226, 255); //(232, 242, 254);
    // dark green
    /** The Constant COLOR_RGB_FOREGROUND_YET_TO_BE_DONE_MICROSTEP. */
    public static final RGB COLOR_RGB_FOREGROUND_YET_TO_BE_DONE_MICROSTEP = new RGB(0, 0, 0); //(  0, 100,   0);
    // misty rose
    /** The Constant COLOR_RGB_BACKGROUND_YET_TO_BE_DONE_MICROSTEP. */
    public static final RGB COLOR_RGB_BACKGROUND_YET_TO_BE_DONE_MICROSTEP = new RGB(255, 228, 225);
    
    // black
    /** The Constant FOREGROUND_STANDARD_COLOR. */
    public static final Color FOREGROUND_STANDARD_COLOR = new Color(Display.getDefault(), 0, 0, 0);
    // white
    /** The Constant BACKGROUND_STANDARD_COLOR. */
    public static final Color BACKGROUND_STANDARD_COLOR = new Color(Display.getDefault(), 255, 255, 255);

    // dark orange
    /** The Constant ALREADY_DONE_MICROSTEP_FOREGROUND_COLOR. */
    public static final Color ALREADY_DONE_MICROSTEP_FOREGROUND_COLOR = new Color(Display.getDefault(), 0, 0, 0); //255, 140, 0);
    // dark sea green 1 //eclipse standard selected line background color
    /** The Constant ALREADY_DONE_MICROSTEP_BACKGROUND_COLOR. */
    public static final Color ALREADY_DONE_MICROSTEP_BACKGROUND_COLOR = new Color(Display.getDefault(), 193, 255, 193); //232, 242, 254);
    // red
    /** The Constant ACTIVE_MICROSTEP_FOREGROUND_COLOR. */
    public static final Color ACTIVE_MICROSTEP_FOREGROUND_COLOR = new Color(Display.getDefault(), 0, 0, 0); // 255, 0, 0);
    // light sky blue 1 //eclipse standard selected line background color
    /** The Constant ACTIVE_MICROSTEP_BACKGROUND_COLOR. */
    public static final Color ACTIVE_MICROSTEP_BACKGROUND_COLOR = new Color(Display.getDefault(), 176, 226, 255); //232, 242, 254);
    // dark green
    /** The Constant YET_TO_BE_DONE_MICROSTEP_FOREGROUND_COLOR. */
    public static final Color YET_TO_BE_DONE_MICROSTEP_FOREGROUND_COLOR = new Color(Display.getDefault(), 0, 0, 0); // 0, 100, 0);
    // misty rose
    /** The Constant YET_TO_BE_DONE_MICROSTEP_BACKGROUND_COLOR. */
    public static final Color YET_TO_BE_DONE_MICROSTEP_BACKGROUND_COLOR = new Color(Display.getDefault(), 255, 228, 225);

    // SJ instructions
    /** The Constant sjInstructionsMap. */
    public static final String[][] SJ_INSTSTRUCTIONS_MAP = {
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
    
    /** The Constant sjInstructionsMapSize. */
    public static final int SJ_INSTRUCTIONS_MAP_SIZE = 16;
    
    /** The Constant LABEL_ENUM_NAME. */
    public static final String LABEL_ENUM_NAME = "enum StateLabel";
    
    /** The Constant LABEL_CASE_NAME. */
    public static final String LABEL_CASE_NAME = "case ";
    
    /** The Constant SIGNAL_DECLARATION_NAME. */
    public static final String SIGNAL_DECLARATION_NAME = "addSignals(";
    
    /** The Constant TICK_METHOD_NAME. */
    public static final String TICK_METHOD_NAME = "public void tick()";

    /** The Constant EMPTY_STRING. */
    public static final String EMPTY_STRING = "";
    
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
    
    /** The Constant QUOTE_SIGN_CHAR. */
    public static final char QUOTE_SIGN_CHAR = '"';
    
    /** The Constant QUOTE_SIGN_STRING. */
    public static final String QUOTE_SIGN_STRING = "\"";
    
    /** The Constant SJ_INSTRUCTION_START_BRACKET_CHAR. */
    public static final char SJ_INSTRUCTION_START_BRACKET_CHAR = '(';
    
    /** The Constant SJ_INSTRUCTION_START_BRACKET_STRING. */
    public static final String SJ_INSTRUCTION_START_BRACKET_STRING = "(";
    
    /** The Constant SJ_INSTRUCTION_END_BRACKET_CHAR. */
    public static final char SJ_INSTRUCTION_END_BRACKET_CHAR = ')';
    
    /** The Constant SJ_INSTRUCTION_END_BRACKET_STRING. */
    public static final String SJ_INSTRUCTION_END_BRACKET_STRING = ")";
    
    /** The Constant MULTI_LINE_COMMENT_START. */
    public static final String MULTI_LINE_COMMENT_START = "/*";
    
    /** The Constant MULTI_LINE_COMMENT_END. */
    public static final String MULTI_LINE_COMMENT_END = "*/";
    
    /** The Constant SINGLE_LINE_COMMENT_START. */
    public static final String SINGLE_LINE_COMMENT_START = "//";
    
    /** The Constant SINGLE_LINE_COMMENT_END. */
    public static final String SINGLE_LINE_COMMENT_END = "\n";
    
    /** The Constant STRING_START_CHAR. */
    public static final char STRING_START_CHAR = '\"';
    
    /** The Constant STRING_START_STRING. */
    public static final String STRING_START_STRING = "\"";
    
    /** The Constant STRING_END_CHAR. */
    public static final char STRING_END_CHAR = '\"';
    
    /** The Constant STRING_END_STRING. */
    public static final String STRING_END_STRING = "\"";
    
    /** The Constant SEARATOR_STRING. */
    public static final String SEARATOR_STRING = "<#>";

    // CHECKSTYLEON LineLength
    
    /**
     * Utility class not to be instantiated.
     */
    private KlotsConstants() {
    }

}
