/**
 * <copyright>
 * </copyright>
 *
 */
package de.cau.cs.kieler.sim.esi.esi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>signal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.sim.esi.esi.signal#getName <em>Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.sim.esi.esi.signal#isValued <em>Valued</em>}</li>
 *   <li>{@link de.cau.cs.kieler.sim.esi.esi.signal#getVal <em>Val</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.sim.esi.esi.EsiPackage#getsignal()
 * @model
 * @generated
 */
public interface signal extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.cau.cs.kieler.sim.esi.esi.EsiPackage#getsignal_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.sim.esi.esi.signal#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Valued</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Valued</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Valued</em>' attribute.
   * @see #setValued(boolean)
   * @see de.cau.cs.kieler.sim.esi.esi.EsiPackage#getsignal_Valued()
   * @model
   * @generated
   */
  boolean isValued();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.sim.esi.esi.signal#isValued <em>Valued</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Valued</em>' attribute.
   * @see #isValued()
   * @generated
   */
  void setValued(boolean value);

  /**
   * Returns the value of the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val</em>' attribute.
   * @see #setVal(int)
   * @see de.cau.cs.kieler.sim.esi.esi.EsiPackage#getsignal_Val()
   * @model
   * @generated
   */
  int getVal();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.sim.esi.esi.signal#getVal <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val</em>' attribute.
   * @see #getVal()
   * @generated
   */
  void setVal(int value);

} // signal
