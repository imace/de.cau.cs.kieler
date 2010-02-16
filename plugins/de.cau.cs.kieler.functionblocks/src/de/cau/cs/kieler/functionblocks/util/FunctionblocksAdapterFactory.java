/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks.util;

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
import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;
import de.cau.cs.kieler.functionblocks.HCECC;
import de.cau.cs.kieler.functionblocks.HCECCRelation;
import de.cau.cs.kieler.functionblocks.Identification;
import de.cau.cs.kieler.functionblocks.InputPrimitive;
import de.cau.cs.kieler.functionblocks.InputVars;
import de.cau.cs.kieler.functionblocks.InterfaceList;
import de.cau.cs.kieler.functionblocks.InternalVars;
import de.cau.cs.kieler.functionblocks.LD;
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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage
 * @generated
 */
public class FunctionblocksAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FunctionblocksPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionblocksAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = FunctionblocksPackage.eINSTANCE;
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
	protected FunctionblocksSwitch<Adapter> modelSwitch =
		new FunctionblocksSwitch<Adapter>() {
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
			public Adapter caseCompiler(de.cau.cs.kieler.functionblocks.Compiler object) {
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
			public Adapter caseSystem(de.cau.cs.kieler.functionblocks.System object) {
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
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.AdapterConnections <em>Adapter Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.AdapterConnections
	 * @generated
	 */
	public Adapter createAdapterConnectionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.AdapterDeclaration <em>Adapter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.AdapterDeclaration
	 * @generated
	 */
	public Adapter createAdapterDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.AdapterType <em>Adapter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.AdapterType
	 * @generated
	 */
	public Adapter createAdapterTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Algorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Algorithm
	 * @generated
	 */
	public Adapter createAlgorithmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Application
	 * @generated
	 */
	public Adapter createApplicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.BasicFB <em>Basic FB</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.BasicFB
	 * @generated
	 */
	public Adapter createBasicFBAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.CompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.CompilerInfo
	 * @generated
	 */
	public Adapter createCompilerInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Compiler <em>Compiler</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Compiler
	 * @generated
	 */
	public Adapter createCompilerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Connection
	 * @generated
	 */
	public Adapter createConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.DataConnections <em>Data Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.DataConnections
	 * @generated
	 */
	public Adapter createDataConnectionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Device <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Device
	 * @generated
	 */
	public Adapter createDeviceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.DeviceType <em>Device Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.DeviceType
	 * @generated
	 */
	public Adapter createDeviceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.ECAction <em>EC Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.ECAction
	 * @generated
	 */
	public Adapter createECActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.ECC <em>ECC</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.ECC
	 * @generated
	 */
	public Adapter createECCAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.ECState <em>EC State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.ECState
	 * @generated
	 */
	public Adapter createECStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.ECTransition <em>EC Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.ECTransition
	 * @generated
	 */
	public Adapter createECTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.EventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.EventConnections
	 * @generated
	 */
	public Adapter createEventConnectionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.EventInputs <em>Event Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.EventInputs
	 * @generated
	 */
	public Adapter createEventInputsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.EventOutputs <em>Event Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.EventOutputs
	 * @generated
	 */
	public Adapter createEventOutputsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.FBD <em>FBD</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.FBD
	 * @generated
	 */
	public Adapter createFBDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.FBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.FBNetwork
	 * @generated
	 */
	public Adapter createFBNetworkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.FB <em>FB</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.FB
	 * @generated
	 */
	public Adapter createFBAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.FBTypeName <em>FB Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.FBTypeName
	 * @generated
	 */
	public Adapter createFBTypeNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.FBType <em>FB Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.FBType
	 * @generated
	 */
	public Adapter createFBTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.HCECCRelation <em>HCECC Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.HCECCRelation
	 * @generated
	 */
	public Adapter createHCECCRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.HCECC <em>HCECC</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.HCECC
	 * @generated
	 */
	public Adapter createHCECCAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Identification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Identification
	 * @generated
	 */
	public Adapter createIdentificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.InputPrimitive <em>Input Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.InputPrimitive
	 * @generated
	 */
	public Adapter createInputPrimitiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.InputVars <em>Input Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.InputVars
	 * @generated
	 */
	public Adapter createInputVarsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.InterfaceList <em>Interface List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.InterfaceList
	 * @generated
	 */
	public Adapter createInterfaceListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.InternalVars <em>Internal Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.InternalVars
	 * @generated
	 */
	public Adapter createInternalVarsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.LD <em>LD</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.LD
	 * @generated
	 */
	public Adapter createLDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Link
	 * @generated
	 */
	public Adapter createLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Mapping
	 * @generated
	 */
	public Adapter createMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Other <em>Other</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Other
	 * @generated
	 */
	public Adapter createOtherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.OutputPrimitive <em>Output Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.OutputPrimitive
	 * @generated
	 */
	public Adapter createOutputPrimitiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.OutputVars <em>Output Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.OutputVars
	 * @generated
	 */
	public Adapter createOutputVarsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Plugs <em>Plugs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Plugs
	 * @generated
	 */
	public Adapter createPlugsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.ResourceTypeName <em>Resource Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.ResourceTypeName
	 * @generated
	 */
	public Adapter createResourceTypeNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.ResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.ResourceType
	 * @generated
	 */
	public Adapter createResourceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Rung <em>Rung</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Rung
	 * @generated
	 */
	public Adapter createRungAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Segment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Segment
	 * @generated
	 */
	public Adapter createSegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.ServiceSequence <em>Service Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.ServiceSequence
	 * @generated
	 */
	public Adapter createServiceSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.ServiceTransaction <em>Service Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.ServiceTransaction
	 * @generated
	 */
	public Adapter createServiceTransactionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Service
	 * @generated
	 */
	public Adapter createServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.Sockets <em>Sockets</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.Sockets
	 * @generated
	 */
	public Adapter createSocketsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.ST <em>ST</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.ST
	 * @generated
	 */
	public Adapter createSTAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.SubAppEventInputs <em>Sub App Event Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.SubAppEventInputs
	 * @generated
	 */
	public Adapter createSubAppEventInputsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.SubAppEventOutputs <em>Sub App Event Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.SubAppEventOutputs
	 * @generated
	 */
	public Adapter createSubAppEventOutputsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.SubAppEvent <em>Sub App Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.SubAppEvent
	 * @generated
	 */
	public Adapter createSubAppEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.SubAppInterfaceList <em>Sub App Interface List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.SubAppInterfaceList
	 * @generated
	 */
	public Adapter createSubAppInterfaceListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.SubAppNetwork <em>Sub App Network</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.SubAppNetwork
	 * @generated
	 */
	public Adapter createSubAppNetworkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.SubApp <em>Sub App</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.SubApp
	 * @generated
	 */
	public Adapter createSubAppAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.SubAppType <em>Sub App Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.SubAppType
	 * @generated
	 */
	public Adapter createSubAppTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.System
	 * @generated
	 */
	public Adapter createSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.VarDeclaration <em>Var Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.VarDeclaration
	 * @generated
	 */
	public Adapter createVarDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.VersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.VersionInfo
	 * @generated
	 */
	public Adapter createVersionInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.functionblocks.With <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.cau.cs.kieler.functionblocks.With
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

} //FunctionblocksAdapterFactory
