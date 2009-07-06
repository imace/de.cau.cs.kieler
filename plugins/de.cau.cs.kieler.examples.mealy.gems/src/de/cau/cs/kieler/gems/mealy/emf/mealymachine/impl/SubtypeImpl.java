/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl;

import de.cau.cs.kieler.gems.mealy.emf.mealymachine.MealyMachinePackage;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.ModelObject;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.Subtype;
import de.cau.cs.kieler.gems.mealy.emf.mealymachine.SubtypeLink;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subtype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl.SubtypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl.SubtypeImpl#getBase <em>Base</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl.SubtypeImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl.SubtypeImpl#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubtypeImpl extends EObjectImpl implements Subtype
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = "AnonymousSubtype";

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
   * The cached value of the '{@link #getBase() <em>Base</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBase()
   * @generated
   * @ordered
   */
  protected ModelObject base;

  /**
   * The cached value of the '{@link #getInstances() <em>Instances</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstances()
   * @generated
   * @ordered
   */
  protected EList instances;

  /**
   * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLinks()
   * @generated
   * @ordered
   */
  protected EList links;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SubtypeImpl()
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
    return MealyMachinePackage.Literals.SUBTYPE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, MealyMachinePackage.SUBTYPE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelObject getBase()
  {
    if (base != null && base.eIsProxy())
    {
      InternalEObject oldBase = (InternalEObject)base;
      base = (ModelObject)eResolveProxy(oldBase);
      if (base != oldBase)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MealyMachinePackage.SUBTYPE__BASE, oldBase, base));
      }
    }
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelObject basicGetBase()
  {
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBase(ModelObject newBase)
  {
    ModelObject oldBase = base;
    base = newBase;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MealyMachinePackage.SUBTYPE__BASE, oldBase, base));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getInstances()
  {
    if (instances == null)
    {
      instances = new EObjectResolvingEList(ModelObject.class, this, MealyMachinePackage.SUBTYPE__INSTANCES);
    }
    return instances;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getLinks()
  {
    if (links == null)
    {
      links = new EObjectContainmentEList(SubtypeLink.class, this, MealyMachinePackage.SUBTYPE__LINKS);
    }
    return links;
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
      case MealyMachinePackage.SUBTYPE__LINKS:
        return ((InternalEList)getLinks()).basicRemove(otherEnd, msgs);
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
      case MealyMachinePackage.SUBTYPE__NAME:
        return getName();
      case MealyMachinePackage.SUBTYPE__BASE:
        if (resolve) return getBase();
        return basicGetBase();
      case MealyMachinePackage.SUBTYPE__INSTANCES:
        return getInstances();
      case MealyMachinePackage.SUBTYPE__LINKS:
        return getLinks();
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
      case MealyMachinePackage.SUBTYPE__NAME:
        setName((String)newValue);
        return;
      case MealyMachinePackage.SUBTYPE__BASE:
        setBase((ModelObject)newValue);
        return;
      case MealyMachinePackage.SUBTYPE__INSTANCES:
        getInstances().clear();
        getInstances().addAll((Collection)newValue);
        return;
      case MealyMachinePackage.SUBTYPE__LINKS:
        getLinks().clear();
        getLinks().addAll((Collection)newValue);
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
      case MealyMachinePackage.SUBTYPE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MealyMachinePackage.SUBTYPE__BASE:
        setBase((ModelObject)null);
        return;
      case MealyMachinePackage.SUBTYPE__INSTANCES:
        getInstances().clear();
        return;
      case MealyMachinePackage.SUBTYPE__LINKS:
        getLinks().clear();
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
      case MealyMachinePackage.SUBTYPE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MealyMachinePackage.SUBTYPE__BASE:
        return base != null;
      case MealyMachinePackage.SUBTYPE__INSTANCES:
        return instances != null && !instances.isEmpty();
      case MealyMachinePackage.SUBTYPE__LINKS:
        return links != null && !links.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //SubtypeImpl
