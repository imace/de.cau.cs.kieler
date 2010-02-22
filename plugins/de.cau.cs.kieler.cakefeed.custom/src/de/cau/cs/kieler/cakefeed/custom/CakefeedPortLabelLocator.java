package de.cau.cs.kieler.cakefeed.custom;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;

public class CakefeedPortLabelLocator extends BorderItemLocator {

	protected PortFigure portFigure;
	protected boolean input;
	
	public CakefeedPortLabelLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
		if ((parentFigure instanceof DefaultSizeNodeFigure)
				&& (parentFigure.getChildren() != null)
				&& (parentFigure.getChildren().get(0) instanceof PortFigure)) {
			this.portFigure = (PortFigure)(parentFigure.getChildren().get(0));
		}
	}
	
	public CakefeedPortLabelLocator(IFigure parentFigure, int preferredSide, 
			boolean input) {
		this(parentFigure, preferredSide);
		this.input = input;
	}
	
	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation,
			IFigure borderItem) {
		Rectangle newLocation = super.getValidLocation(proposedLocation, borderItem);
		if (portFigure != null) {
			int x = 0;
			if (input) {
				x = portFigure.getBounds().x + portFigure.getBounds().width + 10;
			}
			else {
				x = portFigure.getBounds().x - newLocation.width - 10;
			}
			newLocation.x = x;
			newLocation.y = portFigure.getBounds().y + (portFigure.getBounds().height
							- newLocation.height) / 2;
		}
		return newLocation;
	}

}
