/*
* generated by Xtext
*/
package de.cau.cs.kieler.krep.editors.rif.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import de.cau.cs.kieler.krep.editors.rif.services.RifGrammarAccess;

public class RifParser extends AbstractContentAssistParser {
	
	@Inject
	private RifGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.cau.cs.kieler.krep.editors.rif.contentassist.antlr.internal.InternalRifParser createParser() {
		de.cau.cs.kieler.krep.editors.rif.contentassist.antlr.internal.InternalRifParser result = new de.cau.cs.kieler.krep.editors.rif.contentassist.antlr.internal.InternalRifParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getTypeAccess().getAlternatives(), "rule__Type__Alternatives");
					put(grammarAccess.getDataAccess().getAlternatives(), "rule__Data__Alternatives");
					put(grammarAccess.getTraceAccess().getGroup(), "rule__Trace__Group__0");
					put(grammarAccess.getDeclAccess().getGroup(), "rule__Decl__Group__0");
					put(grammarAccess.getTickAccess().getGroup(), "rule__Tick__Group__0");
					put(grammarAccess.getStatusAccess().getGroup(), "rule__Status__Group__0");
					put(grammarAccess.getTraceAccess().getInputsAssignment_1(), "rule__Trace__InputsAssignment_1");
					put(grammarAccess.getTraceAccess().getOutputsAssignment_4(), "rule__Trace__OutputsAssignment_4");
					put(grammarAccess.getTraceAccess().getLocalAssignment_7(), "rule__Trace__LocalAssignment_7");
					put(grammarAccess.getTraceAccess().getTickAssignment_9(), "rule__Trace__TickAssignment_9");
					put(grammarAccess.getDeclAccess().getNameAssignment_0(), "rule__Decl__NameAssignment_0");
					put(grammarAccess.getDeclAccess().getTypeAssignment_2(), "rule__Decl__TypeAssignment_2");
					put(grammarAccess.getTickAccess().getNrAssignment_2(), "rule__Tick__NrAssignment_2");
					put(grammarAccess.getTickAccess().getInputAssignment_3(), "rule__Tick__InputAssignment_3");
					put(grammarAccess.getTickAccess().getOutputAssignment_5(), "rule__Tick__OutputAssignment_5");
					put(grammarAccess.getTickAccess().getLocalAssignment_7(), "rule__Tick__LocalAssignment_7");
					put(grammarAccess.getDataAccess().getIntValAssignment_0(), "rule__Data__IntValAssignment_0");
					put(grammarAccess.getDataAccess().getTrueAssignment_1(), "rule__Data__TrueAssignment_1");
					put(grammarAccess.getDataAccess().getFalseAssignment_2(), "rule__Data__FalseAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.cau.cs.kieler.krep.editors.rif.contentassist.antlr.internal.InternalRifParser typedParser = (de.cau.cs.kieler.krep.editors.rif.contentassist.antlr.internal.InternalRifParser) parser;
			typedParser.entryRuleTrace();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_COMMENT" };
	}
	
	public RifGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(RifGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
