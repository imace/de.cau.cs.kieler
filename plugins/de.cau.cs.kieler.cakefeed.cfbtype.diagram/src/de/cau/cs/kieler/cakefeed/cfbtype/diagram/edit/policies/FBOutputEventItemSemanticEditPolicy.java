package de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.FBFBEventConnectionCreateCommand;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.FBFBEventConnectionReorientCommand;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.FBIFEventConnectionCreateCommand;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.FBIFEventConnectionReorientCommand;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBFBEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBIFEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedVisualIDRegistry;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class FBOutputEventItemSemanticEditPolicy extends
		CakefeedBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FBOutputEventItemSemanticEditPolicy() {
		super(CakefeedElementTypes.FBOutputEvent_3018);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (CakefeedVisualIDRegistry.getVisualID(outgoingLink) == FBIFEventConnectionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (CakefeedVisualIDRegistry.getVisualID(outgoingLink) == FBFBEventConnectionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
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
		if (CakefeedElementTypes.FBIFEventConnection_4009 == req
				.getElementType()) {
			return getGEFWrapper(new FBIFEventConnectionCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (CakefeedElementTypes.FBFBEventConnection_4010 == req
				.getElementType()) {
			return getGEFWrapper(new FBFBEventConnectionCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (CakefeedElementTypes.FBIFEventConnection_4009 == req
				.getElementType()) {
			return null;
		}
		if (CakefeedElementTypes.FBFBEventConnection_4010 == req
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
		case FBIFEventConnectionEditPart.VISUAL_ID:
			return getGEFWrapper(new FBIFEventConnectionReorientCommand(req));
		case FBFBEventConnectionEditPart.VISUAL_ID:
			return getGEFWrapper(new FBFBEventConnectionReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
