/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataflow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataflow.DataflowModel#getName <em>Name</em>}</li>
 *   <li>{@link dataflow.DataflowModel#getBoxes <em>Boxes</em>}</li>
 *   <li>{@link dataflow.DataflowModel#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataflow.DataflowPackage#getDataflowModel()
 * @model
 * @generated
 */
public interface DataflowModel extends EObject {
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
	 * @see dataflow.DataflowPackage#getDataflowModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link dataflow.DataflowModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Boxes</b></em>' containment reference list.
	 * The list contents are of type {@link dataflow.Box}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boxes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boxes</em>' containment reference list.
	 * @see dataflow.DataflowPackage#getDataflowModel_Boxes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Box> getBoxes();

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
	 * The list contents are of type {@link dataflow.Connection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference list.
	 * @see dataflow.DataflowPackage#getDataflowModel_Connections()
	 * @model containment="true"
	 * @generated
	 */
	EList<Connection> getConnections();

} // DataflowModel
