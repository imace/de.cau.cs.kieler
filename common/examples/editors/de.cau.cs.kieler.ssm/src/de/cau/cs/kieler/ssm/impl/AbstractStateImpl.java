/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.ssm.impl;

import de.cau.cs.kieler.ssm.AbstractState;
import de.cau.cs.kieler.ssm.OnAction;
import de.cau.cs.kieler.ssm.Transition;
import de.cau.cs.kieler.ssm.ssmPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.ssm.impl.AbstractStateImpl#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.ssm.impl.AbstractStateImpl#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.ssm.impl.AbstractStateImpl#getOnEntryAction <em>On Entry Action</em>}</li>
 *   <li>{@link de.cau.cs.kieler.ssm.impl.AbstractStateImpl#getOnInsideAction <em>On Inside Action</em>}</li>
 *   <li>{@link de.cau.cs.kieler.ssm.impl.AbstractStateImpl#getOnExitAction <em>On Exit Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractStateImpl extends EObjectImpl implements AbstractState {
	/**
	 * The cached value of the '{@link #getIncomingTransitions() <em>Incoming Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> incomingTransitions;

	/**
	 * The cached value of the '{@link #getOutgoingTransitions() <em>Outgoing Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outgoingTransitions;

	/**
	 * The cached value of the '{@link #getOnEntryAction() <em>On Entry Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnEntryAction()
	 * @generated
	 * @ordered
	 */
	protected OnAction onEntryAction;

	/**
	 * The cached value of the '{@link #getOnInsideAction() <em>On Inside Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnInsideAction()
	 * @generated
	 * @ordered
	 */
	protected OnAction onInsideAction;

	/**
	 * The cached value of the '{@link #getOnExitAction() <em>On Exit Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnExitAction()
	 * @generated
	 * @ordered
	 */
	protected OnAction onExitAction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ssmPackage.Literals.ABSTRACT_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getIncomingTransitions() {
		if (incomingTransitions == null) {
			incomingTransitions = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, ssmPackage.ABSTRACT_STATE__INCOMING_TRANSITIONS, ssmPackage.TRANSITION__TARGET);
		}
		return incomingTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOutgoingTransitions() {
		if (outgoingTransitions == null) {
			outgoingTransitions = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, ssmPackage.ABSTRACT_STATE__OUTGOING_TRANSITIONS, ssmPackage.TRANSITION__SOURCE);
		}
		return outgoingTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnAction getOnEntryAction() {
		if (onEntryAction != null && onEntryAction.eIsProxy()) {
			InternalEObject oldOnEntryAction = (InternalEObject)onEntryAction;
			onEntryAction = (OnAction)eResolveProxy(oldOnEntryAction);
			if (onEntryAction != oldOnEntryAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ssmPackage.ABSTRACT_STATE__ON_ENTRY_ACTION, oldOnEntryAction, onEntryAction));
			}
		}
		return onEntryAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnAction basicGetOnEntryAction() {
		return onEntryAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnEntryAction(OnAction newOnEntryAction) {
		OnAction oldOnEntryAction = onEntryAction;
		onEntryAction = newOnEntryAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.ABSTRACT_STATE__ON_ENTRY_ACTION, oldOnEntryAction, onEntryAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnAction getOnInsideAction() {
		if (onInsideAction != null && onInsideAction.eIsProxy()) {
			InternalEObject oldOnInsideAction = (InternalEObject)onInsideAction;
			onInsideAction = (OnAction)eResolveProxy(oldOnInsideAction);
			if (onInsideAction != oldOnInsideAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ssmPackage.ABSTRACT_STATE__ON_INSIDE_ACTION, oldOnInsideAction, onInsideAction));
			}
		}
		return onInsideAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnAction basicGetOnInsideAction() {
		return onInsideAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnInsideAction(OnAction newOnInsideAction) {
		OnAction oldOnInsideAction = onInsideAction;
		onInsideAction = newOnInsideAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.ABSTRACT_STATE__ON_INSIDE_ACTION, oldOnInsideAction, onInsideAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnAction getOnExitAction() {
		if (onExitAction != null && onExitAction.eIsProxy()) {
			InternalEObject oldOnExitAction = (InternalEObject)onExitAction;
			onExitAction = (OnAction)eResolveProxy(oldOnExitAction);
			if (onExitAction != oldOnExitAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ssmPackage.ABSTRACT_STATE__ON_EXIT_ACTION, oldOnExitAction, onExitAction));
			}
		}
		return onExitAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnAction basicGetOnExitAction() {
		return onExitAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnExitAction(OnAction newOnExitAction) {
		OnAction oldOnExitAction = onExitAction;
		onExitAction = newOnExitAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.ABSTRACT_STATE__ON_EXIT_ACTION, oldOnExitAction, onExitAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ssmPackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingTransitions()).basicAdd(otherEnd, msgs);
			case ssmPackage.ABSTRACT_STATE__OUTGOING_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingTransitions()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ssmPackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				return ((InternalEList<?>)getIncomingTransitions()).basicRemove(otherEnd, msgs);
			case ssmPackage.ABSTRACT_STATE__OUTGOING_TRANSITIONS:
				return ((InternalEList<?>)getOutgoingTransitions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ssmPackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				return getIncomingTransitions();
			case ssmPackage.ABSTRACT_STATE__OUTGOING_TRANSITIONS:
				return getOutgoingTransitions();
			case ssmPackage.ABSTRACT_STATE__ON_ENTRY_ACTION:
				if (resolve) return getOnEntryAction();
				return basicGetOnEntryAction();
			case ssmPackage.ABSTRACT_STATE__ON_INSIDE_ACTION:
				if (resolve) return getOnInsideAction();
				return basicGetOnInsideAction();
			case ssmPackage.ABSTRACT_STATE__ON_EXIT_ACTION:
				if (resolve) return getOnExitAction();
				return basicGetOnExitAction();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ssmPackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				getIncomingTransitions().clear();
				getIncomingTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case ssmPackage.ABSTRACT_STATE__OUTGOING_TRANSITIONS:
				getOutgoingTransitions().clear();
				getOutgoingTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case ssmPackage.ABSTRACT_STATE__ON_ENTRY_ACTION:
				setOnEntryAction((OnAction)newValue);
				return;
			case ssmPackage.ABSTRACT_STATE__ON_INSIDE_ACTION:
				setOnInsideAction((OnAction)newValue);
				return;
			case ssmPackage.ABSTRACT_STATE__ON_EXIT_ACTION:
				setOnExitAction((OnAction)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ssmPackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				getIncomingTransitions().clear();
				return;
			case ssmPackage.ABSTRACT_STATE__OUTGOING_TRANSITIONS:
				getOutgoingTransitions().clear();
				return;
			case ssmPackage.ABSTRACT_STATE__ON_ENTRY_ACTION:
				setOnEntryAction((OnAction)null);
				return;
			case ssmPackage.ABSTRACT_STATE__ON_INSIDE_ACTION:
				setOnInsideAction((OnAction)null);
				return;
			case ssmPackage.ABSTRACT_STATE__ON_EXIT_ACTION:
				setOnExitAction((OnAction)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ssmPackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				return incomingTransitions != null && !incomingTransitions.isEmpty();
			case ssmPackage.ABSTRACT_STATE__OUTGOING_TRANSITIONS:
				return outgoingTransitions != null && !outgoingTransitions.isEmpty();
			case ssmPackage.ABSTRACT_STATE__ON_ENTRY_ACTION:
				return onEntryAction != null;
			case ssmPackage.ABSTRACT_STATE__ON_INSIDE_ACTION:
				return onInsideAction != null;
			case ssmPackage.ABSTRACT_STATE__ON_EXIT_ACTION:
				return onExitAction != null;
		}
		return super.eIsSet(featureID);
	}

} //AbstractStateImpl
