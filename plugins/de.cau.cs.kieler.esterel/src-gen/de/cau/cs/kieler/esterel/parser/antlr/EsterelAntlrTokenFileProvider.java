/*
* generated by Xtext
*/
package de.cau.cs.kieler.esterel.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class EsterelAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("de/cau/cs/kieler/esterel/parser/antlr/internal/InternalEsterel.tokens");
	}
}