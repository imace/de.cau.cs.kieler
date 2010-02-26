/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.Adapter;
import de.cau.cs.kieler.cakefeed.AdapterConnection;
import de.cau.cs.kieler.cakefeed.AdapterType;
import de.cau.cs.kieler.cakefeed.Application;
import de.cau.cs.kieler.cakefeed.BasicFunctionBlockDiagram;
import de.cau.cs.kieler.cakefeed.BasicFunctionBlockType;
import de.cau.cs.kieler.cakefeed.CakefeedFactory;
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
import de.cau.cs.kieler.cakefeed.Language;
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
import de.cau.cs.kieler.cakefeed.SegmentType;
import de.cau.cs.kieler.cakefeed.Service;
import de.cau.cs.kieler.cakefeed.ServiceSequence;
import de.cau.cs.kieler.cakefeed.ServiceTransaction;
import de.cau.cs.kieler.cakefeed.Socket;
import de.cau.cs.kieler.cakefeed.StructuredText;
import de.cau.cs.kieler.cakefeed.Var;
import de.cau.cs.kieler.cakefeed.VarType;
import de.cau.cs.kieler.cakefeed.VersionInfo;
import de.cau.cs.kieler.cakefeed.With;

import de.cau.cs.kieler.synccharts.SyncchartsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CakefeedPackageImpl extends EPackageImpl implements CakefeedPackage {
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
	private EClass identificationEClass = null;

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
	private EClass applicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionBlockNetworkEClass = null;

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
	private EClass mappingEClass = null;

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
	private EClass linkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionBlockInterfaceEClass = null;

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
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionBlockTypeEClass = null;

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
	private EClass eventConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataConnectionEClass = null;

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
	private EClass ififEventConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ififDataConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iffbEventConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iffbDataConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fbifEventConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fbifDataConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fbfbEventConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fbfbDataConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifivDataConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ivifDataConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fbivDataConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ivfbDataConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ivivDataConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adapterConnectionEClass = null;

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
	private EClass ifInputEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fbInputEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifOutputEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fbOutputEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifInputVarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fbInputVarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifOutputVarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fbOutputVarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalVarEClass = null;

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
	private EClass withEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputWithEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputWithEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adapterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass socketEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass plugEClass = null;

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
	private EClass serviceEClass = null;

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
	private EClass primitiveEClass = null;

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
	private EClass outputPrimitiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicFunctionBlockTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionBlockDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ladderDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass otherAlgorithmEClass = null;

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
	private EClass compositeFunctionBlockTypeEClass = null;

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
	private EClass resourceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicFunctionBlockDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeFunctionBlockDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedAndCommentedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compilableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum segmentTypeEEnum = null;

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
	private EEnum varTypeEEnum = null;

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
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CakefeedPackageImpl() {
		super(eNS_URI, CakefeedFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CakefeedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CakefeedPackage init() {
		if (isInited) return (CakefeedPackage)EPackage.Registry.INSTANCE.getEPackage(CakefeedPackage.eNS_URI);

		// Obtain or create and register package
		CakefeedPackageImpl theCakefeedPackage = (CakefeedPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CakefeedPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CakefeedPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SyncchartsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCakefeedPackage.createPackageContents();

		// Initialize created meta-data
		theCakefeedPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCakefeedPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CakefeedPackage.eNS_URI, theCakefeedPackage);
		return theCakefeedPackage;
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
	public EReference getSystem_Applications() {
		return (EReference)systemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Devices() {
		return (EReference)systemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Mappings() {
		return (EReference)systemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Segments() {
		return (EReference)systemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Links() {
		return (EReference)systemEClass.getEStructuralFeatures().get(4);
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
	public EAttribute getVersionInfo_Organisation() {
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
	public EClass getFunctionBlockNetwork() {
		return functionBlockNetworkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlockNetwork_FBs() {
		return (EReference)functionBlockNetworkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlockNetwork_EventConnections() {
		return (EReference)functionBlockNetworkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlockNetwork_DataConnections() {
		return (EReference)functionBlockNetworkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlockNetwork_AdapterConnections() {
		return (EReference)functionBlockNetworkEClass.getEStructuralFeatures().get(3);
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
	public EReference getDevice_Parameters() {
		return (EReference)deviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDevice_Resources() {
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
	public EReference getDevice_Type() {
		return (EReference)deviceEClass.getEStructuralFeatures().get(3);
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
	public EClass getSegment() {
		return segmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSegment_Parameters() {
		return (EReference)segmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSegment_Type() {
		return (EAttribute)segmentEClass.getEStructuralFeatures().get(1);
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
	public EReference getLink_Parameters() {
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
	public EClass getFunctionBlock() {
		return functionBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlock_Parameters() {
		return (EReference)functionBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlock_Type() {
		return (EReference)functionBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlock_InputEvents() {
		return (EReference)functionBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlock_OutputEvents() {
		return (EReference)functionBlockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlock_InputVars() {
		return (EReference)functionBlockEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlock_OutputVars() {
		return (EReference)functionBlockEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionBlockInterface() {
		return functionBlockInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlockInterface_InputEvents() {
		return (EReference)functionBlockInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlockInterface_OutputEvents() {
		return (EReference)functionBlockInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlockInterface_InputVars() {
		return (EReference)functionBlockInterfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlockInterface_OutputVars() {
		return (EReference)functionBlockInterfaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlockInterface_Sockets() {
		return (EReference)functionBlockInterfaceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlockInterface_Plugs() {
		return (EReference)functionBlockInterfaceEClass.getEStructuralFeatures().get(5);
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
	public EAttribute getParameter_Value() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
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
	public EReference getResource_Parameters() {
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
	public EReference getResource_Type() {
		return (EReference)resourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionBlockType() {
		return functionBlockTypeEClass;
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
	public EClass getEventConnection() {
		return eventConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataConnection() {
		return dataConnectionEClass;
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
	public EReference getCompilerInfo_Compilers() {
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
	public EClass getIFIFEventConnection() {
		return ififEventConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFIFEventConnection_Destination() {
		return (EReference)ififEventConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFIFEventConnection_Source() {
		return (EReference)ififEventConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFIFDataConnection() {
		return ififDataConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFIFDataConnection_Destination() {
		return (EReference)ififDataConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFIFDataConnection_Source() {
		return (EReference)ififDataConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFFBEventConnection() {
		return iffbEventConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFFBEventConnection_Destination() {
		return (EReference)iffbEventConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFFBEventConnection_Source() {
		return (EReference)iffbEventConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFFBDataConnection() {
		return iffbDataConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFFBDataConnection_Destination() {
		return (EReference)iffbDataConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFFBDataConnection_Source() {
		return (EReference)iffbDataConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFBIFEventConnection() {
		return fbifEventConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBIFEventConnection_Destination() {
		return (EReference)fbifEventConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBIFEventConnection_Source() {
		return (EReference)fbifEventConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFBIFDataConnection() {
		return fbifDataConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBIFDataConnection_Destination() {
		return (EReference)fbifDataConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBIFDataConnection_Source() {
		return (EReference)fbifDataConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFBFBEventConnection() {
		return fbfbEventConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBFBEventConnection_Destination() {
		return (EReference)fbfbEventConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBFBEventConnection_Source() {
		return (EReference)fbfbEventConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFBFBDataConnection() {
		return fbfbDataConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBFBDataConnection_Destination() {
		return (EReference)fbfbDataConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBFBDataConnection_Source() {
		return (EReference)fbfbDataConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFIVDataConnection() {
		return ifivDataConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFIVDataConnection_Destination() {
		return (EReference)ifivDataConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFIVDataConnection_Source() {
		return (EReference)ifivDataConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIVIFDataConnection() {
		return ivifDataConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIVIFDataConnection_Destination() {
		return (EReference)ivifDataConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIVIFDataConnection_Source() {
		return (EReference)ivifDataConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFBIVDataConnection() {
		return fbivDataConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBIVDataConnection_Destination() {
		return (EReference)fbivDataConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFBIVDataConnection_Source() {
		return (EReference)fbivDataConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIVFBDataConnection() {
		return ivfbDataConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIVFBDataConnection_Destination() {
		return (EReference)ivfbDataConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIVFBDataConnection_Source() {
		return (EReference)ivfbDataConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIVIVDataConnection() {
		return ivivDataConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIVIVDataConnection_Destination() {
		return (EReference)ivivDataConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIVIVDataConnection_Source() {
		return (EReference)ivivDataConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdapterConnection() {
		return adapterConnectionEClass;
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
	public EAttribute getEvent_Type() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFInputEvent() {
		return ifInputEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFInputEvent_With() {
		return (EReference)ifInputEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFBInputEvent() {
		return fbInputEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFOutputEvent() {
		return ifOutputEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFOutputEvent_With() {
		return (EReference)ifOutputEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFBOutputEvent() {
		return fbOutputEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVar() {
		return varEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVar_ArraySize() {
		return (EAttribute)varEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVar_InitialValue() {
		return (EAttribute)varEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVar_Type() {
		return (EAttribute)varEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFInputVar() {
		return ifInputVarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFBInputVar() {
		return fbInputVarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFOutputVar() {
		return ifOutputVarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFBOutputVar() {
		return fbOutputVarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalVar() {
		return internalVarEClass;
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
	public EClass getWith() {
		return withEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputWith() {
		return inputWithEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputWith_ParentInputEvent() {
		return (EReference)inputWithEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputWith_With() {
		return (EReference)inputWithEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputWith() {
		return outputWithEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputWith_ParentOutputEvent() {
		return (EReference)outputWithEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputWith_With() {
		return (EReference)outputWithEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdapter() {
		return adapterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapter_Parameters() {
		return (EReference)adapterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapter_Type() {
		return (EReference)adapterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSocket() {
		return socketEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlug() {
		return plugEClass;
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
	public EReference getAdapterType_Service() {
		return (EReference)adapterTypeEClass.getEStructuralFeatures().get(0);
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
	public EReference getService_ServiceSequences() {
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
	public EAttribute getService_RightInterface() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_LeftInterface() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(3);
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
	public EReference getServiceSequence_ServiceTransactions() {
		return (EReference)serviceSequenceEClass.getEStructuralFeatures().get(0);
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
	public EReference getServiceTransaction_InputPrimitive() {
		return (EReference)serviceTransactionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceTransaction_OutputPrimitives() {
		return (EReference)serviceTransactionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitive() {
		return primitiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitive_Event() {
		return (EAttribute)primitiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitive_Interface() {
		return (EAttribute)primitiveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitive_Parameters() {
		return (EAttribute)primitiveEClass.getEStructuralFeatures().get(2);
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
	public EClass getOutputPrimitive() {
		return outputPrimitiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicFunctionBlockType() {
		return basicFunctionBlockTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFunctionBlockType_Service() {
		return (EReference)basicFunctionBlockTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFunctionBlockType_SyncChart() {
		return (EReference)basicFunctionBlockTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFunctionBlockType_InternalVars() {
		return (EReference)basicFunctionBlockTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFunctionBlockType_FunctionBlockDiagrams() {
		return (EReference)basicFunctionBlockTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFunctionBlockType_StructuredTexts() {
		return (EReference)basicFunctionBlockTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFunctionBlockType_LadderDiagrams() {
		return (EReference)basicFunctionBlockTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFunctionBlockType_OtherAlgorithms() {
		return (EReference)basicFunctionBlockTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionBlockDiagram() {
		return functionBlockDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlockDiagram_FBs() {
		return (EReference)functionBlockDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlockDiagram_DataConnections() {
		return (EReference)functionBlockDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuredText() {
		return structuredTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructuredText_Text() {
		return (EAttribute)structuredTextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLadderDiagram() {
		return ladderDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLadderDiagram_Rungs() {
		return (EReference)ladderDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOtherAlgorithm() {
		return otherAlgorithmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOtherAlgorithm_Language() {
		return (EAttribute)otherAlgorithmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOtherAlgorithm_Prototype() {
		return (EAttribute)otherAlgorithmEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOtherAlgorithm_Text() {
		return (EAttribute)otherAlgorithmEClass.getEStructuralFeatures().get(2);
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
	public EClass getCompositeFunctionBlockType() {
		return compositeFunctionBlockTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeFunctionBlockType_Service() {
		return (EReference)compositeFunctionBlockTypeEClass.getEStructuralFeatures().get(0);
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
	public EReference getDeviceType_VarDeclarations() {
		return (EReference)deviceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceType_Resources() {
		return (EReference)deviceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceType_FBNetwork() {
		return (EReference)deviceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeviceType_ResourceNames() {
		return (EAttribute)deviceTypeEClass.getEStructuralFeatures().get(3);
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
	public EReference getResourceType_VarDeclarations() {
		return (EReference)resourceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceType_FBNetwork() {
		return (EReference)resourceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceType_FBNames() {
		return (EAttribute)resourceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicFunctionBlockDiagram() {
		return basicFunctionBlockDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFunctionBlockDiagram_BFBType() {
		return (EReference)basicFunctionBlockDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeFunctionBlockDiagram() {
		return compositeFunctionBlockDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeFunctionBlockDiagram_CFBType() {
		return (EReference)compositeFunctionBlockDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedAndCommented() {
		return namedAndCommentedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedAndCommented_Comment() {
		return (EAttribute)namedAndCommentedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedAndCommented_Name() {
		return (EAttribute)namedAndCommentedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifiable() {
		return identifiableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifiable_Identification() {
		return (EReference)identifiableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifiable_VersionInfos() {
		return (EReference)identifiableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompilable() {
		return compilableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompilable_CompilerInfo() {
		return (EReference)compilableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSegmentType() {
		return segmentTypeEEnum;
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
	public EEnum getVarType() {
		return varTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CakefeedFactory getCakefeedFactory() {
		return (CakefeedFactory)getEFactoryInstance();
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
		systemEClass = createEClass(SYSTEM);
		createEReference(systemEClass, SYSTEM__APPLICATIONS);
		createEReference(systemEClass, SYSTEM__DEVICES);
		createEReference(systemEClass, SYSTEM__MAPPINGS);
		createEReference(systemEClass, SYSTEM__SEGMENTS);
		createEReference(systemEClass, SYSTEM__LINKS);

		identificationEClass = createEClass(IDENTIFICATION);
		createEAttribute(identificationEClass, IDENTIFICATION__APPLICATION_DOMAIN);
		createEAttribute(identificationEClass, IDENTIFICATION__CLASSIFICATION);
		createEAttribute(identificationEClass, IDENTIFICATION__DESCRIPTION);
		createEAttribute(identificationEClass, IDENTIFICATION__FUNCTION);
		createEAttribute(identificationEClass, IDENTIFICATION__STANDARD);
		createEAttribute(identificationEClass, IDENTIFICATION__TYPE);

		versionInfoEClass = createEClass(VERSION_INFO);
		createEAttribute(versionInfoEClass, VERSION_INFO__AUTHOR);
		createEAttribute(versionInfoEClass, VERSION_INFO__DATE);
		createEAttribute(versionInfoEClass, VERSION_INFO__ORGANISATION);
		createEAttribute(versionInfoEClass, VERSION_INFO__REMARKS);
		createEAttribute(versionInfoEClass, VERSION_INFO__VERSION);

		applicationEClass = createEClass(APPLICATION);
		createEReference(applicationEClass, APPLICATION__FB_NETWORK);

		functionBlockNetworkEClass = createEClass(FUNCTION_BLOCK_NETWORK);
		createEReference(functionBlockNetworkEClass, FUNCTION_BLOCK_NETWORK__FBS);
		createEReference(functionBlockNetworkEClass, FUNCTION_BLOCK_NETWORK__EVENT_CONNECTIONS);
		createEReference(functionBlockNetworkEClass, FUNCTION_BLOCK_NETWORK__DATA_CONNECTIONS);
		createEReference(functionBlockNetworkEClass, FUNCTION_BLOCK_NETWORK__ADAPTER_CONNECTIONS);

		deviceEClass = createEClass(DEVICE);
		createEReference(deviceEClass, DEVICE__PARAMETERS);
		createEReference(deviceEClass, DEVICE__RESOURCES);
		createEReference(deviceEClass, DEVICE__FB_NETWORK);
		createEReference(deviceEClass, DEVICE__TYPE);

		mappingEClass = createEClass(MAPPING);
		createEAttribute(mappingEClass, MAPPING__FROM);
		createEAttribute(mappingEClass, MAPPING__TO);

		segmentEClass = createEClass(SEGMENT);
		createEReference(segmentEClass, SEGMENT__PARAMETERS);
		createEAttribute(segmentEClass, SEGMENT__TYPE);

		linkEClass = createEClass(LINK);
		createEReference(linkEClass, LINK__PARAMETERS);
		createEAttribute(linkEClass, LINK__COMMENT);
		createEAttribute(linkEClass, LINK__COMM_RESOURCE);
		createEAttribute(linkEClass, LINK__SEGMENT_NAME);

		functionBlockEClass = createEClass(FUNCTION_BLOCK);
		createEReference(functionBlockEClass, FUNCTION_BLOCK__PARAMETERS);
		createEReference(functionBlockEClass, FUNCTION_BLOCK__TYPE);
		createEReference(functionBlockEClass, FUNCTION_BLOCK__INPUT_EVENTS);
		createEReference(functionBlockEClass, FUNCTION_BLOCK__OUTPUT_EVENTS);
		createEReference(functionBlockEClass, FUNCTION_BLOCK__INPUT_VARS);
		createEReference(functionBlockEClass, FUNCTION_BLOCK__OUTPUT_VARS);

		functionBlockInterfaceEClass = createEClass(FUNCTION_BLOCK_INTERFACE);
		createEReference(functionBlockInterfaceEClass, FUNCTION_BLOCK_INTERFACE__INPUT_EVENTS);
		createEReference(functionBlockInterfaceEClass, FUNCTION_BLOCK_INTERFACE__OUTPUT_EVENTS);
		createEReference(functionBlockInterfaceEClass, FUNCTION_BLOCK_INTERFACE__INPUT_VARS);
		createEReference(functionBlockInterfaceEClass, FUNCTION_BLOCK_INTERFACE__OUTPUT_VARS);
		createEReference(functionBlockInterfaceEClass, FUNCTION_BLOCK_INTERFACE__SOCKETS);
		createEReference(functionBlockInterfaceEClass, FUNCTION_BLOCK_INTERFACE__PLUGS);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__VALUE);

		resourceEClass = createEClass(RESOURCE);
		createEReference(resourceEClass, RESOURCE__PARAMETERS);
		createEReference(resourceEClass, RESOURCE__FB_NETWORK);
		createEReference(resourceEClass, RESOURCE__TYPE);

		functionBlockTypeEClass = createEClass(FUNCTION_BLOCK_TYPE);

		connectionEClass = createEClass(CONNECTION);
		createEAttribute(connectionEClass, CONNECTION__COMMENT);

		eventConnectionEClass = createEClass(EVENT_CONNECTION);

		dataConnectionEClass = createEClass(DATA_CONNECTION);

		compilerInfoEClass = createEClass(COMPILER_INFO);
		createEReference(compilerInfoEClass, COMPILER_INFO__COMPILERS);
		createEAttribute(compilerInfoEClass, COMPILER_INFO__CLASSDEF);
		createEAttribute(compilerInfoEClass, COMPILER_INFO__HEADER);

		ififEventConnectionEClass = createEClass(IFIF_EVENT_CONNECTION);
		createEReference(ififEventConnectionEClass, IFIF_EVENT_CONNECTION__DESTINATION);
		createEReference(ififEventConnectionEClass, IFIF_EVENT_CONNECTION__SOURCE);

		ififDataConnectionEClass = createEClass(IFIF_DATA_CONNECTION);
		createEReference(ififDataConnectionEClass, IFIF_DATA_CONNECTION__DESTINATION);
		createEReference(ififDataConnectionEClass, IFIF_DATA_CONNECTION__SOURCE);

		iffbEventConnectionEClass = createEClass(IFFB_EVENT_CONNECTION);
		createEReference(iffbEventConnectionEClass, IFFB_EVENT_CONNECTION__DESTINATION);
		createEReference(iffbEventConnectionEClass, IFFB_EVENT_CONNECTION__SOURCE);

		iffbDataConnectionEClass = createEClass(IFFB_DATA_CONNECTION);
		createEReference(iffbDataConnectionEClass, IFFB_DATA_CONNECTION__DESTINATION);
		createEReference(iffbDataConnectionEClass, IFFB_DATA_CONNECTION__SOURCE);

		fbifEventConnectionEClass = createEClass(FBIF_EVENT_CONNECTION);
		createEReference(fbifEventConnectionEClass, FBIF_EVENT_CONNECTION__DESTINATION);
		createEReference(fbifEventConnectionEClass, FBIF_EVENT_CONNECTION__SOURCE);

		fbifDataConnectionEClass = createEClass(FBIF_DATA_CONNECTION);
		createEReference(fbifDataConnectionEClass, FBIF_DATA_CONNECTION__DESTINATION);
		createEReference(fbifDataConnectionEClass, FBIF_DATA_CONNECTION__SOURCE);

		fbfbEventConnectionEClass = createEClass(FBFB_EVENT_CONNECTION);
		createEReference(fbfbEventConnectionEClass, FBFB_EVENT_CONNECTION__DESTINATION);
		createEReference(fbfbEventConnectionEClass, FBFB_EVENT_CONNECTION__SOURCE);

		fbfbDataConnectionEClass = createEClass(FBFB_DATA_CONNECTION);
		createEReference(fbfbDataConnectionEClass, FBFB_DATA_CONNECTION__DESTINATION);
		createEReference(fbfbDataConnectionEClass, FBFB_DATA_CONNECTION__SOURCE);

		ifivDataConnectionEClass = createEClass(IFIV_DATA_CONNECTION);
		createEReference(ifivDataConnectionEClass, IFIV_DATA_CONNECTION__DESTINATION);
		createEReference(ifivDataConnectionEClass, IFIV_DATA_CONNECTION__SOURCE);

		ivifDataConnectionEClass = createEClass(IVIF_DATA_CONNECTION);
		createEReference(ivifDataConnectionEClass, IVIF_DATA_CONNECTION__DESTINATION);
		createEReference(ivifDataConnectionEClass, IVIF_DATA_CONNECTION__SOURCE);

		fbivDataConnectionEClass = createEClass(FBIV_DATA_CONNECTION);
		createEReference(fbivDataConnectionEClass, FBIV_DATA_CONNECTION__DESTINATION);
		createEReference(fbivDataConnectionEClass, FBIV_DATA_CONNECTION__SOURCE);

		ivfbDataConnectionEClass = createEClass(IVFB_DATA_CONNECTION);
		createEReference(ivfbDataConnectionEClass, IVFB_DATA_CONNECTION__DESTINATION);
		createEReference(ivfbDataConnectionEClass, IVFB_DATA_CONNECTION__SOURCE);

		ivivDataConnectionEClass = createEClass(IVIV_DATA_CONNECTION);
		createEReference(ivivDataConnectionEClass, IVIV_DATA_CONNECTION__DESTINATION);
		createEReference(ivivDataConnectionEClass, IVIV_DATA_CONNECTION__SOURCE);

		adapterConnectionEClass = createEClass(ADAPTER_CONNECTION);

		eventEClass = createEClass(EVENT);
		createEAttribute(eventEClass, EVENT__TYPE);

		ifInputEventEClass = createEClass(IF_INPUT_EVENT);
		createEReference(ifInputEventEClass, IF_INPUT_EVENT__WITH);

		fbInputEventEClass = createEClass(FB_INPUT_EVENT);

		ifOutputEventEClass = createEClass(IF_OUTPUT_EVENT);
		createEReference(ifOutputEventEClass, IF_OUTPUT_EVENT__WITH);

		fbOutputEventEClass = createEClass(FB_OUTPUT_EVENT);

		varEClass = createEClass(VAR);
		createEAttribute(varEClass, VAR__ARRAY_SIZE);
		createEAttribute(varEClass, VAR__INITIAL_VALUE);
		createEAttribute(varEClass, VAR__TYPE);

		ifInputVarEClass = createEClass(IF_INPUT_VAR);

		fbInputVarEClass = createEClass(FB_INPUT_VAR);

		ifOutputVarEClass = createEClass(IF_OUTPUT_VAR);

		fbOutputVarEClass = createEClass(FB_OUTPUT_VAR);

		internalVarEClass = createEClass(INTERNAL_VAR);

		compilerEClass = createEClass(COMPILER);
		createEAttribute(compilerEClass, COMPILER__LANGUAGE);
		createEAttribute(compilerEClass, COMPILER__PRODUCT);
		createEAttribute(compilerEClass, COMPILER__VENDOR);
		createEAttribute(compilerEClass, COMPILER__VERSION);

		withEClass = createEClass(WITH);

		inputWithEClass = createEClass(INPUT_WITH);
		createEReference(inputWithEClass, INPUT_WITH__PARENT_INPUT_EVENT);
		createEReference(inputWithEClass, INPUT_WITH__WITH);

		outputWithEClass = createEClass(OUTPUT_WITH);
		createEReference(outputWithEClass, OUTPUT_WITH__PARENT_OUTPUT_EVENT);
		createEReference(outputWithEClass, OUTPUT_WITH__WITH);

		adapterEClass = createEClass(ADAPTER);
		createEReference(adapterEClass, ADAPTER__PARAMETERS);
		createEReference(adapterEClass, ADAPTER__TYPE);

		socketEClass = createEClass(SOCKET);

		plugEClass = createEClass(PLUG);

		adapterTypeEClass = createEClass(ADAPTER_TYPE);
		createEReference(adapterTypeEClass, ADAPTER_TYPE__SERVICE);

		serviceEClass = createEClass(SERVICE);
		createEReference(serviceEClass, SERVICE__SERVICE_SEQUENCES);
		createEAttribute(serviceEClass, SERVICE__COMMENT);
		createEAttribute(serviceEClass, SERVICE__RIGHT_INTERFACE);
		createEAttribute(serviceEClass, SERVICE__LEFT_INTERFACE);

		serviceSequenceEClass = createEClass(SERVICE_SEQUENCE);
		createEReference(serviceSequenceEClass, SERVICE_SEQUENCE__SERVICE_TRANSACTIONS);

		serviceTransactionEClass = createEClass(SERVICE_TRANSACTION);
		createEReference(serviceTransactionEClass, SERVICE_TRANSACTION__INPUT_PRIMITIVE);
		createEReference(serviceTransactionEClass, SERVICE_TRANSACTION__OUTPUT_PRIMITIVES);

		primitiveEClass = createEClass(PRIMITIVE);
		createEAttribute(primitiveEClass, PRIMITIVE__EVENT);
		createEAttribute(primitiveEClass, PRIMITIVE__INTERFACE);
		createEAttribute(primitiveEClass, PRIMITIVE__PARAMETERS);

		inputPrimitiveEClass = createEClass(INPUT_PRIMITIVE);

		outputPrimitiveEClass = createEClass(OUTPUT_PRIMITIVE);

		basicFunctionBlockTypeEClass = createEClass(BASIC_FUNCTION_BLOCK_TYPE);
		createEReference(basicFunctionBlockTypeEClass, BASIC_FUNCTION_BLOCK_TYPE__SERVICE);
		createEReference(basicFunctionBlockTypeEClass, BASIC_FUNCTION_BLOCK_TYPE__SYNC_CHART);
		createEReference(basicFunctionBlockTypeEClass, BASIC_FUNCTION_BLOCK_TYPE__INTERNAL_VARS);
		createEReference(basicFunctionBlockTypeEClass, BASIC_FUNCTION_BLOCK_TYPE__FUNCTION_BLOCK_DIAGRAMS);
		createEReference(basicFunctionBlockTypeEClass, BASIC_FUNCTION_BLOCK_TYPE__STRUCTURED_TEXTS);
		createEReference(basicFunctionBlockTypeEClass, BASIC_FUNCTION_BLOCK_TYPE__LADDER_DIAGRAMS);
		createEReference(basicFunctionBlockTypeEClass, BASIC_FUNCTION_BLOCK_TYPE__OTHER_ALGORITHMS);

		functionBlockDiagramEClass = createEClass(FUNCTION_BLOCK_DIAGRAM);
		createEReference(functionBlockDiagramEClass, FUNCTION_BLOCK_DIAGRAM__FBS);
		createEReference(functionBlockDiagramEClass, FUNCTION_BLOCK_DIAGRAM__DATA_CONNECTIONS);

		structuredTextEClass = createEClass(STRUCTURED_TEXT);
		createEAttribute(structuredTextEClass, STRUCTURED_TEXT__TEXT);

		ladderDiagramEClass = createEClass(LADDER_DIAGRAM);
		createEReference(ladderDiagramEClass, LADDER_DIAGRAM__RUNGS);

		otherAlgorithmEClass = createEClass(OTHER_ALGORITHM);
		createEAttribute(otherAlgorithmEClass, OTHER_ALGORITHM__LANGUAGE);
		createEAttribute(otherAlgorithmEClass, OTHER_ALGORITHM__PROTOTYPE);
		createEAttribute(otherAlgorithmEClass, OTHER_ALGORITHM__TEXT);

		rungEClass = createEClass(RUNG);
		createEAttribute(rungEClass, RUNG__COMMENT);
		createEAttribute(rungEClass, RUNG__EXPRESSION);
		createEAttribute(rungEClass, RUNG__OUTPUT);

		compositeFunctionBlockTypeEClass = createEClass(COMPOSITE_FUNCTION_BLOCK_TYPE);
		createEReference(compositeFunctionBlockTypeEClass, COMPOSITE_FUNCTION_BLOCK_TYPE__SERVICE);

		deviceTypeEClass = createEClass(DEVICE_TYPE);
		createEReference(deviceTypeEClass, DEVICE_TYPE__VAR_DECLARATIONS);
		createEReference(deviceTypeEClass, DEVICE_TYPE__RESOURCES);
		createEReference(deviceTypeEClass, DEVICE_TYPE__FB_NETWORK);
		createEAttribute(deviceTypeEClass, DEVICE_TYPE__RESOURCE_NAMES);

		resourceTypeEClass = createEClass(RESOURCE_TYPE);
		createEReference(resourceTypeEClass, RESOURCE_TYPE__VAR_DECLARATIONS);
		createEReference(resourceTypeEClass, RESOURCE_TYPE__FB_NETWORK);
		createEAttribute(resourceTypeEClass, RESOURCE_TYPE__FB_NAMES);

		basicFunctionBlockDiagramEClass = createEClass(BASIC_FUNCTION_BLOCK_DIAGRAM);
		createEReference(basicFunctionBlockDiagramEClass, BASIC_FUNCTION_BLOCK_DIAGRAM__BFB_TYPE);

		compositeFunctionBlockDiagramEClass = createEClass(COMPOSITE_FUNCTION_BLOCK_DIAGRAM);
		createEReference(compositeFunctionBlockDiagramEClass, COMPOSITE_FUNCTION_BLOCK_DIAGRAM__CFB_TYPE);

		namedAndCommentedEClass = createEClass(NAMED_AND_COMMENTED);
		createEAttribute(namedAndCommentedEClass, NAMED_AND_COMMENTED__COMMENT);
		createEAttribute(namedAndCommentedEClass, NAMED_AND_COMMENTED__NAME);

		identifiableEClass = createEClass(IDENTIFIABLE);
		createEReference(identifiableEClass, IDENTIFIABLE__IDENTIFICATION);
		createEReference(identifiableEClass, IDENTIFIABLE__VERSION_INFOS);

		compilableEClass = createEClass(COMPILABLE);
		createEReference(compilableEClass, COMPILABLE__COMPILER_INFO);

		// Create enums
		segmentTypeEEnum = createEEnum(SEGMENT_TYPE);
		languageEEnum = createEEnum(LANGUAGE);
		varTypeEEnum = createEEnum(VAR_TYPE);
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
		SyncchartsPackage theSyncchartsPackage = (SyncchartsPackage)EPackage.Registry.INSTANCE.getEPackage(SyncchartsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		systemEClass.getESuperTypes().add(this.getIdentifiable());
		systemEClass.getESuperTypes().add(this.getNamedAndCommented());
		applicationEClass.getESuperTypes().add(this.getNamedAndCommented());
		functionBlockNetworkEClass.getESuperTypes().add(this.getNamedAndCommented());
		deviceEClass.getESuperTypes().add(this.getNamedAndCommented());
		segmentEClass.getESuperTypes().add(this.getNamedAndCommented());
		functionBlockEClass.getESuperTypes().add(this.getNamedAndCommented());
		parameterEClass.getESuperTypes().add(this.getNamedAndCommented());
		resourceEClass.getESuperTypes().add(this.getNamedAndCommented());
		functionBlockTypeEClass.getESuperTypes().add(this.getCompilable());
		functionBlockTypeEClass.getESuperTypes().add(this.getNamedAndCommented());
		functionBlockTypeEClass.getESuperTypes().add(this.getFunctionBlockInterface());
		eventConnectionEClass.getESuperTypes().add(this.getConnection());
		dataConnectionEClass.getESuperTypes().add(this.getConnection());
		ififEventConnectionEClass.getESuperTypes().add(this.getEventConnection());
		ififDataConnectionEClass.getESuperTypes().add(this.getDataConnection());
		iffbEventConnectionEClass.getESuperTypes().add(this.getEventConnection());
		iffbDataConnectionEClass.getESuperTypes().add(this.getDataConnection());
		fbifEventConnectionEClass.getESuperTypes().add(this.getEventConnection());
		fbifDataConnectionEClass.getESuperTypes().add(this.getDataConnection());
		fbfbEventConnectionEClass.getESuperTypes().add(this.getEventConnection());
		fbfbDataConnectionEClass.getESuperTypes().add(this.getDataConnection());
		ifivDataConnectionEClass.getESuperTypes().add(this.getDataConnection());
		ivifDataConnectionEClass.getESuperTypes().add(this.getDataConnection());
		fbivDataConnectionEClass.getESuperTypes().add(this.getDataConnection());
		ivfbDataConnectionEClass.getESuperTypes().add(this.getDataConnection());
		ivivDataConnectionEClass.getESuperTypes().add(this.getDataConnection());
		adapterConnectionEClass.getESuperTypes().add(this.getConnection());
		eventEClass.getESuperTypes().add(this.getNamedAndCommented());
		ifInputEventEClass.getESuperTypes().add(this.getEvent());
		fbInputEventEClass.getESuperTypes().add(this.getEvent());
		ifOutputEventEClass.getESuperTypes().add(this.getEvent());
		fbOutputEventEClass.getESuperTypes().add(this.getEvent());
		varEClass.getESuperTypes().add(this.getNamedAndCommented());
		ifInputVarEClass.getESuperTypes().add(this.getVar());
		fbInputVarEClass.getESuperTypes().add(this.getVar());
		ifOutputVarEClass.getESuperTypes().add(this.getVar());
		fbOutputVarEClass.getESuperTypes().add(this.getVar());
		internalVarEClass.getESuperTypes().add(this.getVar());
		inputWithEClass.getESuperTypes().add(this.getWith());
		outputWithEClass.getESuperTypes().add(this.getWith());
		adapterEClass.getESuperTypes().add(this.getNamedAndCommented());
		socketEClass.getESuperTypes().add(this.getAdapter());
		plugEClass.getESuperTypes().add(this.getAdapter());
		adapterTypeEClass.getESuperTypes().add(this.getCompilable());
		adapterTypeEClass.getESuperTypes().add(this.getNamedAndCommented());
		adapterTypeEClass.getESuperTypes().add(this.getFunctionBlockInterface());
		serviceSequenceEClass.getESuperTypes().add(this.getNamedAndCommented());
		inputPrimitiveEClass.getESuperTypes().add(this.getPrimitive());
		outputPrimitiveEClass.getESuperTypes().add(this.getPrimitive());
		basicFunctionBlockTypeEClass.getESuperTypes().add(this.getFunctionBlockType());
		functionBlockDiagramEClass.getESuperTypes().add(this.getNamedAndCommented());
		structuredTextEClass.getESuperTypes().add(this.getNamedAndCommented());
		ladderDiagramEClass.getESuperTypes().add(this.getNamedAndCommented());
		otherAlgorithmEClass.getESuperTypes().add(this.getNamedAndCommented());
		compositeFunctionBlockTypeEClass.getESuperTypes().add(this.getFunctionBlockType());
		compositeFunctionBlockTypeEClass.getESuperTypes().add(this.getFunctionBlockNetwork());
		deviceTypeEClass.getESuperTypes().add(this.getCompilable());
		deviceTypeEClass.getESuperTypes().add(this.getNamedAndCommented());
		resourceTypeEClass.getESuperTypes().add(this.getCompilable());
		resourceTypeEClass.getESuperTypes().add(this.getNamedAndCommented());
		compilableEClass.getESuperTypes().add(this.getIdentifiable());

		// Initialize classes and features; add operations and parameters
		initEClass(systemEClass, de.cau.cs.kieler.cakefeed.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystem_Applications(), this.getApplication(), null, "applications", null, 0, -1, de.cau.cs.kieler.cakefeed.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Devices(), this.getDevice(), null, "devices", null, 1, -1, de.cau.cs.kieler.cakefeed.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Mappings(), this.getMapping(), null, "mappings", null, 0, -1, de.cau.cs.kieler.cakefeed.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Segments(), this.getSegment(), null, "segments", null, 0, -1, de.cau.cs.kieler.cakefeed.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Links(), this.getLink(), null, "links", null, 0, -1, de.cau.cs.kieler.cakefeed.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identificationEClass, Identification.class, "Identification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentification_ApplicationDomain(), ecorePackage.getEString(), "applicationDomain", null, 0, 1, Identification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdentification_Classification(), ecorePackage.getEString(), "classification", null, 0, 1, Identification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdentification_Description(), ecorePackage.getEString(), "description", null, 0, 1, Identification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdentification_Function(), ecorePackage.getEString(), "function", null, 0, 1, Identification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdentification_Standard(), ecorePackage.getEString(), "standard", null, 0, 1, Identification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdentification_Type(), ecorePackage.getEString(), "type", null, 0, 1, Identification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versionInfoEClass, VersionInfo.class, "VersionInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersionInfo_Author(), ecorePackage.getEString(), "author", null, 1, 1, VersionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionInfo_Date(), ecorePackage.getEString(), "date", null, 1, 1, VersionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionInfo_Organisation(), ecorePackage.getEString(), "organisation", null, 1, 1, VersionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionInfo_Remarks(), ecorePackage.getEString(), "remarks", null, 0, 1, VersionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionInfo_Version(), ecorePackage.getEString(), "version", null, 1, 1, VersionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(applicationEClass, Application.class, "Application", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplication_FBNetwork(), this.getFunctionBlockNetwork(), null, "fBNetwork", null, 1, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionBlockNetworkEClass, FunctionBlockNetwork.class, "FunctionBlockNetwork", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionBlockNetwork_FBs(), this.getFunctionBlock(), null, "fBs", null, 0, -1, FunctionBlockNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlockNetwork_EventConnections(), this.getEventConnection(), null, "eventConnections", null, 0, -1, FunctionBlockNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlockNetwork_DataConnections(), this.getDataConnection(), null, "dataConnections", null, 0, -1, FunctionBlockNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlockNetwork_AdapterConnections(), this.getAdapterConnection(), null, "adapterConnections", null, 0, -1, FunctionBlockNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deviceEClass, Device.class, "Device", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDevice_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDevice_Resources(), this.getResource(), null, "resources", null, 0, -1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDevice_FBNetwork(), this.getFunctionBlockNetwork(), null, "fBNetwork", null, 0, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDevice_Type(), this.getDeviceType(), null, "type", null, 1, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMapping_From(), ecorePackage.getEString(), "from", null, 1, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMapping_To(), ecorePackage.getEString(), "to", null, 1, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(segmentEClass, Segment.class, "Segment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSegment_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSegment_Type(), this.getSegmentType(), "type", null, 1, 1, Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkEClass, Link.class, "Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLink_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_CommResource(), ecorePackage.getEString(), "commResource", null, 1, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_SegmentName(), ecorePackage.getEString(), "segmentName", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionBlockEClass, FunctionBlock.class, "FunctionBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionBlock_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, FunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlock_Type(), this.getFunctionBlockType(), null, "type", null, 1, 1, FunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlock_InputEvents(), this.getFBInputEvent(), null, "inputEvents", null, 0, -1, FunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlock_OutputEvents(), this.getFBOutputEvent(), null, "outputEvents", null, 0, -1, FunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlock_InputVars(), this.getFBInputVar(), null, "inputVars", null, 0, -1, FunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlock_OutputVars(), this.getFBOutputVar(), null, "outputVars", null, 0, -1, FunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionBlockInterfaceEClass, FunctionBlockInterface.class, "FunctionBlockInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionBlockInterface_InputEvents(), this.getIFInputEvent(), null, "inputEvents", null, 0, -1, FunctionBlockInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlockInterface_OutputEvents(), this.getIFOutputEvent(), null, "outputEvents", null, 0, -1, FunctionBlockInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlockInterface_InputVars(), this.getIFInputVar(), null, "inputVars", null, 0, -1, FunctionBlockInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlockInterface_OutputVars(), this.getIFOutputVar(), null, "outputVars", null, 0, -1, FunctionBlockInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlockInterface_Sockets(), this.getAdapter(), null, "sockets", null, 0, -1, FunctionBlockInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlockInterface_Plugs(), this.getAdapter(), null, "plugs", null, 0, -1, FunctionBlockInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Value(), ecorePackage.getEString(), "value", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResource_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResource_FBNetwork(), this.getFunctionBlockNetwork(), null, "fBNetwork", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResource_Type(), this.getResourceType(), null, "type", null, 1, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionBlockTypeEClass, FunctionBlockType.class, "FunctionBlockType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(connectionEClass, Connection.class, "Connection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnection_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventConnectionEClass, EventConnection.class, "EventConnection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataConnectionEClass, DataConnection.class, "DataConnection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compilerInfoEClass, CompilerInfo.class, "CompilerInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompilerInfo_Compilers(), this.getCompiler(), null, "compilers", null, 0, -1, CompilerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompilerInfo_Classdef(), ecorePackage.getEString(), "classdef", null, 0, 1, CompilerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompilerInfo_Header(), ecorePackage.getEString(), "header", null, 0, 1, CompilerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ififEventConnectionEClass, IFIFEventConnection.class, "IFIFEventConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIFIFEventConnection_Destination(), this.getIFOutputEvent(), null, "destination", null, 1, 1, IFIFEventConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIFIFEventConnection_Source(), this.getIFInputEvent(), null, "source", null, 1, 1, IFIFEventConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ififDataConnectionEClass, IFIFDataConnection.class, "IFIFDataConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIFIFDataConnection_Destination(), this.getIFOutputVar(), null, "destination", null, 1, 1, IFIFDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIFIFDataConnection_Source(), this.getIFInputVar(), null, "source", null, 1, 1, IFIFDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iffbEventConnectionEClass, IFFBEventConnection.class, "IFFBEventConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIFFBEventConnection_Destination(), this.getFBInputEvent(), null, "destination", null, 1, 1, IFFBEventConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIFFBEventConnection_Source(), this.getIFInputEvent(), null, "source", null, 1, 1, IFFBEventConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iffbDataConnectionEClass, IFFBDataConnection.class, "IFFBDataConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIFFBDataConnection_Destination(), this.getFBInputVar(), null, "destination", null, 1, 1, IFFBDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIFFBDataConnection_Source(), this.getIFInputVar(), null, "source", null, 1, 1, IFFBDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fbifEventConnectionEClass, FBIFEventConnection.class, "FBIFEventConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFBIFEventConnection_Destination(), this.getIFOutputEvent(), null, "destination", null, 1, 1, FBIFEventConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFBIFEventConnection_Source(), this.getFBOutputEvent(), null, "source", null, 1, 1, FBIFEventConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fbifDataConnectionEClass, FBIFDataConnection.class, "FBIFDataConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFBIFDataConnection_Destination(), this.getIFOutputVar(), null, "destination", null, 1, 1, FBIFDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFBIFDataConnection_Source(), this.getFBOutputVar(), null, "source", null, 1, 1, FBIFDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fbfbEventConnectionEClass, FBFBEventConnection.class, "FBFBEventConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFBFBEventConnection_Destination(), this.getFBInputEvent(), null, "destination", null, 1, 1, FBFBEventConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFBFBEventConnection_Source(), this.getFBOutputEvent(), null, "source", null, 1, 1, FBFBEventConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fbfbDataConnectionEClass, FBFBDataConnection.class, "FBFBDataConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFBFBDataConnection_Destination(), this.getFBInputVar(), null, "destination", null, 1, 1, FBFBDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFBFBDataConnection_Source(), this.getFBOutputVar(), null, "source", null, 1, 1, FBFBDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifivDataConnectionEClass, IFIVDataConnection.class, "IFIVDataConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIFIVDataConnection_Destination(), this.getInternalVar(), null, "destination", null, 1, 1, IFIVDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIFIVDataConnection_Source(), this.getIFInputVar(), null, "source", null, 1, 1, IFIVDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ivifDataConnectionEClass, IVIFDataConnection.class, "IVIFDataConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIVIFDataConnection_Destination(), this.getIFOutputVar(), null, "destination", null, 1, 1, IVIFDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIVIFDataConnection_Source(), this.getInternalVar(), null, "source", null, 1, 1, IVIFDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fbivDataConnectionEClass, FBIVDataConnection.class, "FBIVDataConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFBIVDataConnection_Destination(), this.getInternalVar(), null, "destination", null, 1, 1, FBIVDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFBIVDataConnection_Source(), this.getFBOutputVar(), null, "source", null, 1, 1, FBIVDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ivfbDataConnectionEClass, IVFBDataConnection.class, "IVFBDataConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIVFBDataConnection_Destination(), this.getFBInputVar(), null, "destination", null, 1, 1, IVFBDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIVFBDataConnection_Source(), this.getInternalVar(), null, "source", null, 1, 1, IVFBDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ivivDataConnectionEClass, IVIVDataConnection.class, "IVIVDataConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIVIVDataConnection_Destination(), this.getInternalVar(), null, "destination", null, 1, 1, IVIVDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIVIVDataConnection_Source(), this.getInternalVar(), null, "source", null, 1, 1, IVIVDataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adapterConnectionEClass, AdapterConnection.class, "AdapterConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventEClass, Event.class, "Event", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvent_Type(), ecorePackage.getEString(), "type", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifInputEventEClass, IFInputEvent.class, "IFInputEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIFInputEvent_With(), this.getInputWith(), this.getInputWith_ParentInputEvent(), "with", null, 0, -1, IFInputEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fbInputEventEClass, FBInputEvent.class, "FBInputEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ifOutputEventEClass, IFOutputEvent.class, "IFOutputEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIFOutputEvent_With(), this.getOutputWith(), this.getOutputWith_ParentOutputEvent(), "with", null, 0, -1, IFOutputEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fbOutputEventEClass, FBOutputEvent.class, "FBOutputEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(varEClass, Var.class, "Var", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVar_ArraySize(), ecorePackage.getEInt(), "arraySize", null, 0, 1, Var.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVar_InitialValue(), ecorePackage.getEString(), "initialValue", null, 0, 1, Var.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVar_Type(), this.getVarType(), "type", null, 1, 1, Var.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifInputVarEClass, IFInputVar.class, "IFInputVar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fbInputVarEClass, FBInputVar.class, "FBInputVar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ifOutputVarEClass, IFOutputVar.class, "IFOutputVar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fbOutputVarEClass, FBOutputVar.class, "FBOutputVar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(internalVarEClass, InternalVar.class, "InternalVar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compilerEClass, de.cau.cs.kieler.cakefeed.Compiler.class, "Compiler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompiler_Language(), this.getLanguage(), "language", null, 1, 1, de.cau.cs.kieler.cakefeed.Compiler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompiler_Product(), ecorePackage.getEString(), "product", null, 1, 1, de.cau.cs.kieler.cakefeed.Compiler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompiler_Vendor(), ecorePackage.getEString(), "vendor", null, 1, 1, de.cau.cs.kieler.cakefeed.Compiler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompiler_Version(), ecorePackage.getEString(), "version", null, 1, 1, de.cau.cs.kieler.cakefeed.Compiler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(withEClass, With.class, "With", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputWithEClass, InputWith.class, "InputWith", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputWith_ParentInputEvent(), this.getIFInputEvent(), this.getIFInputEvent_With(), "parentInputEvent", null, 1, 1, InputWith.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInputWith_With(), this.getIFInputVar(), null, "with", null, 1, 1, InputWith.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputWithEClass, OutputWith.class, "OutputWith", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputWith_ParentOutputEvent(), this.getIFOutputEvent(), this.getIFOutputEvent_With(), "parentOutputEvent", null, 1, 1, OutputWith.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutputWith_With(), this.getIFOutputVar(), null, "with", null, 1, 1, OutputWith.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adapterEClass, Adapter.class, "Adapter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdapter_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Adapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdapter_Type(), this.getAdapterType(), null, "type", null, 1, 1, Adapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(socketEClass, Socket.class, "Socket", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(plugEClass, Plug.class, "Plug", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(adapterTypeEClass, AdapterType.class, "AdapterType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdapterType_Service(), this.getService(), null, "service", null, 0, 1, AdapterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getService_ServiceSequences(), this.getServiceSequence(), null, "serviceSequences", null, 1, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_RightInterface(), ecorePackage.getEString(), "rightInterface", null, 1, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_LeftInterface(), ecorePackage.getEString(), "leftInterface", null, 1, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceSequenceEClass, ServiceSequence.class, "ServiceSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceSequence_ServiceTransactions(), this.getServiceTransaction(), null, "serviceTransactions", null, 0, -1, ServiceSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceTransactionEClass, ServiceTransaction.class, "ServiceTransaction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceTransaction_InputPrimitive(), this.getInputPrimitive(), null, "inputPrimitive", null, 0, 1, ServiceTransaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceTransaction_OutputPrimitives(), this.getOutputPrimitive(), null, "outputPrimitives", null, 0, -1, ServiceTransaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveEClass, Primitive.class, "Primitive", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitive_Event(), ecorePackage.getEString(), "event", null, 1, 1, Primitive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimitive_Interface(), ecorePackage.getEString(), "interface", null, 1, 1, Primitive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimitive_Parameters(), ecorePackage.getEString(), "parameters", null, 0, 1, Primitive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputPrimitiveEClass, InputPrimitive.class, "InputPrimitive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outputPrimitiveEClass, OutputPrimitive.class, "OutputPrimitive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(basicFunctionBlockTypeEClass, BasicFunctionBlockType.class, "BasicFunctionBlockType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicFunctionBlockType_Service(), this.getService(), null, "service", null, 0, 1, BasicFunctionBlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicFunctionBlockType_SyncChart(), theSyncchartsPackage.getState(), null, "syncChart", null, 0, 1, BasicFunctionBlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicFunctionBlockType_InternalVars(), this.getInternalVar(), null, "internalVars", null, 0, -1, BasicFunctionBlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicFunctionBlockType_FunctionBlockDiagrams(), this.getFunctionBlockDiagram(), null, "functionBlockDiagrams", null, 0, -1, BasicFunctionBlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicFunctionBlockType_StructuredTexts(), this.getStructuredText(), null, "structuredTexts", null, 0, -1, BasicFunctionBlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicFunctionBlockType_LadderDiagrams(), this.getLadderDiagram(), null, "ladderDiagrams", null, 0, -1, BasicFunctionBlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicFunctionBlockType_OtherAlgorithms(), this.getOtherAlgorithm(), null, "otherAlgorithms", null, 0, -1, BasicFunctionBlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionBlockDiagramEClass, FunctionBlockDiagram.class, "FunctionBlockDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionBlockDiagram_FBs(), this.getFunctionBlock(), null, "fBs", null, 1, -1, FunctionBlockDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlockDiagram_DataConnections(), this.getFBFBDataConnection(), null, "dataConnections", null, 0, -1, FunctionBlockDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuredTextEClass, StructuredText.class, "StructuredText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStructuredText_Text(), ecorePackage.getEString(), "text", null, 1, 1, StructuredText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ladderDiagramEClass, LadderDiagram.class, "LadderDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLadderDiagram_Rungs(), this.getRung(), null, "rungs", null, 1, -1, LadderDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(otherAlgorithmEClass, OtherAlgorithm.class, "OtherAlgorithm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOtherAlgorithm_Language(), ecorePackage.getEString(), "language", null, 1, 1, OtherAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOtherAlgorithm_Prototype(), ecorePackage.getEString(), "prototype", null, 1, 1, OtherAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOtherAlgorithm_Text(), ecorePackage.getEString(), "text", null, 1, 1, OtherAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rungEClass, Rung.class, "Rung", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRung_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, Rung.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRung_Expression(), ecorePackage.getEString(), "expression", null, 1, 1, Rung.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRung_Output(), ecorePackage.getEString(), "output", null, 1, 1, Rung.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeFunctionBlockTypeEClass, CompositeFunctionBlockType.class, "CompositeFunctionBlockType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeFunctionBlockType_Service(), this.getService(), null, "service", null, 0, 1, CompositeFunctionBlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deviceTypeEClass, DeviceType.class, "DeviceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeviceType_VarDeclarations(), this.getInternalVar(), null, "varDeclarations", null, 0, -1, DeviceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeviceType_Resources(), this.getResource(), null, "resources", null, 0, -1, DeviceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeviceType_FBNetwork(), this.getFunctionBlockNetwork(), null, "fBNetwork", null, 0, 1, DeviceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeviceType_ResourceNames(), ecorePackage.getEString(), "resourceNames", null, 0, -1, DeviceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceTypeEClass, ResourceType.class, "ResourceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceType_VarDeclarations(), this.getInternalVar(), null, "varDeclarations", null, 0, -1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceType_FBNetwork(), this.getFunctionBlockNetwork(), null, "fBNetwork", null, 1, 1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceType_FBNames(), ecorePackage.getEString(), "fBNames", null, 0, -1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(basicFunctionBlockDiagramEClass, BasicFunctionBlockDiagram.class, "BasicFunctionBlockDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicFunctionBlockDiagram_BFBType(), this.getBasicFunctionBlockType(), null, "bFBType", null, 1, 1, BasicFunctionBlockDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeFunctionBlockDiagramEClass, CompositeFunctionBlockDiagram.class, "CompositeFunctionBlockDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeFunctionBlockDiagram_CFBType(), this.getCompositeFunctionBlockType(), null, "cFBType", null, 1, 1, CompositeFunctionBlockDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedAndCommentedEClass, NamedAndCommented.class, "NamedAndCommented", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedAndCommented_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, NamedAndCommented.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedAndCommented_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedAndCommented.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identifiableEClass, Identifiable.class, "Identifiable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIdentifiable_Identification(), this.getIdentification(), null, "identification", null, 0, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdentifiable_VersionInfos(), this.getVersionInfo(), null, "versionInfos", null, 1, -1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compilableEClass, Compilable.class, "Compilable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompilable_CompilerInfo(), this.getCompilerInfo(), null, "compilerInfo", null, 0, 1, Compilable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(segmentTypeEEnum, SegmentType.class, "SegmentType");
		addEEnumLiteral(segmentTypeEEnum, SegmentType.LOCAL_HOST);
		addEEnumLiteral(segmentTypeEEnum, SegmentType.LOCAL_BUS);
		addEEnumLiteral(segmentTypeEEnum, SegmentType.ETHERNET);
		addEEnumLiteral(segmentTypeEEnum, SegmentType.DEVICE_NET);
		addEEnumLiteral(segmentTypeEEnum, SegmentType.CONTROL_NET);

		initEEnum(languageEEnum, Language.class, "Language");
		addEEnumLiteral(languageEEnum, Language.JAVA);
		addEEnumLiteral(languageEEnum, Language.CPP);
		addEEnumLiteral(languageEEnum, Language.C);
		addEEnumLiteral(languageEEnum, Language.OTHER);

		initEEnum(varTypeEEnum, VarType.class, "VarType");
		addEEnumLiteral(varTypeEEnum, VarType.BYTE);
		addEEnumLiteral(varTypeEEnum, VarType.DT);
		addEEnumLiteral(varTypeEEnum, VarType.LREAL);
		addEEnumLiteral(varTypeEEnum, VarType.UINT);
		addEEnumLiteral(varTypeEEnum, VarType.LINT);
		addEEnumLiteral(varTypeEEnum, VarType.BOOL);
		addEEnumLiteral(varTypeEEnum, VarType.DATE_AND_TIME);
		addEEnumLiteral(varTypeEEnum, VarType.INT);
		addEEnumLiteral(varTypeEEnum, VarType.SINT);
		addEEnumLiteral(varTypeEEnum, VarType.LWORD);
		addEEnumLiteral(varTypeEEnum, VarType.COLOR);
		addEEnumLiteral(varTypeEEnum, VarType.WORD);
		addEEnumLiteral(varTypeEEnum, VarType.REAL);
		addEEnumLiteral(varTypeEEnum, VarType.TIME);
		addEEnumLiteral(varTypeEEnum, VarType.TOD);
		addEEnumLiteral(varTypeEEnum, VarType.ANY);
		addEEnumLiteral(varTypeEEnum, VarType.DWORD);
		addEEnumLiteral(varTypeEEnum, VarType.UDINT);
		addEEnumLiteral(varTypeEEnum, VarType.USINT);
		addEEnumLiteral(varTypeEEnum, VarType.TIME_OF_DAY);
		addEEnumLiteral(varTypeEEnum, VarType.WSTRING);
		addEEnumLiteral(varTypeEEnum, VarType.DINT);
		addEEnumLiteral(varTypeEEnum, VarType.DATE);
		addEEnumLiteral(varTypeEEnum, VarType.ULINT);
		addEEnumLiteral(varTypeEEnum, VarType.VSTYLE);
		addEEnumLiteral(varTypeEEnum, VarType.ARRAY);
		addEEnumLiteral(varTypeEEnum, VarType.STRING);

		// Create resource
		createResource(eNS_URI);
	}

} //CakefeedPackageImpl
