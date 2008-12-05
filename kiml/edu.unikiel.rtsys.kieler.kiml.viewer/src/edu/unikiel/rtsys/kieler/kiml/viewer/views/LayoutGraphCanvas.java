package edu.unikiel.rtsys.kieler.kiml.viewer.views;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.*;

/**
 * A canvas that is able to paint KIML layout graphs.
 * 
 * @author msp
 */
public class LayoutGraphCanvas extends Canvas implements PaintListener {

	/** the background color */
	private static final Color BACKGROUND_COLOR = new Color(Display.getDefault(), 254, 254, 254);
	/** color used for node borders and labels */
	private static final Color NODE_BORDER_COLOR = new Color(Display.getDefault(), 9, 22, 80);
	/** color used for node fills */
	private static final Color NODE_FILL_COLOR = new Color(Display.getDefault(), 208, 214, 244);
	/** alpha value for nodes */
	private static final int NODE_ALPHA = 120;
	/** color used for port borders and labels */
	private static final Color PORT_BORDER_COLOR = new Color(Display.getDefault(), 14, 54, 24);
	/** color used for port fills */
	private static final Color PORT_FILL_COLOR = new Color(Display.getDefault(), 81, 136, 95);
	/** alpha value for ports */
	private static final int PORT_ALPHA = 240;
	/** color used for edges and edge labels */
	private static final Color EDGE_COLOR = new Color(Display.getDefault(), 39, 9, 16);
	/** alpha value for edges */
	private static final int EDGE_ALPHA = 220;
	
	/** length of edge arrows */
	private static final float ARROW_LENGTH = 4.0f;
	/** width of edge arrows */
	private static final float ARROW_WIDTH = 3.0f;
	
	/**
	 * Rectangle class used to mark painted objects.
	 */
	private class PaintRectangle {
		int x, y, width, height;
		boolean painted = false;
		
		/**
		 * Creates a paint rectangle from the four defining values.
		 * 
		 * @param x x coordinate value of the upper left corner
		 * @param y y coordinate value of the upper left corner
		 * @param width width of the rectangle
		 * @param height height of the rectangle
		 * @param offset offset to be added to coordinate values
		 */
		PaintRectangle(float x, float y, float width, float height,
				KPoint offset) {
			this.x = Math.round(x + offset.getX());
			this.y = Math.round(y + offset.getY());
			this.width = Math.round(width);
			this.height = Math.round(height);
		}
		
		/**
		 * Creates a paint rectangle from a shape layout object.
		 * 
		 * @param shapeLayout shape layout from which values shall be taken
		 * @param offset offset to be added to coordinate values
		 */
		PaintRectangle(KShapeLayout shapeLayout, KPoint offset) {
			this.x = Math.round(shapeLayout.getLocation().getX() + offset.getX());
			this.y = Math.round(shapeLayout.getLocation().getY() + offset.getY());
			this.width = Math.max(Math.round(shapeLayout.getSize().getWidth()), 3);
			this.height = Math.max(Math.round(shapeLayout.getSize().getHeight()), 3);
		}
		
		/**
		 * Creates a paint rectangle from an edge layout object.
		 * 
		 * @param edgeLayout edge layout from which the values shall be determined
		 * @param offset offset to be added to coordinate values
		 */
		PaintRectangle(KEdgeLayout edgeLayout, KPoint offset) {
			float minX = edgeLayout.getSourcePoint().getX(),
				minY = edgeLayout.getSourcePoint().getY();
			float maxX = minX, maxY = minY;
			for (KPoint point : edgeLayout.getGridPoints()) {
				minX = Math.min(minX, point.getX());
				minY = Math.min(minY, point.getY());
				maxX = Math.max(maxX, point.getX());
				maxY = Math.max(maxY, point.getY());
			}
			minX = Math.min(minX, edgeLayout.getTargetPoint().getX());
			minY = Math.min(minY, edgeLayout.getTargetPoint().getY());
			maxX = Math.max(maxX, edgeLayout.getTargetPoint().getX());
			maxY = Math.max(maxY, edgeLayout.getTargetPoint().getY());
			this.x = Math.round(minX + offset.getX());
			this.y = Math.round(minY + offset.getY());
			this.width = Math.round(maxX - minX);
			this.height = Math.round(maxY - minY);
		}
		
		/**
		 * Determines whether the given rectangle intersects with the receiver.
		 * 
		 * @param other the rectangle to check for intersection
		 * @return true if the other rectangle intersects with this one
		 */
		public boolean intersects (PaintRectangle other) {
			float otherX = other.x - 2;
			float otherY = other.y - 2;
			float otherWidth = other.width + 4;
			float otherHeight = other.height + 4;
			return (otherX < this.x + this.width) && (otherY < this.y + this.height)
				&& (otherX + otherWidth > this.x) && (otherY + otherHeight > this.y);
		}
	}
	
	/** indicates whether labels are painted */
	private static boolean paintLabels = false;
	
	/** the layout graph */
	private KLayoutGraph layoutGraph = null;
	/** the mapping of each layout graph element to its computed bounds */
	private Map<Object, PaintRectangle> boundsMap = new LinkedHashMap<Object, PaintRectangle>();
	
	/**
	 * Creates a layout graph canvas.
	 * 
	 * @param parent the parent widget
	 */
	public LayoutGraphCanvas(Composite parent) {
		super(parent, SWT.NONE);
		addPaintListener(this);
		setBackground(BACKGROUND_COLOR);
	}
	
	/**
	 * Sets the given layout graph as the painted graph.
	 * 
	 * @param layoutGraph layout graph to be painted
	 */
	public void setLayoutGraph(KLayoutGraph layoutGraph) {
		// set new size values for the canvas
		if (layoutGraph != null && layoutGraph.getTopGroup() != null)
		{
			KDimension graphDim = layoutGraph.getTopGroup().getLayout().getSize();
			setSize(new Point((int)graphDim.getWidth() + 1,
					(int)graphDim.getHeight() + 1));
		}
		
		this.layoutGraph = layoutGraph;
		boundsMap.clear();
		redraw();
	}

	/**
	 * This method is called when the canvas is requested to paint.
	 * 
	 * @param event paint event
	 */
	public void paintControl(PaintEvent event) {
		if (layoutGraph != null) {
			// reset paint information
			for (PaintRectangle rectangle : boundsMap.values()) {
				rectangle.painted = false;
			}
			
			// paint the top node group with its children
			KPoint offset = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
			PaintRectangle area = new PaintRectangle(event.x, event.y,
					event.width, event.height, offset);
			paintNodeGroup(layoutGraph.getTopGroup(), event.gc, area, offset);
		}
	}
	
	/**
	 * Paints a node group for the given dirty area.
	 * 
	 * @param nodeGroup node group to paint
	 * @param graphics the graphics context used to paint
	 * @param area dirty area that needs painting
	 * @param offset offset to be added to relative coordinates
	 */
	private void paintNodeGroup(KNodeGroup nodeGroup, GC graphics,
			PaintRectangle area, KPoint offset) {
		// paint ports of the node group
		graphics.setForeground(PORT_BORDER_COLOR);
		graphics.setBackground(PORT_FILL_COLOR);
		graphics.setAlpha(PORT_ALPHA);
		for (KPort port : nodeGroup.getPorts()) {
			PaintRectangle rect = boundsMap.get(port);
			if (rect == null) {
				rect = new PaintRectangle(port.getLayout(), offset);
				boundsMap.put(port, rect);
			}
			if (!rect.painted && rect.intersects(area)) {
				graphics.fillRectangle(rect.x, rect.y, rect.width, rect.height);
				graphics.drawRectangle(rect.x, rect.y, rect.width, rect.height);
				rect.painted = true;
			}
			if (paintLabels) {
				rect = boundsMap.get(port.getLabel());
				if (rect == null) {
					rect = new PaintRectangle(port.getLabel().getLabelLayout(), offset);
					boundsMap.put(port.getLabel(), rect);
				}
				if (!rect.painted && rect.intersects(area)) {
					graphics.drawString(port.getLabel().getText(),
							rect.x, rect.y, true);
					rect.painted = true;
				}
			}
		}
		
		// paint sub node groups
		for (KNodeGroup child : nodeGroup.getSubNodeGroups()) {
			graphics.setForeground(NODE_BORDER_COLOR);
			graphics.setBackground(NODE_FILL_COLOR);
			graphics.setAlpha(NODE_ALPHA);
			PaintRectangle rect = boundsMap.get(child);
			if (rect == null) {
				rect = new PaintRectangle(child.getLayout(), offset);
				boundsMap.put(child, rect);
			}
			if (!rect.painted && rect.intersects(area)) {
				graphics.fillRectangle(rect.x, rect.y, rect.width, rect.height);
				graphics.drawRectangle(rect.x, rect.y, rect.width, rect.height);
				rect.painted = true;
				KPoint childOffset = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
				childOffset.setX(rect.x);
				childOffset.setY(rect.y);
				paintNodeGroup(child, graphics, area, childOffset);
			}
			if (paintLabels) {
				rect = boundsMap.get(child.getLabel());
				if (rect == null) {
					rect = new PaintRectangle(child.getLabel().getLabelLayout(), offset);
					boundsMap.put(child.getLabel(), rect);
				}
				if (!rect.painted && rect.intersects(area)) {
					graphics.drawString(child.getLabel().getText(),
							rect.x, rect.y, true);
					rect.painted = true;
				}
			}
			
			// paint edges
			graphics.setForeground(EDGE_COLOR);
			graphics.setBackground(EDGE_COLOR);
			graphics.setAlpha(EDGE_ALPHA);
			for (KEdge edge : child.getIncomingEdges()) {
				paintEdge(edge, graphics, area, offset);
			}
			for (KEdge edge : child.getOutgoingEdges()) {
				paintEdge(edge, graphics, area, offset);
			}
		}
	}
	
	/**
	 * Paints an edge for the given dirty area.
	 * 
	 * @param edge edge to paint
	 * @param graphics the graphics context used to paint
	 * @param area dirty area that needs painting
	 * @param offset offset to be added to relative coordinates
	 */
	private void paintEdge(KEdge edge, GC graphics,
			PaintRectangle area, KPoint offset) {
		PaintRectangle rect = boundsMap.get(edge);
		if (rect == null) {
			rect = new PaintRectangle(edge.getLayout(), offset);
			boundsMap.put(edge, rect);
		}
		if (!rect.painted && rect.intersects(area)) {
			KPoint sourcePoint = edge.getLayout().getSourcePoint();
			KPoint targetPoint = edge.getLayout().getTargetPoint();
			List<KPoint> bendPoints = edge.getLayout().getGridPoints();
			KPoint lastPoint = sourcePoint;
			for (KPoint point : bendPoints) {
				graphics.drawLine(Math.round(lastPoint.getX() + offset.getX()),
						Math.round(lastPoint.getY() + offset.getY()),
						Math.round(point.getX() + offset.getX()),
						Math.round(point.getY() + offset.getY()));
				lastPoint = point;
			}
			graphics.drawLine(Math.round(lastPoint.getX() + offset.getX()),
					Math.round(lastPoint.getY() + offset.getY()),
					Math.round(targetPoint.getX() + offset.getX()),
					Math.round(targetPoint.getY() + offset.getY()));
			graphics.fillPolygon(makeArrow(lastPoint, targetPoint, offset));
			rect.painted = true;
		}
		if (paintLabels) {
			for (KEdgeLabel edgeLabel : edge.getLabel()) {
				rect = boundsMap.get(edgeLabel);
				if (rect == null) {
					rect = new PaintRectangle(edgeLabel.getLabelLayout(), offset);
					boundsMap.put(edgeLabel, rect);
				}
				if (!rect.painted && rect.intersects(area)) {
					graphics.drawString(edgeLabel.getText(), rect.x, rect.y, true);
					rect.painted = true;
				}
			}
		}
	}
	
	/**
	 * Constructs a polygon that forms an arrow.
	 * 
	 * @param point1 source point
	 * @param point2 target point
	 * @param offset offset value to be added to coordinates
	 * @return array of coordinates for the arrow polygon
	 */
	private int[] makeArrow(KPoint point1, KPoint point2, KPoint offset) {
		int[] arrow = new int[6];
		arrow[0] = Math.round(point2.getX() + offset.getX());
		arrow[1] = Math.round(point2.getY() + offset.getY());
		
		float vectX = point1.getX() - point2.getX();
		float vectY = point1.getY() - point2.getY();
		float length = (float)Math.sqrt(vectX * vectX + vectY * vectY);
		float normX = vectX / length;
		float normY = vectY / length;
		float neckX = point2.getX() + ARROW_LENGTH * normX;
		float neckY = point2.getY() + ARROW_LENGTH * normY;
		float orthX = normY * ARROW_WIDTH / 2;
		float orthY = -normX * ARROW_WIDTH / 2;
		
		arrow[2] = Math.round(neckX + orthX + offset.getX());
		arrow[3] = Math.round(neckY + orthY + offset.getY());
		arrow[4] = Math.round(neckX - orthX + offset.getX());
		arrow[5] = Math.round(neckY - orthY + offset.getY());
		return arrow;
	}
	
}
