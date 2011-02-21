/**
 * <copyright>
 * </copyright>
 *
 */
package de.cau.cs.kieler.synccharts.text.interfaces.interfaces.impl;

import de.cau.cs.kieler.core.kexpressions.KExpressionsPackage;

import de.cau.cs.kieler.synccharts.SyncchartsPackage;

import de.cau.cs.kieler.synccharts.text.interfaces.interfaces.InOutputSignals;
import de.cau.cs.kieler.synccharts.text.interfaces.interfaces.InputSignals;
import de.cau.cs.kieler.synccharts.text.interfaces.interfaces.InterfacesFactory;
import de.cau.cs.kieler.synccharts.text.interfaces.interfaces.InterfacesPackage;
import de.cau.cs.kieler.synccharts.text.interfaces.interfaces.OutputSignals;
import de.cau.cs.kieler.synccharts.text.interfaces.interfaces.RegionSignalDec;
import de.cau.cs.kieler.synccharts.text.interfaces.interfaces.Signals;
import de.cau.cs.kieler.synccharts.text.interfaces.interfaces.StateExtend;
import de.cau.cs.kieler.synccharts.text.interfaces.interfaces.Variables;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InterfacesPackageImpl extends EPackageImpl implements InterfacesPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateExtendEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass regionSignalDecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variablesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signalsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inputSignalsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass outputSignalsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inOutputSignalsEClass = null;

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
   * @see de.cau.cs.kieler.synccharts.text.interfaces.interfaces.InterfacesPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private InterfacesPackageImpl()
  {
    super(eNS_URI, InterfacesFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link InterfacesPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static InterfacesPackage init()
  {
    if (isInited) return (InterfacesPackage)EPackage.Registry.INSTANCE.getEPackage(InterfacesPackage.eNS_URI);

    // Obtain or create and register package
    InterfacesPackageImpl theInterfacesPackage = (InterfacesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InterfacesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InterfacesPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    SyncchartsPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theInterfacesPackage.createPackageContents();

    // Initialize created meta-data
    theInterfacesPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theInterfacesPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(InterfacesPackage.eNS_URI, theInterfacesPackage);
    return theInterfacesPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateExtend()
  {
    return stateExtendEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateExtend_Regions()
  {
    return (EReference)stateExtendEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateExtend_InOutputSignals()
  {
    return (EReference)stateExtendEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateExtend_OutputSignals()
  {
    return (EReference)stateExtendEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateExtend_InputSignals()
  {
    return (EReference)stateExtendEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateExtend_Signals()
  {
    return (EReference)stateExtendEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateExtend_Variable()
  {
    return (EReference)stateExtendEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRegionSignalDec()
  {
    return regionSignalDecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRegionSignalDec_Region()
  {
    return (EReference)regionSignalDecEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRegionSignalDec_Vars()
  {
    return (EReference)regionSignalDecEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRegionSignalDec_Signals()
  {
    return (EReference)regionSignalDecEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariables()
  {
    return variablesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariables_Vars()
  {
    return (EReference)variablesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSignals()
  {
    return signalsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSignals_Signals()
  {
    return (EReference)signalsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInputSignals()
  {
    return inputSignalsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInputSignals_Signals()
  {
    return (EReference)inputSignalsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOutputSignals()
  {
    return outputSignalsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutputSignals_Signals()
  {
    return (EReference)outputSignalsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInOutputSignals()
  {
    return inOutputSignalsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInOutputSignals_Signals()
  {
    return (EReference)inOutputSignalsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InterfacesFactory getInterfacesFactory()
  {
    return (InterfacesFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    stateExtendEClass = createEClass(STATE_EXTEND);
    createEReference(stateExtendEClass, STATE_EXTEND__REGIONS);
    createEReference(stateExtendEClass, STATE_EXTEND__IN_OUTPUT_SIGNALS);
    createEReference(stateExtendEClass, STATE_EXTEND__OUTPUT_SIGNALS);
    createEReference(stateExtendEClass, STATE_EXTEND__INPUT_SIGNALS);
    createEReference(stateExtendEClass, STATE_EXTEND__SIGNALS);
    createEReference(stateExtendEClass, STATE_EXTEND__VARIABLE);

    regionSignalDecEClass = createEClass(REGION_SIGNAL_DEC);
    createEReference(regionSignalDecEClass, REGION_SIGNAL_DEC__REGION);
    createEReference(regionSignalDecEClass, REGION_SIGNAL_DEC__VARS);
    createEReference(regionSignalDecEClass, REGION_SIGNAL_DEC__SIGNALS);

    variablesEClass = createEClass(VARIABLES);
    createEReference(variablesEClass, VARIABLES__VARS);

    signalsEClass = createEClass(SIGNALS);
    createEReference(signalsEClass, SIGNALS__SIGNALS);

    inputSignalsEClass = createEClass(INPUT_SIGNALS);
    createEReference(inputSignalsEClass, INPUT_SIGNALS__SIGNALS);

    outputSignalsEClass = createEClass(OUTPUT_SIGNALS);
    createEReference(outputSignalsEClass, OUTPUT_SIGNALS__SIGNALS);

    inOutputSignalsEClass = createEClass(IN_OUTPUT_SIGNALS);
    createEReference(inOutputSignalsEClass, IN_OUTPUT_SIGNALS__SIGNALS);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    SyncchartsPackage theSyncchartsPackage = (SyncchartsPackage)EPackage.Registry.INSTANCE.getEPackage(SyncchartsPackage.eNS_URI);
    KExpressionsPackage theKExpressionsPackage = (KExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(KExpressionsPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(stateExtendEClass, StateExtend.class, "StateExtend", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStateExtend_Regions(), this.getRegionSignalDec(), null, "regions", null, 0, -1, StateExtend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateExtend_InOutputSignals(), this.getInOutputSignals(), null, "inOutputSignals", null, 0, -1, StateExtend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateExtend_OutputSignals(), this.getOutputSignals(), null, "outputSignals", null, 0, -1, StateExtend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateExtend_InputSignals(), this.getInputSignals(), null, "inputSignals", null, 0, -1, StateExtend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateExtend_Signals(), this.getSignals(), null, "signals", null, 0, -1, StateExtend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateExtend_Variable(), this.getVariables(), null, "variable", null, 0, -1, StateExtend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(regionSignalDecEClass, RegionSignalDec.class, "RegionSignalDec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRegionSignalDec_Region(), theSyncchartsPackage.getRegion(), null, "region", null, 0, 1, RegionSignalDec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRegionSignalDec_Vars(), theKExpressionsPackage.getVariable(), null, "vars", null, 0, -1, RegionSignalDec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRegionSignalDec_Signals(), theKExpressionsPackage.getSignal(), null, "signals", null, 0, -1, RegionSignalDec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variablesEClass, Variables.class, "Variables", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVariables_Vars(), theKExpressionsPackage.getVariable(), null, "vars", null, 0, -1, Variables.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(signalsEClass, Signals.class, "Signals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSignals_Signals(), theKExpressionsPackage.getSignal(), null, "signals", null, 0, -1, Signals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inputSignalsEClass, InputSignals.class, "InputSignals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInputSignals_Signals(), theKExpressionsPackage.getSignal(), null, "signals", null, 0, -1, InputSignals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(outputSignalsEClass, OutputSignals.class, "OutputSignals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOutputSignals_Signals(), theKExpressionsPackage.getSignal(), null, "signals", null, 0, -1, OutputSignals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inOutputSignalsEClass, InOutputSignals.class, "InOutputSignals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInOutputSignals_Signals(), theKExpressionsPackage.getSignal(), null, "signals", null, 0, -1, InOutputSignals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //InterfacesPackageImpl
