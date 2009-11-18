/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed.impl;

import Cakefeed.Algorithm;
import Cakefeed.CakefeedPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Algorithm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Cakefeed.impl.AlgorithmImpl#getAlgorithmName <em>Algorithm Name</em>}</li>
 *   <li>{@link Cakefeed.impl.AlgorithmImpl#getAlgorithmLanguage <em>Algorithm Language</em>}</li>
 *   <li>{@link Cakefeed.impl.AlgorithmImpl#getAlgorithmSourceCode <em>Algorithm Source Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AlgorithmImpl extends EObjectImpl implements Algorithm {
	/**
	 * The default value of the '{@link #getAlgorithmName() <em>Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithmName()
	 * @generated
	 * @ordered
	 */
	protected static final String ALGORITHM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlgorithmName() <em>Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithmName()
	 * @generated
	 * @ordered
	 */
	protected String algorithmName = ALGORITHM_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlgorithmLanguage() <em>Algorithm Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithmLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String ALGORITHM_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlgorithmLanguage() <em>Algorithm Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithmLanguage()
	 * @generated
	 * @ordered
	 */
	protected String algorithmLanguage = ALGORITHM_LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlgorithmSourceCode() <em>Algorithm Source Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithmSourceCode()
	 * @generated
	 * @ordered
	 */
	protected static final String ALGORITHM_SOURCE_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlgorithmSourceCode() <em>Algorithm Source Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithmSourceCode()
	 * @generated
	 * @ordered
	 */
	protected String algorithmSourceCode = ALGORITHM_SOURCE_CODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlgorithmImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.ALGORITHM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlgorithmName() {
		return algorithmName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithmName(String newAlgorithmName) {
		String oldAlgorithmName = algorithmName;
		algorithmName = newAlgorithmName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.ALGORITHM__ALGORITHM_NAME, oldAlgorithmName, algorithmName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlgorithmLanguage() {
		return algorithmLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithmLanguage(String newAlgorithmLanguage) {
		String oldAlgorithmLanguage = algorithmLanguage;
		algorithmLanguage = newAlgorithmLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.ALGORITHM__ALGORITHM_LANGUAGE, oldAlgorithmLanguage, algorithmLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlgorithmSourceCode() {
		return algorithmSourceCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithmSourceCode(String newAlgorithmSourceCode) {
		String oldAlgorithmSourceCode = algorithmSourceCode;
		algorithmSourceCode = newAlgorithmSourceCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.ALGORITHM__ALGORITHM_SOURCE_CODE, oldAlgorithmSourceCode, algorithmSourceCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CakefeedPackage.ALGORITHM__ALGORITHM_NAME:
				return getAlgorithmName();
			case CakefeedPackage.ALGORITHM__ALGORITHM_LANGUAGE:
				return getAlgorithmLanguage();
			case CakefeedPackage.ALGORITHM__ALGORITHM_SOURCE_CODE:
				return getAlgorithmSourceCode();
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
			case CakefeedPackage.ALGORITHM__ALGORITHM_NAME:
				setAlgorithmName((String)newValue);
				return;
			case CakefeedPackage.ALGORITHM__ALGORITHM_LANGUAGE:
				setAlgorithmLanguage((String)newValue);
				return;
			case CakefeedPackage.ALGORITHM__ALGORITHM_SOURCE_CODE:
				setAlgorithmSourceCode((String)newValue);
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
			case CakefeedPackage.ALGORITHM__ALGORITHM_NAME:
				setAlgorithmName(ALGORITHM_NAME_EDEFAULT);
				return;
			case CakefeedPackage.ALGORITHM__ALGORITHM_LANGUAGE:
				setAlgorithmLanguage(ALGORITHM_LANGUAGE_EDEFAULT);
				return;
			case CakefeedPackage.ALGORITHM__ALGORITHM_SOURCE_CODE:
				setAlgorithmSourceCode(ALGORITHM_SOURCE_CODE_EDEFAULT);
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
			case CakefeedPackage.ALGORITHM__ALGORITHM_NAME:
				return ALGORITHM_NAME_EDEFAULT == null ? algorithmName != null : !ALGORITHM_NAME_EDEFAULT.equals(algorithmName);
			case CakefeedPackage.ALGORITHM__ALGORITHM_LANGUAGE:
				return ALGORITHM_LANGUAGE_EDEFAULT == null ? algorithmLanguage != null : !ALGORITHM_LANGUAGE_EDEFAULT.equals(algorithmLanguage);
			case CakefeedPackage.ALGORITHM__ALGORITHM_SOURCE_CODE:
				return ALGORITHM_SOURCE_CODE_EDEFAULT == null ? algorithmSourceCode != null : !ALGORITHM_SOURCE_CODE_EDEFAULT.equals(algorithmSourceCode);
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
		result.append(" (algorithmName: ");
		result.append(algorithmName);
		result.append(", algorithmLanguage: ");
		result.append(algorithmLanguage);
		result.append(", algorithmSourceCode: ");
		result.append(algorithmSourceCode);
		result.append(')');
		return result.toString();
	}

} //AlgorithmImpl
