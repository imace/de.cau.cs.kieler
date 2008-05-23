package edu.unikiel.informatik.aiw.generated.epc.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.EventToOperatorConnectionCreateCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.EventToOperatorConnectionReorientCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.FunctionToOperatorConnectionCreateCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.FunctionToOperatorConnectionReorientCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.OperatorToEventConnectionCreateCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.OperatorToEventConnectionReorientCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.OperatorToFunctionConnectionCreateCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.OperatorToFunctionConnectionReorientCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EventToOperatorConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.FunctionToOperatorConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.OperatorToEventConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.OperatorToFunctionConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.providers.EpcElementTypes;

/**
 * @generated
 */
public class XORItemSemanticEditPolicy extends EpcBaseItemSemanticEditPolicy {

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
		if (EpcElementTypes.EventToOperatorConnection_3005 == req
				.getElementType()) {
			return null;
		}
		if (EpcElementTypes.FunctionToOperatorConnection_3006 == req
				.getElementType()) {
			return null;
		}
		if (EpcElementTypes.OperatorToEventConnection_3007 == req
				.getElementType()) {
			return getGEFWrapper(new OperatorToEventConnectionCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (EpcElementTypes.OperatorToFunctionConnection_3008 == req
				.getElementType()) {
			return getGEFWrapper(new OperatorToFunctionConnectionCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (EpcElementTypes.EventToOperatorConnection_3005 == req
				.getElementType()) {
			return getGEFWrapper(new EventToOperatorConnectionCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (EpcElementTypes.FunctionToOperatorConnection_3006 == req
				.getElementType()) {
			return getGEFWrapper(new FunctionToOperatorConnectionCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (EpcElementTypes.OperatorToEventConnection_3007 == req
				.getElementType()) {
			return null;
		}
		if (EpcElementTypes.OperatorToFunctionConnection_3008 == req
				.getElementType()) {
			return null;
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
		case EventToOperatorConnectionEditPart.VISUAL_ID:
			return getGEFWrapper(new EventToOperatorConnectionReorientCommand(
					req));
		case FunctionToOperatorConnectionEditPart.VISUAL_ID:
			return getGEFWrapper(new FunctionToOperatorConnectionReorientCommand(
					req));
		case OperatorToEventConnectionEditPart.VISUAL_ID:
			return getGEFWrapper(new OperatorToEventConnectionReorientCommand(
					req));
		case OperatorToFunctionConnectionEditPart.VISUAL_ID:
			return getGEFWrapper(new OperatorToFunctionConnectionReorientCommand(
					req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
