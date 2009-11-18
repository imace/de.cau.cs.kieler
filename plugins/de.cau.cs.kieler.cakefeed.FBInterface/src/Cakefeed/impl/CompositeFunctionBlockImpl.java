/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed.impl;

import Cakefeed.CakefeedPackage;
import Cakefeed.CompositeFunctionBlock;
import Cakefeed.CompositeNetwork;
import Cakefeed.ServiceSequence;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Function Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Cakefeed.impl.CompositeFunctionBlockImpl#getCompositeNetwork <em>Composite Network</em>}</li>
 *   <li>{@link Cakefeed.impl.CompositeFunctionBlockImpl#getServiceSequence <em>Service Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeFunctionBlockImpl extends FunctionBlockImpl implements CompositeFunctionBlock {
	/**
	 * The cached value of the '{@link #getCompositeNetwork() <em>Composite Network</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeNetwork()
	 * @generated
	 * @ordered
	 */
	protected CompositeNetwork compositeNetwork;

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
	protected CompositeFunctionBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.COMPOSITE_FUNCTION_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeNetwork getCompositeNetwork() {
		return compositeNetwork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompositeNetwork(CompositeNetwork newCompositeNetwork, NotificationChain msgs) {
		CompositeNetwork oldCompositeNetwork = compositeNetwork;
		compositeNetwork = newCompositeNetwork;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK, oldCompositeNetwork, newCompositeNetwork);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositeNetwork(CompositeNetwork newCompositeNetwork) {
		if (newCompositeNetwork != compositeNetwork) {
			NotificationChain msgs = null;
			if (compositeNetwork != null)
				msgs = ((InternalEObject)compositeNetwork).eInverseRemove(this, CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK, CompositeNetwork.class, msgs);
			if (newCompositeNetwork != null)
				msgs = ((InternalEObject)newCompositeNetwork).eInverseAdd(this, CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK, CompositeNetwork.class, msgs);
			msgs = basicSetCompositeNetwork(newCompositeNetwork, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK, newCompositeNetwork, newCompositeNetwork));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__SERVICE_SEQUENCE, oldServiceSequence, serviceSequence));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__SERVICE_SEQUENCE, oldServiceSequence, serviceSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK:
				if (compositeNetwork != null)
					msgs = ((InternalEObject)compositeNetwork).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK, null, msgs);
				return basicSetCompositeNetwork((CompositeNetwork)otherEnd, msgs);
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
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK:
				return basicSetCompositeNetwork(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK:
				return getCompositeNetwork();
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__SERVICE_SEQUENCE:
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
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK:
				setCompositeNetwork((CompositeNetwork)newValue);
				return;
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__SERVICE_SEQUENCE:
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
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK:
				setCompositeNetwork((CompositeNetwork)null);
				return;
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__SERVICE_SEQUENCE:
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
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK:
				return compositeNetwork != null;
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__SERVICE_SEQUENCE:
				return serviceSequence != null;
		}
		return super.eIsSet(featureID);
	}

} //CompositeFunctionBlockImpl
