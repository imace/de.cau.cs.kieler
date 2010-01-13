package de.cau.cs.kieler.cakefeed.custom;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class PortFigure extends Shape {

	protected boolean reverse;
	protected final int portWidth = 6;
	protected final int portHeight = 6;
	
	public PortFigure() {
		super();
	}
	
	@Override
	protected void fillShape(Graphics graphics) {
		graphics.fillRectangle(computePortBounds(getBounds()));
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		float lineInset = Math.max(1.0f, getLineWidthFloat()) / 2.0f;
	    int inset1 = (int)Math.floor(lineInset);
	    int inset2 = (int)Math.ceil(lineInset);

	    Rectangle r = Rectangle.SINGLETON.setBounds(getBounds());
	    r.x += inset1 ; 
	    r.y += inset1; 
	    r.width -= inset1 + inset2;
	    r.height -= inset1 + inset2;
	    
	    graphics.drawRectangle(computePortBounds(r));
	    graphics.drawLine(computeStartPoint(r), computeEndPoint(r));
	}
	
	private Point computeStartPoint(Rectangle r) {
		Point startPoint = new Point();
		startPoint.y = r.height / 2;
		if (reverse) {
			startPoint.x = r.x + portWidth;
		} else {
			startPoint.x = r.x;
		}
		return startPoint;
	}

	private Point computeEndPoint(Rectangle r) {
		Point endPoint = new Point();
		endPoint.y = r.height / 2;
		if (reverse) {
			endPoint.x = r.width;
		} else {
			endPoint.x = r.width - portWidth;
		}
		return endPoint;
	}

	private Rectangle computePortBounds(Rectangle r) {
		Rectangle newBounds = new Rectangle();
		if (reverse) {
			newBounds.x = r.x;
		} else {
			newBounds.x = Math.max((r.width - portWidth), 0);
		}
		
		newBounds.y = Math.max((r.height - portHeight) / 2, 0);
		newBounds.width = Math.min(portWidth, r.width);
		newBounds.height = Math.min(portHeight, r.height);
		return newBounds;
	}
}
