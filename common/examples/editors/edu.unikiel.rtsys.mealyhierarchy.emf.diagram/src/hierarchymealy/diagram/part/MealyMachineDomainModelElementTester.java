package hierarchymealy.diagram.part;

import hierarchymealy.MealyPackage;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * @generated
 */
public class MealyMachineDomainModelElementTester extends PropertyTester {

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
		if (eClass == MealyPackage.eINSTANCE.getHierarchyMealyMachine()) {
			return true;
		}
		if (eClass == MealyPackage.eINSTANCE.getState()) {
			return true;
		}
		if (eClass == MealyPackage.eINSTANCE.getEdge()) {
			return true;
		}
		if (eClass == MealyPackage.eINSTANCE.getCompositeState()) {
			return true;
		}
		return false;
	}

}
