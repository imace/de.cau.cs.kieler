/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Application#getFBNetwork <em>FB Network</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getApplication()
 * @model
 * @generated
 */
public interface Application extends NamedAndCommented {
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
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getApplication_FBNetwork()
	 * @model required="true"
	 * @generated
	 */
	FunctionBlockNetwork getFBNetwork();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Application#getFBNetwork <em>FB Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FB Network</em>' reference.
	 * @see #getFBNetwork()
	 * @generated
	 */
	void setFBNetwork(FunctionBlockNetwork value);

} // Application
