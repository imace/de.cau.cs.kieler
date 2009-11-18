/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed.impl;

import Cakefeed.CakefeedPackage;
import Cakefeed.ServiceInterfaceFunctionBlock;
import Cakefeed.ServiceInterfaceFunctionBlockInstance;
import Cakefeed.ServiceSequence;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Interface Function Block Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Cakefeed.impl.ServiceInterfaceFunctionBlockInstanceImpl#getServiceSequence <em>Service Sequence</em>}</li>
 *   <li>{@link Cakefeed.impl.ServiceInterfaceFunctionBlockInstanceImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceInterfaceFunctionBlockInstanceImpl extends FunctionBlockInstanceImpl implements ServiceInterfaceFunctionBlockInstance {
	/**
	 * The cached value of the '{@link #getServiceSequence() <em>Service Sequence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceSequence()
	 * @generated
	 * @ordered
	 */
	protected ServiceSequence serviceSequence;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ServiceInterfaceFunctionBlock type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceInterfaceFunctionBlockInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceSequence getServiceSequence() {
		if (serviceSequence != null && serviceSequence.eIsProxy()) {
			InternalEObject oldServiceSequence = (InternalEObject)serviceSequence;
			serviceSequence = (ServiceSequence)eResolveProxy(oldServiceSequence);
			if (serviceSequence != oldServiceSequence) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__SERVICE_SEQUENCE, oldServiceSequence, serviceSequence));
			}
		}
		return serviceSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceSequence basicGetServiceSequence() {
		return serviceSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceSequence(ServiceSequence newServiceSequence) {
		ServiceSequence oldServiceSequence = serviceSequence;
		serviceSequence = newServiceSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__SERVICE_SEQUENCE, oldServiceSequence, serviceSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceInterfaceFunctionBlock getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (ServiceInterfaceFunctionBlock)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceInterfaceFunctionBlock basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ServiceInterfaceFunctionBlock newType) {
		ServiceInterfaceFunctionBlock oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__SERVICE_SEQUENCE:
				if (resolve) return getServiceSequence();
				return basicGetServiceSequence();
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__SERVICE_SEQUENCE:
				setServiceSequence((ServiceSequence)newValue);
				return;
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__TYPE:
				setType((ServiceInterfaceFunctionBlock)newValue);
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
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__SERVICE_SEQUENCE:
				setServiceSequence((ServiceSequence)null);
				return;
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__TYPE:
				setType((ServiceInterfaceFunctionBlock)null);
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
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__SERVICE_SEQUENCE:
				return serviceSequence != null;
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ServiceInterfaceFunctionBlock.class) {
			switch (derivedFeatureID) {
				case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__SERVICE_SEQUENCE: return CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK__SERVICE_SEQUENCE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ServiceInterfaceFunctionBlock.class) {
			switch (baseFeatureID) {
				case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK__SERVICE_SEQUENCE: return CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__SERVICE_SEQUENCE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ServiceInterfaceFunctionBlockInstanceImpl
