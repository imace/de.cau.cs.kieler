/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KLayoutEdge Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel#getLabelLayout <em>Label Layout</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel#getParentEdge <em>Parent Edge</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLabel()
 * @model
 * @generated
 */
public interface KEdgeLabel extends KLabel {
	/**
     * Returns the value of the '<em><b>Label Layout</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Layout</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Label Layout</em>' containment reference.
     * @see #setLabelLayout(KEdgeLabelLayout)
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLabel_LabelLayout()
     * @model containment="true" required="true"
     * @generated
     */
	KEdgeLabelLayout getLabelLayout();

	/**
     * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel#getLabelLayout <em>Label Layout</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label Layout</em>' containment reference.
     * @see #getLabelLayout()
     * @generated
     */
	void setLabelLayout(KEdgeLabelLayout value);

    /**
     * Returns the value of the '<em><b>Parent Edge</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent Edge</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parent Edge</em>' container reference.
     * @see #setParentEdge(KLayoutEdge)
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLabel_ParentEdge()
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge#getLabel
     * @model opposite="label" required="true" transient="false"
     * @generated
     */
    KLayoutEdge getParentEdge();

    /**
     * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel#getParentEdge <em>Parent Edge</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent Edge</em>' container reference.
     * @see #getParentEdge()
     * @generated
     */
    void setParentEdge(KLayoutEdge value);

} // KEdgeLabel
