/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.Adapter;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.FunctionBlockInterface;
import de.cau.cs.kieler.cakefeed.IFInputEvent;
import de.cau.cs.kieler.cakefeed.IFInputVar;
import de.cau.cs.kieler.cakefeed.IFOutputEvent;
import de.cau.cs.kieler.cakefeed.IFOutputVar;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Block Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockInterfaceImpl#getInputEvents <em>Input Events</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockInterfaceImpl#getOutputEvents <em>Output Events</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockInterfaceImpl#getInputVars <em>Input Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockInterfaceImpl#getOutputVars <em>Output Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockInterfaceImpl#getSockets <em>Sockets</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.FunctionBlockInterfaceImpl#getPlugs <em>Plugs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionBlockInterfaceImpl extends EObjectImpl implements FunctionBlockInterface {
	/**
	 * The cached value of the '{@link #getInputEvents() <em>Input Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<IFInputEvent> inputEvents;

	/**
	 * The cached value of the '{@link #getOutputEvents() <em>Output Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<IFOutputEvent> outputEvents;

	/**
	 * The cached value of the '{@link #getInputVars() <em>Input Vars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputVars()
	 * @generated
	 * @ordered
	 */
	protected EList<IFInputVar> inputVars;

	/**
	 * The cached value of the '{@link #getOutputVars() <em>Output Vars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputVars()
	 * @generated
	 * @ordered
	 */
	protected EList<IFOutputVar> outputVars;

	/**
	 * The cached value of the '{@link #getSockets() <em>Sockets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSockets()
	 * @generated
	 * @ordered
	 */
	protected EList<Adapter> sockets;

	/**
	 * The cached value of the '{@link #getPlugs() <em>Plugs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlugs()
	 * @generated
	 * @ordered
	 */
	protected EList<Adapter> plugs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionBlockInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.FUNCTION_BLOCK_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IFInputEvent> getInputEvents() {
		if (inputEvents == null) {
			inputEvents = new EObjectContainmentEList<IFInputEvent>(IFInputEvent.class, this, CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_EVENTS);
		}
		return inputEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IFOutputEvent> getOutputEvents() {
		if (outputEvents == null) {
			outputEvents = new EObjectContainmentEList<IFOutputEvent>(IFOutputEvent.class, this, CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_EVENTS);
		}
		return outputEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IFInputVar> getInputVars() {
		if (inputVars == null) {
			inputVars = new EObjectContainmentEList<IFInputVar>(IFInputVar.class, this, CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_VARS);
		}
		return inputVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IFOutputVar> getOutputVars() {
		if (outputVars == null) {
			outputVars = new EObjectContainmentEList<IFOutputVar>(IFOutputVar.class, this, CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_VARS);
		}
		return outputVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Adapter> getSockets() {
		if (sockets == null) {
			sockets = new EObjectContainmentEList<Adapter>(Adapter.class, this, CakefeedPackage.FUNCTION_BLOCK_INTERFACE__SOCKETS);
		}
		return sockets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Adapter> getPlugs() {
		if (plugs == null) {
			plugs = new EObjectContainmentEList<Adapter>(Adapter.class, this, CakefeedPackage.FUNCTION_BLOCK_INTERFACE__PLUGS);
		}
		return plugs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_EVENTS:
				return ((InternalEList<?>)getInputEvents()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_EVENTS:
				return ((InternalEList<?>)getOutputEvents()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_VARS:
				return ((InternalEList<?>)getInputVars()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_VARS:
				return ((InternalEList<?>)getOutputVars()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__SOCKETS:
				return ((InternalEList<?>)getSockets()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__PLUGS:
				return ((InternalEList<?>)getPlugs()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_EVENTS:
				return getInputEvents();
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_EVENTS:
				return getOutputEvents();
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_VARS:
				return getInputVars();
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_VARS:
				return getOutputVars();
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__SOCKETS:
				return getSockets();
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__PLUGS:
				return getPlugs();
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
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_EVENTS:
				getInputEvents().clear();
				getInputEvents().addAll((Collection<? extends IFInputEvent>)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_EVENTS:
				getOutputEvents().clear();
				getOutputEvents().addAll((Collection<? extends IFOutputEvent>)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_VARS:
				getInputVars().clear();
				getInputVars().addAll((Collection<? extends IFInputVar>)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_VARS:
				getOutputVars().clear();
				getOutputVars().addAll((Collection<? extends IFOutputVar>)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__SOCKETS:
				getSockets().clear();
				getSockets().addAll((Collection<? extends Adapter>)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__PLUGS:
				getPlugs().clear();
				getPlugs().addAll((Collection<? extends Adapter>)newValue);
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
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_EVENTS:
				getInputEvents().clear();
				return;
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_EVENTS:
				getOutputEvents().clear();
				return;
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_VARS:
				getInputVars().clear();
				return;
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_VARS:
				getOutputVars().clear();
				return;
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__SOCKETS:
				getSockets().clear();
				return;
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__PLUGS:
				getPlugs().clear();
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
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_EVENTS:
				return inputEvents != null && !inputEvents.isEmpty();
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_EVENTS:
				return outputEvents != null && !outputEvents.isEmpty();
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_VARS:
				return inputVars != null && !inputVars.isEmpty();
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_VARS:
				return outputVars != null && !outputVars.isEmpty();
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__SOCKETS:
				return sockets != null && !sockets.isEmpty();
			case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__PLUGS:
				return plugs != null && !plugs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FunctionBlockInterfaceImpl
