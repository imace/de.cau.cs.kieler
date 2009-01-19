/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.gems.mealy.emf.mealymachine;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection#getSource <em>Source</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection#getTarget <em>Target</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection#getAction <em>Action</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getTransitionConnection()
 * @model
 * @generated
 */
public interface TransitionConnection extends EObject
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(State)
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getTransitionConnection_Source()
   * @model
   * @generated
   */
  State getSource();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(State value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(State)
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getTransitionConnection_Target()
   * @model
   * @generated
   */
  State getTarget();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(State value);

  /**
   * Returns the value of the '<em><b>Action</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' attribute.
   * @see #setAction(String)
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getTransitionConnection_Action()
   * @model default="0"
   * @generated
   */
  String getAction();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection#getAction <em>Action</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' attribute.
   * @see #getAction()
   * @generated
   */
  void setAction(String value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' attribute.
   * @see #setCondition(String)
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getTransitionConnection_Condition()
   * @model default="0"
   * @generated
   */
  String getCondition();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection#getCondition <em>Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' attribute.
   * @see #getCondition()
   * @generated
   */
  void setCondition(String value);

} // TransitionConnection
