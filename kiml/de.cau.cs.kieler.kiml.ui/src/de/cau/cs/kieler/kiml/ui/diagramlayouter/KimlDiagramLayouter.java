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
package de.cau.cs.kieler.kiml.ui.diagramlayouter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Animation;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.core.ui.KielerProgressMonitor;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayouterEngine;
import de.cau.cs.kieler.kiml.layout.services.KimlLayoutServices;
import de.cau.cs.kieler.kiml.layout.services.RecursiveGroupLayouterEngine;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;
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
public final class KimlDiagramLayouter {

	/** static List of Error Messages, such that they can be 
	 * created from within other threads and handled later on from another thread.
	 */
	static List<IStatus> stati = new ArrayList<IStatus>();;
	
	/** duration of animation for diagram layout */
	// TODO export duration of animation (e.g. make it user definable)
	private final static int ANIMATION_TIME = 1000;
	
	/**
	 * The wrapper method to get a layout for a diagram. Performs several steps.
	 * 
	 * @param target
	 *            The object which should be laid out. Is typically an
	 *            IEditorPart or a StructuredSelection of EditParts
	 * @param animate
	 *            If true, animation will be used for diagram layout
	 * @param createJob
	 *            If true, diagram layout will be performed in a separate job
	 */
	public static void layout(Object target, boolean animate,
			boolean createJob) {
		// fetches editor id
		String editorID = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor().getEditorSite().getId();

		// uses standard layout function with active editor and one run
		layout(target, editorID, animate, createJob, 1);
	}

	/**
	 * The wrapper method to get a layout for a diagram. Performs several steps.
	 * 
	 * @param target
	 *            The object which should be laid out. Is typically an
	 *            IEditorPart or a StructuredSelection of EditParts
	 * @param animate
	 *            If true, animation will be used for diagram layout
	 * @param createJob
	 *            If true, diagram layout will be performed in a separate job
	 * @param runs
	 *            Number of runs to perform
	 */
	public static void layout(Object target, boolean animate,
			boolean createJob, int runs) {
		// fetches editor id
		String editorID = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor().getEditorSite().getId();

		// uses standard layout function with active editor
		layout(target, editorID, animate, createJob, runs);
	}

	/**
	 * The wrapper method to get a layout for a diagram. Performs several steps.
	 * 
	 * @param target
	 *            The object which should be laid out. Is typically an
	 *            IEditorPart or a StructuredSelection of EditParts
	 * @param editorID
	 *            The ID of the editor for the diagram/target to be laid out
	 * @param animate
	 *            If true, animation will be used for diagram layout
	 * @param createJob
	 *            If true, diagram layout will be performed in a separate job
	 */
	public static void layout(Object target, String editorID,
			boolean animate, boolean createJob) {
		// uses standard layout function with provided editor
		layout(target, editorID, animate, createJob, 1);
	}

	/**
	 * The wrapper method to get a layout for a diagram. Performs several steps.
	 * 
	 * @param target
	 *            The object which should be laid out. Is typically an
	 *            IEditorPart or a StructuredSelection of EditParts
	 * @param editorID
	 *            The ID of the editor for the diagram/target to be laid out
	 * @param animate
	 *            If true, animation will be used for diagram layout
	 * @param createJob
	 *            If true, diagram layout will be performed in a separate job
	 * @param runs
	 *            Number of times the layout should be applied (workaround)
	 */
	public static void layout(final Object target, final String editorID,
			final boolean animate, boolean createJob, final int runs) {
// FIXME performing layout in a job does not work properly
//		if (createJob) {
//			Job layoutJob = new Job("Diagram layout") {
//				protected IStatus run(IProgressMonitor monitor) {
//					IStatus status = layout(target, editorID, animate, runs,
//							new KielerProgressMonitor(monitor));
//					try {
//						if (animate) {
//							IProgressService progressService = PlatformUI
//									.getWorkbench().getProgressService();
//							progressService.runInUI(progressService,
//									new IRunnableWithProgress() {
//								public void run(IProgressMonitor monitor) {
//									Animation.run(ANIMATION_TIME);
//								}
//							}, this.getRule());
//						}
//					} catch (Exception exception) {
//						Status logStatus = new Status(IStatus.ERROR, KimlUiPlugin.PLUGIN_ID,
//								"Could not run animation thread.", exception);
//						StatusManager.getManager().handle(logStatus, StatusManager.LOG);
//					}
//					if (status == null)
//						return new Status(IStatus.INFO, KimlUiPlugin.PLUGIN_ID,
//									0, "OK", null);
//					else
//						return status;
//				}
//			};
//			IProgressMonitor monitor = Job.getJobManager().createProgressGroup();
//			layoutJob.setProgressGroup(monitor, 100);
//			layoutJob.setPriority(Job.INTERACTIVE);
//			layoutJob.setUser(true);
//			layoutJob.schedule();
//		}
//		else {
			try {
				PlatformUI.getWorkbench().getProgressService().run(false, false,
						new IRunnableWithProgress() {
					public void run(IProgressMonitor monitor) {
						// perform layout and add the result as a status to the 
						// static status list such it can be handled from the original
						// thread below.
						IStatus status = layout(target, editorID, animate, runs,
								new KielerProgressMonitor(monitor));
						if (status != null)
							KimlDiagramLayouter.stati.add(status);
					}
				});
				if (animate)
					Animation.run(ANIMATION_TIME);
			}
			catch (Exception exception) {
				Status status = new Status(IStatus.ERROR, KimlUiPlugin.PLUGIN_ID,
						"Failed to perform diagram layout.", exception);
				StatusManager.getManager().handle(status, StatusManager.SHOW);
				StatusManager.getManager().handle(status, StatusManager.LOG);
			}
			// handle errors from the Progress monitor thread
			if (stati != null && !stati.isEmpty()) {
				for (IStatus status : stati) { 
					StatusManager.getManager().handle(status, StatusManager.SHOW);
					StatusManager.getManager().handle(status, StatusManager.LOG);
				}
				stati.clear();
			}
				
//		}
	}

	
	/**
	 * The wrapper method to get a layout for a diagram. Performs several steps.
	 * 
	 * @param target
	 *            The object which should be laid out. Is typically an
	 *            IEditorPart or a StructuredSelection of EditParts
	 * @param editorID
	 *            The ID of the editor for the diagram/target to be laid out
	 * @param animate
	 *            If true, animation will be used for diagram layout
	 * @param runs
	 *            Number of times the layout should be applied (workaround)
	 * @param progressMonitor monitor used to keep track of layout progress
	 * @return a status if diagram layout failed
	 */
	private static IStatus layout(Object target, String editorID, boolean animate,
			int runs, KielerProgressMonitor progressMonitor) {
		AbstractLayouterEngine layoutEngine = null;
		KimlLayoutInformation layoutInformation = null;
		try {
			progressMonitor.begin("Diagram layout", 100);
			
			// fetches layout graph builder for the provided editor
			KimlAbstractLayoutGraphBuilder layoutGraphBuilder = LayoutGraphBuilders
					.getInstance().getLayoutGraphBuilder(editorID);

			// transforms the diagram into the KLayoutGraph and also use the
			// mappings
			layoutInformation = layoutGraphBuilder.buildLayoutGraph(target);
			progressMonitor.worked(5);

			// notifies layout listeners about the layout request
			KimlLayoutServices.getInstance().layoutRequested(
					layoutInformation.layoutGraph);

			// chooses the default layout engine
			layoutEngine = new RecursiveGroupLayouterEngine();

			// does the layout with the layout graph
			layoutEngine.layout(layoutInformation.layoutGraph,
					progressMonitor.subTask(90));

			// fetches layout graph applier for the provided editor
			KimlAbstractLayoutGraphApplier layoutGraphApplier = LayoutGraphAppliers
					.getInstance().getLayoutGraphAppliers(editorID);

			if (animate)
				Animation.markBegin();
			// and applies layout to model
			layoutGraphApplier.applyLayoutGraph(layoutInformation);

			/** WORKAROUND START **/
			// handle multiple layout runs, that is appliance of layout through
			// GEF commands, just the appliance is the layout is performed
			// multiple times, not the computation of the layout et al.
			int workaroundRuns = runsWorkaround();
			if (runs < workaroundRuns)
				runs = workaroundRuns;
			if (runs > 4)
				runs = 4; // should not need more than 4 in any case
			for (; runs > 1; runs--) {
				layoutInformation.layoutRootPart.getViewer().flush();
				layoutGraphApplier.applyLayoutGraph(layoutInformation);
			}
			/** WORKAROUND END **/
			
			progressMonitor.done();
			// notifies layout listeners about the performed layout
			KimlLayoutServices.getInstance().layoutPerformed(
					layoutInformation.layoutGraph, progressMonitor);
			return null;
			
		} catch (Throwable exception) {
			String message = "Failed to perform diagram layout.";
			if (layoutEngine != null
					&& layoutEngine.getLastLayoutProvider() != null)
				message += " ("
						+ layoutEngine.getLastLayoutProvider().getName() + ")";
			Status status = new Status(IStatus.ERROR,
					KimlUiPlugin.PLUGIN_ID, message, exception);
			return status;
		}
		finally {
			progressMonitor.done();
		}
	}

	/**
	 * Computes the number of layout runs necessary according to the currently
	 * active options.
	 * 
	 * @return The number of layout runs to perform depending on the options set
	 *         in the preference page
	 */
	private static int runsWorkaround() {
		boolean prefMultipleLayoutRuns = KimlUiPlugin
				.getDefault()
				.getPreferenceStore()
				.getBoolean(
						KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_MULTIPLE_LAYOUT_RUNS);
		boolean prefUseGMFLabelLocation = KimlUiPlugin
				.getDefault()
				.getPreferenceStore()
				.getBoolean(
						KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_USE_GMF_TO_LAYOUT_CONNECTION_LABELS);

		if (!prefMultipleLayoutRuns)
			return 1;
		else if (prefMultipleLayoutRuns && prefUseGMFLabelLocation)
			return 2;
		else
			return 3;
	}

}
