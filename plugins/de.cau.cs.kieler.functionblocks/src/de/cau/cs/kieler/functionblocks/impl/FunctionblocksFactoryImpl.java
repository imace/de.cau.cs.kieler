/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks.impl;

import de.cau.cs.kieler.functionblocks.AdapterConnections;
import de.cau.cs.kieler.functionblocks.AdapterDeclaration;
import de.cau.cs.kieler.functionblocks.AdapterType;
import de.cau.cs.kieler.functionblocks.Algorithm;
import de.cau.cs.kieler.functionblocks.Application;
import de.cau.cs.kieler.functionblocks.BasicFB;
import de.cau.cs.kieler.functionblocks.CompilerInfo;
import de.cau.cs.kieler.functionblocks.Connection;
import de.cau.cs.kieler.functionblocks.DataConnections;
import de.cau.cs.kieler.functionblocks.Device;
import de.cau.cs.kieler.functionblocks.DeviceType;
import de.cau.cs.kieler.functionblocks.DocumentRoot;
import de.cau.cs.kieler.functionblocks.ECAction;
import de.cau.cs.kieler.functionblocks.ECC;
import de.cau.cs.kieler.functionblocks.ECState;
import de.cau.cs.kieler.functionblocks.ECTransition;
import de.cau.cs.kieler.functionblocks.Event;
import de.cau.cs.kieler.functionblocks.EventConnections;
import de.cau.cs.kieler.functionblocks.EventInputs;
import de.cau.cs.kieler.functionblocks.EventOutputs;
import de.cau.cs.kieler.functionblocks.FB;
import de.cau.cs.kieler.functionblocks.FBD;
import de.cau.cs.kieler.functionblocks.FBNetwork;
import de.cau.cs.kieler.functionblocks.FBType;
import de.cau.cs.kieler.functionblocks.FBTypeName;
import de.cau.cs.kieler.functionblocks.FunctionblocksFactory;
import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;
import de.cau.cs.kieler.functionblocks.HCECC;
import de.cau.cs.kieler.functionblocks.HCECCRelation;
import de.cau.cs.kieler.functionblocks.Identification;
import de.cau.cs.kieler.functionblocks.InputPrimitive;
import de.cau.cs.kieler.functionblocks.InputVars;
import de.cau.cs.kieler.functionblocks.InterfaceList;
import de.cau.cs.kieler.functionblocks.InternalVars;
import de.cau.cs.kieler.functionblocks.LD;
import de.cau.cs.kieler.functionblocks.Language;
import de.cau.cs.kieler.functionblocks.Link;
import de.cau.cs.kieler.functionblocks.Mapping;
import de.cau.cs.kieler.functionblocks.Other;
import de.cau.cs.kieler.functionblocks.OutputPrimitive;
import de.cau.cs.kieler.functionblocks.OutputVars;
import de.cau.cs.kieler.functionblocks.Parameter;
import de.cau.cs.kieler.functionblocks.Plugs;
import de.cau.cs.kieler.functionblocks.Resource;
import de.cau.cs.kieler.functionblocks.ResourceType;
import de.cau.cs.kieler.functionblocks.ResourceTypeName;
import de.cau.cs.kieler.functionblocks.Rung;
import de.cau.cs.kieler.functionblocks.ST;
import de.cau.cs.kieler.functionblocks.Segment;
import de.cau.cs.kieler.functionblocks.Service;
import de.cau.cs.kieler.functionblocks.ServiceSequence;
import de.cau.cs.kieler.functionblocks.ServiceTransaction;
import de.cau.cs.kieler.functionblocks.Sockets;
import de.cau.cs.kieler.functionblocks.SubApp;
import de.cau.cs.kieler.functionblocks.SubAppEvent;
import de.cau.cs.kieler.functionblocks.SubAppEventInputs;
import de.cau.cs.kieler.functionblocks.SubAppEventOutputs;
import de.cau.cs.kieler.functionblocks.SubAppInterfaceList;
import de.cau.cs.kieler.functionblocks.SubAppNetwork;
import de.cau.cs.kieler.functionblocks.SubAppType;
import de.cau.cs.kieler.functionblocks.VarDeclaration;
import de.cau.cs.kieler.functionblocks.VersionInfo;
import de.cau.cs.kieler.functionblocks.With;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionblocksFactoryImpl extends EFactoryImpl implements FunctionblocksFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FunctionblocksFactory init() {
		try {
			FunctionblocksFactory theFunctionblocksFactory = (FunctionblocksFactory)EPackage.Registry.INSTANCE.getEFactory("http://kieler.cs.cau.de/functionblocks/"); 
			if (theFunctionblocksFactory != null) {
				return theFunctionblocksFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FunctionblocksFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionblocksFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FunctionblocksPackage.ADAPTER_CONNECTIONS: return createAdapterConnections();
			case FunctionblocksPackage.ADAPTER_DECLARATION: return createAdapterDeclaration();
			case FunctionblocksPackage.ADAPTER_TYPE: return createAdapterType();
			case FunctionblocksPackage.ALGORITHM: return createAlgorithm();
			case FunctionblocksPackage.APPLICATION: return createApplication();
			case FunctionblocksPackage.BASIC_FB: return createBasicFB();
			case FunctionblocksPackage.COMPILER_INFO: return createCompilerInfo();
			case FunctionblocksPackage.COMPILER: return createCompiler();
			case FunctionblocksPackage.CONNECTION: return createConnection();
			case FunctionblocksPackage.DATA_CONNECTIONS: return createDataConnections();
			case FunctionblocksPackage.DEVICE: return createDevice();
			case FunctionblocksPackage.DEVICE_TYPE: return createDeviceType();
			case FunctionblocksPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case FunctionblocksPackage.EC_ACTION: return createECAction();
			case FunctionblocksPackage.ECC: return createECC();
			case FunctionblocksPackage.EC_STATE: return createECState();
			case FunctionblocksPackage.EC_TRANSITION: return createECTransition();
			case FunctionblocksPackage.EVENT_CONNECTIONS: return createEventConnections();
			case FunctionblocksPackage.EVENT_INPUTS: return createEventInputs();
			case FunctionblocksPackage.EVENT_OUTPUTS: return createEventOutputs();
			case FunctionblocksPackage.EVENT: return createEvent();
			case FunctionblocksPackage.FBD: return createFBD();
			case FunctionblocksPackage.FB_NETWORK: return createFBNetwork();
			case FunctionblocksPackage.FB: return createFB();
			case FunctionblocksPackage.FB_TYPE_NAME: return createFBTypeName();
			case FunctionblocksPackage.FB_TYPE: return createFBType();
			case FunctionblocksPackage.HCECC_RELATION: return createHCECCRelation();
			case FunctionblocksPackage.HCECC: return createHCECC();
			case FunctionblocksPackage.IDENTIFICATION: return createIdentification();
			case FunctionblocksPackage.INPUT_PRIMITIVE: return createInputPrimitive();
			case FunctionblocksPackage.INPUT_VARS: return createInputVars();
			case FunctionblocksPackage.INTERFACE_LIST: return createInterfaceList();
			case FunctionblocksPackage.INTERNAL_VARS: return createInternalVars();
			case FunctionblocksPackage.LD: return createLD();
			case FunctionblocksPackage.LINK: return createLink();
			case FunctionblocksPackage.MAPPING: return createMapping();
			case FunctionblocksPackage.OTHER: return createOther();
			case FunctionblocksPackage.OUTPUT_PRIMITIVE: return createOutputPrimitive();
			case FunctionblocksPackage.OUTPUT_VARS: return createOutputVars();
			case FunctionblocksPackage.PARAMETER: return createParameter();
			case FunctionblocksPackage.PLUGS: return createPlugs();
			case FunctionblocksPackage.RESOURCE: return createResource();
			case FunctionblocksPackage.RESOURCE_TYPE_NAME: return createResourceTypeName();
			case FunctionblocksPackage.RESOURCE_TYPE: return createResourceType();
			case FunctionblocksPackage.RUNG: return createRung();
			case FunctionblocksPackage.SEGMENT: return createSegment();
			case FunctionblocksPackage.SERVICE_SEQUENCE: return createServiceSequence();
			case FunctionblocksPackage.SERVICE_TRANSACTION: return createServiceTransaction();
			case FunctionblocksPackage.SERVICE: return createService();
			case FunctionblocksPackage.SOCKETS: return createSockets();
			case FunctionblocksPackage.ST: return createST();
			case FunctionblocksPackage.SUB_APP_EVENT_INPUTS: return createSubAppEventInputs();
			case FunctionblocksPackage.SUB_APP_EVENT_OUTPUTS: return createSubAppEventOutputs();
			case FunctionblocksPackage.SUB_APP_EVENT: return createSubAppEvent();
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST: return createSubAppInterfaceList();
			case FunctionblocksPackage.SUB_APP_NETWORK: return createSubAppNetwork();
			case FunctionblocksPackage.SUB_APP: return createSubApp();
			case FunctionblocksPackage.SUB_APP_TYPE: return createSubAppType();
			case FunctionblocksPackage.SYSTEM: return createSystem();
			case FunctionblocksPackage.VAR_DECLARATION: return createVarDeclaration();
			case FunctionblocksPackage.VERSION_INFO: return createVersionInfo();
			case FunctionblocksPackage.WITH: return createWith();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case FunctionblocksPackage.LANGUAGE:
				return createLanguageFromString(eDataType, initialValue);
			case FunctionblocksPackage.LANGUAGE_OBJECT:
				return createLanguageObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case FunctionblocksPackage.LANGUAGE:
				return convertLanguageToString(eDataType, instanceValue);
			case FunctionblocksPackage.LANGUAGE_OBJECT:
				return convertLanguageObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterConnections createAdapterConnections() {
		AdapterConnectionsImpl adapterConnections = new AdapterConnectionsImpl();
		return adapterConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterDeclaration createAdapterDeclaration() {
		AdapterDeclarationImpl adapterDeclaration = new AdapterDeclarationImpl();
		return adapterDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterType createAdapterType() {
		AdapterTypeImpl adapterType = new AdapterTypeImpl();
		return adapterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Algorithm createAlgorithm() {
		AlgorithmImpl algorithm = new AlgorithmImpl();
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Application createApplication() {
		ApplicationImpl application = new ApplicationImpl();
		return application;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFB createBasicFB() {
		BasicFBImpl basicFB = new BasicFBImpl();
		return basicFB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompilerInfo createCompilerInfo() {
		CompilerInfoImpl compilerInfo = new CompilerInfoImpl();
		return compilerInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.cau.cs.kieler.functionblocks.Compiler createCompiler() {
		CompilerImpl compiler = new CompilerImpl();
		return compiler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection createConnection() {
		ConnectionImpl connection = new ConnectionImpl();
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataConnections createDataConnections() {
		DataConnectionsImpl dataConnections = new DataConnectionsImpl();
		return dataConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Device createDevice() {
		DeviceImpl device = new DeviceImpl();
		return device;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceType createDeviceType() {
		DeviceTypeImpl deviceType = new DeviceTypeImpl();
		return deviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECAction createECAction() {
		ECActionImpl ecAction = new ECActionImpl();
		return ecAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECC createECC() {
		ECCImpl ecc = new ECCImpl();
		return ecc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECState createECState() {
		ECStateImpl ecState = new ECStateImpl();
		return ecState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECTransition createECTransition() {
		ECTransitionImpl ecTransition = new ECTransitionImpl();
		return ecTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventConnections createEventConnections() {
		EventConnectionsImpl eventConnections = new EventConnectionsImpl();
		return eventConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventInputs createEventInputs() {
		EventInputsImpl eventInputs = new EventInputsImpl();
		return eventInputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventOutputs createEventOutputs() {
		EventOutputsImpl eventOutputs = new EventOutputsImpl();
		return eventOutputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBD createFBD() {
		FBDImpl fbd = new FBDImpl();
		return fbd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBNetwork createFBNetwork() {
		FBNetworkImpl fbNetwork = new FBNetworkImpl();
		return fbNetwork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FB createFB() {
		FBImpl fb = new FBImpl();
		return fb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBTypeName createFBTypeName() {
		FBTypeNameImpl fbTypeName = new FBTypeNameImpl();
		return fbTypeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBType createFBType() {
		FBTypeImpl fbType = new FBTypeImpl();
		return fbType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HCECCRelation createHCECCRelation() {
		HCECCRelationImpl hceccRelation = new HCECCRelationImpl();
		return hceccRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HCECC createHCECC() {
		HCECCImpl hcecc = new HCECCImpl();
		return hcecc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identification createIdentification() {
		IdentificationImpl identification = new IdentificationImpl();
		return identification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPrimitive createInputPrimitive() {
		InputPrimitiveImpl inputPrimitive = new InputPrimitiveImpl();
		return inputPrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputVars createInputVars() {
		InputVarsImpl inputVars = new InputVarsImpl();
		return inputVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceList createInterfaceList() {
		InterfaceListImpl interfaceList = new InterfaceListImpl();
		return interfaceList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalVars createInternalVars() {
		InternalVarsImpl internalVars = new InternalVarsImpl();
		return internalVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LD createLD() {
		LDImpl ld = new LDImpl();
		return ld;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Other createOther() {
		OtherImpl other = new OtherImpl();
		return other;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPrimitive createOutputPrimitive() {
		OutputPrimitiveImpl outputPrimitive = new OutputPrimitiveImpl();
		return outputPrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputVars createOutputVars() {
		OutputVarsImpl outputVars = new OutputVarsImpl();
		return outputVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Plugs createPlugs() {
		PlugsImpl plugs = new PlugsImpl();
		return plugs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceTypeName createResourceTypeName() {
		ResourceTypeNameImpl resourceTypeName = new ResourceTypeNameImpl();
		return resourceTypeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType createResourceType() {
		ResourceTypeImpl resourceType = new ResourceTypeImpl();
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rung createRung() {
		RungImpl rung = new RungImpl();
		return rung;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Segment createSegment() {
		SegmentImpl segment = new SegmentImpl();
		return segment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceSequence createServiceSequence() {
		ServiceSequenceImpl serviceSequence = new ServiceSequenceImpl();
		return serviceSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceTransaction createServiceTransaction() {
		ServiceTransactionImpl serviceTransaction = new ServiceTransactionImpl();
		return serviceTransaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sockets createSockets() {
		SocketsImpl sockets = new SocketsImpl();
		return sockets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ST createST() {
		STImpl st = new STImpl();
		return st;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppEventInputs createSubAppEventInputs() {
		SubAppEventInputsImpl subAppEventInputs = new SubAppEventInputsImpl();
		return subAppEventInputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppEventOutputs createSubAppEventOutputs() {
		SubAppEventOutputsImpl subAppEventOutputs = new SubAppEventOutputsImpl();
		return subAppEventOutputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppEvent createSubAppEvent() {
		SubAppEventImpl subAppEvent = new SubAppEventImpl();
		return subAppEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppInterfaceList createSubAppInterfaceList() {
		SubAppInterfaceListImpl subAppInterfaceList = new SubAppInterfaceListImpl();
		return subAppInterfaceList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppNetwork createSubAppNetwork() {
		SubAppNetworkImpl subAppNetwork = new SubAppNetworkImpl();
		return subAppNetwork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubApp createSubApp() {
		SubAppImpl subApp = new SubAppImpl();
		return subApp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppType createSubAppType() {
		SubAppTypeImpl subAppType = new SubAppTypeImpl();
		return subAppType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.cau.cs.kieler.functionblocks.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarDeclaration createVarDeclaration() {
		VarDeclarationImpl varDeclaration = new VarDeclarationImpl();
		return varDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionInfo createVersionInfo() {
		VersionInfoImpl versionInfo = new VersionInfoImpl();
		return versionInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public With createWith() {
		WithImpl with = new WithImpl();
		return with;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language createLanguageFromString(EDataType eDataType, String initialValue) {
		Language result = Language.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLanguageToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language createLanguageObjectFromString(EDataType eDataType, String initialValue) {
		return createLanguageFromString(FunctionblocksPackage.Literals.LANGUAGE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLanguageObjectToString(EDataType eDataType, Object instanceValue) {
		return convertLanguageToString(FunctionblocksPackage.Literals.LANGUAGE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionblocksPackage getFunctionblocksPackage() {
		return (FunctionblocksPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FunctionblocksPackage getPackage() {
		return FunctionblocksPackage.eINSTANCE;
	}

} //FunctionblocksFactoryImpl
