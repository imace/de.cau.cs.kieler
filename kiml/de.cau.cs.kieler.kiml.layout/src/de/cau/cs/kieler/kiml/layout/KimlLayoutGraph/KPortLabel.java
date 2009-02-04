/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KLayoutPort Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabel#getLabelLayout <em>Label Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKPortLabel()
 * @model
 * @generated
 */
public interface KPortLabel extends KLabel {
	/**
	 * Returns the value of the '<em><b>Label Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Layout</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Layout</em>' reference.
	 * @see #setLabelLayout(KPortLabelLayout)
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKPortLabel_LabelLayout()
	 * @model
	 * @generated
	 */
	KPortLabelLayout getLabelLayout();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabel#getLabelLayout <em>Label Layout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Layout</em>' reference.
	 * @see #getLabelLayout()
	 * @generated
	 */
	void setLabelLayout(KPortLabelLayout value);

} // KPortLabel
