/*
* generated by Xtext
*/
grammar InternalRetypingSynccharts;

options {
	superClass=AbstractInternalAntlrParser;
	backtrack=true;
	
}

@lexer::header {
package de.cau.cs.kieler.synccharts.dsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package de.cau.cs.kieler.synccharts.dsl.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import de.cau.cs.kieler.synccharts.dsl.services.RetypingSyncchartsGrammarAccess;

}

@parser::members {
 
 	private RetypingSyncchartsGrammarAccess grammarAccess;
 	
    public InternalRetypingSyncchartsParser(TokenStream input, IAstFactory factory, RetypingSyncchartsGrammarAccess grammarAccess) {
        this(input);
        this.factory = factory;
        registerRules(grammarAccess.getGrammar());
        this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("de/cau/cs/kieler/synccharts/dsl/parser/antlr/internal/InternalRetypingSynccharts.tokens");
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "State";	
   	} 
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleState
entryRuleState returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.getStateRule(), currentNode); }
	 iv_ruleState=ruleState 
	 { $current=$iv_ruleState.current; } 
	 EOF 
;

// Rule State
ruleState returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
(((	
	
	    lv_isInitial_0='init' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_0_0(), "isInitial"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isInitial", true, "init", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)
    |(	
	
	    lv_isFinal_1='final' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_1_0(), "isFinal"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isFinal", true, "final", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_2_0(), currentNode); 
	    }
	    lv_stateKind_2=ruleStateType 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "stateKind", lv_stateKind_2, "StateType", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)
    |((	
	
	    lv_isInitial_3='init' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_3_0_0(), "isInitial"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isInitial", true, "init", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    lv_isFinal_4='final' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_3_1_0(), "isFinal"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isFinal", true, "final", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |((	
	
	    lv_isInitial_5='init' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_4_0_0(), "isInitial"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isInitial", true, "init", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_4_1_0(), currentNode); 
	    }
	    lv_stateKind_6=ruleStateType 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "stateKind", lv_stateKind_6, "StateType", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))
    |((	
	
	    lv_isFinal_7='final' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_5_0_0(), "isFinal"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isFinal", true, "final", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    lv_isInitial_8='init' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_5_1_0(), "isInitial"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isInitial", true, "init", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |((	
	
	    lv_isFinal_9='final' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_6_0_0(), "isFinal"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isFinal", true, "final", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_6_1_0(), currentNode); 
	    }
	    lv_stateKind_10=ruleStateType 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "stateKind", lv_stateKind_10, "StateType", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))
    |((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_7_0_0(), currentNode); 
	    }
	    lv_stateKind_11=ruleStateType 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "stateKind", lv_stateKind_11, "StateType", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)(	
	
	    lv_isInitial_12='init' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_7_1_0(), "isInitial"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isInitial", true, "init", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_8_0_0(), currentNode); 
	    }
	    lv_stateKind_13=ruleStateType 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "stateKind", lv_stateKind_13, "StateType", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)(	
	
	    lv_isFinal_14='final' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_8_1_0(), "isFinal"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isFinal", true, "final", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |((	
	
	    lv_isInitial_15='init' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_9_0_0(), "isInitial"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isInitial", true, "init", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    lv_isFinal_16='final' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_9_1_0(), "isFinal"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isFinal", true, "final", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_9_2_0(), currentNode); 
	    }
	    lv_stateKind_17=ruleStateType 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "stateKind", lv_stateKind_17, "StateType", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))
    |((	
	
	    lv_isInitial_18='init' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_10_0_0(), "isInitial"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isInitial", true, "init", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_10_1_0(), currentNode); 
	    }
	    lv_stateKind_19=ruleStateType 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "stateKind", lv_stateKind_19, "StateType", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)(	
	
	    lv_isFinal_20='final' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_10_2_0(), "isFinal"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isFinal", true, "final", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |((	
	
	    lv_isFinal_21='final' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_11_0_0(), "isFinal"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isFinal", true, "final", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    lv_isInitial_22='init' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_11_1_0(), "isInitial"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isInitial", true, "init", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_11_2_0(), currentNode); 
	    }
	    lv_stateKind_23=ruleStateType 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "stateKind", lv_stateKind_23, "StateType", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))
    |((	
	
	    lv_isFinal_24='final' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_12_0_0(), "isFinal"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isFinal", true, "final", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_12_1_0(), currentNode); 
	    }
	    lv_stateKind_25=ruleStateType 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "stateKind", lv_stateKind_25, "StateType", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)(	
	
	    lv_isInitial_26='init' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_12_2_0(), "isInitial"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isInitial", true, "init", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_13_0_0(), currentNode); 
	    }
	    lv_stateKind_27=ruleStateType 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "stateKind", lv_stateKind_27, "StateType", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)(	
	
	    lv_isFinal_28='final' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_13_1_0(), "isFinal"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isFinal", true, "final", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    lv_isInitial_29='init' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_13_2_0(), "isInitial"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isInitial", true, "init", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
))
    |((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_14_0_0(), currentNode); 
	    }
	    lv_stateKind_30=ruleStateType 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "stateKind", lv_stateKind_30, "StateType", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)(	
	
	    lv_isInitial_31='init' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_14_1_0(), "isInitial"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isInitial", true, "init", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)(	
	
	    lv_isFinal_32='final' 
    {
        createLeafNode(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_14_2_0(), "isFinal"); 
    }

 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "isFinal", true, "final", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)))?('state' 
    {
        createLeafNode(grammarAccess.getStateAccess().getStateKeyword_1(), null); 
    }
)?(	
	
	    lv_stateID_34=	RULE_ID
	{
		createLeafNode(grammarAccess.getStateAccess().getStateIDIDTerminalRuleCall_2_0(), "stateID"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "stateID", lv_stateID_34, "ID", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?(	
	
	    lv_stateLabel_35=	RULE_STRING
	{
		createLeafNode(grammarAccess.getStateAccess().getStateLabelSTRINGTerminalRuleCall_3_0(), "stateLabel"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "stateLabel", lv_stateLabel_35, "STRING", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
)?(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateContentStateContentParserRuleCall_4_0(), currentNode); 
	    }
	    lv_stateContent_36=ruleStateContent 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		set($current, "stateContent", lv_stateContent_36, "StateContent", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)?);





// Entry rule entryRuleStateContent
entryRuleStateContent returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.getStateContentRule(), currentNode); }
	 iv_ruleStateContent=ruleStateContent 
	 { $current=$iv_ruleStateContent.current; } 
	 EOF 
;

// Rule StateContent
ruleStateContent returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
('{' 
    {
        createLeafNode(grammarAccess.getStateContentAccess().getLeftCurlyBracketKeyword_0(), null); 
    }
((	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.getStateContentAccess().getExitActionsExitActionParserRuleCall_1_0_0(), currentNode); 
	    }
	    lv_exitActions_1=ruleExitAction 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateContentRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		add($current, "exitActions", lv_exitActions_1, "ExitAction", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.getStateContentAccess().getEntryActionsEntryActionParserRuleCall_1_1_0(), currentNode); 
	    }
	    lv_entryActions_2=ruleEntryAction 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateContentRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		add($current, "entryActions", lv_entryActions_2, "EntryAction", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
)
    |(	
	
	    
	    { 
	        currentNode=createCompositeNode(grammarAccess.getStateContentAccess().getInnerActionInnerActionParserRuleCall_1_2_0(), currentNode); 
	    }
	    lv_innerAction_3=ruleInnerAction 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getStateContentRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode.getParent(), $current);
	        }
	        
	        try {
	       		add($current, "innerAction", lv_innerAction_3, "InnerAction", currentNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	        currentNode = currentNode.getParent();
	    }
	
))+'}' 
    {
        createLeafNode(grammarAccess.getStateContentAccess().getRightCurlyBracketKeyword_2(), null); 
    }
);





// Entry rule entryRuleInnerAction
entryRuleInnerAction returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.getInnerActionRule(), currentNode); }
	 iv_ruleInnerAction=ruleInnerAction 
	 { $current=$iv_ruleInnerAction.current; } 
	 EOF 
;

// Rule InnerAction
ruleInnerAction returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
('oninner' 
    {
        createLeafNode(grammarAccess.getInnerActionAccess().getOninnerKeyword_0(), null); 
    }
(	
	
	    lv_inner_1=	RULE_STRING
	{
		createLeafNode(grammarAccess.getInnerActionAccess().getInnerSTRINGTerminalRuleCall_1_0(), "inner"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getInnerActionRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "inner", lv_inner_1, "STRING", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));





// Entry rule entryRuleEntryAction
entryRuleEntryAction returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.getEntryActionRule(), currentNode); }
	 iv_ruleEntryAction=ruleEntryAction 
	 { $current=$iv_ruleEntryAction.current; } 
	 EOF 
;

// Rule EntryAction
ruleEntryAction returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
('onentry' 
    {
        createLeafNode(grammarAccess.getEntryActionAccess().getOnentryKeyword_0(), null); 
    }
(	
	
	    lv_entryAction_1=	RULE_STRING
	{
		createLeafNode(grammarAccess.getEntryActionAccess().getEntryActionSTRINGTerminalRuleCall_1_0(), "entryAction"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getEntryActionRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "entryAction", lv_entryAction_1, "STRING", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));





// Entry rule entryRuleExitAction
entryRuleExitAction returns [EObject current=null] :
	{ currentNode = createCompositeNode(grammarAccess.getExitActionRule(), currentNode); }
	 iv_ruleExitAction=ruleExitAction 
	 { $current=$iv_ruleExitAction.current; } 
	 EOF 
;

// Rule ExitAction
ruleExitAction returns [EObject current=null] 
    @init { EObject temp=null; setCurrentLookahead(); resetLookahead(); 
    }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
('onexit' 
    {
        createLeafNode(grammarAccess.getExitActionAccess().getOnexitKeyword_0(), null); 
    }
(	
	
	    lv_exit_1=	RULE_STRING
	{
		createLeafNode(grammarAccess.getExitActionAccess().getExitSTRINGTerminalRuleCall_1_0(), "exit"); 
	}
 
	    {
	        if ($current==null) {
	            $current = factory.create(grammarAccess.getExitActionRule().getType().getClassifier());
	            associateNodeWithAstElement(currentNode, $current);
	        }
	        
	        try {
	       		set($current, "exit", lv_exit_1, "STRING", lastConsumedNode);
	        } catch (ValueConverterException vce) {
				handleValueConverterException(vce);
	        }
	    }
	
));





// Rule StateType
ruleStateType returns [Enumerator current=null] 
    @init { setCurrentLookahead(); resetLookahead(); }
    @after { resetLookahead(); 
    	lastConsumedNode = currentNode;
    }:
((	'NORMAL' 
	{
        $current = grammarAccess.getStateTypeAccess().getNORMALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        createLeafNode(grammarAccess.getStateTypeAccess().getNORMALEnumLiteralDeclaration_0(), null); 
    }
)
    |(	'cond' 
	{
        $current = grammarAccess.getStateTypeAccess().getPSEUDOEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        createLeafNode(grammarAccess.getStateTypeAccess().getPSEUDOEnumLiteralDeclaration_1(), null); 
    }
)
    |(	'reference' 
	{
        $current = grammarAccess.getStateTypeAccess().getREFERENCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        createLeafNode(grammarAccess.getStateTypeAccess().getREFERENCEEnumLiteralDeclaration_2(), null); 
    }
)
    |(	'textual' 
	{
        $current = grammarAccess.getStateTypeAccess().getTEXTUALEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        createLeafNode(grammarAccess.getStateTypeAccess().getTEXTUALEnumLiteralDeclaration_3(), null); 
    }
));



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


