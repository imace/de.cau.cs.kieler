package de.cau.cs.kieler.kiml.viewer;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.layout.services.IKimlLayoutListener;
import de.cau.cs.kieler.kiml.layout.util.LayoutGraphCloner;
import de.cau.cs.kieler.kiml.viewer.views.ExecutionView;
import de.cau.cs.kieler.kiml.viewer.views.LayoutGraphView;


/**
 * Layout listener implementation that displays the layout graphs in
 * a view.
 * 
 * @author msp
 */
public class ViewLayoutListener implements IKimlLayoutListener {

	/** the currently open layout graph view */
	private LayoutGraphView layoutGraphView;
	/** the currently open execution view */
	private ExecutionView executionView;
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.IKimlLayoutListener#layoutRequested(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph)
	 */
	public void layoutRequested(KLayoutGraph layoutGraph) {
		findViews();
		if (layoutGraphView != null) {
			layoutGraphView.setLayoutGraph(LayoutGraphCloner
					.cloneLayoutGraph(layoutGraph), false);
			// the last post-layout graph is deleted to avoid inconsistent graphs
			layoutGraphView.setLayoutGraph(null, true);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.IKimlLayoutListener#layoutPerformed(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph, de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void layoutPerformed(KLayoutGraph layoutGraph,
			IKielerProgressMonitor monitor) {
		findViews();
		if (layoutGraphView != null) {
			layoutGraphView.setLayoutGraph(LayoutGraphCloner
					.cloneLayoutGraph(layoutGraph), true);
		}
		if (executionView != null) {
			executionView.addExecution(monitor);
		}
	}
	
	/**
	 * Tries to find the relevant currently open views.
	 */
	private void findViews() {
		layoutGraphView = null;
		executionView = null;
		
		IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWindow == null)
			return;
		
		IWorkbenchPage activePage = activeWindow.getActivePage();
		if (activePage == null)
			return;
		
		IViewPart viewPart = activePage.findView(LayoutGraphView.VIEW_ID);
		if (viewPart instanceof LayoutGraphView)
			layoutGraphView = (LayoutGraphView)viewPart;
		viewPart = activePage.findView(ExecutionView.VIEW_ID);
		if (viewPart instanceof ExecutionView)
			executionView = (ExecutionView)viewPart;
	}

}
