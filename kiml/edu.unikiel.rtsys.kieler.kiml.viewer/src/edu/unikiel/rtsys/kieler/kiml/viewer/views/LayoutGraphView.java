package edu.unikiel.rtsys.kieler.kiml.viewer.views;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.part.*;
import org.eclipse.swt.SWT;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import edu.unikiel.rtsys.kieler.kiml.viewer.Messages;


/**
 * A viewer for layout graphs.
 * 
 * @author msp
 */
public class LayoutGraphView extends ViewPart {
	
	/** the view identifier */
	public static final String VIEW_ID = "edu.unikiel.rtsys.kieler.kiml.viewer.layoutGraph"; //$NON-NLS-1$

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
		tabFolder = new TabFolder(parent, SWT.BOTTOM);
		
		// create canvas for pre-layout
		TabItem preItem = new TabItem(tabFolder, SWT.NONE);
		preItem.setText("Pre-Layout"); //$NON-NLS-1$
		preCanvas = new LayoutGraphCanvas(tabFolder);
		preCanvas.setToolTipText(Messages.getString("kiml.viewer.0")); //$NON-NLS-1$
		preItem.setControl(preCanvas);
		
		// create canvas for post-layout
		TabItem postItem = new TabItem(tabFolder, SWT.NONE);
		postItem.setText("Post-Layout"); //$NON-NLS-1$
		postCanvas = new LayoutGraphCanvas(tabFolder);
		postCanvas.setToolTipText(Messages.getString("kiml.viewer.1")); //$NON-NLS-1$
		postItem.setControl(postCanvas);
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
	
}
