/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cakefeed.DataConnection#getSourceDataPort <em>Source Data Port</em>}</li>
 *   <li>{@link Cakefeed.DataConnection#getTargetDataPort <em>Target Data Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cakefeed.CakefeedPackage#getDataConnection()
 * @model
 * @generated
 */
public interface DataConnection extends Connection {
	/**
	 * Returns the value of the '<em><b>Source Data Port</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link Cakefeed.OutputDataPort#getEventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Data Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Data Port</em>' reference.
	 * @see #setSourceDataPort(OutputDataPort)
	 * @see Cakefeed.CakefeedPackage#getDataConnection_SourceDataPort()
	 * @see Cakefeed.OutputDataPort#getEventConnections
	 * @model opposite="eventConnections" required="true"
	 * @generated
	 */
	OutputDataPort getSourceDataPort();

	/**
	 * Sets the value of the '{@link Cakefeed.DataConnection#getSourceDataPort <em>Source Data Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Data Port</em>' reference.
	 * @see #getSourceDataPort()
	 * @generated
	 */
	void setSourceDataPort(OutputDataPort value);

	/**
	 * Returns the value of the '<em><b>Target Data Port</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link Cakefeed.InputDataPort#getEventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Data Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Data Port</em>' reference.
	 * @see #setTargetDataPort(InputDataPort)
	 * @see Cakefeed.CakefeedPackage#getDataConnection_TargetDataPort()
	 * @see Cakefeed.InputDataPort#getEventConnections
	 * @model opposite="eventConnections" required="true"
	 * @generated
	 */
	InputDataPort getTargetDataPort();

	/**
	 * Sets the value of the '{@link Cakefeed.DataConnection#getTargetDataPort <em>Target Data Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Data Port</em>' reference.
	 * @see #getTargetDataPort()
	 * @generated
	 */
	void setTargetDataPort(InputDataPort value);

} // DataConnection
