/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_OPTION;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;

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
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.LAYOUTER_INFOImpl#getLayouterName <em>Layouter Name</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.LAYOUTER_INFOImpl#getLayoutType <em>Layout Type</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.LAYOUTER_INFOImpl#getLayoutOption <em>Layout Option</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.LAYOUTER_INFOImpl#getLayouterCollectionID <em>Layouter Collection ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LAYOUTER_INFOImpl extends EObjectImpl implements LAYOUTER_INFO {
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
	protected static final LAYOUT_TYPE LAYOUT_TYPE_EDEFAULT = LAYOUT_TYPE.DEFAULT;

	/**
	 * The cached value of the '{@link #getLayoutType() <em>Layout Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutType()
	 * @generated
	 * @ordered
	 */
	protected LAYOUT_TYPE layoutType = LAYOUT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayoutOption() <em>Layout Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutOption()
	 * @generated
	 * @ordered
	 */
	protected static final LAYOUT_OPTION LAYOUT_OPTION_EDEFAULT = LAYOUT_OPTION.DEFAULT;

	/**
	 * The cached value of the '{@link #getLayoutOption() <em>Layout Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutOption()
	 * @generated
	 * @ordered
	 */
	protected LAYOUT_OPTION layoutOption = LAYOUT_OPTION_EDEFAULT;

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
	protected LAYOUTER_INFOImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KimlLayoutGraphPackage.Literals.LAYOUTER_INFO;
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
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUTER_NAME, oldLayouterName, layouterName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LAYOUT_TYPE getLayoutType() {
		return layoutType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayoutType(LAYOUT_TYPE newLayoutType) {
		LAYOUT_TYPE oldLayoutType = layoutType;
		layoutType = newLayoutType == null ? LAYOUT_TYPE_EDEFAULT : newLayoutType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUT_TYPE, oldLayoutType, layoutType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LAYOUT_OPTION getLayoutOption() {
		return layoutOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayoutOption(LAYOUT_OPTION newLayoutOption) {
		LAYOUT_OPTION oldLayoutOption = layoutOption;
		layoutOption = newLayoutOption == null ? LAYOUT_OPTION_EDEFAULT : newLayoutOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUT_OPTION, oldLayoutOption, layoutOption));
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
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUTER_COLLECTION_ID, oldLayouterCollectionID, layouterCollectionID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUTER_NAME:
				return getLayouterName();
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUT_TYPE:
				return getLayoutType();
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUT_OPTION:
				return getLayoutOption();
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUTER_COLLECTION_ID:
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
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUTER_NAME:
				setLayouterName((String)newValue);
				return;
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUT_TYPE:
				setLayoutType((LAYOUT_TYPE)newValue);
				return;
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUT_OPTION:
				setLayoutOption((LAYOUT_OPTION)newValue);
				return;
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUTER_COLLECTION_ID:
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
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUTER_NAME:
				setLayouterName(LAYOUTER_NAME_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUT_TYPE:
				setLayoutType(LAYOUT_TYPE_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUT_OPTION:
				setLayoutOption(LAYOUT_OPTION_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUTER_COLLECTION_ID:
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
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUTER_NAME:
				return LAYOUTER_NAME_EDEFAULT == null ? layouterName != null : !LAYOUTER_NAME_EDEFAULT.equals(layouterName);
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUT_TYPE:
				return layoutType != LAYOUT_TYPE_EDEFAULT;
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUT_OPTION:
				return layoutOption != LAYOUT_OPTION_EDEFAULT;
			case KimlLayoutGraphPackage.LAYOUTER_INFO__LAYOUTER_COLLECTION_ID:
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

} //LAYOUTER_INFOImpl
