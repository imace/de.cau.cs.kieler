lexer grammar InternalRif;
@header {
package de.cau.cs.kieler.krep.editors.rif.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'bool' ;
T12 : 'int' ;
T13 : '@#' ;
T14 : ':' ;
T15 : '#step' ;
T16 : '#outs' ;
T17 : '#locs' ;
T18 : 'The' ;
T19 : 'execution' ;
T20 : 'lasted' ;
T21 : '.' ;
T22 : 'second.' ;
T23 : 'T' ;
T24 : 'F' ;

// $ANTLR src "../de.cau.cs.kieler.krep.editors.rif.ui/src-gen/de/cau/cs/kieler/krep/editors/rif/ui/contentassist/antlr/internal/InternalRif.g" 1426
RULE_INT : '-'? ('0'..'9')+;

// $ANTLR src "../de.cau.cs.kieler.krep.editors.rif.ui/src-gen/de/cau/cs/kieler/krep/editors/rif/ui/contentassist/antlr/internal/InternalRif.g" 1428
RULE_INPUTS : '#@inputs';

// $ANTLR src "../de.cau.cs.kieler.krep.editors.rif.ui/src-gen/de/cau/cs/kieler/krep/editors/rif/ui/contentassist/antlr/internal/InternalRif.g" 1430
RULE_OUTPUTS : '#@outputs';

// $ANTLR src "../de.cau.cs.kieler.krep.editors.rif.ui/src-gen/de/cau/cs/kieler/krep/editors/rif/ui/contentassist/antlr/internal/InternalRif.g" 1432
RULE_LOCALS : '#@locals';

// $ANTLR src "../de.cau.cs.kieler.krep.editors.rif.ui/src-gen/de/cau/cs/kieler/krep/editors/rif/ui/contentassist/antlr/internal/InternalRif.g" 1434
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../de.cau.cs.kieler.krep.editors.rif.ui/src-gen/de/cau/cs/kieler/krep/editors/rif/ui/contentassist/antlr/internal/InternalRif.g" 1436
RULE_WS : ('\t'|' '|'\r'|'\n');

// $ANTLR src "../de.cau.cs.kieler.krep.editors.rif.ui/src-gen/de/cau/cs/kieler/krep/editors/rif/ui/contentassist/antlr/internal/InternalRif.g" 1438
RULE_COMMENT : '# ' ( options {greedy=false;} : . )*'\n';


