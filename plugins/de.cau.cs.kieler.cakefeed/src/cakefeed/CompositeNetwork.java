/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Network</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.CompositeNetwork#getParentCompositeFunctionBlock <em>Parent Composite Function Block</em>}</li>
 *   <li>{@link cakefeed.CompositeNetwork#getInputEvents <em>Input Events</em>}</li>
 *   <li>{@link cakefeed.CompositeNetwork#getOutputEvents <em>Output Events</em>}</li>
 *   <li>{@link cakefeed.CompositeNetwork#getInputData <em>Input Data</em>}</li>
 *   <li>{@link cakefeed.CompositeNetwork#getOutputData <em>Output Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getCompositeNetwork()
 * @model
 * @generated
 */
public interface CompositeNetwork extends Application {
	/**
	 * Returns the value of the '<em><b>Parent Composite Function Block</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.CompositeFunctionBlock#getCompositeNetwork <em>Composite Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Composite Function Block</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Composite Function Block</em>' reference.
	 * @see #setParentCompositeFunctionBlock(CompositeFunctionBlock)
	 * @see cakefeed.CakefeedPackage#getCompositeNetwork_ParentCompositeFunctionBlock()
	 * @see cakefeed.CompositeFunctionBlock#getCompositeNetwork
	 * @model opposite="compositeNetwork" required="true"
	 * @generated
	 */
	CompositeFunctionBlock getParentCompositeFunctionBlock();

	/**
	 * Sets the value of the '{@link cakefeed.CompositeNetwork#getParentCompositeFunctionBlock <em>Parent Composite Function Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Composite Function Block</em>' reference.
	 * @see #getParentCompositeFunctionBlock()
	 * @generated
	 */
	void setParentCompositeFunctionBlock(CompositeFunctionBlock value);

	/**
	 * Returns the value of the '<em><b>Input Events</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.OutputEventPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Events</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getCompositeNetwork_InputEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputEventPort> getInputEvents();

	/**
	 * Returns the value of the '<em><b>Output Events</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.InputEventPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Events</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getCompositeNetwork_OutputEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputEventPort> getOutputEvents();

	/**
	 * Returns the value of the '<em><b>Input Data</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.OutputDataPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Data</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Data</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getCompositeNetwork_InputData()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputDataPort> getInputData();

	/**
	 * Returns the value of the '<em><b>Output Data</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.InputDataPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Data</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Data</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getCompositeNetwork_OutputData()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputDataPort> getOutputData();

} // CompositeNetwork
