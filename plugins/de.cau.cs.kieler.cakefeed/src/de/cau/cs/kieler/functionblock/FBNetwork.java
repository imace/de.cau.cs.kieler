/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblock;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FB Network</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.FBNetwork#getMixed <em>Mixed</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.FBNetwork#getFB <em>FB</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.FBNetwork#getEventConnections <em>Event Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.FBNetwork#getDataConnections <em>Data Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.FBNetwork#getAdapterConnections <em>Adapter Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getFBNetwork()
 * @model extendedMetaData="name='FBNetwork_._type' kind='mixed'"
 * @generated
 */
public interface FBNetwork extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getFBNetwork_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>FB</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblock.FB}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Common element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>FB</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getFBNetwork_FB()
	 * @model containment="true" transient="true" volatile="true" derived="true"
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
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getFBNetwork_EventConnections()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='EventConnections' namespace='##targetNamespace'"
	 * @generated
	 */
	EventConnections getEventConnections();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.FBNetwork#getEventConnections <em>Event Connections</em>}' containment reference.
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
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getFBNetwork_DataConnections()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='DataConnections' namespace='##targetNamespace'"
	 * @generated
	 */
	DataConnections getDataConnections();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.FBNetwork#getDataConnections <em>Data Connections</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Connections</em>' containment reference.
	 * @see #getDataConnections()
	 * @generated
	 */
	void setDataConnections(DataConnections value);

	/**
	 * Returns the value of the '<em><b>Adapter Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Common element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Adapter Connections</em>' containment reference.
	 * @see #setAdapterConnections(AdapterConnections)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getFBNetwork_AdapterConnections()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='AdapterConnections' namespace='##targetNamespace'"
	 * @generated
	 */
	AdapterConnections getAdapterConnections();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.FBNetwork#getAdapterConnections <em>Adapter Connections</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adapter Connections</em>' containment reference.
	 * @see #getAdapterConnections()
	 * @generated
	 */
	void setAdapterConnections(AdapterConnections value);

} // FBNetwork
