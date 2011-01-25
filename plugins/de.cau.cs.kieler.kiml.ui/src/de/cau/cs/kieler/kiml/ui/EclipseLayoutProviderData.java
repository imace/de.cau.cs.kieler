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
package de.cau.cs.kieler.kiml.ui;

import org.eclipse.jface.resource.ImageDescriptor;

import de.cau.cs.kieler.kiml.LayoutProviderData;

/**
 * An extension of layout provider data that supports preview images.
 *
 * @kieler.rating 2009-12-24 proposed yellow msp
 * @author msp
 */
public class EclipseLayoutProviderData extends LayoutProviderData {
    
    /** the preview image. */
    private ImageDescriptor previewImage;

    /**
     * Returns the preview image.
     * 
     * @return the preview image
     */
    public ImageDescriptor getPreviewImage() {
        return previewImage;
    }

    /**
     * Sets the preview image.
     * 
     * @param thepreviewImage the preview image to set
     */
    public void setPreviewImage(final ImageDescriptor thepreviewImage) {
        this.previewImage = thepreviewImage;
    }

}