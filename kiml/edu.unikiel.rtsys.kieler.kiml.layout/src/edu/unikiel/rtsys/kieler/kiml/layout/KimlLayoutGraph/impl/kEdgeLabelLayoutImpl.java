/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.EDGE_LABEL_PLACEMENT;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabelLayout;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>kEdge Label Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeLabelLayoutImpl#getEdgeLabelPlacement <em>Edge Label Placement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class kEdgeLabelLayoutImpl extends kShapeLayoutImpl implements kEdgeLabelLayout {
	/**
	 * The default value of the '{@link #getEdgeLabelPlacement() <em>Edge Label Placement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeLabelPlacement()
	 * @generated
	 * @ordered
	 */
	protected static final EDGE_LABEL_PLACEMENT EDGE_LABEL_PLACEMENT_EDEFAULT = EDGE_LABEL_PLACEMENT.ANYWHERE;

	/**
	 * The cached value of the '{@link #getEdgeLabelPlacement() <em>Edge Label Placement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeLabelPlacement()
	 * @generated
	 * @ordered
	 */
	protected EDGE_LABEL_PLACEMENT edgeLabelPlacement = EDGE_LABEL_PLACEMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected kEdgeLabelLayoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KimlLayoutGraphPackage.Literals.KEDGE_LABEL_LAYOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDGE_LABEL_PLACEMENT getEdgeLabelPlacement() {
		return edgeLabelPlacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeLabelPlacement(EDGE_LABEL_PLACEMENT newEdgeLabelPlacement) {
		EDGE_LABEL_PLACEMENT oldEdgeLabelPlacement = edgeLabelPlacement;
		edgeLabelPlacement = newEdgeLabelPlacement == null ? EDGE_LABEL_PLACEMENT_EDEFAULT : newEdgeLabelPlacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE_LABEL_LAYOUT__EDGE_LABEL_PLACEMENT, oldEdgeLabelPlacement, edgeLabelPlacement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KimlLayoutGraphPackage.KEDGE_LABEL_LAYOUT__EDGE_LABEL_PLACEMENT:
				return getEdgeLabelPlacement();
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
			case KimlLayoutGraphPackage.KEDGE_LABEL_LAYOUT__EDGE_LABEL_PLACEMENT:
				setEdgeLabelPlacement((EDGE_LABEL_PLACEMENT)newValue);
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
			case KimlLayoutGraphPackage.KEDGE_LABEL_LAYOUT__EDGE_LABEL_PLACEMENT:
				setEdgeLabelPlacement(EDGE_LABEL_PLACEMENT_EDEFAULT);
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
			case KimlLayoutGraphPackage.KEDGE_LABEL_LAYOUT__EDGE_LABEL_PLACEMENT:
				return edgeLabelPlacement != EDGE_LABEL_PLACEMENT_EDEFAULT;
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
		result.append(" (edgeLabelPlacement: ");
		result.append(edgeLabelPlacement);
		result.append(')');
		return result.toString();
	}

} //kEdgeLabelLayoutImpl
