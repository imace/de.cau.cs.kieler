package org.eclipse.papyrus.diagram.statemachine.custom.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;

public class PseudostateDeepHistoryFigure extends Ellipse {

	public PseudostateDeepHistoryFigure() {
		super();
		Dimension dim1 = new Dimension(22, 22);
		this.setPreferredSize(new Dimension(dim1));
		this.setMaximumSize(new Dimension(dim1));
		this.setMinimumSize(new Dimension(dim1));
		this.setSize(dim1);
	}

	/**
	 * Fills the circle.
	 * 
	 * @param graphics
	 *        the graphics
	 * 
	 * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
	 */
	protected void fillShape(Graphics graphics) {
		graphics.pushState();
		graphics.setBackgroundColor(ColorConstants.white);
		graphics.fillOval(getBounds());
		graphics.popState();

	}

	protected void outlineShape(Graphics graphics) {
		super.outlineShape(graphics);

		// 'H' letter
		graphics.drawLine(bounds.getCenter().getTranslated((int)(-bounds.width * 0.25), (int)(-bounds.height * 0.25)), bounds.getCenter().getTranslated((int)(-bounds.width * 0.25), (int)(bounds.height * 0.25)));
		graphics.drawLine(bounds.getCenter().getTranslated((int)(bounds.width * 0.05), (int)(-bounds.height * 0.25)), bounds.getCenter().getTranslated((int)(bounds.width * 0.05), (int)(bounds.height * 0.25)));
		graphics.drawLine(bounds.getCenter().getTranslated((int)(-bounds.width * 0.25), 0), bounds.getCenter().getTranslated((int)(bounds.width * 0.05), 0));

		// '*' character
		graphics.drawLine(bounds.getCenter().getTranslated((int)(bounds.width * 0.25), (int)(-bounds.height * 0.25)), bounds.getCenter().getTranslated((int)(bounds.width * 0.25), (int)(-bounds.height * 0.05)));
		graphics.drawLine(bounds.getCenter().getTranslated((int)(bounds.width * 0.15), (int)(-bounds.height * 0.20)), bounds.getCenter().getTranslated((int)(bounds.width * 0.35), (int)(-bounds.height * 0.10)));
		graphics.drawLine(bounds.getCenter().getTranslated((int)(bounds.width * 0.35), (int)(-bounds.height * 0.20)), bounds.getCenter().getTranslated((int)(bounds.width * 0.15), (int)(-bounds.height * 0.10)));
	}

}
