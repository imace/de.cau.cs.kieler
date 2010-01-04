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
 * A representation of the model object '<em><b>LD</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.LD#getRung <em>Rung</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getLD()
 * @model extendedMetaData="name='LD_._type' kind='elementOnly'"
 * @generated
 */
public interface LD extends EObject {
	/**
	 * Returns the value of the '<em><b>Rung</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblock.Rung}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rung</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getLD_Rung()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Rung' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Rung> getRung();

} // LD
