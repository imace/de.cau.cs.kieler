/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>KNode Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutNodeImpl#getChildNodes <em>Child Nodes</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutNodeImpl#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutNodeImpl#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutNodeImpl#getParentNode <em>Parent Node</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutNodeImpl#getLayout <em>Layout</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutNodeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutNodeImpl#getIdString <em>Id String</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutNodeImpl#getPorts <em>Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KLayoutNodeImpl extends EObjectImpl implements KLayoutNode {
	/**
	 * The cached value of the '{@link #getChildNodes() <em>Child Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<KLayoutNode> childNodes;

	/**
	 * The cached value of the '{@link #getOutgoingEdges() <em>Outgoing Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<KLayoutEdge> outgoingEdges;

	/**
	 * The cached value of the '{@link #getIncomingEdges() <em>Incoming Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<KLayoutEdge> incomingEdges;

	/**
	 * The cached value of the '{@link #getLayout() <em>Layout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected KNodeLayout layout;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected KNodeLabel label;

	/**
	 * The default value of the '{@link #getIdString() <em>Id String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdString()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_STRING_EDEFAULT = "\"\"";

	/**
	 * The cached value of the '{@link #getIdString() <em>Id String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdString()
	 * @generated
	 * @ordered
	 */
	protected String idString = ID_STRING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<KLayoutPort> ports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KLayoutNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KimlLayoutGraphPackage.Literals.KLAYOUT_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KLayoutNode> getChildNodes() {
		if (childNodes == null) {
			childNodes = new EObjectContainmentWithInverseEList<KLayoutNode>(KLayoutNode.class, this, KimlLayoutGraphPackage.KLAYOUT_NODE__CHILD_NODES, KimlLayoutGraphPackage.KLAYOUT_NODE__PARENT_NODE);
		}
		return childNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KLayoutEdge> getOutgoingEdges() {
		if (outgoingEdges == null) {
			outgoingEdges = new EObjectWithInverseResolvingEList<KLayoutEdge>(KLayoutEdge.class, this, KimlLayoutGraphPackage.KLAYOUT_NODE__OUTGOING_EDGES, KimlLayoutGraphPackage.KLAYOUT_EDGE__SOURCE);
		}
		return outgoingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KLayoutEdge> getIncomingEdges() {
		if (incomingEdges == null) {
			incomingEdges = new EObjectWithInverseResolvingEList<KLayoutEdge>(KLayoutEdge.class, this, KimlLayoutGraphPackage.KLAYOUT_NODE__INCOMING_EDGES, KimlLayoutGraphPackage.KLAYOUT_EDGE__TARGET);
		}
		return incomingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KLayoutNode getParentNode() {
		if (eContainerFeatureID != KimlLayoutGraphPackage.KLAYOUT_NODE__PARENT_NODE) return null;
		return (KLayoutNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentNode(KLayoutNode newParentNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentNode, KimlLayoutGraphPackage.KLAYOUT_NODE__PARENT_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentNode(KLayoutNode newParentNode) {
		if (newParentNode != eInternalContainer() || (eContainerFeatureID != KimlLayoutGraphPackage.KLAYOUT_NODE__PARENT_NODE && newParentNode != null)) {
			if (EcoreUtil.isAncestor(this, newParentNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentNode != null)
				msgs = ((InternalEObject)newParentNode).eInverseAdd(this, KimlLayoutGraphPackage.KLAYOUT_NODE__CHILD_NODES, KLayoutNode.class, msgs);
			msgs = basicSetParentNode(newParentNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUT_NODE__PARENT_NODE, newParentNode, newParentNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KNodeLayout getLayout() {
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLayout(KNodeLayout newLayout, NotificationChain msgs) {
		KNodeLayout oldLayout = layout;
		layout = newLayout;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUT_NODE__LAYOUT, oldLayout, newLayout);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayout(KNodeLayout newLayout) {
		if (newLayout != layout) {
			NotificationChain msgs = null;
			if (layout != null)
				msgs = ((InternalEObject)layout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KLAYOUT_NODE__LAYOUT, null, msgs);
			if (newLayout != null)
				msgs = ((InternalEObject)newLayout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KLAYOUT_NODE__LAYOUT, null, msgs);
			msgs = basicSetLayout(newLayout, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUT_NODE__LAYOUT, newLayout, newLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KNodeLabel getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLabel(KNodeLabel newLabel, NotificationChain msgs) {
		KNodeLabel oldLabel = label;
		label = newLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUT_NODE__LABEL, oldLabel, newLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(KNodeLabel newLabel) {
		if (newLabel != label) {
			NotificationChain msgs = null;
			if (label != null)
				msgs = ((InternalEObject)label).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KLAYOUT_NODE__LABEL, null, msgs);
			if (newLabel != null)
				msgs = ((InternalEObject)newLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KLAYOUT_NODE__LABEL, null, msgs);
			msgs = basicSetLabel(newLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUT_NODE__LABEL, newLabel, newLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdString() {
		return idString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdString(String newIdString) {
		String oldIdString = idString;
		idString = newIdString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUT_NODE__ID_STRING, oldIdString, idString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KLayoutPort> getPorts() {
		if (ports == null) {
			ports = new EObjectContainmentWithInverseEList<KLayoutPort>(KLayoutPort.class, this, KimlLayoutGraphPackage.KLAYOUT_NODE__PORTS, KimlLayoutGraphPackage.KLAYOUT_PORT__NODE);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KimlLayoutGraphPackage.KLAYOUT_NODE__CHILD_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildNodes()).basicAdd(otherEnd, msgs);
			case KimlLayoutGraphPackage.KLAYOUT_NODE__OUTGOING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingEdges()).basicAdd(otherEnd, msgs);
			case KimlLayoutGraphPackage.KLAYOUT_NODE__INCOMING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingEdges()).basicAdd(otherEnd, msgs);
			case KimlLayoutGraphPackage.KLAYOUT_NODE__PARENT_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentNode((KLayoutNode)otherEnd, msgs);
			case KimlLayoutGraphPackage.KLAYOUT_NODE__PORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPorts()).basicAdd(otherEnd, msgs);
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
			case KimlLayoutGraphPackage.KLAYOUT_NODE__CHILD_NODES:
				return ((InternalEList<?>)getChildNodes()).basicRemove(otherEnd, msgs);
			case KimlLayoutGraphPackage.KLAYOUT_NODE__OUTGOING_EDGES:
				return ((InternalEList<?>)getOutgoingEdges()).basicRemove(otherEnd, msgs);
			case KimlLayoutGraphPackage.KLAYOUT_NODE__INCOMING_EDGES:
				return ((InternalEList<?>)getIncomingEdges()).basicRemove(otherEnd, msgs);
			case KimlLayoutGraphPackage.KLAYOUT_NODE__PARENT_NODE:
				return basicSetParentNode(null, msgs);
			case KimlLayoutGraphPackage.KLAYOUT_NODE__LAYOUT:
				return basicSetLayout(null, msgs);
			case KimlLayoutGraphPackage.KLAYOUT_NODE__LABEL:
				return basicSetLabel(null, msgs);
			case KimlLayoutGraphPackage.KLAYOUT_NODE__PORTS:
				return ((InternalEList<?>)getPorts()).basicRemove(otherEnd, msgs);
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
			case KimlLayoutGraphPackage.KLAYOUT_NODE__PARENT_NODE:
				return eInternalContainer().eInverseRemove(this, KimlLayoutGraphPackage.KLAYOUT_NODE__CHILD_NODES, KLayoutNode.class, msgs);
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
			case KimlLayoutGraphPackage.KLAYOUT_NODE__CHILD_NODES:
				return getChildNodes();
			case KimlLayoutGraphPackage.KLAYOUT_NODE__OUTGOING_EDGES:
				return getOutgoingEdges();
			case KimlLayoutGraphPackage.KLAYOUT_NODE__INCOMING_EDGES:
				return getIncomingEdges();
			case KimlLayoutGraphPackage.KLAYOUT_NODE__PARENT_NODE:
				return getParentNode();
			case KimlLayoutGraphPackage.KLAYOUT_NODE__LAYOUT:
				return getLayout();
			case KimlLayoutGraphPackage.KLAYOUT_NODE__LABEL:
				return getLabel();
			case KimlLayoutGraphPackage.KLAYOUT_NODE__ID_STRING:
				return getIdString();
			case KimlLayoutGraphPackage.KLAYOUT_NODE__PORTS:
				return getPorts();
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
			case KimlLayoutGraphPackage.KLAYOUT_NODE__CHILD_NODES:
				getChildNodes().clear();
				getChildNodes().addAll((Collection<? extends KLayoutNode>)newValue);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				getOutgoingEdges().addAll((Collection<? extends KLayoutEdge>)newValue);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__INCOMING_EDGES:
				getIncomingEdges().clear();
				getIncomingEdges().addAll((Collection<? extends KLayoutEdge>)newValue);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__PARENT_NODE:
				setParentNode((KLayoutNode)newValue);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__LAYOUT:
				setLayout((KNodeLayout)newValue);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__LABEL:
				setLabel((KNodeLabel)newValue);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__ID_STRING:
				setIdString((String)newValue);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__PORTS:
				getPorts().clear();
				getPorts().addAll((Collection<? extends KLayoutPort>)newValue);
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
			case KimlLayoutGraphPackage.KLAYOUT_NODE__CHILD_NODES:
				getChildNodes().clear();
				return;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				return;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__INCOMING_EDGES:
				getIncomingEdges().clear();
				return;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__PARENT_NODE:
				setParentNode((KLayoutNode)null);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__LAYOUT:
				setLayout((KNodeLayout)null);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__LABEL:
				setLabel((KNodeLabel)null);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__ID_STRING:
				setIdString(ID_STRING_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__PORTS:
				getPorts().clear();
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
			case KimlLayoutGraphPackage.KLAYOUT_NODE__CHILD_NODES:
				return childNodes != null && !childNodes.isEmpty();
			case KimlLayoutGraphPackage.KLAYOUT_NODE__OUTGOING_EDGES:
				return outgoingEdges != null && !outgoingEdges.isEmpty();
			case KimlLayoutGraphPackage.KLAYOUT_NODE__INCOMING_EDGES:
				return incomingEdges != null && !incomingEdges.isEmpty();
			case KimlLayoutGraphPackage.KLAYOUT_NODE__PARENT_NODE:
				return getParentNode() != null;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__LAYOUT:
				return layout != null;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__LABEL:
				return label != null;
			case KimlLayoutGraphPackage.KLAYOUT_NODE__ID_STRING:
				return ID_STRING_EDEFAULT == null ? idString != null : !ID_STRING_EDEFAULT.equals(idString);
			case KimlLayoutGraphPackage.KLAYOUT_NODE__PORTS:
				return ports != null && !ports.isEmpty();
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
		result.append(" (idString: ");
		result.append(idString);
		result.append(')');
		return result.toString();
	}

} //KLayoutNodeImpl
