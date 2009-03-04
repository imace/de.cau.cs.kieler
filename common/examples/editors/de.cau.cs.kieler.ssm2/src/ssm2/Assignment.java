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
 * A representation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ssm2.Assignment#getVariable <em>Variable</em>}</li>
 *   <li>{@link ssm2.Assignment#getParentExpression <em>Parent Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see ssm2.Ssm2Package#getAssignment()
 * @model
 * @generated
 */
public interface Assignment extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(Variable)
	 * @see ssm2.Ssm2Package#getAssignment_Variable()
	 * @model required="true"
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link ssm2.Assignment#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Parent Expression</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link ssm2.Expression#getAssignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Expression</em>' reference.
	 * @see #setParentExpression(Expression)
	 * @see ssm2.Ssm2Package#getAssignment_ParentExpression()
	 * @see ssm2.Expression#getAssignment
	 * @model opposite="assignment"
	 * @generated
	 */
	Expression getParentExpression();

	/**
	 * Sets the value of the '{@link ssm2.Assignment#getParentExpression <em>Parent Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Expression</em>' reference.
	 * @see #getParentExpression()
	 * @generated
	 */
	void setParentExpression(Expression value);

} // Assignment
