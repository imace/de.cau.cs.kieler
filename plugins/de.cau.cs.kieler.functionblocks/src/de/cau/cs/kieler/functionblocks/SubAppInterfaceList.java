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
 * A representation of the model object '<em><b>Sub App Interface List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.SubAppInterfaceList#getSubAppEventInputs <em>Sub App Event Inputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.SubAppInterfaceList#getSubAppEventOutputs <em>Sub App Event Outputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.SubAppInterfaceList#getInputVars <em>Input Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.SubAppInterfaceList#getOutputVars <em>Output Vars</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSubAppInterfaceList()
 * @model extendedMetaData="name='SubAppInterfaceList_._type' kind='elementOnly'"
 * @generated
 */
public interface SubAppInterfaceList extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub App Event Inputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SubAppType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub App Event Inputs</em>' containment reference.
	 * @see #setSubAppEventInputs(SubAppEventInputs)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSubAppInterfaceList_SubAppEventInputs()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='SubAppEventInputs' namespace='##targetNamespace'"
	 * @generated
	 */
	SubAppEventInputs getSubAppEventInputs();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.SubAppInterfaceList#getSubAppEventInputs <em>Sub App Event Inputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub App Event Inputs</em>' containment reference.
	 * @see #getSubAppEventInputs()
	 * @generated
	 */
	void setSubAppEventInputs(SubAppEventInputs value);

	/**
	 * Returns the value of the '<em><b>Sub App Event Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SubAppType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub App Event Outputs</em>' containment reference.
	 * @see #setSubAppEventOutputs(SubAppEventOutputs)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSubAppInterfaceList_SubAppEventOutputs()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='SubAppEventOutputs' namespace='##targetNamespace'"
	 * @generated
	 */
	SubAppEventOutputs getSubAppEventOutputs();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.SubAppInterfaceList#getSubAppEventOutputs <em>Sub App Event Outputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub App Event Outputs</em>' containment reference.
	 * @see #getSubAppEventOutputs()
	 * @generated
	 */
	void setSubAppEventOutputs(SubAppEventOutputs value);

	/**
	 * Returns the value of the '<em><b>Input Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input Vars</em>' containment reference.
	 * @see #setInputVars(InputVars)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSubAppInterfaceList_InputVars()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='InputVars' namespace='##targetNamespace'"
	 * @generated
	 */
	InputVars getInputVars();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.SubAppInterfaceList#getInputVars <em>Input Vars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Vars</em>' containment reference.
	 * @see #getInputVars()
	 * @generated
	 */
	void setInputVars(InputVars value);

	/**
	 * Returns the value of the '<em><b>Output Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output Vars</em>' containment reference.
	 * @see #setOutputVars(OutputVars)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSubAppInterfaceList_OutputVars()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='OutputVars' namespace='##targetNamespace'"
	 * @generated
	 */
	OutputVars getOutputVars();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.SubAppInterfaceList#getOutputVars <em>Output Vars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Vars</em>' containment reference.
	 * @see #getOutputVars()
	 * @generated
	 */
	void setOutputVars(OutputVars value);

} // SubAppInterfaceList
