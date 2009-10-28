lexer grammar InternalMyDsl;
@header {
package org.xtext.example.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'import' ;
T12 : 'type' ;
T13 : 'entity' ;
T14 : '{' ;
T15 : '}' ;
T16 : 'extends' ;
T17 : 'property' ;
T18 : ':' ;
T19 : '[]' ;

// $ANTLR src "../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g" 803
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g" 805
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g" 807
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g" 809
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g" 811
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g" 813
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g" 815
RULE_ANY_OTHER : .;


