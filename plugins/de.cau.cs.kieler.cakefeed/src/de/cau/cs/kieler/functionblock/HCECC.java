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
 * A representation of the model object '<em><b>HCECC</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.HCECC#getGroup <em>Group</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.HCECC#getECC <em>ECC</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.HCECC#getHCECCRelation <em>HCECC Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getHCECC()
 * @model extendedMetaData="name='HCECC_._type' kind='elementOnly'"
 * @generated
 */
public interface HCECC extends EObject {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getHCECC_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>ECC</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblock.ECC}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>ECC</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getHCECC_ECC()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ECC' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
	EList<ECC> getECC();

	/**
	 * Returns the value of the '<em><b>HCECC Relation</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblock.HCECCRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>HCECC Relation</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getHCECC_HCECCRelation()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='HCECCRelation' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
	EList<HCECCRelation> getHCECCRelation();

} // HCECC
