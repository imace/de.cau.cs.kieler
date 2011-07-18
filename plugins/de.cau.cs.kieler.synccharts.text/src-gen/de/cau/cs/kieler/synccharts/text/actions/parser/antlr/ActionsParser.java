/*
* generated by Xtext
*/
package de.cau.cs.kieler.synccharts.text.actions.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import de.cau.cs.kieler.synccharts.text.actions.services.ActionsGrammarAccess;

public class ActionsParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private ActionsGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected de.cau.cs.kieler.synccharts.text.actions.parser.antlr.internal.InternalActionsParser createParser(XtextTokenStream stream) {
		return new de.cau.cs.kieler.synccharts.text.actions.parser.antlr.internal.InternalActionsParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Transition";
	}
	
	public ActionsGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ActionsGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
