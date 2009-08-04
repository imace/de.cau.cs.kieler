/*
* generated by Xtext
*/
grammar InternalRetypingSynccharts;

options {
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;
	
}

@lexer::header {
package de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal; 

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
import de.cau.cs.kieler.synccharts.dsl.services.RetypingSyncchartsGrammarAccess;

}

@parser::members {
 
 	private RetypingSyncchartsGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(RetypingSyncchartsGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }

}




// Entry rule entryRuleState
entryRuleState :
{ before(grammarAccess.getStateRule()); }
	 ruleState
{ after(grammarAccess.getStateRule()); } 
	 EOF 
;

// Rule State
ruleState 
    @init {
		int stackSize = keepStackSize();
    }
 :
(
{ before(grammarAccess.getStateAccess().getGroup()); }
(rule__State__Group__0)
{ after(grammarAccess.getStateAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}










// Rule StateType
ruleStateType
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateTypeAccess().getAlternatives()); }
(rule__StateType__Alternatives)
{ after(grammarAccess.getStateTypeAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__State__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialAssignment_0_0()); }
(rule__State__IsInitialAssignment_0_0)
{ after(grammarAccess.getStateAccess().getIsInitialAssignment_0_0()); }
)

    |(
{ before(grammarAccess.getStateAccess().getGroup_0_1()); }
(rule__State__Group_0_1__0)
{ after(grammarAccess.getStateAccess().getGroup_0_1()); }
)

    |(
{ before(grammarAccess.getStateAccess().getGroup_0_2()); }
(rule__State__Group_0_2__0)
{ after(grammarAccess.getStateAccess().getGroup_0_2()); }
)

    |(
{ before(grammarAccess.getStateAccess().getStateKindAssignment_0_3()); }
(rule__State__StateKindAssignment_0_3)
{ after(grammarAccess.getStateAccess().getStateKindAssignment_0_3()); }
)

    |(
{ before(grammarAccess.getStateAccess().getGroup_0_4()); }
(rule__State__Group_0_4__0)
{ after(grammarAccess.getStateAccess().getGroup_0_4()); }
)

    |(
{ before(grammarAccess.getStateAccess().getGroup_0_5()); }
(rule__State__Group_0_5__0)
{ after(grammarAccess.getStateAccess().getGroup_0_5()); }
)

    |(
{ before(grammarAccess.getStateAccess().getIsFinalAssignment_0_6()); }
(rule__State__IsFinalAssignment_0_6)
{ after(grammarAccess.getStateAccess().getIsFinalAssignment_0_6()); }
)

    |(
{ before(grammarAccess.getStateAccess().getGroup_0_7()); }
(rule__State__Group_0_7__0)
{ after(grammarAccess.getStateAccess().getGroup_0_7()); }
)

    |(
{ before(grammarAccess.getStateAccess().getGroup_0_8()); }
(rule__State__Group_0_8__0)
{ after(grammarAccess.getStateAccess().getGroup_0_8()); }
)

    |(
{ before(grammarAccess.getStateAccess().getGroup_0_9()); }
(rule__State__Group_0_9__0)
{ after(grammarAccess.getStateAccess().getGroup_0_9()); }
)

    |(
{ before(grammarAccess.getStateAccess().getGroup_0_10()); }
(rule__State__Group_0_10__0)
{ after(grammarAccess.getStateAccess().getGroup_0_10()); }
)

    |(
{ before(grammarAccess.getStateAccess().getGroup_0_11()); }
(rule__State__Group_0_11__0)
{ after(grammarAccess.getStateAccess().getGroup_0_11()); }
)

    |(
{ before(grammarAccess.getStateAccess().getGroup_0_12()); }
(rule__State__Group_0_12__0)
{ after(grammarAccess.getStateAccess().getGroup_0_12()); }
)

    |(
{ before(grammarAccess.getStateAccess().getGroup_0_13()); }
(rule__State__Group_0_13__0)
{ after(grammarAccess.getStateAccess().getGroup_0_13()); }
)

    |(
{ before(grammarAccess.getStateAccess().getGroup_0_14()); }
(rule__State__Group_0_14__0)
{ after(grammarAccess.getStateAccess().getGroup_0_14()); }
)

    |(
{ before(grammarAccess.getStateAccess().getGroup_0_15()); }
(rule__State__Group_0_15__0)
{ after(grammarAccess.getStateAccess().getGroup_0_15()); }
)

    |(
{ before(grammarAccess.getStateAccess().getGroup_0_16()); }
(rule__State__Group_0_16__0)
{ after(grammarAccess.getStateAccess().getGroup_0_16()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StateType__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateTypeAccess().getNORMALEnumLiteralDeclaration_0()); }
(	'NORMAL' 
)
{ after(grammarAccess.getStateTypeAccess().getNORMALEnumLiteralDeclaration_0()); }
)

    |(
{ before(grammarAccess.getStateTypeAccess().getPSEUDOEnumLiteralDeclaration_1()); }
(	'cond' 
)
{ after(grammarAccess.getStateTypeAccess().getPSEUDOEnumLiteralDeclaration_1()); }
)

    |(
{ before(grammarAccess.getStateTypeAccess().getREFERENCEEnumLiteralDeclaration_2()); }
(	'reference' 
)
{ after(grammarAccess.getStateTypeAccess().getREFERENCEEnumLiteralDeclaration_2()); }
)

    |(
{ before(grammarAccess.getStateTypeAccess().getTEXTUALEnumLiteralDeclaration_3()); }
(	'textual' 
)
{ after(grammarAccess.getStateTypeAccess().getTEXTUALEnumLiteralDeclaration_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__State__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getAlternatives_0()); }
(rule__State__Alternatives_0)?
{ after(grammarAccess.getStateAccess().getAlternatives_0()); }
)

	rule__State__Group__1
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKeyword_1()); }
(
	'state' 
)?
{ after(grammarAccess.getStateAccess().getStateKeyword_1()); }
)

	rule__State__Group__2
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateNameAssignment_2()); }
(rule__State__StateNameAssignment_2)?
{ after(grammarAccess.getStateAccess().getStateNameAssignment_2()); }
)

	rule__State__Group__3
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getLabelAssignment_3()); }
(rule__State__LabelAssignment_3)?
{ after(grammarAccess.getStateAccess().getLabelAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__State__Group_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialAssignment_0_1_0()); }
(rule__State__IsInitialAssignment_0_1_0)
{ after(grammarAccess.getStateAccess().getIsInitialAssignment_0_1_0()); }
)

	rule__State__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalAssignment_0_1_1()); }
(rule__State__IsFinalAssignment_0_1_1)
{ after(grammarAccess.getStateAccess().getIsFinalAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__State__Group_0_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialAssignment_0_2_0()); }
(rule__State__IsInitialAssignment_0_2_0)
{ after(grammarAccess.getStateAccess().getIsInitialAssignment_0_2_0()); }
)

	rule__State__Group_0_2__1
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindAssignment_0_2_1()); }
(rule__State__StateKindAssignment_0_2_1)
{ after(grammarAccess.getStateAccess().getStateKindAssignment_0_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__State__Group_0_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindAssignment_0_4_0()); }
(rule__State__StateKindAssignment_0_4_0)
{ after(grammarAccess.getStateAccess().getStateKindAssignment_0_4_0()); }
)

	rule__State__Group_0_4__1
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialAssignment_0_4_1()); }
(rule__State__IsInitialAssignment_0_4_1)
{ after(grammarAccess.getStateAccess().getIsInitialAssignment_0_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__State__Group_0_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindAssignment_0_5_0()); }
(rule__State__StateKindAssignment_0_5_0)
{ after(grammarAccess.getStateAccess().getStateKindAssignment_0_5_0()); }
)

	rule__State__Group_0_5__1
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalAssignment_0_5_1()); }
(rule__State__IsFinalAssignment_0_5_1)
{ after(grammarAccess.getStateAccess().getIsFinalAssignment_0_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__State__Group_0_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalAssignment_0_7_0()); }
(rule__State__IsFinalAssignment_0_7_0)
{ after(grammarAccess.getStateAccess().getIsFinalAssignment_0_7_0()); }
)

	rule__State__Group_0_7__1
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialAssignment_0_7_1()); }
(rule__State__IsInitialAssignment_0_7_1)
{ after(grammarAccess.getStateAccess().getIsInitialAssignment_0_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__State__Group_0_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalAssignment_0_8_0()); }
(rule__State__IsFinalAssignment_0_8_0)
{ after(grammarAccess.getStateAccess().getIsFinalAssignment_0_8_0()); }
)

	rule__State__Group_0_8__1
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindAssignment_0_8_1()); }
(rule__State__StateKindAssignment_0_8_1)
{ after(grammarAccess.getStateAccess().getStateKindAssignment_0_8_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__State__Group_0_9__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindAssignment_0_9_0()); }
(rule__State__StateKindAssignment_0_9_0)
{ after(grammarAccess.getStateAccess().getStateKindAssignment_0_9_0()); }
)

	rule__State__Group_0_9__1
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_9__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalAssignment_0_9_1()); }
(rule__State__IsFinalAssignment_0_9_1)
{ after(grammarAccess.getStateAccess().getIsFinalAssignment_0_9_1()); }
)

	rule__State__Group_0_9__2
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_9__2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialAssignment_0_9_2()); }
(rule__State__IsInitialAssignment_0_9_2)
{ after(grammarAccess.getStateAccess().getIsInitialAssignment_0_9_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__State__Group_0_10__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialAssignment_0_10_0()); }
(rule__State__IsInitialAssignment_0_10_0)
{ after(grammarAccess.getStateAccess().getIsInitialAssignment_0_10_0()); }
)

	rule__State__Group_0_10__1
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_10__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalAssignment_0_10_1()); }
(rule__State__IsFinalAssignment_0_10_1)
{ after(grammarAccess.getStateAccess().getIsFinalAssignment_0_10_1()); }
)

	rule__State__Group_0_10__2
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_10__2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindAssignment_0_10_2()); }
(rule__State__StateKindAssignment_0_10_2)
{ after(grammarAccess.getStateAccess().getStateKindAssignment_0_10_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__State__Group_0_11__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialAssignment_0_11_0()); }
(rule__State__IsInitialAssignment_0_11_0)
{ after(grammarAccess.getStateAccess().getIsInitialAssignment_0_11_0()); }
)

	rule__State__Group_0_11__1
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_11__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalAssignment_0_11_1()); }
(rule__State__IsFinalAssignment_0_11_1)
{ after(grammarAccess.getStateAccess().getIsFinalAssignment_0_11_1()); }
)

	rule__State__Group_0_11__2
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_11__2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindAssignment_0_11_2()); }
(rule__State__StateKindAssignment_0_11_2)
{ after(grammarAccess.getStateAccess().getStateKindAssignment_0_11_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__State__Group_0_12__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialAssignment_0_12_0()); }
(rule__State__IsInitialAssignment_0_12_0)
{ after(grammarAccess.getStateAccess().getIsInitialAssignment_0_12_0()); }
)

	rule__State__Group_0_12__1
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_12__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindAssignment_0_12_1()); }
(rule__State__StateKindAssignment_0_12_1)
{ after(grammarAccess.getStateAccess().getStateKindAssignment_0_12_1()); }
)

	rule__State__Group_0_12__2
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_12__2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalAssignment_0_12_2()); }
(rule__State__IsFinalAssignment_0_12_2)
{ after(grammarAccess.getStateAccess().getIsFinalAssignment_0_12_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__State__Group_0_13__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalAssignment_0_13_0()); }
(rule__State__IsFinalAssignment_0_13_0)
{ after(grammarAccess.getStateAccess().getIsFinalAssignment_0_13_0()); }
)

	rule__State__Group_0_13__1
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_13__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialAssignment_0_13_1()); }
(rule__State__IsInitialAssignment_0_13_1)
{ after(grammarAccess.getStateAccess().getIsInitialAssignment_0_13_1()); }
)

	rule__State__Group_0_13__2
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_13__2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindAssignment_0_13_2()); }
(rule__State__StateKindAssignment_0_13_2)
{ after(grammarAccess.getStateAccess().getStateKindAssignment_0_13_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__State__Group_0_14__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalAssignment_0_14_0()); }
(rule__State__IsFinalAssignment_0_14_0)
{ after(grammarAccess.getStateAccess().getIsFinalAssignment_0_14_0()); }
)

	rule__State__Group_0_14__1
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_14__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindAssignment_0_14_1()); }
(rule__State__StateKindAssignment_0_14_1)
{ after(grammarAccess.getStateAccess().getStateKindAssignment_0_14_1()); }
)

	rule__State__Group_0_14__2
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_14__2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialAssignment_0_14_2()); }
(rule__State__IsInitialAssignment_0_14_2)
{ after(grammarAccess.getStateAccess().getIsInitialAssignment_0_14_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__State__Group_0_15__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindAssignment_0_15_0()); }
(rule__State__StateKindAssignment_0_15_0)
{ after(grammarAccess.getStateAccess().getStateKindAssignment_0_15_0()); }
)

	rule__State__Group_0_15__1
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_15__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialAssignment_0_15_1()); }
(rule__State__IsInitialAssignment_0_15_1)
{ after(grammarAccess.getStateAccess().getIsInitialAssignment_0_15_1()); }
)

	rule__State__Group_0_15__2
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_15__2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalAssignment_0_15_2()); }
(rule__State__IsFinalAssignment_0_15_2)
{ after(grammarAccess.getStateAccess().getIsFinalAssignment_0_15_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__State__Group_0_16__0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindAssignment_0_16_0()); }
(rule__State__StateKindAssignment_0_16_0)
{ after(grammarAccess.getStateAccess().getStateKindAssignment_0_16_0()); }
)

	rule__State__Group_0_16__1
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_16__1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalAssignment_0_16_1()); }
(rule__State__IsFinalAssignment_0_16_1)
{ after(grammarAccess.getStateAccess().getIsFinalAssignment_0_16_1()); }
)

	rule__State__Group_0_16__2
;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_0_16__2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialAssignment_0_16_2()); }
(rule__State__IsInitialAssignment_0_16_2)
{ after(grammarAccess.getStateAccess().getIsInitialAssignment_0_16_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}











rule__State__IsInitialAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_0_0()); }
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_0_0()); }

	'init' 

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_0_0()); }
)

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsInitialAssignment_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_1_0_0()); }
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_1_0_0()); }

	'init' 

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_1_0_0()); }
)

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsFinalAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_1_1_0()); }
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_1_1_0()); }

	'final' 

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_1_1_0()); }
)

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsInitialAssignment_0_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_2_0_0()); }
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_2_0_0()); }

	'init' 

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_2_0_0()); }
)

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__StateKindAssignment_0_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_2_1_0()); }
	ruleStateType{ after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__StateKindAssignment_0_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_3_0()); }
	ruleStateType{ after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__StateKindAssignment_0_4_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_4_0_0()); }
	ruleStateType{ after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_4_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsInitialAssignment_0_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_4_1_0()); }
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_4_1_0()); }

	'init' 

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_4_1_0()); }
)

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__StateKindAssignment_0_5_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_5_0_0()); }
	ruleStateType{ after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsFinalAssignment_0_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_5_1_0()); }
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_5_1_0()); }

	'final' 

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_5_1_0()); }
)

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsFinalAssignment_0_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_6_0()); }
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_6_0()); }

	'final' 

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_6_0()); }
)

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsFinalAssignment_0_7_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_7_0_0()); }
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_7_0_0()); }

	'final' 

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_7_0_0()); }
)

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_7_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsInitialAssignment_0_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_7_1_0()); }
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_7_1_0()); }

	'init' 

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_7_1_0()); }
)

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsFinalAssignment_0_8_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_8_0_0()); }
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_8_0_0()); }

	'final' 

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_8_0_0()); }
)

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_8_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__StateKindAssignment_0_8_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_8_1_0()); }
	ruleStateType{ after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_8_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__StateKindAssignment_0_9_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_9_0_0()); }
	ruleStateType{ after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_9_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsFinalAssignment_0_9_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_9_1_0()); }
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_9_1_0()); }

	'final' 

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_9_1_0()); }
)

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_9_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsInitialAssignment_0_9_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_9_2_0()); }
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_9_2_0()); }

	'init' 

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_9_2_0()); }
)

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_9_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsInitialAssignment_0_10_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_10_0_0()); }
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_10_0_0()); }

	'init' 

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_10_0_0()); }
)

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_10_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsFinalAssignment_0_10_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_10_1_0()); }
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_10_1_0()); }

	'final' 

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_10_1_0()); }
)

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_10_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__StateKindAssignment_0_10_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_10_2_0()); }
	ruleStateType{ after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_10_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsInitialAssignment_0_11_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_11_0_0()); }
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_11_0_0()); }

	'init' 

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_11_0_0()); }
)

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_11_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsFinalAssignment_0_11_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_11_1_0()); }
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_11_1_0()); }

	'final' 

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_11_1_0()); }
)

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_11_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__StateKindAssignment_0_11_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_11_2_0()); }
	ruleStateType{ after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_11_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsInitialAssignment_0_12_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_12_0_0()); }
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_12_0_0()); }

	'init' 

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_12_0_0()); }
)

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_12_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__StateKindAssignment_0_12_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_12_1_0()); }
	ruleStateType{ after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_12_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsFinalAssignment_0_12_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_12_2_0()); }
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_12_2_0()); }

	'final' 

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_12_2_0()); }
)

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_12_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsFinalAssignment_0_13_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_13_0_0()); }
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_13_0_0()); }

	'final' 

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_13_0_0()); }
)

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_13_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsInitialAssignment_0_13_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_13_1_0()); }
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_13_1_0()); }

	'init' 

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_13_1_0()); }
)

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_13_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__StateKindAssignment_0_13_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_13_2_0()); }
	ruleStateType{ after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_13_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsFinalAssignment_0_14_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_14_0_0()); }
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_14_0_0()); }

	'final' 

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_14_0_0()); }
)

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_14_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__StateKindAssignment_0_14_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_14_1_0()); }
	ruleStateType{ after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_14_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsInitialAssignment_0_14_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_14_2_0()); }
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_14_2_0()); }

	'init' 

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_14_2_0()); }
)

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_14_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__StateKindAssignment_0_15_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_15_0_0()); }
	ruleStateType{ after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_15_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsInitialAssignment_0_15_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_15_1_0()); }
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_15_1_0()); }

	'init' 

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_15_1_0()); }
)

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_15_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsFinalAssignment_0_15_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_15_2_0()); }
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_15_2_0()); }

	'final' 

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_15_2_0()); }
)

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_15_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__StateKindAssignment_0_16_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_16_0_0()); }
	ruleStateType{ after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_16_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsFinalAssignment_0_16_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_16_1_0()); }
(
{ before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_16_1_0()); }

	'final' 

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_16_1_0()); }
)

{ after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_16_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IsInitialAssignment_0_16_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_16_2_0()); }
(
{ before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_16_2_0()); }

	'init' 

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_16_2_0()); }
)

{ after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_16_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__StateNameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateNameIDTerminalRuleCall_2_0()); }
	RULE_ID{ after(grammarAccess.getStateAccess().getStateNameIDTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__LabelAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getLabelSTRINGTerminalRuleCall_3_0()); }
	RULE_STRING{ after(grammarAccess.getStateAccess().getLabelSTRINGTerminalRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}





RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


