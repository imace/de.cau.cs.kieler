/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.gems.mealy.emf.mealymachine;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subtype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype#getName <em>Name</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype#getBase <em>Base</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype#getInstances <em>Instances</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MealyMachinePackage#getSubtype()
 * @model
 * @generated
 */
public interface Subtype extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * The default value is <code>"AnonymousSubtype"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MealyMachinePackage#getSubtype_Name()
   * @model default="AnonymousSubtype"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base</em>' reference.
   * @see #setBase(ModelObject)
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MealyMachinePackage#getSubtype_Base()
   * @model
   * @generated
   */
  ModelObject getBase();

  /**
   * Sets the value of the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype#getBase <em>Base</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base</em>' reference.
   * @see #getBase()
   * @generated
   */
  void setBase(ModelObject value);

  /**
   * Returns the value of the '<em><b>Instances</b></em>' reference list.
   * The list contents are of type {@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instances</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instances</em>' reference list.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MealyMachinePackage#getSubtype_Instances()
   * @model type="edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject" upper="2000"
   * @generated
   */
  EList getInstances();

  /**
   * Returns the value of the '<em><b>Links</b></em>' containment reference list.
   * The list contents are of type {@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.SubtypeLink}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Links</em>' containment reference list.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MealyMachinePackage#getSubtype_Links()
   * @model type="edu.unikiel.rtsys.gems.mealy.emf.mealymachine.SubtypeLink" containment="true" upper="20000"
   * @generated
   */
  EList getLinks();

} // Subtype
