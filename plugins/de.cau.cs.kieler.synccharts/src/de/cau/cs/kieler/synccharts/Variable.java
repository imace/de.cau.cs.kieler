/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.synccharts;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.synccharts.Variable#getValue <em>Value</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.Variable#getParentState <em>Parent State</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends ValuedObject {
	/**
     * Returns the value of the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' containment reference.
     * @see #setValue(EObject)
     * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getVariable_Value()
     * @model containment="true" required="true"
     * @generated
     */
	EObject getValue();

	/**
     * Sets the value of the '{@link de.cau.cs.kieler.synccharts.Variable#getValue <em>Value</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' containment reference.
     * @see #getValue()
     * @generated
     */
	void setValue(EObject value);

	/**
     * Returns the value of the '<em><b>Parent State</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.synccharts.State#getVariables <em>Variables</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent State</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Parent State</em>' container reference.
     * @see #setParentState(State)
     * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getVariable_ParentState()
     * @see de.cau.cs.kieler.synccharts.State#getVariables
     * @model opposite="variables" transient="false"
     * @generated
     */
	State getParentState();

	/**
     * Sets the value of the '{@link de.cau.cs.kieler.synccharts.Variable#getParentState <em>Parent State</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent State</em>' container reference.
     * @see #getParentState()
     * @generated
     */
	void setParentState(State value);

} // Variable
