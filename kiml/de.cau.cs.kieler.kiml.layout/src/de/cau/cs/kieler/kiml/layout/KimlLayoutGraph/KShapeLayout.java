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
 * A representation of the model object '<em><b>KShape Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#getLocation <em>Location</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#getSize <em>Size</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#isUseLayout <em>Use Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKShapeLayout()
 * @model abstract="true"
 * @generated
 */
public interface KShapeLayout extends EObject {
	/**
	 * Returns the value of the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' reference.
	 * @see #setLocation(KPoint)
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKShapeLayout_Location()
	 * @model required="true"
	 * @generated
	 */
	KPoint getLocation();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#getLocation <em>Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(KPoint value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' reference.
	 * @see #setSize(KDimension)
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKShapeLayout_Size()
	 * @model required="true"
	 * @generated
	 */
	KDimension getSize();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#getSize <em>Size</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' reference.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(KDimension value);

	/**
	 * Returns the value of the '<em><b>Use Layout</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Layout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Layout</em>' attribute.
	 * @see #setUseLayout(boolean)
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKShapeLayout_UseLayout()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isUseLayout();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout#isUseLayout <em>Use Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Layout</em>' attribute.
	 * @see #isUseLayout()
	 * @generated
	 */
	void setUseLayout(boolean value);

} // KShapeLayout
