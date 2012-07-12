/**
 */
package de.cau.cs.kieler.esterel.esterel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedure Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.esterel.esterel.ProcedureDecl#getProcedures <em>Procedures</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.esterel.esterel.EsterelPackage#getProcedureDecl()
 * @model
 * @generated
 */
public interface ProcedureDecl extends EObject
{
  /**
   * Returns the value of the '<em><b>Procedures</b></em>' containment reference list.
   * The list contents are of type {@link de.cau.cs.kieler.esterel.esterel.Procedure}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Procedures</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Procedures</em>' containment reference list.
   * @see de.cau.cs.kieler.esterel.esterel.EsterelPackage#getProcedureDecl_Procedures()
   * @model containment="true"
   * @generated
   */
  EList<Procedure> getProcedures();

} // ProcedureDecl
