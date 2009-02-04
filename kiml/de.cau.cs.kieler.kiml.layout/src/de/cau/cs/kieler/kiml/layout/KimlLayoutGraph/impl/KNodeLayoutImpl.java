/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutOption;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutType;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>KNode Group Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLayoutImpl#getLayoutType <em>Layout Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLayoutImpl#getLayoutOptions <em>Layout Options</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLayoutImpl#getLayouterName <em>Layouter Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.impl.KNodeLayoutImpl#getInsets <em>Insets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KNodeLayoutImpl extends KShapeLayoutImpl implements KNodeLayout {
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
	 * The cached value of the '{@link #getLayoutOptions() <em>Layout Options</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<KLayoutOption> layoutOptions;

	/**
	 * The default value of the '{@link #getLayouterName() <em>Layouter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayouterName()
	 * @generated
	 * @ordered
	 */
	protected static final String LAYOUTER_NAME_EDEFAULT = "\"\"";

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
	 * The cached value of the '{@link #getInsets() <em>Insets</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsets()
	 * @generated
	 * @ordered
	 */
	protected KInsets insets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KNodeLayoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KimlLayoutGraphPackage.Literals.KNODE_LAYOUT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KNODE_LAYOUT__LAYOUT_TYPE, oldLayoutType, layoutType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KLayoutOption> getLayoutOptions() {
		if (layoutOptions == null) {
			layoutOptions = new EDataTypeUniqueEList<KLayoutOption>(KLayoutOption.class, this, KimlLayoutGraphPackage.KNODE_LAYOUT__LAYOUT_OPTIONS);
		}
		return layoutOptions;
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
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KNODE_LAYOUT__LAYOUTER_NAME, oldLayouterName, layouterName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KInsets getInsets() {
		if (insets != null && insets.eIsProxy()) {
			InternalEObject oldInsets = (InternalEObject)insets;
			insets = (KInsets)eResolveProxy(oldInsets);
			if (insets != oldInsets) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KNODE_LAYOUT__INSETS, oldInsets, insets));
			}
		}
		return insets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KInsets basicGetInsets() {
		return insets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInsets(KInsets newInsets) {
		KInsets oldInsets = insets;
		insets = newInsets;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KNODE_LAYOUT__INSETS, oldInsets, insets));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KimlLayoutGraphPackage.KNODE_LAYOUT__LAYOUT_TYPE:
				return getLayoutType();
			case KimlLayoutGraphPackage.KNODE_LAYOUT__LAYOUT_OPTIONS:
				return getLayoutOptions();
			case KimlLayoutGraphPackage.KNODE_LAYOUT__LAYOUTER_NAME:
				return getLayouterName();
			case KimlLayoutGraphPackage.KNODE_LAYOUT__INSETS:
				if (resolve) return getInsets();
				return basicGetInsets();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KimlLayoutGraphPackage.KNODE_LAYOUT__LAYOUT_TYPE:
				setLayoutType((KLayoutType)newValue);
				return;
			case KimlLayoutGraphPackage.KNODE_LAYOUT__LAYOUT_OPTIONS:
				getLayoutOptions().clear();
				getLayoutOptions().addAll((Collection<? extends KLayoutOption>)newValue);
				return;
			case KimlLayoutGraphPackage.KNODE_LAYOUT__LAYOUTER_NAME:
				setLayouterName((String)newValue);
				return;
			case KimlLayoutGraphPackage.KNODE_LAYOUT__INSETS:
				setInsets((KInsets)newValue);
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
			case KimlLayoutGraphPackage.KNODE_LAYOUT__LAYOUT_TYPE:
				setLayoutType(LAYOUT_TYPE_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.KNODE_LAYOUT__LAYOUT_OPTIONS:
				getLayoutOptions().clear();
				return;
			case KimlLayoutGraphPackage.KNODE_LAYOUT__LAYOUTER_NAME:
				setLayouterName(LAYOUTER_NAME_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.KNODE_LAYOUT__INSETS:
				setInsets((KInsets)null);
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
			case KimlLayoutGraphPackage.KNODE_LAYOUT__LAYOUT_TYPE:
				return layoutType != LAYOUT_TYPE_EDEFAULT;
			case KimlLayoutGraphPackage.KNODE_LAYOUT__LAYOUT_OPTIONS:
				return layoutOptions != null && !layoutOptions.isEmpty();
			case KimlLayoutGraphPackage.KNODE_LAYOUT__LAYOUTER_NAME:
				return LAYOUTER_NAME_EDEFAULT == null ? layouterName != null : !LAYOUTER_NAME_EDEFAULT.equals(layouterName);
			case KimlLayoutGraphPackage.KNODE_LAYOUT__INSETS:
				return insets != null;
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
		result.append(", layouterName: ");
		result.append(layouterName);
		result.append(')');
		return result.toString();
	}

} //KNodeLayoutImpl
