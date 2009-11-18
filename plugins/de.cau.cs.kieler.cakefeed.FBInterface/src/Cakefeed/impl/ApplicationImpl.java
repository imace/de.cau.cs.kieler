/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed.impl;

import Cakefeed.Application;
import Cakefeed.CakefeedPackage;
import Cakefeed.Connection;
import Cakefeed.FunctionBlockInstance;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Cakefeed.impl.ApplicationImpl#getApplicationName <em>Application Name</em>}</li>
 *   <li>{@link Cakefeed.impl.ApplicationImpl#getFunctionBlocksInstances <em>Function Blocks Instances</em>}</li>
 *   <li>{@link Cakefeed.impl.ApplicationImpl#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicationImpl extends EObjectImpl implements Application {
	/**
	 * The default value of the '{@link #getApplicationName() <em>Application Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationName()
	 * @generated
	 * @ordered
	 */
	protected static final String APPLICATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApplicationName() <em>Application Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationName()
	 * @generated
	 * @ordered
	 */
	protected String applicationName = APPLICATION_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFunctionBlocksInstances() <em>Function Blocks Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionBlocksInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionBlockInstance> functionBlocksInstances;

	/**
	 * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<Connection> connections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicationName(String newApplicationName) {
		String oldApplicationName = applicationName;
		applicationName = newApplicationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.APPLICATION__APPLICATION_NAME, oldApplicationName, applicationName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionBlockInstance> getFunctionBlocksInstances() {
		if (functionBlocksInstances == null) {
			functionBlocksInstances = new EObjectContainmentWithInverseEList<FunctionBlockInstance>(FunctionBlockInstance.class, this, CakefeedPackage.APPLICATION__FUNCTION_BLOCKS_INSTANCES, CakefeedPackage.FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION);
		}
		return functionBlocksInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Connection> getConnections() {
		if (connections == null) {
			connections = new EObjectContainmentWithInverseEList<Connection>(Connection.class, this, CakefeedPackage.APPLICATION__CONNECTIONS, CakefeedPackage.CONNECTION__PARENT_APPLICATION);
		}
		return connections;
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
			case CakefeedPackage.APPLICATION__FUNCTION_BLOCKS_INSTANCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFunctionBlocksInstances()).basicAdd(otherEnd, msgs);
			case CakefeedPackage.APPLICATION__CONNECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnections()).basicAdd(otherEnd, msgs);
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
			case CakefeedPackage.APPLICATION__FUNCTION_BLOCKS_INSTANCES:
				return ((InternalEList<?>)getFunctionBlocksInstances()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.APPLICATION__CONNECTIONS:
				return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.APPLICATION__APPLICATION_NAME:
				return getApplicationName();
			case CakefeedPackage.APPLICATION__FUNCTION_BLOCKS_INSTANCES:
				return getFunctionBlocksInstances();
			case CakefeedPackage.APPLICATION__CONNECTIONS:
				return getConnections();
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
			case CakefeedPackage.APPLICATION__APPLICATION_NAME:
				setApplicationName((String)newValue);
				return;
			case CakefeedPackage.APPLICATION__FUNCTION_BLOCKS_INSTANCES:
				getFunctionBlocksInstances().clear();
				getFunctionBlocksInstances().addAll((Collection<? extends FunctionBlockInstance>)newValue);
				return;
			case CakefeedPackage.APPLICATION__CONNECTIONS:
				getConnections().clear();
				getConnections().addAll((Collection<? extends Connection>)newValue);
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
			case CakefeedPackage.APPLICATION__APPLICATION_NAME:
				setApplicationName(APPLICATION_NAME_EDEFAULT);
				return;
			case CakefeedPackage.APPLICATION__FUNCTION_BLOCKS_INSTANCES:
				getFunctionBlocksInstances().clear();
				return;
			case CakefeedPackage.APPLICATION__CONNECTIONS:
				getConnections().clear();
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
			case CakefeedPackage.APPLICATION__APPLICATION_NAME:
				return APPLICATION_NAME_EDEFAULT == null ? applicationName != null : !APPLICATION_NAME_EDEFAULT.equals(applicationName);
			case CakefeedPackage.APPLICATION__FUNCTION_BLOCKS_INSTANCES:
				return functionBlocksInstances != null && !functionBlocksInstances.isEmpty();
			case CakefeedPackage.APPLICATION__CONNECTIONS:
				return connections != null && !connections.isEmpty();
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
		result.append(" (applicationName: ");
		result.append(applicationName);
		result.append(')');
		return result.toString();
	}

} //ApplicationImpl
