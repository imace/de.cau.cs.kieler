/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cakefeed.DataPort#getPortType <em>Port Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cakefeed.CakefeedPackage#getDataPort()
 * @model abstract="true"
 * @generated
 */
public interface DataPort extends Port {
	/**
	 * Returns the value of the '<em><b>Port Type</b></em>' attribute.
	 * The literals are from the enumeration {@link Cakefeed.PortType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Type</em>' attribute.
	 * @see Cakefeed.PortType
	 * @see #setPortType(PortType)
	 * @see Cakefeed.CakefeedPackage#getDataPort_PortType()
	 * @model required="true"
	 * @generated
	 */
	PortType getPortType();

	/**
	 * Sets the value of the '{@link Cakefeed.DataPort#getPortType <em>Port Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Type</em>' attribute.
	 * @see Cakefeed.PortType
	 * @see #getPortType()
	 * @generated
	 */
	void setPortType(PortType value);

} // DataPort
