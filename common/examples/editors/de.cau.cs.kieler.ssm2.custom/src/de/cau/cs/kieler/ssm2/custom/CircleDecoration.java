package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

// A new decoration that depicts a circle
public class CircleDecoration extends PolygonDecoration {
	
	@Override
	public void setRotation(double angle) {
	// This has to be empty, otherwise the circle would be deformed at
	// different angles
	}
	
	@Override
	protected void outlineShape(Graphics g) {
		Rectangle ovalBounds = getBoundsFromPoints();
		g.drawOval(ovalBounds);
	}
	
	@Override
	protected void fillShape(Graphics g) {
		Rectangle ovalBounds = getBoundsFromPoints();
		g.fillOval(ovalBounds);
	}
	
	// Transforms the PointList into bounds that can be used to draw the circle
	protected Rectangle getBoundsFromPoints() {
		if (getPoints().size() < 2) {
			return null;
		}
		
		PointList pointList = getPoints();
		
		int top  = pointList.getFirstPoint().y;
		int left = pointList.getFirstPoint().x;
		int right = pointList.getFirstPoint().x;
		int bottom = pointList.getFirstPoint().y;
		
		// Take the outermost coordinates of all points as bounds 
		for (int i = 1; i < getPoints().size(); i++) {
			Point p = pointList.getPoint(i);
			if (p.x < left)
				left = p.x;
			if (p.x > right)
				right = p.x;
			if (p.y < top)
				top = p.y;
			if (p.y > bottom)
				bottom = p.y;
		}
		return new Rectangle(left, top, right-left, bottom-top);
	}
	
}
