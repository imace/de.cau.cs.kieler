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
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.Port#getPortName <em>Port Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getPort()
 * @model abstract="true"
 * @generated
 */
public interface Port extends EObject {
	/**
	 * Returns the value of the '<em><b>Port Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Name</em>' attribute.
	 * @see #setPortName(String)
	 * @see cakefeed.CakefeedPackage#getPort_PortName()
	 * @model required="true"
	 * @generated
	 */
	String getPortName();

	/**
	 * Sets the value of the '{@link cakefeed.Port#getPortName <em>Port Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Name</em>' attribute.
	 * @see #getPortName()
	 * @generated
	 */
	void setPortName(String value);

} // Port
