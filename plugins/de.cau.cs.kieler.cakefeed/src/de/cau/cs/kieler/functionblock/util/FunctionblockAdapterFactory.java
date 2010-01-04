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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage
 * @generated
 */
public class FunctionblockAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FunctionblockPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionblockAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = FunctionblockPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionblockSwitch<Adapter> modelSwitch =
		new FunctionblockSwitch<Adapter>() {
			@Override
			public Adapter caseAdapterConnections(AdapterConnections object) {
				return createAdapterConnectionsAdapter();
			}
			@Override
			public Adapter caseAdapterDeclaration(AdapterDeclaration object) {
				return createAdapterDeclarationAdapter();
			}
			@Override
			public Adapter caseAdapterType(AdapterType object) {
				return createAdapterTypeAdapter();
			}
			@Override
			public Adapter caseAlgorithm(Algorithm object) {
				return createAlgorithmAdapter();
			}
			@Override
			public Adapter caseApplication(Application object) {
				return createApplicationAdapter();
			}
			@Override
			public Adapter caseBasicFB(BasicFB object) {
				return createBasicFBAdapter();
			}
			@Override
			public Adapter caseCompilerInfo(CompilerInfo object) {
				return createCompilerInfoAdapter();
			}
			@Override
			public Adapter caseCompiler(de.cau.cs.kieler.functionblock.Compiler object) {
				return createCompilerAdapter();
			}
			@Override
			public Adapter caseConnection(Connection object) {
				return createConnectionAdapter();
			}
			@Override
			public Adapter caseDataConnections(DataConnections object) {
				return createDataConnectionsAdapter();
			}
			@Override
			public Adapter caseDevice(Device object) {
				return createDeviceAdapter();
			}
			@Override
			public Adapter caseDeviceType(DeviceType object) {
				return createDeviceTypeAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseECAction(ECAction object) {
				return createECActionAdapter();
			}
			@Override
			public Adapter caseECC(ECC object) {
				return createECCAdapter();
			}
			@Override
			public Adapter caseECState(ECState object) {
				return createECStateAdapter();
			}
			@Override
			public Adapter caseECTransition(ECTransition object) {
				return createECTransitionAdapter();
			}
			@Override
			public Adapter caseEventConnections(EventConnections object) {
				return createEventConnectionsAdapter();
			}
			@Override
			public Adapter caseEventInputs(EventInputs object) {
				return createEventInputsAdapter();
			}
			@Override
			public Adapter caseEventOutputs(EventOutputs object) {
				return createEventOutputsAdapter();
			}
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter caseFBD(FBD object) {
				return createFBDAdapter();
			}
			@Override
			public Adapter caseFBNetwork(FBNetwork object) {
				return createFBNetworkAdapter();
			}
			@Override
			public Adapter caseFB(FB object) {
				return createFBAdapter();
			}
			@Override
			public Adapter caseFBTypeName(FBTypeName object) {
				return createFBTypeNameAdapter();
			}
			@Override
			public Adapter caseFBType(FBType object) {
				return createFBTypeAdapter();
			}
			@Override
			public Adapter caseHCECCRelation(HCECCRelation object) {
				return createHCECCRelationAdapter();
			}
			@Override
			public Adapter caseHCECC(HCECC object) {
				return createHCECCAdapter();
			}
			@Override
			public Adapter caseIdentification(Identification object) {
				return createIdentificationAdapter();
			}
			@Override
			public Adapter caseInputPrimitive(InputPrimitive object) {
				return createInputPrimitiveAdapter();
			}
			@Override
			public Adapter caseInputVars(InputVars object) {
				return createInputVarsAdapter();
			}
			@Override
			public Adapter caseInterfaceList(InterfaceList object) {
				return createInterfaceListAdapter();
			}
			@Override
			public Adapter caseInternalVars(InternalVars object) {
				return createInternalVarsAdapter();
			}
			@Override
			public Adapter caseLD(LD object) {
				return createLDAdapter();
			}
			@Override
			public Adapter caseLink(Link object) {
				return createLinkAdapter();
			}
			@Override
			public Adapter caseMapping(Mapping object) {
				return createMappingAdapter();
			}
			@Override
			public Adapter caseOther(Other object) {
				return createOtherAdapter();
			}
			@Override
			public Adapter caseOutputPrimitive(OutputPrimitive object) {
				return createOutputPrimitiveAdapter();
			}
			@Override
			public Adapter caseOutputVars(OutputVars object) {
				return createOutputVarsAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter casePlugs(Plugs object) {
				return createPlugsAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter caseResourceTypeName(ResourceTypeName object) {
				return createResourceTypeNameAdapter();
			}
			@Override
			public Adapter caseResourceType(ResourceType object) {
				return createResourceTypeAdapter();
			}
			@Override
			public Adapter caseRung(Rung object) {
				return createRungAdapter();
			}
			@Override
			public Adapter caseSegment(Segment object) {
				return createSegmentAdapter();
			}
			@Override
			public Adapter caseServiceSequence(ServiceSequence object) {
				return createServiceSequenceAdapter();
			}
			@Override
			public Adapter caseServiceTransaction(ServiceTransaction object) {
				return createServiceTransactionAdapter();
			}
			@Override
			public Adapter caseService(Service object) {
				return createServiceAdapter();
			}
			@Override
			public Adapter caseSockets(Sockets object) {
				return createSocketsAdapter();
			}
			@Override
			public Adapter caseST(ST object) {
				return createSTAdapter();
			}
			@Override
			public Adapter caseSubAppEventInputs(SubAppEventInputs object) {
				return createSubAppEventInputsAdapter();
			}
			@Override
			public Adapter caseSubAppEventOutputs(SubAppEventOutputs object) {
				return createSubAppEventOutputsAdapter();
			}
			@Override
			public Adapter caseSubAppEvent(SubAppEvent object) {
				return createSubAppEventAdapter();
			}
			@Override
			public Adapter caseSubAppInterfaceList(SubAppInterfaceList object) {
				return createSubAppInterfaceListAdapter();
			}
			@Override
			public Adapter caseSubAppNetwork(SubAppNetwork object) {
				return createSubAppNetworkAdapter();
			}
			@Override
			public Adapter caseSubApp(SubApp object) {
				return createSubAppAdapter();
			}
			@Override
			public Adapter caseSubAppType(SubAppType object) {
				return createSubAppTypeAdapter();
			}
			@Override
			public Adapter caseSystem(de.cau.cs.kieler.functionblock.System object) {
				return createSystemAdapter();
			}
			@Override
			public Adapter caseVarDeclaration(VarDeclaration object) {
				return createVarDeclarationAdapter();
			}
			@Override
			public Adapter caseVersionInfo(VersionInfo object) {
				return createVersionInfoAdapter();
			}
			@Override
			public Adapter caseWith(With object) {
				return createWithAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.AdapterConnections <em>Adapter Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.AdapterConnections
	 * @generated
	 */
	public Adapter createAdapterConnectionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.AdapterDeclaration <em>Adapter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.AdapterDeclaration
	 * @generated
	 */
	public Adapter createAdapterDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.AdapterType <em>Adapter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.AdapterType
	 * @generated
	 */
	public Adapter createAdapterTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Algorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Algorithm
	 * @generated
	 */
	public Adapter createAlgorithmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Application
	 * @generated
	 */
	public Adapter createApplicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.BasicFB <em>Basic FB</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.BasicFB
	 * @generated
	 */
	public Adapter createBasicFBAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.CompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.CompilerInfo
	 * @generated
	 */
	public Adapter createCompilerInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Compiler <em>Compiler</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Compiler
	 * @generated
	 */
	public Adapter createCompilerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Connection
	 * @generated
	 */
	public Adapter createConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.DataConnections <em>Data Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.DataConnections
	 * @generated
	 */
	public Adapter createDataConnectionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Device <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Device
	 * @generated
	 */
	public Adapter createDeviceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.DeviceType <em>Device Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.DeviceType
	 * @generated
	 */
	public Adapter createDeviceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.ECAction <em>EC Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.ECAction
	 * @generated
	 */
	public Adapter createECActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.ECC <em>ECC</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.ECC
	 * @generated
	 */
	public Adapter createECCAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.ECState <em>EC State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.ECState
	 * @generated
	 */
	public Adapter createECStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.ECTransition <em>EC Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.ECTransition
	 * @generated
	 */
	public Adapter createECTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.EventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.EventConnections
	 * @generated
	 */
	public Adapter createEventConnectionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.EventInputs <em>Event Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.EventInputs
	 * @generated
	 */
	public Adapter createEventInputsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.EventOutputs <em>Event Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.EventOutputs
	 * @generated
	 */
	public Adapter createEventOutputsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.FBD <em>FBD</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.FBD
	 * @generated
	 */
	public Adapter createFBDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.FBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.FBNetwork
	 * @generated
	 */
	public Adapter createFBNetworkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.FB <em>FB</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.FB
	 * @generated
	 */
	public Adapter createFBAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.FBTypeName <em>FB Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.FBTypeName
	 * @generated
	 */
	public Adapter createFBTypeNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.FBType <em>FB Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.FBType
	 * @generated
	 */
	public Adapter createFBTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.HCECCRelation <em>HCECC Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.HCECCRelation
	 * @generated
	 */
	public Adapter createHCECCRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.HCECC <em>HCECC</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.HCECC
	 * @generated
	 */
	public Adapter createHCECCAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Identification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Identification
	 * @generated
	 */
	public Adapter createIdentificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.InputPrimitive <em>Input Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.InputPrimitive
	 * @generated
	 */
	public Adapter createInputPrimitiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.InputVars <em>Input Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.InputVars
	 * @generated
	 */
	public Adapter createInputVarsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.InterfaceList <em>Interface List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.InterfaceList
	 * @generated
	 */
	public Adapter createInterfaceListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.InternalVars <em>Internal Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.InternalVars
	 * @generated
	 */
	public Adapter createInternalVarsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.LD <em>LD</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.LD
	 * @generated
	 */
	public Adapter createLDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Link
	 * @generated
	 */
	public Adapter createLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Mapping
	 * @generated
	 */
	public Adapter createMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Other <em>Other</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Other
	 * @generated
	 */
	public Adapter createOtherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.OutputPrimitive <em>Output Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.OutputPrimitive
	 * @generated
	 */
	public Adapter createOutputPrimitiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.OutputVars <em>Output Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.OutputVars
	 * @generated
	 */
	public Adapter createOutputVarsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Plugs <em>Plugs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Plugs
	 * @generated
	 */
	public Adapter createPlugsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.ResourceTypeName <em>Resource Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.ResourceTypeName
	 * @generated
	 */
	public Adapter createResourceTypeNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.ResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.ResourceType
	 * @generated
	 */
	public Adapter createResourceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Rung <em>Rung</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Rung
	 * @generated
	 */
	public Adapter createRungAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Segment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Segment
	 * @generated
	 */
	public Adapter createSegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.ServiceSequence <em>Service Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.ServiceSequence
	 * @generated
	 */
	public Adapter createServiceSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.ServiceTransaction <em>Service Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.ServiceTransaction
	 * @generated
	 */
	public Adapter createServiceTransactionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Service
	 * @generated
	 */
	public Adapter createServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.Sockets <em>Sockets</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.Sockets
	 * @generated
	 */
	public Adapter createSocketsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.ST <em>ST</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.ST
	 * @generated
	 */
	public Adapter createSTAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.SubAppEventInputs <em>Sub App Event Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.SubAppEventInputs
	 * @generated
	 */
	public Adapter createSubAppEventInputsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.SubAppEventOutputs <em>Sub App Event Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.SubAppEventOutputs
	 * @generated
	 */
	public Adapter createSubAppEventOutputsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.SubAppEvent <em>Sub App Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.SubAppEvent
	 * @generated
	 */
	public Adapter createSubAppEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.SubAppInterfaceList <em>Sub App Interface List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.SubAppInterfaceList
	 * @generated
	 */
	public Adapter createSubAppInterfaceListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.SubAppNetwork <em>Sub App Network</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.SubAppNetwork
	 * @generated
	 */
	public Adapter createSubAppNetworkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.SubApp <em>Sub App</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.SubApp
	 * @generated
	 */
	public Adapter createSubAppAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.SubAppType <em>Sub App Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.SubAppType
	 * @generated
	 */
	public Adapter createSubAppTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.System
	 * @generated
	 */
	public Adapter createSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.VarDeclaration <em>Var Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.VarDeclaration
	 * @generated
	 */
	public Adapter createVarDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.VersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.VersionInfo
	 * @generated
	 */
	public Adapter createVersionInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblock.With <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblock.With
	 * @generated
	 */
	public Adapter createWithAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //FunctionblockAdapterFactory
