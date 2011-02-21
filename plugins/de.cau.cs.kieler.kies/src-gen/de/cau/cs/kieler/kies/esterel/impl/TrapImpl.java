/**
 * <copyright>
 * </copyright>
 *
 */
package de.cau.cs.kieler.kies.esterel.impl;

import de.cau.cs.kieler.kies.esterel.EsterelPackage;
import de.cau.cs.kieler.kies.esterel.Statement;
import de.cau.cs.kieler.kies.esterel.Trap;
import de.cau.cs.kieler.kies.esterel.TrapDeclList;
import de.cau.cs.kieler.kies.esterel.TrapHandler;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trap</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kies.esterel.impl.TrapImpl#getTrapDeclList <em>Trap Decl List</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kies.esterel.impl.TrapImpl#getStatement <em>Statement</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kies.esterel.impl.TrapImpl#getTrapHandler <em>Trap Handler</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kies.esterel.impl.TrapImpl#getOptEnd <em>Opt End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TrapImpl extends StatementImpl implements Trap
{
  /**
   * The cached value of the '{@link #getTrapDeclList() <em>Trap Decl List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrapDeclList()
   * @generated
   * @ordered
   */
  protected TrapDeclList trapDeclList;

  /**
   * The cached value of the '{@link #getStatement() <em>Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatement()
   * @generated
   * @ordered
   */
  protected Statement statement;

  /**
   * The cached value of the '{@link #getTrapHandler() <em>Trap Handler</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrapHandler()
   * @generated
   * @ordered
   */
  protected EList<TrapHandler> trapHandler;

  /**
   * The default value of the '{@link #getOptEnd() <em>Opt End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOptEnd()
   * @generated
   * @ordered
   */
  protected static final String OPT_END_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOptEnd() <em>Opt End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOptEnd()
   * @generated
   * @ordered
   */
  protected String optEnd = OPT_END_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TrapImpl()
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
    return EsterelPackage.Literals.TRAP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrapDeclList getTrapDeclList()
  {
    return trapDeclList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTrapDeclList(TrapDeclList newTrapDeclList, NotificationChain msgs)
  {
    TrapDeclList oldTrapDeclList = trapDeclList;
    trapDeclList = newTrapDeclList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsterelPackage.TRAP__TRAP_DECL_LIST, oldTrapDeclList, newTrapDeclList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrapDeclList(TrapDeclList newTrapDeclList)
  {
    if (newTrapDeclList != trapDeclList)
    {
      NotificationChain msgs = null;
      if (trapDeclList != null)
        msgs = ((InternalEObject)trapDeclList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsterelPackage.TRAP__TRAP_DECL_LIST, null, msgs);
      if (newTrapDeclList != null)
        msgs = ((InternalEObject)newTrapDeclList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsterelPackage.TRAP__TRAP_DECL_LIST, null, msgs);
      msgs = basicSetTrapDeclList(newTrapDeclList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EsterelPackage.TRAP__TRAP_DECL_LIST, newTrapDeclList, newTrapDeclList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement getStatement()
  {
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStatement(Statement newStatement, NotificationChain msgs)
  {
    Statement oldStatement = statement;
    statement = newStatement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsterelPackage.TRAP__STATEMENT, oldStatement, newStatement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatement(Statement newStatement)
  {
    if (newStatement != statement)
    {
      NotificationChain msgs = null;
      if (statement != null)
        msgs = ((InternalEObject)statement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsterelPackage.TRAP__STATEMENT, null, msgs);
      if (newStatement != null)
        msgs = ((InternalEObject)newStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsterelPackage.TRAP__STATEMENT, null, msgs);
      msgs = basicSetStatement(newStatement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EsterelPackage.TRAP__STATEMENT, newStatement, newStatement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TrapHandler> getTrapHandler()
  {
    if (trapHandler == null)
    {
      trapHandler = new EObjectContainmentEList<TrapHandler>(TrapHandler.class, this, EsterelPackage.TRAP__TRAP_HANDLER);
    }
    return trapHandler;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOptEnd()
  {
    return optEnd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOptEnd(String newOptEnd)
  {
    String oldOptEnd = optEnd;
    optEnd = newOptEnd;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EsterelPackage.TRAP__OPT_END, oldOptEnd, optEnd));
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
      case EsterelPackage.TRAP__TRAP_DECL_LIST:
        return basicSetTrapDeclList(null, msgs);
      case EsterelPackage.TRAP__STATEMENT:
        return basicSetStatement(null, msgs);
      case EsterelPackage.TRAP__TRAP_HANDLER:
        return ((InternalEList<?>)getTrapHandler()).basicRemove(otherEnd, msgs);
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
      case EsterelPackage.TRAP__TRAP_DECL_LIST:
        return getTrapDeclList();
      case EsterelPackage.TRAP__STATEMENT:
        return getStatement();
      case EsterelPackage.TRAP__TRAP_HANDLER:
        return getTrapHandler();
      case EsterelPackage.TRAP__OPT_END:
        return getOptEnd();
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
      case EsterelPackage.TRAP__TRAP_DECL_LIST:
        setTrapDeclList((TrapDeclList)newValue);
        return;
      case EsterelPackage.TRAP__STATEMENT:
        setStatement((Statement)newValue);
        return;
      case EsterelPackage.TRAP__TRAP_HANDLER:
        getTrapHandler().clear();
        getTrapHandler().addAll((Collection<? extends TrapHandler>)newValue);
        return;
      case EsterelPackage.TRAP__OPT_END:
        setOptEnd((String)newValue);
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
      case EsterelPackage.TRAP__TRAP_DECL_LIST:
        setTrapDeclList((TrapDeclList)null);
        return;
      case EsterelPackage.TRAP__STATEMENT:
        setStatement((Statement)null);
        return;
      case EsterelPackage.TRAP__TRAP_HANDLER:
        getTrapHandler().clear();
        return;
      case EsterelPackage.TRAP__OPT_END:
        setOptEnd(OPT_END_EDEFAULT);
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
      case EsterelPackage.TRAP__TRAP_DECL_LIST:
        return trapDeclList != null;
      case EsterelPackage.TRAP__STATEMENT:
        return statement != null;
      case EsterelPackage.TRAP__TRAP_HANDLER:
        return trapHandler != null && !trapHandler.isEmpty();
      case EsterelPackage.TRAP__OPT_END:
        return OPT_END_EDEFAULT == null ? optEnd != null : !OPT_END_EDEFAULT.equals(optEnd);
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
    result.append(" (optEnd: ");
    result.append(optEnd);
    result.append(')');
    return result.toString();
  }

} //TrapImpl
