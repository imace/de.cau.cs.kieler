lexer grammar KIT;
@members {
	 private List<ErrorMsg> errors = new ArrayList<ErrorMsg>();
	public List<ErrorMsg> getErrors() {
		return errors;
	}

	public String getErrorMessage(RecognitionException e, String[] tokenNames) {
		String msg = super.getErrorMessage(e,tokenNames);
		errors.add(AntlrUtil.create(msg,e,tokenNames));
		return msg;
	}
}
@header {
package de.cau.cs.kieler.ssm2.kit.parser;

import org.openarchitectureware.xtext.parser.ErrorMsg;
import org.openarchitectureware.xtext.parser.impl.AntlrUtil;

}

T10 : 'statechart' ;
T11 : '[' ;
T12 : ']' ;
T13 : '{' ;
T14 : '}' ;
T15 : ';' ;
T16 : 'model' ;
T17 : '=' ;
T18 : 'version' ;
T19 : ':' ;
T20 : 'input' ;
T21 : 'output' ;
T22 : 'boolean' ;
T23 : 'double' ;
T24 : 'float' ;
T25 : 'integer' ;
T26 : 'label' ;
T27 : 'type' ;
T28 : 'final' ;
T29 : 'initial' ;
T30 : 'pseudo' ;
T31 : '||' ;
T32 : '->' ;
T33 : 'priority' ;
T34 : 'weakAbortion' ;
T35 : 'wa' ;
T36 : 'strongAbortion' ;
T37 : 'sa' ;
T38 : 'normalTermination' ;
T39 : 'nt' ;
T40 : '/' ;
T41 : '(' ;
T42 : ')' ;
T43 : 'I' ;
T44 : 'O' ;
T45 : 'L' ;
T46 : 'EQ' ;
T47 : 'LT' ;
T48 : 'LEQ' ;
T49 : 'AND' ;
T50 : 'OR' ;
T51 : 'ADD' ;
T52 : 'SUB' ;
T53 : 'MULT' ;
T54 : 'DIV' ;

// $ANTLR src "..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g" 1300
RULE_ID :

	 ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
	 
;

// $ANTLR src "..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g" 1306
RULE_STRING :

	 '\"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\"') )* '\"' |
	 '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\''
	 
;

// $ANTLR src "..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g" 1313
RULE_INT :

	 ('-')?('0'..'9')+
	 
;

// $ANTLR src "..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g" 1319
RULE_WS :

	 (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;}
	 
;

// $ANTLR src "..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g" 1325
RULE_ML_COMMENT :

	 '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
	 
;

// $ANTLR src "..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g" 1331
RULE_SL_COMMENT :

	 '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
	 
;

