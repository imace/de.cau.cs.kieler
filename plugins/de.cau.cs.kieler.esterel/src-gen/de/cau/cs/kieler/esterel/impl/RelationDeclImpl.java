/**
 * <copyright>
 * </copyright>
 *
 */
package de.cau.cs.kieler.esterel.impl;

import de.cau.cs.kieler.esterel.EsterelPackage;
import de.cau.cs.kieler.esterel.Relation;
import de.cau.cs.kieler.esterel.RelationDecl;

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
 * An implementation of the model object '<em><b>Relation Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.esterel.impl.RelationDeclImpl#getRelation <em>Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationDeclImpl extends MinimalEObjectImpl.Container implements RelationDecl
{
  /**
   * The cached value of the '{@link #getRelation() <em>Relation</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelation()
   * @generated
   * @ordered
   */
  protected EList<Relation> relation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RelationDeclImpl()
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
    return EsterelPackage.Literals.RELATION_DECL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Relation> getRelation()
  {
    if (relation == null)
    {
      relation = new EObjectContainmentEList<Relation>(Relation.class, this, EsterelPackage.RELATION_DECL__RELATION);
    }
    return relation;
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
      case EsterelPackage.RELATION_DECL__RELATION:
        return ((InternalEList<?>)getRelation()).basicRemove(otherEnd, msgs);
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
      case EsterelPackage.RELATION_DECL__RELATION:
        return getRelation();
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
      case EsterelPackage.RELATION_DECL__RELATION:
        getRelation().clear();
        getRelation().addAll((Collection<? extends Relation>)newValue);
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
      case EsterelPackage.RELATION_DECL__RELATION:
        getRelation().clear();
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
      case EsterelPackage.RELATION_DECL__RELATION:
        return relation != null && !relation.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RelationDeclImpl
