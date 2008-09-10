/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm;

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
 * @see edu.unikiel.rtsys.kieler.ssm.ssmFactory
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
    ssmPackage eINSTANCE = edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl.init();

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.NamedImpl <em>Named</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.NamedImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getNamed()
     * @generated
     */
    int NAMED = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED__NAME = 0;

    /**
     * The number of structural features of the '<em>Named</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.RegionImpl <em>Region</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.RegionImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getRegion()
     * @generated
     */
    int REGION = 1;

    /**
     * The feature id for the '<em><b>States</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REGION__STATES = 0;

    /**
     * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REGION__TRANSITIONS = 1;

    /**
     * The number of structural features of the '<em>Region</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REGION_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.AbstractStateImpl <em>Abstract State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.AbstractStateImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getAbstractState()
     * @generated
     */
    int ABSTRACT_STATE = 2;

    /**
     * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_STATE__INCOMING_TRANSITIONS = 0;

    /**
     * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_STATE__OUTGOING_TRANSITIONS = 1;

    /**
     * The feature id for the '<em><b>On Entry Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_STATE__ON_ENTRY_ACTION = 2;

    /**
     * The feature id for the '<em><b>On Inside Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_STATE__ON_INSIDE_ACTION = 3;

    /**
     * The feature id for the '<em><b>On Exit Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_STATE__ON_EXIT_ACTION = 4;

    /**
     * The number of structural features of the '<em>Abstract State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_STATE_FEATURE_COUNT = 5;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.SimpleStateImpl <em>Simple State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.SimpleStateImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getSimpleState()
     * @generated
     */
    int SIMPLE_STATE = 3;

    /**
     * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_STATE__INCOMING_TRANSITIONS = ABSTRACT_STATE__INCOMING_TRANSITIONS;

    /**
     * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_STATE__OUTGOING_TRANSITIONS = ABSTRACT_STATE__OUTGOING_TRANSITIONS;

    /**
     * The feature id for the '<em><b>On Entry Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_STATE__ON_ENTRY_ACTION = ABSTRACT_STATE__ON_ENTRY_ACTION;

    /**
     * The feature id for the '<em><b>On Inside Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_STATE__ON_INSIDE_ACTION = ABSTRACT_STATE__ON_INSIDE_ACTION;

    /**
     * The feature id for the '<em><b>On Exit Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_STATE__ON_EXIT_ACTION = ABSTRACT_STATE__ON_EXIT_ACTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_STATE__NAME = ABSTRACT_STATE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>State Flag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_STATE__STATE_FLAG = ABSTRACT_STATE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Simple State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_STATE_FEATURE_COUNT = ABSTRACT_STATE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.PseudoStateImpl <em>Pseudo State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.PseudoStateImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getPseudoState()
     * @generated
     */
    int PSEUDO_STATE = 4;

    /**
     * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PSEUDO_STATE__INCOMING_TRANSITIONS = ABSTRACT_STATE__INCOMING_TRANSITIONS;

    /**
     * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PSEUDO_STATE__OUTGOING_TRANSITIONS = ABSTRACT_STATE__OUTGOING_TRANSITIONS;

    /**
     * The feature id for the '<em><b>On Entry Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PSEUDO_STATE__ON_ENTRY_ACTION = ABSTRACT_STATE__ON_ENTRY_ACTION;

    /**
     * The feature id for the '<em><b>On Inside Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PSEUDO_STATE__ON_INSIDE_ACTION = ABSTRACT_STATE__ON_INSIDE_ACTION;

    /**
     * The feature id for the '<em><b>On Exit Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PSEUDO_STATE__ON_EXIT_ACTION = ABSTRACT_STATE__ON_EXIT_ACTION;

    /**
     * The number of structural features of the '<em>Pseudo State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PSEUDO_STATE_FEATURE_COUNT = ABSTRACT_STATE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.InitialStateImpl <em>Initial State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.InitialStateImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getInitialState()
     * @generated
     */
    int INITIAL_STATE = 5;

    /**
     * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INITIAL_STATE__INCOMING_TRANSITIONS = PSEUDO_STATE__INCOMING_TRANSITIONS;

    /**
     * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INITIAL_STATE__OUTGOING_TRANSITIONS = PSEUDO_STATE__OUTGOING_TRANSITIONS;

    /**
     * The feature id for the '<em><b>On Entry Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INITIAL_STATE__ON_ENTRY_ACTION = PSEUDO_STATE__ON_ENTRY_ACTION;

    /**
     * The feature id for the '<em><b>On Inside Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INITIAL_STATE__ON_INSIDE_ACTION = PSEUDO_STATE__ON_INSIDE_ACTION;

    /**
     * The feature id for the '<em><b>On Exit Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INITIAL_STATE__ON_EXIT_ACTION = PSEUDO_STATE__ON_EXIT_ACTION;

    /**
     * The number of structural features of the '<em>Initial State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INITIAL_STATE_FEATURE_COUNT = PSEUDO_STATE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.CompositeStateImpl <em>Composite State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.CompositeStateImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getCompositeState()
     * @generated
     */
    int COMPOSITE_STATE = 6;

    /**
     * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_STATE__INCOMING_TRANSITIONS = SIMPLE_STATE__INCOMING_TRANSITIONS;

    /**
     * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_STATE__OUTGOING_TRANSITIONS = SIMPLE_STATE__OUTGOING_TRANSITIONS;

    /**
     * The feature id for the '<em><b>On Entry Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_STATE__ON_ENTRY_ACTION = SIMPLE_STATE__ON_ENTRY_ACTION;

    /**
     * The feature id for the '<em><b>On Inside Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_STATE__ON_INSIDE_ACTION = SIMPLE_STATE__ON_INSIDE_ACTION;

    /**
     * The feature id for the '<em><b>On Exit Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_STATE__ON_EXIT_ACTION = SIMPLE_STATE__ON_EXIT_ACTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_STATE__NAME = SIMPLE_STATE__NAME;

    /**
     * The feature id for the '<em><b>State Flag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_STATE__STATE_FLAG = SIMPLE_STATE__STATE_FLAG;

    /**
     * The feature id for the '<em><b>Regions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_STATE__REGIONS = SIMPLE_STATE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Local Signals</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_STATE__LOCAL_SIGNALS = SIMPLE_STATE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Input Signals</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_STATE__INPUT_SIGNALS = SIMPLE_STATE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Output Signals</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_STATE__OUTPUT_SIGNALS = SIMPLE_STATE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Composite State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_STATE_FEATURE_COUNT = SIMPLE_STATE_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.TransitionImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getTransition()
     * @generated
     */
    int TRANSITION = 7;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__TARGET = 0;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__SOURCE = 1;

    /**
     * The feature id for the '<em><b>Priority</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__PRIORITY = 2;

    /**
     * The feature id for the '<em><b>Effect</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__EFFECT = 3;

    /**
     * The feature id for the '<em><b>Effect String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION__EFFECT_STRING = 4;

    /**
     * The number of structural features of the '<em>Transition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION_FEATURE_COUNT = 5;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.TransitionTriggerableImpl <em>Transition Triggerable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.TransitionTriggerableImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getTransitionTriggerable()
     * @generated
     */
    int TRANSITION_TRIGGERABLE = 8;

    /**
     * The feature id for the '<em><b>Trigger</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION_TRIGGERABLE__TRIGGER = 0;

    /**
     * The feature id for the '<em><b>Trigger String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION_TRIGGERABLE__TRIGGER_STRING = 1;

    /**
     * The number of structural features of the '<em>Transition Triggerable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION_TRIGGERABLE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.TransitionImmediateableImpl <em>Transition Immediateable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.TransitionImmediateableImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getTransitionImmediateable()
     * @generated
     */
    int TRANSITION_IMMEDIATEABLE = 9;

    /**
     * The feature id for the '<em><b>Is Immediate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE = 0;

    /**
     * The feature id for the '<em><b>Is Immediate String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE_STRING = 1;

    /**
     * The number of structural features of the '<em>Transition Immediateable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSITION_IMMEDIATEABLE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.InitialArcImpl <em>Initial Arc</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.InitialArcImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getInitialArc()
     * @generated
     */
    int INITIAL_ARC = 10;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INITIAL_ARC__TARGET = TRANSITION__TARGET;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INITIAL_ARC__SOURCE = TRANSITION__SOURCE;

    /**
     * The feature id for the '<em><b>Priority</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INITIAL_ARC__PRIORITY = TRANSITION__PRIORITY;

    /**
     * The feature id for the '<em><b>Effect</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INITIAL_ARC__EFFECT = TRANSITION__EFFECT;

    /**
     * The feature id for the '<em><b>Effect String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INITIAL_ARC__EFFECT_STRING = TRANSITION__EFFECT_STRING;

    /**
     * The feature id for the '<em><b>Trigger</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INITIAL_ARC__TRIGGER = TRANSITION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Trigger String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INITIAL_ARC__TRIGGER_STRING = TRANSITION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Initial Arc</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INITIAL_ARC_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.ConditionalTransitionImpl <em>Conditional Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ConditionalTransitionImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getConditionalTransition()
     * @generated
     */
    int CONDITIONAL_TRANSITION = 11;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONDITIONAL_TRANSITION__TARGET = TRANSITION__TARGET;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONDITIONAL_TRANSITION__SOURCE = TRANSITION__SOURCE;

    /**
     * The feature id for the '<em><b>Priority</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONDITIONAL_TRANSITION__PRIORITY = TRANSITION__PRIORITY;

    /**
     * The feature id for the '<em><b>Effect</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONDITIONAL_TRANSITION__EFFECT = TRANSITION__EFFECT;

    /**
     * The feature id for the '<em><b>Effect String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONDITIONAL_TRANSITION__EFFECT_STRING = TRANSITION__EFFECT_STRING;

    /**
     * The feature id for the '<em><b>Trigger</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONDITIONAL_TRANSITION__TRIGGER = TRANSITION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Trigger String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONDITIONAL_TRANSITION__TRIGGER_STRING = TRANSITION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Conditional Transition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONDITIONAL_TRANSITION_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.NormalTerminationImpl <em>Normal Termination</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.NormalTerminationImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getNormalTermination()
     * @generated
     */
    int NORMAL_TERMINATION = 12;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NORMAL_TERMINATION__TARGET = TRANSITION__TARGET;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NORMAL_TERMINATION__SOURCE = TRANSITION__SOURCE;

    /**
     * The feature id for the '<em><b>Priority</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NORMAL_TERMINATION__PRIORITY = TRANSITION__PRIORITY;

    /**
     * The feature id for the '<em><b>Effect</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NORMAL_TERMINATION__EFFECT = TRANSITION__EFFECT;

    /**
     * The feature id for the '<em><b>Effect String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NORMAL_TERMINATION__EFFECT_STRING = TRANSITION__EFFECT_STRING;

    /**
     * The number of structural features of the '<em>Normal Termination</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NORMAL_TERMINATION_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.StrongAbortionImpl <em>Strong Abortion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.StrongAbortionImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getStrongAbortion()
     * @generated
     */
    int STRONG_ABORTION = 13;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRONG_ABORTION__TARGET = TRANSITION__TARGET;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRONG_ABORTION__SOURCE = TRANSITION__SOURCE;

    /**
     * The feature id for the '<em><b>Priority</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRONG_ABORTION__PRIORITY = TRANSITION__PRIORITY;

    /**
     * The feature id for the '<em><b>Effect</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRONG_ABORTION__EFFECT = TRANSITION__EFFECT;

    /**
     * The feature id for the '<em><b>Effect String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRONG_ABORTION__EFFECT_STRING = TRANSITION__EFFECT_STRING;

    /**
     * The feature id for the '<em><b>Trigger</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRONG_ABORTION__TRIGGER = TRANSITION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Trigger String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRONG_ABORTION__TRIGGER_STRING = TRANSITION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Is Immediate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRONG_ABORTION__IS_IMMEDIATE = TRANSITION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Is Immediate String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRONG_ABORTION__IS_IMMEDIATE_STRING = TRANSITION_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Strong Abortion</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRONG_ABORTION_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.WeakAbortionImpl <em>Weak Abortion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.WeakAbortionImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getWeakAbortion()
     * @generated
     */
    int WEAK_ABORTION = 14;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_ABORTION__TARGET = TRANSITION__TARGET;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_ABORTION__SOURCE = TRANSITION__SOURCE;

    /**
     * The feature id for the '<em><b>Priority</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_ABORTION__PRIORITY = TRANSITION__PRIORITY;

    /**
     * The feature id for the '<em><b>Effect</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_ABORTION__EFFECT = TRANSITION__EFFECT;

    /**
     * The feature id for the '<em><b>Effect String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_ABORTION__EFFECT_STRING = TRANSITION__EFFECT_STRING;

    /**
     * The feature id for the '<em><b>Trigger</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_ABORTION__TRIGGER = TRANSITION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Trigger String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_ABORTION__TRIGGER_STRING = TRANSITION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Is Immediate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_ABORTION__IS_IMMEDIATE = TRANSITION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Is Immediate String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_ABORTION__IS_IMMEDIATE_STRING = TRANSITION_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Weak Abortion</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_ABORTION_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.SafeStateMachineImpl <em>Safe State Machine</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.SafeStateMachineImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getSafeStateMachine()
     * @generated
     */
    int SAFE_STATE_MACHINE = 15;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SAFE_STATE_MACHINE__NAME = NAMED__NAME;

    /**
     * The feature id for the '<em><b>Top</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SAFE_STATE_MACHINE__TOP = NAMED_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Safe State Machine</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SAFE_STATE_MACHINE_FEATURE_COUNT = NAMED_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.TriggerImpl <em>Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.TriggerImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getTrigger()
     * @generated
     */
    int TRIGGER = 16;

    /**
     * The feature id for the '<em><b>Counter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER__COUNTER = 0;

    /**
     * The feature id for the '<em><b>Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER__EVENT = 1;

    /**
     * The feature id for the '<em><b>Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER__CONDITION = 2;

    /**
     * The number of structural features of the '<em>Trigger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.ActionImpl <em>Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ActionImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getAction()
     * @generated
     */
    int ACTION = 17;

    /**
     * The feature id for the '<em><b>Signals</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION__SIGNALS = 0;

    /**
     * The number of structural features of the '<em>Action</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.OnActionImpl <em>On Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.OnActionImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getOnAction()
     * @generated
     */
    int ON_ACTION = 18;

    /**
     * The feature id for the '<em><b>Trigger</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ON_ACTION__TRIGGER = 0;

    /**
     * The feature id for the '<em><b>Effect</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ON_ACTION__EFFECT = 1;

    /**
     * The number of structural features of the '<em>On Action</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ON_ACTION_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.SignalImpl <em>Signal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.SignalImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getSignal()
     * @generated
     */
    int SIGNAL = 19;

    /**
     * The feature id for the '<em><b>Signal Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL__SIGNAL_NAME = 0;

    /**
     * The number of structural features of the '<em>Signal</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNAL_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.IntegerSignalImpl <em>Integer Signal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.impl.IntegerSignalImpl
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getIntegerSignal()
     * @generated
     */
    int INTEGER_SIGNAL = 20;

    /**
     * The feature id for the '<em><b>Signal Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTEGER_SIGNAL__SIGNAL_NAME = SIGNAL__SIGNAL_NAME;

    /**
     * The feature id for the '<em><b>Integer Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTEGER_SIGNAL__INTEGER_VALUE = SIGNAL_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Integer Signal</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INTEGER_SIGNAL_FEATURE_COUNT = SIGNAL_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link edu.unikiel.rtsys.kieler.ssm.StateFlag <em>State Flag</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.kieler.ssm.StateFlag
     * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getStateFlag()
     * @generated
     */
    int STATE_FLAG = 21;


    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.Named <em>Named</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Named
     * @generated
     */
    EClass getNamed();

    /**
     * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.ssm.Named#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Named#getName()
     * @see #getNamed()
     * @generated
     */
    EAttribute getNamed_Name();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.Region <em>Region</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Region</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Region
     * @generated
     */
    EClass getRegion();

    /**
     * Returns the meta object for the containment reference list '{@link edu.unikiel.rtsys.kieler.ssm.Region#getStates <em>States</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>States</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Region#getStates()
     * @see #getRegion()
     * @generated
     */
    EReference getRegion_States();

    /**
     * Returns the meta object for the containment reference list '{@link edu.unikiel.rtsys.kieler.ssm.Region#getTransitions <em>Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Transitions</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Region#getTransitions()
     * @see #getRegion()
     * @generated
     */
    EReference getRegion_Transitions();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.AbstractState <em>Abstract State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract State</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.AbstractState
     * @generated
     */
    EClass getAbstractState();

    /**
     * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.kieler.ssm.AbstractState#getIncomingTransitions <em>Incoming Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Incoming Transitions</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.AbstractState#getIncomingTransitions()
     * @see #getAbstractState()
     * @generated
     */
    EReference getAbstractState_IncomingTransitions();

    /**
     * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.kieler.ssm.AbstractState#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Outgoing Transitions</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.AbstractState#getOutgoingTransitions()
     * @see #getAbstractState()
     * @generated
     */
    EReference getAbstractState_OutgoingTransitions();

    /**
     * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.ssm.AbstractState#getOnEntryAction <em>On Entry Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>On Entry Action</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.AbstractState#getOnEntryAction()
     * @see #getAbstractState()
     * @generated
     */
    EReference getAbstractState_OnEntryAction();

    /**
     * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.ssm.AbstractState#getOnInsideAction <em>On Inside Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>On Inside Action</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.AbstractState#getOnInsideAction()
     * @see #getAbstractState()
     * @generated
     */
    EReference getAbstractState_OnInsideAction();

    /**
     * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.ssm.AbstractState#getOnExitAction <em>On Exit Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>On Exit Action</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.AbstractState#getOnExitAction()
     * @see #getAbstractState()
     * @generated
     */
    EReference getAbstractState_OnExitAction();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.SimpleState <em>Simple State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple State</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.SimpleState
     * @generated
     */
    EClass getSimpleState();

    /**
     * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.ssm.SimpleState#getStateFlag <em>State Flag</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>State Flag</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.SimpleState#getStateFlag()
     * @see #getSimpleState()
     * @generated
     */
    EAttribute getSimpleState_StateFlag();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.PseudoState <em>Pseudo State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Pseudo State</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.PseudoState
     * @generated
     */
    EClass getPseudoState();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.InitialState <em>Initial State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Initial State</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.InitialState
     * @generated
     */
    EClass getInitialState();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.CompositeState <em>Composite State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Composite State</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.CompositeState
     * @generated
     */
    EClass getCompositeState();

    /**
     * Returns the meta object for the containment reference list '{@link edu.unikiel.rtsys.kieler.ssm.CompositeState#getRegions <em>Regions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Regions</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.CompositeState#getRegions()
     * @see #getCompositeState()
     * @generated
     */
    EReference getCompositeState_Regions();

    /**
     * Returns the meta object for the containment reference list '{@link edu.unikiel.rtsys.kieler.ssm.CompositeState#getLocalSignals <em>Local Signals</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Local Signals</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.CompositeState#getLocalSignals()
     * @see #getCompositeState()
     * @generated
     */
    EReference getCompositeState_LocalSignals();

    /**
     * Returns the meta object for the containment reference list '{@link edu.unikiel.rtsys.kieler.ssm.CompositeState#getInputSignals <em>Input Signals</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Input Signals</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.CompositeState#getInputSignals()
     * @see #getCompositeState()
     * @generated
     */
    EReference getCompositeState_InputSignals();

    /**
     * Returns the meta object for the containment reference list '{@link edu.unikiel.rtsys.kieler.ssm.CompositeState#getOutputSignals <em>Output Signals</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Output Signals</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.CompositeState#getOutputSignals()
     * @see #getCompositeState()
     * @generated
     */
    EReference getCompositeState_OutputSignals();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.Transition <em>Transition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Transition</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Transition
     * @generated
     */
    EClass getTransition();

    /**
     * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.ssm.Transition#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Transition#getTarget()
     * @see #getTransition()
     * @generated
     */
    EReference getTransition_Target();

    /**
     * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.ssm.Transition#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Transition#getSource()
     * @see #getTransition()
     * @generated
     */
    EReference getTransition_Source();

    /**
     * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.ssm.Transition#getPriority <em>Priority</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Priority</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Transition#getPriority()
     * @see #getTransition()
     * @generated
     */
    EAttribute getTransition_Priority();

    /**
     * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.kieler.ssm.Transition#getEffect <em>Effect</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Effect</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Transition#getEffect()
     * @see #getTransition()
     * @generated
     */
    EReference getTransition_Effect();

    /**
     * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.ssm.Transition#getEffectString <em>Effect String</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Effect String</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Transition#getEffectString()
     * @see #getTransition()
     * @generated
     */
    EAttribute getTransition_EffectString();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.TransitionTriggerable <em>Transition Triggerable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Transition Triggerable</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.TransitionTriggerable
     * @generated
     */
    EClass getTransitionTriggerable();

    /**
     * Returns the meta object for the containment reference '{@link edu.unikiel.rtsys.kieler.ssm.TransitionTriggerable#getTrigger <em>Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Trigger</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.TransitionTriggerable#getTrigger()
     * @see #getTransitionTriggerable()
     * @generated
     */
    EReference getTransitionTriggerable_Trigger();

    /**
     * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.ssm.TransitionTriggerable#getTriggerString <em>Trigger String</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Trigger String</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.TransitionTriggerable#getTriggerString()
     * @see #getTransitionTriggerable()
     * @generated
     */
    EAttribute getTransitionTriggerable_TriggerString();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.TransitionImmediateable <em>Transition Immediateable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Transition Immediateable</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.TransitionImmediateable
     * @generated
     */
    EClass getTransitionImmediateable();

    /**
     * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.ssm.TransitionImmediateable#isIsImmediate <em>Is Immediate</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Immediate</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.TransitionImmediateable#isIsImmediate()
     * @see #getTransitionImmediateable()
     * @generated
     */
    EAttribute getTransitionImmediateable_IsImmediate();

    /**
     * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.ssm.TransitionImmediateable#getIsImmediateString <em>Is Immediate String</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Immediate String</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.TransitionImmediateable#getIsImmediateString()
     * @see #getTransitionImmediateable()
     * @generated
     */
    EAttribute getTransitionImmediateable_IsImmediateString();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.InitialArc <em>Initial Arc</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Initial Arc</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.InitialArc
     * @generated
     */
    EClass getInitialArc();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.ConditionalTransition <em>Conditional Transition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Conditional Transition</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.ConditionalTransition
     * @generated
     */
    EClass getConditionalTransition();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.NormalTermination <em>Normal Termination</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Normal Termination</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.NormalTermination
     * @generated
     */
    EClass getNormalTermination();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.StrongAbortion <em>Strong Abortion</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Strong Abortion</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.StrongAbortion
     * @generated
     */
    EClass getStrongAbortion();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.WeakAbortion <em>Weak Abortion</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Weak Abortion</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.WeakAbortion
     * @generated
     */
    EClass getWeakAbortion();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.SafeStateMachine <em>Safe State Machine</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Safe State Machine</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.SafeStateMachine
     * @generated
     */
    EClass getSafeStateMachine();

    /**
     * Returns the meta object for the containment reference '{@link edu.unikiel.rtsys.kieler.ssm.SafeStateMachine#getTop <em>Top</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Top</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.SafeStateMachine#getTop()
     * @see #getSafeStateMachine()
     * @generated
     */
    EReference getSafeStateMachine_Top();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.Trigger <em>Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Trigger</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Trigger
     * @generated
     */
    EClass getTrigger();

    /**
     * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.ssm.Trigger#getCounter <em>Counter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Counter</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Trigger#getCounter()
     * @see #getTrigger()
     * @generated
     */
    EAttribute getTrigger_Counter();

    /**
     * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.ssm.Trigger#getEvent <em>Event</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Event</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Trigger#getEvent()
     * @see #getTrigger()
     * @generated
     */
    EAttribute getTrigger_Event();

    /**
     * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.ssm.Trigger#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Condition</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Trigger#getCondition()
     * @see #getTrigger()
     * @generated
     */
    EAttribute getTrigger_Condition();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.Action <em>Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Action</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Action
     * @generated
     */
    EClass getAction();

    /**
     * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.kieler.ssm.Action#getSignals <em>Signals</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Signals</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Action#getSignals()
     * @see #getAction()
     * @generated
     */
    EReference getAction_Signals();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.OnAction <em>On Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>On Action</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.OnAction
     * @generated
     */
    EClass getOnAction();

    /**
     * Returns the meta object for the reference '{@link edu.unikiel.rtsys.kieler.ssm.OnAction#getTrigger <em>Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Trigger</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.OnAction#getTrigger()
     * @see #getOnAction()
     * @generated
     */
    EReference getOnAction_Trigger();

    /**
     * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.kieler.ssm.OnAction#getEffect <em>Effect</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Effect</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.OnAction#getEffect()
     * @see #getOnAction()
     * @generated
     */
    EReference getOnAction_Effect();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.Signal <em>Signal</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Signal</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Signal
     * @generated
     */
    EClass getSignal();

    /**
     * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.ssm.Signal#getSignalName <em>Signal Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Signal Name</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.Signal#getSignalName()
     * @see #getSignal()
     * @generated
     */
    EAttribute getSignal_SignalName();

    /**
     * Returns the meta object for class '{@link edu.unikiel.rtsys.kieler.ssm.IntegerSignal <em>Integer Signal</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Integer Signal</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.IntegerSignal
     * @generated
     */
    EClass getIntegerSignal();

    /**
     * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.kieler.ssm.IntegerSignal#getIntegerValue <em>Integer Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Integer Value</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.IntegerSignal#getIntegerValue()
     * @see #getIntegerSignal()
     * @generated
     */
    EAttribute getIntegerSignal_IntegerValue();

    /**
     * Returns the meta object for enum '{@link edu.unikiel.rtsys.kieler.ssm.StateFlag <em>State Flag</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>State Flag</em>'.
     * @see edu.unikiel.rtsys.kieler.ssm.StateFlag
     * @generated
     */
    EEnum getStateFlag();

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
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.NamedImpl <em>Named</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.NamedImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getNamed()
         * @generated
         */
        EClass NAMED = eINSTANCE.getNamed();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NAMED__NAME = eINSTANCE.getNamed_Name();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.RegionImpl <em>Region</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.RegionImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getRegion()
         * @generated
         */
        EClass REGION = eINSTANCE.getRegion();

        /**
         * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REGION__STATES = eINSTANCE.getRegion_States();

        /**
         * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REGION__TRANSITIONS = eINSTANCE.getRegion_Transitions();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.AbstractStateImpl <em>Abstract State</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.AbstractStateImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getAbstractState()
         * @generated
         */
        EClass ABSTRACT_STATE = eINSTANCE.getAbstractState();

        /**
         * The meta object literal for the '<em><b>Incoming Transitions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_STATE__INCOMING_TRANSITIONS = eINSTANCE.getAbstractState_IncomingTransitions();

        /**
         * The meta object literal for the '<em><b>Outgoing Transitions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_STATE__OUTGOING_TRANSITIONS = eINSTANCE.getAbstractState_OutgoingTransitions();

        /**
         * The meta object literal for the '<em><b>On Entry Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_STATE__ON_ENTRY_ACTION = eINSTANCE.getAbstractState_OnEntryAction();

        /**
         * The meta object literal for the '<em><b>On Inside Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_STATE__ON_INSIDE_ACTION = eINSTANCE.getAbstractState_OnInsideAction();

        /**
         * The meta object literal for the '<em><b>On Exit Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_STATE__ON_EXIT_ACTION = eINSTANCE.getAbstractState_OnExitAction();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.SimpleStateImpl <em>Simple State</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.SimpleStateImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getSimpleState()
         * @generated
         */
        EClass SIMPLE_STATE = eINSTANCE.getSimpleState();

        /**
         * The meta object literal for the '<em><b>State Flag</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SIMPLE_STATE__STATE_FLAG = eINSTANCE.getSimpleState_StateFlag();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.PseudoStateImpl <em>Pseudo State</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.PseudoStateImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getPseudoState()
         * @generated
         */
        EClass PSEUDO_STATE = eINSTANCE.getPseudoState();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.InitialStateImpl <em>Initial State</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.InitialStateImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getInitialState()
         * @generated
         */
        EClass INITIAL_STATE = eINSTANCE.getInitialState();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.CompositeStateImpl <em>Composite State</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.CompositeStateImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getCompositeState()
         * @generated
         */
        EClass COMPOSITE_STATE = eINSTANCE.getCompositeState();

        /**
         * The meta object literal for the '<em><b>Regions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPOSITE_STATE__REGIONS = eINSTANCE.getCompositeState_Regions();

        /**
         * The meta object literal for the '<em><b>Local Signals</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPOSITE_STATE__LOCAL_SIGNALS = eINSTANCE.getCompositeState_LocalSignals();

        /**
         * The meta object literal for the '<em><b>Input Signals</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPOSITE_STATE__INPUT_SIGNALS = eINSTANCE.getCompositeState_InputSignals();

        /**
         * The meta object literal for the '<em><b>Output Signals</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPOSITE_STATE__OUTPUT_SIGNALS = eINSTANCE.getCompositeState_OutputSignals();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.TransitionImpl <em>Transition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.TransitionImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getTransition()
         * @generated
         */
        EClass TRANSITION = eINSTANCE.getTransition();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRANSITION__TARGET = eINSTANCE.getTransition_Target();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRANSITION__SOURCE = eINSTANCE.getTransition_Source();

        /**
         * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TRANSITION__PRIORITY = eINSTANCE.getTransition_Priority();

        /**
         * The meta object literal for the '<em><b>Effect</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRANSITION__EFFECT = eINSTANCE.getTransition_Effect();

        /**
         * The meta object literal for the '<em><b>Effect String</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TRANSITION__EFFECT_STRING = eINSTANCE.getTransition_EffectString();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.TransitionTriggerableImpl <em>Transition Triggerable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.TransitionTriggerableImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getTransitionTriggerable()
         * @generated
         */
        EClass TRANSITION_TRIGGERABLE = eINSTANCE.getTransitionTriggerable();

        /**
         * The meta object literal for the '<em><b>Trigger</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRANSITION_TRIGGERABLE__TRIGGER = eINSTANCE.getTransitionTriggerable_Trigger();

        /**
         * The meta object literal for the '<em><b>Trigger String</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TRANSITION_TRIGGERABLE__TRIGGER_STRING = eINSTANCE.getTransitionTriggerable_TriggerString();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.TransitionImmediateableImpl <em>Transition Immediateable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.TransitionImmediateableImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getTransitionImmediateable()
         * @generated
         */
        EClass TRANSITION_IMMEDIATEABLE = eINSTANCE.getTransitionImmediateable();

        /**
         * The meta object literal for the '<em><b>Is Immediate</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE = eINSTANCE.getTransitionImmediateable_IsImmediate();

        /**
         * The meta object literal for the '<em><b>Is Immediate String</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE_STRING = eINSTANCE.getTransitionImmediateable_IsImmediateString();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.InitialArcImpl <em>Initial Arc</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.InitialArcImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getInitialArc()
         * @generated
         */
        EClass INITIAL_ARC = eINSTANCE.getInitialArc();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.ConditionalTransitionImpl <em>Conditional Transition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ConditionalTransitionImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getConditionalTransition()
         * @generated
         */
        EClass CONDITIONAL_TRANSITION = eINSTANCE.getConditionalTransition();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.NormalTerminationImpl <em>Normal Termination</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.NormalTerminationImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getNormalTermination()
         * @generated
         */
        EClass NORMAL_TERMINATION = eINSTANCE.getNormalTermination();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.StrongAbortionImpl <em>Strong Abortion</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.StrongAbortionImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getStrongAbortion()
         * @generated
         */
        EClass STRONG_ABORTION = eINSTANCE.getStrongAbortion();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.WeakAbortionImpl <em>Weak Abortion</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.WeakAbortionImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getWeakAbortion()
         * @generated
         */
        EClass WEAK_ABORTION = eINSTANCE.getWeakAbortion();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.SafeStateMachineImpl <em>Safe State Machine</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.SafeStateMachineImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getSafeStateMachine()
         * @generated
         */
        EClass SAFE_STATE_MACHINE = eINSTANCE.getSafeStateMachine();

        /**
         * The meta object literal for the '<em><b>Top</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SAFE_STATE_MACHINE__TOP = eINSTANCE.getSafeStateMachine_Top();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.TriggerImpl <em>Trigger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.TriggerImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getTrigger()
         * @generated
         */
        EClass TRIGGER = eINSTANCE.getTrigger();

        /**
         * The meta object literal for the '<em><b>Counter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TRIGGER__COUNTER = eINSTANCE.getTrigger_Counter();

        /**
         * The meta object literal for the '<em><b>Event</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TRIGGER__EVENT = eINSTANCE.getTrigger_Event();

        /**
         * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TRIGGER__CONDITION = eINSTANCE.getTrigger_Condition();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.ActionImpl <em>Action</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ActionImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getAction()
         * @generated
         */
        EClass ACTION = eINSTANCE.getAction();

        /**
         * The meta object literal for the '<em><b>Signals</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ACTION__SIGNALS = eINSTANCE.getAction_Signals();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.OnActionImpl <em>On Action</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.OnActionImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getOnAction()
         * @generated
         */
        EClass ON_ACTION = eINSTANCE.getOnAction();

        /**
         * The meta object literal for the '<em><b>Trigger</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ON_ACTION__TRIGGER = eINSTANCE.getOnAction_Trigger();

        /**
         * The meta object literal for the '<em><b>Effect</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ON_ACTION__EFFECT = eINSTANCE.getOnAction_Effect();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.SignalImpl <em>Signal</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.SignalImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getSignal()
         * @generated
         */
        EClass SIGNAL = eINSTANCE.getSignal();

        /**
         * The meta object literal for the '<em><b>Signal Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SIGNAL__SIGNAL_NAME = eINSTANCE.getSignal_SignalName();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.impl.IntegerSignalImpl <em>Integer Signal</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.impl.IntegerSignalImpl
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getIntegerSignal()
         * @generated
         */
        EClass INTEGER_SIGNAL = eINSTANCE.getIntegerSignal();

        /**
         * The meta object literal for the '<em><b>Integer Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INTEGER_SIGNAL__INTEGER_VALUE = eINSTANCE.getIntegerSignal_IntegerValue();

        /**
         * The meta object literal for the '{@link edu.unikiel.rtsys.kieler.ssm.StateFlag <em>State Flag</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.unikiel.rtsys.kieler.ssm.StateFlag
         * @see edu.unikiel.rtsys.kieler.ssm.impl.ssmPackageImpl#getStateFlag()
         * @generated
         */
        EEnum STATE_FLAG = eINSTANCE.getStateFlag();

    }

} //ssmPackage
