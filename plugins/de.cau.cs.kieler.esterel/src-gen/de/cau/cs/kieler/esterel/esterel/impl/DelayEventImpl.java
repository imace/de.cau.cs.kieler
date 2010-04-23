/**
 * <copyright>
 * </copyright>
 *

 */
package de.cau.cs.kieler.esterel.esterel.impl;

import de.cau.cs.kieler.esterel.esterel.DelayEvent;
import de.cau.cs.kieler.esterel.esterel.EsterelPackage;
import de.cau.cs.kieler.esterel.esterel.SigExpr;
import de.cau.cs.kieler.esterel.esterel.Signal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delay Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.esterel.esterel.impl.DelayEventImpl#getSignal <em>Signal</em>}</li>
 *   <li>{@link de.cau.cs.kieler.esterel.esterel.impl.DelayEventImpl#getTick <em>Tick</em>}</li>
 *   <li>{@link de.cau.cs.kieler.esterel.esterel.impl.DelayEventImpl#getPreSigExpr <em>Pre Sig Expr</em>}</li>
 *   <li>{@link de.cau.cs.kieler.esterel.esterel.impl.DelayEventImpl#getBlockSigExpr <em>Block Sig Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DelayEventImpl extends MinimalEObjectImpl.Container implements DelayEvent
{
  /**
   * The cached value of the '{@link #getSignal() <em>Signal</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignal()
   * @generated
   * @ordered
   */
  protected Signal signal;

  /**
   * The default value of the '{@link #getTick() <em>Tick</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTick()
   * @generated
   * @ordered
   */
  protected static final String TICK_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTick() <em>Tick</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTick()
   * @generated
   * @ordered
   */
  protected String tick = TICK_EDEFAULT;

  /**
   * The cached value of the '{@link #getPreSigExpr() <em>Pre Sig Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreSigExpr()
   * @generated
   * @ordered
   */
  protected SigExpr preSigExpr;

  /**
   * The cached value of the '{@link #getBlockSigExpr() <em>Block Sig Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlockSigExpr()
   * @generated
   * @ordered
   */
  protected SigExpr blockSigExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DelayEventImpl()
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
    return EsterelPackage.Literals.DELAY_EVENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Signal getSignal()
  {
    if (signal != null && signal.eIsProxy())
    {
      InternalEObject oldSignal = (InternalEObject)signal;
      signal = (Signal)eResolveProxy(oldSignal);
      if (signal != oldSignal)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsterelPackage.DELAY_EVENT__SIGNAL, oldSignal, signal));
      }
    }
    return signal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Signal basicGetSignal()
  {
    return signal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSignal(Signal newSignal)
  {
    Signal oldSignal = signal;
    signal = newSignal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EsterelPackage.DELAY_EVENT__SIGNAL, oldSignal, signal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTick()
  {
    return tick;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTick(String newTick)
  {
    String oldTick = tick;
    tick = newTick;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EsterelPackage.DELAY_EVENT__TICK, oldTick, tick));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SigExpr getPreSigExpr()
  {
    return preSigExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPreSigExpr(SigExpr newPreSigExpr, NotificationChain msgs)
  {
    SigExpr oldPreSigExpr = preSigExpr;
    preSigExpr = newPreSigExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsterelPackage.DELAY_EVENT__PRE_SIG_EXPR, oldPreSigExpr, newPreSigExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPreSigExpr(SigExpr newPreSigExpr)
  {
    if (newPreSigExpr != preSigExpr)
    {
      NotificationChain msgs = null;
      if (preSigExpr != null)
        msgs = ((InternalEObject)preSigExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsterelPackage.DELAY_EVENT__PRE_SIG_EXPR, null, msgs);
      if (newPreSigExpr != null)
        msgs = ((InternalEObject)newPreSigExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsterelPackage.DELAY_EVENT__PRE_SIG_EXPR, null, msgs);
      msgs = basicSetPreSigExpr(newPreSigExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EsterelPackage.DELAY_EVENT__PRE_SIG_EXPR, newPreSigExpr, newPreSigExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SigExpr getBlockSigExpr()
  {
    return blockSigExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBlockSigExpr(SigExpr newBlockSigExpr, NotificationChain msgs)
  {
    SigExpr oldBlockSigExpr = blockSigExpr;
    blockSigExpr = newBlockSigExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsterelPackage.DELAY_EVENT__BLOCK_SIG_EXPR, oldBlockSigExpr, newBlockSigExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBlockSigExpr(SigExpr newBlockSigExpr)
  {
    if (newBlockSigExpr != blockSigExpr)
    {
      NotificationChain msgs = null;
      if (blockSigExpr != null)
        msgs = ((InternalEObject)blockSigExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsterelPackage.DELAY_EVENT__BLOCK_SIG_EXPR, null, msgs);
      if (newBlockSigExpr != null)
        msgs = ((InternalEObject)newBlockSigExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsterelPackage.DELAY_EVENT__BLOCK_SIG_EXPR, null, msgs);
      msgs = basicSetBlockSigExpr(newBlockSigExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EsterelPackage.DELAY_EVENT__BLOCK_SIG_EXPR, newBlockSigExpr, newBlockSigExpr));
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
      case EsterelPackage.DELAY_EVENT__PRE_SIG_EXPR:
        return basicSetPreSigExpr(null, msgs);
      case EsterelPackage.DELAY_EVENT__BLOCK_SIG_EXPR:
        return basicSetBlockSigExpr(null, msgs);
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
      case EsterelPackage.DELAY_EVENT__SIGNAL:
        if (resolve) return getSignal();
        return basicGetSignal();
      case EsterelPackage.DELAY_EVENT__TICK:
        return getTick();
      case EsterelPackage.DELAY_EVENT__PRE_SIG_EXPR:
        return getPreSigExpr();
      case EsterelPackage.DELAY_EVENT__BLOCK_SIG_EXPR:
        return getBlockSigExpr();
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
      case EsterelPackage.DELAY_EVENT__SIGNAL:
        setSignal((Signal)newValue);
        return;
      case EsterelPackage.DELAY_EVENT__TICK:
        setTick((String)newValue);
        return;
      case EsterelPackage.DELAY_EVENT__PRE_SIG_EXPR:
        setPreSigExpr((SigExpr)newValue);
        return;
      case EsterelPackage.DELAY_EVENT__BLOCK_SIG_EXPR:
        setBlockSigExpr((SigExpr)newValue);
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
      case EsterelPackage.DELAY_EVENT__SIGNAL:
        setSignal((Signal)null);
        return;
      case EsterelPackage.DELAY_EVENT__TICK:
        setTick(TICK_EDEFAULT);
        return;
      case EsterelPackage.DELAY_EVENT__PRE_SIG_EXPR:
        setPreSigExpr((SigExpr)null);
        return;
      case EsterelPackage.DELAY_EVENT__BLOCK_SIG_EXPR:
        setBlockSigExpr((SigExpr)null);
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
      case EsterelPackage.DELAY_EVENT__SIGNAL:
        return signal != null;
      case EsterelPackage.DELAY_EVENT__TICK:
        return TICK_EDEFAULT == null ? tick != null : !TICK_EDEFAULT.equals(tick);
      case EsterelPackage.DELAY_EVENT__PRE_SIG_EXPR:
        return preSigExpr != null;
      case EsterelPackage.DELAY_EVENT__BLOCK_SIG_EXPR:
        return blockSigExpr != null;
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
    result.append(" (tick: ");
    result.append(tick);
    result.append(')');
    return result.toString();
  }

} //DelayEventImpl
