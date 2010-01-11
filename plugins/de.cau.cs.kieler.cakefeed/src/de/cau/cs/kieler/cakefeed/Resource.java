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
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Resource#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Resource#getFBNetwork <em>FB Network</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Resource#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getResource()
 * @model
 * @generated
 */
public interface Resource extends NamedAndCommented {
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
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getResource_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>FB Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FB Network</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FB Network</em>' reference.
	 * @see #setFBNetwork(FBNetwork)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getResource_FBNetwork()
	 * @model
	 * @generated
	 */
	FBNetwork getFBNetwork();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Resource#getFBNetwork <em>FB Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FB Network</em>' reference.
	 * @see #getFBNetwork()
	 * @generated
	 */
	void setFBNetwork(FBNetwork value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(ResourceType)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getResource_Type()
	 * @model required="true"
	 * @generated
	 */
	ResourceType getType();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Resource#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ResourceType value);

} // Resource
