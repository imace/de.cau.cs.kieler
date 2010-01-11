/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CFB Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.CFBType#getService <em>Service</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCFBType()
 * @model
 * @generated
 */
public interface CFBType extends FBType, FBNetwork {
	/**
	 * Returns the value of the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' containment reference.
	 * @see #setService(Service)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCFBType_Service()
	 * @model containment="true"
	 * @generated
	 */
	Service getService();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.CFBType#getService <em>Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' containment reference.
	 * @see #getService()
	 * @generated
	 */
	void setService(Service value);

} // CFBType
