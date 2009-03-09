package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class PseudoStateFigure extends Ellipse {
	
	public PseudoStateFigure() {
		super();
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		Rectangle t = Rectangle.SINGLETON;
		t.setBounds(getBounds());
		t.width--;
		t.height--;
		t.shrink((lineWidth - 1) / 2, (lineWidth - 1) / 2);
		graphics.drawOval(t);
		
		Rectangle f = Rectangle.SINGLETON;
		Rectangle r = getBounds();
		f.x = r.x + (r.width / 3);
		f.y = r.y + (r.height / 3);
		f.width = r.width / 3;
		f.height = r.height / 3;
		
		int hUnit = f.width / 4;
		int vUnit = f.height / 6;
		Point sP = new Point(f.x + hUnit, f.y + 6*vUnit);
		Point bP1 = new Point(sP.x, sP.y - 6*vUnit);
		Point bP2 = new Point(bP1.x + hUnit, bP1.y);
		Point bP3 = new Point(bP2.x + hUnit, bP2.y + vUnit );
		Point bP4 = new Point(bP3.x, bP3.y + hUnit);
		Point bP5 = new Point(bP4.x - hUnit, bP4.y + vUnit);
		Point eP = new Point(bP5.x - hUnit, bP5.y);
		
		graphics.drawLine(sP.x, sP.y, bP1.x, bP1.y);
		graphics.drawLine(bP1.x, bP1.y, bP2.x, bP2.y);
		graphics.drawLine(bP2.x, bP2.y, bP3.x, bP3.y);
		graphics.drawLine(bP3.x, bP3.y, bP4.x, bP4.y);
		graphics.drawLine(bP4.x, bP4.y, bP5.x, bP5.y);
		graphics.drawLine(bP5.x, bP5.y, eP.x, eP.y);
	}
	
}
