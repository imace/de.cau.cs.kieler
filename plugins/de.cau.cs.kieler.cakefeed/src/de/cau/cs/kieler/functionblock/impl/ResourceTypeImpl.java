/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblock.impl;

import de.cau.cs.kieler.functionblock.CompilerInfo;
import de.cau.cs.kieler.functionblock.FBNetwork;
import de.cau.cs.kieler.functionblock.FBTypeName;
import de.cau.cs.kieler.functionblock.FunctionblockPackage;
import de.cau.cs.kieler.functionblock.Identification;
import de.cau.cs.kieler.functionblock.ResourceType;
import de.cau.cs.kieler.functionblock.VarDeclaration;
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
 * An implementation of the model object '<em><b>Resource Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.ResourceTypeImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.ResourceTypeImpl#getVersionInfo <em>Version Info</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.ResourceTypeImpl#getCompilerInfo <em>Compiler Info</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.ResourceTypeImpl#getFBTypeName <em>FB Type Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.ResourceTypeImpl#getVarDeclaration <em>Var Declaration</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.ResourceTypeImpl#getFBNetwork <em>FB Network</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.ResourceTypeImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.ResourceTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceTypeImpl extends EObjectImpl implements ResourceType {
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
	 * The cached value of the '{@link #getFBTypeName() <em>FB Type Name</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFBTypeName()
	 * @generated
	 * @ordered
	 */
	protected EList<FBTypeName> fBTypeName;

	/**
	 * The cached value of the '{@link #getVarDeclaration() <em>Var Declaration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarDeclaration()
	 * @generated
	 * @ordered
	 */
	protected EList<VarDeclaration> varDeclaration;

	/**
	 * The cached value of the '{@link #getFBNetwork() <em>FB Network</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFBNetwork()
	 * @generated
	 * @ordered
	 */
	protected FBNetwork fBNetwork;

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
	protected ResourceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblockPackage.Literals.RESOURCE_TYPE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblockPackage.RESOURCE_TYPE__IDENTIFICATION, oldIdentification, newIdentification);
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
				msgs = ((InternalEObject)identification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblockPackage.RESOURCE_TYPE__IDENTIFICATION, null, msgs);
			if (newIdentification != null)
				msgs = ((InternalEObject)newIdentification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblockPackage.RESOURCE_TYPE__IDENTIFICATION, null, msgs);
			msgs = basicSetIdentification(newIdentification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblockPackage.RESOURCE_TYPE__IDENTIFICATION, newIdentification, newIdentification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VersionInfo> getVersionInfo() {
		if (versionInfo == null) {
			versionInfo = new EObjectContainmentEList<VersionInfo>(VersionInfo.class, this, FunctionblockPackage.RESOURCE_TYPE__VERSION_INFO);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblockPackage.RESOURCE_TYPE__COMPILER_INFO, oldCompilerInfo, newCompilerInfo);
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
				msgs = ((InternalEObject)compilerInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblockPackage.RESOURCE_TYPE__COMPILER_INFO, null, msgs);
			if (newCompilerInfo != null)
				msgs = ((InternalEObject)newCompilerInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblockPackage.RESOURCE_TYPE__COMPILER_INFO, null, msgs);
			msgs = basicSetCompilerInfo(newCompilerInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblockPackage.RESOURCE_TYPE__COMPILER_INFO, newCompilerInfo, newCompilerInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FBTypeName> getFBTypeName() {
		if (fBTypeName == null) {
			fBTypeName = new EObjectContainmentEList<FBTypeName>(FBTypeName.class, this, FunctionblockPackage.RESOURCE_TYPE__FB_TYPE_NAME);
		}
		return fBTypeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VarDeclaration> getVarDeclaration() {
		if (varDeclaration == null) {
			varDeclaration = new EObjectContainmentEList<VarDeclaration>(VarDeclaration.class, this, FunctionblockPackage.RESOURCE_TYPE__VAR_DECLARATION);
		}
		return varDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBNetwork getFBNetwork() {
		return fBNetwork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFBNetwork(FBNetwork newFBNetwork, NotificationChain msgs) {
		FBNetwork oldFBNetwork = fBNetwork;
		fBNetwork = newFBNetwork;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblockPackage.RESOURCE_TYPE__FB_NETWORK, oldFBNetwork, newFBNetwork);
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
		if (newFBNetwork != fBNetwork) {
			NotificationChain msgs = null;
			if (fBNetwork != null)
				msgs = ((InternalEObject)fBNetwork).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblockPackage.RESOURCE_TYPE__FB_NETWORK, null, msgs);
			if (newFBNetwork != null)
				msgs = ((InternalEObject)newFBNetwork).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblockPackage.RESOURCE_TYPE__FB_NETWORK, null, msgs);
			msgs = basicSetFBNetwork(newFBNetwork, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblockPackage.RESOURCE_TYPE__FB_NETWORK, newFBNetwork, newFBNetwork));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblockPackage.RESOURCE_TYPE__COMMENT, oldComment, comment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblockPackage.RESOURCE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblockPackage.RESOURCE_TYPE__IDENTIFICATION:
				return basicSetIdentification(null, msgs);
			case FunctionblockPackage.RESOURCE_TYPE__VERSION_INFO:
				return ((InternalEList<?>)getVersionInfo()).basicRemove(otherEnd, msgs);
			case FunctionblockPackage.RESOURCE_TYPE__COMPILER_INFO:
				return basicSetCompilerInfo(null, msgs);
			case FunctionblockPackage.RESOURCE_TYPE__FB_TYPE_NAME:
				return ((InternalEList<?>)getFBTypeName()).basicRemove(otherEnd, msgs);
			case FunctionblockPackage.RESOURCE_TYPE__VAR_DECLARATION:
				return ((InternalEList<?>)getVarDeclaration()).basicRemove(otherEnd, msgs);
			case FunctionblockPackage.RESOURCE_TYPE__FB_NETWORK:
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
			case FunctionblockPackage.RESOURCE_TYPE__IDENTIFICATION:
				return getIdentification();
			case FunctionblockPackage.RESOURCE_TYPE__VERSION_INFO:
				return getVersionInfo();
			case FunctionblockPackage.RESOURCE_TYPE__COMPILER_INFO:
				return getCompilerInfo();
			case FunctionblockPackage.RESOURCE_TYPE__FB_TYPE_NAME:
				return getFBTypeName();
			case FunctionblockPackage.RESOURCE_TYPE__VAR_DECLARATION:
				return getVarDeclaration();
			case FunctionblockPackage.RESOURCE_TYPE__FB_NETWORK:
				return getFBNetwork();
			case FunctionblockPackage.RESOURCE_TYPE__COMMENT:
				return getComment();
			case FunctionblockPackage.RESOURCE_TYPE__NAME:
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
			case FunctionblockPackage.RESOURCE_TYPE__IDENTIFICATION:
				setIdentification((Identification)newValue);
				return;
			case FunctionblockPackage.RESOURCE_TYPE__VERSION_INFO:
				getVersionInfo().clear();
				getVersionInfo().addAll((Collection<? extends VersionInfo>)newValue);
				return;
			case FunctionblockPackage.RESOURCE_TYPE__COMPILER_INFO:
				setCompilerInfo((CompilerInfo)newValue);
				return;
			case FunctionblockPackage.RESOURCE_TYPE__FB_TYPE_NAME:
				getFBTypeName().clear();
				getFBTypeName().addAll((Collection<? extends FBTypeName>)newValue);
				return;
			case FunctionblockPackage.RESOURCE_TYPE__VAR_DECLARATION:
				getVarDeclaration().clear();
				getVarDeclaration().addAll((Collection<? extends VarDeclaration>)newValue);
				return;
			case FunctionblockPackage.RESOURCE_TYPE__FB_NETWORK:
				setFBNetwork((FBNetwork)newValue);
				return;
			case FunctionblockPackage.RESOURCE_TYPE__COMMENT:
				setComment((String)newValue);
				return;
			case FunctionblockPackage.RESOURCE_TYPE__NAME:
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
			case FunctionblockPackage.RESOURCE_TYPE__IDENTIFICATION:
				setIdentification((Identification)null);
				return;
			case FunctionblockPackage.RESOURCE_TYPE__VERSION_INFO:
				getVersionInfo().clear();
				return;
			case FunctionblockPackage.RESOURCE_TYPE__COMPILER_INFO:
				setCompilerInfo((CompilerInfo)null);
				return;
			case FunctionblockPackage.RESOURCE_TYPE__FB_TYPE_NAME:
				getFBTypeName().clear();
				return;
			case FunctionblockPackage.RESOURCE_TYPE__VAR_DECLARATION:
				getVarDeclaration().clear();
				return;
			case FunctionblockPackage.RESOURCE_TYPE__FB_NETWORK:
				setFBNetwork((FBNetwork)null);
				return;
			case FunctionblockPackage.RESOURCE_TYPE__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case FunctionblockPackage.RESOURCE_TYPE__NAME:
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
			case FunctionblockPackage.RESOURCE_TYPE__IDENTIFICATION:
				return identification != null;
			case FunctionblockPackage.RESOURCE_TYPE__VERSION_INFO:
				return versionInfo != null && !versionInfo.isEmpty();
			case FunctionblockPackage.RESOURCE_TYPE__COMPILER_INFO:
				return compilerInfo != null;
			case FunctionblockPackage.RESOURCE_TYPE__FB_TYPE_NAME:
				return fBTypeName != null && !fBTypeName.isEmpty();
			case FunctionblockPackage.RESOURCE_TYPE__VAR_DECLARATION:
				return varDeclaration != null && !varDeclaration.isEmpty();
			case FunctionblockPackage.RESOURCE_TYPE__FB_NETWORK:
				return fBNetwork != null;
			case FunctionblockPackage.RESOURCE_TYPE__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case FunctionblockPackage.RESOURCE_TYPE__NAME:
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

} //ResourceTypeImpl
