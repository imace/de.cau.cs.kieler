/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KNode Group Label Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabelLayout#getLabelPlacement <em>Label Placement</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroupLabelLayout()
 * @model
 * @generated
 */
public interface KNodeGroupLabelLayout extends KShapeLayout {
	/**
	 * Returns the value of the '<em><b>Label Placement</b></em>' attribute.
	 * The literals are from the enumeration {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Placement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Placement</em>' attribute.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT
	 * @see #setLabelPlacement(NODE_LABEL_PLACEMENT)
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroupLabelLayout_LabelPlacement()
	 * @model required="true"
	 * @generated
	 */
	NODE_LABEL_PLACEMENT getLabelPlacement();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabelLayout#getLabelPlacement <em>Label Placement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Placement</em>' attribute.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.NODE_LABEL_PLACEMENT
	 * @see #getLabelPlacement()
	 * @generated
	 */
	void setLabelPlacement(NODE_LABEL_PLACEMENT value);

} // KNodeGroupLabelLayout
