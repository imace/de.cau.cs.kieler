package de.cau.cs.kieler.karma;

import java.util.HashMap;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.internal.figures.BorderItemContainerFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.notation.impl.BasicCompartmentImpl;

import de.cau.cs.kieler.core.util.ICondition;
import de.cau.cs.kieler.core.util.Pair;

/**
 * Class containing generic method to update the figure and handle the notification. Used to
 * eliminate redundant code from AdvancedRenderingEditParts.
 * 
 * @author ckru
 * 
 */
public class AdvancedRenderingEditPartUtil {

    /**
     * Container for the last positive condition. Used for performance optimizations.
     */
    private ICondition<EObject> lastCondition = null;

    /**
     * The list of conditions and the corresponding string for generating the figure.
     */
    private List<HashMap<String, Object>> conditions;

    /**
     * 
     * @param theConditions
     *            The list of conditions and the corresponding string for generating the figure.
     * @param theRenderingProvider
     *            The figure provider for generating the figures from a string.
     */
    public AdvancedRenderingEditPartUtil(final List<HashMap<String, Object>> theConditions) {
        conditions = theConditions;
    }

    /**
     * 
     * @param notification
     *            the notification given to the handleNotificationEvent of the editpart.
     * @param primaryShape
     *            the primaryShape attribute of the editpart.
     * @param modelElement
     *            the modelelement of the editpart.
     * @param editPart
     *            the editpart himself.
     */
    public void handleNotificationEvent(final Notification notification,
            final IFigure primaryShape, final EObject modelElement,
            final AbstractGraphicalEditPart editPart) {
        if (!(notification.isTouch())) {
            if (primaryShape != null) {
                IFigure attrFigure = primaryShape;
                boolean changed = this.updateFigure(attrFigure, modelElement, editPart);
                if (changed) {
                    LayoutManager layoutManager = attrFigure.getLayoutManager();
                    if (layoutManager != null) {
                        layoutManager.layout(attrFigure);
                    }
                }

            }
        }
    }

    /**
     * Method to update a figure according to the conditions.
     * 
     * @param figure
     *            the figure to be updated.
     * @param modelElement
     *            the modelelement the figure belongs to.
     * @return true if the figure actually changed, false else.
     */
    public boolean updateFigure(final IFigure figure, final EObject modelElement,
            final AbstractGraphicalEditPart editPart) {
        if (conditions != null) {
            IFigure oldFigure;
            SwitchableFigure attrFigure = null;
            if ((figure instanceof SwitchableFigure)) {
                attrFigure = (SwitchableFigure) figure;
                oldFigure = attrFigure.getCurrentFigure();
            } else {
                oldFigure = figure;
            }
            IFigure newFigure = null;
            for (HashMap<String, Object> conditionElement : conditions) {
                @SuppressWarnings("unchecked")
                ICondition<EObject> condition = (ICondition<EObject>) conditionElement
                        .get("condition");

                if (condition.evaluate(modelElement)) {
                    if (lastCondition == condition) {
                        return false;
                    } else {
                        lastCondition = condition;
                        @SuppressWarnings("unchecked")
                        Pair<Integer, Integer> figureSize = (Pair<Integer, Integer>) conditionElement
                                .get("figureSize");
                        String figureParam = (String) conditionElement.get("figureParam");
                        String layoutParam = (String) conditionElement.get("layoutParam");
                        String borderItemParam = (String) conditionElement.get("borderItemParam");

                        IRenderingProvider renderingProvider = (IRenderingProvider) conditionElement
                                .get("renderingProvider");

                        // setting the new figure
                        newFigure = renderingProvider.getFigureByString(figureParam, oldFigure,
                                modelElement);
                        if (attrFigure != null && newFigure != null) {
                            attrFigure.setCurrentFigure(newFigure);
                        } else {

                        }
                        
                        // setting the LayoutManager
                        LayoutManager newLayoutManager = renderingProvider
                                .getLayoutManagerByString(layoutParam, figure.getLayoutManager(),
                                        modelElement);
                        if (newLayoutManager != null) {
                            figure.setLayoutManager(newLayoutManager);
                        }

                        // sets the new BoderItemLocator
                        if (editPart instanceof AbstractBorderItemEditPart) {
                            AbstractBorderedShapeEditPart parent = ((AbstractBorderedShapeEditPart)editPart.getParent());
                            IFigure mainFigure = parent.getMainFigure();
                            BorderedNodeFigure borderedNodeFigure = (BorderedNodeFigure) figure.getParent().getParent();
                            IBorderItemLocator newLocator = renderingProvider.getBorderItemLocatorByString(borderItemParam, mainFigure, null, modelElement);
                            if (borderedNodeFigure.getParent() != null) {
                                parent.setLayoutConstraint(editPart, borderedNodeFigure, newLocator);
                            } else {
                                lastCondition = null;
                            }
                            /*
                            if (newLocator != null && figure.getLayoutManager() != null) {
                                figure.getLayoutManager().setConstraint(figure, newLocator);
                            }
                            */
                            /*
                            BorderedNodeFigure borderedNodeFigure = (BorderedNodeFigure) ((AdvancedRenderingBorderedShapeEditPart) editPart.getParent()).getFigure();
                            BorderItemContainerFigure borderItemContainerFigure = (BorderItemContainerFigure) borderedNodeFigure.getBorderItemContainer();
                            IBorderItemLocator oldBorderItemLocator = (IBorderItemLocator) borderItemContainerFigure.getLayoutManager().getConstraint(figure.getParent().getParent());//(IBorderItemLocator) borderItemContainerFigure.getLayoutManager().getConstraint(figure);
                            IBorderItemLocator newBorderItemLocatior = renderingProvider
                                    .getBorderItemLocatorByString(borderItemParam,
                                            figure, oldBorderItemLocator);
                            if (newBorderItemLocatior != null) {
                                borderItemContainerFigure.getLayoutManager().setConstraint(figure, newBorderItemLocatior);
                            }
                            //oldBorderItemLocator = (IBorderItemLocator) figure.getParent().getLayoutManager().getConstraint(figure);
                            oldBorderItemLocator = (IBorderItemLocator) borderItemContainerFigure.getLayoutManager().getConstraint(figure);
                            int f = 7;
                            */
                        }

                        // setting a fixed node size
                        if (((figureSize.getFirst() >= 0) && (figureSize.getSecond() >= 0))
                                && attrFigure != null) {
                            setFixedNodeSize(attrFigure, figure, figureSize);
                        }
                        
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void setFixedNodeSize(SwitchableFigure attrFigure, IFigure figure, Pair<Integer, Integer> figureSize) {
        Dimension dim = new Dimension(figureSize.getFirst(),
                figureSize.getSecond());
        figure.getBounds().setSize(dim);
        figure.setMaximumSize(dim.getCopy());
        figure.setMinimumSize(dim.getCopy());
        figure.setPreferredSize(dim.getCopy());
        if (figure.getParent() instanceof DefaultSizeNodeFigure) {
            ((DefaultSizeNodeFigure) figure.getParent()).setDefaultSize(figure
                    .getSize().getCopy());
        }
        attrFigure.setResizeable(false);
    }
    
}
