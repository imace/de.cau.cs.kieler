/*
* generated by Xtext
*/
package de.cau.cs.kieler.kiml.graphviz.parser.antlr;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.google.inject.Inject;

import de.cau.cs.kieler.kiml.graphviz.services.DotGrammarAccess;

/** @generated */
public class DotParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject 
    protected ITokenDefProvider antlrTokenDefProvider;
	
	@Inject
	private DotGrammarAccess grammarAccess;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in) {
		de.cau.cs.kieler.kiml.graphviz.parser.antlr.internal.InternalDotLexer lexer = new de.cau.cs.kieler.kiml.graphviz.parser.antlr.internal.InternalDotLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer, antlrTokenDefProvider);
		stream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_PREC_LINE");
		de.cau.cs.kieler.kiml.graphviz.parser.antlr.internal.InternalDotParser parser = new de.cau.cs.kieler.kiml.graphviz.parser.antlr.internal.InternalDotParser(
				stream, getElementFactory(), grammarAccess);
		parser.setTokenTypeMap(antlrTokenDefProvider.getTokenDefMap());
		try {
			if(ruleName != null)
				return parser.parse(ruleName);
			return parser.parse();
		} catch (Exception re) {
			throw new ParseException(re.getMessage(),re);
		}
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "GraphvizModel";
	}
	
	public DotGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(DotGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
