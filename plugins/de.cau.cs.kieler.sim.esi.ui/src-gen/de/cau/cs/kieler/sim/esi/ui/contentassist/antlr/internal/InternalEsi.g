/*
* generated by Xtext
*/
grammar InternalEsi;

options {
	superClass=AbstractInternalContentAssistParser;
	
}

@lexer::header {
package de.cau.cs.kieler.sim.esi.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package de.cau.cs.kieler.sim.esi.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import de.cau.cs.kieler.sim.esi.services.EsiGrammarAccess;

}

@parser::members {
 
 	private EsiGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(EsiGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }
    
    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuletracelist
entryRuletracelist 
:
{ before(grammarAccess.getTracelistRule()); }
	 ruletracelist
{ after(grammarAccess.getTracelistRule()); } 
	 EOF 
;

// Rule tracelist
ruletracelist
    @init {
		int stackSize = keepStackSize();
    }
	:
(
(
{ before(grammarAccess.getTracelistAccess().getTracesAssignment()); }
(rule__Tracelist__TracesAssignment)
{ after(grammarAccess.getTracelistAccess().getTracesAssignment()); }
)
(
{ before(grammarAccess.getTracelistAccess().getTracesAssignment()); }
(rule__Tracelist__TracesAssignment)*
{ after(grammarAccess.getTracelistAccess().getTracesAssignment()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuletrace
entryRuletrace 
:
{ before(grammarAccess.getTraceRule()); }
	 ruletrace
{ after(grammarAccess.getTraceRule()); } 
	 EOF 
;

// Rule trace
ruletrace
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTraceAccess().getGroup()); }
(rule__Trace__Group__0)
{ after(grammarAccess.getTraceAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuletick
entryRuletick 
:
{ before(grammarAccess.getTickRule()); }
	 ruletick
{ after(grammarAccess.getTickRule()); } 
	 EOF 
;

// Rule tick
ruletick
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTickAccess().getGroup()); }
(rule__Tick__Group__0)
{ after(grammarAccess.getTickAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulesignal
entryRulesignal 
:
{ before(grammarAccess.getSignalRule()); }
	 rulesignal
{ after(grammarAccess.getSignalRule()); } 
	 EOF 
;

// Rule signal
rulesignal
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSignalAccess().getGroup()); }
(rule__Signal__Group__0)
{ after(grammarAccess.getSignalAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulekvpair
entryRulekvpair 
:
{ before(grammarAccess.getKvpairRule()); }
	 rulekvpair
{ after(grammarAccess.getKvpairRule()); } 
	 EOF 
;

// Rule kvpair
rulekvpair
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getKvpairAccess().getGroup()); }
(rule__Kvpair__Group__0)
{ after(grammarAccess.getKvpairAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__Signal__NameAlternatives_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getNameAlphaTerminalRuleCall_0_0_0()); }
	RULE_ALPHA
{ after(grammarAccess.getSignalAccess().getNameAlphaTerminalRuleCall_0_0_0()); }
)

    |(
{ before(grammarAccess.getSignalAccess().getNameAlphaNumTerminalRuleCall_0_0_1()); }
	RULE_ALPHANUM
{ after(grammarAccess.getSignalAccess().getNameAlphaNumTerminalRuleCall_0_0_1()); }
)

    |(
{ before(grammarAccess.getSignalAccess().getNameAlphaNumSpecialTerminalRuleCall_0_0_2()); }
	RULE_ALPHANUMSPECIAL
{ after(grammarAccess.getSignalAccess().getNameAlphaNumSpecialTerminalRuleCall_0_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Kvpair__KAlternatives_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKvpairAccess().getKAlphaTerminalRuleCall_1_0_0()); }
	RULE_ALPHA
{ after(grammarAccess.getKvpairAccess().getKAlphaTerminalRuleCall_1_0_0()); }
)

    |(
{ before(grammarAccess.getKvpairAccess().getKAlphaNumTerminalRuleCall_1_0_1()); }
	RULE_ALPHANUM
{ after(grammarAccess.getKvpairAccess().getKAlphaNumTerminalRuleCall_1_0_1()); }
)

    |(
{ before(grammarAccess.getKvpairAccess().getKAlphaNumSpecialTerminalRuleCall_1_0_2()); }
	RULE_ALPHANUMSPECIAL
{ after(grammarAccess.getKvpairAccess().getKAlphaNumSpecialTerminalRuleCall_1_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Kvpair__ValAlternatives_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKvpairAccess().getValAlphaTerminalRuleCall_3_0_0()); }
	RULE_ALPHA
{ after(grammarAccess.getKvpairAccess().getValAlphaTerminalRuleCall_3_0_0()); }
)

    |(
{ before(grammarAccess.getKvpairAccess().getValAlphaNumTerminalRuleCall_3_0_1()); }
	RULE_ALPHANUM
{ after(grammarAccess.getKvpairAccess().getValAlphaNumTerminalRuleCall_3_0_1()); }
)

    |(
{ before(grammarAccess.getKvpairAccess().getValAlphaNumSpecialTerminalRuleCall_3_0_2()); }
	RULE_ALPHANUMSPECIAL
{ after(grammarAccess.getKvpairAccess().getValAlphaNumSpecialTerminalRuleCall_3_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__Trace__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Trace__Group__0__Impl
	rule__Trace__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Trace__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getExclamationMarkKeyword_0()); }

	'!' 

{ after(grammarAccess.getTraceAccess().getExclamationMarkKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Trace__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Trace__Group__1__Impl
	rule__Trace__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Trace__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getResetKeyword_1()); }

	'reset' 

{ after(grammarAccess.getTraceAccess().getResetKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Trace__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Trace__Group__2__Impl
	rule__Trace__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Trace__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getSemicolonKeyword_2()); }

	';' 

{ after(grammarAccess.getTraceAccess().getSemicolonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Trace__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Trace__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Trace__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getTraceAccess().getTicksAssignment_3()); }
(rule__Trace__TicksAssignment_3)
{ after(grammarAccess.getTraceAccess().getTicksAssignment_3()); }
)
(
{ before(grammarAccess.getTraceAccess().getTicksAssignment_3()); }
(rule__Trace__TicksAssignment_3)*
{ after(grammarAccess.getTraceAccess().getTicksAssignment_3()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}










rule__Tick__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Tick__Group__0__Impl
	rule__Tick__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getTickAction_0()); }
(

)
{ after(grammarAccess.getTickAccess().getTickAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Tick__Group__1__Impl
	rule__Tick__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getInputAssignment_1()); }
(rule__Tick__InputAssignment_1)*
{ after(grammarAccess.getTickAccess().getInputAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Tick__Group__2__Impl
	rule__Tick__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getGroup_2()); }
(rule__Tick__Group_2__0)?
{ after(grammarAccess.getTickAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Tick__Group__3__Impl
	rule__Tick__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getExtraInfosAssignment_3()); }
(rule__Tick__ExtraInfosAssignment_3)*
{ after(grammarAccess.getTickAccess().getExtraInfosAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Tick__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getSemicolonKeyword_4()); }

	';' 

{ after(grammarAccess.getTickAccess().getSemicolonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__Tick__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Tick__Group_2__0__Impl
	rule__Tick__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getPercentSignKeyword_2_0()); }

	'%' 

{ after(grammarAccess.getTickAccess().getPercentSignKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Tick__Group_2__1__Impl
	rule__Tick__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getOutputKeyword_2_1()); }

	'Output' 

{ after(grammarAccess.getTickAccess().getOutputKeyword_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Tick__Group_2__2__Impl
	rule__Tick__Group_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getColonKeyword_2_2()); }

	':' 

{ after(grammarAccess.getTickAccess().getColonKeyword_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Tick__Group_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__Group_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getOutputAssignment_2_3()); }
(rule__Tick__OutputAssignment_2_3)*
{ after(grammarAccess.getTickAccess().getOutputAssignment_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__Signal__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Signal__Group__0__Impl
	rule__Signal__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getNameAssignment_0()); }
(rule__Signal__NameAssignment_0)
{ after(grammarAccess.getSignalAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Signal__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Signal__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getGroup_1()); }
(rule__Signal__Group_1__0)?
{ after(grammarAccess.getSignalAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Signal__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Signal__Group_1__0__Impl
	rule__Signal__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getValuedAssignment_1_0()); }
(rule__Signal__ValuedAssignment_1_0)
{ after(grammarAccess.getSignalAccess().getValuedAssignment_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Signal__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Signal__Group_1__1__Impl
	rule__Signal__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getValAssignment_1_1()); }
(rule__Signal__ValAssignment_1_1)
{ after(grammarAccess.getSignalAccess().getValAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Signal__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Signal__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getRightParenthesisKeyword_1_2()); }

	')' 

{ after(grammarAccess.getSignalAccess().getRightParenthesisKeyword_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Kvpair__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Kvpair__Group__0__Impl
	rule__Kvpair__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Kvpair__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKvpairAccess().getPercentSignPercentSignKeyword_0()); }

	'%%' 

{ after(grammarAccess.getKvpairAccess().getPercentSignPercentSignKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Kvpair__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Kvpair__Group__1__Impl
	rule__Kvpair__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Kvpair__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKvpairAccess().getKAssignment_1()); }
(rule__Kvpair__KAssignment_1)
{ after(grammarAccess.getKvpairAccess().getKAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Kvpair__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Kvpair__Group__2__Impl
	rule__Kvpair__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Kvpair__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKvpairAccess().getColonKeyword_2()); }

	':' 

{ after(grammarAccess.getKvpairAccess().getColonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Kvpair__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Kvpair__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Kvpair__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKvpairAccess().getValAssignment_3()); }
(rule__Kvpair__ValAssignment_3)
{ after(grammarAccess.getKvpairAccess().getValAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}











rule__Tracelist__TracesAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTracelistAccess().getTracesTraceParserRuleCall_0()); }
	ruletrace{ after(grammarAccess.getTracelistAccess().getTracesTraceParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Trace__TicksAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getTicksTickParserRuleCall_3_0()); }
	ruletick{ after(grammarAccess.getTraceAccess().getTicksTickParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__InputAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getInputSignalParserRuleCall_1_0()); }
	rulesignal{ after(grammarAccess.getTickAccess().getInputSignalParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__OutputAssignment_2_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getOutputSignalParserRuleCall_2_3_0()); }
	rulesignal{ after(grammarAccess.getTickAccess().getOutputSignalParserRuleCall_2_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__ExtraInfosAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getExtraInfosKvpairParserRuleCall_3_0()); }
	rulekvpair{ after(grammarAccess.getTickAccess().getExtraInfosKvpairParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getNameAlternatives_0_0()); }
(rule__Signal__NameAlternatives_0_0)
{ after(grammarAccess.getSignalAccess().getNameAlternatives_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__ValuedAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0_0()); }
(
{ before(grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0_0()); }

	'(' 

{ after(grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0_0()); }
)

{ after(grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__ValAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getValNumTerminalRuleCall_1_1_0()); }
	RULE_NUM{ after(grammarAccess.getSignalAccess().getValNumTerminalRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Kvpair__KAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKvpairAccess().getKAlternatives_1_0()); }
(rule__Kvpair__KAlternatives_1_0)
{ after(grammarAccess.getKvpairAccess().getKAlternatives_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Kvpair__ValAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKvpairAccess().getValAlternatives_3_0()); }
(rule__Kvpair__ValAlternatives_3_0)
{ after(grammarAccess.getKvpairAccess().getValAlternatives_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_ALPHA : ('a'..'z'|'A'..'Z')+;

RULE_DIGIT : '0'..'9';

RULE_NUM : ('+'|'-') ('0'..'9')+;

RULE_ALPHANUM : (RULE_ALPHA|'0'..'9')+;

RULE_SPECIAL : (','|'.'|'/'|'@'|'#'|'$'|'^'|'&'|'*'|'_'|'='|'+'|'-');

RULE_ALPHANUMSPECIAL : (RULE_ALPHA|'0'..'9'|RULE_SPECIAL)+;

RULE_COMMENT : '%' ('a'..'z'|'A'..'N'|'P'..'Z'|RULE_DIGIT|RULE_SPECIAL) ( options {greedy=false;} : . )*'\n';

RULE_WS : ('\t'|' '|'\r'|'\n');


