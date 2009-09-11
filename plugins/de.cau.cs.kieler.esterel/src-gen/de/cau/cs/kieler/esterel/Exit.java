/**
 * <copyright>
 * </copyright>
 *
 */
package de.cau.cs.kieler.esterel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.esterel.Exit#getTrap <em>Trap</em>}</li>
 *   <li>{@link de.cau.cs.kieler.esterel.Exit#getDataExpr <em>Data Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.esterel.EsterelPackage#getExit()
 * @model
 * @generated
 */
public interface Exit extends Statement
{
  /**
   * Returns the value of the '<em><b>Trap</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trap</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trap</em>' reference.
   * @see #setTrap(Trap)
   * @see de.cau.cs.kieler.esterel.EsterelPackage#getExit_Trap()
   * @model
   * @generated
   */
  Trap getTrap();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.esterel.Exit#getTrap <em>Trap</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trap</em>' reference.
   * @see #getTrap()
   * @generated
   */
  void setTrap(Trap value);

  /**
   * Returns the value of the '<em><b>Data Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Expr</em>' containment reference.
   * @see #setDataExpr(DataExpr)
   * @see de.cau.cs.kieler.esterel.EsterelPackage#getExit_DataExpr()
   * @model containment="true"
   * @generated
   */
  DataExpr getDataExpr();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.esterel.Exit#getDataExpr <em>Data Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Expr</em>' containment reference.
   * @see #getDataExpr()
   * @generated
   */
  void setDataExpr(DataExpr value);

} // Exit
