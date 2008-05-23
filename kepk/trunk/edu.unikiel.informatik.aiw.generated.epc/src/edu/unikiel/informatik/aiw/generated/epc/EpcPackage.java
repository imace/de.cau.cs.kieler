/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.generated.epc;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see edu.unikiel.informatik.aiw.generated.epc.EpcFactory
 * @model kind="package"
 * @generated
 */
public interface EpcPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "epc";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://informatik.uni-kiel.de/aiw/epcmodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "epc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EpcPackage eINSTANCE = edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.EPCObject <em>EPC Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.EPCObject
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getEPCObject()
	 * @generated
	 */
	int EPC_OBJECT = 10;

	/**
	 * The feature id for the '<em><b>Show In EPC Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPC_OBJECT__SHOW_IN_EPC_EDITOR = 0;

	/**
	 * The number of structural features of the '<em>EPC Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPC_OBJECT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.Node <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.Node
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 9;

	/**
	 * The feature id for the '<em><b>Show In EPC Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SHOW_IN_EPC_EDITOR = EPC_OBJECT__SHOW_IN_EPC_EDITOR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = EPC_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = EPC_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.FunctionImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 2;

	/**
	 * The feature id for the '<em><b>Show In EPC Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__SHOW_IN_EPC_EDITOR = NODE__SHOW_IN_EPC_EDITOR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = NODE__NAME;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.EPCImpl <em>EPC</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EPCImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getEPC()
	 * @generated
	 */
	int EPC = 0;

	/**
	 * The feature id for the '<em><b>Show In EPC Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPC__SHOW_IN_EPC_EDITOR = FUNCTION__SHOW_IN_EPC_EDITOR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPC__NAME = FUNCTION__NAME;

	/**
	 * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPC__CONNECTORS = FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPC__OBJECTS = FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EPC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPC_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EventImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 1;

	/**
	 * The feature id for the '<em><b>Show In EPC Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__SHOW_IN_EPC_EDITOR = NODE__SHOW_IN_EPC_EDITOR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NAME = NODE__NAME;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.Relationship <em>Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.Relationship
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getRelationship()
	 * @generated
	 */
	int RELATIONSHIP = 11;

	/**
	 * The number of structural features of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.SuccessorOf <em>Successor Of</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.SuccessorOf
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getSuccessorOf()
	 * @generated
	 */
	int SUCCESSOR_OF = 13;

	/**
	 * The number of structural features of the '<em>Successor Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESSOR_OF_FEATURE_COUNT = RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.TriggersEventImpl <em>Triggers Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.TriggersEventImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getTriggersEvent()
	 * @generated
	 */
	int TRIGGERS_EVENT = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERS_EVENT__SOURCE = SUCCESSOR_OF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERS_EVENT__TARGET = SUCCESSOR_OF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Triggers Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERS_EVENT_FEATURE_COUNT = SUCCESSOR_OF_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.LogicalOperator <em>Logical Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.LogicalOperator
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getLogicalOperator()
	 * @generated
	 */
	int LOGICAL_OPERATOR = 4;

	/**
	 * The feature id for the '<em><b>Show In EPC Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_OPERATOR__SHOW_IN_EPC_EDITOR = EPC_OBJECT__SHOW_IN_EPC_EDITOR;

	/**
	 * The number of structural features of the '<em>Logical Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_OPERATOR_FEATURE_COUNT = EPC_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.XORImpl <em>XOR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.XORImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getXOR()
	 * @generated
	 */
	int XOR = 5;

	/**
	 * The feature id for the '<em><b>Show In EPC Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__SHOW_IN_EPC_EDITOR = LOGICAL_OPERATOR__SHOW_IN_EPC_EDITOR;

	/**
	 * The number of structural features of the '<em>XOR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_FEATURE_COUNT = LOGICAL_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.ORImpl <em>OR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.ORImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getOR()
	 * @generated
	 */
	int OR = 6;

	/**
	 * The feature id for the '<em><b>Show In EPC Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__SHOW_IN_EPC_EDITOR = LOGICAL_OPERATOR__SHOW_IN_EPC_EDITOR;

	/**
	 * The number of structural features of the '<em>OR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = LOGICAL_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.ANDImpl <em>AND</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.ANDImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getAND()
	 * @generated
	 */
	int AND = 7;

	/**
	 * The feature id for the '<em><b>Show In EPC Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__SHOW_IN_EPC_EDITOR = LOGICAL_OPERATOR__SHOW_IN_EPC_EDITOR;

	/**
	 * The number of structural features of the '<em>AND</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = LOGICAL_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.InformationImpl <em>Information</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.InformationImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getInformation()
	 * @generated
	 */
	int INFORMATION = 8;

	/**
	 * The feature id for the '<em><b>Show In EPC Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__SHOW_IN_EPC_EDITOR = NODE__SHOW_IN_EPC_EDITOR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__NAME = NODE__NAME;

	/**
	 * The number of structural features of the '<em>Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.ActivatesFunctionImpl <em>Activates Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.ActivatesFunctionImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getActivatesFunction()
	 * @generated
	 */
	int ACTIVATES_FUNCTION = 12;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATES_FUNCTION__SOURCE = SUCCESSOR_OF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATES_FUNCTION__TARGET = SUCCESSOR_OF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Activates Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATES_FUNCTION_FEATURE_COUNT = SUCCESSOR_OF_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.ProvidesDataToImpl <em>Provides Data To</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.ProvidesDataToImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getProvidesDataTo()
	 * @generated
	 */
	int PROVIDES_DATA_TO = 14;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_DATA_TO__SOURCE = RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_DATA_TO__TARGET = RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Provides Data To</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_DATA_TO_FEATURE_COUNT = RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.WritesDataToImpl <em>Writes Data To</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.WritesDataToImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getWritesDataTo()
	 * @generated
	 */
	int WRITES_DATA_TO = 15;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITES_DATA_TO__SOURCE = RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITES_DATA_TO__TARGET = RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Writes Data To</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITES_DATA_TO_FEATURE_COUNT = RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.FunctionToOperatorConnectionImpl <em>Function To Operator Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.FunctionToOperatorConnectionImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getFunctionToOperatorConnection()
	 * @generated
	 */
	int FUNCTION_TO_OPERATOR_CONNECTION = 16;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_OPERATOR_CONNECTION__FUNCTION = SUCCESSOR_OF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_OPERATOR_CONNECTION__OPERATOR = SUCCESSOR_OF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function To Operator Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_OPERATOR_CONNECTION_FEATURE_COUNT = SUCCESSOR_OF_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.EventToOperatorConnectionImpl <em>Event To Operator Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EventToOperatorConnectionImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getEventToOperatorConnection()
	 * @generated
	 */
	int EVENT_TO_OPERATOR_CONNECTION = 17;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TO_OPERATOR_CONNECTION__EVENT = SUCCESSOR_OF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TO_OPERATOR_CONNECTION__OPERATOR = SUCCESSOR_OF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Event To Operator Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TO_OPERATOR_CONNECTION_FEATURE_COUNT = SUCCESSOR_OF_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.OperatorToFunctionConnectionImpl <em>Operator To Function Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.OperatorToFunctionConnectionImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getOperatorToFunctionConnection()
	 * @generated
	 */
	int OPERATOR_TO_FUNCTION_CONNECTION = 18;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TO_FUNCTION_CONNECTION__FUNCTION = SUCCESSOR_OF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TO_FUNCTION_CONNECTION__OPERATOR = SUCCESSOR_OF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operator To Function Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TO_FUNCTION_CONNECTION_FEATURE_COUNT = SUCCESSOR_OF_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.OperatorToEventConnectionImpl <em>Operator To Event Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.OperatorToEventConnectionImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getOperatorToEventConnection()
	 * @generated
	 */
	int OPERATOR_TO_EVENT_CONNECTION = 19;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TO_EVENT_CONNECTION__EVENT = SUCCESSOR_OF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TO_EVENT_CONNECTION__OPERATOR = SUCCESSOR_OF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operator To Event Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_TO_EVENT_CONNECTION_FEATURE_COUNT = SUCCESSOR_OF_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.GCTLconnectorImpl <em>GCT Lconnector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.GCTLconnectorImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getGCTLconnector()
	 * @generated
	 */
	int GCT_LCONNECTOR = 20;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GCT_LCONNECTOR__SOURCE = RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GCT_LCONNECTOR__TARGET = RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>GCT Lconnector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GCT_LCONNECTOR_FEATURE_COUNT = RELATIONSHIP_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.ImplicationImpl <em>Implication</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.ImplicationImpl
	 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getImplication()
	 * @generated
	 */
	int IMPLICATION = 21;

	/**
	 * The feature id for the '<em><b>Show In EPC Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION__SHOW_IN_EPC_EDITOR = NODE__SHOW_IN_EPC_EDITOR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION__NAME = NODE__NAME;

	/**
	 * The number of structural features of the '<em>Implication</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.EPC <em>EPC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EPC</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.EPC
	 * @generated
	 */
	EClass getEPC();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.unikiel.informatik.aiw.generated.epc.EPC#getConnectors <em>Connectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connectors</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.EPC#getConnectors()
	 * @see #getEPC()
	 * @generated
	 */
	EReference getEPC_Connectors();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.unikiel.informatik.aiw.generated.epc.EPC#getObjects <em>Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Objects</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.EPC#getObjects()
	 * @see #getEPC()
	 * @generated
	 */
	EReference getEPC_Objects();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.TriggersEvent <em>Triggers Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Triggers Event</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.TriggersEvent
	 * @generated
	 */
	EClass getTriggersEvent();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.TriggersEvent#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.TriggersEvent#getSource()
	 * @see #getTriggersEvent()
	 * @generated
	 */
	EReference getTriggersEvent_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.TriggersEvent#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.TriggersEvent#getTarget()
	 * @see #getTriggersEvent()
	 * @generated
	 */
	EReference getTriggersEvent_Target();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.LogicalOperator <em>Logical Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Operator</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.LogicalOperator
	 * @generated
	 */
	EClass getLogicalOperator();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.XOR <em>XOR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XOR</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.XOR
	 * @generated
	 */
	EClass getXOR();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.OR <em>OR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OR</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.OR
	 * @generated
	 */
	EClass getOR();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.AND <em>AND</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AND</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.AND
	 * @generated
	 */
	EClass getAND();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.Information <em>Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Information</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.Information
	 * @generated
	 */
	EClass getInformation();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.informatik.aiw.generated.epc.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.EPCObject <em>EPC Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EPC Object</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.EPCObject
	 * @generated
	 */
	EClass getEPCObject();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.informatik.aiw.generated.epc.EPCObject#isShowInEPCEditor <em>Show In EPC Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show In EPC Editor</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.EPCObject#isShowInEPCEditor()
	 * @see #getEPCObject()
	 * @generated
	 */
	EAttribute getEPCObject_ShowInEPCEditor();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relationship</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.Relationship
	 * @generated
	 */
	EClass getRelationship();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.ActivatesFunction <em>Activates Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activates Function</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.ActivatesFunction
	 * @generated
	 */
	EClass getActivatesFunction();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.ActivatesFunction#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.ActivatesFunction#getSource()
	 * @see #getActivatesFunction()
	 * @generated
	 */
	EReference getActivatesFunction_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.ActivatesFunction#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.ActivatesFunction#getTarget()
	 * @see #getActivatesFunction()
	 * @generated
	 */
	EReference getActivatesFunction_Target();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.SuccessorOf <em>Successor Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Successor Of</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.SuccessorOf
	 * @generated
	 */
	EClass getSuccessorOf();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.ProvidesDataTo <em>Provides Data To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Provides Data To</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.ProvidesDataTo
	 * @generated
	 */
	EClass getProvidesDataTo();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.ProvidesDataTo#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.ProvidesDataTo#getSource()
	 * @see #getProvidesDataTo()
	 * @generated
	 */
	EReference getProvidesDataTo_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.ProvidesDataTo#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.ProvidesDataTo#getTarget()
	 * @see #getProvidesDataTo()
	 * @generated
	 */
	EReference getProvidesDataTo_Target();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.WritesDataTo <em>Writes Data To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Writes Data To</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.WritesDataTo
	 * @generated
	 */
	EClass getWritesDataTo();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.WritesDataTo#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.WritesDataTo#getSource()
	 * @see #getWritesDataTo()
	 * @generated
	 */
	EReference getWritesDataTo_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.WritesDataTo#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.WritesDataTo#getTarget()
	 * @see #getWritesDataTo()
	 * @generated
	 */
	EReference getWritesDataTo_Target();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.FunctionToOperatorConnection <em>Function To Operator Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function To Operator Connection</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.FunctionToOperatorConnection
	 * @generated
	 */
	EClass getFunctionToOperatorConnection();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.FunctionToOperatorConnection#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.FunctionToOperatorConnection#getFunction()
	 * @see #getFunctionToOperatorConnection()
	 * @generated
	 */
	EReference getFunctionToOperatorConnection_Function();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.FunctionToOperatorConnection#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operator</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.FunctionToOperatorConnection#getOperator()
	 * @see #getFunctionToOperatorConnection()
	 * @generated
	 */
	EReference getFunctionToOperatorConnection_Operator();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.EventToOperatorConnection <em>Event To Operator Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event To Operator Connection</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.EventToOperatorConnection
	 * @generated
	 */
	EClass getEventToOperatorConnection();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.EventToOperatorConnection#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.EventToOperatorConnection#getEvent()
	 * @see #getEventToOperatorConnection()
	 * @generated
	 */
	EReference getEventToOperatorConnection_Event();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.EventToOperatorConnection#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operator</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.EventToOperatorConnection#getOperator()
	 * @see #getEventToOperatorConnection()
	 * @generated
	 */
	EReference getEventToOperatorConnection_Operator();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.OperatorToFunctionConnection <em>Operator To Function Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator To Function Connection</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.OperatorToFunctionConnection
	 * @generated
	 */
	EClass getOperatorToFunctionConnection();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.OperatorToFunctionConnection#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.OperatorToFunctionConnection#getFunction()
	 * @see #getOperatorToFunctionConnection()
	 * @generated
	 */
	EReference getOperatorToFunctionConnection_Function();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.OperatorToFunctionConnection#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operator</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.OperatorToFunctionConnection#getOperator()
	 * @see #getOperatorToFunctionConnection()
	 * @generated
	 */
	EReference getOperatorToFunctionConnection_Operator();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.OperatorToEventConnection <em>Operator To Event Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator To Event Connection</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.OperatorToEventConnection
	 * @generated
	 */
	EClass getOperatorToEventConnection();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.OperatorToEventConnection#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.OperatorToEventConnection#getEvent()
	 * @see #getOperatorToEventConnection()
	 * @generated
	 */
	EReference getOperatorToEventConnection_Event();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.OperatorToEventConnection#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operator</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.OperatorToEventConnection#getOperator()
	 * @see #getOperatorToEventConnection()
	 * @generated
	 */
	EReference getOperatorToEventConnection_Operator();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.GCTLconnector <em>GCT Lconnector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>GCT Lconnector</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.GCTLconnector
	 * @generated
	 */
	EClass getGCTLconnector();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.GCTLconnector#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.GCTLconnector#getSource()
	 * @see #getGCTLconnector()
	 * @generated
	 */
	EReference getGCTLconnector_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.generated.epc.GCTLconnector#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.GCTLconnector#getTarget()
	 * @see #getGCTLconnector()
	 * @generated
	 */
	EReference getGCTLconnector_Target();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.generated.epc.Implication <em>Implication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implication</em>'.
	 * @see edu.unikiel.informatik.aiw.generated.epc.Implication
	 * @generated
	 */
	EClass getImplication();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EpcFactory getEpcFactory();

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
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.EPCImpl <em>EPC</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EPCImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getEPC()
		 * @generated
		 */
		EClass EPC = eINSTANCE.getEPC();

		/**
		 * The meta object literal for the '<em><b>Connectors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPC__CONNECTORS = eINSTANCE.getEPC_Connectors();

		/**
		 * The meta object literal for the '<em><b>Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPC__OBJECTS = eINSTANCE.getEPC_Objects();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EventImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.FunctionImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.TriggersEventImpl <em>Triggers Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.TriggersEventImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getTriggersEvent()
		 * @generated
		 */
		EClass TRIGGERS_EVENT = eINSTANCE.getTriggersEvent();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIGGERS_EVENT__SOURCE = eINSTANCE.getTriggersEvent_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIGGERS_EVENT__TARGET = eINSTANCE.getTriggersEvent_Target();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.LogicalOperator <em>Logical Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.LogicalOperator
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getLogicalOperator()
		 * @generated
		 */
		EClass LOGICAL_OPERATOR = eINSTANCE.getLogicalOperator();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.XORImpl <em>XOR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.XORImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getXOR()
		 * @generated
		 */
		EClass XOR = eINSTANCE.getXOR();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.ORImpl <em>OR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.ORImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getOR()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOR();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.ANDImpl <em>AND</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.ANDImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getAND()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAND();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.InformationImpl <em>Information</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.InformationImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getInformation()
		 * @generated
		 */
		EClass INFORMATION = eINSTANCE.getInformation();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.Node <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.Node
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NAME = eINSTANCE.getNode_Name();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.EPCObject <em>EPC Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.EPCObject
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getEPCObject()
		 * @generated
		 */
		EClass EPC_OBJECT = eINSTANCE.getEPCObject();

		/**
		 * The meta object literal for the '<em><b>Show In EPC Editor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPC_OBJECT__SHOW_IN_EPC_EDITOR = eINSTANCE.getEPCObject_ShowInEPCEditor();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.Relationship <em>Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.Relationship
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getRelationship()
		 * @generated
		 */
		EClass RELATIONSHIP = eINSTANCE.getRelationship();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.ActivatesFunctionImpl <em>Activates Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.ActivatesFunctionImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getActivatesFunction()
		 * @generated
		 */
		EClass ACTIVATES_FUNCTION = eINSTANCE.getActivatesFunction();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVATES_FUNCTION__SOURCE = eINSTANCE.getActivatesFunction_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVATES_FUNCTION__TARGET = eINSTANCE.getActivatesFunction_Target();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.SuccessorOf <em>Successor Of</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.SuccessorOf
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getSuccessorOf()
		 * @generated
		 */
		EClass SUCCESSOR_OF = eINSTANCE.getSuccessorOf();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.ProvidesDataToImpl <em>Provides Data To</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.ProvidesDataToImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getProvidesDataTo()
		 * @generated
		 */
		EClass PROVIDES_DATA_TO = eINSTANCE.getProvidesDataTo();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROVIDES_DATA_TO__SOURCE = eINSTANCE.getProvidesDataTo_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROVIDES_DATA_TO__TARGET = eINSTANCE.getProvidesDataTo_Target();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.WritesDataToImpl <em>Writes Data To</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.WritesDataToImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getWritesDataTo()
		 * @generated
		 */
		EClass WRITES_DATA_TO = eINSTANCE.getWritesDataTo();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WRITES_DATA_TO__SOURCE = eINSTANCE.getWritesDataTo_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WRITES_DATA_TO__TARGET = eINSTANCE.getWritesDataTo_Target();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.FunctionToOperatorConnectionImpl <em>Function To Operator Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.FunctionToOperatorConnectionImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getFunctionToOperatorConnection()
		 * @generated
		 */
		EClass FUNCTION_TO_OPERATOR_CONNECTION = eINSTANCE.getFunctionToOperatorConnection();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TO_OPERATOR_CONNECTION__FUNCTION = eINSTANCE.getFunctionToOperatorConnection_Function();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TO_OPERATOR_CONNECTION__OPERATOR = eINSTANCE.getFunctionToOperatorConnection_Operator();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.EventToOperatorConnectionImpl <em>Event To Operator Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EventToOperatorConnectionImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getEventToOperatorConnection()
		 * @generated
		 */
		EClass EVENT_TO_OPERATOR_CONNECTION = eINSTANCE.getEventToOperatorConnection();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_TO_OPERATOR_CONNECTION__EVENT = eINSTANCE.getEventToOperatorConnection_Event();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_TO_OPERATOR_CONNECTION__OPERATOR = eINSTANCE.getEventToOperatorConnection_Operator();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.OperatorToFunctionConnectionImpl <em>Operator To Function Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.OperatorToFunctionConnectionImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getOperatorToFunctionConnection()
		 * @generated
		 */
		EClass OPERATOR_TO_FUNCTION_CONNECTION = eINSTANCE.getOperatorToFunctionConnection();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_TO_FUNCTION_CONNECTION__FUNCTION = eINSTANCE.getOperatorToFunctionConnection_Function();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_TO_FUNCTION_CONNECTION__OPERATOR = eINSTANCE.getOperatorToFunctionConnection_Operator();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.OperatorToEventConnectionImpl <em>Operator To Event Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.OperatorToEventConnectionImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getOperatorToEventConnection()
		 * @generated
		 */
		EClass OPERATOR_TO_EVENT_CONNECTION = eINSTANCE.getOperatorToEventConnection();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_TO_EVENT_CONNECTION__EVENT = eINSTANCE.getOperatorToEventConnection_Event();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_TO_EVENT_CONNECTION__OPERATOR = eINSTANCE.getOperatorToEventConnection_Operator();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.GCTLconnectorImpl <em>GCT Lconnector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.GCTLconnectorImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getGCTLconnector()
		 * @generated
		 */
		EClass GCT_LCONNECTOR = eINSTANCE.getGCTLconnector();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GCT_LCONNECTOR__SOURCE = eINSTANCE.getGCTLconnector_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GCT_LCONNECTOR__TARGET = eINSTANCE.getGCTLconnector_Target();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.generated.epc.impl.ImplicationImpl <em>Implication</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.ImplicationImpl
		 * @see edu.unikiel.informatik.aiw.generated.epc.impl.EpcPackageImpl#getImplication()
		 * @generated
		 */
		EClass IMPLICATION = eINSTANCE.getImplication();

	}

} //EpcPackage
