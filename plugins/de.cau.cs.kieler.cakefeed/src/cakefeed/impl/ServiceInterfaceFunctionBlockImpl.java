/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.impl;

import cakefeed.CakefeedPackage;
import cakefeed.ServiceInterfaceFunctionBlock;
import cakefeed.ServiceSequence;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Interface Function Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cakefeed.impl.ServiceInterfaceFunctionBlockImpl#getServiceSequence <em>Service Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceInterfaceFunctionBlockImpl extends FunctionBlockImpl implements ServiceInterfaceFunctionBlock {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceInterfaceFunctionBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.SERVICE_INTERFACE_FUNCTION_BLOCK;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK__SERVICE_SEQUENCE, oldServiceSequence, serviceSequence));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK__SERVICE_SEQUENCE, oldServiceSequence, serviceSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK__SERVICE_SEQUENCE:
				if (resolve) return getServiceSequence();
				return basicGetServiceSequence();
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
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK__SERVICE_SEQUENCE:
				setServiceSequence((ServiceSequence)newValue);
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
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK__SERVICE_SEQUENCE:
				setServiceSequence((ServiceSequence)null);
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
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK__SERVICE_SEQUENCE:
				return serviceSequence != null;
		}
		return super.eIsSet(featureID);
	}

} //ServiceInterfaceFunctionBlockImpl
