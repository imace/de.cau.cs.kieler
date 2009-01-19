package de.cau.cs.kieler.ssm.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * @generated
 */
public class SafeStateMachineDomainModelElementTester extends PropertyTester {

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
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getNamed()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getRegion()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getAbstractState()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getSimpleState()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getPseudoState()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getInitialState()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getCompositeState()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getTransition()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getTransitionTriggerable()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getTransitionImmediateable()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getInitialArc()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getConditionalTransition()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getNormalTermination()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getStrongAbortion()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getWeakAbortion()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getSafeStateMachine()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getTrigger()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getAction()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getOnAction()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getSignal()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getIntegerSignal()) {
			return true;
		}
		if (eClass == edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getCondition()) {
			return true;
		}
		return false;
	}

}
