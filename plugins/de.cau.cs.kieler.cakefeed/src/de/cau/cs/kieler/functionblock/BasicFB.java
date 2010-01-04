/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblock;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic FB</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.BasicFB#getInternalVars <em>Internal Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.BasicFB#getECC <em>ECC</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.BasicFB#getHCECC <em>HCECC</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.BasicFB#getAlgorithm <em>Algorithm</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getBasicFB()
 * @model extendedMetaData="name='BasicFB_._type' kind='elementOnly'"
 * @generated
 */
public interface BasicFB extends EObject {
	/**
	 * Returns the value of the '<em><b>Internal Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Internal Vars</em>' containment reference.
	 * @see #setInternalVars(InternalVars)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getBasicFB_InternalVars()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='InternalVars' namespace='##targetNamespace'"
	 * @generated
	 */
	InternalVars getInternalVars();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.BasicFB#getInternalVars <em>Internal Vars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Vars</em>' containment reference.
	 * @see #getInternalVars()
	 * @generated
	 */
	void setInternalVars(InternalVars value);

	/**
	 * Returns the value of the '<em><b>ECC</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>ECC</em>' containment reference.
	 * @see #setECC(ECC)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getBasicFB_ECC()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ECC' namespace='##targetNamespace'"
	 * @generated
	 */
	ECC getECC();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.BasicFB#getECC <em>ECC</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ECC</em>' containment reference.
	 * @see #getECC()
	 * @generated
	 */
	void setECC(ECC value);

	/**
	 * Returns the value of the '<em><b>HCECC</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>HCECC</em>' containment reference.
	 * @see #setHCECC(HCECC)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getBasicFB_HCECC()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='HCECC' namespace='##targetNamespace'"
	 * @generated
	 */
	HCECC getHCECC();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.BasicFB#getHCECC <em>HCECC</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>HCECC</em>' containment reference.
	 * @see #getHCECC()
	 * @generated
	 */
	void setHCECC(HCECC value);

	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblock.Algorithm}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Algorithm</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getBasicFB_Algorithm()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Algorithm' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Algorithm> getAlgorithm();

} // BasicFB
