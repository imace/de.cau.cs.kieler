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

import de.cau.cs.kieler.kiml.layout.services.KimlAbstractLayouterEngine;
import de.cau.cs.kieler.kiml.layout.services.KimlLayoutServices;
import de.cau.cs.kieler.kiml.layout.services.KimlRecursiveGroupLayouterEngine;
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

	/**
	 * The wrapper method to get a layout for a diagram. Performs several steps.
	 * 
	 * @param target
	 *            The object which should be laid out. Is typically an
	 *            IEditorPart or a StructuredSelection of EditParts
	 */
	public static void layout(Object target) {
		// fetches editor id
		String editorID = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor().getEditorSite().getId();

		// uses standard layout function with active editor and one run
		layout(target, editorID, 1);
	}

	/**
	 * The wrapper method to get a layout for a diagram. Performs several steps.
	 * 
	 * @param target
	 *            The object which should be laid out. Is typically an
	 *            IEditorPart or a StructuredSelection of EditParts
	 * @param runs
	 *            Number of runs to perform
	 */
	public static void layout(Object target, int runs) {
		// fetches editor id
		String editorID = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor().getEditorSite().getId();

		// uses standard layout function with active editor
		layout(target, editorID, runs);
	}

	/**
	 * The wrapper method to get a layout for a diagram. Performs several steps.
	 * 
	 * @param target
	 *            The object which should be laid out. Is typically an
	 *            IEditorPart or a StructuredSelection of EditParts
	 * @param editorID
	 *            The ID of the editor for the diagram/target to be laid out
	 */
	public static void layout(Object target, String editorID) {
		// uses standard layout function with provided editor
		layout(target, editorID, 1);
	}

	/**
	 * The wrapper method to get a layout for a diagram. Performs several steps.
	 * 
	 * @param target
	 *            The object which should be laid out. Is typically an
	 *            IEditorPart or a StructuredSelection of EditParts
	 * @param editorID
	 *            The ID of the editor for the diagram/target to be laid out
	 * @param runs
	 *            Number of times the layout should be applied (workaround).
	 */
	public static void layout(Object target, String editorID, int runs) {
		KimlAbstractLayouterEngine layoutEngine = null;
		try {
			// fetches layout graph builder for the provided editor
			KimlAbstractLayoutGraphBuilder layoutGraphBuilder = LayoutGraphBuilders
					.getInstance().getLayoutGraphBuilder(editorID);

			// transforms the diagram into the KLayoutGraph and also use the
			// mappings
			KimlLayoutInformation layoutInformation = layoutGraphBuilder
					.buildLayoutGraph(target);

			// notifies layout listeners about the layout request
			KimlLayoutServices.getInstance().layoutRequested(
					layoutInformation.layoutGraph);

			// chooses the default layout engine
			layoutEngine = new KimlRecursiveGroupLayouterEngine();

			// does the layout with the layout graph
			layoutEngine.layout(layoutInformation.layoutGraph);

			// notifies layout listeners about the performed layout
			KimlLayoutServices.getInstance().layoutPerformed(
					layoutInformation.layoutGraph);

			// fetches layout graph applier for the provided editor
			KimlAbstractLayoutGraphApplier layoutGraphApplier = LayoutGraphAppliers
					.getInstance().getLayoutGraphAppliers(editorID);

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

		} catch (Throwable exception) {
			String message = "Failed to perform diagram layout.";
			if (layoutEngine != null
					&& layoutEngine.getLastLayoutProvider() != null)
				message += " ("
						+ layoutEngine.getLastLayoutProvider()
								.getLayouterInfo().getLayouterName() + ")";
			Status status = new Status(IStatus.ERROR,
					KimlUiPlugin.PLUGIN_ID, message, exception);
			StatusManager.getManager().handle(status, StatusManager.SHOW);
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
