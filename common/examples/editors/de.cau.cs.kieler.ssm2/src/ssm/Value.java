/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ssm.Value#getValue <em>Value</em>}</li>
 *   <li>{@link ssm.Value#getParentSignal <em>Parent Signal</em>}</li>
 *   <li>{@link ssm.Value#getParentEmisson <em>Parent Emisson</em>}</li>
 * </ul>
 * </p>
 *
 * @see ssm.ssmPackage#getValue()
 * @model
 * @generated
 */
public interface Value extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see ssm.ssmPackage#getValue_Value()
	 * @model required="true"
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link ssm.Value#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

	/**
	 * Returns the value of the '<em><b>Parent Signal</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm.Signal#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Signal</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Signal</em>' container reference.
	 * @see #setParentSignal(Signal)
	 * @see ssm.ssmPackage#getValue_ParentSignal()
	 * @see ssm.Signal#getValue
	 * @model opposite="value" transient="false"
	 * @generated
	 */
	Signal getParentSignal();

	/**
	 * Sets the value of the '{@link ssm.Value#getParentSignal <em>Parent Signal</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Signal</em>' container reference.
	 * @see #getParentSignal()
	 * @generated
	 */
	void setParentSignal(Signal value);

	/**
	 * Returns the value of the '<em><b>Parent Emisson</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm.Emission#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Emisson</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Emisson</em>' container reference.
	 * @see #setParentEmisson(Emission)
	 * @see ssm.ssmPackage#getValue_ParentEmisson()
	 * @see ssm.Emission#getNewValue
	 * @model opposite="newValue" transient="false"
	 * @generated
	 */
	Emission getParentEmisson();

	/**
	 * Sets the value of the '{@link ssm.Value#getParentEmisson <em>Parent Emisson</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Emisson</em>' container reference.
	 * @see #getParentEmisson()
	 * @generated
	 */
	void setParentEmisson(Emission value);

} // Value
