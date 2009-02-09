/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KLayoutEdge Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getSourcePoint <em>Source Point</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getTargetPoint <em>Target Point</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getBendPoints <em>Bend Points</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getEdgeType <em>Edge Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#isUseLayout <em>Use Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLayout()
 * @model
 * @generated
 */
public interface KEdgeLayout extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Point</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Point</em>' reference.
	 * @see #setSourcePoint(KPoint)
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLayout_SourcePoint()
	 * @model required="true"
	 * @generated
	 */
	KPoint getSourcePoint();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getSourcePoint <em>Source Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Point</em>' reference.
	 * @see #getSourcePoint()
	 * @generated
	 */
	void setSourcePoint(KPoint value);

	/**
	 * Returns the value of the '<em><b>Target Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Point</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Point</em>' reference.
	 * @see #setTargetPoint(KPoint)
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLayout_TargetPoint()
	 * @model required="true"
	 * @generated
	 */
	KPoint getTargetPoint();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getTargetPoint <em>Target Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Point</em>' reference.
	 * @see #getTargetPoint()
	 * @generated
	 */
	void setTargetPoint(KPoint value);

	/**
	 * Returns the value of the '<em><b>Bend Points</b></em>' reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid Points</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bend Points</em>' reference list.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLayout_BendPoints()
	 * @model
	 * @generated
	 */
	EList<KPoint> getBendPoints();

	/**
	 * Returns the value of the '<em><b>Edge Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Type</em>' attribute.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeType
	 * @see #setEdgeType(KEdgeType)
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLayout_EdgeType()
	 * @model required="true"
	 * @generated
	 */
	KEdgeType getEdgeType();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getEdgeType <em>Edge Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge Type</em>' attribute.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeType
	 * @see #getEdgeType()
	 * @generated
	 */
	void setEdgeType(KEdgeType value);

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
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLayout_UseLayout()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isUseLayout();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#isUseLayout <em>Use Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Layout</em>' attribute.
	 * @see #isUseLayout()
	 * @generated
	 */
	void setUseLayout(boolean value);

} // KEdgeLayout
