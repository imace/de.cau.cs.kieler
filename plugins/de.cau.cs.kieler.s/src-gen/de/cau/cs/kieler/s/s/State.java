/**
 * <copyright>
 * </copyright>
 *
 */
package de.cau.cs.kieler.s.s;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.s.s.State#getName <em>Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.s.s.State#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link de.cau.cs.kieler.s.s.State#getSignals <em>Signals</em>}</li>
 *   <li>{@link de.cau.cs.kieler.s.s.State#getInstructions <em>Instructions</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.s.s.SPackage#getState()
 * @model
 * @generated
 */
public interface State extends Annotatable
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
   * @see de.cau.cs.kieler.s.s.SPackage#getState_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.s.s.State#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
   * The list contents are of type {@link de.cau.cs.kieler.s.s.Annotation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotations</em>' containment reference list.
   * @see de.cau.cs.kieler.s.s.SPackage#getState_Annotations()
   * @model containment="true"
   * @generated
   */
  EList<Annotation> getAnnotations();

  /**
   * Returns the value of the '<em><b>Signals</b></em>' containment reference list.
   * The list contents are of type {@link de.cau.cs.kieler.s.s.Signal}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signals</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signals</em>' containment reference list.
   * @see de.cau.cs.kieler.s.s.SPackage#getState_Signals()
   * @model containment="true"
   * @generated
   */
  EList<Signal> getSignals();

  /**
   * Returns the value of the '<em><b>Instructions</b></em>' containment reference list.
   * The list contents are of type {@link de.cau.cs.kieler.s.s.Instruction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instructions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instructions</em>' containment reference list.
   * @see de.cau.cs.kieler.s.s.SPackage#getState_Instructions()
   * @model containment="true"
   * @generated
   */
  EList<Instruction> getInstructions();

} // State
