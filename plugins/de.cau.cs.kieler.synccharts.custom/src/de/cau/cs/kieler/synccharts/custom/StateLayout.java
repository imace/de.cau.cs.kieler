/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 * 
 *****************************************************************************/
package de.cau.cs.kieler.synccharts.custom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

import de.cau.cs.kieler.synccharts.State;
import de.cau.cs.kieler.synccharts.StateType;

/**
 * A special layout for states: If the state is simple, its name is written in
 * the center and the compartments are reduced in size to zero. If the state is
 * complex, the name is written on top and the compartments are laid out in a
 * column below the name.
 * 
 * @author schm
 * 
 */

public class StateLayout extends ConstrainedToolbarLayout {

    public static final int MIN_HEIGHT = 20;
    public static final int MIN_WIDTH = 20;
    public static final int COND_HEIGHT = 10;
    public static final int COND_WIDTH = 10;

    boolean containsRegions;
    boolean containsSignals;
    boolean containsVariables;
    boolean containsEntryActions;
    boolean containsInnerActions;
    boolean containsExitActions;
    boolean containsSuspensionTrigger;

    /**
     * Apply the layout.
     */
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

        // Check if the figure is an attribute aware state and whether it is
        // a simple or a complex state
        if (parent instanceof AttributeAwareFigure) {
            EObject modelElement = ((AttributeAwareFigure) parent)
                    .getModelElement();
            if (modelElement instanceof State) {
                State state = (State) modelElement;
                retrieveContents(state);
                if (state.getType().equals(StateType.CONDITIONAL)) {
                    height = 5;
                    width = 5;
                }
                // sortFigures(parent);
                if (isSimple(state)) {
                    simpleLayout(parent, children, x, y, height, width);
                } else {
                    complexLayout(parent, children, x, y, height, width);
                }
            }
        }
    }

    private void sortFigures(IFigure state) {
        List<IFigure> children = state.getChildren();
        for (int i = 0; i < children.size(); i++) {
            IFigure child = children.get(i);
            if (child instanceof Polyline) {
                // if Polyline is not the last figure in the state,
                // move it there
                if (i < (children.size() - 1)) {
                    state.remove(child);
                    state.add(child);
                }
                break;
            }
        }
    }

    /**
     * Lookup which compartments of a state have contents.
     * 
     * @param state
     *            The state to check.
     */
    // Method to lookup which compartments have contents
    private void retrieveContents(State state) {
        containsRegions = false;
        containsSignals = false;
        containsVariables = false;
        containsEntryActions = false;
        containsInnerActions = false;
        containsExitActions = false;
        containsSuspensionTrigger = false;

        if ((state.getRegions() != null && state.getRegions().size() > 0)) {
            containsRegions = true;
        }
        if ((state.getSignals() != null && state.getSignals().size() > 0)) {
            containsSignals = true;
        }
        if ((state.getEntryActions() != null && state.getEntryActions().size() > 0)) {
            containsEntryActions = true;
        }
        if ((state.getInnerActions() != null && state.getInnerActions().size() > 0)) {
            containsInnerActions = true;
        }
        if ((state.getExitActions() != null && state.getExitActions().size() > 0)) {
            containsExitActions = true;
        }
        /*
         * if ((state.getVariables() != null && state.getVariables().size() >
         * 0)) { containsVariables = true; }
         */
        if (state.getSuspensionTrigger() != null) {
            containsSuspensionTrigger = true;
        }
    }

    /**
     * Apply the layout for complex states.
     * 
     * @param parent
     *            The state figure.
     * @param children
     *            The children of the state figure.
     * @param x
     *            The x coordinate of the state figure.
     * @param y
     *            The y coordinate of the state figure.
     * @param height
     *            The height of the state figure.
     * @param width
     *            The width of the state figure.
     */
    // The layout for complex states
    private void complexLayout(IFigure parent, List children, int x, int y,
            int height, int width) {

        // Collect preferred widths and heights
        int numChildren = children.size();
        int totalWidth = 0;
        int totalHeight = 0;
        int[] prefWidths = new int[numChildren];
        int[] prefHeights = new int[numChildren];
        Rectangle newBounds = new Rectangle();
        int regionSeparatorHeight = 0;
        int regionSeparatorWidth = 0;
        for (int i = 0; i < numChildren; i++) {
            Object child = children.get(i);
            if (child instanceof IFigure && !(child instanceof Polyline)) {
                IFigure childFigure = (IFigure) child;
                int newWidth = childFigure.getPreferredSize().width;
                int newHeight = childFigure.getPreferredSize().height;
                // Empty compartments are not considered
                if (child instanceof ResizableCompartmentFigure) {
                    String compartmentName = getName((ResizableCompartmentFigure) child);
                    if ((compartmentName.equals("Signal:") && (!containsSignals))
                            || (compartmentName.equals("Variable:") && (!containsVariables))
                            || (compartmentName.equals("OnEntryAction:") && (!containsEntryActions))
                            || (compartmentName.equals("OnInsideAction:") && (!containsInnerActions))
                            || (compartmentName.equals("OnExitAction:") && (!containsExitActions))
                            || (compartmentName.equals("Suspend:") && (!containsSuspensionTrigger))) {
                        newWidth = 0;
                        newHeight = 0;
                        setCompartmentTitleVisibility(child, false);
                    } else if (!compartmentName.equals("RegionCompartment")) {
                        // Make title label visible if the compartment is not a
                        // region compartment and has more than the title label
                        // as
                        // content
                        setCompartmentTitleVisibility(child, true);
                    } else { // child is the region compartment
                        if (!containsRegions) {
                            newWidth = 0;
                            newHeight = 0;
                        }
                        // set the y position of the region separator polyline
                        // to the current
                        // calculated total height = y position of region
                        // compartment
                        regionSeparatorHeight = totalHeight;
                        // regionSeparatorWidth =
                        // ((ResizableCompartmentFigure)child).getBounds().width;
                    }
                }

                // Take maximum width and sum of heights
                prefWidths[i] = newWidth;
                prefHeights[i] = newHeight;
                totalHeight += newHeight;
                if (newWidth > totalWidth) {
                    totalWidth = newWidth;
                }
            }
        }

        // stretch if the node is larger than the
        if (totalHeight < height) {
            totalHeight = height;
        }
        if (totalWidth < width) {
            totalWidth = width;
        }

        // Labels are centered in the upper area while compartments share the
        // rest of the space, always using the full available width
        int offsetY = 0;
        for (int i = 0; i < numChildren; i++) {
            Object child = children.get(i);
            if (i > 0)
                offsetY += prefHeights[i - 1];

            if (child instanceof Polyline) {
                // handle RegionSeparator
                Polyline regionSeparator = (Polyline) child;
                PointList points = new PointList();
                Point start = new Point(1, regionSeparatorHeight);
                Point end = new Point(Math.max(0, totalWidth - 1),
                        regionSeparatorHeight);
                points.addPoint(start);
                points.addPoint(end);
                regionSeparator.setPoints(points);
            } else

            if (child instanceof Figure) {
                IFigure childFigure = (IFigure) child;
                if (child instanceof WrappingLabel) {
                    newBounds.x = x + (width - prefWidths[i]) / 2;
                    newBounds.y = y;
                    newBounds.width = prefWidths[i];
                    newBounds.height = prefHeights[i];
                    childFigure.setBounds(transposer.t(newBounds));
                } else if (child instanceof ShapeCompartmentFigure) {
                    // Leave a little border so that transition anchors
                    // can be moved freely by the user
                    newBounds.x = x + 1;
                    newBounds.y = y + offsetY;
                    if (prefWidths[i] == 0)
                        newBounds.width = 0;
                    else
                        newBounds.width = totalWidth - 2;
                    // stretch the last element over the rest space
                    if (i == (numChildren - 1))
                        newBounds.height = totalHeight - offsetY;
                    else
                        newBounds.height = prefHeights[i];
                    childFigure.setBounds(transposer.t(newBounds));
                }
            }
        }
    }

    /**
     * Set the visibility of a compartment's title label.
     * 
     * @param child
     *            The compartment.
     * @param b
     *            True if visible, false otherwise.
     */
    // Method to make the compartment's title figure invisible
    private void setCompartmentTitleVisibility(Object child, boolean b) {
        for (Object o : ((ShapeCompartmentFigure) child).getContentPane()
                .getChildren()) {
            if (o instanceof WrappingLabel) {
                ((WrappingLabel) o).setVisible(b);
            }
        }
    }

    /**
     * Retrieve the name of a compartment.
     * 
     * @param child
     *            The compartment.
     * @return The name of the compartment.
     */
    // Method to retrieve a compartment's name
    private String getName(ResizableCompartmentFigure child) {
        if ((child.getChildren() != null) && (child.getChildren().size() > 0)
                && (child.getChildren().get(0) instanceof IFigure)) {
            IFigure rcf = (IFigure) child.getChildren().get(0);
            if ((rcf.getChildren() != null) && (rcf.getChildren().size() > 0)
                    && (rcf.getChildren().get(0) instanceof WrappingLabel)) {
                WrappingLabel label = (WrappingLabel) rcf.getChildren().get(0);
                return label.getText();
            }
        }
        return "";
    }

    /**
     * Apply the layout for simple states.
     * 
     * @param parent
     *            The state figure.
     * @param children
     *            The children of the state figure.
     * @param x
     *            The x coordinate of the state figure.
     * @param y
     *            The y coordinate of the state figure.
     * @param height
     *            The height of the state figure.
     * @param width
     *            The width of the state figure.
     */
    // The layout for simple states
    private void simpleLayout(IFigure parent, List children, int x, int y,
            int height, int width) {
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

        // The label is centered in the middle, and the compartments are hidden
        // by setting their size to 0
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
                } else if (child instanceof ResizableCompartmentFigure) {
                    name = ((ResizableCompartmentFigure) child)
                            .getCompartmentTitle();
                    int offsetY = 0;
                    newBounds.x = x;
                    newBounds.y = y;
                    newBounds.width = 0;
                    newBounds.height = 0;
                } else if (child instanceof Polyline) {
                    // hide region separator line by setting an empty point list
                    ((Polyline) child).setPoints(new PointList());
                }

                childFigure.setBounds(transposer.t(newBounds));

            }
        }
    }

    /**
     * Gets the list of children after applying the layout options of ignore
     * invisible children & reverse children
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

    /**
     * Check whether a state is simple.
     * 
     * @param state
     *            The state to check.
     * @return True if simple, false otherwise.
     */
    // Method to decide whether a state is simple
    private boolean isSimple(State state) {
        if ((state.getRegions() == null || state.getRegions().size() == 0)
                && (state.getSignals() == null || state.getSignals().size() == 0)
                && (state.getEntryActions() == null || state.getEntryActions()
                        .size() == 0)
                && (state.getInnerActions() == null || state.getInnerActions()
                        .size() == 0)
                && (state.getExitActions() == null || state.getExitActions()
                        .size() == 0) && (state.getSuspensionTrigger() == null)) {
            return true;
        }
        return false;
    }

    /**
     * Returns the minimum size of the figure.
     * 
     * @return The minimum size of the figure.
     */
    // The minimum size of a simple state is 40x40 pixels
    // The minimum height of complex states is the sum of
    // all its children's minimum heights, while its minimum
    // width is the maximum of all its children's minimum sizes;
    // however, empty compartments are not considered.
    @Override
    public Dimension calculateMinimumSize(IFigure parent, int hint, int hint2) {
        EObject modelElement = ((AttributeAwareFigure) parent)
                .getModelElement();
        int prefWidth = 0;// super.getMinimumSize(hint, hint2).width;
        int prefHeight = 0;
        if (modelElement instanceof State) {
            State state = (State) modelElement;

            List<Object> children = parent.getChildren();
            int numChildren = children.size();

            if (state.getType().equals(StateType.CONDITIONAL)) {
                return new Dimension(StateLayout.COND_WIDTH,
                        StateLayout.COND_HEIGHT);
            }
            if (isSimple(state)) {
                Object child = children.get(0);
                // set the min size of a state with a label
                // increase the size abit such that the text looks proper even
                // for a final state
                if (child != null && child instanceof WrappingLabel
                        && ((WrappingLabel) child).getText() != null
                        && !((WrappingLabel) child).getText().equals("")) {
                    return new Dimension(((WrappingLabel) children.get(0))
                            .getPreferredSize().width,
                            StateLayout.MIN_HEIGHT + 2);
                } else {
                    return new Dimension(StateLayout.MIN_WIDTH,
                            StateLayout.MIN_WIDTH);
                }
            } else {

                // Lookup, which compartments contain contents
                retrieveContents(state);

                for (int i = 0; i < numChildren; i++) {
                    Object child = children.get(i);
                    if (child instanceof IFigure
                            && !(child instanceof Polyline)) {
                        IFigure childFigure = (IFigure) child;
                        if (!(child instanceof ShapeCompartmentFigure)
                                || !getName((ShapeCompartmentFigure) child)
                                        .equals("RegionCompartment")) {
                            Rectangle childBounds = childFigure.getBounds();
                            // if we have manually set the bounds to zero,
                            // ignore
                            // the bounds for min size calculations
                            if (childBounds.height == 0
                                    || childBounds.width == 0) {
                                continue;
                            }
                            Dimension preferredSize = childFigure
                                    .getPreferredSize();
                            if (preferredSize.width > prefWidth) {
                                // add 1 pixel to avoid scroll bars (this was
                                // added during layout above)
                                prefWidth = preferredSize.width + 1;
                            }
                            prefHeight += preferredSize.height;
                        } else if (child instanceof ShapeCompartmentFigure) {
                            // child is the region compartment
                            // add a default minimum size so that the region
                            // compartment
                            // is visible after all
                            prefHeight += StateLayout.MIN_HEIGHT;
                        }
                    }
                }
            }
        }
        return new Dimension(prefWidth, prefHeight);

    }

    /**
     * Calculate the minimum size of the figure.
     */
    // Method to calculate the minimum size of a figure
    // @Override
    // public Dimension calculateMinimumSize(IFigure parent, int hint, int
    // hint2) {
    //
    // int minWidth = 0;
    // int minHeight = 0;
    // for (Object child : parent.getChildren()) {
    // if (child instanceof IFigure && ! (child instanceof Polyline)
    // && !(child instanceof ShapeCompartmentFigure)) {
    // IFigure childFigure = (IFigure) child;
    // int newWidth = childFigure.getPreferredSize().width;
    // if (newWidth > minWidth) {
    // minWidth = newWidth;
    // }
    // minHeight += childFigure.getPreferredSize().height;
    // }
    // }
    //
    // // simple states can be made smaller in height than the compartments
    // // would allow
    // if (parent instanceof AttributeAwareFigure) {
    // EObject modelElement = ((AttributeAwareFigure) parent)
    // .getModelElement();
    // if (modelElement instanceof State) {
    // State state = (State) modelElement;
    // if (isSimple(state)) {
    // minHeight = MIN_HEIGHT;
    // if (minWidth < MIN_WIDTH) {
    // minWidth = MIN_WIDTH;
    // }
    // if (state.getType().equals(StateType.CONDITIONAL)) {
    // minHeight = COND_HEIGHT;
    // minWidth = COND_WIDTH;
    // }
    // }
    // }
    // }
    //
    // return new Dimension(minWidth, minHeight);
    // }

    /**
     * Calculate the preferred size of the figure.
     */
    // Method to calculate the preferred size of a figure
    @Override
    protected Dimension calculatePreferredSize(IFigure parent, int hint,
            int hint2) {

        // The height of simple states is reduced,
        // the height of complex states considers only
        // the compartments with contents
        if (parent instanceof AttributeAwareFigure) {
            EObject modelElement = ((AttributeAwareFigure) parent)
                    .getModelElement();
            if (modelElement instanceof State) {
                State state = (State) modelElement;
                if (isSimple(state)) {
                    Dimension newDimension = super.calculatePreferredSize(
                            parent, hint, hint2);
                    newDimension.height = MIN_HEIGHT;
                    return newDimension;
                }
            }
        }
        return super.calculatePreferredSize(parent, hint, hint2);
    }
}
