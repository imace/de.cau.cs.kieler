/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.AdapterConnection;
import de.cau.cs.kieler.cakefeed.CFBType;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.DataConnection;
import de.cau.cs.kieler.cakefeed.EventConnection;
import de.cau.cs.kieler.cakefeed.FB;
import de.cau.cs.kieler.cakefeed.FBNetwork;
import de.cau.cs.kieler.cakefeed.Service;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CFB Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.CFBTypeImpl#getFBs <em>FBs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.CFBTypeImpl#getEventConnections <em>Event Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.CFBTypeImpl#getDataConnections <em>Data Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.CFBTypeImpl#getAdapterConnections <em>Adapter Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.CFBTypeImpl#getService <em>Service</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CFBTypeImpl extends FBTypeImpl implements CFBType {
	/**
	 * The cached value of the '{@link #getFBs() <em>FBs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFBs()
	 * @generated
	 * @ordered
	 */
	protected EList<FB> fBs;

	/**
	 * The cached value of the '{@link #getEventConnections() <em>Event Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<EventConnection> eventConnections;

	/**
	 * The cached value of the '{@link #getDataConnections() <em>Data Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<DataConnection> dataConnections;

	/**
	 * The cached value of the '{@link #getAdapterConnections() <em>Adapter Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdapterConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<AdapterConnection> adapterConnections;

	/**
	 * The cached value of the '{@link #getService() <em>Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected Service service;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CFBTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.CFB_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FB> getFBs() {
		if (fBs == null) {
			fBs = new EObjectContainmentEList<FB>(FB.class, this, CakefeedPackage.CFB_TYPE__FBS);
		}
		return fBs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventConnection> getEventConnections() {
		if (eventConnections == null) {
			eventConnections = new EObjectContainmentEList<EventConnection>(EventConnection.class, this, CakefeedPackage.CFB_TYPE__EVENT_CONNECTIONS);
		}
		return eventConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataConnection> getDataConnections() {
		if (dataConnections == null) {
			dataConnections = new EObjectContainmentEList<DataConnection>(DataConnection.class, this, CakefeedPackage.CFB_TYPE__DATA_CONNECTIONS);
		}
		return dataConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AdapterConnection> getAdapterConnections() {
		if (adapterConnections == null) {
			adapterConnections = new EObjectContainmentEList<AdapterConnection>(AdapterConnection.class, this, CakefeedPackage.CFB_TYPE__ADAPTER_CONNECTIONS);
		}
		return adapterConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service getService() {
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetService(Service newService, NotificationChain msgs) {
		Service oldService = service;
		service = newService;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.CFB_TYPE__SERVICE, oldService, newService);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setService(Service newService) {
		if (newService != service) {
			NotificationChain msgs = null;
			if (service != null)
				msgs = ((InternalEObject)service).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.CFB_TYPE__SERVICE, null, msgs);
			if (newService != null)
				msgs = ((InternalEObject)newService).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.CFB_TYPE__SERVICE, null, msgs);
			msgs = basicSetService(newService, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.CFB_TYPE__SERVICE, newService, newService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.CFB_TYPE__FBS:
				return ((InternalEList<?>)getFBs()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.CFB_TYPE__EVENT_CONNECTIONS:
				return ((InternalEList<?>)getEventConnections()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.CFB_TYPE__DATA_CONNECTIONS:
				return ((InternalEList<?>)getDataConnections()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.CFB_TYPE__ADAPTER_CONNECTIONS:
				return ((InternalEList<?>)getAdapterConnections()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.CFB_TYPE__SERVICE:
				return basicSetService(null, msgs);
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
			case CakefeedPackage.CFB_TYPE__FBS:
				return getFBs();
			case CakefeedPackage.CFB_TYPE__EVENT_CONNECTIONS:
				return getEventConnections();
			case CakefeedPackage.CFB_TYPE__DATA_CONNECTIONS:
				return getDataConnections();
			case CakefeedPackage.CFB_TYPE__ADAPTER_CONNECTIONS:
				return getAdapterConnections();
			case CakefeedPackage.CFB_TYPE__SERVICE:
				return getService();
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
			case CakefeedPackage.CFB_TYPE__FBS:
				getFBs().clear();
				getFBs().addAll((Collection<? extends FB>)newValue);
				return;
			case CakefeedPackage.CFB_TYPE__EVENT_CONNECTIONS:
				getEventConnections().clear();
				getEventConnections().addAll((Collection<? extends EventConnection>)newValue);
				return;
			case CakefeedPackage.CFB_TYPE__DATA_CONNECTIONS:
				getDataConnections().clear();
				getDataConnections().addAll((Collection<? extends DataConnection>)newValue);
				return;
			case CakefeedPackage.CFB_TYPE__ADAPTER_CONNECTIONS:
				getAdapterConnections().clear();
				getAdapterConnections().addAll((Collection<? extends AdapterConnection>)newValue);
				return;
			case CakefeedPackage.CFB_TYPE__SERVICE:
				setService((Service)newValue);
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
			case CakefeedPackage.CFB_TYPE__FBS:
				getFBs().clear();
				return;
			case CakefeedPackage.CFB_TYPE__EVENT_CONNECTIONS:
				getEventConnections().clear();
				return;
			case CakefeedPackage.CFB_TYPE__DATA_CONNECTIONS:
				getDataConnections().clear();
				return;
			case CakefeedPackage.CFB_TYPE__ADAPTER_CONNECTIONS:
				getAdapterConnections().clear();
				return;
			case CakefeedPackage.CFB_TYPE__SERVICE:
				setService((Service)null);
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
			case CakefeedPackage.CFB_TYPE__FBS:
				return fBs != null && !fBs.isEmpty();
			case CakefeedPackage.CFB_TYPE__EVENT_CONNECTIONS:
				return eventConnections != null && !eventConnections.isEmpty();
			case CakefeedPackage.CFB_TYPE__DATA_CONNECTIONS:
				return dataConnections != null && !dataConnections.isEmpty();
			case CakefeedPackage.CFB_TYPE__ADAPTER_CONNECTIONS:
				return adapterConnections != null && !adapterConnections.isEmpty();
			case CakefeedPackage.CFB_TYPE__SERVICE:
				return service != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == FBNetwork.class) {
			switch (derivedFeatureID) {
				case CakefeedPackage.CFB_TYPE__FBS: return CakefeedPackage.FB_NETWORK__FBS;
				case CakefeedPackage.CFB_TYPE__EVENT_CONNECTIONS: return CakefeedPackage.FB_NETWORK__EVENT_CONNECTIONS;
				case CakefeedPackage.CFB_TYPE__DATA_CONNECTIONS: return CakefeedPackage.FB_NETWORK__DATA_CONNECTIONS;
				case CakefeedPackage.CFB_TYPE__ADAPTER_CONNECTIONS: return CakefeedPackage.FB_NETWORK__ADAPTER_CONNECTIONS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == FBNetwork.class) {
			switch (baseFeatureID) {
				case CakefeedPackage.FB_NETWORK__FBS: return CakefeedPackage.CFB_TYPE__FBS;
				case CakefeedPackage.FB_NETWORK__EVENT_CONNECTIONS: return CakefeedPackage.CFB_TYPE__EVENT_CONNECTIONS;
				case CakefeedPackage.FB_NETWORK__DATA_CONNECTIONS: return CakefeedPackage.CFB_TYPE__DATA_CONNECTIONS;
				case CakefeedPackage.FB_NETWORK__ADAPTER_CONNECTIONS: return CakefeedPackage.CFB_TYPE__ADAPTER_CONNECTIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CFBTypeImpl
