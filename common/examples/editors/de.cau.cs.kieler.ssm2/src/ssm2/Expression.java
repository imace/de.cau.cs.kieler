/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ssm2.Expression#getSubExpressions <em>Sub Expressions</em>}</li>
 *   <li>{@link ssm2.Expression#getSignal <em>Signal</em>}</li>
 *   <li>{@link ssm2.Expression#getOperator <em>Operator</em>}</li>
 *   <li>{@link ssm2.Expression#getParentExpression <em>Parent Expression</em>}</li>
 *   <li>{@link ssm2.Expression#getParentAction <em>Parent Action</em>}</li>
 *   <li>{@link ssm2.Expression#getVariable <em>Variable</em>}</li>
 *   <li>{@link ssm2.Expression#getParentEmisson <em>Parent Emisson</em>}</li>
 *   <li>{@link ssm2.Expression#getAssignment <em>Assignment</em>}</li>
 * </ul>
 * </p>
 *
 * @see ssm2.Ssm2Package#getExpression()
 * @model
 * @generated
 */
public interface Expression extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link ssm2.Expression}.
	 * It is bidirectional and its opposite is '{@link ssm2.Expression#getParentExpression <em>Parent Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Expressions</em>' containment reference list.
	 * @see ssm2.Ssm2Package#getExpression_SubExpressions()
	 * @see ssm2.Expression#getParentExpression
	 * @model opposite="parentExpression" containment="true"
	 * @generated
	 */
	EList<Expression> getSubExpressions();

	/**
	 * Returns the value of the '<em><b>Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal</em>' reference.
	 * @see #setSignal(Signal)
	 * @see ssm2.Ssm2Package#getExpression_Signal()
	 * @model
	 * @generated
	 */
	Signal getSignal();

	/**
	 * Sets the value of the '{@link ssm2.Expression#getSignal <em>Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signal</em>' reference.
	 * @see #getSignal()
	 * @generated
	 */
	void setSignal(Signal value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link ssm2.Operator#getParentExpression <em>Parent Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' containment reference.
	 * @see #setOperator(Operator)
	 * @see ssm2.Ssm2Package#getExpression_Operator()
	 * @see ssm2.Operator#getParentExpression
	 * @model opposite="parentExpression" containment="true"
	 * @generated
	 */
	Operator getOperator();

	/**
	 * Sets the value of the '{@link ssm2.Expression#getOperator <em>Operator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' containment reference.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(Operator value);

	/**
	 * Returns the value of the '<em><b>Parent Expression</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm2.Expression#getSubExpressions <em>Sub Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Expression</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Expression</em>' container reference.
	 * @see #setParentExpression(Expression)
	 * @see ssm2.Ssm2Package#getExpression_ParentExpression()
	 * @see ssm2.Expression#getSubExpressions
	 * @model opposite="subExpressions" transient="false"
	 * @generated
	 */
	Expression getParentExpression();

	/**
	 * Sets the value of the '{@link ssm2.Expression#getParentExpression <em>Parent Expression</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Expression</em>' container reference.
	 * @see #getParentExpression()
	 * @generated
	 */
	void setParentExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Parent Action</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm2.Action#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Action</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Action</em>' container reference.
	 * @see #setParentAction(Action)
	 * @see ssm2.Ssm2Package#getExpression_ParentAction()
	 * @see ssm2.Action#getTrigger
	 * @model opposite="trigger" transient="false"
	 * @generated
	 */
	Action getParentAction();

	/**
	 * Sets the value of the '{@link ssm2.Expression#getParentAction <em>Parent Action</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Action</em>' container reference.
	 * @see #getParentAction()
	 * @generated
	 */
	void setParentAction(Action value);

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
	 * @see ssm2.Ssm2Package#getExpression_Variable()
	 * @model
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link ssm2.Expression#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Parent Emisson</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm2.Emission#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Emisson</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Emisson</em>' container reference.
	 * @see #setParentEmisson(Emission)
	 * @see ssm2.Ssm2Package#getExpression_ParentEmisson()
	 * @see ssm2.Emission#getNewValue
	 * @model opposite="newValue" transient="false"
	 * @generated
	 */
	Emission getParentEmisson();

	/**
	 * Sets the value of the '{@link ssm2.Expression#getParentEmisson <em>Parent Emisson</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Emisson</em>' container reference.
	 * @see #getParentEmisson()
	 * @generated
	 */
	void setParentEmisson(Emission value);

	/**
	 * Returns the value of the '<em><b>Assignment</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link ssm2.Assignment#getParentExpression <em>Parent Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignment</em>' reference.
	 * @see #setAssignment(Assignment)
	 * @see ssm2.Ssm2Package#getExpression_Assignment()
	 * @see ssm2.Assignment#getParentExpression
	 * @model opposite="parentExpression"
	 * @generated
	 */
	Assignment getAssignment();

	/**
	 * Sets the value of the '{@link ssm2.Expression#getAssignment <em>Assignment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assignment</em>' reference.
	 * @see #getAssignment()
	 * @generated
	 */
	void setAssignment(Assignment value);

} // Expression
