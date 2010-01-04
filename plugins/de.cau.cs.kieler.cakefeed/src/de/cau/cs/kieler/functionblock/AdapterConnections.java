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
 * A representation of the model object '<em><b>Adapter Connections</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.AdapterConnections#getConnection <em>Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getAdapterConnections()
 * @model extendedMetaData="name='AdapterConnections_._type' kind='elementOnly'"
 * @generated
 */
public interface AdapterConnections extends EObject {
	/**
	 * Returns the value of the '<em><b>Connection</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblock.Connection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Common element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connection</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getAdapterConnections_Connection()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Connection' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Connection> getConnection();

} // AdapterConnections
