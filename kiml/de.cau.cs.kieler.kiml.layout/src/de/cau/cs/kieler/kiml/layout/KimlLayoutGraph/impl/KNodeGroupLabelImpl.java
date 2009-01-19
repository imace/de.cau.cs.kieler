/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabel;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabelLayout;
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
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeGroupLabelImpl#getLabelLayout <em>Label Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KNodeGroupLabelImpl extends KLabelImpl implements KNodeGroupLabel {
	/**
	 * The cached value of the '{@link #getLabelLayout() <em>Label Layout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelLayout()
	 * @generated
	 * @ordered
	 */
	protected KNodeGroupLabelLayout labelLayout;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KNodeGroupLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KimlLayoutGraphPackage.Literals.KNODE_GROUP_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KNodeGroupLabelLayout getLabelLayout() {
		if (labelLayout != null && labelLayout.eIsProxy()) {
			InternalEObject oldLabelLayout = (InternalEObject)labelLayout;
			labelLayout = (KNodeGroupLabelLayout)eResolveProxy(oldLabelLayout);
			if (labelLayout != oldLabelLayout) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KNODE_GROUP_LABEL__LABEL_LAYOUT, oldLabelLayout, labelLayout));
			}
		}
		return labelLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KNodeGroupLabelLayout basicGetLabelLayout() {
		return labelLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelLayout(KNodeGroupLabelLayout newLabelLayout) {
		KNodeGroupLabelLayout oldLabelLayout = labelLayout;
		labelLayout = newLabelLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KNODE_GROUP_LABEL__LABEL_LAYOUT, oldLabelLayout, labelLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KimlLayoutGraphPackage.KNODE_GROUP_LABEL__LABEL_LAYOUT:
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
			case KimlLayoutGraphPackage.KNODE_GROUP_LABEL__LABEL_LAYOUT:
				setLabelLayout((KNodeGroupLabelLayout)newValue);
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
			case KimlLayoutGraphPackage.KNODE_GROUP_LABEL__LABEL_LAYOUT:
				setLabelLayout((KNodeGroupLabelLayout)null);
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
			case KimlLayoutGraphPackage.KNODE_GROUP_LABEL__LABEL_LAYOUT:
				return labelLayout != null;
		}
		return super.eIsSet(featureID);
	}

} //KNodeGroupLabelImpl
