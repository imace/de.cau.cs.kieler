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
 * A representation of the model object '<em><b>Input Vars</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.InputVars#getVarDeclaration <em>Var Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getInputVars()
 * @model extendedMetaData="name='InputVars_._type' kind='elementOnly'"
 * @generated
 */
public interface InputVars extends EObject {
	/**
	 * Returns the value of the '<em><b>Var Declaration</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblocks.VarDeclaration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Var Declaration</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getInputVars_VarDeclaration()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='VarDeclaration' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<VarDeclaration> getVarDeclaration();

} // InputVars
