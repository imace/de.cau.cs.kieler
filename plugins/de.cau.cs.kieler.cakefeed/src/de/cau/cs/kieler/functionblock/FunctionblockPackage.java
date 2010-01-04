/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblock;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.functionblock.FunctionblockFactory
 * @model kind="package"
 *        extendedMetaData="qualified='false'"
 * @generated
 */
public interface FunctionblockPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "functionblock";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://kieler.cs.cau.de/functionblock/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "functionblock";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FunctionblockPackage eINSTANCE = de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.AdapterConnectionsImpl <em>Adapter Connections</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.AdapterConnectionsImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getAdapterConnections()
	 * @generated
	 */
	int ADAPTER_CONNECTIONS = 0;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_CONNECTIONS__CONNECTION = 0;

	/**
	 * The number of structural features of the '<em>Adapter Connections</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_CONNECTIONS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.AdapterDeclarationImpl <em>Adapter Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.AdapterDeclarationImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getAdapterDeclaration()
	 * @generated
	 */
	int ADAPTER_DECLARATION = 1;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_DECLARATION__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_DECLARATION__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_DECLARATION__NAME = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_DECLARATION__TYPE = 3;

	/**
	 * The number of structural features of the '<em>Adapter Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_DECLARATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.AdapterTypeImpl <em>Adapter Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.AdapterTypeImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getAdapterType()
	 * @generated
	 */
	int ADAPTER_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__IDENTIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Version Info</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__VERSION_INFO = 1;

	/**
	 * The feature id for the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__COMPILER_INFO = 2;

	/**
	 * The feature id for the '<em><b>Interface List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__INTERFACE_LIST = 3;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__SERVICE = 4;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__COMMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__NAME = 6;

	/**
	 * The number of structural features of the '<em>Adapter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.AlgorithmImpl <em>Algorithm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.AlgorithmImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getAlgorithm()
	 * @generated
	 */
	int ALGORITHM = 3;

	/**
	 * The feature id for the '<em><b>FBD</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__FBD = 0;

	/**
	 * The feature id for the '<em><b>ST</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__ST = 1;

	/**
	 * The feature id for the '<em><b>LD</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__LD = 2;

	/**
	 * The feature id for the '<em><b>Other</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__OTHER = 3;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__COMMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__NAME = 5;

	/**
	 * The number of structural features of the '<em>Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.ApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.ApplicationImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getApplication()
	 * @generated
	 */
	int APPLICATION = 4;

	/**
	 * The feature id for the '<em><b>FB Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__FB_NETWORK = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__NAME = 2;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.BasicFBImpl <em>Basic FB</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.BasicFBImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getBasicFB()
	 * @generated
	 */
	int BASIC_FB = 5;

	/**
	 * The feature id for the '<em><b>Internal Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FB__INTERNAL_VARS = 0;

	/**
	 * The feature id for the '<em><b>ECC</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FB__ECC = 1;

	/**
	 * The feature id for the '<em><b>HCECC</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FB__HCECC = 2;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FB__ALGORITHM = 3;

	/**
	 * The number of structural features of the '<em>Basic FB</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FB_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.CompilerInfoImpl <em>Compiler Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.CompilerInfoImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getCompilerInfo()
	 * @generated
	 */
	int COMPILER_INFO = 6;

	/**
	 * The feature id for the '<em><b>Compiler</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILER_INFO__COMPILER = 0;

	/**
	 * The feature id for the '<em><b>Classdef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILER_INFO__CLASSDEF = 1;

	/**
	 * The feature id for the '<em><b>Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILER_INFO__HEADER = 2;

	/**
	 * The number of structural features of the '<em>Compiler Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILER_INFO_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.CompilerImpl <em>Compiler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.CompilerImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getCompiler()
	 * @generated
	 */
	int COMPILER = 7;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILER__LANGUAGE = 0;

	/**
	 * The feature id for the '<em><b>Product</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILER__PRODUCT = 1;

	/**
	 * The feature id for the '<em><b>Vendor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILER__VENDOR = 2;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILER__VERSION = 3;

	/**
	 * The number of structural features of the '<em>Compiler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.ConnectionImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 8;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__DESTINATION = 1;

	/**
	 * The feature id for the '<em><b>Dx1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__DX1 = 2;

	/**
	 * The feature id for the '<em><b>Dx2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__DX2 = 3;

	/**
	 * The feature id for the '<em><b>Dy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__DY = 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SOURCE = 5;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.DataConnectionsImpl <em>Data Connections</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.DataConnectionsImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getDataConnections()
	 * @generated
	 */
	int DATA_CONNECTIONS = 9;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONNECTIONS__CONNECTION = 0;

	/**
	 * The number of structural features of the '<em>Data Connections</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONNECTIONS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.DeviceImpl <em>Device</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.DeviceImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getDevice()
	 * @generated
	 */
	int DEVICE = 10;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__RESOURCE = 1;

	/**
	 * The feature id for the '<em><b>FB Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__FB_NETWORK = 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__COMMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__NAME = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__TYPE = 5;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__X = 6;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__Y = 7;

	/**
	 * The number of structural features of the '<em>Device</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.DeviceTypeImpl <em>Device Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.DeviceTypeImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getDeviceType()
	 * @generated
	 */
	int DEVICE_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__IDENTIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Version Info</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__VERSION_INFO = 1;

	/**
	 * The feature id for the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__COMPILER_INFO = 2;

	/**
	 * The feature id for the '<em><b>Var Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__VAR_DECLARATION = 3;

	/**
	 * The feature id for the '<em><b>Resource Type Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__RESOURCE_TYPE_NAME = 4;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__RESOURCE = 5;

	/**
	 * The feature id for the '<em><b>FB Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__FB_NETWORK = 6;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__COMMENT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__NAME = 8;

	/**
	 * The number of structural features of the '<em>Device Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.DocumentRootImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 12;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Adapter Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ADAPTER_CONNECTIONS = 3;

	/**
	 * The feature id for the '<em><b>Adapter Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ADAPTER_DECLARATION = 4;

	/**
	 * The feature id for the '<em><b>Adapter Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ADAPTER_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ALGORITHM = 6;

	/**
	 * The feature id for the '<em><b>Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__APPLICATION = 7;

	/**
	 * The feature id for the '<em><b>Basic FB</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__BASIC_FB = 8;

	/**
	 * The feature id for the '<em><b>Compiler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__COMPILER = 9;

	/**
	 * The feature id for the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__COMPILER_INFO = 10;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CONNECTION = 11;

	/**
	 * The feature id for the '<em><b>Data Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DATA_CONNECTIONS = 12;

	/**
	 * The feature id for the '<em><b>Device</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DEVICE = 13;

	/**
	 * The feature id for the '<em><b>Device Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DEVICE_TYPE = 14;

	/**
	 * The feature id for the '<em><b>EC Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EC_ACTION = 15;

	/**
	 * The feature id for the '<em><b>ECC</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ECC = 16;

	/**
	 * The feature id for the '<em><b>EC State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EC_STATE = 17;

	/**
	 * The feature id for the '<em><b>EC Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EC_TRANSITION = 18;

	/**
	 * The feature id for the '<em><b>Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EVENT = 19;

	/**
	 * The feature id for the '<em><b>Event Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EVENT_CONNECTIONS = 20;

	/**
	 * The feature id for the '<em><b>Event Inputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EVENT_INPUTS = 21;

	/**
	 * The feature id for the '<em><b>Event Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EVENT_OUTPUTS = 22;

	/**
	 * The feature id for the '<em><b>FB</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FB = 23;

	/**
	 * The feature id for the '<em><b>FBD</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FBD = 24;

	/**
	 * The feature id for the '<em><b>FB Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FB_NETWORK = 25;

	/**
	 * The feature id for the '<em><b>FB Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FB_TYPE = 26;

	/**
	 * The feature id for the '<em><b>FB Type Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FB_TYPE_NAME = 27;

	/**
	 * The feature id for the '<em><b>HCECC</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__HCECC = 28;

	/**
	 * The feature id for the '<em><b>HCECC Relation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__HCECC_RELATION = 29;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__IDENTIFICATION = 30;

	/**
	 * The feature id for the '<em><b>Input Primitive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__INPUT_PRIMITIVE = 31;

	/**
	 * The feature id for the '<em><b>Input Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__INPUT_VARS = 32;

	/**
	 * The feature id for the '<em><b>Interface List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__INTERFACE_LIST = 33;

	/**
	 * The feature id for the '<em><b>Internal Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__INTERNAL_VARS = 34;

	/**
	 * The feature id for the '<em><b>LD</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__LD = 35;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__LINK = 36;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MAPPING = 37;

	/**
	 * The feature id for the '<em><b>Other</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__OTHER = 38;

	/**
	 * The feature id for the '<em><b>Output Primitive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__OUTPUT_PRIMITIVE = 39;

	/**
	 * The feature id for the '<em><b>Output Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__OUTPUT_VARS = 40;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PARAMETER = 41;

	/**
	 * The feature id for the '<em><b>Plugs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PLUGS = 42;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RESOURCE = 43;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RESOURCE_TYPE = 44;

	/**
	 * The feature id for the '<em><b>Resource Type Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RESOURCE_TYPE_NAME = 45;

	/**
	 * The feature id for the '<em><b>Rung</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RUNG = 46;

	/**
	 * The feature id for the '<em><b>Segment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SEGMENT = 47;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SERVICE = 48;

	/**
	 * The feature id for the '<em><b>Service Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SERVICE_SEQUENCE = 49;

	/**
	 * The feature id for the '<em><b>Service Transaction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SERVICE_TRANSACTION = 50;

	/**
	 * The feature id for the '<em><b>Sockets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SOCKETS = 51;

	/**
	 * The feature id for the '<em><b>ST</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ST = 52;

	/**
	 * The feature id for the '<em><b>Sub App</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SUB_APP = 53;

	/**
	 * The feature id for the '<em><b>Sub App Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SUB_APP_EVENT = 54;

	/**
	 * The feature id for the '<em><b>Sub App Event Inputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SUB_APP_EVENT_INPUTS = 55;

	/**
	 * The feature id for the '<em><b>Sub App Event Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SUB_APP_EVENT_OUTPUTS = 56;

	/**
	 * The feature id for the '<em><b>Sub App Interface List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SUB_APP_INTERFACE_LIST = 57;

	/**
	 * The feature id for the '<em><b>Sub App Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SUB_APP_NETWORK = 58;

	/**
	 * The feature id for the '<em><b>Sub App Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SUB_APP_TYPE = 59;

	/**
	 * The feature id for the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SYSTEM = 60;

	/**
	 * The feature id for the '<em><b>Var Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__VAR_DECLARATION = 61;

	/**
	 * The feature id for the '<em><b>Version Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__VERSION_INFO = 62;

	/**
	 * The feature id for the '<em><b>With</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__WITH = 63;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 64;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.ECActionImpl <em>EC Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.ECActionImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getECAction()
	 * @generated
	 */
	int EC_ACTION = 13;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_ACTION__ALGORITHM = 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_ACTION__OUTPUT = 1;

	/**
	 * The number of structural features of the '<em>EC Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_ACTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.ECCImpl <em>ECC</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.ECCImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getECC()
	 * @generated
	 */
	int ECC = 14;

	/**
	 * The feature id for the '<em><b>EC State</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECC__EC_STATE = 0;

	/**
	 * The feature id for the '<em><b>EC Transition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECC__EC_TRANSITION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECC__NAME = 2;

	/**
	 * The number of structural features of the '<em>ECC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECC_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.ECStateImpl <em>EC State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.ECStateImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getECState()
	 * @generated
	 */
	int EC_STATE = 15;

	/**
	 * The feature id for the '<em><b>EC Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_STATE__EC_ACTION = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_STATE__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_STATE__NAME = 2;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_STATE__X = 3;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_STATE__Y = 4;

	/**
	 * The number of structural features of the '<em>EC State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_STATE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.ECTransitionImpl <em>EC Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.ECTransitionImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getECTransition()
	 * @generated
	 */
	int EC_TRANSITION = 16;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_TRANSITION__COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_TRANSITION__CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_TRANSITION__DESTINATION = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_TRANSITION__SOURCE = 3;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_TRANSITION__X = 4;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_TRANSITION__Y = 5;

	/**
	 * The number of structural features of the '<em>EC Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EC_TRANSITION_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.EventConnectionsImpl <em>Event Connections</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.EventConnectionsImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getEventConnections()
	 * @generated
	 */
	int EVENT_CONNECTIONS = 17;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONNECTIONS__CONNECTION = 0;

	/**
	 * The number of structural features of the '<em>Event Connections</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONNECTIONS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.EventInputsImpl <em>Event Inputs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.EventInputsImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getEventInputs()
	 * @generated
	 */
	int EVENT_INPUTS = 18;

	/**
	 * The feature id for the '<em><b>Event</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INPUTS__EVENT = 0;

	/**
	 * The number of structural features of the '<em>Event Inputs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INPUTS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.EventOutputsImpl <em>Event Outputs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.EventOutputsImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getEventOutputs()
	 * @generated
	 */
	int EVENT_OUTPUTS = 19;

	/**
	 * The feature id for the '<em><b>Event</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_OUTPUTS__EVENT = 0;

	/**
	 * The number of structural features of the '<em>Event Outputs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_OUTPUTS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.EventImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 20;

	/**
	 * The feature id for the '<em><b>With</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__WITH = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NAME = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TYPE = 3;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.FBDImpl <em>FBD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.FBDImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getFBD()
	 * @generated
	 */
	int FBD = 21;

	/**
	 * The feature id for the '<em><b>FB</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBD__FB = 0;

	/**
	 * The feature id for the '<em><b>Data Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBD__DATA_CONNECTIONS = 1;

	/**
	 * The number of structural features of the '<em>FBD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBD_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.FBNetworkImpl <em>FB Network</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.FBNetworkImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getFBNetwork()
	 * @generated
	 */
	int FB_NETWORK = 22;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_NETWORK__MIXED = 0;

	/**
	 * The feature id for the '<em><b>FB</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_NETWORK__FB = 1;

	/**
	 * The feature id for the '<em><b>Event Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_NETWORK__EVENT_CONNECTIONS = 2;

	/**
	 * The feature id for the '<em><b>Data Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_NETWORK__DATA_CONNECTIONS = 3;

	/**
	 * The feature id for the '<em><b>Adapter Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_NETWORK__ADAPTER_CONNECTIONS = 4;

	/**
	 * The number of structural features of the '<em>FB Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_NETWORK_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.FBImpl <em>FB</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.FBImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getFB()
	 * @generated
	 */
	int FB = 23;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__NAME = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__TYPE = 3;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__X = 4;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__Y = 5;

	/**
	 * The number of structural features of the '<em>FB</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.FBTypeNameImpl <em>FB Type Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.FBTypeNameImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getFBTypeName()
	 * @generated
	 */
	int FB_TYPE_NAME = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE_NAME__NAME = 0;

	/**
	 * The number of structural features of the '<em>FB Type Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE_NAME_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.FBTypeImpl <em>FB Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.FBTypeImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getFBType()
	 * @generated
	 */
	int FB_TYPE = 25;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__IDENTIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Version Info</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__VERSION_INFO = 1;

	/**
	 * The feature id for the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__COMPILER_INFO = 2;

	/**
	 * The feature id for the '<em><b>Interface List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__INTERFACE_LIST = 3;

	/**
	 * The feature id for the '<em><b>Basic FB</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__BASIC_FB = 4;

	/**
	 * The feature id for the '<em><b>FB Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__FB_NETWORK = 5;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__SERVICE = 6;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__COMMENT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__NAME = 8;

	/**
	 * The number of structural features of the '<em>FB Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.HCECCRelationImpl <em>HCECC Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.HCECCRelationImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getHCECCRelation()
	 * @generated
	 */
	int HCECC_RELATION = 26;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HCECC_RELATION__COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HCECC_RELATION__DESTINATION = 1;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HCECC_RELATION__RELATION = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HCECC_RELATION__SOURCE = 3;

	/**
	 * The number of structural features of the '<em>HCECC Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HCECC_RELATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.HCECCImpl <em>HCECC</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.HCECCImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getHCECC()
	 * @generated
	 */
	int HCECC = 27;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HCECC__GROUP = 0;

	/**
	 * The feature id for the '<em><b>ECC</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HCECC__ECC = 1;

	/**
	 * The feature id for the '<em><b>HCECC Relation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HCECC__HCECC_RELATION = 2;

	/**
	 * The number of structural features of the '<em>HCECC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HCECC_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.IdentificationImpl <em>Identification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.IdentificationImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getIdentification()
	 * @generated
	 */
	int IDENTIFICATION = 28;

	/**
	 * The feature id for the '<em><b>Application Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFICATION__APPLICATION_DOMAIN = 0;

	/**
	 * The feature id for the '<em><b>Classification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFICATION__CLASSIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFICATION__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFICATION__FUNCTION = 3;

	/**
	 * The feature id for the '<em><b>Standard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFICATION__STANDARD = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFICATION__TYPE = 5;

	/**
	 * The number of structural features of the '<em>Identification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFICATION_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.InputPrimitiveImpl <em>Input Primitive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.InputPrimitiveImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getInputPrimitive()
	 * @generated
	 */
	int INPUT_PRIMITIVE = 29;

	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PRIMITIVE__EVENT = 0;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PRIMITIVE__INTERFACE = 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PRIMITIVE__PARAMETERS = 2;

	/**
	 * The number of structural features of the '<em>Input Primitive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PRIMITIVE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.InputVarsImpl <em>Input Vars</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.InputVarsImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getInputVars()
	 * @generated
	 */
	int INPUT_VARS = 30;

	/**
	 * The feature id for the '<em><b>Var Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARS__VAR_DECLARATION = 0;

	/**
	 * The number of structural features of the '<em>Input Vars</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.InterfaceListImpl <em>Interface List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.InterfaceListImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getInterfaceList()
	 * @generated
	 */
	int INTERFACE_LIST = 31;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_LIST__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Event Inputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_LIST__EVENT_INPUTS = 1;

	/**
	 * The feature id for the '<em><b>Event Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_LIST__EVENT_OUTPUTS = 2;

	/**
	 * The feature id for the '<em><b>Input Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_LIST__INPUT_VARS = 3;

	/**
	 * The feature id for the '<em><b>Output Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_LIST__OUTPUT_VARS = 4;

	/**
	 * The feature id for the '<em><b>Sockets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_LIST__SOCKETS = 5;

	/**
	 * The feature id for the '<em><b>Plugs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_LIST__PLUGS = 6;

	/**
	 * The number of structural features of the '<em>Interface List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_LIST_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.InternalVarsImpl <em>Internal Vars</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.InternalVarsImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getInternalVars()
	 * @generated
	 */
	int INTERNAL_VARS = 32;

	/**
	 * The feature id for the '<em><b>Var Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_VARS__VAR_DECLARATION = 0;

	/**
	 * The number of structural features of the '<em>Internal Vars</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_VARS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.LDImpl <em>LD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.LDImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getLD()
	 * @generated
	 */
	int LD = 33;

	/**
	 * The feature id for the '<em><b>Rung</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LD__RUNG = 0;

	/**
	 * The number of structural features of the '<em>LD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LD_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.LinkImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 34;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Comm Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__COMM_RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Segment Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__SEGMENT_NAME = 3;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.MappingImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 35;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__FROM = 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__TO = 1;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.OtherImpl <em>Other</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.OtherImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getOther()
	 * @generated
	 */
	int OTHER = 36;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER__LANGUAGE = 0;

	/**
	 * The feature id for the '<em><b>Prototype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER__PROTOTYPE = 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER__TEXT = 2;

	/**
	 * The number of structural features of the '<em>Other</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.OutputPrimitiveImpl <em>Output Primitive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.OutputPrimitiveImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getOutputPrimitive()
	 * @generated
	 */
	int OUTPUT_PRIMITIVE = 37;

	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRIMITIVE__EVENT = 0;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRIMITIVE__INTERFACE = 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRIMITIVE__PARAMETERS = 2;

	/**
	 * The number of structural features of the '<em>Output Primitive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRIMITIVE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.OutputVarsImpl <em>Output Vars</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.OutputVarsImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getOutputVars()
	 * @generated
	 */
	int OUTPUT_VARS = 38;

	/**
	 * The feature id for the '<em><b>Var Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARS__VAR_DECLARATION = 0;

	/**
	 * The number of structural features of the '<em>Output Vars</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.ParameterImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 39;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.PlugsImpl <em>Plugs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.PlugsImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getPlugs()
	 * @generated
	 */
	int PLUGS = 40;

	/**
	 * The feature id for the '<em><b>Adapter Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGS__ADAPTER_DECLARATION = 0;

	/**
	 * The number of structural features of the '<em>Plugs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.ResourceImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 41;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>FB Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__FB_NETWORK = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__COMMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__TYPE = 4;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__X = 5;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__Y = 6;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.ResourceTypeNameImpl <em>Resource Type Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.ResourceTypeNameImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getResourceTypeName()
	 * @generated
	 */
	int RESOURCE_TYPE_NAME = 42;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_NAME__NAME = 0;

	/**
	 * The number of structural features of the '<em>Resource Type Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_NAME_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.ResourceTypeImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getResourceType()
	 * @generated
	 */
	int RESOURCE_TYPE = 43;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__IDENTIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Version Info</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__VERSION_INFO = 1;

	/**
	 * The feature id for the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__COMPILER_INFO = 2;

	/**
	 * The feature id for the '<em><b>FB Type Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__FB_TYPE_NAME = 3;

	/**
	 * The feature id for the '<em><b>Var Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__VAR_DECLARATION = 4;

	/**
	 * The feature id for the '<em><b>FB Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__FB_NETWORK = 5;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__COMMENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__NAME = 7;

	/**
	 * The number of structural features of the '<em>Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.RungImpl <em>Rung</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.RungImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getRung()
	 * @generated
	 */
	int RUNG = 44;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNG__COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNG__EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNG__OUTPUT = 2;

	/**
	 * The number of structural features of the '<em>Rung</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNG_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.SegmentImpl <em>Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.SegmentImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSegment()
	 * @generated
	 */
	int SEGMENT = 45;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Dx1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__DX1 = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__NAME = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__TYPE = 4;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__X = 5;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__Y = 6;

	/**
	 * The number of structural features of the '<em>Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.ServiceSequenceImpl <em>Service Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.ServiceSequenceImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getServiceSequence()
	 * @generated
	 */
	int SERVICE_SEQUENCE = 46;

	/**
	 * The feature id for the '<em><b>Service Transaction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SEQUENCE__SERVICE_TRANSACTION = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SEQUENCE__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SEQUENCE__NAME = 2;

	/**
	 * The number of structural features of the '<em>Service Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SEQUENCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.ServiceTransactionImpl <em>Service Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.ServiceTransactionImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getServiceTransaction()
	 * @generated
	 */
	int SERVICE_TRANSACTION = 47;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TRANSACTION__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Input Primitive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TRANSACTION__INPUT_PRIMITIVE = 1;

	/**
	 * The feature id for the '<em><b>Output Primitive</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TRANSACTION__OUTPUT_PRIMITIVE = 2;

	/**
	 * The number of structural features of the '<em>Service Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TRANSACTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.ServiceImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 48;

	/**
	 * The feature id for the '<em><b>Service Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_SEQUENCE = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Left Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__LEFT_INTERFACE = 2;

	/**
	 * The feature id for the '<em><b>Right Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__RIGHT_INTERFACE = 3;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.SocketsImpl <em>Sockets</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.SocketsImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSockets()
	 * @generated
	 */
	int SOCKETS = 49;

	/**
	 * The feature id for the '<em><b>Adapter Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKETS__ADAPTER_DECLARATION = 0;

	/**
	 * The number of structural features of the '<em>Sockets</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKETS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.STImpl <em>ST</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.STImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getST()
	 * @generated
	 */
	int ST = 50;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ST__TEXT = 0;

	/**
	 * The number of structural features of the '<em>ST</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ST_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.SubAppEventInputsImpl <em>Sub App Event Inputs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.SubAppEventInputsImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSubAppEventInputs()
	 * @generated
	 */
	int SUB_APP_EVENT_INPUTS = 51;

	/**
	 * The feature id for the '<em><b>Sub App Event</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_EVENT_INPUTS__SUB_APP_EVENT = 0;

	/**
	 * The number of structural features of the '<em>Sub App Event Inputs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_EVENT_INPUTS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.SubAppEventOutputsImpl <em>Sub App Event Outputs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.SubAppEventOutputsImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSubAppEventOutputs()
	 * @generated
	 */
	int SUB_APP_EVENT_OUTPUTS = 52;

	/**
	 * The feature id for the '<em><b>Sub App Event</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_EVENT_OUTPUTS__SUB_APP_EVENT = 0;

	/**
	 * The number of structural features of the '<em>Sub App Event Outputs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_EVENT_OUTPUTS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.SubAppEventImpl <em>Sub App Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.SubAppEventImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSubAppEvent()
	 * @generated
	 */
	int SUB_APP_EVENT = 53;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_EVENT__COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_EVENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_EVENT__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Sub App Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_EVENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.SubAppInterfaceListImpl <em>Sub App Interface List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.SubAppInterfaceListImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSubAppInterfaceList()
	 * @generated
	 */
	int SUB_APP_INTERFACE_LIST = 54;

	/**
	 * The feature id for the '<em><b>Sub App Event Inputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_INPUTS = 0;

	/**
	 * The feature id for the '<em><b>Sub App Event Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_OUTPUTS = 1;

	/**
	 * The feature id for the '<em><b>Input Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_INTERFACE_LIST__INPUT_VARS = 2;

	/**
	 * The feature id for the '<em><b>Output Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_INTERFACE_LIST__OUTPUT_VARS = 3;

	/**
	 * The number of structural features of the '<em>Sub App Interface List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_INTERFACE_LIST_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.SubAppNetworkImpl <em>Sub App Network</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.SubAppNetworkImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSubAppNetwork()
	 * @generated
	 */
	int SUB_APP_NETWORK = 55;

	/**
	 * The feature id for the '<em><b>Sub App</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_NETWORK__SUB_APP = 0;

	/**
	 * The feature id for the '<em><b>FB</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_NETWORK__FB = 1;

	/**
	 * The feature id for the '<em><b>Event Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_NETWORK__EVENT_CONNECTIONS = 2;

	/**
	 * The feature id for the '<em><b>Data Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_NETWORK__DATA_CONNECTIONS = 3;

	/**
	 * The number of structural features of the '<em>Sub App Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_NETWORK_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.SubAppImpl <em>Sub App</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.SubAppImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSubApp()
	 * @generated
	 */
	int SUB_APP = 56;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP__COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP__NAME = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP__TYPE = 2;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP__X = 3;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP__Y = 4;

	/**
	 * The number of structural features of the '<em>Sub App</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.SubAppTypeImpl <em>Sub App Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.SubAppTypeImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSubAppType()
	 * @generated
	 */
	int SUB_APP_TYPE = 57;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_TYPE__IDENTIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Version Info</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_TYPE__VERSION_INFO = 1;

	/**
	 * The feature id for the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_TYPE__COMPILER_INFO = 2;

	/**
	 * The feature id for the '<em><b>Sub App Interface List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_TYPE__SUB_APP_INTERFACE_LIST = 3;

	/**
	 * The feature id for the '<em><b>Sub App Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_TYPE__SUB_APP_NETWORK = 4;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_TYPE__COMMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_TYPE__NAME = 6;

	/**
	 * The number of structural features of the '<em>Sub App Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_APP_TYPE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.SystemImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 58;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__IDENTIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Version Info</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__VERSION_INFO = 1;

	/**
	 * The feature id for the '<em><b>Application</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__APPLICATION = 2;

	/**
	 * The feature id for the '<em><b>Device</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__DEVICE = 3;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__MAPPING = 4;

	/**
	 * The feature id for the '<em><b>Segment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__SEGMENT = 5;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__LINK = 6;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__COMMENT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = 8;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.VarDeclarationImpl <em>Var Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.VarDeclarationImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getVarDeclaration()
	 * @generated
	 */
	int VAR_DECLARATION = 59;

	/**
	 * The feature id for the '<em><b>Array Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION__ARRAY_SIZE = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION__INITIAL_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION__NAME = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION__TYPE = 4;

	/**
	 * The number of structural features of the '<em>Var Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.VersionInfoImpl <em>Version Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.VersionInfoImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getVersionInfo()
	 * @generated
	 */
	int VERSION_INFO = 60;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_INFO__AUTHOR = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_INFO__DATE = 1;

	/**
	 * The feature id for the '<em><b>Organization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_INFO__ORGANIZATION = 2;

	/**
	 * The feature id for the '<em><b>Remarks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_INFO__REMARKS = 3;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_INFO__VERSION = 4;

	/**
	 * The number of structural features of the '<em>Version Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_INFO_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.impl.WithImpl <em>With</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.impl.WithImpl
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getWith()
	 * @generated
	 */
	int WITH = 61;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH__VAR = 0;

	/**
	 * The number of structural features of the '<em>With</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.functionblock.Language <em>Language</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.Language
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getLanguage()
	 * @generated
	 */
	int LANGUAGE = 62;

	/**
	 * The meta object id for the '<em>Language Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.functionblock.Language
	 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getLanguageObject()
	 * @generated
	 */
	int LANGUAGE_OBJECT = 63;


	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.AdapterConnections <em>Adapter Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter Connections</em>'.
	 * @see de.cau.cs.kieler.functionblock.AdapterConnections
	 * @generated
	 */
	EClass getAdapterConnections();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.AdapterConnections#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connection</em>'.
	 * @see de.cau.cs.kieler.functionblock.AdapterConnections#getConnection()
	 * @see #getAdapterConnections()
	 * @generated
	 */
	EReference getAdapterConnections_Connection();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.AdapterDeclaration <em>Adapter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter Declaration</em>'.
	 * @see de.cau.cs.kieler.functionblock.AdapterDeclaration
	 * @generated
	 */
	EClass getAdapterDeclaration();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.AdapterDeclaration#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see de.cau.cs.kieler.functionblock.AdapterDeclaration#getParameter()
	 * @see #getAdapterDeclaration()
	 * @generated
	 */
	EReference getAdapterDeclaration_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.AdapterDeclaration#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.AdapterDeclaration#getComment()
	 * @see #getAdapterDeclaration()
	 * @generated
	 */
	EAttribute getAdapterDeclaration_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.AdapterDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.AdapterDeclaration#getName()
	 * @see #getAdapterDeclaration()
	 * @generated
	 */
	EAttribute getAdapterDeclaration_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.AdapterDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.AdapterDeclaration#getType()
	 * @see #getAdapterDeclaration()
	 * @generated
	 */
	EAttribute getAdapterDeclaration_Type();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.AdapterType <em>Adapter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.AdapterType
	 * @generated
	 */
	EClass getAdapterType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.AdapterType#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identification</em>'.
	 * @see de.cau.cs.kieler.functionblock.AdapterType#getIdentification()
	 * @see #getAdapterType()
	 * @generated
	 */
	EReference getAdapterType_Identification();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.AdapterType#getVersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version Info</em>'.
	 * @see de.cau.cs.kieler.functionblock.AdapterType#getVersionInfo()
	 * @see #getAdapterType()
	 * @generated
	 */
	EReference getAdapterType_VersionInfo();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.AdapterType#getCompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compiler Info</em>'.
	 * @see de.cau.cs.kieler.functionblock.AdapterType#getCompilerInfo()
	 * @see #getAdapterType()
	 * @generated
	 */
	EReference getAdapterType_CompilerInfo();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.AdapterType#getInterfaceList <em>Interface List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interface List</em>'.
	 * @see de.cau.cs.kieler.functionblock.AdapterType#getInterfaceList()
	 * @see #getAdapterType()
	 * @generated
	 */
	EReference getAdapterType_InterfaceList();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.AdapterType#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service</em>'.
	 * @see de.cau.cs.kieler.functionblock.AdapterType#getService()
	 * @see #getAdapterType()
	 * @generated
	 */
	EReference getAdapterType_Service();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.AdapterType#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.AdapterType#getComment()
	 * @see #getAdapterType()
	 * @generated
	 */
	EAttribute getAdapterType_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.AdapterType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.AdapterType#getName()
	 * @see #getAdapterType()
	 * @generated
	 */
	EAttribute getAdapterType_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Algorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Algorithm</em>'.
	 * @see de.cau.cs.kieler.functionblock.Algorithm
	 * @generated
	 */
	EClass getAlgorithm();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.Algorithm#getFBD <em>FBD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FBD</em>'.
	 * @see de.cau.cs.kieler.functionblock.Algorithm#getFBD()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EReference getAlgorithm_FBD();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.Algorithm#getST <em>ST</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>ST</em>'.
	 * @see de.cau.cs.kieler.functionblock.Algorithm#getST()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EReference getAlgorithm_ST();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.Algorithm#getLD <em>LD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>LD</em>'.
	 * @see de.cau.cs.kieler.functionblock.Algorithm#getLD()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EReference getAlgorithm_LD();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.Algorithm#getOther <em>Other</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Other</em>'.
	 * @see de.cau.cs.kieler.functionblock.Algorithm#getOther()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EReference getAlgorithm_Other();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Algorithm#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.Algorithm#getComment()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EAttribute getAlgorithm_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Algorithm#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.Algorithm#getName()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EAttribute getAlgorithm_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see de.cau.cs.kieler.functionblock.Application
	 * @generated
	 */
	EClass getApplication();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.Application#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.functionblock.Application#getFBNetwork()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_FBNetwork();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Application#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.Application#getComment()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Application#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.Application#getName()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.BasicFB <em>Basic FB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic FB</em>'.
	 * @see de.cau.cs.kieler.functionblock.BasicFB
	 * @generated
	 */
	EClass getBasicFB();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.BasicFB#getInternalVars <em>Internal Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Internal Vars</em>'.
	 * @see de.cau.cs.kieler.functionblock.BasicFB#getInternalVars()
	 * @see #getBasicFB()
	 * @generated
	 */
	EReference getBasicFB_InternalVars();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.BasicFB#getECC <em>ECC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>ECC</em>'.
	 * @see de.cau.cs.kieler.functionblock.BasicFB#getECC()
	 * @see #getBasicFB()
	 * @generated
	 */
	EReference getBasicFB_ECC();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.BasicFB#getHCECC <em>HCECC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>HCECC</em>'.
	 * @see de.cau.cs.kieler.functionblock.BasicFB#getHCECC()
	 * @see #getBasicFB()
	 * @generated
	 */
	EReference getBasicFB_HCECC();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.BasicFB#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Algorithm</em>'.
	 * @see de.cau.cs.kieler.functionblock.BasicFB#getAlgorithm()
	 * @see #getBasicFB()
	 * @generated
	 */
	EReference getBasicFB_Algorithm();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.CompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compiler Info</em>'.
	 * @see de.cau.cs.kieler.functionblock.CompilerInfo
	 * @generated
	 */
	EClass getCompilerInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.CompilerInfo#getCompiler <em>Compiler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Compiler</em>'.
	 * @see de.cau.cs.kieler.functionblock.CompilerInfo#getCompiler()
	 * @see #getCompilerInfo()
	 * @generated
	 */
	EReference getCompilerInfo_Compiler();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.CompilerInfo#getClassdef <em>Classdef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classdef</em>'.
	 * @see de.cau.cs.kieler.functionblock.CompilerInfo#getClassdef()
	 * @see #getCompilerInfo()
	 * @generated
	 */
	EAttribute getCompilerInfo_Classdef();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.CompilerInfo#getHeader <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Header</em>'.
	 * @see de.cau.cs.kieler.functionblock.CompilerInfo#getHeader()
	 * @see #getCompilerInfo()
	 * @generated
	 */
	EAttribute getCompilerInfo_Header();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Compiler <em>Compiler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compiler</em>'.
	 * @see de.cau.cs.kieler.functionblock.Compiler
	 * @generated
	 */
	EClass getCompiler();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Compiler#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see de.cau.cs.kieler.functionblock.Compiler#getLanguage()
	 * @see #getCompiler()
	 * @generated
	 */
	EAttribute getCompiler_Language();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Compiler#getProduct <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product</em>'.
	 * @see de.cau.cs.kieler.functionblock.Compiler#getProduct()
	 * @see #getCompiler()
	 * @generated
	 */
	EAttribute getCompiler_Product();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Compiler#getVendor <em>Vendor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vendor</em>'.
	 * @see de.cau.cs.kieler.functionblock.Compiler#getVendor()
	 * @see #getCompiler()
	 * @generated
	 */
	EAttribute getCompiler_Vendor();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Compiler#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.cau.cs.kieler.functionblock.Compiler#getVersion()
	 * @see #getCompiler()
	 * @generated
	 */
	EAttribute getCompiler_Version();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see de.cau.cs.kieler.functionblock.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Connection#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.Connection#getComment()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Connection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.functionblock.Connection#getDestination()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Destination();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Connection#getDx1 <em>Dx1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dx1</em>'.
	 * @see de.cau.cs.kieler.functionblock.Connection#getDx1()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Dx1();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Connection#getDx2 <em>Dx2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dx2</em>'.
	 * @see de.cau.cs.kieler.functionblock.Connection#getDx2()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Dx2();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Connection#getDy <em>Dy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dy</em>'.
	 * @see de.cau.cs.kieler.functionblock.Connection#getDy()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Dy();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Connection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see de.cau.cs.kieler.functionblock.Connection#getSource()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.DataConnections <em>Data Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Connections</em>'.
	 * @see de.cau.cs.kieler.functionblock.DataConnections
	 * @generated
	 */
	EClass getDataConnections();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.DataConnections#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connection</em>'.
	 * @see de.cau.cs.kieler.functionblock.DataConnections#getConnection()
	 * @see #getDataConnections()
	 * @generated
	 */
	EReference getDataConnections_Connection();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Device <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device</em>'.
	 * @see de.cau.cs.kieler.functionblock.Device
	 * @generated
	 */
	EClass getDevice();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.Device#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see de.cau.cs.kieler.functionblock.Device#getParameter()
	 * @see #getDevice()
	 * @generated
	 */
	EReference getDevice_Parameter();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.Device#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource</em>'.
	 * @see de.cau.cs.kieler.functionblock.Device#getResource()
	 * @see #getDevice()
	 * @generated
	 */
	EReference getDevice_Resource();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.Device#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.functionblock.Device#getFBNetwork()
	 * @see #getDevice()
	 * @generated
	 */
	EReference getDevice_FBNetwork();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Device#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.Device#getComment()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Device#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.Device#getName()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Device#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.Device#getType()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Device#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see de.cau.cs.kieler.functionblock.Device#getX()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_X();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Device#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see de.cau.cs.kieler.functionblock.Device#getY()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Y();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.DeviceType <em>Device Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.DeviceType
	 * @generated
	 */
	EClass getDeviceType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DeviceType#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identification</em>'.
	 * @see de.cau.cs.kieler.functionblock.DeviceType#getIdentification()
	 * @see #getDeviceType()
	 * @generated
	 */
	EReference getDeviceType_Identification();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.DeviceType#getVersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version Info</em>'.
	 * @see de.cau.cs.kieler.functionblock.DeviceType#getVersionInfo()
	 * @see #getDeviceType()
	 * @generated
	 */
	EReference getDeviceType_VersionInfo();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DeviceType#getCompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compiler Info</em>'.
	 * @see de.cau.cs.kieler.functionblock.DeviceType#getCompilerInfo()
	 * @see #getDeviceType()
	 * @generated
	 */
	EReference getDeviceType_CompilerInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.DeviceType#getVarDeclaration <em>Var Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Var Declaration</em>'.
	 * @see de.cau.cs.kieler.functionblock.DeviceType#getVarDeclaration()
	 * @see #getDeviceType()
	 * @generated
	 */
	EReference getDeviceType_VarDeclaration();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.DeviceType#getResourceTypeName <em>Resource Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Type Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.DeviceType#getResourceTypeName()
	 * @see #getDeviceType()
	 * @generated
	 */
	EReference getDeviceType_ResourceTypeName();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.DeviceType#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource</em>'.
	 * @see de.cau.cs.kieler.functionblock.DeviceType#getResource()
	 * @see #getDeviceType()
	 * @generated
	 */
	EReference getDeviceType_Resource();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DeviceType#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.functionblock.DeviceType#getFBNetwork()
	 * @see #getDeviceType()
	 * @generated
	 */
	EReference getDeviceType_FBNetwork();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.DeviceType#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.DeviceType#getComment()
	 * @see #getDeviceType()
	 * @generated
	 */
	EAttribute getDeviceType_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.DeviceType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.DeviceType#getName()
	 * @see #getDeviceType()
	 * @generated
	 */
	EAttribute getDeviceType_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getAdapterConnections <em>Adapter Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Adapter Connections</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getAdapterConnections()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_AdapterConnections();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getAdapterDeclaration <em>Adapter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Adapter Declaration</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getAdapterDeclaration()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_AdapterDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getAdapterType <em>Adapter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Adapter Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getAdapterType()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_AdapterType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Algorithm</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getAlgorithm()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Algorithm();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Application</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getApplication()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Application();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getBasicFB <em>Basic FB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Basic FB</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getBasicFB()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_BasicFB();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getCompiler <em>Compiler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compiler</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getCompiler()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Compiler();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getCompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compiler Info</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getCompilerInfo()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_CompilerInfo();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Connection</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getConnection()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Connection();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getDataConnections <em>Data Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Connections</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getDataConnections()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_DataConnections();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getDevice <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Device</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getDevice()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Device();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getDeviceType <em>Device Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Device Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getDeviceType()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_DeviceType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getECAction <em>EC Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EC Action</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getECAction()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ECAction();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getECC <em>ECC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>ECC</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getECC()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ECC();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getECState <em>EC State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EC State</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getECState()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ECState();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getECTransition <em>EC Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EC Transition</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getECTransition()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ECTransition();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getEvent()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Event();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getEventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event Connections</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getEventConnections()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_EventConnections();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getEventInputs <em>Event Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event Inputs</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getEventInputs()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_EventInputs();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getEventOutputs <em>Event Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event Outputs</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getEventOutputs()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_EventOutputs();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getFB <em>FB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getFB()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_FB();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getFBD <em>FBD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FBD</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getFBD()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_FBD();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getFBNetwork()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_FBNetwork();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getFBType <em>FB Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getFBType()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_FBType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getFBTypeName <em>FB Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB Type Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getFBTypeName()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_FBTypeName();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getHCECC <em>HCECC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>HCECC</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getHCECC()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_HCECC();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getHCECCRelation <em>HCECC Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>HCECC Relation</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getHCECCRelation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_HCECCRelation();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identification</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getIdentification()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Identification();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getInputPrimitive <em>Input Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input Primitive</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getInputPrimitive()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_InputPrimitive();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getInputVars <em>Input Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input Vars</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getInputVars()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_InputVars();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getInterfaceList <em>Interface List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interface List</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getInterfaceList()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_InterfaceList();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getInternalVars <em>Internal Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Internal Vars</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getInternalVars()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_InternalVars();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getLD <em>LD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>LD</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getLD()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_LD();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getLink()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Link();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getMapping()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Mapping();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getOther <em>Other</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Other</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getOther()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Other();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getOutputPrimitive <em>Output Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output Primitive</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getOutputPrimitive()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_OutputPrimitive();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getOutputVars <em>Output Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output Vars</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getOutputVars()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_OutputVars();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getParameter()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Parameter();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getPlugs <em>Plugs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Plugs</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getPlugs()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Plugs();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getResource()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Resource();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getResourceType()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ResourceType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getResourceTypeName <em>Resource Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource Type Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getResourceTypeName()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ResourceTypeName();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getRung <em>Rung</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rung</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getRung()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Rung();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSegment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Segment</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getSegment()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Segment();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getService()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Service();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getServiceSequence <em>Service Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service Sequence</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getServiceSequence()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ServiceSequence();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getServiceTransaction <em>Service Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service Transaction</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getServiceTransaction()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ServiceTransaction();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSockets <em>Sockets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sockets</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getSockets()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Sockets();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getST <em>ST</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>ST</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getST()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ST();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubApp <em>Sub App</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub App</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getSubApp()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SubApp();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppEvent <em>Sub App Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub App Event</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppEvent()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SubAppEvent();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppEventInputs <em>Sub App Event Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub App Event Inputs</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppEventInputs()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SubAppEventInputs();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppEventOutputs <em>Sub App Event Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub App Event Outputs</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppEventOutputs()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SubAppEventOutputs();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppInterfaceList <em>Sub App Interface List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub App Interface List</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppInterfaceList()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SubAppInterfaceList();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppNetwork <em>Sub App Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub App Network</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppNetwork()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SubAppNetwork();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppType <em>Sub App Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub App Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getSubAppType()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SubAppType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>System</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getSystem()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_System();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getVarDeclaration <em>Var Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Var Declaration</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getVarDeclaration()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_VarDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getVersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Version Info</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getVersionInfo()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_VersionInfo();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.DocumentRoot#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>With</em>'.
	 * @see de.cau.cs.kieler.functionblock.DocumentRoot#getWith()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_With();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.ECAction <em>EC Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EC Action</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECAction
	 * @generated
	 */
	EClass getECAction();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ECAction#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Algorithm</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECAction#getAlgorithm()
	 * @see #getECAction()
	 * @generated
	 */
	EAttribute getECAction_Algorithm();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ECAction#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECAction#getOutput()
	 * @see #getECAction()
	 * @generated
	 */
	EAttribute getECAction_Output();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.ECC <em>ECC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ECC</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECC
	 * @generated
	 */
	EClass getECC();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.ECC#getECState <em>EC State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EC State</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECC#getECState()
	 * @see #getECC()
	 * @generated
	 */
	EReference getECC_ECState();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.ECC#getECTransition <em>EC Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EC Transition</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECC#getECTransition()
	 * @see #getECC()
	 * @generated
	 */
	EReference getECC_ECTransition();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ECC#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECC#getName()
	 * @see #getECC()
	 * @generated
	 */
	EAttribute getECC_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.ECState <em>EC State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EC State</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECState
	 * @generated
	 */
	EClass getECState();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.ECState#getECAction <em>EC Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>EC Action</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECState#getECAction()
	 * @see #getECState()
	 * @generated
	 */
	EReference getECState_ECAction();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ECState#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECState#getComment()
	 * @see #getECState()
	 * @generated
	 */
	EAttribute getECState_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ECState#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECState#getName()
	 * @see #getECState()
	 * @generated
	 */
	EAttribute getECState_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ECState#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECState#getX()
	 * @see #getECState()
	 * @generated
	 */
	EAttribute getECState_X();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ECState#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECState#getY()
	 * @see #getECState()
	 * @generated
	 */
	EAttribute getECState_Y();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.ECTransition <em>EC Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EC Transition</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECTransition
	 * @generated
	 */
	EClass getECTransition();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ECTransition#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECTransition#getComment()
	 * @see #getECTransition()
	 * @generated
	 */
	EAttribute getECTransition_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ECTransition#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECTransition#getCondition()
	 * @see #getECTransition()
	 * @generated
	 */
	EAttribute getECTransition_Condition();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ECTransition#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECTransition#getDestination()
	 * @see #getECTransition()
	 * @generated
	 */
	EAttribute getECTransition_Destination();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ECTransition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECTransition#getSource()
	 * @see #getECTransition()
	 * @generated
	 */
	EAttribute getECTransition_Source();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ECTransition#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECTransition#getX()
	 * @see #getECTransition()
	 * @generated
	 */
	EAttribute getECTransition_X();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ECTransition#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see de.cau.cs.kieler.functionblock.ECTransition#getY()
	 * @see #getECTransition()
	 * @generated
	 */
	EAttribute getECTransition_Y();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.EventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Connections</em>'.
	 * @see de.cau.cs.kieler.functionblock.EventConnections
	 * @generated
	 */
	EClass getEventConnections();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.EventConnections#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connection</em>'.
	 * @see de.cau.cs.kieler.functionblock.EventConnections#getConnection()
	 * @see #getEventConnections()
	 * @generated
	 */
	EReference getEventConnections_Connection();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.EventInputs <em>Event Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Inputs</em>'.
	 * @see de.cau.cs.kieler.functionblock.EventInputs
	 * @generated
	 */
	EClass getEventInputs();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.EventInputs#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event</em>'.
	 * @see de.cau.cs.kieler.functionblock.EventInputs#getEvent()
	 * @see #getEventInputs()
	 * @generated
	 */
	EReference getEventInputs_Event();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.EventOutputs <em>Event Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Outputs</em>'.
	 * @see de.cau.cs.kieler.functionblock.EventOutputs
	 * @generated
	 */
	EClass getEventOutputs();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.EventOutputs#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event</em>'.
	 * @see de.cau.cs.kieler.functionblock.EventOutputs#getEvent()
	 * @see #getEventOutputs()
	 * @generated
	 */
	EReference getEventOutputs_Event();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see de.cau.cs.kieler.functionblock.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.Event#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>With</em>'.
	 * @see de.cau.cs.kieler.functionblock.Event#getWith()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_With();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Event#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.Event#getComment()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Event#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.Event#getName()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Event#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.Event#getType()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Type();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.FBD <em>FBD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FBD</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBD
	 * @generated
	 */
	EClass getFBD();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.FBD#getFB <em>FB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>FB</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBD#getFB()
	 * @see #getFBD()
	 * @generated
	 */
	EReference getFBD_FB();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.FBD#getDataConnections <em>Data Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Connections</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBD#getDataConnections()
	 * @see #getFBD()
	 * @generated
	 */
	EReference getFBD_DataConnections();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.FBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBNetwork
	 * @generated
	 */
	EClass getFBNetwork();

	/**
	 * Returns the meta object for the attribute list '{@link de.cau.cs.kieler.functionblock.FBNetwork#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBNetwork#getMixed()
	 * @see #getFBNetwork()
	 * @generated
	 */
	EAttribute getFBNetwork_Mixed();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.FBNetwork#getFB <em>FB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>FB</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBNetwork#getFB()
	 * @see #getFBNetwork()
	 * @generated
	 */
	EReference getFBNetwork_FB();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.FBNetwork#getEventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event Connections</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBNetwork#getEventConnections()
	 * @see #getFBNetwork()
	 * @generated
	 */
	EReference getFBNetwork_EventConnections();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.FBNetwork#getDataConnections <em>Data Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Connections</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBNetwork#getDataConnections()
	 * @see #getFBNetwork()
	 * @generated
	 */
	EReference getFBNetwork_DataConnections();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.FBNetwork#getAdapterConnections <em>Adapter Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Adapter Connections</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBNetwork#getAdapterConnections()
	 * @see #getFBNetwork()
	 * @generated
	 */
	EReference getFBNetwork_AdapterConnections();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.FB <em>FB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FB</em>'.
	 * @see de.cau.cs.kieler.functionblock.FB
	 * @generated
	 */
	EClass getFB();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.FB#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see de.cau.cs.kieler.functionblock.FB#getParameter()
	 * @see #getFB()
	 * @generated
	 */
	EReference getFB_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.FB#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.FB#getComment()
	 * @see #getFB()
	 * @generated
	 */
	EAttribute getFB_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.FB#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.FB#getName()
	 * @see #getFB()
	 * @generated
	 */
	EAttribute getFB_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.FB#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.FB#getType()
	 * @see #getFB()
	 * @generated
	 */
	EAttribute getFB_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.FB#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see de.cau.cs.kieler.functionblock.FB#getX()
	 * @see #getFB()
	 * @generated
	 */
	EAttribute getFB_X();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.FB#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see de.cau.cs.kieler.functionblock.FB#getY()
	 * @see #getFB()
	 * @generated
	 */
	EAttribute getFB_Y();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.FBTypeName <em>FB Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FB Type Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBTypeName
	 * @generated
	 */
	EClass getFBTypeName();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.FBTypeName#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBTypeName#getName()
	 * @see #getFBTypeName()
	 * @generated
	 */
	EAttribute getFBTypeName_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.FBType <em>FB Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FB Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBType
	 * @generated
	 */
	EClass getFBType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.FBType#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identification</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBType#getIdentification()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_Identification();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.FBType#getVersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version Info</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBType#getVersionInfo()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_VersionInfo();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.FBType#getCompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compiler Info</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBType#getCompilerInfo()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_CompilerInfo();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.FBType#getInterfaceList <em>Interface List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interface List</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBType#getInterfaceList()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_InterfaceList();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.FBType#getBasicFB <em>Basic FB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Basic FB</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBType#getBasicFB()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_BasicFB();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.FBType#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBType#getFBNetwork()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_FBNetwork();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.FBType#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBType#getService()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_Service();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.FBType#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBType#getComment()
	 * @see #getFBType()
	 * @generated
	 */
	EAttribute getFBType_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.FBType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.FBType#getName()
	 * @see #getFBType()
	 * @generated
	 */
	EAttribute getFBType_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.HCECCRelation <em>HCECC Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HCECC Relation</em>'.
	 * @see de.cau.cs.kieler.functionblock.HCECCRelation
	 * @generated
	 */
	EClass getHCECCRelation();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.HCECCRelation#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.HCECCRelation#getComment()
	 * @see #getHCECCRelation()
	 * @generated
	 */
	EAttribute getHCECCRelation_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.HCECCRelation#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.functionblock.HCECCRelation#getDestination()
	 * @see #getHCECCRelation()
	 * @generated
	 */
	EAttribute getHCECCRelation_Destination();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.HCECCRelation#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relation</em>'.
	 * @see de.cau.cs.kieler.functionblock.HCECCRelation#getRelation()
	 * @see #getHCECCRelation()
	 * @generated
	 */
	EAttribute getHCECCRelation_Relation();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.HCECCRelation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see de.cau.cs.kieler.functionblock.HCECCRelation#getSource()
	 * @see #getHCECCRelation()
	 * @generated
	 */
	EAttribute getHCECCRelation_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.HCECC <em>HCECC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HCECC</em>'.
	 * @see de.cau.cs.kieler.functionblock.HCECC
	 * @generated
	 */
	EClass getHCECC();

	/**
	 * Returns the meta object for the attribute list '{@link de.cau.cs.kieler.functionblock.HCECC#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see de.cau.cs.kieler.functionblock.HCECC#getGroup()
	 * @see #getHCECC()
	 * @generated
	 */
	EAttribute getHCECC_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.HCECC#getECC <em>ECC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>ECC</em>'.
	 * @see de.cau.cs.kieler.functionblock.HCECC#getECC()
	 * @see #getHCECC()
	 * @generated
	 */
	EReference getHCECC_ECC();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.HCECC#getHCECCRelation <em>HCECC Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>HCECC Relation</em>'.
	 * @see de.cau.cs.kieler.functionblock.HCECC#getHCECCRelation()
	 * @see #getHCECC()
	 * @generated
	 */
	EReference getHCECC_HCECCRelation();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Identification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identification</em>'.
	 * @see de.cau.cs.kieler.functionblock.Identification
	 * @generated
	 */
	EClass getIdentification();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Identification#getApplicationDomain <em>Application Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Application Domain</em>'.
	 * @see de.cau.cs.kieler.functionblock.Identification#getApplicationDomain()
	 * @see #getIdentification()
	 * @generated
	 */
	EAttribute getIdentification_ApplicationDomain();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Identification#getClassification <em>Classification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classification</em>'.
	 * @see de.cau.cs.kieler.functionblock.Identification#getClassification()
	 * @see #getIdentification()
	 * @generated
	 */
	EAttribute getIdentification_Classification();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Identification#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.cau.cs.kieler.functionblock.Identification#getDescription()
	 * @see #getIdentification()
	 * @generated
	 */
	EAttribute getIdentification_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Identification#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function</em>'.
	 * @see de.cau.cs.kieler.functionblock.Identification#getFunction()
	 * @see #getIdentification()
	 * @generated
	 */
	EAttribute getIdentification_Function();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Identification#getStandard <em>Standard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Standard</em>'.
	 * @see de.cau.cs.kieler.functionblock.Identification#getStandard()
	 * @see #getIdentification()
	 * @generated
	 */
	EAttribute getIdentification_Standard();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Identification#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.Identification#getType()
	 * @see #getIdentification()
	 * @generated
	 */
	EAttribute getIdentification_Type();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.InputPrimitive <em>Input Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Primitive</em>'.
	 * @see de.cau.cs.kieler.functionblock.InputPrimitive
	 * @generated
	 */
	EClass getInputPrimitive();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.InputPrimitive#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event</em>'.
	 * @see de.cau.cs.kieler.functionblock.InputPrimitive#getEvent()
	 * @see #getInputPrimitive()
	 * @generated
	 */
	EAttribute getInputPrimitive_Event();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.InputPrimitive#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface</em>'.
	 * @see de.cau.cs.kieler.functionblock.InputPrimitive#getInterface()
	 * @see #getInputPrimitive()
	 * @generated
	 */
	EAttribute getInputPrimitive_Interface();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.InputPrimitive#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameters</em>'.
	 * @see de.cau.cs.kieler.functionblock.InputPrimitive#getParameters()
	 * @see #getInputPrimitive()
	 * @generated
	 */
	EAttribute getInputPrimitive_Parameters();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.InputVars <em>Input Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Vars</em>'.
	 * @see de.cau.cs.kieler.functionblock.InputVars
	 * @generated
	 */
	EClass getInputVars();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.InputVars#getVarDeclaration <em>Var Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Var Declaration</em>'.
	 * @see de.cau.cs.kieler.functionblock.InputVars#getVarDeclaration()
	 * @see #getInputVars()
	 * @generated
	 */
	EReference getInputVars_VarDeclaration();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.InterfaceList <em>Interface List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface List</em>'.
	 * @see de.cau.cs.kieler.functionblock.InterfaceList
	 * @generated
	 */
	EClass getInterfaceList();

	/**
	 * Returns the meta object for the attribute list '{@link de.cau.cs.kieler.functionblock.InterfaceList#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see de.cau.cs.kieler.functionblock.InterfaceList#getMixed()
	 * @see #getInterfaceList()
	 * @generated
	 */
	EAttribute getInterfaceList_Mixed();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.InterfaceList#getEventInputs <em>Event Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event Inputs</em>'.
	 * @see de.cau.cs.kieler.functionblock.InterfaceList#getEventInputs()
	 * @see #getInterfaceList()
	 * @generated
	 */
	EReference getInterfaceList_EventInputs();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.InterfaceList#getEventOutputs <em>Event Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event Outputs</em>'.
	 * @see de.cau.cs.kieler.functionblock.InterfaceList#getEventOutputs()
	 * @see #getInterfaceList()
	 * @generated
	 */
	EReference getInterfaceList_EventOutputs();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.InterfaceList#getInputVars <em>Input Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input Vars</em>'.
	 * @see de.cau.cs.kieler.functionblock.InterfaceList#getInputVars()
	 * @see #getInterfaceList()
	 * @generated
	 */
	EReference getInterfaceList_InputVars();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.InterfaceList#getOutputVars <em>Output Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output Vars</em>'.
	 * @see de.cau.cs.kieler.functionblock.InterfaceList#getOutputVars()
	 * @see #getInterfaceList()
	 * @generated
	 */
	EReference getInterfaceList_OutputVars();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.InterfaceList#getSockets <em>Sockets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sockets</em>'.
	 * @see de.cau.cs.kieler.functionblock.InterfaceList#getSockets()
	 * @see #getInterfaceList()
	 * @generated
	 */
	EReference getInterfaceList_Sockets();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.InterfaceList#getPlugs <em>Plugs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Plugs</em>'.
	 * @see de.cau.cs.kieler.functionblock.InterfaceList#getPlugs()
	 * @see #getInterfaceList()
	 * @generated
	 */
	EReference getInterfaceList_Plugs();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.InternalVars <em>Internal Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Vars</em>'.
	 * @see de.cau.cs.kieler.functionblock.InternalVars
	 * @generated
	 */
	EClass getInternalVars();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.InternalVars#getVarDeclaration <em>Var Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Var Declaration</em>'.
	 * @see de.cau.cs.kieler.functionblock.InternalVars#getVarDeclaration()
	 * @see #getInternalVars()
	 * @generated
	 */
	EReference getInternalVars_VarDeclaration();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.LD <em>LD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LD</em>'.
	 * @see de.cau.cs.kieler.functionblock.LD
	 * @generated
	 */
	EClass getLD();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.LD#getRung <em>Rung</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rung</em>'.
	 * @see de.cau.cs.kieler.functionblock.LD#getRung()
	 * @see #getLD()
	 * @generated
	 */
	EReference getLD_Rung();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see de.cau.cs.kieler.functionblock.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.Link#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see de.cau.cs.kieler.functionblock.Link#getParameter()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Link#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.Link#getComment()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Link#getCommResource <em>Comm Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comm Resource</em>'.
	 * @see de.cau.cs.kieler.functionblock.Link#getCommResource()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_CommResource();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Link#getSegmentName <em>Segment Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Segment Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.Link#getSegmentName()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_SegmentName();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see de.cau.cs.kieler.functionblock.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Mapping#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see de.cau.cs.kieler.functionblock.Mapping#getFrom()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_From();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Mapping#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To</em>'.
	 * @see de.cau.cs.kieler.functionblock.Mapping#getTo()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_To();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Other <em>Other</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Other</em>'.
	 * @see de.cau.cs.kieler.functionblock.Other
	 * @generated
	 */
	EClass getOther();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Other#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see de.cau.cs.kieler.functionblock.Other#getLanguage()
	 * @see #getOther()
	 * @generated
	 */
	EAttribute getOther_Language();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Other#getPrototype <em>Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prototype</em>'.
	 * @see de.cau.cs.kieler.functionblock.Other#getPrototype()
	 * @see #getOther()
	 * @generated
	 */
	EAttribute getOther_Prototype();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Other#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see de.cau.cs.kieler.functionblock.Other#getText()
	 * @see #getOther()
	 * @generated
	 */
	EAttribute getOther_Text();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.OutputPrimitive <em>Output Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Primitive</em>'.
	 * @see de.cau.cs.kieler.functionblock.OutputPrimitive
	 * @generated
	 */
	EClass getOutputPrimitive();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.OutputPrimitive#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event</em>'.
	 * @see de.cau.cs.kieler.functionblock.OutputPrimitive#getEvent()
	 * @see #getOutputPrimitive()
	 * @generated
	 */
	EAttribute getOutputPrimitive_Event();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.OutputPrimitive#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface</em>'.
	 * @see de.cau.cs.kieler.functionblock.OutputPrimitive#getInterface()
	 * @see #getOutputPrimitive()
	 * @generated
	 */
	EAttribute getOutputPrimitive_Interface();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.OutputPrimitive#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameters</em>'.
	 * @see de.cau.cs.kieler.functionblock.OutputPrimitive#getParameters()
	 * @see #getOutputPrimitive()
	 * @generated
	 */
	EAttribute getOutputPrimitive_Parameters();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.OutputVars <em>Output Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Vars</em>'.
	 * @see de.cau.cs.kieler.functionblock.OutputVars
	 * @generated
	 */
	EClass getOutputVars();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.OutputVars#getVarDeclaration <em>Var Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Var Declaration</em>'.
	 * @see de.cau.cs.kieler.functionblock.OutputVars#getVarDeclaration()
	 * @see #getOutputVars()
	 * @generated
	 */
	EReference getOutputVars_VarDeclaration();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see de.cau.cs.kieler.functionblock.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Parameter#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.Parameter#getComment()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Parameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.cau.cs.kieler.functionblock.Parameter#getValue()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Value();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Plugs <em>Plugs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugs</em>'.
	 * @see de.cau.cs.kieler.functionblock.Plugs
	 * @generated
	 */
	EClass getPlugs();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.Plugs#getAdapterDeclaration <em>Adapter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Adapter Declaration</em>'.
	 * @see de.cau.cs.kieler.functionblock.Plugs#getAdapterDeclaration()
	 * @see #getPlugs()
	 * @generated
	 */
	EReference getPlugs_AdapterDeclaration();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see de.cau.cs.kieler.functionblock.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.Resource#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see de.cau.cs.kieler.functionblock.Resource#getParameter()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Parameter();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.Resource#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.functionblock.Resource#getFBNetwork()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_FBNetwork();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Resource#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.Resource#getComment()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Resource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.Resource#getName()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Resource#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.Resource#getType()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Resource#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see de.cau.cs.kieler.functionblock.Resource#getX()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_X();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Resource#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see de.cau.cs.kieler.functionblock.Resource#getY()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Y();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.ResourceTypeName <em>Resource Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Type Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.ResourceTypeName
	 * @generated
	 */
	EClass getResourceTypeName();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ResourceTypeName#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.ResourceTypeName#getName()
	 * @see #getResourceTypeName()
	 * @generated
	 */
	EAttribute getResourceTypeName_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.ResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.ResourceType
	 * @generated
	 */
	EClass getResourceType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.ResourceType#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identification</em>'.
	 * @see de.cau.cs.kieler.functionblock.ResourceType#getIdentification()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_Identification();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.ResourceType#getVersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version Info</em>'.
	 * @see de.cau.cs.kieler.functionblock.ResourceType#getVersionInfo()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_VersionInfo();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.ResourceType#getCompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compiler Info</em>'.
	 * @see de.cau.cs.kieler.functionblock.ResourceType#getCompilerInfo()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_CompilerInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.ResourceType#getFBTypeName <em>FB Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>FB Type Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.ResourceType#getFBTypeName()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_FBTypeName();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.ResourceType#getVarDeclaration <em>Var Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Var Declaration</em>'.
	 * @see de.cau.cs.kieler.functionblock.ResourceType#getVarDeclaration()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_VarDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.ResourceType#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.functionblock.ResourceType#getFBNetwork()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_FBNetwork();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ResourceType#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.ResourceType#getComment()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ResourceType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.ResourceType#getName()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Rung <em>Rung</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rung</em>'.
	 * @see de.cau.cs.kieler.functionblock.Rung
	 * @generated
	 */
	EClass getRung();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Rung#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.Rung#getComment()
	 * @see #getRung()
	 * @generated
	 */
	EAttribute getRung_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Rung#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see de.cau.cs.kieler.functionblock.Rung#getExpression()
	 * @see #getRung()
	 * @generated
	 */
	EAttribute getRung_Expression();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Rung#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output</em>'.
	 * @see de.cau.cs.kieler.functionblock.Rung#getOutput()
	 * @see #getRung()
	 * @generated
	 */
	EAttribute getRung_Output();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Segment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Segment</em>'.
	 * @see de.cau.cs.kieler.functionblock.Segment
	 * @generated
	 */
	EClass getSegment();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.Segment#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see de.cau.cs.kieler.functionblock.Segment#getParameter()
	 * @see #getSegment()
	 * @generated
	 */
	EReference getSegment_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Segment#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.Segment#getComment()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Segment#getDx1 <em>Dx1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dx1</em>'.
	 * @see de.cau.cs.kieler.functionblock.Segment#getDx1()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_Dx1();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Segment#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.Segment#getName()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Segment#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.Segment#getType()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Segment#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see de.cau.cs.kieler.functionblock.Segment#getX()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_X();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Segment#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see de.cau.cs.kieler.functionblock.Segment#getY()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_Y();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.ServiceSequence <em>Service Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Sequence</em>'.
	 * @see de.cau.cs.kieler.functionblock.ServiceSequence
	 * @generated
	 */
	EClass getServiceSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.ServiceSequence#getServiceTransaction <em>Service Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Transaction</em>'.
	 * @see de.cau.cs.kieler.functionblock.ServiceSequence#getServiceTransaction()
	 * @see #getServiceSequence()
	 * @generated
	 */
	EReference getServiceSequence_ServiceTransaction();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ServiceSequence#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.ServiceSequence#getComment()
	 * @see #getServiceSequence()
	 * @generated
	 */
	EAttribute getServiceSequence_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ServiceSequence#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.ServiceSequence#getName()
	 * @see #getServiceSequence()
	 * @generated
	 */
	EAttribute getServiceSequence_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.ServiceTransaction <em>Service Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Transaction</em>'.
	 * @see de.cau.cs.kieler.functionblock.ServiceTransaction
	 * @generated
	 */
	EClass getServiceTransaction();

	/**
	 * Returns the meta object for the attribute list '{@link de.cau.cs.kieler.functionblock.ServiceTransaction#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see de.cau.cs.kieler.functionblock.ServiceTransaction#getMixed()
	 * @see #getServiceTransaction()
	 * @generated
	 */
	EAttribute getServiceTransaction_Mixed();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.ServiceTransaction#getInputPrimitive <em>Input Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input Primitive</em>'.
	 * @see de.cau.cs.kieler.functionblock.ServiceTransaction#getInputPrimitive()
	 * @see #getServiceTransaction()
	 * @generated
	 */
	EReference getServiceTransaction_InputPrimitive();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.ServiceTransaction#getOutputPrimitive <em>Output Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Primitive</em>'.
	 * @see de.cau.cs.kieler.functionblock.ServiceTransaction#getOutputPrimitive()
	 * @see #getServiceTransaction()
	 * @generated
	 */
	EReference getServiceTransaction_OutputPrimitive();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see de.cau.cs.kieler.functionblock.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.Service#getServiceSequence <em>Service Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Sequence</em>'.
	 * @see de.cau.cs.kieler.functionblock.Service#getServiceSequence()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_ServiceSequence();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Service#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.Service#getComment()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Service#getLeftInterface <em>Left Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Left Interface</em>'.
	 * @see de.cau.cs.kieler.functionblock.Service#getLeftInterface()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_LeftInterface();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.Service#getRightInterface <em>Right Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right Interface</em>'.
	 * @see de.cau.cs.kieler.functionblock.Service#getRightInterface()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_RightInterface();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.Sockets <em>Sockets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sockets</em>'.
	 * @see de.cau.cs.kieler.functionblock.Sockets
	 * @generated
	 */
	EClass getSockets();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.Sockets#getAdapterDeclaration <em>Adapter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Adapter Declaration</em>'.
	 * @see de.cau.cs.kieler.functionblock.Sockets#getAdapterDeclaration()
	 * @see #getSockets()
	 * @generated
	 */
	EReference getSockets_AdapterDeclaration();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.ST <em>ST</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ST</em>'.
	 * @see de.cau.cs.kieler.functionblock.ST
	 * @generated
	 */
	EClass getST();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.ST#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see de.cau.cs.kieler.functionblock.ST#getText()
	 * @see #getST()
	 * @generated
	 */
	EAttribute getST_Text();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.SubAppEventInputs <em>Sub App Event Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub App Event Inputs</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppEventInputs
	 * @generated
	 */
	EClass getSubAppEventInputs();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.SubAppEventInputs#getSubAppEvent <em>Sub App Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub App Event</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppEventInputs#getSubAppEvent()
	 * @see #getSubAppEventInputs()
	 * @generated
	 */
	EReference getSubAppEventInputs_SubAppEvent();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.SubAppEventOutputs <em>Sub App Event Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub App Event Outputs</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppEventOutputs
	 * @generated
	 */
	EClass getSubAppEventOutputs();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.SubAppEventOutputs#getSubAppEvent <em>Sub App Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub App Event</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppEventOutputs#getSubAppEvent()
	 * @see #getSubAppEventOutputs()
	 * @generated
	 */
	EReference getSubAppEventOutputs_SubAppEvent();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.SubAppEvent <em>Sub App Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub App Event</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppEvent
	 * @generated
	 */
	EClass getSubAppEvent();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.SubAppEvent#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppEvent#getComment()
	 * @see #getSubAppEvent()
	 * @generated
	 */
	EAttribute getSubAppEvent_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.SubAppEvent#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppEvent#getName()
	 * @see #getSubAppEvent()
	 * @generated
	 */
	EAttribute getSubAppEvent_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.SubAppEvent#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppEvent#getType()
	 * @see #getSubAppEvent()
	 * @generated
	 */
	EAttribute getSubAppEvent_Type();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.SubAppInterfaceList <em>Sub App Interface List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub App Interface List</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppInterfaceList
	 * @generated
	 */
	EClass getSubAppInterfaceList();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.SubAppInterfaceList#getSubAppEventInputs <em>Sub App Event Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub App Event Inputs</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppInterfaceList#getSubAppEventInputs()
	 * @see #getSubAppInterfaceList()
	 * @generated
	 */
	EReference getSubAppInterfaceList_SubAppEventInputs();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.SubAppInterfaceList#getSubAppEventOutputs <em>Sub App Event Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub App Event Outputs</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppInterfaceList#getSubAppEventOutputs()
	 * @see #getSubAppInterfaceList()
	 * @generated
	 */
	EReference getSubAppInterfaceList_SubAppEventOutputs();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.SubAppInterfaceList#getInputVars <em>Input Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input Vars</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppInterfaceList#getInputVars()
	 * @see #getSubAppInterfaceList()
	 * @generated
	 */
	EReference getSubAppInterfaceList_InputVars();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.SubAppInterfaceList#getOutputVars <em>Output Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output Vars</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppInterfaceList#getOutputVars()
	 * @see #getSubAppInterfaceList()
	 * @generated
	 */
	EReference getSubAppInterfaceList_OutputVars();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.SubAppNetwork <em>Sub App Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub App Network</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppNetwork
	 * @generated
	 */
	EClass getSubAppNetwork();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.SubAppNetwork#getSubApp <em>Sub App</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub App</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppNetwork#getSubApp()
	 * @see #getSubAppNetwork()
	 * @generated
	 */
	EReference getSubAppNetwork_SubApp();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.SubAppNetwork#getFB <em>FB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>FB</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppNetwork#getFB()
	 * @see #getSubAppNetwork()
	 * @generated
	 */
	EReference getSubAppNetwork_FB();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.SubAppNetwork#getEventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event Connections</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppNetwork#getEventConnections()
	 * @see #getSubAppNetwork()
	 * @generated
	 */
	EReference getSubAppNetwork_EventConnections();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.SubAppNetwork#getDataConnections <em>Data Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Connections</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppNetwork#getDataConnections()
	 * @see #getSubAppNetwork()
	 * @generated
	 */
	EReference getSubAppNetwork_DataConnections();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.SubApp <em>Sub App</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub App</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubApp
	 * @generated
	 */
	EClass getSubApp();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.SubApp#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubApp#getComment()
	 * @see #getSubApp()
	 * @generated
	 */
	EAttribute getSubApp_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.SubApp#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubApp#getName()
	 * @see #getSubApp()
	 * @generated
	 */
	EAttribute getSubApp_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.SubApp#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubApp#getType()
	 * @see #getSubApp()
	 * @generated
	 */
	EAttribute getSubApp_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.SubApp#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubApp#getX()
	 * @see #getSubApp()
	 * @generated
	 */
	EAttribute getSubApp_X();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.SubApp#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubApp#getY()
	 * @see #getSubApp()
	 * @generated
	 */
	EAttribute getSubApp_Y();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.SubAppType <em>Sub App Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub App Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppType
	 * @generated
	 */
	EClass getSubAppType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.SubAppType#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identification</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppType#getIdentification()
	 * @see #getSubAppType()
	 * @generated
	 */
	EReference getSubAppType_Identification();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.SubAppType#getVersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version Info</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppType#getVersionInfo()
	 * @see #getSubAppType()
	 * @generated
	 */
	EReference getSubAppType_VersionInfo();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.SubAppType#getCompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compiler Info</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppType#getCompilerInfo()
	 * @see #getSubAppType()
	 * @generated
	 */
	EReference getSubAppType_CompilerInfo();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.SubAppType#getSubAppInterfaceList <em>Sub App Interface List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub App Interface List</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppType#getSubAppInterfaceList()
	 * @see #getSubAppType()
	 * @generated
	 */
	EReference getSubAppType_SubAppInterfaceList();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.SubAppType#getSubAppNetwork <em>Sub App Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub App Network</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppType#getSubAppNetwork()
	 * @see #getSubAppType()
	 * @generated
	 */
	EReference getSubAppType_SubAppNetwork();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.SubAppType#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppType#getComment()
	 * @see #getSubAppType()
	 * @generated
	 */
	EAttribute getSubAppType_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.SubAppType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.SubAppType#getName()
	 * @see #getSubAppType()
	 * @generated
	 */
	EAttribute getSubAppType_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see de.cau.cs.kieler.functionblock.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.functionblock.System#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identification</em>'.
	 * @see de.cau.cs.kieler.functionblock.System#getIdentification()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Identification();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.System#getVersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version Info</em>'.
	 * @see de.cau.cs.kieler.functionblock.System#getVersionInfo()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_VersionInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.System#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Application</em>'.
	 * @see de.cau.cs.kieler.functionblock.System#getApplication()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Application();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.System#getDevice <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Device</em>'.
	 * @see de.cau.cs.kieler.functionblock.System#getDevice()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Device();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.System#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping</em>'.
	 * @see de.cau.cs.kieler.functionblock.System#getMapping()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Mapping();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.System#getSegment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Segment</em>'.
	 * @see de.cau.cs.kieler.functionblock.System#getSegment()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Segment();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.functionblock.System#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link</em>'.
	 * @see de.cau.cs.kieler.functionblock.System#getLink()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Link();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.System#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.System#getComment()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.System#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.System#getName()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.VarDeclaration <em>Var Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Declaration</em>'.
	 * @see de.cau.cs.kieler.functionblock.VarDeclaration
	 * @generated
	 */
	EClass getVarDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.VarDeclaration#getArraySize <em>Array Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Array Size</em>'.
	 * @see de.cau.cs.kieler.functionblock.VarDeclaration#getArraySize()
	 * @see #getVarDeclaration()
	 * @generated
	 */
	EAttribute getVarDeclaration_ArraySize();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.VarDeclaration#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.functionblock.VarDeclaration#getComment()
	 * @see #getVarDeclaration()
	 * @generated
	 */
	EAttribute getVarDeclaration_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.VarDeclaration#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Value</em>'.
	 * @see de.cau.cs.kieler.functionblock.VarDeclaration#getInitialValue()
	 * @see #getVarDeclaration()
	 * @generated
	 */
	EAttribute getVarDeclaration_InitialValue();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.VarDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.functionblock.VarDeclaration#getName()
	 * @see #getVarDeclaration()
	 * @generated
	 */
	EAttribute getVarDeclaration_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.VarDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.cau.cs.kieler.functionblock.VarDeclaration#getType()
	 * @see #getVarDeclaration()
	 * @generated
	 */
	EAttribute getVarDeclaration_Type();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.VersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version Info</em>'.
	 * @see de.cau.cs.kieler.functionblock.VersionInfo
	 * @generated
	 */
	EClass getVersionInfo();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.VersionInfo#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see de.cau.cs.kieler.functionblock.VersionInfo#getAuthor()
	 * @see #getVersionInfo()
	 * @generated
	 */
	EAttribute getVersionInfo_Author();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.VersionInfo#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see de.cau.cs.kieler.functionblock.VersionInfo#getDate()
	 * @see #getVersionInfo()
	 * @generated
	 */
	EAttribute getVersionInfo_Date();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.VersionInfo#getOrganization <em>Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Organization</em>'.
	 * @see de.cau.cs.kieler.functionblock.VersionInfo#getOrganization()
	 * @see #getVersionInfo()
	 * @generated
	 */
	EAttribute getVersionInfo_Organization();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.VersionInfo#getRemarks <em>Remarks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remarks</em>'.
	 * @see de.cau.cs.kieler.functionblock.VersionInfo#getRemarks()
	 * @see #getVersionInfo()
	 * @generated
	 */
	EAttribute getVersionInfo_Remarks();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.VersionInfo#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.cau.cs.kieler.functionblock.VersionInfo#getVersion()
	 * @see #getVersionInfo()
	 * @generated
	 */
	EAttribute getVersionInfo_Version();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.functionblock.With <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>With</em>'.
	 * @see de.cau.cs.kieler.functionblock.With
	 * @generated
	 */
	EClass getWith();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.functionblock.With#getVar <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var</em>'.
	 * @see de.cau.cs.kieler.functionblock.With#getVar()
	 * @see #getWith()
	 * @generated
	 */
	EAttribute getWith_Var();

	/**
	 * Returns the meta object for enum '{@link de.cau.cs.kieler.functionblock.Language <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Language</em>'.
	 * @see de.cau.cs.kieler.functionblock.Language
	 * @generated
	 */
	EEnum getLanguage();

	/**
	 * Returns the meta object for data type '{@link de.cau.cs.kieler.functionblock.Language <em>Language Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Language Object</em>'.
	 * @see de.cau.cs.kieler.functionblock.Language
	 * @model instanceClass="de.cau.cs.kieler.functionblock.Language"
	 *        extendedMetaData="name='Language_._type:Object' baseType='Language_._type'"
	 * @generated
	 */
	EDataType getLanguageObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FunctionblockFactory getFunctionblockFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.AdapterConnectionsImpl <em>Adapter Connections</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.AdapterConnectionsImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getAdapterConnections()
		 * @generated
		 */
		EClass ADAPTER_CONNECTIONS = eINSTANCE.getAdapterConnections();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_CONNECTIONS__CONNECTION = eINSTANCE.getAdapterConnections_Connection();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.AdapterDeclarationImpl <em>Adapter Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.AdapterDeclarationImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getAdapterDeclaration()
		 * @generated
		 */
		EClass ADAPTER_DECLARATION = eINSTANCE.getAdapterDeclaration();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_DECLARATION__PARAMETER = eINSTANCE.getAdapterDeclaration_Parameter();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER_DECLARATION__COMMENT = eINSTANCE.getAdapterDeclaration_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER_DECLARATION__NAME = eINSTANCE.getAdapterDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER_DECLARATION__TYPE = eINSTANCE.getAdapterDeclaration_Type();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.AdapterTypeImpl <em>Adapter Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.AdapterTypeImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getAdapterType()
		 * @generated
		 */
		EClass ADAPTER_TYPE = eINSTANCE.getAdapterType();

		/**
		 * The meta object literal for the '<em><b>Identification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_TYPE__IDENTIFICATION = eINSTANCE.getAdapterType_Identification();

		/**
		 * The meta object literal for the '<em><b>Version Info</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_TYPE__VERSION_INFO = eINSTANCE.getAdapterType_VersionInfo();

		/**
		 * The meta object literal for the '<em><b>Compiler Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_TYPE__COMPILER_INFO = eINSTANCE.getAdapterType_CompilerInfo();

		/**
		 * The meta object literal for the '<em><b>Interface List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_TYPE__INTERFACE_LIST = eINSTANCE.getAdapterType_InterfaceList();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_TYPE__SERVICE = eINSTANCE.getAdapterType_Service();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER_TYPE__COMMENT = eINSTANCE.getAdapterType_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER_TYPE__NAME = eINSTANCE.getAdapterType_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.AlgorithmImpl <em>Algorithm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.AlgorithmImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getAlgorithm()
		 * @generated
		 */
		EClass ALGORITHM = eINSTANCE.getAlgorithm();

		/**
		 * The meta object literal for the '<em><b>FBD</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALGORITHM__FBD = eINSTANCE.getAlgorithm_FBD();

		/**
		 * The meta object literal for the '<em><b>ST</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALGORITHM__ST = eINSTANCE.getAlgorithm_ST();

		/**
		 * The meta object literal for the '<em><b>LD</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALGORITHM__LD = eINSTANCE.getAlgorithm_LD();

		/**
		 * The meta object literal for the '<em><b>Other</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALGORITHM__OTHER = eINSTANCE.getAlgorithm_Other();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALGORITHM__COMMENT = eINSTANCE.getAlgorithm_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALGORITHM__NAME = eINSTANCE.getAlgorithm_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.ApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.ApplicationImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getApplication()
		 * @generated
		 */
		EClass APPLICATION = eINSTANCE.getApplication();

		/**
		 * The meta object literal for the '<em><b>FB Network</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__FB_NETWORK = eINSTANCE.getApplication_FBNetwork();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__COMMENT = eINSTANCE.getApplication_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__NAME = eINSTANCE.getApplication_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.BasicFBImpl <em>Basic FB</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.BasicFBImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getBasicFB()
		 * @generated
		 */
		EClass BASIC_FB = eINSTANCE.getBasicFB();

		/**
		 * The meta object literal for the '<em><b>Internal Vars</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_FB__INTERNAL_VARS = eINSTANCE.getBasicFB_InternalVars();

		/**
		 * The meta object literal for the '<em><b>ECC</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_FB__ECC = eINSTANCE.getBasicFB_ECC();

		/**
		 * The meta object literal for the '<em><b>HCECC</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_FB__HCECC = eINSTANCE.getBasicFB_HCECC();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_FB__ALGORITHM = eINSTANCE.getBasicFB_Algorithm();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.CompilerInfoImpl <em>Compiler Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.CompilerInfoImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getCompilerInfo()
		 * @generated
		 */
		EClass COMPILER_INFO = eINSTANCE.getCompilerInfo();

		/**
		 * The meta object literal for the '<em><b>Compiler</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPILER_INFO__COMPILER = eINSTANCE.getCompilerInfo_Compiler();

		/**
		 * The meta object literal for the '<em><b>Classdef</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILER_INFO__CLASSDEF = eINSTANCE.getCompilerInfo_Classdef();

		/**
		 * The meta object literal for the '<em><b>Header</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILER_INFO__HEADER = eINSTANCE.getCompilerInfo_Header();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.CompilerImpl <em>Compiler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.CompilerImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getCompiler()
		 * @generated
		 */
		EClass COMPILER = eINSTANCE.getCompiler();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILER__LANGUAGE = eINSTANCE.getCompiler_Language();

		/**
		 * The meta object literal for the '<em><b>Product</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILER__PRODUCT = eINSTANCE.getCompiler_Product();

		/**
		 * The meta object literal for the '<em><b>Vendor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILER__VENDOR = eINSTANCE.getCompiler_Vendor();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILER__VERSION = eINSTANCE.getCompiler_Version();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.ConnectionImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__COMMENT = eINSTANCE.getConnection_Comment();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__DESTINATION = eINSTANCE.getConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Dx1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__DX1 = eINSTANCE.getConnection_Dx1();

		/**
		 * The meta object literal for the '<em><b>Dx2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__DX2 = eINSTANCE.getConnection_Dx2();

		/**
		 * The meta object literal for the '<em><b>Dy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__DY = eINSTANCE.getConnection_Dy();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__SOURCE = eINSTANCE.getConnection_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.DataConnectionsImpl <em>Data Connections</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.DataConnectionsImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getDataConnections()
		 * @generated
		 */
		EClass DATA_CONNECTIONS = eINSTANCE.getDataConnections();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CONNECTIONS__CONNECTION = eINSTANCE.getDataConnections_Connection();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.DeviceImpl <em>Device</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.DeviceImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getDevice()
		 * @generated
		 */
		EClass DEVICE = eINSTANCE.getDevice();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE__PARAMETER = eINSTANCE.getDevice_Parameter();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE__RESOURCE = eINSTANCE.getDevice_Resource();

		/**
		 * The meta object literal for the '<em><b>FB Network</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE__FB_NETWORK = eINSTANCE.getDevice_FBNetwork();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__COMMENT = eINSTANCE.getDevice_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__NAME = eINSTANCE.getDevice_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__TYPE = eINSTANCE.getDevice_Type();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__X = eINSTANCE.getDevice_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__Y = eINSTANCE.getDevice_Y();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.DeviceTypeImpl <em>Device Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.DeviceTypeImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getDeviceType()
		 * @generated
		 */
		EClass DEVICE_TYPE = eINSTANCE.getDeviceType();

		/**
		 * The meta object literal for the '<em><b>Identification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_TYPE__IDENTIFICATION = eINSTANCE.getDeviceType_Identification();

		/**
		 * The meta object literal for the '<em><b>Version Info</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_TYPE__VERSION_INFO = eINSTANCE.getDeviceType_VersionInfo();

		/**
		 * The meta object literal for the '<em><b>Compiler Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_TYPE__COMPILER_INFO = eINSTANCE.getDeviceType_CompilerInfo();

		/**
		 * The meta object literal for the '<em><b>Var Declaration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_TYPE__VAR_DECLARATION = eINSTANCE.getDeviceType_VarDeclaration();

		/**
		 * The meta object literal for the '<em><b>Resource Type Name</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_TYPE__RESOURCE_TYPE_NAME = eINSTANCE.getDeviceType_ResourceTypeName();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_TYPE__RESOURCE = eINSTANCE.getDeviceType_Resource();

		/**
		 * The meta object literal for the '<em><b>FB Network</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_TYPE__FB_NETWORK = eINSTANCE.getDeviceType_FBNetwork();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE_TYPE__COMMENT = eINSTANCE.getDeviceType_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE_TYPE__NAME = eINSTANCE.getDeviceType_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.DocumentRootImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Adapter Connections</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ADAPTER_CONNECTIONS = eINSTANCE.getDocumentRoot_AdapterConnections();

		/**
		 * The meta object literal for the '<em><b>Adapter Declaration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ADAPTER_DECLARATION = eINSTANCE.getDocumentRoot_AdapterDeclaration();

		/**
		 * The meta object literal for the '<em><b>Adapter Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ADAPTER_TYPE = eINSTANCE.getDocumentRoot_AdapterType();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ALGORITHM = eINSTANCE.getDocumentRoot_Algorithm();

		/**
		 * The meta object literal for the '<em><b>Application</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__APPLICATION = eINSTANCE.getDocumentRoot_Application();

		/**
		 * The meta object literal for the '<em><b>Basic FB</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__BASIC_FB = eINSTANCE.getDocumentRoot_BasicFB();

		/**
		 * The meta object literal for the '<em><b>Compiler</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__COMPILER = eINSTANCE.getDocumentRoot_Compiler();

		/**
		 * The meta object literal for the '<em><b>Compiler Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__COMPILER_INFO = eINSTANCE.getDocumentRoot_CompilerInfo();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__CONNECTION = eINSTANCE.getDocumentRoot_Connection();

		/**
		 * The meta object literal for the '<em><b>Data Connections</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DATA_CONNECTIONS = eINSTANCE.getDocumentRoot_DataConnections();

		/**
		 * The meta object literal for the '<em><b>Device</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DEVICE = eINSTANCE.getDocumentRoot_Device();

		/**
		 * The meta object literal for the '<em><b>Device Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DEVICE_TYPE = eINSTANCE.getDocumentRoot_DeviceType();

		/**
		 * The meta object literal for the '<em><b>EC Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EC_ACTION = eINSTANCE.getDocumentRoot_ECAction();

		/**
		 * The meta object literal for the '<em><b>ECC</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ECC = eINSTANCE.getDocumentRoot_ECC();

		/**
		 * The meta object literal for the '<em><b>EC State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EC_STATE = eINSTANCE.getDocumentRoot_ECState();

		/**
		 * The meta object literal for the '<em><b>EC Transition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EC_TRANSITION = eINSTANCE.getDocumentRoot_ECTransition();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EVENT = eINSTANCE.getDocumentRoot_Event();

		/**
		 * The meta object literal for the '<em><b>Event Connections</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EVENT_CONNECTIONS = eINSTANCE.getDocumentRoot_EventConnections();

		/**
		 * The meta object literal for the '<em><b>Event Inputs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EVENT_INPUTS = eINSTANCE.getDocumentRoot_EventInputs();

		/**
		 * The meta object literal for the '<em><b>Event Outputs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EVENT_OUTPUTS = eINSTANCE.getDocumentRoot_EventOutputs();

		/**
		 * The meta object literal for the '<em><b>FB</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__FB = eINSTANCE.getDocumentRoot_FB();

		/**
		 * The meta object literal for the '<em><b>FBD</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__FBD = eINSTANCE.getDocumentRoot_FBD();

		/**
		 * The meta object literal for the '<em><b>FB Network</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__FB_NETWORK = eINSTANCE.getDocumentRoot_FBNetwork();

		/**
		 * The meta object literal for the '<em><b>FB Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__FB_TYPE = eINSTANCE.getDocumentRoot_FBType();

		/**
		 * The meta object literal for the '<em><b>FB Type Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__FB_TYPE_NAME = eINSTANCE.getDocumentRoot_FBTypeName();

		/**
		 * The meta object literal for the '<em><b>HCECC</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__HCECC = eINSTANCE.getDocumentRoot_HCECC();

		/**
		 * The meta object literal for the '<em><b>HCECC Relation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__HCECC_RELATION = eINSTANCE.getDocumentRoot_HCECCRelation();

		/**
		 * The meta object literal for the '<em><b>Identification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__IDENTIFICATION = eINSTANCE.getDocumentRoot_Identification();

		/**
		 * The meta object literal for the '<em><b>Input Primitive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__INPUT_PRIMITIVE = eINSTANCE.getDocumentRoot_InputPrimitive();

		/**
		 * The meta object literal for the '<em><b>Input Vars</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__INPUT_VARS = eINSTANCE.getDocumentRoot_InputVars();

		/**
		 * The meta object literal for the '<em><b>Interface List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__INTERFACE_LIST = eINSTANCE.getDocumentRoot_InterfaceList();

		/**
		 * The meta object literal for the '<em><b>Internal Vars</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__INTERNAL_VARS = eINSTANCE.getDocumentRoot_InternalVars();

		/**
		 * The meta object literal for the '<em><b>LD</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__LD = eINSTANCE.getDocumentRoot_LD();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__LINK = eINSTANCE.getDocumentRoot_Link();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__MAPPING = eINSTANCE.getDocumentRoot_Mapping();

		/**
		 * The meta object literal for the '<em><b>Other</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__OTHER = eINSTANCE.getDocumentRoot_Other();

		/**
		 * The meta object literal for the '<em><b>Output Primitive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__OUTPUT_PRIMITIVE = eINSTANCE.getDocumentRoot_OutputPrimitive();

		/**
		 * The meta object literal for the '<em><b>Output Vars</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__OUTPUT_VARS = eINSTANCE.getDocumentRoot_OutputVars();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PARAMETER = eINSTANCE.getDocumentRoot_Parameter();

		/**
		 * The meta object literal for the '<em><b>Plugs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PLUGS = eINSTANCE.getDocumentRoot_Plugs();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__RESOURCE = eINSTANCE.getDocumentRoot_Resource();

		/**
		 * The meta object literal for the '<em><b>Resource Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__RESOURCE_TYPE = eINSTANCE.getDocumentRoot_ResourceType();

		/**
		 * The meta object literal for the '<em><b>Resource Type Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__RESOURCE_TYPE_NAME = eINSTANCE.getDocumentRoot_ResourceTypeName();

		/**
		 * The meta object literal for the '<em><b>Rung</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__RUNG = eINSTANCE.getDocumentRoot_Rung();

		/**
		 * The meta object literal for the '<em><b>Segment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SEGMENT = eINSTANCE.getDocumentRoot_Segment();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SERVICE = eINSTANCE.getDocumentRoot_Service();

		/**
		 * The meta object literal for the '<em><b>Service Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SERVICE_SEQUENCE = eINSTANCE.getDocumentRoot_ServiceSequence();

		/**
		 * The meta object literal for the '<em><b>Service Transaction</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SERVICE_TRANSACTION = eINSTANCE.getDocumentRoot_ServiceTransaction();

		/**
		 * The meta object literal for the '<em><b>Sockets</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SOCKETS = eINSTANCE.getDocumentRoot_Sockets();

		/**
		 * The meta object literal for the '<em><b>ST</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ST = eINSTANCE.getDocumentRoot_ST();

		/**
		 * The meta object literal for the '<em><b>Sub App</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SUB_APP = eINSTANCE.getDocumentRoot_SubApp();

		/**
		 * The meta object literal for the '<em><b>Sub App Event</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SUB_APP_EVENT = eINSTANCE.getDocumentRoot_SubAppEvent();

		/**
		 * The meta object literal for the '<em><b>Sub App Event Inputs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SUB_APP_EVENT_INPUTS = eINSTANCE.getDocumentRoot_SubAppEventInputs();

		/**
		 * The meta object literal for the '<em><b>Sub App Event Outputs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SUB_APP_EVENT_OUTPUTS = eINSTANCE.getDocumentRoot_SubAppEventOutputs();

		/**
		 * The meta object literal for the '<em><b>Sub App Interface List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SUB_APP_INTERFACE_LIST = eINSTANCE.getDocumentRoot_SubAppInterfaceList();

		/**
		 * The meta object literal for the '<em><b>Sub App Network</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SUB_APP_NETWORK = eINSTANCE.getDocumentRoot_SubAppNetwork();

		/**
		 * The meta object literal for the '<em><b>Sub App Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SUB_APP_TYPE = eINSTANCE.getDocumentRoot_SubAppType();

		/**
		 * The meta object literal for the '<em><b>System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SYSTEM = eINSTANCE.getDocumentRoot_System();

		/**
		 * The meta object literal for the '<em><b>Var Declaration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__VAR_DECLARATION = eINSTANCE.getDocumentRoot_VarDeclaration();

		/**
		 * The meta object literal for the '<em><b>Version Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__VERSION_INFO = eINSTANCE.getDocumentRoot_VersionInfo();

		/**
		 * The meta object literal for the '<em><b>With</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__WITH = eINSTANCE.getDocumentRoot_With();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.ECActionImpl <em>EC Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.ECActionImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getECAction()
		 * @generated
		 */
		EClass EC_ACTION = eINSTANCE.getECAction();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EC_ACTION__ALGORITHM = eINSTANCE.getECAction_Algorithm();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EC_ACTION__OUTPUT = eINSTANCE.getECAction_Output();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.ECCImpl <em>ECC</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.ECCImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getECC()
		 * @generated
		 */
		EClass ECC = eINSTANCE.getECC();

		/**
		 * The meta object literal for the '<em><b>EC State</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECC__EC_STATE = eINSTANCE.getECC_ECState();

		/**
		 * The meta object literal for the '<em><b>EC Transition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECC__EC_TRANSITION = eINSTANCE.getECC_ECTransition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECC__NAME = eINSTANCE.getECC_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.ECStateImpl <em>EC State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.ECStateImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getECState()
		 * @generated
		 */
		EClass EC_STATE = eINSTANCE.getECState();

		/**
		 * The meta object literal for the '<em><b>EC Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EC_STATE__EC_ACTION = eINSTANCE.getECState_ECAction();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EC_STATE__COMMENT = eINSTANCE.getECState_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EC_STATE__NAME = eINSTANCE.getECState_Name();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EC_STATE__X = eINSTANCE.getECState_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EC_STATE__Y = eINSTANCE.getECState_Y();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.ECTransitionImpl <em>EC Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.ECTransitionImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getECTransition()
		 * @generated
		 */
		EClass EC_TRANSITION = eINSTANCE.getECTransition();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EC_TRANSITION__COMMENT = eINSTANCE.getECTransition_Comment();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EC_TRANSITION__CONDITION = eINSTANCE.getECTransition_Condition();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EC_TRANSITION__DESTINATION = eINSTANCE.getECTransition_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EC_TRANSITION__SOURCE = eINSTANCE.getECTransition_Source();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EC_TRANSITION__X = eINSTANCE.getECTransition_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EC_TRANSITION__Y = eINSTANCE.getECTransition_Y();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.EventConnectionsImpl <em>Event Connections</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.EventConnectionsImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getEventConnections()
		 * @generated
		 */
		EClass EVENT_CONNECTIONS = eINSTANCE.getEventConnections();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_CONNECTIONS__CONNECTION = eINSTANCE.getEventConnections_Connection();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.EventInputsImpl <em>Event Inputs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.EventInputsImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getEventInputs()
		 * @generated
		 */
		EClass EVENT_INPUTS = eINSTANCE.getEventInputs();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_INPUTS__EVENT = eINSTANCE.getEventInputs_Event();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.EventOutputsImpl <em>Event Outputs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.EventOutputsImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getEventOutputs()
		 * @generated
		 */
		EClass EVENT_OUTPUTS = eINSTANCE.getEventOutputs();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_OUTPUTS__EVENT = eINSTANCE.getEventOutputs_Event();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.EventImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>With</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__WITH = eINSTANCE.getEvent_With();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__COMMENT = eINSTANCE.getEvent_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__NAME = eINSTANCE.getEvent_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TYPE = eINSTANCE.getEvent_Type();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.FBDImpl <em>FBD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.FBDImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getFBD()
		 * @generated
		 */
		EClass FBD = eINSTANCE.getFBD();

		/**
		 * The meta object literal for the '<em><b>FB</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FBD__FB = eINSTANCE.getFBD_FB();

		/**
		 * The meta object literal for the '<em><b>Data Connections</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FBD__DATA_CONNECTIONS = eINSTANCE.getFBD_DataConnections();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.FBNetworkImpl <em>FB Network</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.FBNetworkImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getFBNetwork()
		 * @generated
		 */
		EClass FB_NETWORK = eINSTANCE.getFBNetwork();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FB_NETWORK__MIXED = eINSTANCE.getFBNetwork_Mixed();

		/**
		 * The meta object literal for the '<em><b>FB</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_NETWORK__FB = eINSTANCE.getFBNetwork_FB();

		/**
		 * The meta object literal for the '<em><b>Event Connections</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_NETWORK__EVENT_CONNECTIONS = eINSTANCE.getFBNetwork_EventConnections();

		/**
		 * The meta object literal for the '<em><b>Data Connections</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_NETWORK__DATA_CONNECTIONS = eINSTANCE.getFBNetwork_DataConnections();

		/**
		 * The meta object literal for the '<em><b>Adapter Connections</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_NETWORK__ADAPTER_CONNECTIONS = eINSTANCE.getFBNetwork_AdapterConnections();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.FBImpl <em>FB</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.FBImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getFB()
		 * @generated
		 */
		EClass FB = eINSTANCE.getFB();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB__PARAMETER = eINSTANCE.getFB_Parameter();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FB__COMMENT = eINSTANCE.getFB_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FB__NAME = eINSTANCE.getFB_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FB__TYPE = eINSTANCE.getFB_Type();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FB__X = eINSTANCE.getFB_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FB__Y = eINSTANCE.getFB_Y();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.FBTypeNameImpl <em>FB Type Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.FBTypeNameImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getFBTypeName()
		 * @generated
		 */
		EClass FB_TYPE_NAME = eINSTANCE.getFBTypeName();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FB_TYPE_NAME__NAME = eINSTANCE.getFBTypeName_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.FBTypeImpl <em>FB Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.FBTypeImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getFBType()
		 * @generated
		 */
		EClass FB_TYPE = eINSTANCE.getFBType();

		/**
		 * The meta object literal for the '<em><b>Identification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_TYPE__IDENTIFICATION = eINSTANCE.getFBType_Identification();

		/**
		 * The meta object literal for the '<em><b>Version Info</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_TYPE__VERSION_INFO = eINSTANCE.getFBType_VersionInfo();

		/**
		 * The meta object literal for the '<em><b>Compiler Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_TYPE__COMPILER_INFO = eINSTANCE.getFBType_CompilerInfo();

		/**
		 * The meta object literal for the '<em><b>Interface List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_TYPE__INTERFACE_LIST = eINSTANCE.getFBType_InterfaceList();

		/**
		 * The meta object literal for the '<em><b>Basic FB</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_TYPE__BASIC_FB = eINSTANCE.getFBType_BasicFB();

		/**
		 * The meta object literal for the '<em><b>FB Network</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_TYPE__FB_NETWORK = eINSTANCE.getFBType_FBNetwork();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_TYPE__SERVICE = eINSTANCE.getFBType_Service();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FB_TYPE__COMMENT = eINSTANCE.getFBType_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FB_TYPE__NAME = eINSTANCE.getFBType_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.HCECCRelationImpl <em>HCECC Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.HCECCRelationImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getHCECCRelation()
		 * @generated
		 */
		EClass HCECC_RELATION = eINSTANCE.getHCECCRelation();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HCECC_RELATION__COMMENT = eINSTANCE.getHCECCRelation_Comment();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HCECC_RELATION__DESTINATION = eINSTANCE.getHCECCRelation_Destination();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HCECC_RELATION__RELATION = eINSTANCE.getHCECCRelation_Relation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HCECC_RELATION__SOURCE = eINSTANCE.getHCECCRelation_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.HCECCImpl <em>HCECC</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.HCECCImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getHCECC()
		 * @generated
		 */
		EClass HCECC = eINSTANCE.getHCECC();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HCECC__GROUP = eINSTANCE.getHCECC_Group();

		/**
		 * The meta object literal for the '<em><b>ECC</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HCECC__ECC = eINSTANCE.getHCECC_ECC();

		/**
		 * The meta object literal for the '<em><b>HCECC Relation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HCECC__HCECC_RELATION = eINSTANCE.getHCECC_HCECCRelation();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.IdentificationImpl <em>Identification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.IdentificationImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getIdentification()
		 * @generated
		 */
		EClass IDENTIFICATION = eINSTANCE.getIdentification();

		/**
		 * The meta object literal for the '<em><b>Application Domain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFICATION__APPLICATION_DOMAIN = eINSTANCE.getIdentification_ApplicationDomain();

		/**
		 * The meta object literal for the '<em><b>Classification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFICATION__CLASSIFICATION = eINSTANCE.getIdentification_Classification();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFICATION__DESCRIPTION = eINSTANCE.getIdentification_Description();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFICATION__FUNCTION = eINSTANCE.getIdentification_Function();

		/**
		 * The meta object literal for the '<em><b>Standard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFICATION__STANDARD = eINSTANCE.getIdentification_Standard();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFICATION__TYPE = eINSTANCE.getIdentification_Type();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.InputPrimitiveImpl <em>Input Primitive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.InputPrimitiveImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getInputPrimitive()
		 * @generated
		 */
		EClass INPUT_PRIMITIVE = eINSTANCE.getInputPrimitive();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_PRIMITIVE__EVENT = eINSTANCE.getInputPrimitive_Event();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_PRIMITIVE__INTERFACE = eINSTANCE.getInputPrimitive_Interface();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_PRIMITIVE__PARAMETERS = eINSTANCE.getInputPrimitive_Parameters();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.InputVarsImpl <em>Input Vars</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.InputVarsImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getInputVars()
		 * @generated
		 */
		EClass INPUT_VARS = eINSTANCE.getInputVars();

		/**
		 * The meta object literal for the '<em><b>Var Declaration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_VARS__VAR_DECLARATION = eINSTANCE.getInputVars_VarDeclaration();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.InterfaceListImpl <em>Interface List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.InterfaceListImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getInterfaceList()
		 * @generated
		 */
		EClass INTERFACE_LIST = eINSTANCE.getInterfaceList();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_LIST__MIXED = eINSTANCE.getInterfaceList_Mixed();

		/**
		 * The meta object literal for the '<em><b>Event Inputs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_LIST__EVENT_INPUTS = eINSTANCE.getInterfaceList_EventInputs();

		/**
		 * The meta object literal for the '<em><b>Event Outputs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_LIST__EVENT_OUTPUTS = eINSTANCE.getInterfaceList_EventOutputs();

		/**
		 * The meta object literal for the '<em><b>Input Vars</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_LIST__INPUT_VARS = eINSTANCE.getInterfaceList_InputVars();

		/**
		 * The meta object literal for the '<em><b>Output Vars</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_LIST__OUTPUT_VARS = eINSTANCE.getInterfaceList_OutputVars();

		/**
		 * The meta object literal for the '<em><b>Sockets</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_LIST__SOCKETS = eINSTANCE.getInterfaceList_Sockets();

		/**
		 * The meta object literal for the '<em><b>Plugs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_LIST__PLUGS = eINSTANCE.getInterfaceList_Plugs();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.InternalVarsImpl <em>Internal Vars</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.InternalVarsImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getInternalVars()
		 * @generated
		 */
		EClass INTERNAL_VARS = eINSTANCE.getInternalVars();

		/**
		 * The meta object literal for the '<em><b>Var Declaration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_VARS__VAR_DECLARATION = eINSTANCE.getInternalVars_VarDeclaration();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.LDImpl <em>LD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.LDImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getLD()
		 * @generated
		 */
		EClass LD = eINSTANCE.getLD();

		/**
		 * The meta object literal for the '<em><b>Rung</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LD__RUNG = eINSTANCE.getLD_Rung();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.LinkImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__PARAMETER = eINSTANCE.getLink_Parameter();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__COMMENT = eINSTANCE.getLink_Comment();

		/**
		 * The meta object literal for the '<em><b>Comm Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__COMM_RESOURCE = eINSTANCE.getLink_CommResource();

		/**
		 * The meta object literal for the '<em><b>Segment Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__SEGMENT_NAME = eINSTANCE.getLink_SegmentName();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.MappingImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING__FROM = eINSTANCE.getMapping_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING__TO = eINSTANCE.getMapping_To();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.OtherImpl <em>Other</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.OtherImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getOther()
		 * @generated
		 */
		EClass OTHER = eINSTANCE.getOther();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OTHER__LANGUAGE = eINSTANCE.getOther_Language();

		/**
		 * The meta object literal for the '<em><b>Prototype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OTHER__PROTOTYPE = eINSTANCE.getOther_Prototype();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OTHER__TEXT = eINSTANCE.getOther_Text();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.OutputPrimitiveImpl <em>Output Primitive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.OutputPrimitiveImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getOutputPrimitive()
		 * @generated
		 */
		EClass OUTPUT_PRIMITIVE = eINSTANCE.getOutputPrimitive();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT_PRIMITIVE__EVENT = eINSTANCE.getOutputPrimitive_Event();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT_PRIMITIVE__INTERFACE = eINSTANCE.getOutputPrimitive_Interface();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT_PRIMITIVE__PARAMETERS = eINSTANCE.getOutputPrimitive_Parameters();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.OutputVarsImpl <em>Output Vars</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.OutputVarsImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getOutputVars()
		 * @generated
		 */
		EClass OUTPUT_VARS = eINSTANCE.getOutputVars();

		/**
		 * The meta object literal for the '<em><b>Var Declaration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_VARS__VAR_DECLARATION = eINSTANCE.getOutputVars_VarDeclaration();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.ParameterImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__COMMENT = eINSTANCE.getParameter_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__VALUE = eINSTANCE.getParameter_Value();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.PlugsImpl <em>Plugs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.PlugsImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getPlugs()
		 * @generated
		 */
		EClass PLUGS = eINSTANCE.getPlugs();

		/**
		 * The meta object literal for the '<em><b>Adapter Declaration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUGS__ADAPTER_DECLARATION = eINSTANCE.getPlugs_AdapterDeclaration();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.ResourceImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__PARAMETER = eINSTANCE.getResource_Parameter();

		/**
		 * The meta object literal for the '<em><b>FB Network</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__FB_NETWORK = eINSTANCE.getResource_FBNetwork();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__COMMENT = eINSTANCE.getResource_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__NAME = eINSTANCE.getResource_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__TYPE = eINSTANCE.getResource_Type();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__X = eINSTANCE.getResource_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__Y = eINSTANCE.getResource_Y();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.ResourceTypeNameImpl <em>Resource Type Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.ResourceTypeNameImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getResourceTypeName()
		 * @generated
		 */
		EClass RESOURCE_TYPE_NAME = eINSTANCE.getResourceTypeName();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE_NAME__NAME = eINSTANCE.getResourceTypeName_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.ResourceTypeImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getResourceType()
		 * @generated
		 */
		EClass RESOURCE_TYPE = eINSTANCE.getResourceType();

		/**
		 * The meta object literal for the '<em><b>Identification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE__IDENTIFICATION = eINSTANCE.getResourceType_Identification();

		/**
		 * The meta object literal for the '<em><b>Version Info</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE__VERSION_INFO = eINSTANCE.getResourceType_VersionInfo();

		/**
		 * The meta object literal for the '<em><b>Compiler Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE__COMPILER_INFO = eINSTANCE.getResourceType_CompilerInfo();

		/**
		 * The meta object literal for the '<em><b>FB Type Name</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE__FB_TYPE_NAME = eINSTANCE.getResourceType_FBTypeName();

		/**
		 * The meta object literal for the '<em><b>Var Declaration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE__VAR_DECLARATION = eINSTANCE.getResourceType_VarDeclaration();

		/**
		 * The meta object literal for the '<em><b>FB Network</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE__FB_NETWORK = eINSTANCE.getResourceType_FBNetwork();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__COMMENT = eINSTANCE.getResourceType_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__NAME = eINSTANCE.getResourceType_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.RungImpl <em>Rung</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.RungImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getRung()
		 * @generated
		 */
		EClass RUNG = eINSTANCE.getRung();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNG__COMMENT = eINSTANCE.getRung_Comment();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNG__EXPRESSION = eINSTANCE.getRung_Expression();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNG__OUTPUT = eINSTANCE.getRung_Output();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.SegmentImpl <em>Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.SegmentImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSegment()
		 * @generated
		 */
		EClass SEGMENT = eINSTANCE.getSegment();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEGMENT__PARAMETER = eINSTANCE.getSegment_Parameter();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__COMMENT = eINSTANCE.getSegment_Comment();

		/**
		 * The meta object literal for the '<em><b>Dx1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__DX1 = eINSTANCE.getSegment_Dx1();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__NAME = eINSTANCE.getSegment_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__TYPE = eINSTANCE.getSegment_Type();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__X = eINSTANCE.getSegment_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__Y = eINSTANCE.getSegment_Y();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.ServiceSequenceImpl <em>Service Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.ServiceSequenceImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getServiceSequence()
		 * @generated
		 */
		EClass SERVICE_SEQUENCE = eINSTANCE.getServiceSequence();

		/**
		 * The meta object literal for the '<em><b>Service Transaction</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_SEQUENCE__SERVICE_TRANSACTION = eINSTANCE.getServiceSequence_ServiceTransaction();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_SEQUENCE__COMMENT = eINSTANCE.getServiceSequence_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_SEQUENCE__NAME = eINSTANCE.getServiceSequence_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.ServiceTransactionImpl <em>Service Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.ServiceTransactionImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getServiceTransaction()
		 * @generated
		 */
		EClass SERVICE_TRANSACTION = eINSTANCE.getServiceTransaction();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_TRANSACTION__MIXED = eINSTANCE.getServiceTransaction_Mixed();

		/**
		 * The meta object literal for the '<em><b>Input Primitive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_TRANSACTION__INPUT_PRIMITIVE = eINSTANCE.getServiceTransaction_InputPrimitive();

		/**
		 * The meta object literal for the '<em><b>Output Primitive</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_TRANSACTION__OUTPUT_PRIMITIVE = eINSTANCE.getServiceTransaction_OutputPrimitive();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.ServiceImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Service Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__SERVICE_SEQUENCE = eINSTANCE.getService_ServiceSequence();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__COMMENT = eINSTANCE.getService_Comment();

		/**
		 * The meta object literal for the '<em><b>Left Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__LEFT_INTERFACE = eINSTANCE.getService_LeftInterface();

		/**
		 * The meta object literal for the '<em><b>Right Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__RIGHT_INTERFACE = eINSTANCE.getService_RightInterface();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.SocketsImpl <em>Sockets</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.SocketsImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSockets()
		 * @generated
		 */
		EClass SOCKETS = eINSTANCE.getSockets();

		/**
		 * The meta object literal for the '<em><b>Adapter Declaration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOCKETS__ADAPTER_DECLARATION = eINSTANCE.getSockets_AdapterDeclaration();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.STImpl <em>ST</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.STImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getST()
		 * @generated
		 */
		EClass ST = eINSTANCE.getST();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ST__TEXT = eINSTANCE.getST_Text();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.SubAppEventInputsImpl <em>Sub App Event Inputs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.SubAppEventInputsImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSubAppEventInputs()
		 * @generated
		 */
		EClass SUB_APP_EVENT_INPUTS = eINSTANCE.getSubAppEventInputs();

		/**
		 * The meta object literal for the '<em><b>Sub App Event</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_APP_EVENT_INPUTS__SUB_APP_EVENT = eINSTANCE.getSubAppEventInputs_SubAppEvent();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.SubAppEventOutputsImpl <em>Sub App Event Outputs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.SubAppEventOutputsImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSubAppEventOutputs()
		 * @generated
		 */
		EClass SUB_APP_EVENT_OUTPUTS = eINSTANCE.getSubAppEventOutputs();

		/**
		 * The meta object literal for the '<em><b>Sub App Event</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_APP_EVENT_OUTPUTS__SUB_APP_EVENT = eINSTANCE.getSubAppEventOutputs_SubAppEvent();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.SubAppEventImpl <em>Sub App Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.SubAppEventImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSubAppEvent()
		 * @generated
		 */
		EClass SUB_APP_EVENT = eINSTANCE.getSubAppEvent();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_APP_EVENT__COMMENT = eINSTANCE.getSubAppEvent_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_APP_EVENT__NAME = eINSTANCE.getSubAppEvent_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_APP_EVENT__TYPE = eINSTANCE.getSubAppEvent_Type();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.SubAppInterfaceListImpl <em>Sub App Interface List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.SubAppInterfaceListImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSubAppInterfaceList()
		 * @generated
		 */
		EClass SUB_APP_INTERFACE_LIST = eINSTANCE.getSubAppInterfaceList();

		/**
		 * The meta object literal for the '<em><b>Sub App Event Inputs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_INPUTS = eINSTANCE.getSubAppInterfaceList_SubAppEventInputs();

		/**
		 * The meta object literal for the '<em><b>Sub App Event Outputs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_OUTPUTS = eINSTANCE.getSubAppInterfaceList_SubAppEventOutputs();

		/**
		 * The meta object literal for the '<em><b>Input Vars</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_APP_INTERFACE_LIST__INPUT_VARS = eINSTANCE.getSubAppInterfaceList_InputVars();

		/**
		 * The meta object literal for the '<em><b>Output Vars</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_APP_INTERFACE_LIST__OUTPUT_VARS = eINSTANCE.getSubAppInterfaceList_OutputVars();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.SubAppNetworkImpl <em>Sub App Network</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.SubAppNetworkImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSubAppNetwork()
		 * @generated
		 */
		EClass SUB_APP_NETWORK = eINSTANCE.getSubAppNetwork();

		/**
		 * The meta object literal for the '<em><b>Sub App</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_APP_NETWORK__SUB_APP = eINSTANCE.getSubAppNetwork_SubApp();

		/**
		 * The meta object literal for the '<em><b>FB</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_APP_NETWORK__FB = eINSTANCE.getSubAppNetwork_FB();

		/**
		 * The meta object literal for the '<em><b>Event Connections</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_APP_NETWORK__EVENT_CONNECTIONS = eINSTANCE.getSubAppNetwork_EventConnections();

		/**
		 * The meta object literal for the '<em><b>Data Connections</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_APP_NETWORK__DATA_CONNECTIONS = eINSTANCE.getSubAppNetwork_DataConnections();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.SubAppImpl <em>Sub App</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.SubAppImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSubApp()
		 * @generated
		 */
		EClass SUB_APP = eINSTANCE.getSubApp();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_APP__COMMENT = eINSTANCE.getSubApp_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_APP__NAME = eINSTANCE.getSubApp_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_APP__TYPE = eINSTANCE.getSubApp_Type();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_APP__X = eINSTANCE.getSubApp_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_APP__Y = eINSTANCE.getSubApp_Y();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.SubAppTypeImpl <em>Sub App Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.SubAppTypeImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSubAppType()
		 * @generated
		 */
		EClass SUB_APP_TYPE = eINSTANCE.getSubAppType();

		/**
		 * The meta object literal for the '<em><b>Identification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_APP_TYPE__IDENTIFICATION = eINSTANCE.getSubAppType_Identification();

		/**
		 * The meta object literal for the '<em><b>Version Info</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_APP_TYPE__VERSION_INFO = eINSTANCE.getSubAppType_VersionInfo();

		/**
		 * The meta object literal for the '<em><b>Compiler Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_APP_TYPE__COMPILER_INFO = eINSTANCE.getSubAppType_CompilerInfo();

		/**
		 * The meta object literal for the '<em><b>Sub App Interface List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_APP_TYPE__SUB_APP_INTERFACE_LIST = eINSTANCE.getSubAppType_SubAppInterfaceList();

		/**
		 * The meta object literal for the '<em><b>Sub App Network</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_APP_TYPE__SUB_APP_NETWORK = eINSTANCE.getSubAppType_SubAppNetwork();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_APP_TYPE__COMMENT = eINSTANCE.getSubAppType_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_APP_TYPE__NAME = eINSTANCE.getSubAppType_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.SystemImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Identification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__IDENTIFICATION = eINSTANCE.getSystem_Identification();

		/**
		 * The meta object literal for the '<em><b>Version Info</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__VERSION_INFO = eINSTANCE.getSystem_VersionInfo();

		/**
		 * The meta object literal for the '<em><b>Application</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__APPLICATION = eINSTANCE.getSystem_Application();

		/**
		 * The meta object literal for the '<em><b>Device</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__DEVICE = eINSTANCE.getSystem_Device();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__MAPPING = eINSTANCE.getSystem_Mapping();

		/**
		 * The meta object literal for the '<em><b>Segment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__SEGMENT = eINSTANCE.getSystem_Segment();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__LINK = eINSTANCE.getSystem_Link();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__COMMENT = eINSTANCE.getSystem_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__NAME = eINSTANCE.getSystem_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.VarDeclarationImpl <em>Var Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.VarDeclarationImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getVarDeclaration()
		 * @generated
		 */
		EClass VAR_DECLARATION = eINSTANCE.getVarDeclaration();

		/**
		 * The meta object literal for the '<em><b>Array Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_DECLARATION__ARRAY_SIZE = eINSTANCE.getVarDeclaration_ArraySize();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_DECLARATION__COMMENT = eINSTANCE.getVarDeclaration_Comment();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_DECLARATION__INITIAL_VALUE = eINSTANCE.getVarDeclaration_InitialValue();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_DECLARATION__NAME = eINSTANCE.getVarDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_DECLARATION__TYPE = eINSTANCE.getVarDeclaration_Type();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.VersionInfoImpl <em>Version Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.VersionInfoImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getVersionInfo()
		 * @generated
		 */
		EClass VERSION_INFO = eINSTANCE.getVersionInfo();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION_INFO__AUTHOR = eINSTANCE.getVersionInfo_Author();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION_INFO__DATE = eINSTANCE.getVersionInfo_Date();

		/**
		 * The meta object literal for the '<em><b>Organization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION_INFO__ORGANIZATION = eINSTANCE.getVersionInfo_Organization();

		/**
		 * The meta object literal for the '<em><b>Remarks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION_INFO__REMARKS = eINSTANCE.getVersionInfo_Remarks();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION_INFO__VERSION = eINSTANCE.getVersionInfo_Version();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.impl.WithImpl <em>With</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.impl.WithImpl
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getWith()
		 * @generated
		 */
		EClass WITH = eINSTANCE.getWith();

		/**
		 * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WITH__VAR = eINSTANCE.getWith_Var();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.functionblock.Language <em>Language</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.Language
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getLanguage()
		 * @generated
		 */
		EEnum LANGUAGE = eINSTANCE.getLanguage();

		/**
		 * The meta object literal for the '<em>Language Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.functionblock.Language
		 * @see de.cau.cs.kieler.functionblock.impl.FunctionblockPackageImpl#getLanguageObject()
		 * @generated
		 */
		EDataType LANGUAGE_OBJECT = eINSTANCE.getLanguageObject();

	}

} //FunctionblockPackage
