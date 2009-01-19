/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.ssm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.ssm.AbstractState#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.ssm.AbstractState#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.ssm.AbstractState#getOnEntryAction <em>On Entry Action</em>}</li>
 *   <li>{@link de.cau.cs.kieler.ssm.AbstractState#getOnInsideAction <em>On Inside Action</em>}</li>
 *   <li>{@link de.cau.cs.kieler.ssm.AbstractState#getOnExitAction <em>On Exit Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.ssm.ssmPackage#getAbstractState()
 * @model abstract="true"
 *        annotation="http://rtsys.informatik.uni-kiel.de/trac/kieler documentation='This one is called Reactive-Cell in the SSM documentation. For convenience, it is called \"Abstract State\" here.'"
 * @generated
 */
public interface AbstractState extends EObject {
	/**
	 * Returns the value of the '<em><b>Incoming Transitions</b></em>' reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.ssm.Transition}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.ssm.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Transitions</em>' reference list.
	 * @see de.cau.cs.kieler.ssm.ssmPackage#getAbstractState_IncomingTransitions()
	 * @see de.cau.cs.kieler.ssm.Transition#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Transition> getIncomingTransitions();

	/**
	 * Returns the value of the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.ssm.Transition}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.ssm.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Transitions</em>' reference list.
	 * @see de.cau.cs.kieler.ssm.ssmPackage#getAbstractState_OutgoingTransitions()
	 * @see de.cau.cs.kieler.ssm.Transition#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Transition> getOutgoingTransitions();

	/**
	 * Returns the value of the '<em><b>On Entry Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Entry Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Entry Action</em>' reference.
	 * @see #setOnEntryAction(OnAction)
	 * @see de.cau.cs.kieler.ssm.ssmPackage#getAbstractState_OnEntryAction()
	 * @model transient="true"
	 * @generated
	 */
	OnAction getOnEntryAction();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.ssm.AbstractState#getOnEntryAction <em>On Entry Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Entry Action</em>' reference.
	 * @see #getOnEntryAction()
	 * @generated
	 */
	void setOnEntryAction(OnAction value);

	/**
	 * Returns the value of the '<em><b>On Inside Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Inside Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Inside Action</em>' reference.
	 * @see #setOnInsideAction(OnAction)
	 * @see de.cau.cs.kieler.ssm.ssmPackage#getAbstractState_OnInsideAction()
	 * @model transient="true"
	 * @generated
	 */
	OnAction getOnInsideAction();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.ssm.AbstractState#getOnInsideAction <em>On Inside Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Inside Action</em>' reference.
	 * @see #getOnInsideAction()
	 * @generated
	 */
	void setOnInsideAction(OnAction value);

	/**
	 * Returns the value of the '<em><b>On Exit Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Exit Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Exit Action</em>' reference.
	 * @see #setOnExitAction(OnAction)
	 * @see de.cau.cs.kieler.ssm.ssmPackage#getAbstractState_OnExitAction()
	 * @model transient="true"
	 * @generated
	 */
	OnAction getOnExitAction();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.ssm.AbstractState#getOnExitAction <em>On Exit Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Exit Action</em>' reference.
	 * @see #getOnExitAction()
	 * @generated
	 */
	void setOnExitAction(OnAction value);

} // AbstractState
