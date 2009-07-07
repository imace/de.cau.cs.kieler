/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.synccharts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Operator Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getOperatorKind()
 * @model
 * @generated
 */
public enum OperatorKind implements Enumerator {
	/**
     * The '<em><b>NOT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #NOT_VALUE
     * @generated
     * @ordered
     */
	NOT(0, "NOT", "NOT"),

	/**
     * The '<em><b>EQ</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #EQ_VALUE
     * @generated
     * @ordered
     */
	EQ(1, "EQ", "EQ"),

	/**
     * The '<em><b>LT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #LT_VALUE
     * @generated
     * @ordered
     */
	LT(2, "LT", "LT"),

	/**
     * The '<em><b>LEQ</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #LEQ_VALUE
     * @generated
     * @ordered
     */
	LEQ(3, "LEQ", "LEQ"),

	/**
     * The '<em><b>AND</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #AND_VALUE
     * @generated
     * @ordered
     */
	AND(4, "AND", "AND"),

	/**
     * The '<em><b>OR</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OR_VALUE
     * @generated
     * @ordered
     */
	OR(5, "OR", "OR"),

	/**
     * The '<em><b>ADD</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #ADD_VALUE
     * @generated
     * @ordered
     */
	ADD(6, "ADD", "ADD"),

	/**
     * The '<em><b>SUB</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #SUB_VALUE
     * @generated
     * @ordered
     */
	SUB(7, "SUB", "SUB"),

	/**
     * The '<em><b>MULT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #MULT_VALUE
     * @generated
     * @ordered
     */
	MULT(8, "MULT", "MULT"),

	/**
     * The '<em><b>DIV</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #DIV_VALUE
     * @generated
     * @ordered
     */
	DIV(9, "DIV", "DIV"),

	/**
     * The '<em><b>VAL</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #VAL_VALUE
     * @generated
     * @ordered
     */
	VAL(0, "VAL", "VAL");

	/**
     * The '<em><b>NOT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #NOT
     * @model
     * @generated
     * @ordered
     */
	public static final int NOT_VALUE = 0;

	/**
     * The '<em><b>EQ</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQ</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #EQ
     * @model
     * @generated
     * @ordered
     */
	public static final int EQ_VALUE = 1;

	/**
     * The '<em><b>LT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #LT
     * @model
     * @generated
     * @ordered
     */
	public static final int LT_VALUE = 2;

	/**
     * The '<em><b>LEQ</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LEQ</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #LEQ
     * @model
     * @generated
     * @ordered
     */
	public static final int LEQ_VALUE = 3;

	/**
     * The '<em><b>AND</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #AND
     * @model
     * @generated
     * @ordered
     */
	public static final int AND_VALUE = 4;

	/**
     * The '<em><b>OR</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OR
     * @model
     * @generated
     * @ordered
     */
	public static final int OR_VALUE = 5;

	/**
     * The '<em><b>ADD</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #ADD
     * @model
     * @generated
     * @ordered
     */
	public static final int ADD_VALUE = 6;

	/**
     * The '<em><b>SUB</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #SUB
     * @model
     * @generated
     * @ordered
     */
	public static final int SUB_VALUE = 7;

	/**
     * The '<em><b>MULT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #MULT
     * @model
     * @generated
     * @ordered
     */
	public static final int MULT_VALUE = 8;

	/**
     * The '<em><b>DIV</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #DIV
     * @model
     * @generated
     * @ordered
     */
	public static final int DIV_VALUE = 9;

	/**
     * The '<em><b>VAL</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #VAL
     * @model
     * @generated
     * @ordered
     */
	public static final int VAL_VALUE = 0;

	/**
     * An array of all the '<em><b>Operator Kind</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final OperatorKind[] VALUES_ARRAY =
		new OperatorKind[] {
            NOT,
            EQ,
            LT,
            LEQ,
            AND,
            OR,
            ADD,
            SUB,
            MULT,
            DIV,
            VAL,
        };

	/**
     * A public read-only list of all the '<em><b>Operator Kind</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<OperatorKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Operator Kind</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static OperatorKind get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            OperatorKind result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Operator Kind</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static OperatorKind getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            OperatorKind result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Operator Kind</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static OperatorKind get(int value) {
        switch (value) {
            case NOT_VALUE: return NOT;
            case EQ_VALUE: return EQ;
            case LT_VALUE: return LT;
            case LEQ_VALUE: return LEQ;
            case AND_VALUE: return AND;
            case OR_VALUE: return OR;
            case ADD_VALUE: return ADD;
            case SUB_VALUE: return SUB;
            case MULT_VALUE: return MULT;
            case DIV_VALUE: return DIV;
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
	private OperatorKind(int value, String name, String literal) {
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
	
} //OperatorKind
