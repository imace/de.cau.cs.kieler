/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>KLayoutEdge Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelImpl#getLabelLayout <em>Label Layout</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLabelImpl#getParentEdge <em>Parent Edge</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KEdgeLabelImpl extends KLabelImpl implements KEdgeLabel {
	/**
     * The cached value of the '{@link #getLabelLayout() <em>Label Layout</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLabelLayout()
     * @generated
     * @ordered
     */
	protected KEdgeLabelLayout labelLayout;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected KEdgeLabelImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return KimlLayoutGraphPackage.Literals.KEDGE_LABEL;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KEdgeLabelLayout getLabelLayout() {
        return labelLayout;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetLabelLayout(KEdgeLabelLayout newLabelLayout, NotificationChain msgs) {
        KEdgeLabelLayout oldLabelLayout = labelLayout;
        labelLayout = newLabelLayout;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE_LABEL__LABEL_LAYOUT, oldLabelLayout, newLabelLayout);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLabelLayout(KEdgeLabelLayout newLabelLayout) {
        if (newLabelLayout != labelLayout) {
            NotificationChain msgs = null;
            if (labelLayout != null)
                msgs = ((InternalEObject)labelLayout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KEDGE_LABEL__LABEL_LAYOUT, null, msgs);
            if (newLabelLayout != null)
                msgs = ((InternalEObject)newLabelLayout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KEDGE_LABEL__LABEL_LAYOUT, null, msgs);
            msgs = basicSetLabelLayout(newLabelLayout, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE_LABEL__LABEL_LAYOUT, newLabelLayout, newLabelLayout));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KLayoutEdge getParentEdge() {
        if (eContainerFeatureID != KimlLayoutGraphPackage.KEDGE_LABEL__PARENT_EDGE) return null;
        return (KLayoutEdge)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParentEdge(KLayoutEdge newParentEdge, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParentEdge, KimlLayoutGraphPackage.KEDGE_LABEL__PARENT_EDGE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParentEdge(KLayoutEdge newParentEdge) {
        if (newParentEdge != eInternalContainer() || (eContainerFeatureID != KimlLayoutGraphPackage.KEDGE_LABEL__PARENT_EDGE && newParentEdge != null)) {
            if (EcoreUtil.isAncestor(this, newParentEdge))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParentEdge != null)
                msgs = ((InternalEObject)newParentEdge).eInverseAdd(this, KimlLayoutGraphPackage.KLAYOUT_EDGE__LABEL, KLayoutEdge.class, msgs);
            msgs = basicSetParentEdge(newParentEdge, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE_LABEL__PARENT_EDGE, newParentEdge, newParentEdge));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case KimlLayoutGraphPackage.KEDGE_LABEL__PARENT_EDGE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParentEdge((KLayoutEdge)otherEnd, msgs);
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
            case KimlLayoutGraphPackage.KEDGE_LABEL__LABEL_LAYOUT:
                return basicSetLabelLayout(null, msgs);
            case KimlLayoutGraphPackage.KEDGE_LABEL__PARENT_EDGE:
                return basicSetParentEdge(null, msgs);
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
            case KimlLayoutGraphPackage.KEDGE_LABEL__PARENT_EDGE:
                return eInternalContainer().eInverseRemove(this, KimlLayoutGraphPackage.KLAYOUT_EDGE__LABEL, KLayoutEdge.class, msgs);
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
            case KimlLayoutGraphPackage.KEDGE_LABEL__LABEL_LAYOUT:
                return getLabelLayout();
            case KimlLayoutGraphPackage.KEDGE_LABEL__PARENT_EDGE:
                return getParentEdge();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case KimlLayoutGraphPackage.KEDGE_LABEL__LABEL_LAYOUT:
                setLabelLayout((KEdgeLabelLayout)newValue);
                return;
            case KimlLayoutGraphPackage.KEDGE_LABEL__PARENT_EDGE:
                setParentEdge((KLayoutEdge)newValue);
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
            case KimlLayoutGraphPackage.KEDGE_LABEL__LABEL_LAYOUT:
                setLabelLayout((KEdgeLabelLayout)null);
                return;
            case KimlLayoutGraphPackage.KEDGE_LABEL__PARENT_EDGE:
                setParentEdge((KLayoutEdge)null);
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
            case KimlLayoutGraphPackage.KEDGE_LABEL__LABEL_LAYOUT:
                return labelLayout != null;
            case KimlLayoutGraphPackage.KEDGE_LABEL__PARENT_EDGE:
                return getParentEdge() != null;
        }
        return super.eIsSet(featureID);
    }

} //KEdgeLabelImpl
