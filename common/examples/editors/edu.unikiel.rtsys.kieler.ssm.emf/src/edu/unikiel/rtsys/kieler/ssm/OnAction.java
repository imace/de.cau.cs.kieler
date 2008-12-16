/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>On Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.OnAction#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.OnAction#getEffect <em>Effect</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getOnAction()
 * @model
 * @generated
 */
public interface OnAction extends EObject {
    /**
	 * Returns the value of the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Trigger</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' reference.
	 * @see #setTrigger(Trigger)
	 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getOnAction_Trigger()
	 * @model
	 * @generated
	 */
    Trigger getTrigger();

    /**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.ssm.OnAction#getTrigger <em>Trigger</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' reference.
	 * @see #getTrigger()
	 * @generated
	 */
    void setTrigger(Trigger value);

    /**
	 * Returns the value of the '<em><b>Effect</b></em>' reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.kieler.ssm.Action}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Effect</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Effect</em>' reference list.
	 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getOnAction_Effect()
	 * @model
	 * @generated
	 */
    EList<Action> getEffect();

} // OnAction
