package de.cau.cs.kieler.klots;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public interface KlotsConstants {

	public final static String SIGNALS_TAG = "SIGNALS";
	public final static String INSTRUCTION_TAG = "INSTRUCTION";
	public final static String TICK_INFO_TAG = "TICK_INFO";
	public final static String PROGRAM_INFO_TAG = "PROGRAM_INFO";
	
	public final static String PRINT_START_COMMAND_KEY = "PRINT_START:";
	public final static String PRINT_END_COMMAND_KEY = ":PRINT_END";
	public final static String PRINT_TAG = "PRINT:";
	
	public final static String STANDALONE_PROGRAM_MODE_COMMAND_KEY = "STANDALONE";
	public final static String SYNCHRONIZED_COMMAND_KEY = "SYNCHRONIZED";
	public final static String STEP_COMMAND_KEY = "STEP";
	public final static String STOP_COMMAND_KEY = "STOP";
	public final static String END_OF_MESSAGE_COMMAND_KEY = "EOT";
	public final static String END_OF_TRANSMISSION_COMMAND_KEY = "END_OF_TRANSMISSION";
	public final static String MESSAGE_LINE_DELIMITER = "\n";
	public final static String MESSAGE_NEW_LINE = "NEW_LINE";
	
	public final static String JSON_EXECUTION_TRACE_TAG = "executionTrace";
	public final static String JSON_SIGNALS_TAG = "signals";
	public final static String JSON_LABEL_TAG = "label";
	public final static String JSON_PRIORITY_TAG = "prio";
	public final static String JSON_PARAMETER_TAG = "param";
	public final static String JSON_RETURN_VALUE_TAG = "retval";
	public final static String JSON_INITIAL_EXECUTION_TAG = "initialExcecution";
	
	public final static String SJ_FILE_NAME_EXTENSION = "java";
	
	
	// SJ INSTRUCTION MARKER ID & ATTRIBUTES
	public final static String SJ_INSTRUCTION_MARKER_ID = "de.cau.cs.kieler.klots.editor.instructionMarker";
	public final static String SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_NAME = "instructionName";
	public final static String SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_LABEL = "instructionLabel";
	public final static String SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_START = "instructionStart";
	public final static String SJ_INSTRUCTION_MARKER_ATTRIBUTE_INSTRUCTION_END = "instructionEnd";
	
	// HIGHLIGHT COLORS
	// black
	public final static Color FOREGROUND_STANDARD_COLOR = new Color(Display.getDefault(), 0, 0, 0);
	// white
	public final static Color BACKGROUND_STANDARD_COLOR = new Color(Display.getDefault(), 255, 255, 255);
	
	// dark orange
	public final static Color ALREADY_DONE_MICROSTEP_FOREGROUND_COLOR = new Color(Display.getDefault(), 255, 140, 0);
	// eclipse standard selected line background color
	public final static Color ALREADY_DONE_MICROSTEP_BACKGROUND_COLOR = new Color(Display.getDefault(), 232, 242, 254);
	// red
	public final static Color ACTIVE_MICROSTEP_FOREGROUND_COLOR = new Color(Display.getDefault(), 255, 0, 0);
	// eclipse standard selected line background color
	public final static Color ACTIVE_MICROSTEP_BACKGROUND_COLOR = new Color(Display.getDefault(), 232, 242, 254);
	// dark green
	public final static Color YET_TO_BE_DONE_MICROSTEP_FOREGROUND_COLOR = new Color(Display.getDefault(), 0, 100, 0);
	// misty rose
	public final static Color YET_TO_BE_DONE_MICROSTEP_BACKGROUND_COLOR = new Color(Display.getDefault(), 255, 228, 225);
	
	// SJ instructions
	public final static String[][] sjInstructionsMap = {
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
	public final static int sjInstructionsMapSize = 16;
	public final static String LABEL_ENUM_NAME = "enum StateLabel";
	public final static String LABEL_CASE_NAME = "case ";
	public final static String SIGNAL_DECLARATION_NAME = "addSignals(";
	public final static String TICK_METHOD_NAME = "public void tick()";
	
	public final static String EMPTY_STRING = "";
	public final static char SPACE_CHAR = ' ';
	public final static String SPACE_STRING = " ";
	public final static char COLON_CHAR = ':';
	public final static String COLON_STRING = ":";
	public final static char SEMICOLON_CHAR = ';';
	public final static String SEMICOLON_STRING = ";";
	public final static char COMMA_CHAR = ',';
	public final static String COMMA_STRING = ",";
	public final static char QUOTE_SIGN_CHAR = '"';
	public final static String QUOTE_SIGN_STRING = "\"";
	public final static char SJ_INSTRUCTION_START_BRACKET_CHAR = '(';
	public final static String SJ_INSTRUCTION_START_BRACKET_STRING = "(";
	public final static char SJ_INSTRUCTION_END_BRACKET_CHAR = ')';
	public final static String SJ_INSTRUCTION_END_BRACKET_STRING = ")";
	public final static String MULTI_LINE_COMMENT_START = "/*";
	public final static String MULTI_LINE_COMMENT_END = "*/";
	public final static String SINGLE_LINE_COMMENT_START = "//";
	public final static String SINGLE_LINE_COMMENT_END = "\n";
	public final static char STRING_START_CHAR = '\"';
	public final static String STRING_START_STRING = "\"";
	public final static char STRING_END_CHAR = '\"';
	public final static String STRING_END_STRING = "\"";
	
	
}
