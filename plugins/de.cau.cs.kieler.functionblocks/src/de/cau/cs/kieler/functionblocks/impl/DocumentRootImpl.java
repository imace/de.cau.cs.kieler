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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getAdapterConnections <em>Adapter Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getAdapterDeclaration <em>Adapter Declaration</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getAdapterType <em>Adapter Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getApplication <em>Application</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getBasicFB <em>Basic FB</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getCompiler <em>Compiler</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getCompilerInfo <em>Compiler Info</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getConnection <em>Connection</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getDataConnections <em>Data Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getDevice <em>Device</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getDeviceType <em>Device Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getECAction <em>EC Action</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getECC <em>ECC</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getECState <em>EC State</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getECTransition <em>EC Transition</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getEventConnections <em>Event Connections</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getEventInputs <em>Event Inputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getEventOutputs <em>Event Outputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getFB <em>FB</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getFBD <em>FBD</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getFBNetwork <em>FB Network</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getFBType <em>FB Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getFBTypeName <em>FB Type Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getHCECC <em>HCECC</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getHCECCRelation <em>HCECC Relation</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getInputPrimitive <em>Input Primitive</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getInputVars <em>Input Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getInterfaceList <em>Interface List</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getInternalVars <em>Internal Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getLD <em>LD</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getLink <em>Link</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getMapping <em>Mapping</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getOther <em>Other</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getOutputPrimitive <em>Output Primitive</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getOutputVars <em>Output Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getPlugs <em>Plugs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getResourceTypeName <em>Resource Type Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getRung <em>Rung</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getSegment <em>Segment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getService <em>Service</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getServiceSequence <em>Service Sequence</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getServiceTransaction <em>Service Transaction</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getSockets <em>Sockets</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getST <em>ST</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getSubApp <em>Sub App</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getSubAppEvent <em>Sub App Event</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getSubAppEventInputs <em>Sub App Event Inputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getSubAppEventOutputs <em>Sub App Event Outputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getSubAppInterfaceList <em>Sub App Interface List</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getSubAppNetwork <em>Sub App Network</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getSubAppType <em>Sub App Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getSystem <em>System</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getVarDeclaration <em>Var Declaration</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getVersionInfo <em>Version Info</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.DocumentRootImpl#getWith <em>With</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends EObjectImpl implements DocumentRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblocksPackage.Literals.DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, FunctionblocksPackage.DOCUMENT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, FunctionblocksPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, FunctionblocksPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterConnections getAdapterConnections() {
		return (AdapterConnections)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ADAPTER_CONNECTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdapterConnections(AdapterConnections newAdapterConnections, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ADAPTER_CONNECTIONS, newAdapterConnections, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdapterConnections(AdapterConnections newAdapterConnections) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ADAPTER_CONNECTIONS, newAdapterConnections);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterDeclaration getAdapterDeclaration() {
		return (AdapterDeclaration)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ADAPTER_DECLARATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdapterDeclaration(AdapterDeclaration newAdapterDeclaration, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ADAPTER_DECLARATION, newAdapterDeclaration, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdapterDeclaration(AdapterDeclaration newAdapterDeclaration) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ADAPTER_DECLARATION, newAdapterDeclaration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterType getAdapterType() {
		return (AdapterType)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ADAPTER_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdapterType(AdapterType newAdapterType, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ADAPTER_TYPE, newAdapterType, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdapterType(AdapterType newAdapterType) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ADAPTER_TYPE, newAdapterType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Algorithm getAlgorithm() {
		return (Algorithm)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ALGORITHM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAlgorithm(Algorithm newAlgorithm, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ALGORITHM, newAlgorithm, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithm(Algorithm newAlgorithm) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ALGORITHM, newAlgorithm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Application getApplication() {
		return (Application)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__APPLICATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApplication(Application newApplication, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__APPLICATION, newApplication, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplication(Application newApplication) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__APPLICATION, newApplication);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFB getBasicFB() {
		return (BasicFB)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__BASIC_FB, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBasicFB(BasicFB newBasicFB, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__BASIC_FB, newBasicFB, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasicFB(BasicFB newBasicFB) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__BASIC_FB, newBasicFB);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.cau.cs.kieler.functionblocks.Compiler getCompiler() {
		return (de.cau.cs.kieler.functionblocks.Compiler)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__COMPILER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompiler(de.cau.cs.kieler.functionblocks.Compiler newCompiler, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__COMPILER, newCompiler, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompiler(de.cau.cs.kieler.functionblocks.Compiler newCompiler) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__COMPILER, newCompiler);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompilerInfo getCompilerInfo() {
		return (CompilerInfo)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__COMPILER_INFO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompilerInfo(CompilerInfo newCompilerInfo, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__COMPILER_INFO, newCompilerInfo, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompilerInfo(CompilerInfo newCompilerInfo) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__COMPILER_INFO, newCompilerInfo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection getConnection() {
		return (Connection)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__CONNECTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConnection(Connection newConnection, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__CONNECTION, newConnection, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnection(Connection newConnection) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__CONNECTION, newConnection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataConnections getDataConnections() {
		return (DataConnections)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__DATA_CONNECTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataConnections(DataConnections newDataConnections, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__DATA_CONNECTIONS, newDataConnections, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataConnections(DataConnections newDataConnections) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__DATA_CONNECTIONS, newDataConnections);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Device getDevice() {
		return (Device)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__DEVICE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDevice(Device newDevice, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__DEVICE, newDevice, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDevice(Device newDevice) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__DEVICE, newDevice);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceType getDeviceType() {
		return (DeviceType)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__DEVICE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeviceType(DeviceType newDeviceType, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__DEVICE_TYPE, newDeviceType, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeviceType(DeviceType newDeviceType) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__DEVICE_TYPE, newDeviceType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECAction getECAction() {
		return (ECAction)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EC_ACTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetECAction(ECAction newECAction, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EC_ACTION, newECAction, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setECAction(ECAction newECAction) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EC_ACTION, newECAction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECC getECC() {
		return (ECC)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ECC, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetECC(ECC newECC, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ECC, newECC, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setECC(ECC newECC) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ECC, newECC);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECState getECState() {
		return (ECState)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EC_STATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetECState(ECState newECState, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EC_STATE, newECState, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setECState(ECState newECState) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EC_STATE, newECState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECTransition getECTransition() {
		return (ECTransition)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EC_TRANSITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetECTransition(ECTransition newECTransition, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EC_TRANSITION, newECTransition, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setECTransition(ECTransition newECTransition) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EC_TRANSITION, newECTransition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event getEvent() {
		return (Event)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EVENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEvent(Event newEvent, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EVENT, newEvent, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvent(Event newEvent) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EVENT, newEvent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventConnections getEventConnections() {
		return (EventConnections)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EVENT_CONNECTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventConnections(EventConnections newEventConnections, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EVENT_CONNECTIONS, newEventConnections, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventConnections(EventConnections newEventConnections) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EVENT_CONNECTIONS, newEventConnections);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventInputs getEventInputs() {
		return (EventInputs)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EVENT_INPUTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventInputs(EventInputs newEventInputs, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EVENT_INPUTS, newEventInputs, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventInputs(EventInputs newEventInputs) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EVENT_INPUTS, newEventInputs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventOutputs getEventOutputs() {
		return (EventOutputs)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EVENT_OUTPUTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventOutputs(EventOutputs newEventOutputs, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EVENT_OUTPUTS, newEventOutputs, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventOutputs(EventOutputs newEventOutputs) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__EVENT_OUTPUTS, newEventOutputs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FB getFB() {
		return (FB)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__FB, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFB(FB newFB, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__FB, newFB, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFB(FB newFB) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__FB, newFB);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBD getFBD() {
		return (FBD)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__FBD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFBD(FBD newFBD, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__FBD, newFBD, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFBD(FBD newFBD) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__FBD, newFBD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBNetwork getFBNetwork() {
		return (FBNetwork)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__FB_NETWORK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFBNetwork(FBNetwork newFBNetwork, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__FB_NETWORK, newFBNetwork, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFBNetwork(FBNetwork newFBNetwork) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__FB_NETWORK, newFBNetwork);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBType getFBType() {
		return (FBType)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__FB_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFBType(FBType newFBType, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__FB_TYPE, newFBType, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFBType(FBType newFBType) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__FB_TYPE, newFBType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBTypeName getFBTypeName() {
		return (FBTypeName)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__FB_TYPE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFBTypeName(FBTypeName newFBTypeName, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__FB_TYPE_NAME, newFBTypeName, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFBTypeName(FBTypeName newFBTypeName) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__FB_TYPE_NAME, newFBTypeName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HCECC getHCECC() {
		return (HCECC)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__HCECC, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHCECC(HCECC newHCECC, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__HCECC, newHCECC, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHCECC(HCECC newHCECC) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__HCECC, newHCECC);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HCECCRelation getHCECCRelation() {
		return (HCECCRelation)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__HCECC_RELATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHCECCRelation(HCECCRelation newHCECCRelation, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__HCECC_RELATION, newHCECCRelation, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHCECCRelation(HCECCRelation newHCECCRelation) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__HCECC_RELATION, newHCECCRelation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identification getIdentification() {
		return (Identification)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__IDENTIFICATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentification(Identification newIdentification, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__IDENTIFICATION, newIdentification, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentification(Identification newIdentification) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__IDENTIFICATION, newIdentification);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPrimitive getInputPrimitive() {
		return (InputPrimitive)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__INPUT_PRIMITIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputPrimitive(InputPrimitive newInputPrimitive, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__INPUT_PRIMITIVE, newInputPrimitive, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputPrimitive(InputPrimitive newInputPrimitive) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__INPUT_PRIMITIVE, newInputPrimitive);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputVars getInputVars() {
		return (InputVars)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__INPUT_VARS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputVars(InputVars newInputVars, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__INPUT_VARS, newInputVars, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputVars(InputVars newInputVars) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__INPUT_VARS, newInputVars);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceList getInterfaceList() {
		return (InterfaceList)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__INTERFACE_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterfaceList(InterfaceList newInterfaceList, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__INTERFACE_LIST, newInterfaceList, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceList(InterfaceList newInterfaceList) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__INTERFACE_LIST, newInterfaceList);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalVars getInternalVars() {
		return (InternalVars)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__INTERNAL_VARS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInternalVars(InternalVars newInternalVars, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__INTERNAL_VARS, newInternalVars, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalVars(InternalVars newInternalVars) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__INTERNAL_VARS, newInternalVars);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LD getLD() {
		return (LD)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__LD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLD(LD newLD, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__LD, newLD, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLD(LD newLD) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__LD, newLD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link getLink() {
		return (Link)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__LINK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLink(Link newLink, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__LINK, newLink, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink(Link newLink) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__LINK, newLink);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping getMapping() {
		return (Mapping)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__MAPPING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMapping(Mapping newMapping, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__MAPPING, newMapping, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapping(Mapping newMapping) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__MAPPING, newMapping);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Other getOther() {
		return (Other)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__OTHER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOther(Other newOther, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__OTHER, newOther, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOther(Other newOther) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__OTHER, newOther);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPrimitive getOutputPrimitive() {
		return (OutputPrimitive)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__OUTPUT_PRIMITIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputPrimitive(OutputPrimitive newOutputPrimitive, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__OUTPUT_PRIMITIVE, newOutputPrimitive, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputPrimitive(OutputPrimitive newOutputPrimitive) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__OUTPUT_PRIMITIVE, newOutputPrimitive);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputVars getOutputVars() {
		return (OutputVars)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__OUTPUT_VARS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputVars(OutputVars newOutputVars, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__OUTPUT_VARS, newOutputVars, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputVars(OutputVars newOutputVars) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__OUTPUT_VARS, newOutputVars);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getParameter() {
		return (Parameter)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__PARAMETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameter(Parameter newParameter, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__PARAMETER, newParameter, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameter(Parameter newParameter) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__PARAMETER, newParameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Plugs getPlugs() {
		return (Plugs)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__PLUGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlugs(Plugs newPlugs, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__PLUGS, newPlugs, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlugs(Plugs newPlugs) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__PLUGS, newPlugs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getResource() {
		return (Resource)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__RESOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResource(Resource newResource, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__RESOURCE, newResource, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResource(Resource newResource) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__RESOURCE, newResource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType getResourceType() {
		return (ResourceType)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__RESOURCE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceType(ResourceType newResourceType, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__RESOURCE_TYPE, newResourceType, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceType(ResourceType newResourceType) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__RESOURCE_TYPE, newResourceType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceTypeName getResourceTypeName() {
		return (ResourceTypeName)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__RESOURCE_TYPE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceTypeName(ResourceTypeName newResourceTypeName, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__RESOURCE_TYPE_NAME, newResourceTypeName, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceTypeName(ResourceTypeName newResourceTypeName) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__RESOURCE_TYPE_NAME, newResourceTypeName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rung getRung() {
		return (Rung)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__RUNG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRung(Rung newRung, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__RUNG, newRung, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRung(Rung newRung) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__RUNG, newRung);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Segment getSegment() {
		return (Segment)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SEGMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSegment(Segment newSegment, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SEGMENT, newSegment, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSegment(Segment newSegment) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SEGMENT, newSegment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service getService() {
		return (Service)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetService(Service newService, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SERVICE, newService, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setService(Service newService) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SERVICE, newService);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceSequence getServiceSequence() {
		return (ServiceSequence)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SERVICE_SEQUENCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServiceSequence(ServiceSequence newServiceSequence, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SERVICE_SEQUENCE, newServiceSequence, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceSequence(ServiceSequence newServiceSequence) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SERVICE_SEQUENCE, newServiceSequence);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceTransaction getServiceTransaction() {
		return (ServiceTransaction)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SERVICE_TRANSACTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServiceTransaction(ServiceTransaction newServiceTransaction, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SERVICE_TRANSACTION, newServiceTransaction, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceTransaction(ServiceTransaction newServiceTransaction) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SERVICE_TRANSACTION, newServiceTransaction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sockets getSockets() {
		return (Sockets)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SOCKETS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSockets(Sockets newSockets, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SOCKETS, newSockets, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSockets(Sockets newSockets) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SOCKETS, newSockets);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ST getST() {
		return (ST)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetST(ST newST, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ST, newST, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setST(ST newST) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__ST, newST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubApp getSubApp() {
		return (SubApp)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubApp(SubApp newSubApp, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP, newSubApp, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubApp(SubApp newSubApp) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP, newSubApp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppEvent getSubAppEvent() {
		return (SubAppEvent)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_EVENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubAppEvent(SubAppEvent newSubAppEvent, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_EVENT, newSubAppEvent, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubAppEvent(SubAppEvent newSubAppEvent) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_EVENT, newSubAppEvent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppEventInputs getSubAppEventInputs() {
		return (SubAppEventInputs)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_EVENT_INPUTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubAppEventInputs(SubAppEventInputs newSubAppEventInputs, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_EVENT_INPUTS, newSubAppEventInputs, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubAppEventInputs(SubAppEventInputs newSubAppEventInputs) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_EVENT_INPUTS, newSubAppEventInputs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppEventOutputs getSubAppEventOutputs() {
		return (SubAppEventOutputs)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_EVENT_OUTPUTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubAppEventOutputs(SubAppEventOutputs newSubAppEventOutputs, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_EVENT_OUTPUTS, newSubAppEventOutputs, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubAppEventOutputs(SubAppEventOutputs newSubAppEventOutputs) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_EVENT_OUTPUTS, newSubAppEventOutputs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppInterfaceList getSubAppInterfaceList() {
		return (SubAppInterfaceList)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_INTERFACE_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubAppInterfaceList(SubAppInterfaceList newSubAppInterfaceList, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_INTERFACE_LIST, newSubAppInterfaceList, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubAppInterfaceList(SubAppInterfaceList newSubAppInterfaceList) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_INTERFACE_LIST, newSubAppInterfaceList);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppNetwork getSubAppNetwork() {
		return (SubAppNetwork)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_NETWORK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubAppNetwork(SubAppNetwork newSubAppNetwork, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_NETWORK, newSubAppNetwork, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubAppNetwork(SubAppNetwork newSubAppNetwork) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_NETWORK, newSubAppNetwork);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppType getSubAppType() {
		return (SubAppType)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubAppType(SubAppType newSubAppType, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_TYPE, newSubAppType, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubAppType(SubAppType newSubAppType) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SUB_APP_TYPE, newSubAppType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.cau.cs.kieler.functionblocks.System getSystem() {
		return (de.cau.cs.kieler.functionblocks.System)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystem(de.cau.cs.kieler.functionblocks.System newSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SYSTEM, newSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem(de.cau.cs.kieler.functionblocks.System newSystem) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__SYSTEM, newSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarDeclaration getVarDeclaration() {
		return (VarDeclaration)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__VAR_DECLARATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVarDeclaration(VarDeclaration newVarDeclaration, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__VAR_DECLARATION, newVarDeclaration, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarDeclaration(VarDeclaration newVarDeclaration) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__VAR_DECLARATION, newVarDeclaration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionInfo getVersionInfo() {
		return (VersionInfo)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__VERSION_INFO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVersionInfo(VersionInfo newVersionInfo, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__VERSION_INFO, newVersionInfo, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionInfo(VersionInfo newVersionInfo) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__VERSION_INFO, newVersionInfo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public With getWith() {
		return (With)getMixed().get(FunctionblocksPackage.Literals.DOCUMENT_ROOT__WITH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWith(With newWith, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.DOCUMENT_ROOT__WITH, newWith, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWith(With newWith) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.DOCUMENT_ROOT__WITH, newWith);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblocksPackage.DOCUMENT_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__ADAPTER_CONNECTIONS:
				return basicSetAdapterConnections(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__ADAPTER_DECLARATION:
				return basicSetAdapterDeclaration(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__ADAPTER_TYPE:
				return basicSetAdapterType(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__ALGORITHM:
				return basicSetAlgorithm(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__APPLICATION:
				return basicSetApplication(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__BASIC_FB:
				return basicSetBasicFB(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__COMPILER:
				return basicSetCompiler(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__COMPILER_INFO:
				return basicSetCompilerInfo(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__CONNECTION:
				return basicSetConnection(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__DATA_CONNECTIONS:
				return basicSetDataConnections(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__DEVICE:
				return basicSetDevice(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__DEVICE_TYPE:
				return basicSetDeviceType(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__EC_ACTION:
				return basicSetECAction(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__ECC:
				return basicSetECC(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__EC_STATE:
				return basicSetECState(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__EC_TRANSITION:
				return basicSetECTransition(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT:
				return basicSetEvent(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT_CONNECTIONS:
				return basicSetEventConnections(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT_INPUTS:
				return basicSetEventInputs(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT_OUTPUTS:
				return basicSetEventOutputs(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__FB:
				return basicSetFB(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__FBD:
				return basicSetFBD(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__FB_NETWORK:
				return basicSetFBNetwork(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__FB_TYPE:
				return basicSetFBType(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__FB_TYPE_NAME:
				return basicSetFBTypeName(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__HCECC:
				return basicSetHCECC(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__HCECC_RELATION:
				return basicSetHCECCRelation(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__IDENTIFICATION:
				return basicSetIdentification(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__INPUT_PRIMITIVE:
				return basicSetInputPrimitive(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__INPUT_VARS:
				return basicSetInputVars(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__INTERFACE_LIST:
				return basicSetInterfaceList(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__INTERNAL_VARS:
				return basicSetInternalVars(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__LD:
				return basicSetLD(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__LINK:
				return basicSetLink(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__MAPPING:
				return basicSetMapping(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__OTHER:
				return basicSetOther(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__OUTPUT_PRIMITIVE:
				return basicSetOutputPrimitive(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__OUTPUT_VARS:
				return basicSetOutputVars(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__PARAMETER:
				return basicSetParameter(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__PLUGS:
				return basicSetPlugs(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__RESOURCE:
				return basicSetResource(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__RESOURCE_TYPE:
				return basicSetResourceType(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__RESOURCE_TYPE_NAME:
				return basicSetResourceTypeName(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__RUNG:
				return basicSetRung(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__SEGMENT:
				return basicSetSegment(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__SERVICE:
				return basicSetService(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__SERVICE_SEQUENCE:
				return basicSetServiceSequence(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__SERVICE_TRANSACTION:
				return basicSetServiceTransaction(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__SOCKETS:
				return basicSetSockets(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__ST:
				return basicSetST(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP:
				return basicSetSubApp(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_EVENT:
				return basicSetSubAppEvent(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_EVENT_INPUTS:
				return basicSetSubAppEventInputs(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_EVENT_OUTPUTS:
				return basicSetSubAppEventOutputs(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_INTERFACE_LIST:
				return basicSetSubAppInterfaceList(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_NETWORK:
				return basicSetSubAppNetwork(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_TYPE:
				return basicSetSubAppType(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__SYSTEM:
				return basicSetSystem(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__VAR_DECLARATION:
				return basicSetVarDeclaration(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__VERSION_INFO:
				return basicSetVersionInfo(null, msgs);
			case FunctionblocksPackage.DOCUMENT_ROOT__WITH:
				return basicSetWith(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FunctionblocksPackage.DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case FunctionblocksPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case FunctionblocksPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case FunctionblocksPackage.DOCUMENT_ROOT__ADAPTER_CONNECTIONS:
				return getAdapterConnections();
			case FunctionblocksPackage.DOCUMENT_ROOT__ADAPTER_DECLARATION:
				return getAdapterDeclaration();
			case FunctionblocksPackage.DOCUMENT_ROOT__ADAPTER_TYPE:
				return getAdapterType();
			case FunctionblocksPackage.DOCUMENT_ROOT__ALGORITHM:
				return getAlgorithm();
			case FunctionblocksPackage.DOCUMENT_ROOT__APPLICATION:
				return getApplication();
			case FunctionblocksPackage.DOCUMENT_ROOT__BASIC_FB:
				return getBasicFB();
			case FunctionblocksPackage.DOCUMENT_ROOT__COMPILER:
				return getCompiler();
			case FunctionblocksPackage.DOCUMENT_ROOT__COMPILER_INFO:
				return getCompilerInfo();
			case FunctionblocksPackage.DOCUMENT_ROOT__CONNECTION:
				return getConnection();
			case FunctionblocksPackage.DOCUMENT_ROOT__DATA_CONNECTIONS:
				return getDataConnections();
			case FunctionblocksPackage.DOCUMENT_ROOT__DEVICE:
				return getDevice();
			case FunctionblocksPackage.DOCUMENT_ROOT__DEVICE_TYPE:
				return getDeviceType();
			case FunctionblocksPackage.DOCUMENT_ROOT__EC_ACTION:
				return getECAction();
			case FunctionblocksPackage.DOCUMENT_ROOT__ECC:
				return getECC();
			case FunctionblocksPackage.DOCUMENT_ROOT__EC_STATE:
				return getECState();
			case FunctionblocksPackage.DOCUMENT_ROOT__EC_TRANSITION:
				return getECTransition();
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT:
				return getEvent();
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT_CONNECTIONS:
				return getEventConnections();
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT_INPUTS:
				return getEventInputs();
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT_OUTPUTS:
				return getEventOutputs();
			case FunctionblocksPackage.DOCUMENT_ROOT__FB:
				return getFB();
			case FunctionblocksPackage.DOCUMENT_ROOT__FBD:
				return getFBD();
			case FunctionblocksPackage.DOCUMENT_ROOT__FB_NETWORK:
				return getFBNetwork();
			case FunctionblocksPackage.DOCUMENT_ROOT__FB_TYPE:
				return getFBType();
			case FunctionblocksPackage.DOCUMENT_ROOT__FB_TYPE_NAME:
				return getFBTypeName();
			case FunctionblocksPackage.DOCUMENT_ROOT__HCECC:
				return getHCECC();
			case FunctionblocksPackage.DOCUMENT_ROOT__HCECC_RELATION:
				return getHCECCRelation();
			case FunctionblocksPackage.DOCUMENT_ROOT__IDENTIFICATION:
				return getIdentification();
			case FunctionblocksPackage.DOCUMENT_ROOT__INPUT_PRIMITIVE:
				return getInputPrimitive();
			case FunctionblocksPackage.DOCUMENT_ROOT__INPUT_VARS:
				return getInputVars();
			case FunctionblocksPackage.DOCUMENT_ROOT__INTERFACE_LIST:
				return getInterfaceList();
			case FunctionblocksPackage.DOCUMENT_ROOT__INTERNAL_VARS:
				return getInternalVars();
			case FunctionblocksPackage.DOCUMENT_ROOT__LD:
				return getLD();
			case FunctionblocksPackage.DOCUMENT_ROOT__LINK:
				return getLink();
			case FunctionblocksPackage.DOCUMENT_ROOT__MAPPING:
				return getMapping();
			case FunctionblocksPackage.DOCUMENT_ROOT__OTHER:
				return getOther();
			case FunctionblocksPackage.DOCUMENT_ROOT__OUTPUT_PRIMITIVE:
				return getOutputPrimitive();
			case FunctionblocksPackage.DOCUMENT_ROOT__OUTPUT_VARS:
				return getOutputVars();
			case FunctionblocksPackage.DOCUMENT_ROOT__PARAMETER:
				return getParameter();
			case FunctionblocksPackage.DOCUMENT_ROOT__PLUGS:
				return getPlugs();
			case FunctionblocksPackage.DOCUMENT_ROOT__RESOURCE:
				return getResource();
			case FunctionblocksPackage.DOCUMENT_ROOT__RESOURCE_TYPE:
				return getResourceType();
			case FunctionblocksPackage.DOCUMENT_ROOT__RESOURCE_TYPE_NAME:
				return getResourceTypeName();
			case FunctionblocksPackage.DOCUMENT_ROOT__RUNG:
				return getRung();
			case FunctionblocksPackage.DOCUMENT_ROOT__SEGMENT:
				return getSegment();
			case FunctionblocksPackage.DOCUMENT_ROOT__SERVICE:
				return getService();
			case FunctionblocksPackage.DOCUMENT_ROOT__SERVICE_SEQUENCE:
				return getServiceSequence();
			case FunctionblocksPackage.DOCUMENT_ROOT__SERVICE_TRANSACTION:
				return getServiceTransaction();
			case FunctionblocksPackage.DOCUMENT_ROOT__SOCKETS:
				return getSockets();
			case FunctionblocksPackage.DOCUMENT_ROOT__ST:
				return getST();
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP:
				return getSubApp();
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_EVENT:
				return getSubAppEvent();
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_EVENT_INPUTS:
				return getSubAppEventInputs();
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_EVENT_OUTPUTS:
				return getSubAppEventOutputs();
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_INTERFACE_LIST:
				return getSubAppInterfaceList();
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_NETWORK:
				return getSubAppNetwork();
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_TYPE:
				return getSubAppType();
			case FunctionblocksPackage.DOCUMENT_ROOT__SYSTEM:
				return getSystem();
			case FunctionblocksPackage.DOCUMENT_ROOT__VAR_DECLARATION:
				return getVarDeclaration();
			case FunctionblocksPackage.DOCUMENT_ROOT__VERSION_INFO:
				return getVersionInfo();
			case FunctionblocksPackage.DOCUMENT_ROOT__WITH:
				return getWith();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FunctionblocksPackage.DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__ADAPTER_CONNECTIONS:
				setAdapterConnections((AdapterConnections)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__ADAPTER_DECLARATION:
				setAdapterDeclaration((AdapterDeclaration)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__ADAPTER_TYPE:
				setAdapterType((AdapterType)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__ALGORITHM:
				setAlgorithm((Algorithm)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__APPLICATION:
				setApplication((Application)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__BASIC_FB:
				setBasicFB((BasicFB)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__COMPILER:
				setCompiler((de.cau.cs.kieler.functionblocks.Compiler)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__COMPILER_INFO:
				setCompilerInfo((CompilerInfo)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__CONNECTION:
				setConnection((Connection)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__DATA_CONNECTIONS:
				setDataConnections((DataConnections)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__DEVICE:
				setDevice((Device)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__DEVICE_TYPE:
				setDeviceType((DeviceType)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__EC_ACTION:
				setECAction((ECAction)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__ECC:
				setECC((ECC)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__EC_STATE:
				setECState((ECState)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__EC_TRANSITION:
				setECTransition((ECTransition)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT:
				setEvent((Event)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT_CONNECTIONS:
				setEventConnections((EventConnections)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT_INPUTS:
				setEventInputs((EventInputs)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT_OUTPUTS:
				setEventOutputs((EventOutputs)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__FB:
				setFB((FB)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__FBD:
				setFBD((FBD)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__FB_NETWORK:
				setFBNetwork((FBNetwork)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__FB_TYPE:
				setFBType((FBType)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__FB_TYPE_NAME:
				setFBTypeName((FBTypeName)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__HCECC:
				setHCECC((HCECC)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__HCECC_RELATION:
				setHCECCRelation((HCECCRelation)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__IDENTIFICATION:
				setIdentification((Identification)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__INPUT_PRIMITIVE:
				setInputPrimitive((InputPrimitive)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__INPUT_VARS:
				setInputVars((InputVars)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__INTERFACE_LIST:
				setInterfaceList((InterfaceList)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__INTERNAL_VARS:
				setInternalVars((InternalVars)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__LD:
				setLD((LD)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__LINK:
				setLink((Link)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__MAPPING:
				setMapping((Mapping)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__OTHER:
				setOther((Other)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__OUTPUT_PRIMITIVE:
				setOutputPrimitive((OutputPrimitive)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__OUTPUT_VARS:
				setOutputVars((OutputVars)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__PARAMETER:
				setParameter((Parameter)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__PLUGS:
				setPlugs((Plugs)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__RESOURCE:
				setResource((Resource)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__RESOURCE_TYPE_NAME:
				setResourceTypeName((ResourceTypeName)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__RUNG:
				setRung((Rung)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SEGMENT:
				setSegment((Segment)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SERVICE:
				setService((Service)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SERVICE_SEQUENCE:
				setServiceSequence((ServiceSequence)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SERVICE_TRANSACTION:
				setServiceTransaction((ServiceTransaction)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SOCKETS:
				setSockets((Sockets)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__ST:
				setST((ST)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP:
				setSubApp((SubApp)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_EVENT:
				setSubAppEvent((SubAppEvent)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_EVENT_INPUTS:
				setSubAppEventInputs((SubAppEventInputs)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_EVENT_OUTPUTS:
				setSubAppEventOutputs((SubAppEventOutputs)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_INTERFACE_LIST:
				setSubAppInterfaceList((SubAppInterfaceList)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_NETWORK:
				setSubAppNetwork((SubAppNetwork)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_TYPE:
				setSubAppType((SubAppType)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SYSTEM:
				setSystem((de.cau.cs.kieler.functionblocks.System)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__VAR_DECLARATION:
				setVarDeclaration((VarDeclaration)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__VERSION_INFO:
				setVersionInfo((VersionInfo)newValue);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__WITH:
				setWith((With)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FunctionblocksPackage.DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__ADAPTER_CONNECTIONS:
				setAdapterConnections((AdapterConnections)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__ADAPTER_DECLARATION:
				setAdapterDeclaration((AdapterDeclaration)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__ADAPTER_TYPE:
				setAdapterType((AdapterType)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__ALGORITHM:
				setAlgorithm((Algorithm)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__APPLICATION:
				setApplication((Application)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__BASIC_FB:
				setBasicFB((BasicFB)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__COMPILER:
				setCompiler((de.cau.cs.kieler.functionblocks.Compiler)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__COMPILER_INFO:
				setCompilerInfo((CompilerInfo)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__CONNECTION:
				setConnection((Connection)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__DATA_CONNECTIONS:
				setDataConnections((DataConnections)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__DEVICE:
				setDevice((Device)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__DEVICE_TYPE:
				setDeviceType((DeviceType)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__EC_ACTION:
				setECAction((ECAction)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__ECC:
				setECC((ECC)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__EC_STATE:
				setECState((ECState)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__EC_TRANSITION:
				setECTransition((ECTransition)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT:
				setEvent((Event)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT_CONNECTIONS:
				setEventConnections((EventConnections)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT_INPUTS:
				setEventInputs((EventInputs)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT_OUTPUTS:
				setEventOutputs((EventOutputs)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__FB:
				setFB((FB)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__FBD:
				setFBD((FBD)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__FB_NETWORK:
				setFBNetwork((FBNetwork)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__FB_TYPE:
				setFBType((FBType)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__FB_TYPE_NAME:
				setFBTypeName((FBTypeName)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__HCECC:
				setHCECC((HCECC)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__HCECC_RELATION:
				setHCECCRelation((HCECCRelation)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__IDENTIFICATION:
				setIdentification((Identification)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__INPUT_PRIMITIVE:
				setInputPrimitive((InputPrimitive)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__INPUT_VARS:
				setInputVars((InputVars)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__INTERFACE_LIST:
				setInterfaceList((InterfaceList)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__INTERNAL_VARS:
				setInternalVars((InternalVars)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__LD:
				setLD((LD)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__LINK:
				setLink((Link)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__MAPPING:
				setMapping((Mapping)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__OTHER:
				setOther((Other)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__OUTPUT_PRIMITIVE:
				setOutputPrimitive((OutputPrimitive)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__OUTPUT_VARS:
				setOutputVars((OutputVars)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__PARAMETER:
				setParameter((Parameter)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__PLUGS:
				setPlugs((Plugs)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__RESOURCE:
				setResource((Resource)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__RESOURCE_TYPE:
				setResourceType((ResourceType)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__RESOURCE_TYPE_NAME:
				setResourceTypeName((ResourceTypeName)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__RUNG:
				setRung((Rung)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SEGMENT:
				setSegment((Segment)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SERVICE:
				setService((Service)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SERVICE_SEQUENCE:
				setServiceSequence((ServiceSequence)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SERVICE_TRANSACTION:
				setServiceTransaction((ServiceTransaction)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SOCKETS:
				setSockets((Sockets)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__ST:
				setST((ST)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP:
				setSubApp((SubApp)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_EVENT:
				setSubAppEvent((SubAppEvent)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_EVENT_INPUTS:
				setSubAppEventInputs((SubAppEventInputs)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_EVENT_OUTPUTS:
				setSubAppEventOutputs((SubAppEventOutputs)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_INTERFACE_LIST:
				setSubAppInterfaceList((SubAppInterfaceList)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_NETWORK:
				setSubAppNetwork((SubAppNetwork)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_TYPE:
				setSubAppType((SubAppType)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__SYSTEM:
				setSystem((de.cau.cs.kieler.functionblocks.System)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__VAR_DECLARATION:
				setVarDeclaration((VarDeclaration)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__VERSION_INFO:
				setVersionInfo((VersionInfo)null);
				return;
			case FunctionblocksPackage.DOCUMENT_ROOT__WITH:
				setWith((With)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FunctionblocksPackage.DOCUMENT_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case FunctionblocksPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case FunctionblocksPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case FunctionblocksPackage.DOCUMENT_ROOT__ADAPTER_CONNECTIONS:
				return getAdapterConnections() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__ADAPTER_DECLARATION:
				return getAdapterDeclaration() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__ADAPTER_TYPE:
				return getAdapterType() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__ALGORITHM:
				return getAlgorithm() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__APPLICATION:
				return getApplication() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__BASIC_FB:
				return getBasicFB() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__COMPILER:
				return getCompiler() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__COMPILER_INFO:
				return getCompilerInfo() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__CONNECTION:
				return getConnection() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__DATA_CONNECTIONS:
				return getDataConnections() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__DEVICE:
				return getDevice() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__DEVICE_TYPE:
				return getDeviceType() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__EC_ACTION:
				return getECAction() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__ECC:
				return getECC() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__EC_STATE:
				return getECState() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__EC_TRANSITION:
				return getECTransition() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT:
				return getEvent() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT_CONNECTIONS:
				return getEventConnections() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT_INPUTS:
				return getEventInputs() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__EVENT_OUTPUTS:
				return getEventOutputs() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__FB:
				return getFB() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__FBD:
				return getFBD() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__FB_NETWORK:
				return getFBNetwork() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__FB_TYPE:
				return getFBType() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__FB_TYPE_NAME:
				return getFBTypeName() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__HCECC:
				return getHCECC() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__HCECC_RELATION:
				return getHCECCRelation() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__IDENTIFICATION:
				return getIdentification() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__INPUT_PRIMITIVE:
				return getInputPrimitive() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__INPUT_VARS:
				return getInputVars() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__INTERFACE_LIST:
				return getInterfaceList() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__INTERNAL_VARS:
				return getInternalVars() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__LD:
				return getLD() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__LINK:
				return getLink() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__MAPPING:
				return getMapping() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__OTHER:
				return getOther() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__OUTPUT_PRIMITIVE:
				return getOutputPrimitive() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__OUTPUT_VARS:
				return getOutputVars() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__PARAMETER:
				return getParameter() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__PLUGS:
				return getPlugs() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__RESOURCE:
				return getResource() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__RESOURCE_TYPE:
				return getResourceType() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__RESOURCE_TYPE_NAME:
				return getResourceTypeName() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__RUNG:
				return getRung() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__SEGMENT:
				return getSegment() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__SERVICE:
				return getService() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__SERVICE_SEQUENCE:
				return getServiceSequence() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__SERVICE_TRANSACTION:
				return getServiceTransaction() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__SOCKETS:
				return getSockets() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__ST:
				return getST() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP:
				return getSubApp() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_EVENT:
				return getSubAppEvent() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_EVENT_INPUTS:
				return getSubAppEventInputs() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_EVENT_OUTPUTS:
				return getSubAppEventOutputs() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_INTERFACE_LIST:
				return getSubAppInterfaceList() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_NETWORK:
				return getSubAppNetwork() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__SUB_APP_TYPE:
				return getSubAppType() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__SYSTEM:
				return getSystem() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__VAR_DECLARATION:
				return getVarDeclaration() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__VERSION_INFO:
				return getVersionInfo() != null;
			case FunctionblocksPackage.DOCUMENT_ROOT__WITH:
				return getWith() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
