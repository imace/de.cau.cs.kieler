lexer grammar InternalRetypingSynccharts;
@header {
package de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'NORMAL' ;
T12 : 'cond' ;
T13 : 'reference' ;
T14 : 'textual' ;
T15 : 'state' ;
T16 : '{' ;
T17 : '}' ;
T18 : 'oninner' ;
T19 : 'onentry' ;
T20 : 'onexit' ;
T21 : 'init' ;
T22 : 'final' ;

// $ANTLR src "../de.cau.cs.kieler.synccharts.dsl.rtsys.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalRetypingSynccharts.g" 2072
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../de.cau.cs.kieler.synccharts.dsl.rtsys.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalRetypingSynccharts.g" 2074
RULE_INT : ('0'..'9')+;

// $ANTLR src "../de.cau.cs.kieler.synccharts.dsl.rtsys.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalRetypingSynccharts.g" 2076
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../de.cau.cs.kieler.synccharts.dsl.rtsys.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalRetypingSynccharts.g" 2078
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../de.cau.cs.kieler.synccharts.dsl.rtsys.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalRetypingSynccharts.g" 2080
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../de.cau.cs.kieler.synccharts.dsl.rtsys.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalRetypingSynccharts.g" 2082
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../de.cau.cs.kieler.synccharts.dsl.rtsys.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalRetypingSynccharts.g" 2084
RULE_ANY_OTHER : .;


