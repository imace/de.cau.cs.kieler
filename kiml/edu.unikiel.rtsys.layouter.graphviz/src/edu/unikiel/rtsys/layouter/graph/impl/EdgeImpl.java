/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.layouter.graph.impl;

import edu.unikiel.rtsys.layouter.graph.Coordinates;
import edu.unikiel.rtsys.layouter.graph.Edge;
import edu.unikiel.rtsys.layouter.graph.Graph;
import edu.unikiel.rtsys.layouter.graph.GraphPackage;
import edu.unikiel.rtsys.layouter.graph.Label;
import edu.unikiel.rtsys.layouter.graph.Node;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.impl.EdgeImpl#getParentGraph <em>Parent Graph</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.impl.EdgeImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.impl.EdgeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.impl.EdgeImpl#getBendpoints <em>Bendpoints</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.impl.EdgeImpl#getData <em>Data</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.impl.EdgeImpl#getEdgeLabel <em>Edge Label</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.impl.EdgeImpl#getHeadLabel <em>Head Label</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.layouter.graph.impl.EdgeImpl#getTailLabel <em>Tail Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeImpl extends EObjectImpl implements Edge {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Node target;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Node source;

	/**
	 * The cached value of the '{@link #getBendpoints() <em>Bendpoints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBendpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<Coordinates> bendpoints;

	/**
	 * The default value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected static final Object DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected Object data = DATA_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEdgeLabel() <em>Edge Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeLabel()
	 * @generated
	 * @ordered
	 */
	protected Label edgeLabel;

	/**
	 * The cached value of the '{@link #getHeadLabel() <em>Head Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadLabel()
	 * @generated
	 * @ordered
	 */
	protected Label headLabel;

	/**
	 * The cached value of the '{@link #getTailLabel() <em>Tail Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTailLabel()
	 * @generated
	 * @ordered
	 */
	protected Label tailLabel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getParentGraph() {
		if (eContainerFeatureID != GraphPackage.EDGE__PARENT_GRAPH) return null;
		return (Graph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentGraph(Graph newParentGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentGraph, GraphPackage.EDGE__PARENT_GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentGraph(Graph newParentGraph) {
		if (newParentGraph != eInternalContainer() || (eContainerFeatureID != GraphPackage.EDGE__PARENT_GRAPH && newParentGraph != null)) {
			if (EcoreUtil.isAncestor(this, newParentGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentGraph != null)
				msgs = ((InternalEObject)newParentGraph).eInverseAdd(this, GraphPackage.GRAPH__EDGES, Graph.class, msgs);
			msgs = basicSetParentGraph(newParentGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__PARENT_GRAPH, newParentGraph, newParentGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Node)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.EDGE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(Node newTarget, NotificationChain msgs) {
		Node oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Node newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, GraphPackage.NODE__INCOMING_EDGES, Node.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, GraphPackage.NODE__INCOMING_EDGES, Node.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Node)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.EDGE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Node newSource, NotificationChain msgs) {
		Node oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Node newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, GraphPackage.NODE__OUTGOING_EDGES, Node.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, GraphPackage.NODE__OUTGOING_EDGES, Node.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Coordinates> getBendpoints() {
		if (bendpoints == null) {
			bendpoints = new EObjectContainmentEList<Coordinates>(Coordinates.class, this, GraphPackage.EDGE__BENDPOINTS);
		}
		return bendpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getData() {
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(Object newData) {
		Object oldData = data;
		data = newData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__DATA, oldData, data));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getEdgeLabel() {
		return edgeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEdgeLabel(Label newEdgeLabel, NotificationChain msgs) {
		Label oldEdgeLabel = edgeLabel;
		edgeLabel = newEdgeLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__EDGE_LABEL, oldEdgeLabel, newEdgeLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeLabel(Label newEdgeLabel) {
		if (newEdgeLabel != edgeLabel) {
			NotificationChain msgs = null;
			if (edgeLabel != null)
				msgs = ((InternalEObject)edgeLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphPackage.EDGE__EDGE_LABEL, null, msgs);
			if (newEdgeLabel != null)
				msgs = ((InternalEObject)newEdgeLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphPackage.EDGE__EDGE_LABEL, null, msgs);
			msgs = basicSetEdgeLabel(newEdgeLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__EDGE_LABEL, newEdgeLabel, newEdgeLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getHeadLabel() {
		return headLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeadLabel(Label newHeadLabel, NotificationChain msgs) {
		Label oldHeadLabel = headLabel;
		headLabel = newHeadLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__HEAD_LABEL, oldHeadLabel, newHeadLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeadLabel(Label newHeadLabel) {
		if (newHeadLabel != headLabel) {
			NotificationChain msgs = null;
			if (headLabel != null)
				msgs = ((InternalEObject)headLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphPackage.EDGE__HEAD_LABEL, null, msgs);
			if (newHeadLabel != null)
				msgs = ((InternalEObject)newHeadLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphPackage.EDGE__HEAD_LABEL, null, msgs);
			msgs = basicSetHeadLabel(newHeadLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__HEAD_LABEL, newHeadLabel, newHeadLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getTailLabel() {
		return tailLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTailLabel(Label newTailLabel, NotificationChain msgs) {
		Label oldTailLabel = tailLabel;
		tailLabel = newTailLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__TAIL_LABEL, oldTailLabel, newTailLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTailLabel(Label newTailLabel) {
		if (newTailLabel != tailLabel) {
			NotificationChain msgs = null;
			if (tailLabel != null)
				msgs = ((InternalEObject)tailLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphPackage.EDGE__TAIL_LABEL, null, msgs);
			if (newTailLabel != null)
				msgs = ((InternalEObject)newTailLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphPackage.EDGE__TAIL_LABEL, null, msgs);
			msgs = basicSetTailLabel(newTailLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__TAIL_LABEL, newTailLabel, newTailLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.EDGE__PARENT_GRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentGraph((Graph)otherEnd, msgs);
			case GraphPackage.EDGE__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, GraphPackage.NODE__INCOMING_EDGES, Node.class, msgs);
				return basicSetTarget((Node)otherEnd, msgs);
			case GraphPackage.EDGE__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, GraphPackage.NODE__OUTGOING_EDGES, Node.class, msgs);
				return basicSetSource((Node)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.EDGE__PARENT_GRAPH:
				return basicSetParentGraph(null, msgs);
			case GraphPackage.EDGE__TARGET:
				return basicSetTarget(null, msgs);
			case GraphPackage.EDGE__SOURCE:
				return basicSetSource(null, msgs);
			case GraphPackage.EDGE__BENDPOINTS:
				return ((InternalEList<?>)getBendpoints()).basicRemove(otherEnd, msgs);
			case GraphPackage.EDGE__EDGE_LABEL:
				return basicSetEdgeLabel(null, msgs);
			case GraphPackage.EDGE__HEAD_LABEL:
				return basicSetHeadLabel(null, msgs);
			case GraphPackage.EDGE__TAIL_LABEL:
				return basicSetTailLabel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case GraphPackage.EDGE__PARENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, GraphPackage.GRAPH__EDGES, Graph.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphPackage.EDGE__PARENT_GRAPH:
				return getParentGraph();
			case GraphPackage.EDGE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case GraphPackage.EDGE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case GraphPackage.EDGE__BENDPOINTS:
				return getBendpoints();
			case GraphPackage.EDGE__DATA:
				return getData();
			case GraphPackage.EDGE__EDGE_LABEL:
				return getEdgeLabel();
			case GraphPackage.EDGE__HEAD_LABEL:
				return getHeadLabel();
			case GraphPackage.EDGE__TAIL_LABEL:
				return getTailLabel();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphPackage.EDGE__PARENT_GRAPH:
				setParentGraph((Graph)newValue);
				return;
			case GraphPackage.EDGE__TARGET:
				setTarget((Node)newValue);
				return;
			case GraphPackage.EDGE__SOURCE:
				setSource((Node)newValue);
				return;
			case GraphPackage.EDGE__BENDPOINTS:
				getBendpoints().clear();
				getBendpoints().addAll((Collection<? extends Coordinates>)newValue);
				return;
			case GraphPackage.EDGE__DATA:
				setData(newValue);
				return;
			case GraphPackage.EDGE__EDGE_LABEL:
				setEdgeLabel((Label)newValue);
				return;
			case GraphPackage.EDGE__HEAD_LABEL:
				setHeadLabel((Label)newValue);
				return;
			case GraphPackage.EDGE__TAIL_LABEL:
				setTailLabel((Label)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraphPackage.EDGE__PARENT_GRAPH:
				setParentGraph((Graph)null);
				return;
			case GraphPackage.EDGE__TARGET:
				setTarget((Node)null);
				return;
			case GraphPackage.EDGE__SOURCE:
				setSource((Node)null);
				return;
			case GraphPackage.EDGE__BENDPOINTS:
				getBendpoints().clear();
				return;
			case GraphPackage.EDGE__DATA:
				setData(DATA_EDEFAULT);
				return;
			case GraphPackage.EDGE__EDGE_LABEL:
				setEdgeLabel((Label)null);
				return;
			case GraphPackage.EDGE__HEAD_LABEL:
				setHeadLabel((Label)null);
				return;
			case GraphPackage.EDGE__TAIL_LABEL:
				setTailLabel((Label)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphPackage.EDGE__PARENT_GRAPH:
				return getParentGraph() != null;
			case GraphPackage.EDGE__TARGET:
				return target != null;
			case GraphPackage.EDGE__SOURCE:
				return source != null;
			case GraphPackage.EDGE__BENDPOINTS:
				return bendpoints != null && !bendpoints.isEmpty();
			case GraphPackage.EDGE__DATA:
				return DATA_EDEFAULT == null ? data != null : !DATA_EDEFAULT.equals(data);
			case GraphPackage.EDGE__EDGE_LABEL:
				return edgeLabel != null;
			case GraphPackage.EDGE__HEAD_LABEL:
				return headLabel != null;
			case GraphPackage.EDGE__TAIL_LABEL:
				return tailLabel != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (data: ");
		result.append(data);
		result.append(')');
		return result.toString();
	}

} //EdgeImpl
