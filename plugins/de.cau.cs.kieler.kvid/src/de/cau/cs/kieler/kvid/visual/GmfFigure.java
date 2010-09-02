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

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Rectangle;

import de.cau.cs.kieler.kvid.data.DataObject;

/**
 * The figure which is used to display plain data.
 * 
 * @author jjc
 *
 */
public class GmfFigure extends RoundedRectangle implements IKvidFigure {
    
    /** Reference to the currently displayed data. */
    private DataObject currentData;
    
    /** The factor by which the figure is enlarged in comparison to the data's length. */
    private static final int STRETCH_FACTOR = 10; 
    
    /**
     * Constructs a new figure for the given data.
     * 
     * @param thedata The {@link DataObject} to display with this figure
     */
    public GmfFigure(final DataObject thedata) {
        super();
        this.currentData = thedata;
        
        //Construct the visual parts
        setLayoutManager(new BorderLayout());
        setBounds(new Rectangle(0, 0, currentData.getData().toString().length()
                * STRETCH_FACTOR, 2 * STRETCH_FACTOR));
        setForegroundColor(ColorConstants.black);
        Label label = new Label(currentData.getData().toString());
        label.setForegroundColor(ColorConstants.black);
        label.setBounds(new Rectangle(0, 0, currentData.getData().toString()
                .length()
                * STRETCH_FACTOR, STRETCH_FACTOR));
        add(label, BorderLayout.CENTER);
    }
    
    /**
     * {@inheritDoc}
     */
    public void updateData(final DataObject thedata) {
        currentData = thedata;
        //Clean figure
        removeAll();
        
        //Create new visuals
        setBounds(new Rectangle(0, 0, currentData.getData().toString().length()
                * STRETCH_FACTOR, 2 * STRETCH_FACTOR));
        Label label = new Label(currentData.getData().toString());
        label.setForegroundColor(ColorConstants.black);
        label.setBounds(new Rectangle(0, 0, currentData.getData().toString()
                .length()
                * STRETCH_FACTOR, STRETCH_FACTOR));
        add(label, BorderLayout.CENTER);
    }

    /**
     * {@inheritDoc}
     */
    public DataObject getData() {
        return currentData;
    }

}
