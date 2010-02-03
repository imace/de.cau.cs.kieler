package de.cau.cs.kieler.cakefeed.custom;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.internal.figures.BorderItemContainerFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;

@SuppressWarnings("restriction")
public class FBBorderItemLocator implements IBorderItemLocator{

	protected boolean input;
	protected boolean ctrl;
	
	public FBBorderItemLocator(boolean input, boolean ctrl) {
		this.input = input;
		this.ctrl = ctrl;
	}
	
	@Override
	public int getCurrentSideOfParent() {
		if (input) {
			return PositionConstants.WEST;
		} else {
			return PositionConstants.EAST;
		}
	}

	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation,
			IFigure borderItem) {
		Rectangle validLocation = new Rectangle(proposedLocation);
		Rectangle reference = null;
		FBTypeFigure fBFigure = getFBFigure(borderItem);
		if (fBFigure != null) {
			if (ctrl) {
				reference = fBFigure.getCtrlRectangle();
			} else {
				reference = fBFigure.getDataRectangle();
			}
			if (input) {
				reference.x -= proposedLocation.width;
			} else {
				reference.x += reference.width;
			}
			reference.width = 0;
			validLocation.x = reference.x;
			if (validLocation.y < reference.y) {
				validLocation.y = reference.y;
			} else if ((validLocation.y + validLocation.height) > (reference.y + reference.height)) {
				validLocation.y = reference.y + reference.height - validLocation.height;
			}
		}
		return validLocation;
	}

	private FBTypeFigure getFBFigure(IFigure borderItem) {
		IFigure parent = borderItem.getParent();
		if (parent instanceof DefaultSizeNodeFigure) {
			parent = parent.getParent();
			if (parent instanceof BorderedNodeFigure) {
				parent = parent.getParent();
				if (parent instanceof BorderItemContainerFigure) {
					parent = parent.getParent();
					if (parent instanceof BorderedNodeFigure) {
						return getFBFigureFromBorderedNodeFigure((BorderedNodeFigure)parent);
					}
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private FBTypeFigure getFBFigureFromBorderedNodeFigure(BorderedNodeFigure parent) {
		List children = parent.getChildren();
		for (Object object : children) {
			if (object instanceof DefaultSizeNodeFigure) {
				DefaultSizeNodeFigure dSNF = (DefaultSizeNodeFigure)object;
				List children2 = dSNF.getChildren();
				for (Object object2 : children2) {
					if (object2 instanceof FBTypeFigure) {
						return (FBTypeFigure)object2;
					}
				}
			}
		}
		return null;
	}

	@Override
	public void setConstraint(Rectangle constraint) {
		// Do not pay attention to constraints
	}

	@Override
	public void relocate(IFigure target) {
		Rectangle newBounds = new Rectangle();
		newBounds.x = target.getBounds().x;
		newBounds.y = target.getBounds().y;
		newBounds.width = target.getPreferredSize().width;
		newBounds.height = target.getPreferredSize().height;
		target.setBounds(getValidLocation(newBounds, target));
	}

}
