/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import ssm2.Action;
import ssm2.Assignment;
import ssm2.Emission;
import ssm2.Expression;
import ssm2.Ssm2Package;
import ssm2.State;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ssm2.impl.ActionImpl#getEmissions <em>Emissions</em>}</li>
 *   <li>{@link ssm2.impl.ActionImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link ssm2.impl.ActionImpl#getParentStateEntryAction <em>Parent State Entry Action</em>}</li>
 *   <li>{@link ssm2.impl.ActionImpl#getParentStateInnerAction <em>Parent State Inner Action</em>}</li>
 *   <li>{@link ssm2.impl.ActionImpl#getParentStateExitAction <em>Parent State Exit Action</em>}</li>
 *   <li>{@link ssm2.impl.ActionImpl#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link ssm2.impl.ActionImpl#getTriggersAndEffects <em>Triggers And Effects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionImpl extends EObjectImpl implements Action {
	/**
	 * The cached value of the '{@link #getEmissions() <em>Emissions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmissions()
	 * @generated
	 * @ordered
	 */
	protected EList<Emission> emissions;

	/**
	 * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected Expression trigger;

	/**
	 * The cached value of the '{@link #getAssignments() <em>Assignments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignments()
	 * @generated
	 * @ordered
	 */
	protected EList<Assignment> assignments;

	/**
	 * The default value of the '{@link #getTriggersAndEffects() <em>Triggers And Effects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggersAndEffects()
	 * @generated
	 * @ordered
	 */
	protected static final String TRIGGERS_AND_EFFECTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTriggersAndEffects() <em>Triggers And Effects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggersAndEffects()
	 * @generated
	 * @ordered
	 */
	protected String triggersAndEffects = TRIGGERS_AND_EFFECTS_EDEFAULT;

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
		return Ssm2Package.Literals.ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Emission> getEmissions() {
		if (emissions == null) {
			emissions = new EObjectContainmentWithInverseEList<Emission>(Emission.class, this, Ssm2Package.ACTION__EMISSIONS, Ssm2Package.EMISSION__PARENT_ACTION);
		}
		return emissions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTrigger() {
		return trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrigger(Expression newTrigger, NotificationChain msgs) {
		Expression oldTrigger = trigger;
		trigger = newTrigger;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ssm2Package.ACTION__TRIGGER, oldTrigger, newTrigger);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrigger(Expression newTrigger) {
		if (newTrigger != trigger) {
			NotificationChain msgs = null;
			if (trigger != null)
				msgs = ((InternalEObject)trigger).eInverseRemove(this, Ssm2Package.EXPRESSION__PARENT_ACTION, Expression.class, msgs);
			if (newTrigger != null)
				msgs = ((InternalEObject)newTrigger).eInverseAdd(this, Ssm2Package.EXPRESSION__PARENT_ACTION, Expression.class, msgs);
			msgs = basicSetTrigger(newTrigger, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.ACTION__TRIGGER, newTrigger, newTrigger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getParentStateEntryAction() {
		if (eContainerFeatureID != Ssm2Package.ACTION__PARENT_STATE_ENTRY_ACTION) return null;
		return (State)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentStateEntryAction(State newParentStateEntryAction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentStateEntryAction, Ssm2Package.ACTION__PARENT_STATE_ENTRY_ACTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentStateEntryAction(State newParentStateEntryAction) {
		if (newParentStateEntryAction != eInternalContainer() || (eContainerFeatureID != Ssm2Package.ACTION__PARENT_STATE_ENTRY_ACTION && newParentStateEntryAction != null)) {
			if (EcoreUtil.isAncestor(this, newParentStateEntryAction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentStateEntryAction != null)
				msgs = ((InternalEObject)newParentStateEntryAction).eInverseAdd(this, Ssm2Package.STATE__ENTRY_ACTIONS, State.class, msgs);
			msgs = basicSetParentStateEntryAction(newParentStateEntryAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.ACTION__PARENT_STATE_ENTRY_ACTION, newParentStateEntryAction, newParentStateEntryAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getParentStateInnerAction() {
		if (eContainerFeatureID != Ssm2Package.ACTION__PARENT_STATE_INNER_ACTION) return null;
		return (State)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentStateInnerAction(State newParentStateInnerAction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentStateInnerAction, Ssm2Package.ACTION__PARENT_STATE_INNER_ACTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentStateInnerAction(State newParentStateInnerAction) {
		if (newParentStateInnerAction != eInternalContainer() || (eContainerFeatureID != Ssm2Package.ACTION__PARENT_STATE_INNER_ACTION && newParentStateInnerAction != null)) {
			if (EcoreUtil.isAncestor(this, newParentStateInnerAction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentStateInnerAction != null)
				msgs = ((InternalEObject)newParentStateInnerAction).eInverseAdd(this, Ssm2Package.STATE__INNER_ACTIONS, State.class, msgs);
			msgs = basicSetParentStateInnerAction(newParentStateInnerAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.ACTION__PARENT_STATE_INNER_ACTION, newParentStateInnerAction, newParentStateInnerAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getParentStateExitAction() {
		if (eContainerFeatureID != Ssm2Package.ACTION__PARENT_STATE_EXIT_ACTION) return null;
		return (State)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentStateExitAction(State newParentStateExitAction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentStateExitAction, Ssm2Package.ACTION__PARENT_STATE_EXIT_ACTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentStateExitAction(State newParentStateExitAction) {
		if (newParentStateExitAction != eInternalContainer() || (eContainerFeatureID != Ssm2Package.ACTION__PARENT_STATE_EXIT_ACTION && newParentStateExitAction != null)) {
			if (EcoreUtil.isAncestor(this, newParentStateExitAction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentStateExitAction != null)
				msgs = ((InternalEObject)newParentStateExitAction).eInverseAdd(this, Ssm2Package.STATE__EXIT_ACTIONS, State.class, msgs);
			msgs = basicSetParentStateExitAction(newParentStateExitAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.ACTION__PARENT_STATE_EXIT_ACTION, newParentStateExitAction, newParentStateExitAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assignment> getAssignments() {
		if (assignments == null) {
			assignments = new EObjectContainmentEList<Assignment>(Assignment.class, this, Ssm2Package.ACTION__ASSIGNMENTS);
		}
		return assignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTriggersAndEffects() {
		return triggersAndEffects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTriggersAndEffects(String newTriggersAndEffects) {
		String oldTriggersAndEffects = triggersAndEffects;
		triggersAndEffects = newTriggersAndEffects;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.ACTION__TRIGGERS_AND_EFFECTS, oldTriggersAndEffects, triggersAndEffects));
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
			case Ssm2Package.ACTION__EMISSIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEmissions()).basicAdd(otherEnd, msgs);
			case Ssm2Package.ACTION__TRIGGER:
				if (trigger != null)
					msgs = ((InternalEObject)trigger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Ssm2Package.ACTION__TRIGGER, null, msgs);
				return basicSetTrigger((Expression)otherEnd, msgs);
			case Ssm2Package.ACTION__PARENT_STATE_ENTRY_ACTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentStateEntryAction((State)otherEnd, msgs);
			case Ssm2Package.ACTION__PARENT_STATE_INNER_ACTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentStateInnerAction((State)otherEnd, msgs);
			case Ssm2Package.ACTION__PARENT_STATE_EXIT_ACTION:
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
			case Ssm2Package.ACTION__EMISSIONS:
				return ((InternalEList<?>)getEmissions()).basicRemove(otherEnd, msgs);
			case Ssm2Package.ACTION__TRIGGER:
				return basicSetTrigger(null, msgs);
			case Ssm2Package.ACTION__PARENT_STATE_ENTRY_ACTION:
				return basicSetParentStateEntryAction(null, msgs);
			case Ssm2Package.ACTION__PARENT_STATE_INNER_ACTION:
				return basicSetParentStateInnerAction(null, msgs);
			case Ssm2Package.ACTION__PARENT_STATE_EXIT_ACTION:
				return basicSetParentStateExitAction(null, msgs);
			case Ssm2Package.ACTION__ASSIGNMENTS:
				return ((InternalEList<?>)getAssignments()).basicRemove(otherEnd, msgs);
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
			case Ssm2Package.ACTION__PARENT_STATE_ENTRY_ACTION:
				return eInternalContainer().eInverseRemove(this, Ssm2Package.STATE__ENTRY_ACTIONS, State.class, msgs);
			case Ssm2Package.ACTION__PARENT_STATE_INNER_ACTION:
				return eInternalContainer().eInverseRemove(this, Ssm2Package.STATE__INNER_ACTIONS, State.class, msgs);
			case Ssm2Package.ACTION__PARENT_STATE_EXIT_ACTION:
				return eInternalContainer().eInverseRemove(this, Ssm2Package.STATE__EXIT_ACTIONS, State.class, msgs);
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
			case Ssm2Package.ACTION__EMISSIONS:
				return getEmissions();
			case Ssm2Package.ACTION__TRIGGER:
				return getTrigger();
			case Ssm2Package.ACTION__PARENT_STATE_ENTRY_ACTION:
				return getParentStateEntryAction();
			case Ssm2Package.ACTION__PARENT_STATE_INNER_ACTION:
				return getParentStateInnerAction();
			case Ssm2Package.ACTION__PARENT_STATE_EXIT_ACTION:
				return getParentStateExitAction();
			case Ssm2Package.ACTION__ASSIGNMENTS:
				return getAssignments();
			case Ssm2Package.ACTION__TRIGGERS_AND_EFFECTS:
				return getTriggersAndEffects();
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
			case Ssm2Package.ACTION__EMISSIONS:
				getEmissions().clear();
				getEmissions().addAll((Collection<? extends Emission>)newValue);
				return;
			case Ssm2Package.ACTION__TRIGGER:
				setTrigger((Expression)newValue);
				return;
			case Ssm2Package.ACTION__PARENT_STATE_ENTRY_ACTION:
				setParentStateEntryAction((State)newValue);
				return;
			case Ssm2Package.ACTION__PARENT_STATE_INNER_ACTION:
				setParentStateInnerAction((State)newValue);
				return;
			case Ssm2Package.ACTION__PARENT_STATE_EXIT_ACTION:
				setParentStateExitAction((State)newValue);
				return;
			case Ssm2Package.ACTION__ASSIGNMENTS:
				getAssignments().clear();
				getAssignments().addAll((Collection<? extends Assignment>)newValue);
				return;
			case Ssm2Package.ACTION__TRIGGERS_AND_EFFECTS:
				setTriggersAndEffects((String)newValue);
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
			case Ssm2Package.ACTION__EMISSIONS:
				getEmissions().clear();
				return;
			case Ssm2Package.ACTION__TRIGGER:
				setTrigger((Expression)null);
				return;
			case Ssm2Package.ACTION__PARENT_STATE_ENTRY_ACTION:
				setParentStateEntryAction((State)null);
				return;
			case Ssm2Package.ACTION__PARENT_STATE_INNER_ACTION:
				setParentStateInnerAction((State)null);
				return;
			case Ssm2Package.ACTION__PARENT_STATE_EXIT_ACTION:
				setParentStateExitAction((State)null);
				return;
			case Ssm2Package.ACTION__ASSIGNMENTS:
				getAssignments().clear();
				return;
			case Ssm2Package.ACTION__TRIGGERS_AND_EFFECTS:
				setTriggersAndEffects(TRIGGERS_AND_EFFECTS_EDEFAULT);
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
			case Ssm2Package.ACTION__EMISSIONS:
				return emissions != null && !emissions.isEmpty();
			case Ssm2Package.ACTION__TRIGGER:
				return trigger != null;
			case Ssm2Package.ACTION__PARENT_STATE_ENTRY_ACTION:
				return getParentStateEntryAction() != null;
			case Ssm2Package.ACTION__PARENT_STATE_INNER_ACTION:
				return getParentStateInnerAction() != null;
			case Ssm2Package.ACTION__PARENT_STATE_EXIT_ACTION:
				return getParentStateExitAction() != null;
			case Ssm2Package.ACTION__ASSIGNMENTS:
				return assignments != null && !assignments.isEmpty();
			case Ssm2Package.ACTION__TRIGGERS_AND_EFFECTS:
				return TRIGGERS_AND_EFFECTS_EDEFAULT == null ? triggersAndEffects != null : !TRIGGERS_AND_EFFECTS_EDEFAULT.equals(triggersAndEffects);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (triggersAndEffects: ");
		result.append(triggersAndEffects);
		result.append(')');
		return result.toString();
	}

} //ActionImpl
