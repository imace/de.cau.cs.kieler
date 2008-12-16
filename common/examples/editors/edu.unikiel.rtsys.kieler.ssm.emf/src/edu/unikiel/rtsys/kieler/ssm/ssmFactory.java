/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage
 * @generated
 */
public interface ssmFactory extends EFactory {
    /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    ssmFactory eINSTANCE = edu.unikiel.rtsys.kieler.ssm.impl.ssmFactoryImpl.init();

    /**
	 * Returns a new object of class '<em>Named</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named</em>'.
	 * @generated
	 */
    Named createNamed();

    /**
	 * Returns a new object of class '<em>Region</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Region</em>'.
	 * @generated
	 */
    Region createRegion();

    /**
	 * Returns a new object of class '<em>Simple State</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple State</em>'.
	 * @generated
	 */
    SimpleState createSimpleState();

    /**
	 * Returns a new object of class '<em>Pseudo State</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pseudo State</em>'.
	 * @generated
	 */
    PseudoState createPseudoState();

    /**
	 * Returns a new object of class '<em>Initial State</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Initial State</em>'.
	 * @generated
	 */
    InitialState createInitialState();

    /**
	 * Returns a new object of class '<em>Composite State</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite State</em>'.
	 * @generated
	 */
    CompositeState createCompositeState();

    /**
	 * Returns a new object of class '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition</em>'.
	 * @generated
	 */
    Transition createTransition();

    /**
	 * Returns a new object of class '<em>Transition Triggerable</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition Triggerable</em>'.
	 * @generated
	 */
    TransitionTriggerable createTransitionTriggerable();

    /**
	 * Returns a new object of class '<em>Transition Immediateable</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition Immediateable</em>'.
	 * @generated
	 */
    TransitionImmediateable createTransitionImmediateable();

    /**
	 * Returns a new object of class '<em>Initial Arc</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Initial Arc</em>'.
	 * @generated
	 */
    InitialArc createInitialArc();

    /**
	 * Returns a new object of class '<em>Conditional Transition</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Transition</em>'.
	 * @generated
	 */
    ConditionalTransition createConditionalTransition();

    /**
	 * Returns a new object of class '<em>Normal Termination</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Normal Termination</em>'.
	 * @generated
	 */
    NormalTermination createNormalTermination();

    /**
	 * Returns a new object of class '<em>Strong Abortion</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Strong Abortion</em>'.
	 * @generated
	 */
    StrongAbortion createStrongAbortion();

    /**
	 * Returns a new object of class '<em>Weak Abortion</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Weak Abortion</em>'.
	 * @generated
	 */
    WeakAbortion createWeakAbortion();

    /**
	 * Returns a new object of class '<em>Safe State Machine</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Safe State Machine</em>'.
	 * @generated
	 */
    SafeStateMachine createSafeStateMachine();

    /**
	 * Returns a new object of class '<em>Trigger</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trigger</em>'.
	 * @generated
	 */
    Trigger createTrigger();

    /**
	 * Returns a new object of class '<em>Action</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action</em>'.
	 * @generated
	 */
    Action createAction();

    /**
	 * Returns a new object of class '<em>On Action</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>On Action</em>'.
	 * @generated
	 */
    OnAction createOnAction();

    /**
	 * Returns a new object of class '<em>Signal</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Signal</em>'.
	 * @generated
	 */
    Signal createSignal();

    /**
	 * Returns a new object of class '<em>Integer Signal</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Signal</em>'.
	 * @generated
	 */
    IntegerSignal createIntegerSignal();

    /**
	 * Returns a new object of class '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition</em>'.
	 * @generated
	 */
	Condition createCondition();

				/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
    ssmPackage getssmPackage();

} //ssmFactory
