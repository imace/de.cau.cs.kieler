/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Primitive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.InputPrimitive#getEvent <em>Event</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.InputPrimitive#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.InputPrimitive#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getInputPrimitive()
 * @model extendedMetaData="name='InputPrimitive_._type' kind='empty'"
 * @generated
 */
public interface InputPrimitive extends EObject {
	/**
	 * Returns the value of the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' attribute.
	 * @see #setEvent(String)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getInputPrimitive_Event()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute' name='Event' namespace='##targetNamespace'"
	 * @generated
	 */
	String getEvent();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.InputPrimitive#getEvent <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' attribute.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(String value);

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' attribute.
	 * @see #setInterface(String)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getInputPrimitive_Interface()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute' name='Interface' namespace='##targetNamespace'"
	 * @generated
	 */
	String getInterface();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.InputPrimitive#getInterface <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' attribute.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' attribute.
	 * @see #setParameters(String)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getInputPrimitive_Parameters()
	 * @model extendedMetaData="kind='attribute' name='Parameters' namespace='##targetNamespace'"
	 * @generated
	 */
	String getParameters();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.InputPrimitive#getParameters <em>Parameters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameters</em>' attribute.
	 * @see #getParameters()
	 * @generated
	 */
	void setParameters(String value);

} // InputPrimitive
