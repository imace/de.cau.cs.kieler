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

package de.cau.cs.kieler.core.model.gmf.effects;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;

import de.cau.cs.kieler.core.kivi.AbstractEffect;
import de.cau.cs.kieler.core.ui.util.MonitoredOperation;

/**
 * 
 * This effect scrolls to the given eobject or coordinates.
 * 
 * @author ckru
 * 
 */
public class PanningEffect extends AbstractEffect {

    private EObject target = null;
    private Point coordinates = null;
    private FigureCanvas canvas = null;
    private DiagramDocumentEditor editor = null;
    private boolean animate = false;
    private double zoomLevel = 100;
    private boolean zoom = false;

    /**
     * Constructor of the PanningEffect with coordinates as scrolling target.
     * 
     * @param editor
     *            the editor
     * @param coordinates
     *            the coordinates to be scrolled to
     * @param animate
     *            true if scrolling should be animated
     * @param zoom
     *            true if zooming should be done
     * @param zoomLevel
     *            the desired zoom level (i.e. 1.5 = 150%)
     */
    public PanningEffect(final DiagramDocumentEditor editor, final Point coordinates,
            final boolean animate, boolean zoom, double zoomLevel) {
        this.coordinates = coordinates;
        this.editor = editor;
        this.animate = animate;
        this.zoom = zoom;
        this.zoomLevel = zoomLevel;

        if (editor.getDiagramGraphicalViewer() instanceof ScrollingGraphicalViewer) {
            ScrollingGraphicalViewer scrollViewer = (ScrollingGraphicalViewer) editor
                    .getDiagramGraphicalViewer();
            if (scrollViewer.getControl() instanceof FigureCanvas) {
                canvas = (FigureCanvas) scrollViewer.getControl();
            }
        }
    }

    /**
     * Constructor of the PanningEffect with EObject as scrolling target.
     * 
     * @param editor
     *            the editor
     * @param target
     *            the coordinates to be scrolled to
     * @param animate
     *            true if scrolling should be animated
     * @param zoom
     *            true if zooming should be done
     * @param zoomLevel
     *            the desired zoom level (i.e. 1.5 = 150%)
     */
    public PanningEffect(final DiagramDocumentEditor editor, final EObject target,
            final boolean animate, boolean zoom, double zoomLevel) {
        this.target = target;
        this.editor = editor;
        this.animate = animate;
        this.zoom = zoom;
        this.zoomLevel = zoomLevel;

        if (editor.getDiagramGraphicalViewer() instanceof ScrollingGraphicalViewer) {
            ScrollingGraphicalViewer scrollViewer = (ScrollingGraphicalViewer) editor
                    .getDiagramGraphicalViewer();
            if (scrollViewer.getControl() instanceof FigureCanvas) {
                canvas = (FigureCanvas) scrollViewer.getControl();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void execute() {
        final ZoomManager zoomManager = ((RenderedDiagramRootEditPart) editor.getDiagramEditPart()
                .getRoot()).getZoomManager();
        Point coords = null;
        if (target != null) {
            EditPart part = editor.getDiagramEditPart().findEditPart(editor.getDiagramEditPart(),
                    target);
            if (part instanceof GraphicalEditPart) {
                GraphicalEditPart graphicalPart = (GraphicalEditPart) part;
                coords = graphicalPart.getFigure().getBounds().getLocation();
                graphicalPart.getFigure().translateToAbsolute(coords);
            }
        } else if (coordinates != null) {
            coords = coordinates;
        }
        final Point finalCoords = coords;
        if (finalCoords != null) {
            MonitoredOperation.runInUI(new Runnable() {
                public void run() {
                    if (animate) {
                        canvas.scrollSmoothTo(finalCoords.x, finalCoords.y);
                        
                    } else {
                        canvas.scrollTo(finalCoords.x, finalCoords.y);
                    }
                    if (zoom) {
                        zoomManager.setZoom(zoomLevel);                            
                    }
                }
            }, false);
        }
    }

}
