/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LD</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.LD#getRungs <em>Rungs</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getLD()
 * @model
 * @generated
 */
public interface LD extends NamedAndCommented {
	/**
	 * Returns the value of the '<em><b>Rungs</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.Rung}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rungs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rungs</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getLD_Rungs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Rung> getRungs();

} // LD
