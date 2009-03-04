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
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ssm2.State#getStateKind <em>State Kind</em>}</li>
 *   <li>{@link ssm2.State#getStateFlag <em>State Flag</em>}</li>
 *   <li>{@link ssm2.State#getSignals <em>Signals</em>}</li>
 *   <li>{@link ssm2.State#getInnerStates <em>Inner States</em>}</li>
 *   <li>{@link ssm2.State#getEntryActions <em>Entry Actions</em>}</li>
 *   <li>{@link ssm2.State#getInnerActions <em>Inner Actions</em>}</li>
 *   <li>{@link ssm2.State#getExitActions <em>Exit Actions</em>}</li>
 *   <li>{@link ssm2.State#getSignalRenamings <em>Signal Renamings</em>}</li>
 *   <li>{@link ssm2.State#getSuspensionTrigger <em>Suspension Trigger</em>}</li>
 *   <li>{@link ssm2.State#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link ssm2.State#getName <em>Name</em>}</li>
 *   <li>{@link ssm2.State#getParentState <em>Parent State</em>}</li>
 *   <li>{@link ssm2.State#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see ssm2.Ssm2Package#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>State Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link ssm2.StateKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Kind</em>' attribute.
	 * @see ssm2.StateKind
	 * @see #setStateKind(StateKind)
	 * @see ssm2.Ssm2Package#getState_StateKind()
	 * @model required="true"
	 * @generated
	 */
	StateKind getStateKind();

	/**
	 * Sets the value of the '{@link ssm2.State#getStateKind <em>State Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Kind</em>' attribute.
	 * @see ssm2.StateKind
	 * @see #getStateKind()
	 * @generated
	 */
	void setStateKind(StateKind value);

	/**
	 * Returns the value of the '<em><b>State Flag</b></em>' attribute.
	 * The literals are from the enumeration {@link ssm2.StateFlag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Flag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Flag</em>' attribute.
	 * @see ssm2.StateFlag
	 * @see #setStateFlag(StateFlag)
	 * @see ssm2.Ssm2Package#getState_StateFlag()
	 * @model required="true"
	 * @generated
	 */
	StateFlag getStateFlag();

	/**
	 * Sets the value of the '{@link ssm2.State#getStateFlag <em>State Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Flag</em>' attribute.
	 * @see ssm2.StateFlag
	 * @see #getStateFlag()
	 * @generated
	 */
	void setStateFlag(StateFlag value);

	/**
	 * Returns the value of the '<em><b>Signals</b></em>' containment reference list.
	 * The list contents are of type {@link ssm2.Signal}.
	 * It is bidirectional and its opposite is '{@link ssm2.Signal#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signals</em>' containment reference list.
	 * @see ssm2.Ssm2Package#getState_Signals()
	 * @see ssm2.Signal#getParentState
	 * @model opposite="parentState" containment="true"
	 * @generated
	 */
	EList<Signal> getSignals();

	/**
	 * Returns the value of the '<em><b>Inner States</b></em>' containment reference list.
	 * The list contents are of type {@link ssm2.State}.
	 * It is bidirectional and its opposite is '{@link ssm2.State#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner States</em>' containment reference list.
	 * @see ssm2.Ssm2Package#getState_InnerStates()
	 * @see ssm2.State#getParentState
	 * @model opposite="parentState" containment="true"
	 * @generated
	 */
	EList<State> getInnerStates();

	/**
	 * Returns the value of the '<em><b>Entry Actions</b></em>' containment reference list.
	 * The list contents are of type {@link ssm2.Action}.
	 * It is bidirectional and its opposite is '{@link ssm2.Action#getParentStateEntryAction <em>Parent State Entry Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Actions</em>' containment reference list.
	 * @see ssm2.Ssm2Package#getState_EntryActions()
	 * @see ssm2.Action#getParentStateEntryAction
	 * @model opposite="parentStateEntryAction" containment="true"
	 * @generated
	 */
	EList<Action> getEntryActions();

	/**
	 * Returns the value of the '<em><b>Inner Actions</b></em>' containment reference list.
	 * The list contents are of type {@link ssm2.Action}.
	 * It is bidirectional and its opposite is '{@link ssm2.Action#getParentStateInnerAction <em>Parent State Inner Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Actions</em>' containment reference list.
	 * @see ssm2.Ssm2Package#getState_InnerActions()
	 * @see ssm2.Action#getParentStateInnerAction
	 * @model opposite="parentStateInnerAction" containment="true"
	 * @generated
	 */
	EList<Action> getInnerActions();

	/**
	 * Returns the value of the '<em><b>Exit Actions</b></em>' containment reference list.
	 * The list contents are of type {@link ssm2.Action}.
	 * It is bidirectional and its opposite is '{@link ssm2.Action#getParentStateExitAction <em>Parent State Exit Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit Actions</em>' containment reference list.
	 * @see ssm2.Ssm2Package#getState_ExitActions()
	 * @see ssm2.Action#getParentStateExitAction
	 * @model opposite="parentStateExitAction" containment="true"
	 * @generated
	 */
	EList<Action> getExitActions();

	/**
	 * Returns the value of the '<em><b>Signal Renamings</b></em>' containment reference list.
	 * The list contents are of type {@link ssm2.SignalRenaming}.
	 * It is bidirectional and its opposite is '{@link ssm2.SignalRenaming#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal Renamings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal Renamings</em>' containment reference list.
	 * @see ssm2.Ssm2Package#getState_SignalRenamings()
	 * @see ssm2.SignalRenaming#getParentState
	 * @model opposite="parentState" containment="true"
	 * @generated
	 */
	EList<SignalRenaming> getSignalRenamings();

	/**
	 * Returns the value of the '<em><b>Suspension Trigger</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link ssm2.SuspensionTrigger#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspension Trigger</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspension Trigger</em>' containment reference.
	 * @see #setSuspensionTrigger(SuspensionTrigger)
	 * @see ssm2.Ssm2Package#getState_SuspensionTrigger()
	 * @see ssm2.SuspensionTrigger#getParentState
	 * @model opposite="parentState" containment="true"
	 * @generated
	 */
	SuspensionTrigger getSuspensionTrigger();

	/**
	 * Sets the value of the '{@link ssm2.State#getSuspensionTrigger <em>Suspension Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspension Trigger</em>' containment reference.
	 * @see #getSuspensionTrigger()
	 * @generated
	 */
	void setSuspensionTrigger(SuspensionTrigger value);

	/**
	 * Returns the value of the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link ssm2.Transition}.
	 * It is bidirectional and its opposite is '{@link ssm2.Transition#getSourceState <em>Source State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Transitions</em>' containment reference list.
	 * @see ssm2.Ssm2Package#getState_OutgoingTransitions()
	 * @see ssm2.Transition#getSourceState
	 * @model opposite="sourceState" containment="true"
	 * @generated
	 */
	EList<Transition> getOutgoingTransitions();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ssm2.Ssm2Package#getState_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ssm2.State#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parent State</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm2.State#getInnerStates <em>Inner States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent State</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent State</em>' container reference.
	 * @see #setParentState(State)
	 * @see ssm2.Ssm2Package#getState_ParentState()
	 * @see ssm2.State#getInnerStates
	 * @model opposite="innerStates" transient="false"
	 * @generated
	 */
	State getParentState();

	/**
	 * Sets the value of the '{@link ssm2.State#getParentState <em>Parent State</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent State</em>' container reference.
	 * @see #getParentState()
	 * @generated
	 */
	void setParentState(State value);

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link ssm2.Variable}.
	 * It is bidirectional and its opposite is '{@link ssm2.Variable#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see ssm2.Ssm2Package#getState_Variables()
	 * @see ssm2.Variable#getParentState
	 * @model opposite="parentState" containment="true"
	 * @generated
	 */
	EList<Variable> getVariables();

} // State
