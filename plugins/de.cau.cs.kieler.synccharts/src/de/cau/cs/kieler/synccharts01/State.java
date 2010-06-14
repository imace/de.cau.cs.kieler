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
package de.cau.cs.kieler.synccharts01;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This is a State GenModel Doc comment.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getId <em>Id</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getLabel <em>Label</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getType <em>Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getSignals <em>Signals</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getRegions <em>Regions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getEntryActions <em>Entry Actions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getInnerActions <em>Inner Actions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getExitActions <em>Exit Actions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getRenamings <em>Renamings</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getSuspensionTrigger <em>Suspension Trigger</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getParentRegion <em>Parent Region</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#isIsInitial <em>Is Initial</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#isIsFinal <em>Is Final</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getBodyText <em>Body Text</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getBodyReference <em>Body Reference</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getBodyContents <em>Body Contents</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts01.State#getInterfaceDeclaration <em>Interface Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts01.State#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts01.State#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.cau.cs.kieler.synccharts01.StateType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.cau.cs.kieler.synccharts01.StateType
	 * @see #setType(StateType)
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_Type()
	 * @model required="true"
	 * @generated
	 */
	StateType getType();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts01.State#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.cau.cs.kieler.synccharts01.StateType
	 * @see #getType()
	 * @generated
	 */
	void setType(StateType value);

	/**
	 * Returns the value of the '<em><b>Signals</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.synccharts01.Signal}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.synccharts01.Signal#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signals</em>' containment reference list.
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_Signals()
	 * @see de.cau.cs.kieler.synccharts01.Signal#getParentState
	 * @model opposite="parentState" containment="true"
	 * @generated
	 */
	EList<Signal> getSignals();

	/**
	 * Returns the value of the '<em><b>Regions</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.synccharts01.Region}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.synccharts01.Region#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regions</em>' containment reference list.
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_Regions()
	 * @see de.cau.cs.kieler.synccharts01.Region#getParentState
	 * @model opposite="parentState" containment="true"
	 * @generated
	 */
	EList<Region> getRegions();

	/**
	 * Returns the value of the '<em><b>Entry Actions</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.synccharts01.Action}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.synccharts01.Action#getParentStateEntryAction <em>Parent State Entry Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Actions</em>' containment reference list.
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_EntryActions()
	 * @see de.cau.cs.kieler.synccharts01.Action#getParentStateEntryAction
	 * @model opposite="parentStateEntryAction" containment="true"
	 * @generated
	 */
	EList<Action> getEntryActions();

	/**
	 * Returns the value of the '<em><b>Inner Actions</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.synccharts01.Action}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.synccharts01.Action#getParentStateInnerAction <em>Parent State Inner Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Actions</em>' containment reference list.
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_InnerActions()
	 * @see de.cau.cs.kieler.synccharts01.Action#getParentStateInnerAction
	 * @model opposite="parentStateInnerAction" containment="true"
	 * @generated
	 */
	EList<Action> getInnerActions();

	/**
	 * Returns the value of the '<em><b>Exit Actions</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.synccharts01.Action}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.synccharts01.Action#getParentStateExitAction <em>Parent State Exit Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit Actions</em>' containment reference list.
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_ExitActions()
	 * @see de.cau.cs.kieler.synccharts01.Action#getParentStateExitAction
	 * @model opposite="parentStateExitAction" containment="true"
	 * @generated
	 */
	EList<Action> getExitActions();

	/**
	 * Returns the value of the '<em><b>Renamings</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.synccharts01.Renaming}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.synccharts01.Renaming#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Renamings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Renamings</em>' containment reference list.
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_Renamings()
	 * @see de.cau.cs.kieler.synccharts01.Renaming#getParentState
	 * @model opposite="parentState" containment="true"
	 * @generated
	 */
	EList<Renaming> getRenamings();

	/**
	 * Returns the value of the '<em><b>Suspension Trigger</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.synccharts01.Action#getParentStateSuspension <em>Parent State Suspension</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspension Trigger</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspension Trigger</em>' containment reference.
	 * @see #setSuspensionTrigger(Action)
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_SuspensionTrigger()
	 * @see de.cau.cs.kieler.synccharts01.Action#getParentStateSuspension
	 * @model opposite="parentStateSuspension" containment="true"
	 * @generated
	 */
	Action getSuspensionTrigger();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts01.State#getSuspensionTrigger <em>Suspension Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspension Trigger</em>' containment reference.
	 * @see #getSuspensionTrigger()
	 * @generated
	 */
	void setSuspensionTrigger(Action value);

	/**
	 * Returns the value of the '<em><b>Outgoing Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.synccharts01.Transition}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.synccharts01.Transition#getSourceState <em>Source State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Transitions</em>' containment reference list.
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_OutgoingTransitions()
	 * @see de.cau.cs.kieler.synccharts01.Transition#getSourceState
	 * @model opposite="sourceState" containment="true"
	 * @generated
	 */
	EList<Transition> getOutgoingTransitions();

	/**
	 * Returns the value of the '<em><b>Parent Region</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.synccharts01.Region#getInnerStates <em>Inner States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Region</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Region</em>' container reference.
	 * @see #setParentRegion(Region)
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_ParentRegion()
	 * @see de.cau.cs.kieler.synccharts01.Region#getInnerStates
	 * @model opposite="innerStates" required="true" transient="false"
	 * @generated
	 */
	Region getParentRegion();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts01.State#getParentRegion <em>Parent Region</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Region</em>' container reference.
	 * @see #getParentRegion()
	 * @generated
	 */
	void setParentRegion(Region value);

	/**
	 * Returns the value of the '<em><b>Is Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Initial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Initial</em>' attribute.
	 * @see #setIsInitial(boolean)
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_IsInitial()
	 * @model
	 * @generated
	 */
	boolean isIsInitial();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts01.State#isIsInitial <em>Is Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Initial</em>' attribute.
	 * @see #isIsInitial()
	 * @generated
	 */
	void setIsInitial(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Final</em>' attribute.
	 * @see #setIsFinal(boolean)
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_IsFinal()
	 * @model
	 * @generated
	 */
	boolean isIsFinal();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts01.State#isIsFinal <em>Is Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Final</em>' attribute.
	 * @see #isIsFinal()
	 * @generated
	 */
	void setIsFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Body Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Text</em>' attribute.
	 * @see #setBodyText(String)
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_BodyText()
	 * @model
	 * @generated
	 */
	String getBodyText();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts01.State#getBodyText <em>Body Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Text</em>' attribute.
	 * @see #getBodyText()
	 * @generated
	 */
	void setBodyText(String value);

	/**
	 * Returns the value of the '<em><b>Body Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Reference</em>' reference.
	 * @see #setBodyReference(EObject)
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_BodyReference()
	 * @model
	 * @generated
	 */
	EObject getBodyReference();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts01.State#getBodyReference <em>Body Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Reference</em>' reference.
	 * @see #getBodyReference()
	 * @generated
	 */
	void setBodyReference(EObject value);

	/**
	 * Returns the value of the '<em><b>Body Contents</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Contents</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Contents</em>' containment reference.
	 * @see #setBodyContents(EObject)
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_BodyContents()
	 * @model containment="true"
	 * @generated
	 */
	EObject getBodyContents();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts01.State#getBodyContents <em>Body Contents</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Contents</em>' containment reference.
	 * @see #getBodyContents()
	 * @generated
	 */
	void setBodyContents(EObject value);

	/**
	 * Returns the value of the '<em><b>Interface Declaration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Declaration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface Declaration</em>' attribute.
	 * @see #setInterfaceDeclaration(String)
	 * @see de.cau.cs.kieler.synccharts01.SyncchartsPackage#getState_InterfaceDeclaration()
	 * @model
	 * @generated
	 */
	String getInterfaceDeclaration();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts01.State#getInterfaceDeclaration <em>Interface Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Declaration</em>' attribute.
	 * @see #getInterfaceDeclaration()
	 * @generated
	 */
	void setInterfaceDeclaration(String value);

} // State
