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
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ssm.Action#getEffects <em>Effects</em>}</li>
 *   <li>{@link ssm.Action#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link ssm.Action#getParentStateEntryAction <em>Parent State Entry Action</em>}</li>
 *   <li>{@link ssm.Action#getParentStateInnerAction <em>Parent State Inner Action</em>}</li>
 *   <li>{@link ssm.Action#getParentStateExitAction <em>Parent State Exit Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see ssm.ssmPackage#getAction()
 * @model
 * @generated
 */
public interface Action extends EObject {
	/**
	 * Returns the value of the '<em><b>Effects</b></em>' containment reference list.
	 * The list contents are of type {@link ssm.Emission}.
	 * It is bidirectional and its opposite is '{@link ssm.Emission#getParentAction <em>Parent Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effects</em>' containment reference list.
	 * @see ssm.ssmPackage#getAction_Effects()
	 * @see ssm.Emission#getParentAction
	 * @model opposite="parentAction" containment="true"
	 * @generated
	 */
	EList<Emission> getEffects();

	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link ssm.Trigger#getParentAction <em>Parent Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' containment reference.
	 * @see #setTrigger(Trigger)
	 * @see ssm.ssmPackage#getAction_Trigger()
	 * @see ssm.Trigger#getParentAction
	 * @model opposite="parentAction" containment="true"
	 * @generated
	 */
	Trigger getTrigger();

	/**
	 * Sets the value of the '{@link ssm.Action#getTrigger <em>Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' containment reference.
	 * @see #getTrigger()
	 * @generated
	 */
	void setTrigger(Trigger value);

	/**
	 * Returns the value of the '<em><b>Parent State Entry Action</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm.State#getEntryActions <em>Entry Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent State Entry Action</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent State Entry Action</em>' container reference.
	 * @see #setParentStateEntryAction(State)
	 * @see ssm.ssmPackage#getAction_ParentStateEntryAction()
	 * @see ssm.State#getEntryActions
	 * @model opposite="entryActions" transient="false"
	 * @generated
	 */
	State getParentStateEntryAction();

	/**
	 * Sets the value of the '{@link ssm.Action#getParentStateEntryAction <em>Parent State Entry Action</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent State Entry Action</em>' container reference.
	 * @see #getParentStateEntryAction()
	 * @generated
	 */
	void setParentStateEntryAction(State value);

	/**
	 * Returns the value of the '<em><b>Parent State Inner Action</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm.State#getInnerActions <em>Inner Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent State Inner Action</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent State Inner Action</em>' container reference.
	 * @see #setParentStateInnerAction(State)
	 * @see ssm.ssmPackage#getAction_ParentStateInnerAction()
	 * @see ssm.State#getInnerActions
	 * @model opposite="innerActions" transient="false"
	 * @generated
	 */
	State getParentStateInnerAction();

	/**
	 * Sets the value of the '{@link ssm.Action#getParentStateInnerAction <em>Parent State Inner Action</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent State Inner Action</em>' container reference.
	 * @see #getParentStateInnerAction()
	 * @generated
	 */
	void setParentStateInnerAction(State value);

	/**
	 * Returns the value of the '<em><b>Parent State Exit Action</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm.State#getExitActions <em>Exit Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent State Exit Action</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent State Exit Action</em>' container reference.
	 * @see #setParentStateExitAction(State)
	 * @see ssm.ssmPackage#getAction_ParentStateExitAction()
	 * @see ssm.State#getExitActions
	 * @model opposite="exitActions" transient="false"
	 * @generated
	 */
	State getParentStateExitAction();

	/**
	 * Sets the value of the '{@link ssm.Action#getParentStateExitAction <em>Parent State Exit Action</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent State Exit Action</em>' container reference.
	 * @see #getParentStateExitAction()
	 * @generated
	 */
	void setParentStateExitAction(State value);

} // Action
