/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kInsets;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>kInsets</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kInsetsImpl#getBottom <em>Bottom</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kInsetsImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kInsetsImpl#getRight <em>Right</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kInsetsImpl#getTop <em>Top</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class kInsetsImpl extends EObjectImpl implements kInsets {
	/**
	 * The default value of the '{@link #getBottom() <em>Bottom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBottom()
	 * @generated
	 * @ordered
	 */
	protected static final float BOTTOM_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getBottom() <em>Bottom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBottom()
	 * @generated
	 * @ordered
	 */
	protected float bottom = BOTTOM_EDEFAULT;

	/**
	 * The default value of the '{@link #getLeft() <em>Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
	protected static final float LEFT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getLeft() <em>Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
	protected float left = LEFT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRight() <em>Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
	protected static final float RIGHT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getRight() <em>Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
	protected float right = RIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTop() <em>Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTop()
	 * @generated
	 * @ordered
	 */
	protected static final float TOP_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getTop() <em>Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTop()
	 * @generated
	 * @ordered
	 */
	protected float top = TOP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected kInsetsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KimlLayoutGraphPackage.Literals.KINSETS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getBottom() {
		return bottom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottom(float newBottom) {
		float oldBottom = bottom;
		bottom = newBottom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KINSETS__BOTTOM, oldBottom, bottom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLeft() {
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeft(float newLeft) {
		float oldLeft = left;
		left = newLeft;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KINSETS__LEFT, oldLeft, left));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRight() {
		return right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRight(float newRight) {
		float oldRight = right;
		right = newRight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KINSETS__RIGHT, oldRight, right));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTop() {
		return top;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTop(float newTop) {
		float oldTop = top;
		top = newTop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KINSETS__TOP, oldTop, top));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KimlLayoutGraphPackage.KINSETS__BOTTOM:
				return new Float(getBottom());
			case KimlLayoutGraphPackage.KINSETS__LEFT:
				return new Float(getLeft());
			case KimlLayoutGraphPackage.KINSETS__RIGHT:
				return new Float(getRight());
			case KimlLayoutGraphPackage.KINSETS__TOP:
				return new Float(getTop());
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
			case KimlLayoutGraphPackage.KINSETS__BOTTOM:
				setBottom(((Float)newValue).floatValue());
				return;
			case KimlLayoutGraphPackage.KINSETS__LEFT:
				setLeft(((Float)newValue).floatValue());
				return;
			case KimlLayoutGraphPackage.KINSETS__RIGHT:
				setRight(((Float)newValue).floatValue());
				return;
			case KimlLayoutGraphPackage.KINSETS__TOP:
				setTop(((Float)newValue).floatValue());
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
			case KimlLayoutGraphPackage.KINSETS__BOTTOM:
				setBottom(BOTTOM_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.KINSETS__LEFT:
				setLeft(LEFT_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.KINSETS__RIGHT:
				setRight(RIGHT_EDEFAULT);
				return;
			case KimlLayoutGraphPackage.KINSETS__TOP:
				setTop(TOP_EDEFAULT);
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
			case KimlLayoutGraphPackage.KINSETS__BOTTOM:
				return bottom != BOTTOM_EDEFAULT;
			case KimlLayoutGraphPackage.KINSETS__LEFT:
				return left != LEFT_EDEFAULT;
			case KimlLayoutGraphPackage.KINSETS__RIGHT:
				return right != RIGHT_EDEFAULT;
			case KimlLayoutGraphPackage.KINSETS__TOP:
				return top != TOP_EDEFAULT;
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
		result.append(" (bottom: ");
		result.append(bottom);
		result.append(", left: ");
		result.append(left);
		result.append(", right: ");
		result.append(right);
		result.append(", top: ");
		result.append(top);
		result.append(')');
		return result.toString();
	}

} //kInsetsImpl
