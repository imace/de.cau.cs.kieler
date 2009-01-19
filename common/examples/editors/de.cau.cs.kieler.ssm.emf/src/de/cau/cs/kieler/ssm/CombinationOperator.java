/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.ssm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Combination Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.ssm.ssmPackage#getCombinationOperator()
 * @model
 * @generated
 */
public enum CombinationOperator implements Enumerator {
	/**
	 * The '<em><b>PURESIGNALAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PURESIGNALAND_VALUE
	 * @generated
	 * @ordered
	 */
	PURESIGNALAND(0, "PURESIGNALAND", "PURESIGNALAND"),

	/**
	 * The '<em><b>PURESIGNALOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PURESIGNALOR_VALUE
	 * @generated
	 * @ordered
	 */
	PURESIGNALOR(1, "PURESIGNALOR", "PURESIGNALOR"),

	/**
	 * The '<em><b>PURESIGNALNOT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PURESIGNALNOT_VALUE
	 * @generated
	 * @ordered
	 */
	PURESIGNALNOT(2, "PURESIGNALNOT", "PURESIGNALNOT"),

	/**
	 * The '<em><b>INTSIGNALADD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTSIGNALADD_VALUE
	 * @generated
	 * @ordered
	 */
	INTSIGNALADD(3, "INTSIGNALADD", "INTSIGNALADD"),

	/**
	 * The '<em><b>INTSIGNALMUL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTSIGNALMUL_VALUE
	 * @generated
	 * @ordered
	 */
	INTSIGNALMUL(4, "INTSIGNALMUL", "INTSIGNALMUL"),

	/**
	 * The '<em><b>INTSIGNALGT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTSIGNALGT_VALUE
	 * @generated
	 * @ordered
	 */
	INTSIGNALGT(5, "INTSIGNALGT", "INTSIGNALGT"),

	/**
	 * The '<em><b>INTSIGNALLT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTSIGNALLT_VALUE
	 * @generated
	 * @ordered
	 */
	INTSIGNALLT(6, "INTSIGNALLT", "INTSIGNALLT"),

	/**
	 * The '<em><b>STRINGSIGNALCONCAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRINGSIGNALCONCAT_VALUE
	 * @generated
	 * @ordered
	 */
	STRINGSIGNALCONCAT(7, "STRINGSIGNALCONCAT", "STRINGSIGNALCONCAT"),

	/**
	 * The '<em><b>INTSIGNALEQ</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTSIGNALEQ_VALUE
	 * @generated
	 * @ordered
	 */
	INTSIGNALEQ(8, "INTSIGNALEQ", "INTSIGNALEQ"),

	/**
	 * The '<em><b>STRINGSIGNALEQ</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRINGSIGNALEQ_VALUE
	 * @generated
	 * @ordered
	 */
	STRINGSIGNALEQ(9, "STRINGSIGNALEQ", "STRINGSIGNALEQ"),

	/**
	 * The '<em><b>PURESIGNALEQ</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PURESIGNALEQ_VALUE
	 * @generated
	 * @ordered
	 */
	PURESIGNALEQ(10, "PURESIGNALEQ", "PURESIGNALEQ");

	/**
	 * The '<em><b>PURESIGNALAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PURESIGNALAND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PURESIGNALAND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PURESIGNALAND_VALUE = 0;

	/**
	 * The '<em><b>PURESIGNALOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PURESIGNALOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PURESIGNALOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PURESIGNALOR_VALUE = 1;

	/**
	 * The '<em><b>PURESIGNALNOT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PURESIGNALNOT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PURESIGNALNOT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PURESIGNALNOT_VALUE = 2;

	/**
	 * The '<em><b>INTSIGNALADD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INTSIGNALADD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTSIGNALADD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INTSIGNALADD_VALUE = 3;

	/**
	 * The '<em><b>INTSIGNALMUL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INTSIGNALMUL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTSIGNALMUL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INTSIGNALMUL_VALUE = 4;

	/**
	 * The '<em><b>INTSIGNALGT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INTSIGNALGT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTSIGNALGT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INTSIGNALGT_VALUE = 5;

	/**
	 * The '<em><b>INTSIGNALLT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INTSIGNALLT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTSIGNALLT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INTSIGNALLT_VALUE = 6;

	/**
	 * The '<em><b>STRINGSIGNALCONCAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRINGSIGNALCONCAT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRINGSIGNALCONCAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRINGSIGNALCONCAT_VALUE = 7;

	/**
	 * The '<em><b>INTSIGNALEQ</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INTSIGNALEQ</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTSIGNALEQ
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INTSIGNALEQ_VALUE = 8;

	/**
	 * The '<em><b>STRINGSIGNALEQ</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRINGSIGNALEQ</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRINGSIGNALEQ
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRINGSIGNALEQ_VALUE = 9;

	/**
	 * The '<em><b>PURESIGNALEQ</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PURESIGNALEQ</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PURESIGNALEQ
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PURESIGNALEQ_VALUE = 10;

	/**
	 * An array of all the '<em><b>Combination Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CombinationOperator[] VALUES_ARRAY =
		new CombinationOperator[] {
			PURESIGNALAND,
			PURESIGNALOR,
			PURESIGNALNOT,
			INTSIGNALADD,
			INTSIGNALMUL,
			INTSIGNALGT,
			INTSIGNALLT,
			STRINGSIGNALCONCAT,
			INTSIGNALEQ,
			STRINGSIGNALEQ,
			PURESIGNALEQ,
		};

	/**
	 * A public read-only list of all the '<em><b>Combination Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CombinationOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Combination Operator</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CombinationOperator get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CombinationOperator result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Combination Operator</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CombinationOperator getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CombinationOperator result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Combination Operator</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CombinationOperator get(int value) {
		switch (value) {
			case PURESIGNALAND_VALUE: return PURESIGNALAND;
			case PURESIGNALOR_VALUE: return PURESIGNALOR;
			case PURESIGNALNOT_VALUE: return PURESIGNALNOT;
			case INTSIGNALADD_VALUE: return INTSIGNALADD;
			case INTSIGNALMUL_VALUE: return INTSIGNALMUL;
			case INTSIGNALGT_VALUE: return INTSIGNALGT;
			case INTSIGNALLT_VALUE: return INTSIGNALLT;
			case STRINGSIGNALCONCAT_VALUE: return STRINGSIGNALCONCAT;
			case INTSIGNALEQ_VALUE: return INTSIGNALEQ;
			case STRINGSIGNALEQ_VALUE: return STRINGSIGNALEQ;
			case PURESIGNALEQ_VALUE: return PURESIGNALEQ;
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
	private CombinationOperator(int value, String name, String literal) {
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
	
} //CombinationOperator
