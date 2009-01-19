/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.layouter.graph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.layouter.graph.Node#getParentGraph <em>Parent Graph</em>}</li>
 *   <li>{@link de.cau.cs.kieler.layouter.graph.Node#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link de.cau.cs.kieler.layouter.graph.Node#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link de.cau.cs.kieler.layouter.graph.Node#getSize <em>Size</em>}</li>
 *   <li>{@link de.cau.cs.kieler.layouter.graph.Node#getPosition <em>Position</em>}</li>
 *   <li>{@link de.cau.cs.kieler.layouter.graph.Node#getData <em>Data</em>}</li>
 *   <li>{@link de.cau.cs.kieler.layouter.graph.Node#getParentNode <em>Parent Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.layouter.graph.GraphPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Graph</em>' reference.
	 * @see #setParentGraph(Graph)
	 * @see de.cau.cs.kieler.layouter.graph.GraphPackage#getNode_ParentGraph()
	 * @model required="true"
	 * @generated
	 */
	Graph getParentGraph();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.layouter.graph.Node#getParentGraph <em>Parent Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Graph</em>' reference.
	 * @see #getParentGraph()
	 * @generated
	 */
	void setParentGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Outgoing Edges</b></em>' reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.layouter.graph.Edge}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.layouter.graph.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Edges</em>' reference list.
	 * @see de.cau.cs.kieler.layouter.graph.GraphPackage#getNode_OutgoingEdges()
	 * @see de.cau.cs.kieler.layouter.graph.Edge#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Edge> getOutgoingEdges();

	/**
	 * Returns the value of the '<em><b>Incoming Edges</b></em>' reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.layouter.graph.Edge}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.layouter.graph.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Edges</em>' reference list.
	 * @see de.cau.cs.kieler.layouter.graph.GraphPackage#getNode_IncomingEdges()
	 * @see de.cau.cs.kieler.layouter.graph.Edge#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Edge> getIncomingEdges();

	/**
	 * Returns the value of the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' containment reference.
	 * @see #setSize(Size)
	 * @see de.cau.cs.kieler.layouter.graph.GraphPackage#getNode_Size()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Size getSize();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.layouter.graph.Node#getSize <em>Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' containment reference.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Size value);

	/**
	 * Returns the value of the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' containment reference.
	 * @see #setPosition(Coordinates)
	 * @see de.cau.cs.kieler.layouter.graph.GraphPackage#getNode_Position()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Coordinates getPosition();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.layouter.graph.Node#getPosition <em>Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' containment reference.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(Coordinates value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(Object)
	 * @see de.cau.cs.kieler.layouter.graph.GraphPackage#getNode_Data()
	 * @model
	 * @generated
	 */
	Object getData();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.layouter.graph.Node#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(Object value);

	/**
	 * Returns the value of the '<em><b>Parent Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.layouter.graph.CompositeNode#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Node</em>' container reference.
	 * @see #setParentNode(CompositeNode)
	 * @see de.cau.cs.kieler.layouter.graph.GraphPackage#getNode_ParentNode()
	 * @see de.cau.cs.kieler.layouter.graph.CompositeNode#getNodes
	 * @model opposite="nodes" required="true" transient="false"
	 * @generated
	 */
	CompositeNode getParentNode();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.layouter.graph.Node#getParentNode <em>Parent Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Node</em>' container reference.
	 * @see #getParentNode()
	 * @generated
	 */
	void setParentNode(CompositeNode value);

} // Node
