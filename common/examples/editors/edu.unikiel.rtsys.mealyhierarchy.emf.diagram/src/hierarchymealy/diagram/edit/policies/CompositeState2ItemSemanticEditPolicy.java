package hierarchymealy.diagram.edit.policies;

import hierarchymealy.diagram.edit.commands.EdgeCreateCommand;
import hierarchymealy.diagram.edit.commands.EdgeReorientCommand;
import hierarchymealy.diagram.edit.parts.CompositeState2EditPart;
import hierarchymealy.diagram.edit.parts.CompositeStateCompositeStateCompartment2EditPart;
import hierarchymealy.diagram.edit.parts.EdgeEditPart;
import hierarchymealy.diagram.edit.parts.State2EditPart;
import hierarchymealy.diagram.edit.parts.StateEditPart;
import hierarchymealy.diagram.part.MealyMachineVisualIDRegistry;
import hierarchymealy.diagram.providers.MealyMachineElementTypes;

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

/**
 * @generated
 */
public class CompositeState2ItemSemanticEditPolicy extends
		MealyMachineBaseItemSemanticEditPolicy {

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
			switch (MealyMachineVisualIDRegistry.getVisualID(node)) {
			case CompositeStateCompositeStateCompartment2EditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (MealyMachineVisualIDRegistry.getVisualID(cnode)) {
					case State2EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case CompositeState2EditPart.VISUAL_ID:
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
		if (MealyMachineElementTypes.Edge_4001 == req.getElementType()) {
			return getGEFWrapper(new EdgeCreateCommand(req, req.getSource(),
					req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (MealyMachineElementTypes.Edge_4001 == req.getElementType()) {
			return getGEFWrapper(new EdgeCreateCommand(req, req.getSource(),
					req.getTarget()));
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
		case EdgeEditPart.VISUAL_ID:
			return getGEFWrapper(new EdgeReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
