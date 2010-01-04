package de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
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
import de.cau.cs.kieler.cakefeed.FBOutputEvent;
import de.cau.cs.kieler.cakefeed.FBOutputVar;
import de.cau.cs.kieler.cakefeed.FBType;
import de.cau.cs.kieler.cakefeed.IFInputEvent;
import de.cau.cs.kieler.cakefeed.IFInputVar;
import de.cau.cs.kieler.cakefeed.IFOutputEvent;
import de.cau.cs.kieler.cakefeed.IFOutputVar;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.providers.CakefeedElementTypes;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies.FBItemSemanticEditPolicy;
import de.cau.cs.kieler.cakefeed.impl.BFBTypeImpl;
import de.cau.cs.kieler.cakefeed.impl.CFBTypeImpl;
import de.cau.cs.kieler.cakefeed.impl.FBTypeImpl;

/**
 * @generated
 */
public class FBEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3016;

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
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new FBItemSemanticEditPolicy());
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
		FBFigureDescriptor figure = new FBFigureDescriptor();
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
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
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
	public class FBFigureDescriptor extends RectangleFigure {

		/**
		 * @generated
		 */
		public FBFigureDescriptor() {
			this.setFill(false);
			this.setOutline(false);
			this.setLineWidth(1);
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
				if ((name != null) && (name.equals("Type"))) {
					Object newValue = notification.getNewValue();
					if ((newValue != null)
							&& ((newValue instanceof CFBTypeImpl) || (newValue instanceof BFBTypeImpl))) {

						ShapeCompartmentEditPart compartment = null;
						List children = this.getChildren();
						for (Object c : children) {
							if (c instanceof ShapeCompartmentEditPart) {
								compartment = (ShapeCompartmentEditPart) c;
							}
						}

						if (compartment != null) {
							EList inputEvents = null;
							EList outputEvents = null;
							EList inputVars = null;
							EList outputVars = null;

							FBTypeImpl t = (FBTypeImpl) newValue;

							WrappingLabel typeNameLabel = null;
							for (Object o : compartment.getChildren()) {
								if (o instanceof WrappingLabel) {
									typeNameLabel = (WrappingLabel) o;
									typeNameLabel.setText(t.getName());
								}
							}

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

							// Delete old Events and Vars
							de.cau.cs.kieler.cakefeed.FB fB = (de.cau.cs.kieler.cakefeed.FB) ((View) this
									.getModel()).getElement();

							compartment.getDiagramEditDomain()
									.getDiagramCommandStack().execute(
											new FBDeleteEventsAndVarsCommand(
													"deleteEventsAndVariables",
													fB));

							/*EList[] oldLists = new EList[4];
							oldLists[0] = fB.getInputEvents();
							oldLists[1] = fB.getOutputEvents();
							oldLists[2] = fB.getInputVars();
							oldLists[3] = fB.getOutputVars();*/

							//--------new try
							/*
							EList<FBInputEvent> emptyFBIEList = new BasicEList<FBInputEvent>();
							EList<FBOutputEvent> emptyFBOEList = new BasicEList<FBOutputEvent>();
							EList<FBInputVar> emptyFBIVList = new BasicEList<FBInputVar>();
							EList<FBOutputVar> emptyFBOVList = new BasicEList<FBOutputVar>();
							
							ChangeChildPropertyValueRequest deleteFBIERequest = new ChangeChildPropertyValueRequest("", "", emptyFBIEList, "");
							ChangeChildPropertyValueRequest deleteFBOERequest = new ChangeChildPropertyValueRequest("", "", emptyFBOEList, "");
							ChangeChildPropertyValueRequest deleteFBIVRequest = new ChangeChildPropertyValueRequest("", "", emptyFBIVList, "");
							ChangeChildPropertyValueRequest deleteFBOVRequest = new ChangeChildPropertyValueRequest("", "", emptyFBOVList, "");
							 */
							//--------end of new try

							/*for (int i = 0; i < 4; i++) {
								EList<EObject> l = oldLists[i];
								for (EObject o : l) {
									//Request deleteRequest = null;
									//Command deleteCmd = compartment.getCommand(deleteRequest);
									compartment.getDiagramEditDomain().getDiagramCommandStack().execute(
											new Command("deleteEventsAndVariables") {
												protected void doExecute() {
													// delete o
													
												}
											});
								}
							}*/
							// End of Delete old Events and Vars

							if ((inputEvents != null) && (outputEvents != null)
									&& (inputVars != null)
									&& (outputVars != null)) {
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
											elementType = CakefeedElementTypes.FBInputEvent_3017;
										} else if (o instanceof IFOutputEvent) {
											elementType = CakefeedElementTypes.FBOutputEvent_3018;
										} else if (o instanceof IFInputVar) {
											elementType = CakefeedElementTypes.FBInputVar_3019;
										} else if (o instanceof IFOutputVar) {
											elementType = CakefeedElementTypes.FBOutputVar_3020;
										}
										if ((compartment != null)
												&& (elementType != null)) {
											CreateViewRequest createRequest = CreateViewRequestFactory
													.getCreateShapeRequest(
															elementType,
															this
																	.getDiagramPreferencesHint());
											Command createCmd = compartment
													.getCommand(createRequest);
											compartment.getDiagramEditDomain()
													.getDiagramCommandStack()
													.execute(createCmd);
										}
									}
								}
								// Adapt Events and Variables
								compartment
										.getDiagramEditDomain()
										.getDiagramCommandStack()
										.execute(
												new FBAdaptEventsAndVarsCommand(
														"adaptEventsAndVariables",
														fB, t));
							}
						}
					}
				}
			}
		}
	}

	public class FBCommand extends Command {

		protected de.cau.cs.kieler.cakefeed.FB functionBlock;

		public FBCommand(String label, de.cau.cs.kieler.cakefeed.FB fB) {
			super(label);
			functionBlock = fB;
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
}
