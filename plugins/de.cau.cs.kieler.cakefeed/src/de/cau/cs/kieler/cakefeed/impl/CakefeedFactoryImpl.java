/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.AdapterConnection;
import de.cau.cs.kieler.cakefeed.AdapterType;
import de.cau.cs.kieler.cakefeed.Application;
import de.cau.cs.kieler.cakefeed.BFBDiagram;
import de.cau.cs.kieler.cakefeed.BFBType;
import de.cau.cs.kieler.cakefeed.CFBDiagram;
import de.cau.cs.kieler.cakefeed.CFBType;
import de.cau.cs.kieler.cakefeed.CakefeedFactory;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.CompilerInfo;
import de.cau.cs.kieler.cakefeed.Device;
import de.cau.cs.kieler.cakefeed.DeviceType;
import de.cau.cs.kieler.cakefeed.FB;
import de.cau.cs.kieler.cakefeed.FBD;
import de.cau.cs.kieler.cakefeed.FBFBDataConnection;
import de.cau.cs.kieler.cakefeed.FBFBEventConnection;
import de.cau.cs.kieler.cakefeed.FBIFDataConnection;
import de.cau.cs.kieler.cakefeed.FBIFEventConnection;
import de.cau.cs.kieler.cakefeed.FBIVDataConnection;
import de.cau.cs.kieler.cakefeed.FBInputEvent;
import de.cau.cs.kieler.cakefeed.FBInputVar;
import de.cau.cs.kieler.cakefeed.FBNetwork;
import de.cau.cs.kieler.cakefeed.FBOutputEvent;
import de.cau.cs.kieler.cakefeed.FBOutputVar;
import de.cau.cs.kieler.cakefeed.IFFBDataConnection;
import de.cau.cs.kieler.cakefeed.IFFBEventConnection;
import de.cau.cs.kieler.cakefeed.IFIFDataConnection;
import de.cau.cs.kieler.cakefeed.IFIFEventConnection;
import de.cau.cs.kieler.cakefeed.IFIVDataConnection;
import de.cau.cs.kieler.cakefeed.IFInputEvent;
import de.cau.cs.kieler.cakefeed.IFInputVar;
import de.cau.cs.kieler.cakefeed.IFOutputEvent;
import de.cau.cs.kieler.cakefeed.IFOutputVar;
import de.cau.cs.kieler.cakefeed.IVFBDataConnection;
import de.cau.cs.kieler.cakefeed.IVIFDataConnection;
import de.cau.cs.kieler.cakefeed.IVIVDataConnection;
import de.cau.cs.kieler.cakefeed.Identification;
import de.cau.cs.kieler.cakefeed.InputPrimitive;
import de.cau.cs.kieler.cakefeed.InputWith;
import de.cau.cs.kieler.cakefeed.InternalVar;
import de.cau.cs.kieler.cakefeed.LD;
import de.cau.cs.kieler.cakefeed.Language;
import de.cau.cs.kieler.cakefeed.Link;
import de.cau.cs.kieler.cakefeed.Mapping;
import de.cau.cs.kieler.cakefeed.Other;
import de.cau.cs.kieler.cakefeed.OutputPrimitive;
import de.cau.cs.kieler.cakefeed.OutputWith;
import de.cau.cs.kieler.cakefeed.Parameter;
import de.cau.cs.kieler.cakefeed.Plug;
import de.cau.cs.kieler.cakefeed.Resource;
import de.cau.cs.kieler.cakefeed.ResourceType;
import de.cau.cs.kieler.cakefeed.Rung;
import de.cau.cs.kieler.cakefeed.ST;
import de.cau.cs.kieler.cakefeed.Segment;
import de.cau.cs.kieler.cakefeed.SegmentType;
import de.cau.cs.kieler.cakefeed.Service;
import de.cau.cs.kieler.cakefeed.ServiceSequence;
import de.cau.cs.kieler.cakefeed.ServiceTransaction;
import de.cau.cs.kieler.cakefeed.Socket;
import de.cau.cs.kieler.cakefeed.VarType;
import de.cau.cs.kieler.cakefeed.VersionInfo;

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
public class CakefeedFactoryImpl extends EFactoryImpl implements CakefeedFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CakefeedFactory init() {
		try {
			CakefeedFactory theCakefeedFactory = (CakefeedFactory)EPackage.Registry.INSTANCE.getEFactory("http://kieler.cs.cau.de/cakefeed/"); 
			if (theCakefeedFactory != null) {
				return theCakefeedFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CakefeedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CakefeedFactoryImpl() {
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
			case CakefeedPackage.SYSTEM: return createSystem();
			case CakefeedPackage.IDENTIFICATION: return createIdentification();
			case CakefeedPackage.VERSION_INFO: return createVersionInfo();
			case CakefeedPackage.APPLICATION: return createApplication();
			case CakefeedPackage.FB_NETWORK: return createFBNetwork();
			case CakefeedPackage.DEVICE: return createDevice();
			case CakefeedPackage.MAPPING: return createMapping();
			case CakefeedPackage.SEGMENT: return createSegment();
			case CakefeedPackage.LINK: return createLink();
			case CakefeedPackage.FB: return createFB();
			case CakefeedPackage.PARAMETER: return createParameter();
			case CakefeedPackage.RESOURCE: return createResource();
			case CakefeedPackage.COMPILER_INFO: return createCompilerInfo();
			case CakefeedPackage.IFIF_EVENT_CONNECTION: return createIFIFEventConnection();
			case CakefeedPackage.IFIF_DATA_CONNECTION: return createIFIFDataConnection();
			case CakefeedPackage.IFFB_EVENT_CONNECTION: return createIFFBEventConnection();
			case CakefeedPackage.IFFB_DATA_CONNECTION: return createIFFBDataConnection();
			case CakefeedPackage.FBIF_EVENT_CONNECTION: return createFBIFEventConnection();
			case CakefeedPackage.FBIF_DATA_CONNECTION: return createFBIFDataConnection();
			case CakefeedPackage.FBFB_EVENT_CONNECTION: return createFBFBEventConnection();
			case CakefeedPackage.FBFB_DATA_CONNECTION: return createFBFBDataConnection();
			case CakefeedPackage.IFIV_DATA_CONNECTION: return createIFIVDataConnection();
			case CakefeedPackage.IVIF_DATA_CONNECTION: return createIVIFDataConnection();
			case CakefeedPackage.FBIV_DATA_CONNECTION: return createFBIVDataConnection();
			case CakefeedPackage.IVFB_DATA_CONNECTION: return createIVFBDataConnection();
			case CakefeedPackage.IVIV_DATA_CONNECTION: return createIVIVDataConnection();
			case CakefeedPackage.ADAPTER_CONNECTION: return createAdapterConnection();
			case CakefeedPackage.IF_INPUT_EVENT: return createIFInputEvent();
			case CakefeedPackage.FB_INPUT_EVENT: return createFBInputEvent();
			case CakefeedPackage.IF_OUTPUT_EVENT: return createIFOutputEvent();
			case CakefeedPackage.FB_OUTPUT_EVENT: return createFBOutputEvent();
			case CakefeedPackage.IF_INPUT_VAR: return createIFInputVar();
			case CakefeedPackage.FB_INPUT_VAR: return createFBInputVar();
			case CakefeedPackage.IF_OUTPUT_VAR: return createIFOutputVar();
			case CakefeedPackage.FB_OUTPUT_VAR: return createFBOutputVar();
			case CakefeedPackage.INTERNAL_VAR: return createInternalVar();
			case CakefeedPackage.COMPILER: return createCompiler();
			case CakefeedPackage.INPUT_WITH: return createInputWith();
			case CakefeedPackage.OUTPUT_WITH: return createOutputWith();
			case CakefeedPackage.SOCKET: return createSocket();
			case CakefeedPackage.PLUG: return createPlug();
			case CakefeedPackage.ADAPTER_TYPE: return createAdapterType();
			case CakefeedPackage.SERVICE: return createService();
			case CakefeedPackage.SERVICE_SEQUENCE: return createServiceSequence();
			case CakefeedPackage.SERVICE_TRANSACTION: return createServiceTransaction();
			case CakefeedPackage.INPUT_PRIMITIVE: return createInputPrimitive();
			case CakefeedPackage.OUTPUT_PRIMITIVE: return createOutputPrimitive();
			case CakefeedPackage.BFB_TYPE: return createBFBType();
			case CakefeedPackage.FBD: return createFBD();
			case CakefeedPackage.ST: return createST();
			case CakefeedPackage.LD: return createLD();
			case CakefeedPackage.OTHER: return createOther();
			case CakefeedPackage.RUNG: return createRung();
			case CakefeedPackage.CFB_TYPE: return createCFBType();
			case CakefeedPackage.DEVICE_TYPE: return createDeviceType();
			case CakefeedPackage.RESOURCE_TYPE: return createResourceType();
			case CakefeedPackage.BFB_DIAGRAM: return createBFBDiagram();
			case CakefeedPackage.CFB_DIAGRAM: return createCFBDiagram();
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
			case CakefeedPackage.SEGMENT_TYPE:
				return createSegmentTypeFromString(eDataType, initialValue);
			case CakefeedPackage.LANGUAGE:
				return createLanguageFromString(eDataType, initialValue);
			case CakefeedPackage.VAR_TYPE:
				return createVarTypeFromString(eDataType, initialValue);
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
			case CakefeedPackage.SEGMENT_TYPE:
				return convertSegmentTypeToString(eDataType, instanceValue);
			case CakefeedPackage.LANGUAGE:
				return convertLanguageToString(eDataType, instanceValue);
			case CakefeedPackage.VAR_TYPE:
				return convertVarTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.cau.cs.kieler.cakefeed.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
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
	public VersionInfo createVersionInfo() {
		VersionInfoImpl versionInfo = new VersionInfoImpl();
		return versionInfo;
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
	public FBNetwork createFBNetwork() {
		FBNetworkImpl fbNetwork = new FBNetworkImpl();
		return fbNetwork;
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
	public Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
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
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
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
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
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
	public CompilerInfo createCompilerInfo() {
		CompilerInfoImpl compilerInfo = new CompilerInfoImpl();
		return compilerInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFIFEventConnection createIFIFEventConnection() {
		IFIFEventConnectionImpl ififEventConnection = new IFIFEventConnectionImpl();
		return ififEventConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFIFDataConnection createIFIFDataConnection() {
		IFIFDataConnectionImpl ififDataConnection = new IFIFDataConnectionImpl();
		return ififDataConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFFBEventConnection createIFFBEventConnection() {
		IFFBEventConnectionImpl iffbEventConnection = new IFFBEventConnectionImpl();
		return iffbEventConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFFBDataConnection createIFFBDataConnection() {
		IFFBDataConnectionImpl iffbDataConnection = new IFFBDataConnectionImpl();
		return iffbDataConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBIFEventConnection createFBIFEventConnection() {
		FBIFEventConnectionImpl fbifEventConnection = new FBIFEventConnectionImpl();
		return fbifEventConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBIFDataConnection createFBIFDataConnection() {
		FBIFDataConnectionImpl fbifDataConnection = new FBIFDataConnectionImpl();
		return fbifDataConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBFBEventConnection createFBFBEventConnection() {
		FBFBEventConnectionImpl fbfbEventConnection = new FBFBEventConnectionImpl();
		return fbfbEventConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBFBDataConnection createFBFBDataConnection() {
		FBFBDataConnectionImpl fbfbDataConnection = new FBFBDataConnectionImpl();
		return fbfbDataConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFIVDataConnection createIFIVDataConnection() {
		IFIVDataConnectionImpl ifivDataConnection = new IFIVDataConnectionImpl();
		return ifivDataConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IVIFDataConnection createIVIFDataConnection() {
		IVIFDataConnectionImpl ivifDataConnection = new IVIFDataConnectionImpl();
		return ivifDataConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBIVDataConnection createFBIVDataConnection() {
		FBIVDataConnectionImpl fbivDataConnection = new FBIVDataConnectionImpl();
		return fbivDataConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IVFBDataConnection createIVFBDataConnection() {
		IVFBDataConnectionImpl ivfbDataConnection = new IVFBDataConnectionImpl();
		return ivfbDataConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IVIVDataConnection createIVIVDataConnection() {
		IVIVDataConnectionImpl ivivDataConnection = new IVIVDataConnectionImpl();
		return ivivDataConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterConnection createAdapterConnection() {
		AdapterConnectionImpl adapterConnection = new AdapterConnectionImpl();
		return adapterConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFInputEvent createIFInputEvent() {
		IFInputEventImpl ifInputEvent = new IFInputEventImpl();
		return ifInputEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBInputEvent createFBInputEvent() {
		FBInputEventImpl fbInputEvent = new FBInputEventImpl();
		return fbInputEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFOutputEvent createIFOutputEvent() {
		IFOutputEventImpl ifOutputEvent = new IFOutputEventImpl();
		return ifOutputEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBOutputEvent createFBOutputEvent() {
		FBOutputEventImpl fbOutputEvent = new FBOutputEventImpl();
		return fbOutputEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFInputVar createIFInputVar() {
		IFInputVarImpl ifInputVar = new IFInputVarImpl();
		return ifInputVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBInputVar createFBInputVar() {
		FBInputVarImpl fbInputVar = new FBInputVarImpl();
		return fbInputVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFOutputVar createIFOutputVar() {
		IFOutputVarImpl ifOutputVar = new IFOutputVarImpl();
		return ifOutputVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBOutputVar createFBOutputVar() {
		FBOutputVarImpl fbOutputVar = new FBOutputVarImpl();
		return fbOutputVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalVar createInternalVar() {
		InternalVarImpl internalVar = new InternalVarImpl();
		return internalVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.cau.cs.kieler.cakefeed.Compiler createCompiler() {
		CompilerImpl compiler = new CompilerImpl();
		return compiler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputWith createInputWith() {
		InputWithImpl inputWith = new InputWithImpl();
		return inputWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputWith createOutputWith() {
		OutputWithImpl outputWith = new OutputWithImpl();
		return outputWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Socket createSocket() {
		SocketImpl socket = new SocketImpl();
		return socket;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Plug createPlug() {
		PlugImpl plug = new PlugImpl();
		return plug;
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
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
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
	public InputPrimitive createInputPrimitive() {
		InputPrimitiveImpl inputPrimitive = new InputPrimitiveImpl();
		return inputPrimitive;
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
	public BFBType createBFBType() {
		BFBTypeImpl bfbType = new BFBTypeImpl();
		return bfbType;
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
	public ST createST() {
		STImpl st = new STImpl();
		return st;
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
	public Other createOther() {
		OtherImpl other = new OtherImpl();
		return other;
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
	public CFBType createCFBType() {
		CFBTypeImpl cfbType = new CFBTypeImpl();
		return cfbType;
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
	public ResourceType createResourceType() {
		ResourceTypeImpl resourceType = new ResourceTypeImpl();
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BFBDiagram createBFBDiagram() {
		BFBDiagramImpl bfbDiagram = new BFBDiagramImpl();
		return bfbDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CFBDiagram createCFBDiagram() {
		CFBDiagramImpl cfbDiagram = new CFBDiagramImpl();
		return cfbDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SegmentType createSegmentTypeFromString(EDataType eDataType, String initialValue) {
		SegmentType result = SegmentType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSegmentTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
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
	public VarType createVarTypeFromString(EDataType eDataType, String initialValue) {
		VarType result = VarType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVarTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CakefeedPackage getCakefeedPackage() {
		return (CakefeedPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CakefeedPackage getPackage() {
		return CakefeedPackage.eINSTANCE;
	}

} //CakefeedFactoryImpl
