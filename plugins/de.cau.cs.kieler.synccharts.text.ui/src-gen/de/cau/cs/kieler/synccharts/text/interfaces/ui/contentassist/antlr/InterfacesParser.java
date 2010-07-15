/*
* generated by Xtext
*/
package de.cau.cs.kieler.synccharts.text.interfaces.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import de.cau.cs.kieler.synccharts.text.interfaces.services.InterfacesGrammarAccess;

public class InterfacesParser extends AbstractContentAssistParser {
	
	@Inject
	private InterfacesGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.cau.cs.kieler.synccharts.text.interfaces.ui.contentassist.antlr.internal.InternalInterfacesParser createParser() {
		de.cau.cs.kieler.synccharts.text.interfaces.ui.contentassist.antlr.internal.InternalInterfacesParser result = new de.cau.cs.kieler.synccharts.text.interfaces.ui.contentassist.antlr.internal.InternalInterfacesParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getStateExtendAccess().getAlternatives(), "rule__StateExtend__Alternatives");
					put(grammarAccess.getRegionSignalDecAccess().getAlternatives_2(), "rule__RegionSignalDec__Alternatives_2");
					put(grammarAccess.getRegionSignalDecAccess().getAlternatives_3(), "rule__RegionSignalDec__Alternatives_3");
					put(grammarAccess.getSignalAccess().getAlternatives(), "rule__Signal__Alternatives");
					put(grammarAccess.getVariableAccess().getAlternatives(), "rule__Variable__Alternatives");
					put(grammarAccess.getEffectAccess().getAlternatives(), "rule__Effect__Alternatives");
					put(grammarAccess.getEmissionAccess().getAlternatives_1(), "rule__Emission__Alternatives_1");
					put(grammarAccess.getAssignmentAccess().getAlternatives_2(), "rule__Assignment__Alternatives_2");
					put(grammarAccess.getValueAccess().getAlternatives(), "rule__Value__Alternatives");
					put(grammarAccess.getParanthesedValuedExpressionAccess().getAlternatives(), "rule__ParanthesedValuedExpression__Alternatives");
					put(grammarAccess.getMultOrDivOperationAccess().getAlternatives(), "rule__MultOrDivOperation__Alternatives");
					put(grammarAccess.getPreOrNormalValuedExpressionAccess().getAlternatives(), "rule__PreOrNormalValuedExpression__Alternatives");
					put(grammarAccess.getUnaryOperationAccess().getSubExpressionsAlternatives_1_0(), "rule__UnaryOperation__SubExpressionsAlternatives_1_0");
					put(grammarAccess.getUnaryOrNormalExpressionAccess().getAlternatives(), "rule__UnaryOrNormalExpression__Alternatives");
					put(grammarAccess.getParanthesedBooleanExpressionAccess().getAlternatives(), "rule__ParanthesedBooleanExpression__Alternatives");
					put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
					put(grammarAccess.getOperatorTypeAccess().getAlternatives(), "rule__OperatorType__Alternatives");
					put(grammarAccess.getCompareOperatorAccess().getAlternatives(), "rule__CompareOperator__Alternatives");
					put(grammarAccess.getPlusOperatorAccess().getAlternatives(), "rule__PlusOperator__Alternatives");
					put(grammarAccess.getMultOperatorAccess().getAlternatives(), "rule__MultOperator__Alternatives");
					put(grammarAccess.getValueTypeAccess().getAlternatives(), "rule__ValueType__Alternatives");
					put(grammarAccess.getCombineOperatorAccess().getAlternatives(), "rule__CombineOperator__Alternatives");
					put(grammarAccess.getStateExtendAccess().getGroup_1(), "rule__StateExtend__Group_1__0");
					put(grammarAccess.getStateExtendAccess().getGroup_2(), "rule__StateExtend__Group_2__0");
					put(grammarAccess.getStateExtendAccess().getGroup_3(), "rule__StateExtend__Group_3__0");
					put(grammarAccess.getStateExtendAccess().getGroup_4(), "rule__StateExtend__Group_4__0");
					put(grammarAccess.getStateExtendAccess().getGroup_5(), "rule__StateExtend__Group_5__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup(), "rule__RegionSignalDec__Group__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_2_0(), "rule__RegionSignalDec__Group_2_0__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_2_0_2(), "rule__RegionSignalDec__Group_2_0_2__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_2_1(), "rule__RegionSignalDec__Group_2_1__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_2_1_2(), "rule__RegionSignalDec__Group_2_1_2__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_3_0(), "rule__RegionSignalDec__Group_3_0__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_3_0_3(), "rule__RegionSignalDec__Group_3_0_3__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_3_1(), "rule__RegionSignalDec__Group_3_1__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_3_1_3(), "rule__RegionSignalDec__Group_3_1_3__0");
					put(grammarAccess.getVariablesAccess().getGroup(), "rule__Variables__Group__0");
					put(grammarAccess.getVariablesAccess().getGroup_0(), "rule__Variables__Group_0__0");
					put(grammarAccess.getVariablesAccess().getGroup_0_1(), "rule__Variables__Group_0_1__0");
					put(grammarAccess.getSignalsAccess().getGroup(), "rule__Signals__Group__0");
					put(grammarAccess.getSignalsAccess().getGroup_0(), "rule__Signals__Group_0__0");
					put(grammarAccess.getSignalsAccess().getGroup_0_1(), "rule__Signals__Group_0_1__0");
					put(grammarAccess.getInputSignalsAccess().getGroup(), "rule__InputSignals__Group__0");
					put(grammarAccess.getInputSignalsAccess().getGroup_0(), "rule__InputSignals__Group_0__0");
					put(grammarAccess.getInputSignalsAccess().getGroup_0_1(), "rule__InputSignals__Group_0_1__0");
					put(grammarAccess.getOutputSignalsAccess().getGroup(), "rule__OutputSignals__Group__0");
					put(grammarAccess.getOutputSignalsAccess().getGroup_0(), "rule__OutputSignals__Group_0__0");
					put(grammarAccess.getOutputSignalsAccess().getGroup_0_1(), "rule__OutputSignals__Group_0_1__0");
					put(grammarAccess.getInOutputSignalsAccess().getGroup(), "rule__InOutputSignals__Group__0");
					put(grammarAccess.getInOutputSignalsAccess().getGroup_0(), "rule__InOutputSignals__Group_0__0");
					put(grammarAccess.getInOutputSignalsAccess().getGroup_0_1(), "rule__InOutputSignals__Group_0_1__0");
					put(grammarAccess.getSignalAccess().getGroup_1(), "rule__Signal__Group_1__0");
					put(grammarAccess.getSignalAccess().getGroup_2(), "rule__Signal__Group_2__0");
					put(grammarAccess.getSignalAccess().getGroup_2_1(), "rule__Signal__Group_2_1__0");
					put(grammarAccess.getSignalAccess().getGroup_3(), "rule__Signal__Group_3__0");
					put(grammarAccess.getSignalAccess().getGroup_3_1(), "rule__Signal__Group_3_1__0");
					put(grammarAccess.getSignalAccess().getGroup_4(), "rule__Signal__Group_4__0");
					put(grammarAccess.getSignalAccess().getGroup_4_1(), "rule__Signal__Group_4_1__0");
					put(grammarAccess.getSignalAccess().getGroup_4_2(), "rule__Signal__Group_4_2__0");
					put(grammarAccess.getSignalAccess().getGroup_5(), "rule__Signal__Group_5__0");
					put(grammarAccess.getSignalAccess().getGroup_6(), "rule__Signal__Group_6__0");
					put(grammarAccess.getSignalAccess().getGroup_6_1(), "rule__Signal__Group_6_1__0");
					put(grammarAccess.getSignalAccess().getGroup_7(), "rule__Signal__Group_7__0");
					put(grammarAccess.getSignalAccess().getGroup_7_1(), "rule__Signal__Group_7_1__0");
					put(grammarAccess.getSignalAccess().getGroup_7_2(), "rule__Signal__Group_7_2__0");
					put(grammarAccess.getSignalAccess().getGroup_8(), "rule__Signal__Group_8__0");
					put(grammarAccess.getSignalAccess().getGroup_8_1(), "rule__Signal__Group_8_1__0");
					put(grammarAccess.getSignalAccess().getGroup_9(), "rule__Signal__Group_9__0");
					put(grammarAccess.getSignalAccess().getGroup_9_1(), "rule__Signal__Group_9_1__0");
					put(grammarAccess.getVariableAccess().getGroup_1(), "rule__Variable__Group_1__0");
					put(grammarAccess.getVariableAccess().getGroup_2(), "rule__Variable__Group_2__0");
					put(grammarAccess.getVariableAccess().getGroup_2_1(), "rule__Variable__Group_2_1__0");
					put(grammarAccess.getVariableAccess().getGroup_3(), "rule__Variable__Group_3__0");
					put(grammarAccess.getVariableAccess().getGroup_3_1(), "rule__Variable__Group_3_1__0");
					put(grammarAccess.getVariableAccess().getGroup_4(), "rule__Variable__Group_4__0");
					put(grammarAccess.getVariableAccess().getGroup_5(), "rule__Variable__Group_5__0");
					put(grammarAccess.getVariableAccess().getGroup_5_1(), "rule__Variable__Group_5_1__0");
					put(grammarAccess.getActionAccess().getGroup(), "rule__Action__Group__0");
					put(grammarAccess.getActionAccess().getGroup_4(), "rule__Action__Group_4__0");
					put(grammarAccess.getActionAccess().getGroup_4_1(), "rule__Action__Group_4_1__0");
					put(grammarAccess.getEmissionAccess().getGroup(), "rule__Emission__Group__0");
					put(grammarAccess.getEmissionAccess().getGroup_1_0(), "rule__Emission__Group_1_0__0");
					put(grammarAccess.getEmissionAccess().getGroup_1_1(), "rule__Emission__Group_1_1__0");
					put(grammarAccess.getAssignmentAccess().getGroup(), "rule__Assignment__Group__0");
					put(grammarAccess.getTextEffectAccess().getGroup(), "rule__TextEffect__Group__0");
					put(grammarAccess.getTextEffectAccess().getGroup_1(), "rule__TextEffect__Group_1__0");
					put(grammarAccess.getSignalReferenceAccess().getGroup(), "rule__SignalReference__Group__0");
					put(grammarAccess.getSignalReferenceAccess().getGroup_1(), "rule__SignalReference__Group_1__0");
					put(grammarAccess.getSignalReferenceAccess().getGroup_1_1(), "rule__SignalReference__Group_1_1__0");
					put(grammarAccess.getVariableReferenceAccess().getGroup(), "rule__VariableReference__Group__0");
					put(grammarAccess.getVariableReferenceAccess().getGroup_1(), "rule__VariableReference__Group_1__0");
					put(grammarAccess.getVariableReferenceAccess().getGroup_1_1(), "rule__VariableReference__Group_1_1__0");
					put(grammarAccess.getValOperationAccess().getGroup(), "rule__ValOperation__Group__0");
					put(grammarAccess.getParanthesedValuedExpressionAccess().getGroup_5(), "rule__ParanthesedValuedExpression__Group_5__0");
					put(grammarAccess.getParanthesedValuedExpressionAccess().getGroup_6(), "rule__ParanthesedValuedExpression__Group_6__0");
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
					put(grammarAccess.getTextExpressionAccess().getGroup(), "rule__TextExpression__Group__0");
					put(grammarAccess.getTextExpressionAccess().getGroup_1(), "rule__TextExpression__Group_1__0");
					put(grammarAccess.getStateExtendAccess().getRegionsAssignment_0(), "rule__StateExtend__RegionsAssignment_0");
					put(grammarAccess.getStateExtendAccess().getInOutputSignalsAssignment_1_2(), "rule__StateExtend__InOutputSignalsAssignment_1_2");
					put(grammarAccess.getStateExtendAccess().getOutputSignalsAssignment_2_1(), "rule__StateExtend__OutputSignalsAssignment_2_1");
					put(grammarAccess.getStateExtendAccess().getInputSignalsAssignment_3_1(), "rule__StateExtend__InputSignalsAssignment_3_1");
					put(grammarAccess.getStateExtendAccess().getSignalsAssignment_4_1(), "rule__StateExtend__SignalsAssignment_4_1");
					put(grammarAccess.getStateExtendAccess().getVariableAssignment_5_1(), "rule__StateExtend__VariableAssignment_5_1");
					put(grammarAccess.getRegionSignalDecAccess().getRegionAssignment_0(), "rule__RegionSignalDec__RegionAssignment_0");
					put(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_2_0_1(), "rule__RegionSignalDec__VarsAssignment_2_0_1");
					put(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_2_0_2_1(), "rule__RegionSignalDec__VarsAssignment_2_0_2_1");
					put(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_2_1_1(), "rule__RegionSignalDec__SignalsAssignment_2_1_1");
					put(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_2_1_2_1(), "rule__RegionSignalDec__SignalsAssignment_2_1_2_1");
					put(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_3_0_2(), "rule__RegionSignalDec__VarsAssignment_3_0_2");
					put(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_3_0_3_1(), "rule__RegionSignalDec__VarsAssignment_3_0_3_1");
					put(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_3_1_2(), "rule__RegionSignalDec__SignalsAssignment_3_1_2");
					put(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_3_1_3_1(), "rule__RegionSignalDec__SignalsAssignment_3_1_3_1");
					put(grammarAccess.getVariablesAccess().getVarsAssignment_0_0(), "rule__Variables__VarsAssignment_0_0");
					put(grammarAccess.getVariablesAccess().getVarsAssignment_0_1_1(), "rule__Variables__VarsAssignment_0_1_1");
					put(grammarAccess.getSignalsAccess().getSignalsAssignment_0_0(), "rule__Signals__SignalsAssignment_0_0");
					put(grammarAccess.getSignalsAccess().getSignalsAssignment_0_1_1(), "rule__Signals__SignalsAssignment_0_1_1");
					put(grammarAccess.getInputSignalsAccess().getSignalsAssignment_0_0(), "rule__InputSignals__SignalsAssignment_0_0");
					put(grammarAccess.getInputSignalsAccess().getSignalsAssignment_0_1_1(), "rule__InputSignals__SignalsAssignment_0_1_1");
					put(grammarAccess.getOutputSignalsAccess().getSignalsAssignment_0_0(), "rule__OutputSignals__SignalsAssignment_0_0");
					put(grammarAccess.getOutputSignalsAccess().getSignalsAssignment_0_1_1(), "rule__OutputSignals__SignalsAssignment_0_1_1");
					put(grammarAccess.getInOutputSignalsAccess().getSignalsAssignment_0_0(), "rule__InOutputSignals__SignalsAssignment_0_0");
					put(grammarAccess.getInOutputSignalsAccess().getSignalsAssignment_0_1_1(), "rule__InOutputSignals__SignalsAssignment_0_1_1");
					put(grammarAccess.getSignalAccess().getNameAssignment_0(), "rule__Signal__NameAssignment_0");
					put(grammarAccess.getSignalAccess().getNameAssignment_1_0(), "rule__Signal__NameAssignment_1_0");
					put(grammarAccess.getSignalAccess().getTypeAssignment_1_2(), "rule__Signal__TypeAssignment_1_2");
					put(grammarAccess.getSignalAccess().getNameAssignment_2_0(), "rule__Signal__NameAssignment_2_0");
					put(grammarAccess.getSignalAccess().getInitialValueAssignment_2_1_1(), "rule__Signal__InitialValueAssignment_2_1_1");
					put(grammarAccess.getSignalAccess().getNameAssignment_3_0(), "rule__Signal__NameAssignment_3_0");
					put(grammarAccess.getSignalAccess().getInitialValueAssignment_3_1_1(), "rule__Signal__InitialValueAssignment_3_1_1");
					put(grammarAccess.getSignalAccess().getTypeAssignment_3_3(), "rule__Signal__TypeAssignment_3_3");
					put(grammarAccess.getSignalAccess().getNameAssignment_4_0(), "rule__Signal__NameAssignment_4_0");
					put(grammarAccess.getSignalAccess().getInitialValueAssignment_4_1_1(), "rule__Signal__InitialValueAssignment_4_1_1");
					put(grammarAccess.getSignalAccess().getTypeAssignment_4_2_1(), "rule__Signal__TypeAssignment_4_2_1");
					put(grammarAccess.getSignalAccess().getCombineOperatorAssignment_4_2_3(), "rule__Signal__CombineOperatorAssignment_4_2_3");
					put(grammarAccess.getSignalAccess().getNameAssignment_5_0(), "rule__Signal__NameAssignment_5_0");
					put(grammarAccess.getSignalAccess().getHostTypeAssignment_5_2(), "rule__Signal__HostTypeAssignment_5_2");
					put(grammarAccess.getSignalAccess().getNameAssignment_6_0(), "rule__Signal__NameAssignment_6_0");
					put(grammarAccess.getSignalAccess().getInitialValueAssignment_6_1_1(), "rule__Signal__InitialValueAssignment_6_1_1");
					put(grammarAccess.getSignalAccess().getHostTypeAssignment_6_3(), "rule__Signal__HostTypeAssignment_6_3");
					put(grammarAccess.getSignalAccess().getNameAssignment_7_0(), "rule__Signal__NameAssignment_7_0");
					put(grammarAccess.getSignalAccess().getInitialValueAssignment_7_1_1(), "rule__Signal__InitialValueAssignment_7_1_1");
					put(grammarAccess.getSignalAccess().getHostTypeAssignment_7_2_1(), "rule__Signal__HostTypeAssignment_7_2_1");
					put(grammarAccess.getSignalAccess().getHostCombineOperatorAssignment_7_2_3(), "rule__Signal__HostCombineOperatorAssignment_7_2_3");
					put(grammarAccess.getSignalAccess().getNameAssignment_8_0(), "rule__Signal__NameAssignment_8_0");
					put(grammarAccess.getSignalAccess().getTypeAssignment_8_1_1(), "rule__Signal__TypeAssignment_8_1_1");
					put(grammarAccess.getSignalAccess().getCombineOperatorAssignment_8_1_3(), "rule__Signal__CombineOperatorAssignment_8_1_3");
					put(grammarAccess.getSignalAccess().getNameAssignment_9_0(), "rule__Signal__NameAssignment_9_0");
					put(grammarAccess.getSignalAccess().getHostTypeAssignment_9_1_1(), "rule__Signal__HostTypeAssignment_9_1_1");
					put(grammarAccess.getSignalAccess().getHostCombineOperatorAssignment_9_1_3(), "rule__Signal__HostCombineOperatorAssignment_9_1_3");
					put(grammarAccess.getVariableAccess().getNameAssignment_0(), "rule__Variable__NameAssignment_0");
					put(grammarAccess.getVariableAccess().getNameAssignment_1_0(), "rule__Variable__NameAssignment_1_0");
					put(grammarAccess.getVariableAccess().getTypeAssignment_1_2(), "rule__Variable__TypeAssignment_1_2");
					put(grammarAccess.getVariableAccess().getNameAssignment_2_0(), "rule__Variable__NameAssignment_2_0");
					put(grammarAccess.getVariableAccess().getInitialValueAssignment_2_1_1(), "rule__Variable__InitialValueAssignment_2_1_1");
					put(grammarAccess.getVariableAccess().getNameAssignment_3_0(), "rule__Variable__NameAssignment_3_0");
					put(grammarAccess.getVariableAccess().getInitialValueAssignment_3_1_1(), "rule__Variable__InitialValueAssignment_3_1_1");
					put(grammarAccess.getVariableAccess().getTypeAssignment_3_3(), "rule__Variable__TypeAssignment_3_3");
					put(grammarAccess.getVariableAccess().getNameAssignment_4_0(), "rule__Variable__NameAssignment_4_0");
					put(grammarAccess.getVariableAccess().getHostTypeAssignment_4_2(), "rule__Variable__HostTypeAssignment_4_2");
					put(grammarAccess.getVariableAccess().getNameAssignment_5_0(), "rule__Variable__NameAssignment_5_0");
					put(grammarAccess.getVariableAccess().getInitialValueAssignment_5_1_1(), "rule__Variable__InitialValueAssignment_5_1_1");
					put(grammarAccess.getVariableAccess().getHostTypeAssignment_5_3(), "rule__Variable__HostTypeAssignment_5_3");
					put(grammarAccess.getActionAccess().getIsImmediateAssignment_1(), "rule__Action__IsImmediateAssignment_1");
					put(grammarAccess.getActionAccess().getDelayAssignment_2(), "rule__Action__DelayAssignment_2");
					put(grammarAccess.getActionAccess().getTriggerAssignment_3(), "rule__Action__TriggerAssignment_3");
					put(grammarAccess.getActionAccess().getEffectsAssignment_4_1_0(), "rule__Action__EffectsAssignment_4_1_0");
					put(grammarAccess.getEmissionAccess().getSignalAssignment_0(), "rule__Emission__SignalAssignment_0");
					put(grammarAccess.getEmissionAccess().getNewValueAssignment_1_0_1(), "rule__Emission__NewValueAssignment_1_0_1");
					put(grammarAccess.getEmissionAccess().getNewValueAssignment_1_1_1(), "rule__Emission__NewValueAssignment_1_1_1");
					put(grammarAccess.getAssignmentAccess().getVariableAssignment_0(), "rule__Assignment__VariableAssignment_0");
					put(grammarAccess.getAssignmentAccess().getExpressionAssignment_2_0(), "rule__Assignment__ExpressionAssignment_2_0");
					put(grammarAccess.getAssignmentAccess().getExpressionAssignment_2_1(), "rule__Assignment__ExpressionAssignment_2_1");
					put(grammarAccess.getTextEffectAccess().getCodeAssignment_0(), "rule__TextEffect__CodeAssignment_0");
					put(grammarAccess.getTextEffectAccess().getTypeAssignment_1_1(), "rule__TextEffect__TypeAssignment_1_1");
					put(grammarAccess.getSignalReferenceAccess().getSignalAssignment_0(), "rule__SignalReference__SignalAssignment_0");
					put(grammarAccess.getSignalReferenceAccess().getSubExpressionsAssignment_1_1_0(), "rule__SignalReference__SubExpressionsAssignment_1_1_0");
					put(grammarAccess.getVariableReferenceAccess().getVariableAssignment_0(), "rule__VariableReference__VariableAssignment_0");
					put(grammarAccess.getVariableReferenceAccess().getSubExpressionsAssignment_1_1_0(), "rule__VariableReference__SubExpressionsAssignment_1_1_0");
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
					put(grammarAccess.getTextExpressionAccess().getCodeAssignment_0(), "rule__TextExpression__CodeAssignment_0");
					put(grammarAccess.getTextExpressionAccess().getTypeAssignment_1_1(), "rule__TextExpression__TypeAssignment_1_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.cau.cs.kieler.synccharts.text.interfaces.ui.contentassist.antlr.internal.InternalInterfacesParser typedParser = (de.cau.cs.kieler.synccharts.text.interfaces.ui.contentassist.antlr.internal.InternalInterfacesParser) parser;
			typedParser.entryRuleStateExtend();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public InterfacesGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(InterfacesGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
