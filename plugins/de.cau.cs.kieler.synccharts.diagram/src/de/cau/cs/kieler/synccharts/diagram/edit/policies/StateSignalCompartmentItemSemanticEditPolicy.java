package de.cau.cs.kieler.synccharts.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.cau.cs.kieler.synccharts.diagram.edit.commands.SignalCreateCommand;
import de.cau.cs.kieler.synccharts.diagram.edit.commands.VariableCreateCommand;
import de.cau.cs.kieler.synccharts.diagram.providers.SyncchartsElementTypes;

/**
 * @generated
 */
public class StateSignalCompartmentItemSemanticEditPolicy extends
    SyncchartsBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public StateSignalCompartmentItemSemanticEditPolicy() {
        super(SyncchartsElementTypes.State_2005);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (SyncchartsElementTypes.Signal_3041 == req.getElementType()) {
            return getGEFWrapper(new SignalCreateCommand(req));
        }
        if (SyncchartsElementTypes.Variable_3047 == req.getElementType()) {
            return getGEFWrapper(new VariableCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

}
