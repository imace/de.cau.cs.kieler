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
 * A representation of the model object '<em><b>Transition Triggerable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.ssm.TransitionTriggerable#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link de.cau.cs.kieler.ssm.TransitionTriggerable#getTriggerString <em>Trigger String</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.ssm.ssmPackage#getTransitionTriggerable()
 * @model
 * @generated
 */
public interface TransitionTriggerable extends EObject {
	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' containment reference.
	 * @see #setTrigger(Trigger)
	 * @see de.cau.cs.kieler.ssm.ssmPackage#getTransitionTriggerable_Trigger()
	 * @model containment="true" required="true" transient="true"
	 * @generated
	 */
	Trigger getTrigger();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.ssm.TransitionTriggerable#getTrigger <em>Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' containment reference.
	 * @see #getTrigger()
	 * @generated
	 */
	void setTrigger(Trigger value);

	/**
	 * Returns the value of the '<em><b>Trigger String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger String</em>' attribute.
	 * @see #setTriggerString(String)
	 * @see de.cau.cs.kieler.ssm.ssmPackage#getTransitionTriggerable_TriggerString()
	 * @model
	 * @generated
	 */
	String getTriggerString();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.ssm.TransitionTriggerable#getTriggerString <em>Trigger String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger String</em>' attribute.
	 * @see #getTriggerString()
	 * @generated
	 */
	void setTriggerString(String value);

} // TransitionTriggerable
