/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.synccharts;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.synccharts.Scope#getId <em>Id</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.Scope#getLabel <em>Label</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.Scope#getSignals <em>Signals</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.Scope#getVariables <em>Variables</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.Scope#getSuspensionTrigger <em>Suspension Trigger</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.Scope#getExitActions <em>Exit Actions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.Scope#getInnerActions <em>Inner Actions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.Scope#getEntryActions <em>Entry Actions</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.Scope#getBodyReference <em>Body Reference</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.Scope#getBodyContents <em>Body Contents</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.Scope#getBodyText <em>Body Text</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.Scope#getRenamings <em>Renamings</em>}</li>
 *   <li>{@link de.cau.cs.kieler.synccharts.Scope#getInterfaceDeclaration <em>Interface Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getScope()
 * @model abstract="true"
 * @generated
 */
public interface Scope extends EObject {
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
	 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getScope_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts.Scope#getId <em>Id</em>}' attribute.
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
	 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getScope_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts.Scope#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Signals</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.synccharts.Signal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signals</em>' containment reference list.
	 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getScope_Signals()
	 * @model containment="true"
	 * @generated
	 */
	EList<Signal> getSignals();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.synccharts.Variable}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.synccharts.Variable#getParentScope <em>Parent Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getScope_Variables()
	 * @see de.cau.cs.kieler.synccharts.Variable#getParentScope
	 * @model opposite="parentScope" containment="true"
	 * @generated
	 */
	EList<Variable> getVariables();

	/**
	 * Returns the value of the '<em><b>Suspension Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspension Trigger</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspension Trigger</em>' containment reference.
	 * @see #setSuspensionTrigger(Action)
	 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getScope_SuspensionTrigger()
	 * @model containment="true"
	 * @generated
	 */
	Action getSuspensionTrigger();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts.Scope#getSuspensionTrigger <em>Suspension Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspension Trigger</em>' containment reference.
	 * @see #getSuspensionTrigger()
	 * @generated
	 */
	void setSuspensionTrigger(Action value);

	/**
	 * Returns the value of the '<em><b>Exit Actions</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.synccharts.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit Actions</em>' containment reference list.
	 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getScope_ExitActions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getExitActions();

	/**
	 * Returns the value of the '<em><b>Inner Actions</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.synccharts.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Actions</em>' containment reference list.
	 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getScope_InnerActions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getInnerActions();

	/**
	 * Returns the value of the '<em><b>Entry Actions</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.synccharts.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Actions</em>' containment reference list.
	 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getScope_EntryActions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getEntryActions();

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
	 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getScope_BodyReference()
	 * @model
	 * @generated
	 */
	EObject getBodyReference();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts.Scope#getBodyReference <em>Body Reference</em>}' reference.
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
	 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getScope_BodyContents()
	 * @model containment="true"
	 * @generated
	 */
	EObject getBodyContents();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts.Scope#getBodyContents <em>Body Contents</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Contents</em>' containment reference.
	 * @see #getBodyContents()
	 * @generated
	 */
	void setBodyContents(EObject value);

	/**
	 * Returns the value of the '<em><b>Body Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Text</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Text</em>' containment reference.
	 * @see #setBodyText(TextualCode)
	 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getScope_BodyText()
	 * @model containment="true"
	 * @generated
	 */
	TextualCode getBodyText();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts.Scope#getBodyText <em>Body Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Text</em>' containment reference.
	 * @see #getBodyText()
	 * @generated
	 */
	void setBodyText(TextualCode value);

	/**
	 * Returns the value of the '<em><b>Interface Declaration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Declaration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface Declaration</em>' attribute.
	 * @see #setInterfaceDeclaration(String)
	 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getScope_InterfaceDeclaration()
	 * @model dataType="de.cau.cs.kieler.synccharts.Parsable"
	 * @generated
	 */
	String getInterfaceDeclaration();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.synccharts.Scope#getInterfaceDeclaration <em>Interface Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Declaration</em>' attribute.
	 * @see #getInterfaceDeclaration()
	 * @generated
	 */
	void setInterfaceDeclaration(String value);

	/**
	 * Returns the value of the '<em><b>Renamings</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.synccharts.Substitution}.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.synccharts.Substitution#getParentScope <em>Parent Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Renamings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Renamings</em>' containment reference list.
	 * @see de.cau.cs.kieler.synccharts.SyncchartsPackage#getScope_Renamings()
	 * @see de.cau.cs.kieler.synccharts.Substitution#getParentScope
	 * @model opposite="parentScope" containment="true"
	 * @generated
	 */
	EList<Substitution> getRenamings();

} // Scope
