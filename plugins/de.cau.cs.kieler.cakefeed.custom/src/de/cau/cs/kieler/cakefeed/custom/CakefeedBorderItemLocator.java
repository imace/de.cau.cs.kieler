package de.cau.cs.kieler.cakefeed.custom;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;

public class CakefeedBorderItemLocator extends BorderItemLocator {

	protected FBTypeFigure fBTypeFigure;
	protected boolean ctrl;
	protected boolean input;
	
	public CakefeedBorderItemLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
		if ((parentFigure instanceof DefaultSizeNodeFigure)
				&& (parentFigure.getChildren() != null)
				&& (parentFigure.getChildren().get(0) instanceof FBTypeFigure)) {
			this.fBTypeFigure = (FBTypeFigure)(parentFigure.getChildren().get(0));
		}
		
	}
	
	public CakefeedBorderItemLocator(IFigure parentFigure, int preferredSide, 
			boolean ctrl, boolean input) {
		this(parentFigure, preferredSide);
		this.ctrl = ctrl;
		this.input = input;
	}

	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation,
			IFigure borderItem) {
		Rectangle newLocation = super.getValidLocation(proposedLocation, borderItem);
		if (fBTypeFigure != null) {
			Rectangle reference = null;
			if (ctrl) {
				reference = fBTypeFigure.getCtrlRectangle();
			} else {
				reference = fBTypeFigure.getDataRectangle();
			}
			if (newLocation.y < reference.y) {
				newLocation.y = reference.y;
			} else if ((newLocation.y + newLocation.height) > (reference.y + reference.height)) {
				newLocation.y = reference.y + reference.height - newLocation.height;
			}
			if (input && ((newLocation.x + newLocation.width) > reference.x)) {
				newLocation.x = reference.x - newLocation.width;
			} else if (!input && (newLocation.x < (reference.x + reference.width))) {
				newLocation.x = newLocation.x = (reference.x + reference.width);
			}
		}
		return newLocation;
	}
}
