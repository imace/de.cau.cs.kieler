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
 * A representation of the model object '<em><b>Sub App Network</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.SubAppNetwork#getSubApp <em>Sub App</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.SubAppNetwork#getFB <em>FB</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.SubAppNetwork#getEventConnections <em>Event Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.SubAppNetwork#getDataConnections <em>Data Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getSubAppNetwork()
 * @model extendedMetaData="name='SubAppNetwork_._type' kind='elementOnly'"
 * @generated
 */
public interface SubAppNetwork extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub App</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblock.SubApp}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SubAppType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub App</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getSubAppNetwork_SubApp()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='SubApp' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SubApp> getSubApp();

	/**
	 * Returns the value of the '<em><b>FB</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblock.FB}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Common element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>FB</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getSubAppNetwork_FB()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='FB' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<FB> getFB();

	/**
	 * Returns the value of the '<em><b>Event Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Common element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Event Connections</em>' containment reference.
	 * @see #setEventConnections(EventConnections)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getSubAppNetwork_EventConnections()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='EventConnections' namespace='##targetNamespace'"
	 * @generated
	 */
	EventConnections getEventConnections();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.SubAppNetwork#getEventConnections <em>Event Connections</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Connections</em>' containment reference.
	 * @see #getEventConnections()
	 * @generated
	 */
	void setEventConnections(EventConnections value);

	/**
	 * Returns the value of the '<em><b>Data Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Common element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Data Connections</em>' containment reference.
	 * @see #setDataConnections(DataConnections)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getSubAppNetwork_DataConnections()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='DataConnections' namespace='##targetNamespace'"
	 * @generated
	 */
	DataConnections getDataConnections();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.SubAppNetwork#getDataConnections <em>Data Connections</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Connections</em>' containment reference.
	 * @see #getDataConnections()
	 * @generated
	 */
	void setDataConnections(DataConnections value);

} // SubAppNetwork
