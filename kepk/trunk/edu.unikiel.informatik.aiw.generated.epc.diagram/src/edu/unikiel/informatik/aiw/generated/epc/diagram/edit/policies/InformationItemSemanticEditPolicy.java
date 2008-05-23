package edu.unikiel.informatik.aiw.generated.epc.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.ProvidesDataToCreateCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.ProvidesDataToReorientCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.WritesDataToCreateCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.commands.WritesDataToReorientCommand;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.ProvidesDataToEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.WritesDataToEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.providers.EpcElementTypes;

/**
 * @generated
 */
public class InformationItemSemanticEditPolicy extends
		EpcBaseItemSemanticEditPolicy {

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
		if (EpcElementTypes.ProvidesDataTo_3002 == req.getElementType()) {
			return getGEFWrapper(new ProvidesDataToCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (EpcElementTypes.WritesDataTo_3003 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (EpcElementTypes.ProvidesDataTo_3002 == req.getElementType()) {
			return null;
		}
		if (EpcElementTypes.WritesDataTo_3003 == req.getElementType()) {
			return getGEFWrapper(new WritesDataToCreateCommand(req, req
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
		case ProvidesDataToEditPart.VISUAL_ID:
			return getGEFWrapper(new ProvidesDataToReorientCommand(req));
		case WritesDataToEditPart.VISUAL_ID:
			return getGEFWrapper(new WritesDataToReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
