/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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
 */
package de.cau.cs.kieler.kvid.visual;

import org.eclipse.draw2d.ImageFigure;
import org.eclipse.swt.graphics.Image;

import de.cau.cs.kieler.kvid.data.DataObject;

/**
 * @author jjc
 *
 */
public class GmfImageFigure extends ImageFigure implements IKvidFigure {
    
    private DataObject data;
    
    /**
     * 
     */
    public GmfImageFigure(Image theimage) {
        super(theimage);
    }

    /* (non-Javadoc)
     * @see de.cau.cs.kieler.kvid.visual.IKvidFigure#updateData(de.cau.cs.kieler.kvid.data.DataObject)
     */
    public void updateData(DataObject thedata) {
        this.data = thedata;        
    }
    
    

}
