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
 * A representation of the literals of the enumeration '<em><b>NODE LABEL PLACEMENT</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeLabelPlacement()
 * @model
 * @generated
 */
public enum KNodeLabelPlacement implements Enumerator {
	/**
     * The '<em><b>DEFAULT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #DEFAULT_VALUE
     * @generated
     * @ordered
     */
	DEFAULT(0, "DEFAULT", "DEFAULT"),

	/**
     * The '<em><b>INSIDE NORTH</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #INSIDE_NORTH_VALUE
     * @generated
     * @ordered
     */
	INSIDE_NORTH(1, "INSIDE_NORTH", "INSIDE_NORTH"),

	/**
     * The '<em><b>INSIDE SOUTH</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #INSIDE_SOUTH_VALUE
     * @generated
     * @ordered
     */
	INSIDE_SOUTH(2, "INSIDE_SOUTH", "INSIDE_SOUTH"),

	/**
     * The '<em><b>INSIDE WEST</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #INSIDE_WEST_VALUE
     * @generated
     * @ordered
     */
	INSIDE_WEST(3, "INSIDE_WEST", "INSIDE_WEST"),

	/**
     * The '<em><b>INSIDE EAST</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #INSIDE_EAST_VALUE
     * @generated
     * @ordered
     */
	INSIDE_EAST(4, "INSIDE_EAST", "INSIDE_EAST"),

	/**
     * The '<em><b>OUTSIDE NORTH</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OUTSIDE_NORTH_VALUE
     * @generated
     * @ordered
     */
	OUTSIDE_NORTH(5, "OUTSIDE_NORTH", "OUTSIDE_NORTH"),

	/**
     * The '<em><b>OUTSIDE SOUTH</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OUTSIDE_SOUTH_VALUE
     * @generated
     * @ordered
     */
	OUTSIDE_SOUTH(6, "OUTSIDE_SOUTH", "OUTSIDE_SOUTH"),

	/**
     * The '<em><b>OUTSIDE WEST</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OUTSIDE_WEST_VALUE
     * @generated
     * @ordered
     */
	OUTSIDE_WEST(7, "OUTSIDE_WEST", "OUTSIDE_WEST"),

	/**
     * The '<em><b>OUTSIDE EAST</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OUTSIDE_EAST_VALUE
     * @generated
     * @ordered
     */
	OUTSIDE_EAST(8, "OUTSIDE_EAST", "OUTSIDE_EAST");

	/**
     * The '<em><b>DEFAULT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEFAULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #DEFAULT
     * @model
     * @generated
     * @ordered
     */
	public static final int DEFAULT_VALUE = 0;

	/**
     * The '<em><b>INSIDE NORTH</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INSIDE NORTH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #INSIDE_NORTH
     * @model
     * @generated
     * @ordered
     */
	public static final int INSIDE_NORTH_VALUE = 1;

	/**
     * The '<em><b>INSIDE SOUTH</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INSIDE SOUTH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #INSIDE_SOUTH
     * @model
     * @generated
     * @ordered
     */
	public static final int INSIDE_SOUTH_VALUE = 2;

	/**
     * The '<em><b>INSIDE WEST</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INSIDE WEST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #INSIDE_WEST
     * @model
     * @generated
     * @ordered
     */
	public static final int INSIDE_WEST_VALUE = 3;

	/**
     * The '<em><b>INSIDE EAST</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INSIDE EAST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #INSIDE_EAST
     * @model
     * @generated
     * @ordered
     */
	public static final int INSIDE_EAST_VALUE = 4;

	/**
     * The '<em><b>OUTSIDE NORTH</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OUTSIDE NORTH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OUTSIDE_NORTH
     * @model
     * @generated
     * @ordered
     */
	public static final int OUTSIDE_NORTH_VALUE = 5;

	/**
     * The '<em><b>OUTSIDE SOUTH</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OUTSIDE SOUTH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OUTSIDE_SOUTH
     * @model
     * @generated
     * @ordered
     */
	public static final int OUTSIDE_SOUTH_VALUE = 6;

	/**
     * The '<em><b>OUTSIDE WEST</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OUTSIDE WEST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OUTSIDE_WEST
     * @model
     * @generated
     * @ordered
     */
	public static final int OUTSIDE_WEST_VALUE = 7;

	/**
     * The '<em><b>OUTSIDE EAST</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OUTSIDE EAST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OUTSIDE_EAST
     * @model
     * @generated
     * @ordered
     */
	public static final int OUTSIDE_EAST_VALUE = 8;

	/**
     * An array of all the '<em><b>KNode Label Placement</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final KNodeLabelPlacement[] VALUES_ARRAY =
		new KNodeLabelPlacement[] {
            DEFAULT,
            INSIDE_NORTH,
            INSIDE_SOUTH,
            INSIDE_WEST,
            INSIDE_EAST,
            OUTSIDE_NORTH,
            OUTSIDE_SOUTH,
            OUTSIDE_WEST,
            OUTSIDE_EAST,
        };

	/**
     * A public read-only list of all the '<em><b>KNode Label Placement</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<KNodeLabelPlacement> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>KNode Label Placement</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KNodeLabelPlacement get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            KNodeLabelPlacement result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>KNode Label Placement</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KNodeLabelPlacement getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            KNodeLabelPlacement result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>KNode Label Placement</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KNodeLabelPlacement get(int value) {
        switch (value) {
            case DEFAULT_VALUE: return DEFAULT;
            case INSIDE_NORTH_VALUE: return INSIDE_NORTH;
            case INSIDE_SOUTH_VALUE: return INSIDE_SOUTH;
            case INSIDE_WEST_VALUE: return INSIDE_WEST;
            case INSIDE_EAST_VALUE: return INSIDE_EAST;
            case OUTSIDE_NORTH_VALUE: return OUTSIDE_NORTH;
            case OUTSIDE_SOUTH_VALUE: return OUTSIDE_SOUTH;
            case OUTSIDE_WEST_VALUE: return OUTSIDE_WEST;
            case OUTSIDE_EAST_VALUE: return OUTSIDE_EAST;
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
	private KNodeLabelPlacement(int value, String name, String literal) {
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
	
} //KNodeLabelPlacement
