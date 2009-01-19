/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.gems.mealy.emf.mealymachine;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.Root#getMementos <em>Mementos</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.Root#getSubtypes <em>Subtypes</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.Root#getRealRoot <em>Real Root</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.Root#getMealyMachine <em>Mealy Machine</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.Root#getState <em>State</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.Root#getTransitionConnection <em>Transition Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject
{
  /**
   * Returns the value of the '<em><b>Mementos</b></em>' containment reference list.
   * The list contents are of type {@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.Memento}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mementos</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mementos</em>' containment reference list.
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getRoot_Mementos()
   * @model type="de.cau.cs.kieler.gems.mealy.emf.mealymachine.Memento" containment="true" upper="2000"
   * @generated
   */
  EList getMementos();

  /**
   * Returns the value of the '<em><b>Subtypes</b></em>' containment reference list.
   * The list contents are of type {@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.Subtype}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subtypes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subtypes</em>' containment reference list.
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getRoot_Subtypes()
   * @model type="de.cau.cs.kieler.gems.mealy.emf.mealymachine.Subtype" containment="true" upper="2000"
   * @generated
   */
  EList getSubtypes();

  /**
   * Returns the value of the '<em><b>Real Root</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Real Root</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Real Root</em>' containment reference.
   * @see #setRealRoot(MealyMachine)
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getRoot_RealRoot()
   * @model containment="true"
   * @generated
   */
  MealyMachine getRealRoot();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.Root#getRealRoot <em>Real Root</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Real Root</em>' containment reference.
   * @see #getRealRoot()
   * @generated
   */
  void setRealRoot(MealyMachine value);

  /**
   * Returns the value of the '<em><b>Mealy Machine</b></em>' containment reference list.
   * The list contents are of type {@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachine}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mealy Machine</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mealy Machine</em>' containment reference list.
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getRoot_MealyMachine()
   * @model type="de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachine" containment="true" upper="2000"
   * @generated
   */
  EList getMealyMachine();

  /**
   * Returns the value of the '<em><b>State</b></em>' containment reference list.
   * The list contents are of type {@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.State}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' containment reference list.
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getRoot_State()
   * @model type="de.cau.cs.kieler.gems.mealy.emf.mealymachine.State" containment="true" upper="2000"
   * @generated
   */
  EList getState();

  /**
   * Returns the value of the '<em><b>Transition Connection</b></em>' containment reference list.
   * The list contents are of type {@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transition Connection</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transition Connection</em>' containment reference list.
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getRoot_TransitionConnection()
   * @model type="de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection" containment="true" upper="2000"
   * @generated
   */
  EList getTransitionConnection();

} // Root
