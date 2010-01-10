/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks.impl;

import de.cau.cs.kieler.functionblocks.AdapterConnections;
import de.cau.cs.kieler.functionblocks.DataConnections;
import de.cau.cs.kieler.functionblocks.EventConnections;
import de.cau.cs.kieler.functionblocks.FB;
import de.cau.cs.kieler.functionblocks.FBNetwork;
import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FB Network</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.FBNetworkImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.FBNetworkImpl#getFB <em>FB</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.FBNetworkImpl#getEventConnections <em>Event Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.FBNetworkImpl#getDataConnections <em>Data Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.FBNetworkImpl#getAdapterConnections <em>Adapter Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FBNetworkImpl extends EObjectImpl implements FBNetwork {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FBNetworkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblocksPackage.Literals.FB_NETWORK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, FunctionblocksPackage.FB_NETWORK__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FB> getFB() {
		return getMixed().list(FunctionblocksPackage.Literals.FB_NETWORK__FB);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventConnections getEventConnections() {
		return (EventConnections)getMixed().get(FunctionblocksPackage.Literals.FB_NETWORK__EVENT_CONNECTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventConnections(EventConnections newEventConnections, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.FB_NETWORK__EVENT_CONNECTIONS, newEventConnections, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventConnections(EventConnections newEventConnections) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.FB_NETWORK__EVENT_CONNECTIONS, newEventConnections);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataConnections getDataConnections() {
		return (DataConnections)getMixed().get(FunctionblocksPackage.Literals.FB_NETWORK__DATA_CONNECTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataConnections(DataConnections newDataConnections, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.FB_NETWORK__DATA_CONNECTIONS, newDataConnections, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataConnections(DataConnections newDataConnections) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.FB_NETWORK__DATA_CONNECTIONS, newDataConnections);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterConnections getAdapterConnections() {
		return (AdapterConnections)getMixed().get(FunctionblocksPackage.Literals.FB_NETWORK__ADAPTER_CONNECTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdapterConnections(AdapterConnections newAdapterConnections, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.FB_NETWORK__ADAPTER_CONNECTIONS, newAdapterConnections, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdapterConnections(AdapterConnections newAdapterConnections) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.FB_NETWORK__ADAPTER_CONNECTIONS, newAdapterConnections);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblocksPackage.FB_NETWORK__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case FunctionblocksPackage.FB_NETWORK__FB:
				return ((InternalEList<?>)getFB()).basicRemove(otherEnd, msgs);
			case FunctionblocksPackage.FB_NETWORK__EVENT_CONNECTIONS:
				return basicSetEventConnections(null, msgs);
			case FunctionblocksPackage.FB_NETWORK__DATA_CONNECTIONS:
				return basicSetDataConnections(null, msgs);
			case FunctionblocksPackage.FB_NETWORK__ADAPTER_CONNECTIONS:
				return basicSetAdapterConnections(null, msgs);
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
			case FunctionblocksPackage.FB_NETWORK__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case FunctionblocksPackage.FB_NETWORK__FB:
				return getFB();
			case FunctionblocksPackage.FB_NETWORK__EVENT_CONNECTIONS:
				return getEventConnections();
			case FunctionblocksPackage.FB_NETWORK__DATA_CONNECTIONS:
				return getDataConnections();
			case FunctionblocksPackage.FB_NETWORK__ADAPTER_CONNECTIONS:
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
			case FunctionblocksPackage.FB_NETWORK__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case FunctionblocksPackage.FB_NETWORK__FB:
				getFB().clear();
				getFB().addAll((Collection<? extends FB>)newValue);
				return;
			case FunctionblocksPackage.FB_NETWORK__EVENT_CONNECTIONS:
				setEventConnections((EventConnections)newValue);
				return;
			case FunctionblocksPackage.FB_NETWORK__DATA_CONNECTIONS:
				setDataConnections((DataConnections)newValue);
				return;
			case FunctionblocksPackage.FB_NETWORK__ADAPTER_CONNECTIONS:
				setAdapterConnections((AdapterConnections)newValue);
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
			case FunctionblocksPackage.FB_NETWORK__MIXED:
				getMixed().clear();
				return;
			case FunctionblocksPackage.FB_NETWORK__FB:
				getFB().clear();
				return;
			case FunctionblocksPackage.FB_NETWORK__EVENT_CONNECTIONS:
				setEventConnections((EventConnections)null);
				return;
			case FunctionblocksPackage.FB_NETWORK__DATA_CONNECTIONS:
				setDataConnections((DataConnections)null);
				return;
			case FunctionblocksPackage.FB_NETWORK__ADAPTER_CONNECTIONS:
				setAdapterConnections((AdapterConnections)null);
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
			case FunctionblocksPackage.FB_NETWORK__MIXED:
				return mixed != null && !mixed.isEmpty();
			case FunctionblocksPackage.FB_NETWORK__FB:
				return !getFB().isEmpty();
			case FunctionblocksPackage.FB_NETWORK__EVENT_CONNECTIONS:
				return getEventConnections() != null;
			case FunctionblocksPackage.FB_NETWORK__DATA_CONNECTIONS:
				return getDataConnections() != null;
			case FunctionblocksPackage.FB_NETWORK__ADAPTER_CONNECTIONS:
				return getAdapterConnections() != null;
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //FBNetworkImpl
