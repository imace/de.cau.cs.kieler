/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;

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
 * An implementation of the model object '<em><b>KNode Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupImpl#getSubNodeGroups <em>Sub Node Groups</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupImpl#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupImpl#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupImpl#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupImpl#getLayout <em>Layout</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupImpl#getIdString <em>Id String</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupImpl#getPorts <em>Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KNodeGroupImpl extends EObjectImpl implements KNodeGroup {
	/**
	 * The cached value of the '{@link #getSubNodeGroups() <em>Sub Node Groups</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubNodeGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<KNodeGroup> subNodeGroups;

	/**
	 * The cached value of the '{@link #getOutgoingEdges() <em>Outgoing Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<KEdge> outgoingEdges;

	/**
	 * The cached value of the '{@link #getIncomingEdges() <em>Incoming Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<KEdge> incomingEdges;

	/**
	 * The cached value of the '{@link #getParentGroup() <em>Parent Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentGroup()
	 * @generated
	 * @ordered
	 */
	protected KNodeGroup parentGroup;

	/**
	 * The cached value of the '{@link #getLayout() <em>Layout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected KNodeGroupLayout layout;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected KNodeGroupLabel label;

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
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<KPort> ports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KNodeGroupImpl() {
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
	public EList<KNodeGroup> getSubNodeGroups() {
		if (subNodeGroups == null) {
			subNodeGroups = new EObjectWithInverseResolvingEList<KNodeGroup>(KNodeGroup.class, this, KimlLayoutGraphPackage.KNODE_GROUP__SUB_NODE_GROUPS, KimlLayoutGraphPackage.KNODE_GROUP__PARENT_GROUP);
		}
		return subNodeGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KEdge> getOutgoingEdges() {
		if (outgoingEdges == null) {
			outgoingEdges = new EObjectWithInverseResolvingEList<KEdge>(KEdge.class, this, KimlLayoutGraphPackage.KNODE_GROUP__OUTGOING_EDGES, KimlLayoutGraphPackage.KEDGE__SOURCE);
		}
		return outgoingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KEdge> getIncomingEdges() {
		if (incomingEdges == null) {
			incomingEdges = new EObjectWithInverseResolvingEList<KEdge>(KEdge.class, this, KimlLayoutGraphPackage.KNODE_GROUP__INCOMING_EDGES, KimlLayoutGraphPackage.KEDGE__TARGET);
		}
		return incomingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KNodeGroup getParentGroup() {
		if (parentGroup != null && parentGroup.eIsProxy()) {
			InternalEObject oldParentGroup = (InternalEObject)parentGroup;
			parentGroup = (KNodeGroup)eResolveProxy(oldParentGroup);
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
	public KNodeGroup basicGetParentGroup() {
		return parentGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentGroup(KNodeGroup newParentGroup, NotificationChain msgs) {
		KNodeGroup oldParentGroup = parentGroup;
		parentGroup = newParentGroup;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KNODE_GROUP__PARENT_GROUP, oldParentGroup, newParentGroup);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentGroup(KNodeGroup newParentGroup) {
		if (newParentGroup != parentGroup) {
			NotificationChain msgs = null;
			if (parentGroup != null)
				msgs = ((InternalEObject)parentGroup).eInverseRemove(this, KimlLayoutGraphPackage.KNODE_GROUP__SUB_NODE_GROUPS, KNodeGroup.class, msgs);
			if (newParentGroup != null)
				msgs = ((InternalEObject)newParentGroup).eInverseAdd(this, KimlLayoutGraphPackage.KNODE_GROUP__SUB_NODE_GROUPS, KNodeGroup.class, msgs);
			msgs = basicSetParentGroup(newParentGroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KNODE_GROUP__PARENT_GROUP, newParentGroup, newParentGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KNodeGroupLayout getLayout() {
		if (layout != null && layout.eIsProxy()) {
			InternalEObject oldLayout = (InternalEObject)layout;
			layout = (KNodeGroupLayout)eResolveProxy(oldLayout);
			if (layout != oldLayout) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KNODE_GROUP__LAYOUT, oldLayout, layout));
			}
		}
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KNodeGroupLayout basicGetLayout() {
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayout(KNodeGroupLayout newLayout) {
		KNodeGroupLayout oldLayout = layout;
		layout = newLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KNODE_GROUP__LAYOUT, oldLayout, layout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KNodeGroupLabel getLabel() {
		if (label != null && label.eIsProxy()) {
			InternalEObject oldLabel = (InternalEObject)label;
			label = (KNodeGroupLabel)eResolveProxy(oldLabel);
			if (label != oldLabel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KNODE_GROUP__LABEL, oldLabel, label));
			}
		}
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KNodeGroupLabel basicGetLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(KNodeGroupLabel newLabel) {
		KNodeGroupLabel oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KNODE_GROUP__LABEL, oldLabel, label));
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
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KNODE_GROUP__ID_STRING, oldIdString, idString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KPort> getPorts() {
		if (ports == null) {
			ports = new EObjectResolvingEList<KPort>(KPort.class, this, KimlLayoutGraphPackage.KNODE_GROUP__PORTS);
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
			case KimlLayoutGraphPackage.KNODE_GROUP__SUB_NODE_GROUPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubNodeGroups()).basicAdd(otherEnd, msgs);
			case KimlLayoutGraphPackage.KNODE_GROUP__OUTGOING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingEdges()).basicAdd(otherEnd, msgs);
			case KimlLayoutGraphPackage.KNODE_GROUP__INCOMING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingEdges()).basicAdd(otherEnd, msgs);
			case KimlLayoutGraphPackage.KNODE_GROUP__PARENT_GROUP:
				if (parentGroup != null)
					msgs = ((InternalEObject)parentGroup).eInverseRemove(this, KimlLayoutGraphPackage.KNODE_GROUP__SUB_NODE_GROUPS, KNodeGroup.class, msgs);
				return basicSetParentGroup((KNodeGroup)otherEnd, msgs);
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
			case KimlLayoutGraphPackage.KNODE_GROUP__SUB_NODE_GROUPS:
				return ((InternalEList<?>)getSubNodeGroups()).basicRemove(otherEnd, msgs);
			case KimlLayoutGraphPackage.KNODE_GROUP__OUTGOING_EDGES:
				return ((InternalEList<?>)getOutgoingEdges()).basicRemove(otherEnd, msgs);
			case KimlLayoutGraphPackage.KNODE_GROUP__INCOMING_EDGES:
				return ((InternalEList<?>)getIncomingEdges()).basicRemove(otherEnd, msgs);
			case KimlLayoutGraphPackage.KNODE_GROUP__PARENT_GROUP:
				return basicSetParentGroup(null, msgs);
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
			case KimlLayoutGraphPackage.KNODE_GROUP__LAYOUT:
				if (resolve) return getLayout();
				return basicGetLayout();
			case KimlLayoutGraphPackage.KNODE_GROUP__LABEL:
				if (resolve) return getLabel();
				return basicGetLabel();
			case KimlLayoutGraphPackage.KNODE_GROUP__ID_STRING:
				return getIdString();
			case KimlLayoutGraphPackage.KNODE_GROUP__PORTS:
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
			case KimlLayoutGraphPackage.KNODE_GROUP__SUB_NODE_GROUPS:
				getSubNodeGroups().clear();
				getSubNodeGroups().addAll((Collection<? extends KNodeGroup>)newValue);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				getOutgoingEdges().addAll((Collection<? extends KEdge>)newValue);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__INCOMING_EDGES:
				getIncomingEdges().clear();
				getIncomingEdges().addAll((Collection<? extends KEdge>)newValue);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__PARENT_GROUP:
				setParentGroup((KNodeGroup)newValue);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__LAYOUT:
				setLayout((KNodeGroupLayout)newValue);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__LABEL:
				setLabel((KNodeGroupLabel)newValue);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__ID_STRING:
				setIdString((String)newValue);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__PORTS:
				getPorts().clear();
				getPorts().addAll((Collection<? extends KPort>)newValue);
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
				setParentGroup((KNodeGroup)null);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__LAYOUT:
				setLayout((KNodeGroupLayout)null);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__LABEL:
				setLabel((KNodeGroupLabel)null);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__ID_STRING:
				setIdString(ID_STRING_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP__PORTS:
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
			case KimlLayoutGraphPackage.KNODE_GROUP__SUB_NODE_GROUPS:
				return subNodeGroups != null && !subNodeGroups.isEmpty();
			case KimlLayoutGraphPackage.KNODE_GROUP__OUTGOING_EDGES:
				return outgoingEdges != null && !outgoingEdges.isEmpty();
			case KimlLayoutGraphPackage.KNODE_GROUP__INCOMING_EDGES:
				return incomingEdges != null && !incomingEdges.isEmpty();
			case KimlLayoutGraphPackage.KNODE_GROUP__PARENT_GROUP:
				return parentGroup != null;
			case KimlLayoutGraphPackage.KNODE_GROUP__LAYOUT:
				return layout != null;
			case KimlLayoutGraphPackage.KNODE_GROUP__LABEL:
				return label != null;
			case KimlLayoutGraphPackage.KNODE_GROUP__ID_STRING:
				return ID_STRING_EDEFAULT == null ? idString != null : !ID_STRING_EDEFAULT.equals(idString);
			case KimlLayoutGraphPackage.KNODE_GROUP__PORTS:
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

} //KNodeGroupImpl
