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
 * A representation of the model object '<em><b>Mealy Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachine#getStates <em>States</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getMealyMachine()
 * @model
 * @generated
 */
public interface MealyMachine extends ModelObject
{
  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.State}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>States</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#getMealyMachine_States()
   * @model type="de.cau.cs.kieler.gems.mealy.emf.mealymachine.State" containment="true" upper="2000"
   * @generated
   */
  EList getStates();

} // MealyMachine
