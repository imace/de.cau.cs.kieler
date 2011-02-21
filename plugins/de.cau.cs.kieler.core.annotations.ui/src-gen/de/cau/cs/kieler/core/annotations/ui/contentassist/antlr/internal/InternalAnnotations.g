/*
* generated by Xtext
*/
grammar InternalAnnotations;

options {
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;
	
}

@lexer::header {
package de.cau.cs.kieler.core.annotations.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package de.cau.cs.kieler.core.annotations.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import de.cau.cs.kieler.core.annotations.services.AnnotationsGrammarAccess;

}

@parser::members {
 
 	private AnnotationsGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(AnnotationsGrammarAccess grammarAccess) {
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




// Entry rule entryRuleAnnotation
entryRuleAnnotation 
:
{ before(grammarAccess.getAnnotationRule()); }
	 ruleAnnotation
{ after(grammarAccess.getAnnotationRule()); } 
	 EOF 
;

// Rule Annotation
ruleAnnotation
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAnnotationAccess().getAlternatives()); }
(rule__Annotation__Alternatives)
{ after(grammarAccess.getAnnotationAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCommentAnnotation
entryRuleCommentAnnotation 
:
{ before(grammarAccess.getCommentAnnotationRule()); }
	 ruleCommentAnnotation
{ after(grammarAccess.getCommentAnnotationRule()); } 
	 EOF 
;

// Rule CommentAnnotation
ruleCommentAnnotation
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCommentAnnotationAccess().getValueAssignment()); }
(rule__CommentAnnotation__ValueAssignment)
{ after(grammarAccess.getCommentAnnotationAccess().getValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTagAnnotation
entryRuleTagAnnotation 
:
{ before(grammarAccess.getTagAnnotationRule()); }
	 ruleTagAnnotation
{ after(grammarAccess.getTagAnnotationRule()); } 
	 EOF 
;

// Rule TagAnnotation
ruleTagAnnotation
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTagAnnotationAccess().getGroup()); }
(rule__TagAnnotation__Group__0)
{ after(grammarAccess.getTagAnnotationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleKeyStringValueAnnotation
entryRuleKeyStringValueAnnotation 
:
{ before(grammarAccess.getKeyStringValueAnnotationRule()); }
	 ruleKeyStringValueAnnotation
{ after(grammarAccess.getKeyStringValueAnnotationRule()); } 
	 EOF 
;

// Rule KeyStringValueAnnotation
ruleKeyStringValueAnnotation
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getKeyStringValueAnnotationAccess().getGroup()); }
(rule__KeyStringValueAnnotation__Group__0)
{ after(grammarAccess.getKeyStringValueAnnotationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleKeyBooleanValueAnnotation
entryRuleKeyBooleanValueAnnotation 
:
{ before(grammarAccess.getKeyBooleanValueAnnotationRule()); }
	 ruleKeyBooleanValueAnnotation
{ after(grammarAccess.getKeyBooleanValueAnnotationRule()); } 
	 EOF 
;

// Rule KeyBooleanValueAnnotation
ruleKeyBooleanValueAnnotation
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getKeyBooleanValueAnnotationAccess().getGroup()); }
(rule__KeyBooleanValueAnnotation__Group__0)
{ after(grammarAccess.getKeyBooleanValueAnnotationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleKeyIntValueAnnotation
entryRuleKeyIntValueAnnotation 
:
{ before(grammarAccess.getKeyIntValueAnnotationRule()); }
	 ruleKeyIntValueAnnotation
{ after(grammarAccess.getKeyIntValueAnnotationRule()); } 
	 EOF 
;

// Rule KeyIntValueAnnotation
ruleKeyIntValueAnnotation
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getKeyIntValueAnnotationAccess().getGroup()); }
(rule__KeyIntValueAnnotation__Group__0)
{ after(grammarAccess.getKeyIntValueAnnotationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleKeyFloatValueAnnotation
entryRuleKeyFloatValueAnnotation 
:
{ before(grammarAccess.getKeyFloatValueAnnotationRule()); }
	 ruleKeyFloatValueAnnotation
{ after(grammarAccess.getKeyFloatValueAnnotationRule()); } 
	 EOF 
;

// Rule KeyFloatValueAnnotation
ruleKeyFloatValueAnnotation
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getKeyFloatValueAnnotationAccess().getGroup()); }
(rule__KeyFloatValueAnnotation__Group__0)
{ after(grammarAccess.getKeyFloatValueAnnotationAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}





// Entry rule entryRuleEString
entryRuleEString 
:
{ before(grammarAccess.getEStringRule()); }
	 ruleEString
{ after(grammarAccess.getEStringRule()); } 
	 EOF 
;

// Rule EString
ruleEString
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEStringAccess().getAlternatives()); }
(rule__EString__Alternatives)
{ after(grammarAccess.getEStringAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__Annotation__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAnnotationAccess().getCommentAnnotationParserRuleCall_0()); }
	ruleCommentAnnotation
{ after(grammarAccess.getAnnotationAccess().getCommentAnnotationParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getAnnotationAccess().getTagAnnotationParserRuleCall_1()); }
	ruleTagAnnotation
{ after(grammarAccess.getAnnotationAccess().getTagAnnotationParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getAnnotationAccess().getKeyStringValueAnnotationParserRuleCall_2()); }
	ruleKeyStringValueAnnotation
{ after(grammarAccess.getAnnotationAccess().getKeyStringValueAnnotationParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getAnnotationAccess().getKeyBooleanValueAnnotationParserRuleCall_3()); }
	ruleKeyBooleanValueAnnotation
{ after(grammarAccess.getAnnotationAccess().getKeyBooleanValueAnnotationParserRuleCall_3()); }
)

    |(
{ before(grammarAccess.getAnnotationAccess().getKeyIntValueAnnotationParserRuleCall_4()); }
	ruleKeyIntValueAnnotation
{ after(grammarAccess.getAnnotationAccess().getKeyIntValueAnnotationParserRuleCall_4()); }
)

    |(
{ before(grammarAccess.getAnnotationAccess().getKeyFloatValueAnnotationParserRuleCall_5()); }
	ruleKeyFloatValueAnnotation
{ after(grammarAccess.getAnnotationAccess().getKeyFloatValueAnnotationParserRuleCall_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EString__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); }
	RULE_STRING
{ after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); }
)

    |(
{ before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); }
	RULE_ID
{ after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__TagAnnotation__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TagAnnotation__Group__0__Impl
	rule__TagAnnotation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TagAnnotation__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTagAnnotationAccess().getCommercialAtKeyword_0()); }

	'@' 

{ after(grammarAccess.getTagAnnotationAccess().getCommercialAtKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TagAnnotation__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TagAnnotation__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TagAnnotation__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTagAnnotationAccess().getNameAssignment_1()); }
(rule__TagAnnotation__NameAssignment_1)
{ after(grammarAccess.getTagAnnotationAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__KeyStringValueAnnotation__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__KeyStringValueAnnotation__Group__0__Impl
	rule__KeyStringValueAnnotation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyStringValueAnnotation__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyStringValueAnnotationAccess().getCommercialAtKeyword_0()); }

	'@' 

{ after(grammarAccess.getKeyStringValueAnnotationAccess().getCommercialAtKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__KeyStringValueAnnotation__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__KeyStringValueAnnotation__Group__1__Impl
	rule__KeyStringValueAnnotation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyStringValueAnnotation__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyStringValueAnnotationAccess().getNameAssignment_1()); }
(rule__KeyStringValueAnnotation__NameAssignment_1)
{ after(grammarAccess.getKeyStringValueAnnotationAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__KeyStringValueAnnotation__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__KeyStringValueAnnotation__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyStringValueAnnotation__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyStringValueAnnotationAccess().getValueAssignment_2()); }
(rule__KeyStringValueAnnotation__ValueAssignment_2)
{ after(grammarAccess.getKeyStringValueAnnotationAccess().getValueAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__KeyBooleanValueAnnotation__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__KeyBooleanValueAnnotation__Group__0__Impl
	rule__KeyBooleanValueAnnotation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyBooleanValueAnnotation__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyBooleanValueAnnotationAccess().getCommercialAtKeyword_0()); }

	'@' 

{ after(grammarAccess.getKeyBooleanValueAnnotationAccess().getCommercialAtKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__KeyBooleanValueAnnotation__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__KeyBooleanValueAnnotation__Group__1__Impl
	rule__KeyBooleanValueAnnotation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyBooleanValueAnnotation__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyBooleanValueAnnotationAccess().getNameAssignment_1()); }
(rule__KeyBooleanValueAnnotation__NameAssignment_1)
{ after(grammarAccess.getKeyBooleanValueAnnotationAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__KeyBooleanValueAnnotation__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__KeyBooleanValueAnnotation__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyBooleanValueAnnotation__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyBooleanValueAnnotationAccess().getValueAssignment_2()); }
(rule__KeyBooleanValueAnnotation__ValueAssignment_2)
{ after(grammarAccess.getKeyBooleanValueAnnotationAccess().getValueAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__KeyIntValueAnnotation__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__KeyIntValueAnnotation__Group__0__Impl
	rule__KeyIntValueAnnotation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyIntValueAnnotation__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyIntValueAnnotationAccess().getCommercialAtKeyword_0()); }

	'@' 

{ after(grammarAccess.getKeyIntValueAnnotationAccess().getCommercialAtKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__KeyIntValueAnnotation__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__KeyIntValueAnnotation__Group__1__Impl
	rule__KeyIntValueAnnotation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyIntValueAnnotation__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyIntValueAnnotationAccess().getNameAssignment_1()); }
(rule__KeyIntValueAnnotation__NameAssignment_1)
{ after(grammarAccess.getKeyIntValueAnnotationAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__KeyIntValueAnnotation__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__KeyIntValueAnnotation__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyIntValueAnnotation__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyIntValueAnnotationAccess().getValueAssignment_2()); }
(rule__KeyIntValueAnnotation__ValueAssignment_2)
{ after(grammarAccess.getKeyIntValueAnnotationAccess().getValueAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__KeyFloatValueAnnotation__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__KeyFloatValueAnnotation__Group__0__Impl
	rule__KeyFloatValueAnnotation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyFloatValueAnnotation__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyFloatValueAnnotationAccess().getCommercialAtKeyword_0()); }

	'@' 

{ after(grammarAccess.getKeyFloatValueAnnotationAccess().getCommercialAtKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__KeyFloatValueAnnotation__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__KeyFloatValueAnnotation__Group__1__Impl
	rule__KeyFloatValueAnnotation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyFloatValueAnnotation__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyFloatValueAnnotationAccess().getNameAssignment_1()); }
(rule__KeyFloatValueAnnotation__NameAssignment_1)
{ after(grammarAccess.getKeyFloatValueAnnotationAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__KeyFloatValueAnnotation__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__KeyFloatValueAnnotation__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__KeyFloatValueAnnotation__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyFloatValueAnnotationAccess().getValueAssignment_2()); }
(rule__KeyFloatValueAnnotation__ValueAssignment_2)
{ after(grammarAccess.getKeyFloatValueAnnotationAccess().getValueAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__CommentAnnotation__ValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCommentAnnotationAccess().getValueCOMMENT_ANNOTATIONTerminalRuleCall_0()); }
	RULE_COMMENT_ANNOTATION{ after(grammarAccess.getCommentAnnotationAccess().getValueCOMMENT_ANNOTATIONTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TagAnnotation__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTagAnnotationAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getTagAnnotationAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__KeyStringValueAnnotation__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyStringValueAnnotationAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getKeyStringValueAnnotationAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__KeyStringValueAnnotation__ValueAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyStringValueAnnotationAccess().getValueEStringParserRuleCall_2_0()); }
	ruleEString{ after(grammarAccess.getKeyStringValueAnnotationAccess().getValueEStringParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__KeyBooleanValueAnnotation__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyBooleanValueAnnotationAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getKeyBooleanValueAnnotationAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__KeyBooleanValueAnnotation__ValueAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyBooleanValueAnnotationAccess().getValueBooleanTerminalRuleCall_2_0()); }
	RULE_BOOLEAN{ after(grammarAccess.getKeyBooleanValueAnnotationAccess().getValueBooleanTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__KeyIntValueAnnotation__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyIntValueAnnotationAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getKeyIntValueAnnotationAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__KeyIntValueAnnotation__ValueAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyIntValueAnnotationAccess().getValueINTTerminalRuleCall_2_0()); }
	RULE_INT{ after(grammarAccess.getKeyIntValueAnnotationAccess().getValueINTTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__KeyFloatValueAnnotation__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyFloatValueAnnotationAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getKeyFloatValueAnnotationAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__KeyFloatValueAnnotation__ValueAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeyFloatValueAnnotationAccess().getValueFloatTerminalRuleCall_2_0()); }
	RULE_FLOAT{ after(grammarAccess.getKeyFloatValueAnnotationAccess().getValueFloatTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}



RULE_COMMENT_ANNOTATION : '/**' ( options {greedy=false;} : . )*'*/';

RULE_ML_COMMENT : '/*' ~('*') ( options {greedy=false;} : . )*'*/';

RULE_INT : '-'? ('0'..'9')+;

RULE_FLOAT : ('-'? ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)? 'f'?|'-'? ('0'..'9')+ 'f');

RULE_BOOLEAN : ('true'|'false');

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


