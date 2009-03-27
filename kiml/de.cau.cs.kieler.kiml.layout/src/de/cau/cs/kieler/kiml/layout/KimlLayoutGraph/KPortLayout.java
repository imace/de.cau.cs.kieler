/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KLayoutPort Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout#getPlacement <em>Placement</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKPortLayout()
 * @model
 * @generated
 */
public interface KPortLayout extends KShapeLayout {
	/**
     * Returns the value of the '<em><b>Placement</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * The literals are from the enumeration {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Placement</em>' attribute.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement
     * @see #setPlacement(KPortPlacement)
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKPortLayout_Placement()
     * @model default="0"
     * @generated
     */
	KPortPlacement getPlacement();

	/**
     * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout#getPlacement <em>Placement</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Placement</em>' attribute.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement
     * @see #getPlacement()
     * @generated
     */
	void setPlacement(KPortPlacement value);

} // KPortLayout
