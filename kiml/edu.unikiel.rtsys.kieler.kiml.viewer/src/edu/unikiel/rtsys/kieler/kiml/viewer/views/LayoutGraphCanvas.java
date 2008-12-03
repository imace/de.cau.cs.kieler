package edu.unikiel.rtsys.kieler.kiml.viewer.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.*;

/**
 * A canvas that is able to draw KIML layout graphs.
 * 
 * @author msp
 */
public class LayoutGraphCanvas extends Canvas implements PaintListener {

	/** the layout graph */
	private KLayoutGraph layoutGraph = null;
	
	/** the background color */
	private Color backgoundColor = new Color(Display.getDefault(), 252, 252, 252);
	
	/**
	 * Creates a layout graph canvas.
	 * 
	 * @param parent the parent widget
	 */
	public LayoutGraphCanvas(Composite parent) {
		super(parent, SWT.NONE);
		addPaintListener(this);
		setBackground(backgoundColor);
	}
	
	/**
	 * Sets the given layout graph as the drawn graph.
	 * 
	 * @param layoutGraph layout graph to be drawn
	 */
	public void setLayoutGraph(KLayoutGraph layoutGraph) {
		this.layoutGraph = layoutGraph;
		System.out.println("topp!");
	}

	/**
	 * This method is called when the canvas is requested to paint.
	 * 
	 * @param event paint event
	 */
	public void paintControl(PaintEvent event) {
		GC graphics = event.gc;
	}
	
}
