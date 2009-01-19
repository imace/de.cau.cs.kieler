/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.ssm.impl;

import de.cau.cs.kieler.ssm.CombinationOperator;
import de.cau.cs.kieler.ssm.Condition;
import de.cau.cs.kieler.ssm.ssmPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.ssm.impl.ConditionImpl#getSubConditions <em>Sub Conditions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.ssm.impl.ConditionImpl#getCombinationOperator <em>Combination Operator</em>}</li>
 *   <li>{@link de.cau.cs.kieler.ssm.impl.ConditionImpl#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionImpl extends EObjectImpl implements Condition {
	/**
	 * The cached value of the '{@link #getSubConditions() <em>Sub Conditions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<Condition> subConditions;

	/**
	 * The default value of the '{@link #getCombinationOperator() <em>Combination Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCombinationOperator()
	 * @generated
	 * @ordered
	 */
	protected static final CombinationOperator COMBINATION_OPERATOR_EDEFAULT = CombinationOperator.PURESIGNALAND;

	/**
	 * The cached value of the '{@link #getCombinationOperator() <em>Combination Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCombinationOperator()
	 * @generated
	 * @ordered
	 */
	protected CombinationOperator combinationOperator = COMBINATION_OPERATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLiterals() <em>Literals</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> literals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ssmPackage.Literals.CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Condition> getSubConditions() {
		if (subConditions == null) {
			subConditions = new EObjectResolvingEList<Condition>(Condition.class, this, ssmPackage.CONDITION__SUB_CONDITIONS);
		}
		return subConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CombinationOperator getCombinationOperator() {
		return combinationOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCombinationOperator(CombinationOperator newCombinationOperator) {
		CombinationOperator oldCombinationOperator = combinationOperator;
		combinationOperator = newCombinationOperator == null ? COMBINATION_OPERATOR_EDEFAULT : newCombinationOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.CONDITION__COMBINATION_OPERATOR, oldCombinationOperator, combinationOperator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getLiterals() {
		if (literals == null) {
			literals = new EDataTypeUniqueEList<Object>(Object.class, this, ssmPackage.CONDITION__LITERALS);
		}
		return literals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ssmPackage.CONDITION__SUB_CONDITIONS:
				return getSubConditions();
			case ssmPackage.CONDITION__COMBINATION_OPERATOR:
				return getCombinationOperator();
			case ssmPackage.CONDITION__LITERALS:
				return getLiterals();
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
			case ssmPackage.CONDITION__SUB_CONDITIONS:
				getSubConditions().clear();
				getSubConditions().addAll((Collection<? extends Condition>)newValue);
				return;
			case ssmPackage.CONDITION__COMBINATION_OPERATOR:
				setCombinationOperator((CombinationOperator)newValue);
				return;
			case ssmPackage.CONDITION__LITERALS:
				getLiterals().clear();
				getLiterals().addAll((Collection<? extends Object>)newValue);
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
			case ssmPackage.CONDITION__SUB_CONDITIONS:
				getSubConditions().clear();
				return;
			case ssmPackage.CONDITION__COMBINATION_OPERATOR:
				setCombinationOperator(COMBINATION_OPERATOR_EDEFAULT);
				return;
			case ssmPackage.CONDITION__LITERALS:
				getLiterals().clear();
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
			case ssmPackage.CONDITION__SUB_CONDITIONS:
				return subConditions != null && !subConditions.isEmpty();
			case ssmPackage.CONDITION__COMBINATION_OPERATOR:
				return combinationOperator != COMBINATION_OPERATOR_EDEFAULT;
			case ssmPackage.CONDITION__LITERALS:
				return literals != null && !literals.isEmpty();
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
		result.append(" (combinationOperator: ");
		result.append(combinationOperator);
		result.append(", literals: ");
		result.append(literals);
		result.append(')');
		return result.toString();
	}

} //ConditionImpl
