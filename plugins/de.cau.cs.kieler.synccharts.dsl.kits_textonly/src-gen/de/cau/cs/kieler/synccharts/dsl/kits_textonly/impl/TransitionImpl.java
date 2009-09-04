/**
 * <copyright>
 * </copyright>
 *
 */
package de.cau.cs.kieler.synccharts.dsl.kits_textonly.impl;

import de.cau.cs.kieler.synccharts.dsl.kits_textonly.Kits_textonlyPackage;
import de.cau.cs.kieler.synccharts.dsl.kits_textonly.State;
import de.cau.cs.kieler.synccharts.dsl.kits_textonly.Transition;
import de.cau.cs.kieler.synccharts.dsl.kits_textonly.TransitionState;
import de.cau.cs.kieler.synccharts.dsl.kits_textonly.TransitionType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.synccharts.dsl.kits_textonly.impl.TransitionImpl#getNewSourceState <em>New Source State</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.dsl.kits_textonly.impl.TransitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.dsl.kits_textonly.impl.TransitionImpl#getTargetState <em>Target State</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.dsl.kits_textonly.impl.TransitionImpl#isIsHistory <em>Is History</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionImpl extends ActionImpl implements Transition
{
  /**
   * The cached value of the '{@link #getNewSourceState() <em>New Source State</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNewSourceState()
   * @generated
   * @ordered
   */
  protected TransitionState newSourceState;

  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final TransitionType TYPE_EDEFAULT = TransitionType.WEAKABORT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected TransitionType type = TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getTargetState() <em>Target State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetState()
   * @generated
   * @ordered
   */
  protected State targetState;

  /**
   * The default value of the '{@link #isIsHistory() <em>Is History</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsHistory()
   * @generated
   * @ordered
   */
  protected static final boolean IS_HISTORY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsHistory() <em>Is History</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsHistory()
   * @generated
   * @ordered
   */
  protected boolean isHistory = IS_HISTORY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return Kits_textonlyPackage.Literals.TRANSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionState getNewSourceState()
  {
    return newSourceState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNewSourceState(TransitionState newNewSourceState, NotificationChain msgs)
  {
    TransitionState oldNewSourceState = newSourceState;
    newSourceState = newNewSourceState;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Kits_textonlyPackage.TRANSITION__NEW_SOURCE_STATE, oldNewSourceState, newNewSourceState);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNewSourceState(TransitionState newNewSourceState)
  {
    if (newNewSourceState != newSourceState)
    {
      NotificationChain msgs = null;
      if (newSourceState != null)
        msgs = ((InternalEObject)newSourceState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Kits_textonlyPackage.TRANSITION__NEW_SOURCE_STATE, null, msgs);
      if (newNewSourceState != null)
        msgs = ((InternalEObject)newNewSourceState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Kits_textonlyPackage.TRANSITION__NEW_SOURCE_STATE, null, msgs);
      msgs = basicSetNewSourceState(newNewSourceState, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Kits_textonlyPackage.TRANSITION__NEW_SOURCE_STATE, newNewSourceState, newNewSourceState));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionType getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(TransitionType newType)
  {
    TransitionType oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Kits_textonlyPackage.TRANSITION__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State getTargetState()
  {
    if (targetState != null && targetState.eIsProxy())
    {
      InternalEObject oldTargetState = (InternalEObject)targetState;
      targetState = (State)eResolveProxy(oldTargetState);
      if (targetState != oldTargetState)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Kits_textonlyPackage.TRANSITION__TARGET_STATE, oldTargetState, targetState));
      }
    }
    return targetState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State basicGetTargetState()
  {
    return targetState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetState(State newTargetState)
  {
    State oldTargetState = targetState;
    targetState = newTargetState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Kits_textonlyPackage.TRANSITION__TARGET_STATE, oldTargetState, targetState));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsHistory()
  {
    return isHistory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsHistory(boolean newIsHistory)
  {
    boolean oldIsHistory = isHistory;
    isHistory = newIsHistory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Kits_textonlyPackage.TRANSITION__IS_HISTORY, oldIsHistory, isHistory));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case Kits_textonlyPackage.TRANSITION__NEW_SOURCE_STATE:
        return basicSetNewSourceState(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case Kits_textonlyPackage.TRANSITION__NEW_SOURCE_STATE:
        return getNewSourceState();
      case Kits_textonlyPackage.TRANSITION__TYPE:
        return getType();
      case Kits_textonlyPackage.TRANSITION__TARGET_STATE:
        if (resolve) return getTargetState();
        return basicGetTargetState();
      case Kits_textonlyPackage.TRANSITION__IS_HISTORY:
        return isIsHistory();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case Kits_textonlyPackage.TRANSITION__NEW_SOURCE_STATE:
        setNewSourceState((TransitionState)newValue);
        return;
      case Kits_textonlyPackage.TRANSITION__TYPE:
        setType((TransitionType)newValue);
        return;
      case Kits_textonlyPackage.TRANSITION__TARGET_STATE:
        setTargetState((State)newValue);
        return;
      case Kits_textonlyPackage.TRANSITION__IS_HISTORY:
        setIsHistory((Boolean)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case Kits_textonlyPackage.TRANSITION__NEW_SOURCE_STATE:
        setNewSourceState((TransitionState)null);
        return;
      case Kits_textonlyPackage.TRANSITION__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case Kits_textonlyPackage.TRANSITION__TARGET_STATE:
        setTargetState((State)null);
        return;
      case Kits_textonlyPackage.TRANSITION__IS_HISTORY:
        setIsHistory(IS_HISTORY_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case Kits_textonlyPackage.TRANSITION__NEW_SOURCE_STATE:
        return newSourceState != null;
      case Kits_textonlyPackage.TRANSITION__TYPE:
        return type != TYPE_EDEFAULT;
      case Kits_textonlyPackage.TRANSITION__TARGET_STATE:
        return targetState != null;
      case Kits_textonlyPackage.TRANSITION__IS_HISTORY:
        return isHistory != IS_HISTORY_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (type: ");
    result.append(type);
    result.append(", isHistory: ");
    result.append(isHistory);
    result.append(')');
    return result.toString();
  }

} //TransitionImpl
