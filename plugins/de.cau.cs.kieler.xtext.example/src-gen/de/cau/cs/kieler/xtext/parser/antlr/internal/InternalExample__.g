lexer grammar InternalExample;
@header {
package de.cau.cs.kieler.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : ';' ;
T12 : 'not' ;
T13 : 'and' ;
T14 : 'or' ;
T15 : '(' ;
T16 : ')' ;

// $ANTLR src "../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g" 616
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g" 618
RULE_INT : ('0'..'9')+;

// $ANTLR src "../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g" 620
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g" 622
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g" 624
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g" 626
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g" 628
RULE_ANY_OTHER : .;


