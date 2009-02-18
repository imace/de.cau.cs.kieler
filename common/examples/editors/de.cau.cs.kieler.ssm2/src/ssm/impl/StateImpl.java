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
import ssm.Signal;
import ssm.SignalRenaming;
import ssm.State;
import ssm.StateFlag;
import ssm.StateKind;
import ssm.SuspensionTrigger;
import ssm.Transition;
import ssm.ssmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ssm.impl.StateImpl#getStateKind <em>State Kind</em>}</li>
 *   <li>{@link ssm.impl.StateImpl#getStateFlag <em>State Flag</em>}</li>
 *   <li>{@link ssm.impl.StateImpl#getSignals <em>Signals</em>}</li>
 *   <li>{@link ssm.impl.StateImpl#getInnerStates <em>Inner States</em>}</li>
 *   <li>{@link ssm.impl.StateImpl#getEntryActions <em>Entry Actions</em>}</li>
 *   <li>{@link ssm.impl.StateImpl#getInnerActions <em>Inner Actions</em>}</li>
 *   <li>{@link ssm.impl.StateImpl#getExitActions <em>Exit Actions</em>}</li>
 *   <li>{@link ssm.impl.StateImpl#getSignalRenamings <em>Signal Renamings</em>}</li>
 *   <li>{@link ssm.impl.StateImpl#getSuspensionTrigger <em>Suspension Trigger</em>}</li>
 *   <li>{@link ssm.impl.StateImpl#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link ssm.impl.StateImpl#getName <em>Name</em>}</li>
 *   <li>{@link ssm.impl.StateImpl#getParentState <em>Parent State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends EObjectImpl implements State {
	/**
	 * The default value of the '{@link #getStateKind() <em>State Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateKind()
	 * @generated
	 * @ordered
	 */
	protected static final StateKind STATE_KIND_EDEFAULT = StateKind.NORMAL;

	/**
	 * The cached value of the '{@link #getStateKind() <em>State Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateKind()
	 * @generated
	 * @ordered
	 */
	protected StateKind stateKind = STATE_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getStateFlag() <em>State Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateFlag()
	 * @generated
	 * @ordered
	 */
	protected static final StateFlag STATE_FLAG_EDEFAULT = StateFlag.NORMAL;

	/**
	 * The cached value of the '{@link #getStateFlag() <em>State Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateFlag()
	 * @generated
	 * @ordered
	 */
	protected StateFlag stateFlag = STATE_FLAG_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSignals() <em>Signals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignals()
	 * @generated
	 * @ordered
	 */
	protected EList<Signal> signals;

	/**
	 * The cached value of the '{@link #getInnerStates() <em>Inner States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> innerStates;

	/**
	 * The cached value of the '{@link #getEntryActions() <em>Entry Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> entryActions;

	/**
	 * The cached value of the '{@link #getInnerActions() <em>Inner Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> innerActions;

	/**
	 * The cached value of the '{@link #getExitActions() <em>Exit Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> exitActions;

	/**
	 * The cached value of the '{@link #getSignalRenamings() <em>Signal Renamings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignalRenamings()
	 * @generated
	 * @ordered
	 */
	protected EList<SignalRenaming> signalRenamings;

	/**
	 * The cached value of the '{@link #getSuspensionTrigger() <em>Suspension Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionTrigger()
	 * @generated
	 * @ordered
	 */
	protected SuspensionTrigger suspensionTrigger;

	/**
	 * The cached value of the '{@link #getOutgoingTransitions() <em>Outgoing Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outgoingTransitions;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ssmPackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateKind getStateKind() {
		return stateKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateKind(StateKind newStateKind) {
		StateKind oldStateKind = stateKind;
		stateKind = newStateKind == null ? STATE_KIND_EDEFAULT : newStateKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.STATE__STATE_KIND, oldStateKind, stateKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateFlag getStateFlag() {
		return stateFlag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateFlag(StateFlag newStateFlag) {
		StateFlag oldStateFlag = stateFlag;
		stateFlag = newStateFlag == null ? STATE_FLAG_EDEFAULT : newStateFlag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.STATE__STATE_FLAG, oldStateFlag, stateFlag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Signal> getSignals() {
		if (signals == null) {
			signals = new EObjectContainmentWithInverseEList<Signal>(Signal.class, this, ssmPackage.STATE__SIGNALS, ssmPackage.SIGNAL__PARENT_STATE);
		}
		return signals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getInnerStates() {
		if (innerStates == null) {
			innerStates = new EObjectContainmentWithInverseEList<State>(State.class, this, ssmPackage.STATE__INNER_STATES, ssmPackage.STATE__PARENT_STATE);
		}
		return innerStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getEntryActions() {
		if (entryActions == null) {
			entryActions = new EObjectContainmentWithInverseEList<Action>(Action.class, this, ssmPackage.STATE__ENTRY_ACTIONS, ssmPackage.ACTION__PARENT_STATE_ENTRY_ACTION);
		}
		return entryActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getInnerActions() {
		if (innerActions == null) {
			innerActions = new EObjectContainmentWithInverseEList<Action>(Action.class, this, ssmPackage.STATE__INNER_ACTIONS, ssmPackage.ACTION__PARENT_STATE_INNER_ACTION);
		}
		return innerActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getExitActions() {
		if (exitActions == null) {
			exitActions = new EObjectContainmentWithInverseEList<Action>(Action.class, this, ssmPackage.STATE__EXIT_ACTIONS, ssmPackage.ACTION__PARENT_STATE_EXIT_ACTION);
		}
		return exitActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SignalRenaming> getSignalRenamings() {
		if (signalRenamings == null) {
			signalRenamings = new EObjectContainmentWithInverseEList<SignalRenaming>(SignalRenaming.class, this, ssmPackage.STATE__SIGNAL_RENAMINGS, ssmPackage.SIGNAL_RENAMING__PARENT_STATE);
		}
		return signalRenamings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuspensionTrigger getSuspensionTrigger() {
		return suspensionTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuspensionTrigger(SuspensionTrigger newSuspensionTrigger, NotificationChain msgs) {
		SuspensionTrigger oldSuspensionTrigger = suspensionTrigger;
		suspensionTrigger = newSuspensionTrigger;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ssmPackage.STATE__SUSPENSION_TRIGGER, oldSuspensionTrigger, newSuspensionTrigger);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspensionTrigger(SuspensionTrigger newSuspensionTrigger) {
		if (newSuspensionTrigger != suspensionTrigger) {
			NotificationChain msgs = null;
			if (suspensionTrigger != null)
				msgs = ((InternalEObject)suspensionTrigger).eInverseRemove(this, ssmPackage.SUSPENSION_TRIGGER__PARENT_STATE, SuspensionTrigger.class, msgs);
			if (newSuspensionTrigger != null)
				msgs = ((InternalEObject)newSuspensionTrigger).eInverseAdd(this, ssmPackage.SUSPENSION_TRIGGER__PARENT_STATE, SuspensionTrigger.class, msgs);
			msgs = basicSetSuspensionTrigger(newSuspensionTrigger, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.STATE__SUSPENSION_TRIGGER, newSuspensionTrigger, newSuspensionTrigger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOutgoingTransitions() {
		if (outgoingTransitions == null) {
			outgoingTransitions = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this, ssmPackage.STATE__OUTGOING_TRANSITIONS, ssmPackage.TRANSITION__SOURCE_STATE);
		}
		return outgoingTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.STATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getParentState() {
		if (eContainerFeatureID != ssmPackage.STATE__PARENT_STATE) return null;
		return (State)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentState(State newParentState, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentState, ssmPackage.STATE__PARENT_STATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentState(State newParentState) {
		if (newParentState != eInternalContainer() || (eContainerFeatureID != ssmPackage.STATE__PARENT_STATE && newParentState != null)) {
			if (EcoreUtil.isAncestor(this, newParentState))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentState != null)
				msgs = ((InternalEObject)newParentState).eInverseAdd(this, ssmPackage.STATE__INNER_STATES, State.class, msgs);
			msgs = basicSetParentState(newParentState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.STATE__PARENT_STATE, newParentState, newParentState));
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
			case ssmPackage.STATE__SIGNALS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSignals()).basicAdd(otherEnd, msgs);
			case ssmPackage.STATE__INNER_STATES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInnerStates()).basicAdd(otherEnd, msgs);
			case ssmPackage.STATE__ENTRY_ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEntryActions()).basicAdd(otherEnd, msgs);
			case ssmPackage.STATE__INNER_ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInnerActions()).basicAdd(otherEnd, msgs);
			case ssmPackage.STATE__EXIT_ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExitActions()).basicAdd(otherEnd, msgs);
			case ssmPackage.STATE__SIGNAL_RENAMINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSignalRenamings()).basicAdd(otherEnd, msgs);
			case ssmPackage.STATE__SUSPENSION_TRIGGER:
				if (suspensionTrigger != null)
					msgs = ((InternalEObject)suspensionTrigger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ssmPackage.STATE__SUSPENSION_TRIGGER, null, msgs);
				return basicSetSuspensionTrigger((SuspensionTrigger)otherEnd, msgs);
			case ssmPackage.STATE__OUTGOING_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingTransitions()).basicAdd(otherEnd, msgs);
			case ssmPackage.STATE__PARENT_STATE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentState((State)otherEnd, msgs);
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
			case ssmPackage.STATE__SIGNALS:
				return ((InternalEList<?>)getSignals()).basicRemove(otherEnd, msgs);
			case ssmPackage.STATE__INNER_STATES:
				return ((InternalEList<?>)getInnerStates()).basicRemove(otherEnd, msgs);
			case ssmPackage.STATE__ENTRY_ACTIONS:
				return ((InternalEList<?>)getEntryActions()).basicRemove(otherEnd, msgs);
			case ssmPackage.STATE__INNER_ACTIONS:
				return ((InternalEList<?>)getInnerActions()).basicRemove(otherEnd, msgs);
			case ssmPackage.STATE__EXIT_ACTIONS:
				return ((InternalEList<?>)getExitActions()).basicRemove(otherEnd, msgs);
			case ssmPackage.STATE__SIGNAL_RENAMINGS:
				return ((InternalEList<?>)getSignalRenamings()).basicRemove(otherEnd, msgs);
			case ssmPackage.STATE__SUSPENSION_TRIGGER:
				return basicSetSuspensionTrigger(null, msgs);
			case ssmPackage.STATE__OUTGOING_TRANSITIONS:
				return ((InternalEList<?>)getOutgoingTransitions()).basicRemove(otherEnd, msgs);
			case ssmPackage.STATE__PARENT_STATE:
				return basicSetParentState(null, msgs);
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
			case ssmPackage.STATE__PARENT_STATE:
				return eInternalContainer().eInverseRemove(this, ssmPackage.STATE__INNER_STATES, State.class, msgs);
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
			case ssmPackage.STATE__STATE_KIND:
				return getStateKind();
			case ssmPackage.STATE__STATE_FLAG:
				return getStateFlag();
			case ssmPackage.STATE__SIGNALS:
				return getSignals();
			case ssmPackage.STATE__INNER_STATES:
				return getInnerStates();
			case ssmPackage.STATE__ENTRY_ACTIONS:
				return getEntryActions();
			case ssmPackage.STATE__INNER_ACTIONS:
				return getInnerActions();
			case ssmPackage.STATE__EXIT_ACTIONS:
				return getExitActions();
			case ssmPackage.STATE__SIGNAL_RENAMINGS:
				return getSignalRenamings();
			case ssmPackage.STATE__SUSPENSION_TRIGGER:
				return getSuspensionTrigger();
			case ssmPackage.STATE__OUTGOING_TRANSITIONS:
				return getOutgoingTransitions();
			case ssmPackage.STATE__NAME:
				return getName();
			case ssmPackage.STATE__PARENT_STATE:
				return getParentState();
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
			case ssmPackage.STATE__STATE_KIND:
				setStateKind((StateKind)newValue);
				return;
			case ssmPackage.STATE__STATE_FLAG:
				setStateFlag((StateFlag)newValue);
				return;
			case ssmPackage.STATE__SIGNALS:
				getSignals().clear();
				getSignals().addAll((Collection<? extends Signal>)newValue);
				return;
			case ssmPackage.STATE__INNER_STATES:
				getInnerStates().clear();
				getInnerStates().addAll((Collection<? extends State>)newValue);
				return;
			case ssmPackage.STATE__ENTRY_ACTIONS:
				getEntryActions().clear();
				getEntryActions().addAll((Collection<? extends Action>)newValue);
				return;
			case ssmPackage.STATE__INNER_ACTIONS:
				getInnerActions().clear();
				getInnerActions().addAll((Collection<? extends Action>)newValue);
				return;
			case ssmPackage.STATE__EXIT_ACTIONS:
				getExitActions().clear();
				getExitActions().addAll((Collection<? extends Action>)newValue);
				return;
			case ssmPackage.STATE__SIGNAL_RENAMINGS:
				getSignalRenamings().clear();
				getSignalRenamings().addAll((Collection<? extends SignalRenaming>)newValue);
				return;
			case ssmPackage.STATE__SUSPENSION_TRIGGER:
				setSuspensionTrigger((SuspensionTrigger)newValue);
				return;
			case ssmPackage.STATE__OUTGOING_TRANSITIONS:
				getOutgoingTransitions().clear();
				getOutgoingTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case ssmPackage.STATE__NAME:
				setName((String)newValue);
				return;
			case ssmPackage.STATE__PARENT_STATE:
				setParentState((State)newValue);
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
			case ssmPackage.STATE__STATE_KIND:
				setStateKind(STATE_KIND_EDEFAULT);
				return;
			case ssmPackage.STATE__STATE_FLAG:
				setStateFlag(STATE_FLAG_EDEFAULT);
				return;
			case ssmPackage.STATE__SIGNALS:
				getSignals().clear();
				return;
			case ssmPackage.STATE__INNER_STATES:
				getInnerStates().clear();
				return;
			case ssmPackage.STATE__ENTRY_ACTIONS:
				getEntryActions().clear();
				return;
			case ssmPackage.STATE__INNER_ACTIONS:
				getInnerActions().clear();
				return;
			case ssmPackage.STATE__EXIT_ACTIONS:
				getExitActions().clear();
				return;
			case ssmPackage.STATE__SIGNAL_RENAMINGS:
				getSignalRenamings().clear();
				return;
			case ssmPackage.STATE__SUSPENSION_TRIGGER:
				setSuspensionTrigger((SuspensionTrigger)null);
				return;
			case ssmPackage.STATE__OUTGOING_TRANSITIONS:
				getOutgoingTransitions().clear();
				return;
			case ssmPackage.STATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ssmPackage.STATE__PARENT_STATE:
				setParentState((State)null);
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
			case ssmPackage.STATE__STATE_KIND:
				return stateKind != STATE_KIND_EDEFAULT;
			case ssmPackage.STATE__STATE_FLAG:
				return stateFlag != STATE_FLAG_EDEFAULT;
			case ssmPackage.STATE__SIGNALS:
				return signals != null && !signals.isEmpty();
			case ssmPackage.STATE__INNER_STATES:
				return innerStates != null && !innerStates.isEmpty();
			case ssmPackage.STATE__ENTRY_ACTIONS:
				return entryActions != null && !entryActions.isEmpty();
			case ssmPackage.STATE__INNER_ACTIONS:
				return innerActions != null && !innerActions.isEmpty();
			case ssmPackage.STATE__EXIT_ACTIONS:
				return exitActions != null && !exitActions.isEmpty();
			case ssmPackage.STATE__SIGNAL_RENAMINGS:
				return signalRenamings != null && !signalRenamings.isEmpty();
			case ssmPackage.STATE__SUSPENSION_TRIGGER:
				return suspensionTrigger != null;
			case ssmPackage.STATE__OUTGOING_TRANSITIONS:
				return outgoingTransitions != null && !outgoingTransitions.isEmpty();
			case ssmPackage.STATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ssmPackage.STATE__PARENT_STATE:
				return getParentState() != null;
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
		result.append(" (stateKind: ");
		result.append(stateKind);
		result.append(", stateFlag: ");
		result.append(stateFlag);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //StateImpl
