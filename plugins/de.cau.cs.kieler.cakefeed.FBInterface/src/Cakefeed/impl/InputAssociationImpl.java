/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed.impl;

import Cakefeed.CakefeedPackage;
import Cakefeed.InputAssociation;
import Cakefeed.InputDataPort;
import Cakefeed.InputEventPort;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Cakefeed.impl.InputAssociationImpl#getSourceInputEventPort <em>Source Input Event Port</em>}</li>
 *   <li>{@link Cakefeed.impl.InputAssociationImpl#getTargetInputDataPort <em>Target Input Data Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputAssociationImpl extends AssociationImpl implements InputAssociation {
	/**
	 * The cached value of the '{@link #getTargetInputDataPort() <em>Target Input Data Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetInputDataPort()
	 * @generated
	 * @ordered
	 */
	protected InputDataPort targetInputDataPort;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputAssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.INPUT_ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputEventPort getSourceInputEventPort() {
		if (eContainerFeatureID() != CakefeedPackage.INPUT_ASSOCIATION__SOURCE_INPUT_EVENT_PORT) return null;
		return (InputEventPort)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceInputEventPort(InputEventPort newSourceInputEventPort, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSourceInputEventPort, CakefeedPackage.INPUT_ASSOCIATION__SOURCE_INPUT_EVENT_PORT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceInputEventPort(InputEventPort newSourceInputEventPort) {
		if (newSourceInputEventPort != eInternalContainer() || (eContainerFeatureID() != CakefeedPackage.INPUT_ASSOCIATION__SOURCE_INPUT_EVENT_PORT && newSourceInputEventPort != null)) {
			if (EcoreUtil.isAncestor(this, newSourceInputEventPort))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSourceInputEventPort != null)
				msgs = ((InternalEObject)newSourceInputEventPort).eInverseAdd(this, CakefeedPackage.INPUT_EVENT_PORT__INPUT_ASSOCIATIONS, InputEventPort.class, msgs);
			msgs = basicSetSourceInputEventPort(newSourceInputEventPort, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.INPUT_ASSOCIATION__SOURCE_INPUT_EVENT_PORT, newSourceInputEventPort, newSourceInputEventPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputDataPort getTargetInputDataPort() {
		if (targetInputDataPort != null && targetInputDataPort.eIsProxy()) {
			InternalEObject oldTargetInputDataPort = (InternalEObject)targetInputDataPort;
			targetInputDataPort = (InputDataPort)eResolveProxy(oldTargetInputDataPort);
			if (targetInputDataPort != oldTargetInputDataPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.INPUT_ASSOCIATION__TARGET_INPUT_DATA_PORT, oldTargetInputDataPort, targetInputDataPort));
			}
		}
		return targetInputDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputDataPort basicGetTargetInputDataPort() {
		return targetInputDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetInputDataPort(InputDataPort newTargetInputDataPort, NotificationChain msgs) {
		InputDataPort oldTargetInputDataPort = targetInputDataPort;
		targetInputDataPort = newTargetInputDataPort;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.INPUT_ASSOCIATION__TARGET_INPUT_DATA_PORT, oldTargetInputDataPort, newTargetInputDataPort);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetInputDataPort(InputDataPort newTargetInputDataPort) {
		if (newTargetInputDataPort != targetInputDataPort) {
			NotificationChain msgs = null;
			if (targetInputDataPort != null)
				msgs = ((InternalEObject)targetInputDataPort).eInverseRemove(this, CakefeedPackage.INPUT_DATA_PORT__INPUT_ASSOCIATIONS, InputDataPort.class, msgs);
			if (newTargetInputDataPort != null)
				msgs = ((InternalEObject)newTargetInputDataPort).eInverseAdd(this, CakefeedPackage.INPUT_DATA_PORT__INPUT_ASSOCIATIONS, InputDataPort.class, msgs);
			msgs = basicSetTargetInputDataPort(newTargetInputDataPort, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.INPUT_ASSOCIATION__TARGET_INPUT_DATA_PORT, newTargetInputDataPort, newTargetInputDataPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.INPUT_ASSOCIATION__SOURCE_INPUT_EVENT_PORT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSourceInputEventPort((InputEventPort)otherEnd, msgs);
			case CakefeedPackage.INPUT_ASSOCIATION__TARGET_INPUT_DATA_PORT:
				if (targetInputDataPort != null)
					msgs = ((InternalEObject)targetInputDataPort).eInverseRemove(this, CakefeedPackage.INPUT_DATA_PORT__INPUT_ASSOCIATIONS, InputDataPort.class, msgs);
				return basicSetTargetInputDataPort((InputDataPort)otherEnd, msgs);
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
			case CakefeedPackage.INPUT_ASSOCIATION__SOURCE_INPUT_EVENT_PORT:
				return basicSetSourceInputEventPort(null, msgs);
			case CakefeedPackage.INPUT_ASSOCIATION__TARGET_INPUT_DATA_PORT:
				return basicSetTargetInputDataPort(null, msgs);
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
		switch (eContainerFeatureID()) {
			case CakefeedPackage.INPUT_ASSOCIATION__SOURCE_INPUT_EVENT_PORT:
				return eInternalContainer().eInverseRemove(this, CakefeedPackage.INPUT_EVENT_PORT__INPUT_ASSOCIATIONS, InputEventPort.class, msgs);
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
			case CakefeedPackage.INPUT_ASSOCIATION__SOURCE_INPUT_EVENT_PORT:
				return getSourceInputEventPort();
			case CakefeedPackage.INPUT_ASSOCIATION__TARGET_INPUT_DATA_PORT:
				if (resolve) return getTargetInputDataPort();
				return basicGetTargetInputDataPort();
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
			case CakefeedPackage.INPUT_ASSOCIATION__SOURCE_INPUT_EVENT_PORT:
				setSourceInputEventPort((InputEventPort)newValue);
				return;
			case CakefeedPackage.INPUT_ASSOCIATION__TARGET_INPUT_DATA_PORT:
				setTargetInputDataPort((InputDataPort)newValue);
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
			case CakefeedPackage.INPUT_ASSOCIATION__SOURCE_INPUT_EVENT_PORT:
				setSourceInputEventPort((InputEventPort)null);
				return;
			case CakefeedPackage.INPUT_ASSOCIATION__TARGET_INPUT_DATA_PORT:
				setTargetInputDataPort((InputDataPort)null);
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
			case CakefeedPackage.INPUT_ASSOCIATION__SOURCE_INPUT_EVENT_PORT:
				return getSourceInputEventPort() != null;
			case CakefeedPackage.INPUT_ASSOCIATION__TARGET_INPUT_DATA_PORT:
				return targetInputDataPort != null;
		}
		return super.eIsSet(featureID);
	}

} //InputAssociationImpl
