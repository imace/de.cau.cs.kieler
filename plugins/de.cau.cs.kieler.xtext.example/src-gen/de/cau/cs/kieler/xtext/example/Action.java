/**
 * <copyright>
 * </copyright>
 *
 */
package de.cau.cs.kieler.xtext.example;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.xtext.example.Action#getTriggers <em>Triggers</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.xtext.example.ExamplePackage#getAction()
 * @model
 * @generated
 */
public interface Action extends EObject
{
  /**
   * Returns the value of the '<em><b>Triggers</b></em>' containment reference list.
   * The list contents are of type {@link de.cau.cs.kieler.xtext.example.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Triggers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Triggers</em>' containment reference list.
   * @see de.cau.cs.kieler.xtext.example.ExamplePackage#getAction_Triggers()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getTriggers();

} // Action
