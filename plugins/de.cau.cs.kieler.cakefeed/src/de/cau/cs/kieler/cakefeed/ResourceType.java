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
 * A representation of the model object '<em><b>Resource Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.ResourceType#getVarDeclarations <em>Var Declarations</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.ResourceType#getFBNetwork <em>FB Network</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.ResourceType#getFBNames <em>FB Names</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getResourceType()
 * @model
 * @generated
 */
public interface ResourceType extends Compilable, NamedAndCommented {
	/**
	 * Returns the value of the '<em><b>Var Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.InternalVar}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Declarations</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getResourceType_VarDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<InternalVar> getVarDeclarations();

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
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getResourceType_FBNetwork()
	 * @model required="true"
	 * @generated
	 */
	FunctionBlockNetwork getFBNetwork();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.ResourceType#getFBNetwork <em>FB Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FB Network</em>' reference.
	 * @see #getFBNetwork()
	 * @generated
	 */
	void setFBNetwork(FunctionBlockNetwork value);

	/**
	 * Returns the value of the '<em><b>FB Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FB Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FB Names</em>' attribute list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getResourceType_FBNames()
	 * @model
	 * @generated
	 */
	EList<String> getFBNames();

} // ResourceType
