/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm2;

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
 * @see ssm2.Ssm2Factory
 * @model kind="package"
 * @generated
 */
public interface Ssm2Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ssm2";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.informatik.uni-kiel.de/rtsys/ssm2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ssm2";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Ssm2Package eINSTANCE = ssm2.impl.Ssm2PackageImpl.init();

	/**
	 * The meta object id for the '{@link ssm2.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.impl.StateImpl
	 * @see ssm2.impl.Ssm2PackageImpl#getState()
	 * @generated
	 */
	int STATE = 0;

	/**
	 * The feature id for the '<em><b>State Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__STATE_KIND = 0;

	/**
	 * The feature id for the '<em><b>State Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__STATE_FLAG = 1;

	/**
	 * The feature id for the '<em><b>Signals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__SIGNALS = 2;

	/**
	 * The feature id for the '<em><b>Inner States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INNER_STATES = 3;

	/**
	 * The feature id for the '<em><b>Entry Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ENTRY_ACTIONS = 4;

	/**
	 * The feature id for the '<em><b>Inner Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INNER_ACTIONS = 5;

	/**
	 * The feature id for the '<em><b>Exit Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__EXIT_ACTIONS = 6;

	/**
	 * The feature id for the '<em><b>Signal Renamings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__SIGNAL_RENAMINGS = 7;

	/**
	 * The feature id for the '<em><b>Suspension Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__SUSPENSION_TRIGGER = 8;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTGOING_TRANSITIONS = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = 10;

	/**
	 * The feature id for the '<em><b>Parent State</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__PARENT_STATE = 11;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__VARIABLES = 12;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 13;

	/**
	 * The meta object id for the '{@link ssm2.impl.SignalImpl <em>Signal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.impl.SignalImpl
	 * @see ssm2.impl.Ssm2PackageImpl#getSignal()
	 * @generated
	 */
	int SIGNAL = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__NAME = 1;

	/**
	 * The feature id for the '<em><b>Parent State</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__PARENT_STATE = 2;

	/**
	 * The feature id for the '<em><b>Is Local</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__IS_LOCAL = 3;

	/**
	 * The feature id for the '<em><b>Is Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__IS_INPUT = 4;

	/**
	 * The feature id for the '<em><b>Is Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__IS_OUTPUT = 5;

	/**
	 * The number of structural features of the '<em>Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link ssm2.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.impl.ValueImpl
	 * @see ssm2.impl.Ssm2PackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Parent Signal</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__PARENT_SIGNAL = 1;

	/**
	 * The feature id for the '<em><b>Parent Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__PARENT_VARIABLE = 2;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link ssm2.impl.EmissionImpl <em>Emission</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.impl.EmissionImpl
	 * @see ssm2.impl.Ssm2PackageImpl#getEmission()
	 * @generated
	 */
	int EMISSION = 3;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION__NEW_VALUE = 0;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION__SIGNAL = 1;

	/**
	 * The feature id for the '<em><b>Parent Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION__PARENT_ACTION = 2;

	/**
	 * The number of structural features of the '<em>Emission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMISSION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link ssm2.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.impl.ActionImpl
	 * @see ssm2.impl.Ssm2PackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 8;

	/**
	 * The feature id for the '<em><b>Emissions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__EMISSIONS = 0;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__TRIGGER = 1;

	/**
	 * The feature id for the '<em><b>Parent State Entry Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PARENT_STATE_ENTRY_ACTION = 2;

	/**
	 * The feature id for the '<em><b>Parent State Inner Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PARENT_STATE_INNER_ACTION = 3;

	/**
	 * The feature id for the '<em><b>Parent State Exit Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PARENT_STATE_EXIT_ACTION = 4;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ASSIGNMENTS = 5;

	/**
	 * The feature id for the '<em><b>Triggers And Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__TRIGGERS_AND_EFFECTS = 6;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link ssm2.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.impl.TransitionImpl
	 * @see ssm2.impl.Ssm2PackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 4;

	/**
	 * The feature id for the '<em><b>Emissions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EMISSIONS = ACTION__EMISSIONS;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TRIGGER = ACTION__TRIGGER;

	/**
	 * The feature id for the '<em><b>Parent State Entry Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__PARENT_STATE_ENTRY_ACTION = ACTION__PARENT_STATE_ENTRY_ACTION;

	/**
	 * The feature id for the '<em><b>Parent State Inner Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__PARENT_STATE_INNER_ACTION = ACTION__PARENT_STATE_INNER_ACTION;

	/**
	 * The feature id for the '<em><b>Parent State Exit Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__PARENT_STATE_EXIT_ACTION = ACTION__PARENT_STATE_EXIT_ACTION;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ASSIGNMENTS = ACTION__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Triggers And Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TRIGGERS_AND_EFFECTS = ACTION__TRIGGERS_AND_EFFECTS;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__DELAY = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Immediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__IMMEDIATE = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__PRIORITY = ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Transition Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TRANSITION_KIND = ACTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET_STATE = ACTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Source State</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE_STATE = ACTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>History</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__HISTORY = ACTION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link ssm2.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.impl.ExpressionImpl
	 * @see ssm2.impl.Ssm2PackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Sub Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__SUB_EXPRESSIONS = 0;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__SIGNAL = 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__OPERATOR = 2;

	/**
	 * The feature id for the '<em><b>Parent Expression</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__PARENT_EXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>Parent Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__PARENT_ACTION = 4;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__VARIABLE = 5;

	/**
	 * The feature id for the '<em><b>Parent Emisson</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__PARENT_EMISSON = 6;

	/**
	 * The feature id for the '<em><b>Assignment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__ASSIGNMENT = 7;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link ssm2.impl.SignalRenamingImpl <em>Signal Renaming</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.impl.SignalRenamingImpl
	 * @see ssm2.impl.Ssm2PackageImpl#getSignalRenaming()
	 * @generated
	 */
	int SIGNAL_RENAMING = 6;

	/**
	 * The feature id for the '<em><b>Old Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_RENAMING__OLD_SIGNAL = 0;

	/**
	 * The feature id for the '<em><b>New Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_RENAMING__NEW_SIGNAL = 1;

	/**
	 * The feature id for the '<em><b>Parent State</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_RENAMING__PARENT_STATE = 2;

	/**
	 * The number of structural features of the '<em>Signal Renaming</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_RENAMING_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link ssm2.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.impl.OperatorImpl
	 * @see ssm2.impl.Ssm2PackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 7;

	/**
	 * The feature id for the '<em><b>Operator Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__OPERATOR_KIND = 0;

	/**
	 * The feature id for the '<em><b>Parent Expression</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__PARENT_EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link ssm2.impl.SuspensionTriggerImpl <em>Suspension Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.impl.SuspensionTriggerImpl
	 * @see ssm2.impl.Ssm2PackageImpl#getSuspensionTrigger()
	 * @generated
	 */
	int SUSPENSION_TRIGGER = 9;

	/**
	 * The feature id for the '<em><b>Sub Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__SUB_EXPRESSIONS = EXPRESSION__SUB_EXPRESSIONS;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__SIGNAL = EXPRESSION__SIGNAL;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__OPERATOR = EXPRESSION__OPERATOR;

	/**
	 * The feature id for the '<em><b>Parent Expression</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__PARENT_EXPRESSION = EXPRESSION__PARENT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Parent Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__PARENT_ACTION = EXPRESSION__PARENT_ACTION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__VARIABLE = EXPRESSION__VARIABLE;

	/**
	 * The feature id for the '<em><b>Parent Emisson</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__PARENT_EMISSON = EXPRESSION__PARENT_EMISSON;

	/**
	 * The feature id for the '<em><b>Assignment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__ASSIGNMENT = EXPRESSION__ASSIGNMENT;

	/**
	 * The feature id for the '<em><b>Parent State</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__PARENT_STATE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Immediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__IMMEDIATE = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Suspension Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ssm2.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.impl.AssignmentImpl
	 * @see ssm2.impl.Ssm2PackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 10;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Parent Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__PARENT_EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link ssm2.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.impl.VariableImpl
	 * @see ssm2.impl.Ssm2PackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 11;

	/**
	 * The feature id for the '<em><b>Vname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__VNAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Parent State</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__PARENT_STATE = 2;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link ssm2.StateKind <em>State Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.StateKind
	 * @see ssm2.impl.Ssm2PackageImpl#getStateKind()
	 * @generated
	 */
	int STATE_KIND = 12;

	/**
	 * The meta object id for the '{@link ssm2.StateFlag <em>State Flag</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.StateFlag
	 * @see ssm2.impl.Ssm2PackageImpl#getStateFlag()
	 * @generated
	 */
	int STATE_FLAG = 13;

	/**
	 * The meta object id for the '{@link ssm2.TransitionKind <em>Transition Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.TransitionKind
	 * @see ssm2.impl.Ssm2PackageImpl#getTransitionKind()
	 * @generated
	 */
	int TRANSITION_KIND = 14;

	/**
	 * The meta object id for the '{@link ssm2.OperatorKind <em>Operator Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm2.OperatorKind
	 * @see ssm2.impl.Ssm2PackageImpl#getOperatorKind()
	 * @generated
	 */
	int OPERATOR_KIND = 15;


	/**
	 * Returns the meta object for class '{@link ssm2.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see ssm2.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.State#getStateKind <em>State Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Kind</em>'.
	 * @see ssm2.State#getStateKind()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_StateKind();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.State#getStateFlag <em>State Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Flag</em>'.
	 * @see ssm2.State#getStateFlag()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_StateFlag();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm2.State#getSignals <em>Signals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Signals</em>'.
	 * @see ssm2.State#getSignals()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Signals();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm2.State#getInnerStates <em>Inner States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inner States</em>'.
	 * @see ssm2.State#getInnerStates()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_InnerStates();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm2.State#getEntryActions <em>Entry Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entry Actions</em>'.
	 * @see ssm2.State#getEntryActions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_EntryActions();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm2.State#getInnerActions <em>Inner Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inner Actions</em>'.
	 * @see ssm2.State#getInnerActions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_InnerActions();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm2.State#getExitActions <em>Exit Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exit Actions</em>'.
	 * @see ssm2.State#getExitActions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_ExitActions();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm2.State#getSignalRenamings <em>Signal Renamings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Signal Renamings</em>'.
	 * @see ssm2.State#getSignalRenamings()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_SignalRenamings();

	/**
	 * Returns the meta object for the containment reference '{@link ssm2.State#getSuspensionTrigger <em>Suspension Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Suspension Trigger</em>'.
	 * @see ssm2.State#getSuspensionTrigger()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_SuspensionTrigger();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm2.State#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outgoing Transitions</em>'.
	 * @see ssm2.State#getOutgoingTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OutgoingTransitions();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.State#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ssm2.State#getName()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Name();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.State#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent State</em>'.
	 * @see ssm2.State#getParentState()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_ParentState();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm2.State#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see ssm2.State#getVariables()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Variables();

	/**
	 * Returns the meta object for class '{@link ssm2.Signal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signal</em>'.
	 * @see ssm2.Signal
	 * @generated
	 */
	EClass getSignal();

	/**
	 * Returns the meta object for the containment reference '{@link ssm2.Signal#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see ssm2.Signal#getValue()
	 * @see #getSignal()
	 * @generated
	 */
	EReference getSignal_Value();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.Signal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ssm2.Signal#getName()
	 * @see #getSignal()
	 * @generated
	 */
	EAttribute getSignal_Name();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.Signal#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent State</em>'.
	 * @see ssm2.Signal#getParentState()
	 * @see #getSignal()
	 * @generated
	 */
	EReference getSignal_ParentState();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.Signal#isIsLocal <em>Is Local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Local</em>'.
	 * @see ssm2.Signal#isIsLocal()
	 * @see #getSignal()
	 * @generated
	 */
	EAttribute getSignal_IsLocal();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.Signal#isIsInput <em>Is Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Input</em>'.
	 * @see ssm2.Signal#isIsInput()
	 * @see #getSignal()
	 * @generated
	 */
	EAttribute getSignal_IsInput();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.Signal#isIsOutput <em>Is Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Output</em>'.
	 * @see ssm2.Signal#isIsOutput()
	 * @see #getSignal()
	 * @generated
	 */
	EAttribute getSignal_IsOutput();

	/**
	 * Returns the meta object for class '{@link ssm2.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see ssm2.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.Value#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ssm2.Value#getValue()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_Value();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.Value#getParentSignal <em>Parent Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Signal</em>'.
	 * @see ssm2.Value#getParentSignal()
	 * @see #getValue()
	 * @generated
	 */
	EReference getValue_ParentSignal();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.Value#getParentVariable <em>Parent Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Variable</em>'.
	 * @see ssm2.Value#getParentVariable()
	 * @see #getValue()
	 * @generated
	 */
	EReference getValue_ParentVariable();

	/**
	 * Returns the meta object for class '{@link ssm2.Emission <em>Emission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Emission</em>'.
	 * @see ssm2.Emission
	 * @generated
	 */
	EClass getEmission();

	/**
	 * Returns the meta object for the containment reference '{@link ssm2.Emission#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Value</em>'.
	 * @see ssm2.Emission#getNewValue()
	 * @see #getEmission()
	 * @generated
	 */
	EReference getEmission_NewValue();

	/**
	 * Returns the meta object for the reference '{@link ssm2.Emission#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signal</em>'.
	 * @see ssm2.Emission#getSignal()
	 * @see #getEmission()
	 * @generated
	 */
	EReference getEmission_Signal();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.Emission#getParentAction <em>Parent Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Action</em>'.
	 * @see ssm2.Emission#getParentAction()
	 * @see #getEmission()
	 * @generated
	 */
	EReference getEmission_ParentAction();

	/**
	 * Returns the meta object for class '{@link ssm2.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see ssm2.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.Transition#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see ssm2.Transition#getDelay()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Delay();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.Transition#isImmediate <em>Immediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Immediate</em>'.
	 * @see ssm2.Transition#isImmediate()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Immediate();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.Transition#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see ssm2.Transition#getPriority()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Priority();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.Transition#getTransitionKind <em>Transition Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transition Kind</em>'.
	 * @see ssm2.Transition#getTransitionKind()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_TransitionKind();

	/**
	 * Returns the meta object for the reference '{@link ssm2.Transition#getTargetState <em>Target State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target State</em>'.
	 * @see ssm2.Transition#getTargetState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_TargetState();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.Transition#getSourceState <em>Source State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source State</em>'.
	 * @see ssm2.Transition#getSourceState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_SourceState();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.Transition#isHistory <em>History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>History</em>'.
	 * @see ssm2.Transition#isHistory()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_History();

	/**
	 * Returns the meta object for class '{@link ssm2.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see ssm2.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm2.Expression#getSubExpressions <em>Sub Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Expressions</em>'.
	 * @see ssm2.Expression#getSubExpressions()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_SubExpressions();

	/**
	 * Returns the meta object for the reference '{@link ssm2.Expression#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signal</em>'.
	 * @see ssm2.Expression#getSignal()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_Signal();

	/**
	 * Returns the meta object for the containment reference '{@link ssm2.Expression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operator</em>'.
	 * @see ssm2.Expression#getOperator()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_Operator();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.Expression#getParentExpression <em>Parent Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Expression</em>'.
	 * @see ssm2.Expression#getParentExpression()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_ParentExpression();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.Expression#getParentAction <em>Parent Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Action</em>'.
	 * @see ssm2.Expression#getParentAction()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_ParentAction();

	/**
	 * Returns the meta object for the reference '{@link ssm2.Expression#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see ssm2.Expression#getVariable()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_Variable();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.Expression#getParentEmisson <em>Parent Emisson</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Emisson</em>'.
	 * @see ssm2.Expression#getParentEmisson()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_ParentEmisson();

	/**
	 * Returns the meta object for the reference '{@link ssm2.Expression#getAssignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assignment</em>'.
	 * @see ssm2.Expression#getAssignment()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_Assignment();

	/**
	 * Returns the meta object for class '{@link ssm2.SignalRenaming <em>Signal Renaming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signal Renaming</em>'.
	 * @see ssm2.SignalRenaming
	 * @generated
	 */
	EClass getSignalRenaming();

	/**
	 * Returns the meta object for the reference '{@link ssm2.SignalRenaming#getOldSignal <em>Old Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Old Signal</em>'.
	 * @see ssm2.SignalRenaming#getOldSignal()
	 * @see #getSignalRenaming()
	 * @generated
	 */
	EReference getSignalRenaming_OldSignal();

	/**
	 * Returns the meta object for the reference '{@link ssm2.SignalRenaming#getNewSignal <em>New Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Signal</em>'.
	 * @see ssm2.SignalRenaming#getNewSignal()
	 * @see #getSignalRenaming()
	 * @generated
	 */
	EReference getSignalRenaming_NewSignal();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.SignalRenaming#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent State</em>'.
	 * @see ssm2.SignalRenaming#getParentState()
	 * @see #getSignalRenaming()
	 * @generated
	 */
	EReference getSignalRenaming_ParentState();

	/**
	 * Returns the meta object for class '{@link ssm2.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see ssm2.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.Operator#getOperatorKind <em>Operator Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator Kind</em>'.
	 * @see ssm2.Operator#getOperatorKind()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_OperatorKind();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.Operator#getParentExpression <em>Parent Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Expression</em>'.
	 * @see ssm2.Operator#getParentExpression()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_ParentExpression();

	/**
	 * Returns the meta object for class '{@link ssm2.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see ssm2.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm2.Action#getEmissions <em>Emissions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Emissions</em>'.
	 * @see ssm2.Action#getEmissions()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Emissions();

	/**
	 * Returns the meta object for the containment reference '{@link ssm2.Action#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Trigger</em>'.
	 * @see ssm2.Action#getTrigger()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Trigger();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.Action#getParentStateEntryAction <em>Parent State Entry Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent State Entry Action</em>'.
	 * @see ssm2.Action#getParentStateEntryAction()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_ParentStateEntryAction();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.Action#getParentStateInnerAction <em>Parent State Inner Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent State Inner Action</em>'.
	 * @see ssm2.Action#getParentStateInnerAction()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_ParentStateInnerAction();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.Action#getParentStateExitAction <em>Parent State Exit Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent State Exit Action</em>'.
	 * @see ssm2.Action#getParentStateExitAction()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_ParentStateExitAction();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm2.Action#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assignments</em>'.
	 * @see ssm2.Action#getAssignments()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Assignments();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.Action#getTriggersAndEffects <em>Triggers And Effects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Triggers And Effects</em>'.
	 * @see ssm2.Action#getTriggersAndEffects()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_TriggersAndEffects();

	/**
	 * Returns the meta object for class '{@link ssm2.SuspensionTrigger <em>Suspension Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Suspension Trigger</em>'.
	 * @see ssm2.SuspensionTrigger
	 * @generated
	 */
	EClass getSuspensionTrigger();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.SuspensionTrigger#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent State</em>'.
	 * @see ssm2.SuspensionTrigger#getParentState()
	 * @see #getSuspensionTrigger()
	 * @generated
	 */
	EReference getSuspensionTrigger_ParentState();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.SuspensionTrigger#isImmediate <em>Immediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Immediate</em>'.
	 * @see ssm2.SuspensionTrigger#isImmediate()
	 * @see #getSuspensionTrigger()
	 * @generated
	 */
	EAttribute getSuspensionTrigger_Immediate();

	/**
	 * Returns the meta object for class '{@link ssm2.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see ssm2.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the reference '{@link ssm2.Assignment#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see ssm2.Assignment#getVariable()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Variable();

	/**
	 * Returns the meta object for the reference '{@link ssm2.Assignment#getParentExpression <em>Parent Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Expression</em>'.
	 * @see ssm2.Assignment#getParentExpression()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_ParentExpression();

	/**
	 * Returns the meta object for class '{@link ssm2.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see ssm2.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link ssm2.Variable#getVname <em>Vname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vname</em>'.
	 * @see ssm2.Variable#getVname()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Vname();

	/**
	 * Returns the meta object for the containment reference '{@link ssm2.Variable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see ssm2.Variable#getValue()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Value();

	/**
	 * Returns the meta object for the container reference '{@link ssm2.Variable#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent State</em>'.
	 * @see ssm2.Variable#getParentState()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_ParentState();

	/**
	 * Returns the meta object for enum '{@link ssm2.StateKind <em>State Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>State Kind</em>'.
	 * @see ssm2.StateKind
	 * @generated
	 */
	EEnum getStateKind();

	/**
	 * Returns the meta object for enum '{@link ssm2.StateFlag <em>State Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>State Flag</em>'.
	 * @see ssm2.StateFlag
	 * @generated
	 */
	EEnum getStateFlag();

	/**
	 * Returns the meta object for enum '{@link ssm2.TransitionKind <em>Transition Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transition Kind</em>'.
	 * @see ssm2.TransitionKind
	 * @generated
	 */
	EEnum getTransitionKind();

	/**
	 * Returns the meta object for enum '{@link ssm2.OperatorKind <em>Operator Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operator Kind</em>'.
	 * @see ssm2.OperatorKind
	 * @generated
	 */
	EEnum getOperatorKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Ssm2Factory getSsm2Factory();

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
		 * The meta object literal for the '{@link ssm2.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.impl.StateImpl
		 * @see ssm2.impl.Ssm2PackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>State Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__STATE_KIND = eINSTANCE.getState_StateKind();

		/**
		 * The meta object literal for the '<em><b>State Flag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__STATE_FLAG = eINSTANCE.getState_StateFlag();

		/**
		 * The meta object literal for the '<em><b>Signals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__SIGNALS = eINSTANCE.getState_Signals();

		/**
		 * The meta object literal for the '<em><b>Inner States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__INNER_STATES = eINSTANCE.getState_InnerStates();

		/**
		 * The meta object literal for the '<em><b>Entry Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__ENTRY_ACTIONS = eINSTANCE.getState_EntryActions();

		/**
		 * The meta object literal for the '<em><b>Inner Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__INNER_ACTIONS = eINSTANCE.getState_InnerActions();

		/**
		 * The meta object literal for the '<em><b>Exit Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__EXIT_ACTIONS = eINSTANCE.getState_ExitActions();

		/**
		 * The meta object literal for the '<em><b>Signal Renamings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__SIGNAL_RENAMINGS = eINSTANCE.getState_SignalRenamings();

		/**
		 * The meta object literal for the '<em><b>Suspension Trigger</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__SUSPENSION_TRIGGER = eINSTANCE.getState_SuspensionTrigger();

		/**
		 * The meta object literal for the '<em><b>Outgoing Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OUTGOING_TRANSITIONS = eINSTANCE.getState_OutgoingTransitions();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__NAME = eINSTANCE.getState_Name();

		/**
		 * The meta object literal for the '<em><b>Parent State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__PARENT_STATE = eINSTANCE.getState_ParentState();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__VARIABLES = eINSTANCE.getState_Variables();

		/**
		 * The meta object literal for the '{@link ssm2.impl.SignalImpl <em>Signal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.impl.SignalImpl
		 * @see ssm2.impl.Ssm2PackageImpl#getSignal()
		 * @generated
		 */
		EClass SIGNAL = eINSTANCE.getSignal();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIGNAL__VALUE = eINSTANCE.getSignal_Value();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNAL__NAME = eINSTANCE.getSignal_Name();

		/**
		 * The meta object literal for the '<em><b>Parent State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIGNAL__PARENT_STATE = eINSTANCE.getSignal_ParentState();

		/**
		 * The meta object literal for the '<em><b>Is Local</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNAL__IS_LOCAL = eINSTANCE.getSignal_IsLocal();

		/**
		 * The meta object literal for the '<em><b>Is Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNAL__IS_INPUT = eINSTANCE.getSignal_IsInput();

		/**
		 * The meta object literal for the '<em><b>Is Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNAL__IS_OUTPUT = eINSTANCE.getSignal_IsOutput();

		/**
		 * The meta object literal for the '{@link ssm2.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.impl.ValueImpl
		 * @see ssm2.impl.Ssm2PackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__VALUE = eINSTANCE.getValue_Value();

		/**
		 * The meta object literal for the '<em><b>Parent Signal</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE__PARENT_SIGNAL = eINSTANCE.getValue_ParentSignal();

		/**
		 * The meta object literal for the '<em><b>Parent Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE__PARENT_VARIABLE = eINSTANCE.getValue_ParentVariable();

		/**
		 * The meta object literal for the '{@link ssm2.impl.EmissionImpl <em>Emission</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.impl.EmissionImpl
		 * @see ssm2.impl.Ssm2PackageImpl#getEmission()
		 * @generated
		 */
		EClass EMISSION = eINSTANCE.getEmission();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMISSION__NEW_VALUE = eINSTANCE.getEmission_NewValue();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMISSION__SIGNAL = eINSTANCE.getEmission_Signal();

		/**
		 * The meta object literal for the '<em><b>Parent Action</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMISSION__PARENT_ACTION = eINSTANCE.getEmission_ParentAction();

		/**
		 * The meta object literal for the '{@link ssm2.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.impl.TransitionImpl
		 * @see ssm2.impl.Ssm2PackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__DELAY = eINSTANCE.getTransition_Delay();

		/**
		 * The meta object literal for the '<em><b>Immediate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__IMMEDIATE = eINSTANCE.getTransition_Immediate();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__PRIORITY = eINSTANCE.getTransition_Priority();

		/**
		 * The meta object literal for the '<em><b>Transition Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__TRANSITION_KIND = eINSTANCE.getTransition_TransitionKind();

		/**
		 * The meta object literal for the '<em><b>Target State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET_STATE = eINSTANCE.getTransition_TargetState();

		/**
		 * The meta object literal for the '<em><b>Source State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__SOURCE_STATE = eINSTANCE.getTransition_SourceState();

		/**
		 * The meta object literal for the '<em><b>History</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__HISTORY = eINSTANCE.getTransition_History();

		/**
		 * The meta object literal for the '{@link ssm2.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.impl.ExpressionImpl
		 * @see ssm2.impl.Ssm2PackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '<em><b>Sub Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__SUB_EXPRESSIONS = eINSTANCE.getExpression_SubExpressions();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__SIGNAL = eINSTANCE.getExpression_Signal();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__OPERATOR = eINSTANCE.getExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Parent Expression</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__PARENT_EXPRESSION = eINSTANCE.getExpression_ParentExpression();

		/**
		 * The meta object literal for the '<em><b>Parent Action</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__PARENT_ACTION = eINSTANCE.getExpression_ParentAction();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__VARIABLE = eINSTANCE.getExpression_Variable();

		/**
		 * The meta object literal for the '<em><b>Parent Emisson</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__PARENT_EMISSON = eINSTANCE.getExpression_ParentEmisson();

		/**
		 * The meta object literal for the '<em><b>Assignment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__ASSIGNMENT = eINSTANCE.getExpression_Assignment();

		/**
		 * The meta object literal for the '{@link ssm2.impl.SignalRenamingImpl <em>Signal Renaming</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.impl.SignalRenamingImpl
		 * @see ssm2.impl.Ssm2PackageImpl#getSignalRenaming()
		 * @generated
		 */
		EClass SIGNAL_RENAMING = eINSTANCE.getSignalRenaming();

		/**
		 * The meta object literal for the '<em><b>Old Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIGNAL_RENAMING__OLD_SIGNAL = eINSTANCE.getSignalRenaming_OldSignal();

		/**
		 * The meta object literal for the '<em><b>New Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIGNAL_RENAMING__NEW_SIGNAL = eINSTANCE.getSignalRenaming_NewSignal();

		/**
		 * The meta object literal for the '<em><b>Parent State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIGNAL_RENAMING__PARENT_STATE = eINSTANCE.getSignalRenaming_ParentState();

		/**
		 * The meta object literal for the '{@link ssm2.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.impl.OperatorImpl
		 * @see ssm2.impl.Ssm2PackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '<em><b>Operator Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__OPERATOR_KIND = eINSTANCE.getOperator_OperatorKind();

		/**
		 * The meta object literal for the '<em><b>Parent Expression</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__PARENT_EXPRESSION = eINSTANCE.getOperator_ParentExpression();

		/**
		 * The meta object literal for the '{@link ssm2.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.impl.ActionImpl
		 * @see ssm2.impl.Ssm2PackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Emissions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__EMISSIONS = eINSTANCE.getAction_Emissions();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__TRIGGER = eINSTANCE.getAction_Trigger();

		/**
		 * The meta object literal for the '<em><b>Parent State Entry Action</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__PARENT_STATE_ENTRY_ACTION = eINSTANCE.getAction_ParentStateEntryAction();

		/**
		 * The meta object literal for the '<em><b>Parent State Inner Action</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__PARENT_STATE_INNER_ACTION = eINSTANCE.getAction_ParentStateInnerAction();

		/**
		 * The meta object literal for the '<em><b>Parent State Exit Action</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__PARENT_STATE_EXIT_ACTION = eINSTANCE.getAction_ParentStateExitAction();

		/**
		 * The meta object literal for the '<em><b>Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__ASSIGNMENTS = eINSTANCE.getAction_Assignments();

		/**
		 * The meta object literal for the '<em><b>Triggers And Effects</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__TRIGGERS_AND_EFFECTS = eINSTANCE.getAction_TriggersAndEffects();

		/**
		 * The meta object literal for the '{@link ssm2.impl.SuspensionTriggerImpl <em>Suspension Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.impl.SuspensionTriggerImpl
		 * @see ssm2.impl.Ssm2PackageImpl#getSuspensionTrigger()
		 * @generated
		 */
		EClass SUSPENSION_TRIGGER = eINSTANCE.getSuspensionTrigger();

		/**
		 * The meta object literal for the '<em><b>Parent State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUSPENSION_TRIGGER__PARENT_STATE = eINSTANCE.getSuspensionTrigger_ParentState();

		/**
		 * The meta object literal for the '<em><b>Immediate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUSPENSION_TRIGGER__IMMEDIATE = eINSTANCE.getSuspensionTrigger_Immediate();

		/**
		 * The meta object literal for the '{@link ssm2.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.impl.AssignmentImpl
		 * @see ssm2.impl.Ssm2PackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__VARIABLE = eINSTANCE.getAssignment_Variable();

		/**
		 * The meta object literal for the '<em><b>Parent Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__PARENT_EXPRESSION = eINSTANCE.getAssignment_ParentExpression();

		/**
		 * The meta object literal for the '{@link ssm2.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.impl.VariableImpl
		 * @see ssm2.impl.Ssm2PackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Vname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__VNAME = eINSTANCE.getVariable_Vname();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__VALUE = eINSTANCE.getVariable_Value();

		/**
		 * The meta object literal for the '<em><b>Parent State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__PARENT_STATE = eINSTANCE.getVariable_ParentState();

		/**
		 * The meta object literal for the '{@link ssm2.StateKind <em>State Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.StateKind
		 * @see ssm2.impl.Ssm2PackageImpl#getStateKind()
		 * @generated
		 */
		EEnum STATE_KIND = eINSTANCE.getStateKind();

		/**
		 * The meta object literal for the '{@link ssm2.StateFlag <em>State Flag</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.StateFlag
		 * @see ssm2.impl.Ssm2PackageImpl#getStateFlag()
		 * @generated
		 */
		EEnum STATE_FLAG = eINSTANCE.getStateFlag();

		/**
		 * The meta object literal for the '{@link ssm2.TransitionKind <em>Transition Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.TransitionKind
		 * @see ssm2.impl.Ssm2PackageImpl#getTransitionKind()
		 * @generated
		 */
		EEnum TRANSITION_KIND = eINSTANCE.getTransitionKind();

		/**
		 * The meta object literal for the '{@link ssm2.OperatorKind <em>Operator Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm2.OperatorKind
		 * @see ssm2.impl.Ssm2PackageImpl#getOperatorKind()
		 * @generated
		 */
		EEnum OPERATOR_KIND = eINSTANCE.getOperatorKind();

	}

} //Ssm2Package
