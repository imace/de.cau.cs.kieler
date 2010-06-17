package de.cau.cs.kieler.synccharts.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.cau.cs.kieler.synccharts.diagram.edit.commands.Action3CreateCommand;
import de.cau.cs.kieler.synccharts.diagram.providers.SyncchartsElementTypes;

/**
 * @generated
 */
public class StateState9ItemSemanticEditPolicy extends SyncchartsBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public StateState9ItemSemanticEditPolicy() {
        super(SyncchartsElementTypes.State_3024);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (SyncchartsElementTypes.Action_3028 == req.getElementType()) {
            return getGEFWrapper(new Action3CreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
