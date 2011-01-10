/**
 * <copyright>
 * </copyright>
 *

 */
package de.cau.cs.kieler.kies.esterel;

import de.cau.cs.kieler.core.kexpressions.ISignal;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exec Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kies.esterel.ExecCase#getTask <em>Task</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kies.esterel.ExecCase#getBody <em>Body</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kies.esterel.ExecCase#getRetSignal <em>Ret Signal</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kies.esterel.ExecCase#getStatement <em>Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kies.esterel.EsterelPackage#getExecCase()
 * @model
 * @generated
 */
public interface ExecCase extends EObject
{
  /**
   * Returns the value of the '<em><b>Task</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Task</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Task</em>' reference.
   * @see #setTask(Task)
   * @see de.cau.cs.kieler.kies.esterel.EsterelPackage#getExecCase_Task()
   * @model
   * @generated
   */
  Task getTask();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.kies.esterel.ExecCase#getTask <em>Task</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Task</em>' reference.
   * @see #getTask()
   * @generated
   */
  void setTask(Task value);

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(ExecBody)
   * @see de.cau.cs.kieler.kies.esterel.EsterelPackage#getExecCase_Body()
   * @model containment="true"
   * @generated
   */
  ExecBody getBody();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.kies.esterel.ExecCase#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(ExecBody value);

  /**
   * Returns the value of the '<em><b>Ret Signal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ret Signal</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ret Signal</em>' reference.
   * @see #setRetSignal(ISignal)
   * @see de.cau.cs.kieler.kies.esterel.EsterelPackage#getExecCase_RetSignal()
   * @model
   * @generated
   */
  ISignal getRetSignal();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.kies.esterel.ExecCase#getRetSignal <em>Ret Signal</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ret Signal</em>' reference.
   * @see #getRetSignal()
   * @generated
   */
  void setRetSignal(ISignal value);

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
   * @see de.cau.cs.kieler.kies.esterel.EsterelPackage#getExecCase_Statement()
   * @model containment="true"
   * @generated
   */
  Statement getStatement();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.kies.esterel.ExecCase#getStatement <em>Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statement</em>' containment reference.
   * @see #getStatement()
   * @generated
   */
  void setStatement(Statement value);

} // ExecCase
