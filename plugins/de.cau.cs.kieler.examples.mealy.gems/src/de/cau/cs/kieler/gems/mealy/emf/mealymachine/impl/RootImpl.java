/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl;

import de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachine;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.Memento;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.Root;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.State;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.Subtype;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.TransitionConnection;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl.RootImpl#getMementos <em>Mementos</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl.RootImpl#getSubtypes <em>Subtypes</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl.RootImpl#getRealRoot <em>Real Root</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl.RootImpl#getMealyMachine <em>Mealy Machine</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl.RootImpl#getState <em>State</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl.RootImpl#getTransitionConnection <em>Transition Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootImpl extends EObjectImpl implements Root
{
  /**
   * The cached value of the '{@link #getMementos() <em>Mementos</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMementos()
   * @generated
   * @ordered
   */
  protected EList mementos;

  /**
   * The cached value of the '{@link #getSubtypes() <em>Subtypes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubtypes()
   * @generated
   * @ordered
   */
  protected EList subtypes;

  /**
   * The cached value of the '{@link #getRealRoot() <em>Real Root</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRealRoot()
   * @generated
   * @ordered
   */
  protected MealyMachine realRoot;

  /**
   * The cached value of the '{@link #getMealyMachine() <em>Mealy Machine</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMealyMachine()
   * @generated
   * @ordered
   */
  protected EList mealyMachine;

  /**
   * The cached value of the '{@link #getState() <em>State</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected EList state;

  /**
   * The cached value of the '{@link #getTransitionConnection() <em>Transition Connection</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitionConnection()
   * @generated
   * @ordered
   */
  protected EList transitionConnection;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RootImpl()
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
    return MealyMachinePackage.Literals.ROOT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getMementos()
  {
    if (mementos == null)
    {
      mementos = new EObjectContainmentEList(Memento.class, this, MealyMachinePackage.ROOT__MEMENTOS);
    }
    return mementos;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getSubtypes()
  {
    if (subtypes == null)
    {
      subtypes = new EObjectContainmentEList(Subtype.class, this, MealyMachinePackage.ROOT__SUBTYPES);
    }
    return subtypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MealyMachine getRealRoot()
  {
    return realRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRealRoot(MealyMachine newRealRoot, NotificationChain msgs)
  {
    MealyMachine oldRealRoot = realRoot;
    realRoot = newRealRoot;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MealyMachinePackage.ROOT__REAL_ROOT, oldRealRoot, newRealRoot);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRealRoot(MealyMachine newRealRoot)
  {
    if (newRealRoot != realRoot)
    {
      NotificationChain msgs = null;
      if (realRoot != null)
        msgs = ((InternalEObject)realRoot).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MealyMachinePackage.ROOT__REAL_ROOT, null, msgs);
      if (newRealRoot != null)
        msgs = ((InternalEObject)newRealRoot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MealyMachinePackage.ROOT__REAL_ROOT, null, msgs);
      msgs = basicSetRealRoot(newRealRoot, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MealyMachinePackage.ROOT__REAL_ROOT, newRealRoot, newRealRoot));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getMealyMachine()
  {
    if (mealyMachine == null)
    {
      mealyMachine = new EObjectContainmentEList(MealyMachine.class, this, MealyMachinePackage.ROOT__MEALY_MACHINE);
    }
    return mealyMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getState()
  {
    if (state == null)
    {
      state = new EObjectContainmentEList(State.class, this, MealyMachinePackage.ROOT__STATE);
    }
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getTransitionConnection()
  {
    if (transitionConnection == null)
    {
      transitionConnection = new EObjectContainmentEList(TransitionConnection.class, this, MealyMachinePackage.ROOT__TRANSITION_CONNECTION);
    }
    return transitionConnection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MealyMachinePackage.ROOT__MEMENTOS:
        return ((InternalEList)getMementos()).basicRemove(otherEnd, msgs);
      case MealyMachinePackage.ROOT__SUBTYPES:
        return ((InternalEList)getSubtypes()).basicRemove(otherEnd, msgs);
      case MealyMachinePackage.ROOT__REAL_ROOT:
        return basicSetRealRoot(null, msgs);
      case MealyMachinePackage.ROOT__MEALY_MACHINE:
        return ((InternalEList)getMealyMachine()).basicRemove(otherEnd, msgs);
      case MealyMachinePackage.ROOT__STATE:
        return ((InternalEList)getState()).basicRemove(otherEnd, msgs);
      case MealyMachinePackage.ROOT__TRANSITION_CONNECTION:
        return ((InternalEList)getTransitionConnection()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case MealyMachinePackage.ROOT__MEMENTOS:
        return getMementos();
      case MealyMachinePackage.ROOT__SUBTYPES:
        return getSubtypes();
      case MealyMachinePackage.ROOT__REAL_ROOT:
        return getRealRoot();
      case MealyMachinePackage.ROOT__MEALY_MACHINE:
        return getMealyMachine();
      case MealyMachinePackage.ROOT__STATE:
        return getState();
      case MealyMachinePackage.ROOT__TRANSITION_CONNECTION:
        return getTransitionConnection();
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
      case MealyMachinePackage.ROOT__MEMENTOS:
        getMementos().clear();
        getMementos().addAll((Collection)newValue);
        return;
      case MealyMachinePackage.ROOT__SUBTYPES:
        getSubtypes().clear();
        getSubtypes().addAll((Collection)newValue);
        return;
      case MealyMachinePackage.ROOT__REAL_ROOT:
        setRealRoot((MealyMachine)newValue);
        return;
      case MealyMachinePackage.ROOT__MEALY_MACHINE:
        getMealyMachine().clear();
        getMealyMachine().addAll((Collection)newValue);
        return;
      case MealyMachinePackage.ROOT__STATE:
        getState().clear();
        getState().addAll((Collection)newValue);
        return;
      case MealyMachinePackage.ROOT__TRANSITION_CONNECTION:
        getTransitionConnection().clear();
        getTransitionConnection().addAll((Collection)newValue);
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
      case MealyMachinePackage.ROOT__MEMENTOS:
        getMementos().clear();
        return;
      case MealyMachinePackage.ROOT__SUBTYPES:
        getSubtypes().clear();
        return;
      case MealyMachinePackage.ROOT__REAL_ROOT:
        setRealRoot((MealyMachine)null);
        return;
      case MealyMachinePackage.ROOT__MEALY_MACHINE:
        getMealyMachine().clear();
        return;
      case MealyMachinePackage.ROOT__STATE:
        getState().clear();
        return;
      case MealyMachinePackage.ROOT__TRANSITION_CONNECTION:
        getTransitionConnection().clear();
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
      case MealyMachinePackage.ROOT__MEMENTOS:
        return mementos != null && !mementos.isEmpty();
      case MealyMachinePackage.ROOT__SUBTYPES:
        return subtypes != null && !subtypes.isEmpty();
      case MealyMachinePackage.ROOT__REAL_ROOT:
        return realRoot != null;
      case MealyMachinePackage.ROOT__MEALY_MACHINE:
        return mealyMachine != null && !mealyMachine.isEmpty();
      case MealyMachinePackage.ROOT__STATE:
        return state != null && !state.isEmpty();
      case MealyMachinePackage.ROOT__TRANSITION_CONNECTION:
        return transitionConnection != null && !transitionConnection.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RootImpl
