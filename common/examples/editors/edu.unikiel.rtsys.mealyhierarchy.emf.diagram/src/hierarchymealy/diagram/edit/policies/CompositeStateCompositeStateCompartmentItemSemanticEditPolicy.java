package hierarchymealy.diagram.edit.policies;

import hierarchymealy.MealyPackage;
import hierarchymealy.diagram.edit.commands.CompositeState2CreateCommand;
import hierarchymealy.diagram.edit.commands.State2CreateCommand;
import hierarchymealy.diagram.edit.commands.StateCreateCommand;
import hierarchymealy.diagram.providers.MealyMachineElementTypes;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class CompositeStateCompositeStateCompartmentItemSemanticEditPolicy
		extends MealyMachineBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (MealyMachineElementTypes.State_3001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(MealyPackage.eINSTANCE
						.getCompositeState_Nodes());
			}
			return getGEFWrapper(new State2CreateCommand(req));
		}
		if (MealyMachineElementTypes.CompositeState_3002 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(MealyPackage.eINSTANCE
						.getCompositeState_Nodes());
			}
			return getGEFWrapper(new CompositeState2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
