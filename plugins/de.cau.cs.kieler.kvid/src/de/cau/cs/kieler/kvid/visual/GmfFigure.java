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
import de.cau.cs.kieler.kvid.data.KvidUri;
import de.cau.cs.kieler.kvid.datadistributor.RuntimeConfiguration;

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
    
    /** The default lable length. */
    private static final int DEFAULT_LABEL_LENGTH = 6;
    
    /**
     * Constructs a new figure for the given data.
     * 
     * @param thedata The {@link DataObject} to display with this figure
     */
    public GmfFigure(final DataObject thedata) {
        super();
        this.currentData = thedata;
        if ("true".equalsIgnoreCase(currentData.getData())) {
            setBounds(new Rectangle(0, 0, STRETCH_FACTOR, STRETCH_FACTOR));
            setForegroundColor(ColorConstants.green);
            setBackgroundColor(ColorConstants.green);
        } else if ("false".equalsIgnoreCase(currentData.getData())) {
            setBounds(new Rectangle(0, 0, STRETCH_FACTOR, STRETCH_FACTOR));
            setForegroundColor(ColorConstants.red);
            setBackgroundColor(ColorConstants.red);
        } else {
            
            //Construct the visual parts
            setLayoutManager(new BorderLayout());
            setForegroundColor(ColorConstants.black);
            int maxLabelLength;
            try {
                String propertyText = RuntimeConfiguration.getInstance()
                .getProperty(RuntimeConfiguration.MAX_TOKEN_SIZE).getCurrentValue();
                maxLabelLength = Integer.parseInt(propertyText);
            } catch (NumberFormatException nfex) {
                //Invalid number entered, use a default value
                maxLabelLength = DEFAULT_LABEL_LENGTH;
            }
            Label label;
            if (currentData.getData().length() > maxLabelLength) {
                label = new Label(currentData.getData().substring(0, maxLabelLength) + "...");
            } else {
                label = new Label(currentData.getData());
            }
            label.setForegroundColor(ColorConstants.black);
            label.setBounds(new Rectangle(0, 0, label.getText().length()
                    * STRETCH_FACTOR, STRETCH_FACTOR));
            add(label, BorderLayout.CENTER);
            setBounds(new Rectangle(0, 0, label.getText().length()
                    * STRETCH_FACTOR, 2 * STRETCH_FACTOR));
        }
        setVisible(false);
    }
    
    /**
     * {@inheritDoc}
     */
    public void updateData(final DataObject thedata) {
        currentData = thedata;
        //Clean figure
        removeAll();
        if ("true".equalsIgnoreCase(currentData.getData())) {
            setBounds(new Rectangle(0, 0, STRETCH_FACTOR, STRETCH_FACTOR));
            setForegroundColor(ColorConstants.green);
            setBackgroundColor(ColorConstants.green);
        } else if ("false".equalsIgnoreCase(currentData.getData())) {
            setBounds(new Rectangle(0, 0, STRETCH_FACTOR, STRETCH_FACTOR));
            setForegroundColor(ColorConstants.red);
            setBackgroundColor(ColorConstants.red);
        } else {
            
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
    }

    /**
     * {@inheritDoc}
     */
    public DataObject getData() {
        return currentData;
    }

    /**
     * {@inheritDoc}
     */
    public IKvidFigure copy() {
        KvidUri currentUri = currentData.getUri();
        KvidUri uriCopy;
        if (currentUri.hasPort()) {
            uriCopy = new KvidUri(currentUri.getElementUri() + ":"
                    + currentUri.getPort() + "<" + currentUri.getPriority()
                    + ">");
        } else {
            uriCopy = new KvidUri(currentUri.getElementUri() + "<" + currentUri.getPriority() + ">");
        }
        DataObject dataCopy = new DataObject(uriCopy, currentData.getData().toString());
        return new GmfFigure(dataCopy);
    }
    
    

}
