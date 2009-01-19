package de.cau.cs.kieler.ssm.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolygonDecoration;
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

import de.cau.cs.kieler.ssm.diagram.edit.policies.StrongAbortionItemSemanticEditPolicy;

/**
 * @generated
 */
public class StrongAbortionEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;

	/**
	 * @generated
	 */
	public StrongAbortionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new StrongAbortionItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StrongAbortionIsImmediateStringTriggeEditPart) {
			((StrongAbortionIsImmediateStringTriggeEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureStrongAbortionLabelLabel());
			return true;
		}
		if (childEditPart instanceof StrongAbortionPriorityEditPart) {
			((StrongAbortionPriorityEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureStrongAbortionPriorityLabel());
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
		return new StrongAbortionFigure();
	}

	/**
	 * @generated
	 */
	public StrongAbortionFigure getPrimaryShape() {
		return (StrongAbortionFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class StrongAbortionFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureStrongAbortionLabelLabel;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureStrongAbortionPriorityLabel;

		/**
		 * @generated
		 */
		public StrongAbortionFigure() {

			createContents();
			setSourceDecoration(createSourceDecoration());
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureStrongAbortionLabelLabel = new WrappingLabel();
			fFigureStrongAbortionLabelLabel.setText("");

			this.add(fFigureStrongAbortionLabelLabel);

			fFigureStrongAbortionPriorityLabel = new WrappingLabel();
			fFigureStrongAbortionPriorityLabel.setText("");

			this.add(fFigureStrongAbortionPriorityLabel);

		}

		/**
		 * @generated
		 */
		private RotatableDecoration createSourceDecoration() {
			PolygonDecoration df = new PolygonDecoration();
			df.setFill(true);
			df.setOutline(false);
			df.setForegroundColor(ColorConstants.red);
			df.setBackgroundColor(ColorConstants.red);
			PointList pl = new PointList();
			pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
			pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(-1));
			pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(-1));
			pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(1));
			pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(1));
			df.setTemplate(pl);
			df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
			return df;
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
		public WrappingLabel getFigureStrongAbortionLabelLabel() {
			return fFigureStrongAbortionLabelLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStrongAbortionPriorityLabel() {
			return fFigureStrongAbortionPriorityLabel;
		}

	}

}
