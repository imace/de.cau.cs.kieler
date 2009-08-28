package de.cau.cs.kieler.xtext.contentassist.antlr.internal; 

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
import de.cau.cs.kieler.xtext.services.ExampleGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalExampleParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'('", "')'", "'not'", "'and'", "'or'"
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
            ruleMemo = new HashMap[56+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g"; }


     
     	private ExampleGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ExampleGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleModel
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:61:16: ( ruleModel EOF )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:62:1: ruleModel EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel66);
            ruleModel();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getModelRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel73); if (failed) return ;

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:69:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:73:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:74:1: ( ( rule__Model__Group__0 ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:74:1: ( ( rule__Model__Group__0 ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:75:1: ( rule__Model__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getModelAccess().getGroup()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:76:1: ( rule__Model__Group__0 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:76:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel100);
            rule__Model__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getModelAccess().getGroup()); 
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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleAction
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:88:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:88:17: ( ruleAction EOF )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:89:1: ruleAction EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getActionRule()); 
            }
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction126);
            ruleAction();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getActionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction133); if (failed) return ;

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
    // $ANTLR end entryRuleAction


    // $ANTLR start ruleAction
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:96:1: ruleAction : ( ( rule__Action__TriggersAssignment ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:100:2: ( ( ( rule__Action__TriggersAssignment ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:101:1: ( ( rule__Action__TriggersAssignment ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:101:1: ( ( rule__Action__TriggersAssignment ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:102:1: ( rule__Action__TriggersAssignment )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getActionAccess().getTriggersAssignment()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:103:1: ( rule__Action__TriggersAssignment )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:103:2: rule__Action__TriggersAssignment
            {
            pushFollow(FOLLOW_rule__Action__TriggersAssignment_in_ruleAction160);
            rule__Action__TriggersAssignment();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getActionAccess().getTriggersAssignment()); 
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
    // $ANTLR end ruleAction


    // $ANTLR start entryRuleSignal
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:115:1: entryRuleSignal : ruleSignal EOF ;
    public final void entryRuleSignal() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:115:17: ( ruleSignal EOF )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:116:1: ruleSignal EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getSignalRule()); 
            }
            pushFollow(FOLLOW_ruleSignal_in_entryRuleSignal186);
            ruleSignal();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getSignalRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignal193); if (failed) return ;

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
    // $ANTLR end entryRuleSignal


    // $ANTLR start ruleSignal
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:123:1: ruleSignal : ( ( rule__Signal__NameAssignment ) ) ;
    public final void ruleSignal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:127:2: ( ( ( rule__Signal__NameAssignment ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:128:1: ( ( rule__Signal__NameAssignment ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:128:1: ( ( rule__Signal__NameAssignment ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:129:1: ( rule__Signal__NameAssignment )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getSignalAccess().getNameAssignment()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:130:1: ( rule__Signal__NameAssignment )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:130:2: rule__Signal__NameAssignment
            {
            pushFollow(FOLLOW_rule__Signal__NameAssignment_in_ruleSignal220);
            rule__Signal__NameAssignment();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getSignalAccess().getNameAssignment()); 
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
    // $ANTLR end ruleSignal


    // $ANTLR start entryRuleSignalReference
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:142:1: entryRuleSignalReference : ruleSignalReference EOF ;
    public final void entryRuleSignalReference() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:142:26: ( ruleSignalReference EOF )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:143:1: ruleSignalReference EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getSignalReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleSignalReference_in_entryRuleSignalReference246);
            ruleSignalReference();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getSignalReferenceRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignalReference253); if (failed) return ;

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
    // $ANTLR end entryRuleSignalReference


    // $ANTLR start ruleSignalReference
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:150:1: ruleSignalReference : ( ( rule__SignalReference__SignalAssignment ) ) ;
    public final void ruleSignalReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:154:2: ( ( ( rule__SignalReference__SignalAssignment ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:155:1: ( ( rule__SignalReference__SignalAssignment ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:155:1: ( ( rule__SignalReference__SignalAssignment ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:156:1: ( rule__SignalReference__SignalAssignment )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getSignalReferenceAccess().getSignalAssignment()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:157:1: ( rule__SignalReference__SignalAssignment )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:157:2: rule__SignalReference__SignalAssignment
            {
            pushFollow(FOLLOW_rule__SignalReference__SignalAssignment_in_ruleSignalReference280);
            rule__SignalReference__SignalAssignment();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getSignalReferenceAccess().getSignalAssignment()); 
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
    // $ANTLR end ruleSignalReference


    // $ANTLR start entryRuleNotOperation
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:169:1: entryRuleNotOperation : ruleNotOperation EOF ;
    public final void entryRuleNotOperation() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:169:23: ( ruleNotOperation EOF )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:170:1: ruleNotOperation EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getNotOperationRule()); 
            }
            pushFollow(FOLLOW_ruleNotOperation_in_entryRuleNotOperation306);
            ruleNotOperation();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getNotOperationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNotOperation313); if (failed) return ;

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
    // $ANTLR end entryRuleNotOperation


    // $ANTLR start ruleNotOperation
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:177:1: ruleNotOperation : ( ( rule__NotOperation__Group__0 ) ) ;
    public final void ruleNotOperation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:181:2: ( ( ( rule__NotOperation__Group__0 ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:182:1: ( ( rule__NotOperation__Group__0 ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:182:1: ( ( rule__NotOperation__Group__0 ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:183:1: ( rule__NotOperation__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getNotOperationAccess().getGroup()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:184:1: ( rule__NotOperation__Group__0 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:184:2: rule__NotOperation__Group__0
            {
            pushFollow(FOLLOW_rule__NotOperation__Group__0_in_ruleNotOperation340);
            rule__NotOperation__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getNotOperationAccess().getGroup()); 
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
    // $ANTLR end ruleNotOperation


    // $ANTLR start entryRuleNotOrNormalExpression
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:196:1: entryRuleNotOrNormalExpression : ruleNotOrNormalExpression EOF ;
    public final void entryRuleNotOrNormalExpression() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:196:32: ( ruleNotOrNormalExpression EOF )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:197:1: ruleNotOrNormalExpression EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getNotOrNormalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNotOrNormalExpression_in_entryRuleNotOrNormalExpression366);
            ruleNotOrNormalExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getNotOrNormalExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNotOrNormalExpression373); if (failed) return ;

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
    // $ANTLR end entryRuleNotOrNormalExpression


    // $ANTLR start ruleNotOrNormalExpression
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:204:1: ruleNotOrNormalExpression : ( ( rule__NotOrNormalExpression__Alternatives ) ) ;
    public final void ruleNotOrNormalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:208:2: ( ( ( rule__NotOrNormalExpression__Alternatives ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:209:1: ( ( rule__NotOrNormalExpression__Alternatives ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:209:1: ( ( rule__NotOrNormalExpression__Alternatives ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:210:1: ( rule__NotOrNormalExpression__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getNotOrNormalExpressionAccess().getAlternatives()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:211:1: ( rule__NotOrNormalExpression__Alternatives )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:211:2: rule__NotOrNormalExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__NotOrNormalExpression__Alternatives_in_ruleNotOrNormalExpression400);
            rule__NotOrNormalExpression__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getNotOrNormalExpressionAccess().getAlternatives()); 
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
    // $ANTLR end ruleNotOrNormalExpression


    // $ANTLR start entryRuleAndOperation
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:223:1: entryRuleAndOperation : ruleAndOperation EOF ;
    public final void entryRuleAndOperation() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:223:23: ( ruleAndOperation EOF )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:224:1: ruleAndOperation EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAndOperationRule()); 
            }
            pushFollow(FOLLOW_ruleAndOperation_in_entryRuleAndOperation426);
            ruleAndOperation();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAndOperationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOperation433); if (failed) return ;

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
    // $ANTLR end entryRuleAndOperation


    // $ANTLR start ruleAndOperation
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:231:1: ruleAndOperation : ( ( rule__AndOperation__Group__0 ) ) ;
    public final void ruleAndOperation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:235:2: ( ( ( rule__AndOperation__Group__0 ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:236:1: ( ( rule__AndOperation__Group__0 ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:236:1: ( ( rule__AndOperation__Group__0 ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:237:1: ( rule__AndOperation__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAndOperationAccess().getGroup()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:238:1: ( rule__AndOperation__Group__0 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:238:2: rule__AndOperation__Group__0
            {
            pushFollow(FOLLOW_rule__AndOperation__Group__0_in_ruleAndOperation460);
            rule__AndOperation__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAndOperationAccess().getGroup()); 
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
    // $ANTLR end ruleAndOperation


    // $ANTLR start entryRuleOrOperation
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:250:1: entryRuleOrOperation : ruleOrOperation EOF ;
    public final void entryRuleOrOperation() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:250:22: ( ruleOrOperation EOF )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:251:1: ruleOrOperation EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOrOperationRule()); 
            }
            pushFollow(FOLLOW_ruleOrOperation_in_entryRuleOrOperation486);
            ruleOrOperation();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOrOperationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrOperation493); if (failed) return ;

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
    // $ANTLR end entryRuleOrOperation


    // $ANTLR start ruleOrOperation
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:258:1: ruleOrOperation : ( ( rule__OrOperation__Group__0 ) ) ;
    public final void ruleOrOperation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:262:2: ( ( ( rule__OrOperation__Group__0 ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:263:1: ( ( rule__OrOperation__Group__0 ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:263:1: ( ( rule__OrOperation__Group__0 ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:264:1: ( rule__OrOperation__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOrOperationAccess().getGroup()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:265:1: ( rule__OrOperation__Group__0 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:265:2: rule__OrOperation__Group__0
            {
            pushFollow(FOLLOW_rule__OrOperation__Group__0_in_ruleOrOperation520);
            rule__OrOperation__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getOrOperationAccess().getGroup()); 
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
    // $ANTLR end ruleOrOperation


    // $ANTLR start entryRuleParanthesedBooleanExpression
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:277:1: entryRuleParanthesedBooleanExpression : ruleParanthesedBooleanExpression EOF ;
    public final void entryRuleParanthesedBooleanExpression() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:277:39: ( ruleParanthesedBooleanExpression EOF )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:278:1: ruleParanthesedBooleanExpression EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParanthesedBooleanExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleParanthesedBooleanExpression_in_entryRuleParanthesedBooleanExpression546);
            ruleParanthesedBooleanExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParanthesedBooleanExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParanthesedBooleanExpression553); if (failed) return ;

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
    // $ANTLR end entryRuleParanthesedBooleanExpression


    // $ANTLR start ruleParanthesedBooleanExpression
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:285:1: ruleParanthesedBooleanExpression : ( ( rule__ParanthesedBooleanExpression__Alternatives ) ) ;
    public final void ruleParanthesedBooleanExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:289:2: ( ( ( rule__ParanthesedBooleanExpression__Alternatives ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:290:1: ( ( rule__ParanthesedBooleanExpression__Alternatives ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:290:1: ( ( rule__ParanthesedBooleanExpression__Alternatives ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:291:1: ( rule__ParanthesedBooleanExpression__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParanthesedBooleanExpressionAccess().getAlternatives()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:292:1: ( rule__ParanthesedBooleanExpression__Alternatives )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:292:2: rule__ParanthesedBooleanExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__ParanthesedBooleanExpression__Alternatives_in_ruleParanthesedBooleanExpression580);
            rule__ParanthesedBooleanExpression__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getParanthesedBooleanExpressionAccess().getAlternatives()); 
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
    // $ANTLR end ruleParanthesedBooleanExpression


    // $ANTLR start entryRuleBooleanExpression
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:304:1: entryRuleBooleanExpression : ruleBooleanExpression EOF ;
    public final void entryRuleBooleanExpression() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:304:28: ( ruleBooleanExpression EOF )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:305:1: ruleBooleanExpression EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression606);
            ruleBooleanExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getBooleanExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanExpression613); if (failed) return ;

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
    // $ANTLR end entryRuleBooleanExpression


    // $ANTLR start ruleBooleanExpression
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:312:1: ruleBooleanExpression : ( ruleOrOperation ) ;
    public final void ruleBooleanExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:316:2: ( ( ruleOrOperation ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:317:1: ( ruleOrOperation )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:317:1: ( ruleOrOperation )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:318:1: ruleOrOperation
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getOrOperationParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleOrOperation_in_ruleBooleanExpression640);
            ruleOrOperation();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getBooleanExpressionAccess().getOrOperationParserRuleCall()); 
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
    // $ANTLR end ruleBooleanExpression


    // $ANTLR start rule__NotOrNormalExpression__Alternatives
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:331:1: rule__NotOrNormalExpression__Alternatives : ( ( ruleNotOperation ) | ( ruleParanthesedBooleanExpression ) );
    public final void rule__NotOrNormalExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:335:1: ( ( ruleNotOperation ) | ( ruleParanthesedBooleanExpression ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID||LA1_0==12) ) {
                alt1=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("331:1: rule__NotOrNormalExpression__Alternatives : ( ( ruleNotOperation ) | ( ruleParanthesedBooleanExpression ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:336:1: ( ruleNotOperation )
                    {
                    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:336:1: ( ruleNotOperation )
                    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:337:1: ruleNotOperation
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getNotOrNormalExpressionAccess().getNotOperationParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleNotOperation_in_rule__NotOrNormalExpression__Alternatives675);
                    ruleNotOperation();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getNotOrNormalExpressionAccess().getNotOperationParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:342:6: ( ruleParanthesedBooleanExpression )
                    {
                    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:342:6: ( ruleParanthesedBooleanExpression )
                    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:343:1: ruleParanthesedBooleanExpression
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getNotOrNormalExpressionAccess().getParanthesedBooleanExpressionParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleParanthesedBooleanExpression_in_rule__NotOrNormalExpression__Alternatives692);
                    ruleParanthesedBooleanExpression();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getNotOrNormalExpressionAccess().getParanthesedBooleanExpressionParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

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
    // $ANTLR end rule__NotOrNormalExpression__Alternatives


    // $ANTLR start rule__ParanthesedBooleanExpression__Alternatives
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:353:1: rule__ParanthesedBooleanExpression__Alternatives : ( ( ruleSignalReference ) | ( ( rule__ParanthesedBooleanExpression__Group_1__0 ) ) );
    public final void rule__ParanthesedBooleanExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:357:1: ( ( ruleSignalReference ) | ( ( rule__ParanthesedBooleanExpression__Group_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("353:1: rule__ParanthesedBooleanExpression__Alternatives : ( ( ruleSignalReference ) | ( ( rule__ParanthesedBooleanExpression__Group_1__0 ) ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:358:1: ( ruleSignalReference )
                    {
                    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:358:1: ( ruleSignalReference )
                    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:359:1: ruleSignalReference
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getParanthesedBooleanExpressionAccess().getSignalReferenceParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleSignalReference_in_rule__ParanthesedBooleanExpression__Alternatives724);
                    ruleSignalReference();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getParanthesedBooleanExpressionAccess().getSignalReferenceParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:364:6: ( ( rule__ParanthesedBooleanExpression__Group_1__0 ) )
                    {
                    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:364:6: ( ( rule__ParanthesedBooleanExpression__Group_1__0 ) )
                    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:365:1: ( rule__ParanthesedBooleanExpression__Group_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getParanthesedBooleanExpressionAccess().getGroup_1()); 
                    }
                    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:366:1: ( rule__ParanthesedBooleanExpression__Group_1__0 )
                    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:366:2: rule__ParanthesedBooleanExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ParanthesedBooleanExpression__Group_1__0_in_rule__ParanthesedBooleanExpression__Alternatives741);
                    rule__ParanthesedBooleanExpression__Group_1__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getParanthesedBooleanExpressionAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;

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
    // $ANTLR end rule__ParanthesedBooleanExpression__Alternatives


    // $ANTLR start rule__Model__Group__0
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:377:1: rule__Model__Group__0 : ( ( ( rule__Model__SignalsAssignment_0 ) ) ( ( rule__Model__SignalsAssignment_0 )* ) ) rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:381:1: ( ( ( ( rule__Model__SignalsAssignment_0 ) ) ( ( rule__Model__SignalsAssignment_0 )* ) ) rule__Model__Group__1 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:382:1: ( ( ( rule__Model__SignalsAssignment_0 ) ) ( ( rule__Model__SignalsAssignment_0 )* ) ) rule__Model__Group__1
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:382:1: ( ( ( rule__Model__SignalsAssignment_0 ) ) ( ( rule__Model__SignalsAssignment_0 )* ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:383:1: ( ( rule__Model__SignalsAssignment_0 ) ) ( ( rule__Model__SignalsAssignment_0 )* )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:383:1: ( ( rule__Model__SignalsAssignment_0 ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:384:1: ( rule__Model__SignalsAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getModelAccess().getSignalsAssignment_0()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:385:1: ( rule__Model__SignalsAssignment_0 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:385:2: rule__Model__SignalsAssignment_0
            {
            pushFollow(FOLLOW_rule__Model__SignalsAssignment_0_in_rule__Model__Group__0778);
            rule__Model__SignalsAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getModelAccess().getSignalsAssignment_0()); 
            }

            }

            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:388:1: ( ( rule__Model__SignalsAssignment_0 )* )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:389:1: ( rule__Model__SignalsAssignment_0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getModelAccess().getSignalsAssignment_0()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:390:1: ( rule__Model__SignalsAssignment_0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:390:2: rule__Model__SignalsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Model__SignalsAssignment_0_in_rule__Model__Group__0790);
            	    rule__Model__SignalsAssignment_0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getModelAccess().getSignalsAssignment_0()); 
            }

            }


            }

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0802);
            rule__Model__Group__1();
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
    // $ANTLR end rule__Model__Group__0


    // $ANTLR start rule__Model__Group__1
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:402:1: rule__Model__Group__1 : ( ';' ) rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:406:1: ( ( ';' ) rule__Model__Group__2 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:407:1: ( ';' ) rule__Model__Group__2
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:407:1: ( ';' )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:408:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getModelAccess().getSemicolonKeyword_1()); 
            }
            match(input,11,FOLLOW_11_in_rule__Model__Group__1831); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getModelAccess().getSemicolonKeyword_1()); 
            }

            }

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__1841);
            rule__Model__Group__2();
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
    // $ANTLR end rule__Model__Group__1


    // $ANTLR start rule__Model__Group__2
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:422:1: rule__Model__Group__2 : ( ( rule__Model__ActionAssignment_2 ) ) ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:426:1: ( ( ( rule__Model__ActionAssignment_2 ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:427:1: ( ( rule__Model__ActionAssignment_2 ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:427:1: ( ( rule__Model__ActionAssignment_2 ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:428:1: ( rule__Model__ActionAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getModelAccess().getActionAssignment_2()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:429:1: ( rule__Model__ActionAssignment_2 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:429:2: rule__Model__ActionAssignment_2
            {
            pushFollow(FOLLOW_rule__Model__ActionAssignment_2_in_rule__Model__Group__2869);
            rule__Model__ActionAssignment_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getModelAccess().getActionAssignment_2()); 
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
    // $ANTLR end rule__Model__Group__2


    // $ANTLR start rule__NotOperation__Group__0
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:445:1: rule__NotOperation__Group__0 : ( ( rule__NotOperation__OperatorAssignment_0 ) ) rule__NotOperation__Group__1 ;
    public final void rule__NotOperation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:449:1: ( ( ( rule__NotOperation__OperatorAssignment_0 ) ) rule__NotOperation__Group__1 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:450:1: ( ( rule__NotOperation__OperatorAssignment_0 ) ) rule__NotOperation__Group__1
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:450:1: ( ( rule__NotOperation__OperatorAssignment_0 ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:451:1: ( rule__NotOperation__OperatorAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getNotOperationAccess().getOperatorAssignment_0()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:452:1: ( rule__NotOperation__OperatorAssignment_0 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:452:2: rule__NotOperation__OperatorAssignment_0
            {
            pushFollow(FOLLOW_rule__NotOperation__OperatorAssignment_0_in_rule__NotOperation__Group__0909);
            rule__NotOperation__OperatorAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getNotOperationAccess().getOperatorAssignment_0()); 
            }

            }

            pushFollow(FOLLOW_rule__NotOperation__Group__1_in_rule__NotOperation__Group__0918);
            rule__NotOperation__Group__1();
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
    // $ANTLR end rule__NotOperation__Group__0


    // $ANTLR start rule__NotOperation__Group__1
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:463:1: rule__NotOperation__Group__1 : ( ( rule__NotOperation__SubExpressionsAssignment_1 ) ) ;
    public final void rule__NotOperation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:467:1: ( ( ( rule__NotOperation__SubExpressionsAssignment_1 ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:468:1: ( ( rule__NotOperation__SubExpressionsAssignment_1 ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:468:1: ( ( rule__NotOperation__SubExpressionsAssignment_1 ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:469:1: ( rule__NotOperation__SubExpressionsAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getNotOperationAccess().getSubExpressionsAssignment_1()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:470:1: ( rule__NotOperation__SubExpressionsAssignment_1 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:470:2: rule__NotOperation__SubExpressionsAssignment_1
            {
            pushFollow(FOLLOW_rule__NotOperation__SubExpressionsAssignment_1_in_rule__NotOperation__Group__1946);
            rule__NotOperation__SubExpressionsAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getNotOperationAccess().getSubExpressionsAssignment_1()); 
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
    // $ANTLR end rule__NotOperation__Group__1


    // $ANTLR start rule__AndOperation__Group__0
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:484:1: rule__AndOperation__Group__0 : ( ruleNotOrNormalExpression ) rule__AndOperation__Group__1 ;
    public final void rule__AndOperation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:488:1: ( ( ruleNotOrNormalExpression ) rule__AndOperation__Group__1 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:489:1: ( ruleNotOrNormalExpression ) rule__AndOperation__Group__1
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:489:1: ( ruleNotOrNormalExpression )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:490:1: ruleNotOrNormalExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAndOperationAccess().getNotOrNormalExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleNotOrNormalExpression_in_rule__AndOperation__Group__0984);
            ruleNotOrNormalExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAndOperationAccess().getNotOrNormalExpressionParserRuleCall_0()); 
            }

            }

            pushFollow(FOLLOW_rule__AndOperation__Group__1_in_rule__AndOperation__Group__0992);
            rule__AndOperation__Group__1();
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
    // $ANTLR end rule__AndOperation__Group__0


    // $ANTLR start rule__AndOperation__Group__1
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:502:1: rule__AndOperation__Group__1 : ( ( rule__AndOperation__Group_1__0 )* ) ;
    public final void rule__AndOperation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:506:1: ( ( ( rule__AndOperation__Group_1__0 )* ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:507:1: ( ( rule__AndOperation__Group_1__0 )* )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:507:1: ( ( rule__AndOperation__Group_1__0 )* )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:508:1: ( rule__AndOperation__Group_1__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAndOperationAccess().getGroup_1()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:509:1: ( rule__AndOperation__Group_1__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:509:2: rule__AndOperation__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AndOperation__Group_1__0_in_rule__AndOperation__Group__11020);
            	    rule__AndOperation__Group_1__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getAndOperationAccess().getGroup_1()); 
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
    // $ANTLR end rule__AndOperation__Group__1


    // $ANTLR start rule__AndOperation__Group_1__0
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:523:1: rule__AndOperation__Group_1__0 : ( () ) rule__AndOperation__Group_1__1 ;
    public final void rule__AndOperation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:527:1: ( ( () ) rule__AndOperation__Group_1__1 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:528:1: ( () ) rule__AndOperation__Group_1__1
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:528:1: ( () )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:529:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAndOperationAccess().getOperationSubExpressionsAction_1_0()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:530:1: ()
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:532:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAndOperationAccess().getOperationSubExpressionsAction_1_0()); 
            }

            }

            pushFollow(FOLLOW_rule__AndOperation__Group_1__1_in_rule__AndOperation__Group_1__01069);
            rule__AndOperation__Group_1__1();
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
    // $ANTLR end rule__AndOperation__Group_1__0


    // $ANTLR start rule__AndOperation__Group_1__1
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:543:1: rule__AndOperation__Group_1__1 : ( ( rule__AndOperation__OperatorAssignment_1_1 ) ) rule__AndOperation__Group_1__2 ;
    public final void rule__AndOperation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:547:1: ( ( ( rule__AndOperation__OperatorAssignment_1_1 ) ) rule__AndOperation__Group_1__2 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:548:1: ( ( rule__AndOperation__OperatorAssignment_1_1 ) ) rule__AndOperation__Group_1__2
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:548:1: ( ( rule__AndOperation__OperatorAssignment_1_1 ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:549:1: ( rule__AndOperation__OperatorAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAndOperationAccess().getOperatorAssignment_1_1()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:550:1: ( rule__AndOperation__OperatorAssignment_1_1 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:550:2: rule__AndOperation__OperatorAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AndOperation__OperatorAssignment_1_1_in_rule__AndOperation__Group_1__11097);
            rule__AndOperation__OperatorAssignment_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAndOperationAccess().getOperatorAssignment_1_1()); 
            }

            }

            pushFollow(FOLLOW_rule__AndOperation__Group_1__2_in_rule__AndOperation__Group_1__11106);
            rule__AndOperation__Group_1__2();
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
    // $ANTLR end rule__AndOperation__Group_1__1


    // $ANTLR start rule__AndOperation__Group_1__2
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:561:1: rule__AndOperation__Group_1__2 : ( ( rule__AndOperation__SubExpressionsAssignment_1_2 ) ) ;
    public final void rule__AndOperation__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:565:1: ( ( ( rule__AndOperation__SubExpressionsAssignment_1_2 ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:566:1: ( ( rule__AndOperation__SubExpressionsAssignment_1_2 ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:566:1: ( ( rule__AndOperation__SubExpressionsAssignment_1_2 ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:567:1: ( rule__AndOperation__SubExpressionsAssignment_1_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAndOperationAccess().getSubExpressionsAssignment_1_2()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:568:1: ( rule__AndOperation__SubExpressionsAssignment_1_2 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:568:2: rule__AndOperation__SubExpressionsAssignment_1_2
            {
            pushFollow(FOLLOW_rule__AndOperation__SubExpressionsAssignment_1_2_in_rule__AndOperation__Group_1__21134);
            rule__AndOperation__SubExpressionsAssignment_1_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAndOperationAccess().getSubExpressionsAssignment_1_2()); 
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
    // $ANTLR end rule__AndOperation__Group_1__2


    // $ANTLR start rule__OrOperation__Group__0
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:584:1: rule__OrOperation__Group__0 : ( ruleAndOperation ) rule__OrOperation__Group__1 ;
    public final void rule__OrOperation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:588:1: ( ( ruleAndOperation ) rule__OrOperation__Group__1 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:589:1: ( ruleAndOperation ) rule__OrOperation__Group__1
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:589:1: ( ruleAndOperation )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:590:1: ruleAndOperation
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOrOperationAccess().getAndOperationParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleAndOperation_in_rule__OrOperation__Group__01174);
            ruleAndOperation();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOrOperationAccess().getAndOperationParserRuleCall_0()); 
            }

            }

            pushFollow(FOLLOW_rule__OrOperation__Group__1_in_rule__OrOperation__Group__01182);
            rule__OrOperation__Group__1();
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
    // $ANTLR end rule__OrOperation__Group__0


    // $ANTLR start rule__OrOperation__Group__1
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:602:1: rule__OrOperation__Group__1 : ( ( rule__OrOperation__Group_1__0 )* ) ;
    public final void rule__OrOperation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:606:1: ( ( ( rule__OrOperation__Group_1__0 )* ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:607:1: ( ( rule__OrOperation__Group_1__0 )* )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:607:1: ( ( rule__OrOperation__Group_1__0 )* )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:608:1: ( rule__OrOperation__Group_1__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOrOperationAccess().getGroup_1()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:609:1: ( rule__OrOperation__Group_1__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==16) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:609:2: rule__OrOperation__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__OrOperation__Group_1__0_in_rule__OrOperation__Group__11210);
            	    rule__OrOperation__Group_1__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getOrOperationAccess().getGroup_1()); 
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
    // $ANTLR end rule__OrOperation__Group__1


    // $ANTLR start rule__OrOperation__Group_1__0
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:623:1: rule__OrOperation__Group_1__0 : ( () ) rule__OrOperation__Group_1__1 ;
    public final void rule__OrOperation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:627:1: ( ( () ) rule__OrOperation__Group_1__1 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:628:1: ( () ) rule__OrOperation__Group_1__1
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:628:1: ( () )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:629:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOrOperationAccess().getOperationSubExpressionsAction_1_0()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:630:1: ()
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:632:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getOrOperationAccess().getOperationSubExpressionsAction_1_0()); 
            }

            }

            pushFollow(FOLLOW_rule__OrOperation__Group_1__1_in_rule__OrOperation__Group_1__01259);
            rule__OrOperation__Group_1__1();
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
    // $ANTLR end rule__OrOperation__Group_1__0


    // $ANTLR start rule__OrOperation__Group_1__1
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:643:1: rule__OrOperation__Group_1__1 : ( ( rule__OrOperation__OperatorAssignment_1_1 ) ) rule__OrOperation__Group_1__2 ;
    public final void rule__OrOperation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:647:1: ( ( ( rule__OrOperation__OperatorAssignment_1_1 ) ) rule__OrOperation__Group_1__2 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:648:1: ( ( rule__OrOperation__OperatorAssignment_1_1 ) ) rule__OrOperation__Group_1__2
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:648:1: ( ( rule__OrOperation__OperatorAssignment_1_1 ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:649:1: ( rule__OrOperation__OperatorAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOrOperationAccess().getOperatorAssignment_1_1()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:650:1: ( rule__OrOperation__OperatorAssignment_1_1 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:650:2: rule__OrOperation__OperatorAssignment_1_1
            {
            pushFollow(FOLLOW_rule__OrOperation__OperatorAssignment_1_1_in_rule__OrOperation__Group_1__11287);
            rule__OrOperation__OperatorAssignment_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getOrOperationAccess().getOperatorAssignment_1_1()); 
            }

            }

            pushFollow(FOLLOW_rule__OrOperation__Group_1__2_in_rule__OrOperation__Group_1__11296);
            rule__OrOperation__Group_1__2();
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
    // $ANTLR end rule__OrOperation__Group_1__1


    // $ANTLR start rule__OrOperation__Group_1__2
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:661:1: rule__OrOperation__Group_1__2 : ( ( rule__OrOperation__SubExpressionsAssignment_1_2 ) ) ;
    public final void rule__OrOperation__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:665:1: ( ( ( rule__OrOperation__SubExpressionsAssignment_1_2 ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:666:1: ( ( rule__OrOperation__SubExpressionsAssignment_1_2 ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:666:1: ( ( rule__OrOperation__SubExpressionsAssignment_1_2 ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:667:1: ( rule__OrOperation__SubExpressionsAssignment_1_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOrOperationAccess().getSubExpressionsAssignment_1_2()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:668:1: ( rule__OrOperation__SubExpressionsAssignment_1_2 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:668:2: rule__OrOperation__SubExpressionsAssignment_1_2
            {
            pushFollow(FOLLOW_rule__OrOperation__SubExpressionsAssignment_1_2_in_rule__OrOperation__Group_1__21324);
            rule__OrOperation__SubExpressionsAssignment_1_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getOrOperationAccess().getSubExpressionsAssignment_1_2()); 
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
    // $ANTLR end rule__OrOperation__Group_1__2


    // $ANTLR start rule__ParanthesedBooleanExpression__Group_1__0
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:684:1: rule__ParanthesedBooleanExpression__Group_1__0 : ( '(' ) rule__ParanthesedBooleanExpression__Group_1__1 ;
    public final void rule__ParanthesedBooleanExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:688:1: ( ( '(' ) rule__ParanthesedBooleanExpression__Group_1__1 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:689:1: ( '(' ) rule__ParanthesedBooleanExpression__Group_1__1
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:689:1: ( '(' )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:690:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParanthesedBooleanExpressionAccess().getLeftParenthesisKeyword_1_0()); 
            }
            match(input,12,FOLLOW_12_in_rule__ParanthesedBooleanExpression__Group_1__01365); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParanthesedBooleanExpressionAccess().getLeftParenthesisKeyword_1_0()); 
            }

            }

            pushFollow(FOLLOW_rule__ParanthesedBooleanExpression__Group_1__1_in_rule__ParanthesedBooleanExpression__Group_1__01375);
            rule__ParanthesedBooleanExpression__Group_1__1();
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
    // $ANTLR end rule__ParanthesedBooleanExpression__Group_1__0


    // $ANTLR start rule__ParanthesedBooleanExpression__Group_1__1
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:704:1: rule__ParanthesedBooleanExpression__Group_1__1 : ( ruleOrOperation ) rule__ParanthesedBooleanExpression__Group_1__2 ;
    public final void rule__ParanthesedBooleanExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:708:1: ( ( ruleOrOperation ) rule__ParanthesedBooleanExpression__Group_1__2 )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:709:1: ( ruleOrOperation ) rule__ParanthesedBooleanExpression__Group_1__2
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:709:1: ( ruleOrOperation )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:710:1: ruleOrOperation
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParanthesedBooleanExpressionAccess().getOrOperationParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_ruleOrOperation_in_rule__ParanthesedBooleanExpression__Group_1__11403);
            ruleOrOperation();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParanthesedBooleanExpressionAccess().getOrOperationParserRuleCall_1_1()); 
            }

            }

            pushFollow(FOLLOW_rule__ParanthesedBooleanExpression__Group_1__2_in_rule__ParanthesedBooleanExpression__Group_1__11411);
            rule__ParanthesedBooleanExpression__Group_1__2();
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
    // $ANTLR end rule__ParanthesedBooleanExpression__Group_1__1


    // $ANTLR start rule__ParanthesedBooleanExpression__Group_1__2
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:722:1: rule__ParanthesedBooleanExpression__Group_1__2 : ( ')' ) ;
    public final void rule__ParanthesedBooleanExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:726:1: ( ( ')' ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:727:1: ( ')' )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:727:1: ( ')' )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:728:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParanthesedBooleanExpressionAccess().getRightParenthesisKeyword_1_2()); 
            }
            match(input,13,FOLLOW_13_in_rule__ParanthesedBooleanExpression__Group_1__21440); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParanthesedBooleanExpressionAccess().getRightParenthesisKeyword_1_2()); 
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
    // $ANTLR end rule__ParanthesedBooleanExpression__Group_1__2


    // $ANTLR start rule__Model__SignalsAssignment_0
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:747:1: rule__Model__SignalsAssignment_0 : ( ruleSignal ) ;
    public final void rule__Model__SignalsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:751:1: ( ( ruleSignal ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:752:1: ( ruleSignal )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:752:1: ( ruleSignal )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:753:1: ruleSignal
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getModelAccess().getSignalsSignalParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleSignal_in_rule__Model__SignalsAssignment_01481);
            ruleSignal();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getModelAccess().getSignalsSignalParserRuleCall_0_0()); 
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
    // $ANTLR end rule__Model__SignalsAssignment_0


    // $ANTLR start rule__Model__ActionAssignment_2
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:762:1: rule__Model__ActionAssignment_2 : ( ruleAction ) ;
    public final void rule__Model__ActionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:766:1: ( ( ruleAction ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:767:1: ( ruleAction )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:767:1: ( ruleAction )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:768:1: ruleAction
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getModelAccess().getActionActionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleAction_in_rule__Model__ActionAssignment_21512);
            ruleAction();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getModelAccess().getActionActionParserRuleCall_2_0()); 
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
    // $ANTLR end rule__Model__ActionAssignment_2


    // $ANTLR start rule__Action__TriggersAssignment
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:777:1: rule__Action__TriggersAssignment : ( ruleBooleanExpression ) ;
    public final void rule__Action__TriggersAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:781:1: ( ( ruleBooleanExpression ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:782:1: ( ruleBooleanExpression )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:782:1: ( ruleBooleanExpression )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:783:1: ruleBooleanExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getActionAccess().getTriggersBooleanExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleBooleanExpression_in_rule__Action__TriggersAssignment1543);
            ruleBooleanExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getActionAccess().getTriggersBooleanExpressionParserRuleCall_0()); 
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
    // $ANTLR end rule__Action__TriggersAssignment


    // $ANTLR start rule__Signal__NameAssignment
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:792:1: rule__Signal__NameAssignment : ( RULE_ID ) ;
    public final void rule__Signal__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:796:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:797:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:797:1: ( RULE_ID )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:798:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Signal__NameAssignment1574); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_0()); 
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
    // $ANTLR end rule__Signal__NameAssignment


    // $ANTLR start rule__SignalReference__SignalAssignment
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:807:1: rule__SignalReference__SignalAssignment : ( ( RULE_ID ) ) ;
    public final void rule__SignalReference__SignalAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:811:1: ( ( ( RULE_ID ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:812:1: ( ( RULE_ID ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:812:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:813:1: ( RULE_ID )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getSignalReferenceAccess().getSignalSignalCrossReference_0()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:814:1: ( RULE_ID )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:815:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getSignalReferenceAccess().getSignalSignalIDTerminalRuleCall_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SignalReference__SignalAssignment1609); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getSignalReferenceAccess().getSignalSignalIDTerminalRuleCall_0_1()); 
            }

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getSignalReferenceAccess().getSignalSignalCrossReference_0()); 
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
    // $ANTLR end rule__SignalReference__SignalAssignment


    // $ANTLR start rule__NotOperation__OperatorAssignment_0
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:826:1: rule__NotOperation__OperatorAssignment_0 : ( ( 'not' ) ) ;
    public final void rule__NotOperation__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:830:1: ( ( ( 'not' ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:831:1: ( ( 'not' ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:831:1: ( ( 'not' ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:832:1: ( 'not' )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getNotOperationAccess().getOperatorNotKeyword_0_0()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:833:1: ( 'not' )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:834:1: 'not'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getNotOperationAccess().getOperatorNotKeyword_0_0()); 
            }
            match(input,14,FOLLOW_14_in_rule__NotOperation__OperatorAssignment_01649); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getNotOperationAccess().getOperatorNotKeyword_0_0()); 
            }

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getNotOperationAccess().getOperatorNotKeyword_0_0()); 
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
    // $ANTLR end rule__NotOperation__OperatorAssignment_0


    // $ANTLR start rule__NotOperation__SubExpressionsAssignment_1
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:849:1: rule__NotOperation__SubExpressionsAssignment_1 : ( ruleParanthesedBooleanExpression ) ;
    public final void rule__NotOperation__SubExpressionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:853:1: ( ( ruleParanthesedBooleanExpression ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:854:1: ( ruleParanthesedBooleanExpression )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:854:1: ( ruleParanthesedBooleanExpression )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:855:1: ruleParanthesedBooleanExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getNotOperationAccess().getSubExpressionsParanthesedBooleanExpressionParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleParanthesedBooleanExpression_in_rule__NotOperation__SubExpressionsAssignment_11688);
            ruleParanthesedBooleanExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getNotOperationAccess().getSubExpressionsParanthesedBooleanExpressionParserRuleCall_1_0()); 
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
    // $ANTLR end rule__NotOperation__SubExpressionsAssignment_1


    // $ANTLR start rule__AndOperation__OperatorAssignment_1_1
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:864:1: rule__AndOperation__OperatorAssignment_1_1 : ( ( 'and' ) ) ;
    public final void rule__AndOperation__OperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:868:1: ( ( ( 'and' ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:869:1: ( ( 'and' ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:869:1: ( ( 'and' ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:870:1: ( 'and' )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAndOperationAccess().getOperatorAndKeyword_1_1_0()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:871:1: ( 'and' )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:872:1: 'and'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAndOperationAccess().getOperatorAndKeyword_1_1_0()); 
            }
            match(input,15,FOLLOW_15_in_rule__AndOperation__OperatorAssignment_1_11724); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAndOperationAccess().getOperatorAndKeyword_1_1_0()); 
            }

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAndOperationAccess().getOperatorAndKeyword_1_1_0()); 
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
    // $ANTLR end rule__AndOperation__OperatorAssignment_1_1


    // $ANTLR start rule__AndOperation__SubExpressionsAssignment_1_2
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:887:1: rule__AndOperation__SubExpressionsAssignment_1_2 : ( ruleNotOrNormalExpression ) ;
    public final void rule__AndOperation__SubExpressionsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:891:1: ( ( ruleNotOrNormalExpression ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:892:1: ( ruleNotOrNormalExpression )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:892:1: ( ruleNotOrNormalExpression )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:893:1: ruleNotOrNormalExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAndOperationAccess().getSubExpressionsNotOrNormalExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleNotOrNormalExpression_in_rule__AndOperation__SubExpressionsAssignment_1_21763);
            ruleNotOrNormalExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAndOperationAccess().getSubExpressionsNotOrNormalExpressionParserRuleCall_1_2_0()); 
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
    // $ANTLR end rule__AndOperation__SubExpressionsAssignment_1_2


    // $ANTLR start rule__OrOperation__OperatorAssignment_1_1
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:902:1: rule__OrOperation__OperatorAssignment_1_1 : ( ( 'or' ) ) ;
    public final void rule__OrOperation__OperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:906:1: ( ( ( 'or' ) ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:907:1: ( ( 'or' ) )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:907:1: ( ( 'or' ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:908:1: ( 'or' )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOrOperationAccess().getOperatorOrKeyword_1_1_0()); 
            }
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:909:1: ( 'or' )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:910:1: 'or'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOrOperationAccess().getOperatorOrKeyword_1_1_0()); 
            }
            match(input,16,FOLLOW_16_in_rule__OrOperation__OperatorAssignment_1_11799); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOrOperationAccess().getOperatorOrKeyword_1_1_0()); 
            }

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getOrOperationAccess().getOperatorOrKeyword_1_1_0()); 
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
    // $ANTLR end rule__OrOperation__OperatorAssignment_1_1


    // $ANTLR start rule__OrOperation__SubExpressionsAssignment_1_2
    // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:925:1: rule__OrOperation__SubExpressionsAssignment_1_2 : ( ruleAndOperation ) ;
    public final void rule__OrOperation__SubExpressionsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:929:1: ( ( ruleAndOperation ) )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:930:1: ( ruleAndOperation )
            {
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:930:1: ( ruleAndOperation )
            // ../de.cau.cs.kieler.xtext.example.ui/src-gen/de/cau/cs/kieler/xtext/contentassist/antlr/internal/InternalExample.g:931:1: ruleAndOperation
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getOrOperationAccess().getSubExpressionsAndOperationParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleAndOperation_in_rule__OrOperation__SubExpressionsAssignment_1_21838);
            ruleAndOperation();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getOrOperationAccess().getSubExpressionsAndOperationParserRuleCall_1_2_0()); 
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
    // $ANTLR end rule__OrOperation__SubExpressionsAssignment_1_2


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel66 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction126 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Action__TriggersAssignment_in_ruleAction160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_entryRuleSignal186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignal193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__NameAssignment_in_ruleSignal220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignalReference_in_entryRuleSignalReference246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignalReference253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignalReference__SignalAssignment_in_ruleSignalReference280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOperation_in_entryRuleNotOperation306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNotOperation313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NotOperation__Group__0_in_ruleNotOperation340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOrNormalExpression_in_entryRuleNotOrNormalExpression366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNotOrNormalExpression373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NotOrNormalExpression__Alternatives_in_ruleNotOrNormalExpression400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOperation_in_entryRuleAndOperation426 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOperation433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOperation__Group__0_in_ruleAndOperation460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrOperation_in_entryRuleOrOperation486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrOperation493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrOperation__Group__0_in_ruleOrOperation520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParanthesedBooleanExpression_in_entryRuleParanthesedBooleanExpression546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParanthesedBooleanExpression553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParanthesedBooleanExpression__Alternatives_in_ruleParanthesedBooleanExpression580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanExpression613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrOperation_in_ruleBooleanExpression640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOperation_in_rule__NotOrNormalExpression__Alternatives675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParanthesedBooleanExpression_in_rule__NotOrNormalExpression__Alternatives692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignalReference_in_rule__ParanthesedBooleanExpression__Alternatives724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParanthesedBooleanExpression__Group_1__0_in_rule__ParanthesedBooleanExpression__Alternatives741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__SignalsAssignment_0_in_rule__Model__Group__0778 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_rule__Model__SignalsAssignment_0_in_rule__Model__Group__0790 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Model__Group__1831 = new BitSet(new long[]{0x0000000000005010L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__1841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ActionAssignment_2_in_rule__Model__Group__2869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NotOperation__OperatorAssignment_0_in_rule__NotOperation__Group__0909 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__NotOperation__Group__1_in_rule__NotOperation__Group__0918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NotOperation__SubExpressionsAssignment_1_in_rule__NotOperation__Group__1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOrNormalExpression_in_rule__AndOperation__Group__0984 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__AndOperation__Group__1_in_rule__AndOperation__Group__0992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOperation__Group_1__0_in_rule__AndOperation__Group__11020 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__AndOperation__Group_1__1_in_rule__AndOperation__Group_1__01069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOperation__OperatorAssignment_1_1_in_rule__AndOperation__Group_1__11097 = new BitSet(new long[]{0x0000000000005010L});
    public static final BitSet FOLLOW_rule__AndOperation__Group_1__2_in_rule__AndOperation__Group_1__11106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOperation__SubExpressionsAssignment_1_2_in_rule__AndOperation__Group_1__21134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOperation_in_rule__OrOperation__Group__01174 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__OrOperation__Group__1_in_rule__OrOperation__Group__01182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrOperation__Group_1__0_in_rule__OrOperation__Group__11210 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__OrOperation__Group_1__1_in_rule__OrOperation__Group_1__01259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrOperation__OperatorAssignment_1_1_in_rule__OrOperation__Group_1__11287 = new BitSet(new long[]{0x0000000000005010L});
    public static final BitSet FOLLOW_rule__OrOperation__Group_1__2_in_rule__OrOperation__Group_1__11296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrOperation__SubExpressionsAssignment_1_2_in_rule__OrOperation__Group_1__21324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ParanthesedBooleanExpression__Group_1__01365 = new BitSet(new long[]{0x0000000000005010L});
    public static final BitSet FOLLOW_rule__ParanthesedBooleanExpression__Group_1__1_in_rule__ParanthesedBooleanExpression__Group_1__01375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrOperation_in_rule__ParanthesedBooleanExpression__Group_1__11403 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__ParanthesedBooleanExpression__Group_1__2_in_rule__ParanthesedBooleanExpression__Group_1__11411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ParanthesedBooleanExpression__Group_1__21440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_rule__Model__SignalsAssignment_01481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_rule__Model__ActionAssignment_21512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_rule__Action__TriggersAssignment1543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Signal__NameAssignment1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SignalReference__SignalAssignment1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__NotOperation__OperatorAssignment_01649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParanthesedBooleanExpression_in_rule__NotOperation__SubExpressionsAssignment_11688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__AndOperation__OperatorAssignment_1_11724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOrNormalExpression_in_rule__AndOperation__SubExpressionsAssignment_1_21763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__OrOperation__OperatorAssignment_1_11799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOperation_in_rule__OrOperation__SubExpressionsAssignment_1_21838 = new BitSet(new long[]{0x0000000000000002L});

}