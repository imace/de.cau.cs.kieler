/*
* generated by Xtext
*/

package de.cau.cs.kieler.synccharts.text.kitsState.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import de.cau.cs.kieler.synccharts.text.kits.services.KitsGrammarAccess;
import de.cau.cs.kieler.synccharts.text.actions.services.ActionsGrammarAccess;
import de.cau.cs.kieler.core.kexpressions.services.KExpressionsGrammarAccess;
import de.cau.cs.kieler.core.annotations.services.AnnotationsGrammarAccess;

@Singleton
public class KitsStateGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class RootStateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RootState");
		private final RuleCall cStateParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//RootState returns synccharts::State:
		//	State;
		public ParserRule getRule() { return rule; }

		//State
		public RuleCall getStateParserRuleCall() { return cStateParserRuleCall; }
	}
	
	
	private RootStateElements pRootState;
	
	private final GrammarProvider grammarProvider;

	private KitsGrammarAccess gaKits;

	@Inject
	public KitsStateGrammarAccess(GrammarProvider grammarProvider,
		KitsGrammarAccess gaKits) {
		this.grammarProvider = grammarProvider;
		this.gaKits = gaKits;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public KitsGrammarAccess getKitsGrammarAccess() {
		return gaKits;
	}

	
	//RootState returns synccharts::State:
	//	State;
	public RootStateElements getRootStateAccess() {
		return (pRootState != null) ? pRootState : (pRootState = new RootStateElements());
	}
	
	public ParserRule getRootStateRule() {
		return getRootStateAccess().getRule();
	}

	//RootRegion returns synccharts::Region:
	//	annotations+=ImportAnnotation* (annotations+=StringAnnotation* "region" id=ID? label=STRING? ":" (variables+=Variable
	//	| signals+=Signal)* bodyText+=TextualCode*)? states+=State*;
	public KitsGrammarAccess.RootRegionElements getRootRegionAccess() {
		return gaKits.getRootRegionAccess();
	}
	
	public ParserRule getRootRegionRule() {
		return getRootRegionAccess().getRule();
	}

	//// ---------------------------------------------------------------------------------------------------
	//
	//SingleRegion returns synccharts::Region:
	//	(annotations+=StringAnnotation* "region" id=ID? label=STRING? ":" (variables+=Variable | signals+=Signal)*
	//	bodyText+=TextualCode*)? states+=State*;
	public KitsGrammarAccess.SingleRegionElements getSingleRegionAccess() {
		return gaKits.getSingleRegionAccess();
	}
	
	public ParserRule getSingleRegionRule() {
		return getSingleRegionAccess().getRule();
	}

	//// ---------------------------------------------------------------------------------------------------
	//
	//TextualCode returns kexpressions::TextualCode:
	//	"textual" "code" ("(" type=ID ")")? ":" code=STRING;
	public KitsGrammarAccess.TextualCodeElements getTextualCodeAccess() {
		return gaKits.getTextualCodeAccess();
	}
	
	public ParserRule getTextualCodeRule() {
		return getTextualCodeAccess().getRule();
	}

	//Region returns synccharts::Region:
	//	annotations+=StringAnnotation* "region" id=ID? label=STRING? ":" (variables+=Variable | signals+=Signal)*
	//	bodyText+=TextualCode* states+=State+;
	public KitsGrammarAccess.RegionElements getRegionAccess() {
		return gaKits.getRegionAccess();
	}
	
	public ParserRule getRegionRule() {
		return getRegionAccess().getRule();
	}

	//// ---------------------------------------------------------------------------------------------------
	//
	//State returns synccharts::State:
	//	annotations+=StringAnnotation* (isInitial?="init" isFinal?="final"? | isFinal?="final" isInitial?="init"?)?
	//	type=StateType? "state" id=ID label=STRING? ("@" bodyReference=[synccharts::State] ("[" renamings+=Substitution (","
	//	renamings+=Substitution)* "]")? | "{" ((signals+=Signal | variables+=Variable | "onentry" entryActions+=Action |
	//	"oninner" innerActions+=Action | "onexit" exitActions+=Action | "suspension" suspensionTrigger=Action)*
	//	bodyText+=TextualCode* (regions+=SingleRegion regions+=Region*)?) "}")? outgoingTransitions+=Transition*;
	public KitsGrammarAccess.StateElements getStateAccess() {
		return gaKits.getStateAccess();
	}
	
	public ParserRule getStateRule() {
		return getStateAccess().getRule();
	}

	//// ---------------------------------------------------------------------------------------------------
	//
	//Transition returns synccharts::Transition:
	//	annotations+=StringAnnotation* type=TransitionType priority=INT? targetState=[synccharts::State] ("with"
	//	(isImmediate?="#"? delay=INT? trigger=BooleanExpression? ("/" effects+=Effect ("," effects+=Effect)*)? |
	//	label=STRING))? isHistory?="history"?;
	public KitsGrammarAccess.TransitionElements getTransitionAccess() {
		return gaKits.getTransitionAccess();
	}
	
	public ParserRule getTransitionRule() {
		return getTransitionAccess().getRule();
	}

	//// ---------------------------------------------------------------------------------------------------
	//
	//Signal returns kexpressions::Signal:
	//	annotations+=StringAnnotation* isInput?="input"? isOutput?="output"? "signal" name=ID (":=" initialValue=AnyType)?
	//	(":" (type=ValueType | hostType=STRING) | ":" "combine" (type=ValueType | hostType=STRING) "with"
	//	(combineOperator=CombineOperator | hostCombineOperator=STRING))?;
	public KitsGrammarAccess.SignalElements getSignalAccess() {
		return gaKits.getSignalAccess();
	}
	
	public ParserRule getSignalRule() {
		return getSignalAccess().getRule();
	}

	//// ---------------------------------------------------------------------------------------------------
	//
	//Variable returns kexpressions::Variable:
	//	annotations+=StringAnnotation* "var" name=ID (":=" initialValue=AnyType)? ":" (type=ValueType | hostType=STRING);
	public KitsGrammarAccess.VariableElements getVariableAccess() {
		return gaKits.getVariableAccess();
	}
	
	public ParserRule getVariableRule() {
		return getVariableAccess().getRule();
	}

	//// ---------------------------------------------------------------------------------------------------
	//
	//Substitution returns synccharts::Substitution:
	//	actual=ID "/" formal=ID;
	public KitsGrammarAccess.SubstitutionElements getSubstitutionAccess() {
		return gaKits.getSubstitutionAccess();
	}
	
	public ParserRule getSubstitutionRule() {
		return getSubstitutionAccess().getRule();
	}

	//// ---------------------------------------------------------------------------------------------------
	//
	//enum StateType returns synccharts::StateType:
	//	NORMAL="normal" | CONDITIONAL="conditional" | REFERENCE="reference" | TEXTUAL="textual";
	public KitsGrammarAccess.StateTypeElements getStateTypeAccess() {
		return gaKits.getStateTypeAccess();
	}
	
	public EnumRule getStateTypeRule() {
		return getStateTypeAccess().getRule();
	}

	//enum TransitionType returns synccharts::TransitionType:
	//	WEAKABORT="-->" | STRONGABORT="o->" | NORMALTERMINATION=">->";
	public KitsGrammarAccess.TransitionTypeElements getTransitionTypeAccess() {
		return gaKits.getTransitionTypeAccess();
	}
	
	public EnumRule getTransitionTypeRule() {
		return getTransitionTypeAccess().getRule();
	}

	//// chsch: The action rule is used in Kits.xtext for entry-, inner-, exitActions, suspensionTrigger 
	//Action returns synccharts::Action:
	//	{synccharts::Action} isImmediate?="#"? delay=INT? trigger=BooleanExpression? ("/" effects+=Effect (","
	//	effects+=Effect)*)?;
	public ActionsGrammarAccess.ActionElements getActionAccess() {
		return gaKits.getActionAccess();
	}
	
	public ParserRule getActionRule() {
		return getActionAccess().getRule();
	}

	//Effect returns synccharts::Effect:
	//	Emission | Assignment | TextEffect;
	public ActionsGrammarAccess.EffectElements getEffectAccess() {
		return gaKits.getEffectAccess();
	}
	
	public ParserRule getEffectRule() {
		return getEffectAccess().getRule();
	}

	//Emission returns synccharts::Emission:
	//	signal=[kexpressions::Signal] ("(" newValue=Expression ")")?;
	public ActionsGrammarAccess.EmissionElements getEmissionAccess() {
		return gaKits.getEmissionAccess();
	}
	
	public ParserRule getEmissionRule() {
		return getEmissionAccess().getRule();
	}

	//Assignment returns synccharts::Assignment:
	//	variable=[kexpressions::Variable] ":=" expression=Expression;
	public ActionsGrammarAccess.AssignmentElements getAssignmentAccess() {
		return gaKits.getAssignmentAccess();
	}
	
	public ParserRule getAssignmentRule() {
		return getAssignmentAccess().getRule();
	}

	//TextEffect returns synccharts::TextEffect:
	//	code=HOSTCODE ("(" type=ID ")")?;
	public ActionsGrammarAccess.TextEffectElements getTextEffectAccess() {
		return gaKits.getTextEffectAccess();
	}
	
	public ParserRule getTextEffectRule() {
		return getTextEffectAccess().getRule();
	}

	//enum DivOperator returns kexpressions::OperatorType:
	//	DIV=":";
	public ActionsGrammarAccess.DivOperatorElements getDivOperatorAccess() {
		return gaKits.getDivOperatorAccess();
	}
	
	public EnumRule getDivOperatorRule() {
		return getDivOperatorAccess().getRule();
	}

	//Root returns ecore::EObject:
	//	Expression | InterfaceDeclaration;
	public KExpressionsGrammarAccess.RootElements getRootAccess() {
		return gaKits.getRootAccess();
	}
	
	public ParserRule getRootRule() {
		return getRootAccess().getRule();
	}

	////Variable returns annotations::Annotatable:
	////    (annotations += StringAnnotation)*;
	//// --------------------------
	////
	////   EXPRESSIONS
	////
	//// --------------------------
	//Expression:
	//	BooleanExpression | ValuedExpression;
	public KExpressionsGrammarAccess.ExpressionElements getExpressionAccess() {
		return gaKits.getExpressionAccess();
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}

	//// Example: not D and C or ?E = 42 or not (A and (B or C))
	//BooleanExpression returns Expression:
	//	OrExpression;
	public KExpressionsGrammarAccess.BooleanExpressionElements getBooleanExpressionAccess() {
		return gaKits.getBooleanExpressionAccess();
	}
	
	public ParserRule getBooleanExpressionRule() {
		return getBooleanExpressionAccess().getRule();
	}

	//// Example: A or B, A and B and C, C and B or D and not E, A and B and C
	//OrExpression returns Expression:
	//	AndExpression ({OperatorExpression.subExpressions+=current} operator=OrOperator subExpressions+=AndExpression)*;
	public KExpressionsGrammarAccess.OrExpressionElements getOrExpressionAccess() {
		return gaKits.getOrExpressionAccess();
	}
	
	public ParserRule getOrExpressionRule() {
		return getOrExpressionAccess().getRule();
	}

	//// Example: A and B, not C and 42 <= ?D
	//AndExpression returns Expression:
	//	CompareOperation ({OperatorExpression.subExpressions+=current} operator=AndOperator
	//	subExpressions+=CompareOperation)*;
	public KExpressionsGrammarAccess.AndExpressionElements getAndExpressionAccess() {
		return gaKits.getAndExpressionAccess();
	}
	
	public ParserRule getAndExpressionRule() {
		return getAndExpressionAccess().getRule();
	}

	//// Example: 42 <= ?A
	//CompareOperation returns Expression:
	//	NotOrValuedExpression ({OperatorExpression.subExpressions+=current} operator=CompareOperator
	//	subExpressions+=NotOrValuedExpression) | NotExpression;
	public KExpressionsGrammarAccess.CompareOperationElements getCompareOperationAccess() {
		return gaKits.getCompareOperationAccess();
	}
	
	public ParserRule getCompareOperationRule() {
		return getCompareOperationAccess().getRule();
	}

	//// order IS IMPORTANT
	//NotOrValuedExpression returns Expression:
	//	ValuedExpression | NotExpression;
	public KExpressionsGrammarAccess.NotOrValuedExpressionElements getNotOrValuedExpressionAccess() {
		return gaKits.getNotOrValuedExpressionAccess();
	}
	
	public ParserRule getNotOrValuedExpressionRule() {
		return getNotOrValuedExpressionAccess().getRule();
	}

	//// Example: not A, not false, not (A or B)
	//// at the latter we need the parans to indicate the right binding
	//NotExpression returns Expression:
	//	{OperatorExpression} operator=NotOperator subExpressions+=NotExpression | AtomicExpression;
	public KExpressionsGrammarAccess.NotExpressionElements getNotExpressionAccess() {
		return gaKits.getNotExpressionAccess();
	}
	
	public ParserRule getNotExpressionRule() {
		return getNotExpressionAccess().getRule();
	}

	//// everything that evaluates to a primitive number value
	//ValuedExpression returns Expression:
	//	AddExpression;
	public KExpressionsGrammarAccess.ValuedExpressionElements getValuedExpressionAccess() {
		return gaKits.getValuedExpressionAccess();
	}
	
	public ParserRule getValuedExpressionRule() {
		return getValuedExpressionAccess().getRule();
	}

	//// Example: 1 + 2
	//AddExpression returns Expression:
	//	SubExpression ({OperatorExpression.subExpressions+=current} operator=AddOperator subExpressions+=SubExpression)*;
	public KExpressionsGrammarAccess.AddExpressionElements getAddExpressionAccess() {
		return gaKits.getAddExpressionAccess();
	}
	
	public ParserRule getAddExpressionRule() {
		return getAddExpressionAccess().getRule();
	}

	//// Example: varA - ?B
	//SubExpression returns Expression:
	//	MultExpression ({OperatorExpression.subExpressions+=current} operator=SubOperator subExpressions+=MultExpression)*;
	public KExpressionsGrammarAccess.SubExpressionElements getSubExpressionAccess() {
		return gaKits.getSubExpressionAccess();
	}
	
	public ParserRule getSubExpressionRule() {
		return getSubExpressionAccess().getRule();
	}

	////    ({OperatorExpression} subExpressions+=MultExpression (operator=SubOperator subExpressions+=MultExpression)+)
	////	| ({OperatorExpression} subExpressions+=MultExpression subExpressions+=NIntValue)
	////    | MultExpression;
	//// Example: 2 * 4
	//MultExpression returns Expression:
	//	DivExpression ({OperatorExpression.subExpressions+=current} operator=MultOperator subExpressions+=DivExpression)*;
	public KExpressionsGrammarAccess.MultExpressionElements getMultExpressionAccess() {
		return gaKits.getMultExpressionAccess();
	}
	
	public ParserRule getMultExpressionRule() {
		return getMultExpressionAccess().getRule();
	}

	//// Example: (2 / 4)
	//// note: division always has to have parantheses because the '/' sign is also used for trigger/effect delimiter
	//DivExpression returns Expression:
	//	ModExpression ({OperatorExpression.subExpressions+=current} operator=DivOperator subExpressions+=ModExpression)?;
	public KExpressionsGrammarAccess.DivExpressionElements getDivExpressionAccess() {
		return gaKits.getDivExpressionAccess();
	}
	
	public ParserRule getDivExpressionRule() {
		return getDivExpressionAccess().getRule();
	}

	//// Example: varA mod ?B
	//ModExpression returns Expression:
	//	NegExpression ({OperatorExpression.subExpressions+=current} operator=ModOperator
	//	subExpressions+=AtomicValuedExpression)?;
	public KExpressionsGrammarAccess.ModExpressionElements getModExpressionAccess() {
		return gaKits.getModExpressionAccess();
	}
	
	public ParserRule getModExpressionRule() {
		return getModExpressionAccess().getRule();
	}

	//// Example: not A, not false, not (A or B)
	//// at the latter we need the parans to indicate the right binding
	//NegExpression returns Expression:
	//	{OperatorExpression} operator=SubOperator subExpressions+=NegExpression | AtomicValuedExpression;
	public KExpressionsGrammarAccess.NegExpressionElements getNegExpressionAccess() {
		return gaKits.getNegExpressionAccess();
	}
	
	public ParserRule getNegExpressionRule() {
		return getNegExpressionAccess().getRule();
	}

	//AtomicExpression returns Expression:
	//	BooleanValue | ValuedObjectTestExpression | "(" BooleanExpression ")" | TextExpression;
	public KExpressionsGrammarAccess.AtomicExpressionElements getAtomicExpressionAccess() {
		return gaKits.getAtomicExpressionAccess();
	}
	
	public ParserRule getAtomicExpressionRule() {
		return getAtomicExpressionAccess().getRule();
	}

	//AtomicValuedExpression returns Expression:
	//	IntValue //    | '(' DivExpression ')'
	//	| FloatValue | "(" ValuedExpression ")" | AtomicExpression;
	public KExpressionsGrammarAccess.AtomicValuedExpressionElements getAtomicValuedExpressionAccess() {
		return gaKits.getAtomicValuedExpressionAccess();
	}
	
	public ParserRule getAtomicValuedExpressionRule() {
		return getAtomicValuedExpressionAccess().getRule();
	}

	//// Example: pre(pre(?A)), pre(pre(A)), ?A, A varX
	//ValuedObjectTestExpression returns Expression:
	//	{OperatorExpression} operator=PreOperator "(" subExpressions+=ValuedObjectTestExpression ")" | {OperatorExpression}
	//	operator=ValueTestOperator subExpressions+=ValuedObjectReference | ValuedObjectReference;
	public KExpressionsGrammarAccess.ValuedObjectTestExpressionElements getValuedObjectTestExpressionAccess() {
		return gaKits.getValuedObjectTestExpressionAccess();
	}
	
	public ParserRule getValuedObjectTestExpressionRule() {
		return getValuedObjectTestExpressionAccess().getRule();
	}

	//// Example: A, varB
	//ValuedObjectReference:
	//	valuedObject=[ValuedObject];
	public KExpressionsGrammarAccess.ValuedObjectReferenceElements getValuedObjectReferenceAccess() {
		return gaKits.getValuedObjectReferenceAccess();
	}
	
	public ParserRule getValuedObjectReferenceRule() {
		return getValuedObjectReferenceAccess().getRule();
	}

	//// Example: 'printf(...)'(C)
	//TextExpression:
	//	code=HOSTCODE ("(" type=ID ")")?;
	public KExpressionsGrammarAccess.TextExpressionElements getTextExpressionAccess() {
		return gaKits.getTextExpressionAccess();
	}
	
	public ParserRule getTextExpressionRule() {
		return getTextExpressionAccess().getRule();
	}

	//IntValue:
	//	value=INT;
	public KExpressionsGrammarAccess.IntValueElements getIntValueAccess() {
		return gaKits.getIntValueAccess();
	}
	
	public ParserRule getIntValueRule() {
		return getIntValueAccess().getRule();
	}

	////NIntValue returns IntValue:
	////	value=NINT;
	//FloatValue:
	//	value=Float;
	public KExpressionsGrammarAccess.FloatValueElements getFloatValueAccess() {
		return gaKits.getFloatValueAccess();
	}
	
	public ParserRule getFloatValueRule() {
		return getFloatValueAccess().getRule();
	}

	//BooleanValue:
	//	value=Boolean;
	public KExpressionsGrammarAccess.BooleanValueElements getBooleanValueAccess() {
		return gaKits.getBooleanValueAccess();
	}
	
	public ParserRule getBooleanValueRule() {
		return getBooleanValueAccess().getRule();
	}

	//// data type rule allowing any kind of value to be accepted,
	//// e.g. as initialValues of valuedObjects
	//// used in Kits.xtext 
	//AnyType returns ecore::EString:
	//	Boolean | INT | Float | ID | STRING;
	public KExpressionsGrammarAccess.AnyTypeElements getAnyTypeAccess() {
		return gaKits.getAnyTypeAccess();
	}
	
	public ParserRule getAnyTypeRule() {
		return getAnyTypeAccess().getRule();
	}

	//// --------------------------
	////
	////  Interface Declarations
	////
	//// --------------------------
	//InterfaceDeclaration:
	//	InterfaceSignalDecl | InterfaceVariableDecl;
	public KExpressionsGrammarAccess.InterfaceDeclarationElements getInterfaceDeclarationAccess() {
		return gaKits.getInterfaceDeclarationAccess();
	}
	
	public ParserRule getInterfaceDeclarationRule() {
		return getInterfaceDeclarationAccess().getRule();
	}

	//ISignal:
	//	name=ID channelDescr=ChannelDescription?;
	public KExpressionsGrammarAccess.ISignalElements getISignalAccess() {
		return gaKits.getISignalAccess();
	}
	
	public ParserRule getISignalRule() {
		return getISignalAccess().getRule();
	}

	//InterfaceSignalDecl:
	//	{Input} "input" signals+=ISignal ("," signals+=ISignal)* ";" | {Output} "output" signals+=ISignal (","
	//	signals+=ISignal)* ";" | {InputOutput} "inputoutput" signals+=ISignal ("," signals+=ISignal)* ";" | {Return} "return"
	//	signals+=ISignal ("," signals+=ISignal)* ";";
	public KExpressionsGrammarAccess.InterfaceSignalDeclElements getInterfaceSignalDeclAccess() {
		return gaKits.getInterfaceSignalDeclAccess();
	}
	
	public ParserRule getInterfaceSignalDeclRule() {
		return getInterfaceSignalDeclAccess().getRule();
	}

	//ChannelDescription:
	//	":" type=TypeIdentifier | "(" type=TypeIdentifier ")" | ":=" expression=Expression ":" type=TypeIdentifier;
	public KExpressionsGrammarAccess.ChannelDescriptionElements getChannelDescriptionAccess() {
		return gaKits.getChannelDescriptionAccess();
	}
	
	public ParserRule getChannelDescriptionRule() {
		return getChannelDescriptionAccess().getRule();
	}

	//// Variables
	//InterfaceVariableDecl:
	//	"var" varDecls+=VariableDecl ("," varDecls+=VariableDecl)*;
	public KExpressionsGrammarAccess.InterfaceVariableDeclElements getInterfaceVariableDeclAccess() {
		return gaKits.getInterfaceVariableDeclAccess();
	}
	
	public ParserRule getInterfaceVariableDeclRule() {
		return getInterfaceVariableDeclAccess().getRule();
	}

	//VariableDecl:
	//	variables+=IVariable ("," variables+=IVariable)* ":" type=TypeIdentifier;
	public KExpressionsGrammarAccess.VariableDeclElements getVariableDeclAccess() {
		return gaKits.getVariableDeclAccess();
	}
	
	public ParserRule getVariableDeclRule() {
		return getVariableDeclAccess().getRule();
	}

	//IVariable:
	//	name=ID (":=" expression=Expression)?;
	public KExpressionsGrammarAccess.IVariableElements getIVariableAccess() {
		return gaKits.getIVariableAccess();
	}
	
	public ParserRule getIVariableRule() {
		return getIVariableAccess().getRule();
	}

	//// transform ID to hostcode
	//TypeIdentifier:
	//	type=ValueType | typeID=ID | "combine" (type=ValueType | typeID=ID) "with" operator=CombineOperator;
	public KExpressionsGrammarAccess.TypeIdentifierElements getTypeIdentifierAccess() {
		return gaKits.getTypeIdentifierAccess();
	}
	
	public ParserRule getTypeIdentifierRule() {
		return getTypeIdentifierAccess().getRule();
	}

	//// --------------------------
	////
	////  Terminals...
	////
	//// --------------------------
	//enum CompareOperator returns OperatorType:
	//	EQ="=" | LT="<" | LEQ="<=" | GT=">" | GEQ=">=" | NE="<>";
	public KExpressionsGrammarAccess.CompareOperatorElements getCompareOperatorAccess() {
		return gaKits.getCompareOperatorAccess();
	}
	
	public EnumRule getCompareOperatorRule() {
		return getCompareOperatorAccess().getRule();
	}

	//enum PreOperator returns OperatorType:
	//	PRE="pre";
	public KExpressionsGrammarAccess.PreOperatorElements getPreOperatorAccess() {
		return gaKits.getPreOperatorAccess();
	}
	
	public EnumRule getPreOperatorRule() {
		return getPreOperatorAccess().getRule();
	}

	//enum OrOperator returns OperatorType:
	//	OR="or";
	public KExpressionsGrammarAccess.OrOperatorElements getOrOperatorAccess() {
		return gaKits.getOrOperatorAccess();
	}
	
	public EnumRule getOrOperatorRule() {
		return getOrOperatorAccess().getRule();
	}

	//enum AndOperator returns OperatorType:
	//	AND="and";
	public KExpressionsGrammarAccess.AndOperatorElements getAndOperatorAccess() {
		return gaKits.getAndOperatorAccess();
	}
	
	public EnumRule getAndOperatorRule() {
		return getAndOperatorAccess().getRule();
	}

	//enum NotOperator returns OperatorType:
	//	NOT="not";
	public KExpressionsGrammarAccess.NotOperatorElements getNotOperatorAccess() {
		return gaKits.getNotOperatorAccess();
	}
	
	public EnumRule getNotOperatorRule() {
		return getNotOperatorAccess().getRule();
	}

	//enum AddOperator returns OperatorType:
	//	ADD="+";
	public KExpressionsGrammarAccess.AddOperatorElements getAddOperatorAccess() {
		return gaKits.getAddOperatorAccess();
	}
	
	public EnumRule getAddOperatorRule() {
		return getAddOperatorAccess().getRule();
	}

	//enum SubOperator returns OperatorType:
	//	SUB="-";
	public KExpressionsGrammarAccess.SubOperatorElements getSubOperatorAccess() {
		return gaKits.getSubOperatorAccess();
	}
	
	public EnumRule getSubOperatorRule() {
		return getSubOperatorAccess().getRule();
	}

	//enum MultOperator returns OperatorType:
	//	MULT="*";
	public KExpressionsGrammarAccess.MultOperatorElements getMultOperatorAccess() {
		return gaKits.getMultOperatorAccess();
	}
	
	public EnumRule getMultOperatorRule() {
		return getMultOperatorAccess().getRule();
	}

	//enum ModOperator returns OperatorType:
	//	MOD="mod";
	public KExpressionsGrammarAccess.ModOperatorElements getModOperatorAccess() {
		return gaKits.getModOperatorAccess();
	}
	
	public EnumRule getModOperatorRule() {
		return getModOperatorAccess().getRule();
	}

	//enum ValueTestOperator returns OperatorType:
	//	VAL="?";
	public KExpressionsGrammarAccess.ValueTestOperatorElements getValueTestOperatorAccess() {
		return gaKits.getValueTestOperatorAccess();
	}
	
	public EnumRule getValueTestOperatorRule() {
		return getValueTestOperatorAccess().getRule();
	}

	/// *
	//   the following declarations are re-used in Actions.xtext, Interface.xtext, Kits.xtext 
	// * /enum ValueType:
	//	PURE="pure" | BOOL="boolean" | UNSIGNED="unsigned" | INT="integer" | FLOAT="float" | DOUBLE="double" | STRING="string"
	//	| HOST="host";
	public KExpressionsGrammarAccess.ValueTypeElements getValueTypeAccess() {
		return gaKits.getValueTypeAccess();
	}
	
	public EnumRule getValueTypeRule() {
		return getValueTypeAccess().getRule();
	}

	//enum CombineOperator:
	//	NONE="none" | ADD="+" | MULT="*" | MAX="max" | MIN="min" | OR="or" | AND="and" | HOST="host";
	public KExpressionsGrammarAccess.CombineOperatorElements getCombineOperatorAccess() {
		return gaKits.getCombineOperatorAccess();
	}
	
	public EnumRule getCombineOperatorRule() {
		return getCombineOperatorAccess().getRule();
	}

	//// redefine INT terminal to allow negative numbers
	//terminal INT returns ecore::EInt:
	//	"-"? "0".."9"+;
	public TerminalRule getINTRule() {
		return gaKits.getINTRule();
	} 

	////// redefine INT terminal to allow negative numbers
	////terminal NINT returns ecore::EInt:
	////    '-'?('0'..'9')+;
	//// make sure the Float rule does not shadow the INT rule
	//terminal Float returns ecore::EFloatObject:
	//	"-"? "0".."9"+ ("." "0".."9"*) (("e" | "E") ("+" | "-")? "0".."9"+)? "f"? | "-"? "0".."9"+ "f";
	public TerminalRule getFloatRule() {
		return gaKits.getFloatRule();
	} 

	//// introduce boolean values
	//terminal Boolean returns ecore::EBooleanObject:
	//	"true" | "false";
	public TerminalRule getBooleanRule() {
		return gaKits.getBooleanRule();
	} 

	//// custom terminal rule allowing to save transition label string as they are
	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"";
	public TerminalRule getSTRINGRule() {
		return gaKits.getSTRINGRule();
	} 

	//// custom terminal rule allowing to save transition label string as they are
	//terminal HOSTCODE:
	//	"\'" ("\\" ("b" | "t" | "n" | "f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getHOSTCODERule() {
		return gaKits.getHOSTCODERule();
	} 

	//// --------------------------
	////
	////   EXPRESSIONS
	////
	//// --------------------------
	//// introduction of parsing rules for annotations
	//StringAnnotation returns Annotation:
	//	CommentAnnotation | KeyValueAnnotation;
	public AnnotationsGrammarAccess.StringAnnotationElements getStringAnnotationAccess() {
		return gaKits.getStringAnnotationAccess();
	}
	
	public ParserRule getStringAnnotationRule() {
		return getStringAnnotationAccess().getRule();
	}

	//// e.g.: / ** semantic comment * /
	//CommentAnnotation returns StringAnnotation:
	//	value=COMMENT_ANNOTATION;
	public AnnotationsGrammarAccess.CommentAnnotationElements getCommentAnnotationAccess() {
		return gaKits.getCommentAnnotationAccess();
	}
	
	public ParserRule getCommentAnnotationRule() {
		return getCommentAnnotationAccess().getRule();
	}

	//// e.g.: @layouter dot; @layoutOptions "margin 5, dir top-down";    
	//KeyValueAnnotation returns StringAnnotation:
	//	"@" name=ID value=EString;
	public AnnotationsGrammarAccess.KeyValueAnnotationElements getKeyValueAnnotationAccess() {
		return gaKits.getKeyValueAnnotationAccess();
	}
	
	public ParserRule getKeyValueAnnotationRule() {
		return getKeyValueAnnotationAccess().getRule();
	}

	//// needed for importing other resources
	//ImportAnnotation:
	//	"import" importURI=STRING;
	public AnnotationsGrammarAccess.ImportAnnotationElements getImportAnnotationAccess() {
		return gaKits.getImportAnnotationAccess();
	}
	
	public ParserRule getImportAnnotationRule() {
		return getImportAnnotationAccess().getRule();
	}

	//// allow strings without quotes as they don'c contain spaces
	//EString returns ecore::EString:
	//	STRING | ID;
	public AnnotationsGrammarAccess.EStringElements getEStringAccess() {
		return gaKits.getEStringAccess();
	}
	
	public ParserRule getEStringRule() {
		return getEStringAccess().getRule();
	}

	//// custom terminal rule introducing semantic comments
	//terminal COMMENT_ANNOTATION:
	//	"/ **"->"* /";
	public TerminalRule getCOMMENT_ANNOTATIONRule() {
		return gaKits.getCOMMENT_ANNOTATIONRule();
	} 

	//// modified version of Terminals.ML_COMMENT as
	//// COMMENT_ANNOTATION is not recognized correctly with original one 
	//terminal ML_COMMENT:
	//	"/ *" !"*"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaKits.getML_COMMENTRule();
	} 

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaKits.getIDRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaKits.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaKits.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaKits.getANY_OTHERRule();
	} 
}
