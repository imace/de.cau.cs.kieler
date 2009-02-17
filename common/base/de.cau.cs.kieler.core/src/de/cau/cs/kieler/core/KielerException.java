package de.cau.cs.kieler.core;

/**
 * Exception for error handling in KIELER projects.
 * 
 * @author msp
 */
public class KielerException extends Exception {

	private static final long serialVersionUID = 366091287522261006L;
	
	/**
	 * Definition of exception types, may be extended to match more cases.
	 */
	public enum Type {
		/** default value */
		UNDEFINED,
		/** a file system path does not point to a valid target */
		INVALID_PATH,
		/** an external library or program reported failure */
		EXTERNAL_ERROR,
		/** a timeout occurred while waiting for some operation */
		TIMEOUT,
		/** a constructed LP can't be solved because it is infeasible */
		INFEASIBLE_LP,
	}
	
	private Type type = Type.UNDEFINED;
	
	/**
	 * Constructs a KIELER exception with given message.
	 * 
	 * @param message readable exception message
	 */
	public KielerException(String message) {
		super(message);
	}
	
	/**
	 * Constructs a KIELER exception with given message and type.
	 * 
	 * @param message readable exception message
	 * @param type type of KIELER exception
	 */
	public KielerException(String message, Type type) {
		super(message);
		this.type = type;
	}
	
	/**
	 * Returns the type of KIELER exception.
	 * 
	 * @return the exception type
	 */
	public Type getType() {
		return type;
	}

}
