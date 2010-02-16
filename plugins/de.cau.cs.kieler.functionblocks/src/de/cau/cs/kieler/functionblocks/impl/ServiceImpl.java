/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks.impl;

import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;
import de.cau.cs.kieler.functionblocks.Service;
import de.cau.cs.kieler.functionblocks.ServiceSequence;

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
 * An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ServiceImpl#getServiceSequence <em>Service Sequence</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ServiceImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ServiceImpl#getLeftInterface <em>Left Interface</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ServiceImpl#getRightInterface <em>Right Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceImpl extends EObjectImpl implements Service {
	/**
	 * The cached value of the '{@link #getServiceSequence() <em>Service Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceSequence> serviceSequence;

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
	 * The default value of the '{@link #getLeftInterface() <em>Left Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftInterface()
	 * @generated
	 * @ordered
	 */
	protected static final String LEFT_INTERFACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLeftInterface() <em>Left Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftInterface()
	 * @generated
	 * @ordered
	 */
	protected String leftInterface = LEFT_INTERFACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRightInterface() <em>Right Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightInterface()
	 * @generated
	 * @ordered
	 */
	protected static final String RIGHT_INTERFACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRightInterface() <em>Right Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightInterface()
	 * @generated
	 * @ordered
	 */
	protected String rightInterface = RIGHT_INTERFACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblocksPackage.Literals.SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceSequence> getServiceSequence() {
		if (serviceSequence == null) {
			serviceSequence = new EObjectContainmentEList<ServiceSequence>(ServiceSequence.class, this, FunctionblocksPackage.SERVICE__SERVICE_SEQUENCE);
		}
		return serviceSequence;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SERVICE__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLeftInterface() {
		return leftInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftInterface(String newLeftInterface) {
		String oldLeftInterface = leftInterface;
		leftInterface = newLeftInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SERVICE__LEFT_INTERFACE, oldLeftInterface, leftInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRightInterface() {
		return rightInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightInterface(String newRightInterface) {
		String oldRightInterface = rightInterface;
		rightInterface = newRightInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SERVICE__RIGHT_INTERFACE, oldRightInterface, rightInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblocksPackage.SERVICE__SERVICE_SEQUENCE:
				return ((InternalEList<?>)getServiceSequence()).basicRemove(otherEnd, msgs);
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
			case FunctionblocksPackage.SERVICE__SERVICE_SEQUENCE:
				return getServiceSequence();
			case FunctionblocksPackage.SERVICE__COMMENT:
				return getComment();
			case FunctionblocksPackage.SERVICE__LEFT_INTERFACE:
				return getLeftInterface();
			case FunctionblocksPackage.SERVICE__RIGHT_INTERFACE:
				return getRightInterface();
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
			case FunctionblocksPackage.SERVICE__SERVICE_SEQUENCE:
				getServiceSequence().clear();
				getServiceSequence().addAll((Collection<? extends ServiceSequence>)newValue);
				return;
			case FunctionblocksPackage.SERVICE__COMMENT:
				setComment((String)newValue);
				return;
			case FunctionblocksPackage.SERVICE__LEFT_INTERFACE:
				setLeftInterface((String)newValue);
				return;
			case FunctionblocksPackage.SERVICE__RIGHT_INTERFACE:
				setRightInterface((String)newValue);
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
			case FunctionblocksPackage.SERVICE__SERVICE_SEQUENCE:
				getServiceSequence().clear();
				return;
			case FunctionblocksPackage.SERVICE__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case FunctionblocksPackage.SERVICE__LEFT_INTERFACE:
				setLeftInterface(LEFT_INTERFACE_EDEFAULT);
				return;
			case FunctionblocksPackage.SERVICE__RIGHT_INTERFACE:
				setRightInterface(RIGHT_INTERFACE_EDEFAULT);
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
			case FunctionblocksPackage.SERVICE__SERVICE_SEQUENCE:
				return serviceSequence != null && !serviceSequence.isEmpty();
			case FunctionblocksPackage.SERVICE__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case FunctionblocksPackage.SERVICE__LEFT_INTERFACE:
				return LEFT_INTERFACE_EDEFAULT == null ? leftInterface != null : !LEFT_INTERFACE_EDEFAULT.equals(leftInterface);
			case FunctionblocksPackage.SERVICE__RIGHT_INTERFACE:
				return RIGHT_INTERFACE_EDEFAULT == null ? rightInterface != null : !RIGHT_INTERFACE_EDEFAULT.equals(rightInterface);
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
		result.append(", leftInterface: ");
		result.append(leftInterface);
		result.append(", rightInterface: ");
		result.append(rightInterface);
		result.append(')');
		return result.toString();
	}

} //ServiceImpl
