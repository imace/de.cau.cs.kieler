/*
* generated by Xtext
*/
package de.cau.cs.kieler.synccharts.interfacedeclparser.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import de.cau.cs.kieler.synccharts.interfacedeclparser.services.InterfaceDeclGrammarAccess;

public class InterfaceDeclParser extends AbstractContentAssistParser {
	
	@Inject
	private InterfaceDeclGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.cau.cs.kieler.synccharts.interfacedeclparser.contentassist.antlr.internal.InternalInterfaceDeclParser createParser() {
		de.cau.cs.kieler.synccharts.interfacedeclparser.contentassist.antlr.internal.InternalInterfaceDeclParser result = new de.cau.cs.kieler.synccharts.interfacedeclparser.contentassist.antlr.internal.InternalInterfaceDeclParser(null);
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
					put(grammarAccess.getValueTypeAccess().getAlternatives(), "rule__ValueType__Alternatives");
					put(grammarAccess.getCombineOperatorAccess().getAlternatives(), "rule__CombineOperator__Alternatives");
					put(grammarAccess.getStateExtendAccess().getGroup_0(), "rule__StateExtend__Group_0__0");
					put(grammarAccess.getStateExtendAccess().getGroup_1(), "rule__StateExtend__Group_1__0");
					put(grammarAccess.getStateExtendAccess().getGroup_2(), "rule__StateExtend__Group_2__0");
					put(grammarAccess.getStateExtendAccess().getGroup_3(), "rule__StateExtend__Group_3__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup(), "rule__RegionSignalDec__Group__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_2_0(), "rule__RegionSignalDec__Group_2_0__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_2_0_2(), "rule__RegionSignalDec__Group_2_0_2__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_2_1(), "rule__RegionSignalDec__Group_2_1__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_2_1_2(), "rule__RegionSignalDec__Group_2_1_2__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_3_0(), "rule__RegionSignalDec__Group_3_0__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_3_0_3(), "rule__RegionSignalDec__Group_3_0_3__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_3_1(), "rule__RegionSignalDec__Group_3_1__0");
					put(grammarAccess.getRegionSignalDecAccess().getGroup_3_1_3(), "rule__RegionSignalDec__Group_3_1_3__0");
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
					put(grammarAccess.getSignalAccess().getGroup_1_1(), "rule__Signal__Group_1_1__0");
					put(grammarAccess.getSignalAccess().getGroup_2(), "rule__Signal__Group_2__0");
					put(grammarAccess.getSignalAccess().getGroup_2_1(), "rule__Signal__Group_2_1__0");
					put(grammarAccess.getSignalAccess().getGroup_3(), "rule__Signal__Group_3__0");
					put(grammarAccess.getSignalAccess().getGroup_3_1(), "rule__Signal__Group_3_1__0");
					put(grammarAccess.getSignalAccess().getGroup_3_2(), "rule__Signal__Group_3_2__0");
					put(grammarAccess.getSignalAccess().getGroup_4(), "rule__Signal__Group_4__0");
					put(grammarAccess.getSignalAccess().getGroup_4_1(), "rule__Signal__Group_4_1__0");
					put(grammarAccess.getSignalAccess().getGroup_5(), "rule__Signal__Group_5__0");
					put(grammarAccess.getSignalAccess().getGroup_5_1(), "rule__Signal__Group_5_1__0");
					put(grammarAccess.getSignalAccess().getGroup_5_2(), "rule__Signal__Group_5_2__0");
					put(grammarAccess.getSignalAccess().getGroup_6(), "rule__Signal__Group_6__0");
					put(grammarAccess.getSignalAccess().getGroup_6_1(), "rule__Signal__Group_6_1__0");
					put(grammarAccess.getSignalAccess().getGroup_7(), "rule__Signal__Group_7__0");
					put(grammarAccess.getSignalAccess().getGroup_7_1(), "rule__Signal__Group_7_1__0");
					put(grammarAccess.getVariableAccess().getGroup(), "rule__Variable__Group__0");
					put(grammarAccess.getVariableAccess().getGroup_1(), "rule__Variable__Group_1__0");
					put(grammarAccess.getVariableAccess().getGroup_3(), "rule__Variable__Group_3__0");
					put(grammarAccess.getStateExtendAccess().getInputSignalsAssignment_0_1(), "rule__StateExtend__InputSignalsAssignment_0_1");
					put(grammarAccess.getStateExtendAccess().getOutputSignalsAssignment_1_1(), "rule__StateExtend__OutputSignalsAssignment_1_1");
					put(grammarAccess.getStateExtendAccess().getInOutputSignalsAssignment_2_2(), "rule__StateExtend__InOutputSignalsAssignment_2_2");
					put(grammarAccess.getStateExtendAccess().getSignalsAssignment_3_1(), "rule__StateExtend__SignalsAssignment_3_1");
					put(grammarAccess.getStateExtendAccess().getRegionsAssignment_4(), "rule__StateExtend__RegionsAssignment_4");
					put(grammarAccess.getRegionSignalDecAccess().getRegionAssignment_0(), "rule__RegionSignalDec__RegionAssignment_0");
					put(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_2_0_1(), "rule__RegionSignalDec__VarsAssignment_2_0_1");
					put(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_2_0_2_1(), "rule__RegionSignalDec__VarsAssignment_2_0_2_1");
					put(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_2_1_1(), "rule__RegionSignalDec__SignalsAssignment_2_1_1");
					put(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_2_1_2_1(), "rule__RegionSignalDec__SignalsAssignment_2_1_2_1");
					put(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_3_0_2(), "rule__RegionSignalDec__VarsAssignment_3_0_2");
					put(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_3_0_3_1(), "rule__RegionSignalDec__VarsAssignment_3_0_3_1");
					put(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_3_1_2(), "rule__RegionSignalDec__SignalsAssignment_3_1_2");
					put(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_3_1_3_1(), "rule__RegionSignalDec__SignalsAssignment_3_1_3_1");
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
					put(grammarAccess.getSignalAccess().getInitialValueAssignment_1_1_1(), "rule__Signal__InitialValueAssignment_1_1_1");
					put(grammarAccess.getSignalAccess().getNameAssignment_2_0(), "rule__Signal__NameAssignment_2_0");
					put(grammarAccess.getSignalAccess().getInitialValueAssignment_2_1_1(), "rule__Signal__InitialValueAssignment_2_1_1");
					put(grammarAccess.getSignalAccess().getTypeAssignment_2_2(), "rule__Signal__TypeAssignment_2_2");
					put(grammarAccess.getSignalAccess().getNameAssignment_3_0(), "rule__Signal__NameAssignment_3_0");
					put(grammarAccess.getSignalAccess().getInitialValueAssignment_3_1_1(), "rule__Signal__InitialValueAssignment_3_1_1");
					put(grammarAccess.getSignalAccess().getTypeAssignment_3_2_1(), "rule__Signal__TypeAssignment_3_2_1");
					put(grammarAccess.getSignalAccess().getCombineOperatorAssignment_3_2_3(), "rule__Signal__CombineOperatorAssignment_3_2_3");
					put(grammarAccess.getSignalAccess().getNameAssignment_4_0(), "rule__Signal__NameAssignment_4_0");
					put(grammarAccess.getSignalAccess().getInitialValueAssignment_4_1_1(), "rule__Signal__InitialValueAssignment_4_1_1");
					put(grammarAccess.getSignalAccess().getHostTypeAssignment_4_2(), "rule__Signal__HostTypeAssignment_4_2");
					put(grammarAccess.getSignalAccess().getNameAssignment_5_0(), "rule__Signal__NameAssignment_5_0");
					put(grammarAccess.getSignalAccess().getInitialValueAssignment_5_1_1(), "rule__Signal__InitialValueAssignment_5_1_1");
					put(grammarAccess.getSignalAccess().getHostTypeAssignment_5_2_1(), "rule__Signal__HostTypeAssignment_5_2_1");
					put(grammarAccess.getSignalAccess().getHostCombineOperatorAssignment_5_2_3(), "rule__Signal__HostCombineOperatorAssignment_5_2_3");
					put(grammarAccess.getSignalAccess().getNameAssignment_6_0(), "rule__Signal__NameAssignment_6_0");
					put(grammarAccess.getSignalAccess().getTypeAssignment_6_1_1(), "rule__Signal__TypeAssignment_6_1_1");
					put(grammarAccess.getSignalAccess().getCombineOperatorAssignment_6_1_3(), "rule__Signal__CombineOperatorAssignment_6_1_3");
					put(grammarAccess.getSignalAccess().getNameAssignment_7_0(), "rule__Signal__NameAssignment_7_0");
					put(grammarAccess.getSignalAccess().getHostTypeAssignment_7_1_1(), "rule__Signal__HostTypeAssignment_7_1_1");
					put(grammarAccess.getSignalAccess().getHostCombineOperatorAssignment_7_1_3(), "rule__Signal__HostCombineOperatorAssignment_7_1_3");
					put(grammarAccess.getVariableAccess().getNameAssignment_0(), "rule__Variable__NameAssignment_0");
					put(grammarAccess.getVariableAccess().getInitialValueAssignment_1_1(), "rule__Variable__InitialValueAssignment_1_1");
					put(grammarAccess.getVariableAccess().getTypeAssignment_2(), "rule__Variable__TypeAssignment_2");
					put(grammarAccess.getVariableAccess().getHostTypeAssignment_3_1(), "rule__Variable__HostTypeAssignment_3_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.cau.cs.kieler.synccharts.interfacedeclparser.contentassist.antlr.internal.InternalInterfaceDeclParser typedParser = (de.cau.cs.kieler.synccharts.interfacedeclparser.contentassist.antlr.internal.InternalInterfaceDeclParser) parser;
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
	
	public InterfaceDeclGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(InterfaceDeclGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
