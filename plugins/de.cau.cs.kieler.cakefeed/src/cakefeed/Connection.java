/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.Connection#getParentApplication <em>Parent Application</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent Application</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.Application#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Application</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Application</em>' container reference.
	 * @see #setParentApplication(Application)
	 * @see cakefeed.CakefeedPackage#getConnection_ParentApplication()
	 * @see cakefeed.Application#getConnections
	 * @model opposite="connections" required="true" transient="false"
	 * @generated
	 */
	Application getParentApplication();

	/**
	 * Sets the value of the '{@link cakefeed.Connection#getParentApplication <em>Parent Application</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Application</em>' container reference.
	 * @see #getParentApplication()
	 * @generated
	 */
	void setParentApplication(Application value);

} // Connection
