package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

public class DoubleEllipse extends Ellipse {
	
	// A class that draws two ellipses instead of only one
	public DoubleEllipse() {
		super();
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		Rectangle r = Rectangle.SINGLETON;
		r.setBounds(getBounds());
		r.width--;
		r.height--;
		r.shrink((lineWidth - 1) / 2, (lineWidth - 1) / 2);
		graphics.drawOval(r);
		r.x += 5;
		r.y += 5;
		r.width -= 10;
		r.height -= 10;
		graphics.drawOval(r);
	}
	
}
