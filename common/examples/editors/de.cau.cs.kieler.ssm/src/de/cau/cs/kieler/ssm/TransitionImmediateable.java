/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.ssm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Immediateable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.ssm.TransitionImmediateable#isIsImmediate <em>Is Immediate</em>}</li>
 *   <li>{@link de.cau.cs.kieler.ssm.TransitionImmediateable#getIsImmediateString <em>Is Immediate String</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.ssm.ssmPackage#getTransitionImmediateable()
 * @model
 * @generated
 */
public interface TransitionImmediateable extends EObject {
	/**
	 * Returns the value of the '<em><b>Is Immediate</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Immediate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Immediate</em>' attribute.
	 * @see #setIsImmediate(boolean)
	 * @see de.cau.cs.kieler.ssm.ssmPackage#getTransitionImmediateable_IsImmediate()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsImmediate();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.ssm.TransitionImmediateable#isIsImmediate <em>Is Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Immediate</em>' attribute.
	 * @see #isIsImmediate()
	 * @generated
	 */
	void setIsImmediate(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Immediate String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Immediate String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Immediate String</em>' attribute.
	 * @see #setIsImmediateString(String)
	 * @see de.cau.cs.kieler.ssm.ssmPackage#getTransitionImmediateable_IsImmediateString()
	 * @model
	 * @generated
	 */
	String getIsImmediateString();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.ssm.TransitionImmediateable#getIsImmediateString <em>Is Immediate String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Immediate String</em>' attribute.
	 * @see #getIsImmediateString()
	 * @generated
	 */
	void setIsImmediateString(String value);

} // TransitionImmediateable
