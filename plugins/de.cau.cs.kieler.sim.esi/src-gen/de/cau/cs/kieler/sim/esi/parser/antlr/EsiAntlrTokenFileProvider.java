/*
* generated by Xtext
*/
package de.cau.cs.kieler.sim.esi.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

/** @generated */
public class EsiAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("de/cau/cs/kieler/sim/esi/parser/antlr/internal/InternalEsi.tokens");
	}
}
