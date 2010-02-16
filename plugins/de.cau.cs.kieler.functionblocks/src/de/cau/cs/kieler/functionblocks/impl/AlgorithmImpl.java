/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks.impl;

import de.cau.cs.kieler.functionblocks.Algorithm;
import de.cau.cs.kieler.functionblocks.FBD;
import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;
import de.cau.cs.kieler.functionblocks.LD;
import de.cau.cs.kieler.functionblocks.Other;
import de.cau.cs.kieler.functionblocks.ST;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Algorithm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.AlgorithmImpl#getFBD <em>FBD</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.AlgorithmImpl#getST <em>ST</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.AlgorithmImpl#getLD <em>LD</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.AlgorithmImpl#getOther <em>Other</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.AlgorithmImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.AlgorithmImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AlgorithmImpl extends EObjectImpl implements Algorithm {
	/**
	 * The cached value of the '{@link #getFBD() <em>FBD</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFBD()
	 * @generated
	 * @ordered
	 */
	protected FBD fBD;

	/**
	 * The cached value of the '{@link #getST() <em>ST</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getST()
	 * @generated
	 * @ordered
	 */
	protected ST sT;

	/**
	 * The cached value of the '{@link #getLD() <em>LD</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLD()
	 * @generated
	 * @ordered
	 */
	protected LD lD;

	/**
	 * The cached value of the '{@link #getOther() <em>Other</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOther()
	 * @generated
	 * @ordered
	 */
	protected Other other;

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
		return FunctionblocksPackage.Literals.ALGORITHM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FBD getFBD() {
		return fBD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFBD(FBD newFBD, NotificationChain msgs) {
		FBD oldFBD = fBD;
		fBD = newFBD;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.ALGORITHM__FBD, oldFBD, newFBD);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFBD(FBD newFBD) {
		if (newFBD != fBD) {
			NotificationChain msgs = null;
			if (fBD != null)
				msgs = ((InternalEObject)fBD).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.ALGORITHM__FBD, null, msgs);
			if (newFBD != null)
				msgs = ((InternalEObject)newFBD).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.ALGORITHM__FBD, null, msgs);
			msgs = basicSetFBD(newFBD, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.ALGORITHM__FBD, newFBD, newFBD));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ST getST() {
		return sT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetST(ST newST, NotificationChain msgs) {
		ST oldST = sT;
		sT = newST;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.ALGORITHM__ST, oldST, newST);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setST(ST newST) {
		if (newST != sT) {
			NotificationChain msgs = null;
			if (sT != null)
				msgs = ((InternalEObject)sT).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.ALGORITHM__ST, null, msgs);
			if (newST != null)
				msgs = ((InternalEObject)newST).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.ALGORITHM__ST, null, msgs);
			msgs = basicSetST(newST, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.ALGORITHM__ST, newST, newST));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LD getLD() {
		return lD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLD(LD newLD, NotificationChain msgs) {
		LD oldLD = lD;
		lD = newLD;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.ALGORITHM__LD, oldLD, newLD);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLD(LD newLD) {
		if (newLD != lD) {
			NotificationChain msgs = null;
			if (lD != null)
				msgs = ((InternalEObject)lD).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.ALGORITHM__LD, null, msgs);
			if (newLD != null)
				msgs = ((InternalEObject)newLD).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.ALGORITHM__LD, null, msgs);
			msgs = basicSetLD(newLD, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.ALGORITHM__LD, newLD, newLD));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Other getOther() {
		return other;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOther(Other newOther, NotificationChain msgs) {
		Other oldOther = other;
		other = newOther;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.ALGORITHM__OTHER, oldOther, newOther);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOther(Other newOther) {
		if (newOther != other) {
			NotificationChain msgs = null;
			if (other != null)
				msgs = ((InternalEObject)other).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.ALGORITHM__OTHER, null, msgs);
			if (newOther != null)
				msgs = ((InternalEObject)newOther).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.ALGORITHM__OTHER, null, msgs);
			msgs = basicSetOther(newOther, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.ALGORITHM__OTHER, newOther, newOther));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.ALGORITHM__COMMENT, oldComment, comment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.ALGORITHM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblocksPackage.ALGORITHM__FBD:
				return basicSetFBD(null, msgs);
			case FunctionblocksPackage.ALGORITHM__ST:
				return basicSetST(null, msgs);
			case FunctionblocksPackage.ALGORITHM__LD:
				return basicSetLD(null, msgs);
			case FunctionblocksPackage.ALGORITHM__OTHER:
				return basicSetOther(null, msgs);
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
			case FunctionblocksPackage.ALGORITHM__FBD:
				return getFBD();
			case FunctionblocksPackage.ALGORITHM__ST:
				return getST();
			case FunctionblocksPackage.ALGORITHM__LD:
				return getLD();
			case FunctionblocksPackage.ALGORITHM__OTHER:
				return getOther();
			case FunctionblocksPackage.ALGORITHM__COMMENT:
				return getComment();
			case FunctionblocksPackage.ALGORITHM__NAME:
				return getName();
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
			case FunctionblocksPackage.ALGORITHM__FBD:
				setFBD((FBD)newValue);
				return;
			case FunctionblocksPackage.ALGORITHM__ST:
				setST((ST)newValue);
				return;
			case FunctionblocksPackage.ALGORITHM__LD:
				setLD((LD)newValue);
				return;
			case FunctionblocksPackage.ALGORITHM__OTHER:
				setOther((Other)newValue);
				return;
			case FunctionblocksPackage.ALGORITHM__COMMENT:
				setComment((String)newValue);
				return;
			case FunctionblocksPackage.ALGORITHM__NAME:
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
			case FunctionblocksPackage.ALGORITHM__FBD:
				setFBD((FBD)null);
				return;
			case FunctionblocksPackage.ALGORITHM__ST:
				setST((ST)null);
				return;
			case FunctionblocksPackage.ALGORITHM__LD:
				setLD((LD)null);
				return;
			case FunctionblocksPackage.ALGORITHM__OTHER:
				setOther((Other)null);
				return;
			case FunctionblocksPackage.ALGORITHM__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case FunctionblocksPackage.ALGORITHM__NAME:
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
			case FunctionblocksPackage.ALGORITHM__FBD:
				return fBD != null;
			case FunctionblocksPackage.ALGORITHM__ST:
				return sT != null;
			case FunctionblocksPackage.ALGORITHM__LD:
				return lD != null;
			case FunctionblocksPackage.ALGORITHM__OTHER:
				return other != null;
			case FunctionblocksPackage.ALGORITHM__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case FunctionblocksPackage.ALGORITHM__NAME:
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

} //AlgorithmImpl
