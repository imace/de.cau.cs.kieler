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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import ssm.Action;
import ssm.Operator;
import ssm.Signal;
import ssm.Trigger;
import ssm.ssmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ssm.impl.TriggerImpl#getSubTriggers <em>Sub Triggers</em>}</li>
 *   <li>{@link ssm.impl.TriggerImpl#getLiterals <em>Literals</em>}</li>
 *   <li>{@link ssm.impl.TriggerImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link ssm.impl.TriggerImpl#getParentTrigger <em>Parent Trigger</em>}</li>
 *   <li>{@link ssm.impl.TriggerImpl#getParentAction <em>Parent Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TriggerImpl extends EObjectImpl implements Trigger {
	/**
	 * The cached value of the '{@link #getSubTriggers() <em>Sub Triggers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubTriggers()
	 * @generated
	 * @ordered
	 */
	protected EList<Trigger> subTriggers;

	/**
	 * The cached value of the '{@link #getLiterals() <em>Literals</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<Signal> literals;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected Operator operator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TriggerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ssmPackage.Literals.TRIGGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Trigger> getSubTriggers() {
		if (subTriggers == null) {
			subTriggers = new EObjectContainmentWithInverseEList<Trigger>(Trigger.class, this, ssmPackage.TRIGGER__SUB_TRIGGERS, ssmPackage.TRIGGER__PARENT_TRIGGER);
		}
		return subTriggers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Signal> getLiterals() {
		if (literals == null) {
			literals = new EObjectResolvingEList<Signal>(Signal.class, this, ssmPackage.TRIGGER__LITERALS);
		}
		return literals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperator(Operator newOperator, NotificationChain msgs) {
		Operator oldOperator = operator;
		operator = newOperator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ssmPackage.TRIGGER__OPERATOR, oldOperator, newOperator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(Operator newOperator) {
		if (newOperator != operator) {
			NotificationChain msgs = null;
			if (operator != null)
				msgs = ((InternalEObject)operator).eInverseRemove(this, ssmPackage.OPERATOR__PARENT_TRIGGER, Operator.class, msgs);
			if (newOperator != null)
				msgs = ((InternalEObject)newOperator).eInverseAdd(this, ssmPackage.OPERATOR__PARENT_TRIGGER, Operator.class, msgs);
			msgs = basicSetOperator(newOperator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRIGGER__OPERATOR, newOperator, newOperator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trigger getParentTrigger() {
		if (eContainerFeatureID != ssmPackage.TRIGGER__PARENT_TRIGGER) return null;
		return (Trigger)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentTrigger(Trigger newParentTrigger, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentTrigger, ssmPackage.TRIGGER__PARENT_TRIGGER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentTrigger(Trigger newParentTrigger) {
		if (newParentTrigger != eInternalContainer() || (eContainerFeatureID != ssmPackage.TRIGGER__PARENT_TRIGGER && newParentTrigger != null)) {
			if (EcoreUtil.isAncestor(this, newParentTrigger))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentTrigger != null)
				msgs = ((InternalEObject)newParentTrigger).eInverseAdd(this, ssmPackage.TRIGGER__SUB_TRIGGERS, Trigger.class, msgs);
			msgs = basicSetParentTrigger(newParentTrigger, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRIGGER__PARENT_TRIGGER, newParentTrigger, newParentTrigger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getParentAction() {
		if (eContainerFeatureID != ssmPackage.TRIGGER__PARENT_ACTION) return null;
		return (Action)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentAction(Action newParentAction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentAction, ssmPackage.TRIGGER__PARENT_ACTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAction(Action newParentAction) {
		if (newParentAction != eInternalContainer() || (eContainerFeatureID != ssmPackage.TRIGGER__PARENT_ACTION && newParentAction != null)) {
			if (EcoreUtil.isAncestor(this, newParentAction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentAction != null)
				msgs = ((InternalEObject)newParentAction).eInverseAdd(this, ssmPackage.ACTION__TRIGGER, Action.class, msgs);
			msgs = basicSetParentAction(newParentAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRIGGER__PARENT_ACTION, newParentAction, newParentAction));
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
			case ssmPackage.TRIGGER__SUB_TRIGGERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubTriggers()).basicAdd(otherEnd, msgs);
			case ssmPackage.TRIGGER__OPERATOR:
				if (operator != null)
					msgs = ((InternalEObject)operator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ssmPackage.TRIGGER__OPERATOR, null, msgs);
				return basicSetOperator((Operator)otherEnd, msgs);
			case ssmPackage.TRIGGER__PARENT_TRIGGER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentTrigger((Trigger)otherEnd, msgs);
			case ssmPackage.TRIGGER__PARENT_ACTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentAction((Action)otherEnd, msgs);
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
			case ssmPackage.TRIGGER__SUB_TRIGGERS:
				return ((InternalEList<?>)getSubTriggers()).basicRemove(otherEnd, msgs);
			case ssmPackage.TRIGGER__OPERATOR:
				return basicSetOperator(null, msgs);
			case ssmPackage.TRIGGER__PARENT_TRIGGER:
				return basicSetParentTrigger(null, msgs);
			case ssmPackage.TRIGGER__PARENT_ACTION:
				return basicSetParentAction(null, msgs);
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
			case ssmPackage.TRIGGER__PARENT_TRIGGER:
				return eInternalContainer().eInverseRemove(this, ssmPackage.TRIGGER__SUB_TRIGGERS, Trigger.class, msgs);
			case ssmPackage.TRIGGER__PARENT_ACTION:
				return eInternalContainer().eInverseRemove(this, ssmPackage.ACTION__TRIGGER, Action.class, msgs);
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
			case ssmPackage.TRIGGER__SUB_TRIGGERS:
				return getSubTriggers();
			case ssmPackage.TRIGGER__LITERALS:
				return getLiterals();
			case ssmPackage.TRIGGER__OPERATOR:
				return getOperator();
			case ssmPackage.TRIGGER__PARENT_TRIGGER:
				return getParentTrigger();
			case ssmPackage.TRIGGER__PARENT_ACTION:
				return getParentAction();
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
			case ssmPackage.TRIGGER__SUB_TRIGGERS:
				getSubTriggers().clear();
				getSubTriggers().addAll((Collection<? extends Trigger>)newValue);
				return;
			case ssmPackage.TRIGGER__LITERALS:
				getLiterals().clear();
				getLiterals().addAll((Collection<? extends Signal>)newValue);
				return;
			case ssmPackage.TRIGGER__OPERATOR:
				setOperator((Operator)newValue);
				return;
			case ssmPackage.TRIGGER__PARENT_TRIGGER:
				setParentTrigger((Trigger)newValue);
				return;
			case ssmPackage.TRIGGER__PARENT_ACTION:
				setParentAction((Action)newValue);
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
			case ssmPackage.TRIGGER__SUB_TRIGGERS:
				getSubTriggers().clear();
				return;
			case ssmPackage.TRIGGER__LITERALS:
				getLiterals().clear();
				return;
			case ssmPackage.TRIGGER__OPERATOR:
				setOperator((Operator)null);
				return;
			case ssmPackage.TRIGGER__PARENT_TRIGGER:
				setParentTrigger((Trigger)null);
				return;
			case ssmPackage.TRIGGER__PARENT_ACTION:
				setParentAction((Action)null);
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
			case ssmPackage.TRIGGER__SUB_TRIGGERS:
				return subTriggers != null && !subTriggers.isEmpty();
			case ssmPackage.TRIGGER__LITERALS:
				return literals != null && !literals.isEmpty();
			case ssmPackage.TRIGGER__OPERATOR:
				return operator != null;
			case ssmPackage.TRIGGER__PARENT_TRIGGER:
				return getParentTrigger() != null;
			case ssmPackage.TRIGGER__PARENT_ACTION:
				return getParentAction() != null;
		}
		return super.eIsSet(featureID);
	}

} //TriggerImpl
