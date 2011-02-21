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
					put(grammarAccess.getRootAccess().getAlternatives(), "rule__Root__Alternatives");
					put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
					put(grammarAccess.getCompareOperationAccess().getAlternatives(), "rule__CompareOperation__Alternatives");
					put(grammarAccess.getNotOrValuedExpressionAccess().getAlternatives(), "rule__NotOrValuedExpression__Alternatives");
					put(grammarAccess.getNotExpressionAccess().getAlternatives(), "rule__NotExpression__Alternatives");
					put(grammarAccess.getNegExpressionAccess().getAlternatives(), "rule__NegExpression__Alternatives");
					put(grammarAccess.getAtomicExpressionAccess().getAlternatives(), "rule__AtomicExpression__Alternatives");
					put(grammarAccess.getAtomicValuedExpressionAccess().getAlternatives(), "rule__AtomicValuedExpression__Alternatives");
					put(grammarAccess.getValuedObjectTestExpressionAccess().getAlternatives(), "rule__ValuedObjectTestExpression__Alternatives");
					put(grammarAccess.getAnyTypeAccess().getAlternatives(), "rule__AnyType__Alternatives");
					put(grammarAccess.getInterfaceDeclarationAccess().getAlternatives(), "rule__InterfaceDeclaration__Alternatives");
					put(grammarAccess.getInterfaceSignalDeclAccess().getAlternatives(), "rule__InterfaceSignalDecl__Alternatives");
					put(grammarAccess.getChannelDescriptionAccess().getAlternatives(), "rule__ChannelDescription__Alternatives");
					put(grammarAccess.getTypeIdentifierAccess().getAlternatives(), "rule__TypeIdentifier__Alternatives");
					put(grammarAccess.getTypeIdentifierAccess().getAlternatives_2_1(), "rule__TypeIdentifier__Alternatives_2_1");
					put(grammarAccess.getAnnotationAccess().getAlternatives(), "rule__Annotation__Alternatives");
					put(grammarAccess.getEStringAccess().getAlternatives(), "rule__EString__Alternatives");
					put(grammarAccess.getCompareOperatorAccess().getAlternatives(), "rule__CompareOperator__Alternatives");
					put(grammarAccess.getValueTypeAccess().getAlternatives(), "rule__ValueType__Alternatives");
					put(grammarAccess.getCombineOperatorAccess().getAlternatives(), "rule__CombineOperator__Alternatives");
					put(grammarAccess.getTransitionAccess().getGroup(), "rule__Transition__Group__0");
					put(grammarAccess.getTransitionAccess().getGroup_4(), "rule__Transition__Group_4__0");
					put(grammarAccess.getTransitionAccess().getGroup_4_2(), "rule__Transition__Group_4_2__0");
					put(grammarAccess.getActionAccess().getGroup(), "rule__Action__Group__0");
					put(grammarAccess.getActionAccess().getGroup_4(), "rule__Action__Group_4__0");
					put(grammarAccess.getActionAccess().getGroup_4_2(), "rule__Action__Group_4_2__0");
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
					put(grammarAccess.getNotExpressionAccess().getGroup_0(), "rule__NotExpression__Group_0__0");
					put(grammarAccess.getAddExpressionAccess().getGroup(), "rule__AddExpression__Group__0");
					put(grammarAccess.getAddExpressionAccess().getGroup_1(), "rule__AddExpression__Group_1__0");
					put(grammarAccess.getSubExpressionAccess().getGroup(), "rule__SubExpression__Group__0");
					put(grammarAccess.getSubExpressionAccess().getGroup_1(), "rule__SubExpression__Group_1__0");
					put(grammarAccess.getMultExpressionAccess().getGroup(), "rule__MultExpression__Group__0");
					put(grammarAccess.getMultExpressionAccess().getGroup_1(), "rule__MultExpression__Group_1__0");
					put(grammarAccess.getDivExpressionAccess().getGroup(), "rule__DivExpression__Group__0");
					put(grammarAccess.getDivExpressionAccess().getGroup_1(), "rule__DivExpression__Group_1__0");
					put(grammarAccess.getModExpressionAccess().getGroup(), "rule__ModExpression__Group__0");
					put(grammarAccess.getModExpressionAccess().getGroup_1(), "rule__ModExpression__Group_1__0");
					put(grammarAccess.getNegExpressionAccess().getGroup_0(), "rule__NegExpression__Group_0__0");
					put(grammarAccess.getAtomicExpressionAccess().getGroup_2(), "rule__AtomicExpression__Group_2__0");
					put(grammarAccess.getAtomicValuedExpressionAccess().getGroup_2(), "rule__AtomicValuedExpression__Group_2__0");
					put(grammarAccess.getValuedObjectTestExpressionAccess().getGroup_0(), "rule__ValuedObjectTestExpression__Group_0__0");
					put(grammarAccess.getValuedObjectTestExpressionAccess().getGroup_1(), "rule__ValuedObjectTestExpression__Group_1__0");
					put(grammarAccess.getTextExpressionAccess().getGroup(), "rule__TextExpression__Group__0");
					put(grammarAccess.getTextExpressionAccess().getGroup_1(), "rule__TextExpression__Group_1__0");
					put(grammarAccess.getISignalAccess().getGroup(), "rule__ISignal__Group__0");
					put(grammarAccess.getInterfaceSignalDeclAccess().getGroup_0(), "rule__InterfaceSignalDecl__Group_0__0");
					put(grammarAccess.getInterfaceSignalDeclAccess().getGroup_0_3(), "rule__InterfaceSignalDecl__Group_0_3__0");
					put(grammarAccess.getInterfaceSignalDeclAccess().getGroup_1(), "rule__InterfaceSignalDecl__Group_1__0");
					put(grammarAccess.getInterfaceSignalDeclAccess().getGroup_1_3(), "rule__InterfaceSignalDecl__Group_1_3__0");
					put(grammarAccess.getInterfaceSignalDeclAccess().getGroup_2(), "rule__InterfaceSignalDecl__Group_2__0");
					put(grammarAccess.getInterfaceSignalDeclAccess().getGroup_2_3(), "rule__InterfaceSignalDecl__Group_2_3__0");
					put(grammarAccess.getInterfaceSignalDeclAccess().getGroup_3(), "rule__InterfaceSignalDecl__Group_3__0");
					put(grammarAccess.getInterfaceSignalDeclAccess().getGroup_3_3(), "rule__InterfaceSignalDecl__Group_3_3__0");
					put(grammarAccess.getChannelDescriptionAccess().getGroup_0(), "rule__ChannelDescription__Group_0__0");
					put(grammarAccess.getChannelDescriptionAccess().getGroup_1(), "rule__ChannelDescription__Group_1__0");
					put(grammarAccess.getChannelDescriptionAccess().getGroup_2(), "rule__ChannelDescription__Group_2__0");
					put(grammarAccess.getInterfaceVariableDeclAccess().getGroup(), "rule__InterfaceVariableDecl__Group__0");
					put(grammarAccess.getInterfaceVariableDeclAccess().getGroup_2(), "rule__InterfaceVariableDecl__Group_2__0");
					put(grammarAccess.getVariableDeclAccess().getGroup(), "rule__VariableDecl__Group__0");
					put(grammarAccess.getVariableDeclAccess().getGroup_1(), "rule__VariableDecl__Group_1__0");
					put(grammarAccess.getIVariableAccess().getGroup(), "rule__IVariable__Group__0");
					put(grammarAccess.getIVariableAccess().getGroup_1(), "rule__IVariable__Group_1__0");
					put(grammarAccess.getTypeIdentifierAccess().getGroup_2(), "rule__TypeIdentifier__Group_2__0");
					put(grammarAccess.getTagAnnotationAccess().getGroup(), "rule__TagAnnotation__Group__0");
					put(grammarAccess.getKeyStringValueAnnotationAccess().getGroup(), "rule__KeyStringValueAnnotation__Group__0");
					put(grammarAccess.getKeyBooleanValueAnnotationAccess().getGroup(), "rule__KeyBooleanValueAnnotation__Group__0");
					put(grammarAccess.getKeyIntValueAnnotationAccess().getGroup(), "rule__KeyIntValueAnnotation__Group__0");
					put(grammarAccess.getKeyFloatValueAnnotationAccess().getGroup(), "rule__KeyFloatValueAnnotation__Group__0");
					put(grammarAccess.getImportAnnotationAccess().getGroup(), "rule__ImportAnnotation__Group__0");
					put(grammarAccess.getTransitionAccess().getIsImmediateAssignment_1(), "rule__Transition__IsImmediateAssignment_1");
					put(grammarAccess.getTransitionAccess().getDelayAssignment_2(), "rule__Transition__DelayAssignment_2");
					put(grammarAccess.getTransitionAccess().getTriggerAssignment_3(), "rule__Transition__TriggerAssignment_3");
					put(grammarAccess.getTransitionAccess().getEffectsAssignment_4_1(), "rule__Transition__EffectsAssignment_4_1");
					put(grammarAccess.getTransitionAccess().getEffectsAssignment_4_2_1(), "rule__Transition__EffectsAssignment_4_2_1");
					put(grammarAccess.getActionAccess().getIsImmediateAssignment_1(), "rule__Action__IsImmediateAssignment_1");
					put(grammarAccess.getActionAccess().getDelayAssignment_2(), "rule__Action__DelayAssignment_2");
					put(grammarAccess.getActionAccess().getTriggerAssignment_3(), "rule__Action__TriggerAssignment_3");
					put(grammarAccess.getActionAccess().getEffectsAssignment_4_1(), "rule__Action__EffectsAssignment_4_1");
					put(grammarAccess.getActionAccess().getEffectsAssignment_4_2_1(), "rule__Action__EffectsAssignment_4_2_1");
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
					put(grammarAccess.getNotExpressionAccess().getOperatorAssignment_0_1(), "rule__NotExpression__OperatorAssignment_0_1");
					put(grammarAccess.getNotExpressionAccess().getSubExpressionsAssignment_0_2(), "rule__NotExpression__SubExpressionsAssignment_0_2");
					put(grammarAccess.getAddExpressionAccess().getOperatorAssignment_1_1(), "rule__AddExpression__OperatorAssignment_1_1");
					put(grammarAccess.getAddExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__AddExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getSubExpressionAccess().getOperatorAssignment_1_1(), "rule__SubExpression__OperatorAssignment_1_1");
					put(grammarAccess.getSubExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__SubExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getMultExpressionAccess().getOperatorAssignment_1_1(), "rule__MultExpression__OperatorAssignment_1_1");
					put(grammarAccess.getMultExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__MultExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getDivExpressionAccess().getOperatorAssignment_1_1(), "rule__DivExpression__OperatorAssignment_1_1");
					put(grammarAccess.getDivExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__DivExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getModExpressionAccess().getOperatorAssignment_1_1(), "rule__ModExpression__OperatorAssignment_1_1");
					put(grammarAccess.getModExpressionAccess().getSubExpressionsAssignment_1_2(), "rule__ModExpression__SubExpressionsAssignment_1_2");
					put(grammarAccess.getNegExpressionAccess().getOperatorAssignment_0_1(), "rule__NegExpression__OperatorAssignment_0_1");
					put(grammarAccess.getNegExpressionAccess().getSubExpressionsAssignment_0_2(), "rule__NegExpression__SubExpressionsAssignment_0_2");
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
					put(grammarAccess.getISignalAccess().getNameAssignment_0(), "rule__ISignal__NameAssignment_0");
					put(grammarAccess.getISignalAccess().getChannelDescrAssignment_1(), "rule__ISignal__ChannelDescrAssignment_1");
					put(grammarAccess.getInterfaceSignalDeclAccess().getSignalsAssignment_0_2(), "rule__InterfaceSignalDecl__SignalsAssignment_0_2");
					put(grammarAccess.getInterfaceSignalDeclAccess().getSignalsAssignment_0_3_1(), "rule__InterfaceSignalDecl__SignalsAssignment_0_3_1");
					put(grammarAccess.getInterfaceSignalDeclAccess().getSignalsAssignment_1_2(), "rule__InterfaceSignalDecl__SignalsAssignment_1_2");
					put(grammarAccess.getInterfaceSignalDeclAccess().getSignalsAssignment_1_3_1(), "rule__InterfaceSignalDecl__SignalsAssignment_1_3_1");
					put(grammarAccess.getInterfaceSignalDeclAccess().getSignalsAssignment_2_2(), "rule__InterfaceSignalDecl__SignalsAssignment_2_2");
					put(grammarAccess.getInterfaceSignalDeclAccess().getSignalsAssignment_2_3_1(), "rule__InterfaceSignalDecl__SignalsAssignment_2_3_1");
					put(grammarAccess.getInterfaceSignalDeclAccess().getSignalsAssignment_3_2(), "rule__InterfaceSignalDecl__SignalsAssignment_3_2");
					put(grammarAccess.getInterfaceSignalDeclAccess().getSignalsAssignment_3_3_1(), "rule__InterfaceSignalDecl__SignalsAssignment_3_3_1");
					put(grammarAccess.getChannelDescriptionAccess().getTypeAssignment_0_1(), "rule__ChannelDescription__TypeAssignment_0_1");
					put(grammarAccess.getChannelDescriptionAccess().getTypeAssignment_1_1(), "rule__ChannelDescription__TypeAssignment_1_1");
					put(grammarAccess.getChannelDescriptionAccess().getExpressionAssignment_2_1(), "rule__ChannelDescription__ExpressionAssignment_2_1");
					put(grammarAccess.getChannelDescriptionAccess().getTypeAssignment_2_3(), "rule__ChannelDescription__TypeAssignment_2_3");
					put(grammarAccess.getInterfaceVariableDeclAccess().getVarDeclsAssignment_1(), "rule__InterfaceVariableDecl__VarDeclsAssignment_1");
					put(grammarAccess.getInterfaceVariableDeclAccess().getVarDeclsAssignment_2_1(), "rule__InterfaceVariableDecl__VarDeclsAssignment_2_1");
					put(grammarAccess.getVariableDeclAccess().getVariablesAssignment_0(), "rule__VariableDecl__VariablesAssignment_0");
					put(grammarAccess.getVariableDeclAccess().getVariablesAssignment_1_1(), "rule__VariableDecl__VariablesAssignment_1_1");
					put(grammarAccess.getVariableDeclAccess().getTypeAssignment_3(), "rule__VariableDecl__TypeAssignment_3");
					put(grammarAccess.getIVariableAccess().getNameAssignment_0(), "rule__IVariable__NameAssignment_0");
					put(grammarAccess.getIVariableAccess().getExpressionAssignment_1_1(), "rule__IVariable__ExpressionAssignment_1_1");
					put(grammarAccess.getTypeIdentifierAccess().getTypeAssignment_0(), "rule__TypeIdentifier__TypeAssignment_0");
					put(grammarAccess.getTypeIdentifierAccess().getTypeIDAssignment_1(), "rule__TypeIdentifier__TypeIDAssignment_1");
					put(grammarAccess.getTypeIdentifierAccess().getTypeAssignment_2_1_0(), "rule__TypeIdentifier__TypeAssignment_2_1_0");
					put(grammarAccess.getTypeIdentifierAccess().getTypeIDAssignment_2_1_1(), "rule__TypeIdentifier__TypeIDAssignment_2_1_1");
					put(grammarAccess.getTypeIdentifierAccess().getOperatorAssignment_2_3(), "rule__TypeIdentifier__OperatorAssignment_2_3");
					put(grammarAccess.getCommentAnnotationAccess().getValueAssignment(), "rule__CommentAnnotation__ValueAssignment");
					put(grammarAccess.getTagAnnotationAccess().getNameAssignment_1(), "rule__TagAnnotation__NameAssignment_1");
					put(grammarAccess.getKeyStringValueAnnotationAccess().getNameAssignment_1(), "rule__KeyStringValueAnnotation__NameAssignment_1");
					put(grammarAccess.getKeyStringValueAnnotationAccess().getValueAssignment_2(), "rule__KeyStringValueAnnotation__ValueAssignment_2");
					put(grammarAccess.getKeyBooleanValueAnnotationAccess().getNameAssignment_1(), "rule__KeyBooleanValueAnnotation__NameAssignment_1");
					put(grammarAccess.getKeyBooleanValueAnnotationAccess().getValueAssignment_2(), "rule__KeyBooleanValueAnnotation__ValueAssignment_2");
					put(grammarAccess.getKeyIntValueAnnotationAccess().getNameAssignment_1(), "rule__KeyIntValueAnnotation__NameAssignment_1");
					put(grammarAccess.getKeyIntValueAnnotationAccess().getValueAssignment_2(), "rule__KeyIntValueAnnotation__ValueAssignment_2");
					put(grammarAccess.getKeyFloatValueAnnotationAccess().getNameAssignment_1(), "rule__KeyFloatValueAnnotation__NameAssignment_1");
					put(grammarAccess.getKeyFloatValueAnnotationAccess().getValueAssignment_2(), "rule__KeyFloatValueAnnotation__ValueAssignment_2");
					put(grammarAccess.getImportAnnotationAccess().getImportURIAssignment_1(), "rule__ImportAnnotation__ImportURIAssignment_1");
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
