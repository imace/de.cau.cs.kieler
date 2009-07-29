/**
 * <copyright>
 * </copyright>
 *
 */
package de.cau.cs.kieler.synccharts.transitionlabel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.synccharts.transitionlabel.Operation#getSubExpression <em>Sub Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.synccharts.transitionlabel.TransitionlabelPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends Expression
{
  /**
   * Returns the value of the '<em><b>Sub Expression</b></em>' containment reference list.
   * The list contents are of type {@link de.cau.cs.kieler.synccharts.transitionlabel.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Expression</em>' containment reference list.
   * @see de.cau.cs.kieler.synccharts.transitionlabel.TransitionlabelPackage#getOperation_SubExpression()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getSubExpression();

} // Operation
