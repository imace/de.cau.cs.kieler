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
package de.cau.cs.kieler.kies.transformation.kivi;

import java.util.concurrent.Semaphore;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.xtend.XtendFacade;

import de.cau.cs.kieler.core.kivi.AbstractTrigger;
import de.cau.cs.kieler.core.kivi.AbstractTriggerState;
import de.cau.cs.kieler.core.kivi.ITrigger;
import de.cau.cs.kieler.kies.transformation.core.TransformationDescriptor;

/**
 * @author uru
 * 
 */
public class TransformationTrigger extends AbstractTrigger {

    private static TransformationTrigger instance;

    /**
     * default constructor.
     */
    public TransformationTrigger() {
        instance = this;
    }

    /**
     * faux singleton.
     * 
     * @return instance
     */
    public static TransformationTrigger getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void register() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void unregister() {
    }

    /**
     * initiates a transformation.
     * 
     * @param facade
     *            the xtendfacade
     * @param theTransformationName
     *            name of the transformation to run.
     * @param theParameters
     *            parameters to pass.
     * @param theEditingDomain
     *            editing domain in which the transformation should be performed.
     */
    public void step(final XtendFacade facade, final TransformationDescriptor descriptor,
            final TransactionalEditingDomain theEditingDomain, final Semaphore aSem) {
        trigger(new TransformationState(facade, descriptor, theEditingDomain, aSem));
    }

    /**
     * 
     * @author uru
     * 
     */
    public static final class TransformationState extends AbstractTriggerState {

        private XtendFacade xtendFacade;
        private TransformationDescriptor descriptor;
        private TransactionalEditingDomain editingDomain;
        private Semaphore semaphore;

        /**
         * Default Constructor.
         */
        public TransformationState() {
        }

        /**
         * @param facade
         *            the xtendfacade
         * @param theTransformationName
         *            name of the transformation to run.
         * @param theParameters
         *            parameters to pass.
         * @param theEditingDomain
         *            editing domain in which the transformation should be performed.
         */
        public TransformationState(final XtendFacade facade,
                final TransformationDescriptor theDescriptor,
                final TransactionalEditingDomain theEditingDomain, final Semaphore aSem) {
            super();
            this.xtendFacade = facade;
            this.editingDomain = theEditingDomain;
            this.semaphore = aSem;
        }

        /**
         * @return the xtendFacade
         */
        public XtendFacade getXtendFacade() {
            return xtendFacade;
        }

        /**
         * @return the descriptor
         */
        public TransformationDescriptor getDescriptor() {
            return descriptor;
        }

        /**
         * @return the editingDomain
         */
        public TransactionalEditingDomain getEditingDomain() {
            return editingDomain;
        }

        /**
         * @return the semaphore
         */
        public Semaphore getSemaphore() {
            return semaphore;
        }

        /**
         * {@inheritDoc}
         */
        public Class<? extends ITrigger> getTriggerClass() {
            return TransformationTrigger.class;
        }

    }

}
