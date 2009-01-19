/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.ssm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Signal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.ssm.IntegerSignal#getIntegerValue <em>Integer Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.ssm.ssmPackage#getIntegerSignal()
 * @model
 * @generated
 */
public interface IntegerSignal extends Signal {
	/**
	 * Returns the value of the '<em><b>Integer Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Integer Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integer Value</em>' attribute.
	 * @see #setIntegerValue(int)
	 * @see de.cau.cs.kieler.ssm.ssmPackage#getIntegerSignal_IntegerValue()
	 * @model
	 * @generated
	 */
	int getIntegerValue();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.ssm.IntegerSignal#getIntegerValue <em>Integer Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer Value</em>' attribute.
	 * @see #getIntegerValue()
	 * @generated
	 */
	void setIntegerValue(int value);

} // IntegerSignal
