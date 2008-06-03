/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hierarchymealy;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hierarchymealy.CompositeState#getNodes <em>Nodes</em>}</li>
 *   <li>{@link hierarchymealy.CompositeState#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @see hierarchymealy.MealyPackage#getCompositeState()
 * @model
 * @generated
 */
public interface CompositeState extends State {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link hierarchymealy.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see hierarchymealy.MealyPackage#getCompositeState_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link hierarchymealy.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see hierarchymealy.MealyPackage#getCompositeState_Edges()
	 * @model containment="true"
	 * @generated
	 */
	EList<Edge> getEdges();

} // CompositeState
