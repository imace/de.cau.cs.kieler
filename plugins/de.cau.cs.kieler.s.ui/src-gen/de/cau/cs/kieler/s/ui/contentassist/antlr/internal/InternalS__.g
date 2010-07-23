lexer grammar InternalS;
@header {
package de.cau.cs.kieler.s.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T13 : '?' ;
T14 : 'not' ;
T15 : 'pre' ;
T16 : 'or' ;
T17 : 'and' ;
T18 : '/' ;
T19 : '=' ;
T20 : '<' ;
T21 : '<=' ;
T22 : '>' ;
T23 : '>=' ;
T24 : '<>' ;
T25 : '+' ;
T26 : '-' ;
T27 : '*' ;
T28 : 'mod' ;
T29 : 'PURE' ;
T30 : 'BOOL' ;
T31 : 'UNSIGNED' ;
T32 : 'INT' ;
T33 : 'FLOAT' ;
T34 : 'HOST' ;
T35 : 'NONE' ;
T36 : 'max' ;
T37 : 'min' ;
T38 : 'host' ;
T39 : 'Synchronous Program' ;
T40 : '(' ;
T41 : ')' ;
T42 : ':' ;
T43 : 'SIGNALS' ;
T44 : ';' ;
T45 : 'signal' ;
T46 : ':=' ;
T47 : 'combine' ;
T48 : 'with' ;
T49 : 'PAUSE' ;
T50 : 'TERM' ;
T51 : 'Halt' ;
T52 : 'JOIN' ;
T53 : 'ABORT' ;
T54 : 'IF' ;
T55 : '{' ;
T56 : '}' ;
T57 : ',' ;
T58 : 'GOTO' ;
T59 : 'FORK' ;
T60 : 'FORKE' ;
T61 : 'EMIT' ;
T62 : 'AWAIT' ;
T63 : 'PRIO' ;
T64 : 'input' ;
T65 : 'output' ;

// $ANTLR src "../de.cau.cs.kieler.s.ui/src-gen/de/cau/cs/kieler/s/ui/contentassist/antlr/internal/InternalS.g" 8989
RULE_INT : '-'? ('0'..'9')+;

// $ANTLR src "../de.cau.cs.kieler.s.ui/src-gen/de/cau/cs/kieler/s/ui/contentassist/antlr/internal/InternalS.g" 8991
RULE_FLOAT : ((RULE_INT '.' RULE_INT|RULE_INT ('.' RULE_INT)? ('e'|'E') '+'? RULE_INT) 'f'?|RULE_INT 'f');

// $ANTLR src "../de.cau.cs.kieler.s.ui/src-gen/de/cau/cs/kieler/s/ui/contentassist/antlr/internal/InternalS.g" 8993
RULE_BOOLEAN : ('true'|'false');

// $ANTLR src "../de.cau.cs.kieler.s.ui/src-gen/de/cau/cs/kieler/s/ui/contentassist/antlr/internal/InternalS.g" 8995
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../de.cau.cs.kieler.s.ui/src-gen/de/cau/cs/kieler/s/ui/contentassist/antlr/internal/InternalS.g" 8997
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../de.cau.cs.kieler.s.ui/src-gen/de/cau/cs/kieler/s/ui/contentassist/antlr/internal/InternalS.g" 8999
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../de.cau.cs.kieler.s.ui/src-gen/de/cau/cs/kieler/s/ui/contentassist/antlr/internal/InternalS.g" 9001
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../de.cau.cs.kieler.s.ui/src-gen/de/cau/cs/kieler/s/ui/contentassist/antlr/internal/InternalS.g" 9003
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../de.cau.cs.kieler.s.ui/src-gen/de/cau/cs/kieler/s/ui/contentassist/antlr/internal/InternalS.g" 9005
RULE_ANY_OTHER : .;


