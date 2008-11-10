/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPortLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPortLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_TYPE;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>KPort</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KPortImpl#getLayout <em>Layout</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KPortImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KPortImpl#getNodeGroup <em>Node Group</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KPortImpl#getType <em>Type</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KPortImpl#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KPortImpl extends EObjectImpl implements KPort {
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
	 * The cached value of the '{@link #getNodeGroup() <em>Node Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeGroup()
	 * @generated
	 * @ordered
	 */
	protected KNodeGroup nodeGroup;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final PORT_TYPE TYPE_EDEFAULT = PORT_TYPE.DEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected PORT_TYPE type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<KEdge> edges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KimlLayoutGraphPackage.Literals.KPORT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KPORT__LAYOUT, oldLayout, layout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KPORT__LAYOUT, oldLayout, layout));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KPORT__LABEL, oldLabel, label));
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
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KPORT__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KNodeGroup getNodeGroup() {
		if (nodeGroup != null && nodeGroup.eIsProxy()) {
			InternalEObject oldNodeGroup = (InternalEObject)nodeGroup;
			nodeGroup = (KNodeGroup)eResolveProxy(oldNodeGroup);
			if (nodeGroup != oldNodeGroup) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KPORT__NODE_GROUP, oldNodeGroup, nodeGroup));
			}
		}
		return nodeGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KNodeGroup basicGetNodeGroup() {
		return nodeGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeGroup(KNodeGroup newNodeGroup) {
		KNodeGroup oldNodeGroup = nodeGroup;
		nodeGroup = newNodeGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KPORT__NODE_GROUP, oldNodeGroup, nodeGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PORT_TYPE getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(PORT_TYPE newType) {
		PORT_TYPE oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KPORT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KEdge> getEdges() {
		if (edges == null) {
			edges = new EObjectResolvingEList<KEdge>(KEdge.class, this, KimlLayoutGraphPackage.KPORT__EDGES);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KimlLayoutGraphPackage.KPORT__LAYOUT:
				if (resolve) return getLayout();
				return basicGetLayout();
			case KimlLayoutGraphPackage.KPORT__LABEL:
				if (resolve) return getLabel();
				return basicGetLabel();
			case KimlLayoutGraphPackage.KPORT__NODE_GROUP:
				if (resolve) return getNodeGroup();
				return basicGetNodeGroup();
			case KimlLayoutGraphPackage.KPORT__TYPE:
				return getType();
			case KimlLayoutGraphPackage.KPORT__EDGES:
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
			case KimlLayoutGraphPackage.KPORT__LAYOUT:
				setLayout((KPortLayout)newValue);
				return;
			case KimlLayoutGraphPackage.KPORT__LABEL:
				setLabel((KPortLabel)newValue);
				return;
			case KimlLayoutGraphPackage.KPORT__NODE_GROUP:
				setNodeGroup((KNodeGroup)newValue);
				return;
			case KimlLayoutGraphPackage.KPORT__TYPE:
				setType((PORT_TYPE)newValue);
				return;
			case KimlLayoutGraphPackage.KPORT__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends KEdge>)newValue);
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
			case KimlLayoutGraphPackage.KPORT__LAYOUT:
				setLayout((KPortLayout)null);
				return;
			case KimlLayoutGraphPackage.KPORT__LABEL:
				setLabel((KPortLabel)null);
				return;
			case KimlLayoutGraphPackage.KPORT__NODE_GROUP:
				setNodeGroup((KNodeGroup)null);
				return;
			case KimlLayoutGraphPackage.KPORT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.KPORT__EDGES:
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
			case KimlLayoutGraphPackage.KPORT__LAYOUT:
				return layout != null;
			case KimlLayoutGraphPackage.KPORT__LABEL:
				return label != null;
			case KimlLayoutGraphPackage.KPORT__NODE_GROUP:
				return nodeGroup != null;
			case KimlLayoutGraphPackage.KPORT__TYPE:
				return type != TYPE_EDEFAULT;
			case KimlLayoutGraphPackage.KPORT__EDGES:
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

} //KPortImpl
