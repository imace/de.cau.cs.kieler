/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.generated.epc;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function To Operator Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.informatik.aiw.generated.epc.FunctionToOperatorConnection#getFunction <em>Function</em>}</li>
 *   <li>{@link edu.unikiel.informatik.aiw.generated.epc.FunctionToOperatorConnection#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage#getFunctionToOperatorConnection()
 * @model
 * @generated
 */
public interface FunctionToOperatorConnection extends SuccessorOf {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(Function)
	 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage#getFunctionToOperatorConnection_Function()
	 * @model
	 * @generated
	 */
	Function getFunction();

	/**
	 * Sets the value of the '{@link edu.unikiel.informatik.aiw.generated.epc.FunctionToOperatorConnection#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(Function value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' reference.
	 * @see #setOperator(LogicalOperator)
	 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage#getFunctionToOperatorConnection_Operator()
	 * @model
	 * @generated
	 */
	LogicalOperator getOperator();

	/**
	 * Sets the value of the '{@link edu.unikiel.informatik.aiw.generated.epc.FunctionToOperatorConnection#getOperator <em>Operator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' reference.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(LogicalOperator value);

} // FunctionToOperatorConnection
