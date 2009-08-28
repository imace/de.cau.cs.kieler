lexer grammar InternalExample;
@header {
package de.cau.cs.kieler.xtext.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

T11 : ';' ;
T12 : '(' ;
T13 : ')' ;
T14 : 'not' ;
T15 : 'and' ;
T16 : 'or' ;

// $ANTLR src "../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g" 941
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g" 943
RULE_INT : ('0'..'9')+;

// $ANTLR src "../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g" 945
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g" 947
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g" 949
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g" 951
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g" 953
RULE_ANY_OTHER : .;


