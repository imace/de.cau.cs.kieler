/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compiler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Compiler#getLanguage <em>Language</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Compiler#getProduct <em>Product</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Compiler#getVendor <em>Vendor</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Compiler#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCompiler()
 * @model
 * @generated
 */
public interface Compiler extends EObject {
	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * The literals are from the enumeration {@link de.cau.cs.kieler.cakefeed.Language}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see de.cau.cs.kieler.cakefeed.Language
	 * @see #setLanguage(Language)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCompiler_Language()
	 * @model required="true"
	 * @generated
	 */
	Language getLanguage();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Compiler#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see de.cau.cs.kieler.cakefeed.Language
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(Language value);

	/**
	 * Returns the value of the '<em><b>Product</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product</em>' attribute.
	 * @see #setProduct(String)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCompiler_Product()
	 * @model required="true"
	 * @generated
	 */
	String getProduct();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Compiler#getProduct <em>Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product</em>' attribute.
	 * @see #getProduct()
	 * @generated
	 */
	void setProduct(String value);

	/**
	 * Returns the value of the '<em><b>Vendor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vendor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vendor</em>' attribute.
	 * @see #setVendor(String)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCompiler_Vendor()
	 * @model required="true"
	 * @generated
	 */
	String getVendor();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Compiler#getVendor <em>Vendor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vendor</em>' attribute.
	 * @see #getVendor()
	 * @generated
	 */
	void setVendor(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCompiler_Version()
	 * @model required="true"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Compiler#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

} // Compiler
