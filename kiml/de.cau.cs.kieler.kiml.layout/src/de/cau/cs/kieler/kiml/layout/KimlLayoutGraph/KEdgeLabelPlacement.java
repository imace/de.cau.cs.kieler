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
 * A representation of the literals of the enumeration '<em><b>EDGE LABEL PLACEMENT</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLabelPlacement()
 * @model
 * @generated
 */
public enum KEdgeLabelPlacement implements Enumerator {
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
     * The '<em><b>CENTER</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #CENTER_VALUE
     * @generated
     * @ordered
     */
	CENTER(1, "CENTER", "CENTER"),

	/**
     * The '<em><b>HEAD</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #HEAD_VALUE
     * @generated
     * @ordered
     */
	HEAD(2, "HEAD", "HEAD"),

	/**
     * The '<em><b>TAIL</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #TAIL_VALUE
     * @generated
     * @ordered
     */
	TAIL(4, "TAIL", "TAIL"),

	/**
     * The '<em><b>LEFT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #LEFT_VALUE
     * @generated
     * @ordered
     */
	LEFT(8, "LEFT", "LEFT"),

	/**
     * The '<em><b>RIGHT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #RIGHT_VALUE
     * @generated
     * @ordered
     */
	RIGHT(16, "RIGHT", "RIGHT");

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
     * The '<em><b>CENTER</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CENTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #CENTER
     * @model
     * @generated
     * @ordered
     */
	public static final int CENTER_VALUE = 1;

	/**
     * The '<em><b>HEAD</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HEAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #HEAD
     * @model
     * @generated
     * @ordered
     */
	public static final int HEAD_VALUE = 2;

	/**
     * The '<em><b>TAIL</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TAIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #TAIL
     * @model
     * @generated
     * @ordered
     */
	public static final int TAIL_VALUE = 4;

	/**
     * The '<em><b>LEFT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LEFT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #LEFT
     * @model
     * @generated
     * @ordered
     */
	public static final int LEFT_VALUE = 8;

	/**
     * The '<em><b>RIGHT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #RIGHT
     * @model
     * @generated
     * @ordered
     */
	public static final int RIGHT_VALUE = 16;

	/**
     * An array of all the '<em><b>KEdge Label Placement</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final KEdgeLabelPlacement[] VALUES_ARRAY =
		new KEdgeLabelPlacement[] {
            DEFAULT,
            CENTER,
            HEAD,
            TAIL,
            LEFT,
            RIGHT,
        };

	/**
     * A public read-only list of all the '<em><b>KEdge Label Placement</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<KEdgeLabelPlacement> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>KEdge Label Placement</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KEdgeLabelPlacement get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            KEdgeLabelPlacement result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>KEdge Label Placement</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KEdgeLabelPlacement getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            KEdgeLabelPlacement result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>KEdge Label Placement</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KEdgeLabelPlacement get(int value) {
        switch (value) {
            case DEFAULT_VALUE: return DEFAULT;
            case CENTER_VALUE: return CENTER;
            case HEAD_VALUE: return HEAD;
            case TAIL_VALUE: return TAIL;
            case LEFT_VALUE: return LEFT;
            case RIGHT_VALUE: return RIGHT;
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
	private KEdgeLabelPlacement(int value, String name, String literal) {
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
	
} //KEdgeLabelPlacement
