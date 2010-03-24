package de.cau.cs.kieler.synccharts.interfacedeclparser.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import de.cau.cs.kieler.synccharts.interfacedeclparser.services.InterfaceDeclGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalInterfaceDeclParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'PURE'", "'BOOL'", "'UNSIGNED'", "'INT'", "'FLOAT'", "'HOST'", "'NONE'", "'+'", "'*'", "'max'", "'min'", "'or'", "'and'", "'host'", "'input'", "'output'", "'signal'", "':'", "';'", "'var'", "','", "':='", "'combine'", "'with'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalInterfaceDeclParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g"; }


     
     	private InterfaceDeclGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(InterfaceDeclGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleStateExtend
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:60:1: entryRuleStateExtend : ruleStateExtend EOF ;
    public final void entryRuleStateExtend() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:61:1: ( ruleStateExtend EOF )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:62:1: ruleStateExtend EOF
            {
             before(grammarAccess.getStateExtendRule()); 
            pushFollow(FOLLOW_ruleStateExtend_in_entryRuleStateExtend61);
            ruleStateExtend();
            _fsp--;

             after(grammarAccess.getStateExtendRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateExtend68); 

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
    // $ANTLR end entryRuleStateExtend


    // $ANTLR start ruleStateExtend
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:69:1: ruleStateExtend : ( ( ( rule__StateExtend__Alternatives ) ) ( ( rule__StateExtend__Alternatives )* ) ) ;
    public final void ruleStateExtend() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:73:2: ( ( ( ( rule__StateExtend__Alternatives ) ) ( ( rule__StateExtend__Alternatives )* ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:74:1: ( ( ( rule__StateExtend__Alternatives ) ) ( ( rule__StateExtend__Alternatives )* ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:74:1: ( ( ( rule__StateExtend__Alternatives ) ) ( ( rule__StateExtend__Alternatives )* ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:75:1: ( ( rule__StateExtend__Alternatives ) ) ( ( rule__StateExtend__Alternatives )* )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:75:1: ( ( rule__StateExtend__Alternatives ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:76:1: ( rule__StateExtend__Alternatives )
            {
             before(grammarAccess.getStateExtendAccess().getAlternatives()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:77:1: ( rule__StateExtend__Alternatives )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:77:2: rule__StateExtend__Alternatives
            {
            pushFollow(FOLLOW_rule__StateExtend__Alternatives_in_ruleStateExtend96);
            rule__StateExtend__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getStateExtendAccess().getAlternatives()); 

            }

            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:80:1: ( ( rule__StateExtend__Alternatives )* )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:81:1: ( rule__StateExtend__Alternatives )*
            {
             before(grammarAccess.getStateExtendAccess().getAlternatives()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:82:1: ( rule__StateExtend__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||(LA1_0>=25 && LA1_0<=27)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:82:2: rule__StateExtend__Alternatives
            	    {
            	    pushFollow(FOLLOW_rule__StateExtend__Alternatives_in_ruleStateExtend108);
            	    rule__StateExtend__Alternatives();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getStateExtendAccess().getAlternatives()); 

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
    // $ANTLR end ruleStateExtend


    // $ANTLR start entryRuleRegionSignalDec
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:95:1: entryRuleRegionSignalDec : ruleRegionSignalDec EOF ;
    public final void entryRuleRegionSignalDec() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:96:1: ( ruleRegionSignalDec EOF )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:97:1: ruleRegionSignalDec EOF
            {
             before(grammarAccess.getRegionSignalDecRule()); 
            pushFollow(FOLLOW_ruleRegionSignalDec_in_entryRuleRegionSignalDec138);
            ruleRegionSignalDec();
            _fsp--;

             after(grammarAccess.getRegionSignalDecRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRegionSignalDec145); 

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
    // $ANTLR end entryRuleRegionSignalDec


    // $ANTLR start ruleRegionSignalDec
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:104:1: ruleRegionSignalDec : ( ( rule__RegionSignalDec__Group__0 ) ) ;
    public final void ruleRegionSignalDec() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:108:2: ( ( ( rule__RegionSignalDec__Group__0 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:109:1: ( ( rule__RegionSignalDec__Group__0 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:109:1: ( ( rule__RegionSignalDec__Group__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:110:1: ( rule__RegionSignalDec__Group__0 )
            {
             before(grammarAccess.getRegionSignalDecAccess().getGroup()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:111:1: ( rule__RegionSignalDec__Group__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:111:2: rule__RegionSignalDec__Group__0
            {
            pushFollow(FOLLOW_rule__RegionSignalDec__Group__0_in_ruleRegionSignalDec171);
            rule__RegionSignalDec__Group__0();
            _fsp--;


            }

             after(grammarAccess.getRegionSignalDecAccess().getGroup()); 

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
    // $ANTLR end ruleRegionSignalDec


    // $ANTLR start entryRuleSignals
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:123:1: entryRuleSignals : ruleSignals EOF ;
    public final void entryRuleSignals() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:124:1: ( ruleSignals EOF )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:125:1: ruleSignals EOF
            {
             before(grammarAccess.getSignalsRule()); 
            pushFollow(FOLLOW_ruleSignals_in_entryRuleSignals198);
            ruleSignals();
            _fsp--;

             after(grammarAccess.getSignalsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignals205); 

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
    // $ANTLR end entryRuleSignals


    // $ANTLR start ruleSignals
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:132:1: ruleSignals : ( ( rule__Signals__Group__0 ) ) ;
    public final void ruleSignals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:136:2: ( ( ( rule__Signals__Group__0 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:137:1: ( ( rule__Signals__Group__0 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:137:1: ( ( rule__Signals__Group__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:138:1: ( rule__Signals__Group__0 )
            {
             before(grammarAccess.getSignalsAccess().getGroup()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:139:1: ( rule__Signals__Group__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:139:2: rule__Signals__Group__0
            {
            pushFollow(FOLLOW_rule__Signals__Group__0_in_ruleSignals231);
            rule__Signals__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSignalsAccess().getGroup()); 

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
    // $ANTLR end ruleSignals


    // $ANTLR start entryRuleInputSignals
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:151:1: entryRuleInputSignals : ruleInputSignals EOF ;
    public final void entryRuleInputSignals() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:152:1: ( ruleInputSignals EOF )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:153:1: ruleInputSignals EOF
            {
             before(grammarAccess.getInputSignalsRule()); 
            pushFollow(FOLLOW_ruleInputSignals_in_entryRuleInputSignals258);
            ruleInputSignals();
            _fsp--;

             after(grammarAccess.getInputSignalsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInputSignals265); 

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
    // $ANTLR end entryRuleInputSignals


    // $ANTLR start ruleInputSignals
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:160:1: ruleInputSignals : ( ( rule__InputSignals__Group__0 ) ) ;
    public final void ruleInputSignals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:164:2: ( ( ( rule__InputSignals__Group__0 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:165:1: ( ( rule__InputSignals__Group__0 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:165:1: ( ( rule__InputSignals__Group__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:166:1: ( rule__InputSignals__Group__0 )
            {
             before(grammarAccess.getInputSignalsAccess().getGroup()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:167:1: ( rule__InputSignals__Group__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:167:2: rule__InputSignals__Group__0
            {
            pushFollow(FOLLOW_rule__InputSignals__Group__0_in_ruleInputSignals291);
            rule__InputSignals__Group__0();
            _fsp--;


            }

             after(grammarAccess.getInputSignalsAccess().getGroup()); 

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
    // $ANTLR end ruleInputSignals


    // $ANTLR start entryRuleOutputSignals
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:179:1: entryRuleOutputSignals : ruleOutputSignals EOF ;
    public final void entryRuleOutputSignals() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:180:1: ( ruleOutputSignals EOF )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:181:1: ruleOutputSignals EOF
            {
             before(grammarAccess.getOutputSignalsRule()); 
            pushFollow(FOLLOW_ruleOutputSignals_in_entryRuleOutputSignals318);
            ruleOutputSignals();
            _fsp--;

             after(grammarAccess.getOutputSignalsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOutputSignals325); 

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
    // $ANTLR end entryRuleOutputSignals


    // $ANTLR start ruleOutputSignals
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:188:1: ruleOutputSignals : ( ( rule__OutputSignals__Group__0 ) ) ;
    public final void ruleOutputSignals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:192:2: ( ( ( rule__OutputSignals__Group__0 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:193:1: ( ( rule__OutputSignals__Group__0 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:193:1: ( ( rule__OutputSignals__Group__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:194:1: ( rule__OutputSignals__Group__0 )
            {
             before(grammarAccess.getOutputSignalsAccess().getGroup()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:195:1: ( rule__OutputSignals__Group__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:195:2: rule__OutputSignals__Group__0
            {
            pushFollow(FOLLOW_rule__OutputSignals__Group__0_in_ruleOutputSignals351);
            rule__OutputSignals__Group__0();
            _fsp--;


            }

             after(grammarAccess.getOutputSignalsAccess().getGroup()); 

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
    // $ANTLR end ruleOutputSignals


    // $ANTLR start entryRuleInOutputSignals
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:207:1: entryRuleInOutputSignals : ruleInOutputSignals EOF ;
    public final void entryRuleInOutputSignals() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:208:1: ( ruleInOutputSignals EOF )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:209:1: ruleInOutputSignals EOF
            {
             before(grammarAccess.getInOutputSignalsRule()); 
            pushFollow(FOLLOW_ruleInOutputSignals_in_entryRuleInOutputSignals378);
            ruleInOutputSignals();
            _fsp--;

             after(grammarAccess.getInOutputSignalsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInOutputSignals385); 

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
    // $ANTLR end entryRuleInOutputSignals


    // $ANTLR start ruleInOutputSignals
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:216:1: ruleInOutputSignals : ( ( rule__InOutputSignals__Group__0 ) ) ;
    public final void ruleInOutputSignals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:220:2: ( ( ( rule__InOutputSignals__Group__0 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:221:1: ( ( rule__InOutputSignals__Group__0 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:221:1: ( ( rule__InOutputSignals__Group__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:222:1: ( rule__InOutputSignals__Group__0 )
            {
             before(grammarAccess.getInOutputSignalsAccess().getGroup()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:223:1: ( rule__InOutputSignals__Group__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:223:2: rule__InOutputSignals__Group__0
            {
            pushFollow(FOLLOW_rule__InOutputSignals__Group__0_in_ruleInOutputSignals411);
            rule__InOutputSignals__Group__0();
            _fsp--;


            }

             after(grammarAccess.getInOutputSignalsAccess().getGroup()); 

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
    // $ANTLR end ruleInOutputSignals


    // $ANTLR start entryRuleSignal
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:235:1: entryRuleSignal : ruleSignal EOF ;
    public final void entryRuleSignal() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:236:1: ( ruleSignal EOF )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:237:1: ruleSignal EOF
            {
             before(grammarAccess.getSignalRule()); 
            pushFollow(FOLLOW_ruleSignal_in_entryRuleSignal438);
            ruleSignal();
            _fsp--;

             after(grammarAccess.getSignalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignal445); 

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
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:244:1: ruleSignal : ( ( rule__Signal__Alternatives ) ) ;
    public final void ruleSignal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:248:2: ( ( ( rule__Signal__Alternatives ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:249:1: ( ( rule__Signal__Alternatives ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:249:1: ( ( rule__Signal__Alternatives ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:250:1: ( rule__Signal__Alternatives )
            {
             before(grammarAccess.getSignalAccess().getAlternatives()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:251:1: ( rule__Signal__Alternatives )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:251:2: rule__Signal__Alternatives
            {
            pushFollow(FOLLOW_rule__Signal__Alternatives_in_ruleSignal471);
            rule__Signal__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getAlternatives()); 

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


    // $ANTLR start entryRuleVariable
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:263:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:264:1: ( ruleVariable EOF )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:265:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable498);
            ruleVariable();
            _fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable505); 

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
    // $ANTLR end entryRuleVariable


    // $ANTLR start ruleVariable
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:272:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:276:2: ( ( ( rule__Variable__Group__0 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:277:1: ( ( rule__Variable__Group__0 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:277:1: ( ( rule__Variable__Group__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:278:1: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:279:1: ( rule__Variable__Group__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:279:2: rule__Variable__Group__0
            {
            pushFollow(FOLLOW_rule__Variable__Group__0_in_ruleVariable531);
            rule__Variable__Group__0();
            _fsp--;


            }

             after(grammarAccess.getVariableAccess().getGroup()); 

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
    // $ANTLR end ruleVariable


    // $ANTLR start ruleValueType
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:292:1: ruleValueType : ( ( rule__ValueType__Alternatives ) ) ;
    public final void ruleValueType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:296:1: ( ( ( rule__ValueType__Alternatives ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:297:1: ( ( rule__ValueType__Alternatives ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:297:1: ( ( rule__ValueType__Alternatives ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:298:1: ( rule__ValueType__Alternatives )
            {
             before(grammarAccess.getValueTypeAccess().getAlternatives()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:299:1: ( rule__ValueType__Alternatives )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:299:2: rule__ValueType__Alternatives
            {
            pushFollow(FOLLOW_rule__ValueType__Alternatives_in_ruleValueType568);
            rule__ValueType__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getValueTypeAccess().getAlternatives()); 

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
    // $ANTLR end ruleValueType


    // $ANTLR start ruleCombineOperator
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:311:1: ruleCombineOperator : ( ( rule__CombineOperator__Alternatives ) ) ;
    public final void ruleCombineOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:315:1: ( ( ( rule__CombineOperator__Alternatives ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:316:1: ( ( rule__CombineOperator__Alternatives ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:316:1: ( ( rule__CombineOperator__Alternatives ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:317:1: ( rule__CombineOperator__Alternatives )
            {
             before(grammarAccess.getCombineOperatorAccess().getAlternatives()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:318:1: ( rule__CombineOperator__Alternatives )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:318:2: rule__CombineOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__CombineOperator__Alternatives_in_ruleCombineOperator604);
            rule__CombineOperator__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getCombineOperatorAccess().getAlternatives()); 

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
    // $ANTLR end ruleCombineOperator


    // $ANTLR start rule__StateExtend__Alternatives
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:329:1: rule__StateExtend__Alternatives : ( ( ( rule__StateExtend__RegionsAssignment_0 ) ) | ( ( rule__StateExtend__Group_1__0 ) ) | ( ( rule__StateExtend__Group_2__0 ) ) | ( ( rule__StateExtend__Group_3__0 ) ) | ( ( rule__StateExtend__Group_4__0 ) ) );
    public final void rule__StateExtend__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:333:1: ( ( ( rule__StateExtend__RegionsAssignment_0 ) ) | ( ( rule__StateExtend__Group_1__0 ) ) | ( ( rule__StateExtend__Group_2__0 ) ) | ( ( rule__StateExtend__Group_3__0 ) ) | ( ( rule__StateExtend__Group_4__0 ) ) )
            int alt2=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt2=1;
                }
                break;
            case 25:
                {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==RULE_ID) ) {
                    alt2=4;
                }
                else if ( (LA2_2==26) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("329:1: rule__StateExtend__Alternatives : ( ( ( rule__StateExtend__RegionsAssignment_0 ) ) | ( ( rule__StateExtend__Group_1__0 ) ) | ( ( rule__StateExtend__Group_2__0 ) ) | ( ( rule__StateExtend__Group_3__0 ) ) | ( ( rule__StateExtend__Group_4__0 ) ) );", 2, 2, input);

                    throw nvae;
                }
                }
                break;
            case 26:
                {
                alt2=3;
                }
                break;
            case 27:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("329:1: rule__StateExtend__Alternatives : ( ( ( rule__StateExtend__RegionsAssignment_0 ) ) | ( ( rule__StateExtend__Group_1__0 ) ) | ( ( rule__StateExtend__Group_2__0 ) ) | ( ( rule__StateExtend__Group_3__0 ) ) | ( ( rule__StateExtend__Group_4__0 ) ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:334:1: ( ( rule__StateExtend__RegionsAssignment_0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:334:1: ( ( rule__StateExtend__RegionsAssignment_0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:335:1: ( rule__StateExtend__RegionsAssignment_0 )
                    {
                     before(grammarAccess.getStateExtendAccess().getRegionsAssignment_0()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:336:1: ( rule__StateExtend__RegionsAssignment_0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:336:2: rule__StateExtend__RegionsAssignment_0
                    {
                    pushFollow(FOLLOW_rule__StateExtend__RegionsAssignment_0_in_rule__StateExtend__Alternatives639);
                    rule__StateExtend__RegionsAssignment_0();
                    _fsp--;


                    }

                     after(grammarAccess.getStateExtendAccess().getRegionsAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:340:6: ( ( rule__StateExtend__Group_1__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:340:6: ( ( rule__StateExtend__Group_1__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:341:1: ( rule__StateExtend__Group_1__0 )
                    {
                     before(grammarAccess.getStateExtendAccess().getGroup_1()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:342:1: ( rule__StateExtend__Group_1__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:342:2: rule__StateExtend__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__StateExtend__Group_1__0_in_rule__StateExtend__Alternatives657);
                    rule__StateExtend__Group_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getStateExtendAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:346:6: ( ( rule__StateExtend__Group_2__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:346:6: ( ( rule__StateExtend__Group_2__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:347:1: ( rule__StateExtend__Group_2__0 )
                    {
                     before(grammarAccess.getStateExtendAccess().getGroup_2()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:348:1: ( rule__StateExtend__Group_2__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:348:2: rule__StateExtend__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__StateExtend__Group_2__0_in_rule__StateExtend__Alternatives675);
                    rule__StateExtend__Group_2__0();
                    _fsp--;


                    }

                     after(grammarAccess.getStateExtendAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:352:6: ( ( rule__StateExtend__Group_3__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:352:6: ( ( rule__StateExtend__Group_3__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:353:1: ( rule__StateExtend__Group_3__0 )
                    {
                     before(grammarAccess.getStateExtendAccess().getGroup_3()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:354:1: ( rule__StateExtend__Group_3__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:354:2: rule__StateExtend__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__StateExtend__Group_3__0_in_rule__StateExtend__Alternatives693);
                    rule__StateExtend__Group_3__0();
                    _fsp--;


                    }

                     after(grammarAccess.getStateExtendAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:358:6: ( ( rule__StateExtend__Group_4__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:358:6: ( ( rule__StateExtend__Group_4__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:359:1: ( rule__StateExtend__Group_4__0 )
                    {
                     before(grammarAccess.getStateExtendAccess().getGroup_4()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:360:1: ( rule__StateExtend__Group_4__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:360:2: rule__StateExtend__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__StateExtend__Group_4__0_in_rule__StateExtend__Alternatives711);
                    rule__StateExtend__Group_4__0();
                    _fsp--;


                    }

                     after(grammarAccess.getStateExtendAccess().getGroup_4()); 

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
    // $ANTLR end rule__StateExtend__Alternatives


    // $ANTLR start rule__RegionSignalDec__Alternatives_2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:369:1: rule__RegionSignalDec__Alternatives_2 : ( ( ( rule__RegionSignalDec__Group_2_0__0 ) ) | ( ( rule__RegionSignalDec__Group_2_1__0 ) ) );
    public final void rule__RegionSignalDec__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:373:1: ( ( ( rule__RegionSignalDec__Group_2_0__0 ) ) | ( ( rule__RegionSignalDec__Group_2_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==30) ) {
                alt3=1;
            }
            else if ( (LA3_0==27) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("369:1: rule__RegionSignalDec__Alternatives_2 : ( ( ( rule__RegionSignalDec__Group_2_0__0 ) ) | ( ( rule__RegionSignalDec__Group_2_1__0 ) ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:374:1: ( ( rule__RegionSignalDec__Group_2_0__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:374:1: ( ( rule__RegionSignalDec__Group_2_0__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:375:1: ( rule__RegionSignalDec__Group_2_0__0 )
                    {
                     before(grammarAccess.getRegionSignalDecAccess().getGroup_2_0()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:376:1: ( rule__RegionSignalDec__Group_2_0__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:376:2: rule__RegionSignalDec__Group_2_0__0
                    {
                    pushFollow(FOLLOW_rule__RegionSignalDec__Group_2_0__0_in_rule__RegionSignalDec__Alternatives_2744);
                    rule__RegionSignalDec__Group_2_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getRegionSignalDecAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:380:6: ( ( rule__RegionSignalDec__Group_2_1__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:380:6: ( ( rule__RegionSignalDec__Group_2_1__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:381:1: ( rule__RegionSignalDec__Group_2_1__0 )
                    {
                     before(grammarAccess.getRegionSignalDecAccess().getGroup_2_1()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:382:1: ( rule__RegionSignalDec__Group_2_1__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:382:2: rule__RegionSignalDec__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__RegionSignalDec__Group_2_1__0_in_rule__RegionSignalDec__Alternatives_2762);
                    rule__RegionSignalDec__Group_2_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getRegionSignalDecAccess().getGroup_2_1()); 

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
    // $ANTLR end rule__RegionSignalDec__Alternatives_2


    // $ANTLR start rule__RegionSignalDec__Alternatives_3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:391:1: rule__RegionSignalDec__Alternatives_3 : ( ( ( rule__RegionSignalDec__Group_3_0__0 ) ) | ( ( rule__RegionSignalDec__Group_3_1__0 ) ) );
    public final void rule__RegionSignalDec__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:395:1: ( ( ( rule__RegionSignalDec__Group_3_0__0 ) ) | ( ( rule__RegionSignalDec__Group_3_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==31) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==27) ) {
                    alt4=2;
                }
                else if ( (LA4_1==30) ) {
                    alt4=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("391:1: rule__RegionSignalDec__Alternatives_3 : ( ( ( rule__RegionSignalDec__Group_3_0__0 ) ) | ( ( rule__RegionSignalDec__Group_3_1__0 ) ) );", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("391:1: rule__RegionSignalDec__Alternatives_3 : ( ( ( rule__RegionSignalDec__Group_3_0__0 ) ) | ( ( rule__RegionSignalDec__Group_3_1__0 ) ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:396:1: ( ( rule__RegionSignalDec__Group_3_0__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:396:1: ( ( rule__RegionSignalDec__Group_3_0__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:397:1: ( rule__RegionSignalDec__Group_3_0__0 )
                    {
                     before(grammarAccess.getRegionSignalDecAccess().getGroup_3_0()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:398:1: ( rule__RegionSignalDec__Group_3_0__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:398:2: rule__RegionSignalDec__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__RegionSignalDec__Group_3_0__0_in_rule__RegionSignalDec__Alternatives_3795);
                    rule__RegionSignalDec__Group_3_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getRegionSignalDecAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:402:6: ( ( rule__RegionSignalDec__Group_3_1__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:402:6: ( ( rule__RegionSignalDec__Group_3_1__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:403:1: ( rule__RegionSignalDec__Group_3_1__0 )
                    {
                     before(grammarAccess.getRegionSignalDecAccess().getGroup_3_1()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:404:1: ( rule__RegionSignalDec__Group_3_1__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:404:2: rule__RegionSignalDec__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__RegionSignalDec__Group_3_1__0_in_rule__RegionSignalDec__Alternatives_3813);
                    rule__RegionSignalDec__Group_3_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getRegionSignalDecAccess().getGroup_3_1()); 

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
    // $ANTLR end rule__RegionSignalDec__Alternatives_3


    // $ANTLR start rule__Signal__Alternatives
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:413:1: rule__Signal__Alternatives : ( ( ( rule__Signal__NameAssignment_0 ) ) | ( ( rule__Signal__Group_1__0 ) ) | ( ( rule__Signal__Group_2__0 ) ) | ( ( rule__Signal__Group_3__0 ) ) | ( ( rule__Signal__Group_4__0 ) ) | ( ( rule__Signal__Group_5__0 ) ) | ( ( rule__Signal__Group_6__0 ) ) | ( ( rule__Signal__Group_7__0 ) ) | ( ( rule__Signal__Group_8__0 ) ) | ( ( rule__Signal__Group_9__0 ) ) );
    public final void rule__Signal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:417:1: ( ( ( rule__Signal__NameAssignment_0 ) ) | ( ( rule__Signal__Group_1__0 ) ) | ( ( rule__Signal__Group_2__0 ) ) | ( ( rule__Signal__Group_3__0 ) ) | ( ( rule__Signal__Group_4__0 ) ) | ( ( rule__Signal__Group_5__0 ) ) | ( ( rule__Signal__Group_6__0 ) ) | ( ( rule__Signal__Group_7__0 ) ) | ( ( rule__Signal__Group_8__0 ) ) | ( ( rule__Signal__Group_9__0 ) ) )
            int alt5=10;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 28:
                    {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==RULE_STRING) ) {
                        alt5=6;
                    }
                    else if ( ((LA5_2>=11 && LA5_2<=16)) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("413:1: rule__Signal__Alternatives : ( ( ( rule__Signal__NameAssignment_0 ) ) | ( ( rule__Signal__Group_1__0 ) ) | ( ( rule__Signal__Group_2__0 ) ) | ( ( rule__Signal__Group_3__0 ) ) | ( ( rule__Signal__Group_4__0 ) ) | ( ( rule__Signal__Group_5__0 ) ) | ( ( rule__Signal__Group_6__0 ) ) | ( ( rule__Signal__Group_7__0 ) ) | ( ( rule__Signal__Group_8__0 ) ) | ( ( rule__Signal__Group_9__0 ) ) );", 5, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case 32:
                    {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==RULE_STRING) ) {
                        switch ( input.LA(4) ) {
                        case EOF:
                        case 29:
                        case 31:
                            {
                            alt5=3;
                            }
                            break;
                        case 28:
                            {
                            int LA5_12 = input.LA(5);

                            if ( ((LA5_12>=11 && LA5_12<=16)) ) {
                                alt5=4;
                            }
                            else if ( (LA5_12==RULE_STRING) ) {
                                alt5=7;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("413:1: rule__Signal__Alternatives : ( ( ( rule__Signal__NameAssignment_0 ) ) | ( ( rule__Signal__Group_1__0 ) ) | ( ( rule__Signal__Group_2__0 ) ) | ( ( rule__Signal__Group_3__0 ) ) | ( ( rule__Signal__Group_4__0 ) ) | ( ( rule__Signal__Group_5__0 ) ) | ( ( rule__Signal__Group_6__0 ) ) | ( ( rule__Signal__Group_7__0 ) ) | ( ( rule__Signal__Group_8__0 ) ) | ( ( rule__Signal__Group_9__0 ) ) );", 5, 12, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 33:
                            {
                            int LA5_13 = input.LA(5);

                            if ( (LA5_13==RULE_STRING) ) {
                                alt5=8;
                            }
                            else if ( ((LA5_13>=11 && LA5_13<=16)) ) {
                                alt5=5;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("413:1: rule__Signal__Alternatives : ( ( ( rule__Signal__NameAssignment_0 ) ) | ( ( rule__Signal__Group_1__0 ) ) | ( ( rule__Signal__Group_2__0 ) ) | ( ( rule__Signal__Group_3__0 ) ) | ( ( rule__Signal__Group_4__0 ) ) | ( ( rule__Signal__Group_5__0 ) ) | ( ( rule__Signal__Group_6__0 ) ) | ( ( rule__Signal__Group_7__0 ) ) | ( ( rule__Signal__Group_8__0 ) ) | ( ( rule__Signal__Group_9__0 ) ) );", 5, 13, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("413:1: rule__Signal__Alternatives : ( ( ( rule__Signal__NameAssignment_0 ) ) | ( ( rule__Signal__Group_1__0 ) ) | ( ( rule__Signal__Group_2__0 ) ) | ( ( rule__Signal__Group_3__0 ) ) | ( ( rule__Signal__Group_4__0 ) ) | ( ( rule__Signal__Group_5__0 ) ) | ( ( rule__Signal__Group_6__0 ) ) | ( ( rule__Signal__Group_7__0 ) ) | ( ( rule__Signal__Group_8__0 ) ) | ( ( rule__Signal__Group_9__0 ) ) );", 5, 8, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("413:1: rule__Signal__Alternatives : ( ( ( rule__Signal__NameAssignment_0 ) ) | ( ( rule__Signal__Group_1__0 ) ) | ( ( rule__Signal__Group_2__0 ) ) | ( ( rule__Signal__Group_3__0 ) ) | ( ( rule__Signal__Group_4__0 ) ) | ( ( rule__Signal__Group_5__0 ) ) | ( ( rule__Signal__Group_6__0 ) ) | ( ( rule__Signal__Group_7__0 ) ) | ( ( rule__Signal__Group_8__0 ) ) | ( ( rule__Signal__Group_9__0 ) ) );", 5, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 33:
                    {
                    int LA5_4 = input.LA(3);

                    if ( ((LA5_4>=11 && LA5_4<=16)) ) {
                        alt5=9;
                    }
                    else if ( (LA5_4==RULE_STRING) ) {
                        alt5=10;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("413:1: rule__Signal__Alternatives : ( ( ( rule__Signal__NameAssignment_0 ) ) | ( ( rule__Signal__Group_1__0 ) ) | ( ( rule__Signal__Group_2__0 ) ) | ( ( rule__Signal__Group_3__0 ) ) | ( ( rule__Signal__Group_4__0 ) ) | ( ( rule__Signal__Group_5__0 ) ) | ( ( rule__Signal__Group_6__0 ) ) | ( ( rule__Signal__Group_7__0 ) ) | ( ( rule__Signal__Group_8__0 ) ) | ( ( rule__Signal__Group_9__0 ) ) );", 5, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case EOF:
                case 29:
                case 31:
                    {
                    alt5=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("413:1: rule__Signal__Alternatives : ( ( ( rule__Signal__NameAssignment_0 ) ) | ( ( rule__Signal__Group_1__0 ) ) | ( ( rule__Signal__Group_2__0 ) ) | ( ( rule__Signal__Group_3__0 ) ) | ( ( rule__Signal__Group_4__0 ) ) | ( ( rule__Signal__Group_5__0 ) ) | ( ( rule__Signal__Group_6__0 ) ) | ( ( rule__Signal__Group_7__0 ) ) | ( ( rule__Signal__Group_8__0 ) ) | ( ( rule__Signal__Group_9__0 ) ) );", 5, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("413:1: rule__Signal__Alternatives : ( ( ( rule__Signal__NameAssignment_0 ) ) | ( ( rule__Signal__Group_1__0 ) ) | ( ( rule__Signal__Group_2__0 ) ) | ( ( rule__Signal__Group_3__0 ) ) | ( ( rule__Signal__Group_4__0 ) ) | ( ( rule__Signal__Group_5__0 ) ) | ( ( rule__Signal__Group_6__0 ) ) | ( ( rule__Signal__Group_7__0 ) ) | ( ( rule__Signal__Group_8__0 ) ) | ( ( rule__Signal__Group_9__0 ) ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:418:1: ( ( rule__Signal__NameAssignment_0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:418:1: ( ( rule__Signal__NameAssignment_0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:419:1: ( rule__Signal__NameAssignment_0 )
                    {
                     before(grammarAccess.getSignalAccess().getNameAssignment_0()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:420:1: ( rule__Signal__NameAssignment_0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:420:2: rule__Signal__NameAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Signal__NameAssignment_0_in_rule__Signal__Alternatives846);
                    rule__Signal__NameAssignment_0();
                    _fsp--;


                    }

                     after(grammarAccess.getSignalAccess().getNameAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:424:6: ( ( rule__Signal__Group_1__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:424:6: ( ( rule__Signal__Group_1__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:425:1: ( rule__Signal__Group_1__0 )
                    {
                     before(grammarAccess.getSignalAccess().getGroup_1()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:426:1: ( rule__Signal__Group_1__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:426:2: rule__Signal__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Signal__Group_1__0_in_rule__Signal__Alternatives864);
                    rule__Signal__Group_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getSignalAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:430:6: ( ( rule__Signal__Group_2__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:430:6: ( ( rule__Signal__Group_2__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:431:1: ( rule__Signal__Group_2__0 )
                    {
                     before(grammarAccess.getSignalAccess().getGroup_2()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:432:1: ( rule__Signal__Group_2__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:432:2: rule__Signal__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Signal__Group_2__0_in_rule__Signal__Alternatives882);
                    rule__Signal__Group_2__0();
                    _fsp--;


                    }

                     after(grammarAccess.getSignalAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:436:6: ( ( rule__Signal__Group_3__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:436:6: ( ( rule__Signal__Group_3__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:437:1: ( rule__Signal__Group_3__0 )
                    {
                     before(grammarAccess.getSignalAccess().getGroup_3()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:438:1: ( rule__Signal__Group_3__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:438:2: rule__Signal__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Signal__Group_3__0_in_rule__Signal__Alternatives900);
                    rule__Signal__Group_3__0();
                    _fsp--;


                    }

                     after(grammarAccess.getSignalAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:442:6: ( ( rule__Signal__Group_4__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:442:6: ( ( rule__Signal__Group_4__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:443:1: ( rule__Signal__Group_4__0 )
                    {
                     before(grammarAccess.getSignalAccess().getGroup_4()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:444:1: ( rule__Signal__Group_4__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:444:2: rule__Signal__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Signal__Group_4__0_in_rule__Signal__Alternatives918);
                    rule__Signal__Group_4__0();
                    _fsp--;


                    }

                     after(grammarAccess.getSignalAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:448:6: ( ( rule__Signal__Group_5__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:448:6: ( ( rule__Signal__Group_5__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:449:1: ( rule__Signal__Group_5__0 )
                    {
                     before(grammarAccess.getSignalAccess().getGroup_5()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:450:1: ( rule__Signal__Group_5__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:450:2: rule__Signal__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Signal__Group_5__0_in_rule__Signal__Alternatives936);
                    rule__Signal__Group_5__0();
                    _fsp--;


                    }

                     after(grammarAccess.getSignalAccess().getGroup_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:454:6: ( ( rule__Signal__Group_6__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:454:6: ( ( rule__Signal__Group_6__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:455:1: ( rule__Signal__Group_6__0 )
                    {
                     before(grammarAccess.getSignalAccess().getGroup_6()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:456:1: ( rule__Signal__Group_6__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:456:2: rule__Signal__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__Signal__Group_6__0_in_rule__Signal__Alternatives954);
                    rule__Signal__Group_6__0();
                    _fsp--;


                    }

                     after(grammarAccess.getSignalAccess().getGroup_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:460:6: ( ( rule__Signal__Group_7__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:460:6: ( ( rule__Signal__Group_7__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:461:1: ( rule__Signal__Group_7__0 )
                    {
                     before(grammarAccess.getSignalAccess().getGroup_7()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:462:1: ( rule__Signal__Group_7__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:462:2: rule__Signal__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__Signal__Group_7__0_in_rule__Signal__Alternatives972);
                    rule__Signal__Group_7__0();
                    _fsp--;


                    }

                     after(grammarAccess.getSignalAccess().getGroup_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:466:6: ( ( rule__Signal__Group_8__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:466:6: ( ( rule__Signal__Group_8__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:467:1: ( rule__Signal__Group_8__0 )
                    {
                     before(grammarAccess.getSignalAccess().getGroup_8()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:468:1: ( rule__Signal__Group_8__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:468:2: rule__Signal__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__Signal__Group_8__0_in_rule__Signal__Alternatives990);
                    rule__Signal__Group_8__0();
                    _fsp--;


                    }

                     after(grammarAccess.getSignalAccess().getGroup_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:472:6: ( ( rule__Signal__Group_9__0 ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:472:6: ( ( rule__Signal__Group_9__0 ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:473:1: ( rule__Signal__Group_9__0 )
                    {
                     before(grammarAccess.getSignalAccess().getGroup_9()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:474:1: ( rule__Signal__Group_9__0 )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:474:2: rule__Signal__Group_9__0
                    {
                    pushFollow(FOLLOW_rule__Signal__Group_9__0_in_rule__Signal__Alternatives1008);
                    rule__Signal__Group_9__0();
                    _fsp--;


                    }

                     after(grammarAccess.getSignalAccess().getGroup_9()); 

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
    // $ANTLR end rule__Signal__Alternatives


    // $ANTLR start rule__ValueType__Alternatives
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:483:1: rule__ValueType__Alternatives : ( ( ( 'PURE' ) ) | ( ( 'BOOL' ) ) | ( ( 'UNSIGNED' ) ) | ( ( 'INT' ) ) | ( ( 'FLOAT' ) ) | ( ( 'HOST' ) ) );
    public final void rule__ValueType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:487:1: ( ( ( 'PURE' ) ) | ( ( 'BOOL' ) ) | ( ( 'UNSIGNED' ) ) | ( ( 'INT' ) ) | ( ( 'FLOAT' ) ) | ( ( 'HOST' ) ) )
            int alt6=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt6=1;
                }
                break;
            case 12:
                {
                alt6=2;
                }
                break;
            case 13:
                {
                alt6=3;
                }
                break;
            case 14:
                {
                alt6=4;
                }
                break;
            case 15:
                {
                alt6=5;
                }
                break;
            case 16:
                {
                alt6=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("483:1: rule__ValueType__Alternatives : ( ( ( 'PURE' ) ) | ( ( 'BOOL' ) ) | ( ( 'UNSIGNED' ) ) | ( ( 'INT' ) ) | ( ( 'FLOAT' ) ) | ( ( 'HOST' ) ) );", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:488:1: ( ( 'PURE' ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:488:1: ( ( 'PURE' ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:489:1: ( 'PURE' )
                    {
                     before(grammarAccess.getValueTypeAccess().getPUREEnumLiteralDeclaration_0()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:490:1: ( 'PURE' )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:490:3: 'PURE'
                    {
                    match(input,11,FOLLOW_11_in_rule__ValueType__Alternatives1042); 

                    }

                     after(grammarAccess.getValueTypeAccess().getPUREEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:495:6: ( ( 'BOOL' ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:495:6: ( ( 'BOOL' ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:496:1: ( 'BOOL' )
                    {
                     before(grammarAccess.getValueTypeAccess().getBOOLEnumLiteralDeclaration_1()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:497:1: ( 'BOOL' )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:497:3: 'BOOL'
                    {
                    match(input,12,FOLLOW_12_in_rule__ValueType__Alternatives1063); 

                    }

                     after(grammarAccess.getValueTypeAccess().getBOOLEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:502:6: ( ( 'UNSIGNED' ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:502:6: ( ( 'UNSIGNED' ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:503:1: ( 'UNSIGNED' )
                    {
                     before(grammarAccess.getValueTypeAccess().getUNSIGNEDEnumLiteralDeclaration_2()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:504:1: ( 'UNSIGNED' )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:504:3: 'UNSIGNED'
                    {
                    match(input,13,FOLLOW_13_in_rule__ValueType__Alternatives1084); 

                    }

                     after(grammarAccess.getValueTypeAccess().getUNSIGNEDEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:509:6: ( ( 'INT' ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:509:6: ( ( 'INT' ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:510:1: ( 'INT' )
                    {
                     before(grammarAccess.getValueTypeAccess().getINTEGEREnumLiteralDeclaration_3()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:511:1: ( 'INT' )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:511:3: 'INT'
                    {
                    match(input,14,FOLLOW_14_in_rule__ValueType__Alternatives1105); 

                    }

                     after(grammarAccess.getValueTypeAccess().getINTEGEREnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:516:6: ( ( 'FLOAT' ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:516:6: ( ( 'FLOAT' ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:517:1: ( 'FLOAT' )
                    {
                     before(grammarAccess.getValueTypeAccess().getFLOATEnumLiteralDeclaration_4()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:518:1: ( 'FLOAT' )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:518:3: 'FLOAT'
                    {
                    match(input,15,FOLLOW_15_in_rule__ValueType__Alternatives1126); 

                    }

                     after(grammarAccess.getValueTypeAccess().getFLOATEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:523:6: ( ( 'HOST' ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:523:6: ( ( 'HOST' ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:524:1: ( 'HOST' )
                    {
                     before(grammarAccess.getValueTypeAccess().getHOSTEnumLiteralDeclaration_5()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:525:1: ( 'HOST' )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:525:3: 'HOST'
                    {
                    match(input,16,FOLLOW_16_in_rule__ValueType__Alternatives1147); 

                    }

                     after(grammarAccess.getValueTypeAccess().getHOSTEnumLiteralDeclaration_5()); 

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
    // $ANTLR end rule__ValueType__Alternatives


    // $ANTLR start rule__CombineOperator__Alternatives
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:535:1: rule__CombineOperator__Alternatives : ( ( ( 'NONE' ) ) | ( ( '+' ) ) | ( ( '*' ) ) | ( ( 'max' ) ) | ( ( 'min' ) ) | ( ( 'or' ) ) | ( ( 'and' ) ) | ( ( 'host' ) ) );
    public final void rule__CombineOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:539:1: ( ( ( 'NONE' ) ) | ( ( '+' ) ) | ( ( '*' ) ) | ( ( 'max' ) ) | ( ( 'min' ) ) | ( ( 'or' ) ) | ( ( 'and' ) ) | ( ( 'host' ) ) )
            int alt7=8;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt7=1;
                }
                break;
            case 18:
                {
                alt7=2;
                }
                break;
            case 19:
                {
                alt7=3;
                }
                break;
            case 20:
                {
                alt7=4;
                }
                break;
            case 21:
                {
                alt7=5;
                }
                break;
            case 22:
                {
                alt7=6;
                }
                break;
            case 23:
                {
                alt7=7;
                }
                break;
            case 24:
                {
                alt7=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("535:1: rule__CombineOperator__Alternatives : ( ( ( 'NONE' ) ) | ( ( '+' ) ) | ( ( '*' ) ) | ( ( 'max' ) ) | ( ( 'min' ) ) | ( ( 'or' ) ) | ( ( 'and' ) ) | ( ( 'host' ) ) );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:540:1: ( ( 'NONE' ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:540:1: ( ( 'NONE' ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:541:1: ( 'NONE' )
                    {
                     before(grammarAccess.getCombineOperatorAccess().getNONEEnumLiteralDeclaration_0()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:542:1: ( 'NONE' )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:542:3: 'NONE'
                    {
                    match(input,17,FOLLOW_17_in_rule__CombineOperator__Alternatives1183); 

                    }

                     after(grammarAccess.getCombineOperatorAccess().getNONEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:547:6: ( ( '+' ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:547:6: ( ( '+' ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:548:1: ( '+' )
                    {
                     before(grammarAccess.getCombineOperatorAccess().getADDEnumLiteralDeclaration_1()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:549:1: ( '+' )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:549:3: '+'
                    {
                    match(input,18,FOLLOW_18_in_rule__CombineOperator__Alternatives1204); 

                    }

                     after(grammarAccess.getCombineOperatorAccess().getADDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:554:6: ( ( '*' ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:554:6: ( ( '*' ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:555:1: ( '*' )
                    {
                     before(grammarAccess.getCombineOperatorAccess().getMULTEnumLiteralDeclaration_2()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:556:1: ( '*' )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:556:3: '*'
                    {
                    match(input,19,FOLLOW_19_in_rule__CombineOperator__Alternatives1225); 

                    }

                     after(grammarAccess.getCombineOperatorAccess().getMULTEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:561:6: ( ( 'max' ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:561:6: ( ( 'max' ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:562:1: ( 'max' )
                    {
                     before(grammarAccess.getCombineOperatorAccess().getMAXEnumLiteralDeclaration_3()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:563:1: ( 'max' )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:563:3: 'max'
                    {
                    match(input,20,FOLLOW_20_in_rule__CombineOperator__Alternatives1246); 

                    }

                     after(grammarAccess.getCombineOperatorAccess().getMAXEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:568:6: ( ( 'min' ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:568:6: ( ( 'min' ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:569:1: ( 'min' )
                    {
                     before(grammarAccess.getCombineOperatorAccess().getMINEnumLiteralDeclaration_4()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:570:1: ( 'min' )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:570:3: 'min'
                    {
                    match(input,21,FOLLOW_21_in_rule__CombineOperator__Alternatives1267); 

                    }

                     after(grammarAccess.getCombineOperatorAccess().getMINEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:575:6: ( ( 'or' ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:575:6: ( ( 'or' ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:576:1: ( 'or' )
                    {
                     before(grammarAccess.getCombineOperatorAccess().getOREnumLiteralDeclaration_5()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:577:1: ( 'or' )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:577:3: 'or'
                    {
                    match(input,22,FOLLOW_22_in_rule__CombineOperator__Alternatives1288); 

                    }

                     after(grammarAccess.getCombineOperatorAccess().getOREnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:582:6: ( ( 'and' ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:582:6: ( ( 'and' ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:583:1: ( 'and' )
                    {
                     before(grammarAccess.getCombineOperatorAccess().getANDEnumLiteralDeclaration_6()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:584:1: ( 'and' )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:584:3: 'and'
                    {
                    match(input,23,FOLLOW_23_in_rule__CombineOperator__Alternatives1309); 

                    }

                     after(grammarAccess.getCombineOperatorAccess().getANDEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:589:6: ( ( 'host' ) )
                    {
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:589:6: ( ( 'host' ) )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:590:1: ( 'host' )
                    {
                     before(grammarAccess.getCombineOperatorAccess().getHOSTEnumLiteralDeclaration_7()); 
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:591:1: ( 'host' )
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:591:3: 'host'
                    {
                    match(input,24,FOLLOW_24_in_rule__CombineOperator__Alternatives1330); 

                    }

                     after(grammarAccess.getCombineOperatorAccess().getHOSTEnumLiteralDeclaration_7()); 

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
    // $ANTLR end rule__CombineOperator__Alternatives


    // $ANTLR start rule__StateExtend__Group_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:603:1: rule__StateExtend__Group_1__0 : ( 'input' ) rule__StateExtend__Group_1__1 ;
    public final void rule__StateExtend__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:607:1: ( ( 'input' ) rule__StateExtend__Group_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:608:1: ( 'input' ) rule__StateExtend__Group_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:608:1: ( 'input' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:609:1: 'input'
            {
             before(grammarAccess.getStateExtendAccess().getInputKeyword_1_0()); 
            match(input,25,FOLLOW_25_in_rule__StateExtend__Group_1__01368); 
             after(grammarAccess.getStateExtendAccess().getInputKeyword_1_0()); 

            }

            pushFollow(FOLLOW_rule__StateExtend__Group_1__1_in_rule__StateExtend__Group_1__01378);
            rule__StateExtend__Group_1__1();
            _fsp--;


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
    // $ANTLR end rule__StateExtend__Group_1__0


    // $ANTLR start rule__StateExtend__Group_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:623:1: rule__StateExtend__Group_1__1 : ( 'output' ) rule__StateExtend__Group_1__2 ;
    public final void rule__StateExtend__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:627:1: ( ( 'output' ) rule__StateExtend__Group_1__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:628:1: ( 'output' ) rule__StateExtend__Group_1__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:628:1: ( 'output' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:629:1: 'output'
            {
             before(grammarAccess.getStateExtendAccess().getOutputKeyword_1_1()); 
            match(input,26,FOLLOW_26_in_rule__StateExtend__Group_1__11407); 
             after(grammarAccess.getStateExtendAccess().getOutputKeyword_1_1()); 

            }

            pushFollow(FOLLOW_rule__StateExtend__Group_1__2_in_rule__StateExtend__Group_1__11417);
            rule__StateExtend__Group_1__2();
            _fsp--;


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
    // $ANTLR end rule__StateExtend__Group_1__1


    // $ANTLR start rule__StateExtend__Group_1__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:643:1: rule__StateExtend__Group_1__2 : ( ( rule__StateExtend__InOutputSignalsAssignment_1_2 ) ) ;
    public final void rule__StateExtend__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:647:1: ( ( ( rule__StateExtend__InOutputSignalsAssignment_1_2 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:648:1: ( ( rule__StateExtend__InOutputSignalsAssignment_1_2 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:648:1: ( ( rule__StateExtend__InOutputSignalsAssignment_1_2 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:649:1: ( rule__StateExtend__InOutputSignalsAssignment_1_2 )
            {
             before(grammarAccess.getStateExtendAccess().getInOutputSignalsAssignment_1_2()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:650:1: ( rule__StateExtend__InOutputSignalsAssignment_1_2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:650:2: rule__StateExtend__InOutputSignalsAssignment_1_2
            {
            pushFollow(FOLLOW_rule__StateExtend__InOutputSignalsAssignment_1_2_in_rule__StateExtend__Group_1__21445);
            rule__StateExtend__InOutputSignalsAssignment_1_2();
            _fsp--;


            }

             after(grammarAccess.getStateExtendAccess().getInOutputSignalsAssignment_1_2()); 

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
    // $ANTLR end rule__StateExtend__Group_1__2


    // $ANTLR start rule__StateExtend__Group_2__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:666:1: rule__StateExtend__Group_2__0 : ( 'output' ) rule__StateExtend__Group_2__1 ;
    public final void rule__StateExtend__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:670:1: ( ( 'output' ) rule__StateExtend__Group_2__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:671:1: ( 'output' ) rule__StateExtend__Group_2__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:671:1: ( 'output' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:672:1: 'output'
            {
             before(grammarAccess.getStateExtendAccess().getOutputKeyword_2_0()); 
            match(input,26,FOLLOW_26_in_rule__StateExtend__Group_2__01486); 
             after(grammarAccess.getStateExtendAccess().getOutputKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__StateExtend__Group_2__1_in_rule__StateExtend__Group_2__01496);
            rule__StateExtend__Group_2__1();
            _fsp--;


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
    // $ANTLR end rule__StateExtend__Group_2__0


    // $ANTLR start rule__StateExtend__Group_2__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:686:1: rule__StateExtend__Group_2__1 : ( ( rule__StateExtend__OutputSignalsAssignment_2_1 ) ) ;
    public final void rule__StateExtend__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:690:1: ( ( ( rule__StateExtend__OutputSignalsAssignment_2_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:691:1: ( ( rule__StateExtend__OutputSignalsAssignment_2_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:691:1: ( ( rule__StateExtend__OutputSignalsAssignment_2_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:692:1: ( rule__StateExtend__OutputSignalsAssignment_2_1 )
            {
             before(grammarAccess.getStateExtendAccess().getOutputSignalsAssignment_2_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:693:1: ( rule__StateExtend__OutputSignalsAssignment_2_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:693:2: rule__StateExtend__OutputSignalsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__StateExtend__OutputSignalsAssignment_2_1_in_rule__StateExtend__Group_2__11524);
            rule__StateExtend__OutputSignalsAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getStateExtendAccess().getOutputSignalsAssignment_2_1()); 

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
    // $ANTLR end rule__StateExtend__Group_2__1


    // $ANTLR start rule__StateExtend__Group_3__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:707:1: rule__StateExtend__Group_3__0 : ( 'input' ) rule__StateExtend__Group_3__1 ;
    public final void rule__StateExtend__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:711:1: ( ( 'input' ) rule__StateExtend__Group_3__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:712:1: ( 'input' ) rule__StateExtend__Group_3__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:712:1: ( 'input' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:713:1: 'input'
            {
             before(grammarAccess.getStateExtendAccess().getInputKeyword_3_0()); 
            match(input,25,FOLLOW_25_in_rule__StateExtend__Group_3__01563); 
             after(grammarAccess.getStateExtendAccess().getInputKeyword_3_0()); 

            }

            pushFollow(FOLLOW_rule__StateExtend__Group_3__1_in_rule__StateExtend__Group_3__01573);
            rule__StateExtend__Group_3__1();
            _fsp--;


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
    // $ANTLR end rule__StateExtend__Group_3__0


    // $ANTLR start rule__StateExtend__Group_3__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:727:1: rule__StateExtend__Group_3__1 : ( ( rule__StateExtend__InputSignalsAssignment_3_1 ) ) ;
    public final void rule__StateExtend__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:731:1: ( ( ( rule__StateExtend__InputSignalsAssignment_3_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:732:1: ( ( rule__StateExtend__InputSignalsAssignment_3_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:732:1: ( ( rule__StateExtend__InputSignalsAssignment_3_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:733:1: ( rule__StateExtend__InputSignalsAssignment_3_1 )
            {
             before(grammarAccess.getStateExtendAccess().getInputSignalsAssignment_3_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:734:1: ( rule__StateExtend__InputSignalsAssignment_3_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:734:2: rule__StateExtend__InputSignalsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__StateExtend__InputSignalsAssignment_3_1_in_rule__StateExtend__Group_3__11601);
            rule__StateExtend__InputSignalsAssignment_3_1();
            _fsp--;


            }

             after(grammarAccess.getStateExtendAccess().getInputSignalsAssignment_3_1()); 

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
    // $ANTLR end rule__StateExtend__Group_3__1


    // $ANTLR start rule__StateExtend__Group_4__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:748:1: rule__StateExtend__Group_4__0 : ( 'signal' ) rule__StateExtend__Group_4__1 ;
    public final void rule__StateExtend__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:752:1: ( ( 'signal' ) rule__StateExtend__Group_4__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:753:1: ( 'signal' ) rule__StateExtend__Group_4__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:753:1: ( 'signal' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:754:1: 'signal'
            {
             before(grammarAccess.getStateExtendAccess().getSignalKeyword_4_0()); 
            match(input,27,FOLLOW_27_in_rule__StateExtend__Group_4__01640); 
             after(grammarAccess.getStateExtendAccess().getSignalKeyword_4_0()); 

            }

            pushFollow(FOLLOW_rule__StateExtend__Group_4__1_in_rule__StateExtend__Group_4__01650);
            rule__StateExtend__Group_4__1();
            _fsp--;


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
    // $ANTLR end rule__StateExtend__Group_4__0


    // $ANTLR start rule__StateExtend__Group_4__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:768:1: rule__StateExtend__Group_4__1 : ( ( rule__StateExtend__SignalsAssignment_4_1 ) ) ;
    public final void rule__StateExtend__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:772:1: ( ( ( rule__StateExtend__SignalsAssignment_4_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:773:1: ( ( rule__StateExtend__SignalsAssignment_4_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:773:1: ( ( rule__StateExtend__SignalsAssignment_4_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:774:1: ( rule__StateExtend__SignalsAssignment_4_1 )
            {
             before(grammarAccess.getStateExtendAccess().getSignalsAssignment_4_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:775:1: ( rule__StateExtend__SignalsAssignment_4_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:775:2: rule__StateExtend__SignalsAssignment_4_1
            {
            pushFollow(FOLLOW_rule__StateExtend__SignalsAssignment_4_1_in_rule__StateExtend__Group_4__11678);
            rule__StateExtend__SignalsAssignment_4_1();
            _fsp--;


            }

             after(grammarAccess.getStateExtendAccess().getSignalsAssignment_4_1()); 

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
    // $ANTLR end rule__StateExtend__Group_4__1


    // $ANTLR start rule__RegionSignalDec__Group__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:789:1: rule__RegionSignalDec__Group__0 : ( ( rule__RegionSignalDec__RegionAssignment_0 ) ) rule__RegionSignalDec__Group__1 ;
    public final void rule__RegionSignalDec__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:793:1: ( ( ( rule__RegionSignalDec__RegionAssignment_0 ) ) rule__RegionSignalDec__Group__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:794:1: ( ( rule__RegionSignalDec__RegionAssignment_0 ) ) rule__RegionSignalDec__Group__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:794:1: ( ( rule__RegionSignalDec__RegionAssignment_0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:795:1: ( rule__RegionSignalDec__RegionAssignment_0 )
            {
             before(grammarAccess.getRegionSignalDecAccess().getRegionAssignment_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:796:1: ( rule__RegionSignalDec__RegionAssignment_0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:796:2: rule__RegionSignalDec__RegionAssignment_0
            {
            pushFollow(FOLLOW_rule__RegionSignalDec__RegionAssignment_0_in_rule__RegionSignalDec__Group__01716);
            rule__RegionSignalDec__RegionAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getRegionSignalDecAccess().getRegionAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group__1_in_rule__RegionSignalDec__Group__01725);
            rule__RegionSignalDec__Group__1();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group__0


    // $ANTLR start rule__RegionSignalDec__Group__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:807:1: rule__RegionSignalDec__Group__1 : ( ':' ) rule__RegionSignalDec__Group__2 ;
    public final void rule__RegionSignalDec__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:811:1: ( ( ':' ) rule__RegionSignalDec__Group__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:812:1: ( ':' ) rule__RegionSignalDec__Group__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:812:1: ( ':' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:813:1: ':'
            {
             before(grammarAccess.getRegionSignalDecAccess().getColonKeyword_1()); 
            match(input,28,FOLLOW_28_in_rule__RegionSignalDec__Group__11754); 
             after(grammarAccess.getRegionSignalDecAccess().getColonKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group__2_in_rule__RegionSignalDec__Group__11764);
            rule__RegionSignalDec__Group__2();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group__1


    // $ANTLR start rule__RegionSignalDec__Group__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:827:1: rule__RegionSignalDec__Group__2 : ( ( rule__RegionSignalDec__Alternatives_2 ) ) rule__RegionSignalDec__Group__3 ;
    public final void rule__RegionSignalDec__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:831:1: ( ( ( rule__RegionSignalDec__Alternatives_2 ) ) rule__RegionSignalDec__Group__3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:832:1: ( ( rule__RegionSignalDec__Alternatives_2 ) ) rule__RegionSignalDec__Group__3
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:832:1: ( ( rule__RegionSignalDec__Alternatives_2 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:833:1: ( rule__RegionSignalDec__Alternatives_2 )
            {
             before(grammarAccess.getRegionSignalDecAccess().getAlternatives_2()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:834:1: ( rule__RegionSignalDec__Alternatives_2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:834:2: rule__RegionSignalDec__Alternatives_2
            {
            pushFollow(FOLLOW_rule__RegionSignalDec__Alternatives_2_in_rule__RegionSignalDec__Group__21792);
            rule__RegionSignalDec__Alternatives_2();
            _fsp--;


            }

             after(grammarAccess.getRegionSignalDecAccess().getAlternatives_2()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group__3_in_rule__RegionSignalDec__Group__21801);
            rule__RegionSignalDec__Group__3();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group__2


    // $ANTLR start rule__RegionSignalDec__Group__3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:845:1: rule__RegionSignalDec__Group__3 : ( ( rule__RegionSignalDec__Alternatives_3 )* ) rule__RegionSignalDec__Group__4 ;
    public final void rule__RegionSignalDec__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:849:1: ( ( ( rule__RegionSignalDec__Alternatives_3 )* ) rule__RegionSignalDec__Group__4 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:850:1: ( ( rule__RegionSignalDec__Alternatives_3 )* ) rule__RegionSignalDec__Group__4
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:850:1: ( ( rule__RegionSignalDec__Alternatives_3 )* )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:851:1: ( rule__RegionSignalDec__Alternatives_3 )*
            {
             before(grammarAccess.getRegionSignalDecAccess().getAlternatives_3()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:852:1: ( rule__RegionSignalDec__Alternatives_3 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==31) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:852:2: rule__RegionSignalDec__Alternatives_3
            	    {
            	    pushFollow(FOLLOW_rule__RegionSignalDec__Alternatives_3_in_rule__RegionSignalDec__Group__31829);
            	    rule__RegionSignalDec__Alternatives_3();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getRegionSignalDecAccess().getAlternatives_3()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group__4_in_rule__RegionSignalDec__Group__31839);
            rule__RegionSignalDec__Group__4();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group__3


    // $ANTLR start rule__RegionSignalDec__Group__4
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:863:1: rule__RegionSignalDec__Group__4 : ( ';' ) ;
    public final void rule__RegionSignalDec__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:867:1: ( ( ';' ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:868:1: ( ';' )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:868:1: ( ';' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:869:1: ';'
            {
             before(grammarAccess.getRegionSignalDecAccess().getSemicolonKeyword_4()); 
            match(input,29,FOLLOW_29_in_rule__RegionSignalDec__Group__41868); 
             after(grammarAccess.getRegionSignalDecAccess().getSemicolonKeyword_4()); 

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
    // $ANTLR end rule__RegionSignalDec__Group__4


    // $ANTLR start rule__RegionSignalDec__Group_2_0__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:892:1: rule__RegionSignalDec__Group_2_0__0 : ( 'var' ) rule__RegionSignalDec__Group_2_0__1 ;
    public final void rule__RegionSignalDec__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:896:1: ( ( 'var' ) rule__RegionSignalDec__Group_2_0__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:897:1: ( 'var' ) rule__RegionSignalDec__Group_2_0__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:897:1: ( 'var' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:898:1: 'var'
            {
             before(grammarAccess.getRegionSignalDecAccess().getVarKeyword_2_0_0()); 
            match(input,30,FOLLOW_30_in_rule__RegionSignalDec__Group_2_0__01914); 
             after(grammarAccess.getRegionSignalDecAccess().getVarKeyword_2_0_0()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group_2_0__1_in_rule__RegionSignalDec__Group_2_0__01924);
            rule__RegionSignalDec__Group_2_0__1();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group_2_0__0


    // $ANTLR start rule__RegionSignalDec__Group_2_0__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:912:1: rule__RegionSignalDec__Group_2_0__1 : ( ( rule__RegionSignalDec__VarsAssignment_2_0_1 ) ) rule__RegionSignalDec__Group_2_0__2 ;
    public final void rule__RegionSignalDec__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:916:1: ( ( ( rule__RegionSignalDec__VarsAssignment_2_0_1 ) ) rule__RegionSignalDec__Group_2_0__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:917:1: ( ( rule__RegionSignalDec__VarsAssignment_2_0_1 ) ) rule__RegionSignalDec__Group_2_0__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:917:1: ( ( rule__RegionSignalDec__VarsAssignment_2_0_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:918:1: ( rule__RegionSignalDec__VarsAssignment_2_0_1 )
            {
             before(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_2_0_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:919:1: ( rule__RegionSignalDec__VarsAssignment_2_0_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:919:2: rule__RegionSignalDec__VarsAssignment_2_0_1
            {
            pushFollow(FOLLOW_rule__RegionSignalDec__VarsAssignment_2_0_1_in_rule__RegionSignalDec__Group_2_0__11952);
            rule__RegionSignalDec__VarsAssignment_2_0_1();
            _fsp--;


            }

             after(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_2_0_1()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group_2_0__2_in_rule__RegionSignalDec__Group_2_0__11961);
            rule__RegionSignalDec__Group_2_0__2();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group_2_0__1


    // $ANTLR start rule__RegionSignalDec__Group_2_0__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:930:1: rule__RegionSignalDec__Group_2_0__2 : ( ( rule__RegionSignalDec__Group_2_0_2__0 )* ) ;
    public final void rule__RegionSignalDec__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:934:1: ( ( ( rule__RegionSignalDec__Group_2_0_2__0 )* ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:935:1: ( ( rule__RegionSignalDec__Group_2_0_2__0 )* )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:935:1: ( ( rule__RegionSignalDec__Group_2_0_2__0 )* )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:936:1: ( rule__RegionSignalDec__Group_2_0_2__0 )*
            {
             before(grammarAccess.getRegionSignalDecAccess().getGroup_2_0_2()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:937:1: ( rule__RegionSignalDec__Group_2_0_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==31) ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1==RULE_ID) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:937:2: rule__RegionSignalDec__Group_2_0_2__0
            	    {
            	    pushFollow(FOLLOW_rule__RegionSignalDec__Group_2_0_2__0_in_rule__RegionSignalDec__Group_2_0__21989);
            	    rule__RegionSignalDec__Group_2_0_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getRegionSignalDecAccess().getGroup_2_0_2()); 

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
    // $ANTLR end rule__RegionSignalDec__Group_2_0__2


    // $ANTLR start rule__RegionSignalDec__Group_2_0_2__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:953:1: rule__RegionSignalDec__Group_2_0_2__0 : ( ',' ) rule__RegionSignalDec__Group_2_0_2__1 ;
    public final void rule__RegionSignalDec__Group_2_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:957:1: ( ( ',' ) rule__RegionSignalDec__Group_2_0_2__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:958:1: ( ',' ) rule__RegionSignalDec__Group_2_0_2__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:958:1: ( ',' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:959:1: ','
            {
             before(grammarAccess.getRegionSignalDecAccess().getCommaKeyword_2_0_2_0()); 
            match(input,31,FOLLOW_31_in_rule__RegionSignalDec__Group_2_0_2__02031); 
             after(grammarAccess.getRegionSignalDecAccess().getCommaKeyword_2_0_2_0()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group_2_0_2__1_in_rule__RegionSignalDec__Group_2_0_2__02041);
            rule__RegionSignalDec__Group_2_0_2__1();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group_2_0_2__0


    // $ANTLR start rule__RegionSignalDec__Group_2_0_2__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:973:1: rule__RegionSignalDec__Group_2_0_2__1 : ( ( rule__RegionSignalDec__VarsAssignment_2_0_2_1 ) ) ;
    public final void rule__RegionSignalDec__Group_2_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:977:1: ( ( ( rule__RegionSignalDec__VarsAssignment_2_0_2_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:978:1: ( ( rule__RegionSignalDec__VarsAssignment_2_0_2_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:978:1: ( ( rule__RegionSignalDec__VarsAssignment_2_0_2_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:979:1: ( rule__RegionSignalDec__VarsAssignment_2_0_2_1 )
            {
             before(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_2_0_2_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:980:1: ( rule__RegionSignalDec__VarsAssignment_2_0_2_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:980:2: rule__RegionSignalDec__VarsAssignment_2_0_2_1
            {
            pushFollow(FOLLOW_rule__RegionSignalDec__VarsAssignment_2_0_2_1_in_rule__RegionSignalDec__Group_2_0_2__12069);
            rule__RegionSignalDec__VarsAssignment_2_0_2_1();
            _fsp--;


            }

             after(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_2_0_2_1()); 

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
    // $ANTLR end rule__RegionSignalDec__Group_2_0_2__1


    // $ANTLR start rule__RegionSignalDec__Group_2_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:994:1: rule__RegionSignalDec__Group_2_1__0 : ( 'signal' ) rule__RegionSignalDec__Group_2_1__1 ;
    public final void rule__RegionSignalDec__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:998:1: ( ( 'signal' ) rule__RegionSignalDec__Group_2_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:999:1: ( 'signal' ) rule__RegionSignalDec__Group_2_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:999:1: ( 'signal' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1000:1: 'signal'
            {
             before(grammarAccess.getRegionSignalDecAccess().getSignalKeyword_2_1_0()); 
            match(input,27,FOLLOW_27_in_rule__RegionSignalDec__Group_2_1__02108); 
             after(grammarAccess.getRegionSignalDecAccess().getSignalKeyword_2_1_0()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group_2_1__1_in_rule__RegionSignalDec__Group_2_1__02118);
            rule__RegionSignalDec__Group_2_1__1();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group_2_1__0


    // $ANTLR start rule__RegionSignalDec__Group_2_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1014:1: rule__RegionSignalDec__Group_2_1__1 : ( ( rule__RegionSignalDec__SignalsAssignment_2_1_1 ) ) rule__RegionSignalDec__Group_2_1__2 ;
    public final void rule__RegionSignalDec__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1018:1: ( ( ( rule__RegionSignalDec__SignalsAssignment_2_1_1 ) ) rule__RegionSignalDec__Group_2_1__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1019:1: ( ( rule__RegionSignalDec__SignalsAssignment_2_1_1 ) ) rule__RegionSignalDec__Group_2_1__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1019:1: ( ( rule__RegionSignalDec__SignalsAssignment_2_1_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1020:1: ( rule__RegionSignalDec__SignalsAssignment_2_1_1 )
            {
             before(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_2_1_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1021:1: ( rule__RegionSignalDec__SignalsAssignment_2_1_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1021:2: rule__RegionSignalDec__SignalsAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__RegionSignalDec__SignalsAssignment_2_1_1_in_rule__RegionSignalDec__Group_2_1__12146);
            rule__RegionSignalDec__SignalsAssignment_2_1_1();
            _fsp--;


            }

             after(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_2_1_1()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group_2_1__2_in_rule__RegionSignalDec__Group_2_1__12155);
            rule__RegionSignalDec__Group_2_1__2();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group_2_1__1


    // $ANTLR start rule__RegionSignalDec__Group_2_1__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1032:1: rule__RegionSignalDec__Group_2_1__2 : ( ( rule__RegionSignalDec__Group_2_1_2__0 )* ) ;
    public final void rule__RegionSignalDec__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1036:1: ( ( ( rule__RegionSignalDec__Group_2_1_2__0 )* ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1037:1: ( ( rule__RegionSignalDec__Group_2_1_2__0 )* )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1037:1: ( ( rule__RegionSignalDec__Group_2_1_2__0 )* )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1038:1: ( rule__RegionSignalDec__Group_2_1_2__0 )*
            {
             before(grammarAccess.getRegionSignalDecAccess().getGroup_2_1_2()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1039:1: ( rule__RegionSignalDec__Group_2_1_2__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==31) ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1==RULE_ID) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1039:2: rule__RegionSignalDec__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__RegionSignalDec__Group_2_1_2__0_in_rule__RegionSignalDec__Group_2_1__22183);
            	    rule__RegionSignalDec__Group_2_1_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getRegionSignalDecAccess().getGroup_2_1_2()); 

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
    // $ANTLR end rule__RegionSignalDec__Group_2_1__2


    // $ANTLR start rule__RegionSignalDec__Group_2_1_2__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1055:1: rule__RegionSignalDec__Group_2_1_2__0 : ( ',' ) rule__RegionSignalDec__Group_2_1_2__1 ;
    public final void rule__RegionSignalDec__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1059:1: ( ( ',' ) rule__RegionSignalDec__Group_2_1_2__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1060:1: ( ',' ) rule__RegionSignalDec__Group_2_1_2__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1060:1: ( ',' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1061:1: ','
            {
             before(grammarAccess.getRegionSignalDecAccess().getCommaKeyword_2_1_2_0()); 
            match(input,31,FOLLOW_31_in_rule__RegionSignalDec__Group_2_1_2__02225); 
             after(grammarAccess.getRegionSignalDecAccess().getCommaKeyword_2_1_2_0()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group_2_1_2__1_in_rule__RegionSignalDec__Group_2_1_2__02235);
            rule__RegionSignalDec__Group_2_1_2__1();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group_2_1_2__0


    // $ANTLR start rule__RegionSignalDec__Group_2_1_2__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1075:1: rule__RegionSignalDec__Group_2_1_2__1 : ( ( rule__RegionSignalDec__SignalsAssignment_2_1_2_1 ) ) ;
    public final void rule__RegionSignalDec__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1079:1: ( ( ( rule__RegionSignalDec__SignalsAssignment_2_1_2_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1080:1: ( ( rule__RegionSignalDec__SignalsAssignment_2_1_2_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1080:1: ( ( rule__RegionSignalDec__SignalsAssignment_2_1_2_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1081:1: ( rule__RegionSignalDec__SignalsAssignment_2_1_2_1 )
            {
             before(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_2_1_2_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1082:1: ( rule__RegionSignalDec__SignalsAssignment_2_1_2_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1082:2: rule__RegionSignalDec__SignalsAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__RegionSignalDec__SignalsAssignment_2_1_2_1_in_rule__RegionSignalDec__Group_2_1_2__12263);
            rule__RegionSignalDec__SignalsAssignment_2_1_2_1();
            _fsp--;


            }

             after(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_2_1_2_1()); 

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
    // $ANTLR end rule__RegionSignalDec__Group_2_1_2__1


    // $ANTLR start rule__RegionSignalDec__Group_3_0__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1096:1: rule__RegionSignalDec__Group_3_0__0 : ( ',' ) rule__RegionSignalDec__Group_3_0__1 ;
    public final void rule__RegionSignalDec__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1100:1: ( ( ',' ) rule__RegionSignalDec__Group_3_0__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1101:1: ( ',' ) rule__RegionSignalDec__Group_3_0__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1101:1: ( ',' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1102:1: ','
            {
             before(grammarAccess.getRegionSignalDecAccess().getCommaKeyword_3_0_0()); 
            match(input,31,FOLLOW_31_in_rule__RegionSignalDec__Group_3_0__02302); 
             after(grammarAccess.getRegionSignalDecAccess().getCommaKeyword_3_0_0()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group_3_0__1_in_rule__RegionSignalDec__Group_3_0__02312);
            rule__RegionSignalDec__Group_3_0__1();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group_3_0__0


    // $ANTLR start rule__RegionSignalDec__Group_3_0__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1116:1: rule__RegionSignalDec__Group_3_0__1 : ( 'var' ) rule__RegionSignalDec__Group_3_0__2 ;
    public final void rule__RegionSignalDec__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1120:1: ( ( 'var' ) rule__RegionSignalDec__Group_3_0__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1121:1: ( 'var' ) rule__RegionSignalDec__Group_3_0__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1121:1: ( 'var' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1122:1: 'var'
            {
             before(grammarAccess.getRegionSignalDecAccess().getVarKeyword_3_0_1()); 
            match(input,30,FOLLOW_30_in_rule__RegionSignalDec__Group_3_0__12341); 
             after(grammarAccess.getRegionSignalDecAccess().getVarKeyword_3_0_1()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group_3_0__2_in_rule__RegionSignalDec__Group_3_0__12351);
            rule__RegionSignalDec__Group_3_0__2();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group_3_0__1


    // $ANTLR start rule__RegionSignalDec__Group_3_0__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1136:1: rule__RegionSignalDec__Group_3_0__2 : ( ( rule__RegionSignalDec__VarsAssignment_3_0_2 ) ) rule__RegionSignalDec__Group_3_0__3 ;
    public final void rule__RegionSignalDec__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1140:1: ( ( ( rule__RegionSignalDec__VarsAssignment_3_0_2 ) ) rule__RegionSignalDec__Group_3_0__3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1141:1: ( ( rule__RegionSignalDec__VarsAssignment_3_0_2 ) ) rule__RegionSignalDec__Group_3_0__3
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1141:1: ( ( rule__RegionSignalDec__VarsAssignment_3_0_2 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1142:1: ( rule__RegionSignalDec__VarsAssignment_3_0_2 )
            {
             before(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_3_0_2()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1143:1: ( rule__RegionSignalDec__VarsAssignment_3_0_2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1143:2: rule__RegionSignalDec__VarsAssignment_3_0_2
            {
            pushFollow(FOLLOW_rule__RegionSignalDec__VarsAssignment_3_0_2_in_rule__RegionSignalDec__Group_3_0__22379);
            rule__RegionSignalDec__VarsAssignment_3_0_2();
            _fsp--;


            }

             after(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_3_0_2()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group_3_0__3_in_rule__RegionSignalDec__Group_3_0__22388);
            rule__RegionSignalDec__Group_3_0__3();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group_3_0__2


    // $ANTLR start rule__RegionSignalDec__Group_3_0__3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1154:1: rule__RegionSignalDec__Group_3_0__3 : ( ( rule__RegionSignalDec__Group_3_0_3__0 )* ) ;
    public final void rule__RegionSignalDec__Group_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1158:1: ( ( ( rule__RegionSignalDec__Group_3_0_3__0 )* ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1159:1: ( ( rule__RegionSignalDec__Group_3_0_3__0 )* )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1159:1: ( ( rule__RegionSignalDec__Group_3_0_3__0 )* )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1160:1: ( rule__RegionSignalDec__Group_3_0_3__0 )*
            {
             before(grammarAccess.getRegionSignalDecAccess().getGroup_3_0_3()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1161:1: ( rule__RegionSignalDec__Group_3_0_3__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==31) ) {
                    int LA11_2 = input.LA(2);

                    if ( (LA11_2==RULE_ID) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1161:2: rule__RegionSignalDec__Group_3_0_3__0
            	    {
            	    pushFollow(FOLLOW_rule__RegionSignalDec__Group_3_0_3__0_in_rule__RegionSignalDec__Group_3_0__32416);
            	    rule__RegionSignalDec__Group_3_0_3__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getRegionSignalDecAccess().getGroup_3_0_3()); 

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
    // $ANTLR end rule__RegionSignalDec__Group_3_0__3


    // $ANTLR start rule__RegionSignalDec__Group_3_0_3__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1179:1: rule__RegionSignalDec__Group_3_0_3__0 : ( ',' ) rule__RegionSignalDec__Group_3_0_3__1 ;
    public final void rule__RegionSignalDec__Group_3_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1183:1: ( ( ',' ) rule__RegionSignalDec__Group_3_0_3__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1184:1: ( ',' ) rule__RegionSignalDec__Group_3_0_3__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1184:1: ( ',' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1185:1: ','
            {
             before(grammarAccess.getRegionSignalDecAccess().getCommaKeyword_3_0_3_0()); 
            match(input,31,FOLLOW_31_in_rule__RegionSignalDec__Group_3_0_3__02460); 
             after(grammarAccess.getRegionSignalDecAccess().getCommaKeyword_3_0_3_0()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group_3_0_3__1_in_rule__RegionSignalDec__Group_3_0_3__02470);
            rule__RegionSignalDec__Group_3_0_3__1();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group_3_0_3__0


    // $ANTLR start rule__RegionSignalDec__Group_3_0_3__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1199:1: rule__RegionSignalDec__Group_3_0_3__1 : ( ( rule__RegionSignalDec__VarsAssignment_3_0_3_1 ) ) ;
    public final void rule__RegionSignalDec__Group_3_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1203:1: ( ( ( rule__RegionSignalDec__VarsAssignment_3_0_3_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1204:1: ( ( rule__RegionSignalDec__VarsAssignment_3_0_3_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1204:1: ( ( rule__RegionSignalDec__VarsAssignment_3_0_3_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1205:1: ( rule__RegionSignalDec__VarsAssignment_3_0_3_1 )
            {
             before(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_3_0_3_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1206:1: ( rule__RegionSignalDec__VarsAssignment_3_0_3_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1206:2: rule__RegionSignalDec__VarsAssignment_3_0_3_1
            {
            pushFollow(FOLLOW_rule__RegionSignalDec__VarsAssignment_3_0_3_1_in_rule__RegionSignalDec__Group_3_0_3__12498);
            rule__RegionSignalDec__VarsAssignment_3_0_3_1();
            _fsp--;


            }

             after(grammarAccess.getRegionSignalDecAccess().getVarsAssignment_3_0_3_1()); 

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
    // $ANTLR end rule__RegionSignalDec__Group_3_0_3__1


    // $ANTLR start rule__RegionSignalDec__Group_3_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1220:1: rule__RegionSignalDec__Group_3_1__0 : ( ',' ) rule__RegionSignalDec__Group_3_1__1 ;
    public final void rule__RegionSignalDec__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1224:1: ( ( ',' ) rule__RegionSignalDec__Group_3_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1225:1: ( ',' ) rule__RegionSignalDec__Group_3_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1225:1: ( ',' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1226:1: ','
            {
             before(grammarAccess.getRegionSignalDecAccess().getCommaKeyword_3_1_0()); 
            match(input,31,FOLLOW_31_in_rule__RegionSignalDec__Group_3_1__02537); 
             after(grammarAccess.getRegionSignalDecAccess().getCommaKeyword_3_1_0()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group_3_1__1_in_rule__RegionSignalDec__Group_3_1__02547);
            rule__RegionSignalDec__Group_3_1__1();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group_3_1__0


    // $ANTLR start rule__RegionSignalDec__Group_3_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1240:1: rule__RegionSignalDec__Group_3_1__1 : ( 'signal' ) rule__RegionSignalDec__Group_3_1__2 ;
    public final void rule__RegionSignalDec__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1244:1: ( ( 'signal' ) rule__RegionSignalDec__Group_3_1__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1245:1: ( 'signal' ) rule__RegionSignalDec__Group_3_1__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1245:1: ( 'signal' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1246:1: 'signal'
            {
             before(grammarAccess.getRegionSignalDecAccess().getSignalKeyword_3_1_1()); 
            match(input,27,FOLLOW_27_in_rule__RegionSignalDec__Group_3_1__12576); 
             after(grammarAccess.getRegionSignalDecAccess().getSignalKeyword_3_1_1()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group_3_1__2_in_rule__RegionSignalDec__Group_3_1__12586);
            rule__RegionSignalDec__Group_3_1__2();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group_3_1__1


    // $ANTLR start rule__RegionSignalDec__Group_3_1__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1260:1: rule__RegionSignalDec__Group_3_1__2 : ( ( rule__RegionSignalDec__SignalsAssignment_3_1_2 ) ) rule__RegionSignalDec__Group_3_1__3 ;
    public final void rule__RegionSignalDec__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1264:1: ( ( ( rule__RegionSignalDec__SignalsAssignment_3_1_2 ) ) rule__RegionSignalDec__Group_3_1__3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1265:1: ( ( rule__RegionSignalDec__SignalsAssignment_3_1_2 ) ) rule__RegionSignalDec__Group_3_1__3
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1265:1: ( ( rule__RegionSignalDec__SignalsAssignment_3_1_2 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1266:1: ( rule__RegionSignalDec__SignalsAssignment_3_1_2 )
            {
             before(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_3_1_2()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1267:1: ( rule__RegionSignalDec__SignalsAssignment_3_1_2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1267:2: rule__RegionSignalDec__SignalsAssignment_3_1_2
            {
            pushFollow(FOLLOW_rule__RegionSignalDec__SignalsAssignment_3_1_2_in_rule__RegionSignalDec__Group_3_1__22614);
            rule__RegionSignalDec__SignalsAssignment_3_1_2();
            _fsp--;


            }

             after(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_3_1_2()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group_3_1__3_in_rule__RegionSignalDec__Group_3_1__22623);
            rule__RegionSignalDec__Group_3_1__3();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group_3_1__2


    // $ANTLR start rule__RegionSignalDec__Group_3_1__3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1278:1: rule__RegionSignalDec__Group_3_1__3 : ( ( rule__RegionSignalDec__Group_3_1_3__0 )* ) ;
    public final void rule__RegionSignalDec__Group_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1282:1: ( ( ( rule__RegionSignalDec__Group_3_1_3__0 )* ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1283:1: ( ( rule__RegionSignalDec__Group_3_1_3__0 )* )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1283:1: ( ( rule__RegionSignalDec__Group_3_1_3__0 )* )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1284:1: ( rule__RegionSignalDec__Group_3_1_3__0 )*
            {
             before(grammarAccess.getRegionSignalDecAccess().getGroup_3_1_3()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1285:1: ( rule__RegionSignalDec__Group_3_1_3__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==31) ) {
                    int LA12_2 = input.LA(2);

                    if ( (LA12_2==RULE_ID) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1285:2: rule__RegionSignalDec__Group_3_1_3__0
            	    {
            	    pushFollow(FOLLOW_rule__RegionSignalDec__Group_3_1_3__0_in_rule__RegionSignalDec__Group_3_1__32651);
            	    rule__RegionSignalDec__Group_3_1_3__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getRegionSignalDecAccess().getGroup_3_1_3()); 

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
    // $ANTLR end rule__RegionSignalDec__Group_3_1__3


    // $ANTLR start rule__RegionSignalDec__Group_3_1_3__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1303:1: rule__RegionSignalDec__Group_3_1_3__0 : ( ',' ) rule__RegionSignalDec__Group_3_1_3__1 ;
    public final void rule__RegionSignalDec__Group_3_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1307:1: ( ( ',' ) rule__RegionSignalDec__Group_3_1_3__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1308:1: ( ',' ) rule__RegionSignalDec__Group_3_1_3__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1308:1: ( ',' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1309:1: ','
            {
             before(grammarAccess.getRegionSignalDecAccess().getCommaKeyword_3_1_3_0()); 
            match(input,31,FOLLOW_31_in_rule__RegionSignalDec__Group_3_1_3__02695); 
             after(grammarAccess.getRegionSignalDecAccess().getCommaKeyword_3_1_3_0()); 

            }

            pushFollow(FOLLOW_rule__RegionSignalDec__Group_3_1_3__1_in_rule__RegionSignalDec__Group_3_1_3__02705);
            rule__RegionSignalDec__Group_3_1_3__1();
            _fsp--;


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
    // $ANTLR end rule__RegionSignalDec__Group_3_1_3__0


    // $ANTLR start rule__RegionSignalDec__Group_3_1_3__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1323:1: rule__RegionSignalDec__Group_3_1_3__1 : ( ( rule__RegionSignalDec__SignalsAssignment_3_1_3_1 ) ) ;
    public final void rule__RegionSignalDec__Group_3_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1327:1: ( ( ( rule__RegionSignalDec__SignalsAssignment_3_1_3_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1328:1: ( ( rule__RegionSignalDec__SignalsAssignment_3_1_3_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1328:1: ( ( rule__RegionSignalDec__SignalsAssignment_3_1_3_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1329:1: ( rule__RegionSignalDec__SignalsAssignment_3_1_3_1 )
            {
             before(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_3_1_3_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1330:1: ( rule__RegionSignalDec__SignalsAssignment_3_1_3_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1330:2: rule__RegionSignalDec__SignalsAssignment_3_1_3_1
            {
            pushFollow(FOLLOW_rule__RegionSignalDec__SignalsAssignment_3_1_3_1_in_rule__RegionSignalDec__Group_3_1_3__12733);
            rule__RegionSignalDec__SignalsAssignment_3_1_3_1();
            _fsp--;


            }

             after(grammarAccess.getRegionSignalDecAccess().getSignalsAssignment_3_1_3_1()); 

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
    // $ANTLR end rule__RegionSignalDec__Group_3_1_3__1


    // $ANTLR start rule__Signals__Group__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1344:1: rule__Signals__Group__0 : ( ( rule__Signals__Group_0__0 ) ) rule__Signals__Group__1 ;
    public final void rule__Signals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1348:1: ( ( ( rule__Signals__Group_0__0 ) ) rule__Signals__Group__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1349:1: ( ( rule__Signals__Group_0__0 ) ) rule__Signals__Group__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1349:1: ( ( rule__Signals__Group_0__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1350:1: ( rule__Signals__Group_0__0 )
            {
             before(grammarAccess.getSignalsAccess().getGroup_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1351:1: ( rule__Signals__Group_0__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1351:2: rule__Signals__Group_0__0
            {
            pushFollow(FOLLOW_rule__Signals__Group_0__0_in_rule__Signals__Group__02771);
            rule__Signals__Group_0__0();
            _fsp--;


            }

             after(grammarAccess.getSignalsAccess().getGroup_0()); 

            }

            pushFollow(FOLLOW_rule__Signals__Group__1_in_rule__Signals__Group__02780);
            rule__Signals__Group__1();
            _fsp--;


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
    // $ANTLR end rule__Signals__Group__0


    // $ANTLR start rule__Signals__Group__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1362:1: rule__Signals__Group__1 : ( ';' ) ;
    public final void rule__Signals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1366:1: ( ( ';' ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1367:1: ( ';' )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1367:1: ( ';' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1368:1: ';'
            {
             before(grammarAccess.getSignalsAccess().getSemicolonKeyword_1()); 
            match(input,29,FOLLOW_29_in_rule__Signals__Group__12809); 
             after(grammarAccess.getSignalsAccess().getSemicolonKeyword_1()); 

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
    // $ANTLR end rule__Signals__Group__1


    // $ANTLR start rule__Signals__Group_0__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1385:1: rule__Signals__Group_0__0 : ( ( rule__Signals__SignalsAssignment_0_0 ) ) rule__Signals__Group_0__1 ;
    public final void rule__Signals__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1389:1: ( ( ( rule__Signals__SignalsAssignment_0_0 ) ) rule__Signals__Group_0__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1390:1: ( ( rule__Signals__SignalsAssignment_0_0 ) ) rule__Signals__Group_0__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1390:1: ( ( rule__Signals__SignalsAssignment_0_0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1391:1: ( rule__Signals__SignalsAssignment_0_0 )
            {
             before(grammarAccess.getSignalsAccess().getSignalsAssignment_0_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1392:1: ( rule__Signals__SignalsAssignment_0_0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1392:2: rule__Signals__SignalsAssignment_0_0
            {
            pushFollow(FOLLOW_rule__Signals__SignalsAssignment_0_0_in_rule__Signals__Group_0__02848);
            rule__Signals__SignalsAssignment_0_0();
            _fsp--;


            }

             after(grammarAccess.getSignalsAccess().getSignalsAssignment_0_0()); 

            }

            pushFollow(FOLLOW_rule__Signals__Group_0__1_in_rule__Signals__Group_0__02857);
            rule__Signals__Group_0__1();
            _fsp--;


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
    // $ANTLR end rule__Signals__Group_0__0


    // $ANTLR start rule__Signals__Group_0__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1403:1: rule__Signals__Group_0__1 : ( ( rule__Signals__Group_0_1__0 )* ) ;
    public final void rule__Signals__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1407:1: ( ( ( rule__Signals__Group_0_1__0 )* ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1408:1: ( ( rule__Signals__Group_0_1__0 )* )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1408:1: ( ( rule__Signals__Group_0_1__0 )* )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1409:1: ( rule__Signals__Group_0_1__0 )*
            {
             before(grammarAccess.getSignalsAccess().getGroup_0_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1410:1: ( rule__Signals__Group_0_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==31) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1410:2: rule__Signals__Group_0_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Signals__Group_0_1__0_in_rule__Signals__Group_0__12885);
            	    rule__Signals__Group_0_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getSignalsAccess().getGroup_0_1()); 

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
    // $ANTLR end rule__Signals__Group_0__1


    // $ANTLR start rule__Signals__Group_0_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1424:1: rule__Signals__Group_0_1__0 : ( ',' ) rule__Signals__Group_0_1__1 ;
    public final void rule__Signals__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1428:1: ( ( ',' ) rule__Signals__Group_0_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1429:1: ( ',' ) rule__Signals__Group_0_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1429:1: ( ',' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1430:1: ','
            {
             before(grammarAccess.getSignalsAccess().getCommaKeyword_0_1_0()); 
            match(input,31,FOLLOW_31_in_rule__Signals__Group_0_1__02925); 
             after(grammarAccess.getSignalsAccess().getCommaKeyword_0_1_0()); 

            }

            pushFollow(FOLLOW_rule__Signals__Group_0_1__1_in_rule__Signals__Group_0_1__02935);
            rule__Signals__Group_0_1__1();
            _fsp--;


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
    // $ANTLR end rule__Signals__Group_0_1__0


    // $ANTLR start rule__Signals__Group_0_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1444:1: rule__Signals__Group_0_1__1 : ( ( rule__Signals__SignalsAssignment_0_1_1 ) ) ;
    public final void rule__Signals__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1448:1: ( ( ( rule__Signals__SignalsAssignment_0_1_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1449:1: ( ( rule__Signals__SignalsAssignment_0_1_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1449:1: ( ( rule__Signals__SignalsAssignment_0_1_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1450:1: ( rule__Signals__SignalsAssignment_0_1_1 )
            {
             before(grammarAccess.getSignalsAccess().getSignalsAssignment_0_1_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1451:1: ( rule__Signals__SignalsAssignment_0_1_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1451:2: rule__Signals__SignalsAssignment_0_1_1
            {
            pushFollow(FOLLOW_rule__Signals__SignalsAssignment_0_1_1_in_rule__Signals__Group_0_1__12963);
            rule__Signals__SignalsAssignment_0_1_1();
            _fsp--;


            }

             after(grammarAccess.getSignalsAccess().getSignalsAssignment_0_1_1()); 

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
    // $ANTLR end rule__Signals__Group_0_1__1


    // $ANTLR start rule__InputSignals__Group__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1465:1: rule__InputSignals__Group__0 : ( ( rule__InputSignals__Group_0__0 ) ) rule__InputSignals__Group__1 ;
    public final void rule__InputSignals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1469:1: ( ( ( rule__InputSignals__Group_0__0 ) ) rule__InputSignals__Group__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1470:1: ( ( rule__InputSignals__Group_0__0 ) ) rule__InputSignals__Group__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1470:1: ( ( rule__InputSignals__Group_0__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1471:1: ( rule__InputSignals__Group_0__0 )
            {
             before(grammarAccess.getInputSignalsAccess().getGroup_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1472:1: ( rule__InputSignals__Group_0__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1472:2: rule__InputSignals__Group_0__0
            {
            pushFollow(FOLLOW_rule__InputSignals__Group_0__0_in_rule__InputSignals__Group__03001);
            rule__InputSignals__Group_0__0();
            _fsp--;


            }

             after(grammarAccess.getInputSignalsAccess().getGroup_0()); 

            }

            pushFollow(FOLLOW_rule__InputSignals__Group__1_in_rule__InputSignals__Group__03010);
            rule__InputSignals__Group__1();
            _fsp--;


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
    // $ANTLR end rule__InputSignals__Group__0


    // $ANTLR start rule__InputSignals__Group__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1483:1: rule__InputSignals__Group__1 : ( ';' ) ;
    public final void rule__InputSignals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1487:1: ( ( ';' ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1488:1: ( ';' )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1488:1: ( ';' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1489:1: ';'
            {
             before(grammarAccess.getInputSignalsAccess().getSemicolonKeyword_1()); 
            match(input,29,FOLLOW_29_in_rule__InputSignals__Group__13039); 
             after(grammarAccess.getInputSignalsAccess().getSemicolonKeyword_1()); 

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
    // $ANTLR end rule__InputSignals__Group__1


    // $ANTLR start rule__InputSignals__Group_0__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1506:1: rule__InputSignals__Group_0__0 : ( ( rule__InputSignals__SignalsAssignment_0_0 ) ) rule__InputSignals__Group_0__1 ;
    public final void rule__InputSignals__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1510:1: ( ( ( rule__InputSignals__SignalsAssignment_0_0 ) ) rule__InputSignals__Group_0__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1511:1: ( ( rule__InputSignals__SignalsAssignment_0_0 ) ) rule__InputSignals__Group_0__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1511:1: ( ( rule__InputSignals__SignalsAssignment_0_0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1512:1: ( rule__InputSignals__SignalsAssignment_0_0 )
            {
             before(grammarAccess.getInputSignalsAccess().getSignalsAssignment_0_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1513:1: ( rule__InputSignals__SignalsAssignment_0_0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1513:2: rule__InputSignals__SignalsAssignment_0_0
            {
            pushFollow(FOLLOW_rule__InputSignals__SignalsAssignment_0_0_in_rule__InputSignals__Group_0__03078);
            rule__InputSignals__SignalsAssignment_0_0();
            _fsp--;


            }

             after(grammarAccess.getInputSignalsAccess().getSignalsAssignment_0_0()); 

            }

            pushFollow(FOLLOW_rule__InputSignals__Group_0__1_in_rule__InputSignals__Group_0__03087);
            rule__InputSignals__Group_0__1();
            _fsp--;


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
    // $ANTLR end rule__InputSignals__Group_0__0


    // $ANTLR start rule__InputSignals__Group_0__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1524:1: rule__InputSignals__Group_0__1 : ( ( rule__InputSignals__Group_0_1__0 )* ) ;
    public final void rule__InputSignals__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1528:1: ( ( ( rule__InputSignals__Group_0_1__0 )* ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1529:1: ( ( rule__InputSignals__Group_0_1__0 )* )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1529:1: ( ( rule__InputSignals__Group_0_1__0 )* )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1530:1: ( rule__InputSignals__Group_0_1__0 )*
            {
             before(grammarAccess.getInputSignalsAccess().getGroup_0_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1531:1: ( rule__InputSignals__Group_0_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==31) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1531:2: rule__InputSignals__Group_0_1__0
            	    {
            	    pushFollow(FOLLOW_rule__InputSignals__Group_0_1__0_in_rule__InputSignals__Group_0__13115);
            	    rule__InputSignals__Group_0_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getInputSignalsAccess().getGroup_0_1()); 

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
    // $ANTLR end rule__InputSignals__Group_0__1


    // $ANTLR start rule__InputSignals__Group_0_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1545:1: rule__InputSignals__Group_0_1__0 : ( ',' ) rule__InputSignals__Group_0_1__1 ;
    public final void rule__InputSignals__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1549:1: ( ( ',' ) rule__InputSignals__Group_0_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1550:1: ( ',' ) rule__InputSignals__Group_0_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1550:1: ( ',' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1551:1: ','
            {
             before(grammarAccess.getInputSignalsAccess().getCommaKeyword_0_1_0()); 
            match(input,31,FOLLOW_31_in_rule__InputSignals__Group_0_1__03155); 
             after(grammarAccess.getInputSignalsAccess().getCommaKeyword_0_1_0()); 

            }

            pushFollow(FOLLOW_rule__InputSignals__Group_0_1__1_in_rule__InputSignals__Group_0_1__03165);
            rule__InputSignals__Group_0_1__1();
            _fsp--;


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
    // $ANTLR end rule__InputSignals__Group_0_1__0


    // $ANTLR start rule__InputSignals__Group_0_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1565:1: rule__InputSignals__Group_0_1__1 : ( ( rule__InputSignals__SignalsAssignment_0_1_1 ) ) ;
    public final void rule__InputSignals__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1569:1: ( ( ( rule__InputSignals__SignalsAssignment_0_1_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1570:1: ( ( rule__InputSignals__SignalsAssignment_0_1_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1570:1: ( ( rule__InputSignals__SignalsAssignment_0_1_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1571:1: ( rule__InputSignals__SignalsAssignment_0_1_1 )
            {
             before(grammarAccess.getInputSignalsAccess().getSignalsAssignment_0_1_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1572:1: ( rule__InputSignals__SignalsAssignment_0_1_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1572:2: rule__InputSignals__SignalsAssignment_0_1_1
            {
            pushFollow(FOLLOW_rule__InputSignals__SignalsAssignment_0_1_1_in_rule__InputSignals__Group_0_1__13193);
            rule__InputSignals__SignalsAssignment_0_1_1();
            _fsp--;


            }

             after(grammarAccess.getInputSignalsAccess().getSignalsAssignment_0_1_1()); 

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
    // $ANTLR end rule__InputSignals__Group_0_1__1


    // $ANTLR start rule__OutputSignals__Group__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1586:1: rule__OutputSignals__Group__0 : ( ( rule__OutputSignals__Group_0__0 ) ) rule__OutputSignals__Group__1 ;
    public final void rule__OutputSignals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1590:1: ( ( ( rule__OutputSignals__Group_0__0 ) ) rule__OutputSignals__Group__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1591:1: ( ( rule__OutputSignals__Group_0__0 ) ) rule__OutputSignals__Group__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1591:1: ( ( rule__OutputSignals__Group_0__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1592:1: ( rule__OutputSignals__Group_0__0 )
            {
             before(grammarAccess.getOutputSignalsAccess().getGroup_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1593:1: ( rule__OutputSignals__Group_0__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1593:2: rule__OutputSignals__Group_0__0
            {
            pushFollow(FOLLOW_rule__OutputSignals__Group_0__0_in_rule__OutputSignals__Group__03231);
            rule__OutputSignals__Group_0__0();
            _fsp--;


            }

             after(grammarAccess.getOutputSignalsAccess().getGroup_0()); 

            }

            pushFollow(FOLLOW_rule__OutputSignals__Group__1_in_rule__OutputSignals__Group__03240);
            rule__OutputSignals__Group__1();
            _fsp--;


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
    // $ANTLR end rule__OutputSignals__Group__0


    // $ANTLR start rule__OutputSignals__Group__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1604:1: rule__OutputSignals__Group__1 : ( ';' ) ;
    public final void rule__OutputSignals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1608:1: ( ( ';' ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1609:1: ( ';' )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1609:1: ( ';' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1610:1: ';'
            {
             before(grammarAccess.getOutputSignalsAccess().getSemicolonKeyword_1()); 
            match(input,29,FOLLOW_29_in_rule__OutputSignals__Group__13269); 
             after(grammarAccess.getOutputSignalsAccess().getSemicolonKeyword_1()); 

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
    // $ANTLR end rule__OutputSignals__Group__1


    // $ANTLR start rule__OutputSignals__Group_0__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1627:1: rule__OutputSignals__Group_0__0 : ( ( rule__OutputSignals__SignalsAssignment_0_0 ) ) rule__OutputSignals__Group_0__1 ;
    public final void rule__OutputSignals__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1631:1: ( ( ( rule__OutputSignals__SignalsAssignment_0_0 ) ) rule__OutputSignals__Group_0__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1632:1: ( ( rule__OutputSignals__SignalsAssignment_0_0 ) ) rule__OutputSignals__Group_0__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1632:1: ( ( rule__OutputSignals__SignalsAssignment_0_0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1633:1: ( rule__OutputSignals__SignalsAssignment_0_0 )
            {
             before(grammarAccess.getOutputSignalsAccess().getSignalsAssignment_0_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1634:1: ( rule__OutputSignals__SignalsAssignment_0_0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1634:2: rule__OutputSignals__SignalsAssignment_0_0
            {
            pushFollow(FOLLOW_rule__OutputSignals__SignalsAssignment_0_0_in_rule__OutputSignals__Group_0__03308);
            rule__OutputSignals__SignalsAssignment_0_0();
            _fsp--;


            }

             after(grammarAccess.getOutputSignalsAccess().getSignalsAssignment_0_0()); 

            }

            pushFollow(FOLLOW_rule__OutputSignals__Group_0__1_in_rule__OutputSignals__Group_0__03317);
            rule__OutputSignals__Group_0__1();
            _fsp--;


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
    // $ANTLR end rule__OutputSignals__Group_0__0


    // $ANTLR start rule__OutputSignals__Group_0__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1645:1: rule__OutputSignals__Group_0__1 : ( ( rule__OutputSignals__Group_0_1__0 )* ) ;
    public final void rule__OutputSignals__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1649:1: ( ( ( rule__OutputSignals__Group_0_1__0 )* ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1650:1: ( ( rule__OutputSignals__Group_0_1__0 )* )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1650:1: ( ( rule__OutputSignals__Group_0_1__0 )* )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1651:1: ( rule__OutputSignals__Group_0_1__0 )*
            {
             before(grammarAccess.getOutputSignalsAccess().getGroup_0_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1652:1: ( rule__OutputSignals__Group_0_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==31) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1652:2: rule__OutputSignals__Group_0_1__0
            	    {
            	    pushFollow(FOLLOW_rule__OutputSignals__Group_0_1__0_in_rule__OutputSignals__Group_0__13345);
            	    rule__OutputSignals__Group_0_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getOutputSignalsAccess().getGroup_0_1()); 

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
    // $ANTLR end rule__OutputSignals__Group_0__1


    // $ANTLR start rule__OutputSignals__Group_0_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1666:1: rule__OutputSignals__Group_0_1__0 : ( ',' ) rule__OutputSignals__Group_0_1__1 ;
    public final void rule__OutputSignals__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1670:1: ( ( ',' ) rule__OutputSignals__Group_0_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1671:1: ( ',' ) rule__OutputSignals__Group_0_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1671:1: ( ',' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1672:1: ','
            {
             before(grammarAccess.getOutputSignalsAccess().getCommaKeyword_0_1_0()); 
            match(input,31,FOLLOW_31_in_rule__OutputSignals__Group_0_1__03385); 
             after(grammarAccess.getOutputSignalsAccess().getCommaKeyword_0_1_0()); 

            }

            pushFollow(FOLLOW_rule__OutputSignals__Group_0_1__1_in_rule__OutputSignals__Group_0_1__03395);
            rule__OutputSignals__Group_0_1__1();
            _fsp--;


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
    // $ANTLR end rule__OutputSignals__Group_0_1__0


    // $ANTLR start rule__OutputSignals__Group_0_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1686:1: rule__OutputSignals__Group_0_1__1 : ( ( rule__OutputSignals__SignalsAssignment_0_1_1 ) ) ;
    public final void rule__OutputSignals__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1690:1: ( ( ( rule__OutputSignals__SignalsAssignment_0_1_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1691:1: ( ( rule__OutputSignals__SignalsAssignment_0_1_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1691:1: ( ( rule__OutputSignals__SignalsAssignment_0_1_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1692:1: ( rule__OutputSignals__SignalsAssignment_0_1_1 )
            {
             before(grammarAccess.getOutputSignalsAccess().getSignalsAssignment_0_1_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1693:1: ( rule__OutputSignals__SignalsAssignment_0_1_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1693:2: rule__OutputSignals__SignalsAssignment_0_1_1
            {
            pushFollow(FOLLOW_rule__OutputSignals__SignalsAssignment_0_1_1_in_rule__OutputSignals__Group_0_1__13423);
            rule__OutputSignals__SignalsAssignment_0_1_1();
            _fsp--;


            }

             after(grammarAccess.getOutputSignalsAccess().getSignalsAssignment_0_1_1()); 

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
    // $ANTLR end rule__OutputSignals__Group_0_1__1


    // $ANTLR start rule__InOutputSignals__Group__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1707:1: rule__InOutputSignals__Group__0 : ( ( rule__InOutputSignals__Group_0__0 ) ) rule__InOutputSignals__Group__1 ;
    public final void rule__InOutputSignals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1711:1: ( ( ( rule__InOutputSignals__Group_0__0 ) ) rule__InOutputSignals__Group__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1712:1: ( ( rule__InOutputSignals__Group_0__0 ) ) rule__InOutputSignals__Group__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1712:1: ( ( rule__InOutputSignals__Group_0__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1713:1: ( rule__InOutputSignals__Group_0__0 )
            {
             before(grammarAccess.getInOutputSignalsAccess().getGroup_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1714:1: ( rule__InOutputSignals__Group_0__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1714:2: rule__InOutputSignals__Group_0__0
            {
            pushFollow(FOLLOW_rule__InOutputSignals__Group_0__0_in_rule__InOutputSignals__Group__03461);
            rule__InOutputSignals__Group_0__0();
            _fsp--;


            }

             after(grammarAccess.getInOutputSignalsAccess().getGroup_0()); 

            }

            pushFollow(FOLLOW_rule__InOutputSignals__Group__1_in_rule__InOutputSignals__Group__03470);
            rule__InOutputSignals__Group__1();
            _fsp--;


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
    // $ANTLR end rule__InOutputSignals__Group__0


    // $ANTLR start rule__InOutputSignals__Group__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1725:1: rule__InOutputSignals__Group__1 : ( ';' ) ;
    public final void rule__InOutputSignals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1729:1: ( ( ';' ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1730:1: ( ';' )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1730:1: ( ';' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1731:1: ';'
            {
             before(grammarAccess.getInOutputSignalsAccess().getSemicolonKeyword_1()); 
            match(input,29,FOLLOW_29_in_rule__InOutputSignals__Group__13499); 
             after(grammarAccess.getInOutputSignalsAccess().getSemicolonKeyword_1()); 

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
    // $ANTLR end rule__InOutputSignals__Group__1


    // $ANTLR start rule__InOutputSignals__Group_0__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1748:1: rule__InOutputSignals__Group_0__0 : ( ( rule__InOutputSignals__SignalsAssignment_0_0 ) ) rule__InOutputSignals__Group_0__1 ;
    public final void rule__InOutputSignals__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1752:1: ( ( ( rule__InOutputSignals__SignalsAssignment_0_0 ) ) rule__InOutputSignals__Group_0__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1753:1: ( ( rule__InOutputSignals__SignalsAssignment_0_0 ) ) rule__InOutputSignals__Group_0__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1753:1: ( ( rule__InOutputSignals__SignalsAssignment_0_0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1754:1: ( rule__InOutputSignals__SignalsAssignment_0_0 )
            {
             before(grammarAccess.getInOutputSignalsAccess().getSignalsAssignment_0_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1755:1: ( rule__InOutputSignals__SignalsAssignment_0_0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1755:2: rule__InOutputSignals__SignalsAssignment_0_0
            {
            pushFollow(FOLLOW_rule__InOutputSignals__SignalsAssignment_0_0_in_rule__InOutputSignals__Group_0__03538);
            rule__InOutputSignals__SignalsAssignment_0_0();
            _fsp--;


            }

             after(grammarAccess.getInOutputSignalsAccess().getSignalsAssignment_0_0()); 

            }

            pushFollow(FOLLOW_rule__InOutputSignals__Group_0__1_in_rule__InOutputSignals__Group_0__03547);
            rule__InOutputSignals__Group_0__1();
            _fsp--;


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
    // $ANTLR end rule__InOutputSignals__Group_0__0


    // $ANTLR start rule__InOutputSignals__Group_0__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1766:1: rule__InOutputSignals__Group_0__1 : ( ( rule__InOutputSignals__Group_0_1__0 )* ) ;
    public final void rule__InOutputSignals__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1770:1: ( ( ( rule__InOutputSignals__Group_0_1__0 )* ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1771:1: ( ( rule__InOutputSignals__Group_0_1__0 )* )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1771:1: ( ( rule__InOutputSignals__Group_0_1__0 )* )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1772:1: ( rule__InOutputSignals__Group_0_1__0 )*
            {
             before(grammarAccess.getInOutputSignalsAccess().getGroup_0_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1773:1: ( rule__InOutputSignals__Group_0_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==31) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1773:2: rule__InOutputSignals__Group_0_1__0
            	    {
            	    pushFollow(FOLLOW_rule__InOutputSignals__Group_0_1__0_in_rule__InOutputSignals__Group_0__13575);
            	    rule__InOutputSignals__Group_0_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getInOutputSignalsAccess().getGroup_0_1()); 

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
    // $ANTLR end rule__InOutputSignals__Group_0__1


    // $ANTLR start rule__InOutputSignals__Group_0_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1787:1: rule__InOutputSignals__Group_0_1__0 : ( ',' ) rule__InOutputSignals__Group_0_1__1 ;
    public final void rule__InOutputSignals__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1791:1: ( ( ',' ) rule__InOutputSignals__Group_0_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1792:1: ( ',' ) rule__InOutputSignals__Group_0_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1792:1: ( ',' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1793:1: ','
            {
             before(grammarAccess.getInOutputSignalsAccess().getCommaKeyword_0_1_0()); 
            match(input,31,FOLLOW_31_in_rule__InOutputSignals__Group_0_1__03615); 
             after(grammarAccess.getInOutputSignalsAccess().getCommaKeyword_0_1_0()); 

            }

            pushFollow(FOLLOW_rule__InOutputSignals__Group_0_1__1_in_rule__InOutputSignals__Group_0_1__03625);
            rule__InOutputSignals__Group_0_1__1();
            _fsp--;


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
    // $ANTLR end rule__InOutputSignals__Group_0_1__0


    // $ANTLR start rule__InOutputSignals__Group_0_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1807:1: rule__InOutputSignals__Group_0_1__1 : ( ( rule__InOutputSignals__SignalsAssignment_0_1_1 ) ) ;
    public final void rule__InOutputSignals__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1811:1: ( ( ( rule__InOutputSignals__SignalsAssignment_0_1_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1812:1: ( ( rule__InOutputSignals__SignalsAssignment_0_1_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1812:1: ( ( rule__InOutputSignals__SignalsAssignment_0_1_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1813:1: ( rule__InOutputSignals__SignalsAssignment_0_1_1 )
            {
             before(grammarAccess.getInOutputSignalsAccess().getSignalsAssignment_0_1_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1814:1: ( rule__InOutputSignals__SignalsAssignment_0_1_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1814:2: rule__InOutputSignals__SignalsAssignment_0_1_1
            {
            pushFollow(FOLLOW_rule__InOutputSignals__SignalsAssignment_0_1_1_in_rule__InOutputSignals__Group_0_1__13653);
            rule__InOutputSignals__SignalsAssignment_0_1_1();
            _fsp--;


            }

             after(grammarAccess.getInOutputSignalsAccess().getSignalsAssignment_0_1_1()); 

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
    // $ANTLR end rule__InOutputSignals__Group_0_1__1


    // $ANTLR start rule__Signal__Group_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1828:1: rule__Signal__Group_1__0 : ( ( rule__Signal__NameAssignment_1_0 ) ) rule__Signal__Group_1__1 ;
    public final void rule__Signal__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1832:1: ( ( ( rule__Signal__NameAssignment_1_0 ) ) rule__Signal__Group_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1833:1: ( ( rule__Signal__NameAssignment_1_0 ) ) rule__Signal__Group_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1833:1: ( ( rule__Signal__NameAssignment_1_0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1834:1: ( rule__Signal__NameAssignment_1_0 )
            {
             before(grammarAccess.getSignalAccess().getNameAssignment_1_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1835:1: ( rule__Signal__NameAssignment_1_0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1835:2: rule__Signal__NameAssignment_1_0
            {
            pushFollow(FOLLOW_rule__Signal__NameAssignment_1_0_in_rule__Signal__Group_1__03691);
            rule__Signal__NameAssignment_1_0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getNameAssignment_1_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_1__1_in_rule__Signal__Group_1__03700);
            rule__Signal__Group_1__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_1__0


    // $ANTLR start rule__Signal__Group_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1846:1: rule__Signal__Group_1__1 : ( ':' ) rule__Signal__Group_1__2 ;
    public final void rule__Signal__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1850:1: ( ( ':' ) rule__Signal__Group_1__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1851:1: ( ':' ) rule__Signal__Group_1__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1851:1: ( ':' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1852:1: ':'
            {
             before(grammarAccess.getSignalAccess().getColonKeyword_1_1()); 
            match(input,28,FOLLOW_28_in_rule__Signal__Group_1__13729); 
             after(grammarAccess.getSignalAccess().getColonKeyword_1_1()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_1__2_in_rule__Signal__Group_1__13739);
            rule__Signal__Group_1__2();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_1__1


    // $ANTLR start rule__Signal__Group_1__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1866:1: rule__Signal__Group_1__2 : ( ( rule__Signal__TypeAssignment_1_2 ) ) ;
    public final void rule__Signal__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1870:1: ( ( ( rule__Signal__TypeAssignment_1_2 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1871:1: ( ( rule__Signal__TypeAssignment_1_2 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1871:1: ( ( rule__Signal__TypeAssignment_1_2 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1872:1: ( rule__Signal__TypeAssignment_1_2 )
            {
             before(grammarAccess.getSignalAccess().getTypeAssignment_1_2()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1873:1: ( rule__Signal__TypeAssignment_1_2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1873:2: rule__Signal__TypeAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Signal__TypeAssignment_1_2_in_rule__Signal__Group_1__23767);
            rule__Signal__TypeAssignment_1_2();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getTypeAssignment_1_2()); 

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
    // $ANTLR end rule__Signal__Group_1__2


    // $ANTLR start rule__Signal__Group_2__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1889:1: rule__Signal__Group_2__0 : ( ( rule__Signal__NameAssignment_2_0 ) ) rule__Signal__Group_2__1 ;
    public final void rule__Signal__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1893:1: ( ( ( rule__Signal__NameAssignment_2_0 ) ) rule__Signal__Group_2__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1894:1: ( ( rule__Signal__NameAssignment_2_0 ) ) rule__Signal__Group_2__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1894:1: ( ( rule__Signal__NameAssignment_2_0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1895:1: ( rule__Signal__NameAssignment_2_0 )
            {
             before(grammarAccess.getSignalAccess().getNameAssignment_2_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1896:1: ( rule__Signal__NameAssignment_2_0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1896:2: rule__Signal__NameAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Signal__NameAssignment_2_0_in_rule__Signal__Group_2__03807);
            rule__Signal__NameAssignment_2_0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getNameAssignment_2_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_2__1_in_rule__Signal__Group_2__03816);
            rule__Signal__Group_2__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_2__0


    // $ANTLR start rule__Signal__Group_2__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1907:1: rule__Signal__Group_2__1 : ( ( rule__Signal__Group_2_1__0 ) ) ;
    public final void rule__Signal__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1911:1: ( ( ( rule__Signal__Group_2_1__0 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1912:1: ( ( rule__Signal__Group_2_1__0 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1912:1: ( ( rule__Signal__Group_2_1__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1913:1: ( rule__Signal__Group_2_1__0 )
            {
             before(grammarAccess.getSignalAccess().getGroup_2_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1914:1: ( rule__Signal__Group_2_1__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1914:2: rule__Signal__Group_2_1__0
            {
            pushFollow(FOLLOW_rule__Signal__Group_2_1__0_in_rule__Signal__Group_2__13844);
            rule__Signal__Group_2_1__0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getGroup_2_1()); 

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
    // $ANTLR end rule__Signal__Group_2__1


    // $ANTLR start rule__Signal__Group_2_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1928:1: rule__Signal__Group_2_1__0 : ( ':=' ) rule__Signal__Group_2_1__1 ;
    public final void rule__Signal__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1932:1: ( ( ':=' ) rule__Signal__Group_2_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1933:1: ( ':=' ) rule__Signal__Group_2_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1933:1: ( ':=' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1934:1: ':='
            {
             before(grammarAccess.getSignalAccess().getColonEqualsSignKeyword_2_1_0()); 
            match(input,32,FOLLOW_32_in_rule__Signal__Group_2_1__03883); 
             after(grammarAccess.getSignalAccess().getColonEqualsSignKeyword_2_1_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_2_1__1_in_rule__Signal__Group_2_1__03893);
            rule__Signal__Group_2_1__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_2_1__0


    // $ANTLR start rule__Signal__Group_2_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1948:1: rule__Signal__Group_2_1__1 : ( ( rule__Signal__InitialValueAssignment_2_1_1 ) ) ;
    public final void rule__Signal__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1952:1: ( ( ( rule__Signal__InitialValueAssignment_2_1_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1953:1: ( ( rule__Signal__InitialValueAssignment_2_1_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1953:1: ( ( rule__Signal__InitialValueAssignment_2_1_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1954:1: ( rule__Signal__InitialValueAssignment_2_1_1 )
            {
             before(grammarAccess.getSignalAccess().getInitialValueAssignment_2_1_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1955:1: ( rule__Signal__InitialValueAssignment_2_1_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1955:2: rule__Signal__InitialValueAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__Signal__InitialValueAssignment_2_1_1_in_rule__Signal__Group_2_1__13921);
            rule__Signal__InitialValueAssignment_2_1_1();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getInitialValueAssignment_2_1_1()); 

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
    // $ANTLR end rule__Signal__Group_2_1__1


    // $ANTLR start rule__Signal__Group_3__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1969:1: rule__Signal__Group_3__0 : ( ( rule__Signal__NameAssignment_3_0 ) ) rule__Signal__Group_3__1 ;
    public final void rule__Signal__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1973:1: ( ( ( rule__Signal__NameAssignment_3_0 ) ) rule__Signal__Group_3__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1974:1: ( ( rule__Signal__NameAssignment_3_0 ) ) rule__Signal__Group_3__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1974:1: ( ( rule__Signal__NameAssignment_3_0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1975:1: ( rule__Signal__NameAssignment_3_0 )
            {
             before(grammarAccess.getSignalAccess().getNameAssignment_3_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1976:1: ( rule__Signal__NameAssignment_3_0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1976:2: rule__Signal__NameAssignment_3_0
            {
            pushFollow(FOLLOW_rule__Signal__NameAssignment_3_0_in_rule__Signal__Group_3__03959);
            rule__Signal__NameAssignment_3_0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getNameAssignment_3_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_3__1_in_rule__Signal__Group_3__03968);
            rule__Signal__Group_3__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_3__0


    // $ANTLR start rule__Signal__Group_3__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1987:1: rule__Signal__Group_3__1 : ( ( rule__Signal__Group_3_1__0 ) ) rule__Signal__Group_3__2 ;
    public final void rule__Signal__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1991:1: ( ( ( rule__Signal__Group_3_1__0 ) ) rule__Signal__Group_3__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1992:1: ( ( rule__Signal__Group_3_1__0 ) ) rule__Signal__Group_3__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1992:1: ( ( rule__Signal__Group_3_1__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1993:1: ( rule__Signal__Group_3_1__0 )
            {
             before(grammarAccess.getSignalAccess().getGroup_3_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1994:1: ( rule__Signal__Group_3_1__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:1994:2: rule__Signal__Group_3_1__0
            {
            pushFollow(FOLLOW_rule__Signal__Group_3_1__0_in_rule__Signal__Group_3__13996);
            rule__Signal__Group_3_1__0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getGroup_3_1()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_3__2_in_rule__Signal__Group_3__14005);
            rule__Signal__Group_3__2();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_3__1


    // $ANTLR start rule__Signal__Group_3__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2005:1: rule__Signal__Group_3__2 : ( ':' ) rule__Signal__Group_3__3 ;
    public final void rule__Signal__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2009:1: ( ( ':' ) rule__Signal__Group_3__3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2010:1: ( ':' ) rule__Signal__Group_3__3
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2010:1: ( ':' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2011:1: ':'
            {
             before(grammarAccess.getSignalAccess().getColonKeyword_3_2()); 
            match(input,28,FOLLOW_28_in_rule__Signal__Group_3__24034); 
             after(grammarAccess.getSignalAccess().getColonKeyword_3_2()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_3__3_in_rule__Signal__Group_3__24044);
            rule__Signal__Group_3__3();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_3__2


    // $ANTLR start rule__Signal__Group_3__3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2025:1: rule__Signal__Group_3__3 : ( ( rule__Signal__TypeAssignment_3_3 ) ) ;
    public final void rule__Signal__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2029:1: ( ( ( rule__Signal__TypeAssignment_3_3 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2030:1: ( ( rule__Signal__TypeAssignment_3_3 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2030:1: ( ( rule__Signal__TypeAssignment_3_3 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2031:1: ( rule__Signal__TypeAssignment_3_3 )
            {
             before(grammarAccess.getSignalAccess().getTypeAssignment_3_3()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2032:1: ( rule__Signal__TypeAssignment_3_3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2032:2: rule__Signal__TypeAssignment_3_3
            {
            pushFollow(FOLLOW_rule__Signal__TypeAssignment_3_3_in_rule__Signal__Group_3__34072);
            rule__Signal__TypeAssignment_3_3();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getTypeAssignment_3_3()); 

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
    // $ANTLR end rule__Signal__Group_3__3


    // $ANTLR start rule__Signal__Group_3_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2050:1: rule__Signal__Group_3_1__0 : ( ':=' ) rule__Signal__Group_3_1__1 ;
    public final void rule__Signal__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2054:1: ( ( ':=' ) rule__Signal__Group_3_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2055:1: ( ':=' ) rule__Signal__Group_3_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2055:1: ( ':=' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2056:1: ':='
            {
             before(grammarAccess.getSignalAccess().getColonEqualsSignKeyword_3_1_0()); 
            match(input,32,FOLLOW_32_in_rule__Signal__Group_3_1__04115); 
             after(grammarAccess.getSignalAccess().getColonEqualsSignKeyword_3_1_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_3_1__1_in_rule__Signal__Group_3_1__04125);
            rule__Signal__Group_3_1__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_3_1__0


    // $ANTLR start rule__Signal__Group_3_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2070:1: rule__Signal__Group_3_1__1 : ( ( rule__Signal__InitialValueAssignment_3_1_1 ) ) ;
    public final void rule__Signal__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2074:1: ( ( ( rule__Signal__InitialValueAssignment_3_1_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2075:1: ( ( rule__Signal__InitialValueAssignment_3_1_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2075:1: ( ( rule__Signal__InitialValueAssignment_3_1_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2076:1: ( rule__Signal__InitialValueAssignment_3_1_1 )
            {
             before(grammarAccess.getSignalAccess().getInitialValueAssignment_3_1_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2077:1: ( rule__Signal__InitialValueAssignment_3_1_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2077:2: rule__Signal__InitialValueAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__Signal__InitialValueAssignment_3_1_1_in_rule__Signal__Group_3_1__14153);
            rule__Signal__InitialValueAssignment_3_1_1();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getInitialValueAssignment_3_1_1()); 

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
    // $ANTLR end rule__Signal__Group_3_1__1


    // $ANTLR start rule__Signal__Group_4__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2091:1: rule__Signal__Group_4__0 : ( ( rule__Signal__NameAssignment_4_0 ) ) rule__Signal__Group_4__1 ;
    public final void rule__Signal__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2095:1: ( ( ( rule__Signal__NameAssignment_4_0 ) ) rule__Signal__Group_4__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2096:1: ( ( rule__Signal__NameAssignment_4_0 ) ) rule__Signal__Group_4__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2096:1: ( ( rule__Signal__NameAssignment_4_0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2097:1: ( rule__Signal__NameAssignment_4_0 )
            {
             before(grammarAccess.getSignalAccess().getNameAssignment_4_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2098:1: ( rule__Signal__NameAssignment_4_0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2098:2: rule__Signal__NameAssignment_4_0
            {
            pushFollow(FOLLOW_rule__Signal__NameAssignment_4_0_in_rule__Signal__Group_4__04191);
            rule__Signal__NameAssignment_4_0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getNameAssignment_4_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_4__1_in_rule__Signal__Group_4__04200);
            rule__Signal__Group_4__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_4__0


    // $ANTLR start rule__Signal__Group_4__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2109:1: rule__Signal__Group_4__1 : ( ( rule__Signal__Group_4_1__0 ) ) rule__Signal__Group_4__2 ;
    public final void rule__Signal__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2113:1: ( ( ( rule__Signal__Group_4_1__0 ) ) rule__Signal__Group_4__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2114:1: ( ( rule__Signal__Group_4_1__0 ) ) rule__Signal__Group_4__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2114:1: ( ( rule__Signal__Group_4_1__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2115:1: ( rule__Signal__Group_4_1__0 )
            {
             before(grammarAccess.getSignalAccess().getGroup_4_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2116:1: ( rule__Signal__Group_4_1__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2116:2: rule__Signal__Group_4_1__0
            {
            pushFollow(FOLLOW_rule__Signal__Group_4_1__0_in_rule__Signal__Group_4__14228);
            rule__Signal__Group_4_1__0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getGroup_4_1()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_4__2_in_rule__Signal__Group_4__14237);
            rule__Signal__Group_4__2();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_4__1


    // $ANTLR start rule__Signal__Group_4__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2127:1: rule__Signal__Group_4__2 : ( ( rule__Signal__Group_4_2__0 ) ) ;
    public final void rule__Signal__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2131:1: ( ( ( rule__Signal__Group_4_2__0 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2132:1: ( ( rule__Signal__Group_4_2__0 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2132:1: ( ( rule__Signal__Group_4_2__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2133:1: ( rule__Signal__Group_4_2__0 )
            {
             before(grammarAccess.getSignalAccess().getGroup_4_2()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2134:1: ( rule__Signal__Group_4_2__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2134:2: rule__Signal__Group_4_2__0
            {
            pushFollow(FOLLOW_rule__Signal__Group_4_2__0_in_rule__Signal__Group_4__24265);
            rule__Signal__Group_4_2__0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getGroup_4_2()); 

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
    // $ANTLR end rule__Signal__Group_4__2


    // $ANTLR start rule__Signal__Group_4_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2150:1: rule__Signal__Group_4_1__0 : ( ':=' ) rule__Signal__Group_4_1__1 ;
    public final void rule__Signal__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2154:1: ( ( ':=' ) rule__Signal__Group_4_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2155:1: ( ':=' ) rule__Signal__Group_4_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2155:1: ( ':=' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2156:1: ':='
            {
             before(grammarAccess.getSignalAccess().getColonEqualsSignKeyword_4_1_0()); 
            match(input,32,FOLLOW_32_in_rule__Signal__Group_4_1__04306); 
             after(grammarAccess.getSignalAccess().getColonEqualsSignKeyword_4_1_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_4_1__1_in_rule__Signal__Group_4_1__04316);
            rule__Signal__Group_4_1__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_4_1__0


    // $ANTLR start rule__Signal__Group_4_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2170:1: rule__Signal__Group_4_1__1 : ( ( rule__Signal__InitialValueAssignment_4_1_1 ) ) ;
    public final void rule__Signal__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2174:1: ( ( ( rule__Signal__InitialValueAssignment_4_1_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2175:1: ( ( rule__Signal__InitialValueAssignment_4_1_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2175:1: ( ( rule__Signal__InitialValueAssignment_4_1_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2176:1: ( rule__Signal__InitialValueAssignment_4_1_1 )
            {
             before(grammarAccess.getSignalAccess().getInitialValueAssignment_4_1_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2177:1: ( rule__Signal__InitialValueAssignment_4_1_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2177:2: rule__Signal__InitialValueAssignment_4_1_1
            {
            pushFollow(FOLLOW_rule__Signal__InitialValueAssignment_4_1_1_in_rule__Signal__Group_4_1__14344);
            rule__Signal__InitialValueAssignment_4_1_1();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getInitialValueAssignment_4_1_1()); 

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
    // $ANTLR end rule__Signal__Group_4_1__1


    // $ANTLR start rule__Signal__Group_4_2__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2191:1: rule__Signal__Group_4_2__0 : ( 'combine' ) rule__Signal__Group_4_2__1 ;
    public final void rule__Signal__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2195:1: ( ( 'combine' ) rule__Signal__Group_4_2__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2196:1: ( 'combine' ) rule__Signal__Group_4_2__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2196:1: ( 'combine' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2197:1: 'combine'
            {
             before(grammarAccess.getSignalAccess().getCombineKeyword_4_2_0()); 
            match(input,33,FOLLOW_33_in_rule__Signal__Group_4_2__04383); 
             after(grammarAccess.getSignalAccess().getCombineKeyword_4_2_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_4_2__1_in_rule__Signal__Group_4_2__04393);
            rule__Signal__Group_4_2__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_4_2__0


    // $ANTLR start rule__Signal__Group_4_2__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2211:1: rule__Signal__Group_4_2__1 : ( ( rule__Signal__TypeAssignment_4_2_1 ) ) rule__Signal__Group_4_2__2 ;
    public final void rule__Signal__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2215:1: ( ( ( rule__Signal__TypeAssignment_4_2_1 ) ) rule__Signal__Group_4_2__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2216:1: ( ( rule__Signal__TypeAssignment_4_2_1 ) ) rule__Signal__Group_4_2__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2216:1: ( ( rule__Signal__TypeAssignment_4_2_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2217:1: ( rule__Signal__TypeAssignment_4_2_1 )
            {
             before(grammarAccess.getSignalAccess().getTypeAssignment_4_2_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2218:1: ( rule__Signal__TypeAssignment_4_2_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2218:2: rule__Signal__TypeAssignment_4_2_1
            {
            pushFollow(FOLLOW_rule__Signal__TypeAssignment_4_2_1_in_rule__Signal__Group_4_2__14421);
            rule__Signal__TypeAssignment_4_2_1();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getTypeAssignment_4_2_1()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_4_2__2_in_rule__Signal__Group_4_2__14430);
            rule__Signal__Group_4_2__2();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_4_2__1


    // $ANTLR start rule__Signal__Group_4_2__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2229:1: rule__Signal__Group_4_2__2 : ( 'with' ) rule__Signal__Group_4_2__3 ;
    public final void rule__Signal__Group_4_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2233:1: ( ( 'with' ) rule__Signal__Group_4_2__3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2234:1: ( 'with' ) rule__Signal__Group_4_2__3
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2234:1: ( 'with' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2235:1: 'with'
            {
             before(grammarAccess.getSignalAccess().getWithKeyword_4_2_2()); 
            match(input,34,FOLLOW_34_in_rule__Signal__Group_4_2__24459); 
             after(grammarAccess.getSignalAccess().getWithKeyword_4_2_2()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_4_2__3_in_rule__Signal__Group_4_2__24469);
            rule__Signal__Group_4_2__3();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_4_2__2


    // $ANTLR start rule__Signal__Group_4_2__3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2249:1: rule__Signal__Group_4_2__3 : ( ( rule__Signal__CombineOperatorAssignment_4_2_3 ) ) ;
    public final void rule__Signal__Group_4_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2253:1: ( ( ( rule__Signal__CombineOperatorAssignment_4_2_3 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2254:1: ( ( rule__Signal__CombineOperatorAssignment_4_2_3 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2254:1: ( ( rule__Signal__CombineOperatorAssignment_4_2_3 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2255:1: ( rule__Signal__CombineOperatorAssignment_4_2_3 )
            {
             before(grammarAccess.getSignalAccess().getCombineOperatorAssignment_4_2_3()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2256:1: ( rule__Signal__CombineOperatorAssignment_4_2_3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2256:2: rule__Signal__CombineOperatorAssignment_4_2_3
            {
            pushFollow(FOLLOW_rule__Signal__CombineOperatorAssignment_4_2_3_in_rule__Signal__Group_4_2__34497);
            rule__Signal__CombineOperatorAssignment_4_2_3();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getCombineOperatorAssignment_4_2_3()); 

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
    // $ANTLR end rule__Signal__Group_4_2__3


    // $ANTLR start rule__Signal__Group_5__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2274:1: rule__Signal__Group_5__0 : ( ( rule__Signal__NameAssignment_5_0 ) ) rule__Signal__Group_5__1 ;
    public final void rule__Signal__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2278:1: ( ( ( rule__Signal__NameAssignment_5_0 ) ) rule__Signal__Group_5__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2279:1: ( ( rule__Signal__NameAssignment_5_0 ) ) rule__Signal__Group_5__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2279:1: ( ( rule__Signal__NameAssignment_5_0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2280:1: ( rule__Signal__NameAssignment_5_0 )
            {
             before(grammarAccess.getSignalAccess().getNameAssignment_5_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2281:1: ( rule__Signal__NameAssignment_5_0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2281:2: rule__Signal__NameAssignment_5_0
            {
            pushFollow(FOLLOW_rule__Signal__NameAssignment_5_0_in_rule__Signal__Group_5__04539);
            rule__Signal__NameAssignment_5_0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getNameAssignment_5_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_5__1_in_rule__Signal__Group_5__04548);
            rule__Signal__Group_5__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_5__0


    // $ANTLR start rule__Signal__Group_5__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2292:1: rule__Signal__Group_5__1 : ( ':' ) rule__Signal__Group_5__2 ;
    public final void rule__Signal__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2296:1: ( ( ':' ) rule__Signal__Group_5__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2297:1: ( ':' ) rule__Signal__Group_5__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2297:1: ( ':' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2298:1: ':'
            {
             before(grammarAccess.getSignalAccess().getColonKeyword_5_1()); 
            match(input,28,FOLLOW_28_in_rule__Signal__Group_5__14577); 
             after(grammarAccess.getSignalAccess().getColonKeyword_5_1()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_5__2_in_rule__Signal__Group_5__14587);
            rule__Signal__Group_5__2();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_5__1


    // $ANTLR start rule__Signal__Group_5__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2312:1: rule__Signal__Group_5__2 : ( ( rule__Signal__HostTypeAssignment_5_2 ) ) ;
    public final void rule__Signal__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2316:1: ( ( ( rule__Signal__HostTypeAssignment_5_2 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2317:1: ( ( rule__Signal__HostTypeAssignment_5_2 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2317:1: ( ( rule__Signal__HostTypeAssignment_5_2 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2318:1: ( rule__Signal__HostTypeAssignment_5_2 )
            {
             before(grammarAccess.getSignalAccess().getHostTypeAssignment_5_2()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2319:1: ( rule__Signal__HostTypeAssignment_5_2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2319:2: rule__Signal__HostTypeAssignment_5_2
            {
            pushFollow(FOLLOW_rule__Signal__HostTypeAssignment_5_2_in_rule__Signal__Group_5__24615);
            rule__Signal__HostTypeAssignment_5_2();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getHostTypeAssignment_5_2()); 

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
    // $ANTLR end rule__Signal__Group_5__2


    // $ANTLR start rule__Signal__Group_6__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2335:1: rule__Signal__Group_6__0 : ( ( rule__Signal__NameAssignment_6_0 ) ) rule__Signal__Group_6__1 ;
    public final void rule__Signal__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2339:1: ( ( ( rule__Signal__NameAssignment_6_0 ) ) rule__Signal__Group_6__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2340:1: ( ( rule__Signal__NameAssignment_6_0 ) ) rule__Signal__Group_6__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2340:1: ( ( rule__Signal__NameAssignment_6_0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2341:1: ( rule__Signal__NameAssignment_6_0 )
            {
             before(grammarAccess.getSignalAccess().getNameAssignment_6_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2342:1: ( rule__Signal__NameAssignment_6_0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2342:2: rule__Signal__NameAssignment_6_0
            {
            pushFollow(FOLLOW_rule__Signal__NameAssignment_6_0_in_rule__Signal__Group_6__04655);
            rule__Signal__NameAssignment_6_0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getNameAssignment_6_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_6__1_in_rule__Signal__Group_6__04664);
            rule__Signal__Group_6__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_6__0


    // $ANTLR start rule__Signal__Group_6__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2353:1: rule__Signal__Group_6__1 : ( ( rule__Signal__Group_6_1__0 ) ) rule__Signal__Group_6__2 ;
    public final void rule__Signal__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2357:1: ( ( ( rule__Signal__Group_6_1__0 ) ) rule__Signal__Group_6__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2358:1: ( ( rule__Signal__Group_6_1__0 ) ) rule__Signal__Group_6__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2358:1: ( ( rule__Signal__Group_6_1__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2359:1: ( rule__Signal__Group_6_1__0 )
            {
             before(grammarAccess.getSignalAccess().getGroup_6_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2360:1: ( rule__Signal__Group_6_1__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2360:2: rule__Signal__Group_6_1__0
            {
            pushFollow(FOLLOW_rule__Signal__Group_6_1__0_in_rule__Signal__Group_6__14692);
            rule__Signal__Group_6_1__0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getGroup_6_1()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_6__2_in_rule__Signal__Group_6__14701);
            rule__Signal__Group_6__2();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_6__1


    // $ANTLR start rule__Signal__Group_6__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2371:1: rule__Signal__Group_6__2 : ( ':' ) rule__Signal__Group_6__3 ;
    public final void rule__Signal__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2375:1: ( ( ':' ) rule__Signal__Group_6__3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2376:1: ( ':' ) rule__Signal__Group_6__3
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2376:1: ( ':' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2377:1: ':'
            {
             before(grammarAccess.getSignalAccess().getColonKeyword_6_2()); 
            match(input,28,FOLLOW_28_in_rule__Signal__Group_6__24730); 
             after(grammarAccess.getSignalAccess().getColonKeyword_6_2()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_6__3_in_rule__Signal__Group_6__24740);
            rule__Signal__Group_6__3();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_6__2


    // $ANTLR start rule__Signal__Group_6__3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2391:1: rule__Signal__Group_6__3 : ( ( rule__Signal__HostTypeAssignment_6_3 ) ) ;
    public final void rule__Signal__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2395:1: ( ( ( rule__Signal__HostTypeAssignment_6_3 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2396:1: ( ( rule__Signal__HostTypeAssignment_6_3 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2396:1: ( ( rule__Signal__HostTypeAssignment_6_3 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2397:1: ( rule__Signal__HostTypeAssignment_6_3 )
            {
             before(grammarAccess.getSignalAccess().getHostTypeAssignment_6_3()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2398:1: ( rule__Signal__HostTypeAssignment_6_3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2398:2: rule__Signal__HostTypeAssignment_6_3
            {
            pushFollow(FOLLOW_rule__Signal__HostTypeAssignment_6_3_in_rule__Signal__Group_6__34768);
            rule__Signal__HostTypeAssignment_6_3();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getHostTypeAssignment_6_3()); 

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
    // $ANTLR end rule__Signal__Group_6__3


    // $ANTLR start rule__Signal__Group_6_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2416:1: rule__Signal__Group_6_1__0 : ( ':=' ) rule__Signal__Group_6_1__1 ;
    public final void rule__Signal__Group_6_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2420:1: ( ( ':=' ) rule__Signal__Group_6_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2421:1: ( ':=' ) rule__Signal__Group_6_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2421:1: ( ':=' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2422:1: ':='
            {
             before(grammarAccess.getSignalAccess().getColonEqualsSignKeyword_6_1_0()); 
            match(input,32,FOLLOW_32_in_rule__Signal__Group_6_1__04811); 
             after(grammarAccess.getSignalAccess().getColonEqualsSignKeyword_6_1_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_6_1__1_in_rule__Signal__Group_6_1__04821);
            rule__Signal__Group_6_1__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_6_1__0


    // $ANTLR start rule__Signal__Group_6_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2436:1: rule__Signal__Group_6_1__1 : ( ( rule__Signal__InitialValueAssignment_6_1_1 ) ) ;
    public final void rule__Signal__Group_6_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2440:1: ( ( ( rule__Signal__InitialValueAssignment_6_1_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2441:1: ( ( rule__Signal__InitialValueAssignment_6_1_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2441:1: ( ( rule__Signal__InitialValueAssignment_6_1_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2442:1: ( rule__Signal__InitialValueAssignment_6_1_1 )
            {
             before(grammarAccess.getSignalAccess().getInitialValueAssignment_6_1_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2443:1: ( rule__Signal__InitialValueAssignment_6_1_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2443:2: rule__Signal__InitialValueAssignment_6_1_1
            {
            pushFollow(FOLLOW_rule__Signal__InitialValueAssignment_6_1_1_in_rule__Signal__Group_6_1__14849);
            rule__Signal__InitialValueAssignment_6_1_1();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getInitialValueAssignment_6_1_1()); 

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
    // $ANTLR end rule__Signal__Group_6_1__1


    // $ANTLR start rule__Signal__Group_7__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2457:1: rule__Signal__Group_7__0 : ( ( rule__Signal__NameAssignment_7_0 ) ) rule__Signal__Group_7__1 ;
    public final void rule__Signal__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2461:1: ( ( ( rule__Signal__NameAssignment_7_0 ) ) rule__Signal__Group_7__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2462:1: ( ( rule__Signal__NameAssignment_7_0 ) ) rule__Signal__Group_7__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2462:1: ( ( rule__Signal__NameAssignment_7_0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2463:1: ( rule__Signal__NameAssignment_7_0 )
            {
             before(grammarAccess.getSignalAccess().getNameAssignment_7_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2464:1: ( rule__Signal__NameAssignment_7_0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2464:2: rule__Signal__NameAssignment_7_0
            {
            pushFollow(FOLLOW_rule__Signal__NameAssignment_7_0_in_rule__Signal__Group_7__04887);
            rule__Signal__NameAssignment_7_0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getNameAssignment_7_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_7__1_in_rule__Signal__Group_7__04896);
            rule__Signal__Group_7__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_7__0


    // $ANTLR start rule__Signal__Group_7__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2475:1: rule__Signal__Group_7__1 : ( ( rule__Signal__Group_7_1__0 ) ) rule__Signal__Group_7__2 ;
    public final void rule__Signal__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2479:1: ( ( ( rule__Signal__Group_7_1__0 ) ) rule__Signal__Group_7__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2480:1: ( ( rule__Signal__Group_7_1__0 ) ) rule__Signal__Group_7__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2480:1: ( ( rule__Signal__Group_7_1__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2481:1: ( rule__Signal__Group_7_1__0 )
            {
             before(grammarAccess.getSignalAccess().getGroup_7_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2482:1: ( rule__Signal__Group_7_1__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2482:2: rule__Signal__Group_7_1__0
            {
            pushFollow(FOLLOW_rule__Signal__Group_7_1__0_in_rule__Signal__Group_7__14924);
            rule__Signal__Group_7_1__0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getGroup_7_1()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_7__2_in_rule__Signal__Group_7__14933);
            rule__Signal__Group_7__2();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_7__1


    // $ANTLR start rule__Signal__Group_7__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2493:1: rule__Signal__Group_7__2 : ( ( rule__Signal__Group_7_2__0 ) ) ;
    public final void rule__Signal__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2497:1: ( ( ( rule__Signal__Group_7_2__0 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2498:1: ( ( rule__Signal__Group_7_2__0 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2498:1: ( ( rule__Signal__Group_7_2__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2499:1: ( rule__Signal__Group_7_2__0 )
            {
             before(grammarAccess.getSignalAccess().getGroup_7_2()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2500:1: ( rule__Signal__Group_7_2__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2500:2: rule__Signal__Group_7_2__0
            {
            pushFollow(FOLLOW_rule__Signal__Group_7_2__0_in_rule__Signal__Group_7__24961);
            rule__Signal__Group_7_2__0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getGroup_7_2()); 

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
    // $ANTLR end rule__Signal__Group_7__2


    // $ANTLR start rule__Signal__Group_7_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2516:1: rule__Signal__Group_7_1__0 : ( ':=' ) rule__Signal__Group_7_1__1 ;
    public final void rule__Signal__Group_7_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2520:1: ( ( ':=' ) rule__Signal__Group_7_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2521:1: ( ':=' ) rule__Signal__Group_7_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2521:1: ( ':=' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2522:1: ':='
            {
             before(grammarAccess.getSignalAccess().getColonEqualsSignKeyword_7_1_0()); 
            match(input,32,FOLLOW_32_in_rule__Signal__Group_7_1__05002); 
             after(grammarAccess.getSignalAccess().getColonEqualsSignKeyword_7_1_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_7_1__1_in_rule__Signal__Group_7_1__05012);
            rule__Signal__Group_7_1__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_7_1__0


    // $ANTLR start rule__Signal__Group_7_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2536:1: rule__Signal__Group_7_1__1 : ( ( rule__Signal__InitialValueAssignment_7_1_1 ) ) ;
    public final void rule__Signal__Group_7_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2540:1: ( ( ( rule__Signal__InitialValueAssignment_7_1_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2541:1: ( ( rule__Signal__InitialValueAssignment_7_1_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2541:1: ( ( rule__Signal__InitialValueAssignment_7_1_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2542:1: ( rule__Signal__InitialValueAssignment_7_1_1 )
            {
             before(grammarAccess.getSignalAccess().getInitialValueAssignment_7_1_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2543:1: ( rule__Signal__InitialValueAssignment_7_1_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2543:2: rule__Signal__InitialValueAssignment_7_1_1
            {
            pushFollow(FOLLOW_rule__Signal__InitialValueAssignment_7_1_1_in_rule__Signal__Group_7_1__15040);
            rule__Signal__InitialValueAssignment_7_1_1();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getInitialValueAssignment_7_1_1()); 

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
    // $ANTLR end rule__Signal__Group_7_1__1


    // $ANTLR start rule__Signal__Group_7_2__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2557:1: rule__Signal__Group_7_2__0 : ( 'combine' ) rule__Signal__Group_7_2__1 ;
    public final void rule__Signal__Group_7_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2561:1: ( ( 'combine' ) rule__Signal__Group_7_2__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2562:1: ( 'combine' ) rule__Signal__Group_7_2__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2562:1: ( 'combine' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2563:1: 'combine'
            {
             before(grammarAccess.getSignalAccess().getCombineKeyword_7_2_0()); 
            match(input,33,FOLLOW_33_in_rule__Signal__Group_7_2__05079); 
             after(grammarAccess.getSignalAccess().getCombineKeyword_7_2_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_7_2__1_in_rule__Signal__Group_7_2__05089);
            rule__Signal__Group_7_2__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_7_2__0


    // $ANTLR start rule__Signal__Group_7_2__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2577:1: rule__Signal__Group_7_2__1 : ( ( rule__Signal__HostTypeAssignment_7_2_1 ) ) rule__Signal__Group_7_2__2 ;
    public final void rule__Signal__Group_7_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2581:1: ( ( ( rule__Signal__HostTypeAssignment_7_2_1 ) ) rule__Signal__Group_7_2__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2582:1: ( ( rule__Signal__HostTypeAssignment_7_2_1 ) ) rule__Signal__Group_7_2__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2582:1: ( ( rule__Signal__HostTypeAssignment_7_2_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2583:1: ( rule__Signal__HostTypeAssignment_7_2_1 )
            {
             before(grammarAccess.getSignalAccess().getHostTypeAssignment_7_2_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2584:1: ( rule__Signal__HostTypeAssignment_7_2_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2584:2: rule__Signal__HostTypeAssignment_7_2_1
            {
            pushFollow(FOLLOW_rule__Signal__HostTypeAssignment_7_2_1_in_rule__Signal__Group_7_2__15117);
            rule__Signal__HostTypeAssignment_7_2_1();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getHostTypeAssignment_7_2_1()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_7_2__2_in_rule__Signal__Group_7_2__15126);
            rule__Signal__Group_7_2__2();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_7_2__1


    // $ANTLR start rule__Signal__Group_7_2__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2595:1: rule__Signal__Group_7_2__2 : ( 'with' ) rule__Signal__Group_7_2__3 ;
    public final void rule__Signal__Group_7_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2599:1: ( ( 'with' ) rule__Signal__Group_7_2__3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2600:1: ( 'with' ) rule__Signal__Group_7_2__3
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2600:1: ( 'with' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2601:1: 'with'
            {
             before(grammarAccess.getSignalAccess().getWithKeyword_7_2_2()); 
            match(input,34,FOLLOW_34_in_rule__Signal__Group_7_2__25155); 
             after(grammarAccess.getSignalAccess().getWithKeyword_7_2_2()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_7_2__3_in_rule__Signal__Group_7_2__25165);
            rule__Signal__Group_7_2__3();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_7_2__2


    // $ANTLR start rule__Signal__Group_7_2__3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2615:1: rule__Signal__Group_7_2__3 : ( ( rule__Signal__HostCombineOperatorAssignment_7_2_3 ) ) ;
    public final void rule__Signal__Group_7_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2619:1: ( ( ( rule__Signal__HostCombineOperatorAssignment_7_2_3 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2620:1: ( ( rule__Signal__HostCombineOperatorAssignment_7_2_3 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2620:1: ( ( rule__Signal__HostCombineOperatorAssignment_7_2_3 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2621:1: ( rule__Signal__HostCombineOperatorAssignment_7_2_3 )
            {
             before(grammarAccess.getSignalAccess().getHostCombineOperatorAssignment_7_2_3()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2622:1: ( rule__Signal__HostCombineOperatorAssignment_7_2_3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2622:2: rule__Signal__HostCombineOperatorAssignment_7_2_3
            {
            pushFollow(FOLLOW_rule__Signal__HostCombineOperatorAssignment_7_2_3_in_rule__Signal__Group_7_2__35193);
            rule__Signal__HostCombineOperatorAssignment_7_2_3();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getHostCombineOperatorAssignment_7_2_3()); 

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
    // $ANTLR end rule__Signal__Group_7_2__3


    // $ANTLR start rule__Signal__Group_8__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2640:1: rule__Signal__Group_8__0 : ( ( rule__Signal__NameAssignment_8_0 ) ) rule__Signal__Group_8__1 ;
    public final void rule__Signal__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2644:1: ( ( ( rule__Signal__NameAssignment_8_0 ) ) rule__Signal__Group_8__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2645:1: ( ( rule__Signal__NameAssignment_8_0 ) ) rule__Signal__Group_8__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2645:1: ( ( rule__Signal__NameAssignment_8_0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2646:1: ( rule__Signal__NameAssignment_8_0 )
            {
             before(grammarAccess.getSignalAccess().getNameAssignment_8_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2647:1: ( rule__Signal__NameAssignment_8_0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2647:2: rule__Signal__NameAssignment_8_0
            {
            pushFollow(FOLLOW_rule__Signal__NameAssignment_8_0_in_rule__Signal__Group_8__05235);
            rule__Signal__NameAssignment_8_0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getNameAssignment_8_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_8__1_in_rule__Signal__Group_8__05244);
            rule__Signal__Group_8__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_8__0


    // $ANTLR start rule__Signal__Group_8__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2658:1: rule__Signal__Group_8__1 : ( ( rule__Signal__Group_8_1__0 ) ) ;
    public final void rule__Signal__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2662:1: ( ( ( rule__Signal__Group_8_1__0 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2663:1: ( ( rule__Signal__Group_8_1__0 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2663:1: ( ( rule__Signal__Group_8_1__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2664:1: ( rule__Signal__Group_8_1__0 )
            {
             before(grammarAccess.getSignalAccess().getGroup_8_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2665:1: ( rule__Signal__Group_8_1__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2665:2: rule__Signal__Group_8_1__0
            {
            pushFollow(FOLLOW_rule__Signal__Group_8_1__0_in_rule__Signal__Group_8__15272);
            rule__Signal__Group_8_1__0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getGroup_8_1()); 

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
    // $ANTLR end rule__Signal__Group_8__1


    // $ANTLR start rule__Signal__Group_8_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2679:1: rule__Signal__Group_8_1__0 : ( 'combine' ) rule__Signal__Group_8_1__1 ;
    public final void rule__Signal__Group_8_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2683:1: ( ( 'combine' ) rule__Signal__Group_8_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2684:1: ( 'combine' ) rule__Signal__Group_8_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2684:1: ( 'combine' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2685:1: 'combine'
            {
             before(grammarAccess.getSignalAccess().getCombineKeyword_8_1_0()); 
            match(input,33,FOLLOW_33_in_rule__Signal__Group_8_1__05311); 
             after(grammarAccess.getSignalAccess().getCombineKeyword_8_1_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_8_1__1_in_rule__Signal__Group_8_1__05321);
            rule__Signal__Group_8_1__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_8_1__0


    // $ANTLR start rule__Signal__Group_8_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2699:1: rule__Signal__Group_8_1__1 : ( ( rule__Signal__TypeAssignment_8_1_1 ) ) rule__Signal__Group_8_1__2 ;
    public final void rule__Signal__Group_8_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2703:1: ( ( ( rule__Signal__TypeAssignment_8_1_1 ) ) rule__Signal__Group_8_1__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2704:1: ( ( rule__Signal__TypeAssignment_8_1_1 ) ) rule__Signal__Group_8_1__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2704:1: ( ( rule__Signal__TypeAssignment_8_1_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2705:1: ( rule__Signal__TypeAssignment_8_1_1 )
            {
             before(grammarAccess.getSignalAccess().getTypeAssignment_8_1_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2706:1: ( rule__Signal__TypeAssignment_8_1_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2706:2: rule__Signal__TypeAssignment_8_1_1
            {
            pushFollow(FOLLOW_rule__Signal__TypeAssignment_8_1_1_in_rule__Signal__Group_8_1__15349);
            rule__Signal__TypeAssignment_8_1_1();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getTypeAssignment_8_1_1()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_8_1__2_in_rule__Signal__Group_8_1__15358);
            rule__Signal__Group_8_1__2();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_8_1__1


    // $ANTLR start rule__Signal__Group_8_1__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2717:1: rule__Signal__Group_8_1__2 : ( 'with' ) rule__Signal__Group_8_1__3 ;
    public final void rule__Signal__Group_8_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2721:1: ( ( 'with' ) rule__Signal__Group_8_1__3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2722:1: ( 'with' ) rule__Signal__Group_8_1__3
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2722:1: ( 'with' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2723:1: 'with'
            {
             before(grammarAccess.getSignalAccess().getWithKeyword_8_1_2()); 
            match(input,34,FOLLOW_34_in_rule__Signal__Group_8_1__25387); 
             after(grammarAccess.getSignalAccess().getWithKeyword_8_1_2()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_8_1__3_in_rule__Signal__Group_8_1__25397);
            rule__Signal__Group_8_1__3();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_8_1__2


    // $ANTLR start rule__Signal__Group_8_1__3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2737:1: rule__Signal__Group_8_1__3 : ( ( rule__Signal__CombineOperatorAssignment_8_1_3 ) ) ;
    public final void rule__Signal__Group_8_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2741:1: ( ( ( rule__Signal__CombineOperatorAssignment_8_1_3 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2742:1: ( ( rule__Signal__CombineOperatorAssignment_8_1_3 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2742:1: ( ( rule__Signal__CombineOperatorAssignment_8_1_3 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2743:1: ( rule__Signal__CombineOperatorAssignment_8_1_3 )
            {
             before(grammarAccess.getSignalAccess().getCombineOperatorAssignment_8_1_3()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2744:1: ( rule__Signal__CombineOperatorAssignment_8_1_3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2744:2: rule__Signal__CombineOperatorAssignment_8_1_3
            {
            pushFollow(FOLLOW_rule__Signal__CombineOperatorAssignment_8_1_3_in_rule__Signal__Group_8_1__35425);
            rule__Signal__CombineOperatorAssignment_8_1_3();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getCombineOperatorAssignment_8_1_3()); 

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
    // $ANTLR end rule__Signal__Group_8_1__3


    // $ANTLR start rule__Signal__Group_9__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2762:1: rule__Signal__Group_9__0 : ( ( rule__Signal__NameAssignment_9_0 ) ) rule__Signal__Group_9__1 ;
    public final void rule__Signal__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2766:1: ( ( ( rule__Signal__NameAssignment_9_0 ) ) rule__Signal__Group_9__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2767:1: ( ( rule__Signal__NameAssignment_9_0 ) ) rule__Signal__Group_9__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2767:1: ( ( rule__Signal__NameAssignment_9_0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2768:1: ( rule__Signal__NameAssignment_9_0 )
            {
             before(grammarAccess.getSignalAccess().getNameAssignment_9_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2769:1: ( rule__Signal__NameAssignment_9_0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2769:2: rule__Signal__NameAssignment_9_0
            {
            pushFollow(FOLLOW_rule__Signal__NameAssignment_9_0_in_rule__Signal__Group_9__05467);
            rule__Signal__NameAssignment_9_0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getNameAssignment_9_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_9__1_in_rule__Signal__Group_9__05476);
            rule__Signal__Group_9__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_9__0


    // $ANTLR start rule__Signal__Group_9__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2780:1: rule__Signal__Group_9__1 : ( ( rule__Signal__Group_9_1__0 ) ) ;
    public final void rule__Signal__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2784:1: ( ( ( rule__Signal__Group_9_1__0 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2785:1: ( ( rule__Signal__Group_9_1__0 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2785:1: ( ( rule__Signal__Group_9_1__0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2786:1: ( rule__Signal__Group_9_1__0 )
            {
             before(grammarAccess.getSignalAccess().getGroup_9_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2787:1: ( rule__Signal__Group_9_1__0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2787:2: rule__Signal__Group_9_1__0
            {
            pushFollow(FOLLOW_rule__Signal__Group_9_1__0_in_rule__Signal__Group_9__15504);
            rule__Signal__Group_9_1__0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getGroup_9_1()); 

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
    // $ANTLR end rule__Signal__Group_9__1


    // $ANTLR start rule__Signal__Group_9_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2801:1: rule__Signal__Group_9_1__0 : ( 'combine' ) rule__Signal__Group_9_1__1 ;
    public final void rule__Signal__Group_9_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2805:1: ( ( 'combine' ) rule__Signal__Group_9_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2806:1: ( 'combine' ) rule__Signal__Group_9_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2806:1: ( 'combine' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2807:1: 'combine'
            {
             before(grammarAccess.getSignalAccess().getCombineKeyword_9_1_0()); 
            match(input,33,FOLLOW_33_in_rule__Signal__Group_9_1__05543); 
             after(grammarAccess.getSignalAccess().getCombineKeyword_9_1_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_9_1__1_in_rule__Signal__Group_9_1__05553);
            rule__Signal__Group_9_1__1();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_9_1__0


    // $ANTLR start rule__Signal__Group_9_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2821:1: rule__Signal__Group_9_1__1 : ( ( rule__Signal__HostTypeAssignment_9_1_1 ) ) rule__Signal__Group_9_1__2 ;
    public final void rule__Signal__Group_9_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2825:1: ( ( ( rule__Signal__HostTypeAssignment_9_1_1 ) ) rule__Signal__Group_9_1__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2826:1: ( ( rule__Signal__HostTypeAssignment_9_1_1 ) ) rule__Signal__Group_9_1__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2826:1: ( ( rule__Signal__HostTypeAssignment_9_1_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2827:1: ( rule__Signal__HostTypeAssignment_9_1_1 )
            {
             before(grammarAccess.getSignalAccess().getHostTypeAssignment_9_1_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2828:1: ( rule__Signal__HostTypeAssignment_9_1_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2828:2: rule__Signal__HostTypeAssignment_9_1_1
            {
            pushFollow(FOLLOW_rule__Signal__HostTypeAssignment_9_1_1_in_rule__Signal__Group_9_1__15581);
            rule__Signal__HostTypeAssignment_9_1_1();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getHostTypeAssignment_9_1_1()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_9_1__2_in_rule__Signal__Group_9_1__15590);
            rule__Signal__Group_9_1__2();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_9_1__1


    // $ANTLR start rule__Signal__Group_9_1__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2839:1: rule__Signal__Group_9_1__2 : ( 'with' ) rule__Signal__Group_9_1__3 ;
    public final void rule__Signal__Group_9_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2843:1: ( ( 'with' ) rule__Signal__Group_9_1__3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2844:1: ( 'with' ) rule__Signal__Group_9_1__3
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2844:1: ( 'with' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2845:1: 'with'
            {
             before(grammarAccess.getSignalAccess().getWithKeyword_9_1_2()); 
            match(input,34,FOLLOW_34_in_rule__Signal__Group_9_1__25619); 
             after(grammarAccess.getSignalAccess().getWithKeyword_9_1_2()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_9_1__3_in_rule__Signal__Group_9_1__25629);
            rule__Signal__Group_9_1__3();
            _fsp--;


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
    // $ANTLR end rule__Signal__Group_9_1__2


    // $ANTLR start rule__Signal__Group_9_1__3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2859:1: rule__Signal__Group_9_1__3 : ( ( rule__Signal__HostCombineOperatorAssignment_9_1_3 ) ) ;
    public final void rule__Signal__Group_9_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2863:1: ( ( ( rule__Signal__HostCombineOperatorAssignment_9_1_3 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2864:1: ( ( rule__Signal__HostCombineOperatorAssignment_9_1_3 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2864:1: ( ( rule__Signal__HostCombineOperatorAssignment_9_1_3 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2865:1: ( rule__Signal__HostCombineOperatorAssignment_9_1_3 )
            {
             before(grammarAccess.getSignalAccess().getHostCombineOperatorAssignment_9_1_3()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2866:1: ( rule__Signal__HostCombineOperatorAssignment_9_1_3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2866:2: rule__Signal__HostCombineOperatorAssignment_9_1_3
            {
            pushFollow(FOLLOW_rule__Signal__HostCombineOperatorAssignment_9_1_3_in_rule__Signal__Group_9_1__35657);
            rule__Signal__HostCombineOperatorAssignment_9_1_3();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getHostCombineOperatorAssignment_9_1_3()); 

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
    // $ANTLR end rule__Signal__Group_9_1__3


    // $ANTLR start rule__Variable__Group__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2884:1: rule__Variable__Group__0 : ( ( rule__Variable__NameAssignment_0 ) ) rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2888:1: ( ( ( rule__Variable__NameAssignment_0 ) ) rule__Variable__Group__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2889:1: ( ( rule__Variable__NameAssignment_0 ) ) rule__Variable__Group__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2889:1: ( ( rule__Variable__NameAssignment_0 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2890:1: ( rule__Variable__NameAssignment_0 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2891:1: ( rule__Variable__NameAssignment_0 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2891:2: rule__Variable__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Variable__NameAssignment_0_in_rule__Variable__Group__05699);
            rule__Variable__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getVariableAccess().getNameAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__05708);
            rule__Variable__Group__1();
            _fsp--;


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
    // $ANTLR end rule__Variable__Group__0


    // $ANTLR start rule__Variable__Group__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2902:1: rule__Variable__Group__1 : ( ( rule__Variable__Group_1__0 )? ) rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2906:1: ( ( ( rule__Variable__Group_1__0 )? ) rule__Variable__Group__2 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2907:1: ( ( rule__Variable__Group_1__0 )? ) rule__Variable__Group__2
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2907:1: ( ( rule__Variable__Group_1__0 )? )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2908:1: ( rule__Variable__Group_1__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2909:1: ( rule__Variable__Group_1__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==32) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2909:2: rule__Variable__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Variable__Group_1__0_in_rule__Variable__Group__15736);
                    rule__Variable__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVariableAccess().getGroup_1()); 

            }

            pushFollow(FOLLOW_rule__Variable__Group__2_in_rule__Variable__Group__15746);
            rule__Variable__Group__2();
            _fsp--;


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
    // $ANTLR end rule__Variable__Group__1


    // $ANTLR start rule__Variable__Group__2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2920:1: rule__Variable__Group__2 : ( ( rule__Variable__TypeAssignment_2 )? ) rule__Variable__Group__3 ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2924:1: ( ( ( rule__Variable__TypeAssignment_2 )? ) rule__Variable__Group__3 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2925:1: ( ( rule__Variable__TypeAssignment_2 )? ) rule__Variable__Group__3
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2925:1: ( ( rule__Variable__TypeAssignment_2 )? )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2926:1: ( rule__Variable__TypeAssignment_2 )?
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_2()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2927:1: ( rule__Variable__TypeAssignment_2 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=11 && LA18_0<=16)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2927:2: rule__Variable__TypeAssignment_2
                    {
                    pushFollow(FOLLOW_rule__Variable__TypeAssignment_2_in_rule__Variable__Group__25774);
                    rule__Variable__TypeAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVariableAccess().getTypeAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__Variable__Group__3_in_rule__Variable__Group__25784);
            rule__Variable__Group__3();
            _fsp--;


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
    // $ANTLR end rule__Variable__Group__2


    // $ANTLR start rule__Variable__Group__3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2938:1: rule__Variable__Group__3 : ( ( rule__Variable__Group_3__0 )? ) ;
    public final void rule__Variable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2942:1: ( ( ( rule__Variable__Group_3__0 )? ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2943:1: ( ( rule__Variable__Group_3__0 )? )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2943:1: ( ( rule__Variable__Group_3__0 )? )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2944:1: ( rule__Variable__Group_3__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_3()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2945:1: ( rule__Variable__Group_3__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==24) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2945:2: rule__Variable__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Variable__Group_3__0_in_rule__Variable__Group__35812);
                    rule__Variable__Group_3__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVariableAccess().getGroup_3()); 

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
    // $ANTLR end rule__Variable__Group__3


    // $ANTLR start rule__Variable__Group_1__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2963:1: rule__Variable__Group_1__0 : ( ':=' ) rule__Variable__Group_1__1 ;
    public final void rule__Variable__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2967:1: ( ( ':=' ) rule__Variable__Group_1__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2968:1: ( ':=' ) rule__Variable__Group_1__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2968:1: ( ':=' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2969:1: ':='
            {
             before(grammarAccess.getVariableAccess().getColonEqualsSignKeyword_1_0()); 
            match(input,32,FOLLOW_32_in_rule__Variable__Group_1__05856); 
             after(grammarAccess.getVariableAccess().getColonEqualsSignKeyword_1_0()); 

            }

            pushFollow(FOLLOW_rule__Variable__Group_1__1_in_rule__Variable__Group_1__05866);
            rule__Variable__Group_1__1();
            _fsp--;


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
    // $ANTLR end rule__Variable__Group_1__0


    // $ANTLR start rule__Variable__Group_1__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2983:1: rule__Variable__Group_1__1 : ( ( rule__Variable__InitialValueAssignment_1_1 ) ) ;
    public final void rule__Variable__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2987:1: ( ( ( rule__Variable__InitialValueAssignment_1_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2988:1: ( ( rule__Variable__InitialValueAssignment_1_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2988:1: ( ( rule__Variable__InitialValueAssignment_1_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2989:1: ( rule__Variable__InitialValueAssignment_1_1 )
            {
             before(grammarAccess.getVariableAccess().getInitialValueAssignment_1_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2990:1: ( rule__Variable__InitialValueAssignment_1_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:2990:2: rule__Variable__InitialValueAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Variable__InitialValueAssignment_1_1_in_rule__Variable__Group_1__15894);
            rule__Variable__InitialValueAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getVariableAccess().getInitialValueAssignment_1_1()); 

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
    // $ANTLR end rule__Variable__Group_1__1


    // $ANTLR start rule__Variable__Group_3__0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3004:1: rule__Variable__Group_3__0 : ( 'host' ) rule__Variable__Group_3__1 ;
    public final void rule__Variable__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3008:1: ( ( 'host' ) rule__Variable__Group_3__1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3009:1: ( 'host' ) rule__Variable__Group_3__1
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3009:1: ( 'host' )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3010:1: 'host'
            {
             before(grammarAccess.getVariableAccess().getHostKeyword_3_0()); 
            match(input,24,FOLLOW_24_in_rule__Variable__Group_3__05933); 
             after(grammarAccess.getVariableAccess().getHostKeyword_3_0()); 

            }

            pushFollow(FOLLOW_rule__Variable__Group_3__1_in_rule__Variable__Group_3__05943);
            rule__Variable__Group_3__1();
            _fsp--;


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
    // $ANTLR end rule__Variable__Group_3__0


    // $ANTLR start rule__Variable__Group_3__1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3024:1: rule__Variable__Group_3__1 : ( ( rule__Variable__HostTypeAssignment_3_1 ) ) ;
    public final void rule__Variable__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3028:1: ( ( ( rule__Variable__HostTypeAssignment_3_1 ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3029:1: ( ( rule__Variable__HostTypeAssignment_3_1 ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3029:1: ( ( rule__Variable__HostTypeAssignment_3_1 ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3030:1: ( rule__Variable__HostTypeAssignment_3_1 )
            {
             before(grammarAccess.getVariableAccess().getHostTypeAssignment_3_1()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3031:1: ( rule__Variable__HostTypeAssignment_3_1 )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3031:2: rule__Variable__HostTypeAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Variable__HostTypeAssignment_3_1_in_rule__Variable__Group_3__15971);
            rule__Variable__HostTypeAssignment_3_1();
            _fsp--;


            }

             after(grammarAccess.getVariableAccess().getHostTypeAssignment_3_1()); 

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
    // $ANTLR end rule__Variable__Group_3__1


    // $ANTLR start rule__StateExtend__RegionsAssignment_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3046:1: rule__StateExtend__RegionsAssignment_0 : ( ruleRegionSignalDec ) ;
    public final void rule__StateExtend__RegionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3050:1: ( ( ruleRegionSignalDec ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3051:1: ( ruleRegionSignalDec )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3051:1: ( ruleRegionSignalDec )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3052:1: ruleRegionSignalDec
            {
             before(grammarAccess.getStateExtendAccess().getRegionsRegionSignalDecParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleRegionSignalDec_in_rule__StateExtend__RegionsAssignment_06010);
            ruleRegionSignalDec();
            _fsp--;

             after(grammarAccess.getStateExtendAccess().getRegionsRegionSignalDecParserRuleCall_0_0()); 

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
    // $ANTLR end rule__StateExtend__RegionsAssignment_0


    // $ANTLR start rule__StateExtend__InOutputSignalsAssignment_1_2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3061:1: rule__StateExtend__InOutputSignalsAssignment_1_2 : ( ruleInOutputSignals ) ;
    public final void rule__StateExtend__InOutputSignalsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3065:1: ( ( ruleInOutputSignals ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3066:1: ( ruleInOutputSignals )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3066:1: ( ruleInOutputSignals )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3067:1: ruleInOutputSignals
            {
             before(grammarAccess.getStateExtendAccess().getInOutputSignalsInOutputSignalsParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleInOutputSignals_in_rule__StateExtend__InOutputSignalsAssignment_1_26041);
            ruleInOutputSignals();
            _fsp--;

             after(grammarAccess.getStateExtendAccess().getInOutputSignalsInOutputSignalsParserRuleCall_1_2_0()); 

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
    // $ANTLR end rule__StateExtend__InOutputSignalsAssignment_1_2


    // $ANTLR start rule__StateExtend__OutputSignalsAssignment_2_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3076:1: rule__StateExtend__OutputSignalsAssignment_2_1 : ( ruleOutputSignals ) ;
    public final void rule__StateExtend__OutputSignalsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3080:1: ( ( ruleOutputSignals ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3081:1: ( ruleOutputSignals )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3081:1: ( ruleOutputSignals )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3082:1: ruleOutputSignals
            {
             before(grammarAccess.getStateExtendAccess().getOutputSignalsOutputSignalsParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleOutputSignals_in_rule__StateExtend__OutputSignalsAssignment_2_16072);
            ruleOutputSignals();
            _fsp--;

             after(grammarAccess.getStateExtendAccess().getOutputSignalsOutputSignalsParserRuleCall_2_1_0()); 

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
    // $ANTLR end rule__StateExtend__OutputSignalsAssignment_2_1


    // $ANTLR start rule__StateExtend__InputSignalsAssignment_3_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3091:1: rule__StateExtend__InputSignalsAssignment_3_1 : ( ruleInputSignals ) ;
    public final void rule__StateExtend__InputSignalsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3095:1: ( ( ruleInputSignals ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3096:1: ( ruleInputSignals )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3096:1: ( ruleInputSignals )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3097:1: ruleInputSignals
            {
             before(grammarAccess.getStateExtendAccess().getInputSignalsInputSignalsParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleInputSignals_in_rule__StateExtend__InputSignalsAssignment_3_16103);
            ruleInputSignals();
            _fsp--;

             after(grammarAccess.getStateExtendAccess().getInputSignalsInputSignalsParserRuleCall_3_1_0()); 

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
    // $ANTLR end rule__StateExtend__InputSignalsAssignment_3_1


    // $ANTLR start rule__StateExtend__SignalsAssignment_4_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3106:1: rule__StateExtend__SignalsAssignment_4_1 : ( ruleSignals ) ;
    public final void rule__StateExtend__SignalsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3110:1: ( ( ruleSignals ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3111:1: ( ruleSignals )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3111:1: ( ruleSignals )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3112:1: ruleSignals
            {
             before(grammarAccess.getStateExtendAccess().getSignalsSignalsParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleSignals_in_rule__StateExtend__SignalsAssignment_4_16134);
            ruleSignals();
            _fsp--;

             after(grammarAccess.getStateExtendAccess().getSignalsSignalsParserRuleCall_4_1_0()); 

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
    // $ANTLR end rule__StateExtend__SignalsAssignment_4_1


    // $ANTLR start rule__RegionSignalDec__RegionAssignment_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3121:1: rule__RegionSignalDec__RegionAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__RegionSignalDec__RegionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3125:1: ( ( ( RULE_ID ) ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3126:1: ( ( RULE_ID ) )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3126:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3127:1: ( RULE_ID )
            {
             before(grammarAccess.getRegionSignalDecAccess().getRegionRegionCrossReference_0_0()); 
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3128:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3129:1: RULE_ID
            {
             before(grammarAccess.getRegionSignalDecAccess().getRegionRegionIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RegionSignalDec__RegionAssignment_06169); 
             after(grammarAccess.getRegionSignalDecAccess().getRegionRegionIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getRegionSignalDecAccess().getRegionRegionCrossReference_0_0()); 

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
    // $ANTLR end rule__RegionSignalDec__RegionAssignment_0


    // $ANTLR start rule__RegionSignalDec__VarsAssignment_2_0_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3140:1: rule__RegionSignalDec__VarsAssignment_2_0_1 : ( ruleVariable ) ;
    public final void rule__RegionSignalDec__VarsAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3144:1: ( ( ruleVariable ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3145:1: ( ruleVariable )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3145:1: ( ruleVariable )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3146:1: ruleVariable
            {
             before(grammarAccess.getRegionSignalDecAccess().getVarsVariableParserRuleCall_2_0_1_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__RegionSignalDec__VarsAssignment_2_0_16204);
            ruleVariable();
            _fsp--;

             after(grammarAccess.getRegionSignalDecAccess().getVarsVariableParserRuleCall_2_0_1_0()); 

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
    // $ANTLR end rule__RegionSignalDec__VarsAssignment_2_0_1


    // $ANTLR start rule__RegionSignalDec__VarsAssignment_2_0_2_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3155:1: rule__RegionSignalDec__VarsAssignment_2_0_2_1 : ( ruleVariable ) ;
    public final void rule__RegionSignalDec__VarsAssignment_2_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3159:1: ( ( ruleVariable ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3160:1: ( ruleVariable )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3160:1: ( ruleVariable )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3161:1: ruleVariable
            {
             before(grammarAccess.getRegionSignalDecAccess().getVarsVariableParserRuleCall_2_0_2_1_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__RegionSignalDec__VarsAssignment_2_0_2_16235);
            ruleVariable();
            _fsp--;

             after(grammarAccess.getRegionSignalDecAccess().getVarsVariableParserRuleCall_2_0_2_1_0()); 

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
    // $ANTLR end rule__RegionSignalDec__VarsAssignment_2_0_2_1


    // $ANTLR start rule__RegionSignalDec__SignalsAssignment_2_1_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3170:1: rule__RegionSignalDec__SignalsAssignment_2_1_1 : ( ruleSignal ) ;
    public final void rule__RegionSignalDec__SignalsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3174:1: ( ( ruleSignal ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3175:1: ( ruleSignal )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3175:1: ( ruleSignal )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3176:1: ruleSignal
            {
             before(grammarAccess.getRegionSignalDecAccess().getSignalsSignalParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleSignal_in_rule__RegionSignalDec__SignalsAssignment_2_1_16266);
            ruleSignal();
            _fsp--;

             after(grammarAccess.getRegionSignalDecAccess().getSignalsSignalParserRuleCall_2_1_1_0()); 

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
    // $ANTLR end rule__RegionSignalDec__SignalsAssignment_2_1_1


    // $ANTLR start rule__RegionSignalDec__SignalsAssignment_2_1_2_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3185:1: rule__RegionSignalDec__SignalsAssignment_2_1_2_1 : ( ruleSignal ) ;
    public final void rule__RegionSignalDec__SignalsAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3189:1: ( ( ruleSignal ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3190:1: ( ruleSignal )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3190:1: ( ruleSignal )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3191:1: ruleSignal
            {
             before(grammarAccess.getRegionSignalDecAccess().getSignalsSignalParserRuleCall_2_1_2_1_0()); 
            pushFollow(FOLLOW_ruleSignal_in_rule__RegionSignalDec__SignalsAssignment_2_1_2_16297);
            ruleSignal();
            _fsp--;

             after(grammarAccess.getRegionSignalDecAccess().getSignalsSignalParserRuleCall_2_1_2_1_0()); 

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
    // $ANTLR end rule__RegionSignalDec__SignalsAssignment_2_1_2_1


    // $ANTLR start rule__RegionSignalDec__VarsAssignment_3_0_2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3200:1: rule__RegionSignalDec__VarsAssignment_3_0_2 : ( ruleVariable ) ;
    public final void rule__RegionSignalDec__VarsAssignment_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3204:1: ( ( ruleVariable ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3205:1: ( ruleVariable )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3205:1: ( ruleVariable )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3206:1: ruleVariable
            {
             before(grammarAccess.getRegionSignalDecAccess().getVarsVariableParserRuleCall_3_0_2_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__RegionSignalDec__VarsAssignment_3_0_26328);
            ruleVariable();
            _fsp--;

             after(grammarAccess.getRegionSignalDecAccess().getVarsVariableParserRuleCall_3_0_2_0()); 

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
    // $ANTLR end rule__RegionSignalDec__VarsAssignment_3_0_2


    // $ANTLR start rule__RegionSignalDec__VarsAssignment_3_0_3_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3215:1: rule__RegionSignalDec__VarsAssignment_3_0_3_1 : ( ruleVariable ) ;
    public final void rule__RegionSignalDec__VarsAssignment_3_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3219:1: ( ( ruleVariable ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3220:1: ( ruleVariable )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3220:1: ( ruleVariable )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3221:1: ruleVariable
            {
             before(grammarAccess.getRegionSignalDecAccess().getVarsVariableParserRuleCall_3_0_3_1_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__RegionSignalDec__VarsAssignment_3_0_3_16359);
            ruleVariable();
            _fsp--;

             after(grammarAccess.getRegionSignalDecAccess().getVarsVariableParserRuleCall_3_0_3_1_0()); 

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
    // $ANTLR end rule__RegionSignalDec__VarsAssignment_3_0_3_1


    // $ANTLR start rule__RegionSignalDec__SignalsAssignment_3_1_2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3230:1: rule__RegionSignalDec__SignalsAssignment_3_1_2 : ( ruleSignal ) ;
    public final void rule__RegionSignalDec__SignalsAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3234:1: ( ( ruleSignal ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3235:1: ( ruleSignal )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3235:1: ( ruleSignal )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3236:1: ruleSignal
            {
             before(grammarAccess.getRegionSignalDecAccess().getSignalsSignalParserRuleCall_3_1_2_0()); 
            pushFollow(FOLLOW_ruleSignal_in_rule__RegionSignalDec__SignalsAssignment_3_1_26390);
            ruleSignal();
            _fsp--;

             after(grammarAccess.getRegionSignalDecAccess().getSignalsSignalParserRuleCall_3_1_2_0()); 

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
    // $ANTLR end rule__RegionSignalDec__SignalsAssignment_3_1_2


    // $ANTLR start rule__RegionSignalDec__SignalsAssignment_3_1_3_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3245:1: rule__RegionSignalDec__SignalsAssignment_3_1_3_1 : ( ruleSignal ) ;
    public final void rule__RegionSignalDec__SignalsAssignment_3_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3249:1: ( ( ruleSignal ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3250:1: ( ruleSignal )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3250:1: ( ruleSignal )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3251:1: ruleSignal
            {
             before(grammarAccess.getRegionSignalDecAccess().getSignalsSignalParserRuleCall_3_1_3_1_0()); 
            pushFollow(FOLLOW_ruleSignal_in_rule__RegionSignalDec__SignalsAssignment_3_1_3_16421);
            ruleSignal();
            _fsp--;

             after(grammarAccess.getRegionSignalDecAccess().getSignalsSignalParserRuleCall_3_1_3_1_0()); 

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
    // $ANTLR end rule__RegionSignalDec__SignalsAssignment_3_1_3_1


    // $ANTLR start rule__Signals__SignalsAssignment_0_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3260:1: rule__Signals__SignalsAssignment_0_0 : ( ruleSignal ) ;
    public final void rule__Signals__SignalsAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3264:1: ( ( ruleSignal ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3265:1: ( ruleSignal )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3265:1: ( ruleSignal )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3266:1: ruleSignal
            {
             before(grammarAccess.getSignalsAccess().getSignalsSignalParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_ruleSignal_in_rule__Signals__SignalsAssignment_0_06452);
            ruleSignal();
            _fsp--;

             after(grammarAccess.getSignalsAccess().getSignalsSignalParserRuleCall_0_0_0()); 

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
    // $ANTLR end rule__Signals__SignalsAssignment_0_0


    // $ANTLR start rule__Signals__SignalsAssignment_0_1_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3275:1: rule__Signals__SignalsAssignment_0_1_1 : ( ruleSignal ) ;
    public final void rule__Signals__SignalsAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3279:1: ( ( ruleSignal ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3280:1: ( ruleSignal )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3280:1: ( ruleSignal )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3281:1: ruleSignal
            {
             before(grammarAccess.getSignalsAccess().getSignalsSignalParserRuleCall_0_1_1_0()); 
            pushFollow(FOLLOW_ruleSignal_in_rule__Signals__SignalsAssignment_0_1_16483);
            ruleSignal();
            _fsp--;

             after(grammarAccess.getSignalsAccess().getSignalsSignalParserRuleCall_0_1_1_0()); 

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
    // $ANTLR end rule__Signals__SignalsAssignment_0_1_1


    // $ANTLR start rule__InputSignals__SignalsAssignment_0_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3290:1: rule__InputSignals__SignalsAssignment_0_0 : ( ruleSignal ) ;
    public final void rule__InputSignals__SignalsAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3294:1: ( ( ruleSignal ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3295:1: ( ruleSignal )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3295:1: ( ruleSignal )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3296:1: ruleSignal
            {
             before(grammarAccess.getInputSignalsAccess().getSignalsSignalParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_ruleSignal_in_rule__InputSignals__SignalsAssignment_0_06514);
            ruleSignal();
            _fsp--;

             after(grammarAccess.getInputSignalsAccess().getSignalsSignalParserRuleCall_0_0_0()); 

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
    // $ANTLR end rule__InputSignals__SignalsAssignment_0_0


    // $ANTLR start rule__InputSignals__SignalsAssignment_0_1_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3305:1: rule__InputSignals__SignalsAssignment_0_1_1 : ( ruleSignal ) ;
    public final void rule__InputSignals__SignalsAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3309:1: ( ( ruleSignal ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3310:1: ( ruleSignal )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3310:1: ( ruleSignal )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3311:1: ruleSignal
            {
             before(grammarAccess.getInputSignalsAccess().getSignalsSignalParserRuleCall_0_1_1_0()); 
            pushFollow(FOLLOW_ruleSignal_in_rule__InputSignals__SignalsAssignment_0_1_16545);
            ruleSignal();
            _fsp--;

             after(grammarAccess.getInputSignalsAccess().getSignalsSignalParserRuleCall_0_1_1_0()); 

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
    // $ANTLR end rule__InputSignals__SignalsAssignment_0_1_1


    // $ANTLR start rule__OutputSignals__SignalsAssignment_0_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3320:1: rule__OutputSignals__SignalsAssignment_0_0 : ( ruleSignal ) ;
    public final void rule__OutputSignals__SignalsAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3324:1: ( ( ruleSignal ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3325:1: ( ruleSignal )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3325:1: ( ruleSignal )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3326:1: ruleSignal
            {
             before(grammarAccess.getOutputSignalsAccess().getSignalsSignalParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_ruleSignal_in_rule__OutputSignals__SignalsAssignment_0_06576);
            ruleSignal();
            _fsp--;

             after(grammarAccess.getOutputSignalsAccess().getSignalsSignalParserRuleCall_0_0_0()); 

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
    // $ANTLR end rule__OutputSignals__SignalsAssignment_0_0


    // $ANTLR start rule__OutputSignals__SignalsAssignment_0_1_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3335:1: rule__OutputSignals__SignalsAssignment_0_1_1 : ( ruleSignal ) ;
    public final void rule__OutputSignals__SignalsAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3339:1: ( ( ruleSignal ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3340:1: ( ruleSignal )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3340:1: ( ruleSignal )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3341:1: ruleSignal
            {
             before(grammarAccess.getOutputSignalsAccess().getSignalsSignalParserRuleCall_0_1_1_0()); 
            pushFollow(FOLLOW_ruleSignal_in_rule__OutputSignals__SignalsAssignment_0_1_16607);
            ruleSignal();
            _fsp--;

             after(grammarAccess.getOutputSignalsAccess().getSignalsSignalParserRuleCall_0_1_1_0()); 

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
    // $ANTLR end rule__OutputSignals__SignalsAssignment_0_1_1


    // $ANTLR start rule__InOutputSignals__SignalsAssignment_0_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3350:1: rule__InOutputSignals__SignalsAssignment_0_0 : ( ruleSignal ) ;
    public final void rule__InOutputSignals__SignalsAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3354:1: ( ( ruleSignal ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3355:1: ( ruleSignal )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3355:1: ( ruleSignal )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3356:1: ruleSignal
            {
             before(grammarAccess.getInOutputSignalsAccess().getSignalsSignalParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_ruleSignal_in_rule__InOutputSignals__SignalsAssignment_0_06638);
            ruleSignal();
            _fsp--;

             after(grammarAccess.getInOutputSignalsAccess().getSignalsSignalParserRuleCall_0_0_0()); 

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
    // $ANTLR end rule__InOutputSignals__SignalsAssignment_0_0


    // $ANTLR start rule__InOutputSignals__SignalsAssignment_0_1_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3365:1: rule__InOutputSignals__SignalsAssignment_0_1_1 : ( ruleSignal ) ;
    public final void rule__InOutputSignals__SignalsAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3369:1: ( ( ruleSignal ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3370:1: ( ruleSignal )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3370:1: ( ruleSignal )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3371:1: ruleSignal
            {
             before(grammarAccess.getInOutputSignalsAccess().getSignalsSignalParserRuleCall_0_1_1_0()); 
            pushFollow(FOLLOW_ruleSignal_in_rule__InOutputSignals__SignalsAssignment_0_1_16669);
            ruleSignal();
            _fsp--;

             after(grammarAccess.getInOutputSignalsAccess().getSignalsSignalParserRuleCall_0_1_1_0()); 

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
    // $ANTLR end rule__InOutputSignals__SignalsAssignment_0_1_1


    // $ANTLR start rule__Signal__NameAssignment_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3380:1: rule__Signal__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Signal__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3384:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3385:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3385:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3386:1: RULE_ID
            {
             before(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_06700); 
             after(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end rule__Signal__NameAssignment_0


    // $ANTLR start rule__Signal__NameAssignment_1_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3395:1: rule__Signal__NameAssignment_1_0 : ( RULE_ID ) ;
    public final void rule__Signal__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3399:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3400:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3400:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3401:1: RULE_ID
            {
             before(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_1_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_1_06731); 
             after(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_1_0_0()); 

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
    // $ANTLR end rule__Signal__NameAssignment_1_0


    // $ANTLR start rule__Signal__TypeAssignment_1_2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3410:1: rule__Signal__TypeAssignment_1_2 : ( ruleValueType ) ;
    public final void rule__Signal__TypeAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3414:1: ( ( ruleValueType ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3415:1: ( ruleValueType )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3415:1: ( ruleValueType )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3416:1: ruleValueType
            {
             before(grammarAccess.getSignalAccess().getTypeValueTypeEnumRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleValueType_in_rule__Signal__TypeAssignment_1_26762);
            ruleValueType();
            _fsp--;

             after(grammarAccess.getSignalAccess().getTypeValueTypeEnumRuleCall_1_2_0()); 

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
    // $ANTLR end rule__Signal__TypeAssignment_1_2


    // $ANTLR start rule__Signal__NameAssignment_2_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3425:1: rule__Signal__NameAssignment_2_0 : ( RULE_ID ) ;
    public final void rule__Signal__NameAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3429:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3430:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3430:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3431:1: RULE_ID
            {
             before(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_2_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_2_06793); 
             after(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_2_0_0()); 

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
    // $ANTLR end rule__Signal__NameAssignment_2_0


    // $ANTLR start rule__Signal__InitialValueAssignment_2_1_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3440:1: rule__Signal__InitialValueAssignment_2_1_1 : ( RULE_STRING ) ;
    public final void rule__Signal__InitialValueAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3444:1: ( ( RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3445:1: ( RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3445:1: ( RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3446:1: RULE_STRING
            {
             before(grammarAccess.getSignalAccess().getInitialValueSTRINGTerminalRuleCall_2_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Signal__InitialValueAssignment_2_1_16824); 
             after(grammarAccess.getSignalAccess().getInitialValueSTRINGTerminalRuleCall_2_1_1_0()); 

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
    // $ANTLR end rule__Signal__InitialValueAssignment_2_1_1


    // $ANTLR start rule__Signal__NameAssignment_3_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3455:1: rule__Signal__NameAssignment_3_0 : ( RULE_ID ) ;
    public final void rule__Signal__NameAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3459:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3460:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3460:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3461:1: RULE_ID
            {
             before(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_3_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_3_06855); 
             after(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_3_0_0()); 

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
    // $ANTLR end rule__Signal__NameAssignment_3_0


    // $ANTLR start rule__Signal__InitialValueAssignment_3_1_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3470:1: rule__Signal__InitialValueAssignment_3_1_1 : ( RULE_STRING ) ;
    public final void rule__Signal__InitialValueAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3474:1: ( ( RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3475:1: ( RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3475:1: ( RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3476:1: RULE_STRING
            {
             before(grammarAccess.getSignalAccess().getInitialValueSTRINGTerminalRuleCall_3_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Signal__InitialValueAssignment_3_1_16886); 
             after(grammarAccess.getSignalAccess().getInitialValueSTRINGTerminalRuleCall_3_1_1_0()); 

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
    // $ANTLR end rule__Signal__InitialValueAssignment_3_1_1


    // $ANTLR start rule__Signal__TypeAssignment_3_3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3485:1: rule__Signal__TypeAssignment_3_3 : ( ruleValueType ) ;
    public final void rule__Signal__TypeAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3489:1: ( ( ruleValueType ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3490:1: ( ruleValueType )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3490:1: ( ruleValueType )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3491:1: ruleValueType
            {
             before(grammarAccess.getSignalAccess().getTypeValueTypeEnumRuleCall_3_3_0()); 
            pushFollow(FOLLOW_ruleValueType_in_rule__Signal__TypeAssignment_3_36917);
            ruleValueType();
            _fsp--;

             after(grammarAccess.getSignalAccess().getTypeValueTypeEnumRuleCall_3_3_0()); 

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
    // $ANTLR end rule__Signal__TypeAssignment_3_3


    // $ANTLR start rule__Signal__NameAssignment_4_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3500:1: rule__Signal__NameAssignment_4_0 : ( RULE_ID ) ;
    public final void rule__Signal__NameAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3504:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3505:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3505:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3506:1: RULE_ID
            {
             before(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_4_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_4_06948); 
             after(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_4_0_0()); 

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
    // $ANTLR end rule__Signal__NameAssignment_4_0


    // $ANTLR start rule__Signal__InitialValueAssignment_4_1_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3515:1: rule__Signal__InitialValueAssignment_4_1_1 : ( RULE_STRING ) ;
    public final void rule__Signal__InitialValueAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3519:1: ( ( RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3520:1: ( RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3520:1: ( RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3521:1: RULE_STRING
            {
             before(grammarAccess.getSignalAccess().getInitialValueSTRINGTerminalRuleCall_4_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Signal__InitialValueAssignment_4_1_16979); 
             after(grammarAccess.getSignalAccess().getInitialValueSTRINGTerminalRuleCall_4_1_1_0()); 

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
    // $ANTLR end rule__Signal__InitialValueAssignment_4_1_1


    // $ANTLR start rule__Signal__TypeAssignment_4_2_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3530:1: rule__Signal__TypeAssignment_4_2_1 : ( ruleValueType ) ;
    public final void rule__Signal__TypeAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3534:1: ( ( ruleValueType ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3535:1: ( ruleValueType )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3535:1: ( ruleValueType )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3536:1: ruleValueType
            {
             before(grammarAccess.getSignalAccess().getTypeValueTypeEnumRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_ruleValueType_in_rule__Signal__TypeAssignment_4_2_17010);
            ruleValueType();
            _fsp--;

             after(grammarAccess.getSignalAccess().getTypeValueTypeEnumRuleCall_4_2_1_0()); 

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
    // $ANTLR end rule__Signal__TypeAssignment_4_2_1


    // $ANTLR start rule__Signal__CombineOperatorAssignment_4_2_3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3545:1: rule__Signal__CombineOperatorAssignment_4_2_3 : ( ruleCombineOperator ) ;
    public final void rule__Signal__CombineOperatorAssignment_4_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3549:1: ( ( ruleCombineOperator ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3550:1: ( ruleCombineOperator )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3550:1: ( ruleCombineOperator )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3551:1: ruleCombineOperator
            {
             before(grammarAccess.getSignalAccess().getCombineOperatorCombineOperatorEnumRuleCall_4_2_3_0()); 
            pushFollow(FOLLOW_ruleCombineOperator_in_rule__Signal__CombineOperatorAssignment_4_2_37041);
            ruleCombineOperator();
            _fsp--;

             after(grammarAccess.getSignalAccess().getCombineOperatorCombineOperatorEnumRuleCall_4_2_3_0()); 

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
    // $ANTLR end rule__Signal__CombineOperatorAssignment_4_2_3


    // $ANTLR start rule__Signal__NameAssignment_5_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3560:1: rule__Signal__NameAssignment_5_0 : ( RULE_ID ) ;
    public final void rule__Signal__NameAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3564:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3565:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3565:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3566:1: RULE_ID
            {
             before(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_5_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_5_07072); 
             after(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_5_0_0()); 

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
    // $ANTLR end rule__Signal__NameAssignment_5_0


    // $ANTLR start rule__Signal__HostTypeAssignment_5_2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3575:1: rule__Signal__HostTypeAssignment_5_2 : ( RULE_STRING ) ;
    public final void rule__Signal__HostTypeAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3579:1: ( ( RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3580:1: ( RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3580:1: ( RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3581:1: RULE_STRING
            {
             before(grammarAccess.getSignalAccess().getHostTypeSTRINGTerminalRuleCall_5_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Signal__HostTypeAssignment_5_27103); 
             after(grammarAccess.getSignalAccess().getHostTypeSTRINGTerminalRuleCall_5_2_0()); 

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
    // $ANTLR end rule__Signal__HostTypeAssignment_5_2


    // $ANTLR start rule__Signal__NameAssignment_6_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3590:1: rule__Signal__NameAssignment_6_0 : ( RULE_ID ) ;
    public final void rule__Signal__NameAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3594:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3595:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3595:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3596:1: RULE_ID
            {
             before(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_6_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_6_07134); 
             after(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_6_0_0()); 

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
    // $ANTLR end rule__Signal__NameAssignment_6_0


    // $ANTLR start rule__Signal__InitialValueAssignment_6_1_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3605:1: rule__Signal__InitialValueAssignment_6_1_1 : ( RULE_STRING ) ;
    public final void rule__Signal__InitialValueAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3609:1: ( ( RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3610:1: ( RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3610:1: ( RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3611:1: RULE_STRING
            {
             before(grammarAccess.getSignalAccess().getInitialValueSTRINGTerminalRuleCall_6_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Signal__InitialValueAssignment_6_1_17165); 
             after(grammarAccess.getSignalAccess().getInitialValueSTRINGTerminalRuleCall_6_1_1_0()); 

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
    // $ANTLR end rule__Signal__InitialValueAssignment_6_1_1


    // $ANTLR start rule__Signal__HostTypeAssignment_6_3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3620:1: rule__Signal__HostTypeAssignment_6_3 : ( RULE_STRING ) ;
    public final void rule__Signal__HostTypeAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3624:1: ( ( RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3625:1: ( RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3625:1: ( RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3626:1: RULE_STRING
            {
             before(grammarAccess.getSignalAccess().getHostTypeSTRINGTerminalRuleCall_6_3_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Signal__HostTypeAssignment_6_37196); 
             after(grammarAccess.getSignalAccess().getHostTypeSTRINGTerminalRuleCall_6_3_0()); 

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
    // $ANTLR end rule__Signal__HostTypeAssignment_6_3


    // $ANTLR start rule__Signal__NameAssignment_7_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3635:1: rule__Signal__NameAssignment_7_0 : ( RULE_ID ) ;
    public final void rule__Signal__NameAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3639:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3640:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3640:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3641:1: RULE_ID
            {
             before(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_7_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_7_07227); 
             after(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_7_0_0()); 

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
    // $ANTLR end rule__Signal__NameAssignment_7_0


    // $ANTLR start rule__Signal__InitialValueAssignment_7_1_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3650:1: rule__Signal__InitialValueAssignment_7_1_1 : ( RULE_STRING ) ;
    public final void rule__Signal__InitialValueAssignment_7_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3654:1: ( ( RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3655:1: ( RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3655:1: ( RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3656:1: RULE_STRING
            {
             before(grammarAccess.getSignalAccess().getInitialValueSTRINGTerminalRuleCall_7_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Signal__InitialValueAssignment_7_1_17258); 
             after(grammarAccess.getSignalAccess().getInitialValueSTRINGTerminalRuleCall_7_1_1_0()); 

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
    // $ANTLR end rule__Signal__InitialValueAssignment_7_1_1


    // $ANTLR start rule__Signal__HostTypeAssignment_7_2_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3665:1: rule__Signal__HostTypeAssignment_7_2_1 : ( RULE_STRING ) ;
    public final void rule__Signal__HostTypeAssignment_7_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3669:1: ( ( RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3670:1: ( RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3670:1: ( RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3671:1: RULE_STRING
            {
             before(grammarAccess.getSignalAccess().getHostTypeSTRINGTerminalRuleCall_7_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Signal__HostTypeAssignment_7_2_17289); 
             after(grammarAccess.getSignalAccess().getHostTypeSTRINGTerminalRuleCall_7_2_1_0()); 

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
    // $ANTLR end rule__Signal__HostTypeAssignment_7_2_1


    // $ANTLR start rule__Signal__HostCombineOperatorAssignment_7_2_3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3680:1: rule__Signal__HostCombineOperatorAssignment_7_2_3 : ( RULE_STRING ) ;
    public final void rule__Signal__HostCombineOperatorAssignment_7_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3684:1: ( ( RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3685:1: ( RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3685:1: ( RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3686:1: RULE_STRING
            {
             before(grammarAccess.getSignalAccess().getHostCombineOperatorSTRINGTerminalRuleCall_7_2_3_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Signal__HostCombineOperatorAssignment_7_2_37320); 
             after(grammarAccess.getSignalAccess().getHostCombineOperatorSTRINGTerminalRuleCall_7_2_3_0()); 

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
    // $ANTLR end rule__Signal__HostCombineOperatorAssignment_7_2_3


    // $ANTLR start rule__Signal__NameAssignment_8_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3695:1: rule__Signal__NameAssignment_8_0 : ( RULE_ID ) ;
    public final void rule__Signal__NameAssignment_8_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3699:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3700:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3700:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3701:1: RULE_ID
            {
             before(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_8_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_8_07351); 
             after(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_8_0_0()); 

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
    // $ANTLR end rule__Signal__NameAssignment_8_0


    // $ANTLR start rule__Signal__TypeAssignment_8_1_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3710:1: rule__Signal__TypeAssignment_8_1_1 : ( ruleValueType ) ;
    public final void rule__Signal__TypeAssignment_8_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3714:1: ( ( ruleValueType ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3715:1: ( ruleValueType )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3715:1: ( ruleValueType )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3716:1: ruleValueType
            {
             before(grammarAccess.getSignalAccess().getTypeValueTypeEnumRuleCall_8_1_1_0()); 
            pushFollow(FOLLOW_ruleValueType_in_rule__Signal__TypeAssignment_8_1_17382);
            ruleValueType();
            _fsp--;

             after(grammarAccess.getSignalAccess().getTypeValueTypeEnumRuleCall_8_1_1_0()); 

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
    // $ANTLR end rule__Signal__TypeAssignment_8_1_1


    // $ANTLR start rule__Signal__CombineOperatorAssignment_8_1_3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3725:1: rule__Signal__CombineOperatorAssignment_8_1_3 : ( ruleCombineOperator ) ;
    public final void rule__Signal__CombineOperatorAssignment_8_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3729:1: ( ( ruleCombineOperator ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3730:1: ( ruleCombineOperator )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3730:1: ( ruleCombineOperator )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3731:1: ruleCombineOperator
            {
             before(grammarAccess.getSignalAccess().getCombineOperatorCombineOperatorEnumRuleCall_8_1_3_0()); 
            pushFollow(FOLLOW_ruleCombineOperator_in_rule__Signal__CombineOperatorAssignment_8_1_37413);
            ruleCombineOperator();
            _fsp--;

             after(grammarAccess.getSignalAccess().getCombineOperatorCombineOperatorEnumRuleCall_8_1_3_0()); 

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
    // $ANTLR end rule__Signal__CombineOperatorAssignment_8_1_3


    // $ANTLR start rule__Signal__NameAssignment_9_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3740:1: rule__Signal__NameAssignment_9_0 : ( RULE_ID ) ;
    public final void rule__Signal__NameAssignment_9_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3744:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3745:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3745:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3746:1: RULE_ID
            {
             before(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_9_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_9_07444); 
             after(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_9_0_0()); 

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
    // $ANTLR end rule__Signal__NameAssignment_9_0


    // $ANTLR start rule__Signal__HostTypeAssignment_9_1_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3755:1: rule__Signal__HostTypeAssignment_9_1_1 : ( RULE_STRING ) ;
    public final void rule__Signal__HostTypeAssignment_9_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3759:1: ( ( RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3760:1: ( RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3760:1: ( RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3761:1: RULE_STRING
            {
             before(grammarAccess.getSignalAccess().getHostTypeSTRINGTerminalRuleCall_9_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Signal__HostTypeAssignment_9_1_17475); 
             after(grammarAccess.getSignalAccess().getHostTypeSTRINGTerminalRuleCall_9_1_1_0()); 

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
    // $ANTLR end rule__Signal__HostTypeAssignment_9_1_1


    // $ANTLR start rule__Signal__HostCombineOperatorAssignment_9_1_3
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3770:1: rule__Signal__HostCombineOperatorAssignment_9_1_3 : ( RULE_STRING ) ;
    public final void rule__Signal__HostCombineOperatorAssignment_9_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3774:1: ( ( RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3775:1: ( RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3775:1: ( RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3776:1: RULE_STRING
            {
             before(grammarAccess.getSignalAccess().getHostCombineOperatorSTRINGTerminalRuleCall_9_1_3_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Signal__HostCombineOperatorAssignment_9_1_37506); 
             after(grammarAccess.getSignalAccess().getHostCombineOperatorSTRINGTerminalRuleCall_9_1_3_0()); 

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
    // $ANTLR end rule__Signal__HostCombineOperatorAssignment_9_1_3


    // $ANTLR start rule__Variable__NameAssignment_0
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3785:1: rule__Variable__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Variable__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3789:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3790:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3790:1: ( RULE_ID )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3791:1: RULE_ID
            {
             before(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Variable__NameAssignment_07537); 
             after(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end rule__Variable__NameAssignment_0


    // $ANTLR start rule__Variable__InitialValueAssignment_1_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3800:1: rule__Variable__InitialValueAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__Variable__InitialValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3804:1: ( ( RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3805:1: ( RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3805:1: ( RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3806:1: RULE_STRING
            {
             before(grammarAccess.getVariableAccess().getInitialValueSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Variable__InitialValueAssignment_1_17568); 
             after(grammarAccess.getVariableAccess().getInitialValueSTRINGTerminalRuleCall_1_1_0()); 

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
    // $ANTLR end rule__Variable__InitialValueAssignment_1_1


    // $ANTLR start rule__Variable__TypeAssignment_2
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3815:1: rule__Variable__TypeAssignment_2 : ( ruleValueType ) ;
    public final void rule__Variable__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3819:1: ( ( ruleValueType ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3820:1: ( ruleValueType )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3820:1: ( ruleValueType )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3821:1: ruleValueType
            {
             before(grammarAccess.getVariableAccess().getTypeValueTypeEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValueType_in_rule__Variable__TypeAssignment_27599);
            ruleValueType();
            _fsp--;

             after(grammarAccess.getVariableAccess().getTypeValueTypeEnumRuleCall_2_0()); 

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
    // $ANTLR end rule__Variable__TypeAssignment_2


    // $ANTLR start rule__Variable__HostTypeAssignment_3_1
    // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3830:1: rule__Variable__HostTypeAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__Variable__HostTypeAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3834:1: ( ( RULE_STRING ) )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3835:1: ( RULE_STRING )
            {
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3835:1: ( RULE_STRING )
            // ../de.cau.cs.kieler.synccharts.interfacedeclparser.ui/src-gen/de/cau/cs/kieler/synccharts/interfacedeclparser/ui/contentassist/antlr/internal/InternalInterfaceDecl.g:3836:1: RULE_STRING
            {
             before(grammarAccess.getVariableAccess().getHostTypeSTRINGTerminalRuleCall_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Variable__HostTypeAssignment_3_17630); 
             after(grammarAccess.getVariableAccess().getHostTypeSTRINGTerminalRuleCall_3_1_0()); 

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
    // $ANTLR end rule__Variable__HostTypeAssignment_3_1


 

    public static final BitSet FOLLOW_ruleStateExtend_in_entryRuleStateExtend61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateExtend68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateExtend__Alternatives_in_ruleStateExtend96 = new BitSet(new long[]{0x000000000E000012L});
    public static final BitSet FOLLOW_rule__StateExtend__Alternatives_in_ruleStateExtend108 = new BitSet(new long[]{0x000000000E000012L});
    public static final BitSet FOLLOW_ruleRegionSignalDec_in_entryRuleRegionSignalDec138 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRegionSignalDec145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group__0_in_ruleRegionSignalDec171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignals_in_entryRuleSignals198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignals205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signals__Group__0_in_ruleSignals231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInputSignals_in_entryRuleInputSignals258 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInputSignals265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InputSignals__Group__0_in_ruleInputSignals291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutputSignals_in_entryRuleOutputSignals318 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOutputSignals325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutputSignals__Group__0_in_ruleOutputSignals351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInOutputSignals_in_entryRuleInOutputSignals378 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInOutputSignals385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InOutputSignals__Group__0_in_ruleInOutputSignals411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_entryRuleSignal438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignal445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Alternatives_in_ruleSignal471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable498 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__0_in_ruleVariable531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__Alternatives_in_ruleValueType568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CombineOperator__Alternatives_in_ruleCombineOperator604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateExtend__RegionsAssignment_0_in_rule__StateExtend__Alternatives639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateExtend__Group_1__0_in_rule__StateExtend__Alternatives657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateExtend__Group_2__0_in_rule__StateExtend__Alternatives675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateExtend__Group_3__0_in_rule__StateExtend__Alternatives693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateExtend__Group_4__0_in_rule__StateExtend__Alternatives711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_2_0__0_in_rule__RegionSignalDec__Alternatives_2744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_2_1__0_in_rule__RegionSignalDec__Alternatives_2762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_3_0__0_in_rule__RegionSignalDec__Alternatives_3795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_3_1__0_in_rule__RegionSignalDec__Alternatives_3813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__NameAssignment_0_in_rule__Signal__Alternatives846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_1__0_in_rule__Signal__Alternatives864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_2__0_in_rule__Signal__Alternatives882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_3__0_in_rule__Signal__Alternatives900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_4__0_in_rule__Signal__Alternatives918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_5__0_in_rule__Signal__Alternatives936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_6__0_in_rule__Signal__Alternatives954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_7__0_in_rule__Signal__Alternatives972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_8__0_in_rule__Signal__Alternatives990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_9__0_in_rule__Signal__Alternatives1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ValueType__Alternatives1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ValueType__Alternatives1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ValueType__Alternatives1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ValueType__Alternatives1105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ValueType__Alternatives1126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ValueType__Alternatives1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__CombineOperator__Alternatives1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__CombineOperator__Alternatives1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__CombineOperator__Alternatives1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__CombineOperator__Alternatives1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__CombineOperator__Alternatives1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__CombineOperator__Alternatives1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__CombineOperator__Alternatives1309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__CombineOperator__Alternatives1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__StateExtend__Group_1__01368 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__StateExtend__Group_1__1_in_rule__StateExtend__Group_1__01378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__StateExtend__Group_1__11407 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__StateExtend__Group_1__2_in_rule__StateExtend__Group_1__11417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateExtend__InOutputSignalsAssignment_1_2_in_rule__StateExtend__Group_1__21445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__StateExtend__Group_2__01486 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__StateExtend__Group_2__1_in_rule__StateExtend__Group_2__01496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateExtend__OutputSignalsAssignment_2_1_in_rule__StateExtend__Group_2__11524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__StateExtend__Group_3__01563 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__StateExtend__Group_3__1_in_rule__StateExtend__Group_3__01573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateExtend__InputSignalsAssignment_3_1_in_rule__StateExtend__Group_3__11601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__StateExtend__Group_4__01640 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__StateExtend__Group_4__1_in_rule__StateExtend__Group_4__01650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateExtend__SignalsAssignment_4_1_in_rule__StateExtend__Group_4__11678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__RegionAssignment_0_in_rule__RegionSignalDec__Group__01716 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group__1_in_rule__RegionSignalDec__Group__01725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__RegionSignalDec__Group__11754 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group__2_in_rule__RegionSignalDec__Group__11764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Alternatives_2_in_rule__RegionSignalDec__Group__21792 = new BitSet(new long[]{0x00000000A0000000L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group__3_in_rule__RegionSignalDec__Group__21801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Alternatives_3_in_rule__RegionSignalDec__Group__31829 = new BitSet(new long[]{0x00000000A0000000L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group__4_in_rule__RegionSignalDec__Group__31839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__RegionSignalDec__Group__41868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__RegionSignalDec__Group_2_0__01914 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_2_0__1_in_rule__RegionSignalDec__Group_2_0__01924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__VarsAssignment_2_0_1_in_rule__RegionSignalDec__Group_2_0__11952 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_2_0__2_in_rule__RegionSignalDec__Group_2_0__11961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_2_0_2__0_in_rule__RegionSignalDec__Group_2_0__21989 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_rule__RegionSignalDec__Group_2_0_2__02031 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_2_0_2__1_in_rule__RegionSignalDec__Group_2_0_2__02041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__VarsAssignment_2_0_2_1_in_rule__RegionSignalDec__Group_2_0_2__12069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__RegionSignalDec__Group_2_1__02108 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_2_1__1_in_rule__RegionSignalDec__Group_2_1__02118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__SignalsAssignment_2_1_1_in_rule__RegionSignalDec__Group_2_1__12146 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_2_1__2_in_rule__RegionSignalDec__Group_2_1__12155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_2_1_2__0_in_rule__RegionSignalDec__Group_2_1__22183 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_rule__RegionSignalDec__Group_2_1_2__02225 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_2_1_2__1_in_rule__RegionSignalDec__Group_2_1_2__02235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__SignalsAssignment_2_1_2_1_in_rule__RegionSignalDec__Group_2_1_2__12263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__RegionSignalDec__Group_3_0__02302 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_3_0__1_in_rule__RegionSignalDec__Group_3_0__02312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__RegionSignalDec__Group_3_0__12341 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_3_0__2_in_rule__RegionSignalDec__Group_3_0__12351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__VarsAssignment_3_0_2_in_rule__RegionSignalDec__Group_3_0__22379 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_3_0__3_in_rule__RegionSignalDec__Group_3_0__22388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_3_0_3__0_in_rule__RegionSignalDec__Group_3_0__32416 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_rule__RegionSignalDec__Group_3_0_3__02460 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_3_0_3__1_in_rule__RegionSignalDec__Group_3_0_3__02470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__VarsAssignment_3_0_3_1_in_rule__RegionSignalDec__Group_3_0_3__12498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__RegionSignalDec__Group_3_1__02537 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_3_1__1_in_rule__RegionSignalDec__Group_3_1__02547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__RegionSignalDec__Group_3_1__12576 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_3_1__2_in_rule__RegionSignalDec__Group_3_1__12586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__SignalsAssignment_3_1_2_in_rule__RegionSignalDec__Group_3_1__22614 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_3_1__3_in_rule__RegionSignalDec__Group_3_1__22623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_3_1_3__0_in_rule__RegionSignalDec__Group_3_1__32651 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_rule__RegionSignalDec__Group_3_1_3__02695 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__Group_3_1_3__1_in_rule__RegionSignalDec__Group_3_1_3__02705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegionSignalDec__SignalsAssignment_3_1_3_1_in_rule__RegionSignalDec__Group_3_1_3__12733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signals__Group_0__0_in_rule__Signals__Group__02771 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Signals__Group__1_in_rule__Signals__Group__02780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Signals__Group__12809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signals__SignalsAssignment_0_0_in_rule__Signals__Group_0__02848 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__Signals__Group_0__1_in_rule__Signals__Group_0__02857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signals__Group_0_1__0_in_rule__Signals__Group_0__12885 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_rule__Signals__Group_0_1__02925 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Signals__Group_0_1__1_in_rule__Signals__Group_0_1__02935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signals__SignalsAssignment_0_1_1_in_rule__Signals__Group_0_1__12963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InputSignals__Group_0__0_in_rule__InputSignals__Group__03001 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__InputSignals__Group__1_in_rule__InputSignals__Group__03010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__InputSignals__Group__13039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InputSignals__SignalsAssignment_0_0_in_rule__InputSignals__Group_0__03078 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__InputSignals__Group_0__1_in_rule__InputSignals__Group_0__03087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InputSignals__Group_0_1__0_in_rule__InputSignals__Group_0__13115 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_rule__InputSignals__Group_0_1__03155 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__InputSignals__Group_0_1__1_in_rule__InputSignals__Group_0_1__03165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InputSignals__SignalsAssignment_0_1_1_in_rule__InputSignals__Group_0_1__13193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutputSignals__Group_0__0_in_rule__OutputSignals__Group__03231 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__OutputSignals__Group__1_in_rule__OutputSignals__Group__03240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__OutputSignals__Group__13269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutputSignals__SignalsAssignment_0_0_in_rule__OutputSignals__Group_0__03308 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__OutputSignals__Group_0__1_in_rule__OutputSignals__Group_0__03317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutputSignals__Group_0_1__0_in_rule__OutputSignals__Group_0__13345 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_rule__OutputSignals__Group_0_1__03385 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OutputSignals__Group_0_1__1_in_rule__OutputSignals__Group_0_1__03395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OutputSignals__SignalsAssignment_0_1_1_in_rule__OutputSignals__Group_0_1__13423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InOutputSignals__Group_0__0_in_rule__InOutputSignals__Group__03461 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__InOutputSignals__Group__1_in_rule__InOutputSignals__Group__03470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__InOutputSignals__Group__13499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InOutputSignals__SignalsAssignment_0_0_in_rule__InOutputSignals__Group_0__03538 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__InOutputSignals__Group_0__1_in_rule__InOutputSignals__Group_0__03547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InOutputSignals__Group_0_1__0_in_rule__InOutputSignals__Group_0__13575 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_rule__InOutputSignals__Group_0_1__03615 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__InOutputSignals__Group_0_1__1_in_rule__InOutputSignals__Group_0_1__03625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InOutputSignals__SignalsAssignment_0_1_1_in_rule__InOutputSignals__Group_0_1__13653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__NameAssignment_1_0_in_rule__Signal__Group_1__03691 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_1__1_in_rule__Signal__Group_1__03700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Signal__Group_1__13729 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_rule__Signal__Group_1__2_in_rule__Signal__Group_1__13739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__TypeAssignment_1_2_in_rule__Signal__Group_1__23767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__NameAssignment_2_0_in_rule__Signal__Group_2__03807 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_2__1_in_rule__Signal__Group_2__03816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_2_1__0_in_rule__Signal__Group_2__13844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Signal__Group_2_1__03883 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Signal__Group_2_1__1_in_rule__Signal__Group_2_1__03893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__InitialValueAssignment_2_1_1_in_rule__Signal__Group_2_1__13921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__NameAssignment_3_0_in_rule__Signal__Group_3__03959 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_3__1_in_rule__Signal__Group_3__03968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_3_1__0_in_rule__Signal__Group_3__13996 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_3__2_in_rule__Signal__Group_3__14005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Signal__Group_3__24034 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_rule__Signal__Group_3__3_in_rule__Signal__Group_3__24044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__TypeAssignment_3_3_in_rule__Signal__Group_3__34072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Signal__Group_3_1__04115 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Signal__Group_3_1__1_in_rule__Signal__Group_3_1__04125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__InitialValueAssignment_3_1_1_in_rule__Signal__Group_3_1__14153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__NameAssignment_4_0_in_rule__Signal__Group_4__04191 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_4__1_in_rule__Signal__Group_4__04200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_4_1__0_in_rule__Signal__Group_4__14228 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_4__2_in_rule__Signal__Group_4__14237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_4_2__0_in_rule__Signal__Group_4__24265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Signal__Group_4_1__04306 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Signal__Group_4_1__1_in_rule__Signal__Group_4_1__04316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__InitialValueAssignment_4_1_1_in_rule__Signal__Group_4_1__14344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Signal__Group_4_2__04383 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_rule__Signal__Group_4_2__1_in_rule__Signal__Group_4_2__04393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__TypeAssignment_4_2_1_in_rule__Signal__Group_4_2__14421 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_4_2__2_in_rule__Signal__Group_4_2__14430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Signal__Group_4_2__24459 = new BitSet(new long[]{0x0000000001FE0000L});
    public static final BitSet FOLLOW_rule__Signal__Group_4_2__3_in_rule__Signal__Group_4_2__24469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__CombineOperatorAssignment_4_2_3_in_rule__Signal__Group_4_2__34497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__NameAssignment_5_0_in_rule__Signal__Group_5__04539 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_5__1_in_rule__Signal__Group_5__04548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Signal__Group_5__14577 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Signal__Group_5__2_in_rule__Signal__Group_5__14587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__HostTypeAssignment_5_2_in_rule__Signal__Group_5__24615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__NameAssignment_6_0_in_rule__Signal__Group_6__04655 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_6__1_in_rule__Signal__Group_6__04664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_6_1__0_in_rule__Signal__Group_6__14692 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_6__2_in_rule__Signal__Group_6__14701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Signal__Group_6__24730 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Signal__Group_6__3_in_rule__Signal__Group_6__24740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__HostTypeAssignment_6_3_in_rule__Signal__Group_6__34768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Signal__Group_6_1__04811 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Signal__Group_6_1__1_in_rule__Signal__Group_6_1__04821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__InitialValueAssignment_6_1_1_in_rule__Signal__Group_6_1__14849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__NameAssignment_7_0_in_rule__Signal__Group_7__04887 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_7__1_in_rule__Signal__Group_7__04896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_7_1__0_in_rule__Signal__Group_7__14924 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_7__2_in_rule__Signal__Group_7__14933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_7_2__0_in_rule__Signal__Group_7__24961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Signal__Group_7_1__05002 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Signal__Group_7_1__1_in_rule__Signal__Group_7_1__05012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__InitialValueAssignment_7_1_1_in_rule__Signal__Group_7_1__15040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Signal__Group_7_2__05079 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Signal__Group_7_2__1_in_rule__Signal__Group_7_2__05089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__HostTypeAssignment_7_2_1_in_rule__Signal__Group_7_2__15117 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_7_2__2_in_rule__Signal__Group_7_2__15126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Signal__Group_7_2__25155 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Signal__Group_7_2__3_in_rule__Signal__Group_7_2__25165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__HostCombineOperatorAssignment_7_2_3_in_rule__Signal__Group_7_2__35193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__NameAssignment_8_0_in_rule__Signal__Group_8__05235 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_8__1_in_rule__Signal__Group_8__05244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_8_1__0_in_rule__Signal__Group_8__15272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Signal__Group_8_1__05311 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_rule__Signal__Group_8_1__1_in_rule__Signal__Group_8_1__05321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__TypeAssignment_8_1_1_in_rule__Signal__Group_8_1__15349 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_8_1__2_in_rule__Signal__Group_8_1__15358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Signal__Group_8_1__25387 = new BitSet(new long[]{0x0000000001FE0000L});
    public static final BitSet FOLLOW_rule__Signal__Group_8_1__3_in_rule__Signal__Group_8_1__25397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__CombineOperatorAssignment_8_1_3_in_rule__Signal__Group_8_1__35425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__NameAssignment_9_0_in_rule__Signal__Group_9__05467 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_9__1_in_rule__Signal__Group_9__05476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_9_1__0_in_rule__Signal__Group_9__15504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Signal__Group_9_1__05543 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Signal__Group_9_1__1_in_rule__Signal__Group_9_1__05553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__HostTypeAssignment_9_1_1_in_rule__Signal__Group_9_1__15581 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Signal__Group_9_1__2_in_rule__Signal__Group_9_1__15590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Signal__Group_9_1__25619 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Signal__Group_9_1__3_in_rule__Signal__Group_9_1__25629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__HostCombineOperatorAssignment_9_1_3_in_rule__Signal__Group_9_1__35657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_0_in_rule__Variable__Group__05699 = new BitSet(new long[]{0x000000010101F802L});
    public static final BitSet FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__05708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_1__0_in_rule__Variable__Group__15736 = new BitSet(new long[]{0x000000000101F802L});
    public static final BitSet FOLLOW_rule__Variable__Group__2_in_rule__Variable__Group__15746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__TypeAssignment_2_in_rule__Variable__Group__25774 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__3_in_rule__Variable__Group__25784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group_3__0_in_rule__Variable__Group__35812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Variable__Group_1__05856 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Variable__Group_1__1_in_rule__Variable__Group_1__05866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__InitialValueAssignment_1_1_in_rule__Variable__Group_1__15894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Variable__Group_3__05933 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Variable__Group_3__1_in_rule__Variable__Group_3__05943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__HostTypeAssignment_3_1_in_rule__Variable__Group_3__15971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRegionSignalDec_in_rule__StateExtend__RegionsAssignment_06010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInOutputSignals_in_rule__StateExtend__InOutputSignalsAssignment_1_26041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutputSignals_in_rule__StateExtend__OutputSignalsAssignment_2_16072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInputSignals_in_rule__StateExtend__InputSignalsAssignment_3_16103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignals_in_rule__StateExtend__SignalsAssignment_4_16134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RegionSignalDec__RegionAssignment_06169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__RegionSignalDec__VarsAssignment_2_0_16204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__RegionSignalDec__VarsAssignment_2_0_2_16235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_rule__RegionSignalDec__SignalsAssignment_2_1_16266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_rule__RegionSignalDec__SignalsAssignment_2_1_2_16297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__RegionSignalDec__VarsAssignment_3_0_26328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__RegionSignalDec__VarsAssignment_3_0_3_16359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_rule__RegionSignalDec__SignalsAssignment_3_1_26390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_rule__RegionSignalDec__SignalsAssignment_3_1_3_16421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_rule__Signals__SignalsAssignment_0_06452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_rule__Signals__SignalsAssignment_0_1_16483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_rule__InputSignals__SignalsAssignment_0_06514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_rule__InputSignals__SignalsAssignment_0_1_16545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_rule__OutputSignals__SignalsAssignment_0_06576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_rule__OutputSignals__SignalsAssignment_0_1_16607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_rule__InOutputSignals__SignalsAssignment_0_06638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_rule__InOutputSignals__SignalsAssignment_0_1_16669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_06700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_1_06731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_rule__Signal__TypeAssignment_1_26762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_2_06793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Signal__InitialValueAssignment_2_1_16824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_3_06855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Signal__InitialValueAssignment_3_1_16886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_rule__Signal__TypeAssignment_3_36917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_4_06948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Signal__InitialValueAssignment_4_1_16979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_rule__Signal__TypeAssignment_4_2_17010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCombineOperator_in_rule__Signal__CombineOperatorAssignment_4_2_37041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_5_07072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Signal__HostTypeAssignment_5_27103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_6_07134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Signal__InitialValueAssignment_6_1_17165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Signal__HostTypeAssignment_6_37196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_7_07227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Signal__InitialValueAssignment_7_1_17258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Signal__HostTypeAssignment_7_2_17289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Signal__HostCombineOperatorAssignment_7_2_37320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_8_07351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_rule__Signal__TypeAssignment_8_1_17382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCombineOperator_in_rule__Signal__CombineOperatorAssignment_8_1_37413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_9_07444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Signal__HostTypeAssignment_9_1_17475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Signal__HostCombineOperatorAssignment_9_1_37506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Variable__NameAssignment_07537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Variable__InitialValueAssignment_1_17568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_rule__Variable__TypeAssignment_27599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Variable__HostTypeAssignment_3_17630 = new BitSet(new long[]{0x0000000000000002L});

}