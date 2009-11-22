/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.util;

import cakefeed.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see cakefeed.CakefeedPackage
 * @generated
 */
public class CakefeedSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CakefeedPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CakefeedSwitch() {
		if (modelPackage == null) {
			modelPackage = CakefeedPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CakefeedPackage.APPLICATION: {
				Application application = (Application)theEObject;
				T result = caseApplication(application);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FUNCTION_BLOCK: {
				FunctionBlock functionBlock = (FunctionBlock)theEObject;
				T result = caseFunctionBlock(functionBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.BASIC_FUNCTION_BLOCK: {
				BasicFunctionBlock basicFunctionBlock = (BasicFunctionBlock)theEObject;
				T result = caseBasicFunctionBlock(basicFunctionBlock);
				if (result == null) result = caseFunctionBlock(basicFunctionBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK: {
				CompositeFunctionBlock compositeFunctionBlock = (CompositeFunctionBlock)theEObject;
				T result = caseCompositeFunctionBlock(compositeFunctionBlock);
				if (result == null) result = caseFunctionBlock(compositeFunctionBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK: {
				ServiceInterfaceFunctionBlock serviceInterfaceFunctionBlock = (ServiceInterfaceFunctionBlock)theEObject;
				T result = caseServiceInterfaceFunctionBlock(serviceInterfaceFunctionBlock);
				if (result == null) result = caseFunctionBlock(serviceInterfaceFunctionBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.FUNCTION_BLOCK_INSTANCE: {
				FunctionBlockInstance functionBlockInstance = (FunctionBlockInstance)theEObject;
				T result = caseFunctionBlockInstance(functionBlockInstance);
				if (result == null) result = caseFunctionBlock(functionBlockInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE: {
				BasicFunctionBlockInstance basicFunctionBlockInstance = (BasicFunctionBlockInstance)theEObject;
				T result = caseBasicFunctionBlockInstance(basicFunctionBlockInstance);
				if (result == null) result = caseFunctionBlockInstance(basicFunctionBlockInstance);
				if (result == null) result = caseBasicFunctionBlock(basicFunctionBlockInstance);
				if (result == null) result = caseFunctionBlock(basicFunctionBlockInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK_INSTANCE: {
				CompositeFunctionBlockInstance compositeFunctionBlockInstance = (CompositeFunctionBlockInstance)theEObject;
				T result = caseCompositeFunctionBlockInstance(compositeFunctionBlockInstance);
				if (result == null) result = caseFunctionBlockInstance(compositeFunctionBlockInstance);
				if (result == null) result = caseCompositeFunctionBlock(compositeFunctionBlockInstance);
				if (result == null) result = caseFunctionBlock(compositeFunctionBlockInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE: {
				ServiceInterfaceFunctionBlockInstance serviceInterfaceFunctionBlockInstance = (ServiceInterfaceFunctionBlockInstance)theEObject;
				T result = caseServiceInterfaceFunctionBlockInstance(serviceInterfaceFunctionBlockInstance);
				if (result == null) result = caseFunctionBlockInstance(serviceInterfaceFunctionBlockInstance);
				if (result == null) result = caseServiceInterfaceFunctionBlock(serviceInterfaceFunctionBlockInstance);
				if (result == null) result = caseFunctionBlock(serviceInterfaceFunctionBlockInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.CONNECTION: {
				Connection connection = (Connection)theEObject;
				T result = caseConnection(connection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.EVENT_CONNECTION: {
				EventConnection eventConnection = (EventConnection)theEObject;
				T result = caseEventConnection(eventConnection);
				if (result == null) result = caseConnection(eventConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.DATA_CONNECTION: {
				DataConnection dataConnection = (DataConnection)theEObject;
				T result = caseDataConnection(dataConnection);
				if (result == null) result = caseConnection(dataConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.PORT: {
				Port port = (Port)theEObject;
				T result = casePort(port);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.EVENT_PORT: {
				EventPort eventPort = (EventPort)theEObject;
				T result = caseEventPort(eventPort);
				if (result == null) result = casePort(eventPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.DATA_PORT: {
				DataPort dataPort = (DataPort)theEObject;
				T result = caseDataPort(dataPort);
				if (result == null) result = casePort(dataPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.INPUT_EVENT_PORT: {
				InputEventPort inputEventPort = (InputEventPort)theEObject;
				T result = caseInputEventPort(inputEventPort);
				if (result == null) result = caseEventPort(inputEventPort);
				if (result == null) result = casePort(inputEventPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.OUTPUT_EVENT_PORT: {
				OutputEventPort outputEventPort = (OutputEventPort)theEObject;
				T result = caseOutputEventPort(outputEventPort);
				if (result == null) result = caseEventPort(outputEventPort);
				if (result == null) result = casePort(outputEventPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.INPUT_DATA_PORT: {
				InputDataPort inputDataPort = (InputDataPort)theEObject;
				T result = caseInputDataPort(inputDataPort);
				if (result == null) result = caseDataPort(inputDataPort);
				if (result == null) result = casePort(inputDataPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.OUTPUT_DATA_PORT: {
				OutputDataPort outputDataPort = (OutputDataPort)theEObject;
				T result = caseOutputDataPort(outputDataPort);
				if (result == null) result = caseDataPort(outputDataPort);
				if (result == null) result = casePort(outputDataPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.ALGORITHM: {
				Algorithm algorithm = (Algorithm)theEObject;
				T result = caseAlgorithm(algorithm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.COMPOSITE_NETWORK: {
				CompositeNetwork compositeNetwork = (CompositeNetwork)theEObject;
				T result = caseCompositeNetwork(compositeNetwork);
				if (result == null) result = caseApplication(compositeNetwork);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.SERVICE_SEQUENCE: {
				ServiceSequence serviceSequence = (ServiceSequence)theEObject;
				T result = caseServiceSequence(serviceSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.ASSOCIATION: {
				Association association = (Association)theEObject;
				T result = caseAssociation(association);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.INPUT_ASSOCIATION: {
				InputAssociation inputAssociation = (InputAssociation)theEObject;
				T result = caseInputAssociation(inputAssociation);
				if (result == null) result = caseAssociation(inputAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.OUTPUT_ASSOCIATION: {
				OutputAssociation outputAssociation = (OutputAssociation)theEObject;
				T result = caseOutputAssociation(outputAssociation);
				if (result == null) result = caseAssociation(outputAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CakefeedPackage.INTERFACE: {
				Interface interface_ = (Interface)theEObject;
				T result = caseInterface(interface_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplication(Application object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionBlock(FunctionBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Function Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Function Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicFunctionBlock(BasicFunctionBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Function Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Function Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeFunctionBlock(CompositeFunctionBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Interface Function Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Interface Function Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceInterfaceFunctionBlock(ServiceInterfaceFunctionBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Block Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Block Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionBlockInstance(FunctionBlockInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Function Block Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Function Block Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicFunctionBlockInstance(BasicFunctionBlockInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Function Block Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Function Block Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeFunctionBlockInstance(CompositeFunctionBlockInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Interface Function Block Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Interface Function Block Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceInterfaceFunctionBlockInstance(ServiceInterfaceFunctionBlockInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnection(Connection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventConnection(EventConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataConnection(DataConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventPort(EventPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataPort(DataPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Event Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Event Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputEventPort(InputEventPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Event Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Event Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputEventPort(OutputEventPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Data Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Data Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputDataPort(InputDataPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Data Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Data Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputDataPort(OutputDataPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Algorithm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlgorithm(Algorithm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Network</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Network</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeNetwork(CompositeNetwork object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceSequence(ServiceSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssociation(Association object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputAssociation(InputAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputAssociation(OutputAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterface(Interface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //CakefeedSwitch
