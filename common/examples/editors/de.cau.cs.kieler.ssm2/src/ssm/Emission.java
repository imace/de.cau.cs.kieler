/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Emission</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ssm.Emission#getNewValue <em>New Value</em>}</li>
 *   <li>{@link ssm.Emission#getSignal <em>Signal</em>}</li>
 *   <li>{@link ssm.Emission#getParentAction <em>Parent Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see ssm.ssmPackage#getEmission()
 * @model
 * @generated
 */
public interface Emission extends EObject {
	/**
	 * Returns the value of the '<em><b>New Value</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link ssm.Value#getParentEmisson <em>Parent Emisson</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value</em>' containment reference.
	 * @see #setNewValue(Value)
	 * @see ssm.ssmPackage#getEmission_NewValue()
	 * @see ssm.Value#getParentEmisson
	 * @model opposite="parentEmisson" containment="true"
	 * @generated
	 */
	Value getNewValue();

	/**
	 * Sets the value of the '{@link ssm.Emission#getNewValue <em>New Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value</em>' containment reference.
	 * @see #getNewValue()
	 * @generated
	 */
	void setNewValue(Value value);

	/**
	 * Returns the value of the '<em><b>Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal</em>' reference.
	 * @see #setSignal(Signal)
	 * @see ssm.ssmPackage#getEmission_Signal()
	 * @model required="true"
	 * @generated
	 */
	Signal getSignal();

	/**
	 * Sets the value of the '{@link ssm.Emission#getSignal <em>Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signal</em>' reference.
	 * @see #getSignal()
	 * @generated
	 */
	void setSignal(Signal value);

	/**
	 * Returns the value of the '<em><b>Parent Action</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm.Action#getEffects <em>Effects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Action</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Action</em>' container reference.
	 * @see #setParentAction(Action)
	 * @see ssm.ssmPackage#getEmission_ParentAction()
	 * @see ssm.Action#getEffects
	 * @model opposite="effects" required="true" transient="false"
	 * @generated
	 */
	Action getParentAction();

	/**
	 * Sets the value of the '{@link ssm.Emission#getParentAction <em>Parent Action</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Action</em>' container reference.
	 * @see #getParentAction()
	 * @generated
	 */
	void setParentAction(Action value);

} // Emission
