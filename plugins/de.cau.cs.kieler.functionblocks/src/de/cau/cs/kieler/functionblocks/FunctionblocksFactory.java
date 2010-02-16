/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage
 * @generated
 */
public interface FunctionblocksFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FunctionblocksFactory eINSTANCE = de.cau.cs.kieler.functionblocks.impl.FunctionblocksFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Adapter Connections</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Adapter Connections</em>'.
	 * @generated
	 */
	AdapterConnections createAdapterConnections();

	/**
	 * Returns a new object of class '<em>Adapter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Adapter Declaration</em>'.
	 * @generated
	 */
	AdapterDeclaration createAdapterDeclaration();

	/**
	 * Returns a new object of class '<em>Adapter Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Adapter Type</em>'.
	 * @generated
	 */
	AdapterType createAdapterType();

	/**
	 * Returns a new object of class '<em>Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Algorithm</em>'.
	 * @generated
	 */
	Algorithm createAlgorithm();

	/**
	 * Returns a new object of class '<em>Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application</em>'.
	 * @generated
	 */
	Application createApplication();

	/**
	 * Returns a new object of class '<em>Basic FB</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic FB</em>'.
	 * @generated
	 */
	BasicFB createBasicFB();

	/**
	 * Returns a new object of class '<em>Compiler Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compiler Info</em>'.
	 * @generated
	 */
	CompilerInfo createCompilerInfo();

	/**
	 * Returns a new object of class '<em>Compiler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compiler</em>'.
	 * @generated
	 */
	Compiler createCompiler();

	/**
	 * Returns a new object of class '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection</em>'.
	 * @generated
	 */
	Connection createConnection();

	/**
	 * Returns a new object of class '<em>Data Connections</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Connections</em>'.
	 * @generated
	 */
	DataConnections createDataConnections();

	/**
	 * Returns a new object of class '<em>Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device</em>'.
	 * @generated
	 */
	Device createDevice();

	/**
	 * Returns a new object of class '<em>Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device Type</em>'.
	 * @generated
	 */
	DeviceType createDeviceType();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>EC Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EC Action</em>'.
	 * @generated
	 */
	ECAction createECAction();

	/**
	 * Returns a new object of class '<em>ECC</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ECC</em>'.
	 * @generated
	 */
	ECC createECC();

	/**
	 * Returns a new object of class '<em>EC State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EC State</em>'.
	 * @generated
	 */
	ECState createECState();

	/**
	 * Returns a new object of class '<em>EC Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EC Transition</em>'.
	 * @generated
	 */
	ECTransition createECTransition();

	/**
	 * Returns a new object of class '<em>Event Connections</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Connections</em>'.
	 * @generated
	 */
	EventConnections createEventConnections();

	/**
	 * Returns a new object of class '<em>Event Inputs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Inputs</em>'.
	 * @generated
	 */
	EventInputs createEventInputs();

	/**
	 * Returns a new object of class '<em>Event Outputs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Outputs</em>'.
	 * @generated
	 */
	EventOutputs createEventOutputs();

	/**
	 * Returns a new object of class '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event</em>'.
	 * @generated
	 */
	Event createEvent();

	/**
	 * Returns a new object of class '<em>FBD</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FBD</em>'.
	 * @generated
	 */
	FBD createFBD();

	/**
	 * Returns a new object of class '<em>FB Network</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FB Network</em>'.
	 * @generated
	 */
	FBNetwork createFBNetwork();

	/**
	 * Returns a new object of class '<em>FB</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FB</em>'.
	 * @generated
	 */
	FB createFB();

	/**
	 * Returns a new object of class '<em>FB Type Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FB Type Name</em>'.
	 * @generated
	 */
	FBTypeName createFBTypeName();

	/**
	 * Returns a new object of class '<em>FB Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FB Type</em>'.
	 * @generated
	 */
	FBType createFBType();

	/**
	 * Returns a new object of class '<em>HCECC Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HCECC Relation</em>'.
	 * @generated
	 */
	HCECCRelation createHCECCRelation();

	/**
	 * Returns a new object of class '<em>HCECC</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HCECC</em>'.
	 * @generated
	 */
	HCECC createHCECC();

	/**
	 * Returns a new object of class '<em>Identification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identification</em>'.
	 * @generated
	 */
	Identification createIdentification();

	/**
	 * Returns a new object of class '<em>Input Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Primitive</em>'.
	 * @generated
	 */
	InputPrimitive createInputPrimitive();

	/**
	 * Returns a new object of class '<em>Input Vars</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Vars</em>'.
	 * @generated
	 */
	InputVars createInputVars();

	/**
	 * Returns a new object of class '<em>Interface List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface List</em>'.
	 * @generated
	 */
	InterfaceList createInterfaceList();

	/**
	 * Returns a new object of class '<em>Internal Vars</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Vars</em>'.
	 * @generated
	 */
	InternalVars createInternalVars();

	/**
	 * Returns a new object of class '<em>LD</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>LD</em>'.
	 * @generated
	 */
	LD createLD();

	/**
	 * Returns a new object of class '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link</em>'.
	 * @generated
	 */
	Link createLink();

	/**
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	Mapping createMapping();

	/**
	 * Returns a new object of class '<em>Other</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Other</em>'.
	 * @generated
	 */
	Other createOther();

	/**
	 * Returns a new object of class '<em>Output Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Primitive</em>'.
	 * @generated
	 */
	OutputPrimitive createOutputPrimitive();

	/**
	 * Returns a new object of class '<em>Output Vars</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Vars</em>'.
	 * @generated
	 */
	OutputVars createOutputVars();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Plugs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plugs</em>'.
	 * @generated
	 */
	Plugs createPlugs();

	/**
	 * Returns a new object of class '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource</em>'.
	 * @generated
	 */
	Resource createResource();

	/**
	 * Returns a new object of class '<em>Resource Type Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Type Name</em>'.
	 * @generated
	 */
	ResourceTypeName createResourceTypeName();

	/**
	 * Returns a new object of class '<em>Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Type</em>'.
	 * @generated
	 */
	ResourceType createResourceType();

	/**
	 * Returns a new object of class '<em>Rung</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rung</em>'.
	 * @generated
	 */
	Rung createRung();

	/**
	 * Returns a new object of class '<em>Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Segment</em>'.
	 * @generated
	 */
	Segment createSegment();

	/**
	 * Returns a new object of class '<em>Service Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Sequence</em>'.
	 * @generated
	 */
	ServiceSequence createServiceSequence();

	/**
	 * Returns a new object of class '<em>Service Transaction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Transaction</em>'.
	 * @generated
	 */
	ServiceTransaction createServiceTransaction();

	/**
	 * Returns a new object of class '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service</em>'.
	 * @generated
	 */
	Service createService();

	/**
	 * Returns a new object of class '<em>Sockets</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sockets</em>'.
	 * @generated
	 */
	Sockets createSockets();

	/**
	 * Returns a new object of class '<em>ST</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ST</em>'.
	 * @generated
	 */
	ST createST();

	/**
	 * Returns a new object of class '<em>Sub App Event Inputs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub App Event Inputs</em>'.
	 * @generated
	 */
	SubAppEventInputs createSubAppEventInputs();

	/**
	 * Returns a new object of class '<em>Sub App Event Outputs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub App Event Outputs</em>'.
	 * @generated
	 */
	SubAppEventOutputs createSubAppEventOutputs();

	/**
	 * Returns a new object of class '<em>Sub App Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub App Event</em>'.
	 * @generated
	 */
	SubAppEvent createSubAppEvent();

	/**
	 * Returns a new object of class '<em>Sub App Interface List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub App Interface List</em>'.
	 * @generated
	 */
	SubAppInterfaceList createSubAppInterfaceList();

	/**
	 * Returns a new object of class '<em>Sub App Network</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub App Network</em>'.
	 * @generated
	 */
	SubAppNetwork createSubAppNetwork();

	/**
	 * Returns a new object of class '<em>Sub App</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub App</em>'.
	 * @generated
	 */
	SubApp createSubApp();

	/**
	 * Returns a new object of class '<em>Sub App Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub App Type</em>'.
	 * @generated
	 */
	SubAppType createSubAppType();

	/**
	 * Returns a new object of class '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System</em>'.
	 * @generated
	 */
	System createSystem();

	/**
	 * Returns a new object of class '<em>Var Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var Declaration</em>'.
	 * @generated
	 */
	VarDeclaration createVarDeclaration();

	/**
	 * Returns a new object of class '<em>Version Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Version Info</em>'.
	 * @generated
	 */
	VersionInfo createVersionInfo();

	/**
	 * Returns a new object of class '<em>With</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>With</em>'.
	 * @generated
	 */
	With createWith();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FunctionblocksPackage getFunctionblocksPackage();

} //FunctionblocksFactory
