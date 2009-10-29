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
 * A representation of the model object '<em><b>Input Event Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.InputEventPort#getParentFunctionBlock <em>Parent Function Block</em>}</li>
 *   <li>{@link cakefeed.InputEventPort#getEventConnections <em>Event Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getInputEventPort()
 * @model
 * @generated
 */
public interface InputEventPort extends EventPort {
	/**
	 * Returns the value of the '<em><b>Parent Function Block</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.FunctionBlock#getInputEventPorts <em>Input Event Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Function Block</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Function Block</em>' container reference.
	 * @see #setParentFunctionBlock(FunctionBlock)
	 * @see cakefeed.CakefeedPackage#getInputEventPort_ParentFunctionBlock()
	 * @see cakefeed.FunctionBlock#getInputEventPorts
	 * @model opposite="inputEventPorts" required="true" transient="false"
	 * @generated
	 */
	FunctionBlock getParentFunctionBlock();

	/**
	 * Sets the value of the '{@link cakefeed.InputEventPort#getParentFunctionBlock <em>Parent Function Block</em>}' container reference.
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
	 * It is bidirectional and its opposite is '{@link cakefeed.EventConnection#getTargetEventPort <em>Target Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Connections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Connections</em>' reference list.
	 * @see cakefeed.CakefeedPackage#getInputEventPort_EventConnections()
	 * @see cakefeed.EventConnection#getTargetEventPort
	 * @model opposite="targetEventPort"
	 * @generated
	 */
	EList<EventConnection> getEventConnections();

} // InputEventPort
