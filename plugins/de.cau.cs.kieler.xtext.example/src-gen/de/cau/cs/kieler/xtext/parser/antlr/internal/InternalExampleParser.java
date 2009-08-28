package de.cau.cs.kieler.xtext.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import de.cau.cs.kieler.xtext.services.ExampleGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalExampleParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'not'", "'and'", "'or'", "'('", "')'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalExampleParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[25+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g"; }


     
     	private ExampleGrammarAccess grammarAccess;
     	
        public InternalExampleParser(TokenStream input, IAstFactory factory, ExampleGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:73:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:73:47: (iv_ruleModel= ruleModel EOF )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:74:2: iv_ruleModel= ruleModel EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel79);
            iv_ruleModel=ruleModel();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel89); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:81:1: ruleModel returns [EObject current=null] : ( (lv_signals_0= ruleSignal )+ ';' (lv_action_2= ruleAction ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_signals_0 = null;

        EObject lv_action_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:86:6: ( ( (lv_signals_0= ruleSignal )+ ';' (lv_action_2= ruleAction ) ) )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:87:1: ( (lv_signals_0= ruleSignal )+ ';' (lv_action_2= ruleAction ) )
            {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:87:1: ( (lv_signals_0= ruleSignal )+ ';' (lv_action_2= ruleAction ) )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:87:2: (lv_signals_0= ruleSignal )+ ';' (lv_action_2= ruleAction )
            {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:87:2: (lv_signals_0= ruleSignal )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:90:6: lv_signals_0= ruleSignal
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getSignalsSignalParserRuleCall_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSignal_in_ruleModel148);
            	    lv_signals_0=ruleSignal();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		add(current, "signals", lv_signals_0, "Signal", currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            match(input,11,FOLLOW_11_in_ruleModel162); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getModelAccess().getSemicolonKeyword_1(), null); 
                  
            }
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:112:1: (lv_action_2= ruleAction )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:115:6: lv_action_2= ruleAction
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getActionActionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleAction_in_ruleModel196);
            lv_action_2=ruleAction();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        
              	        try {
              	       		set(current, "action", lv_action_2, "Action", currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleAction
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:140:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:140:48: (iv_ruleAction= ruleAction EOF )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:141:2: iv_ruleAction= ruleAction EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getActionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction233);
            iv_ruleAction=ruleAction();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction243); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAction


    // $ANTLR start ruleAction
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:148:1: ruleAction returns [EObject current=null] : (lv_triggers_0= ruleBooleanExpression ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        EObject lv_triggers_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:153:6: ( (lv_triggers_0= ruleBooleanExpression ) )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:154:1: (lv_triggers_0= ruleBooleanExpression )
            {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:154:1: (lv_triggers_0= ruleBooleanExpression )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:157:6: lv_triggers_0= ruleBooleanExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getActionAccess().getTriggersBooleanExpressionParserRuleCall_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleBooleanExpression_in_ruleAction301);
            lv_triggers_0=ruleBooleanExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getActionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        
              	        try {
              	       		add(current, "triggers", lv_triggers_0, "BooleanExpression", currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAction


    // $ANTLR start entryRuleSignal
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:182:1: entryRuleSignal returns [EObject current=null] : iv_ruleSignal= ruleSignal EOF ;
    public final EObject entryRuleSignal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignal = null;


        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:182:48: (iv_ruleSignal= ruleSignal EOF )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:183:2: iv_ruleSignal= ruleSignal EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSignalRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSignal_in_entryRuleSignal337);
            iv_ruleSignal=ruleSignal();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSignal; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignal347); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSignal


    // $ANTLR start ruleSignal
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:190:1: ruleSignal returns [EObject current=null] : (lv_name_0= RULE_ID ) ;
    public final EObject ruleSignal() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:195:6: ( (lv_name_0= RULE_ID ) )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:196:1: (lv_name_0= RULE_ID )
            {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:196:1: (lv_name_0= RULE_ID )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:198:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSignal393); if (failed) return current;
            if ( backtracking==0 ) {

              		createLeafNode(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_0(), "name"); 
              	
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getSignalRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        
              	        try {
              	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSignal


    // $ANTLR start entryRuleSignalReference
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:223:1: entryRuleSignalReference returns [EObject current=null] : iv_ruleSignalReference= ruleSignalReference EOF ;
    public final EObject entryRuleSignalReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignalReference = null;


        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:223:57: (iv_ruleSignalReference= ruleSignalReference EOF )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:224:2: iv_ruleSignalReference= ruleSignalReference EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSignalReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSignalReference_in_entryRuleSignalReference433);
            iv_ruleSignalReference=ruleSignalReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSignalReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignalReference443); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSignalReference


    // $ANTLR start ruleSignalReference
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:231:1: ruleSignalReference returns [EObject current=null] : ( RULE_ID ) ;
    public final EObject ruleSignalReference() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:236:6: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:237:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:237:1: ( RULE_ID )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:240:3: RULE_ID
            {
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getSignalReferenceRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSignalReference489); if (failed) return current;
            if ( backtracking==0 ) {

              		createLeafNode(grammarAccess.getSignalReferenceAccess().getSignalSignalCrossReference_0(), "signal"); 
              	
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSignalReference


    // $ANTLR start entryRuleNotOperation
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:260:1: entryRuleNotOperation returns [EObject current=null] : iv_ruleNotOperation= ruleNotOperation EOF ;
    public final EObject entryRuleNotOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotOperation = null;


        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:260:54: (iv_ruleNotOperation= ruleNotOperation EOF )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:261:2: iv_ruleNotOperation= ruleNotOperation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNotOperationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNotOperation_in_entryRuleNotOperation524);
            iv_ruleNotOperation=ruleNotOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNotOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNotOperation534); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNotOperation


    // $ANTLR start ruleNotOperation
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:268:1: ruleNotOperation returns [EObject current=null] : ( (lv_operator_0= 'not' ) (lv_subExpressions_1= ruleParanthesedBooleanExpression ) ) ;
    public final EObject ruleNotOperation() throws RecognitionException {
        EObject current = null;

        Token lv_operator_0=null;
        EObject lv_subExpressions_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:273:6: ( ( (lv_operator_0= 'not' ) (lv_subExpressions_1= ruleParanthesedBooleanExpression ) ) )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:274:1: ( (lv_operator_0= 'not' ) (lv_subExpressions_1= ruleParanthesedBooleanExpression ) )
            {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:274:1: ( (lv_operator_0= 'not' ) (lv_subExpressions_1= ruleParanthesedBooleanExpression ) )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:274:2: (lv_operator_0= 'not' ) (lv_subExpressions_1= ruleParanthesedBooleanExpression )
            {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:274:2: (lv_operator_0= 'not' )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:276:6: lv_operator_0= 'not'
            {
            lv_operator_0=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_ruleNotOperation580); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getNotOperationAccess().getOperatorNotKeyword_0_0(), "operator"); 
                  
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getNotOperationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        
              	        try {
              	       		set(current, "operator", /* lv_operator_0 */ input.LT(-1), "not", lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }

            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:295:2: (lv_subExpressions_1= ruleParanthesedBooleanExpression )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:298:6: lv_subExpressions_1= ruleParanthesedBooleanExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getNotOperationAccess().getSubExpressionsParanthesedBooleanExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleParanthesedBooleanExpression_in_ruleNotOperation627);
            lv_subExpressions_1=ruleParanthesedBooleanExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getNotOperationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        
              	        try {
              	       		add(current, "subExpressions", lv_subExpressions_1, "ParanthesedBooleanExpression", currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNotOperation


    // $ANTLR start entryRuleNotOrNormalExpression
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:323:1: entryRuleNotOrNormalExpression returns [EObject current=null] : iv_ruleNotOrNormalExpression= ruleNotOrNormalExpression EOF ;
    public final EObject entryRuleNotOrNormalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotOrNormalExpression = null;


        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:323:63: (iv_ruleNotOrNormalExpression= ruleNotOrNormalExpression EOF )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:324:2: iv_ruleNotOrNormalExpression= ruleNotOrNormalExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNotOrNormalExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNotOrNormalExpression_in_entryRuleNotOrNormalExpression664);
            iv_ruleNotOrNormalExpression=ruleNotOrNormalExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNotOrNormalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNotOrNormalExpression674); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNotOrNormalExpression


    // $ANTLR start ruleNotOrNormalExpression
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:331:1: ruleNotOrNormalExpression returns [EObject current=null] : (this_NotOperation_0= ruleNotOperation | this_ParanthesedBooleanExpression_1= ruleParanthesedBooleanExpression ) ;
    public final EObject ruleNotOrNormalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NotOperation_0 = null;

        EObject this_ParanthesedBooleanExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:336:6: ( (this_NotOperation_0= ruleNotOperation | this_ParanthesedBooleanExpression_1= ruleParanthesedBooleanExpression ) )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:337:1: (this_NotOperation_0= ruleNotOperation | this_ParanthesedBooleanExpression_1= ruleParanthesedBooleanExpression )
            {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:337:1: (this_NotOperation_0= ruleNotOperation | this_ParanthesedBooleanExpression_1= ruleParanthesedBooleanExpression )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID||LA2_0==15) ) {
                alt2=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("337:1: (this_NotOperation_0= ruleNotOperation | this_ParanthesedBooleanExpression_1= ruleParanthesedBooleanExpression )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:338:5: this_NotOperation_0= ruleNotOperation
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getNotOrNormalExpressionAccess().getNotOperationParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleNotOperation_in_ruleNotOrNormalExpression721);
                    this_NotOperation_0=ruleNotOperation();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_NotOperation_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:348:5: this_ParanthesedBooleanExpression_1= ruleParanthesedBooleanExpression
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getNotOrNormalExpressionAccess().getParanthesedBooleanExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleParanthesedBooleanExpression_in_ruleNotOrNormalExpression748);
                    this_ParanthesedBooleanExpression_1=ruleParanthesedBooleanExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_ParanthesedBooleanExpression_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNotOrNormalExpression


    // $ANTLR start entryRuleAndOperation
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:363:1: entryRuleAndOperation returns [EObject current=null] : iv_ruleAndOperation= ruleAndOperation EOF ;
    public final EObject entryRuleAndOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndOperation = null;


        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:363:54: (iv_ruleAndOperation= ruleAndOperation EOF )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:364:2: iv_ruleAndOperation= ruleAndOperation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAndOperationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAndOperation_in_entryRuleAndOperation780);
            iv_ruleAndOperation=ruleAndOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAndOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOperation790); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAndOperation


    // $ANTLR start ruleAndOperation
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:371:1: ruleAndOperation returns [EObject current=null] : (this_NotOrNormalExpression_0= ruleNotOrNormalExpression ( () (lv_operator_2= 'and' ) (lv_subExpressions_3= ruleNotOrNormalExpression ) )* ) ;
    public final EObject ruleAndOperation() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2=null;
        EObject this_NotOrNormalExpression_0 = null;

        EObject lv_subExpressions_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:376:6: ( (this_NotOrNormalExpression_0= ruleNotOrNormalExpression ( () (lv_operator_2= 'and' ) (lv_subExpressions_3= ruleNotOrNormalExpression ) )* ) )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:377:1: (this_NotOrNormalExpression_0= ruleNotOrNormalExpression ( () (lv_operator_2= 'and' ) (lv_subExpressions_3= ruleNotOrNormalExpression ) )* )
            {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:377:1: (this_NotOrNormalExpression_0= ruleNotOrNormalExpression ( () (lv_operator_2= 'and' ) (lv_subExpressions_3= ruleNotOrNormalExpression ) )* )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:378:5: this_NotOrNormalExpression_0= ruleNotOrNormalExpression ( () (lv_operator_2= 'and' ) (lv_subExpressions_3= ruleNotOrNormalExpression ) )*
            {
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAndOperationAccess().getNotOrNormalExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleNotOrNormalExpression_in_ruleAndOperation837);
            this_NotOrNormalExpression_0=ruleNotOrNormalExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_NotOrNormalExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:386:1: ( () (lv_operator_2= 'and' ) (lv_subExpressions_3= ruleNotOrNormalExpression ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:386:2: () (lv_operator_2= 'and' ) (lv_subExpressions_3= ruleNotOrNormalExpression )
            	    {
            	    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:386:2: ()
            	    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:387:5: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getAndOperationAccess().getOperationSubExpressionsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "subExpressions", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getAndOperationAccess().getOperationSubExpressionsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:402:2: (lv_operator_2= 'and' )
            	    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:404:6: lv_operator_2= 'and'
            	    {
            	    lv_operator_2=(Token)input.LT(1);
            	    match(input,13,FOLLOW_13_in_ruleAndOperation867); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getAndOperationAccess().getOperatorAndKeyword_1_1_0(), "operator"); 
            	          
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getAndOperationRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "operator", /* lv_operator_2 */ input.LT(-1), "and", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }

            	    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:423:2: (lv_subExpressions_3= ruleNotOrNormalExpression )
            	    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:426:6: lv_subExpressions_3= ruleNotOrNormalExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getAndOperationAccess().getSubExpressionsNotOrNormalExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNotOrNormalExpression_in_ruleAndOperation914);
            	    lv_subExpressions_3=ruleNotOrNormalExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getAndOperationRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		add(current, "subExpressions", lv_subExpressions_3, "NotOrNormalExpression", currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAndOperation


    // $ANTLR start entryRuleOrOperation
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:451:1: entryRuleOrOperation returns [EObject current=null] : iv_ruleOrOperation= ruleOrOperation EOF ;
    public final EObject entryRuleOrOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrOperation = null;


        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:451:53: (iv_ruleOrOperation= ruleOrOperation EOF )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:452:2: iv_ruleOrOperation= ruleOrOperation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOrOperationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOrOperation_in_entryRuleOrOperation953);
            iv_ruleOrOperation=ruleOrOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOrOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrOperation963); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOrOperation


    // $ANTLR start ruleOrOperation
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:459:1: ruleOrOperation returns [EObject current=null] : (this_AndOperation_0= ruleAndOperation ( () (lv_operator_2= 'or' ) (lv_subExpressions_3= ruleAndOperation ) )* ) ;
    public final EObject ruleOrOperation() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2=null;
        EObject this_AndOperation_0 = null;

        EObject lv_subExpressions_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:464:6: ( (this_AndOperation_0= ruleAndOperation ( () (lv_operator_2= 'or' ) (lv_subExpressions_3= ruleAndOperation ) )* ) )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:465:1: (this_AndOperation_0= ruleAndOperation ( () (lv_operator_2= 'or' ) (lv_subExpressions_3= ruleAndOperation ) )* )
            {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:465:1: (this_AndOperation_0= ruleAndOperation ( () (lv_operator_2= 'or' ) (lv_subExpressions_3= ruleAndOperation ) )* )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:466:5: this_AndOperation_0= ruleAndOperation ( () (lv_operator_2= 'or' ) (lv_subExpressions_3= ruleAndOperation ) )*
            {
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getOrOperationAccess().getAndOperationParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleAndOperation_in_ruleOrOperation1010);
            this_AndOperation_0=ruleAndOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_AndOperation_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:474:1: ( () (lv_operator_2= 'or' ) (lv_subExpressions_3= ruleAndOperation ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:474:2: () (lv_operator_2= 'or' ) (lv_subExpressions_3= ruleAndOperation )
            	    {
            	    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:474:2: ()
            	    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:475:5: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getOrOperationAccess().getOperationSubExpressionsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "subExpressions", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getOrOperationAccess().getOperationSubExpressionsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:490:2: (lv_operator_2= 'or' )
            	    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:492:6: lv_operator_2= 'or'
            	    {
            	    lv_operator_2=(Token)input.LT(1);
            	    match(input,14,FOLLOW_14_in_ruleOrOperation1040); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getOrOperationAccess().getOperatorOrKeyword_1_1_0(), "operator"); 
            	          
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getOrOperationRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "operator", /* lv_operator_2 */ input.LT(-1), "or", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }

            	    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:511:2: (lv_subExpressions_3= ruleAndOperation )
            	    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:514:6: lv_subExpressions_3= ruleAndOperation
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getOrOperationAccess().getSubExpressionsAndOperationParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndOperation_in_ruleOrOperation1087);
            	    lv_subExpressions_3=ruleAndOperation();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getOrOperationRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		add(current, "subExpressions", lv_subExpressions_3, "AndOperation", currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleOrOperation


    // $ANTLR start entryRuleParanthesedBooleanExpression
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:539:1: entryRuleParanthesedBooleanExpression returns [EObject current=null] : iv_ruleParanthesedBooleanExpression= ruleParanthesedBooleanExpression EOF ;
    public final EObject entryRuleParanthesedBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesedBooleanExpression = null;


        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:539:70: (iv_ruleParanthesedBooleanExpression= ruleParanthesedBooleanExpression EOF )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:540:2: iv_ruleParanthesedBooleanExpression= ruleParanthesedBooleanExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getParanthesedBooleanExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleParanthesedBooleanExpression_in_entryRuleParanthesedBooleanExpression1126);
            iv_ruleParanthesedBooleanExpression=ruleParanthesedBooleanExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleParanthesedBooleanExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParanthesedBooleanExpression1136); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleParanthesedBooleanExpression


    // $ANTLR start ruleParanthesedBooleanExpression
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:547:1: ruleParanthesedBooleanExpression returns [EObject current=null] : (this_SignalReference_0= ruleSignalReference | ( '(' this_OrOperation_2= ruleOrOperation ')' ) ) ;
    public final EObject ruleParanthesedBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject this_SignalReference_0 = null;

        EObject this_OrOperation_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:552:6: ( (this_SignalReference_0= ruleSignalReference | ( '(' this_OrOperation_2= ruleOrOperation ')' ) ) )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:553:1: (this_SignalReference_0= ruleSignalReference | ( '(' this_OrOperation_2= ruleOrOperation ')' ) )
            {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:553:1: (this_SignalReference_0= ruleSignalReference | ( '(' this_OrOperation_2= ruleOrOperation ')' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            else if ( (LA5_0==15) ) {
                alt5=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("553:1: (this_SignalReference_0= ruleSignalReference | ( '(' this_OrOperation_2= ruleOrOperation ')' ) )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:554:5: this_SignalReference_0= ruleSignalReference
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getParanthesedBooleanExpressionAccess().getSignalReferenceParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleSignalReference_in_ruleParanthesedBooleanExpression1183);
                    this_SignalReference_0=ruleSignalReference();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_SignalReference_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:563:6: ( '(' this_OrOperation_2= ruleOrOperation ')' )
                    {
                    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:563:6: ( '(' this_OrOperation_2= ruleOrOperation ')' )
                    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:563:7: '(' this_OrOperation_2= ruleOrOperation ')'
                    {
                    match(input,15,FOLLOW_15_in_ruleParanthesedBooleanExpression1198); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getParanthesedBooleanExpressionAccess().getLeftParenthesisKeyword_1_0(), null); 
                          
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getParanthesedBooleanExpressionAccess().getOrOperationParserRuleCall_1_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleOrOperation_in_ruleParanthesedBooleanExpression1220);
                    this_OrOperation_2=ruleOrOperation();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_OrOperation_2; 
                              currentNode = currentNode.getParent();
                          
                    }
                    match(input,16,FOLLOW_16_in_ruleParanthesedBooleanExpression1228); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getParanthesedBooleanExpressionAccess().getRightParenthesisKeyword_1_2(), null); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleParanthesedBooleanExpression


    // $ANTLR start entryRuleBooleanExpression
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:587:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:587:59: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:588:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBooleanExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression1262);
            iv_ruleBooleanExpression=ruleBooleanExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBooleanExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanExpression1272); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBooleanExpression


    // $ANTLR start ruleBooleanExpression
    // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:595:1: ruleBooleanExpression returns [EObject current=null] : this_OrOperation_0= ruleOrOperation ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrOperation_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:600:6: (this_OrOperation_0= ruleOrOperation )
            // ../de.cau.cs.kieler.xtext.example/src-gen/de/cau/cs/kieler/xtext/parser/antlr/internal/InternalExample.g:602:5: this_OrOperation_0= ruleOrOperation
            {
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getBooleanExpressionAccess().getOrOperationParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleOrOperation_in_ruleBooleanExpression1318);
            this_OrOperation_0=ruleOrOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_OrOperation_0; 
                      currentNode = currentNode.getParent();
                  
            }

            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBooleanExpression


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel79 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_ruleModel148 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_11_in_ruleModel162 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleAction_in_ruleModel196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction233 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_ruleAction301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_entryRuleSignal337 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignal347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSignal393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignalReference_in_entryRuleSignalReference433 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignalReference443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSignalReference489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOperation_in_entryRuleNotOperation524 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNotOperation534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleNotOperation580 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleParanthesedBooleanExpression_in_ruleNotOperation627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOrNormalExpression_in_entryRuleNotOrNormalExpression664 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNotOrNormalExpression674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOperation_in_ruleNotOrNormalExpression721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParanthesedBooleanExpression_in_ruleNotOrNormalExpression748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOperation_in_entryRuleAndOperation780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOperation790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOrNormalExpression_in_ruleAndOperation837 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleAndOperation867 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleNotOrNormalExpression_in_ruleAndOperation914 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleOrOperation_in_entryRuleOrOperation953 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrOperation963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOperation_in_ruleOrOperation1010 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleOrOperation1040 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleAndOperation_in_ruleOrOperation1087 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleParanthesedBooleanExpression_in_entryRuleParanthesedBooleanExpression1126 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParanthesedBooleanExpression1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignalReference_in_ruleParanthesedBooleanExpression1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParanthesedBooleanExpression1198 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleOrOperation_in_ruleParanthesedBooleanExpression1220 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParanthesedBooleanExpression1228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression1262 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanExpression1272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrOperation_in_ruleBooleanExpression1318 = new BitSet(new long[]{0x0000000000000002L});

}