/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KLayoutEdge Label Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout#getLabelPlacement <em>Label Placement</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLabelLayout()
 * @model
 * @generated
 */
public interface KEdgeLabelLayout extends KShapeLayout {
	/**
     * Returns the value of the '<em><b>Label Placement</b></em>' attribute.
     * The literals are from the enumeration {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelPlacement}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Placement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Label Placement</em>' attribute.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelPlacement
     * @see #setLabelPlacement(KEdgeLabelPlacement)
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLabelLayout_LabelPlacement()
     * @model required="true"
     * @generated
     */
	KEdgeLabelPlacement getLabelPlacement();

	/**
     * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout#getLabelPlacement <em>Label Placement</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label Placement</em>' attribute.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelPlacement
     * @see #getLabelPlacement()
     * @generated
     */
	void setLabelPlacement(KEdgeLabelPlacement value);

} // KEdgeLabelLayout
