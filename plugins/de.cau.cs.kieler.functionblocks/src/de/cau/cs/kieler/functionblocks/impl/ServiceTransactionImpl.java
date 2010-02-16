/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks.impl;

import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;
import de.cau.cs.kieler.functionblocks.InputPrimitive;
import de.cau.cs.kieler.functionblocks.OutputPrimitive;
import de.cau.cs.kieler.functionblocks.ServiceTransaction;

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
 * An implementation of the model object '<em><b>Service Transaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ServiceTransactionImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ServiceTransactionImpl#getInputPrimitive <em>Input Primitive</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ServiceTransactionImpl#getOutputPrimitive <em>Output Primitive</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceTransactionImpl extends EObjectImpl implements ServiceTransaction {
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
	protected ServiceTransactionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblocksPackage.Literals.SERVICE_TRANSACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, FunctionblocksPackage.SERVICE_TRANSACTION__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPrimitive getInputPrimitive() {
		return (InputPrimitive)getMixed().get(FunctionblocksPackage.Literals.SERVICE_TRANSACTION__INPUT_PRIMITIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputPrimitive(InputPrimitive newInputPrimitive, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.SERVICE_TRANSACTION__INPUT_PRIMITIVE, newInputPrimitive, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputPrimitive(InputPrimitive newInputPrimitive) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.SERVICE_TRANSACTION__INPUT_PRIMITIVE, newInputPrimitive);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputPrimitive> getOutputPrimitive() {
		return getMixed().list(FunctionblocksPackage.Literals.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblocksPackage.SERVICE_TRANSACTION__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case FunctionblocksPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE:
				return basicSetInputPrimitive(null, msgs);
			case FunctionblocksPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE:
				return ((InternalEList<?>)getOutputPrimitive()).basicRemove(otherEnd, msgs);
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
			case FunctionblocksPackage.SERVICE_TRANSACTION__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case FunctionblocksPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE:
				return getInputPrimitive();
			case FunctionblocksPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE:
				return getOutputPrimitive();
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
			case FunctionblocksPackage.SERVICE_TRANSACTION__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case FunctionblocksPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE:
				setInputPrimitive((InputPrimitive)newValue);
				return;
			case FunctionblocksPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE:
				getOutputPrimitive().clear();
				getOutputPrimitive().addAll((Collection<? extends OutputPrimitive>)newValue);
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
			case FunctionblocksPackage.SERVICE_TRANSACTION__MIXED:
				getMixed().clear();
				return;
			case FunctionblocksPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE:
				setInputPrimitive((InputPrimitive)null);
				return;
			case FunctionblocksPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE:
				getOutputPrimitive().clear();
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
			case FunctionblocksPackage.SERVICE_TRANSACTION__MIXED:
				return mixed != null && !mixed.isEmpty();
			case FunctionblocksPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE:
				return getInputPrimitive() != null;
			case FunctionblocksPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE:
				return !getOutputPrimitive().isEmpty();
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

} //ServiceTransactionImpl
