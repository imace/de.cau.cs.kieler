/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeType;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;

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
 * An implementation of the model object '<em><b>KLayoutEdge Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl#getSourcePoint <em>Source Point</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl#getTargetPoint <em>Target Point</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl#getBendPoints <em>Bend Points</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl#getEdgeType <em>Edge Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl#isUseLayout <em>Use Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KEdgeLayoutImpl extends EObjectImpl implements KEdgeLayout {
	/**
     * The cached value of the '{@link #getSourcePoint() <em>Source Point</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSourcePoint()
     * @generated
     * @ordered
     */
	protected KPoint sourcePoint;

	/**
     * The cached value of the '{@link #getTargetPoint() <em>Target Point</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTargetPoint()
     * @generated
     * @ordered
     */
	protected KPoint targetPoint;

	/**
     * The cached value of the '{@link #getBendPoints() <em>Bend Points</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBendPoints()
     * @generated
     * @ordered
     */
	protected EList<KPoint> bendPoints;

	/**
     * The default value of the '{@link #getEdgeType() <em>Edge Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEdgeType()
     * @generated
     * @ordered
     */
	protected static final KEdgeType EDGE_TYPE_EDEFAULT = KEdgeType.DEFAULT;

	/**
     * The cached value of the '{@link #getEdgeType() <em>Edge Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEdgeType()
     * @generated
     * @ordered
     */
	protected KEdgeType edgeType = EDGE_TYPE_EDEFAULT;

	/**
     * The default value of the '{@link #isUseLayout() <em>Use Layout</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isUseLayout()
     * @generated
     * @ordered
     */
	protected static final boolean USE_LAYOUT_EDEFAULT = true;

	/**
     * The cached value of the '{@link #isUseLayout() <em>Use Layout</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isUseLayout()
     * @generated
     * @ordered
     */
	protected boolean useLayout = USE_LAYOUT_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected KEdgeLayoutImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return KimlLayoutGraphPackage.Literals.KEDGE_LAYOUT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KPoint getSourcePoint() {
        return sourcePoint;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSourcePoint(KPoint newSourcePoint, NotificationChain msgs) {
        KPoint oldSourcePoint = sourcePoint;
        sourcePoint = newSourcePoint;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE_LAYOUT__SOURCE_POINT, oldSourcePoint, newSourcePoint);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSourcePoint(KPoint newSourcePoint) {
        if (newSourcePoint != sourcePoint) {
            NotificationChain msgs = null;
            if (sourcePoint != null)
                msgs = ((InternalEObject)sourcePoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KEDGE_LAYOUT__SOURCE_POINT, null, msgs);
            if (newSourcePoint != null)
                msgs = ((InternalEObject)newSourcePoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KEDGE_LAYOUT__SOURCE_POINT, null, msgs);
            msgs = basicSetSourcePoint(newSourcePoint, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE_LAYOUT__SOURCE_POINT, newSourcePoint, newSourcePoint));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KPoint getTargetPoint() {
        return targetPoint;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetTargetPoint(KPoint newTargetPoint, NotificationChain msgs) {
        KPoint oldTargetPoint = targetPoint;
        targetPoint = newTargetPoint;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE_LAYOUT__TARGET_POINT, oldTargetPoint, newTargetPoint);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTargetPoint(KPoint newTargetPoint) {
        if (newTargetPoint != targetPoint) {
            NotificationChain msgs = null;
            if (targetPoint != null)
                msgs = ((InternalEObject)targetPoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KEDGE_LAYOUT__TARGET_POINT, null, msgs);
            if (newTargetPoint != null)
                msgs = ((InternalEObject)newTargetPoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KEDGE_LAYOUT__TARGET_POINT, null, msgs);
            msgs = basicSetTargetPoint(newTargetPoint, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE_LAYOUT__TARGET_POINT, newTargetPoint, newTargetPoint));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<KPoint> getBendPoints() {
        if (bendPoints == null) {
            bendPoints = new EObjectResolvingEList<KPoint>(KPoint.class, this, KimlLayoutGraphPackage.KEDGE_LAYOUT__BEND_POINTS);
        }
        return bendPoints;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KEdgeType getEdgeType() {
        return edgeType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEdgeType(KEdgeType newEdgeType) {
        KEdgeType oldEdgeType = edgeType;
        edgeType = newEdgeType == null ? EDGE_TYPE_EDEFAULT : newEdgeType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE_LAYOUT__EDGE_TYPE, oldEdgeType, edgeType));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isUseLayout() {
        return useLayout;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setUseLayout(boolean newUseLayout) {
        boolean oldUseLayout = useLayout;
        useLayout = newUseLayout;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE_LAYOUT__USE_LAYOUT, oldUseLayout, useLayout));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__SOURCE_POINT:
                return basicSetSourcePoint(null, msgs);
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__TARGET_POINT:
                return basicSetTargetPoint(null, msgs);
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
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__SOURCE_POINT:
                return getSourcePoint();
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__TARGET_POINT:
                return getTargetPoint();
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__BEND_POINTS:
                return getBendPoints();
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__EDGE_TYPE:
                return getEdgeType();
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__USE_LAYOUT:
                return isUseLayout() ? Boolean.TRUE : Boolean.FALSE;
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
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__SOURCE_POINT:
                setSourcePoint((KPoint)newValue);
                return;
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__TARGET_POINT:
                setTargetPoint((KPoint)newValue);
                return;
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__BEND_POINTS:
                getBendPoints().clear();
                getBendPoints().addAll((Collection<? extends KPoint>)newValue);
                return;
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__EDGE_TYPE:
                setEdgeType((KEdgeType)newValue);
                return;
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__USE_LAYOUT:
                setUseLayout(((Boolean)newValue).booleanValue());
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
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__SOURCE_POINT:
                setSourcePoint((KPoint)null);
                return;
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__TARGET_POINT:
                setTargetPoint((KPoint)null);
                return;
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__BEND_POINTS:
                getBendPoints().clear();
                return;
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__EDGE_TYPE:
                setEdgeType(EDGE_TYPE_EDEFAULT);
                return;
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__USE_LAYOUT:
                setUseLayout(USE_LAYOUT_EDEFAULT);
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
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__SOURCE_POINT:
                return sourcePoint != null;
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__TARGET_POINT:
                return targetPoint != null;
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__BEND_POINTS:
                return bendPoints != null && !bendPoints.isEmpty();
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__EDGE_TYPE:
                return edgeType != EDGE_TYPE_EDEFAULT;
            case KimlLayoutGraphPackage.KEDGE_LAYOUT__USE_LAYOUT:
                return useLayout != USE_LAYOUT_EDEFAULT;
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
        result.append(" (edgeType: ");
        result.append(edgeType);
        result.append(", useLayout: ");
        result.append(useLayout);
        result.append(')');
        return result.toString();
    }

} //KEdgeLayoutImpl
