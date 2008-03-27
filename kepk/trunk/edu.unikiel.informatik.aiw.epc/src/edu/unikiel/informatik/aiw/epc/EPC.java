/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.epc;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EPC</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.informatik.aiw.epc.EPC#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link edu.unikiel.informatik.aiw.epc.EPC#getObjects <em>Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.informatik.aiw.epc.EpcPackage#getEPC()
 * @model
 * @generated
 */
public interface EPC extends Function {
	/**
	 * Returns the value of the '<em><b>Connectors</b></em>' containment reference list.
	 * The list contents are of type {@link edu.unikiel.informatik.aiw.epc.Relationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connectors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connectors</em>' containment reference list.
	 * @see edu.unikiel.informatik.aiw.epc.EpcPackage#getEPC_Connectors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Relationship> getConnectors();

	/**
	 * Returns the value of the '<em><b>Objects</b></em>' containment reference list.
	 * The list contents are of type {@link edu.unikiel.informatik.aiw.epc.EPCObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objects</em>' containment reference list.
	 * @see edu.unikiel.informatik.aiw.epc.EpcPackage#getEPC_Objects()
	 * @model containment="true"
	 * @generated
	 */
	EList<EPCObject> getObjects();

} // EPC
