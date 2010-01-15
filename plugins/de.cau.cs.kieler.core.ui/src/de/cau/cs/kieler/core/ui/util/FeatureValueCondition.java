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
package de.cau.cs.kieler.core.ui.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A condition that evaluates a feature of an EOject.
 * 
 * @author schm
 * @author msp
 */
public class FeatureValueCondition implements ICondition {

    private EStructuralFeature feature;
    private Object value;

    /**
     * Creates a feature condition.
     * 
     * @param thefeature
     *            a structural feature
     * @param thevalue
     *            the expected value of the feature
     */
    public FeatureValueCondition(final EStructuralFeature thefeature, final Object thevalue) {
        feature = thefeature;
        value = thevalue;
    }

    /**
     * {@inheritDoc}
     */
    public boolean evaluate(final Object object) {
        try {
            if (object instanceof EObject) {
                EObject modelElement = (EObject) object;
                return value.equals(modelElement.eGet(feature));
            }
        } catch (Exception e) {
            /* nothing. If an exception occurs, simply go on and return false.*/
        }
        return false;
    }

}
