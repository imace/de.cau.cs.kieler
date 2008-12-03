package edu.unikiel.rtsys.kieler.kiml.viewer;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import edu.unikiel.rtsys.kieler.kiml.layout.services.IKimlLayoutListener;
import edu.unikiel.rtsys.kieler.kiml.layout.util.LayoutGraphCloner;
import edu.unikiel.rtsys.kieler.kiml.viewer.views.LayoutGraphView;

/**
 * Layout listener implementation that displays the layout graphs in
 * a view.
 * 
 * @author msp
 */
public class ViewLayoutListener implements IKimlLayoutListener {

	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.IKimlLayoutListener#layoutRequested(edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph)
	 */
	public void layoutRequested(KLayoutGraph layoutGraph) {
		LayoutGraphView view = getLayoutGraphView();
		if (view != null) {
			view.setLayoutGraph(LayoutGraphCloner.cloneLayoutGraph(layoutGraph), false);
			// the last post-layout graph is deleted to avoid inconsistent graphs
			view.setLayoutGraph(null, true);
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.services.IKimlLayoutListener#layoutPerformed(edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph)
	 */
	public void layoutPerformed(KLayoutGraph layoutGraph) {
		LayoutGraphView view = getLayoutGraphView();
		if (view != null) {
			view.setLayoutGraph(LayoutGraphCloner.cloneLayoutGraph(layoutGraph), true);
		}
	}
	
	/**
	 * Retrieves the layout graph view.
	 * 
	 * @return the active layout graph view
	 */
	private LayoutGraphView getLayoutGraphView() {
		IViewPart viewPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
			.getActivePage().findView(LayoutGraphView.VIEW_ID);
		if (viewPart instanceof LayoutGraphView)
			return (LayoutGraphView)viewPart;
		else
			return null;
	}

}
