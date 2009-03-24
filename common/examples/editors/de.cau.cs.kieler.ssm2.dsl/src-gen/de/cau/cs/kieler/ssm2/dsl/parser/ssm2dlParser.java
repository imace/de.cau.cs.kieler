// $ANTLR 3.0 ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g 2009-03-20 12:41:36

package de.cau.cs.kieler.ssm2.dsl.parser;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;

import org.openarchitectureware.xtext.parser.impl.AntlrUtil;
import org.openarchitectureware.xtext.XtextFile;
import org.openarchitectureware.xtext.parser.impl.EcoreModelFactory;
import org.openarchitectureware.xtext.parser.ErrorMsg;
import org.openarchitectureware.xtext.parser.model.ParseTreeManagerNeu;
import org.openarchitectureware.xtext.parser.parsetree.Node;

import de.cau.cs.kieler.ssm2.dsl.MetaModelRegistration;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class ssm2dlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "'/'", "'('", "')'", "'='", "'not'", "'<'", "'<='", "'and'", "'or'", "'+'", "'-'", "'*'", "'?'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_INT=5;
    public static final int RULE_WS=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;

        public ssm2dlParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[28+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g"; }



    	private Token getLastToken() {
    		return input.LT(-1);
    	}

    	protected Object convert(Object arg) {
    		if (arg instanceof org.antlr.runtime.Token) {
    			Token t = (Token) arg;
    			String s = t.getText();
    			if (t.getType() == ssm2dlLexer.RULE_ID && s.startsWith("^")) {
    				return s.substring(1);
    			} else if (t.getType()==ssm2dlLexer.RULE_STRING) {
    				return s.substring(1,s.length()-1);
    			} else if (t.getType()==ssm2dlLexer.RULE_INT) {
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
    			factory.addImport("ssm2", "http://www.informatik.uni-kiel.de/rtsys/ssm2");
    		
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
    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:102:1: parse returns [Node r] : result= ruleAction EOF ;
    public Node parse() throws RecognitionException {
        Node r = null;
        int parse_StartIndex = input.index();
        EObject result = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 1) ) { return r; }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:103:3: (result= ruleAction EOF )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:103:3: result= ruleAction EOF
            {
            pushFollow(FOLLOW_ruleAction_in_parse67);
            result=ruleAction();
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


    // $ANTLR start ruleAction
    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:113:1: ruleAction returns [EObject result] : ( (temp_Expression= ruleExpression )? ( '/' ) ( (temp_Emission= ruleEmission ) | (temp_Assignment= ruleAssignment ) )* ) ;
    public EObject ruleAction() throws RecognitionException {
        EObject result = null;
        int ruleAction_StartIndex = input.index();
        EObject temp_Expression = null;

        EObject temp_Emission = null;

        EObject temp_Assignment = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:116:4: ( ( (temp_Expression= ruleExpression )? ( '/' ) ( (temp_Emission= ruleEmission ) | (temp_Assignment= ruleAssignment ) )* ) )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:116:4: ( (temp_Expression= ruleExpression )? ( '/' ) ( (temp_Emission= ruleEmission ) | (temp_Assignment= ruleAssignment ) )* )
            {
            if ( backtracking==0 ) {

              				result = factory.create("ssm2", "Action");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:119:1: ( (temp_Expression= ruleExpression )? ( '/' ) ( (temp_Emission= ruleEmission ) | (temp_Assignment= ruleAssignment ) )* )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:119:2: (temp_Expression= ruleExpression )? ( '/' ) ( (temp_Emission= ruleEmission ) | (temp_Assignment= ruleAssignment ) )*
            {
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:119:2: (temp_Expression= ruleExpression )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_INT)||LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:119:3: temp_Expression= ruleExpression
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(0)));
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleAction107);
                    temp_Expression=ruleExpression();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_Expression != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_Expression);
                        factory.set(result,"trigger",convert(temp_Expression),false);
                        ptm.ruleFinished(temp_Expression);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }
                    break;

            }

            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:131:1: ( '/' )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:131:2: '/'
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,10,FOLLOW_10_in_ruleAction116); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(1)));
                ptm.ruleFinished(getLastToken());
              }
            }

            }

            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:137:1: ( (temp_Emission= ruleEmission ) | (temp_Assignment= ruleAssignment ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    int LA2_2 = input.LA(2);

                    if ( (LA2_2==EOF||(LA2_2>=RULE_ID && LA2_2<=RULE_INT)||LA2_2==11) ) {
                        alt2=1;
                    }
                    else if ( (LA2_2==13) ) {
                        alt2=2;
                    }


                }
                else if ( (LA2_0==RULE_INT) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:137:2: (temp_Emission= ruleEmission )
            	    {
            	    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:137:2: (temp_Emission= ruleEmission )
            	    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:137:3: temp_Emission= ruleEmission
            	    {
            	    if ( backtracking==0 ) {
            	      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(2)).eContents().get(0)));
            	    }
            	    pushFollow(FOLLOW_ruleEmission_in_ruleAction127);
            	    temp_Emission=ruleEmission();
            	    _fsp--;
            	    if (failed) return result;
            	    if ( backtracking==0 ) {
            	      if (temp_Emission != null) {
            	        hasContent = true;
            	        ptm.setModelElement(temp_Emission);
            	        factory.add(result,"emissions",convert(temp_Emission),false);
            	        ptm.ruleFinished(temp_Emission);
            	      } else {
            	        ptm.destroyNode();
            	      }

            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:149:1: (temp_Assignment= ruleAssignment )
            	    {
            	    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:149:1: (temp_Assignment= ruleAssignment )
            	    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:149:2: temp_Assignment= ruleAssignment
            	    {
            	    if ( backtracking==0 ) {
            	      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(1)).eContents().get(1)).eContents().get(2)).eContents().get(1)));
            	    }
            	    pushFollow(FOLLOW_ruleAssignment_in_ruleAction140);
            	    temp_Assignment=ruleAssignment();
            	    _fsp--;
            	    if (failed) return result;
            	    if ( backtracking==0 ) {
            	      if (temp_Assignment != null) {
            	        hasContent = true;
            	        ptm.setModelElement(temp_Assignment);
            	        factory.add(result,"assignments",convert(temp_Assignment),false);
            	        ptm.ruleFinished(temp_Assignment);
            	      } else {
            	        ptm.destroyNode();
            	      }

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
            if ( backtracking>0 ) { memoize(input, 2, ruleAction_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleAction


    // $ANTLR start ruleExpression
    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:169:1: ruleExpression returns [EObject result] : (temp_signal= ruleSignal | temp_variable= ruleVariable | temp_complexexpression= ruleComplexExpression );
    public EObject ruleExpression() throws RecognitionException {
        EObject result = null;
        int ruleExpression_StartIndex = input.index();
        EObject temp_signal = null;

        EObject temp_variable = null;

        EObject temp_complexexpression = null;


        try {
            if ( backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:171:9: (temp_signal= ruleSignal | temp_variable= ruleVariable | temp_complexexpression= ruleComplexExpression )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA3_1 = input.LA(2);

                if ( (synpred4()) ) {
                    alt3=1;
                }
                else if ( (synpred5()) ) {
                    alt3=2;
                }
                else {
                    if (backtracking>0) {failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("169:1: ruleExpression returns [EObject result] : (temp_signal= ruleSignal | temp_variable= ruleVariable | temp_complexexpression= ruleComplexExpression );", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt3=2;
                }
                break;
            case 11:
                {
                alt3=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("169:1: ruleExpression returns [EObject result] : (temp_signal= ruleSignal | temp_variable= ruleVariable | temp_complexexpression= ruleComplexExpression );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:171:9: temp_signal= ruleSignal
                    {
                    pushFollow(FOLLOW_ruleSignal_in_ruleExpression179);
                    temp_signal=ruleSignal();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      result =temp_signal;
                    }

                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:171:64: temp_variable= ruleVariable
                    {
                    pushFollow(FOLLOW_ruleVariable_in_ruleExpression194);
                    temp_variable=ruleVariable();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      result =temp_variable;
                    }

                    }
                    break;
                case 3 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:171:125: temp_complexexpression= ruleComplexExpression
                    {
                    pushFollow(FOLLOW_ruleComplexExpression_in_ruleExpression209);
                    temp_complexexpression=ruleComplexExpression();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      result =temp_complexexpression;
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
            if ( backtracking>0 ) { memoize(input, 3, ruleExpression_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleExpression


    // $ANTLR start ruleComplexExpression
    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:173:1: ruleComplexExpression returns [EObject result] : ( ( '(' ) (temp_Expression= ruleExpression )? (temp_Operator= ruleOperator ) (temp_Expression= ruleExpression ) ( ')' ) ) ;
    public EObject ruleComplexExpression() throws RecognitionException {
        EObject result = null;
        int ruleComplexExpression_StartIndex = input.index();
        EObject temp_Expression = null;

        EObject temp_Operator = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:176:4: ( ( ( '(' ) (temp_Expression= ruleExpression )? (temp_Operator= ruleOperator ) (temp_Expression= ruleExpression ) ( ')' ) ) )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:176:4: ( ( '(' ) (temp_Expression= ruleExpression )? (temp_Operator= ruleOperator ) (temp_Expression= ruleExpression ) ( ')' ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("ssm2", "ComplexExpression");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:179:1: ( ( '(' ) (temp_Expression= ruleExpression )? (temp_Operator= ruleOperator ) (temp_Expression= ruleExpression ) ( ')' ) )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:179:2: ( '(' ) (temp_Expression= ruleExpression )? (temp_Operator= ruleOperator ) (temp_Expression= ruleExpression ) ( ')' )
            {
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:179:2: ( '(' )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:179:3: '('
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,11,FOLLOW_11_in_ruleComplexExpression237); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(3)).eContents().get(1)).eContents().get(0)));
                ptm.ruleFinished(getLastToken());
              }
            }

            }

            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:185:1: (temp_Expression= ruleExpression )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_INT)||LA4_0==11) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:185:2: temp_Expression= ruleExpression
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(3)).eContents().get(1)).eContents().get(1)));
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleComplexExpression247);
                    temp_Expression=ruleExpression();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_Expression != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_Expression);
                        factory.add(result,"subExpressions",convert(temp_Expression),false);
                        ptm.ruleFinished(temp_Expression);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }
                    break;

            }

            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:197:1: (temp_Operator= ruleOperator )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:197:2: temp_Operator= ruleOperator
            {
            if ( backtracking==0 ) {
              ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(3)).eContents().get(1)).eContents().get(2)));
            }
            pushFollow(FOLLOW_ruleOperator_in_ruleComplexExpression259);
            temp_Operator=ruleOperator();
            _fsp--;
            if (failed) return result;
            if ( backtracking==0 ) {
              if (temp_Operator != null) {
                hasContent = true;
                ptm.setModelElement(temp_Operator);
                factory.set(result,"operator",convert(temp_Operator),false);
                ptm.ruleFinished(temp_Operator);
              } else {
                ptm.destroyNode();
              }

            }

            }

            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:209:1: (temp_Expression= ruleExpression )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:209:2: temp_Expression= ruleExpression
            {
            if ( backtracking==0 ) {
              ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(3)).eContents().get(1)).eContents().get(3)));
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleComplexExpression270);
            temp_Expression=ruleExpression();
            _fsp--;
            if (failed) return result;
            if ( backtracking==0 ) {
              if (temp_Expression != null) {
                hasContent = true;
                ptm.setModelElement(temp_Expression);
                factory.add(result,"subExpressions",convert(temp_Expression),false);
                ptm.ruleFinished(temp_Expression);
              } else {
                ptm.destroyNode();
              }

            }

            }

            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:221:1: ( ')' )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:221:2: ')'
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,12,FOLLOW_12_in_ruleComplexExpression278); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(3)).eContents().get(1)).eContents().get(4)));
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
            if ( backtracking>0 ) { memoize(input, 4, ruleComplexExpression_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleComplexExpression


    // $ANTLR start ruleEmission
    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:234:1: ruleEmission returns [EObject result] : ( (temp_Signal= ruleSignal ) ( ( '(' ) (temp_Expression= ruleExpression ) ( ')' ) )? ) ;
    public EObject ruleEmission() throws RecognitionException {
        EObject result = null;
        int ruleEmission_StartIndex = input.index();
        EObject temp_Signal = null;

        EObject temp_Expression = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:237:4: ( ( (temp_Signal= ruleSignal ) ( ( '(' ) (temp_Expression= ruleExpression ) ( ')' ) )? ) )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:237:4: ( (temp_Signal= ruleSignal ) ( ( '(' ) (temp_Expression= ruleExpression ) ( ')' ) )? )
            {
            if ( backtracking==0 ) {

              				result = factory.create("ssm2", "Emission");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:240:1: ( (temp_Signal= ruleSignal ) ( ( '(' ) (temp_Expression= ruleExpression ) ( ')' ) )? )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:240:2: (temp_Signal= ruleSignal ) ( ( '(' ) (temp_Expression= ruleExpression ) ( ')' ) )?
            {
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:240:2: (temp_Signal= ruleSignal )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:240:3: temp_Signal= ruleSignal
            {
            if ( backtracking==0 ) {
              ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(4)).eContents().get(1)).eContents().get(0)));
            }
            pushFollow(FOLLOW_ruleSignal_in_ruleEmission319);
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

            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:252:1: ( ( '(' ) (temp_Expression= ruleExpression ) ( ')' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:252:2: ( '(' ) (temp_Expression= ruleExpression ) ( ')' )
                    {
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:252:2: ( '(' )
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:252:3: '('
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,11,FOLLOW_11_in_ruleEmission328); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(4)).eContents().get(1)).eContents().get(1)).eContents().get(0)));
                        ptm.ruleFinished(getLastToken());
                      }
                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:258:1: (temp_Expression= ruleExpression )
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:258:2: temp_Expression= ruleExpression
                    {
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(4)).eContents().get(1)).eContents().get(1)).eContents().get(1)));
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleEmission338);
                    temp_Expression=ruleExpression();
                    _fsp--;
                    if (failed) return result;
                    if ( backtracking==0 ) {
                      if (temp_Expression != null) {
                        hasContent = true;
                        ptm.setModelElement(temp_Expression);
                        factory.set(result,"newValue",convert(temp_Expression),false);
                        ptm.ruleFinished(temp_Expression);
                      } else {
                        ptm.destroyNode();
                      }

                    }

                    }

                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:270:1: ( ')' )
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:270:2: ')'
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,12,FOLLOW_12_in_ruleEmission346); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        ptm.createNode(((EObject)((EObject)((EObject)((EObject)xtextfile.eContents().get(4)).eContents().get(1)).eContents().get(1)).eContents().get(2)));
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
            if ( backtracking>0 ) { memoize(input, 5, ruleEmission_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleEmission


    // $ANTLR start ruleAssignment
    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:284:1: ruleAssignment returns [EObject result] : ( (temp_Variable= ruleVariable ) ( '=' ) (temp_Expression= ruleExpression ) ) ;
    public EObject ruleAssignment() throws RecognitionException {
        EObject result = null;
        int ruleAssignment_StartIndex = input.index();
        EObject temp_Variable = null;

        EObject temp_Expression = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:287:4: ( ( (temp_Variable= ruleVariable ) ( '=' ) (temp_Expression= ruleExpression ) ) )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:287:4: ( (temp_Variable= ruleVariable ) ( '=' ) (temp_Expression= ruleExpression ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("ssm2", "Assignment");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:290:1: ( (temp_Variable= ruleVariable ) ( '=' ) (temp_Expression= ruleExpression ) )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:290:2: (temp_Variable= ruleVariable ) ( '=' ) (temp_Expression= ruleExpression )
            {
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:290:2: (temp_Variable= ruleVariable )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:290:3: temp_Variable= ruleVariable
            {
            if ( backtracking==0 ) {
              ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(0)));
            }
            pushFollow(FOLLOW_ruleVariable_in_ruleAssignment390);
            temp_Variable=ruleVariable();
            _fsp--;
            if (failed) return result;
            if ( backtracking==0 ) {
              if (temp_Variable != null) {
                hasContent = true;
                ptm.setModelElement(temp_Variable);
                factory.set(result,"variable",convert(temp_Variable),false);
                ptm.ruleFinished(temp_Variable);
              } else {
                ptm.destroyNode();
              }

            }

            }

            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:302:1: ( '=' )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:302:2: '='
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,13,FOLLOW_13_in_ruleAssignment398); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(1)));
                ptm.ruleFinished(getLastToken());
              }
            }

            }

            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:308:1: (temp_Expression= ruleExpression )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:308:2: temp_Expression= ruleExpression
            {
            if ( backtracking==0 ) {
              ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(5)).eContents().get(1)).eContents().get(2)));
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleAssignment408);
            temp_Expression=ruleExpression();
            _fsp--;
            if (failed) return result;
            if ( backtracking==0 ) {
              if (temp_Expression != null) {
                hasContent = true;
                ptm.setModelElement(temp_Expression);
                factory.set(result,"expression",convert(temp_Expression),false);
                ptm.ruleFinished(temp_Expression);
              } else {
                ptm.destroyNode();
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
            if ( backtracking>0 ) { memoize(input, 6, ruleAssignment_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleAssignment


    // $ANTLR start ruleSignal
    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:327:1: ruleSignal returns [EObject result] : ( RULE_ID ) ;
    public EObject ruleSignal() throws RecognitionException {
        EObject result = null;
        int ruleSignal_StartIndex = input.index();
        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:330:4: ( ( RULE_ID ) )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:330:4: ( RULE_ID )
            {
            if ( backtracking==0 ) {

              				result = factory.create("ssm2", "Signal");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:333:1: ( RULE_ID )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:333:2: RULE_ID
            {
            if ( backtracking==0 ) {
              skipCurrentToken = false;
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSignal447); if (failed) return result;
            if ( backtracking==0 ) {
              if (!skipCurrentToken) {
                hasContent = true;
                Token temp = getLastToken();
                ptm.createNode(((EObject)((EObject)xtextfile.eContents().get(6)).eContents().get(1)));
                factory.set(result,"name",convert(temp),false);
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
            if ( backtracking>0 ) { memoize(input, 7, ruleSignal_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleSignal


    // $ANTLR start ruleVariable
    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:349:1: ruleVariable returns [EObject result] : ( ( RULE_ID ) | ( RULE_INT ) ) ;
    public EObject ruleVariable() throws RecognitionException {
        EObject result = null;
        int ruleVariable_StartIndex = input.index();
        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:352:4: ( ( ( RULE_ID ) | ( RULE_INT ) ) )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:352:4: ( ( RULE_ID ) | ( RULE_INT ) )
            {
            if ( backtracking==0 ) {

              				result = factory.create("ssm2", "Variable");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:355:1: ( ( RULE_ID ) | ( RULE_INT ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_INT) ) {
                alt6=2;
            }
            else {
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("355:1: ( ( RULE_ID ) | ( RULE_INT ) )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:355:2: ( RULE_ID )
                    {
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:355:2: ( RULE_ID )
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:355:3: RULE_ID
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariable485); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        Token temp = getLastToken();
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(7)).eContents().get(1)).eContents().get(0)));
                        factory.set(result,"vname",convert(temp),false);
                        ptm.ruleFinished(temp);
                      }
                    }

                    }


                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:365:1: ( RULE_INT )
                    {
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:365:1: ( RULE_INT )
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:365:2: RULE_INT
                    {
                    if ( backtracking==0 ) {
                      skipCurrentToken = false;
                    }
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleVariable496); if (failed) return result;
                    if ( backtracking==0 ) {
                      if (!skipCurrentToken) {
                        hasContent = true;
                        Token temp = getLastToken();
                        ptm.createNode(((EObject)((EObject)((EObject)xtextfile.eContents().get(7)).eContents().get(1)).eContents().get(1)));
                        factory.set(result,"value",convert(temp),false);
                        ptm.ruleFinished(temp);
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
            if ( backtracking>0 ) { memoize(input, 8, ruleVariable_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleVariable


    // $ANTLR start ruleOperator
    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:382:1: ruleOperator returns [EObject result] : (temp_OperatorKind= ruleOperatorKind ) ;
    public EObject ruleOperator() throws RecognitionException {
        EObject result = null;
        int ruleOperator_StartIndex = input.index();
        Enumerator temp_OperatorKind = null;


        boolean hasContent = false;
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:385:4: ( (temp_OperatorKind= ruleOperatorKind ) )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:385:4: (temp_OperatorKind= ruleOperatorKind )
            {
            if ( backtracking==0 ) {

              				result = factory.create("ssm2", "Operator");
              			 
            }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:388:1: (temp_OperatorKind= ruleOperatorKind )
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:388:2: temp_OperatorKind= ruleOperatorKind
            {
            if ( backtracking==0 ) {
              ptm.createNode(((EObject)((EObject)xtextfile.eContents().get(8)).eContents().get(1)));
            }
            pushFollow(FOLLOW_ruleOperatorKind_in_ruleOperator537);
            temp_OperatorKind=ruleOperatorKind();
            _fsp--;
            if (failed) return result;
            if ( backtracking==0 ) {
              if (temp_OperatorKind != null) {
                hasContent = true;
                factory.set(result,"operatorKind",convert(temp_OperatorKind),false);
                ptm.ruleFinished(temp_OperatorKind);
              } else {
                ptm.destroyNode();
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
            if ( backtracking>0 ) { memoize(input, 9, ruleOperator_StartIndex); }
        }
        return result;
    }
    // $ANTLR end ruleOperator


    // $ANTLR start ruleOperatorKind
    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:405:1: ruleOperatorKind returns [Enumerator r] : ( 'not' | '=' | '<' | '<=' | 'and' | 'or' | '+' | '-' | '*' | '/' | '?' );
    public Enumerator ruleOperatorKind() throws RecognitionException {
        Enumerator r = null;
        int ruleOperatorKind_StartIndex = input.index();
        try {
            if ( backtracking>0 && alreadyParsedRule(input, 10) ) { return r; }
            // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:406:4: ( 'not' | '=' | '<' | '<=' | 'and' | 'or' | '+' | '-' | '*' | '/' | '?' )
            int alt7=11;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt7=1;
                }
                break;
            case 13:
                {
                alt7=2;
                }
                break;
            case 15:
                {
                alt7=3;
                }
                break;
            case 16:
                {
                alt7=4;
                }
                break;
            case 17:
                {
                alt7=5;
                }
                break;
            case 18:
                {
                alt7=6;
                }
                break;
            case 19:
                {
                alt7=7;
                }
                break;
            case 20:
                {
                alt7=8;
                }
                break;
            case 21:
                {
                alt7=9;
                }
                break;
            case 10:
                {
                alt7=10;
                }
                break;
            case 22:
                {
                alt7=11;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("405:1: ruleOperatorKind returns [Enumerator r] : ( 'not' | '=' | '<' | '<=' | 'and' | 'or' | '+' | '-' | '*' | '/' | '?' );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:406:4: 'not'
                    {
                    match(input,14,FOLLOW_14_in_ruleOperatorKind564); if (failed) return r;
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(1)));
                      r =factory.enumLit("ssm2", "OperatorKind","NOT");
                      ptm.setModelElement(r);
                      ptm.ruleFinished(getLastToken());

                    }

                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:412:7: '='
                    {
                    match(input,13,FOLLOW_13_in_ruleOperatorKind577); if (failed) return r;
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(2)));
                      r =factory.enumLit("ssm2", "OperatorKind","EQ");
                      ptm.setModelElement(r);
                      ptm.ruleFinished(getLastToken());

                    }

                    }
                    break;
                case 3 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:418:7: '<'
                    {
                    match(input,15,FOLLOW_15_in_ruleOperatorKind590); if (failed) return r;
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(3)));
                      r =factory.enumLit("ssm2", "OperatorKind","LT");
                      ptm.setModelElement(r);
                      ptm.ruleFinished(getLastToken());

                    }

                    }
                    break;
                case 4 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:424:7: '<='
                    {
                    match(input,16,FOLLOW_16_in_ruleOperatorKind603); if (failed) return r;
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(4)));
                      r =factory.enumLit("ssm2", "OperatorKind","LEQ");
                      ptm.setModelElement(r);
                      ptm.ruleFinished(getLastToken());

                    }

                    }
                    break;
                case 5 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:430:7: 'and'
                    {
                    match(input,17,FOLLOW_17_in_ruleOperatorKind616); if (failed) return r;
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(5)));
                      r =factory.enumLit("ssm2", "OperatorKind","AND");
                      ptm.setModelElement(r);
                      ptm.ruleFinished(getLastToken());

                    }

                    }
                    break;
                case 6 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:436:7: 'or'
                    {
                    match(input,18,FOLLOW_18_in_ruleOperatorKind629); if (failed) return r;
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(6)));
                      r =factory.enumLit("ssm2", "OperatorKind","OR");
                      ptm.setModelElement(r);
                      ptm.ruleFinished(getLastToken());

                    }

                    }
                    break;
                case 7 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:442:7: '+'
                    {
                    match(input,19,FOLLOW_19_in_ruleOperatorKind642); if (failed) return r;
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(7)));
                      r =factory.enumLit("ssm2", "OperatorKind","ADD");
                      ptm.setModelElement(r);
                      ptm.ruleFinished(getLastToken());

                    }

                    }
                    break;
                case 8 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:448:7: '-'
                    {
                    match(input,20,FOLLOW_20_in_ruleOperatorKind655); if (failed) return r;
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(8)));
                      r =factory.enumLit("ssm2", "OperatorKind","SUB");
                      ptm.setModelElement(r);
                      ptm.ruleFinished(getLastToken());

                    }

                    }
                    break;
                case 9 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:454:7: '*'
                    {
                    match(input,21,FOLLOW_21_in_ruleOperatorKind668); if (failed) return r;
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(9)));
                      r =factory.enumLit("ssm2", "OperatorKind","MULT");
                      ptm.setModelElement(r);
                      ptm.ruleFinished(getLastToken());

                    }

                    }
                    break;
                case 10 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:460:7: '/'
                    {
                    match(input,10,FOLLOW_10_in_ruleOperatorKind681); if (failed) return r;
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(10)));
                      r =factory.enumLit("ssm2", "OperatorKind","DIV");
                      ptm.setModelElement(r);
                      ptm.ruleFinished(getLastToken());

                    }

                    }
                    break;
                case 11 :
                    // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:466:7: '?'
                    {
                    match(input,22,FOLLOW_22_in_ruleOperatorKind694); if (failed) return r;
                    if ( backtracking==0 ) {
                      ptm.createNode(((EObject)((EObject)xtextfile.eContents().get(9)).eContents().get(11)));
                      r =factory.enumLit("ssm2", "OperatorKind","VAL");
                      ptm.setModelElement(r);
                      ptm.ruleFinished(getLastToken());

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
            if ( backtracking>0 ) { memoize(input, 10, ruleOperatorKind_StartIndex); }
        }
        return r;
    }
    // $ANTLR end ruleOperatorKind

    // $ANTLR start synpred4
    public void synpred4_fragment() throws RecognitionException {   
        // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:171:9: ( ruleSignal )
        // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:171:9: ruleSignal
        {
        pushFollow(FOLLOW_ruleSignal_in_synpred4179);
        ruleSignal();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred4

    // $ANTLR start synpred5
    public void synpred5_fragment() throws RecognitionException {   
        // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:171:64: ( ruleVariable )
        // ..//de.cau.cs.kieler.ssm2.dsl/src-gen/de/cau/cs/kieler/ssm2/dsl/parser/ssm2dl.g:171:64: ruleVariable
        {
        pushFollow(FOLLOW_ruleVariable_in_synpred5194);
        ruleVariable();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred5

    public final boolean synpred5() {
        backtracking++;
        int start = input.mark();
        try {
            synpred5_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred4() {
        backtracking++;
        int start = input.mark();
        try {
            synpred4_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleAction_in_parse67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAction107 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleAction116 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleEmission_in_ruleAction127 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAction140 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleSignal_in_ruleExpression179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleExpression194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexExpression_in_ruleExpression209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleComplexExpression237 = new BitSet(new long[]{0x00000000007FEC30L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleComplexExpression247 = new BitSet(new long[]{0x00000000007FE400L});
    public static final BitSet FOLLOW_ruleOperator_in_ruleComplexExpression259 = new BitSet(new long[]{0x0000000000000830L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleComplexExpression270 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleComplexExpression278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_ruleEmission319 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_ruleEmission328 = new BitSet(new long[]{0x0000000000000830L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleEmission338 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleEmission346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleAssignment390 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleAssignment398 = new BitSet(new long[]{0x0000000000000830L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssignment408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSignal447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariable485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleVariable496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperatorKind_in_ruleOperator537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleOperatorKind564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleOperatorKind577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleOperatorKind590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleOperatorKind603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleOperatorKind616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleOperatorKind629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleOperatorKind642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleOperatorKind655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOperatorKind668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_ruleOperatorKind681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOperatorKind694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_synpred4179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_synpred5194 = new BitSet(new long[]{0x0000000000000002L});

}