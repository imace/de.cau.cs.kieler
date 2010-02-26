/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.Adapter;
import de.cau.cs.kieler.cakefeed.AdapterType;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.FunctionBlockInterface;
import de.cau.cs.kieler.cakefeed.IFInputEvent;
import de.cau.cs.kieler.cakefeed.IFInputVar;
import de.cau.cs.kieler.cakefeed.IFOutputEvent;
import de.cau.cs.kieler.cakefeed.IFOutputVar;
import de.cau.cs.kieler.cakefeed.NamedAndCommented;
import de.cau.cs.kieler.cakefeed.Service;

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
 * An implementation of the model object '<em><b>Adapter Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.AdapterTypeImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.AdapterTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.AdapterTypeImpl#getInputEvents <em>Input Events</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.AdapterTypeImpl#getOutputEvents <em>Output Events</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.AdapterTypeImpl#getInputVars <em>Input Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.AdapterTypeImpl#getOutputVars <em>Output Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.AdapterTypeImpl#getSockets <em>Sockets</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.AdapterTypeImpl#getPlugs <em>Plugs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.AdapterTypeImpl#getService <em>Service</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdapterTypeImpl extends CompilableImpl implements AdapterType {
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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getService() <em>Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected Service service;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdapterTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.ADAPTER_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.ADAPTER_TYPE__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.ADAPTER_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IFInputEvent> getInputEvents() {
		if (inputEvents == null) {
			inputEvents = new EObjectContainmentEList<IFInputEvent>(IFInputEvent.class, this, CakefeedPackage.ADAPTER_TYPE__INPUT_EVENTS);
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
			outputEvents = new EObjectContainmentEList<IFOutputEvent>(IFOutputEvent.class, this, CakefeedPackage.ADAPTER_TYPE__OUTPUT_EVENTS);
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
			inputVars = new EObjectContainmentEList<IFInputVar>(IFInputVar.class, this, CakefeedPackage.ADAPTER_TYPE__INPUT_VARS);
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
			outputVars = new EObjectContainmentEList<IFOutputVar>(IFOutputVar.class, this, CakefeedPackage.ADAPTER_TYPE__OUTPUT_VARS);
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
			sockets = new EObjectContainmentEList<Adapter>(Adapter.class, this, CakefeedPackage.ADAPTER_TYPE__SOCKETS);
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
			plugs = new EObjectContainmentEList<Adapter>(Adapter.class, this, CakefeedPackage.ADAPTER_TYPE__PLUGS);
		}
		return plugs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service getService() {
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetService(Service newService, NotificationChain msgs) {
		Service oldService = service;
		service = newService;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.ADAPTER_TYPE__SERVICE, oldService, newService);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setService(Service newService) {
		if (newService != service) {
			NotificationChain msgs = null;
			if (service != null)
				msgs = ((InternalEObject)service).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.ADAPTER_TYPE__SERVICE, null, msgs);
			if (newService != null)
				msgs = ((InternalEObject)newService).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.ADAPTER_TYPE__SERVICE, null, msgs);
			msgs = basicSetService(newService, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.ADAPTER_TYPE__SERVICE, newService, newService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.ADAPTER_TYPE__INPUT_EVENTS:
				return ((InternalEList<?>)getInputEvents()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.ADAPTER_TYPE__OUTPUT_EVENTS:
				return ((InternalEList<?>)getOutputEvents()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.ADAPTER_TYPE__INPUT_VARS:
				return ((InternalEList<?>)getInputVars()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.ADAPTER_TYPE__OUTPUT_VARS:
				return ((InternalEList<?>)getOutputVars()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.ADAPTER_TYPE__SOCKETS:
				return ((InternalEList<?>)getSockets()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.ADAPTER_TYPE__PLUGS:
				return ((InternalEList<?>)getPlugs()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.ADAPTER_TYPE__SERVICE:
				return basicSetService(null, msgs);
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
			case CakefeedPackage.ADAPTER_TYPE__COMMENT:
				return getComment();
			case CakefeedPackage.ADAPTER_TYPE__NAME:
				return getName();
			case CakefeedPackage.ADAPTER_TYPE__INPUT_EVENTS:
				return getInputEvents();
			case CakefeedPackage.ADAPTER_TYPE__OUTPUT_EVENTS:
				return getOutputEvents();
			case CakefeedPackage.ADAPTER_TYPE__INPUT_VARS:
				return getInputVars();
			case CakefeedPackage.ADAPTER_TYPE__OUTPUT_VARS:
				return getOutputVars();
			case CakefeedPackage.ADAPTER_TYPE__SOCKETS:
				return getSockets();
			case CakefeedPackage.ADAPTER_TYPE__PLUGS:
				return getPlugs();
			case CakefeedPackage.ADAPTER_TYPE__SERVICE:
				return getService();
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
			case CakefeedPackage.ADAPTER_TYPE__COMMENT:
				setComment((String)newValue);
				return;
			case CakefeedPackage.ADAPTER_TYPE__NAME:
				setName((String)newValue);
				return;
			case CakefeedPackage.ADAPTER_TYPE__INPUT_EVENTS:
				getInputEvents().clear();
				getInputEvents().addAll((Collection<? extends IFInputEvent>)newValue);
				return;
			case CakefeedPackage.ADAPTER_TYPE__OUTPUT_EVENTS:
				getOutputEvents().clear();
				getOutputEvents().addAll((Collection<? extends IFOutputEvent>)newValue);
				return;
			case CakefeedPackage.ADAPTER_TYPE__INPUT_VARS:
				getInputVars().clear();
				getInputVars().addAll((Collection<? extends IFInputVar>)newValue);
				return;
			case CakefeedPackage.ADAPTER_TYPE__OUTPUT_VARS:
				getOutputVars().clear();
				getOutputVars().addAll((Collection<? extends IFOutputVar>)newValue);
				return;
			case CakefeedPackage.ADAPTER_TYPE__SOCKETS:
				getSockets().clear();
				getSockets().addAll((Collection<? extends Adapter>)newValue);
				return;
			case CakefeedPackage.ADAPTER_TYPE__PLUGS:
				getPlugs().clear();
				getPlugs().addAll((Collection<? extends Adapter>)newValue);
				return;
			case CakefeedPackage.ADAPTER_TYPE__SERVICE:
				setService((Service)newValue);
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
			case CakefeedPackage.ADAPTER_TYPE__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case CakefeedPackage.ADAPTER_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CakefeedPackage.ADAPTER_TYPE__INPUT_EVENTS:
				getInputEvents().clear();
				return;
			case CakefeedPackage.ADAPTER_TYPE__OUTPUT_EVENTS:
				getOutputEvents().clear();
				return;
			case CakefeedPackage.ADAPTER_TYPE__INPUT_VARS:
				getInputVars().clear();
				return;
			case CakefeedPackage.ADAPTER_TYPE__OUTPUT_VARS:
				getOutputVars().clear();
				return;
			case CakefeedPackage.ADAPTER_TYPE__SOCKETS:
				getSockets().clear();
				return;
			case CakefeedPackage.ADAPTER_TYPE__PLUGS:
				getPlugs().clear();
				return;
			case CakefeedPackage.ADAPTER_TYPE__SERVICE:
				setService((Service)null);
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
			case CakefeedPackage.ADAPTER_TYPE__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case CakefeedPackage.ADAPTER_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CakefeedPackage.ADAPTER_TYPE__INPUT_EVENTS:
				return inputEvents != null && !inputEvents.isEmpty();
			case CakefeedPackage.ADAPTER_TYPE__OUTPUT_EVENTS:
				return outputEvents != null && !outputEvents.isEmpty();
			case CakefeedPackage.ADAPTER_TYPE__INPUT_VARS:
				return inputVars != null && !inputVars.isEmpty();
			case CakefeedPackage.ADAPTER_TYPE__OUTPUT_VARS:
				return outputVars != null && !outputVars.isEmpty();
			case CakefeedPackage.ADAPTER_TYPE__SOCKETS:
				return sockets != null && !sockets.isEmpty();
			case CakefeedPackage.ADAPTER_TYPE__PLUGS:
				return plugs != null && !plugs.isEmpty();
			case CakefeedPackage.ADAPTER_TYPE__SERVICE:
				return service != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NamedAndCommented.class) {
			switch (derivedFeatureID) {
				case CakefeedPackage.ADAPTER_TYPE__COMMENT: return CakefeedPackage.NAMED_AND_COMMENTED__COMMENT;
				case CakefeedPackage.ADAPTER_TYPE__NAME: return CakefeedPackage.NAMED_AND_COMMENTED__NAME;
				default: return -1;
			}
		}
		if (baseClass == FunctionBlockInterface.class) {
			switch (derivedFeatureID) {
				case CakefeedPackage.ADAPTER_TYPE__INPUT_EVENTS: return CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_EVENTS;
				case CakefeedPackage.ADAPTER_TYPE__OUTPUT_EVENTS: return CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_EVENTS;
				case CakefeedPackage.ADAPTER_TYPE__INPUT_VARS: return CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_VARS;
				case CakefeedPackage.ADAPTER_TYPE__OUTPUT_VARS: return CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_VARS;
				case CakefeedPackage.ADAPTER_TYPE__SOCKETS: return CakefeedPackage.FUNCTION_BLOCK_INTERFACE__SOCKETS;
				case CakefeedPackage.ADAPTER_TYPE__PLUGS: return CakefeedPackage.FUNCTION_BLOCK_INTERFACE__PLUGS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NamedAndCommented.class) {
			switch (baseFeatureID) {
				case CakefeedPackage.NAMED_AND_COMMENTED__COMMENT: return CakefeedPackage.ADAPTER_TYPE__COMMENT;
				case CakefeedPackage.NAMED_AND_COMMENTED__NAME: return CakefeedPackage.ADAPTER_TYPE__NAME;
				default: return -1;
			}
		}
		if (baseClass == FunctionBlockInterface.class) {
			switch (baseFeatureID) {
				case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_EVENTS: return CakefeedPackage.ADAPTER_TYPE__INPUT_EVENTS;
				case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_EVENTS: return CakefeedPackage.ADAPTER_TYPE__OUTPUT_EVENTS;
				case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__INPUT_VARS: return CakefeedPackage.ADAPTER_TYPE__INPUT_VARS;
				case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__OUTPUT_VARS: return CakefeedPackage.ADAPTER_TYPE__OUTPUT_VARS;
				case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__SOCKETS: return CakefeedPackage.ADAPTER_TYPE__SOCKETS;
				case CakefeedPackage.FUNCTION_BLOCK_INTERFACE__PLUGS: return CakefeedPackage.ADAPTER_TYPE__PLUGS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //AdapterTypeImpl
