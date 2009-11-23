/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.impl;

import cakefeed.Algorithm;
import cakefeed.Application;
import cakefeed.CakefeedPackage;
import cakefeed.CompositeNetwork;
import cakefeed.Interface;
import cakefeed.Library;
import cakefeed.ServiceSequence;

import de.cau.cs.kieler.synccharts.State;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cakefeed.impl.LibraryImpl#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link cakefeed.impl.LibraryImpl#getAlgorithms <em>Algorithms</em>}</li>
 *   <li>{@link cakefeed.impl.LibraryImpl#getApplications <em>Applications</em>}</li>
 *   <li>{@link cakefeed.impl.LibraryImpl#getCompositeNetworks <em>Composite Networks</em>}</li>
 *   <li>{@link cakefeed.impl.LibraryImpl#getSyncCharts <em>Sync Charts</em>}</li>
 *   <li>{@link cakefeed.impl.LibraryImpl#getServiceSequences <em>Service Sequences</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibraryImpl extends EObjectImpl implements Library {
	/**
	 * The cached value of the '{@link #getInterfaces() <em>Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> interfaces;

	/**
	 * The cached value of the '{@link #getAlgorithms() <em>Algorithms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithms()
	 * @generated
	 * @ordered
	 */
	protected EList<Algorithm> algorithms;

	/**
	 * The cached value of the '{@link #getApplications() <em>Applications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplications()
	 * @generated
	 * @ordered
	 */
	protected EList<Application> applications;

	/**
	 * The cached value of the '{@link #getCompositeNetworks() <em>Composite Networks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeNetworks()
	 * @generated
	 * @ordered
	 */
	protected EList<CompositeNetwork> compositeNetworks;

	/**
	 * The cached value of the '{@link #getSyncCharts() <em>Sync Charts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyncCharts()
	 * @generated
	 * @ordered
	 */
	protected EList<State> syncCharts;

	/**
	 * The cached value of the '{@link #getServiceSequences() <em>Service Sequences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceSequences()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceSequence> serviceSequences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getInterfaces() {
		if (interfaces == null) {
			interfaces = new EObjectContainmentEList<Interface>(Interface.class, this, CakefeedPackage.LIBRARY__INTERFACES);
		}
		return interfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Algorithm> getAlgorithms() {
		if (algorithms == null) {
			algorithms = new EObjectContainmentEList<Algorithm>(Algorithm.class, this, CakefeedPackage.LIBRARY__ALGORITHMS);
		}
		return algorithms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Application> getApplications() {
		if (applications == null) {
			applications = new EObjectContainmentEList<Application>(Application.class, this, CakefeedPackage.LIBRARY__APPLICATIONS);
		}
		return applications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompositeNetwork> getCompositeNetworks() {
		if (compositeNetworks == null) {
			compositeNetworks = new EObjectContainmentEList<CompositeNetwork>(CompositeNetwork.class, this, CakefeedPackage.LIBRARY__COMPOSITE_NETWORKS);
		}
		return compositeNetworks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getSyncCharts() {
		if (syncCharts == null) {
			syncCharts = new EObjectContainmentEList<State>(State.class, this, CakefeedPackage.LIBRARY__SYNC_CHARTS);
		}
		return syncCharts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceSequence> getServiceSequences() {
		if (serviceSequences == null) {
			serviceSequences = new EObjectContainmentEList<ServiceSequence>(ServiceSequence.class, this, CakefeedPackage.LIBRARY__SERVICE_SEQUENCES);
		}
		return serviceSequences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.LIBRARY__INTERFACES:
				return ((InternalEList<?>)getInterfaces()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.LIBRARY__ALGORITHMS:
				return ((InternalEList<?>)getAlgorithms()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.LIBRARY__APPLICATIONS:
				return ((InternalEList<?>)getApplications()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.LIBRARY__COMPOSITE_NETWORKS:
				return ((InternalEList<?>)getCompositeNetworks()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.LIBRARY__SYNC_CHARTS:
				return ((InternalEList<?>)getSyncCharts()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.LIBRARY__SERVICE_SEQUENCES:
				return ((InternalEList<?>)getServiceSequences()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.LIBRARY__INTERFACES:
				return getInterfaces();
			case CakefeedPackage.LIBRARY__ALGORITHMS:
				return getAlgorithms();
			case CakefeedPackage.LIBRARY__APPLICATIONS:
				return getApplications();
			case CakefeedPackage.LIBRARY__COMPOSITE_NETWORKS:
				return getCompositeNetworks();
			case CakefeedPackage.LIBRARY__SYNC_CHARTS:
				return getSyncCharts();
			case CakefeedPackage.LIBRARY__SERVICE_SEQUENCES:
				return getServiceSequences();
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
			case CakefeedPackage.LIBRARY__INTERFACES:
				getInterfaces().clear();
				getInterfaces().addAll((Collection<? extends Interface>)newValue);
				return;
			case CakefeedPackage.LIBRARY__ALGORITHMS:
				getAlgorithms().clear();
				getAlgorithms().addAll((Collection<? extends Algorithm>)newValue);
				return;
			case CakefeedPackage.LIBRARY__APPLICATIONS:
				getApplications().clear();
				getApplications().addAll((Collection<? extends Application>)newValue);
				return;
			case CakefeedPackage.LIBRARY__COMPOSITE_NETWORKS:
				getCompositeNetworks().clear();
				getCompositeNetworks().addAll((Collection<? extends CompositeNetwork>)newValue);
				return;
			case CakefeedPackage.LIBRARY__SYNC_CHARTS:
				getSyncCharts().clear();
				getSyncCharts().addAll((Collection<? extends State>)newValue);
				return;
			case CakefeedPackage.LIBRARY__SERVICE_SEQUENCES:
				getServiceSequences().clear();
				getServiceSequences().addAll((Collection<? extends ServiceSequence>)newValue);
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
			case CakefeedPackage.LIBRARY__INTERFACES:
				getInterfaces().clear();
				return;
			case CakefeedPackage.LIBRARY__ALGORITHMS:
				getAlgorithms().clear();
				return;
			case CakefeedPackage.LIBRARY__APPLICATIONS:
				getApplications().clear();
				return;
			case CakefeedPackage.LIBRARY__COMPOSITE_NETWORKS:
				getCompositeNetworks().clear();
				return;
			case CakefeedPackage.LIBRARY__SYNC_CHARTS:
				getSyncCharts().clear();
				return;
			case CakefeedPackage.LIBRARY__SERVICE_SEQUENCES:
				getServiceSequences().clear();
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
			case CakefeedPackage.LIBRARY__INTERFACES:
				return interfaces != null && !interfaces.isEmpty();
			case CakefeedPackage.LIBRARY__ALGORITHMS:
				return algorithms != null && !algorithms.isEmpty();
			case CakefeedPackage.LIBRARY__APPLICATIONS:
				return applications != null && !applications.isEmpty();
			case CakefeedPackage.LIBRARY__COMPOSITE_NETWORKS:
				return compositeNetworks != null && !compositeNetworks.isEmpty();
			case CakefeedPackage.LIBRARY__SYNC_CHARTS:
				return syncCharts != null && !syncCharts.isEmpty();
			case CakefeedPackage.LIBRARY__SERVICE_SEQUENCES:
				return serviceSequences != null && !serviceSequences.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LibraryImpl
