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
 * A representation of the model object '<em><b>Output Data Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.OutputDataPort#getParentFunctionBlock <em>Parent Function Block</em>}</li>
 *   <li>{@link cakefeed.OutputDataPort#getEventConnections <em>Event Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getOutputDataPort()
 * @model
 * @generated
 */
public interface OutputDataPort extends DataPort {
	/**
	 * Returns the value of the '<em><b>Parent Function Block</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.FunctionBlock#getOutputDataPorts <em>Output Data Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Function Block</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Function Block</em>' container reference.
	 * @see #setParentFunctionBlock(FunctionBlock)
	 * @see cakefeed.CakefeedPackage#getOutputDataPort_ParentFunctionBlock()
	 * @see cakefeed.FunctionBlock#getOutputDataPorts
	 * @model opposite="outputDataPorts" required="true" transient="false"
	 * @generated
	 */
	FunctionBlock getParentFunctionBlock();

	/**
	 * Sets the value of the '{@link cakefeed.OutputDataPort#getParentFunctionBlock <em>Parent Function Block</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Function Block</em>' container reference.
	 * @see #getParentFunctionBlock()
	 * @generated
	 */
	void setParentFunctionBlock(FunctionBlock value);

	/**
	 * Returns the value of the '<em><b>Event Connections</b></em>' reference list.
	 * The list contents are of type {@link cakefeed.DataConnection}.
	 * It is bidirectional and its opposite is '{@link cakefeed.DataConnection#getSourceDataPort <em>Source Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Connections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Connections</em>' reference list.
	 * @see cakefeed.CakefeedPackage#getOutputDataPort_EventConnections()
	 * @see cakefeed.DataConnection#getSourceDataPort
	 * @model opposite="sourceDataPort"
	 * @generated
	 */
	EList<DataConnection> getEventConnections();

} // OutputDataPort
