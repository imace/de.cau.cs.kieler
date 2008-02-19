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
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.Edge#getParentGraph <em>Parent Graph</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.Edge#getTarget <em>Target</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.Edge#getSource <em>Source</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.Edge#getBendpoints <em>Bendpoints</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.Edge#getData <em>Data</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.Edge#getEdgeLabel <em>Edge Label</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.Edge#getHeadLabel <em>Head Label</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.Edge#getTailLabel <em>Tail Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.unikiel.rtsys.layouter.graph.Graph#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Graph</em>' container reference.
	 * @see #setParentGraph(Graph)
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getEdge_ParentGraph()
	 * @see edu.unikiel.rtsys.layouter.graph.Graph#getEdges
	 * @model opposite="edges" required="true" transient="false"
	 * @generated
	 */
	Graph getParentGraph();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.layouter.graph.Edge#getParentGraph <em>Parent Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Graph</em>' container reference.
	 * @see #getParentGraph()
	 * @generated
	 */
	void setParentGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.unikiel.rtsys.layouter.graph.Node#getIncomingEdges <em>Incoming Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getEdge_Target()
	 * @see edu.unikiel.rtsys.layouter.graph.Node#getIncomingEdges
	 * @model opposite="incomingEdges" required="true"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.layouter.graph.Edge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.unikiel.rtsys.layouter.graph.Node#getOutgoingEdges <em>Outgoing Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getEdge_Source()
	 * @see edu.unikiel.rtsys.layouter.graph.Node#getOutgoingEdges
	 * @model opposite="outgoingEdges" required="true"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.layouter.graph.Edge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Bendpoints</b></em>' containment reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.layouter.graph.Coordinates}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bendpoints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bendpoints</em>' containment reference list.
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getEdge_Bendpoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Coordinates> getBendpoints();

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
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getEdge_Data()
	 * @model
	 * @generated
	 */
	Object getData();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.layouter.graph.Edge#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(Object value);

	/**
	 * Returns the value of the '<em><b>Edge Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Label</em>' containment reference.
	 * @see #setEdgeLabel(Label)
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getEdge_EdgeLabel()
	 * @model containment="true"
	 * @generated
	 */
	Label getEdgeLabel();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.layouter.graph.Edge#getEdgeLabel <em>Edge Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge Label</em>' containment reference.
	 * @see #getEdgeLabel()
	 * @generated
	 */
	void setEdgeLabel(Label value);

	/**
	 * Returns the value of the '<em><b>Head Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Label</em>' containment reference.
	 * @see #setHeadLabel(Label)
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getEdge_HeadLabel()
	 * @model containment="true"
	 * @generated
	 */
	Label getHeadLabel();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.layouter.graph.Edge#getHeadLabel <em>Head Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Label</em>' containment reference.
	 * @see #getHeadLabel()
	 * @generated
	 */
	void setHeadLabel(Label value);

	/**
	 * Returns the value of the '<em><b>Tail Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tail Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tail Label</em>' containment reference.
	 * @see #setTailLabel(Label)
	 * @see edu.unikiel.rtsys.layouter.graph.GraphPackage#getEdge_TailLabel()
	 * @model containment="true"
	 * @generated
	 */
	Label getTailLabel();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.layouter.graph.Edge#getTailLabel <em>Tail Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tail Label</em>' containment reference.
	 * @see #getTailLabel()
	 * @generated
	 */
	void setTailLabel(Label value);

} // Edge
