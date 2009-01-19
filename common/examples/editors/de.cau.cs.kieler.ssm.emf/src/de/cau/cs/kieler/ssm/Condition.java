/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.ssm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.ssm.Condition#getSubConditions <em>Sub Conditions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.ssm.Condition#getCombinationOperator <em>Combination Operator</em>}</li>
 *   <li>{@link de.cau.cs.kieler.ssm.Condition#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.ssm.ssmPackage#getCondition()
 * @model
 * @generated
 */
public interface Condition extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub Conditions</b></em>' reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.ssm.Condition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Conditions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Conditions</em>' reference list.
	 * @see de.cau.cs.kieler.ssm.ssmPackage#getCondition_SubConditions()
	 * @model
	 * @generated
	 */
	EList<Condition> getSubConditions();

	/**
	 * Returns the value of the '<em><b>Combination Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link de.cau.cs.kieler.ssm.CombinationOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Combination Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Combination Operator</em>' attribute.
	 * @see de.cau.cs.kieler.ssm.CombinationOperator
	 * @see #setCombinationOperator(CombinationOperator)
	 * @see de.cau.cs.kieler.ssm.ssmPackage#getCondition_CombinationOperator()
	 * @model required="true"
	 * @generated
	 */
	CombinationOperator getCombinationOperator();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.ssm.Condition#getCombinationOperator <em>Combination Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Combination Operator</em>' attribute.
	 * @see de.cau.cs.kieler.ssm.CombinationOperator
	 * @see #getCombinationOperator()
	 * @generated
	 */
	void setCombinationOperator(CombinationOperator value);

	/**
	 * Returns the value of the '<em><b>Literals</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' attribute list.
	 * @see de.cau.cs.kieler.ssm.ssmPackage#getCondition_Literals()
	 * @model dataType="de.cau.cs.kieler.ssm.AnyType"
	 * @generated
	 */
	EList<Object> getLiterals();

} // Condition
