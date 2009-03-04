/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm2;

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
 *   <li>{@link ssm2.Action#getEmissions <em>Emissions</em>}</li>
 *   <li>{@link ssm2.Action#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link ssm2.Action#getParentStateEntryAction <em>Parent State Entry Action</em>}</li>
 *   <li>{@link ssm2.Action#getParentStateInnerAction <em>Parent State Inner Action</em>}</li>
 *   <li>{@link ssm2.Action#getParentStateExitAction <em>Parent State Exit Action</em>}</li>
 *   <li>{@link ssm2.Action#getAssignments <em>Assignments</em>}</li>
 * </ul>
 * </p>
 *
 * @see ssm2.Ssm2Package#getAction()
 * @model
 * @generated
 */
public interface Action extends EObject {
	/**
	 * Returns the value of the '<em><b>Emissions</b></em>' containment reference list.
	 * The list contents are of type {@link ssm2.Emission}.
	 * It is bidirectional and its opposite is '{@link ssm2.Emission#getParentAction <em>Parent Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Emissions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Emissions</em>' containment reference list.
	 * @see ssm2.Ssm2Package#getAction_Emissions()
	 * @see ssm2.Emission#getParentAction
	 * @model opposite="parentAction" containment="true"
	 * @generated
	 */
	EList<Emission> getEmissions();

	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link ssm2.Expression#getParentAction <em>Parent Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' containment reference.
	 * @see #setTrigger(Expression)
	 * @see ssm2.Ssm2Package#getAction_Trigger()
	 * @see ssm2.Expression#getParentAction
	 * @model opposite="parentAction" containment="true"
	 * @generated
	 */
	Expression getTrigger();

	/**
	 * Sets the value of the '{@link ssm2.Action#getTrigger <em>Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' containment reference.
	 * @see #getTrigger()
	 * @generated
	 */
	void setTrigger(Expression value);

	/**
	 * Returns the value of the '<em><b>Parent State Entry Action</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm2.State#getEntryActions <em>Entry Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent State Entry Action</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent State Entry Action</em>' container reference.
	 * @see #setParentStateEntryAction(State)
	 * @see ssm2.Ssm2Package#getAction_ParentStateEntryAction()
	 * @see ssm2.State#getEntryActions
	 * @model opposite="entryActions" transient="false"
	 * @generated
	 */
	State getParentStateEntryAction();

	/**
	 * Sets the value of the '{@link ssm2.Action#getParentStateEntryAction <em>Parent State Entry Action</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent State Entry Action</em>' container reference.
	 * @see #getParentStateEntryAction()
	 * @generated
	 */
	void setParentStateEntryAction(State value);

	/**
	 * Returns the value of the '<em><b>Parent State Inner Action</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm2.State#getInnerActions <em>Inner Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent State Inner Action</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent State Inner Action</em>' container reference.
	 * @see #setParentStateInnerAction(State)
	 * @see ssm2.Ssm2Package#getAction_ParentStateInnerAction()
	 * @see ssm2.State#getInnerActions
	 * @model opposite="innerActions" transient="false"
	 * @generated
	 */
	State getParentStateInnerAction();

	/**
	 * Sets the value of the '{@link ssm2.Action#getParentStateInnerAction <em>Parent State Inner Action</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent State Inner Action</em>' container reference.
	 * @see #getParentStateInnerAction()
	 * @generated
	 */
	void setParentStateInnerAction(State value);

	/**
	 * Returns the value of the '<em><b>Parent State Exit Action</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm2.State#getExitActions <em>Exit Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent State Exit Action</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent State Exit Action</em>' container reference.
	 * @see #setParentStateExitAction(State)
	 * @see ssm2.Ssm2Package#getAction_ParentStateExitAction()
	 * @see ssm2.State#getExitActions
	 * @model opposite="exitActions" transient="false"
	 * @generated
	 */
	State getParentStateExitAction();

	/**
	 * Sets the value of the '{@link ssm2.Action#getParentStateExitAction <em>Parent State Exit Action</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent State Exit Action</em>' container reference.
	 * @see #getParentStateExitAction()
	 * @generated
	 */
	void setParentStateExitAction(State value);

	/**
	 * Returns the value of the '<em><b>Assignments</b></em>' containment reference list.
	 * The list contents are of type {@link ssm2.Assignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignments</em>' containment reference list.
	 * @see ssm2.Ssm2Package#getAction_Assignments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Assignment> getAssignments();

} // Action
