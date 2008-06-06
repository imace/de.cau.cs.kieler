package hierarchymealy.diagram.edit.parts;

import hierarchymealy.custom.TransitionSplineCurve;
import hierarchymealy.diagram.edit.policies.EdgeItemSemanticEditPolicy;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EdgeEditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;

	/**
	 * @generated
	 */
	public EdgeEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new EdgeItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof EdgeTriggerActionEditPart) {
			((EdgeTriggerActionEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureEdgeSplineLabelFigure());
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
		return new EdgeSplineFigure();
	}

	/**
	 * @generated
	 */
	public EdgeSplineFigure getPrimaryShape() {
		return (EdgeSplineFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class EdgeSplineFigure extends TransitionSplineCurve {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureEdgeSplineLabelFigure;

		/**
		 * @generated
		 */
		public EdgeSplineFigure() {

			this.setForegroundColor(ColorConstants.darkBlue);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureEdgeSplineLabelFigure = new WrappingLabel();
			fFigureEdgeSplineLabelFigure.setText("[] / []");

			this.add(fFigureEdgeSplineLabelFigure);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureEdgeSplineLabelFigure() {
			return fFigureEdgeSplineLabelFigure;
		}

	}

}
