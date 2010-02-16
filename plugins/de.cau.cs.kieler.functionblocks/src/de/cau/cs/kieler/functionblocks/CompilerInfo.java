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
 * A representation of the model object '<em><b>Compiler Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.CompilerInfo#getCompiler <em>Compiler</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.CompilerInfo#getClassdef <em>Classdef</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.CompilerInfo#getHeader <em>Header</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getCompilerInfo()
 * @model extendedMetaData="name='CompilerInfo_._type' kind='elementOnly'"
 * @generated
 */
public interface CompilerInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Compiler</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblocks.Compiler}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Comment element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Compiler</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getCompilerInfo_Compiler()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Compiler' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<de.cau.cs.kieler.functionblocks.Compiler> getCompiler();

	/**
	 * Returns the value of the '<em><b>Classdef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classdef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classdef</em>' attribute.
	 * @see #setClassdef(String)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getCompilerInfo_Classdef()
	 * @model extendedMetaData="kind='attribute' name='classdef' namespace='##targetNamespace'"
	 * @generated
	 */
	String getClassdef();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.CompilerInfo#getClassdef <em>Classdef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classdef</em>' attribute.
	 * @see #getClassdef()
	 * @generated
	 */
	void setClassdef(String value);

	/**
	 * Returns the value of the '<em><b>Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header</em>' attribute.
	 * @see #setHeader(String)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getCompilerInfo_Header()
	 * @model extendedMetaData="kind='attribute' name='header' namespace='##targetNamespace'"
	 * @generated
	 */
	String getHeader();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.CompilerInfo#getHeader <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header</em>' attribute.
	 * @see #getHeader()
	 * @generated
	 */
	void setHeader(String value);

} // CompilerInfo
