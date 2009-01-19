/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.ui.handlers;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.draw2d.Animation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUTER_INFO;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.LAYOUT_TYPE;
import de.cau.cs.kieler.kiml.layout.services.DiagramLayouters;
import de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouter;
import de.cau.cs.kieler.kiml.layout.services.LayoutProviders;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;
import de.cau.cs.kieler.kiml.ui.ContributionItemLayoutAs;
import de.cau.cs.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;


/**
 * The handler which is responsible for the functions that concern grouping of
 * single elements within a compartment. Handler is called when executing
 * a command. This is set in the plugin.xml file. The commands can only be
 * issued through a menu, when the grouping of single elements is enabled. 
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see LayoutAsHandler
 * @see ContributionItemGroupFunctions
 * @see GroupFunctionHandler
 * @see KimlLayoutHintView
 * @deprecated This method was introduced to support grouping of single elements
 *             within one compartment. It should be moved/changed to a somehow
 *             better place and name and the implementation is about to change.
 *             Full support for laying out (and grouping) is given in
 *             {@link LayoutAsHandler}. Though this just works with <b>all</b>
 *             elements of a compartment as a whole, this is in most cases what
 *             you want.
 * 
 */
public class GroupAsHandler extends AbstractHandler implements IHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
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
				else if (element instanceof DiagramEditPart) {
					selectedShapeNodeEditParts
							.add((ShapeNodeEditPart) ((DiagramEditPart) element)
									.getChildren().get(0));
				} else if (element instanceof CompartmentEditPart) {
					selectedCompartmentEditPart = (CompartmentEditPart) element;
					break;
				}
			}
		}

		/*
		 * if CompartmentEditPart, fetch parent. This must be done if clicking
		 * on an EditPart which may contain other EditParts. If selected such an
		 * EditPart, the actual selection in just the therein contained
		 * CompartmentEditPart. But the semantic equivalent is the parent
		 * thereof, so fetch this.
		 */
		if (selectedCompartmentEditPart != null) {
			GraphicalEditPart gep = (GraphicalEditPart) selectedCompartmentEditPart
					.getParent();
			selectedShapeNodeEditParts.clear();
			selectedShapeNodeEditParts.add(gep);
		}

		String commandID = event.getCommand().getId();
		/* the parameter provided holds the layouterName */
		String layouterName = event
				.getParameter(ContributionItemLayoutAs.PARAM_LAYOUTER_NAME);
		LAYOUTER_INFO layouterInfo = LayoutProviders.getInstance()
				.getLayouterInfoForLayouterName(layouterName);
		LAYOUT_TYPE layoutType = layouterInfo.getLayoutType();
		String groupID = "";

		/* just another sanity check if the right commandID */
		if (commandID
				.equals("de.cau.cs.kieler.kiml.ui.command.groupAs")) {

			IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
			String editorId = editorPart.getEditorSite().getId();
			KimlAbstractLayouter diagramLayouter = DiagramLayouters
					.getInstance().getDiagramLayouter(editorId);

			/*
			 * Check if Emma wants to layout every single element, or if she
			 * wants to apply the layout to sub (or contained elements) of the
			 * one selected. This is an option of the DiagramLayouter, as this
			 * Class is responsible for the translation into the KLayoutGraph.
			 */
			if (Boolean
					.parseBoolean(diagramLayouter
							.getSettings()
							.get(
									KimlLayoutPreferenceConstants.PREF_GROUP_EVERY_SINGLE_ELEMENT))) {

				/* group every single element */
				groupID = KimlGMFLayoutHintHelper
						.generateLayoutGroupID(selectedShapeNodeEditParts);

				/* take care of the selection, .. */
				if (selectedShapeNodeEditParts.size() == 1) {
					/*
					 * just 1 selected, assume that Emma wants to select
					 * subelements
					 */
					KimlGMFLayoutHintHelper.setChildrenLayoutHint(
							(ShapeNodeEditPart) selectedShapeNodeEditParts
									.get(0), groupID, layoutType, layouterName);
				} else {
					/* more selected, group single elements */
					KimlGMFLayoutHintHelper.setLayoutHint(
							selectedShapeNodeEditParts, groupID, layoutType,
							layouterName);
				}

			} else {

				/* group all elements contained in selected ones */
				for (Object shapeNodeEditPart : selectedShapeNodeEditParts) {
					KimlGMFLayoutHintHelper.setContainedElementsLayoutHint(
							(ShapeNodeEditPart) shapeNodeEditPart, layoutType,
							layouterName);
				}
			}

			/*
			 * now use the new grouping/layout information and re-layout the
			 * whole diagram
			 */
			Animation.markBegin();
			diagramLayouter.layout(editorPart);
			Animation.run(700);
		}
		return null;
	}
}
