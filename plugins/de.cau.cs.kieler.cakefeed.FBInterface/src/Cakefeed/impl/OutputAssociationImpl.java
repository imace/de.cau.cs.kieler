/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed.impl;

import Cakefeed.CakefeedPackage;
import Cakefeed.OutputAssociation;
import Cakefeed.OutputDataPort;
import Cakefeed.OutputEventPort;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Cakefeed.impl.OutputAssociationImpl#getSourceOutputEventPort <em>Source Output Event Port</em>}</li>
 *   <li>{@link Cakefeed.impl.OutputAssociationImpl#getTargetOutputDataPort <em>Target Output Data Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputAssociationImpl extends AssociationImpl implements OutputAssociation {
	/**
	 * The cached value of the '{@link #getTargetOutputDataPort() <em>Target Output Data Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetOutputDataPort()
	 * @generated
	 * @ordered
	 */
	protected OutputDataPort targetOutputDataPort;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputAssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.OUTPUT_ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputEventPort getSourceOutputEventPort() {
		if (eContainerFeatureID() != CakefeedPackage.OUTPUT_ASSOCIATION__SOURCE_OUTPUT_EVENT_PORT) return null;
		return (OutputEventPort)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceOutputEventPort(OutputEventPort newSourceOutputEventPort, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSourceOutputEventPort, CakefeedPackage.OUTPUT_ASSOCIATION__SOURCE_OUTPUT_EVENT_PORT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceOutputEventPort(OutputEventPort newSourceOutputEventPort) {
		if (newSourceOutputEventPort != eInternalContainer() || (eContainerFeatureID() != CakefeedPackage.OUTPUT_ASSOCIATION__SOURCE_OUTPUT_EVENT_PORT && newSourceOutputEventPort != null)) {
			if (EcoreUtil.isAncestor(this, newSourceOutputEventPort))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSourceOutputEventPort != null)
				msgs = ((InternalEObject)newSourceOutputEventPort).eInverseAdd(this, CakefeedPackage.OUTPUT_EVENT_PORT__OUTPUT_ASSOCIATIONS, OutputEventPort.class, msgs);
			msgs = basicSetSourceOutputEventPort(newSourceOutputEventPort, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.OUTPUT_ASSOCIATION__SOURCE_OUTPUT_EVENT_PORT, newSourceOutputEventPort, newSourceOutputEventPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputDataPort getTargetOutputDataPort() {
		if (targetOutputDataPort != null && targetOutputDataPort.eIsProxy()) {
			InternalEObject oldTargetOutputDataPort = (InternalEObject)targetOutputDataPort;
			targetOutputDataPort = (OutputDataPort)eResolveProxy(oldTargetOutputDataPort);
			if (targetOutputDataPort != oldTargetOutputDataPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.OUTPUT_ASSOCIATION__TARGET_OUTPUT_DATA_PORT, oldTargetOutputDataPort, targetOutputDataPort));
			}
		}
		return targetOutputDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputDataPort basicGetTargetOutputDataPort() {
		return targetOutputDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetOutputDataPort(OutputDataPort newTargetOutputDataPort, NotificationChain msgs) {
		OutputDataPort oldTargetOutputDataPort = targetOutputDataPort;
		targetOutputDataPort = newTargetOutputDataPort;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.OUTPUT_ASSOCIATION__TARGET_OUTPUT_DATA_PORT, oldTargetOutputDataPort, newTargetOutputDataPort);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetOutputDataPort(OutputDataPort newTargetOutputDataPort) {
		if (newTargetOutputDataPort != targetOutputDataPort) {
			NotificationChain msgs = null;
			if (targetOutputDataPort != null)
				msgs = ((InternalEObject)targetOutputDataPort).eInverseRemove(this, CakefeedPackage.OUTPUT_DATA_PORT__OUTPUT_ASSOCIATIONS, OutputDataPort.class, msgs);
			if (newTargetOutputDataPort != null)
				msgs = ((InternalEObject)newTargetOutputDataPort).eInverseAdd(this, CakefeedPackage.OUTPUT_DATA_PORT__OUTPUT_ASSOCIATIONS, OutputDataPort.class, msgs);
			msgs = basicSetTargetOutputDataPort(newTargetOutputDataPort, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.OUTPUT_ASSOCIATION__TARGET_OUTPUT_DATA_PORT, newTargetOutputDataPort, newTargetOutputDataPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.OUTPUT_ASSOCIATION__SOURCE_OUTPUT_EVENT_PORT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSourceOutputEventPort((OutputEventPort)otherEnd, msgs);
			case CakefeedPackage.OUTPUT_ASSOCIATION__TARGET_OUTPUT_DATA_PORT:
				if (targetOutputDataPort != null)
					msgs = ((InternalEObject)targetOutputDataPort).eInverseRemove(this, CakefeedPackage.OUTPUT_DATA_PORT__OUTPUT_ASSOCIATIONS, OutputDataPort.class, msgs);
				return basicSetTargetOutputDataPort((OutputDataPort)otherEnd, msgs);
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
			case CakefeedPackage.OUTPUT_ASSOCIATION__SOURCE_OUTPUT_EVENT_PORT:
				return basicSetSourceOutputEventPort(null, msgs);
			case CakefeedPackage.OUTPUT_ASSOCIATION__TARGET_OUTPUT_DATA_PORT:
				return basicSetTargetOutputDataPort(null, msgs);
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
			case CakefeedPackage.OUTPUT_ASSOCIATION__SOURCE_OUTPUT_EVENT_PORT:
				return eInternalContainer().eInverseRemove(this, CakefeedPackage.OUTPUT_EVENT_PORT__OUTPUT_ASSOCIATIONS, OutputEventPort.class, msgs);
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
			case CakefeedPackage.OUTPUT_ASSOCIATION__SOURCE_OUTPUT_EVENT_PORT:
				return getSourceOutputEventPort();
			case CakefeedPackage.OUTPUT_ASSOCIATION__TARGET_OUTPUT_DATA_PORT:
				if (resolve) return getTargetOutputDataPort();
				return basicGetTargetOutputDataPort();
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
			case CakefeedPackage.OUTPUT_ASSOCIATION__SOURCE_OUTPUT_EVENT_PORT:
				setSourceOutputEventPort((OutputEventPort)newValue);
				return;
			case CakefeedPackage.OUTPUT_ASSOCIATION__TARGET_OUTPUT_DATA_PORT:
				setTargetOutputDataPort((OutputDataPort)newValue);
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
			case CakefeedPackage.OUTPUT_ASSOCIATION__SOURCE_OUTPUT_EVENT_PORT:
				setSourceOutputEventPort((OutputEventPort)null);
				return;
			case CakefeedPackage.OUTPUT_ASSOCIATION__TARGET_OUTPUT_DATA_PORT:
				setTargetOutputDataPort((OutputDataPort)null);
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
			case CakefeedPackage.OUTPUT_ASSOCIATION__SOURCE_OUTPUT_EVENT_PORT:
				return getSourceOutputEventPort() != null;
			case CakefeedPackage.OUTPUT_ASSOCIATION__TARGET_OUTPUT_DATA_PORT:
				return targetOutputDataPort != null;
		}
		return super.eIsSet(featureID);
	}

} //OutputAssociationImpl
