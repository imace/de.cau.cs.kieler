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
 * A representation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ssm.Operator#getOperatorKind <em>Operator Kind</em>}</li>
 *   <li>{@link ssm.Operator#getParentTrigger <em>Parent Trigger</em>}</li>
 * </ul>
 * </p>
 *
 * @see ssm.ssmPackage#getOperator()
 * @model
 * @generated
 */
public interface Operator extends EObject {
	/**
	 * Returns the value of the '<em><b>Operator Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link ssm.OperatorKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator Kind</em>' attribute.
	 * @see ssm.OperatorKind
	 * @see #setOperatorKind(OperatorKind)
	 * @see ssm.ssmPackage#getOperator_OperatorKind()
	 * @model required="true"
	 * @generated
	 */
	OperatorKind getOperatorKind();

	/**
	 * Sets the value of the '{@link ssm.Operator#getOperatorKind <em>Operator Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator Kind</em>' attribute.
	 * @see ssm.OperatorKind
	 * @see #getOperatorKind()
	 * @generated
	 */
	void setOperatorKind(OperatorKind value);

	/**
	 * Returns the value of the '<em><b>Parent Trigger</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm.Trigger#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Trigger</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Trigger</em>' container reference.
	 * @see #setParentTrigger(Trigger)
	 * @see ssm.ssmPackage#getOperator_ParentTrigger()
	 * @see ssm.Trigger#getOperator
	 * @model opposite="operator" required="true" transient="false"
	 * @generated
	 */
	Trigger getParentTrigger();

	/**
	 * Sets the value of the '{@link ssm.Operator#getParentTrigger <em>Parent Trigger</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Trigger</em>' container reference.
	 * @see #getParentTrigger()
	 * @generated
	 */
	void setParentTrigger(Trigger value);

} // Operator
