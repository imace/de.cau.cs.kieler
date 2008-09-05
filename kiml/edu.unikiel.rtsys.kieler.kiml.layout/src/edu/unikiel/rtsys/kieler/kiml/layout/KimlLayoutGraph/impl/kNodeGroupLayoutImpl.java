/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPES;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroupLayout;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>kNode Group Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kNodeGroupLayoutImpl#getLayoutType <em>Layout Type</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kNodeGroupLayoutImpl#getLayoutOptions <em>Layout Options</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class kNodeGroupLayoutImpl extends kShapeLayoutImpl implements kNodeGroupLayout {
	/**
	 * The default value of the '{@link #getLayoutType() <em>Layout Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutType()
	 * @generated
	 * @ordered
	 */
	protected static final LAYOUT_TYPES LAYOUT_TYPE_EDEFAULT = LAYOUT_TYPES.DOT;

	/**
	 * The cached value of the '{@link #getLayoutType() <em>Layout Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutType()
	 * @generated
	 * @ordered
	 */
	protected LAYOUT_TYPES layoutType = LAYOUT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayoutOptions() <em>Layout Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutOptions()
	 * @generated
	 * @ordered
	 */
	protected static final int LAYOUT_OPTIONS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLayoutOptions() <em>Layout Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutOptions()
	 * @generated
	 * @ordered
	 */
	protected int layoutOptions = LAYOUT_OPTIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected kNodeGroupLayoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KimlLayoutGraphPackage.Literals.KNODE_GROUP_LAYOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LAYOUT_TYPES getLayoutType() {
		return layoutType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayoutType(LAYOUT_TYPES newLayoutType) {
		LAYOUT_TYPES oldLayoutType = layoutType;
		layoutType = newLayoutType == null ? LAYOUT_TYPE_EDEFAULT : newLayoutType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KNODE_GROUP_LAYOUT__LAYOUT_TYPE, oldLayoutType, layoutType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLayoutOptions() {
		return layoutOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayoutOptions(int newLayoutOptions) {
		int oldLayoutOptions = layoutOptions;
		layoutOptions = newLayoutOptions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KNODE_GROUP_LAYOUT__LAYOUT_OPTIONS, oldLayoutOptions, layoutOptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KimlLayoutGraphPackage.KNODE_GROUP_LAYOUT__LAYOUT_TYPE:
				return getLayoutType();
			case KimlLayoutGraphPackage.KNODE_GROUP_LAYOUT__LAYOUT_OPTIONS:
				return new Integer(getLayoutOptions());
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
			case KimlLayoutGraphPackage.KNODE_GROUP_LAYOUT__LAYOUT_TYPE:
				setLayoutType((LAYOUT_TYPES)newValue);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP_LAYOUT__LAYOUT_OPTIONS:
				setLayoutOptions(((Integer)newValue).intValue());
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
			case KimlLayoutGraphPackage.KNODE_GROUP_LAYOUT__LAYOUT_TYPE:
				setLayoutType(LAYOUT_TYPE_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.KNODE_GROUP_LAYOUT__LAYOUT_OPTIONS:
				setLayoutOptions(LAYOUT_OPTIONS_EDEFAULT);
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
			case KimlLayoutGraphPackage.KNODE_GROUP_LAYOUT__LAYOUT_TYPE:
				return layoutType != LAYOUT_TYPE_EDEFAULT;
			case KimlLayoutGraphPackage.KNODE_GROUP_LAYOUT__LAYOUT_OPTIONS:
				return layoutOptions != LAYOUT_OPTIONS_EDEFAULT;
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
		result.append(" (layoutType: ");
		result.append(layoutType);
		result.append(", layoutOptions: ");
		result.append(layoutOptions);
		result.append(')');
		return result.toString();
	}

} //kNodeGroupLayoutImpl
