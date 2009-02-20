package ssm.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import ssm.Transition;
import ssm.diagram.edit.policies.TransitionItemSemanticEditPolicy;

/**
 * @generated
 */
public class TransitionEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4006;

	/**
	 * @generated
	 */
	public TransitionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new TransitionItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof TransitionDelayEditPart) {
			((TransitionDelayEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureTransitionDelayLabel());
			return true;
		}
		if (childEditPart instanceof TransitionImmediateEditPart) {
			((TransitionImmediateEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureTransitionImmediateLabel());
			return true;
		}
		if (childEditPart instanceof TransitionPriorityEditPart) {
			((TransitionPriorityEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureTransitionPriorityLabel());
			return true;
		}
		if (childEditPart instanceof TransitionTransitionKindEditPart) {
			((TransitionTransitionKindEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureTransitionKindLabel());
			return true;
		}
		if (childEditPart instanceof TransitionTriggersAndEffectsEditPart) {
			((TransitionTriggersAndEffectsEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureTransitionTriggerEffectLabel());
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
		return new TransitionFigureDescriptor();
	}

	/**
	 * @generated
	 */
	public TransitionFigureDescriptor getPrimaryShape() {
		return (TransitionFigureDescriptor) getFigure();
	}

	//Changes: Override method
	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getNotifier() instanceof Transition) {
			getPrimaryShape().updateFace();
		}
		super.handleNotificationEvent(notification);
	}

	/**
	 * @generated
	 */
	public class TransitionFigureDescriptor extends PolylineConnectionEx {

		// Changes: new method updateFace
		public void updateFace() {
			Transition transition = (Transition) ((Edge) TransitionEditPart.this.getModel())
			.getElement();
			if (transition.getTransitionKind().toString().equals("STRONGABORT")) {
				PolygonDecoration df = new PolygonDecoration();
				df.setFill(true);
				df.setForegroundColor(ColorConstants.black);
				df.setBackgroundColor(ColorConstants.red);
				PointList pl = new PointList();
				pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
				pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(-1));
				pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(-1));
				pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(1));
				pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(1));
				df.setTemplate(pl);
				df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
				this.setSourceDecoration(df);
			}
			else if (transition.getTransitionKind().toString().equals(
					"NORMALTERMINATION")) {
				PolygonDecoration df = new PolygonDecoration();
				df.setFill(true);
				df.setForegroundColor(ColorConstants.black);
				df.setBackgroundColor(ColorConstants.green);
				PointList pl = new PointList();
				pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(-1));
				pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(0));
				pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(1));
				df.setTemplate(pl);
				df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
				this.setSourceDecoration(df);
			}
			else {
				this.setSourceDecoration(null);
			}
		}

		/**
		 * @generated
		 */
		private WrappingLabel fFigureTransitionDelayLabel;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureTransitionImmediateLabel;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureTransitionPriorityLabel;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureTransitionKindLabel;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureTransitionTriggerEffectLabel;

		/**
		 * @generated NOT
		 */
		public TransitionFigureDescriptor() {
			this.setForegroundColor(ColorConstants.black);
			this.setBackgroundColor(ColorConstants.black);
			setTargetDecoration(createTargetDecoration());
			// Changes: call updateFace
			updateFace();
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureTransitionDelayLabel = new WrappingLabel();
			fFigureTransitionDelayLabel.setText("");

			this.add(fFigureTransitionDelayLabel);

			fFigureTransitionImmediateLabel = new WrappingLabel();
			fFigureTransitionImmediateLabel.setText("");

			this.add(fFigureTransitionImmediateLabel);

			fFigureTransitionPriorityLabel = new WrappingLabel();
			fFigureTransitionPriorityLabel.setText("");

			this.add(fFigureTransitionPriorityLabel);

			fFigureTransitionKindLabel = new WrappingLabel();
			fFigureTransitionKindLabel.setText("");

			this.add(fFigureTransitionKindLabel);

			fFigureTransitionTriggerEffectLabel = new WrappingLabel();
			fFigureTransitionTriggerEffectLabel.setText("<Triggers>/<Effects>");

			this.add(fFigureTransitionTriggerEffectLabel);

		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolygonDecoration df = new PolygonDecoration();
			df.setFill(true);
			df.setLineWidth(2);
			df.setForegroundColor(ColorConstants.black);
			df.setBackgroundColor(ColorConstants.black);
			return df;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureTransitionDelayLabel() {
			return fFigureTransitionDelayLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureTransitionImmediateLabel() {
			return fFigureTransitionImmediateLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureTransitionPriorityLabel() {
			return fFigureTransitionPriorityLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureTransitionKindLabel() {
			return fFigureTransitionKindLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureTransitionTriggerEffectLabel() {
			return fFigureTransitionTriggerEffectLabel;
		}

	}

}
