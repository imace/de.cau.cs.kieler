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
package de.cau.cs.kieler.kiml.graphviz.formatting;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * See <a href="http://wiki.eclipse.org/Xtext/Documentation#Formatting">
 * http://wiki.eclipse.org/Xtext/Documentation#Formatting</a>
 * on how and when to use it. 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example.
 * 
 * @kieler.rating 2010-01-26 proposed yellow msp
 */
public class DotFormatter extends AbstractDeclarativeFormatter {
	
    /**
     * {@inheritDoc}
     */
	@Override
	protected void configureFormatting(FormattingConfig c) {
//		de.cau.cs.kieler.kiml.graphviz.services.DotGrammarAccess f =
//		    (de.cau.cs.kieler.kiml.graphviz.services.DotGrammarAccess) getGrammarAccess();
	}
	
}
