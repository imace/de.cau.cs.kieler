/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Var Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getVarType()
 * @model
 * @generated
 */
public enum VarType implements Enumerator {
	/**
	 * The '<em><b>BYTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BYTE_VALUE
	 * @generated
	 * @ordered
	 */
	BYTE(0, "BYTE", "BYTE"),

	/**
	 * The '<em><b>DT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DT_VALUE
	 * @generated
	 * @ordered
	 */
	DT(1, "DT", "DT"),

	/**
	 * The '<em><b>LREAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LREAL_VALUE
	 * @generated
	 * @ordered
	 */
	LREAL(2, "LREAL", "LREAL"),

	/**
	 * The '<em><b>UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UINT_VALUE
	 * @generated
	 * @ordered
	 */
	UINT(3, "UINT", "UINT"),

	/**
	 * The '<em><b>LINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINT_VALUE
	 * @generated
	 * @ordered
	 */
	LINT(4, "LINT", "LINT"),

	/**
	 * The '<em><b>BOOL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOL_VALUE
	 * @generated
	 * @ordered
	 */
	BOOL(5, "BOOL", "BOOL"),

	/**
	 * The '<em><b>DATE AND TIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATE_AND_TIME_VALUE
	 * @generated
	 * @ordered
	 */
	DATE_AND_TIME(6, "DATE_AND_TIME", "DATE_AND_TIME"),

	/**
	 * The '<em><b>INT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_VALUE
	 * @generated
	 * @ordered
	 */
	INT(7, "INT", "INT"),

	/**
	 * The '<em><b>SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINT_VALUE
	 * @generated
	 * @ordered
	 */
	SINT(8, "SINT", "SINT"),

	/**
	 * The '<em><b>LWORD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LWORD_VALUE
	 * @generated
	 * @ordered
	 */
	LWORD(9, "LWORD", "LWORD"),

	/**
	 * The '<em><b>COLOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLOR_VALUE
	 * @generated
	 * @ordered
	 */
	COLOR(10, "COLOR", "COLOR"),

	/**
	 * The '<em><b>WORD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WORD_VALUE
	 * @generated
	 * @ordered
	 */
	WORD(11, "WORD", "WORD"),

	/**
	 * The '<em><b>REAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REAL_VALUE
	 * @generated
	 * @ordered
	 */
	REAL(12, "REAL", "REAL"),

	/**
	 * The '<em><b>TIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIME_VALUE
	 * @generated
	 * @ordered
	 */
	TIME(13, "TIME", "TIME"),

	/**
	 * The '<em><b>TOD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOD_VALUE
	 * @generated
	 * @ordered
	 */
	TOD(14, "TOD", "TOD"),

	/**
	 * The '<em><b>ANY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANY_VALUE
	 * @generated
	 * @ordered
	 */
	ANY(15, "ANY", "ANY"),

	/**
	 * The '<em><b>DWORD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DWORD_VALUE
	 * @generated
	 * @ordered
	 */
	DWORD(16, "DWORD", "DWORD"),

	/**
	 * The '<em><b>UDINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UDINT_VALUE
	 * @generated
	 * @ordered
	 */
	UDINT(17, "UDINT", "UDINT"),

	/**
	 * The '<em><b>USINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USINT_VALUE
	 * @generated
	 * @ordered
	 */
	USINT(18, "USINT", "USINT"),

	/**
	 * The '<em><b>TIME OF DAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIME_OF_DAY_VALUE
	 * @generated
	 * @ordered
	 */
	TIME_OF_DAY(19, "TIME_OF_DAY", "TIME_OF_DAY"),

	/**
	 * The '<em><b>WSTRING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WSTRING_VALUE
	 * @generated
	 * @ordered
	 */
	WSTRING(20, "WSTRING", "WSTRING"),

	/**
	 * The '<em><b>DINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DINT_VALUE
	 * @generated
	 * @ordered
	 */
	DINT(21, "DINT", "DINT"),

	/**
	 * The '<em><b>DATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATE_VALUE
	 * @generated
	 * @ordered
	 */
	DATE(22, "DATE", "DATE"),

	/**
	 * The '<em><b>ULINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ULINT_VALUE
	 * @generated
	 * @ordered
	 */
	ULINT(23, "ULINT", "ULINT"),

	/**
	 * The '<em><b>VSTYLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VSTYLE_VALUE
	 * @generated
	 * @ordered
	 */
	VSTYLE(24, "VSTYLE", "VSTYLE"),

	/**
	 * The '<em><b>ARRAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARRAY_VALUE
	 * @generated
	 * @ordered
	 */
	ARRAY(25, "ARRAY", "ARRAY"),

	/**
	 * The '<em><b>STRING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRING_VALUE
	 * @generated
	 * @ordered
	 */
	STRING(26, "STRING", "STRING");

	/**
	 * The '<em><b>BYTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BYTE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BYTE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BYTE_VALUE = 0;

	/**
	 * The '<em><b>DT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DT_VALUE = 1;

	/**
	 * The '<em><b>LREAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LREAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LREAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LREAL_VALUE = 2;

	/**
	 * The '<em><b>UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UINT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UINT_VALUE = 3;

	/**
	 * The '<em><b>LINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LINT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINT_VALUE = 4;

	/**
	 * The '<em><b>BOOL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOOL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOOL_VALUE = 5;

	/**
	 * The '<em><b>DATE AND TIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DATE AND TIME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATE_AND_TIME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATE_AND_TIME_VALUE = 6;

	/**
	 * The '<em><b>INT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INT_VALUE = 7;

	/**
	 * The '<em><b>SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SINT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINT_VALUE = 8;

	/**
	 * The '<em><b>LWORD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LWORD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LWORD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LWORD_VALUE = 9;

	/**
	 * The '<em><b>COLOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COLOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COLOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COLOR_VALUE = 10;

	/**
	 * The '<em><b>WORD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WORD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WORD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WORD_VALUE = 11;

	/**
	 * The '<em><b>REAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REAL_VALUE = 12;

	/**
	 * The '<em><b>TIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TIME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TIME_VALUE = 13;

	/**
	 * The '<em><b>TOD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOD_VALUE = 14;

	/**
	 * The '<em><b>ANY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANY_VALUE = 15;

	/**
	 * The '<em><b>DWORD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DWORD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DWORD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DWORD_VALUE = 16;

	/**
	 * The '<em><b>UDINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UDINT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UDINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UDINT_VALUE = 17;

	/**
	 * The '<em><b>USINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USINT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USINT_VALUE = 18;

	/**
	 * The '<em><b>TIME OF DAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TIME OF DAY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIME_OF_DAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TIME_OF_DAY_VALUE = 19;

	/**
	 * The '<em><b>WSTRING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WSTRING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WSTRING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WSTRING_VALUE = 20;

	/**
	 * The '<em><b>DINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DINT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DINT_VALUE = 21;

	/**
	 * The '<em><b>DATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATE_VALUE = 22;

	/**
	 * The '<em><b>ULINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ULINT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ULINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ULINT_VALUE = 23;

	/**
	 * The '<em><b>VSTYLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VSTYLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VSTYLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VSTYLE_VALUE = 24;

	/**
	 * The '<em><b>ARRAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARRAY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARRAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY_VALUE = 25;

	/**
	 * The '<em><b>STRING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRING_VALUE = 26;

	/**
	 * An array of all the '<em><b>Var Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final VarType[] VALUES_ARRAY =
		new VarType[] {
			BYTE,
			DT,
			LREAL,
			UINT,
			LINT,
			BOOL,
			DATE_AND_TIME,
			INT,
			SINT,
			LWORD,
			COLOR,
			WORD,
			REAL,
			TIME,
			TOD,
			ANY,
			DWORD,
			UDINT,
			USINT,
			TIME_OF_DAY,
			WSTRING,
			DINT,
			DATE,
			ULINT,
			VSTYLE,
			ARRAY,
			STRING,
		};

	/**
	 * A public read-only list of all the '<em><b>Var Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<VarType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Var Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VarType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VarType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Var Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VarType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VarType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Var Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VarType get(int value) {
		switch (value) {
			case BYTE_VALUE: return BYTE;
			case DT_VALUE: return DT;
			case LREAL_VALUE: return LREAL;
			case UINT_VALUE: return UINT;
			case LINT_VALUE: return LINT;
			case BOOL_VALUE: return BOOL;
			case DATE_AND_TIME_VALUE: return DATE_AND_TIME;
			case INT_VALUE: return INT;
			case SINT_VALUE: return SINT;
			case LWORD_VALUE: return LWORD;
			case COLOR_VALUE: return COLOR;
			case WORD_VALUE: return WORD;
			case REAL_VALUE: return REAL;
			case TIME_VALUE: return TIME;
			case TOD_VALUE: return TOD;
			case ANY_VALUE: return ANY;
			case DWORD_VALUE: return DWORD;
			case UDINT_VALUE: return UDINT;
			case USINT_VALUE: return USINT;
			case TIME_OF_DAY_VALUE: return TIME_OF_DAY;
			case WSTRING_VALUE: return WSTRING;
			case DINT_VALUE: return DINT;
			case DATE_VALUE: return DATE;
			case ULINT_VALUE: return ULINT;
			case VSTYLE_VALUE: return VSTYLE;
			case ARRAY_VALUE: return ARRAY;
			case STRING_VALUE: return STRING;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private VarType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //VarType
