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
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;

import de.cau.cs.kieler.core.ui.figures.AttributeAwareSwitchFigure;
import de.cau.cs.kieler.core.ui.figures.DoubleRoundedRectangle;
import de.cau.cs.kieler.core.ui.util.FeatureValueCondition;
import de.cau.cs.kieler.core.ui.util.ListSizeCondition;
import de.cau.cs.kieler.core.util.CompoundCondition;
import de.cau.cs.kieler.core.util.ICondition;
import de.cau.cs.kieler.synccharts.State;
import de.cau.cs.kieler.synccharts.StateType;
import de.cau.cs.kieler.synccharts.SyncchartsPackage;

/**
 * This class represents attribute aware state figures.
 * 
 * @kieler.rating 2010-01-27 proposed yellow msp
 * @author schm
 * @author msp
 */
public class AttributeAwareStateFigure extends AttributeAwareSwitchFigure {

    /** line width for initial states. */
    private static final float INIT_LINE_WIDTH = 4.0f;

    private static final ICondition<EObject> COND_NORMAL = new FeatureValueCondition(
            SyncchartsPackage.eINSTANCE.getState_Type(), StateType.NORMAL);
    private static final ICondition<EObject> COND_CONDITIONAL = new FeatureValueCondition(
            SyncchartsPackage.eINSTANCE.getState_Type(), StateType.CONDITIONAL);
    private static final ICondition<EObject> COND_REFERENCE = new FeatureValueCondition(
            SyncchartsPackage.eINSTANCE.getState_Type(), StateType.REFERENCE);
    private static final ICondition<EObject> COND_TEXTUAL = new FeatureValueCondition(
            SyncchartsPackage.eINSTANCE.getState_Type(), StateType.TEXTUAL);

    private static final ICondition<EObject> COND_IS_INITIAL = new FeatureValueCondition(
            SyncchartsPackage.eINSTANCE.getState_IsInitial(), true);
    private static final ICondition<EObject> COND_IS_FINAL = new FeatureValueCondition(
            SyncchartsPackage.eINSTANCE.getState_IsFinal(), true);
    private static final ICondition<EObject> COND_NOT_INITIAL = new FeatureValueCondition(
            SyncchartsPackage.eINSTANCE.getState_IsInitial(), false);
    private static final ICondition<EObject> COND_NOT_FINAL = new FeatureValueCondition(
            SyncchartsPackage.eINSTANCE.getState_IsFinal(), false);
    private static final ICondition<EObject> COND_INITIAL = new CompoundCondition<EObject>(
            new ICondition[] { COND_IS_INITIAL, COND_NOT_FINAL });
    private static final ICondition<EObject> COND_FINAL = new CompoundCondition<EObject>(
            new ICondition[] { COND_NOT_INITIAL, COND_IS_FINAL });

    @SuppressWarnings("unchecked")
    private static final ICondition<EObject> COND_INITIAL_FINAL = new CompoundCondition<EObject>(
            new ICondition[] { COND_IS_INITIAL, COND_IS_FINAL });

    private static final ICondition<EObject> COND_NOREGIONS = new ListSizeCondition(
            SyncchartsPackage.eINSTANCE.getState_Regions(), 0);
    private static final ICondition<EObject> COND_NOSIGNALS = new ListSizeCondition(
            SyncchartsPackage.eINSTANCE.getState_Signals(), 0);
    private static final ICondition<EObject> COND_NOENTRYACT = new ListSizeCondition(
            SyncchartsPackage.eINSTANCE.getState_EntryActions(), 0);
    private static final ICondition<EObject> COND_NOINSIDEACT = new ListSizeCondition(
            SyncchartsPackage.eINSTANCE.getState_InnerActions(), 0);
    private static final ICondition<EObject> COND_NOEXITACT = new ListSizeCondition(
            SyncchartsPackage.eINSTANCE.getState_ExitActions(), 0);

    @SuppressWarnings("unchecked")
    private static final ICondition<EObject> COND_SIMPLE = new CompoundCondition<EObject>(
            new ICondition[] { COND_NORMAL, COND_NOREGIONS, COND_NOSIGNALS,
                    COND_NOENTRYACT, COND_NOINSIDEACT, COND_NOEXITACT });
    @SuppressWarnings("unchecked")
    private static final ICondition<EObject> COND_SIMPLE_INITIAL = new CompoundCondition<EObject>(
            new ICondition[] { COND_INITIAL, COND_SIMPLE });
    @SuppressWarnings("unchecked")
    private static final ICondition<EObject> COND_SIMPLE_FINAL = new CompoundCondition<EObject>(
            new ICondition[] { COND_FINAL, COND_SIMPLE });

    private static final ICondition<EObject> COND_SIMPLE_INITIAL_FINAL = new CompoundCondition<EObject>(
            new ICondition[] { COND_INITIAL_FINAL, COND_SIMPLE });

    /**
     * The constructor.
     */
    public AttributeAwareStateFigure() {
        super();

        // Create all needed figures
        IFigure normalFigure = createNormalFigure();
        IFigure initialFigure = createInitialFigure();
        IFigure finalFigure = createFinalFigure();
        IFigure conditionalFigure = new ConditionalStateFigure();
        /* create even more normal figures to trigger layoutmanager via 
         * notifyChanged if statetype changed */
        IFigure referenceFigure = createNormalFigure();
        IFigure textualfigure = createNormalFigure();
        IFigure initialFinalFigure = createInitialFinalFigure();

        // Set default and current figure
        setDefaultFigure(normalFigure);

        // Add all conditional figures to the list
        // note: the order in this list is crucial. Add most special cases
        // first.
        addConditionalFigure(conditionalFigure, COND_CONDITIONAL);
        addConditionalFigure(initialFinalFigure, COND_INITIAL_FINAL);
        addConditionalFigure(initialFinalFigure, COND_SIMPLE_INITIAL_FINAL);
        addConditionalFigure(initialFigure, COND_SIMPLE_INITIAL);
        addConditionalFigure(initialFigure, COND_INITIAL);
        addConditionalFigure(finalFigure, COND_SIMPLE_FINAL);
        addConditionalFigure(finalFigure, COND_FINAL);
        addConditionalFigure(referenceFigure, COND_REFERENCE);
        addConditionalFigure(textualfigure, COND_TEXTUAL);
        addConditionalFigure(normalFigure, COND_SIMPLE);
    }

    /**
     * Create a figure for states that are both final and initial.
     * 
     * @return a figure for states that are both final and initial
     */
    private IFigure createInitialFinalFigure() {
        RoundedRectangle figure = new DoubleRoundedRectangle();
        figure.setCornerDimensions(new Dimension(StateLayout.MIN_WIDTH,
                StateLayout.MIN_HEIGHT));
        figure.setFill(false);
        // figure.setLineWidth(2);
        figure.setLineWidthFloat(2.25f);
        figure.setForegroundColor(ColorConstants.black);
        return figure;
    }

    /**
     * Create a figure for normal states.
     * 
     * @return a figure for normal states
     */
    private IFigure createNormalFigure() {
        RoundedRectangle figure = new RoundedRectangle();
        figure.setCornerDimensions(new Dimension(StateLayout.MIN_WIDTH,
                StateLayout.MIN_HEIGHT));
        figure.setFill(false);
        figure.setLineWidthFloat(1.0f);
        figure.setForegroundColor(ColorConstants.black);
        return figure;
    }

    /**
     * Create a figure for initial states.
     * 
     * @return a figure for initial states.
     */
    private IFigure createInitialFigure() {
        RoundedRectangle figure = new RoundedRectangle();
        figure.setCornerDimensions(new Dimension(StateLayout.MIN_WIDTH,
                StateLayout.MIN_HEIGHT));
        figure.setFill(false);
        figure.setLineWidthFloat(INIT_LINE_WIDTH);
        figure.setForegroundColor(ColorConstants.black);
        return figure;
    }

    /**
     * Create a figure for final states.
     * 
     * @return a figure for final states
     */
    private IFigure createFinalFigure() {
        RoundedRectangle figure = new DoubleRoundedRectangle();
        figure.setCornerDimensions(new Dimension(StateLayout.MIN_WIDTH,
                StateLayout.MIN_HEIGHT));
        figure.setFill(false);
        figure.setLineWidthFloat(1.0f);
        figure.setForegroundColor(ColorConstants.black);
        return figure;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isAdapterForType(final Object type) {
        return State.class == type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBounds(final Rectangle rect) {
        Notifier target = getTarget();
        LayoutManager layoutManager = getLayoutManager();
        if (target instanceof State && layoutManager instanceof StateLayout) {
            ((StateLayout) layoutManager).checkNewSize(this, (State) target,
                    rect);
        }
        super.setBounds(rect);
    }

    /**
     * Directly set the bounds of this figure, without further checks.
     * 
     * @param rect
     *            the new bounds
     */
    public void setBoundsDirect(final Rectangle rect) {
        super.setBounds(rect);
    }

}
