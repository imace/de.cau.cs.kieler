/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.layouter.graph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Size</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.layouter.graph.Size#getWidth <em>Width</em>}</li>
 *   <li>{@link de.cau.cs.kieler.layouter.graph.Size#getHeight <em>Height</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.layouter.graph.GraphPackage#getSize()
 * @model
 * @generated
 */
public interface Size extends EObject {
	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see de.cau.cs.kieler.layouter.graph.GraphPackage#getSize_Width()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.layouter.graph.Size#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(int)
	 * @see de.cau.cs.kieler.layouter.graph.GraphPackage#getSize_Height()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.layouter.graph.Size#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

} // Size
