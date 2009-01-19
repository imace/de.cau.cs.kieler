package de.cau.cs.kieler.kiml.viewer.views;


import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.part.*;
import org.eclipse.swt.SWT;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.viewer.Messages;



/**
 * A viewer for layout graphs.
 * 
 * @author msp
 */
public class LayoutGraphView extends ViewPart {
	
	/** the view identifier */
	public static final String VIEW_ID = "de.cau.cs.kieler.kiml.viewer.layoutGraph"; //$NON-NLS-1$

	/** the tab folder used to hold the canvas controls */
	private TabFolder tabFolder;
	/** the canvas used to draw pre-layout graphs */
	private LayoutGraphCanvas preCanvas;
	/** the canvas used to draw post-layout graphs */
	private LayoutGraphCanvas postCanvas;

	/**
	 * Creates a layout graph view.
	 */
	public LayoutGraphView() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createPartControl(Composite parent) {
		// create actions in the view toolbar
		getViewSite().getActionBars().getToolBarManager()
				.add(new ImageExportAction(this));
		
		// create tab folder for pre- and post-layout
		tabFolder = new TabFolder(parent, SWT.BOTTOM);
		
		// create canvas for pre-layout
		TabItem preItem = new TabItem(tabFolder, SWT.NONE);
		preItem.setText("Pre-Layout"); //$NON-NLS-1$
		ScrolledComposite preScroller = new ScrolledComposite(tabFolder,
				SWT.H_SCROLL | SWT.V_SCROLL);
		preItem.setControl(preScroller);
		preCanvas = new LayoutGraphCanvas(preScroller);
		preScroller.setContent(preCanvas);
		preCanvas.setToolTipText(Messages.getString("kiml.viewer.0")); //$NON-NLS-1$		
		
		// create canvas for post-layout
		TabItem postItem = new TabItem(tabFolder, SWT.NONE);
		postItem.setText("Post-Layout"); //$NON-NLS-1$
		ScrolledComposite postScroller = new ScrolledComposite(tabFolder,
				SWT.H_SCROLL | SWT.V_SCROLL);
		postItem.setControl(postScroller);
		postCanvas = new LayoutGraphCanvas(postScroller);
		postScroller.setContent(postCanvas);
		postCanvas.setToolTipText(Messages.getString("kiml.viewer.1")); //$NON-NLS-1$
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	public void setFocus() {
		tabFolder.setFocus();
	}
	
	/**
	 * Sets the given layout graph as the displayed graph.
	 * 
	 * @param layoutGraph layout graph to be displayed
	 * @param post if true, the graph is displayed as 'post-layout', else
	 *     it is displayed as 'pre-layout'
	 */
	public void setLayoutGraph(KLayoutGraph layoutGraph, boolean post) {
		if (post)
			postCanvas.setLayoutGraph(layoutGraph);
		else
			preCanvas.setLayoutGraph(layoutGraph);
	}
	
	/**
	 * Retrieves the currently active layout graph canvas.
	 * 
	 * @return the active layout graph canvas
	 */
	public LayoutGraphCanvas getActiveCanvas() {
		int tabIndex = tabFolder.getSelectionIndex();
		if (tabIndex >= 0) {
			return (LayoutGraphCanvas)((ScrolledComposite)tabFolder
					.getItem(tabIndex).getControl()).getContent();
		}
		else return null;
	}
	
}
