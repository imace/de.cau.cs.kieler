/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import ssm.Action;
import ssm.Emission;
import ssm.State;
import ssm.Trigger;
import ssm.ssmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ssm.impl.ActionImpl#getEffects <em>Effects</em>}</li>
 *   <li>{@link ssm.impl.ActionImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link ssm.impl.ActionImpl#getParentStateEntryAction <em>Parent State Entry Action</em>}</li>
 *   <li>{@link ssm.impl.ActionImpl#getParentStateInnerAction <em>Parent State Inner Action</em>}</li>
 *   <li>{@link ssm.impl.ActionImpl#getParentStateExitAction <em>Parent State Exit Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionImpl extends EObjectImpl implements Action {
	/**
	 * The cached value of the '{@link #getEffects() <em>Effects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEffects()
	 * @generated
	 * @ordered
	 */
	protected EList<Emission> effects;

	/**
	 * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected Trigger trigger;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ssmPackage.Literals.ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Emission> getEffects() {
		if (effects == null) {
			effects = new EObjectContainmentWithInverseEList<Emission>(Emission.class, this, ssmPackage.ACTION__EFFECTS, ssmPackage.EMISSION__PARENT_ACTION);
		}
		return effects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trigger getTrigger() {
		return trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrigger(Trigger newTrigger, NotificationChain msgs) {
		Trigger oldTrigger = trigger;
		trigger = newTrigger;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ssmPackage.ACTION__TRIGGER, oldTrigger, newTrigger);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrigger(Trigger newTrigger) {
		if (newTrigger != trigger) {
			NotificationChain msgs = null;
			if (trigger != null)
				msgs = ((InternalEObject)trigger).eInverseRemove(this, ssmPackage.TRIGGER__PARENT_ACTION, Trigger.class, msgs);
			if (newTrigger != null)
				msgs = ((InternalEObject)newTrigger).eInverseAdd(this, ssmPackage.TRIGGER__PARENT_ACTION, Trigger.class, msgs);
			msgs = basicSetTrigger(newTrigger, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.ACTION__TRIGGER, newTrigger, newTrigger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getParentStateEntryAction() {
		if (eContainerFeatureID != ssmPackage.ACTION__PARENT_STATE_ENTRY_ACTION) return null;
		return (State)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentStateEntryAction(State newParentStateEntryAction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentStateEntryAction, ssmPackage.ACTION__PARENT_STATE_ENTRY_ACTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentStateEntryAction(State newParentStateEntryAction) {
		if (newParentStateEntryAction != eInternalContainer() || (eContainerFeatureID != ssmPackage.ACTION__PARENT_STATE_ENTRY_ACTION && newParentStateEntryAction != null)) {
			if (EcoreUtil.isAncestor(this, newParentStateEntryAction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentStateEntryAction != null)
				msgs = ((InternalEObject)newParentStateEntryAction).eInverseAdd(this, ssmPackage.STATE__ENTRY_ACTIONS, State.class, msgs);
			msgs = basicSetParentStateEntryAction(newParentStateEntryAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.ACTION__PARENT_STATE_ENTRY_ACTION, newParentStateEntryAction, newParentStateEntryAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getParentStateInnerAction() {
		if (eContainerFeatureID != ssmPackage.ACTION__PARENT_STATE_INNER_ACTION) return null;
		return (State)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentStateInnerAction(State newParentStateInnerAction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentStateInnerAction, ssmPackage.ACTION__PARENT_STATE_INNER_ACTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentStateInnerAction(State newParentStateInnerAction) {
		if (newParentStateInnerAction != eInternalContainer() || (eContainerFeatureID != ssmPackage.ACTION__PARENT_STATE_INNER_ACTION && newParentStateInnerAction != null)) {
			if (EcoreUtil.isAncestor(this, newParentStateInnerAction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentStateInnerAction != null)
				msgs = ((InternalEObject)newParentStateInnerAction).eInverseAdd(this, ssmPackage.STATE__INNER_ACTIONS, State.class, msgs);
			msgs = basicSetParentStateInnerAction(newParentStateInnerAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.ACTION__PARENT_STATE_INNER_ACTION, newParentStateInnerAction, newParentStateInnerAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getParentStateExitAction() {
		if (eContainerFeatureID != ssmPackage.ACTION__PARENT_STATE_EXIT_ACTION) return null;
		return (State)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentStateExitAction(State newParentStateExitAction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentStateExitAction, ssmPackage.ACTION__PARENT_STATE_EXIT_ACTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentStateExitAction(State newParentStateExitAction) {
		if (newParentStateExitAction != eInternalContainer() || (eContainerFeatureID != ssmPackage.ACTION__PARENT_STATE_EXIT_ACTION && newParentStateExitAction != null)) {
			if (EcoreUtil.isAncestor(this, newParentStateExitAction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentStateExitAction != null)
				msgs = ((InternalEObject)newParentStateExitAction).eInverseAdd(this, ssmPackage.STATE__EXIT_ACTIONS, State.class, msgs);
			msgs = basicSetParentStateExitAction(newParentStateExitAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.ACTION__PARENT_STATE_EXIT_ACTION, newParentStateExitAction, newParentStateExitAction));
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
			case ssmPackage.ACTION__EFFECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEffects()).basicAdd(otherEnd, msgs);
			case ssmPackage.ACTION__TRIGGER:
				if (trigger != null)
					msgs = ((InternalEObject)trigger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ssmPackage.ACTION__TRIGGER, null, msgs);
				return basicSetTrigger((Trigger)otherEnd, msgs);
			case ssmPackage.ACTION__PARENT_STATE_ENTRY_ACTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentStateEntryAction((State)otherEnd, msgs);
			case ssmPackage.ACTION__PARENT_STATE_INNER_ACTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentStateInnerAction((State)otherEnd, msgs);
			case ssmPackage.ACTION__PARENT_STATE_EXIT_ACTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentStateExitAction((State)otherEnd, msgs);
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
			case ssmPackage.ACTION__EFFECTS:
				return ((InternalEList<?>)getEffects()).basicRemove(otherEnd, msgs);
			case ssmPackage.ACTION__TRIGGER:
				return basicSetTrigger(null, msgs);
			case ssmPackage.ACTION__PARENT_STATE_ENTRY_ACTION:
				return basicSetParentStateEntryAction(null, msgs);
			case ssmPackage.ACTION__PARENT_STATE_INNER_ACTION:
				return basicSetParentStateInnerAction(null, msgs);
			case ssmPackage.ACTION__PARENT_STATE_EXIT_ACTION:
				return basicSetParentStateExitAction(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case ssmPackage.ACTION__PARENT_STATE_ENTRY_ACTION:
				return eInternalContainer().eInverseRemove(this, ssmPackage.STATE__ENTRY_ACTIONS, State.class, msgs);
			case ssmPackage.ACTION__PARENT_STATE_INNER_ACTION:
				return eInternalContainer().eInverseRemove(this, ssmPackage.STATE__INNER_ACTIONS, State.class, msgs);
			case ssmPackage.ACTION__PARENT_STATE_EXIT_ACTION:
				return eInternalContainer().eInverseRemove(this, ssmPackage.STATE__EXIT_ACTIONS, State.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ssmPackage.ACTION__EFFECTS:
				return getEffects();
			case ssmPackage.ACTION__TRIGGER:
				return getTrigger();
			case ssmPackage.ACTION__PARENT_STATE_ENTRY_ACTION:
				return getParentStateEntryAction();
			case ssmPackage.ACTION__PARENT_STATE_INNER_ACTION:
				return getParentStateInnerAction();
			case ssmPackage.ACTION__PARENT_STATE_EXIT_ACTION:
				return getParentStateExitAction();
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
			case ssmPackage.ACTION__EFFECTS:
				getEffects().clear();
				getEffects().addAll((Collection<? extends Emission>)newValue);
				return;
			case ssmPackage.ACTION__TRIGGER:
				setTrigger((Trigger)newValue);
				return;
			case ssmPackage.ACTION__PARENT_STATE_ENTRY_ACTION:
				setParentStateEntryAction((State)newValue);
				return;
			case ssmPackage.ACTION__PARENT_STATE_INNER_ACTION:
				setParentStateInnerAction((State)newValue);
				return;
			case ssmPackage.ACTION__PARENT_STATE_EXIT_ACTION:
				setParentStateExitAction((State)newValue);
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
			case ssmPackage.ACTION__EFFECTS:
				getEffects().clear();
				return;
			case ssmPackage.ACTION__TRIGGER:
				setTrigger((Trigger)null);
				return;
			case ssmPackage.ACTION__PARENT_STATE_ENTRY_ACTION:
				setParentStateEntryAction((State)null);
				return;
			case ssmPackage.ACTION__PARENT_STATE_INNER_ACTION:
				setParentStateInnerAction((State)null);
				return;
			case ssmPackage.ACTION__PARENT_STATE_EXIT_ACTION:
				setParentStateExitAction((State)null);
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
			case ssmPackage.ACTION__EFFECTS:
				return effects != null && !effects.isEmpty();
			case ssmPackage.ACTION__TRIGGER:
				return trigger != null;
			case ssmPackage.ACTION__PARENT_STATE_ENTRY_ACTION:
				return getParentStateEntryAction() != null;
			case ssmPackage.ACTION__PARENT_STATE_INNER_ACTION:
				return getParentStateInnerAction() != null;
			case ssmPackage.ACTION__PARENT_STATE_EXIT_ACTION:
				return getParentStateExitAction() != null;
		}
		return super.eIsSet(featureID);
	}

} //ActionImpl
