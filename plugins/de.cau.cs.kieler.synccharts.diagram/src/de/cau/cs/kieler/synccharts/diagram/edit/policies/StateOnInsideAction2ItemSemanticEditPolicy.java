package de.cau.cs.kieler.synccharts.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.cau.cs.kieler.synccharts.diagram.edit.commands.Action2CreateCommand;
import de.cau.cs.kieler.synccharts.diagram.providers.SyncchartsElementTypes;

/**
 * @generated
 */
public class StateOnInsideAction2ItemSemanticEditPolicy extends
        SyncchartsBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public StateOnInsideAction2ItemSemanticEditPolicy() {
        super(SyncchartsElementTypes.State_3002);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (SyncchartsElementTypes.Action_3005 == req.getElementType()) {
            return getGEFWrapper(new Action2CreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
