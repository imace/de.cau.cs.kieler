/*
* generated by Xtext
*/
package de.cau.cs.kieler.synccharts.text.actions.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import de.cau.cs.kieler.synccharts.text.actions.services.ActionsGrammarAccess;

public class ActionsParser extends AbstractContentAssistParser {
	
	@Inject
	private ActionsGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.cau.cs.kieler.synccharts.text.actions.ui.contentassist.antlr.internal.InternalActionsParser createParser() {
		de.cau.cs.kieler.synccharts.text.actions.ui.contentassist.antlr.internal.InternalActionsParser result = new de.cau.cs.kieler.synccharts.text.actions.ui.contentassist.antlr.internal.InternalActionsParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getEffectAccess().getAlternatives(), "rule__Effect__Alternatives");
					put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
					put(grammarAccess.getCompareOperationAccess().getAlternatives(), "rule__CompareOperation__Alternatives");
					put(grammarAccess.getNotOrValuedExpressionAccess().getAlternatives(), "rule__NotOrValuedExpression__Alternatives");
					put(grammarAccess.getNotExpressionAccess().getAlternatives(), "rule__NotExpression__Alternatives");
					put(grammarAccess.getAtomicExpressionAccess().getAlternatives(), "rule__AtomicExpression__Alternatives");
					put(grammarAccess.getAtomicValuedExpressionAccess().getAlternatives(), "rule__AtomicValuedExpression__Alternatives");
					put(grammarAccess.getValuedObjectTestExpressionAccess().getAlternatives(), "rule__ValuedObjectTestExpression__Alternatives");
					put(grammarAccess.getAnyTypeAccess().getAlternatives(), "rule__AnyType__Alternatives");
					put(grammarAccess.getStringAnnotationAccess().getAlternatives(), "rule__StringAnnotation__Alternatives");
					put(grammarAccess.getEStringAccess().getAlternatives(), "rule__EString__Alternatives");
					put(grammarAccess.getCompareOperatorAccess().getAlternatives(), "rule__CompareOperator__Alternatives");
					put(grammarAccess.getValueTypeAccess().getAlternatives(), "rule__ValueType__Alternatives");
					put(grammarAccess.getCombineOperatorAccess().getAlternatives(), "rule__CombineOperator__Alternatives");
					put(grammarAccess.getTransitionAccess().getGroup(), "rule__Transition__Group__0");
					put(grammarAccess.getTransitionAccess().getGroup_4(), "rule__Transition__Group_4__0");
					put(grammarAccess.getTransitionAccess().getGroup_4_2(), "rule__Transition__Group_4_2__0");
					put(grammarAccess.getActionAccess().getGroup(), "rule__Action__Group__0");
					put(grammarAccess.getActionAccess().getGroup_4(), "rule__Action__Group_4__0");
					put(grammarAccess.getActionAccess().getGroup_4_1(), "rule__Action__Group_4_1__0");
					put(grammarAccess.getEmissionAccess().getGroup(), "rule__Emission__Group__0");
					put(grammarAccess.getEmissionAccess().getGroup_1(), "rule__Emission__Group_1__0");
					put(grammarAccess.getAssignmentAccess().getGroup(), "rule__Assignment__Group__0");
					put(grammarAccess.getTextEffectAccess().getGroup(), "rule__TextEffect__Group__0");
					put(grammarAccess.getTextEffectAccess().getGroup_1(), "rule__TextEffect__Group_1__0");
					put(grammarAccess.getOrExpressionAccess().getGroup(), "rule__OrExpression__Group__0");
					put(grammarAccess.getOrExpressionAccess().getGroup_1(), "rule__OrExpression__Group_1__0");
					put(grammarAccess.getAndExpressionAccess().getGroup(), "rule__AndExpression__Group__0");
					put(grammarAccess.getAndExpressionAccess().getGroup_1(), "rule__AndExpression__Group_1__0");
					put(grammarAccess.getCompareOperationAccess().getGroup_0(), "rule__CompareOperation__Group_0__0");
					put(grammarAccess.getCompareOperationAccess().getGroup_0_1(), "rule__CompareOperation__Group_0_1__0");
					put(grammarAccess.getAddExpressionAccess().getGroup(), "rule__AddExpression__Group__0");
					put(grammarAccess.getAddExpressionAccess().getGroup_1(), "rule__AddExpression__Group_1__0");
					put(grammarAccess.getSubExpressionAccess().getGroup(), "rule__SubExpression__Group__0");
					put(grammarAccess.getSubExpressionAccess().getGroup_1(), "rule__SubExpression__Group_1__0");
					put(grammarAccess.getMultExpressionAccess().getGroup(), "rule__MultExpression__Group__0");
					put(grammarAccess.getMultExpressionAccess().getGroup_1(), "rule__MultExpression__Group_1__0");
					put(grammarAccess.getModExpressionAccess().getGroup(), "rule__ModExpression__Group__0");
					put(grammarAccess.getModExpressionAccess().getGroup_1(), "rule__ModExpression__Group_1__0");
					put(grammarAccess.getNotExpressionAccess().getGroup_0(), "rule__NotExpression__Group_0__0");
					put(grammarAccess.getAtomicExpressionAccess().getGroup_2(), "rule__AtomicExpression__Group_2__0");
					put(grammarAccess.getAtomicValuedExpressionAccess().getGroup_2(), "rule__AtomicValuedExpression__Group_2__0");
					put(grammarAccess.getAtomicValuedExpressionAccess().getGroup_3(), "rule__AtomicValuedExpression__Group_3__0");
					put(grammarAccess.getDivExpressionAccess().getGroup(), "rule__DivExpression__Group__0");
					put(grammarAccess.getValuedObjectTestExpressionAccess().getGroup_0(), "rule__ValuedObjectTestExpression__Group_0__0");
					put(grammarAccess.getValuedObjectTestExpressionAccess().getGroup_1(), "rule__ValuedObjectTestExpression__Group_1__0");
					put(grammarAccess.getTextExpressionAccess().getGroup(), "rule__TextExpression__Group__0");
					put(grammarAccess.getTextExpressionAccess().getGroup_1(), "rule__TextExpression__Group_1__0");
					put(grammarAccess.getKeyValueAnnotationAccess().getGroup(), "rule__KeyValueAnnotation__Group__0");
					put(grammarAccess.getTransitionAccess().getIsImmediateAssignment_1(), "rule__Transition__IsImmediateAssignment_1");
					put(grammarAccess.getTransitionAccess().getDelayAssignment_2(), "rule__Transition__DelayAssignment_2");
					put(grammarAccess.getTransitionAccess().getTriggerAssignment_3(), "rule__Transition__TriggerAssignment_3");
					put(grammarAccess.getTransitionAccess().getEffectsAssignment_4_1(), "rule__Transition__EffectsAssignment_4_1");
					put(grammarAccess.getTransitionAccess().getEffectsAssignment_4_2_1(), "rule__Transition__EffectsAssignment_4_2_1");
					put(grammarAccess.getActionAccess().getIsImmediateAssignment_1(), "rule__Action__IsImmediateAssignment_1");
					put(grammarAccess.getActionAccess().getDelayAssignment_2(), "rule__Action__DelayAssignment_2");
					put(grammarAccess.getActionAccess().getTriggerAssignment_3(), "rule__Action__TriggerAssignment_3");
					put(grammarAccess.getActionAccess().getEffectsAssignment_4_1_0(), "rule__Action__EffectsAssignment_4_1_0");
					put(grammarAccess.getEmissionAccess().getSignalAssignment_0(), "rule__Emission__SignalAssignment_0");
					put(grammarAccess.getEmissionAccess().getNewValueAssignment_1_1(), "rule__Emission__NewValueAssignment_1_1");
					put(grammarAccess.getAssignmentAccess().getVariableAssignment_0(), "rule__Assignment__VariableAssignment_0");
					put(grammarAccess.getAssignmentAccess().getExpressionAssignment_2(), "rule__Assignment__ExpressionAssignment_2");
					put(grammarAccess.getTextEffectAccess().getCodeAssignment_0(), "rule__TextEffect__CodeAssignment_0");
					put(grammarAccess.getTextEffectAccess().getTypeAssignment_1_1(), "rule__TextEffect__TypeAssignment_1_1");
					put(grammarAccess.getOrExpressionAccess().getOperatorAssignment_1_1(), "rule__OrExpression__OperatorAssignment_1_1");
					put(grammarAccess.getOrExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__OrExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getAndExpressionAccess().getOperatorAssignment_1_1(), "rule__AndExpression__OperatorAssignment_1_1");
					put(grammarAccess.getAndExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__AndExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getCompareOperationAccess().getOperatorAssignment_0_1_1(), "rule__CompareOperation__OperatorAssignment_0_1_1");
					put(grammarAccess.getCompareOperationAccess().getSubExpressionsAssignment_0_1_2(), "rule__CompareOperation__SubExpressionsAssignment_0_1_2");
					put(grammarAccess.getAddExpressionAccess().getOperatorAssignment_1_1(), "rule__AddExpression__OperatorAssignment_1_1");
					put(grammarAccess.getAddExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__AddExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getSubExpressionAccess().getOperatorAssignment_1_1(), "rule__SubExpression__OperatorAssignment_1_1");
					put(grammarAccess.getSubExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__SubExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getMultExpressionAccess().getOperatorAssignment_1_1(), "rule__MultExpression__OperatorAssignment_1_1");
					put(grammarAccess.getMultExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__MultExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getModExpressionAccess().getOperatorAssignment_1_1(), "rule__ModExpression__OperatorAssignment_1_1");
					put(grammarAccess.getModExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__ModExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getNotExpressionAccess().getOperatorAssignment_0_1(), "rule__NotExpression__OperatorAssignment_0_1");
					put(grammarAccess.getNotExpressionAccess().getSubExpressionsAssignment_0_2(), "rule__NotExpression__SubExpressionsAssignment_0_2");
					put(grammarAccess.getDivExpressionAccess().getOperatorAssignment_2(), "rule__DivExpression__OperatorAssignment_2");
					put(grammarAccess.getDivExpressionAccess().getSubExpressionsAssignment_3(), "rule__DivExpression__SubExpressionsAssignment_3");
					put(grammarAccess.getValuedObjectTestExpressionAccess().getOperatorAssignment_0_1(), "rule__ValuedObjectTestExpression__OperatorAssignment_0_1");
					put(grammarAccess.getValuedObjectTestExpressionAccess().getSubExpressionsAssignment_0_3(), "rule__ValuedObjectTestExpression__SubExpressionsAssignment_0_3");
					put(grammarAccess.getValuedObjectTestExpressionAccess().getOperatorAssignment_1_1(), "rule__ValuedObjectTestExpression__OperatorAssignment_1_1");
					put(grammarAccess.getValuedObjectTestExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__ValuedObjectTestExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getValuedObjectReferenceAccess().getValuedObjectAssignment(), "rule__ValuedObjectReference__ValuedObjectAssignment");
					put(grammarAccess.getTextExpressionAccess().getCodeAssignment_0(), "rule__TextExpression__CodeAssignment_0");
					put(grammarAccess.getTextExpressionAccess().getTypeAssignment_1_1(), "rule__TextExpression__TypeAssignment_1_1");
					put(grammarAccess.getIntValueAccess().getValueAssignment(), "rule__IntValue__ValueAssignment");
					put(grammarAccess.getFloatValueAccess().getValueAssignment(), "rule__FloatValue__ValueAssignment");
					put(grammarAccess.getBooleanValueAccess().getValueAssignment(), "rule__BooleanValue__ValueAssignment");
					put(grammarAccess.getCommentAnnotationAccess().getValueAssignment(), "rule__CommentAnnotation__ValueAssignment");
					put(grammarAccess.getKeyValueAnnotationAccess().getNameAssignment_1(), "rule__KeyValueAnnotation__NameAssignment_1");
					put(grammarAccess.getKeyValueAnnotationAccess().getValueAssignment_2(), "rule__KeyValueAnnotation__ValueAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.cau.cs.kieler.synccharts.text.actions.ui.contentassist.antlr.internal.InternalActionsParser typedParser = (de.cau.cs.kieler.synccharts.text.actions.ui.contentassist.antlr.internal.InternalActionsParser) parser;
			typedParser.entryRuleTransition();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public ActionsGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ActionsGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
