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
package de.cau.cs.kieler.klighd.views;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * A utility class for creating and updating diagram views.
 * 
 * @author mri
 */
public final class DiagramViewUtil {

    /** the primary identifier for the diagram view as specified in the view extension. */
    private static final String PRIMARY_VIEW_ID = "de.cau.cs.kieler.klighd.lightDiagramView";

    /**
     * A private constructor to prevent instantiation.
     */
    private DiagramViewUtil() {
        // do nothing
    }
    
    /**
     * Returns the diagram view with the given identifier if available. Does not create any views.
     * 
     * @param id
     *            the diagram view identifier (can be null for the default view)
     * @return the diagram view or null if no view with the given identifier exists
     */
    public static DiagramViewPart getView(final String id) {
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        IViewReference viewRef = window.getActivePage().findViewReference(PRIMARY_VIEW_ID, id);
        if (viewRef != null) {
            IViewPart view = viewRef.getView(false);
            if (view instanceof DiagramViewPart) {
                return (DiagramViewPart) view;
            }
        }
        return null;
    }

    /**
     * Updates the diagram view with the given identifier with a given name and model.
     * 
     * @param id
     *            the diagram view identifier (can be null for the default view)
     * @param name
     *            the name (can be null if the name of the view should remain unchanged)
     * @param model
     *            the model (can be null if the displayed model should remain unchanged)
     * @return whether a view with the given identifier has been updated
     */
    public static boolean updateView(final String id, final String name, final Object model) {
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        IWorkbenchPage page = window.getActivePage();
        IViewReference viewRef = page.findViewReference(PRIMARY_VIEW_ID, id);
        if (viewRef != null) {
            IViewPart view = viewRef.getView(false);
            if (view instanceof DiagramViewPart) {
                DiagramViewPart diagramView = (DiagramViewPart) view;
                if (name != null) {
                    diagramView.setName(name);
                }
                if (model != null) {
                    diagramView.setInputModel(model);
                }
                page.activate(diagramView);
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a diagram view with the given name and model under the specified identifier.
     * 
     * @param id
     *            the diagram view identifier (can be null for the default view)
     * @param name
     *            the name (can be null if the view should be created with the default name)
     * @param model
     *            the model (can be null if the view should be created without an initial model)
     * @return the created view or null if a view with the given identifier exists already or if
     *         creating the view failed
     */
    public static DiagramViewPart createView(final String id, final String name, final Object model) {
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        IWorkbenchPage page = window.getActivePage();
        IViewReference viewRef = page.findViewReference(PRIMARY_VIEW_ID, id);
        if (viewRef == null) {
            try {
                IViewPart view = page.showView(PRIMARY_VIEW_ID, id, IWorkbenchPage.VIEW_ACTIVATE);
                if (view instanceof DiagramViewPart) {
                    DiagramViewPart diagramView = (DiagramViewPart) view;
                    if (name != null) {
                        diagramView.setName(name);
                    }
                    if (model != null) {
                        diagramView.setInputModel(model);
                    }
                    return diagramView;
                }
            } catch (PartInitException e) {
                return null;
            }
        }
        return null;
    }

}
