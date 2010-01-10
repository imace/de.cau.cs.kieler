/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks.impl;

import de.cau.cs.kieler.functionblocks.ECC;
import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;
import de.cau.cs.kieler.functionblocks.HCECC;
import de.cau.cs.kieler.functionblocks.HCECCRelation;

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
 * An implementation of the model object '<em><b>HCECC</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.HCECCImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.HCECCImpl#getECC <em>ECC</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.HCECCImpl#getHCECCRelation <em>HCECC Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HCECCImpl extends EObjectImpl implements HCECC {
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HCECCImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblocksPackage.Literals.HCECC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, FunctionblocksPackage.HCECC__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ECC> getECC() {
		return getGroup().list(FunctionblocksPackage.Literals.HCECC__ECC);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HCECCRelation> getHCECCRelation() {
		return getGroup().list(FunctionblocksPackage.Literals.HCECC__HCECC_RELATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblocksPackage.HCECC__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case FunctionblocksPackage.HCECC__ECC:
				return ((InternalEList<?>)getECC()).basicRemove(otherEnd, msgs);
			case FunctionblocksPackage.HCECC__HCECC_RELATION:
				return ((InternalEList<?>)getHCECCRelation()).basicRemove(otherEnd, msgs);
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
			case FunctionblocksPackage.HCECC__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case FunctionblocksPackage.HCECC__ECC:
				return getECC();
			case FunctionblocksPackage.HCECC__HCECC_RELATION:
				return getHCECCRelation();
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
			case FunctionblocksPackage.HCECC__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case FunctionblocksPackage.HCECC__ECC:
				getECC().clear();
				getECC().addAll((Collection<? extends ECC>)newValue);
				return;
			case FunctionblocksPackage.HCECC__HCECC_RELATION:
				getHCECCRelation().clear();
				getHCECCRelation().addAll((Collection<? extends HCECCRelation>)newValue);
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
			case FunctionblocksPackage.HCECC__GROUP:
				getGroup().clear();
				return;
			case FunctionblocksPackage.HCECC__ECC:
				getECC().clear();
				return;
			case FunctionblocksPackage.HCECC__HCECC_RELATION:
				getHCECCRelation().clear();
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
			case FunctionblocksPackage.HCECC__GROUP:
				return group != null && !group.isEmpty();
			case FunctionblocksPackage.HCECC__ECC:
				return !getECC().isEmpty();
			case FunctionblocksPackage.HCECC__HCECC_RELATION:
				return !getHCECCRelation().isEmpty();
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
		result.append(" (group: ");
		result.append(group);
		result.append(')');
		return result.toString();
	}

} //HCECCImpl
