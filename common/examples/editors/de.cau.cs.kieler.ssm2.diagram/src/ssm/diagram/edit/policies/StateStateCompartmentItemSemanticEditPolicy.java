package ssm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import ssm.diagram.edit.commands.State2CreateCommand;
import ssm.diagram.providers.SsmElementTypes;

/**
 * @generated
 */
public class StateStateCompartmentItemSemanticEditPolicy extends
		SsmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (SsmElementTypes.State_3001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(ssm.ssmPackage.eINSTANCE
						.getState_InnerStates());
			}
			return getGEFWrapper(new State2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
