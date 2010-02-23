/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.graphs.impl;

import de.cau.cs.kieler.graphs.CompoundNode;
import de.cau.cs.kieler.graphs.Edge;
import de.cau.cs.kieler.graphs.GraphsPackage;
import de.cau.cs.kieler.graphs.Node;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compound Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.graphs.impl.CompoundNodeImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link de.cau.cs.kieler.graphs.impl.CompoundNodeImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link de.cau.cs.kieler.graphs.impl.CompoundNodeImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompoundNodeImpl extends GraphImpl implements CompoundNode {
	/**
     * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOutgoing()
     * @generated
     * @ordered
     */
	protected EList<Edge> outgoing;

	/**
     * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIncoming()
     * @generated
     * @ordered
     */
	protected EList<Edge> incoming;

	/**
     * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
	protected static final String LABEL_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
	protected String label = LABEL_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CompoundNodeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return GraphsPackage.Literals.COMPOUND_NODE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Edge> getOutgoing() {
        if (outgoing == null) {
            outgoing = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, GraphsPackage.COMPOUND_NODE__OUTGOING, GraphsPackage.EDGE__SOURCE);
        }
        return outgoing;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Edge> getIncoming() {
        if (incoming == null) {
            incoming = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, GraphsPackage.COMPOUND_NODE__INCOMING, GraphsPackage.EDGE__TARGET);
        }
        return incoming;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getLabel() {
        return label;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLabel(String newLabel) {
        String oldLabel = label;
        label = newLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphsPackage.COMPOUND_NODE__LABEL, oldLabel, label));
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
            case GraphsPackage.COMPOUND_NODE__OUTGOING:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
            case GraphsPackage.COMPOUND_NODE__INCOMING:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
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
            case GraphsPackage.COMPOUND_NODE__OUTGOING:
                return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
            case GraphsPackage.COMPOUND_NODE__INCOMING:
                return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
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
            case GraphsPackage.COMPOUND_NODE__OUTGOING:
                return getOutgoing();
            case GraphsPackage.COMPOUND_NODE__INCOMING:
                return getIncoming();
            case GraphsPackage.COMPOUND_NODE__LABEL:
                return getLabel();
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
            case GraphsPackage.COMPOUND_NODE__OUTGOING:
                getOutgoing().clear();
                getOutgoing().addAll((Collection<? extends Edge>)newValue);
                return;
            case GraphsPackage.COMPOUND_NODE__INCOMING:
                getIncoming().clear();
                getIncoming().addAll((Collection<? extends Edge>)newValue);
                return;
            case GraphsPackage.COMPOUND_NODE__LABEL:
                setLabel((String)newValue);
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
            case GraphsPackage.COMPOUND_NODE__OUTGOING:
                getOutgoing().clear();
                return;
            case GraphsPackage.COMPOUND_NODE__INCOMING:
                getIncoming().clear();
                return;
            case GraphsPackage.COMPOUND_NODE__LABEL:
                setLabel(LABEL_EDEFAULT);
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
            case GraphsPackage.COMPOUND_NODE__OUTGOING:
                return outgoing != null && !outgoing.isEmpty();
            case GraphsPackage.COMPOUND_NODE__INCOMING:
                return incoming != null && !incoming.isEmpty();
            case GraphsPackage.COMPOUND_NODE__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == Node.class) {
            switch (derivedFeatureID) {
                case GraphsPackage.COMPOUND_NODE__OUTGOING: return GraphsPackage.NODE__OUTGOING;
                case GraphsPackage.COMPOUND_NODE__INCOMING: return GraphsPackage.NODE__INCOMING;
                case GraphsPackage.COMPOUND_NODE__LABEL: return GraphsPackage.NODE__LABEL;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == Node.class) {
            switch (baseFeatureID) {
                case GraphsPackage.NODE__OUTGOING: return GraphsPackage.COMPOUND_NODE__OUTGOING;
                case GraphsPackage.NODE__INCOMING: return GraphsPackage.COMPOUND_NODE__INCOMING;
                case GraphsPackage.NODE__LABEL: return GraphsPackage.COMPOUND_NODE__LABEL;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
        result.append(" (label: ");
        result.append(label);
        result.append(')');
        return result.toString();
    }

} //CompoundNodeImpl
