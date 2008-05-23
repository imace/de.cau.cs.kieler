/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.generated.epc;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GCT Lconnector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.informatik.aiw.generated.epc.GCTLconnector#getSource <em>Source</em>}</li>
 *   <li>{@link edu.unikiel.informatik.aiw.generated.epc.GCTLconnector#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage#getGCTLconnector()
 * @model
 * @generated
 */
public interface GCTLconnector extends Relationship {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage#getGCTLconnector_Source()
	 * @model
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link edu.unikiel.informatik.aiw.generated.epc.GCTLconnector#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage#getGCTLconnector_Target()
	 * @model
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link edu.unikiel.informatik.aiw.generated.epc.GCTLconnector#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

} // GCTLconnector
