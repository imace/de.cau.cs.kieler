/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.Association#getParentEventConnection <em>Parent Event Connection</em>}</li>
 *   <li>{@link cakefeed.Association#getAssociatedDataConnection <em>Associated Data Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent Event Connection</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.EventConnection#getAssociations <em>Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Event Connection</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Event Connection</em>' container reference.
	 * @see #setParentEventConnection(EventConnection)
	 * @see cakefeed.CakefeedPackage#getAssociation_ParentEventConnection()
	 * @see cakefeed.EventConnection#getAssociations
	 * @model opposite="associations" required="true" transient="false"
	 * @generated
	 */
	EventConnection getParentEventConnection();

	/**
	 * Sets the value of the '{@link cakefeed.Association#getParentEventConnection <em>Parent Event Connection</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Event Connection</em>' container reference.
	 * @see #getParentEventConnection()
	 * @generated
	 */
	void setParentEventConnection(EventConnection value);

	/**
	 * Returns the value of the '<em><b>Associated Data Connection</b></em>' reference list.
	 * The list contents are of type {@link cakefeed.DataConnection}.
	 * It is bidirectional and its opposite is '{@link cakefeed.DataConnection#getAssociations <em>Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Data Connection</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Data Connection</em>' reference list.
	 * @see cakefeed.CakefeedPackage#getAssociation_AssociatedDataConnection()
	 * @see cakefeed.DataConnection#getAssociations
	 * @model opposite="associations" required="true"
	 * @generated
	 */
	EList<DataConnection> getAssociatedDataConnection();

} // Association
