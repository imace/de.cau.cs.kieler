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

import ssm.Emission;
import ssm.Signal;
import ssm.Value;
import ssm.ssmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ssm.impl.ValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link ssm.impl.ValueImpl#getParentSignal <em>Parent Signal</em>}</li>
 *   <li>{@link ssm.impl.ValueImpl#getParentEmisson <em>Parent Emisson</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueImpl extends EObjectImpl implements Value {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Object value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ssmPackage.Literals.VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Object newValue) {
		Object oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.VALUE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal getParentSignal() {
		if (eContainerFeatureID != ssmPackage.VALUE__PARENT_SIGNAL) return null;
		return (Signal)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentSignal(Signal newParentSignal, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentSignal, ssmPackage.VALUE__PARENT_SIGNAL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentSignal(Signal newParentSignal) {
		if (newParentSignal != eInternalContainer() || (eContainerFeatureID != ssmPackage.VALUE__PARENT_SIGNAL && newParentSignal != null)) {
			if (EcoreUtil.isAncestor(this, newParentSignal))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentSignal != null)
				msgs = ((InternalEObject)newParentSignal).eInverseAdd(this, ssmPackage.SIGNAL__VALUE, Signal.class, msgs);
			msgs = basicSetParentSignal(newParentSignal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.VALUE__PARENT_SIGNAL, newParentSignal, newParentSignal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Emission getParentEmisson() {
		if (eContainerFeatureID != ssmPackage.VALUE__PARENT_EMISSON) return null;
		return (Emission)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentEmisson(Emission newParentEmisson, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentEmisson, ssmPackage.VALUE__PARENT_EMISSON, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentEmisson(Emission newParentEmisson) {
		if (newParentEmisson != eInternalContainer() || (eContainerFeatureID != ssmPackage.VALUE__PARENT_EMISSON && newParentEmisson != null)) {
			if (EcoreUtil.isAncestor(this, newParentEmisson))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentEmisson != null)
				msgs = ((InternalEObject)newParentEmisson).eInverseAdd(this, ssmPackage.EMISSION__NEW_VALUE, Emission.class, msgs);
			msgs = basicSetParentEmisson(newParentEmisson, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.VALUE__PARENT_EMISSON, newParentEmisson, newParentEmisson));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ssmPackage.VALUE__PARENT_SIGNAL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentSignal((Signal)otherEnd, msgs);
			case ssmPackage.VALUE__PARENT_EMISSON:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentEmisson((Emission)otherEnd, msgs);
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
			case ssmPackage.VALUE__PARENT_SIGNAL:
				return basicSetParentSignal(null, msgs);
			case ssmPackage.VALUE__PARENT_EMISSON:
				return basicSetParentEmisson(null, msgs);
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
			case ssmPackage.VALUE__PARENT_SIGNAL:
				return eInternalContainer().eInverseRemove(this, ssmPackage.SIGNAL__VALUE, Signal.class, msgs);
			case ssmPackage.VALUE__PARENT_EMISSON:
				return eInternalContainer().eInverseRemove(this, ssmPackage.EMISSION__NEW_VALUE, Emission.class, msgs);
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
			case ssmPackage.VALUE__VALUE:
				return getValue();
			case ssmPackage.VALUE__PARENT_SIGNAL:
				return getParentSignal();
			case ssmPackage.VALUE__PARENT_EMISSON:
				return getParentEmisson();
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
			case ssmPackage.VALUE__VALUE:
				setValue(newValue);
				return;
			case ssmPackage.VALUE__PARENT_SIGNAL:
				setParentSignal((Signal)newValue);
				return;
			case ssmPackage.VALUE__PARENT_EMISSON:
				setParentEmisson((Emission)newValue);
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
			case ssmPackage.VALUE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ssmPackage.VALUE__PARENT_SIGNAL:
				setParentSignal((Signal)null);
				return;
			case ssmPackage.VALUE__PARENT_EMISSON:
				setParentEmisson((Emission)null);
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
			case ssmPackage.VALUE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case ssmPackage.VALUE__PARENT_SIGNAL:
				return getParentSignal() != null;
			case ssmPackage.VALUE__PARENT_EMISSON:
				return getParentEmisson() != null;
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
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ValueImpl
