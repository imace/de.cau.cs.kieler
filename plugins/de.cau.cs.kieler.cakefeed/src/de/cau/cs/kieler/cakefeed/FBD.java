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
 * A representation of the model object '<em><b>FBD</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.FBD#getFBs <em>FBs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.FBD#getDataConnections <em>Data Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFBD()
 * @model
 * @generated
 */
public interface FBD extends NamedAndCommented {
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
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFBD_FBs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<FB> getFBs();

	/**
	 * Returns the value of the '<em><b>Data Connections</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.FBFBDataConnection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Connections</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFBD_DataConnections()
	 * @model containment="true"
	 * @generated
	 */
	EList<FBFBDataConnection> getDataConnections();

} // FBD
