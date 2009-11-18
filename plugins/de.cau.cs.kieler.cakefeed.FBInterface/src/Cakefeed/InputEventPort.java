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
 * A representation of the model object '<em><b>Input Event Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cakefeed.InputEventPort#getParentFunctionBlock <em>Parent Function Block</em>}</li>
 *   <li>{@link Cakefeed.InputEventPort#getEventConnections <em>Event Connections</em>}</li>
 *   <li>{@link Cakefeed.InputEventPort#getInputAssociations <em>Input Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cakefeed.CakefeedPackage#getInputEventPort()
 * @model
 * @generated
 */
public interface InputEventPort extends EventPort {
	/**
	 * Returns the value of the '<em><b>Parent Function Block</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link Cakefeed.FunctionBlock#getInputEventPorts <em>Input Event Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Function Block</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Function Block</em>' container reference.
	 * @see #setParentFunctionBlock(FunctionBlock)
	 * @see Cakefeed.CakefeedPackage#getInputEventPort_ParentFunctionBlock()
	 * @see Cakefeed.FunctionBlock#getInputEventPorts
	 * @model opposite="inputEventPorts" required="true" transient="false"
	 * @generated
	 */
	FunctionBlock getParentFunctionBlock();

	/**
	 * Sets the value of the '{@link Cakefeed.InputEventPort#getParentFunctionBlock <em>Parent Function Block</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Function Block</em>' container reference.
	 * @see #getParentFunctionBlock()
	 * @generated
	 */
	void setParentFunctionBlock(FunctionBlock value);

	/**
	 * Returns the value of the '<em><b>Event Connections</b></em>' reference list.
	 * The list contents are of type {@link Cakefeed.EventConnection}.
	 * It is bidirectional and its opposite is '{@link Cakefeed.EventConnection#getTargetEventPort <em>Target Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Connections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Connections</em>' reference list.
	 * @see Cakefeed.CakefeedPackage#getInputEventPort_EventConnections()
	 * @see Cakefeed.EventConnection#getTargetEventPort
	 * @model opposite="targetEventPort"
	 * @generated
	 */
	EList<EventConnection> getEventConnections();

	/**
	 * Returns the value of the '<em><b>Input Associations</b></em>' containment reference list.
	 * The list contents are of type {@link Cakefeed.InputAssociation}.
	 * It is bidirectional and its opposite is '{@link Cakefeed.InputAssociation#getSourceInputEventPort <em>Source Input Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Associations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Associations</em>' containment reference list.
	 * @see Cakefeed.CakefeedPackage#getInputEventPort_InputAssociations()
	 * @see Cakefeed.InputAssociation#getSourceInputEventPort
	 * @model opposite="sourceInputEventPort" containment="true"
	 * @generated
	 */
	EList<InputAssociation> getInputAssociations();

} // InputEventPort
