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

import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.FBIFEventConnectionCreateCommand;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.FBIFEventConnectionReorientCommand;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.IFIFEventConnectionCreateCommand;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.IFIFEventConnectionReorientCommand;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.OutputWithCreateCommand;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.commands.OutputWithReorientCommand;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBIFEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFIFEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.OutputWithEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedVisualIDRegistry;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class IFOutputEventItemSemanticEditPolicy extends
		CakefeedBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public IFOutputEventItemSemanticEditPolicy() {
		super(CakefeedElementTypes.IFOutputEvent_3022);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (CakefeedVisualIDRegistry.getVisualID(incomingLink) == IFIFEventConnectionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (CakefeedVisualIDRegistry.getVisualID(incomingLink) == FBIFEventConnectionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (CakefeedVisualIDRegistry.getVisualID(outgoingLink) == OutputWithEditPart.VISUAL_ID) {
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
		if (CakefeedElementTypes.OutputWith_4002 == req.getElementType()) {
			return getGEFWrapper(new OutputWithCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (CakefeedElementTypes.IFIFEventConnection_4007 == req
				.getElementType()) {
			return null;
		}
		if (CakefeedElementTypes.FBIFEventConnection_4009 == req
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
		if (CakefeedElementTypes.OutputWith_4002 == req.getElementType()) {
			return null;
		}
		if (CakefeedElementTypes.IFIFEventConnection_4007 == req
				.getElementType()) {
			return getGEFWrapper(new IFIFEventConnectionCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (CakefeedElementTypes.FBIFEventConnection_4009 == req
				.getElementType()) {
			return getGEFWrapper(new FBIFEventConnectionCreateCommand(req, req
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
		case OutputWithEditPart.VISUAL_ID:
			return getGEFWrapper(new OutputWithReorientCommand(req));
		case IFIFEventConnectionEditPart.VISUAL_ID:
			return getGEFWrapper(new IFIFEventConnectionReorientCommand(req));
		case FBIFEventConnectionEditPart.VISUAL_ID:
			return getGEFWrapper(new FBIFEventConnectionReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
