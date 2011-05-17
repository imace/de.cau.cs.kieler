/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
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
package de.cau.cs.kieler.klots.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * @author ybe
 *
 */
public class ColorProvider {
    
    private Map<RGB, Color> colorTable = new HashMap<RGB, Color>(KlotsConstants.COLORS_NUMBER);
    private IPreferenceStore store;
    
    
    
    /**
     * @param store 
     */
    public ColorProvider(final IPreferenceStore store) {
        this.store = store;
    }
    
    
    
    /**
     * 
     */
    public void dispose() {
        Iterator<Color> e = colorTable.values().iterator();
        while (e.hasNext()) {
            e.next().dispose();
        }
    }
    
    
    
    /**
     * @param prefKey 
     * @return Color 
     */
    public Color getColor(final String prefKey) {
        String colorName = store.getString(prefKey);
        RGB rgb = StringConverter.asRGB(colorName);
        return getColor(rgb);
    }
    
    
    
    /**
     * @param rgb 
     * @return Color 
     */
    private Color getColor(final RGB rgb) {
        Color color = colorTable.get(rgb);
        if (color == null) {
           color = new Color(Display.getCurrent(), rgb);
           colorTable.put(rgb, color);
        }
        return color;
    }
    
    
    
    /**
     * {@inheritDoc}
     */
    public void handlePreferenceStoreChanged(final PropertyChangeEvent event) {
        System.out.println("***********>>>> COLOR PROVIDER > handlePreferenceStoreChanged()");
        // remove old color
        RGB oldColor = StringConverter.asRGB((String) event.getOldValue());
        colorTable.remove(oldColor).dispose();
        // save new color
        String colorName = store.getString(event.getProperty());
        RGB rgb = StringConverter.asRGB(colorName);
        Color color = new Color(Display.getCurrent(), rgb);
        colorTable.put(rgb, color);
     }
}