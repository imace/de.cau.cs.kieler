/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroupLayout;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>kNode Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kNodeGroupImpl#getSubNodeGroups <em>Sub Node Groups</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kNodeGroupImpl#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kNodeGroupImpl#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kNodeGroupImpl#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kNodeGroupImpl#getNodeGroupLayout <em>Node Group Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class kNodeGroupImpl extends EObjectImpl implements kNodeGroup {
	/**
	 * The cached value of the '{@link #getSubNodeGroups() <em>Sub Node Groups</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubNodeGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<kNodeGroup> subNodeGroups;

	/**
	 * The cached value of the '{@link #getOutgoingEdges() <em>Outgoing Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<kEdge> outgoingEdges;

	/**
	 * The cached value of the '{@link #getIncomingEdges() <em>Incoming Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<kEdge> incomingEdges;

	/**
	 * The cached value of the '{@link #getParentGroup() <em>Parent Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentGroup()
	 * @generated
	 * @ordered
	 */
	protected kNodeGroup parentGroup;

	/**
	 * The cached value of the '{@link #getNodeGroupLayout() <em>Node Group Layout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeGroupLayout()
	 * @generated
	 * @ordered
	 */
	protected kNodeGroupLayout nodeGroupLayout;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected kNodeGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KimlLayoutGraphPackage.Literals.KNODE_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<kNodeGroup> getSubNodeGroups() {
		if (subNodeGroups == null) {
			subNodeGroups = new EObjectResolvingEList<kNodeGroup>(kNodeGroup.class, this, KimlLayoutGraphPackage.KNODE_GROUP__SUB_NODE_GROUPS);
		}
		return subNodeGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<kEdge> getOutgoingEdges() {
		if (outgoingEdges == null) {
			outgoingEdges = new EObjectWithInverseResolvingEList<kEdge>(kEdge.class, this, KimlLayoutGraphPackage.KNODE_GROUP__OUTGOING_EDGES, KimlLayoutGraphPackage.KEDGE__SOURCE);
		}
		return outgoingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<kEdge> getIncomingEdges() {
		if (incomingEdges == null) {
			incomingEdges = new EObjectWithInverseResolvingEList<kEdge>(kEdge.class, this, KimlLayoutGraphPackage.KNODE_GROUP__INCOMING_EDGES, KimlLayoutGraphPackage.KEDGE__TARGET);
		}
		return incomingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kNodeGroup getParentGroup() {
		if (parentGroup != null && parentGroup.eIsProxy()) {
			InternalEObject oldParentGroup = (InternalEObject)parentGroup;
			parentGroup = (kNodeGroup)eResolveProxy(oldParentGroup);
			if (parentGroup != oldParentGroup) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KNODE_GROUP__PARENT_GROUP, oldParentGroup, parentGroup));
			}
		}
		return parentGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kNodeGroup basicGetParentGroup() {
		return parentGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentGroup(kNodeGroup newParentGroup) {
		kNodeGroup oldParentGroup = parentGroup;
		parentGroup = newParentGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KNODE_GROUP__PARENT_GROUP, oldParentGroup, parentGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kNodeGroupLayout getNodeGroupLayout() {
		if (nodeGroupLayout != null && nodeGroupLayout.eIsProxy()) {
			InternalEObject oldNodeGroupLayout = (InternalEObject)nodeGroupLayout;
			nodeGroupLayout = (kNodeGroupLayout)eResolveProxy(oldNodeGroupLayout);
			if (nodeGroupLayout != oldNodeGroupLayout) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KNODE_GROUP__NODE_GROUP_LAYOUT, oldNodeGroupLayout, nodeGroupLayout));
			}
		}
		return nodeGroupLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kNodeGroupLayout basicGetNodeGroupLayout() {
		return nodeGroupLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeGroupLayout(kNodeGroupLayout newNodeGroupLayout) {
		kNodeGroupLayout oldNodeGroupLayout = nodeGroupLayout;
		nodeGroupLayout = newNodeGroupLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KNODE_GROUP__NODE_GROUP_LAYOUT, oldNodeGroupLayout, nodeGroupLayout));
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
			case KimlLayoutGraphPackage.KNODE_GROUP__OUTGOING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingEdges()).basicAdd(otherEnd, msgs);
			case KimlLayoutGraphPackage.KNODE_GROUP__INCOMING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingEdges()).basicAdd(otherEnd, msgs);
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
			case KimlLayoutGraphPackage.KNODE_GROUP__OUTGOING_EDGES:
				return ((InternalEList<?>)getOutgoingEdges()).basicRemove(otherEnd, msgs);
			case KimlLayoutGraphPackage.KNODE_GROUP__INCOMING_EDGES:
				return ((InternalEList<?>)getIncomingEdges()).basicRemove(otherEnd, msgs);
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
			case KimlLayoutGraphPackage.KNODE_GROUP__SUB_NODE_GROUPS:
				return getSubNodeGroups();
			case KimlLayoutGraphPackage.KNODE_GROUP__OUTGOING_EDGES:
				return getOutgoingEdges();
			case KimlLayoutGraphPackage.KNODE_GROUP__INCOMING_EDGES:
				return getIncomingEdges();
			case KimlLayoutGraphPackage.KNODE_GROUP__PARENT_GROUP:
				if (resolve) return getParentGroup();
				return basicGetParentGroup();
			case KimlLayoutGraphPackage.KNODE_GROUP__NODE_GROUP_LAYOUT:
				if (resolve) return getNodeGroupLayout();
				return basicGetNodeGroupLayout();
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
			case KimlLayoutGraphPackage.KNODE_GROUP__SUB_NODE_GROUPS:
				getSubNodeGroups().clear();
				getSubNodeGroups().addAll((Collection<? extends kNodeGroup>)newValue);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				getOutgoingEdges().addAll((Collection<? extends kEdge>)newValue);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__INCOMING_EDGES:
				getIncomingEdges().clear();
				getIncomingEdges().addAll((Collection<? extends kEdge>)newValue);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__PARENT_GROUP:
				setParentGroup((kNodeGroup)newValue);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__NODE_GROUP_LAYOUT:
				setNodeGroupLayout((kNodeGroupLayout)newValue);
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
			case KimlLayoutGraphPackage.KNODE_GROUP__SUB_NODE_GROUPS:
				getSubNodeGroups().clear();
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__INCOMING_EDGES:
				getIncomingEdges().clear();
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__PARENT_GROUP:
				setParentGroup((kNodeGroup)null);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__NODE_GROUP_LAYOUT:
				setNodeGroupLayout((kNodeGroupLayout)null);
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
			case KimlLayoutGraphPackage.KNODE_GROUP__SUB_NODE_GROUPS:
				return subNodeGroups != null && !subNodeGroups.isEmpty();
			case KimlLayoutGraphPackage.KNODE_GROUP__OUTGOING_EDGES:
				return outgoingEdges != null && !outgoingEdges.isEmpty();
			case KimlLayoutGraphPackage.KNODE_GROUP__INCOMING_EDGES:
				return incomingEdges != null && !incomingEdges.isEmpty();
			case KimlLayoutGraphPackage.KNODE_GROUP__PARENT_GROUP:
				return parentGroup != null;
			case KimlLayoutGraphPackage.KNODE_GROUP__NODE_GROUP_LAYOUT:
				return nodeGroupLayout != null;
		}
		return super.eIsSet(featureID);
	}

} //kNodeGroupImpl
