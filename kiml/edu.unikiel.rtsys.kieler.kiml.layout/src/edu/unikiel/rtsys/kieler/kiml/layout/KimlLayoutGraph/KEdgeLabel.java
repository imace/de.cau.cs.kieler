/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KEdge Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel#getLabelLayout <em>Label Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLabel()
 * @model
 * @generated
 */
public interface KEdgeLabel extends KLabel {
	/**
	 * Returns the value of the '<em><b>Label Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Layout</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Layout</em>' reference.
	 * @see #setLabelLayout(KEdgeLabelLayout)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLabel_LabelLayout()
	 * @model required="true"
	 * @generated
	 */
	KEdgeLabelLayout getLabelLayout();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel#getLabelLayout <em>Label Layout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Layout</em>' reference.
	 * @see #getLabelLayout()
	 * @generated
	 */
	void setLabelLayout(KEdgeLabelLayout value);

} // KEdgeLabel
