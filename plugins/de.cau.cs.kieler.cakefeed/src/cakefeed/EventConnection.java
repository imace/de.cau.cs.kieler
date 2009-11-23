/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.EventConnection#getSourceEventPort <em>Source Event Port</em>}</li>
 *   <li>{@link cakefeed.EventConnection#getTargetEventPort <em>Target Event Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getEventConnection()
 * @model
 * @generated
 */
public interface EventConnection extends Connection {
	/**
	 * Returns the value of the '<em><b>Source Event Port</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.OutputEventPort#getEventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Event Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Event Port</em>' reference.
	 * @see #setSourceEventPort(OutputEventPort)
	 * @see cakefeed.CakefeedPackage#getEventConnection_SourceEventPort()
	 * @see cakefeed.OutputEventPort#getEventConnections
	 * @model opposite="eventConnections" required="true"
	 * @generated
	 */
	OutputEventPort getSourceEventPort();

	/**
	 * Sets the value of the '{@link cakefeed.EventConnection#getSourceEventPort <em>Source Event Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Event Port</em>' reference.
	 * @see #getSourceEventPort()
	 * @generated
	 */
	void setSourceEventPort(OutputEventPort value);

	/**
	 * Returns the value of the '<em><b>Target Event Port</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.InputEventPort#getEventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Event Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Event Port</em>' reference.
	 * @see #setTargetEventPort(InputEventPort)
	 * @see cakefeed.CakefeedPackage#getEventConnection_TargetEventPort()
	 * @see cakefeed.InputEventPort#getEventConnections
	 * @model opposite="eventConnections" required="true"
	 * @generated
	 */
	InputEventPort getTargetEventPort();

	/**
	 * Sets the value of the '{@link cakefeed.EventConnection#getTargetEventPort <em>Target Event Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Event Port</em>' reference.
	 * @see #getTargetEventPort()
	 * @generated
	 */
	void setTargetEventPort(InputEventPort value);

} // EventConnection
