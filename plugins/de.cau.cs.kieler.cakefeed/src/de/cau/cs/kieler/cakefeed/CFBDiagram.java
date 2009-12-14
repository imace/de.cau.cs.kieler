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
 * A representation of the model object '<em><b>CFB Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.CFBDiagram#getCFBType <em>CFB Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCFBDiagram()
 * @model
 * @generated
 */
public interface CFBDiagram extends EObject {
	/**
	 * Returns the value of the '<em><b>CFB Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CFB Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CFB Type</em>' containment reference.
	 * @see #setCFBType(CFBType)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCFBDiagram_CFBType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CFBType getCFBType();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.CFBDiagram#getCFBType <em>CFB Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CFB Type</em>' containment reference.
	 * @see #getCFBType()
	 * @generated
	 */
	void setCFBType(CFBType value);

} // CFBDiagram
