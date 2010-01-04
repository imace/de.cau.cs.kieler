/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblock;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FBD</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.FBD#getFB <em>FB</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.FBD#getDataConnections <em>Data Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getFBD()
 * @model extendedMetaData="name='FBD_._type' kind='elementOnly'"
 * @generated
 */
public interface FBD extends EObject {
	/**
	 * Returns the value of the '<em><b>FB</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblock.FB}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Common element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>FB</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getFBD_FB()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='FB' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<FB> getFB();

	/**
	 * Returns the value of the '<em><b>Data Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Common element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Data Connections</em>' containment reference.
	 * @see #setDataConnections(DataConnections)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getFBD_DataConnections()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='DataConnections' namespace='##targetNamespace'"
	 * @generated
	 */
	DataConnections getDataConnections();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.FBD#getDataConnections <em>Data Connections</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Connections</em>' containment reference.
	 * @see #getDataConnections()
	 * @generated
	 */
	void setDataConnections(DataConnections value);

} // FBD
