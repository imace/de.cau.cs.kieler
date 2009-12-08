/*
* generated by Xtext
*/

package de.cau.cs.kieler.sim.esi.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;


@Singleton
public class EsiGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class TracelistElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "tracelist");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTracesAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cTracesTraceParserRuleCall_0_0 = (RuleCall)cTracesAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cExclamationMarkKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Keyword cResetKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Keyword cSemicolonKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		private final Assignment cTracesAssignment_1_3 = (Assignment)cGroup_1.eContents().get(3);
		private final RuleCall cTracesTraceParserRuleCall_1_3_0 = (RuleCall)cTracesAssignment_1_3.eContents().get(0);
		
		//tracelist:
		//  traces+=trace? ("!" "reset" ";" traces+=trace)+;
		public ParserRule getRule() { return rule; }

		//traces+=trace? ("!" "reset" ";" traces+=trace)+
		public Group getGroup() { return cGroup; }

		//traces+=trace?
		public Assignment getTracesAssignment_0() { return cTracesAssignment_0; }

		//trace
		public RuleCall getTracesTraceParserRuleCall_0_0() { return cTracesTraceParserRuleCall_0_0; }

		//("!" "reset" ";" traces+=trace)+
		public Group getGroup_1() { return cGroup_1; }

		//"!"
		public Keyword getExclamationMarkKeyword_1_0() { return cExclamationMarkKeyword_1_0; }

		//"reset"
		public Keyword getResetKeyword_1_1() { return cResetKeyword_1_1; }

		//";"
		public Keyword getSemicolonKeyword_1_2() { return cSemicolonKeyword_1_2; }

		//traces+=trace
		public Assignment getTracesAssignment_1_3() { return cTracesAssignment_1_3; }

		//trace
		public RuleCall getTracesTraceParserRuleCall_1_3_0() { return cTracesTraceParserRuleCall_1_3_0; }
	}

	public class TraceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "trace");
		private final Assignment cTicksAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cTicksTickParserRuleCall_0 = (RuleCall)cTicksAssignment.eContents().get(0);
		
		//trace:
		//  ticks+=tick+;
		public ParserRule getRule() { return rule; }

		//ticks+=tick+
		public Assignment getTicksAssignment() { return cTicksAssignment; }

		//tick
		public RuleCall getTicksTickParserRuleCall_0() { return cTicksTickParserRuleCall_0; }
	}

	public class TickElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "tick");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cInputAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cInputSignalParserRuleCall_0_0 = (RuleCall)cInputAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cPercentSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Keyword cOutputKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Keyword cColonKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		private final Assignment cOutputAssignment_1_3 = (Assignment)cGroup_1.eContents().get(3);
		private final RuleCall cOutputSignalParserRuleCall_1_3_0 = (RuleCall)cOutputAssignment_1_3.eContents().get(0);
		private final Assignment cNAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cNSemicolonKeyword_2_0 = (Keyword)cNAssignment_2.eContents().get(0);
		
		//tick:
		//  input+=signal* ("%" "Output" ":" output+=signal*)? n=";";
		public ParserRule getRule() { return rule; }

		//input+=signal* ("%" "Output" ":" output+=signal*)? n=";"
		public Group getGroup() { return cGroup; }

		//input+=signal*
		public Assignment getInputAssignment_0() { return cInputAssignment_0; }

		//signal
		public RuleCall getInputSignalParserRuleCall_0_0() { return cInputSignalParserRuleCall_0_0; }

		//("%" "Output" ":" output+=signal*)?
		public Group getGroup_1() { return cGroup_1; }

		//"%"
		public Keyword getPercentSignKeyword_1_0() { return cPercentSignKeyword_1_0; }

		//"Output"
		public Keyword getOutputKeyword_1_1() { return cOutputKeyword_1_1; }

		//":"
		public Keyword getColonKeyword_1_2() { return cColonKeyword_1_2; }

		//output+=signal*
		public Assignment getOutputAssignment_1_3() { return cOutputAssignment_1_3; }

		//signal
		public RuleCall getOutputSignalParserRuleCall_1_3_0() { return cOutputSignalParserRuleCall_1_3_0; }

		//n=";"
		public Assignment getNAssignment_2() { return cNAssignment_2; }

		//";"
		public Keyword getNSemicolonKeyword_2_0() { return cNSemicolonKeyword_2_0; }
	}

	public class SignalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "signal");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cValuedAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final Keyword cValuedLeftParenthesisKeyword_1_0_0 = (Keyword)cValuedAssignment_1_0.eContents().get(0);
		private final Assignment cValAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cValNUMTerminalRuleCall_1_1_0 = (RuleCall)cValAssignment_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		
		//signal:
		//  name=ID (valued?="(" val=NUM ")")?;  
		//
		//     
		//             
		//   
		//               
		/// *------------------------------------------------------------------
		// * LEXER RULES
		// *------------------------------------------------------------------* /
		public ParserRule getRule() { return rule; }

		//name=ID (valued?="(" val=NUM ")")?
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//(valued?="(" val=NUM ")")?
		public Group getGroup_1() { return cGroup_1; }

		//valued?="("
		public Assignment getValuedAssignment_1_0() { return cValuedAssignment_1_0; }

		//"("
		public Keyword getValuedLeftParenthesisKeyword_1_0_0() { return cValuedLeftParenthesisKeyword_1_0_0; }

		//val=NUM
		public Assignment getValAssignment_1_1() { return cValAssignment_1_1; }

		//NUM
		public RuleCall getValNUMTerminalRuleCall_1_1_0() { return cValNUMTerminalRuleCall_1_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_1_2() { return cRightParenthesisKeyword_1_2; }
	}
	
	
	private TracelistElements pTracelist;
	private TraceElements pTrace;
	private TickElements pTick;
	private SignalElements pSignal;
	private TerminalRule tID;
	private TerminalRule tNUM;
	private TerminalRule tWS;
	private TerminalRule tCOMMENT;
	private TerminalRule tDigit;
	private TerminalRule tLetter;
	
	private final GrammarProvider grammarProvider;

	@Inject
	public EsiGrammarAccess(GrammarProvider grammarProvider) {
		this.grammarProvider = grammarProvider;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	
	//tracelist:
	//  traces+=trace? ("!" "reset" ";" traces+=trace)+;
	public TracelistElements getTracelistAccess() {
		return (pTracelist != null) ? pTracelist : (pTracelist = new TracelistElements());
	}
	
	public ParserRule getTracelistRule() {
		return getTracelistAccess().getRule();
	}

	//trace:
	//  ticks+=tick+;
	public TraceElements getTraceAccess() {
		return (pTrace != null) ? pTrace : (pTrace = new TraceElements());
	}
	
	public ParserRule getTraceRule() {
		return getTraceAccess().getRule();
	}

	//tick:
	//  input+=signal* ("%" "Output" ":" output+=signal*)? n=";";
	public TickElements getTickAccess() {
		return (pTick != null) ? pTick : (pTick = new TickElements());
	}
	
	public ParserRule getTickRule() {
		return getTickAccess().getRule();
	}

	//signal:
	//  name=ID (valued?="(" val=NUM ")")?;  
	//
	//     
	//             
	//   
	//               
	/// *------------------------------------------------------------------
	// * LEXER RULES
	// *------------------------------------------------------------------* /
	public SignalElements getSignalAccess() {
		return (pSignal != null) ? pSignal : (pSignal = new SignalElements());
	}
	
	public ParserRule getSignalRule() {
		return getSignalAccess().getRule();
	}

	//terminal ID:
	//  (Letter | "_") (Letter | Digit | "_")*; 
	//               
	/// *------------------------------------------------------------------
	// * LEXER RULES
	// *------------------------------------------------------------------* /
	public TerminalRule getIDRule() {
		return (tID != null) ? tID : (tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ID"));
	} 

	//terminal NUM returns ecore::EInt:
	//  ("+" | "-")? Digit+;
	public TerminalRule getNUMRule() {
		return (tNUM != null) ? tNUM : (tNUM = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "NUM"));
	} 

	//terminal WS:
	//  "\t" | " " | "\r" | "\n";
	public TerminalRule getWSRule() {
		return (tWS != null) ? tWS : (tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "WS"));
	} 

	//terminal COMMENT:
	//  "%" ("A".."N" | "P".."Z")->"\n";
	public TerminalRule getCOMMENTRule() {
		return (tCOMMENT != null) ? tCOMMENT : (tCOMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "COMMENT"));
	} 

	//terminal Digit:
	//  "0".."9";
	public TerminalRule getDigitRule() {
		return (tDigit != null) ? tDigit : (tDigit = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "Digit"));
	} 

	//terminal Letter:
	//  "a".."z" | "A".."Z";
	public TerminalRule getLetterRule() {
		return (tLetter != null) ? tLetter : (tLetter = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "Letter"));
	} 
}
