/*******************************************************************************
 * Copyright (c) 2009 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.ui.diagramlayouter;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.kiml.layout.KimlLayoutPlugin;
import de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouterEngine;
import de.cau.cs.kieler.kiml.layout.services.KimlRecursiveGroupLayouterEngine;
import de.cau.cs.kieler.kiml.layout.services.LayoutListeners;

/**
 * Convenience class with just one static method to perform all the necessary
 * steps to lay out a diagram.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * 
 */
public final class KimlDiagramLayouter {

	/**
	 * The wrapper method to get a layout for a diagram. Performs several
	 * steps.
	 * 
	 * @param target
	 *            The object which should be laid out. Is typically an
	 *            IEditorPart or a StructuredSelection of EditParts
	 */
	public static void layout(Object target) {
		try {
			// fetches editor id
			String editorID = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getActiveEditor().getEditorSite().getId();
	
			// fetches layout graph builder for the provided editor
			KimlAbstractLayoutGraphBuilder layoutGraphBuilder = LayoutGraphBuilders
					.getInstance().getLayoutGraphBuilder(editorID);
	
			// transforms the diagram into the KLayoutGraph and also use the mappings
			KimlLayoutInformation layoutInformation = layoutGraphBuilder
					.buildLayoutGraph(target);
	
			// notifies layout listeners about the layout request
			LayoutListeners.getInstance().layoutRequested(layoutInformation.layoutGraph);
	
			// chooses the default layout engine
			KimlAbstractLayouterEngine layoutEngine = new KimlRecursiveGroupLayouterEngine();
	
			// does the layout with the layout graph
			layoutEngine.layout(layoutInformation.layoutGraph);
	
			// notifies layout listeners about the performed layout
			LayoutListeners.getInstance().layoutPerformed(layoutInformation.layoutGraph);
	
			// fetches layout graph applier for the provided editor
			KimlAbstractLayoutGraphApplier layoutGraphApplier = LayoutGraphAppliers
					.getInstance().getLayoutGraphAppliers(editorID);
	
			// and applies layout to model
			layoutGraphApplier.applyLayoutGraph(layoutInformation);
		}
		catch (Throwable exception) {
            Status status = new Status(IStatus.ERROR, KimlLayoutPlugin.PLUGIN_ID,
                    "Failed to perform diagram layout.", exception);
            StatusManager.getManager().handle(status, StatusManager.SHOW);
        }
	}
}
