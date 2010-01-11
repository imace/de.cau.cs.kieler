package de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.commands.FBInputEventCreateCommand;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.commands.FBInputVarCreateCommand;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.commands.FBOutputEventCreateCommand;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.commands.FBOutputVarCreateCommand;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBFBEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputEventEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputVarEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.part.CakefeedVisualIDRegistry;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class FBItemSemanticEditPolicy extends
		CakefeedBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FBItemSemanticEditPolicy() {
		super(CakefeedElementTypes.FB_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CakefeedElementTypes.FBInputEvent_3001 == req.getElementType()) {
			return getGEFWrapper(new FBInputEventCreateCommand(req));
		}
		if (CakefeedElementTypes.FBOutputEvent_3002 == req.getElementType()) {
			return getGEFWrapper(new FBOutputEventCreateCommand(req));
		}
		if (CakefeedElementTypes.FBInputVar_3003 == req.getElementType()) {
			return getGEFWrapper(new FBInputVarCreateCommand(req));
		}
		if (CakefeedElementTypes.FBOutputVar_3004 == req.getElementType()) {
			return getGEFWrapper(new FBOutputVarCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyChildNodesCommand(cmd);
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
	private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
		View view = (View) getHost().getModel();
		for (Iterator nit = view.getChildren().iterator(); nit.hasNext();) {
			Node node = (Node) nit.next();
			switch (CakefeedVisualIDRegistry.getVisualID(node)) {
			case FBInputEventEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it
						.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (CakefeedVisualIDRegistry.getVisualID(incomingLink) == FBFBEventConnectionEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(
								incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(),
								incomingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(
						getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case FBOutputEventEditPart.VISUAL_ID:
				for (Iterator it = node.getSourceEdges().iterator(); it
						.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (CakefeedVisualIDRegistry.getVisualID(outgoingLink) == FBFBEventConnectionEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(
								outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(),
								outgoingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(
						getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case FBInputVarEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it
						.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (CakefeedVisualIDRegistry.getVisualID(incomingLink) == FBFBDataConnectionEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(
								incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(),
								incomingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(
						getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case FBOutputVarEditPart.VISUAL_ID:
				for (Iterator it = node.getSourceEdges().iterator(); it
						.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (CakefeedVisualIDRegistry.getVisualID(outgoingLink) == FBFBDataConnectionEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(
								outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(),
								outgoingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(
						getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			}
		}
	}

}
