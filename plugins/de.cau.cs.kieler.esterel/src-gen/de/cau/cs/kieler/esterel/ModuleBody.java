/**
 * <copyright>
 * </copyright>
 *
 */
package de.cau.cs.kieler.esterel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.esterel.ModuleBody#getStatement <em>Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.esterel.EsterelPackage#getModuleBody()
 * @model
 * @generated
 */
public interface ModuleBody extends EObject
{
  /**
   * Returns the value of the '<em><b>Statement</b></em>' containment reference list.
   * The list contents are of type {@link de.cau.cs.kieler.esterel.Statement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statement</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statement</em>' containment reference list.
   * @see de.cau.cs.kieler.esterel.EsterelPackage#getModuleBody_Statement()
   * @model containment="true"
   * @generated
   */
  EList<Statement> getStatement();

} // ModuleBody
