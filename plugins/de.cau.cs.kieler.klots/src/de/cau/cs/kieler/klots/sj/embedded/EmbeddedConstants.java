package de.cau.cs.kieler.klots.sj.embedded;

public interface EmbeddedConstants {

	public final static String SIGNALS_TAG = "SIGNALS";
	public final static String INSTRUCTION_TAG = "INSTRUCTION";
	public final static String TICK_INFO_TAG = "TICK_INFO";
	public final static String PROGRAM_INFO_TAG = "PROGRAM_INFO";
	
	public final static String PRINT_START_COMMAND_KEY = "PRINT_START:";
	public final static String PRINT_END_COMMAND_KEY = ":PRINT_END";
	
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
	
	
	public final static String EMPTY_STRING = "";
	public final static String NULL_STRING = "null";
	public final static char SPACE_CHAR = ' ';
	public final static String SPACE_STRING = " ";
	public final static char COLON_CHAR = ':';
	public final static String COLON_STRING = ":";
	public final static char SEMICOLON_CHAR = ';';
	public final static String SEMICOLON_STRING = ";";
	public final static char COMMA_CHAR = ',';
	public final static String COMMA_STRING = ",";
	
}
