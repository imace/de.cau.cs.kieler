package de.cau.cs.kieler.synccharts.dsl.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import de.cau.cs.kieler.synccharts.dsl.services.KitsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalKitsParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalKitsParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[13+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g"; }


     
     	private KitsGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(KitsGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start entryRuleRegion
    // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:61:1: entryRuleRegion : ruleRegion EOF ;
    public final void entryRuleRegion() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:61:17: ( ruleRegion EOF )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:62:1: ruleRegion EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRegionRule()); 
            }
            pushFollow(FOLLOW_ruleRegion_in_entryRuleRegion66);
            ruleRegion();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRegionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRegion73); if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleRegion


    // $ANTLR start ruleRegion
    // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:69:1: ruleRegion : ( ( rule__Region__InnerStatesAssignment ) ) ;
    public final void ruleRegion() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:73:2: ( ( ( rule__Region__InnerStatesAssignment ) ) )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:74:1: ( ( rule__Region__InnerStatesAssignment ) )
            {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:74:1: ( ( rule__Region__InnerStatesAssignment ) )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:75:1: ( rule__Region__InnerStatesAssignment )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRegionAccess().getInnerStatesAssignment()); 
            }
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:76:1: ( rule__Region__InnerStatesAssignment )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:76:2: rule__Region__InnerStatesAssignment
            {
            pushFollow(FOLLOW_rule__Region__InnerStatesAssignment_in_ruleRegion100);
            rule__Region__InnerStatesAssignment();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getRegionAccess().getInnerStatesAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleRegion


    // $ANTLR start entryRuleState
    // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:88:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:88:16: ( ruleState EOF )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:89:1: ruleState EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStateRule()); 
            }
            pushFollow(FOLLOW_ruleState_in_entryRuleState126);
            ruleState();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getStateRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleState133); if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleState


    // $ANTLR start ruleState
    // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:96:1: ruleState : ( ( rule__State__Group__0 ) ) ;
    public final void ruleState() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:100:2: ( ( ( rule__State__Group__0 ) ) )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:101:1: ( ( rule__State__Group__0 ) )
            {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:101:1: ( ( rule__State__Group__0 ) )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:102:1: ( rule__State__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStateAccess().getGroup()); 
            }
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:103:1: ( rule__State__Group__0 )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:103:2: rule__State__Group__0
            {
            pushFollow(FOLLOW_rule__State__Group__0_in_ruleState160);
            rule__State__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getStateAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleState


    // $ANTLR start rule__State__Group__0
    // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:117:1: rule__State__Group__0 : ( ( rule__State__LabelAssignment_0 ) ) rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:121:1: ( ( ( rule__State__LabelAssignment_0 ) ) rule__State__Group__1 )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:122:1: ( ( rule__State__LabelAssignment_0 ) ) rule__State__Group__1
            {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:122:1: ( ( rule__State__LabelAssignment_0 ) )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:123:1: ( rule__State__LabelAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStateAccess().getLabelAssignment_0()); 
            }
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:124:1: ( rule__State__LabelAssignment_0 )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:124:2: rule__State__LabelAssignment_0
            {
            pushFollow(FOLLOW_rule__State__LabelAssignment_0_in_rule__State__Group__0198);
            rule__State__LabelAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getStateAccess().getLabelAssignment_0()); 
            }

            }

            pushFollow(FOLLOW_rule__State__Group__1_in_rule__State__Group__0207);
            rule__State__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__Group__0


    // $ANTLR start rule__State__Group__1
    // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:135:1: rule__State__Group__1 : ( ( rule__State__IdAssignment_1 )? ) rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:139:1: ( ( ( rule__State__IdAssignment_1 )? ) rule__State__Group__2 )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:140:1: ( ( rule__State__IdAssignment_1 )? ) rule__State__Group__2
            {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:140:1: ( ( rule__State__IdAssignment_1 )? )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:141:1: ( rule__State__IdAssignment_1 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStateAccess().getIdAssignment_1()); 
            }
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:142:1: ( rule__State__IdAssignment_1 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_STRING) ) {
                int LA1_1 = input.LA(2);

                if ( (synpred1()) ) {
                    alt1=1;
                }
            }
            switch (alt1) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:142:2: rule__State__IdAssignment_1
                    {
                    pushFollow(FOLLOW_rule__State__IdAssignment_1_in_rule__State__Group__1235);
                    rule__State__IdAssignment_1();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getStateAccess().getIdAssignment_1()); 
            }

            }

            pushFollow(FOLLOW_rule__State__Group__2_in_rule__State__Group__1245);
            rule__State__Group__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__Group__1


    // $ANTLR start rule__State__Group__2
    // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:153:1: rule__State__Group__2 : ( ( rule__State__BodyTextAssignment_2 )? ) ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:157:1: ( ( ( rule__State__BodyTextAssignment_2 )? ) )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:158:1: ( ( rule__State__BodyTextAssignment_2 )? )
            {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:158:1: ( ( rule__State__BodyTextAssignment_2 )? )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:159:1: ( rule__State__BodyTextAssignment_2 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStateAccess().getBodyTextAssignment_2()); 
            }
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:160:1: ( rule__State__BodyTextAssignment_2 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:160:2: rule__State__BodyTextAssignment_2
                    {
                    pushFollow(FOLLOW_rule__State__BodyTextAssignment_2_in_rule__State__Group__2273);
                    rule__State__BodyTextAssignment_2();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getStateAccess().getBodyTextAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__Group__2


    // $ANTLR start rule__Region__InnerStatesAssignment
    // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:176:1: rule__Region__InnerStatesAssignment : ( ruleState ) ;
    public final void rule__Region__InnerStatesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:180:1: ( ( ruleState ) )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:181:1: ( ruleState )
            {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:181:1: ( ruleState )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:182:1: ruleState
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRegionAccess().getInnerStatesStateParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleState_in_rule__Region__InnerStatesAssignment314);
            ruleState();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRegionAccess().getInnerStatesStateParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Region__InnerStatesAssignment


    // $ANTLR start rule__State__LabelAssignment_0
    // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:191:1: rule__State__LabelAssignment_0 : ( RULE_ID ) ;
    public final void rule__State__LabelAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:195:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:196:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:196:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:197:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStateAccess().getLabelIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__State__LabelAssignment_0345); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getStateAccess().getLabelIDTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__LabelAssignment_0


    // $ANTLR start rule__State__IdAssignment_1
    // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:206:1: rule__State__IdAssignment_1 : ( RULE_STRING ) ;
    public final void rule__State__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:210:1: ( ( RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:211:1: ( RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:211:1: ( RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:212:1: RULE_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStateAccess().getIdSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__State__IdAssignment_1376); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getStateAccess().getIdSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__IdAssignment_1


    // $ANTLR start rule__State__BodyTextAssignment_2
    // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:221:1: rule__State__BodyTextAssignment_2 : ( RULE_STRING ) ;
    public final void rule__State__BodyTextAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:225:1: ( ( RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:226:1: ( RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:226:1: ( RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:227:1: RULE_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStateAccess().getBodyTextSTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__State__BodyTextAssignment_2407); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getStateAccess().getBodyTextSTRINGTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__State__BodyTextAssignment_2

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:142:2: ( rule__State__IdAssignment_1 )
        // ../de.cau.cs.kieler.synccharts.dsl.kits.ui/src-gen/de/cau/cs/kieler/synccharts/dsl/contentassist/antlr/internal/InternalKits.g:142:2: rule__State__IdAssignment_1
        {
        pushFollow(FOLLOW_rule__State__IdAssignment_1_in_synpred1235);
        rule__State__IdAssignment_1();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred1

    public final boolean synpred1() {
        backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleRegion_in_entryRuleRegion66 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRegion73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Region__InnerStatesAssignment_in_ruleRegion100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState126 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__0_in_ruleState160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__LabelAssignment_0_in_rule__State__Group__0198 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__State__Group__1_in_rule__State__Group__0207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__IdAssignment_1_in_rule__State__Group__1235 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__State__Group__2_in_rule__State__Group__1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__BodyTextAssignment_2_in_rule__State__Group__2273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_rule__Region__InnerStatesAssignment314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__State__LabelAssignment_0345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__State__IdAssignment_1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__State__BodyTextAssignment_2407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__IdAssignment_1_in_synpred1235 = new BitSet(new long[]{0x0000000000000002L});

}