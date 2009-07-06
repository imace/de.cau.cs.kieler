/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl;

import de.cau.cs.kieler.gems.mealy.emf.mealymachine.*;

import org.eclipse.emf.ecore.EClass;
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
public class MealyMachineFactoryImpl extends EFactoryImpl implements MealyMachineFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MealyMachineFactory init()
  {
    try
    {
      MealyMachineFactory theMealyMachineFactory = (MealyMachineFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.informatik.uni-kiel.de/rtsys/gems/mealy"); 
      if (theMealyMachineFactory != null)
      {
        return theMealyMachineFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MealyMachineFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MealyMachineFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case MealyMachinePackage.MEMENTO_VALUE: return createMementoValue();
      case MealyMachinePackage.MEMENTO: return createMemento();
      case MealyMachinePackage.SUBTYPE: return createSubtype();
      case MealyMachinePackage.SUBTYPE_LINK: return createSubtypeLink();
      case MealyMachinePackage.MODEL_OBJECT: return createModelObject();
      case MealyMachinePackage.MEALY_MACHINE: return createMealyMachine();
      case MealyMachinePackage.STATE: return createState();
      case MealyMachinePackage.TRANSITION_CONNECTION: return createTransitionConnection();
      case MealyMachinePackage.ROOT: return createRoot();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MementoValue createMementoValue()
  {
    MementoValueImpl mementoValue = new MementoValueImpl();
    return mementoValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Memento createMemento()
  {
    MementoImpl memento = new MementoImpl();
    return memento;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Subtype createSubtype()
  {
    SubtypeImpl subtype = new SubtypeImpl();
    return subtype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubtypeLink createSubtypeLink()
  {
    SubtypeLinkImpl subtypeLink = new SubtypeLinkImpl();
    return subtypeLink;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelObject createModelObject()
  {
    ModelObjectImpl modelObject = new ModelObjectImpl();
    return modelObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MealyMachine createMealyMachine()
  {
    MealyMachineImpl mealyMachine = new MealyMachineImpl();
    return mealyMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State createState()
  {
    StateImpl state = new StateImpl();
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionConnection createTransitionConnection()
  {
    TransitionConnectionImpl transitionConnection = new TransitionConnectionImpl();
    return transitionConnection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Root createRoot()
  {
    RootImpl root = new RootImpl();
    return root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MealyMachinePackage getMealyMachinePackage()
  {
    return (MealyMachinePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  public static MealyMachinePackage getPackage()
  {
    return MealyMachinePackage.eINSTANCE;
  }

} //MealyMachineFactoryImpl
