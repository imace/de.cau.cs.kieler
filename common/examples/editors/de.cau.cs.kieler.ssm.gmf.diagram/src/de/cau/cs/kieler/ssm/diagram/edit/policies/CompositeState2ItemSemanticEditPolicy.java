package de.cau.cs.kieler.ssm.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.ssm.diagram.edit.commands.NormalTerminationCreateCommand;
import de.cau.cs.kieler.ssm.diagram.edit.commands.NormalTerminationReorientCommand;
import de.cau.cs.kieler.ssm.diagram.edit.commands.StrongAbortionCreateCommand;
import de.cau.cs.kieler.ssm.diagram.edit.commands.StrongAbortionReorientCommand;
import de.cau.cs.kieler.ssm.diagram.edit.commands.WeakAbortionCreateCommand;
import de.cau.cs.kieler.ssm.diagram.edit.commands.WeakAbortionReorientCommand;
import de.cau.cs.kieler.ssm.diagram.edit.parts.CompositeStateCompositeStateCompartment2EditPart;
import de.cau.cs.kieler.ssm.diagram.edit.parts.NormalTerminationEditPart;
import de.cau.cs.kieler.ssm.diagram.edit.parts.RegionEditPart;
import de.cau.cs.kieler.ssm.diagram.edit.parts.StrongAbortionEditPart;
import de.cau.cs.kieler.ssm.diagram.edit.parts.WeakAbortionEditPart;
import de.cau.cs.kieler.ssm.diagram.part.SafeStateMachineVisualIDRegistry;
import de.cau.cs.kieler.ssm.diagram.providers.SafeStateMachineElementTypes;

/**
 * @generated
 */
public class CompositeState2ItemSemanticEditPolicy extends
		SafeStateMachineBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyChildNodesCommand(cc);
		addDestroyShortcutsCommand(cc);
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
		View view = (View) getHost().getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation != null) {
			return;
		}
		for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			switch (SafeStateMachineVisualIDRegistry.getVisualID(node)) {
			case CompositeStateCompositeStateCompartment2EditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (SafeStateMachineVisualIDRegistry.getVisualID(cnode)) {
					case RegionEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					}
				}
				break;
			}
		}
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
