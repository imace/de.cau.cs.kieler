/*
* generated by Xtext
*/
grammar InternalRif;

options {
	superClass=AbstractInternalContentAssistParser;
	
}

@lexer::header {
package de.cau.cs.kieler.krep.editors.rif.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package de.cau.cs.kieler.krep.editors.rif.contentassist.antlr.internal; 

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
import de.cau.cs.kieler.krep.editors.rif.services.RifGrammarAccess;

}

@parser::members {
 
 	private RifGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(RifGrammarAccess grammarAccess) {
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




// Entry rule entryRuleTrace
entryRuleTrace 
:
{ before(grammarAccess.getTraceRule()); }
	 ruleTrace
{ after(grammarAccess.getTraceRule()); } 
	 EOF 
;

// Rule Trace
ruleTrace 
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



// Entry rule entryRuledecl
entryRuledecl 
:
{ before(grammarAccess.getDeclRule()); }
	 ruledecl
{ after(grammarAccess.getDeclRule()); } 
	 EOF 
;

// Rule decl
ruledecl 
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDeclAccess().getGroup()); }
(rule__Decl__Group__0)
{ after(grammarAccess.getDeclAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleType
entryRuleType 
:
{ before(grammarAccess.getTypeRule()); }
	 ruleType
{ after(grammarAccess.getTypeRule()); } 
	 EOF 
;

// Rule Type
ruleType 
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeAccess().getAlternatives()); }
(rule__Type__Alternatives)
{ after(grammarAccess.getTypeAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTick
entryRuleTick 
:
{ before(grammarAccess.getTickRule()); }
	 ruleTick
{ after(grammarAccess.getTickRule()); } 
	 EOF 
;

// Rule Tick
ruleTick 
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



// Entry rule entryRuleData
entryRuleData 
:
{ before(grammarAccess.getDataRule()); }
	 ruleData
{ after(grammarAccess.getDataRule()); } 
	 EOF 
;

// Rule Data
ruleData 
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDataAccess().getAlternatives()); }
(rule__Data__Alternatives)
{ after(grammarAccess.getDataAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleStatus
entryRuleStatus 
:
{ before(grammarAccess.getStatusRule()); }
	 ruleStatus
{ after(grammarAccess.getStatusRule()); } 
	 EOF 
;

// Rule Status
ruleStatus 
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getStatusAccess().getGroup()); }
(rule__Status__Group__0)
{ after(grammarAccess.getStatusAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__Type__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeAccess().getBoolKeyword_0()); }

	'bool' 

{ after(grammarAccess.getTypeAccess().getBoolKeyword_0()); }
)

    |(
{ before(grammarAccess.getTypeAccess().getIntKeyword_1()); }

	'int' 

{ after(grammarAccess.getTypeAccess().getIntKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Data__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataAccess().getValAssignment_0()); }
(rule__Data__ValAssignment_0)
{ after(grammarAccess.getDataAccess().getValAssignment_0()); }
)

    |(
{ before(grammarAccess.getDataAccess().getTrueAssignment_1()); }
(rule__Data__TrueAssignment_1)
{ after(grammarAccess.getDataAccess().getTrueAssignment_1()); }
)

    |(
{ before(grammarAccess.getDataAccess().getFalseAssignment_2()); }
(rule__Data__FalseAssignment_2)
{ after(grammarAccess.getDataAccess().getFalseAssignment_2()); }
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
{ before(grammarAccess.getTraceAccess().getINPUTSTerminalRuleCall_0()); }
	RULE_INPUTS
{ after(grammarAccess.getTraceAccess().getINPUTSTerminalRuleCall_0()); }
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
{ before(grammarAccess.getTraceAccess().getInputsAssignment_1()); }
(rule__Trace__InputsAssignment_1)*
{ after(grammarAccess.getTraceAccess().getInputsAssignment_1()); }
)

	rule__Trace__Group__2
;
finally {
	restoreStackSize(stackSize);
}


rule__Trace__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getCommercialAtNumberSignKeyword_2()); }

	'@#' 

{ after(grammarAccess.getTraceAccess().getCommercialAtNumberSignKeyword_2()); }
)

	rule__Trace__Group__3
;
finally {
	restoreStackSize(stackSize);
}


rule__Trace__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getOUTPUTSTerminalRuleCall_3()); }
	RULE_OUTPUTS
{ after(grammarAccess.getTraceAccess().getOUTPUTSTerminalRuleCall_3()); }
)

	rule__Trace__Group__4
;
finally {
	restoreStackSize(stackSize);
}


rule__Trace__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getOutputsAssignment_4()); }
(rule__Trace__OutputsAssignment_4)*
{ after(grammarAccess.getTraceAccess().getOutputsAssignment_4()); }
)

	rule__Trace__Group__5
;
finally {
	restoreStackSize(stackSize);
}


rule__Trace__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getCommercialAtNumberSignKeyword_5()); }

	'@#' 

{ after(grammarAccess.getTraceAccess().getCommercialAtNumberSignKeyword_5()); }
)

	rule__Trace__Group__6
;
finally {
	restoreStackSize(stackSize);
}


rule__Trace__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getLOCALSTerminalRuleCall_6()); }
	RULE_LOCALS
{ after(grammarAccess.getTraceAccess().getLOCALSTerminalRuleCall_6()); }
)

	rule__Trace__Group__7
;
finally {
	restoreStackSize(stackSize);
}


rule__Trace__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getLocalAssignment_7()); }
(rule__Trace__LocalAssignment_7)*
{ after(grammarAccess.getTraceAccess().getLocalAssignment_7()); }
)

	rule__Trace__Group__8
;
finally {
	restoreStackSize(stackSize);
}


rule__Trace__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getCommercialAtNumberSignKeyword_8()); }

	'@#' 

{ after(grammarAccess.getTraceAccess().getCommercialAtNumberSignKeyword_8()); }
)

	rule__Trace__Group__9
;
finally {
	restoreStackSize(stackSize);
}


rule__Trace__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getTraceAccess().getTickAssignment_9()); }
(rule__Trace__TickAssignment_9)
{ after(grammarAccess.getTraceAccess().getTickAssignment_9()); }
)
(
{ before(grammarAccess.getTraceAccess().getTickAssignment_9()); }
(rule__Trace__TickAssignment_9)*
{ after(grammarAccess.getTraceAccess().getTickAssignment_9()); }
)
)

	rule__Trace__Group__10
;
finally {
	restoreStackSize(stackSize);
}


rule__Trace__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getStatusParserRuleCall_10()); }
(	ruleStatus)?
{ after(grammarAccess.getTraceAccess().getStatusParserRuleCall_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}
























rule__Decl__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclAccess().getNameAssignment_0()); }
(rule__Decl__NameAssignment_0)
{ after(grammarAccess.getDeclAccess().getNameAssignment_0()); }
)

	rule__Decl__Group__1
;
finally {
	restoreStackSize(stackSize);
}


rule__Decl__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclAccess().getColonKeyword_1()); }

	':' 

{ after(grammarAccess.getDeclAccess().getColonKeyword_1()); }
)

	rule__Decl__Group__2
;
finally {
	restoreStackSize(stackSize);
}


rule__Decl__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclAccess().getTypeAssignment_2()); }
(rule__Decl__TypeAssignment_2)
{ after(grammarAccess.getDeclAccess().getTypeAssignment_2()); }
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
{ before(grammarAccess.getTickAccess().getTickAction_0()); }
(

)
{ after(grammarAccess.getTickAccess().getTickAction_0()); }
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
{ before(grammarAccess.getTickAccess().getStepKeyword_1()); }

	'#step' 

{ after(grammarAccess.getTickAccess().getStepKeyword_1()); }
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
{ before(grammarAccess.getTickAccess().getNrAssignment_2()); }
(rule__Tick__NrAssignment_2)
{ after(grammarAccess.getTickAccess().getNrAssignment_2()); }
)

	rule__Tick__Group__3
;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getInputAssignment_3()); }
(rule__Tick__InputAssignment_3)*
{ after(grammarAccess.getTickAccess().getInputAssignment_3()); }
)

	rule__Tick__Group__4
;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getOutsKeyword_4()); }

	'#outs' 

{ after(grammarAccess.getTickAccess().getOutsKeyword_4()); }
)

	rule__Tick__Group__5
;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getOutputAssignment_5()); }
(rule__Tick__OutputAssignment_5)*
{ after(grammarAccess.getTickAccess().getOutputAssignment_5()); }
)

	rule__Tick__Group__6
;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getLocsKeyword_6()); }

	'#locs' 

{ after(grammarAccess.getTickAccess().getLocsKeyword_6()); }
)

	rule__Tick__Group__7
;
finally {
	restoreStackSize(stackSize);
}


rule__Tick__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getLocalAssignment_7()); }
(rule__Tick__LocalAssignment_7)*
{ after(grammarAccess.getTickAccess().getLocalAssignment_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__Status__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatusAccess().getTheKeyword_0()); }

	'The' 

{ after(grammarAccess.getStatusAccess().getTheKeyword_0()); }
)

	rule__Status__Group__1
;
finally {
	restoreStackSize(stackSize);
}


rule__Status__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatusAccess().getExecutionKeyword_1()); }

	'execution' 

{ after(grammarAccess.getStatusAccess().getExecutionKeyword_1()); }
)

	rule__Status__Group__2
;
finally {
	restoreStackSize(stackSize);
}


rule__Status__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatusAccess().getLastedKeyword_2()); }

	'lasted' 

{ after(grammarAccess.getStatusAccess().getLastedKeyword_2()); }
)

	rule__Status__Group__3
;
finally {
	restoreStackSize(stackSize);
}


rule__Status__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatusAccess().getINTTerminalRuleCall_3()); }
	RULE_INT
{ after(grammarAccess.getStatusAccess().getINTTerminalRuleCall_3()); }
)

	rule__Status__Group__4
;
finally {
	restoreStackSize(stackSize);
}


rule__Status__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatusAccess().getFullStopKeyword_4()); }

	'.' 

{ after(grammarAccess.getStatusAccess().getFullStopKeyword_4()); }
)

	rule__Status__Group__5
;
finally {
	restoreStackSize(stackSize);
}


rule__Status__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatusAccess().getINTTerminalRuleCall_5()); }
	RULE_INT
{ after(grammarAccess.getStatusAccess().getINTTerminalRuleCall_5()); }
)

	rule__Status__Group__6
;
finally {
	restoreStackSize(stackSize);
}


rule__Status__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatusAccess().getSecondKeyword_6()); }

	'second.' 

{ after(grammarAccess.getStatusAccess().getSecondKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__Trace__InputsAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getInputsDeclParserRuleCall_1_0()); }
	ruledecl{ after(grammarAccess.getTraceAccess().getInputsDeclParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Trace__OutputsAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getOutputsDeclParserRuleCall_4_0()); }
	ruledecl{ after(grammarAccess.getTraceAccess().getOutputsDeclParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Trace__LocalAssignment_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getLocalDeclParserRuleCall_7_0()); }
	ruledecl{ after(grammarAccess.getTraceAccess().getLocalDeclParserRuleCall_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Trace__TickAssignment_9
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTraceAccess().getTickTickParserRuleCall_9_0()); }
	ruleTick{ after(grammarAccess.getTraceAccess().getTickTickParserRuleCall_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Decl__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclAccess().getNameSTRINGTerminalRuleCall_0_0()); }
	RULE_STRING{ after(grammarAccess.getDeclAccess().getNameSTRINGTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Decl__TypeAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDeclAccess().getTypeTypeParserRuleCall_2_0()); }
	ruleType{ after(grammarAccess.getDeclAccess().getTypeTypeParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__NrAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getNrINTTerminalRuleCall_2_0()); }
	RULE_INT{ after(grammarAccess.getTickAccess().getNrINTTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__InputAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getInputDataParserRuleCall_3_0()); }
	ruleData{ after(grammarAccess.getTickAccess().getInputDataParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__OutputAssignment_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getOutputDataParserRuleCall_5_0()); }
	ruleData{ after(grammarAccess.getTickAccess().getOutputDataParserRuleCall_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Tick__LocalAssignment_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTickAccess().getLocalDataParserRuleCall_7_0()); }
	ruleData{ after(grammarAccess.getTickAccess().getLocalDataParserRuleCall_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Data__ValAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataAccess().getValINTTerminalRuleCall_0_0()); }
	RULE_INT{ after(grammarAccess.getDataAccess().getValINTTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Data__TrueAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataAccess().getTrueTKeyword_1_0()); }
(
{ before(grammarAccess.getDataAccess().getTrueTKeyword_1_0()); }

	'T' 

{ after(grammarAccess.getDataAccess().getTrueTKeyword_1_0()); }
)

{ after(grammarAccess.getDataAccess().getTrueTKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Data__FalseAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataAccess().getFalseFKeyword_2_0()); }
(
{ before(grammarAccess.getDataAccess().getFalseFKeyword_2_0()); }

	'F' 

{ after(grammarAccess.getDataAccess().getFalseFKeyword_2_0()); }
)

{ after(grammarAccess.getDataAccess().getFalseFKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_INPUTS : '#@inputs';

RULE_OUTPUTS : '#@outputs';

RULE_LOCALS : '#@locals';

RULE_WS : ('\t'|' '|'\r'|'\n');

RULE_COMMENT : '# ' ( options {greedy=false;} : . )*'\n';

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_ANY_OTHER : .;


