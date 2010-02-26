/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.AdapterConnection;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.DataConnection;
import de.cau.cs.kieler.cakefeed.EventConnection;
import de.cau.cs.kieler.cakefeed.FunctionBlock;
import de.cau.cs.kieler.cakefeed.FunctionBlockNetwork;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Block Network</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockNetworkImpl#getFBs <em>FBs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockNetworkImpl#getEventConnections <em>Event Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockNetworkImpl#getDataConnections <em>Data Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockNetworkImpl#getAdapterConnections <em>Adapter Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionBlockNetworkImpl extends NamedAndCommentedImpl implements FunctionBlockNetwork {
	/**
	 * The cached value of the '{@link #getFBs() <em>FBs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFBs()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionBlock> fBs;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionBlockNetworkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.FUNCTION_BLOCK_NETWORK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionBlock> getFBs() {
		if (fBs == null) {
			fBs = new EObjectContainmentEList<FunctionBlock>(FunctionBlock.class, this, CakefeedPackage.FUNCTION_BLOCK_NETWORK__FBS);
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
			eventConnections = new EObjectContainmentEList<EventConnection>(EventConnection.class, this, CakefeedPackage.FUNCTION_BLOCK_NETWORK__EVENT_CONNECTIONS);
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
			dataConnections = new EObjectContainmentEList<DataConnection>(DataConnection.class, this, CakefeedPackage.FUNCTION_BLOCK_NETWORK__DATA_CONNECTIONS);
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
			adapterConnections = new EObjectContainmentEList<AdapterConnection>(AdapterConnection.class, this, CakefeedPackage.FUNCTION_BLOCK_NETWORK__ADAPTER_CONNECTIONS);
		}
		return adapterConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__FBS:
				return ((InternalEList<?>)getFBs()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__EVENT_CONNECTIONS:
				return ((InternalEList<?>)getEventConnections()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__DATA_CONNECTIONS:
				return ((InternalEList<?>)getDataConnections()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__ADAPTER_CONNECTIONS:
				return ((InternalEList<?>)getAdapterConnections()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__FBS:
				return getFBs();
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__EVENT_CONNECTIONS:
				return getEventConnections();
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__DATA_CONNECTIONS:
				return getDataConnections();
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__ADAPTER_CONNECTIONS:
				return getAdapterConnections();
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
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__FBS:
				getFBs().clear();
				getFBs().addAll((Collection<? extends FunctionBlock>)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__EVENT_CONNECTIONS:
				getEventConnections().clear();
				getEventConnections().addAll((Collection<? extends EventConnection>)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__DATA_CONNECTIONS:
				getDataConnections().clear();
				getDataConnections().addAll((Collection<? extends DataConnection>)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__ADAPTER_CONNECTIONS:
				getAdapterConnections().clear();
				getAdapterConnections().addAll((Collection<? extends AdapterConnection>)newValue);
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
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__FBS:
				getFBs().clear();
				return;
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__EVENT_CONNECTIONS:
				getEventConnections().clear();
				return;
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__DATA_CONNECTIONS:
				getDataConnections().clear();
				return;
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__ADAPTER_CONNECTIONS:
				getAdapterConnections().clear();
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
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__FBS:
				return fBs != null && !fBs.isEmpty();
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__EVENT_CONNECTIONS:
				return eventConnections != null && !eventConnections.isEmpty();
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__DATA_CONNECTIONS:
				return dataConnections != null && !dataConnections.isEmpty();
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK__ADAPTER_CONNECTIONS:
				return adapterConnections != null && !adapterConnections.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FunctionBlockNetworkImpl
