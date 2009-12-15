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

import java.util.List;

import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

/**
 * This class represents invisible figures, which usually serve as container for
 * labels.
 * 
 * @author schm
 */
public class AttributeAwareInvisibleFigure extends AttributeAwareFigure {

    /**
     * The constructor. The figure for figures that are not supposed to be seen,
     * such as the background figures needed for signal and action labels; actually
     * they do not need to be attribute aware, but if they were not, the code
     * templates would not work since we cannot distinguish different classes in
     * code templates (at least I can't).
     * 
     * @param e The edit part the figure is supposed to watch.
     */
    public AttributeAwareInvisibleFigure(final EditPart e) {
        super();
        this.setModelElementAndRegisterFromEditPart(e);

        RoundedRectangle invisibleFigure = new RoundedRectangle();
        invisibleFigure.setFill(false);
        invisibleFigure.setOutline(false);

        this.setDefaultFigure(invisibleFigure);
        this.setCurrentFigure(invisibleFigure);

    }

    /**
     * The constructor without the edit part. Use this if you do not want your
     * figure to be attribute aware.
     */
    public AttributeAwareInvisibleFigure() {
        super();

        RoundedRectangle invisibleFigure = new RoundedRectangle();
        invisibleFigure.setFill(false);
        invisibleFigure.setOutline(false);

        this.setDefaultFigure(invisibleFigure);
        this.setCurrentFigure(invisibleFigure);

    }

    private static final int WIDTH_GROW = 5;
    
    /**
     * Return the preferred size of the figure. This is usually a size that is
     * big enough to contain all its inner elements. The preferred size of the
     * invisible figure is the maximum preferred size of all its child labels.
     * 
     * @param hint width hint
     * @param hint2 height hint
     * @return The preferred size of the figure.
     */
    @Override
    public Dimension getPreferredSize(final int hint, final int hint2) {
        List<?> children = this.getChildren();
        Dimension prefSize = new Dimension();
        for (Object child : children) {
            if (child instanceof WrappingLabel) {
                WrappingLabel label = (WrappingLabel) child;
                int width = label.getPreferredSize().width + WIDTH_GROW;
                int height = label.getPreferredSize().height;
                if (width > prefSize.width) {
                    prefSize.width = width;
                }
                if (width > prefSize.height) {
                    prefSize.height = height;
                }
            }
        }
        return prefSize;
    }

    /**
     * Return the minimum size of the figure. Here it is the same as the
     * preferred size.
     * 
     * @param hint width hint
     * @param hint2 height hint
     * @return The minimum size of the figure.
     */
    @Override
    public Dimension getMinimumSize(final int hint, final int hint2) {
        return getPreferredSize();
    }

    /**
     * {@inheritDoc}
     */
    public boolean isAdapterForType(final Object type) {
        return false;
    }
    
}
