package de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies.IFIFEventConnectionItemSemanticEditPolicy;

/**
 * @generated
 */
public class IFIFEventConnectionEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4007;

	/**
	 * @generated
	 */
	public IFIFEventConnectionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new IFIFEventConnectionItemSemanticEditPolicy());
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
		return new EventConnectionFigureDescriptor();
	}

	/**
	 * @generated
	 */
	public EventConnectionFigureDescriptor getPrimaryShape() {
		return (EventConnectionFigureDescriptor) getFigure();
	}

	/**
	 * @generated
	 */
	public class EventConnectionFigureDescriptor extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public EventConnectionFigureDescriptor() {
			this.setLineWidth(1);
			this.setForegroundColor(ColorConstants.blue);
			this.setBackgroundColor(ColorConstants.blue);

		}

	}

}
