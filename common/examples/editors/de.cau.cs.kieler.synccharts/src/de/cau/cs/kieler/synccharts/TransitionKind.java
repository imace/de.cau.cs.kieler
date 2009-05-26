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
 * A representation of the literals of the enumeration '<em><b>Transition Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getTransitionKind()
 * @model
 * @generated
 */
public enum TransitionKind implements Enumerator {
	/**
	 * The '<em><b>STRONGABORT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRONGABORT_VALUE
	 * @generated
	 * @ordered
	 */
	STRONGABORT(0, "STRONGABORT", "STRONGABORT"),

	/**
	 * The '<em><b>WEAKABORT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEAKABORT_VALUE
	 * @generated
	 * @ordered
	 */
	WEAKABORT(1, "WEAKABORT", "WEAKABORT"),

	/**
	 * The '<em><b>NORMALTERMINATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NORMALTERMINATION_VALUE
	 * @generated
	 * @ordered
	 */
	NORMALTERMINATION(3, "NORMALTERMINATION", "NORMALTERMINATION");

	/**
	 * The '<em><b>STRONGABORT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRONGABORT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRONGABORT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRONGABORT_VALUE = 0;

	/**
	 * The '<em><b>WEAKABORT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WEAKABORT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WEAKABORT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WEAKABORT_VALUE = 1;

	/**
	 * The '<em><b>NORMALTERMINATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NORMALTERMINATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NORMALTERMINATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NORMALTERMINATION_VALUE = 3;

	/**
	 * An array of all the '<em><b>Transition Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TransitionKind[] VALUES_ARRAY =
		new TransitionKind[] {
			STRONGABORT,
			WEAKABORT,
			NORMALTERMINATION,
		};

	/**
	 * A public read-only list of all the '<em><b>Transition Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TransitionKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Transition Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransitionKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransitionKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transition Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransitionKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransitionKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transition Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransitionKind get(int value) {
		switch (value) {
			case STRONGABORT_VALUE: return STRONGABORT;
			case WEAKABORT_VALUE: return WEAKABORT;
			case NORMALTERMINATION_VALUE: return NORMALTERMINATION;
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
	private TransitionKind(int value, String name, String literal) {
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
	
} //TransitionKind
