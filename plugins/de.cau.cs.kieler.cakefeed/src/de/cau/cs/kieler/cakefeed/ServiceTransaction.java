/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Transaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.ServiceTransaction#getInputPrimitive <em>Input Primitive</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.ServiceTransaction#getOutputPrimitives <em>Output Primitives</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getServiceTransaction()
 * @model
 * @generated
 */
public interface ServiceTransaction extends EObject {
	/**
	 * Returns the value of the '<em><b>Input Primitive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Primitive</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Primitive</em>' containment reference.
	 * @see #setInputPrimitive(InputPrimitive)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getServiceTransaction_InputPrimitive()
	 * @model containment="true"
	 * @generated
	 */
	InputPrimitive getInputPrimitive();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.ServiceTransaction#getInputPrimitive <em>Input Primitive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Primitive</em>' containment reference.
	 * @see #getInputPrimitive()
	 * @generated
	 */
	void setInputPrimitive(InputPrimitive value);

	/**
	 * Returns the value of the '<em><b>Output Primitives</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.OutputPrimitive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Primitives</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Primitives</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getServiceTransaction_OutputPrimitives()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputPrimitive> getOutputPrimitives();

} // ServiceTransaction
