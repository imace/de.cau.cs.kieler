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
package de.cau.cs.kieler.klighd.viewers;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import de.cau.cs.kieler.klighd.IViewer;
import de.cau.cs.kieler.klighd.IViewerEvent;
import de.cau.cs.kieler.klighd.IViewerEventListener;
import de.cau.cs.kieler.klighd.IViewerProvider;
import de.cau.cs.kieler.klighd.KlighdColor;
import de.cau.cs.kieler.klighd.ViewContext;
import de.cau.cs.kieler.klighd.events.SelectionEvent;
import de.cau.cs.kieler.klighd.triggers.KlighdSelectionTrigger;
import de.cau.cs.kieler.klighd.triggers.KlighdSelectionTrigger.KlighdSelectionState;
import de.cau.cs.kieler.klighd.triggers.KlighdSelectionTrigger.KlighdSelectionState.SelectionElement;

/**
 * A viewer for instances of type {@code ViewContext}. This viewer acts as a wrapper for the viewer
 * supplied by the current view context. The method {@code getControl} returns the control for that
 * viewer and all other methods are delegated to the wrapped viewer.<br>
 * <br>
 * If a model is set that is not of type {@code ViewContext} but is supported by the currently
 * wrapped viewer it is set as model for that viewer instead.<br>
 * <br>
 * In addition it is possible to set a message to be shown instead of a view context, the wrapped
 * viewer is then of type {@code StringViewer}.<br>
 * <br>
 * This viewer also implements the {@code ISelectionProvider} interface and acts as the KLighD view
 * provider for selection events.
 * 
 * @author mri
 */
public class ContextViewer extends AbstractViewer<Object> implements IViewerEventListener,
        ISelectionProvider {

    /** the parent composite. */
    private Composite parent;
    /** the id of the view this viewer belongs to. */
    private String viewId;
    /** the current viewer. */
    private IViewer<Object> currentViewer;
    /** the current view context. */
    private ViewContext currentViewContext = null;
    /** the selection listeners registered on this view. */
    private Set<ISelectionChangedListener> selectionListeners =
            new LinkedHashSet<ISelectionChangedListener>();
    /** the current selection. */
    private Selection selection = new Selection();

    /**
     * Constructs a view context viewer.
     * 
     * @param parent
     *            the parent composite
     * @param viewId
     *            the id of the view this viewer belongs to
     */
    public ContextViewer(final Composite parent, final String viewId) {
        this.parent = parent;
        this.viewId = viewId;
    }

    /**
     * {@inheritDoc}
     */
    public Control getControl() {
        return currentViewer.getControl();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public synchronized void setModel(final Object model) {
        // if the model is a view context adapt the viewer to the given context, else set it as
        // input model for the current viewer if possible or show it if it is a string
        if (model instanceof ViewContext) {
            ViewContext viewContext = (ViewContext) model;
            if (currentViewContext == null
                    || currentViewContext.getViewerProvider() != viewContext.getViewerProvider()) {
                // remove the old viewer
                removeViewer();
                // create the new viewer from the view context
                IViewerProvider viewerProvider = viewContext.getViewerProvider();
                IViewer<Object> viewer = (IViewer<Object>) viewerProvider.createViewer(parent);
                // add the new viewer
                addViewer(viewer);
            }
            // set the new view context
            currentViewContext = viewContext;
            // set the model
            currentViewer.setModel(viewContext.getModel());
            // reset the current selection
            resetSelection();
        } else if (currentViewContext != null
                && currentViewContext.getViewerProvider().supports(model)) {
            // if the current viewer supports the given model set it as new input model
            currentViewer.setModel(model);
            // reset the current selection
            resetSelection();
        } else if (model instanceof String) {
            // if the model is a string show it
            showMessage((String) model);
            // reset the current selection
            resetSelection();
        }
    }

    /**
     * Shows the given message.
     * 
     * @param message
     *            the message
     */
    public synchronized void showMessage(final String message) {
        if (!((IViewer<?>) currentViewer instanceof StringViewer)) {
            removeViewer();
            addViewer(new StringViewer(parent));
        }
        currentViewer.setModel(message);
    }

    @SuppressWarnings("unchecked")
    private synchronized void addViewer(final IViewer<?> viewer) {
        currentViewer = (IViewer<Object>) viewer;
        parent.layout();
        currentViewer.addEventListener(this);
    }

    private synchronized void removeViewer() {
        if (currentViewer != null) {
            currentViewer.removeEventListener(this);
            currentViewer.getControl().dispose();
            currentViewer = null;
            currentViewContext = null;
        }
    }

    /**
     * {@inheritDoc}
     */
    public synchronized void handleEvent(final IViewerEvent event) {
        // call method to handle the specific event
        if (event instanceof SelectionEvent) {
            handleSelectionEvent((SelectionEvent) event);
        }
        // propagate event to listeners on this viewer
        notifyListeners(event);
    }

    private void handleSelectionEvent(final SelectionEvent selectionEvent) {
        KlighdSelectionTrigger trigger = KlighdSelectionTrigger.getInstance();
        if (trigger != null) {
            // create the selection objects
            List<SelectionElement> selections = new LinkedList<SelectionElement>();
            // create the selection state
            KlighdSelectionState state =
                    new KlighdSelectionState(viewId, currentViewContext, currentViewer, selections);
            // fill the selection
            for (Object diagramObject : selectionEvent.getDiagramElements()) {
                selections.add(state.new SelectionElement(diagramObject));
            }
            trigger.trigger(state);
        }
        // update the selection status for the ISelectionProvider interface
        updateSelection(selectionEvent);
    }

    private void updateSelection(final SelectionEvent selectionEvent) {
        synchronized (selection) {
            selection.selectedElements.clear();
            selection.selectedElements.addAll(selectionEvent.getDiagramElements());
        }
        notifySelectionListeners();
    }

    private void resetSelection() {
        synchronized (selection) {
            selection.selectedElements.clear();
        }
        notifySelectionListeners();
    }

    private void notifySelectionListeners() {
        synchronized (selectionListeners) {
            if (selectionListeners.size() > 0) {
                // create a clone of the selection
                Selection clone;
                synchronized (selection) {
                    clone = selection.clone();
                }
                // notify all selection listeners
                for (ISelectionChangedListener listener : selectionListeners) {
                    listener.selectionChanged(new SelectionChangedEvent(this, clone));
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public ISelection getSelection() {
        synchronized (selection) {
            return selection.clone();
        }
    }

    /**
     * {@inheritDoc}
     */
    public void setSelection(final ISelection selection) {
        // not supported yet
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHighlight(final Object[] diagramElements, final KlighdColor foreground,
            final KlighdColor background, final float lineWidthFactor) {
        if (currentViewer != null) {
            currentViewer.setHighlight(diagramElements, foreground, background, lineWidthFactor);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeHighlight(final Object[] diagramElements) {
        if (currentViewer != null) {
            currentViewer.removeHighlight(diagramElements);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void select(final Object[] diagramElements) {
        if (currentViewer != null) {
            currentViewer.select(diagramElements);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void unselect(final Object[] diagramElements) {
        if (currentViewer != null) {
            currentViewer.unselect(diagramElements);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void reveal(final Object diagramElement, final int duration) {
        if (currentViewer != null) {
            currentViewer.reveal(diagramElement, duration);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void centerOn(final Object diagramElement, final int duration) {
        if (currentViewer != null) {
            currentViewer.centerOn(diagramElement, duration);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void zoom(final float zoomLevel, final int duration) {
        if (currentViewer != null) {
            currentViewer.zoom(zoomLevel, duration);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void zoomToFit(final int duration) {
        if (currentViewer != null) {
            currentViewer.zoomToFit(duration);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void addSelectionChangedListener(final ISelectionChangedListener listener) {
        selectionListeners.add(listener);
    }

    /**
     * {@inheritDoc}
     */
    public void removeSelectionChangedListener(final ISelectionChangedListener listener) {
        selectionListeners.remove(listener);
    }

    /**
     * Returns the currently active viewer.
     * 
     * @return the viewer
     */
    public IViewer<?> getActiveViewer() {
        return currentViewer;
    }

    /**
     * Returns the currently active view context.
     * 
     * @return the view context
     */
    public ViewContext getCurrentViewContext() {
        return currentViewContext;
    }

    /**
     * An implementation of {@code IStructuredSelection} for the {@code ISelectionProvider}.
     */
    private class Selection implements IStructuredSelection, Iterable<Object> {

        /** the objects which make up the selection. */
        private List<Object> selectedElements = new LinkedList<Object>();

        /**
         * {@inheritDoc}
         */
        public boolean isEmpty() {
            return selectedElements.isEmpty();
        }

        /**
         * {@inheritDoc}
         */
        public Object getFirstElement() {
            if (selectedElements.isEmpty()) {
                return null;
            } else {
                return selectedElements.get(0);
            }
        }

        /**
         * {@inheritDoc}
         */
        public Iterator<Object> iterator() {
            return selectedElements.iterator();
        }

        /**
         * {@inheritDoc}
         */
        public int size() {
            return selectedElements.size();
        }

        /**
         * {@inheritDoc}
         */
        public Object[] toArray() {
            return selectedElements.toArray();
        }

        /**
         * {@inheritDoc}
         */
        public List<Object> toList() {
            return selectedElements;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Selection clone() {
            Selection clone = new Selection();
            clone.selectedElements.addAll(selectedElements);
            return clone;
        }

    }

}