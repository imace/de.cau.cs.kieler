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

/**
 * Request used to apply layout.
 * 
 * @author haf, msp
 */
public class ApplyLayoutRequest extends Request {

    /** the request type used to apply layout */
    public static final String REQ_APPLY_LAYOUT = "apply layout";
    
    /**
     * Creates a request to apply layout.
     */
    public ApplyLayoutRequest() {
        super(REQ_APPLY_LAYOUT);
    }
    
}
