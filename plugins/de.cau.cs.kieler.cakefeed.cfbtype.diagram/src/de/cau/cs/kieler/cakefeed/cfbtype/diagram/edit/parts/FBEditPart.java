package de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
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
import org.eclipse.gmf.runtime.diagram.ui.requests.ChangeChildPropertyValueRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.cau.cs.kieler.cakefeed.FB;
import de.cau.cs.kieler.cakefeed.FBInputEvent;
import de.cau.cs.kieler.cakefeed.FBInputVar;
import de.cau.cs.kieler.cakefeed.FBOutputEvent;
import de.cau.cs.kieler.cakefeed.FBOutputVar;
import de.cau.cs.kieler.cakefeed.IFInputEvent;
import de.cau.cs.kieler.cakefeed.IFInputVar;
import de.cau.cs.kieler.cakefeed.IFOutputEvent;
import de.cau.cs.kieler.cakefeed.IFOutputVar;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies.FBItemSemanticEditPolicy;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.providers.CakefeedElementTypes;
import de.cau.cs.kieler.cakefeed.impl.BFBTypeImpl;
import de.cau.cs.kieler.cakefeed.impl.CFBTypeImpl;
import de.cau.cs.kieler.cakefeed.impl.CakefeedFactoryImpl;
import de.cau.cs.kieler.cakefeed.impl.CakefeedPackageImpl;

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
		return primaryShape = new RectangleFigure();
	}

	/**
	 * @generated
	 */
	public RectangleFigure getPrimaryShape() {
		return (RectangleFigure) primaryShape;
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
	 * @generated NOT
	 */
	// This method is called when properties of the FB have been changed
	protected void handleNotificationEvent(Notification notification) {
		if (notification != null) {
			Object feat = notification.getFeature();
			if ((feat != null) && (feat instanceof EReferenceImpl)) {
				EReferenceImpl ref = (EReferenceImpl)feat;
				String name = ref.getName();
				if ((name != null) && (name.equals("Type"))) {
					Object newValue = notification.getNewValue();
					if ((newValue != null)
						&& ((newValue instanceof CFBTypeImpl) 
							|| (newValue instanceof BFBTypeImpl))) {
						
						ShapeCompartmentEditPart compartment = null;
						List children = this.getChildren();
						for (Object c : children) {
							if (c instanceof ShapeCompartmentEditPart) {
								compartment = (ShapeCompartmentEditPart)c;
							}
						}
						
						EList inputEvents = null;
						EList outputEvents = null;
						EList inputVars = null;
						EList outputVars = null;
						
						if (newValue instanceof CFBTypeImpl) {
							CFBTypeImpl type = (CFBTypeImpl)newValue;
							inputEvents = type.getInputEvents();
							outputEvents = type.getOutputEvents();
							inputVars = type.getInputVars();
							outputVars = type.getOutputVars();
						}
						else {
							BFBTypeImpl type = (BFBTypeImpl)newValue;
							inputEvents = type.getInputEvents();
							outputEvents = type.getOutputEvents();
							inputVars = type.getInputVars();
							outputVars = type.getOutputVars();
						}
						
						// Delete old Events and Vars
						FB fB = (FB)((View)this.getModel()).getElement();
						EList[] oldLists = new EList[4];
						oldLists[0] = fB.getInputEvents();
						oldLists[1] = fB.getOutputEvents();
						oldLists[2] = fB.getInputVars();
						oldLists[3] = fB.getOutputVars();
						
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
						
						for (int i = 0; i < 4; i++) {
							EList<EObject> l = oldLists[i];
							for (EObject o : l) {
								//Request deleteRequest = null;
								//Command deleteCmd = compartment.getCommand(deleteRequest);
								//compartment.getDiagramEditDomain().getDiagramCommandStack().execute(deleteCmd);
							}
						}
						// End of Delete old Events and Vars
						
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
								}
								else if (o instanceof IFOutputEvent) {
									elementType = CakefeedElementTypes.FBOutputEvent_3018;
								}
								else if (o instanceof IFInputVar) {
									elementType = CakefeedElementTypes.FBInputVar_3019;
								}
								else if (o instanceof IFOutputVar) {
									elementType = CakefeedElementTypes.FBOutputVar_3020;
								}
								if ((compartment != null) && (elementType != null)) {
									CreateViewRequest createRequest = CreateViewRequestFactory.getCreateShapeRequest(elementType, this.getDiagramPreferencesHint());
									Command createCmd = compartment.getCommand(createRequest);
									compartment.getDiagramEditDomain().getDiagramCommandStack().execute(createCmd);
								}
							}
						}
					}
				}
			}
		}
	}

}
