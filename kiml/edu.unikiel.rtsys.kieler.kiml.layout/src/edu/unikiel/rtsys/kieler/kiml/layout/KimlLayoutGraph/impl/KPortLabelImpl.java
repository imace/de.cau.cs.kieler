/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPortLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPortLabelLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>KPort Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.KPortLabelImpl#getLabelLayout <em>Label Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KPortLabelImpl extends KLabelImpl implements KPortLabel {
	/**
	 * The cached value of the '{@link #getLabelLayout() <em>Label Layout</em>}' reference.
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
		if (labelLayout != null && labelLayout.eIsProxy()) {
			InternalEObject oldLabelLayout = (InternalEObject)labelLayout;
			labelLayout = (KPortLabelLayout)eResolveProxy(oldLabelLayout);
			if (labelLayout != oldLabelLayout) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KPORT_LABEL__LABEL_LAYOUT, oldLabelLayout, labelLayout));
			}
		}
		return labelLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KPortLabelLayout basicGetLabelLayout() {
		return labelLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelLayout(KPortLabelLayout newLabelLayout) {
		KPortLabelLayout oldLabelLayout = labelLayout;
		labelLayout = newLabelLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KPORT_LABEL__LABEL_LAYOUT, oldLabelLayout, labelLayout));
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
				if (resolve) return getLabelLayout();
				return basicGetLabelLayout();
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
