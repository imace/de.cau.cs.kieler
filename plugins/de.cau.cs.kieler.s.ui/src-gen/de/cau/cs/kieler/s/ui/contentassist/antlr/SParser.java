/*
* generated by Xtext
*/
package de.cau.cs.kieler.s.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import de.cau.cs.kieler.s.services.SGrammarAccess;

public class SParser extends AbstractContentAssistParser {
	
	@Inject
	private SGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.cau.cs.kieler.s.ui.contentassist.antlr.internal.InternalSParser createParser() {
		de.cau.cs.kieler.s.ui.contentassist.antlr.internal.InternalSParser result = new de.cau.cs.kieler.s.ui.contentassist.antlr.internal.InternalSParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getSignalAccess().getAlternatives_5(), "rule__Signal__Alternatives_5");
					put(grammarAccess.getSignalAccess().getAlternatives_5_1_4(), "rule__Signal__Alternatives_5_1_4");
					put(grammarAccess.getInstructionAccess().getAlternatives(), "rule__Instruction__Alternatives");
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
					put(grammarAccess.getProgramAccess().getGroup(), "rule__Program__Group__0");
					put(grammarAccess.getStateAccess().getGroup(), "rule__State__Group__0");
					put(grammarAccess.getStateAccess().getGroup_2(), "rule__State__Group_2__0");
					put(grammarAccess.getStateAccess().getGroup_3(), "rule__State__Group_3__0");
					put(grammarAccess.getSignalAccess().getGroup(), "rule__Signal__Group__0");
					put(grammarAccess.getSignalAccess().getGroup_4(), "rule__Signal__Group_4__0");
					put(grammarAccess.getSignalAccess().getGroup_5_0(), "rule__Signal__Group_5_0__0");
					put(grammarAccess.getSignalAccess().getGroup_5_1(), "rule__Signal__Group_5_1__0");
					put(grammarAccess.getPauseAccess().getGroup(), "rule__Pause__Group__0");
					put(grammarAccess.getTermAccess().getGroup(), "rule__Term__Group__0");
					put(grammarAccess.getHaltAccess().getGroup(), "rule__Halt__Group__0");
					put(grammarAccess.getJoinAccess().getGroup(), "rule__Join__Group__0");
					put(grammarAccess.getAbortAccess().getGroup(), "rule__Abort__Group__0");
					put(grammarAccess.getIfAccess().getGroup(), "rule__If__Group__0");
					put(grammarAccess.getIfAccess().getGroup_3(), "rule__If__Group_3__0");
					put(grammarAccess.getIfAccess().getGroup_6(), "rule__If__Group_6__0");
					put(grammarAccess.getGotoAccess().getGroup(), "rule__Goto__Group__0");
					put(grammarAccess.getGotoAccess().getGroup_3(), "rule__Goto__Group_3__0");
					put(grammarAccess.getForkAccess().getGroup(), "rule__Fork__Group__0");
					put(grammarAccess.getForkAccess().getGroup_5(), "rule__Fork__Group_5__0");
					put(grammarAccess.getForkeAccess().getGroup(), "rule__Forke__Group__0");
					put(grammarAccess.getForkeAccess().getGroup_3(), "rule__Forke__Group_3__0");
					put(grammarAccess.getEmitAccess().getGroup(), "rule__Emit__Group__0");
					put(grammarAccess.getEmitAccess().getGroup_3(), "rule__Emit__Group_3__0");
					put(grammarAccess.getAwaitAccess().getGroup(), "rule__Await__Group__0");
					put(grammarAccess.getAwaitAccess().getGroup_3(), "rule__Await__Group_3__0");
					put(grammarAccess.getPrioAccess().getGroup(), "rule__Prio__Group__0");
					put(grammarAccess.getPrioAccess().getGroup_3(), "rule__Prio__Group_3__0");
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
					put(grammarAccess.getProgramAccess().getNameAssignment_1(), "rule__Program__NameAssignment_1");
					put(grammarAccess.getProgramAccess().getPriorityAssignment_3(), "rule__Program__PriorityAssignment_3");
					put(grammarAccess.getProgramAccess().getSignalsAssignment_5(), "rule__Program__SignalsAssignment_5");
					put(grammarAccess.getProgramAccess().getStatesAssignment_6(), "rule__Program__StatesAssignment_6");
					put(grammarAccess.getStateAccess().getNameAssignment_0(), "rule__State__NameAssignment_0");
					put(grammarAccess.getStateAccess().getSignalsAssignment_2_1(), "rule__State__SignalsAssignment_2_1");
					put(grammarAccess.getStateAccess().getInstructionsAssignment_3_0(), "rule__State__InstructionsAssignment_3_0");
					put(grammarAccess.getSignalAccess().getIsInputAssignment_0(), "rule__Signal__IsInputAssignment_0");
					put(grammarAccess.getSignalAccess().getIsOutputAssignment_1(), "rule__Signal__IsOutputAssignment_1");
					put(grammarAccess.getSignalAccess().getNameAssignment_3(), "rule__Signal__NameAssignment_3");
					put(grammarAccess.getSignalAccess().getInitialValueAssignment_4_1(), "rule__Signal__InitialValueAssignment_4_1");
					put(grammarAccess.getSignalAccess().getTypeAssignment_5_0_1(), "rule__Signal__TypeAssignment_5_0_1");
					put(grammarAccess.getSignalAccess().getTypeAssignment_5_1_2(), "rule__Signal__TypeAssignment_5_1_2");
					put(grammarAccess.getSignalAccess().getCombineOperatorAssignment_5_1_4_0(), "rule__Signal__CombineOperatorAssignment_5_1_4_0");
					put(grammarAccess.getSignalAccess().getHostCombineOperatorAssignment_5_1_4_1(), "rule__Signal__HostCombineOperatorAssignment_5_1_4_1");
					put(grammarAccess.getPauseAccess().getContinuationAssignment_3(), "rule__Pause__ContinuationAssignment_3");
					put(grammarAccess.getTermAccess().getContinuationAssignment_3(), "rule__Term__ContinuationAssignment_3");
					put(grammarAccess.getHaltAccess().getContinuationAssignment_3(), "rule__Halt__ContinuationAssignment_3");
					put(grammarAccess.getJoinAccess().getContinuationAssignment_3(), "rule__Join__ContinuationAssignment_3");
					put(grammarAccess.getAbortAccess().getContinuationAssignment_3(), "rule__Abort__ContinuationAssignment_3");
					put(grammarAccess.getIfAccess().getExpressionAssignment_2(), "rule__If__ExpressionAssignment_2");
					put(grammarAccess.getIfAccess().getContinuationAssignment_3_1(), "rule__If__ContinuationAssignment_3_1");
					put(grammarAccess.getIfAccess().getInstructionsAssignment_6_0(), "rule__If__InstructionsAssignment_6_0");
					put(grammarAccess.getGotoAccess().getStateAssignment_2(), "rule__Goto__StateAssignment_2");
					put(grammarAccess.getGotoAccess().getContinuationAssignment_3_1(), "rule__Goto__ContinuationAssignment_3_1");
					put(grammarAccess.getForkAccess().getStateAssignment_2(), "rule__Fork__StateAssignment_2");
					put(grammarAccess.getForkAccess().getPriorityAssignment_4(), "rule__Fork__PriorityAssignment_4");
					put(grammarAccess.getForkAccess().getContinuationAssignment_5_1(), "rule__Fork__ContinuationAssignment_5_1");
					put(grammarAccess.getForkeAccess().getStateAssignment_2(), "rule__Forke__StateAssignment_2");
					put(grammarAccess.getForkeAccess().getContinuationAssignment_3_1(), "rule__Forke__ContinuationAssignment_3_1");
					put(grammarAccess.getEmitAccess().getSignalAssignment_2(), "rule__Emit__SignalAssignment_2");
					put(grammarAccess.getEmitAccess().getContinuationAssignment_3_1(), "rule__Emit__ContinuationAssignment_3_1");
					put(grammarAccess.getAwaitAccess().getSignalAssignment_2(), "rule__Await__SignalAssignment_2");
					put(grammarAccess.getAwaitAccess().getContinuationAssignment_3_1(), "rule__Await__ContinuationAssignment_3_1");
					put(grammarAccess.getPrioAccess().getPriorityAssignment_2(), "rule__Prio__PriorityAssignment_2");
					put(grammarAccess.getPrioAccess().getContinuationAssignment_3_1(), "rule__Prio__ContinuationAssignment_3_1");
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
			de.cau.cs.kieler.s.ui.contentassist.antlr.internal.InternalSParser typedParser = (de.cau.cs.kieler.s.ui.contentassist.antlr.internal.InternalSParser) parser;
			typedParser.entryRuleProgram();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public SGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(SGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
