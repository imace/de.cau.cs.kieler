/**
 */
package de.cau.cs.kieler.kiml.graphviz.dot.dot.impl;

import de.cau.cs.kieler.kiml.graphviz.dot.dot.Attribute;
import de.cau.cs.kieler.kiml.graphviz.dot.dot.DotPackage;
import de.cau.cs.kieler.kiml.graphviz.dot.dot.EdgeStatement;
import de.cau.cs.kieler.kiml.graphviz.dot.dot.EdgeTarget;
import de.cau.cs.kieler.kiml.graphviz.dot.dot.Node;

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
 * An implementation of the model object '<em><b>Edge Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.graphviz.dot.dot.impl.EdgeStatementImpl#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.graphviz.dot.dot.impl.EdgeStatementImpl#getEdgeTargets <em>Edge Targets</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.graphviz.dot.dot.impl.EdgeStatementImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeStatementImpl extends StatementImpl implements EdgeStatement
{
  /**
   * The cached value of the '{@link #getSourceNode() <em>Source Node</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceNode()
   * @generated
   * @ordered
   */
  protected Node sourceNode;

  /**
   * The cached value of the '{@link #getEdgeTargets() <em>Edge Targets</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEdgeTargets()
   * @generated
   * @ordered
   */
  protected EList<EdgeTarget> edgeTargets;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EdgeStatementImpl()
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
    return DotPackage.Literals.EDGE_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node getSourceNode()
  {
    return sourceNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSourceNode(Node newSourceNode, NotificationChain msgs)
  {
    Node oldSourceNode = sourceNode;
    sourceNode = newSourceNode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DotPackage.EDGE_STATEMENT__SOURCE_NODE, oldSourceNode, newSourceNode);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSourceNode(Node newSourceNode)
  {
    if (newSourceNode != sourceNode)
    {
      NotificationChain msgs = null;
      if (sourceNode != null)
        msgs = ((InternalEObject)sourceNode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DotPackage.EDGE_STATEMENT__SOURCE_NODE, null, msgs);
      if (newSourceNode != null)
        msgs = ((InternalEObject)newSourceNode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DotPackage.EDGE_STATEMENT__SOURCE_NODE, null, msgs);
      msgs = basicSetSourceNode(newSourceNode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DotPackage.EDGE_STATEMENT__SOURCE_NODE, newSourceNode, newSourceNode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EdgeTarget> getEdgeTargets()
  {
    if (edgeTargets == null)
    {
      edgeTargets = new EObjectContainmentEList<EdgeTarget>(EdgeTarget.class, this, DotPackage.EDGE_STATEMENT__EDGE_TARGETS);
    }
    return edgeTargets;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, DotPackage.EDGE_STATEMENT__ATTRIBUTES);
    }
    return attributes;
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
      case DotPackage.EDGE_STATEMENT__SOURCE_NODE:
        return basicSetSourceNode(null, msgs);
      case DotPackage.EDGE_STATEMENT__EDGE_TARGETS:
        return ((InternalEList<?>)getEdgeTargets()).basicRemove(otherEnd, msgs);
      case DotPackage.EDGE_STATEMENT__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
      case DotPackage.EDGE_STATEMENT__SOURCE_NODE:
        return getSourceNode();
      case DotPackage.EDGE_STATEMENT__EDGE_TARGETS:
        return getEdgeTargets();
      case DotPackage.EDGE_STATEMENT__ATTRIBUTES:
        return getAttributes();
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
      case DotPackage.EDGE_STATEMENT__SOURCE_NODE:
        setSourceNode((Node)newValue);
        return;
      case DotPackage.EDGE_STATEMENT__EDGE_TARGETS:
        getEdgeTargets().clear();
        getEdgeTargets().addAll((Collection<? extends EdgeTarget>)newValue);
        return;
      case DotPackage.EDGE_STATEMENT__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
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
      case DotPackage.EDGE_STATEMENT__SOURCE_NODE:
        setSourceNode((Node)null);
        return;
      case DotPackage.EDGE_STATEMENT__EDGE_TARGETS:
        getEdgeTargets().clear();
        return;
      case DotPackage.EDGE_STATEMENT__ATTRIBUTES:
        getAttributes().clear();
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
      case DotPackage.EDGE_STATEMENT__SOURCE_NODE:
        return sourceNode != null;
      case DotPackage.EDGE_STATEMENT__EDGE_TARGETS:
        return edgeTargets != null && !edgeTargets.isEmpty();
      case DotPackage.EDGE_STATEMENT__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //EdgeStatementImpl
