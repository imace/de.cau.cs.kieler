/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cakefeed.CakefeedPackage
 * @generated
 */
public interface CakefeedFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CakefeedFactory eINSTANCE = cakefeed.impl.CakefeedFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application</em>'.
	 * @generated
	 */
	Application createApplication();

	/**
	 * Returns a new object of class '<em>Basic Function Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Function Block</em>'.
	 * @generated
	 */
	BasicFunctionBlock createBasicFunctionBlock();

	/**
	 * Returns a new object of class '<em>Composite Function Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Function Block</em>'.
	 * @generated
	 */
	CompositeFunctionBlock createCompositeFunctionBlock();

	/**
	 * Returns a new object of class '<em>Service Interface Function Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Interface Function Block</em>'.
	 * @generated
	 */
	ServiceInterfaceFunctionBlock createServiceInterfaceFunctionBlock();

	/**
	 * Returns a new object of class '<em>Basic Function Block Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Function Block Instance</em>'.
	 * @generated
	 */
	BasicFunctionBlockInstance createBasicFunctionBlockInstance();

	/**
	 * Returns a new object of class '<em>Composite Function Block Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Function Block Instance</em>'.
	 * @generated
	 */
	CompositeFunctionBlockInstance createCompositeFunctionBlockInstance();

	/**
	 * Returns a new object of class '<em>Service Interface Function Block Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Interface Function Block Instance</em>'.
	 * @generated
	 */
	ServiceInterfaceFunctionBlockInstance createServiceInterfaceFunctionBlockInstance();

	/**
	 * Returns a new object of class '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection</em>'.
	 * @generated
	 */
	Connection createConnection();

	/**
	 * Returns a new object of class '<em>Event Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Connection</em>'.
	 * @generated
	 */
	EventConnection createEventConnection();

	/**
	 * Returns a new object of class '<em>Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Connection</em>'.
	 * @generated
	 */
	DataConnection createDataConnection();

	/**
	 * Returns a new object of class '<em>Input Event Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Event Port</em>'.
	 * @generated
	 */
	InputEventPort createInputEventPort();

	/**
	 * Returns a new object of class '<em>Output Event Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Event Port</em>'.
	 * @generated
	 */
	OutputEventPort createOutputEventPort();

	/**
	 * Returns a new object of class '<em>Input Data Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Data Port</em>'.
	 * @generated
	 */
	InputDataPort createInputDataPort();

	/**
	 * Returns a new object of class '<em>Output Data Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Data Port</em>'.
	 * @generated
	 */
	OutputDataPort createOutputDataPort();

	/**
	 * Returns a new object of class '<em>Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Algorithm</em>'.
	 * @generated
	 */
	Algorithm createAlgorithm();

	/**
	 * Returns a new object of class '<em>Composite Network</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Network</em>'.
	 * @generated
	 */
	CompositeNetwork createCompositeNetwork();

	/**
	 * Returns a new object of class '<em>Service Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Sequence</em>'.
	 * @generated
	 */
	ServiceSequence createServiceSequence();

	/**
	 * Returns a new object of class '<em>Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association</em>'.
	 * @generated
	 */
	Association createAssociation();

	/**
	 * Returns a new object of class '<em>Input Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Association</em>'.
	 * @generated
	 */
	InputAssociation createInputAssociation();

	/**
	 * Returns a new object of class '<em>Output Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Association</em>'.
	 * @generated
	 */
	OutputAssociation createOutputAssociation();

	/**
	 * Returns a new object of class '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface</em>'.
	 * @generated
	 */
	Interface createInterface();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CakefeedPackage getCakefeedPackage();

} //CakefeedFactory
