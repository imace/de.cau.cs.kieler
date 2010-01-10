/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks.impl;

import de.cau.cs.kieler.functionblocks.DataConnections;
import de.cau.cs.kieler.functionblocks.EventConnections;
import de.cau.cs.kieler.functionblocks.FB;
import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;
import de.cau.cs.kieler.functionblocks.SubApp;
import de.cau.cs.kieler.functionblocks.SubAppNetwork;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub App Network</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppNetworkImpl#getSubApp <em>Sub App</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppNetworkImpl#getFB <em>FB</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppNetworkImpl#getEventConnections <em>Event Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppNetworkImpl#getDataConnections <em>Data Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubAppNetworkImpl extends EObjectImpl implements SubAppNetwork {
	/**
	 * The cached value of the '{@link #getSubApp() <em>Sub App</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubApp()
	 * @generated
	 * @ordered
	 */
	protected EList<SubApp> subApp;

	/**
	 * The cached value of the '{@link #getFB() <em>FB</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFB()
	 * @generated
	 * @ordered
	 */
	protected EList<FB> fB;

	/**
	 * The cached value of the '{@link #getEventConnections() <em>Event Connections</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventConnections()
	 * @generated
	 * @ordered
	 */
	protected EventConnections eventConnections;

	/**
	 * The cached value of the '{@link #getDataConnections() <em>Data Connections</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataConnections()
	 * @generated
	 * @ordered
	 */
	protected DataConnections dataConnections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubAppNetworkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblocksPackage.Literals.SUB_APP_NETWORK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubApp> getSubApp() {
		if (subApp == null) {
			subApp = new EObjectContainmentEList<SubApp>(SubApp.class, this, FunctionblocksPackage.SUB_APP_NETWORK__SUB_APP);
		}
		return subApp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FB> getFB() {
		if (fB == null) {
			fB = new EObjectContainmentEList<FB>(FB.class, this, FunctionblocksPackage.SUB_APP_NETWORK__FB);
		}
		return fB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventConnections getEventConnections() {
		return eventConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventConnections(EventConnections newEventConnections, NotificationChain msgs) {
		EventConnections oldEventConnections = eventConnections;
		eventConnections = newEventConnections;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_NETWORK__EVENT_CONNECTIONS, oldEventConnections, newEventConnections);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventConnections(EventConnections newEventConnections) {
		if (newEventConnections != eventConnections) {
			NotificationChain msgs = null;
			if (eventConnections != null)
				msgs = ((InternalEObject)eventConnections).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_NETWORK__EVENT_CONNECTIONS, null, msgs);
			if (newEventConnections != null)
				msgs = ((InternalEObject)newEventConnections).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_NETWORK__EVENT_CONNECTIONS, null, msgs);
			msgs = basicSetEventConnections(newEventConnections, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_NETWORK__EVENT_CONNECTIONS, newEventConnections, newEventConnections));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataConnections getDataConnections() {
		return dataConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataConnections(DataConnections newDataConnections, NotificationChain msgs) {
		DataConnections oldDataConnections = dataConnections;
		dataConnections = newDataConnections;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_NETWORK__DATA_CONNECTIONS, oldDataConnections, newDataConnections);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataConnections(DataConnections newDataConnections) {
		if (newDataConnections != dataConnections) {
			NotificationChain msgs = null;
			if (dataConnections != null)
				msgs = ((InternalEObject)dataConnections).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_NETWORK__DATA_CONNECTIONS, null, msgs);
			if (newDataConnections != null)
				msgs = ((InternalEObject)newDataConnections).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_NETWORK__DATA_CONNECTIONS, null, msgs);
			msgs = basicSetDataConnections(newDataConnections, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_NETWORK__DATA_CONNECTIONS, newDataConnections, newDataConnections));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblocksPackage.SUB_APP_NETWORK__SUB_APP:
				return ((InternalEList<?>)getSubApp()).basicRemove(otherEnd, msgs);
			case FunctionblocksPackage.SUB_APP_NETWORK__FB:
				return ((InternalEList<?>)getFB()).basicRemove(otherEnd, msgs);
			case FunctionblocksPackage.SUB_APP_NETWORK__EVENT_CONNECTIONS:
				return basicSetEventConnections(null, msgs);
			case FunctionblocksPackage.SUB_APP_NETWORK__DATA_CONNECTIONS:
				return basicSetDataConnections(null, msgs);
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
			case FunctionblocksPackage.SUB_APP_NETWORK__SUB_APP:
				return getSubApp();
			case FunctionblocksPackage.SUB_APP_NETWORK__FB:
				return getFB();
			case FunctionblocksPackage.SUB_APP_NETWORK__EVENT_CONNECTIONS:
				return getEventConnections();
			case FunctionblocksPackage.SUB_APP_NETWORK__DATA_CONNECTIONS:
				return getDataConnections();
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
			case FunctionblocksPackage.SUB_APP_NETWORK__SUB_APP:
				getSubApp().clear();
				getSubApp().addAll((Collection<? extends SubApp>)newValue);
				return;
			case FunctionblocksPackage.SUB_APP_NETWORK__FB:
				getFB().clear();
				getFB().addAll((Collection<? extends FB>)newValue);
				return;
			case FunctionblocksPackage.SUB_APP_NETWORK__EVENT_CONNECTIONS:
				setEventConnections((EventConnections)newValue);
				return;
			case FunctionblocksPackage.SUB_APP_NETWORK__DATA_CONNECTIONS:
				setDataConnections((DataConnections)newValue);
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
			case FunctionblocksPackage.SUB_APP_NETWORK__SUB_APP:
				getSubApp().clear();
				return;
			case FunctionblocksPackage.SUB_APP_NETWORK__FB:
				getFB().clear();
				return;
			case FunctionblocksPackage.SUB_APP_NETWORK__EVENT_CONNECTIONS:
				setEventConnections((EventConnections)null);
				return;
			case FunctionblocksPackage.SUB_APP_NETWORK__DATA_CONNECTIONS:
				setDataConnections((DataConnections)null);
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
			case FunctionblocksPackage.SUB_APP_NETWORK__SUB_APP:
				return subApp != null && !subApp.isEmpty();
			case FunctionblocksPackage.SUB_APP_NETWORK__FB:
				return fB != null && !fB.isEmpty();
			case FunctionblocksPackage.SUB_APP_NETWORK__EVENT_CONNECTIONS:
				return eventConnections != null;
			case FunctionblocksPackage.SUB_APP_NETWORK__DATA_CONNECTIONS:
				return dataConnections != null;
		}
		return super.eIsSet(featureID);
	}

} //SubAppNetworkImpl
