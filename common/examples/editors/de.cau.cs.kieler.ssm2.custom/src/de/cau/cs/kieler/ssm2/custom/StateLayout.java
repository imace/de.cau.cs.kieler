package de.cau.cs.kieler.ssm2.custom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Transposer;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

public class StateLayout extends ConstrainedToolbarLayout {
	
	protected Transposer transposer; {
		transposer = new Transposer();
		transposer.setEnabled(false);
	}	
	
	/**
	 * @see org.eclipse.draw2d.LayoutManager#layout(IFigure)
	 */
	public void layout(IFigure parent) {
		List children = parent.getChildren();
		int numChildren = children.size();
		Rectangle clientArea = transposer.t(parent.getClientArea());
		Rectangle newBounds = new Rectangle();
		int x = clientArea.x;
		int y = clientArea.y;
		int width = clientArea.width;
		int height = clientArea.height;
		int availableHeight = height;
		
		int[] heights = new int[numChildren];
		int[] widths = new int[numChildren];
		int numUndecided = 0;
		
		boolean simpleLayout = true;
		
		for (int i = 0; i < numChildren; i++) {
			IFigure child = (IFigure) children.get(i);
			try {
				IFigure figure = ((IFigure) ((IFigure) ((IFigure) ((IFigure) child.getChildren().get(1)).getChildren().get(0)).getChildren().get(0)).getChildren().get(0));
				simpleLayout = false;
				}
			catch (Exception e) {
				
			}
		}
		
		if (simpleLayout) {
			for (int i = 0; i < numChildren; i++) {
				IFigure child = (IFigure) children.get(i);
				if (child instanceof WrappingLabel) {
					newBounds.x = x + (width / 2) - (child.getPreferredSize().width / 2);
					newBounds.y = y + (height / 2) - (child.getPreferredSize().height / 2);
					newBounds.width = child.getPreferredSize().width;
					newBounds.height = child.getPreferredSize().height;
				}
				else if (child instanceof ShapeCompartmentFigure) {
					newBounds.x = x + width / 10;
					newBounds.y = y + height / 10;
					newBounds.width = width / 5*4;
					newBounds.height = height / 5*4;
				}
				else {
					newBounds.x = x;
					newBounds.y = y;
					newBounds.width = 0;
					newBounds.height = 0;
				}
				child.setBounds(transposer.t(newBounds));
			}
		}
		else {
			for (int i = 0; i < numChildren; i++) {
				IFigure child = (IFigure) children.get(i);
				heights[i] = determineHeight(child);
				widths[i] = determineWidth(child);
				
				if (widths[i] < 0) {
					widths[i] = width*4/5;
				}
				
				if (heights[i] >= 0) {
					availableHeight -= heights[i];
				}
				else {
					numUndecided++;
				}
			}
			
			for (int i = 0; i < numChildren; i++) {
				if (heights[i] < 0) {
					heights[i] = availableHeight / numUndecided;
				}
			}
			
			newBounds.y = y; 
			for (int i = 0; i < numChildren; i++) {
				IFigure child = (IFigure) children.get(i);
				
				newBounds.x = x + (width / 2) - (widths[i] / 2);
				newBounds.width = widths[i];
				newBounds.height = heights[i];
				
				child.setBounds(transposer.t(newBounds));
				
				newBounds.y += newBounds.height;
			}
		}
	}

	private int determineWidth(IFigure child) {
		if (child instanceof WrappingLabel) {
			return child.getPreferredSize().width;
		}
		else if (child instanceof ShapeCompartmentFigure) {
			try {
				IFigure figure = ((IFigure) ((IFigure) ((IFigure) ((IFigure) child.getChildren().get(1)).getChildren().get(0)).getChildren().get(0)).getChildren().get(0));
				return -1;
				}
			catch (Exception e) {
				return -1;
			}
		}
		else if (child instanceof ResizableCompartmentFigure) {
			try {
				IFigure figure = ((IFigure) ((IFigure) ((IFigure) ((IFigure) child.getChildren().get(1)).getChildren().get(0)).getChildren().get(0)).getChildren().get(0));
			
				if (figure instanceof Label) {
					return -1;
				}
				else {
					return 0;
				}
			}
			catch (Exception e) {
				return 0;
			}
		}
		else {
			return 0;
		}
	}

	private int determineHeight(IFigure child) {
		if (child instanceof WrappingLabel) {
			return child.getPreferredSize().height;
		}
		else if (child instanceof ShapeCompartmentFigure) {
			try {
				IFigure figure = ((IFigure) ((IFigure) ((IFigure) ((IFigure) child.getChildren().get(1)).getChildren().get(0)).getChildren().get(0)).getChildren().get(0));
				return -1;
				}
			catch (Exception e) {
				return -1;
			}
		}
		else if (child instanceof ResizableCompartmentFigure) {
			try {
				IFigure figure = ((IFigure) ((IFigure) ((IFigure) ((IFigure) child.getChildren().get(1)).getChildren().get(0)).getChildren().get(0)).getChildren().get(0));
			
				if (figure instanceof Label) {
					return figure.getPreferredSize().height;
				}
				else {
					return 0;
				}
			}
			catch (Exception e) {
				return 0;
			}
		}
		else {
			return 0;
		}
	}

	/**
	 * Gets the list of children after applying the layout options of
	 * ignore invisible children & reverse children
	 */
	private List getChildren(IFigure container) {
		List children = new ArrayList(container.getChildren());
		if (getIgnoreInvisibleChildren()) {
			Iterator iter = children.iterator();
			while (iter.hasNext()) {
				IFigure f = (IFigure) iter.next();
				if (!f.isVisible())
					iter.remove();
			}
		}
		if (isReversed())
			Collections.reverse(children);
		return children;
	}

	@Override
	protected Dimension calculatePreferredSize(IFigure arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Dimension calculateMinimumSize(IFigure container, int hint, int hint2) {
		List children = getChildren(container);
		Figure child;
		Dimension minSize = new Dimension(0, 0);
		Dimension currSize = new Dimension();
		for (int i = 0; i < children.size(); i++) {
			child = (Figure) children.get(i);
			if (child instanceof WrappingLabel) {
				currSize.width = child.getPreferredSize().width;
				if (currSize.width < 57) {
					currSize.height = currSize.width;
				}
				else {
					currSize.height = 57;
				}
			}
			else {
				currSize = child.getMinimumSize();
			}
			if (currSize.width > minSize.width) {
				minSize.width = currSize.width;
			}
			if (currSize.height > minSize.height) {
				minSize.height = currSize.height;
			}
		}
		return minSize;
	}
	
}

