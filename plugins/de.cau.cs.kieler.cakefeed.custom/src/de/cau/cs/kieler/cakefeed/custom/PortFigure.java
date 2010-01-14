package de.cau.cs.kieler.cakefeed.custom;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class PortFigure extends Shape {

	protected boolean reverse;
	protected final int portWidth = 6;
	protected final int portHeight = 6;
	protected Color fgrdcolor = ColorConstants.black;
	protected Color bgrdcolor = ColorConstants.white;
	
	public PortFigure() {
		super();
		this.setPreferredSize(36, 6);
	}
	
	@Override
	protected void fillShape(Graphics graphics) {
		this.setBackgroundColor(bgrdcolor);
		graphics.fillRectangle(computePortBounds(getBounds()));
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		this.setForegroundColor(fgrdcolor);
		
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
		startPoint.y = r.y + r.height / 2;
		if (reverse) {
			startPoint.x = r.x + portWidth;
		} else {
			startPoint.x = r.x;
		}
		return startPoint;
	}

	private Point computeEndPoint(Rectangle r) {
		Point endPoint = new Point();
		endPoint.y = r.y + r.height / 2;
		if (reverse) {
			endPoint.x = r.x + r.width;
		} else {
			endPoint.x = r.x + r.width - portWidth;
		}
		return endPoint;
	}

	private Rectangle computePortBounds(Rectangle r) {
		Rectangle newBounds = new Rectangle();
		if (reverse) {
			newBounds.x = r.x;
		} else {
			newBounds.x = Math.max((r.x + r.width - portWidth), r.x);
		}
		
		newBounds.y = Math.max(r.y + ((r.height - portHeight) / 2), 0);
		newBounds.width = Math.min(portWidth, r.width);
		newBounds.height = Math.min(portHeight, r.height);
		return newBounds;
	}
}
