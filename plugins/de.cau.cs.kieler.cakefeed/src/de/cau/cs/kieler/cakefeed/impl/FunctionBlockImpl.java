/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.FBInputEvent;
import de.cau.cs.kieler.cakefeed.FBInputVar;
import de.cau.cs.kieler.cakefeed.FBOutputEvent;
import de.cau.cs.kieler.cakefeed.FBOutputVar;
import de.cau.cs.kieler.cakefeed.FunctionBlock;
import de.cau.cs.kieler.cakefeed.FunctionBlockType;
import de.cau.cs.kieler.cakefeed.Parameter;

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
 * An implementation of the model object '<em><b>Function Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockImpl#getInputEvents <em>Input Events</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockImpl#getOutputEvents <em>Output Events</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockImpl#getInputVars <em>Input Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockImpl#getOutputVars <em>Output Vars</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionBlockImpl extends NamedAndCommentedImpl implements FunctionBlock {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected FunctionBlockType type;

	/**
	 * The cached value of the '{@link #getInputEvents() <em>Input Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<FBInputEvent> inputEvents;

	/**
	 * The cached value of the '{@link #getOutputEvents() <em>Output Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<FBOutputEvent> outputEvents;

	/**
	 * The cached value of the '{@link #getInputVars() <em>Input Vars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputVars()
	 * @generated
	 * @ordered
	 */
	protected EList<FBInputVar> inputVars;

	/**
	 * The cached value of the '{@link #getOutputVars() <em>Output Vars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputVars()
	 * @generated
	 * @ordered
	 */
	protected EList<FBOutputVar> outputVars;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.FUNCTION_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, CakefeedPackage.FUNCTION_BLOCK__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionBlockType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (FunctionBlockType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.FUNCTION_BLOCK__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionBlockType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(FunctionBlockType newType) {
		FunctionBlockType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.FUNCTION_BLOCK__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FBInputEvent> getInputEvents() {
		if (inputEvents == null) {
			inputEvents = new EObjectContainmentEList<FBInputEvent>(FBInputEvent.class, this, CakefeedPackage.FUNCTION_BLOCK__INPUT_EVENTS);
		}
		return inputEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FBOutputEvent> getOutputEvents() {
		if (outputEvents == null) {
			outputEvents = new EObjectContainmentEList<FBOutputEvent>(FBOutputEvent.class, this, CakefeedPackage.FUNCTION_BLOCK__OUTPUT_EVENTS);
		}
		return outputEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FBInputVar> getInputVars() {
		if (inputVars == null) {
			inputVars = new EObjectContainmentEList<FBInputVar>(FBInputVar.class, this, CakefeedPackage.FUNCTION_BLOCK__INPUT_VARS);
		}
		return inputVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FBOutputVar> getOutputVars() {
		if (outputVars == null) {
			outputVars = new EObjectContainmentEList<FBOutputVar>(FBOutputVar.class, this, CakefeedPackage.FUNCTION_BLOCK__OUTPUT_VARS);
		}
		return outputVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.FUNCTION_BLOCK__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_EVENTS:
				return ((InternalEList<?>)getInputEvents()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_EVENTS:
				return ((InternalEList<?>)getOutputEvents()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_VARS:
				return ((InternalEList<?>)getInputVars()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_VARS:
				return ((InternalEList<?>)getOutputVars()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.FUNCTION_BLOCK__PARAMETERS:
				return getParameters();
			case CakefeedPackage.FUNCTION_BLOCK__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_EVENTS:
				return getInputEvents();
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_EVENTS:
				return getOutputEvents();
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_VARS:
				return getInputVars();
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_VARS:
				return getOutputVars();
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
			case CakefeedPackage.FUNCTION_BLOCK__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK__TYPE:
				setType((FunctionBlockType)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_EVENTS:
				getInputEvents().clear();
				getInputEvents().addAll((Collection<? extends FBInputEvent>)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_EVENTS:
				getOutputEvents().clear();
				getOutputEvents().addAll((Collection<? extends FBOutputEvent>)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_VARS:
				getInputVars().clear();
				getInputVars().addAll((Collection<? extends FBInputVar>)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_VARS:
				getOutputVars().clear();
				getOutputVars().addAll((Collection<? extends FBOutputVar>)newValue);
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
			case CakefeedPackage.FUNCTION_BLOCK__PARAMETERS:
				getParameters().clear();
				return;
			case CakefeedPackage.FUNCTION_BLOCK__TYPE:
				setType((FunctionBlockType)null);
				return;
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_EVENTS:
				getInputEvents().clear();
				return;
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_EVENTS:
				getOutputEvents().clear();
				return;
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_VARS:
				getInputVars().clear();
				return;
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_VARS:
				getOutputVars().clear();
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
			case CakefeedPackage.FUNCTION_BLOCK__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case CakefeedPackage.FUNCTION_BLOCK__TYPE:
				return type != null;
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_EVENTS:
				return inputEvents != null && !inputEvents.isEmpty();
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_EVENTS:
				return outputEvents != null && !outputEvents.isEmpty();
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_VARS:
				return inputVars != null && !inputVars.isEmpty();
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_VARS:
				return outputVars != null && !outputVars.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FunctionBlockImpl
