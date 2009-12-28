package de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies.CFBTypeCFBTypeCompartmentCanonicalEditPolicy;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.policies.CFBTypeCFBTypeCompartmentItemSemanticEditPolicy;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.Messages;

/**
 * @generated
 */
public class CFBTypeCFBTypeCompartmentEditPart extends ShapeCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7001;

	/**
	 * @generated
	 */
	public CFBTypeCFBTypeCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	public String getCompartmentName() {
		return Messages.CFBTypeCFBTypeCompartmentEditPart_title;
	}

	/**
	 * @generated
	 */
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super
				.createFigure();
		result.setTitleVisibility(false);

		result.setBorder(null);

		RoundedRectangle ctrlRect = new RoundedRectangle();
		ctrlRect.setForegroundColor(ColorConstants.black);
		ctrlRect.setBackgroundColor(ColorConstants.lightGray);
		result.getContentPane().add(ctrlRect);
		RoundedRectangle dataRect = new RoundedRectangle();
		dataRect.setForegroundColor(ColorConstants.black);
		dataRect.setBackgroundColor(ColorConstants.lightGray);
		result.getContentPane().add(dataRect);
		RectangleFigure typeRect = new RectangleFigure();
		typeRect.setForegroundColor(ColorConstants.lightGray);
		typeRect.setBackgroundColor(ColorConstants.lightGray);
		result.getContentPane().add(typeRect);
		for (int i = 0; i < 2; i++) {
			RectangleFigure blackRect = new RectangleFigure();
			blackRect.setForegroundColor(ColorConstants.black);
			blackRect.setBackgroundColor(ColorConstants.black);
			result.getContentPane().add(blackRect);
		}

		WrappingLabel typeName = new WrappingLabel();
		typeName.setForegroundColor(ColorConstants.black);
		result.getContentPane().add(typeName, 0);

		result.getContentPane().setLayoutManager(new FBCompartmentLayout());
		return result;
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new CFBTypeCFBTypeCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new CFBTypeCFBTypeCompartmentCanonicalEditPolicy());
	}

	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

	/**
	 * 
	 * @author schm
	 * 
	 * A layout for FBCompartments. The three decoration figures are laid out
	 * at a certain size and the ports are arranged on the sides.
	 * In addition, FBNetworks and Algorithms are laid out in the middle of the
	 * decoration figures. 
	 *
	 */
	@SuppressWarnings("unchecked")
	public class FBCompartmentLayout extends XYLayout {

		protected int fBWidth = 0;
		protected int fBHeight = 0;
		protected Boolean rectAssigned = false;
		protected Boolean lineAssigned = false;
		protected WrappingLabel typeNameLabel = null;
		protected RoundedRectangle ctrlRect = null;
		protected RoundedRectangle dataRect = null;
		protected RectangleFigure typeRect = null;
		protected RectangleFigure lineRect1 = null;
		protected RectangleFigure lineRect2 = null;
		protected List<IFInputEventEditPart.IFInputEventFigureDescriptor> inputEvents = new LinkedList<IFInputEventEditPart.IFInputEventFigureDescriptor>();
		protected List<IFOutputEventEditPart.IFOutputEventFigureDescriptor> outputEvents = new LinkedList<IFOutputEventEditPart.IFOutputEventFigureDescriptor>();
		protected List<IFInputVarEditPart.IFInputVarFigureDescriptor> inputVars = new LinkedList<IFInputVarEditPart.IFInputVarFigureDescriptor>();
		protected List<IFOutputVarEditPart.IFOutputVarFigureDescriptor> outputVars = new LinkedList<IFOutputVarEditPart.IFOutputVarFigureDescriptor>();

		public void layout(final IFigure parent) {
			if (!parent.isVisible()) {
				return;
			}

			// Search children for specific figures and store their references
			List<IFigure> children = parent.getChildren();
			for (IFigure c : children) {
				if (c instanceof WrappingLabel) {
					typeNameLabel = (WrappingLabel) c;
				} else if (c instanceof RoundedRectangle) {
					if (rectAssigned) {
						dataRect = (RoundedRectangle) c;
					} else {
						ctrlRect = (RoundedRectangle) c;
						rectAssigned = true;
					}
				} else if (c instanceof RectangleFigure) {
					if (((RectangleFigure) c).getForegroundColor().equals(
							ColorConstants.lightGray)) {
						typeRect = (RectangleFigure) c;
					} else if (lineAssigned) {
						lineRect2 = (RectangleFigure) c;
					} else {
						lineRect1 = (RectangleFigure) c;
						lineAssigned = true;
					}
				} else if (c instanceof IFInputEventEditPart.IFInputEventFigureDescriptor) {
					inputEvents
							.add((IFInputEventEditPart.IFInputEventFigureDescriptor) c);
				} else if (c instanceof IFOutputEventEditPart.IFOutputEventFigureDescriptor) {
					outputEvents
							.add((IFOutputEventEditPart.IFOutputEventFigureDescriptor) c);
				} else if (c instanceof IFInputVarEditPart.IFInputVarFigureDescriptor) {
					inputVars
							.add((IFInputVarEditPart.IFInputVarFigureDescriptor) c);
				} else if (c instanceof IFOutputVarEditPart.IFOutputVarFigureDescriptor) {
					outputVars
							.add((IFOutputVarEditPart.IFOutputVarFigureDescriptor) c);
				}
				/*else if (c instanceof FBDEditPart.FBDFigureDescriptor) {
					inputEvents.add((FBDEditPart.FBDFigureDescriptor)c);
				}
				else if (c instanceof STEditPart.STFigureDescriptor) {
					inputEvents.add((STEditPart.STFigureDescriptor)c);
				}
				else if (c instanceof LDEditPart.LDFigureDescriptor) {
					inputEvents.add((LDEditPart.LDFigureDescriptor)c);
				}
				else if (c instanceof OtherEditPart.OtherFigureDescriptor) {
					inputEvents.add((OtherEditPart.OtherFigureDescriptor)c);
				}*/
			}
			// Retrieve the needed information for the layout
			Rectangle clientArea = parent.getClientArea();
			fBWidth = clientArea.width;
			fBHeight = clientArea.height;

			// Lay out the figures
			Rectangle newBounds = new Rectangle();
			/*if (typeNameLabel != null) {
				int width = typeNameLabel.getPreferredSize().width;
				if (width > fBWidth) {
					newBounds.x = 0;
				}
				else {
					newBounds.x = (fBWidth - width)/2;
				}
				newBounds.y = 0;
				newBounds.width = width;
				newBounds.height = typeNameLabel.getPreferredSize().height;
				typeNameLabel.setBounds(newBounds);
			}*/
			if (ctrlRect != null) {
				newBounds.x = 0;
				newBounds.y = 0;
				newBounds.width = fBWidth;
				newBounds.height = calculateCtrlRectHeight();
				ctrlRect.setBounds(newBounds);
			}
			if (typeRect != null) {
				newBounds.x = 20;
				newBounds.y = ctrlRect.getBounds().height;
				newBounds.width = fBWidth - 40;
				newBounds.height = calculateTypeRectHeight();
				ctrlRect.setBounds(newBounds);
			}
			if (dataRect != null) {
				newBounds.x = 0;
				newBounds.y = ctrlRect.getBounds().height
						+ typeRect.getBounds().height;
				newBounds.width = fBWidth;
				newBounds.height = calculateDataRectHeight();
				dataRect.setBounds(newBounds);
			}
			if (lineRect1 != null) {
				newBounds.x = typeRect.getBounds().x;
				newBounds.y = typeRect.getBounds().y;
				newBounds.width = 1;
				newBounds.height = typeRect.getBounds().height;
				lineRect1.setBounds(newBounds);
			}
			if (lineRect2 != null) {
				newBounds.x = typeRect.getBounds().x
						+ typeRect.getBounds().width;
				newBounds.y = typeRect.getBounds().y;
				newBounds.width = 1;
				newBounds.height = typeRect.getBounds().height;
				lineRect2.setBounds(newBounds);
			}
			if (typeNameLabel != null) {
				int width = typeNameLabel.getPreferredSize().width;
				int typeRectHeight = typeRect.getBounds().height;
				if (width > fBWidth) {
					newBounds.x = typeRect.getBounds().x;
				} else {
					newBounds.x = (fBWidth - width) / 2;
				}
				int height = typeNameLabel.getPreferredSize().height;
				if (height > typeRectHeight) {
					newBounds.y = typeRect.getBounds().y;
				} else {
					newBounds.y = (typeRectHeight - height) / 2;
				}
				newBounds.width = width;
				newBounds.height = typeNameLabel.getPreferredSize().height;
				typeNameLabel.setBounds(newBounds);
			}
			int size = inputEvents.size();
			newBounds.x = 0;
			newBounds.y = 0;
			for (Figure ie : inputEvents) {
				newBounds.width = ie.getPreferredSize().width;
				newBounds.height = ie.getMinimumSize().height;
				ie.setBounds(newBounds);
				newBounds.y += ctrlRect.getBounds().width / size;
			}
			size = outputEvents.size();
			newBounds.y = 0;
			for (Figure oe : outputEvents) {
				int width = oe.getPreferredSize().width;
				if (width > fBWidth) {
					newBounds.x = 0;
				} else {
					newBounds.x = fBWidth - width;
				}
				newBounds.width = oe.getPreferredSize().width;
				newBounds.height = oe.getMinimumSize().height;
				oe.setBounds(newBounds);
				newBounds.y += ctrlRect.getBounds().width / size;
			}
			size = inputVars.size();
			newBounds.x = 0;
			newBounds.y = dataRect.getBounds().y;
			for (Figure iv : inputVars) {
				newBounds.width = iv.getPreferredSize().width;
				newBounds.height = iv.getMinimumSize().height;
				iv.setBounds(newBounds);
				newBounds.y += dataRect.getBounds().width / size;
			}
			size = outputVars.size();
			newBounds.y = dataRect.getBounds().y;
			for (Figure ov : outputVars) {
				int width = ov.getPreferredSize().width;
				if (width > fBWidth) {
					newBounds.x = 0;
				} else {
					newBounds.x = fBWidth - width;
				}
				newBounds.width = ov.getPreferredSize().width;
				newBounds.height = ov.getMinimumSize().height;
				ov.setBounds(newBounds);
				newBounds.y += dataRect.getBounds().width / size;
			}
		}

		private int calculateDataRectHeight() {
			int numberCtrl = getNumberCtrl();
			int numberData = getNumberData();
			return (fBHeight / (numberCtrl + numberData + 1)) * numberData;
		}

		private int getNumberData() {
			int numberData = inputVars.size();
			if (outputVars.size() > numberData) {
				numberData = outputVars.size();
			}
			if (numberData == 0) {
				return 1;
			}
			return numberData;
		}

		private int getNumberCtrl() {
			int numberCtrl = inputEvents.size();
			if (outputEvents.size() > numberCtrl) {
				numberCtrl = outputEvents.size();
			}
			if (numberCtrl == 0) {
				return 1;
			}
			return numberCtrl;
		}

		private int calculateTypeRectHeight() {
			int numberCtrl = getNumberCtrl();
			int numberData = getNumberData();
			return fBHeight / (numberCtrl + numberData + 1);
		}

		private int calculateCtrlRectHeight() {
			int numberCtrl = getNumberCtrl();
			int numberData = getNumberData();
			return (fBHeight / (numberCtrl + numberData + 1)) * numberCtrl;
		}

	}
}
