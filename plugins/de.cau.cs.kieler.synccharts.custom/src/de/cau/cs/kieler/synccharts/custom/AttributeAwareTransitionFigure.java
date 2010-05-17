/*
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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

import de.cau.cs.kieler.core.ui.figures.AttributeAwareConnection;
import de.cau.cs.kieler.core.ui.figures.CircleDecoration;
import de.cau.cs.kieler.core.ui.util.FeatureValueCondition;
import de.cau.cs.kieler.core.util.CompoundCondition;
import de.cau.cs.kieler.core.util.ICondition;
import de.cau.cs.kieler.synccharts.SyncchartsPackage;
import de.cau.cs.kieler.synccharts.Transition;
import de.cau.cs.kieler.synccharts.TransitionType;

/**
 * This class represents attribute aware transition figures.
 * 
 * @kieler.rating 2010-01-27 proposed yellow msp
 * @author schm
 * @author msp
 */
public class AttributeAwareTransitionFigure extends AttributeAwareConnection {

    private static final ICondition<EObject> COND_WEAKAB = new FeatureValueCondition(
            SyncchartsPackage.eINSTANCE.getTransition_Type(),
            TransitionType.WEAKABORT);
    private static final ICondition<EObject> COND_STRONGAB = new FeatureValueCondition(
            SyncchartsPackage.eINSTANCE.getTransition_Type(),
            TransitionType.STRONGABORT);
    private static final ICondition<EObject> COND_TERMINATION = new FeatureValueCondition(
            SyncchartsPackage.eINSTANCE.getTransition_Type(),
            TransitionType.NORMALTERMINATION);
    private static final ICondition<EObject> COND_HISTORY = new FeatureValueCondition(
            SyncchartsPackage.eINSTANCE.getTransition_IsHistory(), Boolean.TRUE);

    @SuppressWarnings("unchecked")
    private static final ICondition<EObject> COND_WEAKAB_HIST = new CompoundCondition<EObject>(
            new ICondition[] { COND_WEAKAB, COND_HISTORY });
    @SuppressWarnings("unchecked")
    private static final ICondition<EObject> COND_STRONGAB_HIST = new CompoundCondition<EObject>(
            new ICondition[] { COND_STRONGAB, COND_HISTORY });
    @SuppressWarnings("unchecked")
    private static final ICondition<EObject> COND_TERMINATION_HIST = new CompoundCondition<EObject>(
            new ICondition[] { COND_TERMINATION, COND_HISTORY });

    /**
     * The constructor.
     */
    public AttributeAwareTransitionFigure() {
        super();

        this.setForegroundColor(ColorConstants.black);
        this.setBackgroundColor(ColorConstants.black);
        this.setLineWidthFloat(2.0f);

        RotatableDecoration arrowDeco = createArrowDecoration();
        RotatableDecoration weakAbortDeco = null;
        RotatableDecoration stronAbortDeco = createStrongAbortDecoration();
        RotatableDecoration terminationDeco = createTerminationDecoration();
        RotatableDecoration historyDeco = createHistoryDecoration();

        // Add all decorations with associated conditions to the figure's list
        addConditionalDecoration(weakAbortDeco, historyDeco, COND_WEAKAB_HIST);
        addConditionalDecoration(stronAbortDeco, historyDeco,
                COND_STRONGAB_HIST);
        addConditionalDecoration(terminationDeco, historyDeco,
                COND_TERMINATION_HIST);
        addConditionalDecoration(weakAbortDeco, arrowDeco, COND_WEAKAB);
        addConditionalDecoration(stronAbortDeco, arrowDeco, COND_STRONGAB);
        addConditionalDecoration(terminationDeco, arrowDeco, COND_TERMINATION);

        // Set default and current look
        setDefaultDecoration(weakAbortDeco, arrowDeco);
    }

    private static final double STRONG_ABORT_SIZE = 2.0;
    private static final double STRONG_ABORT_SCALE = 2.0;

    /**
     * Create the strong abortion decoration.
     * 
     * @return The decoration.
     */
    private static RotatableDecoration createStrongAbortDecoration() {
        PolygonDecoration circleDecoration = new CircleDecoration();
        circleDecoration.setLineWidthFloat(1.5f);
        circleDecoration.setForegroundColor(ColorConstants.black);
        circleDecoration.setBackgroundColor(ColorConstants.red);
        PointList circleDecorationPoints = new PointList();
        circleDecorationPoints.addPoint(new Point(STRONG_ABORT_SIZE,
                STRONG_ABORT_SIZE));
        circleDecorationPoints.addPoint(new Point(-STRONG_ABORT_SIZE,
                -STRONG_ABORT_SIZE));
        circleDecoration.setTemplate(circleDecorationPoints);
        circleDecoration.setScale(STRONG_ABORT_SCALE, STRONG_ABORT_SCALE);
        return circleDecoration;
    }

    private static final double TERMINATION_SIZE = 2.0;
    private static final double TERMINATION_X_SCALE = 4.0;
    private static final double TERMINATION_Y_SCALE = 2.5;

    /**
     * Create the normal termination decoration.
     * 
     * @return The decoration.
     */
    private RotatableDecoration createTerminationDecoration() {
        PolygonDecoration triangleDecoration = new PolygonDecoration();
        triangleDecoration.setLineWidthFloat(1);
        triangleDecoration.setForegroundColor(ColorConstants.black);
        triangleDecoration.setBackgroundColor(ColorConstants.green);
        PointList triangleDecorationPoints = new PointList();
        triangleDecorationPoints.addPoint(new Point(0, TERMINATION_SIZE));
        triangleDecorationPoints.addPoint(new Point(-TERMINATION_SIZE, 0));
        triangleDecorationPoints.addPoint(new Point(0, -TERMINATION_SIZE));
        triangleDecoration.setTemplate(triangleDecorationPoints);
        triangleDecoration.setScale(TERMINATION_X_SCALE, TERMINATION_Y_SCALE);
        return triangleDecoration;
    }

    private static final double ARROW_SIZE = 10;
    private static final double ARROW_X_SCALE = 1.0;
    private static final double ARROW_Y_SCALE = 0.5;

    /**
     * Create the arrow decoration.
     * 
     * @return The decoration.
     */
    private RotatableDecoration createArrowDecoration() {
        PolygonDecoration arrowDecoration = new PolygonDecoration();
        PointList arrowDecorationPoints = new PointList();
        arrowDecorationPoints.addPoint(new Point(-ARROW_SIZE, ARROW_SIZE));
        arrowDecorationPoints.addPoint(new Point(1, 0));
        arrowDecorationPoints.addPoint(new Point(-ARROW_SIZE, -ARROW_SIZE));
        arrowDecorationPoints.addPoint(new Point(-ARROW_SIZE / 2, 0));
        arrowDecoration.setTemplate(arrowDecorationPoints);
        arrowDecoration.setScale(ARROW_X_SCALE, ARROW_Y_SCALE);
        return arrowDecoration;
    }

    private static final double HISTORY_SIZE = 3;
    private static final double HISTORY_SCALE = 2.2;
    private static final float H_REL_SIZE = 0.4f;

    /**
     * Create the history decoration.
     * 
     * @return The decoration.
     */
    private RotatableDecoration createHistoryDecoration() {
        CircleDecoration historyDecoration = new CircleDecoration() {
            @Override
            protected void outlineShape(final Graphics g) {
                super.outlineShape(g);
                Rectangle bounds = getBounds();
                int hsize = (int) (H_REL_SIZE * bounds.width);
                int vsize = (int) (H_REL_SIZE * bounds.height);
                int size = hsize < vsize ? hsize : vsize;
                int topy = bounds.y + (bounds.height - size) / 2;
                int leftx = bounds.x + (bounds.width - size) / 2;
                g.setForegroundColor(ColorConstants.black);
                g.drawLine(leftx, topy, leftx, topy + size);
                g.drawLine(leftx + size, topy, leftx + size, topy + size);
                g.drawLine(leftx, topy + size / 2, leftx + size, topy + size
                        / 2);
            }
        };
        historyDecoration.setLineWidthFloat(2);
        historyDecoration.setForegroundColor(ColorConstants.black);
        historyDecoration.setBackgroundColor(ColorConstants.lightGray);
        PointList historyDecorationPoints = new PointList();
        historyDecorationPoints.addPoint(new Point(HISTORY_SIZE, HISTORY_SIZE));
        historyDecorationPoints
                .addPoint(new Point(-HISTORY_SIZE, -HISTORY_SIZE));
        historyDecoration.setTemplate(historyDecorationPoints);
        historyDecoration.setScale(HISTORY_SCALE, HISTORY_SCALE);
        return historyDecoration;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isAdapterForType(final Object type) {
        return Transition.class == type;
    }

}
