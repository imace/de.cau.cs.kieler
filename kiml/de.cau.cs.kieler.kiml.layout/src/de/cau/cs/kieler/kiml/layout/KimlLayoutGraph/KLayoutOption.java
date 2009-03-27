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
 * A representation of the literals of the enumeration '<em><b>LAYOUT OPTION</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKLayoutOption()
 * @model
 * @generated
 */
public enum KLayoutOption implements Enumerator {
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
     * The '<em><b>PRESERVE MENTAL MAP</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #PRESERVE_MENTAL_MAP_VALUE
     * @generated
     * @ordered
     */
	PRESERVE_MENTAL_MAP(1, "PRESERVE_MENTAL_MAP", "Preserve mental map"), /**
     * The '<em><b>VERTICAL</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #VERTICAL_VALUE
     * @generated
     * @ordered
     */
	VERTICAL(2, "VERTICAL", "Vertical"), /**
     * The '<em><b>HORIZONTAL</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #HORIZONTAL_VALUE
     * @generated
     * @ordered
     */
	HORIZONTAL(3, "HORIZONTAL", "Horizontal"), /**
     * The '<em><b>FIXED PORTS</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #FIXED_PORTS_VALUE
     * @generated
     * @ordered
     */
	FIXED_PORTS(4, "FIXED_PORTS", "Fixed ports"), /**
     * The '<em><b>FIXED PORT SIDES</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #FIXED_PORT_SIDES_VALUE
     * @generated
     * @ordered
     */
	FIXED_PORT_SIDES(5, "FIXED_PORT_SIDES", "Fixed port sides"), /**
     * The '<em><b>FIXED SIZE</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #FIXED_SIZE_VALUE
     * @generated
     * @ordered
     */
	FIXED_SIZE(6, "FIXED_SIZE", "Fixed size");

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
     * The '<em><b>PRESERVE MENTAL MAP</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRESERVE MENTAL MAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #PRESERVE_MENTAL_MAP
     * @model literal="Preserve mental map"
     * @generated
     * @ordered
     */
	public static final int PRESERVE_MENTAL_MAP_VALUE = 1;

	/**
     * The '<em><b>VERTICAL</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VERTICAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #VERTICAL
     * @model literal="Vertical"
     * @generated
     * @ordered
     */
	public static final int VERTICAL_VALUE = 2;

	/**
     * The '<em><b>HORIZONTAL</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HORIZONTAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #HORIZONTAL
     * @model literal="Horizontal"
     * @generated
     * @ordered
     */
	public static final int HORIZONTAL_VALUE = 3;

	/**
     * The '<em><b>FIXED PORTS</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIXED PORTS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #FIXED_PORTS
     * @model literal="Fixed ports"
     * @generated
     * @ordered
     */
	public static final int FIXED_PORTS_VALUE = 4;

	/**
     * The '<em><b>FIXED PORT SIDES</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIXED PORT SIDES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #FIXED_PORT_SIDES
     * @model literal="Fixed port sides"
     * @generated
     * @ordered
     */
	public static final int FIXED_PORT_SIDES_VALUE = 5;

	/**
     * The '<em><b>FIXED SIZE</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIXED SIZE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #FIXED_SIZE
     * @model literal="Fixed size"
     * @generated
     * @ordered
     */
	public static final int FIXED_SIZE_VALUE = 6;

	/**
     * An array of all the '<em><b>KLayout Option</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final KLayoutOption[] VALUES_ARRAY =
		new KLayoutOption[] {
            DEFAULT,
            PRESERVE_MENTAL_MAP,
            VERTICAL,
            HORIZONTAL,
            FIXED_PORTS,
            FIXED_PORT_SIDES,
            FIXED_SIZE,
        };

	/**
     * A public read-only list of all the '<em><b>KLayout Option</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<KLayoutOption> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>KLayout Option</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KLayoutOption get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            KLayoutOption result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>KLayout Option</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KLayoutOption getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            KLayoutOption result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>KLayout Option</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static KLayoutOption get(int value) {
        switch (value) {
            case DEFAULT_VALUE: return DEFAULT;
            case PRESERVE_MENTAL_MAP_VALUE: return PRESERVE_MENTAL_MAP;
            case VERTICAL_VALUE: return VERTICAL;
            case HORIZONTAL_VALUE: return HORIZONTAL;
            case FIXED_PORTS_VALUE: return FIXED_PORTS;
            case FIXED_PORT_SIDES_VALUE: return FIXED_PORT_SIDES;
            case FIXED_SIZE_VALUE: return FIXED_SIZE;
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
	private KLayoutOption(int value, String name, String literal) {
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
	
} //KLayoutOption
