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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

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
	 * The cached value of the '{@link #getInputEvents() <em>Input Events</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputEvents()
	 * @generated
	 * @ordered
	 */
	protected OutputEventPort inputEvents;

	/**
	 * The cached value of the '{@link #getOutputEvents() <em>Output Events</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputEvents()
	 * @generated
	 * @ordered
	 */
	protected InputEventPort outputEvents;

	/**
	 * The cached value of the '{@link #getInputData() <em>Input Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputData()
	 * @generated
	 * @ordered
	 */
	protected OutputDataPort inputData;

	/**
	 * The cached value of the '{@link #getOutputData() <em>Output Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputData()
	 * @generated
	 * @ordered
	 */
	protected InputDataPort outputData;

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
		if (eContainerFeatureID() != CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK) return null;
		return (CompositeFunctionBlock)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentCompositeFunctionBlock(CompositeFunctionBlock newParentCompositeFunctionBlock, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentCompositeFunctionBlock, CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentCompositeFunctionBlock(CompositeFunctionBlock newParentCompositeFunctionBlock) {
		if (newParentCompositeFunctionBlock != eInternalContainer() || (eContainerFeatureID() != CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK && newParentCompositeFunctionBlock != null)) {
			if (EcoreUtil.isAncestor(this, newParentCompositeFunctionBlock))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
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
	public OutputEventPort getInputEvents() {
		return inputEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputEvents(OutputEventPort newInputEvents, NotificationChain msgs) {
		OutputEventPort oldInputEvents = inputEvents;
		inputEvents = newInputEvents;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPOSITE_NETWORK__INPUT_EVENTS, oldInputEvents, newInputEvents);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputEvents(OutputEventPort newInputEvents) {
		if (newInputEvents != inputEvents) {
			NotificationChain msgs = null;
			if (inputEvents != null)
				msgs = ((InternalEObject)inputEvents).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.COMPOSITE_NETWORK__INPUT_EVENTS, null, msgs);
			if (newInputEvents != null)
				msgs = ((InternalEObject)newInputEvents).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.COMPOSITE_NETWORK__INPUT_EVENTS, null, msgs);
			msgs = basicSetInputEvents(newInputEvents, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPOSITE_NETWORK__INPUT_EVENTS, newInputEvents, newInputEvents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputEventPort getOutputEvents() {
		return outputEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputEvents(InputEventPort newOutputEvents, NotificationChain msgs) {
		InputEventPort oldOutputEvents = outputEvents;
		outputEvents = newOutputEvents;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_EVENTS, oldOutputEvents, newOutputEvents);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputEvents(InputEventPort newOutputEvents) {
		if (newOutputEvents != outputEvents) {
			NotificationChain msgs = null;
			if (outputEvents != null)
				msgs = ((InternalEObject)outputEvents).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_EVENTS, null, msgs);
			if (newOutputEvents != null)
				msgs = ((InternalEObject)newOutputEvents).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_EVENTS, null, msgs);
			msgs = basicSetOutputEvents(newOutputEvents, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_EVENTS, newOutputEvents, newOutputEvents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputDataPort getInputData() {
		return inputData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputData(OutputDataPort newInputData, NotificationChain msgs) {
		OutputDataPort oldInputData = inputData;
		inputData = newInputData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPOSITE_NETWORK__INPUT_DATA, oldInputData, newInputData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputData(OutputDataPort newInputData) {
		if (newInputData != inputData) {
			NotificationChain msgs = null;
			if (inputData != null)
				msgs = ((InternalEObject)inputData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.COMPOSITE_NETWORK__INPUT_DATA, null, msgs);
			if (newInputData != null)
				msgs = ((InternalEObject)newInputData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.COMPOSITE_NETWORK__INPUT_DATA, null, msgs);
			msgs = basicSetInputData(newInputData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPOSITE_NETWORK__INPUT_DATA, newInputData, newInputData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputDataPort getOutputData() {
		return outputData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputData(InputDataPort newOutputData, NotificationChain msgs) {
		InputDataPort oldOutputData = outputData;
		outputData = newOutputData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_DATA, oldOutputData, newOutputData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputData(InputDataPort newOutputData) {
		if (newOutputData != outputData) {
			NotificationChain msgs = null;
			if (outputData != null)
				msgs = ((InternalEObject)outputData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_DATA, null, msgs);
			if (newOutputData != null)
				msgs = ((InternalEObject)newOutputData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_DATA, null, msgs);
			msgs = basicSetOutputData(newOutputData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_DATA, newOutputData, newOutputData));
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
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
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
				return basicSetInputEvents(null, msgs);
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_EVENTS:
				return basicSetOutputEvents(null, msgs);
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_DATA:
				return basicSetInputData(null, msgs);
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_DATA:
				return basicSetOutputData(null, msgs);
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
			case CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK:
				return eInternalContainer().eInverseRemove(this, CakefeedPackage.COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK, CompositeFunctionBlock.class, msgs);
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
			case CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK:
				return getParentCompositeFunctionBlock();
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CakefeedPackage.COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK:
				setParentCompositeFunctionBlock((CompositeFunctionBlock)newValue);
				return;
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_EVENTS:
				setInputEvents((OutputEventPort)newValue);
				return;
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_EVENTS:
				setOutputEvents((InputEventPort)newValue);
				return;
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_DATA:
				setInputData((OutputDataPort)newValue);
				return;
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_DATA:
				setOutputData((InputDataPort)newValue);
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
				setInputEvents((OutputEventPort)null);
				return;
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_EVENTS:
				setOutputEvents((InputEventPort)null);
				return;
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_DATA:
				setInputData((OutputDataPort)null);
				return;
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_DATA:
				setOutputData((InputDataPort)null);
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
				return getParentCompositeFunctionBlock() != null;
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_EVENTS:
				return inputEvents != null;
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_EVENTS:
				return outputEvents != null;
			case CakefeedPackage.COMPOSITE_NETWORK__INPUT_DATA:
				return inputData != null;
			case CakefeedPackage.COMPOSITE_NETWORK__OUTPUT_DATA:
				return outputData != null;
		}
		return super.eIsSet(featureID);
	}

} //CompositeNetworkImpl
