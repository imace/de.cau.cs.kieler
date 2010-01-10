/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Inputs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.EventInputs#getEvent <em>Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getEventInputs()
 * @model extendedMetaData="name='EventInputs_._type' kind='elementOnly'"
 * @generated
 */
public interface EventInputs extends EObject {
	/**
	 * Returns the value of the '<em><b>Event</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblocks.Event}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Event</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getEventInputs_Event()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Event' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Event> getEvent();

} // EventInputs
