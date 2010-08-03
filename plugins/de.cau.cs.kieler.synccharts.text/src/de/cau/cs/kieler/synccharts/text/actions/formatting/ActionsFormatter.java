/*
 * generated by Xtext
 */
package de.cau.cs.kieler.synccharts.text.actions.formatting;

import org.eclipse.xtext.formatting.impl.FormattingConfig;

import de.cau.cs.kieler.core.expressions.formatting.ExpressionsFormatter;
import de.cau.cs.kieler.synccharts.text.actions.services.ActionsGrammarAccess;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class ActionsFormatter extends ExpressionsFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {
		ActionsGrammarAccess f = (ActionsGrammarAccess) getGrammarAccess();
		customConfigureFormatting(c, f);
	}

	
	/**
	 * Method contains actual formatting instructions while GrammarAccess class
	 * maybe parameterized allowing the reuse within ActionsFormatter. 
	 * @param c FormattingConfig provided by caller
	 * @param f GrammarAccess provided by caller
	 */
	protected void customConfigureFormatting(FormattingConfig c, ActionsGrammarAccess f) {
		super.customConfigureFormatting(c, f.getExpressionsGrammarAccess());
		
		// avoid space in valued Emission like 'X (5 + 7)' -> 'X(5 + 7)'
		c.setNoSpace().before(f.getEmissionAccess().getLeftParenthesisKeyword_1_0());
		
		// avoid space in textual effect like '/ "foo" (java)' -> '/ "foo"(java)' 
		c.setNoSpace().before(f.getTextEffectAccess().getLeftParenthesisKeyword_1_0());
		
		
	}
}
