/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.layouter.graph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.layouter.graph.CompositeNode#getNodes <em>Nodes</em>}</li>
 *   <li>{@link de.cau.cs.kieler.layouter.graph.CompositeNode#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.layouter.graph.GraphPackage#getCompositeNode()
 * @model
 * @generated
 */
public interface CompositeNode extends Node {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.layouter.graph.Node}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.layouter.graph.Node#getParentNode <em>Parent Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see de.cau.cs.kieler.layouter.graph.GraphPackage#getCompositeNode_Nodes()
	 * @see de.cau.cs.kieler.layouter.graph.Node#getParentNode
	 * @model opposite="parentNode" containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.layouter.graph.Edge}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.layouter.graph.Edge#getParentNode <em>Parent Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see de.cau.cs.kieler.layouter.graph.GraphPackage#getCompositeNode_Edges()
	 * @see de.cau.cs.kieler.layouter.graph.Edge#getParentNode
	 * @model opposite="parentNode" containment="true"
	 * @generated
	 */
	EList<Edge> getEdges();

} // CompositeNode
