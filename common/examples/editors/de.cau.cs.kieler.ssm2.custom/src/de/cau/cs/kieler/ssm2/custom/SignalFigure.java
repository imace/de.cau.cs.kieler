package de.cau.cs.kieler.ssm2.custom;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

public class SignalFigure extends Ellipse {

	protected boolean[] status;
	
	public SignalFigure() {
		super();
	}
	
	public SignalFigure(boolean i, boolean o, boolean l) {
		super();
		status = new boolean[3];
		status[0] = i;
		status[1] = l;
		status[2] = o;
	}
	
	@Override
	protected void fillShape(Graphics graphics) {
		for (int i = 0; i < 3; i++) {
			if (status[i])
				graphics.setBackgroundColor(ColorConstants.lightGreen);
			else
				graphics.setBackgroundColor(ColorConstants.lightGray);
			graphics.fillOval(new Rectangle(this.getBounds().x + this.getBounds().width/3*i,
											this.getBounds().y, 
											this.getBounds().width/3, 
											this.getBounds().height));
		}
	}
	
	@Override
	protected void outlineShape(Graphics graphics) {
		int hUnit = this.getBounds().width / 12;
		int vUnit = this.getBounds().height / 4;
		this.setForegroundColor(ColorConstants.black);
		for (int i = 0; i < 3; i++) {
			graphics.drawOval(new Rectangle(this.getBounds().x + this.getBounds().width/3*i,
											this.getBounds().y, 
											this.getBounds().width/3, 
											this.getBounds().height));
		}
		graphics.drawLine(this.getBounds().x + 2*hUnit, this.getBounds().y + vUnit,
						this.getBounds().x + 2*hUnit, this.getBounds().y + 3*vUnit);
		graphics.drawLine(this.getBounds().x + 5*hUnit, this.getBounds().y + vUnit,
						this.getBounds().x + 5*hUnit, this.getBounds().y + 3*vUnit);
		graphics.drawLine(this.getBounds().x + 5*hUnit, this.getBounds().y + 3*vUnit,
						this.getBounds().x + 7*hUnit, this.getBounds().y + 3*vUnit);
		graphics.drawOval(this.getBounds().x + 9*hUnit, this.getBounds().y + vUnit, 
						this.getBounds().width / 6, this.getBounds().height / 2);
	}
}
