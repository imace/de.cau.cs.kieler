package de.cau.cs.kieler.ssm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.cau.cs.kieler.ssm.diagram.edit.commands.RegionCreateCommand;
import de.cau.cs.kieler.ssm.diagram.providers.SafeStateMachineElementTypes;

/**
 * @generated
 */
public class CompositeStateCompositeStateCompartment2ItemSemanticEditPolicy
		extends SafeStateMachineBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (SafeStateMachineElementTypes.Region_3001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(de.cau.cs.kieler.ssm.ssmPackage.eINSTANCE
								.getCompositeState_Regions());
			}
			return getGEFWrapper(new RegionCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
