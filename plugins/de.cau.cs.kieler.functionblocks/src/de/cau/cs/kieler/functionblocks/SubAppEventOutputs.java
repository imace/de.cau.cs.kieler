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
 * A representation of the model object '<em><b>Sub App Event Outputs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.SubAppEventOutputs#getSubAppEvent <em>Sub App Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSubAppEventOutputs()
 * @model extendedMetaData="name='SubAppEventOutputs_._type' kind='elementOnly'"
 * @generated
 */
public interface SubAppEventOutputs extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub App Event</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblocks.SubAppEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SubAppType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub App Event</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSubAppEventOutputs_SubAppEvent()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='SubAppEvent' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SubAppEvent> getSubAppEvent();

} // SubAppEventOutputs
