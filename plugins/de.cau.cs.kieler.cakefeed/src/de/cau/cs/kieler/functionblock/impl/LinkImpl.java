/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblock.impl;

import de.cau.cs.kieler.functionblock.FunctionblockPackage;
import de.cau.cs.kieler.functionblock.Link;
import de.cau.cs.kieler.functionblock.Parameter;

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
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.LinkImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.LinkImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.LinkImpl#getCommResource <em>Comm Resource</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.LinkImpl#getSegmentName <em>Segment Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkImpl extends EObjectImpl implements Link {
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
	 * The default value of the '{@link #getCommResource() <em>Comm Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommResource()
	 * @generated
	 * @ordered
	 */
	protected static final String COMM_RESOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommResource() <em>Comm Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommResource()
	 * @generated
	 * @ordered
	 */
	protected String commResource = COMM_RESOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSegmentName() <em>Segment Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSegmentName()
	 * @generated
	 * @ordered
	 */
	protected static final String SEGMENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSegmentName() <em>Segment Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSegmentName()
	 * @generated
	 * @ordered
	 */
	protected String segmentName = SEGMENT_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblockPackage.Literals.LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<Parameter>(Parameter.class, this, FunctionblockPackage.LINK__PARAMETER);
		}
		return parameter;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblockPackage.LINK__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommResource() {
		return commResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommResource(String newCommResource) {
		String oldCommResource = commResource;
		commResource = newCommResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblockPackage.LINK__COMM_RESOURCE, oldCommResource, commResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSegmentName() {
		return segmentName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSegmentName(String newSegmentName) {
		String oldSegmentName = segmentName;
		segmentName = newSegmentName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblockPackage.LINK__SEGMENT_NAME, oldSegmentName, segmentName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblockPackage.LINK__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
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
			case FunctionblockPackage.LINK__PARAMETER:
				return getParameter();
			case FunctionblockPackage.LINK__COMMENT:
				return getComment();
			case FunctionblockPackage.LINK__COMM_RESOURCE:
				return getCommResource();
			case FunctionblockPackage.LINK__SEGMENT_NAME:
				return getSegmentName();
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
			case FunctionblockPackage.LINK__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends Parameter>)newValue);
				return;
			case FunctionblockPackage.LINK__COMMENT:
				setComment((String)newValue);
				return;
			case FunctionblockPackage.LINK__COMM_RESOURCE:
				setCommResource((String)newValue);
				return;
			case FunctionblockPackage.LINK__SEGMENT_NAME:
				setSegmentName((String)newValue);
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
			case FunctionblockPackage.LINK__PARAMETER:
				getParameter().clear();
				return;
			case FunctionblockPackage.LINK__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case FunctionblockPackage.LINK__COMM_RESOURCE:
				setCommResource(COMM_RESOURCE_EDEFAULT);
				return;
			case FunctionblockPackage.LINK__SEGMENT_NAME:
				setSegmentName(SEGMENT_NAME_EDEFAULT);
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
			case FunctionblockPackage.LINK__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case FunctionblockPackage.LINK__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case FunctionblockPackage.LINK__COMM_RESOURCE:
				return COMM_RESOURCE_EDEFAULT == null ? commResource != null : !COMM_RESOURCE_EDEFAULT.equals(commResource);
			case FunctionblockPackage.LINK__SEGMENT_NAME:
				return SEGMENT_NAME_EDEFAULT == null ? segmentName != null : !SEGMENT_NAME_EDEFAULT.equals(segmentName);
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
		result.append(", commResource: ");
		result.append(commResource);
		result.append(", segmentName: ");
		result.append(segmentName);
		result.append(')');
		return result.toString();
	}

} //LinkImpl
