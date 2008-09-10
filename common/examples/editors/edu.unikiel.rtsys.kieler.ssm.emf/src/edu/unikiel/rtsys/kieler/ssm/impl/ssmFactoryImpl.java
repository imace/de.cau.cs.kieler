/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm.impl;

import edu.unikiel.rtsys.kieler.ssm.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ssmFactoryImpl extends EFactoryImpl implements ssmFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ssmFactory init() {
        try {
            ssmFactory thessmFactory = (ssmFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.informatik.uni-kiel.de/rtsys/ssm"); 
            if (thessmFactory != null) {
                return thessmFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ssmFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ssmFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case ssmPackage.NAMED: return createNamed();
            case ssmPackage.REGION: return createRegion();
            case ssmPackage.SIMPLE_STATE: return createSimpleState();
            case ssmPackage.PSEUDO_STATE: return createPseudoState();
            case ssmPackage.INITIAL_STATE: return createInitialState();
            case ssmPackage.COMPOSITE_STATE: return createCompositeState();
            case ssmPackage.TRANSITION: return createTransition();
            case ssmPackage.TRANSITION_TRIGGERABLE: return createTransitionTriggerable();
            case ssmPackage.TRANSITION_IMMEDIATEABLE: return createTransitionImmediateable();
            case ssmPackage.INITIAL_ARC: return createInitialArc();
            case ssmPackage.CONDITIONAL_TRANSITION: return createConditionalTransition();
            case ssmPackage.NORMAL_TERMINATION: return createNormalTermination();
            case ssmPackage.STRONG_ABORTION: return createStrongAbortion();
            case ssmPackage.WEAK_ABORTION: return createWeakAbortion();
            case ssmPackage.SAFE_STATE_MACHINE: return createSafeStateMachine();
            case ssmPackage.TRIGGER: return createTrigger();
            case ssmPackage.ACTION: return createAction();
            case ssmPackage.ON_ACTION: return createOnAction();
            case ssmPackage.SIGNAL: return createSignal();
            case ssmPackage.INTEGER_SIGNAL: return createIntegerSignal();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case ssmPackage.STATE_FLAG:
                return createStateFlagFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case ssmPackage.STATE_FLAG:
                return convertStateFlagToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Named createNamed() {
        NamedImpl named = new NamedImpl();
        return named;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Region createRegion() {
        RegionImpl region = new RegionImpl();
        return region;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimpleState createSimpleState() {
        SimpleStateImpl simpleState = new SimpleStateImpl();
        return simpleState;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PseudoState createPseudoState() {
        PseudoStateImpl pseudoState = new PseudoStateImpl();
        return pseudoState;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InitialState createInitialState() {
        InitialStateImpl initialState = new InitialStateImpl();
        return initialState;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompositeState createCompositeState() {
        CompositeStateImpl compositeState = new CompositeStateImpl();
        return compositeState;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Transition createTransition() {
        TransitionImpl transition = new TransitionImpl();
        return transition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TransitionTriggerable createTransitionTriggerable() {
        TransitionTriggerableImpl transitionTriggerable = new TransitionTriggerableImpl();
        return transitionTriggerable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TransitionImmediateable createTransitionImmediateable() {
        TransitionImmediateableImpl transitionImmediateable = new TransitionImmediateableImpl();
        return transitionImmediateable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InitialArc createInitialArc() {
        InitialArcImpl initialArc = new InitialArcImpl();
        return initialArc;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConditionalTransition createConditionalTransition() {
        ConditionalTransitionImpl conditionalTransition = new ConditionalTransitionImpl();
        return conditionalTransition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NormalTermination createNormalTermination() {
        NormalTerminationImpl normalTermination = new NormalTerminationImpl();
        return normalTermination;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StrongAbortion createStrongAbortion() {
        StrongAbortionImpl strongAbortion = new StrongAbortionImpl();
        return strongAbortion;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WeakAbortion createWeakAbortion() {
        WeakAbortionImpl weakAbortion = new WeakAbortionImpl();
        return weakAbortion;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SafeStateMachine createSafeStateMachine() {
        SafeStateMachineImpl safeStateMachine = new SafeStateMachineImpl();
        return safeStateMachine;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Trigger createTrigger() {
        TriggerImpl trigger = new TriggerImpl();
        return trigger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Action createAction() {
        ActionImpl action = new ActionImpl();
        return action;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OnAction createOnAction() {
        OnActionImpl onAction = new OnActionImpl();
        return onAction;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Signal createSignal() {
        SignalImpl signal = new SignalImpl();
        return signal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntegerSignal createIntegerSignal() {
        IntegerSignalImpl integerSignal = new IntegerSignalImpl();
        return integerSignal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StateFlag createStateFlagFromString(EDataType eDataType, String initialValue) {
        StateFlag result = StateFlag.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertStateFlagToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ssmPackage getssmPackage() {
        return (ssmPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ssmPackage getPackage() {
        return ssmPackage.eINSTANCE;
    }

} //ssmFactoryImpl
