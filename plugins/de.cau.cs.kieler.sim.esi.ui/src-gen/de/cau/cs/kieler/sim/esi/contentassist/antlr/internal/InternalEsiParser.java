package de.cau.cs.kieler.sim.esi.contentassist.antlr.internal; 

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
import de.cau.cs.kieler.sim.esi.services.EsiGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEsiParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_NUM", "RULE_LETTER", "RULE_DIGIT", "RULE_WS", "RULE_COMMENT", "'!'", "'reset'", "';'", "'%'", "'Output'", "':'", "')'", "'('"
    };
    public static final int RULE_ID=4;
    public static final int RULE_COMMENT=9;
    public static final int RULE_WS=8;
    public static final int EOF=-1;
    public static final int RULE_DIGIT=7;
    public static final int RULE_LETTER=6;
    public static final int RULE_NUM=5;

        public InternalEsiParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g"; }


     
     	private EsiGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(EsiGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuletracelist
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:60:1: entryRuletracelist : ruletracelist EOF ;
    public final void entryRuletracelist() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:61:1: ( ruletracelist EOF )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:62:1: ruletracelist EOF
            {
             before(grammarAccess.getTracelistRule()); 
            pushFollow(FOLLOW_ruletracelist_in_entryRuletracelist61);
            ruletracelist();
            _fsp--;

             after(grammarAccess.getTracelistRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuletracelist68); 

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
    // $ANTLR end entryRuletracelist


    // $ANTLR start ruletracelist
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:69:1: ruletracelist : ( ( rule__Tracelist__Group__0 ) ) ;
    public final void ruletracelist() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:73:2: ( ( ( rule__Tracelist__Group__0 ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:74:1: ( ( rule__Tracelist__Group__0 ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:74:1: ( ( rule__Tracelist__Group__0 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:75:1: ( rule__Tracelist__Group__0 )
            {
             before(grammarAccess.getTracelistAccess().getGroup()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:76:1: ( rule__Tracelist__Group__0 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:76:2: rule__Tracelist__Group__0
            {
            pushFollow(FOLLOW_rule__Tracelist__Group__0_in_ruletracelist95);
            rule__Tracelist__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTracelistAccess().getGroup()); 

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
    // $ANTLR end ruletracelist


    // $ANTLR start entryRuletrace
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:88:1: entryRuletrace : ruletrace EOF ;
    public final void entryRuletrace() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:89:1: ( ruletrace EOF )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:90:1: ruletrace EOF
            {
             before(grammarAccess.getTraceRule()); 
            pushFollow(FOLLOW_ruletrace_in_entryRuletrace122);
            ruletrace();
            _fsp--;

             after(grammarAccess.getTraceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuletrace129); 

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
    // $ANTLR end entryRuletrace


    // $ANTLR start ruletrace
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:97:1: ruletrace : ( ( rule__Trace__Group__0 ) ) ;
    public final void ruletrace() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:101:2: ( ( ( rule__Trace__Group__0 ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:102:1: ( ( rule__Trace__Group__0 ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:102:1: ( ( rule__Trace__Group__0 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:103:1: ( rule__Trace__Group__0 )
            {
             before(grammarAccess.getTraceAccess().getGroup()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:104:1: ( rule__Trace__Group__0 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:104:2: rule__Trace__Group__0
            {
            pushFollow(FOLLOW_rule__Trace__Group__0_in_ruletrace156);
            rule__Trace__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTraceAccess().getGroup()); 

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
    // $ANTLR end ruletrace


    // $ANTLR start entryRuletick
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:116:1: entryRuletick : ruletick EOF ;
    public final void entryRuletick() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:117:1: ( ruletick EOF )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:118:1: ruletick EOF
            {
             before(grammarAccess.getTickRule()); 
            pushFollow(FOLLOW_ruletick_in_entryRuletick183);
            ruletick();
            _fsp--;

             after(grammarAccess.getTickRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuletick190); 

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
    // $ANTLR end entryRuletick


    // $ANTLR start ruletick
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:125:1: ruletick : ( ( rule__Tick__Group__0 ) ) ;
    public final void ruletick() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:129:2: ( ( ( rule__Tick__Group__0 ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:130:1: ( ( rule__Tick__Group__0 ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:130:1: ( ( rule__Tick__Group__0 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:131:1: ( rule__Tick__Group__0 )
            {
             before(grammarAccess.getTickAccess().getGroup()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:132:1: ( rule__Tick__Group__0 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:132:2: rule__Tick__Group__0
            {
            pushFollow(FOLLOW_rule__Tick__Group__0_in_ruletick217);
            rule__Tick__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTickAccess().getGroup()); 

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
    // $ANTLR end ruletick


    // $ANTLR start entryRulesignal
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:144:1: entryRulesignal : rulesignal EOF ;
    public final void entryRulesignal() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:145:1: ( rulesignal EOF )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:146:1: rulesignal EOF
            {
             before(grammarAccess.getSignalRule()); 
            pushFollow(FOLLOW_rulesignal_in_entryRulesignal244);
            rulesignal();
            _fsp--;

             after(grammarAccess.getSignalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulesignal251); 

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
    // $ANTLR end entryRulesignal


    // $ANTLR start rulesignal
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:153:1: rulesignal : ( ( rule__Signal__Group__0 ) ) ;
    public final void rulesignal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:157:2: ( ( ( rule__Signal__Group__0 ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:158:1: ( ( rule__Signal__Group__0 ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:158:1: ( ( rule__Signal__Group__0 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:159:1: ( rule__Signal__Group__0 )
            {
             before(grammarAccess.getSignalAccess().getGroup()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:160:1: ( rule__Signal__Group__0 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:160:2: rule__Signal__Group__0
            {
            pushFollow(FOLLOW_rule__Signal__Group__0_in_rulesignal278);
            rule__Signal__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getGroup()); 

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
    // $ANTLR end rulesignal


    // $ANTLR start rule__Tracelist__Group__0
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:174:1: rule__Tracelist__Group__0 : ( ( rule__Tracelist__TracesAssignment_0 )? ) rule__Tracelist__Group__1 ;
    public final void rule__Tracelist__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:178:1: ( ( ( rule__Tracelist__TracesAssignment_0 )? ) rule__Tracelist__Group__1 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:179:1: ( ( rule__Tracelist__TracesAssignment_0 )? ) rule__Tracelist__Group__1
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:179:1: ( ( rule__Tracelist__TracesAssignment_0 )? )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:180:1: ( rule__Tracelist__TracesAssignment_0 )?
            {
             before(grammarAccess.getTracelistAccess().getTracesAssignment_0()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:181:1: ( rule__Tracelist__TracesAssignment_0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID||(LA1_0>=12 && LA1_0<=13)) ) {
                alt1=1;
            }
            else if ( (LA1_0==10) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:181:2: rule__Tracelist__TracesAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Tracelist__TracesAssignment_0_in_rule__Tracelist__Group__0316);
                    rule__Tracelist__TracesAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTracelistAccess().getTracesAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__Tracelist__Group__1_in_rule__Tracelist__Group__0326);
            rule__Tracelist__Group__1();
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
    // $ANTLR end rule__Tracelist__Group__0


    // $ANTLR start rule__Tracelist__Group__1
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:192:1: rule__Tracelist__Group__1 : ( ( ( rule__Tracelist__Group_1__0 ) ) ( ( rule__Tracelist__Group_1__0 )* ) ) ;
    public final void rule__Tracelist__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:196:1: ( ( ( ( rule__Tracelist__Group_1__0 ) ) ( ( rule__Tracelist__Group_1__0 )* ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:197:1: ( ( ( rule__Tracelist__Group_1__0 ) ) ( ( rule__Tracelist__Group_1__0 )* ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:197:1: ( ( ( rule__Tracelist__Group_1__0 ) ) ( ( rule__Tracelist__Group_1__0 )* ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:198:1: ( ( rule__Tracelist__Group_1__0 ) ) ( ( rule__Tracelist__Group_1__0 )* )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:198:1: ( ( rule__Tracelist__Group_1__0 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:199:1: ( rule__Tracelist__Group_1__0 )
            {
             before(grammarAccess.getTracelistAccess().getGroup_1()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:200:1: ( rule__Tracelist__Group_1__0 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:200:2: rule__Tracelist__Group_1__0
            {
            pushFollow(FOLLOW_rule__Tracelist__Group_1__0_in_rule__Tracelist__Group__1356);
            rule__Tracelist__Group_1__0();
            _fsp--;


            }

             after(grammarAccess.getTracelistAccess().getGroup_1()); 

            }

            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:203:1: ( ( rule__Tracelist__Group_1__0 )* )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:204:1: ( rule__Tracelist__Group_1__0 )*
            {
             before(grammarAccess.getTracelistAccess().getGroup_1()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:205:1: ( rule__Tracelist__Group_1__0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==10) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:205:2: rule__Tracelist__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Tracelist__Group_1__0_in_rule__Tracelist__Group__1368);
            	    rule__Tracelist__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getTracelistAccess().getGroup_1()); 

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
    // $ANTLR end rule__Tracelist__Group__1


    // $ANTLR start rule__Tracelist__Group_1__0
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:220:1: rule__Tracelist__Group_1__0 : ( '!' ) rule__Tracelist__Group_1__1 ;
    public final void rule__Tracelist__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:224:1: ( ( '!' ) rule__Tracelist__Group_1__1 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:225:1: ( '!' ) rule__Tracelist__Group_1__1
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:225:1: ( '!' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:226:1: '!'
            {
             before(grammarAccess.getTracelistAccess().getExclamationMarkKeyword_1_0()); 
            match(input,10,FOLLOW_10_in_rule__Tracelist__Group_1__0410); 
             after(grammarAccess.getTracelistAccess().getExclamationMarkKeyword_1_0()); 

            }

            pushFollow(FOLLOW_rule__Tracelist__Group_1__1_in_rule__Tracelist__Group_1__0420);
            rule__Tracelist__Group_1__1();
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
    // $ANTLR end rule__Tracelist__Group_1__0


    // $ANTLR start rule__Tracelist__Group_1__1
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:240:1: rule__Tracelist__Group_1__1 : ( 'reset' ) rule__Tracelist__Group_1__2 ;
    public final void rule__Tracelist__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:244:1: ( ( 'reset' ) rule__Tracelist__Group_1__2 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:245:1: ( 'reset' ) rule__Tracelist__Group_1__2
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:245:1: ( 'reset' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:246:1: 'reset'
            {
             before(grammarAccess.getTracelistAccess().getResetKeyword_1_1()); 
            match(input,11,FOLLOW_11_in_rule__Tracelist__Group_1__1449); 
             after(grammarAccess.getTracelistAccess().getResetKeyword_1_1()); 

            }

            pushFollow(FOLLOW_rule__Tracelist__Group_1__2_in_rule__Tracelist__Group_1__1459);
            rule__Tracelist__Group_1__2();
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
    // $ANTLR end rule__Tracelist__Group_1__1


    // $ANTLR start rule__Tracelist__Group_1__2
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:260:1: rule__Tracelist__Group_1__2 : ( ';' ) rule__Tracelist__Group_1__3 ;
    public final void rule__Tracelist__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:264:1: ( ( ';' ) rule__Tracelist__Group_1__3 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:265:1: ( ';' ) rule__Tracelist__Group_1__3
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:265:1: ( ';' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:266:1: ';'
            {
             before(grammarAccess.getTracelistAccess().getSemicolonKeyword_1_2()); 
            match(input,12,FOLLOW_12_in_rule__Tracelist__Group_1__2488); 
             after(grammarAccess.getTracelistAccess().getSemicolonKeyword_1_2()); 

            }

            pushFollow(FOLLOW_rule__Tracelist__Group_1__3_in_rule__Tracelist__Group_1__2498);
            rule__Tracelist__Group_1__3();
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
    // $ANTLR end rule__Tracelist__Group_1__2


    // $ANTLR start rule__Tracelist__Group_1__3
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:280:1: rule__Tracelist__Group_1__3 : ( ( rule__Tracelist__TracesAssignment_1_3 ) ) ;
    public final void rule__Tracelist__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:284:1: ( ( ( rule__Tracelist__TracesAssignment_1_3 ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:285:1: ( ( rule__Tracelist__TracesAssignment_1_3 ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:285:1: ( ( rule__Tracelist__TracesAssignment_1_3 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:286:1: ( rule__Tracelist__TracesAssignment_1_3 )
            {
             before(grammarAccess.getTracelistAccess().getTracesAssignment_1_3()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:287:1: ( rule__Tracelist__TracesAssignment_1_3 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:287:2: rule__Tracelist__TracesAssignment_1_3
            {
            pushFollow(FOLLOW_rule__Tracelist__TracesAssignment_1_3_in_rule__Tracelist__Group_1__3526);
            rule__Tracelist__TracesAssignment_1_3();
            _fsp--;


            }

             after(grammarAccess.getTracelistAccess().getTracesAssignment_1_3()); 

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
    // $ANTLR end rule__Tracelist__Group_1__3


    // $ANTLR start rule__Trace__Group__0
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:305:1: rule__Trace__Group__0 : ( () ) rule__Trace__Group__1 ;
    public final void rule__Trace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:309:1: ( ( () ) rule__Trace__Group__1 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:310:1: ( () ) rule__Trace__Group__1
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:310:1: ( () )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:311:1: ()
            {
             before(grammarAccess.getTraceAccess().getTraceAction_0()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:312:1: ()
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:314:1: 
            {
            }

             after(grammarAccess.getTraceAccess().getTraceAction_0()); 

            }

            pushFollow(FOLLOW_rule__Trace__Group__1_in_rule__Trace__Group__0578);
            rule__Trace__Group__1();
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
    // $ANTLR end rule__Trace__Group__0


    // $ANTLR start rule__Trace__Group__1
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:325:1: rule__Trace__Group__1 : ( ( rule__Trace__TicksAssignment_1 )* ) ;
    public final void rule__Trace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:329:1: ( ( ( rule__Trace__TicksAssignment_1 )* ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:330:1: ( ( rule__Trace__TicksAssignment_1 )* )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:330:1: ( ( rule__Trace__TicksAssignment_1 )* )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:331:1: ( rule__Trace__TicksAssignment_1 )*
            {
             before(grammarAccess.getTraceAccess().getTicksAssignment_1()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:332:1: ( rule__Trace__TicksAssignment_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID||(LA3_0>=12 && LA3_0<=13)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:332:2: rule__Trace__TicksAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Trace__TicksAssignment_1_in_rule__Trace__Group__1606);
            	    rule__Trace__TicksAssignment_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getTraceAccess().getTicksAssignment_1()); 

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
    // $ANTLR end rule__Trace__Group__1


    // $ANTLR start rule__Tick__Group__0
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:346:1: rule__Tick__Group__0 : ( ( rule__Tick__InputAssignment_0 )* ) rule__Tick__Group__1 ;
    public final void rule__Tick__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:350:1: ( ( ( rule__Tick__InputAssignment_0 )* ) rule__Tick__Group__1 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:351:1: ( ( rule__Tick__InputAssignment_0 )* ) rule__Tick__Group__1
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:351:1: ( ( rule__Tick__InputAssignment_0 )* )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:352:1: ( rule__Tick__InputAssignment_0 )*
            {
             before(grammarAccess.getTickAccess().getInputAssignment_0()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:353:1: ( rule__Tick__InputAssignment_0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:353:2: rule__Tick__InputAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Tick__InputAssignment_0_in_rule__Tick__Group__0645);
            	    rule__Tick__InputAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getTickAccess().getInputAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__Tick__Group__1_in_rule__Tick__Group__0655);
            rule__Tick__Group__1();
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
    // $ANTLR end rule__Tick__Group__0


    // $ANTLR start rule__Tick__Group__1
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:364:1: rule__Tick__Group__1 : ( ( rule__Tick__Group_1__0 )? ) rule__Tick__Group__2 ;
    public final void rule__Tick__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:368:1: ( ( ( rule__Tick__Group_1__0 )? ) rule__Tick__Group__2 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:369:1: ( ( rule__Tick__Group_1__0 )? ) rule__Tick__Group__2
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:369:1: ( ( rule__Tick__Group_1__0 )? )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:370:1: ( rule__Tick__Group_1__0 )?
            {
             before(grammarAccess.getTickAccess().getGroup_1()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:371:1: ( rule__Tick__Group_1__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:371:2: rule__Tick__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Tick__Group_1__0_in_rule__Tick__Group__1683);
                    rule__Tick__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTickAccess().getGroup_1()); 

            }

            pushFollow(FOLLOW_rule__Tick__Group__2_in_rule__Tick__Group__1693);
            rule__Tick__Group__2();
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
    // $ANTLR end rule__Tick__Group__1


    // $ANTLR start rule__Tick__Group__2
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:382:1: rule__Tick__Group__2 : ( ( rule__Tick__NAssignment_2 ) ) ;
    public final void rule__Tick__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:386:1: ( ( ( rule__Tick__NAssignment_2 ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:387:1: ( ( rule__Tick__NAssignment_2 ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:387:1: ( ( rule__Tick__NAssignment_2 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:388:1: ( rule__Tick__NAssignment_2 )
            {
             before(grammarAccess.getTickAccess().getNAssignment_2()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:389:1: ( rule__Tick__NAssignment_2 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:389:2: rule__Tick__NAssignment_2
            {
            pushFollow(FOLLOW_rule__Tick__NAssignment_2_in_rule__Tick__Group__2721);
            rule__Tick__NAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getTickAccess().getNAssignment_2()); 

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
    // $ANTLR end rule__Tick__Group__2


    // $ANTLR start rule__Tick__Group_1__0
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:405:1: rule__Tick__Group_1__0 : ( '%' ) rule__Tick__Group_1__1 ;
    public final void rule__Tick__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:409:1: ( ( '%' ) rule__Tick__Group_1__1 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:410:1: ( '%' ) rule__Tick__Group_1__1
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:410:1: ( '%' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:411:1: '%'
            {
             before(grammarAccess.getTickAccess().getPercentSignKeyword_1_0()); 
            match(input,13,FOLLOW_13_in_rule__Tick__Group_1__0762); 
             after(grammarAccess.getTickAccess().getPercentSignKeyword_1_0()); 

            }

            pushFollow(FOLLOW_rule__Tick__Group_1__1_in_rule__Tick__Group_1__0772);
            rule__Tick__Group_1__1();
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
    // $ANTLR end rule__Tick__Group_1__0


    // $ANTLR start rule__Tick__Group_1__1
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:425:1: rule__Tick__Group_1__1 : ( 'Output' ) rule__Tick__Group_1__2 ;
    public final void rule__Tick__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:429:1: ( ( 'Output' ) rule__Tick__Group_1__2 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:430:1: ( 'Output' ) rule__Tick__Group_1__2
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:430:1: ( 'Output' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:431:1: 'Output'
            {
             before(grammarAccess.getTickAccess().getOutputKeyword_1_1()); 
            match(input,14,FOLLOW_14_in_rule__Tick__Group_1__1801); 
             after(grammarAccess.getTickAccess().getOutputKeyword_1_1()); 

            }

            pushFollow(FOLLOW_rule__Tick__Group_1__2_in_rule__Tick__Group_1__1811);
            rule__Tick__Group_1__2();
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
    // $ANTLR end rule__Tick__Group_1__1


    // $ANTLR start rule__Tick__Group_1__2
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:445:1: rule__Tick__Group_1__2 : ( ':' ) rule__Tick__Group_1__3 ;
    public final void rule__Tick__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:449:1: ( ( ':' ) rule__Tick__Group_1__3 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:450:1: ( ':' ) rule__Tick__Group_1__3
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:450:1: ( ':' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:451:1: ':'
            {
             before(grammarAccess.getTickAccess().getColonKeyword_1_2()); 
            match(input,15,FOLLOW_15_in_rule__Tick__Group_1__2840); 
             after(grammarAccess.getTickAccess().getColonKeyword_1_2()); 

            }

            pushFollow(FOLLOW_rule__Tick__Group_1__3_in_rule__Tick__Group_1__2850);
            rule__Tick__Group_1__3();
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
    // $ANTLR end rule__Tick__Group_1__2


    // $ANTLR start rule__Tick__Group_1__3
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:465:1: rule__Tick__Group_1__3 : ( ( rule__Tick__OutputAssignment_1_3 )* ) ;
    public final void rule__Tick__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:469:1: ( ( ( rule__Tick__OutputAssignment_1_3 )* ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:470:1: ( ( rule__Tick__OutputAssignment_1_3 )* )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:470:1: ( ( rule__Tick__OutputAssignment_1_3 )* )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:471:1: ( rule__Tick__OutputAssignment_1_3 )*
            {
             before(grammarAccess.getTickAccess().getOutputAssignment_1_3()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:472:1: ( rule__Tick__OutputAssignment_1_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:472:2: rule__Tick__OutputAssignment_1_3
            	    {
            	    pushFollow(FOLLOW_rule__Tick__OutputAssignment_1_3_in_rule__Tick__Group_1__3878);
            	    rule__Tick__OutputAssignment_1_3();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getTickAccess().getOutputAssignment_1_3()); 

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
    // $ANTLR end rule__Tick__Group_1__3


    // $ANTLR start rule__Signal__Group__0
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:490:1: rule__Signal__Group__0 : ( ( rule__Signal__NameAssignment_0 ) ) rule__Signal__Group__1 ;
    public final void rule__Signal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:494:1: ( ( ( rule__Signal__NameAssignment_0 ) ) rule__Signal__Group__1 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:495:1: ( ( rule__Signal__NameAssignment_0 ) ) rule__Signal__Group__1
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:495:1: ( ( rule__Signal__NameAssignment_0 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:496:1: ( rule__Signal__NameAssignment_0 )
            {
             before(grammarAccess.getSignalAccess().getNameAssignment_0()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:497:1: ( rule__Signal__NameAssignment_0 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:497:2: rule__Signal__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Signal__NameAssignment_0_in_rule__Signal__Group__0921);
            rule__Signal__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getNameAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group__1_in_rule__Signal__Group__0930);
            rule__Signal__Group__1();
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
    // $ANTLR end rule__Signal__Group__0


    // $ANTLR start rule__Signal__Group__1
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:508:1: rule__Signal__Group__1 : ( ( rule__Signal__Group_1__0 )? ) ;
    public final void rule__Signal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:512:1: ( ( ( rule__Signal__Group_1__0 )? ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:513:1: ( ( rule__Signal__Group_1__0 )? )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:513:1: ( ( rule__Signal__Group_1__0 )? )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:514:1: ( rule__Signal__Group_1__0 )?
            {
             before(grammarAccess.getSignalAccess().getGroup_1()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:515:1: ( rule__Signal__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:515:2: rule__Signal__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Signal__Group_1__0_in_rule__Signal__Group__1958);
                    rule__Signal__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSignalAccess().getGroup_1()); 

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
    // $ANTLR end rule__Signal__Group__1


    // $ANTLR start rule__Signal__Group_1__0
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:529:1: rule__Signal__Group_1__0 : ( ( rule__Signal__ValuedAssignment_1_0 ) ) rule__Signal__Group_1__1 ;
    public final void rule__Signal__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:533:1: ( ( ( rule__Signal__ValuedAssignment_1_0 ) ) rule__Signal__Group_1__1 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:534:1: ( ( rule__Signal__ValuedAssignment_1_0 ) ) rule__Signal__Group_1__1
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:534:1: ( ( rule__Signal__ValuedAssignment_1_0 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:535:1: ( rule__Signal__ValuedAssignment_1_0 )
            {
             before(grammarAccess.getSignalAccess().getValuedAssignment_1_0()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:536:1: ( rule__Signal__ValuedAssignment_1_0 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:536:2: rule__Signal__ValuedAssignment_1_0
            {
            pushFollow(FOLLOW_rule__Signal__ValuedAssignment_1_0_in_rule__Signal__Group_1__0997);
            rule__Signal__ValuedAssignment_1_0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getValuedAssignment_1_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_1__1_in_rule__Signal__Group_1__01006);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:547:1: rule__Signal__Group_1__1 : ( ( rule__Signal__ValAssignment_1_1 ) ) rule__Signal__Group_1__2 ;
    public final void rule__Signal__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:551:1: ( ( ( rule__Signal__ValAssignment_1_1 ) ) rule__Signal__Group_1__2 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:552:1: ( ( rule__Signal__ValAssignment_1_1 ) ) rule__Signal__Group_1__2
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:552:1: ( ( rule__Signal__ValAssignment_1_1 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:553:1: ( rule__Signal__ValAssignment_1_1 )
            {
             before(grammarAccess.getSignalAccess().getValAssignment_1_1()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:554:1: ( rule__Signal__ValAssignment_1_1 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:554:2: rule__Signal__ValAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Signal__ValAssignment_1_1_in_rule__Signal__Group_1__11034);
            rule__Signal__ValAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getValAssignment_1_1()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_1__2_in_rule__Signal__Group_1__11043);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:565:1: rule__Signal__Group_1__2 : ( ')' ) ;
    public final void rule__Signal__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:569:1: ( ( ')' ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:570:1: ( ')' )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:570:1: ( ')' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:571:1: ')'
            {
             before(grammarAccess.getSignalAccess().getRightParenthesisKeyword_1_2()); 
            match(input,16,FOLLOW_16_in_rule__Signal__Group_1__21072); 
             after(grammarAccess.getSignalAccess().getRightParenthesisKeyword_1_2()); 

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


    // $ANTLR start rule__Tracelist__TracesAssignment_0
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:590:1: rule__Tracelist__TracesAssignment_0 : ( ruletrace ) ;
    public final void rule__Tracelist__TracesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:594:1: ( ( ruletrace ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:595:1: ( ruletrace )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:595:1: ( ruletrace )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:596:1: ruletrace
            {
             before(grammarAccess.getTracelistAccess().getTracesTraceParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruletrace_in_rule__Tracelist__TracesAssignment_01113);
            ruletrace();
            _fsp--;

             after(grammarAccess.getTracelistAccess().getTracesTraceParserRuleCall_0_0()); 

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
    // $ANTLR end rule__Tracelist__TracesAssignment_0


    // $ANTLR start rule__Tracelist__TracesAssignment_1_3
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:605:1: rule__Tracelist__TracesAssignment_1_3 : ( ruletrace ) ;
    public final void rule__Tracelist__TracesAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:609:1: ( ( ruletrace ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:610:1: ( ruletrace )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:610:1: ( ruletrace )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:611:1: ruletrace
            {
             before(grammarAccess.getTracelistAccess().getTracesTraceParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_ruletrace_in_rule__Tracelist__TracesAssignment_1_31144);
            ruletrace();
            _fsp--;

             after(grammarAccess.getTracelistAccess().getTracesTraceParserRuleCall_1_3_0()); 

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
    // $ANTLR end rule__Tracelist__TracesAssignment_1_3


    // $ANTLR start rule__Trace__TicksAssignment_1
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:620:1: rule__Trace__TicksAssignment_1 : ( ruletick ) ;
    public final void rule__Trace__TicksAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:624:1: ( ( ruletick ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:625:1: ( ruletick )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:625:1: ( ruletick )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:626:1: ruletick
            {
             before(grammarAccess.getTraceAccess().getTicksTickParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruletick_in_rule__Trace__TicksAssignment_11175);
            ruletick();
            _fsp--;

             after(grammarAccess.getTraceAccess().getTicksTickParserRuleCall_1_0()); 

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
    // $ANTLR end rule__Trace__TicksAssignment_1


    // $ANTLR start rule__Tick__InputAssignment_0
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:635:1: rule__Tick__InputAssignment_0 : ( rulesignal ) ;
    public final void rule__Tick__InputAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:639:1: ( ( rulesignal ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:640:1: ( rulesignal )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:640:1: ( rulesignal )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:641:1: rulesignal
            {
             before(grammarAccess.getTickAccess().getInputSignalParserRuleCall_0_0()); 
            pushFollow(FOLLOW_rulesignal_in_rule__Tick__InputAssignment_01206);
            rulesignal();
            _fsp--;

             after(grammarAccess.getTickAccess().getInputSignalParserRuleCall_0_0()); 

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
    // $ANTLR end rule__Tick__InputAssignment_0


    // $ANTLR start rule__Tick__OutputAssignment_1_3
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:650:1: rule__Tick__OutputAssignment_1_3 : ( rulesignal ) ;
    public final void rule__Tick__OutputAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:654:1: ( ( rulesignal ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:655:1: ( rulesignal )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:655:1: ( rulesignal )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:656:1: rulesignal
            {
             before(grammarAccess.getTickAccess().getOutputSignalParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_rulesignal_in_rule__Tick__OutputAssignment_1_31237);
            rulesignal();
            _fsp--;

             after(grammarAccess.getTickAccess().getOutputSignalParserRuleCall_1_3_0()); 

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
    // $ANTLR end rule__Tick__OutputAssignment_1_3


    // $ANTLR start rule__Tick__NAssignment_2
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:665:1: rule__Tick__NAssignment_2 : ( ( ';' ) ) ;
    public final void rule__Tick__NAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:669:1: ( ( ( ';' ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:670:1: ( ( ';' ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:670:1: ( ( ';' ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:671:1: ( ';' )
            {
             before(grammarAccess.getTickAccess().getNSemicolonKeyword_2_0()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:672:1: ( ';' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:673:1: ';'
            {
             before(grammarAccess.getTickAccess().getNSemicolonKeyword_2_0()); 
            match(input,12,FOLLOW_12_in_rule__Tick__NAssignment_21273); 
             after(grammarAccess.getTickAccess().getNSemicolonKeyword_2_0()); 

            }

             after(grammarAccess.getTickAccess().getNSemicolonKeyword_2_0()); 

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
    // $ANTLR end rule__Tick__NAssignment_2


    // $ANTLR start rule__Signal__NameAssignment_0
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:688:1: rule__Signal__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Signal__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:692:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:693:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:693:1: ( RULE_ID )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:694:1: RULE_ID
            {
             before(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_01312); 
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


    // $ANTLR start rule__Signal__ValuedAssignment_1_0
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:703:1: rule__Signal__ValuedAssignment_1_0 : ( ( '(' ) ) ;
    public final void rule__Signal__ValuedAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:707:1: ( ( ( '(' ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:708:1: ( ( '(' ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:708:1: ( ( '(' ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:709:1: ( '(' )
            {
             before(grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0_0()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:710:1: ( '(' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:711:1: '('
            {
             before(grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0_0()); 
            match(input,17,FOLLOW_17_in_rule__Signal__ValuedAssignment_1_01348); 
             after(grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0_0()); 

            }

             after(grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0_0()); 

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
    // $ANTLR end rule__Signal__ValuedAssignment_1_0


    // $ANTLR start rule__Signal__ValAssignment_1_1
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:726:1: rule__Signal__ValAssignment_1_1 : ( RULE_NUM ) ;
    public final void rule__Signal__ValAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:730:1: ( ( RULE_NUM ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:731:1: ( RULE_NUM )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:731:1: ( RULE_NUM )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/sim/esi/contentassist/antlr/internal/InternalEsi.g:732:1: RULE_NUM
            {
             before(grammarAccess.getSignalAccess().getValNUMTerminalRuleCall_1_1_0()); 
            match(input,RULE_NUM,FOLLOW_RULE_NUM_in_rule__Signal__ValAssignment_1_11387); 
             after(grammarAccess.getSignalAccess().getValNUMTerminalRuleCall_1_1_0()); 

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
    // $ANTLR end rule__Signal__ValAssignment_1_1


 

    public static final BitSet FOLLOW_ruletracelist_in_entryRuletracelist61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletracelist68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tracelist__Group__0_in_ruletracelist95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletrace_in_entryRuletrace122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletrace129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Trace__Group__0_in_ruletrace156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletick_in_entryRuletick183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletick190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tick__Group__0_in_ruletick217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesignal_in_entryRulesignal244 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulesignal251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group__0_in_rulesignal278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tracelist__TracesAssignment_0_in_rule__Tracelist__Group__0316 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__Tracelist__Group__1_in_rule__Tracelist__Group__0326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tracelist__Group_1__0_in_rule__Tracelist__Group__1356 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_rule__Tracelist__Group_1__0_in_rule__Tracelist__Group__1368 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_rule__Tracelist__Group_1__0410 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__Tracelist__Group_1__1_in_rule__Tracelist__Group_1__0420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Tracelist__Group_1__1449 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Tracelist__Group_1__2_in_rule__Tracelist__Group_1__1459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Tracelist__Group_1__2488 = new BitSet(new long[]{0x0000000000003012L});
    public static final BitSet FOLLOW_rule__Tracelist__Group_1__3_in_rule__Tracelist__Group_1__2498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tracelist__TracesAssignment_1_3_in_rule__Tracelist__Group_1__3526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Trace__Group__1_in_rule__Trace__Group__0578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Trace__TicksAssignment_1_in_rule__Trace__Group__1606 = new BitSet(new long[]{0x0000000000003012L});
    public static final BitSet FOLLOW_rule__Tick__InputAssignment_0_in_rule__Tick__Group__0645 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__Tick__Group__1_in_rule__Tick__Group__0655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tick__Group_1__0_in_rule__Tick__Group__1683 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Tick__Group__2_in_rule__Tick__Group__1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tick__NAssignment_2_in_rule__Tick__Group__2721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Tick__Group_1__0762 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Tick__Group_1__1_in_rule__Tick__Group_1__0772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Tick__Group_1__1801 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Tick__Group_1__2_in_rule__Tick__Group_1__1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Tick__Group_1__2840 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Tick__Group_1__3_in_rule__Tick__Group_1__2850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tick__OutputAssignment_1_3_in_rule__Tick__Group_1__3878 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Signal__NameAssignment_0_in_rule__Signal__Group__0921 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__Signal__Group__1_in_rule__Signal__Group__0930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_1__0_in_rule__Signal__Group__1958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__ValuedAssignment_1_0_in_rule__Signal__Group_1__0997 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Signal__Group_1__1_in_rule__Signal__Group_1__01006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__ValAssignment_1_1_in_rule__Signal__Group_1__11034 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Signal__Group_1__2_in_rule__Signal__Group_1__11043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Signal__Group_1__21072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletrace_in_rule__Tracelist__TracesAssignment_01113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletrace_in_rule__Tracelist__TracesAssignment_1_31144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletick_in_rule__Trace__TicksAssignment_11175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesignal_in_rule__Tick__InputAssignment_01206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesignal_in_rule__Tick__OutputAssignment_1_31237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Tick__NAssignment_21273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_01312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Signal__ValuedAssignment_1_01348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUM_in_rule__Signal__ValAssignment_1_11387 = new BitSet(new long[]{0x0000000000000002L});

}