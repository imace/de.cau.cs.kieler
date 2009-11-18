/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed.impl;

import Cakefeed.CakefeedPackage;
import Cakefeed.DataConnection;
import Cakefeed.InputDataPort;
import Cakefeed.OutputDataPort;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Cakefeed.impl.DataConnectionImpl#getSourceDataPort <em>Source Data Port</em>}</li>
 *   <li>{@link Cakefeed.impl.DataConnectionImpl#getTargetDataPort <em>Target Data Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataConnectionImpl extends ConnectionImpl implements DataConnection {
	/**
	 * The cached value of the '{@link #getSourceDataPort() <em>Source Data Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceDataPort()
	 * @generated
	 * @ordered
	 */
	protected OutputDataPort sourceDataPort;

	/**
	 * The cached value of the '{@link #getTargetDataPort() <em>Target Data Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetDataPort()
	 * @generated
	 * @ordered
	 */
	protected InputDataPort targetDataPort;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.DATA_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputDataPort getSourceDataPort() {
		if (sourceDataPort != null && sourceDataPort.eIsProxy()) {
			InternalEObject oldSourceDataPort = (InternalEObject)sourceDataPort;
			sourceDataPort = (OutputDataPort)eResolveProxy(oldSourceDataPort);
			if (sourceDataPort != oldSourceDataPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.DATA_CONNECTION__SOURCE_DATA_PORT, oldSourceDataPort, sourceDataPort));
			}
		}
		return sourceDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputDataPort basicGetSourceDataPort() {
		return sourceDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceDataPort(OutputDataPort newSourceDataPort, NotificationChain msgs) {
		OutputDataPort oldSourceDataPort = sourceDataPort;
		sourceDataPort = newSourceDataPort;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.DATA_CONNECTION__SOURCE_DATA_PORT, oldSourceDataPort, newSourceDataPort);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceDataPort(OutputDataPort newSourceDataPort) {
		if (newSourceDataPort != sourceDataPort) {
			NotificationChain msgs = null;
			if (sourceDataPort != null)
				msgs = ((InternalEObject)sourceDataPort).eInverseRemove(this, CakefeedPackage.OUTPUT_DATA_PORT__EVENT_CONNECTIONS, OutputDataPort.class, msgs);
			if (newSourceDataPort != null)
				msgs = ((InternalEObject)newSourceDataPort).eInverseAdd(this, CakefeedPackage.OUTPUT_DATA_PORT__EVENT_CONNECTIONS, OutputDataPort.class, msgs);
			msgs = basicSetSourceDataPort(newSourceDataPort, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.DATA_CONNECTION__SOURCE_DATA_PORT, newSourceDataPort, newSourceDataPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputDataPort getTargetDataPort() {
		if (targetDataPort != null && targetDataPort.eIsProxy()) {
			InternalEObject oldTargetDataPort = (InternalEObject)targetDataPort;
			targetDataPort = (InputDataPort)eResolveProxy(oldTargetDataPort);
			if (targetDataPort != oldTargetDataPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.DATA_CONNECTION__TARGET_DATA_PORT, oldTargetDataPort, targetDataPort));
			}
		}
		return targetDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputDataPort basicGetTargetDataPort() {
		return targetDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetDataPort(InputDataPort newTargetDataPort, NotificationChain msgs) {
		InputDataPort oldTargetDataPort = targetDataPort;
		targetDataPort = newTargetDataPort;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.DATA_CONNECTION__TARGET_DATA_PORT, oldTargetDataPort, newTargetDataPort);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetDataPort(InputDataPort newTargetDataPort) {
		if (newTargetDataPort != targetDataPort) {
			NotificationChain msgs = null;
			if (targetDataPort != null)
				msgs = ((InternalEObject)targetDataPort).eInverseRemove(this, CakefeedPackage.INPUT_DATA_PORT__EVENT_CONNECTIONS, InputDataPort.class, msgs);
			if (newTargetDataPort != null)
				msgs = ((InternalEObject)newTargetDataPort).eInverseAdd(this, CakefeedPackage.INPUT_DATA_PORT__EVENT_CONNECTIONS, InputDataPort.class, msgs);
			msgs = basicSetTargetDataPort(newTargetDataPort, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.DATA_CONNECTION__TARGET_DATA_PORT, newTargetDataPort, newTargetDataPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.DATA_CONNECTION__SOURCE_DATA_PORT:
				if (sourceDataPort != null)
					msgs = ((InternalEObject)sourceDataPort).eInverseRemove(this, CakefeedPackage.OUTPUT_DATA_PORT__EVENT_CONNECTIONS, OutputDataPort.class, msgs);
				return basicSetSourceDataPort((OutputDataPort)otherEnd, msgs);
			case CakefeedPackage.DATA_CONNECTION__TARGET_DATA_PORT:
				if (targetDataPort != null)
					msgs = ((InternalEObject)targetDataPort).eInverseRemove(this, CakefeedPackage.INPUT_DATA_PORT__EVENT_CONNECTIONS, InputDataPort.class, msgs);
				return basicSetTargetDataPort((InputDataPort)otherEnd, msgs);
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
			case CakefeedPackage.DATA_CONNECTION__SOURCE_DATA_PORT:
				return basicSetSourceDataPort(null, msgs);
			case CakefeedPackage.DATA_CONNECTION__TARGET_DATA_PORT:
				return basicSetTargetDataPort(null, msgs);
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
			case CakefeedPackage.DATA_CONNECTION__SOURCE_DATA_PORT:
				if (resolve) return getSourceDataPort();
				return basicGetSourceDataPort();
			case CakefeedPackage.DATA_CONNECTION__TARGET_DATA_PORT:
				if (resolve) return getTargetDataPort();
				return basicGetTargetDataPort();
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
			case CakefeedPackage.DATA_CONNECTION__SOURCE_DATA_PORT:
				setSourceDataPort((OutputDataPort)newValue);
				return;
			case CakefeedPackage.DATA_CONNECTION__TARGET_DATA_PORT:
				setTargetDataPort((InputDataPort)newValue);
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
			case CakefeedPackage.DATA_CONNECTION__SOURCE_DATA_PORT:
				setSourceDataPort((OutputDataPort)null);
				return;
			case CakefeedPackage.DATA_CONNECTION__TARGET_DATA_PORT:
				setTargetDataPort((InputDataPort)null);
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
			case CakefeedPackage.DATA_CONNECTION__SOURCE_DATA_PORT:
				return sourceDataPort != null;
			case CakefeedPackage.DATA_CONNECTION__TARGET_DATA_PORT:
				return targetDataPort != null;
		}
		return super.eIsSet(featureID);
	}

} //DataConnectionImpl
