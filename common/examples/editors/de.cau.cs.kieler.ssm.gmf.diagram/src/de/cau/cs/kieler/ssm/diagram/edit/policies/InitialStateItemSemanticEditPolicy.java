package de.cau.cs.kieler.ssm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.cau.cs.kieler.ssm.diagram.edit.commands.NormalTerminationCreateCommand;
import de.cau.cs.kieler.ssm.diagram.edit.commands.NormalTerminationReorientCommand;
import de.cau.cs.kieler.ssm.diagram.edit.commands.StrongAbortionCreateCommand;
import de.cau.cs.kieler.ssm.diagram.edit.commands.StrongAbortionReorientCommand;
import de.cau.cs.kieler.ssm.diagram.edit.commands.WeakAbortionCreateCommand;
import de.cau.cs.kieler.ssm.diagram.edit.commands.WeakAbortionReorientCommand;
import de.cau.cs.kieler.ssm.diagram.edit.parts.NormalTerminationEditPart;
import de.cau.cs.kieler.ssm.diagram.edit.parts.StrongAbortionEditPart;
import de.cau.cs.kieler.ssm.diagram.edit.parts.WeakAbortionEditPart;
import de.cau.cs.kieler.ssm.diagram.providers.SafeStateMachineElementTypes;

/**
 * @generated
 */
public class InitialStateItemSemanticEditPolicy extends
		SafeStateMachineBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyShortcutsCommand(cc);
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (SafeStateMachineElementTypes.StrongAbortion_4001 == req
				.getElementType()) {
			return getGEFWrapper(new StrongAbortionCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (SafeStateMachineElementTypes.NormalTermination_4002 == req
				.getElementType()) {
			return getGEFWrapper(new NormalTerminationCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (SafeStateMachineElementTypes.WeakAbortion_4003 == req
				.getElementType()) {
			return getGEFWrapper(new WeakAbortionCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (SafeStateMachineElementTypes.StrongAbortion_4001 == req
				.getElementType()) {
			return getGEFWrapper(new StrongAbortionCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (SafeStateMachineElementTypes.NormalTermination_4002 == req
				.getElementType()) {
			return getGEFWrapper(new NormalTerminationCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (SafeStateMachineElementTypes.WeakAbortion_4003 == req
				.getElementType()) {
			return getGEFWrapper(new WeakAbortionCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case StrongAbortionEditPart.VISUAL_ID:
			return getGEFWrapper(new StrongAbortionReorientCommand(req));
		case NormalTerminationEditPart.VISUAL_ID:
			return getGEFWrapper(new NormalTerminationReorientCommand(req));
		case WeakAbortionEditPart.VISUAL_ID:
			return getGEFWrapper(new WeakAbortionReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
