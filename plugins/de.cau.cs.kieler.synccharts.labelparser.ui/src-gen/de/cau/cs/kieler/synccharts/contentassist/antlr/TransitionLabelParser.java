/*
* generated by Xtext
*/
package de.cau.cs.kieler.synccharts.contentassist.antlr;

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

import de.cau.cs.kieler.synccharts.services.TransitionLabelGrammarAccess;

public class TransitionLabelParser extends AbstractContentAssistParser {
	
	@Inject
	private TransitionLabelGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.cau.cs.kieler.synccharts.contentassist.antlr.internal.InternalTransitionLabelLexer createLexer(CharStream stream) {
		return new de.cau.cs.kieler.synccharts.contentassist.antlr.internal.InternalTransitionLabelLexer(stream);
	}
	
	@Override
	protected de.cau.cs.kieler.synccharts.contentassist.antlr.internal.InternalTransitionLabelParser createParser() {
		de.cau.cs.kieler.synccharts.contentassist.antlr.internal.InternalTransitionLabelParser result = new de.cau.cs.kieler.synccharts.contentassist.antlr.internal.InternalTransitionLabelParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				{
					put(grammarAccess.getModelAccess().getAlternatives_0(), "rule__Model__Alternatives_0");
					put(grammarAccess.getEffectAccess().getAlternatives(), "rule__Effect__Alternatives");
					put(grammarAccess.getValueAccess().getAlternatives(), "rule__Value__Alternatives");
					put(grammarAccess.getValueExpressionAccess().getAlternatives(), "rule__ValueExpression__Alternatives");
					put(grammarAccess.getNotOrNormalExpressionAccess().getAlternatives(), "rule__NotOrNormalExpression__Alternatives");
					put(grammarAccess.getBooleanExpressionAccess().getAlternatives(), "rule__BooleanExpression__Alternatives");
					put(grammarAccess.getOperatorKindAccess().getAlternatives(), "rule__OperatorKind__Alternatives");
					put(grammarAccess.getCompareOperatorAccess().getAlternatives(), "rule__CompareOperator__Alternatives");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getModelAccess().getGroup_1(), "rule__Model__Group_1__0");
					put(grammarAccess.getActionAccess().getGroup(), "rule__Action__Group__0");
					put(grammarAccess.getActionAccess().getGroup_1(), "rule__Action__Group_1__0");
					put(grammarAccess.getEmissionAccess().getGroup(), "rule__Emission__Group__0");
					put(grammarAccess.getEmissionAccess().getGroup_1(), "rule__Emission__Group_1__0");
					put(grammarAccess.getAssignmentAccess().getGroup(), "rule__Assignment__Group__0");
					put(grammarAccess.getSignalAccess().getGroup(), "rule__Signal__Group__0");
					put(grammarAccess.getVariableAccess().getGroup(), "rule__Variable__Group__0");
					put(grammarAccess.getValOperationAccess().getGroup(), "rule__ValOperation__Group__0");
					put(grammarAccess.getCompareOperationAccess().getGroup(), "rule__CompareOperation__Group__0");
					put(grammarAccess.getCompareOperationAccess().getGroup_1(), "rule__CompareOperation__Group_1__0");
					put(grammarAccess.getNotOperationAccess().getGroup(), "rule__NotOperation__Group__0");
					put(grammarAccess.getAndOperationAccess().getGroup(), "rule__AndOperation__Group__0");
					put(grammarAccess.getAndOperationAccess().getGroup_1(), "rule__AndOperation__Group_1__0");
					put(grammarAccess.getOrOperationAccess().getGroup(), "rule__OrOperation__Group__0");
					put(grammarAccess.getOrOperationAccess().getGroup_1(), "rule__OrOperation__Group_1__0");
					put(grammarAccess.getBooleanExpressionAccess().getGroup_3(), "rule__BooleanExpression__Group_3__0");
					put(grammarAccess.getModelAccess().getSignalsAssignment_0_0(), "rule__Model__SignalsAssignment_0_0");
					put(grammarAccess.getModelAccess().getVariablesAssignment_0_1(), "rule__Model__VariablesAssignment_0_1");
					put(grammarAccess.getModelAccess().getActionsAssignment_1_0(), "rule__Model__ActionsAssignment_1_0");
					put(grammarAccess.getActionAccess().getTriggerAssignment_0(), "rule__Action__TriggerAssignment_0");
					put(grammarAccess.getActionAccess().getEffectsAssignment_1_1(), "rule__Action__EffectsAssignment_1_1");
					put(grammarAccess.getEmissionAccess().getSignalAssignment_0(), "rule__Emission__SignalAssignment_0");
					put(grammarAccess.getEmissionAccess().getNewValueAssignment_1_1(), "rule__Emission__NewValueAssignment_1_1");
					put(grammarAccess.getAssignmentAccess().getVariableAssignment_0(), "rule__Assignment__VariableAssignment_0");
					put(grammarAccess.getAssignmentAccess().getExpressionAssignment_2(), "rule__Assignment__ExpressionAssignment_2");
					put(grammarAccess.getSignalReferenceAccess().getReferenceAssignment(), "rule__SignalReference__ReferenceAssignment");
					put(grammarAccess.getVariableReferenceAccess().getReferenceAssignment(), "rule__VariableReference__ReferenceAssignment");
					put(grammarAccess.getSignalAccess().getNameAssignment_1(), "rule__Signal__NameAssignment_1");
					put(grammarAccess.getVariableAccess().getNameAssignment_1(), "rule__Variable__NameAssignment_1");
					put(grammarAccess.getIntValueAccess().getValueAssignment(), "rule__IntValue__ValueAssignment");
					put(grammarAccess.getFloatValueAccess().getValueAssignment(), "rule__FloatValue__ValueAssignment");
					put(grammarAccess.getBooleanValueAccess().getValueAssignment(), "rule__BooleanValue__ValueAssignment");
					put(grammarAccess.getHostCodeAccess().getCodeAssignment(), "rule__HostCode__CodeAssignment");
					put(grammarAccess.getOperatorAccess().getOperatorKindAssignment(), "rule__Operator__OperatorKindAssignment");
					put(grammarAccess.getValOperationAccess().getOperatorAssignment_0(), "rule__ValOperation__OperatorAssignment_0");
					put(grammarAccess.getValOperationAccess().getSubExpressionsAssignment_1(), "rule__ValOperation__SubExpressionsAssignment_1");
					put(grammarAccess.getCompareOperationAccess().getOperatorAssignment_1_1(), "rule__CompareOperation__OperatorAssignment_1_1");
					put(grammarAccess.getCompareOperationAccess().getSubExpressionsAssignment_1_2(), "rule__CompareOperation__SubExpressionsAssignment_1_2");
					put(grammarAccess.getNotOperationAccess().getOperatorsAssignment_0(), "rule__NotOperation__OperatorsAssignment_0");
					put(grammarAccess.getNotOperationAccess().getSubExpressionsAssignment_1(), "rule__NotOperation__SubExpressionsAssignment_1");
					put(grammarAccess.getAndOperationAccess().getOperatorAssignment_1_1(), "rule__AndOperation__OperatorAssignment_1_1");
					put(grammarAccess.getAndOperationAccess().getSubExpressionAssignment_1_2(), "rule__AndOperation__SubExpressionAssignment_1_2");
					put(grammarAccess.getOrOperationAccess().getOperatorAssignment_1_1(), "rule__OrOperation__OperatorAssignment_1_1");
					put(grammarAccess.getOrOperationAccess().getSubExpressionsAssignment_1_2(), "rule__OrOperation__SubExpressionsAssignment_1_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.cau.cs.kieler.synccharts.contentassist.antlr.internal.InternalTransitionLabelParser typedParser = (de.cau.cs.kieler.synccharts.contentassist.antlr.internal.InternalTransitionLabelParser) parser;
			typedParser.entryRuleModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public TransitionLabelGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(TransitionLabelGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
