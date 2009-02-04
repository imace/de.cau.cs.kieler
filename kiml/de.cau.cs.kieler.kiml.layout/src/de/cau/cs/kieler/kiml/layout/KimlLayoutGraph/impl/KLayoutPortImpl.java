/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>KLayoutPort</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutPortImpl#getLayout <em>Layout</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutPortImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutPortImpl#getNode <em>Node</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutPortImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayoutPortImpl#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KLayoutPortImpl extends EObjectImpl implements KLayoutPort {
	/**
	 * The cached value of the '{@link #getLayout() <em>Layout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected KPortLayout layout;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected KPortLabel label;

	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected KLayoutNode node;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final KPortType TYPE_EDEFAULT = KPortType.DEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected KPortType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<KLayoutEdge> edges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KLayoutPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KimlLayoutGraphPackage.Literals.KLAYOUT_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KPortLayout getLayout() {
		if (layout != null && layout.eIsProxy()) {
			InternalEObject oldLayout = (InternalEObject)layout;
			layout = (KPortLayout)eResolveProxy(oldLayout);
			if (layout != oldLayout) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KLAYOUT_PORT__LAYOUT, oldLayout, layout));
			}
		}
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KPortLayout basicGetLayout() {
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayout(KPortLayout newLayout) {
		KPortLayout oldLayout = layout;
		layout = newLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUT_PORT__LAYOUT, oldLayout, layout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KPortLabel getLabel() {
		if (label != null && label.eIsProxy()) {
			InternalEObject oldLabel = (InternalEObject)label;
			label = (KPortLabel)eResolveProxy(oldLabel);
			if (label != oldLabel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KLAYOUT_PORT__LABEL, oldLabel, label));
			}
		}
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KPortLabel basicGetLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(KPortLabel newLabel) {
		KPortLabel oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUT_PORT__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KLayoutNode getNode() {
		if (node != null && node.eIsProxy()) {
			InternalEObject oldNode = (InternalEObject)node;
			node = (KLayoutNode)eResolveProxy(oldNode);
			if (node != oldNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KLAYOUT_PORT__NODE, oldNode, node));
			}
		}
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KLayoutNode basicGetNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode(KLayoutNode newNode, NotificationChain msgs) {
		KLayoutNode oldNode = node;
		node = newNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUT_PORT__NODE, oldNode, newNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(KLayoutNode newNode) {
		if (newNode != node) {
			NotificationChain msgs = null;
			if (node != null)
				msgs = ((InternalEObject)node).eInverseRemove(this, KimlLayoutGraphPackage.KLAYOUT_NODE__PORTS, KLayoutNode.class, msgs);
			if (newNode != null)
				msgs = ((InternalEObject)newNode).eInverseAdd(this, KimlLayoutGraphPackage.KLAYOUT_NODE__PORTS, KLayoutNode.class, msgs);
			msgs = basicSetNode(newNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUT_PORT__NODE, newNode, newNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KPortType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(KPortType newType) {
		KPortType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUT_PORT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KLayoutEdge> getEdges() {
		if (edges == null) {
			edges = new EObjectResolvingEList<KLayoutEdge>(KLayoutEdge.class, this, KimlLayoutGraphPackage.KLAYOUT_PORT__EDGES);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KimlLayoutGraphPackage.KLAYOUT_PORT__NODE:
				if (node != null)
					msgs = ((InternalEObject)node).eInverseRemove(this, KimlLayoutGraphPackage.KLAYOUT_NODE__PORTS, KLayoutNode.class, msgs);
				return basicSetNode((KLayoutNode)otherEnd, msgs);
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
			case KimlLayoutGraphPackage.KLAYOUT_PORT__NODE:
				return basicSetNode(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KimlLayoutGraphPackage.KLAYOUT_PORT__LAYOUT:
				if (resolve) return getLayout();
				return basicGetLayout();
			case KimlLayoutGraphPackage.KLAYOUT_PORT__LABEL:
				if (resolve) return getLabel();
				return basicGetLabel();
			case KimlLayoutGraphPackage.KLAYOUT_PORT__NODE:
				if (resolve) return getNode();
				return basicGetNode();
			case KimlLayoutGraphPackage.KLAYOUT_PORT__TYPE:
				return getType();
			case KimlLayoutGraphPackage.KLAYOUT_PORT__EDGES:
				return getEdges();
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
			case KimlLayoutGraphPackage.KLAYOUT_PORT__LAYOUT:
				setLayout((KPortLayout)newValue);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_PORT__LABEL:
				setLabel((KPortLabel)newValue);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_PORT__NODE:
				setNode((KLayoutNode)newValue);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_PORT__TYPE:
				setType((KPortType)newValue);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_PORT__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends KLayoutEdge>)newValue);
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
			case KimlLayoutGraphPackage.KLAYOUT_PORT__LAYOUT:
				setLayout((KPortLayout)null);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_PORT__LABEL:
				setLabel((KPortLabel)null);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_PORT__NODE:
				setNode((KLayoutNode)null);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_PORT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.KLAYOUT_PORT__EDGES:
				getEdges().clear();
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
			case KimlLayoutGraphPackage.KLAYOUT_PORT__LAYOUT:
				return layout != null;
			case KimlLayoutGraphPackage.KLAYOUT_PORT__LABEL:
				return label != null;
			case KimlLayoutGraphPackage.KLAYOUT_PORT__NODE:
				return node != null;
			case KimlLayoutGraphPackage.KLAYOUT_PORT__TYPE:
				return type != TYPE_EDEFAULT;
			case KimlLayoutGraphPackage.KLAYOUT_PORT__EDGES:
				return edges != null && !edges.isEmpty();
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //KLayoutPortImpl
