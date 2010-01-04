/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblock.util;

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
import de.cau.cs.kieler.functionblock.FunctionblockPackage;
import de.cau.cs.kieler.functionblock.HCECC;
import de.cau.cs.kieler.functionblock.HCECCRelation;
import de.cau.cs.kieler.functionblock.Identification;
import de.cau.cs.kieler.functionblock.InputPrimitive;
import de.cau.cs.kieler.functionblock.InputVars;
import de.cau.cs.kieler.functionblock.InterfaceList;
import de.cau.cs.kieler.functionblock.InternalVars;
import de.cau.cs.kieler.functionblock.LD;
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
 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage
 * @generated
 */
public class FunctionblockSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FunctionblockPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionblockSwitch() {
		if (modelPackage == null) {
			modelPackage = FunctionblockPackage.eINSTANCE;
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
			case FunctionblockPackage.ADAPTER_CONNECTIONS: {
				AdapterConnections adapterConnections = (AdapterConnections)theEObject;
				T result = caseAdapterConnections(adapterConnections);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.ADAPTER_DECLARATION: {
				AdapterDeclaration adapterDeclaration = (AdapterDeclaration)theEObject;
				T result = caseAdapterDeclaration(adapterDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.ADAPTER_TYPE: {
				AdapterType adapterType = (AdapterType)theEObject;
				T result = caseAdapterType(adapterType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.ALGORITHM: {
				Algorithm algorithm = (Algorithm)theEObject;
				T result = caseAlgorithm(algorithm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.APPLICATION: {
				Application application = (Application)theEObject;
				T result = caseApplication(application);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.BASIC_FB: {
				BasicFB basicFB = (BasicFB)theEObject;
				T result = caseBasicFB(basicFB);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.COMPILER_INFO: {
				CompilerInfo compilerInfo = (CompilerInfo)theEObject;
				T result = caseCompilerInfo(compilerInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.COMPILER: {
				de.cau.cs.kieler.functionblock.Compiler compiler = (de.cau.cs.kieler.functionblock.Compiler)theEObject;
				T result = caseCompiler(compiler);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.CONNECTION: {
				Connection connection = (Connection)theEObject;
				T result = caseConnection(connection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.DATA_CONNECTIONS: {
				DataConnections dataConnections = (DataConnections)theEObject;
				T result = caseDataConnections(dataConnections);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.DEVICE: {
				Device device = (Device)theEObject;
				T result = caseDevice(device);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.DEVICE_TYPE: {
				DeviceType deviceType = (DeviceType)theEObject;
				T result = caseDeviceType(deviceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.EC_ACTION: {
				ECAction ecAction = (ECAction)theEObject;
				T result = caseECAction(ecAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.ECC: {
				ECC ecc = (ECC)theEObject;
				T result = caseECC(ecc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.EC_STATE: {
				ECState ecState = (ECState)theEObject;
				T result = caseECState(ecState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.EC_TRANSITION: {
				ECTransition ecTransition = (ECTransition)theEObject;
				T result = caseECTransition(ecTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.EVENT_CONNECTIONS: {
				EventConnections eventConnections = (EventConnections)theEObject;
				T result = caseEventConnections(eventConnections);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.EVENT_INPUTS: {
				EventInputs eventInputs = (EventInputs)theEObject;
				T result = caseEventInputs(eventInputs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.EVENT_OUTPUTS: {
				EventOutputs eventOutputs = (EventOutputs)theEObject;
				T result = caseEventOutputs(eventOutputs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.EVENT: {
				Event event = (Event)theEObject;
				T result = caseEvent(event);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.FBD: {
				FBD fbd = (FBD)theEObject;
				T result = caseFBD(fbd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.FB_NETWORK: {
				FBNetwork fbNetwork = (FBNetwork)theEObject;
				T result = caseFBNetwork(fbNetwork);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.FB: {
				FB fb = (FB)theEObject;
				T result = caseFB(fb);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.FB_TYPE_NAME: {
				FBTypeName fbTypeName = (FBTypeName)theEObject;
				T result = caseFBTypeName(fbTypeName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.FB_TYPE: {
				FBType fbType = (FBType)theEObject;
				T result = caseFBType(fbType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.HCECC_RELATION: {
				HCECCRelation hceccRelation = (HCECCRelation)theEObject;
				T result = caseHCECCRelation(hceccRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.HCECC: {
				HCECC hcecc = (HCECC)theEObject;
				T result = caseHCECC(hcecc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.IDENTIFICATION: {
				Identification identification = (Identification)theEObject;
				T result = caseIdentification(identification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.INPUT_PRIMITIVE: {
				InputPrimitive inputPrimitive = (InputPrimitive)theEObject;
				T result = caseInputPrimitive(inputPrimitive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.INPUT_VARS: {
				InputVars inputVars = (InputVars)theEObject;
				T result = caseInputVars(inputVars);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.INTERFACE_LIST: {
				InterfaceList interfaceList = (InterfaceList)theEObject;
				T result = caseInterfaceList(interfaceList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.INTERNAL_VARS: {
				InternalVars internalVars = (InternalVars)theEObject;
				T result = caseInternalVars(internalVars);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.LD: {
				LD ld = (LD)theEObject;
				T result = caseLD(ld);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.LINK: {
				Link link = (Link)theEObject;
				T result = caseLink(link);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.MAPPING: {
				Mapping mapping = (Mapping)theEObject;
				T result = caseMapping(mapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.OTHER: {
				Other other = (Other)theEObject;
				T result = caseOther(other);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.OUTPUT_PRIMITIVE: {
				OutputPrimitive outputPrimitive = (OutputPrimitive)theEObject;
				T result = caseOutputPrimitive(outputPrimitive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.OUTPUT_VARS: {
				OutputVars outputVars = (OutputVars)theEObject;
				T result = caseOutputVars(outputVars);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.PLUGS: {
				Plugs plugs = (Plugs)theEObject;
				T result = casePlugs(plugs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.RESOURCE: {
				Resource resource = (Resource)theEObject;
				T result = caseResource(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.RESOURCE_TYPE_NAME: {
				ResourceTypeName resourceTypeName = (ResourceTypeName)theEObject;
				T result = caseResourceTypeName(resourceTypeName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.RESOURCE_TYPE: {
				ResourceType resourceType = (ResourceType)theEObject;
				T result = caseResourceType(resourceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.RUNG: {
				Rung rung = (Rung)theEObject;
				T result = caseRung(rung);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.SEGMENT: {
				Segment segment = (Segment)theEObject;
				T result = caseSegment(segment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.SERVICE_SEQUENCE: {
				ServiceSequence serviceSequence = (ServiceSequence)theEObject;
				T result = caseServiceSequence(serviceSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.SERVICE_TRANSACTION: {
				ServiceTransaction serviceTransaction = (ServiceTransaction)theEObject;
				T result = caseServiceTransaction(serviceTransaction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.SERVICE: {
				Service service = (Service)theEObject;
				T result = caseService(service);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.SOCKETS: {
				Sockets sockets = (Sockets)theEObject;
				T result = caseSockets(sockets);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.ST: {
				ST st = (ST)theEObject;
				T result = caseST(st);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.SUB_APP_EVENT_INPUTS: {
				SubAppEventInputs subAppEventInputs = (SubAppEventInputs)theEObject;
				T result = caseSubAppEventInputs(subAppEventInputs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.SUB_APP_EVENT_OUTPUTS: {
				SubAppEventOutputs subAppEventOutputs = (SubAppEventOutputs)theEObject;
				T result = caseSubAppEventOutputs(subAppEventOutputs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.SUB_APP_EVENT: {
				SubAppEvent subAppEvent = (SubAppEvent)theEObject;
				T result = caseSubAppEvent(subAppEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.SUB_APP_INTERFACE_LIST: {
				SubAppInterfaceList subAppInterfaceList = (SubAppInterfaceList)theEObject;
				T result = caseSubAppInterfaceList(subAppInterfaceList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.SUB_APP_NETWORK: {
				SubAppNetwork subAppNetwork = (SubAppNetwork)theEObject;
				T result = caseSubAppNetwork(subAppNetwork);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.SUB_APP: {
				SubApp subApp = (SubApp)theEObject;
				T result = caseSubApp(subApp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.SUB_APP_TYPE: {
				SubAppType subAppType = (SubAppType)theEObject;
				T result = caseSubAppType(subAppType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.SYSTEM: {
				de.cau.cs.kieler.functionblock.System system = (de.cau.cs.kieler.functionblock.System)theEObject;
				T result = caseSystem(system);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.VAR_DECLARATION: {
				VarDeclaration varDeclaration = (VarDeclaration)theEObject;
				T result = caseVarDeclaration(varDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.VERSION_INFO: {
				VersionInfo versionInfo = (VersionInfo)theEObject;
				T result = caseVersionInfo(versionInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FunctionblockPackage.WITH: {
				With with = (With)theEObject;
				T result = caseWith(with);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Adapter Connections</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Adapter Connections</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdapterConnections(AdapterConnections object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Adapter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Adapter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdapterDeclaration(AdapterDeclaration object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Algorithm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlgorithm(Algorithm object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Basic FB</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic FB</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicFB(BasicFB object) {
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
	public T caseCompiler(de.cau.cs.kieler.functionblock.Compiler object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Data Connections</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Connections</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataConnections(DataConnections object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EC Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EC Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseECAction(ECAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ECC</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ECC</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseECC(ECC object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EC State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EC State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseECState(ECState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EC Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EC Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseECTransition(ECTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Connections</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Connections</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventConnections(EventConnections object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Inputs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Inputs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventInputs(EventInputs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Outputs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Outputs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventOutputs(EventOutputs object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>FBD</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FBD</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFBD(FBD object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FB Network</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FB Network</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFBNetwork(FBNetwork object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FB</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FB</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFB(FB object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FB Type Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FB Type Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFBTypeName(FBTypeName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FB Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FB Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFBType(FBType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HCECC Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HCECC Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHCECCRelation(HCECCRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HCECC</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HCECC</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHCECC(HCECC object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Input Vars</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Vars</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputVars(InputVars object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceList(InterfaceList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Vars</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Vars</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalVars(InternalVars object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LD</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LD</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLD(LD object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Other</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Other</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOther(Other object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Output Vars</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Vars</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputVars(OutputVars object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Plugs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plugs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlugs(Plugs object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Resource Type Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Type Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceTypeName(ResourceTypeName object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Sockets</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sockets</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSockets(Sockets object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ST</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ST</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseST(ST object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub App Event Inputs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub App Event Inputs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubAppEventInputs(SubAppEventInputs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub App Event Outputs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub App Event Outputs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubAppEventOutputs(SubAppEventOutputs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub App Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub App Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubAppEvent(SubAppEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub App Interface List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub App Interface List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubAppInterfaceList(SubAppInterfaceList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub App Network</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub App Network</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubAppNetwork(SubAppNetwork object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub App</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub App</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubApp(SubApp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub App Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub App Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubAppType(SubAppType object) {
		return null;
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
	public T caseSystem(de.cau.cs.kieler.functionblock.System object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVarDeclaration(VarDeclaration object) {
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

} //FunctionblockSwitch
