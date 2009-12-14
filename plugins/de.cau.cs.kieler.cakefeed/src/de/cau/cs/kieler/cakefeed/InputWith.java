/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input With</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.InputWith#getParentInputEvent <em>Parent Input Event</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.InputWith#getWith <em>With</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getInputWith()
 * @model
 * @generated
 */
public interface InputWith extends With {
	/**
	 * Returns the value of the '<em><b>Parent Input Event</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.cakefeed.InputEvent#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Input Event</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Input Event</em>' container reference.
	 * @see #setParentInputEvent(InputEvent)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getInputWith_ParentInputEvent()
	 * @see de.cau.cs.kieler.cakefeed.InputEvent#getWith
	 * @model opposite="With" required="true" transient="false"
	 * @generated
	 */
	InputEvent getParentInputEvent();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.InputWith#getParentInputEvent <em>Parent Input Event</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Input Event</em>' container reference.
	 * @see #getParentInputEvent()
	 * @generated
	 */
	void setParentInputEvent(InputEvent value);

	/**
	 * Returns the value of the '<em><b>With</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>With</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>With</em>' reference.
	 * @see #setWith(InputVar)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getInputWith_With()
	 * @model
	 * @generated
	 */
	InputVar getWith();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.InputWith#getWith <em>With</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>With</em>' reference.
	 * @see #getWith()
	 * @generated
	 */
	void setWith(InputVar value);

} // InputWith
