/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.impl;

import cakefeed.CakefeedPackage;
import cakefeed.CompositeFunctionBlock;
import cakefeed.CompositeNetwork;
import cakefeed.InputDataPort;
import cakefeed.InputEventPort;
import cakefeed.OutputDataPort;
import cakefeed.OutputEventPort;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Network</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cakefeed.impl.CompositeNetworkImpl#getParentCompositeFunctionBlock <em>Parent Composite Function Block</em>}</li>
 *   <li>{@link cakefeed.impl.CompositeNetworkImpl#getInputEvents <em>Input Events</em>}</li>
 *   <li>{@link cakefeed.impl.CompositeNetworkImpl#getOutputEvents <em>Output Events</em>}</li>
 *   <li>{@link cakefeed.impl.CompositeNetworkImpl#getInputData <em>Input Data</em>}</li>
 *   <li>{@link cakefeed.impl.CompositeNetworkImpl#getOutputData <em>Output Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeNetworkImpl extends ApplicationImpl implements CompositeNetwork {
	/**
	 * The cached value of the '{@link #getParentCompositeFunctionBlock() <em>Parent Composite Function Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentCompositeFunctionBlock()
	 * @generated
	 * @ordered
	 */
	protected CompositeFunctionBlock parentCompositeFunctionBlock;

	/**
	 * The cached value of the '{@link #getInputEvents() <em>Input Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputEventPort> inputEvents;

	/**
	 * The cached value of the '{@link #getOutputEvents() <em>Output Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<InputEventPort> outputEvents;

	/**
	 * The cached value of the '{@link #getInputData() <em>Input Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputData()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputDataPort> inputData;

	/**
	 * The cached value of the '{@link #getOutputData() <em>Output Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputData()
	 * @generated
	 * @ordered
	 */
	protected EList<InputDataPort> outputData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeNetworkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.COMPOSITE_NETWORK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeFunctionBlock getParentCompositeFunctionBlock() {
		if (parentCompositeFunctionBlock != null && parentCompositeFunctionBlock.eIsProxy()) {
			InternalEObject oldParentCompositeFunctionBlock = (InternalEObject)parentCompositeFunctionBlock;
			parentCompositeFunctionBlock = (CompositeFunctionBlock)eResolveProxy(oldParentCompositeFunctionBlock);
			if (parentCompositeFunctionBlock != oldParentCompositeFunctionBlock) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK, oldParentCompositeFunctionBlock, parentCompositeFunctionBlock));
			}
		}
		return parentCompositeFunctionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeFunctionBlock basicGetParentCompositeFunctionBlock() {
		return parentCompositeFunctionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentCompositeFunctionBlock(CompositeFunctionBlock newParentCompositeFunctionBlock, NotificationChain msgs) {
		CompositeFunctionBlock oldParentCompositeFunctionBlock = parentCompositeFunctionBlock;
		parentCompositeFunctionBlock = newParentCompositeFunctionBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK, oldParentCompositeFunctionBlock, newParentCompositeFunctionBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentCompositeFunctionBlock(CompositeFunctionBlock newParentCompositeFunctionBlock) {
		if (newParentCompositeFunctionBlock != parentCompositeFunctionBlock) {
			NotificationChain msgs = null;
			if (parentCompositeFunctionBlock != null)
				msgs = ((InternalEObject)parentCompositeFunctionBlock).eInverseRemove(this, CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK, CompositeFunctionBlock.class, msgs);
			if (newParentCompositeFunctionBlock != null)
				msgs = ((InternalEObject)newParentCompositeFunctionBlock).eInverseAdd(this, CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK, CompositeFunctionBlock.class, msgs);
			msgs = basicSetParentCompositeFunctionBlock(newParentCompositeFunctionBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK, newParentCompositeFunctionBlock, newParentCompositeFunctionBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputEventPort> getInputEvents() {
		if (inputEvents == null) {
			inputEvents = new EObjectContainmentEList<OutputEventPort>(OutputEventPort.class, this, CakefeedPackage.COMPOSITE_NETWORK__INPUT_EVENTS);
		}
		return inputEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputEventPort> getOutputEvents() {
		if (outputEvents == null) {
			outputEvents = new EObjectContainmentEList<InputEventPort>(InputEventPort.class, this, CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_EVENTS);
		}
		return outputEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputDataPort> getInputData() {
		if (inputData == null) {
			inputData = new EObjectContainmentEList<OutputDataPort>(OutputDataPort.class, this, CakefeedPackage.COMPOSITE_NETWORK__INPUT_DATA);
		}
		return inputData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputDataPort> getOutputData() {
		if (outputData == null) {
			outputData = new EObjectContainmentEList<InputDataPort>(InputDataPort.class, this, CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_DATA);
		}
		return outputData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK:
				if (parentCompositeFunctionBlock != null)
					msgs = ((InternalEObject)parentCompositeFunctionBlock).eInverseRemove(this, CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK, CompositeFunctionBlock.class, msgs);
				return basicSetParentCompositeFunctionBlock((CompositeFunctionBlock)otherEnd, msgs);
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
			case CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK:
				return basicSetParentCompositeFunctionBlock(null, msgs);
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_EVENTS:
				return ((InternalEList<?>)getInputEvents()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_EVENTS:
				return ((InternalEList<?>)getOutputEvents()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_DATA:
				return ((InternalEList<?>)getInputData()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_DATA:
				return ((InternalEList<?>)getOutputData()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK:
				if (resolve) return getParentCompositeFunctionBlock();
				return basicGetParentCompositeFunctionBlock();
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_EVENTS:
				return getInputEvents();
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_EVENTS:
				return getOutputEvents();
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_DATA:
				return getInputData();
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_DATA:
				return getOutputData();
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
			case CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK:
				setParentCompositeFunctionBlock((CompositeFunctionBlock)newValue);
				return;
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_EVENTS:
				getInputEvents().clear();
				getInputEvents().addAll((Collection<? extends OutputEventPort>)newValue);
				return;
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_EVENTS:
				getOutputEvents().clear();
				getOutputEvents().addAll((Collection<? extends InputEventPort>)newValue);
				return;
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_DATA:
				getInputData().clear();
				getInputData().addAll((Collection<? extends OutputDataPort>)newValue);
				return;
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_DATA:
				getOutputData().clear();
				getOutputData().addAll((Collection<? extends InputDataPort>)newValue);
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
			case CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK:
				setParentCompositeFunctionBlock((CompositeFunctionBlock)null);
				return;
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_EVENTS:
				getInputEvents().clear();
				return;
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_EVENTS:
				getOutputEvents().clear();
				return;
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_DATA:
				getInputData().clear();
				return;
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_DATA:
				getOutputData().clear();
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
			case CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK:
				return parentCompositeFunctionBlock != null;
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_EVENTS:
				return inputEvents != null && !inputEvents.isEmpty();
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_EVENTS:
				return outputEvents != null && !outputEvents.isEmpty();
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_DATA:
				return inputData != null && !inputData.isEmpty();
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_DATA:
				return outputData != null && !outputData.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeNetworkImpl
