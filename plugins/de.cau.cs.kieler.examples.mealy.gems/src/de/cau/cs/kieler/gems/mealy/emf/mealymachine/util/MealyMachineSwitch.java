/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.gems.mealy.emf.mealymachine.util;

import de.cau.cs.kieler.gems.mealy.emf.mealymachine.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage
 * @generated
 */
public class MealyMachineSwitch
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MealyMachinePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MealyMachineSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = MealyMachinePackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public Object doSwitch(EObject theEObject)
  {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected Object doSwitch(EClass theEClass, EObject theEObject)
  {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch((EClass)eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected Object doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case MealyMachinePackage.MEMENTO_VALUE:
      {
        MementoValue mementoValue = (MementoValue)theEObject;
        Object result = caseMementoValue(mementoValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MealyMachinePackage.MEMENTO:
      {
        Memento memento = (Memento)theEObject;
        Object result = caseMemento(memento);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MealyMachinePackage.SUBTYPE:
      {
        Subtype subtype = (Subtype)theEObject;
        Object result = caseSubtype(subtype);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MealyMachinePackage.SUBTYPE_LINK:
      {
        SubtypeLink subtypeLink = (SubtypeLink)theEObject;
        Object result = caseSubtypeLink(subtypeLink);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MealyMachinePackage.MODEL_OBJECT:
      {
        ModelObject modelObject = (ModelObject)theEObject;
        Object result = caseModelObject(modelObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MealyMachinePackage.MEALY_MACHINE:
      {
        MealyMachine mealyMachine = (MealyMachine)theEObject;
        Object result = caseMealyMachine(mealyMachine);
        if (result == null) result = caseModelObject(mealyMachine);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MealyMachinePackage.STATE:
      {
        State state = (State)theEObject;
        Object result = caseState(state);
        if (result == null) result = caseModelObject(state);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MealyMachinePackage.TRANSITION_CONNECTION:
      {
        TransitionConnection transitionConnection = (TransitionConnection)theEObject;
        Object result = caseTransitionConnection(transitionConnection);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MealyMachinePackage.ROOT:
      {
        Root root = (Root)theEObject;
        Object result = caseRoot(root);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Memento Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Memento Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseMementoValue(MementoValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Memento</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Memento</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseMemento(Memento object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subtype</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subtype</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseSubtype(Subtype object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subtype Link</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subtype Link</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseSubtypeLink(SubtypeLink object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseModelObject(ModelObject object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mealy Machine</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mealy Machine</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseMealyMachine(MealyMachine object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseState(State object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transition Connection</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transition Connection</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseTransitionConnection(TransitionConnection object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseRoot(Root object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public Object defaultCase(EObject object)
  {
    return null;
  }

} //MealyMachineSwitch
