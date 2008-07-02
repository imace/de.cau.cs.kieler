package edu.unikiel.rtsys.layouter.gef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kiel.layouter.graphviz.CrossFigure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.swt.graphics.Color;

/**
 * Helper class to add debug figures to some EditPart. The debug Figures can
 * display debug information. Debug Figures can be refreshed in order to avoid
 * explicit remove of debug items between multiple successive debug steps.
 * @author haf
 */
public class DebugFigureHandler {
	
	HashMap<EditPart, DebugFigure> editPart2debugFigure = new HashMap<EditPart, DebugFigure>();
	boolean debug = false;
	
	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	/**
	 * Draw some debug graphics.
	 * @param containerEditPart
	 */
	public DebugFigure getDebugGraphics(GraphicalEditPart containerEditPart) {
			IFigure fig = containerEditPart.getContentPane();
			// if necessary create new debug layer and add it to the root part
			DebugFigure debugFigure = editPart2debugFigure.get(containerEditPart);
			if( (debugFigure == null || !fig.getChildren().contains(debugFigure)) && debug){
				debugFigure = new DebugFigure();
				debugFigure.setBounds(fig.getBounds());
				fig.add(debugFigure);
				editPart2debugFigure.put(containerEditPart, debugFigure);
			}
			return debugFigure;
	}
	
	/**
	 * Refresh all debug figures for all EditParts.
	 */
	public void refresh(){
		for(EditPart container : editPart2debugFigure.keySet()){
			DebugFigure debugFigure = editPart2debugFigure.get(container);
			if(debugFigure != null)
				debugFigure.refresh(debug);
		}
	}

	public void addDebugPoint(GraphicalEditPart containerEditPart, Point p){
		DebugFigure df = getDebugGraphics(containerEditPart);
		if(df != null)
			df.addDebugPoint(p);
	}
	
	public void addDebugPoint(GraphicalEditPart containerEditPart, Point p, Color c){
		DebugFigure df = getDebugGraphics(containerEditPart);
		if(df != null)
			df.addDebugPoint(p,c);
	}
	
	public void addDebugRectangle(GraphicalEditPart containerEditPart, Rectangle bounds, Color c){
		DebugFigure df = getDebugGraphics(containerEditPart);
		if(df != null)
			df.addDebugRectangle(bounds, c);
	}
	
	

public class DebugFigure extends Figure {

	List<Point> debugPoints;
	List<Color> debugColors;
	List<Figure> debugRectangles;

	public void refresh(boolean debug){
		// remove all old stuff from the debug layer
		this.removeAll();
		if(debug){
			// add new stuff to the debug layer
			if(debugPoints != null){
				for (int i = 0; i<debugPoints.size();i++) {
					Point p = debugPoints.get(i);
					Color c = debugColors.get(i);
					CrossFigure cross = new CrossFigure(6, p.x,p.y);
					cross.setForegroundColor(c);
					this.add(cross);
				}
				this.debugPoints.clear();
				this.debugColors.clear();
			}
			if(debugRectangles != null){
				for (int i = 0; i<debugRectangles.size();i++) {
					this.add(debugRectangles.get(i));
				}
				this.debugRectangles.clear();
			}
		}
	}
	
	private void addDebugPoint(Point p){
		if(debugPoints == null){
			debugPoints = new ArrayList<Point>();
		}
		if(debugColors == null){
			debugColors = new ArrayList<Color>();
		}
		debugPoints.add(p);
		debugColors.add(ColorConstants.red);
	}
	private void addDebugPoint(Point p, Color c){
		if(debugPoints == null){
			debugPoints = new ArrayList<Point>();
		}
		if(debugColors == null){
			debugColors = new ArrayList<Color>();
		}
		debugPoints.add(p);
		debugColors.add(c);
	}
	
	private void addDebugRectangle(Rectangle b, Color c){
		if(debugRectangles == null){
			debugRectangles = new ArrayList<Figure>();
		}
		// use polyline instead of real rectangle, because a 
		// RectangleFigure would always overlap most other Figures 
		Polyline p = new Polyline();
		// make everything 1 point smaller so it's visible in the parent
		int offset = 1;
		p.addPoint(new Point(b.x+offset,b.y+offset));
		p.addPoint(new Point(b.x+b.width-offset,b.y+offset));
		p.addPoint(new Point(b.x+b.width-offset,b.y+b.height-offset));
		p.addPoint(new Point(b.x+offset,b.y+b.height-offset));
		p.addPoint(new Point(b.x+offset,b.y+offset));
/*		RectangleFigure r = new RectangleFigure();
		r.setBounds(b);
*/		p.setForegroundColor(c);
		p.setLineWidth(5);
		debugRectangles.add(p);
	}
}

}