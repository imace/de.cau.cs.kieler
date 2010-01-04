/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblock.impl;

import de.cau.cs.kieler.functionblock.Application;
import de.cau.cs.kieler.functionblock.Device;
import de.cau.cs.kieler.functionblock.FunctionblockPackage;
import de.cau.cs.kieler.functionblock.Identification;
import de.cau.cs.kieler.functionblock.Link;
import de.cau.cs.kieler.functionblock.Mapping;
import de.cau.cs.kieler.functionblock.Segment;
import de.cau.cs.kieler.functionblock.VersionInfo;

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
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.SystemImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.SystemImpl#getVersionInfo <em>Version Info</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.SystemImpl#getApplication <em>Application</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.SystemImpl#getDevice <em>Device</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.SystemImpl#getMapping <em>Mapping</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.SystemImpl#getSegment <em>Segment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.SystemImpl#getLink <em>Link</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.SystemImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.SystemImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends EObjectImpl implements de.cau.cs.kieler.functionblock.System {
	/**
	 * The cached value of the '{@link #getIdentification() <em>Identification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentification()
	 * @generated
	 * @ordered
	 */
	protected Identification identification;

	/**
	 * The cached value of the '{@link #getVersionInfo() <em>Version Info</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionInfo()
	 * @generated
	 * @ordered
	 */
	protected EList<VersionInfo> versionInfo;

	/**
	 * The cached value of the '{@link #getApplication() <em>Application</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplication()
	 * @generated
	 * @ordered
	 */
	protected EList<Application> application;

	/**
	 * The cached value of the '{@link #getDevice() <em>Device</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevice()
	 * @generated
	 * @ordered
	 */
	protected EList<Device> device;

	/**
	 * The cached value of the '{@link #getMapping() <em>Mapping</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> mapping;

	/**
	 * The cached value of the '{@link #getSegment() <em>Segment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSegment()
	 * @generated
	 * @ordered
	 */
	protected EList<Segment> segment;

	/**
	 * The cached value of the '{@link #getLink() <em>Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> link;

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
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblockPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identification getIdentification() {
		return identification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentification(Identification newIdentification, NotificationChain msgs) {
		Identification oldIdentification = identification;
		identification = newIdentification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblockPackage.SYSTEM__IDENTIFICATION, oldIdentification, newIdentification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentification(Identification newIdentification) {
		if (newIdentification != identification) {
			NotificationChain msgs = null;
			if (identification != null)
				msgs = ((InternalEObject)identification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblockPackage.SYSTEM__IDENTIFICATION, null, msgs);
			if (newIdentification != null)
				msgs = ((InternalEObject)newIdentification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblockPackage.SYSTEM__IDENTIFICATION, null, msgs);
			msgs = basicSetIdentification(newIdentification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblockPackage.SYSTEM__IDENTIFICATION, newIdentification, newIdentification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VersionInfo> getVersionInfo() {
		if (versionInfo == null) {
			versionInfo = new EObjectContainmentEList<VersionInfo>(VersionInfo.class, this, FunctionblockPackage.SYSTEM__VERSION_INFO);
		}
		return versionInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Application> getApplication() {
		if (application == null) {
			application = new EObjectContainmentEList<Application>(Application.class, this, FunctionblockPackage.SYSTEM__APPLICATION);
		}
		return application;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Device> getDevice() {
		if (device == null) {
			device = new EObjectContainmentEList<Device>(Device.class, this, FunctionblockPackage.SYSTEM__DEVICE);
		}
		return device;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getMapping() {
		if (mapping == null) {
			mapping = new EObjectContainmentEList<Mapping>(Mapping.class, this, FunctionblockPackage.SYSTEM__MAPPING);
		}
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Segment> getSegment() {
		if (segment == null) {
			segment = new EObjectContainmentEList<Segment>(Segment.class, this, FunctionblockPackage.SYSTEM__SEGMENT);
		}
		return segment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getLink() {
		if (link == null) {
			link = new EObjectContainmentEList<Link>(Link.class, this, FunctionblockPackage.SYSTEM__LINK);
		}
		return link;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblockPackage.SYSTEM__COMMENT, oldComment, comment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblockPackage.SYSTEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblockPackage.SYSTEM__IDENTIFICATION:
				return basicSetIdentification(null, msgs);
			case FunctionblockPackage.SYSTEM__VERSION_INFO:
				return ((InternalEList<?>)getVersionInfo()).basicRemove(otherEnd, msgs);
			case FunctionblockPackage.SYSTEM__APPLICATION:
				return ((InternalEList<?>)getApplication()).basicRemove(otherEnd, msgs);
			case FunctionblockPackage.SYSTEM__DEVICE:
				return ((InternalEList<?>)getDevice()).basicRemove(otherEnd, msgs);
			case FunctionblockPackage.SYSTEM__MAPPING:
				return ((InternalEList<?>)getMapping()).basicRemove(otherEnd, msgs);
			case FunctionblockPackage.SYSTEM__SEGMENT:
				return ((InternalEList<?>)getSegment()).basicRemove(otherEnd, msgs);
			case FunctionblockPackage.SYSTEM__LINK:
				return ((InternalEList<?>)getLink()).basicRemove(otherEnd, msgs);
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
			case FunctionblockPackage.SYSTEM__IDENTIFICATION:
				return getIdentification();
			case FunctionblockPackage.SYSTEM__VERSION_INFO:
				return getVersionInfo();
			case FunctionblockPackage.SYSTEM__APPLICATION:
				return getApplication();
			case FunctionblockPackage.SYSTEM__DEVICE:
				return getDevice();
			case FunctionblockPackage.SYSTEM__MAPPING:
				return getMapping();
			case FunctionblockPackage.SYSTEM__SEGMENT:
				return getSegment();
			case FunctionblockPackage.SYSTEM__LINK:
				return getLink();
			case FunctionblockPackage.SYSTEM__COMMENT:
				return getComment();
			case FunctionblockPackage.SYSTEM__NAME:
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
			case FunctionblockPackage.SYSTEM__IDENTIFICATION:
				setIdentification((Identification)newValue);
				return;
			case FunctionblockPackage.SYSTEM__VERSION_INFO:
				getVersionInfo().clear();
				getVersionInfo().addAll((Collection<? extends VersionInfo>)newValue);
				return;
			case FunctionblockPackage.SYSTEM__APPLICATION:
				getApplication().clear();
				getApplication().addAll((Collection<? extends Application>)newValue);
				return;
			case FunctionblockPackage.SYSTEM__DEVICE:
				getDevice().clear();
				getDevice().addAll((Collection<? extends Device>)newValue);
				return;
			case FunctionblockPackage.SYSTEM__MAPPING:
				getMapping().clear();
				getMapping().addAll((Collection<? extends Mapping>)newValue);
				return;
			case FunctionblockPackage.SYSTEM__SEGMENT:
				getSegment().clear();
				getSegment().addAll((Collection<? extends Segment>)newValue);
				return;
			case FunctionblockPackage.SYSTEM__LINK:
				getLink().clear();
				getLink().addAll((Collection<? extends Link>)newValue);
				return;
			case FunctionblockPackage.SYSTEM__COMMENT:
				setComment((String)newValue);
				return;
			case FunctionblockPackage.SYSTEM__NAME:
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
			case FunctionblockPackage.SYSTEM__IDENTIFICATION:
				setIdentification((Identification)null);
				return;
			case FunctionblockPackage.SYSTEM__VERSION_INFO:
				getVersionInfo().clear();
				return;
			case FunctionblockPackage.SYSTEM__APPLICATION:
				getApplication().clear();
				return;
			case FunctionblockPackage.SYSTEM__DEVICE:
				getDevice().clear();
				return;
			case FunctionblockPackage.SYSTEM__MAPPING:
				getMapping().clear();
				return;
			case FunctionblockPackage.SYSTEM__SEGMENT:
				getSegment().clear();
				return;
			case FunctionblockPackage.SYSTEM__LINK:
				getLink().clear();
				return;
			case FunctionblockPackage.SYSTEM__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case FunctionblockPackage.SYSTEM__NAME:
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
			case FunctionblockPackage.SYSTEM__IDENTIFICATION:
				return identification != null;
			case FunctionblockPackage.SYSTEM__VERSION_INFO:
				return versionInfo != null && !versionInfo.isEmpty();
			case FunctionblockPackage.SYSTEM__APPLICATION:
				return application != null && !application.isEmpty();
			case FunctionblockPackage.SYSTEM__DEVICE:
				return device != null && !device.isEmpty();
			case FunctionblockPackage.SYSTEM__MAPPING:
				return mapping != null && !mapping.isEmpty();
			case FunctionblockPackage.SYSTEM__SEGMENT:
				return segment != null && !segment.isEmpty();
			case FunctionblockPackage.SYSTEM__LINK:
				return link != null && !link.isEmpty();
			case FunctionblockPackage.SYSTEM__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case FunctionblockPackage.SYSTEM__NAME:
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
		result.append(" (comment: ");
		result.append(comment);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SystemImpl
