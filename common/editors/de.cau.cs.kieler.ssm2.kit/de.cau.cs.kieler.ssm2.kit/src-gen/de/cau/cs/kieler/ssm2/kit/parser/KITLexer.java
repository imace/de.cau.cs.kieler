// $ANTLR 3.0 ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g 2009-02-28 15:56:20

package de.cau.cs.kieler.ssm2.kit.parser;

import org.openarchitectureware.xtext.parser.ErrorMsg;
import org.openarchitectureware.xtext.parser.impl.AntlrUtil;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class KITLexer extends Lexer {
    public static final int T14=14;
    public static final int T29=29;
    public static final int T36=36;
    public static final int RULE_STRING=6;
    public static final int T35=35;
    public static final int T45=45;
    public static final int T20=20;
    public static final int T34=34;
    public static final int T25=25;
    public static final int T18=18;
    public static final int T37=37;
    public static final int T26=26;
    public static final int RULE_INT=5;
    public static final int T32=32;
    public static final int T17=17;
    public static final int T51=51;
    public static final int T46=46;
    public static final int T16=16;
    public static final int T38=38;
    public static final int T41=41;
    public static final int T24=24;
    public static final int T19=19;
    public static final int T39=39;
    public static final int T21=21;
    public static final int T44=44;
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int T33=33;
    public static final int T11=11;
    public static final int T22=22;
    public static final int T50=50;
    public static final int T43=43;
    public static final int T12=12;
    public static final int T23=23;
    public static final int T28=28;
    public static final int T42=42;
    public static final int T40=40;
    public static final int T13=13;
    public static final int T10=10;
    public static final int RULE_WS=7;
    public static final int T48=48;
    public static final int T15=15;
    public static final int T54=54;
    public static final int EOF=-1;
    public static final int T47=47;
    public static final int Tokens=55;
    public static final int T53=53;
    public static final int T31=31;
    public static final int T49=49;
    public static final int RULE_SL_COMMENT=9;
    public static final int T27=27;
    public static final int T52=52;
    public static final int T30=30;

    	 private List<ErrorMsg> errors = new ArrayList<ErrorMsg>();
    	public List<ErrorMsg> getErrors() {
    		return errors;
    	}

    	public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    		String msg = super.getErrorMessage(e,tokenNames);
    		errors.add(AntlrUtil.create(msg,e,tokenNames));
    		return msg;
    	}

    public KITLexer() {;} 
    public KITLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g"; }

    // $ANTLR start T10
    public void mT10() throws RecognitionException {
        try {
            int _type = T10;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:22:7: ( 'statechart' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:22:7: 'statechart'
            {
            match("statechart"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T10

    // $ANTLR start T11
    public void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:23:7: ( '[' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:23:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:24:7: ( ']' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:24:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:25:7: ( '{' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:25:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:26:7: ( '}' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:26:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:27:7: ( ';' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:27:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:28:7: ( 'model' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:28:7: 'model'
            {
            match("model"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:29:7: ( '=' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:29:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:30:7: ( 'version' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:30:7: 'version'
            {
            match("version"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:31:7: ( ':' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:31:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:32:7: ( 'input' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:32:7: 'input'
            {
            match("input"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:33:7: ( 'output' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:33:7: 'output'
            {
            match("output"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:34:7: ( 'boolean' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:34:7: 'boolean'
            {
            match("boolean"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:35:7: ( 'double' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:35:7: 'double'
            {
            match("double"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:36:7: ( 'float' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:36:7: 'float'
            {
            match("float"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:37:7: ( 'integer' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:37:7: 'integer'
            {
            match("integer"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:38:7: ( 'label' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:38:7: 'label'
            {
            match("label"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:39:7: ( 'type' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:39:7: 'type'
            {
            match("type"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:40:7: ( 'final' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:40:7: 'final'
            {
            match("final"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:41:7: ( 'initial' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:41:7: 'initial'
            {
            match("initial"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:42:7: ( 'pseudo' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:42:7: 'pseudo'
            {
            match("pseudo"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:43:7: ( '||' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:43:7: '||'
            {
            match("||"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:44:7: ( '->' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:44:7: '->'
            {
            match("->"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:45:7: ( 'priority' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:45:7: 'priority'
            {
            match("priority"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:46:7: ( 'weakAbortion' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:46:7: 'weakAbortion'
            {
            match("weakAbortion"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:47:7: ( 'wa' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:47:7: 'wa'
            {
            match("wa"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:48:7: ( 'strongAbortion' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:48:7: 'strongAbortion'
            {
            match("strongAbortion"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:49:7: ( 'sa' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:49:7: 'sa'
            {
            match("sa"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start T38
    public void mT38() throws RecognitionException {
        try {
            int _type = T38;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:50:7: ( 'normalTermination' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:50:7: 'normalTermination'
            {
            match("normalTermination"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start T39
    public void mT39() throws RecognitionException {
        try {
            int _type = T39;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:51:7: ( 'nt' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:51:7: 'nt'
            {
            match("nt"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T39

    // $ANTLR start T40
    public void mT40() throws RecognitionException {
        try {
            int _type = T40;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:52:7: ( '/' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:52:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start T41
    public void mT41() throws RecognitionException {
        try {
            int _type = T41;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:53:7: ( '(' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:53:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T41

    // $ANTLR start T42
    public void mT42() throws RecognitionException {
        try {
            int _type = T42;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:54:7: ( ')' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:54:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start T43
    public void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:55:7: ( 'I' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:55:7: 'I'
            {
            match('I'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T43

    // $ANTLR start T44
    public void mT44() throws RecognitionException {
        try {
            int _type = T44;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:56:7: ( 'O' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:56:7: 'O'
            {
            match('O'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T44

    // $ANTLR start T45
    public void mT45() throws RecognitionException {
        try {
            int _type = T45;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:57:7: ( 'L' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:57:7: 'L'
            {
            match('L'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T45

    // $ANTLR start T46
    public void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:58:7: ( 'EQ' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:58:7: 'EQ'
            {
            match("EQ"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start T47
    public void mT47() throws RecognitionException {
        try {
            int _type = T47;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:59:7: ( 'LT' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:59:7: 'LT'
            {
            match("LT"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T47

    // $ANTLR start T48
    public void mT48() throws RecognitionException {
        try {
            int _type = T48;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:60:7: ( 'LEQ' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:60:7: 'LEQ'
            {
            match("LEQ"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T48

    // $ANTLR start T49
    public void mT49() throws RecognitionException {
        try {
            int _type = T49;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:61:7: ( 'AND' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:61:7: 'AND'
            {
            match("AND"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T49

    // $ANTLR start T50
    public void mT50() throws RecognitionException {
        try {
            int _type = T50;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:62:7: ( 'OR' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:62:7: 'OR'
            {
            match("OR"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T50

    // $ANTLR start T51
    public void mT51() throws RecognitionException {
        try {
            int _type = T51;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:63:7: ( 'ADD' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:63:7: 'ADD'
            {
            match("ADD"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T51

    // $ANTLR start T52
    public void mT52() throws RecognitionException {
        try {
            int _type = T52;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:64:7: ( 'SUB' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:64:7: 'SUB'
            {
            match("SUB"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T52

    // $ANTLR start T53
    public void mT53() throws RecognitionException {
        try {
            int _type = T53;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:65:7: ( 'MULT' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:65:7: 'MULT'
            {
            match("MULT"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T53

    // $ANTLR start T54
    public void mT54() throws RecognitionException {
        try {
            int _type = T54;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:66:7: ( 'DIV' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:66:7: 'DIV'
            {
            match("DIV"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T54

    // $ANTLR start RULE_ID
    public void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1302:3: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1302:3: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1302:3: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1302:4: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1302:33: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_STRING
    public void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1308:3: ( '\\\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\\"' ) )* '\\\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\"') ) {
                alt5=1;
            }
            else if ( (LA5_0=='\'') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1306:1: RULE_STRING : ( '\\\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\\"' ) )* '\\\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1308:3: '\\\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\\"' ) )* '\\\"'
                    {
                    match('\"'); 
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1308:8: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\\"' ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='\\') ) {
                            alt3=1;
                        }
                        else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFE')) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1308:10: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1308:54: ~ ( '\\\\' | '\\\"' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1309:3: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); 
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1309:8: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ~ ( '\\\\' | '\\'' ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFE')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1309:10: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1309:54: ~ ( '\\\\' | '\\'' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_INT
    public void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1315:3: ( ( '-' )? ( '0' .. '9' )+ )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1315:3: ( '-' )? ( '0' .. '9' )+
            {
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1315:3: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1315:4: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1315:9: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1315:10: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_WS
    public void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1321:3: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1321:3: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1321:3: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\t' && LA8_0<='\n')||LA8_0=='\r'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_ML_COMMENT
    public void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1327:3: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1327:3: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1327:8: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFE')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1327:36: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*/"); 

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ML_COMMENT

    // $ANTLR start RULE_SL_COMMENT
    public void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1333:3: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1333:3: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1333:8: (~ ( '\\n' | '\\r' ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1333:8: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1333:22: ( '\\r' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1333:22: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SL_COMMENT

    public void mTokens() throws RecognitionException {
        // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:10: ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | RULE_ID | RULE_STRING | RULE_INT | RULE_WS | RULE_ML_COMMENT | RULE_SL_COMMENT )
        int alt12=51;
        switch ( input.LA(1) ) {
        case 's':
            {
            switch ( input.LA(2) ) {
            case 't':
                {
                switch ( input.LA(3) ) {
                case 'a':
                    {
                    int LA12_72 = input.LA(4);

                    if ( (LA12_72=='t') ) {
                        int LA12_102 = input.LA(5);

                        if ( (LA12_102=='e') ) {
                            int LA12_126 = input.LA(6);

                            if ( (LA12_126=='c') ) {
                                int LA12_145 = input.LA(7);

                                if ( (LA12_145=='h') ) {
                                    int LA12_162 = input.LA(8);

                                    if ( (LA12_162=='a') ) {
                                        int LA12_174 = input.LA(9);

                                        if ( (LA12_174=='r') ) {
                                            int LA12_183 = input.LA(10);

                                            if ( (LA12_183=='t') ) {
                                                int LA12_188 = input.LA(11);

                                                if ( ((LA12_188>='0' && LA12_188<='9')||(LA12_188>='A' && LA12_188<='Z')||LA12_188=='_'||(LA12_188>='a' && LA12_188<='z')) ) {
                                                    alt12=46;
                                                }
                                                else {
                                                    alt12=1;}
                                            }
                                            else {
                                                alt12=46;}
                                        }
                                        else {
                                            alt12=46;}
                                    }
                                    else {
                                        alt12=46;}
                                }
                                else {
                                    alt12=46;}
                            }
                            else {
                                alt12=46;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                    }
                    break;
                case 'r':
                    {
                    int LA12_73 = input.LA(4);

                    if ( (LA12_73=='o') ) {
                        int LA12_103 = input.LA(5);

                        if ( (LA12_103=='n') ) {
                            int LA12_127 = input.LA(6);

                            if ( (LA12_127=='g') ) {
                                int LA12_146 = input.LA(7);

                                if ( (LA12_146=='A') ) {
                                    int LA12_163 = input.LA(8);

                                    if ( (LA12_163=='b') ) {
                                        int LA12_175 = input.LA(9);

                                        if ( (LA12_175=='o') ) {
                                            int LA12_184 = input.LA(10);

                                            if ( (LA12_184=='r') ) {
                                                int LA12_189 = input.LA(11);

                                                if ( (LA12_189=='t') ) {
                                                    int LA12_193 = input.LA(12);

                                                    if ( (LA12_193=='i') ) {
                                                        int LA12_196 = input.LA(13);

                                                        if ( (LA12_196=='o') ) {
                                                            int LA12_199 = input.LA(14);

                                                            if ( (LA12_199=='n') ) {
                                                                int LA12_202 = input.LA(15);

                                                                if ( ((LA12_202>='0' && LA12_202<='9')||(LA12_202>='A' && LA12_202<='Z')||LA12_202=='_'||(LA12_202>='a' && LA12_202<='z')) ) {
                                                                    alt12=46;
                                                                }
                                                                else {
                                                                    alt12=27;}
                                                            }
                                                            else {
                                                                alt12=46;}
                                                        }
                                                        else {
                                                            alt12=46;}
                                                    }
                                                    else {
                                                        alt12=46;}
                                                }
                                                else {
                                                    alt12=46;}
                                            }
                                            else {
                                                alt12=46;}
                                        }
                                        else {
                                            alt12=46;}
                                    }
                                    else {
                                        alt12=46;}
                                }
                                else {
                                    alt12=46;}
                            }
                            else {
                                alt12=46;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                    }
                    break;
                default:
                    alt12=46;}

                }
                break;
            case 'a':
                {
                int LA12_39 = input.LA(3);

                if ( ((LA12_39>='0' && LA12_39<='9')||(LA12_39>='A' && LA12_39<='Z')||LA12_39=='_'||(LA12_39>='a' && LA12_39<='z')) ) {
                    alt12=46;
                }
                else {
                    alt12=28;}
                }
                break;
            default:
                alt12=46;}

            }
            break;
        case '[':
            {
            alt12=2;
            }
            break;
        case ']':
            {
            alt12=3;
            }
            break;
        case '{':
            {
            alt12=4;
            }
            break;
        case '}':
            {
            alt12=5;
            }
            break;
        case ';':
            {
            alt12=6;
            }
            break;
        case 'm':
            {
            int LA12_7 = input.LA(2);

            if ( (LA12_7=='o') ) {
                int LA12_40 = input.LA(3);

                if ( (LA12_40=='d') ) {
                    int LA12_75 = input.LA(4);

                    if ( (LA12_75=='e') ) {
                        int LA12_104 = input.LA(5);

                        if ( (LA12_104=='l') ) {
                            int LA12_128 = input.LA(6);

                            if ( ((LA12_128>='0' && LA12_128<='9')||(LA12_128>='A' && LA12_128<='Z')||LA12_128=='_'||(LA12_128>='a' && LA12_128<='z')) ) {
                                alt12=46;
                            }
                            else {
                                alt12=7;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                }
                else {
                    alt12=46;}
            }
            else {
                alt12=46;}
            }
            break;
        case '=':
            {
            alt12=8;
            }
            break;
        case 'v':
            {
            int LA12_9 = input.LA(2);

            if ( (LA12_9=='e') ) {
                int LA12_41 = input.LA(3);

                if ( (LA12_41=='r') ) {
                    int LA12_76 = input.LA(4);

                    if ( (LA12_76=='s') ) {
                        int LA12_105 = input.LA(5);

                        if ( (LA12_105=='i') ) {
                            int LA12_129 = input.LA(6);

                            if ( (LA12_129=='o') ) {
                                int LA12_148 = input.LA(7);

                                if ( (LA12_148=='n') ) {
                                    int LA12_164 = input.LA(8);

                                    if ( ((LA12_164>='0' && LA12_164<='9')||(LA12_164>='A' && LA12_164<='Z')||LA12_164=='_'||(LA12_164>='a' && LA12_164<='z')) ) {
                                        alt12=46;
                                    }
                                    else {
                                        alt12=9;}
                                }
                                else {
                                    alt12=46;}
                            }
                            else {
                                alt12=46;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                }
                else {
                    alt12=46;}
            }
            else {
                alt12=46;}
            }
            break;
        case ':':
            {
            alt12=10;
            }
            break;
        case 'i':
            {
            int LA12_11 = input.LA(2);

            if ( (LA12_11=='n') ) {
                switch ( input.LA(3) ) {
                case 'p':
                    {
                    int LA12_77 = input.LA(4);

                    if ( (LA12_77=='u') ) {
                        int LA12_106 = input.LA(5);

                        if ( (LA12_106=='t') ) {
                            int LA12_130 = input.LA(6);

                            if ( ((LA12_130>='0' && LA12_130<='9')||(LA12_130>='A' && LA12_130<='Z')||LA12_130=='_'||(LA12_130>='a' && LA12_130<='z')) ) {
                                alt12=46;
                            }
                            else {
                                alt12=11;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                    }
                    break;
                case 't':
                    {
                    int LA12_78 = input.LA(4);

                    if ( (LA12_78=='e') ) {
                        int LA12_107 = input.LA(5);

                        if ( (LA12_107=='g') ) {
                            int LA12_131 = input.LA(6);

                            if ( (LA12_131=='e') ) {
                                int LA12_150 = input.LA(7);

                                if ( (LA12_150=='r') ) {
                                    int LA12_165 = input.LA(8);

                                    if ( ((LA12_165>='0' && LA12_165<='9')||(LA12_165>='A' && LA12_165<='Z')||LA12_165=='_'||(LA12_165>='a' && LA12_165<='z')) ) {
                                        alt12=46;
                                    }
                                    else {
                                        alt12=16;}
                                }
                                else {
                                    alt12=46;}
                            }
                            else {
                                alt12=46;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                    }
                    break;
                case 'i':
                    {
                    int LA12_79 = input.LA(4);

                    if ( (LA12_79=='t') ) {
                        int LA12_108 = input.LA(5);

                        if ( (LA12_108=='i') ) {
                            int LA12_132 = input.LA(6);

                            if ( (LA12_132=='a') ) {
                                int LA12_151 = input.LA(7);

                                if ( (LA12_151=='l') ) {
                                    int LA12_166 = input.LA(8);

                                    if ( ((LA12_166>='0' && LA12_166<='9')||(LA12_166>='A' && LA12_166<='Z')||LA12_166=='_'||(LA12_166>='a' && LA12_166<='z')) ) {
                                        alt12=46;
                                    }
                                    else {
                                        alt12=20;}
                                }
                                else {
                                    alt12=46;}
                            }
                            else {
                                alt12=46;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                    }
                    break;
                default:
                    alt12=46;}

            }
            else {
                alt12=46;}
            }
            break;
        case 'o':
            {
            int LA12_12 = input.LA(2);

            if ( (LA12_12=='u') ) {
                int LA12_43 = input.LA(3);

                if ( (LA12_43=='t') ) {
                    int LA12_80 = input.LA(4);

                    if ( (LA12_80=='p') ) {
                        int LA12_109 = input.LA(5);

                        if ( (LA12_109=='u') ) {
                            int LA12_133 = input.LA(6);

                            if ( (LA12_133=='t') ) {
                                int LA12_152 = input.LA(7);

                                if ( ((LA12_152>='0' && LA12_152<='9')||(LA12_152>='A' && LA12_152<='Z')||LA12_152=='_'||(LA12_152>='a' && LA12_152<='z')) ) {
                                    alt12=46;
                                }
                                else {
                                    alt12=12;}
                            }
                            else {
                                alt12=46;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                }
                else {
                    alt12=46;}
            }
            else {
                alt12=46;}
            }
            break;
        case 'b':
            {
            int LA12_13 = input.LA(2);

            if ( (LA12_13=='o') ) {
                int LA12_44 = input.LA(3);

                if ( (LA12_44=='o') ) {
                    int LA12_81 = input.LA(4);

                    if ( (LA12_81=='l') ) {
                        int LA12_110 = input.LA(5);

                        if ( (LA12_110=='e') ) {
                            int LA12_134 = input.LA(6);

                            if ( (LA12_134=='a') ) {
                                int LA12_153 = input.LA(7);

                                if ( (LA12_153=='n') ) {
                                    int LA12_168 = input.LA(8);

                                    if ( ((LA12_168>='0' && LA12_168<='9')||(LA12_168>='A' && LA12_168<='Z')||LA12_168=='_'||(LA12_168>='a' && LA12_168<='z')) ) {
                                        alt12=46;
                                    }
                                    else {
                                        alt12=13;}
                                }
                                else {
                                    alt12=46;}
                            }
                            else {
                                alt12=46;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                }
                else {
                    alt12=46;}
            }
            else {
                alt12=46;}
            }
            break;
        case 'd':
            {
            int LA12_14 = input.LA(2);

            if ( (LA12_14=='o') ) {
                int LA12_45 = input.LA(3);

                if ( (LA12_45=='u') ) {
                    int LA12_82 = input.LA(4);

                    if ( (LA12_82=='b') ) {
                        int LA12_111 = input.LA(5);

                        if ( (LA12_111=='l') ) {
                            int LA12_135 = input.LA(6);

                            if ( (LA12_135=='e') ) {
                                int LA12_154 = input.LA(7);

                                if ( ((LA12_154>='0' && LA12_154<='9')||(LA12_154>='A' && LA12_154<='Z')||LA12_154=='_'||(LA12_154>='a' && LA12_154<='z')) ) {
                                    alt12=46;
                                }
                                else {
                                    alt12=14;}
                            }
                            else {
                                alt12=46;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                }
                else {
                    alt12=46;}
            }
            else {
                alt12=46;}
            }
            break;
        case 'f':
            {
            switch ( input.LA(2) ) {
            case 'l':
                {
                int LA12_46 = input.LA(3);

                if ( (LA12_46=='o') ) {
                    int LA12_83 = input.LA(4);

                    if ( (LA12_83=='a') ) {
                        int LA12_112 = input.LA(5);

                        if ( (LA12_112=='t') ) {
                            int LA12_136 = input.LA(6);

                            if ( ((LA12_136>='0' && LA12_136<='9')||(LA12_136>='A' && LA12_136<='Z')||LA12_136=='_'||(LA12_136>='a' && LA12_136<='z')) ) {
                                alt12=46;
                            }
                            else {
                                alt12=15;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                }
                else {
                    alt12=46;}
                }
                break;
            case 'i':
                {
                int LA12_47 = input.LA(3);

                if ( (LA12_47=='n') ) {
                    int LA12_84 = input.LA(4);

                    if ( (LA12_84=='a') ) {
                        int LA12_113 = input.LA(5);

                        if ( (LA12_113=='l') ) {
                            int LA12_137 = input.LA(6);

                            if ( ((LA12_137>='0' && LA12_137<='9')||(LA12_137>='A' && LA12_137<='Z')||LA12_137=='_'||(LA12_137>='a' && LA12_137<='z')) ) {
                                alt12=46;
                            }
                            else {
                                alt12=19;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                }
                else {
                    alt12=46;}
                }
                break;
            default:
                alt12=46;}

            }
            break;
        case 'l':
            {
            int LA12_16 = input.LA(2);

            if ( (LA12_16=='a') ) {
                int LA12_48 = input.LA(3);

                if ( (LA12_48=='b') ) {
                    int LA12_85 = input.LA(4);

                    if ( (LA12_85=='e') ) {
                        int LA12_114 = input.LA(5);

                        if ( (LA12_114=='l') ) {
                            int LA12_138 = input.LA(6);

                            if ( ((LA12_138>='0' && LA12_138<='9')||(LA12_138>='A' && LA12_138<='Z')||LA12_138=='_'||(LA12_138>='a' && LA12_138<='z')) ) {
                                alt12=46;
                            }
                            else {
                                alt12=17;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                }
                else {
                    alt12=46;}
            }
            else {
                alt12=46;}
            }
            break;
        case 't':
            {
            int LA12_17 = input.LA(2);

            if ( (LA12_17=='y') ) {
                int LA12_49 = input.LA(3);

                if ( (LA12_49=='p') ) {
                    int LA12_86 = input.LA(4);

                    if ( (LA12_86=='e') ) {
                        int LA12_115 = input.LA(5);

                        if ( ((LA12_115>='0' && LA12_115<='9')||(LA12_115>='A' && LA12_115<='Z')||LA12_115=='_'||(LA12_115>='a' && LA12_115<='z')) ) {
                            alt12=46;
                        }
                        else {
                            alt12=18;}
                    }
                    else {
                        alt12=46;}
                }
                else {
                    alt12=46;}
            }
            else {
                alt12=46;}
            }
            break;
        case 'p':
            {
            switch ( input.LA(2) ) {
            case 'r':
                {
                int LA12_50 = input.LA(3);

                if ( (LA12_50=='i') ) {
                    int LA12_87 = input.LA(4);

                    if ( (LA12_87=='o') ) {
                        int LA12_116 = input.LA(5);

                        if ( (LA12_116=='r') ) {
                            int LA12_140 = input.LA(6);

                            if ( (LA12_140=='i') ) {
                                int LA12_158 = input.LA(7);

                                if ( (LA12_158=='t') ) {
                                    int LA12_170 = input.LA(8);

                                    if ( (LA12_170=='y') ) {
                                        int LA12_180 = input.LA(9);

                                        if ( ((LA12_180>='0' && LA12_180<='9')||(LA12_180>='A' && LA12_180<='Z')||LA12_180=='_'||(LA12_180>='a' && LA12_180<='z')) ) {
                                            alt12=46;
                                        }
                                        else {
                                            alt12=24;}
                                    }
                                    else {
                                        alt12=46;}
                                }
                                else {
                                    alt12=46;}
                            }
                            else {
                                alt12=46;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                }
                else {
                    alt12=46;}
                }
                break;
            case 's':
                {
                int LA12_51 = input.LA(3);

                if ( (LA12_51=='e') ) {
                    int LA12_88 = input.LA(4);

                    if ( (LA12_88=='u') ) {
                        int LA12_117 = input.LA(5);

                        if ( (LA12_117=='d') ) {
                            int LA12_141 = input.LA(6);

                            if ( (LA12_141=='o') ) {
                                int LA12_159 = input.LA(7);

                                if ( ((LA12_159>='0' && LA12_159<='9')||(LA12_159>='A' && LA12_159<='Z')||LA12_159=='_'||(LA12_159>='a' && LA12_159<='z')) ) {
                                    alt12=46;
                                }
                                else {
                                    alt12=21;}
                            }
                            else {
                                alt12=46;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                }
                else {
                    alt12=46;}
                }
                break;
            default:
                alt12=46;}

            }
            break;
        case '|':
            {
            alt12=22;
            }
            break;
        case '-':
            {
            int LA12_20 = input.LA(2);

            if ( (LA12_20=='>') ) {
                alt12=23;
            }
            else if ( ((LA12_20>='0' && LA12_20<='9')) ) {
                alt12=48;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | RULE_ID | RULE_STRING | RULE_INT | RULE_WS | RULE_ML_COMMENT | RULE_SL_COMMENT );", 12, 20, input);

                throw nvae;
            }
            }
            break;
        case 'w':
            {
            switch ( input.LA(2) ) {
            case 'a':
                {
                int LA12_53 = input.LA(3);

                if ( ((LA12_53>='0' && LA12_53<='9')||(LA12_53>='A' && LA12_53<='Z')||LA12_53=='_'||(LA12_53>='a' && LA12_53<='z')) ) {
                    alt12=46;
                }
                else {
                    alt12=26;}
                }
                break;
            case 'e':
                {
                int LA12_54 = input.LA(3);

                if ( (LA12_54=='a') ) {
                    int LA12_90 = input.LA(4);

                    if ( (LA12_90=='k') ) {
                        int LA12_118 = input.LA(5);

                        if ( (LA12_118=='A') ) {
                            int LA12_142 = input.LA(6);

                            if ( (LA12_142=='b') ) {
                                int LA12_160 = input.LA(7);

                                if ( (LA12_160=='o') ) {
                                    int LA12_172 = input.LA(8);

                                    if ( (LA12_172=='r') ) {
                                        int LA12_181 = input.LA(9);

                                        if ( (LA12_181=='t') ) {
                                            int LA12_186 = input.LA(10);

                                            if ( (LA12_186=='i') ) {
                                                int LA12_190 = input.LA(11);

                                                if ( (LA12_190=='o') ) {
                                                    int LA12_194 = input.LA(12);

                                                    if ( (LA12_194=='n') ) {
                                                        int LA12_197 = input.LA(13);

                                                        if ( ((LA12_197>='0' && LA12_197<='9')||(LA12_197>='A' && LA12_197<='Z')||LA12_197=='_'||(LA12_197>='a' && LA12_197<='z')) ) {
                                                            alt12=46;
                                                        }
                                                        else {
                                                            alt12=25;}
                                                    }
                                                    else {
                                                        alt12=46;}
                                                }
                                                else {
                                                    alt12=46;}
                                            }
                                            else {
                                                alt12=46;}
                                        }
                                        else {
                                            alt12=46;}
                                    }
                                    else {
                                        alt12=46;}
                                }
                                else {
                                    alt12=46;}
                            }
                            else {
                                alt12=46;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                }
                else {
                    alt12=46;}
                }
                break;
            default:
                alt12=46;}

            }
            break;
        case 'n':
            {
            switch ( input.LA(2) ) {
            case 't':
                {
                int LA12_55 = input.LA(3);

                if ( ((LA12_55>='0' && LA12_55<='9')||(LA12_55>='A' && LA12_55<='Z')||LA12_55=='_'||(LA12_55>='a' && LA12_55<='z')) ) {
                    alt12=46;
                }
                else {
                    alt12=30;}
                }
                break;
            case 'o':
                {
                int LA12_56 = input.LA(3);

                if ( (LA12_56=='r') ) {
                    int LA12_92 = input.LA(4);

                    if ( (LA12_92=='m') ) {
                        int LA12_119 = input.LA(5);

                        if ( (LA12_119=='a') ) {
                            int LA12_143 = input.LA(6);

                            if ( (LA12_143=='l') ) {
                                int LA12_161 = input.LA(7);

                                if ( (LA12_161=='T') ) {
                                    int LA12_173 = input.LA(8);

                                    if ( (LA12_173=='e') ) {
                                        int LA12_182 = input.LA(9);

                                        if ( (LA12_182=='r') ) {
                                            int LA12_187 = input.LA(10);

                                            if ( (LA12_187=='m') ) {
                                                int LA12_191 = input.LA(11);

                                                if ( (LA12_191=='i') ) {
                                                    int LA12_195 = input.LA(12);

                                                    if ( (LA12_195=='n') ) {
                                                        int LA12_198 = input.LA(13);

                                                        if ( (LA12_198=='a') ) {
                                                            int LA12_201 = input.LA(14);

                                                            if ( (LA12_201=='t') ) {
                                                                int LA12_203 = input.LA(15);

                                                                if ( (LA12_203=='i') ) {
                                                                    int LA12_205 = input.LA(16);

                                                                    if ( (LA12_205=='o') ) {
                                                                        int LA12_206 = input.LA(17);

                                                                        if ( (LA12_206=='n') ) {
                                                                            int LA12_207 = input.LA(18);

                                                                            if ( ((LA12_207>='0' && LA12_207<='9')||(LA12_207>='A' && LA12_207<='Z')||LA12_207=='_'||(LA12_207>='a' && LA12_207<='z')) ) {
                                                                                alt12=46;
                                                                            }
                                                                            else {
                                                                                alt12=29;}
                                                                        }
                                                                        else {
                                                                            alt12=46;}
                                                                    }
                                                                    else {
                                                                        alt12=46;}
                                                                }
                                                                else {
                                                                    alt12=46;}
                                                            }
                                                            else {
                                                                alt12=46;}
                                                        }
                                                        else {
                                                            alt12=46;}
                                                    }
                                                    else {
                                                        alt12=46;}
                                                }
                                                else {
                                                    alt12=46;}
                                            }
                                            else {
                                                alt12=46;}
                                        }
                                        else {
                                            alt12=46;}
                                    }
                                    else {
                                        alt12=46;}
                                }
                                else {
                                    alt12=46;}
                            }
                            else {
                                alt12=46;}
                        }
                        else {
                            alt12=46;}
                    }
                    else {
                        alt12=46;}
                }
                else {
                    alt12=46;}
                }
                break;
            default:
                alt12=46;}

            }
            break;
        case '/':
            {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt12=51;
                }
                break;
            case '*':
                {
                alt12=50;
                }
                break;
            default:
                alt12=31;}

            }
            break;
        case '(':
            {
            alt12=32;
            }
            break;
        case ')':
            {
            alt12=33;
            }
            break;
        case 'I':
            {
            int LA12_26 = input.LA(2);

            if ( ((LA12_26>='0' && LA12_26<='9')||(LA12_26>='A' && LA12_26<='Z')||LA12_26=='_'||(LA12_26>='a' && LA12_26<='z')) ) {
                alt12=46;
            }
            else {
                alt12=34;}
            }
            break;
        case 'O':
            {
            switch ( input.LA(2) ) {
            case 'R':
                {
                int LA12_61 = input.LA(3);

                if ( ((LA12_61>='0' && LA12_61<='9')||(LA12_61>='A' && LA12_61<='Z')||LA12_61=='_'||(LA12_61>='a' && LA12_61<='z')) ) {
                    alt12=46;
                }
                else {
                    alt12=41;}
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt12=46;
                }
                break;
            default:
                alt12=35;}

            }
            break;
        case 'L':
            {
            switch ( input.LA(2) ) {
            case 'T':
                {
                int LA12_63 = input.LA(3);

                if ( ((LA12_63>='0' && LA12_63<='9')||(LA12_63>='A' && LA12_63<='Z')||LA12_63=='_'||(LA12_63>='a' && LA12_63<='z')) ) {
                    alt12=46;
                }
                else {
                    alt12=38;}
                }
                break;
            case 'E':
                {
                int LA12_64 = input.LA(3);

                if ( (LA12_64=='Q') ) {
                    int LA12_95 = input.LA(4);

                    if ( ((LA12_95>='0' && LA12_95<='9')||(LA12_95>='A' && LA12_95<='Z')||LA12_95=='_'||(LA12_95>='a' && LA12_95<='z')) ) {
                        alt12=46;
                    }
                    else {
                        alt12=39;}
                }
                else {
                    alt12=46;}
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt12=46;
                }
                break;
            default:
                alt12=36;}

            }
            break;
        case 'E':
            {
            int LA12_29 = input.LA(2);

            if ( (LA12_29=='Q') ) {
                int LA12_66 = input.LA(3);

                if ( ((LA12_66>='0' && LA12_66<='9')||(LA12_66>='A' && LA12_66<='Z')||LA12_66=='_'||(LA12_66>='a' && LA12_66<='z')) ) {
                    alt12=46;
                }
                else {
                    alt12=37;}
            }
            else {
                alt12=46;}
            }
            break;
        case 'A':
            {
            switch ( input.LA(2) ) {
            case 'N':
                {
                int LA12_67 = input.LA(3);

                if ( (LA12_67=='D') ) {
                    int LA12_97 = input.LA(4);

                    if ( ((LA12_97>='0' && LA12_97<='9')||(LA12_97>='A' && LA12_97<='Z')||LA12_97=='_'||(LA12_97>='a' && LA12_97<='z')) ) {
                        alt12=46;
                    }
                    else {
                        alt12=40;}
                }
                else {
                    alt12=46;}
                }
                break;
            case 'D':
                {
                int LA12_68 = input.LA(3);

                if ( (LA12_68=='D') ) {
                    int LA12_98 = input.LA(4);

                    if ( ((LA12_98>='0' && LA12_98<='9')||(LA12_98>='A' && LA12_98<='Z')||LA12_98=='_'||(LA12_98>='a' && LA12_98<='z')) ) {
                        alt12=46;
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=46;}
                }
                break;
            default:
                alt12=46;}

            }
            break;
        case 'S':
            {
            int LA12_31 = input.LA(2);

            if ( (LA12_31=='U') ) {
                int LA12_69 = input.LA(3);

                if ( (LA12_69=='B') ) {
                    int LA12_99 = input.LA(4);

                    if ( ((LA12_99>='0' && LA12_99<='9')||(LA12_99>='A' && LA12_99<='Z')||LA12_99=='_'||(LA12_99>='a' && LA12_99<='z')) ) {
                        alt12=46;
                    }
                    else {
                        alt12=43;}
                }
                else {
                    alt12=46;}
            }
            else {
                alt12=46;}
            }
            break;
        case 'M':
            {
            int LA12_32 = input.LA(2);

            if ( (LA12_32=='U') ) {
                int LA12_70 = input.LA(3);

                if ( (LA12_70=='L') ) {
                    int LA12_100 = input.LA(4);

                    if ( (LA12_100=='T') ) {
                        int LA12_124 = input.LA(5);

                        if ( ((LA12_124>='0' && LA12_124<='9')||(LA12_124>='A' && LA12_124<='Z')||LA12_124=='_'||(LA12_124>='a' && LA12_124<='z')) ) {
                            alt12=46;
                        }
                        else {
                            alt12=44;}
                    }
                    else {
                        alt12=46;}
                }
                else {
                    alt12=46;}
            }
            else {
                alt12=46;}
            }
            break;
        case 'D':
            {
            int LA12_33 = input.LA(2);

            if ( (LA12_33=='I') ) {
                int LA12_71 = input.LA(3);

                if ( (LA12_71=='V') ) {
                    int LA12_101 = input.LA(4);

                    if ( ((LA12_101>='0' && LA12_101<='9')||(LA12_101>='A' && LA12_101<='Z')||LA12_101=='_'||(LA12_101>='a' && LA12_101<='z')) ) {
                        alt12=46;
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=46;}
            }
            else {
                alt12=46;}
            }
            break;
        case 'B':
        case 'C':
        case 'F':
        case 'G':
        case 'H':
        case 'J':
        case 'K':
        case 'N':
        case 'P':
        case 'Q':
        case 'R':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '^':
        case '_':
        case 'a':
        case 'c':
        case 'e':
        case 'g':
        case 'h':
        case 'j':
        case 'k':
        case 'q':
        case 'r':
        case 'u':
        case 'x':
        case 'y':
        case 'z':
            {
            alt12=46;
            }
            break;
        case '\"':
        case '\'':
            {
            alt12=47;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt12=48;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt12=49;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | RULE_ID | RULE_STRING | RULE_INT | RULE_WS | RULE_ML_COMMENT | RULE_SL_COMMENT );", 12, 0, input);

            throw nvae;
        }

        switch (alt12) {
            case 1 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:10: T10
                {
                mT10(); 

                }
                break;
            case 2 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:14: T11
                {
                mT11(); 

                }
                break;
            case 3 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:18: T12
                {
                mT12(); 

                }
                break;
            case 4 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:22: T13
                {
                mT13(); 

                }
                break;
            case 5 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:26: T14
                {
                mT14(); 

                }
                break;
            case 6 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:30: T15
                {
                mT15(); 

                }
                break;
            case 7 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:34: T16
                {
                mT16(); 

                }
                break;
            case 8 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:38: T17
                {
                mT17(); 

                }
                break;
            case 9 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:42: T18
                {
                mT18(); 

                }
                break;
            case 10 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:46: T19
                {
                mT19(); 

                }
                break;
            case 11 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:50: T20
                {
                mT20(); 

                }
                break;
            case 12 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:54: T21
                {
                mT21(); 

                }
                break;
            case 13 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:58: T22
                {
                mT22(); 

                }
                break;
            case 14 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:62: T23
                {
                mT23(); 

                }
                break;
            case 15 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:66: T24
                {
                mT24(); 

                }
                break;
            case 16 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:70: T25
                {
                mT25(); 

                }
                break;
            case 17 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:74: T26
                {
                mT26(); 

                }
                break;
            case 18 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:78: T27
                {
                mT27(); 

                }
                break;
            case 19 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:82: T28
                {
                mT28(); 

                }
                break;
            case 20 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:86: T29
                {
                mT29(); 

                }
                break;
            case 21 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:90: T30
                {
                mT30(); 

                }
                break;
            case 22 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:94: T31
                {
                mT31(); 

                }
                break;
            case 23 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:98: T32
                {
                mT32(); 

                }
                break;
            case 24 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:102: T33
                {
                mT33(); 

                }
                break;
            case 25 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:106: T34
                {
                mT34(); 

                }
                break;
            case 26 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:110: T35
                {
                mT35(); 

                }
                break;
            case 27 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:114: T36
                {
                mT36(); 

                }
                break;
            case 28 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:118: T37
                {
                mT37(); 

                }
                break;
            case 29 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:122: T38
                {
                mT38(); 

                }
                break;
            case 30 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:126: T39
                {
                mT39(); 

                }
                break;
            case 31 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:130: T40
                {
                mT40(); 

                }
                break;
            case 32 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:134: T41
                {
                mT41(); 

                }
                break;
            case 33 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:138: T42
                {
                mT42(); 

                }
                break;
            case 34 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:142: T43
                {
                mT43(); 

                }
                break;
            case 35 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:146: T44
                {
                mT44(); 

                }
                break;
            case 36 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:150: T45
                {
                mT45(); 

                }
                break;
            case 37 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:154: T46
                {
                mT46(); 

                }
                break;
            case 38 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:158: T47
                {
                mT47(); 

                }
                break;
            case 39 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:162: T48
                {
                mT48(); 

                }
                break;
            case 40 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:166: T49
                {
                mT49(); 

                }
                break;
            case 41 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:170: T50
                {
                mT50(); 

                }
                break;
            case 42 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:174: T51
                {
                mT51(); 

                }
                break;
            case 43 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:178: T52
                {
                mT52(); 

                }
                break;
            case 44 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:182: T53
                {
                mT53(); 

                }
                break;
            case 45 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:186: T54
                {
                mT54(); 

                }
                break;
            case 46 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:190: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 47 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:198: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 48 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:210: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 49 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:219: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 50 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:227: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 51 :
                // ..//de.cau.cs.kieler.ssm2.kit/src-gen/de/cau/cs/kieler/ssm2/kit/parser/KIT.g:1:243: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;

        }

    }


 

}