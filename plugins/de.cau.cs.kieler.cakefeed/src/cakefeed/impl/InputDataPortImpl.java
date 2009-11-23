/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.impl;

import cakefeed.CakefeedPackage;
import cakefeed.DataConnection;
import cakefeed.FunctionBlock;
import cakefeed.InputAssociation;
import cakefeed.InputDataPort;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Data Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cakefeed.impl.InputDataPortImpl#getParentFunctionBlock <em>Parent Function Block</em>}</li>
 *   <li>{@link cakefeed.impl.InputDataPortImpl#getEventConnections <em>Event Connections</em>}</li>
 *   <li>{@link cakefeed.impl.InputDataPortImpl#getInputAssociations <em>Input Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputDataPortImpl extends DataPortImpl implements InputDataPort {
	/**
	 * The cached value of the '{@link #getEventConnections() <em>Event Connections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<DataConnection> eventConnections;

	/**
	 * The cached value of the '{@link #getInputAssociations() <em>Input Associations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<InputAssociation> inputAssociations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputDataPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.INPUT_DATA_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionBlock getParentFunctionBlock() {
		if (eContainerFeatureID() != CakefeedPackage.INPUT_DATA_PORT__PARENT_FUNCTION_BLOCK) return null;
		return (FunctionBlock)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentFunctionBlock(FunctionBlock newParentFunctionBlock, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentFunctionBlock, CakefeedPackage.INPUT_DATA_PORT__PARENT_FUNCTION_BLOCK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentFunctionBlock(FunctionBlock newParentFunctionBlock) {
		if (newParentFunctionBlock != eInternalContainer() || (eContainerFeatureID() != CakefeedPackage.INPUT_DATA_PORT__PARENT_FUNCTION_BLOCK && newParentFunctionBlock != null)) {
			if (EcoreUtil.isAncestor(this, newParentFunctionBlock))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentFunctionBlock != null)
				msgs = ((InternalEObject)newParentFunctionBlock).eInverseAdd(this, CakefeedPackage.FUNCTION_BLOCK__INPUT_DATA_PORTS, FunctionBlock.class, msgs);
			msgs = basicSetParentFunctionBlock(newParentFunctionBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.INPUT_DATA_PORT__PARENT_FUNCTION_BLOCK, newParentFunctionBlock, newParentFunctionBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataConnection> getEventConnections() {
		if (eventConnections == null) {
			eventConnections = new EObjectWithInverseResolvingEList<DataConnection>(DataConnection.class, this, CakefeedPackage.INPUT_DATA_PORT__EVENT_CONNECTIONS, CakefeedPackage.DATA_CONNECTION__TARGET_DATA_PORT);
		}
		return eventConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputAssociation> getInputAssociations() {
		if (inputAssociations == null) {
			inputAssociations = new EObjectWithInverseResolvingEList<InputAssociation>(InputAssociation.class, this, CakefeedPackage.INPUT_DATA_PORT__INPUT_ASSOCIATIONS, CakefeedPackage.INPUT_ASSOCIATION__TARGET_INPUT_DATA_PORT);
		}
		return inputAssociations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.INPUT_DATA_PORT__PARENT_FUNCTION_BLOCK:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentFunctionBlock((FunctionBlock)otherEnd, msgs);
			case CakefeedPackage.INPUT_DATA_PORT__EVENT_CONNECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEventConnections()).basicAdd(otherEnd, msgs);
			case CakefeedPackage.INPUT_DATA_PORT__INPUT_ASSOCIATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputAssociations()).basicAdd(otherEnd, msgs);
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
			case CakefeedPackage.INPUT_DATA_PORT__PARENT_FUNCTION_BLOCK:
				return basicSetParentFunctionBlock(null, msgs);
			case CakefeedPackage.INPUT_DATA_PORT__EVENT_CONNECTIONS:
				return ((InternalEList<?>)getEventConnections()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.INPUT_DATA_PORT__INPUT_ASSOCIATIONS:
				return ((InternalEList<?>)getInputAssociations()).basicRemove(otherEnd, msgs);
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
		switch (eContainerFeatureID()) {
			case CakefeedPackage.INPUT_DATA_PORT__PARENT_FUNCTION_BLOCK:
				return eInternalContainer().eInverseRemove(this, CakefeedPackage.FUNCTION_BLOCK__INPUT_DATA_PORTS, FunctionBlock.class, msgs);
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
			case CakefeedPackage.INPUT_DATA_PORT__PARENT_FUNCTION_BLOCK:
				return getParentFunctionBlock();
			case CakefeedPackage.INPUT_DATA_PORT__EVENT_CONNECTIONS:
				return getEventConnections();
			case CakefeedPackage.INPUT_DATA_PORT__INPUT_ASSOCIATIONS:
				return getInputAssociations();
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
			case CakefeedPackage.INPUT_DATA_PORT__PARENT_FUNCTION_BLOCK:
				setParentFunctionBlock((FunctionBlock)newValue);
				return;
			case CakefeedPackage.INPUT_DATA_PORT__EVENT_CONNECTIONS:
				getEventConnections().clear();
				getEventConnections().addAll((Collection<? extends DataConnection>)newValue);
				return;
			case CakefeedPackage.INPUT_DATA_PORT__INPUT_ASSOCIATIONS:
				getInputAssociations().clear();
				getInputAssociations().addAll((Collection<? extends InputAssociation>)newValue);
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
			case CakefeedPackage.INPUT_DATA_PORT__PARENT_FUNCTION_BLOCK:
				setParentFunctionBlock((FunctionBlock)null);
				return;
			case CakefeedPackage.INPUT_DATA_PORT__EVENT_CONNECTIONS:
				getEventConnections().clear();
				return;
			case CakefeedPackage.INPUT_DATA_PORT__INPUT_ASSOCIATIONS:
				getInputAssociations().clear();
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
			case CakefeedPackage.INPUT_DATA_PORT__PARENT_FUNCTION_BLOCK:
				return getParentFunctionBlock() != null;
			case CakefeedPackage.INPUT_DATA_PORT__EVENT_CONNECTIONS:
				return eventConnections != null && !eventConnections.isEmpty();
			case CakefeedPackage.INPUT_DATA_PORT__INPUT_ASSOCIATIONS:
				return inputAssociations != null && !inputAssociations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InputDataPortImpl
