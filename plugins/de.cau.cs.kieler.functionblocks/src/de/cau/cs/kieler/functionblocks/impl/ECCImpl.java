/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks.impl;

import de.cau.cs.kieler.functionblocks.ECC;
import de.cau.cs.kieler.functionblocks.ECState;
import de.cau.cs.kieler.functionblocks.ECTransition;
import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;

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
 * An implementation of the model object '<em><b>ECC</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ECCImpl#getECState <em>EC State</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ECCImpl#getECTransition <em>EC Transition</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ECCImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ECCImpl extends EObjectImpl implements ECC {
	/**
	 * The cached value of the '{@link #getECState() <em>EC State</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getECState()
	 * @generated
	 * @ordered
	 */
	protected EList<ECState> eCState;

	/**
	 * The cached value of the '{@link #getECTransition() <em>EC Transition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getECTransition()
	 * @generated
	 * @ordered
	 */
	protected EList<ECTransition> eCTransition;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ECCImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblocksPackage.Literals.ECC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ECState> getECState() {
		if (eCState == null) {
			eCState = new EObjectContainmentEList<ECState>(ECState.class, this, FunctionblocksPackage.ECC__EC_STATE);
		}
		return eCState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ECTransition> getECTransition() {
		if (eCTransition == null) {
			eCTransition = new EObjectContainmentEList<ECTransition>(ECTransition.class, this, FunctionblocksPackage.ECC__EC_TRANSITION);
		}
		return eCTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.ECC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblocksPackage.ECC__EC_STATE:
				return ((InternalEList<?>)getECState()).basicRemove(otherEnd, msgs);
			case FunctionblocksPackage.ECC__EC_TRANSITION:
				return ((InternalEList<?>)getECTransition()).basicRemove(otherEnd, msgs);
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
			case FunctionblocksPackage.ECC__EC_STATE:
				return getECState();
			case FunctionblocksPackage.ECC__EC_TRANSITION:
				return getECTransition();
			case FunctionblocksPackage.ECC__NAME:
				return getName();
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
			case FunctionblocksPackage.ECC__EC_STATE:
				getECState().clear();
				getECState().addAll((Collection<? extends ECState>)newValue);
				return;
			case FunctionblocksPackage.ECC__EC_TRANSITION:
				getECTransition().clear();
				getECTransition().addAll((Collection<? extends ECTransition>)newValue);
				return;
			case FunctionblocksPackage.ECC__NAME:
				setName((String)newValue);
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
			case FunctionblocksPackage.ECC__EC_STATE:
				getECState().clear();
				return;
			case FunctionblocksPackage.ECC__EC_TRANSITION:
				getECTransition().clear();
				return;
			case FunctionblocksPackage.ECC__NAME:
				setName(NAME_EDEFAULT);
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
			case FunctionblocksPackage.ECC__EC_STATE:
				return eCState != null && !eCState.isEmpty();
			case FunctionblocksPackage.ECC__EC_TRANSITION:
				return eCTransition != null && !eCTransition.isEmpty();
			case FunctionblocksPackage.ECC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ECCImpl
