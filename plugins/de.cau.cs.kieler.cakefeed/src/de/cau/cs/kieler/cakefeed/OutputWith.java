/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output With</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.OutputWith#getParentOutputEvent <em>Parent Output Event</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.OutputWith#getWith <em>With</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getOutputWith()
 * @model
 * @generated
 */
public interface OutputWith extends With {
	/**
	 * Returns the value of the '<em><b>Parent Output Event</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.cakefeed.OutputEvent#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Output Event</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Output Event</em>' container reference.
	 * @see #setParentOutputEvent(OutputEvent)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getOutputWith_ParentOutputEvent()
	 * @see de.cau.cs.kieler.cakefeed.OutputEvent#getWith
	 * @model opposite="With" required="true" transient="false"
	 * @generated
	 */
	OutputEvent getParentOutputEvent();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.OutputWith#getParentOutputEvent <em>Parent Output Event</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Output Event</em>' container reference.
	 * @see #getParentOutputEvent()
	 * @generated
	 */
	void setParentOutputEvent(OutputEvent value);

	/**
	 * Returns the value of the '<em><b>With</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>With</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>With</em>' reference.
	 * @see #setWith(OutputVar)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getOutputWith_With()
	 * @model
	 * @generated
	 */
	OutputVar getWith();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.OutputWith#getWith <em>With</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>With</em>' reference.
	 * @see #getWith()
	 * @generated
	 */
	void setWith(OutputVar value);

} // OutputWith
