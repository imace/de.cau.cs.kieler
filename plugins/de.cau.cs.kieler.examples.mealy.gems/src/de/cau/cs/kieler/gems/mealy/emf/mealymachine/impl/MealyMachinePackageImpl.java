/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl;

import de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachine;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachineFactory;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.Memento;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.MementoValue;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.ModelObject;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.Root;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.State;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.Subtype;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.SubtypeLink;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection;

import org.eclipse.emf.ecore.EAttribute;
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
public class MealyMachinePackageImpl extends EPackageImpl implements MealyMachinePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mementoValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mementoEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subtypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subtypeLinkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mealyMachineEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionConnectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rootEClass = null;

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
   * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private MealyMachinePackageImpl()
  {
    super(eNS_URI, MealyMachineFactory.eINSTANCE);
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
  public static MealyMachinePackage init()
  {
    if (isInited) return (MealyMachinePackage)EPackage.Registry.INSTANCE.getEPackage(MealyMachinePackage.eNS_URI);

    // Obtain or create and register package
    MealyMachinePackageImpl theMealyMachinePackage = (MealyMachinePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof MealyMachinePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new MealyMachinePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theMealyMachinePackage.createPackageContents();

    // Initialize created meta-data
    theMealyMachinePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMealyMachinePackage.freeze();

    return theMealyMachinePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMementoValue()
  {
    return mementoValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMementoValue_Name()
  {
    return (EAttribute)mementoValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMementoValue_Value()
  {
    return (EAttribute)mementoValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMemento()
  {
    return mementoEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMemento_Id()
  {
    return (EAttribute)mementoEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMemento_Data()
  {
    return (EReference)mementoEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubtype()
  {
    return subtypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSubtype_Name()
  {
    return (EAttribute)subtypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubtype_Base()
  {
    return (EReference)subtypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubtype_Instances()
  {
    return (EReference)subtypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubtype_Links()
  {
    return (EReference)subtypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubtypeLink()
  {
    return subtypeLinkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubtypeLink_Base()
  {
    return (EReference)subtypeLinkEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubtypeLink_Instance()
  {
    return (EReference)subtypeLinkEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModelObject()
  {
    return modelObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelObject_Name()
  {
    return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelObject_Id()
  {
    return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelObject_X()
  {
    return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelObject_Y()
  {
    return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelObject_Width()
  {
    return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelObject_Height()
  {
    return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelObject_ExpandedWidth()
  {
    return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelObject_ExpandedHeight()
  {
    return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelObject_Expanded()
  {
    return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelObject_Subtype()
  {
    return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelObject_Visible()
  {
    return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelObject_ModelLinkTarget()
  {
    return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelObject_Annotation()
  {
    return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMealyMachine()
  {
    return mealyMachineEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMealyMachine_States()
  {
    return (EReference)mealyMachineEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getState()
  {
    return stateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getState_StateName()
  {
    return (EAttribute)stateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState_ParentMachine()
  {
    return (EReference)stateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState_OutgoingTransitions()
  {
    return (EReference)stateEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState_IncomingTransitions()
  {
    return (EReference)stateEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionConnection()
  {
    return transitionConnectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionConnection_Source()
  {
    return (EReference)transitionConnectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionConnection_Target()
  {
    return (EReference)transitionConnectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransitionConnection_Action()
  {
    return (EAttribute)transitionConnectionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransitionConnection_Condition()
  {
    return (EAttribute)transitionConnectionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoot()
  {
    return rootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoot_Mementos()
  {
    return (EReference)rootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoot_Subtypes()
  {
    return (EReference)rootEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoot_RealRoot()
  {
    return (EReference)rootEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoot_MealyMachine()
  {
    return (EReference)rootEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoot_State()
  {
    return (EReference)rootEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoot_TransitionConnection()
  {
    return (EReference)rootEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MealyMachineFactory getMealyMachineFactory()
  {
    return (MealyMachineFactory)getEFactoryInstance();
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
    mementoValueEClass = createEClass(MEMENTO_VALUE);
    createEAttribute(mementoValueEClass, MEMENTO_VALUE__NAME);
    createEAttribute(mementoValueEClass, MEMENTO_VALUE__VALUE);

    mementoEClass = createEClass(MEMENTO);
    createEAttribute(mementoEClass, MEMENTO__ID);
    createEReference(mementoEClass, MEMENTO__DATA);

    subtypeEClass = createEClass(SUBTYPE);
    createEAttribute(subtypeEClass, SUBTYPE__NAME);
    createEReference(subtypeEClass, SUBTYPE__BASE);
    createEReference(subtypeEClass, SUBTYPE__INSTANCES);
    createEReference(subtypeEClass, SUBTYPE__LINKS);

    subtypeLinkEClass = createEClass(SUBTYPE_LINK);
    createEReference(subtypeLinkEClass, SUBTYPE_LINK__BASE);
    createEReference(subtypeLinkEClass, SUBTYPE_LINK__INSTANCE);

    modelObjectEClass = createEClass(MODEL_OBJECT);
    createEAttribute(modelObjectEClass, MODEL_OBJECT__NAME);
    createEAttribute(modelObjectEClass, MODEL_OBJECT__ID);
    createEAttribute(modelObjectEClass, MODEL_OBJECT__X);
    createEAttribute(modelObjectEClass, MODEL_OBJECT__Y);
    createEAttribute(modelObjectEClass, MODEL_OBJECT__WIDTH);
    createEAttribute(modelObjectEClass, MODEL_OBJECT__HEIGHT);
    createEAttribute(modelObjectEClass, MODEL_OBJECT__EXPANDED_WIDTH);
    createEAttribute(modelObjectEClass, MODEL_OBJECT__EXPANDED_HEIGHT);
    createEAttribute(modelObjectEClass, MODEL_OBJECT__EXPANDED);
    createEAttribute(modelObjectEClass, MODEL_OBJECT__SUBTYPE);
    createEAttribute(modelObjectEClass, MODEL_OBJECT__VISIBLE);
    createEAttribute(modelObjectEClass, MODEL_OBJECT__MODEL_LINK_TARGET);
    createEAttribute(modelObjectEClass, MODEL_OBJECT__ANNOTATION);

    mealyMachineEClass = createEClass(MEALY_MACHINE);
    createEReference(mealyMachineEClass, MEALY_MACHINE__STATES);

    stateEClass = createEClass(STATE);
    createEAttribute(stateEClass, STATE__STATE_NAME);
    createEReference(stateEClass, STATE__PARENT_MACHINE);
    createEReference(stateEClass, STATE__OUTGOING_TRANSITIONS);
    createEReference(stateEClass, STATE__INCOMING_TRANSITIONS);

    transitionConnectionEClass = createEClass(TRANSITION_CONNECTION);
    createEReference(transitionConnectionEClass, TRANSITION_CONNECTION__SOURCE);
    createEReference(transitionConnectionEClass, TRANSITION_CONNECTION__TARGET);
    createEAttribute(transitionConnectionEClass, TRANSITION_CONNECTION__ACTION);
    createEAttribute(transitionConnectionEClass, TRANSITION_CONNECTION__CONDITION);

    rootEClass = createEClass(ROOT);
    createEReference(rootEClass, ROOT__MEMENTOS);
    createEReference(rootEClass, ROOT__SUBTYPES);
    createEReference(rootEClass, ROOT__REAL_ROOT);
    createEReference(rootEClass, ROOT__MEALY_MACHINE);
    createEReference(rootEClass, ROOT__STATE);
    createEReference(rootEClass, ROOT__TRANSITION_CONNECTION);
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

    // Add supertypes to classes
    mealyMachineEClass.getESuperTypes().add(this.getModelObject());
    stateEClass.getESuperTypes().add(this.getModelObject());

    // Initialize classes and features; add operations and parameters
    initEClass(mementoValueEClass, MementoValue.class, "MementoValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMementoValue_Name(), ecorePackage.getEString(), "name", "0", 0, 1, MementoValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMementoValue_Value(), ecorePackage.getEString(), "value", "0", 0, 1, MementoValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mementoEClass, Memento.class, "Memento", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMemento_Id(), ecorePackage.getEString(), "id", "0", 0, 1, Memento.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMemento_Data(), this.getMementoValue(), null, "data", null, 0, 2000, Memento.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subtypeEClass, Subtype.class, "Subtype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSubtype_Name(), ecorePackage.getEString(), "name", "AnonymousSubtype", 0, 1, Subtype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubtype_Base(), this.getModelObject(), null, "base", null, 0, 1, Subtype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubtype_Instances(), this.getModelObject(), null, "instances", null, 0, 2000, Subtype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubtype_Links(), this.getSubtypeLink(), null, "links", null, 0, 20000, Subtype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subtypeLinkEClass, SubtypeLink.class, "SubtypeLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSubtypeLink_Base(), this.getModelObject(), null, "base", null, 0, 1, SubtypeLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubtypeLink_Instance(), this.getModelObject(), null, "instance", null, 0, 1, SubtypeLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modelObjectEClass, ModelObject.class, "ModelObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModelObject_Name(), ecorePackage.getEString(), "Name", "0", 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModelObject_Id(), ecorePackage.getEString(), "Id", "0", 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModelObject_X(), ecorePackage.getEInt(), "X", "0", 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModelObject_Y(), ecorePackage.getEInt(), "Y", "0", 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModelObject_Width(), ecorePackage.getEInt(), "Width", "100", 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModelObject_Height(), ecorePackage.getEInt(), "Height", "100", 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModelObject_ExpandedWidth(), ecorePackage.getEInt(), "ExpandedWidth", "200", 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModelObject_ExpandedHeight(), ecorePackage.getEInt(), "ExpandedHeight", "200", 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModelObject_Expanded(), ecorePackage.getEBoolean(), "Expanded", "false", 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModelObject_Subtype(), ecorePackage.getEBoolean(), "Subtype", "false", 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModelObject_Visible(), ecorePackage.getEBoolean(), "Visible", "true", 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModelObject_ModelLinkTarget(), ecorePackage.getEString(), "ModelLinkTarget", "", 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModelObject_Annotation(), ecorePackage.getEString(), "Annotation", "", 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mealyMachineEClass, MealyMachine.class, "MealyMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMealyMachine_States(), this.getState(), null, "States", null, 0, 2000, MealyMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getState_StateName(), ecorePackage.getEString(), "StateName", "0", 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_ParentMachine(), this.getMealyMachine(), null, "ParentMachine", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_OutgoingTransitions(), this.getTransitionConnection(), null, "OutgoingTransitions", null, 0, 2147483647, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_IncomingTransitions(), this.getTransitionConnection(), null, "IncomingTransitions", null, 0, 2147483647, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionConnectionEClass, TransitionConnection.class, "TransitionConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransitionConnection_Source(), this.getState(), null, "Source", null, 0, 1, TransitionConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionConnection_Target(), this.getState(), null, "Target", null, 0, 1, TransitionConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransitionConnection_Action(), ecorePackage.getEString(), "Action", "0", 0, 1, TransitionConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransitionConnection_Condition(), ecorePackage.getEString(), "Condition", "0", 0, 1, TransitionConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRoot_Mementos(), this.getMemento(), null, "mementos", null, 0, 2000, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoot_Subtypes(), this.getSubtype(), null, "subtypes", null, 0, 2000, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoot_RealRoot(), this.getMealyMachine(), null, "RealRoot", null, 0, 1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoot_MealyMachine(), this.getMealyMachine(), null, "MealyMachine", null, 0, 2000, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoot_State(), this.getState(), null, "State", null, 0, 2000, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoot_TransitionConnection(), this.getTransitionConnection(), null, "TransitionConnection", null, 0, 2000, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //MealyMachinePackageImpl
