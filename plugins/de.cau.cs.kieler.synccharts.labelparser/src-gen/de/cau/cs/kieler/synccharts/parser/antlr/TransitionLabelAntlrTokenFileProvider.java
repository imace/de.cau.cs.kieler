/*
* generated by Xtext
*/
package de.cau.cs.kieler.synccharts.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class TransitionLabelAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("de/cau/cs/kieler/synccharts/parser/antlr/internal/InternalTransitionLabel.tokens");
	}
}
