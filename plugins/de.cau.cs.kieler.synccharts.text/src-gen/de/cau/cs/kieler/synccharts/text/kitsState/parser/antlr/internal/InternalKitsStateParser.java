package de.cau.cs.kieler.synccharts.text.kitsState.parser.antlr.internal; 

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
import de.cau.cs.kieler.synccharts.text.kitsState.services.KitsStateGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalKitsStateParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_HOSTCODE", "RULE_FLOAT", "RULE_BOOLEAN", "RULE_COMMENT_ANNOTATION", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'region'", "':'", "'textual'", "'code'", "'('", "')'", "'init'", "'final'", "'state'", "'@'", "'['", "','", "']'", "'{'", "'onentry'", "'oninner'", "'onexit'", "'suspension'", "'}'", "'with'", "'#'", "'/'", "'history'", "'input'", "'output'", "'signal'", "':='", "'combine'", "'var'", "';'", "'inputoutput'", "'return'", "'import'", "'normal'", "'conditional'", "'reference'", "'-->'", "'o->'", "'>->'", "'='", "'<'", "'<='", "'>'", "'>='", "'<>'", "'pre'", "'or'", "'and'", "'not'", "'+'", "'-'", "'*'", "'mod'", "'?'", "'pure'", "'bool'", "'unsigned'", "'int'", "'float'", "'host'", "'none'", "'max'", "'min'"
    };
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_ID=4;
    public static final int RULE_WS=13;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_COMMENT_ANNOTATION=10;
    public static final int RULE_BOOLEAN=9;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_FLOAT=8;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_HOSTCODE=7;

        public InternalKitsStateParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[247+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private KitsStateGrammarAccess grammarAccess;
     	
        public InternalKitsStateParser(TokenStream input, IAstFactory factory, KitsStateGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "RootState";	
       	}
       	
       	@Override
       	protected KitsStateGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleRootState
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:84:1: entryRuleRootState returns [EObject current=null] : iv_ruleRootState= ruleRootState EOF ;
    public final EObject entryRuleRootState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootState = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:85:2: (iv_ruleRootState= ruleRootState EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:86:2: iv_ruleRootState= ruleRootState EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRootStateRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRootState_in_entryRuleRootState81);
            iv_ruleRootState=ruleRootState();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRootState; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRootState91); if (failed) return current;

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
    // $ANTLR end entryRuleRootState


    // $ANTLR start ruleRootState
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:93:1: ruleRootState returns [EObject current=null] : this_State_0= ruleState ;
    public final EObject ruleRootState() throws RecognitionException {
        EObject current = null;

        EObject this_State_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:98:6: (this_State_0= ruleState )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:100:2: this_State_0= ruleState
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getRootStateAccess().getStateParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleState_in_ruleRootState140);
            this_State_0=ruleState();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_State_0; 
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
    // $ANTLR end ruleRootState


    // $ANTLR start entryRuleSingleRegion
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:121:1: entryRuleSingleRegion returns [EObject current=null] : iv_ruleSingleRegion= ruleSingleRegion EOF ;
    public final EObject entryRuleSingleRegion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleRegion = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:122:2: (iv_ruleSingleRegion= ruleSingleRegion EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:123:2: iv_ruleSingleRegion= ruleSingleRegion EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSingleRegionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSingleRegion_in_entryRuleSingleRegion176);
            iv_ruleSingleRegion=ruleSingleRegion();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSingleRegion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleRegion186); if (failed) return current;

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
    // $ANTLR end entryRuleSingleRegion


    // $ANTLR start ruleSingleRegion
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:130:1: ruleSingleRegion returns [EObject current=null] : ( ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* 'region' ( (lv_id_2_0= RULE_ID ) )? ( (lv_label_3_0= RULE_STRING ) )? ':' ( ( (lv_variables_5_0= ruleVariable ) ) | ( (lv_signals_6_0= ruleSignal ) ) )* ( (lv_bodyText_7_0= ruleTextualCode ) )* )? ( (lv_states_8_0= ruleState ) )* ) ;
    public final EObject ruleSingleRegion() throws RecognitionException {
        EObject current = null;

        Token lv_id_2_0=null;
        Token lv_label_3_0=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_variables_5_0 = null;

        EObject lv_signals_6_0 = null;

        EObject lv_bodyText_7_0 = null;

        EObject lv_states_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:135:6: ( ( ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* 'region' ( (lv_id_2_0= RULE_ID ) )? ( (lv_label_3_0= RULE_STRING ) )? ':' ( ( (lv_variables_5_0= ruleVariable ) ) | ( (lv_signals_6_0= ruleSignal ) ) )* ( (lv_bodyText_7_0= ruleTextualCode ) )* )? ( (lv_states_8_0= ruleState ) )* ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:136:1: ( ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* 'region' ( (lv_id_2_0= RULE_ID ) )? ( (lv_label_3_0= RULE_STRING ) )? ':' ( ( (lv_variables_5_0= ruleVariable ) ) | ( (lv_signals_6_0= ruleSignal ) ) )* ( (lv_bodyText_7_0= ruleTextualCode ) )* )? ( (lv_states_8_0= ruleState ) )* )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:136:1: ( ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* 'region' ( (lv_id_2_0= RULE_ID ) )? ( (lv_label_3_0= RULE_STRING ) )? ':' ( ( (lv_variables_5_0= ruleVariable ) ) | ( (lv_signals_6_0= ruleSignal ) ) )* ( (lv_bodyText_7_0= ruleTextualCode ) )* )? ( (lv_states_8_0= ruleState ) )* )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:136:2: ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* 'region' ( (lv_id_2_0= RULE_ID ) )? ( (lv_label_3_0= RULE_STRING ) )? ':' ( ( (lv_variables_5_0= ruleVariable ) ) | ( (lv_signals_6_0= ruleSignal ) ) )* ( (lv_bodyText_7_0= ruleTextualCode ) )* )? ( (lv_states_8_0= ruleState ) )*
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:136:2: ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* 'region' ( (lv_id_2_0= RULE_ID ) )? ( (lv_label_3_0= RULE_STRING ) )? ':' ( ( (lv_variables_5_0= ruleVariable ) ) | ( (lv_signals_6_0= ruleSignal ) ) )* ( (lv_bodyText_7_0= ruleTextualCode ) )* )?
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:136:3: ( (lv_annotations_0_0= ruleStringAnnotation ) )* 'region' ( (lv_id_2_0= RULE_ID ) )? ( (lv_label_3_0= RULE_STRING ) )? ':' ( ( (lv_variables_5_0= ruleVariable ) ) | ( (lv_signals_6_0= ruleSignal ) ) )* ( (lv_bodyText_7_0= ruleTextualCode ) )*
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:136:3: ( (lv_annotations_0_0= ruleStringAnnotation ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_COMMENT_ANNOTATION||LA1_0==24) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:137:1: (lv_annotations_0_0= ruleStringAnnotation )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:137:1: (lv_annotations_0_0= ruleStringAnnotation )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:138:3: lv_annotations_0_0= ruleStringAnnotation
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getSingleRegionAccess().getAnnotationsStringAnnotationParserRuleCall_0_0_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleStringAnnotation_in_ruleSingleRegion233);
                    	    lv_annotations_0_0=ruleStringAnnotation();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getSingleRegionRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"annotations",
                    	      	        		lv_annotations_0_0, 
                    	      	        		"StringAnnotation", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    match(input,15,FollowSets000.FOLLOW_15_in_ruleSingleRegion244); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSingleRegionAccess().getRegionKeyword_0_1(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:164:1: ( (lv_id_2_0= RULE_ID ) )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==RULE_ID) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:165:1: (lv_id_2_0= RULE_ID )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:165:1: (lv_id_2_0= RULE_ID )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:166:3: lv_id_2_0= RULE_ID
                            {
                            lv_id_2_0=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleRegion261); if (failed) return current;
                            if ( backtracking==0 ) {

                              			createLeafNode(grammarAccess.getSingleRegionAccess().getIdIDTerminalRuleCall_0_2_0(), "id"); 
                              		
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getSingleRegionRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"id",
                              	        		lv_id_2_0, 
                              	        		"ID", 
                              	        		lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:188:3: ( (lv_label_3_0= RULE_STRING ) )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==RULE_STRING) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:189:1: (lv_label_3_0= RULE_STRING )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:189:1: (lv_label_3_0= RULE_STRING )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:190:3: lv_label_3_0= RULE_STRING
                            {
                            lv_label_3_0=(Token)input.LT(1);
                            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSingleRegion284); if (failed) return current;
                            if ( backtracking==0 ) {

                              			createLeafNode(grammarAccess.getSingleRegionAccess().getLabelSTRINGTerminalRuleCall_0_3_0(), "label"); 
                              		
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getSingleRegionRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"label",
                              	        		lv_label_3_0, 
                              	        		"STRING", 
                              	        		lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }


                            }
                            break;

                    }

                    match(input,16,FollowSets000.FOLLOW_16_in_ruleSingleRegion300); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSingleRegionAccess().getColonKeyword_0_4(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:216:1: ( ( (lv_variables_5_0= ruleVariable ) ) | ( (lv_signals_6_0= ruleSignal ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==43) ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>=38 && LA4_0<=40)) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:216:2: ( (lv_variables_5_0= ruleVariable ) )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:216:2: ( (lv_variables_5_0= ruleVariable ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:217:1: (lv_variables_5_0= ruleVariable )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:217:1: (lv_variables_5_0= ruleVariable )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:218:3: lv_variables_5_0= ruleVariable
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getSingleRegionAccess().getVariablesVariableParserRuleCall_0_5_0_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleVariable_in_ruleSingleRegion322);
                    	    lv_variables_5_0=ruleVariable();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getSingleRegionRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"variables",
                    	      	        		lv_variables_5_0, 
                    	      	        		"Variable", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:241:6: ( (lv_signals_6_0= ruleSignal ) )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:241:6: ( (lv_signals_6_0= ruleSignal ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:242:1: (lv_signals_6_0= ruleSignal )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:242:1: (lv_signals_6_0= ruleSignal )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:243:3: lv_signals_6_0= ruleSignal
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getSingleRegionAccess().getSignalsSignalParserRuleCall_0_5_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSignal_in_ruleSingleRegion349);
                    	    lv_signals_6_0=ruleSignal();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getSingleRegionRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"signals",
                    	      	        		lv_signals_6_0, 
                    	      	        		"Signal", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:265:4: ( (lv_bodyText_7_0= ruleTextualCode ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==17) ) {
                            int LA5_2 = input.LA(2);

                            if ( (LA5_2==18) ) {
                                alt5=1;
                            }


                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:266:1: (lv_bodyText_7_0= ruleTextualCode )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:266:1: (lv_bodyText_7_0= ruleTextualCode )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:267:3: lv_bodyText_7_0= ruleTextualCode
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getSingleRegionAccess().getBodyTextTextualCodeParserRuleCall_0_6_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleTextualCode_in_ruleSingleRegion372);
                    	    lv_bodyText_7_0=ruleTextualCode();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getSingleRegionRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"bodyText",
                    	      	        		lv_bodyText_7_0, 
                    	      	        		"TextualCode", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:289:5: ( (lv_states_8_0= ruleState ) )*
            loop7:
            do {
                int alt7=2;
                alt7 = dfa7.predict(input);
                switch (alt7) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:290:1: (lv_states_8_0= ruleState )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:290:1: (lv_states_8_0= ruleState )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:291:3: lv_states_8_0= ruleState
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getSingleRegionAccess().getStatesStateParserRuleCall_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleState_in_ruleSingleRegion396);
            	    lv_states_8_0=ruleState();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getSingleRegionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"states",
            	      	        		lv_states_8_0, 
            	      	        		"State", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end ruleSingleRegion


    // $ANTLR start entryRuleTextualCode
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:321:1: entryRuleTextualCode returns [EObject current=null] : iv_ruleTextualCode= ruleTextualCode EOF ;
    public final EObject entryRuleTextualCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextualCode = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:322:2: (iv_ruleTextualCode= ruleTextualCode EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:323:2: iv_ruleTextualCode= ruleTextualCode EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTextualCodeRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTextualCode_in_entryRuleTextualCode433);
            iv_ruleTextualCode=ruleTextualCode();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTextualCode; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTextualCode443); if (failed) return current;

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
    // $ANTLR end entryRuleTextualCode


    // $ANTLR start ruleTextualCode
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:330:1: ruleTextualCode returns [EObject current=null] : ( 'textual' 'code' ( '(' ( (lv_type_3_0= RULE_ID ) ) ')' )? ':' ( (lv_code_6_0= RULE_STRING ) ) ) ;
    public final EObject ruleTextualCode() throws RecognitionException {
        EObject current = null;

        Token lv_type_3_0=null;
        Token lv_code_6_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:335:6: ( ( 'textual' 'code' ( '(' ( (lv_type_3_0= RULE_ID ) ) ')' )? ':' ( (lv_code_6_0= RULE_STRING ) ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:336:1: ( 'textual' 'code' ( '(' ( (lv_type_3_0= RULE_ID ) ) ')' )? ':' ( (lv_code_6_0= RULE_STRING ) ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:336:1: ( 'textual' 'code' ( '(' ( (lv_type_3_0= RULE_ID ) ) ')' )? ':' ( (lv_code_6_0= RULE_STRING ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:336:3: 'textual' 'code' ( '(' ( (lv_type_3_0= RULE_ID ) ) ')' )? ':' ( (lv_code_6_0= RULE_STRING ) )
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleTextualCode478); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTextualCodeAccess().getTextualKeyword_0(), null); 
                  
            }
            match(input,18,FollowSets000.FOLLOW_18_in_ruleTextualCode488); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTextualCodeAccess().getCodeKeyword_1(), null); 
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:344:1: ( '(' ( (lv_type_3_0= RULE_ID ) ) ')' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:344:3: '(' ( (lv_type_3_0= RULE_ID ) ) ')'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleTextualCode499); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTextualCodeAccess().getLeftParenthesisKeyword_2_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:348:1: ( (lv_type_3_0= RULE_ID ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:349:1: (lv_type_3_0= RULE_ID )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:349:1: (lv_type_3_0= RULE_ID )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:350:3: lv_type_3_0= RULE_ID
                    {
                    lv_type_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTextualCode516); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getTextualCodeAccess().getTypeIDTerminalRuleCall_2_1_0(), "type"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getTextualCodeRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_3_0, 
                      	        		"ID", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    match(input,20,FollowSets000.FOLLOW_20_in_ruleTextualCode531); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTextualCodeAccess().getRightParenthesisKeyword_2_2(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleTextualCode543); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTextualCodeAccess().getColonKeyword_3(), null); 
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:380:1: ( (lv_code_6_0= RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:381:1: (lv_code_6_0= RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:381:1: (lv_code_6_0= RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:382:3: lv_code_6_0= RULE_STRING
            {
            lv_code_6_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTextualCode560); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getTextualCodeAccess().getCodeSTRINGTerminalRuleCall_4_0(), "code"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTextualCodeRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"code",
              	        		lv_code_6_0, 
              	        		"STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

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
    // $ANTLR end ruleTextualCode


    // $ANTLR start entryRuleRegion
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:412:1: entryRuleRegion returns [EObject current=null] : iv_ruleRegion= ruleRegion EOF ;
    public final EObject entryRuleRegion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegion = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:413:2: (iv_ruleRegion= ruleRegion EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:414:2: iv_ruleRegion= ruleRegion EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRegionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRegion_in_entryRuleRegion601);
            iv_ruleRegion=ruleRegion();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRegion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRegion611); if (failed) return current;

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
    // $ANTLR end entryRuleRegion


    // $ANTLR start ruleRegion
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:421:1: ruleRegion returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* 'region' ( (lv_id_2_0= RULE_ID ) )? ( (lv_label_3_0= RULE_STRING ) )? ':' ( ( (lv_variables_5_0= ruleVariable ) ) | ( (lv_signals_6_0= ruleSignal ) ) )* ( (lv_bodyText_7_0= ruleTextualCode ) )* ( (lv_states_8_0= ruleState ) )+ ) ;
    public final EObject ruleRegion() throws RecognitionException {
        EObject current = null;

        Token lv_id_2_0=null;
        Token lv_label_3_0=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_variables_5_0 = null;

        EObject lv_signals_6_0 = null;

        EObject lv_bodyText_7_0 = null;

        EObject lv_states_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:426:6: ( ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* 'region' ( (lv_id_2_0= RULE_ID ) )? ( (lv_label_3_0= RULE_STRING ) )? ':' ( ( (lv_variables_5_0= ruleVariable ) ) | ( (lv_signals_6_0= ruleSignal ) ) )* ( (lv_bodyText_7_0= ruleTextualCode ) )* ( (lv_states_8_0= ruleState ) )+ ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:427:1: ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* 'region' ( (lv_id_2_0= RULE_ID ) )? ( (lv_label_3_0= RULE_STRING ) )? ':' ( ( (lv_variables_5_0= ruleVariable ) ) | ( (lv_signals_6_0= ruleSignal ) ) )* ( (lv_bodyText_7_0= ruleTextualCode ) )* ( (lv_states_8_0= ruleState ) )+ )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:427:1: ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* 'region' ( (lv_id_2_0= RULE_ID ) )? ( (lv_label_3_0= RULE_STRING ) )? ':' ( ( (lv_variables_5_0= ruleVariable ) ) | ( (lv_signals_6_0= ruleSignal ) ) )* ( (lv_bodyText_7_0= ruleTextualCode ) )* ( (lv_states_8_0= ruleState ) )+ )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:427:2: ( (lv_annotations_0_0= ruleStringAnnotation ) )* 'region' ( (lv_id_2_0= RULE_ID ) )? ( (lv_label_3_0= RULE_STRING ) )? ':' ( ( (lv_variables_5_0= ruleVariable ) ) | ( (lv_signals_6_0= ruleSignal ) ) )* ( (lv_bodyText_7_0= ruleTextualCode ) )* ( (lv_states_8_0= ruleState ) )+
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:427:2: ( (lv_annotations_0_0= ruleStringAnnotation ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_COMMENT_ANNOTATION||LA9_0==24) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:428:1: (lv_annotations_0_0= ruleStringAnnotation )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:428:1: (lv_annotations_0_0= ruleStringAnnotation )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:429:3: lv_annotations_0_0= ruleStringAnnotation
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getRegionAccess().getAnnotationsStringAnnotationParserRuleCall_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringAnnotation_in_ruleRegion657);
            	    lv_annotations_0_0=ruleStringAnnotation();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getRegionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"annotations",
            	      	        		lv_annotations_0_0, 
            	      	        		"StringAnnotation", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match(input,15,FollowSets000.FOLLOW_15_in_ruleRegion668); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRegionAccess().getRegionKeyword_1(), null); 
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:455:1: ( (lv_id_2_0= RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:456:1: (lv_id_2_0= RULE_ID )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:456:1: (lv_id_2_0= RULE_ID )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:457:3: lv_id_2_0= RULE_ID
                    {
                    lv_id_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRegion685); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getRegionAccess().getIdIDTerminalRuleCall_2_0(), "id"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getRegionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"id",
                      	        		lv_id_2_0, 
                      	        		"ID", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:479:3: ( (lv_label_3_0= RULE_STRING ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_STRING) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:480:1: (lv_label_3_0= RULE_STRING )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:480:1: (lv_label_3_0= RULE_STRING )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:481:3: lv_label_3_0= RULE_STRING
                    {
                    lv_label_3_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleRegion708); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getRegionAccess().getLabelSTRINGTerminalRuleCall_3_0(), "label"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getRegionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"label",
                      	        		lv_label_3_0, 
                      	        		"STRING", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleRegion724); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRegionAccess().getColonKeyword_4(), null); 
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:507:1: ( ( (lv_variables_5_0= ruleVariable ) ) | ( (lv_signals_6_0= ruleSignal ) ) )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==43) ) {
                    alt12=1;
                }
                else if ( ((LA12_0>=38 && LA12_0<=40)) ) {
                    alt12=2;
                }


                switch (alt12) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:507:2: ( (lv_variables_5_0= ruleVariable ) )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:507:2: ( (lv_variables_5_0= ruleVariable ) )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:508:1: (lv_variables_5_0= ruleVariable )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:508:1: (lv_variables_5_0= ruleVariable )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:509:3: lv_variables_5_0= ruleVariable
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getRegionAccess().getVariablesVariableParserRuleCall_5_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleVariable_in_ruleRegion746);
            	    lv_variables_5_0=ruleVariable();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getRegionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"variables",
            	      	        		lv_variables_5_0, 
            	      	        		"Variable", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:532:6: ( (lv_signals_6_0= ruleSignal ) )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:532:6: ( (lv_signals_6_0= ruleSignal ) )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:533:1: (lv_signals_6_0= ruleSignal )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:533:1: (lv_signals_6_0= ruleSignal )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:534:3: lv_signals_6_0= ruleSignal
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getRegionAccess().getSignalsSignalParserRuleCall_5_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleSignal_in_ruleRegion773);
            	    lv_signals_6_0=ruleSignal();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getRegionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"signals",
            	      	        		lv_signals_6_0, 
            	      	        		"Signal", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:556:4: ( (lv_bodyText_7_0= ruleTextualCode ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==17) ) {
                    int LA13_2 = input.LA(2);

                    if ( (LA13_2==18) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:557:1: (lv_bodyText_7_0= ruleTextualCode )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:557:1: (lv_bodyText_7_0= ruleTextualCode )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:558:3: lv_bodyText_7_0= ruleTextualCode
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getRegionAccess().getBodyTextTextualCodeParserRuleCall_6_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTextualCode_in_ruleRegion796);
            	    lv_bodyText_7_0=ruleTextualCode();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getRegionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"bodyText",
            	      	        		lv_bodyText_7_0, 
            	      	        		"TextualCode", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:580:3: ( (lv_states_8_0= ruleState ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:581:1: (lv_states_8_0= ruleState )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:581:1: (lv_states_8_0= ruleState )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:582:3: lv_states_8_0= ruleState
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getRegionAccess().getStatesStateParserRuleCall_7_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleState_in_ruleRegion818);
            	    lv_states_8_0=ruleState();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getRegionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"states",
            	      	        		lv_states_8_0, 
            	      	        		"State", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
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
    // $ANTLR end ruleRegion


    // $ANTLR start entryRuleState
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:612:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:613:2: (iv_ruleState= ruleState EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:614:2: iv_ruleState= ruleState EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStateRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleState_in_entryRuleState855);
            iv_ruleState=ruleState();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleState; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleState865); if (failed) return current;

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
    // $ANTLR end entryRuleState


    // $ANTLR start ruleState
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:621:1: ruleState returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* ( ( ( (lv_isInitial_1_0= 'init' ) ) ( (lv_isFinal_2_0= 'final' ) )? ) | ( ( (lv_isFinal_3_0= 'final' ) ) ( (lv_isInitial_4_0= 'init' ) )? ) )? ( (lv_type_5_0= ruleStateType ) )? 'state' ( (lv_id_7_0= RULE_ID ) ) ( (lv_label_8_0= RULE_STRING ) )? ( ( '@' ( ( RULE_ID ) ) ( '[' ( (lv_renamings_12_0= ruleSubstitution ) ) ( ',' ( (lv_renamings_14_0= ruleSubstitution ) ) )* ']' )? ) | ( '{' ( ( ( (lv_signals_17_0= ruleSignal ) ) | ( (lv_variables_18_0= ruleVariable ) ) | ( 'onentry' ( (lv_entryActions_20_0= ruleAction ) ) ) | ( 'oninner' ( (lv_innerActions_22_0= ruleAction ) ) ) | ( 'onexit' ( (lv_exitActions_24_0= ruleAction ) ) ) | ( 'suspension' ( (lv_suspensionTrigger_26_0= ruleAction ) ) ) )* ( (lv_bodyText_27_0= ruleTextualCode ) )* ( ( (lv_regions_28_0= ruleSingleRegion ) ) ( (lv_regions_29_0= ruleRegion ) )* )? ) '}' ) )? ( (lv_outgoingTransitions_31_0= ruleTransition ) )* ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token lv_isInitial_1_0=null;
        Token lv_isFinal_2_0=null;
        Token lv_isFinal_3_0=null;
        Token lv_isInitial_4_0=null;
        Token lv_id_7_0=null;
        Token lv_label_8_0=null;
        EObject lv_annotations_0_0 = null;

        Enumerator lv_type_5_0 = null;

        EObject lv_renamings_12_0 = null;

        EObject lv_renamings_14_0 = null;

        EObject lv_signals_17_0 = null;

        EObject lv_variables_18_0 = null;

        EObject lv_entryActions_20_0 = null;

        EObject lv_innerActions_22_0 = null;

        EObject lv_exitActions_24_0 = null;

        EObject lv_suspensionTrigger_26_0 = null;

        EObject lv_bodyText_27_0 = null;

        EObject lv_regions_28_0 = null;

        EObject lv_regions_29_0 = null;

        EObject lv_outgoingTransitions_31_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:626:6: ( ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* ( ( ( (lv_isInitial_1_0= 'init' ) ) ( (lv_isFinal_2_0= 'final' ) )? ) | ( ( (lv_isFinal_3_0= 'final' ) ) ( (lv_isInitial_4_0= 'init' ) )? ) )? ( (lv_type_5_0= ruleStateType ) )? 'state' ( (lv_id_7_0= RULE_ID ) ) ( (lv_label_8_0= RULE_STRING ) )? ( ( '@' ( ( RULE_ID ) ) ( '[' ( (lv_renamings_12_0= ruleSubstitution ) ) ( ',' ( (lv_renamings_14_0= ruleSubstitution ) ) )* ']' )? ) | ( '{' ( ( ( (lv_signals_17_0= ruleSignal ) ) | ( (lv_variables_18_0= ruleVariable ) ) | ( 'onentry' ( (lv_entryActions_20_0= ruleAction ) ) ) | ( 'oninner' ( (lv_innerActions_22_0= ruleAction ) ) ) | ( 'onexit' ( (lv_exitActions_24_0= ruleAction ) ) ) | ( 'suspension' ( (lv_suspensionTrigger_26_0= ruleAction ) ) ) )* ( (lv_bodyText_27_0= ruleTextualCode ) )* ( ( (lv_regions_28_0= ruleSingleRegion ) ) ( (lv_regions_29_0= ruleRegion ) )* )? ) '}' ) )? ( (lv_outgoingTransitions_31_0= ruleTransition ) )* ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:627:1: ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* ( ( ( (lv_isInitial_1_0= 'init' ) ) ( (lv_isFinal_2_0= 'final' ) )? ) | ( ( (lv_isFinal_3_0= 'final' ) ) ( (lv_isInitial_4_0= 'init' ) )? ) )? ( (lv_type_5_0= ruleStateType ) )? 'state' ( (lv_id_7_0= RULE_ID ) ) ( (lv_label_8_0= RULE_STRING ) )? ( ( '@' ( ( RULE_ID ) ) ( '[' ( (lv_renamings_12_0= ruleSubstitution ) ) ( ',' ( (lv_renamings_14_0= ruleSubstitution ) ) )* ']' )? ) | ( '{' ( ( ( (lv_signals_17_0= ruleSignal ) ) | ( (lv_variables_18_0= ruleVariable ) ) | ( 'onentry' ( (lv_entryActions_20_0= ruleAction ) ) ) | ( 'oninner' ( (lv_innerActions_22_0= ruleAction ) ) ) | ( 'onexit' ( (lv_exitActions_24_0= ruleAction ) ) ) | ( 'suspension' ( (lv_suspensionTrigger_26_0= ruleAction ) ) ) )* ( (lv_bodyText_27_0= ruleTextualCode ) )* ( ( (lv_regions_28_0= ruleSingleRegion ) ) ( (lv_regions_29_0= ruleRegion ) )* )? ) '}' ) )? ( (lv_outgoingTransitions_31_0= ruleTransition ) )* )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:627:1: ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* ( ( ( (lv_isInitial_1_0= 'init' ) ) ( (lv_isFinal_2_0= 'final' ) )? ) | ( ( (lv_isFinal_3_0= 'final' ) ) ( (lv_isInitial_4_0= 'init' ) )? ) )? ( (lv_type_5_0= ruleStateType ) )? 'state' ( (lv_id_7_0= RULE_ID ) ) ( (lv_label_8_0= RULE_STRING ) )? ( ( '@' ( ( RULE_ID ) ) ( '[' ( (lv_renamings_12_0= ruleSubstitution ) ) ( ',' ( (lv_renamings_14_0= ruleSubstitution ) ) )* ']' )? ) | ( '{' ( ( ( (lv_signals_17_0= ruleSignal ) ) | ( (lv_variables_18_0= ruleVariable ) ) | ( 'onentry' ( (lv_entryActions_20_0= ruleAction ) ) ) | ( 'oninner' ( (lv_innerActions_22_0= ruleAction ) ) ) | ( 'onexit' ( (lv_exitActions_24_0= ruleAction ) ) ) | ( 'suspension' ( (lv_suspensionTrigger_26_0= ruleAction ) ) ) )* ( (lv_bodyText_27_0= ruleTextualCode ) )* ( ( (lv_regions_28_0= ruleSingleRegion ) ) ( (lv_regions_29_0= ruleRegion ) )* )? ) '}' ) )? ( (lv_outgoingTransitions_31_0= ruleTransition ) )* )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:627:2: ( (lv_annotations_0_0= ruleStringAnnotation ) )* ( ( ( (lv_isInitial_1_0= 'init' ) ) ( (lv_isFinal_2_0= 'final' ) )? ) | ( ( (lv_isFinal_3_0= 'final' ) ) ( (lv_isInitial_4_0= 'init' ) )? ) )? ( (lv_type_5_0= ruleStateType ) )? 'state' ( (lv_id_7_0= RULE_ID ) ) ( (lv_label_8_0= RULE_STRING ) )? ( ( '@' ( ( RULE_ID ) ) ( '[' ( (lv_renamings_12_0= ruleSubstitution ) ) ( ',' ( (lv_renamings_14_0= ruleSubstitution ) ) )* ']' )? ) | ( '{' ( ( ( (lv_signals_17_0= ruleSignal ) ) | ( (lv_variables_18_0= ruleVariable ) ) | ( 'onentry' ( (lv_entryActions_20_0= ruleAction ) ) ) | ( 'oninner' ( (lv_innerActions_22_0= ruleAction ) ) ) | ( 'onexit' ( (lv_exitActions_24_0= ruleAction ) ) ) | ( 'suspension' ( (lv_suspensionTrigger_26_0= ruleAction ) ) ) )* ( (lv_bodyText_27_0= ruleTextualCode ) )* ( ( (lv_regions_28_0= ruleSingleRegion ) ) ( (lv_regions_29_0= ruleRegion ) )* )? ) '}' ) )? ( (lv_outgoingTransitions_31_0= ruleTransition ) )*
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:627:2: ( (lv_annotations_0_0= ruleStringAnnotation ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_COMMENT_ANNOTATION||LA15_0==24) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:628:1: (lv_annotations_0_0= ruleStringAnnotation )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:628:1: (lv_annotations_0_0= ruleStringAnnotation )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:629:3: lv_annotations_0_0= ruleStringAnnotation
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getAnnotationsStringAnnotationParserRuleCall_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringAnnotation_in_ruleState911);
            	    lv_annotations_0_0=ruleStringAnnotation();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"annotations",
            	      	        		lv_annotations_0_0, 
            	      	        		"StringAnnotation", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:651:3: ( ( ( (lv_isInitial_1_0= 'init' ) ) ( (lv_isFinal_2_0= 'final' ) )? ) | ( ( (lv_isFinal_3_0= 'final' ) ) ( (lv_isInitial_4_0= 'init' ) )? ) )?
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==21) ) {
                alt18=1;
            }
            else if ( (LA18_0==22) ) {
                alt18=2;
            }
            switch (alt18) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:651:4: ( ( (lv_isInitial_1_0= 'init' ) ) ( (lv_isFinal_2_0= 'final' ) )? )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:651:4: ( ( (lv_isInitial_1_0= 'init' ) ) ( (lv_isFinal_2_0= 'final' ) )? )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:651:5: ( (lv_isInitial_1_0= 'init' ) ) ( (lv_isFinal_2_0= 'final' ) )?
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:651:5: ( (lv_isInitial_1_0= 'init' ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:652:1: (lv_isInitial_1_0= 'init' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:652:1: (lv_isInitial_1_0= 'init' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:653:3: lv_isInitial_1_0= 'init'
                    {
                    lv_isInitial_1_0=(Token)input.LT(1);
                    match(input,21,FollowSets000.FOLLOW_21_in_ruleState932); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_1_0_0_0(), "isInitial"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "isInitial", true, "init", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:672:2: ( (lv_isFinal_2_0= 'final' ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==22) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:673:1: (lv_isFinal_2_0= 'final' )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:673:1: (lv_isFinal_2_0= 'final' )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:674:3: lv_isFinal_2_0= 'final'
                            {
                            lv_isFinal_2_0=(Token)input.LT(1);
                            match(input,22,FollowSets000.FOLLOW_22_in_ruleState963); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getStateAccess().getIsFinalFinalKeyword_1_0_1_0(), "isFinal"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "isFinal", true, "final", lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:694:6: ( ( (lv_isFinal_3_0= 'final' ) ) ( (lv_isInitial_4_0= 'init' ) )? )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:694:6: ( ( (lv_isFinal_3_0= 'final' ) ) ( (lv_isInitial_4_0= 'init' ) )? )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:694:7: ( (lv_isFinal_3_0= 'final' ) ) ( (lv_isInitial_4_0= 'init' ) )?
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:694:7: ( (lv_isFinal_3_0= 'final' ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:695:1: (lv_isFinal_3_0= 'final' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:695:1: (lv_isFinal_3_0= 'final' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:696:3: lv_isFinal_3_0= 'final'
                    {
                    lv_isFinal_3_0=(Token)input.LT(1);
                    match(input,22,FollowSets000.FOLLOW_22_in_ruleState1003); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getStateAccess().getIsFinalFinalKeyword_1_1_0_0(), "isFinal"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "isFinal", true, "final", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:715:2: ( (lv_isInitial_4_0= 'init' ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==21) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:716:1: (lv_isInitial_4_0= 'init' )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:716:1: (lv_isInitial_4_0= 'init' )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:717:3: lv_isInitial_4_0= 'init'
                            {
                            lv_isInitial_4_0=(Token)input.LT(1);
                            match(input,21,FollowSets000.FOLLOW_21_in_ruleState1034); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_1_1_1_0(), "isInitial"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "isInitial", true, "init", lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:736:6: ( (lv_type_5_0= ruleStateType ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==17||(LA19_0>=48 && LA19_0<=50)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:737:1: (lv_type_5_0= ruleStateType )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:737:1: (lv_type_5_0= ruleStateType )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:738:3: lv_type_5_0= ruleStateType
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getTypeStateTypeEnumRuleCall_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStateType_in_ruleState1072);
                    lv_type_5_0=ruleStateType();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_5_0, 
                      	        		"StateType", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleState1083); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getStateAccess().getStateKeyword_3(), null); 
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:764:1: ( (lv_id_7_0= RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:765:1: (lv_id_7_0= RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:765:1: (lv_id_7_0= RULE_ID )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:766:3: lv_id_7_0= RULE_ID
            {
            lv_id_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleState1100); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getStateAccess().getIdIDTerminalRuleCall_4_0(), "id"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"id",
              	        		lv_id_7_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:788:2: ( (lv_label_8_0= RULE_STRING ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_STRING) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:789:1: (lv_label_8_0= RULE_STRING )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:789:1: (lv_label_8_0= RULE_STRING )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:790:3: lv_label_8_0= RULE_STRING
                    {
                    lv_label_8_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleState1122); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getStateAccess().getLabelSTRINGTerminalRuleCall_5_0(), "label"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"label",
                      	        		lv_label_8_0, 
                      	        		"STRING", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:812:3: ( ( '@' ( ( RULE_ID ) ) ( '[' ( (lv_renamings_12_0= ruleSubstitution ) ) ( ',' ( (lv_renamings_14_0= ruleSubstitution ) ) )* ']' )? ) | ( '{' ( ( ( (lv_signals_17_0= ruleSignal ) ) | ( (lv_variables_18_0= ruleVariable ) ) | ( 'onentry' ( (lv_entryActions_20_0= ruleAction ) ) ) | ( 'oninner' ( (lv_innerActions_22_0= ruleAction ) ) ) | ( 'onexit' ( (lv_exitActions_24_0= ruleAction ) ) ) | ( 'suspension' ( (lv_suspensionTrigger_26_0= ruleAction ) ) ) )* ( (lv_bodyText_27_0= ruleTextualCode ) )* ( ( (lv_regions_28_0= ruleSingleRegion ) ) ( (lv_regions_29_0= ruleRegion ) )* )? ) '}' ) )?
            int alt27=3;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==24) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==RULE_ID) ) {
                    int LA27_4 = input.LA(3);

                    if ( (LA27_4==EOF||LA27_4==RULE_COMMENT_ANNOTATION||LA27_4==15||LA27_4==17||(LA27_4>=21 && LA27_4<=25)||LA27_4==33||(LA27_4>=48 && LA27_4<=53)) ) {
                        alt27=1;
                    }
                }
            }
            else if ( (LA27_0==28) ) {
                alt27=2;
            }
            switch (alt27) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:812:4: ( '@' ( ( RULE_ID ) ) ( '[' ( (lv_renamings_12_0= ruleSubstitution ) ) ( ',' ( (lv_renamings_14_0= ruleSubstitution ) ) )* ']' )? )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:812:4: ( '@' ( ( RULE_ID ) ) ( '[' ( (lv_renamings_12_0= ruleSubstitution ) ) ( ',' ( (lv_renamings_14_0= ruleSubstitution ) ) )* ']' )? )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:812:6: '@' ( ( RULE_ID ) ) ( '[' ( (lv_renamings_12_0= ruleSubstitution ) ) ( ',' ( (lv_renamings_14_0= ruleSubstitution ) ) )* ']' )?
                    {
                    match(input,24,FollowSets000.FOLLOW_24_in_ruleState1140); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getStateAccess().getCommercialAtKeyword_6_0_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:816:1: ( ( RULE_ID ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:817:1: ( RULE_ID )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:817:1: ( RULE_ID )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:818:3: RULE_ID
                    {
                    if ( backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleState1162); if (failed) return current;
                    if ( backtracking==0 ) {

                      		createLeafNode(grammarAccess.getStateAccess().getBodyReferenceStateCrossReference_6_0_1_0(), "bodyReference"); 
                      	
                    }

                    }


                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:833:2: ( '[' ( (lv_renamings_12_0= ruleSubstitution ) ) ( ',' ( (lv_renamings_14_0= ruleSubstitution ) ) )* ']' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==25) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:833:4: '[' ( (lv_renamings_12_0= ruleSubstitution ) ) ( ',' ( (lv_renamings_14_0= ruleSubstitution ) ) )* ']'
                            {
                            match(input,25,FollowSets000.FOLLOW_25_in_ruleState1173); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getStateAccess().getLeftSquareBracketKeyword_6_0_2_0(), null); 
                                  
                            }
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:837:1: ( (lv_renamings_12_0= ruleSubstitution ) )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:838:1: (lv_renamings_12_0= ruleSubstitution )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:838:1: (lv_renamings_12_0= ruleSubstitution )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:839:3: lv_renamings_12_0= ruleSubstitution
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getRenamingsSubstitutionParserRuleCall_6_0_2_1_0(), currentNode); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleSubstitution_in_ruleState1194);
                            lv_renamings_12_0=ruleSubstitution();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		add(
                              	       			current, 
                              	       			"renamings",
                              	        		lv_renamings_12_0, 
                              	        		"Substitution", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:861:2: ( ',' ( (lv_renamings_14_0= ruleSubstitution ) ) )*
                            loop21:
                            do {
                                int alt21=2;
                                int LA21_0 = input.LA(1);

                                if ( (LA21_0==26) ) {
                                    alt21=1;
                                }


                                switch (alt21) {
                            	case 1 :
                            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:861:4: ',' ( (lv_renamings_14_0= ruleSubstitution ) )
                            	    {
                            	    match(input,26,FollowSets000.FOLLOW_26_in_ruleState1205); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getStateAccess().getCommaKeyword_6_0_2_2_0(), null); 
                            	          
                            	    }
                            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:865:1: ( (lv_renamings_14_0= ruleSubstitution ) )
                            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:866:1: (lv_renamings_14_0= ruleSubstitution )
                            	    {
                            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:866:1: (lv_renamings_14_0= ruleSubstitution )
                            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:867:3: lv_renamings_14_0= ruleSubstitution
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getRenamingsSubstitutionParserRuleCall_6_0_2_2_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleSubstitution_in_ruleState1226);
                            	    lv_renamings_14_0=ruleSubstitution();
                            	    _fsp--;
                            	    if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	      	        }
                            	      	        try {
                            	      	       		add(
                            	      	       			current, 
                            	      	       			"renamings",
                            	      	        		lv_renamings_14_0, 
                            	      	        		"Substitution", 
                            	      	        		currentNode);
                            	      	        } catch (ValueConverterException vce) {
                            	      				handleValueConverterException(vce);
                            	      	        }
                            	      	        currentNode = currentNode.getParent();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop21;
                                }
                            } while (true);

                            match(input,27,FollowSets000.FOLLOW_27_in_ruleState1238); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getStateAccess().getRightSquareBracketKeyword_6_0_2_3(), null); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:894:6: ( '{' ( ( ( (lv_signals_17_0= ruleSignal ) ) | ( (lv_variables_18_0= ruleVariable ) ) | ( 'onentry' ( (lv_entryActions_20_0= ruleAction ) ) ) | ( 'oninner' ( (lv_innerActions_22_0= ruleAction ) ) ) | ( 'onexit' ( (lv_exitActions_24_0= ruleAction ) ) ) | ( 'suspension' ( (lv_suspensionTrigger_26_0= ruleAction ) ) ) )* ( (lv_bodyText_27_0= ruleTextualCode ) )* ( ( (lv_regions_28_0= ruleSingleRegion ) ) ( (lv_regions_29_0= ruleRegion ) )* )? ) '}' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:894:6: ( '{' ( ( ( (lv_signals_17_0= ruleSignal ) ) | ( (lv_variables_18_0= ruleVariable ) ) | ( 'onentry' ( (lv_entryActions_20_0= ruleAction ) ) ) | ( 'oninner' ( (lv_innerActions_22_0= ruleAction ) ) ) | ( 'onexit' ( (lv_exitActions_24_0= ruleAction ) ) ) | ( 'suspension' ( (lv_suspensionTrigger_26_0= ruleAction ) ) ) )* ( (lv_bodyText_27_0= ruleTextualCode ) )* ( ( (lv_regions_28_0= ruleSingleRegion ) ) ( (lv_regions_29_0= ruleRegion ) )* )? ) '}' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:894:8: '{' ( ( ( (lv_signals_17_0= ruleSignal ) ) | ( (lv_variables_18_0= ruleVariable ) ) | ( 'onentry' ( (lv_entryActions_20_0= ruleAction ) ) ) | ( 'oninner' ( (lv_innerActions_22_0= ruleAction ) ) ) | ( 'onexit' ( (lv_exitActions_24_0= ruleAction ) ) ) | ( 'suspension' ( (lv_suspensionTrigger_26_0= ruleAction ) ) ) )* ( (lv_bodyText_27_0= ruleTextualCode ) )* ( ( (lv_regions_28_0= ruleSingleRegion ) ) ( (lv_regions_29_0= ruleRegion ) )* )? ) '}'
                    {
                    match(input,28,FollowSets000.FOLLOW_28_in_ruleState1258); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_6_1_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:898:1: ( ( ( (lv_signals_17_0= ruleSignal ) ) | ( (lv_variables_18_0= ruleVariable ) ) | ( 'onentry' ( (lv_entryActions_20_0= ruleAction ) ) ) | ( 'oninner' ( (lv_innerActions_22_0= ruleAction ) ) ) | ( 'onexit' ( (lv_exitActions_24_0= ruleAction ) ) ) | ( 'suspension' ( (lv_suspensionTrigger_26_0= ruleAction ) ) ) )* ( (lv_bodyText_27_0= ruleTextualCode ) )* ( ( (lv_regions_28_0= ruleSingleRegion ) ) ( (lv_regions_29_0= ruleRegion ) )* )? )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:898:2: ( ( (lv_signals_17_0= ruleSignal ) ) | ( (lv_variables_18_0= ruleVariable ) ) | ( 'onentry' ( (lv_entryActions_20_0= ruleAction ) ) ) | ( 'oninner' ( (lv_innerActions_22_0= ruleAction ) ) ) | ( 'onexit' ( (lv_exitActions_24_0= ruleAction ) ) ) | ( 'suspension' ( (lv_suspensionTrigger_26_0= ruleAction ) ) ) )* ( (lv_bodyText_27_0= ruleTextualCode ) )* ( ( (lv_regions_28_0= ruleSingleRegion ) ) ( (lv_regions_29_0= ruleRegion ) )* )?
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:898:2: ( ( (lv_signals_17_0= ruleSignal ) ) | ( (lv_variables_18_0= ruleVariable ) ) | ( 'onentry' ( (lv_entryActions_20_0= ruleAction ) ) ) | ( 'oninner' ( (lv_innerActions_22_0= ruleAction ) ) ) | ( 'onexit' ( (lv_exitActions_24_0= ruleAction ) ) ) | ( 'suspension' ( (lv_suspensionTrigger_26_0= ruleAction ) ) ) )*
                    loop23:
                    do {
                        int alt23=7;
                        switch ( input.LA(1) ) {
                        case 38:
                        case 39:
                        case 40:
                            {
                            alt23=1;
                            }
                            break;
                        case 43:
                            {
                            alt23=2;
                            }
                            break;
                        case 29:
                            {
                            alt23=3;
                            }
                            break;
                        case 30:
                            {
                            alt23=4;
                            }
                            break;
                        case 31:
                            {
                            alt23=5;
                            }
                            break;
                        case 32:
                            {
                            alt23=6;
                            }
                            break;

                        }

                        switch (alt23) {
                    	case 1 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:898:3: ( (lv_signals_17_0= ruleSignal ) )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:898:3: ( (lv_signals_17_0= ruleSignal ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:899:1: (lv_signals_17_0= ruleSignal )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:899:1: (lv_signals_17_0= ruleSignal )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:900:3: lv_signals_17_0= ruleSignal
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getSignalsSignalParserRuleCall_6_1_1_0_0_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSignal_in_ruleState1281);
                    	    lv_signals_17_0=ruleSignal();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"signals",
                    	      	        		lv_signals_17_0, 
                    	      	        		"Signal", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:923:6: ( (lv_variables_18_0= ruleVariable ) )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:923:6: ( (lv_variables_18_0= ruleVariable ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:924:1: (lv_variables_18_0= ruleVariable )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:924:1: (lv_variables_18_0= ruleVariable )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:925:3: lv_variables_18_0= ruleVariable
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getVariablesVariableParserRuleCall_6_1_1_0_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleVariable_in_ruleState1308);
                    	    lv_variables_18_0=ruleVariable();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"variables",
                    	      	        		lv_variables_18_0, 
                    	      	        		"Variable", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:948:6: ( 'onentry' ( (lv_entryActions_20_0= ruleAction ) ) )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:948:6: ( 'onentry' ( (lv_entryActions_20_0= ruleAction ) ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:948:8: 'onentry' ( (lv_entryActions_20_0= ruleAction ) )
                    	    {
                    	    match(input,29,FollowSets000.FOLLOW_29_in_ruleState1325); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getStateAccess().getOnentryKeyword_6_1_1_0_2_0(), null); 
                    	          
                    	    }
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:952:1: ( (lv_entryActions_20_0= ruleAction ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:953:1: (lv_entryActions_20_0= ruleAction )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:953:1: (lv_entryActions_20_0= ruleAction )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:954:3: lv_entryActions_20_0= ruleAction
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getEntryActionsActionParserRuleCall_6_1_1_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAction_in_ruleState1346);
                    	    lv_entryActions_20_0=ruleAction();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"entryActions",
                    	      	        		lv_entryActions_20_0, 
                    	      	        		"Action", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:977:6: ( 'oninner' ( (lv_innerActions_22_0= ruleAction ) ) )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:977:6: ( 'oninner' ( (lv_innerActions_22_0= ruleAction ) ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:977:8: 'oninner' ( (lv_innerActions_22_0= ruleAction ) )
                    	    {
                    	    match(input,30,FollowSets000.FOLLOW_30_in_ruleState1364); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getStateAccess().getOninnerKeyword_6_1_1_0_3_0(), null); 
                    	          
                    	    }
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:981:1: ( (lv_innerActions_22_0= ruleAction ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:982:1: (lv_innerActions_22_0= ruleAction )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:982:1: (lv_innerActions_22_0= ruleAction )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:983:3: lv_innerActions_22_0= ruleAction
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getInnerActionsActionParserRuleCall_6_1_1_0_3_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAction_in_ruleState1385);
                    	    lv_innerActions_22_0=ruleAction();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"innerActions",
                    	      	        		lv_innerActions_22_0, 
                    	      	        		"Action", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 5 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1006:6: ( 'onexit' ( (lv_exitActions_24_0= ruleAction ) ) )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1006:6: ( 'onexit' ( (lv_exitActions_24_0= ruleAction ) ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1006:8: 'onexit' ( (lv_exitActions_24_0= ruleAction ) )
                    	    {
                    	    match(input,31,FollowSets000.FOLLOW_31_in_ruleState1403); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getStateAccess().getOnexitKeyword_6_1_1_0_4_0(), null); 
                    	          
                    	    }
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1010:1: ( (lv_exitActions_24_0= ruleAction ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1011:1: (lv_exitActions_24_0= ruleAction )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1011:1: (lv_exitActions_24_0= ruleAction )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1012:3: lv_exitActions_24_0= ruleAction
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getExitActionsActionParserRuleCall_6_1_1_0_4_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAction_in_ruleState1424);
                    	    lv_exitActions_24_0=ruleAction();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"exitActions",
                    	      	        		lv_exitActions_24_0, 
                    	      	        		"Action", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 6 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1035:6: ( 'suspension' ( (lv_suspensionTrigger_26_0= ruleAction ) ) )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1035:6: ( 'suspension' ( (lv_suspensionTrigger_26_0= ruleAction ) ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1035:8: 'suspension' ( (lv_suspensionTrigger_26_0= ruleAction ) )
                    	    {
                    	    match(input,32,FollowSets000.FOLLOW_32_in_ruleState1442); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getStateAccess().getSuspensionKeyword_6_1_1_0_5_0(), null); 
                    	          
                    	    }
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1039:1: ( (lv_suspensionTrigger_26_0= ruleAction ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1040:1: (lv_suspensionTrigger_26_0= ruleAction )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1040:1: (lv_suspensionTrigger_26_0= ruleAction )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1041:3: lv_suspensionTrigger_26_0= ruleAction
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getSuspensionTriggerActionParserRuleCall_6_1_1_0_5_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAction_in_ruleState1463);
                    	    lv_suspensionTrigger_26_0=ruleAction();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		set(
                    	      	       			current, 
                    	      	       			"suspensionTrigger",
                    	      	        		lv_suspensionTrigger_26_0, 
                    	      	        		"Action", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1063:5: ( (lv_bodyText_27_0= ruleTextualCode ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==17) ) {
                            int LA24_2 = input.LA(2);

                            if ( (LA24_2==18) ) {
                                alt24=1;
                            }


                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1064:1: (lv_bodyText_27_0= ruleTextualCode )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1064:1: (lv_bodyText_27_0= ruleTextualCode )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1065:3: lv_bodyText_27_0= ruleTextualCode
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getBodyTextTextualCodeParserRuleCall_6_1_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleTextualCode_in_ruleState1487);
                    	    lv_bodyText_27_0=ruleTextualCode();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"bodyText",
                    	      	        		lv_bodyText_27_0, 
                    	      	        		"TextualCode", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1087:3: ( ( (lv_regions_28_0= ruleSingleRegion ) ) ( (lv_regions_29_0= ruleRegion ) )* )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==RULE_COMMENT_ANNOTATION||LA26_0==15||LA26_0==17||(LA26_0>=21 && LA26_0<=24)||(LA26_0>=48 && LA26_0<=50)) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==33) ) {
                        int LA26_2 = input.LA(2);

                        if ( (synpred35()) ) {
                            alt26=1;
                        }
                    }
                    switch (alt26) {
                        case 1 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1087:4: ( (lv_regions_28_0= ruleSingleRegion ) ) ( (lv_regions_29_0= ruleRegion ) )*
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1087:4: ( (lv_regions_28_0= ruleSingleRegion ) )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1088:1: (lv_regions_28_0= ruleSingleRegion )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1088:1: (lv_regions_28_0= ruleSingleRegion )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1089:3: lv_regions_28_0= ruleSingleRegion
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getRegionsSingleRegionParserRuleCall_6_1_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleSingleRegion_in_ruleState1510);
                            lv_regions_28_0=ruleSingleRegion();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		add(
                              	       			current, 
                              	       			"regions",
                              	        		lv_regions_28_0, 
                              	        		"SingleRegion", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1111:2: ( (lv_regions_29_0= ruleRegion ) )*
                            loop25:
                            do {
                                int alt25=2;
                                int LA25_0 = input.LA(1);

                                if ( (LA25_0==RULE_COMMENT_ANNOTATION||LA25_0==15||LA25_0==24) ) {
                                    alt25=1;
                                }


                                switch (alt25) {
                            	case 1 :
                            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1112:1: (lv_regions_29_0= ruleRegion )
                            	    {
                            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1112:1: (lv_regions_29_0= ruleRegion )
                            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1113:3: lv_regions_29_0= ruleRegion
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getRegionsRegionParserRuleCall_6_1_1_2_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleRegion_in_ruleState1531);
                            	    lv_regions_29_0=ruleRegion();
                            	    _fsp--;
                            	    if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	      	        }
                            	      	        try {
                            	      	       		add(
                            	      	       			current, 
                            	      	       			"regions",
                            	      	        		lv_regions_29_0, 
                            	      	        		"Region", 
                            	      	        		currentNode);
                            	      	        } catch (ValueConverterException vce) {
                            	      				handleValueConverterException(vce);
                            	      	        }
                            	      	        currentNode = currentNode.getParent();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop25;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }

                    match(input,33,FollowSets000.FOLLOW_33_in_ruleState1545); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_6_1_2(), null); 
                          
                    }

                    }


                    }
                    break;

            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1139:4: ( (lv_outgoingTransitions_31_0= ruleTransition ) )*
            loop28:
            do {
                int alt28=2;
                alt28 = dfa28.predict(input);
                switch (alt28) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1140:1: (lv_outgoingTransitions_31_0= ruleTransition )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1140:1: (lv_outgoingTransitions_31_0= ruleTransition )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1141:3: lv_outgoingTransitions_31_0= ruleTransition
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getOutgoingTransitionsTransitionParserRuleCall_7_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTransition_in_ruleState1569);
            	    lv_outgoingTransitions_31_0=ruleTransition();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"outgoingTransitions",
            	      	        		lv_outgoingTransitions_31_0, 
            	      	        		"Transition", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // $ANTLR end ruleState


    // $ANTLR start entryRuleTransition
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1171:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1172:2: (iv_ruleTransition= ruleTransition EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1173:2: iv_ruleTransition= ruleTransition EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTransitionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTransition_in_entryRuleTransition1606);
            iv_ruleTransition=ruleTransition();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTransition; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransition1616); if (failed) return current;

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
    // $ANTLR end entryRuleTransition


    // $ANTLR start ruleTransition
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1180:1: ruleTransition returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* ( (lv_type_1_0= ruleTransitionType ) ) ( (lv_priority_2_0= RULE_INT ) )? ( ( RULE_ID ) ) ( 'with' ( ( ( (lv_isImmediate_5_0= '#' ) )? ( (lv_delay_6_0= RULE_INT ) )? ( (lv_trigger_7_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_9_0= ruleEffect ) ) ( ',' ( (lv_effects_11_0= ruleEffect ) ) )* )? ) | ( (lv_label_12_0= RULE_STRING ) ) ) )? ( (lv_isHistory_13_0= 'history' ) )? ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token lv_priority_2_0=null;
        Token lv_isImmediate_5_0=null;
        Token lv_delay_6_0=null;
        Token lv_label_12_0=null;
        Token lv_isHistory_13_0=null;
        EObject lv_annotations_0_0 = null;

        Enumerator lv_type_1_0 = null;

        EObject lv_trigger_7_0 = null;

        EObject lv_effects_9_0 = null;

        EObject lv_effects_11_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1185:6: ( ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* ( (lv_type_1_0= ruleTransitionType ) ) ( (lv_priority_2_0= RULE_INT ) )? ( ( RULE_ID ) ) ( 'with' ( ( ( (lv_isImmediate_5_0= '#' ) )? ( (lv_delay_6_0= RULE_INT ) )? ( (lv_trigger_7_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_9_0= ruleEffect ) ) ( ',' ( (lv_effects_11_0= ruleEffect ) ) )* )? ) | ( (lv_label_12_0= RULE_STRING ) ) ) )? ( (lv_isHistory_13_0= 'history' ) )? ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1186:1: ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* ( (lv_type_1_0= ruleTransitionType ) ) ( (lv_priority_2_0= RULE_INT ) )? ( ( RULE_ID ) ) ( 'with' ( ( ( (lv_isImmediate_5_0= '#' ) )? ( (lv_delay_6_0= RULE_INT ) )? ( (lv_trigger_7_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_9_0= ruleEffect ) ) ( ',' ( (lv_effects_11_0= ruleEffect ) ) )* )? ) | ( (lv_label_12_0= RULE_STRING ) ) ) )? ( (lv_isHistory_13_0= 'history' ) )? )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1186:1: ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* ( (lv_type_1_0= ruleTransitionType ) ) ( (lv_priority_2_0= RULE_INT ) )? ( ( RULE_ID ) ) ( 'with' ( ( ( (lv_isImmediate_5_0= '#' ) )? ( (lv_delay_6_0= RULE_INT ) )? ( (lv_trigger_7_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_9_0= ruleEffect ) ) ( ',' ( (lv_effects_11_0= ruleEffect ) ) )* )? ) | ( (lv_label_12_0= RULE_STRING ) ) ) )? ( (lv_isHistory_13_0= 'history' ) )? )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1186:2: ( (lv_annotations_0_0= ruleStringAnnotation ) )* ( (lv_type_1_0= ruleTransitionType ) ) ( (lv_priority_2_0= RULE_INT ) )? ( ( RULE_ID ) ) ( 'with' ( ( ( (lv_isImmediate_5_0= '#' ) )? ( (lv_delay_6_0= RULE_INT ) )? ( (lv_trigger_7_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_9_0= ruleEffect ) ) ( ',' ( (lv_effects_11_0= ruleEffect ) ) )* )? ) | ( (lv_label_12_0= RULE_STRING ) ) ) )? ( (lv_isHistory_13_0= 'history' ) )?
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1186:2: ( (lv_annotations_0_0= ruleStringAnnotation ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_COMMENT_ANNOTATION||LA29_0==24) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1187:1: (lv_annotations_0_0= ruleStringAnnotation )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1187:1: (lv_annotations_0_0= ruleStringAnnotation )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1188:3: lv_annotations_0_0= ruleStringAnnotation
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getAnnotationsStringAnnotationParserRuleCall_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringAnnotation_in_ruleTransition1662);
            	    lv_annotations_0_0=ruleStringAnnotation();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"annotations",
            	      	        		lv_annotations_0_0, 
            	      	        		"StringAnnotation", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1210:3: ( (lv_type_1_0= ruleTransitionType ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1211:1: (lv_type_1_0= ruleTransitionType )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1211:1: (lv_type_1_0= ruleTransitionType )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1212:3: lv_type_1_0= ruleTransitionType
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getTypeTransitionTypeEnumRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTransitionType_in_ruleTransition1684);
            lv_type_1_0=ruleTransitionType();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_1_0, 
              	        		"TransitionType", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1234:2: ( (lv_priority_2_0= RULE_INT ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_INT) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1235:1: (lv_priority_2_0= RULE_INT )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1235:1: (lv_priority_2_0= RULE_INT )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1236:3: lv_priority_2_0= RULE_INT
                    {
                    lv_priority_2_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTransition1701); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getTransitionAccess().getPriorityINTTerminalRuleCall_2_0(), "priority"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"priority",
                      	        		lv_priority_2_0, 
                      	        		"INT", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1258:3: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1259:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1259:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1260:3: RULE_ID
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransition1729); if (failed) return current;
            if ( backtracking==0 ) {

              		createLeafNode(grammarAccess.getTransitionAccess().getTargetStateStateCrossReference_3_0(), "targetState"); 
              	
            }

            }


            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1275:2: ( 'with' ( ( ( (lv_isImmediate_5_0= '#' ) )? ( (lv_delay_6_0= RULE_INT ) )? ( (lv_trigger_7_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_9_0= ruleEffect ) ) ( ',' ( (lv_effects_11_0= ruleEffect ) ) )* )? ) | ( (lv_label_12_0= RULE_STRING ) ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==34) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1275:4: 'with' ( ( ( (lv_isImmediate_5_0= '#' ) )? ( (lv_delay_6_0= RULE_INT ) )? ( (lv_trigger_7_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_9_0= ruleEffect ) ) ( ',' ( (lv_effects_11_0= ruleEffect ) ) )* )? ) | ( (lv_label_12_0= RULE_STRING ) ) )
                    {
                    match(input,34,FollowSets000.FOLLOW_34_in_ruleTransition1740); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTransitionAccess().getWithKeyword_4_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1279:1: ( ( ( (lv_isImmediate_5_0= '#' ) )? ( (lv_delay_6_0= RULE_INT ) )? ( (lv_trigger_7_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_9_0= ruleEffect ) ) ( ',' ( (lv_effects_11_0= ruleEffect ) ) )* )? ) | ( (lv_label_12_0= RULE_STRING ) ) )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==EOF||LA36_0==RULE_ID||(LA36_0>=RULE_INT && LA36_0<=RULE_COMMENT_ANNOTATION)||LA36_0==15||LA36_0==17||LA36_0==19||(LA36_0>=21 && LA36_0<=24)||LA36_0==33||(LA36_0>=35 && LA36_0<=37)||(LA36_0>=48 && LA36_0<=53)||LA36_0==60||LA36_0==63||LA36_0==65||LA36_0==68) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==RULE_STRING) ) {
                        alt36=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("1279:1: ( ( ( (lv_isImmediate_5_0= '#' ) )? ( (lv_delay_6_0= RULE_INT ) )? ( (lv_trigger_7_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_9_0= ruleEffect ) ) ( ',' ( (lv_effects_11_0= ruleEffect ) ) )* )? ) | ( (lv_label_12_0= RULE_STRING ) ) )", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1279:2: ( ( (lv_isImmediate_5_0= '#' ) )? ( (lv_delay_6_0= RULE_INT ) )? ( (lv_trigger_7_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_9_0= ruleEffect ) ) ( ',' ( (lv_effects_11_0= ruleEffect ) ) )* )? )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1279:2: ( ( (lv_isImmediate_5_0= '#' ) )? ( (lv_delay_6_0= RULE_INT ) )? ( (lv_trigger_7_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_9_0= ruleEffect ) ) ( ',' ( (lv_effects_11_0= ruleEffect ) ) )* )? )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1279:3: ( (lv_isImmediate_5_0= '#' ) )? ( (lv_delay_6_0= RULE_INT ) )? ( (lv_trigger_7_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_9_0= ruleEffect ) ) ( ',' ( (lv_effects_11_0= ruleEffect ) ) )* )?
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1279:3: ( (lv_isImmediate_5_0= '#' ) )?
                            int alt31=2;
                            int LA31_0 = input.LA(1);

                            if ( (LA31_0==35) ) {
                                alt31=1;
                            }
                            switch (alt31) {
                                case 1 :
                                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1280:1: (lv_isImmediate_5_0= '#' )
                                    {
                                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1280:1: (lv_isImmediate_5_0= '#' )
                                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1281:3: lv_isImmediate_5_0= '#'
                                    {
                                    lv_isImmediate_5_0=(Token)input.LT(1);
                                    match(input,35,FollowSets000.FOLLOW_35_in_ruleTransition1760); if (failed) return current;
                                    if ( backtracking==0 ) {

                                              createLeafNode(grammarAccess.getTransitionAccess().getIsImmediateNumberSignKeyword_4_1_0_0_0(), "isImmediate"); 
                                          
                                    }
                                    if ( backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
                                      	            associateNodeWithAstElement(currentNode, current);
                                      	        }
                                      	        
                                      	        try {
                                      	       		set(current, "isImmediate", true, "#", lastConsumedNode);
                                      	        } catch (ValueConverterException vce) {
                                      				handleValueConverterException(vce);
                                      	        }
                                      	    
                                    }

                                    }


                                    }
                                    break;

                            }

                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1300:3: ( (lv_delay_6_0= RULE_INT ) )?
                            int alt32=2;
                            int LA32_0 = input.LA(1);

                            if ( (LA32_0==RULE_INT) ) {
                                int LA32_1 = input.LA(2);

                                if ( (LA32_1==65) ) {
                                    switch ( input.LA(3) ) {
                                        case 65:
                                            {
                                            switch ( input.LA(4) ) {
                                                case 65:
                                                    {
                                                    int LA32_14 = input.LA(5);

                                                    if ( (synpred41()) ) {
                                                        alt32=1;
                                                    }
                                                    }
                                                    break;
                                                case RULE_INT:
                                                    {
                                                    int LA32_15 = input.LA(5);

                                                    if ( (synpred41()) ) {
                                                        alt32=1;
                                                    }
                                                    }
                                                    break;
                                                case RULE_FLOAT:
                                                    {
                                                    int LA32_16 = input.LA(5);

                                                    if ( (synpred41()) ) {
                                                        alt32=1;
                                                    }
                                                    }
                                                    break;
                                                case 19:
                                                    {
                                                    int LA32_17 = input.LA(5);

                                                    if ( (synpred41()) ) {
                                                        alt32=1;
                                                    }
                                                    }
                                                    break;
                                                case RULE_BOOLEAN:
                                                    {
                                                    int LA32_18 = input.LA(5);

                                                    if ( (synpred41()) ) {
                                                        alt32=1;
                                                    }
                                                    }
                                                    break;
                                                case 60:
                                                    {
                                                    int LA32_19 = input.LA(5);

                                                    if ( (LA32_19==19) ) {
                                                        switch ( input.LA(6) ) {
                                                            case 60:
                                                                {
                                                                int LA32_30 = input.LA(7);

                                                                if ( (LA32_30==19) ) {
                                                                    int LA32_36 = input.LA(8);

                                                                    if ( (synpred41()) ) {
                                                                        alt32=1;
                                                                    }
                                                                }
                                                                }
                                                                break;
                                                            case 68:
                                                                {
                                                                int LA32_31 = input.LA(7);

                                                                if ( (LA32_31==RULE_ID) ) {
                                                                    int LA32_37 = input.LA(8);

                                                                    if ( (LA32_37==20) ) {
                                                                        int LA32_38 = input.LA(9);

                                                                        if ( (synpred41()) ) {
                                                                            alt32=1;
                                                                        }
                                                                    }
                                                                }
                                                                }
                                                                break;
                                                            case RULE_ID:
                                                                {
                                                                int LA32_32 = input.LA(7);

                                                                if ( (LA32_32==20) ) {
                                                                    int LA32_38 = input.LA(8);

                                                                    if ( (synpred41()) ) {
                                                                        alt32=1;
                                                                    }
                                                                }
                                                                }
                                                                break;
                                                        }

                                                    }
                                                    }
                                                    break;
                                                case 68:
                                                    {
                                                    int LA32_20 = input.LA(5);

                                                    if ( (LA32_20==RULE_ID) ) {
                                                        int LA32_26 = input.LA(6);

                                                        if ( (synpred41()) ) {
                                                            alt32=1;
                                                        }
                                                    }
                                                    }
                                                    break;
                                                case RULE_ID:
                                                    {
                                                    int LA32_21 = input.LA(5);

                                                    if ( (synpred41()) ) {
                                                        alt32=1;
                                                    }
                                                    }
                                                    break;
                                                case RULE_HOSTCODE:
                                                    {
                                                    int LA32_22 = input.LA(5);

                                                    if ( (synpred41()) ) {
                                                        alt32=1;
                                                    }
                                                    }
                                                    break;
                                            }

                                            }
                                            break;
                                        case RULE_INT:
                                            {
                                            int LA32_6 = input.LA(4);

                                            if ( (synpred41()) ) {
                                                alt32=1;
                                            }
                                            }
                                            break;
                                        case RULE_FLOAT:
                                            {
                                            int LA32_7 = input.LA(4);

                                            if ( (synpred41()) ) {
                                                alt32=1;
                                            }
                                            }
                                            break;
                                        case 19:
                                            {
                                            int LA32_8 = input.LA(4);

                                            if ( (synpred41()) ) {
                                                alt32=1;
                                            }
                                            }
                                            break;
                                        case RULE_BOOLEAN:
                                            {
                                            int LA32_9 = input.LA(4);

                                            if ( (synpred41()) ) {
                                                alt32=1;
                                            }
                                            }
                                            break;
                                        case 60:
                                            {
                                            int LA32_10 = input.LA(4);

                                            if ( (LA32_10==19) ) {
                                                switch ( input.LA(5) ) {
                                                    case 60:
                                                        {
                                                        int LA32_27 = input.LA(6);

                                                        if ( (LA32_27==19) ) {
                                                            int LA32_33 = input.LA(7);

                                                            if ( (synpred41()) ) {
                                                                alt32=1;
                                                            }
                                                        }
                                                        }
                                                        break;
                                                    case 68:
                                                        {
                                                        int LA32_28 = input.LA(6);

                                                        if ( (LA32_28==RULE_ID) ) {
                                                            int LA32_34 = input.LA(7);

                                                            if ( (LA32_34==20) ) {
                                                                int LA32_35 = input.LA(8);

                                                                if ( (synpred41()) ) {
                                                                    alt32=1;
                                                                }
                                                            }
                                                        }
                                                        }
                                                        break;
                                                    case RULE_ID:
                                                        {
                                                        int LA32_29 = input.LA(6);

                                                        if ( (LA32_29==20) ) {
                                                            int LA32_35 = input.LA(7);

                                                            if ( (synpred41()) ) {
                                                                alt32=1;
                                                            }
                                                        }
                                                        }
                                                        break;
                                                }

                                            }
                                            }
                                            break;
                                        case 68:
                                            {
                                            int LA32_11 = input.LA(4);

                                            if ( (LA32_11==RULE_ID) ) {
                                                int LA32_24 = input.LA(5);

                                                if ( (synpred41()) ) {
                                                    alt32=1;
                                                }
                                            }
                                            }
                                            break;
                                        case RULE_ID:
                                            {
                                            int LA32_12 = input.LA(4);

                                            if ( (synpred41()) ) {
                                                alt32=1;
                                            }
                                            }
                                            break;
                                        case RULE_HOSTCODE:
                                            {
                                            int LA32_13 = input.LA(4);

                                            if ( (synpred41()) ) {
                                                alt32=1;
                                            }
                                            }
                                            break;
                                    }

                                }
                                else if ( (LA32_1==EOF||LA32_1==RULE_ID||(LA32_1>=RULE_INT && LA32_1<=RULE_COMMENT_ANNOTATION)||LA32_1==15||LA32_1==17||LA32_1==19||(LA32_1>=21 && LA32_1<=24)||LA32_1==33||(LA32_1>=36 && LA32_1<=37)||(LA32_1>=48 && LA32_1<=53)||LA32_1==60||LA32_1==63||LA32_1==68) ) {
                                    alt32=1;
                                }
                            }
                            switch (alt32) {
                                case 1 :
                                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1301:1: (lv_delay_6_0= RULE_INT )
                                    {
                                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1301:1: (lv_delay_6_0= RULE_INT )
                                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1302:3: lv_delay_6_0= RULE_INT
                                    {
                                    lv_delay_6_0=(Token)input.LT(1);
                                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTransition1791); if (failed) return current;
                                    if ( backtracking==0 ) {

                                      			createLeafNode(grammarAccess.getTransitionAccess().getDelayINTTerminalRuleCall_4_1_0_1_0(), "delay"); 
                                      		
                                    }
                                    if ( backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
                                      	            associateNodeWithAstElement(currentNode, current);
                                      	        }
                                      	        try {
                                      	       		set(
                                      	       			current, 
                                      	       			"delay",
                                      	        		lv_delay_6_0, 
                                      	        		"INT", 
                                      	        		lastConsumedNode);
                                      	        } catch (ValueConverterException vce) {
                                      				handleValueConverterException(vce);
                                      	        }
                                      	    
                                    }

                                    }


                                    }
                                    break;

                            }

                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1324:3: ( (lv_trigger_7_0= ruleBooleanExpression ) )?
                            int alt33=2;
                            int LA33_0 = input.LA(1);

                            if ( (LA33_0==RULE_ID||(LA33_0>=RULE_INT && LA33_0<=RULE_BOOLEAN)||LA33_0==19||LA33_0==60||LA33_0==63||LA33_0==65||LA33_0==68) ) {
                                alt33=1;
                            }
                            switch (alt33) {
                                case 1 :
                                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1325:1: (lv_trigger_7_0= ruleBooleanExpression )
                                    {
                                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1325:1: (lv_trigger_7_0= ruleBooleanExpression )
                                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1326:3: lv_trigger_7_0= ruleBooleanExpression
                                    {
                                    if ( backtracking==0 ) {
                                       
                                      	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getTriggerBooleanExpressionParserRuleCall_4_1_0_2_0(), currentNode); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleBooleanExpression_in_ruleTransition1818);
                                    lv_trigger_7_0=ruleBooleanExpression();
                                    _fsp--;
                                    if (failed) return current;
                                    if ( backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
                                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                                      	        }
                                      	        try {
                                      	       		set(
                                      	       			current, 
                                      	       			"trigger",
                                      	        		lv_trigger_7_0, 
                                      	        		"BooleanExpression", 
                                      	        		currentNode);
                                      	        } catch (ValueConverterException vce) {
                                      				handleValueConverterException(vce);
                                      	        }
                                      	        currentNode = currentNode.getParent();
                                      	    
                                    }

                                    }


                                    }
                                    break;

                            }

                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1348:3: ( '/' ( (lv_effects_9_0= ruleEffect ) ) ( ',' ( (lv_effects_11_0= ruleEffect ) ) )* )?
                            int alt35=2;
                            int LA35_0 = input.LA(1);

                            if ( (LA35_0==36) ) {
                                alt35=1;
                            }
                            switch (alt35) {
                                case 1 :
                                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1348:5: '/' ( (lv_effects_9_0= ruleEffect ) ) ( ',' ( (lv_effects_11_0= ruleEffect ) ) )*
                                    {
                                    match(input,36,FollowSets000.FOLLOW_36_in_ruleTransition1830); if (failed) return current;
                                    if ( backtracking==0 ) {

                                              createLeafNode(grammarAccess.getTransitionAccess().getSolidusKeyword_4_1_0_3_0(), null); 
                                          
                                    }
                                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1352:1: ( (lv_effects_9_0= ruleEffect ) )
                                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1353:1: (lv_effects_9_0= ruleEffect )
                                    {
                                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1353:1: (lv_effects_9_0= ruleEffect )
                                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1354:3: lv_effects_9_0= ruleEffect
                                    {
                                    if ( backtracking==0 ) {
                                       
                                      	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getEffectsEffectParserRuleCall_4_1_0_3_1_0(), currentNode); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleEffect_in_ruleTransition1851);
                                    lv_effects_9_0=ruleEffect();
                                    _fsp--;
                                    if (failed) return current;
                                    if ( backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
                                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                                      	        }
                                      	        try {
                                      	       		add(
                                      	       			current, 
                                      	       			"effects",
                                      	        		lv_effects_9_0, 
                                      	        		"Effect", 
                                      	        		currentNode);
                                      	        } catch (ValueConverterException vce) {
                                      				handleValueConverterException(vce);
                                      	        }
                                      	        currentNode = currentNode.getParent();
                                      	    
                                    }

                                    }


                                    }

                                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1376:2: ( ',' ( (lv_effects_11_0= ruleEffect ) ) )*
                                    loop34:
                                    do {
                                        int alt34=2;
                                        int LA34_0 = input.LA(1);

                                        if ( (LA34_0==26) ) {
                                            alt34=1;
                                        }


                                        switch (alt34) {
                                    	case 1 :
                                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1376:4: ',' ( (lv_effects_11_0= ruleEffect ) )
                                    	    {
                                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleTransition1862); if (failed) return current;
                                    	    if ( backtracking==0 ) {

                                    	              createLeafNode(grammarAccess.getTransitionAccess().getCommaKeyword_4_1_0_3_2_0(), null); 
                                    	          
                                    	    }
                                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1380:1: ( (lv_effects_11_0= ruleEffect ) )
                                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1381:1: (lv_effects_11_0= ruleEffect )
                                    	    {
                                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1381:1: (lv_effects_11_0= ruleEffect )
                                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1382:3: lv_effects_11_0= ruleEffect
                                    	    {
                                    	    if ( backtracking==0 ) {
                                    	       
                                    	      	        currentNode=createCompositeNode(grammarAccess.getTransitionAccess().getEffectsEffectParserRuleCall_4_1_0_3_2_1_0(), currentNode); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_ruleEffect_in_ruleTransition1883);
                                    	    lv_effects_11_0=ruleEffect();
                                    	    _fsp--;
                                    	    if (failed) return current;
                                    	    if ( backtracking==0 ) {

                                    	      	        if (current==null) {
                                    	      	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
                                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                                    	      	        }
                                    	      	        try {
                                    	      	       		add(
                                    	      	       			current, 
                                    	      	       			"effects",
                                    	      	        		lv_effects_11_0, 
                                    	      	        		"Effect", 
                                    	      	        		currentNode);
                                    	      	        } catch (ValueConverterException vce) {
                                    	      				handleValueConverterException(vce);
                                    	      	        }
                                    	      	        currentNode = currentNode.getParent();
                                    	      	    
                                    	    }

                                    	    }


                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop34;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1405:6: ( (lv_label_12_0= RULE_STRING ) )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1405:6: ( (lv_label_12_0= RULE_STRING ) )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1406:1: (lv_label_12_0= RULE_STRING )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1406:1: (lv_label_12_0= RULE_STRING )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1407:3: lv_label_12_0= RULE_STRING
                            {
                            lv_label_12_0=(Token)input.LT(1);
                            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTransition1911); if (failed) return current;
                            if ( backtracking==0 ) {

                              			createLeafNode(grammarAccess.getTransitionAccess().getLabelSTRINGTerminalRuleCall_4_1_1_0(), "label"); 
                              		
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"label",
                              	        		lv_label_12_0, 
                              	        		"STRING", 
                              	        		lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1429:5: ( (lv_isHistory_13_0= 'history' ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==37) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1430:1: (lv_isHistory_13_0= 'history' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1430:1: (lv_isHistory_13_0= 'history' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1431:3: lv_isHistory_13_0= 'history'
                    {
                    lv_isHistory_13_0=(Token)input.LT(1);
                    match(input,37,FollowSets000.FOLLOW_37_in_ruleTransition1937); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTransitionAccess().getIsHistoryHistoryKeyword_5_0(), "isHistory"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "isHistory", true, "history", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

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
    // $ANTLR end ruleTransition


    // $ANTLR start entryRuleSignal
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1458:1: entryRuleSignal returns [EObject current=null] : iv_ruleSignal= ruleSignal EOF ;
    public final EObject entryRuleSignal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignal = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1459:2: (iv_ruleSignal= ruleSignal EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1460:2: iv_ruleSignal= ruleSignal EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSignalRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSignal_in_entryRuleSignal1987);
            iv_ruleSignal=ruleSignal();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSignal; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSignal1997); if (failed) return current;

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
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1467:1: ruleSignal returns [EObject current=null] : ( ( (lv_isInput_0_0= 'input' ) )? ( (lv_isOutput_1_0= 'output' ) )? 'signal' ( (lv_name_3_0= RULE_ID ) ) ( ':=' ( (lv_initialValue_5_0= ruleAnyType ) ) )? ( ( ':' ( ( (lv_type_7_0= ruleValueType ) ) | ( (lv_hostType_8_0= RULE_STRING ) ) ) ) | ( ':' 'combine' ( ( (lv_type_11_0= ruleValueType ) ) | ( (lv_hostType_12_0= RULE_STRING ) ) ) 'with' ( ( (lv_combineOperator_14_0= ruleCombineOperator ) ) | ( (lv_hostCombineOperator_15_0= RULE_STRING ) ) ) ) )? ) ;
    public final EObject ruleSignal() throws RecognitionException {
        EObject current = null;

        Token lv_isInput_0_0=null;
        Token lv_isOutput_1_0=null;
        Token lv_name_3_0=null;
        Token lv_hostType_8_0=null;
        Token lv_hostType_12_0=null;
        Token lv_hostCombineOperator_15_0=null;
        AntlrDatatypeRuleToken lv_initialValue_5_0 = null;

        Enumerator lv_type_7_0 = null;

        Enumerator lv_type_11_0 = null;

        Enumerator lv_combineOperator_14_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1472:6: ( ( ( (lv_isInput_0_0= 'input' ) )? ( (lv_isOutput_1_0= 'output' ) )? 'signal' ( (lv_name_3_0= RULE_ID ) ) ( ':=' ( (lv_initialValue_5_0= ruleAnyType ) ) )? ( ( ':' ( ( (lv_type_7_0= ruleValueType ) ) | ( (lv_hostType_8_0= RULE_STRING ) ) ) ) | ( ':' 'combine' ( ( (lv_type_11_0= ruleValueType ) ) | ( (lv_hostType_12_0= RULE_STRING ) ) ) 'with' ( ( (lv_combineOperator_14_0= ruleCombineOperator ) ) | ( (lv_hostCombineOperator_15_0= RULE_STRING ) ) ) ) )? ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1473:1: ( ( (lv_isInput_0_0= 'input' ) )? ( (lv_isOutput_1_0= 'output' ) )? 'signal' ( (lv_name_3_0= RULE_ID ) ) ( ':=' ( (lv_initialValue_5_0= ruleAnyType ) ) )? ( ( ':' ( ( (lv_type_7_0= ruleValueType ) ) | ( (lv_hostType_8_0= RULE_STRING ) ) ) ) | ( ':' 'combine' ( ( (lv_type_11_0= ruleValueType ) ) | ( (lv_hostType_12_0= RULE_STRING ) ) ) 'with' ( ( (lv_combineOperator_14_0= ruleCombineOperator ) ) | ( (lv_hostCombineOperator_15_0= RULE_STRING ) ) ) ) )? )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1473:1: ( ( (lv_isInput_0_0= 'input' ) )? ( (lv_isOutput_1_0= 'output' ) )? 'signal' ( (lv_name_3_0= RULE_ID ) ) ( ':=' ( (lv_initialValue_5_0= ruleAnyType ) ) )? ( ( ':' ( ( (lv_type_7_0= ruleValueType ) ) | ( (lv_hostType_8_0= RULE_STRING ) ) ) ) | ( ':' 'combine' ( ( (lv_type_11_0= ruleValueType ) ) | ( (lv_hostType_12_0= RULE_STRING ) ) ) 'with' ( ( (lv_combineOperator_14_0= ruleCombineOperator ) ) | ( (lv_hostCombineOperator_15_0= RULE_STRING ) ) ) ) )? )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1473:2: ( (lv_isInput_0_0= 'input' ) )? ( (lv_isOutput_1_0= 'output' ) )? 'signal' ( (lv_name_3_0= RULE_ID ) ) ( ':=' ( (lv_initialValue_5_0= ruleAnyType ) ) )? ( ( ':' ( ( (lv_type_7_0= ruleValueType ) ) | ( (lv_hostType_8_0= RULE_STRING ) ) ) ) | ( ':' 'combine' ( ( (lv_type_11_0= ruleValueType ) ) | ( (lv_hostType_12_0= RULE_STRING ) ) ) 'with' ( ( (lv_combineOperator_14_0= ruleCombineOperator ) ) | ( (lv_hostCombineOperator_15_0= RULE_STRING ) ) ) ) )?
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1473:2: ( (lv_isInput_0_0= 'input' ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==38) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1474:1: (lv_isInput_0_0= 'input' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1474:1: (lv_isInput_0_0= 'input' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1475:3: lv_isInput_0_0= 'input'
                    {
                    lv_isInput_0_0=(Token)input.LT(1);
                    match(input,38,FollowSets000.FOLLOW_38_in_ruleSignal2040); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSignalAccess().getIsInputInputKeyword_0_0(), "isInput"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSignalRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "isInput", true, "input", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1494:3: ( (lv_isOutput_1_0= 'output' ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==39) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1495:1: (lv_isOutput_1_0= 'output' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1495:1: (lv_isOutput_1_0= 'output' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1496:3: lv_isOutput_1_0= 'output'
                    {
                    lv_isOutput_1_0=(Token)input.LT(1);
                    match(input,39,FollowSets000.FOLLOW_39_in_ruleSignal2072); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSignalAccess().getIsOutputOutputKeyword_1_0(), "isOutput"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSignalRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "isOutput", true, "output", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            match(input,40,FollowSets000.FOLLOW_40_in_ruleSignal2096); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSignalAccess().getSignalKeyword_2(), null); 
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1519:1: ( (lv_name_3_0= RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1520:1: (lv_name_3_0= RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1520:1: (lv_name_3_0= RULE_ID )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1521:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSignal2113); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getSignalRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_3_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1543:2: ( ':=' ( (lv_initialValue_5_0= ruleAnyType ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==41) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1543:4: ':=' ( (lv_initialValue_5_0= ruleAnyType ) )
                    {
                    match(input,41,FollowSets000.FOLLOW_41_in_ruleSignal2129); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSignalAccess().getColonEqualsSignKeyword_4_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1547:1: ( (lv_initialValue_5_0= ruleAnyType ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1548:1: (lv_initialValue_5_0= ruleAnyType )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1548:1: (lv_initialValue_5_0= ruleAnyType )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1549:3: lv_initialValue_5_0= ruleAnyType
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSignalAccess().getInitialValueAnyTypeParserRuleCall_4_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAnyType_in_ruleSignal2150);
                    lv_initialValue_5_0=ruleAnyType();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSignalRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"initialValue",
                      	        		lv_initialValue_5_0, 
                      	        		"AnyType", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1571:4: ( ( ':' ( ( (lv_type_7_0= ruleValueType ) ) | ( (lv_hostType_8_0= RULE_STRING ) ) ) ) | ( ':' 'combine' ( ( (lv_type_11_0= ruleValueType ) ) | ( (lv_hostType_12_0= RULE_STRING ) ) ) 'with' ( ( (lv_combineOperator_14_0= ruleCombineOperator ) ) | ( (lv_hostCombineOperator_15_0= RULE_STRING ) ) ) ) )?
            int alt45=3;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==16) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==42) ) {
                    alt45=2;
                }
                else if ( (LA45_1==RULE_STRING||(LA45_1>=69 && LA45_1<=74)) ) {
                    alt45=1;
                }
            }
            switch (alt45) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1571:5: ( ':' ( ( (lv_type_7_0= ruleValueType ) ) | ( (lv_hostType_8_0= RULE_STRING ) ) ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1571:5: ( ':' ( ( (lv_type_7_0= ruleValueType ) ) | ( (lv_hostType_8_0= RULE_STRING ) ) ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1571:7: ':' ( ( (lv_type_7_0= ruleValueType ) ) | ( (lv_hostType_8_0= RULE_STRING ) ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleSignal2164); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSignalAccess().getColonKeyword_5_0_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1575:1: ( ( (lv_type_7_0= ruleValueType ) ) | ( (lv_hostType_8_0= RULE_STRING ) ) )
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( ((LA42_0>=69 && LA42_0<=74)) ) {
                        alt42=1;
                    }
                    else if ( (LA42_0==RULE_STRING) ) {
                        alt42=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("1575:1: ( ( (lv_type_7_0= ruleValueType ) ) | ( (lv_hostType_8_0= RULE_STRING ) ) )", 42, 0, input);

                        throw nvae;
                    }
                    switch (alt42) {
                        case 1 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1575:2: ( (lv_type_7_0= ruleValueType ) )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1575:2: ( (lv_type_7_0= ruleValueType ) )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1576:1: (lv_type_7_0= ruleValueType )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1576:1: (lv_type_7_0= ruleValueType )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1577:3: lv_type_7_0= ruleValueType
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getSignalAccess().getTypeValueTypeEnumRuleCall_5_0_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleValueType_in_ruleSignal2186);
                            lv_type_7_0=ruleValueType();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getSignalRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"type",
                              	        		lv_type_7_0, 
                              	        		"ValueType", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1600:6: ( (lv_hostType_8_0= RULE_STRING ) )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1600:6: ( (lv_hostType_8_0= RULE_STRING ) )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1601:1: (lv_hostType_8_0= RULE_STRING )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1601:1: (lv_hostType_8_0= RULE_STRING )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1602:3: lv_hostType_8_0= RULE_STRING
                            {
                            lv_hostType_8_0=(Token)input.LT(1);
                            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSignal2209); if (failed) return current;
                            if ( backtracking==0 ) {

                              			createLeafNode(grammarAccess.getSignalAccess().getHostTypeSTRINGTerminalRuleCall_5_0_1_1_0(), "hostType"); 
                              		
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getSignalRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"hostType",
                              	        		lv_hostType_8_0, 
                              	        		"STRING", 
                              	        		lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1625:6: ( ':' 'combine' ( ( (lv_type_11_0= ruleValueType ) ) | ( (lv_hostType_12_0= RULE_STRING ) ) ) 'with' ( ( (lv_combineOperator_14_0= ruleCombineOperator ) ) | ( (lv_hostCombineOperator_15_0= RULE_STRING ) ) ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1625:6: ( ':' 'combine' ( ( (lv_type_11_0= ruleValueType ) ) | ( (lv_hostType_12_0= RULE_STRING ) ) ) 'with' ( ( (lv_combineOperator_14_0= ruleCombineOperator ) ) | ( (lv_hostCombineOperator_15_0= RULE_STRING ) ) ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1625:8: ':' 'combine' ( ( (lv_type_11_0= ruleValueType ) ) | ( (lv_hostType_12_0= RULE_STRING ) ) ) 'with' ( ( (lv_combineOperator_14_0= ruleCombineOperator ) ) | ( (lv_hostCombineOperator_15_0= RULE_STRING ) ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleSignal2233); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSignalAccess().getColonKeyword_5_1_0(), null); 
                          
                    }
                    match(input,42,FollowSets000.FOLLOW_42_in_ruleSignal2243); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSignalAccess().getCombineKeyword_5_1_1(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1633:1: ( ( (lv_type_11_0= ruleValueType ) ) | ( (lv_hostType_12_0= RULE_STRING ) ) )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( ((LA43_0>=69 && LA43_0<=74)) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==RULE_STRING) ) {
                        alt43=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("1633:1: ( ( (lv_type_11_0= ruleValueType ) ) | ( (lv_hostType_12_0= RULE_STRING ) ) )", 43, 0, input);

                        throw nvae;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1633:2: ( (lv_type_11_0= ruleValueType ) )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1633:2: ( (lv_type_11_0= ruleValueType ) )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1634:1: (lv_type_11_0= ruleValueType )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1634:1: (lv_type_11_0= ruleValueType )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1635:3: lv_type_11_0= ruleValueType
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getSignalAccess().getTypeValueTypeEnumRuleCall_5_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleValueType_in_ruleSignal2265);
                            lv_type_11_0=ruleValueType();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getSignalRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"type",
                              	        		lv_type_11_0, 
                              	        		"ValueType", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1658:6: ( (lv_hostType_12_0= RULE_STRING ) )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1658:6: ( (lv_hostType_12_0= RULE_STRING ) )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1659:1: (lv_hostType_12_0= RULE_STRING )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1659:1: (lv_hostType_12_0= RULE_STRING )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1660:3: lv_hostType_12_0= RULE_STRING
                            {
                            lv_hostType_12_0=(Token)input.LT(1);
                            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSignal2288); if (failed) return current;
                            if ( backtracking==0 ) {

                              			createLeafNode(grammarAccess.getSignalAccess().getHostTypeSTRINGTerminalRuleCall_5_1_2_1_0(), "hostType"); 
                              		
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getSignalRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"hostType",
                              	        		lv_hostType_12_0, 
                              	        		"STRING", 
                              	        		lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    match(input,34,FollowSets000.FOLLOW_34_in_ruleSignal2304); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSignalAccess().getWithKeyword_5_1_3(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1686:1: ( ( (lv_combineOperator_14_0= ruleCombineOperator ) ) | ( (lv_hostCombineOperator_15_0= RULE_STRING ) ) )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( ((LA44_0>=61 && LA44_0<=62)||LA44_0==64||LA44_0==66||(LA44_0>=74 && LA44_0<=77)) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==RULE_STRING) ) {
                        alt44=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("1686:1: ( ( (lv_combineOperator_14_0= ruleCombineOperator ) ) | ( (lv_hostCombineOperator_15_0= RULE_STRING ) ) )", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1686:2: ( (lv_combineOperator_14_0= ruleCombineOperator ) )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1686:2: ( (lv_combineOperator_14_0= ruleCombineOperator ) )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1687:1: (lv_combineOperator_14_0= ruleCombineOperator )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1687:1: (lv_combineOperator_14_0= ruleCombineOperator )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1688:3: lv_combineOperator_14_0= ruleCombineOperator
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getSignalAccess().getCombineOperatorCombineOperatorEnumRuleCall_5_1_4_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleCombineOperator_in_ruleSignal2326);
                            lv_combineOperator_14_0=ruleCombineOperator();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getSignalRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"combineOperator",
                              	        		lv_combineOperator_14_0, 
                              	        		"CombineOperator", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1711:6: ( (lv_hostCombineOperator_15_0= RULE_STRING ) )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1711:6: ( (lv_hostCombineOperator_15_0= RULE_STRING ) )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1712:1: (lv_hostCombineOperator_15_0= RULE_STRING )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1712:1: (lv_hostCombineOperator_15_0= RULE_STRING )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1713:3: lv_hostCombineOperator_15_0= RULE_STRING
                            {
                            lv_hostCombineOperator_15_0=(Token)input.LT(1);
                            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSignal2349); if (failed) return current;
                            if ( backtracking==0 ) {

                              			createLeafNode(grammarAccess.getSignalAccess().getHostCombineOperatorSTRINGTerminalRuleCall_5_1_4_1_0(), "hostCombineOperator"); 
                              		
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getSignalRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"hostCombineOperator",
                              	        		lv_hostCombineOperator_15_0, 
                              	        		"STRING", 
                              	        		lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

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


    // $ANTLR start entryRuleVariable
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1743:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1744:2: (iv_ruleVariable= ruleVariable EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1745:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getVariableRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariable_in_entryRuleVariable2394);
            iv_ruleVariable=ruleVariable();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariable2404); if (failed) return current;

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
    // $ANTLR end entryRuleVariable


    // $ANTLR start ruleVariable
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1752:1: ruleVariable returns [EObject current=null] : ( 'var' ( (lv_name_1_0= RULE_ID ) ) ( ':=' ( (lv_initialValue_3_0= ruleAnyType ) ) )? ':' ( ( (lv_type_5_0= ruleValueType ) ) | ( (lv_hostType_6_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_hostType_6_0=null;
        AntlrDatatypeRuleToken lv_initialValue_3_0 = null;

        Enumerator lv_type_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1757:6: ( ( 'var' ( (lv_name_1_0= RULE_ID ) ) ( ':=' ( (lv_initialValue_3_0= ruleAnyType ) ) )? ':' ( ( (lv_type_5_0= ruleValueType ) ) | ( (lv_hostType_6_0= RULE_STRING ) ) ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1758:1: ( 'var' ( (lv_name_1_0= RULE_ID ) ) ( ':=' ( (lv_initialValue_3_0= ruleAnyType ) ) )? ':' ( ( (lv_type_5_0= ruleValueType ) ) | ( (lv_hostType_6_0= RULE_STRING ) ) ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1758:1: ( 'var' ( (lv_name_1_0= RULE_ID ) ) ( ':=' ( (lv_initialValue_3_0= ruleAnyType ) ) )? ':' ( ( (lv_type_5_0= ruleValueType ) ) | ( (lv_hostType_6_0= RULE_STRING ) ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1758:3: 'var' ( (lv_name_1_0= RULE_ID ) ) ( ':=' ( (lv_initialValue_3_0= ruleAnyType ) ) )? ':' ( ( (lv_type_5_0= ruleValueType ) ) | ( (lv_hostType_6_0= RULE_STRING ) ) )
            {
            match(input,43,FollowSets000.FOLLOW_43_in_ruleVariable2439); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getVariableAccess().getVarKeyword_0(), null); 
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1762:1: ( (lv_name_1_0= RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1763:1: (lv_name_1_0= RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1763:1: (lv_name_1_0= RULE_ID )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1764:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariable2456); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1786:2: ( ':=' ( (lv_initialValue_3_0= ruleAnyType ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==41) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1786:4: ':=' ( (lv_initialValue_3_0= ruleAnyType ) )
                    {
                    match(input,41,FollowSets000.FOLLOW_41_in_ruleVariable2472); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getVariableAccess().getColonEqualsSignKeyword_2_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1790:1: ( (lv_initialValue_3_0= ruleAnyType ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1791:1: (lv_initialValue_3_0= ruleAnyType )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1791:1: (lv_initialValue_3_0= ruleAnyType )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1792:3: lv_initialValue_3_0= ruleAnyType
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getVariableAccess().getInitialValueAnyTypeParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAnyType_in_ruleVariable2493);
                    lv_initialValue_3_0=ruleAnyType();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"initialValue",
                      	        		lv_initialValue_3_0, 
                      	        		"AnyType", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleVariable2505); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getVariableAccess().getColonKeyword_3(), null); 
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1818:1: ( ( (lv_type_5_0= ruleValueType ) ) | ( (lv_hostType_6_0= RULE_STRING ) ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=69 && LA47_0<=74)) ) {
                alt47=1;
            }
            else if ( (LA47_0==RULE_STRING) ) {
                alt47=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1818:1: ( ( (lv_type_5_0= ruleValueType ) ) | ( (lv_hostType_6_0= RULE_STRING ) ) )", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1818:2: ( (lv_type_5_0= ruleValueType ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1818:2: ( (lv_type_5_0= ruleValueType ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1819:1: (lv_type_5_0= ruleValueType )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1819:1: (lv_type_5_0= ruleValueType )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1820:3: lv_type_5_0= ruleValueType
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getVariableAccess().getTypeValueTypeEnumRuleCall_4_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValueType_in_ruleVariable2527);
                    lv_type_5_0=ruleValueType();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_5_0, 
                      	        		"ValueType", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1843:6: ( (lv_hostType_6_0= RULE_STRING ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1843:6: ( (lv_hostType_6_0= RULE_STRING ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1844:1: (lv_hostType_6_0= RULE_STRING )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1844:1: (lv_hostType_6_0= RULE_STRING )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1845:3: lv_hostType_6_0= RULE_STRING
                    {
                    lv_hostType_6_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleVariable2550); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getVariableAccess().getHostTypeSTRINGTerminalRuleCall_4_1_0(), "hostType"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"hostType",
                      	        		lv_hostType_6_0, 
                      	        		"STRING", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;

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
    // $ANTLR end ruleVariable


    // $ANTLR start entryRuleSubstitution
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1875:1: entryRuleSubstitution returns [EObject current=null] : iv_ruleSubstitution= ruleSubstitution EOF ;
    public final EObject entryRuleSubstitution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubstitution = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1876:2: (iv_ruleSubstitution= ruleSubstitution EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1877:2: iv_ruleSubstitution= ruleSubstitution EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSubstitutionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSubstitution_in_entryRuleSubstitution2592);
            iv_ruleSubstitution=ruleSubstitution();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSubstitution; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubstitution2602); if (failed) return current;

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
    // $ANTLR end entryRuleSubstitution


    // $ANTLR start ruleSubstitution
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1884:1: ruleSubstitution returns [EObject current=null] : ( ( (lv_actual_0_0= RULE_ID ) ) '/' ( (lv_formal_2_0= RULE_ID ) ) ) ;
    public final EObject ruleSubstitution() throws RecognitionException {
        EObject current = null;

        Token lv_actual_0_0=null;
        Token lv_formal_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1889:6: ( ( ( (lv_actual_0_0= RULE_ID ) ) '/' ( (lv_formal_2_0= RULE_ID ) ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1890:1: ( ( (lv_actual_0_0= RULE_ID ) ) '/' ( (lv_formal_2_0= RULE_ID ) ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1890:1: ( ( (lv_actual_0_0= RULE_ID ) ) '/' ( (lv_formal_2_0= RULE_ID ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1890:2: ( (lv_actual_0_0= RULE_ID ) ) '/' ( (lv_formal_2_0= RULE_ID ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1890:2: ( (lv_actual_0_0= RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1891:1: (lv_actual_0_0= RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1891:1: (lv_actual_0_0= RULE_ID )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1892:3: lv_actual_0_0= RULE_ID
            {
            lv_actual_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubstitution2644); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getSubstitutionAccess().getActualIDTerminalRuleCall_0_0(), "actual"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getSubstitutionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"actual",
              	        		lv_actual_0_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,36,FollowSets000.FOLLOW_36_in_ruleSubstitution2659); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSubstitutionAccess().getSolidusKeyword_1(), null); 
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1918:1: ( (lv_formal_2_0= RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1919:1: (lv_formal_2_0= RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1919:1: (lv_formal_2_0= RULE_ID )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1920:3: lv_formal_2_0= RULE_ID
            {
            lv_formal_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubstitution2676); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getSubstitutionAccess().getFormalIDTerminalRuleCall_2_0(), "formal"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getSubstitutionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"formal",
              	        		lv_formal_2_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

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
    // $ANTLR end ruleSubstitution


    // $ANTLR start entryRuleAction
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1950:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1951:2: (iv_ruleAction= ruleAction EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1952:2: iv_ruleAction= ruleAction EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getActionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAction_in_entryRuleAction2717);
            iv_ruleAction=ruleAction();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAction; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAction2727); if (failed) return current;

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
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1959:1: ruleAction returns [EObject current=null] : ( () ( (lv_isImmediate_1_0= '#' ) )? ( (lv_delay_2_0= RULE_INT ) )? ( (lv_trigger_3_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_5_0= ruleEffect ) ) ( ',' ( (lv_effects_7_0= ruleEffect ) ) )* )? ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_isImmediate_1_0=null;
        Token lv_delay_2_0=null;
        EObject lv_trigger_3_0 = null;

        EObject lv_effects_5_0 = null;

        EObject lv_effects_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1964:6: ( ( () ( (lv_isImmediate_1_0= '#' ) )? ( (lv_delay_2_0= RULE_INT ) )? ( (lv_trigger_3_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_5_0= ruleEffect ) ) ( ',' ( (lv_effects_7_0= ruleEffect ) ) )* )? ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1965:1: ( () ( (lv_isImmediate_1_0= '#' ) )? ( (lv_delay_2_0= RULE_INT ) )? ( (lv_trigger_3_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_5_0= ruleEffect ) ) ( ',' ( (lv_effects_7_0= ruleEffect ) ) )* )? )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1965:1: ( () ( (lv_isImmediate_1_0= '#' ) )? ( (lv_delay_2_0= RULE_INT ) )? ( (lv_trigger_3_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_5_0= ruleEffect ) ) ( ',' ( (lv_effects_7_0= ruleEffect ) ) )* )? )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1965:2: () ( (lv_isImmediate_1_0= '#' ) )? ( (lv_delay_2_0= RULE_INT ) )? ( (lv_trigger_3_0= ruleBooleanExpression ) )? ( '/' ( (lv_effects_5_0= ruleEffect ) ) ( ',' ( (lv_effects_7_0= ruleEffect ) ) )* )?
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1965:2: ()
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1966:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getActionAccess().getActionAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getActionAccess().getActionAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1979:2: ( (lv_isImmediate_1_0= '#' ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==35) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1980:1: (lv_isImmediate_1_0= '#' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1980:1: (lv_isImmediate_1_0= '#' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1981:3: lv_isImmediate_1_0= '#'
                    {
                    lv_isImmediate_1_0=(Token)input.LT(1);
                    match(input,35,FollowSets000.FOLLOW_35_in_ruleAction2782); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getActionAccess().getIsImmediateNumberSignKeyword_1_0(), "isImmediate"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getActionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "isImmediate", true, "#", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2000:3: ( (lv_delay_2_0= RULE_INT ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_INT) ) {
                int LA49_1 = input.LA(2);

                if ( (LA49_1==65) ) {
                    switch ( input.LA(3) ) {
                        case 65:
                            {
                            switch ( input.LA(4) ) {
                                case 65:
                                    {
                                    int LA49_14 = input.LA(5);

                                    if ( (synpred59()) ) {
                                        alt49=1;
                                    }
                                    }
                                    break;
                                case RULE_INT:
                                    {
                                    int LA49_15 = input.LA(5);

                                    if ( (synpred59()) ) {
                                        alt49=1;
                                    }
                                    }
                                    break;
                                case RULE_FLOAT:
                                    {
                                    int LA49_16 = input.LA(5);

                                    if ( (synpred59()) ) {
                                        alt49=1;
                                    }
                                    }
                                    break;
                                case 19:
                                    {
                                    int LA49_17 = input.LA(5);

                                    if ( (synpred59()) ) {
                                        alt49=1;
                                    }
                                    }
                                    break;
                                case RULE_BOOLEAN:
                                    {
                                    int LA49_18 = input.LA(5);

                                    if ( (synpred59()) ) {
                                        alt49=1;
                                    }
                                    }
                                    break;
                                case 60:
                                    {
                                    int LA49_19 = input.LA(5);

                                    if ( (LA49_19==19) ) {
                                        switch ( input.LA(6) ) {
                                            case 60:
                                                {
                                                int LA49_30 = input.LA(7);

                                                if ( (LA49_30==19) ) {
                                                    int LA49_36 = input.LA(8);

                                                    if ( (synpred59()) ) {
                                                        alt49=1;
                                                    }
                                                }
                                                }
                                                break;
                                            case 68:
                                                {
                                                int LA49_31 = input.LA(7);

                                                if ( (LA49_31==RULE_ID) ) {
                                                    int LA49_37 = input.LA(8);

                                                    if ( (LA49_37==20) ) {
                                                        int LA49_38 = input.LA(9);

                                                        if ( (synpred59()) ) {
                                                            alt49=1;
                                                        }
                                                    }
                                                }
                                                }
                                                break;
                                            case RULE_ID:
                                                {
                                                int LA49_32 = input.LA(7);

                                                if ( (LA49_32==20) ) {
                                                    int LA49_38 = input.LA(8);

                                                    if ( (synpred59()) ) {
                                                        alt49=1;
                                                    }
                                                }
                                                }
                                                break;
                                        }

                                    }
                                    }
                                    break;
                                case 68:
                                    {
                                    int LA49_20 = input.LA(5);

                                    if ( (LA49_20==RULE_ID) ) {
                                        int LA49_26 = input.LA(6);

                                        if ( (synpred59()) ) {
                                            alt49=1;
                                        }
                                    }
                                    }
                                    break;
                                case RULE_ID:
                                    {
                                    int LA49_21 = input.LA(5);

                                    if ( (synpred59()) ) {
                                        alt49=1;
                                    }
                                    }
                                    break;
                                case RULE_HOSTCODE:
                                    {
                                    int LA49_22 = input.LA(5);

                                    if ( (synpred59()) ) {
                                        alt49=1;
                                    }
                                    }
                                    break;
                            }

                            }
                            break;
                        case RULE_INT:
                            {
                            int LA49_6 = input.LA(4);

                            if ( (synpred59()) ) {
                                alt49=1;
                            }
                            }
                            break;
                        case RULE_FLOAT:
                            {
                            int LA49_7 = input.LA(4);

                            if ( (synpred59()) ) {
                                alt49=1;
                            }
                            }
                            break;
                        case 19:
                            {
                            int LA49_8 = input.LA(4);

                            if ( (synpred59()) ) {
                                alt49=1;
                            }
                            }
                            break;
                        case RULE_BOOLEAN:
                            {
                            int LA49_9 = input.LA(4);

                            if ( (synpred59()) ) {
                                alt49=1;
                            }
                            }
                            break;
                        case 60:
                            {
                            int LA49_10 = input.LA(4);

                            if ( (LA49_10==19) ) {
                                switch ( input.LA(5) ) {
                                    case 60:
                                        {
                                        int LA49_27 = input.LA(6);

                                        if ( (LA49_27==19) ) {
                                            int LA49_33 = input.LA(7);

                                            if ( (synpred59()) ) {
                                                alt49=1;
                                            }
                                        }
                                        }
                                        break;
                                    case 68:
                                        {
                                        int LA49_28 = input.LA(6);

                                        if ( (LA49_28==RULE_ID) ) {
                                            int LA49_34 = input.LA(7);

                                            if ( (LA49_34==20) ) {
                                                int LA49_35 = input.LA(8);

                                                if ( (synpred59()) ) {
                                                    alt49=1;
                                                }
                                            }
                                        }
                                        }
                                        break;
                                    case RULE_ID:
                                        {
                                        int LA49_29 = input.LA(6);

                                        if ( (LA49_29==20) ) {
                                            int LA49_35 = input.LA(7);

                                            if ( (synpred59()) ) {
                                                alt49=1;
                                            }
                                        }
                                        }
                                        break;
                                }

                            }
                            }
                            break;
                        case 68:
                            {
                            int LA49_11 = input.LA(4);

                            if ( (LA49_11==RULE_ID) ) {
                                int LA49_24 = input.LA(5);

                                if ( (synpred59()) ) {
                                    alt49=1;
                                }
                            }
                            }
                            break;
                        case RULE_ID:
                            {
                            int LA49_12 = input.LA(4);

                            if ( (synpred59()) ) {
                                alt49=1;
                            }
                            }
                            break;
                        case RULE_HOSTCODE:
                            {
                            int LA49_13 = input.LA(4);

                            if ( (synpred59()) ) {
                                alt49=1;
                            }
                            }
                            break;
                    }

                }
                else if ( (LA49_1==EOF||LA49_1==RULE_ID||(LA49_1>=RULE_INT && LA49_1<=RULE_COMMENT_ANNOTATION)||LA49_1==15||LA49_1==17||LA49_1==19||(LA49_1>=21 && LA49_1<=24)||(LA49_1>=29 && LA49_1<=33)||LA49_1==36||(LA49_1>=38 && LA49_1<=40)||LA49_1==43||(LA49_1>=48 && LA49_1<=50)||LA49_1==60||LA49_1==63||LA49_1==68) ) {
                    alt49=1;
                }
            }
            switch (alt49) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2001:1: (lv_delay_2_0= RULE_INT )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2001:1: (lv_delay_2_0= RULE_INT )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2002:3: lv_delay_2_0= RULE_INT
                    {
                    lv_delay_2_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleAction2813); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getActionAccess().getDelayINTTerminalRuleCall_2_0(), "delay"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getActionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"delay",
                      	        		lv_delay_2_0, 
                      	        		"INT", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2024:3: ( (lv_trigger_3_0= ruleBooleanExpression ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID||(LA50_0>=RULE_INT && LA50_0<=RULE_BOOLEAN)||LA50_0==19||LA50_0==60||LA50_0==63||LA50_0==65||LA50_0==68) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2025:1: (lv_trigger_3_0= ruleBooleanExpression )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2025:1: (lv_trigger_3_0= ruleBooleanExpression )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2026:3: lv_trigger_3_0= ruleBooleanExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getActionAccess().getTriggerBooleanExpressionParserRuleCall_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanExpression_in_ruleAction2840);
                    lv_trigger_3_0=ruleBooleanExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getActionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"trigger",
                      	        		lv_trigger_3_0, 
                      	        		"BooleanExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2048:3: ( '/' ( (lv_effects_5_0= ruleEffect ) ) ( ',' ( (lv_effects_7_0= ruleEffect ) ) )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==36) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2048:5: '/' ( (lv_effects_5_0= ruleEffect ) ) ( ',' ( (lv_effects_7_0= ruleEffect ) ) )*
                    {
                    match(input,36,FollowSets000.FOLLOW_36_in_ruleAction2852); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getActionAccess().getSolidusKeyword_4_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2052:1: ( (lv_effects_5_0= ruleEffect ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2053:1: (lv_effects_5_0= ruleEffect )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2053:1: (lv_effects_5_0= ruleEffect )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2054:3: lv_effects_5_0= ruleEffect
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getActionAccess().getEffectsEffectParserRuleCall_4_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEffect_in_ruleAction2873);
                    lv_effects_5_0=ruleEffect();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getActionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"effects",
                      	        		lv_effects_5_0, 
                      	        		"Effect", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2076:2: ( ',' ( (lv_effects_7_0= ruleEffect ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==26) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2076:4: ',' ( (lv_effects_7_0= ruleEffect ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleAction2884); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getActionAccess().getCommaKeyword_4_2_0(), null); 
                    	          
                    	    }
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2080:1: ( (lv_effects_7_0= ruleEffect ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2081:1: (lv_effects_7_0= ruleEffect )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2081:1: (lv_effects_7_0= ruleEffect )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2082:3: lv_effects_7_0= ruleEffect
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getActionAccess().getEffectsEffectParserRuleCall_4_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleEffect_in_ruleAction2905);
                    	    lv_effects_7_0=ruleEffect();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getActionRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"effects",
                    	      	        		lv_effects_7_0, 
                    	      	        		"Effect", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);


                    }
                    break;

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


    // $ANTLR start entryRuleEffect
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2112:1: entryRuleEffect returns [EObject current=null] : iv_ruleEffect= ruleEffect EOF ;
    public final EObject entryRuleEffect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEffect = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2113:2: (iv_ruleEffect= ruleEffect EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2114:2: iv_ruleEffect= ruleEffect EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getEffectRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEffect_in_entryRuleEffect2945);
            iv_ruleEffect=ruleEffect();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleEffect; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEffect2955); if (failed) return current;

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
    // $ANTLR end entryRuleEffect


    // $ANTLR start ruleEffect
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2121:1: ruleEffect returns [EObject current=null] : (this_Emission_0= ruleEmission | this_Assignment_1= ruleAssignment | this_TextEffect_2= ruleTextEffect ) ;
    public final EObject ruleEffect() throws RecognitionException {
        EObject current = null;

        EObject this_Emission_0 = null;

        EObject this_Assignment_1 = null;

        EObject this_TextEffect_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2126:6: ( (this_Emission_0= ruleEmission | this_Assignment_1= ruleAssignment | this_TextEffect_2= ruleTextEffect ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2127:1: (this_Emission_0= ruleEmission | this_Assignment_1= ruleAssignment | this_TextEffect_2= ruleTextEffect )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2127:1: (this_Emission_0= ruleEmission | this_Assignment_1= ruleAssignment | this_TextEffect_2= ruleTextEffect )
            int alt53=3;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==41) ) {
                    alt53=2;
                }
                else if ( (LA53_1==EOF||LA53_1==RULE_COMMENT_ANNOTATION||LA53_1==15||LA53_1==17||LA53_1==19||(LA53_1>=21 && LA53_1<=24)||LA53_1==26||(LA53_1>=29 && LA53_1<=33)||(LA53_1>=37 && LA53_1<=40)||LA53_1==43||(LA53_1>=48 && LA53_1<=53)) ) {
                    alt53=1;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2127:1: (this_Emission_0= ruleEmission | this_Assignment_1= ruleAssignment | this_TextEffect_2= ruleTextEffect )", 53, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA53_0==RULE_HOSTCODE) ) {
                alt53=3;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2127:1: (this_Emission_0= ruleEmission | this_Assignment_1= ruleAssignment | this_TextEffect_2= ruleTextEffect )", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2128:2: this_Emission_0= ruleEmission
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getEffectAccess().getEmissionParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEmission_in_ruleEffect3005);
                    this_Emission_0=ruleEmission();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Emission_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2141:2: this_Assignment_1= ruleAssignment
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getEffectAccess().getAssignmentParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_ruleEffect3035);
                    this_Assignment_1=ruleAssignment();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Assignment_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2154:2: this_TextEffect_2= ruleTextEffect
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getEffectAccess().getTextEffectParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTextEffect_in_ruleEffect3065);
                    this_TextEffect_2=ruleTextEffect();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_TextEffect_2; 
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
    // $ANTLR end ruleEffect


    // $ANTLR start entryRuleEmission
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2173:1: entryRuleEmission returns [EObject current=null] : iv_ruleEmission= ruleEmission EOF ;
    public final EObject entryRuleEmission() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmission = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2174:2: (iv_ruleEmission= ruleEmission EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2175:2: iv_ruleEmission= ruleEmission EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getEmissionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEmission_in_entryRuleEmission3100);
            iv_ruleEmission=ruleEmission();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleEmission; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEmission3110); if (failed) return current;

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
    // $ANTLR end entryRuleEmission


    // $ANTLR start ruleEmission
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2182:1: ruleEmission returns [EObject current=null] : ( ( ( RULE_ID ) ) ( '(' ( (lv_newValue_2_0= ruleExpression ) ) ')' )? ) ;
    public final EObject ruleEmission() throws RecognitionException {
        EObject current = null;

        EObject lv_newValue_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2187:6: ( ( ( ( RULE_ID ) ) ( '(' ( (lv_newValue_2_0= ruleExpression ) ) ')' )? ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2188:1: ( ( ( RULE_ID ) ) ( '(' ( (lv_newValue_2_0= ruleExpression ) ) ')' )? )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2188:1: ( ( ( RULE_ID ) ) ( '(' ( (lv_newValue_2_0= ruleExpression ) ) ')' )? )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2188:2: ( ( RULE_ID ) ) ( '(' ( (lv_newValue_2_0= ruleExpression ) ) ')' )?
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2188:2: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2189:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2189:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2190:3: RULE_ID
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getEmissionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEmission3157); if (failed) return current;
            if ( backtracking==0 ) {

              		createLeafNode(grammarAccess.getEmissionAccess().getSignalSignalCrossReference_0_0(), "signal"); 
              	
            }

            }


            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2205:2: ( '(' ( (lv_newValue_2_0= ruleExpression ) ) ')' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==19) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2205:4: '(' ( (lv_newValue_2_0= ruleExpression ) ) ')'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleEmission3168); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getEmissionAccess().getLeftParenthesisKeyword_1_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2209:1: ( (lv_newValue_2_0= ruleExpression ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2210:1: (lv_newValue_2_0= ruleExpression )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2210:1: (lv_newValue_2_0= ruleExpression )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2211:3: lv_newValue_2_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getEmissionAccess().getNewValueExpressionParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleEmission3189);
                    lv_newValue_2_0=ruleExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getEmissionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"newValue",
                      	        		lv_newValue_2_0, 
                      	        		"Expression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,20,FollowSets000.FOLLOW_20_in_ruleEmission3199); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getEmissionAccess().getRightParenthesisKeyword_1_2(), null); 
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleEmission


    // $ANTLR start entryRuleAssignment
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2245:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2246:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2247:2: iv_ruleAssignment= ruleAssignment EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAssignmentRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_entryRuleAssignment3237);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAssignment; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignment3247); if (failed) return current;

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
    // $ANTLR end entryRuleAssignment


    // $ANTLR start ruleAssignment
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2254:1: ruleAssignment returns [EObject current=null] : ( ( ( RULE_ID ) ) ':=' ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2259:6: ( ( ( ( RULE_ID ) ) ':=' ( (lv_expression_2_0= ruleExpression ) ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2260:1: ( ( ( RULE_ID ) ) ':=' ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2260:1: ( ( ( RULE_ID ) ) ':=' ( (lv_expression_2_0= ruleExpression ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2260:2: ( ( RULE_ID ) ) ':=' ( (lv_expression_2_0= ruleExpression ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2260:2: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2261:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2261:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2262:3: RULE_ID
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getAssignmentRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignment3294); if (failed) return current;
            if ( backtracking==0 ) {

              		createLeafNode(grammarAccess.getAssignmentAccess().getVariableVariableCrossReference_0_0(), "variable"); 
              	
            }

            }


            }

            match(input,41,FollowSets000.FOLLOW_41_in_ruleAssignment3304); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getAssignmentAccess().getColonEqualsSignKeyword_1(), null); 
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2281:1: ( (lv_expression_2_0= ruleExpression ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2282:1: (lv_expression_2_0= ruleExpression )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2282:1: (lv_expression_2_0= ruleExpression )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2283:3: lv_expression_2_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getAssignmentAccess().getExpressionExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleAssignment3325);
            lv_expression_2_0=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getAssignmentRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_2_0, 
              	        		"Expression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

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
    // $ANTLR end ruleAssignment


    // $ANTLR start entryRuleTextEffect
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2313:1: entryRuleTextEffect returns [EObject current=null] : iv_ruleTextEffect= ruleTextEffect EOF ;
    public final EObject entryRuleTextEffect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextEffect = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2314:2: (iv_ruleTextEffect= ruleTextEffect EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2315:2: iv_ruleTextEffect= ruleTextEffect EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTextEffectRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTextEffect_in_entryRuleTextEffect3361);
            iv_ruleTextEffect=ruleTextEffect();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTextEffect; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTextEffect3371); if (failed) return current;

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
    // $ANTLR end entryRuleTextEffect


    // $ANTLR start ruleTextEffect
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2322:1: ruleTextEffect returns [EObject current=null] : ( ( (lv_code_0_0= RULE_HOSTCODE ) ) ( '(' ( (lv_type_2_0= RULE_ID ) ) ')' )? ) ;
    public final EObject ruleTextEffect() throws RecognitionException {
        EObject current = null;

        Token lv_code_0_0=null;
        Token lv_type_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2327:6: ( ( ( (lv_code_0_0= RULE_HOSTCODE ) ) ( '(' ( (lv_type_2_0= RULE_ID ) ) ')' )? ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2328:1: ( ( (lv_code_0_0= RULE_HOSTCODE ) ) ( '(' ( (lv_type_2_0= RULE_ID ) ) ')' )? )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2328:1: ( ( (lv_code_0_0= RULE_HOSTCODE ) ) ( '(' ( (lv_type_2_0= RULE_ID ) ) ')' )? )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2328:2: ( (lv_code_0_0= RULE_HOSTCODE ) ) ( '(' ( (lv_type_2_0= RULE_ID ) ) ')' )?
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2328:2: ( (lv_code_0_0= RULE_HOSTCODE ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2329:1: (lv_code_0_0= RULE_HOSTCODE )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2329:1: (lv_code_0_0= RULE_HOSTCODE )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2330:3: lv_code_0_0= RULE_HOSTCODE
            {
            lv_code_0_0=(Token)input.LT(1);
            match(input,RULE_HOSTCODE,FollowSets000.FOLLOW_RULE_HOSTCODE_in_ruleTextEffect3413); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getTextEffectAccess().getCodeHOSTCODETerminalRuleCall_0_0(), "code"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTextEffectRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"code",
              	        		lv_code_0_0, 
              	        		"HOSTCODE", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2352:2: ( '(' ( (lv_type_2_0= RULE_ID ) ) ')' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==19) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2352:4: '(' ( (lv_type_2_0= RULE_ID ) ) ')'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleTextEffect3429); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTextEffectAccess().getLeftParenthesisKeyword_1_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2356:1: ( (lv_type_2_0= RULE_ID ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2357:1: (lv_type_2_0= RULE_ID )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2357:1: (lv_type_2_0= RULE_ID )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2358:3: lv_type_2_0= RULE_ID
                    {
                    lv_type_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTextEffect3446); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getTextEffectAccess().getTypeIDTerminalRuleCall_1_1_0(), "type"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getTextEffectRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_2_0, 
                      	        		"ID", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    match(input,20,FollowSets000.FOLLOW_20_in_ruleTextEffect3461); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTextEffectAccess().getRightParenthesisKeyword_1_2(), null); 
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleTextEffect


    // $ANTLR start entryRuleExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2394:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2395:2: (iv_ruleExpression= ruleExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2396:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression3501);
            iv_ruleExpression=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression3511); if (failed) return current;

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
    // $ANTLR end entryRuleExpression


    // $ANTLR start ruleExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2403:1: ruleExpression returns [EObject current=null] : (this_BooleanExpression_0= ruleBooleanExpression | this_ValuedExpression_1= ruleValuedExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanExpression_0 = null;

        EObject this_ValuedExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2408:6: ( (this_BooleanExpression_0= ruleBooleanExpression | this_ValuedExpression_1= ruleValuedExpression ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2409:1: (this_BooleanExpression_0= ruleBooleanExpression | this_ValuedExpression_1= ruleValuedExpression )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2409:1: (this_BooleanExpression_0= ruleBooleanExpression | this_ValuedExpression_1= ruleValuedExpression )
            int alt56=2;
            switch ( input.LA(1) ) {
            case 65:
                {
                int LA56_1 = input.LA(2);

                if ( (synpred67()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2409:1: (this_BooleanExpression_0= ruleBooleanExpression | this_ValuedExpression_1= ruleValuedExpression )", 56, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA56_2 = input.LA(2);

                if ( (synpred67()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2409:1: (this_BooleanExpression_0= ruleBooleanExpression | this_ValuedExpression_1= ruleValuedExpression )", 56, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_FLOAT:
                {
                int LA56_3 = input.LA(2);

                if ( (synpred67()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2409:1: (this_BooleanExpression_0= ruleBooleanExpression | this_ValuedExpression_1= ruleValuedExpression )", 56, 3, input);

                    throw nvae;
                }
                }
                break;
            case 19:
                {
                int LA56_4 = input.LA(2);

                if ( (synpred67()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2409:1: (this_BooleanExpression_0= ruleBooleanExpression | this_ValuedExpression_1= ruleValuedExpression )", 56, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_BOOLEAN:
                {
                int LA56_5 = input.LA(2);

                if ( (synpred67()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2409:1: (this_BooleanExpression_0= ruleBooleanExpression | this_ValuedExpression_1= ruleValuedExpression )", 56, 5, input);

                    throw nvae;
                }
                }
                break;
            case 60:
                {
                int LA56_6 = input.LA(2);

                if ( (synpred67()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2409:1: (this_BooleanExpression_0= ruleBooleanExpression | this_ValuedExpression_1= ruleValuedExpression )", 56, 6, input);

                    throw nvae;
                }
                }
                break;
            case 68:
                {
                int LA56_7 = input.LA(2);

                if ( (synpred67()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2409:1: (this_BooleanExpression_0= ruleBooleanExpression | this_ValuedExpression_1= ruleValuedExpression )", 56, 7, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA56_8 = input.LA(2);

                if ( (synpred67()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2409:1: (this_BooleanExpression_0= ruleBooleanExpression | this_ValuedExpression_1= ruleValuedExpression )", 56, 8, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HOSTCODE:
                {
                int LA56_9 = input.LA(2);

                if ( (synpred67()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2409:1: (this_BooleanExpression_0= ruleBooleanExpression | this_ValuedExpression_1= ruleValuedExpression )", 56, 9, input);

                    throw nvae;
                }
                }
                break;
            case 63:
                {
                alt56=1;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2409:1: (this_BooleanExpression_0= ruleBooleanExpression | this_ValuedExpression_1= ruleValuedExpression )", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2410:2: this_BooleanExpression_0= ruleBooleanExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getBooleanExpressionParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanExpression_in_ruleExpression3561);
                    this_BooleanExpression_0=ruleBooleanExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_BooleanExpression_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2423:2: this_ValuedExpression_1= ruleValuedExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getValuedExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValuedExpression_in_ruleExpression3591);
                    this_ValuedExpression_1=ruleValuedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_ValuedExpression_1; 
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
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleBooleanExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2442:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2443:2: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2444:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBooleanExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression3626);
            iv_ruleBooleanExpression=ruleBooleanExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBooleanExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanExpression3636); if (failed) return current;

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
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2451:1: ruleBooleanExpression returns [EObject current=null] : this_OrExpression_0= ruleOrExpression ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpression_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2456:6: (this_OrExpression_0= ruleOrExpression )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2458:2: this_OrExpression_0= ruleOrExpression
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getBooleanExpressionAccess().getOrExpressionParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleOrExpression_in_ruleBooleanExpression3685);
            this_OrExpression_0=ruleOrExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_OrExpression_0; 
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


    // $ANTLR start entryRuleOrExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2477:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2478:2: (iv_ruleOrExpression= ruleOrExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2479:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOrExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOrExpression_in_entryRuleOrExpression3719);
            iv_ruleOrExpression=ruleOrExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOrExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOrExpression3729); if (failed) return current;

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
    // $ANTLR end entryRuleOrExpression


    // $ANTLR start ruleOrExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2486:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= ruleOrOperator ) ) ( (lv_subExpressions_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AndExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_subExpressions_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2491:6: ( (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= ruleOrOperator ) ) ( (lv_subExpressions_3_0= ruleAndExpression ) ) )* ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2492:1: (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= ruleOrOperator ) ) ( (lv_subExpressions_3_0= ruleAndExpression ) ) )* )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2492:1: (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= ruleOrOperator ) ) ( (lv_subExpressions_3_0= ruleAndExpression ) ) )* )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2493:2: this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= ruleOrOperator ) ) ( (lv_subExpressions_3_0= ruleAndExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleAndExpression_in_ruleOrExpression3779);
            this_AndExpression_0=ruleAndExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_AndExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2504:1: ( () ( (lv_operator_2_0= ruleOrOperator ) ) ( (lv_subExpressions_3_0= ruleAndExpression ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==61) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2504:2: () ( (lv_operator_2_0= ruleOrOperator ) ) ( (lv_subExpressions_3_0= ruleAndExpression ) )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2504:2: ()
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2505:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getOrExpressionAccess().getOperatorExpressionSubExpressionsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "subExpressions", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getOrExpressionAccess().getOperatorExpressionSubExpressionsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2523:2: ( (lv_operator_2_0= ruleOrOperator ) )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2524:1: (lv_operator_2_0= ruleOrOperator )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2524:1: (lv_operator_2_0= ruleOrOperator )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2525:3: lv_operator_2_0= ruleOrOperator
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getOrExpressionAccess().getOperatorOrOperatorEnumRuleCall_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleOrOperator_in_ruleOrExpression3812);
            	    lv_operator_2_0=ruleOrOperator();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getOrExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"operator",
            	      	        		lv_operator_2_0, 
            	      	        		"OrOperator", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2547:2: ( (lv_subExpressions_3_0= ruleAndExpression ) )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2548:1: (lv_subExpressions_3_0= ruleAndExpression )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2548:1: (lv_subExpressions_3_0= ruleAndExpression )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2549:3: lv_subExpressions_3_0= ruleAndExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getOrExpressionAccess().getSubExpressionsAndExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAndExpression_in_ruleOrExpression3833);
            	    lv_subExpressions_3_0=ruleAndExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getOrExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"subExpressions",
            	      	        		lv_subExpressions_3_0, 
            	      	        		"AndExpression", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
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
    // $ANTLR end ruleOrExpression


    // $ANTLR start entryRuleAndExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2579:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2580:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2581:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAndExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAndExpression_in_entryRuleAndExpression3871);
            iv_ruleAndExpression=ruleAndExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAndExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAndExpression3881); if (failed) return current;

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
    // $ANTLR end entryRuleAndExpression


    // $ANTLR start ruleAndExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2588:1: ruleAndExpression returns [EObject current=null] : (this_CompareOperation_0= ruleCompareOperation ( () ( (lv_operator_2_0= ruleAndOperator ) ) ( (lv_subExpressions_3_0= ruleCompareOperation ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CompareOperation_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_subExpressions_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2593:6: ( (this_CompareOperation_0= ruleCompareOperation ( () ( (lv_operator_2_0= ruleAndOperator ) ) ( (lv_subExpressions_3_0= ruleCompareOperation ) ) )* ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2594:1: (this_CompareOperation_0= ruleCompareOperation ( () ( (lv_operator_2_0= ruleAndOperator ) ) ( (lv_subExpressions_3_0= ruleCompareOperation ) ) )* )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2594:1: (this_CompareOperation_0= ruleCompareOperation ( () ( (lv_operator_2_0= ruleAndOperator ) ) ( (lv_subExpressions_3_0= ruleCompareOperation ) ) )* )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2595:2: this_CompareOperation_0= ruleCompareOperation ( () ( (lv_operator_2_0= ruleAndOperator ) ) ( (lv_subExpressions_3_0= ruleCompareOperation ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getCompareOperationParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleCompareOperation_in_ruleAndExpression3931);
            this_CompareOperation_0=ruleCompareOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_CompareOperation_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2606:1: ( () ( (lv_operator_2_0= ruleAndOperator ) ) ( (lv_subExpressions_3_0= ruleCompareOperation ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==62) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2606:2: () ( (lv_operator_2_0= ruleAndOperator ) ) ( (lv_subExpressions_3_0= ruleCompareOperation ) )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2606:2: ()
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2607:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getAndExpressionAccess().getOperatorExpressionSubExpressionsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "subExpressions", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getAndExpressionAccess().getOperatorExpressionSubExpressionsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2625:2: ( (lv_operator_2_0= ruleAndOperator ) )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2626:1: (lv_operator_2_0= ruleAndOperator )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2626:1: (lv_operator_2_0= ruleAndOperator )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2627:3: lv_operator_2_0= ruleAndOperator
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getOperatorAndOperatorEnumRuleCall_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAndOperator_in_ruleAndExpression3964);
            	    lv_operator_2_0=ruleAndOperator();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getAndExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"operator",
            	      	        		lv_operator_2_0, 
            	      	        		"AndOperator", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2649:2: ( (lv_subExpressions_3_0= ruleCompareOperation ) )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2650:1: (lv_subExpressions_3_0= ruleCompareOperation )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2650:1: (lv_subExpressions_3_0= ruleCompareOperation )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2651:3: lv_subExpressions_3_0= ruleCompareOperation
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getSubExpressionsCompareOperationParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleCompareOperation_in_ruleAndExpression3985);
            	    lv_subExpressions_3_0=ruleCompareOperation();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getAndExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"subExpressions",
            	      	        		lv_subExpressions_3_0, 
            	      	        		"CompareOperation", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
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
    // $ANTLR end ruleAndExpression


    // $ANTLR start entryRuleCompareOperation
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2681:1: entryRuleCompareOperation returns [EObject current=null] : iv_ruleCompareOperation= ruleCompareOperation EOF ;
    public final EObject entryRuleCompareOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompareOperation = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2682:2: (iv_ruleCompareOperation= ruleCompareOperation EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2683:2: iv_ruleCompareOperation= ruleCompareOperation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCompareOperationRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCompareOperation_in_entryRuleCompareOperation4023);
            iv_ruleCompareOperation=ruleCompareOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCompareOperation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompareOperation4033); if (failed) return current;

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
    // $ANTLR end entryRuleCompareOperation


    // $ANTLR start ruleCompareOperation
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2690:1: ruleCompareOperation returns [EObject current=null] : ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression ) ;
    public final EObject ruleCompareOperation() throws RecognitionException {
        EObject current = null;

        EObject this_NotOrValuedExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_subExpressions_3_0 = null;

        EObject this_NotExpression_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2695:6: ( ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )
            int alt59=2;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case RULE_FLOAT:
            case 65:
                {
                alt59=1;
                }
                break;
            case 19:
                {
                int LA59_2 = input.LA(2);

                if ( (synpred70()) ) {
                    alt59=1;
                }
                else if ( (true) ) {
                    alt59=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_BOOLEAN:
                {
                switch ( input.LA(2) ) {
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 64:
                case 65:
                case 66:
                case 67:
                    {
                    alt59=1;
                    }
                    break;
                case 16:
                    {
                    switch ( input.LA(3) ) {
                    case 42:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                        {
                        alt59=2;
                        }
                        break;
                    case RULE_ID:
                        {
                        int LA59_22 = input.LA(4);

                        if ( (LA59_22==EOF||LA59_22==26||LA59_22==44) ) {
                            alt59=2;
                        }
                        else if ( ((LA59_22>=54 && LA59_22<=59)||(LA59_22>=64 && LA59_22<=67)) ) {
                            alt59=1;
                        }
                        else {
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 22, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_INT:
                    case RULE_HOSTCODE:
                    case RULE_FLOAT:
                    case RULE_BOOLEAN:
                    case 19:
                    case 60:
                    case 65:
                    case 68:
                        {
                        alt59=1;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 10, input);

                        throw nvae;
                    }

                    }
                    break;
                case EOF:
                case RULE_COMMENT_ANNOTATION:
                case 15:
                case 17:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 26:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 43:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 61:
                case 62:
                    {
                    alt59=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 3, input);

                    throw nvae;
                }

                }
                break;
            case 60:
                {
                int LA59_4 = input.LA(2);

                if ( (LA59_4==19) ) {
                    switch ( input.LA(3) ) {
                    case 60:
                        {
                        int LA59_23 = input.LA(4);

                        if ( (LA59_23==19) ) {
                            int LA59_30 = input.LA(5);

                            if ( (synpred70()) ) {
                                alt59=1;
                            }
                            else if ( (true) ) {
                                alt59=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 30, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 23, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 68:
                        {
                        int LA59_24 = input.LA(4);

                        if ( (LA59_24==RULE_ID) ) {
                            int LA59_31 = input.LA(5);

                            if ( (LA59_31==20) ) {
                                switch ( input.LA(6) ) {
                                case 54:
                                case 55:
                                case 56:
                                case 57:
                                case 58:
                                case 59:
                                case 64:
                                case 65:
                                case 66:
                                case 67:
                                    {
                                    alt59=1;
                                    }
                                    break;
                                case 16:
                                    {
                                    switch ( input.LA(7) ) {
                                    case 42:
                                    case 69:
                                    case 70:
                                    case 71:
                                    case 72:
                                    case 73:
                                    case 74:
                                        {
                                        alt59=2;
                                        }
                                        break;
                                    case RULE_ID:
                                        {
                                        int LA59_22 = input.LA(8);

                                        if ( (LA59_22==EOF||LA59_22==26||LA59_22==44) ) {
                                            alt59=2;
                                        }
                                        else if ( ((LA59_22>=54 && LA59_22<=59)||(LA59_22>=64 && LA59_22<=67)) ) {
                                            alt59=1;
                                        }
                                        else {
                                            if (backtracking>0) {failed=true; return current;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 22, input);

                                            throw nvae;
                                        }
                                        }
                                        break;
                                    case RULE_INT:
                                    case RULE_HOSTCODE:
                                    case RULE_FLOAT:
                                    case RULE_BOOLEAN:
                                    case 19:
                                    case 60:
                                    case 65:
                                    case 68:
                                        {
                                        alt59=1;
                                        }
                                        break;
                                    default:
                                        if (backtracking>0) {failed=true; return current;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 10, input);

                                        throw nvae;
                                    }

                                    }
                                    break;
                                case EOF:
                                case RULE_COMMENT_ANNOTATION:
                                case 15:
                                case 17:
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 26:
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 36:
                                case 37:
                                case 38:
                                case 39:
                                case 40:
                                case 43:
                                case 48:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 53:
                                case 61:
                                case 62:
                                    {
                                    alt59=2;
                                    }
                                    break;
                                default:
                                    if (backtracking>0) {failed=true; return current;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 32, input);

                                    throw nvae;
                                }

                            }
                            else {
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 31, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 24, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                        {
                        int LA59_25 = input.LA(4);

                        if ( (LA59_25==20) ) {
                            switch ( input.LA(5) ) {
                            case 54:
                            case 55:
                            case 56:
                            case 57:
                            case 58:
                            case 59:
                            case 64:
                            case 65:
                            case 66:
                            case 67:
                                {
                                alt59=1;
                                }
                                break;
                            case 16:
                                {
                                switch ( input.LA(6) ) {
                                case 42:
                                case 69:
                                case 70:
                                case 71:
                                case 72:
                                case 73:
                                case 74:
                                    {
                                    alt59=2;
                                    }
                                    break;
                                case RULE_ID:
                                    {
                                    int LA59_22 = input.LA(7);

                                    if ( (LA59_22==EOF||LA59_22==26||LA59_22==44) ) {
                                        alt59=2;
                                    }
                                    else if ( ((LA59_22>=54 && LA59_22<=59)||(LA59_22>=64 && LA59_22<=67)) ) {
                                        alt59=1;
                                    }
                                    else {
                                        if (backtracking>0) {failed=true; return current;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 22, input);

                                        throw nvae;
                                    }
                                    }
                                    break;
                                case RULE_INT:
                                case RULE_HOSTCODE:
                                case RULE_FLOAT:
                                case RULE_BOOLEAN:
                                case 19:
                                case 60:
                                case 65:
                                case 68:
                                    {
                                    alt59=1;
                                    }
                                    break;
                                default:
                                    if (backtracking>0) {failed=true; return current;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 10, input);

                                    throw nvae;
                                }

                                }
                                break;
                            case EOF:
                            case RULE_COMMENT_ANNOTATION:
                            case 15:
                            case 17:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 26:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 43:
                            case 48:
                            case 49:
                            case 50:
                            case 51:
                            case 52:
                            case 53:
                            case 61:
                            case 62:
                                {
                                alt59=2;
                                }
                                break;
                            default:
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 32, input);

                                throw nvae;
                            }

                        }
                        else {
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 25, input);

                            throw nvae;
                        }
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 12, input);

                        throw nvae;
                    }

                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 4, input);

                    throw nvae;
                }
                }
                break;
            case 68:
                {
                int LA59_5 = input.LA(2);

                if ( (LA59_5==RULE_ID) ) {
                    switch ( input.LA(3) ) {
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        {
                        alt59=1;
                        }
                        break;
                    case 16:
                        {
                        switch ( input.LA(4) ) {
                        case 42:
                        case 69:
                        case 70:
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                            {
                            alt59=2;
                            }
                            break;
                        case RULE_ID:
                            {
                            int LA59_22 = input.LA(5);

                            if ( (LA59_22==EOF||LA59_22==26||LA59_22==44) ) {
                                alt59=2;
                            }
                            else if ( ((LA59_22>=54 && LA59_22<=59)||(LA59_22>=64 && LA59_22<=67)) ) {
                                alt59=1;
                            }
                            else {
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 22, input);

                                throw nvae;
                            }
                            }
                            break;
                        case RULE_INT:
                        case RULE_HOSTCODE:
                        case RULE_FLOAT:
                        case RULE_BOOLEAN:
                        case 19:
                        case 60:
                        case 65:
                        case 68:
                            {
                            alt59=1;
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 10, input);

                            throw nvae;
                        }

                        }
                        break;
                    case EOF:
                    case RULE_COMMENT_ANNOTATION:
                    case 15:
                    case 17:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 26:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 43:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 61:
                    case 62:
                        {
                        alt59=2;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 13, input);

                        throw nvae;
                    }

                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 5, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 64:
                case 65:
                case 66:
                case 67:
                    {
                    alt59=1;
                    }
                    break;
                case 16:
                    {
                    switch ( input.LA(3) ) {
                    case 42:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                        {
                        alt59=2;
                        }
                        break;
                    case RULE_ID:
                        {
                        int LA59_22 = input.LA(4);

                        if ( (LA59_22==EOF||LA59_22==26||LA59_22==44) ) {
                            alt59=2;
                        }
                        else if ( ((LA59_22>=54 && LA59_22<=59)||(LA59_22>=64 && LA59_22<=67)) ) {
                            alt59=1;
                        }
                        else {
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 22, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_INT:
                    case RULE_HOSTCODE:
                    case RULE_FLOAT:
                    case RULE_BOOLEAN:
                    case 19:
                    case 60:
                    case 65:
                    case 68:
                        {
                        alt59=1;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 10, input);

                        throw nvae;
                    }

                    }
                    break;
                case EOF:
                case RULE_COMMENT_ANNOTATION:
                case 15:
                case 17:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 26:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 43:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 61:
                case 62:
                    {
                    alt59=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 6, input);

                    throw nvae;
                }

                }
                break;
            case RULE_HOSTCODE:
                {
                switch ( input.LA(2) ) {
                case 19:
                    {
                    int LA59_14 = input.LA(3);

                    if ( (LA59_14==RULE_ID) ) {
                        int LA59_26 = input.LA(4);

                        if ( (LA59_26==20) ) {
                            switch ( input.LA(5) ) {
                            case EOF:
                            case RULE_COMMENT_ANNOTATION:
                            case 15:
                            case 17:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 26:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 43:
                            case 48:
                            case 49:
                            case 50:
                            case 51:
                            case 52:
                            case 53:
                            case 61:
                            case 62:
                                {
                                alt59=2;
                                }
                                break;
                            case 16:
                                {
                                switch ( input.LA(6) ) {
                                case 42:
                                case 69:
                                case 70:
                                case 71:
                                case 72:
                                case 73:
                                case 74:
                                    {
                                    alt59=2;
                                    }
                                    break;
                                case RULE_ID:
                                    {
                                    int LA59_22 = input.LA(7);

                                    if ( (LA59_22==EOF||LA59_22==26||LA59_22==44) ) {
                                        alt59=2;
                                    }
                                    else if ( ((LA59_22>=54 && LA59_22<=59)||(LA59_22>=64 && LA59_22<=67)) ) {
                                        alt59=1;
                                    }
                                    else {
                                        if (backtracking>0) {failed=true; return current;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 22, input);

                                        throw nvae;
                                    }
                                    }
                                    break;
                                case RULE_INT:
                                case RULE_HOSTCODE:
                                case RULE_FLOAT:
                                case RULE_BOOLEAN:
                                case 19:
                                case 60:
                                case 65:
                                case 68:
                                    {
                                    alt59=1;
                                    }
                                    break;
                                default:
                                    if (backtracking>0) {failed=true; return current;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 10, input);

                                    throw nvae;
                                }

                                }
                                break;
                            case 54:
                            case 55:
                            case 56:
                            case 57:
                            case 58:
                            case 59:
                            case 64:
                            case 65:
                            case 66:
                            case 67:
                                {
                                alt59=1;
                                }
                                break;
                            default:
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 33, input);

                                throw nvae;
                            }

                        }
                        else {
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 26, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 14, input);

                        throw nvae;
                    }
                    }
                    break;
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 64:
                case 65:
                case 66:
                case 67:
                    {
                    alt59=1;
                    }
                    break;
                case 16:
                    {
                    switch ( input.LA(3) ) {
                    case 42:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                        {
                        alt59=2;
                        }
                        break;
                    case RULE_ID:
                        {
                        int LA59_22 = input.LA(4);

                        if ( (LA59_22==EOF||LA59_22==26||LA59_22==44) ) {
                            alt59=2;
                        }
                        else if ( ((LA59_22>=54 && LA59_22<=59)||(LA59_22>=64 && LA59_22<=67)) ) {
                            alt59=1;
                        }
                        else {
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 22, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_INT:
                    case RULE_HOSTCODE:
                    case RULE_FLOAT:
                    case RULE_BOOLEAN:
                    case 19:
                    case 60:
                    case 65:
                    case 68:
                        {
                        alt59=1;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 10, input);

                        throw nvae;
                    }

                    }
                    break;
                case EOF:
                case RULE_COMMENT_ANNOTATION:
                case 15:
                case 17:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 26:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 43:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 61:
                case 62:
                    {
                    alt59=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 7, input);

                    throw nvae;
                }

                }
                break;
            case 63:
                {
                switch ( input.LA(2) ) {
                case 63:
                    {
                    int LA59_15 = input.LA(3);

                    if ( (synpred70()) ) {
                        alt59=1;
                    }
                    else if ( (true) ) {
                        alt59=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 15, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_BOOLEAN:
                    {
                    int LA59_16 = input.LA(3);

                    if ( ((LA59_16>=54 && LA59_16<=59)) ) {
                        alt59=1;
                    }
                    else if ( (LA59_16==EOF||LA59_16==RULE_COMMENT_ANNOTATION||(LA59_16>=15 && LA59_16<=17)||(LA59_16>=20 && LA59_16<=24)||LA59_16==26||(LA59_16>=29 && LA59_16<=33)||(LA59_16>=36 && LA59_16<=40)||LA59_16==43||(LA59_16>=48 && LA59_16<=53)||(LA59_16>=61 && LA59_16<=62)) ) {
                        alt59=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 16, input);

                        throw nvae;
                    }
                    }
                    break;
                case 60:
                    {
                    int LA59_17 = input.LA(3);

                    if ( (LA59_17==19) ) {
                        switch ( input.LA(4) ) {
                        case 60:
                            {
                            int LA59_34 = input.LA(5);

                            if ( (LA59_34==19) ) {
                                int LA59_38 = input.LA(6);

                                if ( (synpred70()) ) {
                                    alt59=1;
                                }
                                else if ( (true) ) {
                                    alt59=2;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return current;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 38, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 34, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 68:
                            {
                            int LA59_35 = input.LA(5);

                            if ( (LA59_35==RULE_ID) ) {
                                int LA59_39 = input.LA(6);

                                if ( (LA59_39==20) ) {
                                    int LA59_40 = input.LA(7);

                                    if ( (LA59_40==EOF||LA59_40==RULE_COMMENT_ANNOTATION||(LA59_40>=15 && LA59_40<=17)||(LA59_40>=20 && LA59_40<=24)||LA59_40==26||(LA59_40>=29 && LA59_40<=33)||(LA59_40>=36 && LA59_40<=40)||LA59_40==43||(LA59_40>=48 && LA59_40<=53)||(LA59_40>=61 && LA59_40<=62)) ) {
                                        alt59=2;
                                    }
                                    else if ( ((LA59_40>=54 && LA59_40<=59)) ) {
                                        alt59=1;
                                    }
                                    else {
                                        if (backtracking>0) {failed=true; return current;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 40, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    if (backtracking>0) {failed=true; return current;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 39, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 35, input);

                                throw nvae;
                            }
                            }
                            break;
                        case RULE_ID:
                            {
                            int LA59_36 = input.LA(5);

                            if ( (LA59_36==20) ) {
                                int LA59_40 = input.LA(6);

                                if ( (LA59_40==EOF||LA59_40==RULE_COMMENT_ANNOTATION||(LA59_40>=15 && LA59_40<=17)||(LA59_40>=20 && LA59_40<=24)||LA59_40==26||(LA59_40>=29 && LA59_40<=33)||(LA59_40>=36 && LA59_40<=40)||LA59_40==43||(LA59_40>=48 && LA59_40<=53)||(LA59_40>=61 && LA59_40<=62)) ) {
                                    alt59=2;
                                }
                                else if ( ((LA59_40>=54 && LA59_40<=59)) ) {
                                    alt59=1;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return current;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 40, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 36, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 27, input);

                            throw nvae;
                        }

                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 17, input);

                        throw nvae;
                    }
                    }
                    break;
                case 68:
                    {
                    int LA59_18 = input.LA(3);

                    if ( (LA59_18==RULE_ID) ) {
                        int LA59_28 = input.LA(4);

                        if ( ((LA59_28>=54 && LA59_28<=59)) ) {
                            alt59=1;
                        }
                        else if ( (LA59_28==EOF||LA59_28==RULE_COMMENT_ANNOTATION||(LA59_28>=15 && LA59_28<=17)||(LA59_28>=20 && LA59_28<=24)||LA59_28==26||(LA59_28>=29 && LA59_28<=33)||(LA59_28>=36 && LA59_28<=40)||LA59_28==43||(LA59_28>=48 && LA59_28<=53)||(LA59_28>=61 && LA59_28<=62)) ) {
                            alt59=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 28, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 18, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_ID:
                    {
                    int LA59_19 = input.LA(3);

                    if ( ((LA59_19>=54 && LA59_19<=59)) ) {
                        alt59=1;
                    }
                    else if ( (LA59_19==EOF||LA59_19==RULE_COMMENT_ANNOTATION||(LA59_19>=15 && LA59_19<=17)||(LA59_19>=20 && LA59_19<=24)||LA59_19==26||(LA59_19>=29 && LA59_19<=33)||(LA59_19>=36 && LA59_19<=40)||LA59_19==43||(LA59_19>=48 && LA59_19<=53)||(LA59_19>=61 && LA59_19<=62)) ) {
                        alt59=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 19, input);

                        throw nvae;
                    }
                    }
                    break;
                case 19:
                    {
                    int LA59_20 = input.LA(3);

                    if ( (synpred70()) ) {
                        alt59=1;
                    }
                    else if ( (true) ) {
                        alt59=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 20, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_HOSTCODE:
                    {
                    switch ( input.LA(3) ) {
                    case 19:
                        {
                        int LA59_29 = input.LA(4);

                        if ( (LA59_29==RULE_ID) ) {
                            int LA59_37 = input.LA(5);

                            if ( (LA59_37==20) ) {
                                int LA59_41 = input.LA(6);

                                if ( (LA59_41==EOF||LA59_41==RULE_COMMENT_ANNOTATION||(LA59_41>=15 && LA59_41<=17)||(LA59_41>=20 && LA59_41<=24)||LA59_41==26||(LA59_41>=29 && LA59_41<=33)||(LA59_41>=36 && LA59_41<=40)||LA59_41==43||(LA59_41>=48 && LA59_41<=53)||(LA59_41>=61 && LA59_41<=62)) ) {
                                    alt59=2;
                                }
                                else if ( ((LA59_41>=54 && LA59_41<=59)) ) {
                                    alt59=1;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return current;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 41, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 37, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 29, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        {
                        alt59=1;
                        }
                        break;
                    case EOF:
                    case RULE_COMMENT_ANNOTATION:
                    case 15:
                    case 16:
                    case 17:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 26:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 43:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 61:
                    case 62:
                        {
                        alt59=2;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 21, input);

                        throw nvae;
                    }

                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 8, input);

                    throw nvae;
                }

                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2696:1: ( (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) ) | this_NotExpression_4= ruleNotExpression )", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2696:2: (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2696:2: (this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2697:2: this_NotOrValuedExpression_0= ruleNotOrValuedExpression ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) )
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getCompareOperationAccess().getNotOrValuedExpressionParserRuleCall_0_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNotOrValuedExpression_in_ruleCompareOperation4084);
                    this_NotOrValuedExpression_0=ruleNotOrValuedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_NotOrValuedExpression_0; 
                              currentNode = currentNode.getParent();
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2708:1: ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2708:2: () ( (lv_operator_2_0= ruleCompareOperator ) ) ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2708:2: ()
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2709:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getCompareOperationAccess().getOperatorExpressionSubExpressionsAction_0_1_0().getType().getClassifier());
                              try {
                              	factory.add(temp, "subExpressions", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getCompareOperationAccess().getOperatorExpressionSubExpressionsAction_0_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2727:2: ( (lv_operator_2_0= ruleCompareOperator ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2728:1: (lv_operator_2_0= ruleCompareOperator )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2728:1: (lv_operator_2_0= ruleCompareOperator )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2729:3: lv_operator_2_0= ruleCompareOperator
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCompareOperationAccess().getOperatorCompareOperatorEnumRuleCall_0_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCompareOperator_in_ruleCompareOperation4117);
                    lv_operator_2_0=ruleCompareOperator();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCompareOperationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"operator",
                      	        		lv_operator_2_0, 
                      	        		"CompareOperator", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2751:2: ( (lv_subExpressions_3_0= ruleNotOrValuedExpression ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2752:1: (lv_subExpressions_3_0= ruleNotOrValuedExpression )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2752:1: (lv_subExpressions_3_0= ruleNotOrValuedExpression )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2753:3: lv_subExpressions_3_0= ruleNotOrValuedExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCompareOperationAccess().getSubExpressionsNotOrValuedExpressionParserRuleCall_0_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNotOrValuedExpression_in_ruleCompareOperation4138);
                    lv_subExpressions_3_0=ruleNotOrValuedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCompareOperationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"subExpressions",
                      	        		lv_subExpressions_3_0, 
                      	        		"NotOrValuedExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2777:2: this_NotExpression_4= ruleNotExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getCompareOperationAccess().getNotExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNotExpression_in_ruleCompareOperation4171);
                    this_NotExpression_4=ruleNotExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_NotExpression_4; 
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
    // $ANTLR end ruleCompareOperation


    // $ANTLR start entryRuleNotOrValuedExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2796:1: entryRuleNotOrValuedExpression returns [EObject current=null] : iv_ruleNotOrValuedExpression= ruleNotOrValuedExpression EOF ;
    public final EObject entryRuleNotOrValuedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotOrValuedExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2797:2: (iv_ruleNotOrValuedExpression= ruleNotOrValuedExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2798:2: iv_ruleNotOrValuedExpression= ruleNotOrValuedExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNotOrValuedExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNotOrValuedExpression_in_entryRuleNotOrValuedExpression4206);
            iv_ruleNotOrValuedExpression=ruleNotOrValuedExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNotOrValuedExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNotOrValuedExpression4216); if (failed) return current;

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
    // $ANTLR end entryRuleNotOrValuedExpression


    // $ANTLR start ruleNotOrValuedExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2805:1: ruleNotOrValuedExpression returns [EObject current=null] : (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression ) ;
    public final EObject ruleNotOrValuedExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ValuedExpression_0 = null;

        EObject this_NotExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2810:6: ( (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )
            int alt60=2;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case RULE_FLOAT:
            case 65:
                {
                alt60=1;
                }
                break;
            case 19:
                {
                int LA60_2 = input.LA(2);

                if ( (synpred71()) ) {
                    alt60=1;
                }
                else if ( (true) ) {
                    alt60=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_BOOLEAN:
                {
                int LA60_3 = input.LA(2);

                if ( (synpred71()) ) {
                    alt60=1;
                }
                else if ( (true) ) {
                    alt60=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 3, input);

                    throw nvae;
                }
                }
                break;
            case 60:
                {
                int LA60_4 = input.LA(2);

                if ( (LA60_4==19) ) {
                    switch ( input.LA(3) ) {
                    case 60:
                        {
                        int LA60_11 = input.LA(4);

                        if ( (LA60_11==19) ) {
                            int LA60_14 = input.LA(5);

                            if ( (synpred71()) ) {
                                alt60=1;
                            }
                            else if ( (true) ) {
                                alt60=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 14, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 11, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 68:
                        {
                        int LA60_12 = input.LA(4);

                        if ( (LA60_12==RULE_ID) ) {
                            int LA60_15 = input.LA(5);

                            if ( (LA60_15==20) ) {
                                int LA60_16 = input.LA(6);

                                if ( (synpred71()) ) {
                                    alt60=1;
                                }
                                else if ( (true) ) {
                                    alt60=2;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return current;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 16, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 15, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 12, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                        {
                        int LA60_13 = input.LA(4);

                        if ( (LA60_13==20) ) {
                            int LA60_16 = input.LA(5);

                            if ( (synpred71()) ) {
                                alt60=1;
                            }
                            else if ( (true) ) {
                                alt60=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 16, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 13, input);

                            throw nvae;
                        }
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 9, input);

                        throw nvae;
                    }

                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 4, input);

                    throw nvae;
                }
                }
                break;
            case 68:
                {
                int LA60_5 = input.LA(2);

                if ( (LA60_5==RULE_ID) ) {
                    int LA60_10 = input.LA(3);

                    if ( (synpred71()) ) {
                        alt60=1;
                    }
                    else if ( (true) ) {
                        alt60=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 10, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 5, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA60_6 = input.LA(2);

                if ( (synpred71()) ) {
                    alt60=1;
                }
                else if ( (true) ) {
                    alt60=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 6, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HOSTCODE:
                {
                int LA60_7 = input.LA(2);

                if ( (synpred71()) ) {
                    alt60=1;
                }
                else if ( (true) ) {
                    alt60=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 7, input);

                    throw nvae;
                }
                }
                break;
            case 63:
                {
                alt60=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2811:1: (this_ValuedExpression_0= ruleValuedExpression | this_NotExpression_1= ruleNotExpression )", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2812:2: this_ValuedExpression_0= ruleValuedExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getNotOrValuedExpressionAccess().getValuedExpressionParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValuedExpression_in_ruleNotOrValuedExpression4266);
                    this_ValuedExpression_0=ruleValuedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_ValuedExpression_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2825:2: this_NotExpression_1= ruleNotExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getNotOrValuedExpressionAccess().getNotExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNotExpression_in_ruleNotOrValuedExpression4296);
                    this_NotExpression_1=ruleNotExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_NotExpression_1; 
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
    // $ANTLR end ruleNotOrValuedExpression


    // $ANTLR start entryRuleNotExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2844:1: entryRuleNotExpression returns [EObject current=null] : iv_ruleNotExpression= ruleNotExpression EOF ;
    public final EObject entryRuleNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2845:2: (iv_ruleNotExpression= ruleNotExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2846:2: iv_ruleNotExpression= ruleNotExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNotExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNotExpression_in_entryRuleNotExpression4331);
            iv_ruleNotExpression=ruleNotExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNotExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNotExpression4341); if (failed) return current;

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
    // $ANTLR end entryRuleNotExpression


    // $ANTLR start ruleNotExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2853:1: ruleNotExpression returns [EObject current=null] : ( ( () ( (lv_operator_1_0= ruleNotOperator ) ) ( (lv_subExpressions_2_0= ruleNotExpression ) ) ) | this_AtomicExpression_3= ruleAtomicExpression ) ;
    public final EObject ruleNotExpression() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_subExpressions_2_0 = null;

        EObject this_AtomicExpression_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2858:6: ( ( ( () ( (lv_operator_1_0= ruleNotOperator ) ) ( (lv_subExpressions_2_0= ruleNotExpression ) ) ) | this_AtomicExpression_3= ruleAtomicExpression ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2859:1: ( ( () ( (lv_operator_1_0= ruleNotOperator ) ) ( (lv_subExpressions_2_0= ruleNotExpression ) ) ) | this_AtomicExpression_3= ruleAtomicExpression )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2859:1: ( ( () ( (lv_operator_1_0= ruleNotOperator ) ) ( (lv_subExpressions_2_0= ruleNotExpression ) ) ) | this_AtomicExpression_3= ruleAtomicExpression )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==63) ) {
                alt61=1;
            }
            else if ( (LA61_0==RULE_ID||LA61_0==RULE_HOSTCODE||LA61_0==RULE_BOOLEAN||LA61_0==19||LA61_0==60||LA61_0==68) ) {
                alt61=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2859:1: ( ( () ( (lv_operator_1_0= ruleNotOperator ) ) ( (lv_subExpressions_2_0= ruleNotExpression ) ) ) | this_AtomicExpression_3= ruleAtomicExpression )", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2859:2: ( () ( (lv_operator_1_0= ruleNotOperator ) ) ( (lv_subExpressions_2_0= ruleNotExpression ) ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2859:2: ( () ( (lv_operator_1_0= ruleNotOperator ) ) ( (lv_subExpressions_2_0= ruleNotExpression ) ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2859:3: () ( (lv_operator_1_0= ruleNotOperator ) ) ( (lv_subExpressions_2_0= ruleNotExpression ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2859:3: ()
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2860:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getNotExpressionAccess().getOperatorExpressionAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getNotExpressionAccess().getOperatorExpressionAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2873:2: ( (lv_operator_1_0= ruleNotOperator ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2874:1: (lv_operator_1_0= ruleNotOperator )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2874:1: (lv_operator_1_0= ruleNotOperator )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2875:3: lv_operator_1_0= ruleNotOperator
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getNotExpressionAccess().getOperatorNotOperatorEnumRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNotOperator_in_ruleNotExpression4400);
                    lv_operator_1_0=ruleNotOperator();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getNotExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"operator",
                      	        		lv_operator_1_0, 
                      	        		"NotOperator", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2897:2: ( (lv_subExpressions_2_0= ruleNotExpression ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2898:1: (lv_subExpressions_2_0= ruleNotExpression )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2898:1: (lv_subExpressions_2_0= ruleNotExpression )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2899:3: lv_subExpressions_2_0= ruleNotExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getNotExpressionAccess().getSubExpressionsNotExpressionParserRuleCall_0_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNotExpression_in_ruleNotExpression4421);
                    lv_subExpressions_2_0=ruleNotExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getNotExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"subExpressions",
                      	        		lv_subExpressions_2_0, 
                      	        		"NotExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2923:2: this_AtomicExpression_3= ruleAtomicExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getNotExpressionAccess().getAtomicExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAtomicExpression_in_ruleNotExpression4453);
                    this_AtomicExpression_3=ruleAtomicExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_AtomicExpression_3; 
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
    // $ANTLR end ruleNotExpression


    // $ANTLR start entryRuleValuedExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2942:1: entryRuleValuedExpression returns [EObject current=null] : iv_ruleValuedExpression= ruleValuedExpression EOF ;
    public final EObject entryRuleValuedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValuedExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2943:2: (iv_ruleValuedExpression= ruleValuedExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2944:2: iv_ruleValuedExpression= ruleValuedExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getValuedExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleValuedExpression_in_entryRuleValuedExpression4488);
            iv_ruleValuedExpression=ruleValuedExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleValuedExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValuedExpression4498); if (failed) return current;

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
    // $ANTLR end entryRuleValuedExpression


    // $ANTLR start ruleValuedExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2951:1: ruleValuedExpression returns [EObject current=null] : this_AddExpression_0= ruleAddExpression ;
    public final EObject ruleValuedExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AddExpression_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2956:6: (this_AddExpression_0= ruleAddExpression )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2958:2: this_AddExpression_0= ruleAddExpression
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getValuedExpressionAccess().getAddExpressionParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleAddExpression_in_ruleValuedExpression4547);
            this_AddExpression_0=ruleAddExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_AddExpression_0; 
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
    // $ANTLR end ruleValuedExpression


    // $ANTLR start entryRuleAddExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2977:1: entryRuleAddExpression returns [EObject current=null] : iv_ruleAddExpression= ruleAddExpression EOF ;
    public final EObject entryRuleAddExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2978:2: (iv_ruleAddExpression= ruleAddExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2979:2: iv_ruleAddExpression= ruleAddExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAddExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAddExpression_in_entryRuleAddExpression4581);
            iv_ruleAddExpression=ruleAddExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAddExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddExpression4591); if (failed) return current;

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
    // $ANTLR end entryRuleAddExpression


    // $ANTLR start ruleAddExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2986:1: ruleAddExpression returns [EObject current=null] : (this_SubExpression_0= ruleSubExpression ( () ( (lv_operator_2_0= ruleAddOperator ) ) ( (lv_subExpressions_3_0= ruleSubExpression ) ) )* ) ;
    public final EObject ruleAddExpression() throws RecognitionException {
        EObject current = null;

        EObject this_SubExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_subExpressions_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2991:6: ( (this_SubExpression_0= ruleSubExpression ( () ( (lv_operator_2_0= ruleAddOperator ) ) ( (lv_subExpressions_3_0= ruleSubExpression ) ) )* ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2992:1: (this_SubExpression_0= ruleSubExpression ( () ( (lv_operator_2_0= ruleAddOperator ) ) ( (lv_subExpressions_3_0= ruleSubExpression ) ) )* )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2992:1: (this_SubExpression_0= ruleSubExpression ( () ( (lv_operator_2_0= ruleAddOperator ) ) ( (lv_subExpressions_3_0= ruleSubExpression ) ) )* )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2993:2: this_SubExpression_0= ruleSubExpression ( () ( (lv_operator_2_0= ruleAddOperator ) ) ( (lv_subExpressions_3_0= ruleSubExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAddExpressionAccess().getSubExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleSubExpression_in_ruleAddExpression4641);
            this_SubExpression_0=ruleSubExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_SubExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3004:1: ( () ( (lv_operator_2_0= ruleAddOperator ) ) ( (lv_subExpressions_3_0= ruleSubExpression ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==64) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3004:2: () ( (lv_operator_2_0= ruleAddOperator ) ) ( (lv_subExpressions_3_0= ruleSubExpression ) )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3004:2: ()
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3005:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getAddExpressionAccess().getOperatorExpressionSubExpressionsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "subExpressions", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getAddExpressionAccess().getOperatorExpressionSubExpressionsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3023:2: ( (lv_operator_2_0= ruleAddOperator ) )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3024:1: (lv_operator_2_0= ruleAddOperator )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3024:1: (lv_operator_2_0= ruleAddOperator )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3025:3: lv_operator_2_0= ruleAddOperator
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getAddExpressionAccess().getOperatorAddOperatorEnumRuleCall_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAddOperator_in_ruleAddExpression4674);
            	    lv_operator_2_0=ruleAddOperator();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getAddExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"operator",
            	      	        		lv_operator_2_0, 
            	      	        		"AddOperator", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3047:2: ( (lv_subExpressions_3_0= ruleSubExpression ) )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3048:1: (lv_subExpressions_3_0= ruleSubExpression )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3048:1: (lv_subExpressions_3_0= ruleSubExpression )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3049:3: lv_subExpressions_3_0= ruleSubExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getAddExpressionAccess().getSubExpressionsSubExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleSubExpression_in_ruleAddExpression4695);
            	    lv_subExpressions_3_0=ruleSubExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getAddExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"subExpressions",
            	      	        		lv_subExpressions_3_0, 
            	      	        		"SubExpression", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
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
    // $ANTLR end ruleAddExpression


    // $ANTLR start entryRuleSubExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3079:1: entryRuleSubExpression returns [EObject current=null] : iv_ruleSubExpression= ruleSubExpression EOF ;
    public final EObject entryRuleSubExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3080:2: (iv_ruleSubExpression= ruleSubExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3081:2: iv_ruleSubExpression= ruleSubExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSubExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSubExpression_in_entryRuleSubExpression4733);
            iv_ruleSubExpression=ruleSubExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSubExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubExpression4743); if (failed) return current;

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
    // $ANTLR end entryRuleSubExpression


    // $ANTLR start ruleSubExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3088:1: ruleSubExpression returns [EObject current=null] : (this_MultExpression_0= ruleMultExpression ( () ( (lv_operator_2_0= ruleSubOperator ) ) ( (lv_subExpressions_3_0= ruleMultExpression ) ) )* ) ;
    public final EObject ruleSubExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_subExpressions_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3093:6: ( (this_MultExpression_0= ruleMultExpression ( () ( (lv_operator_2_0= ruleSubOperator ) ) ( (lv_subExpressions_3_0= ruleMultExpression ) ) )* ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3094:1: (this_MultExpression_0= ruleMultExpression ( () ( (lv_operator_2_0= ruleSubOperator ) ) ( (lv_subExpressions_3_0= ruleMultExpression ) ) )* )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3094:1: (this_MultExpression_0= ruleMultExpression ( () ( (lv_operator_2_0= ruleSubOperator ) ) ( (lv_subExpressions_3_0= ruleMultExpression ) ) )* )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3095:2: this_MultExpression_0= ruleMultExpression ( () ( (lv_operator_2_0= ruleSubOperator ) ) ( (lv_subExpressions_3_0= ruleMultExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getSubExpressionAccess().getMultExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultExpression_in_ruleSubExpression4793);
            this_MultExpression_0=ruleMultExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_MultExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3106:1: ( () ( (lv_operator_2_0= ruleSubOperator ) ) ( (lv_subExpressions_3_0= ruleMultExpression ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==65) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3106:2: () ( (lv_operator_2_0= ruleSubOperator ) ) ( (lv_subExpressions_3_0= ruleMultExpression ) )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3106:2: ()
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3107:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getSubExpressionAccess().getOperatorExpressionSubExpressionsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "subExpressions", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getSubExpressionAccess().getOperatorExpressionSubExpressionsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3125:2: ( (lv_operator_2_0= ruleSubOperator ) )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3126:1: (lv_operator_2_0= ruleSubOperator )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3126:1: (lv_operator_2_0= ruleSubOperator )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3127:3: lv_operator_2_0= ruleSubOperator
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getSubExpressionAccess().getOperatorSubOperatorEnumRuleCall_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleSubOperator_in_ruleSubExpression4826);
            	    lv_operator_2_0=ruleSubOperator();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getSubExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"operator",
            	      	        		lv_operator_2_0, 
            	      	        		"SubOperator", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3149:2: ( (lv_subExpressions_3_0= ruleMultExpression ) )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3150:1: (lv_subExpressions_3_0= ruleMultExpression )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3150:1: (lv_subExpressions_3_0= ruleMultExpression )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3151:3: lv_subExpressions_3_0= ruleMultExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getSubExpressionAccess().getSubExpressionsMultExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMultExpression_in_ruleSubExpression4847);
            	    lv_subExpressions_3_0=ruleMultExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getSubExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"subExpressions",
            	      	        		lv_subExpressions_3_0, 
            	      	        		"MultExpression", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
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
    // $ANTLR end ruleSubExpression


    // $ANTLR start entryRuleMultExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3181:1: entryRuleMultExpression returns [EObject current=null] : iv_ruleMultExpression= ruleMultExpression EOF ;
    public final EObject entryRuleMultExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3182:2: (iv_ruleMultExpression= ruleMultExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3183:2: iv_ruleMultExpression= ruleMultExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getMultExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultExpression_in_entryRuleMultExpression4885);
            iv_ruleMultExpression=ruleMultExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleMultExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultExpression4895); if (failed) return current;

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
    // $ANTLR end entryRuleMultExpression


    // $ANTLR start ruleMultExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3190:1: ruleMultExpression returns [EObject current=null] : (this_DivExpression_0= ruleDivExpression ( () ( (lv_operator_2_0= ruleMultOperator ) ) ( (lv_subExpressions_3_0= ruleDivExpression ) ) )* ) ;
    public final EObject ruleMultExpression() throws RecognitionException {
        EObject current = null;

        EObject this_DivExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_subExpressions_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3195:6: ( (this_DivExpression_0= ruleDivExpression ( () ( (lv_operator_2_0= ruleMultOperator ) ) ( (lv_subExpressions_3_0= ruleDivExpression ) ) )* ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3196:1: (this_DivExpression_0= ruleDivExpression ( () ( (lv_operator_2_0= ruleMultOperator ) ) ( (lv_subExpressions_3_0= ruleDivExpression ) ) )* )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3196:1: (this_DivExpression_0= ruleDivExpression ( () ( (lv_operator_2_0= ruleMultOperator ) ) ( (lv_subExpressions_3_0= ruleDivExpression ) ) )* )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3197:2: this_DivExpression_0= ruleDivExpression ( () ( (lv_operator_2_0= ruleMultOperator ) ) ( (lv_subExpressions_3_0= ruleDivExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getMultExpressionAccess().getDivExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleDivExpression_in_ruleMultExpression4945);
            this_DivExpression_0=ruleDivExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_DivExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3208:1: ( () ( (lv_operator_2_0= ruleMultOperator ) ) ( (lv_subExpressions_3_0= ruleDivExpression ) ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==66) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3208:2: () ( (lv_operator_2_0= ruleMultOperator ) ) ( (lv_subExpressions_3_0= ruleDivExpression ) )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3208:2: ()
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3209:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getMultExpressionAccess().getOperatorExpressionSubExpressionsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "subExpressions", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getMultExpressionAccess().getOperatorExpressionSubExpressionsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3227:2: ( (lv_operator_2_0= ruleMultOperator ) )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3228:1: (lv_operator_2_0= ruleMultOperator )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3228:1: (lv_operator_2_0= ruleMultOperator )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3229:3: lv_operator_2_0= ruleMultOperator
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getMultExpressionAccess().getOperatorMultOperatorEnumRuleCall_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMultOperator_in_ruleMultExpression4978);
            	    lv_operator_2_0=ruleMultOperator();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getMultExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"operator",
            	      	        		lv_operator_2_0, 
            	      	        		"MultOperator", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3251:2: ( (lv_subExpressions_3_0= ruleDivExpression ) )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3252:1: (lv_subExpressions_3_0= ruleDivExpression )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3252:1: (lv_subExpressions_3_0= ruleDivExpression )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3253:3: lv_subExpressions_3_0= ruleDivExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getMultExpressionAccess().getSubExpressionsDivExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleDivExpression_in_ruleMultExpression4999);
            	    lv_subExpressions_3_0=ruleDivExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getMultExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"subExpressions",
            	      	        		lv_subExpressions_3_0, 
            	      	        		"DivExpression", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop64;
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
    // $ANTLR end ruleMultExpression


    // $ANTLR start entryRuleDivExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3283:1: entryRuleDivExpression returns [EObject current=null] : iv_ruleDivExpression= ruleDivExpression EOF ;
    public final EObject entryRuleDivExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3284:2: (iv_ruleDivExpression= ruleDivExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3285:2: iv_ruleDivExpression= ruleDivExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDivExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDivExpression_in_entryRuleDivExpression5037);
            iv_ruleDivExpression=ruleDivExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleDivExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDivExpression5047); if (failed) return current;

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
    // $ANTLR end entryRuleDivExpression


    // $ANTLR start ruleDivExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3292:1: ruleDivExpression returns [EObject current=null] : (this_ModExpression_0= ruleModExpression ( () ( (lv_operator_2_0= ruleDivOperator ) ) ( (lv_subExpressions_3_0= ruleModExpression ) ) )? ) ;
    public final EObject ruleDivExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ModExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_subExpressions_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3297:6: ( (this_ModExpression_0= ruleModExpression ( () ( (lv_operator_2_0= ruleDivOperator ) ) ( (lv_subExpressions_3_0= ruleModExpression ) ) )? ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3298:1: (this_ModExpression_0= ruleModExpression ( () ( (lv_operator_2_0= ruleDivOperator ) ) ( (lv_subExpressions_3_0= ruleModExpression ) ) )? )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3298:1: (this_ModExpression_0= ruleModExpression ( () ( (lv_operator_2_0= ruleDivOperator ) ) ( (lv_subExpressions_3_0= ruleModExpression ) ) )? )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3299:2: this_ModExpression_0= ruleModExpression ( () ( (lv_operator_2_0= ruleDivOperator ) ) ( (lv_subExpressions_3_0= ruleModExpression ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getDivExpressionAccess().getModExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleModExpression_in_ruleDivExpression5097);
            this_ModExpression_0=ruleModExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_ModExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3310:1: ( () ( (lv_operator_2_0= ruleDivOperator ) ) ( (lv_subExpressions_3_0= ruleModExpression ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==16) ) {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==RULE_ID) ) {
                    switch ( input.LA(3) ) {
                        case EOF:
                            {
                            int LA65_5 = input.LA(4);

                            if ( (LA65_5==EOF) ) {
                                int LA65_97 = input.LA(5);


                            }
                            }
                            break;
                        case 26:
                            {
                            int LA65_6 = input.LA(4);

                            if ( (LA65_6==RULE_ID) ) {
                                int LA65_7 = input.LA(5);

                                if ( (synpred76()) ) {
                                    alt65=1;
                                }
                            }
                            else if ( (LA65_6==RULE_HOSTCODE) ) {
                                alt65=1;
                            }
                            }
                            break;
                        case RULE_COMMENT_ANNOTATION:
                        case 15:
                        case 16:
                        case 17:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 43:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                        case 61:
                        case 62:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                            {
                            alt65=1;
                            }
                            break;
                    }

                }
                else if ( ((LA65_1>=RULE_INT && LA65_1<=RULE_BOOLEAN)||LA65_1==19||LA65_1==60||LA65_1==65||LA65_1==68) ) {
                    alt65=1;
                }
            }
            switch (alt65) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3310:2: () ( (lv_operator_2_0= ruleDivOperator ) ) ( (lv_subExpressions_3_0= ruleModExpression ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3310:2: ()
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3311:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getDivExpressionAccess().getOperatorExpressionSubExpressionsAction_1_0().getType().getClassifier());
                              try {
                              	factory.add(temp, "subExpressions", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getDivExpressionAccess().getOperatorExpressionSubExpressionsAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3329:2: ( (lv_operator_2_0= ruleDivOperator ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3330:1: (lv_operator_2_0= ruleDivOperator )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3330:1: (lv_operator_2_0= ruleDivOperator )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3331:3: lv_operator_2_0= ruleDivOperator
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getDivExpressionAccess().getOperatorDivOperatorEnumRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDivOperator_in_ruleDivExpression5130);
                    lv_operator_2_0=ruleDivOperator();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getDivExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"operator",
                      	        		lv_operator_2_0, 
                      	        		"DivOperator", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3353:2: ( (lv_subExpressions_3_0= ruleModExpression ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3354:1: (lv_subExpressions_3_0= ruleModExpression )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3354:1: (lv_subExpressions_3_0= ruleModExpression )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3355:3: lv_subExpressions_3_0= ruleModExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getDivExpressionAccess().getSubExpressionsModExpressionParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleModExpression_in_ruleDivExpression5151);
                    lv_subExpressions_3_0=ruleModExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getDivExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"subExpressions",
                      	        		lv_subExpressions_3_0, 
                      	        		"ModExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

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
    // $ANTLR end ruleDivExpression


    // $ANTLR start entryRuleModExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3385:1: entryRuleModExpression returns [EObject current=null] : iv_ruleModExpression= ruleModExpression EOF ;
    public final EObject entryRuleModExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3386:2: (iv_ruleModExpression= ruleModExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3387:2: iv_ruleModExpression= ruleModExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModExpression_in_entryRuleModExpression5189);
            iv_ruleModExpression=ruleModExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleModExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModExpression5199); if (failed) return current;

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
    // $ANTLR end entryRuleModExpression


    // $ANTLR start ruleModExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3394:1: ruleModExpression returns [EObject current=null] : (this_NegExpression_0= ruleNegExpression ( () ( (lv_operator_2_0= ruleModOperator ) ) ( (lv_subExpressions_3_0= ruleAtomicValuedExpression ) ) )? ) ;
    public final EObject ruleModExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NegExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_subExpressions_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3399:6: ( (this_NegExpression_0= ruleNegExpression ( () ( (lv_operator_2_0= ruleModOperator ) ) ( (lv_subExpressions_3_0= ruleAtomicValuedExpression ) ) )? ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3400:1: (this_NegExpression_0= ruleNegExpression ( () ( (lv_operator_2_0= ruleModOperator ) ) ( (lv_subExpressions_3_0= ruleAtomicValuedExpression ) ) )? )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3400:1: (this_NegExpression_0= ruleNegExpression ( () ( (lv_operator_2_0= ruleModOperator ) ) ( (lv_subExpressions_3_0= ruleAtomicValuedExpression ) ) )? )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3401:2: this_NegExpression_0= ruleNegExpression ( () ( (lv_operator_2_0= ruleModOperator ) ) ( (lv_subExpressions_3_0= ruleAtomicValuedExpression ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getModExpressionAccess().getNegExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleNegExpression_in_ruleModExpression5249);
            this_NegExpression_0=ruleNegExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_NegExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3412:1: ( () ( (lv_operator_2_0= ruleModOperator ) ) ( (lv_subExpressions_3_0= ruleAtomicValuedExpression ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==67) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3412:2: () ( (lv_operator_2_0= ruleModOperator ) ) ( (lv_subExpressions_3_0= ruleAtomicValuedExpression ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3412:2: ()
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3413:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getModExpressionAccess().getOperatorExpressionSubExpressionsAction_1_0().getType().getClassifier());
                              try {
                              	factory.add(temp, "subExpressions", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getModExpressionAccess().getOperatorExpressionSubExpressionsAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3431:2: ( (lv_operator_2_0= ruleModOperator ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3432:1: (lv_operator_2_0= ruleModOperator )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3432:1: (lv_operator_2_0= ruleModOperator )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3433:3: lv_operator_2_0= ruleModOperator
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getModExpressionAccess().getOperatorModOperatorEnumRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleModOperator_in_ruleModExpression5282);
                    lv_operator_2_0=ruleModOperator();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getModExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"operator",
                      	        		lv_operator_2_0, 
                      	        		"ModOperator", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3455:2: ( (lv_subExpressions_3_0= ruleAtomicValuedExpression ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3456:1: (lv_subExpressions_3_0= ruleAtomicValuedExpression )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3456:1: (lv_subExpressions_3_0= ruleAtomicValuedExpression )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3457:3: lv_subExpressions_3_0= ruleAtomicValuedExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getModExpressionAccess().getSubExpressionsAtomicValuedExpressionParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAtomicValuedExpression_in_ruleModExpression5303);
                    lv_subExpressions_3_0=ruleAtomicValuedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getModExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"subExpressions",
                      	        		lv_subExpressions_3_0, 
                      	        		"AtomicValuedExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

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
    // $ANTLR end ruleModExpression


    // $ANTLR start entryRuleNegExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3487:1: entryRuleNegExpression returns [EObject current=null] : iv_ruleNegExpression= ruleNegExpression EOF ;
    public final EObject entryRuleNegExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3488:2: (iv_ruleNegExpression= ruleNegExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3489:2: iv_ruleNegExpression= ruleNegExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNegExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNegExpression_in_entryRuleNegExpression5341);
            iv_ruleNegExpression=ruleNegExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNegExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNegExpression5351); if (failed) return current;

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
    // $ANTLR end entryRuleNegExpression


    // $ANTLR start ruleNegExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3496:1: ruleNegExpression returns [EObject current=null] : ( ( () ( (lv_operator_1_0= ruleSubOperator ) ) ( (lv_subExpressions_2_0= ruleNegExpression ) ) ) | this_AtomicValuedExpression_3= ruleAtomicValuedExpression ) ;
    public final EObject ruleNegExpression() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_subExpressions_2_0 = null;

        EObject this_AtomicValuedExpression_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3501:6: ( ( ( () ( (lv_operator_1_0= ruleSubOperator ) ) ( (lv_subExpressions_2_0= ruleNegExpression ) ) ) | this_AtomicValuedExpression_3= ruleAtomicValuedExpression ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3502:1: ( ( () ( (lv_operator_1_0= ruleSubOperator ) ) ( (lv_subExpressions_2_0= ruleNegExpression ) ) ) | this_AtomicValuedExpression_3= ruleAtomicValuedExpression )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3502:1: ( ( () ( (lv_operator_1_0= ruleSubOperator ) ) ( (lv_subExpressions_2_0= ruleNegExpression ) ) ) | this_AtomicValuedExpression_3= ruleAtomicValuedExpression )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==65) ) {
                alt67=1;
            }
            else if ( (LA67_0==RULE_ID||(LA67_0>=RULE_INT && LA67_0<=RULE_BOOLEAN)||LA67_0==19||LA67_0==60||LA67_0==68) ) {
                alt67=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3502:1: ( ( () ( (lv_operator_1_0= ruleSubOperator ) ) ( (lv_subExpressions_2_0= ruleNegExpression ) ) ) | this_AtomicValuedExpression_3= ruleAtomicValuedExpression )", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3502:2: ( () ( (lv_operator_1_0= ruleSubOperator ) ) ( (lv_subExpressions_2_0= ruleNegExpression ) ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3502:2: ( () ( (lv_operator_1_0= ruleSubOperator ) ) ( (lv_subExpressions_2_0= ruleNegExpression ) ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3502:3: () ( (lv_operator_1_0= ruleSubOperator ) ) ( (lv_subExpressions_2_0= ruleNegExpression ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3502:3: ()
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3503:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getNegExpressionAccess().getOperatorExpressionAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getNegExpressionAccess().getOperatorExpressionAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3516:2: ( (lv_operator_1_0= ruleSubOperator ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3517:1: (lv_operator_1_0= ruleSubOperator )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3517:1: (lv_operator_1_0= ruleSubOperator )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3518:3: lv_operator_1_0= ruleSubOperator
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getNegExpressionAccess().getOperatorSubOperatorEnumRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSubOperator_in_ruleNegExpression5410);
                    lv_operator_1_0=ruleSubOperator();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getNegExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"operator",
                      	        		lv_operator_1_0, 
                      	        		"SubOperator", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3540:2: ( (lv_subExpressions_2_0= ruleNegExpression ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3541:1: (lv_subExpressions_2_0= ruleNegExpression )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3541:1: (lv_subExpressions_2_0= ruleNegExpression )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3542:3: lv_subExpressions_2_0= ruleNegExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getNegExpressionAccess().getSubExpressionsNegExpressionParserRuleCall_0_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNegExpression_in_ruleNegExpression5431);
                    lv_subExpressions_2_0=ruleNegExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getNegExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"subExpressions",
                      	        		lv_subExpressions_2_0, 
                      	        		"NegExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3566:2: this_AtomicValuedExpression_3= ruleAtomicValuedExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getNegExpressionAccess().getAtomicValuedExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAtomicValuedExpression_in_ruleNegExpression5463);
                    this_AtomicValuedExpression_3=ruleAtomicValuedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_AtomicValuedExpression_3; 
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
    // $ANTLR end ruleNegExpression


    // $ANTLR start entryRuleAtomicExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3585:1: entryRuleAtomicExpression returns [EObject current=null] : iv_ruleAtomicExpression= ruleAtomicExpression EOF ;
    public final EObject entryRuleAtomicExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3586:2: (iv_ruleAtomicExpression= ruleAtomicExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3587:2: iv_ruleAtomicExpression= ruleAtomicExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAtomicExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAtomicExpression_in_entryRuleAtomicExpression5498);
            iv_ruleAtomicExpression=ruleAtomicExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAtomicExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAtomicExpression5508); if (failed) return current;

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
    // $ANTLR end entryRuleAtomicExpression


    // $ANTLR start ruleAtomicExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3594:1: ruleAtomicExpression returns [EObject current=null] : (this_BooleanValue_0= ruleBooleanValue | this_ValuedObjectTestExpression_1= ruleValuedObjectTestExpression | ( '(' this_BooleanExpression_3= ruleBooleanExpression ')' ) | this_TextExpression_5= ruleTextExpression ) ;
    public final EObject ruleAtomicExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanValue_0 = null;

        EObject this_ValuedObjectTestExpression_1 = null;

        EObject this_BooleanExpression_3 = null;

        EObject this_TextExpression_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3599:6: ( (this_BooleanValue_0= ruleBooleanValue | this_ValuedObjectTestExpression_1= ruleValuedObjectTestExpression | ( '(' this_BooleanExpression_3= ruleBooleanExpression ')' ) | this_TextExpression_5= ruleTextExpression ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3600:1: (this_BooleanValue_0= ruleBooleanValue | this_ValuedObjectTestExpression_1= ruleValuedObjectTestExpression | ( '(' this_BooleanExpression_3= ruleBooleanExpression ')' ) | this_TextExpression_5= ruleTextExpression )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3600:1: (this_BooleanValue_0= ruleBooleanValue | this_ValuedObjectTestExpression_1= ruleValuedObjectTestExpression | ( '(' this_BooleanExpression_3= ruleBooleanExpression ')' ) | this_TextExpression_5= ruleTextExpression )
            int alt68=4;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt68=1;
                }
                break;
            case RULE_ID:
            case 60:
            case 68:
                {
                alt68=2;
                }
                break;
            case 19:
                {
                alt68=3;
                }
                break;
            case RULE_HOSTCODE:
                {
                alt68=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3600:1: (this_BooleanValue_0= ruleBooleanValue | this_ValuedObjectTestExpression_1= ruleValuedObjectTestExpression | ( '(' this_BooleanExpression_3= ruleBooleanExpression ')' ) | this_TextExpression_5= ruleTextExpression )", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3601:2: this_BooleanValue_0= ruleBooleanValue
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAtomicExpressionAccess().getBooleanValueParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanValue_in_ruleAtomicExpression5558);
                    this_BooleanValue_0=ruleBooleanValue();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_BooleanValue_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3614:2: this_ValuedObjectTestExpression_1= ruleValuedObjectTestExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAtomicExpressionAccess().getValuedObjectTestExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValuedObjectTestExpression_in_ruleAtomicExpression5588);
                    this_ValuedObjectTestExpression_1=ruleValuedObjectTestExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_ValuedObjectTestExpression_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3626:6: ( '(' this_BooleanExpression_3= ruleBooleanExpression ')' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3626:6: ( '(' this_BooleanExpression_3= ruleBooleanExpression ')' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3626:8: '(' this_BooleanExpression_3= ruleBooleanExpression ')'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleAtomicExpression5604); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getAtomicExpressionAccess().getLeftParenthesisKeyword_2_0(), null); 
                          
                    }
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAtomicExpressionAccess().getBooleanExpressionParserRuleCall_2_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanExpression_in_ruleAtomicExpression5629);
                    this_BooleanExpression_3=ruleBooleanExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_BooleanExpression_3; 
                              currentNode = currentNode.getParent();
                          
                    }
                    match(input,20,FollowSets000.FOLLOW_20_in_ruleAtomicExpression5638); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getAtomicExpressionAccess().getRightParenthesisKeyword_2_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3648:2: this_TextExpression_5= ruleTextExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAtomicExpressionAccess().getTextExpressionParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTextExpression_in_ruleAtomicExpression5670);
                    this_TextExpression_5=ruleTextExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_TextExpression_5; 
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
    // $ANTLR end ruleAtomicExpression


    // $ANTLR start entryRuleAtomicValuedExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3667:1: entryRuleAtomicValuedExpression returns [EObject current=null] : iv_ruleAtomicValuedExpression= ruleAtomicValuedExpression EOF ;
    public final EObject entryRuleAtomicValuedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicValuedExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3668:2: (iv_ruleAtomicValuedExpression= ruleAtomicValuedExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3669:2: iv_ruleAtomicValuedExpression= ruleAtomicValuedExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAtomicValuedExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAtomicValuedExpression_in_entryRuleAtomicValuedExpression5705);
            iv_ruleAtomicValuedExpression=ruleAtomicValuedExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAtomicValuedExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAtomicValuedExpression5715); if (failed) return current;

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
    // $ANTLR end entryRuleAtomicValuedExpression


    // $ANTLR start ruleAtomicValuedExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3676:1: ruleAtomicValuedExpression returns [EObject current=null] : (this_IntValue_0= ruleIntValue | this_FloatValue_1= ruleFloatValue | ( '(' this_ValuedExpression_3= ruleValuedExpression ')' ) | this_AtomicExpression_5= ruleAtomicExpression ) ;
    public final EObject ruleAtomicValuedExpression() throws RecognitionException {
        EObject current = null;

        EObject this_IntValue_0 = null;

        EObject this_FloatValue_1 = null;

        EObject this_ValuedExpression_3 = null;

        EObject this_AtomicExpression_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3681:6: ( (this_IntValue_0= ruleIntValue | this_FloatValue_1= ruleFloatValue | ( '(' this_ValuedExpression_3= ruleValuedExpression ')' ) | this_AtomicExpression_5= ruleAtomicExpression ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3682:1: (this_IntValue_0= ruleIntValue | this_FloatValue_1= ruleFloatValue | ( '(' this_ValuedExpression_3= ruleValuedExpression ')' ) | this_AtomicExpression_5= ruleAtomicExpression )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3682:1: (this_IntValue_0= ruleIntValue | this_FloatValue_1= ruleFloatValue | ( '(' this_ValuedExpression_3= ruleValuedExpression ')' ) | this_AtomicExpression_5= ruleAtomicExpression )
            int alt69=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt69=1;
                }
                break;
            case RULE_FLOAT:
                {
                alt69=2;
                }
                break;
            case 19:
                {
                int LA69_3 = input.LA(2);

                if ( (synpred84()) ) {
                    alt69=3;
                }
                else if ( (true) ) {
                    alt69=4;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("3682:1: (this_IntValue_0= ruleIntValue | this_FloatValue_1= ruleFloatValue | ( '(' this_ValuedExpression_3= ruleValuedExpression ')' ) | this_AtomicExpression_5= ruleAtomicExpression )", 69, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
            case RULE_HOSTCODE:
            case RULE_BOOLEAN:
            case 60:
            case 68:
                {
                alt69=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3682:1: (this_IntValue_0= ruleIntValue | this_FloatValue_1= ruleFloatValue | ( '(' this_ValuedExpression_3= ruleValuedExpression ')' ) | this_AtomicExpression_5= ruleAtomicExpression )", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3683:2: this_IntValue_0= ruleIntValue
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAtomicValuedExpressionAccess().getIntValueParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIntValue_in_ruleAtomicValuedExpression5765);
                    this_IntValue_0=ruleIntValue();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_IntValue_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3696:2: this_FloatValue_1= ruleFloatValue
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAtomicValuedExpressionAccess().getFloatValueParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFloatValue_in_ruleAtomicValuedExpression5795);
                    this_FloatValue_1=ruleFloatValue();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_FloatValue_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3708:6: ( '(' this_ValuedExpression_3= ruleValuedExpression ')' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3708:6: ( '(' this_ValuedExpression_3= ruleValuedExpression ')' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3708:8: '(' this_ValuedExpression_3= ruleValuedExpression ')'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleAtomicValuedExpression5811); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getAtomicValuedExpressionAccess().getLeftParenthesisKeyword_2_0(), null); 
                          
                    }
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAtomicValuedExpressionAccess().getValuedExpressionParserRuleCall_2_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValuedExpression_in_ruleAtomicValuedExpression5836);
                    this_ValuedExpression_3=ruleValuedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_ValuedExpression_3; 
                              currentNode = currentNode.getParent();
                          
                    }
                    match(input,20,FollowSets000.FOLLOW_20_in_ruleAtomicValuedExpression5845); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getAtomicValuedExpressionAccess().getRightParenthesisKeyword_2_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3730:2: this_AtomicExpression_5= ruleAtomicExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAtomicValuedExpressionAccess().getAtomicExpressionParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAtomicExpression_in_ruleAtomicValuedExpression5877);
                    this_AtomicExpression_5=ruleAtomicExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_AtomicExpression_5; 
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
    // $ANTLR end ruleAtomicValuedExpression


    // $ANTLR start entryRuleValuedObjectTestExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3749:1: entryRuleValuedObjectTestExpression returns [EObject current=null] : iv_ruleValuedObjectTestExpression= ruleValuedObjectTestExpression EOF ;
    public final EObject entryRuleValuedObjectTestExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValuedObjectTestExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3750:2: (iv_ruleValuedObjectTestExpression= ruleValuedObjectTestExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3751:2: iv_ruleValuedObjectTestExpression= ruleValuedObjectTestExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getValuedObjectTestExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleValuedObjectTestExpression_in_entryRuleValuedObjectTestExpression5912);
            iv_ruleValuedObjectTestExpression=ruleValuedObjectTestExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleValuedObjectTestExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValuedObjectTestExpression5922); if (failed) return current;

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
    // $ANTLR end entryRuleValuedObjectTestExpression


    // $ANTLR start ruleValuedObjectTestExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3758:1: ruleValuedObjectTestExpression returns [EObject current=null] : ( ( () ( (lv_operator_1_0= rulePreOperator ) ) '(' ( (lv_subExpressions_3_0= ruleValuedObjectTestExpression ) ) ')' ) | ( () ( (lv_operator_6_0= ruleValueTestOperator ) ) ( (lv_subExpressions_7_0= ruleValuedObjectReference ) ) ) | this_ValuedObjectReference_8= ruleValuedObjectReference ) ;
    public final EObject ruleValuedObjectTestExpression() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_subExpressions_3_0 = null;

        Enumerator lv_operator_6_0 = null;

        EObject lv_subExpressions_7_0 = null;

        EObject this_ValuedObjectReference_8 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3763:6: ( ( ( () ( (lv_operator_1_0= rulePreOperator ) ) '(' ( (lv_subExpressions_3_0= ruleValuedObjectTestExpression ) ) ')' ) | ( () ( (lv_operator_6_0= ruleValueTestOperator ) ) ( (lv_subExpressions_7_0= ruleValuedObjectReference ) ) ) | this_ValuedObjectReference_8= ruleValuedObjectReference ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3764:1: ( ( () ( (lv_operator_1_0= rulePreOperator ) ) '(' ( (lv_subExpressions_3_0= ruleValuedObjectTestExpression ) ) ')' ) | ( () ( (lv_operator_6_0= ruleValueTestOperator ) ) ( (lv_subExpressions_7_0= ruleValuedObjectReference ) ) ) | this_ValuedObjectReference_8= ruleValuedObjectReference )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3764:1: ( ( () ( (lv_operator_1_0= rulePreOperator ) ) '(' ( (lv_subExpressions_3_0= ruleValuedObjectTestExpression ) ) ')' ) | ( () ( (lv_operator_6_0= ruleValueTestOperator ) ) ( (lv_subExpressions_7_0= ruleValuedObjectReference ) ) ) | this_ValuedObjectReference_8= ruleValuedObjectReference )
            int alt70=3;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt70=1;
                }
                break;
            case 68:
                {
                alt70=2;
                }
                break;
            case RULE_ID:
                {
                alt70=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3764:1: ( ( () ( (lv_operator_1_0= rulePreOperator ) ) '(' ( (lv_subExpressions_3_0= ruleValuedObjectTestExpression ) ) ')' ) | ( () ( (lv_operator_6_0= ruleValueTestOperator ) ) ( (lv_subExpressions_7_0= ruleValuedObjectReference ) ) ) | this_ValuedObjectReference_8= ruleValuedObjectReference )", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3764:2: ( () ( (lv_operator_1_0= rulePreOperator ) ) '(' ( (lv_subExpressions_3_0= ruleValuedObjectTestExpression ) ) ')' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3764:2: ( () ( (lv_operator_1_0= rulePreOperator ) ) '(' ( (lv_subExpressions_3_0= ruleValuedObjectTestExpression ) ) ')' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3764:3: () ( (lv_operator_1_0= rulePreOperator ) ) '(' ( (lv_subExpressions_3_0= ruleValuedObjectTestExpression ) ) ')'
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3764:3: ()
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3765:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getValuedObjectTestExpressionAccess().getOperatorExpressionAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getValuedObjectTestExpressionAccess().getOperatorExpressionAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3778:2: ( (lv_operator_1_0= rulePreOperator ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3779:1: (lv_operator_1_0= rulePreOperator )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3779:1: (lv_operator_1_0= rulePreOperator )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3780:3: lv_operator_1_0= rulePreOperator
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getValuedObjectTestExpressionAccess().getOperatorPreOperatorEnumRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePreOperator_in_ruleValuedObjectTestExpression5981);
                    lv_operator_1_0=rulePreOperator();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getValuedObjectTestExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"operator",
                      	        		lv_operator_1_0, 
                      	        		"PreOperator", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,19,FollowSets000.FOLLOW_19_in_ruleValuedObjectTestExpression5991); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getValuedObjectTestExpressionAccess().getLeftParenthesisKeyword_0_2(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3806:1: ( (lv_subExpressions_3_0= ruleValuedObjectTestExpression ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3807:1: (lv_subExpressions_3_0= ruleValuedObjectTestExpression )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3807:1: (lv_subExpressions_3_0= ruleValuedObjectTestExpression )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3808:3: lv_subExpressions_3_0= ruleValuedObjectTestExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getValuedObjectTestExpressionAccess().getSubExpressionsValuedObjectTestExpressionParserRuleCall_0_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValuedObjectTestExpression_in_ruleValuedObjectTestExpression6012);
                    lv_subExpressions_3_0=ruleValuedObjectTestExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getValuedObjectTestExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"subExpressions",
                      	        		lv_subExpressions_3_0, 
                      	        		"ValuedObjectTestExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,20,FollowSets000.FOLLOW_20_in_ruleValuedObjectTestExpression6022); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getValuedObjectTestExpressionAccess().getRightParenthesisKeyword_0_4(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3835:6: ( () ( (lv_operator_6_0= ruleValueTestOperator ) ) ( (lv_subExpressions_7_0= ruleValuedObjectReference ) ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3835:6: ( () ( (lv_operator_6_0= ruleValueTestOperator ) ) ( (lv_subExpressions_7_0= ruleValuedObjectReference ) ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3835:7: () ( (lv_operator_6_0= ruleValueTestOperator ) ) ( (lv_subExpressions_7_0= ruleValuedObjectReference ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3835:7: ()
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3836:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getValuedObjectTestExpressionAccess().getOperatorExpressionAction_1_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getValuedObjectTestExpressionAccess().getOperatorExpressionAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3849:2: ( (lv_operator_6_0= ruleValueTestOperator ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3850:1: (lv_operator_6_0= ruleValueTestOperator )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3850:1: (lv_operator_6_0= ruleValueTestOperator )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3851:3: lv_operator_6_0= ruleValueTestOperator
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getValuedObjectTestExpressionAccess().getOperatorValueTestOperatorEnumRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValueTestOperator_in_ruleValuedObjectTestExpression6063);
                    lv_operator_6_0=ruleValueTestOperator();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getValuedObjectTestExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"operator",
                      	        		lv_operator_6_0, 
                      	        		"ValueTestOperator", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3873:2: ( (lv_subExpressions_7_0= ruleValuedObjectReference ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3874:1: (lv_subExpressions_7_0= ruleValuedObjectReference )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3874:1: (lv_subExpressions_7_0= ruleValuedObjectReference )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3875:3: lv_subExpressions_7_0= ruleValuedObjectReference
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getValuedObjectTestExpressionAccess().getSubExpressionsValuedObjectReferenceParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValuedObjectReference_in_ruleValuedObjectTestExpression6084);
                    lv_subExpressions_7_0=ruleValuedObjectReference();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getValuedObjectTestExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"subExpressions",
                      	        		lv_subExpressions_7_0, 
                      	        		"ValuedObjectReference", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3899:2: this_ValuedObjectReference_8= ruleValuedObjectReference
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getValuedObjectTestExpressionAccess().getValuedObjectReferenceParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValuedObjectReference_in_ruleValuedObjectTestExpression6116);
                    this_ValuedObjectReference_8=ruleValuedObjectReference();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_ValuedObjectReference_8; 
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
    // $ANTLR end ruleValuedObjectTestExpression


    // $ANTLR start entryRuleValuedObjectReference
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3918:1: entryRuleValuedObjectReference returns [EObject current=null] : iv_ruleValuedObjectReference= ruleValuedObjectReference EOF ;
    public final EObject entryRuleValuedObjectReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValuedObjectReference = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3919:2: (iv_ruleValuedObjectReference= ruleValuedObjectReference EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3920:2: iv_ruleValuedObjectReference= ruleValuedObjectReference EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getValuedObjectReferenceRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleValuedObjectReference_in_entryRuleValuedObjectReference6151);
            iv_ruleValuedObjectReference=ruleValuedObjectReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleValuedObjectReference; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValuedObjectReference6161); if (failed) return current;

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
    // $ANTLR end entryRuleValuedObjectReference


    // $ANTLR start ruleValuedObjectReference
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3927:1: ruleValuedObjectReference returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleValuedObjectReference() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3932:6: ( ( ( RULE_ID ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3933:1: ( ( RULE_ID ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3933:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3934:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3934:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3935:3: RULE_ID
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getValuedObjectReferenceRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleValuedObjectReference6207); if (failed) return current;
            if ( backtracking==0 ) {

              		createLeafNode(grammarAccess.getValuedObjectReferenceAccess().getValuedObjectValuedObjectCrossReference_0(), "valuedObject"); 
              	
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
    // $ANTLR end ruleValuedObjectReference


    // $ANTLR start entryRuleTextExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3958:1: entryRuleTextExpression returns [EObject current=null] : iv_ruleTextExpression= ruleTextExpression EOF ;
    public final EObject entryRuleTextExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextExpression = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3959:2: (iv_ruleTextExpression= ruleTextExpression EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3960:2: iv_ruleTextExpression= ruleTextExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTextExpressionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTextExpression_in_entryRuleTextExpression6242);
            iv_ruleTextExpression=ruleTextExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTextExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTextExpression6252); if (failed) return current;

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
    // $ANTLR end entryRuleTextExpression


    // $ANTLR start ruleTextExpression
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3967:1: ruleTextExpression returns [EObject current=null] : ( ( (lv_code_0_0= RULE_HOSTCODE ) ) ( '(' ( (lv_type_2_0= RULE_ID ) ) ')' )? ) ;
    public final EObject ruleTextExpression() throws RecognitionException {
        EObject current = null;

        Token lv_code_0_0=null;
        Token lv_type_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3972:6: ( ( ( (lv_code_0_0= RULE_HOSTCODE ) ) ( '(' ( (lv_type_2_0= RULE_ID ) ) ')' )? ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3973:1: ( ( (lv_code_0_0= RULE_HOSTCODE ) ) ( '(' ( (lv_type_2_0= RULE_ID ) ) ')' )? )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3973:1: ( ( (lv_code_0_0= RULE_HOSTCODE ) ) ( '(' ( (lv_type_2_0= RULE_ID ) ) ')' )? )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3973:2: ( (lv_code_0_0= RULE_HOSTCODE ) ) ( '(' ( (lv_type_2_0= RULE_ID ) ) ')' )?
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3973:2: ( (lv_code_0_0= RULE_HOSTCODE ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3974:1: (lv_code_0_0= RULE_HOSTCODE )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3974:1: (lv_code_0_0= RULE_HOSTCODE )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3975:3: lv_code_0_0= RULE_HOSTCODE
            {
            lv_code_0_0=(Token)input.LT(1);
            match(input,RULE_HOSTCODE,FollowSets000.FOLLOW_RULE_HOSTCODE_in_ruleTextExpression6294); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getTextExpressionAccess().getCodeHOSTCODETerminalRuleCall_0_0(), "code"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTextExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"code",
              	        		lv_code_0_0, 
              	        		"HOSTCODE", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3997:2: ( '(' ( (lv_type_2_0= RULE_ID ) ) ')' )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==19) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3997:4: '(' ( (lv_type_2_0= RULE_ID ) ) ')'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleTextExpression6310); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTextExpressionAccess().getLeftParenthesisKeyword_1_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4001:1: ( (lv_type_2_0= RULE_ID ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4002:1: (lv_type_2_0= RULE_ID )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4002:1: (lv_type_2_0= RULE_ID )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4003:3: lv_type_2_0= RULE_ID
                    {
                    lv_type_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTextExpression6327); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getTextExpressionAccess().getTypeIDTerminalRuleCall_1_1_0(), "type"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getTextExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_2_0, 
                      	        		"ID", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    match(input,20,FollowSets000.FOLLOW_20_in_ruleTextExpression6342); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTextExpressionAccess().getRightParenthesisKeyword_1_2(), null); 
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleTextExpression


    // $ANTLR start entryRuleIntValue
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4037:1: entryRuleIntValue returns [EObject current=null] : iv_ruleIntValue= ruleIntValue EOF ;
    public final EObject entryRuleIntValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntValue = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4038:2: (iv_ruleIntValue= ruleIntValue EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4039:2: iv_ruleIntValue= ruleIntValue EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIntValueRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIntValue_in_entryRuleIntValue6380);
            iv_ruleIntValue=ruleIntValue();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleIntValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIntValue6390); if (failed) return current;

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
    // $ANTLR end entryRuleIntValue


    // $ANTLR start ruleIntValue
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4046:1: ruleIntValue returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4051:6: ( ( (lv_value_0_0= RULE_INT ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4052:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4052:1: ( (lv_value_0_0= RULE_INT ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4053:1: (lv_value_0_0= RULE_INT )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4053:1: (lv_value_0_0= RULE_INT )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4054:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleIntValue6431); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getIntValueAccess().getValueINTTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIntValueRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"value",
              	        		lv_value_0_0, 
              	        		"INT", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
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
    // $ANTLR end ruleIntValue


    // $ANTLR start entryRuleFloatValue
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4084:1: entryRuleFloatValue returns [EObject current=null] : iv_ruleFloatValue= ruleFloatValue EOF ;
    public final EObject entryRuleFloatValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatValue = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4085:2: (iv_ruleFloatValue= ruleFloatValue EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4086:2: iv_ruleFloatValue= ruleFloatValue EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFloatValueRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFloatValue_in_entryRuleFloatValue6471);
            iv_ruleFloatValue=ruleFloatValue();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFloatValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFloatValue6481); if (failed) return current;

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
    // $ANTLR end entryRuleFloatValue


    // $ANTLR start ruleFloatValue
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4093:1: ruleFloatValue returns [EObject current=null] : ( (lv_value_0_0= RULE_FLOAT ) ) ;
    public final EObject ruleFloatValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4098:6: ( ( (lv_value_0_0= RULE_FLOAT ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4099:1: ( (lv_value_0_0= RULE_FLOAT ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4099:1: ( (lv_value_0_0= RULE_FLOAT ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4100:1: (lv_value_0_0= RULE_FLOAT )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4100:1: (lv_value_0_0= RULE_FLOAT )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4101:3: lv_value_0_0= RULE_FLOAT
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_FLOAT,FollowSets000.FOLLOW_RULE_FLOAT_in_ruleFloatValue6522); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getFloatValueAccess().getValueFloatTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getFloatValueRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"value",
              	        		lv_value_0_0, 
              	        		"Float", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
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
    // $ANTLR end ruleFloatValue


    // $ANTLR start entryRuleBooleanValue
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4131:1: entryRuleBooleanValue returns [EObject current=null] : iv_ruleBooleanValue= ruleBooleanValue EOF ;
    public final EObject entryRuleBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanValue = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4132:2: (iv_ruleBooleanValue= ruleBooleanValue EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4133:2: iv_ruleBooleanValue= ruleBooleanValue EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBooleanValueRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanValue_in_entryRuleBooleanValue6562);
            iv_ruleBooleanValue=ruleBooleanValue();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBooleanValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanValue6572); if (failed) return current;

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
    // $ANTLR end entryRuleBooleanValue


    // $ANTLR start ruleBooleanValue
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4140:1: ruleBooleanValue returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEAN ) ) ;
    public final EObject ruleBooleanValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4145:6: ( ( (lv_value_0_0= RULE_BOOLEAN ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4146:1: ( (lv_value_0_0= RULE_BOOLEAN ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4146:1: ( (lv_value_0_0= RULE_BOOLEAN ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4147:1: (lv_value_0_0= RULE_BOOLEAN )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4147:1: (lv_value_0_0= RULE_BOOLEAN )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4148:3: lv_value_0_0= RULE_BOOLEAN
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_BOOLEAN,FollowSets000.FOLLOW_RULE_BOOLEAN_in_ruleBooleanValue6613); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getBooleanValueAccess().getValueBooleanTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getBooleanValueRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"value",
              	        		lv_value_0_0, 
              	        		"Boolean", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
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
    // $ANTLR end ruleBooleanValue


    // $ANTLR start entryRuleAnyType
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4178:1: entryRuleAnyType returns [String current=null] : iv_ruleAnyType= ruleAnyType EOF ;
    public final String entryRuleAnyType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnyType = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4179:2: (iv_ruleAnyType= ruleAnyType EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4180:2: iv_ruleAnyType= ruleAnyType EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAnyTypeRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAnyType_in_entryRuleAnyType6654);
            iv_ruleAnyType=ruleAnyType();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAnyType.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAnyType6665); if (failed) return current;

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
    // $ANTLR end entryRuleAnyType


    // $ANTLR start ruleAnyType
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4187:1: ruleAnyType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Boolean_0= RULE_BOOLEAN | this_INT_1= RULE_INT | this_Float_2= RULE_FLOAT | this_ID_3= RULE_ID | this_STRING_4= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleAnyType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_Boolean_0=null;
        Token this_INT_1=null;
        Token this_Float_2=null;
        Token this_ID_3=null;
        Token this_STRING_4=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4192:6: ( (this_Boolean_0= RULE_BOOLEAN | this_INT_1= RULE_INT | this_Float_2= RULE_FLOAT | this_ID_3= RULE_ID | this_STRING_4= RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4193:1: (this_Boolean_0= RULE_BOOLEAN | this_INT_1= RULE_INT | this_Float_2= RULE_FLOAT | this_ID_3= RULE_ID | this_STRING_4= RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4193:1: (this_Boolean_0= RULE_BOOLEAN | this_INT_1= RULE_INT | this_Float_2= RULE_FLOAT | this_ID_3= RULE_ID | this_STRING_4= RULE_STRING )
            int alt72=5;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt72=1;
                }
                break;
            case RULE_INT:
                {
                alt72=2;
                }
                break;
            case RULE_FLOAT:
                {
                alt72=3;
                }
                break;
            case RULE_ID:
                {
                alt72=4;
                }
                break;
            case RULE_STRING:
                {
                alt72=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4193:1: (this_Boolean_0= RULE_BOOLEAN | this_INT_1= RULE_INT | this_Float_2= RULE_FLOAT | this_ID_3= RULE_ID | this_STRING_4= RULE_STRING )", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4193:6: this_Boolean_0= RULE_BOOLEAN
                    {
                    this_Boolean_0=(Token)input.LT(1);
                    match(input,RULE_BOOLEAN,FollowSets000.FOLLOW_RULE_BOOLEAN_in_ruleAnyType6705); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_Boolean_0);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getAnyTypeAccess().getBooleanTerminalRuleCall_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4201:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleAnyType6731); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_INT_1);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getAnyTypeAccess().getINTTerminalRuleCall_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4209:10: this_Float_2= RULE_FLOAT
                    {
                    this_Float_2=(Token)input.LT(1);
                    match(input,RULE_FLOAT,FollowSets000.FOLLOW_RULE_FLOAT_in_ruleAnyType6757); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_Float_2);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getAnyTypeAccess().getFloatTerminalRuleCall_2(), null); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4217:10: this_ID_3= RULE_ID
                    {
                    this_ID_3=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAnyType6783); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_ID_3);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getAnyTypeAccess().getIDTerminalRuleCall_3(), null); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4225:10: this_STRING_4= RULE_STRING
                    {
                    this_STRING_4=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAnyType6809); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_STRING_4);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getAnyTypeAccess().getSTRINGTerminalRuleCall_4(), null); 
                          
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
    // $ANTLR end ruleAnyType


    // $ANTLR start entryRuleInterfaceDeclaration
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4240:1: entryRuleInterfaceDeclaration returns [EObject current=null] : iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF ;
    public final EObject entryRuleInterfaceDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceDeclaration = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4241:2: (iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4242:2: iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getInterfaceDeclarationRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInterfaceDeclaration_in_entryRuleInterfaceDeclaration6854);
            iv_ruleInterfaceDeclaration=ruleInterfaceDeclaration();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleInterfaceDeclaration; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInterfaceDeclaration6864); if (failed) return current;

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
    // $ANTLR end entryRuleInterfaceDeclaration


    // $ANTLR start ruleInterfaceDeclaration
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4249:1: ruleInterfaceDeclaration returns [EObject current=null] : (this_InterfaceSignalDecl_0= ruleInterfaceSignalDecl | this_InterfaceVariableDecl_1= ruleInterfaceVariableDecl ) ;
    public final EObject ruleInterfaceDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_InterfaceSignalDecl_0 = null;

        EObject this_InterfaceVariableDecl_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4254:6: ( (this_InterfaceSignalDecl_0= ruleInterfaceSignalDecl | this_InterfaceVariableDecl_1= ruleInterfaceVariableDecl ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4255:1: (this_InterfaceSignalDecl_0= ruleInterfaceSignalDecl | this_InterfaceVariableDecl_1= ruleInterfaceVariableDecl )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4255:1: (this_InterfaceSignalDecl_0= ruleInterfaceSignalDecl | this_InterfaceVariableDecl_1= ruleInterfaceVariableDecl )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=38 && LA73_0<=39)||(LA73_0>=45 && LA73_0<=46)) ) {
                alt73=1;
            }
            else if ( (LA73_0==43) ) {
                alt73=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4255:1: (this_InterfaceSignalDecl_0= ruleInterfaceSignalDecl | this_InterfaceVariableDecl_1= ruleInterfaceVariableDecl )", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4256:2: this_InterfaceSignalDecl_0= ruleInterfaceSignalDecl
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getInterfaceDeclarationAccess().getInterfaceSignalDeclParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInterfaceSignalDecl_in_ruleInterfaceDeclaration6914);
                    this_InterfaceSignalDecl_0=ruleInterfaceSignalDecl();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_InterfaceSignalDecl_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4269:2: this_InterfaceVariableDecl_1= ruleInterfaceVariableDecl
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getInterfaceDeclarationAccess().getInterfaceVariableDeclParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInterfaceVariableDecl_in_ruleInterfaceDeclaration6944);
                    this_InterfaceVariableDecl_1=ruleInterfaceVariableDecl();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_InterfaceVariableDecl_1; 
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
    // $ANTLR end ruleInterfaceDeclaration


    // $ANTLR start entryRuleISignal
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4288:1: entryRuleISignal returns [EObject current=null] : iv_ruleISignal= ruleISignal EOF ;
    public final EObject entryRuleISignal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleISignal = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4289:2: (iv_ruleISignal= ruleISignal EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4290:2: iv_ruleISignal= ruleISignal EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getISignalRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleISignal_in_entryRuleISignal6979);
            iv_ruleISignal=ruleISignal();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleISignal; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleISignal6989); if (failed) return current;

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
    // $ANTLR end entryRuleISignal


    // $ANTLR start ruleISignal
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4297:1: ruleISignal returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_channelDescr_1_0= ruleChannelDescription ) )? ) ;
    public final EObject ruleISignal() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_channelDescr_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4302:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_channelDescr_1_0= ruleChannelDescription ) )? ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4303:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_channelDescr_1_0= ruleChannelDescription ) )? )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4303:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_channelDescr_1_0= ruleChannelDescription ) )? )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4303:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_channelDescr_1_0= ruleChannelDescription ) )?
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4303:2: ( (lv_name_0_0= RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4304:1: (lv_name_0_0= RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4304:1: (lv_name_0_0= RULE_ID )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4305:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleISignal7031); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getISignalAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getISignalRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_0_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4327:2: ( (lv_channelDescr_1_0= ruleChannelDescription ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==16||LA74_0==19||LA74_0==41) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4328:1: (lv_channelDescr_1_0= ruleChannelDescription )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4328:1: (lv_channelDescr_1_0= ruleChannelDescription )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4329:3: lv_channelDescr_1_0= ruleChannelDescription
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getISignalAccess().getChannelDescrChannelDescriptionParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleChannelDescription_in_ruleISignal7057);
                    lv_channelDescr_1_0=ruleChannelDescription();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getISignalRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"channelDescr",
                      	        		lv_channelDescr_1_0, 
                      	        		"ChannelDescription", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

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
    // $ANTLR end ruleISignal


    // $ANTLR start entryRuleInterfaceSignalDecl
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4359:1: entryRuleInterfaceSignalDecl returns [EObject current=null] : iv_ruleInterfaceSignalDecl= ruleInterfaceSignalDecl EOF ;
    public final EObject entryRuleInterfaceSignalDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceSignalDecl = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4360:2: (iv_ruleInterfaceSignalDecl= ruleInterfaceSignalDecl EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4361:2: iv_ruleInterfaceSignalDecl= ruleInterfaceSignalDecl EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getInterfaceSignalDeclRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInterfaceSignalDecl_in_entryRuleInterfaceSignalDecl7094);
            iv_ruleInterfaceSignalDecl=ruleInterfaceSignalDecl();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleInterfaceSignalDecl; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInterfaceSignalDecl7104); if (failed) return current;

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
    // $ANTLR end entryRuleInterfaceSignalDecl


    // $ANTLR start ruleInterfaceSignalDecl
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4368:1: ruleInterfaceSignalDecl returns [EObject current=null] : ( ( () 'input' ( (lv_signals_2_0= ruleISignal ) ) ( ',' ( (lv_signals_4_0= ruleISignal ) ) )* ';' ) | ( () 'output' ( (lv_signals_8_0= ruleISignal ) ) ( ',' ( (lv_signals_10_0= ruleISignal ) ) )* ';' ) | ( () 'inputoutput' ( (lv_signals_14_0= ruleISignal ) ) ( ',' ( (lv_signals_16_0= ruleISignal ) ) )* ';' ) | ( () 'return' ( (lv_signals_20_0= ruleISignal ) ) ( ',' ( (lv_signals_22_0= ruleISignal ) ) )* ';' ) ) ;
    public final EObject ruleInterfaceSignalDecl() throws RecognitionException {
        EObject current = null;

        EObject lv_signals_2_0 = null;

        EObject lv_signals_4_0 = null;

        EObject lv_signals_8_0 = null;

        EObject lv_signals_10_0 = null;

        EObject lv_signals_14_0 = null;

        EObject lv_signals_16_0 = null;

        EObject lv_signals_20_0 = null;

        EObject lv_signals_22_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4373:6: ( ( ( () 'input' ( (lv_signals_2_0= ruleISignal ) ) ( ',' ( (lv_signals_4_0= ruleISignal ) ) )* ';' ) | ( () 'output' ( (lv_signals_8_0= ruleISignal ) ) ( ',' ( (lv_signals_10_0= ruleISignal ) ) )* ';' ) | ( () 'inputoutput' ( (lv_signals_14_0= ruleISignal ) ) ( ',' ( (lv_signals_16_0= ruleISignal ) ) )* ';' ) | ( () 'return' ( (lv_signals_20_0= ruleISignal ) ) ( ',' ( (lv_signals_22_0= ruleISignal ) ) )* ';' ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4374:1: ( ( () 'input' ( (lv_signals_2_0= ruleISignal ) ) ( ',' ( (lv_signals_4_0= ruleISignal ) ) )* ';' ) | ( () 'output' ( (lv_signals_8_0= ruleISignal ) ) ( ',' ( (lv_signals_10_0= ruleISignal ) ) )* ';' ) | ( () 'inputoutput' ( (lv_signals_14_0= ruleISignal ) ) ( ',' ( (lv_signals_16_0= ruleISignal ) ) )* ';' ) | ( () 'return' ( (lv_signals_20_0= ruleISignal ) ) ( ',' ( (lv_signals_22_0= ruleISignal ) ) )* ';' ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4374:1: ( ( () 'input' ( (lv_signals_2_0= ruleISignal ) ) ( ',' ( (lv_signals_4_0= ruleISignal ) ) )* ';' ) | ( () 'output' ( (lv_signals_8_0= ruleISignal ) ) ( ',' ( (lv_signals_10_0= ruleISignal ) ) )* ';' ) | ( () 'inputoutput' ( (lv_signals_14_0= ruleISignal ) ) ( ',' ( (lv_signals_16_0= ruleISignal ) ) )* ';' ) | ( () 'return' ( (lv_signals_20_0= ruleISignal ) ) ( ',' ( (lv_signals_22_0= ruleISignal ) ) )* ';' ) )
            int alt79=4;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt79=1;
                }
                break;
            case 39:
                {
                alt79=2;
                }
                break;
            case 45:
                {
                alt79=3;
                }
                break;
            case 46:
                {
                alt79=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4374:1: ( ( () 'input' ( (lv_signals_2_0= ruleISignal ) ) ( ',' ( (lv_signals_4_0= ruleISignal ) ) )* ';' ) | ( () 'output' ( (lv_signals_8_0= ruleISignal ) ) ( ',' ( (lv_signals_10_0= ruleISignal ) ) )* ';' ) | ( () 'inputoutput' ( (lv_signals_14_0= ruleISignal ) ) ( ',' ( (lv_signals_16_0= ruleISignal ) ) )* ';' ) | ( () 'return' ( (lv_signals_20_0= ruleISignal ) ) ( ',' ( (lv_signals_22_0= ruleISignal ) ) )* ';' ) )", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4374:2: ( () 'input' ( (lv_signals_2_0= ruleISignal ) ) ( ',' ( (lv_signals_4_0= ruleISignal ) ) )* ';' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4374:2: ( () 'input' ( (lv_signals_2_0= ruleISignal ) ) ( ',' ( (lv_signals_4_0= ruleISignal ) ) )* ';' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4374:3: () 'input' ( (lv_signals_2_0= ruleISignal ) ) ( ',' ( (lv_signals_4_0= ruleISignal ) ) )* ';'
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4374:3: ()
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4375:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getInterfaceSignalDeclAccess().getInputAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getInterfaceSignalDeclAccess().getInputAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,38,FollowSets000.FOLLOW_38_in_ruleInterfaceSignalDecl7152); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getInterfaceSignalDeclAccess().getInputKeyword_0_1(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4392:1: ( (lv_signals_2_0= ruleISignal ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4393:1: (lv_signals_2_0= ruleISignal )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4393:1: (lv_signals_2_0= ruleISignal )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4394:3: lv_signals_2_0= ruleISignal
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getInterfaceSignalDeclAccess().getSignalsISignalParserRuleCall_0_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7173);
                    lv_signals_2_0=ruleISignal();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getInterfaceSignalDeclRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"signals",
                      	        		lv_signals_2_0, 
                      	        		"ISignal", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4416:2: ( ',' ( (lv_signals_4_0= ruleISignal ) ) )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==26) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4416:4: ',' ( (lv_signals_4_0= ruleISignal ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleInterfaceSignalDecl7184); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getInterfaceSignalDeclAccess().getCommaKeyword_0_3_0(), null); 
                    	          
                    	    }
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4420:1: ( (lv_signals_4_0= ruleISignal ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4421:1: (lv_signals_4_0= ruleISignal )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4421:1: (lv_signals_4_0= ruleISignal )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4422:3: lv_signals_4_0= ruleISignal
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getInterfaceSignalDeclAccess().getSignalsISignalParserRuleCall_0_3_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7205);
                    	    lv_signals_4_0=ruleISignal();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getInterfaceSignalDeclRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"signals",
                    	      	        		lv_signals_4_0, 
                    	      	        		"ISignal", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop75;
                        }
                    } while (true);

                    match(input,44,FollowSets000.FOLLOW_44_in_ruleInterfaceSignalDecl7217); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getInterfaceSignalDeclAccess().getSemicolonKeyword_0_4(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4449:6: ( () 'output' ( (lv_signals_8_0= ruleISignal ) ) ( ',' ( (lv_signals_10_0= ruleISignal ) ) )* ';' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4449:6: ( () 'output' ( (lv_signals_8_0= ruleISignal ) ) ( ',' ( (lv_signals_10_0= ruleISignal ) ) )* ';' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4449:7: () 'output' ( (lv_signals_8_0= ruleISignal ) ) ( ',' ( (lv_signals_10_0= ruleISignal ) ) )* ';'
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4449:7: ()
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4450:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getInterfaceSignalDeclAccess().getOutputAction_1_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getInterfaceSignalDeclAccess().getOutputAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,39,FollowSets000.FOLLOW_39_in_ruleInterfaceSignalDecl7247); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getInterfaceSignalDeclAccess().getOutputKeyword_1_1(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4467:1: ( (lv_signals_8_0= ruleISignal ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4468:1: (lv_signals_8_0= ruleISignal )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4468:1: (lv_signals_8_0= ruleISignal )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4469:3: lv_signals_8_0= ruleISignal
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getInterfaceSignalDeclAccess().getSignalsISignalParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7268);
                    lv_signals_8_0=ruleISignal();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getInterfaceSignalDeclRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"signals",
                      	        		lv_signals_8_0, 
                      	        		"ISignal", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4491:2: ( ',' ( (lv_signals_10_0= ruleISignal ) ) )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==26) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4491:4: ',' ( (lv_signals_10_0= ruleISignal ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleInterfaceSignalDecl7279); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getInterfaceSignalDeclAccess().getCommaKeyword_1_3_0(), null); 
                    	          
                    	    }
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4495:1: ( (lv_signals_10_0= ruleISignal ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4496:1: (lv_signals_10_0= ruleISignal )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4496:1: (lv_signals_10_0= ruleISignal )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4497:3: lv_signals_10_0= ruleISignal
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getInterfaceSignalDeclAccess().getSignalsISignalParserRuleCall_1_3_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7300);
                    	    lv_signals_10_0=ruleISignal();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getInterfaceSignalDeclRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"signals",
                    	      	        		lv_signals_10_0, 
                    	      	        		"ISignal", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop76;
                        }
                    } while (true);

                    match(input,44,FollowSets000.FOLLOW_44_in_ruleInterfaceSignalDecl7312); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getInterfaceSignalDeclAccess().getSemicolonKeyword_1_4(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4524:6: ( () 'inputoutput' ( (lv_signals_14_0= ruleISignal ) ) ( ',' ( (lv_signals_16_0= ruleISignal ) ) )* ';' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4524:6: ( () 'inputoutput' ( (lv_signals_14_0= ruleISignal ) ) ( ',' ( (lv_signals_16_0= ruleISignal ) ) )* ';' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4524:7: () 'inputoutput' ( (lv_signals_14_0= ruleISignal ) ) ( ',' ( (lv_signals_16_0= ruleISignal ) ) )* ';'
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4524:7: ()
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4525:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getInterfaceSignalDeclAccess().getInputOutputAction_2_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getInterfaceSignalDeclAccess().getInputOutputAction_2_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,45,FollowSets000.FOLLOW_45_in_ruleInterfaceSignalDecl7342); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getInterfaceSignalDeclAccess().getInputoutputKeyword_2_1(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4542:1: ( (lv_signals_14_0= ruleISignal ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4543:1: (lv_signals_14_0= ruleISignal )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4543:1: (lv_signals_14_0= ruleISignal )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4544:3: lv_signals_14_0= ruleISignal
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getInterfaceSignalDeclAccess().getSignalsISignalParserRuleCall_2_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7363);
                    lv_signals_14_0=ruleISignal();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getInterfaceSignalDeclRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"signals",
                      	        		lv_signals_14_0, 
                      	        		"ISignal", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4566:2: ( ',' ( (lv_signals_16_0= ruleISignal ) ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==26) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4566:4: ',' ( (lv_signals_16_0= ruleISignal ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleInterfaceSignalDecl7374); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getInterfaceSignalDeclAccess().getCommaKeyword_2_3_0(), null); 
                    	          
                    	    }
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4570:1: ( (lv_signals_16_0= ruleISignal ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4571:1: (lv_signals_16_0= ruleISignal )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4571:1: (lv_signals_16_0= ruleISignal )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4572:3: lv_signals_16_0= ruleISignal
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getInterfaceSignalDeclAccess().getSignalsISignalParserRuleCall_2_3_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7395);
                    	    lv_signals_16_0=ruleISignal();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getInterfaceSignalDeclRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"signals",
                    	      	        		lv_signals_16_0, 
                    	      	        		"ISignal", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop77;
                        }
                    } while (true);

                    match(input,44,FollowSets000.FOLLOW_44_in_ruleInterfaceSignalDecl7407); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getInterfaceSignalDeclAccess().getSemicolonKeyword_2_4(), null); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4599:6: ( () 'return' ( (lv_signals_20_0= ruleISignal ) ) ( ',' ( (lv_signals_22_0= ruleISignal ) ) )* ';' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4599:6: ( () 'return' ( (lv_signals_20_0= ruleISignal ) ) ( ',' ( (lv_signals_22_0= ruleISignal ) ) )* ';' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4599:7: () 'return' ( (lv_signals_20_0= ruleISignal ) ) ( ',' ( (lv_signals_22_0= ruleISignal ) ) )* ';'
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4599:7: ()
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4600:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getInterfaceSignalDeclAccess().getReturnAction_3_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getInterfaceSignalDeclAccess().getReturnAction_3_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,46,FollowSets000.FOLLOW_46_in_ruleInterfaceSignalDecl7437); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getInterfaceSignalDeclAccess().getReturnKeyword_3_1(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4617:1: ( (lv_signals_20_0= ruleISignal ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4618:1: (lv_signals_20_0= ruleISignal )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4618:1: (lv_signals_20_0= ruleISignal )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4619:3: lv_signals_20_0= ruleISignal
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getInterfaceSignalDeclAccess().getSignalsISignalParserRuleCall_3_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7458);
                    lv_signals_20_0=ruleISignal();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getInterfaceSignalDeclRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"signals",
                      	        		lv_signals_20_0, 
                      	        		"ISignal", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4641:2: ( ',' ( (lv_signals_22_0= ruleISignal ) ) )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==26) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4641:4: ',' ( (lv_signals_22_0= ruleISignal ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleInterfaceSignalDecl7469); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getInterfaceSignalDeclAccess().getCommaKeyword_3_3_0(), null); 
                    	          
                    	    }
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4645:1: ( (lv_signals_22_0= ruleISignal ) )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4646:1: (lv_signals_22_0= ruleISignal )
                    	    {
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4646:1: (lv_signals_22_0= ruleISignal )
                    	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4647:3: lv_signals_22_0= ruleISignal
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getInterfaceSignalDeclAccess().getSignalsISignalParserRuleCall_3_3_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7490);
                    	    lv_signals_22_0=ruleISignal();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getInterfaceSignalDeclRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"signals",
                    	      	        		lv_signals_22_0, 
                    	      	        		"ISignal", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop78;
                        }
                    } while (true);

                    match(input,44,FollowSets000.FOLLOW_44_in_ruleInterfaceSignalDecl7502); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getInterfaceSignalDeclAccess().getSemicolonKeyword_3_4(), null); 
                          
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
    // $ANTLR end ruleInterfaceSignalDecl


    // $ANTLR start entryRuleChannelDescription
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4681:1: entryRuleChannelDescription returns [EObject current=null] : iv_ruleChannelDescription= ruleChannelDescription EOF ;
    public final EObject entryRuleChannelDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChannelDescription = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4682:2: (iv_ruleChannelDescription= ruleChannelDescription EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4683:2: iv_ruleChannelDescription= ruleChannelDescription EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getChannelDescriptionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleChannelDescription_in_entryRuleChannelDescription7539);
            iv_ruleChannelDescription=ruleChannelDescription();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleChannelDescription; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChannelDescription7549); if (failed) return current;

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
    // $ANTLR end entryRuleChannelDescription


    // $ANTLR start ruleChannelDescription
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4690:1: ruleChannelDescription returns [EObject current=null] : ( ( ':' ( (lv_type_1_0= ruleTypeIdentifier ) ) ) | ( '(' ( (lv_type_3_0= ruleTypeIdentifier ) ) ')' ) | ( ':=' ( (lv_expression_6_0= ruleExpression ) ) ':' ( (lv_type_8_0= ruleTypeIdentifier ) ) ) ) ;
    public final EObject ruleChannelDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1_0 = null;

        EObject lv_type_3_0 = null;

        EObject lv_expression_6_0 = null;

        EObject lv_type_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4695:6: ( ( ( ':' ( (lv_type_1_0= ruleTypeIdentifier ) ) ) | ( '(' ( (lv_type_3_0= ruleTypeIdentifier ) ) ')' ) | ( ':=' ( (lv_expression_6_0= ruleExpression ) ) ':' ( (lv_type_8_0= ruleTypeIdentifier ) ) ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4696:1: ( ( ':' ( (lv_type_1_0= ruleTypeIdentifier ) ) ) | ( '(' ( (lv_type_3_0= ruleTypeIdentifier ) ) ')' ) | ( ':=' ( (lv_expression_6_0= ruleExpression ) ) ':' ( (lv_type_8_0= ruleTypeIdentifier ) ) ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4696:1: ( ( ':' ( (lv_type_1_0= ruleTypeIdentifier ) ) ) | ( '(' ( (lv_type_3_0= ruleTypeIdentifier ) ) ')' ) | ( ':=' ( (lv_expression_6_0= ruleExpression ) ) ':' ( (lv_type_8_0= ruleTypeIdentifier ) ) ) )
            int alt80=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt80=1;
                }
                break;
            case 19:
                {
                alt80=2;
                }
                break;
            case 41:
                {
                alt80=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4696:1: ( ( ':' ( (lv_type_1_0= ruleTypeIdentifier ) ) ) | ( '(' ( (lv_type_3_0= ruleTypeIdentifier ) ) ')' ) | ( ':=' ( (lv_expression_6_0= ruleExpression ) ) ':' ( (lv_type_8_0= ruleTypeIdentifier ) ) ) )", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4696:2: ( ':' ( (lv_type_1_0= ruleTypeIdentifier ) ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4696:2: ( ':' ( (lv_type_1_0= ruleTypeIdentifier ) ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4696:4: ':' ( (lv_type_1_0= ruleTypeIdentifier ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleChannelDescription7585); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getChannelDescriptionAccess().getColonKeyword_0_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4700:1: ( (lv_type_1_0= ruleTypeIdentifier ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4701:1: (lv_type_1_0= ruleTypeIdentifier )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4701:1: (lv_type_1_0= ruleTypeIdentifier )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4702:3: lv_type_1_0= ruleTypeIdentifier
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getChannelDescriptionAccess().getTypeTypeIdentifierParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeIdentifier_in_ruleChannelDescription7606);
                    lv_type_1_0=ruleTypeIdentifier();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getChannelDescriptionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_1_0, 
                      	        		"TypeIdentifier", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4725:6: ( '(' ( (lv_type_3_0= ruleTypeIdentifier ) ) ')' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4725:6: ( '(' ( (lv_type_3_0= ruleTypeIdentifier ) ) ')' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4725:8: '(' ( (lv_type_3_0= ruleTypeIdentifier ) ) ')'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleChannelDescription7624); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getChannelDescriptionAccess().getLeftParenthesisKeyword_1_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4729:1: ( (lv_type_3_0= ruleTypeIdentifier ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4730:1: (lv_type_3_0= ruleTypeIdentifier )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4730:1: (lv_type_3_0= ruleTypeIdentifier )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4731:3: lv_type_3_0= ruleTypeIdentifier
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getChannelDescriptionAccess().getTypeTypeIdentifierParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeIdentifier_in_ruleChannelDescription7645);
                    lv_type_3_0=ruleTypeIdentifier();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getChannelDescriptionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_3_0, 
                      	        		"TypeIdentifier", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,20,FollowSets000.FOLLOW_20_in_ruleChannelDescription7655); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getChannelDescriptionAccess().getRightParenthesisKeyword_1_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4758:6: ( ':=' ( (lv_expression_6_0= ruleExpression ) ) ':' ( (lv_type_8_0= ruleTypeIdentifier ) ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4758:6: ( ':=' ( (lv_expression_6_0= ruleExpression ) ) ':' ( (lv_type_8_0= ruleTypeIdentifier ) ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4758:8: ':=' ( (lv_expression_6_0= ruleExpression ) ) ':' ( (lv_type_8_0= ruleTypeIdentifier ) )
                    {
                    match(input,41,FollowSets000.FOLLOW_41_in_ruleChannelDescription7673); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getChannelDescriptionAccess().getColonEqualsSignKeyword_2_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4762:1: ( (lv_expression_6_0= ruleExpression ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4763:1: (lv_expression_6_0= ruleExpression )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4763:1: (lv_expression_6_0= ruleExpression )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4764:3: lv_expression_6_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getChannelDescriptionAccess().getExpressionExpressionParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleChannelDescription7694);
                    lv_expression_6_0=ruleExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getChannelDescriptionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"expression",
                      	        		lv_expression_6_0, 
                      	        		"Expression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,16,FollowSets000.FOLLOW_16_in_ruleChannelDescription7704); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getChannelDescriptionAccess().getColonKeyword_2_2(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4790:1: ( (lv_type_8_0= ruleTypeIdentifier ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4791:1: (lv_type_8_0= ruleTypeIdentifier )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4791:1: (lv_type_8_0= ruleTypeIdentifier )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4792:3: lv_type_8_0= ruleTypeIdentifier
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getChannelDescriptionAccess().getTypeTypeIdentifierParserRuleCall_2_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeIdentifier_in_ruleChannelDescription7725);
                    lv_type_8_0=ruleTypeIdentifier();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getChannelDescriptionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_8_0, 
                      	        		"TypeIdentifier", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


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
    // $ANTLR end ruleChannelDescription


    // $ANTLR start entryRuleInterfaceVariableDecl
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4822:1: entryRuleInterfaceVariableDecl returns [EObject current=null] : iv_ruleInterfaceVariableDecl= ruleInterfaceVariableDecl EOF ;
    public final EObject entryRuleInterfaceVariableDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceVariableDecl = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4823:2: (iv_ruleInterfaceVariableDecl= ruleInterfaceVariableDecl EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4824:2: iv_ruleInterfaceVariableDecl= ruleInterfaceVariableDecl EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getInterfaceVariableDeclRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInterfaceVariableDecl_in_entryRuleInterfaceVariableDecl7762);
            iv_ruleInterfaceVariableDecl=ruleInterfaceVariableDecl();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleInterfaceVariableDecl; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInterfaceVariableDecl7772); if (failed) return current;

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
    // $ANTLR end entryRuleInterfaceVariableDecl


    // $ANTLR start ruleInterfaceVariableDecl
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4831:1: ruleInterfaceVariableDecl returns [EObject current=null] : ( 'var' ( (lv_varDecls_1_0= ruleVariableDecl ) ) ( ',' ( (lv_varDecls_3_0= ruleVariableDecl ) ) )* ) ;
    public final EObject ruleInterfaceVariableDecl() throws RecognitionException {
        EObject current = null;

        EObject lv_varDecls_1_0 = null;

        EObject lv_varDecls_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4836:6: ( ( 'var' ( (lv_varDecls_1_0= ruleVariableDecl ) ) ( ',' ( (lv_varDecls_3_0= ruleVariableDecl ) ) )* ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4837:1: ( 'var' ( (lv_varDecls_1_0= ruleVariableDecl ) ) ( ',' ( (lv_varDecls_3_0= ruleVariableDecl ) ) )* )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4837:1: ( 'var' ( (lv_varDecls_1_0= ruleVariableDecl ) ) ( ',' ( (lv_varDecls_3_0= ruleVariableDecl ) ) )* )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4837:3: 'var' ( (lv_varDecls_1_0= ruleVariableDecl ) ) ( ',' ( (lv_varDecls_3_0= ruleVariableDecl ) ) )*
            {
            match(input,43,FollowSets000.FOLLOW_43_in_ruleInterfaceVariableDecl7807); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getInterfaceVariableDeclAccess().getVarKeyword_0(), null); 
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4841:1: ( (lv_varDecls_1_0= ruleVariableDecl ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4842:1: (lv_varDecls_1_0= ruleVariableDecl )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4842:1: (lv_varDecls_1_0= ruleVariableDecl )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4843:3: lv_varDecls_1_0= ruleVariableDecl
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getInterfaceVariableDeclAccess().getVarDeclsVariableDeclParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariableDecl_in_ruleInterfaceVariableDecl7828);
            lv_varDecls_1_0=ruleVariableDecl();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getInterfaceVariableDeclRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		add(
              	       			current, 
              	       			"varDecls",
              	        		lv_varDecls_1_0, 
              	        		"VariableDecl", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4865:2: ( ',' ( (lv_varDecls_3_0= ruleVariableDecl ) ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==26) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4865:4: ',' ( (lv_varDecls_3_0= ruleVariableDecl ) )
            	    {
            	    match(input,26,FollowSets000.FOLLOW_26_in_ruleInterfaceVariableDecl7839); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getInterfaceVariableDeclAccess().getCommaKeyword_2_0(), null); 
            	          
            	    }
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4869:1: ( (lv_varDecls_3_0= ruleVariableDecl ) )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4870:1: (lv_varDecls_3_0= ruleVariableDecl )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4870:1: (lv_varDecls_3_0= ruleVariableDecl )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4871:3: lv_varDecls_3_0= ruleVariableDecl
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getInterfaceVariableDeclAccess().getVarDeclsVariableDeclParserRuleCall_2_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleVariableDecl_in_ruleInterfaceVariableDecl7860);
            	    lv_varDecls_3_0=ruleVariableDecl();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getInterfaceVariableDeclRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"varDecls",
            	      	        		lv_varDecls_3_0, 
            	      	        		"VariableDecl", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop81;
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
    // $ANTLR end ruleInterfaceVariableDecl


    // $ANTLR start entryRuleVariableDecl
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4901:1: entryRuleVariableDecl returns [EObject current=null] : iv_ruleVariableDecl= ruleVariableDecl EOF ;
    public final EObject entryRuleVariableDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDecl = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4902:2: (iv_ruleVariableDecl= ruleVariableDecl EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4903:2: iv_ruleVariableDecl= ruleVariableDecl EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getVariableDeclRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVariableDecl_in_entryRuleVariableDecl7898);
            iv_ruleVariableDecl=ruleVariableDecl();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleVariableDecl; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariableDecl7908); if (failed) return current;

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
    // $ANTLR end entryRuleVariableDecl


    // $ANTLR start ruleVariableDecl
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4910:1: ruleVariableDecl returns [EObject current=null] : ( ( (lv_variables_0_0= ruleIVariable ) ) ( ',' ( (lv_variables_2_0= ruleIVariable ) ) )* ':' ( (lv_type_4_0= ruleTypeIdentifier ) ) ) ;
    public final EObject ruleVariableDecl() throws RecognitionException {
        EObject current = null;

        EObject lv_variables_0_0 = null;

        EObject lv_variables_2_0 = null;

        EObject lv_type_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4915:6: ( ( ( (lv_variables_0_0= ruleIVariable ) ) ( ',' ( (lv_variables_2_0= ruleIVariable ) ) )* ':' ( (lv_type_4_0= ruleTypeIdentifier ) ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4916:1: ( ( (lv_variables_0_0= ruleIVariable ) ) ( ',' ( (lv_variables_2_0= ruleIVariable ) ) )* ':' ( (lv_type_4_0= ruleTypeIdentifier ) ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4916:1: ( ( (lv_variables_0_0= ruleIVariable ) ) ( ',' ( (lv_variables_2_0= ruleIVariable ) ) )* ':' ( (lv_type_4_0= ruleTypeIdentifier ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4916:2: ( (lv_variables_0_0= ruleIVariable ) ) ( ',' ( (lv_variables_2_0= ruleIVariable ) ) )* ':' ( (lv_type_4_0= ruleTypeIdentifier ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4916:2: ( (lv_variables_0_0= ruleIVariable ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4917:1: (lv_variables_0_0= ruleIVariable )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4917:1: (lv_variables_0_0= ruleIVariable )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4918:3: lv_variables_0_0= ruleIVariable
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getVariableDeclAccess().getVariablesIVariableParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIVariable_in_ruleVariableDecl7954);
            lv_variables_0_0=ruleIVariable();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getVariableDeclRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		add(
              	       			current, 
              	       			"variables",
              	        		lv_variables_0_0, 
              	        		"IVariable", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4940:2: ( ',' ( (lv_variables_2_0= ruleIVariable ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==26) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4940:4: ',' ( (lv_variables_2_0= ruleIVariable ) )
            	    {
            	    match(input,26,FollowSets000.FOLLOW_26_in_ruleVariableDecl7965); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getVariableDeclAccess().getCommaKeyword_1_0(), null); 
            	          
            	    }
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4944:1: ( (lv_variables_2_0= ruleIVariable ) )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4945:1: (lv_variables_2_0= ruleIVariable )
            	    {
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4945:1: (lv_variables_2_0= ruleIVariable )
            	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4946:3: lv_variables_2_0= ruleIVariable
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getVariableDeclAccess().getVariablesIVariableParserRuleCall_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleIVariable_in_ruleVariableDecl7986);
            	    lv_variables_2_0=ruleIVariable();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getVariableDeclRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"variables",
            	      	        		lv_variables_2_0, 
            	      	        		"IVariable", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);

            match(input,16,FollowSets000.FOLLOW_16_in_ruleVariableDecl7998); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getVariableDeclAccess().getColonKeyword_2(), null); 
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4972:1: ( (lv_type_4_0= ruleTypeIdentifier ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4973:1: (lv_type_4_0= ruleTypeIdentifier )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4973:1: (lv_type_4_0= ruleTypeIdentifier )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:4974:3: lv_type_4_0= ruleTypeIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getVariableDeclAccess().getTypeTypeIdentifierParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeIdentifier_in_ruleVariableDecl8019);
            lv_type_4_0=ruleTypeIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getVariableDeclRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_4_0, 
              	        		"TypeIdentifier", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

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
    // $ANTLR end ruleVariableDecl


    // $ANTLR start entryRuleIVariable
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5004:1: entryRuleIVariable returns [EObject current=null] : iv_ruleIVariable= ruleIVariable EOF ;
    public final EObject entryRuleIVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIVariable = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5005:2: (iv_ruleIVariable= ruleIVariable EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5006:2: iv_ruleIVariable= ruleIVariable EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIVariableRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIVariable_in_entryRuleIVariable8055);
            iv_ruleIVariable=ruleIVariable();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleIVariable; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIVariable8065); if (failed) return current;

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
    // $ANTLR end entryRuleIVariable


    // $ANTLR start ruleIVariable
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5013:1: ruleIVariable returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ':=' ( (lv_expression_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleIVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_expression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5018:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ':=' ( (lv_expression_2_0= ruleExpression ) ) )? ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5019:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ':=' ( (lv_expression_2_0= ruleExpression ) ) )? )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5019:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ':=' ( (lv_expression_2_0= ruleExpression ) ) )? )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5019:2: ( (lv_name_0_0= RULE_ID ) ) ( ':=' ( (lv_expression_2_0= ruleExpression ) ) )?
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5019:2: ( (lv_name_0_0= RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5020:1: (lv_name_0_0= RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5020:1: (lv_name_0_0= RULE_ID )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5021:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIVariable8107); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getIVariableAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIVariableRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_0_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5043:2: ( ':=' ( (lv_expression_2_0= ruleExpression ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==41) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5043:4: ':=' ( (lv_expression_2_0= ruleExpression ) )
                    {
                    match(input,41,FollowSets000.FOLLOW_41_in_ruleIVariable8123); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getIVariableAccess().getColonEqualsSignKeyword_1_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5047:1: ( (lv_expression_2_0= ruleExpression ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5048:1: (lv_expression_2_0= ruleExpression )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5048:1: (lv_expression_2_0= ruleExpression )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5049:3: lv_expression_2_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getIVariableAccess().getExpressionExpressionParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleIVariable8144);
                    lv_expression_2_0=ruleExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getIVariableRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"expression",
                      	        		lv_expression_2_0, 
                      	        		"Expression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

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
    // $ANTLR end ruleIVariable


    // $ANTLR start entryRuleTypeIdentifier
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5079:1: entryRuleTypeIdentifier returns [EObject current=null] : iv_ruleTypeIdentifier= ruleTypeIdentifier EOF ;
    public final EObject entryRuleTypeIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeIdentifier = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5080:2: (iv_ruleTypeIdentifier= ruleTypeIdentifier EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5081:2: iv_ruleTypeIdentifier= ruleTypeIdentifier EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeIdentifierRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeIdentifier_in_entryRuleTypeIdentifier8182);
            iv_ruleTypeIdentifier=ruleTypeIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTypeIdentifier; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeIdentifier8192); if (failed) return current;

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
    // $ANTLR end entryRuleTypeIdentifier


    // $ANTLR start ruleTypeIdentifier
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5088:1: ruleTypeIdentifier returns [EObject current=null] : ( ( (lv_type_0_0= ruleValueType ) ) | ( (lv_typeID_1_0= RULE_ID ) ) | ( 'combine' ( ( (lv_type_3_0= ruleValueType ) ) | ( (lv_typeID_4_0= RULE_ID ) ) ) 'with' ( (lv_operator_6_0= ruleCombineOperator ) ) ) ) ;
    public final EObject ruleTypeIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_typeID_1_0=null;
        Token lv_typeID_4_0=null;
        Enumerator lv_type_0_0 = null;

        Enumerator lv_type_3_0 = null;

        Enumerator lv_operator_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5093:6: ( ( ( (lv_type_0_0= ruleValueType ) ) | ( (lv_typeID_1_0= RULE_ID ) ) | ( 'combine' ( ( (lv_type_3_0= ruleValueType ) ) | ( (lv_typeID_4_0= RULE_ID ) ) ) 'with' ( (lv_operator_6_0= ruleCombineOperator ) ) ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5094:1: ( ( (lv_type_0_0= ruleValueType ) ) | ( (lv_typeID_1_0= RULE_ID ) ) | ( 'combine' ( ( (lv_type_3_0= ruleValueType ) ) | ( (lv_typeID_4_0= RULE_ID ) ) ) 'with' ( (lv_operator_6_0= ruleCombineOperator ) ) ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5094:1: ( ( (lv_type_0_0= ruleValueType ) ) | ( (lv_typeID_1_0= RULE_ID ) ) | ( 'combine' ( ( (lv_type_3_0= ruleValueType ) ) | ( (lv_typeID_4_0= RULE_ID ) ) ) 'with' ( (lv_operator_6_0= ruleCombineOperator ) ) ) )
            int alt85=3;
            switch ( input.LA(1) ) {
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
                {
                alt85=1;
                }
                break;
            case RULE_ID:
                {
                alt85=2;
                }
                break;
            case 42:
                {
                alt85=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("5094:1: ( ( (lv_type_0_0= ruleValueType ) ) | ( (lv_typeID_1_0= RULE_ID ) ) | ( 'combine' ( ( (lv_type_3_0= ruleValueType ) ) | ( (lv_typeID_4_0= RULE_ID ) ) ) 'with' ( (lv_operator_6_0= ruleCombineOperator ) ) ) )", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5094:2: ( (lv_type_0_0= ruleValueType ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5094:2: ( (lv_type_0_0= ruleValueType ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5095:1: (lv_type_0_0= ruleValueType )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5095:1: (lv_type_0_0= ruleValueType )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5096:3: lv_type_0_0= ruleValueType
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getTypeIdentifierAccess().getTypeValueTypeEnumRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleValueType_in_ruleTypeIdentifier8238);
                    lv_type_0_0=ruleValueType();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getTypeIdentifierRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_0_0, 
                      	        		"ValueType", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5119:6: ( (lv_typeID_1_0= RULE_ID ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5119:6: ( (lv_typeID_1_0= RULE_ID ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5120:1: (lv_typeID_1_0= RULE_ID )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5120:1: (lv_typeID_1_0= RULE_ID )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5121:3: lv_typeID_1_0= RULE_ID
                    {
                    lv_typeID_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeIdentifier8261); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getTypeIdentifierAccess().getTypeIDIDTerminalRuleCall_1_0(), "typeID"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getTypeIdentifierRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"typeID",
                      	        		lv_typeID_1_0, 
                      	        		"ID", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5144:6: ( 'combine' ( ( (lv_type_3_0= ruleValueType ) ) | ( (lv_typeID_4_0= RULE_ID ) ) ) 'with' ( (lv_operator_6_0= ruleCombineOperator ) ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5144:6: ( 'combine' ( ( (lv_type_3_0= ruleValueType ) ) | ( (lv_typeID_4_0= RULE_ID ) ) ) 'with' ( (lv_operator_6_0= ruleCombineOperator ) ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5144:8: 'combine' ( ( (lv_type_3_0= ruleValueType ) ) | ( (lv_typeID_4_0= RULE_ID ) ) ) 'with' ( (lv_operator_6_0= ruleCombineOperator ) )
                    {
                    match(input,42,FollowSets000.FOLLOW_42_in_ruleTypeIdentifier8283); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTypeIdentifierAccess().getCombineKeyword_2_0(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5148:1: ( ( (lv_type_3_0= ruleValueType ) ) | ( (lv_typeID_4_0= RULE_ID ) ) )
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( ((LA84_0>=69 && LA84_0<=74)) ) {
                        alt84=1;
                    }
                    else if ( (LA84_0==RULE_ID) ) {
                        alt84=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("5148:1: ( ( (lv_type_3_0= ruleValueType ) ) | ( (lv_typeID_4_0= RULE_ID ) ) )", 84, 0, input);

                        throw nvae;
                    }
                    switch (alt84) {
                        case 1 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5148:2: ( (lv_type_3_0= ruleValueType ) )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5148:2: ( (lv_type_3_0= ruleValueType ) )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5149:1: (lv_type_3_0= ruleValueType )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5149:1: (lv_type_3_0= ruleValueType )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5150:3: lv_type_3_0= ruleValueType
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getTypeIdentifierAccess().getTypeValueTypeEnumRuleCall_2_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleValueType_in_ruleTypeIdentifier8305);
                            lv_type_3_0=ruleValueType();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getTypeIdentifierRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"type",
                              	        		lv_type_3_0, 
                              	        		"ValueType", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5173:6: ( (lv_typeID_4_0= RULE_ID ) )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5173:6: ( (lv_typeID_4_0= RULE_ID ) )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5174:1: (lv_typeID_4_0= RULE_ID )
                            {
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5174:1: (lv_typeID_4_0= RULE_ID )
                            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5175:3: lv_typeID_4_0= RULE_ID
                            {
                            lv_typeID_4_0=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeIdentifier8328); if (failed) return current;
                            if ( backtracking==0 ) {

                              			createLeafNode(grammarAccess.getTypeIdentifierAccess().getTypeIDIDTerminalRuleCall_2_1_1_0(), "typeID"); 
                              		
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getTypeIdentifierRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"typeID",
                              	        		lv_typeID_4_0, 
                              	        		"ID", 
                              	        		lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    match(input,34,FollowSets000.FOLLOW_34_in_ruleTypeIdentifier8344); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTypeIdentifierAccess().getWithKeyword_2_2(), null); 
                          
                    }
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5201:1: ( (lv_operator_6_0= ruleCombineOperator ) )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5202:1: (lv_operator_6_0= ruleCombineOperator )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5202:1: (lv_operator_6_0= ruleCombineOperator )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5203:3: lv_operator_6_0= ruleCombineOperator
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getTypeIdentifierAccess().getOperatorCombineOperatorEnumRuleCall_2_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCombineOperator_in_ruleTypeIdentifier8365);
                    lv_operator_6_0=ruleCombineOperator();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getTypeIdentifierRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"operator",
                      	        		lv_operator_6_0, 
                      	        		"CombineOperator", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


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
    // $ANTLR end ruleTypeIdentifier


    // $ANTLR start entryRuleStringAnnotation
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5233:1: entryRuleStringAnnotation returns [EObject current=null] : iv_ruleStringAnnotation= ruleStringAnnotation EOF ;
    public final EObject entryRuleStringAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringAnnotation = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5234:2: (iv_ruleStringAnnotation= ruleStringAnnotation EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5235:2: iv_ruleStringAnnotation= ruleStringAnnotation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStringAnnotationRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringAnnotation_in_entryRuleStringAnnotation8402);
            iv_ruleStringAnnotation=ruleStringAnnotation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleStringAnnotation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringAnnotation8412); if (failed) return current;

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
    // $ANTLR end entryRuleStringAnnotation


    // $ANTLR start ruleStringAnnotation
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5242:1: ruleStringAnnotation returns [EObject current=null] : (this_CommentAnnotation_0= ruleCommentAnnotation | this_KeyValueAnnotation_1= ruleKeyValueAnnotation ) ;
    public final EObject ruleStringAnnotation() throws RecognitionException {
        EObject current = null;

        EObject this_CommentAnnotation_0 = null;

        EObject this_KeyValueAnnotation_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5247:6: ( (this_CommentAnnotation_0= ruleCommentAnnotation | this_KeyValueAnnotation_1= ruleKeyValueAnnotation ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5248:1: (this_CommentAnnotation_0= ruleCommentAnnotation | this_KeyValueAnnotation_1= ruleKeyValueAnnotation )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5248:1: (this_CommentAnnotation_0= ruleCommentAnnotation | this_KeyValueAnnotation_1= ruleKeyValueAnnotation )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_COMMENT_ANNOTATION) ) {
                alt86=1;
            }
            else if ( (LA86_0==24) ) {
                alt86=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("5248:1: (this_CommentAnnotation_0= ruleCommentAnnotation | this_KeyValueAnnotation_1= ruleKeyValueAnnotation )", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5249:2: this_CommentAnnotation_0= ruleCommentAnnotation
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getStringAnnotationAccess().getCommentAnnotationParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCommentAnnotation_in_ruleStringAnnotation8462);
                    this_CommentAnnotation_0=ruleCommentAnnotation();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_CommentAnnotation_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5262:2: this_KeyValueAnnotation_1= ruleKeyValueAnnotation
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getStringAnnotationAccess().getKeyValueAnnotationParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleKeyValueAnnotation_in_ruleStringAnnotation8492);
                    this_KeyValueAnnotation_1=ruleKeyValueAnnotation();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_KeyValueAnnotation_1; 
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
    // $ANTLR end ruleStringAnnotation


    // $ANTLR start entryRuleCommentAnnotation
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5281:1: entryRuleCommentAnnotation returns [EObject current=null] : iv_ruleCommentAnnotation= ruleCommentAnnotation EOF ;
    public final EObject entryRuleCommentAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommentAnnotation = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5282:2: (iv_ruleCommentAnnotation= ruleCommentAnnotation EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5283:2: iv_ruleCommentAnnotation= ruleCommentAnnotation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCommentAnnotationRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCommentAnnotation_in_entryRuleCommentAnnotation8527);
            iv_ruleCommentAnnotation=ruleCommentAnnotation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCommentAnnotation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCommentAnnotation8537); if (failed) return current;

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
    // $ANTLR end entryRuleCommentAnnotation


    // $ANTLR start ruleCommentAnnotation
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5290:1: ruleCommentAnnotation returns [EObject current=null] : ( (lv_value_0_0= RULE_COMMENT_ANNOTATION ) ) ;
    public final EObject ruleCommentAnnotation() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5295:6: ( ( (lv_value_0_0= RULE_COMMENT_ANNOTATION ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5296:1: ( (lv_value_0_0= RULE_COMMENT_ANNOTATION ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5296:1: ( (lv_value_0_0= RULE_COMMENT_ANNOTATION ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5297:1: (lv_value_0_0= RULE_COMMENT_ANNOTATION )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5297:1: (lv_value_0_0= RULE_COMMENT_ANNOTATION )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5298:3: lv_value_0_0= RULE_COMMENT_ANNOTATION
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_COMMENT_ANNOTATION,FollowSets000.FOLLOW_RULE_COMMENT_ANNOTATION_in_ruleCommentAnnotation8578); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getCommentAnnotationAccess().getValueCOMMENT_ANNOTATIONTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getCommentAnnotationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"value",
              	        		lv_value_0_0, 
              	        		"COMMENT_ANNOTATION", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
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
    // $ANTLR end ruleCommentAnnotation


    // $ANTLR start entryRuleKeyValueAnnotation
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5328:1: entryRuleKeyValueAnnotation returns [EObject current=null] : iv_ruleKeyValueAnnotation= ruleKeyValueAnnotation EOF ;
    public final EObject entryRuleKeyValueAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValueAnnotation = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5329:2: (iv_ruleKeyValueAnnotation= ruleKeyValueAnnotation EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5330:2: iv_ruleKeyValueAnnotation= ruleKeyValueAnnotation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getKeyValueAnnotationRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleKeyValueAnnotation_in_entryRuleKeyValueAnnotation8618);
            iv_ruleKeyValueAnnotation=ruleKeyValueAnnotation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleKeyValueAnnotation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKeyValueAnnotation8628); if (failed) return current;

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
    // $ANTLR end entryRuleKeyValueAnnotation


    // $ANTLR start ruleKeyValueAnnotation
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5337:1: ruleKeyValueAnnotation returns [EObject current=null] : ( '@' ( (lv_name_1_0= RULE_ID ) ) ( (lv_value_2_0= ruleEString ) ) ) ;
    public final EObject ruleKeyValueAnnotation() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5342:6: ( ( '@' ( (lv_name_1_0= RULE_ID ) ) ( (lv_value_2_0= ruleEString ) ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5343:1: ( '@' ( (lv_name_1_0= RULE_ID ) ) ( (lv_value_2_0= ruleEString ) ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5343:1: ( '@' ( (lv_name_1_0= RULE_ID ) ) ( (lv_value_2_0= ruleEString ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5343:3: '@' ( (lv_name_1_0= RULE_ID ) ) ( (lv_value_2_0= ruleEString ) )
            {
            match(input,24,FollowSets000.FOLLOW_24_in_ruleKeyValueAnnotation8663); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getKeyValueAnnotationAccess().getCommercialAtKeyword_0(), null); 
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5347:1: ( (lv_name_1_0= RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5348:1: (lv_name_1_0= RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5348:1: (lv_name_1_0= RULE_ID )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5349:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleKeyValueAnnotation8680); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getKeyValueAnnotationAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getKeyValueAnnotationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5371:2: ( (lv_value_2_0= ruleEString ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5372:1: (lv_value_2_0= ruleEString )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5372:1: (lv_value_2_0= ruleEString )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5373:3: lv_value_2_0= ruleEString
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getKeyValueAnnotationAccess().getValueEStringParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleKeyValueAnnotation8706);
            lv_value_2_0=ruleEString();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getKeyValueAnnotationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"value",
              	        		lv_value_2_0, 
              	        		"EString", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

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
    // $ANTLR end ruleKeyValueAnnotation


    // $ANTLR start entryRuleImportAnnotation
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5403:1: entryRuleImportAnnotation returns [EObject current=null] : iv_ruleImportAnnotation= ruleImportAnnotation EOF ;
    public final EObject entryRuleImportAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportAnnotation = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5404:2: (iv_ruleImportAnnotation= ruleImportAnnotation EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5405:2: iv_ruleImportAnnotation= ruleImportAnnotation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getImportAnnotationRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImportAnnotation_in_entryRuleImportAnnotation8742);
            iv_ruleImportAnnotation=ruleImportAnnotation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleImportAnnotation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImportAnnotation8752); if (failed) return current;

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
    // $ANTLR end entryRuleImportAnnotation


    // $ANTLR start ruleImportAnnotation
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5412:1: ruleImportAnnotation returns [EObject current=null] : ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImportAnnotation() throws RecognitionException {
        EObject current = null;

        Token lv_importURI_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5417:6: ( ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5418:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5418:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5418:3: 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            match(input,47,FollowSets000.FOLLOW_47_in_ruleImportAnnotation8787); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getImportAnnotationAccess().getImportKeyword_0(), null); 
                  
            }
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5422:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5423:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5423:1: (lv_importURI_1_0= RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5424:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleImportAnnotation8804); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getImportAnnotationAccess().getImportURISTRINGTerminalRuleCall_1_0(), "importURI"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getImportAnnotationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"importURI",
              	        		lv_importURI_1_0, 
              	        		"STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

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
    // $ANTLR end ruleImportAnnotation


    // $ANTLR start entryRuleEString
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5454:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5455:2: (iv_ruleEString= ruleEString EOF )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5456:2: iv_ruleEString= ruleEString EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getEStringRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString8846);
            iv_ruleEString=ruleEString();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleEString.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString8857); if (failed) return current;

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
    // $ANTLR end entryRuleEString


    // $ANTLR start ruleEString
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5463:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5468:6: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5469:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5469:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_STRING) ) {
                alt87=1;
            }
            else if ( (LA87_0==RULE_ID) ) {
                alt87=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("5469:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5469:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString8897); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_STRING_0);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5477:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString8923); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_ID_1);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1(), null); 
                          
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
    // $ANTLR end ruleEString


    // $ANTLR start ruleStateType
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5492:1: ruleStateType returns [Enumerator current=null] : ( ( 'normal' ) | ( 'conditional' ) | ( 'reference' ) | ( 'textual' ) ) ;
    public final Enumerator ruleStateType() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5496:6: ( ( ( 'normal' ) | ( 'conditional' ) | ( 'reference' ) | ( 'textual' ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5497:1: ( ( 'normal' ) | ( 'conditional' ) | ( 'reference' ) | ( 'textual' ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5497:1: ( ( 'normal' ) | ( 'conditional' ) | ( 'reference' ) | ( 'textual' ) )
            int alt88=4;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt88=1;
                }
                break;
            case 49:
                {
                alt88=2;
                }
                break;
            case 50:
                {
                alt88=3;
                }
                break;
            case 17:
                {
                alt88=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("5497:1: ( ( 'normal' ) | ( 'conditional' ) | ( 'reference' ) | ( 'textual' ) )", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5497:2: ( 'normal' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5497:2: ( 'normal' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5497:4: 'normal'
                    {
                    match(input,48,FollowSets000.FOLLOW_48_in_ruleStateType8980); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getStateTypeAccess().getNORMALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getStateTypeAccess().getNORMALEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5503:6: ( 'conditional' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5503:6: ( 'conditional' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5503:8: 'conditional'
                    {
                    match(input,49,FollowSets000.FOLLOW_49_in_ruleStateType8995); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getStateTypeAccess().getCONDITIONALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getStateTypeAccess().getCONDITIONALEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5509:6: ( 'reference' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5509:6: ( 'reference' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5509:8: 'reference'
                    {
                    match(input,50,FollowSets000.FOLLOW_50_in_ruleStateType9010); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getStateTypeAccess().getREFERENCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getStateTypeAccess().getREFERENCEEnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5515:6: ( 'textual' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5515:6: ( 'textual' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5515:8: 'textual'
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleStateType9025); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getStateTypeAccess().getTEXTUALEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getStateTypeAccess().getTEXTUALEnumLiteralDeclaration_3(), null); 
                          
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
    // $ANTLR end ruleStateType


    // $ANTLR start ruleTransitionType
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5525:1: ruleTransitionType returns [Enumerator current=null] : ( ( '-->' ) | ( 'o->' ) | ( '>->' ) ) ;
    public final Enumerator ruleTransitionType() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5529:6: ( ( ( '-->' ) | ( 'o->' ) | ( '>->' ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5530:1: ( ( '-->' ) | ( 'o->' ) | ( '>->' ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5530:1: ( ( '-->' ) | ( 'o->' ) | ( '>->' ) )
            int alt89=3;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt89=1;
                }
                break;
            case 52:
                {
                alt89=2;
                }
                break;
            case 53:
                {
                alt89=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("5530:1: ( ( '-->' ) | ( 'o->' ) | ( '>->' ) )", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5530:2: ( '-->' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5530:2: ( '-->' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5530:4: '-->'
                    {
                    match(input,51,FollowSets000.FOLLOW_51_in_ruleTransitionType9068); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getTransitionTypeAccess().getWEAKABORTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getTransitionTypeAccess().getWEAKABORTEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5536:6: ( 'o->' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5536:6: ( 'o->' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5536:8: 'o->'
                    {
                    match(input,52,FollowSets000.FOLLOW_52_in_ruleTransitionType9083); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getTransitionTypeAccess().getSTRONGABORTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getTransitionTypeAccess().getSTRONGABORTEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5542:6: ( '>->' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5542:6: ( '>->' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5542:8: '>->'
                    {
                    match(input,53,FollowSets000.FOLLOW_53_in_ruleTransitionType9098); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getTransitionTypeAccess().getNORMALTERMINATIONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getTransitionTypeAccess().getNORMALTERMINATIONEnumLiteralDeclaration_2(), null); 
                          
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
    // $ANTLR end ruleTransitionType


    // $ANTLR start ruleDivOperator
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5552:1: ruleDivOperator returns [Enumerator current=null] : ( ':' ) ;
    public final Enumerator ruleDivOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5556:6: ( ( ':' ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5557:1: ( ':' )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5557:1: ( ':' )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5557:3: ':'
            {
            match(input,16,FollowSets000.FOLLOW_16_in_ruleDivOperator9140); if (failed) return current;
            if ( backtracking==0 ) {

                      current = grammarAccess.getDivOperatorAccess().getDIVEnumLiteralDeclaration().getEnumLiteral().getInstance();
                      createLeafNode(grammarAccess.getDivOperatorAccess().getDIVEnumLiteralDeclaration(), null); 
                  
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
    // $ANTLR end ruleDivOperator


    // $ANTLR start ruleCompareOperator
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5567:1: ruleCompareOperator returns [Enumerator current=null] : ( ( '=' ) | ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '<>' ) ) ;
    public final Enumerator ruleCompareOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5571:6: ( ( ( '=' ) | ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '<>' ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5572:1: ( ( '=' ) | ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '<>' ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5572:1: ( ( '=' ) | ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '<>' ) )
            int alt90=6;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt90=1;
                }
                break;
            case 55:
                {
                alt90=2;
                }
                break;
            case 56:
                {
                alt90=3;
                }
                break;
            case 57:
                {
                alt90=4;
                }
                break;
            case 58:
                {
                alt90=5;
                }
                break;
            case 59:
                {
                alt90=6;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("5572:1: ( ( '=' ) | ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '<>' ) )", 90, 0, input);

                throw nvae;
            }

            switch (alt90) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5572:2: ( '=' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5572:2: ( '=' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5572:4: '='
                    {
                    match(input,54,FollowSets000.FOLLOW_54_in_ruleCompareOperator9182); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getCompareOperatorAccess().getEQEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5578:6: ( '<' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5578:6: ( '<' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5578:8: '<'
                    {
                    match(input,55,FollowSets000.FOLLOW_55_in_ruleCompareOperator9197); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getLTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getCompareOperatorAccess().getLTEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5584:6: ( '<=' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5584:6: ( '<=' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5584:8: '<='
                    {
                    match(input,56,FollowSets000.FOLLOW_56_in_ruleCompareOperator9212); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getLEQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getCompareOperatorAccess().getLEQEnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5590:6: ( '>' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5590:6: ( '>' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5590:8: '>'
                    {
                    match(input,57,FollowSets000.FOLLOW_57_in_ruleCompareOperator9227); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getGTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getCompareOperatorAccess().getGTEnumLiteralDeclaration_3(), null); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5596:6: ( '>=' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5596:6: ( '>=' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5596:8: '>='
                    {
                    match(input,58,FollowSets000.FOLLOW_58_in_ruleCompareOperator9242); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getGEQEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getCompareOperatorAccess().getGEQEnumLiteralDeclaration_4(), null); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5602:6: ( '<>' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5602:6: ( '<>' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5602:8: '<>'
                    {
                    match(input,59,FollowSets000.FOLLOW_59_in_ruleCompareOperator9257); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getNEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getCompareOperatorAccess().getNEEnumLiteralDeclaration_5(), null); 
                          
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
    // $ANTLR end ruleCompareOperator


    // $ANTLR start rulePreOperator
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5612:1: rulePreOperator returns [Enumerator current=null] : ( 'pre' ) ;
    public final Enumerator rulePreOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5616:6: ( ( 'pre' ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5617:1: ( 'pre' )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5617:1: ( 'pre' )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5617:3: 'pre'
            {
            match(input,60,FollowSets000.FOLLOW_60_in_rulePreOperator9299); if (failed) return current;
            if ( backtracking==0 ) {

                      current = grammarAccess.getPreOperatorAccess().getPREEnumLiteralDeclaration().getEnumLiteral().getInstance();
                      createLeafNode(grammarAccess.getPreOperatorAccess().getPREEnumLiteralDeclaration(), null); 
                  
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
    // $ANTLR end rulePreOperator


    // $ANTLR start ruleOrOperator
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5627:1: ruleOrOperator returns [Enumerator current=null] : ( 'or' ) ;
    public final Enumerator ruleOrOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5631:6: ( ( 'or' ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5632:1: ( 'or' )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5632:1: ( 'or' )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5632:3: 'or'
            {
            match(input,61,FollowSets000.FOLLOW_61_in_ruleOrOperator9340); if (failed) return current;
            if ( backtracking==0 ) {

                      current = grammarAccess.getOrOperatorAccess().getOREnumLiteralDeclaration().getEnumLiteral().getInstance();
                      createLeafNode(grammarAccess.getOrOperatorAccess().getOREnumLiteralDeclaration(), null); 
                  
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
    // $ANTLR end ruleOrOperator


    // $ANTLR start ruleAndOperator
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5642:1: ruleAndOperator returns [Enumerator current=null] : ( 'and' ) ;
    public final Enumerator ruleAndOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5646:6: ( ( 'and' ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5647:1: ( 'and' )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5647:1: ( 'and' )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5647:3: 'and'
            {
            match(input,62,FollowSets000.FOLLOW_62_in_ruleAndOperator9381); if (failed) return current;
            if ( backtracking==0 ) {

                      current = grammarAccess.getAndOperatorAccess().getANDEnumLiteralDeclaration().getEnumLiteral().getInstance();
                      createLeafNode(grammarAccess.getAndOperatorAccess().getANDEnumLiteralDeclaration(), null); 
                  
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
    // $ANTLR end ruleAndOperator


    // $ANTLR start ruleNotOperator
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5657:1: ruleNotOperator returns [Enumerator current=null] : ( 'not' ) ;
    public final Enumerator ruleNotOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5661:6: ( ( 'not' ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5662:1: ( 'not' )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5662:1: ( 'not' )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5662:3: 'not'
            {
            match(input,63,FollowSets000.FOLLOW_63_in_ruleNotOperator9422); if (failed) return current;
            if ( backtracking==0 ) {

                      current = grammarAccess.getNotOperatorAccess().getNOTEnumLiteralDeclaration().getEnumLiteral().getInstance();
                      createLeafNode(grammarAccess.getNotOperatorAccess().getNOTEnumLiteralDeclaration(), null); 
                  
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
    // $ANTLR end ruleNotOperator


    // $ANTLR start ruleAddOperator
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5672:1: ruleAddOperator returns [Enumerator current=null] : ( '+' ) ;
    public final Enumerator ruleAddOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5676:6: ( ( '+' ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5677:1: ( '+' )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5677:1: ( '+' )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5677:3: '+'
            {
            match(input,64,FollowSets000.FOLLOW_64_in_ruleAddOperator9463); if (failed) return current;
            if ( backtracking==0 ) {

                      current = grammarAccess.getAddOperatorAccess().getADDEnumLiteralDeclaration().getEnumLiteral().getInstance();
                      createLeafNode(grammarAccess.getAddOperatorAccess().getADDEnumLiteralDeclaration(), null); 
                  
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
    // $ANTLR end ruleAddOperator


    // $ANTLR start ruleSubOperator
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5687:1: ruleSubOperator returns [Enumerator current=null] : ( '-' ) ;
    public final Enumerator ruleSubOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5691:6: ( ( '-' ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5692:1: ( '-' )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5692:1: ( '-' )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5692:3: '-'
            {
            match(input,65,FollowSets000.FOLLOW_65_in_ruleSubOperator9504); if (failed) return current;
            if ( backtracking==0 ) {

                      current = grammarAccess.getSubOperatorAccess().getSUBEnumLiteralDeclaration().getEnumLiteral().getInstance();
                      createLeafNode(grammarAccess.getSubOperatorAccess().getSUBEnumLiteralDeclaration(), null); 
                  
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
    // $ANTLR end ruleSubOperator


    // $ANTLR start ruleMultOperator
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5702:1: ruleMultOperator returns [Enumerator current=null] : ( '*' ) ;
    public final Enumerator ruleMultOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5706:6: ( ( '*' ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5707:1: ( '*' )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5707:1: ( '*' )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5707:3: '*'
            {
            match(input,66,FollowSets000.FOLLOW_66_in_ruleMultOperator9545); if (failed) return current;
            if ( backtracking==0 ) {

                      current = grammarAccess.getMultOperatorAccess().getMULTEnumLiteralDeclaration().getEnumLiteral().getInstance();
                      createLeafNode(grammarAccess.getMultOperatorAccess().getMULTEnumLiteralDeclaration(), null); 
                  
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
    // $ANTLR end ruleMultOperator


    // $ANTLR start ruleModOperator
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5717:1: ruleModOperator returns [Enumerator current=null] : ( 'mod' ) ;
    public final Enumerator ruleModOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5721:6: ( ( 'mod' ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5722:1: ( 'mod' )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5722:1: ( 'mod' )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5722:3: 'mod'
            {
            match(input,67,FollowSets000.FOLLOW_67_in_ruleModOperator9586); if (failed) return current;
            if ( backtracking==0 ) {

                      current = grammarAccess.getModOperatorAccess().getMODEnumLiteralDeclaration().getEnumLiteral().getInstance();
                      createLeafNode(grammarAccess.getModOperatorAccess().getMODEnumLiteralDeclaration(), null); 
                  
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
    // $ANTLR end ruleModOperator


    // $ANTLR start ruleValueTestOperator
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5732:1: ruleValueTestOperator returns [Enumerator current=null] : ( '?' ) ;
    public final Enumerator ruleValueTestOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5736:6: ( ( '?' ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5737:1: ( '?' )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5737:1: ( '?' )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5737:3: '?'
            {
            match(input,68,FollowSets000.FOLLOW_68_in_ruleValueTestOperator9627); if (failed) return current;
            if ( backtracking==0 ) {

                      current = grammarAccess.getValueTestOperatorAccess().getVALEnumLiteralDeclaration().getEnumLiteral().getInstance();
                      createLeafNode(grammarAccess.getValueTestOperatorAccess().getVALEnumLiteralDeclaration(), null); 
                  
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
    // $ANTLR end ruleValueTestOperator


    // $ANTLR start ruleValueType
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5747:1: ruleValueType returns [Enumerator current=null] : ( ( 'pure' ) | ( 'bool' ) | ( 'unsigned' ) | ( 'int' ) | ( 'float' ) | ( 'host' ) ) ;
    public final Enumerator ruleValueType() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5751:6: ( ( ( 'pure' ) | ( 'bool' ) | ( 'unsigned' ) | ( 'int' ) | ( 'float' ) | ( 'host' ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5752:1: ( ( 'pure' ) | ( 'bool' ) | ( 'unsigned' ) | ( 'int' ) | ( 'float' ) | ( 'host' ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5752:1: ( ( 'pure' ) | ( 'bool' ) | ( 'unsigned' ) | ( 'int' ) | ( 'float' ) | ( 'host' ) )
            int alt91=6;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt91=1;
                }
                break;
            case 70:
                {
                alt91=2;
                }
                break;
            case 71:
                {
                alt91=3;
                }
                break;
            case 72:
                {
                alt91=4;
                }
                break;
            case 73:
                {
                alt91=5;
                }
                break;
            case 74:
                {
                alt91=6;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("5752:1: ( ( 'pure' ) | ( 'bool' ) | ( 'unsigned' ) | ( 'int' ) | ( 'float' ) | ( 'host' ) )", 91, 0, input);

                throw nvae;
            }

            switch (alt91) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5752:2: ( 'pure' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5752:2: ( 'pure' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5752:4: 'pure'
                    {
                    match(input,69,FollowSets000.FOLLOW_69_in_ruleValueType9669); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getValueTypeAccess().getPUREEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getValueTypeAccess().getPUREEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5758:6: ( 'bool' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5758:6: ( 'bool' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5758:8: 'bool'
                    {
                    match(input,70,FollowSets000.FOLLOW_70_in_ruleValueType9684); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getValueTypeAccess().getBOOLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getValueTypeAccess().getBOOLEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5764:6: ( 'unsigned' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5764:6: ( 'unsigned' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5764:8: 'unsigned'
                    {
                    match(input,71,FollowSets000.FOLLOW_71_in_ruleValueType9699); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getValueTypeAccess().getUNSIGNEDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getValueTypeAccess().getUNSIGNEDEnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5770:6: ( 'int' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5770:6: ( 'int' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5770:8: 'int'
                    {
                    match(input,72,FollowSets000.FOLLOW_72_in_ruleValueType9714); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getValueTypeAccess().getINTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getValueTypeAccess().getINTEnumLiteralDeclaration_3(), null); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5776:6: ( 'float' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5776:6: ( 'float' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5776:8: 'float'
                    {
                    match(input,73,FollowSets000.FOLLOW_73_in_ruleValueType9729); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getValueTypeAccess().getFLOATEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getValueTypeAccess().getFLOATEnumLiteralDeclaration_4(), null); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5782:6: ( 'host' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5782:6: ( 'host' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5782:8: 'host'
                    {
                    match(input,74,FollowSets000.FOLLOW_74_in_ruleValueType9744); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getValueTypeAccess().getHOSTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getValueTypeAccess().getHOSTEnumLiteralDeclaration_5(), null); 
                          
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
    // $ANTLR end ruleValueType


    // $ANTLR start ruleCombineOperator
    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5792:1: ruleCombineOperator returns [Enumerator current=null] : ( ( 'none' ) | ( '+' ) | ( '*' ) | ( 'max' ) | ( 'min' ) | ( 'or' ) | ( 'and' ) | ( 'host' ) ) ;
    public final Enumerator ruleCombineOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5796:6: ( ( ( 'none' ) | ( '+' ) | ( '*' ) | ( 'max' ) | ( 'min' ) | ( 'or' ) | ( 'and' ) | ( 'host' ) ) )
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5797:1: ( ( 'none' ) | ( '+' ) | ( '*' ) | ( 'max' ) | ( 'min' ) | ( 'or' ) | ( 'and' ) | ( 'host' ) )
            {
            // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5797:1: ( ( 'none' ) | ( '+' ) | ( '*' ) | ( 'max' ) | ( 'min' ) | ( 'or' ) | ( 'and' ) | ( 'host' ) )
            int alt92=8;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt92=1;
                }
                break;
            case 64:
                {
                alt92=2;
                }
                break;
            case 66:
                {
                alt92=3;
                }
                break;
            case 76:
                {
                alt92=4;
                }
                break;
            case 77:
                {
                alt92=5;
                }
                break;
            case 61:
                {
                alt92=6;
                }
                break;
            case 62:
                {
                alt92=7;
                }
                break;
            case 74:
                {
                alt92=8;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("5797:1: ( ( 'none' ) | ( '+' ) | ( '*' ) | ( 'max' ) | ( 'min' ) | ( 'or' ) | ( 'and' ) | ( 'host' ) )", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5797:2: ( 'none' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5797:2: ( 'none' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5797:4: 'none'
                    {
                    match(input,75,FollowSets000.FOLLOW_75_in_ruleCombineOperator9787); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getCombineOperatorAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getCombineOperatorAccess().getNONEEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5803:6: ( '+' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5803:6: ( '+' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5803:8: '+'
                    {
                    match(input,64,FollowSets000.FOLLOW_64_in_ruleCombineOperator9802); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getCombineOperatorAccess().getADDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getCombineOperatorAccess().getADDEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5809:6: ( '*' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5809:6: ( '*' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5809:8: '*'
                    {
                    match(input,66,FollowSets000.FOLLOW_66_in_ruleCombineOperator9817); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getCombineOperatorAccess().getMULTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getCombineOperatorAccess().getMULTEnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5815:6: ( 'max' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5815:6: ( 'max' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5815:8: 'max'
                    {
                    match(input,76,FollowSets000.FOLLOW_76_in_ruleCombineOperator9832); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getCombineOperatorAccess().getMAXEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getCombineOperatorAccess().getMAXEnumLiteralDeclaration_3(), null); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5821:6: ( 'min' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5821:6: ( 'min' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5821:8: 'min'
                    {
                    match(input,77,FollowSets000.FOLLOW_77_in_ruleCombineOperator9847); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getCombineOperatorAccess().getMINEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getCombineOperatorAccess().getMINEnumLiteralDeclaration_4(), null); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5827:6: ( 'or' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5827:6: ( 'or' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5827:8: 'or'
                    {
                    match(input,61,FollowSets000.FOLLOW_61_in_ruleCombineOperator9862); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getCombineOperatorAccess().getOREnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getCombineOperatorAccess().getOREnumLiteralDeclaration_5(), null); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5833:6: ( 'and' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5833:6: ( 'and' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5833:8: 'and'
                    {
                    match(input,62,FollowSets000.FOLLOW_62_in_ruleCombineOperator9877); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getCombineOperatorAccess().getANDEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getCombineOperatorAccess().getANDEnumLiteralDeclaration_6(), null); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5839:6: ( 'host' )
                    {
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5839:6: ( 'host' )
                    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:5839:8: 'host'
                    {
                    match(input,74,FollowSets000.FOLLOW_74_in_ruleCombineOperator9892); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getCombineOperatorAccess().getHOSTEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getCombineOperatorAccess().getHOSTEnumLiteralDeclaration_7(), null); 
                          
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
    // $ANTLR end ruleCombineOperator

    // $ANTLR start synpred7
    public final void synpred7_fragment() throws RecognitionException {   
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:136:3: ( ( ( ruleStringAnnotation ) )* 'region' ( ( RULE_ID ) )? ( ( RULE_STRING ) )? ':' ( ( ( ruleVariable ) ) | ( ( ruleSignal ) ) )* ( ( ruleTextualCode ) )* )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:136:3: ( ( ruleStringAnnotation ) )* 'region' ( ( RULE_ID ) )? ( ( RULE_STRING ) )? ':' ( ( ( ruleVariable ) ) | ( ( ruleSignal ) ) )* ( ( ruleTextualCode ) )*
        {
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:136:3: ( ( ruleStringAnnotation ) )*
        loop93:
        do {
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==RULE_COMMENT_ANNOTATION||LA93_0==24) ) {
                alt93=1;
            }


            switch (alt93) {
        	case 1 :
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:137:1: ( ruleStringAnnotation )
        	    {
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:137:1: ( ruleStringAnnotation )
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:138:3: ruleStringAnnotation
        	    {
        	    if ( backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getSingleRegionAccess().getAnnotationsStringAnnotationParserRuleCall_0_0_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleStringAnnotation_in_synpred7233);
        	    ruleStringAnnotation();
        	    _fsp--;
        	    if (failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop93;
            }
        } while (true);

        match(input,15,FollowSets000.FOLLOW_15_in_synpred7244); if (failed) return ;
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:164:1: ( ( RULE_ID ) )?
        int alt94=2;
        int LA94_0 = input.LA(1);

        if ( (LA94_0==RULE_ID) ) {
            alt94=1;
        }
        switch (alt94) {
            case 1 :
                // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:165:1: ( RULE_ID )
                {
                // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:165:1: ( RULE_ID )
                // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:166:3: RULE_ID
                {
                match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred7261); if (failed) return ;

                }


                }
                break;

        }

        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:188:3: ( ( RULE_STRING ) )?
        int alt95=2;
        int LA95_0 = input.LA(1);

        if ( (LA95_0==RULE_STRING) ) {
            alt95=1;
        }
        switch (alt95) {
            case 1 :
                // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:189:1: ( RULE_STRING )
                {
                // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:189:1: ( RULE_STRING )
                // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:190:3: RULE_STRING
                {
                match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred7284); if (failed) return ;

                }


                }
                break;

        }

        match(input,16,FollowSets000.FOLLOW_16_in_synpred7300); if (failed) return ;
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:216:1: ( ( ( ruleVariable ) ) | ( ( ruleSignal ) ) )*
        loop96:
        do {
            int alt96=3;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==43) ) {
                alt96=1;
            }
            else if ( ((LA96_0>=38 && LA96_0<=40)) ) {
                alt96=2;
            }


            switch (alt96) {
        	case 1 :
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:216:2: ( ( ruleVariable ) )
        	    {
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:216:2: ( ( ruleVariable ) )
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:217:1: ( ruleVariable )
        	    {
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:217:1: ( ruleVariable )
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:218:3: ruleVariable
        	    {
        	    if ( backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getSingleRegionAccess().getVariablesVariableParserRuleCall_0_5_0_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleVariable_in_synpred7322);
        	    ruleVariable();
        	    _fsp--;
        	    if (failed) return ;

        	    }


        	    }


        	    }
        	    break;
        	case 2 :
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:241:6: ( ( ruleSignal ) )
        	    {
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:241:6: ( ( ruleSignal ) )
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:242:1: ( ruleSignal )
        	    {
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:242:1: ( ruleSignal )
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:243:3: ruleSignal
        	    {
        	    if ( backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getSingleRegionAccess().getSignalsSignalParserRuleCall_0_5_1_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleSignal_in_synpred7349);
        	    ruleSignal();
        	    _fsp--;
        	    if (failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop96;
            }
        } while (true);

        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:265:4: ( ( ruleTextualCode ) )*
        loop97:
        do {
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==17) ) {
                alt97=1;
            }


            switch (alt97) {
        	case 1 :
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:266:1: ( ruleTextualCode )
        	    {
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:266:1: ( ruleTextualCode )
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:267:3: ruleTextualCode
        	    {
        	    if ( backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getSingleRegionAccess().getBodyTextTextualCodeParserRuleCall_0_6_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleTextualCode_in_synpred7372);
        	    ruleTextualCode();
        	    _fsp--;
        	    if (failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop97;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred7

    // $ANTLR start synpred35
    public final void synpred35_fragment() throws RecognitionException {   
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1087:4: ( ( ( ruleSingleRegion ) ) ( ( ruleRegion ) )* )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1087:4: ( ( ruleSingleRegion ) ) ( ( ruleRegion ) )*
        {
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1087:4: ( ( ruleSingleRegion ) )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1088:1: ( ruleSingleRegion )
        {
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1088:1: ( ruleSingleRegion )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1089:3: ruleSingleRegion
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getRegionsSingleRegionParserRuleCall_6_1_1_2_0_0(), currentNode); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleSingleRegion_in_synpred351510);
        ruleSingleRegion();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1111:2: ( ( ruleRegion ) )*
        loop103:
        do {
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==RULE_COMMENT_ANNOTATION||LA103_0==15||LA103_0==24) ) {
                alt103=1;
            }


            switch (alt103) {
        	case 1 :
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1112:1: ( ruleRegion )
        	    {
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1112:1: ( ruleRegion )
        	    // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1113:3: ruleRegion
        	    {
        	    if ( backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getRegionsRegionParserRuleCall_6_1_1_2_1_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleRegion_in_synpred351531);
        	    ruleRegion();
        	    _fsp--;
        	    if (failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop103;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred35

    // $ANTLR start synpred41
    public final void synpred41_fragment() throws RecognitionException {   
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1301:1: ( ( RULE_INT ) )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1301:1: ( RULE_INT )
        {
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1301:1: ( RULE_INT )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:1302:3: RULE_INT
        {
        match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_synpred411791); if (failed) return ;

        }


        }
    }
    // $ANTLR end synpred41

    // $ANTLR start synpred59
    public final void synpred59_fragment() throws RecognitionException {   
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2001:1: ( ( RULE_INT ) )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2001:1: ( RULE_INT )
        {
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2001:1: ( RULE_INT )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2002:3: RULE_INT
        {
        match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_synpred592813); if (failed) return ;

        }


        }
    }
    // $ANTLR end synpred59

    // $ANTLR start synpred67
    public final void synpred67_fragment() throws RecognitionException {   
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2410:2: ( ruleBooleanExpression )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2410:2: ruleBooleanExpression
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleBooleanExpression_in_synpred673561);
        ruleBooleanExpression();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred67

    // $ANTLR start synpred70
    public final void synpred70_fragment() throws RecognitionException {   
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2696:2: ( ( ruleNotOrValuedExpression ( () ( ( ruleCompareOperator ) ) ( ( ruleNotOrValuedExpression ) ) ) ) )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2696:2: ( ruleNotOrValuedExpression ( () ( ( ruleCompareOperator ) ) ( ( ruleNotOrValuedExpression ) ) ) )
        {
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2696:2: ( ruleNotOrValuedExpression ( () ( ( ruleCompareOperator ) ) ( ( ruleNotOrValuedExpression ) ) ) )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2697:2: ruleNotOrValuedExpression ( () ( ( ruleCompareOperator ) ) ( ( ruleNotOrValuedExpression ) ) )
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleNotOrValuedExpression_in_synpred704084);
        ruleNotOrValuedExpression();
        _fsp--;
        if (failed) return ;
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2708:1: ( () ( ( ruleCompareOperator ) ) ( ( ruleNotOrValuedExpression ) ) )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2708:2: () ( ( ruleCompareOperator ) ) ( ( ruleNotOrValuedExpression ) )
        {
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2708:2: ()
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2709:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2727:2: ( ( ruleCompareOperator ) )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2728:1: ( ruleCompareOperator )
        {
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2728:1: ( ruleCompareOperator )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2729:3: ruleCompareOperator
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getCompareOperationAccess().getOperatorCompareOperatorEnumRuleCall_0_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleCompareOperator_in_synpred704117);
        ruleCompareOperator();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2751:2: ( ( ruleNotOrValuedExpression ) )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2752:1: ( ruleNotOrValuedExpression )
        {
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2752:1: ( ruleNotOrValuedExpression )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2753:3: ruleNotOrValuedExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getCompareOperationAccess().getSubExpressionsNotOrValuedExpressionParserRuleCall_0_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleNotOrValuedExpression_in_synpred704138);
        ruleNotOrValuedExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred70

    // $ANTLR start synpred71
    public final void synpred71_fragment() throws RecognitionException {   
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2812:2: ( ruleValuedExpression )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:2812:2: ruleValuedExpression
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleValuedExpression_in_synpred714266);
        ruleValuedExpression();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred71

    // $ANTLR start synpred76
    public final void synpred76_fragment() throws RecognitionException {   
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3310:2: ( () ( ( ruleDivOperator ) ) ( ( ruleModExpression ) ) )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3310:2: () ( ( ruleDivOperator ) ) ( ( ruleModExpression ) )
        {
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3310:2: ()
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3311:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3329:2: ( ( ruleDivOperator ) )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3330:1: ( ruleDivOperator )
        {
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3330:1: ( ruleDivOperator )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3331:3: ruleDivOperator
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getDivExpressionAccess().getOperatorDivOperatorEnumRuleCall_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleDivOperator_in_synpred765130);
        ruleDivOperator();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3353:2: ( ( ruleModExpression ) )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3354:1: ( ruleModExpression )
        {
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3354:1: ( ruleModExpression )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3355:3: ruleModExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getDivExpressionAccess().getSubExpressionsModExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleModExpression_in_synpred765151);
        ruleModExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred76

    // $ANTLR start synpred84
    public final void synpred84_fragment() throws RecognitionException {   
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3708:6: ( ( '(' ruleValuedExpression ')' ) )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3708:6: ( '(' ruleValuedExpression ')' )
        {
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3708:6: ( '(' ruleValuedExpression ')' )
        // ../de.cau.cs.kieler.synccharts.text/src-gen/de/cau/cs/kieler/synccharts/text/kitsState/parser/antlr/internal/InternalKitsState.g:3708:8: '(' ruleValuedExpression ')'
        {
        match(input,19,FollowSets000.FOLLOW_19_in_synpred845811); if (failed) return ;
        pushFollow(FollowSets000.FOLLOW_ruleValuedExpression_in_synpred845836);
        ruleValuedExpression();
        _fsp--;
        if (failed) return ;
        match(input,20,FollowSets000.FOLLOW_20_in_synpred845845); if (failed) return ;

        }


        }
    }
    // $ANTLR end synpred84

    public final boolean synpred35() {
        backtracking++;
        int start = input.mark();
        try {
            synpred35_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred7() {
        backtracking++;
        int start = input.mark();
        try {
            synpred7_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred41() {
        backtracking++;
        int start = input.mark();
        try {
            synpred41_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred67() {
        backtracking++;
        int start = input.mark();
        try {
            synpred67_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred76() {
        backtracking++;
        int start = input.mark();
        try {
            synpred76_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred70() {
        backtracking++;
        int start = input.mark();
        try {
            synpred70_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred59() {
        backtracking++;
        int start = input.mark();
        try {
            synpred59_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred84() {
        backtracking++;
        int start = input.mark();
        try {
            synpred84_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred71() {
        backtracking++;
        int start = input.mark();
        try {
            synpred71_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA6_eotS =
        "\126\uffff";
    static final String DFA6_eofS =
        "\1\4\7\uffff\1\30\21\uffff\1\30\23\uffff\14\30\1\uffff\7\30\1\uffff"+
        "\1\30\11\uffff\11\30";
    static final String DFA6_minS =
        "\2\12\2\4\1\uffff\1\4\1\5\1\20\3\12\1\4\1\47\1\50\1\4\1\22\1\12"+
        "\1\4\2\21\3\27\1\4\1\uffff\1\20\1\12\1\20\1\27\1\4\2\21\1\0\1\4"+
        "\1\5\1\4\1\5\1\4\1\5\2\12\5\20\14\12\1\5\7\12\1\24\1\12\7\42\1\20"+
        "\1\5\11\12";
    static final String DFA6_maxS =
        "\2\62\1\4\1\20\1\uffff\1\5\2\20\3\62\1\4\2\50\1\4\1\27\1\62\1\4"+
        "\2\62\3\27\1\4\1\uffff\1\51\1\62\1\23\1\27\1\5\2\62\1\0\1\11\1\112"+
        "\1\11\1\112\1\4\1\5\2\62\5\20\14\62\1\112\7\62\1\24\1\62\7\42\1"+
        "\20\1\115\11\62";
    static final String DFA6_acceptS =
        "\4\uffff\1\2\23\uffff\1\1\75\uffff";
    static final String DFA6_specialS =
        "\40\uffff\1\0\65\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1\4\uffff\1\3\1\uffff\1\4\3\uffff\3\4\1\2\10\uffff\1\4\16"+
            "\uffff\3\4",
            "\1\1\4\uffff\1\3\1\uffff\1\4\3\uffff\3\4\1\2\27\uffff\3\4",
            "\1\5",
            "\1\6\1\7\12\uffff\1\10",
            "",
            "\1\12\1\11",
            "\1\7\12\uffff\1\10",
            "\1\10",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\1\4\uffff\1\3\1\uffff\1\4\3\uffff\3\4\1\2\27\uffff\3\4",
            "\1\1\4\uffff\1\3\1\uffff\1\4\3\uffff\3\4\1\2\27\uffff\3\4",
            "\1\31",
            "\1\15\1\16",
            "\1\16",
            "\1\32",
            "\1\33\4\uffff\1\27",
            "\1\20\4\uffff\1\30\1\uffff\1\34\3\uffff\1\22\1\23\1\27\1\21"+
            "\27\uffff\1\24\1\25\1\26",
            "\1\35",
            "\1\34\4\uffff\1\36\1\27\30\uffff\1\24\1\25\1\26",
            "\1\34\3\uffff\1\37\1\uffff\1\27\30\uffff\1\24\1\25\1\26",
            "\1\27",
            "\1\27",
            "\1\27",
            "\1\40",
            "",
            "\1\42\30\uffff\1\41",
            "\1\20\4\uffff\1\30\1\44\1\17\3\uffff\1\22\1\23\1\27\1\21\10"+
            "\uffff\1\30\4\uffff\1\14\1\15\1\16\1\43\1\uffff\1\13\4\uffff"+
            "\1\24\1\25\1\26",
            "\1\46\2\uffff\1\45",
            "\1\27",
            "\1\50\1\47",
            "\1\34\5\uffff\1\27\30\uffff\1\24\1\25\1\26",
            "\1\34\5\uffff\1\27\30\uffff\1\24\1\25\1\26",
            "\1\uffff",
            "\1\54\1\55\1\52\1\uffff\1\53\1\51",
            "\1\64\77\uffff\1\56\1\57\1\60\1\61\1\62\1\63",
            "\1\70\1\71\1\66\1\uffff\1\67\1\65",
            "\1\101\44\uffff\1\72\32\uffff\1\73\1\74\1\75\1\76\1\77\1\100",
            "\1\102",
            "\1\103",
            "\1\20\4\uffff\1\30\1\uffff\1\34\3\uffff\1\22\1\23\1\27\1\21"+
            "\27\uffff\1\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\34\3\uffff\1\22\1\23\1\27\1\21"+
            "\27\uffff\1\24\1\25\1\26",
            "\1\42",
            "\1\42",
            "\1\42",
            "\1\42",
            "\1\42",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\44\1\17\3\uffff\1\22\1\23\1\27\1\21\10"+
            "\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1\24"+
            "\1\25\1\26",
            "\1\20\4\uffff\1\30\1\44\1\17\3\uffff\1\22\1\23\1\27\1\21\10"+
            "\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1\24"+
            "\1\25\1\26",
            "\1\20\4\uffff\1\30\1\44\1\17\3\uffff\1\22\1\23\1\27\1\21\10"+
            "\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1\24"+
            "\1\25\1\26",
            "\1\20\4\uffff\1\30\1\44\1\17\3\uffff\1\22\1\23\1\27\1\21\10"+
            "\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1\24"+
            "\1\25\1\26",
            "\1\20\4\uffff\1\30\1\44\1\17\3\uffff\1\22\1\23\1\27\1\21\10"+
            "\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1\24"+
            "\1\25\1\26",
            "\1\112\77\uffff\1\104\1\105\1\106\1\107\1\110\1\111",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\113",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\16\uffff\1\24\1\25\1\26",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\114",
            "\1\46",
            "\1\125\67\uffff\1\122\1\123\1\uffff\1\116\1\uffff\1\117\7\uffff"+
            "\1\124\1\115\1\120\1\121",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26",
            "\1\20\4\uffff\1\30\1\uffff\1\17\3\uffff\1\22\1\23\1\27\1\21"+
            "\10\uffff\1\30\4\uffff\1\14\1\15\1\16\2\uffff\1\13\4\uffff\1"+
            "\24\1\25\1\26"
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "136:2: ( ( (lv_annotations_0_0= ruleStringAnnotation ) )* 'region' ( (lv_id_2_0= RULE_ID ) )? ( (lv_label_3_0= RULE_STRING ) )? ':' ( ( (lv_variables_5_0= ruleVariable ) ) | ( (lv_signals_6_0= ruleSignal ) ) )* ( (lv_bodyText_7_0= ruleTextualCode ) )* )?";
        }
        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_32 = input.LA(1);

                         
                        int index6_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7()) ) {s = 24;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index6_32);
                        if ( s>=0 ) return s;
                        break;
            }
            if (backtracking>0) {failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA7_eotS =
        "\10\uffff";
    static final String DFA7_eofS =
        "\1\1\7\uffff";
    static final String DFA7_minS =
        "\1\12\1\uffff\1\12\1\4\1\uffff\1\4\2\12";
    static final String DFA7_maxS =
        "\1\62\1\uffff\1\62\1\4\1\uffff\1\5\2\62";
    static final String DFA7_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\3\uffff";
    static final String DFA7_specialS =
        "\10\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\2\4\uffff\1\1\1\uffff\1\4\3\uffff\3\4\1\3\10\uffff\1\1\16"+
            "\uffff\3\4",
            "",
            "\1\2\4\uffff\1\1\1\uffff\1\4\3\uffff\3\4\1\3\27\uffff\3\4",
            "\1\5",
            "",
            "\1\7\1\6",
            "\1\2\4\uffff\1\1\1\uffff\1\4\3\uffff\3\4\1\3\27\uffff\3\4",
            "\1\2\4\uffff\1\1\1\uffff\1\4\3\uffff\3\4\1\3\27\uffff\3\4"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "()* loopback of 289:5: ( (lv_states_8_0= ruleState ) )*";
        }
    }
    static final String DFA14_eotS =
        "\10\uffff";
    static final String DFA14_eofS =
        "\1\1\7\uffff";
    static final String DFA14_minS =
        "\1\12\1\uffff\1\12\1\4\1\uffff\1\4\2\12";
    static final String DFA14_maxS =
        "\1\62\1\uffff\1\62\1\4\1\uffff\1\5\2\62";
    static final String DFA14_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\3\uffff";
    static final String DFA14_specialS =
        "\10\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\2\4\uffff\1\1\1\uffff\1\4\3\uffff\3\4\1\3\10\uffff\1\1\16"+
            "\uffff\3\4",
            "",
            "\1\2\4\uffff\1\1\1\uffff\1\4\3\uffff\3\4\1\3\27\uffff\3\4",
            "\1\5",
            "",
            "\1\7\1\6",
            "\1\2\4\uffff\1\1\1\uffff\1\4\3\uffff\3\4\1\3\27\uffff\3\4",
            "\1\2\4\uffff\1\1\1\uffff\1\4\3\uffff\3\4\1\3\27\uffff\3\4"
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "()+ loopback of 580:3: ( (lv_states_8_0= ruleState ) )+";
        }
    }
    static final String DFA28_eotS =
        "\10\uffff";
    static final String DFA28_eofS =
        "\1\1\7\uffff";
    static final String DFA28_minS =
        "\1\12\1\uffff\1\12\1\4\1\uffff\1\4\2\12";
    static final String DFA28_maxS =
        "\1\65\1\uffff\1\65\1\4\1\uffff\1\5\2\65";
    static final String DFA28_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\3\uffff";
    static final String DFA28_specialS =
        "\10\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\2\4\uffff\1\1\1\uffff\1\1\3\uffff\3\1\1\3\10\uffff\1\1\16"+
            "\uffff\3\1\3\4",
            "",
            "\1\2\4\uffff\1\1\1\uffff\1\1\3\uffff\3\1\1\3\27\uffff\3\1\3"+
            "\4",
            "\1\5",
            "",
            "\1\7\1\6",
            "\1\2\4\uffff\1\1\1\uffff\1\1\3\uffff\3\1\1\3\27\uffff\3\1\3"+
            "\4",
            "\1\2\4\uffff\1\1\1\uffff\1\1\3\uffff\3\1\1\3\27\uffff\3\1\3"+
            "\4"
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "()* loopback of 1139:4: ( (lv_outgoingTransitions_31_0= ruleTransition ) )*";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRootState_in_entryRuleRootState81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRootState91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleState_in_ruleRootState140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleRegion_in_entryRuleSingleRegion176 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleRegion186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringAnnotation_in_ruleSingleRegion233 = new BitSet(new long[]{0x0000000001008400L});
        public static final BitSet FOLLOW_15_in_ruleSingleRegion244 = new BitSet(new long[]{0x0000000000010030L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleRegion261 = new BitSet(new long[]{0x0000000000010020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleRegion284 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleSingleRegion300 = new BitSet(new long[]{0x000709C001E20402L});
        public static final BitSet FOLLOW_ruleVariable_in_ruleSingleRegion322 = new BitSet(new long[]{0x000709C001E20402L});
        public static final BitSet FOLLOW_ruleSignal_in_ruleSingleRegion349 = new BitSet(new long[]{0x000709C001E20402L});
        public static final BitSet FOLLOW_ruleTextualCode_in_ruleSingleRegion372 = new BitSet(new long[]{0x0007000001E20402L});
        public static final BitSet FOLLOW_ruleState_in_ruleSingleRegion396 = new BitSet(new long[]{0x0007000001E20402L});
        public static final BitSet FOLLOW_ruleTextualCode_in_entryRuleTextualCode433 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTextualCode443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleTextualCode478 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleTextualCode488 = new BitSet(new long[]{0x0000000000090000L});
        public static final BitSet FOLLOW_19_in_ruleTextualCode499 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTextualCode516 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleTextualCode531 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleTextualCode543 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTextualCode560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRegion_in_entryRuleRegion601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRegion611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringAnnotation_in_ruleRegion657 = new BitSet(new long[]{0x0000000001008400L});
        public static final BitSet FOLLOW_15_in_ruleRegion668 = new BitSet(new long[]{0x0000000000010030L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRegion685 = new BitSet(new long[]{0x0000000000010020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleRegion708 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleRegion724 = new BitSet(new long[]{0x000709C001E20400L});
        public static final BitSet FOLLOW_ruleVariable_in_ruleRegion746 = new BitSet(new long[]{0x000709C001E20400L});
        public static final BitSet FOLLOW_ruleSignal_in_ruleRegion773 = new BitSet(new long[]{0x000709C001E20400L});
        public static final BitSet FOLLOW_ruleTextualCode_in_ruleRegion796 = new BitSet(new long[]{0x0007000001E20400L});
        public static final BitSet FOLLOW_ruleState_in_ruleRegion818 = new BitSet(new long[]{0x0007000001E20402L});
        public static final BitSet FOLLOW_ruleState_in_entryRuleState855 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleState865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringAnnotation_in_ruleState911 = new BitSet(new long[]{0x0007000001E20400L});
        public static final BitSet FOLLOW_21_in_ruleState932 = new BitSet(new long[]{0x0007000000C20000L});
        public static final BitSet FOLLOW_22_in_ruleState963 = new BitSet(new long[]{0x0007000000820000L});
        public static final BitSet FOLLOW_22_in_ruleState1003 = new BitSet(new long[]{0x0007000000A20000L});
        public static final BitSet FOLLOW_21_in_ruleState1034 = new BitSet(new long[]{0x0007000000820000L});
        public static final BitSet FOLLOW_ruleStateType_in_ruleState1072 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleState1083 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleState1100 = new BitSet(new long[]{0x0038000011000422L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleState1122 = new BitSet(new long[]{0x0038000011000402L});
        public static final BitSet FOLLOW_24_in_ruleState1140 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleState1162 = new BitSet(new long[]{0x0038000003000402L});
        public static final BitSet FOLLOW_25_in_ruleState1173 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleSubstitution_in_ruleState1194 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_26_in_ruleState1205 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleSubstitution_in_ruleState1226 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_27_in_ruleState1238 = new BitSet(new long[]{0x0038000001000402L});
        public static final BitSet FOLLOW_28_in_ruleState1258 = new BitSet(new long[]{0x000709C3E1E28400L});
        public static final BitSet FOLLOW_ruleSignal_in_ruleState1281 = new BitSet(new long[]{0x000709C3E1E28400L});
        public static final BitSet FOLLOW_ruleVariable_in_ruleState1308 = new BitSet(new long[]{0x000709C3E1E28400L});
        public static final BitSet FOLLOW_29_in_ruleState1325 = new BitSet(new long[]{0x900709DBE1EA87D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAction_in_ruleState1346 = new BitSet(new long[]{0x000709C3E1E28400L});
        public static final BitSet FOLLOW_30_in_ruleState1364 = new BitSet(new long[]{0x900709DBE1EA87D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAction_in_ruleState1385 = new BitSet(new long[]{0x000709C3E1E28400L});
        public static final BitSet FOLLOW_31_in_ruleState1403 = new BitSet(new long[]{0x900709DBE1EA87D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAction_in_ruleState1424 = new BitSet(new long[]{0x000709C3E1E28400L});
        public static final BitSet FOLLOW_32_in_ruleState1442 = new BitSet(new long[]{0x900709DBE1EA87D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAction_in_ruleState1463 = new BitSet(new long[]{0x000709C3E1E28400L});
        public static final BitSet FOLLOW_ruleTextualCode_in_ruleState1487 = new BitSet(new long[]{0x0007000201E28400L});
        public static final BitSet FOLLOW_ruleSingleRegion_in_ruleState1510 = new BitSet(new long[]{0x0000000201008400L});
        public static final BitSet FOLLOW_ruleRegion_in_ruleState1531 = new BitSet(new long[]{0x0000000201008400L});
        public static final BitSet FOLLOW_33_in_ruleState1545 = new BitSet(new long[]{0x0038000001000402L});
        public static final BitSet FOLLOW_ruleTransition_in_ruleState1569 = new BitSet(new long[]{0x0038000001000402L});
        public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition1606 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransition1616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringAnnotation_in_ruleTransition1662 = new BitSet(new long[]{0x0038000001000400L});
        public static final BitSet FOLLOW_ruleTransitionType_in_ruleTransition1684 = new BitSet(new long[]{0x0000000000000050L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTransition1701 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransition1729 = new BitSet(new long[]{0x0000002400000002L});
        public static final BitSet FOLLOW_34_in_ruleTransition1740 = new BitSet(new long[]{0x90000038000803F2L,0x0000000000000012L});
        public static final BitSet FOLLOW_35_in_ruleTransition1760 = new BitSet(new long[]{0x90000030000803D2L,0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTransition1791 = new BitSet(new long[]{0x90000030000803D2L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleBooleanExpression_in_ruleTransition1818 = new BitSet(new long[]{0x0000003000000002L});
        public static final BitSet FOLLOW_36_in_ruleTransition1830 = new BitSet(new long[]{0x0000000000000090L});
        public static final BitSet FOLLOW_ruleEffect_in_ruleTransition1851 = new BitSet(new long[]{0x0000002004000002L});
        public static final BitSet FOLLOW_26_in_ruleTransition1862 = new BitSet(new long[]{0x0000000000000090L});
        public static final BitSet FOLLOW_ruleEffect_in_ruleTransition1883 = new BitSet(new long[]{0x0000002004000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTransition1911 = new BitSet(new long[]{0x0000002000000002L});
        public static final BitSet FOLLOW_37_in_ruleTransition1937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignal_in_entryRuleSignal1987 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSignal1997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleSignal2040 = new BitSet(new long[]{0x0000018000000000L});
        public static final BitSet FOLLOW_39_in_ruleSignal2072 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleSignal2096 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSignal2113 = new BitSet(new long[]{0x0000020000010002L});
        public static final BitSet FOLLOW_41_in_ruleSignal2129 = new BitSet(new long[]{0x0000000000000370L});
        public static final BitSet FOLLOW_ruleAnyType_in_ruleSignal2150 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleSignal2164 = new BitSet(new long[]{0x0000000000000020L,0x00000000000007E0L});
        public static final BitSet FOLLOW_ruleValueType_in_ruleSignal2186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSignal2209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleSignal2233 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_42_in_ruleSignal2243 = new BitSet(new long[]{0x0000000000000020L,0x00000000000007E0L});
        public static final BitSet FOLLOW_ruleValueType_in_ruleSignal2265 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSignal2288 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleSignal2304 = new BitSet(new long[]{0x6000000000000020L,0x0000000000003C05L});
        public static final BitSet FOLLOW_ruleCombineOperator_in_ruleSignal2326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSignal2349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable2394 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariable2404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleVariable2439 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariable2456 = new BitSet(new long[]{0x0000020000010000L});
        public static final BitSet FOLLOW_41_in_ruleVariable2472 = new BitSet(new long[]{0x0000000000000370L});
        public static final BitSet FOLLOW_ruleAnyType_in_ruleVariable2493 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleVariable2505 = new BitSet(new long[]{0x0000000000000020L,0x00000000000007E0L});
        public static final BitSet FOLLOW_ruleValueType_in_ruleVariable2527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleVariable2550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubstitution_in_entryRuleSubstitution2592 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubstitution2602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubstitution2644 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleSubstitution2659 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubstitution2676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAction_in_entryRuleAction2717 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAction2727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleAction2782 = new BitSet(new long[]{0x90000010000803D2L,0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleAction2813 = new BitSet(new long[]{0x90000010000803D2L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleBooleanExpression_in_ruleAction2840 = new BitSet(new long[]{0x0000001000000002L});
        public static final BitSet FOLLOW_36_in_ruleAction2852 = new BitSet(new long[]{0x0000000000000090L});
        public static final BitSet FOLLOW_ruleEffect_in_ruleAction2873 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleAction2884 = new BitSet(new long[]{0x0000000000000090L});
        public static final BitSet FOLLOW_ruleEffect_in_ruleAction2905 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_ruleEffect_in_entryRuleEffect2945 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEffect2955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEmission_in_ruleEffect3005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_ruleEffect3035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextEffect_in_ruleEffect3065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEmission_in_entryRuleEmission3100 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEmission3110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEmission3157 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleEmission3168 = new BitSet(new long[]{0x90000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleEmission3189 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleEmission3199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment3237 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignment3247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment3294 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_41_in_ruleAssignment3304 = new BitSet(new long[]{0x90000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleAssignment3325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextEffect_in_entryRuleTextEffect3361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTextEffect3371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_HOSTCODE_in_ruleTextEffect3413 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleTextEffect3429 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTextEffect3446 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleTextEffect3461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression3501 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression3511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanExpression_in_ruleExpression3561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValuedExpression_in_ruleExpression3591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression3626 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanExpression3636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOrExpression_in_ruleBooleanExpression3685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOrExpression_in_entryRuleOrExpression3719 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOrExpression3729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAndExpression_in_ruleOrExpression3779 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_ruleOrOperator_in_ruleOrExpression3812 = new BitSet(new long[]{0x90000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAndExpression_in_ruleOrExpression3833 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression3871 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression3881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompareOperation_in_ruleAndExpression3931 = new BitSet(new long[]{0x4000000000000002L});
        public static final BitSet FOLLOW_ruleAndOperator_in_ruleAndExpression3964 = new BitSet(new long[]{0x90000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleCompareOperation_in_ruleAndExpression3985 = new BitSet(new long[]{0x4000000000000002L});
        public static final BitSet FOLLOW_ruleCompareOperation_in_entryRuleCompareOperation4023 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompareOperation4033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotOrValuedExpression_in_ruleCompareOperation4084 = new BitSet(new long[]{0x0FC0000000000000L});
        public static final BitSet FOLLOW_ruleCompareOperator_in_ruleCompareOperation4117 = new BitSet(new long[]{0x90000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleNotOrValuedExpression_in_ruleCompareOperation4138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotExpression_in_ruleCompareOperation4171 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotOrValuedExpression_in_entryRuleNotOrValuedExpression4206 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNotOrValuedExpression4216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValuedExpression_in_ruleNotOrValuedExpression4266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotExpression_in_ruleNotOrValuedExpression4296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotExpression_in_entryRuleNotExpression4331 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNotExpression4341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotOperator_in_ruleNotExpression4400 = new BitSet(new long[]{0x9000000000080290L,0x0000000000000010L});
        public static final BitSet FOLLOW_ruleNotExpression_in_ruleNotExpression4421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtomicExpression_in_ruleNotExpression4453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValuedExpression_in_entryRuleValuedExpression4488 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValuedExpression4498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddExpression_in_ruleValuedExpression4547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddExpression_in_entryRuleAddExpression4581 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddExpression4591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubExpression_in_ruleAddExpression4641 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleAddOperator_in_ruleAddExpression4674 = new BitSet(new long[]{0x10000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleSubExpression_in_ruleAddExpression4695 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleSubExpression_in_entryRuleSubExpression4733 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubExpression4743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultExpression_in_ruleSubExpression4793 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubOperator_in_ruleSubExpression4826 = new BitSet(new long[]{0x10000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleMultExpression_in_ruleSubExpression4847 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultExpression_in_entryRuleMultExpression4885 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultExpression4895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDivExpression_in_ruleMultExpression4945 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleMultOperator_in_ruleMultExpression4978 = new BitSet(new long[]{0x10000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleDivExpression_in_ruleMultExpression4999 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleDivExpression_in_entryRuleDivExpression5037 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDivExpression5047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModExpression_in_ruleDivExpression5097 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_ruleDivOperator_in_ruleDivExpression5130 = new BitSet(new long[]{0x10000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleModExpression_in_ruleDivExpression5151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModExpression_in_entryRuleModExpression5189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModExpression5199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegExpression_in_ruleModExpression5249 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
        public static final BitSet FOLLOW_ruleModOperator_in_ruleModExpression5282 = new BitSet(new long[]{0x10000000000803D0L,0x0000000000000010L});
        public static final BitSet FOLLOW_ruleAtomicValuedExpression_in_ruleModExpression5303 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegExpression_in_entryRuleNegExpression5341 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNegExpression5351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubOperator_in_ruleNegExpression5410 = new BitSet(new long[]{0x10000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleNegExpression_in_ruleNegExpression5431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtomicValuedExpression_in_ruleNegExpression5463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtomicExpression_in_entryRuleAtomicExpression5498 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAtomicExpression5508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanValue_in_ruleAtomicExpression5558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValuedObjectTestExpression_in_ruleAtomicExpression5588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleAtomicExpression5604 = new BitSet(new long[]{0x90000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleBooleanExpression_in_ruleAtomicExpression5629 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleAtomicExpression5638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextExpression_in_ruleAtomicExpression5670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtomicValuedExpression_in_entryRuleAtomicValuedExpression5705 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAtomicValuedExpression5715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntValue_in_ruleAtomicValuedExpression5765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFloatValue_in_ruleAtomicValuedExpression5795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleAtomicValuedExpression5811 = new BitSet(new long[]{0x10000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleValuedExpression_in_ruleAtomicValuedExpression5836 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleAtomicValuedExpression5845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtomicExpression_in_ruleAtomicValuedExpression5877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValuedObjectTestExpression_in_entryRuleValuedObjectTestExpression5912 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValuedObjectTestExpression5922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePreOperator_in_ruleValuedObjectTestExpression5981 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleValuedObjectTestExpression5991 = new BitSet(new long[]{0x1000000000000010L,0x0000000000000010L});
        public static final BitSet FOLLOW_ruleValuedObjectTestExpression_in_ruleValuedObjectTestExpression6012 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleValuedObjectTestExpression6022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueTestOperator_in_ruleValuedObjectTestExpression6063 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleValuedObjectReference_in_ruleValuedObjectTestExpression6084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValuedObjectReference_in_ruleValuedObjectTestExpression6116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValuedObjectReference_in_entryRuleValuedObjectReference6151 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValuedObjectReference6161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleValuedObjectReference6207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextExpression_in_entryRuleTextExpression6242 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTextExpression6252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_HOSTCODE_in_ruleTextExpression6294 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleTextExpression6310 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTextExpression6327 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleTextExpression6342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntValue_in_entryRuleIntValue6380 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIntValue6390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleIntValue6431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFloatValue_in_entryRuleFloatValue6471 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFloatValue6481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_FLOAT_in_ruleFloatValue6522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanValue_in_entryRuleBooleanValue6562 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanValue6572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_BOOLEAN_in_ruleBooleanValue6613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnyType_in_entryRuleAnyType6654 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAnyType6665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_BOOLEAN_in_ruleAnyType6705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleAnyType6731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_FLOAT_in_ruleAnyType6757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAnyType6783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAnyType6809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInterfaceDeclaration_in_entryRuleInterfaceDeclaration6854 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInterfaceDeclaration6864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInterfaceSignalDecl_in_ruleInterfaceDeclaration6914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInterfaceVariableDecl_in_ruleInterfaceDeclaration6944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleISignal_in_entryRuleISignal6979 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleISignal6989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleISignal7031 = new BitSet(new long[]{0x0000020000090002L});
        public static final BitSet FOLLOW_ruleChannelDescription_in_ruleISignal7057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInterfaceSignalDecl_in_entryRuleInterfaceSignalDecl7094 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInterfaceSignalDecl7104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleInterfaceSignalDecl7152 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7173 = new BitSet(new long[]{0x0000100004000000L});
        public static final BitSet FOLLOW_26_in_ruleInterfaceSignalDecl7184 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7205 = new BitSet(new long[]{0x0000100004000000L});
        public static final BitSet FOLLOW_44_in_ruleInterfaceSignalDecl7217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleInterfaceSignalDecl7247 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7268 = new BitSet(new long[]{0x0000100004000000L});
        public static final BitSet FOLLOW_26_in_ruleInterfaceSignalDecl7279 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7300 = new BitSet(new long[]{0x0000100004000000L});
        public static final BitSet FOLLOW_44_in_ruleInterfaceSignalDecl7312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleInterfaceSignalDecl7342 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7363 = new BitSet(new long[]{0x0000100004000000L});
        public static final BitSet FOLLOW_26_in_ruleInterfaceSignalDecl7374 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7395 = new BitSet(new long[]{0x0000100004000000L});
        public static final BitSet FOLLOW_44_in_ruleInterfaceSignalDecl7407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleInterfaceSignalDecl7437 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7458 = new BitSet(new long[]{0x0000100004000000L});
        public static final BitSet FOLLOW_26_in_ruleInterfaceSignalDecl7469 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleISignal_in_ruleInterfaceSignalDecl7490 = new BitSet(new long[]{0x0000100004000000L});
        public static final BitSet FOLLOW_44_in_ruleInterfaceSignalDecl7502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChannelDescription_in_entryRuleChannelDescription7539 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChannelDescription7549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleChannelDescription7585 = new BitSet(new long[]{0x0000040000000010L,0x00000000000007E0L});
        public static final BitSet FOLLOW_ruleTypeIdentifier_in_ruleChannelDescription7606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleChannelDescription7624 = new BitSet(new long[]{0x0000040000000010L,0x00000000000007E0L});
        public static final BitSet FOLLOW_ruleTypeIdentifier_in_ruleChannelDescription7645 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleChannelDescription7655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleChannelDescription7673 = new BitSet(new long[]{0x90000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleChannelDescription7694 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleChannelDescription7704 = new BitSet(new long[]{0x0000040000000010L,0x00000000000007E0L});
        public static final BitSet FOLLOW_ruleTypeIdentifier_in_ruleChannelDescription7725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInterfaceVariableDecl_in_entryRuleInterfaceVariableDecl7762 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInterfaceVariableDecl7772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleInterfaceVariableDecl7807 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleVariableDecl_in_ruleInterfaceVariableDecl7828 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleInterfaceVariableDecl7839 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleVariableDecl_in_ruleInterfaceVariableDecl7860 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_ruleVariableDecl_in_entryRuleVariableDecl7898 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariableDecl7908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIVariable_in_ruleVariableDecl7954 = new BitSet(new long[]{0x0000000004010000L});
        public static final BitSet FOLLOW_26_in_ruleVariableDecl7965 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleIVariable_in_ruleVariableDecl7986 = new BitSet(new long[]{0x0000000004010000L});
        public static final BitSet FOLLOW_16_in_ruleVariableDecl7998 = new BitSet(new long[]{0x0000040000000010L,0x00000000000007E0L});
        public static final BitSet FOLLOW_ruleTypeIdentifier_in_ruleVariableDecl8019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIVariable_in_entryRuleIVariable8055 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIVariable8065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIVariable8107 = new BitSet(new long[]{0x0000020000000002L});
        public static final BitSet FOLLOW_41_in_ruleIVariable8123 = new BitSet(new long[]{0x90000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleIVariable8144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeIdentifier_in_entryRuleTypeIdentifier8182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeIdentifier8192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueType_in_ruleTypeIdentifier8238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeIdentifier8261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleTypeIdentifier8283 = new BitSet(new long[]{0x0000000000000010L,0x00000000000007E0L});
        public static final BitSet FOLLOW_ruleValueType_in_ruleTypeIdentifier8305 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeIdentifier8328 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleTypeIdentifier8344 = new BitSet(new long[]{0x6000000000000000L,0x0000000000003C05L});
        public static final BitSet FOLLOW_ruleCombineOperator_in_ruleTypeIdentifier8365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringAnnotation_in_entryRuleStringAnnotation8402 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringAnnotation8412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommentAnnotation_in_ruleStringAnnotation8462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyValueAnnotation_in_ruleStringAnnotation8492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommentAnnotation_in_entryRuleCommentAnnotation8527 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCommentAnnotation8537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_COMMENT_ANNOTATION_in_ruleCommentAnnotation8578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKeyValueAnnotation_in_entryRuleKeyValueAnnotation8618 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKeyValueAnnotation8628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleKeyValueAnnotation8663 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleKeyValueAnnotation8680 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleKeyValueAnnotation8706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImportAnnotation_in_entryRuleImportAnnotation8742 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImportAnnotation8752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleImportAnnotation8787 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleImportAnnotation8804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString8846 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString8857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString8897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString8923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleStateType8980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleStateType8995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleStateType9010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleStateType9025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleTransitionType9068 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleTransitionType9083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleTransitionType9098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleDivOperator9140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleCompareOperator9182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleCompareOperator9197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleCompareOperator9212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleCompareOperator9227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleCompareOperator9242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleCompareOperator9257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rulePreOperator9299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleOrOperator9340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleAndOperator9381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleNotOperator9422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleAddOperator9463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleSubOperator9504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleMultOperator9545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleModOperator9586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleValueTestOperator9627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleValueType9669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleValueType9684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_ruleValueType9699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleValueType9714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_73_in_ruleValueType9729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_74_in_ruleValueType9744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleCombineOperator9787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleCombineOperator9802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleCombineOperator9817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleCombineOperator9832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_ruleCombineOperator9847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleCombineOperator9862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleCombineOperator9877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_74_in_ruleCombineOperator9892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringAnnotation_in_synpred7233 = new BitSet(new long[]{0x0000000001008400L});
        public static final BitSet FOLLOW_15_in_synpred7244 = new BitSet(new long[]{0x0000000000010030L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred7261 = new BitSet(new long[]{0x0000000000010020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred7284 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_synpred7300 = new BitSet(new long[]{0x000009C000020002L});
        public static final BitSet FOLLOW_ruleVariable_in_synpred7322 = new BitSet(new long[]{0x000009C000020002L});
        public static final BitSet FOLLOW_ruleSignal_in_synpred7349 = new BitSet(new long[]{0x000009C000020002L});
        public static final BitSet FOLLOW_ruleTextualCode_in_synpred7372 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleSingleRegion_in_synpred351510 = new BitSet(new long[]{0x0000000001008402L});
        public static final BitSet FOLLOW_ruleRegion_in_synpred351531 = new BitSet(new long[]{0x0000000001008402L});
        public static final BitSet FOLLOW_RULE_INT_in_synpred411791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_synpred592813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanExpression_in_synpred673561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotOrValuedExpression_in_synpred704084 = new BitSet(new long[]{0x0FC0000000000000L});
        public static final BitSet FOLLOW_ruleCompareOperator_in_synpred704117 = new BitSet(new long[]{0x90000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleNotOrValuedExpression_in_synpred704138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValuedExpression_in_synpred714266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDivOperator_in_synpred765130 = new BitSet(new long[]{0x10000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleModExpression_in_synpred765151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_synpred845811 = new BitSet(new long[]{0x10000000000803D0L,0x0000000000000012L});
        public static final BitSet FOLLOW_ruleValuedExpression_in_synpred845836 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_synpred845845 = new BitSet(new long[]{0x0000000000000002L});
    }


}