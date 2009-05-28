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
package de.cau.cs.kieler.taglets;

import java.util.Map;

import com.sun.javadoc.Tag;
import com.sun.tools.doclets.Taglet;

/**
 * Taglet for generated code.
 * 
 * @author msp
 */
public class GeneratedTaglet implements Taglet {

    /** the name of this taglet */
    private final String NAME = "generated";
    /** indicator for elements that are NOT generated */
    private final String NEGATION = "NOT";
    /** printed header for generated elements */
    private final String POS_HEADER = "Generated:";
    /** printed text for generated elements */
    private final String POS_TEXT = "This code was automatically generated.";
    /** printed header for elements that are NOT generated */
    private final String NEG_HEADER = "Not generated:";
    /** printed text for elements that are NOT generated */
    private final String NEG_TEXT = "This code was hand-written.";
    
    /* (non-Javadoc)
     * @see com.sun.tools.doclets.Taglet#getName()
     */
    public String getName() {
        return NAME;
    }

    /* (non-Javadoc)
     * @see com.sun.tools.doclets.Taglet#inConstructor()
     */
    public boolean inConstructor() {
        return true;
    }

    /* (non-Javadoc)
     * @see com.sun.tools.doclets.Taglet#inField()
     */
    public boolean inField() {
        return true;
    }

    /* (non-Javadoc)
     * @see com.sun.tools.doclets.Taglet#inMethod()
     */
    public boolean inMethod() {
        return true;
    }

    /* (non-Javadoc)
     * @see com.sun.tools.doclets.Taglet#inOverview()
     */
    public boolean inOverview() {
        return false;
    }

    /* (non-Javadoc)
     * @see com.sun.tools.doclets.Taglet#inPackage()
     */
    public boolean inPackage() {
        return true;
    }

    /* (non-Javadoc)
     * @see com.sun.tools.doclets.Taglet#inType()
     */
    public boolean inType() {
        return true;
    }

    /* (non-Javadoc)
     * @see com.sun.tools.doclets.Taglet#isInlineTag()
     */
    public boolean isInlineTag() {
        return false;
    }

    /* (non-Javadoc)
     * @see com.sun.tools.doclets.Taglet#toString(com.sun.javadoc.Tag)
     */
    public String toString(Tag tag) {
        return getOutput(!tag.text().startsWith(NEGATION));
    }

    /* (non-Javadoc)
     * @see com.sun.tools.doclets.Taglet#toString(com.sun.javadoc.Tag[])
     */
    public String toString(Tag[] tagArray) {
        for (Tag tag : tagArray) {
            if (tag.text().startsWith(NEGATION))
                return getOutput(false);
        }
        return getOutput(true);
    }
    
    /**
     * Writes the output string for this taglet.
     * 
     * @param isGenerated indicates whether the corresponding element was
     *     generated or not
     * @return an HTML formatted string
     */
    private String getOutput(boolean isGenerated) {
        if (isGenerated)
            return "<dt><b>" + POS_HEADER + "</b><dd>" + POS_TEXT + "</dd>\n";
        else
            return "<dt><b>" + NEG_HEADER + "</b><dd>" + NEG_TEXT + "</dd>\n";
    }
    
    /**
     * Register this Taglet.
     * 
     * @param tagletMap the map to register this tag to
     */
    @SuppressWarnings("unchecked")
    public static void register(Map tagletMap) {
        GeneratedTaglet generatedTaglet = new GeneratedTaglet();
        Taglet taglet = (Taglet)tagletMap.get(generatedTaglet.getName());
        if (taglet != null) {
            tagletMap.remove(generatedTaglet.getName());
        }
        tagletMap.put(generatedTaglet.getName(), generatedTaglet);
    }

}
