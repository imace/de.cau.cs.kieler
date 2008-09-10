package edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import edu.unikiel.rtsys.kieler.ssm.diagram.edit.policies.NormalTerminationItemSemanticEditPolicy;

/**
 * @generated
 */
public class NormalTerminationEditPart extends ConnectionNodeEditPart implements
        ITreeBranchEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 4003;

    /**
     * @generated
     */
    public NormalTerminationEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new NormalTerminationItemSemanticEditPolicy());
    }

    /**
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof NormalTerminationPriorityEditPart) {
            ((NormalTerminationPriorityEditPart) childEditPart)
                    .setLabel(getPrimaryShape()
                            .getFigureWeakAbortionPriorityLabel());
            return true;
        }
        if (childEditPart instanceof NormalTerminationEffectStringEditPart) {
            ((NormalTerminationEffectStringEditPart) childEditPart)
                    .setLabel(getPrimaryShape()
                            .getFigureWeakAbortionLabelLabel());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected void addChildVisual(EditPart childEditPart, int index) {
        if (addFixedChild(childEditPart)) {
            return;
        }
        super.addChildVisual(childEditPart, -1);
    }

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model
     * so you may safely remove <i>generated</i> tag and modify it.
     * 
     * @generated
     */

    protected Connection createConnectionFigure() {
        return new WeakAbortionFigure();
    }

    /**
     * @generated
     */
    public WeakAbortionFigure getPrimaryShape() {
        return (WeakAbortionFigure) getFigure();
    }

    /**
     * @generated
     */
    public class WeakAbortionFigure extends PolylineConnectionEx {

        /**
         * @generated
         */
        private WrappingLabel fFigureWeakAbortionLabelLabel;
        /**
         * @generated
         */
        private WrappingLabel fFigureWeakAbortionPriorityLabel;

        /**
         * @generated
         */
        public WeakAbortionFigure() {
            this.setFillXOR(true);
            this.setOutlineXOR(true);

            createContents();
            setTargetDecoration(createTargetDecoration());
        }

        /**
         * @generated
         */
        private void createContents() {

            fFigureWeakAbortionLabelLabel = new WrappingLabel();
            fFigureWeakAbortionLabelLabel.setText("");

            this.add(fFigureWeakAbortionLabelLabel);

            fFigureWeakAbortionPriorityLabel = new WrappingLabel();
            fFigureWeakAbortionPriorityLabel.setText("");

            this.add(fFigureWeakAbortionPriorityLabel);

        }

        /**
         * @generated
         */
        private RotatableDecoration createTargetDecoration() {
            PolylineDecoration df = new PolylineDecoration();
            return df;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureWeakAbortionLabelLabel() {
            return fFigureWeakAbortionLabelLabel;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureWeakAbortionPriorityLabel() {
            return fFigureWeakAbortionPriorityLabel;
        }

    }

}
