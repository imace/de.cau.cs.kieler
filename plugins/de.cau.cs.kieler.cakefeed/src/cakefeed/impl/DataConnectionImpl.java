/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.impl;

import cakefeed.Association;
import cakefeed.CakefeedPackage;
import cakefeed.DataConnection;
import cakefeed.InputDataPort;
import cakefeed.OutputDataPort;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cakefeed.impl.DataConnectionImpl#getSourceDataPort <em>Source Data Port</em>}</li>
 *   <li>{@link cakefeed.impl.DataConnectionImpl#getTargetDataPort <em>Target Data Port</em>}</li>
 *   <li>{@link cakefeed.impl.DataConnectionImpl#getAssociations <em>Associations</em>}</li>
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
	 * The cached value of the '{@link #getAssociations() <em>Associations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> associations;

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
	public EList<Association> getAssociations() {
		if (associations == null) {
			associations = new EObjectWithInverseResolvingEList.ManyInverse<Association>(Association.class, this, CakefeedPackage.DATA_CONNECTION__ASSOCIATIONS, CakefeedPackage.ASSOCIATION__ASSOCIATED_DATA_CONNECTION);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
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
			case CakefeedPackage.DATA_CONNECTION__ASSOCIATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociations()).basicAdd(otherEnd, msgs);
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
			case CakefeedPackage.DATA_CONNECTION__ASSOCIATIONS:
				return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.DATA_CONNECTION__ASSOCIATIONS:
				return getAssociations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CakefeedPackage.DATA_CONNECTION__SOURCE_DATA_PORT:
				setSourceDataPort((OutputDataPort)newValue);
				return;
			case CakefeedPackage.DATA_CONNECTION__TARGET_DATA_PORT:
				setTargetDataPort((InputDataPort)newValue);
				return;
			case CakefeedPackage.DATA_CONNECTION__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends Association>)newValue);
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
			case CakefeedPackage.DATA_CONNECTION__ASSOCIATIONS:
				getAssociations().clear();
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
			case CakefeedPackage.DATA_CONNECTION__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataConnectionImpl
