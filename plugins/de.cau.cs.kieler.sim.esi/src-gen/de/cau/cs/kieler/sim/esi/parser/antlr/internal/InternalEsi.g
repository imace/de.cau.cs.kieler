/*
* generated by Xtext
*/
grammar InternalEsi;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package de.cau.cs.kieler.sim.esi.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package de.cau.cs.kieler.sim.esi.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.cau.cs.kieler.sim.esi.services.EsiGrammarAccess;

}

@parser::members {

 	private EsiGrammarAccess grammarAccess;
 	
    public InternalEsiParser(TokenStream input, EsiGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "tracelist";	
   	}
   	
   	@Override
   	protected EsiGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuletracelist
entryRuletracelist returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTracelistRule()); }
	 iv_ruletracelist=ruletracelist 
	 { $current=$iv_ruletracelist.current; } 
	 EOF 
;

// Rule tracelist
ruletracelist returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getTracelistAccess().getTracesTraceParserRuleCall_0()); 
	    }
		lv_traces_0_0=ruletrace		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTracelistRule());
	        }
       		add(
       			$current, 
       			"traces",
        		lv_traces_0_0, 
        		"trace");
	        afterParserOrEnumRuleCall();
	    }

)
)+
;





// Entry rule entryRuletrace
entryRuletrace returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTraceRule()); }
	 iv_ruletrace=ruletrace 
	 { $current=$iv_ruletrace.current; } 
	 EOF 
;

// Rule trace
ruletrace returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='!' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getTraceAccess().getExclamationMarkKeyword_0());
    }
	otherlv_1='reset' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTraceAccess().getResetKeyword_1());
    }
	otherlv_2=';' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getTraceAccess().getSemicolonKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTraceAccess().getTicksTickParserRuleCall_3_0()); 
	    }
		lv_ticks_3_0=ruletick		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTraceRule());
	        }
       		add(
       			$current, 
       			"ticks",
        		lv_ticks_3_0, 
        		"tick");
	        afterParserOrEnumRuleCall();
	    }

)
)+)
;





// Entry rule entryRuletick
entryRuletick returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTickRule()); }
	 iv_ruletick=ruletick 
	 { $current=$iv_ruletick.current; } 
	 EOF 
;

// Rule tick
ruletick returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getTickAccess().getTickAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getTickAccess().getInputSignalParserRuleCall_1_0()); 
	    }
		lv_input_1_0=rulesignal		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTickRule());
	        }
       		add(
       			$current, 
       			"input",
        		lv_input_1_0, 
        		"signal");
	        afterParserOrEnumRuleCall();
	    }

)
)*(	otherlv_2='%' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getTickAccess().getPercentSignKeyword_2_0());
    }
	otherlv_3='Output' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getTickAccess().getOutputKeyword_2_1());
    }
	otherlv_4=':' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getTickAccess().getColonKeyword_2_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTickAccess().getOutputSignalParserRuleCall_2_3_0()); 
	    }
		lv_output_5_0=rulesignal		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTickRule());
	        }
       		add(
       			$current, 
       			"output",
        		lv_output_5_0, 
        		"signal");
	        afterParserOrEnumRuleCall();
	    }

)
)*)?(
(
		{ 
	        newCompositeNode(grammarAccess.getTickAccess().getExtraInfosKvpairParserRuleCall_3_0()); 
	    }
		lv_extraInfos_6_0=rulekvpair		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTickRule());
	        }
       		add(
       			$current, 
       			"extraInfos",
        		lv_extraInfos_6_0, 
        		"kvpair");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_7=';' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getTickAccess().getSemicolonKeyword_4());
    }
)
;





// Entry rule entryRulesignal
entryRulesignal returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSignalRule()); }
	 iv_rulesignal=rulesignal 
	 { $current=$iv_rulesignal.current; } 
	 EOF 
;

// Rule signal
rulesignal returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
(
		lv_name_0_1=RULE_ALPHA
		{
			newLeafNode(lv_name_0_1, grammarAccess.getSignalAccess().getNameAlphaTerminalRuleCall_0_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSignalRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_1, 
        		"Alpha");
	    }

    |		lv_name_0_2=RULE_ALPHANUM
		{
			newLeafNode(lv_name_0_2, grammarAccess.getSignalAccess().getNameAlphaNumTerminalRuleCall_0_0_1()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSignalRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_2, 
        		"AlphaNum");
	    }

    |		lv_name_0_3=RULE_ALPHANUMSPECIAL
		{
			newLeafNode(lv_name_0_3, grammarAccess.getSignalAccess().getNameAlphaNumSpecialTerminalRuleCall_0_0_2()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSignalRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_3, 
        		"AlphaNumSpecial");
	    }

)

)
)((
(
		lv_valued_1_0=	'(' 
    {
        newLeafNode(lv_valued_1_0, grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSignalRule());
	        }
       		setWithLastConsumed($current, "valued", true, "(");
	    }

)
)(
(
		lv_val_2_0=RULE_NUM
		{
			newLeafNode(lv_val_2_0, grammarAccess.getSignalAccess().getValNumTerminalRuleCall_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSignalRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"val",
        		lv_val_2_0, 
        		"Num");
	    }

)
)	otherlv_3=')' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getSignalAccess().getRightParenthesisKeyword_1_2());
    }
)?)
;





// Entry rule entryRulekvpair
entryRulekvpair returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getKvpairRule()); }
	 iv_rulekvpair=rulekvpair 
	 { $current=$iv_rulekvpair.current; } 
	 EOF 
;

// Rule kvpair
rulekvpair returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='%%' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getKvpairAccess().getPercentSignPercentSignKeyword_0());
    }
(
(
(
		lv_key_1_1=RULE_ALPHA
		{
			newLeafNode(lv_key_1_1, grammarAccess.getKvpairAccess().getKeyAlphaTerminalRuleCall_1_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getKvpairRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"key",
        		lv_key_1_1, 
        		"Alpha");
	    }

    |		lv_key_1_2=RULE_ALPHANUM
		{
			newLeafNode(lv_key_1_2, grammarAccess.getKvpairAccess().getKeyAlphaNumTerminalRuleCall_1_0_1()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getKvpairRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"key",
        		lv_key_1_2, 
        		"AlphaNum");
	    }

    |		lv_key_1_3=RULE_ALPHANUMSPECIAL
		{
			newLeafNode(lv_key_1_3, grammarAccess.getKvpairAccess().getKeyAlphaNumSpecialTerminalRuleCall_1_0_2()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getKvpairRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"key",
        		lv_key_1_3, 
        		"AlphaNumSpecial");
	    }

)

)
)	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getKvpairAccess().getColonKeyword_2());
    }
(
(
(
		lv_value_3_1=RULE_ALPHA
		{
			newLeafNode(lv_value_3_1, grammarAccess.getKvpairAccess().getValueAlphaTerminalRuleCall_3_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getKvpairRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"value",
        		lv_value_3_1, 
        		"Alpha");
	    }

    |		lv_value_3_2=RULE_ALPHANUM
		{
			newLeafNode(lv_value_3_2, grammarAccess.getKvpairAccess().getValueAlphaNumTerminalRuleCall_3_0_1()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getKvpairRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"value",
        		lv_value_3_2, 
        		"AlphaNum");
	    }

    |		lv_value_3_3=RULE_ALPHANUMSPECIAL
		{
			newLeafNode(lv_value_3_3, grammarAccess.getKvpairAccess().getValueAlphaNumSpecialTerminalRuleCall_3_0_2()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getKvpairRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"value",
        		lv_value_3_3, 
        		"AlphaNumSpecial");
	    }

)

)
))
;





RULE_ALPHA : ('a'..'z'|'A'..'Z')+;

RULE_DIGIT : '0'..'9';

RULE_NUM : ('+'|'-') ('0'..'9')+;

RULE_ALPHANUM : (RULE_ALPHA|'0'..'9')+;

RULE_SPECIAL : (','|'.'|'/'|'@'|'#'|'$'|'^'|'&'|'*'|'_'|'='|'+'|'-');

RULE_ALPHANUMSPECIAL : (RULE_ALPHA|RULE_DIGIT|RULE_SPECIAL)+;

RULE_COMMENT : '%' ('a'..'z'|'A'..'N'|'P'..'Z'|RULE_DIGIT|RULE_SPECIAL) ( options {greedy=false;} : . )*'\n';

RULE_WS : ('\t'|' '|'\r'|'\n');


