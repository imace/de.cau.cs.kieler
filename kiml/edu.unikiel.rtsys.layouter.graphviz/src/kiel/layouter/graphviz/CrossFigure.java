package kiel.layouter.graphviz;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * A figure representing a cross (plus).
 * @author haf
 *
 */
public class CrossFigure extends Figure {

	int x, y, size;
	
	public CrossFigure(int size, int x, int y) {
		super();
		this.size = size;
		this.x = x;
		this.y = y;
		int offset = size / 2;
		this.setBounds(new Rectangle(x-offset,y-offset,size+1,size+1));
	}
	
	public void paint(Graphics g){
		int offset = size /2;
		g.setForegroundColor(this.getForegroundColor());
		g.drawLine(x-offset, y-offset , x+offset , y+offset);
		g.drawLine(x-offset, y+offset , x+offset , y-offset);
	}
}
