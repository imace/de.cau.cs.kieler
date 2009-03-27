/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LAYOUTER INFO</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayouterName <em>Layouter Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayoutType <em>Layout Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayoutOption <em>Layout Option</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayouterCollectionID <em>Layouter Collection ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKLayouterInfo()
 * @model
 * @generated
 */
public interface KLayouterInfo extends EObject {
	/**
     * Returns the value of the '<em><b>Layouter Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layouter Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Layouter Name</em>' attribute.
     * @see #setLayouterName(String)
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKLayouterInfo_LayouterName()
     * @model required="true"
     * @generated
     */
	String getLayouterName();

	/**
     * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayouterName <em>Layouter Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Layouter Name</em>' attribute.
     * @see #getLayouterName()
     * @generated
     */
	void setLayouterName(String value);

	/**
     * Returns the value of the '<em><b>Layout Type</b></em>' attribute.
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
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKLayouterInfo_LayoutType()
     * @model required="true"
     * @generated
     */
	KLayoutType getLayoutType();

	/**
     * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayoutType <em>Layout Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Layout Type</em>' attribute.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType
     * @see #getLayoutType()
     * @generated
     */
	void setLayoutType(KLayoutType value);

	/**
     * Returns the value of the '<em><b>Layout Option</b></em>' attribute.
     * The literals are from the enumeration {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout Option</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Layout Option</em>' attribute.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption
     * @see #setLayoutOption(KLayoutOption)
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKLayouterInfo_LayoutOption()
     * @model required="true"
     * @generated
     */
	KLayoutOption getLayoutOption();

	/**
     * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayoutOption <em>Layout Option</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Layout Option</em>' attribute.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption
     * @see #getLayoutOption()
     * @generated
     */
	void setLayoutOption(KLayoutOption value);

	/**
     * Returns the value of the '<em><b>Layouter Collection ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layouter Collection ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Layouter Collection ID</em>' attribute.
     * @see #setLayouterCollectionID(String)
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKLayouterInfo_LayouterCollectionID()
     * @model required="true"
     * @generated
     */
	String getLayouterCollectionID();

	/**
     * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo#getLayouterCollectionID <em>Layouter Collection ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Layouter Collection ID</em>' attribute.
     * @see #getLayouterCollectionID()
     * @generated
     */
	void setLayouterCollectionID(String value);

} // KLayouterInfo
