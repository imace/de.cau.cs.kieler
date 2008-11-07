package edu.unikiel.rtsys.kieler.kiml.ui.handlers;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.draw2d.Animation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import edu.unikiel.rtsys.kieler.kiml.layout.services.DiagramLayouters;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter;
import edu.unikiel.rtsys.kieler.kiml.layout.services.LayoutProviders;
import edu.unikiel.rtsys.kieler.kiml.ui.ContributionItemGroupAs;
import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;

/**
 * The handler which is responsible for the functions to group the selected
 * elements. At the moment, this covers the following functions:
 * <ul>
 * <li>...</li>
 * </ul>
 * 
 * @author ars
 * 
 */
public class GroupAsHandler extends AbstractHandler implements IHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {

		/*
		 * As this handler is activated from a menu, Emma needs to get the
		 * active menu selection. Just calling selection does not work when
		 * calling from within a view, for example. If called from a menu in the
		 * menu bar - not a context menu - Emma needs to use the
		 * currrentSelection.
		 */
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		if (selection == null)
			selection = HandlerUtil.getCurrentSelection(event);

		/*
		 * Filter out The correct GraphicalEditParts
		 */
		ArrayList<GraphicalEditPart> selectedShapeNodeEditParts = new ArrayList<GraphicalEditPart>();
		GraphicalEditPart selectedCompartmentEditPart = null;
		if (selection != null && selection instanceof IStructuredSelection) {
			for (Object element : ((IStructuredSelection) selection).toList()) {
				if (element instanceof ShapeNodeEditPart)
					selectedShapeNodeEditParts.add((ShapeNodeEditPart) element);
				else if (element instanceof CompartmentEditPart) {
					selectedCompartmentEditPart = (CompartmentEditPart) element;
					break;
				}
			}
		}

		/* if CompartmentEditPart, fetch parent */
		if (selectedCompartmentEditPart != null) {
			GraphicalEditPart gep = (GraphicalEditPart) selectedCompartmentEditPart
					.getParent();
			selectedShapeNodeEditParts.clear();
			selectedShapeNodeEditParts.add(gep);
		}

		String commandID = event.getCommand().getId();
		// the parameter provided holds the layouterName
		String layouterName = event
				.getParameter(ContributionItemGroupAs.PARAM_LAYOUTER_NAME);
		LAYOUTER_INFO layouterInfo = LayoutProviders.getInstance()
				.getLayouterInfoForLayouterName(layouterName);
		LAYOUT_TYPE layoutType = LAYOUT_TYPE.DEFAULT;
		layoutType = layouterInfo.getLayoutType();
		String groupID = "";

		// just another sanity check if the right commandID
		if (commandID
				.equals("edu.unikiel.rtsys.kieler.kiml.ui.command.groupAs")) {

			groupID = KimlGMFLayoutHintHelper
					.generateLayoutGroupID(selectedShapeNodeEditParts);
			/*
			 * if just one selected, assume it was some kind of compartment and
			 * apply grouping on sub elements
			 */
			if (selectedShapeNodeEditParts.size() == 1) {

				KimlGMFLayoutHintHelper.setChildrenLayoutHint(
						(ShapeNodeEditPart) selectedShapeNodeEditParts.get(0),
						groupID, layoutType, layouterName);
			}
			/* more selected, apply grouping information to selected elements */
			else if (selectedShapeNodeEditParts.size() > 1) {

				KimlGMFLayoutHintHelper.setLayoutHint(
						selectedShapeNodeEditParts, groupID, layoutType,
						layouterName);
			}

			IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
			String editorId = editorPart.getEditorSite().getId();
			KimlAbstractLayouter diagramLayouter = DiagramLayouters
					.getInstance().getDiagramLayouter(editorId);
			Animation.markBegin();
			diagramLayouter.layout(editorPart);
			Animation.run(700);
		}
		return null;
	}

}
