/*
 * generated by Xtext
 */
package de.cau.cs.kieler.krep.editors.klp.formatting;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class KlpFormatter extends AbstractDeclarativeFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {
		de.cau.cs.kieler.krep.editors.klp.services.KlpGrammarAccess f = (de.cau.cs.kieler.krep.editors.klp.services.KlpGrammarAccess) getGrammarAccess();

		//...
	}
}
