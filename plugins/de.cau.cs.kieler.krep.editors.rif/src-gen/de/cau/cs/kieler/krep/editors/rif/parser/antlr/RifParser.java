/*
* generated by Xtext
*/
package de.cau.cs.kieler.krep.editors.rif.parser.antlr;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.google.inject.Inject;

import de.cau.cs.kieler.krep.editors.rif.services.RifGrammarAccess;

public class RifParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private RifGrammarAccess grammarAccess;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in) {
		TokenSource tokenSource = createLexer(in);
		XtextTokenStream tokenStream = createTokenStream(tokenSource);
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_COMMENT");
		de.cau.cs.kieler.krep.editors.rif.parser.antlr.internal.InternalRifParser parser = createParser(tokenStream);
		parser.setTokenTypeMap(getTokenDefProvider().getTokenDefMap());
		try {
			if(ruleName != null)
				return parser.parse(ruleName);
			return parser.parse();
		} catch (Exception re) {
			throw new ParseException(re.getMessage(),re);
		}
	}
	
	protected de.cau.cs.kieler.krep.editors.rif.parser.antlr.internal.InternalRifParser createParser(XtextTokenStream stream) {
		return new de.cau.cs.kieler.krep.editors.rif.parser.antlr.internal.InternalRifParser(stream, getElementFactory(), getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Trace";
	}
	
	public RifGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(RifGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
