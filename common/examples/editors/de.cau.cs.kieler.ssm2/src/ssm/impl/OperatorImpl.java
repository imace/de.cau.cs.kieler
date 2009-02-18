/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import ssm.Operator;
import ssm.OperatorKind;
import ssm.Trigger;
import ssm.ssmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ssm.impl.OperatorImpl#getOperatorKind <em>Operator Kind</em>}</li>
 *   <li>{@link ssm.impl.OperatorImpl#getParentTrigger <em>Parent Trigger</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorImpl extends EObjectImpl implements Operator {
	/**
	 * The default value of the '{@link #getOperatorKind() <em>Operator Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorKind()
	 * @generated
	 * @ordered
	 */
	protected static final OperatorKind OPERATOR_KIND_EDEFAULT = OperatorKind.NOT;

	/**
	 * The cached value of the '{@link #getOperatorKind() <em>Operator Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorKind()
	 * @generated
	 * @ordered
	 */
	protected OperatorKind operatorKind = OPERATOR_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ssmPackage.Literals.OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorKind getOperatorKind() {
		return operatorKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperatorKind(OperatorKind newOperatorKind) {
		OperatorKind oldOperatorKind = operatorKind;
		operatorKind = newOperatorKind == null ? OPERATOR_KIND_EDEFAULT : newOperatorKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.OPERATOR__OPERATOR_KIND, oldOperatorKind, operatorKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trigger getParentTrigger() {
		if (eContainerFeatureID != ssmPackage.OPERATOR__PARENT_TRIGGER) return null;
		return (Trigger)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentTrigger(Trigger newParentTrigger, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentTrigger, ssmPackage.OPERATOR__PARENT_TRIGGER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentTrigger(Trigger newParentTrigger) {
		if (newParentTrigger != eInternalContainer() || (eContainerFeatureID != ssmPackage.OPERATOR__PARENT_TRIGGER && newParentTrigger != null)) {
			if (EcoreUtil.isAncestor(this, newParentTrigger))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentTrigger != null)
				msgs = ((InternalEObject)newParentTrigger).eInverseAdd(this, ssmPackage.TRIGGER__OPERATOR, Trigger.class, msgs);
			msgs = basicSetParentTrigger(newParentTrigger, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.OPERATOR__PARENT_TRIGGER, newParentTrigger, newParentTrigger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ssmPackage.OPERATOR__PARENT_TRIGGER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentTrigger((Trigger)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ssmPackage.OPERATOR__PARENT_TRIGGER:
				return basicSetParentTrigger(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case ssmPackage.OPERATOR__PARENT_TRIGGER:
				return eInternalContainer().eInverseRemove(this, ssmPackage.TRIGGER__OPERATOR, Trigger.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ssmPackage.OPERATOR__OPERATOR_KIND:
				return getOperatorKind();
			case ssmPackage.OPERATOR__PARENT_TRIGGER:
				return getParentTrigger();
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
			case ssmPackage.OPERATOR__OPERATOR_KIND:
				setOperatorKind((OperatorKind)newValue);
				return;
			case ssmPackage.OPERATOR__PARENT_TRIGGER:
				setParentTrigger((Trigger)newValue);
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
			case ssmPackage.OPERATOR__OPERATOR_KIND:
				setOperatorKind(OPERATOR_KIND_EDEFAULT);
				return;
			case ssmPackage.OPERATOR__PARENT_TRIGGER:
				setParentTrigger((Trigger)null);
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
			case ssmPackage.OPERATOR__OPERATOR_KIND:
				return operatorKind != OPERATOR_KIND_EDEFAULT;
			case ssmPackage.OPERATOR__PARENT_TRIGGER:
				return getParentTrigger() != null;
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
		result.append(" (operatorKind: ");
		result.append(operatorKind);
		result.append(')');
		return result.toString();
	}

} //OperatorImpl
