/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KEdge Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getSourcePoint <em>Source Point</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getTargetPoint <em>Target Point</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getGridPoints <em>Grid Points</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getEdgeType <em>Edge Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLayout()
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
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLayout_SourcePoint()
	 * @model required="true"
	 * @generated
	 */
	KPoint getSourcePoint();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getSourcePoint <em>Source Point</em>}' reference.
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
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLayout_TargetPoint()
	 * @model required="true"
	 * @generated
	 */
	KPoint getTargetPoint();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getTargetPoint <em>Target Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Point</em>' reference.
	 * @see #getTargetPoint()
	 * @generated
	 */
	void setTargetPoint(KPoint value);

	/**
	 * Returns the value of the '<em><b>Grid Points</b></em>' reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid Points</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grid Points</em>' reference list.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLayout_GridPoints()
	 * @model
	 * @generated
	 */
	EList<KPoint> getGridPoints();

	/**
	 * Returns the value of the '<em><b>Edge Type</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Type</em>' attribute.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE
	 * @see #setEdgeType(EDGE_TYPE)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKEdgeLayout_EdgeType()
	 * @model required="true"
	 * @generated
	 */
	EDGE_TYPE getEdgeType();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout#getEdgeType <em>Edge Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge Type</em>' attribute.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE
	 * @see #getEdgeType()
	 * @generated
	 */
	void setEdgeType(EDGE_TYPE value);

} // KEdgeLayout
