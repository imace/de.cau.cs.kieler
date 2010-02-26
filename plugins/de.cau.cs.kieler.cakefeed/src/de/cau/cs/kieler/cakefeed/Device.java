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
 * A representation of the model object '<em><b>Device</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Device#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Device#getResources <em>Resources</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Device#getFBNetwork <em>FB Network</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Device#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getDevice()
 * @model
 * @generated
 */
public interface Device extends NamedAndCommented {
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
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getDevice_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getDevice_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<Resource> getResources();

	/**
	 * Returns the value of the '<em><b>FB Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FB Network</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FB Network</em>' reference.
	 * @see #setFBNetwork(FunctionBlockNetwork)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getDevice_FBNetwork()
	 * @model
	 * @generated
	 */
	FunctionBlockNetwork getFBNetwork();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Device#getFBNetwork <em>FB Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FB Network</em>' reference.
	 * @see #getFBNetwork()
	 * @generated
	 */
	void setFBNetwork(FunctionBlockNetwork value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(DeviceType)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getDevice_Type()
	 * @model required="true"
	 * @generated
	 */
	DeviceType getType();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Device#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(DeviceType value);

} // Device
