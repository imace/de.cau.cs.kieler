/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortPlacement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>KLayoutPort Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPortLayoutImpl#getPlacement <em>Placement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KPortLayoutImpl extends KShapeLayoutImpl implements KPortLayout {
	/**
     * The default value of the '{@link #getPlacement() <em>Placement</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPlacement()
     * @generated
     * @ordered
     */
	protected static final KPortPlacement PLACEMENT_EDEFAULT = KPortPlacement.DEFAULT;

	/**
     * The cached value of the '{@link #getPlacement() <em>Placement</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPlacement()
     * @generated
     * @ordered
     */
	protected KPortPlacement placement = PLACEMENT_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected KPortLayoutImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return KimlLayoutGraphPackage.Literals.KPORT_LAYOUT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KPortPlacement getPlacement() {
        return placement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPlacement(KPortPlacement newPlacement) {
        KPortPlacement oldPlacement = placement;
        placement = newPlacement == null ? PLACEMENT_EDEFAULT : newPlacement;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KPORT_LAYOUT__PLACEMENT, oldPlacement, placement));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case KimlLayoutGraphPackage.KPORT_LAYOUT__PLACEMENT:
                return getPlacement();
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
            case KimlLayoutGraphPackage.KPORT_LAYOUT__PLACEMENT:
                setPlacement((KPortPlacement)newValue);
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
            case KimlLayoutGraphPackage.KPORT_LAYOUT__PLACEMENT:
                setPlacement(PLACEMENT_EDEFAULT);
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
            case KimlLayoutGraphPackage.KPORT_LAYOUT__PLACEMENT:
                return placement != PLACEMENT_EDEFAULT;
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
        result.append(" (placement: ");
        result.append(placement);
        result.append(')');
        return result.toString();
    }

} //KPortLayoutImpl
