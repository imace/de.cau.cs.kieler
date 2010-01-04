/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblock.impl;

import de.cau.cs.kieler.functionblock.AdapterConnections;
import de.cau.cs.kieler.functionblock.AdapterDeclaration;
import de.cau.cs.kieler.functionblock.AdapterType;
import de.cau.cs.kieler.functionblock.Algorithm;
import de.cau.cs.kieler.functionblock.Application;
import de.cau.cs.kieler.functionblock.BasicFB;
import de.cau.cs.kieler.functionblock.CompilerInfo;
import de.cau.cs.kieler.functionblock.Connection;
import de.cau.cs.kieler.functionblock.DataConnections;
import de.cau.cs.kieler.functionblock.Device;
import de.cau.cs.kieler.functionblock.DeviceType;
import de.cau.cs.kieler.functionblock.DocumentRoot;
import de.cau.cs.kieler.functionblock.ECAction;
import de.cau.cs.kieler.functionblock.ECC;
import de.cau.cs.kieler.functionblock.ECState;
import de.cau.cs.kieler.functionblock.ECTransition;
import de.cau.cs.kieler.functionblock.Event;
import de.cau.cs.kieler.functionblock.EventConnections;
import de.cau.cs.kieler.functionblock.EventInputs;
import de.cau.cs.kieler.functionblock.EventOutputs;
import de.cau.cs.kieler.functionblock.FB;
import de.cau.cs.kieler.functionblock.FBD;
import de.cau.cs.kieler.functionblock.FBNetwork;
import de.cau.cs.kieler.functionblock.FBType;
import de.cau.cs.kieler.functionblock.FBTypeName;
import de.cau.cs.kieler.functionblock.FunctionblockFactory;
import de.cau.cs.kieler.functionblock.FunctionblockPackage;
import de.cau.cs.kieler.functionblock.HCECC;
import de.cau.cs.kieler.functionblock.HCECCRelation;
import de.cau.cs.kieler.functionblock.Identification;
import de.cau.cs.kieler.functionblock.InputPrimitive;
import de.cau.cs.kieler.functionblock.InputVars;
import de.cau.cs.kieler.functionblock.InterfaceList;
import de.cau.cs.kieler.functionblock.InternalVars;
import de.cau.cs.kieler.functionblock.LD;
import de.cau.cs.kieler.functionblock.Language;
import de.cau.cs.kieler.functionblock.Link;
import de.cau.cs.kieler.functionblock.Mapping;
import de.cau.cs.kieler.functionblock.Other;
import de.cau.cs.kieler.functionblock.OutputPrimitive;
import de.cau.cs.kieler.functionblock.OutputVars;
import de.cau.cs.kieler.functionblock.Parameter;
import de.cau.cs.kieler.functionblock.Plugs;
import de.cau.cs.kieler.functionblock.Resource;
import de.cau.cs.kieler.functionblock.ResourceType;
import de.cau.cs.kieler.functionblock.ResourceTypeName;
import de.cau.cs.kieler.functionblock.Rung;
import de.cau.cs.kieler.functionblock.ST;
import de.cau.cs.kieler.functionblock.Segment;
import de.cau.cs.kieler.functionblock.Service;
import de.cau.cs.kieler.functionblock.ServiceSequence;
import de.cau.cs.kieler.functionblock.ServiceTransaction;
import de.cau.cs.kieler.functionblock.Sockets;
import de.cau.cs.kieler.functionblock.SubApp;
import de.cau.cs.kieler.functionblock.SubAppEvent;
import de.cau.cs.kieler.functionblock.SubAppEventInputs;
import de.cau.cs.kieler.functionblock.SubAppEventOutputs;
import de.cau.cs.kieler.functionblock.SubAppInterfaceList;
import de.cau.cs.kieler.functionblock.SubAppNetwork;
import de.cau.cs.kieler.functionblock.SubAppType;
import de.cau.cs.kieler.functionblock.VarDeclaration;
import de.cau.cs.kieler.functionblock.VersionInfo;
import de.cau.cs.kieler.functionblock.With;

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
public class FunctionblockFactoryImpl extends EFactoryImpl implements FunctionblockFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FunctionblockFactory init() {
		try {
			FunctionblockFactory theFunctionblockFactory = (FunctionblockFactory)EPackage.Registry.INSTANCE.getEFactory("http://kieler.cs.cau.de/functionblock/"); 
			if (theFunctionblockFactory != null) {
				return theFunctionblockFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FunctionblockFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionblockFactoryImpl() {
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
			case FunctionblockPackage.ADAPTER_CONNECTIONS: return createAdapterConnections();
			case FunctionblockPackage.ADAPTER_DECLARATION: return createAdapterDeclaration();
			case FunctionblockPackage.ADAPTER_TYPE: return createAdapterType();
			case FunctionblockPackage.ALGORITHM: return createAlgorithm();
			case FunctionblockPackage.APPLICATION: return createApplication();
			case FunctionblockPackage.BASIC_FB: return createBasicFB();
			case FunctionblockPackage.COMPILER_INFO: return createCompilerInfo();
			case FunctionblockPackage.COMPILER: return createCompiler();
			case FunctionblockPackage.CONNECTION: return createConnection();
			case FunctionblockPackage.DATA_CONNECTIONS: return createDataConnections();
			case FunctionblockPackage.DEVICE: return createDevice();
			case FunctionblockPackage.DEVICE_TYPE: return createDeviceType();
			case FunctionblockPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case FunctionblockPackage.EC_ACTION: return createECAction();
			case FunctionblockPackage.ECC: return createECC();
			case FunctionblockPackage.EC_STATE: return createECState();
			case FunctionblockPackage.EC_TRANSITION: return createECTransition();
			case FunctionblockPackage.EVENT_CONNECTIONS: return createEventConnections();
			case FunctionblockPackage.EVENT_INPUTS: return createEventInputs();
			case FunctionblockPackage.EVENT_OUTPUTS: return createEventOutputs();
			case FunctionblockPackage.EVENT: return createEvent();
			case FunctionblockPackage.FBD: return createFBD();
			case FunctionblockPackage.FB_NETWORK: return createFBNetwork();
			case FunctionblockPackage.FB: return createFB();
			case FunctionblockPackage.FB_TYPE_NAME: return createFBTypeName();
			case FunctionblockPackage.FB_TYPE: return createFBType();
			case FunctionblockPackage.HCECC_RELATION: return createHCECCRelation();
			case FunctionblockPackage.HCECC: return createHCECC();
			case FunctionblockPackage.IDENTIFICATION: return createIdentification();
			case FunctionblockPackage.INPUT_PRIMITIVE: return createInputPrimitive();
			case FunctionblockPackage.INPUT_VARS: return createInputVars();
			case FunctionblockPackage.INTERFACE_LIST: return createInterfaceList();
			case FunctionblockPackage.INTERNAL_VARS: return createInternalVars();
			case FunctionblockPackage.LD: return createLD();
			case FunctionblockPackage.LINK: return createLink();
			case FunctionblockPackage.MAPPING: return createMapping();
			case FunctionblockPackage.OTHER: return createOther();
			case FunctionblockPackage.OUTPUT_PRIMITIVE: return createOutputPrimitive();
			case FunctionblockPackage.OUTPUT_VARS: return createOutputVars();
			case FunctionblockPackage.PARAMETER: return createParameter();
			case FunctionblockPackage.PLUGS: return createPlugs();
			case FunctionblockPackage.RESOURCE: return createResource();
			case FunctionblockPackage.RESOURCE_TYPE_NAME: return createResourceTypeName();
			case FunctionblockPackage.RESOURCE_TYPE: return createResourceType();
			case FunctionblockPackage.RUNG: return createRung();
			case FunctionblockPackage.SEGMENT: return createSegment();
			case FunctionblockPackage.SERVICE_SEQUENCE: return createServiceSequence();
			case FunctionblockPackage.SERVICE_TRANSACTION: return createServiceTransaction();
			case FunctionblockPackage.SERVICE: return createService();
			case FunctionblockPackage.SOCKETS: return createSockets();
			case FunctionblockPackage.ST: return createST();
			case FunctionblockPackage.SUB_APP_EVENT_INPUTS: return createSubAppEventInputs();
			case FunctionblockPackage.SUB_APP_EVENT_OUTPUTS: return createSubAppEventOutputs();
			case FunctionblockPackage.SUB_APP_EVENT: return createSubAppEvent();
			case FunctionblockPackage.SUB_APP_INTERFACE_LIST: return createSubAppInterfaceList();
			case FunctionblockPackage.SUB_APP_NETWORK: return createSubAppNetwork();
			case FunctionblockPackage.SUB_APP: return createSubApp();
			case FunctionblockPackage.SUB_APP_TYPE: return createSubAppType();
			case FunctionblockPackage.SYSTEM: return createSystem();
			case FunctionblockPackage.VAR_DECLARATION: return createVarDeclaration();
			case FunctionblockPackage.VERSION_INFO: return createVersionInfo();
			case FunctionblockPackage.WITH: return createWith();
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
			case FunctionblockPackage.LANGUAGE:
				return createLanguageFromString(eDataType, initialValue);
			case FunctionblockPackage.LANGUAGE_OBJECT:
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
			case FunctionblockPackage.LANGUAGE:
				return convertLanguageToString(eDataType, instanceValue);
			case FunctionblockPackage.LANGUAGE_OBJECT:
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
	public de.cau.cs.kieler.functionblock.Compiler createCompiler() {
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
	public de.cau.cs.kieler.functionblock.System createSystem() {
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
		return createLanguageFromString(FunctionblockPackage.Literals.LANGUAGE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLanguageObjectToString(EDataType eDataType, Object instanceValue) {
		return convertLanguageToString(FunctionblockPackage.Literals.LANGUAGE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionblockPackage getFunctionblockPackage() {
		return (FunctionblockPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FunctionblockPackage getPackage() {
		return FunctionblockPackage.eINSTANCE;
	}

} //FunctionblockFactoryImpl
