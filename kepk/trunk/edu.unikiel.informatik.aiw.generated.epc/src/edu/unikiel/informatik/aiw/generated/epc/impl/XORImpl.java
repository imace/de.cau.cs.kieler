/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.generated.epc.impl;

import edu.unikiel.informatik.aiw.generated.epc.EpcPackage;
import edu.unikiel.informatik.aiw.generated.epc.XOR;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XOR</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.informatik.aiw.generated.epc.impl.XORImpl#isShowInEPCEditor <em>Show In EPC Editor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XORImpl extends EObjectImpl implements XOR {
	/**
	 * The default value of the '{@link #isShowInEPCEditor() <em>Show In EPC Editor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowInEPCEditor()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHOW_IN_EPC_EDITOR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isShowInEPCEditor() <em>Show In EPC Editor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowInEPCEditor()
	 * @generated
	 * @ordered
	 */
	protected boolean showInEPCEditor = SHOW_IN_EPC_EDITOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XORImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EpcPackage.Literals.XOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isShowInEPCEditor() {
		return showInEPCEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowInEPCEditor(boolean newShowInEPCEditor) {
		boolean oldShowInEPCEditor = showInEPCEditor;
		showInEPCEditor = newShowInEPCEditor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EpcPackage.XOR__SHOW_IN_EPC_EDITOR, oldShowInEPCEditor, showInEPCEditor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EpcPackage.XOR__SHOW_IN_EPC_EDITOR:
				return isShowInEPCEditor() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EpcPackage.XOR__SHOW_IN_EPC_EDITOR:
				setShowInEPCEditor(((Boolean)newValue).booleanValue());
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case EpcPackage.XOR__SHOW_IN_EPC_EDITOR:
				setShowInEPCEditor(SHOW_IN_EPC_EDITOR_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EpcPackage.XOR__SHOW_IN_EPC_EDITOR:
				return showInEPCEditor != SHOW_IN_EPC_EDITOR_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (showInEPCEditor: ");
		result.append(showInEPCEditor);
		result.append(')');
		return result.toString();
	}

} //XORImpl
