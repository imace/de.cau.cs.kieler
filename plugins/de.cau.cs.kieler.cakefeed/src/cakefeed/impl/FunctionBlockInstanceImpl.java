/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.impl;

import cakefeed.Application;
import cakefeed.CakefeedPackage;
import cakefeed.FunctionBlockInstance;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Block Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cakefeed.impl.FunctionBlockInstanceImpl#getParentApplication <em>Parent Application</em>}</li>
 *   <li>{@link cakefeed.impl.FunctionBlockInstanceImpl#getInstanceName <em>Instance Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FunctionBlockInstanceImpl extends FunctionBlockImpl implements FunctionBlockInstance {
	/**
	 * The default value of the '{@link #getInstanceName() <em>Instance Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceName()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstanceName() <em>Instance Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceName()
	 * @generated
	 * @ordered
	 */
	protected String instanceName = INSTANCE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionBlockInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.FUNCTION_BLOCK_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Application getParentApplication() {
		if (eContainerFeatureID() != CakefeedPackage.FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION) return null;
		return (Application)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentApplication(Application newParentApplication, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentApplication, CakefeedPackage.FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentApplication(Application newParentApplication) {
		if (newParentApplication != eInternalContainer() || (eContainerFeatureID() != CakefeedPackage.FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION && newParentApplication != null)) {
			if (EcoreUtil.isAncestor(this, newParentApplication))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentApplication != null)
				msgs = ((InternalEObject)newParentApplication).eInverseAdd(this, CakefeedPackage.APPLICATION__FUNCTION_BLOCKS_INSTANCES, Application.class, msgs);
			msgs = basicSetParentApplication(newParentApplication, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION, newParentApplication, newParentApplication));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstanceName() {
		return instanceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceName(String newInstanceName) {
		String oldInstanceName = instanceName;
		instanceName = newInstanceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.FUNCTION_BLOCK_INSTANCE__INSTANCE_NAME, oldInstanceName, instanceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentApplication((Application)otherEnd, msgs);
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
			case CakefeedPackage.FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION:
				return basicSetParentApplication(null, msgs);
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
			case CakefeedPackage.FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION:
				return eInternalContainer().eInverseRemove(this, CakefeedPackage.APPLICATION__FUNCTION_BLOCKS_INSTANCES, Application.class, msgs);
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
			case CakefeedPackage.FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION:
				return getParentApplication();
			case CakefeedPackage.FUNCTION_BLOCK_INSTANCE__INSTANCE_NAME:
				return getInstanceName();
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
			case CakefeedPackage.FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION:
				setParentApplication((Application)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK_INSTANCE__INSTANCE_NAME:
				setInstanceName((String)newValue);
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
			case CakefeedPackage.FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION:
				setParentApplication((Application)null);
				return;
			case CakefeedPackage.FUNCTION_BLOCK_INSTANCE__INSTANCE_NAME:
				setInstanceName(INSTANCE_NAME_EDEFAULT);
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
			case CakefeedPackage.FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION:
				return getParentApplication() != null;
			case CakefeedPackage.FUNCTION_BLOCK_INSTANCE__INSTANCE_NAME:
				return INSTANCE_NAME_EDEFAULT == null ? instanceName != null : !INSTANCE_NAME_EDEFAULT.equals(instanceName);
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
		result.append(" (instanceName: ");
		result.append(instanceName);
		result.append(')');
		return result.toString();
	}

} //FunctionBlockInstanceImpl
