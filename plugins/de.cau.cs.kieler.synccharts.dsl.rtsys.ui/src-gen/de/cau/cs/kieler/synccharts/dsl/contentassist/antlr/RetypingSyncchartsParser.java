/*
* generated by Xtext
*/
package de.cau.cs.kieler.synccharts.dsl.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import de.cau.cs.kieler.synccharts.dsl.services.RetypingSyncchartsGrammarAccess;

public class RetypingSyncchartsParser extends AbstractContentAssistParser {
	
	@Inject
	private RetypingSyncchartsGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal.InternalRetypingSyncchartsLexer createLexer(CharStream stream) {
		return new de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal.InternalRetypingSyncchartsLexer(stream);
	}
	
	@Override
	protected de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal.InternalRetypingSyncchartsParser createParser() {
		de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal.InternalRetypingSyncchartsParser result = new de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal.InternalRetypingSyncchartsParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				{
					put(grammarAccess.getStateAccess().getGroup(), "rule__State__Group__0");
					put(grammarAccess.getRegionAccess().getInnerStatesAssignment(), "rule__Region__InnerStatesAssignment");
					put(grammarAccess.getStateAccess().getIdAssignment_0(), "rule__State__IdAssignment_0");
					put(grammarAccess.getStateAccess().getLabelAssignment_1(), "rule__State__LabelAssignment_1");
					put(grammarAccess.getStateAccess().getBodyTextAssignment_2(), "rule__State__BodyTextAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal.InternalRetypingSyncchartsParser typedParser = (de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal.InternalRetypingSyncchartsParser) parser;
			typedParser.entryRuleRegion();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public RetypingSyncchartsGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(RetypingSyncchartsGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
