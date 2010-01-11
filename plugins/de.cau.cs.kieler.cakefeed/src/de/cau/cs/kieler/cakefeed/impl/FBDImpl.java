/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.FB;
import de.cau.cs.kieler.cakefeed.FBD;
import de.cau.cs.kieler.cakefeed.FBFBDataConnection;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FBD</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FBDImpl#getFBs <em>FBs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FBDImpl#getDataConnections <em>Data Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FBDImpl extends NamedAndCommentedImpl implements FBD {
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
	 * The cached value of the '{@link #getDataConnections() <em>Data Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<FBFBDataConnection> dataConnections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FBDImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.FBD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FB> getFBs() {
		if (fBs == null) {
			fBs = new EObjectContainmentEList<FB>(FB.class, this, CakefeedPackage.FBD__FBS);
		}
		return fBs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FBFBDataConnection> getDataConnections() {
		if (dataConnections == null) {
			dataConnections = new EObjectContainmentEList<FBFBDataConnection>(FBFBDataConnection.class, this, CakefeedPackage.FBD__DATA_CONNECTIONS);
		}
		return dataConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.FBD__FBS:
				return ((InternalEList<?>)getFBs()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FBD__DATA_CONNECTIONS:
				return ((InternalEList<?>)getDataConnections()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.FBD__FBS:
				return getFBs();
			case CakefeedPackage.FBD__DATA_CONNECTIONS:
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
			case CakefeedPackage.FBD__FBS:
				getFBs().clear();
				getFBs().addAll((Collection<? extends FB>)newValue);
				return;
			case CakefeedPackage.FBD__DATA_CONNECTIONS:
				getDataConnections().clear();
				getDataConnections().addAll((Collection<? extends FBFBDataConnection>)newValue);
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
			case CakefeedPackage.FBD__FBS:
				getFBs().clear();
				return;
			case CakefeedPackage.FBD__DATA_CONNECTIONS:
				getDataConnections().clear();
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
			case CakefeedPackage.FBD__FBS:
				return fBs != null && !fBs.isEmpty();
			case CakefeedPackage.FBD__DATA_CONNECTIONS:
				return dataConnections != null && !dataConnections.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FBDImpl
