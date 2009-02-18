/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import ssm.State;
import ssm.Transition;
import ssm.TransitionKind;
import ssm.ssmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ssm.impl.TransitionImpl#getDelay <em>Delay</em>}</li>
 *   <li>{@link ssm.impl.TransitionImpl#isImmediate <em>Immediate</em>}</li>
 *   <li>{@link ssm.impl.TransitionImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link ssm.impl.TransitionImpl#getTransitionKind <em>Transition Kind</em>}</li>
 *   <li>{@link ssm.impl.TransitionImpl#getTargetState <em>Target State</em>}</li>
 *   <li>{@link ssm.impl.TransitionImpl#getSourceState <em>Source State</em>}</li>
 *   <li>{@link ssm.impl.TransitionImpl#getTriggersAndEffects <em>Triggers And Effects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionImpl extends ActionImpl implements Transition {
	/**
	 * The default value of the '{@link #getDelay() <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelay()
	 * @generated
	 * @ordered
	 */
	protected static final int DELAY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDelay() <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelay()
	 * @generated
	 * @ordered
	 */
	protected int delay = DELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #isImmediate() <em>Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImmediate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMMEDIATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isImmediate() <em>Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImmediate()
	 * @generated
	 * @ordered
	 */
	protected boolean immediate = IMMEDIATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransitionKind() <em>Transition Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionKind()
	 * @generated
	 * @ordered
	 */
	protected static final TransitionKind TRANSITION_KIND_EDEFAULT = TransitionKind.STRONGABORT;

	/**
	 * The cached value of the '{@link #getTransitionKind() <em>Transition Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionKind()
	 * @generated
	 * @ordered
	 */
	protected TransitionKind transitionKind = TRANSITION_KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTargetState() <em>Target State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetState()
	 * @generated
	 * @ordered
	 */
	protected State targetState;

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
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ssmPackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDelay() {
		return delay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelay(int newDelay) {
		int oldDelay = delay;
		delay = newDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRANSITION__DELAY, oldDelay, delay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImmediate() {
		return immediate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImmediate(boolean newImmediate) {
		boolean oldImmediate = immediate;
		immediate = newImmediate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRANSITION__IMMEDIATE, oldImmediate, immediate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRANSITION__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionKind getTransitionKind() {
		return transitionKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransitionKind(TransitionKind newTransitionKind) {
		TransitionKind oldTransitionKind = transitionKind;
		transitionKind = newTransitionKind == null ? TRANSITION_KIND_EDEFAULT : newTransitionKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRANSITION__TRANSITION_KIND, oldTransitionKind, transitionKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getTargetState() {
		if (targetState != null && targetState.eIsProxy()) {
			InternalEObject oldTargetState = (InternalEObject)targetState;
			targetState = (State)eResolveProxy(oldTargetState);
			if (targetState != oldTargetState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ssmPackage.TRANSITION__TARGET_STATE, oldTargetState, targetState));
			}
		}
		return targetState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetTargetState() {
		return targetState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetState(State newTargetState) {
		State oldTargetState = targetState;
		targetState = newTargetState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRANSITION__TARGET_STATE, oldTargetState, targetState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getSourceState() {
		if (eContainerFeatureID != ssmPackage.TRANSITION__SOURCE_STATE) return null;
		return (State)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceState(State newSourceState, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSourceState, ssmPackage.TRANSITION__SOURCE_STATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceState(State newSourceState) {
		if (newSourceState != eInternalContainer() || (eContainerFeatureID != ssmPackage.TRANSITION__SOURCE_STATE && newSourceState != null)) {
			if (EcoreUtil.isAncestor(this, newSourceState))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSourceState != null)
				msgs = ((InternalEObject)newSourceState).eInverseAdd(this, ssmPackage.STATE__OUTGOING_TRANSITIONS, State.class, msgs);
			msgs = basicSetSourceState(newSourceState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRANSITION__SOURCE_STATE, newSourceState, newSourceState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRANSITION__TRIGGERS_AND_EFFECTS, oldTriggersAndEffects, triggersAndEffects));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ssmPackage.TRANSITION__SOURCE_STATE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSourceState((State)otherEnd, msgs);
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
			case ssmPackage.TRANSITION__SOURCE_STATE:
				return basicSetSourceState(null, msgs);
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
			case ssmPackage.TRANSITION__SOURCE_STATE:
				return eInternalContainer().eInverseRemove(this, ssmPackage.STATE__OUTGOING_TRANSITIONS, State.class, msgs);
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
			case ssmPackage.TRANSITION__DELAY:
				return new Integer(getDelay());
			case ssmPackage.TRANSITION__IMMEDIATE:
				return isImmediate() ? Boolean.TRUE : Boolean.FALSE;
			case ssmPackage.TRANSITION__PRIORITY:
				return new Integer(getPriority());
			case ssmPackage.TRANSITION__TRANSITION_KIND:
				return getTransitionKind();
			case ssmPackage.TRANSITION__TARGET_STATE:
				if (resolve) return getTargetState();
				return basicGetTargetState();
			case ssmPackage.TRANSITION__SOURCE_STATE:
				return getSourceState();
			case ssmPackage.TRANSITION__TRIGGERS_AND_EFFECTS:
				return getTriggersAndEffects();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ssmPackage.TRANSITION__DELAY:
				setDelay(((Integer)newValue).intValue());
				return;
			case ssmPackage.TRANSITION__IMMEDIATE:
				setImmediate(((Boolean)newValue).booleanValue());
				return;
			case ssmPackage.TRANSITION__PRIORITY:
				setPriority(((Integer)newValue).intValue());
				return;
			case ssmPackage.TRANSITION__TRANSITION_KIND:
				setTransitionKind((TransitionKind)newValue);
				return;
			case ssmPackage.TRANSITION__TARGET_STATE:
				setTargetState((State)newValue);
				return;
			case ssmPackage.TRANSITION__SOURCE_STATE:
				setSourceState((State)newValue);
				return;
			case ssmPackage.TRANSITION__TRIGGERS_AND_EFFECTS:
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
			case ssmPackage.TRANSITION__DELAY:
				setDelay(DELAY_EDEFAULT);
				return;
			case ssmPackage.TRANSITION__IMMEDIATE:
				setImmediate(IMMEDIATE_EDEFAULT);
				return;
			case ssmPackage.TRANSITION__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case ssmPackage.TRANSITION__TRANSITION_KIND:
				setTransitionKind(TRANSITION_KIND_EDEFAULT);
				return;
			case ssmPackage.TRANSITION__TARGET_STATE:
				setTargetState((State)null);
				return;
			case ssmPackage.TRANSITION__SOURCE_STATE:
				setSourceState((State)null);
				return;
			case ssmPackage.TRANSITION__TRIGGERS_AND_EFFECTS:
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
			case ssmPackage.TRANSITION__DELAY:
				return delay != DELAY_EDEFAULT;
			case ssmPackage.TRANSITION__IMMEDIATE:
				return immediate != IMMEDIATE_EDEFAULT;
			case ssmPackage.TRANSITION__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case ssmPackage.TRANSITION__TRANSITION_KIND:
				return transitionKind != TRANSITION_KIND_EDEFAULT;
			case ssmPackage.TRANSITION__TARGET_STATE:
				return targetState != null;
			case ssmPackage.TRANSITION__SOURCE_STATE:
				return getSourceState() != null;
			case ssmPackage.TRANSITION__TRIGGERS_AND_EFFECTS:
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
		result.append(" (delay: ");
		result.append(delay);
		result.append(", immediate: ");
		result.append(immediate);
		result.append(", priority: ");
		result.append(priority);
		result.append(", transitionKind: ");
		result.append(transitionKind);
		result.append(", triggersAndEffects: ");
		result.append(triggersAndEffects);
		result.append(')');
		return result.toString();
	}

} //TransitionImpl
