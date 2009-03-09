/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import ssm2.Signal;
import ssm2.Ssm2Package;
import ssm2.Value;
import ssm2.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ssm2.impl.ValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link ssm2.impl.ValueImpl#getParentSignal <em>Parent Signal</em>}</li>
 *   <li>{@link ssm2.impl.ValueImpl#getParentVariable <em>Parent Variable</em>}</li>
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
		return Ssm2Package.Literals.VALUE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.VALUE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal getParentSignal() {
		if (eContainerFeatureID != Ssm2Package.VALUE__PARENT_SIGNAL) return null;
		return (Signal)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentSignal(Signal newParentSignal, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentSignal, Ssm2Package.VALUE__PARENT_SIGNAL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentSignal(Signal newParentSignal) {
		if (newParentSignal != eInternalContainer() || (eContainerFeatureID != Ssm2Package.VALUE__PARENT_SIGNAL && newParentSignal != null)) {
			if (EcoreUtil.isAncestor(this, newParentSignal))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentSignal != null)
				msgs = ((InternalEObject)newParentSignal).eInverseAdd(this, Ssm2Package.SIGNAL__VALUE, Signal.class, msgs);
			msgs = basicSetParentSignal(newParentSignal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.VALUE__PARENT_SIGNAL, newParentSignal, newParentSignal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getParentVariable() {
		if (eContainerFeatureID != Ssm2Package.VALUE__PARENT_VARIABLE) return null;
		return (Variable)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentVariable(Variable newParentVariable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentVariable, Ssm2Package.VALUE__PARENT_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentVariable(Variable newParentVariable) {
		if (newParentVariable != eInternalContainer() || (eContainerFeatureID != Ssm2Package.VALUE__PARENT_VARIABLE && newParentVariable != null)) {
			if (EcoreUtil.isAncestor(this, newParentVariable))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentVariable != null)
				msgs = ((InternalEObject)newParentVariable).eInverseAdd(this, Ssm2Package.VARIABLE__VALUE, Variable.class, msgs);
			msgs = basicSetParentVariable(newParentVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.VALUE__PARENT_VARIABLE, newParentVariable, newParentVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ssm2Package.VALUE__PARENT_SIGNAL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentSignal((Signal)otherEnd, msgs);
			case Ssm2Package.VALUE__PARENT_VARIABLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentVariable((Variable)otherEnd, msgs);
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
			case Ssm2Package.VALUE__PARENT_SIGNAL:
				return basicSetParentSignal(null, msgs);
			case Ssm2Package.VALUE__PARENT_VARIABLE:
				return basicSetParentVariable(null, msgs);
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
			case Ssm2Package.VALUE__PARENT_SIGNAL:
				return eInternalContainer().eInverseRemove(this, Ssm2Package.SIGNAL__VALUE, Signal.class, msgs);
			case Ssm2Package.VALUE__PARENT_VARIABLE:
				return eInternalContainer().eInverseRemove(this, Ssm2Package.VARIABLE__VALUE, Variable.class, msgs);
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
			case Ssm2Package.VALUE__VALUE:
				return getValue();
			case Ssm2Package.VALUE__PARENT_SIGNAL:
				return getParentSignal();
			case Ssm2Package.VALUE__PARENT_VARIABLE:
				return getParentVariable();
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
			case Ssm2Package.VALUE__VALUE:
				setValue(newValue);
				return;
			case Ssm2Package.VALUE__PARENT_SIGNAL:
				setParentSignal((Signal)newValue);
				return;
			case Ssm2Package.VALUE__PARENT_VARIABLE:
				setParentVariable((Variable)newValue);
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
			case Ssm2Package.VALUE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case Ssm2Package.VALUE__PARENT_SIGNAL:
				setParentSignal((Signal)null);
				return;
			case Ssm2Package.VALUE__PARENT_VARIABLE:
				setParentVariable((Variable)null);
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
			case Ssm2Package.VALUE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case Ssm2Package.VALUE__PARENT_SIGNAL:
				return getParentSignal() != null;
			case Ssm2Package.VALUE__PARENT_VARIABLE:
				return getParentVariable() != null;
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
