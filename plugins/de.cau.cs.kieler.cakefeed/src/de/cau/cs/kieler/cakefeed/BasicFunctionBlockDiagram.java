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
 * A representation of the model object '<em><b>Basic Function Block Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BasicFunctionBlockDiagram#getBFBType <em>BFB Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBasicFunctionBlockDiagram()
 * @model
 * @generated
 */
public interface BasicFunctionBlockDiagram extends EObject {
	/**
	 * Returns the value of the '<em><b>BFB Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BFB Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BFB Type</em>' containment reference.
	 * @see #setBFBType(BasicFunctionBlockType)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBasicFunctionBlockDiagram_BFBType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BasicFunctionBlockType getBFBType();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.BasicFunctionBlockDiagram#getBFBType <em>BFB Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BFB Type</em>' containment reference.
	 * @see #getBFBType()
	 * @generated
	 */
	void setBFBType(BasicFunctionBlockType value);

} // BasicFunctionBlockDiagram
