package de.cau.cs.kieler.contentassist.antlr.internal; 

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
import de.cau.cs.kieler.services.EsiGrammarAccess;



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
    public String getGrammarFileName() { return "../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g"; }


     
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:60:1: entryRuletracelist : ruletracelist EOF ;
    public final void entryRuletracelist() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:60:20: ( ruletracelist EOF )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:61:1: ruletracelist EOF
            {
             before(grammarAccess.getTracelistRule()); 
            pushFollow(FOLLOW_ruletracelist_in_entryRuletracelist60);
            ruletracelist();
            _fsp--;

             after(grammarAccess.getTracelistRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuletracelist67); 

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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:68:1: ruletracelist : ( ( rule__Tracelist__Group__0 ) ) ;
    public final void ruletracelist() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:72:2: ( ( ( rule__Tracelist__Group__0 ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:73:1: ( ( rule__Tracelist__Group__0 ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:73:1: ( ( rule__Tracelist__Group__0 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:74:1: ( rule__Tracelist__Group__0 )
            {
             before(grammarAccess.getTracelistAccess().getGroup()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:75:1: ( rule__Tracelist__Group__0 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:75:2: rule__Tracelist__Group__0
            {
            pushFollow(FOLLOW_rule__Tracelist__Group__0_in_ruletracelist94);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:87:1: entryRuletrace : ruletrace EOF ;
    public final void entryRuletrace() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:87:16: ( ruletrace EOF )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:88:1: ruletrace EOF
            {
             before(grammarAccess.getTraceRule()); 
            pushFollow(FOLLOW_ruletrace_in_entryRuletrace120);
            ruletrace();
            _fsp--;

             after(grammarAccess.getTraceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuletrace127); 

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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:95:1: ruletrace : ( ( ( rule__Trace__TicksAssignment ) ) ( ( rule__Trace__TicksAssignment )* ) ) ;
    public final void ruletrace() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:99:2: ( ( ( ( rule__Trace__TicksAssignment ) ) ( ( rule__Trace__TicksAssignment )* ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:100:1: ( ( ( rule__Trace__TicksAssignment ) ) ( ( rule__Trace__TicksAssignment )* ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:100:1: ( ( ( rule__Trace__TicksAssignment ) ) ( ( rule__Trace__TicksAssignment )* ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:101:1: ( ( rule__Trace__TicksAssignment ) ) ( ( rule__Trace__TicksAssignment )* )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:101:1: ( ( rule__Trace__TicksAssignment ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:102:1: ( rule__Trace__TicksAssignment )
            {
             before(grammarAccess.getTraceAccess().getTicksAssignment()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:103:1: ( rule__Trace__TicksAssignment )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:103:2: rule__Trace__TicksAssignment
            {
            pushFollow(FOLLOW_rule__Trace__TicksAssignment_in_ruletrace156);
            rule__Trace__TicksAssignment();
            _fsp--;


            }

             after(grammarAccess.getTraceAccess().getTicksAssignment()); 

            }

            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:106:1: ( ( rule__Trace__TicksAssignment )* )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:107:1: ( rule__Trace__TicksAssignment )*
            {
             before(grammarAccess.getTraceAccess().getTicksAssignment()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:108:1: ( rule__Trace__TicksAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||(LA1_0>=12 && LA1_0<=13)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:108:2: rule__Trace__TicksAssignment
            	    {
            	    pushFollow(FOLLOW_rule__Trace__TicksAssignment_in_ruletrace168);
            	    rule__Trace__TicksAssignment();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getTraceAccess().getTicksAssignment()); 

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
    // $ANTLR end ruletrace


    // $ANTLR start entryRuletick
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:121:1: entryRuletick : ruletick EOF ;
    public final void entryRuletick() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:121:15: ( ruletick EOF )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:122:1: ruletick EOF
            {
             before(grammarAccess.getTickRule()); 
            pushFollow(FOLLOW_ruletick_in_entryRuletick197);
            ruletick();
            _fsp--;

             after(grammarAccess.getTickRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuletick204); 

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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:129:1: ruletick : ( ( rule__Tick__Group__0 ) ) ;
    public final void ruletick() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:133:2: ( ( ( rule__Tick__Group__0 ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:134:1: ( ( rule__Tick__Group__0 ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:134:1: ( ( rule__Tick__Group__0 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:135:1: ( rule__Tick__Group__0 )
            {
             before(grammarAccess.getTickAccess().getGroup()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:136:1: ( rule__Tick__Group__0 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:136:2: rule__Tick__Group__0
            {
            pushFollow(FOLLOW_rule__Tick__Group__0_in_ruletick231);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:148:1: entryRulesignal : rulesignal EOF ;
    public final void entryRulesignal() throws RecognitionException {
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:148:17: ( rulesignal EOF )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:149:1: rulesignal EOF
            {
             before(grammarAccess.getSignalRule()); 
            pushFollow(FOLLOW_rulesignal_in_entryRulesignal257);
            rulesignal();
            _fsp--;

             after(grammarAccess.getSignalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulesignal264); 

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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:156:1: rulesignal : ( ( rule__Signal__Group__0 ) ) ;
    public final void rulesignal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:160:2: ( ( ( rule__Signal__Group__0 ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:161:1: ( ( rule__Signal__Group__0 ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:161:1: ( ( rule__Signal__Group__0 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:162:1: ( rule__Signal__Group__0 )
            {
             before(grammarAccess.getSignalAccess().getGroup()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:163:1: ( rule__Signal__Group__0 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:163:2: rule__Signal__Group__0
            {
            pushFollow(FOLLOW_rule__Signal__Group__0_in_rulesignal291);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:177:1: rule__Tracelist__Group__0 : ( ( rule__Tracelist__TracesAssignment_0 )? ) rule__Tracelist__Group__1 ;
    public final void rule__Tracelist__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:181:1: ( ( ( rule__Tracelist__TracesAssignment_0 )? ) rule__Tracelist__Group__1 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:182:1: ( ( rule__Tracelist__TracesAssignment_0 )? ) rule__Tracelist__Group__1
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:182:1: ( ( rule__Tracelist__TracesAssignment_0 )? )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:183:1: ( rule__Tracelist__TracesAssignment_0 )?
            {
             before(grammarAccess.getTracelistAccess().getTracesAssignment_0()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:184:1: ( rule__Tracelist__TracesAssignment_0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID||(LA2_0>=12 && LA2_0<=13)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:184:2: rule__Tracelist__TracesAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Tracelist__TracesAssignment_0_in_rule__Tracelist__Group__0329);
                    rule__Tracelist__TracesAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTracelistAccess().getTracesAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__Tracelist__Group__1_in_rule__Tracelist__Group__0339);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:195:1: rule__Tracelist__Group__1 : ( ( ( rule__Tracelist__Group_1__0 ) ) ( ( rule__Tracelist__Group_1__0 )* ) ) ;
    public final void rule__Tracelist__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:199:1: ( ( ( ( rule__Tracelist__Group_1__0 ) ) ( ( rule__Tracelist__Group_1__0 )* ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:200:1: ( ( ( rule__Tracelist__Group_1__0 ) ) ( ( rule__Tracelist__Group_1__0 )* ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:200:1: ( ( ( rule__Tracelist__Group_1__0 ) ) ( ( rule__Tracelist__Group_1__0 )* ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:201:1: ( ( rule__Tracelist__Group_1__0 ) ) ( ( rule__Tracelist__Group_1__0 )* )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:201:1: ( ( rule__Tracelist__Group_1__0 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:202:1: ( rule__Tracelist__Group_1__0 )
            {
             before(grammarAccess.getTracelistAccess().getGroup_1()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:203:1: ( rule__Tracelist__Group_1__0 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:203:2: rule__Tracelist__Group_1__0
            {
            pushFollow(FOLLOW_rule__Tracelist__Group_1__0_in_rule__Tracelist__Group__1369);
            rule__Tracelist__Group_1__0();
            _fsp--;


            }

             after(grammarAccess.getTracelistAccess().getGroup_1()); 

            }

            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:206:1: ( ( rule__Tracelist__Group_1__0 )* )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:207:1: ( rule__Tracelist__Group_1__0 )*
            {
             before(grammarAccess.getTracelistAccess().getGroup_1()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:208:1: ( rule__Tracelist__Group_1__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==10) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:208:2: rule__Tracelist__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Tracelist__Group_1__0_in_rule__Tracelist__Group__1381);
            	    rule__Tracelist__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:223:1: rule__Tracelist__Group_1__0 : ( '!' ) rule__Tracelist__Group_1__1 ;
    public final void rule__Tracelist__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:227:1: ( ( '!' ) rule__Tracelist__Group_1__1 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:228:1: ( '!' ) rule__Tracelist__Group_1__1
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:228:1: ( '!' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:229:1: '!'
            {
             before(grammarAccess.getTracelistAccess().getExclamationMarkKeyword_1_0()); 
            match(input,10,FOLLOW_10_in_rule__Tracelist__Group_1__0423); 
             after(grammarAccess.getTracelistAccess().getExclamationMarkKeyword_1_0()); 

            }

            pushFollow(FOLLOW_rule__Tracelist__Group_1__1_in_rule__Tracelist__Group_1__0433);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:243:1: rule__Tracelist__Group_1__1 : ( 'reset' ) rule__Tracelist__Group_1__2 ;
    public final void rule__Tracelist__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:247:1: ( ( 'reset' ) rule__Tracelist__Group_1__2 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:248:1: ( 'reset' ) rule__Tracelist__Group_1__2
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:248:1: ( 'reset' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:249:1: 'reset'
            {
             before(grammarAccess.getTracelistAccess().getResetKeyword_1_1()); 
            match(input,11,FOLLOW_11_in_rule__Tracelist__Group_1__1462); 
             after(grammarAccess.getTracelistAccess().getResetKeyword_1_1()); 

            }

            pushFollow(FOLLOW_rule__Tracelist__Group_1__2_in_rule__Tracelist__Group_1__1472);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:263:1: rule__Tracelist__Group_1__2 : ( ';' ) rule__Tracelist__Group_1__3 ;
    public final void rule__Tracelist__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:267:1: ( ( ';' ) rule__Tracelist__Group_1__3 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:268:1: ( ';' ) rule__Tracelist__Group_1__3
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:268:1: ( ';' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:269:1: ';'
            {
             before(grammarAccess.getTracelistAccess().getSemicolonKeyword_1_2()); 
            match(input,12,FOLLOW_12_in_rule__Tracelist__Group_1__2501); 
             after(grammarAccess.getTracelistAccess().getSemicolonKeyword_1_2()); 

            }

            pushFollow(FOLLOW_rule__Tracelist__Group_1__3_in_rule__Tracelist__Group_1__2511);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:283:1: rule__Tracelist__Group_1__3 : ( ( rule__Tracelist__TracesAssignment_1_3 ) ) ;
    public final void rule__Tracelist__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:287:1: ( ( ( rule__Tracelist__TracesAssignment_1_3 ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:288:1: ( ( rule__Tracelist__TracesAssignment_1_3 ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:288:1: ( ( rule__Tracelist__TracesAssignment_1_3 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:289:1: ( rule__Tracelist__TracesAssignment_1_3 )
            {
             before(grammarAccess.getTracelistAccess().getTracesAssignment_1_3()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:290:1: ( rule__Tracelist__TracesAssignment_1_3 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:290:2: rule__Tracelist__TracesAssignment_1_3
            {
            pushFollow(FOLLOW_rule__Tracelist__TracesAssignment_1_3_in_rule__Tracelist__Group_1__3539);
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


    // $ANTLR start rule__Tick__Group__0
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:308:1: rule__Tick__Group__0 : ( ( rule__Tick__InputAssignment_0 )* ) rule__Tick__Group__1 ;
    public final void rule__Tick__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:312:1: ( ( ( rule__Tick__InputAssignment_0 )* ) rule__Tick__Group__1 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:313:1: ( ( rule__Tick__InputAssignment_0 )* ) rule__Tick__Group__1
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:313:1: ( ( rule__Tick__InputAssignment_0 )* )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:314:1: ( rule__Tick__InputAssignment_0 )*
            {
             before(grammarAccess.getTickAccess().getInputAssignment_0()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:315:1: ( rule__Tick__InputAssignment_0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:315:2: rule__Tick__InputAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Tick__InputAssignment_0_in_rule__Tick__Group__0581);
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

            pushFollow(FOLLOW_rule__Tick__Group__1_in_rule__Tick__Group__0591);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:326:1: rule__Tick__Group__1 : ( ( rule__Tick__Group_1__0 )? ) rule__Tick__Group__2 ;
    public final void rule__Tick__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:330:1: ( ( ( rule__Tick__Group_1__0 )? ) rule__Tick__Group__2 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:331:1: ( ( rule__Tick__Group_1__0 )? ) rule__Tick__Group__2
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:331:1: ( ( rule__Tick__Group_1__0 )? )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:332:1: ( rule__Tick__Group_1__0 )?
            {
             before(grammarAccess.getTickAccess().getGroup_1()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:333:1: ( rule__Tick__Group_1__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:333:2: rule__Tick__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Tick__Group_1__0_in_rule__Tick__Group__1619);
                    rule__Tick__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTickAccess().getGroup_1()); 

            }

            pushFollow(FOLLOW_rule__Tick__Group__2_in_rule__Tick__Group__1629);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:344:1: rule__Tick__Group__2 : ( ';' ) ;
    public final void rule__Tick__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:348:1: ( ( ';' ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:349:1: ( ';' )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:349:1: ( ';' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:350:1: ';'
            {
             before(grammarAccess.getTickAccess().getSemicolonKeyword_2()); 
            match(input,12,FOLLOW_12_in_rule__Tick__Group__2658); 
             after(grammarAccess.getTickAccess().getSemicolonKeyword_2()); 

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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:369:1: rule__Tick__Group_1__0 : ( '%' ) rule__Tick__Group_1__1 ;
    public final void rule__Tick__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:373:1: ( ( '%' ) rule__Tick__Group_1__1 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:374:1: ( '%' ) rule__Tick__Group_1__1
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:374:1: ( '%' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:375:1: '%'
            {
             before(grammarAccess.getTickAccess().getPercentSignKeyword_1_0()); 
            match(input,13,FOLLOW_13_in_rule__Tick__Group_1__0700); 
             after(grammarAccess.getTickAccess().getPercentSignKeyword_1_0()); 

            }

            pushFollow(FOLLOW_rule__Tick__Group_1__1_in_rule__Tick__Group_1__0710);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:389:1: rule__Tick__Group_1__1 : ( 'Output' ) rule__Tick__Group_1__2 ;
    public final void rule__Tick__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:393:1: ( ( 'Output' ) rule__Tick__Group_1__2 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:394:1: ( 'Output' ) rule__Tick__Group_1__2
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:394:1: ( 'Output' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:395:1: 'Output'
            {
             before(grammarAccess.getTickAccess().getOutputKeyword_1_1()); 
            match(input,14,FOLLOW_14_in_rule__Tick__Group_1__1739); 
             after(grammarAccess.getTickAccess().getOutputKeyword_1_1()); 

            }

            pushFollow(FOLLOW_rule__Tick__Group_1__2_in_rule__Tick__Group_1__1749);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:409:1: rule__Tick__Group_1__2 : ( ':' ) rule__Tick__Group_1__3 ;
    public final void rule__Tick__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:413:1: ( ( ':' ) rule__Tick__Group_1__3 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:414:1: ( ':' ) rule__Tick__Group_1__3
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:414:1: ( ':' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:415:1: ':'
            {
             before(grammarAccess.getTickAccess().getColonKeyword_1_2()); 
            match(input,15,FOLLOW_15_in_rule__Tick__Group_1__2778); 
             after(grammarAccess.getTickAccess().getColonKeyword_1_2()); 

            }

            pushFollow(FOLLOW_rule__Tick__Group_1__3_in_rule__Tick__Group_1__2788);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:429:1: rule__Tick__Group_1__3 : ( ( rule__Tick__OutputAssignment_1_3 )* ) ;
    public final void rule__Tick__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:433:1: ( ( ( rule__Tick__OutputAssignment_1_3 )* ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:434:1: ( ( rule__Tick__OutputAssignment_1_3 )* )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:434:1: ( ( rule__Tick__OutputAssignment_1_3 )* )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:435:1: ( rule__Tick__OutputAssignment_1_3 )*
            {
             before(grammarAccess.getTickAccess().getOutputAssignment_1_3()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:436:1: ( rule__Tick__OutputAssignment_1_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:436:2: rule__Tick__OutputAssignment_1_3
            	    {
            	    pushFollow(FOLLOW_rule__Tick__OutputAssignment_1_3_in_rule__Tick__Group_1__3816);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:454:1: rule__Signal__Group__0 : ( ( rule__Signal__NameAssignment_0 ) ) rule__Signal__Group__1 ;
    public final void rule__Signal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:458:1: ( ( ( rule__Signal__NameAssignment_0 ) ) rule__Signal__Group__1 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:459:1: ( ( rule__Signal__NameAssignment_0 ) ) rule__Signal__Group__1
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:459:1: ( ( rule__Signal__NameAssignment_0 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:460:1: ( rule__Signal__NameAssignment_0 )
            {
             before(grammarAccess.getSignalAccess().getNameAssignment_0()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:461:1: ( rule__Signal__NameAssignment_0 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:461:2: rule__Signal__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Signal__NameAssignment_0_in_rule__Signal__Group__0859);
            rule__Signal__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getNameAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group__1_in_rule__Signal__Group__0868);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:472:1: rule__Signal__Group__1 : ( ( rule__Signal__Group_1__0 )? ) ;
    public final void rule__Signal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:476:1: ( ( ( rule__Signal__Group_1__0 )? ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:477:1: ( ( rule__Signal__Group_1__0 )? )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:477:1: ( ( rule__Signal__Group_1__0 )? )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:478:1: ( rule__Signal__Group_1__0 )?
            {
             before(grammarAccess.getSignalAccess().getGroup_1()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:479:1: ( rule__Signal__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:479:2: rule__Signal__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Signal__Group_1__0_in_rule__Signal__Group__1896);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:493:1: rule__Signal__Group_1__0 : ( ( rule__Signal__ValuedAssignment_1_0 ) ) rule__Signal__Group_1__1 ;
    public final void rule__Signal__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:497:1: ( ( ( rule__Signal__ValuedAssignment_1_0 ) ) rule__Signal__Group_1__1 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:498:1: ( ( rule__Signal__ValuedAssignment_1_0 ) ) rule__Signal__Group_1__1
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:498:1: ( ( rule__Signal__ValuedAssignment_1_0 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:499:1: ( rule__Signal__ValuedAssignment_1_0 )
            {
             before(grammarAccess.getSignalAccess().getValuedAssignment_1_0()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:500:1: ( rule__Signal__ValuedAssignment_1_0 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:500:2: rule__Signal__ValuedAssignment_1_0
            {
            pushFollow(FOLLOW_rule__Signal__ValuedAssignment_1_0_in_rule__Signal__Group_1__0935);
            rule__Signal__ValuedAssignment_1_0();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getValuedAssignment_1_0()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_1__1_in_rule__Signal__Group_1__0944);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:511:1: rule__Signal__Group_1__1 : ( ( rule__Signal__ValAssignment_1_1 ) ) rule__Signal__Group_1__2 ;
    public final void rule__Signal__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:515:1: ( ( ( rule__Signal__ValAssignment_1_1 ) ) rule__Signal__Group_1__2 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:516:1: ( ( rule__Signal__ValAssignment_1_1 ) ) rule__Signal__Group_1__2
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:516:1: ( ( rule__Signal__ValAssignment_1_1 ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:517:1: ( rule__Signal__ValAssignment_1_1 )
            {
             before(grammarAccess.getSignalAccess().getValAssignment_1_1()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:518:1: ( rule__Signal__ValAssignment_1_1 )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:518:2: rule__Signal__ValAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Signal__ValAssignment_1_1_in_rule__Signal__Group_1__1972);
            rule__Signal__ValAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getSignalAccess().getValAssignment_1_1()); 

            }

            pushFollow(FOLLOW_rule__Signal__Group_1__2_in_rule__Signal__Group_1__1981);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:529:1: rule__Signal__Group_1__2 : ( ')' ) ;
    public final void rule__Signal__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:533:1: ( ( ')' ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:534:1: ( ')' )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:534:1: ( ')' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:535:1: ')'
            {
             before(grammarAccess.getSignalAccess().getRightParenthesisKeyword_1_2()); 
            match(input,16,FOLLOW_16_in_rule__Signal__Group_1__21010); 
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:554:1: rule__Tracelist__TracesAssignment_0 : ( ruletrace ) ;
    public final void rule__Tracelist__TracesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:558:1: ( ( ruletrace ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:559:1: ( ruletrace )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:559:1: ( ruletrace )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:560:1: ruletrace
            {
             before(grammarAccess.getTracelistAccess().getTracesTraceParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruletrace_in_rule__Tracelist__TracesAssignment_01051);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:569:1: rule__Tracelist__TracesAssignment_1_3 : ( ruletrace ) ;
    public final void rule__Tracelist__TracesAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:573:1: ( ( ruletrace ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:574:1: ( ruletrace )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:574:1: ( ruletrace )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:575:1: ruletrace
            {
             before(grammarAccess.getTracelistAccess().getTracesTraceParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_ruletrace_in_rule__Tracelist__TracesAssignment_1_31082);
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


    // $ANTLR start rule__Trace__TicksAssignment
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:584:1: rule__Trace__TicksAssignment : ( ruletick ) ;
    public final void rule__Trace__TicksAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:588:1: ( ( ruletick ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:589:1: ( ruletick )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:589:1: ( ruletick )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:590:1: ruletick
            {
             before(grammarAccess.getTraceAccess().getTicksTickParserRuleCall_0()); 
            pushFollow(FOLLOW_ruletick_in_rule__Trace__TicksAssignment1113);
            ruletick();
            _fsp--;

             after(grammarAccess.getTraceAccess().getTicksTickParserRuleCall_0()); 

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
    // $ANTLR end rule__Trace__TicksAssignment


    // $ANTLR start rule__Tick__InputAssignment_0
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:599:1: rule__Tick__InputAssignment_0 : ( rulesignal ) ;
    public final void rule__Tick__InputAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:603:1: ( ( rulesignal ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:604:1: ( rulesignal )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:604:1: ( rulesignal )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:605:1: rulesignal
            {
             before(grammarAccess.getTickAccess().getInputSignalParserRuleCall_0_0()); 
            pushFollow(FOLLOW_rulesignal_in_rule__Tick__InputAssignment_01144);
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:614:1: rule__Tick__OutputAssignment_1_3 : ( rulesignal ) ;
    public final void rule__Tick__OutputAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:618:1: ( ( rulesignal ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:619:1: ( rulesignal )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:619:1: ( rulesignal )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:620:1: rulesignal
            {
             before(grammarAccess.getTickAccess().getOutputSignalParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_rulesignal_in_rule__Tick__OutputAssignment_1_31175);
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


    // $ANTLR start rule__Signal__NameAssignment_0
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:629:1: rule__Signal__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Signal__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:633:1: ( ( RULE_ID ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:634:1: ( RULE_ID )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:634:1: ( RULE_ID )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:635:1: RULE_ID
            {
             before(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_01206); 
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:644:1: rule__Signal__ValuedAssignment_1_0 : ( ( '(' ) ) ;
    public final void rule__Signal__ValuedAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:648:1: ( ( ( '(' ) ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:649:1: ( ( '(' ) )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:649:1: ( ( '(' ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:650:1: ( '(' )
            {
             before(grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0_0()); 
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:651:1: ( '(' )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:652:1: '('
            {
             before(grammarAccess.getSignalAccess().getValuedLeftParenthesisKeyword_1_0_0()); 
            match(input,17,FOLLOW_17_in_rule__Signal__ValuedAssignment_1_01242); 
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
    // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:667:1: rule__Signal__ValAssignment_1_1 : ( RULE_NUM ) ;
    public final void rule__Signal__ValAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:671:1: ( ( RULE_NUM ) )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:672:1: ( RULE_NUM )
            {
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:672:1: ( RULE_NUM )
            // ../de.cau.cs.kieler.sim.esi.ui/src-gen/de/cau/cs/kieler/contentassist/antlr/internal/InternalEsi.g:673:1: RULE_NUM
            {
             before(grammarAccess.getSignalAccess().getValNUMTerminalRuleCall_1_1_0()); 
            match(input,RULE_NUM,FOLLOW_RULE_NUM_in_rule__Signal__ValAssignment_1_11281); 
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


 

    public static final BitSet FOLLOW_ruletracelist_in_entryRuletracelist60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletracelist67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tracelist__Group__0_in_ruletracelist94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletrace_in_entryRuletrace120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletrace127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Trace__TicksAssignment_in_ruletrace156 = new BitSet(new long[]{0x0000000000003012L});
    public static final BitSet FOLLOW_rule__Trace__TicksAssignment_in_ruletrace168 = new BitSet(new long[]{0x0000000000003012L});
    public static final BitSet FOLLOW_ruletick_in_entryRuletick197 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletick204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tick__Group__0_in_ruletick231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesignal_in_entryRulesignal257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulesignal264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group__0_in_rulesignal291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tracelist__TracesAssignment_0_in_rule__Tracelist__Group__0329 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__Tracelist__Group__1_in_rule__Tracelist__Group__0339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tracelist__Group_1__0_in_rule__Tracelist__Group__1369 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_rule__Tracelist__Group_1__0_in_rule__Tracelist__Group__1381 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_rule__Tracelist__Group_1__0423 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__Tracelist__Group_1__1_in_rule__Tracelist__Group_1__0433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Tracelist__Group_1__1462 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Tracelist__Group_1__2_in_rule__Tracelist__Group_1__1472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Tracelist__Group_1__2501 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__Tracelist__Group_1__3_in_rule__Tracelist__Group_1__2511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tracelist__TracesAssignment_1_3_in_rule__Tracelist__Group_1__3539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tick__InputAssignment_0_in_rule__Tick__Group__0581 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__Tick__Group__1_in_rule__Tick__Group__0591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tick__Group_1__0_in_rule__Tick__Group__1619 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Tick__Group__2_in_rule__Tick__Group__1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Tick__Group__2658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Tick__Group_1__0700 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Tick__Group_1__1_in_rule__Tick__Group_1__0710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Tick__Group_1__1739 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Tick__Group_1__2_in_rule__Tick__Group_1__1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Tick__Group_1__2778 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Tick__Group_1__3_in_rule__Tick__Group_1__2788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tick__OutputAssignment_1_3_in_rule__Tick__Group_1__3816 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Signal__NameAssignment_0_in_rule__Signal__Group__0859 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__Signal__Group__1_in_rule__Signal__Group__0868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__Group_1__0_in_rule__Signal__Group__1896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__ValuedAssignment_1_0_in_rule__Signal__Group_1__0935 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Signal__Group_1__1_in_rule__Signal__Group_1__0944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signal__ValAssignment_1_1_in_rule__Signal__Group_1__1972 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Signal__Group_1__2_in_rule__Signal__Group_1__1981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Signal__Group_1__21010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletrace_in_rule__Tracelist__TracesAssignment_01051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletrace_in_rule__Tracelist__TracesAssignment_1_31082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletick_in_rule__Trace__TicksAssignment1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesignal_in_rule__Tick__InputAssignment_01144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesignal_in_rule__Tick__OutputAssignment_1_31175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Signal__NameAssignment_01206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Signal__ValuedAssignment_1_01242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUM_in_rule__Signal__ValAssignment_1_11281 = new BitSet(new long[]{0x0000000000000002L});

}