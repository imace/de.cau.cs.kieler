/*
 * generated by Xtext
 */
package de.cau.cs.kieler.synccharts.text.interfaces.formatting;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

import de.cau.cs.kieler.synccharts.text.interfaces.services.InterfacesGrammarAccess;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class InterfacesFormatter extends AbstractDeclarativeFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {
	      InterfacesGrammarAccess ga = (InterfacesGrammarAccess) getGrammarAccess();
	        c.setWhitespaceRule(ga.getWSRule());

	        // stop formatter breaking before SL comment
	        c.setNoLinewrap().before(ga.getSL_COMMENTRule());

	        // break line after a signal declaration rule finished
	        c.setLinewrap().after(ga.getSignalsAccess().getSemicolonKeyword_1());
	        c.setLinewrap().after(
	                ga.getOutputSignalsAccess().getSemicolonKeyword_1());
	        c.setLinewrap().after(
	                ga.getInputSignalsAccess().getSemicolonKeyword_1());
	        c.setLinewrap().after(
	                ga.getInOutputSignalsAccess().getSemicolonKeyword_1());
	  
	        // break line after region declaration
	        c.setLinewrap().after(
	                ga.getRegionSignalDecAccess().getSemicolonKeyword_4());

	        // no spaces before comma
	        c.setNoSpace().before(
	                ga.getInputSignalsAccess().getCommaKeyword_0_1_0());
	        c.setNoSpace().before(
	                ga.getOutputSignalsAccess().getCommaKeyword_0_1_0());
	        c.setNoSpace().before(
	                ga.getInOutputSignalsAccess().getCommaKeyword_0_1_0());
	        c.setNoSpace().before(ga.getSignalsAccess().getCommaKeyword_0_1_0());
	        c.setNoSpace().before(
	                ga.getRegionSignalDecAccess().getCommaKeyword_2_0_2_0());
	        c.setNoSpace().before(
	                ga.getRegionSignalDecAccess().getCommaKeyword_2_1_2_0());
	        c.setNoSpace().before(
	                ga.getRegionSignalDecAccess().getCommaKeyword_3_0_0());
	        c.setNoSpace().before(
	                ga.getRegionSignalDecAccess().getCommaKeyword_3_0_3_0());
	        c.setNoSpace().before(
	                ga.getRegionSignalDecAccess().getCommaKeyword_3_1_0());
	        c.setNoSpace().before(
	                ga.getRegionSignalDecAccess().getCommaKeyword_3_1_3_0());
	        // as well as semicolon
	        c.setNoSpace().before(
	                ga.getInputSignalsAccess().getSemicolonKeyword_1());
	        c.setNoSpace().before(
	                ga.getOutputSignalsAccess().getSemicolonKeyword_1());
	        c.setNoSpace().before(
	                ga.getInOutputSignalsAccess().getSemicolonKeyword_1());
	        c.setNoSpace().before(ga.getSignalsAccess().getSemicolonKeyword_1());
	        c.setNoSpace().before(
	                ga.getRegionSignalDecAccess().getSemicolonKeyword_4());
	        // as well as colon for regions
	        c.setNoSpace()
	                .before(ga.getRegionSignalDecAccess().getColonKeyword_1());
	}
}
