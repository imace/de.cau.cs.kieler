/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KNode Group Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout#getLayoutType <em>Layout Type</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout#getLayoutOptions <em>Layout Options</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout#getLayouterName <em>Layouter Name</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout#getInsets <em>Insets</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroupLayout()
 * @model
 * @generated
 */
public interface KNodeGroupLayout extends KShapeLayout {
	/**
	 * Returns the value of the '<em><b>Layout Type</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout Type</em>' attribute.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE
	 * @see #setLayoutType(LAYOUT_TYPE)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroupLayout_LayoutType()
	 * @model default="" required="true"
	 * @generated
	 */
	LAYOUT_TYPE getLayoutType();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout#getLayoutType <em>Layout Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout Type</em>' attribute.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE
	 * @see #getLayoutType()
	 * @generated
	 */
	void setLayoutType(LAYOUT_TYPE value);

	/**
	 * Returns the value of the '<em><b>Layout Options</b></em>' attribute list.
	 * The list contents are of type {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION}.
	 * The literals are from the enumeration {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout Options</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout Options</em>' attribute list.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroupLayout_LayoutOptions()
	 * @model default="" ordered="false"
	 * @generated
	 */
	EList<LAYOUT_OPTION> getLayoutOptions();

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
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroupLayout_LayouterName()
	 * @model default="\"\"" required="true"
	 * @generated
	 */
	String getLayouterName();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout#getLayouterName <em>Layouter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layouter Name</em>' attribute.
	 * @see #getLayouterName()
	 * @generated
	 */
	void setLayouterName(String value);

	/**
	 * Returns the value of the '<em><b>Insets</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Insets</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Insets</em>' reference.
	 * @see #setInsets(KInsets)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroupLayout_Insets()
	 * @model required="true"
	 * @generated
	 */
	KInsets getInsets();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout#getInsets <em>Insets</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Insets</em>' reference.
	 * @see #getInsets()
	 * @generated
	 */
	void setInsets(KInsets value);

} // KNodeGroupLayout
