/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.BFBType;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.FBD;
import de.cau.cs.kieler.cakefeed.InternalVar;
import de.cau.cs.kieler.cakefeed.LD;
import de.cau.cs.kieler.cakefeed.Other;
import de.cau.cs.kieler.cakefeed.ST;
import de.cau.cs.kieler.cakefeed.Service;

import de.cau.cs.kieler.synccharts.State;

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
 * An implementation of the model object '<em><b>BFB Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BFBTypeImpl#getService <em>Service</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BFBTypeImpl#getSyncChart <em>Sync Chart</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BFBTypeImpl#getInternalVars <em>Internal Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BFBTypeImpl#getFBDs <em>FB Ds</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BFBTypeImpl#getSTs <em>STs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BFBTypeImpl#getLDs <em>LDs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BFBTypeImpl#getOtherAlgorithms <em>Other Algorithms</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BFBTypeImpl extends FBTypeImpl implements BFBType {
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
	 * The cached value of the '{@link #getSyncChart() <em>Sync Chart</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyncChart()
	 * @generated
	 * @ordered
	 */
	protected State syncChart;

	/**
	 * The cached value of the '{@link #getInternalVars() <em>Internal Vars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalVars()
	 * @generated
	 * @ordered
	 */
	protected EList<InternalVar> internalVars;

	/**
	 * The cached value of the '{@link #getFBDs() <em>FB Ds</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFBDs()
	 * @generated
	 * @ordered
	 */
	protected EList<FBD> fbDs;

	/**
	 * The cached value of the '{@link #getSTs() <em>STs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTs()
	 * @generated
	 * @ordered
	 */
	protected EList<ST> sTs;

	/**
	 * The cached value of the '{@link #getLDs() <em>LDs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLDs()
	 * @generated
	 * @ordered
	 */
	protected EList<LD> lDs;

	/**
	 * The cached value of the '{@link #getOtherAlgorithms() <em>Other Algorithms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherAlgorithms()
	 * @generated
	 * @ordered
	 */
	protected EList<Other> otherAlgorithms;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BFBTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.BFB_TYPE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.BFB_TYPE__SERVICE, oldService, newService);
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
				msgs = ((InternalEObject)service).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.BFB_TYPE__SERVICE, null, msgs);
			if (newService != null)
				msgs = ((InternalEObject)newService).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.BFB_TYPE__SERVICE, null, msgs);
			msgs = basicSetService(newService, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.BFB_TYPE__SERVICE, newService, newService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getSyncChart() {
		if (syncChart != null && syncChart.eIsProxy()) {
			InternalEObject oldSyncChart = (InternalEObject)syncChart;
			syncChart = (State)eResolveProxy(oldSyncChart);
			if (syncChart != oldSyncChart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.BFB_TYPE__SYNC_CHART, oldSyncChart, syncChart));
			}
		}
		return syncChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetSyncChart() {
		return syncChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyncChart(State newSyncChart) {
		State oldSyncChart = syncChart;
		syncChart = newSyncChart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.BFB_TYPE__SYNC_CHART, oldSyncChart, syncChart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InternalVar> getInternalVars() {
		if (internalVars == null) {
			internalVars = new EObjectContainmentEList<InternalVar>(InternalVar.class, this, CakefeedPackage.BFB_TYPE__INTERNAL_VARS);
		}
		return internalVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FBD> getFBDs() {
		if (fbDs == null) {
			fbDs = new EObjectContainmentEList<FBD>(FBD.class, this, CakefeedPackage.BFB_TYPE__FB_DS);
		}
		return fbDs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ST> getSTs() {
		if (sTs == null) {
			sTs = new EObjectContainmentEList<ST>(ST.class, this, CakefeedPackage.BFB_TYPE__STS);
		}
		return sTs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LD> getLDs() {
		if (lDs == null) {
			lDs = new EObjectContainmentEList<LD>(LD.class, this, CakefeedPackage.BFB_TYPE__LDS);
		}
		return lDs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Other> getOtherAlgorithms() {
		if (otherAlgorithms == null) {
			otherAlgorithms = new EObjectContainmentEList<Other>(Other.class, this, CakefeedPackage.BFB_TYPE__OTHER_ALGORITHMS);
		}
		return otherAlgorithms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.BFB_TYPE__SERVICE:
				return basicSetService(null, msgs);
			case CakefeedPackage.BFB_TYPE__INTERNAL_VARS:
				return ((InternalEList<?>)getInternalVars()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.BFB_TYPE__FB_DS:
				return ((InternalEList<?>)getFBDs()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.BFB_TYPE__STS:
				return ((InternalEList<?>)getSTs()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.BFB_TYPE__LDS:
				return ((InternalEList<?>)getLDs()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.BFB_TYPE__OTHER_ALGORITHMS:
				return ((InternalEList<?>)getOtherAlgorithms()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.BFB_TYPE__SERVICE:
				return getService();
			case CakefeedPackage.BFB_TYPE__SYNC_CHART:
				if (resolve) return getSyncChart();
				return basicGetSyncChart();
			case CakefeedPackage.BFB_TYPE__INTERNAL_VARS:
				return getInternalVars();
			case CakefeedPackage.BFB_TYPE__FB_DS:
				return getFBDs();
			case CakefeedPackage.BFB_TYPE__STS:
				return getSTs();
			case CakefeedPackage.BFB_TYPE__LDS:
				return getLDs();
			case CakefeedPackage.BFB_TYPE__OTHER_ALGORITHMS:
				return getOtherAlgorithms();
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
			case CakefeedPackage.BFB_TYPE__SERVICE:
				setService((Service)newValue);
				return;
			case CakefeedPackage.BFB_TYPE__SYNC_CHART:
				setSyncChart((State)newValue);
				return;
			case CakefeedPackage.BFB_TYPE__INTERNAL_VARS:
				getInternalVars().clear();
				getInternalVars().addAll((Collection<? extends InternalVar>)newValue);
				return;
			case CakefeedPackage.BFB_TYPE__FB_DS:
				getFBDs().clear();
				getFBDs().addAll((Collection<? extends FBD>)newValue);
				return;
			case CakefeedPackage.BFB_TYPE__STS:
				getSTs().clear();
				getSTs().addAll((Collection<? extends ST>)newValue);
				return;
			case CakefeedPackage.BFB_TYPE__LDS:
				getLDs().clear();
				getLDs().addAll((Collection<? extends LD>)newValue);
				return;
			case CakefeedPackage.BFB_TYPE__OTHER_ALGORITHMS:
				getOtherAlgorithms().clear();
				getOtherAlgorithms().addAll((Collection<? extends Other>)newValue);
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
			case CakefeedPackage.BFB_TYPE__SERVICE:
				setService((Service)null);
				return;
			case CakefeedPackage.BFB_TYPE__SYNC_CHART:
				setSyncChart((State)null);
				return;
			case CakefeedPackage.BFB_TYPE__INTERNAL_VARS:
				getInternalVars().clear();
				return;
			case CakefeedPackage.BFB_TYPE__FB_DS:
				getFBDs().clear();
				return;
			case CakefeedPackage.BFB_TYPE__STS:
				getSTs().clear();
				return;
			case CakefeedPackage.BFB_TYPE__LDS:
				getLDs().clear();
				return;
			case CakefeedPackage.BFB_TYPE__OTHER_ALGORITHMS:
				getOtherAlgorithms().clear();
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
			case CakefeedPackage.BFB_TYPE__SERVICE:
				return service != null;
			case CakefeedPackage.BFB_TYPE__SYNC_CHART:
				return syncChart != null;
			case CakefeedPackage.BFB_TYPE__INTERNAL_VARS:
				return internalVars != null && !internalVars.isEmpty();
			case CakefeedPackage.BFB_TYPE__FB_DS:
				return fbDs != null && !fbDs.isEmpty();
			case CakefeedPackage.BFB_TYPE__STS:
				return sTs != null && !sTs.isEmpty();
			case CakefeedPackage.BFB_TYPE__LDS:
				return lDs != null && !lDs.isEmpty();
			case CakefeedPackage.BFB_TYPE__OTHER_ALGORITHMS:
				return otherAlgorithms != null && !otherAlgorithms.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BFBTypeImpl
