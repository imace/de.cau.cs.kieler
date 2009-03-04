/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ssm2.Value#getValue <em>Value</em>}</li>
 *   <li>{@link ssm2.Value#getParentSignal <em>Parent Signal</em>}</li>
 *   <li>{@link ssm2.Value#getParentVariable <em>Parent Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see ssm2.Ssm2Package#getValue()
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
	 * @see ssm2.Ssm2Package#getValue_Value()
	 * @model required="true"
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link ssm2.Value#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

	/**
	 * Returns the value of the '<em><b>Parent Signal</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm2.Signal#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Signal</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Signal</em>' container reference.
	 * @see #setParentSignal(Signal)
	 * @see ssm2.Ssm2Package#getValue_ParentSignal()
	 * @see ssm2.Signal#getValue
	 * @model opposite="value" transient="false"
	 * @generated
	 */
	Signal getParentSignal();

	/**
	 * Sets the value of the '{@link ssm2.Value#getParentSignal <em>Parent Signal</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Signal</em>' container reference.
	 * @see #getParentSignal()
	 * @generated
	 */
	void setParentSignal(Signal value);

	/**
	 * Returns the value of the '<em><b>Parent Variable</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm2.Variable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Variable</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Variable</em>' container reference.
	 * @see #setParentVariable(Variable)
	 * @see ssm2.Ssm2Package#getValue_ParentVariable()
	 * @see ssm2.Variable#getValue
	 * @model opposite="value" transient="false"
	 * @generated
	 */
	Variable getParentVariable();

	/**
	 * Sets the value of the '{@link ssm2.Value#getParentVariable <em>Parent Variable</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Variable</em>' container reference.
	 * @see #getParentVariable()
	 * @generated
	 */
	void setParentVariable(Variable value);

} // Value
