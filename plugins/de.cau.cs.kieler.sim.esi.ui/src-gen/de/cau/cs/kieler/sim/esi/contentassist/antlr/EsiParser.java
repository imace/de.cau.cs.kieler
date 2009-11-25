/*
* generated by Xtext
*/
package de.cau.cs.kieler.sim.esi.contentassist.antlr;

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

import de.cau.cs.kieler.sim.esi.services.EsiGrammarAccess;

/** @generated */
public class EsiParser extends AbstractContentAssistParser {
	
	@Inject
	private EsiGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.cau.cs.kieler.sim.esi.contentassist.antlr.internal.InternalEsiLexer createLexer(CharStream stream) {
		return new de.cau.cs.kieler.sim.esi.contentassist.antlr.internal.InternalEsiLexer(stream);
	}
	
	@Override
	protected de.cau.cs.kieler.sim.esi.contentassist.antlr.internal.InternalEsiParser createParser() {
		de.cau.cs.kieler.sim.esi.contentassist.antlr.internal.InternalEsiParser result = new de.cau.cs.kieler.sim.esi.contentassist.antlr.internal.InternalEsiParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				{
					put(grammarAccess.getTracelistAccess().getGroup(), "rule__Tracelist__Group__0");
					put(grammarAccess.getTracelistAccess().getGroup_1(), "rule__Tracelist__Group_1__0");
					put(grammarAccess.getTickAccess().getGroup(), "rule__Tick__Group__0");
					put(grammarAccess.getTickAccess().getGroup_1(), "rule__Tick__Group_1__0");
					put(grammarAccess.getSignalAccess().getGroup(), "rule__Signal__Group__0");
					put(grammarAccess.getSignalAccess().getGroup_1(), "rule__Signal__Group_1__0");
					put(grammarAccess.getTracelistAccess().getTracesAssignment_0(), "rule__Tracelist__TracesAssignment_0");
					put(grammarAccess.getTracelistAccess().getTracesAssignment_1_3(), "rule__Tracelist__TracesAssignment_1_3");
					put(grammarAccess.getTraceAccess().getTicksAssignment(), "rule__Trace__TicksAssignment");
					put(grammarAccess.getTickAccess().getInputAssignment_0(), "rule__Tick__InputAssignment_0");
					put(grammarAccess.getTickAccess().getOutputAssignment_1_3(), "rule__Tick__OutputAssignment_1_3");
					put(grammarAccess.getTickAccess().getNAssignment_2(), "rule__Tick__NAssignment_2");
					put(grammarAccess.getSignalAccess().getNameAssignment_0(), "rule__Signal__NameAssignment_0");
					put(grammarAccess.getSignalAccess().getValuedAssignment_1_0(), "rule__Signal__ValuedAssignment_1_0");
					put(grammarAccess.getSignalAccess().getValAssignment_1_1(), "rule__Signal__ValAssignment_1_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.cau.cs.kieler.sim.esi.contentassist.antlr.internal.InternalEsiParser typedParser = (de.cau.cs.kieler.sim.esi.contentassist.antlr.internal.InternalEsiParser) parser;
			typedParser.entryRuletracelist();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_COMMENT" };
	}
	
	public EsiGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(EsiGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
