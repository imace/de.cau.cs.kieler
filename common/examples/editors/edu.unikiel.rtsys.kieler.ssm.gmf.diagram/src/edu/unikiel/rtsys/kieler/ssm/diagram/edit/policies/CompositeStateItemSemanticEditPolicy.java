package edu.unikiel.rtsys.kieler.ssm.diagram.edit.policies;

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

import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.NormalTerminationCreateCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.NormalTerminationReorientCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.StrongAbortion2CreateCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.StrongAbortion2ReorientCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.StrongAbortionCreateCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.StrongAbortionReorientCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateCompositeStateCompartmentEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.NormalTerminationEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.RegionEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortion2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortionEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineVisualIDRegistry;
import edu.unikiel.rtsys.kieler.ssm.diagram.providers.SafeStateMachineElementTypes;

/**
 * @generated
 */
public class CompositeStateItemSemanticEditPolicy extends
        SafeStateMachineBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        CompoundCommand cc = getDestroyEdgesCommand();
        addDestroyChildNodesCommand(cc);
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
    protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
        View view = (View) getHost().getModel();
        EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
        if (annotation != null) {
            return;
        }
        for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
            Node node = (Node) it.next();
            switch (SafeStateMachineVisualIDRegistry.getVisualID(node)) {
            case CompositeStateCompositeStateCompartmentEditPart.VISUAL_ID:
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
            return getGEFWrapper(new StrongAbortion2CreateCommand(req, req
                    .getSource(), req.getTarget()));
        }
        if (SafeStateMachineElementTypes.NormalTermination_4002 == req
                .getElementType()) {
            return getGEFWrapper(new StrongAbortionCreateCommand(req, req
                    .getSource(), req.getTarget()));
        }
        if (SafeStateMachineElementTypes.WeakAbortion_4003 == req
                .getElementType()) {
            return getGEFWrapper(new NormalTerminationCreateCommand(req, req
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
            return getGEFWrapper(new StrongAbortion2CreateCommand(req, req
                    .getSource(), req.getTarget()));
        }
        if (SafeStateMachineElementTypes.NormalTermination_4002 == req
                .getElementType()) {
            return getGEFWrapper(new StrongAbortionCreateCommand(req, req
                    .getSource(), req.getTarget()));
        }
        if (SafeStateMachineElementTypes.WeakAbortion_4003 == req
                .getElementType()) {
            return getGEFWrapper(new NormalTerminationCreateCommand(req, req
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
        case StrongAbortion2EditPart.VISUAL_ID:
            return getGEFWrapper(new StrongAbortion2ReorientCommand(req));
        case StrongAbortionEditPart.VISUAL_ID:
            return getGEFWrapper(new StrongAbortionReorientCommand(req));
        case NormalTerminationEditPart.VISUAL_ID:
            return getGEFWrapper(new NormalTerminationReorientCommand(req));
        }
        return super.getReorientRelationshipCommand(req);
    }

}
