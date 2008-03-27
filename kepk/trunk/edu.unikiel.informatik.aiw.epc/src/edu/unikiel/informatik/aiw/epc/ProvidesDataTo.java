/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.epc;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Provides Data To</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.informatik.aiw.epc.ProvidesDataTo#getSource <em>Source</em>}</li>
 *   <li>{@link edu.unikiel.informatik.aiw.epc.ProvidesDataTo#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.informatik.aiw.epc.EpcPackage#getProvidesDataTo()
 * @model
 * @generated
 */
public interface ProvidesDataTo extends Relationship {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Information)
	 * @see edu.unikiel.informatik.aiw.epc.EpcPackage#getProvidesDataTo_Source()
	 * @model required="true"
	 * @generated
	 */
	Information getSource();

	/**
	 * Sets the value of the '{@link edu.unikiel.informatik.aiw.epc.ProvidesDataTo#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Information value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Function)
	 * @see edu.unikiel.informatik.aiw.epc.EpcPackage#getProvidesDataTo_Target()
	 * @model required="true"
	 * @generated
	 */
	Function getTarget();

	/**
	 * Sets the value of the '{@link edu.unikiel.informatik.aiw.epc.ProvidesDataTo#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Function value);

} // ProvidesDataTo
