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
 * A representation of the model object '<em><b>Plugs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.Plugs#getAdapterDeclaration <em>Adapter Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getPlugs()
 * @model extendedMetaData="name='Plugs_._type' kind='elementOnly'"
 * @generated
 */
public interface Plugs extends EObject {
	/**
	 * Returns the value of the '<em><b>Adapter Declaration</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblock.AdapterDeclaration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Adapter Declaration</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getPlugs_AdapterDeclaration()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='AdapterDeclaration' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AdapterDeclaration> getAdapterDeclaration();

} // Plugs
