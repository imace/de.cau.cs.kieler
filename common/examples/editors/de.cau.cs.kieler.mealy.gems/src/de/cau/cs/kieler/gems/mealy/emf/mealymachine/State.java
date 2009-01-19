/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.gems.mealy.emf.mealymachine;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.State#getStateName <em>State Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.State#getParentMachine <em>Parent Machine</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.State#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.State#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getState()
 * @model
 * @generated
 */
public interface State extends ModelObject
{
  /**
   * Returns the value of the '<em><b>State Name</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Name</em>' attribute.
   * @see #setStateName(String)
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getState_StateName()
   * @model default="0"
   * @generated
   */
  String getStateName();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.State#getStateName <em>State Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State Name</em>' attribute.
   * @see #getStateName()
   * @generated
   */
  void setStateName(String value);

  /**
   * Returns the value of the '<em><b>Parent Machine</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent Machine</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent Machine</em>' reference.
   * @see #setParentMachine(MealyMachine)
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getState_ParentMachine()
   * @model
   * @generated
   */
  MealyMachine getParentMachine();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.State#getParentMachine <em>Parent Machine</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent Machine</em>' reference.
   * @see #getParentMachine()
   * @generated
   */
  void setParentMachine(MealyMachine value);

  /**
   * Returns the value of the '<em><b>Outgoing Transitions</b></em>' reference list.
   * The list contents are of type {@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outgoing Transitions</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing Transitions</em>' reference list.
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getState_OutgoingTransitions()
   * @model type="de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection" upper="2147483647"
   * @generated
   */
  EList getOutgoingTransitions();

  /**
   * Returns the value of the '<em><b>Incoming Transitions</b></em>' reference list.
   * The list contents are of type {@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Incoming Transitions</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Incoming Transitions</em>' reference list.
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getState_IncomingTransitions()
   * @model type="de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection" upper="2147483647"
   * @generated
   */
  EList getIncomingTransitions();

} // State
