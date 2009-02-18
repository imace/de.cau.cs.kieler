/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ssm.Trigger#getSubTriggers <em>Sub Triggers</em>}</li>
 *   <li>{@link ssm.Trigger#getLiterals <em>Literals</em>}</li>
 *   <li>{@link ssm.Trigger#getOperator <em>Operator</em>}</li>
 *   <li>{@link ssm.Trigger#getParentTrigger <em>Parent Trigger</em>}</li>
 *   <li>{@link ssm.Trigger#getParentAction <em>Parent Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see ssm.ssmPackage#getTrigger()
 * @model
 * @generated
 */
public interface Trigger extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub Triggers</b></em>' containment reference list.
	 * The list contents are of type {@link ssm.Trigger}.
	 * It is bidirectional and its opposite is '{@link ssm.Trigger#getParentTrigger <em>Parent Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Triggers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Triggers</em>' containment reference list.
	 * @see ssm.ssmPackage#getTrigger_SubTriggers()
	 * @see ssm.Trigger#getParentTrigger
	 * @model opposite="parentTrigger" containment="true"
	 * @generated
	 */
	EList<Trigger> getSubTriggers();

	/**
	 * Returns the value of the '<em><b>Literals</b></em>' reference list.
	 * The list contents are of type {@link ssm.Signal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' reference list.
	 * @see ssm.ssmPackage#getTrigger_Literals()
	 * @model required="true"
	 * @generated
	 */
	EList<Signal> getLiterals();

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link ssm.Operator#getParentTrigger <em>Parent Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' containment reference.
	 * @see #setOperator(Operator)
	 * @see ssm.ssmPackage#getTrigger_Operator()
	 * @see ssm.Operator#getParentTrigger
	 * @model opposite="parentTrigger" containment="true"
	 * @generated
	 */
	Operator getOperator();

	/**
	 * Sets the value of the '{@link ssm.Trigger#getOperator <em>Operator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' containment reference.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(Operator value);

	/**
	 * Returns the value of the '<em><b>Parent Trigger</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm.Trigger#getSubTriggers <em>Sub Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Trigger</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Trigger</em>' container reference.
	 * @see #setParentTrigger(Trigger)
	 * @see ssm.ssmPackage#getTrigger_ParentTrigger()
	 * @see ssm.Trigger#getSubTriggers
	 * @model opposite="subTriggers" transient="false"
	 * @generated
	 */
	Trigger getParentTrigger();

	/**
	 * Sets the value of the '{@link ssm.Trigger#getParentTrigger <em>Parent Trigger</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Trigger</em>' container reference.
	 * @see #getParentTrigger()
	 * @generated
	 */
	void setParentTrigger(Trigger value);

	/**
	 * Returns the value of the '<em><b>Parent Action</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm.Action#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Action</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Action</em>' container reference.
	 * @see #setParentAction(Action)
	 * @see ssm.ssmPackage#getTrigger_ParentAction()
	 * @see ssm.Action#getTrigger
	 * @model opposite="trigger" transient="false"
	 * @generated
	 */
	Action getParentAction();

	/**
	 * Sets the value of the '{@link ssm.Trigger#getParentAction <em>Parent Action</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Action</em>' container reference.
	 * @see #getParentAction()
	 * @generated
	 */
	void setParentAction(Action value);

} // Trigger
