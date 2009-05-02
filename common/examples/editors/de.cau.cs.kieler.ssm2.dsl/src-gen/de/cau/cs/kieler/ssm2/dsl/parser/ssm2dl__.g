lexer grammar ssm2dl;
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
package de.cau.cs.kieler.ssm2.dsl.parser;

import org.openarchitectureware.xtext.parser.ErrorMsg;
import org.openarchitectureware.xtext.parser.impl.AntlrUtil;

}

T10 : '/' ;
T11 : '(' ;
T12 : ')' ;
T13 : '=' ;
T14 : 'not' ;
T15 : '<' ;
T16 : '<=' ;
T17 : 'and' ;
T18 : 'or' ;
T19 : '+' ;
T20 : '-' ;
T21 : '*' ;
T22 : '?' ;

// $ANTLR src "..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g" 522
RULE_ID :

	 ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
	 
;

// $ANTLR src "..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g" 528
RULE_STRING :

	 '\"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\"') )* '\"' |
	 '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\''
	 
;

// $ANTLR src "..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g" 535
RULE_INT :

	 ('-')?('0'..'9')+
	 
;

// $ANTLR src "..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g" 541
RULE_WS :

	 (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;}
	 
;

// $ANTLR src "..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g" 547
RULE_ML_COMMENT :

	 '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
	 
;

// $ANTLR src "..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g" 553
RULE_SL_COMMENT :

	 '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
	 
;

