/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cakefeed.EventConnection#getSourceEventPort <em>Source Event Port</em>}</li>
 *   <li>{@link Cakefeed.EventConnection#getTargetEventPort <em>Target Event Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cakefeed.CakefeedPackage#getEventConnection()
 * @model
 * @generated
 */
public interface EventConnection extends Connection {
	/**
	 * Returns the value of the '<em><b>Source Event Port</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link Cakefeed.OutputEventPort#getEventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Event Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Event Port</em>' reference.
	 * @see #setSourceEventPort(OutputEventPort)
	 * @see Cakefeed.CakefeedPackage#getEventConnection_SourceEventPort()
	 * @see Cakefeed.OutputEventPort#getEventConnections
	 * @model opposite="eventConnections" required="true"
	 * @generated
	 */
	OutputEventPort getSourceEventPort();

	/**
	 * Sets the value of the '{@link Cakefeed.EventConnection#getSourceEventPort <em>Source Event Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Event Port</em>' reference.
	 * @see #getSourceEventPort()
	 * @generated
	 */
	void setSourceEventPort(OutputEventPort value);

	/**
	 * Returns the value of the '<em><b>Target Event Port</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link Cakefeed.InputEventPort#getEventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Event Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Event Port</em>' reference.
	 * @see #setTargetEventPort(InputEventPort)
	 * @see Cakefeed.CakefeedPackage#getEventConnection_TargetEventPort()
	 * @see Cakefeed.InputEventPort#getEventConnections
	 * @model opposite="eventConnections" required="true"
	 * @generated
	 */
	InputEventPort getTargetEventPort();

	/**
	 * Sets the value of the '{@link Cakefeed.EventConnection#getTargetEventPort <em>Target Event Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Event Port</em>' reference.
	 * @see #getTargetEventPort()
	 * @generated
	 */
	void setTargetEventPort(InputEventPort value);

} // EventConnection
