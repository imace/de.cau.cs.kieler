lexer grammar InternalActionLabel;
@header {
package de.cau.cs.kieler.synccharts.labelparser.ui.contentassist.antlr.internal;

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
T29 : ',' ;
T30 : '(' ;
T31 : ')' ;
T32 : ':=' ;
T33 : '#' ;

// $ANTLR src "../de.cau.cs.kieler.synccharts.labelparser.ui/src-gen/de/cau/cs/kieler/synccharts/labelparser/ui/contentassist/antlr/internal/InternalActionLabel.g" 3541
RULE_INT : '-'? ('0'..'9')+;

// $ANTLR src "../de.cau.cs.kieler.synccharts.labelparser.ui/src-gen/de/cau/cs/kieler/synccharts/labelparser/ui/contentassist/antlr/internal/InternalActionLabel.g" 3543
RULE_FLOAT : ((RULE_INT '.' RULE_INT|RULE_INT ('.' RULE_INT)? ('e'|'E') '+'? RULE_INT) 'f'?|RULE_INT 'f');

// $ANTLR src "../de.cau.cs.kieler.synccharts.labelparser.ui/src-gen/de/cau/cs/kieler/synccharts/labelparser/ui/contentassist/antlr/internal/InternalActionLabel.g" 3545
RULE_BOOLEAN : ('true'|'false');

// $ANTLR src "../de.cau.cs.kieler.synccharts.labelparser.ui/src-gen/de/cau/cs/kieler/synccharts/labelparser/ui/contentassist/antlr/internal/InternalActionLabel.g" 3547
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../de.cau.cs.kieler.synccharts.labelparser.ui/src-gen/de/cau/cs/kieler/synccharts/labelparser/ui/contentassist/antlr/internal/InternalActionLabel.g" 3549
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../de.cau.cs.kieler.synccharts.labelparser.ui/src-gen/de/cau/cs/kieler/synccharts/labelparser/ui/contentassist/antlr/internal/InternalActionLabel.g" 3551
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../de.cau.cs.kieler.synccharts.labelparser.ui/src-gen/de/cau/cs/kieler/synccharts/labelparser/ui/contentassist/antlr/internal/InternalActionLabel.g" 3553
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../de.cau.cs.kieler.synccharts.labelparser.ui/src-gen/de/cau/cs/kieler/synccharts/labelparser/ui/contentassist/antlr/internal/InternalActionLabel.g" 3555
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../de.cau.cs.kieler.synccharts.labelparser.ui/src-gen/de/cau/cs/kieler/synccharts/labelparser/ui/contentassist/antlr/internal/InternalActionLabel.g" 3557
RULE_ANY_OTHER : .;


