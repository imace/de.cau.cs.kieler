/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ECC</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.ECC#getECState <em>EC State</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.ECC#getECTransition <em>EC Transition</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.ECC#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getECC()
 * @model extendedMetaData="name='ECC_._type' kind='elementOnly'"
 * @generated
 */
public interface ECC extends EObject {
	/**
	 * Returns the value of the '<em><b>EC State</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblocks.ECState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EC State</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getECC_ECState()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='ECState' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ECState> getECState();

	/**
	 * Returns the value of the '<em><b>EC Transition</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblocks.ECTransition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EC Transition</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getECC_ECTransition()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ECTransition' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ECTransition> getECTransition();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getECC_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.ECC#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ECC
