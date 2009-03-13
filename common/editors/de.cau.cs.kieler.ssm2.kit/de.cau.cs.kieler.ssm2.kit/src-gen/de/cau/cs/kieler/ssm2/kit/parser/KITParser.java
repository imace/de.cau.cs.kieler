// $ANTLR 3.0 ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g 2009-02-28 15:56:19

package de.cau.cs.kieler.ssm2.kit.parser;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;

import org.openarchitectureware.xtext.parser.impl.AntlrUtil;
import org.openarchitectureware.xtext.XtextFile;
import org.openarchitectureware.xtext.parser.impl.EcoreModelFactory;
import org.openarchitectureware.xtext.parser.ErrorMsg;
import org.openarchitectureware.xtext.parser.model.ParseTreeManagerNeu;
import org.openarchitectureware.xtext.parser.parsetree.Node;

import de.cau.cs.kieler.ssm2.kit.MetaModelRegistration;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class KITParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "'statechart'", "'['", "']'", "'{'", "'}'", "';'", "'model'", "'='", "'version'", "':'", "'input'", "'output'", "'boolean'", "'double'", "'float'", "'integer'", "'label'", "'type'", "'final'", "'initial'", "'pseudo'", "'||'", "'->'", "'priority'", "'weakAbortion'", "'wa'", "'strongAbortion'", "'sa'", "'normalTermination'", "'nt'", "'/'", "'('", "')'", "'I'", "'O'", "'L'", "'EQ'", "'LT'", "'LEQ'", "'AND'", "'OR'", "'ADD'", "'SUB'", "'MULT'", "'DIV'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=7;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=9;

        public KITParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[73+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g"; }



    	private Token getLastToken() {
    		return input.LT(-1);
    	}

    	protected Object convert(Object arg) {
    		if (arg instanceof org.antlr.runtime.Token) {
    			Token t = (Token) arg;
    			String s = t.getText();
    			if (t.getType() == KITLexer.RULE_ID && s.startsWith("^")) {
    				return s.substring(1);
    			} else if (t.getType()==KITLexer.RULE_STRING) {
    				return s.substring(1,s.length()-1);
    			} else if (t.getType()==KITLexer.RULE_INT) {
    				return Integer.valueOf(s);
    			}
    			return s;
    		}
    		return arg;
    	}


    	private EcoreModelFactory factory = new EcoreModelFactory(MetaModelRegistration.getEPackage());
        private ParseTreeManagerNeu ptm = new ParseTreeManagerNeu();
    	private XtextFile xtextfile = MetaModelRegistration.getXtextFile();
    	
    	{
    		
    	}

    	public ParseTreeManagerNeu getResult() {
    		return ptm;
    	}

    	private List<ErrorMsg> errors = new ArrayList<ErrorMsg>();
    	public List<ErrorMsg> getErrors() {
    		return errors;
    	}

    	@Override
    	public void reportError(RecognitionException e) {
    		String msg = super.getErrorMessage(e,tokenNames);
    		errors.add(AntlrUtil.create(msg,e,tokenNames));
    		ptm.addError(msg, e);
    		// This doesn't work. ANTLR may simply report an superfluous token. In that case,
    		// two nodes will be finished instead of one.
    		// ptm.ruleFinished(null, end());
    	}

        private boolean skipCurrentToken;
        
    	@Override
    	protected boolean recoverFromMismatchedElement(IntStream arg0, RecognitionException arg1, BitSet arg2) {
    		skipCurrentToken = true;
    		return super.recoverFromMismatchedElement(arg0, arg1, arg2);
    	}



    // $ANTLR start parse
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:101:1: parse returns [Node r] : result= ruleStatechart EOF ;
    public Node parse() throws RecognitionException {
        Node r = null;
        int parse_StartIndex = input.index();
        EObject result = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 1) ) { return r; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:102:3: (result= ruleStatechart EOF )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:102:3: result= ruleStatechart EOF
            {
            pushFollow(FOLLOW_ruleStatechart_in_parse67);
            result=ruleStatechart();
            _fsp--;
            if (failed) return r;
            if ( backtracking==0 ) {

              if (result != null)
                ptm.setModelElement(result);
              r = ptm.getCurrent();
              ptm.ruleFinished(result);
            }
            match(input,EOF,FOLLOW_EOF_in_parse78); if (failed) return r;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 1, parse_StartIndex); }
        }
        return r;
    }
    // $ANTLR end parse


    // $ANTLR start ruleStatechart
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:112:1: ruleStatechart returns [EObject result] : ( ( 'statechart' ) ( RULE_ID ) ( ( '[' ) (temp_ChartArgument= ruleChartArgument )* ( ']' ) )? ( '{' ) (temp_IoDeclaration= ruleIoDeclaration )* ( '{' ) (temp_Element= ruleElement )* ( '}' ) ( '}' ) ( ';' ) ) ;
    public EObject ruleStatechart() throws RecognitionException {
        EObject result = null;
        int ruleStatechart_StartIndex = input.index();
        EObject temp_ChartArgument = null;

        EObject temp_IoDeclaration = null;

        EObject temp_Element = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:115:4: ( ( ( 'statechart' ) ( RULE_ID ) ( ( '[' ) (temp_ChartArgument= ruleChartArgument )* ( ']' ) )? ( '{' ) (temp_IoDeclaration= ruleIoDeclaration )* ( '{' ) (temp_Element= ruleElement )* ( '}' ) ( '}' ) ( ';' ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:115:4: ( ( 'statechart' ) ( RULE_ID ) ( ( '[' ) (temp_ChartArgument= ruleChartArgument )* ( ']' ) )? ( '{' ) (temp_IoDeclaration= ruleIoDeclaration )* ( '{' ) (temp_Element= ruleElement )* ( '}' ) ( '}' ) ( ';' ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "Statechart");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:118:1: ( ( 'statechart' ) ( RULE_ID ) ( ( '[' ) (temp_ChartArgument= ruleChartArgument )* ( ']' ) )? ( '{' ) (temp_IoDeclaration= ruleIoDeclaration )* ( '{' ) (temp_Element= ruleElement )* ( '}' ) ( '}' ) ( ';' ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:118:2: ( 'statechart' ) ( RULE_ID ) ( ( '[' ) (temp_ChartArgument= ruleChartArgument )* ( ']' ) )? ( '{' ) (temp_IoDeclaration= ruleIoDeclaration )* ( '{' ) (temp_Element= ruleElement )* ( '}' ) ( '}' ) ( ';' )
            {
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:118:2: ( 'statechart' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:118:3: 'statechart'
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,10,FOLLOW_10_in_ruleStatechart104); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(0)));
                ptm.ruleFinished(getLastToken());
              }
            }

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:124:1: ( RULE_ID )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:124:2: RULE_ID
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStatechart112); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                Token temp = getLastToken();
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(1)));
                factory.set(result,"name",convert(temp),false);
                ptm.ruleFinished(temp);
              }
            }

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:134:1: ( ( '[' ) (temp_ChartArgument= ruleChartArgument )* ( ']' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:134:2: ( '[' ) (temp_ChartArgument= ruleChartArgument )* ( ']' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:134:2: ( '[' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:134:3: '['
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,11,FOLLOW_11_in_ruleStatechart121); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(2)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:140:1: (temp_ChartArgument= ruleChartArgument )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==16||LA1_0==18) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:140:2: temp_ChartArgument= ruleChartArgument
                    	    {
                    	    if ( backtracking==0 ) {
                    	      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(2)).eContents().get(1)));
                    	    }
                    	    pushFollow(FOLLOW_ruleChartArgument_in_ruleStatechart131);
                    	    temp_ChartArgument=ruleChartArgument();
                    	    _fsp--;
                    	    if (failed) return result;
                    	    if ( backtracking==0 ) {
                    	      if (temp_ChartArgument != null) {
                    	        hasContent = true;
                    	        ptm.setModelElement(temp_ChartArgument);
                    	        factory.add(result,"arguments",convert(temp_ChartArgument),false);
                    	        ptm.ruleFinished(temp_ChartArgument);
                    	      } else {
                    	        ptm.destroyNode();
                    	      }

                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:152:1: ( ']' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:152:2: ']'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,12,FOLLOW_12_in_ruleStatechart140); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(2)).eContents().get(2)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:159:1: ( '{' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:159:2: '{'
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,13,FOLLOW_13_in_ruleStatechart150); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(3)));
                ptm.ruleFinished(getLastToken());
              }
            }

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:165:1: (temp_IoDeclaration= ruleIoDeclaration )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=20 && LA3_0<=21)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:165:2: temp_IoDeclaration= ruleIoDeclaration
            	    {
            	    if ( backtracking==0 ) {
            	      ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(4)));
            	    }
            	    pushFollow(FOLLOW_ruleIoDeclaration_in_ruleStatechart160);
            	    temp_IoDeclaration=ruleIoDeclaration();
            	    _fsp--;
            	    if (failed) return result;
            	    if ( backtracking==0 ) {
            	      if (temp_IoDeclaration != null) {
            	        hasContent = true;
            	        ptm.setModelElement(temp_IoDeclaration);
            	        factory.add(result,"iodeclarations",convert(temp_IoDeclaration),false);
            	        ptm.ruleFinished(temp_IoDeclaration);
            	      } else {
            	        ptm.destroyNode();
            	      }

            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:177:1: ( '{' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:177:2: '{'
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,13,FOLLOW_13_in_ruleStatechart169); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(5)));
                ptm.ruleFinished(getLastToken());
              }
            }

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:183:1: (temp_Element= ruleElement )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID||(LA4_0>=31 && LA4_0<=32)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:183:2: temp_Element= ruleElement
            	    {
            	    if ( backtracking==0 ) {
            	      ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(6)));
            	    }
            	    pushFollow(FOLLOW_ruleElement_in_ruleStatechart179);
            	    temp_Element=ruleElement();
            	    _fsp--;
            	    if (failed) return result;
            	    if ( backtracking==0 ) {
            	      if (temp_Element != null) {
            	        hasContent = true;
            	        ptm.setModelElement(temp_Element);
            	        factory.add(result,"elements",convert(temp_Element),false);
            	        ptm.ruleFinished(temp_Element);
            	      } else {
            	        ptm.destroyNode();
            	      }

            	    }

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:195:1: ( '}' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:195:2: '}'
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,14,FOLLOW_14_in_ruleStatechart188); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(7)));
                ptm.ruleFinished(getLastToken());
              }
            }

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:201:1: ( '}' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:201:2: '}'
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,14,FOLLOW_14_in_ruleStatechart195); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(8)));
                ptm.ruleFinished(getLastToken());
              }
            }

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:207:1: ( ';' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:207:2: ';'
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,15,FOLLOW_15_in_ruleStatechart202); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(0)).eContents().get(1)).eContents().get(9)));
                ptm.ruleFinished(getLastToken());
              }
            }

            }


            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 2, ruleStatechart_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleStatechart


    // $ANTLR start ruleChartArgument
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:220:1: ruleChartArgument returns [EObject result] : ( ( ( 'model' ) ( '=' ) ( RULE_ID ) ( ';' ) ) | ( ( 'version' ) ( '=' ) ( RULE_ID ) ( ';' ) ) ) ;
    public EObject ruleChartArgument() throws RecognitionException {
        EObject result = null;
        int ruleChartArgument_StartIndex = input.index();
        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:223:4: ( ( ( ( 'model' ) ( '=' ) ( RULE_ID ) ( ';' ) ) | ( ( 'version' ) ( '=' ) ( RULE_ID ) ( ';' ) ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:223:4: ( ( ( 'model' ) ( '=' ) ( RULE_ID ) ( ';' ) ) | ( ( 'version' ) ( '=' ) ( RULE_ID ) ( ';' ) ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "ChartArgument");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:226:1: ( ( ( 'model' ) ( '=' ) ( RULE_ID ) ( ';' ) ) | ( ( 'version' ) ( '=' ) ( RULE_ID ) ( ';' ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            else if ( (LA5_0==18) ) {
                alt5=2;
            }
            else {
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("226:1: ( ( ( 'model' ) ( '=' ) ( RULE_ID ) ( ';' ) ) | ( ( 'version' ) ( '=' ) ( RULE_ID ) ( ';' ) ) )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:226:2: ( ( 'model' ) ( '=' ) ( RULE_ID ) ( ';' ) )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:226:2: ( ( 'model' ) ( '=' ) ( RULE_ID ) ( ';' ) )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:226:3: ( 'model' ) ( '=' ) ( RULE_ID ) ( ';' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:226:3: ( 'model' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:226:4: 'model'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,16,FOLLOW_16_in_ruleChartArgument241); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(0)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:232:1: ( '=' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:232:2: '='
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,17,FOLLOW_17_in_ruleChartArgument248); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(0)).eContents().get(1)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:238:1: ( RULE_ID )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:238:2: RULE_ID
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChartArgument256); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        Token temp = getLastToken();
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(0)).eContents().get(2)));
                        factory.set(result,"model",convert(temp),false);
                        ptm.ruleFinished(temp);
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:248:1: ( ';' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:248:2: ';'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,15,FOLLOW_15_in_ruleChartArgument264); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(0)).eContents().get(3)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:255:1: ( ( 'version' ) ( '=' ) ( RULE_ID ) ( ';' ) )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:255:1: ( ( 'version' ) ( '=' ) ( RULE_ID ) ( ';' ) )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:255:2: ( 'version' ) ( '=' ) ( RULE_ID ) ( ';' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:255:2: ( 'version' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:255:3: 'version'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,18,FOLLOW_18_in_ruleChartArgument276); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(1)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:261:1: ( '=' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:261:2: '='
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,17,FOLLOW_17_in_ruleChartArgument283); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(1)).eContents().get(1)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:267:1: ( RULE_ID )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:267:2: RULE_ID
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChartArgument291); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        Token temp = getLastToken();
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(1)).eContents().get(2)));
                        factory.set(result,"version",convert(temp),false);
                        ptm.ruleFinished(temp);
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:277:1: ( ';' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:277:2: ';'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,15,FOLLOW_15_in_ruleChartArgument299); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(1)).eContents().get(3)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }


                    }
                    break;

            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 3, ruleChartArgument_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleChartArgument


    // $ANTLR start ruleIoDeclaration
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:291:1: ruleIoDeclaration returns [EObject result] : ( (temp_DeclType= ruleDeclType ) ( RULE_ID ) ( ( ':' ) ( '=' ) ( RULE_INT ) )? ( ( ':' ) (temp_VType= ruleVType ) )? ( ';' ) ) ;
    public EObject ruleIoDeclaration() throws RecognitionException {
        EObject result = null;
        int ruleIoDeclaration_StartIndex = input.index();
        EObject temp_DeclType = null;

        EObject temp_VType = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:294:4: ( ( (temp_DeclType= ruleDeclType ) ( RULE_ID ) ( ( ':' ) ( '=' ) ( RULE_INT ) )? ( ( ':' ) (temp_VType= ruleVType ) )? ( ';' ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:294:4: ( (temp_DeclType= ruleDeclType ) ( RULE_ID ) ( ( ':' ) ( '=' ) ( RULE_INT ) )? ( ( ':' ) (temp_VType= ruleVType ) )? ( ';' ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "IoDeclaration");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:297:1: ( (temp_DeclType= ruleDeclType ) ( RULE_ID ) ( ( ':' ) ( '=' ) ( RULE_INT ) )? ( ( ':' ) (temp_VType= ruleVType ) )? ( ';' ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:297:2: (temp_DeclType= ruleDeclType ) ( RULE_ID ) ( ( ':' ) ( '=' ) ( RULE_INT ) )? ( ( ':' ) (temp_VType= ruleVType ) )? ( ';' )
            {
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:297:2: (temp_DeclType= ruleDeclType )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:297:3: temp_DeclType= ruleDeclType
            {
            if ( backtracking==0 ) {
              ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(0)));
            }
            pushFollow(FOLLOW_ruleDeclType_in_ruleIoDeclaration342);
            temp_DeclType=ruleDeclType();
            _fsp--;
            if (failed) return result;
            if ( backtracking==0 ) {
              if (temp_DeclType != null) {
                hasContent = true;
                ptm.setModelElement(temp_DeclType);
                factory.set(result,"type",convert(temp_DeclType),false);
                ptm.ruleFinished(temp_DeclType);
              } else {
                ptm.destroyNode();
              }

            }

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:309:1: ( RULE_ID )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:309:2: RULE_ID
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIoDeclaration351); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                Token temp = getLastToken();
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(1)));
                factory.set(result,"name",convert(temp),false);
                ptm.ruleFinished(temp);
              }
            }

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:319:1: ( ( ':' ) ( '=' ) ( RULE_INT ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==17) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:319:2: ( ':' ) ( '=' ) ( RULE_INT )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:319:2: ( ':' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:319:3: ':'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,19,FOLLOW_19_in_ruleIoDeclaration360); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(2)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:325:1: ( '=' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:325:2: '='
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,17,FOLLOW_17_in_ruleIoDeclaration367); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(2)).eContents().get(1)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:331:1: ( RULE_INT )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:331:2: RULE_INT
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIoDeclaration375); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        Token temp = getLastToken();
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(2)).eContents().get(2)));
                        factory.set(result,"initialValue",convert(temp),false);
                        ptm.ruleFinished(temp);
                      }
                    }

                    }


                    }
                    break;

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:342:1: ( ( ':' ) (temp_VType= ruleVType ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:342:2: ( ':' ) (temp_VType= ruleVType )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:342:2: ( ':' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:342:3: ':'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,19,FOLLOW_19_in_ruleIoDeclaration387); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(3)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:348:1: (temp_VType= ruleVType )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:348:2: temp_VType= ruleVType
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(3)).eContents().get(1)));
                    }
                    pushFollow(FOLLOW_ruleVType_in_ruleIoDeclaration397);
                    temp_VType=ruleVType();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_VType != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_VType);
                        factory.set(result,"valueType",convert(temp_VType),false);
                        ptm.ruleFinished(temp_VType);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }


                    }
                    break;

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:361:1: ( ';' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:361:2: ';'
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,15,FOLLOW_15_in_ruleIoDeclaration408); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(2)).eContents().get(1)).eContents().get(4)));
                ptm.ruleFinished(getLastToken());
              }
            }

            }


            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 4, ruleIoDeclaration_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleIoDeclaration


    // $ANTLR start ruleDeclType
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:374:1: ruleDeclType returns [EObject result] : ( ( 'input' ) | ( 'output' ) ) ;
    public EObject ruleDeclType() throws RecognitionException {
        EObject result = null;
        int ruleDeclType_StartIndex = input.index();
        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:377:4: ( ( ( 'input' ) | ( 'output' ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:377:4: ( ( 'input' ) | ( 'output' ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "DeclType");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:380:1: ( ( 'input' ) | ( 'output' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            else if ( (LA8_0==21) ) {
                alt8=2;
            }
            else {
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("380:1: ( ( 'input' ) | ( 'output' ) )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:380:2: ( 'input' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:380:2: ( 'input' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:380:3: 'input'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,20,FOLLOW_20_in_ruleDeclType446); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(3)).eContents().get(1)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:386:1: ( 'output' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:386:1: ( 'output' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:386:2: 'output'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,21,FOLLOW_21_in_ruleDeclType455); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(3)).eContents().get(1)).eContents().get(1)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;

            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 5, ruleDeclType_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleDeclType


    // $ANTLR start ruleVType
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:399:1: ruleVType returns [EObject result] : ( ( 'boolean' ) | ( 'double' ) | ( 'float' ) | ( 'integer' ) ) ;
    public EObject ruleVType() throws RecognitionException {
        EObject result = null;
        int ruleVType_StartIndex = input.index();
        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:402:4: ( ( ( 'boolean' ) | ( 'double' ) | ( 'float' ) | ( 'integer' ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:402:4: ( ( 'boolean' ) | ( 'double' ) | ( 'float' ) | ( 'integer' ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "VType");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:405:1: ( ( 'boolean' ) | ( 'double' ) | ( 'float' ) | ( 'integer' ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt9=1;
                }
                break;
            case 23:
                {
                alt9=2;
                }
                break;
            case 24:
                {
                alt9=3;
                }
                break;
            case 25:
                {
                alt9=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("405:1: ( ( 'boolean' ) | ( 'double' ) | ( 'float' ) | ( 'integer' ) )", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:405:2: ( 'boolean' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:405:2: ( 'boolean' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:405:3: 'boolean'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,22,FOLLOW_22_in_ruleVType493); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(4)).eContents().get(1)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:411:1: ( 'double' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:411:1: ( 'double' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:411:2: 'double'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,23,FOLLOW_23_in_ruleVType502); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(4)).eContents().get(1)).eContents().get(1)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 3 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:417:1: ( 'float' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:417:1: ( 'float' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:417:2: 'float'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,24,FOLLOW_24_in_ruleVType511); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(4)).eContents().get(1)).eContents().get(2)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 4 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:423:1: ( 'integer' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:423:1: ( 'integer' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:423:2: 'integer'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,25,FOLLOW_25_in_ruleVType520); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(4)).eContents().get(1)).eContents().get(3)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;

            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 6, ruleVType_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleVType


    // $ANTLR start ruleState
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:436:1: ruleState returns [EObject result] : ( ( RULE_ID ) ( ( '[' ) (temp_StateArgument= ruleStateArgument )* ( ']' ) )? ( ( '{' ) (temp_Element= ruleElement )* ( '}' ) )? ( ';' ) ) ;
    public EObject ruleState() throws RecognitionException {
        EObject result = null;
        int ruleState_StartIndex = input.index();
        EObject temp_StateArgument = null;

        EObject temp_Element = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:439:4: ( ( ( RULE_ID ) ( ( '[' ) (temp_StateArgument= ruleStateArgument )* ( ']' ) )? ( ( '{' ) (temp_Element= ruleElement )* ( '}' ) )? ( ';' ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:439:4: ( ( RULE_ID ) ( ( '[' ) (temp_StateArgument= ruleStateArgument )* ( ']' ) )? ( ( '{' ) (temp_Element= ruleElement )* ( '}' ) )? ( ';' ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "State");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:442:1: ( ( RULE_ID ) ( ( '[' ) (temp_StateArgument= ruleStateArgument )* ( ']' ) )? ( ( '{' ) (temp_Element= ruleElement )* ( '}' ) )? ( ';' ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:442:2: ( RULE_ID ) ( ( '[' ) (temp_StateArgument= ruleStateArgument )* ( ']' ) )? ( ( '{' ) (temp_Element= ruleElement )* ( '}' ) )? ( ';' )
            {
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:442:2: ( RULE_ID )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:442:3: RULE_ID
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState559); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                Token temp = getLastToken();
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(0)));
                factory.set(result,"name",convert(temp),false);
                ptm.ruleFinished(temp);
              }
            }

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:452:1: ( ( '[' ) (temp_StateArgument= ruleStateArgument )* ( ']' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==11) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:452:2: ( '[' ) (temp_StateArgument= ruleStateArgument )* ( ']' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:452:2: ( '[' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:452:3: '['
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,11,FOLLOW_11_in_ruleState568); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(1)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:458:1: (temp_StateArgument= ruleStateArgument )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>=26 && LA10_0<=27)) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:458:2: temp_StateArgument= ruleStateArgument
                    	    {
                    	    if ( backtracking==0 ) {
                    	      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(1)).eContents().get(1)));
                    	    }
                    	    pushFollow(FOLLOW_ruleStateArgument_in_ruleState578);
                    	    temp_StateArgument=ruleStateArgument();
                    	    _fsp--;
                    	    if (failed) return result;
                    	    if ( backtracking==0 ) {
                    	      if (temp_StateArgument != null) {
                    	        hasContent = true;
                    	        ptm.setModelElement(temp_StateArgument);
                    	        factory.add(result,"arguments",convert(temp_StateArgument),false);
                    	        ptm.ruleFinished(temp_StateArgument);
                    	      } else {
                    	        ptm.destroyNode();
                    	      }

                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:470:1: ( ']' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:470:2: ']'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,12,FOLLOW_12_in_ruleState587); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(1)).eContents().get(2)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:477:1: ( ( '{' ) (temp_Element= ruleElement )* ( '}' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==13) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:477:2: ( '{' ) (temp_Element= ruleElement )* ( '}' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:477:2: ( '{' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:477:3: '{'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,13,FOLLOW_13_in_ruleState598); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(2)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:483:1: (temp_Element= ruleElement )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID||(LA12_0>=31 && LA12_0<=32)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:483:2: temp_Element= ruleElement
                    	    {
                    	    if ( backtracking==0 ) {
                    	      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(2)).eContents().get(1)));
                    	    }
                    	    pushFollow(FOLLOW_ruleElement_in_ruleState608);
                    	    temp_Element=ruleElement();
                    	    _fsp--;
                    	    if (failed) return result;
                    	    if ( backtracking==0 ) {
                    	      if (temp_Element != null) {
                    	        hasContent = true;
                    	        ptm.setModelElement(temp_Element);
                    	        factory.add(result,"elements",convert(temp_Element),false);
                    	        ptm.ruleFinished(temp_Element);
                    	      } else {
                    	        ptm.destroyNode();
                    	      }

                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:495:1: ( '}' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:495:2: '}'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,14,FOLLOW_14_in_ruleState617); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(2)).eContents().get(2)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:502:1: ( ';' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:502:2: ';'
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,15,FOLLOW_15_in_ruleState627); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(3)));
                ptm.ruleFinished(getLastToken());
              }
            }

            }


            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 7, ruleState_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleState


    // $ANTLR start ruleStateArgument
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:515:1: ruleStateArgument returns [EObject result] : ( ( ( 'label' ) ( '=' ) ( RULE_STRING ) ( ';' )? ) | ( ( 'type' ) ( '=' ) (temp_Pseudo= rulePseudo ) ( ';' )? ) ) ;
    public EObject ruleStateArgument() throws RecognitionException {
        EObject result = null;
        int ruleStateArgument_StartIndex = input.index();
        EObject temp_Pseudo = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:518:4: ( ( ( ( 'label' ) ( '=' ) ( RULE_STRING ) ( ';' )? ) | ( ( 'type' ) ( '=' ) (temp_Pseudo= rulePseudo ) ( ';' )? ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:518:4: ( ( ( 'label' ) ( '=' ) ( RULE_STRING ) ( ';' )? ) | ( ( 'type' ) ( '=' ) (temp_Pseudo= rulePseudo ) ( ';' )? ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "StateArgument");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:521:1: ( ( ( 'label' ) ( '=' ) ( RULE_STRING ) ( ';' )? ) | ( ( 'type' ) ( '=' ) (temp_Pseudo= rulePseudo ) ( ';' )? ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            else if ( (LA16_0==27) ) {
                alt16=2;
            }
            else {
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("521:1: ( ( ( 'label' ) ( '=' ) ( RULE_STRING ) ( ';' )? ) | ( ( 'type' ) ( '=' ) (temp_Pseudo= rulePseudo ) ( ';' )? ) )", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:521:2: ( ( 'label' ) ( '=' ) ( RULE_STRING ) ( ';' )? )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:521:2: ( ( 'label' ) ( '=' ) ( RULE_STRING ) ( ';' )? )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:521:3: ( 'label' ) ( '=' ) ( RULE_STRING ) ( ';' )?
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:521:3: ( 'label' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:521:4: 'label'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,26,FOLLOW_26_in_ruleStateArgument666); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(0)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:527:1: ( '=' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:527:2: '='
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,17,FOLLOW_17_in_ruleStateArgument673); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(0)).eContents().get(1)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:533:1: ( RULE_STRING )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:533:2: RULE_STRING
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStateArgument681); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        Token temp = getLastToken();
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(0)).eContents().get(2)));
                        factory.set(result,"label",convert(temp),false);
                        ptm.ruleFinished(temp);
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:543:1: ( ';' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==15) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:543:2: ';'
                            {
                            if ( backtracking==0 ) {
                              skipCurrentToken = false;
                            }
                            match(input,15,FOLLOW_15_in_ruleStateArgument689); if (failed) return result;
                            if ( backtracking==0 ) {
                              if (!skipCurrentToken) {
                                hasContent = true;
                                ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(0)).eContents().get(3)));
                                ptm.ruleFinished(getLastToken());
                              }
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:550:1: ( ( 'type' ) ( '=' ) (temp_Pseudo= rulePseudo ) ( ';' )? )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:550:1: ( ( 'type' ) ( '=' ) (temp_Pseudo= rulePseudo ) ( ';' )? )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:550:2: ( 'type' ) ( '=' ) (temp_Pseudo= rulePseudo ) ( ';' )?
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:550:2: ( 'type' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:550:3: 'type'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,27,FOLLOW_27_in_ruleStateArgument702); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(1)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:556:1: ( '=' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:556:2: '='
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,17,FOLLOW_17_in_ruleStateArgument709); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(1)).eContents().get(1)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:562:1: (temp_Pseudo= rulePseudo )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:562:2: temp_Pseudo= rulePseudo
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(1)).eContents().get(2)));
                    }
                    pushFollow(FOLLOW_rulePseudo_in_ruleStateArgument719);
                    temp_Pseudo=rulePseudo();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_Pseudo != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_Pseudo);
                        factory.set(result,"type",convert(temp_Pseudo),false);
                        ptm.ruleFinished(temp_Pseudo);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:574:1: ( ';' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==15) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:574:2: ';'
                            {
                            if ( backtracking==0 ) {
                              skipCurrentToken = false;
                            }
                            match(input,15,FOLLOW_15_in_ruleStateArgument727); if (failed) return result;
                            if ( backtracking==0 ) {
                              if (!skipCurrentToken) {
                                hasContent = true;
                                ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)).eContents().get(1)).eContents().get(3)));
                                ptm.ruleFinished(getLastToken());
                              }
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 8, ruleStateArgument_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleStateArgument


    // $ANTLR start rulePseudo
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:588:1: rulePseudo returns [EObject result] : ( ( 'final' ) | ( 'initial' ) | ( 'pseudo' ) ) ;
    public EObject rulePseudo() throws RecognitionException {
        EObject result = null;
        int rulePseudo_StartIndex = input.index();
        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:591:4: ( ( ( 'final' ) | ( 'initial' ) | ( 'pseudo' ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:591:4: ( ( 'final' ) | ( 'initial' ) | ( 'pseudo' ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "Pseudo");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:594:1: ( ( 'final' ) | ( 'initial' ) | ( 'pseudo' ) )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt17=1;
                }
                break;
            case 29:
                {
                alt17=2;
                }
                break;
            case 30:
                {
                alt17=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("594:1: ( ( 'final' ) | ( 'initial' ) | ( 'pseudo' ) )", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:594:2: ( 'final' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:594:2: ( 'final' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:594:3: 'final'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,28,FOLLOW_28_in_rulePseudo768); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(7)).eContents().get(1)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:600:1: ( 'initial' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:600:1: ( 'initial' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:600:2: 'initial'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,29,FOLLOW_29_in_rulePseudo777); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(7)).eContents().get(1)).eContents().get(1)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 3 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:606:1: ( 'pseudo' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:606:1: ( 'pseudo' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:606:2: 'pseudo'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,30,FOLLOW_30_in_rulePseudo786); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(7)).eContents().get(1)).eContents().get(2)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;

            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 9, rulePseudo_StartIndex); }
        }
        return result;
    }
    // $ANTLR end rulePseudo


    // $ANTLR start ruleElement
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:619:1: ruleElement returns [EObject result] : ( (temp_State= ruleState ) | (temp_Transition= ruleTransition ) | ( '||' ) ) ;
    public EObject ruleElement() throws RecognitionException {
        EObject result = null;
        int ruleElement_StartIndex = input.index();
        EObject temp_State = null;

        EObject temp_Transition = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:622:4: ( ( (temp_State= ruleState ) | (temp_Transition= ruleTransition ) | ( '||' ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:622:4: ( (temp_State= ruleState ) | (temp_Transition= ruleTransition ) | ( '||' ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "Element");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:625:1: ( (temp_State= ruleState ) | (temp_Transition= ruleTransition ) | ( '||' ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==11||LA18_1==13||LA18_1==15) ) {
                    alt18=1;
                }
                else if ( (LA18_1==32) ) {
                    alt18=2;
                }
                else {
                    if (backtracking>0) {failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("625:1: ( (temp_State= ruleState ) | (temp_Transition= ruleTransition ) | ( '||' ) )", 18, 1, input);

                    throw nvae;
                }
                }
                break;
            case 32:
                {
                alt18=2;
                }
                break;
            case 31:
                {
                alt18=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("625:1: ( (temp_State= ruleState ) | (temp_Transition= ruleTransition ) | ( '||' ) )", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:625:2: (temp_State= ruleState )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:625:2: (temp_State= ruleState )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:625:3: temp_State= ruleState
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(8)).eContents().get(1)).eContents().get(0)));
                    }
                    pushFollow(FOLLOW_ruleState_in_ruleElement827);
                    temp_State=ruleState();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_State != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_State);
                        ptm.ruleFinished(temp_State);
                        result =temp_State;
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }


                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:638:1: (temp_Transition= ruleTransition )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:638:1: (temp_Transition= ruleTransition )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:638:2: temp_Transition= ruleTransition
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(8)).eContents().get(1)).eContents().get(1)));
                    }
                    pushFollow(FOLLOW_ruleTransition_in_ruleElement841);
                    temp_Transition=ruleTransition();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_Transition != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_Transition);
                        ptm.ruleFinished(temp_Transition);
                        result =temp_Transition;
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }


                    }
                    break;
                case 3 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:651:1: ( '||' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:651:1: ( '||' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:651:2: '||'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,31,FOLLOW_31_in_ruleElement852); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(8)).eContents().get(1)).eContents().get(2)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;

            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 10, ruleElement_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleElement


    // $ANTLR start ruleTransition
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:664:1: ruleTransition returns [EObject result] : ( ( RULE_ID )? ( '->' ) ( RULE_ID ) ( ( '[' ) (temp_TransArgument= ruleTransArgument )* ( ']' ) )? ( ';' ) ) ;
    public EObject ruleTransition() throws RecognitionException {
        EObject result = null;
        int ruleTransition_StartIndex = input.index();
        EObject temp_TransArgument = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:667:4: ( ( ( RULE_ID )? ( '->' ) ( RULE_ID ) ( ( '[' ) (temp_TransArgument= ruleTransArgument )* ( ']' ) )? ( ';' ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:667:4: ( ( RULE_ID )? ( '->' ) ( RULE_ID ) ( ( '[' ) (temp_TransArgument= ruleTransArgument )* ( ']' ) )? ( ';' ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "Transition");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:670:1: ( ( RULE_ID )? ( '->' ) ( RULE_ID ) ( ( '[' ) (temp_TransArgument= ruleTransArgument )* ( ']' ) )? ( ';' ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:670:2: ( RULE_ID )? ( '->' ) ( RULE_ID ) ( ( '[' ) (temp_TransArgument= ruleTransArgument )* ( ']' ) )? ( ';' )
            {
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:670:2: ( RULE_ID )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:670:3: RULE_ID
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition891); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        Token temp = getLastToken();
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(1)).eContents().get(0)));
                        factory.set(result,"source",convert(temp),false);
                        ptm.ruleFinished(temp);
                      }
                    }

                    }
                    break;

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:680:1: ( '->' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:680:2: '->'
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,32,FOLLOW_32_in_ruleTransition900); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(1)).eContents().get(1)));
                ptm.ruleFinished(getLastToken());
              }
            }

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:686:1: ( RULE_ID )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:686:2: RULE_ID
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition908); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                Token temp = getLastToken();
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(1)).eContents().get(2)));
                factory.set(result,"target",convert(temp),false);
                ptm.ruleFinished(temp);
              }
            }

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:696:1: ( ( '[' ) (temp_TransArgument= ruleTransArgument )* ( ']' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==11) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:696:2: ( '[' ) (temp_TransArgument= ruleTransArgument )* ( ']' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:696:2: ( '[' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:696:3: '['
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,11,FOLLOW_11_in_ruleTransition917); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(1)).eContents().get(3)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:702:1: (temp_TransArgument= ruleTransArgument )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>=26 && LA20_0<=27)||LA20_0==33) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:702:2: temp_TransArgument= ruleTransArgument
                    	    {
                    	    if ( backtracking==0 ) {
                    	      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(1)).eContents().get(3)).eContents().get(1)));
                    	    }
                    	    pushFollow(FOLLOW_ruleTransArgument_in_ruleTransition927);
                    	    temp_TransArgument=ruleTransArgument();
                    	    _fsp--;
                    	    if (failed) return result;
                    	    if ( backtracking==0 ) {
                    	      if (temp_TransArgument != null) {
                    	        hasContent = true;
                    	        ptm.setModelElement(temp_TransArgument);
                    	        factory.add(result,"arguments",convert(temp_TransArgument),false);
                    	        ptm.ruleFinished(temp_TransArgument);
                    	      } else {
                    	        ptm.destroyNode();
                    	      }

                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:714:1: ( ']' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:714:2: ']'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,12,FOLLOW_12_in_ruleTransition936); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(1)).eContents().get(3)).eContents().get(2)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:721:1: ( ';' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:721:2: ';'
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,15,FOLLOW_15_in_ruleTransition946); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(1)).eContents().get(4)));
                ptm.ruleFinished(getLastToken());
              }
            }

            }


            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 11, ruleTransition_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleTransition


    // $ANTLR start ruleTransArgument
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:734:1: ruleTransArgument returns [EObject result] : ( ( ( 'label' ) ( '=' ) (temp_Action= ruleAction ) ( ';' )? ) | ( ( 'type' ) ( '=' ) (temp_TransType= ruleTransType ) ( ';' )? ) | ( ( 'priority' ) ( '=' ) ( RULE_INT ) ( ';' )? ) ) ;
    public EObject ruleTransArgument() throws RecognitionException {
        EObject result = null;
        int ruleTransArgument_StartIndex = input.index();
        EObject temp_Action = null;

        EObject temp_TransType = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:737:4: ( ( ( ( 'label' ) ( '=' ) (temp_Action= ruleAction ) ( ';' )? ) | ( ( 'type' ) ( '=' ) (temp_TransType= ruleTransType ) ( ';' )? ) | ( ( 'priority' ) ( '=' ) ( RULE_INT ) ( ';' )? ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:737:4: ( ( ( 'label' ) ( '=' ) (temp_Action= ruleAction ) ( ';' )? ) | ( ( 'type' ) ( '=' ) (temp_TransType= ruleTransType ) ( ';' )? ) | ( ( 'priority' ) ( '=' ) ( RULE_INT ) ( ';' )? ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "TransArgument");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:740:1: ( ( ( 'label' ) ( '=' ) (temp_Action= ruleAction ) ( ';' )? ) | ( ( 'type' ) ( '=' ) (temp_TransType= ruleTransType ) ( ';' )? ) | ( ( 'priority' ) ( '=' ) ( RULE_INT ) ( ';' )? ) )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt25=1;
                }
                break;
            case 27:
                {
                alt25=2;
                }
                break;
            case 33:
                {
                alt25=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("740:1: ( ( ( 'label' ) ( '=' ) (temp_Action= ruleAction ) ( ';' )? ) | ( ( 'type' ) ( '=' ) (temp_TransType= ruleTransType ) ( ';' )? ) | ( ( 'priority' ) ( '=' ) ( RULE_INT ) ( ';' )? ) )", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:740:2: ( ( 'label' ) ( '=' ) (temp_Action= ruleAction ) ( ';' )? )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:740:2: ( ( 'label' ) ( '=' ) (temp_Action= ruleAction ) ( ';' )? )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:740:3: ( 'label' ) ( '=' ) (temp_Action= ruleAction ) ( ';' )?
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:740:3: ( 'label' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:740:4: 'label'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,26,FOLLOW_26_in_ruleTransArgument985); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(0)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:746:1: ( '=' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:746:2: '='
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,17,FOLLOW_17_in_ruleTransArgument992); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(0)).eContents().get(1)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:752:1: (temp_Action= ruleAction )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:752:2: temp_Action= ruleAction
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(0)).eContents().get(2)));
                    }
                    pushFollow(FOLLOW_ruleAction_in_ruleTransArgument1002);
                    temp_Action=ruleAction();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_Action != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_Action);
                        factory.set(result,"label",convert(temp_Action),false);
                        ptm.ruleFinished(temp_Action);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:764:1: ( ';' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==15) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:764:2: ';'
                            {
                            if ( backtracking==0 ) {
                              skipCurrentToken = false;
                            }
                            match(input,15,FOLLOW_15_in_ruleTransArgument1010); if (failed) return result;
                            if ( backtracking==0 ) {
                              if (!skipCurrentToken) {
                                hasContent = true;
                                ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(0)).eContents().get(3)));
                                ptm.ruleFinished(getLastToken());
                              }
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:771:1: ( ( 'type' ) ( '=' ) (temp_TransType= ruleTransType ) ( ';' )? )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:771:1: ( ( 'type' ) ( '=' ) (temp_TransType= ruleTransType ) ( ';' )? )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:771:2: ( 'type' ) ( '=' ) (temp_TransType= ruleTransType ) ( ';' )?
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:771:2: ( 'type' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:771:3: 'type'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,27,FOLLOW_27_in_ruleTransArgument1023); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(1)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:777:1: ( '=' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:777:2: '='
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,17,FOLLOW_17_in_ruleTransArgument1030); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(1)).eContents().get(1)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:783:1: (temp_TransType= ruleTransType )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:783:2: temp_TransType= ruleTransType
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(1)).eContents().get(2)));
                    }
                    pushFollow(FOLLOW_ruleTransType_in_ruleTransArgument1040);
                    temp_TransType=ruleTransType();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_TransType != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_TransType);
                        factory.set(result,"type",convert(temp_TransType),false);
                        ptm.ruleFinished(temp_TransType);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:795:1: ( ';' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==15) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:795:2: ';'
                            {
                            if ( backtracking==0 ) {
                              skipCurrentToken = false;
                            }
                            match(input,15,FOLLOW_15_in_ruleTransArgument1048); if (failed) return result;
                            if ( backtracking==0 ) {
                              if (!skipCurrentToken) {
                                hasContent = true;
                                ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(1)).eContents().get(3)));
                                ptm.ruleFinished(getLastToken());
                              }
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:802:1: ( ( 'priority' ) ( '=' ) ( RULE_INT ) ( ';' )? )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:802:1: ( ( 'priority' ) ( '=' ) ( RULE_INT ) ( ';' )? )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:802:2: ( 'priority' ) ( '=' ) ( RULE_INT ) ( ';' )?
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:802:2: ( 'priority' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:802:3: 'priority'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,33,FOLLOW_33_in_ruleTransArgument1061); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(2)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:808:1: ( '=' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:808:2: '='
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,17,FOLLOW_17_in_ruleTransArgument1068); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(2)).eContents().get(1)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:814:1: ( RULE_INT )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:814:2: RULE_INT
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTransArgument1076); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        Token temp = getLastToken();
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(2)).eContents().get(2)));
                        factory.set(result,"prio",convert(temp),false);
                        ptm.ruleFinished(temp);
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:824:1: ( ';' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==15) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:824:2: ';'
                            {
                            if ( backtracking==0 ) {
                              skipCurrentToken = false;
                            }
                            match(input,15,FOLLOW_15_in_ruleTransArgument1084); if (failed) return result;
                            if ( backtracking==0 ) {
                              if (!skipCurrentToken) {
                                hasContent = true;
                                ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(10)).eContents().get(1)).eContents().get(2)).eContents().get(3)));
                                ptm.ruleFinished(getLastToken());
                              }
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 12, ruleTransArgument_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleTransArgument


    // $ANTLR start ruleTransType
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:838:1: ruleTransType returns [EObject result] : (temp_weakabortion= ruleweakabortion | temp_strongabortion= rulestrongabortion | temp_normaltermination= rulenormaltermination );
    public EObject ruleTransType() throws RecognitionException {
        EObject result = null;
        int ruleTransType_StartIndex = input.index();
        EObject temp_weakabortion = null;

        EObject temp_strongabortion = null;

        EObject temp_normaltermination = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:840:9: (temp_weakabortion= ruleweakabortion | temp_strongabortion= rulestrongabortion | temp_normaltermination= rulenormaltermination )
            int alt26=3;
            switch ( input.LA(1) ) {
            case 34:
            case 35:
                {
                alt26=1;
                }
                break;
            case 36:
            case 37:
                {
                alt26=2;
                }
                break;
            case 38:
            case 39:
                {
                alt26=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("838:1: ruleTransType returns [EObject result] : (temp_weakabortion= ruleweakabortion | temp_strongabortion= rulestrongabortion | temp_normaltermination= rulenormaltermination );", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:840:9: temp_weakabortion= ruleweakabortion
                    {
                    pushFollow(FOLLOW_ruleweakabortion_in_ruleTransType1122);
                    temp_weakabortion=ruleweakabortion();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      result =temp_weakabortion;
                    }

                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:840:82: temp_strongabortion= rulestrongabortion
                    {
                    pushFollow(FOLLOW_rulestrongabortion_in_ruleTransType1137);
                    temp_strongabortion=rulestrongabortion();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      result =temp_strongabortion;
                    }

                    }
                    break;
                case 3 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:840:161: temp_normaltermination= rulenormaltermination
                    {
                    pushFollow(FOLLOW_rulenormaltermination_in_ruleTransType1152);
                    temp_normaltermination=rulenormaltermination();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      result =temp_normaltermination;
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
            if ( backtracking>0 ) { memoize(input, 13, ruleTransType_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleTransType


    // $ANTLR start ruleweakabortion
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:842:1: ruleweakabortion returns [EObject result] : ( ( 'weakAbortion' ) | ( 'wa' ) ) ;
    public EObject ruleweakabortion() throws RecognitionException {
        EObject result = null;
        int ruleweakabortion_StartIndex = input.index();
        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:845:4: ( ( ( 'weakAbortion' ) | ( 'wa' ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:845:4: ( ( 'weakAbortion' ) | ( 'wa' ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "weakabortion");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:848:1: ( ( 'weakAbortion' ) | ( 'wa' ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==34) ) {
                alt27=1;
            }
            else if ( (LA27_0==35) ) {
                alt27=2;
            }
            else {
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("848:1: ( ( 'weakAbortion' ) | ( 'wa' ) )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:848:2: ( 'weakAbortion' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:848:2: ( 'weakAbortion' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:848:3: 'weakAbortion'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,34,FOLLOW_34_in_ruleweakabortion1180); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(12)).eContents().get(1)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:854:1: ( 'wa' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:854:1: ( 'wa' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:854:2: 'wa'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,35,FOLLOW_35_in_ruleweakabortion1189); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(12)).eContents().get(1)).eContents().get(1)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;

            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 14, ruleweakabortion_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleweakabortion


    // $ANTLR start rulestrongabortion
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:867:1: rulestrongabortion returns [EObject result] : ( ( 'strongAbortion' ) | ( 'sa' ) ) ;
    public EObject rulestrongabortion() throws RecognitionException {
        EObject result = null;
        int rulestrongabortion_StartIndex = input.index();
        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:870:4: ( ( ( 'strongAbortion' ) | ( 'sa' ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:870:4: ( ( 'strongAbortion' ) | ( 'sa' ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "strongabortion");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:873:1: ( ( 'strongAbortion' ) | ( 'sa' ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==36) ) {
                alt28=1;
            }
            else if ( (LA28_0==37) ) {
                alt28=2;
            }
            else {
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("873:1: ( ( 'strongAbortion' ) | ( 'sa' ) )", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:873:2: ( 'strongAbortion' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:873:2: ( 'strongAbortion' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:873:3: 'strongAbortion'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,36,FOLLOW_36_in_rulestrongabortion1227); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(13)).eContents().get(1)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:879:1: ( 'sa' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:879:1: ( 'sa' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:879:2: 'sa'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,37,FOLLOW_37_in_rulestrongabortion1236); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(13)).eContents().get(1)).eContents().get(1)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;

            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 15, rulestrongabortion_StartIndex); }
        }
        return result;
    }
    // $ANTLR end rulestrongabortion


    // $ANTLR start rulenormaltermination
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:892:1: rulenormaltermination returns [EObject result] : ( ( 'normalTermination' ) | ( 'nt' ) ) ;
    public EObject rulenormaltermination() throws RecognitionException {
        EObject result = null;
        int rulenormaltermination_StartIndex = input.index();
        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 16) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:895:4: ( ( ( 'normalTermination' ) | ( 'nt' ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:895:4: ( ( 'normalTermination' ) | ( 'nt' ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "normaltermination");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:898:1: ( ( 'normalTermination' ) | ( 'nt' ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==38) ) {
                alt29=1;
            }
            else if ( (LA29_0==39) ) {
                alt29=2;
            }
            else {
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("898:1: ( ( 'normalTermination' ) | ( 'nt' ) )", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:898:2: ( 'normalTermination' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:898:2: ( 'normalTermination' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:898:3: 'normalTermination'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,38,FOLLOW_38_in_rulenormaltermination1274); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(14)).eContents().get(1)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:904:1: ( 'nt' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:904:1: ( 'nt' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:904:2: 'nt'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,39,FOLLOW_39_in_rulenormaltermination1283); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(14)).eContents().get(1)).eContents().get(1)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;

            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 16, rulenormaltermination_StartIndex); }
        }
        return result;
    }
    // $ANTLR end rulenormaltermination


    // $ANTLR start ruleAction
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:917:1: ruleAction returns [EObject result] : ( (temp_Trigger= ruleTrigger ) ( '/' ) (temp_Emission= ruleEmission )* ) ;
    public EObject ruleAction() throws RecognitionException {
        EObject result = null;
        int ruleAction_StartIndex = input.index();
        EObject temp_Trigger = null;

        EObject temp_Emission = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 17) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:920:4: ( ( (temp_Trigger= ruleTrigger ) ( '/' ) (temp_Emission= ruleEmission )* ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:920:4: ( (temp_Trigger= ruleTrigger ) ( '/' ) (temp_Emission= ruleEmission )* )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "Action");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:923:1: ( (temp_Trigger= ruleTrigger ) ( '/' ) (temp_Emission= ruleEmission )* )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:923:2: (temp_Trigger= ruleTrigger ) ( '/' ) (temp_Emission= ruleEmission )*
            {
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:923:2: (temp_Trigger= ruleTrigger )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:923:3: temp_Trigger= ruleTrigger
            {
            if ( backtracking==0 ) {
              ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(15)).eContents().get(1)).eContents().get(0)));
            }
            pushFollow(FOLLOW_ruleTrigger_in_ruleAction1324);
            temp_Trigger=ruleTrigger();
            _fsp--;
            if (failed) return result;
            if ( backtracking==0 ) {
              if (temp_Trigger != null) {
                hasContent = true;
                ptm.setModelElement(temp_Trigger);
                factory.set(result,"trigger",convert(temp_Trigger),false);
                ptm.ruleFinished(temp_Trigger);
              } else {
                ptm.destroyNode();
              }

            }

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:935:1: ( '/' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:935:2: '/'
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,40,FOLLOW_40_in_ruleAction1332); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(15)).eContents().get(1)).eContents().get(1)));
                ptm.ruleFinished(getLastToken());
              }
            }

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:941:1: (temp_Emission= ruleEmission )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID||(LA30_0>=43 && LA30_0<=45)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:941:2: temp_Emission= ruleEmission
            	    {
            	    if ( backtracking==0 ) {
            	      ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(15)).eContents().get(1)).eContents().get(2)));
            	    }
            	    pushFollow(FOLLOW_ruleEmission_in_ruleAction1342);
            	    temp_Emission=ruleEmission();
            	    _fsp--;
            	    if (failed) return result;
            	    if ( backtracking==0 ) {
            	      if (temp_Emission != null) {
            	        hasContent = true;
            	        ptm.setModelElement(temp_Emission);
            	        factory.add(result,"effects",convert(temp_Emission),false);
            	        ptm.ruleFinished(temp_Emission);
            	      } else {
            	        ptm.destroyNode();
            	      }

            	    }

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 17, ruleAction_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleAction


    // $ANTLR start ruleEmission
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:960:1: ruleEmission returns [EObject result] : ( (temp_Signal= ruleSignal ) ( ( '(' ) (temp_Value= ruleValue ) ( ')' ) )? ) ;
    public EObject ruleEmission() throws RecognitionException {
        EObject result = null;
        int ruleEmission_StartIndex = input.index();
        EObject temp_Signal = null;

        EObject temp_Value = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 18) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:963:4: ( ( (temp_Signal= ruleSignal ) ( ( '(' ) (temp_Value= ruleValue ) ( ')' ) )? ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:963:4: ( (temp_Signal= ruleSignal ) ( ( '(' ) (temp_Value= ruleValue ) ( ')' ) )? )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "Emission");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:966:1: ( (temp_Signal= ruleSignal ) ( ( '(' ) (temp_Value= ruleValue ) ( ')' ) )? )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:966:2: (temp_Signal= ruleSignal ) ( ( '(' ) (temp_Value= ruleValue ) ( ')' ) )?
            {
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:966:2: (temp_Signal= ruleSignal )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:966:3: temp_Signal= ruleSignal
            {
            if ( backtracking==0 ) {
              ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(16)).eContents().get(1)).eContents().get(0)));
            }
            pushFollow(FOLLOW_ruleSignal_in_ruleEmission1385);
            temp_Signal=ruleSignal();
            _fsp--;
            if (failed) return result;
            if ( backtracking==0 ) {
              if (temp_Signal != null) {
                hasContent = true;
                ptm.setModelElement(temp_Signal);
                factory.set(result,"signal",convert(temp_Signal),false);
                ptm.ruleFinished(temp_Signal);
              } else {
                ptm.destroyNode();
              }

            }

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:978:1: ( ( '(' ) (temp_Value= ruleValue ) ( ')' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==41) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:978:2: ( '(' ) (temp_Value= ruleValue ) ( ')' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:978:2: ( '(' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:978:3: '('
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,41,FOLLOW_41_in_ruleEmission1394); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(16)).eContents().get(1)).eContents().get(1)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:984:1: (temp_Value= ruleValue )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:984:2: temp_Value= ruleValue
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(16)).eContents().get(1)).eContents().get(1)).eContents().get(1)));
                    }
                    pushFollow(FOLLOW_ruleValue_in_ruleEmission1404);
                    temp_Value=ruleValue();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_Value != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_Value);
                        factory.set(result,"newValue",convert(temp_Value),false);
                        ptm.ruleFinished(temp_Value);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:996:1: ( ')' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:996:2: ')'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,42,FOLLOW_42_in_ruleEmission1412); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(16)).eContents().get(1)).eContents().get(1)).eContents().get(2)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 18, ruleEmission_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleEmission


    // $ANTLR start ruleValue
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1010:1: ruleValue returns [EObject result] : ( RULE_INT ) ;
    public EObject ruleValue() throws RecognitionException {
        EObject result = null;
        int ruleValue_StartIndex = input.index();
        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 19) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1013:4: ( ( RULE_INT ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1013:4: ( RULE_INT )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "Value");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1016:1: ( RULE_INT )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1016:2: RULE_INT
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleValue1453); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                Token temp = getLastToken();
                ptm.createNode(((EObject)((EObject)xtextfile.eContents().get(17)).eContents().get(1)));
                factory.set(result,"value",convert(temp),false);
                ptm.ruleFinished(temp);
              }
            }

            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 19, ruleValue_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleValue


    // $ANTLR start ruleSignal
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1032:1: ruleSignal returns [EObject result] : ( ( 'I' )? ( 'O' )? ( 'L' )? ( RULE_ID ) ( ( '(' ) (temp_Value= ruleValue ) ( ')' ) )? ) ;
    public EObject ruleSignal() throws RecognitionException {
        EObject result = null;
        int ruleSignal_StartIndex = input.index();
        EObject temp_Value = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 20) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1035:4: ( ( ( 'I' )? ( 'O' )? ( 'L' )? ( RULE_ID ) ( ( '(' ) (temp_Value= ruleValue ) ( ')' ) )? ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1035:4: ( ( 'I' )? ( 'O' )? ( 'L' )? ( RULE_ID ) ( ( '(' ) (temp_Value= ruleValue ) ( ')' ) )? )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "Signal");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1038:1: ( ( 'I' )? ( 'O' )? ( 'L' )? ( RULE_ID ) ( ( '(' ) (temp_Value= ruleValue ) ( ')' ) )? )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1038:2: ( 'I' )? ( 'O' )? ( 'L' )? ( RULE_ID ) ( ( '(' ) (temp_Value= ruleValue ) ( ')' ) )?
            {
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1038:2: ( 'I' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==43) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1038:3: 'I'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,43,FOLLOW_43_in_ruleSignal1491); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        Token temp = getLastToken();
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(18)).eContents().get(1)).eContents().get(0)));
                        factory.set(result,"isInput",convert(temp),false);
                        ptm.ruleFinished(temp);
                      }
                    }

                    }
                    break;

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1048:1: ( 'O' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==44) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1048:2: 'O'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,44,FOLLOW_44_in_ruleSignal1501); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        Token temp = getLastToken();
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(18)).eContents().get(1)).eContents().get(1)));
                        factory.set(result,"isOutput",convert(temp),false);
                        ptm.ruleFinished(temp);
                      }
                    }

                    }
                    break;

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1058:1: ( 'L' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==45) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1058:2: 'L'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,45,FOLLOW_45_in_ruleSignal1511); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        Token temp = getLastToken();
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(18)).eContents().get(1)).eContents().get(2)));
                        factory.set(result,"isLocal",convert(temp),false);
                        ptm.ruleFinished(temp);
                      }
                    }

                    }
                    break;

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1068:1: ( RULE_ID )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1068:2: RULE_ID
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSignal1521); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                Token temp = getLastToken();
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(18)).eContents().get(1)).eContents().get(3)));
                factory.set(result,"name",convert(temp),false);
                ptm.ruleFinished(temp);
              }
            }

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1078:1: ( ( '(' ) (temp_Value= ruleValue ) ( ')' ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==41) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==RULE_INT) ) {
                    int LA35_3 = input.LA(3);

                    if ( (LA35_3==42) ) {
                        int LA35_4 = input.LA(4);

                        if ( (synpred41()) ) {
                            alt35=1;
                        }
                    }
                }
            }
            switch (alt35) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1078:2: ( '(' ) (temp_Value= ruleValue ) ( ')' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1078:2: ( '(' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1078:3: '('
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,41,FOLLOW_41_in_ruleSignal1530); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(18)).eContents().get(1)).eContents().get(4)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1084:1: (temp_Value= ruleValue )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1084:2: temp_Value= ruleValue
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(18)).eContents().get(1)).eContents().get(4)).eContents().get(1)));
                    }
                    pushFollow(FOLLOW_ruleValue_in_ruleSignal1540);
                    temp_Value=ruleValue();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_Value != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_Value);
                        factory.set(result,"value",convert(temp_Value),false);
                        ptm.ruleFinished(temp_Value);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1096:1: ( ')' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1096:2: ')'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,42,FOLLOW_42_in_ruleSignal1548); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(18)).eContents().get(1)).eContents().get(4)).eContents().get(2)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 20, ruleSignal_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleSignal


    // $ANTLR start ruleTrigger
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1110:1: ruleTrigger returns [EObject result] : ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) ) ;
    public EObject ruleTrigger() throws RecognitionException {
        EObject result = null;
        int ruleTrigger_StartIndex = input.index();
        EObject temp_Signal = null;

        EObject temp_BinaryOp = null;

        EObject temp_Trigger = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 21) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1113:4: ( ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1113:4: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "Trigger");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                switch ( input.LA(2) ) {
                case 44:
                    {
                    int LA36_2 = input.LA(3);

                    if ( (LA36_2==45) ) {
                        int LA36_3 = input.LA(4);

                        if ( (LA36_3==RULE_ID) ) {
                            switch ( input.LA(5) ) {
                            case 41:
                                {
                                int LA36_6 = input.LA(6);

                                if ( (LA36_6==RULE_INT) ) {
                                    int LA36_9 = input.LA(7);

                                    if ( (LA36_9==42) ) {
                                        int LA36_10 = input.LA(8);

                                        if ( ((LA36_10>=46 && LA36_10<=54)) ) {
                                            alt36=2;
                                        }
                                        else if ( (LA36_10==40||LA36_10==42) ) {
                                            alt36=1;
                                        }
                                        else {
                                            if (backtracking>0) {failed=true; return result;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 10, input);

                                            throw nvae;
                                        }
                                    }
                                    else {
                                        if (backtracking>0) {failed=true; return result;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 9, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    if (backtracking>0) {failed=true; return result;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 6, input);

                                    throw nvae;
                                }
                                }
                                break;
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                            case 50:
                            case 51:
                            case 52:
                            case 53:
                            case 54:
                                {
                                alt36=2;
                                }
                                break;
                            case 40:
                            case 42:
                                {
                                alt36=1;
                                }
                                break;
                            default:
                                if (backtracking>0) {failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 4, input);

                                throw nvae;
                            }

                        }
                        else {
                            if (backtracking>0) {failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 3, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA36_2==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 41:
                            {
                            int LA36_6 = input.LA(5);

                            if ( (LA36_6==RULE_INT) ) {
                                int LA36_9 = input.LA(6);

                                if ( (LA36_9==42) ) {
                                    int LA36_10 = input.LA(7);

                                    if ( ((LA36_10>=46 && LA36_10<=54)) ) {
                                        alt36=2;
                                    }
                                    else if ( (LA36_10==40||LA36_10==42) ) {
                                        alt36=1;
                                    }
                                    else {
                                        if (backtracking>0) {failed=true; return result;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 10, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    if (backtracking>0) {failed=true; return result;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 9, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                            {
                            alt36=2;
                            }
                            break;
                        case 40:
                        case 42:
                            {
                            alt36=1;
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        if (backtracking>0) {failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case 45:
                    {
                    int LA36_3 = input.LA(3);

                    if ( (LA36_3==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 41:
                            {
                            int LA36_6 = input.LA(5);

                            if ( (LA36_6==RULE_INT) ) {
                                int LA36_9 = input.LA(6);

                                if ( (LA36_9==42) ) {
                                    int LA36_10 = input.LA(7);

                                    if ( ((LA36_10>=46 && LA36_10<=54)) ) {
                                        alt36=2;
                                    }
                                    else if ( (LA36_10==40||LA36_10==42) ) {
                                        alt36=1;
                                    }
                                    else {
                                        if (backtracking>0) {failed=true; return result;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 10, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    if (backtracking>0) {failed=true; return result;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 9, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                            {
                            alt36=2;
                            }
                            break;
                        case 40:
                        case 42:
                            {
                            alt36=1;
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        if (backtracking>0) {failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_ID:
                    {
                    switch ( input.LA(3) ) {
                    case 41:
                        {
                        int LA36_6 = input.LA(4);

                        if ( (LA36_6==RULE_INT) ) {
                            int LA36_9 = input.LA(5);

                            if ( (LA36_9==42) ) {
                                int LA36_10 = input.LA(6);

                                if ( ((LA36_10>=46 && LA36_10<=54)) ) {
                                    alt36=2;
                                }
                                else if ( (LA36_10==40||LA36_10==42) ) {
                                    alt36=1;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return result;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 10, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 9, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 6, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                        {
                        alt36=2;
                        }
                        break;
                    case 40:
                    case 42:
                        {
                        alt36=1;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 4, input);

                        throw nvae;
                    }

                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 1, input);

                    throw nvae;
                }

                }
                break;
            case 44:
                {
                int LA36_2 = input.LA(2);

                if ( (LA36_2==45) ) {
                    int LA36_3 = input.LA(3);

                    if ( (LA36_3==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 41:
                            {
                            int LA36_6 = input.LA(5);

                            if ( (LA36_6==RULE_INT) ) {
                                int LA36_9 = input.LA(6);

                                if ( (LA36_9==42) ) {
                                    int LA36_10 = input.LA(7);

                                    if ( ((LA36_10>=46 && LA36_10<=54)) ) {
                                        alt36=2;
                                    }
                                    else if ( (LA36_10==40||LA36_10==42) ) {
                                        alt36=1;
                                    }
                                    else {
                                        if (backtracking>0) {failed=true; return result;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 10, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    if (backtracking>0) {failed=true; return result;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 9, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                            {
                            alt36=2;
                            }
                            break;
                        case 40:
                        case 42:
                            {
                            alt36=1;
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        if (backtracking>0) {failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA36_2==RULE_ID) ) {
                    switch ( input.LA(3) ) {
                    case 41:
                        {
                        int LA36_6 = input.LA(4);

                        if ( (LA36_6==RULE_INT) ) {
                            int LA36_9 = input.LA(5);

                            if ( (LA36_9==42) ) {
                                int LA36_10 = input.LA(6);

                                if ( ((LA36_10>=46 && LA36_10<=54)) ) {
                                    alt36=2;
                                }
                                else if ( (LA36_10==40||LA36_10==42) ) {
                                    alt36=1;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return result;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 10, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 9, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 6, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                        {
                        alt36=2;
                        }
                        break;
                    case 40:
                    case 42:
                        {
                        alt36=1;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 4, input);

                        throw nvae;
                    }

                }
                else {
                    if (backtracking>0) {failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 2, input);

                    throw nvae;
                }
                }
                break;
            case 45:
                {
                int LA36_3 = input.LA(2);

                if ( (LA36_3==RULE_ID) ) {
                    switch ( input.LA(3) ) {
                    case 41:
                        {
                        int LA36_6 = input.LA(4);

                        if ( (LA36_6==RULE_INT) ) {
                            int LA36_9 = input.LA(5);

                            if ( (LA36_9==42) ) {
                                int LA36_10 = input.LA(6);

                                if ( ((LA36_10>=46 && LA36_10<=54)) ) {
                                    alt36=2;
                                }
                                else if ( (LA36_10==40||LA36_10==42) ) {
                                    alt36=1;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return result;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 10, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 9, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 6, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                        {
                        alt36=2;
                        }
                        break;
                    case 40:
                    case 42:
                        {
                        alt36=1;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 4, input);

                        throw nvae;
                    }

                }
                else {
                    if (backtracking>0) {failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case 41:
                    {
                    int LA36_6 = input.LA(3);

                    if ( (LA36_6==RULE_INT) ) {
                        int LA36_9 = input.LA(4);

                        if ( (LA36_9==42) ) {
                            int LA36_10 = input.LA(5);

                            if ( ((LA36_10>=46 && LA36_10<=54)) ) {
                                alt36=2;
                            }
                            else if ( (LA36_10==40||LA36_10==42) ) {
                                alt36=1;
                            }
                            else {
                                if (backtracking>0) {failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 10, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 9, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 6, input);

                        throw nvae;
                    }
                    }
                    break;
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                    {
                    alt36=2;
                    }
                    break;
                case 40:
                case 42:
                    {
                    alt36=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 4, input);

                    throw nvae;
                }

                }
                break;
            case 41:
                {
                alt36=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("1116:1: ( (temp_Signal= ruleSignal ) | ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) ) | ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) ) )", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1116:2: (temp_Signal= ruleSignal )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1116:2: (temp_Signal= ruleSignal )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1116:3: temp_Signal= ruleSignal
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(0)));
                    }
                    pushFollow(FOLLOW_ruleSignal_in_ruleTrigger1592);
                    temp_Signal=ruleSignal();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_Signal != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_Signal);
                        factory.add(result,"literals",convert(temp_Signal),false);
                        ptm.ruleFinished(temp_Signal);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }


                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1128:1: ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1128:1: ( (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal ) )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1128:2: (temp_Signal= ruleSignal ) (temp_BinaryOp= ruleBinaryOp ) (temp_Signal= ruleSignal )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1128:2: (temp_Signal= ruleSignal )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1128:3: temp_Signal= ruleSignal
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(1)).eContents().get(0)));
                    }
                    pushFollow(FOLLOW_ruleSignal_in_ruleTrigger1606);
                    temp_Signal=ruleSignal();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_Signal != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_Signal);
                        factory.add(result,"literals",convert(temp_Signal),false);
                        ptm.ruleFinished(temp_Signal);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1140:1: (temp_BinaryOp= ruleBinaryOp )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1140:2: temp_BinaryOp= ruleBinaryOp
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(1)).eContents().get(1)));
                    }
                    pushFollow(FOLLOW_ruleBinaryOp_in_ruleTrigger1617);
                    temp_BinaryOp=ruleBinaryOp();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_BinaryOp != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_BinaryOp);
                        factory.add(result,"operator",convert(temp_BinaryOp),false);
                        ptm.ruleFinished(temp_BinaryOp);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1152:1: (temp_Signal= ruleSignal )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1152:2: temp_Signal= ruleSignal
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(1)).eContents().get(2)));
                    }
                    pushFollow(FOLLOW_ruleSignal_in_ruleTrigger1628);
                    temp_Signal=ruleSignal();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_Signal != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_Signal);
                        factory.add(result,"literals",convert(temp_Signal),false);
                        ptm.ruleFinished(temp_Signal);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1165:1: ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1165:1: ( ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1165:2: ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' ) (temp_BinaryOp= ruleBinaryOp ) ( '(' ) (temp_Trigger= ruleTrigger ) ( ')' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1165:2: ( '(' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1165:3: '('
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,41,FOLLOW_41_in_ruleTrigger1641); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(2)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1171:1: (temp_Trigger= ruleTrigger )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1171:2: temp_Trigger= ruleTrigger
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(2)).eContents().get(1)));
                    }
                    pushFollow(FOLLOW_ruleTrigger_in_ruleTrigger1651);
                    temp_Trigger=ruleTrigger();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_Trigger != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_Trigger);
                        factory.add(result,"subTrigger",convert(temp_Trigger),false);
                        ptm.ruleFinished(temp_Trigger);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1183:1: ( ')' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1183:2: ')'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,42,FOLLOW_42_in_ruleTrigger1659); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(2)).eContents().get(2)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1189:1: (temp_BinaryOp= ruleBinaryOp )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1189:2: temp_BinaryOp= ruleBinaryOp
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(2)).eContents().get(3)));
                    }
                    pushFollow(FOLLOW_ruleBinaryOp_in_ruleTrigger1669);
                    temp_BinaryOp=ruleBinaryOp();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_BinaryOp != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_BinaryOp);
                        factory.add(result,"operator",convert(temp_BinaryOp),false);
                        ptm.ruleFinished(temp_BinaryOp);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1201:1: ( '(' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1201:2: '('
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,41,FOLLOW_41_in_ruleTrigger1677); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(2)).eContents().get(4)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1207:1: (temp_Trigger= ruleTrigger )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1207:2: temp_Trigger= ruleTrigger
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(2)).eContents().get(5)));
                    }
                    pushFollow(FOLLOW_ruleTrigger_in_ruleTrigger1687);
                    temp_Trigger=ruleTrigger();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_Trigger != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_Trigger);
                        factory.add(result,"subTrigger",convert(temp_Trigger),false);
                        ptm.ruleFinished(temp_Trigger);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1219:1: ( ')' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1219:2: ')'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,42,FOLLOW_42_in_ruleTrigger1695); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(19)).eContents().get(1)).eContents().get(2)).eContents().get(6)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }


                    }
                    break;

            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 21, ruleTrigger_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleTrigger


    // $ANTLR start ruleBinaryOp
    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1233:1: ruleBinaryOp returns [EObject result] : ( ( 'EQ' ) | ( 'LT' ) | ( 'LEQ' ) | ( 'AND' ) | ( 'OR' ) | ( 'ADD' ) | ( 'SUB' ) | ( 'MULT' ) | ( 'DIV' ) ) ;
    public EObject ruleBinaryOp() throws RecognitionException {
        EObject result = null;
        int ruleBinaryOp_StartIndex = input.index();
        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 22) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1236:4: ( ( ( 'EQ' ) | ( 'LT' ) | ( 'LEQ' ) | ( 'AND' ) | ( 'OR' ) | ( 'ADD' ) | ( 'SUB' ) | ( 'MULT' ) | ( 'DIV' ) ) )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1236:4: ( ( 'EQ' ) | ( 'LT' ) | ( 'LEQ' ) | ( 'AND' ) | ( 'OR' ) | ( 'ADD' ) | ( 'SUB' ) | ( 'MULT' ) | ( 'DIV' ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("", "BinaryOp");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1239:1: ( ( 'EQ' ) | ( 'LT' ) | ( 'LEQ' ) | ( 'AND' ) | ( 'OR' ) | ( 'ADD' ) | ( 'SUB' ) | ( 'MULT' ) | ( 'DIV' ) )
            int alt37=9;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt37=1;
                }
                break;
            case 47:
                {
                alt37=2;
                }
                break;
            case 48:
                {
                alt37=3;
                }
                break;
            case 49:
                {
                alt37=4;
                }
                break;
            case 50:
                {
                alt37=5;
                }
                break;
            case 51:
                {
                alt37=6;
                }
                break;
            case 52:
                {
                alt37=7;
                }
                break;
            case 53:
                {
                alt37=8;
                }
                break;
            case 54:
                {
                alt37=9;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("1239:1: ( ( 'EQ' ) | ( 'LT' ) | ( 'LEQ' ) | ( 'AND' ) | ( 'OR' ) | ( 'ADD' ) | ( 'SUB' ) | ( 'MULT' ) | ( 'DIV' ) )", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1239:2: ( 'EQ' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1239:2: ( 'EQ' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1239:3: 'EQ'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,46,FOLLOW_46_in_ruleBinaryOp1735); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1245:1: ( 'LT' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1245:1: ( 'LT' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1245:2: 'LT'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,47,FOLLOW_47_in_ruleBinaryOp1744); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(1)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 3 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1251:1: ( 'LEQ' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1251:1: ( 'LEQ' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1251:2: 'LEQ'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,48,FOLLOW_48_in_ruleBinaryOp1753); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(2)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 4 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1257:1: ( 'AND' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1257:1: ( 'AND' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1257:2: 'AND'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,49,FOLLOW_49_in_ruleBinaryOp1762); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(3)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 5 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1263:1: ( 'OR' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1263:1: ( 'OR' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1263:2: 'OR'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,50,FOLLOW_50_in_ruleBinaryOp1771); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(4)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 6 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1269:1: ( 'ADD' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1269:1: ( 'ADD' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1269:2: 'ADD'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,51,FOLLOW_51_in_ruleBinaryOp1780); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(5)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 7 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1275:1: ( 'SUB' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1275:1: ( 'SUB' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1275:2: 'SUB'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,52,FOLLOW_52_in_ruleBinaryOp1789); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(6)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 8 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1281:1: ( 'MULT' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1281:1: ( 'MULT' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1281:2: 'MULT'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,53,FOLLOW_53_in_ruleBinaryOp1798); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(7)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;
                case 9 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1287:1: ( 'DIV' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1287:1: ( 'DIV' )
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1287:2: 'DIV'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,54,FOLLOW_54_in_ruleBinaryOp1807); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(21)).eContents().get(1)).eContents().get(8)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }


                    }
                    break;

            }

            if ( backtracking==0 ) {
              if (!hasContent)
                result = null;
            }

            }

        }
        catch (RecognitionException re) {
            if (!hasContent)
                result = null;
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( backtracking>0 ) { memoize(input, 22, ruleBinaryOp_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleBinaryOp

    // $ANTLR start synpred41
    public void synpred41_fragment() throws RecognitionException {   
        // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1078:2: ( ( '(' ) ( ruleValue ) ( ')' ) )
        // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1078:2: ( '(' ) ( ruleValue ) ( ')' )
        {
        // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1078:2: ( '(' )
        // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1078:3: '('
        {
        if ( backtracking==0 ) {
          skipCurrentToken = false;
        }
        match(input,41,FOLLOW_41_in_synpred411530); if (failed) return ;

        }

        // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1084:1: ( ruleValue )
        // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1084:2: ruleValue
        {
        if ( backtracking==0 ) {
          ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(18)).eContents().get(1)).eContents().get(4)).eContents().get(1)));
        }
        pushFollow(FOLLOW_ruleValue_in_synpred411540);
        ruleValue();
        _fsp--;
        if (failed) return ;

        }

        // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1096:1: ( ')' )
        // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1096:2: ')'
        {
        if ( backtracking==0 ) {
          skipCurrentToken = false;
        }
        match(input,42,FOLLOW_42_in_synpred411548); if (failed) return ;

        }


        }
    }
    // $ANTLR end synpred41

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


 

    public static final BitSet FOLLOW_ruleStatechart_in_parse67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_ruleStatechart104 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStatechart112 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_11_in_ruleStatechart121 = new BitSet(new long[]{0x0000000000051000L});
    public static final BitSet FOLLOW_ruleChartArgument_in_ruleStatechart131 = new BitSet(new long[]{0x0000000000051000L});
    public static final BitSet FOLLOW_12_in_ruleStatechart140 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleStatechart150 = new BitSet(new long[]{0x0000000000302000L});
    public static final BitSet FOLLOW_ruleIoDeclaration_in_ruleStatechart160 = new BitSet(new long[]{0x0000000000302000L});
    public static final BitSet FOLLOW_13_in_ruleStatechart169 = new BitSet(new long[]{0x0000000180004010L});
    public static final BitSet FOLLOW_ruleElement_in_ruleStatechart179 = new BitSet(new long[]{0x0000000180004010L});
    public static final BitSet FOLLOW_14_in_ruleStatechart188 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleStatechart195 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStatechart202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleChartArgument241 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleChartArgument248 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChartArgument256 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleChartArgument264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleChartArgument276 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleChartArgument283 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChartArgument291 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleChartArgument299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_ruleIoDeclaration342 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIoDeclaration351 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_19_in_ruleIoDeclaration360 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleIoDeclaration367 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIoDeclaration375 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_19_in_ruleIoDeclaration387 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_ruleVType_in_ruleIoDeclaration397 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleIoDeclaration408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleDeclType446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleDeclType455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVType493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleVType502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleVType511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVType520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleState559 = new BitSet(new long[]{0x000000000000A800L});
    public static final BitSet FOLLOW_11_in_ruleState568 = new BitSet(new long[]{0x000000000C001000L});
    public static final BitSet FOLLOW_ruleStateArgument_in_ruleState578 = new BitSet(new long[]{0x000000000C001000L});
    public static final BitSet FOLLOW_12_in_ruleState587 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_13_in_ruleState598 = new BitSet(new long[]{0x0000000180004010L});
    public static final BitSet FOLLOW_ruleElement_in_ruleState608 = new BitSet(new long[]{0x0000000180004010L});
    public static final BitSet FOLLOW_14_in_ruleState617 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleState627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleStateArgument666 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleStateArgument673 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStateArgument681 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleStateArgument689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleStateArgument702 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleStateArgument709 = new BitSet(new long[]{0x0000000070000000L});
    public static final BitSet FOLLOW_rulePseudo_in_ruleStateArgument719 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleStateArgument727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rulePseudo768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rulePseudo777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rulePseudo786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_ruleElement827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleElement841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleElement852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition891 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleTransition900 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition908 = new BitSet(new long[]{0x0000000000008800L});
    public static final BitSet FOLLOW_11_in_ruleTransition917 = new BitSet(new long[]{0x000000020C001000L});
    public static final BitSet FOLLOW_ruleTransArgument_in_ruleTransition927 = new BitSet(new long[]{0x000000020C001000L});
    public static final BitSet FOLLOW_12_in_ruleTransition936 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTransition946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleTransArgument985 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTransArgument992 = new BitSet(new long[]{0x00003A0000000010L});
    public static final BitSet FOLLOW_ruleAction_in_ruleTransArgument1002 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleTransArgument1010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTransArgument1023 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTransArgument1030 = new BitSet(new long[]{0x000000FC00000000L});
    public static final BitSet FOLLOW_ruleTransType_in_ruleTransArgument1040 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleTransArgument1048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleTransArgument1061 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTransArgument1068 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTransArgument1076 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleTransArgument1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleweakabortion_in_ruleTransType1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulestrongabortion_in_ruleTransType1137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulenormaltermination_in_ruleTransType1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleweakabortion1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleweakabortion1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rulestrongabortion1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rulestrongabortion1236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rulenormaltermination1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rulenormaltermination1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleAction1324 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleAction1332 = new BitSet(new long[]{0x0000380000000012L});
    public static final BitSet FOLLOW_ruleEmission_in_ruleAction1342 = new BitSet(new long[]{0x0000380000000012L});
    public static final BitSet FOLLOW_ruleSignal_in_ruleEmission1385 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleEmission1394 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValue_in_ruleEmission1404 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleEmission1412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleValue1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleSignal1491 = new BitSet(new long[]{0x0000300000000010L});
    public static final BitSet FOLLOW_44_in_ruleSignal1501 = new BitSet(new long[]{0x0000200000000010L});
    public static final BitSet FOLLOW_45_in_ruleSignal1511 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSignal1521 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleSignal1530 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValue_in_ruleSignal1540 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleSignal1548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_ruleTrigger1592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_ruleTrigger1606 = new BitSet(new long[]{0x007FC00000000000L});
    public static final BitSet FOLLOW_ruleBinaryOp_in_ruleTrigger1617 = new BitSet(new long[]{0x0000380000000010L});
    public static final BitSet FOLLOW_ruleSignal_in_ruleTrigger1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleTrigger1641 = new BitSet(new long[]{0x00003A0000000010L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTrigger1651 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleTrigger1659 = new BitSet(new long[]{0x007FC00000000000L});
    public static final BitSet FOLLOW_ruleBinaryOp_in_ruleTrigger1669 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleTrigger1677 = new BitSet(new long[]{0x00003A0000000010L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTrigger1687 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleTrigger1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleBinaryOp1735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleBinaryOp1744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleBinaryOp1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleBinaryOp1762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleBinaryOp1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleBinaryOp1780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleBinaryOp1789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleBinaryOp1798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleBinaryOp1807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred411530 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValue_in_synpred411540 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_synpred411548 = new BitSet(new long[]{0x0000000000000002L});

}