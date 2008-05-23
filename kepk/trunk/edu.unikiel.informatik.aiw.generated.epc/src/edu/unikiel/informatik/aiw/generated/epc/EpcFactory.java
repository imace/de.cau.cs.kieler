/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.generated.epc;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage
 * @generated
 */
public interface EpcFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EpcFactory eINSTANCE = edu.unikiel.informatik.aiw.generated.epc.impl.EpcFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EPC</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EPC</em>'.
	 * @generated
	 */
	EPC createEPC();

	/**
	 * Returns a new object of class '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event</em>'.
	 * @generated
	 */
	Event createEvent();

	/**
	 * Returns a new object of class '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function</em>'.
	 * @generated
	 */
	Function createFunction();

	/**
	 * Returns a new object of class '<em>Triggers Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Triggers Event</em>'.
	 * @generated
	 */
	TriggersEvent createTriggersEvent();

	/**
	 * Returns a new object of class '<em>XOR</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XOR</em>'.
	 * @generated
	 */
	XOR createXOR();

	/**
	 * Returns a new object of class '<em>OR</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OR</em>'.
	 * @generated
	 */
	OR createOR();

	/**
	 * Returns a new object of class '<em>AND</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AND</em>'.
	 * @generated
	 */
	AND createAND();

	/**
	 * Returns a new object of class '<em>Information</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Information</em>'.
	 * @generated
	 */
	Information createInformation();

	/**
	 * Returns a new object of class '<em>Activates Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activates Function</em>'.
	 * @generated
	 */
	ActivatesFunction createActivatesFunction();

	/**
	 * Returns a new object of class '<em>Provides Data To</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Provides Data To</em>'.
	 * @generated
	 */
	ProvidesDataTo createProvidesDataTo();

	/**
	 * Returns a new object of class '<em>Writes Data To</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Writes Data To</em>'.
	 * @generated
	 */
	WritesDataTo createWritesDataTo();

	/**
	 * Returns a new object of class '<em>Function To Operator Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function To Operator Connection</em>'.
	 * @generated
	 */
	FunctionToOperatorConnection createFunctionToOperatorConnection();

	/**
	 * Returns a new object of class '<em>Event To Operator Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event To Operator Connection</em>'.
	 * @generated
	 */
	EventToOperatorConnection createEventToOperatorConnection();

	/**
	 * Returns a new object of class '<em>Operator To Function Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operator To Function Connection</em>'.
	 * @generated
	 */
	OperatorToFunctionConnection createOperatorToFunctionConnection();

	/**
	 * Returns a new object of class '<em>Operator To Event Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operator To Event Connection</em>'.
	 * @generated
	 */
	OperatorToEventConnection createOperatorToEventConnection();

	/**
	 * Returns a new object of class '<em>GCT Lconnector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>GCT Lconnector</em>'.
	 * @generated
	 */
	GCTLconnector createGCTLconnector();

	/**
	 * Returns a new object of class '<em>Implication</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implication</em>'.
	 * @generated
	 */
	Implication createImplication();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EpcPackage getEpcPackage();

} //EpcFactory
