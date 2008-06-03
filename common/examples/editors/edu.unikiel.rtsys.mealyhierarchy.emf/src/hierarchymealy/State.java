/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hierarchymealy;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hierarchymealy.State#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link hierarchymealy.State#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link hierarchymealy.State#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see hierarchymealy.MealyPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>Outgoing Edges</b></em>' reference list.
	 * The list contents are of type {@link hierarchymealy.Edge}.
	 * It is bidirectional and its opposite is '{@link hierarchymealy.Edge#getSourceNode <em>Source Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Edges</em>' reference list.
	 * @see hierarchymealy.MealyPackage#getState_OutgoingEdges()
	 * @see hierarchymealy.Edge#getSourceNode
	 * @model opposite="sourceNode"
	 * @generated
	 */
	EList<Edge> getOutgoingEdges();

	/**
	 * Returns the value of the '<em><b>Incoming Edges</b></em>' reference list.
	 * The list contents are of type {@link hierarchymealy.Edge}.
	 * It is bidirectional and its opposite is '{@link hierarchymealy.Edge#getTargetNode <em>Target Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Edges</em>' reference list.
	 * @see hierarchymealy.MealyPackage#getState_IncomingEdges()
	 * @see hierarchymealy.Edge#getTargetNode
	 * @model opposite="targetNode"
	 * @generated
	 */
	EList<Edge> getIncomingEdges();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see hierarchymealy.MealyPackage#getState_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link hierarchymealy.State#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // State
