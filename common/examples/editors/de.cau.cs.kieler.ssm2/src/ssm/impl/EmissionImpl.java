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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import ssm.Action;
import ssm.Emission;
import ssm.Signal;
import ssm.Value;
import ssm.ssmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Emission</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ssm.impl.EmissionImpl#getNewValue <em>New Value</em>}</li>
 *   <li>{@link ssm.impl.EmissionImpl#getSignal <em>Signal</em>}</li>
 *   <li>{@link ssm.impl.EmissionImpl#getParentAction <em>Parent Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmissionImpl extends EObjectImpl implements Emission {
	/**
	 * The cached value of the '{@link #getNewValue() <em>New Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected Value newValue;

	/**
	 * The cached value of the '{@link #getSignal() <em>Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignal()
	 * @generated
	 * @ordered
	 */
	protected Signal signal;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmissionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ssmPackage.Literals.EMISSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value getNewValue() {
		return newValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNewValue(Value newNewValue, NotificationChain msgs) {
		Value oldNewValue = newValue;
		newValue = newNewValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ssmPackage.EMISSION__NEW_VALUE, oldNewValue, newNewValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewValue(Value newNewValue) {
		if (newNewValue != newValue) {
			NotificationChain msgs = null;
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseRemove(this, ssmPackage.VALUE__PARENT_EMISSON, Value.class, msgs);
			if (newNewValue != null)
				msgs = ((InternalEObject)newNewValue).eInverseAdd(this, ssmPackage.VALUE__PARENT_EMISSON, Value.class, msgs);
			msgs = basicSetNewValue(newNewValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.EMISSION__NEW_VALUE, newNewValue, newNewValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal getSignal() {
		if (signal != null && signal.eIsProxy()) {
			InternalEObject oldSignal = (InternalEObject)signal;
			signal = (Signal)eResolveProxy(oldSignal);
			if (signal != oldSignal) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ssmPackage.EMISSION__SIGNAL, oldSignal, signal));
			}
		}
		return signal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal basicGetSignal() {
		return signal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignal(Signal newSignal) {
		Signal oldSignal = signal;
		signal = newSignal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.EMISSION__SIGNAL, oldSignal, signal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getParentAction() {
		if (eContainerFeatureID != ssmPackage.EMISSION__PARENT_ACTION) return null;
		return (Action)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentAction(Action newParentAction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentAction, ssmPackage.EMISSION__PARENT_ACTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAction(Action newParentAction) {
		if (newParentAction != eInternalContainer() || (eContainerFeatureID != ssmPackage.EMISSION__PARENT_ACTION && newParentAction != null)) {
			if (EcoreUtil.isAncestor(this, newParentAction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentAction != null)
				msgs = ((InternalEObject)newParentAction).eInverseAdd(this, ssmPackage.ACTION__EFFECTS, Action.class, msgs);
			msgs = basicSetParentAction(newParentAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.EMISSION__PARENT_ACTION, newParentAction, newParentAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ssmPackage.EMISSION__NEW_VALUE:
				if (newValue != null)
					msgs = ((InternalEObject)newValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ssmPackage.EMISSION__NEW_VALUE, null, msgs);
				return basicSetNewValue((Value)otherEnd, msgs);
			case ssmPackage.EMISSION__PARENT_ACTION:
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
			case ssmPackage.EMISSION__NEW_VALUE:
				return basicSetNewValue(null, msgs);
			case ssmPackage.EMISSION__PARENT_ACTION:
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
			case ssmPackage.EMISSION__PARENT_ACTION:
				return eInternalContainer().eInverseRemove(this, ssmPackage.ACTION__EFFECTS, Action.class, msgs);
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
			case ssmPackage.EMISSION__NEW_VALUE:
				return getNewValue();
			case ssmPackage.EMISSION__SIGNAL:
				if (resolve) return getSignal();
				return basicGetSignal();
			case ssmPackage.EMISSION__PARENT_ACTION:
				return getParentAction();
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
			case ssmPackage.EMISSION__NEW_VALUE:
				setNewValue((Value)newValue);
				return;
			case ssmPackage.EMISSION__SIGNAL:
				setSignal((Signal)newValue);
				return;
			case ssmPackage.EMISSION__PARENT_ACTION:
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
			case ssmPackage.EMISSION__NEW_VALUE:
				setNewValue((Value)null);
				return;
			case ssmPackage.EMISSION__SIGNAL:
				setSignal((Signal)null);
				return;
			case ssmPackage.EMISSION__PARENT_ACTION:
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
			case ssmPackage.EMISSION__NEW_VALUE:
				return newValue != null;
			case ssmPackage.EMISSION__SIGNAL:
				return signal != null;
			case ssmPackage.EMISSION__PARENT_ACTION:
				return getParentAction() != null;
		}
		return super.eIsSet(featureID);
	}

} //EmissionImpl
