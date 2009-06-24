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
 */
package de.cau.cs.kieler.kiml.layout.services;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Sp&ouml;nemann</a>
 */
public class LayoutProviderData {

    public static final int MIN_SUPPORT_PRIORITY = Integer.MIN_VALUE >> 1;
    
    private static class SupportedDiagram {
        String type;
        int priority = 0;
    }
    
    public String id;
    
    public String name;
    
    public AbstractLayoutProvider instance;
    
    public String type = "";
    
    public String collection = "";
    
    public List<String> knownOptions = new LinkedList<String>();
    
    public List<SupportedDiagram> supportedDiagrams = new LinkedList<SupportedDiagram>();

    public void addSupportedDiagram(String diagramType, int priority) {
        if (diagramType != null) {
            SupportedDiagram newSupported = new SupportedDiagram();
            newSupported.type = diagramType;
            newSupported.priority = priority;
            supportedDiagrams.add(newSupported);
        }
    }
    
    public int getSupportedPriority(String diagramType) {
        if (diagramType != null) {
            for (SupportedDiagram supportedDiagram : supportedDiagrams) {
                if (diagramType.equals(supportedDiagram.type))
                    return supportedDiagram.priority;
            }
        }
        return MIN_SUPPORT_PRIORITY;
    }
    
}
