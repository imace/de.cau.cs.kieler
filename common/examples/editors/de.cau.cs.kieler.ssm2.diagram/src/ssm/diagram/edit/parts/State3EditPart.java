package ssm.diagram.edit.parts;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import ssm.State;
import ssm.diagram.edit.policies.State3ItemSemanticEditPolicy;
import ssm.diagram.part.SsmVisualIDRegistry;

/**
 * @generated
 */
public class State3EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3001;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public State3EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new State3ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		StateFigureDescriptor figure = new StateFigureDescriptor();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public StateFigureDescriptor getPrimaryShape() {
		return (StateFigureDescriptor) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StateName2EditPart) {
			((StateName2EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureStateNameLabel());
			return true;
		}
		if (childEditPart instanceof StateStateCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getFigureStateNameLabel();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((StateStateCompartment2EditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof StateStateCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getFigureStateNameLabel();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((StateStateCompartment2EditPart) childEditPart)
					.getFigure());
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
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

		if (editPart instanceof StateStateCompartment2EditPart) {
			return getPrimaryShape().getFigureStateNameLabel();
		}
		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(40), getMapMode().DPtoLP(30));
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(getMapMode().DPtoLP(5));
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(SsmVisualIDRegistry
				.getType(StateName2EditPart.VISUAL_ID));
	}

	//Changes: Override method
	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getNotifier() instanceof State) {
			getPrimaryShape().updateFace();
		}
		super.handleNotificationEvent(notification);
	}

	/**
	 * @generated
	 */
	public class StateFigureDescriptor extends RoundedRectangle {

		// Changes: new method updateFace
		public void updateFace() {
			State state = (State) ((Node) State3EditPart.this.getModel())
					.getElement();
			int sizeX = this.getBounds().width;
			int sizeY = this.getBounds().height;
			int newSize = 0;
			int newCornerDim = 0;
			int lineWidth = 2;
			Dimension cornerDim;

			if (state.getStateFlag().toString().equals("INITIAL")) {
				lineWidth = 4;
			}
			if (state.getStateFlag().toString().equals("FINAL")) {
				if (sizeX >= sizeY) {
					newSize = sizeY;
					newCornerDim = sizeY;
				} else {
					newSize = sizeX;
					newCornerDim = sizeY;
				}
				this.setSize(newSize, newSize);
				cornerDim = new Dimension(newCornerDim, newCornerDim);
			} else
				cornerDim = new Dimension(sizeX / 5, sizeY / 5);

			this.setCornerDimensions(cornerDim);
			this.setLineWidth(lineWidth);
		}

		/**
		 * @generated
		 */
		private WrappingLabel fFigureStateNameLabel;

		/**
		 * @generated NOT
		 */
		public StateFigureDescriptor() {
			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(16),
					getMapMode().DPtoLP(16)));
			this.setForegroundColor(ColorConstants.black);
			this.setBackgroundColor(ColorConstants.white);
			//Changes: call updateFace
			updateFace();
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureStateNameLabel = new WrappingLabel();
			fFigureStateNameLabel.setText("");

			this.add(fFigureStateNameLabel);

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
		public WrappingLabel getFigureStateNameLabel() {
			return fFigureStateNameLabel;
		}

	}

}
