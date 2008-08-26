/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.gems.mealy.emf.mealymachine;

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
 * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MealyMachineFactory
 * @model kind="package"
 * @generated
 */
public interface MealyMachinePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "mealymachine";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.informatik.uni-kiel.de/rtsys/gems/mealy";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "mealymachine";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MealyMachinePackage eINSTANCE = edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl.init();

  /**
   * The meta object id for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MementoValueImpl <em>Memento Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MementoValueImpl
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getMementoValue()
   * @generated
   */
  int MEMENTO_VALUE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMENTO_VALUE__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMENTO_VALUE__VALUE = 1;

  /**
   * The number of structural features of the '<em>Memento Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMENTO_VALUE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MementoImpl <em>Memento</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MementoImpl
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getMemento()
   * @generated
   */
  int MEMENTO = 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMENTO__ID = 0;

  /**
   * The feature id for the '<em><b>Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMENTO__DATA = 1;

  /**
   * The number of structural features of the '<em>Memento</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMENTO_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.SubtypeImpl <em>Subtype</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.SubtypeImpl
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getSubtype()
   * @generated
   */
  int SUBTYPE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTYPE__NAME = 0;

  /**
   * The feature id for the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTYPE__BASE = 1;

  /**
   * The feature id for the '<em><b>Instances</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTYPE__INSTANCES = 2;

  /**
   * The feature id for the '<em><b>Links</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTYPE__LINKS = 3;

  /**
   * The number of structural features of the '<em>Subtype</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTYPE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.SubtypeLinkImpl <em>Subtype Link</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.SubtypeLinkImpl
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getSubtypeLink()
   * @generated
   */
  int SUBTYPE_LINK = 3;

  /**
   * The feature id for the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTYPE_LINK__BASE = 0;

  /**
   * The feature id for the '<em><b>Instance</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTYPE_LINK__INSTANCE = 1;

  /**
   * The number of structural features of the '<em>Subtype Link</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTYPE_LINK_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.ModelObjectImpl <em>Model Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.ModelObjectImpl
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getModelObject()
   * @generated
   */
  int MODEL_OBJECT = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_OBJECT__NAME = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_OBJECT__ID = 1;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_OBJECT__X = 2;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_OBJECT__Y = 3;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_OBJECT__WIDTH = 4;

  /**
   * The feature id for the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_OBJECT__HEIGHT = 5;

  /**
   * The feature id for the '<em><b>Expanded Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_OBJECT__EXPANDED_WIDTH = 6;

  /**
   * The feature id for the '<em><b>Expanded Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_OBJECT__EXPANDED_HEIGHT = 7;

  /**
   * The feature id for the '<em><b>Expanded</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_OBJECT__EXPANDED = 8;

  /**
   * The feature id for the '<em><b>Subtype</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_OBJECT__SUBTYPE = 9;

  /**
   * The feature id for the '<em><b>Visible</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_OBJECT__VISIBLE = 10;

  /**
   * The feature id for the '<em><b>Model Link Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_OBJECT__MODEL_LINK_TARGET = 11;

  /**
   * The feature id for the '<em><b>Annotation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_OBJECT__ANNOTATION = 12;

  /**
   * The number of structural features of the '<em>Model Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_OBJECT_FEATURE_COUNT = 13;

  /**
   * The meta object id for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachineImpl <em>Mealy Machine</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachineImpl
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getMealyMachine()
   * @generated
   */
  int MEALY_MACHINE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEALY_MACHINE__NAME = MODEL_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEALY_MACHINE__ID = MODEL_OBJECT__ID;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEALY_MACHINE__X = MODEL_OBJECT__X;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEALY_MACHINE__Y = MODEL_OBJECT__Y;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEALY_MACHINE__WIDTH = MODEL_OBJECT__WIDTH;

  /**
   * The feature id for the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEALY_MACHINE__HEIGHT = MODEL_OBJECT__HEIGHT;

  /**
   * The feature id for the '<em><b>Expanded Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEALY_MACHINE__EXPANDED_WIDTH = MODEL_OBJECT__EXPANDED_WIDTH;

  /**
   * The feature id for the '<em><b>Expanded Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEALY_MACHINE__EXPANDED_HEIGHT = MODEL_OBJECT__EXPANDED_HEIGHT;

  /**
   * The feature id for the '<em><b>Expanded</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEALY_MACHINE__EXPANDED = MODEL_OBJECT__EXPANDED;

  /**
   * The feature id for the '<em><b>Subtype</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEALY_MACHINE__SUBTYPE = MODEL_OBJECT__SUBTYPE;

  /**
   * The feature id for the '<em><b>Visible</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEALY_MACHINE__VISIBLE = MODEL_OBJECT__VISIBLE;

  /**
   * The feature id for the '<em><b>Model Link Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEALY_MACHINE__MODEL_LINK_TARGET = MODEL_OBJECT__MODEL_LINK_TARGET;

  /**
   * The feature id for the '<em><b>Annotation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEALY_MACHINE__ANNOTATION = MODEL_OBJECT__ANNOTATION;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEALY_MACHINE__STATES = MODEL_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Mealy Machine</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEALY_MACHINE_FEATURE_COUNT = MODEL_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.StateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.StateImpl
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getState()
   * @generated
   */
  int STATE = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__NAME = MODEL_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__ID = MODEL_OBJECT__ID;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__X = MODEL_OBJECT__X;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__Y = MODEL_OBJECT__Y;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__WIDTH = MODEL_OBJECT__WIDTH;

  /**
   * The feature id for the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__HEIGHT = MODEL_OBJECT__HEIGHT;

  /**
   * The feature id for the '<em><b>Expanded Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__EXPANDED_WIDTH = MODEL_OBJECT__EXPANDED_WIDTH;

  /**
   * The feature id for the '<em><b>Expanded Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__EXPANDED_HEIGHT = MODEL_OBJECT__EXPANDED_HEIGHT;

  /**
   * The feature id for the '<em><b>Expanded</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__EXPANDED = MODEL_OBJECT__EXPANDED;

  /**
   * The feature id for the '<em><b>Subtype</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__SUBTYPE = MODEL_OBJECT__SUBTYPE;

  /**
   * The feature id for the '<em><b>Visible</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__VISIBLE = MODEL_OBJECT__VISIBLE;

  /**
   * The feature id for the '<em><b>Model Link Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__MODEL_LINK_TARGET = MODEL_OBJECT__MODEL_LINK_TARGET;

  /**
   * The feature id for the '<em><b>Annotation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__ANNOTATION = MODEL_OBJECT__ANNOTATION;

  /**
   * The feature id for the '<em><b>State Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__STATE_NAME = MODEL_OBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parent Machine</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__PARENT_MACHINE = MODEL_OBJECT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__OUTGOING_TRANSITIONS = MODEL_OBJECT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__INCOMING_TRANSITIONS = MODEL_OBJECT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FEATURE_COUNT = MODEL_OBJECT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.TransitionConnectionImpl <em>Transition Connection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.TransitionConnectionImpl
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getTransitionConnection()
   * @generated
   */
  int TRANSITION_CONNECTION = 7;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_CONNECTION__SOURCE = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_CONNECTION__TARGET = 1;

  /**
   * The feature id for the '<em><b>Action</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_CONNECTION__ACTION = 2;

  /**
   * The feature id for the '<em><b>Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_CONNECTION__CONDITION = 3;

  /**
   * The number of structural features of the '<em>Transition Connection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_CONNECTION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.RootImpl <em>Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.RootImpl
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getRoot()
   * @generated
   */
  int ROOT = 8;

  /**
   * The feature id for the '<em><b>Mementos</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT__MEMENTOS = 0;

  /**
   * The feature id for the '<em><b>Subtypes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT__SUBTYPES = 1;

  /**
   * The feature id for the '<em><b>Real Root</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT__REAL_ROOT = 2;

  /**
   * The feature id for the '<em><b>Mealy Machine</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT__MEALY_MACHINE = 3;

  /**
   * The feature id for the '<em><b>State</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT__STATE = 4;

  /**
   * The feature id for the '<em><b>Transition Connection</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT__TRANSITION_CONNECTION = 5;

  /**
   * The number of structural features of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_FEATURE_COUNT = 6;


  /**
   * Returns the meta object for class '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MementoValue <em>Memento Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Memento Value</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MementoValue
   * @generated
   */
  EClass getMementoValue();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MementoValue#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MementoValue#getName()
   * @see #getMementoValue()
   * @generated
   */
  EAttribute getMementoValue_Name();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MementoValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MementoValue#getValue()
   * @see #getMementoValue()
   * @generated
   */
  EAttribute getMementoValue_Value();

  /**
   * Returns the meta object for class '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Memento <em>Memento</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Memento</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Memento
   * @generated
   */
  EClass getMemento();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Memento#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Memento#getId()
   * @see #getMemento()
   * @generated
   */
  EAttribute getMemento_Id();

  /**
   * Returns the meta object for the containment reference list '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Memento#getData <em>Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Data</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Memento#getData()
   * @see #getMemento()
   * @generated
   */
  EReference getMemento_Data();

  /**
   * Returns the meta object for class '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype <em>Subtype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subtype</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype
   * @generated
   */
  EClass getSubtype();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype#getName()
   * @see #getSubtype()
   * @generated
   */
  EAttribute getSubtype_Name();

  /**
   * Returns the meta object for the reference '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Base</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype#getBase()
   * @see #getSubtype()
   * @generated
   */
  EReference getSubtype_Base();

  /**
   * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype#getInstances <em>Instances</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Instances</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype#getInstances()
   * @see #getSubtype()
   * @generated
   */
  EReference getSubtype_Instances();

  /**
   * Returns the meta object for the containment reference list '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype#getLinks <em>Links</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Links</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Subtype#getLinks()
   * @see #getSubtype()
   * @generated
   */
  EReference getSubtype_Links();

  /**
   * Returns the meta object for class '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.SubtypeLink <em>Subtype Link</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subtype Link</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.SubtypeLink
   * @generated
   */
  EClass getSubtypeLink();

  /**
   * Returns the meta object for the reference '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.SubtypeLink#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Base</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.SubtypeLink#getBase()
   * @see #getSubtypeLink()
   * @generated
   */
  EReference getSubtypeLink_Base();

  /**
   * Returns the meta object for the reference '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.SubtypeLink#getInstance <em>Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Instance</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.SubtypeLink#getInstance()
   * @see #getSubtypeLink()
   * @generated
   */
  EReference getSubtypeLink_Instance();

  /**
   * Returns the meta object for class '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject <em>Model Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Object</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject
   * @generated
   */
  EClass getModelObject();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getName()
   * @see #getModelObject()
   * @generated
   */
  EAttribute getModelObject_Name();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getId()
   * @see #getModelObject()
   * @generated
   */
  EAttribute getModelObject_Id();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getX <em>X</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>X</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getX()
   * @see #getModelObject()
   * @generated
   */
  EAttribute getModelObject_X();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getY <em>Y</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Y</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getY()
   * @see #getModelObject()
   * @generated
   */
  EAttribute getModelObject_Y();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getWidth <em>Width</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Width</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getWidth()
   * @see #getModelObject()
   * @generated
   */
  EAttribute getModelObject_Width();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getHeight <em>Height</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Height</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getHeight()
   * @see #getModelObject()
   * @generated
   */
  EAttribute getModelObject_Height();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getExpandedWidth <em>Expanded Width</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expanded Width</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getExpandedWidth()
   * @see #getModelObject()
   * @generated
   */
  EAttribute getModelObject_ExpandedWidth();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getExpandedHeight <em>Expanded Height</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expanded Height</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getExpandedHeight()
   * @see #getModelObject()
   * @generated
   */
  EAttribute getModelObject_ExpandedHeight();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#isExpanded <em>Expanded</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expanded</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#isExpanded()
   * @see #getModelObject()
   * @generated
   */
  EAttribute getModelObject_Expanded();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#isSubtype <em>Subtype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Subtype</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#isSubtype()
   * @see #getModelObject()
   * @generated
   */
  EAttribute getModelObject_Subtype();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#isVisible <em>Visible</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visible</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#isVisible()
   * @see #getModelObject()
   * @generated
   */
  EAttribute getModelObject_Visible();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getModelLinkTarget <em>Model Link Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Model Link Target</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getModelLinkTarget()
   * @see #getModelObject()
   * @generated
   */
  EAttribute getModelObject_ModelLinkTarget();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getAnnotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Annotation</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.ModelObject#getAnnotation()
   * @see #getModelObject()
   * @generated
   */
  EAttribute getModelObject_Annotation();

  /**
   * Returns the meta object for class '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MealyMachine <em>Mealy Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mealy Machine</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MealyMachine
   * @generated
   */
  EClass getMealyMachine();

  /**
   * Returns the meta object for the containment reference list '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MealyMachine#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MealyMachine#getStates()
   * @see #getMealyMachine()
   * @generated
   */
  EReference getMealyMachine_States();

  /**
   * Returns the meta object for class '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.State
   * @generated
   */
  EClass getState();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.State#getStateName <em>State Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>State Name</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.State#getStateName()
   * @see #getState()
   * @generated
   */
  EAttribute getState_StateName();

  /**
   * Returns the meta object for the reference '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.State#getParentMachine <em>Parent Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parent Machine</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.State#getParentMachine()
   * @see #getState()
   * @generated
   */
  EReference getState_ParentMachine();

  /**
   * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.State#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Outgoing Transitions</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.State#getOutgoingTransitions()
   * @see #getState()
   * @generated
   */
  EReference getState_OutgoingTransitions();

  /**
   * Returns the meta object for the reference list '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.State#getIncomingTransitions <em>Incoming Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Incoming Transitions</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.State#getIncomingTransitions()
   * @see #getState()
   * @generated
   */
  EReference getState_IncomingTransitions();

  /**
   * Returns the meta object for class '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.TransitionConnection <em>Transition Connection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Connection</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.TransitionConnection
   * @generated
   */
  EClass getTransitionConnection();

  /**
   * Returns the meta object for the reference '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.TransitionConnection#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.TransitionConnection#getSource()
   * @see #getTransitionConnection()
   * @generated
   */
  EReference getTransitionConnection_Source();

  /**
   * Returns the meta object for the reference '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.TransitionConnection#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.TransitionConnection#getTarget()
   * @see #getTransitionConnection()
   * @generated
   */
  EReference getTransitionConnection_Target();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.TransitionConnection#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Action</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.TransitionConnection#getAction()
   * @see #getTransitionConnection()
   * @generated
   */
  EAttribute getTransitionConnection_Action();

  /**
   * Returns the meta object for the attribute '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.TransitionConnection#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Condition</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.TransitionConnection#getCondition()
   * @see #getTransitionConnection()
   * @generated
   */
  EAttribute getTransitionConnection_Condition();

  /**
   * Returns the meta object for class '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Root <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Root
   * @generated
   */
  EClass getRoot();

  /**
   * Returns the meta object for the containment reference list '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Root#getMementos <em>Mementos</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mementos</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Root#getMementos()
   * @see #getRoot()
   * @generated
   */
  EReference getRoot_Mementos();

  /**
   * Returns the meta object for the containment reference list '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Root#getSubtypes <em>Subtypes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Subtypes</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Root#getSubtypes()
   * @see #getRoot()
   * @generated
   */
  EReference getRoot_Subtypes();

  /**
   * Returns the meta object for the containment reference '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Root#getRealRoot <em>Real Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Real Root</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Root#getRealRoot()
   * @see #getRoot()
   * @generated
   */
  EReference getRoot_RealRoot();

  /**
   * Returns the meta object for the containment reference list '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Root#getMealyMachine <em>Mealy Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mealy Machine</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Root#getMealyMachine()
   * @see #getRoot()
   * @generated
   */
  EReference getRoot_MealyMachine();

  /**
   * Returns the meta object for the containment reference list '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Root#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Root#getState()
   * @see #getRoot()
   * @generated
   */
  EReference getRoot_State();

  /**
   * Returns the meta object for the containment reference list '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Root#getTransitionConnection <em>Transition Connection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transition Connection</em>'.
   * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.Root#getTransitionConnection()
   * @see #getRoot()
   * @generated
   */
  EReference getRoot_TransitionConnection();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MealyMachineFactory getMealyMachineFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MementoValueImpl <em>Memento Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MementoValueImpl
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getMementoValue()
     * @generated
     */
    EClass MEMENTO_VALUE = eINSTANCE.getMementoValue();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MEMENTO_VALUE__NAME = eINSTANCE.getMementoValue_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MEMENTO_VALUE__VALUE = eINSTANCE.getMementoValue_Value();

    /**
     * The meta object literal for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MementoImpl <em>Memento</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MementoImpl
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getMemento()
     * @generated
     */
    EClass MEMENTO = eINSTANCE.getMemento();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MEMENTO__ID = eINSTANCE.getMemento_Id();

    /**
     * The meta object literal for the '<em><b>Data</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEMENTO__DATA = eINSTANCE.getMemento_Data();

    /**
     * The meta object literal for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.SubtypeImpl <em>Subtype</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.SubtypeImpl
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getSubtype()
     * @generated
     */
    EClass SUBTYPE = eINSTANCE.getSubtype();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUBTYPE__NAME = eINSTANCE.getSubtype_Name();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBTYPE__BASE = eINSTANCE.getSubtype_Base();

    /**
     * The meta object literal for the '<em><b>Instances</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBTYPE__INSTANCES = eINSTANCE.getSubtype_Instances();

    /**
     * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBTYPE__LINKS = eINSTANCE.getSubtype_Links();

    /**
     * The meta object literal for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.SubtypeLinkImpl <em>Subtype Link</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.SubtypeLinkImpl
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getSubtypeLink()
     * @generated
     */
    EClass SUBTYPE_LINK = eINSTANCE.getSubtypeLink();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBTYPE_LINK__BASE = eINSTANCE.getSubtypeLink_Base();

    /**
     * The meta object literal for the '<em><b>Instance</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBTYPE_LINK__INSTANCE = eINSTANCE.getSubtypeLink_Instance();

    /**
     * The meta object literal for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.ModelObjectImpl <em>Model Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.ModelObjectImpl
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getModelObject()
     * @generated
     */
    EClass MODEL_OBJECT = eINSTANCE.getModelObject();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_OBJECT__NAME = eINSTANCE.getModelObject_Name();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_OBJECT__ID = eINSTANCE.getModelObject_Id();

    /**
     * The meta object literal for the '<em><b>X</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_OBJECT__X = eINSTANCE.getModelObject_X();

    /**
     * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_OBJECT__Y = eINSTANCE.getModelObject_Y();

    /**
     * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_OBJECT__WIDTH = eINSTANCE.getModelObject_Width();

    /**
     * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_OBJECT__HEIGHT = eINSTANCE.getModelObject_Height();

    /**
     * The meta object literal for the '<em><b>Expanded Width</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_OBJECT__EXPANDED_WIDTH = eINSTANCE.getModelObject_ExpandedWidth();

    /**
     * The meta object literal for the '<em><b>Expanded Height</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_OBJECT__EXPANDED_HEIGHT = eINSTANCE.getModelObject_ExpandedHeight();

    /**
     * The meta object literal for the '<em><b>Expanded</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_OBJECT__EXPANDED = eINSTANCE.getModelObject_Expanded();

    /**
     * The meta object literal for the '<em><b>Subtype</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_OBJECT__SUBTYPE = eINSTANCE.getModelObject_Subtype();

    /**
     * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_OBJECT__VISIBLE = eINSTANCE.getModelObject_Visible();

    /**
     * The meta object literal for the '<em><b>Model Link Target</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_OBJECT__MODEL_LINK_TARGET = eINSTANCE.getModelObject_ModelLinkTarget();

    /**
     * The meta object literal for the '<em><b>Annotation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_OBJECT__ANNOTATION = eINSTANCE.getModelObject_Annotation();

    /**
     * The meta object literal for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachineImpl <em>Mealy Machine</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachineImpl
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getMealyMachine()
     * @generated
     */
    EClass MEALY_MACHINE = eINSTANCE.getMealyMachine();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEALY_MACHINE__STATES = eINSTANCE.getMealyMachine_States();

    /**
     * The meta object literal for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.StateImpl
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getState()
     * @generated
     */
    EClass STATE = eINSTANCE.getState();

    /**
     * The meta object literal for the '<em><b>State Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__STATE_NAME = eINSTANCE.getState_StateName();

    /**
     * The meta object literal for the '<em><b>Parent Machine</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__PARENT_MACHINE = eINSTANCE.getState_ParentMachine();

    /**
     * The meta object literal for the '<em><b>Outgoing Transitions</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__OUTGOING_TRANSITIONS = eINSTANCE.getState_OutgoingTransitions();

    /**
     * The meta object literal for the '<em><b>Incoming Transitions</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__INCOMING_TRANSITIONS = eINSTANCE.getState_IncomingTransitions();

    /**
     * The meta object literal for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.TransitionConnectionImpl <em>Transition Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.TransitionConnectionImpl
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getTransitionConnection()
     * @generated
     */
    EClass TRANSITION_CONNECTION = eINSTANCE.getTransitionConnection();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_CONNECTION__SOURCE = eINSTANCE.getTransitionConnection_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_CONNECTION__TARGET = eINSTANCE.getTransitionConnection_Target();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION_CONNECTION__ACTION = eINSTANCE.getTransitionConnection_Action();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION_CONNECTION__CONDITION = eINSTANCE.getTransitionConnection_Condition();

    /**
     * The meta object literal for the '{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.RootImpl <em>Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.RootImpl
     * @see edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl#getRoot()
     * @generated
     */
    EClass ROOT = eINSTANCE.getRoot();

    /**
     * The meta object literal for the '<em><b>Mementos</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOT__MEMENTOS = eINSTANCE.getRoot_Mementos();

    /**
     * The meta object literal for the '<em><b>Subtypes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOT__SUBTYPES = eINSTANCE.getRoot_Subtypes();

    /**
     * The meta object literal for the '<em><b>Real Root</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOT__REAL_ROOT = eINSTANCE.getRoot_RealRoot();

    /**
     * The meta object literal for the '<em><b>Mealy Machine</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOT__MEALY_MACHINE = eINSTANCE.getRoot_MealyMachine();

    /**
     * The meta object literal for the '<em><b>State</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOT__STATE = eINSTANCE.getRoot_State();

    /**
     * The meta object literal for the '<em><b>Transition Connection</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOT__TRANSITION_CONNECTION = eINSTANCE.getRoot_TransitionConnection();

  }

} //MealyMachinePackage
