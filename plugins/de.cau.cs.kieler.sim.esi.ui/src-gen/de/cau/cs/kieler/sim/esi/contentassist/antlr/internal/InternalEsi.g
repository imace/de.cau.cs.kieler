/*
* generated by Xtext
*/
grammar InternalEsi;

options {
	superClass=AbstractInternalContentAssistParser;
	
}

@lexer::header {
package de.cau.cs.kieler.sim.esi.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package de.cau.cs.kieler.sim.esi.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
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
{ before(grammarAccess.getTracelistAccess().getGroup()); }
(rule__Tracelist__Group__0)
{ after(grammarAccess.getTracelistAccess().getGroup()); }
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






rule__Tracelist__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTracelistAccess().getTracesAssignment_0()); }
(rule__Tracelist__TracesAssignment_0)?
{ after(grammarAccess.getTracelistAccess().getTracesAssignment_0()); }
)

	rule__Tracelist__Group__1
;
finally {
	restoreStackSize(stackSize);
}


rule__Tracelist__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getTracelistAccess().getGroup_1()); }
(rule__Tracelist__Group_1__0)
{ after(grammarAccess.getTracelistAccess().getGroup_1()); }
)
(
{ before(grammarAccess.getTracelistAccess().getGroup_1()); }
(rule__Tracelist__Group_1__0)*
{ after(grammarAccess.getTracelistAccess().getGroup_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Tracelist__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTracelistAccess().getExclamationMarkKeyword_1_0()); }

	'!' 

{ after(grammarAccess.getTracelistAccess().getExclamationMarkKeyword_1_0()); }
)

	rule__Tracelist__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}


rule__Tracelist__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTracelistAccess().getResetKeyword_1_1()); }

	'reset' 

{ after(grammarAccess.getTracelistAccess().getResetKeyword_1_1()); }
)

	rule__Tracelist__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}


rule__Tracelist__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTracelistAccess().getSemicolonKeyword_1_2()); }

	';' 

{ after(grammarAccess.getTracelistAccess().getSemicolonKeyword_1_2()); }
)

	rule__Tracelist__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}


rule__Tracelist__Group_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTracelistAccess().getTracesAssignment_1_3()); }
(rule__Tracelist__TracesAssignment_1_3)
{ after(grammarAccess.getTracelistAccess().getTracesAssignment_1_3()); }
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
(
{ before(grammarAccess.getTraceAccess().getTraceAction_0()); }
(

)
{ after(grammarAccess.getTraceAccess().getTraceAction_0()); }
)

	rule__Trace__Group__1
;
finally {
	restoreStackSize(stackSize);
}


rule__Trace__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getTraceAccess().getTicksAssignment_1()); }
(rule__Trace__TicksAssignment_1)
{ after(grammarAccess.getTraceAccess().getTicksAssignment_1()); }
)
(
{ before(grammarAccess.getTraceAccess().getTicksAssignment_1()); }
(rule__Trace__TicksAssignment_1)*
{ after(grammarAccess.getTraceAccess().getTicksAssignment_1()); }
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
(
{ before(grammarAccess.getTickAccess().getInputAssignment_0()); }
(rule__Tick__InputAssignment_0)*
{ after(grammarAccess.getTickAccess().getInputAssignment_0()); }
)

	rule__Tick__Group__1
;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getGroup_1()); }
(rule__Tick__Group_1__0)?
{ after(grammarAccess.getTickAccess().getGroup_1()); }
)

	rule__Tick__Group__2
;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getNAssignment_2()); }
(rule__Tick__NAssignment_2)
{ after(grammarAccess.getTickAccess().getNAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Tick__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getPercentSignKeyword_1_0()); }

	'%' 

{ after(grammarAccess.getTickAccess().getPercentSignKeyword_1_0()); }
)

	rule__Tick__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getOutputKeyword_1_1()); }

	'Output' 

{ after(grammarAccess.getTickAccess().getOutputKeyword_1_1()); }
)

	rule__Tick__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getColonKeyword_1_2()); }

	':' 

{ after(grammarAccess.getTickAccess().getColonKeyword_1_2()); }
)

	rule__Tick__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getOutputAssignment_1_3()); }
(rule__Tick__OutputAssignment_1_3)*
{ after(grammarAccess.getTickAccess().getOutputAssignment_1_3()); }
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
(
{ before(grammarAccess.getSignalAccess().getNameAssignment_0()); }
(rule__Signal__NameAssignment_0)
{ after(grammarAccess.getSignalAccess().getNameAssignment_0()); }
)

	rule__Signal__Group__1
;
finally {
	restoreStackSize(stackSize);
}


rule__Signal__Group__1
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
(
{ before(grammarAccess.getSignalAccess().getValuedAssignment_1_0()); }
(rule__Signal__ValuedAssignment_1_0)
{ after(grammarAccess.getSignalAccess().getValuedAssignment_1_0()); }
)

	rule__Signal__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}


rule__Signal__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSignalAccess().getValAssignment_1_1()); }
(rule__Signal__ValAssignment_1_1)
{ after(grammarAccess.getSignalAccess().getValAssignment_1_1()); }
)

	rule__Signal__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}


rule__Signal__Group_1__2
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








rule__Tracelist__TracesAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTracelistAccess().getTracesTraceParserRuleCall_0_0()); }
	ruletrace{ after(grammarAccess.getTracelistAccess().getTracesTraceParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Tracelist__TracesAssignment_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTracelistAccess().getTracesTraceParserRuleCall_1_3_0()); }
	ruletrace{ after(grammarAccess.getTracelistAccess().getTracesTraceParserRuleCall_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Trace__TicksAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getTicksTickParserRuleCall_1_0()); }
	ruletick{ after(grammarAccess.getTraceAccess().getTicksTickParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__InputAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getInputSignalParserRuleCall_0_0()); }
	rulesignal{ after(grammarAccess.getTickAccess().getInputSignalParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__OutputAssignment_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getOutputSignalParserRuleCall_1_3_0()); }
	rulesignal{ after(grammarAccess.getTickAccess().getOutputSignalParserRuleCall_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__NAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getNSemicolonKeyword_2_0()); }
(
{ before(grammarAccess.getTickAccess().getNSemicolonKeyword_2_0()); }

	';' 

{ after(grammarAccess.getTickAccess().getNSemicolonKeyword_2_0()); }
)

{ after(grammarAccess.getTickAccess().getNSemicolonKeyword_2_0()); }
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
{ before(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_0_0()); }
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
{ before(grammarAccess.getSignalAccess().getValNUMTerminalRuleCall_1_1_0()); }
	RULE_NUM{ after(grammarAccess.getSignalAccess().getValNUMTerminalRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_ID : (RULE_LETTER|'_') (RULE_LETTER|RULE_DIGIT|'_')*;

RULE_NUM : ('+'|'-')? RULE_DIGIT+;

RULE_WS : ('\t'|' '|'\r'|'\n');

RULE_COMMENT : '%' ('A'..'N'|'P'..'Z') ( options {greedy=false;} : . )*'\n';

RULE_DIGIT : '0'..'9';

RULE_LETTER : ('a'..'z'|'A'..'Z');


