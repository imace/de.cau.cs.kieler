/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Suspension Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ssm2.SuspensionTrigger#getParentState <em>Parent State</em>}</li>
 *   <li>{@link ssm2.SuspensionTrigger#isImmediate <em>Immediate</em>}</li>
 * </ul>
 * </p>
 *
 * @see ssm2.Ssm2Package#getSuspensionTrigger()
 * @model
 * @generated
 */
public interface SuspensionTrigger extends Expression {
	/**
	 * Returns the value of the '<em><b>Parent State</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ssm2.State#getSuspensionTrigger <em>Suspension Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent State</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent State</em>' container reference.
	 * @see #setParentState(State)
	 * @see ssm2.Ssm2Package#getSuspensionTrigger_ParentState()
	 * @see ssm2.State#getSuspensionTrigger
	 * @model opposite="suspensionTrigger" required="true" transient="false"
	 * @generated
	 */
	State getParentState();

	/**
	 * Sets the value of the '{@link ssm2.SuspensionTrigger#getParentState <em>Parent State</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent State</em>' container reference.
	 * @see #getParentState()
	 * @generated
	 */
	void setParentState(State value);

	/**
	 * Returns the value of the '<em><b>Immediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Immediate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Immediate</em>' attribute.
	 * @see #setImmediate(boolean)
	 * @see ssm2.Ssm2Package#getSuspensionTrigger_Immediate()
	 * @model
	 * @generated
	 */
	boolean isImmediate();

	/**
	 * Sets the value of the '{@link ssm2.SuspensionTrigger#isImmediate <em>Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Immediate</em>' attribute.
	 * @see #isImmediate()
	 * @generated
	 */
	void setImmediate(boolean value);

} // SuspensionTrigger
