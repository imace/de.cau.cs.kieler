/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LAYOUTER INFO</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayouterInfoImpl#getLayouterName <em>Layouter Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayouterInfoImpl#getLayoutType <em>Layout Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayouterInfoImpl#getLayoutOption <em>Layout Option</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KLayouterInfoImpl#getLayouterCollectionID <em>Layouter Collection ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KLayouterInfoImpl extends EObjectImpl implements KLayouterInfo {
	/**
	 * The default value of the '{@link #getLayouterName() <em>Layouter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayouterName()
	 * @generated
	 * @ordered
	 */
	protected static final String LAYOUTER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLayouterName() <em>Layouter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayouterName()
	 * @generated
	 * @ordered
	 */
	protected String layouterName = LAYOUTER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayoutType() <em>Layout Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutType()
	 * @generated
	 * @ordered
	 */
	protected static final KLayoutType LAYOUT_TYPE_EDEFAULT = KLayoutType.DEFAULT;

	/**
	 * The cached value of the '{@link #getLayoutType() <em>Layout Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutType()
	 * @generated
	 * @ordered
	 */
	protected KLayoutType layoutType = LAYOUT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayoutOption() <em>Layout Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutOption()
	 * @generated
	 * @ordered
	 */
	protected static final KLayoutOption LAYOUT_OPTION_EDEFAULT = KLayoutOption.DEFAULT;

	/**
	 * The cached value of the '{@link #getLayoutOption() <em>Layout Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutOption()
	 * @generated
	 * @ordered
	 */
	protected KLayoutOption layoutOption = LAYOUT_OPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayouterCollectionID() <em>Layouter Collection ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayouterCollectionID()
	 * @generated
	 * @ordered
	 */
	protected static final String LAYOUTER_COLLECTION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLayouterCollectionID() <em>Layouter Collection ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayouterCollectionID()
	 * @generated
	 * @ordered
	 */
	protected String layouterCollectionID = LAYOUTER_COLLECTION_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KLayouterInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KimlLayoutGraphPackage.Literals.KLAYOUTER_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLayouterName() {
		return layouterName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayouterName(String newLayouterName) {
		String oldLayouterName = layouterName;
		layouterName = newLayouterName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUTER_NAME, oldLayouterName, layouterName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KLayoutType getLayoutType() {
		return layoutType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayoutType(KLayoutType newLayoutType) {
		KLayoutType oldLayoutType = layoutType;
		layoutType = newLayoutType == null ? LAYOUT_TYPE_EDEFAULT : newLayoutType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUT_TYPE, oldLayoutType, layoutType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KLayoutOption getLayoutOption() {
		return layoutOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayoutOption(KLayoutOption newLayoutOption) {
		KLayoutOption oldLayoutOption = layoutOption;
		layoutOption = newLayoutOption == null ? LAYOUT_OPTION_EDEFAULT : newLayoutOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUT_OPTION, oldLayoutOption, layoutOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLayouterCollectionID() {
		return layouterCollectionID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayouterCollectionID(String newLayouterCollectionID) {
		String oldLayouterCollectionID = layouterCollectionID;
		layouterCollectionID = newLayouterCollectionID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUTER_COLLECTION_ID, oldLayouterCollectionID, layouterCollectionID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUTER_NAME:
				return getLayouterName();
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUT_TYPE:
				return getLayoutType();
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUT_OPTION:
				return getLayoutOption();
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUTER_COLLECTION_ID:
				return getLayouterCollectionID();
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
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUTER_NAME:
				setLayouterName((String)newValue);
				return;
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUT_TYPE:
				setLayoutType((KLayoutType)newValue);
				return;
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUT_OPTION:
				setLayoutOption((KLayoutOption)newValue);
				return;
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUTER_COLLECTION_ID:
				setLayouterCollectionID((String)newValue);
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
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUTER_NAME:
				setLayouterName(LAYOUTER_NAME_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUT_TYPE:
				setLayoutType(LAYOUT_TYPE_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUT_OPTION:
				setLayoutOption(LAYOUT_OPTION_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUTER_COLLECTION_ID:
				setLayouterCollectionID(LAYOUTER_COLLECTION_ID_EDEFAULT);
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
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUTER_NAME:
				return LAYOUTER_NAME_EDEFAULT == null ? layouterName != null : !LAYOUTER_NAME_EDEFAULT.equals(layouterName);
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUT_TYPE:
				return layoutType != LAYOUT_TYPE_EDEFAULT;
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUT_OPTION:
				return layoutOption != LAYOUT_OPTION_EDEFAULT;
			case KimlLayoutGraphPackage.KLAYOUTER_INFO__LAYOUTER_COLLECTION_ID:
				return LAYOUTER_COLLECTION_ID_EDEFAULT == null ? layouterCollectionID != null : !LAYOUTER_COLLECTION_ID_EDEFAULT.equals(layouterCollectionID);
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
		result.append(" (layouterName: ");
		result.append(layouterName);
		result.append(", layoutType: ");
		result.append(layoutType);
		result.append(", layoutOption: ");
		result.append(layoutOption);
		result.append(", layouterCollectionID: ");
		result.append(layouterCollectionID);
		result.append(')');
		return result.toString();
	}

} //KLayouterInfoImpl
