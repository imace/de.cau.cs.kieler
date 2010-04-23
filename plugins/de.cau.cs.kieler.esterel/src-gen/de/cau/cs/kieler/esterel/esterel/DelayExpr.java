/**
 * <copyright>
 * </copyright>
 *

 */
package de.cau.cs.kieler.esterel.esterel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delay Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.esterel.esterel.DelayExpr#getEvent <em>Event</em>}</li>
 *   <li>{@link de.cau.cs.kieler.esterel.esterel.DelayExpr#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.esterel.esterel.EsterelPackage#getDelayExpr()
 * @model
 * @generated
 */
public interface DelayExpr extends EObject
{
  /**
   * Returns the value of the '<em><b>Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event</em>' containment reference.
   * @see #setEvent(DelayEvent)
   * @see de.cau.cs.kieler.esterel.esterel.EsterelPackage#getDelayExpr_Event()
   * @model containment="true"
   * @generated
   */
  DelayEvent getEvent();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.esterel.esterel.DelayExpr#getEvent <em>Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event</em>' containment reference.
   * @see #getEvent()
   * @generated
   */
  void setEvent(DelayEvent value);

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(DataExpr)
   * @see de.cau.cs.kieler.esterel.esterel.EsterelPackage#getDelayExpr_Expr()
   * @model containment="true"
   * @generated
   */
  DataExpr getExpr();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.esterel.esterel.DelayExpr#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(DataExpr value);

} // DelayExpr
