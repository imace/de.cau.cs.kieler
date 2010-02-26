/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.ServiceSequence;
import de.cau.cs.kieler.cakefeed.ServiceTransaction;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.ServiceSequenceImpl#getServiceTransactions <em>Service Transactions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceSequenceImpl extends NamedAndCommentedImpl implements ServiceSequence {
	/**
	 * The cached value of the '{@link #getServiceTransactions() <em>Service Transactions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceTransactions()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceTransaction> serviceTransactions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceSequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.SERVICE_SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceTransaction> getServiceTransactions() {
		if (serviceTransactions == null) {
			serviceTransactions = new EObjectContainmentEList<ServiceTransaction>(ServiceTransaction.class, this, CakefeedPackage.SERVICE_SEQUENCE__SERVICE_TRANSACTIONS);
		}
		return serviceTransactions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.SERVICE_SEQUENCE__SERVICE_TRANSACTIONS:
				return ((InternalEList<?>)getServiceTransactions()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.SERVICE_SEQUENCE__SERVICE_TRANSACTIONS:
				return getServiceTransactions();
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
			case CakefeedPackage.SERVICE_SEQUENCE__SERVICE_TRANSACTIONS:
				getServiceTransactions().clear();
				getServiceTransactions().addAll((Collection<? extends ServiceTransaction>)newValue);
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
			case CakefeedPackage.SERVICE_SEQUENCE__SERVICE_TRANSACTIONS:
				getServiceTransactions().clear();
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
			case CakefeedPackage.SERVICE_SEQUENCE__SERVICE_TRANSACTIONS:
				return serviceTransactions != null && !serviceTransactions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ServiceSequenceImpl
