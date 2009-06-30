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

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;

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
            return null;
        }
        else
            return super.getCommand(request);
    }
    
}
