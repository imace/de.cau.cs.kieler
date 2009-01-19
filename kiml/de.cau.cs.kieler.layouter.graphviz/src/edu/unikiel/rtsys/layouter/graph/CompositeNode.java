/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.layouter.graph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.CompositeNode#getNodes <em>Nodes</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.CompositeNode#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getCompositeNode()
 * @model
 * @generated
 */
public interface CompositeNode extends Node {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.layouter.graph.Node}.
	 * It is bidirectional and its opposite is '{@link edu.unikiel.rtsys.layouter.graph.Node#getParentNode <em>Parent Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getCompositeNode_Nodes()
	 * @see edu.unikiel.rtsys.layouter.graph.Node#getParentNode
	 * @model opposite="parentNode" containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.layouter.graph.Edge}.
	 * It is bidirectional and its opposite is '{@link edu.unikiel.rtsys.layouter.graph.Edge#getParentNode <em>Parent Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getCompositeNode_Edges()
	 * @see edu.unikiel.rtsys.layouter.graph.Edge#getParentNode
	 * @model opposite="parentNode" containment="true"
	 * @generated
	 */
	EList<Edge> getEdges();

} // CompositeNode
