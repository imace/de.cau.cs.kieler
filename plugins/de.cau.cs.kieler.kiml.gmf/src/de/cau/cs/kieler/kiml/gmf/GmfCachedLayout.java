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
package de.cau.cs.kieler.kiml.gmf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Animation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.core.kgraph.KGraphElement;
import de.cau.cs.kieler.core.kgraph.KLabel;
import de.cau.cs.kieler.core.ui.util.MonitoredOperation;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;
import de.cau.cs.kieler.kiml.ui.layout.ApplyLayoutRequest;
import de.cau.cs.kieler.kiml.ui.layout.DiagramLayoutManager;
import de.cau.cs.kieler.kiml.ui.layout.ICachedLayout;

/**
 * A cache for results of automatic layout. Can be used to repeatedly apply the
 * same layout to a diagram.
 *
 * @kieler.rating 2010-01-26 proposed yellow msp
 * @author msp
 */
public class GmfCachedLayout implements ICachedLayout {
    
    /**
     * Data type for entities of the layout cache.
     */
    private static final class LayoutEntity {
        private EObject modelObject;
        private KGraphElement graphElement;
        
        /**
         * Creates an initialized layout entity.
         * 
         * @param themodelObject the model object
         * @param thegraphElement the layout graph element
         */
        private LayoutEntity(final EObject themodelObject, final KGraphElement thegraphElement) {
            this.modelObject = themodelObject;
            this.graphElement = thegraphElement;
        }
    }
    
    /** list of layout entities that constitute the layout cache. */
    private List<LayoutEntity> layoutCache;
    
    /**
     * Creates a cached layout with given initial capacity.
     * 
     * @param initialCapacity the initial capacity of the cache
     */
    public GmfCachedLayout(final int initialCapacity) {
        layoutCache = new ArrayList<LayoutEntity>(initialCapacity);
    }

    /**
     * Adds the given model object with associated layout to the cache.
     * 
     * @param modelObject a model object
     * @param graphElement the associated layout graph element
     */
    public void addLayout(final EObject modelObject, final KGraphElement graphElement) {
        layoutCache.add(new LayoutEntity(modelObject, graphElement));
    }
    
    /**
     * Adds the given edit part with associated layout to the cache.
     * 
     * @param editPart an edit part
     * @param graphElement the associated layout graph element
     */
    public void addLayout(final IGraphicalEditPart editPart, final KGraphElement graphElement) {
        if (graphElement instanceof KLabel) {
            layoutCache.add(new LayoutEntity(editPart.getNotationView(), graphElement));
        } else {
            layoutCache.add(new LayoutEntity(editPart.getNotationView().getElement(), graphElement));
        }
    }
    
    /** divisor for parameter to the calculated animation time. */
    private static final int ANIMATION_SHORTEN = 3;
    
    /**
     * {@inheritDoc}
     */
    public void applyLayout(final IEditorPart editorPart, final boolean animate) {
        MonitoredOperation.runInUI(new Runnable() {
            public void run() {
                if (animate) {
                    Animation.markBegin();
                    applyLayout(editorPart);
                    Animation.run(DiagramLayoutManager.calcAnimationTime(
                            layoutCache.size() / ANIMATION_SHORTEN));
                } else {
                    applyLayout(editorPart);
                }
            }
        }, false);
    }
    
    /**
     * {@inheritDoc}
     */
    public void applyLayout(final IEditorPart editorPart) {
        // get a command stack to execute the command
        CommandStack commandStack = null;
        if (editorPart != null) {
            Object adapter = editorPart.getAdapter(CommandStack.class);
            if (adapter instanceof CommandStack) {
                commandStack = (CommandStack) adapter;
            }
        }
        if (commandStack == null || !(editorPart instanceof DiagramEditor)) {
            IStatus status = new Status(IStatus.ERROR, KimlUiPlugin.PLUGIN_ID,
                    "The selected editor has no command stack.", null);
            StatusManager.getManager().handle(status);
            return;
        }

        // create a new request to change the layout
        DiagramEditor diagramEditor = (DiagramEditor) editorPart;
        Map<EObject, View> viewMap = getViewMap(diagramEditor.getDiagram());
        Map<?, ?> editPartRegistry = diagramEditor.getDiagramGraphicalViewer().getEditPartRegistry();
        ApplyLayoutRequest applyLayoutRequest = new ApplyLayoutRequest();
        for (LayoutEntity entity : layoutCache) {
            Object object;
            if (entity.modelObject instanceof View) {
                object = editPartRegistry.get(entity.modelObject);
            } else {
                object = editPartRegistry.get(viewMap.get(entity.modelObject));
            }
            if (object instanceof GraphicalEditPart) {
                applyLayoutRequest.addElement(entity.graphElement, (GraphicalEditPart) object);
            }
        }

        // retrieve a command for the request; the command is created by GmfLayoutEditPolicy
        DiagramEditPart diagramEditPart = diagramEditor.getDiagramEditPart();
        Command applyLayoutCommand = diagramEditPart.getCommand(applyLayoutRequest);
        // execute the command
        commandStack.execute(applyLayoutCommand);
    }
    
    /**
     * Constructs a map of domain model elements to their views.
     * 
     * @param diagram the top level view
     * @return a map of model elements to views
     */
    private Map<EObject, View> getViewMap(final Diagram diagram) {
        Map<EObject, View> viewMap = new HashMap<EObject, View>();
        registerView(viewMap, diagram);
        for (Object edge : diagram.getPersistedEdges()) {
            registerView(viewMap, (View) edge);
        }
        return viewMap;
    }
    
    /**
     * Register a view and all its children to the given map.
     * 
     * @param viewMap map of model elements to views
     * @param parent the parent view
     */
    private void registerView(final Map<EObject, View> viewMap, final View parent) {
        EObject element = parent.getElement();
        if (!viewMap.containsKey(element)) {
            viewMap.put(element, parent);
        }
        for (Object node : parent.getPersistedChildren()) {
            registerView(viewMap, (View) node);
        }
    }
    
}
