package de.cau.cs.kieler.s.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSLexer extends Lexer {
    public static final int T14=14;
    public static final int T29=29;
    public static final int T36=36;
    public static final int T58=58;
    public static final int RULE_STRING=6;
    public static final int RULE_COMMENT_ANNOTATION=9;
    public static final int RULE_FLOAT=7;
    public static final int T35=35;
    public static final int T61=61;
    public static final int T45=45;
    public static final int T20=20;
    public static final int T34=34;
    public static final int T64=64;
    public static final int T25=25;
    public static final int T18=18;
    public static final int T37=37;
    public static final int T26=26;
    public static final int RULE_INT=5;
    public static final int RULE_BOOLEAN=8;
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
    public static final int T62=62;
    public static final int T44=44;
    public static final int T55=55;
    public static final int RULE_ML_COMMENT=10;
    public static final int RULE_ID=4;
    public static final int T33=33;
    public static final int T22=22;
    public static final int T50=50;
    public static final int T43=43;
    public static final int T23=23;
    public static final int T28=28;
    public static final int T42=42;
    public static final int T66=66;
    public static final int T40=40;
    public static final int T63=63;
    public static final int T57=57;
    public static final int T65=65;
    public static final int T56=56;
    public static final int T59=59;
    public static final int RULE_WS=12;
    public static final int T48=48;
    public static final int T15=15;
    public static final int T54=54;
    public static final int EOF=-1;
    public static final int T47=47;
    public static final int Tokens=67;
    public static final int T53=53;
    public static final int T60=60;
    public static final int RULE_ANY_OTHER=13;
    public static final int T31=31;
    public static final int T49=49;
    public static final int RULE_SL_COMMENT=11;
    public static final int T27=27;
    public static final int T52=52;
    public static final int T30=30;
    public InternalSLexer() {;} 
    public InternalSLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g"; }

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:10:5: ( 'Synchronous Program' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:10:7: 'Synchronous Program'
            {
            match("Synchronous Program"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:11:5: ( '(' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:11:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:12:5: ( ')' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:12:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:13:5: ( ':' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:13:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:14:5: ( 'SIGNALS' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:14:7: 'SIGNALS'
            {
            match("SIGNALS"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:15:5: ( ';' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:15:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:16:5: ( 'input' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:16:7: 'input'
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
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:17:5: ( 'output' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:17:7: 'output'
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
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:18:5: ( 'signal' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:18:7: 'signal'
            {
            match("signal"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:19:5: ( ':=' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:19:7: ':='
            {
            match(":="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:20:5: ( 'combine' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:20:7: 'combine'
            {
            match("combine"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:21:5: ( 'with' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:21:7: 'with'
            {
            match("with"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:22:5: ( 'PAUSE' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:22:7: 'PAUSE'
            {
            match("PAUSE"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:23:5: ( 'TERM' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:23:7: 'TERM'
            {
            match("TERM"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:24:5: ( 'Halt' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:24:7: 'Halt'
            {
            match("Halt"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:25:5: ( 'JOIN' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:25:7: 'JOIN'
            {
            match("JOIN"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:26:5: ( 'ABORT' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:26:7: 'ABORT'
            {
            match("ABORT"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:27:5: ( 'IF' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:27:7: 'IF'
            {
            match("IF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:28:5: ( ',' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:28:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:29:5: ( '{' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:29:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:30:5: ( '}' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:30:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:31:5: ( 'GOTO' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:31:7: 'GOTO'
            {
            match("GOTO"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:32:5: ( 'FORK' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:32:7: 'FORK'
            {
            match("FORK"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public final void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:33:5: ( 'FORKE' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:33:7: 'FORKE'
            {
            match("FORKE"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start T38
    public final void mT38() throws RecognitionException {
        try {
            int _type = T38;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:34:5: ( 'EMIT' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:34:7: 'EMIT'
            {
            match("EMIT"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start T39
    public final void mT39() throws RecognitionException {
        try {
            int _type = T39;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:35:5: ( 'AWAIT' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:35:7: 'AWAIT'
            {
            match("AWAIT"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T39

    // $ANTLR start T40
    public final void mT40() throws RecognitionException {
        try {
            int _type = T40;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:36:5: ( 'PRIO' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:36:7: 'PRIO'
            {
            match("PRIO"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start T41
    public final void mT41() throws RecognitionException {
        try {
            int _type = T41;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:37:5: ( '@' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:37:7: '@'
            {
            match('@'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T41

    // $ANTLR start T42
    public final void mT42() throws RecognitionException {
        try {
            int _type = T42;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:38:5: ( '=' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:38:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start T43
    public final void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:39:5: ( '<' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:39:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T43

    // $ANTLR start T44
    public final void mT44() throws RecognitionException {
        try {
            int _type = T44;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:40:5: ( '<=' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:40:7: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T44

    // $ANTLR start T45
    public final void mT45() throws RecognitionException {
        try {
            int _type = T45;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:41:5: ( '>' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:41:7: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T45

    // $ANTLR start T46
    public final void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:42:5: ( '>=' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:42:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start T47
    public final void mT47() throws RecognitionException {
        try {
            int _type = T47;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:43:5: ( '<>' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:43:7: '<>'
            {
            match("<>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T47

    // $ANTLR start T48
    public final void mT48() throws RecognitionException {
        try {
            int _type = T48;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:44:5: ( 'pre' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:44:7: 'pre'
            {
            match("pre"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T48

    // $ANTLR start T49
    public final void mT49() throws RecognitionException {
        try {
            int _type = T49;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:45:5: ( 'or' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:45:7: 'or'
            {
            match("or"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T49

    // $ANTLR start T50
    public final void mT50() throws RecognitionException {
        try {
            int _type = T50;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:46:5: ( 'and' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:46:7: 'and'
            {
            match("and"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T50

    // $ANTLR start T51
    public final void mT51() throws RecognitionException {
        try {
            int _type = T51;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:47:5: ( 'not' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:47:7: 'not'
            {
            match("not"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T51

    // $ANTLR start T52
    public final void mT52() throws RecognitionException {
        try {
            int _type = T52;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:48:5: ( '+' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:48:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T52

    // $ANTLR start T53
    public final void mT53() throws RecognitionException {
        try {
            int _type = T53;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:49:5: ( '-' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:49:7: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T53

    // $ANTLR start T54
    public final void mT54() throws RecognitionException {
        try {
            int _type = T54;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:50:5: ( '*' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:50:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T54

    // $ANTLR start T55
    public final void mT55() throws RecognitionException {
        try {
            int _type = T55;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:51:5: ( 'mod' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:51:7: 'mod'
            {
            match("mod"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T55

    // $ANTLR start T56
    public final void mT56() throws RecognitionException {
        try {
            int _type = T56;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:52:5: ( '/' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:52:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T56

    // $ANTLR start T57
    public final void mT57() throws RecognitionException {
        try {
            int _type = T57;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:53:5: ( '?' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:53:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T57

    // $ANTLR start T58
    public final void mT58() throws RecognitionException {
        try {
            int _type = T58;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:54:5: ( 'pure' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:54:7: 'pure'
            {
            match("pure"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T58

    // $ANTLR start T59
    public final void mT59() throws RecognitionException {
        try {
            int _type = T59;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:55:5: ( 'bool' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:55:7: 'bool'
            {
            match("bool"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T59

    // $ANTLR start T60
    public final void mT60() throws RecognitionException {
        try {
            int _type = T60;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:56:5: ( 'unsigned' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:56:7: 'unsigned'
            {
            match("unsigned"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T60

    // $ANTLR start T61
    public final void mT61() throws RecognitionException {
        try {
            int _type = T61;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:57:5: ( 'int' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:57:7: 'int'
            {
            match("int"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T61

    // $ANTLR start T62
    public final void mT62() throws RecognitionException {
        try {
            int _type = T62;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:58:5: ( 'float' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:58:7: 'float'
            {
            match("float"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T62

    // $ANTLR start T63
    public final void mT63() throws RecognitionException {
        try {
            int _type = T63;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:59:5: ( 'host' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:59:7: 'host'
            {
            match("host"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T63

    // $ANTLR start T64
    public final void mT64() throws RecognitionException {
        try {
            int _type = T64;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:60:5: ( 'none' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:60:7: 'none'
            {
            match("none"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T64

    // $ANTLR start T65
    public final void mT65() throws RecognitionException {
        try {
            int _type = T65;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:61:5: ( 'max' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:61:7: 'max'
            {
            match("max"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T65

    // $ANTLR start T66
    public final void mT66() throws RecognitionException {
        try {
            int _type = T66;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:62:5: ( 'min' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:62:7: 'min'
            {
            match("min"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T66

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3829:10: ( ( '-' )? ( '0' .. '9' )+ )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3829:12: ( '-' )? ( '0' .. '9' )+
            {
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3829:12: ( '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3829:12: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3829:17: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3829:18: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_FLOAT
    public final void mRULE_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_FLOAT;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3831:12: ( ( ( RULE_INT '.' RULE_INT | RULE_INT ( '.' RULE_INT )? ( 'e' | 'E' ) ( '+' )? RULE_INT ) ( 'f' )? | RULE_INT 'f' ) )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3831:14: ( ( RULE_INT '.' RULE_INT | RULE_INT ( '.' RULE_INT )? ( 'e' | 'E' ) ( '+' )? RULE_INT ) ( 'f' )? | RULE_INT 'f' )
            {
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3831:14: ( ( RULE_INT '.' RULE_INT | RULE_INT ( '.' RULE_INT )? ( 'e' | 'E' ) ( '+' )? RULE_INT ) ( 'f' )? | RULE_INT 'f' )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3831:15: ( RULE_INT '.' RULE_INT | RULE_INT ( '.' RULE_INT )? ( 'e' | 'E' ) ( '+' )? RULE_INT ) ( 'f' )?
                    {
                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3831:15: ( RULE_INT '.' RULE_INT | RULE_INT ( '.' RULE_INT )? ( 'e' | 'E' ) ( '+' )? RULE_INT )
                    int alt5=2;
                    alt5 = dfa5.predict(input);
                    switch (alt5) {
                        case 1 :
                            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3831:16: RULE_INT '.' RULE_INT
                            {
                            mRULE_INT(); 
                            match('.'); 
                            mRULE_INT(); 

                            }
                            break;
                        case 2 :
                            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3831:38: RULE_INT ( '.' RULE_INT )? ( 'e' | 'E' ) ( '+' )? RULE_INT
                            {
                            mRULE_INT(); 
                            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3831:47: ( '.' RULE_INT )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0=='.') ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3831:48: '.' RULE_INT
                                    {
                                    match('.'); 
                                    mRULE_INT(); 

                                    }
                                    break;

                            }

                            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recover(mse);    throw mse;
                            }

                            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3831:73: ( '+' )?
                            int alt4=2;
                            int LA4_0 = input.LA(1);

                            if ( (LA4_0=='+') ) {
                                alt4=1;
                            }
                            switch (alt4) {
                                case 1 :
                                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3831:73: '+'
                                    {
                                    match('+'); 

                                    }
                                    break;

                            }

                            mRULE_INT(); 

                            }
                            break;

                    }

                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3831:88: ( 'f' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='f') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3831:88: 'f'
                            {
                            match('f'); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3831:93: RULE_INT 'f'
                    {
                    mRULE_INT(); 
                    match('f'); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_FLOAT

    // $ANTLR start RULE_BOOLEAN
    public final void mRULE_BOOLEAN() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3833:14: ( ( 'true' | 'false' ) )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3833:16: ( 'true' | 'false' )
            {
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3833:16: ( 'true' | 'false' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='t') ) {
                alt8=1;
            }
            else if ( (LA8_0=='f') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3833:16: ( 'true' | 'false' )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3833:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3833:24: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_BOOLEAN

    // $ANTLR start RULE_COMMENT_ANNOTATION
    public final void mRULE_COMMENT_ANNOTATION() throws RecognitionException {
        try {
            int _type = RULE_COMMENT_ANNOTATION;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3835:25: ( '/**' ( options {greedy=false; } : . )* '*/' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3835:27: '/**' ( options {greedy=false; } : . )* '*/'
            {
            match("/**"); 

            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3835:33: ( options {greedy=false; } : . )*
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
            	    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3835:61: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*/"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_COMMENT_ANNOTATION

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3837:17: ( '/*' ~ ( '*' ) ( options {greedy=false; } : . )* '*/' )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3837:19: '/*' ~ ( '*' ) ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            if ( (input.LA(1)>='\u0000' && input.LA(1)<=')')||(input.LA(1)>='+' && input.LA(1)<='\uFFFE') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3837:31: ( options {greedy=false; } : . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='*') ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1=='/') ) {
                        alt10=2;
                    }
                    else if ( ((LA10_1>='\u0000' && LA10_1<='.')||(LA10_1>='0' && LA10_1<='\uFFFE')) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>='\u0000' && LA10_0<=')')||(LA10_0>='+' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3837:59: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match("*/"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ML_COMMENT

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3839:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3839:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3839:11: ( '^' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='^') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3839:11: '^'
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

            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3839:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')||(LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='z')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:
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
            	    break loop12;
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
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3841:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3841:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3841:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\"') ) {
                alt15=1;
            }
            else if ( (LA15_0=='\'') ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3841:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3841:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3841:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop13:
                    do {
                        int alt13=3;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='\\') ) {
                            alt13=1;
                        }
                        else if ( ((LA13_0>='\u0000' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFE')) ) {
                            alt13=2;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3841:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3841:62: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop13;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3841:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3841:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop14:
                    do {
                        int alt14=3;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0=='\\') ) {
                            alt14=1;
                        }
                        else if ( ((LA14_0>='\u0000' && LA14_0<='&')||(LA14_0>='(' && LA14_0<='[')||(LA14_0>=']' && LA14_0<='\uFFFE')) ) {
                            alt14=2;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3841:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3841:129: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop14;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3843:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3843:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3843:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\u0000' && LA16_0<='\t')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\uFFFE')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3843:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop16;
                }
            } while (true);

            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3843:40: ( ( '\\r' )? '\\n' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='\n'||LA18_0=='\r') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3843:41: ( '\\r' )? '\\n'
                    {
                    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3843:41: ( '\\r' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0=='\r') ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3843:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SL_COMMENT

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3845:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3845:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3845:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='\t' && LA19_0<='\n')||LA19_0=='\r'||LA19_0==' ') ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:
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
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_ANY_OTHER
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3847:16: ( . )
            // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:3847:18: .
            {
            matchAny(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ANY_OTHER

    public void mTokens() throws RecognitionException {
        // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:8: ( T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | RULE_INT | RULE_FLOAT | RULE_BOOLEAN | RULE_COMMENT_ANNOTATION | RULE_ML_COMMENT | RULE_ID | RULE_STRING | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt20=63;
        alt20 = dfa20.predict(input);
        switch (alt20) {
            case 1 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:10: T14
                {
                mT14(); 

                }
                break;
            case 2 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:14: T15
                {
                mT15(); 

                }
                break;
            case 3 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:18: T16
                {
                mT16(); 

                }
                break;
            case 4 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:22: T17
                {
                mT17(); 

                }
                break;
            case 5 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:26: T18
                {
                mT18(); 

                }
                break;
            case 6 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:30: T19
                {
                mT19(); 

                }
                break;
            case 7 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:34: T20
                {
                mT20(); 

                }
                break;
            case 8 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:38: T21
                {
                mT21(); 

                }
                break;
            case 9 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:42: T22
                {
                mT22(); 

                }
                break;
            case 10 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:46: T23
                {
                mT23(); 

                }
                break;
            case 11 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:50: T24
                {
                mT24(); 

                }
                break;
            case 12 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:54: T25
                {
                mT25(); 

                }
                break;
            case 13 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:58: T26
                {
                mT26(); 

                }
                break;
            case 14 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:62: T27
                {
                mT27(); 

                }
                break;
            case 15 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:66: T28
                {
                mT28(); 

                }
                break;
            case 16 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:70: T29
                {
                mT29(); 

                }
                break;
            case 17 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:74: T30
                {
                mT30(); 

                }
                break;
            case 18 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:78: T31
                {
                mT31(); 

                }
                break;
            case 19 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:82: T32
                {
                mT32(); 

                }
                break;
            case 20 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:86: T33
                {
                mT33(); 

                }
                break;
            case 21 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:90: T34
                {
                mT34(); 

                }
                break;
            case 22 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:94: T35
                {
                mT35(); 

                }
                break;
            case 23 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:98: T36
                {
                mT36(); 

                }
                break;
            case 24 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:102: T37
                {
                mT37(); 

                }
                break;
            case 25 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:106: T38
                {
                mT38(); 

                }
                break;
            case 26 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:110: T39
                {
                mT39(); 

                }
                break;
            case 27 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:114: T40
                {
                mT40(); 

                }
                break;
            case 28 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:118: T41
                {
                mT41(); 

                }
                break;
            case 29 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:122: T42
                {
                mT42(); 

                }
                break;
            case 30 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:126: T43
                {
                mT43(); 

                }
                break;
            case 31 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:130: T44
                {
                mT44(); 

                }
                break;
            case 32 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:134: T45
                {
                mT45(); 

                }
                break;
            case 33 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:138: T46
                {
                mT46(); 

                }
                break;
            case 34 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:142: T47
                {
                mT47(); 

                }
                break;
            case 35 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:146: T48
                {
                mT48(); 

                }
                break;
            case 36 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:150: T49
                {
                mT49(); 

                }
                break;
            case 37 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:154: T50
                {
                mT50(); 

                }
                break;
            case 38 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:158: T51
                {
                mT51(); 

                }
                break;
            case 39 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:162: T52
                {
                mT52(); 

                }
                break;
            case 40 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:166: T53
                {
                mT53(); 

                }
                break;
            case 41 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:170: T54
                {
                mT54(); 

                }
                break;
            case 42 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:174: T55
                {
                mT55(); 

                }
                break;
            case 43 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:178: T56
                {
                mT56(); 

                }
                break;
            case 44 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:182: T57
                {
                mT57(); 

                }
                break;
            case 45 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:186: T58
                {
                mT58(); 

                }
                break;
            case 46 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:190: T59
                {
                mT59(); 

                }
                break;
            case 47 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:194: T60
                {
                mT60(); 

                }
                break;
            case 48 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:198: T61
                {
                mT61(); 

                }
                break;
            case 49 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:202: T62
                {
                mT62(); 

                }
                break;
            case 50 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:206: T63
                {
                mT63(); 

                }
                break;
            case 51 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:210: T64
                {
                mT64(); 

                }
                break;
            case 52 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:214: T65
                {
                mT65(); 

                }
                break;
            case 53 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:218: T66
                {
                mT66(); 

                }
                break;
            case 54 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:222: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 55 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:231: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 56 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:242: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 57 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:255: RULE_COMMENT_ANNOTATION
                {
                mRULE_COMMENT_ANNOTATION(); 

                }
                break;
            case 58 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:279: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 59 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:295: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 60 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:303: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 61 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:315: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 62 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:331: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 63 :
                // ../de.cau.cs.kieler.s/src-gen/de/cau/cs/kieler/s/parser/antlr/internal/InternalS.g:1:339: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA7_eotS =
        "\5\uffff";
    static final String DFA7_eofS =
        "\5\uffff";
    static final String DFA7_minS =
        "\1\55\1\60\1\56\2\uffff";
    static final String DFA7_maxS =
        "\2\71\1\146\2\uffff";
    static final String DFA7_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA7_specialS =
        "\5\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\2\uffff\12\2",
            "\12\2",
            "\1\3\1\uffff\12\2\13\uffff\1\3\37\uffff\1\3\1\4",
            "",
            ""
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
            return "3831:14: ( ( RULE_INT '.' RULE_INT | RULE_INT ( '.' RULE_INT )? ( 'e' | 'E' ) ( '+' )? RULE_INT ) ( 'f' )? | RULE_INT 'f' )";
        }
    }
    static final String DFA5_eotS =
        "\6\uffff\1\7\1\uffff";
    static final String DFA5_eofS =
        "\10\uffff";
    static final String DFA5_minS =
        "\1\55\1\60\1\56\1\55\1\uffff\2\60\1\uffff";
    static final String DFA5_maxS =
        "\2\71\1\145\1\71\1\uffff\1\71\1\145\1\uffff";
    static final String DFA5_acceptS =
        "\4\uffff\1\2\2\uffff\1\1";
    static final String DFA5_specialS =
        "\10\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\2\uffff\12\2",
            "\12\2",
            "\1\3\1\uffff\12\2\13\uffff\1\4\37\uffff\1\4",
            "\1\5\2\uffff\12\6",
            "",
            "\12\6",
            "\12\6\13\uffff\1\4\37\uffff\1\4",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "3831:15: ( RULE_INT '.' RULE_INT | RULE_INT ( '.' RULE_INT )? ( 'e' | 'E' ) ( '+' )? RULE_INT )";
        }
    }
    static final String DFA20_eotS =
        "\1\uffff\1\62\2\uffff\1\66\1\uffff\13\62\3\uffff\3\62\2\uffff\1"+
        "\120\1\122\3\62\1\uffff\1\130\1\uffff\1\62\1\140\1\uffff\4\62\1"+
        "\147\1\62\1\57\1\uffff\2\57\2\uffff\2\62\6\uffff\2\62\1\161\12\62"+
        "\1\174\3\uffff\3\62\7\uffff\4\62\2\uffff\1\147\1\uffff\3\62\4\uffff"+
        "\5\62\2\uffff\1\62\2\uffff\2\62\1\u0092\2\62\1\uffff\12\62\1\uffff"+
        "\3\62\1\u00a2\1\62\1\u00a4\1\62\1\u00a6\1\u00a7\1\u00a8\1\u00a9"+
        "\2\uffff\10\62\1\uffff\4\62\1\u00b6\1\u00b7\1\62\1\u00b9\1\u00ba"+
        "\1\u00bb\2\62\1\u00be\1\u00c0\1\u00c1\1\uffff\1\u00c2\1\uffff\1"+
        "\u00c3\4\uffff\1\u00c4\3\62\1\u00c8\1\u00c9\2\62\1\u00cc\3\62\2"+
        "\uffff\1\u00d0\3\uffff\1\u00d1\1\u00d2\1\uffff\1\u00d3\5\uffff\1"+
        "\62\1\u00c9\1\u00d5\2\uffff\2\62\1\uffff\1\u00d8\1\u00d9\1\62\4"+
        "\uffff\1\62\1\uffff\1\u00dc\1\62\2\uffff\1\u00de\1\62\1\uffff\1"+
        "\62\1\uffff\1\u00e1\1\62\1\uffff\2\62\1\uffff";
    static final String DFA20_eofS =
        "\u00e5\uffff";
    static final String DFA20_minS =
        "\1\0\1\111\2\uffff\1\75\1\uffff\1\156\1\162\1\151\1\157\1\151\1"+
        "\101\1\105\1\141\1\117\1\102\1\106\3\uffff\2\117\1\115\2\uffff\2"+
        "\75\1\162\1\156\1\157\1\uffff\1\60\1\uffff\1\141\1\52\1\uffff\1"+
        "\157\1\156\1\141\1\157\1\56\1\162\1\101\1\uffff\2\0\2\uffff\1\107"+
        "\1\156\6\uffff\1\160\1\164\1\60\1\147\1\155\1\164\1\111\1\125\1"+
        "\122\1\154\1\111\1\117\1\101\1\60\3\uffff\1\124\1\122\1\111\7\uffff"+
        "\1\145\1\162\1\144\1\156\2\uffff\1\56\1\uffff\1\156\1\170\1\144"+
        "\1\0\3\uffff\1\157\1\163\1\154\1\157\1\163\2\uffff\1\165\2\uffff"+
        "\1\116\1\143\1\60\1\165\1\160\1\uffff\1\156\1\142\1\150\1\117\1"+
        "\123\1\115\1\164\1\116\1\122\1\111\1\uffff\1\117\1\113\1\124\1\60"+
        "\1\145\1\60\1\145\4\60\2\uffff\1\154\1\151\1\163\1\141\1\164\1\145"+
        "\1\101\1\150\1\uffff\1\164\1\165\1\141\1\151\2\60\1\105\3\60\2\124"+
        "\3\60\1\uffff\1\60\1\uffff\1\60\4\uffff\1\60\1\147\1\145\1\164\2"+
        "\60\1\114\1\162\1\60\1\164\1\154\1\156\2\uffff\1\60\3\uffff\2\60"+
        "\1\uffff\1\60\5\uffff\1\156\2\60\2\uffff\1\123\1\157\1\uffff\2\60"+
        "\1\145\4\uffff\1\145\1\uffff\1\60\1\156\2\uffff\1\60\1\144\1\uffff"+
        "\1\157\1\uffff\1\60\1\165\1\uffff\1\163\1\40\1\uffff";
    static final String DFA20_maxS =
        "\1\ufffe\1\171\2\uffff\1\75\1\uffff\1\156\1\165\1\151\1\157\1\151"+
        "\1\122\1\105\1\141\1\117\1\127\1\106\3\uffff\2\117\1\115\2\uffff"+
        "\1\76\1\75\1\165\1\156\1\157\1\uffff\1\71\1\uffff\1\157\1\57\1\uffff"+
        "\1\157\1\156\1\154\1\157\1\146\1\162\1\172\1\uffff\2\ufffe\2\uffff"+
        "\1\107\1\156\6\uffff\2\164\1\172\1\147\1\155\1\164\1\111\1\125\1"+
        "\122\1\154\1\111\1\117\1\101\1\172\3\uffff\1\124\1\122\1\111\7\uffff"+
        "\1\145\1\162\1\144\1\164\2\uffff\1\146\1\uffff\1\156\1\170\1\144"+
        "\1\ufffe\3\uffff\1\157\1\163\1\154\1\157\1\163\2\uffff\1\165\2\uffff"+
        "\1\116\1\143\1\172\1\165\1\160\1\uffff\1\156\1\142\1\150\1\117\1"+
        "\123\1\115\1\164\1\116\1\122\1\111\1\uffff\1\117\1\113\1\124\1\172"+
        "\1\145\1\172\1\145\4\172\2\uffff\1\154\1\151\1\163\1\141\1\164\1"+
        "\145\1\101\1\150\1\uffff\1\164\1\165\1\141\1\151\2\172\1\105\3\172"+
        "\2\124\3\172\1\uffff\1\172\1\uffff\1\172\4\uffff\1\172\1\147\1\145"+
        "\1\164\2\172\1\114\1\162\1\172\1\164\1\154\1\156\2\uffff\1\172\3"+
        "\uffff\2\172\1\uffff\1\172\5\uffff\1\156\2\172\2\uffff\1\123\1\157"+
        "\1\uffff\2\172\1\145\4\uffff\1\145\1\uffff\1\172\1\156\2\uffff\1"+
        "\172\1\144\1\uffff\1\157\1\uffff\1\172\1\165\1\uffff\1\163\1\40"+
        "\1\uffff";
    static final String DFA20_acceptS =
        "\2\uffff\1\2\1\3\1\uffff\1\6\13\uffff\1\23\1\24\1\25\3\uffff\1\34"+
        "\1\35\5\uffff\1\47\1\uffff\1\51\2\uffff\1\54\7\uffff\1\73\2\uffff"+
        "\1\76\1\77\2\uffff\1\73\1\2\1\3\1\12\1\4\1\6\16\uffff\1\23\1\24"+
        "\1\25\3\uffff\1\34\1\35\1\42\1\37\1\36\1\41\1\40\4\uffff\1\47\1"+
        "\50\1\uffff\1\51\4\uffff\1\75\1\53\1\54\5\uffff\1\66\1\67\1\uffff"+
        "\1\74\1\76\5\uffff\1\44\12\uffff\1\22\13\uffff\1\71\1\72\10\uffff"+
        "\1\60\17\uffff\1\43\1\uffff\1\45\1\uffff\1\46\1\65\1\64\1\52\14"+
        "\uffff\1\14\1\33\1\uffff\1\16\1\17\1\20\2\uffff\1\26\1\uffff\1\27"+
        "\1\31\1\55\1\63\1\56\3\uffff\1\62\1\70\2\uffff\1\7\3\uffff\1\15"+
        "\1\21\1\32\1\30\1\uffff\1\61\2\uffff\1\10\1\11\2\uffff\1\5\1\uffff"+
        "\1\13\2\uffff\1\57\2\uffff\1\1";
    static final String DFA20_specialS =
        "\u00e5\uffff}>";
    static final String[] DFA20_transitionS = {
            "\11\57\2\56\2\57\1\56\22\57\1\56\1\57\1\54\4\57\1\55\1\2\1\3"+
            "\1\40\1\36\1\21\1\37\1\57\1\42\12\50\1\4\1\5\1\31\1\30\1\32"+
            "\1\43\1\27\1\17\3\53\1\26\1\25\1\24\1\15\1\20\1\16\5\53\1\13"+
            "\2\53\1\1\1\14\6\53\3\57\1\52\1\53\1\57\1\34\1\44\1\11\2\53"+
            "\1\46\1\53\1\47\1\6\3\53\1\41\1\35\1\7\1\33\2\53\1\10\1\51\1"+
            "\45\1\53\1\12\3\53\1\22\1\57\1\23\uff81\57",
            "\1\60\57\uffff\1\61",
            "",
            "",
            "\1\65",
            "",
            "\1\70",
            "\1\72\2\uffff\1\71",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\77\20\uffff\1\76",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103\24\uffff\1\104",
            "\1\105",
            "",
            "",
            "",
            "\1\111",
            "\1\112",
            "\1\113",
            "",
            "",
            "\1\117\1\116",
            "\1\121",
            "\1\123\2\uffff\1\124",
            "\1\125",
            "\1\126",
            "",
            "\12\131",
            "",
            "\1\134\7\uffff\1\133\5\uffff\1\135",
            "\1\136\4\uffff\1\137",
            "",
            "\1\142",
            "\1\143",
            "\1\144\12\uffff\1\145",
            "\1\146",
            "\1\150\1\uffff\12\131\13\uffff\1\150\37\uffff\2\150",
            "\1\151",
            "\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\uffff\152",
            "\uffff\152",
            "",
            "",
            "\1\154",
            "\1\155",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\157\3\uffff\1\156",
            "\1\160",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "\1\175",
            "\1\176",
            "\1\177",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083\5\uffff\1\u0084",
            "",
            "",
            "\1\150\1\uffff\12\131\13\uffff\1\150\37\uffff\2\150",
            "",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\52\u0089\1\u0088\uffd4\u0089",
            "",
            "",
            "",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "",
            "",
            "\1\u008f",
            "",
            "",
            "\1\u0090",
            "\1\u0091",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0093",
            "\1\u0094",
            "",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00a3",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00a5",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00b8",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00bc",
            "\1\u00bd",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\4\62\1\u00bf\25\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00ca",
            "\1\u00cb",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "",
            "",
            "\1\u00d4",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\1\u00d6",
            "\1\u00d7",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00da",
            "",
            "",
            "",
            "",
            "\1\u00db",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00dd",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00df",
            "",
            "\1\u00e0",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00e2",
            "",
            "\1\u00e3",
            "\1\u00e4",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | RULE_INT | RULE_FLOAT | RULE_BOOLEAN | RULE_COMMENT_ANNOTATION | RULE_ML_COMMENT | RULE_ID | RULE_STRING | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
    }
 

}