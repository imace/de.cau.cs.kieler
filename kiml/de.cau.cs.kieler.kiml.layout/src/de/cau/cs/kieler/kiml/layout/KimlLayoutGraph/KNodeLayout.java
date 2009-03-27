/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KNode Group Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout#getLayoutType <em>Layout Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout#getLayoutOptions <em>Layout Options</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout#getLayouterName <em>Layouter Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout#getInsets <em>Insets</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeLayout()
 * @model
 * @generated
 */
public interface KNodeLayout extends KShapeLayout {
	/**
     * Returns the value of the '<em><b>Layout Type</b></em>' attribute.
     * The default value is <code>""</code>.
     * The literals are from the enumeration {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Layout Type</em>' attribute.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType
     * @see #setLayoutType(KLayoutType)
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeLayout_LayoutType()
     * @model default="" required="true"
     * @generated
     */
	KLayoutType getLayoutType();

	/**
     * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout#getLayoutType <em>Layout Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Layout Type</em>' attribute.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType
     * @see #getLayoutType()
     * @generated
     */
	void setLayoutType(KLayoutType value);

	/**
     * Returns the value of the '<em><b>Layout Options</b></em>' attribute list.
     * The list contents are of type {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption}.
     * The literals are from the enumeration {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout Options</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Layout Options</em>' attribute list.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeLayout_LayoutOptions()
     * @model default="" ordered="false"
     * @generated
     */
	EList<KLayoutOption> getLayoutOptions();

	/**
     * Returns the value of the '<em><b>Layouter Name</b></em>' attribute.
     * The default value is <code>"\"\""</code>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layouter Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Layouter Name</em>' attribute.
     * @see #setLayouterName(String)
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeLayout_LayouterName()
     * @model default="\"\"" required="true"
     * @generated
     */
	String getLayouterName();

	/**
     * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout#getLayouterName <em>Layouter Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Layouter Name</em>' attribute.
     * @see #getLayouterName()
     * @generated
     */
	void setLayouterName(String value);

	/**
     * Returns the value of the '<em><b>Insets</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Insets</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Insets</em>' containment reference.
     * @see #setInsets(KInsets)
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeLayout_Insets()
     * @model containment="true" required="true"
     * @generated
     */
	KInsets getInsets();

	/**
     * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout#getInsets <em>Insets</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Insets</em>' containment reference.
     * @see #getInsets()
     * @generated
     */
	void setInsets(KInsets value);

} // KNodeLayout
