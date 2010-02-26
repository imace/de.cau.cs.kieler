/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.DeviceType;
import de.cau.cs.kieler.cakefeed.FunctionBlockNetwork;
import de.cau.cs.kieler.cakefeed.InternalVar;
import de.cau.cs.kieler.cakefeed.NamedAndCommented;
import de.cau.cs.kieler.cakefeed.Resource;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Device Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.DeviceTypeImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.DeviceTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.DeviceTypeImpl#getVarDeclarations <em>Var Declarations</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.DeviceTypeImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.DeviceTypeImpl#getFBNetwork <em>FB Network</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.DeviceTypeImpl#getResourceNames <em>Resource Names</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeviceTypeImpl extends CompilableImpl implements DeviceType {
	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

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
	 * The cached value of the '{@link #getVarDeclarations() <em>Var Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<InternalVar> varDeclarations;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> resources;

	/**
	 * The cached value of the '{@link #getFBNetwork() <em>FB Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFBNetwork()
	 * @generated
	 * @ordered
	 */
	protected FunctionBlockNetwork fBNetwork;

	/**
	 * The cached value of the '{@link #getResourceNames() <em>Resource Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> resourceNames;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeviceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.DEVICE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.DEVICE_TYPE__COMMENT, oldComment, comment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.DEVICE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InternalVar> getVarDeclarations() {
		if (varDeclarations == null) {
			varDeclarations = new EObjectContainmentEList<InternalVar>(InternalVar.class, this, CakefeedPackage.DEVICE_TYPE__VAR_DECLARATIONS);
		}
		return varDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<Resource>(Resource.class, this, CakefeedPackage.DEVICE_TYPE__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionBlockNetwork getFBNetwork() {
		if (fBNetwork != null && fBNetwork.eIsProxy()) {
			InternalEObject oldFBNetwork = (InternalEObject)fBNetwork;
			fBNetwork = (FunctionBlockNetwork)eResolveProxy(oldFBNetwork);
			if (fBNetwork != oldFBNetwork) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.DEVICE_TYPE__FB_NETWORK, oldFBNetwork, fBNetwork));
			}
		}
		return fBNetwork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionBlockNetwork basicGetFBNetwork() {
		return fBNetwork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFBNetwork(FunctionBlockNetwork newFBNetwork) {
		FunctionBlockNetwork oldFBNetwork = fBNetwork;
		fBNetwork = newFBNetwork;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.DEVICE_TYPE__FB_NETWORK, oldFBNetwork, fBNetwork));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getResourceNames() {
		if (resourceNames == null) {
			resourceNames = new EDataTypeUniqueEList<String>(String.class, this, CakefeedPackage.DEVICE_TYPE__RESOURCE_NAMES);
		}
		return resourceNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.DEVICE_TYPE__VAR_DECLARATIONS:
				return ((InternalEList<?>)getVarDeclarations()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.DEVICE_TYPE__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.DEVICE_TYPE__COMMENT:
				return getComment();
			case CakefeedPackage.DEVICE_TYPE__NAME:
				return getName();
			case CakefeedPackage.DEVICE_TYPE__VAR_DECLARATIONS:
				return getVarDeclarations();
			case CakefeedPackage.DEVICE_TYPE__RESOURCES:
				return getResources();
			case CakefeedPackage.DEVICE_TYPE__FB_NETWORK:
				if (resolve) return getFBNetwork();
				return basicGetFBNetwork();
			case CakefeedPackage.DEVICE_TYPE__RESOURCE_NAMES:
				return getResourceNames();
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
			case CakefeedPackage.DEVICE_TYPE__COMMENT:
				setComment((String)newValue);
				return;
			case CakefeedPackage.DEVICE_TYPE__NAME:
				setName((String)newValue);
				return;
			case CakefeedPackage.DEVICE_TYPE__VAR_DECLARATIONS:
				getVarDeclarations().clear();
				getVarDeclarations().addAll((Collection<? extends InternalVar>)newValue);
				return;
			case CakefeedPackage.DEVICE_TYPE__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends Resource>)newValue);
				return;
			case CakefeedPackage.DEVICE_TYPE__FB_NETWORK:
				setFBNetwork((FunctionBlockNetwork)newValue);
				return;
			case CakefeedPackage.DEVICE_TYPE__RESOURCE_NAMES:
				getResourceNames().clear();
				getResourceNames().addAll((Collection<? extends String>)newValue);
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
			case CakefeedPackage.DEVICE_TYPE__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case CakefeedPackage.DEVICE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CakefeedPackage.DEVICE_TYPE__VAR_DECLARATIONS:
				getVarDeclarations().clear();
				return;
			case CakefeedPackage.DEVICE_TYPE__RESOURCES:
				getResources().clear();
				return;
			case CakefeedPackage.DEVICE_TYPE__FB_NETWORK:
				setFBNetwork((FunctionBlockNetwork)null);
				return;
			case CakefeedPackage.DEVICE_TYPE__RESOURCE_NAMES:
				getResourceNames().clear();
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
			case CakefeedPackage.DEVICE_TYPE__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case CakefeedPackage.DEVICE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CakefeedPackage.DEVICE_TYPE__VAR_DECLARATIONS:
				return varDeclarations != null && !varDeclarations.isEmpty();
			case CakefeedPackage.DEVICE_TYPE__RESOURCES:
				return resources != null && !resources.isEmpty();
			case CakefeedPackage.DEVICE_TYPE__FB_NETWORK:
				return fBNetwork != null;
			case CakefeedPackage.DEVICE_TYPE__RESOURCE_NAMES:
				return resourceNames != null && !resourceNames.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NamedAndCommented.class) {
			switch (derivedFeatureID) {
				case CakefeedPackage.DEVICE_TYPE__COMMENT: return CakefeedPackage.NAMED_AND_COMMENTED__COMMENT;
				case CakefeedPackage.DEVICE_TYPE__NAME: return CakefeedPackage.NAMED_AND_COMMENTED__NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NamedAndCommented.class) {
			switch (baseFeatureID) {
				case CakefeedPackage.NAMED_AND_COMMENTED__COMMENT: return CakefeedPackage.DEVICE_TYPE__COMMENT;
				case CakefeedPackage.NAMED_AND_COMMENTED__NAME: return CakefeedPackage.DEVICE_TYPE__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (comment: ");
		result.append(comment);
		result.append(", name: ");
		result.append(name);
		result.append(", resourceNames: ");
		result.append(resourceNames);
		result.append(')');
		return result.toString();
	}

} //DeviceTypeImpl
