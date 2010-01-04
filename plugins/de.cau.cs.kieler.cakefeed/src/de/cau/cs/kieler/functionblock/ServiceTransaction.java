/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblock;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Transaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.ServiceTransaction#getMixed <em>Mixed</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.ServiceTransaction#getInputPrimitive <em>Input Primitive</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.ServiceTransaction#getOutputPrimitive <em>Output Primitive</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getServiceTransaction()
 * @model extendedMetaData="name='ServiceTransaction_._type' kind='mixed'"
 * @generated
 */
public interface ServiceTransaction extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getServiceTransaction_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Input Primitive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input Primitive</em>' containment reference.
	 * @see #setInputPrimitive(InputPrimitive)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getServiceTransaction_InputPrimitive()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='InputPrimitive' namespace='##targetNamespace'"
	 * @generated
	 */
	InputPrimitive getInputPrimitive();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.ServiceTransaction#getInputPrimitive <em>Input Primitive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Primitive</em>' containment reference.
	 * @see #getInputPrimitive()
	 * @generated
	 */
	void setInputPrimitive(InputPrimitive value);

	/**
	 * Returns the value of the '<em><b>Output Primitive</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblock.OutputPrimitive}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output Primitive</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getServiceTransaction_OutputPrimitive()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='OutputPrimitive' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<OutputPrimitive> getOutputPrimitive();

} // ServiceTransaction
