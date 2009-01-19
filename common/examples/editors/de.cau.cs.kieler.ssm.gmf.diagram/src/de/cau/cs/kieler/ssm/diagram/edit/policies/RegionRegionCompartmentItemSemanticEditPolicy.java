package de.cau.cs.kieler.ssm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.cau.cs.kieler.ssm.diagram.edit.commands.CompositeState2CreateCommand;
import de.cau.cs.kieler.ssm.diagram.edit.commands.InitialStateCreateCommand;
import de.cau.cs.kieler.ssm.diagram.edit.commands.SimpleStateCreateCommand;
import de.cau.cs.kieler.ssm.diagram.providers.SafeStateMachineElementTypes;

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
						.setContainmentFeature(de.cau.cs.kieler.ssm.ssmPackage.eINSTANCE
								.getRegion_States());
			}
			return getGEFWrapper(new CompositeState2CreateCommand(req));
		}
		if (SafeStateMachineElementTypes.SimpleState_3003 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(de.cau.cs.kieler.ssm.ssmPackage.eINSTANCE
								.getRegion_States());
			}
			return getGEFWrapper(new SimpleStateCreateCommand(req));
		}
		if (SafeStateMachineElementTypes.InitialState_3004 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(de.cau.cs.kieler.ssm.ssmPackage.eINSTANCE
								.getRegion_States());
			}
			return getGEFWrapper(new InitialStateCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
