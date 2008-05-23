package edu.unikiel.informatik.aiw.generated.epc.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import edu.unikiel.informatik.aiw.generated.epc.EpcPackage;

/**
 * @generated
 */
public class EpcDomainModelElementTester extends PropertyTester {

	/**
	 * @generated
	 */
	public boolean test(Object receiver, String method, Object[] args,
			Object expectedValue) {
		if (false == receiver instanceof EObject) {
			return false;
		}
		EObject eObject = (EObject) receiver;
		EClass eClass = eObject.eClass();
		if (eClass == EpcPackage.eINSTANCE.getEPC()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getEvent()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getFunction()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getTriggersEvent()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getLogicalOperator()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getXOR()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getOR()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getAND()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getInformation()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getNode()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getEPCObject()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getRelationship()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getActivatesFunction()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getSuccessorOf()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getProvidesDataTo()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getWritesDataTo()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getFunctionToOperatorConnection()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getEventToOperatorConnection()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getOperatorToFunctionConnection()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getOperatorToEventConnection()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getGCTLconnector()) {
			return true;
		}
		if (eClass == EpcPackage.eINSTANCE.getImplication()) {
			return true;
		}
		return false;
	}

}
