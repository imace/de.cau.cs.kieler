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
package de.cau.cs.kieler.klighd.effects;

import com.google.common.collect.Lists;

import de.cau.cs.kieler.core.kivi.IEffect;
import de.cau.cs.kieler.core.kivi.KiVi;
import de.cau.cs.kieler.core.properties.IPropertyHolder;
import de.cau.cs.kieler.core.properties.MapPropertyHolder;
import de.cau.cs.kieler.core.ui.util.MonitoredOperation;
import de.cau.cs.kieler.klighd.IViewer;
import de.cau.cs.kieler.klighd.LightDiagramServices;
import de.cau.cs.kieler.klighd.views.DiagramViewManager;
import de.cau.cs.kieler.klighd.views.DiagramViewPart;

/**
 * A view management effect for showing models in a KLighD view.
 * 
 * @author mri
 */
public class KlighdDiagramEffect extends MapPropertyHolder implements IEffect {

    /** the identifier for the diagram view. */
    private String id = null;
    /** the new name for the diagram view. */
    private String name = null;
    /** the new input model for the diagram view. */
    private Object model = null;

    // the following fields are valid AFTER the effect executed

    /** the created/updated view. */
    private DiagramViewPart view = null;
    /** the created viewer. */
    private IViewer<?> viewer = null;

    /**
     * Constructs an effect that opens the default diagram view if it is not already open.
     */
    public KlighdDiagramEffect() {
    }

    /**
     * Constructs an effect that opens a diagram view with the given identifier if it is not already
     * open.
     * 
     * @param id
     *            the identifier
     */
    public KlighdDiagramEffect(final String id) {
        this.id = id;
    }

    /**
     * Constructs an effect that opens a diagram view with the given name and identifier or changes
     * the name of an exisiting view with that identifier.
     * 
     * @param id
     *            the identifier
     * @param name
     *            the name
     */
    public KlighdDiagramEffect(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Constructs an effect that opens the default diagram view with the given input model or
     * changes the input model of the default view.
     * 
     * @param model
     *            the input model
     */
    public KlighdDiagramEffect(final Object model) {
        this.model = model;
    }

    /**
     * Constructs an effect that opens a diagram view with the given input model and identifier or
     * changes the input model of an existing view with that identifier.
     * 
     * @param id
     *            the identifier
     * @param model
     *            the input model
     */
    public KlighdDiagramEffect(final String id, final Object model) {
        this.id = id;
        this.model = model;
    }

    /**
     * Constructs an effect that opens a diagram view with the given input model, identifier and
     * name or changes the input model and name of an existing view with that identifier.
     * 
     * @param id
     *            the identifier
     * @param name
     *            the name
     * @param model
     *            the input model
     */
    public KlighdDiagramEffect(final String id, final String name, final Object model) {
        this.id = id;
        this.name = name;
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    public void execute() {
        final IPropertyHolder propertyHolder = this;
        MonitoredOperation.runInUI(new Runnable() {
            public void run() {
                view = DiagramViewManager.getInstance().createView(id, name, model, propertyHolder);
                if (view != null) {
                    viewer = view.getViewer().getActiveViewer();
                }
            }
        }, true);
    }

    /**
     * Returns the view identifier associated with this effect.
     * 
     * @return the view identifier or null for the default view
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name for the view associated with this effect.
     * 
     * @return the name for the view or null for no name modification
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the model for the view associated with this effect.
     * 
     * @return the model for the view or null for no new model
     */
    public Object getModel() {
        return model;
    }

    /**
     * Returns the view created or updated as part of the effect.
     * 
     * @return the view or null when called before the effect executed, the execute failed or was
     *         invalid
     */
    public DiagramViewPart getView() {
        return view;
    }

    /**
     * Returns the viewer created as part of the effect.
     * 
     * @return the viewer or null when called before the effect executed, the execute failed or was
     *         invalid
     */
    public IViewer<?> getViewer() {
        return viewer;
    }

    /**
     * Sets the request for a viewer by identifier.
     * 
     * @param viewerProviderId
     *            the viewer provider identifier
     */
    public void setViewerRequest(final String viewerProviderId) {
        setProperty(LightDiagramServices.REQUESTED_VIEWER_PROVIDER, viewerProviderId);
    }

    /**
     * Sets the request for a number of transformations by identifier.
     * 
     * @param transformationIds
     *            the transformations identifiers
     */
    public void setTransformationsRequest(final String... transformationIds) {
        setProperty(LightDiagramServices.REQUESTED_TRANSFORMATIONS,
                Lists.newArrayList(transformationIds));
    }

    /**
     * Sets the request for an update strategy by identifier.
     * 
     * @param updateStrategyId
     *            the update strategy identifier
     */
    public void setUpdateStrategyRequest(final String updateStrategyId) {
        setProperty(LightDiagramServices.REQUESTED_UPDATE_STRATEGY, updateStrategyId);
    }

    /**
     * {@inheritDoc}
     */
    public void schedule() {
        KiVi.getInstance().executeEffect(this);
    }

    /**
     * {@inheritDoc}
     */
    public void undo() {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    public void scheduleUndo() {
        KiVi.getInstance().undoEffect(this);
    }

    /**
     * {@inheritDoc}
     */
    public boolean isMergeable() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public IEffect merge(final IEffect otherEffect) {
        return null;
    }

    /**
     * Sets the view created by the effect.
     * 
     * @param view
     *            the view
     */
    protected void setView(final DiagramViewPart view) {
        this.view = view;
    }

    /**
     * Sets the viewer created by the effect.
     * 
     * @param viewer
     *            the viewer
     */
    protected void setViewer(final IViewer<?> viewer) {
        this.viewer = viewer;
    }

}
