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
 * A representation of the model object '<em><b>IF Input Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.IFInputEvent#getWith <em>With</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getIFInputEvent()
 * @model
 * @generated
 */
public interface IFInputEvent extends Event {
	/**
	 * Returns the value of the '<em><b>With</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.InputWith}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.cakefeed.InputWith#getParentInputEvent <em>Parent Input Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>With</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>With</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getIFInputEvent_With()
	 * @see de.cau.cs.kieler.cakefeed.InputWith#getParentInputEvent
	 * @model opposite="parentInputEvent" containment="true"
	 * @generated
	 */
	EList<InputWith> getWith();

} // IFInputEvent
