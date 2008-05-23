package edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.policies.GCTLconnectorItemSemanticEditPolicy;

/**
 * @generated
 */
public class GCTLconnectorEditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3001;

	/**
	 * @generated
	 */
	public GCTLconnectorEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new GCTLconnectorItemSemanticEditPolicy());
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
		return new GCTLConnectorFigure();
	}

	/**
	 * @generated
	 */
	public GCTLConnectorFigure getPrimaryShape() {
		return (GCTLConnectorFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class GCTLConnectorFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public GCTLConnectorFigure() {

			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolygonDecoration df = new PolygonDecoration();
			return df;
		}

	}

}
