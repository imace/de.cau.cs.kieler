/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compilable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.Compilable#getCompilerInfo <em>Compiler Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCompilable()
 * @model
 * @generated
 */
public interface Compilable extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compiler Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compiler Info</em>' containment reference.
	 * @see #setCompilerInfo(CompilerInfo)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getCompilable_CompilerInfo()
	 * @model containment="true"
	 * @generated
	 */
	CompilerInfo getCompilerInfo();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.Compilable#getCompilerInfo <em>Compiler Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compiler Info</em>' containment reference.
	 * @see #getCompilerInfo()
	 * @generated
	 */
	void setCompilerInfo(CompilerInfo value);

} // Compilable
