/**
 * <copyright>
 * </copyright>
 *

 */
package de.cau.cs.kieler.kies.esterel;

import de.cau.cs.kieler.core.kexpressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repeat</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kies.esterel.Repeat#isPositive <em>Positive</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kies.esterel.Repeat#getDataExpr <em>Data Expr</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kies.esterel.Repeat#getStatement <em>Statement</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kies.esterel.Repeat#getOptEnd <em>Opt End</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kies.esterel.EsterelPackage#getRepeat()
 * @model
 * @generated
 */
public interface Repeat extends Statement
{
  /**
   * Returns the value of the '<em><b>Positive</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Positive</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Positive</em>' attribute.
   * @see #setPositive(boolean)
   * @see de.cau.cs.kieler.kies.esterel.EsterelPackage#getRepeat_Positive()
   * @model
   * @generated
   */
  boolean isPositive();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.kies.esterel.Repeat#isPositive <em>Positive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Positive</em>' attribute.
   * @see #isPositive()
   * @generated
   */
  void setPositive(boolean value);

  /**
   * Returns the value of the '<em><b>Data Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Expr</em>' containment reference.
   * @see #setDataExpr(Expression)
   * @see de.cau.cs.kieler.kies.esterel.EsterelPackage#getRepeat_DataExpr()
   * @model containment="true"
   * @generated
   */
  Expression getDataExpr();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.kies.esterel.Repeat#getDataExpr <em>Data Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Expr</em>' containment reference.
   * @see #getDataExpr()
   * @generated
   */
  void setDataExpr(Expression value);

  /**
   * Returns the value of the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statement</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statement</em>' containment reference.
   * @see #setStatement(Statement)
   * @see de.cau.cs.kieler.kies.esterel.EsterelPackage#getRepeat_Statement()
   * @model containment="true"
   * @generated
   */
  Statement getStatement();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.kies.esterel.Repeat#getStatement <em>Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statement</em>' containment reference.
   * @see #getStatement()
   * @generated
   */
  void setStatement(Statement value);

  /**
   * Returns the value of the '<em><b>Opt End</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opt End</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opt End</em>' attribute.
   * @see #setOptEnd(String)
   * @see de.cau.cs.kieler.kies.esterel.EsterelPackage#getRepeat_OptEnd()
   * @model
   * @generated
   */
  String getOptEnd();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.kies.esterel.Repeat#getOptEnd <em>Opt End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opt End</em>' attribute.
   * @see #getOptEnd()
   * @generated
   */
  void setOptEnd(String value);

} // Repeat