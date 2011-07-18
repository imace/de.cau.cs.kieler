/*
* generated by Xtext
*/
package de.cau.cs.kieler.synccharts.text.kitsState.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import de.cau.cs.kieler.synccharts.text.kitsState.services.KitsStateGrammarAccess;

public class KitsStateParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private KitsStateGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected de.cau.cs.kieler.synccharts.text.kitsState.parser.antlr.internal.InternalKitsStateParser createParser(XtextTokenStream stream) {
		return new de.cau.cs.kieler.synccharts.text.kitsState.parser.antlr.internal.InternalKitsStateParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "RootState";
	}
	
	public KitsStateGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(KitsStateGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
