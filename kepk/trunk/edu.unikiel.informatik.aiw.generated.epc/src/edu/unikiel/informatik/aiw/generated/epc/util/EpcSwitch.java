/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.generated.epc.util;

import edu.unikiel.informatik.aiw.generated.epc.*;

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
 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage
 * @generated
 */
public class EpcSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EpcPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EpcSwitch() {
		if (modelPackage == null) {
			modelPackage = EpcPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EpcPackage.EPC: {
				EPC epc = (EPC)theEObject;
				Object result = caseEPC(epc);
				if (result == null) result = caseFunction(epc);
				if (result == null) result = caseNode(epc);
				if (result == null) result = caseEPCObject(epc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.EVENT: {
				Event event = (Event)theEObject;
				Object result = caseEvent(event);
				if (result == null) result = caseNode(event);
				if (result == null) result = caseEPCObject(event);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.FUNCTION: {
				Function function = (Function)theEObject;
				Object result = caseFunction(function);
				if (result == null) result = caseNode(function);
				if (result == null) result = caseEPCObject(function);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.TRIGGERS_EVENT: {
				TriggersEvent triggersEvent = (TriggersEvent)theEObject;
				Object result = caseTriggersEvent(triggersEvent);
				if (result == null) result = caseSuccessorOf(triggersEvent);
				if (result == null) result = caseRelationship(triggersEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.LOGICAL_OPERATOR: {
				LogicalOperator logicalOperator = (LogicalOperator)theEObject;
				Object result = caseLogicalOperator(logicalOperator);
				if (result == null) result = caseEPCObject(logicalOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.XOR: {
				XOR xor = (XOR)theEObject;
				Object result = caseXOR(xor);
				if (result == null) result = caseLogicalOperator(xor);
				if (result == null) result = caseEPCObject(xor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.OR: {
				OR or = (OR)theEObject;
				Object result = caseOR(or);
				if (result == null) result = caseLogicalOperator(or);
				if (result == null) result = caseEPCObject(or);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.AND: {
				AND and = (AND)theEObject;
				Object result = caseAND(and);
				if (result == null) result = caseLogicalOperator(and);
				if (result == null) result = caseEPCObject(and);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.INFORMATION: {
				Information information = (Information)theEObject;
				Object result = caseInformation(information);
				if (result == null) result = caseNode(information);
				if (result == null) result = caseEPCObject(information);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.NODE: {
				Node node = (Node)theEObject;
				Object result = caseNode(node);
				if (result == null) result = caseEPCObject(node);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.EPC_OBJECT: {
				EPCObject epcObject = (EPCObject)theEObject;
				Object result = caseEPCObject(epcObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.RELATIONSHIP: {
				Relationship relationship = (Relationship)theEObject;
				Object result = caseRelationship(relationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.ACTIVATES_FUNCTION: {
				ActivatesFunction activatesFunction = (ActivatesFunction)theEObject;
				Object result = caseActivatesFunction(activatesFunction);
				if (result == null) result = caseSuccessorOf(activatesFunction);
				if (result == null) result = caseRelationship(activatesFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.SUCCESSOR_OF: {
				SuccessorOf successorOf = (SuccessorOf)theEObject;
				Object result = caseSuccessorOf(successorOf);
				if (result == null) result = caseRelationship(successorOf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.PROVIDES_DATA_TO: {
				ProvidesDataTo providesDataTo = (ProvidesDataTo)theEObject;
				Object result = caseProvidesDataTo(providesDataTo);
				if (result == null) result = caseRelationship(providesDataTo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.WRITES_DATA_TO: {
				WritesDataTo writesDataTo = (WritesDataTo)theEObject;
				Object result = caseWritesDataTo(writesDataTo);
				if (result == null) result = caseRelationship(writesDataTo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.FUNCTION_TO_OPERATOR_CONNECTION: {
				FunctionToOperatorConnection functionToOperatorConnection = (FunctionToOperatorConnection)theEObject;
				Object result = caseFunctionToOperatorConnection(functionToOperatorConnection);
				if (result == null) result = caseSuccessorOf(functionToOperatorConnection);
				if (result == null) result = caseRelationship(functionToOperatorConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.EVENT_TO_OPERATOR_CONNECTION: {
				EventToOperatorConnection eventToOperatorConnection = (EventToOperatorConnection)theEObject;
				Object result = caseEventToOperatorConnection(eventToOperatorConnection);
				if (result == null) result = caseSuccessorOf(eventToOperatorConnection);
				if (result == null) result = caseRelationship(eventToOperatorConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.OPERATOR_TO_FUNCTION_CONNECTION: {
				OperatorToFunctionConnection operatorToFunctionConnection = (OperatorToFunctionConnection)theEObject;
				Object result = caseOperatorToFunctionConnection(operatorToFunctionConnection);
				if (result == null) result = caseSuccessorOf(operatorToFunctionConnection);
				if (result == null) result = caseRelationship(operatorToFunctionConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.OPERATOR_TO_EVENT_CONNECTION: {
				OperatorToEventConnection operatorToEventConnection = (OperatorToEventConnection)theEObject;
				Object result = caseOperatorToEventConnection(operatorToEventConnection);
				if (result == null) result = caseSuccessorOf(operatorToEventConnection);
				if (result == null) result = caseRelationship(operatorToEventConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.GCT_LCONNECTOR: {
				GCTLconnector gctLconnector = (GCTLconnector)theEObject;
				Object result = caseGCTLconnector(gctLconnector);
				if (result == null) result = caseRelationship(gctLconnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.IMPLICATION: {
				Implication implication = (Implication)theEObject;
				Object result = caseImplication(implication);
				if (result == null) result = caseNode(implication);
				if (result == null) result = caseEPCObject(implication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpcPackage.EQUIVALENCE: {
				Equivalence equivalence = (Equivalence)theEObject;
				Object result = caseEquivalence(equivalence);
				if (result == null) result = caseNode(equivalence);
				if (result == null) result = caseEPCObject(equivalence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EPC</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EPC</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEPC(EPC object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFunction(Function object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Triggers Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Triggers Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTriggersEvent(TriggersEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logical Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logical Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLogicalOperator(LogicalOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XOR</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XOR</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseXOR(XOR object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OR</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OR</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOR(OR object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AND</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AND</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAND(AND object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Information</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Information</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInformation(Information object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EPC Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EPC Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEPCObject(EPCObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRelationship(Relationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activates Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activates Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseActivatesFunction(ActivatesFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Successor Of</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Successor Of</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSuccessorOf(SuccessorOf object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Provides Data To</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Provides Data To</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProvidesDataTo(ProvidesDataTo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Writes Data To</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Writes Data To</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWritesDataTo(WritesDataTo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function To Operator Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function To Operator Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFunctionToOperatorConnection(FunctionToOperatorConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event To Operator Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event To Operator Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEventToOperatorConnection(EventToOperatorConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator To Function Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator To Function Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperatorToFunctionConnection(OperatorToFunctionConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator To Event Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator To Event Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperatorToEventConnection(OperatorToEventConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>GCT Lconnector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GCT Lconnector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGCTLconnector(GCTLconnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implication</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implication</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseImplication(Implication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equivalence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equivalence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEquivalence(Equivalence object) {
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
	public Object defaultCase(EObject object) {
		return null;
	}

} //EpcSwitch
