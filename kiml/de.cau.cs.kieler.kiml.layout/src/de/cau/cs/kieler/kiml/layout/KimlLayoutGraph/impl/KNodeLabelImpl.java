/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>KNode Group Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLabelImpl#getLabelLayout <em>Label Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KNodeLabelImpl extends KLabelImpl implements KNodeLabel {
	/**
	 * The cached value of the '{@link #getLabelLayout() <em>Label Layout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelLayout()
	 * @generated
	 * @ordered
	 */
	protected KNodeLabelLayout labelLayout;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KNodeLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KimlLayoutGraphPackage.Literals.KNODE_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KNodeLabelLayout getLabelLayout() {
		if (labelLayout != null && labelLayout.eIsProxy()) {
			InternalEObject oldLabelLayout = (InternalEObject)labelLayout;
			labelLayout = (KNodeLabelLayout)eResolveProxy(oldLabelLayout);
			if (labelLayout != oldLabelLayout) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KNODE_LABEL__LABEL_LAYOUT, oldLabelLayout, labelLayout));
			}
		}
		return labelLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KNodeLabelLayout basicGetLabelLayout() {
		return labelLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelLayout(KNodeLabelLayout newLabelLayout) {
		KNodeLabelLayout oldLabelLayout = labelLayout;
		labelLayout = newLabelLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KNODE_LABEL__LABEL_LAYOUT, oldLabelLayout, labelLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KimlLayoutGraphPackage.KNODE_LABEL__LABEL_LAYOUT:
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
			case KimlLayoutGraphPackage.KNODE_LABEL__LABEL_LAYOUT:
				setLabelLayout((KNodeLabelLayout)newValue);
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
			case KimlLayoutGraphPackage.KNODE_LABEL__LABEL_LAYOUT:
				setLabelLayout((KNodeLabelLayout)null);
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
			case KimlLayoutGraphPackage.KNODE_LABEL__LABEL_LAYOUT:
				return labelLayout != null;
		}
		return super.eIsSet(featureID);
	}

} //KNodeLabelImpl
