/*
* generated by Xtext
*/
package de.cau.cs.kieler.core.kexpressions.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import de.cau.cs.kieler.core.kexpressions.services.KExpressionsGrammarAccess;

public class KExpressionsParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private KExpressionsGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected de.cau.cs.kieler.core.kexpressions.parser.antlr.internal.InternalKExpressionsParser createParser(XtextTokenStream stream) {
		return new de.cau.cs.kieler.core.kexpressions.parser.antlr.internal.InternalKExpressionsParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Root";
	}
	
	public KExpressionsGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(KExpressionsGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
