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
 * A representation of the model object '<em><b>Output Event Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.OutputEventPort#getParentFunctionBlock <em>Parent Function Block</em>}</li>
 *   <li>{@link cakefeed.OutputEventPort#getEventConnections <em>Event Connections</em>}</li>
 *   <li>{@link cakefeed.OutputEventPort#getOutputAssociations <em>Output Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getOutputEventPort()
 * @model
 * @generated
 */
public interface OutputEventPort extends EventPort {
	/**
	 * Returns the value of the '<em><b>Parent Function Block</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.FunctionBlock#getOutputEventPorts <em>Output Event Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Function Block</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Function Block</em>' container reference.
	 * @see #setParentFunctionBlock(FunctionBlock)
	 * @see cakefeed.CakefeedPackage#getOutputEventPort_ParentFunctionBlock()
	 * @see cakefeed.FunctionBlock#getOutputEventPorts
	 * @model opposite="outputEventPorts" required="true" transient="false"
	 * @generated
	 */
	FunctionBlock getParentFunctionBlock();

	/**
	 * Sets the value of the '{@link cakefeed.OutputEventPort#getParentFunctionBlock <em>Parent Function Block</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Function Block</em>' container reference.
	 * @see #getParentFunctionBlock()
	 * @generated
	 */
	void setParentFunctionBlock(FunctionBlock value);

	/**
	 * Returns the value of the '<em><b>Event Connections</b></em>' reference list.
	 * The list contents are of type {@link cakefeed.EventConnection}.
	 * It is bidirectional and its opposite is '{@link cakefeed.EventConnection#getSourceEventPort <em>Source Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Connections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Connections</em>' reference list.
	 * @see cakefeed.CakefeedPackage#getOutputEventPort_EventConnections()
	 * @see cakefeed.EventConnection#getSourceEventPort
	 * @model opposite="sourceEventPort"
	 * @generated
	 */
	EList<EventConnection> getEventConnections();

	/**
	 * Returns the value of the '<em><b>Output Associations</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.OutputAssociation}.
	 * It is bidirectional and its opposite is '{@link cakefeed.OutputAssociation#getSourceOutputEventPort <em>Source Output Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Associations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Associations</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getOutputEventPort_OutputAssociations()
	 * @see cakefeed.OutputAssociation#getSourceOutputEventPort
	 * @model opposite="sourceOutputEventPort" containment="true"
	 * @generated
	 */
	EList<OutputAssociation> getOutputAssociations();

} // OutputEventPort
