/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FBFB Data Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.FBFBDataConnection#getDestination <em>Destination</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.FBFBDataConnection#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFBFBDataConnection()
 * @model
 * @generated
 */
public interface FBFBDataConnection extends DataConnection {
	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(FBInputVar)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFBFBDataConnection_Destination()
	 * @model required="true"
	 * @generated
	 */
	FBInputVar getDestination();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.FBFBDataConnection#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(FBInputVar value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(FBOutputVar)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFBFBDataConnection_Source()
	 * @model required="true"
	 * @generated
	 */
	FBOutputVar getSource();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.FBFBDataConnection#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(FBOutputVar value);

} // FBFBDataConnection
