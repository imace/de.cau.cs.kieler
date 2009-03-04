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
 * A representation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ssm2.Operator#getOperatorKind <em>Operator Kind</em>}</li>
 *   <li>{@link ssm2.Operator#getParentExpression <em>Parent Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see ssm2.Ssm2Package#getOperator()
 * @model
 * @generated
 */
public interface Operator extends EObject {
	/**
	 * Returns the value of the '<em><b>Operator Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link ssm2.OperatorKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator Kind</em>' attribute.
	 * @see ssm2.OperatorKind
	 * @see #setOperatorKind(OperatorKind)
	 * @see ssm2.Ssm2Package#getOperator_OperatorKind()
	 * @model required="true"
	 * @generated
	 */
	OperatorKind getOperatorKind();

	/**
	 * Sets the value of the '{@link ssm2.Operator#getOperatorKind <em>Operator Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator Kind</em>' attribute.
	 * @see ssm2.OperatorKind
	 * @see #getOperatorKind()
	 * @generated
	 */
	void setOperatorKind(OperatorKind value);

	/**
	 * Returns the value of the '<em><b>Parent Expression</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm2.Expression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Expression</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Expression</em>' container reference.
	 * @see #setParentExpression(Expression)
	 * @see ssm2.Ssm2Package#getOperator_ParentExpression()
	 * @see ssm2.Expression#getOperator
	 * @model opposite="operator" required="true" transient="false"
	 * @generated
	 */
	Expression getParentExpression();

	/**
	 * Sets the value of the '{@link ssm2.Operator#getParentExpression <em>Parent Expression</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Expression</em>' container reference.
	 * @see #getParentExpression()
	 * @generated
	 */
	void setParentExpression(Expression value);

} // Operator
