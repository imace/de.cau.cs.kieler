/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblock;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub App Event Inputs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.SubAppEventInputs#getSubAppEvent <em>Sub App Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getSubAppEventInputs()
 * @model extendedMetaData="name='SubAppEventInputs_._type' kind='elementOnly'"
 * @generated
 */
public interface SubAppEventInputs extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub App Event</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblock.SubAppEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SubAppType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub App Event</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getSubAppEventInputs_SubAppEvent()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='SubAppEvent' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SubAppEvent> getSubAppEvent();

} // SubAppEventInputs
