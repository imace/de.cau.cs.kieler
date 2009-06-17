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

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.swt.SWT;

/**
 * @author haf
 *
 */
public class GenericSingleCommandLayoutGraphApplier extends AbstractLayoutGraphApplier{

    /* preference settings */
    private boolean prefUseGMFLabelLocation = false;
    private boolean prefSmoothTransitions = false;

    /* zoom level and connection layer */
    private double zoomLevel = 1.0;
    private ConnectionLayer connectionLayer = null;
    
    /** This is the Request that will store all information about the new layout */
    private ApplyLayoutRequest applyLayoutRequest;
    
    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.ui.layout.AbstractLayoutGraphApplier#doApplyLayoutGraph()
     */
    @Override
    protected void doApplyLayoutGraph() {
        /* gets zoom level */
        ScalableFreeformRootEditPart sfrep = (ScalableFreeformRootEditPart) layoutRootPart
                .getRoot();
        zoomLevel = sfrep.getZoomManager().getZoom();

        /* gets connection layer */
        connectionLayer = (ConnectionLayer) sfrep
                .getLayer(DiagramRootEditPart.CONNECTION_LAYER);
        connectionLayer.setAntialias(SWT.ON);
        
        // create a new GEF Request to change the layout
        // the request will be filled with the new layout specification
        // piece by piece in the following
        applyLayoutRequest = new ApplyLayoutRequest();
        // the type is not important for us but may not be null
        applyLayoutRequest.setType(RequestConstants.REQ_ALIGN);
        
        // create a new GEF Command from the Request we just set up
        // the command is received from a custom ApplyLayoutEditPolicy that is
        // registered with the DiagramEditPart. So we get the command from
        // the diagram. This way we only have exactly one Request/Command pair which
        // should result in massive performance gains.
        DiagramEditPart diagramEditPart = this.getDiagramEditPart();
        Command applyLayoutCommand = diagramEditPart.getCommand(applyLayoutRequest);
        
        /* gets the diagram command stack */
        DiagramCommandStack commandStack = null;
        Object adapter = sfrep.getAdapter(CommandStack.class);
        if (adapter instanceof DiagramCommandStack) {
            commandStack = (DiagramCommandStack) adapter;
        } else {
            commandStack = new DiagramCommandStack(null);
        }
        
        // now execute the layout command!
        commandStack.execute(applyLayoutCommand);
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kiml.ui.layout.AbstractLayoutGraphApplier#updatePreferences()
     */
    @Override
    protected void updatePreferences() {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * Search the root DiagramEditPart of this layout run. This may be used e.g. to obtain
     * a special command by an EditPolicy that is only installed for the root DiagramEditPart.
     * It is recursively searched from this layoutrooteditpart which also could be a Node.
     * @return the root DiagramEditPart of this layout run
     */
    private DiagramEditPart getDiagramEditPart(){
        EditPart ep = this.layoutRootPart;
        while ( (ep != null) && (! (ep instanceof DiagramEditPart)) ){
            ep = ep.getParent();
        }
        // assuming that every EP always is located into an DiagramEditPart somewhere
        // this should be verified
        assert (ep != null);
        return (DiagramEditPart)ep;
    }

}
