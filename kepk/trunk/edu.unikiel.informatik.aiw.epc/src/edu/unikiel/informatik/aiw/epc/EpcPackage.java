/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.epc;

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
 * @see edu.unikiel.informatik.aiw.epc.EpcFactory
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
	EpcPackage eINSTANCE = edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.EPCObject <em>EPC Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.EPCObject
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getEPCObject()
	 * @generated
	 */
	int EPC_OBJECT = 10;

	/**
	 * The number of structural features of the '<em>EPC Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPC_OBJECT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.Node <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.Node
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 9;

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
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.impl.FunctionImpl
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 2;

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
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.impl.EPCImpl <em>EPC</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.impl.EPCImpl
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getEPC()
	 * @generated
	 */
	int EPC = 0;

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
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.impl.EventImpl
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 1;

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
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.Relationship <em>Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.Relationship
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getRelationship()
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
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.SuccessorOf <em>Successor Of</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.SuccessorOf
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getSuccessorOf()
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
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.impl.TriggersEventImpl <em>Triggers Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.impl.TriggersEventImpl
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getTriggersEvent()
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
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.LogicalOperator <em>Logical Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.LogicalOperator
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getLogicalOperator()
	 * @generated
	 */
	int LOGICAL_OPERATOR = 4;

	/**
	 * The number of structural features of the '<em>Logical Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_OPERATOR_FEATURE_COUNT = EPC_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.impl.XORImpl <em>XOR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.impl.XORImpl
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getXOR()
	 * @generated
	 */
	int XOR = 5;

	/**
	 * The number of structural features of the '<em>XOR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_FEATURE_COUNT = LOGICAL_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.impl.ORImpl <em>OR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.impl.ORImpl
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getOR()
	 * @generated
	 */
	int OR = 6;

	/**
	 * The number of structural features of the '<em>OR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = LOGICAL_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.impl.ANDImpl <em>AND</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.impl.ANDImpl
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getAND()
	 * @generated
	 */
	int AND = 7;

	/**
	 * The number of structural features of the '<em>AND</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = LOGICAL_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.impl.InformationImpl <em>Information</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.impl.InformationImpl
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getInformation()
	 * @generated
	 */
	int INFORMATION = 8;

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
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.impl.ActivatesFunctionImpl <em>Activates Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.impl.ActivatesFunctionImpl
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getActivatesFunction()
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
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.impl.ProvidesDataToImpl <em>Provides Data To</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.impl.ProvidesDataToImpl
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getProvidesDataTo()
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
	 * The meta object id for the '{@link edu.unikiel.informatik.aiw.epc.impl.WritesDataToImpl <em>Writes Data To</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.unikiel.informatik.aiw.epc.impl.WritesDataToImpl
	 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getWritesDataTo()
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
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.EPC <em>EPC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EPC</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.EPC
	 * @generated
	 */
	EClass getEPC();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.unikiel.informatik.aiw.epc.EPC#getConnectors <em>Connectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connectors</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.EPC#getConnectors()
	 * @see #getEPC()
	 * @generated
	 */
	EReference getEPC_Connectors();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.unikiel.informatik.aiw.epc.EPC#getObjects <em>Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Objects</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.EPC#getObjects()
	 * @see #getEPC()
	 * @generated
	 */
	EReference getEPC_Objects();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.TriggersEvent <em>Triggers Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Triggers Event</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.TriggersEvent
	 * @generated
	 */
	EClass getTriggersEvent();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.epc.TriggersEvent#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.TriggersEvent#getSource()
	 * @see #getTriggersEvent()
	 * @generated
	 */
	EReference getTriggersEvent_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.epc.TriggersEvent#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.TriggersEvent#getTarget()
	 * @see #getTriggersEvent()
	 * @generated
	 */
	EReference getTriggersEvent_Target();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.LogicalOperator <em>Logical Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Operator</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.LogicalOperator
	 * @generated
	 */
	EClass getLogicalOperator();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.XOR <em>XOR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XOR</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.XOR
	 * @generated
	 */
	EClass getXOR();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.OR <em>OR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OR</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.OR
	 * @generated
	 */
	EClass getOR();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.AND <em>AND</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AND</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.AND
	 * @generated
	 */
	EClass getAND();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.Information <em>Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Information</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.Information
	 * @generated
	 */
	EClass getInformation();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link edu.unikiel.informatik.aiw.epc.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.EPCObject <em>EPC Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EPC Object</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.EPCObject
	 * @generated
	 */
	EClass getEPCObject();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relationship</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.Relationship
	 * @generated
	 */
	EClass getRelationship();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.ActivatesFunction <em>Activates Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activates Function</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.ActivatesFunction
	 * @generated
	 */
	EClass getActivatesFunction();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.epc.ActivatesFunction#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.ActivatesFunction#getSource()
	 * @see #getActivatesFunction()
	 * @generated
	 */
	EReference getActivatesFunction_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.epc.ActivatesFunction#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.ActivatesFunction#getTarget()
	 * @see #getActivatesFunction()
	 * @generated
	 */
	EReference getActivatesFunction_Target();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.SuccessorOf <em>Successor Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Successor Of</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.SuccessorOf
	 * @generated
	 */
	EClass getSuccessorOf();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.ProvidesDataTo <em>Provides Data To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Provides Data To</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.ProvidesDataTo
	 * @generated
	 */
	EClass getProvidesDataTo();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.epc.ProvidesDataTo#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.ProvidesDataTo#getSource()
	 * @see #getProvidesDataTo()
	 * @generated
	 */
	EReference getProvidesDataTo_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.epc.ProvidesDataTo#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.ProvidesDataTo#getTarget()
	 * @see #getProvidesDataTo()
	 * @generated
	 */
	EReference getProvidesDataTo_Target();

	/**
	 * Returns the meta object for class '{@link edu.unikiel.informatik.aiw.epc.WritesDataTo <em>Writes Data To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Writes Data To</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.WritesDataTo
	 * @generated
	 */
	EClass getWritesDataTo();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.epc.WritesDataTo#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.WritesDataTo#getSource()
	 * @see #getWritesDataTo()
	 * @generated
	 */
	EReference getWritesDataTo_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.unikiel.informatik.aiw.epc.WritesDataTo#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.unikiel.informatik.aiw.epc.WritesDataTo#getTarget()
	 * @see #getWritesDataTo()
	 * @generated
	 */
	EReference getWritesDataTo_Target();

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
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.impl.EPCImpl <em>EPC</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.impl.EPCImpl
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getEPC()
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
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.impl.EventImpl
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.impl.FunctionImpl
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.impl.TriggersEventImpl <em>Triggers Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.impl.TriggersEventImpl
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getTriggersEvent()
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
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.LogicalOperator <em>Logical Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.LogicalOperator
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getLogicalOperator()
		 * @generated
		 */
		EClass LOGICAL_OPERATOR = eINSTANCE.getLogicalOperator();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.impl.XORImpl <em>XOR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.impl.XORImpl
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getXOR()
		 * @generated
		 */
		EClass XOR = eINSTANCE.getXOR();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.impl.ORImpl <em>OR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.impl.ORImpl
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getOR()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOR();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.impl.ANDImpl <em>AND</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.impl.ANDImpl
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getAND()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAND();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.impl.InformationImpl <em>Information</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.impl.InformationImpl
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getInformation()
		 * @generated
		 */
		EClass INFORMATION = eINSTANCE.getInformation();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.Node <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.Node
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getNode()
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
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.EPCObject <em>EPC Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.EPCObject
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getEPCObject()
		 * @generated
		 */
		EClass EPC_OBJECT = eINSTANCE.getEPCObject();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.Relationship <em>Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.Relationship
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getRelationship()
		 * @generated
		 */
		EClass RELATIONSHIP = eINSTANCE.getRelationship();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.impl.ActivatesFunctionImpl <em>Activates Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.impl.ActivatesFunctionImpl
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getActivatesFunction()
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
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.SuccessorOf <em>Successor Of</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.SuccessorOf
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getSuccessorOf()
		 * @generated
		 */
		EClass SUCCESSOR_OF = eINSTANCE.getSuccessorOf();

		/**
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.impl.ProvidesDataToImpl <em>Provides Data To</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.impl.ProvidesDataToImpl
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getProvidesDataTo()
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
		 * The meta object literal for the '{@link edu.unikiel.informatik.aiw.epc.impl.WritesDataToImpl <em>Writes Data To</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.unikiel.informatik.aiw.epc.impl.WritesDataToImpl
		 * @see edu.unikiel.informatik.aiw.epc.impl.EpcPackageImpl#getWritesDataTo()
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

	}

} //EpcPackage
