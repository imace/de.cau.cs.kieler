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
package de.cau.cs.kieler.graphs.custom;

import org.eclipse.emf.ecore.EPackage;

import de.cau.cs.kieler.core.ui.policies.AbstractDeletionPolicyProvider;
import de.cau.cs.kieler.graphs.impl.GraphsPackageImpl;

/**
 * This policy prevents deletion of edit parts that should not be deleted from a
 * graphs diagram.
 * 
 * @author mri
 */
public class GraphsDeletionPolicyProvider extends
        AbstractDeletionPolicyProvider {

    /**
     * {@inheritDoc}
     */
    @Override
    protected EPackage getEPackage() {
        return GraphsPackageImpl.eINSTANCE;
    }

}
