/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>PORT TYPE</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKPortType()
 * @model
 * @generated
 */
public enum KPortType implements Enumerator {
	/**
     * The '<em><b>DEFAULT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #DEFAULT_VALUE
     * @generated
     * @ordered
     */
	DEFAULT(0, "DEFAULT", "Default"),

	/**
     * The '<em><b>INPUT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #INPUT_VALUE
     * @generated
     * @ordered
     */
	INPUT(1, "INPUT", "Input"),

	/**
     * The '<em><b>OUTPUT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OUTPUT_VALUE
     * @generated
     * @ordered
     */
	OUTPUT(2, "OUTPUT", "Output");

	/**
     * The '<em><b>DEFAULT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEFAULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #DEFAULT
     * @model literal="Default"
     * @generated
     * @ordered
     */
	public static final int DEFAULT_VALUE = 0;

	/**
     * The '<em><b>INPUT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INPUT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #INPUT
     * @model literal="Input"
     * @generated
     * @ordered
     */
	public static final int INPUT_VALUE = 1;

	/**
     * The '<em><b>OUTPUT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OUTPUT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OUTPUT
     * @model literal="Output"
     * @generated
     * @ordered
     */
	public static final int OUTPUT_VALUE = 2;

	/**
     * An array of all the '<em><b>KPort Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final KPortType[] VALUES_ARRAY =
		new KPortType[] {
            DEFAULT,
            INPUT,
            OUTPUT,
        };

	/**
     * A public read-only list of all the '<em><b>KPort Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<KPortType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>KPort Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KPortType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            KPortType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>KPort Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KPortType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            KPortType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>KPort Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KPortType get(int value) {
        switch (value) {
            case DEFAULT_VALUE: return DEFAULT;
            case INPUT_VALUE: return INPUT;
            case OUTPUT_VALUE: return OUTPUT;
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
	private KPortType(int value, String name, String literal) {
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
	
} //KPortType
