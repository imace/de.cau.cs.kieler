/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui.layout;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Animation;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.core.ui.KielerProgressMonitor;
import de.cau.cs.kieler.kiml.layout.services.LayoutServices;
import de.cau.cs.kieler.kiml.layout.services.RecursiveLayouterEngine;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;

/**
 * Convenience class with just one static method to perform all the necessary
 * steps to lay out a diagram. A workaround is implemented to get a sound layout
 * for the connections and the labels of them. This is done by adding additional
 * appliances of the layout. The workaround is triggered when 'Multiple layout
 * runs' is enabled in the main 'Diagram Layouters' preference page of KIML. If
 * the option is set to use GMF to position the connection labels (same
 * preference page), one additional layout run is omitted.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * 
 */
public final class DiagramLayouter {

	/** static List of Error Messages, such that they can be 
	 * created from within other threads and handled later on from another thread.
	 */
	private static List<IStatus> stati = new LinkedList<IStatus>();
	/** the layouter engine used to layout diagrams */
    private static RecursiveLayouterEngine layouterEngine = new RecursiveLayouterEngine();
	
	/** duration of animation for diagram layout */
	// TODO export duration of animation (e.g. make it user definable)
	private final static int ANIMATION_TIME = 1000;
	
	/**
	 * Performs layout for a diagram.
	 * 
	 * @param target
	 *            The object which should be laid out. Is typically an
	 *            IEditorPart or a StructuredSelection of EditParts
	 * @param editorID
	 *            The ID of the editor for the diagram/target to be laid out
	 * @param animate
	 *            If true, animation will be used for diagram layout
	 */
	public static void layout(final Object target, final String editorID,
			final boolean animate) {
		try {
			PlatformUI.getWorkbench().getProgressService().run(false, false,
					new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) {
					// perform layout and add the result as a status to the 
					// static status list such it can be handled from the original
					// thread below.
					IStatus status = layout(target, editorID, animate,
							new KielerProgressMonitor(monitor));
					if (status != null)
						DiagramLayouter.stati.add(status);
				}
			});
			if (animate)
				Animation.run(ANIMATION_TIME);
		}
		catch (Exception exception) {
		    stati.add(new Status(IStatus.ERROR, KimlUiPlugin.PLUGIN_ID,
					"Failed to perform diagram layout.", exception));
		}
		// handle errors from the diagram layout thread
		if (!stati.isEmpty()) {
			for (IStatus status : stati) { 
				StatusManager.getManager().handle(status, StatusManager.SHOW);
				StatusManager.getManager().handle(status, StatusManager.LOG);
			}
			stati.clear();
		}
	}

	
	/**
	 * Performs layout for a diagram.
	 * 
	 * @param target
	 *            The object which should be laid out. Is typically an
	 *            IEditorPart or a StructuredSelection of EditParts
	 * @param editorID
	 *            The ID of the editor for the diagram/target to be laid out
	 * @param animate
	 *            If true, animation will be used for diagram layout
	 * @param progressMonitor monitor used to keep track of layout progress
	 * @return a status if diagram layout failed
	 */
	private static IStatus layout(Object target, String editorID, boolean animate,
			KielerProgressMonitor progressMonitor) {
		KimlLayoutInformation layoutInformation = null;
		try {
			progressMonitor.begin("Diagram layout", 100);
			
			// fetches layout graph builder for the provided editor
			AbstractLayoutGraphBuilder layoutGraphBuilder = new GenericLayoutGraphBuilder();

			// transforms the diagram into the KLayoutGraph and also use the
			// mappings
			layoutInformation = layoutGraphBuilder.buildLayoutGraph(target);
			progressMonitor.worked(5);

			// notifies layout listeners about the layout request
			LayoutServices.INSTANCE.layoutRequested(
					layoutInformation.layoutGraph);

			// does the layout with the layout graph
			layouterEngine.layout(layoutInformation.layoutGraph,
					progressMonitor.subTask(90));

			// fetches layout graph applier for the provided editor
			AbstractLayoutGraphApplier layoutGraphApplier = new GenericSingleCommandLayoutGraphApplier();

			if (animate)
				Animation.markBegin();
			// and applies layout to model
			layoutGraphApplier.applyLayoutGraph(layoutInformation);

			progressMonitor.done();
			// notifies layout listeners about the performed layout
			LayoutServices.INSTANCE.layoutPerformed(
					layoutInformation.layoutGraph, progressMonitor);
			return null;
			
		} catch (Throwable exception) {
			String message = "Failed to perform diagram layout.";
			if (layouterEngine != null
					&& layouterEngine.getLastLayoutProvider() != null)
				message += " ("	+ layouterEngine.getLastLayoutProvider()
						.getClass().getSimpleName() + ")";
			Status status = new Status(IStatus.ERROR,
					KimlUiPlugin.PLUGIN_ID, message, exception);
			return status;
		}
		finally {
			progressMonitor.done();
		}
	}
	
}
