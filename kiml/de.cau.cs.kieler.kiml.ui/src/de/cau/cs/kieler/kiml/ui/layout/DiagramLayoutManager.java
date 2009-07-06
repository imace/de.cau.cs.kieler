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
import org.eclipse.gef.EditPart;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.ui.KielerProgressMonitor;
import de.cau.cs.kieler.kiml.layout.services.LayoutServices;
import de.cau.cs.kieler.kiml.layout.services.RecursiveLayouterEngine;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;

/**
 * 
 * 
 * @author msp
 */
public abstract class DiagramLayoutManager {
    
    // TODO export duration of animation (e.g. make it user definable)
    private final static int ANIMATION_TIME = 1000;

    /** list of registered diagram layout managers */
    private final static List<DiagramLayoutManager> managers = new LinkedList<DiagramLayoutManager>();

    /** the layouter engine used to layout diagrams */
    private RecursiveLayouterEngine layouterEngine = new RecursiveLayouterEngine();
	
	/**
	 * Registers the given diagram layout manager.
	 * 
	 * @param manager an instance of a diagram layout manager
	 */
	public static void registerManager(DiagramLayoutManager manager) {
	    managers.add(manager);
	}
	
	/**
	 * Performs layout on the given editor by choosing an appropriate
     * layout manager instance.
	 * 
     * @param editorPart the editor for which layout is performed, or {@code null} if
     *     the diagram is not part of an editor
     * @param editPart the parent edit part for which layout is performed, or
     *     {@code null} if the whole diagram shall be layouted
	 * @param animate if true, Draw2D animation is activated
	 */
	public final static void layout(IEditorPart editorPart, EditPart editPart,
	        boolean animate) {
	    for (DiagramLayoutManager manager : managers) {
	        if (manager.supports(editorPart) || manager.supports(editPart)) {
	            IStatus status = manager.doLayout(editorPart, editPart, animate);
	            if (status != null) {
	                StatusManager.getManager().handle(status, StatusManager.SHOW);
	                StatusManager.getManager().handle(status, StatusManager.LOG);
	            }
	            return;
	        }
	    }
	    throw new UnsupportedOperationException("No layout manager is available for "
	            + editorPart.getTitle() + ".");
	}
	
	/**
	 * Performs layout on the given editor or edit part using this layout manager.
	 * A progress bar indicating progress of the layout algorithm is shown to the user.
	 * 
	 * @param editorPart the editor for which layout is performed, or {@code null} if
     *     the diagram is not part of an editor
	 * @param editPart the parent edit part for which layout is performed, or
	 *     {@code null} if the whole diagram shall be layouted
	 * @param animate if true, Draw2D animation is activated
	 * @return a status indicating failure, or {@code null} if layout was successful
	 */
	public final IStatus doLayout(final IEditorPart editorPart, final EditPart editPart,
            final boolean animate) {
	    final LinkedList<IStatus> stati = new LinkedList<IStatus>();
		try {
			PlatformUI.getWorkbench().getProgressService().run(false, false,
					new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) {
					IStatus status = doLayout(editorPart, editPart, animate,
							new KielerProgressMonitor(monitor));
					if (status != null)
						stati.add(status);
				}
			});
			if (animate)
				Animation.run(ANIMATION_TIME);
		}
		catch (Exception exception) {
		    if (stati.isEmpty())
		        stati.add(new Status(IStatus.ERROR, KimlUiPlugin.PLUGIN_ID,
		                "Failed to perform diagram layout.", exception));
		}
		if (!stati.isEmpty())
		    return stati.getFirst();
		else return null;
	}

	/**
	 * Performs layout on the given editor or edit part using this layout manager
	 * and a specific progress monitor.
	 * 
	 * @param editorPart the editor for which layout is performed, or {@code null} if
     *     the diagram is not part of an editor
	 * @param editPart the parent edit part for which layout is performed, or
     *     {@code null} if the whole diagram shall be layouted
	 * @param animate if true, Draw2D animation is activated
	 * @param progressMonitor a progress monitor to which progress of the layout algorithm
	 *     is reported
	 * @return a status indicating failure, or {@code null} if layout was successful
	 */
	public final IStatus doLayout(IEditorPart editorPart, EditPart editPart,
            boolean animate, KielerProgressMonitor progressMonitor) {
		try {
			progressMonitor.begin("Diagram layout", 100);
			
			// transform the diagram into a KGraph instance
			KNode layoutGraph = buildLayoutGraph(editorPart, editPart);
			progressMonitor.worked(5);

			// notify layout listeners about the layout request
			LayoutServices.INSTANCE.layoutRequested(layoutGraph);

			// perform layout on the layout graph
			layouterEngine.layout(layoutGraph, progressMonitor.subTask(90));

			if (animate)
				Animation.markBegin();
			
			// apply layout to the model
			applyLayout();

			progressMonitor.done();
			// notify layout listeners about the performed layout
			LayoutServices.INSTANCE.layoutPerformed(layoutGraph, progressMonitor);
			return null;
			
		} catch (Throwable exception) {
		    progressMonitor.done();
			String message = "Failed to perform diagram layout.";
			if (layouterEngine != null
					&& layouterEngine.getLastLayoutProvider() != null)
				message += " ("	+ layouterEngine.getLastLayoutProvider()
						.getClass().getSimpleName() + ")";
			Status status = new Status(IStatus.ERROR,
					KimlUiPlugin.PLUGIN_ID, message, exception);
			return status;
		}
	}
	
	/**
	 * Determines whether this layout manager is able to perform layout for the
	 * given editor.
	 * 
	 * @param editorPart an editor part
	 * @return true if this layout manager supports the editor part
	 */
	protected abstract boolean supports(IEditorPart editorPart);
	
	/**
	 * Determines whether this layout manager is able to perform layout for
	 * the given edit part.
	 * 
	 * @param editPart an edit part
	 * @return true if this layout manager supports the edit part
	 */
	protected abstract boolean supports(EditPart editPart);
	
	/**
	 * Builds a KGraph instance for the given editor or selection.
	 * 
	 * @param editorPart the editor for which layout is performed, or {@code null} if
     *     the diagram is not part of an editor
	 * @param editPart the parent edit part for which layout is performed, or
     *     {@code null} if the whole diagram shall be layouted
	 * @return a layout graph instance
	 */
	protected abstract KNode buildLayoutGraph(IEditorPart editorPart, EditPart editPart);
	
	/**
	 * Applies all layout data from the last created KGraph instance to the original
	 * diagram. 
	 */
	protected abstract void applyLayout();
	
}
