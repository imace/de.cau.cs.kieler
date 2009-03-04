/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Emission</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ssm2.Emission#getNewValue <em>New Value</em>}</li>
 *   <li>{@link ssm2.Emission#getSignal <em>Signal</em>}</li>
 *   <li>{@link ssm2.Emission#getParentAction <em>Parent Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see ssm2.Ssm2Package#getEmission()
 * @model
 * @generated
 */
public interface Emission extends EObject {
	/**
	 * Returns the value of the '<em><b>New Value</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link ssm2.Expression#getParentEmisson <em>Parent Emisson</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value</em>' containment reference.
	 * @see #setNewValue(Expression)
	 * @see ssm2.Ssm2Package#getEmission_NewValue()
	 * @see ssm2.Expression#getParentEmisson
	 * @model opposite="parentEmisson" containment="true"
	 * @generated
	 */
	Expression getNewValue();

	/**
	 * Sets the value of the '{@link ssm2.Emission#getNewValue <em>New Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value</em>' containment reference.
	 * @see #getNewValue()
	 * @generated
	 */
	void setNewValue(Expression value);

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
	 * @see ssm2.Ssm2Package#getEmission_Signal()
	 * @model required="true"
	 * @generated
	 */
	Signal getSignal();

	/**
	 * Sets the value of the '{@link ssm2.Emission#getSignal <em>Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signal</em>' reference.
	 * @see #getSignal()
	 * @generated
	 */
	void setSignal(Signal value);

	/**
	 * Returns the value of the '<em><b>Parent Action</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm2.Action#getEmissions <em>Emissions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Action</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Action</em>' container reference.
	 * @see #setParentAction(Action)
	 * @see ssm2.Ssm2Package#getEmission_ParentAction()
	 * @see ssm2.Action#getEmissions
	 * @model opposite="emissions" required="true" transient="false"
	 * @generated
	 */
	Action getParentAction();

	/**
	 * Sets the value of the '{@link ssm2.Emission#getParentAction <em>Parent Action</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Action</em>' container reference.
	 * @see #getParentAction()
	 * @generated
	 */
	void setParentAction(Action value);

} // Emission
