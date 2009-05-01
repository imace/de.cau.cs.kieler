package de.cau.cs.kieler.ssm2.custom;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class CustomCompartmentLayout extends XYLayout {

	// The maximum height of all elements in the current row
	int maxHeight;
	
	// A custom layout for compartments which lays its children out in rows
	// and wraps them around if needed.
	public void layout(IFigure parent) {
		
		if (!parent.isVisible())
			return;
		
		List children = parent.getChildren();
		Rectangle clientArea = parent.getClientArea();
		int width = clientArea.width;
		Rectangle newBounds = new Rectangle();
		newBounds.x = 0;
		newBounds.y = 0;
		newBounds.width = 0;
		newBounds.height = 0;
		maxHeight = 0;
		
		for (Object child : children) {
			if (child instanceof IFigure) {
				IFigure childFigure = (IFigure) child;
				if ((childFigure.getChildren() != null) && (childFigure.getChildren().size() > 0) && (childFigure.getChildren().get(0) instanceof AttributeAwareInvisibleFigure)) {
					newBounds.width = childFigure.getMinimumSize(-1, -1).width;
					newBounds.height = childFigure.getMinimumSize(-1, -1).height;
				}
				else {
					newBounds.width = childFigure.getPreferredSize(-1, -1).width;
					newBounds.height = childFigure.getPreferredSize(-1, -1).height;
				}
				
				if (newBounds.x + newBounds.width > width) {
					newBounds.x = 0;
					newBounds.y += maxHeight;
					maxHeight = newBounds.height;
				}
				else if (newBounds.height > maxHeight) {
					maxHeight = newBounds.height;
				}
				
				childFigure.setBounds(newBounds);
				newBounds.x += newBounds.width;
			}
		}
	}

	// Method to calculate the preferred size of a figure
	@Override
	protected Dimension calculatePreferredSize(IFigure parent, int hint, int hint2) {
		
		return parent.getPreferredSize(hint, hint2);
	}
}