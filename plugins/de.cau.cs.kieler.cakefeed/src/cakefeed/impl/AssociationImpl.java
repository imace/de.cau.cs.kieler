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
import cakefeed.EventConnection;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cakefeed.impl.AssociationImpl#getParentEventConnection <em>Parent Event Connection</em>}</li>
 *   <li>{@link cakefeed.impl.AssociationImpl#getAssociatedDataConnection <em>Associated Data Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationImpl extends EObjectImpl implements Association {
	/**
	 * The cached value of the '{@link #getAssociatedDataConnection() <em>Associated Data Connection</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedDataConnection()
	 * @generated
	 * @ordered
	 */
	protected EList<DataConnection> associatedDataConnection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventConnection getParentEventConnection() {
		if (eContainerFeatureID() != CakefeedPackage.ASSOCIATION__PARENT_EVENT_CONNECTION) return null;
		return (EventConnection)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentEventConnection(EventConnection newParentEventConnection, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentEventConnection, CakefeedPackage.ASSOCIATION__PARENT_EVENT_CONNECTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentEventConnection(EventConnection newParentEventConnection) {
		if (newParentEventConnection != eInternalContainer() || (eContainerFeatureID() != CakefeedPackage.ASSOCIATION__PARENT_EVENT_CONNECTION && newParentEventConnection != null)) {
			if (EcoreUtil.isAncestor(this, newParentEventConnection))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentEventConnection != null)
				msgs = ((InternalEObject)newParentEventConnection).eInverseAdd(this, CakefeedPackage.EVENT_CONNECTION__ASSOCIATIONS, EventConnection.class, msgs);
			msgs = basicSetParentEventConnection(newParentEventConnection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.ASSOCIATION__PARENT_EVENT_CONNECTION, newParentEventConnection, newParentEventConnection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataConnection> getAssociatedDataConnection() {
		if (associatedDataConnection == null) {
			associatedDataConnection = new EObjectWithInverseResolvingEList.ManyInverse<DataConnection>(DataConnection.class, this, CakefeedPackage.ASSOCIATION__ASSOCIATED_DATA_CONNECTION, CakefeedPackage.DATA_CONNECTION__ASSOCIATIONS);
		}
		return associatedDataConnection;
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
			case CakefeedPackage.ASSOCIATION__PARENT_EVENT_CONNECTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentEventConnection((EventConnection)otherEnd, msgs);
			case CakefeedPackage.ASSOCIATION__ASSOCIATED_DATA_CONNECTION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociatedDataConnection()).basicAdd(otherEnd, msgs);
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
			case CakefeedPackage.ASSOCIATION__PARENT_EVENT_CONNECTION:
				return basicSetParentEventConnection(null, msgs);
			case CakefeedPackage.ASSOCIATION__ASSOCIATED_DATA_CONNECTION:
				return ((InternalEList<?>)getAssociatedDataConnection()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.ASSOCIATION__PARENT_EVENT_CONNECTION:
				return eInternalContainer().eInverseRemove(this, CakefeedPackage.EVENT_CONNECTION__ASSOCIATIONS, EventConnection.class, msgs);
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
			case CakefeedPackage.ASSOCIATION__PARENT_EVENT_CONNECTION:
				return getParentEventConnection();
			case CakefeedPackage.ASSOCIATION__ASSOCIATED_DATA_CONNECTION:
				return getAssociatedDataConnection();
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
			case CakefeedPackage.ASSOCIATION__PARENT_EVENT_CONNECTION:
				setParentEventConnection((EventConnection)newValue);
				return;
			case CakefeedPackage.ASSOCIATION__ASSOCIATED_DATA_CONNECTION:
				getAssociatedDataConnection().clear();
				getAssociatedDataConnection().addAll((Collection<? extends DataConnection>)newValue);
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
			case CakefeedPackage.ASSOCIATION__PARENT_EVENT_CONNECTION:
				setParentEventConnection((EventConnection)null);
				return;
			case CakefeedPackage.ASSOCIATION__ASSOCIATED_DATA_CONNECTION:
				getAssociatedDataConnection().clear();
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
			case CakefeedPackage.ASSOCIATION__PARENT_EVENT_CONNECTION:
				return getParentEventConnection() != null;
			case CakefeedPackage.ASSOCIATION__ASSOCIATED_DATA_CONNECTION:
				return associatedDataConnection != null && !associatedDataConnection.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AssociationImpl
