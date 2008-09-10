/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KNode Group Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabel#getLabelLayout <em>Label Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroupLabel()
 * @model
 * @generated
 */
public interface KNodeGroupLabel extends KLabel {
	/**
	 * Returns the value of the '<em><b>Label Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Layout</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Layout</em>' reference.
	 * @see #setLabelLayout(KNodeGroupLabelLayout)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroupLabel_LabelLayout()
	 * @model required="true"
	 * @generated
	 */
	KNodeGroupLabelLayout getLabelLayout();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabel#getLabelLayout <em>Label Layout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Layout</em>' reference.
	 * @see #getLabelLayout()
	 * @generated
	 */
	void setLabelLayout(KNodeGroupLabelLayout value);

} // KNodeGroupLabel
