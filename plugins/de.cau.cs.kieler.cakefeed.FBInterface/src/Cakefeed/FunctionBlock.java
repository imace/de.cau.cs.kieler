/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cakefeed.FunctionBlock#getParentInterface <em>Parent Interface</em>}</li>
 *   <li>{@link Cakefeed.FunctionBlock#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link Cakefeed.FunctionBlock#getInputEventPorts <em>Input Event Ports</em>}</li>
 *   <li>{@link Cakefeed.FunctionBlock#getOutputEventPorts <em>Output Event Ports</em>}</li>
 *   <li>{@link Cakefeed.FunctionBlock#getInputDataPorts <em>Input Data Ports</em>}</li>
 *   <li>{@link Cakefeed.FunctionBlock#getOutputDataPorts <em>Output Data Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cakefeed.CakefeedPackage#getFunctionBlock()
 * @model abstract="true"
 * @generated
 */
public interface FunctionBlock extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent Interface</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link Cakefeed.Interface#getFunctionBlock <em>Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Interface</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Interface</em>' container reference.
	 * @see #setParentInterface(Interface)
	 * @see Cakefeed.CakefeedPackage#getFunctionBlock_ParentInterface()
	 * @see Cakefeed.Interface#getFunctionBlock
	 * @model opposite="functionBlock" required="true" transient="false"
	 * @generated
	 */
	Interface getParentInterface();

	/**
	 * Sets the value of the '{@link Cakefeed.FunctionBlock#getParentInterface <em>Parent Interface</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Interface</em>' container reference.
	 * @see #getParentInterface()
	 * @generated
	 */
	void setParentInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Name</em>' attribute.
	 * @see #setTypeName(String)
	 * @see Cakefeed.CakefeedPackage#getFunctionBlock_TypeName()
	 * @model default="" required="true"
	 * @generated
	 */
	String getTypeName();

	/**
	 * Sets the value of the '{@link Cakefeed.FunctionBlock#getTypeName <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' attribute.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(String value);

	/**
	 * Returns the value of the '<em><b>Input Event Ports</b></em>' containment reference list.
	 * The list contents are of type {@link Cakefeed.InputEventPort}.
	 * It is bidirectional and its opposite is '{@link Cakefeed.InputEventPort#getParentFunctionBlock <em>Parent Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Event Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Event Ports</em>' containment reference list.
	 * @see Cakefeed.CakefeedPackage#getFunctionBlock_InputEventPorts()
	 * @see Cakefeed.InputEventPort#getParentFunctionBlock
	 * @model opposite="parentFunctionBlock" containment="true"
	 * @generated
	 */
	EList<InputEventPort> getInputEventPorts();

	/**
	 * Returns the value of the '<em><b>Output Event Ports</b></em>' containment reference list.
	 * The list contents are of type {@link Cakefeed.OutputEventPort}.
	 * It is bidirectional and its opposite is '{@link Cakefeed.OutputEventPort#getParentFunctionBlock <em>Parent Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Event Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Event Ports</em>' containment reference list.
	 * @see Cakefeed.CakefeedPackage#getFunctionBlock_OutputEventPorts()
	 * @see Cakefeed.OutputEventPort#getParentFunctionBlock
	 * @model opposite="parentFunctionBlock" containment="true"
	 * @generated
	 */
	EList<OutputEventPort> getOutputEventPorts();

	/**
	 * Returns the value of the '<em><b>Input Data Ports</b></em>' containment reference list.
	 * The list contents are of type {@link Cakefeed.InputDataPort}.
	 * It is bidirectional and its opposite is '{@link Cakefeed.InputDataPort#getParentFunctionBlock <em>Parent Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Data Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Data Ports</em>' containment reference list.
	 * @see Cakefeed.CakefeedPackage#getFunctionBlock_InputDataPorts()
	 * @see Cakefeed.InputDataPort#getParentFunctionBlock
	 * @model opposite="parentFunctionBlock" containment="true"
	 * @generated
	 */
	EList<InputDataPort> getInputDataPorts();

	/**
	 * Returns the value of the '<em><b>Output Data Ports</b></em>' containment reference list.
	 * The list contents are of type {@link Cakefeed.OutputDataPort}.
	 * It is bidirectional and its opposite is '{@link Cakefeed.OutputDataPort#getParentFunctionBlock <em>Parent Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Data Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Data Ports</em>' containment reference list.
	 * @see Cakefeed.CakefeedPackage#getFunctionBlock_OutputDataPorts()
	 * @see Cakefeed.OutputDataPort#getParentFunctionBlock
	 * @model opposite="parentFunctionBlock" containment="true"
	 * @generated
	 */
	EList<OutputDataPort> getOutputDataPorts();

} // FunctionBlock
