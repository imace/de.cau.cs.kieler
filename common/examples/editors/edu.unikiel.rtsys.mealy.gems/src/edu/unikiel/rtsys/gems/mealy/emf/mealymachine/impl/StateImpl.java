/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl;

import edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MealyMachine;
import edu.unikiel.rtsys.gems.mealy.emf.mealymachine.MealyMachinePackage;
import edu.unikiel.rtsys.gems.mealy.emf.mealymachine.State;
import edu.unikiel.rtsys.gems.mealy.emf.mealymachine.TransitionConnection;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.StateImpl#getStateName <em>State Name</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.StateImpl#getParentMachine <em>Parent Machine</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.StateImpl#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.gems.mealy.emf.mealymachine.impl.StateImpl#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends ModelObjectImpl implements State
{
  /**
   * The default value of the '{@link #getStateName() <em>State Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateName()
   * @generated
   * @ordered
   */
  protected static final String STATE_NAME_EDEFAULT = "0";

  /**
   * The cached value of the '{@link #getStateName() <em>State Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateName()
   * @generated
   * @ordered
   */
  protected String stateName = STATE_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getParentMachine() <em>Parent Machine</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParentMachine()
   * @generated
   * @ordered
   */
  protected MealyMachine parentMachine;

  /**
   * The cached value of the '{@link #getOutgoingTransitions() <em>Outgoing Transitions</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoingTransitions()
   * @generated
   * @ordered
   */
  protected EList outgoingTransitions;

  /**
   * The cached value of the '{@link #getIncomingTransitions() <em>Incoming Transitions</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncomingTransitions()
   * @generated
   * @ordered
   */
  protected EList incomingTransitions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StateImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return MealyMachinePackage.Literals.STATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStateName()
  {
    return stateName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStateName(String newStateName)
  {
    String oldStateName = stateName;
    stateName = newStateName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MealyMachinePackage.STATE__STATE_NAME, oldStateName, stateName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MealyMachine getParentMachine()
  {
    if (parentMachine != null && parentMachine.eIsProxy())
    {
      InternalEObject oldParentMachine = (InternalEObject)parentMachine;
      parentMachine = (MealyMachine)eResolveProxy(oldParentMachine);
      if (parentMachine != oldParentMachine)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MealyMachinePackage.STATE__PARENT_MACHINE, oldParentMachine, parentMachine));
      }
    }
    return parentMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MealyMachine basicGetParentMachine()
  {
    return parentMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentMachine(MealyMachine newParentMachine)
  {
    MealyMachine oldParentMachine = parentMachine;
    parentMachine = newParentMachine;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MealyMachinePackage.STATE__PARENT_MACHINE, oldParentMachine, parentMachine));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getOutgoingTransitions()
  {
    if (outgoingTransitions == null)
    {
      outgoingTransitions = new EObjectResolvingEList(TransitionConnection.class, this, MealyMachinePackage.STATE__OUTGOING_TRANSITIONS);
    }
    return outgoingTransitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getIncomingTransitions()
  {
    if (incomingTransitions == null)
    {
      incomingTransitions = new EObjectResolvingEList(TransitionConnection.class, this, MealyMachinePackage.STATE__INCOMING_TRANSITIONS);
    }
    return incomingTransitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MealyMachinePackage.STATE__STATE_NAME:
        return getStateName();
      case MealyMachinePackage.STATE__PARENT_MACHINE:
        if (resolve) return getParentMachine();
        return basicGetParentMachine();
      case MealyMachinePackage.STATE__OUTGOING_TRANSITIONS:
        return getOutgoingTransitions();
      case MealyMachinePackage.STATE__INCOMING_TRANSITIONS:
        return getIncomingTransitions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MealyMachinePackage.STATE__STATE_NAME:
        setStateName((String)newValue);
        return;
      case MealyMachinePackage.STATE__PARENT_MACHINE:
        setParentMachine((MealyMachine)newValue);
        return;
      case MealyMachinePackage.STATE__OUTGOING_TRANSITIONS:
        getOutgoingTransitions().clear();
        getOutgoingTransitions().addAll((Collection)newValue);
        return;
      case MealyMachinePackage.STATE__INCOMING_TRANSITIONS:
        getIncomingTransitions().clear();
        getIncomingTransitions().addAll((Collection)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MealyMachinePackage.STATE__STATE_NAME:
        setStateName(STATE_NAME_EDEFAULT);
        return;
      case MealyMachinePackage.STATE__PARENT_MACHINE:
        setParentMachine((MealyMachine)null);
        return;
      case MealyMachinePackage.STATE__OUTGOING_TRANSITIONS:
        getOutgoingTransitions().clear();
        return;
      case MealyMachinePackage.STATE__INCOMING_TRANSITIONS:
        getIncomingTransitions().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MealyMachinePackage.STATE__STATE_NAME:
        return STATE_NAME_EDEFAULT == null ? stateName != null : !STATE_NAME_EDEFAULT.equals(stateName);
      case MealyMachinePackage.STATE__PARENT_MACHINE:
        return parentMachine != null;
      case MealyMachinePackage.STATE__OUTGOING_TRANSITIONS:
        return outgoingTransitions != null && !outgoingTransitions.isEmpty();
      case MealyMachinePackage.STATE__INCOMING_TRANSITIONS:
        return incomingTransitions != null && !incomingTransitions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (StateName: ");
    result.append(stateName);
    result.append(')');
    return result.toString();
  }

} //StateImpl
