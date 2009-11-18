/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Data Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cakefeed.InputDataPort#getParentFunctionBlock <em>Parent Function Block</em>}</li>
 *   <li>{@link Cakefeed.InputDataPort#getEventConnections <em>Event Connections</em>}</li>
 *   <li>{@link Cakefeed.InputDataPort#getInputAssociations <em>Input Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cakefeed.CakefeedPackage#getInputDataPort()
 * @model
 * @generated
 */
public interface InputDataPort extends DataPort {
	/**
	 * Returns the value of the '<em><b>Parent Function Block</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link Cakefeed.FunctionBlock#getInputDataPorts <em>Input Data Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Function Block</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Function Block</em>' container reference.
	 * @see #setParentFunctionBlock(FunctionBlock)
	 * @see Cakefeed.CakefeedPackage#getInputDataPort_ParentFunctionBlock()
	 * @see Cakefeed.FunctionBlock#getInputDataPorts
	 * @model opposite="inputDataPorts" required="true" transient="false"
	 * @generated
	 */
	FunctionBlock getParentFunctionBlock();

	/**
	 * Sets the value of the '{@link Cakefeed.InputDataPort#getParentFunctionBlock <em>Parent Function Block</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Function Block</em>' container reference.
	 * @see #getParentFunctionBlock()
	 * @generated
	 */
	void setParentFunctionBlock(FunctionBlock value);

	/**
	 * Returns the value of the '<em><b>Event Connections</b></em>' reference list.
	 * The list contents are of type {@link Cakefeed.DataConnection}.
	 * It is bidirectional and its opposite is '{@link Cakefeed.DataConnection#getTargetDataPort <em>Target Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Connections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Connections</em>' reference list.
	 * @see Cakefeed.CakefeedPackage#getInputDataPort_EventConnections()
	 * @see Cakefeed.DataConnection#getTargetDataPort
	 * @model opposite="targetDataPort"
	 * @generated
	 */
	EList<DataConnection> getEventConnections();

	/**
	 * Returns the value of the '<em><b>Input Associations</b></em>' reference list.
	 * The list contents are of type {@link Cakefeed.InputAssociation}.
	 * It is bidirectional and its opposite is '{@link Cakefeed.InputAssociation#getTargetInputDataPort <em>Target Input Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Associations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Associations</em>' reference list.
	 * @see Cakefeed.CakefeedPackage#getInputDataPort_InputAssociations()
	 * @see Cakefeed.InputAssociation#getTargetInputDataPort
	 * @model opposite="targetInputDataPort"
	 * @generated
	 */
	EList<InputAssociation> getInputAssociations();

} // InputDataPort
