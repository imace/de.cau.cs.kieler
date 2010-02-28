/*
* generated by Xtext
*/
package de.cau.cs.kieler.synccharts.dsl.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import de.cau.cs.kieler.synccharts.dsl.services.KitsGrammarAccess;

public class KitsParser extends AbstractContentAssistParser {
	
	@Inject
	private KitsGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal.InternalKitsParser createParser() {
		de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal.InternalKitsParser result = new de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal.InternalKitsParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getRegionAccess().getAlternatives_1(), "rule__Region__Alternatives_1");
					put(grammarAccess.getRegionAccess().getAlternatives_2(), "rule__Region__Alternatives_2");
					put(grammarAccess.getStateAccess().getOutgoingTransitionsAlternatives_14_0(), "rule__State__OutgoingTransitionsAlternatives_14_0");
					put(grammarAccess.getTextualTransitionAccess().getAlternatives_1(), "rule__TextualTransition__Alternatives_1");
					put(grammarAccess.getTextualTransitionAccess().getMakeConditionalAlternatives_1_1_0(), "rule__TextualTransition__MakeConditionalAlternatives_1_1_0");
					put(grammarAccess.getValuedObjectAccess().getAlternatives(), "rule__ValuedObject__Alternatives");
					put(grammarAccess.getSignalAccess().getAlternatives_0(), "rule__Signal__Alternatives_0");
					put(grammarAccess.getSignalAccess().getAlternatives_2_1(), "rule__Signal__Alternatives_2_1");
					put(grammarAccess.getSignalAccess().getAlternatives_2_1_1_3(), "rule__Signal__Alternatives_2_1_1_3");
					put(grammarAccess.getEffectAccess().getAlternatives(), "rule__Effect__Alternatives");
					put(grammarAccess.getEmissionAccess().getAlternatives_1(), "rule__Emission__Alternatives_1");
					put(grammarAccess.getAssignmentAccess().getAlternatives_2(), "rule__Assignment__Alternatives_2");
					put(grammarAccess.getValueAccess().getAlternatives(), "rule__Value__Alternatives");
					put(grammarAccess.getParanthesedValueExpressionAccess().getAlternatives(), "rule__ParanthesedValueExpression__Alternatives");
					put(grammarAccess.getMultOrDivOperationAccess().getAlternatives(), "rule__MultOrDivOperation__Alternatives");
					put(grammarAccess.getPreOrNormalValueExpressionAccess().getAlternatives(), "rule__PreOrNormalValueExpression__Alternatives");
					put(grammarAccess.getUnaryOperationAccess().getSubExpressionsAlternatives_1_0(), "rule__UnaryOperation__SubExpressionsAlternatives_1_0");
					put(grammarAccess.getUnaryOrNormalExpressionAccess().getAlternatives(), "rule__UnaryOrNormalExpression__Alternatives");
					put(grammarAccess.getParanthesedBooleanExpressionAccess().getAlternatives(), "rule__ParanthesedBooleanExpression__Alternatives");
					put(grammarAccess.getCombineOperatorAccess().getAlternatives(), "rule__CombineOperator__Alternatives");
					put(grammarAccess.getValueTypeAccess().getAlternatives(), "rule__ValueType__Alternatives");
					put(grammarAccess.getTransitionTypeAccess().getAlternatives(), "rule__TransitionType__Alternatives");
					put(grammarAccess.getOperatorTypeAccess().getAlternatives(), "rule__OperatorType__Alternatives");
					put(grammarAccess.getCompareOperatorAccess().getAlternatives(), "rule__CompareOperator__Alternatives");
					put(grammarAccess.getPlusOperatorAccess().getAlternatives(), "rule__PlusOperator__Alternatives");
					put(grammarAccess.getMultOperatorAccess().getAlternatives(), "rule__MultOperator__Alternatives");
					put(grammarAccess.getRegionAccess().getGroup(), "rule__Region__Group__0");
					put(grammarAccess.getRegionAccess().getGroup_1_0(), "rule__Region__Group_1_0__0");
					put(grammarAccess.getStateAccess().getGroup(), "rule__State__Group__0");
					put(grammarAccess.getStateAccess().getGroup_8(), "rule__State__Group_8__0");
					put(grammarAccess.getStateAccess().getGroup_9(), "rule__State__Group_9__0");
					put(grammarAccess.getStateAccess().getGroup_10(), "rule__State__Group_10__0");
					put(grammarAccess.getStateAccess().getGroup_11(), "rule__State__Group_11__0");
					put(grammarAccess.getStateAccess().getGroup_12(), "rule__State__Group_12__0");
					put(grammarAccess.getStateAccess().getGroup_12_2(), "rule__State__Group_12_2__0");
					put(grammarAccess.getStateAccess().getGroup_13(), "rule__State__Group_13__0");
					put(grammarAccess.getTransitionAccess().getGroup(), "rule__Transition__Group__0");
					put(grammarAccess.getTransitionAccess().getGroup_2(), "rule__Transition__Group_2__0");
					put(grammarAccess.getTransitionAccess().getGroup_2_2(), "rule__Transition__Group_2_2__0");
					put(grammarAccess.getTransitionAccess().getGroup_2_3(), "rule__Transition__Group_2_3__0");
					put(grammarAccess.getTransitionAccess().getGroup_2_3_1(), "rule__Transition__Group_2_3_1__0");
					put(grammarAccess.getTransitionAccess().getGroup_2_3_1_1(), "rule__Transition__Group_2_3_1_1__0");
					put(grammarAccess.getTransitionAccess().getGroup_2_3_1_1_1(), "rule__Transition__Group_2_3_1_1_1__0");
					put(grammarAccess.getTextualTransitionAccess().getGroup(), "rule__TextualTransition__Group__0");
					put(grammarAccess.getTextualTransitionAccess().getGroup_3(), "rule__TextualTransition__Group_3__0");
					put(grammarAccess.getTextualTransitionAccess().getGroup_3_2(), "rule__TextualTransition__Group_3_2__0");
					put(grammarAccess.getTextualTransitionAccess().getGroup_3_3(), "rule__TextualTransition__Group_3_3__0");
					put(grammarAccess.getTextualTransitionAccess().getGroup_3_3_1(), "rule__TextualTransition__Group_3_3_1__0");
					put(grammarAccess.getTextualTransitionAccess().getGroup_3_3_1_1(), "rule__TextualTransition__Group_3_3_1_1__0");
					put(grammarAccess.getVariableAccess().getGroup(), "rule__Variable__Group__0");
					put(grammarAccess.getVariableAccess().getGroup_2(), "rule__Variable__Group_2__0");
					put(grammarAccess.getVariableAccess().getGroup_2_0(), "rule__Variable__Group_2_0__0");
					put(grammarAccess.getSignalAccess().getGroup(), "rule__Signal__Group__0");
					put(grammarAccess.getSignalAccess().getGroup_0_0(), "rule__Signal__Group_0_0__0");
					put(grammarAccess.getSignalAccess().getGroup_2(), "rule__Signal__Group_2__0");
					put(grammarAccess.getSignalAccess().getGroup_2_0(), "rule__Signal__Group_2_0__0");
					put(grammarAccess.getSignalAccess().getGroup_2_1_0(), "rule__Signal__Group_2_1_0__0");
					put(grammarAccess.getSignalAccess().getGroup_2_1_1(), "rule__Signal__Group_2_1_1__0");
					put(grammarAccess.getActionAccess().getGroup(), "rule__Action__Group__0");
					put(grammarAccess.getActionAccess().getGroup_3(), "rule__Action__Group_3__0");
					put(grammarAccess.getActionAccess().getGroup_3_1(), "rule__Action__Group_3_1__0");
					put(grammarAccess.getEmissionAccess().getGroup(), "rule__Emission__Group__0");
					put(grammarAccess.getEmissionAccess().getGroup_1_0(), "rule__Emission__Group_1_0__0");
					put(grammarAccess.getEmissionAccess().getGroup_1_1(), "rule__Emission__Group_1_1__0");
					put(grammarAccess.getAssignmentAccess().getGroup(), "rule__Assignment__Group__0");
					put(grammarAccess.getValOperationAccess().getGroup(), "rule__ValOperation__Group__0");
					put(grammarAccess.getParanthesedValueExpressionAccess().getGroup_5(), "rule__ParanthesedValueExpression__Group_5__0");
					put(grammarAccess.getParanthesedValueExpressionAccess().getGroup_6(), "rule__ParanthesedValueExpression__Group_6__0");
					put(grammarAccess.getPlusOperationAccess().getGroup(), "rule__PlusOperation__Group__0");
					put(grammarAccess.getPlusOperationAccess().getGroup_1(), "rule__PlusOperation__Group_1__0");
					put(grammarAccess.getMultOrDivOperationAccess().getGroup_1(), "rule__MultOrDivOperation__Group_1__0");
					put(grammarAccess.getMultOperationAccess().getGroup(), "rule__MultOperation__Group__0");
					put(grammarAccess.getMultOperationAccess().getGroup_1(), "rule__MultOperation__Group_1__0");
					put(grammarAccess.getDivOperationAccess().getGroup(), "rule__DivOperation__Group__0");
					put(grammarAccess.getDivOperationAccess().getGroup_1(), "rule__DivOperation__Group_1__0");
					put(grammarAccess.getPreArithmOperationAccess().getGroup(), "rule__PreArithmOperation__Group__0");
					put(grammarAccess.getCompareOperationAccess().getGroup(), "rule__CompareOperation__Group__0");
					put(grammarAccess.getCompareOperationAccess().getGroup_1(), "rule__CompareOperation__Group_1__0");
					put(grammarAccess.getUnaryOperationAccess().getGroup(), "rule__UnaryOperation__Group__0");
					put(grammarAccess.getUnaryParanthesedOperationAccess().getGroup(), "rule__UnaryParanthesedOperation__Group__0");
					put(grammarAccess.getAndOperationAccess().getGroup(), "rule__AndOperation__Group__0");
					put(grammarAccess.getAndOperationAccess().getGroup_1(), "rule__AndOperation__Group_1__0");
					put(grammarAccess.getOrOperationAccess().getGroup(), "rule__OrOperation__Group__0");
					put(grammarAccess.getOrOperationAccess().getGroup_1(), "rule__OrOperation__Group_1__0");
					put(grammarAccess.getParanthesedBooleanExpressionAccess().getGroup_5(), "rule__ParanthesedBooleanExpression__Group_5__0");
					put(grammarAccess.getHostCodeAccess().getGroup(), "rule__HostCode__Group__0");
					put(grammarAccess.getHostCodeAccess().getGroup_1(), "rule__HostCode__Group_1__0");
					put(grammarAccess.getRegionAccess().getIdAssignment_1_0_1(), "rule__Region__IdAssignment_1_0_1");
					put(grammarAccess.getRegionAccess().getVariablesAssignment_2_0(), "rule__Region__VariablesAssignment_2_0");
					put(grammarAccess.getRegionAccess().getSignalsAssignment_2_1(), "rule__Region__SignalsAssignment_2_1");
					put(grammarAccess.getRegionAccess().getInnerStatesAssignment_3(), "rule__Region__InnerStatesAssignment_3");
					put(grammarAccess.getStateAccess().getIsInitialAssignment_1(), "rule__State__IsInitialAssignment_1");
					put(grammarAccess.getStateAccess().getIsFinalAssignment_2(), "rule__State__IsFinalAssignment_2");
					put(grammarAccess.getStateAccess().getTypeAssignment_3(), "rule__State__TypeAssignment_3");
					put(grammarAccess.getStateAccess().getIdAssignment_5(), "rule__State__IdAssignment_5");
					put(grammarAccess.getStateAccess().getLabelAssignment_6(), "rule__State__LabelAssignment_6");
					put(grammarAccess.getStateAccess().getSignalsAssignment_7(), "rule__State__SignalsAssignment_7");
					put(grammarAccess.getStateAccess().getEntryActionsAssignment_8_1(), "rule__State__EntryActionsAssignment_8_1");
					put(grammarAccess.getStateAccess().getInnerActionsAssignment_9_1(), "rule__State__InnerActionsAssignment_9_1");
					put(grammarAccess.getStateAccess().getExitActionsAssignment_10_1(), "rule__State__ExitActionsAssignment_10_1");
					put(grammarAccess.getStateAccess().getSuspensionTriggerAssignment_11_1(), "rule__State__SuspensionTriggerAssignment_11_1");
					put(grammarAccess.getStateAccess().getRegionsAssignment_12_1(), "rule__State__RegionsAssignment_12_1");
					put(grammarAccess.getStateAccess().getRegionsAssignment_12_2_1(), "rule__State__RegionsAssignment_12_2_1");
					put(grammarAccess.getStateAccess().getBodyTextAssignment_13_1(), "rule__State__BodyTextAssignment_13_1");
					put(grammarAccess.getStateAccess().getOutgoingTransitionsAssignment_14(), "rule__State__OutgoingTransitionsAssignment_14");
					put(grammarAccess.getTransitionAccess().getTypeAssignment_0(), "rule__Transition__TypeAssignment_0");
					put(grammarAccess.getTransitionAccess().getTargetStateAssignment_1(), "rule__Transition__TargetStateAssignment_1");
					put(grammarAccess.getTransitionAccess().getIsImmediateAssignment_2_1(), "rule__Transition__IsImmediateAssignment_2_1");
					put(grammarAccess.getTransitionAccess().getDelayAssignment_2_2_1(), "rule__Transition__DelayAssignment_2_2_1");
					put(grammarAccess.getTransitionAccess().getTriggerAssignment_2_3_0(), "rule__Transition__TriggerAssignment_2_3_0");
					put(grammarAccess.getTransitionAccess().getEffectsAssignment_2_3_1_1_0(), "rule__Transition__EffectsAssignment_2_3_1_1_0");
					put(grammarAccess.getTransitionAccess().getEffectsAssignment_2_3_1_1_1_1(), "rule__Transition__EffectsAssignment_2_3_1_1_1_1");
					put(grammarAccess.getTransitionAccess().getIsHistoryAssignment_3(), "rule__Transition__IsHistoryAssignment_3");
					put(grammarAccess.getTextualTransitionAccess().getTypeAssignment_0(), "rule__TextualTransition__TypeAssignment_0");
					put(grammarAccess.getTextualTransitionAccess().getMakeConditionalAssignment_1_1(), "rule__TextualTransition__MakeConditionalAssignment_1_1");
					put(grammarAccess.getTextualTransitionAccess().getMakeFinalAssignment_1_2(), "rule__TextualTransition__MakeFinalAssignment_1_2");
					put(grammarAccess.getTextualTransitionAccess().getTargetStateProxyAssignment_2(), "rule__TextualTransition__TargetStateProxyAssignment_2");
					put(grammarAccess.getTextualTransitionAccess().getIsImmediateAssignment_3_1(), "rule__TextualTransition__IsImmediateAssignment_3_1");
					put(grammarAccess.getTextualTransitionAccess().getDelayAssignment_3_2_1(), "rule__TextualTransition__DelayAssignment_3_2_1");
					put(grammarAccess.getTextualTransitionAccess().getTriggerAssignment_3_3_0(), "rule__TextualTransition__TriggerAssignment_3_3_0");
					put(grammarAccess.getTextualTransitionAccess().getEffectsAssignment_3_3_1_1_0(), "rule__TextualTransition__EffectsAssignment_3_3_1_1_0");
					put(grammarAccess.getTextualTransitionAccess().getIsHistoryAssignment_4(), "rule__TextualTransition__IsHistoryAssignment_4");
					put(grammarAccess.getVariableAccess().getNameAssignment_1(), "rule__Variable__NameAssignment_1");
					put(grammarAccess.getVariableAccess().getInitialValueAssignment_2_0_1(), "rule__Variable__InitialValueAssignment_2_0_1");
					put(grammarAccess.getVariableAccess().getTypeAssignment_2_2(), "rule__Variable__TypeAssignment_2_2");
					put(grammarAccess.getSignalAccess().getIsInputAssignment_0_0_0(), "rule__Signal__IsInputAssignment_0_0_0");
					put(grammarAccess.getSignalAccess().getIsOutputAssignment_0_0_1(), "rule__Signal__IsOutputAssignment_0_0_1");
					put(grammarAccess.getSignalAccess().getNameAssignment_1(), "rule__Signal__NameAssignment_1");
					put(grammarAccess.getSignalAccess().getInitialValueAssignment_2_0_1(), "rule__Signal__InitialValueAssignment_2_0_1");
					put(grammarAccess.getSignalAccess().getTypeAssignment_2_1_0_1(), "rule__Signal__TypeAssignment_2_1_0_1");
					put(grammarAccess.getSignalAccess().getTypeAssignment_2_1_1_1(), "rule__Signal__TypeAssignment_2_1_1_1");
					put(grammarAccess.getSignalAccess().getCombineOperatorAssignment_2_1_1_3_0(), "rule__Signal__CombineOperatorAssignment_2_1_1_3_0");
					put(grammarAccess.getSignalAccess().getHostCombineOperatorAssignment_2_1_1_3_1(), "rule__Signal__HostCombineOperatorAssignment_2_1_1_3_1");
					put(grammarAccess.getActionAccess().getIsImmediateAssignment_0(), "rule__Action__IsImmediateAssignment_0");
					put(grammarAccess.getActionAccess().getDelayAssignment_1(), "rule__Action__DelayAssignment_1");
					put(grammarAccess.getActionAccess().getTriggerAssignment_2(), "rule__Action__TriggerAssignment_2");
					put(grammarAccess.getActionAccess().getEffectsAssignment_3_1_0(), "rule__Action__EffectsAssignment_3_1_0");
					put(grammarAccess.getEmissionAccess().getSignalAssignment_0(), "rule__Emission__SignalAssignment_0");
					put(grammarAccess.getEmissionAccess().getNewValueAssignment_1_0_1(), "rule__Emission__NewValueAssignment_1_0_1");
					put(grammarAccess.getEmissionAccess().getNewValueAssignment_1_1_1(), "rule__Emission__NewValueAssignment_1_1_1");
					put(grammarAccess.getAssignmentAccess().getVariableAssignment_0(), "rule__Assignment__VariableAssignment_0");
					put(grammarAccess.getAssignmentAccess().getExpressionAssignment_2_0(), "rule__Assignment__ExpressionAssignment_2_0");
					put(grammarAccess.getAssignmentAccess().getExpressionAssignment_2_1(), "rule__Assignment__ExpressionAssignment_2_1");
					put(grammarAccess.getSignalReferenceAccess().getSignalAssignment(), "rule__SignalReference__SignalAssignment");
					put(grammarAccess.getVariableReferenceAccess().getVariableAssignment(), "rule__VariableReference__VariableAssignment");
					put(grammarAccess.getIntValueAccess().getValueAssignment(), "rule__IntValue__ValueAssignment");
					put(grammarAccess.getFloatValueAccess().getValueAssignment(), "rule__FloatValue__ValueAssignment");
					put(grammarAccess.getBooleanValueAccess().getValueAssignment(), "rule__BooleanValue__ValueAssignment");
					put(grammarAccess.getValOperationAccess().getOperatorAssignment_0(), "rule__ValOperation__OperatorAssignment_0");
					put(grammarAccess.getValOperationAccess().getSubExpressionsAssignment_1(), "rule__ValOperation__SubExpressionsAssignment_1");
					put(grammarAccess.getPlusOperationAccess().getOperatorAssignment_1_1(), "rule__PlusOperation__OperatorAssignment_1_1");
					put(grammarAccess.getPlusOperationAccess().getSubExpressionsAssignment_1_2(), "rule__PlusOperation__SubExpressionsAssignment_1_2");
					put(grammarAccess.getMultOperationAccess().getOperatorAssignment_1_1(), "rule__MultOperation__OperatorAssignment_1_1");
					put(grammarAccess.getMultOperationAccess().getSubExpressionsAssignment_1_2(), "rule__MultOperation__SubExpressionsAssignment_1_2");
					put(grammarAccess.getDivOperationAccess().getOperatorAssignment_1_1(), "rule__DivOperation__OperatorAssignment_1_1");
					put(grammarAccess.getDivOperationAccess().getSubExpressionsAssignment_1_2(), "rule__DivOperation__SubExpressionsAssignment_1_2");
					put(grammarAccess.getPreArithmOperationAccess().getOperatorAssignment_0(), "rule__PreArithmOperation__OperatorAssignment_0");
					put(grammarAccess.getPreArithmOperationAccess().getSubExpressionsAssignment_2(), "rule__PreArithmOperation__SubExpressionsAssignment_2");
					put(grammarAccess.getCompareOperationAccess().getOperatorAssignment_1_1(), "rule__CompareOperation__OperatorAssignment_1_1");
					put(grammarAccess.getCompareOperationAccess().getSubExpressionsAssignment_1_2(), "rule__CompareOperation__SubExpressionsAssignment_1_2");
					put(grammarAccess.getUnaryOperationAccess().getOperatorAssignment_0(), "rule__UnaryOperation__OperatorAssignment_0");
					put(grammarAccess.getUnaryOperationAccess().getSubExpressionsAssignment_1(), "rule__UnaryOperation__SubExpressionsAssignment_1");
					put(grammarAccess.getUnaryParanthesedOperationAccess().getOperatorAssignment_0(), "rule__UnaryParanthesedOperation__OperatorAssignment_0");
					put(grammarAccess.getUnaryParanthesedOperationAccess().getSubExpressionsAssignment_2(), "rule__UnaryParanthesedOperation__SubExpressionsAssignment_2");
					put(grammarAccess.getAndOperationAccess().getOperatorAssignment_1_1(), "rule__AndOperation__OperatorAssignment_1_1");
					put(grammarAccess.getAndOperationAccess().getSubExpressionsAssignment_1_2(), "rule__AndOperation__SubExpressionsAssignment_1_2");
					put(grammarAccess.getOrOperationAccess().getOperatorAssignment_1_1(), "rule__OrOperation__OperatorAssignment_1_1");
					put(grammarAccess.getOrOperationAccess().getSubExpressionsAssignment_1_2(), "rule__OrOperation__SubExpressionsAssignment_1_2");
					put(grammarAccess.getHostCodeAccess().getCodeAssignment_0(), "rule__HostCode__CodeAssignment_0");
					put(grammarAccess.getHostCodeAccess().getTypeAssignment_1_1(), "rule__HostCode__TypeAssignment_1_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal.InternalKitsParser typedParser = (de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal.InternalKitsParser) parser;
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
	
	public KitsGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(KitsGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
