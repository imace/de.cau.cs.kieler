/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed;

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
 * @see cakefeed.CakefeedFactory
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
	String eNS_URI = "http://kieler.cs.cau.de/cakefeed";

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
	CakefeedPackage eINSTANCE = cakefeed.impl.CakefeedPackageImpl.init();

	/**
	 * The meta object id for the '{@link cakefeed.impl.ApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.ApplicationImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getApplication()
	 * @generated
	 */
	int APPLICATION = 0;

	/**
	 * The feature id for the '<em><b>Application Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__APPLICATION_NAME = 0;

	/**
	 * The feature id for the '<em><b>Function Blocks Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__FUNCTION_BLOCKS_INSTANCES = 1;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__CONNECTIONS = 2;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link cakefeed.impl.FunctionBlockImpl <em>Function Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.FunctionBlockImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getFunctionBlock()
	 * @generated
	 */
	int FUNCTION_BLOCK = 1;

	/**
	 * The feature id for the '<em><b>Parent Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK__PARENT_INTERFACE = 0;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK__TYPE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Input Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK__INPUT_EVENT_PORTS = 2;

	/**
	 * The feature id for the '<em><b>Output Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK__OUTPUT_EVENT_PORTS = 3;

	/**
	 * The feature id for the '<em><b>Input Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK__INPUT_DATA_PORTS = 4;

	/**
	 * The feature id for the '<em><b>Output Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK__OUTPUT_DATA_PORTS = 5;

	/**
	 * The number of structural features of the '<em>Function Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link cakefeed.impl.BasicFunctionBlockImpl <em>Basic Function Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.BasicFunctionBlockImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getBasicFunctionBlock()
	 * @generated
	 */
	int BASIC_FUNCTION_BLOCK = 2;

	/**
	 * The feature id for the '<em><b>Parent Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK__PARENT_INTERFACE = FUNCTION_BLOCK__PARENT_INTERFACE;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK__TYPE_NAME = FUNCTION_BLOCK__TYPE_NAME;

	/**
	 * The feature id for the '<em><b>Input Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK__INPUT_EVENT_PORTS = FUNCTION_BLOCK__INPUT_EVENT_PORTS;

	/**
	 * The feature id for the '<em><b>Output Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK__OUTPUT_EVENT_PORTS = FUNCTION_BLOCK__OUTPUT_EVENT_PORTS;

	/**
	 * The feature id for the '<em><b>Input Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK__INPUT_DATA_PORTS = FUNCTION_BLOCK__INPUT_DATA_PORTS;

	/**
	 * The feature id for the '<em><b>Output Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK__OUTPUT_DATA_PORTS = FUNCTION_BLOCK__OUTPUT_DATA_PORTS;

	/**
	 * The feature id for the '<em><b>Execution Control Chart</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK__EXECUTION_CONTROL_CHART = FUNCTION_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Algorithms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK__ALGORITHMS = FUNCTION_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Basic Function Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK_FEATURE_COUNT = FUNCTION_BLOCK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cakefeed.impl.CompositeFunctionBlockImpl <em>Composite Function Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.CompositeFunctionBlockImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getCompositeFunctionBlock()
	 * @generated
	 */
	int COMPOSITE_FUNCTION_BLOCK = 3;

	/**
	 * The feature id for the '<em><b>Parent Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK__PARENT_INTERFACE = FUNCTION_BLOCK__PARENT_INTERFACE;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK__TYPE_NAME = FUNCTION_BLOCK__TYPE_NAME;

	/**
	 * The feature id for the '<em><b>Input Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK__INPUT_EVENT_PORTS = FUNCTION_BLOCK__INPUT_EVENT_PORTS;

	/**
	 * The feature id for the '<em><b>Output Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK__OUTPUT_EVENT_PORTS = FUNCTION_BLOCK__OUTPUT_EVENT_PORTS;

	/**
	 * The feature id for the '<em><b>Input Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK__INPUT_DATA_PORTS = FUNCTION_BLOCK__INPUT_DATA_PORTS;

	/**
	 * The feature id for the '<em><b>Output Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK__OUTPUT_DATA_PORTS = FUNCTION_BLOCK__OUTPUT_DATA_PORTS;

	/**
	 * The feature id for the '<em><b>Composite Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK = FUNCTION_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Service Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK__SERVICE_SEQUENCE = FUNCTION_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Function Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK_FEATURE_COUNT = FUNCTION_BLOCK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cakefeed.impl.ServiceInterfaceFunctionBlockImpl <em>Service Interface Function Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.ServiceInterfaceFunctionBlockImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getServiceInterfaceFunctionBlock()
	 * @generated
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK = 4;

	/**
	 * The feature id for the '<em><b>Parent Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK__PARENT_INTERFACE = FUNCTION_BLOCK__PARENT_INTERFACE;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK__TYPE_NAME = FUNCTION_BLOCK__TYPE_NAME;

	/**
	 * The feature id for the '<em><b>Input Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK__INPUT_EVENT_PORTS = FUNCTION_BLOCK__INPUT_EVENT_PORTS;

	/**
	 * The feature id for the '<em><b>Output Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK__OUTPUT_EVENT_PORTS = FUNCTION_BLOCK__OUTPUT_EVENT_PORTS;

	/**
	 * The feature id for the '<em><b>Input Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK__INPUT_DATA_PORTS = FUNCTION_BLOCK__INPUT_DATA_PORTS;

	/**
	 * The feature id for the '<em><b>Output Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK__OUTPUT_DATA_PORTS = FUNCTION_BLOCK__OUTPUT_DATA_PORTS;

	/**
	 * The feature id for the '<em><b>Service Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK__SERVICE_SEQUENCE = FUNCTION_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Service Interface Function Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK_FEATURE_COUNT = FUNCTION_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cakefeed.impl.FunctionBlockInstanceImpl <em>Function Block Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.FunctionBlockInstanceImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getFunctionBlockInstance()
	 * @generated
	 */
	int FUNCTION_BLOCK_INSTANCE = 5;

	/**
	 * The feature id for the '<em><b>Parent Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK_INSTANCE__PARENT_INTERFACE = FUNCTION_BLOCK__PARENT_INTERFACE;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK_INSTANCE__TYPE_NAME = FUNCTION_BLOCK__TYPE_NAME;

	/**
	 * The feature id for the '<em><b>Input Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK_INSTANCE__INPUT_EVENT_PORTS = FUNCTION_BLOCK__INPUT_EVENT_PORTS;

	/**
	 * The feature id for the '<em><b>Output Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK_INSTANCE__OUTPUT_EVENT_PORTS = FUNCTION_BLOCK__OUTPUT_EVENT_PORTS;

	/**
	 * The feature id for the '<em><b>Input Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK_INSTANCE__INPUT_DATA_PORTS = FUNCTION_BLOCK__INPUT_DATA_PORTS;

	/**
	 * The feature id for the '<em><b>Output Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK_INSTANCE__OUTPUT_DATA_PORTS = FUNCTION_BLOCK__OUTPUT_DATA_PORTS;

	/**
	 * The feature id for the '<em><b>Parent Application</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION = FUNCTION_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK_INSTANCE__INSTANCE_NAME = FUNCTION_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function Block Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BLOCK_INSTANCE_FEATURE_COUNT = FUNCTION_BLOCK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cakefeed.impl.BasicFunctionBlockInstanceImpl <em>Basic Function Block Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.BasicFunctionBlockInstanceImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getBasicFunctionBlockInstance()
	 * @generated
	 */
	int BASIC_FUNCTION_BLOCK_INSTANCE = 6;

	/**
	 * The feature id for the '<em><b>Parent Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK_INSTANCE__PARENT_INTERFACE = FUNCTION_BLOCK_INSTANCE__PARENT_INTERFACE;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK_INSTANCE__TYPE_NAME = FUNCTION_BLOCK_INSTANCE__TYPE_NAME;

	/**
	 * The feature id for the '<em><b>Input Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK_INSTANCE__INPUT_EVENT_PORTS = FUNCTION_BLOCK_INSTANCE__INPUT_EVENT_PORTS;

	/**
	 * The feature id for the '<em><b>Output Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK_INSTANCE__OUTPUT_EVENT_PORTS = FUNCTION_BLOCK_INSTANCE__OUTPUT_EVENT_PORTS;

	/**
	 * The feature id for the '<em><b>Input Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK_INSTANCE__INPUT_DATA_PORTS = FUNCTION_BLOCK_INSTANCE__INPUT_DATA_PORTS;

	/**
	 * The feature id for the '<em><b>Output Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK_INSTANCE__OUTPUT_DATA_PORTS = FUNCTION_BLOCK_INSTANCE__OUTPUT_DATA_PORTS;

	/**
	 * The feature id for the '<em><b>Parent Application</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION = FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION;

	/**
	 * The feature id for the '<em><b>Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK_INSTANCE__INSTANCE_NAME = FUNCTION_BLOCK_INSTANCE__INSTANCE_NAME;

	/**
	 * The feature id for the '<em><b>Execution Control Chart</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK_INSTANCE__EXECUTION_CONTROL_CHART = FUNCTION_BLOCK_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Algorithms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK_INSTANCE__ALGORITHMS = FUNCTION_BLOCK_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK_INSTANCE__TYPE = FUNCTION_BLOCK_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Basic Function Block Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_BLOCK_INSTANCE_FEATURE_COUNT = FUNCTION_BLOCK_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link cakefeed.impl.CompositeFunctionBlockInstanceImpl <em>Composite Function Block Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.CompositeFunctionBlockInstanceImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getCompositeFunctionBlockInstance()
	 * @generated
	 */
	int COMPOSITE_FUNCTION_BLOCK_INSTANCE = 7;

	/**
	 * The feature id for the '<em><b>Parent Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK_INSTANCE__PARENT_INTERFACE = FUNCTION_BLOCK_INSTANCE__PARENT_INTERFACE;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK_INSTANCE__TYPE_NAME = FUNCTION_BLOCK_INSTANCE__TYPE_NAME;

	/**
	 * The feature id for the '<em><b>Input Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK_INSTANCE__INPUT_EVENT_PORTS = FUNCTION_BLOCK_INSTANCE__INPUT_EVENT_PORTS;

	/**
	 * The feature id for the '<em><b>Output Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK_INSTANCE__OUTPUT_EVENT_PORTS = FUNCTION_BLOCK_INSTANCE__OUTPUT_EVENT_PORTS;

	/**
	 * The feature id for the '<em><b>Input Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK_INSTANCE__INPUT_DATA_PORTS = FUNCTION_BLOCK_INSTANCE__INPUT_DATA_PORTS;

	/**
	 * The feature id for the '<em><b>Output Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK_INSTANCE__OUTPUT_DATA_PORTS = FUNCTION_BLOCK_INSTANCE__OUTPUT_DATA_PORTS;

	/**
	 * The feature id for the '<em><b>Parent Application</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION = FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION;

	/**
	 * The feature id for the '<em><b>Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK_INSTANCE__INSTANCE_NAME = FUNCTION_BLOCK_INSTANCE__INSTANCE_NAME;

	/**
	 * The feature id for the '<em><b>Composite Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK_INSTANCE__COMPOSITE_NETWORK = FUNCTION_BLOCK_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Service Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK_INSTANCE__SERVICE_SEQUENCE = FUNCTION_BLOCK_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK_INSTANCE__TYPE = FUNCTION_BLOCK_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composite Function Block Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FUNCTION_BLOCK_INSTANCE_FEATURE_COUNT = FUNCTION_BLOCK_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link cakefeed.impl.ServiceInterfaceFunctionBlockInstanceImpl <em>Service Interface Function Block Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.ServiceInterfaceFunctionBlockInstanceImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getServiceInterfaceFunctionBlockInstance()
	 * @generated
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE = 8;

	/**
	 * The feature id for the '<em><b>Parent Interface</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__PARENT_INTERFACE = FUNCTION_BLOCK_INSTANCE__PARENT_INTERFACE;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__TYPE_NAME = FUNCTION_BLOCK_INSTANCE__TYPE_NAME;

	/**
	 * The feature id for the '<em><b>Input Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__INPUT_EVENT_PORTS = FUNCTION_BLOCK_INSTANCE__INPUT_EVENT_PORTS;

	/**
	 * The feature id for the '<em><b>Output Event Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__OUTPUT_EVENT_PORTS = FUNCTION_BLOCK_INSTANCE__OUTPUT_EVENT_PORTS;

	/**
	 * The feature id for the '<em><b>Input Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__INPUT_DATA_PORTS = FUNCTION_BLOCK_INSTANCE__INPUT_DATA_PORTS;

	/**
	 * The feature id for the '<em><b>Output Data Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__OUTPUT_DATA_PORTS = FUNCTION_BLOCK_INSTANCE__OUTPUT_DATA_PORTS;

	/**
	 * The feature id for the '<em><b>Parent Application</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION = FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION;

	/**
	 * The feature id for the '<em><b>Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__INSTANCE_NAME = FUNCTION_BLOCK_INSTANCE__INSTANCE_NAME;

	/**
	 * The feature id for the '<em><b>Service Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__SERVICE_SEQUENCE = FUNCTION_BLOCK_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__TYPE = FUNCTION_BLOCK_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Service Interface Function Block Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE_FEATURE_COUNT = FUNCTION_BLOCK_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cakefeed.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.ConnectionImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 9;

	/**
	 * The feature id for the '<em><b>Parent Application</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__PARENT_APPLICATION = 0;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link cakefeed.impl.EventConnectionImpl <em>Event Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.EventConnectionImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getEventConnection()
	 * @generated
	 */
	int EVENT_CONNECTION = 10;

	/**
	 * The feature id for the '<em><b>Parent Application</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONNECTION__PARENT_APPLICATION = CONNECTION__PARENT_APPLICATION;

	/**
	 * The feature id for the '<em><b>Source Event Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONNECTION__SOURCE_EVENT_PORT = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Event Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONNECTION__TARGET_EVENT_PORT = CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Event Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONNECTION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cakefeed.impl.DataConnectionImpl <em>Data Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.DataConnectionImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getDataConnection()
	 * @generated
	 */
	int DATA_CONNECTION = 11;

	/**
	 * The feature id for the '<em><b>Parent Application</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONNECTION__PARENT_APPLICATION = CONNECTION__PARENT_APPLICATION;

	/**
	 * The feature id for the '<em><b>Source Data Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONNECTION__SOURCE_DATA_PORT = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Data Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONNECTION__TARGET_DATA_PORT = CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONNECTION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cakefeed.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.PortImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 12;

	/**
	 * The feature id for the '<em><b>Port Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PORT_NAME = 0;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link cakefeed.impl.EventPortImpl <em>Event Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.EventPortImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getEventPort()
	 * @generated
	 */
	int EVENT_PORT = 13;

	/**
	 * The feature id for the '<em><b>Port Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PORT__PORT_NAME = PORT__PORT_NAME;

	/**
	 * The number of structural features of the '<em>Event Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link cakefeed.impl.DataPortImpl <em>Data Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.DataPortImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getDataPort()
	 * @generated
	 */
	int DATA_PORT = 14;

	/**
	 * The feature id for the '<em><b>Port Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT__PORT_NAME = PORT__PORT_NAME;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT__PORT_TYPE = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link cakefeed.impl.InputEventPortImpl <em>Input Event Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.InputEventPortImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getInputEventPort()
	 * @generated
	 */
	int INPUT_EVENT_PORT = 15;

	/**
	 * The feature id for the '<em><b>Port Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_EVENT_PORT__PORT_NAME = EVENT_PORT__PORT_NAME;

	/**
	 * The feature id for the '<em><b>Parent Function Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_EVENT_PORT__PARENT_FUNCTION_BLOCK = EVENT_PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_EVENT_PORT__EVENT_CONNECTIONS = EVENT_PORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input Associations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_EVENT_PORT__INPUT_ASSOCIATIONS = EVENT_PORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Input Event Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_EVENT_PORT_FEATURE_COUNT = EVENT_PORT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link cakefeed.impl.OutputEventPortImpl <em>Output Event Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.OutputEventPortImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getOutputEventPort()
	 * @generated
	 */
	int OUTPUT_EVENT_PORT = 16;

	/**
	 * The feature id for the '<em><b>Port Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_EVENT_PORT__PORT_NAME = EVENT_PORT__PORT_NAME;

	/**
	 * The feature id for the '<em><b>Parent Function Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_EVENT_PORT__PARENT_FUNCTION_BLOCK = EVENT_PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_EVENT_PORT__EVENT_CONNECTIONS = EVENT_PORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output Associations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_EVENT_PORT__OUTPUT_ASSOCIATIONS = EVENT_PORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Output Event Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_EVENT_PORT_FEATURE_COUNT = EVENT_PORT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link cakefeed.impl.InputDataPortImpl <em>Input Data Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.InputDataPortImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getInputDataPort()
	 * @generated
	 */
	int INPUT_DATA_PORT = 17;

	/**
	 * The feature id for the '<em><b>Port Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_PORT__PORT_NAME = DATA_PORT__PORT_NAME;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_PORT__PORT_TYPE = DATA_PORT__PORT_TYPE;

	/**
	 * The feature id for the '<em><b>Parent Function Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_PORT__PARENT_FUNCTION_BLOCK = DATA_PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_PORT__EVENT_CONNECTIONS = DATA_PORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_PORT__INPUT_ASSOCIATIONS = DATA_PORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Input Data Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_PORT_FEATURE_COUNT = DATA_PORT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link cakefeed.impl.OutputDataPortImpl <em>Output Data Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.OutputDataPortImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getOutputDataPort()
	 * @generated
	 */
	int OUTPUT_DATA_PORT = 18;

	/**
	 * The feature id for the '<em><b>Port Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DATA_PORT__PORT_NAME = DATA_PORT__PORT_NAME;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DATA_PORT__PORT_TYPE = DATA_PORT__PORT_TYPE;

	/**
	 * The feature id for the '<em><b>Parent Function Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DATA_PORT__PARENT_FUNCTION_BLOCK = DATA_PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DATA_PORT__EVENT_CONNECTIONS = DATA_PORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DATA_PORT__OUTPUT_ASSOCIATIONS = DATA_PORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Output Data Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DATA_PORT_FEATURE_COUNT = DATA_PORT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link cakefeed.impl.AlgorithmImpl <em>Algorithm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.AlgorithmImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getAlgorithm()
	 * @generated
	 */
	int ALGORITHM = 19;

	/**
	 * The feature id for the '<em><b>Algorithm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__ALGORITHM_NAME = 0;

	/**
	 * The feature id for the '<em><b>Algorithm Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__ALGORITHM_LANGUAGE = 1;

	/**
	 * The feature id for the '<em><b>Algorithm Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__ALGORITHM_SOURCE_CODE = 2;

	/**
	 * The number of structural features of the '<em>Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link cakefeed.impl.CompositeNetworkImpl <em>Composite Network</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.CompositeNetworkImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getCompositeNetwork()
	 * @generated
	 */
	int COMPOSITE_NETWORK = 20;

	/**
	 * The feature id for the '<em><b>Application Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NETWORK__APPLICATION_NAME = APPLICATION__APPLICATION_NAME;

	/**
	 * The feature id for the '<em><b>Function Blocks Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NETWORK__FUNCTION_BLOCKS_INSTANCES = APPLICATION__FUNCTION_BLOCKS_INSTANCES;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NETWORK__CONNECTIONS = APPLICATION__CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Parent Composite Function Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK = APPLICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input Events</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NETWORK__INPUT_EVENTS = APPLICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output Events</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NETWORK__OUTPUT_EVENTS = APPLICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Input Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NETWORK__INPUT_DATA = APPLICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Output Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NETWORK__OUTPUT_DATA = APPLICATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Composite Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NETWORK_FEATURE_COUNT = APPLICATION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link cakefeed.impl.ServiceSequenceImpl <em>Service Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.ServiceSequenceImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getServiceSequence()
	 * @generated
	 */
	int SERVICE_SEQUENCE = 21;

	/**
	 * The number of structural features of the '<em>Service Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SEQUENCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link cakefeed.impl.AssociationImpl <em>Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.AssociationImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getAssociation()
	 * @generated
	 */
	int ASSOCIATION = 22;

	/**
	 * The number of structural features of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link cakefeed.impl.InputAssociationImpl <em>Input Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.InputAssociationImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getInputAssociation()
	 * @generated
	 */
	int INPUT_ASSOCIATION = 23;

	/**
	 * The feature id for the '<em><b>Source Input Event Port</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ASSOCIATION__SOURCE_INPUT_EVENT_PORT = ASSOCIATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Input Data Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ASSOCIATION__TARGET_INPUT_DATA_PORT = ASSOCIATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Input Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ASSOCIATION_FEATURE_COUNT = ASSOCIATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cakefeed.impl.OutputAssociationImpl <em>Output Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.OutputAssociationImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getOutputAssociation()
	 * @generated
	 */
	int OUTPUT_ASSOCIATION = 24;

	/**
	 * The feature id for the '<em><b>Source Output Event Port</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ASSOCIATION__SOURCE_OUTPUT_EVENT_PORT = ASSOCIATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Output Data Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ASSOCIATION__TARGET_OUTPUT_DATA_PORT = ASSOCIATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Output Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ASSOCIATION_FEATURE_COUNT = ASSOCIATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link cakefeed.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.InterfaceImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 25;

	/**
	 * The feature id for the '<em><b>Function Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__FUNCTION_BLOCK = 0;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link cakefeed.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.impl.LibraryImpl
	 * @see cakefeed.impl.CakefeedPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 26;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__TYPES = 0;

	/**
	 * The feature id for the '<em><b>Algorithms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ALGORITHMS = 1;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link cakefeed.PortType <em>Port Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cakefeed.PortType
	 * @see cakefeed.impl.CakefeedPackageImpl#getPortType()
	 * @generated
	 */
	int PORT_TYPE = 27;


	/**
	 * Returns the meta object for class '{@link cakefeed.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see cakefeed.Application
	 * @generated
	 */
	EClass getApplication();

	/**
	 * Returns the meta object for the attribute '{@link cakefeed.Application#getApplicationName <em>Application Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Application Name</em>'.
	 * @see cakefeed.Application#getApplicationName()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_ApplicationName();

	/**
	 * Returns the meta object for the containment reference list '{@link cakefeed.Application#getFunctionBlocksInstances <em>Function Blocks Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Function Blocks Instances</em>'.
	 * @see cakefeed.Application#getFunctionBlocksInstances()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_FunctionBlocksInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link cakefeed.Application#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connections</em>'.
	 * @see cakefeed.Application#getConnections()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_Connections();

	/**
	 * Returns the meta object for class '{@link cakefeed.FunctionBlock <em>Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Block</em>'.
	 * @see cakefeed.FunctionBlock
	 * @generated
	 */
	EClass getFunctionBlock();

	/**
	 * Returns the meta object for the container reference '{@link cakefeed.FunctionBlock#getParentInterface <em>Parent Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Interface</em>'.
	 * @see cakefeed.FunctionBlock#getParentInterface()
	 * @see #getFunctionBlock()
	 * @generated
	 */
	EReference getFunctionBlock_ParentInterface();

	/**
	 * Returns the meta object for the attribute '{@link cakefeed.FunctionBlock#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see cakefeed.FunctionBlock#getTypeName()
	 * @see #getFunctionBlock()
	 * @generated
	 */
	EAttribute getFunctionBlock_TypeName();

	/**
	 * Returns the meta object for the containment reference list '{@link cakefeed.FunctionBlock#getInputEventPorts <em>Input Event Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Event Ports</em>'.
	 * @see cakefeed.FunctionBlock#getInputEventPorts()
	 * @see #getFunctionBlock()
	 * @generated
	 */
	EReference getFunctionBlock_InputEventPorts();

	/**
	 * Returns the meta object for the containment reference list '{@link cakefeed.FunctionBlock#getOutputEventPorts <em>Output Event Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Event Ports</em>'.
	 * @see cakefeed.FunctionBlock#getOutputEventPorts()
	 * @see #getFunctionBlock()
	 * @generated
	 */
	EReference getFunctionBlock_OutputEventPorts();

	/**
	 * Returns the meta object for the containment reference list '{@link cakefeed.FunctionBlock#getInputDataPorts <em>Input Data Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Data Ports</em>'.
	 * @see cakefeed.FunctionBlock#getInputDataPorts()
	 * @see #getFunctionBlock()
	 * @generated
	 */
	EReference getFunctionBlock_InputDataPorts();

	/**
	 * Returns the meta object for the containment reference list '{@link cakefeed.FunctionBlock#getOutputDataPorts <em>Output Data Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Data Ports</em>'.
	 * @see cakefeed.FunctionBlock#getOutputDataPorts()
	 * @see #getFunctionBlock()
	 * @generated
	 */
	EReference getFunctionBlock_OutputDataPorts();

	/**
	 * Returns the meta object for class '{@link cakefeed.BasicFunctionBlock <em>Basic Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Function Block</em>'.
	 * @see cakefeed.BasicFunctionBlock
	 * @generated
	 */
	EClass getBasicFunctionBlock();

	/**
	 * Returns the meta object for the reference '{@link cakefeed.BasicFunctionBlock#getExecutionControlChart <em>Execution Control Chart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Execution Control Chart</em>'.
	 * @see cakefeed.BasicFunctionBlock#getExecutionControlChart()
	 * @see #getBasicFunctionBlock()
	 * @generated
	 */
	EReference getBasicFunctionBlock_ExecutionControlChart();

	/**
	 * Returns the meta object for the reference list '{@link cakefeed.BasicFunctionBlock#getAlgorithms <em>Algorithms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Algorithms</em>'.
	 * @see cakefeed.BasicFunctionBlock#getAlgorithms()
	 * @see #getBasicFunctionBlock()
	 * @generated
	 */
	EReference getBasicFunctionBlock_Algorithms();

	/**
	 * Returns the meta object for class '{@link cakefeed.CompositeFunctionBlock <em>Composite Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Function Block</em>'.
	 * @see cakefeed.CompositeFunctionBlock
	 * @generated
	 */
	EClass getCompositeFunctionBlock();

	/**
	 * Returns the meta object for the containment reference '{@link cakefeed.CompositeFunctionBlock#getCompositeNetwork <em>Composite Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Composite Network</em>'.
	 * @see cakefeed.CompositeFunctionBlock#getCompositeNetwork()
	 * @see #getCompositeFunctionBlock()
	 * @generated
	 */
	EReference getCompositeFunctionBlock_CompositeNetwork();

	/**
	 * Returns the meta object for the reference '{@link cakefeed.CompositeFunctionBlock#getServiceSequence <em>Service Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service Sequence</em>'.
	 * @see cakefeed.CompositeFunctionBlock#getServiceSequence()
	 * @see #getCompositeFunctionBlock()
	 * @generated
	 */
	EReference getCompositeFunctionBlock_ServiceSequence();

	/**
	 * Returns the meta object for class '{@link cakefeed.ServiceInterfaceFunctionBlock <em>Service Interface Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Interface Function Block</em>'.
	 * @see cakefeed.ServiceInterfaceFunctionBlock
	 * @generated
	 */
	EClass getServiceInterfaceFunctionBlock();

	/**
	 * Returns the meta object for the reference '{@link cakefeed.ServiceInterfaceFunctionBlock#getServiceSequence <em>Service Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service Sequence</em>'.
	 * @see cakefeed.ServiceInterfaceFunctionBlock#getServiceSequence()
	 * @see #getServiceInterfaceFunctionBlock()
	 * @generated
	 */
	EReference getServiceInterfaceFunctionBlock_ServiceSequence();

	/**
	 * Returns the meta object for class '{@link cakefeed.FunctionBlockInstance <em>Function Block Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Block Instance</em>'.
	 * @see cakefeed.FunctionBlockInstance
	 * @generated
	 */
	EClass getFunctionBlockInstance();

	/**
	 * Returns the meta object for the container reference '{@link cakefeed.FunctionBlockInstance#getParentApplication <em>Parent Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Application</em>'.
	 * @see cakefeed.FunctionBlockInstance#getParentApplication()
	 * @see #getFunctionBlockInstance()
	 * @generated
	 */
	EReference getFunctionBlockInstance_ParentApplication();

	/**
	 * Returns the meta object for the attribute '{@link cakefeed.FunctionBlockInstance#getInstanceName <em>Instance Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Name</em>'.
	 * @see cakefeed.FunctionBlockInstance#getInstanceName()
	 * @see #getFunctionBlockInstance()
	 * @generated
	 */
	EAttribute getFunctionBlockInstance_InstanceName();

	/**
	 * Returns the meta object for class '{@link cakefeed.BasicFunctionBlockInstance <em>Basic Function Block Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Function Block Instance</em>'.
	 * @see cakefeed.BasicFunctionBlockInstance
	 * @generated
	 */
	EClass getBasicFunctionBlockInstance();

	/**
	 * Returns the meta object for the reference '{@link cakefeed.BasicFunctionBlockInstance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see cakefeed.BasicFunctionBlockInstance#getType()
	 * @see #getBasicFunctionBlockInstance()
	 * @generated
	 */
	EReference getBasicFunctionBlockInstance_Type();

	/**
	 * Returns the meta object for class '{@link cakefeed.CompositeFunctionBlockInstance <em>Composite Function Block Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Function Block Instance</em>'.
	 * @see cakefeed.CompositeFunctionBlockInstance
	 * @generated
	 */
	EClass getCompositeFunctionBlockInstance();

	/**
	 * Returns the meta object for the reference '{@link cakefeed.CompositeFunctionBlockInstance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see cakefeed.CompositeFunctionBlockInstance#getType()
	 * @see #getCompositeFunctionBlockInstance()
	 * @generated
	 */
	EReference getCompositeFunctionBlockInstance_Type();

	/**
	 * Returns the meta object for class '{@link cakefeed.ServiceInterfaceFunctionBlockInstance <em>Service Interface Function Block Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Interface Function Block Instance</em>'.
	 * @see cakefeed.ServiceInterfaceFunctionBlockInstance
	 * @generated
	 */
	EClass getServiceInterfaceFunctionBlockInstance();

	/**
	 * Returns the meta object for the reference '{@link cakefeed.ServiceInterfaceFunctionBlockInstance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see cakefeed.ServiceInterfaceFunctionBlockInstance#getType()
	 * @see #getServiceInterfaceFunctionBlockInstance()
	 * @generated
	 */
	EReference getServiceInterfaceFunctionBlockInstance_Type();

	/**
	 * Returns the meta object for class '{@link cakefeed.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see cakefeed.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the container reference '{@link cakefeed.Connection#getParentApplication <em>Parent Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Application</em>'.
	 * @see cakefeed.Connection#getParentApplication()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_ParentApplication();

	/**
	 * Returns the meta object for class '{@link cakefeed.EventConnection <em>Event Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Connection</em>'.
	 * @see cakefeed.EventConnection
	 * @generated
	 */
	EClass getEventConnection();

	/**
	 * Returns the meta object for the reference '{@link cakefeed.EventConnection#getSourceEventPort <em>Source Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Event Port</em>'.
	 * @see cakefeed.EventConnection#getSourceEventPort()
	 * @see #getEventConnection()
	 * @generated
	 */
	EReference getEventConnection_SourceEventPort();

	/**
	 * Returns the meta object for the reference '{@link cakefeed.EventConnection#getTargetEventPort <em>Target Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Event Port</em>'.
	 * @see cakefeed.EventConnection#getTargetEventPort()
	 * @see #getEventConnection()
	 * @generated
	 */
	EReference getEventConnection_TargetEventPort();

	/**
	 * Returns the meta object for class '{@link cakefeed.DataConnection <em>Data Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Connection</em>'.
	 * @see cakefeed.DataConnection
	 * @generated
	 */
	EClass getDataConnection();

	/**
	 * Returns the meta object for the reference '{@link cakefeed.DataConnection#getSourceDataPort <em>Source Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Data Port</em>'.
	 * @see cakefeed.DataConnection#getSourceDataPort()
	 * @see #getDataConnection()
	 * @generated
	 */
	EReference getDataConnection_SourceDataPort();

	/**
	 * Returns the meta object for the reference '{@link cakefeed.DataConnection#getTargetDataPort <em>Target Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Data Port</em>'.
	 * @see cakefeed.DataConnection#getTargetDataPort()
	 * @see #getDataConnection()
	 * @generated
	 */
	EReference getDataConnection_TargetDataPort();

	/**
	 * Returns the meta object for class '{@link cakefeed.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see cakefeed.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the attribute '{@link cakefeed.Port#getPortName <em>Port Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port Name</em>'.
	 * @see cakefeed.Port#getPortName()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_PortName();

	/**
	 * Returns the meta object for class '{@link cakefeed.EventPort <em>Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Port</em>'.
	 * @see cakefeed.EventPort
	 * @generated
	 */
	EClass getEventPort();

	/**
	 * Returns the meta object for class '{@link cakefeed.DataPort <em>Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Port</em>'.
	 * @see cakefeed.DataPort
	 * @generated
	 */
	EClass getDataPort();

	/**
	 * Returns the meta object for the attribute '{@link cakefeed.DataPort#getPortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port Type</em>'.
	 * @see cakefeed.DataPort#getPortType()
	 * @see #getDataPort()
	 * @generated
	 */
	EAttribute getDataPort_PortType();

	/**
	 * Returns the meta object for class '{@link cakefeed.InputEventPort <em>Input Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Event Port</em>'.
	 * @see cakefeed.InputEventPort
	 * @generated
	 */
	EClass getInputEventPort();

	/**
	 * Returns the meta object for the container reference '{@link cakefeed.InputEventPort#getParentFunctionBlock <em>Parent Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Function Block</em>'.
	 * @see cakefeed.InputEventPort#getParentFunctionBlock()
	 * @see #getInputEventPort()
	 * @generated
	 */
	EReference getInputEventPort_ParentFunctionBlock();

	/**
	 * Returns the meta object for the reference list '{@link cakefeed.InputEventPort#getEventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Event Connections</em>'.
	 * @see cakefeed.InputEventPort#getEventConnections()
	 * @see #getInputEventPort()
	 * @generated
	 */
	EReference getInputEventPort_EventConnections();

	/**
	 * Returns the meta object for the containment reference list '{@link cakefeed.InputEventPort#getInputAssociations <em>Input Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Associations</em>'.
	 * @see cakefeed.InputEventPort#getInputAssociations()
	 * @see #getInputEventPort()
	 * @generated
	 */
	EReference getInputEventPort_InputAssociations();

	/**
	 * Returns the meta object for class '{@link cakefeed.OutputEventPort <em>Output Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Event Port</em>'.
	 * @see cakefeed.OutputEventPort
	 * @generated
	 */
	EClass getOutputEventPort();

	/**
	 * Returns the meta object for the container reference '{@link cakefeed.OutputEventPort#getParentFunctionBlock <em>Parent Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Function Block</em>'.
	 * @see cakefeed.OutputEventPort#getParentFunctionBlock()
	 * @see #getOutputEventPort()
	 * @generated
	 */
	EReference getOutputEventPort_ParentFunctionBlock();

	/**
	 * Returns the meta object for the reference list '{@link cakefeed.OutputEventPort#getEventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Event Connections</em>'.
	 * @see cakefeed.OutputEventPort#getEventConnections()
	 * @see #getOutputEventPort()
	 * @generated
	 */
	EReference getOutputEventPort_EventConnections();

	/**
	 * Returns the meta object for the containment reference list '{@link cakefeed.OutputEventPort#getOutputAssociations <em>Output Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Associations</em>'.
	 * @see cakefeed.OutputEventPort#getOutputAssociations()
	 * @see #getOutputEventPort()
	 * @generated
	 */
	EReference getOutputEventPort_OutputAssociations();

	/**
	 * Returns the meta object for class '{@link cakefeed.InputDataPort <em>Input Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Data Port</em>'.
	 * @see cakefeed.InputDataPort
	 * @generated
	 */
	EClass getInputDataPort();

	/**
	 * Returns the meta object for the container reference '{@link cakefeed.InputDataPort#getParentFunctionBlock <em>Parent Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Function Block</em>'.
	 * @see cakefeed.InputDataPort#getParentFunctionBlock()
	 * @see #getInputDataPort()
	 * @generated
	 */
	EReference getInputDataPort_ParentFunctionBlock();

	/**
	 * Returns the meta object for the reference list '{@link cakefeed.InputDataPort#getEventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Event Connections</em>'.
	 * @see cakefeed.InputDataPort#getEventConnections()
	 * @see #getInputDataPort()
	 * @generated
	 */
	EReference getInputDataPort_EventConnections();

	/**
	 * Returns the meta object for the reference list '{@link cakefeed.InputDataPort#getInputAssociations <em>Input Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input Associations</em>'.
	 * @see cakefeed.InputDataPort#getInputAssociations()
	 * @see #getInputDataPort()
	 * @generated
	 */
	EReference getInputDataPort_InputAssociations();

	/**
	 * Returns the meta object for class '{@link cakefeed.OutputDataPort <em>Output Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Data Port</em>'.
	 * @see cakefeed.OutputDataPort
	 * @generated
	 */
	EClass getOutputDataPort();

	/**
	 * Returns the meta object for the container reference '{@link cakefeed.OutputDataPort#getParentFunctionBlock <em>Parent Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Function Block</em>'.
	 * @see cakefeed.OutputDataPort#getParentFunctionBlock()
	 * @see #getOutputDataPort()
	 * @generated
	 */
	EReference getOutputDataPort_ParentFunctionBlock();

	/**
	 * Returns the meta object for the reference list '{@link cakefeed.OutputDataPort#getEventConnections <em>Event Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Event Connections</em>'.
	 * @see cakefeed.OutputDataPort#getEventConnections()
	 * @see #getOutputDataPort()
	 * @generated
	 */
	EReference getOutputDataPort_EventConnections();

	/**
	 * Returns the meta object for the reference list '{@link cakefeed.OutputDataPort#getOutputAssociations <em>Output Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Output Associations</em>'.
	 * @see cakefeed.OutputDataPort#getOutputAssociations()
	 * @see #getOutputDataPort()
	 * @generated
	 */
	EReference getOutputDataPort_OutputAssociations();

	/**
	 * Returns the meta object for class '{@link cakefeed.Algorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Algorithm</em>'.
	 * @see cakefeed.Algorithm
	 * @generated
	 */
	EClass getAlgorithm();

	/**
	 * Returns the meta object for the attribute '{@link cakefeed.Algorithm#getAlgorithmName <em>Algorithm Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Algorithm Name</em>'.
	 * @see cakefeed.Algorithm#getAlgorithmName()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EAttribute getAlgorithm_AlgorithmName();

	/**
	 * Returns the meta object for the attribute '{@link cakefeed.Algorithm#getAlgorithmLanguage <em>Algorithm Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Algorithm Language</em>'.
	 * @see cakefeed.Algorithm#getAlgorithmLanguage()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EAttribute getAlgorithm_AlgorithmLanguage();

	/**
	 * Returns the meta object for the attribute '{@link cakefeed.Algorithm#getAlgorithmSourceCode <em>Algorithm Source Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Algorithm Source Code</em>'.
	 * @see cakefeed.Algorithm#getAlgorithmSourceCode()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EAttribute getAlgorithm_AlgorithmSourceCode();

	/**
	 * Returns the meta object for class '{@link cakefeed.CompositeNetwork <em>Composite Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Network</em>'.
	 * @see cakefeed.CompositeNetwork
	 * @generated
	 */
	EClass getCompositeNetwork();

	/**
	 * Returns the meta object for the container reference '{@link cakefeed.CompositeNetwork#getParentCompositeFunctionBlock <em>Parent Composite Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Composite Function Block</em>'.
	 * @see cakefeed.CompositeNetwork#getParentCompositeFunctionBlock()
	 * @see #getCompositeNetwork()
	 * @generated
	 */
	EReference getCompositeNetwork_ParentCompositeFunctionBlock();

	/**
	 * Returns the meta object for the containment reference '{@link cakefeed.CompositeNetwork#getInputEvents <em>Input Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input Events</em>'.
	 * @see cakefeed.CompositeNetwork#getInputEvents()
	 * @see #getCompositeNetwork()
	 * @generated
	 */
	EReference getCompositeNetwork_InputEvents();

	/**
	 * Returns the meta object for the containment reference '{@link cakefeed.CompositeNetwork#getOutputEvents <em>Output Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output Events</em>'.
	 * @see cakefeed.CompositeNetwork#getOutputEvents()
	 * @see #getCompositeNetwork()
	 * @generated
	 */
	EReference getCompositeNetwork_OutputEvents();

	/**
	 * Returns the meta object for the containment reference '{@link cakefeed.CompositeNetwork#getInputData <em>Input Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input Data</em>'.
	 * @see cakefeed.CompositeNetwork#getInputData()
	 * @see #getCompositeNetwork()
	 * @generated
	 */
	EReference getCompositeNetwork_InputData();

	/**
	 * Returns the meta object for the containment reference '{@link cakefeed.CompositeNetwork#getOutputData <em>Output Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output Data</em>'.
	 * @see cakefeed.CompositeNetwork#getOutputData()
	 * @see #getCompositeNetwork()
	 * @generated
	 */
	EReference getCompositeNetwork_OutputData();

	/**
	 * Returns the meta object for class '{@link cakefeed.ServiceSequence <em>Service Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Sequence</em>'.
	 * @see cakefeed.ServiceSequence
	 * @generated
	 */
	EClass getServiceSequence();

	/**
	 * Returns the meta object for class '{@link cakefeed.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association</em>'.
	 * @see cakefeed.Association
	 * @generated
	 */
	EClass getAssociation();

	/**
	 * Returns the meta object for class '{@link cakefeed.InputAssociation <em>Input Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Association</em>'.
	 * @see cakefeed.InputAssociation
	 * @generated
	 */
	EClass getInputAssociation();

	/**
	 * Returns the meta object for the container reference '{@link cakefeed.InputAssociation#getSourceInputEventPort <em>Source Input Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source Input Event Port</em>'.
	 * @see cakefeed.InputAssociation#getSourceInputEventPort()
	 * @see #getInputAssociation()
	 * @generated
	 */
	EReference getInputAssociation_SourceInputEventPort();

	/**
	 * Returns the meta object for the reference '{@link cakefeed.InputAssociation#getTargetInputDataPort <em>Target Input Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Input Data Port</em>'.
	 * @see cakefeed.InputAssociation#getTargetInputDataPort()
	 * @see #getInputAssociation()
	 * @generated
	 */
	EReference getInputAssociation_TargetInputDataPort();

	/**
	 * Returns the meta object for class '{@link cakefeed.OutputAssociation <em>Output Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Association</em>'.
	 * @see cakefeed.OutputAssociation
	 * @generated
	 */
	EClass getOutputAssociation();

	/**
	 * Returns the meta object for the container reference '{@link cakefeed.OutputAssociation#getSourceOutputEventPort <em>Source Output Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source Output Event Port</em>'.
	 * @see cakefeed.OutputAssociation#getSourceOutputEventPort()
	 * @see #getOutputAssociation()
	 * @generated
	 */
	EReference getOutputAssociation_SourceOutputEventPort();

	/**
	 * Returns the meta object for the reference '{@link cakefeed.OutputAssociation#getTargetOutputDataPort <em>Target Output Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Output Data Port</em>'.
	 * @see cakefeed.OutputAssociation#getTargetOutputDataPort()
	 * @see #getOutputAssociation()
	 * @generated
	 */
	EReference getOutputAssociation_TargetOutputDataPort();

	/**
	 * Returns the meta object for class '{@link cakefeed.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see cakefeed.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for the containment reference '{@link cakefeed.Interface#getFunctionBlock <em>Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Function Block</em>'.
	 * @see cakefeed.Interface#getFunctionBlock()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_FunctionBlock();

	/**
	 * Returns the meta object for class '{@link cakefeed.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see cakefeed.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link cakefeed.Library#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see cakefeed.Library#getTypes()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Types();

	/**
	 * Returns the meta object for the containment reference list '{@link cakefeed.Library#getAlgorithms <em>Algorithms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Algorithms</em>'.
	 * @see cakefeed.Library#getAlgorithms()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Algorithms();

	/**
	 * Returns the meta object for enum '{@link cakefeed.PortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Port Type</em>'.
	 * @see cakefeed.PortType
	 * @generated
	 */
	EEnum getPortType();

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
		 * The meta object literal for the '{@link cakefeed.impl.ApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.ApplicationImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getApplication()
		 * @generated
		 */
		EClass APPLICATION = eINSTANCE.getApplication();

		/**
		 * The meta object literal for the '<em><b>Application Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__APPLICATION_NAME = eINSTANCE.getApplication_ApplicationName();

		/**
		 * The meta object literal for the '<em><b>Function Blocks Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__FUNCTION_BLOCKS_INSTANCES = eINSTANCE.getApplication_FunctionBlocksInstances();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__CONNECTIONS = eINSTANCE.getApplication_Connections();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.FunctionBlockImpl <em>Function Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.FunctionBlockImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getFunctionBlock()
		 * @generated
		 */
		EClass FUNCTION_BLOCK = eINSTANCE.getFunctionBlock();

		/**
		 * The meta object literal for the '<em><b>Parent Interface</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_BLOCK__PARENT_INTERFACE = eINSTANCE.getFunctionBlock_ParentInterface();

		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_BLOCK__TYPE_NAME = eINSTANCE.getFunctionBlock_TypeName();

		/**
		 * The meta object literal for the '<em><b>Input Event Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_BLOCK__INPUT_EVENT_PORTS = eINSTANCE.getFunctionBlock_InputEventPorts();

		/**
		 * The meta object literal for the '<em><b>Output Event Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_BLOCK__OUTPUT_EVENT_PORTS = eINSTANCE.getFunctionBlock_OutputEventPorts();

		/**
		 * The meta object literal for the '<em><b>Input Data Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_BLOCK__INPUT_DATA_PORTS = eINSTANCE.getFunctionBlock_InputDataPorts();

		/**
		 * The meta object literal for the '<em><b>Output Data Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_BLOCK__OUTPUT_DATA_PORTS = eINSTANCE.getFunctionBlock_OutputDataPorts();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.BasicFunctionBlockImpl <em>Basic Function Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.BasicFunctionBlockImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getBasicFunctionBlock()
		 * @generated
		 */
		EClass BASIC_FUNCTION_BLOCK = eINSTANCE.getBasicFunctionBlock();

		/**
		 * The meta object literal for the '<em><b>Execution Control Chart</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_FUNCTION_BLOCK__EXECUTION_CONTROL_CHART = eINSTANCE.getBasicFunctionBlock_ExecutionControlChart();

		/**
		 * The meta object literal for the '<em><b>Algorithms</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_FUNCTION_BLOCK__ALGORITHMS = eINSTANCE.getBasicFunctionBlock_Algorithms();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.CompositeFunctionBlockImpl <em>Composite Function Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.CompositeFunctionBlockImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getCompositeFunctionBlock()
		 * @generated
		 */
		EClass COMPOSITE_FUNCTION_BLOCK = eINSTANCE.getCompositeFunctionBlock();

		/**
		 * The meta object literal for the '<em><b>Composite Network</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK = eINSTANCE.getCompositeFunctionBlock_CompositeNetwork();

		/**
		 * The meta object literal for the '<em><b>Service Sequence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_FUNCTION_BLOCK__SERVICE_SEQUENCE = eINSTANCE.getCompositeFunctionBlock_ServiceSequence();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.ServiceInterfaceFunctionBlockImpl <em>Service Interface Function Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.ServiceInterfaceFunctionBlockImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getServiceInterfaceFunctionBlock()
		 * @generated
		 */
		EClass SERVICE_INTERFACE_FUNCTION_BLOCK = eINSTANCE.getServiceInterfaceFunctionBlock();

		/**
		 * The meta object literal for the '<em><b>Service Sequence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_INTERFACE_FUNCTION_BLOCK__SERVICE_SEQUENCE = eINSTANCE.getServiceInterfaceFunctionBlock_ServiceSequence();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.FunctionBlockInstanceImpl <em>Function Block Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.FunctionBlockInstanceImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getFunctionBlockInstance()
		 * @generated
		 */
		EClass FUNCTION_BLOCK_INSTANCE = eINSTANCE.getFunctionBlockInstance();

		/**
		 * The meta object literal for the '<em><b>Parent Application</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION = eINSTANCE.getFunctionBlockInstance_ParentApplication();

		/**
		 * The meta object literal for the '<em><b>Instance Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_BLOCK_INSTANCE__INSTANCE_NAME = eINSTANCE.getFunctionBlockInstance_InstanceName();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.BasicFunctionBlockInstanceImpl <em>Basic Function Block Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.BasicFunctionBlockInstanceImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getBasicFunctionBlockInstance()
		 * @generated
		 */
		EClass BASIC_FUNCTION_BLOCK_INSTANCE = eINSTANCE.getBasicFunctionBlockInstance();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_FUNCTION_BLOCK_INSTANCE__TYPE = eINSTANCE.getBasicFunctionBlockInstance_Type();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.CompositeFunctionBlockInstanceImpl <em>Composite Function Block Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.CompositeFunctionBlockInstanceImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getCompositeFunctionBlockInstance()
		 * @generated
		 */
		EClass COMPOSITE_FUNCTION_BLOCK_INSTANCE = eINSTANCE.getCompositeFunctionBlockInstance();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_FUNCTION_BLOCK_INSTANCE__TYPE = eINSTANCE.getCompositeFunctionBlockInstance_Type();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.ServiceInterfaceFunctionBlockInstanceImpl <em>Service Interface Function Block Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.ServiceInterfaceFunctionBlockInstanceImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getServiceInterfaceFunctionBlockInstance()
		 * @generated
		 */
		EClass SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE = eINSTANCE.getServiceInterfaceFunctionBlockInstance();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__TYPE = eINSTANCE.getServiceInterfaceFunctionBlockInstance_Type();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.ConnectionImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>Parent Application</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__PARENT_APPLICATION = eINSTANCE.getConnection_ParentApplication();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.EventConnectionImpl <em>Event Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.EventConnectionImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getEventConnection()
		 * @generated
		 */
		EClass EVENT_CONNECTION = eINSTANCE.getEventConnection();

		/**
		 * The meta object literal for the '<em><b>Source Event Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_CONNECTION__SOURCE_EVENT_PORT = eINSTANCE.getEventConnection_SourceEventPort();

		/**
		 * The meta object literal for the '<em><b>Target Event Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_CONNECTION__TARGET_EVENT_PORT = eINSTANCE.getEventConnection_TargetEventPort();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.DataConnectionImpl <em>Data Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.DataConnectionImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getDataConnection()
		 * @generated
		 */
		EClass DATA_CONNECTION = eINSTANCE.getDataConnection();

		/**
		 * The meta object literal for the '<em><b>Source Data Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CONNECTION__SOURCE_DATA_PORT = eINSTANCE.getDataConnection_SourceDataPort();

		/**
		 * The meta object literal for the '<em><b>Target Data Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CONNECTION__TARGET_DATA_PORT = eINSTANCE.getDataConnection_TargetDataPort();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.PortImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Port Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__PORT_NAME = eINSTANCE.getPort_PortName();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.EventPortImpl <em>Event Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.EventPortImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getEventPort()
		 * @generated
		 */
		EClass EVENT_PORT = eINSTANCE.getEventPort();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.DataPortImpl <em>Data Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.DataPortImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getDataPort()
		 * @generated
		 */
		EClass DATA_PORT = eINSTANCE.getDataPort();

		/**
		 * The meta object literal for the '<em><b>Port Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_PORT__PORT_TYPE = eINSTANCE.getDataPort_PortType();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.InputEventPortImpl <em>Input Event Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.InputEventPortImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getInputEventPort()
		 * @generated
		 */
		EClass INPUT_EVENT_PORT = eINSTANCE.getInputEventPort();

		/**
		 * The meta object literal for the '<em><b>Parent Function Block</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_EVENT_PORT__PARENT_FUNCTION_BLOCK = eINSTANCE.getInputEventPort_ParentFunctionBlock();

		/**
		 * The meta object literal for the '<em><b>Event Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_EVENT_PORT__EVENT_CONNECTIONS = eINSTANCE.getInputEventPort_EventConnections();

		/**
		 * The meta object literal for the '<em><b>Input Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_EVENT_PORT__INPUT_ASSOCIATIONS = eINSTANCE.getInputEventPort_InputAssociations();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.OutputEventPortImpl <em>Output Event Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.OutputEventPortImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getOutputEventPort()
		 * @generated
		 */
		EClass OUTPUT_EVENT_PORT = eINSTANCE.getOutputEventPort();

		/**
		 * The meta object literal for the '<em><b>Parent Function Block</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_EVENT_PORT__PARENT_FUNCTION_BLOCK = eINSTANCE.getOutputEventPort_ParentFunctionBlock();

		/**
		 * The meta object literal for the '<em><b>Event Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_EVENT_PORT__EVENT_CONNECTIONS = eINSTANCE.getOutputEventPort_EventConnections();

		/**
		 * The meta object literal for the '<em><b>Output Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_EVENT_PORT__OUTPUT_ASSOCIATIONS = eINSTANCE.getOutputEventPort_OutputAssociations();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.InputDataPortImpl <em>Input Data Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.InputDataPortImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getInputDataPort()
		 * @generated
		 */
		EClass INPUT_DATA_PORT = eINSTANCE.getInputDataPort();

		/**
		 * The meta object literal for the '<em><b>Parent Function Block</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_DATA_PORT__PARENT_FUNCTION_BLOCK = eINSTANCE.getInputDataPort_ParentFunctionBlock();

		/**
		 * The meta object literal for the '<em><b>Event Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_DATA_PORT__EVENT_CONNECTIONS = eINSTANCE.getInputDataPort_EventConnections();

		/**
		 * The meta object literal for the '<em><b>Input Associations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_DATA_PORT__INPUT_ASSOCIATIONS = eINSTANCE.getInputDataPort_InputAssociations();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.OutputDataPortImpl <em>Output Data Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.OutputDataPortImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getOutputDataPort()
		 * @generated
		 */
		EClass OUTPUT_DATA_PORT = eINSTANCE.getOutputDataPort();

		/**
		 * The meta object literal for the '<em><b>Parent Function Block</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_DATA_PORT__PARENT_FUNCTION_BLOCK = eINSTANCE.getOutputDataPort_ParentFunctionBlock();

		/**
		 * The meta object literal for the '<em><b>Event Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_DATA_PORT__EVENT_CONNECTIONS = eINSTANCE.getOutputDataPort_EventConnections();

		/**
		 * The meta object literal for the '<em><b>Output Associations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_DATA_PORT__OUTPUT_ASSOCIATIONS = eINSTANCE.getOutputDataPort_OutputAssociations();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.AlgorithmImpl <em>Algorithm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.AlgorithmImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getAlgorithm()
		 * @generated
		 */
		EClass ALGORITHM = eINSTANCE.getAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Algorithm Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALGORITHM__ALGORITHM_NAME = eINSTANCE.getAlgorithm_AlgorithmName();

		/**
		 * The meta object literal for the '<em><b>Algorithm Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALGORITHM__ALGORITHM_LANGUAGE = eINSTANCE.getAlgorithm_AlgorithmLanguage();

		/**
		 * The meta object literal for the '<em><b>Algorithm Source Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALGORITHM__ALGORITHM_SOURCE_CODE = eINSTANCE.getAlgorithm_AlgorithmSourceCode();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.CompositeNetworkImpl <em>Composite Network</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.CompositeNetworkImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getCompositeNetwork()
		 * @generated
		 */
		EClass COMPOSITE_NETWORK = eINSTANCE.getCompositeNetwork();

		/**
		 * The meta object literal for the '<em><b>Parent Composite Function Block</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK = eINSTANCE.getCompositeNetwork_ParentCompositeFunctionBlock();

		/**
		 * The meta object literal for the '<em><b>Input Events</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_NETWORK__INPUT_EVENTS = eINSTANCE.getCompositeNetwork_InputEvents();

		/**
		 * The meta object literal for the '<em><b>Output Events</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_NETWORK__OUTPUT_EVENTS = eINSTANCE.getCompositeNetwork_OutputEvents();

		/**
		 * The meta object literal for the '<em><b>Input Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_NETWORK__INPUT_DATA = eINSTANCE.getCompositeNetwork_InputData();

		/**
		 * The meta object literal for the '<em><b>Output Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_NETWORK__OUTPUT_DATA = eINSTANCE.getCompositeNetwork_OutputData();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.ServiceSequenceImpl <em>Service Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.ServiceSequenceImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getServiceSequence()
		 * @generated
		 */
		EClass SERVICE_SEQUENCE = eINSTANCE.getServiceSequence();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.AssociationImpl <em>Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.AssociationImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getAssociation()
		 * @generated
		 */
		EClass ASSOCIATION = eINSTANCE.getAssociation();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.InputAssociationImpl <em>Input Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.InputAssociationImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getInputAssociation()
		 * @generated
		 */
		EClass INPUT_ASSOCIATION = eINSTANCE.getInputAssociation();

		/**
		 * The meta object literal for the '<em><b>Source Input Event Port</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_ASSOCIATION__SOURCE_INPUT_EVENT_PORT = eINSTANCE.getInputAssociation_SourceInputEventPort();

		/**
		 * The meta object literal for the '<em><b>Target Input Data Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_ASSOCIATION__TARGET_INPUT_DATA_PORT = eINSTANCE.getInputAssociation_TargetInputDataPort();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.OutputAssociationImpl <em>Output Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.OutputAssociationImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getOutputAssociation()
		 * @generated
		 */
		EClass OUTPUT_ASSOCIATION = eINSTANCE.getOutputAssociation();

		/**
		 * The meta object literal for the '<em><b>Source Output Event Port</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_ASSOCIATION__SOURCE_OUTPUT_EVENT_PORT = eINSTANCE.getOutputAssociation_SourceOutputEventPort();

		/**
		 * The meta object literal for the '<em><b>Target Output Data Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_ASSOCIATION__TARGET_OUTPUT_DATA_PORT = eINSTANCE.getOutputAssociation_TargetOutputDataPort();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.InterfaceImpl <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.InterfaceImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '<em><b>Function Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__FUNCTION_BLOCK = eINSTANCE.getInterface_FunctionBlock();

		/**
		 * The meta object literal for the '{@link cakefeed.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.impl.LibraryImpl
		 * @see cakefeed.impl.CakefeedPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__TYPES = eINSTANCE.getLibrary_Types();

		/**
		 * The meta object literal for the '<em><b>Algorithms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__ALGORITHMS = eINSTANCE.getLibrary_Algorithms();

		/**
		 * The meta object literal for the '{@link cakefeed.PortType <em>Port Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cakefeed.PortType
		 * @see cakefeed.impl.CakefeedPackageImpl#getPortType()
		 * @generated
		 */
		EEnum PORT_TYPE = eINSTANCE.getPortType();

	}

} //CakefeedPackage
