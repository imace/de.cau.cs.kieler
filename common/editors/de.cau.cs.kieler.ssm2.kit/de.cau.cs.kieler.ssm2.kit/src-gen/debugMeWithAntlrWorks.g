grammar debugMeWithAntlrWorks;
 options{backtrack=true; memoize=true;} 



parse :
	 result=ruleStatechart
	 // Always return the root node! This prevents that this method is called multiple times
	 // with interesting side effects.
	 EOF
;

ruleStatechart 

:
(('statechart')

(RULE_ID)

(('[')

(ruleChartArgument)*

(']')
)?

('{')

(ruleIoDeclaration)*

('{')

(ruleElement)*

('}')

('}')

(';')
)
;

ruleChartArgument 

:
((('model')

('=')

(RULE_ID)

(';')
)
	|
(('version')

('=')

(RULE_ID)

(';')
)
)
;

ruleIoDeclaration 

:
((ruleDeclType)

(RULE_ID)

((':')

('=')

(RULE_INT)
)?

((':')

(ruleVType)
)?

(';')
)
;

ruleDeclType 

:
(('input')
	|
('output')
)
;

ruleVType 

:
(('boolean')
	|
('double')
	|
('float')
	|
('integer')
)
;

ruleState 

:
((RULE_ID)

(('[')

(ruleStateArgument)*

(']')
)?

(('{')

(ruleElement)*

('}')
)?

(';')
)
;

ruleStateArgument 

:
((('label')

('=')

(RULE_STRING)

(';')?
)
	|
(('type')

('=')

(rulePseudo)

(';')?
)
)
;

rulePseudo 

:
(('final')
	|
('initial')
	|
('pseudo')
)
;

ruleElement 

:
((temp_State=ruleState)
	|
(temp_Transition=ruleTransition)
	|
('||')
)
;

ruleTransition 

:
((RULE_ID)?

('->')

(RULE_ID)

(('[')

(ruleTransArgument)*

(']')
)?

(';')
)
;

ruleTransArgument 

:
((('label')

('=')

(ruleAction)

(';')?
)
	|
(('type')

('=')

(ruleTransType)

(';')?
)
	|
(('priority')

('=')

(RULE_INT)

(';')?
)
)
;

ruleTransType 
:
        temp_weakabortion=ruleweakabortion 	|        temp_strongabortion=rulestrongabortion 	|        temp_normaltermination=rulenormaltermination 	;

ruleweakabortion 

:
(('weakAbortion')
	|
('wa')
)
;

rulestrongabortion 

:
(('strongAbortion')
	|
('sa')
)
;

rulenormaltermination 

:
(('normalTermination')
	|
('nt')
)
;

ruleAction 

:
((ruleTrigger)

('/')

(ruleEmission)*
)
;

ruleEmission 

:
((ruleSignal)

(('(')

(ruleValue)

(')')
)?
)
;

ruleValue 

:
(RULE_INT)
;

ruleSignal 

:
(('I')?

('O')?

('L')?

(RULE_ID)

(('(')

(ruleValue)

(')')
)?
)
;

ruleTrigger 

:
((ruleSignal)
	|
((ruleSignal)

(ruleBinaryOp)

(ruleSignal)
)
	|
(('(')

(ruleTrigger)

(')')

(ruleBinaryOp)

('(')

(ruleTrigger)

(')')
)
)
;

ruleBinaryOp 

:
(('EQ')
	|
('LT')
	|
('LEQ')
	|
('AND')
	|
('OR')
	|
('ADD')
	|
('SUB')
	|
('MULT')
	|
('DIV')
)
;

RULE_ID :

	 ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
	 
;

RULE_STRING :

	 '\"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\"') )* '\"' |
	 '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\''
	 
;

RULE_INT :

	 ('-')?('0'..'9')+
	 
;

RULE_WS :

	 (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;}
	 
;

RULE_ML_COMMENT :

	 '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
	 
;

RULE_SL_COMMENT :

	 '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
	 
;

