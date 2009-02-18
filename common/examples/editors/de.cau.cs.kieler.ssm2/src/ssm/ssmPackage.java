/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm;

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
 * @see ssm.ssmFactory
 * @model kind="package"
 * @generated
 */
public interface ssmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ssm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.informatik.uni-kiel.de/rtsys/ssm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ssm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ssmPackage eINSTANCE = ssm.impl.ssmPackageImpl.init();

	/**
	 * The meta object id for the '{@link ssm.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm.impl.StateImpl
	 * @see ssm.impl.ssmPackageImpl#getState()
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
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link ssm.impl.SignalImpl <em>Signal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm.impl.SignalImpl
	 * @see ssm.impl.ssmPackageImpl#getSignal()
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
	 * The meta object id for the '{@link ssm.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm.impl.ValueImpl
	 * @see ssm.impl.ssmPackageImpl#getValue()
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
	 * The feature id for the '<em><b>Parent Emisson</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__PARENT_EMISSON = 2;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link ssm.impl.EmissionImpl <em>Emission</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm.impl.EmissionImpl
	 * @see ssm.impl.ssmPackageImpl#getEmission()
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
	 * The meta object id for the '{@link ssm.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm.impl.ActionImpl
	 * @see ssm.impl.ssmPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 8;

	/**
	 * The feature id for the '<em><b>Effects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__EFFECTS = 0;

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
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link ssm.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm.impl.TransitionImpl
	 * @see ssm.impl.ssmPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 4;

	/**
	 * The feature id for the '<em><b>Effects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EFFECTS = ACTION__EFFECTS;

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
	 * The feature id for the '<em><b>Triggers And Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TRIGGERS_AND_EFFECTS = ACTION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link ssm.impl.TriggerImpl <em>Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm.impl.TriggerImpl
	 * @see ssm.impl.ssmPackageImpl#getTrigger()
	 * @generated
	 */
	int TRIGGER = 5;

	/**
	 * The feature id for the '<em><b>Sub Triggers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__SUB_TRIGGERS = 0;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__LITERALS = 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__OPERATOR = 2;

	/**
	 * The feature id for the '<em><b>Parent Trigger</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__PARENT_TRIGGER = 3;

	/**
	 * The feature id for the '<em><b>Parent Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__PARENT_ACTION = 4;

	/**
	 * The number of structural features of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link ssm.impl.SignalRenamingImpl <em>Signal Renaming</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm.impl.SignalRenamingImpl
	 * @see ssm.impl.ssmPackageImpl#getSignalRenaming()
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
	 * The meta object id for the '{@link ssm.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm.impl.OperatorImpl
	 * @see ssm.impl.ssmPackageImpl#getOperator()
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
	 * The feature id for the '<em><b>Parent Trigger</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__PARENT_TRIGGER = 1;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link ssm.impl.SuspensionTriggerImpl <em>Suspension Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm.impl.SuspensionTriggerImpl
	 * @see ssm.impl.ssmPackageImpl#getSuspensionTrigger()
	 * @generated
	 */
	int SUSPENSION_TRIGGER = 9;

	/**
	 * The feature id for the '<em><b>Sub Triggers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__SUB_TRIGGERS = TRIGGER__SUB_TRIGGERS;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__LITERALS = TRIGGER__LITERALS;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__OPERATOR = TRIGGER__OPERATOR;

	/**
	 * The feature id for the '<em><b>Parent Trigger</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__PARENT_TRIGGER = TRIGGER__PARENT_TRIGGER;

	/**
	 * The feature id for the '<em><b>Parent Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__PARENT_ACTION = TRIGGER__PARENT_ACTION;

	/**
	 * The feature id for the '<em><b>Parent State</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__PARENT_STATE = TRIGGER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Immediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER__IMMEDIATE = TRIGGER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Suspension Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSPENSION_TRIGGER_FEATURE_COUNT = TRIGGER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ssm.StateKind <em>State Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm.StateKind
	 * @see ssm.impl.ssmPackageImpl#getStateKind()
	 * @generated
	 */
	int STATE_KIND = 10;

	/**
	 * The meta object id for the '{@link ssm.StateFlag <em>State Flag</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm.StateFlag
	 * @see ssm.impl.ssmPackageImpl#getStateFlag()
	 * @generated
	 */
	int STATE_FLAG = 11;

	/**
	 * The meta object id for the '{@link ssm.TransitionKind <em>Transition Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm.TransitionKind
	 * @see ssm.impl.ssmPackageImpl#getTransitionKind()
	 * @generated
	 */
	int TRANSITION_KIND = 12;

	/**
	 * The meta object id for the '{@link ssm.OperatorKind <em>Operator Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ssm.OperatorKind
	 * @see ssm.impl.ssmPackageImpl#getOperatorKind()
	 * @generated
	 */
	int OPERATOR_KIND = 13;


	/**
	 * Returns the meta object for class '{@link ssm.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see ssm.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link ssm.State#getStateKind <em>State Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Kind</em>'.
	 * @see ssm.State#getStateKind()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_StateKind();

	/**
	 * Returns the meta object for the attribute '{@link ssm.State#getStateFlag <em>State Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Flag</em>'.
	 * @see ssm.State#getStateFlag()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_StateFlag();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm.State#getSignals <em>Signals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Signals</em>'.
	 * @see ssm.State#getSignals()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Signals();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm.State#getInnerStates <em>Inner States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inner States</em>'.
	 * @see ssm.State#getInnerStates()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_InnerStates();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm.State#getEntryActions <em>Entry Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entry Actions</em>'.
	 * @see ssm.State#getEntryActions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_EntryActions();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm.State#getInnerActions <em>Inner Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inner Actions</em>'.
	 * @see ssm.State#getInnerActions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_InnerActions();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm.State#getExitActions <em>Exit Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exit Actions</em>'.
	 * @see ssm.State#getExitActions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_ExitActions();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm.State#getSignalRenamings <em>Signal Renamings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Signal Renamings</em>'.
	 * @see ssm.State#getSignalRenamings()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_SignalRenamings();

	/**
	 * Returns the meta object for the containment reference '{@link ssm.State#getSuspensionTrigger <em>Suspension Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Suspension Trigger</em>'.
	 * @see ssm.State#getSuspensionTrigger()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_SuspensionTrigger();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm.State#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outgoing Transitions</em>'.
	 * @see ssm.State#getOutgoingTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OutgoingTransitions();

	/**
	 * Returns the meta object for the attribute '{@link ssm.State#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ssm.State#getName()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Name();

	/**
	 * Returns the meta object for the container reference '{@link ssm.State#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent State</em>'.
	 * @see ssm.State#getParentState()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_ParentState();

	/**
	 * Returns the meta object for class '{@link ssm.Signal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signal</em>'.
	 * @see ssm.Signal
	 * @generated
	 */
	EClass getSignal();

	/**
	 * Returns the meta object for the containment reference '{@link ssm.Signal#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see ssm.Signal#getValue()
	 * @see #getSignal()
	 * @generated
	 */
	EReference getSignal_Value();

	/**
	 * Returns the meta object for the attribute '{@link ssm.Signal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ssm.Signal#getName()
	 * @see #getSignal()
	 * @generated
	 */
	EAttribute getSignal_Name();

	/**
	 * Returns the meta object for the container reference '{@link ssm.Signal#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent State</em>'.
	 * @see ssm.Signal#getParentState()
	 * @see #getSignal()
	 * @generated
	 */
	EReference getSignal_ParentState();

	/**
	 * Returns the meta object for the attribute '{@link ssm.Signal#isIsLocal <em>Is Local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Local</em>'.
	 * @see ssm.Signal#isIsLocal()
	 * @see #getSignal()
	 * @generated
	 */
	EAttribute getSignal_IsLocal();

	/**
	 * Returns the meta object for the attribute '{@link ssm.Signal#isIsInput <em>Is Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Input</em>'.
	 * @see ssm.Signal#isIsInput()
	 * @see #getSignal()
	 * @generated
	 */
	EAttribute getSignal_IsInput();

	/**
	 * Returns the meta object for the attribute '{@link ssm.Signal#isIsOutput <em>Is Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Output</em>'.
	 * @see ssm.Signal#isIsOutput()
	 * @see #getSignal()
	 * @generated
	 */
	EAttribute getSignal_IsOutput();

	/**
	 * Returns the meta object for class '{@link ssm.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see ssm.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for the attribute '{@link ssm.Value#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ssm.Value#getValue()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_Value();

	/**
	 * Returns the meta object for the container reference '{@link ssm.Value#getParentSignal <em>Parent Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Signal</em>'.
	 * @see ssm.Value#getParentSignal()
	 * @see #getValue()
	 * @generated
	 */
	EReference getValue_ParentSignal();

	/**
	 * Returns the meta object for the container reference '{@link ssm.Value#getParentEmisson <em>Parent Emisson</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Emisson</em>'.
	 * @see ssm.Value#getParentEmisson()
	 * @see #getValue()
	 * @generated
	 */
	EReference getValue_ParentEmisson();

	/**
	 * Returns the meta object for class '{@link ssm.Emission <em>Emission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Emission</em>'.
	 * @see ssm.Emission
	 * @generated
	 */
	EClass getEmission();

	/**
	 * Returns the meta object for the containment reference '{@link ssm.Emission#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Value</em>'.
	 * @see ssm.Emission#getNewValue()
	 * @see #getEmission()
	 * @generated
	 */
	EReference getEmission_NewValue();

	/**
	 * Returns the meta object for the reference '{@link ssm.Emission#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signal</em>'.
	 * @see ssm.Emission#getSignal()
	 * @see #getEmission()
	 * @generated
	 */
	EReference getEmission_Signal();

	/**
	 * Returns the meta object for the container reference '{@link ssm.Emission#getParentAction <em>Parent Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Action</em>'.
	 * @see ssm.Emission#getParentAction()
	 * @see #getEmission()
	 * @generated
	 */
	EReference getEmission_ParentAction();

	/**
	 * Returns the meta object for class '{@link ssm.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see ssm.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the attribute '{@link ssm.Transition#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see ssm.Transition#getDelay()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Delay();

	/**
	 * Returns the meta object for the attribute '{@link ssm.Transition#isImmediate <em>Immediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Immediate</em>'.
	 * @see ssm.Transition#isImmediate()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Immediate();

	/**
	 * Returns the meta object for the attribute '{@link ssm.Transition#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see ssm.Transition#getPriority()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Priority();

	/**
	 * Returns the meta object for the attribute '{@link ssm.Transition#getTransitionKind <em>Transition Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transition Kind</em>'.
	 * @see ssm.Transition#getTransitionKind()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_TransitionKind();

	/**
	 * Returns the meta object for the reference '{@link ssm.Transition#getTargetState <em>Target State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target State</em>'.
	 * @see ssm.Transition#getTargetState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_TargetState();

	/**
	 * Returns the meta object for the container reference '{@link ssm.Transition#getSourceState <em>Source State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source State</em>'.
	 * @see ssm.Transition#getSourceState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_SourceState();

	/**
	 * Returns the meta object for the attribute '{@link ssm.Transition#getTriggersAndEffects <em>Triggers And Effects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Triggers And Effects</em>'.
	 * @see ssm.Transition#getTriggersAndEffects()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_TriggersAndEffects();

	/**
	 * Returns the meta object for class '{@link ssm.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger</em>'.
	 * @see ssm.Trigger
	 * @generated
	 */
	EClass getTrigger();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm.Trigger#getSubTriggers <em>Sub Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Triggers</em>'.
	 * @see ssm.Trigger#getSubTriggers()
	 * @see #getTrigger()
	 * @generated
	 */
	EReference getTrigger_SubTriggers();

	/**
	 * Returns the meta object for the reference list '{@link ssm.Trigger#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Literals</em>'.
	 * @see ssm.Trigger#getLiterals()
	 * @see #getTrigger()
	 * @generated
	 */
	EReference getTrigger_Literals();

	/**
	 * Returns the meta object for the containment reference '{@link ssm.Trigger#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operator</em>'.
	 * @see ssm.Trigger#getOperator()
	 * @see #getTrigger()
	 * @generated
	 */
	EReference getTrigger_Operator();

	/**
	 * Returns the meta object for the container reference '{@link ssm.Trigger#getParentTrigger <em>Parent Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Trigger</em>'.
	 * @see ssm.Trigger#getParentTrigger()
	 * @see #getTrigger()
	 * @generated
	 */
	EReference getTrigger_ParentTrigger();

	/**
	 * Returns the meta object for the container reference '{@link ssm.Trigger#getParentAction <em>Parent Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Action</em>'.
	 * @see ssm.Trigger#getParentAction()
	 * @see #getTrigger()
	 * @generated
	 */
	EReference getTrigger_ParentAction();

	/**
	 * Returns the meta object for class '{@link ssm.SignalRenaming <em>Signal Renaming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signal Renaming</em>'.
	 * @see ssm.SignalRenaming
	 * @generated
	 */
	EClass getSignalRenaming();

	/**
	 * Returns the meta object for the reference '{@link ssm.SignalRenaming#getOldSignal <em>Old Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Old Signal</em>'.
	 * @see ssm.SignalRenaming#getOldSignal()
	 * @see #getSignalRenaming()
	 * @generated
	 */
	EReference getSignalRenaming_OldSignal();

	/**
	 * Returns the meta object for the reference '{@link ssm.SignalRenaming#getNewSignal <em>New Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Signal</em>'.
	 * @see ssm.SignalRenaming#getNewSignal()
	 * @see #getSignalRenaming()
	 * @generated
	 */
	EReference getSignalRenaming_NewSignal();

	/**
	 * Returns the meta object for the container reference '{@link ssm.SignalRenaming#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent State</em>'.
	 * @see ssm.SignalRenaming#getParentState()
	 * @see #getSignalRenaming()
	 * @generated
	 */
	EReference getSignalRenaming_ParentState();

	/**
	 * Returns the meta object for class '{@link ssm.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see ssm.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for the attribute '{@link ssm.Operator#getOperatorKind <em>Operator Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator Kind</em>'.
	 * @see ssm.Operator#getOperatorKind()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_OperatorKind();

	/**
	 * Returns the meta object for the container reference '{@link ssm.Operator#getParentTrigger <em>Parent Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Trigger</em>'.
	 * @see ssm.Operator#getParentTrigger()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_ParentTrigger();

	/**
	 * Returns the meta object for class '{@link ssm.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see ssm.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the containment reference list '{@link ssm.Action#getEffects <em>Effects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Effects</em>'.
	 * @see ssm.Action#getEffects()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Effects();

	/**
	 * Returns the meta object for the containment reference '{@link ssm.Action#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Trigger</em>'.
	 * @see ssm.Action#getTrigger()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Trigger();

	/**
	 * Returns the meta object for the container reference '{@link ssm.Action#getParentStateEntryAction <em>Parent State Entry Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent State Entry Action</em>'.
	 * @see ssm.Action#getParentStateEntryAction()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_ParentStateEntryAction();

	/**
	 * Returns the meta object for the container reference '{@link ssm.Action#getParentStateInnerAction <em>Parent State Inner Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent State Inner Action</em>'.
	 * @see ssm.Action#getParentStateInnerAction()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_ParentStateInnerAction();

	/**
	 * Returns the meta object for the container reference '{@link ssm.Action#getParentStateExitAction <em>Parent State Exit Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent State Exit Action</em>'.
	 * @see ssm.Action#getParentStateExitAction()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_ParentStateExitAction();

	/**
	 * Returns the meta object for class '{@link ssm.SuspensionTrigger <em>Suspension Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Suspension Trigger</em>'.
	 * @see ssm.SuspensionTrigger
	 * @generated
	 */
	EClass getSuspensionTrigger();

	/**
	 * Returns the meta object for the container reference '{@link ssm.SuspensionTrigger#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent State</em>'.
	 * @see ssm.SuspensionTrigger#getParentState()
	 * @see #getSuspensionTrigger()
	 * @generated
	 */
	EReference getSuspensionTrigger_ParentState();

	/**
	 * Returns the meta object for the attribute '{@link ssm.SuspensionTrigger#isImmediate <em>Immediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Immediate</em>'.
	 * @see ssm.SuspensionTrigger#isImmediate()
	 * @see #getSuspensionTrigger()
	 * @generated
	 */
	EAttribute getSuspensionTrigger_Immediate();

	/**
	 * Returns the meta object for enum '{@link ssm.StateKind <em>State Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>State Kind</em>'.
	 * @see ssm.StateKind
	 * @generated
	 */
	EEnum getStateKind();

	/**
	 * Returns the meta object for enum '{@link ssm.StateFlag <em>State Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>State Flag</em>'.
	 * @see ssm.StateFlag
	 * @generated
	 */
	EEnum getStateFlag();

	/**
	 * Returns the meta object for enum '{@link ssm.TransitionKind <em>Transition Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transition Kind</em>'.
	 * @see ssm.TransitionKind
	 * @generated
	 */
	EEnum getTransitionKind();

	/**
	 * Returns the meta object for enum '{@link ssm.OperatorKind <em>Operator Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operator Kind</em>'.
	 * @see ssm.OperatorKind
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
	ssmFactory getssmFactory();

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
		 * The meta object literal for the '{@link ssm.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm.impl.StateImpl
		 * @see ssm.impl.ssmPackageImpl#getState()
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
		 * The meta object literal for the '{@link ssm.impl.SignalImpl <em>Signal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm.impl.SignalImpl
		 * @see ssm.impl.ssmPackageImpl#getSignal()
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
		 * The meta object literal for the '{@link ssm.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm.impl.ValueImpl
		 * @see ssm.impl.ssmPackageImpl#getValue()
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
		 * The meta object literal for the '<em><b>Parent Emisson</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE__PARENT_EMISSON = eINSTANCE.getValue_ParentEmisson();

		/**
		 * The meta object literal for the '{@link ssm.impl.EmissionImpl <em>Emission</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm.impl.EmissionImpl
		 * @see ssm.impl.ssmPackageImpl#getEmission()
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
		 * The meta object literal for the '{@link ssm.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm.impl.TransitionImpl
		 * @see ssm.impl.ssmPackageImpl#getTransition()
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
		 * The meta object literal for the '<em><b>Triggers And Effects</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__TRIGGERS_AND_EFFECTS = eINSTANCE.getTransition_TriggersAndEffects();

		/**
		 * The meta object literal for the '{@link ssm.impl.TriggerImpl <em>Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm.impl.TriggerImpl
		 * @see ssm.impl.ssmPackageImpl#getTrigger()
		 * @generated
		 */
		EClass TRIGGER = eINSTANCE.getTrigger();

		/**
		 * The meta object literal for the '<em><b>Sub Triggers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIGGER__SUB_TRIGGERS = eINSTANCE.getTrigger_SubTriggers();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIGGER__LITERALS = eINSTANCE.getTrigger_Literals();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIGGER__OPERATOR = eINSTANCE.getTrigger_Operator();

		/**
		 * The meta object literal for the '<em><b>Parent Trigger</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIGGER__PARENT_TRIGGER = eINSTANCE.getTrigger_ParentTrigger();

		/**
		 * The meta object literal for the '<em><b>Parent Action</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIGGER__PARENT_ACTION = eINSTANCE.getTrigger_ParentAction();

		/**
		 * The meta object literal for the '{@link ssm.impl.SignalRenamingImpl <em>Signal Renaming</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm.impl.SignalRenamingImpl
		 * @see ssm.impl.ssmPackageImpl#getSignalRenaming()
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
		 * The meta object literal for the '{@link ssm.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm.impl.OperatorImpl
		 * @see ssm.impl.ssmPackageImpl#getOperator()
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
		 * The meta object literal for the '<em><b>Parent Trigger</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__PARENT_TRIGGER = eINSTANCE.getOperator_ParentTrigger();

		/**
		 * The meta object literal for the '{@link ssm.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm.impl.ActionImpl
		 * @see ssm.impl.ssmPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Effects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__EFFECTS = eINSTANCE.getAction_Effects();

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
		 * The meta object literal for the '{@link ssm.impl.SuspensionTriggerImpl <em>Suspension Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm.impl.SuspensionTriggerImpl
		 * @see ssm.impl.ssmPackageImpl#getSuspensionTrigger()
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
		 * The meta object literal for the '{@link ssm.StateKind <em>State Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm.StateKind
		 * @see ssm.impl.ssmPackageImpl#getStateKind()
		 * @generated
		 */
		EEnum STATE_KIND = eINSTANCE.getStateKind();

		/**
		 * The meta object literal for the '{@link ssm.StateFlag <em>State Flag</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm.StateFlag
		 * @see ssm.impl.ssmPackageImpl#getStateFlag()
		 * @generated
		 */
		EEnum STATE_FLAG = eINSTANCE.getStateFlag();

		/**
		 * The meta object literal for the '{@link ssm.TransitionKind <em>Transition Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm.TransitionKind
		 * @see ssm.impl.ssmPackageImpl#getTransitionKind()
		 * @generated
		 */
		EEnum TRANSITION_KIND = eINSTANCE.getTransitionKind();

		/**
		 * The meta object literal for the '{@link ssm.OperatorKind <em>Operator Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ssm.OperatorKind
		 * @see ssm.impl.ssmPackageImpl#getOperatorKind()
		 * @generated
		 */
		EEnum OPERATOR_KIND = eINSTANCE.getOperatorKind();

	}

} //ssmPackage
