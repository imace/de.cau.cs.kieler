/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.CompilerInfo;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compiler Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.CompilerInfoImpl#getCompilers <em>Compilers</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.CompilerInfoImpl#getClassdef <em>Classdef</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.CompilerInfoImpl#getHeader <em>Header</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompilerInfoImpl extends EObjectImpl implements CompilerInfo {
	/**
	 * The cached value of the '{@link #getCompilers() <em>Compilers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompilers()
	 * @generated
	 * @ordered
	 */
	protected EList<de.cau.cs.kieler.cakefeed.Compiler> compilers;

	/**
	 * The default value of the '{@link #getClassdef() <em>Classdef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassdef()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSDEF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassdef() <em>Classdef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassdef()
	 * @generated
	 * @ordered
	 */
	protected String classdef = CLASSDEF_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeader() <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected static final String HEADER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected String header = HEADER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompilerInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.COMPILER_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<de.cau.cs.kieler.cakefeed.Compiler> getCompilers() {
		if (compilers == null) {
			compilers = new EObjectContainmentEList<de.cau.cs.kieler.cakefeed.Compiler>(de.cau.cs.kieler.cakefeed.Compiler.class, this, CakefeedPackage.COMPILER_INFO__COMPILERS);
		}
		return compilers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassdef() {
		return classdef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassdef(String newClassdef) {
		String oldClassdef = classdef;
		classdef = newClassdef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPILER_INFO__CLASSDEF, oldClassdef, classdef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeader(String newHeader) {
		String oldHeader = header;
		header = newHeader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPILER_INFO__HEADER, oldHeader, header));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.COMPILER_INFO__COMPILERS:
				return ((InternalEList<?>)getCompilers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CakefeedPackage.COMPILER_INFO__COMPILERS:
				return getCompilers();
			case CakefeedPackage.COMPILER_INFO__CLASSDEF:
				return getClassdef();
			case CakefeedPackage.COMPILER_INFO__HEADER:
				return getHeader();
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
			case CakefeedPackage.COMPILER_INFO__COMPILERS:
				getCompilers().clear();
				getCompilers().addAll((Collection<? extends de.cau.cs.kieler.cakefeed.Compiler>)newValue);
				return;
			case CakefeedPackage.COMPILER_INFO__CLASSDEF:
				setClassdef((String)newValue);
				return;
			case CakefeedPackage.COMPILER_INFO__HEADER:
				setHeader((String)newValue);
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
			case CakefeedPackage.COMPILER_INFO__COMPILERS:
				getCompilers().clear();
				return;
			case CakefeedPackage.COMPILER_INFO__CLASSDEF:
				setClassdef(CLASSDEF_EDEFAULT);
				return;
			case CakefeedPackage.COMPILER_INFO__HEADER:
				setHeader(HEADER_EDEFAULT);
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
			case CakefeedPackage.COMPILER_INFO__COMPILERS:
				return compilers != null && !compilers.isEmpty();
			case CakefeedPackage.COMPILER_INFO__CLASSDEF:
				return CLASSDEF_EDEFAULT == null ? classdef != null : !CLASSDEF_EDEFAULT.equals(classdef);
			case CakefeedPackage.COMPILER_INFO__HEADER:
				return HEADER_EDEFAULT == null ? header != null : !HEADER_EDEFAULT.equals(header);
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
		result.append(" (classdef: ");
		result.append(classdef);
		result.append(", header: ");
		result.append(header);
		result.append(')');
		return result.toString();
	}

} //CompilerInfoImpl
