package de.cau.cs.kieler.ssm2.custom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

import de.cau.cs.kieler.ssm2.State;

public class StateLayout extends ConstrainedToolbarLayout {

	public void layout(IFigure parent) {
		if (!parent.isVisible())
			return;
		
		List children = getChildren(parent);
		Rectangle clientArea = transposer.t(parent.getClientArea());
		int x = clientArea.x;
		int y = clientArea.y;
		int width = clientArea.width;
		int height = clientArea.height;
		
		if (parent instanceof AttributeAwareFigure) {
			EObject modelElement = ((AttributeAwareFigure) parent).getModelElement();
			if (modelElement instanceof State) {
				State state = (State) modelElement;
				if (isSimple(state)) {
					simpleLayout(parent, children, x, y ,height, width);
				}
				else {
					complexLayout(parent, children, x, y ,height, width);
				}
			}
		}
	}
	
	private void complexLayout(IFigure parent, List children, int x, int y, int height, int width) {
		String name;
		int prefWidth = 0;
		int prefHeight = 0;
		Rectangle newBounds = new Rectangle();
		for (Object child : children) {
			if (child instanceof WrappingLabel) {
				IFigure childFigure = (IFigure) child;
				int newWidth = childFigure.getPreferredSize().width;
				int newHeight = childFigure.getPreferredSize().height;
				if (newWidth > prefWidth) {
					prefWidth = newWidth; 
				}
				if (newHeight > prefHeight) {
					prefHeight = newHeight; 
				}
			}
		}

		for (Object child : children) {
			if (child instanceof Figure) {
				IFigure childFigure = (IFigure) child;
				if (child instanceof WrappingLabel) {
					prefWidth = childFigure.getPreferredSize().width;
					prefHeight = childFigure.getPreferredSize().height;
					newBounds.x = x + (width / 2) - (prefWidth / 2);
					newBounds.y = y;
					newBounds.width = prefWidth;
					newBounds.height = prefHeight;
				}
				else if (child instanceof ResizableCompartmentFigure) {
					name = ((ResizableCompartmentFigure) child).getCompartmentTitle();
					int offsetY = prefHeight;
					if (name.equals("RegionCompartment")) {
						offsetY += (height - prefHeight) / 2;
					}
						newBounds.x = x;
						newBounds.y = y + offsetY;
						newBounds.width = width;
						newBounds.height = (height - prefHeight) / 2;
				}
				childFigure.setBounds(transposer.t(newBounds));
			}
		}
	}

	private void simpleLayout(IFigure parent, List children, int x, int y, int height, int width) {
		String name;
		int prefWidth = 0;
		int prefHeight = 0;
		Rectangle newBounds = new Rectangle();
		for (Object child : children) {
			if (child instanceof WrappingLabel) {
				IFigure childFigure = (IFigure) child;
				int newWidth = childFigure.getPreferredSize().width;
				int newHeight = childFigure.getPreferredSize().height;
				if (newWidth > prefWidth) {
					prefWidth = newWidth; 
				}
				if (newHeight > prefHeight) {
					prefHeight = newHeight; 
				}
			}
		}

		for (Object child : children) {
			if (child instanceof Figure) {
				IFigure childFigure = (IFigure) child;
				if (child instanceof WrappingLabel) {
					prefWidth = childFigure.getPreferredSize().width;
					prefHeight = childFigure.getPreferredSize().height;
					newBounds.x = x + (width / 2) - (prefWidth / 2);
					newBounds.y = y + (height / 2) - (prefHeight / 2);
					newBounds.width = prefWidth;
					newBounds.height = prefHeight;
				}
				else if (child instanceof ResizableCompartmentFigure) {
					name = ((ResizableCompartmentFigure) child).getCompartmentTitle();
					int offsetY = 0;
					if (name.equals("RegionCompartment")) {
						offsetY = (height + prefHeight) / 2;
					}
						newBounds.x = x;
						newBounds.y = y + offsetY;
						newBounds.width = width;
						newBounds.height = (height - prefHeight) / 2;
				}
				childFigure.setBounds(transposer.t(newBounds));
			}
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

	private boolean isSimple(State state) {
		if ((state.getRegions() == null || state.getRegions().size() == 0) 
				&& (state.getEntryActions() == null || state.getEntryActions().size() == 0)
				&& (state.getInnerActions() == null || state.getInnerActions().size() == 0)
				&& (state.getExitActions() == null || state.getExitActions().size() == 0)) {
		return true;	
		}
		return false;
	}

	@Override
	public Dimension calculateMinimumSize(IFigure container, int hint, int hint2) {
		
		int minWidth = 0;
		int minHeight = 0;
		for (Object child : container.getChildren()) {
			if (child instanceof Figure) {
				IFigure childFigure = (IFigure) child;
				int newWidth = childFigure.getPreferredSize().width;
				if (newWidth > minWidth) {
					minWidth = newWidth;
				}
				minHeight += childFigure.getPreferredSize().height;
			}
		}
		return new Dimension(minWidth, minHeight);
	}
	
	@Override
	public Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {
		
		int minWidth = 0;
		int minHeight = 0;
		for (Object child : container.getChildren()) {
			if (child instanceof Figure) {
				IFigure childFigure = (IFigure) child;
				int newWidth = childFigure.getPreferredSize().width;
				if (newWidth > minWidth) {
					minWidth = newWidth;
				}
				minHeight += childFigure.getPreferredSize().height;
			}
		}
		return new Dimension(minWidth, minHeight);
	}
	
}