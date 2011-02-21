/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.synccharts.diagram.custom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.cau.cs.kieler.core.annotations.Annotation;
import de.cau.cs.kieler.kiml.LayoutOptionData;
import de.cau.cs.kieler.kiml.LayoutServices;
import de.cau.cs.kieler.kiml.SemanticLayoutConfig;
import de.cau.cs.kieler.kiml.options.Direction;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.synccharts.Region;
import de.cau.cs.kieler.synccharts.Scope;

/**
 * A layout configuration that applies alternating horizontal / vertical layout when an
 * annotation "HVLayout" is present.
 *
 * @author msp
 */
public class HVLayoutConfig extends SemanticLayoutConfig {
    
    /** the name of the annotation that must be present to activate this config. */
    public static final String HV_ANNOTATION = "HVLayout";

    /**
     * Calculate the minimal distance in the parent hierarchy to a parent that has the
     * HV layout annotation.
     * 
     * @param scope the current scope
     * @return distance to a HV layout annotation
     */
    private int getHVDistance(final Scope scope) {
        Annotation annotation = scope.getAnnotation(HV_ANNOTATION);
        if (annotation != null) {
            return 0;
        } else if (scope.eContainer() instanceof Scope) {
            Scope parent = (Scope) scope.eContainer();
            int parentDist = getHVDistance(parent);
            if (parentDist >= 0 && parent instanceof Region) {
                return parentDist + 1;
            } else {
                return parentDist;
            }
        }
        return -1;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected List<LayoutOptionData<?>> getOptionData(final EObject semanticElem) {
        if (semanticElem instanceof Scope && getHVDistance((Scope) semanticElem) >= 0) {
            LayoutOptionData<?> optionData = LayoutServices.getInstance()
                    .getOptionData(LayoutOptions.DIRECTION_ID);
            List<LayoutOptionData<?>> list = new ArrayList<LayoutOptionData<?>>(1);
            list.add(optionData);
            return list;
        }
        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object getSemanticProperty(final EObject semanticElem,
            final LayoutOptionData<?> layoutOption) {
        if (semanticElem instanceof Scope && layoutOption.getId()
                .equals(LayoutOptions.DIRECTION_ID)) {
            int dist = getHVDistance((Scope) semanticElem);
            if (dist >= 0) {
                if (dist % 2 == 0) {
                    return Direction.RIGHT;
                } else {
                    return Direction.DOWN;
                }
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setSemanticProperty(final EObject semanticElem,
            final LayoutOptionData<?> layoutOption, final Object value) {
        // not supported by this layout configuration
    }

}
