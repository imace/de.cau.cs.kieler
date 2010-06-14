/**
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 * 
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 *
 * $Id$
 */
package de.cau.cs.kieler.synccharts01.impl;

import de.cau.cs.kieler.synccharts01.Action;
import de.cau.cs.kieler.synccharts01.Region;
import de.cau.cs.kieler.synccharts01.Renaming;
import de.cau.cs.kieler.synccharts01.Signal;
import de.cau.cs.kieler.synccharts01.State;
import de.cau.cs.kieler.synccharts01.StateType;
import de.cau.cs.kieler.synccharts01.SyncchartsPackage;
import de.cau.cs.kieler.synccharts01.Transition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getSignals <em>Signals</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getRegions <em>Regions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getEntryActions <em>Entry Actions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getInnerActions <em>Inner Actions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getExitActions <em>Exit Actions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getRenamings <em>Renamings</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getSuspensionTrigger <em>Suspension Trigger</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getParentRegion <em>Parent Region</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#isIsInitial <em>Is Initial</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#isIsFinal <em>Is Final</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getBodyText <em>Body Text</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getBodyReference <em>Body Reference</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getBodyContents <em>Body Contents</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.impl.StateImpl#getInterfaceDeclaration <em>Interface Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends EObjectImpl implements State {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final StateType TYPE_EDEFAULT = StateType.NORMAL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected StateType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSignals() <em>Signals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignals()
	 * @generated
	 * @ordered
	 */
	protected EList<Signal> signals;

	/**
	 * The cached value of the '{@link #getRegions() <em>Regions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<Region> regions;

	/**
	 * The cached value of the '{@link #getEntryActions() <em>Entry Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> entryActions;

	/**
	 * The cached value of the '{@link #getInnerActions() <em>Inner Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> innerActions;

	/**
	 * The cached value of the '{@link #getExitActions() <em>Exit Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> exitActions;

	/**
	 * The cached value of the '{@link #getRenamings() <em>Renamings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRenamings()
	 * @generated
	 * @ordered
	 */
	protected EList<Renaming> renamings;

	/**
	 * The cached value of the '{@link #getSuspensionTrigger() <em>Suspension Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionTrigger()
	 * @generated
	 * @ordered
	 */
	protected Action suspensionTrigger;

	/**
	 * The cached value of the '{@link #getOutgoingTransitions() <em>Outgoing Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outgoingTransitions;

	/**
	 * The default value of the '{@link #isIsInitial() <em>Is Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInitial()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INITIAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInitial() <em>Is Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInitial()
	 * @generated
	 * @ordered
	 */
	protected boolean isInitial = IS_INITIAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsFinal() <em>Is Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsFinal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_FINAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsFinal() <em>Is Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsFinal()
	 * @generated
	 * @ordered
	 */
	protected boolean isFinal = IS_FINAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getBodyText() <em>Body Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyText()
	 * @generated
	 * @ordered
	 */
	protected static final String BODY_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBodyText() <em>Body Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyText()
	 * @generated
	 * @ordered
	 */
	protected String bodyText = BODY_TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBodyReference() <em>Body Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyReference()
	 * @generated
	 * @ordered
	 */
	protected EObject bodyReference;

	/**
	 * The cached value of the '{@link #getBodyContents() <em>Body Contents</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyContents()
	 * @generated
	 * @ordered
	 */
	protected EObject bodyContents;

	/**
	 * The default value of the '{@link #getInterfaceDeclaration() <em>Interface Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceDeclaration()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERFACE_DECLARATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInterfaceDeclaration() <em>Interface Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceDeclaration()
	 * @generated
	 * @ordered
	 */
	protected String interfaceDeclaration = INTERFACE_DECLARATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SyncchartsPackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncchartsPackage.STATE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncchartsPackage.STATE__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(StateType newType) {
		StateType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncchartsPackage.STATE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Signal> getSignals() {
		if (signals == null) {
			signals = new EObjectContainmentWithInverseEList<Signal>(Signal.class, this, SyncchartsPackage.STATE__SIGNALS, SyncchartsPackage.SIGNAL__PARENT_STATE);
		}
		return signals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Region> getRegions() {
		if (regions == null) {
			regions = new EObjectContainmentWithInverseEList<Region>(Region.class, this, SyncchartsPackage.STATE__REGIONS, SyncchartsPackage.REGION__PARENT_STATE);
		}
		return regions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getEntryActions() {
		if (entryActions == null) {
			entryActions = new EObjectContainmentWithInverseEList<Action>(Action.class, this, SyncchartsPackage.STATE__ENTRY_ACTIONS, SyncchartsPackage.ACTION__PARENT_STATE_ENTRY_ACTION);
		}
		return entryActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getInnerActions() {
		if (innerActions == null) {
			innerActions = new EObjectContainmentWithInverseEList<Action>(Action.class, this, SyncchartsPackage.STATE__INNER_ACTIONS, SyncchartsPackage.ACTION__PARENT_STATE_INNER_ACTION);
		}
		return innerActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getExitActions() {
		if (exitActions == null) {
			exitActions = new EObjectContainmentWithInverseEList<Action>(Action.class, this, SyncchartsPackage.STATE__EXIT_ACTIONS, SyncchartsPackage.ACTION__PARENT_STATE_EXIT_ACTION);
		}
		return exitActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Renaming> getRenamings() {
		if (renamings == null) {
			renamings = new EObjectContainmentWithInverseEList<Renaming>(Renaming.class, this, SyncchartsPackage.STATE__RENAMINGS, SyncchartsPackage.RENAMING__PARENT_STATE);
		}
		return renamings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getSuspensionTrigger() {
		return suspensionTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuspensionTrigger(Action newSuspensionTrigger, NotificationChain msgs) {
		Action oldSuspensionTrigger = suspensionTrigger;
		suspensionTrigger = newSuspensionTrigger;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyncchartsPackage.STATE__SUSPENSION_TRIGGER, oldSuspensionTrigger, newSuspensionTrigger);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspensionTrigger(Action newSuspensionTrigger) {
		if (newSuspensionTrigger != suspensionTrigger) {
			NotificationChain msgs = null;
			if (suspensionTrigger != null)
				msgs = ((InternalEObject)suspensionTrigger).eInverseRemove(this, SyncchartsPackage.ACTION__PARENT_STATE_SUSPENSION, Action.class, msgs);
			if (newSuspensionTrigger != null)
				msgs = ((InternalEObject)newSuspensionTrigger).eInverseAdd(this, SyncchartsPackage.ACTION__PARENT_STATE_SUSPENSION, Action.class, msgs);
			msgs = basicSetSuspensionTrigger(newSuspensionTrigger, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncchartsPackage.STATE__SUSPENSION_TRIGGER, newSuspensionTrigger, newSuspensionTrigger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOutgoingTransitions() {
		if (outgoingTransitions == null) {
			outgoingTransitions = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this, SyncchartsPackage.STATE__OUTGOING_TRANSITIONS, SyncchartsPackage.TRANSITION__SOURCE_STATE);
		}
		return outgoingTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Region getParentRegion() {
		if (eContainerFeatureID() != SyncchartsPackage.STATE__PARENT_REGION) return null;
		return (Region)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentRegion(Region newParentRegion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentRegion, SyncchartsPackage.STATE__PARENT_REGION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentRegion(Region newParentRegion) {
		if (newParentRegion != eInternalContainer() || (eContainerFeatureID() != SyncchartsPackage.STATE__PARENT_REGION && newParentRegion != null)) {
			if (EcoreUtil.isAncestor(this, newParentRegion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentRegion != null)
				msgs = ((InternalEObject)newParentRegion).eInverseAdd(this, SyncchartsPackage.REGION__INNER_STATES, Region.class, msgs);
			msgs = basicSetParentRegion(newParentRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncchartsPackage.STATE__PARENT_REGION, newParentRegion, newParentRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsInitial() {
		return isInitial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsInitial(boolean newIsInitial) {
		boolean oldIsInitial = isInitial;
		isInitial = newIsInitial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncchartsPackage.STATE__IS_INITIAL, oldIsInitial, isInitial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsFinal() {
		return isFinal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsFinal(boolean newIsFinal) {
		boolean oldIsFinal = isFinal;
		isFinal = newIsFinal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncchartsPackage.STATE__IS_FINAL, oldIsFinal, isFinal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBodyText() {
		return bodyText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyText(String newBodyText) {
		String oldBodyText = bodyText;
		bodyText = newBodyText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncchartsPackage.STATE__BODY_TEXT, oldBodyText, bodyText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getBodyReference() {
		if (bodyReference != null && bodyReference.eIsProxy()) {
			InternalEObject oldBodyReference = (InternalEObject)bodyReference;
			bodyReference = eResolveProxy(oldBodyReference);
			if (bodyReference != oldBodyReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SyncchartsPackage.STATE__BODY_REFERENCE, oldBodyReference, bodyReference));
			}
		}
		return bodyReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetBodyReference() {
		return bodyReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyReference(EObject newBodyReference) {
		EObject oldBodyReference = bodyReference;
		bodyReference = newBodyReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncchartsPackage.STATE__BODY_REFERENCE, oldBodyReference, bodyReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getBodyContents() {
		return bodyContents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyContents(EObject newBodyContents, NotificationChain msgs) {
		EObject oldBodyContents = bodyContents;
		bodyContents = newBodyContents;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyncchartsPackage.STATE__BODY_CONTENTS, oldBodyContents, newBodyContents);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyContents(EObject newBodyContents) {
		if (newBodyContents != bodyContents) {
			NotificationChain msgs = null;
			if (bodyContents != null)
				msgs = ((InternalEObject)bodyContents).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyncchartsPackage.STATE__BODY_CONTENTS, null, msgs);
			if (newBodyContents != null)
				msgs = ((InternalEObject)newBodyContents).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyncchartsPackage.STATE__BODY_CONTENTS, null, msgs);
			msgs = basicSetBodyContents(newBodyContents, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncchartsPackage.STATE__BODY_CONTENTS, newBodyContents, newBodyContents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInterfaceDeclaration() {
		return interfaceDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceDeclaration(String newInterfaceDeclaration) {
		String oldInterfaceDeclaration = interfaceDeclaration;
		interfaceDeclaration = newInterfaceDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncchartsPackage.STATE__INTERFACE_DECLARATION, oldInterfaceDeclaration, interfaceDeclaration));
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
			case SyncchartsPackage.STATE__SIGNALS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSignals()).basicAdd(otherEnd, msgs);
			case SyncchartsPackage.STATE__REGIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRegions()).basicAdd(otherEnd, msgs);
			case SyncchartsPackage.STATE__ENTRY_ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEntryActions()).basicAdd(otherEnd, msgs);
			case SyncchartsPackage.STATE__INNER_ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInnerActions()).basicAdd(otherEnd, msgs);
			case SyncchartsPackage.STATE__EXIT_ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExitActions()).basicAdd(otherEnd, msgs);
			case SyncchartsPackage.STATE__RENAMINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRenamings()).basicAdd(otherEnd, msgs);
			case SyncchartsPackage.STATE__SUSPENSION_TRIGGER:
				if (suspensionTrigger != null)
					msgs = ((InternalEObject)suspensionTrigger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyncchartsPackage.STATE__SUSPENSION_TRIGGER, null, msgs);
				return basicSetSuspensionTrigger((Action)otherEnd, msgs);
			case SyncchartsPackage.STATE__OUTGOING_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingTransitions()).basicAdd(otherEnd, msgs);
			case SyncchartsPackage.STATE__PARENT_REGION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentRegion((Region)otherEnd, msgs);
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
			case SyncchartsPackage.STATE__SIGNALS:
				return ((InternalEList<?>)getSignals()).basicRemove(otherEnd, msgs);
			case SyncchartsPackage.STATE__REGIONS:
				return ((InternalEList<?>)getRegions()).basicRemove(otherEnd, msgs);
			case SyncchartsPackage.STATE__ENTRY_ACTIONS:
				return ((InternalEList<?>)getEntryActions()).basicRemove(otherEnd, msgs);
			case SyncchartsPackage.STATE__INNER_ACTIONS:
				return ((InternalEList<?>)getInnerActions()).basicRemove(otherEnd, msgs);
			case SyncchartsPackage.STATE__EXIT_ACTIONS:
				return ((InternalEList<?>)getExitActions()).basicRemove(otherEnd, msgs);
			case SyncchartsPackage.STATE__RENAMINGS:
				return ((InternalEList<?>)getRenamings()).basicRemove(otherEnd, msgs);
			case SyncchartsPackage.STATE__SUSPENSION_TRIGGER:
				return basicSetSuspensionTrigger(null, msgs);
			case SyncchartsPackage.STATE__OUTGOING_TRANSITIONS:
				return ((InternalEList<?>)getOutgoingTransitions()).basicRemove(otherEnd, msgs);
			case SyncchartsPackage.STATE__PARENT_REGION:
				return basicSetParentRegion(null, msgs);
			case SyncchartsPackage.STATE__BODY_CONTENTS:
				return basicSetBodyContents(null, msgs);
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
			case SyncchartsPackage.STATE__PARENT_REGION:
				return eInternalContainer().eInverseRemove(this, SyncchartsPackage.REGION__INNER_STATES, Region.class, msgs);
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
			case SyncchartsPackage.STATE__ID:
				return getId();
			case SyncchartsPackage.STATE__LABEL:
				return getLabel();
			case SyncchartsPackage.STATE__TYPE:
				return getType();
			case SyncchartsPackage.STATE__SIGNALS:
				return getSignals();
			case SyncchartsPackage.STATE__REGIONS:
				return getRegions();
			case SyncchartsPackage.STATE__ENTRY_ACTIONS:
				return getEntryActions();
			case SyncchartsPackage.STATE__INNER_ACTIONS:
				return getInnerActions();
			case SyncchartsPackage.STATE__EXIT_ACTIONS:
				return getExitActions();
			case SyncchartsPackage.STATE__RENAMINGS:
				return getRenamings();
			case SyncchartsPackage.STATE__SUSPENSION_TRIGGER:
				return getSuspensionTrigger();
			case SyncchartsPackage.STATE__OUTGOING_TRANSITIONS:
				return getOutgoingTransitions();
			case SyncchartsPackage.STATE__PARENT_REGION:
				return getParentRegion();
			case SyncchartsPackage.STATE__IS_INITIAL:
				return isIsInitial();
			case SyncchartsPackage.STATE__IS_FINAL:
				return isIsFinal();
			case SyncchartsPackage.STATE__BODY_TEXT:
				return getBodyText();
			case SyncchartsPackage.STATE__BODY_REFERENCE:
				if (resolve) return getBodyReference();
				return basicGetBodyReference();
			case SyncchartsPackage.STATE__BODY_CONTENTS:
				return getBodyContents();
			case SyncchartsPackage.STATE__INTERFACE_DECLARATION:
				return getInterfaceDeclaration();
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
			case SyncchartsPackage.STATE__ID:
				setId((String)newValue);
				return;
			case SyncchartsPackage.STATE__LABEL:
				setLabel((String)newValue);
				return;
			case SyncchartsPackage.STATE__TYPE:
				setType((StateType)newValue);
				return;
			case SyncchartsPackage.STATE__SIGNALS:
				getSignals().clear();
				getSignals().addAll((Collection<? extends Signal>)newValue);
				return;
			case SyncchartsPackage.STATE__REGIONS:
				getRegions().clear();
				getRegions().addAll((Collection<? extends Region>)newValue);
				return;
			case SyncchartsPackage.STATE__ENTRY_ACTIONS:
				getEntryActions().clear();
				getEntryActions().addAll((Collection<? extends Action>)newValue);
				return;
			case SyncchartsPackage.STATE__INNER_ACTIONS:
				getInnerActions().clear();
				getInnerActions().addAll((Collection<? extends Action>)newValue);
				return;
			case SyncchartsPackage.STATE__EXIT_ACTIONS:
				getExitActions().clear();
				getExitActions().addAll((Collection<? extends Action>)newValue);
				return;
			case SyncchartsPackage.STATE__RENAMINGS:
				getRenamings().clear();
				getRenamings().addAll((Collection<? extends Renaming>)newValue);
				return;
			case SyncchartsPackage.STATE__SUSPENSION_TRIGGER:
				setSuspensionTrigger((Action)newValue);
				return;
			case SyncchartsPackage.STATE__OUTGOING_TRANSITIONS:
				getOutgoingTransitions().clear();
				getOutgoingTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case SyncchartsPackage.STATE__PARENT_REGION:
				setParentRegion((Region)newValue);
				return;
			case SyncchartsPackage.STATE__IS_INITIAL:
				setIsInitial((Boolean)newValue);
				return;
			case SyncchartsPackage.STATE__IS_FINAL:
				setIsFinal((Boolean)newValue);
				return;
			case SyncchartsPackage.STATE__BODY_TEXT:
				setBodyText((String)newValue);
				return;
			case SyncchartsPackage.STATE__BODY_REFERENCE:
				setBodyReference((EObject)newValue);
				return;
			case SyncchartsPackage.STATE__BODY_CONTENTS:
				setBodyContents((EObject)newValue);
				return;
			case SyncchartsPackage.STATE__INTERFACE_DECLARATION:
				setInterfaceDeclaration((String)newValue);
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
			case SyncchartsPackage.STATE__ID:
				setId(ID_EDEFAULT);
				return;
			case SyncchartsPackage.STATE__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case SyncchartsPackage.STATE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SyncchartsPackage.STATE__SIGNALS:
				getSignals().clear();
				return;
			case SyncchartsPackage.STATE__REGIONS:
				getRegions().clear();
				return;
			case SyncchartsPackage.STATE__ENTRY_ACTIONS:
				getEntryActions().clear();
				return;
			case SyncchartsPackage.STATE__INNER_ACTIONS:
				getInnerActions().clear();
				return;
			case SyncchartsPackage.STATE__EXIT_ACTIONS:
				getExitActions().clear();
				return;
			case SyncchartsPackage.STATE__RENAMINGS:
				getRenamings().clear();
				return;
			case SyncchartsPackage.STATE__SUSPENSION_TRIGGER:
				setSuspensionTrigger((Action)null);
				return;
			case SyncchartsPackage.STATE__OUTGOING_TRANSITIONS:
				getOutgoingTransitions().clear();
				return;
			case SyncchartsPackage.STATE__PARENT_REGION:
				setParentRegion((Region)null);
				return;
			case SyncchartsPackage.STATE__IS_INITIAL:
				setIsInitial(IS_INITIAL_EDEFAULT);
				return;
			case SyncchartsPackage.STATE__IS_FINAL:
				setIsFinal(IS_FINAL_EDEFAULT);
				return;
			case SyncchartsPackage.STATE__BODY_TEXT:
				setBodyText(BODY_TEXT_EDEFAULT);
				return;
			case SyncchartsPackage.STATE__BODY_REFERENCE:
				setBodyReference((EObject)null);
				return;
			case SyncchartsPackage.STATE__BODY_CONTENTS:
				setBodyContents((EObject)null);
				return;
			case SyncchartsPackage.STATE__INTERFACE_DECLARATION:
				setInterfaceDeclaration(INTERFACE_DECLARATION_EDEFAULT);
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
			case SyncchartsPackage.STATE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SyncchartsPackage.STATE__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case SyncchartsPackage.STATE__TYPE:
				return type != TYPE_EDEFAULT;
			case SyncchartsPackage.STATE__SIGNALS:
				return signals != null && !signals.isEmpty();
			case SyncchartsPackage.STATE__REGIONS:
				return regions != null && !regions.isEmpty();
			case SyncchartsPackage.STATE__ENTRY_ACTIONS:
				return entryActions != null && !entryActions.isEmpty();
			case SyncchartsPackage.STATE__INNER_ACTIONS:
				return innerActions != null && !innerActions.isEmpty();
			case SyncchartsPackage.STATE__EXIT_ACTIONS:
				return exitActions != null && !exitActions.isEmpty();
			case SyncchartsPackage.STATE__RENAMINGS:
				return renamings != null && !renamings.isEmpty();
			case SyncchartsPackage.STATE__SUSPENSION_TRIGGER:
				return suspensionTrigger != null;
			case SyncchartsPackage.STATE__OUTGOING_TRANSITIONS:
				return outgoingTransitions != null && !outgoingTransitions.isEmpty();
			case SyncchartsPackage.STATE__PARENT_REGION:
				return getParentRegion() != null;
			case SyncchartsPackage.STATE__IS_INITIAL:
				return isInitial != IS_INITIAL_EDEFAULT;
			case SyncchartsPackage.STATE__IS_FINAL:
				return isFinal != IS_FINAL_EDEFAULT;
			case SyncchartsPackage.STATE__BODY_TEXT:
				return BODY_TEXT_EDEFAULT == null ? bodyText != null : !BODY_TEXT_EDEFAULT.equals(bodyText);
			case SyncchartsPackage.STATE__BODY_REFERENCE:
				return bodyReference != null;
			case SyncchartsPackage.STATE__BODY_CONTENTS:
				return bodyContents != null;
			case SyncchartsPackage.STATE__INTERFACE_DECLARATION:
				return INTERFACE_DECLARATION_EDEFAULT == null ? interfaceDeclaration != null : !INTERFACE_DECLARATION_EDEFAULT.equals(interfaceDeclaration);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", label: ");
		result.append(label);
		result.append(", type: ");
		result.append(type);
		result.append(", isInitial: ");
		result.append(isInitial);
		result.append(", isFinal: ");
		result.append(isFinal);
		result.append(", bodyText: ");
		result.append(bodyText);
		result.append(", interfaceDeclaration: ");
		result.append(interfaceDeclaration);
		result.append(')');
		return result.toString();
	}

} //StateImpl
