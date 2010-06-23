/*
* generated by Xtext
*/
package de.cau.cs.kieler.core.expressions.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import de.cau.cs.kieler.core.expressions.services.ExpressionsGrammarAccess;

public class ExpressionsParser extends AbstractContentAssistParser {
	
	@Inject
	private ExpressionsGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.cau.cs.kieler.core.expressions.ui.contentassist.antlr.internal.InternalExpressionsParser createParser() {
		de.cau.cs.kieler.core.expressions.ui.contentassist.antlr.internal.InternalExpressionsParser result = new de.cau.cs.kieler.core.expressions.ui.contentassist.antlr.internal.InternalExpressionsParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getNotExpressionAccess().getAlternatives(), "rule__NotExpression__Alternatives");
					put(grammarAccess.getAtomicExpressionAccess().getAlternatives(), "rule__AtomicExpression__Alternatives");
					put(grammarAccess.getAtomicValuedExpressionAccess().getAlternatives(), "rule__AtomicValuedExpression__Alternatives");
					put(grammarAccess.getEFloatObjectAccess().getAlternatives_4_0(), "rule__EFloatObject__Alternatives_4_0");
					put(grammarAccess.getEBooleanObjectAccess().getAlternatives(), "rule__EBooleanObject__Alternatives");
					put(grammarAccess.getEStringAccess().getAlternatives(), "rule__EString__Alternatives");
					put(grammarAccess.getCompareOperatorAccess().getAlternatives(), "rule__CompareOperator__Alternatives");
					put(grammarAccess.getValueTypeAccess().getAlternatives(), "rule__ValueType__Alternatives");
					put(grammarAccess.getCombineOperatorAccess().getAlternatives(), "rule__CombineOperator__Alternatives");
					put(grammarAccess.getOrExpressionAccess().getGroup(), "rule__OrExpression__Group__0");
					put(grammarAccess.getOrExpressionAccess().getGroup_1(), "rule__OrExpression__Group_1__0");
					put(grammarAccess.getAndExpressionAccess().getGroup(), "rule__AndExpression__Group__0");
					put(grammarAccess.getAndExpressionAccess().getGroup_1(), "rule__AndExpression__Group_1__0");
					put(grammarAccess.getNotExpressionAccess().getGroup_1(), "rule__NotExpression__Group_1__0");
					put(grammarAccess.getAtomicExpressionAccess().getGroup_2(), "rule__AtomicExpression__Group_2__0");
					put(grammarAccess.getAtomicExpressionAccess().getGroup_3(), "rule__AtomicExpression__Group_3__0");
					put(grammarAccess.getAtomicExpressionAccess().getGroup_4(), "rule__AtomicExpression__Group_4__0");
					put(grammarAccess.getCompareOperationAccess().getGroup(), "rule__CompareOperation__Group__0");
					put(grammarAccess.getCompareOperationAccess().getGroup_1(), "rule__CompareOperation__Group_1__0");
					put(grammarAccess.getAddExpressionAccess().getGroup(), "rule__AddExpression__Group__0");
					put(grammarAccess.getAddExpressionAccess().getGroup_1(), "rule__AddExpression__Group_1__0");
					put(grammarAccess.getSubExpressionAccess().getGroup(), "rule__SubExpression__Group__0");
					put(grammarAccess.getSubExpressionAccess().getGroup_1(), "rule__SubExpression__Group_1__0");
					put(grammarAccess.getMultExpressionAccess().getGroup(), "rule__MultExpression__Group__0");
					put(grammarAccess.getMultExpressionAccess().getGroup_1(), "rule__MultExpression__Group_1__0");
					put(grammarAccess.getModExpressionAccess().getGroup(), "rule__ModExpression__Group__0");
					put(grammarAccess.getModExpressionAccess().getGroup_1(), "rule__ModExpression__Group_1__0");
					put(grammarAccess.getAtomicValuedExpressionAccess().getGroup_5(), "rule__AtomicValuedExpression__Group_5__0");
					put(grammarAccess.getAtomicValuedExpressionAccess().getGroup_6(), "rule__AtomicValuedExpression__Group_6__0");
					put(grammarAccess.getDivExpressionAccess().getGroup(), "rule__DivExpression__Group__0");
					put(grammarAccess.getValueTestExpressionAccess().getGroup(), "rule__ValueTestExpression__Group__0");
					put(grammarAccess.getPreValueTestExpressionAccess().getGroup(), "rule__PreValueTestExpression__Group__0");
					put(grammarAccess.getTextExpressionAccess().getGroup(), "rule__TextExpression__Group__0");
					put(grammarAccess.getTextExpressionAccess().getGroup_1(), "rule__TextExpression__Group_1__0");
					put(grammarAccess.getEIntegerObjectAccess().getGroup(), "rule__EIntegerObject__Group__0");
					put(grammarAccess.getEFloatObjectAccess().getGroup(), "rule__EFloatObject__Group__0");
					put(grammarAccess.getEFloatObjectAccess().getGroup_4(), "rule__EFloatObject__Group_4__0");
					put(grammarAccess.getOrExpressionAccess().getOperatorAssignment_1_1(), "rule__OrExpression__OperatorAssignment_1_1");
					put(grammarAccess.getOrExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__OrExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getAndExpressionAccess().getOperatorAssignment_1_1(), "rule__AndExpression__OperatorAssignment_1_1");
					put(grammarAccess.getAndExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__AndExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getNotExpressionAccess().getOperatorAssignment_1_1(), "rule__NotExpression__OperatorAssignment_1_1");
					put(grammarAccess.getNotExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__NotExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getAtomicExpressionAccess().getOperatorAssignment_2_1(), "rule__AtomicExpression__OperatorAssignment_2_1");
					put(grammarAccess.getAtomicExpressionAccess().getSubExpressionsAssignment_2_3(), "rule__AtomicExpression__SubExpressionsAssignment_2_3");
					put(grammarAccess.getSignalReferenceAccess().getSignalAssignment(), "rule__SignalReference__SignalAssignment");
					put(grammarAccess.getCompareOperationAccess().getOperatorAssignment_1_1(), "rule__CompareOperation__OperatorAssignment_1_1");
					put(grammarAccess.getCompareOperationAccess().getSubExpressionsAssignment_1_2(), "rule__CompareOperation__SubExpressionsAssignment_1_2");
					put(grammarAccess.getAddExpressionAccess().getOperatorAssignment_1_1(), "rule__AddExpression__OperatorAssignment_1_1");
					put(grammarAccess.getAddExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__AddExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getSubExpressionAccess().getOperatorAssignment_1_1(), "rule__SubExpression__OperatorAssignment_1_1");
					put(grammarAccess.getSubExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__SubExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getMultExpressionAccess().getOperatorAssignment_1_1(), "rule__MultExpression__OperatorAssignment_1_1");
					put(grammarAccess.getMultExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__MultExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getModExpressionAccess().getOperatorAssignment_1_1(), "rule__ModExpression__OperatorAssignment_1_1");
					put(grammarAccess.getModExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__ModExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getDivExpressionAccess().getOperatorAssignment_2(), "rule__DivExpression__OperatorAssignment_2");
					put(grammarAccess.getDivExpressionAccess().getSubExpressionsAssignment_3(), "rule__DivExpression__SubExpressionsAssignment_3");
					put(grammarAccess.getVariableReferenceAccess().getVariableAssignment(), "rule__VariableReference__VariableAssignment");
					put(grammarAccess.getValueTestExpressionAccess().getOperatorAssignment_0(), "rule__ValueTestExpression__OperatorAssignment_0");
					put(grammarAccess.getValueTestExpressionAccess().getSubExpressionsAssignment_2(), "rule__ValueTestExpression__SubExpressionsAssignment_2");
					put(grammarAccess.getPreValueTestExpressionAccess().getOperatorAssignment_0(), "rule__PreValueTestExpression__OperatorAssignment_0");
					put(grammarAccess.getPreValueTestExpressionAccess().getSubExpressionsAssignment_2(), "rule__PreValueTestExpression__SubExpressionsAssignment_2");
					put(grammarAccess.getTextExpressionAccess().getCodeAssignment_0(), "rule__TextExpression__CodeAssignment_0");
					put(grammarAccess.getTextExpressionAccess().getTypeAssignment_1_1(), "rule__TextExpression__TypeAssignment_1_1");
					put(grammarAccess.getIntValueAccess().getValueAssignment(), "rule__IntValue__ValueAssignment");
					put(grammarAccess.getFloatValueAccess().getValueAssignment(), "rule__FloatValue__ValueAssignment");
					put(grammarAccess.getBooleanValueAccess().getValueAssignment(), "rule__BooleanValue__ValueAssignment");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.cau.cs.kieler.core.expressions.ui.contentassist.antlr.internal.InternalExpressionsParser typedParser = (de.cau.cs.kieler.core.expressions.ui.contentassist.antlr.internal.InternalExpressionsParser) parser;
			typedParser.entryRuleExpression();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public ExpressionsGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ExpressionsGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
