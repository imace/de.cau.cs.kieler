/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CFB Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.CFBType#getFB <em>FB</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.CFBType#getEventConnections <em>Event Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.CFBType#getDataConnections <em>Data Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.CFBType#getAdapterConnections <em>Adapter Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.CFBType#getService <em>Service</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCFBType()
 * @model
 * @generated
 */
public interface CFBType extends FBType {
	/**
	 * Returns the value of the '<em><b>FB</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.FB}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FB</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FB</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCFBType_FB()
	 * @model containment="true"
	 * @generated
	 */
	EList<FB> getFB();

	/**
	 * Returns the value of the '<em><b>Event Connections</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.EventConnection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Connections</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCFBType_EventConnections()
	 * @model containment="true"
	 * @generated
	 */
	EList<EventConnection> getEventConnections();

	/**
	 * Returns the value of the '<em><b>Data Connections</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.DataConnection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Connections</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCFBType_DataConnections()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataConnection> getDataConnections();

	/**
	 * Returns the value of the '<em><b>Adapter Connections</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.AdapterConnection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapter Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapter Connections</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCFBType_AdapterConnections()
	 * @model containment="true"
	 * @generated
	 */
	EList<AdapterConnection> getAdapterConnections();

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
