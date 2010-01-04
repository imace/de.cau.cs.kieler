/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblock;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.InterfaceList#getMixed <em>Mixed</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.InterfaceList#getEventInputs <em>Event Inputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.InterfaceList#getEventOutputs <em>Event Outputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.InterfaceList#getInputVars <em>Input Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.InterfaceList#getOutputVars <em>Output Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.InterfaceList#getSockets <em>Sockets</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.InterfaceList#getPlugs <em>Plugs</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getInterfaceList()
 * @model extendedMetaData="name='InterfaceList_._type' kind='mixed'"
 * @generated
 */
public interface InterfaceList extends EObject {
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
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getInterfaceList_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Event Inputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Event Inputs</em>' containment reference.
	 * @see #setEventInputs(EventInputs)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getInterfaceList_EventInputs()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='EventInputs' namespace='##targetNamespace'"
	 * @generated
	 */
	EventInputs getEventInputs();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.InterfaceList#getEventInputs <em>Event Inputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Inputs</em>' containment reference.
	 * @see #getEventInputs()
	 * @generated
	 */
	void setEventInputs(EventInputs value);

	/**
	 * Returns the value of the '<em><b>Event Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Event Outputs</em>' containment reference.
	 * @see #setEventOutputs(EventOutputs)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getInterfaceList_EventOutputs()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='EventOutputs' namespace='##targetNamespace'"
	 * @generated
	 */
	EventOutputs getEventOutputs();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.InterfaceList#getEventOutputs <em>Event Outputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Outputs</em>' containment reference.
	 * @see #getEventOutputs()
	 * @generated
	 */
	void setEventOutputs(EventOutputs value);

	/**
	 * Returns the value of the '<em><b>Input Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input Vars</em>' containment reference.
	 * @see #setInputVars(InputVars)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getInterfaceList_InputVars()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='InputVars' namespace='##targetNamespace'"
	 * @generated
	 */
	InputVars getInputVars();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.InterfaceList#getInputVars <em>Input Vars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Vars</em>' containment reference.
	 * @see #getInputVars()
	 * @generated
	 */
	void setInputVars(InputVars value);

	/**
	 * Returns the value of the '<em><b>Output Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output Vars</em>' containment reference.
	 * @see #setOutputVars(OutputVars)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getInterfaceList_OutputVars()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='OutputVars' namespace='##targetNamespace'"
	 * @generated
	 */
	OutputVars getOutputVars();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.InterfaceList#getOutputVars <em>Output Vars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Vars</em>' containment reference.
	 * @see #getOutputVars()
	 * @generated
	 */
	void setOutputVars(OutputVars value);

	/**
	 * Returns the value of the '<em><b>Sockets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sockets</em>' containment reference.
	 * @see #setSockets(Sockets)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getInterfaceList_Sockets()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Sockets' namespace='##targetNamespace'"
	 * @generated
	 */
	Sockets getSockets();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.InterfaceList#getSockets <em>Sockets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sockets</em>' containment reference.
	 * @see #getSockets()
	 * @generated
	 */
	void setSockets(Sockets value);

	/**
	 * Returns the value of the '<em><b>Plugs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Plugs</em>' containment reference.
	 * @see #setPlugs(Plugs)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getInterfaceList_Plugs()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Plugs' namespace='##targetNamespace'"
	 * @generated
	 */
	Plugs getPlugs();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.InterfaceList#getPlugs <em>Plugs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugs</em>' containment reference.
	 * @see #getPlugs()
	 * @generated
	 */
	void setPlugs(Plugs value);

} // InterfaceList
