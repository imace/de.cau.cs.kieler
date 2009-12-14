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
 * A representation of the model object '<em><b>Output Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.OutputEvent#getWith <em>With</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getOutputEvent()
 * @model
 * @generated
 */
public interface OutputEvent extends Event {
	/**
	 * Returns the value of the '<em><b>With</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.OutputWith}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.cakefeed.OutputWith#getParentOutputEvent <em>Parent Output Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>With</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>With</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getOutputEvent_With()
	 * @see de.cau.cs.kieler.cakefeed.OutputWith#getParentOutputEvent
	 * @model opposite="parentOutputEvent" containment="true"
	 * @generated
	 */
	EList<OutputWith> getWith();

} // OutputEvent
