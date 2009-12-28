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
 * A representation of the model object '<em><b>BFB Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BFBDiagram#getBFBType <em>BFB Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBFBDiagram()
 * @model
 * @generated
 */
public interface BFBDiagram extends EObject {
	/**
	 * Returns the value of the '<em><b>BFB Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BFB Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BFB Type</em>' containment reference.
	 * @see #setBFBType(BFBType)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBFBDiagram_BFBType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BFBType getBFBType();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.BFBDiagram#getBFBType <em>BFB Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BFB Type</em>' containment reference.
	 * @see #getBFBType()
	 * @generated
	 */
	void setBFBType(BFBType value);

} // BFBDiagram
