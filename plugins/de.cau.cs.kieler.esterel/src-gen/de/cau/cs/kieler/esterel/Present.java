/**
 * <copyright>
 * </copyright>
 *
 */
package de.cau.cs.kieler.esterel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Present</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.esterel.Present#getBody <em>Body</em>}</li>
 *   <li>{@link de.cau.cs.kieler.esterel.Present#getElsePart <em>Else Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.esterel.EsterelPackage#getPresent()
 * @model
 * @generated
 */
public interface Present extends Statement
{
  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(PresentBody)
   * @see de.cau.cs.kieler.esterel.EsterelPackage#getPresent_Body()
   * @model containment="true"
   * @generated
   */
  PresentBody getBody();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.esterel.Present#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(PresentBody value);

  /**
   * Returns the value of the '<em><b>Else Part</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Part</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Part</em>' containment reference.
   * @see #setElsePart(ElsePart)
   * @see de.cau.cs.kieler.esterel.EsterelPackage#getPresent_ElsePart()
   * @model containment="true"
   * @generated
   */
  ElsePart getElsePart();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.esterel.Present#getElsePart <em>Else Part</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Part</em>' containment reference.
   * @see #getElsePart()
   * @generated
   */
  void setElsePart(ElsePart value);

} // Present
