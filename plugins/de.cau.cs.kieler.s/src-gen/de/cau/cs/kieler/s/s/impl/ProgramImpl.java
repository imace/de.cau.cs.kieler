/**
 * <copyright>
 * </copyright>
 *
 */
package de.cau.cs.kieler.s.s.impl;

import de.cau.cs.kieler.core.kexpressions.Signal;

import de.cau.cs.kieler.s.s.Program;
import de.cau.cs.kieler.s.s.SPackage;
import de.cau.cs.kieler.s.s.State;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.s.s.impl.ProgramImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.s.s.impl.ProgramImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link de.cau.cs.kieler.s.s.impl.ProgramImpl#getSignals <em>Signals</em>}</li>
 *   <li>{@link de.cau.cs.kieler.s.s.impl.ProgramImpl#getStates <em>States</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProgramImpl extends MinimalEObjectImpl.Container implements Program
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected static final int PRIORITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected int priority = PRIORITY_EDEFAULT;

  /**
   * The cached value of the '{@link #getSignals() <em>Signals</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignals()
   * @generated
   * @ordered
   */
  protected EList<Signal> signals;

  /**
   * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStates()
   * @generated
   * @ordered
   */
  protected EList<State> states;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProgramImpl()
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
    return SPackage.Literals.PROGRAM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SPackage.PROGRAM__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPriority()
  {
    return priority;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPriority(int newPriority)
  {
    int oldPriority = priority;
    priority = newPriority;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SPackage.PROGRAM__PRIORITY, oldPriority, priority));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Signal> getSignals()
  {
    if (signals == null)
    {
      signals = new EObjectContainmentEList<Signal>(Signal.class, this, SPackage.PROGRAM__SIGNALS);
    }
    return signals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<State> getStates()
  {
    if (states == null)
    {
      states = new EObjectContainmentEList<State>(State.class, this, SPackage.PROGRAM__STATES);
    }
    return states;
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
      case SPackage.PROGRAM__SIGNALS:
        return ((InternalEList<?>)getSignals()).basicRemove(otherEnd, msgs);
      case SPackage.PROGRAM__STATES:
        return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
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
      case SPackage.PROGRAM__NAME:
        return getName();
      case SPackage.PROGRAM__PRIORITY:
        return getPriority();
      case SPackage.PROGRAM__SIGNALS:
        return getSignals();
      case SPackage.PROGRAM__STATES:
        return getStates();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SPackage.PROGRAM__NAME:
        setName((String)newValue);
        return;
      case SPackage.PROGRAM__PRIORITY:
        setPriority((Integer)newValue);
        return;
      case SPackage.PROGRAM__SIGNALS:
        getSignals().clear();
        getSignals().addAll((Collection<? extends Signal>)newValue);
        return;
      case SPackage.PROGRAM__STATES:
        getStates().clear();
        getStates().addAll((Collection<? extends State>)newValue);
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
      case SPackage.PROGRAM__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SPackage.PROGRAM__PRIORITY:
        setPriority(PRIORITY_EDEFAULT);
        return;
      case SPackage.PROGRAM__SIGNALS:
        getSignals().clear();
        return;
      case SPackage.PROGRAM__STATES:
        getStates().clear();
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
      case SPackage.PROGRAM__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SPackage.PROGRAM__PRIORITY:
        return priority != PRIORITY_EDEFAULT;
      case SPackage.PROGRAM__SIGNALS:
        return signals != null && !signals.isEmpty();
      case SPackage.PROGRAM__STATES:
        return states != null && !states.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(", priority: ");
    result.append(priority);
    result.append(')');
    return result.toString();
  }

} //ProgramImpl
