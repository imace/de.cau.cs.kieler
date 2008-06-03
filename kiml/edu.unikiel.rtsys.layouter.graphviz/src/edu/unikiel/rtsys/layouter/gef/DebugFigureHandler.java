package edu.unikiel.rtsys.layouter.gef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kiel.layouter.graphviz.CrossFigure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.swt.graphics.Color;

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
			if( debugFigure == null || !fig.getChildren().contains(debugFigure)){
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
			debugFigure.refresh(debug);
		}
	}

	public void addDebugPoint(GraphicalEditPart containerEditPart, Point p){
		DebugFigure df = getDebugGraphics(containerEditPart);
		df.addDebugPoint(p);
	}
	
	public void addDebugPoint(GraphicalEditPart containerEditPart, Point p, Color c){
		DebugFigure df = getDebugGraphics(containerEditPart);
		df.addDebugPoint(p,c);
	}
	
	
	

public class DebugFigure extends Figure {

	List<Point> debugPoints;
	List<Color> debugColors;

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
			}
			this.debugPoints.clear();
			this.debugColors.clear();
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
}

}