/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.ssm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safe State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.ssm.SafeStateMachine#getTop <em>Top</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.ssm.ssmPackage#getSafeStateMachine()
 * @model
 * @generated
 */
public interface SafeStateMachine extends Named {
	/**
	 * Returns the value of the '<em><b>Top</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top</em>' containment reference.
	 * @see #setTop(CompositeState)
	 * @see de.cau.cs.kieler.ssm.ssmPackage#getSafeStateMachine_Top()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CompositeState getTop();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.ssm.SafeStateMachine#getTop <em>Top</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top</em>' containment reference.
	 * @see #getTop()
	 * @generated
	 */
	void setTop(CompositeState value);

} // SafeStateMachine
