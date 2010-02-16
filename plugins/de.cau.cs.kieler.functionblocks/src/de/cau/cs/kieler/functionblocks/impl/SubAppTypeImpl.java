/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks.impl;

import de.cau.cs.kieler.functionblocks.CompilerInfo;
import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;
import de.cau.cs.kieler.functionblocks.Identification;
import de.cau.cs.kieler.functionblocks.SubAppInterfaceList;
import de.cau.cs.kieler.functionblocks.SubAppNetwork;
import de.cau.cs.kieler.functionblocks.SubAppType;
import de.cau.cs.kieler.functionblocks.VersionInfo;

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
 * An implementation of the model object '<em><b>Sub App Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppTypeImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppTypeImpl#getVersionInfo <em>Version Info</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppTypeImpl#getCompilerInfo <em>Compiler Info</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppTypeImpl#getSubAppInterfaceList <em>Sub App Interface List</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppTypeImpl#getSubAppNetwork <em>Sub App Network</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppTypeImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubAppTypeImpl extends EObjectImpl implements SubAppType {
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
	 * The cached value of the '{@link #getCompilerInfo() <em>Compiler Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompilerInfo()
	 * @generated
	 * @ordered
	 */
	protected CompilerInfo compilerInfo;

	/**
	 * The cached value of the '{@link #getSubAppInterfaceList() <em>Sub App Interface List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubAppInterfaceList()
	 * @generated
	 * @ordered
	 */
	protected SubAppInterfaceList subAppInterfaceList;

	/**
	 * The cached value of the '{@link #getSubAppNetwork() <em>Sub App Network</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubAppNetwork()
	 * @generated
	 * @ordered
	 */
	protected SubAppNetwork subAppNetwork;

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
	protected SubAppTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblocksPackage.Literals.SUB_APP_TYPE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_TYPE__IDENTIFICATION, oldIdentification, newIdentification);
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
				msgs = ((InternalEObject)identification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_TYPE__IDENTIFICATION, null, msgs);
			if (newIdentification != null)
				msgs = ((InternalEObject)newIdentification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_TYPE__IDENTIFICATION, null, msgs);
			msgs = basicSetIdentification(newIdentification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_TYPE__IDENTIFICATION, newIdentification, newIdentification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VersionInfo> getVersionInfo() {
		if (versionInfo == null) {
			versionInfo = new EObjectContainmentEList<VersionInfo>(VersionInfo.class, this, FunctionblocksPackage.SUB_APP_TYPE__VERSION_INFO);
		}
		return versionInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompilerInfo getCompilerInfo() {
		return compilerInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompilerInfo(CompilerInfo newCompilerInfo, NotificationChain msgs) {
		CompilerInfo oldCompilerInfo = compilerInfo;
		compilerInfo = newCompilerInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_TYPE__COMPILER_INFO, oldCompilerInfo, newCompilerInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompilerInfo(CompilerInfo newCompilerInfo) {
		if (newCompilerInfo != compilerInfo) {
			NotificationChain msgs = null;
			if (compilerInfo != null)
				msgs = ((InternalEObject)compilerInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_TYPE__COMPILER_INFO, null, msgs);
			if (newCompilerInfo != null)
				msgs = ((InternalEObject)newCompilerInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_TYPE__COMPILER_INFO, null, msgs);
			msgs = basicSetCompilerInfo(newCompilerInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_TYPE__COMPILER_INFO, newCompilerInfo, newCompilerInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppInterfaceList getSubAppInterfaceList() {
		return subAppInterfaceList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubAppInterfaceList(SubAppInterfaceList newSubAppInterfaceList, NotificationChain msgs) {
		SubAppInterfaceList oldSubAppInterfaceList = subAppInterfaceList;
		subAppInterfaceList = newSubAppInterfaceList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_INTERFACE_LIST, oldSubAppInterfaceList, newSubAppInterfaceList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubAppInterfaceList(SubAppInterfaceList newSubAppInterfaceList) {
		if (newSubAppInterfaceList != subAppInterfaceList) {
			NotificationChain msgs = null;
			if (subAppInterfaceList != null)
				msgs = ((InternalEObject)subAppInterfaceList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_INTERFACE_LIST, null, msgs);
			if (newSubAppInterfaceList != null)
				msgs = ((InternalEObject)newSubAppInterfaceList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_INTERFACE_LIST, null, msgs);
			msgs = basicSetSubAppInterfaceList(newSubAppInterfaceList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_INTERFACE_LIST, newSubAppInterfaceList, newSubAppInterfaceList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppNetwork getSubAppNetwork() {
		return subAppNetwork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubAppNetwork(SubAppNetwork newSubAppNetwork, NotificationChain msgs) {
		SubAppNetwork oldSubAppNetwork = subAppNetwork;
		subAppNetwork = newSubAppNetwork;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_NETWORK, oldSubAppNetwork, newSubAppNetwork);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubAppNetwork(SubAppNetwork newSubAppNetwork) {
		if (newSubAppNetwork != subAppNetwork) {
			NotificationChain msgs = null;
			if (subAppNetwork != null)
				msgs = ((InternalEObject)subAppNetwork).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_NETWORK, null, msgs);
			if (newSubAppNetwork != null)
				msgs = ((InternalEObject)newSubAppNetwork).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_NETWORK, null, msgs);
			msgs = basicSetSubAppNetwork(newSubAppNetwork, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_NETWORK, newSubAppNetwork, newSubAppNetwork));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_TYPE__COMMENT, oldComment, comment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblocksPackage.SUB_APP_TYPE__IDENTIFICATION:
				return basicSetIdentification(null, msgs);
			case FunctionblocksPackage.SUB_APP_TYPE__VERSION_INFO:
				return ((InternalEList<?>)getVersionInfo()).basicRemove(otherEnd, msgs);
			case FunctionblocksPackage.SUB_APP_TYPE__COMPILER_INFO:
				return basicSetCompilerInfo(null, msgs);
			case FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_INTERFACE_LIST:
				return basicSetSubAppInterfaceList(null, msgs);
			case FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_NETWORK:
				return basicSetSubAppNetwork(null, msgs);
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
			case FunctionblocksPackage.SUB_APP_TYPE__IDENTIFICATION:
				return getIdentification();
			case FunctionblocksPackage.SUB_APP_TYPE__VERSION_INFO:
				return getVersionInfo();
			case FunctionblocksPackage.SUB_APP_TYPE__COMPILER_INFO:
				return getCompilerInfo();
			case FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_INTERFACE_LIST:
				return getSubAppInterfaceList();
			case FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_NETWORK:
				return getSubAppNetwork();
			case FunctionblocksPackage.SUB_APP_TYPE__COMMENT:
				return getComment();
			case FunctionblocksPackage.SUB_APP_TYPE__NAME:
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
			case FunctionblocksPackage.SUB_APP_TYPE__IDENTIFICATION:
				setIdentification((Identification)newValue);
				return;
			case FunctionblocksPackage.SUB_APP_TYPE__VERSION_INFO:
				getVersionInfo().clear();
				getVersionInfo().addAll((Collection<? extends VersionInfo>)newValue);
				return;
			case FunctionblocksPackage.SUB_APP_TYPE__COMPILER_INFO:
				setCompilerInfo((CompilerInfo)newValue);
				return;
			case FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_INTERFACE_LIST:
				setSubAppInterfaceList((SubAppInterfaceList)newValue);
				return;
			case FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_NETWORK:
				setSubAppNetwork((SubAppNetwork)newValue);
				return;
			case FunctionblocksPackage.SUB_APP_TYPE__COMMENT:
				setComment((String)newValue);
				return;
			case FunctionblocksPackage.SUB_APP_TYPE__NAME:
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
			case FunctionblocksPackage.SUB_APP_TYPE__IDENTIFICATION:
				setIdentification((Identification)null);
				return;
			case FunctionblocksPackage.SUB_APP_TYPE__VERSION_INFO:
				getVersionInfo().clear();
				return;
			case FunctionblocksPackage.SUB_APP_TYPE__COMPILER_INFO:
				setCompilerInfo((CompilerInfo)null);
				return;
			case FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_INTERFACE_LIST:
				setSubAppInterfaceList((SubAppInterfaceList)null);
				return;
			case FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_NETWORK:
				setSubAppNetwork((SubAppNetwork)null);
				return;
			case FunctionblocksPackage.SUB_APP_TYPE__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case FunctionblocksPackage.SUB_APP_TYPE__NAME:
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
			case FunctionblocksPackage.SUB_APP_TYPE__IDENTIFICATION:
				return identification != null;
			case FunctionblocksPackage.SUB_APP_TYPE__VERSION_INFO:
				return versionInfo != null && !versionInfo.isEmpty();
			case FunctionblocksPackage.SUB_APP_TYPE__COMPILER_INFO:
				return compilerInfo != null;
			case FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_INTERFACE_LIST:
				return subAppInterfaceList != null;
			case FunctionblocksPackage.SUB_APP_TYPE__SUB_APP_NETWORK:
				return subAppNetwork != null;
			case FunctionblocksPackage.SUB_APP_TYPE__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case FunctionblocksPackage.SUB_APP_TYPE__NAME:
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

} //SubAppTypeImpl
