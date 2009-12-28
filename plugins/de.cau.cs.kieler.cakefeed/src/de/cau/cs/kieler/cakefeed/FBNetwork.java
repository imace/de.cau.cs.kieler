/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FB Network</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.FBNetwork#getFBs <em>FBs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.FBNetwork#getEventConnections <em>Event Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.FBNetwork#getDataConnections <em>Data Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.FBNetwork#getAdapterConnections <em>Adapter Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFBNetwork()
 * @model
 * @generated
 */
public interface FBNetwork extends EObject {
	/**
	 * Returns the value of the '<em><b>FBs</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.FB}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FBs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FBs</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFBNetwork_FBs()
	 * @model containment="true"
	 * @generated
	 */
	EList<FB> getFBs();

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
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFBNetwork_EventConnections()
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
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFBNetwork_DataConnections()
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
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFBNetwork_AdapterConnections()
	 * @model containment="true"
	 * @generated
	 */
	EList<AdapterConnection> getAdapterConnections();

} // FBNetwork
