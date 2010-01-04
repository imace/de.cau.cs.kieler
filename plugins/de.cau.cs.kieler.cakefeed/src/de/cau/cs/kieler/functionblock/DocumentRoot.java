/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblock;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getAdapterConnections <em>Adapter Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getAdapterDeclaration <em>Adapter Declaration</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getAdapterType <em>Adapter Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getApplication <em>Application</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getBasicFB <em>Basic FB</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getCompiler <em>Compiler</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getCompilerInfo <em>Compiler Info</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getConnection <em>Connection</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getDataConnections <em>Data Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getDevice <em>Device</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getDeviceType <em>Device Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getECAction <em>EC Action</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getECC <em>ECC</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getECState <em>EC State</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getECTransition <em>EC Transition</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getEvent <em>Event</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getEventConnections <em>Event Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getEventInputs <em>Event Inputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getEventOutputs <em>Event Outputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getFB <em>FB</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getFBD <em>FBD</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getFBNetwork <em>FB Network</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getFBType <em>FB Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getFBTypeName <em>FB Type Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getHCECC <em>HCECC</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getHCECCRelation <em>HCECC Relation</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getIdentification <em>Identification</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getInputPrimitive <em>Input Primitive</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getInputVars <em>Input Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getInterfaceList <em>Interface List</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getInternalVars <em>Internal Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getLD <em>LD</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getLink <em>Link</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getMapping <em>Mapping</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getOther <em>Other</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getOutputPrimitive <em>Output Primitive</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getOutputVars <em>Output Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getPlugs <em>Plugs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getResource <em>Resource</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getResourceTypeName <em>Resource Type Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getRung <em>Rung</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSegment <em>Segment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getService <em>Service</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getServiceSequence <em>Service Sequence</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getServiceTransaction <em>Service Transaction</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSockets <em>Sockets</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getST <em>ST</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubApp <em>Sub App</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppEvent <em>Sub App Event</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppEventInputs <em>Sub App Event Inputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppEventOutputs <em>Sub App Event Outputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppInterfaceList <em>Sub App Interface List</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppNetwork <em>Sub App Network</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppType <em>Sub App Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSystem <em>System</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getVarDeclaration <em>Var Declaration</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getVersionInfo <em>Version Info</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.DocumentRoot#getWith <em>With</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
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
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap<String, String> getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap<String, String> getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Adapter Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Common element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Adapter Connections</em>' containment reference.
	 * @see #setAdapterConnections(AdapterConnections)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_AdapterConnections()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='AdapterConnections' namespace='##targetNamespace'"
	 * @generated
	 */
	AdapterConnections getAdapterConnections();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getAdapterConnections <em>Adapter Connections</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adapter Connections</em>' containment reference.
	 * @see #getAdapterConnections()
	 * @generated
	 */
	void setAdapterConnections(AdapterConnections value);

	/**
	 * Returns the value of the '<em><b>Adapter Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Adapter Declaration</em>' containment reference.
	 * @see #setAdapterDeclaration(AdapterDeclaration)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_AdapterDeclaration()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='AdapterDeclaration' namespace='##targetNamespace'"
	 * @generated
	 */
	AdapterDeclaration getAdapterDeclaration();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getAdapterDeclaration <em>Adapter Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adapter Declaration</em>' containment reference.
	 * @see #getAdapterDeclaration()
	 * @generated
	 */
	void setAdapterDeclaration(AdapterDeclaration value);

	/**
	 * Returns the value of the '<em><b>Adapter Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * AdapterType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Adapter Type</em>' containment reference.
	 * @see #setAdapterType(AdapterType)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_AdapterType()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='AdapterType' namespace='##targetNamespace'"
	 * @generated
	 */
	AdapterType getAdapterType();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getAdapterType <em>Adapter Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adapter Type</em>' containment reference.
	 * @see #getAdapterType()
	 * @generated
	 */
	void setAdapterType(AdapterType value);

	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Algorithm</em>' containment reference.
	 * @see #setAlgorithm(Algorithm)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Algorithm()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Algorithm' namespace='##targetNamespace'"
	 * @generated
	 */
	Algorithm getAlgorithm();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getAlgorithm <em>Algorithm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm</em>' containment reference.
	 * @see #getAlgorithm()
	 * @generated
	 */
	void setAlgorithm(Algorithm value);

	/**
	 * Returns the value of the '<em><b>Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * System element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application</em>' containment reference.
	 * @see #setApplication(Application)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Application()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Application' namespace='##targetNamespace'"
	 * @generated
	 */
	Application getApplication();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getApplication <em>Application</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application</em>' containment reference.
	 * @see #getApplication()
	 * @generated
	 */
	void setApplication(Application value);

	/**
	 * Returns the value of the '<em><b>Basic FB</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Basic FB</em>' containment reference.
	 * @see #setBasicFB(BasicFB)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_BasicFB()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='BasicFB' namespace='##targetNamespace'"
	 * @generated
	 */
	BasicFB getBasicFB();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getBasicFB <em>Basic FB</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basic FB</em>' containment reference.
	 * @see #getBasicFB()
	 * @generated
	 */
	void setBasicFB(BasicFB value);

	/**
	 * Returns the value of the '<em><b>Compiler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Comment element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Compiler</em>' containment reference.
	 * @see #setCompiler(de.cau.cs.kieler.functionblock.Compiler)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Compiler()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Compiler' namespace='##targetNamespace'"
	 * @generated
	 */
	de.cau.cs.kieler.functionblock.Compiler getCompiler();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getCompiler <em>Compiler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compiler</em>' containment reference.
	 * @see #getCompiler()
	 * @generated
	 */
	void setCompiler(de.cau.cs.kieler.functionblock.Compiler value);

	/**
	 * Returns the value of the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Comment element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Compiler Info</em>' containment reference.
	 * @see #setCompilerInfo(CompilerInfo)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_CompilerInfo()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='CompilerInfo' namespace='##targetNamespace'"
	 * @generated
	 */
	CompilerInfo getCompilerInfo();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getCompilerInfo <em>Compiler Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compiler Info</em>' containment reference.
	 * @see #getCompilerInfo()
	 * @generated
	 */
	void setCompilerInfo(CompilerInfo value);

	/**
	 * Returns the value of the '<em><b>Connection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Common element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connection</em>' containment reference.
	 * @see #setConnection(Connection)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Connection()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Connection' namespace='##targetNamespace'"
	 * @generated
	 */
	Connection getConnection();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getConnection <em>Connection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection</em>' containment reference.
	 * @see #getConnection()
	 * @generated
	 */
	void setConnection(Connection value);

	/**
	 * Returns the value of the '<em><b>Data Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Common element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Data Connections</em>' containment reference.
	 * @see #setDataConnections(DataConnections)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_DataConnections()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='DataConnections' namespace='##targetNamespace'"
	 * @generated
	 */
	DataConnections getDataConnections();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getDataConnections <em>Data Connections</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Connections</em>' containment reference.
	 * @see #getDataConnections()
	 * @generated
	 */
	void setDataConnections(DataConnections value);

	/**
	 * Returns the value of the '<em><b>Device</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * System element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Device</em>' containment reference.
	 * @see #setDevice(Device)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Device()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Device' namespace='##targetNamespace'"
	 * @generated
	 */
	Device getDevice();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getDevice <em>Device</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device</em>' containment reference.
	 * @see #getDevice()
	 * @generated
	 */
	void setDevice(Device value);

	/**
	 * Returns the value of the '<em><b>Device Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * DeviceType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Device Type</em>' containment reference.
	 * @see #setDeviceType(DeviceType)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_DeviceType()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='DeviceType' namespace='##targetNamespace'"
	 * @generated
	 */
	DeviceType getDeviceType();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getDeviceType <em>Device Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device Type</em>' containment reference.
	 * @see #getDeviceType()
	 * @generated
	 */
	void setDeviceType(DeviceType value);

	/**
	 * Returns the value of the '<em><b>EC Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EC Action</em>' containment reference.
	 * @see #setECAction(ECAction)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_ECAction()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ECAction' namespace='##targetNamespace'"
	 * @generated
	 */
	ECAction getECAction();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getECAction <em>EC Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EC Action</em>' containment reference.
	 * @see #getECAction()
	 * @generated
	 */
	void setECAction(ECAction value);

	/**
	 * Returns the value of the '<em><b>ECC</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>ECC</em>' containment reference.
	 * @see #setECC(ECC)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_ECC()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ECC' namespace='##targetNamespace'"
	 * @generated
	 */
	ECC getECC();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getECC <em>ECC</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ECC</em>' containment reference.
	 * @see #getECC()
	 * @generated
	 */
	void setECC(ECC value);

	/**
	 * Returns the value of the '<em><b>EC State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EC State</em>' containment reference.
	 * @see #setECState(ECState)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_ECState()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ECState' namespace='##targetNamespace'"
	 * @generated
	 */
	ECState getECState();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getECState <em>EC State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EC State</em>' containment reference.
	 * @see #getECState()
	 * @generated
	 */
	void setECState(ECState value);

	/**
	 * Returns the value of the '<em><b>EC Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EC Transition</em>' containment reference.
	 * @see #setECTransition(ECTransition)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_ECTransition()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ECTransition' namespace='##targetNamespace'"
	 * @generated
	 */
	ECTransition getECTransition();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getECTransition <em>EC Transition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EC Transition</em>' containment reference.
	 * @see #getECTransition()
	 * @generated
	 */
	void setECTransition(ECTransition value);

	/**
	 * Returns the value of the '<em><b>Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Event</em>' containment reference.
	 * @see #setEvent(Event)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Event()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Event' namespace='##targetNamespace'"
	 * @generated
	 */
	Event getEvent();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getEvent <em>Event</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' containment reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(Event value);

	/**
	 * Returns the value of the '<em><b>Event Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Common element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Event Connections</em>' containment reference.
	 * @see #setEventConnections(EventConnections)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_EventConnections()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='EventConnections' namespace='##targetNamespace'"
	 * @generated
	 */
	EventConnections getEventConnections();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getEventConnections <em>Event Connections</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Connections</em>' containment reference.
	 * @see #getEventConnections()
	 * @generated
	 */
	void setEventConnections(EventConnections value);

	/**
	 * Returns the value of the '<em><b>Event Inputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Event Inputs</em>' containment reference.
	 * @see #setEventInputs(EventInputs)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_EventInputs()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='EventInputs' namespace='##targetNamespace'"
	 * @generated
	 */
	EventInputs getEventInputs();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getEventInputs <em>Event Inputs</em>}' containment reference.
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
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_EventOutputs()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='EventOutputs' namespace='##targetNamespace'"
	 * @generated
	 */
	EventOutputs getEventOutputs();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getEventOutputs <em>Event Outputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Outputs</em>' containment reference.
	 * @see #getEventOutputs()
	 * @generated
	 */
	void setEventOutputs(EventOutputs value);

	/**
	 * Returns the value of the '<em><b>FB</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Common element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>FB</em>' containment reference.
	 * @see #setFB(FB)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_FB()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='FB' namespace='##targetNamespace'"
	 * @generated
	 */
	FB getFB();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getFB <em>FB</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FB</em>' containment reference.
	 * @see #getFB()
	 * @generated
	 */
	void setFB(FB value);

	/**
	 * Returns the value of the '<em><b>FBD</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>FBD</em>' containment reference.
	 * @see #setFBD(FBD)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_FBD()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='FBD' namespace='##targetNamespace'"
	 * @generated
	 */
	FBD getFBD();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getFBD <em>FBD</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FBD</em>' containment reference.
	 * @see #getFBD()
	 * @generated
	 */
	void setFBD(FBD value);

	/**
	 * Returns the value of the '<em><b>FB Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Common element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>FB Network</em>' containment reference.
	 * @see #setFBNetwork(FBNetwork)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_FBNetwork()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='FBNetwork' namespace='##targetNamespace'"
	 * @generated
	 */
	FBNetwork getFBNetwork();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getFBNetwork <em>FB Network</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FB Network</em>' containment reference.
	 * @see #getFBNetwork()
	 * @generated
	 */
	void setFBNetwork(FBNetwork value);

	/**
	 * Returns the value of the '<em><b>FB Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>FB Type</em>' containment reference.
	 * @see #setFBType(FBType)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_FBType()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='FBType' namespace='##targetNamespace'"
	 * @generated
	 */
	FBType getFBType();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getFBType <em>FB Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FB Type</em>' containment reference.
	 * @see #getFBType()
	 * @generated
	 */
	void setFBType(FBType value);

	/**
	 * Returns the value of the '<em><b>FB Type Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ResourceType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>FB Type Name</em>' containment reference.
	 * @see #setFBTypeName(FBTypeName)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_FBTypeName()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='FBTypeName' namespace='##targetNamespace'"
	 * @generated
	 */
	FBTypeName getFBTypeName();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getFBTypeName <em>FB Type Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FB Type Name</em>' containment reference.
	 * @see #getFBTypeName()
	 * @generated
	 */
	void setFBTypeName(FBTypeName value);

	/**
	 * Returns the value of the '<em><b>HCECC</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>HCECC</em>' containment reference.
	 * @see #setHCECC(HCECC)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_HCECC()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='HCECC' namespace='##targetNamespace'"
	 * @generated
	 */
	HCECC getHCECC();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getHCECC <em>HCECC</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>HCECC</em>' containment reference.
	 * @see #getHCECC()
	 * @generated
	 */
	void setHCECC(HCECC value);

	/**
	 * Returns the value of the '<em><b>HCECC Relation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>HCECC Relation</em>' containment reference.
	 * @see #setHCECCRelation(HCECCRelation)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_HCECCRelation()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='HCECCRelation' namespace='##targetNamespace'"
	 * @generated
	 */
	HCECCRelation getHCECCRelation();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getHCECCRelation <em>HCECC Relation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>HCECC Relation</em>' containment reference.
	 * @see #getHCECCRelation()
	 * @generated
	 */
	void setHCECCRelation(HCECCRelation value);

	/**
	 * Returns the value of the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Comment element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Identification</em>' containment reference.
	 * @see #setIdentification(Identification)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Identification()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Identification' namespace='##targetNamespace'"
	 * @generated
	 */
	Identification getIdentification();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getIdentification <em>Identification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identification</em>' containment reference.
	 * @see #getIdentification()
	 * @generated
	 */
	void setIdentification(Identification value);

	/**
	 * Returns the value of the '<em><b>Input Primitive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input Primitive</em>' containment reference.
	 * @see #setInputPrimitive(InputPrimitive)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_InputPrimitive()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='InputPrimitive' namespace='##targetNamespace'"
	 * @generated
	 */
	InputPrimitive getInputPrimitive();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getInputPrimitive <em>Input Primitive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Primitive</em>' containment reference.
	 * @see #getInputPrimitive()
	 * @generated
	 */
	void setInputPrimitive(InputPrimitive value);

	/**
	 * Returns the value of the '<em><b>Input Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input Vars</em>' containment reference.
	 * @see #setInputVars(InputVars)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_InputVars()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='InputVars' namespace='##targetNamespace'"
	 * @generated
	 */
	InputVars getInputVars();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getInputVars <em>Input Vars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Vars</em>' containment reference.
	 * @see #getInputVars()
	 * @generated
	 */
	void setInputVars(InputVars value);

	/**
	 * Returns the value of the '<em><b>Interface List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interface List</em>' containment reference.
	 * @see #setInterfaceList(InterfaceList)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_InterfaceList()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='InterfaceList' namespace='##targetNamespace'"
	 * @generated
	 */
	InterfaceList getInterfaceList();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getInterfaceList <em>Interface List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface List</em>' containment reference.
	 * @see #getInterfaceList()
	 * @generated
	 */
	void setInterfaceList(InterfaceList value);

	/**
	 * Returns the value of the '<em><b>Internal Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Internal Vars</em>' containment reference.
	 * @see #setInternalVars(InternalVars)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_InternalVars()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='InternalVars' namespace='##targetNamespace'"
	 * @generated
	 */
	InternalVars getInternalVars();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getInternalVars <em>Internal Vars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Vars</em>' containment reference.
	 * @see #getInternalVars()
	 * @generated
	 */
	void setInternalVars(InternalVars value);

	/**
	 * Returns the value of the '<em><b>LD</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>LD</em>' containment reference.
	 * @see #setLD(LD)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_LD()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='LD' namespace='##targetNamespace'"
	 * @generated
	 */
	LD getLD();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getLD <em>LD</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LD</em>' containment reference.
	 * @see #getLD()
	 * @generated
	 */
	void setLD(LD value);

	/**
	 * Returns the value of the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Network element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Link</em>' containment reference.
	 * @see #setLink(Link)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Link()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Link' namespace='##targetNamespace'"
	 * @generated
	 */
	Link getLink();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getLink <em>Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link</em>' containment reference.
	 * @see #getLink()
	 * @generated
	 */
	void setLink(Link value);

	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * System element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mapping</em>' containment reference.
	 * @see #setMapping(Mapping)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Mapping()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Mapping' namespace='##targetNamespace'"
	 * @generated
	 */
	Mapping getMapping();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getMapping <em>Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' containment reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(Mapping value);

	/**
	 * Returns the value of the '<em><b>Other</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Other</em>' containment reference.
	 * @see #setOther(Other)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Other()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Other' namespace='##targetNamespace'"
	 * @generated
	 */
	Other getOther();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getOther <em>Other</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other</em>' containment reference.
	 * @see #getOther()
	 * @generated
	 */
	void setOther(Other value);

	/**
	 * Returns the value of the '<em><b>Output Primitive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output Primitive</em>' containment reference.
	 * @see #setOutputPrimitive(OutputPrimitive)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_OutputPrimitive()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='OutputPrimitive' namespace='##targetNamespace'"
	 * @generated
	 */
	OutputPrimitive getOutputPrimitive();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getOutputPrimitive <em>Output Primitive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Primitive</em>' containment reference.
	 * @see #getOutputPrimitive()
	 * @generated
	 */
	void setOutputPrimitive(OutputPrimitive value);

	/**
	 * Returns the value of the '<em><b>Output Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output Vars</em>' containment reference.
	 * @see #setOutputVars(OutputVars)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_OutputVars()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='OutputVars' namespace='##targetNamespace'"
	 * @generated
	 */
	OutputVars getOutputVars();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getOutputVars <em>Output Vars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Vars</em>' containment reference.
	 * @see #getOutputVars()
	 * @generated
	 */
	void setOutputVars(OutputVars value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Network element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference.
	 * @see #setParameter(Parameter)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Parameter()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Parameter' namespace='##targetNamespace'"
	 * @generated
	 */
	Parameter getParameter();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getParameter <em>Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' containment reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Plugs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Plugs</em>' containment reference.
	 * @see #setPlugs(Plugs)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Plugs()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Plugs' namespace='##targetNamespace'"
	 * @generated
	 */
	Plugs getPlugs();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getPlugs <em>Plugs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugs</em>' containment reference.
	 * @see #getPlugs()
	 * @generated
	 */
	void setPlugs(Plugs value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * DeviceType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource</em>' containment reference.
	 * @see #setResource(Resource)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Resource()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Resource' namespace='##targetNamespace'"
	 * @generated
	 */
	Resource getResource();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getResource <em>Resource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' containment reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(Resource value);

	/**
	 * Returns the value of the '<em><b>Resource Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ResourceType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource Type</em>' containment reference.
	 * @see #setResourceType(ResourceType)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_ResourceType()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ResourceType' namespace='##targetNamespace'"
	 * @generated
	 */
	ResourceType getResourceType();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getResourceType <em>Resource Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Type</em>' containment reference.
	 * @see #getResourceType()
	 * @generated
	 */
	void setResourceType(ResourceType value);

	/**
	 * Returns the value of the '<em><b>Resource Type Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * DeviceType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource Type Name</em>' containment reference.
	 * @see #setResourceTypeName(ResourceTypeName)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_ResourceTypeName()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ResourceTypeName' namespace='##targetNamespace'"
	 * @generated
	 */
	ResourceTypeName getResourceTypeName();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getResourceTypeName <em>Resource Type Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Type Name</em>' containment reference.
	 * @see #getResourceTypeName()
	 * @generated
	 */
	void setResourceTypeName(ResourceTypeName value);

	/**
	 * Returns the value of the '<em><b>Rung</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rung</em>' containment reference.
	 * @see #setRung(Rung)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Rung()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Rung' namespace='##targetNamespace'"
	 * @generated
	 */
	Rung getRung();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getRung <em>Rung</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rung</em>' containment reference.
	 * @see #getRung()
	 * @generated
	 */
	void setRung(Rung value);

	/**
	 * Returns the value of the '<em><b>Segment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Network element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Segment</em>' containment reference.
	 * @see #setSegment(Segment)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Segment()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Segment' namespace='##targetNamespace'"
	 * @generated
	 */
	Segment getSegment();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSegment <em>Segment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Segment</em>' containment reference.
	 * @see #getSegment()
	 * @generated
	 */
	void setSegment(Segment value);

	/**
	 * Returns the value of the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service</em>' containment reference.
	 * @see #setService(Service)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Service()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Service' namespace='##targetNamespace'"
	 * @generated
	 */
	Service getService();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getService <em>Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' containment reference.
	 * @see #getService()
	 * @generated
	 */
	void setService(Service value);

	/**
	 * Returns the value of the '<em><b>Service Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Sequence</em>' containment reference.
	 * @see #setServiceSequence(ServiceSequence)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_ServiceSequence()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ServiceSequence' namespace='##targetNamespace'"
	 * @generated
	 */
	ServiceSequence getServiceSequence();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getServiceSequence <em>Service Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Sequence</em>' containment reference.
	 * @see #getServiceSequence()
	 * @generated
	 */
	void setServiceSequence(ServiceSequence value);

	/**
	 * Returns the value of the '<em><b>Service Transaction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Transaction</em>' containment reference.
	 * @see #setServiceTransaction(ServiceTransaction)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_ServiceTransaction()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ServiceTransaction' namespace='##targetNamespace'"
	 * @generated
	 */
	ServiceTransaction getServiceTransaction();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getServiceTransaction <em>Service Transaction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Transaction</em>' containment reference.
	 * @see #getServiceTransaction()
	 * @generated
	 */
	void setServiceTransaction(ServiceTransaction value);

	/**
	 * Returns the value of the '<em><b>Sockets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sockets</em>' containment reference.
	 * @see #setSockets(Sockets)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_Sockets()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Sockets' namespace='##targetNamespace'"
	 * @generated
	 */
	Sockets getSockets();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSockets <em>Sockets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sockets</em>' containment reference.
	 * @see #getSockets()
	 * @generated
	 */
	void setSockets(Sockets value);

	/**
	 * Returns the value of the '<em><b>ST</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>ST</em>' containment reference.
	 * @see #setST(ST)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_ST()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ST' namespace='##targetNamespace'"
	 * @generated
	 */
	ST getST();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getST <em>ST</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ST</em>' containment reference.
	 * @see #getST()
	 * @generated
	 */
	void setST(ST value);

	/**
	 * Returns the value of the '<em><b>Sub App</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SubAppType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub App</em>' containment reference.
	 * @see #setSubApp(SubApp)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_SubApp()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SubApp' namespace='##targetNamespace'"
	 * @generated
	 */
	SubApp getSubApp();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubApp <em>Sub App</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub App</em>' containment reference.
	 * @see #getSubApp()
	 * @generated
	 */
	void setSubApp(SubApp value);

	/**
	 * Returns the value of the '<em><b>Sub App Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SubAppType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub App Event</em>' containment reference.
	 * @see #setSubAppEvent(SubAppEvent)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_SubAppEvent()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SubAppEvent' namespace='##targetNamespace'"
	 * @generated
	 */
	SubAppEvent getSubAppEvent();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppEvent <em>Sub App Event</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub App Event</em>' containment reference.
	 * @see #getSubAppEvent()
	 * @generated
	 */
	void setSubAppEvent(SubAppEvent value);

	/**
	 * Returns the value of the '<em><b>Sub App Event Inputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SubAppType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub App Event Inputs</em>' containment reference.
	 * @see #setSubAppEventInputs(SubAppEventInputs)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_SubAppEventInputs()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SubAppEventInputs' namespace='##targetNamespace'"
	 * @generated
	 */
	SubAppEventInputs getSubAppEventInputs();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppEventInputs <em>Sub App Event Inputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub App Event Inputs</em>' containment reference.
	 * @see #getSubAppEventInputs()
	 * @generated
	 */
	void setSubAppEventInputs(SubAppEventInputs value);

	/**
	 * Returns the value of the '<em><b>Sub App Event Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SubAppType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub App Event Outputs</em>' containment reference.
	 * @see #setSubAppEventOutputs(SubAppEventOutputs)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_SubAppEventOutputs()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SubAppEventOutputs' namespace='##targetNamespace'"
	 * @generated
	 */
	SubAppEventOutputs getSubAppEventOutputs();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppEventOutputs <em>Sub App Event Outputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub App Event Outputs</em>' containment reference.
	 * @see #getSubAppEventOutputs()
	 * @generated
	 */
	void setSubAppEventOutputs(SubAppEventOutputs value);

	/**
	 * Returns the value of the '<em><b>Sub App Interface List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SubAppType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub App Interface List</em>' containment reference.
	 * @see #setSubAppInterfaceList(SubAppInterfaceList)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_SubAppInterfaceList()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SubAppInterfaceList' namespace='##targetNamespace'"
	 * @generated
	 */
	SubAppInterfaceList getSubAppInterfaceList();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppInterfaceList <em>Sub App Interface List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub App Interface List</em>' containment reference.
	 * @see #getSubAppInterfaceList()
	 * @generated
	 */
	void setSubAppInterfaceList(SubAppInterfaceList value);

	/**
	 * Returns the value of the '<em><b>Sub App Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SubAppType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub App Network</em>' containment reference.
	 * @see #setSubAppNetwork(SubAppNetwork)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_SubAppNetwork()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SubAppNetwork' namespace='##targetNamespace'"
	 * @generated
	 */
	SubAppNetwork getSubAppNetwork();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppNetwork <em>Sub App Network</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub App Network</em>' containment reference.
	 * @see #getSubAppNetwork()
	 * @generated
	 */
	void setSubAppNetwork(SubAppNetwork value);

	/**
	 * Returns the value of the '<em><b>Sub App Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SubAppType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub App Type</em>' containment reference.
	 * @see #setSubAppType(SubAppType)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_SubAppType()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SubAppType' namespace='##targetNamespace'"
	 * @generated
	 */
	SubAppType getSubAppType();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppType <em>Sub App Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub App Type</em>' containment reference.
	 * @see #getSubAppType()
	 * @generated
	 */
	void setSubAppType(SubAppType value);

	/**
	 * Returns the value of the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * System element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>System</em>' containment reference.
	 * @see #setSystem(de.cau.cs.kieler.functionblock.System)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_System()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='System' namespace='##targetNamespace'"
	 * @generated
	 */
	de.cau.cs.kieler.functionblock.System getSystem();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSystem <em>System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' containment reference.
	 * @see #getSystem()
	 * @generated
	 */
	void setSystem(de.cau.cs.kieler.functionblock.System value);

	/**
	 * Returns the value of the '<em><b>Var Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Var Declaration</em>' containment reference.
	 * @see #setVarDeclaration(VarDeclaration)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_VarDeclaration()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='VarDeclaration' namespace='##targetNamespace'"
	 * @generated
	 */
	VarDeclaration getVarDeclaration();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getVarDeclaration <em>Var Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Declaration</em>' containment reference.
	 * @see #getVarDeclaration()
	 * @generated
	 */
	void setVarDeclaration(VarDeclaration value);

	/**
	 * Returns the value of the '<em><b>Version Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Comment element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Version Info</em>' containment reference.
	 * @see #setVersionInfo(VersionInfo)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_VersionInfo()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='VersionInfo' namespace='##targetNamespace'"
	 * @generated
	 */
	VersionInfo getVersionInfo();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getVersionInfo <em>Version Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Info</em>' containment reference.
	 * @see #getVersionInfo()
	 * @generated
	 */
	void setVersionInfo(VersionInfo value);

	/**
	 * Returns the value of the '<em><b>With</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>With</em>' containment reference.
	 * @see #setWith(With)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getDocumentRoot_With()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='With' namespace='##targetNamespace'"
	 * @generated
	 */
	With getWith();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getWith <em>With</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>With</em>' containment reference.
	 * @see #getWith()
	 * @generated
	 */
	void setWith(With value);

} // DocumentRoot
