package edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import edu.unikiel.rtsys.kieler.ssm.diagram.edit.policies.SafeStateMachineCanonicalEditPolicy;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.policies.SafeStateMachineItemSemanticEditPolicy;

/**
 * @generated
 */
public class SafeStateMachineEditPart extends DiagramEditPart {

    /**
     * @generated
     */
    public final static String MODEL_ID = "Safe State Machine"; //$NON-NLS-1$

    /**
     * @generated
     */
    public static final int VISUAL_ID = 1000;

    /**
     * @generated
     */
    public SafeStateMachineEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new SafeStateMachineItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
                new SafeStateMachineCanonicalEditPolicy());
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
    }

}
