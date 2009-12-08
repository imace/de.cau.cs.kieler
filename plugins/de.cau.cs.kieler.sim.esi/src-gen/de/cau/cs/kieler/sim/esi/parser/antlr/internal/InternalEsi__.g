lexer grammar InternalEsi;
@header {
package de.cau.cs.kieler.sim.esi.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T10 : '!' ;
T11 : 'reset' ;
T12 : ';' ;
T13 : '%' ;
T14 : 'Output' ;
T15 : ':' ;
T16 : '(' ;
T17 : ')' ;

// $ANTLR src "../de.cau.cs.kieler.sim.esi/src-gen/de/cau/cs/kieler/sim/esi/parser/antlr/internal/InternalEsi.g" 393
RULE_ID : (RULE_LETTER|'_') (RULE_LETTER|RULE_DIGIT|'_')*;

// $ANTLR src "../de.cau.cs.kieler.sim.esi/src-gen/de/cau/cs/kieler/sim/esi/parser/antlr/internal/InternalEsi.g" 395
RULE_NUM : ('+'|'-')? RULE_DIGIT+;

// $ANTLR src "../de.cau.cs.kieler.sim.esi/src-gen/de/cau/cs/kieler/sim/esi/parser/antlr/internal/InternalEsi.g" 397
RULE_WS : ('\t'|' '|'\r'|'\n');

// $ANTLR src "../de.cau.cs.kieler.sim.esi/src-gen/de/cau/cs/kieler/sim/esi/parser/antlr/internal/InternalEsi.g" 399
RULE_COMMENT : '%' ('A'..'N'|'P'..'Z') ( options {greedy=false;} : . )*'\n';

// $ANTLR src "../de.cau.cs.kieler.sim.esi/src-gen/de/cau/cs/kieler/sim/esi/parser/antlr/internal/InternalEsi.g" 401
RULE_DIGIT : '0'..'9';

// $ANTLR src "../de.cau.cs.kieler.sim.esi/src-gen/de/cau/cs/kieler/sim/esi/parser/antlr/internal/InternalEsi.g" 403
RULE_LETTER : ('a'..'z'|'A'..'Z');


