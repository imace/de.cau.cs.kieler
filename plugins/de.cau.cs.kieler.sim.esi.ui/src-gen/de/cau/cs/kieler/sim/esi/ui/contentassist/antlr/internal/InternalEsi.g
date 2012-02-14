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



// Entry rule entryRuleEsoInt
entryRuleEsoInt 
:
{ before(grammarAccess.getEsoIntRule()); }
	 ruleEsoInt
{ after(grammarAccess.getEsoIntRule()); } 
	 EOF 
;

// Rule EsoInt
ruleEsoInt
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEsoIntAccess().getValueAssignment()); }
(rule__EsoInt__ValueAssignment)
{ after(grammarAccess.getEsoIntAccess().getValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEsoString
entryRuleEsoString 
:
{ before(grammarAccess.getEsoStringRule()); }
	 ruleEsoString
{ after(grammarAccess.getEsoStringRule()); } 
	 EOF 
;

// Rule EsoString
ruleEsoString
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEsoStringAccess().getValueAssignment()); }
(rule__EsoString__ValueAssignment)
{ after(grammarAccess.getEsoStringAccess().getValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEsoFloat
entryRuleEsoFloat 
:
{ before(grammarAccess.getEsoFloatRule()); }
	 ruleEsoFloat
{ after(grammarAccess.getEsoFloatRule()); } 
	 EOF 
;

// Rule EsoFloat
ruleEsoFloat
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEsoFloatAccess().getValueAssignment()); }
(rule__EsoFloat__ValueAssignment)
{ after(grammarAccess.getEsoFloatAccess().getValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEsoBool
entryRuleEsoBool 
:
{ before(grammarAccess.getEsoBoolRule()); }
	 ruleEsoBool
{ after(grammarAccess.getEsoBoolRule()); } 
	 EOF 
;

// Rule EsoBool
ruleEsoBool
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEsoBoolAccess().getValueAssignment()); }
(rule__EsoBool__ValueAssignment)
{ after(grammarAccess.getEsoBoolAccess().getValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEsoJson
entryRuleEsoJson 
:
{ before(grammarAccess.getEsoJsonRule()); }
	 ruleEsoJson
{ after(grammarAccess.getEsoJsonRule()); } 
	 EOF 
;

// Rule EsoJson
ruleEsoJson
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEsoJsonAccess().getValueAssignment()); }
(rule__EsoJson__ValueAssignment)
{ after(grammarAccess.getEsoJsonAccess().getValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__Signal__ValAlternatives_2_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getValEsoIntParserRuleCall_2_0_0_0()); }
	ruleEsoInt
{ after(grammarAccess.getSignalAccess().getValEsoIntParserRuleCall_2_0_0_0()); }
)

    |(
{ before(grammarAccess.getSignalAccess().getValEsoFloatParserRuleCall_2_0_0_1()); }
	ruleEsoFloat
{ after(grammarAccess.getSignalAccess().getValEsoFloatParserRuleCall_2_0_0_1()); }
)

    |(
{ before(grammarAccess.getSignalAccess().getValEsoBoolParserRuleCall_2_0_0_2()); }
	ruleEsoBool
{ after(grammarAccess.getSignalAccess().getValEsoBoolParserRuleCall_2_0_0_2()); }
)

    |(
{ before(grammarAccess.getSignalAccess().getValEsoStringParserRuleCall_2_0_0_3()); }
	ruleEsoString
{ after(grammarAccess.getSignalAccess().getValEsoStringParserRuleCall_2_0_0_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Kvpair__ValueAlternatives_4_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKvpairAccess().getValueEsoJsonParserRuleCall_4_0_0()); }
	ruleEsoJson
{ after(grammarAccess.getKvpairAccess().getValueEsoJsonParserRuleCall_4_0_0()); }
)

    |(
{ before(grammarAccess.getKvpairAccess().getValueEsoStringParserRuleCall_4_0_1()); }
	ruleEsoString
{ after(grammarAccess.getKvpairAccess().getValueEsoStringParserRuleCall_4_0_1()); }
)

    |(
{ before(grammarAccess.getKvpairAccess().getValueEsoFloatParserRuleCall_4_0_2()); }
	ruleEsoFloat
{ after(grammarAccess.getKvpairAccess().getValueEsoFloatParserRuleCall_4_0_2()); }
)

    |(
{ before(grammarAccess.getKvpairAccess().getValueEsoBoolParserRuleCall_4_0_3()); }
	ruleEsoBool
{ after(grammarAccess.getKvpairAccess().getValueEsoBoolParserRuleCall_4_0_3()); }
)

    |(
{ before(grammarAccess.getKvpairAccess().getValueEsoIntParserRuleCall_4_0_4()); }
	ruleEsoInt
{ after(grammarAccess.getKvpairAccess().getValueEsoIntParserRuleCall_4_0_4()); }
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
	rule__Signal__Group__2
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
{ before(grammarAccess.getSignalAccess().getValuedAssignment_1()); }
(rule__Signal__ValuedAssignment_1)?
{ after(grammarAccess.getSignalAccess().getValuedAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Signal__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Signal__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getGroup_2()); }
(rule__Signal__Group_2__0)?
{ after(grammarAccess.getSignalAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Signal__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Signal__Group_2__0__Impl
	rule__Signal__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getValAssignment_2_0()); }
(rule__Signal__ValAssignment_2_0)
{ after(grammarAccess.getSignalAccess().getValAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Signal__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Signal__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getRightParenthesisKeyword_2_1()); }

	')' 

{ after(grammarAccess.getSignalAccess().getRightParenthesisKeyword_2_1()); }
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
{ before(grammarAccess.getKvpairAccess().getKvpairAction_0()); }
(

)
{ after(grammarAccess.getKvpairAccess().getKvpairAction_0()); }
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
{ before(grammarAccess.getKvpairAccess().getPercentSignPercentSignKeyword_1()); }

	'%%' 

{ after(grammarAccess.getKvpairAccess().getPercentSignPercentSignKeyword_1()); }
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
{ before(grammarAccess.getKvpairAccess().getKeyAssignment_2()); }
(rule__Kvpair__KeyAssignment_2)
{ after(grammarAccess.getKvpairAccess().getKeyAssignment_2()); }
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
	rule__Kvpair__Group__4
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
{ before(grammarAccess.getKvpairAccess().getColonKeyword_3()); }

	':' 

{ after(grammarAccess.getKvpairAccess().getColonKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Kvpair__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Kvpair__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Kvpair__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKvpairAccess().getValueAssignment_4()); }
(rule__Kvpair__ValueAssignment_4)
{ after(grammarAccess.getKvpairAccess().getValueAssignment_4()); }
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
{ before(grammarAccess.getSignalAccess().getNameAlphaNumSpecialTerminalRuleCall_0_0()); }
	RULE_ALPHANUMSPECIAL{ after(grammarAccess.getSignalAccess().getNameAlphaNumSpecialTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__ValuedAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0()); }
(
{ before(grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0()); }

	'(' 

{ after(grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0()); }
)

{ after(grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Signal__ValAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getValAlternatives_2_0_0()); }
(rule__Signal__ValAlternatives_2_0_0)
{ after(grammarAccess.getSignalAccess().getValAlternatives_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Kvpair__KeyAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKvpairAccess().getKeyAlphaNumSpecialTerminalRuleCall_2_0()); }
	RULE_ALPHANUMSPECIAL{ after(grammarAccess.getKvpairAccess().getKeyAlphaNumSpecialTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Kvpair__ValueAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKvpairAccess().getValueAlternatives_4_0()); }
(rule__Kvpair__ValueAlternatives_4_0)
{ after(grammarAccess.getKvpairAccess().getValueAlternatives_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EsoInt__ValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEsoIntAccess().getValueINTTerminalRuleCall_0()); }
	RULE_INT{ after(grammarAccess.getEsoIntAccess().getValueINTTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EsoString__ValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEsoStringAccess().getValueSTRINGTerminalRuleCall_0()); }
	RULE_STRING{ after(grammarAccess.getEsoStringAccess().getValueSTRINGTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EsoFloat__ValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEsoFloatAccess().getValueFLOATTerminalRuleCall_0()); }
	RULE_FLOAT{ after(grammarAccess.getEsoFloatAccess().getValueFLOATTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EsoBool__ValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEsoBoolAccess().getValueBOOLTerminalRuleCall_0()); }
	RULE_BOOL{ after(grammarAccess.getEsoBoolAccess().getValueBOOLTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EsoJson__ValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEsoJsonAccess().getValueAlphaNumSpecialTerminalRuleCall_0()); }
	RULE_ALPHANUMSPECIAL{ after(grammarAccess.getEsoJsonAccess().getValueAlphaNumSpecialTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_SPECIAL : (','|'.'|'/'|'@'|'#'|'$'|'&'|'*'|'='|'+'|'-');

RULE_BOOL : ('true'|'false');

RULE_ALPHANUMSPECIAL : ('a'..'z'|'A'..'Z'|RULE_SPECIAL) ('a'..'z'|'A'..'Z'|'0'..'9'|RULE_SPECIAL)*;

RULE_FLOAT : ('+'|'-')? ('0'..'9')+ '.' ('0'..'9')+;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_WS : (' '|'\t'|'\r'|'\n')+;


