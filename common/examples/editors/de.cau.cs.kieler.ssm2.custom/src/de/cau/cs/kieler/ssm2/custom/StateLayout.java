package de.cau.cs.kieler.ssm2.custom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

import de.cau.cs.kieler.ssm2.State;

public class StateLayout extends ConstrainedToolbarLayout {

	// A layout for states
	public void layout(IFigure parent) {
		if (!parent.isVisible())
			return;
		
		List children = getChildren(parent);
		Rectangle clientArea = transposer.t(parent.getClientArea());
		int x = clientArea.x;
		int y = clientArea.y;
		int width = clientArea.width;
		int height = clientArea.height;
		
		// Check if the figure is an attribute aware state and wether it is
		// a simple or a complex state
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
	
	// The layout for complex states
	private void complexLayout(IFigure parent, List children, int x, int y, int height, int width) {
		int numChildren = children.size();
		int totalWidth = 0;
		int totalHeight = 0;
		int[] prefWidths = new int[numChildren];
		int[] prefHeights = new int[numChildren];
		Rectangle newBounds = new Rectangle();
		for (int i = 0; i < numChildren; i++) {
			Object child = children.get(i);
			if (child instanceof IFigure) {
				IFigure childFigure = (IFigure) child;
				int newWidth = childFigure.getPreferredSize().width;
				int newHeight = childFigure.getPreferredSize().height;
				prefWidths[i] = newWidth;
				prefHeights[i] = newHeight;
				totalHeight += newHeight;
				if (newWidth > totalWidth) {
					totalWidth = newWidth;
				}
			}
		}

		// Labels are centered in the upper area while compartments share the
		// rest of the space. always using the full available width
		for (int i = 0; i < numChildren; i++) {
			Object child = children.get(i);
			if (child instanceof Figure) {
				IFigure childFigure = (IFigure) child;
				if (child instanceof WrappingLabel) {
					newBounds.x = x + (width - prefWidths[i]) / 2;
					newBounds.y = y;
					newBounds.width = prefWidths[i];
					newBounds.height = prefHeights[i];
				}
				else if (child instanceof ResizableCompartmentFigure) {
					int offsetY = 0;
					for (int j = 0; j < i; j++) {
						Object child2 = children.get(j);
						if (child2 instanceof IFigure) {
							offsetY += ((IFigure) child2).getPreferredSize().height;
						}
					}
					newBounds.x = x;
					newBounds.y = y + offsetY;
					newBounds.width = width;
					newBounds.height = totalHeight - offsetY;
				}
				childFigure.setBounds(transposer.t(newBounds));
			}
		}
	}

	// The layout for simple states
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

		// The label is centered in the middle, and the compartments are arranged
		// around it
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

	// Method to decide whether a state is simple
	private boolean isSimple(State state) {
		if ((state.getRegions() == null || state.getRegions().size() == 0)
				&& (state.getSignals() == null || state.getSignals().size() == 0)
				&& (state.getEntryActions() == null || state.getEntryActions().size() == 0)
				&& (state.getInnerActions() == null || state.getInnerActions().size() == 0)
				&& (state.getExitActions() == null || state.getExitActions().size() == 0)) {
		return true;	
		}
		return false;
	}

	// Method to calculate the minimum size of the figure
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
}