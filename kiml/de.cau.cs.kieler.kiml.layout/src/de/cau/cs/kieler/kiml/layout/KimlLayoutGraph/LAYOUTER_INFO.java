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
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayouterName <em>Layouter Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayoutType <em>Layout Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayoutOption <em>Layout Option</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayouterCollectionID <em>Layouter Collection ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getLAYOUTER_INFO()
 * @model
 * @generated
 */
public interface LAYOUTER_INFO extends EObject {
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
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getLAYOUTER_INFO_LayouterName()
	 * @model required="true"
	 * @generated
	 */
	String getLayouterName();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayouterName <em>Layouter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layouter Name</em>' attribute.
	 * @see #getLayouterName()
	 * @generated
	 */
	void setLayouterName(String value);

	/**
	 * Returns the value of the '<em><b>Layout Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout Type</em>' attribute.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE
	 * @see #setLayoutType(LAYOUT_TYPE)
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getLAYOUTER_INFO_LayoutType()
	 * @model required="true"
	 * @generated
	 */
	LAYOUT_TYPE getLayoutType();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayoutType <em>Layout Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout Type</em>' attribute.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE
	 * @see #getLayoutType()
	 * @generated
	 */
	void setLayoutType(LAYOUT_TYPE value);

	/**
	 * Returns the value of the '<em><b>Layout Option</b></em>' attribute.
	 * The literals are from the enumeration {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout Option</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout Option</em>' attribute.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION
	 * @see #setLayoutOption(LAYOUT_OPTION)
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getLAYOUTER_INFO_LayoutOption()
	 * @model required="true"
	 * @generated
	 */
	LAYOUT_OPTION getLayoutOption();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayoutOption <em>Layout Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout Option</em>' attribute.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION
	 * @see #getLayoutOption()
	 * @generated
	 */
	void setLayoutOption(LAYOUT_OPTION value);

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
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getLAYOUTER_INFO_LayouterCollectionID()
	 * @model required="true"
	 * @generated
	 */
	String getLayouterCollectionID();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO#getLayouterCollectionID <em>Layouter Collection ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layouter Collection ID</em>' attribute.
	 * @see #getLayouterCollectionID()
	 * @generated
	 */
	void setLayouterCollectionID(String value);

} // LAYOUTER_INFO
