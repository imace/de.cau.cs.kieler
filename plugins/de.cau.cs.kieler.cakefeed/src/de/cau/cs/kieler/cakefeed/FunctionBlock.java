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
 * A representation of the model object '<em><b>Function Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.FunctionBlock#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.FunctionBlock#getType <em>Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.FunctionBlock#getInputEvents <em>Input Events</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.FunctionBlock#getOutputEvents <em>Output Events</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.FunctionBlock#getInputVars <em>Input Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.FunctionBlock#getOutputVars <em>Output Vars</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFunctionBlock()
 * @model
 * @generated
 */
public interface FunctionBlock extends NamedAndCommented {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFunctionBlock_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(FunctionBlockType)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFunctionBlock_Type()
	 * @model required="true"
	 * @generated
	 */
	FunctionBlockType getType();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.FunctionBlock#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(FunctionBlockType value);

	/**
	 * Returns the value of the '<em><b>Input Events</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.FBInputEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Events</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFunctionBlock_InputEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<FBInputEvent> getInputEvents();

	/**
	 * Returns the value of the '<em><b>Output Events</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.FBOutputEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Events</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFunctionBlock_OutputEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<FBOutputEvent> getOutputEvents();

	/**
	 * Returns the value of the '<em><b>Input Vars</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.FBInputVar}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Vars</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Vars</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFunctionBlock_InputVars()
	 * @model containment="true"
	 * @generated
	 */
	EList<FBInputVar> getInputVars();

	/**
	 * Returns the value of the '<em><b>Output Vars</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.FBOutputVar}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Vars</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Vars</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getFunctionBlock_OutputVars()
	 * @model containment="true"
	 * @generated
	 */
	EList<FBOutputVar> getOutputVars();

} // FunctionBlock
