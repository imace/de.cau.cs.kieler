/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed;


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
	 * Returns the value of the '<em><b>Parent Composite Function Block</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.CompositeFunctionBlock#getCompositeNetwork <em>Composite Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Composite Function Block</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Composite Function Block</em>' container reference.
	 * @see #setParentCompositeFunctionBlock(CompositeFunctionBlock)
	 * @see cakefeed.CakefeedPackage#getCompositeNetwork_ParentCompositeFunctionBlock()
	 * @see cakefeed.CompositeFunctionBlock#getCompositeNetwork
	 * @model opposite="compositeNetwork" required="true" transient="false"
	 * @generated
	 */
	CompositeFunctionBlock getParentCompositeFunctionBlock();

	/**
	 * Sets the value of the '{@link cakefeed.CompositeNetwork#getParentCompositeFunctionBlock <em>Parent Composite Function Block</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Composite Function Block</em>' container reference.
	 * @see #getParentCompositeFunctionBlock()
	 * @generated
	 */
	void setParentCompositeFunctionBlock(CompositeFunctionBlock value);

	/**
	 * Returns the value of the '<em><b>Input Events</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Events</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Events</em>' containment reference.
	 * @see #setInputEvents(OutputEventPort)
	 * @see cakefeed.CakefeedPackage#getCompositeNetwork_InputEvents()
	 * @model containment="true"
	 * @generated
	 */
	OutputEventPort getInputEvents();

	/**
	 * Sets the value of the '{@link cakefeed.CompositeNetwork#getInputEvents <em>Input Events</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Events</em>' containment reference.
	 * @see #getInputEvents()
	 * @generated
	 */
	void setInputEvents(OutputEventPort value);

	/**
	 * Returns the value of the '<em><b>Output Events</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Events</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Events</em>' containment reference.
	 * @see #setOutputEvents(InputEventPort)
	 * @see cakefeed.CakefeedPackage#getCompositeNetwork_OutputEvents()
	 * @model containment="true"
	 * @generated
	 */
	InputEventPort getOutputEvents();

	/**
	 * Sets the value of the '{@link cakefeed.CompositeNetwork#getOutputEvents <em>Output Events</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Events</em>' containment reference.
	 * @see #getOutputEvents()
	 * @generated
	 */
	void setOutputEvents(InputEventPort value);

	/**
	 * Returns the value of the '<em><b>Input Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Data</em>' containment reference.
	 * @see #setInputData(OutputDataPort)
	 * @see cakefeed.CakefeedPackage#getCompositeNetwork_InputData()
	 * @model containment="true"
	 * @generated
	 */
	OutputDataPort getInputData();

	/**
	 * Sets the value of the '{@link cakefeed.CompositeNetwork#getInputData <em>Input Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Data</em>' containment reference.
	 * @see #getInputData()
	 * @generated
	 */
	void setInputData(OutputDataPort value);

	/**
	 * Returns the value of the '<em><b>Output Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Data</em>' containment reference.
	 * @see #setOutputData(InputDataPort)
	 * @see cakefeed.CakefeedPackage#getCompositeNetwork_OutputData()
	 * @model containment="true"
	 * @generated
	 */
	InputDataPort getOutputData();

	/**
	 * Sets the value of the '{@link cakefeed.CompositeNetwork#getOutputData <em>Output Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Data</em>' containment reference.
	 * @see #getOutputData()
	 * @generated
	 */
	void setOutputData(InputDataPort value);

} // CompositeNetwork
