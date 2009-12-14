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
 * A representation of the literals of the enumeration '<em><b>Segment Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getSegmentType()
 * @model
 * @generated
 */
public enum SegmentType implements Enumerator {
	/**
	 * The '<em><b>Local Host</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOCAL_HOST_VALUE
	 * @generated
	 * @ordered
	 */
	LOCAL_HOST(0, "LocalHost", "LocalHost"),

	/**
	 * The '<em><b>Local Bus</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOCAL_BUS_VALUE
	 * @generated
	 * @ordered
	 */
	LOCAL_BUS(1, "LocalBus", "LocalBus"),

	/**
	 * The '<em><b>Ethernet</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETHERNET_VALUE
	 * @generated
	 * @ordered
	 */
	ETHERNET(2, "Ethernet", "Ethernet"),

	/**
	 * The '<em><b>Device Net</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEVICE_NET_VALUE
	 * @generated
	 * @ordered
	 */
	DEVICE_NET(3, "DeviceNet", "DeviceNet"),

	/**
	 * The '<em><b>Control Net</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTROL_NET_VALUE
	 * @generated
	 * @ordered
	 */
	CONTROL_NET(4, "ControlNet", "ControlNet");

	/**
	 * The '<em><b>Local Host</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Local Host</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOCAL_HOST
	 * @model name="LocalHost"
	 * @generated
	 * @ordered
	 */
	public static final int LOCAL_HOST_VALUE = 0;

	/**
	 * The '<em><b>Local Bus</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Local Bus</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOCAL_BUS
	 * @model name="LocalBus"
	 * @generated
	 * @ordered
	 */
	public static final int LOCAL_BUS_VALUE = 1;

	/**
	 * The '<em><b>Ethernet</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ethernet</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ETHERNET
	 * @model name="Ethernet"
	 * @generated
	 * @ordered
	 */
	public static final int ETHERNET_VALUE = 2;

	/**
	 * The '<em><b>Device Net</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Device Net</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEVICE_NET
	 * @model name="DeviceNet"
	 * @generated
	 * @ordered
	 */
	public static final int DEVICE_NET_VALUE = 3;

	/**
	 * The '<em><b>Control Net</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Control Net</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTROL_NET
	 * @model name="ControlNet"
	 * @generated
	 * @ordered
	 */
	public static final int CONTROL_NET_VALUE = 4;

	/**
	 * An array of all the '<em><b>Segment Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SegmentType[] VALUES_ARRAY =
		new SegmentType[] {
			LOCAL_HOST,
			LOCAL_BUS,
			ETHERNET,
			DEVICE_NET,
			CONTROL_NET,
		};

	/**
	 * A public read-only list of all the '<em><b>Segment Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SegmentType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Segment Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SegmentType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SegmentType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Segment Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SegmentType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SegmentType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Segment Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SegmentType get(int value) {
		switch (value) {
			case LOCAL_HOST_VALUE: return LOCAL_HOST;
			case LOCAL_BUS_VALUE: return LOCAL_BUS;
			case ETHERNET_VALUE: return ETHERNET;
			case DEVICE_NET_VALUE: return DEVICE_NET;
			case CONTROL_NET_VALUE: return CONTROL_NET;
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
	private SegmentType(int value, String name, String literal) {
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
	
} //SegmentType
