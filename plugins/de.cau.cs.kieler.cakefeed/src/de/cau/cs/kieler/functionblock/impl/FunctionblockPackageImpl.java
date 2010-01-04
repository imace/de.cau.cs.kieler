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
import de.cau.cs.kieler.functionblock.ECState;
import de.cau.cs.kieler.functionblock.ECTransition;
import de.cau.cs.kieler.functionblock.Event;
import de.cau.cs.kieler.functionblock.EventConnections;
import de.cau.cs.kieler.functionblock.EventInputs;
import de.cau.cs.kieler.functionblock.EventOutputs;
import de.cau.cs.kieler.functionblock.FBNetwork;
import de.cau.cs.kieler.functionblock.FBType;
import de.cau.cs.kieler.functionblock.FBTypeName;
import de.cau.cs.kieler.functionblock.FunctionblockFactory;
import de.cau.cs.kieler.functionblock.FunctionblockPackage;
import de.cau.cs.kieler.functionblock.HCECCRelation;
import de.cau.cs.kieler.functionblock.Identification;
import de.cau.cs.kieler.functionblock.InputPrimitive;
import de.cau.cs.kieler.functionblock.InputVars;
import de.cau.cs.kieler.functionblock.InterfaceList;
import de.cau.cs.kieler.functionblock.InternalVars;
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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionblockPackageImpl extends EPackageImpl implements FunctionblockPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adapterConnectionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adapterDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adapterTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass algorithmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicFBEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compilerInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compilerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataConnectionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eccEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventConnectionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventInputsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventOutputsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fbdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fbNetworkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fbEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fbTypeNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fbTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hceccRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hceccEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputPrimitiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputVarsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalVarsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass otherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputPrimitiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputVarsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass plugsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceTypeNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rungEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass segmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceTransactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass socketsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subAppEventInputsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subAppEventOutputsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subAppEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subAppInterfaceListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subAppNetworkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subAppEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subAppTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass withEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum languageEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType languageObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FunctionblockPackageImpl() {
		super(eNS_URI, FunctionblockFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link FunctionblockPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FunctionblockPackage init() {
		if (isInited) return (FunctionblockPackage)EPackage.Registry.INSTANCE.getEPackage(FunctionblockPackage.eNS_URI);

		// Obtain or create and register package
		FunctionblockPackageImpl theFunctionblockPackage = (FunctionblockPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FunctionblockPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FunctionblockPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFunctionblockPackage.createPackageContents();

		// Initialize created meta-data
		theFunctionblockPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFunctionblockPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FunctionblockPackage.eNS_URI, theFunctionblockPackage);
		return theFunctionblockPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdapterConnections() {
		return adapterConnectionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapterConnections_Connection() {
		return (EReference)adapterConnectionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdapterDeclaration() {
		return adapterDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapterDeclaration_Parameter() {
		return (EReference)adapterDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdapterDeclaration_Comment() {
		return (EAttribute)adapterDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdapterDeclaration_Name() {
		return (EAttribute)adapterDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdapterDeclaration_Type() {
		return (EAttribute)adapterDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdapterType() {
		return adapterTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapterType_Identification() {
		return (EReference)adapterTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapterType_VersionInfo() {
		return (EReference)adapterTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapterType_CompilerInfo() {
		return (EReference)adapterTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapterType_InterfaceList() {
		return (EReference)adapterTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapterType_Service() {
		return (EReference)adapterTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdapterType_Comment() {
		return (EAttribute)adapterTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdapterType_Name() {
		return (EAttribute)adapterTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlgorithm() {
		return algorithmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlgorithm_FBD() {
		return (EReference)algorithmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlgorithm_ST() {
		return (EReference)algorithmEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlgorithm_LD() {
		return (EReference)algorithmEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlgorithm_Other() {
		return (EReference)algorithmEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlgorithm_Comment() {
		return (EAttribute)algorithmEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlgorithm_Name() {
		return (EAttribute)algorithmEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplication() {
		return applicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplication_FBNetwork() {
		return (EReference)applicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplication_Comment() {
		return (EAttribute)applicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplication_Name() {
		return (EAttribute)applicationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicFB() {
		return basicFBEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFB_InternalVars() {
		return (EReference)basicFBEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFB_ECC() {
		return (EReference)basicFBEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFB_HCECC() {
		return (EReference)basicFBEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFB_Algorithm() {
		return (EReference)basicFBEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompilerInfo() {
		return compilerInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompilerInfo_Compiler() {
		return (EReference)compilerInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompilerInfo_Classdef() {
		return (EAttribute)compilerInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompilerInfo_Header() {
		return (EAttribute)compilerInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompiler() {
		return compilerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompiler_Language() {
		return (EAttribute)compilerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompiler_Product() {
		return (EAttribute)compilerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompiler_Vendor() {
		return (EAttribute)compilerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompiler_Version() {
		return (EAttribute)compilerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnection() {
		return connectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnection_Comment() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnection_Destination() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnection_Dx1() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnection_Dx2() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnection_Dy() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnection_Source() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataConnections() {
		return dataConnectionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataConnections_Connection() {
		return (EReference)dataConnectionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDevice() {
		return deviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDevice_Parameter() {
		return (EReference)deviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDevice_Resource() {
		return (EReference)deviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDevice_FBNetwork() {
		return (EReference)deviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_Comment() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_Name() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_Type() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_X() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_Y() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeviceType() {
		return deviceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceType_Identification() {
		return (EReference)deviceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceType_VersionInfo() {
		return (EReference)deviceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceType_CompilerInfo() {
		return (EReference)deviceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceType_VarDeclaration() {
		return (EReference)deviceTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceType_ResourceTypeName() {
		return (EReference)deviceTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceType_Resource() {
		return (EReference)deviceTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceType_FBNetwork() {
		return (EReference)deviceTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeviceType_Comment() {
		return (EAttribute)deviceTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeviceType_Name() {
		return (EAttribute)deviceTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_AdapterConnections() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_AdapterDeclaration() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_AdapterType() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Algorithm() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Application() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_BasicFB() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Compiler() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CompilerInfo() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Connection() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_DataConnections() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Device() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_DeviceType() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ECAction() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ECC() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ECState() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ECTransition() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Event() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_EventConnections() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_EventInputs() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_EventOutputs() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_FB() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_FBD() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_FBNetwork() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_FBType() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_FBTypeName() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_HCECC() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_HCECCRelation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Identification() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_InputPrimitive() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_InputVars() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_InterfaceList() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_InternalVars() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_LD() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Link() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Mapping() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Other() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_OutputPrimitive() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_OutputVars() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Parameter() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Plugs() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Resource() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ResourceType() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ResourceTypeName() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Rung() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Segment() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Service() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ServiceSequence() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ServiceTransaction() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Sockets() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ST() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SubApp() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SubAppEvent() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SubAppEventInputs() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SubAppEventOutputs() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SubAppInterfaceList() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SubAppNetwork() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SubAppType() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_System() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_VarDeclaration() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_VersionInfo() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_With() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECAction() {
		return ecActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECAction_Algorithm() {
		return (EAttribute)ecActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECAction_Output() {
		return (EAttribute)ecActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECC() {
		return eccEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getECC_ECState() {
		return (EReference)eccEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getECC_ECTransition() {
		return (EReference)eccEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECC_Name() {
		return (EAttribute)eccEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECState() {
		return ecStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getECState_ECAction() {
		return (EReference)ecStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECState_Comment() {
		return (EAttribute)ecStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECState_Name() {
		return (EAttribute)ecStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECState_X() {
		return (EAttribute)ecStateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECState_Y() {
		return (EAttribute)ecStateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECTransition() {
		return ecTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECTransition_Comment() {
		return (EAttribute)ecTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECTransition_Condition() {
		return (EAttribute)ecTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECTransition_Destination() {
		return (EAttribute)ecTransitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECTransition_Source() {
		return (EAttribute)ecTransitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECTransition_X() {
		return (EAttribute)ecTransitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECTransition_Y() {
		return (EAttribute)ecTransitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventConnections() {
		return eventConnectionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventConnections_Connection() {
		return (EReference)eventConnectionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventInputs() {
		return eventInputsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventInputs_Event() {
		return (EReference)eventInputsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventOutputs() {
		return eventOutputsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventOutputs_Event() {
		return (EReference)eventOutputsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_With() {
		return (EReference)eventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Comment() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Name() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Type() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFBD() {
		return fbdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBD_FB() {
		return (EReference)fbdEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBD_DataConnections() {
		return (EReference)fbdEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFBNetwork() {
		return fbNetworkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFBNetwork_Mixed() {
		return (EAttribute)fbNetworkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBNetwork_FB() {
		return (EReference)fbNetworkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBNetwork_EventConnections() {
		return (EReference)fbNetworkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBNetwork_DataConnections() {
		return (EReference)fbNetworkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBNetwork_AdapterConnections() {
		return (EReference)fbNetworkEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFB() {
		return fbEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFB_Parameter() {
		return (EReference)fbEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFB_Comment() {
		return (EAttribute)fbEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFB_Name() {
		return (EAttribute)fbEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFB_Type() {
		return (EAttribute)fbEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFB_X() {
		return (EAttribute)fbEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFB_Y() {
		return (EAttribute)fbEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFBTypeName() {
		return fbTypeNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFBTypeName_Name() {
		return (EAttribute)fbTypeNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFBType() {
		return fbTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBType_Identification() {
		return (EReference)fbTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBType_VersionInfo() {
		return (EReference)fbTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBType_CompilerInfo() {
		return (EReference)fbTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBType_InterfaceList() {
		return (EReference)fbTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBType_BasicFB() {
		return (EReference)fbTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBType_FBNetwork() {
		return (EReference)fbTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBType_Service() {
		return (EReference)fbTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFBType_Comment() {
		return (EAttribute)fbTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFBType_Name() {
		return (EAttribute)fbTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHCECCRelation() {
		return hceccRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHCECCRelation_Comment() {
		return (EAttribute)hceccRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHCECCRelation_Destination() {
		return (EAttribute)hceccRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHCECCRelation_Relation() {
		return (EAttribute)hceccRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHCECCRelation_Source() {
		return (EAttribute)hceccRelationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHCECC() {
		return hceccEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHCECC_Group() {
		return (EAttribute)hceccEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHCECC_ECC() {
		return (EReference)hceccEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHCECC_HCECCRelation() {
		return (EReference)hceccEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentification() {
		return identificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentification_ApplicationDomain() {
		return (EAttribute)identificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentification_Classification() {
		return (EAttribute)identificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentification_Description() {
		return (EAttribute)identificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentification_Function() {
		return (EAttribute)identificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentification_Standard() {
		return (EAttribute)identificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentification_Type() {
		return (EAttribute)identificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputPrimitive() {
		return inputPrimitiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputPrimitive_Event() {
		return (EAttribute)inputPrimitiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputPrimitive_Interface() {
		return (EAttribute)inputPrimitiveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputPrimitive_Parameters() {
		return (EAttribute)inputPrimitiveEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputVars() {
		return inputVarsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputVars_VarDeclaration() {
		return (EReference)inputVarsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceList() {
		return interfaceListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceList_Mixed() {
		return (EAttribute)interfaceListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceList_EventInputs() {
		return (EReference)interfaceListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceList_EventOutputs() {
		return (EReference)interfaceListEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceList_InputVars() {
		return (EReference)interfaceListEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceList_OutputVars() {
		return (EReference)interfaceListEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceList_Sockets() {
		return (EReference)interfaceListEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceList_Plugs() {
		return (EReference)interfaceListEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalVars() {
		return internalVarsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalVars_VarDeclaration() {
		return (EReference)internalVarsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLD() {
		return ldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLD_Rung() {
		return (EReference)ldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink() {
		return linkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Parameter() {
		return (EReference)linkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Comment() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_CommResource() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_SegmentName() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapping_From() {
		return (EAttribute)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapping_To() {
		return (EAttribute)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOther() {
		return otherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOther_Language() {
		return (EAttribute)otherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOther_Prototype() {
		return (EAttribute)otherEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOther_Text() {
		return (EAttribute)otherEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputPrimitive() {
		return outputPrimitiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutputPrimitive_Event() {
		return (EAttribute)outputPrimitiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutputPrimitive_Interface() {
		return (EAttribute)outputPrimitiveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutputPrimitive_Parameters() {
		return (EAttribute)outputPrimitiveEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputVars() {
		return outputVarsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputVars_VarDeclaration() {
		return (EReference)outputVarsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Comment() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Name() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Value() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlugs() {
		return plugsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlugs_AdapterDeclaration() {
		return (EReference)plugsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResource_Parameter() {
		return (EReference)resourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResource_FBNetwork() {
		return (EReference)resourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Comment() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Name() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Type() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_X() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Y() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceTypeName() {
		return resourceTypeNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceTypeName_Name() {
		return (EAttribute)resourceTypeNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceType() {
		return resourceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceType_Identification() {
		return (EReference)resourceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceType_VersionInfo() {
		return (EReference)resourceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceType_CompilerInfo() {
		return (EReference)resourceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceType_FBTypeName() {
		return (EReference)resourceTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceType_VarDeclaration() {
		return (EReference)resourceTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceType_FBNetwork() {
		return (EReference)resourceTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceType_Comment() {
		return (EAttribute)resourceTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceType_Name() {
		return (EAttribute)resourceTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRung() {
		return rungEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRung_Comment() {
		return (EAttribute)rungEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRung_Expression() {
		return (EAttribute)rungEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRung_Output() {
		return (EAttribute)rungEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSegment() {
		return segmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSegment_Parameter() {
		return (EReference)segmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSegment_Comment() {
		return (EAttribute)segmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSegment_Dx1() {
		return (EAttribute)segmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSegment_Name() {
		return (EAttribute)segmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSegment_Type() {
		return (EAttribute)segmentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSegment_X() {
		return (EAttribute)segmentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSegment_Y() {
		return (EAttribute)segmentEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceSequence() {
		return serviceSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceSequence_ServiceTransaction() {
		return (EReference)serviceSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceSequence_Comment() {
		return (EAttribute)serviceSequenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceSequence_Name() {
		return (EAttribute)serviceSequenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceTransaction() {
		return serviceTransactionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceTransaction_Mixed() {
		return (EAttribute)serviceTransactionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceTransaction_InputPrimitive() {
		return (EReference)serviceTransactionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceTransaction_OutputPrimitive() {
		return (EReference)serviceTransactionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_ServiceSequence() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Comment() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_LeftInterface() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_RightInterface() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSockets() {
		return socketsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSockets_AdapterDeclaration() {
		return (EReference)socketsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getST() {
		return stEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getST_Text() {
		return (EAttribute)stEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubAppEventInputs() {
		return subAppEventInputsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAppEventInputs_SubAppEvent() {
		return (EReference)subAppEventInputsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubAppEventOutputs() {
		return subAppEventOutputsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAppEventOutputs_SubAppEvent() {
		return (EReference)subAppEventOutputsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubAppEvent() {
		return subAppEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubAppEvent_Comment() {
		return (EAttribute)subAppEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubAppEvent_Name() {
		return (EAttribute)subAppEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubAppEvent_Type() {
		return (EAttribute)subAppEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubAppInterfaceList() {
		return subAppInterfaceListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAppInterfaceList_SubAppEventInputs() {
		return (EReference)subAppInterfaceListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAppInterfaceList_SubAppEventOutputs() {
		return (EReference)subAppInterfaceListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAppInterfaceList_InputVars() {
		return (EReference)subAppInterfaceListEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAppInterfaceList_OutputVars() {
		return (EReference)subAppInterfaceListEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubAppNetwork() {
		return subAppNetworkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAppNetwork_SubApp() {
		return (EReference)subAppNetworkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAppNetwork_FB() {
		return (EReference)subAppNetworkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAppNetwork_EventConnections() {
		return (EReference)subAppNetworkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAppNetwork_DataConnections() {
		return (EReference)subAppNetworkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubApp() {
		return subAppEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubApp_Comment() {
		return (EAttribute)subAppEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubApp_Name() {
		return (EAttribute)subAppEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubApp_Type() {
		return (EAttribute)subAppEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubApp_X() {
		return (EAttribute)subAppEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubApp_Y() {
		return (EAttribute)subAppEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubAppType() {
		return subAppTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAppType_Identification() {
		return (EReference)subAppTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAppType_VersionInfo() {
		return (EReference)subAppTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAppType_CompilerInfo() {
		return (EReference)subAppTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAppType_SubAppInterfaceList() {
		return (EReference)subAppTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubAppType_SubAppNetwork() {
		return (EReference)subAppTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubAppType_Comment() {
		return (EAttribute)subAppTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubAppType_Name() {
		return (EAttribute)subAppTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystem() {
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Identification() {
		return (EReference)systemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_VersionInfo() {
		return (EReference)systemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Application() {
		return (EReference)systemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Device() {
		return (EReference)systemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Mapping() {
		return (EReference)systemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Segment() {
		return (EReference)systemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Link() {
		return (EReference)systemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystem_Comment() {
		return (EAttribute)systemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystem_Name() {
		return (EAttribute)systemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVarDeclaration() {
		return varDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVarDeclaration_ArraySize() {
		return (EAttribute)varDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVarDeclaration_Comment() {
		return (EAttribute)varDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVarDeclaration_InitialValue() {
		return (EAttribute)varDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVarDeclaration_Name() {
		return (EAttribute)varDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVarDeclaration_Type() {
		return (EAttribute)varDeclarationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersionInfo() {
		return versionInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionInfo_Author() {
		return (EAttribute)versionInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionInfo_Date() {
		return (EAttribute)versionInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionInfo_Organization() {
		return (EAttribute)versionInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionInfo_Remarks() {
		return (EAttribute)versionInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionInfo_Version() {
		return (EAttribute)versionInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWith() {
		return withEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWith_Var() {
		return (EAttribute)withEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLanguage() {
		return languageEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLanguageObject() {
		return languageObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionblockFactory getFunctionblockFactory() {
		return (FunctionblockFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		adapterConnectionsEClass = createEClass(ADAPTER_CONNECTIONS);
		createEReference(adapterConnectionsEClass, ADAPTER_CONNECTIONS__CONNECTION);

		adapterDeclarationEClass = createEClass(ADAPTER_DECLARATION);
		createEReference(adapterDeclarationEClass, ADAPTER_DECLARATION__PARAMETER);
		createEAttribute(adapterDeclarationEClass, ADAPTER_DECLARATION__COMMENT);
		createEAttribute(adapterDeclarationEClass, ADAPTER_DECLARATION__NAME);
		createEAttribute(adapterDeclarationEClass, ADAPTER_DECLARATION__TYPE);

		adapterTypeEClass = createEClass(ADAPTER_TYPE);
		createEReference(adapterTypeEClass, ADAPTER_TYPE__IDENTIFICATION);
		createEReference(adapterTypeEClass, ADAPTER_TYPE__VERSION_INFO);
		createEReference(adapterTypeEClass, ADAPTER_TYPE__COMPILER_INFO);
		createEReference(adapterTypeEClass, ADAPTER_TYPE__INTERFACE_LIST);
		createEReference(adapterTypeEClass, ADAPTER_TYPE__SERVICE);
		createEAttribute(adapterTypeEClass, ADAPTER_TYPE__COMMENT);
		createEAttribute(adapterTypeEClass, ADAPTER_TYPE__NAME);

		algorithmEClass = createEClass(ALGORITHM);
		createEReference(algorithmEClass, ALGORITHM__FBD);
		createEReference(algorithmEClass, ALGORITHM__ST);
		createEReference(algorithmEClass, ALGORITHM__LD);
		createEReference(algorithmEClass, ALGORITHM__OTHER);
		createEAttribute(algorithmEClass, ALGORITHM__COMMENT);
		createEAttribute(algorithmEClass, ALGORITHM__NAME);

		applicationEClass = createEClass(APPLICATION);
		createEReference(applicationEClass, APPLICATION__FB_NETWORK);
		createEAttribute(applicationEClass, APPLICATION__COMMENT);
		createEAttribute(applicationEClass, APPLICATION__NAME);

		basicFBEClass = createEClass(BASIC_FB);
		createEReference(basicFBEClass, BASIC_FB__INTERNAL_VARS);
		createEReference(basicFBEClass, BASIC_FB__ECC);
		createEReference(basicFBEClass, BASIC_FB__HCECC);
		createEReference(basicFBEClass, BASIC_FB__ALGORITHM);

		compilerInfoEClass = createEClass(COMPILER_INFO);
		createEReference(compilerInfoEClass, COMPILER_INFO__COMPILER);
		createEAttribute(compilerInfoEClass, COMPILER_INFO__CLASSDEF);
		createEAttribute(compilerInfoEClass, COMPILER_INFO__HEADER);

		compilerEClass = createEClass(COMPILER);
		createEAttribute(compilerEClass, COMPILER__LANGUAGE);
		createEAttribute(compilerEClass, COMPILER__PRODUCT);
		createEAttribute(compilerEClass, COMPILER__VENDOR);
		createEAttribute(compilerEClass, COMPILER__VERSION);

		connectionEClass = createEClass(CONNECTION);
		createEAttribute(connectionEClass, CONNECTION__COMMENT);
		createEAttribute(connectionEClass, CONNECTION__DESTINATION);
		createEAttribute(connectionEClass, CONNECTION__DX1);
		createEAttribute(connectionEClass, CONNECTION__DX2);
		createEAttribute(connectionEClass, CONNECTION__DY);
		createEAttribute(connectionEClass, CONNECTION__SOURCE);

		dataConnectionsEClass = createEClass(DATA_CONNECTIONS);
		createEReference(dataConnectionsEClass, DATA_CONNECTIONS__CONNECTION);

		deviceEClass = createEClass(DEVICE);
		createEReference(deviceEClass, DEVICE__PARAMETER);
		createEReference(deviceEClass, DEVICE__RESOURCE);
		createEReference(deviceEClass, DEVICE__FB_NETWORK);
		createEAttribute(deviceEClass, DEVICE__COMMENT);
		createEAttribute(deviceEClass, DEVICE__NAME);
		createEAttribute(deviceEClass, DEVICE__TYPE);
		createEAttribute(deviceEClass, DEVICE__X);
		createEAttribute(deviceEClass, DEVICE__Y);

		deviceTypeEClass = createEClass(DEVICE_TYPE);
		createEReference(deviceTypeEClass, DEVICE_TYPE__IDENTIFICATION);
		createEReference(deviceTypeEClass, DEVICE_TYPE__VERSION_INFO);
		createEReference(deviceTypeEClass, DEVICE_TYPE__COMPILER_INFO);
		createEReference(deviceTypeEClass, DEVICE_TYPE__VAR_DECLARATION);
		createEReference(deviceTypeEClass, DEVICE_TYPE__RESOURCE_TYPE_NAME);
		createEReference(deviceTypeEClass, DEVICE_TYPE__RESOURCE);
		createEReference(deviceTypeEClass, DEVICE_TYPE__FB_NETWORK);
		createEAttribute(deviceTypeEClass, DEVICE_TYPE__COMMENT);
		createEAttribute(deviceTypeEClass, DEVICE_TYPE__NAME);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ADAPTER_CONNECTIONS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ADAPTER_DECLARATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ADAPTER_TYPE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ALGORITHM);
		createEReference(documentRootEClass, DOCUMENT_ROOT__APPLICATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__BASIC_FB);
		createEReference(documentRootEClass, DOCUMENT_ROOT__COMPILER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__COMPILER_INFO);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CONNECTION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DATA_CONNECTIONS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DEVICE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DEVICE_TYPE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EC_ACTION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ECC);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EC_STATE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EC_TRANSITION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EVENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EVENT_CONNECTIONS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EVENT_INPUTS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EVENT_OUTPUTS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FB);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FBD);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FB_NETWORK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FB_TYPE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FB_TYPE_NAME);
		createEReference(documentRootEClass, DOCUMENT_ROOT__HCECC);
		createEReference(documentRootEClass, DOCUMENT_ROOT__HCECC_RELATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__IDENTIFICATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__INPUT_PRIMITIVE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__INPUT_VARS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__INTERFACE_LIST);
		createEReference(documentRootEClass, DOCUMENT_ROOT__INTERNAL_VARS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__LD);
		createEReference(documentRootEClass, DOCUMENT_ROOT__LINK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__MAPPING);
		createEReference(documentRootEClass, DOCUMENT_ROOT__OTHER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__OUTPUT_PRIMITIVE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__OUTPUT_VARS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PARAMETER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PLUGS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RESOURCE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RESOURCE_TYPE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RESOURCE_TYPE_NAME);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RUNG);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SEGMENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SERVICE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SERVICE_SEQUENCE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SERVICE_TRANSACTION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SOCKETS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ST);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SUB_APP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SUB_APP_EVENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SUB_APP_EVENT_INPUTS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SUB_APP_EVENT_OUTPUTS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SUB_APP_INTERFACE_LIST);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SUB_APP_NETWORK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SUB_APP_TYPE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SYSTEM);
		createEReference(documentRootEClass, DOCUMENT_ROOT__VAR_DECLARATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__VERSION_INFO);
		createEReference(documentRootEClass, DOCUMENT_ROOT__WITH);

		ecActionEClass = createEClass(EC_ACTION);
		createEAttribute(ecActionEClass, EC_ACTION__ALGORITHM);
		createEAttribute(ecActionEClass, EC_ACTION__OUTPUT);

		eccEClass = createEClass(ECC);
		createEReference(eccEClass, ECC__EC_STATE);
		createEReference(eccEClass, ECC__EC_TRANSITION);
		createEAttribute(eccEClass, ECC__NAME);

		ecStateEClass = createEClass(EC_STATE);
		createEReference(ecStateEClass, EC_STATE__EC_ACTION);
		createEAttribute(ecStateEClass, EC_STATE__COMMENT);
		createEAttribute(ecStateEClass, EC_STATE__NAME);
		createEAttribute(ecStateEClass, EC_STATE__X);
		createEAttribute(ecStateEClass, EC_STATE__Y);

		ecTransitionEClass = createEClass(EC_TRANSITION);
		createEAttribute(ecTransitionEClass, EC_TRANSITION__COMMENT);
		createEAttribute(ecTransitionEClass, EC_TRANSITION__CONDITION);
		createEAttribute(ecTransitionEClass, EC_TRANSITION__DESTINATION);
		createEAttribute(ecTransitionEClass, EC_TRANSITION__SOURCE);
		createEAttribute(ecTransitionEClass, EC_TRANSITION__X);
		createEAttribute(ecTransitionEClass, EC_TRANSITION__Y);

		eventConnectionsEClass = createEClass(EVENT_CONNECTIONS);
		createEReference(eventConnectionsEClass, EVENT_CONNECTIONS__CONNECTION);

		eventInputsEClass = createEClass(EVENT_INPUTS);
		createEReference(eventInputsEClass, EVENT_INPUTS__EVENT);

		eventOutputsEClass = createEClass(EVENT_OUTPUTS);
		createEReference(eventOutputsEClass, EVENT_OUTPUTS__EVENT);

		eventEClass = createEClass(EVENT);
		createEReference(eventEClass, EVENT__WITH);
		createEAttribute(eventEClass, EVENT__COMMENT);
		createEAttribute(eventEClass, EVENT__NAME);
		createEAttribute(eventEClass, EVENT__TYPE);

		fbdEClass = createEClass(FBD);
		createEReference(fbdEClass, FBD__FB);
		createEReference(fbdEClass, FBD__DATA_CONNECTIONS);

		fbNetworkEClass = createEClass(FB_NETWORK);
		createEAttribute(fbNetworkEClass, FB_NETWORK__MIXED);
		createEReference(fbNetworkEClass, FB_NETWORK__FB);
		createEReference(fbNetworkEClass, FB_NETWORK__EVENT_CONNECTIONS);
		createEReference(fbNetworkEClass, FB_NETWORK__DATA_CONNECTIONS);
		createEReference(fbNetworkEClass, FB_NETWORK__ADAPTER_CONNECTIONS);

		fbEClass = createEClass(FB);
		createEReference(fbEClass, FB__PARAMETER);
		createEAttribute(fbEClass, FB__COMMENT);
		createEAttribute(fbEClass, FB__NAME);
		createEAttribute(fbEClass, FB__TYPE);
		createEAttribute(fbEClass, FB__X);
		createEAttribute(fbEClass, FB__Y);

		fbTypeNameEClass = createEClass(FB_TYPE_NAME);
		createEAttribute(fbTypeNameEClass, FB_TYPE_NAME__NAME);

		fbTypeEClass = createEClass(FB_TYPE);
		createEReference(fbTypeEClass, FB_TYPE__IDENTIFICATION);
		createEReference(fbTypeEClass, FB_TYPE__VERSION_INFO);
		createEReference(fbTypeEClass, FB_TYPE__COMPILER_INFO);
		createEReference(fbTypeEClass, FB_TYPE__INTERFACE_LIST);
		createEReference(fbTypeEClass, FB_TYPE__BASIC_FB);
		createEReference(fbTypeEClass, FB_TYPE__FB_NETWORK);
		createEReference(fbTypeEClass, FB_TYPE__SERVICE);
		createEAttribute(fbTypeEClass, FB_TYPE__COMMENT);
		createEAttribute(fbTypeEClass, FB_TYPE__NAME);

		hceccRelationEClass = createEClass(HCECC_RELATION);
		createEAttribute(hceccRelationEClass, HCECC_RELATION__COMMENT);
		createEAttribute(hceccRelationEClass, HCECC_RELATION__DESTINATION);
		createEAttribute(hceccRelationEClass, HCECC_RELATION__RELATION);
		createEAttribute(hceccRelationEClass, HCECC_RELATION__SOURCE);

		hceccEClass = createEClass(HCECC);
		createEAttribute(hceccEClass, HCECC__GROUP);
		createEReference(hceccEClass, HCECC__ECC);
		createEReference(hceccEClass, HCECC__HCECC_RELATION);

		identificationEClass = createEClass(IDENTIFICATION);
		createEAttribute(identificationEClass, IDENTIFICATION__APPLICATION_DOMAIN);
		createEAttribute(identificationEClass, IDENTIFICATION__CLASSIFICATION);
		createEAttribute(identificationEClass, IDENTIFICATION__DESCRIPTION);
		createEAttribute(identificationEClass, IDENTIFICATION__FUNCTION);
		createEAttribute(identificationEClass, IDENTIFICATION__STANDARD);
		createEAttribute(identificationEClass, IDENTIFICATION__TYPE);

		inputPrimitiveEClass = createEClass(INPUT_PRIMITIVE);
		createEAttribute(inputPrimitiveEClass, INPUT_PRIMITIVE__EVENT);
		createEAttribute(inputPrimitiveEClass, INPUT_PRIMITIVE__INTERFACE);
		createEAttribute(inputPrimitiveEClass, INPUT_PRIMITIVE__PARAMETERS);

		inputVarsEClass = createEClass(INPUT_VARS);
		createEReference(inputVarsEClass, INPUT_VARS__VAR_DECLARATION);

		interfaceListEClass = createEClass(INTERFACE_LIST);
		createEAttribute(interfaceListEClass, INTERFACE_LIST__MIXED);
		createEReference(interfaceListEClass, INTERFACE_LIST__EVENT_INPUTS);
		createEReference(interfaceListEClass, INTERFACE_LIST__EVENT_OUTPUTS);
		createEReference(interfaceListEClass, INTERFACE_LIST__INPUT_VARS);
		createEReference(interfaceListEClass, INTERFACE_LIST__OUTPUT_VARS);
		createEReference(interfaceListEClass, INTERFACE_LIST__SOCKETS);
		createEReference(interfaceListEClass, INTERFACE_LIST__PLUGS);

		internalVarsEClass = createEClass(INTERNAL_VARS);
		createEReference(internalVarsEClass, INTERNAL_VARS__VAR_DECLARATION);

		ldEClass = createEClass(LD);
		createEReference(ldEClass, LD__RUNG);

		linkEClass = createEClass(LINK);
		createEReference(linkEClass, LINK__PARAMETER);
		createEAttribute(linkEClass, LINK__COMMENT);
		createEAttribute(linkEClass, LINK__COMM_RESOURCE);
		createEAttribute(linkEClass, LINK__SEGMENT_NAME);

		mappingEClass = createEClass(MAPPING);
		createEAttribute(mappingEClass, MAPPING__FROM);
		createEAttribute(mappingEClass, MAPPING__TO);

		otherEClass = createEClass(OTHER);
		createEAttribute(otherEClass, OTHER__LANGUAGE);
		createEAttribute(otherEClass, OTHER__PROTOTYPE);
		createEAttribute(otherEClass, OTHER__TEXT);

		outputPrimitiveEClass = createEClass(OUTPUT_PRIMITIVE);
		createEAttribute(outputPrimitiveEClass, OUTPUT_PRIMITIVE__EVENT);
		createEAttribute(outputPrimitiveEClass, OUTPUT_PRIMITIVE__INTERFACE);
		createEAttribute(outputPrimitiveEClass, OUTPUT_PRIMITIVE__PARAMETERS);

		outputVarsEClass = createEClass(OUTPUT_VARS);
		createEReference(outputVarsEClass, OUTPUT_VARS__VAR_DECLARATION);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__COMMENT);
		createEAttribute(parameterEClass, PARAMETER__NAME);
		createEAttribute(parameterEClass, PARAMETER__VALUE);

		plugsEClass = createEClass(PLUGS);
		createEReference(plugsEClass, PLUGS__ADAPTER_DECLARATION);

		resourceEClass = createEClass(RESOURCE);
		createEReference(resourceEClass, RESOURCE__PARAMETER);
		createEReference(resourceEClass, RESOURCE__FB_NETWORK);
		createEAttribute(resourceEClass, RESOURCE__COMMENT);
		createEAttribute(resourceEClass, RESOURCE__NAME);
		createEAttribute(resourceEClass, RESOURCE__TYPE);
		createEAttribute(resourceEClass, RESOURCE__X);
		createEAttribute(resourceEClass, RESOURCE__Y);

		resourceTypeNameEClass = createEClass(RESOURCE_TYPE_NAME);
		createEAttribute(resourceTypeNameEClass, RESOURCE_TYPE_NAME__NAME);

		resourceTypeEClass = createEClass(RESOURCE_TYPE);
		createEReference(resourceTypeEClass, RESOURCE_TYPE__IDENTIFICATION);
		createEReference(resourceTypeEClass, RESOURCE_TYPE__VERSION_INFO);
		createEReference(resourceTypeEClass, RESOURCE_TYPE__COMPILER_INFO);
		createEReference(resourceTypeEClass, RESOURCE_TYPE__FB_TYPE_NAME);
		createEReference(resourceTypeEClass, RESOURCE_TYPE__VAR_DECLARATION);
		createEReference(resourceTypeEClass, RESOURCE_TYPE__FB_NETWORK);
		createEAttribute(resourceTypeEClass, RESOURCE_TYPE__COMMENT);
		createEAttribute(resourceTypeEClass, RESOURCE_TYPE__NAME);

		rungEClass = createEClass(RUNG);
		createEAttribute(rungEClass, RUNG__COMMENT);
		createEAttribute(rungEClass, RUNG__EXPRESSION);
		createEAttribute(rungEClass, RUNG__OUTPUT);

		segmentEClass = createEClass(SEGMENT);
		createEReference(segmentEClass, SEGMENT__PARAMETER);
		createEAttribute(segmentEClass, SEGMENT__COMMENT);
		createEAttribute(segmentEClass, SEGMENT__DX1);
		createEAttribute(segmentEClass, SEGMENT__NAME);
		createEAttribute(segmentEClass, SEGMENT__TYPE);
		createEAttribute(segmentEClass, SEGMENT__X);
		createEAttribute(segmentEClass, SEGMENT__Y);

		serviceSequenceEClass = createEClass(SERVICE_SEQUENCE);
		createEReference(serviceSequenceEClass, SERVICE_SEQUENCE__SERVICE_TRANSACTION);
		createEAttribute(serviceSequenceEClass, SERVICE_SEQUENCE__COMMENT);
		createEAttribute(serviceSequenceEClass, SERVICE_SEQUENCE__NAME);

		serviceTransactionEClass = createEClass(SERVICE_TRANSACTION);
		createEAttribute(serviceTransactionEClass, SERVICE_TRANSACTION__MIXED);
		createEReference(serviceTransactionEClass, SERVICE_TRANSACTION__INPUT_PRIMITIVE);
		createEReference(serviceTransactionEClass, SERVICE_TRANSACTION__OUTPUT_PRIMITIVE);

		serviceEClass = createEClass(SERVICE);
		createEReference(serviceEClass, SERVICE__SERVICE_SEQUENCE);
		createEAttribute(serviceEClass, SERVICE__COMMENT);
		createEAttribute(serviceEClass, SERVICE__LEFT_INTERFACE);
		createEAttribute(serviceEClass, SERVICE__RIGHT_INTERFACE);

		socketsEClass = createEClass(SOCKETS);
		createEReference(socketsEClass, SOCKETS__ADAPTER_DECLARATION);

		stEClass = createEClass(ST);
		createEAttribute(stEClass, ST__TEXT);

		subAppEventInputsEClass = createEClass(SUB_APP_EVENT_INPUTS);
		createEReference(subAppEventInputsEClass, SUB_APP_EVENT_INPUTS__SUB_APP_EVENT);

		subAppEventOutputsEClass = createEClass(SUB_APP_EVENT_OUTPUTS);
		createEReference(subAppEventOutputsEClass, SUB_APP_EVENT_OUTPUTS__SUB_APP_EVENT);

		subAppEventEClass = createEClass(SUB_APP_EVENT);
		createEAttribute(subAppEventEClass, SUB_APP_EVENT__COMMENT);
		createEAttribute(subAppEventEClass, SUB_APP_EVENT__NAME);
		createEAttribute(subAppEventEClass, SUB_APP_EVENT__TYPE);

		subAppInterfaceListEClass = createEClass(SUB_APP_INTERFACE_LIST);
		createEReference(subAppInterfaceListEClass, SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_INPUTS);
		createEReference(subAppInterfaceListEClass, SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_OUTPUTS);
		createEReference(subAppInterfaceListEClass, SUB_APP_INTERFACE_LIST__INPUT_VARS);
		createEReference(subAppInterfaceListEClass, SUB_APP_INTERFACE_LIST__OUTPUT_VARS);

		subAppNetworkEClass = createEClass(SUB_APP_NETWORK);
		createEReference(subAppNetworkEClass, SUB_APP_NETWORK__SUB_APP);
		createEReference(subAppNetworkEClass, SUB_APP_NETWORK__FB);
		createEReference(subAppNetworkEClass, SUB_APP_NETWORK__EVENT_CONNECTIONS);
		createEReference(subAppNetworkEClass, SUB_APP_NETWORK__DATA_CONNECTIONS);

		subAppEClass = createEClass(SUB_APP);
		createEAttribute(subAppEClass, SUB_APP__COMMENT);
		createEAttribute(subAppEClass, SUB_APP__NAME);
		createEAttribute(subAppEClass, SUB_APP__TYPE);
		createEAttribute(subAppEClass, SUB_APP__X);
		createEAttribute(subAppEClass, SUB_APP__Y);

		subAppTypeEClass = createEClass(SUB_APP_TYPE);
		createEReference(subAppTypeEClass, SUB_APP_TYPE__IDENTIFICATION);
		createEReference(subAppTypeEClass, SUB_APP_TYPE__VERSION_INFO);
		createEReference(subAppTypeEClass, SUB_APP_TYPE__COMPILER_INFO);
		createEReference(subAppTypeEClass, SUB_APP_TYPE__SUB_APP_INTERFACE_LIST);
		createEReference(subAppTypeEClass, SUB_APP_TYPE__SUB_APP_NETWORK);
		createEAttribute(subAppTypeEClass, SUB_APP_TYPE__COMMENT);
		createEAttribute(subAppTypeEClass, SUB_APP_TYPE__NAME);

		systemEClass = createEClass(SYSTEM);
		createEReference(systemEClass, SYSTEM__IDENTIFICATION);
		createEReference(systemEClass, SYSTEM__VERSION_INFO);
		createEReference(systemEClass, SYSTEM__APPLICATION);
		createEReference(systemEClass, SYSTEM__DEVICE);
		createEReference(systemEClass, SYSTEM__MAPPING);
		createEReference(systemEClass, SYSTEM__SEGMENT);
		createEReference(systemEClass, SYSTEM__LINK);
		createEAttribute(systemEClass, SYSTEM__COMMENT);
		createEAttribute(systemEClass, SYSTEM__NAME);

		varDeclarationEClass = createEClass(VAR_DECLARATION);
		createEAttribute(varDeclarationEClass, VAR_DECLARATION__ARRAY_SIZE);
		createEAttribute(varDeclarationEClass, VAR_DECLARATION__COMMENT);
		createEAttribute(varDeclarationEClass, VAR_DECLARATION__INITIAL_VALUE);
		createEAttribute(varDeclarationEClass, VAR_DECLARATION__NAME);
		createEAttribute(varDeclarationEClass, VAR_DECLARATION__TYPE);

		versionInfoEClass = createEClass(VERSION_INFO);
		createEAttribute(versionInfoEClass, VERSION_INFO__AUTHOR);
		createEAttribute(versionInfoEClass, VERSION_INFO__DATE);
		createEAttribute(versionInfoEClass, VERSION_INFO__ORGANIZATION);
		createEAttribute(versionInfoEClass, VERSION_INFO__REMARKS);
		createEAttribute(versionInfoEClass, VERSION_INFO__VERSION);

		withEClass = createEClass(WITH);
		createEAttribute(withEClass, WITH__VAR);

		// Create enums
		languageEEnum = createEEnum(LANGUAGE);

		// Create data types
		languageObjectEDataType = createEDataType(LANGUAGE_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(adapterConnectionsEClass, AdapterConnections.class, "AdapterConnections", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdapterConnections_Connection(), this.getConnection(), null, "connection", null, 1, -1, AdapterConnections.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adapterDeclarationEClass, AdapterDeclaration.class, "AdapterDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdapterDeclaration_Parameter(), this.getParameter(), null, "parameter", null, 0, -1, AdapterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdapterDeclaration_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, AdapterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdapterDeclaration_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, AdapterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdapterDeclaration_Type(), theXMLTypePackage.getString(), "type", null, 1, 1, AdapterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adapterTypeEClass, AdapterType.class, "AdapterType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdapterType_Identification(), this.getIdentification(), null, "identification", null, 0, 1, AdapterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdapterType_VersionInfo(), this.getVersionInfo(), null, "versionInfo", null, 1, -1, AdapterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdapterType_CompilerInfo(), this.getCompilerInfo(), null, "compilerInfo", null, 0, 1, AdapterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdapterType_InterfaceList(), this.getInterfaceList(), null, "interfaceList", null, 1, 1, AdapterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdapterType_Service(), this.getService(), null, "service", null, 0, 1, AdapterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdapterType_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, AdapterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdapterType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, AdapterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(algorithmEClass, Algorithm.class, "Algorithm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlgorithm_FBD(), this.getFBD(), null, "fBD", null, 0, 1, Algorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlgorithm_ST(), this.getST(), null, "sT", null, 0, 1, Algorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlgorithm_LD(), this.getLD(), null, "lD", null, 0, 1, Algorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlgorithm_Other(), this.getOther(), null, "other", null, 0, 1, Algorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlgorithm_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, Algorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlgorithm_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, Algorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(applicationEClass, Application.class, "Application", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplication_FBNetwork(), this.getFBNetwork(), null, "fBNetwork", null, 1, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplication_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplication_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(basicFBEClass, BasicFB.class, "BasicFB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicFB_InternalVars(), this.getInternalVars(), null, "internalVars", null, 0, 1, BasicFB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicFB_ECC(), this.getECC(), null, "eCC", null, 0, 1, BasicFB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicFB_HCECC(), this.getHCECC(), null, "hCECC", null, 0, 1, BasicFB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicFB_Algorithm(), this.getAlgorithm(), null, "algorithm", null, 0, -1, BasicFB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compilerInfoEClass, CompilerInfo.class, "CompilerInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompilerInfo_Compiler(), this.getCompiler(), null, "compiler", null, 0, -1, CompilerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompilerInfo_Classdef(), theXMLTypePackage.getString(), "classdef", null, 0, 1, CompilerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompilerInfo_Header(), theXMLTypePackage.getString(), "header", null, 0, 1, CompilerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compilerEClass, de.cau.cs.kieler.functionblock.Compiler.class, "Compiler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompiler_Language(), this.getLanguage(), "language", null, 1, 1, de.cau.cs.kieler.functionblock.Compiler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompiler_Product(), theXMLTypePackage.getString(), "product", null, 1, 1, de.cau.cs.kieler.functionblock.Compiler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompiler_Vendor(), theXMLTypePackage.getString(), "vendor", null, 1, 1, de.cau.cs.kieler.functionblock.Compiler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompiler_Version(), theXMLTypePackage.getString(), "version", null, 1, 1, de.cau.cs.kieler.functionblock.Compiler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionEClass, Connection.class, "Connection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnection_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnection_Destination(), theXMLTypePackage.getString(), "destination", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnection_Dx1(), theXMLTypePackage.getString(), "dx1", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnection_Dx2(), theXMLTypePackage.getString(), "dx2", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnection_Dy(), theXMLTypePackage.getString(), "dy", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnection_Source(), theXMLTypePackage.getString(), "source", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataConnectionsEClass, DataConnections.class, "DataConnections", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataConnections_Connection(), this.getConnection(), null, "connection", null, 1, -1, DataConnections.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deviceEClass, Device.class, "Device", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDevice_Parameter(), this.getParameter(), null, "parameter", null, 0, -1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDevice_Resource(), this.getResource(), null, "resource", null, 0, -1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDevice_FBNetwork(), this.getFBNetwork(), null, "fBNetwork", null, 0, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDevice_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDevice_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDevice_Type(), theXMLTypePackage.getString(), "type", null, 1, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDevice_X(), theXMLTypePackage.getString(), "x", null, 0, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDevice_Y(), theXMLTypePackage.getString(), "y", null, 0, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deviceTypeEClass, DeviceType.class, "DeviceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeviceType_Identification(), this.getIdentification(), null, "identification", null, 0, 1, DeviceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeviceType_VersionInfo(), this.getVersionInfo(), null, "versionInfo", null, 1, -1, DeviceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeviceType_CompilerInfo(), this.getCompilerInfo(), null, "compilerInfo", null, 0, 1, DeviceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeviceType_VarDeclaration(), this.getVarDeclaration(), null, "varDeclaration", null, 0, -1, DeviceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeviceType_ResourceTypeName(), this.getResourceTypeName(), null, "resourceTypeName", null, 0, -1, DeviceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeviceType_Resource(), this.getResource(), null, "resource", null, 0, -1, DeviceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeviceType_FBNetwork(), this.getFBNetwork(), null, "fBNetwork", null, 0, 1, DeviceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeviceType_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, DeviceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeviceType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, DeviceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_AdapterConnections(), this.getAdapterConnections(), null, "adapterConnections", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_AdapterDeclaration(), this.getAdapterDeclaration(), null, "adapterDeclaration", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_AdapterType(), this.getAdapterType(), null, "adapterType", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Algorithm(), this.getAlgorithm(), null, "algorithm", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Application(), this.getApplication(), null, "application", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_BasicFB(), this.getBasicFB(), null, "basicFB", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Compiler(), this.getCompiler(), null, "compiler", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CompilerInfo(), this.getCompilerInfo(), null, "compilerInfo", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Connection(), this.getConnection(), null, "connection", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_DataConnections(), this.getDataConnections(), null, "dataConnections", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Device(), this.getDevice(), null, "device", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_DeviceType(), this.getDeviceType(), null, "deviceType", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ECAction(), this.getECAction(), null, "eCAction", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ECC(), this.getECC(), null, "eCC", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ECState(), this.getECState(), null, "eCState", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ECTransition(), this.getECTransition(), null, "eCTransition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Event(), this.getEvent(), null, "event", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_EventConnections(), this.getEventConnections(), null, "eventConnections", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_EventInputs(), this.getEventInputs(), null, "eventInputs", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_EventOutputs(), this.getEventOutputs(), null, "eventOutputs", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_FB(), this.getFB(), null, "fB", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_FBD(), this.getFBD(), null, "fBD", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_FBNetwork(), this.getFBNetwork(), null, "fBNetwork", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_FBType(), this.getFBType(), null, "fBType", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_FBTypeName(), this.getFBTypeName(), null, "fBTypeName", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_HCECC(), this.getHCECC(), null, "hCECC", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_HCECCRelation(), this.getHCECCRelation(), null, "hCECCRelation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Identification(), this.getIdentification(), null, "identification", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_InputPrimitive(), this.getInputPrimitive(), null, "inputPrimitive", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_InputVars(), this.getInputVars(), null, "inputVars", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_InterfaceList(), this.getInterfaceList(), null, "interfaceList", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_InternalVars(), this.getInternalVars(), null, "internalVars", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_LD(), this.getLD(), null, "lD", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Link(), this.getLink(), null, "link", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Mapping(), this.getMapping(), null, "mapping", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Other(), this.getOther(), null, "other", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_OutputPrimitive(), this.getOutputPrimitive(), null, "outputPrimitive", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_OutputVars(), this.getOutputVars(), null, "outputVars", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Parameter(), this.getParameter(), null, "parameter", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Plugs(), this.getPlugs(), null, "plugs", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Resource(), this.getResource(), null, "resource", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ResourceType(), this.getResourceType(), null, "resourceType", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ResourceTypeName(), this.getResourceTypeName(), null, "resourceTypeName", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Rung(), this.getRung(), null, "rung", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Segment(), this.getSegment(), null, "segment", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Service(), this.getService(), null, "service", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ServiceSequence(), this.getServiceSequence(), null, "serviceSequence", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ServiceTransaction(), this.getServiceTransaction(), null, "serviceTransaction", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Sockets(), this.getSockets(), null, "sockets", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ST(), this.getST(), null, "sT", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SubApp(), this.getSubApp(), null, "subApp", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SubAppEvent(), this.getSubAppEvent(), null, "subAppEvent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SubAppEventInputs(), this.getSubAppEventInputs(), null, "subAppEventInputs", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SubAppEventOutputs(), this.getSubAppEventOutputs(), null, "subAppEventOutputs", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SubAppInterfaceList(), this.getSubAppInterfaceList(), null, "subAppInterfaceList", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SubAppNetwork(), this.getSubAppNetwork(), null, "subAppNetwork", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SubAppType(), this.getSubAppType(), null, "subAppType", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_System(), this.getSystem(), null, "system", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_VarDeclaration(), this.getVarDeclaration(), null, "varDeclaration", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_VersionInfo(), this.getVersionInfo(), null, "versionInfo", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_With(), this.getWith(), null, "with", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(ecActionEClass, ECAction.class, "ECAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getECAction_Algorithm(), theXMLTypePackage.getString(), "algorithm", null, 0, 1, ECAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECAction_Output(), theXMLTypePackage.getString(), "output", null, 0, 1, ECAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eccEClass, de.cau.cs.kieler.functionblock.ECC.class, "ECC", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getECC_ECState(), this.getECState(), null, "eCState", null, 1, -1, de.cau.cs.kieler.functionblock.ECC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getECC_ECTransition(), this.getECTransition(), null, "eCTransition", null, 0, -1, de.cau.cs.kieler.functionblock.ECC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECC_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, de.cau.cs.kieler.functionblock.ECC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ecStateEClass, ECState.class, "ECState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getECState_ECAction(), this.getECAction(), null, "eCAction", null, 0, -1, ECState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECState_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, ECState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECState_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, ECState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECState_X(), theXMLTypePackage.getString(), "x", null, 0, 1, ECState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECState_Y(), theXMLTypePackage.getString(), "y", null, 0, 1, ECState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ecTransitionEClass, ECTransition.class, "ECTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getECTransition_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, ECTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECTransition_Condition(), theXMLTypePackage.getString(), "condition", null, 1, 1, ECTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECTransition_Destination(), theXMLTypePackage.getString(), "destination", null, 1, 1, ECTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECTransition_Source(), theXMLTypePackage.getString(), "source", null, 1, 1, ECTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECTransition_X(), theXMLTypePackage.getString(), "x", null, 0, 1, ECTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getECTransition_Y(), theXMLTypePackage.getString(), "y", null, 0, 1, ECTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventConnectionsEClass, EventConnections.class, "EventConnections", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventConnections_Connection(), this.getConnection(), null, "connection", null, 1, -1, EventConnections.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventInputsEClass, EventInputs.class, "EventInputs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventInputs_Event(), this.getEvent(), null, "event", null, 1, -1, EventInputs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventOutputsEClass, EventOutputs.class, "EventOutputs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventOutputs_Event(), this.getEvent(), null, "event", null, 1, -1, EventOutputs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvent_With(), this.getWith(), null, "with", null, 0, -1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fbdEClass, de.cau.cs.kieler.functionblock.FBD.class, "FBD", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFBD_FB(), this.getFB(), null, "fB", null, 1, -1, de.cau.cs.kieler.functionblock.FBD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFBD_DataConnections(), this.getDataConnections(), null, "dataConnections", null, 1, 1, de.cau.cs.kieler.functionblock.FBD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fbNetworkEClass, FBNetwork.class, "FBNetwork", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFBNetwork_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, FBNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFBNetwork_FB(), this.getFB(), null, "fB", null, 0, -1, FBNetwork.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFBNetwork_EventConnections(), this.getEventConnections(), null, "eventConnections", null, 0, 1, FBNetwork.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFBNetwork_DataConnections(), this.getDataConnections(), null, "dataConnections", null, 0, 1, FBNetwork.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFBNetwork_AdapterConnections(), this.getAdapterConnections(), null, "adapterConnections", null, 0, 1, FBNetwork.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(fbEClass, de.cau.cs.kieler.functionblock.FB.class, "FB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFB_Parameter(), this.getParameter(), null, "parameter", null, 0, -1, de.cau.cs.kieler.functionblock.FB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFB_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, de.cau.cs.kieler.functionblock.FB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFB_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, de.cau.cs.kieler.functionblock.FB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFB_Type(), theXMLTypePackage.getString(), "type", null, 1, 1, de.cau.cs.kieler.functionblock.FB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFB_X(), theXMLTypePackage.getString(), "x", null, 0, 1, de.cau.cs.kieler.functionblock.FB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFB_Y(), theXMLTypePackage.getString(), "y", null, 0, 1, de.cau.cs.kieler.functionblock.FB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fbTypeNameEClass, FBTypeName.class, "FBTypeName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFBTypeName_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, FBTypeName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fbTypeEClass, FBType.class, "FBType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFBType_Identification(), this.getIdentification(), null, "identification", null, 0, 1, FBType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFBType_VersionInfo(), this.getVersionInfo(), null, "versionInfo", null, 1, -1, FBType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFBType_CompilerInfo(), this.getCompilerInfo(), null, "compilerInfo", null, 0, 1, FBType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFBType_InterfaceList(), this.getInterfaceList(), null, "interfaceList", null, 1, 1, FBType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFBType_BasicFB(), this.getBasicFB(), null, "basicFB", null, 0, 1, FBType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFBType_FBNetwork(), this.getFBNetwork(), null, "fBNetwork", null, 0, 1, FBType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFBType_Service(), this.getService(), null, "service", null, 0, 1, FBType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFBType_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, FBType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFBType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, FBType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hceccRelationEClass, HCECCRelation.class, "HCECCRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHCECCRelation_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, HCECCRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHCECCRelation_Destination(), theXMLTypePackage.getString(), "destination", null, 1, 1, HCECCRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHCECCRelation_Relation(), theXMLTypePackage.getString(), "relation", null, 1, 1, HCECCRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHCECCRelation_Source(), theXMLTypePackage.getString(), "source", null, 1, 1, HCECCRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hceccEClass, de.cau.cs.kieler.functionblock.HCECC.class, "HCECC", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHCECC_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, de.cau.cs.kieler.functionblock.HCECC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHCECC_ECC(), this.getECC(), null, "eCC", null, 0, -1, de.cau.cs.kieler.functionblock.HCECC.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getHCECC_HCECCRelation(), this.getHCECCRelation(), null, "hCECCRelation", null, 0, -1, de.cau.cs.kieler.functionblock.HCECC.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(identificationEClass, Identification.class, "Identification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentification_ApplicationDomain(), theXMLTypePackage.getString(), "applicationDomain", null, 0, 1, Identification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdentification_Classification(), theXMLTypePackage.getString(), "classification", null, 0, 1, Identification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdentification_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, Identification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdentification_Function(), theXMLTypePackage.getString(), "function", null, 0, 1, Identification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdentification_Standard(), theXMLTypePackage.getString(), "standard", null, 0, 1, Identification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdentification_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, Identification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputPrimitiveEClass, InputPrimitive.class, "InputPrimitive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInputPrimitive_Event(), theXMLTypePackage.getString(), "event", null, 1, 1, InputPrimitive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInputPrimitive_Interface(), theXMLTypePackage.getString(), "interface", null, 1, 1, InputPrimitive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInputPrimitive_Parameters(), theXMLTypePackage.getString(), "parameters", null, 0, 1, InputPrimitive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputVarsEClass, InputVars.class, "InputVars", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputVars_VarDeclaration(), this.getVarDeclaration(), null, "varDeclaration", null, 1, -1, InputVars.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceListEClass, InterfaceList.class, "InterfaceList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInterfaceList_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, InterfaceList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceList_EventInputs(), this.getEventInputs(), null, "eventInputs", null, 0, 1, InterfaceList.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceList_EventOutputs(), this.getEventOutputs(), null, "eventOutputs", null, 0, 1, InterfaceList.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceList_InputVars(), this.getInputVars(), null, "inputVars", null, 0, 1, InterfaceList.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceList_OutputVars(), this.getOutputVars(), null, "outputVars", null, 0, 1, InterfaceList.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceList_Sockets(), this.getSockets(), null, "sockets", null, 0, 1, InterfaceList.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceList_Plugs(), this.getPlugs(), null, "plugs", null, 0, 1, InterfaceList.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(internalVarsEClass, InternalVars.class, "InternalVars", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInternalVars_VarDeclaration(), this.getVarDeclaration(), null, "varDeclaration", null, 1, -1, InternalVars.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ldEClass, de.cau.cs.kieler.functionblock.LD.class, "LD", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLD_Rung(), this.getRung(), null, "rung", null, 1, -1, de.cau.cs.kieler.functionblock.LD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkEClass, Link.class, "Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLink_Parameter(), this.getParameter(), null, "parameter", null, 0, -1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_CommResource(), theXMLTypePackage.getString(), "commResource", null, 1, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_SegmentName(), theXMLTypePackage.getString(), "segmentName", null, 1, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMapping_From(), theXMLTypePackage.getString(), "from", null, 1, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMapping_To(), theXMLTypePackage.getString(), "to", null, 1, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(otherEClass, Other.class, "Other", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOther_Language(), theXMLTypePackage.getString(), "language", null, 1, 1, Other.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOther_Prototype(), theXMLTypePackage.getString(), "prototype", null, 1, 1, Other.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOther_Text(), theXMLTypePackage.getString(), "text", null, 1, 1, Other.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputPrimitiveEClass, OutputPrimitive.class, "OutputPrimitive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOutputPrimitive_Event(), theXMLTypePackage.getString(), "event", null, 1, 1, OutputPrimitive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOutputPrimitive_Interface(), theXMLTypePackage.getString(), "interface", null, 1, 1, OutputPrimitive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOutputPrimitive_Parameters(), theXMLTypePackage.getString(), "parameters", null, 0, 1, OutputPrimitive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputVarsEClass, OutputVars.class, "OutputVars", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputVars_VarDeclaration(), this.getVarDeclaration(), null, "varDeclaration", null, 1, -1, OutputVars.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Value(), theXMLTypePackage.getString(), "value", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(plugsEClass, Plugs.class, "Plugs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlugs_AdapterDeclaration(), this.getAdapterDeclaration(), null, "adapterDeclaration", null, 1, -1, Plugs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResource_Parameter(), this.getParameter(), null, "parameter", null, 0, -1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResource_FBNetwork(), this.getFBNetwork(), null, "fBNetwork", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResource_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResource_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResource_Type(), theXMLTypePackage.getString(), "type", null, 1, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResource_X(), theXMLTypePackage.getString(), "x", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResource_Y(), theXMLTypePackage.getString(), "y", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceTypeNameEClass, ResourceTypeName.class, "ResourceTypeName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceTypeName_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, ResourceTypeName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceTypeEClass, ResourceType.class, "ResourceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceType_Identification(), this.getIdentification(), null, "identification", null, 0, 1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceType_VersionInfo(), this.getVersionInfo(), null, "versionInfo", null, 1, -1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceType_CompilerInfo(), this.getCompilerInfo(), null, "compilerInfo", null, 0, 1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceType_FBTypeName(), this.getFBTypeName(), null, "fBTypeName", null, 0, -1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceType_VarDeclaration(), this.getVarDeclaration(), null, "varDeclaration", null, 0, -1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceType_FBNetwork(), this.getFBNetwork(), null, "fBNetwork", null, 1, 1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceType_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rungEClass, Rung.class, "Rung", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRung_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, Rung.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRung_Expression(), theXMLTypePackage.getString(), "expression", null, 1, 1, Rung.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRung_Output(), theXMLTypePackage.getString(), "output", null, 1, 1, Rung.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(segmentEClass, Segment.class, "Segment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSegment_Parameter(), this.getParameter(), null, "parameter", null, 0, -1, Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSegment_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSegment_Dx1(), theXMLTypePackage.getString(), "dx1", null, 0, 1, Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSegment_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSegment_Type(), theXMLTypePackage.getString(), "type", null, 1, 1, Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSegment_X(), theXMLTypePackage.getString(), "x", null, 0, 1, Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSegment_Y(), theXMLTypePackage.getString(), "y", null, 0, 1, Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceSequenceEClass, ServiceSequence.class, "ServiceSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceSequence_ServiceTransaction(), this.getServiceTransaction(), null, "serviceTransaction", null, 0, -1, ServiceSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceSequence_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, ServiceSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceSequence_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, ServiceSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceTransactionEClass, ServiceTransaction.class, "ServiceTransaction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceTransaction_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, ServiceTransaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceTransaction_InputPrimitive(), this.getInputPrimitive(), null, "inputPrimitive", null, 0, 1, ServiceTransaction.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getServiceTransaction_OutputPrimitive(), this.getOutputPrimitive(), null, "outputPrimitive", null, 0, -1, ServiceTransaction.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getService_ServiceSequence(), this.getServiceSequence(), null, "serviceSequence", null, 1, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_LeftInterface(), theXMLTypePackage.getString(), "leftInterface", null, 1, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_RightInterface(), theXMLTypePackage.getString(), "rightInterface", null, 1, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(socketsEClass, Sockets.class, "Sockets", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSockets_AdapterDeclaration(), this.getAdapterDeclaration(), null, "adapterDeclaration", null, 1, -1, Sockets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stEClass, de.cau.cs.kieler.functionblock.ST.class, "ST", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getST_Text(), theXMLTypePackage.getString(), "text", null, 1, 1, de.cau.cs.kieler.functionblock.ST.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subAppEventInputsEClass, SubAppEventInputs.class, "SubAppEventInputs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubAppEventInputs_SubAppEvent(), this.getSubAppEvent(), null, "subAppEvent", null, 1, -1, SubAppEventInputs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subAppEventOutputsEClass, SubAppEventOutputs.class, "SubAppEventOutputs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubAppEventOutputs_SubAppEvent(), this.getSubAppEvent(), null, "subAppEvent", null, 1, -1, SubAppEventOutputs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subAppEventEClass, SubAppEvent.class, "SubAppEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSubAppEvent_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, SubAppEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubAppEvent_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, SubAppEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubAppEvent_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, SubAppEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subAppInterfaceListEClass, SubAppInterfaceList.class, "SubAppInterfaceList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubAppInterfaceList_SubAppEventInputs(), this.getSubAppEventInputs(), null, "subAppEventInputs", null, 0, 1, SubAppInterfaceList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubAppInterfaceList_SubAppEventOutputs(), this.getSubAppEventOutputs(), null, "subAppEventOutputs", null, 0, 1, SubAppInterfaceList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubAppInterfaceList_InputVars(), this.getInputVars(), null, "inputVars", null, 0, 1, SubAppInterfaceList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubAppInterfaceList_OutputVars(), this.getOutputVars(), null, "outputVars", null, 0, 1, SubAppInterfaceList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subAppNetworkEClass, SubAppNetwork.class, "SubAppNetwork", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubAppNetwork_SubApp(), this.getSubApp(), null, "subApp", null, 0, -1, SubAppNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubAppNetwork_FB(), this.getFB(), null, "fB", null, 0, -1, SubAppNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubAppNetwork_EventConnections(), this.getEventConnections(), null, "eventConnections", null, 0, 1, SubAppNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubAppNetwork_DataConnections(), this.getDataConnections(), null, "dataConnections", null, 0, 1, SubAppNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subAppEClass, SubApp.class, "SubApp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSubApp_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, SubApp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubApp_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, SubApp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubApp_Type(), theXMLTypePackage.getString(), "type", null, 1, 1, SubApp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubApp_X(), theXMLTypePackage.getString(), "x", null, 0, 1, SubApp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubApp_Y(), theXMLTypePackage.getString(), "y", null, 0, 1, SubApp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subAppTypeEClass, SubAppType.class, "SubAppType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubAppType_Identification(), this.getIdentification(), null, "identification", null, 0, 1, SubAppType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubAppType_VersionInfo(), this.getVersionInfo(), null, "versionInfo", null, 1, -1, SubAppType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubAppType_CompilerInfo(), this.getCompilerInfo(), null, "compilerInfo", null, 0, 1, SubAppType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubAppType_SubAppInterfaceList(), this.getSubAppInterfaceList(), null, "subAppInterfaceList", null, 1, 1, SubAppType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubAppType_SubAppNetwork(), this.getSubAppNetwork(), null, "subAppNetwork", null, 0, 1, SubAppType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubAppType_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, SubAppType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubAppType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, SubAppType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemEClass, de.cau.cs.kieler.functionblock.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystem_Identification(), this.getIdentification(), null, "identification", null, 0, 1, de.cau.cs.kieler.functionblock.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_VersionInfo(), this.getVersionInfo(), null, "versionInfo", null, 1, -1, de.cau.cs.kieler.functionblock.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Application(), this.getApplication(), null, "application", null, 0, -1, de.cau.cs.kieler.functionblock.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Device(), this.getDevice(), null, "device", null, 1, -1, de.cau.cs.kieler.functionblock.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Mapping(), this.getMapping(), null, "mapping", null, 0, -1, de.cau.cs.kieler.functionblock.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Segment(), this.getSegment(), null, "segment", null, 0, -1, de.cau.cs.kieler.functionblock.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Link(), this.getLink(), null, "link", null, 0, -1, de.cau.cs.kieler.functionblock.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystem_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, de.cau.cs.kieler.functionblock.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystem_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, de.cau.cs.kieler.functionblock.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varDeclarationEClass, VarDeclaration.class, "VarDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVarDeclaration_ArraySize(), theXMLTypePackage.getString(), "arraySize", null, 0, 1, VarDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVarDeclaration_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, VarDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVarDeclaration_InitialValue(), theXMLTypePackage.getString(), "initialValue", null, 0, 1, VarDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVarDeclaration_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, VarDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVarDeclaration_Type(), theXMLTypePackage.getString(), "type", null, 1, 1, VarDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versionInfoEClass, VersionInfo.class, "VersionInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersionInfo_Author(), theXMLTypePackage.getString(), "author", null, 1, 1, VersionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionInfo_Date(), theXMLTypePackage.getString(), "date", null, 1, 1, VersionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionInfo_Organization(), theXMLTypePackage.getString(), "organization", null, 1, 1, VersionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionInfo_Remarks(), theXMLTypePackage.getString(), "remarks", null, 0, 1, VersionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionInfo_Version(), theXMLTypePackage.getString(), "version", null, 1, 1, VersionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(withEClass, With.class, "With", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWith_Var(), theXMLTypePackage.getString(), "var", null, 1, 1, With.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(languageEEnum, Language.class, "Language");
		addEEnumLiteral(languageEEnum, Language.JAVA);
		addEEnumLiteral(languageEEnum, Language.CPP);
		addEEnumLiteral(languageEEnum, Language.C);
		addEEnumLiteral(languageEEnum, Language.OTHER);

		// Initialize data types
		initEDataType(languageObjectEDataType, Language.class, "LanguageObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "qualified", "false"
		   });		
		addAnnotation
		  (adapterConnectionsEClass, 
		   source, 
		   new String[] {
			 "name", "AdapterConnections_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getAdapterConnections_Connection(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Connection",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (adapterDeclarationEClass, 
		   source, 
		   new String[] {
			 "name", "AdapterDeclaration_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getAdapterDeclaration_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Parameter",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAdapterDeclaration_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAdapterDeclaration_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAdapterDeclaration_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (adapterTypeEClass, 
		   source, 
		   new String[] {
			 "name", "AdapterType_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getAdapterType_Identification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Identification",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getAdapterType_VersionInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "VersionInfo",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getAdapterType_CompilerInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "CompilerInfo",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getAdapterType_InterfaceList(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InterfaceList",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getAdapterType_Service(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Service",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAdapterType_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAdapterType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (algorithmEClass, 
		   source, 
		   new String[] {
			 "name", "Algorithm_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getAlgorithm_FBD(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FBD",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getAlgorithm_ST(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ST",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getAlgorithm_LD(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "LD",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getAlgorithm_Other(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Other",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAlgorithm_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAlgorithm_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (applicationEClass, 
		   source, 
		   new String[] {
			 "name", "Application_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getApplication_FBNetwork(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FBNetwork",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getApplication_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getApplication_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (basicFBEClass, 
		   source, 
		   new String[] {
			 "name", "BasicFB_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getBasicFB_InternalVars(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InternalVars",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getBasicFB_ECC(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ECC",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getBasicFB_HCECC(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "HCECC",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getBasicFB_Algorithm(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Algorithm",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (compilerInfoEClass, 
		   source, 
		   new String[] {
			 "name", "CompilerInfo_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getCompilerInfo_Compiler(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Compiler",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getCompilerInfo_Classdef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "classdef",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getCompilerInfo_Header(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "header",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (compilerEClass, 
		   source, 
		   new String[] {
			 "name", "Compiler_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getCompiler_Language(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Language",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getCompiler_Product(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Product",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getCompiler_Vendor(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Vendor",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getCompiler_Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Version",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (connectionEClass, 
		   source, 
		   new String[] {
			 "name", "Connection_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getConnection_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getConnection_Destination(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Destination",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getConnection_Dx1(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "dx1",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getConnection_Dx2(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "dx2",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getConnection_Dy(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "dy",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getConnection_Source(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Source",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (dataConnectionsEClass, 
		   source, 
		   new String[] {
			 "name", "DataConnections_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getDataConnections_Connection(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Connection",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (deviceEClass, 
		   source, 
		   new String[] {
			 "name", "Device_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getDevice_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Parameter",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDevice_Resource(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Resource",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDevice_FBNetwork(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FBNetwork",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDevice_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDevice_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDevice_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDevice_X(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "x",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDevice_Y(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "y",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (deviceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "DeviceType_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getDeviceType_Identification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Identification",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDeviceType_VersionInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "VersionInfo",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDeviceType_CompilerInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "CompilerInfo",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDeviceType_VarDeclaration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "VarDeclaration",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDeviceType_ResourceTypeName(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ResourceTypeName",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDeviceType_Resource(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Resource",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDeviceType_FBNetwork(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FBNetwork",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDeviceType_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDeviceType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });			
		addAnnotation
		  (getDocumentRoot_AdapterConnections(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AdapterConnections",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_AdapterDeclaration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AdapterDeclaration",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_AdapterType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AdapterType",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Algorithm(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Algorithm",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Application(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Application",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_BasicFB(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "BasicFB",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Compiler(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Compiler",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_CompilerInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "CompilerInfo",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Connection(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Connection",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_DataConnections(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "DataConnections",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Device(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Device",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_DeviceType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "DeviceType",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_ECAction(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ECAction",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_ECC(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ECC",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_ECState(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ECState",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_ECTransition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ECTransition",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Event(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Event",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_EventConnections(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "EventConnections",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_EventInputs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "EventInputs",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_EventOutputs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "EventOutputs",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_FB(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FB",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_FBD(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FBD",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_FBNetwork(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FBNetwork",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_FBType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FBType",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_FBTypeName(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FBTypeName",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_HCECC(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "HCECC",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_HCECCRelation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "HCECCRelation",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Identification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Identification",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_InputPrimitive(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InputPrimitive",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_InputVars(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InputVars",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_InterfaceList(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InterfaceList",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_InternalVars(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InternalVars",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_LD(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "LD",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Link(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Link",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Mapping(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Mapping",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Other(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Other",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_OutputPrimitive(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "OutputPrimitive",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_OutputVars(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "OutputVars",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Parameter",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Plugs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Plugs",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Resource(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Resource",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_ResourceType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ResourceType",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_ResourceTypeName(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ResourceTypeName",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Rung(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Rung",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Segment(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Segment",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Service(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Service",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_ServiceSequence(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ServiceSequence",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_ServiceTransaction(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ServiceTransaction",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_Sockets(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Sockets",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_ST(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ST",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_SubApp(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SubApp",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_SubAppEvent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SubAppEvent",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_SubAppEventInputs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SubAppEventInputs",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_SubAppEventOutputs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SubAppEventOutputs",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_SubAppInterfaceList(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SubAppInterfaceList",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_SubAppNetwork(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SubAppNetwork",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_SubAppType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SubAppType",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_System(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "System",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_VarDeclaration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "VarDeclaration",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_VersionInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "VersionInfo",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getDocumentRoot_With(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "With",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (ecActionEClass, 
		   source, 
		   new String[] {
			 "name", "ECAction_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getECAction_Algorithm(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Algorithm",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getECAction_Output(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Output",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (eccEClass, 
		   source, 
		   new String[] {
			 "name", "ECC_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getECC_ECState(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ECState",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getECC_ECTransition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ECTransition",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getECC_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (ecStateEClass, 
		   source, 
		   new String[] {
			 "name", "ECState_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getECState_ECAction(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ECAction",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getECState_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getECState_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getECState_X(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "x",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getECState_Y(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "y",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (ecTransitionEClass, 
		   source, 
		   new String[] {
			 "name", "ECTransition_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getECTransition_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getECTransition_Condition(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Condition",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getECTransition_Destination(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Destination",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getECTransition_Source(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Source",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getECTransition_X(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "x",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getECTransition_Y(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "y",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (eventConnectionsEClass, 
		   source, 
		   new String[] {
			 "name", "EventConnections_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getEventConnections_Connection(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Connection",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (eventInputsEClass, 
		   source, 
		   new String[] {
			 "name", "EventInputs_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getEventInputs_Event(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Event",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (eventOutputsEClass, 
		   source, 
		   new String[] {
			 "name", "EventOutputs_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getEventOutputs_Event(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Event",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (eventEClass, 
		   source, 
		   new String[] {
			 "name", "Event_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getEvent_With(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "With",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEvent_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEvent_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getEvent_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (fbdEClass, 
		   source, 
		   new String[] {
			 "name", "FBD_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getFBD_FB(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FB",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getFBD_DataConnections(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "DataConnections",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (fbNetworkEClass, 
		   source, 
		   new String[] {
			 "name", "FBNetwork_._type",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getFBNetwork_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });			
		addAnnotation
		  (getFBNetwork_FB(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FB",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getFBNetwork_EventConnections(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "EventConnections",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getFBNetwork_DataConnections(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "DataConnections",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getFBNetwork_AdapterConnections(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AdapterConnections",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (fbEClass, 
		   source, 
		   new String[] {
			 "name", "FB_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getFB_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Parameter",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getFB_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getFB_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getFB_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getFB_X(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "x",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getFB_Y(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "y",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (fbTypeNameEClass, 
		   source, 
		   new String[] {
			 "name", "FBTypeName_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getFBTypeName_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (fbTypeEClass, 
		   source, 
		   new String[] {
			 "name", "FBType_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getFBType_Identification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Identification",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getFBType_VersionInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "VersionInfo",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getFBType_CompilerInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "CompilerInfo",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getFBType_InterfaceList(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InterfaceList",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getFBType_BasicFB(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "BasicFB",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getFBType_FBNetwork(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FBNetwork",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getFBType_Service(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Service",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getFBType_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getFBType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (hceccRelationEClass, 
		   source, 
		   new String[] {
			 "name", "HCECCRelation_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getHCECCRelation_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getHCECCRelation_Destination(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Destination",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getHCECCRelation_Relation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Relation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getHCECCRelation_Source(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Source",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (hceccEClass, 
		   source, 
		   new String[] {
			 "name", "HCECC_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getHCECC_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });			
		addAnnotation
		  (getHCECC_ECC(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ECC",
			 "namespace", "##targetNamespace",
			 "group", "group:0"
		   });			
		addAnnotation
		  (getHCECC_HCECCRelation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "HCECCRelation",
			 "namespace", "##targetNamespace",
			 "group", "group:0"
		   });		
		addAnnotation
		  (identificationEClass, 
		   source, 
		   new String[] {
			 "name", "Identification_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getIdentification_ApplicationDomain(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ApplicationDomain",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getIdentification_Classification(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Classification",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getIdentification_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getIdentification_Function(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Function",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getIdentification_Standard(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Standard",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getIdentification_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (inputPrimitiveEClass, 
		   source, 
		   new String[] {
			 "name", "InputPrimitive_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getInputPrimitive_Event(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Event",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getInputPrimitive_Interface(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Interface",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getInputPrimitive_Parameters(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Parameters",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (inputVarsEClass, 
		   source, 
		   new String[] {
			 "name", "InputVars_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getInputVars_VarDeclaration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "VarDeclaration",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (interfaceListEClass, 
		   source, 
		   new String[] {
			 "name", "InterfaceList_._type",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getInterfaceList_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });			
		addAnnotation
		  (getInterfaceList_EventInputs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "EventInputs",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getInterfaceList_EventOutputs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "EventOutputs",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getInterfaceList_InputVars(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InputVars",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getInterfaceList_OutputVars(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "OutputVars",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getInterfaceList_Sockets(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Sockets",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getInterfaceList_Plugs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Plugs",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (internalVarsEClass, 
		   source, 
		   new String[] {
			 "name", "InternalVars_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getInternalVars_VarDeclaration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "VarDeclaration",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (languageEEnum, 
		   source, 
		   new String[] {
			 "name", "Language_._type"
		   });		
		addAnnotation
		  (languageObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "Language_._type:Object",
			 "baseType", "Language_._type"
		   });		
		addAnnotation
		  (ldEClass, 
		   source, 
		   new String[] {
			 "name", "LD_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getLD_Rung(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Rung",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (linkEClass, 
		   source, 
		   new String[] {
			 "name", "Link_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getLink_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Parameter",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getLink_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getLink_CommResource(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "CommResource",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getLink_SegmentName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "SegmentName",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (mappingEClass, 
		   source, 
		   new String[] {
			 "name", "Mapping_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getMapping_From(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "From",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMapping_To(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "To",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (otherEClass, 
		   source, 
		   new String[] {
			 "name", "Other_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getOther_Language(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Language",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getOther_Prototype(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Prototype",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getOther_Text(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Text",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (outputPrimitiveEClass, 
		   source, 
		   new String[] {
			 "name", "OutputPrimitive_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getOutputPrimitive_Event(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Event",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getOutputPrimitive_Interface(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Interface",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getOutputPrimitive_Parameters(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Parameters",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (outputVarsEClass, 
		   source, 
		   new String[] {
			 "name", "OutputVars_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getOutputVars_VarDeclaration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "VarDeclaration",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (parameterEClass, 
		   source, 
		   new String[] {
			 "name", "Parameter_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getParameter_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getParameter_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getParameter_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Value",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (plugsEClass, 
		   source, 
		   new String[] {
			 "name", "Plugs_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getPlugs_AdapterDeclaration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AdapterDeclaration",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (resourceEClass, 
		   source, 
		   new String[] {
			 "name", "Resource_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getResource_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Parameter",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getResource_FBNetwork(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FBNetwork",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getResource_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getResource_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getResource_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getResource_X(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "x",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getResource_Y(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "y",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (resourceTypeNameEClass, 
		   source, 
		   new String[] {
			 "name", "ResourceTypeName_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getResourceTypeName_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (resourceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ResourceType_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getResourceType_Identification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Identification",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getResourceType_VersionInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "VersionInfo",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getResourceType_CompilerInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "CompilerInfo",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getResourceType_FBTypeName(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FBTypeName",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getResourceType_VarDeclaration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "VarDeclaration",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getResourceType_FBNetwork(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FBNetwork",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getResourceType_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getResourceType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (rungEClass, 
		   source, 
		   new String[] {
			 "name", "Rung_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getRung_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getRung_Expression(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Expression",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getRung_Output(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Output",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (segmentEClass, 
		   source, 
		   new String[] {
			 "name", "Segment_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getSegment_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Parameter",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSegment_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSegment_Dx1(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "dx1",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSegment_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSegment_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSegment_X(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "x",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSegment_Y(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "y",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (serviceSequenceEClass, 
		   source, 
		   new String[] {
			 "name", "ServiceSequence_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getServiceSequence_ServiceTransaction(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ServiceTransaction",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getServiceSequence_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getServiceSequence_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (serviceTransactionEClass, 
		   source, 
		   new String[] {
			 "name", "ServiceTransaction_._type",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getServiceTransaction_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });			
		addAnnotation
		  (getServiceTransaction_InputPrimitive(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InputPrimitive",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getServiceTransaction_OutputPrimitive(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "OutputPrimitive",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (serviceEClass, 
		   source, 
		   new String[] {
			 "name", "Service_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getService_ServiceSequence(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ServiceSequence",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getService_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getService_LeftInterface(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "LeftInterface",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getService_RightInterface(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "RightInterface",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (socketsEClass, 
		   source, 
		   new String[] {
			 "name", "Sockets_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getSockets_AdapterDeclaration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AdapterDeclaration",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (stEClass, 
		   source, 
		   new String[] {
			 "name", "ST_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getST_Text(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Text",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (subAppEventInputsEClass, 
		   source, 
		   new String[] {
			 "name", "SubAppEventInputs_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getSubAppEventInputs_SubAppEvent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SubAppEvent",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (subAppEventOutputsEClass, 
		   source, 
		   new String[] {
			 "name", "SubAppEventOutputs_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getSubAppEventOutputs_SubAppEvent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SubAppEvent",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (subAppEventEClass, 
		   source, 
		   new String[] {
			 "name", "SubAppEvent_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getSubAppEvent_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSubAppEvent_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSubAppEvent_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (subAppInterfaceListEClass, 
		   source, 
		   new String[] {
			 "name", "SubAppInterfaceList_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getSubAppInterfaceList_SubAppEventInputs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SubAppEventInputs",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSubAppInterfaceList_SubAppEventOutputs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SubAppEventOutputs",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSubAppInterfaceList_InputVars(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InputVars",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSubAppInterfaceList_OutputVars(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "OutputVars",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (subAppNetworkEClass, 
		   source, 
		   new String[] {
			 "name", "SubAppNetwork_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getSubAppNetwork_SubApp(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SubApp",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSubAppNetwork_FB(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FB",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSubAppNetwork_EventConnections(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "EventConnections",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSubAppNetwork_DataConnections(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "DataConnections",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (subAppEClass, 
		   source, 
		   new String[] {
			 "name", "SubApp_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getSubApp_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSubApp_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSubApp_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSubApp_X(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "x",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSubApp_Y(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "y",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (subAppTypeEClass, 
		   source, 
		   new String[] {
			 "name", "SubAppType_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getSubAppType_Identification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Identification",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSubAppType_VersionInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "VersionInfo",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSubAppType_CompilerInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "CompilerInfo",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSubAppType_SubAppInterfaceList(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SubAppInterfaceList",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSubAppType_SubAppNetwork(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SubAppNetwork",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSubAppType_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSubAppType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (systemEClass, 
		   source, 
		   new String[] {
			 "name", "System_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getSystem_Identification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Identification",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSystem_VersionInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "VersionInfo",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSystem_Application(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Application",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSystem_Device(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Device",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSystem_Mapping(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Mapping",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSystem_Segment(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Segment",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getSystem_Link(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Link",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSystem_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSystem_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (varDeclarationEClass, 
		   source, 
		   new String[] {
			 "name", "VarDeclaration_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getVarDeclaration_ArraySize(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ArraySize",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getVarDeclaration_Comment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Comment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getVarDeclaration_InitialValue(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "InitialValue",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getVarDeclaration_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getVarDeclaration_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (versionInfoEClass, 
		   source, 
		   new String[] {
			 "name", "VersionInfo_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getVersionInfo_Author(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Author",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getVersionInfo_Date(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Date",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getVersionInfo_Organization(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Organization",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getVersionInfo_Remarks(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Remarks",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getVersionInfo_Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Version",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (withEClass, 
		   source, 
		   new String[] {
			 "name", "With_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getWith_Var(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Var",
			 "namespace", "##targetNamespace"
		   });
	}

} //FunctionblockPackageImpl
