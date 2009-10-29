/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed;

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
 *   <li>{@link cakefeed.FunctionBlock#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link cakefeed.FunctionBlock#getParentLibrary <em>Parent Library</em>}</li>
 *   <li>{@link cakefeed.FunctionBlock#getInputEventPorts <em>Input Event Ports</em>}</li>
 *   <li>{@link cakefeed.FunctionBlock#getOutputEventPorts <em>Output Event Ports</em>}</li>
 *   <li>{@link cakefeed.FunctionBlock#getInputDataPorts <em>Input Data Ports</em>}</li>
 *   <li>{@link cakefeed.FunctionBlock#getOutputDataPorts <em>Output Data Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getFunctionBlock()
 * @model abstract="true"
 * @generated
 */
public interface FunctionBlock extends EObject {
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
	 * @see cakefeed.CakefeedPackage#getFunctionBlock_TypeName()
	 * @model default="" required="true"
	 * @generated
	 */
	String getTypeName();

	/**
	 * Sets the value of the '{@link cakefeed.FunctionBlock#getTypeName <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' attribute.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(String value);

	/**
	 * Returns the value of the '<em><b>Parent Library</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.Library#getFunctionBlocks <em>Function Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Library</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Library</em>' container reference.
	 * @see #setParentLibrary(Library)
	 * @see cakefeed.CakefeedPackage#getFunctionBlock_ParentLibrary()
	 * @see cakefeed.Library#getFunctionBlocks
	 * @model opposite="functionBlocks" required="true" transient="false"
	 * @generated
	 */
	Library getParentLibrary();

	/**
	 * Sets the value of the '{@link cakefeed.FunctionBlock#getParentLibrary <em>Parent Library</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Library</em>' container reference.
	 * @see #getParentLibrary()
	 * @generated
	 */
	void setParentLibrary(Library value);

	/**
	 * Returns the value of the '<em><b>Input Event Ports</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.InputEventPort}.
	 * It is bidirectional and its opposite is '{@link cakefeed.InputEventPort#getParentFunctionBlock <em>Parent Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Event Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Event Ports</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getFunctionBlock_InputEventPorts()
	 * @see cakefeed.InputEventPort#getParentFunctionBlock
	 * @model opposite="parentFunctionBlock" containment="true"
	 * @generated
	 */
	EList<InputEventPort> getInputEventPorts();

	/**
	 * Returns the value of the '<em><b>Output Event Ports</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.OutputEventPort}.
	 * It is bidirectional and its opposite is '{@link cakefeed.OutputEventPort#getParentFunctionBlock <em>Parent Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Event Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Event Ports</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getFunctionBlock_OutputEventPorts()
	 * @see cakefeed.OutputEventPort#getParentFunctionBlock
	 * @model opposite="parentFunctionBlock" containment="true"
	 * @generated
	 */
	EList<OutputEventPort> getOutputEventPorts();

	/**
	 * Returns the value of the '<em><b>Input Data Ports</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.InputDataPort}.
	 * It is bidirectional and its opposite is '{@link cakefeed.InputDataPort#getParentFunctionBlock <em>Parent Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Data Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Data Ports</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getFunctionBlock_InputDataPorts()
	 * @see cakefeed.InputDataPort#getParentFunctionBlock
	 * @model opposite="parentFunctionBlock" containment="true"
	 * @generated
	 */
	EList<InputDataPort> getInputDataPorts();

	/**
	 * Returns the value of the '<em><b>Output Data Ports</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.OutputDataPort}.
	 * It is bidirectional and its opposite is '{@link cakefeed.OutputDataPort#getParentFunctionBlock <em>Parent Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Data Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Data Ports</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getFunctionBlock_OutputDataPorts()
	 * @see cakefeed.OutputDataPort#getParentFunctionBlock
	 * @model opposite="parentFunctionBlock" containment="true"
	 * @generated
	 */
	EList<OutputDataPort> getOutputDataPorts();

} // FunctionBlock
