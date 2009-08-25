lexer grammar InternalRetypingSynccharts;
@header {
package de.cau.cs.kieler.synccharts.dsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : 'init' ;
T13 : 'final' ;
T14 : 'state' ;
T15 : '[' ;
T16 : ',' ;
T17 : ']' ;
T18 : '{' ;
T19 : 'onentry' ;
T20 : 'oninner' ;
T21 : 'onexit' ;
T22 : 'suspension' ;
T23 : '||' ;
T24 : '}' ;
T25 : '/' ;
T26 : 'region' ;
T27 : '#' ;
T28 : ';' ;
T29 : 'with ' ;
T30 : ' history' ;
T31 : ':= ' ;
T32 : ': ' ;
T33 : 'local' ;
T34 : 'input' ;
T35 : 'output' ;
T36 : 'combine' ;
T37 : 'with' ;
T38 : 'cond' ;
T39 : 'ref' ;
T40 : 'textual' ;
T41 : 'NONE' ;
T42 : '+' ;
T43 : '*' ;
T44 : 'AND' ;
T45 : 'OR' ;
T46 : 'host' ;
T47 : 'PURE' ;
T48 : 'boolean' ;
T49 : 'unsigned' ;
T50 : 'integer' ;
T51 : 'float' ;
T52 : '-->' ;
T53 : 'o->' ;
T54 : '>->' ;

// $ANTLR src "../de.cau.cs.kieler.synccharts.dsl.rtsys/src-gen/de/cau/cs/kieler/synccharts/dsl/parser/antlr/internal/InternalRetypingSynccharts.g" 3306
RULE_FULLSTATEID : (RULE_ID '@')? RULE_ID;

// $ANTLR src "../de.cau.cs.kieler.synccharts.dsl.rtsys/src-gen/de/cau/cs/kieler/synccharts/dsl/parser/antlr/internal/InternalRetypingSynccharts.g" 3308
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../de.cau.cs.kieler.synccharts.dsl.rtsys/src-gen/de/cau/cs/kieler/synccharts/dsl/parser/antlr/internal/InternalRetypingSynccharts.g" 3310
RULE_INT : ('0'..'9')+;

// $ANTLR src "../de.cau.cs.kieler.synccharts.dsl.rtsys/src-gen/de/cau/cs/kieler/synccharts/dsl/parser/antlr/internal/InternalRetypingSynccharts.g" 3312
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../de.cau.cs.kieler.synccharts.dsl.rtsys/src-gen/de/cau/cs/kieler/synccharts/dsl/parser/antlr/internal/InternalRetypingSynccharts.g" 3314
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../de.cau.cs.kieler.synccharts.dsl.rtsys/src-gen/de/cau/cs/kieler/synccharts/dsl/parser/antlr/internal/InternalRetypingSynccharts.g" 3316
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../de.cau.cs.kieler.synccharts.dsl.rtsys/src-gen/de/cau/cs/kieler/synccharts/dsl/parser/antlr/internal/InternalRetypingSynccharts.g" 3318
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../de.cau.cs.kieler.synccharts.dsl.rtsys/src-gen/de/cau/cs/kieler/synccharts/dsl/parser/antlr/internal/InternalRetypingSynccharts.g" 3320
RULE_ANY_OTHER : .;


