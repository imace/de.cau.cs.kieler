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
 * A representation of the model object '<em><b>KLayout Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph#getTopGroup <em>Top Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKLayoutGraph()
 * @model
 * @generated
 */
public interface KLayoutGraph extends EObject {
	/**
	 * Returns the value of the '<em><b>Top Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Group</em>' reference.
	 * @see #setTopGroup(KNodeGroup)
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKLayoutGraph_TopGroup()
	 * @model required="true"
	 * @generated
	 */
	KNodeGroup getTopGroup();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph#getTopGroup <em>Top Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Group</em>' reference.
	 * @see #getTopGroup()
	 * @generated
	 */
	void setTopGroup(KNodeGroup value);

} // KLayoutGraph
