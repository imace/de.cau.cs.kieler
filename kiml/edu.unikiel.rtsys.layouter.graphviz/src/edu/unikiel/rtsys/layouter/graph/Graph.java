/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.layouter.graph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.Graph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.Graph#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getGraph()
 * @model
 * @generated
 */
public interface Graph extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.layouter.graph.Node}.
	 * It is bidirectional and its opposite is '{@link edu.unikiel.rtsys.layouter.graph.Node#getParentGraph <em>Parent Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getGraph_Nodes()
	 * @see edu.unikiel.rtsys.layouter.graph.Node#getParentGraph
	 * @model opposite="parentGraph" containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.layouter.graph.Edge}.
	 * It is bidirectional and its opposite is '{@link edu.unikiel.rtsys.layouter.graph.Edge#getParentGraph <em>Parent Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getGraph_Edges()
	 * @see edu.unikiel.rtsys.layouter.graph.Edge#getParentGraph
	 * @model opposite="parentGraph" containment="true"
	 * @generated
	 */
	EList<Edge> getEdges();

} // Graph
