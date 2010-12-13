/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kaom.graphiti.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import de.cau.cs.kieler.kaom.Link;

/**
 * Feature for enabling direct editing of the name of links.
 * 
 * @author atr
 */
public class DirectEditLinkFeature extends AbstractDirectEditingFeature {

    /**
     * The constructor.
     * 
     * @param fp the feature provider
     */
    public DirectEditLinkFeature(final IFeatureProvider fp) {
        super(fp);
    }

    /**
     * {@inheritDoc}
     */
    public int getEditingType() {
        return TYPE_TEXT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canDirectEdit(final IDirectEditingContext context) {
        Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
        GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
        return (bo instanceof Link && ga instanceof Text);
    }

    /**
     * {@inheritDoc}
     */
    public String getInitialValue(final IDirectEditingContext context) {
        Object object = getBusinessObjectForPictogramElement(context.getPictogramElement());
        if (object instanceof Link) {
            return ((Link) object).getName();
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(final String value, final IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Object obj = getBusinessObjectForPictogramElement(pe);
        if (obj instanceof Link) {
            Link link = (Link) obj;
            link.setName(value);
            updatePictogramElement(((ConnectionDecorator) pe).getContainer());
        }
    }
    
}
