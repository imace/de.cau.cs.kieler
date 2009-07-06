/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.gems.mealy.emf.mealymachine;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage
 * @generated
 */
public interface MealyMachineFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MealyMachineFactory eINSTANCE = de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl.MealyMachineFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Memento Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Memento Value</em>'.
   * @generated
   */
  MementoValue createMementoValue();

  /**
   * Returns a new object of class '<em>Memento</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Memento</em>'.
   * @generated
   */
  Memento createMemento();

  /**
   * Returns a new object of class '<em>Subtype</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subtype</em>'.
   * @generated
   */
  Subtype createSubtype();

  /**
   * Returns a new object of class '<em>Subtype Link</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subtype Link</em>'.
   * @generated
   */
  SubtypeLink createSubtypeLink();

  /**
   * Returns a new object of class '<em>Model Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Object</em>'.
   * @generated
   */
  ModelObject createModelObject();

  /**
   * Returns a new object of class '<em>Mealy Machine</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mealy Machine</em>'.
   * @generated
   */
  MealyMachine createMealyMachine();

  /**
   * Returns a new object of class '<em>State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State</em>'.
   * @generated
   */
  State createState();

  /**
   * Returns a new object of class '<em>Transition Connection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition Connection</em>'.
   * @generated
   */
  TransitionConnection createTransitionConnection();

  /**
   * Returns a new object of class '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Root</em>'.
   * @generated
   */
  Root createRoot();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  MealyMachinePackage getMealyMachinePackage();

} //MealyMachineFactory
