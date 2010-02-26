/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.util;

import de.cau.cs.kieler.cakefeed.Adapter;
import de.cau.cs.kieler.cakefeed.AdapterConnection;
import de.cau.cs.kieler.cakefeed.AdapterType;
import de.cau.cs.kieler.cakefeed.Application;
import de.cau.cs.kieler.cakefeed.BasicFunctionBlockDiagram;
import de.cau.cs.kieler.cakefeed.BasicFunctionBlockType;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.Compilable;
import de.cau.cs.kieler.cakefeed.CompilerInfo;
import de.cau.cs.kieler.cakefeed.CompositeFunctionBlockDiagram;
import de.cau.cs.kieler.cakefeed.CompositeFunctionBlockType;
import de.cau.cs.kieler.cakefeed.Connection;
import de.cau.cs.kieler.cakefeed.DataConnection;
import de.cau.cs.kieler.cakefeed.Device;
import de.cau.cs.kieler.cakefeed.DeviceType;
import de.cau.cs.kieler.cakefeed.Event;
import de.cau.cs.kieler.cakefeed.EventConnection;
import de.cau.cs.kieler.cakefeed.FBFBDataConnection;
import de.cau.cs.kieler.cakefeed.FBFBEventConnection;
import de.cau.cs.kieler.cakefeed.FBIFDataConnection;
import de.cau.cs.kieler.cakefeed.FBIFEventConnection;
import de.cau.cs.kieler.cakefeed.FBIVDataConnection;
import de.cau.cs.kieler.cakefeed.FBInputEvent;
import de.cau.cs.kieler.cakefeed.FBInputVar;
import de.cau.cs.kieler.cakefeed.FBOutputEvent;
import de.cau.cs.kieler.cakefeed.FBOutputVar;
import de.cau.cs.kieler.cakefeed.FunctionBlock;
import de.cau.cs.kieler.cakefeed.FunctionBlockDiagram;
import de.cau.cs.kieler.cakefeed.FunctionBlockInterface;
import de.cau.cs.kieler.cakefeed.FunctionBlockNetwork;
import de.cau.cs.kieler.cakefeed.FunctionBlockType;
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
import de.cau.cs.kieler.cakefeed.Identifiable;
import de.cau.cs.kieler.cakefeed.Identification;
import de.cau.cs.kieler.cakefeed.InputPrimitive;
import de.cau.cs.kieler.cakefeed.InputWith;
import de.cau.cs.kieler.cakefeed.InternalVar;
import de.cau.cs.kieler.cakefeed.LadderDiagram;
import de.cau.cs.kieler.cakefeed.Link;
import de.cau.cs.kieler.cakefeed.Mapping;
import de.cau.cs.kieler.cakefeed.NamedAndCommented;
import de.cau.cs.kieler.cakefeed.OtherAlgorithm;
import de.cau.cs.kieler.cakefeed.OutputPrimitive;
import de.cau.cs.kieler.cakefeed.OutputWith;
import de.cau.cs.kieler.cakefeed.Parameter;
import de.cau.cs.kieler.cakefeed.Plug;
import de.cau.cs.kieler.cakefeed.Primitive;
import de.cau.cs.kieler.cakefeed.Resource;
import de.cau.cs.kieler.cakefeed.ResourceType;
import de.cau.cs.kieler.cakefeed.Rung;
import de.cau.cs.kieler.cakefeed.Segment;
import de.cau.cs.kieler.cakefeed.Service;
import de.cau.cs.kieler.cakefeed.ServiceSequence;
import de.cau.cs.kieler.cakefeed.ServiceTransaction;
import de.cau.cs.kieler.cakefeed.Socket;
import de.cau.cs.kieler.cakefeed.StructuredText;
import de.cau.cs.kieler.cakefeed.Var;
import de.cau.cs.kieler.cakefeed.VersionInfo;
import de.cau.cs.kieler.cakefeed.With;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage
 * @generated
 */
public class CakefeedSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CakefeedPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CakefeedSwitch() {
		if (modelPackage == null) {
			modelPackage = CakefeedPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CakefeedPackage.SYSTEM: {
				de.cau.cs.kieler.cakefeed.System system = (de.cau.cs.kieler.cakefeed.System)theEObject;
				T result = caseSystem(system);
				if (result == null) result = caseIdentifiable(system);
				if (result == null) result = caseNamedAndCommented(system);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.IDENTIFICATION: {
				Identification identification = (Identification)theEObject;
				T result = caseIdentification(identification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.VERSION_INFO: {
				VersionInfo versionInfo = (VersionInfo)theEObject;
				T result = caseVersionInfo(versionInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.APPLICATION: {
				Application application = (Application)theEObject;
				T result = caseApplication(application);
				if (result == null) result = caseNamedAndCommented(application);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FUNCTION_BLOCK_NETWORK: {
				FunctionBlockNetwork functionBlockNetwork = (FunctionBlockNetwork)theEObject;
				T result = caseFunctionBlockNetwork(functionBlockNetwork);
				if (result == null) result = caseNamedAndCommented(functionBlockNetwork);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.DEVICE: {
				Device device = (Device)theEObject;
				T result = caseDevice(device);
				if (result == null) result = caseNamedAndCommented(device);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.MAPPING: {
				Mapping mapping = (Mapping)theEObject;
				T result = caseMapping(mapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.SEGMENT: {
				Segment segment = (Segment)theEObject;
				T result = caseSegment(segment);
				if (result == null) result = caseNamedAndCommented(segment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.LINK: {
				Link link = (Link)theEObject;
				T result = caseLink(link);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FUNCTION_BLOCK: {
				FunctionBlock functionBlock = (FunctionBlock)theEObject;
				T result = caseFunctionBlock(functionBlock);
				if (result == null) result = caseNamedAndCommented(functionBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE: {
				FunctionBlockInterface functionBlockInterface = (FunctionBlockInterface)theEObject;
				T result = caseFunctionBlockInterface(functionBlockInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseNamedAndCommented(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.RESOURCE: {
				Resource resource = (Resource)theEObject;
				T result = caseResource(resource);
				if (result == null) result = caseNamedAndCommented(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FUNCTION_BLOCK_TYPE: {
				FunctionBlockType functionBlockType = (FunctionBlockType)theEObject;
				T result = caseFunctionBlockType(functionBlockType);
				if (result == null) result = caseCompilable(functionBlockType);
				if (result == null) result = caseNamedAndCommented(functionBlockType);
				if (result == null) result = caseFunctionBlockInterface(functionBlockType);
				if (result == null) result = caseIdentifiable(functionBlockType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.CONNECTION: {
				Connection connection = (Connection)theEObject;
				T result = caseConnection(connection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.EVENT_CONNECTION: {
				EventConnection eventConnection = (EventConnection)theEObject;
				T result = caseEventConnection(eventConnection);
				if (result == null) result = caseConnection(eventConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.DATA_CONNECTION: {
				DataConnection dataConnection = (DataConnection)theEObject;
				T result = caseDataConnection(dataConnection);
				if (result == null) result = caseConnection(dataConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.COMPILER_INFO: {
				CompilerInfo compilerInfo = (CompilerInfo)theEObject;
				T result = caseCompilerInfo(compilerInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.IFIF_EVENT_CONNECTION: {
				IFIFEventConnection ififEventConnection = (IFIFEventConnection)theEObject;
				T result = caseIFIFEventConnection(ififEventConnection);
				if (result == null) result = caseEventConnection(ififEventConnection);
				if (result == null) result = caseConnection(ififEventConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.IFIF_DATA_CONNECTION: {
				IFIFDataConnection ififDataConnection = (IFIFDataConnection)theEObject;
				T result = caseIFIFDataConnection(ififDataConnection);
				if (result == null) result = caseDataConnection(ififDataConnection);
				if (result == null) result = caseConnection(ififDataConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.IFFB_EVENT_CONNECTION: {
				IFFBEventConnection iffbEventConnection = (IFFBEventConnection)theEObject;
				T result = caseIFFBEventConnection(iffbEventConnection);
				if (result == null) result = caseEventConnection(iffbEventConnection);
				if (result == null) result = caseConnection(iffbEventConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.IFFB_DATA_CONNECTION: {
				IFFBDataConnection iffbDataConnection = (IFFBDataConnection)theEObject;
				T result = caseIFFBDataConnection(iffbDataConnection);
				if (result == null) result = caseDataConnection(iffbDataConnection);
				if (result == null) result = caseConnection(iffbDataConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FBIF_EVENT_CONNECTION: {
				FBIFEventConnection fbifEventConnection = (FBIFEventConnection)theEObject;
				T result = caseFBIFEventConnection(fbifEventConnection);
				if (result == null) result = caseEventConnection(fbifEventConnection);
				if (result == null) result = caseConnection(fbifEventConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FBIF_DATA_CONNECTION: {
				FBIFDataConnection fbifDataConnection = (FBIFDataConnection)theEObject;
				T result = caseFBIFDataConnection(fbifDataConnection);
				if (result == null) result = caseDataConnection(fbifDataConnection);
				if (result == null) result = caseConnection(fbifDataConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FBFB_EVENT_CONNECTION: {
				FBFBEventConnection fbfbEventConnection = (FBFBEventConnection)theEObject;
				T result = caseFBFBEventConnection(fbfbEventConnection);
				if (result == null) result = caseEventConnection(fbfbEventConnection);
				if (result == null) result = caseConnection(fbfbEventConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FBFB_DATA_CONNECTION: {
				FBFBDataConnection fbfbDataConnection = (FBFBDataConnection)theEObject;
				T result = caseFBFBDataConnection(fbfbDataConnection);
				if (result == null) result = caseDataConnection(fbfbDataConnection);
				if (result == null) result = caseConnection(fbfbDataConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.IFIV_DATA_CONNECTION: {
				IFIVDataConnection ifivDataConnection = (IFIVDataConnection)theEObject;
				T result = caseIFIVDataConnection(ifivDataConnection);
				if (result == null) result = caseDataConnection(ifivDataConnection);
				if (result == null) result = caseConnection(ifivDataConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.IVIF_DATA_CONNECTION: {
				IVIFDataConnection ivifDataConnection = (IVIFDataConnection)theEObject;
				T result = caseIVIFDataConnection(ivifDataConnection);
				if (result == null) result = caseDataConnection(ivifDataConnection);
				if (result == null) result = caseConnection(ivifDataConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FBIV_DATA_CONNECTION: {
				FBIVDataConnection fbivDataConnection = (FBIVDataConnection)theEObject;
				T result = caseFBIVDataConnection(fbivDataConnection);
				if (result == null) result = caseDataConnection(fbivDataConnection);
				if (result == null) result = caseConnection(fbivDataConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.IVFB_DATA_CONNECTION: {
				IVFBDataConnection ivfbDataConnection = (IVFBDataConnection)theEObject;
				T result = caseIVFBDataConnection(ivfbDataConnection);
				if (result == null) result = caseDataConnection(ivfbDataConnection);
				if (result == null) result = caseConnection(ivfbDataConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.IVIV_DATA_CONNECTION: {
				IVIVDataConnection ivivDataConnection = (IVIVDataConnection)theEObject;
				T result = caseIVIVDataConnection(ivivDataConnection);
				if (result == null) result = caseDataConnection(ivivDataConnection);
				if (result == null) result = caseConnection(ivivDataConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.ADAPTER_CONNECTION: {
				AdapterConnection adapterConnection = (AdapterConnection)theEObject;
				T result = caseAdapterConnection(adapterConnection);
				if (result == null) result = caseConnection(adapterConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.EVENT: {
				Event event = (Event)theEObject;
				T result = caseEvent(event);
				if (result == null) result = caseNamedAndCommented(event);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.IF_INPUT_EVENT: {
				IFInputEvent ifInputEvent = (IFInputEvent)theEObject;
				T result = caseIFInputEvent(ifInputEvent);
				if (result == null) result = caseEvent(ifInputEvent);
				if (result == null) result = caseNamedAndCommented(ifInputEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FB_INPUT_EVENT: {
				FBInputEvent fbInputEvent = (FBInputEvent)theEObject;
				T result = caseFBInputEvent(fbInputEvent);
				if (result == null) result = caseEvent(fbInputEvent);
				if (result == null) result = caseNamedAndCommented(fbInputEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.IF_OUTPUT_EVENT: {
				IFOutputEvent ifOutputEvent = (IFOutputEvent)theEObject;
				T result = caseIFOutputEvent(ifOutputEvent);
				if (result == null) result = caseEvent(ifOutputEvent);
				if (result == null) result = caseNamedAndCommented(ifOutputEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FB_OUTPUT_EVENT: {
				FBOutputEvent fbOutputEvent = (FBOutputEvent)theEObject;
				T result = caseFBOutputEvent(fbOutputEvent);
				if (result == null) result = caseEvent(fbOutputEvent);
				if (result == null) result = caseNamedAndCommented(fbOutputEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.VAR: {
				Var var = (Var)theEObject;
				T result = caseVar(var);
				if (result == null) result = caseNamedAndCommented(var);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.IF_INPUT_VAR: {
				IFInputVar ifInputVar = (IFInputVar)theEObject;
				T result = caseIFInputVar(ifInputVar);
				if (result == null) result = caseVar(ifInputVar);
				if (result == null) result = caseNamedAndCommented(ifInputVar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FB_INPUT_VAR: {
				FBInputVar fbInputVar = (FBInputVar)theEObject;
				T result = caseFBInputVar(fbInputVar);
				if (result == null) result = caseVar(fbInputVar);
				if (result == null) result = caseNamedAndCommented(fbInputVar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.IF_OUTPUT_VAR: {
				IFOutputVar ifOutputVar = (IFOutputVar)theEObject;
				T result = caseIFOutputVar(ifOutputVar);
				if (result == null) result = caseVar(ifOutputVar);
				if (result == null) result = caseNamedAndCommented(ifOutputVar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FB_OUTPUT_VAR: {
				FBOutputVar fbOutputVar = (FBOutputVar)theEObject;
				T result = caseFBOutputVar(fbOutputVar);
				if (result == null) result = caseVar(fbOutputVar);
				if (result == null) result = caseNamedAndCommented(fbOutputVar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.INTERNAL_VAR: {
				InternalVar internalVar = (InternalVar)theEObject;
				T result = caseInternalVar(internalVar);
				if (result == null) result = caseVar(internalVar);
				if (result == null) result = caseNamedAndCommented(internalVar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.COMPILER: {
				de.cau.cs.kieler.cakefeed.Compiler compiler = (de.cau.cs.kieler.cakefeed.Compiler)theEObject;
				T result = caseCompiler(compiler);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.WITH: {
				With with = (With)theEObject;
				T result = caseWith(with);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.INPUT_WITH: {
				InputWith inputWith = (InputWith)theEObject;
				T result = caseInputWith(inputWith);
				if (result == null) result = caseWith(inputWith);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.OUTPUT_WITH: {
				OutputWith outputWith = (OutputWith)theEObject;
				T result = caseOutputWith(outputWith);
				if (result == null) result = caseWith(outputWith);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.ADAPTER: {
				Adapter adapter = (Adapter)theEObject;
				T result = caseAdapter(adapter);
				if (result == null) result = caseNamedAndCommented(adapter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.SOCKET: {
				Socket socket = (Socket)theEObject;
				T result = caseSocket(socket);
				if (result == null) result = caseAdapter(socket);
				if (result == null) result = caseNamedAndCommented(socket);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.PLUG: {
				Plug plug = (Plug)theEObject;
				T result = casePlug(plug);
				if (result == null) result = caseAdapter(plug);
				if (result == null) result = caseNamedAndCommented(plug);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.ADAPTER_TYPE: {
				AdapterType adapterType = (AdapterType)theEObject;
				T result = caseAdapterType(adapterType);
				if (result == null) result = caseCompilable(adapterType);
				if (result == null) result = caseNamedAndCommented(adapterType);
				if (result == null) result = caseFunctionBlockInterface(adapterType);
				if (result == null) result = caseIdentifiable(adapterType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.SERVICE: {
				Service service = (Service)theEObject;
				T result = caseService(service);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.SERVICE_SEQUENCE: {
				ServiceSequence serviceSequence = (ServiceSequence)theEObject;
				T result = caseServiceSequence(serviceSequence);
				if (result == null) result = caseNamedAndCommented(serviceSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.SERVICE_TRANSACTION: {
				ServiceTransaction serviceTransaction = (ServiceTransaction)theEObject;
				T result = caseServiceTransaction(serviceTransaction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.PRIMITIVE: {
				Primitive primitive = (Primitive)theEObject;
				T result = casePrimitive(primitive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.INPUT_PRIMITIVE: {
				InputPrimitive inputPrimitive = (InputPrimitive)theEObject;
				T result = caseInputPrimitive(inputPrimitive);
				if (result == null) result = casePrimitive(inputPrimitive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.OUTPUT_PRIMITIVE: {
				OutputPrimitive outputPrimitive = (OutputPrimitive)theEObject;
				T result = caseOutputPrimitive(outputPrimitive);
				if (result == null) result = casePrimitive(outputPrimitive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE: {
				BasicFunctionBlockType basicFunctionBlockType = (BasicFunctionBlockType)theEObject;
				T result = caseBasicFunctionBlockType(basicFunctionBlockType);
				if (result == null) result = caseFunctionBlockType(basicFunctionBlockType);
				if (result == null) result = caseCompilable(basicFunctionBlockType);
				if (result == null) result = caseNamedAndCommented(basicFunctionBlockType);
				if (result == null) result = caseFunctionBlockInterface(basicFunctionBlockType);
				if (result == null) result = caseIdentifiable(basicFunctionBlockType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FUNCTION_BLOCK_DIAGRAM: {
				FunctionBlockDiagram functionBlockDiagram = (FunctionBlockDiagram)theEObject;
				T result = caseFunctionBlockDiagram(functionBlockDiagram);
				if (result == null) result = caseNamedAndCommented(functionBlockDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.STRUCTURED_TEXT: {
				StructuredText structuredText = (StructuredText)theEObject;
				T result = caseStructuredText(structuredText);
				if (result == null) result = caseNamedAndCommented(structuredText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.LADDER_DIAGRAM: {
				LadderDiagram ladderDiagram = (LadderDiagram)theEObject;
				T result = caseLadderDiagram(ladderDiagram);
				if (result == null) result = caseNamedAndCommented(ladderDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.OTHER_ALGORITHM: {
				OtherAlgorithm otherAlgorithm = (OtherAlgorithm)theEObject;
				T result = caseOtherAlgorithm(otherAlgorithm);
				if (result == null) result = caseNamedAndCommented(otherAlgorithm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.RUNG: {
				Rung rung = (Rung)theEObject;
				T result = caseRung(rung);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK_TYPE: {
				CompositeFunctionBlockType compositeFunctionBlockType = (CompositeFunctionBlockType)theEObject;
				T result = caseCompositeFunctionBlockType(compositeFunctionBlockType);
				if (result == null) result = caseFunctionBlockType(compositeFunctionBlockType);
				if (result == null) result = caseFunctionBlockNetwork(compositeFunctionBlockType);
				if (result == null) result = caseCompilable(compositeFunctionBlockType);
				if (result == null) result = caseNamedAndCommented(compositeFunctionBlockType);
				if (result == null) result = caseFunctionBlockInterface(compositeFunctionBlockType);
				if (result == null) result = caseIdentifiable(compositeFunctionBlockType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.DEVICE_TYPE: {
				DeviceType deviceType = (DeviceType)theEObject;
				T result = caseDeviceType(deviceType);
				if (result == null) result = caseCompilable(deviceType);
				if (result == null) result = caseNamedAndCommented(deviceType);
				if (result == null) result = caseIdentifiable(deviceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.RESOURCE_TYPE: {
				ResourceType resourceType = (ResourceType)theEObject;
				T result = caseResourceType(resourceType);
				if (result == null) result = caseCompilable(resourceType);
				if (result == null) result = caseNamedAndCommented(resourceType);
				if (result == null) result = caseIdentifiable(resourceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_DIAGRAM: {
				BasicFunctionBlockDiagram basicFunctionBlockDiagram = (BasicFunctionBlockDiagram)theEObject;
				T result = caseBasicFunctionBlockDiagram(basicFunctionBlockDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK_DIAGRAM: {
				CompositeFunctionBlockDiagram compositeFunctionBlockDiagram = (CompositeFunctionBlockDiagram)theEObject;
				T result = caseCompositeFunctionBlockDiagram(compositeFunctionBlockDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.NAMED_AND_COMMENTED: {
				NamedAndCommented namedAndCommented = (NamedAndCommented)theEObject;
				T result = caseNamedAndCommented(namedAndCommented);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.IDENTIFIABLE: {
				Identifiable identifiable = (Identifiable)theEObject;
				T result = caseIdentifiable(identifiable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.COMPILABLE: {
				Compilable compilable = (Compilable)theEObject;
				T result = caseCompilable(compilable);
				if (result == null) result = caseIdentifiable(compilable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystem(de.cau.cs.kieler.cakefeed.System object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentification(Identification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Version Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Version Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVersionInfo(VersionInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplication(Application object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Block Network</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Block Network</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionBlockNetwork(FunctionBlockNetwork object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Device</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Device</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDevice(Device object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapping(Mapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSegment(Segment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLink(Link object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionBlock(FunctionBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Block Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Block Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionBlockInterface(FunctionBlockInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Block Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Block Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionBlockType(FunctionBlockType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnection(Connection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventConnection(EventConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataConnection(DataConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compiler Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compiler Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompilerInfo(CompilerInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFIF Event Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFIF Event Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFIFEventConnection(IFIFEventConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFIF Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFIF Data Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFIFDataConnection(IFIFDataConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFFB Event Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFFB Event Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFFBEventConnection(IFFBEventConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFFB Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFFB Data Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFFBDataConnection(IFFBDataConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FBIF Event Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FBIF Event Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFBIFEventConnection(FBIFEventConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FBIF Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FBIF Data Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFBIFDataConnection(FBIFDataConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FBFB Event Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FBFB Event Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFBFBEventConnection(FBFBEventConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FBFB Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FBFB Data Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFBFBDataConnection(FBFBDataConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFIV Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFIV Data Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFIVDataConnection(IFIVDataConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IVIF Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IVIF Data Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIVIFDataConnection(IVIFDataConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FBIV Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FBIV Data Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFBIVDataConnection(FBIVDataConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IVFB Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IVFB Data Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIVFBDataConnection(IVFBDataConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IVIV Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IVIV Data Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIVIVDataConnection(IVIVDataConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Adapter Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Adapter Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdapterConnection(AdapterConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IF Input Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IF Input Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFInputEvent(IFInputEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FB Input Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FB Input Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFBInputEvent(FBInputEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IF Output Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IF Output Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFOutputEvent(IFOutputEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FB Output Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FB Output Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFBOutputEvent(FBOutputEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVar(Var object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IF Input Var</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IF Input Var</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFInputVar(IFInputVar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FB Input Var</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FB Input Var</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFBInputVar(FBInputVar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IF Output Var</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IF Output Var</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFOutputVar(IFOutputVar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FB Output Var</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FB Output Var</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFBOutputVar(FBOutputVar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Var</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Var</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalVar(InternalVar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compiler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compiler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompiler(de.cau.cs.kieler.cakefeed.Compiler object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>With</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>With</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWith(With object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input With</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input With</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputWith(InputWith object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output With</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output With</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputWith(OutputWith object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Adapter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Adapter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdapter(Adapter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Socket</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Socket</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSocket(Socket object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plug</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plug</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlug(Plug object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Adapter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Adapter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdapterType(AdapterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseService(Service object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceSequence(ServiceSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Transaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Transaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceTransaction(ServiceTransaction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitive(Primitive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Primitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputPrimitive(InputPrimitive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Primitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputPrimitive(OutputPrimitive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Function Block Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Function Block Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicFunctionBlockType(BasicFunctionBlockType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Block Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Block Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionBlockDiagram(FunctionBlockDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredText(StructuredText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ladder Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ladder Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLadderDiagram(LadderDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Other Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Other Algorithm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOtherAlgorithm(OtherAlgorithm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rung</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rung</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRung(Rung object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Function Block Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Function Block Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeFunctionBlockType(CompositeFunctionBlockType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Device Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeviceType(DeviceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceType(ResourceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Function Block Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Function Block Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicFunctionBlockDiagram(BasicFunctionBlockDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Function Block Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Function Block Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeFunctionBlockDiagram(CompositeFunctionBlockDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named And Commented</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named And Commented</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedAndCommented(NamedAndCommented object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiable(Identifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compilable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compilable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompilable(Compilable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //CakefeedSwitch
