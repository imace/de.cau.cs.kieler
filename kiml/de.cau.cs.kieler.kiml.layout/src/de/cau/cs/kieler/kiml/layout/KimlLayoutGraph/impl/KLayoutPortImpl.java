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
import org.eclipse.emf.ecore.util.EcoreUtil;

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
     * The cached value of the '{@link #getLayout() <em>Layout</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLayout()
     * @generated
     * @ordered
     */
	protected KPortLayout layout;

	/**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
	protected KPortLabel label;

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
        return layout;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetLayout(KPortLayout newLayout, NotificationChain msgs) {
        KPortLayout oldLayout = layout;
        layout = newLayout;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUT_PORT__LAYOUT, oldLayout, newLayout);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLayout(KPortLayout newLayout) {
        if (newLayout != layout) {
            NotificationChain msgs = null;
            if (layout != null)
                msgs = ((InternalEObject)layout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KLAYOUT_PORT__LAYOUT, null, msgs);
            if (newLayout != null)
                msgs = ((InternalEObject)newLayout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KLAYOUT_PORT__LAYOUT, null, msgs);
            msgs = basicSetLayout(newLayout, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUT_PORT__LAYOUT, newLayout, newLayout));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KPortLabel getLabel() {
        return label;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetLabel(KPortLabel newLabel, NotificationChain msgs) {
        KPortLabel oldLabel = label;
        label = newLabel;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUT_PORT__LABEL, oldLabel, newLabel);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLabel(KPortLabel newLabel) {
        if (newLabel != label) {
            NotificationChain msgs = null;
            if (label != null)
                msgs = ((InternalEObject)label).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KLAYOUT_PORT__LABEL, null, msgs);
            if (newLabel != null)
                msgs = ((InternalEObject)newLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KLAYOUT_PORT__LABEL, null, msgs);
            msgs = basicSetLabel(newLabel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUT_PORT__LABEL, newLabel, newLabel));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KLayoutNode getNode() {
        if (eContainerFeatureID != KimlLayoutGraphPackage.KLAYOUT_PORT__NODE) return null;
        return (KLayoutNode)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetNode(KLayoutNode newNode, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newNode, KimlLayoutGraphPackage.KLAYOUT_PORT__NODE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setNode(KLayoutNode newNode) {
        if (newNode != eInternalContainer() || (eContainerFeatureID != KimlLayoutGraphPackage.KLAYOUT_PORT__NODE && newNode != null)) {
            if (EcoreUtil.isAncestor(this, newNode))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
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
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
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
            case KimlLayoutGraphPackage.KLAYOUT_PORT__LAYOUT:
                return basicSetLayout(null, msgs);
            case KimlLayoutGraphPackage.KLAYOUT_PORT__LABEL:
                return basicSetLabel(null, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID) {
            case KimlLayoutGraphPackage.KLAYOUT_PORT__NODE:
                return eInternalContainer().eInverseRemove(this, KimlLayoutGraphPackage.KLAYOUT_NODE__PORTS, KLayoutNode.class, msgs);
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
            case KimlLayoutGraphPackage.KLAYOUT_PORT__LAYOUT:
                return getLayout();
            case KimlLayoutGraphPackage.KLAYOUT_PORT__LABEL:
                return getLabel();
            case KimlLayoutGraphPackage.KLAYOUT_PORT__NODE:
                return getNode();
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
                return getNode() != null;
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
