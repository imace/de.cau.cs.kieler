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

import de.cau.cs.kieler.ssm.diagram.edit.policies.NormalTerminationItemSemanticEditPolicy;

/**
 * @generated
 */
public class NormalTerminationEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4002;

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
		if (childEditPart instanceof NormalTerminationEffectStringEditPart) {
			((NormalTerminationEffectStringEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureNormalTerminationLabelLabel());
			return true;
		}
		if (childEditPart instanceof NormalTerminationPriorityEditPart) {
			((NormalTerminationPriorityEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureNormalTerminationPriorityLabel());
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
		return new NormalTerminationFigure();
	}

	/**
	 * @generated
	 */
	public NormalTerminationFigure getPrimaryShape() {
		return (NormalTerminationFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class NormalTerminationFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormalTerminationLabelLabel;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormalTerminationPriorityLabel;

		/**
		 * @generated
		 */
		public NormalTerminationFigure() {

			createContents();
			setSourceDecoration(createSourceDecoration());
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureNormalTerminationLabelLabel = new WrappingLabel();
			fFigureNormalTerminationLabelLabel.setText("<../..>");

			this.add(fFigureNormalTerminationLabelLabel);

			fFigureNormalTerminationPriorityLabel = new WrappingLabel();
			fFigureNormalTerminationPriorityLabel.setText("");

			this.add(fFigureNormalTerminationPriorityLabel);

		}

		/**
		 * @generated
		 */
		private RotatableDecoration createSourceDecoration() {
			PolygonDecoration df = new PolygonDecoration();
			df.setFill(true);
			df.setForegroundColor(ColorConstants.green);
			df.setBackgroundColor(ColorConstants.green);
			PointList pl = new PointList();
			pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(-1));
			pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(0));
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
		public WrappingLabel getFigureNormalTerminationLabelLabel() {
			return fFigureNormalTerminationLabelLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormalTerminationPriorityLabel() {
			return fFigureNormalTerminationPriorityLabel;
		}

	}

}
