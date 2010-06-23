/*
* generated by Xtext
*/

package de.cau.cs.kieler.synccharts.text.actions.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import de.cau.cs.kieler.core.expressions.services.ExpressionsGrammarAccess;

@Singleton
public class ActionsGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class ActionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Action");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cActionAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cIsImmediateAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIsImmediateNumberSignKeyword_1_0 = (Keyword)cIsImmediateAssignment_1.eContents().get(0);
		private final Assignment cDelayAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cDelayINTTerminalRuleCall_2_0 = (RuleCall)cDelayAssignment_2.eContents().get(0);
		private final Assignment cTriggerAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cTriggerBooleanExpressionParserRuleCall_3_0 = (RuleCall)cTriggerAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cSolidusKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cGroup_4.eContents().get(1);
		private final Assignment cEffectsAssignment_4_1_0 = (Assignment)cGroup_4_1.eContents().get(0);
		private final RuleCall cEffectsEffectParserRuleCall_4_1_0_0 = (RuleCall)cEffectsAssignment_4_1_0.eContents().get(0);
		private final Keyword cCommaKeyword_4_1_1 = (Keyword)cGroup_4_1.eContents().get(1);
		
		//Action returns synccharts::Action:
		//	{synccharts::Action} isImmediate?="#"? delay=INT? trigger=BooleanExpression? ("/" (effects+=Effect ","?)*)?;
		public ParserRule getRule() { return rule; }

		//{synccharts::Action} isImmediate?="#"? delay=INT? trigger=BooleanExpression? ("/" (effects+=Effect ","?)*)?
		public Group getGroup() { return cGroup; }

		//{synccharts::Action}
		public Action getActionAction_0() { return cActionAction_0; }

		//isImmediate?="#"?
		public Assignment getIsImmediateAssignment_1() { return cIsImmediateAssignment_1; }

		//"#"
		public Keyword getIsImmediateNumberSignKeyword_1_0() { return cIsImmediateNumberSignKeyword_1_0; }

		//delay=INT?
		public Assignment getDelayAssignment_2() { return cDelayAssignment_2; }

		//INT
		public RuleCall getDelayINTTerminalRuleCall_2_0() { return cDelayINTTerminalRuleCall_2_0; }

		//trigger=BooleanExpression?
		public Assignment getTriggerAssignment_3() { return cTriggerAssignment_3; }

		//BooleanExpression
		public RuleCall getTriggerBooleanExpressionParserRuleCall_3_0() { return cTriggerBooleanExpressionParserRuleCall_3_0; }

		//("/" (effects+=Effect ","?)*)?
		public Group getGroup_4() { return cGroup_4; }

		//"/"
		public Keyword getSolidusKeyword_4_0() { return cSolidusKeyword_4_0; }

		//(effects+=Effect ","?)*
		public Group getGroup_4_1() { return cGroup_4_1; }

		//effects+=Effect
		public Assignment getEffectsAssignment_4_1_0() { return cEffectsAssignment_4_1_0; }

		//Effect
		public RuleCall getEffectsEffectParserRuleCall_4_1_0_0() { return cEffectsEffectParserRuleCall_4_1_0_0; }

		//","?
		public Keyword getCommaKeyword_4_1_1() { return cCommaKeyword_4_1_1; }
	}

	public class EffectElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Effect");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEmissionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cAssignmentParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cTextEffectParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//Effect returns synccharts::Effect:
		//	Emission | Assignment | TextEffect;
		public ParserRule getRule() { return rule; }

		//Emission | Assignment | TextEffect
		public Alternatives getAlternatives() { return cAlternatives; }

		//Emission
		public RuleCall getEmissionParserRuleCall_0() { return cEmissionParserRuleCall_0; }

		//Assignment
		public RuleCall getAssignmentParserRuleCall_1() { return cAssignmentParserRuleCall_1; }

		//TextEffect
		public RuleCall getTextEffectParserRuleCall_2() { return cTextEffectParserRuleCall_2; }
	}

	public class EmissionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Emission");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSignalAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cSignalSignalCrossReference_0_0 = (CrossReference)cSignalAssignment_0.eContents().get(0);
		private final RuleCall cSignalSignalIDTerminalRuleCall_0_0_1 = (RuleCall)cSignalSignalCrossReference_0_0.eContents().get(1);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1_0_0 = (Keyword)cGroup_1_0.eContents().get(0);
		private final Assignment cNewValueAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final RuleCall cNewValueValuedExpressionParserRuleCall_1_0_1_0 = (RuleCall)cNewValueAssignment_1_0_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_0_2 = (Keyword)cGroup_1_0.eContents().get(2);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cNewValueAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cNewValueBooleanExpressionParserRuleCall_1_1_1_0 = (RuleCall)cNewValueAssignment_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_1_2 = (Keyword)cGroup_1_1.eContents().get(2);
		
		//Emission returns synccharts::Emission:
		//	signal=[expressions::Signal] ("(" newValue=ValuedExpression ")" | "(" newValue=BooleanExpression ")")?;
		public ParserRule getRule() { return rule; }

		//signal=[expressions::Signal] ("(" newValue=ValuedExpression ")" | "(" newValue=BooleanExpression ")")?
		public Group getGroup() { return cGroup; }

		//signal=[expressions::Signal]
		public Assignment getSignalAssignment_0() { return cSignalAssignment_0; }

		//[expressions::Signal]
		public CrossReference getSignalSignalCrossReference_0_0() { return cSignalSignalCrossReference_0_0; }

		//ID
		public RuleCall getSignalSignalIDTerminalRuleCall_0_0_1() { return cSignalSignalIDTerminalRuleCall_0_0_1; }

		//("(" newValue=ValuedExpression ")" | "(" newValue=BooleanExpression ")")?
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//"(" newValue=ValuedExpression ")"
		public Group getGroup_1_0() { return cGroup_1_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1_0_0() { return cLeftParenthesisKeyword_1_0_0; }

		//newValue=ValuedExpression
		public Assignment getNewValueAssignment_1_0_1() { return cNewValueAssignment_1_0_1; }

		//ValuedExpression
		public RuleCall getNewValueValuedExpressionParserRuleCall_1_0_1_0() { return cNewValueValuedExpressionParserRuleCall_1_0_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_1_0_2() { return cRightParenthesisKeyword_1_0_2; }

		//"(" newValue=BooleanExpression ")"
		public Group getGroup_1_1() { return cGroup_1_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_1_1_0() { return cLeftParenthesisKeyword_1_1_0; }

		//newValue=BooleanExpression
		public Assignment getNewValueAssignment_1_1_1() { return cNewValueAssignment_1_1_1; }

		//BooleanExpression
		public RuleCall getNewValueBooleanExpressionParserRuleCall_1_1_1_0() { return cNewValueBooleanExpressionParserRuleCall_1_1_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_1_1_2() { return cRightParenthesisKeyword_1_1_2; }
	}

	public class AssignmentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Assignment");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cVariableAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cVariableVariableCrossReference_0_0 = (CrossReference)cVariableAssignment_0.eContents().get(0);
		private final RuleCall cVariableVariableIDTerminalRuleCall_0_0_1 = (RuleCall)cVariableVariableCrossReference_0_0.eContents().get(1);
		private final Keyword cColonEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cExpressionAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final RuleCall cExpressionValuedExpressionParserRuleCall_2_0_0 = (RuleCall)cExpressionAssignment_2_0.eContents().get(0);
		private final Assignment cExpressionAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final RuleCall cExpressionBooleanExpressionParserRuleCall_2_1_0 = (RuleCall)cExpressionAssignment_2_1.eContents().get(0);
		
		//Assignment returns synccharts::Assignment:
		//	variable=[expressions::Variable] ":=" (expression=ValuedExpression | expression=BooleanExpression);
		public ParserRule getRule() { return rule; }

		//variable=[expressions::Variable] ":=" (expression=ValuedExpression | expression=BooleanExpression)
		public Group getGroup() { return cGroup; }

		//variable=[expressions::Variable]
		public Assignment getVariableAssignment_0() { return cVariableAssignment_0; }

		//[expressions::Variable]
		public CrossReference getVariableVariableCrossReference_0_0() { return cVariableVariableCrossReference_0_0; }

		//ID
		public RuleCall getVariableVariableIDTerminalRuleCall_0_0_1() { return cVariableVariableIDTerminalRuleCall_0_0_1; }

		//":="
		public Keyword getColonEqualsSignKeyword_1() { return cColonEqualsSignKeyword_1; }

		//expression=ValuedExpression | expression=BooleanExpression
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//expression=ValuedExpression
		public Assignment getExpressionAssignment_2_0() { return cExpressionAssignment_2_0; }

		//ValuedExpression
		public RuleCall getExpressionValuedExpressionParserRuleCall_2_0_0() { return cExpressionValuedExpressionParserRuleCall_2_0_0; }

		//expression=BooleanExpression
		public Assignment getExpressionAssignment_2_1() { return cExpressionAssignment_2_1; }

		//BooleanExpression
		public RuleCall getExpressionBooleanExpressionParserRuleCall_2_1_0() { return cExpressionBooleanExpressionParserRuleCall_2_1_0; }
	}

	public class TextEffectElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TextEffect");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cCodeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cCodeSTRINGTerminalRuleCall_0_0 = (RuleCall)cCodeAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cTypeIDTerminalRuleCall_1_1_0 = (RuleCall)cTypeAssignment_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		
		//TextEffect returns synccharts::TextEffect:
		//	code=STRING ("(" type=ID ")")?;
		public ParserRule getRule() { return rule; }

		//code=STRING ("(" type=ID ")")?
		public Group getGroup() { return cGroup; }

		//code=STRING
		public Assignment getCodeAssignment_0() { return cCodeAssignment_0; }

		//STRING
		public RuleCall getCodeSTRINGTerminalRuleCall_0_0() { return cCodeSTRINGTerminalRuleCall_0_0; }

		//("(" type=ID ")")?
		public Group getGroup_1() { return cGroup_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_1_0() { return cLeftParenthesisKeyword_1_0; }

		//type=ID
		public Assignment getTypeAssignment_1_1() { return cTypeAssignment_1_1; }

		//ID
		public RuleCall getTypeIDTerminalRuleCall_1_1_0() { return cTypeIDTerminalRuleCall_1_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_1_2() { return cRightParenthesisKeyword_1_2; }
	}
	
	
	private ActionElements pAction;
	private EffectElements pEffect;
	private EmissionElements pEmission;
	private AssignmentElements pAssignment;
	private TextEffectElements pTextEffect;
	
	private final GrammarProvider grammarProvider;

	private ExpressionsGrammarAccess gaExpressions;

	@Inject
	public ActionsGrammarAccess(GrammarProvider grammarProvider,
		ExpressionsGrammarAccess gaExpressions) {
		this.grammarProvider = grammarProvider;
		this.gaExpressions = gaExpressions;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public ExpressionsGrammarAccess getExpressionsGrammarAccess() {
		return gaExpressions;
	}

	
	//Action returns synccharts::Action:
	//	{synccharts::Action} isImmediate?="#"? delay=INT? trigger=BooleanExpression? ("/" (effects+=Effect ","?)*)?;
	public ActionElements getActionAccess() {
		return (pAction != null) ? pAction : (pAction = new ActionElements());
	}
	
	public ParserRule getActionRule() {
		return getActionAccess().getRule();
	}

	//Effect returns synccharts::Effect:
	//	Emission | Assignment | TextEffect;
	public EffectElements getEffectAccess() {
		return (pEffect != null) ? pEffect : (pEffect = new EffectElements());
	}
	
	public ParserRule getEffectRule() {
		return getEffectAccess().getRule();
	}

	//Emission returns synccharts::Emission:
	//	signal=[expressions::Signal] ("(" newValue=ValuedExpression ")" | "(" newValue=BooleanExpression ")")?;
	public EmissionElements getEmissionAccess() {
		return (pEmission != null) ? pEmission : (pEmission = new EmissionElements());
	}
	
	public ParserRule getEmissionRule() {
		return getEmissionAccess().getRule();
	}

	//Assignment returns synccharts::Assignment:
	//	variable=[expressions::Variable] ":=" (expression=ValuedExpression | expression=BooleanExpression);
	public AssignmentElements getAssignmentAccess() {
		return (pAssignment != null) ? pAssignment : (pAssignment = new AssignmentElements());
	}
	
	public ParserRule getAssignmentRule() {
		return getAssignmentAccess().getRule();
	}

	//TextEffect returns synccharts::TextEffect:
	//	code=STRING ("(" type=ID ")")?;
	public TextEffectElements getTextEffectAccess() {
		return (pTextEffect != null) ? pTextEffect : (pTextEffect = new TextEffectElements());
	}
	
	public ParserRule getTextEffectRule() {
		return getTextEffectAccess().getRule();
	}

	//// --------------------------
	////
	////   EXPRESSIONS
	////
	//// --------------------------
	//Expression:
	//	BooleanExpression;
	public ExpressionsGrammarAccess.ExpressionElements getExpressionAccess() {
		return gaExpressions.getExpressionAccess();
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}

	//// Example: not D and C or ?E = 42 or not (A and (B or C))
	//BooleanExpression returns Expression:
	//	OrExpression;
	public ExpressionsGrammarAccess.BooleanExpressionElements getBooleanExpressionAccess() {
		return gaExpressions.getBooleanExpressionAccess();
	}
	
	public ParserRule getBooleanExpressionRule() {
		return getBooleanExpressionAccess().getRule();
	}

	//// Example: A or B, A and B and C, C and B or D and not E, A and B and C
	//OrExpression returns Expression:
	//	AndExpression ({OperatorExpression.subExpressions+=current} operator=OrOperator subExpressions+=AndExpression)*;
	public ExpressionsGrammarAccess.OrExpressionElements getOrExpressionAccess() {
		return gaExpressions.getOrExpressionAccess();
	}
	
	public ParserRule getOrExpressionRule() {
		return getOrExpressionAccess().getRule();
	}

	//// Example: A and B, not C and 42 <= ?D
	//AndExpression returns Expression:
	//	NotExpression ({OperatorExpression.subExpressions+=current} operator=AndOperator subExpressions+=NotExpression)*;
	public ExpressionsGrammarAccess.AndExpressionElements getAndExpressionAccess() {
		return gaExpressions.getAndExpressionAccess();
	}
	
	public ParserRule getAndExpressionRule() {
		return getAndExpressionAccess().getRule();
	}

	//// Example: not A, not false, not (A or B)
	//// at the latter we need the parans to indicate the right binding
	//NotExpression returns Expression:
	//	AtomicExpression | {OperatorExpression} operator=NotOperator subExpressions+=AtomicExpression;
	public ExpressionsGrammarAccess.NotExpressionElements getNotExpressionAccess() {
		return gaExpressions.getNotExpressionAccess();
	}
	
	public ParserRule getNotExpressionRule() {
		return getNotExpressionAccess().getRule();
	}

	//// Example: true, A, 42>var1, (A or B), (not D and C or ?E = 42)
	//// note that the order of CompareOperation and SignalReference is important. This might be an Xtext bug...
	//AtomicExpression returns Expression:
	//	BooleanValue | SignalReference | {OperatorExpression} operator=PreOperator "(" subExpressions+=SignalReference ")" |
	//	"(" CompareOperation ")" | "(" BooleanExpression ")";
	public ExpressionsGrammarAccess.AtomicExpressionElements getAtomicExpressionAccess() {
		return gaExpressions.getAtomicExpressionAccess();
	}
	
	public ParserRule getAtomicExpressionRule() {
		return getAtomicExpressionAccess().getRule();
	}

	//SignalReference:
	//	signal=[Signal|EString];
	public ExpressionsGrammarAccess.SignalReferenceElements getSignalReferenceAccess() {
		return gaExpressions.getSignalReferenceAccess();
	}
	
	public ParserRule getSignalReferenceRule() {
		return getSignalReferenceAccess().getRule();
	}

	//// Example: 42 <= ?A
	//CompareOperation returns Expression:
	//	ValuedExpression ({OperatorExpression.subExpressions+=current} operator=CompareOperator
	//	subExpressions+=ValuedExpression);
	public ExpressionsGrammarAccess.CompareOperationElements getCompareOperationAccess() {
		return gaExpressions.getCompareOperationAccess();
	}
	
	public ParserRule getCompareOperationRule() {
		return getCompareOperationAccess().getRule();
	}

	//// everything that evaluates to a primitive number value
	//ValuedExpression returns Expression:
	//	AddExpression;
	public ExpressionsGrammarAccess.ValuedExpressionElements getValuedExpressionAccess() {
		return gaExpressions.getValuedExpressionAccess();
	}
	
	public ParserRule getValuedExpressionRule() {
		return getValuedExpressionAccess().getRule();
	}

	//// Example: 1 + 2
	//AddExpression returns Expression:
	//	SubExpression ({OperatorExpression.subExpressions+=current} operator=AddOperator subExpressions+=SubExpression)*;
	public ExpressionsGrammarAccess.AddExpressionElements getAddExpressionAccess() {
		return gaExpressions.getAddExpressionAccess();
	}
	
	public ParserRule getAddExpressionRule() {
		return getAddExpressionAccess().getRule();
	}

	//// Example: varA - ?B
	//SubExpression returns Expression:
	//	MultExpression ({OperatorExpression.subExpressions+=current} operator=SubOperator subExpressions+=MultExpression)*;
	public ExpressionsGrammarAccess.SubExpressionElements getSubExpressionAccess() {
		return gaExpressions.getSubExpressionAccess();
	}
	
	public ParserRule getSubExpressionRule() {
		return getSubExpressionAccess().getRule();
	}

	//// Example: 2 * 4
	//MultExpression returns Expression:
	//	ModExpression ({OperatorExpression.subExpressions+=current} operator=MultOperator subExpressions+=ModExpression)*;
	public ExpressionsGrammarAccess.MultExpressionElements getMultExpressionAccess() {
		return gaExpressions.getMultExpressionAccess();
	}
	
	public ParserRule getMultExpressionRule() {
		return getMultExpressionAccess().getRule();
	}

	//// Example: varA mod ?B
	//ModExpression returns Expression:
	//	AtomicValuedExpression ({OperatorExpression.subExpressions+=current} operator=ModOperator
	//	subExpressions+=AtomicValuedExpression)?;
	public ExpressionsGrammarAccess.ModExpressionElements getModExpressionAccess() {
		return gaExpressions.getModExpressionAccess();
	}
	
	public ParserRule getModExpressionRule() {
		return getModExpressionAccess().getRule();
	}

	//AtomicValuedExpression returns Expression:
	//	IntValue | FloatValue | VariableReference | ValueTestExpression | PreValueTestExpression | "(" DivExpression ")" | "("
	//	ValuedExpression ")" | TextExpression;
	public ExpressionsGrammarAccess.AtomicValuedExpressionElements getAtomicValuedExpressionAccess() {
		return gaExpressions.getAtomicValuedExpressionAccess();
	}
	
	public ParserRule getAtomicValuedExpressionRule() {
		return getAtomicValuedExpressionAccess().getRule();
	}

	//// Example: (2 / 4)
	//// note: division always has to have parantheses because the '/' sign is also used for trigger/effect delimiter
	//DivExpression returns Expression:
	//	AtomicValuedExpression {OperatorExpression.subExpressions+=current} operator=DivOperator
	//	subExpressions+=AtomicValuedExpression;
	public ExpressionsGrammarAccess.DivExpressionElements getDivExpressionAccess() {
		return gaExpressions.getDivExpressionAccess();
	}
	
	public ParserRule getDivExpressionRule() {
		return getDivExpressionAccess().getRule();
	}

	//VariableReference:
	//	variable=[Variable|EString];
	public ExpressionsGrammarAccess.VariableReferenceElements getVariableReferenceAccess() {
		return gaExpressions.getVariableReferenceAccess();
	}
	
	public ParserRule getVariableReferenceRule() {
		return getVariableReferenceAccess().getRule();
	}

	//// Example: ? A
	//ValueTestExpression returns OperatorExpression:
	//	operator=ValueTestOperator "(" subExpressions+=SignalReference ")";
	public ExpressionsGrammarAccess.ValueTestExpressionElements getValueTestExpressionAccess() {
		return gaExpressions.getValueTestExpressionAccess();
	}
	
	public ParserRule getValueTestExpressionRule() {
		return getValueTestExpressionAccess().getRule();
	}

	//// Example: pre (? A)
	//PreValueTestExpression returns OperatorExpression:
	//	operator=PreOperator "(" subExpressions+=ValueTestExpression ")";
	public ExpressionsGrammarAccess.PreValueTestExpressionElements getPreValueTestExpressionAccess() {
		return gaExpressions.getPreValueTestExpressionAccess();
	}
	
	public ParserRule getPreValueTestExpressionRule() {
		return getPreValueTestExpressionAccess().getRule();
	}

	//// Taken from oba's kits grammar
	//TextExpression:
	//	code=STRING ("(" type=ID ")")?;
	public ExpressionsGrammarAccess.TextExpressionElements getTextExpressionAccess() {
		return gaExpressions.getTextExpressionAccess();
	}
	
	public ParserRule getTextExpressionRule() {
		return getTextExpressionAccess().getRule();
	}

	//IntValue:
	//	value=EIntegerObject;
	public ExpressionsGrammarAccess.IntValueElements getIntValueAccess() {
		return gaExpressions.getIntValueAccess();
	}
	
	public ParserRule getIntValueRule() {
		return getIntValueAccess().getRule();
	}

	//FloatValue:
	//	value=EFloatObject;
	public ExpressionsGrammarAccess.FloatValueElements getFloatValueAccess() {
		return gaExpressions.getFloatValueAccess();
	}
	
	public ParserRule getFloatValueRule() {
		return getFloatValueAccess().getRule();
	}

	//BooleanValue:
	//	value=EBooleanObject;
	public ExpressionsGrammarAccess.BooleanValueElements getBooleanValueAccess() {
		return gaExpressions.getBooleanValueAccess();
	}
	
	public ParserRule getBooleanValueRule() {
		return getBooleanValueAccess().getRule();
	}

	//EIntegerObject returns ecore::EIntegerObject:
	//	"-"? INT;
	public ExpressionsGrammarAccess.EIntegerObjectElements getEIntegerObjectAccess() {
		return gaExpressions.getEIntegerObjectAccess();
	}
	
	public ParserRule getEIntegerObjectRule() {
		return getEIntegerObjectAccess().getRule();
	}

	//EFloatObject returns ecore::EFloatObject:
	//	"-"? INT? "." INT (("E" | "e") "-"? INT)?;
	public ExpressionsGrammarAccess.EFloatObjectElements getEFloatObjectAccess() {
		return gaExpressions.getEFloatObjectAccess();
	}
	
	public ParserRule getEFloatObjectRule() {
		return getEFloatObjectAccess().getRule();
	}

	//EBooleanObject returns ecore::EBooleanObject:
	//	"true" | "false";
	public ExpressionsGrammarAccess.EBooleanObjectElements getEBooleanObjectAccess() {
		return gaExpressions.getEBooleanObjectAccess();
	}
	
	public ParserRule getEBooleanObjectRule() {
		return getEBooleanObjectAccess().getRule();
	}

	//EString returns ecore::EString:
	//	STRING | ID;
	public ExpressionsGrammarAccess.EStringElements getEStringAccess() {
		return gaExpressions.getEStringAccess();
	}
	
	public ParserRule getEStringRule() {
		return getEStringAccess().getRule();
	}

	//enum CompareOperator returns OperatorType:
	//	EQ="=" | LT="<" | LEQ="<=" | GT=">" | GEQ=">=" | NE="<>";
	public ExpressionsGrammarAccess.CompareOperatorElements getCompareOperatorAccess() {
		return gaExpressions.getCompareOperatorAccess();
	}
	
	public EnumRule getCompareOperatorRule() {
		return getCompareOperatorAccess().getRule();
	}

	//enum PreOperator returns OperatorType:
	//	PRE="pre";
	public ExpressionsGrammarAccess.PreOperatorElements getPreOperatorAccess() {
		return gaExpressions.getPreOperatorAccess();
	}
	
	public EnumRule getPreOperatorRule() {
		return getPreOperatorAccess().getRule();
	}

	//enum OrOperator returns OperatorType:
	//	OR="or";
	public ExpressionsGrammarAccess.OrOperatorElements getOrOperatorAccess() {
		return gaExpressions.getOrOperatorAccess();
	}
	
	public EnumRule getOrOperatorRule() {
		return getOrOperatorAccess().getRule();
	}

	//enum AndOperator returns OperatorType:
	//	AND="and";
	public ExpressionsGrammarAccess.AndOperatorElements getAndOperatorAccess() {
		return gaExpressions.getAndOperatorAccess();
	}
	
	public EnumRule getAndOperatorRule() {
		return getAndOperatorAccess().getRule();
	}

	//enum NotOperator returns OperatorType:
	//	NOT="not";
	public ExpressionsGrammarAccess.NotOperatorElements getNotOperatorAccess() {
		return gaExpressions.getNotOperatorAccess();
	}
	
	public EnumRule getNotOperatorRule() {
		return getNotOperatorAccess().getRule();
	}

	//enum AddOperator returns OperatorType:
	//	ADD="+";
	public ExpressionsGrammarAccess.AddOperatorElements getAddOperatorAccess() {
		return gaExpressions.getAddOperatorAccess();
	}
	
	public EnumRule getAddOperatorRule() {
		return getAddOperatorAccess().getRule();
	}

	//enum SubOperator returns OperatorType:
	//	SUB="-";
	public ExpressionsGrammarAccess.SubOperatorElements getSubOperatorAccess() {
		return gaExpressions.getSubOperatorAccess();
	}
	
	public EnumRule getSubOperatorRule() {
		return getSubOperatorAccess().getRule();
	}

	//enum MultOperator returns OperatorType:
	//	MULT="*";
	public ExpressionsGrammarAccess.MultOperatorElements getMultOperatorAccess() {
		return gaExpressions.getMultOperatorAccess();
	}
	
	public EnumRule getMultOperatorRule() {
		return getMultOperatorAccess().getRule();
	}

	//enum ModOperator returns OperatorType:
	//	MOD="mod";
	public ExpressionsGrammarAccess.ModOperatorElements getModOperatorAccess() {
		return gaExpressions.getModOperatorAccess();
	}
	
	public EnumRule getModOperatorRule() {
		return getModOperatorAccess().getRule();
	}

	//enum DivOperator returns OperatorType:
	//	DIV="/";
	public ExpressionsGrammarAccess.DivOperatorElements getDivOperatorAccess() {
		return gaExpressions.getDivOperatorAccess();
	}
	
	public EnumRule getDivOperatorRule() {
		return getDivOperatorAccess().getRule();
	}

	//enum ValueTestOperator returns OperatorType:
	//	VAL="?";
	public ExpressionsGrammarAccess.ValueTestOperatorElements getValueTestOperatorAccess() {
		return gaExpressions.getValueTestOperatorAccess();
	}
	
	public EnumRule getValueTestOperatorRule() {
		return getValueTestOperatorAccess().getRule();
	}

	/// *
	//   the following declarations are re-used in Interface.xtext, Kits.xtext 
	// * /enum ValueType:
	//	PURE | BOOL | UNSIGNED | INT | FLOAT | HOST;
	public ExpressionsGrammarAccess.ValueTypeElements getValueTypeAccess() {
		return gaExpressions.getValueTypeAccess();
	}
	
	public EnumRule getValueTypeRule() {
		return getValueTypeAccess().getRule();
	}

	//enum CombineOperator:
	//	NONE | ADD="+" | MULT="*" | MAX="max" | MIN="min" | OR="or" | AND="and" | HOST="host";
	public ExpressionsGrammarAccess.CombineOperatorElements getCombineOperatorAccess() {
		return gaExpressions.getCombineOperatorAccess();
	}
	
	public EnumRule getCombineOperatorRule() {
		return getCombineOperatorAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaExpressions.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaExpressions.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" | "n" |
	//	"f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaExpressions.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaExpressions.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaExpressions.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaExpressions.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaExpressions.getANY_OTHERRule();
	} 
}
