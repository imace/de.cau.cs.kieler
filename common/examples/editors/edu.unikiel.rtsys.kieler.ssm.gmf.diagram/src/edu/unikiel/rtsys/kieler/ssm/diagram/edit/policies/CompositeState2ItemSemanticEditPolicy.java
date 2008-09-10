package edu.unikiel.rtsys.kieler.ssm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.NormalTerminationCreateCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.NormalTerminationReorientCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.StrongAbortion2CreateCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.StrongAbortion2ReorientCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.StrongAbortionCreateCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.StrongAbortionReorientCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.NormalTerminationEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortion2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortionEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.providers.SafeStateMachineElementTypes;

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
