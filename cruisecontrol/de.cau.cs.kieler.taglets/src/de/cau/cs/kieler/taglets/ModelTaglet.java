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
import java.util.StringTokenizer;

import com.sun.javadoc.Tag;
import com.sun.tools.doclets.Taglet;

/**
 * 
 * @author msp
 */
public class ModelTaglet implements Taglet {

    /** the name of this taglet */
    private final String NAME = "model";
    /** printed header for this taglet */
    private final String HEADER = "Model element:";
    
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
        return false;
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
        return toString(new Tag[] {tag});
    }

    /* (non-Javadoc)
     * @see com.sun.tools.doclets.Taglet#toString(com.sun.javadoc.Tag[])
     */
    public String toString(Tag[] tagArray) {
        StringBuffer output = new StringBuffer("<dt><b>" + HEADER + "</b><dd><table>");
        for (Tag tag : tagArray) {
            StringTokenizer tokenizer = new StringTokenizer(tag.text(), " \n\r\t");
            while (tokenizer.hasMoreTokens()) {
                String nextToken = tokenizer.nextToken();
                int separatorPos = nextToken.indexOf('=');
                if (separatorPos > 0) {
                    String valueString = nextToken.substring(separatorPos + 1);
                    if (valueString.charAt(0) == '\"'
                        && valueString.charAt(valueString.length()-1) == '\"')
                        valueString = valueString.substring(1, valueString.length() - 1);
                    output.append("<tr><td>" + nextToken.substring(0, separatorPos)
                            + "</td><td>=</td><td><i>" + valueString
                            + "</i></td></tr>");
                }
            }
        }
        output.append("</table></dd>\n");
        return output.toString();
    }

    /**
     * Register this Taglet.
     * 
     * @param tagletMap the map to register this tag to
     */
    @SuppressWarnings("unchecked")
    public static void register(Map tagletMap) {
        Taglet newTaglet = new ModelTaglet();
        Taglet oldTaglet = (Taglet)tagletMap.get(newTaglet.getName());
        if (oldTaglet != null) {
            tagletMap.remove(newTaglet.getName());
        }
        tagletMap.put(newTaglet.getName(), newTaglet);
    }
    
}
