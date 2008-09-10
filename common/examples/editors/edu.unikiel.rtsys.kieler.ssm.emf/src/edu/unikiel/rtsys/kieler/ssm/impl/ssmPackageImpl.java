/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm.impl;

import edu.unikiel.rtsys.kieler.ssm.AbstractState;
import edu.unikiel.rtsys.kieler.ssm.Action;
import edu.unikiel.rtsys.kieler.ssm.CompositeState;
import edu.unikiel.rtsys.kieler.ssm.ConditionalTransition;
import edu.unikiel.rtsys.kieler.ssm.InitialArc;
import edu.unikiel.rtsys.kieler.ssm.InitialState;
import edu.unikiel.rtsys.kieler.ssm.IntegerSignal;
import edu.unikiel.rtsys.kieler.ssm.Named;
import edu.unikiel.rtsys.kieler.ssm.NormalTermination;
import edu.unikiel.rtsys.kieler.ssm.OnAction;
import edu.unikiel.rtsys.kieler.ssm.PseudoState;
import edu.unikiel.rtsys.kieler.ssm.Region;
import edu.unikiel.rtsys.kieler.ssm.SafeStateMachine;
import edu.unikiel.rtsys.kieler.ssm.Signal;
import edu.unikiel.rtsys.kieler.ssm.SimpleState;
import edu.unikiel.rtsys.kieler.ssm.StateFlag;
import edu.unikiel.rtsys.kieler.ssm.StrongAbortion;
import edu.unikiel.rtsys.kieler.ssm.Transition;
import edu.unikiel.rtsys.kieler.ssm.TransitionImmediateable;
import edu.unikiel.rtsys.kieler.ssm.TransitionTriggerable;
import edu.unikiel.rtsys.kieler.ssm.Trigger;
import edu.unikiel.rtsys.kieler.ssm.WeakAbortion;
import edu.unikiel.rtsys.kieler.ssm.ssmFactory;
import edu.unikiel.rtsys.kieler.ssm.ssmPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ssmPackageImpl extends EPackageImpl implements ssmPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass namedEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass regionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractStateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass simpleStateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass pseudoStateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass initialStateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass compositeStateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass transitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass transitionTriggerableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass transitionImmediateableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass initialArcEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass conditionalTransitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass normalTerminationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass strongAbortionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass weakAbortionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass safeStateMachineEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass triggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass actionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass onActionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass signalEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass integerSignalEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum stateFlagEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ssmPackageImpl() {
        super(eNS_URI, ssmFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this
     * model, and for any others upon which it depends.  Simple
     * dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else.  This method drives
     * initialization for interdependent packages directly, in parallel
     * with this package, itself.
     * <p>Of this package and its interdependencies, all packages which
     * have not yet been registered by their URI values are first created
     * and registered.  The packages are then initialized in two steps:
     * meta-model objects for all of the packages are created before any
     * are initialized, since one package's meta-model objects may refer to
     * those of another.
     * <p>Invocation of this method will not affect any packages that have
     * already been initialized.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ssmPackage init() {
        if (isInited) return (ssmPackage)EPackage.Registry.INSTANCE.getEPackage(ssmPackage.eNS_URI);

        // Obtain or create and register package
        ssmPackageImpl thessmPackage = (ssmPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ssmPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ssmPackageImpl());

        isInited = true;

        // Create package meta-data objects
        thessmPackage.createPackageContents();

        // Initialize created meta-data
        thessmPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        thessmPackage.freeze();

        return thessmPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNamed() {
        return namedEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNamed_Name() {
        return (EAttribute)namedEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRegion() {
        return regionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRegion_States() {
        return (EReference)regionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRegion_Transitions() {
        return (EReference)regionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAbstractState() {
        return abstractStateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractState_IncomingTransitions() {
        return (EReference)abstractStateEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractState_OutgoingTransitions() {
        return (EReference)abstractStateEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractState_OnEntryAction() {
        return (EReference)abstractStateEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractState_OnInsideAction() {
        return (EReference)abstractStateEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractState_OnExitAction() {
        return (EReference)abstractStateEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSimpleState() {
        return simpleStateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimpleState_StateFlag() {
        return (EAttribute)simpleStateEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPseudoState() {
        return pseudoStateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInitialState() {
        return initialStateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCompositeState() {
        return compositeStateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCompositeState_Regions() {
        return (EReference)compositeStateEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCompositeState_LocalSignals() {
        return (EReference)compositeStateEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCompositeState_InputSignals() {
        return (EReference)compositeStateEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCompositeState_OutputSignals() {
        return (EReference)compositeStateEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTransition() {
        return transitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTransition_Target() {
        return (EReference)transitionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTransition_Source() {
        return (EReference)transitionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTransition_Priority() {
        return (EAttribute)transitionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTransition_Effect() {
        return (EReference)transitionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTransition_EffectString() {
        return (EAttribute)transitionEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTransitionTriggerable() {
        return transitionTriggerableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTransitionTriggerable_Trigger() {
        return (EReference)transitionTriggerableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTransitionTriggerable_TriggerString() {
        return (EAttribute)transitionTriggerableEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTransitionImmediateable() {
        return transitionImmediateableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTransitionImmediateable_IsImmediate() {
        return (EAttribute)transitionImmediateableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTransitionImmediateable_IsImmediateString() {
        return (EAttribute)transitionImmediateableEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInitialArc() {
        return initialArcEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConditionalTransition() {
        return conditionalTransitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNormalTermination() {
        return normalTerminationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStrongAbortion() {
        return strongAbortionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWeakAbortion() {
        return weakAbortionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSafeStateMachine() {
        return safeStateMachineEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSafeStateMachine_Top() {
        return (EReference)safeStateMachineEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTrigger() {
        return triggerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTrigger_Counter() {
        return (EAttribute)triggerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTrigger_Event() {
        return (EAttribute)triggerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTrigger_Condition() {
        return (EAttribute)triggerEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAction() {
        return actionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAction_Signals() {
        return (EReference)actionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOnAction() {
        return onActionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOnAction_Trigger() {
        return (EReference)onActionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOnAction_Effect() {
        return (EReference)onActionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSignal() {
        return signalEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSignal_SignalName() {
        return (EAttribute)signalEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIntegerSignal() {
        return integerSignalEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIntegerSignal_IntegerValue() {
        return (EAttribute)integerSignalEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getStateFlag() {
        return stateFlagEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ssmFactory getssmFactory() {
        return (ssmFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        namedEClass = createEClass(NAMED);
        createEAttribute(namedEClass, NAMED__NAME);

        regionEClass = createEClass(REGION);
        createEReference(regionEClass, REGION__STATES);
        createEReference(regionEClass, REGION__TRANSITIONS);

        abstractStateEClass = createEClass(ABSTRACT_STATE);
        createEReference(abstractStateEClass, ABSTRACT_STATE__INCOMING_TRANSITIONS);
        createEReference(abstractStateEClass, ABSTRACT_STATE__OUTGOING_TRANSITIONS);
        createEReference(abstractStateEClass, ABSTRACT_STATE__ON_ENTRY_ACTION);
        createEReference(abstractStateEClass, ABSTRACT_STATE__ON_INSIDE_ACTION);
        createEReference(abstractStateEClass, ABSTRACT_STATE__ON_EXIT_ACTION);

        simpleStateEClass = createEClass(SIMPLE_STATE);
        createEAttribute(simpleStateEClass, SIMPLE_STATE__STATE_FLAG);

        pseudoStateEClass = createEClass(PSEUDO_STATE);

        initialStateEClass = createEClass(INITIAL_STATE);

        compositeStateEClass = createEClass(COMPOSITE_STATE);
        createEReference(compositeStateEClass, COMPOSITE_STATE__REGIONS);
        createEReference(compositeStateEClass, COMPOSITE_STATE__LOCAL_SIGNALS);
        createEReference(compositeStateEClass, COMPOSITE_STATE__INPUT_SIGNALS);
        createEReference(compositeStateEClass, COMPOSITE_STATE__OUTPUT_SIGNALS);

        transitionEClass = createEClass(TRANSITION);
        createEReference(transitionEClass, TRANSITION__TARGET);
        createEReference(transitionEClass, TRANSITION__SOURCE);
        createEAttribute(transitionEClass, TRANSITION__PRIORITY);
        createEReference(transitionEClass, TRANSITION__EFFECT);
        createEAttribute(transitionEClass, TRANSITION__EFFECT_STRING);

        transitionTriggerableEClass = createEClass(TRANSITION_TRIGGERABLE);
        createEReference(transitionTriggerableEClass, TRANSITION_TRIGGERABLE__TRIGGER);
        createEAttribute(transitionTriggerableEClass, TRANSITION_TRIGGERABLE__TRIGGER_STRING);

        transitionImmediateableEClass = createEClass(TRANSITION_IMMEDIATEABLE);
        createEAttribute(transitionImmediateableEClass, TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE);
        createEAttribute(transitionImmediateableEClass, TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE_STRING);

        initialArcEClass = createEClass(INITIAL_ARC);

        conditionalTransitionEClass = createEClass(CONDITIONAL_TRANSITION);

        normalTerminationEClass = createEClass(NORMAL_TERMINATION);

        strongAbortionEClass = createEClass(STRONG_ABORTION);

        weakAbortionEClass = createEClass(WEAK_ABORTION);

        safeStateMachineEClass = createEClass(SAFE_STATE_MACHINE);
        createEReference(safeStateMachineEClass, SAFE_STATE_MACHINE__TOP);

        triggerEClass = createEClass(TRIGGER);
        createEAttribute(triggerEClass, TRIGGER__COUNTER);
        createEAttribute(triggerEClass, TRIGGER__EVENT);
        createEAttribute(triggerEClass, TRIGGER__CONDITION);

        actionEClass = createEClass(ACTION);
        createEReference(actionEClass, ACTION__SIGNALS);

        onActionEClass = createEClass(ON_ACTION);
        createEReference(onActionEClass, ON_ACTION__TRIGGER);
        createEReference(onActionEClass, ON_ACTION__EFFECT);

        signalEClass = createEClass(SIGNAL);
        createEAttribute(signalEClass, SIGNAL__SIGNAL_NAME);

        integerSignalEClass = createEClass(INTEGER_SIGNAL);
        createEAttribute(integerSignalEClass, INTEGER_SIGNAL__INTEGER_VALUE);

        // Create enums
        stateFlagEEnum = createEEnum(STATE_FLAG);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        simpleStateEClass.getESuperTypes().add(this.getAbstractState());
        simpleStateEClass.getESuperTypes().add(this.getNamed());
        pseudoStateEClass.getESuperTypes().add(this.getAbstractState());
        initialStateEClass.getESuperTypes().add(this.getPseudoState());
        compositeStateEClass.getESuperTypes().add(this.getSimpleState());
        initialArcEClass.getESuperTypes().add(this.getTransition());
        initialArcEClass.getESuperTypes().add(this.getTransitionTriggerable());
        conditionalTransitionEClass.getESuperTypes().add(this.getTransition());
        conditionalTransitionEClass.getESuperTypes().add(this.getTransitionTriggerable());
        normalTerminationEClass.getESuperTypes().add(this.getTransition());
        strongAbortionEClass.getESuperTypes().add(this.getTransition());
        strongAbortionEClass.getESuperTypes().add(this.getTransitionTriggerable());
        strongAbortionEClass.getESuperTypes().add(this.getTransitionImmediateable());
        weakAbortionEClass.getESuperTypes().add(this.getTransition());
        weakAbortionEClass.getESuperTypes().add(this.getTransitionTriggerable());
        weakAbortionEClass.getESuperTypes().add(this.getTransitionImmediateable());
        safeStateMachineEClass.getESuperTypes().add(this.getNamed());
        integerSignalEClass.getESuperTypes().add(this.getSignal());

        // Initialize classes and features; add operations and parameters
        initEClass(namedEClass, Named.class, "Named", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNamed_Name(), ecorePackage.getEString(), "name", null, 0, 1, Named.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(regionEClass, Region.class, "Region", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRegion_States(), this.getAbstractState(), null, "states", null, 1, -1, Region.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRegion_Transitions(), this.getTransition(), null, "transitions", null, 0, -1, Region.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(abstractStateEClass, AbstractState.class, "AbstractState", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAbstractState_IncomingTransitions(), this.getTransition(), this.getTransition_Target(), "incomingTransitions", null, 0, -1, AbstractState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAbstractState_OutgoingTransitions(), this.getTransition(), this.getTransition_Source(), "outgoingTransitions", null, 0, -1, AbstractState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAbstractState_OnEntryAction(), this.getOnAction(), null, "onEntryAction", null, 0, 1, AbstractState.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAbstractState_OnInsideAction(), this.getOnAction(), null, "onInsideAction", null, 0, 1, AbstractState.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAbstractState_OnExitAction(), this.getOnAction(), null, "onExitAction", null, 0, 1, AbstractState.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(simpleStateEClass, SimpleState.class, "SimpleState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSimpleState_StateFlag(), this.getStateFlag(), "stateFlag", "", 1, 1, SimpleState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pseudoStateEClass, PseudoState.class, "PseudoState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(initialStateEClass, InitialState.class, "InitialState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(compositeStateEClass, CompositeState.class, "CompositeState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getCompositeState_Regions(), this.getRegion(), null, "regions", null, 1, -1, CompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCompositeState_LocalSignals(), this.getSignal(), null, "localSignals", null, 0, -1, CompositeState.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCompositeState_InputSignals(), this.getSignal(), null, "inputSignals", null, 0, -1, CompositeState.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCompositeState_OutputSignals(), this.getSignal(), null, "outputSignals", null, 0, -1, CompositeState.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTransition_Target(), this.getAbstractState(), this.getAbstractState_IncomingTransitions(), "target", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTransition_Source(), this.getAbstractState(), this.getAbstractState_OutgoingTransitions(), "source", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTransition_Priority(), ecorePackage.getEInt(), "priority", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTransition_Effect(), this.getAction(), null, "effect", null, 0, -1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTransition_EffectString(), ecorePackage.getEString(), "effectString", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(transitionTriggerableEClass, TransitionTriggerable.class, "TransitionTriggerable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTransitionTriggerable_Trigger(), this.getTrigger(), null, "trigger", null, 1, 1, TransitionTriggerable.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTransitionTriggerable_TriggerString(), ecorePackage.getEString(), "triggerString", null, 0, 1, TransitionTriggerable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(transitionImmediateableEClass, TransitionImmediateable.class, "TransitionImmediateable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTransitionImmediateable_IsImmediate(), ecorePackage.getEBoolean(), "isImmediate", "false", 0, 1, TransitionImmediateable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTransitionImmediateable_IsImmediateString(), ecorePackage.getEString(), "isImmediateString", null, 0, 1, TransitionImmediateable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(initialArcEClass, InitialArc.class, "InitialArc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(conditionalTransitionEClass, ConditionalTransition.class, "ConditionalTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(normalTerminationEClass, NormalTermination.class, "NormalTermination", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(strongAbortionEClass, StrongAbortion.class, "StrongAbortion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(weakAbortionEClass, WeakAbortion.class, "WeakAbortion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(safeStateMachineEClass, SafeStateMachine.class, "SafeStateMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSafeStateMachine_Top(), this.getCompositeState(), null, "top", null, 1, 1, SafeStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(triggerEClass, Trigger.class, "Trigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTrigger_Counter(), ecorePackage.getEInt(), "counter", null, 0, 1, Trigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTrigger_Event(), ecorePackage.getEString(), "event", null, 0, 1, Trigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTrigger_Condition(), ecorePackage.getEString(), "condition", null, 0, 1, Trigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(actionEClass, Action.class, "Action", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAction_Signals(), this.getSignal(), null, "signals", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(onActionEClass, OnAction.class, "OnAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOnAction_Trigger(), this.getTrigger(), null, "trigger", null, 0, 1, OnAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOnAction_Effect(), this.getAction(), null, "effect", null, 0, -1, OnAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(signalEClass, Signal.class, "Signal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSignal_SignalName(), ecorePackage.getEString(), "signalName", null, 0, 1, Signal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(integerSignalEClass, IntegerSignal.class, "IntegerSignal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntegerSignal_IntegerValue(), ecorePackage.getEInt(), "integerValue", null, 0, 1, IntegerSignal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(stateFlagEEnum, StateFlag.class, "StateFlag");
        addEEnumLiteral(stateFlagEEnum, StateFlag.NORMAL);
        addEEnumLiteral(stateFlagEEnum, StateFlag.INITIAL);
        addEEnumLiteral(stateFlagEEnum, StateFlag.FINAL);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://rtsys.informatik.uni-kiel.de/trac/kieler
        createKielerAnnotations();
    }

    /**
     * Initializes the annotations for <b>http://rtsys.informatik.uni-kiel.de/trac/kieler</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createKielerAnnotations() {
        String source = "http://rtsys.informatik.uni-kiel.de/trac/kieler";		
        addAnnotation
          (regionEClass, 
           source, 
           new String[] {
             "documentation", "Region corresponds to a STG (state-transition-graph) in the SSM syntax. It is named Region here for understandabilty reasons."
           });		
        addAnnotation
          (abstractStateEClass, 
           source, 
           new String[] {
             "documentation", "This one is called Reactive-Cell in the SSM documentation. For convenience, it is called \"Abstract State\" here."
           });		
        addAnnotation
          (compositeStateEClass, 
           source, 
           new String[] {
             "documentation", "This one is called \"MacroState\" in the SSM definition"
           });
    }

} //ssmPackageImpl
