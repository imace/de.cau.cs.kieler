/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see de.cau.cs.kieler.cakefeed.CakefeedFactory
 * @model kind="package"
 * @generated
 */
public interface CakefeedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cakefeed";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://kieler.cs.cau.de/cakefeed/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cakefeed";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CakefeedPackage eINSTANCE = de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.SystemImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 0;

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
	 * The feature id for the '<em><b>Mapping</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__MAPPING = 4;

	/**
	 * The feature id for the '<em><b>Segment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__SEGMENT = 5;

	/**
	 * The feature id for the '<em><b>Link</b></em>' reference list.
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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.IdentificationImpl <em>Identification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.IdentificationImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIdentification()
	 * @generated
	 */
	int IDENTIFICATION = 1;

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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.VersionInfoImpl <em>Version Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.VersionInfoImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getVersionInfo()
	 * @generated
	 */
	int VERSION_INFO = 2;

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
	 * The feature id for the '<em><b>Organisation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_INFO__ORGANISATION = 2;

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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.ApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.ApplicationImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getApplication()
	 * @generated
	 */
	int APPLICATION = 3;

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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBNetworkImpl <em>FB Network</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBNetworkImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBNetwork()
	 * @generated
	 */
	int FB_NETWORK = 4;

	/**
	 * The feature id for the '<em><b>FB</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_NETWORK__FB = 0;

	/**
	 * The feature id for the '<em><b>Event Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_NETWORK__EVENT_CONNECTIONS = 1;

	/**
	 * The feature id for the '<em><b>Data Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_NETWORK__DATA_CONNECTIONS = 2;

	/**
	 * The feature id for the '<em><b>Adapter Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_NETWORK__ADAPTER_CONNECTIONS = 3;

	/**
	 * The number of structural features of the '<em>FB Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_NETWORK_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.DeviceImpl <em>Device</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.DeviceImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getDevice()
	 * @generated
	 */
	int DEVICE = 5;

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
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__COMMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__NAME = 5;

	/**
	 * The number of structural features of the '<em>Device</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.MappingImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 6;

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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.SegmentImpl <em>Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.SegmentImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getSegment()
	 * @generated
	 */
	int SEGMENT = 7;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__COMMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__NAME = 3;

	/**
	 * The number of structural features of the '<em>Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.LinkImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 8;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBImpl <em>FB</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFB()
	 * @generated
	 */
	int FB = 9;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__COMMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__NAME = 3;

	/**
	 * The number of structural features of the '<em>FB</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.ParameterImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 2;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.ResourceImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 11;

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
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__COMMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = 4;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBTypeImpl <em>FB Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBTypeImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBType()
	 * @generated
	 */
	int FB_TYPE = 12;

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
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__COMMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__NAME = 4;

	/**
	 * The feature id for the '<em><b>Input Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__INPUT_EVENTS = 5;

	/**
	 * The feature id for the '<em><b>Output Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__OUTPUT_EVENTS = 6;

	/**
	 * The feature id for the '<em><b>Input Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__INPUT_VARS = 7;

	/**
	 * The feature id for the '<em><b>Output Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__OUTPUT_VARS = 8;

	/**
	 * The feature id for the '<em><b>Sockets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__SOCKETS = 9;

	/**
	 * The feature id for the '<em><b>Plugs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__PLUGS = 10;

	/**
	 * The number of structural features of the '<em>FB Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.ConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 13;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__COMMENT = 0;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.CompilerInfoImpl <em>Compiler Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.CompilerInfoImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getCompilerInfo()
	 * @generated
	 */
	int COMPILER_INFO = 14;

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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.EventConnectionImpl <em>Event Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.EventConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getEventConnection()
	 * @generated
	 */
	int EVENT_CONNECTION = 15;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONNECTION__COMMENT = CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONNECTION__DESTINATION = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONNECTION__SOURCE = CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Event Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONNECTION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.DataConnectionImpl <em>Data Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.DataConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getDataConnection()
	 * @generated
	 */
	int DATA_CONNECTION = 16;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONNECTION__COMMENT = CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONNECTION__DESTINATION = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONNECTION__SOURCE = CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONNECTION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.AdapterConnectionImpl <em>Adapter Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.AdapterConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getAdapterConnection()
	 * @generated
	 */
	int ADAPTER_CONNECTION = 17;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_CONNECTION__COMMENT = CONNECTION__COMMENT;

	/**
	 * The number of structural features of the '<em>Adapter Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_CONNECTION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.EventImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 18;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.InputEventImpl <em>Input Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.InputEventImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getInputEvent()
	 * @generated
	 */
	int INPUT_EVENT = 19;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_EVENT__TYPE = EVENT__TYPE;

	/**
	 * The feature id for the '<em><b>With</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_EVENT__WITH = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.OutputEventImpl <em>Output Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.OutputEventImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getOutputEvent()
	 * @generated
	 */
	int OUTPUT_EVENT = 20;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_EVENT__TYPE = EVENT__TYPE;

	/**
	 * The feature id for the '<em><b>With</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_EVENT__WITH = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Output Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.VarImpl <em>Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.VarImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getVar()
	 * @generated
	 */
	int VAR = 21;

	/**
	 * The feature id for the '<em><b>Array Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__ARRAY_SIZE = 0;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__INITIAL_VALUE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__COMMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__NAME = 4;

	/**
	 * The number of structural features of the '<em>Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.InputVarImpl <em>Input Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.InputVarImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getInputVar()
	 * @generated
	 */
	int INPUT_VAR = 22;

	/**
	 * The feature id for the '<em><b>Array Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VAR__ARRAY_SIZE = VAR__ARRAY_SIZE;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VAR__INITIAL_VALUE = VAR__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VAR__TYPE = VAR__TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VAR__COMMENT = VAR__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VAR__NAME = VAR__NAME;

	/**
	 * The number of structural features of the '<em>Input Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VAR_FEATURE_COUNT = VAR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.OutputVarImpl <em>Output Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.OutputVarImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getOutputVar()
	 * @generated
	 */
	int OUTPUT_VAR = 23;

	/**
	 * The feature id for the '<em><b>Array Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VAR__ARRAY_SIZE = VAR__ARRAY_SIZE;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VAR__INITIAL_VALUE = VAR__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VAR__TYPE = VAR__TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VAR__COMMENT = VAR__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VAR__NAME = VAR__NAME;

	/**
	 * The number of structural features of the '<em>Output Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VAR_FEATURE_COUNT = VAR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.InternalVarImpl <em>Internal Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.InternalVarImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getInternalVar()
	 * @generated
	 */
	int INTERNAL_VAR = 24;

	/**
	 * The feature id for the '<em><b>Array Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_VAR__ARRAY_SIZE = VAR__ARRAY_SIZE;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_VAR__INITIAL_VALUE = VAR__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_VAR__TYPE = VAR__TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_VAR__COMMENT = VAR__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_VAR__NAME = VAR__NAME;

	/**
	 * The number of structural features of the '<em>Internal Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_VAR_FEATURE_COUNT = VAR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.CompilerImpl <em>Compiler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.CompilerImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getCompiler()
	 * @generated
	 */
	int COMPILER = 25;

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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.WithImpl <em>With</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.WithImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getWith()
	 * @generated
	 */
	int WITH = 26;

	/**
	 * The number of structural features of the '<em>With</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.InputWithImpl <em>Input With</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.InputWithImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getInputWith()
	 * @generated
	 */
	int INPUT_WITH = 27;

	/**
	 * The feature id for the '<em><b>Parent Input Event</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_WITH__PARENT_INPUT_EVENT = WITH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>With</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_WITH__WITH = WITH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Input With</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_WITH_FEATURE_COUNT = WITH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.OutputWithImpl <em>Output With</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.OutputWithImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getOutputWith()
	 * @generated
	 */
	int OUTPUT_WITH = 28;

	/**
	 * The feature id for the '<em><b>Parent Output Event</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_WITH__PARENT_OUTPUT_EVENT = WITH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>With</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_WITH__WITH = WITH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Output With</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_WITH_FEATURE_COUNT = WITH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.AdapterImpl <em>Adapter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.AdapterImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getAdapter()
	 * @generated
	 */
	int ADAPTER = 29;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__COMMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__NAME = 3;

	/**
	 * The number of structural features of the '<em>Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.SocketImpl <em>Socket</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.SocketImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getSocket()
	 * @generated
	 */
	int SOCKET = 30;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKET__PARAMETER = ADAPTER__PARAMETER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKET__TYPE = ADAPTER__TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKET__COMMENT = ADAPTER__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKET__NAME = ADAPTER__NAME;

	/**
	 * The number of structural features of the '<em>Socket</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKET_FEATURE_COUNT = ADAPTER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.PlugImpl <em>Plug</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.PlugImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getPlug()
	 * @generated
	 */
	int PLUG = 31;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUG__PARAMETER = ADAPTER__PARAMETER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUG__TYPE = ADAPTER__TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUG__COMMENT = ADAPTER__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUG__NAME = ADAPTER__NAME;

	/**
	 * The number of structural features of the '<em>Plug</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUG_FEATURE_COUNT = ADAPTER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.AdapterTypeImpl <em>Adapter Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.AdapterTypeImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getAdapterType()
	 * @generated
	 */
	int ADAPTER_TYPE = 32;

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
	 * The feature id for the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__SERVICE = 3;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__COMMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__NAME = 5;

	/**
	 * The feature id for the '<em><b>Input Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__INPUT_EVENTS = 6;

	/**
	 * The feature id for the '<em><b>Output Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__OUTPUT_EVENTS = 7;

	/**
	 * The feature id for the '<em><b>Input Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__INPUT_VARS = 8;

	/**
	 * The feature id for the '<em><b>Output Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__OUTPUT_VARS = 9;

	/**
	 * The feature id for the '<em><b>Sockets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__SOCKETS = 10;

	/**
	 * The feature id for the '<em><b>Plugs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__PLUGS = 11;

	/**
	 * The number of structural features of the '<em>Adapter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.ServiceImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 33;

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
	 * The feature id for the '<em><b>Right Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__RIGHT_INTERFACE = 2;

	/**
	 * The feature id for the '<em><b>Left Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__LEFT_INTERFACE = 3;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.ServiceSequenceImpl <em>Service Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.ServiceSequenceImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getServiceSequence()
	 * @generated
	 */
	int SERVICE_SEQUENCE = 34;

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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.ServiceTransactionImpl <em>Service Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.ServiceTransactionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getServiceTransaction()
	 * @generated
	 */
	int SERVICE_TRANSACTION = 35;

	/**
	 * The feature id for the '<em><b>Input Primitive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TRANSACTION__INPUT_PRIMITIVE = 0;

	/**
	 * The feature id for the '<em><b>Output Primitive</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TRANSACTION__OUTPUT_PRIMITIVE = 1;

	/**
	 * The number of structural features of the '<em>Service Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TRANSACTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.PrimitiveImpl <em>Primitive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.PrimitiveImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getPrimitive()
	 * @generated
	 */
	int PRIMITIVE = 36;

	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE__EVENT = 0;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE__INTERFACE = 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE__PARAMETERS = 2;

	/**
	 * The number of structural features of the '<em>Primitive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.InputPrimitiveImpl <em>Input Primitive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.InputPrimitiveImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getInputPrimitive()
	 * @generated
	 */
	int INPUT_PRIMITIVE = 37;

	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PRIMITIVE__EVENT = PRIMITIVE__EVENT;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PRIMITIVE__INTERFACE = PRIMITIVE__INTERFACE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PRIMITIVE__PARAMETERS = PRIMITIVE__PARAMETERS;

	/**
	 * The number of structural features of the '<em>Input Primitive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PRIMITIVE_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.OutputPrimitiveImpl <em>Output Primitive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.OutputPrimitiveImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getOutputPrimitive()
	 * @generated
	 */
	int OUTPUT_PRIMITIVE = 38;

	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRIMITIVE__EVENT = PRIMITIVE__EVENT;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRIMITIVE__INTERFACE = PRIMITIVE__INTERFACE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRIMITIVE__PARAMETERS = PRIMITIVE__PARAMETERS;

	/**
	 * The number of structural features of the '<em>Output Primitive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRIMITIVE_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.BFBTypeImpl <em>BFB Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.BFBTypeImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getBFBType()
	 * @generated
	 */
	int BFB_TYPE = 39;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__IDENTIFICATION = FB_TYPE__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Version Info</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__VERSION_INFO = FB_TYPE__VERSION_INFO;

	/**
	 * The feature id for the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__COMPILER_INFO = FB_TYPE__COMPILER_INFO;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__COMMENT = FB_TYPE__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__NAME = FB_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Input Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__INPUT_EVENTS = FB_TYPE__INPUT_EVENTS;

	/**
	 * The feature id for the '<em><b>Output Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__OUTPUT_EVENTS = FB_TYPE__OUTPUT_EVENTS;

	/**
	 * The feature id for the '<em><b>Input Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__INPUT_VARS = FB_TYPE__INPUT_VARS;

	/**
	 * The feature id for the '<em><b>Output Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__OUTPUT_VARS = FB_TYPE__OUTPUT_VARS;

	/**
	 * The feature id for the '<em><b>Sockets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__SOCKETS = FB_TYPE__SOCKETS;

	/**
	 * The feature id for the '<em><b>Plugs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__PLUGS = FB_TYPE__PLUGS;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__SERVICE = FB_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sync Chart</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__SYNC_CHART = FB_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Internal Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__INTERNAL_VARS = FB_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>FB Ds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__FB_DS = FB_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>STs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__STS = FB_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>LDs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__LDS = FB_TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Other Algorithms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__OTHER_ALGORITHMS = FB_TYPE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>BFB Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE_FEATURE_COUNT = FB_TYPE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBDImpl <em>FBD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBDImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBD()
	 * @generated
	 */
	int FBD = 40;

	/**
	 * The feature id for the '<em><b>FB</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBD__FB = 0;

	/**
	 * The feature id for the '<em><b>Data Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBD__DATA_CONNECTIONS = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBD__COMMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBD__NAME = 3;

	/**
	 * The number of structural features of the '<em>FBD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBD_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.STImpl <em>ST</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.STImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getST()
	 * @generated
	 */
	int ST = 41;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ST__TEXT = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ST__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ST__NAME = 2;

	/**
	 * The number of structural features of the '<em>ST</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ST_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.LDImpl <em>LD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.LDImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getLD()
	 * @generated
	 */
	int LD = 42;

	/**
	 * The feature id for the '<em><b>Rung</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LD__RUNG = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LD__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LD__NAME = 2;

	/**
	 * The number of structural features of the '<em>LD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LD_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.OtherImpl <em>Other</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.OtherImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getOther()
	 * @generated
	 */
	int OTHER = 43;

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
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER__COMMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER__NAME = 4;

	/**
	 * The number of structural features of the '<em>Other</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.RungImpl <em>Rung</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.RungImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getRung()
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
	 * The feature id for the '<em><b>Output</b></em>' reference.
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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.CFBTypeImpl <em>CFB Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.CFBTypeImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getCFBType()
	 * @generated
	 */
	int CFB_TYPE = 45;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__IDENTIFICATION = FB_TYPE__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Version Info</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__VERSION_INFO = FB_TYPE__VERSION_INFO;

	/**
	 * The feature id for the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__COMPILER_INFO = FB_TYPE__COMPILER_INFO;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__COMMENT = FB_TYPE__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__NAME = FB_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Input Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__INPUT_EVENTS = FB_TYPE__INPUT_EVENTS;

	/**
	 * The feature id for the '<em><b>Output Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__OUTPUT_EVENTS = FB_TYPE__OUTPUT_EVENTS;

	/**
	 * The feature id for the '<em><b>Input Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__INPUT_VARS = FB_TYPE__INPUT_VARS;

	/**
	 * The feature id for the '<em><b>Output Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__OUTPUT_VARS = FB_TYPE__OUTPUT_VARS;

	/**
	 * The feature id for the '<em><b>Sockets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__SOCKETS = FB_TYPE__SOCKETS;

	/**
	 * The feature id for the '<em><b>Plugs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__PLUGS = FB_TYPE__PLUGS;

	/**
	 * The feature id for the '<em><b>FB Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__FB_NETWORK = FB_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__SERVICE = FB_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CFB Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE_FEATURE_COUNT = FB_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.DeviceTypeImpl <em>Device Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.DeviceTypeImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getDeviceType()
	 * @generated
	 */
	int DEVICE_TYPE = 46;

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
	 * The feature id for the '<em><b>Var Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__VAR_DECLARATIONS = 3;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__RESOURCES = 4;

	/**
	 * The feature id for the '<em><b>FB Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__FB_NETWORK = 5;

	/**
	 * The feature id for the '<em><b>Resource Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__RESOURCE_NAMES = 6;

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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.ResourceTypeImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getResourceType()
	 * @generated
	 */
	int RESOURCE_TYPE = 47;

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
	 * The feature id for the '<em><b>Var Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__VAR_DECLARATIONS = 3;

	/**
	 * The feature id for the '<em><b>FB Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__FB_NETWORK = 4;

	/**
	 * The feature id for the '<em><b>FB Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__FB_NAMES = 5;

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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.BFBDiagramImpl <em>BFB Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.BFBDiagramImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getBFBDiagram()
	 * @generated
	 */
	int BFB_DIAGRAM = 48;

	/**
	 * The feature id for the '<em><b>BFB Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_DIAGRAM__BFB_TYPE = 0;

	/**
	 * The number of structural features of the '<em>BFB Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_DIAGRAM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.CFBDiagramImpl <em>CFB Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.CFBDiagramImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getCFBDiagram()
	 * @generated
	 */
	int CFB_DIAGRAM = 49;

	/**
	 * The feature id for the '<em><b>CFB Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_DIAGRAM__CFB_TYPE = 0;

	/**
	 * The number of structural features of the '<em>CFB Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_DIAGRAM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.SegmentType <em>Segment Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.SegmentType
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getSegmentType()
	 * @generated
	 */
	int SEGMENT_TYPE = 50;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.Language <em>Language</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.Language
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getLanguage()
	 * @generated
	 */
	int LANGUAGE = 51;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.VarType <em>Var Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.VarType
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getVarType()
	 * @generated
	 */
	int VAR_TYPE = 52;


	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see de.cau.cs.kieler.cakefeed.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.System#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identification</em>'.
	 * @see de.cau.cs.kieler.cakefeed.System#getIdentification()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Identification();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.System#getVersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version Info</em>'.
	 * @see de.cau.cs.kieler.cakefeed.System#getVersionInfo()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_VersionInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.System#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Application</em>'.
	 * @see de.cau.cs.kieler.cakefeed.System#getApplication()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Application();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.System#getDevice <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Device</em>'.
	 * @see de.cau.cs.kieler.cakefeed.System#getDevice()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Device();

	/**
	 * Returns the meta object for the reference list '{@link de.cau.cs.kieler.cakefeed.System#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mapping</em>'.
	 * @see de.cau.cs.kieler.cakefeed.System#getMapping()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Mapping();

	/**
	 * Returns the meta object for the reference list '{@link de.cau.cs.kieler.cakefeed.System#getSegment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Segment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.System#getSegment()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Segment();

	/**
	 * Returns the meta object for the reference list '{@link de.cau.cs.kieler.cakefeed.System#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Link</em>'.
	 * @see de.cau.cs.kieler.cakefeed.System#getLink()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Link();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.System#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.System#getComment()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.System#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.System#getName()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Identification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identification</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Identification
	 * @generated
	 */
	EClass getIdentification();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Identification#getApplicationDomain <em>Application Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Application Domain</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Identification#getApplicationDomain()
	 * @see #getIdentification()
	 * @generated
	 */
	EAttribute getIdentification_ApplicationDomain();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Identification#getClassification <em>Classification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classification</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Identification#getClassification()
	 * @see #getIdentification()
	 * @generated
	 */
	EAttribute getIdentification_Classification();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Identification#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Identification#getDescription()
	 * @see #getIdentification()
	 * @generated
	 */
	EAttribute getIdentification_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Identification#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Identification#getFunction()
	 * @see #getIdentification()
	 * @generated
	 */
	EAttribute getIdentification_Function();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Identification#getStandard <em>Standard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Standard</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Identification#getStandard()
	 * @see #getIdentification()
	 * @generated
	 */
	EAttribute getIdentification_Standard();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Identification#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Identification#getType()
	 * @see #getIdentification()
	 * @generated
	 */
	EAttribute getIdentification_Type();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.VersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version Info</em>'.
	 * @see de.cau.cs.kieler.cakefeed.VersionInfo
	 * @generated
	 */
	EClass getVersionInfo();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.VersionInfo#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see de.cau.cs.kieler.cakefeed.VersionInfo#getAuthor()
	 * @see #getVersionInfo()
	 * @generated
	 */
	EAttribute getVersionInfo_Author();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.VersionInfo#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see de.cau.cs.kieler.cakefeed.VersionInfo#getDate()
	 * @see #getVersionInfo()
	 * @generated
	 */
	EAttribute getVersionInfo_Date();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.VersionInfo#getOrganisation <em>Organisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Organisation</em>'.
	 * @see de.cau.cs.kieler.cakefeed.VersionInfo#getOrganisation()
	 * @see #getVersionInfo()
	 * @generated
	 */
	EAttribute getVersionInfo_Organisation();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.VersionInfo#getRemarks <em>Remarks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remarks</em>'.
	 * @see de.cau.cs.kieler.cakefeed.VersionInfo#getRemarks()
	 * @see #getVersionInfo()
	 * @generated
	 */
	EAttribute getVersionInfo_Remarks();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.VersionInfo#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.cau.cs.kieler.cakefeed.VersionInfo#getVersion()
	 * @see #getVersionInfo()
	 * @generated
	 */
	EAttribute getVersionInfo_Version();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Application
	 * @generated
	 */
	EClass getApplication();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.Application#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Application#getFBNetwork()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_FBNetwork();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Application#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Application#getComment()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Application#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Application#getName()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.FBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBNetwork
	 * @generated
	 */
	EClass getFBNetwork();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBNetwork#getFB <em>FB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>FB</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBNetwork#getFB()
	 * @see #getFBNetwork()
	 * @generated
	 */
	EReference getFBNetwork_FB();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBNetwork#getEventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event Connections</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBNetwork#getEventConnections()
	 * @see #getFBNetwork()
	 * @generated
	 */
	EReference getFBNetwork_EventConnections();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBNetwork#getDataConnections <em>Data Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Connections</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBNetwork#getDataConnections()
	 * @see #getFBNetwork()
	 * @generated
	 */
	EReference getFBNetwork_DataConnections();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBNetwork#getAdapterConnections <em>Adapter Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Adapter Connections</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBNetwork#getAdapterConnections()
	 * @see #getFBNetwork()
	 * @generated
	 */
	EReference getFBNetwork_AdapterConnections();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Device <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Device
	 * @generated
	 */
	EClass getDevice();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.Device#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Device#getParameter()
	 * @see #getDevice()
	 * @generated
	 */
	EReference getDevice_Parameter();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.Device#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Device#getResource()
	 * @see #getDevice()
	 * @generated
	 */
	EReference getDevice_Resource();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.Device#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Device#getFBNetwork()
	 * @see #getDevice()
	 * @generated
	 */
	EReference getDevice_FBNetwork();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.Device#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Device#getType()
	 * @see #getDevice()
	 * @generated
	 */
	EReference getDevice_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Device#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Device#getComment()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Device#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Device#getName()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Mapping#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Mapping#getFrom()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_From();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Mapping#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Mapping#getTo()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_To();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Segment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Segment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Segment
	 * @generated
	 */
	EClass getSegment();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.Segment#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Segment#getParameter()
	 * @see #getSegment()
	 * @generated
	 */
	EReference getSegment_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Segment#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Segment#getType()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Segment#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Segment#getComment()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Segment#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Segment#getName()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.FB <em>FB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FB</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FB
	 * @generated
	 */
	EClass getFB();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FB#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FB#getParameter()
	 * @see #getFB()
	 * @generated
	 */
	EReference getFB_Parameter();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.FB#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FB#getType()
	 * @see #getFB()
	 * @generated
	 */
	EReference getFB_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.FB#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FB#getComment()
	 * @see #getFB()
	 * @generated
	 */
	EAttribute getFB_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.FB#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FB#getName()
	 * @see #getFB()
	 * @generated
	 */
	EAttribute getFB_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Parameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Parameter#getValue()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Value();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Parameter#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Parameter#getComment()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.Resource#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Resource#getParameter()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Parameter();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.Resource#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Resource#getFBNetwork()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_FBNetwork();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.Resource#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Resource#getType()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Resource#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Resource#getComment()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Resource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Resource#getName()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.FBType <em>FB Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FB Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBType
	 * @generated
	 */
	EClass getFBType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.FBType#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identification</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBType#getIdentification()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_Identification();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBType#getVersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version Info</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBType#getVersionInfo()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_VersionInfo();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.FBType#getCompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compiler Info</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBType#getCompilerInfo()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_CompilerInfo();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.FBType#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBType#getComment()
	 * @see #getFBType()
	 * @generated
	 */
	EAttribute getFBType_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.FBType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBType#getName()
	 * @see #getFBType()
	 * @generated
	 */
	EAttribute getFBType_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBType#getInputEvents <em>Input Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Events</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBType#getInputEvents()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_InputEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBType#getOutputEvents <em>Output Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Events</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBType#getOutputEvents()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_OutputEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBType#getInputVars <em>Input Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Vars</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBType#getInputVars()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_InputVars();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBType#getOutputVars <em>Output Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Vars</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBType#getOutputVars()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_OutputVars();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBType#getSockets <em>Sockets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sockets</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBType#getSockets()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_Sockets();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBType#getPlugs <em>Plugs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Plugs</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBType#getPlugs()
	 * @see #getFBType()
	 * @generated
	 */
	EReference getFBType_Plugs();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Connection#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Connection#getComment()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Comment();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.CompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compiler Info</em>'.
	 * @see de.cau.cs.kieler.cakefeed.CompilerInfo
	 * @generated
	 */
	EClass getCompilerInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.CompilerInfo#getCompiler <em>Compiler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Compiler</em>'.
	 * @see de.cau.cs.kieler.cakefeed.CompilerInfo#getCompiler()
	 * @see #getCompilerInfo()
	 * @generated
	 */
	EReference getCompilerInfo_Compiler();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.CompilerInfo#getClassdef <em>Classdef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classdef</em>'.
	 * @see de.cau.cs.kieler.cakefeed.CompilerInfo#getClassdef()
	 * @see #getCompilerInfo()
	 * @generated
	 */
	EAttribute getCompilerInfo_Classdef();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.CompilerInfo#getHeader <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Header</em>'.
	 * @see de.cau.cs.kieler.cakefeed.CompilerInfo#getHeader()
	 * @see #getCompilerInfo()
	 * @generated
	 */
	EAttribute getCompilerInfo_Header();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.EventConnection <em>Event Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.EventConnection
	 * @generated
	 */
	EClass getEventConnection();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.EventConnection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.cakefeed.EventConnection#getDestination()
	 * @see #getEventConnection()
	 * @generated
	 */
	EReference getEventConnection_Destination();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.EventConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.cakefeed.EventConnection#getSource()
	 * @see #getEventConnection()
	 * @generated
	 */
	EReference getEventConnection_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.DataConnection <em>Data Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.DataConnection
	 * @generated
	 */
	EClass getDataConnection();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.DataConnection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.cakefeed.DataConnection#getDestination()
	 * @see #getDataConnection()
	 * @generated
	 */
	EReference getDataConnection_Destination();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.DataConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.cakefeed.DataConnection#getSource()
	 * @see #getDataConnection()
	 * @generated
	 */
	EReference getDataConnection_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.AdapterConnection <em>Adapter Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.AdapterConnection
	 * @generated
	 */
	EClass getAdapterConnection();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Event#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Event#getType()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Type();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.InputEvent <em>Input Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Event</em>'.
	 * @see de.cau.cs.kieler.cakefeed.InputEvent
	 * @generated
	 */
	EClass getInputEvent();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.InputEvent#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>With</em>'.
	 * @see de.cau.cs.kieler.cakefeed.InputEvent#getWith()
	 * @see #getInputEvent()
	 * @generated
	 */
	EReference getInputEvent_With();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.OutputEvent <em>Output Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Event</em>'.
	 * @see de.cau.cs.kieler.cakefeed.OutputEvent
	 * @generated
	 */
	EClass getOutputEvent();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.OutputEvent#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>With</em>'.
	 * @see de.cau.cs.kieler.cakefeed.OutputEvent#getWith()
	 * @see #getOutputEvent()
	 * @generated
	 */
	EReference getOutputEvent_With();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Var <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Var
	 * @generated
	 */
	EClass getVar();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Var#getArraySize <em>Array Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Array Size</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Var#getArraySize()
	 * @see #getVar()
	 * @generated
	 */
	EAttribute getVar_ArraySize();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Var#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Value</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Var#getInitialValue()
	 * @see #getVar()
	 * @generated
	 */
	EAttribute getVar_InitialValue();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Var#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Var#getType()
	 * @see #getVar()
	 * @generated
	 */
	EAttribute getVar_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Var#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Var#getComment()
	 * @see #getVar()
	 * @generated
	 */
	EAttribute getVar_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Var#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Var#getName()
	 * @see #getVar()
	 * @generated
	 */
	EAttribute getVar_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.InputVar <em>Input Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Var</em>'.
	 * @see de.cau.cs.kieler.cakefeed.InputVar
	 * @generated
	 */
	EClass getInputVar();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.OutputVar <em>Output Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Var</em>'.
	 * @see de.cau.cs.kieler.cakefeed.OutputVar
	 * @generated
	 */
	EClass getOutputVar();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.InternalVar <em>Internal Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Var</em>'.
	 * @see de.cau.cs.kieler.cakefeed.InternalVar
	 * @generated
	 */
	EClass getInternalVar();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Compiler <em>Compiler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compiler</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Compiler
	 * @generated
	 */
	EClass getCompiler();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Compiler#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Compiler#getLanguage()
	 * @see #getCompiler()
	 * @generated
	 */
	EAttribute getCompiler_Language();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Compiler#getProduct <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Compiler#getProduct()
	 * @see #getCompiler()
	 * @generated
	 */
	EAttribute getCompiler_Product();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Compiler#getVendor <em>Vendor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vendor</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Compiler#getVendor()
	 * @see #getCompiler()
	 * @generated
	 */
	EAttribute getCompiler_Vendor();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Compiler#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Compiler#getVersion()
	 * @see #getCompiler()
	 * @generated
	 */
	EAttribute getCompiler_Version();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.With <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>With</em>'.
	 * @see de.cau.cs.kieler.cakefeed.With
	 * @generated
	 */
	EClass getWith();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.InputWith <em>Input With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input With</em>'.
	 * @see de.cau.cs.kieler.cakefeed.InputWith
	 * @generated
	 */
	EClass getInputWith();

	/**
	 * Returns the meta object for the container reference '{@link de.cau.cs.kieler.cakefeed.InputWith#getParentInputEvent <em>Parent Input Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Input Event</em>'.
	 * @see de.cau.cs.kieler.cakefeed.InputWith#getParentInputEvent()
	 * @see #getInputWith()
	 * @generated
	 */
	EReference getInputWith_ParentInputEvent();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.InputWith#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>With</em>'.
	 * @see de.cau.cs.kieler.cakefeed.InputWith#getWith()
	 * @see #getInputWith()
	 * @generated
	 */
	EReference getInputWith_With();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.OutputWith <em>Output With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output With</em>'.
	 * @see de.cau.cs.kieler.cakefeed.OutputWith
	 * @generated
	 */
	EClass getOutputWith();

	/**
	 * Returns the meta object for the container reference '{@link de.cau.cs.kieler.cakefeed.OutputWith#getParentOutputEvent <em>Parent Output Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Output Event</em>'.
	 * @see de.cau.cs.kieler.cakefeed.OutputWith#getParentOutputEvent()
	 * @see #getOutputWith()
	 * @generated
	 */
	EReference getOutputWith_ParentOutputEvent();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.OutputWith#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>With</em>'.
	 * @see de.cau.cs.kieler.cakefeed.OutputWith#getWith()
	 * @see #getOutputWith()
	 * @generated
	 */
	EReference getOutputWith_With();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Adapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Adapter
	 * @generated
	 */
	EClass getAdapter();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.Adapter#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Adapter#getParameter()
	 * @see #getAdapter()
	 * @generated
	 */
	EReference getAdapter_Parameter();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.Adapter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Adapter#getType()
	 * @see #getAdapter()
	 * @generated
	 */
	EReference getAdapter_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Adapter#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Adapter#getComment()
	 * @see #getAdapter()
	 * @generated
	 */
	EAttribute getAdapter_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Adapter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Adapter#getName()
	 * @see #getAdapter()
	 * @generated
	 */
	EAttribute getAdapter_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Socket <em>Socket</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Socket</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Socket
	 * @generated
	 */
	EClass getSocket();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Plug <em>Plug</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plug</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Plug
	 * @generated
	 */
	EClass getPlug();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.AdapterType <em>Adapter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.AdapterType
	 * @generated
	 */
	EClass getAdapterType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.AdapterType#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identification</em>'.
	 * @see de.cau.cs.kieler.cakefeed.AdapterType#getIdentification()
	 * @see #getAdapterType()
	 * @generated
	 */
	EReference getAdapterType_Identification();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.AdapterType#getVersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version Info</em>'.
	 * @see de.cau.cs.kieler.cakefeed.AdapterType#getVersionInfo()
	 * @see #getAdapterType()
	 * @generated
	 */
	EReference getAdapterType_VersionInfo();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.AdapterType#getCompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compiler Info</em>'.
	 * @see de.cau.cs.kieler.cakefeed.AdapterType#getCompilerInfo()
	 * @see #getAdapterType()
	 * @generated
	 */
	EReference getAdapterType_CompilerInfo();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.AdapterType#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service</em>'.
	 * @see de.cau.cs.kieler.cakefeed.AdapterType#getService()
	 * @see #getAdapterType()
	 * @generated
	 */
	EReference getAdapterType_Service();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.AdapterType#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.AdapterType#getComment()
	 * @see #getAdapterType()
	 * @generated
	 */
	EAttribute getAdapterType_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.AdapterType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.AdapterType#getName()
	 * @see #getAdapterType()
	 * @generated
	 */
	EAttribute getAdapterType_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.AdapterType#getInputEvents <em>Input Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Events</em>'.
	 * @see de.cau.cs.kieler.cakefeed.AdapterType#getInputEvents()
	 * @see #getAdapterType()
	 * @generated
	 */
	EReference getAdapterType_InputEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.AdapterType#getOutputEvents <em>Output Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Events</em>'.
	 * @see de.cau.cs.kieler.cakefeed.AdapterType#getOutputEvents()
	 * @see #getAdapterType()
	 * @generated
	 */
	EReference getAdapterType_OutputEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.AdapterType#getInputVars <em>Input Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Vars</em>'.
	 * @see de.cau.cs.kieler.cakefeed.AdapterType#getInputVars()
	 * @see #getAdapterType()
	 * @generated
	 */
	EReference getAdapterType_InputVars();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.AdapterType#getOutputVars <em>Output Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Vars</em>'.
	 * @see de.cau.cs.kieler.cakefeed.AdapterType#getOutputVars()
	 * @see #getAdapterType()
	 * @generated
	 */
	EReference getAdapterType_OutputVars();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.AdapterType#getSockets <em>Sockets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sockets</em>'.
	 * @see de.cau.cs.kieler.cakefeed.AdapterType#getSockets()
	 * @see #getAdapterType()
	 * @generated
	 */
	EReference getAdapterType_Sockets();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.AdapterType#getPlugs <em>Plugs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Plugs</em>'.
	 * @see de.cau.cs.kieler.cakefeed.AdapterType#getPlugs()
	 * @see #getAdapterType()
	 * @generated
	 */
	EReference getAdapterType_Plugs();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.Service#getServiceSequence <em>Service Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Sequence</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Service#getServiceSequence()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_ServiceSequence();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Service#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Service#getComment()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Service#getRightInterface <em>Right Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right Interface</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Service#getRightInterface()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_RightInterface();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Service#getLeftInterface <em>Left Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Left Interface</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Service#getLeftInterface()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_LeftInterface();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.ServiceSequence <em>Service Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Sequence</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ServiceSequence
	 * @generated
	 */
	EClass getServiceSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.ServiceSequence#getServiceTransaction <em>Service Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Transaction</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ServiceSequence#getServiceTransaction()
	 * @see #getServiceSequence()
	 * @generated
	 */
	EReference getServiceSequence_ServiceTransaction();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.ServiceSequence#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ServiceSequence#getComment()
	 * @see #getServiceSequence()
	 * @generated
	 */
	EAttribute getServiceSequence_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.ServiceSequence#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ServiceSequence#getName()
	 * @see #getServiceSequence()
	 * @generated
	 */
	EAttribute getServiceSequence_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.ServiceTransaction <em>Service Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Transaction</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ServiceTransaction
	 * @generated
	 */
	EClass getServiceTransaction();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.ServiceTransaction#getInputPrimitive <em>Input Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input Primitive</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ServiceTransaction#getInputPrimitive()
	 * @see #getServiceTransaction()
	 * @generated
	 */
	EReference getServiceTransaction_InputPrimitive();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.ServiceTransaction#getOutputPrimitive <em>Output Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Primitive</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ServiceTransaction#getOutputPrimitive()
	 * @see #getServiceTransaction()
	 * @generated
	 */
	EReference getServiceTransaction_OutputPrimitive();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Primitive <em>Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Primitive
	 * @generated
	 */
	EClass getPrimitive();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Primitive#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Primitive#getEvent()
	 * @see #getPrimitive()
	 * @generated
	 */
	EAttribute getPrimitive_Event();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Primitive#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Primitive#getInterface()
	 * @see #getPrimitive()
	 * @generated
	 */
	EAttribute getPrimitive_Interface();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Primitive#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameters</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Primitive#getParameters()
	 * @see #getPrimitive()
	 * @generated
	 */
	EAttribute getPrimitive_Parameters();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.InputPrimitive <em>Input Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Primitive</em>'.
	 * @see de.cau.cs.kieler.cakefeed.InputPrimitive
	 * @generated
	 */
	EClass getInputPrimitive();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.OutputPrimitive <em>Output Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Primitive</em>'.
	 * @see de.cau.cs.kieler.cakefeed.OutputPrimitive
	 * @generated
	 */
	EClass getOutputPrimitive();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.BFBType <em>BFB Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BFB Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.BFBType
	 * @generated
	 */
	EClass getBFBType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.BFBType#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service</em>'.
	 * @see de.cau.cs.kieler.cakefeed.BFBType#getService()
	 * @see #getBFBType()
	 * @generated
	 */
	EReference getBFBType_Service();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.BFBType#getSyncChart <em>Sync Chart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sync Chart</em>'.
	 * @see de.cau.cs.kieler.cakefeed.BFBType#getSyncChart()
	 * @see #getBFBType()
	 * @generated
	 */
	EReference getBFBType_SyncChart();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.BFBType#getInternalVars <em>Internal Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Internal Vars</em>'.
	 * @see de.cau.cs.kieler.cakefeed.BFBType#getInternalVars()
	 * @see #getBFBType()
	 * @generated
	 */
	EReference getBFBType_InternalVars();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.BFBType#getFBDs <em>FB Ds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>FB Ds</em>'.
	 * @see de.cau.cs.kieler.cakefeed.BFBType#getFBDs()
	 * @see #getBFBType()
	 * @generated
	 */
	EReference getBFBType_FBDs();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.BFBType#getSTs <em>STs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>STs</em>'.
	 * @see de.cau.cs.kieler.cakefeed.BFBType#getSTs()
	 * @see #getBFBType()
	 * @generated
	 */
	EReference getBFBType_STs();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.BFBType#getLDs <em>LDs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>LDs</em>'.
	 * @see de.cau.cs.kieler.cakefeed.BFBType#getLDs()
	 * @see #getBFBType()
	 * @generated
	 */
	EReference getBFBType_LDs();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.BFBType#getOtherAlgorithms <em>Other Algorithms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Other Algorithms</em>'.
	 * @see de.cau.cs.kieler.cakefeed.BFBType#getOtherAlgorithms()
	 * @see #getBFBType()
	 * @generated
	 */
	EReference getBFBType_OtherAlgorithms();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.FBD <em>FBD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FBD</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBD
	 * @generated
	 */
	EClass getFBD();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBD#getFB <em>FB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>FB</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBD#getFB()
	 * @see #getFBD()
	 * @generated
	 */
	EReference getFBD_FB();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBD#getDataConnections <em>Data Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Connections</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBD#getDataConnections()
	 * @see #getFBD()
	 * @generated
	 */
	EReference getFBD_DataConnections();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.FBD#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBD#getComment()
	 * @see #getFBD()
	 * @generated
	 */
	EAttribute getFBD_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.FBD#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBD#getName()
	 * @see #getFBD()
	 * @generated
	 */
	EAttribute getFBD_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.ST <em>ST</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ST</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ST
	 * @generated
	 */
	EClass getST();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.ST#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ST#getText()
	 * @see #getST()
	 * @generated
	 */
	EAttribute getST_Text();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.ST#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ST#getComment()
	 * @see #getST()
	 * @generated
	 */
	EAttribute getST_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.ST#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ST#getName()
	 * @see #getST()
	 * @generated
	 */
	EAttribute getST_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.LD <em>LD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LD</em>'.
	 * @see de.cau.cs.kieler.cakefeed.LD
	 * @generated
	 */
	EClass getLD();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.LD#getRung <em>Rung</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rung</em>'.
	 * @see de.cau.cs.kieler.cakefeed.LD#getRung()
	 * @see #getLD()
	 * @generated
	 */
	EReference getLD_Rung();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.LD#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.LD#getComment()
	 * @see #getLD()
	 * @generated
	 */
	EAttribute getLD_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.LD#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.LD#getName()
	 * @see #getLD()
	 * @generated
	 */
	EAttribute getLD_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Other <em>Other</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Other</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Other
	 * @generated
	 */
	EClass getOther();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Other#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Other#getLanguage()
	 * @see #getOther()
	 * @generated
	 */
	EAttribute getOther_Language();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Other#getPrototype <em>Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prototype</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Other#getPrototype()
	 * @see #getOther()
	 * @generated
	 */
	EAttribute getOther_Prototype();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Other#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Other#getText()
	 * @see #getOther()
	 * @generated
	 */
	EAttribute getOther_Text();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Other#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Other#getComment()
	 * @see #getOther()
	 * @generated
	 */
	EAttribute getOther_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Other#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Other#getName()
	 * @see #getOther()
	 * @generated
	 */
	EAttribute getOther_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Rung <em>Rung</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rung</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Rung
	 * @generated
	 */
	EClass getRung();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Rung#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Rung#getComment()
	 * @see #getRung()
	 * @generated
	 */
	EAttribute getRung_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Rung#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Rung#getExpression()
	 * @see #getRung()
	 * @generated
	 */
	EAttribute getRung_Expression();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.Rung#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Rung#getOutput()
	 * @see #getRung()
	 * @generated
	 */
	EReference getRung_Output();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.CFBType <em>CFB Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CFB Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.CFBType
	 * @generated
	 */
	EClass getCFBType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.CFBType#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.cakefeed.CFBType#getFBNetwork()
	 * @see #getCFBType()
	 * @generated
	 */
	EReference getCFBType_FBNetwork();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.CFBType#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service</em>'.
	 * @see de.cau.cs.kieler.cakefeed.CFBType#getService()
	 * @see #getCFBType()
	 * @generated
	 */
	EReference getCFBType_Service();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.DeviceType <em>Device Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.DeviceType
	 * @generated
	 */
	EClass getDeviceType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.DeviceType#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identification</em>'.
	 * @see de.cau.cs.kieler.cakefeed.DeviceType#getIdentification()
	 * @see #getDeviceType()
	 * @generated
	 */
	EReference getDeviceType_Identification();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.DeviceType#getVersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version Info</em>'.
	 * @see de.cau.cs.kieler.cakefeed.DeviceType#getVersionInfo()
	 * @see #getDeviceType()
	 * @generated
	 */
	EReference getDeviceType_VersionInfo();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.DeviceType#getCompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compiler Info</em>'.
	 * @see de.cau.cs.kieler.cakefeed.DeviceType#getCompilerInfo()
	 * @see #getDeviceType()
	 * @generated
	 */
	EReference getDeviceType_CompilerInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.DeviceType#getVarDeclarations <em>Var Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Var Declarations</em>'.
	 * @see de.cau.cs.kieler.cakefeed.DeviceType#getVarDeclarations()
	 * @see #getDeviceType()
	 * @generated
	 */
	EReference getDeviceType_VarDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.DeviceType#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see de.cau.cs.kieler.cakefeed.DeviceType#getResources()
	 * @see #getDeviceType()
	 * @generated
	 */
	EReference getDeviceType_Resources();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.DeviceType#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.cakefeed.DeviceType#getFBNetwork()
	 * @see #getDeviceType()
	 * @generated
	 */
	EReference getDeviceType_FBNetwork();

	/**
	 * Returns the meta object for the attribute list '{@link de.cau.cs.kieler.cakefeed.DeviceType#getResourceNames <em>Resource Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Resource Names</em>'.
	 * @see de.cau.cs.kieler.cakefeed.DeviceType#getResourceNames()
	 * @see #getDeviceType()
	 * @generated
	 */
	EAttribute getDeviceType_ResourceNames();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.DeviceType#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.DeviceType#getComment()
	 * @see #getDeviceType()
	 * @generated
	 */
	EAttribute getDeviceType_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.DeviceType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.DeviceType#getName()
	 * @see #getDeviceType()
	 * @generated
	 */
	EAttribute getDeviceType_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.ResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ResourceType
	 * @generated
	 */
	EClass getResourceType();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.ResourceType#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identification</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ResourceType#getIdentification()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_Identification();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.ResourceType#getVersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version Info</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ResourceType#getVersionInfo()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_VersionInfo();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.ResourceType#getCompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compiler Info</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ResourceType#getCompilerInfo()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_CompilerInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.ResourceType#getVarDeclarations <em>Var Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Var Declarations</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ResourceType#getVarDeclarations()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_VarDeclarations();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.ResourceType#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ResourceType#getFBNetwork()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_FBNetwork();

	/**
	 * Returns the meta object for the attribute list '{@link de.cau.cs.kieler.cakefeed.ResourceType#getFBNames <em>FB Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>FB Names</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ResourceType#getFBNames()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_FBNames();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.ResourceType#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ResourceType#getComment()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.ResourceType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ResourceType#getName()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.BFBDiagram <em>BFB Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BFB Diagram</em>'.
	 * @see de.cau.cs.kieler.cakefeed.BFBDiagram
	 * @generated
	 */
	EClass getBFBDiagram();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.BFBDiagram#getBFBType <em>BFB Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>BFB Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.BFBDiagram#getBFBType()
	 * @see #getBFBDiagram()
	 * @generated
	 */
	EReference getBFBDiagram_BFBType();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.CFBDiagram <em>CFB Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CFB Diagram</em>'.
	 * @see de.cau.cs.kieler.cakefeed.CFBDiagram
	 * @generated
	 */
	EClass getCFBDiagram();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.CFBDiagram#getCFBType <em>CFB Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>CFB Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.CFBDiagram#getCFBType()
	 * @see #getCFBDiagram()
	 * @generated
	 */
	EReference getCFBDiagram_CFBType();

	/**
	 * Returns the meta object for enum '{@link de.cau.cs.kieler.cakefeed.SegmentType <em>Segment Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Segment Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.SegmentType
	 * @generated
	 */
	EEnum getSegmentType();

	/**
	 * Returns the meta object for enum '{@link de.cau.cs.kieler.cakefeed.Language <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Language</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Language
	 * @generated
	 */
	EEnum getLanguage();

	/**
	 * Returns the meta object for enum '{@link de.cau.cs.kieler.cakefeed.VarType <em>Var Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Var Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.VarType
	 * @generated
	 */
	EEnum getVarType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CakefeedFactory getCakefeedFactory();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.SystemImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getSystem()
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
		 * The meta object literal for the '<em><b>Mapping</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__MAPPING = eINSTANCE.getSystem_Mapping();

		/**
		 * The meta object literal for the '<em><b>Segment</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__SEGMENT = eINSTANCE.getSystem_Segment();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' reference list feature.
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.IdentificationImpl <em>Identification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.IdentificationImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIdentification()
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.VersionInfoImpl <em>Version Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.VersionInfoImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getVersionInfo()
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
		 * The meta object literal for the '<em><b>Organisation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION_INFO__ORGANISATION = eINSTANCE.getVersionInfo_Organisation();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.ApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.ApplicationImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getApplication()
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBNetworkImpl <em>FB Network</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBNetworkImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBNetwork()
		 * @generated
		 */
		EClass FB_NETWORK = eINSTANCE.getFBNetwork();

		/**
		 * The meta object literal for the '<em><b>FB</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_NETWORK__FB = eINSTANCE.getFBNetwork_FB();

		/**
		 * The meta object literal for the '<em><b>Event Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_NETWORK__EVENT_CONNECTIONS = eINSTANCE.getFBNetwork_EventConnections();

		/**
		 * The meta object literal for the '<em><b>Data Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_NETWORK__DATA_CONNECTIONS = eINSTANCE.getFBNetwork_DataConnections();

		/**
		 * The meta object literal for the '<em><b>Adapter Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_NETWORK__ADAPTER_CONNECTIONS = eINSTANCE.getFBNetwork_AdapterConnections();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.DeviceImpl <em>Device</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.DeviceImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getDevice()
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
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE__TYPE = eINSTANCE.getDevice_Type();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.MappingImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getMapping()
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.SegmentImpl <em>Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.SegmentImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getSegment()
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
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__TYPE = eINSTANCE.getSegment_Type();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__COMMENT = eINSTANCE.getSegment_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__NAME = eINSTANCE.getSegment_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.LinkImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBImpl <em>FB</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFB()
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
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB__TYPE = eINSTANCE.getFB_Type();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.ParameterImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__VALUE = eINSTANCE.getParameter_Value();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.ResourceImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getResource()
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
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__TYPE = eINSTANCE.getResource_Type();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBTypeImpl <em>FB Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBTypeImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBType()
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
		 * The meta object literal for the '<em><b>Input Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_TYPE__INPUT_EVENTS = eINSTANCE.getFBType_InputEvents();

		/**
		 * The meta object literal for the '<em><b>Output Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_TYPE__OUTPUT_EVENTS = eINSTANCE.getFBType_OutputEvents();

		/**
		 * The meta object literal for the '<em><b>Input Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_TYPE__INPUT_VARS = eINSTANCE.getFBType_InputVars();

		/**
		 * The meta object literal for the '<em><b>Output Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_TYPE__OUTPUT_VARS = eINSTANCE.getFBType_OutputVars();

		/**
		 * The meta object literal for the '<em><b>Sockets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_TYPE__SOCKETS = eINSTANCE.getFBType_Sockets();

		/**
		 * The meta object literal for the '<em><b>Plugs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_TYPE__PLUGS = eINSTANCE.getFBType_Plugs();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.ConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getConnection()
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.CompilerInfoImpl <em>Compiler Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.CompilerInfoImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getCompilerInfo()
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.EventConnectionImpl <em>Event Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.EventConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getEventConnection()
		 * @generated
		 */
		EClass EVENT_CONNECTION = eINSTANCE.getEventConnection();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_CONNECTION__DESTINATION = eINSTANCE.getEventConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_CONNECTION__SOURCE = eINSTANCE.getEventConnection_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.DataConnectionImpl <em>Data Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.DataConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getDataConnection()
		 * @generated
		 */
		EClass DATA_CONNECTION = eINSTANCE.getDataConnection();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CONNECTION__DESTINATION = eINSTANCE.getDataConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CONNECTION__SOURCE = eINSTANCE.getDataConnection_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.AdapterConnectionImpl <em>Adapter Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.AdapterConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getAdapterConnection()
		 * @generated
		 */
		EClass ADAPTER_CONNECTION = eINSTANCE.getAdapterConnection();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.EventImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TYPE = eINSTANCE.getEvent_Type();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.InputEventImpl <em>Input Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.InputEventImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getInputEvent()
		 * @generated
		 */
		EClass INPUT_EVENT = eINSTANCE.getInputEvent();

		/**
		 * The meta object literal for the '<em><b>With</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_EVENT__WITH = eINSTANCE.getInputEvent_With();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.OutputEventImpl <em>Output Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.OutputEventImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getOutputEvent()
		 * @generated
		 */
		EClass OUTPUT_EVENT = eINSTANCE.getOutputEvent();

		/**
		 * The meta object literal for the '<em><b>With</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_EVENT__WITH = eINSTANCE.getOutputEvent_With();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.VarImpl <em>Var</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.VarImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getVar()
		 * @generated
		 */
		EClass VAR = eINSTANCE.getVar();

		/**
		 * The meta object literal for the '<em><b>Array Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR__ARRAY_SIZE = eINSTANCE.getVar_ArraySize();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR__INITIAL_VALUE = eINSTANCE.getVar_InitialValue();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR__TYPE = eINSTANCE.getVar_Type();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR__COMMENT = eINSTANCE.getVar_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR__NAME = eINSTANCE.getVar_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.InputVarImpl <em>Input Var</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.InputVarImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getInputVar()
		 * @generated
		 */
		EClass INPUT_VAR = eINSTANCE.getInputVar();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.OutputVarImpl <em>Output Var</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.OutputVarImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getOutputVar()
		 * @generated
		 */
		EClass OUTPUT_VAR = eINSTANCE.getOutputVar();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.InternalVarImpl <em>Internal Var</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.InternalVarImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getInternalVar()
		 * @generated
		 */
		EClass INTERNAL_VAR = eINSTANCE.getInternalVar();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.CompilerImpl <em>Compiler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.CompilerImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getCompiler()
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.WithImpl <em>With</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.WithImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getWith()
		 * @generated
		 */
		EClass WITH = eINSTANCE.getWith();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.InputWithImpl <em>Input With</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.InputWithImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getInputWith()
		 * @generated
		 */
		EClass INPUT_WITH = eINSTANCE.getInputWith();

		/**
		 * The meta object literal for the '<em><b>Parent Input Event</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_WITH__PARENT_INPUT_EVENT = eINSTANCE.getInputWith_ParentInputEvent();

		/**
		 * The meta object literal for the '<em><b>With</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_WITH__WITH = eINSTANCE.getInputWith_With();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.OutputWithImpl <em>Output With</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.OutputWithImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getOutputWith()
		 * @generated
		 */
		EClass OUTPUT_WITH = eINSTANCE.getOutputWith();

		/**
		 * The meta object literal for the '<em><b>Parent Output Event</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_WITH__PARENT_OUTPUT_EVENT = eINSTANCE.getOutputWith_ParentOutputEvent();

		/**
		 * The meta object literal for the '<em><b>With</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_WITH__WITH = eINSTANCE.getOutputWith_With();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.AdapterImpl <em>Adapter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.AdapterImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getAdapter()
		 * @generated
		 */
		EClass ADAPTER = eINSTANCE.getAdapter();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER__PARAMETER = eINSTANCE.getAdapter_Parameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER__TYPE = eINSTANCE.getAdapter_Type();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER__COMMENT = eINSTANCE.getAdapter_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER__NAME = eINSTANCE.getAdapter_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.SocketImpl <em>Socket</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.SocketImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getSocket()
		 * @generated
		 */
		EClass SOCKET = eINSTANCE.getSocket();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.PlugImpl <em>Plug</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.PlugImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getPlug()
		 * @generated
		 */
		EClass PLUG = eINSTANCE.getPlug();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.AdapterTypeImpl <em>Adapter Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.AdapterTypeImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getAdapterType()
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
		 * The meta object literal for the '<em><b>Input Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_TYPE__INPUT_EVENTS = eINSTANCE.getAdapterType_InputEvents();

		/**
		 * The meta object literal for the '<em><b>Output Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_TYPE__OUTPUT_EVENTS = eINSTANCE.getAdapterType_OutputEvents();

		/**
		 * The meta object literal for the '<em><b>Input Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_TYPE__INPUT_VARS = eINSTANCE.getAdapterType_InputVars();

		/**
		 * The meta object literal for the '<em><b>Output Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_TYPE__OUTPUT_VARS = eINSTANCE.getAdapterType_OutputVars();

		/**
		 * The meta object literal for the '<em><b>Sockets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_TYPE__SOCKETS = eINSTANCE.getAdapterType_Sockets();

		/**
		 * The meta object literal for the '<em><b>Plugs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_TYPE__PLUGS = eINSTANCE.getAdapterType_Plugs();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.ServiceImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getService()
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
		 * The meta object literal for the '<em><b>Right Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__RIGHT_INTERFACE = eINSTANCE.getService_RightInterface();

		/**
		 * The meta object literal for the '<em><b>Left Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__LEFT_INTERFACE = eINSTANCE.getService_LeftInterface();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.ServiceSequenceImpl <em>Service Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.ServiceSequenceImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getServiceSequence()
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.ServiceTransactionImpl <em>Service Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.ServiceTransactionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getServiceTransaction()
		 * @generated
		 */
		EClass SERVICE_TRANSACTION = eINSTANCE.getServiceTransaction();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.PrimitiveImpl <em>Primitive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.PrimitiveImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getPrimitive()
		 * @generated
		 */
		EClass PRIMITIVE = eINSTANCE.getPrimitive();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE__EVENT = eINSTANCE.getPrimitive_Event();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE__INTERFACE = eINSTANCE.getPrimitive_Interface();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE__PARAMETERS = eINSTANCE.getPrimitive_Parameters();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.InputPrimitiveImpl <em>Input Primitive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.InputPrimitiveImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getInputPrimitive()
		 * @generated
		 */
		EClass INPUT_PRIMITIVE = eINSTANCE.getInputPrimitive();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.OutputPrimitiveImpl <em>Output Primitive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.OutputPrimitiveImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getOutputPrimitive()
		 * @generated
		 */
		EClass OUTPUT_PRIMITIVE = eINSTANCE.getOutputPrimitive();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.BFBTypeImpl <em>BFB Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.BFBTypeImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getBFBType()
		 * @generated
		 */
		EClass BFB_TYPE = eINSTANCE.getBFBType();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BFB_TYPE__SERVICE = eINSTANCE.getBFBType_Service();

		/**
		 * The meta object literal for the '<em><b>Sync Chart</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BFB_TYPE__SYNC_CHART = eINSTANCE.getBFBType_SyncChart();

		/**
		 * The meta object literal for the '<em><b>Internal Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BFB_TYPE__INTERNAL_VARS = eINSTANCE.getBFBType_InternalVars();

		/**
		 * The meta object literal for the '<em><b>FB Ds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BFB_TYPE__FB_DS = eINSTANCE.getBFBType_FBDs();

		/**
		 * The meta object literal for the '<em><b>STs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BFB_TYPE__STS = eINSTANCE.getBFBType_STs();

		/**
		 * The meta object literal for the '<em><b>LDs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BFB_TYPE__LDS = eINSTANCE.getBFBType_LDs();

		/**
		 * The meta object literal for the '<em><b>Other Algorithms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BFB_TYPE__OTHER_ALGORITHMS = eINSTANCE.getBFBType_OtherAlgorithms();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBDImpl <em>FBD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBDImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBD()
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
		 * The meta object literal for the '<em><b>Data Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FBD__DATA_CONNECTIONS = eINSTANCE.getFBD_DataConnections();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FBD__COMMENT = eINSTANCE.getFBD_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FBD__NAME = eINSTANCE.getFBD_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.STImpl <em>ST</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.STImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getST()
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
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ST__COMMENT = eINSTANCE.getST_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ST__NAME = eINSTANCE.getST_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.LDImpl <em>LD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.LDImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getLD()
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
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LD__COMMENT = eINSTANCE.getLD_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LD__NAME = eINSTANCE.getLD_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.OtherImpl <em>Other</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.OtherImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getOther()
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
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OTHER__COMMENT = eINSTANCE.getOther_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OTHER__NAME = eINSTANCE.getOther_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.RungImpl <em>Rung</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.RungImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getRung()
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
		 * The meta object literal for the '<em><b>Output</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUNG__OUTPUT = eINSTANCE.getRung_Output();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.CFBTypeImpl <em>CFB Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.CFBTypeImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getCFBType()
		 * @generated
		 */
		EClass CFB_TYPE = eINSTANCE.getCFBType();

		/**
		 * The meta object literal for the '<em><b>FB Network</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CFB_TYPE__FB_NETWORK = eINSTANCE.getCFBType_FBNetwork();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CFB_TYPE__SERVICE = eINSTANCE.getCFBType_Service();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.DeviceTypeImpl <em>Device Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.DeviceTypeImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getDeviceType()
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
		 * The meta object literal for the '<em><b>Var Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_TYPE__VAR_DECLARATIONS = eINSTANCE.getDeviceType_VarDeclarations();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_TYPE__RESOURCES = eINSTANCE.getDeviceType_Resources();

		/**
		 * The meta object literal for the '<em><b>FB Network</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_TYPE__FB_NETWORK = eINSTANCE.getDeviceType_FBNetwork();

		/**
		 * The meta object literal for the '<em><b>Resource Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE_TYPE__RESOURCE_NAMES = eINSTANCE.getDeviceType_ResourceNames();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.ResourceTypeImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getResourceType()
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
		 * The meta object literal for the '<em><b>Var Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE__VAR_DECLARATIONS = eINSTANCE.getResourceType_VarDeclarations();

		/**
		 * The meta object literal for the '<em><b>FB Network</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE__FB_NETWORK = eINSTANCE.getResourceType_FBNetwork();

		/**
		 * The meta object literal for the '<em><b>FB Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__FB_NAMES = eINSTANCE.getResourceType_FBNames();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.BFBDiagramImpl <em>BFB Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.BFBDiagramImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getBFBDiagram()
		 * @generated
		 */
		EClass BFB_DIAGRAM = eINSTANCE.getBFBDiagram();

		/**
		 * The meta object literal for the '<em><b>BFB Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BFB_DIAGRAM__BFB_TYPE = eINSTANCE.getBFBDiagram_BFBType();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.CFBDiagramImpl <em>CFB Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.CFBDiagramImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getCFBDiagram()
		 * @generated
		 */
		EClass CFB_DIAGRAM = eINSTANCE.getCFBDiagram();

		/**
		 * The meta object literal for the '<em><b>CFB Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CFB_DIAGRAM__CFB_TYPE = eINSTANCE.getCFBDiagram_CFBType();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.SegmentType <em>Segment Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.SegmentType
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getSegmentType()
		 * @generated
		 */
		EEnum SEGMENT_TYPE = eINSTANCE.getSegmentType();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.Language <em>Language</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.Language
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getLanguage()
		 * @generated
		 */
		EEnum LANGUAGE = eINSTANCE.getLanguage();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.VarType <em>Var Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.VarType
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getVarType()
		 * @generated
		 */
		EEnum VAR_TYPE = eINSTANCE.getVarType();

	}

} //CakefeedPackage
