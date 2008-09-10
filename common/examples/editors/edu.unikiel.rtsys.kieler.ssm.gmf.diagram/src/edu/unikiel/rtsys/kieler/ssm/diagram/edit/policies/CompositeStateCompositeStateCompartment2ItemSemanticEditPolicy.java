package edu.unikiel.rtsys.kieler.ssm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.unikiel.rtsys.kieler.ssm.diagram.edit.commands.RegionCreateCommand;
import edu.unikiel.rtsys.kieler.ssm.diagram.providers.SafeStateMachineElementTypes;

/**
 * @generated
 */
public class CompositeStateCompositeStateCompartment2ItemSemanticEditPolicy
        extends SafeStateMachineBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (SafeStateMachineElementTypes.Region_3001 == req.getElementType()) {
            if (req.getContainmentFeature() == null) {
                req
                        .setContainmentFeature(edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                                .getCompositeState_Regions());
            }
            return getGEFWrapper(new RegionCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
