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
 * A representation of the literals of the enumeration '<em><b>EDGE TYPE</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeType()
 * @model
 * @generated
 */
public enum KEdgeType implements Enumerator {
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
     * The '<em><b>DIRECT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #DIRECT_VALUE
     * @generated
     * @ordered
     */
	DIRECT(1, "DIRECT", "Direct"),

	/**
     * The '<em><b>SPLINE</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #SPLINE_VALUE
     * @generated
     * @ordered
     */
	SPLINE(2, "SPLINE", "Spline"),

	/**
     * The '<em><b>BEZIER</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #BEZIER_VALUE
     * @generated
     * @ordered
     */
	BEZIER(3, "BEZIER", "Bezier"), /**
     * The '<em><b>RECTILINEAR</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #RECTILINEAR_VALUE
     * @generated
     * @ordered
     */
	RECTILINEAR(4, "RECTILINEAR", "Rectilinear");

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
     * The '<em><b>DIRECT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #DIRECT
     * @model literal="Direct"
     * @generated
     * @ordered
     */
	public static final int DIRECT_VALUE = 1;

	/**
     * The '<em><b>SPLINE</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPLINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #SPLINE
     * @model literal="Spline"
     * @generated
     * @ordered
     */
	public static final int SPLINE_VALUE = 2;

	/**
     * The '<em><b>BEZIER</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BEZIER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #BEZIER
     * @model literal="Bezier"
     * @generated
     * @ordered
     */
	public static final int BEZIER_VALUE = 3;

	/**
     * The '<em><b>RECTILINEAR</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RECTILINEAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #RECTILINEAR
     * @model literal="Rectilinear"
     * @generated
     * @ordered
     */
	public static final int RECTILINEAR_VALUE = 4;

	/**
     * An array of all the '<em><b>KEdge Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final KEdgeType[] VALUES_ARRAY =
		new KEdgeType[] {
            DEFAULT,
            DIRECT,
            SPLINE,
            BEZIER,
            RECTILINEAR,
        };

	/**
     * A public read-only list of all the '<em><b>KEdge Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<KEdgeType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>KEdge Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KEdgeType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            KEdgeType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>KEdge Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KEdgeType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            KEdgeType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>KEdge Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KEdgeType get(int value) {
        switch (value) {
            case DEFAULT_VALUE: return DEFAULT;
            case DIRECT_VALUE: return DIRECT;
            case SPLINE_VALUE: return SPLINE;
            case BEZIER_VALUE: return BEZIER;
            case RECTILINEAR_VALUE: return RECTILINEAR;
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
	private KEdgeType(int value, String name, String literal) {
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
	
} //KEdgeType
