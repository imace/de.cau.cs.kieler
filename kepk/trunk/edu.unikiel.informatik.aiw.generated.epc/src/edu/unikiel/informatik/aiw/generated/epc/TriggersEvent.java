/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.generated.epc;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Triggers Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.informatik.aiw.generated.epc.TriggersEvent#getSource <em>Source</em>}</li>
 *   <li>{@link edu.unikiel.informatik.aiw.generated.epc.TriggersEvent#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage#getTriggersEvent()
 * @model
 * @generated
 */
public interface TriggersEvent extends SuccessorOf {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Function)
	 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage#getTriggersEvent_Source()
	 * @model required="true"
	 * @generated
	 */
	Function getSource();

	/**
	 * Sets the value of the '{@link edu.unikiel.informatik.aiw.generated.epc.TriggersEvent#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Function value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Event)
	 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage#getTriggersEvent_Target()
	 * @model required="true"
	 * @generated
	 */
	Event getTarget();

	/**
	 * Sets the value of the '{@link edu.unikiel.informatik.aiw.generated.epc.TriggersEvent#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Event value);

} // TriggersEvent
