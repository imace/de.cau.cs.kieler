/**
 * <copyright>
 * </copyright>
 *

 */
package de.cau.cs.kieler.synccharts.interfacedeclparser.interfaceDecl.impl;

import de.cau.cs.kieler.synccharts.Signal;

import de.cau.cs.kieler.synccharts.interfacedeclparser.interfaceDecl.InterfaceDeclPackage;
import de.cau.cs.kieler.synccharts.interfacedeclparser.interfaceDecl.Signals;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signals</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.synccharts.interfacedeclparser.interfaceDecl.impl.SignalsImpl#getSignals <em>Signals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SignalsImpl extends MinimalEObjectImpl.Container implements Signals
{
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SignalsImpl()
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
    return InterfaceDeclPackage.Literals.SIGNALS;
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
      signals = new EObjectContainmentEList<Signal>(Signal.class, this, InterfaceDeclPackage.SIGNALS__SIGNALS);
    }
    return signals;
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
      case InterfaceDeclPackage.SIGNALS__SIGNALS:
        return ((InternalEList<?>)getSignals()).basicRemove(otherEnd, msgs);
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
      case InterfaceDeclPackage.SIGNALS__SIGNALS:
        return getSignals();
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
      case InterfaceDeclPackage.SIGNALS__SIGNALS:
        getSignals().clear();
        getSignals().addAll((Collection<? extends Signal>)newValue);
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
      case InterfaceDeclPackage.SIGNALS__SIGNALS:
        getSignals().clear();
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
      case InterfaceDeclPackage.SIGNALS__SIGNALS:
        return signals != null && !signals.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SignalsImpl
