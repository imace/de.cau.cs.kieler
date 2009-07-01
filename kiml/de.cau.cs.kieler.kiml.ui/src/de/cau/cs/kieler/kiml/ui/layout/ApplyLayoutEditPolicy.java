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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;

/**
 * Edit policy used to apply layout.
 * 
 * @author haf, msp
 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy
 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionBendpointEditPolicy
 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy
 */
public class ApplyLayoutEditPolicy extends AbstractEditPolicy {

    /** the key used to install an <i>apply layout</i> edit policy  */
    public static final String APPLY_LAYOUT_ROLE = "ApplyLayoutEditPolicy";
    
    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#understandsRequest(org.eclipse.gef.Request)
     */
    @Override
    public boolean understandsRequest(Request req) {
        return (ApplyLayoutRequest.REQ_APPLY_LAYOUT.equals(req.getType()));
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
     */
    @Override
    public Command getCommand(Request request) {
        if (ApplyLayoutRequest.REQ_APPLY_LAYOUT.equals(request.getType())) {
            if (request instanceof ApplyLayoutRequest) {
                ApplyLayoutRequest layoutRequest = (ApplyLayoutRequest)request;
                GraphicalEditPart hostEditPart = (GraphicalEditPart)getHost();
                ApplyLayoutCommand command = new ApplyLayoutCommand(
                        hostEditPart.getEditingDomain(), "Apply Layout",
                        new EObjectAdapter((View)hostEditPart.getModel()));
                addShapeLayouts(command, layoutRequest);
                addEdgeLayouts(command, layoutRequest);
                return new ICommandProxy(command);
            }
            else return null;
        }
        else
            return super.getCommand(request);
    }
    
    /**
     * Adds all shape layout data to the given command.
     * 
     * @param command command that shall be enriched with shape layout data
     * @param request request from which the data is extracted
     */
    private void addShapeLayouts(ApplyLayoutCommand command,
            ApplyLayoutRequest request) {
        // process layout data of nodes
        Map<KNode, GraphicalEditPart> nodeMap = request.getNodeMap();
        if (nodeMap != null) {
            for (KNode knode : nodeMap.keySet()) {
                KShapeLayout nodeLayout = KimlLayoutUtil.getShapeLayout(knode);
                GraphicalEditPart editPart = nodeMap.get(knode);
                addShapeLayout(command, editPart, nodeLayout, 0.0f, 0.0f);
            }
        }
        // process layout data of ports
        Map<KPort, ShapeNodeEditPart> portMap = request.getPortMap();
        if (portMap != null) {
            for (KPort kport : portMap.keySet()) {
                KShapeLayout portLayout = KimlLayoutUtil.getShapeLayout(kport);
                GraphicalEditPart editPart = portMap.get(kport);
                Point nodeLocation = nodeMap.get(kport.getNode())
                        .getFigure().getBounds().getLocation();
                addShapeLayout(command, editPart, portLayout, nodeLocation.x,
                        nodeLocation.y);
            }
        }
    }

    /**
     * Adds shape layout data for one element to the given command.
     * 
     * @param command command that shall be enriched with shape layout data
     * @param editPart edit part to which the data is applied
     * @param layoutData new shape layout data
     * @param offsetX offset to add to the x coordinate
     * @param offsetY offset to add to the y coordinate
     */
    private void addShapeLayout(ApplyLayoutCommand command, GraphicalEditPart editPart,
            KShapeLayout layoutData, float offsetX, float offsetY) {
        Rectangle oldBounds = editPart.getFigure().getBounds();
        Point newLocation = new Point(Math.round(layoutData.getXpos() + offsetX),
                Math.round(layoutData.getYpos() + offsetY));
        if (newLocation.x == oldBounds.x && newLocation.y == oldBounds.y)
            newLocation = null;
        Dimension newSize = new Dimension(Math.round(layoutData.getWidth()),
                Math.round(layoutData.getHeight()));
        if (newSize.width == oldBounds.width && newSize.height == oldBounds.height)
            newSize = null;
        if (newLocation != null || newSize != null) {
            View view = (View)editPart.getModel();
            command.addShapeLayout(view, newLocation, newSize);
        }
    }
    
    /**
     * Adds all edge layout data to the given command.
     * 
     * @param command command that shall be enriched with edge layout data
     * @param request request from which the data is extracted
     */
    private void addEdgeLayouts(ApplyLayoutCommand command,
            ApplyLayoutRequest request) {
        
    }

}
