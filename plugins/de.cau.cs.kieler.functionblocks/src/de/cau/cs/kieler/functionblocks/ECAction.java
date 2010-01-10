/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EC Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.ECAction#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.ECAction#getOutput <em>Output</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getECAction()
 * @model extendedMetaData="name='ECAction_._type' kind='empty'"
 * @generated
 */
public interface ECAction extends EObject {
	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm</em>' attribute.
	 * @see #setAlgorithm(String)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getECAction_Algorithm()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Algorithm' namespace='##targetNamespace'"
	 * @generated
	 */
	String getAlgorithm();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.ECAction#getAlgorithm <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm</em>' attribute.
	 * @see #getAlgorithm()
	 * @generated
	 */
	void setAlgorithm(String value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' attribute.
	 * @see #setOutput(String)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getECAction_Output()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Output' namespace='##targetNamespace'"
	 * @generated
	 */
	String getOutput();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.ECAction#getOutput <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' attribute.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(String value);

} // ECAction
