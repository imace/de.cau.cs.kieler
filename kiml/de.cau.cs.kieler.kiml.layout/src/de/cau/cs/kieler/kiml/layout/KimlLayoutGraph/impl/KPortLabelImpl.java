/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabelLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>KLayoutPort Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KPortLabelImpl#getLabelLayout <em>Label Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KPortLabelImpl extends KLabelImpl implements KPortLabel {
	/**
     * The cached value of the '{@link #getLabelLayout() <em>Label Layout</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLabelLayout()
     * @generated
     * @ordered
     */
	protected KPortLabelLayout labelLayout;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected KPortLabelImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return KimlLayoutGraphPackage.Literals.KPORT_LABEL;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KPortLabelLayout getLabelLayout() {
        return labelLayout;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetLabelLayout(KPortLabelLayout newLabelLayout, NotificationChain msgs) {
        KPortLabelLayout oldLabelLayout = labelLayout;
        labelLayout = newLabelLayout;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KPORT_LABEL__LABEL_LAYOUT, oldLabelLayout, newLabelLayout);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLabelLayout(KPortLabelLayout newLabelLayout) {
        if (newLabelLayout != labelLayout) {
            NotificationChain msgs = null;
            if (labelLayout != null)
                msgs = ((InternalEObject)labelLayout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KPORT_LABEL__LABEL_LAYOUT, null, msgs);
            if (newLabelLayout != null)
                msgs = ((InternalEObject)newLabelLayout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KimlLayoutGraphPackage.KPORT_LABEL__LABEL_LAYOUT, null, msgs);
            msgs = basicSetLabelLayout(newLabelLayout, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KPORT_LABEL__LABEL_LAYOUT, newLabelLayout, newLabelLayout));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case KimlLayoutGraphPackage.KPORT_LABEL__LABEL_LAYOUT:
                return basicSetLabelLayout(null, msgs);
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
            case KimlLayoutGraphPackage.KPORT_LABEL__LABEL_LAYOUT:
                return getLabelLayout();
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
            case KimlLayoutGraphPackage.KPORT_LABEL__LABEL_LAYOUT:
                setLabelLayout((KPortLabelLayout)newValue);
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
            case KimlLayoutGraphPackage.KPORT_LABEL__LABEL_LAYOUT:
                setLabelLayout((KPortLabelLayout)null);
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
            case KimlLayoutGraphPackage.KPORT_LABEL__LABEL_LAYOUT:
                return labelLayout != null;
        }
        return super.eIsSet(featureID);
    }

} //KPortLabelImpl
