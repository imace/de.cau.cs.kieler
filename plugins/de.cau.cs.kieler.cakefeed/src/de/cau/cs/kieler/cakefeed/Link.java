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
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Link#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Link#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Link#getCommResource <em>Comm Resource</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Link#getSegmentName <em>Segment Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getLink()
 * @model
 * @generated
 */
public interface Link extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getLink_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

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
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getLink_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Link#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Comm Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comm Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comm Resource</em>' attribute.
	 * @see #setCommResource(String)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getLink_CommResource()
	 * @model required="true"
	 * @generated
	 */
	String getCommResource();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Link#getCommResource <em>Comm Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comm Resource</em>' attribute.
	 * @see #getCommResource()
	 * @generated
	 */
	void setCommResource(String value);

	/**
	 * Returns the value of the '<em><b>Segment Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Segment Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segment Name</em>' attribute.
	 * @see #setSegmentName(String)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getLink_SegmentName()
	 * @model
	 * @generated
	 */
	String getSegmentName();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Link#getSegmentName <em>Segment Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Segment Name</em>' attribute.
	 * @see #getSegmentName()
	 * @generated
	 */
	void setSegmentName(String value);

} // Link
