/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
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
package de.cau.cs.kieler.kiml.ui.layout;

import java.util.Map;

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;

import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KLabel;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;

/**
 * Request used to apply layout.
 * 
 * @author haf, msp
 */
public class ApplyLayoutRequest extends Request {

    /** the request type used to apply layout */
    public static final String REQ_APPLY_LAYOUT = "apply layout";
    
    /** map of layout nodes to the corresponding edit parts */
    private Map<KNode, GraphicalEditPart> nodeMap = null;
    /** map of layout ports to the corresponding edit parts */
    private Map<KPort, ShapeNodeEditPart> portMap = null;
    /** map of layout edges to the corresponding edit parts */
    private Map<KEdge, ConnectionEditPart> edgeMap = null;
    /** map of edge labels to the corresponding edit parts */
    private Map<KLabel, LabelEditPart> edgeLabelMap = null;
    
    /**
     * Creates a request to apply layout.
     */
    public ApplyLayoutRequest() {
        super(REQ_APPLY_LAYOUT);
    }

    /**
     * Returns the map of layout nodes to the corresponding edit parts.
     * 
     * @return the node map
     */
    public Map<KNode, GraphicalEditPart> getNodeMap() {
        return nodeMap;
    }

    /**
     * Sets the map of layout nodes to edit parts.
     * 
     * @param nodeMap the node map to set
     */
    public void setNodeMap(Map<KNode, GraphicalEditPart> nodeMap) {
        this.nodeMap = nodeMap;
    }

    /**
     * Returns the map of layout ports to the corresponding edit parts.
     * 
     * @return the port map
     */
    public Map<KPort, ShapeNodeEditPart> getPortMap() {
        return portMap;
    }

    /**
     * Sets the map of layout ports to edit parts.
     * 
     * @param portMap the port map to set
     */
    public void setPortMap(Map<KPort, ShapeNodeEditPart> portMap) {
        this.portMap = portMap;
    }

    /**
     * Returns the map of layout edges to the corresponding edit parts.
     * 
     * @return the edge map
     */
    public Map<KEdge, ConnectionEditPart> getEdgeMap() {
        return edgeMap;
    }

    /**
     * Sets the map of layout edges to edit parts.
     * 
     * @param edgeMap the edge map to set
     */
    public void setEdgeMap(Map<KEdge, ConnectionEditPart> edgeMap) {
        this.edgeMap = edgeMap;
    }

    /**
     * Returns the map of edge labels to the corresponding edit parts.
     * 
     * @return the edge label map
     */
    public Map<KLabel, LabelEditPart> getEdgeLabelMap() {
        return edgeLabelMap;
    }

    /**
     * Sets the map of edge labels to edit parts.
     * 
     * @param edgeLabelMap the edge label map to set
     */
    public void setEdgeLabelMap(Map<KLabel, LabelEditPart> edgeLabelMap) {
        this.edgeLabelMap = edgeLabelMap;
    }
    
}
