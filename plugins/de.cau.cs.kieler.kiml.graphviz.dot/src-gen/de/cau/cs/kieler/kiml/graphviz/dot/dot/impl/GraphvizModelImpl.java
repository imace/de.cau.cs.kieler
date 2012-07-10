/**
 */
package de.cau.cs.kieler.kiml.graphviz.dot.dot.impl;

import de.cau.cs.kieler.kiml.graphviz.dot.dot.DotPackage;
import de.cau.cs.kieler.kiml.graphviz.dot.dot.Graph;
import de.cau.cs.kieler.kiml.graphviz.dot.dot.GraphvizModel;

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
 * An implementation of the model object '<em><b>Graphviz Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.graphviz.dot.dot.impl.GraphvizModelImpl#getGraphs <em>Graphs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphvizModelImpl extends MinimalEObjectImpl.Container implements GraphvizModel
{
  /**
   * The cached value of the '{@link #getGraphs() <em>Graphs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGraphs()
   * @generated
   * @ordered
   */
  protected EList<Graph> graphs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GraphvizModelImpl()
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
    return DotPackage.Literals.GRAPHVIZ_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Graph> getGraphs()
  {
    if (graphs == null)
    {
      graphs = new EObjectContainmentEList<Graph>(Graph.class, this, DotPackage.GRAPHVIZ_MODEL__GRAPHS);
    }
    return graphs;
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
      case DotPackage.GRAPHVIZ_MODEL__GRAPHS:
        return ((InternalEList<?>)getGraphs()).basicRemove(otherEnd, msgs);
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
      case DotPackage.GRAPHVIZ_MODEL__GRAPHS:
        return getGraphs();
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
      case DotPackage.GRAPHVIZ_MODEL__GRAPHS:
        getGraphs().clear();
        getGraphs().addAll((Collection<? extends Graph>)newValue);
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
      case DotPackage.GRAPHVIZ_MODEL__GRAPHS:
        getGraphs().clear();
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
      case DotPackage.GRAPHVIZ_MODEL__GRAPHS:
        return graphs != null && !graphs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //GraphvizModelImpl
