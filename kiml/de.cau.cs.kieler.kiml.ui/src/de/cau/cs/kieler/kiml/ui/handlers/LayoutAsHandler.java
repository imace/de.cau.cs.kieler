/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui.handlers;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import de.cau.cs.kieler.kiml.layout.options.LayoutType;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider;
import de.cau.cs.kieler.kiml.layout.services.KimlLayoutServices;
import de.cau.cs.kieler.kiml.ui.ContributionItemLayoutAs;
import de.cau.cs.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;
import de.cau.cs.kieler.kiml.ui.layout.DiagramLayouter;

/**
 * The handler which is responsible to annotate the selected element with the
 * information how to lay out its sub elements and to trigger this.
 * <p/>
 * The layout process itself is also triggered to reflect the changes in the
 * diagram. Handler is called when executing a command, which is set in the
 * plugin.xml file. Animation is enabled.
 * <p/>
 * Due to the semantics of compartments, which are EditParts inside their
 * parents and act just as an intermediate layer to hold children, special
 * processing must be done when selecting those EditParts.
 * <p>
 * So if a compartment was selecting during the call to this handler, the parent
 * of the compartment is fetched and the layout information is attached to the
 * parent. This complies with the semantics expected by the
 * {@link KimlAbstractLayouter}s, as for example the
 * {@link KimlGenericDiagramLayouter}.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Spönemann</a>
 * @see LayoutAsHandler
 * @see ContributionItemLayoutAs
 */
public class LayoutAsHandler extends AbstractHandler implements IHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands
	 * .ExecutionEvent)
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
		ArrayList<GraphicalEditPart> selectedGraphicalEditParts = new ArrayList<GraphicalEditPart>();
		GraphicalEditPart selectedCompartmentEditPart = null;
		if (selection != null && selection instanceof IStructuredSelection) {
			for (Object element : ((IStructuredSelection) selection).toList()) {
				if (element instanceof ShapeNodeEditPart)
					selectedGraphicalEditParts.add((ShapeNodeEditPart) element);
				else if (element instanceof DiagramEditPart) {
					selectedGraphicalEditParts.add((DiagramEditPart) element);
				} else if (element instanceof CompartmentEditPart) {
					selectedCompartmentEditPart = (CompartmentEditPart) element;
					break;
				}
			}
		}

		/*
		 * If CompartmentEditPart, fetch parent. This must be done if clicking
		 * on an EditPart which may contain other EditParts. If selected such an
		 * EditPart, the actual selection in just the therein contained
		 * CompartmentEditPart. But the semantic equivalent is the parent
		 * thereof, an EditPart, so fetch this.
		 */
		if (selectedCompartmentEditPart != null) {
			GraphicalEditPart gep = (GraphicalEditPart) selectedCompartmentEditPart
					.getParent();
			selectedGraphicalEditParts.clear();
			selectedGraphicalEditParts.add(gep);
		}

		String commandID = event.getCommand().getId();
		/* the parameter provided holds the layouterName */
		String layouterName = event
				.getParameter(ContributionItemLayoutAs.PARAM_LAYOUTER_NAME);
		AbstractLayoutProvider layouter = KimlLayoutServices.getInstance()
				.getLayoutProvider(layouterName);
		LayoutType layoutType = layouter.getType();

		/* just another sanity check if the right commandID */
		if (commandID.equals("de.cau.cs.kieler.kiml.ui.command.layoutAs")) {

			IEditorPart editorPart = HandlerUtil.getActiveEditor(event);

			/* group all elements contained in selected ones */
			for (Object shapeNodeEditPart : selectedGraphicalEditParts) {
				KimlGMFLayoutHintHelper.setContainedElementsLayoutHint(
						(GraphicalEditPart) shapeNodeEditPart, layoutType,
						layouterName);
			}

			/*
			 * now use the new grouping/layout information and re-layout the
			 * whole diagram
			 */
			DiagramLayouter.layout(editorPart, true, true);
		}
		return null;
	}
}
