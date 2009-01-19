/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.EDGE_TYPE;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;

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
 * An implementation of the model object '<em><b>KEdge Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl#getSourcePoint <em>Source Point</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl#getTargetPoint <em>Target Point</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl#getGridPoints <em>Grid Points</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl#getEdgeType <em>Edge Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KEdgeLayoutImpl#isUseLayout <em>Use Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KEdgeLayoutImpl extends EObjectImpl implements KEdgeLayout {
	/**
	 * The cached value of the '{@link #getSourcePoint() <em>Source Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePoint()
	 * @generated
	 * @ordered
	 */
	protected KPoint sourcePoint;

	/**
	 * The cached value of the '{@link #getTargetPoint() <em>Target Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPoint()
	 * @generated
	 * @ordered
	 */
	protected KPoint targetPoint;

	/**
	 * The cached value of the '{@link #getGridPoints() <em>Grid Points</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGridPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<KPoint> gridPoints;

	/**
	 * The default value of the '{@link #getEdgeType() <em>Edge Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeType()
	 * @generated
	 * @ordered
	 */
	protected static final EDGE_TYPE EDGE_TYPE_EDEFAULT = EDGE_TYPE.DEFAULT;

	/**
	 * The cached value of the '{@link #getEdgeType() <em>Edge Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeType()
	 * @generated
	 * @ordered
	 */
	protected EDGE_TYPE edgeType = EDGE_TYPE_EDEFAULT;

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
		if (sourcePoint != null && sourcePoint.eIsProxy()) {
			InternalEObject oldSourcePoint = (InternalEObject)sourcePoint;
			sourcePoint = (KPoint)eResolveProxy(oldSourcePoint);
			if (sourcePoint != oldSourcePoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KEDGE_LAYOUT__SOURCE_POINT, oldSourcePoint, sourcePoint));
			}
		}
		return sourcePoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KPoint basicGetSourcePoint() {
		return sourcePoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourcePoint(KPoint newSourcePoint) {
		KPoint oldSourcePoint = sourcePoint;
		sourcePoint = newSourcePoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE_LAYOUT__SOURCE_POINT, oldSourcePoint, sourcePoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KPoint getTargetPoint() {
		if (targetPoint != null && targetPoint.eIsProxy()) {
			InternalEObject oldTargetPoint = (InternalEObject)targetPoint;
			targetPoint = (KPoint)eResolveProxy(oldTargetPoint);
			if (targetPoint != oldTargetPoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KEDGE_LAYOUT__TARGET_POINT, oldTargetPoint, targetPoint));
			}
		}
		return targetPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KPoint basicGetTargetPoint() {
		return targetPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPoint(KPoint newTargetPoint) {
		KPoint oldTargetPoint = targetPoint;
		targetPoint = newTargetPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE_LAYOUT__TARGET_POINT, oldTargetPoint, targetPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KPoint> getGridPoints() {
		if (gridPoints == null) {
			gridPoints = new EObjectResolvingEList<KPoint>(KPoint.class, this, KimlLayoutGraphPackage.KEDGE_LAYOUT__GRID_POINTS);
		}
		return gridPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDGE_TYPE getEdgeType() {
		return edgeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeType(EDGE_TYPE newEdgeType) {
		EDGE_TYPE oldEdgeType = edgeType;
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KimlLayoutGraphPackage.KEDGE_LAYOUT__SOURCE_POINT:
				if (resolve) return getSourcePoint();
				return basicGetSourcePoint();
			case KimlLayoutGraphPackage.KEDGE_LAYOUT__TARGET_POINT:
				if (resolve) return getTargetPoint();
				return basicGetTargetPoint();
			case KimlLayoutGraphPackage.KEDGE_LAYOUT__GRID_POINTS:
				return getGridPoints();
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
			case KimlLayoutGraphPackage.KEDGE_LAYOUT__GRID_POINTS:
				getGridPoints().clear();
				getGridPoints().addAll((Collection<? extends KPoint>)newValue);
				return;
			case KimlLayoutGraphPackage.KEDGE_LAYOUT__EDGE_TYPE:
				setEdgeType((EDGE_TYPE)newValue);
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
			case KimlLayoutGraphPackage.KEDGE_LAYOUT__GRID_POINTS:
				getGridPoints().clear();
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
			case KimlLayoutGraphPackage.KEDGE_LAYOUT__GRID_POINTS:
				return gridPoints != null && !gridPoints.isEmpty();
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
