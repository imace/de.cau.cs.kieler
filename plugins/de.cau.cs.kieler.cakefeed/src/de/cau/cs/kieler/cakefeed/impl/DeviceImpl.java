/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.Device;
import de.cau.cs.kieler.cakefeed.DeviceType;
import de.cau.cs.kieler.cakefeed.FBNetwork;
import de.cau.cs.kieler.cakefeed.Parameter;
import de.cau.cs.kieler.cakefeed.Resource;

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
 * An implementation of the model object '<em><b>Device</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.DeviceImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.DeviceImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.DeviceImpl#getFBNetwork <em>FB Network</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.DeviceImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.DeviceImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.DeviceImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeviceImpl extends EObjectImpl implements Device {
	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameter;

	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> resource;

	/**
	 * The cached value of the '{@link #getFBNetwork() <em>FB Network</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFBNetwork()
	 * @generated
	 * @ordered
	 */
	protected FBNetwork fbNetwork;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected DeviceType type;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeviceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.DEVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<Parameter>(Parameter.class, this, CakefeedPackage.DEVICE__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getResource() {
		if (resource == null) {
			resource = new EObjectContainmentEList<Resource>(Resource.class, this, CakefeedPackage.DEVICE__RESOURCE);
		}
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBNetwork getFBNetwork() {
		return fbNetwork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFBNetwork(FBNetwork newFBNetwork, NotificationChain msgs) {
		FBNetwork oldFBNetwork = fbNetwork;
		fbNetwork = newFBNetwork;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.DEVICE__FB_NETWORK, oldFBNetwork, newFBNetwork);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFBNetwork(FBNetwork newFBNetwork) {
		if (newFBNetwork != fbNetwork) {
			NotificationChain msgs = null;
			if (fbNetwork != null)
				msgs = ((InternalEObject)fbNetwork).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.DEVICE__FB_NETWORK, null, msgs);
			if (newFBNetwork != null)
				msgs = ((InternalEObject)newFBNetwork).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.DEVICE__FB_NETWORK, null, msgs);
			msgs = basicSetFBNetwork(newFBNetwork, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.DEVICE__FB_NETWORK, newFBNetwork, newFBNetwork));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (DeviceType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.DEVICE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(DeviceType newType) {
		DeviceType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.DEVICE__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.DEVICE__COMMENT, oldComment, comment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.DEVICE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.DEVICE__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.DEVICE__RESOURCE:
				return ((InternalEList<?>)getResource()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.DEVICE__FB_NETWORK:
				return basicSetFBNetwork(null, msgs);
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
			case CakefeedPackage.DEVICE__PARAMETER:
				return getParameter();
			case CakefeedPackage.DEVICE__RESOURCE:
				return getResource();
			case CakefeedPackage.DEVICE__FB_NETWORK:
				return getFBNetwork();
			case CakefeedPackage.DEVICE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case CakefeedPackage.DEVICE__COMMENT:
				return getComment();
			case CakefeedPackage.DEVICE__NAME:
				return getName();
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
			case CakefeedPackage.DEVICE__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends Parameter>)newValue);
				return;
			case CakefeedPackage.DEVICE__RESOURCE:
				getResource().clear();
				getResource().addAll((Collection<? extends Resource>)newValue);
				return;
			case CakefeedPackage.DEVICE__FB_NETWORK:
				setFBNetwork((FBNetwork)newValue);
				return;
			case CakefeedPackage.DEVICE__TYPE:
				setType((DeviceType)newValue);
				return;
			case CakefeedPackage.DEVICE__COMMENT:
				setComment((String)newValue);
				return;
			case CakefeedPackage.DEVICE__NAME:
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
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CakefeedPackage.DEVICE__PARAMETER:
				getParameter().clear();
				return;
			case CakefeedPackage.DEVICE__RESOURCE:
				getResource().clear();
				return;
			case CakefeedPackage.DEVICE__FB_NETWORK:
				setFBNetwork((FBNetwork)null);
				return;
			case CakefeedPackage.DEVICE__TYPE:
				setType((DeviceType)null);
				return;
			case CakefeedPackage.DEVICE__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case CakefeedPackage.DEVICE__NAME:
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
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CakefeedPackage.DEVICE__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case CakefeedPackage.DEVICE__RESOURCE:
				return resource != null && !resource.isEmpty();
			case CakefeedPackage.DEVICE__FB_NETWORK:
				return fbNetwork != null;
			case CakefeedPackage.DEVICE__TYPE:
				return type != null;
			case CakefeedPackage.DEVICE__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case CakefeedPackage.DEVICE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (Comment: ");
		result.append(comment);
		result.append(", Name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //DeviceImpl
