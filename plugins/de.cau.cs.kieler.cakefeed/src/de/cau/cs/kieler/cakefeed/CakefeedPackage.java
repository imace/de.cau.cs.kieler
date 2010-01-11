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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.IdentifiableImpl <em>Identifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.IdentifiableImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIdentifiable()
	 * @generated
	 */
	int IDENTIFIABLE = 69;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE__IDENTIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Version Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE__VERSION_INFOS = 1;

	/**
	 * The number of structural features of the '<em>Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_FEATURE_COUNT = 2;

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
	int SYSTEM__IDENTIFICATION = IDENTIFIABLE__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Version Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__VERSION_INFOS = IDENTIFIABLE__VERSION_INFOS;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__COMMENT = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Applications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__APPLICATIONS = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Devices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__DEVICES = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__MAPPINGS = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Segments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__SEGMENTS = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__LINKS = IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 7;

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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.NamedAndCommentedImpl <em>Named And Commented</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.NamedAndCommentedImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getNamedAndCommented()
	 * @generated
	 */
	int NAMED_AND_COMMENTED = 68;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_AND_COMMENTED__COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_AND_COMMENTED__NAME = 1;

	/**
	 * The number of structural features of the '<em>Named And Commented</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_AND_COMMENTED_FEATURE_COUNT = 2;

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
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__COMMENT = NAMED_AND_COMMENTED__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__NAME = NAMED_AND_COMMENTED__NAME;

	/**
	 * The feature id for the '<em><b>FB Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__FB_NETWORK = NAMED_AND_COMMENTED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FEATURE_COUNT = NAMED_AND_COMMENTED_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>FBs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_NETWORK__FBS = 0;

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
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__COMMENT = NAMED_AND_COMMENTED__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__NAME = NAMED_AND_COMMENTED__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__PARAMETERS = NAMED_AND_COMMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__RESOURCES = NAMED_AND_COMMENTED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>FB Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__FB_NETWORK = NAMED_AND_COMMENTED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__TYPE = NAMED_AND_COMMENTED_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Device</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_FEATURE_COUNT = NAMED_AND_COMMENTED_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__COMMENT = NAMED_AND_COMMENTED__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__NAME = NAMED_AND_COMMENTED__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__PARAMETERS = NAMED_AND_COMMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__TYPE = NAMED_AND_COMMENTED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT_FEATURE_COUNT = NAMED_AND_COMMENTED_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__PARAMETERS = 0;

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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBImpl <em>FB</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFB()
	 * @generated
	 */
	int FB = 9;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__COMMENT = NAMED_AND_COMMENTED__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__NAME = NAMED_AND_COMMENTED__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__PARAMETERS = NAMED_AND_COMMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__TYPE = NAMED_AND_COMMENTED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__INPUT_EVENTS = NAMED_AND_COMMENTED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Output Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__OUTPUT_EVENTS = NAMED_AND_COMMENTED_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Input Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__INPUT_VARS = NAMED_AND_COMMENTED_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Output Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB__OUTPUT_VARS = NAMED_AND_COMMENTED_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>FB</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_FEATURE_COUNT = NAMED_AND_COMMENTED_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBInterfaceImpl <em>FB Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBInterfaceImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBInterface()
	 * @generated
	 */
	int FB_INTERFACE = 10;

	/**
	 * The feature id for the '<em><b>Input Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INTERFACE__INPUT_EVENTS = 0;

	/**
	 * The feature id for the '<em><b>Output Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INTERFACE__OUTPUT_EVENTS = 1;

	/**
	 * The feature id for the '<em><b>Input Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INTERFACE__INPUT_VARS = 2;

	/**
	 * The feature id for the '<em><b>Output Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INTERFACE__OUTPUT_VARS = 3;

	/**
	 * The feature id for the '<em><b>Sockets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INTERFACE__SOCKETS = 4;

	/**
	 * The feature id for the '<em><b>Plugs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INTERFACE__PLUGS = 5;

	/**
	 * The number of structural features of the '<em>FB Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INTERFACE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.ParameterImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 11;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__COMMENT = NAMED_AND_COMMENTED__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = NAMED_AND_COMMENTED__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VALUE = NAMED_AND_COMMENTED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = NAMED_AND_COMMENTED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.ResourceImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 12;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__COMMENT = NAMED_AND_COMMENTED__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = NAMED_AND_COMMENTED__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__PARAMETERS = NAMED_AND_COMMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>FB Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__FB_NETWORK = NAMED_AND_COMMENTED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__TYPE = NAMED_AND_COMMENTED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = NAMED_AND_COMMENTED_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.CompilableImpl <em>Compilable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.CompilableImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getCompilable()
	 * @generated
	 */
	int COMPILABLE = 70;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILABLE__IDENTIFICATION = IDENTIFIABLE__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Version Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILABLE__VERSION_INFOS = IDENTIFIABLE__VERSION_INFOS;

	/**
	 * The feature id for the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILABLE__COMPILER_INFO = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compilable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILABLE_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBTypeImpl <em>FB Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBTypeImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBType()
	 * @generated
	 */
	int FB_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__IDENTIFICATION = COMPILABLE__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Version Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__VERSION_INFOS = COMPILABLE__VERSION_INFOS;

	/**
	 * The feature id for the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__COMPILER_INFO = COMPILABLE__COMPILER_INFO;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__COMMENT = COMPILABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__NAME = COMPILABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__INPUT_EVENTS = COMPILABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Output Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__OUTPUT_EVENTS = COMPILABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Input Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__INPUT_VARS = COMPILABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Output Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__OUTPUT_VARS = COMPILABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Sockets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__SOCKETS = COMPILABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Plugs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE__PLUGS = COMPILABLE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>FB Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_TYPE_FEATURE_COUNT = COMPILABLE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.ConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 14;

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
	 * The number of structural features of the '<em>Event Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONNECTION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 0;

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
	 * The number of structural features of the '<em>Data Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONNECTION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.CompilerInfoImpl <em>Compiler Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.CompilerInfoImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getCompilerInfo()
	 * @generated
	 */
	int COMPILER_INFO = 17;

	/**
	 * The feature id for the '<em><b>Compilers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILER_INFO__COMPILERS = 0;

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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.IFIFEventConnectionImpl <em>IFIF Event Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.IFIFEventConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFIFEventConnection()
	 * @generated
	 */
	int IFIF_EVENT_CONNECTION = 18;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFIF_EVENT_CONNECTION__COMMENT = EVENT_CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFIF_EVENT_CONNECTION__DESTINATION = EVENT_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFIF_EVENT_CONNECTION__SOURCE = EVENT_CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IFIF Event Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFIF_EVENT_CONNECTION_FEATURE_COUNT = EVENT_CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.IFIFDataConnectionImpl <em>IFIF Data Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.IFIFDataConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFIFDataConnection()
	 * @generated
	 */
	int IFIF_DATA_CONNECTION = 19;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFIF_DATA_CONNECTION__COMMENT = DATA_CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFIF_DATA_CONNECTION__DESTINATION = DATA_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFIF_DATA_CONNECTION__SOURCE = DATA_CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IFIF Data Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFIF_DATA_CONNECTION_FEATURE_COUNT = DATA_CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.IFFBEventConnectionImpl <em>IFFB Event Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.IFFBEventConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFFBEventConnection()
	 * @generated
	 */
	int IFFB_EVENT_CONNECTION = 20;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFFB_EVENT_CONNECTION__COMMENT = EVENT_CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFFB_EVENT_CONNECTION__DESTINATION = EVENT_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFFB_EVENT_CONNECTION__SOURCE = EVENT_CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IFFB Event Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFFB_EVENT_CONNECTION_FEATURE_COUNT = EVENT_CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.IFFBDataConnectionImpl <em>IFFB Data Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.IFFBDataConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFFBDataConnection()
	 * @generated
	 */
	int IFFB_DATA_CONNECTION = 21;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFFB_DATA_CONNECTION__COMMENT = DATA_CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFFB_DATA_CONNECTION__DESTINATION = DATA_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFFB_DATA_CONNECTION__SOURCE = DATA_CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IFFB Data Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFFB_DATA_CONNECTION_FEATURE_COUNT = DATA_CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBIFEventConnectionImpl <em>FBIF Event Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBIFEventConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBIFEventConnection()
	 * @generated
	 */
	int FBIF_EVENT_CONNECTION = 22;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBIF_EVENT_CONNECTION__COMMENT = EVENT_CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBIF_EVENT_CONNECTION__DESTINATION = EVENT_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBIF_EVENT_CONNECTION__SOURCE = EVENT_CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>FBIF Event Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBIF_EVENT_CONNECTION_FEATURE_COUNT = EVENT_CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBIFDataConnectionImpl <em>FBIF Data Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBIFDataConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBIFDataConnection()
	 * @generated
	 */
	int FBIF_DATA_CONNECTION = 23;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBIF_DATA_CONNECTION__COMMENT = DATA_CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBIF_DATA_CONNECTION__DESTINATION = DATA_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBIF_DATA_CONNECTION__SOURCE = DATA_CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>FBIF Data Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBIF_DATA_CONNECTION_FEATURE_COUNT = DATA_CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBFBEventConnectionImpl <em>FBFB Event Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBFBEventConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBFBEventConnection()
	 * @generated
	 */
	int FBFB_EVENT_CONNECTION = 24;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBFB_EVENT_CONNECTION__COMMENT = EVENT_CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBFB_EVENT_CONNECTION__DESTINATION = EVENT_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBFB_EVENT_CONNECTION__SOURCE = EVENT_CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>FBFB Event Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBFB_EVENT_CONNECTION_FEATURE_COUNT = EVENT_CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBFBDataConnectionImpl <em>FBFB Data Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBFBDataConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBFBDataConnection()
	 * @generated
	 */
	int FBFB_DATA_CONNECTION = 25;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBFB_DATA_CONNECTION__COMMENT = DATA_CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBFB_DATA_CONNECTION__DESTINATION = DATA_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBFB_DATA_CONNECTION__SOURCE = DATA_CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>FBFB Data Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBFB_DATA_CONNECTION_FEATURE_COUNT = DATA_CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.IFIVDataConnectionImpl <em>IFIV Data Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.IFIVDataConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFIVDataConnection()
	 * @generated
	 */
	int IFIV_DATA_CONNECTION = 26;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFIV_DATA_CONNECTION__COMMENT = DATA_CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFIV_DATA_CONNECTION__DESTINATION = DATA_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFIV_DATA_CONNECTION__SOURCE = DATA_CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IFIV Data Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFIV_DATA_CONNECTION_FEATURE_COUNT = DATA_CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.IVIFDataConnectionImpl <em>IVIF Data Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.IVIFDataConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIVIFDataConnection()
	 * @generated
	 */
	int IVIF_DATA_CONNECTION = 27;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIF_DATA_CONNECTION__COMMENT = DATA_CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIF_DATA_CONNECTION__DESTINATION = DATA_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIF_DATA_CONNECTION__SOURCE = DATA_CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IVIF Data Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIF_DATA_CONNECTION_FEATURE_COUNT = DATA_CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBIVDataConnectionImpl <em>FBIV Data Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBIVDataConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBIVDataConnection()
	 * @generated
	 */
	int FBIV_DATA_CONNECTION = 28;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBIV_DATA_CONNECTION__COMMENT = DATA_CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBIV_DATA_CONNECTION__DESTINATION = DATA_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBIV_DATA_CONNECTION__SOURCE = DATA_CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>FBIV Data Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBIV_DATA_CONNECTION_FEATURE_COUNT = DATA_CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.IVFBDataConnectionImpl <em>IVFB Data Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.IVFBDataConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIVFBDataConnection()
	 * @generated
	 */
	int IVFB_DATA_CONNECTION = 29;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVFB_DATA_CONNECTION__COMMENT = DATA_CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVFB_DATA_CONNECTION__DESTINATION = DATA_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVFB_DATA_CONNECTION__SOURCE = DATA_CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IVFB Data Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVFB_DATA_CONNECTION_FEATURE_COUNT = DATA_CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.IVIVDataConnectionImpl <em>IVIV Data Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.IVIVDataConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIVIVDataConnection()
	 * @generated
	 */
	int IVIV_DATA_CONNECTION = 30;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIV_DATA_CONNECTION__COMMENT = DATA_CONNECTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIV_DATA_CONNECTION__DESTINATION = DATA_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIV_DATA_CONNECTION__SOURCE = DATA_CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IVIV Data Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVIV_DATA_CONNECTION_FEATURE_COUNT = DATA_CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.AdapterConnectionImpl <em>Adapter Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.AdapterConnectionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getAdapterConnection()
	 * @generated
	 */
	int ADAPTER_CONNECTION = 31;

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
	int EVENT = 32;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__COMMENT = NAMED_AND_COMMENTED__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NAME = NAMED_AND_COMMENTED__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TYPE = NAMED_AND_COMMENTED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = NAMED_AND_COMMENTED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.IFInputEventImpl <em>IF Input Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.IFInputEventImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFInputEvent()
	 * @generated
	 */
	int IF_INPUT_EVENT = 33;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INPUT_EVENT__COMMENT = EVENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INPUT_EVENT__NAME = EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INPUT_EVENT__TYPE = EVENT__TYPE;

	/**
	 * The feature id for the '<em><b>With</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INPUT_EVENT__WITH = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IF Input Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INPUT_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBInputEventImpl <em>FB Input Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBInputEventImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBInputEvent()
	 * @generated
	 */
	int FB_INPUT_EVENT = 34;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INPUT_EVENT__COMMENT = EVENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INPUT_EVENT__NAME = EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INPUT_EVENT__TYPE = EVENT__TYPE;

	/**
	 * The number of structural features of the '<em>FB Input Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INPUT_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.IFOutputEventImpl <em>IF Output Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.IFOutputEventImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFOutputEvent()
	 * @generated
	 */
	int IF_OUTPUT_EVENT = 35;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OUTPUT_EVENT__COMMENT = EVENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OUTPUT_EVENT__NAME = EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OUTPUT_EVENT__TYPE = EVENT__TYPE;

	/**
	 * The feature id for the '<em><b>With</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OUTPUT_EVENT__WITH = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IF Output Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OUTPUT_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBOutputEventImpl <em>FB Output Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBOutputEventImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBOutputEvent()
	 * @generated
	 */
	int FB_OUTPUT_EVENT = 36;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_OUTPUT_EVENT__COMMENT = EVENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_OUTPUT_EVENT__NAME = EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_OUTPUT_EVENT__TYPE = EVENT__TYPE;

	/**
	 * The number of structural features of the '<em>FB Output Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_OUTPUT_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.VarImpl <em>Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.VarImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getVar()
	 * @generated
	 */
	int VAR = 37;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__COMMENT = NAMED_AND_COMMENTED__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__NAME = NAMED_AND_COMMENTED__NAME;

	/**
	 * The feature id for the '<em><b>Array Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__ARRAY_SIZE = NAMED_AND_COMMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__INITIAL_VALUE = NAMED_AND_COMMENTED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__TYPE = NAMED_AND_COMMENTED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_FEATURE_COUNT = NAMED_AND_COMMENTED_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.IFInputVarImpl <em>IF Input Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.IFInputVarImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFInputVar()
	 * @generated
	 */
	int IF_INPUT_VAR = 38;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INPUT_VAR__COMMENT = VAR__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INPUT_VAR__NAME = VAR__NAME;

	/**
	 * The feature id for the '<em><b>Array Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INPUT_VAR__ARRAY_SIZE = VAR__ARRAY_SIZE;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INPUT_VAR__INITIAL_VALUE = VAR__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INPUT_VAR__TYPE = VAR__TYPE;

	/**
	 * The number of structural features of the '<em>IF Input Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INPUT_VAR_FEATURE_COUNT = VAR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBInputVarImpl <em>FB Input Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBInputVarImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBInputVar()
	 * @generated
	 */
	int FB_INPUT_VAR = 39;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INPUT_VAR__COMMENT = VAR__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INPUT_VAR__NAME = VAR__NAME;

	/**
	 * The feature id for the '<em><b>Array Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INPUT_VAR__ARRAY_SIZE = VAR__ARRAY_SIZE;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INPUT_VAR__INITIAL_VALUE = VAR__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INPUT_VAR__TYPE = VAR__TYPE;

	/**
	 * The number of structural features of the '<em>FB Input Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_INPUT_VAR_FEATURE_COUNT = VAR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.IFOutputVarImpl <em>IF Output Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.IFOutputVarImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFOutputVar()
	 * @generated
	 */
	int IF_OUTPUT_VAR = 40;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OUTPUT_VAR__COMMENT = VAR__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OUTPUT_VAR__NAME = VAR__NAME;

	/**
	 * The feature id for the '<em><b>Array Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OUTPUT_VAR__ARRAY_SIZE = VAR__ARRAY_SIZE;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OUTPUT_VAR__INITIAL_VALUE = VAR__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OUTPUT_VAR__TYPE = VAR__TYPE;

	/**
	 * The number of structural features of the '<em>IF Output Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OUTPUT_VAR_FEATURE_COUNT = VAR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.FBOutputVarImpl <em>FB Output Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.FBOutputVarImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBOutputVar()
	 * @generated
	 */
	int FB_OUTPUT_VAR = 41;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_OUTPUT_VAR__COMMENT = VAR__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_OUTPUT_VAR__NAME = VAR__NAME;

	/**
	 * The feature id for the '<em><b>Array Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_OUTPUT_VAR__ARRAY_SIZE = VAR__ARRAY_SIZE;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_OUTPUT_VAR__INITIAL_VALUE = VAR__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_OUTPUT_VAR__TYPE = VAR__TYPE;

	/**
	 * The number of structural features of the '<em>FB Output Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FB_OUTPUT_VAR_FEATURE_COUNT = VAR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.InternalVarImpl <em>Internal Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.InternalVarImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getInternalVar()
	 * @generated
	 */
	int INTERNAL_VAR = 42;

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
	int COMPILER = 43;

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
	int WITH = 44;

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
	int INPUT_WITH = 45;

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
	int OUTPUT_WITH = 46;

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
	int ADAPTER = 47;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__COMMENT = NAMED_AND_COMMENTED__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__NAME = NAMED_AND_COMMENTED__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__PARAMETERS = NAMED_AND_COMMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__TYPE = NAMED_AND_COMMENTED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_FEATURE_COUNT = NAMED_AND_COMMENTED_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.SocketImpl <em>Socket</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.SocketImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getSocket()
	 * @generated
	 */
	int SOCKET = 48;

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
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKET__PARAMETERS = ADAPTER__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKET__TYPE = ADAPTER__TYPE;

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
	int PLUG = 49;

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
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUG__PARAMETERS = ADAPTER__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUG__TYPE = ADAPTER__TYPE;

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
	int ADAPTER_TYPE = 50;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__IDENTIFICATION = COMPILABLE__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Version Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__VERSION_INFOS = COMPILABLE__VERSION_INFOS;

	/**
	 * The feature id for the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__COMPILER_INFO = COMPILABLE__COMPILER_INFO;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__COMMENT = COMPILABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__NAME = COMPILABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__INPUT_EVENTS = COMPILABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Output Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__OUTPUT_EVENTS = COMPILABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Input Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__INPUT_VARS = COMPILABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Output Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__OUTPUT_VARS = COMPILABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Sockets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__SOCKETS = COMPILABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Plugs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__PLUGS = COMPILABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE__SERVICE = COMPILABLE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Adapter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_TYPE_FEATURE_COUNT = COMPILABLE_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.ServiceImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 51;

	/**
	 * The feature id for the '<em><b>Service Sequences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_SEQUENCES = 0;

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
	int SERVICE_SEQUENCE = 52;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SEQUENCE__COMMENT = NAMED_AND_COMMENTED__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SEQUENCE__NAME = NAMED_AND_COMMENTED__NAME;

	/**
	 * The feature id for the '<em><b>Service Transactions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SEQUENCE__SERVICE_TRANSACTIONS = NAMED_AND_COMMENTED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Service Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SEQUENCE_FEATURE_COUNT = NAMED_AND_COMMENTED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.ServiceTransactionImpl <em>Service Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.ServiceTransactionImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getServiceTransaction()
	 * @generated
	 */
	int SERVICE_TRANSACTION = 53;

	/**
	 * The feature id for the '<em><b>Input Primitive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TRANSACTION__INPUT_PRIMITIVE = 0;

	/**
	 * The feature id for the '<em><b>Output Primitives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TRANSACTION__OUTPUT_PRIMITIVES = 1;

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
	int PRIMITIVE = 54;

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
	int INPUT_PRIMITIVE = 55;

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
	int OUTPUT_PRIMITIVE = 56;

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
	int BFB_TYPE = 57;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__IDENTIFICATION = FB_TYPE__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Version Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__VERSION_INFOS = FB_TYPE__VERSION_INFOS;

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
	 * The feature id for the '<em><b>Function Block Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__FUNCTION_BLOCK_DIAGRAMS = FB_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>STs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__STS = FB_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ladder Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFB_TYPE__LADDER_DIAGRAMS = FB_TYPE_FEATURE_COUNT + 5;

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
	int FBD = 58;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBD__COMMENT = NAMED_AND_COMMENTED__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBD__NAME = NAMED_AND_COMMENTED__NAME;

	/**
	 * The feature id for the '<em><b>FBs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBD__FBS = NAMED_AND_COMMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBD__DATA_CONNECTIONS = NAMED_AND_COMMENTED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>FBD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FBD_FEATURE_COUNT = NAMED_AND_COMMENTED_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.STImpl <em>ST</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.STImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getST()
	 * @generated
	 */
	int ST = 59;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ST__COMMENT = NAMED_AND_COMMENTED__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ST__NAME = NAMED_AND_COMMENTED__NAME;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ST__TEXT = NAMED_AND_COMMENTED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ST</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ST_FEATURE_COUNT = NAMED_AND_COMMENTED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.LDImpl <em>LD</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.LDImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getLD()
	 * @generated
	 */
	int LD = 60;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LD__COMMENT = NAMED_AND_COMMENTED__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LD__NAME = NAMED_AND_COMMENTED__NAME;

	/**
	 * The feature id for the '<em><b>Rungs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LD__RUNGS = NAMED_AND_COMMENTED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>LD</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LD_FEATURE_COUNT = NAMED_AND_COMMENTED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.OtherImpl <em>Other</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.OtherImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getOther()
	 * @generated
	 */
	int OTHER = 61;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER__COMMENT = NAMED_AND_COMMENTED__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER__NAME = NAMED_AND_COMMENTED__NAME;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER__LANGUAGE = NAMED_AND_COMMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Prototype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER__PROTOTYPE = NAMED_AND_COMMENTED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER__TEXT = NAMED_AND_COMMENTED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Other</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_FEATURE_COUNT = NAMED_AND_COMMENTED_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.RungImpl <em>Rung</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.RungImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getRung()
	 * @generated
	 */
	int RUNG = 62;

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
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.CFBTypeImpl <em>CFB Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.CFBTypeImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getCFBType()
	 * @generated
	 */
	int CFB_TYPE = 63;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__IDENTIFICATION = FB_TYPE__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Version Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__VERSION_INFOS = FB_TYPE__VERSION_INFOS;

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
	 * The feature id for the '<em><b>FBs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__FBS = FB_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__EVENT_CONNECTIONS = FB_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__DATA_CONNECTIONS = FB_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Adapter Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__ADAPTER_CONNECTIONS = FB_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE__SERVICE = FB_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>CFB Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFB_TYPE_FEATURE_COUNT = FB_TYPE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.DeviceTypeImpl <em>Device Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.DeviceTypeImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getDeviceType()
	 * @generated
	 */
	int DEVICE_TYPE = 64;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__IDENTIFICATION = COMPILABLE__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Version Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__VERSION_INFOS = COMPILABLE__VERSION_INFOS;

	/**
	 * The feature id for the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__COMPILER_INFO = COMPILABLE__COMPILER_INFO;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__COMMENT = COMPILABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__NAME = COMPILABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Var Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__VAR_DECLARATIONS = COMPILABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__RESOURCES = COMPILABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>FB Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__FB_NETWORK = COMPILABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Resource Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__RESOURCE_NAMES = COMPILABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Device Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE_FEATURE_COUNT = COMPILABLE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.ResourceTypeImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getResourceType()
	 * @generated
	 */
	int RESOURCE_TYPE = 65;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__IDENTIFICATION = COMPILABLE__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Version Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__VERSION_INFOS = COMPILABLE__VERSION_INFOS;

	/**
	 * The feature id for the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__COMPILER_INFO = COMPILABLE__COMPILER_INFO;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__COMMENT = COMPILABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__NAME = COMPILABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Var Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__VAR_DECLARATIONS = COMPILABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>FB Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__FB_NETWORK = COMPILABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>FB Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__FB_NAMES = COMPILABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_FEATURE_COUNT = COMPILABLE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.impl.BFBDiagramImpl <em>BFB Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.impl.BFBDiagramImpl
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getBFBDiagram()
	 * @generated
	 */
	int BFB_DIAGRAM = 66;

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
	int CFB_DIAGRAM = 67;

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
	int SEGMENT_TYPE = 71;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.Language <em>Language</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.Language
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getLanguage()
	 * @generated
	 */
	int LANGUAGE = 72;

	/**
	 * The meta object id for the '{@link de.cau.cs.kieler.cakefeed.VarType <em>Var Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.cau.cs.kieler.cakefeed.VarType
	 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getVarType()
	 * @generated
	 */
	int VAR_TYPE = 73;


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
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.System#getApplications <em>Applications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Applications</em>'.
	 * @see de.cau.cs.kieler.cakefeed.System#getApplications()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Applications();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.System#getDevices <em>Devices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Devices</em>'.
	 * @see de.cau.cs.kieler.cakefeed.System#getDevices()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Devices();

	/**
	 * Returns the meta object for the reference list '{@link de.cau.cs.kieler.cakefeed.System#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mappings</em>'.
	 * @see de.cau.cs.kieler.cakefeed.System#getMappings()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Mappings();

	/**
	 * Returns the meta object for the reference list '{@link de.cau.cs.kieler.cakefeed.System#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Segments</em>'.
	 * @see de.cau.cs.kieler.cakefeed.System#getSegments()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Segments();

	/**
	 * Returns the meta object for the reference list '{@link de.cau.cs.kieler.cakefeed.System#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Links</em>'.
	 * @see de.cau.cs.kieler.cakefeed.System#getLinks()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Links();

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
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.Application#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>FB Network</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Application#getFBNetwork()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_FBNetwork();

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
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBNetwork#getFBs <em>FBs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>FBs</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBNetwork#getFBs()
	 * @see #getFBNetwork()
	 * @generated
	 */
	EReference getFBNetwork_FBs();

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
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.Device#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Device#getParameters()
	 * @see #getDevice()
	 * @generated
	 */
	EReference getDevice_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.Device#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Device#getResources()
	 * @see #getDevice()
	 * @generated
	 */
	EReference getDevice_Resources();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.Device#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>FB Network</em>'.
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
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.Segment#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Segment#getParameters()
	 * @see #getSegment()
	 * @generated
	 */
	EReference getSegment_Parameters();

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
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.Link#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Link#getParameters()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Link#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Link#getComment()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Link#getCommResource <em>Comm Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comm Resource</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Link#getCommResource()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_CommResource();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Link#getSegmentName <em>Segment Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Segment Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Link#getSegmentName()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_SegmentName();

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
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FB#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FB#getParameters()
	 * @see #getFB()
	 * @generated
	 */
	EReference getFB_Parameters();

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
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FB#getInputEvents <em>Input Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Events</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FB#getInputEvents()
	 * @see #getFB()
	 * @generated
	 */
	EReference getFB_InputEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FB#getOutputEvents <em>Output Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Events</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FB#getOutputEvents()
	 * @see #getFB()
	 * @generated
	 */
	EReference getFB_OutputEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FB#getInputVars <em>Input Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Vars</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FB#getInputVars()
	 * @see #getFB()
	 * @generated
	 */
	EReference getFB_InputVars();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FB#getOutputVars <em>Output Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Vars</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FB#getOutputVars()
	 * @see #getFB()
	 * @generated
	 */
	EReference getFB_OutputVars();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.FBInterface <em>FB Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FB Interface</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBInterface
	 * @generated
	 */
	EClass getFBInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBInterface#getInputEvents <em>Input Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Events</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBInterface#getInputEvents()
	 * @see #getFBInterface()
	 * @generated
	 */
	EReference getFBInterface_InputEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBInterface#getOutputEvents <em>Output Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Events</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBInterface#getOutputEvents()
	 * @see #getFBInterface()
	 * @generated
	 */
	EReference getFBInterface_OutputEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBInterface#getInputVars <em>Input Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Vars</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBInterface#getInputVars()
	 * @see #getFBInterface()
	 * @generated
	 */
	EReference getFBInterface_InputVars();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBInterface#getOutputVars <em>Output Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Vars</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBInterface#getOutputVars()
	 * @see #getFBInterface()
	 * @generated
	 */
	EReference getFBInterface_OutputVars();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBInterface#getSockets <em>Sockets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sockets</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBInterface#getSockets()
	 * @see #getFBInterface()
	 * @generated
	 */
	EReference getFBInterface_Sockets();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBInterface#getPlugs <em>Plugs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Plugs</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBInterface#getPlugs()
	 * @see #getFBInterface()
	 * @generated
	 */
	EReference getFBInterface_Plugs();

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
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.Resource#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Resource#getParameters()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Parameters();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.Resource#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>FB Network</em>'.
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
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.FBType <em>FB Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FB Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBType
	 * @generated
	 */
	EClass getFBType();

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
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.EventConnection <em>Event Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.EventConnection
	 * @generated
	 */
	EClass getEventConnection();

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
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.CompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compiler Info</em>'.
	 * @see de.cau.cs.kieler.cakefeed.CompilerInfo
	 * @generated
	 */
	EClass getCompilerInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.CompilerInfo#getCompilers <em>Compilers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Compilers</em>'.
	 * @see de.cau.cs.kieler.cakefeed.CompilerInfo#getCompilers()
	 * @see #getCompilerInfo()
	 * @generated
	 */
	EReference getCompilerInfo_Compilers();

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
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.IFIFEventConnection <em>IFIF Event Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IFIF Event Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFIFEventConnection
	 * @generated
	 */
	EClass getIFIFEventConnection();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IFIFEventConnection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFIFEventConnection#getDestination()
	 * @see #getIFIFEventConnection()
	 * @generated
	 */
	EReference getIFIFEventConnection_Destination();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IFIFEventConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFIFEventConnection#getSource()
	 * @see #getIFIFEventConnection()
	 * @generated
	 */
	EReference getIFIFEventConnection_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.IFIFDataConnection <em>IFIF Data Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IFIF Data Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFIFDataConnection
	 * @generated
	 */
	EClass getIFIFDataConnection();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IFIFDataConnection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFIFDataConnection#getDestination()
	 * @see #getIFIFDataConnection()
	 * @generated
	 */
	EReference getIFIFDataConnection_Destination();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IFIFDataConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFIFDataConnection#getSource()
	 * @see #getIFIFDataConnection()
	 * @generated
	 */
	EReference getIFIFDataConnection_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.IFFBEventConnection <em>IFFB Event Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IFFB Event Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFFBEventConnection
	 * @generated
	 */
	EClass getIFFBEventConnection();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IFFBEventConnection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFFBEventConnection#getDestination()
	 * @see #getIFFBEventConnection()
	 * @generated
	 */
	EReference getIFFBEventConnection_Destination();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IFFBEventConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFFBEventConnection#getSource()
	 * @see #getIFFBEventConnection()
	 * @generated
	 */
	EReference getIFFBEventConnection_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.IFFBDataConnection <em>IFFB Data Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IFFB Data Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFFBDataConnection
	 * @generated
	 */
	EClass getIFFBDataConnection();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IFFBDataConnection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFFBDataConnection#getDestination()
	 * @see #getIFFBDataConnection()
	 * @generated
	 */
	EReference getIFFBDataConnection_Destination();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IFFBDataConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFFBDataConnection#getSource()
	 * @see #getIFFBDataConnection()
	 * @generated
	 */
	EReference getIFFBDataConnection_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.FBIFEventConnection <em>FBIF Event Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FBIF Event Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBIFEventConnection
	 * @generated
	 */
	EClass getFBIFEventConnection();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.FBIFEventConnection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBIFEventConnection#getDestination()
	 * @see #getFBIFEventConnection()
	 * @generated
	 */
	EReference getFBIFEventConnection_Destination();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.FBIFEventConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBIFEventConnection#getSource()
	 * @see #getFBIFEventConnection()
	 * @generated
	 */
	EReference getFBIFEventConnection_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.FBIFDataConnection <em>FBIF Data Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FBIF Data Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBIFDataConnection
	 * @generated
	 */
	EClass getFBIFDataConnection();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.FBIFDataConnection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBIFDataConnection#getDestination()
	 * @see #getFBIFDataConnection()
	 * @generated
	 */
	EReference getFBIFDataConnection_Destination();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.FBIFDataConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBIFDataConnection#getSource()
	 * @see #getFBIFDataConnection()
	 * @generated
	 */
	EReference getFBIFDataConnection_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.FBFBEventConnection <em>FBFB Event Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FBFB Event Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBFBEventConnection
	 * @generated
	 */
	EClass getFBFBEventConnection();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.FBFBEventConnection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBFBEventConnection#getDestination()
	 * @see #getFBFBEventConnection()
	 * @generated
	 */
	EReference getFBFBEventConnection_Destination();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.FBFBEventConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBFBEventConnection#getSource()
	 * @see #getFBFBEventConnection()
	 * @generated
	 */
	EReference getFBFBEventConnection_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.FBFBDataConnection <em>FBFB Data Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FBFB Data Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBFBDataConnection
	 * @generated
	 */
	EClass getFBFBDataConnection();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.FBFBDataConnection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBFBDataConnection#getDestination()
	 * @see #getFBFBDataConnection()
	 * @generated
	 */
	EReference getFBFBDataConnection_Destination();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.FBFBDataConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBFBDataConnection#getSource()
	 * @see #getFBFBDataConnection()
	 * @generated
	 */
	EReference getFBFBDataConnection_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.IFIVDataConnection <em>IFIV Data Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IFIV Data Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFIVDataConnection
	 * @generated
	 */
	EClass getIFIVDataConnection();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IFIVDataConnection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFIVDataConnection#getDestination()
	 * @see #getIFIVDataConnection()
	 * @generated
	 */
	EReference getIFIVDataConnection_Destination();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IFIVDataConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFIVDataConnection#getSource()
	 * @see #getIFIVDataConnection()
	 * @generated
	 */
	EReference getIFIVDataConnection_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.IVIFDataConnection <em>IVIF Data Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IVIF Data Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IVIFDataConnection
	 * @generated
	 */
	EClass getIVIFDataConnection();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IVIFDataConnection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IVIFDataConnection#getDestination()
	 * @see #getIVIFDataConnection()
	 * @generated
	 */
	EReference getIVIFDataConnection_Destination();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IVIFDataConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IVIFDataConnection#getSource()
	 * @see #getIVIFDataConnection()
	 * @generated
	 */
	EReference getIVIFDataConnection_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.FBIVDataConnection <em>FBIV Data Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FBIV Data Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBIVDataConnection
	 * @generated
	 */
	EClass getFBIVDataConnection();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.FBIVDataConnection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBIVDataConnection#getDestination()
	 * @see #getFBIVDataConnection()
	 * @generated
	 */
	EReference getFBIVDataConnection_Destination();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.FBIVDataConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBIVDataConnection#getSource()
	 * @see #getFBIVDataConnection()
	 * @generated
	 */
	EReference getFBIVDataConnection_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.IVFBDataConnection <em>IVFB Data Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IVFB Data Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IVFBDataConnection
	 * @generated
	 */
	EClass getIVFBDataConnection();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IVFBDataConnection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IVFBDataConnection#getDestination()
	 * @see #getIVFBDataConnection()
	 * @generated
	 */
	EReference getIVFBDataConnection_Destination();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IVFBDataConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IVFBDataConnection#getSource()
	 * @see #getIVFBDataConnection()
	 * @generated
	 */
	EReference getIVFBDataConnection_Source();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.IVIVDataConnection <em>IVIV Data Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IVIV Data Connection</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IVIVDataConnection
	 * @generated
	 */
	EClass getIVIVDataConnection();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IVIVDataConnection#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IVIVDataConnection#getDestination()
	 * @see #getIVIVDataConnection()
	 * @generated
	 */
	EReference getIVIVDataConnection_Destination();

	/**
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.IVIVDataConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IVIVDataConnection#getSource()
	 * @see #getIVIVDataConnection()
	 * @generated
	 */
	EReference getIVIVDataConnection_Source();

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
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.IFInputEvent <em>IF Input Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IF Input Event</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFInputEvent
	 * @generated
	 */
	EClass getIFInputEvent();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.IFInputEvent#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>With</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFInputEvent#getWith()
	 * @see #getIFInputEvent()
	 * @generated
	 */
	EReference getIFInputEvent_With();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.FBInputEvent <em>FB Input Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FB Input Event</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBInputEvent
	 * @generated
	 */
	EClass getFBInputEvent();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.IFOutputEvent <em>IF Output Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IF Output Event</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFOutputEvent
	 * @generated
	 */
	EClass getIFOutputEvent();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.IFOutputEvent#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>With</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFOutputEvent#getWith()
	 * @see #getIFOutputEvent()
	 * @generated
	 */
	EReference getIFOutputEvent_With();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.FBOutputEvent <em>FB Output Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FB Output Event</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBOutputEvent
	 * @generated
	 */
	EClass getFBOutputEvent();

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
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.IFInputVar <em>IF Input Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IF Input Var</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFInputVar
	 * @generated
	 */
	EClass getIFInputVar();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.FBInputVar <em>FB Input Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FB Input Var</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBInputVar
	 * @generated
	 */
	EClass getFBInputVar();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.IFOutputVar <em>IF Output Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IF Output Var</em>'.
	 * @see de.cau.cs.kieler.cakefeed.IFOutputVar
	 * @generated
	 */
	EClass getIFOutputVar();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.FBOutputVar <em>FB Output Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FB Output Var</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBOutputVar
	 * @generated
	 */
	EClass getFBOutputVar();

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
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.Adapter#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Adapter#getParameters()
	 * @see #getAdapter()
	 * @generated
	 */
	EReference getAdapter_Parameters();

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
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.Service#getServiceSequences <em>Service Sequences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Sequences</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Service#getServiceSequences()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_ServiceSequences();

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
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.ServiceSequence#getServiceTransactions <em>Service Transactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Transactions</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ServiceSequence#getServiceTransactions()
	 * @see #getServiceSequence()
	 * @generated
	 */
	EReference getServiceSequence_ServiceTransactions();

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
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.ServiceTransaction#getOutputPrimitives <em>Output Primitives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Primitives</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ServiceTransaction#getOutputPrimitives()
	 * @see #getServiceTransaction()
	 * @generated
	 */
	EReference getServiceTransaction_OutputPrimitives();

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
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.BFBType#getFunctionBlockDiagrams <em>Function Block Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Function Block Diagrams</em>'.
	 * @see de.cau.cs.kieler.cakefeed.BFBType#getFunctionBlockDiagrams()
	 * @see #getBFBType()
	 * @generated
	 */
	EReference getBFBType_FunctionBlockDiagrams();

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
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.BFBType#getLadderDiagrams <em>Ladder Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ladder Diagrams</em>'.
	 * @see de.cau.cs.kieler.cakefeed.BFBType#getLadderDiagrams()
	 * @see #getBFBType()
	 * @generated
	 */
	EReference getBFBType_LadderDiagrams();

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
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.FBD#getFBs <em>FBs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>FBs</em>'.
	 * @see de.cau.cs.kieler.cakefeed.FBD#getFBs()
	 * @see #getFBD()
	 * @generated
	 */
	EReference getFBD_FBs();

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
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.LD <em>LD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LD</em>'.
	 * @see de.cau.cs.kieler.cakefeed.LD
	 * @generated
	 */
	EClass getLD();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.LD#getRungs <em>Rungs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rungs</em>'.
	 * @see de.cau.cs.kieler.cakefeed.LD#getRungs()
	 * @see #getLD()
	 * @generated
	 */
	EReference getLD_Rungs();

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
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.Rung#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Rung#getOutput()
	 * @see #getRung()
	 * @generated
	 */
	EAttribute getRung_Output();

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
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.DeviceType#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>FB Network</em>'.
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
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.ResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Type</em>'.
	 * @see de.cau.cs.kieler.cakefeed.ResourceType
	 * @generated
	 */
	EClass getResourceType();

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
	 * Returns the meta object for the reference '{@link de.cau.cs.kieler.cakefeed.ResourceType#getFBNetwork <em>FB Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>FB Network</em>'.
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
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.NamedAndCommented <em>Named And Commented</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named And Commented</em>'.
	 * @see de.cau.cs.kieler.cakefeed.NamedAndCommented
	 * @generated
	 */
	EClass getNamedAndCommented();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.NamedAndCommented#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.cau.cs.kieler.cakefeed.NamedAndCommented#getComment()
	 * @see #getNamedAndCommented()
	 * @generated
	 */
	EAttribute getNamedAndCommented_Comment();

	/**
	 * Returns the meta object for the attribute '{@link de.cau.cs.kieler.cakefeed.NamedAndCommented#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.cau.cs.kieler.cakefeed.NamedAndCommented#getName()
	 * @see #getNamedAndCommented()
	 * @generated
	 */
	EAttribute getNamedAndCommented_Name();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Identifiable
	 * @generated
	 */
	EClass getIdentifiable();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.Identifiable#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identification</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Identifiable#getIdentification()
	 * @see #getIdentifiable()
	 * @generated
	 */
	EReference getIdentifiable_Identification();

	/**
	 * Returns the meta object for the containment reference list '{@link de.cau.cs.kieler.cakefeed.Identifiable#getVersionInfos <em>Version Infos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version Infos</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Identifiable#getVersionInfos()
	 * @see #getIdentifiable()
	 * @generated
	 */
	EReference getIdentifiable_VersionInfos();

	/**
	 * Returns the meta object for class '{@link de.cau.cs.kieler.cakefeed.Compilable <em>Compilable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compilable</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Compilable
	 * @generated
	 */
	EClass getCompilable();

	/**
	 * Returns the meta object for the containment reference '{@link de.cau.cs.kieler.cakefeed.Compilable#getCompilerInfo <em>Compiler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compiler Info</em>'.
	 * @see de.cau.cs.kieler.cakefeed.Compilable#getCompilerInfo()
	 * @see #getCompilable()
	 * @generated
	 */
	EReference getCompilable_CompilerInfo();

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
		 * The meta object literal for the '<em><b>Applications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__APPLICATIONS = eINSTANCE.getSystem_Applications();

		/**
		 * The meta object literal for the '<em><b>Devices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__DEVICES = eINSTANCE.getSystem_Devices();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__MAPPINGS = eINSTANCE.getSystem_Mappings();

		/**
		 * The meta object literal for the '<em><b>Segments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__SEGMENTS = eINSTANCE.getSystem_Segments();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__LINKS = eINSTANCE.getSystem_Links();

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
		 * The meta object literal for the '<em><b>FB Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__FB_NETWORK = eINSTANCE.getApplication_FBNetwork();

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
		 * The meta object literal for the '<em><b>FBs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_NETWORK__FBS = eINSTANCE.getFBNetwork_FBs();

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
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE__PARAMETERS = eINSTANCE.getDevice_Parameters();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE__RESOURCES = eINSTANCE.getDevice_Resources();

		/**
		 * The meta object literal for the '<em><b>FB Network</b></em>' reference feature.
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
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEGMENT__PARAMETERS = eINSTANCE.getSegment_Parameters();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__TYPE = eINSTANCE.getSegment_Type();

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
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__PARAMETERS = eINSTANCE.getLink_Parameters();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBImpl <em>FB</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFB()
		 * @generated
		 */
		EClass FB = eINSTANCE.getFB();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB__PARAMETERS = eINSTANCE.getFB_Parameters();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB__TYPE = eINSTANCE.getFB_Type();

		/**
		 * The meta object literal for the '<em><b>Input Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB__INPUT_EVENTS = eINSTANCE.getFB_InputEvents();

		/**
		 * The meta object literal for the '<em><b>Output Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB__OUTPUT_EVENTS = eINSTANCE.getFB_OutputEvents();

		/**
		 * The meta object literal for the '<em><b>Input Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB__INPUT_VARS = eINSTANCE.getFB_InputVars();

		/**
		 * The meta object literal for the '<em><b>Output Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB__OUTPUT_VARS = eINSTANCE.getFB_OutputVars();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBInterfaceImpl <em>FB Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBInterfaceImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBInterface()
		 * @generated
		 */
		EClass FB_INTERFACE = eINSTANCE.getFBInterface();

		/**
		 * The meta object literal for the '<em><b>Input Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_INTERFACE__INPUT_EVENTS = eINSTANCE.getFBInterface_InputEvents();

		/**
		 * The meta object literal for the '<em><b>Output Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_INTERFACE__OUTPUT_EVENTS = eINSTANCE.getFBInterface_OutputEvents();

		/**
		 * The meta object literal for the '<em><b>Input Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_INTERFACE__INPUT_VARS = eINSTANCE.getFBInterface_InputVars();

		/**
		 * The meta object literal for the '<em><b>Output Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_INTERFACE__OUTPUT_VARS = eINSTANCE.getFBInterface_OutputVars();

		/**
		 * The meta object literal for the '<em><b>Sockets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_INTERFACE__SOCKETS = eINSTANCE.getFBInterface_Sockets();

		/**
		 * The meta object literal for the '<em><b>Plugs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FB_INTERFACE__PLUGS = eINSTANCE.getFBInterface_Plugs();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.ResourceImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__PARAMETERS = eINSTANCE.getResource_Parameters();

		/**
		 * The meta object literal for the '<em><b>FB Network</b></em>' reference feature.
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBTypeImpl <em>FB Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBTypeImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBType()
		 * @generated
		 */
		EClass FB_TYPE = eINSTANCE.getFBType();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.EventConnectionImpl <em>Event Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.EventConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getEventConnection()
		 * @generated
		 */
		EClass EVENT_CONNECTION = eINSTANCE.getEventConnection();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.CompilerInfoImpl <em>Compiler Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.CompilerInfoImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getCompilerInfo()
		 * @generated
		 */
		EClass COMPILER_INFO = eINSTANCE.getCompilerInfo();

		/**
		 * The meta object literal for the '<em><b>Compilers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPILER_INFO__COMPILERS = eINSTANCE.getCompilerInfo_Compilers();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.IFIFEventConnectionImpl <em>IFIF Event Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.IFIFEventConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFIFEventConnection()
		 * @generated
		 */
		EClass IFIF_EVENT_CONNECTION = eINSTANCE.getIFIFEventConnection();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IFIF_EVENT_CONNECTION__DESTINATION = eINSTANCE.getIFIFEventConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IFIF_EVENT_CONNECTION__SOURCE = eINSTANCE.getIFIFEventConnection_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.IFIFDataConnectionImpl <em>IFIF Data Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.IFIFDataConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFIFDataConnection()
		 * @generated
		 */
		EClass IFIF_DATA_CONNECTION = eINSTANCE.getIFIFDataConnection();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IFIF_DATA_CONNECTION__DESTINATION = eINSTANCE.getIFIFDataConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IFIF_DATA_CONNECTION__SOURCE = eINSTANCE.getIFIFDataConnection_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.IFFBEventConnectionImpl <em>IFFB Event Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.IFFBEventConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFFBEventConnection()
		 * @generated
		 */
		EClass IFFB_EVENT_CONNECTION = eINSTANCE.getIFFBEventConnection();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IFFB_EVENT_CONNECTION__DESTINATION = eINSTANCE.getIFFBEventConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IFFB_EVENT_CONNECTION__SOURCE = eINSTANCE.getIFFBEventConnection_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.IFFBDataConnectionImpl <em>IFFB Data Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.IFFBDataConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFFBDataConnection()
		 * @generated
		 */
		EClass IFFB_DATA_CONNECTION = eINSTANCE.getIFFBDataConnection();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IFFB_DATA_CONNECTION__DESTINATION = eINSTANCE.getIFFBDataConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IFFB_DATA_CONNECTION__SOURCE = eINSTANCE.getIFFBDataConnection_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBIFEventConnectionImpl <em>FBIF Event Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBIFEventConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBIFEventConnection()
		 * @generated
		 */
		EClass FBIF_EVENT_CONNECTION = eINSTANCE.getFBIFEventConnection();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FBIF_EVENT_CONNECTION__DESTINATION = eINSTANCE.getFBIFEventConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FBIF_EVENT_CONNECTION__SOURCE = eINSTANCE.getFBIFEventConnection_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBIFDataConnectionImpl <em>FBIF Data Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBIFDataConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBIFDataConnection()
		 * @generated
		 */
		EClass FBIF_DATA_CONNECTION = eINSTANCE.getFBIFDataConnection();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FBIF_DATA_CONNECTION__DESTINATION = eINSTANCE.getFBIFDataConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FBIF_DATA_CONNECTION__SOURCE = eINSTANCE.getFBIFDataConnection_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBFBEventConnectionImpl <em>FBFB Event Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBFBEventConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBFBEventConnection()
		 * @generated
		 */
		EClass FBFB_EVENT_CONNECTION = eINSTANCE.getFBFBEventConnection();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FBFB_EVENT_CONNECTION__DESTINATION = eINSTANCE.getFBFBEventConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FBFB_EVENT_CONNECTION__SOURCE = eINSTANCE.getFBFBEventConnection_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBFBDataConnectionImpl <em>FBFB Data Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBFBDataConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBFBDataConnection()
		 * @generated
		 */
		EClass FBFB_DATA_CONNECTION = eINSTANCE.getFBFBDataConnection();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FBFB_DATA_CONNECTION__DESTINATION = eINSTANCE.getFBFBDataConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FBFB_DATA_CONNECTION__SOURCE = eINSTANCE.getFBFBDataConnection_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.IFIVDataConnectionImpl <em>IFIV Data Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.IFIVDataConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFIVDataConnection()
		 * @generated
		 */
		EClass IFIV_DATA_CONNECTION = eINSTANCE.getIFIVDataConnection();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IFIV_DATA_CONNECTION__DESTINATION = eINSTANCE.getIFIVDataConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IFIV_DATA_CONNECTION__SOURCE = eINSTANCE.getIFIVDataConnection_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.IVIFDataConnectionImpl <em>IVIF Data Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.IVIFDataConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIVIFDataConnection()
		 * @generated
		 */
		EClass IVIF_DATA_CONNECTION = eINSTANCE.getIVIFDataConnection();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IVIF_DATA_CONNECTION__DESTINATION = eINSTANCE.getIVIFDataConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IVIF_DATA_CONNECTION__SOURCE = eINSTANCE.getIVIFDataConnection_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBIVDataConnectionImpl <em>FBIV Data Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBIVDataConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBIVDataConnection()
		 * @generated
		 */
		EClass FBIV_DATA_CONNECTION = eINSTANCE.getFBIVDataConnection();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FBIV_DATA_CONNECTION__DESTINATION = eINSTANCE.getFBIVDataConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FBIV_DATA_CONNECTION__SOURCE = eINSTANCE.getFBIVDataConnection_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.IVFBDataConnectionImpl <em>IVFB Data Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.IVFBDataConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIVFBDataConnection()
		 * @generated
		 */
		EClass IVFB_DATA_CONNECTION = eINSTANCE.getIVFBDataConnection();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IVFB_DATA_CONNECTION__DESTINATION = eINSTANCE.getIVFBDataConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IVFB_DATA_CONNECTION__SOURCE = eINSTANCE.getIVFBDataConnection_Source();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.IVIVDataConnectionImpl <em>IVIV Data Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.IVIVDataConnectionImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIVIVDataConnection()
		 * @generated
		 */
		EClass IVIV_DATA_CONNECTION = eINSTANCE.getIVIVDataConnection();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IVIV_DATA_CONNECTION__DESTINATION = eINSTANCE.getIVIVDataConnection_Destination();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IVIV_DATA_CONNECTION__SOURCE = eINSTANCE.getIVIVDataConnection_Source();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.IFInputEventImpl <em>IF Input Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.IFInputEventImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFInputEvent()
		 * @generated
		 */
		EClass IF_INPUT_EVENT = eINSTANCE.getIFInputEvent();

		/**
		 * The meta object literal for the '<em><b>With</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_INPUT_EVENT__WITH = eINSTANCE.getIFInputEvent_With();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBInputEventImpl <em>FB Input Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBInputEventImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBInputEvent()
		 * @generated
		 */
		EClass FB_INPUT_EVENT = eINSTANCE.getFBInputEvent();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.IFOutputEventImpl <em>IF Output Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.IFOutputEventImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFOutputEvent()
		 * @generated
		 */
		EClass IF_OUTPUT_EVENT = eINSTANCE.getIFOutputEvent();

		/**
		 * The meta object literal for the '<em><b>With</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_OUTPUT_EVENT__WITH = eINSTANCE.getIFOutputEvent_With();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBOutputEventImpl <em>FB Output Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBOutputEventImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBOutputEvent()
		 * @generated
		 */
		EClass FB_OUTPUT_EVENT = eINSTANCE.getFBOutputEvent();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.IFInputVarImpl <em>IF Input Var</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.IFInputVarImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFInputVar()
		 * @generated
		 */
		EClass IF_INPUT_VAR = eINSTANCE.getIFInputVar();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBInputVarImpl <em>FB Input Var</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBInputVarImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBInputVar()
		 * @generated
		 */
		EClass FB_INPUT_VAR = eINSTANCE.getFBInputVar();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.IFOutputVarImpl <em>IF Output Var</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.IFOutputVarImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIFOutputVar()
		 * @generated
		 */
		EClass IF_OUTPUT_VAR = eINSTANCE.getIFOutputVar();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.FBOutputVarImpl <em>FB Output Var</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.FBOutputVarImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getFBOutputVar()
		 * @generated
		 */
		EClass FB_OUTPUT_VAR = eINSTANCE.getFBOutputVar();

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
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER__PARAMETERS = eINSTANCE.getAdapter_Parameters();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER__TYPE = eINSTANCE.getAdapter_Type();

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
		 * The meta object literal for the '<em><b>Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_TYPE__SERVICE = eINSTANCE.getAdapterType_Service();

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
		 * The meta object literal for the '<em><b>Service Sequences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__SERVICE_SEQUENCES = eINSTANCE.getService_ServiceSequences();

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
		 * The meta object literal for the '<em><b>Service Transactions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_SEQUENCE__SERVICE_TRANSACTIONS = eINSTANCE.getServiceSequence_ServiceTransactions();

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
		 * The meta object literal for the '<em><b>Output Primitives</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_TRANSACTION__OUTPUT_PRIMITIVES = eINSTANCE.getServiceTransaction_OutputPrimitives();

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
		 * The meta object literal for the '<em><b>Function Block Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BFB_TYPE__FUNCTION_BLOCK_DIAGRAMS = eINSTANCE.getBFBType_FunctionBlockDiagrams();

		/**
		 * The meta object literal for the '<em><b>STs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BFB_TYPE__STS = eINSTANCE.getBFBType_STs();

		/**
		 * The meta object literal for the '<em><b>Ladder Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BFB_TYPE__LADDER_DIAGRAMS = eINSTANCE.getBFBType_LadderDiagrams();

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
		 * The meta object literal for the '<em><b>FBs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FBD__FBS = eINSTANCE.getFBD_FBs();

		/**
		 * The meta object literal for the '<em><b>Data Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FBD__DATA_CONNECTIONS = eINSTANCE.getFBD_DataConnections();

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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.LDImpl <em>LD</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.LDImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getLD()
		 * @generated
		 */
		EClass LD = eINSTANCE.getLD();

		/**
		 * The meta object literal for the '<em><b>Rungs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LD__RUNGS = eINSTANCE.getLD_Rungs();

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
		 * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNG__OUTPUT = eINSTANCE.getRung_Output();

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
		 * The meta object literal for the '<em><b>FB Network</b></em>' reference feature.
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.ResourceTypeImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getResourceType()
		 * @generated
		 */
		EClass RESOURCE_TYPE = eINSTANCE.getResourceType();

		/**
		 * The meta object literal for the '<em><b>Var Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE__VAR_DECLARATIONS = eINSTANCE.getResourceType_VarDeclarations();

		/**
		 * The meta object literal for the '<em><b>FB Network</b></em>' reference feature.
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
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.NamedAndCommentedImpl <em>Named And Commented</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.NamedAndCommentedImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getNamedAndCommented()
		 * @generated
		 */
		EClass NAMED_AND_COMMENTED = eINSTANCE.getNamedAndCommented();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_AND_COMMENTED__COMMENT = eINSTANCE.getNamedAndCommented_Comment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_AND_COMMENTED__NAME = eINSTANCE.getNamedAndCommented_Name();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.IdentifiableImpl <em>Identifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.IdentifiableImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getIdentifiable()
		 * @generated
		 */
		EClass IDENTIFIABLE = eINSTANCE.getIdentifiable();

		/**
		 * The meta object literal for the '<em><b>Identification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIABLE__IDENTIFICATION = eINSTANCE.getIdentifiable_Identification();

		/**
		 * The meta object literal for the '<em><b>Version Infos</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIABLE__VERSION_INFOS = eINSTANCE.getIdentifiable_VersionInfos();

		/**
		 * The meta object literal for the '{@link de.cau.cs.kieler.cakefeed.impl.CompilableImpl <em>Compilable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.cau.cs.kieler.cakefeed.impl.CompilableImpl
		 * @see de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl#getCompilable()
		 * @generated
		 */
		EClass COMPILABLE = eINSTANCE.getCompilable();

		/**
		 * The meta object literal for the '<em><b>Compiler Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPILABLE__COMPILER_INFO = eINSTANCE.getCompilable_CompilerInfo();

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
