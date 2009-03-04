/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KNode Group Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel#getLabelLayout <em>Label Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeLabel()
 * @model
 * @generated
 */
public interface KNodeLabel extends KLabel {
	/**
	 * Returns the value of the '<em><b>Label Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Layout</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Layout</em>' containment reference.
	 * @see #setLabelLayout(KNodeLabelLayout)
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeLabel_LabelLayout()
	 * @model containment="true" required="true"
	 * @generated
	 */
	KNodeLabelLayout getLabelLayout();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel#getLabelLayout <em>Label Layout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Layout</em>' containment reference.
	 * @see #getLabelLayout()
	 * @generated
	 */
	void setLabelLayout(KNodeLabelLayout value);

} // KNodeLabel
