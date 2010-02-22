package de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.cau.cs.kieler.cakefeed.FBInputEvent;
import de.cau.cs.kieler.cakefeed.FBInputVar;
import de.cau.cs.kieler.cakefeed.FBNetwork;
import de.cau.cs.kieler.cakefeed.FBOutputEvent;
import de.cau.cs.kieler.cakefeed.FBOutputVar;
import de.cau.cs.kieler.cakefeed.FBType;
import de.cau.cs.kieler.cakefeed.IFInputEvent;
import de.cau.cs.kieler.cakefeed.IFInputVar;
import de.cau.cs.kieler.cakefeed.IFOutputEvent;
import de.cau.cs.kieler.cakefeed.IFOutputVar;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies.FBCanonicalEditPolicy;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies.FBItemSemanticEditPolicy;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedVisualIDRegistry;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.providers.CakefeedElementTypes;
import de.cau.cs.kieler.cakefeed.custom.CakefeedBorderItemLocator;
import de.cau.cs.kieler.cakefeed.custom.FBFigure;
import de.cau.cs.kieler.cakefeed.custom.FBLayout;
import de.cau.cs.kieler.cakefeed.custom.FBTypeFigure;
import de.cau.cs.kieler.cakefeed.impl.BFBTypeImpl;
import de.cau.cs.kieler.cakefeed.impl.CFBTypeImpl;
import de.cau.cs.kieler.cakefeed.impl.FBTypeImpl;

/**
 * @generated
 */
public class FBEditPart extends AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3025;

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
	public FBEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new FBItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new FBCanonicalEditPolicy());
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
				View childView = (View) child.getModel();
				switch (CakefeedVisualIDRegistry.getVisualID(childView)) {
				case de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputEventEditPart.VISUAL_ID:
				case de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputEventEditPart.VISUAL_ID:
				case de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputVarEditPart.VISUAL_ID:
				case FBOutputVarEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy();
				}
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
		IFigure figure = new FBFigureDescriptor();

		if (figure instanceof FBTypeFigure) {
			((FBTypeFigure) figure).listenTo(this.getNotationView()
					.getElement());
		}
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public FBFigureDescriptor getPrimaryShape() {
		return (FBFigureDescriptor) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabelEditPart) {
			((WrappingLabelEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureFBTypeNameLabel());
			return true;
		}
		if (childEditPart instanceof FBNameEditPart) {
			((FBNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureFBInstanceNameLabel());
			return true;
		}
		if (childEditPart instanceof de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputEventEditPart) {
			BorderItemLocator locator =

			new CakefeedBorderItemLocator(getMainFigure(),
					PositionConstants.WEST, getCtrl(childEditPart),
					getInput(childEditPart));

			getBorderedFigure()
					.getBorderItemContainer()
					.add(
							((de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputEventEditPart) childEditPart)
									.getFigure(), locator);
			return true;
		}
		if (childEditPart instanceof de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputEventEditPart) {
			BorderItemLocator locator =

			new CakefeedBorderItemLocator(getMainFigure(),
					PositionConstants.EAST, getCtrl(childEditPart),
					getInput(childEditPart));

			getBorderedFigure()
					.getBorderItemContainer()
					.add(
							((de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputEventEditPart) childEditPart)
									.getFigure(), locator);
			return true;
		}
		if (childEditPart instanceof de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputVarEditPart) {
			BorderItemLocator locator =

			new CakefeedBorderItemLocator(getMainFigure(),
					PositionConstants.WEST, getCtrl(childEditPart),
					getInput(childEditPart));

			getBorderedFigure()
					.getBorderItemContainer()
					.add(
							((de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputVarEditPart) childEditPart)
									.getFigure(), locator);
			return true;
		}
		if (childEditPart instanceof FBOutputVarEditPart) {
			BorderItemLocator locator =

			new CakefeedBorderItemLocator(getMainFigure(),
					PositionConstants.EAST, getCtrl(childEditPart),
					getInput(childEditPart));

			getBorderedFigure().getBorderItemContainer().add(
					((FBOutputVarEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabelEditPart) {
			return true;
		}
		if (childEditPart instanceof FBNameEditPart) {
			return true;
		}
		if (childEditPart instanceof de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputEventEditPart) {
			getBorderedFigure()
					.getBorderItemContainer()
					.remove(
							((de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputEventEditPart) childEditPart)
									.getFigure());
			return true;
		}
		if (childEditPart instanceof de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputEventEditPart) {
			getBorderedFigure()
					.getBorderItemContainer()
					.remove(
							((de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputEventEditPart) childEditPart)
									.getFigure());
			return true;
		}
		if (childEditPart instanceof de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputVarEditPart) {
			getBorderedFigure()
					.getBorderItemContainer()
					.remove(
							((de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputVarEditPart) childEditPart)
									.getFigure());
			return true;
		}
		if (childEditPart instanceof FBOutputVarEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((FBOutputVarEditPart) childEditPart).getFigure());
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
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(20, 20);
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
	protected NodeFigure createMainFigure() {
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
			layout.setSpacing(5);
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
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(CakefeedVisualIDRegistry
				.getType(FBNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class FBFigureDescriptor extends FBFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureFBInstanceNameLabel;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFBTypeNameLabel;

		/**
		 * @generated
		 */
		public FBFigureDescriptor() {

			FBLayout layoutThis = new FBLayout();

			this.setLayoutManager(layoutThis);

			this.setBorder(new MarginBorder(getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureFBInstanceNameLabel = new WrappingLabel();
			fFigureFBInstanceNameLabel.setText("");

			this.add(fFigureFBInstanceNameLabel);

			fFigureFBTypeNameLabel = new WrappingLabel();
			fFigureFBTypeNameLabel.setText("");

			this.add(fFigureFBTypeNameLabel);

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
		public WrappingLabel getFigureFBInstanceNameLabel() {
			return fFigureFBInstanceNameLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFBTypeNameLabel() {
			return fFigureFBTypeNameLabel;
		}

	}

	/**
	 * @generated NOT
	 *
	 * @author schm
	 *
	 * @param notification The notification
	 *
	 * If the type of an FB has been changed, the ports are updated to reflect
	 * the changes.
	 *
	 */
	@SuppressWarnings("unchecked")
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		if (notification != null) {
			Object feat = notification.getFeature();
			if ((feat != null) && (feat instanceof EReferenceImpl)) {
				EReferenceImpl ref = (EReferenceImpl) feat;
				String name = ref.getName();
				if ((name != null) && (name.equals("type"))) {
					Object newValue = notification.getNewValue();
					if ((newValue != null)
							&& ((newValue instanceof CFBTypeImpl) || (newValue instanceof BFBTypeImpl))) {

						List children = this.getChildren();

						EList inputEvents = null;
						EList outputEvents = null;
						EList inputVars = null;
						EList outputVars = null;

						FBTypeImpl t = (FBTypeImpl) newValue;

						WrappingLabel typeNameLabel = null;

						if (newValue instanceof CFBTypeImpl) {
							CFBTypeImpl type = (CFBTypeImpl) newValue;
							inputEvents = type.getInputEvents();
							outputEvents = type.getOutputEvents();
							inputVars = type.getInputVars();
							outputVars = type.getOutputVars();
						} else {
							BFBTypeImpl type = (BFBTypeImpl) newValue;
							inputEvents = type.getInputEvents();
							outputEvents = type.getOutputEvents();
							inputVars = type.getInputVars();
							outputVars = type.getOutputVars();
						}

						de.cau.cs.kieler.cakefeed.FB fB = (de.cau.cs.kieler.cakefeed.FB) ((View) this
								.getModel()).getElement();

						// Delete old Events and Vars			
						deleteEventsAndVars(fB);

						// Delete Connections connected to this FB
						clearConnections(fB);

						if ((inputEvents != null) && (outputEvents != null)
								&& (inputVars != null) && (outputVars != null)) {
							EList[] lists = new EList[4];
							lists[0] = inputEvents;
							lists[1] = outputEvents;
							lists[2] = inputVars;
							lists[3] = outputVars;

							for (int i = 0; i < 4; i++) {
								EList<EObject> list = lists[i];
								for (EObject o : list) {
									IElementType elementType = null;
									if (o instanceof IFInputEvent) {
										elementType = CakefeedElementTypes.FBInputEvent_3026;
									} else if (o instanceof IFOutputEvent) {
										elementType = CakefeedElementTypes.FBOutputEvent_3027;
									} else if (o instanceof IFInputVar) {
										elementType = CakefeedElementTypes.FBInputVar_3028;
									} else if (o instanceof IFOutputVar) {
										elementType = CakefeedElementTypes.FBOutputVar_3029;
									}
									if (elementType != null) {
										CreateViewRequest createRequest = CreateViewRequestFactory
												.getCreateShapeRequest(
														elementType,
														this
																.getDiagramPreferencesHint());
										Command createCmd = this
												.getCommand(createRequest);
										this.getDiagramEditDomain()
												.getDiagramCommandStack()
												.execute(createCmd);
									}
								}
							}
							// Adapt Events and Variables
							this.getDiagramEditDomain()
									.getDiagramCommandStack().execute(
											new FBAdaptEventsAndVarsCommand(
													"adaptEventsAndVariables",
													fB, t));
						}

					} else {
						de.cau.cs.kieler.cakefeed.FB fB = (de.cau.cs.kieler.cakefeed.FB) ((View) this
								.getModel()).getElement();
						deleteEventsAndVars(fB);
						clearConnections(fB);
					}
				}
			}
		}
	}

	private void deleteEventsAndVars(de.cau.cs.kieler.cakefeed.FB fB) {
		this.getDiagramEditDomain().getDiagramCommandStack()
				.execute(
						new FBDeleteEventsAndVarsCommand(
								"deleteEventsAndVariables", fB));
	}

	private void clearConnections(de.cau.cs.kieler.cakefeed.FB fB) {
		this.getDiagramEditDomain().getDiagramCommandStack().execute(
				new ClearConnectionsCommand("clearConnections", fB));
	}

	public class FBCommand extends Command {

		protected de.cau.cs.kieler.cakefeed.FB functionBlock;

		public FBCommand(String label, de.cau.cs.kieler.cakefeed.FB fB) {
			super(label);
			functionBlock = fB;
		}
	}

	public class ClearConnectionsCommand extends FBCommand {

		public ClearConnectionsCommand(String label,
				de.cau.cs.kieler.cakefeed.FB fB) {
			super(label, fB);
		}

		public void execute() {
			EObject container = functionBlock.eContainer();
			if (container instanceof FBNetwork) {
				FBNetwork fBNetwork = (FBNetwork) container;
				fBNetwork.getEventConnections().clear();
				fBNetwork.getDataConnections().clear();
			}
		}

	}

	public class FBDeleteEventsAndVarsCommand extends FBCommand {

		public FBDeleteEventsAndVarsCommand(String label,
				de.cau.cs.kieler.cakefeed.FB fB) {
			super(label, fB);
		}

		public void execute() {
			if (!(functionBlock.getInputEvents().isEmpty())) {
				functionBlock.getInputEvents().clear();
			}
			if (!(functionBlock.getOutputEvents().isEmpty())) {
				functionBlock.getOutputEvents().clear();
			}
			if (!(functionBlock.getInputVars().isEmpty())) {
				functionBlock.getInputVars().clear();
			}
			if (!(functionBlock.getOutputVars().isEmpty())) {
				functionBlock.getOutputVars().clear();
			}
		}
	}

	public class FBAdaptEventsAndVarsCommand extends FBCommand {

		protected FBType functionBlockType;

		public FBAdaptEventsAndVarsCommand(String label,
				de.cau.cs.kieler.cakefeed.FB fB) {
			super(label, fB);
		}

		public FBAdaptEventsAndVarsCommand(String label,
				de.cau.cs.kieler.cakefeed.FB fB, FBType fBType) {
			super(label, fB);
			functionBlockType = fBType;
		}

		public void execute() {
			EList<IFInputEvent> fBTypeInputEvents = functionBlockType
					.getInputEvents();
			EList<IFOutputEvent> fBTypeOutputEvents = functionBlockType
					.getOutputEvents();
			EList<IFInputVar> fBTypeInputVars = functionBlockType
					.getInputVars();
			EList<IFOutputVar> fBTypeOutputVars = functionBlockType
					.getOutputVars();

			EList<FBInputEvent> fBInputEvents = functionBlock.getInputEvents();
			EList<FBOutputEvent> fBOutputEvents = functionBlock
					.getOutputEvents();
			EList<FBInputVar> fBInputVars = functionBlock.getInputVars();
			EList<FBOutputVar> fBOutputVars = functionBlock.getOutputVars();

			if ((fBTypeInputEvents.size() == fBInputEvents.size())
					&& (fBTypeOutputEvents.size() == fBOutputEvents.size())
					&& (fBTypeInputVars.size() == fBInputVars.size())
					&& (fBTypeOutputVars.size() == fBOutputVars.size())) {
				for (int i = 0; i < fBTypeInputEvents.size(); i++) {
					((FBInputEvent) (fBInputEvents.get(i)))
							.setType(((IFInputEvent) (fBTypeInputEvents.get(i)))
									.getType());
					((FBInputEvent) (fBInputEvents.get(i)))
							.setName(((IFInputEvent) (fBTypeInputEvents.get(i)))
									.getName());
					((FBInputEvent) (fBInputEvents.get(i)))
							.setComment(((IFInputEvent) (fBTypeInputEvents
									.get(i))).getComment());
				}
				for (int i = 0; i < fBTypeOutputEvents.size(); i++) {
					((FBOutputEvent) (fBOutputEvents.get(i)))
							.setType(((IFOutputEvent) (fBTypeOutputEvents
									.get(i))).getType());
					((FBOutputEvent) (fBOutputEvents.get(i)))
							.setName(((IFOutputEvent) (fBTypeOutputEvents
									.get(i))).getName());
					((FBOutputEvent) (fBOutputEvents.get(i)))
							.setComment(((IFOutputEvent) (fBTypeOutputEvents
									.get(i))).getComment());
				}
				for (int i = 0; i < fBTypeInputVars.size(); i++) {
					((FBInputVar) (fBInputVars.get(i)))
							.setType(((IFInputVar) (fBTypeInputVars.get(i)))
									.getType());
					((FBInputVar) (fBInputVars.get(i)))
							.setName(((IFInputVar) (fBTypeInputVars.get(i)))
									.getName());
					((FBInputVar) (fBInputVars.get(i)))
							.setComment(((IFInputVar) (fBTypeInputVars.get(i)))
									.getComment());
					((FBInputVar) (fBInputVars.get(i)))
							.setInitialValue(((IFInputVar) (fBTypeInputVars
									.get(i))).getInitialValue());
					((FBInputVar) (fBInputVars.get(i)))
							.setArraySize(((IFInputVar) (fBTypeInputVars.get(i)))
									.getArraySize());
				}
				for (int i = 0; i < fBTypeOutputVars.size(); i++) {
					((FBOutputVar) (fBOutputVars.get(i)))
							.setType(((IFOutputVar) (fBTypeOutputVars.get(i)))
									.getType());
					((FBOutputVar) (fBOutputVars.get(i)))
							.setName(((IFOutputVar) (fBTypeOutputVars.get(i)))
									.getName());
					((FBOutputVar) (fBOutputVars.get(i)))
							.setComment(((IFOutputVar) (fBTypeOutputVars.get(i)))
									.getComment());
					((FBOutputVar) (fBOutputVars.get(i)))
							.setInitialValue(((IFOutputVar) (fBTypeOutputVars
									.get(i))).getInitialValue());
					((FBOutputVar) (fBOutputVars.get(i)))
							.setArraySize(((IFOutputVar) (fBTypeOutputVars
									.get(i))).getArraySize());
				}
			}
		}
	}

	protected boolean getCtrl(EditPart editPart) {
		if ((editPart instanceof FBInputEventEditPart)
				|| (editPart instanceof FBOutputEventEditPart)) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean getInput(EditPart editPart) {
		if ((editPart instanceof FBInputEventEditPart)
				|| (editPart instanceof FBInputVarEditPart)) {
			return true;
		} else {
			return false;
		}
	}
}
