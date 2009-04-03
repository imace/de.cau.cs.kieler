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
package de.cau.cs.kieler.kiml.viewer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.layout.services.ILayoutListener;
import de.cau.cs.kieler.kiml.viewer.views.ExecutionView;
import de.cau.cs.kieler.kiml.viewer.views.LayoutGraphView;

/**
 * Layout listener implementation that displays the layout graphs in
 * a view.
 * 
 * @author msp
 */
public class ViewLayoutListener implements ILayoutListener {

	/** the currently open layout graph view */
	private LayoutGraphView layoutGraphView;
	/** the currently open execution view */
	private ExecutionView executionView;
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.ILayoutListener#layoutRequested(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph)
	 */
	public void layoutRequested(KLayoutGraph layoutGraph) {
		findViews();
		if (layoutGraphView != null) {
			//layoutGraphView.setLayoutGraph(LayoutGraphCloner
			//		.cloneLayoutGraph(layoutGraph), false);
			layoutGraphView.setLayoutGraph(this.cloneKLayoutGraph(layoutGraph),LayoutGraphView.PRE);
			// the last post-layout graph is deleted to avoid inconsistent graphs
			layoutGraphView.setLayoutGraph(null, LayoutGraphView.POST);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.cau.cs.kieler.kiml.layout.services.ILayoutListener#layoutPerformed(de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph, de.cau.cs.kieler.core.alg.IKielerProgressMonitor)
	 */
	public void layoutPerformed(KLayoutGraph layoutGraph,
			IKielerProgressMonitor monitor) {
		findViews();
		if (layoutGraphView != null) {
			//layoutGraphView.setLayoutGraph(LayoutGraphCloner
			//		.cloneLayoutGraph(layoutGraph), true);
			layoutGraphView.setLayoutGraph(this.cloneKLayoutGraph(layoutGraph),LayoutGraphView.POST);
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
	
	private KLayoutGraph cloneKLayoutGraph(KLayoutGraph input){
		EObject result = EcoreUtil.copy(input);
		return (KLayoutGraph) result;
	}

}
