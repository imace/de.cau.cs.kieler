/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.impl;

import cakefeed.CakefeedPackage;
import cakefeed.EventConnection;
import cakefeed.InputEventPort;
import cakefeed.OutputEventPort;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cakefeed.impl.EventConnectionImpl#getSourceEventPort <em>Source Event Port</em>}</li>
 *   <li>{@link cakefeed.impl.EventConnectionImpl#getTargetEventPort <em>Target Event Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventConnectionImpl extends ConnectionImpl implements EventConnection {
	/**
	 * The cached value of the '{@link #getSourceEventPort() <em>Source Event Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceEventPort()
	 * @generated
	 * @ordered
	 */
	protected OutputEventPort sourceEventPort;

	/**
	 * The cached value of the '{@link #getTargetEventPort() <em>Target Event Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetEventPort()
	 * @generated
	 * @ordered
	 */
	protected InputEventPort targetEventPort;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.EVENT_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputEventPort getSourceEventPort() {
		if (sourceEventPort != null && sourceEventPort.eIsProxy()) {
			InternalEObject oldSourceEventPort = (InternalEObject)sourceEventPort;
			sourceEventPort = (OutputEventPort)eResolveProxy(oldSourceEventPort);
			if (sourceEventPort != oldSourceEventPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.EVENT_CONNECTION__SOURCE_EVENT_PORT, oldSourceEventPort, sourceEventPort));
			}
		}
		return sourceEventPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputEventPort basicGetSourceEventPort() {
		return sourceEventPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceEventPort(OutputEventPort newSourceEventPort, NotificationChain msgs) {
		OutputEventPort oldSourceEventPort = sourceEventPort;
		sourceEventPort = newSourceEventPort;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.EVENT_CONNECTION__SOURCE_EVENT_PORT, oldSourceEventPort, newSourceEventPort);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceEventPort(OutputEventPort newSourceEventPort) {
		if (newSourceEventPort != sourceEventPort) {
			NotificationChain msgs = null;
			if (sourceEventPort != null)
				msgs = ((InternalEObject)sourceEventPort).eInverseRemove(this, CakefeedPackage.OUTPUT_EVENT_PORT__EVENT_CONNECTIONS, OutputEventPort.class, msgs);
			if (newSourceEventPort != null)
				msgs = ((InternalEObject)newSourceEventPort).eInverseAdd(this, CakefeedPackage.OUTPUT_EVENT_PORT__EVENT_CONNECTIONS, OutputEventPort.class, msgs);
			msgs = basicSetSourceEventPort(newSourceEventPort, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.EVENT_CONNECTION__SOURCE_EVENT_PORT, newSourceEventPort, newSourceEventPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputEventPort getTargetEventPort() {
		if (targetEventPort != null && targetEventPort.eIsProxy()) {
			InternalEObject oldTargetEventPort = (InternalEObject)targetEventPort;
			targetEventPort = (InputEventPort)eResolveProxy(oldTargetEventPort);
			if (targetEventPort != oldTargetEventPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.EVENT_CONNECTION__TARGET_EVENT_PORT, oldTargetEventPort, targetEventPort));
			}
		}
		return targetEventPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputEventPort basicGetTargetEventPort() {
		return targetEventPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetEventPort(InputEventPort newTargetEventPort, NotificationChain msgs) {
		InputEventPort oldTargetEventPort = targetEventPort;
		targetEventPort = newTargetEventPort;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.EVENT_CONNECTION__TARGET_EVENT_PORT, oldTargetEventPort, newTargetEventPort);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetEventPort(InputEventPort newTargetEventPort) {
		if (newTargetEventPort != targetEventPort) {
			NotificationChain msgs = null;
			if (targetEventPort != null)
				msgs = ((InternalEObject)targetEventPort).eInverseRemove(this, CakefeedPackage.INPUT_EVENT_PORT__EVENT_CONNECTIONS, InputEventPort.class, msgs);
			if (newTargetEventPort != null)
				msgs = ((InternalEObject)newTargetEventPort).eInverseAdd(this, CakefeedPackage.INPUT_EVENT_PORT__EVENT_CONNECTIONS, InputEventPort.class, msgs);
			msgs = basicSetTargetEventPort(newTargetEventPort, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.EVENT_CONNECTION__TARGET_EVENT_PORT, newTargetEventPort, newTargetEventPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.EVENT_CONNECTION__SOURCE_EVENT_PORT:
				if (sourceEventPort != null)
					msgs = ((InternalEObject)sourceEventPort).eInverseRemove(this, CakefeedPackage.OUTPUT_EVENT_PORT__EVENT_CONNECTIONS, OutputEventPort.class, msgs);
				return basicSetSourceEventPort((OutputEventPort)otherEnd, msgs);
			case CakefeedPackage.EVENT_CONNECTION__TARGET_EVENT_PORT:
				if (targetEventPort != null)
					msgs = ((InternalEObject)targetEventPort).eInverseRemove(this, CakefeedPackage.INPUT_EVENT_PORT__EVENT_CONNECTIONS, InputEventPort.class, msgs);
				return basicSetTargetEventPort((InputEventPort)otherEnd, msgs);
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
			case CakefeedPackage.EVENT_CONNECTION__SOURCE_EVENT_PORT:
				return basicSetSourceEventPort(null, msgs);
			case CakefeedPackage.EVENT_CONNECTION__TARGET_EVENT_PORT:
				return basicSetTargetEventPort(null, msgs);
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
			case CakefeedPackage.EVENT_CONNECTION__SOURCE_EVENT_PORT:
				if (resolve) return getSourceEventPort();
				return basicGetSourceEventPort();
			case CakefeedPackage.EVENT_CONNECTION__TARGET_EVENT_PORT:
				if (resolve) return getTargetEventPort();
				return basicGetTargetEventPort();
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
			case CakefeedPackage.EVENT_CONNECTION__SOURCE_EVENT_PORT:
				setSourceEventPort((OutputEventPort)newValue);
				return;
			case CakefeedPackage.EVENT_CONNECTION__TARGET_EVENT_PORT:
				setTargetEventPort((InputEventPort)newValue);
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
			case CakefeedPackage.EVENT_CONNECTION__SOURCE_EVENT_PORT:
				setSourceEventPort((OutputEventPort)null);
				return;
			case CakefeedPackage.EVENT_CONNECTION__TARGET_EVENT_PORT:
				setTargetEventPort((InputEventPort)null);
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
			case CakefeedPackage.EVENT_CONNECTION__SOURCE_EVENT_PORT:
				return sourceEventPort != null;
			case CakefeedPackage.EVENT_CONNECTION__TARGET_EVENT_PORT:
				return targetEventPort != null;
		}
		return super.eIsSet(featureID);
	}

} //EventConnectionImpl
