package org.xtext.example.contentassist.antlr.internal; 

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
import org.xtext.example.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalMyDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'entity'", "'{'", "'}'", "'extends'", "'property'", "':'", "'[]'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalMyDslParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g"; }


     
     	private MyDslGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(MyDslGrammarAccess grammarAccess) {
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
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:60:16: ( ruleModel EOF )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:61:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel60);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel67); 

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
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:68:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:72:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:73:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:73:1: ( ( rule__Model__Group__0 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:74:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:75:1: ( rule__Model__Group__0 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:75:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel94);
            rule__Model__Group__0();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

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


    // $ANTLR start entryRuleImport
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:87:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:87:17: ( ruleImport EOF )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:88:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport120);
            ruleImport();
            _fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport127); 

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
    // $ANTLR end entryRuleImport


    // $ANTLR start ruleImport
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:95:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:99:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:100:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:100:1: ( ( rule__Import__Group__0 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:101:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:102:1: ( rule__Import__Group__0 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:102:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport154);
            rule__Import__Group__0();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

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
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleType
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:114:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:114:15: ( ruleType EOF )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:115:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType180);
            ruleType();
            _fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType187); 

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
    // $ANTLR end entryRuleType


    // $ANTLR start ruleType
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:122:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:126:2: ( ( ( rule__Type__Alternatives ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:127:1: ( ( rule__Type__Alternatives ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:127:1: ( ( rule__Type__Alternatives ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:128:1: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:129:1: ( rule__Type__Alternatives )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:129:2: rule__Type__Alternatives
            {
            pushFollow(FOLLOW_rule__Type__Alternatives_in_ruleType214);
            rule__Type__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getTypeAccess().getAlternatives()); 

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
    // $ANTLR end ruleType


    // $ANTLR start entryRuleSimpleType
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:141:1: entryRuleSimpleType : ruleSimpleType EOF ;
    public final void entryRuleSimpleType() throws RecognitionException {
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:141:21: ( ruleSimpleType EOF )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:142:1: ruleSimpleType EOF
            {
             before(grammarAccess.getSimpleTypeRule()); 
            pushFollow(FOLLOW_ruleSimpleType_in_entryRuleSimpleType240);
            ruleSimpleType();
            _fsp--;

             after(grammarAccess.getSimpleTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleType247); 

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
    // $ANTLR end entryRuleSimpleType


    // $ANTLR start ruleSimpleType
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:149:1: ruleSimpleType : ( ( rule__SimpleType__Group__0 ) ) ;
    public final void ruleSimpleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:153:2: ( ( ( rule__SimpleType__Group__0 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:154:1: ( ( rule__SimpleType__Group__0 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:154:1: ( ( rule__SimpleType__Group__0 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:155:1: ( rule__SimpleType__Group__0 )
            {
             before(grammarAccess.getSimpleTypeAccess().getGroup()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:156:1: ( rule__SimpleType__Group__0 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:156:2: rule__SimpleType__Group__0
            {
            pushFollow(FOLLOW_rule__SimpleType__Group__0_in_ruleSimpleType274);
            rule__SimpleType__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSimpleTypeAccess().getGroup()); 

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
    // $ANTLR end ruleSimpleType


    // $ANTLR start entryRuleEntity
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:168:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:168:17: ( ruleEntity EOF )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:169:1: ruleEntity EOF
            {
             before(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity300);
            ruleEntity();
            _fsp--;

             after(grammarAccess.getEntityRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity307); 

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
    // $ANTLR end entryRuleEntity


    // $ANTLR start ruleEntity
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:176:1: ruleEntity : ( ( rule__Entity__Group__0 ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:180:2: ( ( ( rule__Entity__Group__0 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:181:1: ( ( rule__Entity__Group__0 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:181:1: ( ( rule__Entity__Group__0 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:182:1: ( rule__Entity__Group__0 )
            {
             before(grammarAccess.getEntityAccess().getGroup()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:183:1: ( rule__Entity__Group__0 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:183:2: rule__Entity__Group__0
            {
            pushFollow(FOLLOW_rule__Entity__Group__0_in_ruleEntity334);
            rule__Entity__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEntityAccess().getGroup()); 

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
    // $ANTLR end ruleEntity


    // $ANTLR start entryRuleProperty
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:195:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:195:19: ( ruleProperty EOF )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:196:1: ruleProperty EOF
            {
             before(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty360);
            ruleProperty();
            _fsp--;

             after(grammarAccess.getPropertyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty367); 

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
    // $ANTLR end entryRuleProperty


    // $ANTLR start ruleProperty
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:203:1: ruleProperty : ( ( rule__Property__Group__0 ) ) ;
    public final void ruleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:207:2: ( ( ( rule__Property__Group__0 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:208:1: ( ( rule__Property__Group__0 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:208:1: ( ( rule__Property__Group__0 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:209:1: ( rule__Property__Group__0 )
            {
             before(grammarAccess.getPropertyAccess().getGroup()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:210:1: ( rule__Property__Group__0 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:210:2: rule__Property__Group__0
            {
            pushFollow(FOLLOW_rule__Property__Group__0_in_ruleProperty394);
            rule__Property__Group__0();
            _fsp--;


            }

             after(grammarAccess.getPropertyAccess().getGroup()); 

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
    // $ANTLR end ruleProperty


    // $ANTLR start rule__Type__Alternatives
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:222:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleEntity ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:226:1: ( ( ruleSimpleType ) | ( ruleEntity ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            else if ( (LA1_0==13) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("222:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleEntity ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:227:1: ( ruleSimpleType )
                    {
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:227:1: ( ruleSimpleType )
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:228:1: ruleSimpleType
                    {
                     before(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleType_in_rule__Type__Alternatives430);
                    ruleSimpleType();
                    _fsp--;

                     after(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:233:6: ( ruleEntity )
                    {
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:233:6: ( ruleEntity )
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:234:1: ruleEntity
                    {
                     before(grammarAccess.getTypeAccess().getEntityParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEntity_in_rule__Type__Alternatives447);
                    ruleEntity();
                    _fsp--;

                     after(grammarAccess.getTypeAccess().getEntityParserRuleCall_1()); 

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
    // $ANTLR end rule__Type__Alternatives


    // $ANTLR start rule__Model__Group__0
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:246:1: rule__Model__Group__0 : ( ( rule__Model__ImportsAssignment_0 )* ) rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:250:1: ( ( ( rule__Model__ImportsAssignment_0 )* ) rule__Model__Group__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:251:1: ( ( rule__Model__ImportsAssignment_0 )* ) rule__Model__Group__1
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:251:1: ( ( rule__Model__ImportsAssignment_0 )* )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:252:1: ( rule__Model__ImportsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_0()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:253:1: ( rule__Model__ImportsAssignment_0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:253:2: rule__Model__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__0481);
            	    rule__Model__ImportsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getImportsAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0491);
            rule__Model__Group__1();
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
    // $ANTLR end rule__Model__Group__0


    // $ANTLR start rule__Model__Group__1
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:264:1: rule__Model__Group__1 : ( ( rule__Model__ElementsAssignment_1 )* ) ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:268:1: ( ( ( rule__Model__ElementsAssignment_1 )* ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:269:1: ( ( rule__Model__ElementsAssignment_1 )* )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:269:1: ( ( rule__Model__ElementsAssignment_1 )* )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:270:1: ( rule__Model__ElementsAssignment_1 )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:271:1: ( rule__Model__ElementsAssignment_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=12 && LA3_0<=13)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:271:2: rule__Model__ElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Model__ElementsAssignment_1_in_rule__Model__Group__1519);
            	    rule__Model__ElementsAssignment_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getElementsAssignment_1()); 

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
    // $ANTLR end rule__Model__Group__1


    // $ANTLR start rule__Import__Group__0
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:285:1: rule__Import__Group__0 : ( 'import' ) rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:289:1: ( ( 'import' ) rule__Import__Group__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:290:1: ( 'import' ) rule__Import__Group__1
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:290:1: ( 'import' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:291:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Import__Group__0559); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0569);
            rule__Import__Group__1();
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
    // $ANTLR end rule__Import__Group__0


    // $ANTLR start rule__Import__Group__1
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:305:1: rule__Import__Group__1 : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:309:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:310:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:310:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:311:1: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:312:1: ( rule__Import__ImportURIAssignment_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:312:2: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1597);
            rule__Import__ImportURIAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1()); 

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
    // $ANTLR end rule__Import__Group__1


    // $ANTLR start rule__SimpleType__Group__0
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:326:1: rule__SimpleType__Group__0 : ( 'type' ) rule__SimpleType__Group__1 ;
    public final void rule__SimpleType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:330:1: ( ( 'type' ) rule__SimpleType__Group__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:331:1: ( 'type' ) rule__SimpleType__Group__1
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:331:1: ( 'type' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:332:1: 'type'
            {
             before(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__SimpleType__Group__0636); 
             after(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__SimpleType__Group__1_in_rule__SimpleType__Group__0646);
            rule__SimpleType__Group__1();
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
    // $ANTLR end rule__SimpleType__Group__0


    // $ANTLR start rule__SimpleType__Group__1
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:346:1: rule__SimpleType__Group__1 : ( ( rule__SimpleType__NameAssignment_1 ) ) ;
    public final void rule__SimpleType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:350:1: ( ( ( rule__SimpleType__NameAssignment_1 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:351:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:351:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:352:1: ( rule__SimpleType__NameAssignment_1 )
            {
             before(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:353:1: ( rule__SimpleType__NameAssignment_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:353:2: rule__SimpleType__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SimpleType__NameAssignment_1_in_rule__SimpleType__Group__1674);
            rule__SimpleType__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 

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
    // $ANTLR end rule__SimpleType__Group__1


    // $ANTLR start rule__Entity__Group__0
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:367:1: rule__Entity__Group__0 : ( 'entity' ) rule__Entity__Group__1 ;
    public final void rule__Entity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:371:1: ( ( 'entity' ) rule__Entity__Group__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:372:1: ( 'entity' ) rule__Entity__Group__1
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:372:1: ( 'entity' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:373:1: 'entity'
            {
             before(grammarAccess.getEntityAccess().getEntityKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__Entity__Group__0713); 
             after(grammarAccess.getEntityAccess().getEntityKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__0723);
            rule__Entity__Group__1();
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
    // $ANTLR end rule__Entity__Group__0


    // $ANTLR start rule__Entity__Group__1
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:387:1: rule__Entity__Group__1 : ( ( rule__Entity__NameAssignment_1 ) ) rule__Entity__Group__2 ;
    public final void rule__Entity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:391:1: ( ( ( rule__Entity__NameAssignment_1 ) ) rule__Entity__Group__2 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:392:1: ( ( rule__Entity__NameAssignment_1 ) ) rule__Entity__Group__2
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:392:1: ( ( rule__Entity__NameAssignment_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:393:1: ( rule__Entity__NameAssignment_1 )
            {
             before(grammarAccess.getEntityAccess().getNameAssignment_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:394:1: ( rule__Entity__NameAssignment_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:394:2: rule__Entity__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__1751);
            rule__Entity__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEntityAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__1760);
            rule__Entity__Group__2();
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
    // $ANTLR end rule__Entity__Group__1


    // $ANTLR start rule__Entity__Group__2
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:405:1: rule__Entity__Group__2 : ( ( rule__Entity__Group_2__0 )? ) rule__Entity__Group__3 ;
    public final void rule__Entity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:409:1: ( ( ( rule__Entity__Group_2__0 )? ) rule__Entity__Group__3 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:410:1: ( ( rule__Entity__Group_2__0 )? ) rule__Entity__Group__3
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:410:1: ( ( rule__Entity__Group_2__0 )? )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:411:1: ( rule__Entity__Group_2__0 )?
            {
             before(grammarAccess.getEntityAccess().getGroup_2()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:412:1: ( rule__Entity__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:412:2: rule__Entity__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Entity__Group_2__0_in_rule__Entity__Group__2788);
                    rule__Entity__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getGroup_2()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__2798);
            rule__Entity__Group__3();
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
    // $ANTLR end rule__Entity__Group__2


    // $ANTLR start rule__Entity__Group__3
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:423:1: rule__Entity__Group__3 : ( '{' ) rule__Entity__Group__4 ;
    public final void rule__Entity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:427:1: ( ( '{' ) rule__Entity__Group__4 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:428:1: ( '{' ) rule__Entity__Group__4
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:428:1: ( '{' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:429:1: '{'
            {
             before(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,14,FOLLOW_14_in_rule__Entity__Group__3827); 
             after(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__3837);
            rule__Entity__Group__4();
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
    // $ANTLR end rule__Entity__Group__3


    // $ANTLR start rule__Entity__Group__4
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:443:1: rule__Entity__Group__4 : ( ( rule__Entity__PropertiesAssignment_4 )* ) rule__Entity__Group__5 ;
    public final void rule__Entity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:447:1: ( ( ( rule__Entity__PropertiesAssignment_4 )* ) rule__Entity__Group__5 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:448:1: ( ( rule__Entity__PropertiesAssignment_4 )* ) rule__Entity__Group__5
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:448:1: ( ( rule__Entity__PropertiesAssignment_4 )* )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:449:1: ( rule__Entity__PropertiesAssignment_4 )*
            {
             before(grammarAccess.getEntityAccess().getPropertiesAssignment_4()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:450:1: ( rule__Entity__PropertiesAssignment_4 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:450:2: rule__Entity__PropertiesAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Entity__PropertiesAssignment_4_in_rule__Entity__Group__4865);
            	    rule__Entity__PropertiesAssignment_4();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getEntityAccess().getPropertiesAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__5_in_rule__Entity__Group__4875);
            rule__Entity__Group__5();
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
    // $ANTLR end rule__Entity__Group__4


    // $ANTLR start rule__Entity__Group__5
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:461:1: rule__Entity__Group__5 : ( '}' ) ;
    public final void rule__Entity__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:465:1: ( ( '}' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:466:1: ( '}' )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:466:1: ( '}' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:467:1: '}'
            {
             before(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5()); 
            match(input,15,FOLLOW_15_in_rule__Entity__Group__5904); 
             after(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5()); 

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
    // $ANTLR end rule__Entity__Group__5


    // $ANTLR start rule__Entity__Group_2__0
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:492:1: rule__Entity__Group_2__0 : ( 'extends' ) rule__Entity__Group_2__1 ;
    public final void rule__Entity__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:496:1: ( ( 'extends' ) rule__Entity__Group_2__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:497:1: ( 'extends' ) rule__Entity__Group_2__1
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:497:1: ( 'extends' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:498:1: 'extends'
            {
             before(grammarAccess.getEntityAccess().getExtendsKeyword_2_0()); 
            match(input,16,FOLLOW_16_in_rule__Entity__Group_2__0952); 
             after(grammarAccess.getEntityAccess().getExtendsKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group_2__1_in_rule__Entity__Group_2__0962);
            rule__Entity__Group_2__1();
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
    // $ANTLR end rule__Entity__Group_2__0


    // $ANTLR start rule__Entity__Group_2__1
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:512:1: rule__Entity__Group_2__1 : ( ( rule__Entity__ExtendsAssignment_2_1 ) ) ;
    public final void rule__Entity__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:516:1: ( ( ( rule__Entity__ExtendsAssignment_2_1 ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:517:1: ( ( rule__Entity__ExtendsAssignment_2_1 ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:517:1: ( ( rule__Entity__ExtendsAssignment_2_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:518:1: ( rule__Entity__ExtendsAssignment_2_1 )
            {
             before(grammarAccess.getEntityAccess().getExtendsAssignment_2_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:519:1: ( rule__Entity__ExtendsAssignment_2_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:519:2: rule__Entity__ExtendsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Entity__ExtendsAssignment_2_1_in_rule__Entity__Group_2__1990);
            rule__Entity__ExtendsAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getEntityAccess().getExtendsAssignment_2_1()); 

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
    // $ANTLR end rule__Entity__Group_2__1


    // $ANTLR start rule__Property__Group__0
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:533:1: rule__Property__Group__0 : ( 'property' ) rule__Property__Group__1 ;
    public final void rule__Property__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:537:1: ( ( 'property' ) rule__Property__Group__1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:538:1: ( 'property' ) rule__Property__Group__1
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:538:1: ( 'property' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:539:1: 'property'
            {
             before(grammarAccess.getPropertyAccess().getPropertyKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__Property__Group__01029); 
             after(grammarAccess.getPropertyAccess().getPropertyKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Property__Group__1_in_rule__Property__Group__01039);
            rule__Property__Group__1();
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
    // $ANTLR end rule__Property__Group__0


    // $ANTLR start rule__Property__Group__1
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:553:1: rule__Property__Group__1 : ( ( rule__Property__NameAssignment_1 ) ) rule__Property__Group__2 ;
    public final void rule__Property__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:557:1: ( ( ( rule__Property__NameAssignment_1 ) ) rule__Property__Group__2 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:558:1: ( ( rule__Property__NameAssignment_1 ) ) rule__Property__Group__2
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:558:1: ( ( rule__Property__NameAssignment_1 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:559:1: ( rule__Property__NameAssignment_1 )
            {
             before(grammarAccess.getPropertyAccess().getNameAssignment_1()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:560:1: ( rule__Property__NameAssignment_1 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:560:2: rule__Property__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Property__NameAssignment_1_in_rule__Property__Group__11067);
            rule__Property__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getPropertyAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Property__Group__2_in_rule__Property__Group__11076);
            rule__Property__Group__2();
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
    // $ANTLR end rule__Property__Group__1


    // $ANTLR start rule__Property__Group__2
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:571:1: rule__Property__Group__2 : ( ':' ) rule__Property__Group__3 ;
    public final void rule__Property__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:575:1: ( ( ':' ) rule__Property__Group__3 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:576:1: ( ':' ) rule__Property__Group__3
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:576:1: ( ':' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:577:1: ':'
            {
             before(grammarAccess.getPropertyAccess().getColonKeyword_2()); 
            match(input,18,FOLLOW_18_in_rule__Property__Group__21105); 
             after(grammarAccess.getPropertyAccess().getColonKeyword_2()); 

            }

            pushFollow(FOLLOW_rule__Property__Group__3_in_rule__Property__Group__21115);
            rule__Property__Group__3();
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
    // $ANTLR end rule__Property__Group__2


    // $ANTLR start rule__Property__Group__3
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:591:1: rule__Property__Group__3 : ( ( rule__Property__TypeAssignment_3 ) ) rule__Property__Group__4 ;
    public final void rule__Property__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:595:1: ( ( ( rule__Property__TypeAssignment_3 ) ) rule__Property__Group__4 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:596:1: ( ( rule__Property__TypeAssignment_3 ) ) rule__Property__Group__4
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:596:1: ( ( rule__Property__TypeAssignment_3 ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:597:1: ( rule__Property__TypeAssignment_3 )
            {
             before(grammarAccess.getPropertyAccess().getTypeAssignment_3()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:598:1: ( rule__Property__TypeAssignment_3 )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:598:2: rule__Property__TypeAssignment_3
            {
            pushFollow(FOLLOW_rule__Property__TypeAssignment_3_in_rule__Property__Group__31143);
            rule__Property__TypeAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getPropertyAccess().getTypeAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__Property__Group__4_in_rule__Property__Group__31152);
            rule__Property__Group__4();
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
    // $ANTLR end rule__Property__Group__3


    // $ANTLR start rule__Property__Group__4
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:609:1: rule__Property__Group__4 : ( ( rule__Property__ManyAssignment_4 )? ) ;
    public final void rule__Property__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:613:1: ( ( ( rule__Property__ManyAssignment_4 )? ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:614:1: ( ( rule__Property__ManyAssignment_4 )? )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:614:1: ( ( rule__Property__ManyAssignment_4 )? )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:615:1: ( rule__Property__ManyAssignment_4 )?
            {
             before(grammarAccess.getPropertyAccess().getManyAssignment_4()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:616:1: ( rule__Property__ManyAssignment_4 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:616:2: rule__Property__ManyAssignment_4
                    {
                    pushFollow(FOLLOW_rule__Property__ManyAssignment_4_in_rule__Property__Group__41180);
                    rule__Property__ManyAssignment_4();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPropertyAccess().getManyAssignment_4()); 

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
    // $ANTLR end rule__Property__Group__4


    // $ANTLR start rule__Model__ImportsAssignment_0
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:636:1: rule__Model__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:640:1: ( ( ruleImport ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:641:1: ( ruleImport )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:641:1: ( ruleImport )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:642:1: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_01225);
            ruleImport();
            _fsp--;

             after(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 

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
    // $ANTLR end rule__Model__ImportsAssignment_0


    // $ANTLR start rule__Model__ElementsAssignment_1
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:651:1: rule__Model__ElementsAssignment_1 : ( ruleType ) ;
    public final void rule__Model__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:655:1: ( ( ruleType ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:656:1: ( ruleType )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:656:1: ( ruleType )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:657:1: ruleType
            {
             before(grammarAccess.getModelAccess().getElementsTypeParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleType_in_rule__Model__ElementsAssignment_11256);
            ruleType();
            _fsp--;

             after(grammarAccess.getModelAccess().getElementsTypeParserRuleCall_1_0()); 

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
    // $ANTLR end rule__Model__ElementsAssignment_1


    // $ANTLR start rule__Import__ImportURIAssignment_1
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:666:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:670:1: ( ( RULE_STRING ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:671:1: ( RULE_STRING )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:671:1: ( RULE_STRING )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:672:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_11287); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end rule__Import__ImportURIAssignment_1


    // $ANTLR start rule__SimpleType__NameAssignment_1
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:681:1: rule__SimpleType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:685:1: ( ( RULE_ID ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:686:1: ( RULE_ID )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:686:1: ( RULE_ID )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:687:1: RULE_ID
            {
             before(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleType__NameAssignment_11318); 
             after(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end rule__SimpleType__NameAssignment_1


    // $ANTLR start rule__Entity__NameAssignment_1
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:696:1: rule__Entity__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Entity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:700:1: ( ( RULE_ID ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:701:1: ( RULE_ID )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:701:1: ( RULE_ID )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:702:1: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_11349); 
             after(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end rule__Entity__NameAssignment_1


    // $ANTLR start rule__Entity__ExtendsAssignment_2_1
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:711:1: rule__Entity__ExtendsAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Entity__ExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:715:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:716:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:716:1: ( ( RULE_ID ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:717:1: ( RULE_ID )
            {
             before(grammarAccess.getEntityAccess().getExtendsEntityCrossReference_2_1_0()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:718:1: ( RULE_ID )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:719:1: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getExtendsEntityIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Entity__ExtendsAssignment_2_11384); 
             after(grammarAccess.getEntityAccess().getExtendsEntityIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getEntityAccess().getExtendsEntityCrossReference_2_1_0()); 

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
    // $ANTLR end rule__Entity__ExtendsAssignment_2_1


    // $ANTLR start rule__Entity__PropertiesAssignment_4
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:730:1: rule__Entity__PropertiesAssignment_4 : ( ruleProperty ) ;
    public final void rule__Entity__PropertiesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:734:1: ( ( ruleProperty ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:735:1: ( ruleProperty )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:735:1: ( ruleProperty )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:736:1: ruleProperty
            {
             before(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleProperty_in_rule__Entity__PropertiesAssignment_41419);
            ruleProperty();
            _fsp--;

             after(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_4_0()); 

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
    // $ANTLR end rule__Entity__PropertiesAssignment_4


    // $ANTLR start rule__Property__NameAssignment_1
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:745:1: rule__Property__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Property__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:749:1: ( ( RULE_ID ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:750:1: ( RULE_ID )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:750:1: ( RULE_ID )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:751:1: RULE_ID
            {
             before(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Property__NameAssignment_11450); 
             after(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end rule__Property__NameAssignment_1


    // $ANTLR start rule__Property__TypeAssignment_3
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:760:1: rule__Property__TypeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Property__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:764:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:765:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:765:1: ( ( RULE_ID ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:766:1: ( RULE_ID )
            {
             before(grammarAccess.getPropertyAccess().getTypeTypeCrossReference_3_0()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:767:1: ( RULE_ID )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:768:1: RULE_ID
            {
             before(grammarAccess.getPropertyAccess().getTypeTypeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Property__TypeAssignment_31485); 
             after(grammarAccess.getPropertyAccess().getTypeTypeIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getPropertyAccess().getTypeTypeCrossReference_3_0()); 

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
    // $ANTLR end rule__Property__TypeAssignment_3


    // $ANTLR start rule__Property__ManyAssignment_4
    // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:779:1: rule__Property__ManyAssignment_4 : ( ( '[]' ) ) ;
    public final void rule__Property__ManyAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:783:1: ( ( ( '[]' ) ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:784:1: ( ( '[]' ) )
            {
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:784:1: ( ( '[]' ) )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:785:1: ( '[]' )
            {
             before(grammarAccess.getPropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:786:1: ( '[]' )
            // ../org.xtext.example.mydsl.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalMyDsl.g:787:1: '[]'
            {
             before(grammarAccess.getPropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            match(input,19,FOLLOW_19_in_rule__Property__ManyAssignment_41525); 
             after(grammarAccess.getPropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 

            }

             after(grammarAccess.getPropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 

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
    // $ANTLR end rule__Property__ManyAssignment_4


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Alternatives_in_ruleType214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_entryRuleSimpleType240 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleType247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleType__Group__0_in_ruleSimpleType274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group__0_in_ruleEntity334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Property__Group__0_in_ruleProperty394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_rule__Type__Alternatives430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_rule__Type__Alternatives447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__0481 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ElementsAssignment_1_in_rule__Model__Group__1519 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_11_in_rule__Import__Group__0559 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__SimpleType__Group__0636 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SimpleType__Group__1_in_rule__SimpleType__Group__0646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleType__NameAssignment_1_in_rule__SimpleType__Group__1674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Entity__Group__0713 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__0723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__1751 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group_2__0_in_rule__Entity__Group__2788 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__2798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Entity__Group__3827 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__3837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__PropertiesAssignment_4_in_rule__Entity__Group__4865 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_rule__Entity__Group__5_in_rule__Entity__Group__4875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Entity__Group__5904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Entity__Group_2__0952 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Entity__Group_2__1_in_rule__Entity__Group_2__0962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__ExtendsAssignment_2_1_in_rule__Entity__Group_2__1990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Property__Group__01029 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Property__Group__1_in_rule__Property__Group__01039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Property__NameAssignment_1_in_rule__Property__Group__11067 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Property__Group__2_in_rule__Property__Group__11076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Property__Group__21105 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Property__Group__3_in_rule__Property__Group__21115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Property__TypeAssignment_3_in_rule__Property__Group__31143 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__Property__Group__4_in_rule__Property__Group__31152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Property__ManyAssignment_4_in_rule__Property__Group__41180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_01225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__Model__ElementsAssignment_11256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_11287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleType__NameAssignment_11318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_11349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Entity__ExtendsAssignment_2_11384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_rule__Entity__PropertiesAssignment_41419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Property__NameAssignment_11450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Property__TypeAssignment_31485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Property__ManyAssignment_41525 = new BitSet(new long[]{0x0000000000000002L});

}