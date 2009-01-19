package edu.unikiel.rtsys.kieler.ssm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.CompositeState2CreateCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.InitialStateCreateCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.SimpleStateCreateCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.providers.SafeStateMachineElementTypes;

/**
 * @generated
 */
public class RegionRegionCompartmentItemSemanticEditPolicy extends
		SafeStateMachineBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (SafeStateMachineElementTypes.CompositeState_3002 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
								.getRegion_States());
			}
			return getGEFWrapper(new CompositeState2CreateCommand(req));
		}
		if (SafeStateMachineElementTypes.SimpleState_3003 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
								.getRegion_States());
			}
			return getGEFWrapper(new SimpleStateCreateCommand(req));
		}
		if (SafeStateMachineElementTypes.InitialState_3004 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
								.getRegion_States());
			}
			return getGEFWrapper(new InitialStateCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
