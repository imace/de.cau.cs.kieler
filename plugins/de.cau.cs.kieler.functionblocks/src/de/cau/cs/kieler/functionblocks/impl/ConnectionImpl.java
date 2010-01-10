/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks.impl;

import de.cau.cs.kieler.functionblocks.Connection;
import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ConnectionImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ConnectionImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ConnectionImpl#getDx1 <em>Dx1</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ConnectionImpl#getDx2 <em>Dx2</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ConnectionImpl#getDy <em>Dy</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.ConnectionImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionImpl extends EObjectImpl implements Connection {
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
	 * The default value of the '{@link #getDestination() <em>Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected static final String DESTINATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected String destination = DESTINATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDx1() <em>Dx1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDx1()
	 * @generated
	 * @ordered
	 */
	protected static final String DX1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDx1() <em>Dx1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDx1()
	 * @generated
	 * @ordered
	 */
	protected String dx1 = DX1_EDEFAULT;

	/**
	 * The default value of the '{@link #getDx2() <em>Dx2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDx2()
	 * @generated
	 * @ordered
	 */
	protected static final String DX2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDx2() <em>Dx2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDx2()
	 * @generated
	 * @ordered
	 */
	protected String dx2 = DX2_EDEFAULT;

	/**
	 * The default value of the '{@link #getDy() <em>Dy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDy()
	 * @generated
	 * @ordered
	 */
	protected static final String DY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDy() <em>Dy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDy()
	 * @generated
	 * @ordered
	 */
	protected String dy = DY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected String source = SOURCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblocksPackage.Literals.CONNECTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.CONNECTION__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(String newDestination) {
		String oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.CONNECTION__DESTINATION, oldDestination, destination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDx1() {
		return dx1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDx1(String newDx1) {
		String oldDx1 = dx1;
		dx1 = newDx1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.CONNECTION__DX1, oldDx1, dx1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDx2() {
		return dx2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDx2(String newDx2) {
		String oldDx2 = dx2;
		dx2 = newDx2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.CONNECTION__DX2, oldDx2, dx2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDy() {
		return dy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDy(String newDy) {
		String oldDy = dy;
		dy = newDy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.CONNECTION__DY, oldDy, dy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(String newSource) {
		String oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.CONNECTION__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FunctionblocksPackage.CONNECTION__COMMENT:
				return getComment();
			case FunctionblocksPackage.CONNECTION__DESTINATION:
				return getDestination();
			case FunctionblocksPackage.CONNECTION__DX1:
				return getDx1();
			case FunctionblocksPackage.CONNECTION__DX2:
				return getDx2();
			case FunctionblocksPackage.CONNECTION__DY:
				return getDy();
			case FunctionblocksPackage.CONNECTION__SOURCE:
				return getSource();
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
			case FunctionblocksPackage.CONNECTION__COMMENT:
				setComment((String)newValue);
				return;
			case FunctionblocksPackage.CONNECTION__DESTINATION:
				setDestination((String)newValue);
				return;
			case FunctionblocksPackage.CONNECTION__DX1:
				setDx1((String)newValue);
				return;
			case FunctionblocksPackage.CONNECTION__DX2:
				setDx2((String)newValue);
				return;
			case FunctionblocksPackage.CONNECTION__DY:
				setDy((String)newValue);
				return;
			case FunctionblocksPackage.CONNECTION__SOURCE:
				setSource((String)newValue);
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
			case FunctionblocksPackage.CONNECTION__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case FunctionblocksPackage.CONNECTION__DESTINATION:
				setDestination(DESTINATION_EDEFAULT);
				return;
			case FunctionblocksPackage.CONNECTION__DX1:
				setDx1(DX1_EDEFAULT);
				return;
			case FunctionblocksPackage.CONNECTION__DX2:
				setDx2(DX2_EDEFAULT);
				return;
			case FunctionblocksPackage.CONNECTION__DY:
				setDy(DY_EDEFAULT);
				return;
			case FunctionblocksPackage.CONNECTION__SOURCE:
				setSource(SOURCE_EDEFAULT);
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
			case FunctionblocksPackage.CONNECTION__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case FunctionblocksPackage.CONNECTION__DESTINATION:
				return DESTINATION_EDEFAULT == null ? destination != null : !DESTINATION_EDEFAULT.equals(destination);
			case FunctionblocksPackage.CONNECTION__DX1:
				return DX1_EDEFAULT == null ? dx1 != null : !DX1_EDEFAULT.equals(dx1);
			case FunctionblocksPackage.CONNECTION__DX2:
				return DX2_EDEFAULT == null ? dx2 != null : !DX2_EDEFAULT.equals(dx2);
			case FunctionblocksPackage.CONNECTION__DY:
				return DY_EDEFAULT == null ? dy != null : !DY_EDEFAULT.equals(dy);
			case FunctionblocksPackage.CONNECTION__SOURCE:
				return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
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
		result.append(", destination: ");
		result.append(destination);
		result.append(", dx1: ");
		result.append(dx1);
		result.append(", dx2: ");
		result.append(dx2);
		result.append(", dy: ");
		result.append(dy);
		result.append(", source: ");
		result.append(source);
		result.append(')');
		return result.toString();
	}

} //ConnectionImpl
