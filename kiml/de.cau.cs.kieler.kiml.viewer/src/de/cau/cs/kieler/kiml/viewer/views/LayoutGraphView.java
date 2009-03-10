package de.cau.cs.kieler.kiml.viewer.views;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.part.ViewPart;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.viewer.Messages;
import de.cau.cs.kieler.kiml.viewer.actions.GmfDebugGraphicsAction;
import de.cau.cs.kieler.kiml.viewer.actions.ImageExportAction;

/**
 * A viewer for layout graphs.
 * 
 * @author msp
 */
public class LayoutGraphView extends ViewPart {
	
        /**
         * Constants to identify the different layout graphs.
         */
        public static final int PRE = 0;
        public static final int POST = 1;
        public static final int COMPLAYOUT = 2;
        public static final int COMPGMF = 3;
    
	/** the view identifier */
	public static final String VIEW_ID = "de.cau.cs.kieler.kiml.viewer.layoutGraph"; //$NON-NLS-1$

	/** the tab folder used to hold the canvas controls */
	private TabFolder tabFolder;
	/** the canvas used to draw pre-layout graphs */
	private LayoutGraphCanvas preCanvas;
	/** the canvas used to draw post-layout graphs */
	private LayoutGraphCanvas postCanvas;
	/** a debugging cancas to compare layout with GMF values */
	private GmfDebugCanvas compareCanvas;
	/** New transparent "window" to display on top of the Eclipse window, i.e. the GMF editor */ 
	TransparentShell transparentShell;

	
	
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
		getViewSite().getActionBars().getToolBarManager()
                                .add(new GmfDebugGraphicsAction(this));

		
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
		
		// create canvas for compare view
                TabItem compareItem = new TabItem(tabFolder, SWT.NONE);
                compareItem.setText("Compare with GMF"); //$NON-NLS-1$
                ScrolledComposite compareScroller = new ScrolledComposite(tabFolder,
                                SWT.H_SCROLL | SWT.V_SCROLL);
                compareItem.setControl(compareScroller);
                compareCanvas = new GmfDebugCanvas(compareScroller);
                compareScroller.setContent(compareCanvas);
                compareCanvas.setToolTipText("Compare actual with GMF layout"); 
                transparentShell = new TransparentShell(compareCanvas);
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
         * Sets the given layout graph as the displayed graph.
         * 
         * @param layoutGraph layout graph to be displayed
         * @param post if true, the graph is displayed as 'post-layout', else
         *     it is displayed as 'pre-layout'
         */
        public void setLayoutGraph(KLayoutGraph layoutGraph, int index) {
                switch (index) {
                case PRE:
                    preCanvas.setLayoutGraph(layoutGraph);
                    break;
                case POST:
                    postCanvas.setLayoutGraph(layoutGraph);
                    compareCanvas.setLayoutGraph(layoutGraph);
                    break;
                case COMPLAYOUT:
                case COMPGMF:
                    compareCanvas.setLayoutGraph(layoutGraph);
                default:
                    break;
                }
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
	
	public GmfDebugCanvas getDebugCanvas(){
	    return compareCanvas;
	}
	public TransparentShell getTransparentShell(){
	    return transparentShell;
	}
	
}
