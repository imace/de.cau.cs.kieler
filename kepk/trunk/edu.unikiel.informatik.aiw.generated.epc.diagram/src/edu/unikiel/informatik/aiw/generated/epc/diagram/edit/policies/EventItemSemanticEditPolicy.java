package edu.unikiel.informatik.aiw.generated.epc.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.ActivatesFunctionCreateCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.ActivatesFunctionReorientCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.EventToOperatorConnectionCreateCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.EventToOperatorConnectionReorientCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.OperatorToEventConnectionCreateCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.OperatorToEventConnectionReorientCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.TriggersEventCreateCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.TriggersEventReorientCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.ActivatesFunctionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EventToOperatorConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.OperatorToEventConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.TriggersEventEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.providers.EpcElementTypes;

/**
 * @generated
 */
public class EventItemSemanticEditPolicy extends EpcBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyShortcutsCommand(cc);
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			req.setElementToDestroy(view);
		}
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
		if (EpcElementTypes.TriggersEvent_3001 == req.getElementType()) {
			return null;
		}
		if (EpcElementTypes.ActivatesFunction_3004 == req.getElementType()) {
			return getGEFWrapper(new ActivatesFunctionCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (EpcElementTypes.EventToOperatorConnection_3005 == req
				.getElementType()) {
			return getGEFWrapper(new EventToOperatorConnectionCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (EpcElementTypes.OperatorToEventConnection_3007 == req
				.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (EpcElementTypes.TriggersEvent_3001 == req.getElementType()) {
			return getGEFWrapper(new TriggersEventCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (EpcElementTypes.ActivatesFunction_3004 == req.getElementType()) {
			return null;
		}
		if (EpcElementTypes.EventToOperatorConnection_3005 == req
				.getElementType()) {
			return null;
		}
		if (EpcElementTypes.OperatorToEventConnection_3007 == req
				.getElementType()) {
			return getGEFWrapper(new OperatorToEventConnectionCreateCommand(
					req, req.getSource(), req.getTarget()));
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
		case TriggersEventEditPart.VISUAL_ID:
			return getGEFWrapper(new TriggersEventReorientCommand(req));
		case ActivatesFunctionEditPart.VISUAL_ID:
			return getGEFWrapper(new ActivatesFunctionReorientCommand(req));
		case EventToOperatorConnectionEditPart.VISUAL_ID:
			return getGEFWrapper(new EventToOperatorConnectionReorientCommand(
					req));
		case OperatorToEventConnectionEditPart.VISUAL_ID:
			return getGEFWrapper(new OperatorToEventConnectionReorientCommand(
					req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
