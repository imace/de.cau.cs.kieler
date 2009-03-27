/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KDimension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension#getHeight <em>Height</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension#getWidth <em>Width</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKDimension()
 * @model
 * @generated
 */
public interface KDimension extends EObject {
	/**
     * Returns the value of the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Height</em>' attribute.
     * @see #setHeight(float)
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKDimension_Height()
     * @model required="true"
     * @generated
     */
	float getHeight();

	/**
     * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension#getHeight <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Height</em>' attribute.
     * @see #getHeight()
     * @generated
     */
	void setHeight(float value);

	/**
     * Returns the value of the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Width</em>' attribute.
     * @see #setWidth(float)
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKDimension_Width()
     * @model required="true"
     * @generated
     */
	float getWidth();

	/**
     * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension#getWidth <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Width</em>' attribute.
     * @see #getWidth()
     * @generated
     */
	void setWidth(float value);

} // KDimension
