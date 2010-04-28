package de.cau.cs.kieler.cakefeed.custom;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
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
	
	@Override
	protected Point locateOnParent(Point suggestedLocation, int suggestedSide,
			IFigure borderItem) {
		Point newPoint = super.locateOnParent(suggestedLocation, suggestedSide, borderItem);
		Rectangle newBounds = new Rectangle();
		newBounds.x = newPoint.x;
		newBounds.y = newPoint.y;
		newBounds.width = borderItem.getPreferredSize().width;
		newBounds.height = borderItem.getPreferredSize().height;
		newBounds = getValidLocation2(newBounds, borderItem);
		return new Point(newBounds.x, newBounds.y);
	}

	private Rectangle getValidLocation2(Rectangle newBounds, IFigure borderItem) {
		Rectangle newLocation = newBounds;
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
