/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.generated.epc.impl;

import edu.unikiel.informatik.aiw.generated.epc.EpcPackage;
import edu.unikiel.informatik.aiw.generated.epc.Information;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.informatik.aiw.generated.epc.impl.InformationImpl#isShowInEPCEditor <em>Show In EPC Editor</em>}</li>
 *   <li>{@link edu.unikiel.informatik.aiw.generated.epc.impl.InformationImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InformationImpl extends EObjectImpl implements Information {
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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EpcPackage.Literals.INFORMATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EpcPackage.INFORMATION__SHOW_IN_EPC_EDITOR, oldShowInEPCEditor, showInEPCEditor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EpcPackage.INFORMATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EpcPackage.INFORMATION__SHOW_IN_EPC_EDITOR:
				return isShowInEPCEditor() ? Boolean.TRUE : Boolean.FALSE;
			case EpcPackage.INFORMATION__NAME:
				return getName();
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
			case EpcPackage.INFORMATION__SHOW_IN_EPC_EDITOR:
				setShowInEPCEditor(((Boolean)newValue).booleanValue());
				return;
			case EpcPackage.INFORMATION__NAME:
				setName((String)newValue);
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
			case EpcPackage.INFORMATION__SHOW_IN_EPC_EDITOR:
				setShowInEPCEditor(SHOW_IN_EPC_EDITOR_EDEFAULT);
				return;
			case EpcPackage.INFORMATION__NAME:
				setName(NAME_EDEFAULT);
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
			case EpcPackage.INFORMATION__SHOW_IN_EPC_EDITOR:
				return showInEPCEditor != SHOW_IN_EPC_EDITOR_EDEFAULT;
			case EpcPackage.INFORMATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //InformationImpl
