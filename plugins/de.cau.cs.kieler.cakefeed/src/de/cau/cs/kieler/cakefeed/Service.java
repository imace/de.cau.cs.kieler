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
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Service#getServiceSequences <em>Service Sequences</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Service#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Service#getRightInterface <em>Right Interface</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Service#getLeftInterface <em>Left Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getService()
 * @model
 * @generated
 */
public interface Service extends EObject {
	/**
	 * Returns the value of the '<em><b>Service Sequences</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.ServiceSequence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Sequences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Sequences</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getService_ServiceSequences()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ServiceSequence> getServiceSequences();

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getService_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Service#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Right Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Interface</em>' attribute.
	 * @see #setRightInterface(String)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getService_RightInterface()
	 * @model required="true"
	 * @generated
	 */
	String getRightInterface();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Service#getRightInterface <em>Right Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Interface</em>' attribute.
	 * @see #getRightInterface()
	 * @generated
	 */
	void setRightInterface(String value);

	/**
	 * Returns the value of the '<em><b>Left Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Interface</em>' attribute.
	 * @see #setLeftInterface(String)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getService_LeftInterface()
	 * @model required="true"
	 * @generated
	 */
	String getLeftInterface();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Service#getLeftInterface <em>Left Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Interface</em>' attribute.
	 * @see #getLeftInterface()
	 * @generated
	 */
	void setLeftInterface(String value);

} // Service
