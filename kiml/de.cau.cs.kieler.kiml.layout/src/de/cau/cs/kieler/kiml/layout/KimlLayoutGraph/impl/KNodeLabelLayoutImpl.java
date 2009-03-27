/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelPlacement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>KNode Group Label Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLabelLayoutImpl#getLabelPlacement <em>Label Placement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KNodeLabelLayoutImpl extends KShapeLayoutImpl implements KNodeLabelLayout {
	/**
     * The default value of the '{@link #getLabelPlacement() <em>Label Placement</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLabelPlacement()
     * @generated
     * @ordered
     */
	protected static final KNodeLabelPlacement LABEL_PLACEMENT_EDEFAULT = KNodeLabelPlacement.DEFAULT;

	/**
     * The cached value of the '{@link #getLabelPlacement() <em>Label Placement</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLabelPlacement()
     * @generated
     * @ordered
     */
	protected KNodeLabelPlacement labelPlacement = LABEL_PLACEMENT_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected KNodeLabelLayoutImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return KimlLayoutGraphPackage.Literals.KNODE_LABEL_LAYOUT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KNodeLabelPlacement getLabelPlacement() {
        return labelPlacement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLabelPlacement(KNodeLabelPlacement newLabelPlacement) {
        KNodeLabelPlacement oldLabelPlacement = labelPlacement;
        labelPlacement = newLabelPlacement == null ? LABEL_PLACEMENT_EDEFAULT : newLabelPlacement;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KNODE_LABEL_LAYOUT__LABEL_PLACEMENT, oldLabelPlacement, labelPlacement));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case KimlLayoutGraphPackage.KNODE_LABEL_LAYOUT__LABEL_PLACEMENT:
                return getLabelPlacement();
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
            case KimlLayoutGraphPackage.KNODE_LABEL_LAYOUT__LABEL_PLACEMENT:
                setLabelPlacement((KNodeLabelPlacement)newValue);
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
            case KimlLayoutGraphPackage.KNODE_LABEL_LAYOUT__LABEL_PLACEMENT:
                setLabelPlacement(LABEL_PLACEMENT_EDEFAULT);
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
            case KimlLayoutGraphPackage.KNODE_LABEL_LAYOUT__LABEL_PLACEMENT:
                return labelPlacement != LABEL_PLACEMENT_EDEFAULT;
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
        result.append(" (labelPlacement: ");
        result.append(labelPlacement);
        result.append(')');
        return result.toString();
    }

} //KNodeLabelLayoutImpl
