/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.generated.epc;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator To Event Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.informatik.aiw.generated.epc.OperatorToEventConnection#getEvent <em>Event</em>}</li>
 *   <li>{@link edu.unikiel.informatik.aiw.generated.epc.OperatorToEventConnection#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage#getOperatorToEventConnection()
 * @model
 * @generated
 */
public interface OperatorToEventConnection extends SuccessorOf {
	/**
	 * Returns the value of the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' reference.
	 * @see #setEvent(Event)
	 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage#getOperatorToEventConnection_Event()
	 * @model
	 * @generated
	 */
	Event getEvent();

	/**
	 * Sets the value of the '{@link edu.unikiel.informatik.aiw.generated.epc.OperatorToEventConnection#getEvent <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(Event value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' reference.
	 * @see #setOperator(LogicalOperator)
	 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage#getOperatorToEventConnection_Operator()
	 * @model
	 * @generated
	 */
	LogicalOperator getOperator();

	/**
	 * Sets the value of the '{@link edu.unikiel.informatik.aiw.generated.epc.OperatorToEventConnection#getOperator <em>Operator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' reference.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(LogicalOperator value);

} // OperatorToEventConnection
