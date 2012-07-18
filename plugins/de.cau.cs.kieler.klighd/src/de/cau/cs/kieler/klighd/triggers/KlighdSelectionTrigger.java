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
package de.cau.cs.kieler.klighd.triggers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import de.cau.cs.kieler.core.kivi.AbstractTrigger;
import de.cau.cs.kieler.core.kivi.ITrigger;
import de.cau.cs.kieler.klighd.IViewer;
import de.cau.cs.kieler.klighd.ViewContext;

/**
 * A view management trigger which listens on the selection of diagram elements in KLighD diagrams.
 * 
 * @author mri
 */
public class KlighdSelectionTrigger extends AbstractTrigger {

    /** the trigger instance. */
    private static KlighdSelectionTrigger instance = null;

    /**
     * Returns the trigger instance.
     * 
     * @return the instance of this trigger
     */
    public static KlighdSelectionTrigger getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void register() {
        instance = this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void unregister() {
        instance = null;
    }

    /**
     * The state generated by a selection trigger. Contains information about the selected diagram
     * element and it's represented model element.
     */
    public static class KlighdSelectionState extends AbstractKlighdTriggerState {

        /** the selection elements. */
        private List<SelectionElement> selections;

        /**
         * Constructs a selection state with default values.
         */
        public KlighdSelectionState() {
            // no selections
            selections = Lists.newLinkedList();
        }

        /**
         * Constructs a selection state with a given list of diagram elements and the represented
         * model elements which have been selected.
         * 
         * @param viewId
         *            the id of the view associated with the selection
         * @param viewContext
         *            the view context in which the selection occurred
         * @param viewer
         *            the viewer in which the selection occurred
         * @param selections
         *            a list of selection elements
         */
        public KlighdSelectionState(final String viewId, final ViewContext viewContext,
                final IViewer<?> viewer, final List<SelectionElement> selections) {
            super(viewId, viewContext, viewer);
            this.selections = selections;
        }

        /**
         * Returns the selection elements.
         * 
         * @return the selection elements
         */
        public List<SelectionElement> getSelections() {
            return selections;
        }
        
        public List<Object> getSelectedModelElements() {
            return Lists.transform(selections, new Function<SelectionElement, Object>() {
                public Object apply(SelectionElement input) {                   
                    return input.getModelElement();
                }
            });
        }

        public List<EObject> getSelectedEModelElements() {
            return Lists.transform(selections, new Function<SelectionElement, EObject>() {
                public EObject apply(SelectionElement input) {
                    return input.getModelElement() instanceof EObject ?
                            (EObject) input.getModelElement() : null;
                }
            });
        }

        /**
         * {@inheritDoc}
         */
        public Class<? extends ITrigger> getTriggerClass() {
            return KlighdSelectionTrigger.class;
        }

        /**
         * A class for representing the pair of a diagram element and the model element it's
         * representing.
         */
        public class SelectionElement {

            /** the diagram element. */
            private Object diagramElement;
            /** the model element. */
            private Object modelElement = null;

            /**
             * Constructs a selection element.
             * 
             * @param diagramElement
             *            the diagram element
             */
            public SelectionElement(final Object diagramElement) {
                this.diagramElement = diagramElement;
            }

            /**
             * Returns the diagram element.
             * 
             * @return the diagram element
             */
            public Object getDiagramElement() {
                return diagramElement;
            }

            /**
             * Returns the model element.
             * 
             * @return the model element
             */
            public Object getModelElement() {
                // lazy
                if (modelElement == null && getViewContext() != null) {
                    modelElement = getViewContext().getSourceElement(diagramElement);
                }
                return modelElement;
            }

        }

    }

}
