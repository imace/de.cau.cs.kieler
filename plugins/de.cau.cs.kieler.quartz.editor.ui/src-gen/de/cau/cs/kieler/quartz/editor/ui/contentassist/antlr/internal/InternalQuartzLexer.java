package de.cau.cs.kieler.quartz.editor.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalQuartzLexer extends Lexer {
    public static final int T114=114;
    public static final int T115=115;
    public static final int T116=116;
    public static final int RULE_ID=9;
    public static final int T117=117;
    public static final int T118=118;
    public static final int T119=119;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int T38=38;
    public static final int T37=37;
    public static final int RULE_NATCONST=7;
    public static final int T39=39;
    public static final int T34=34;
    public static final int T33=33;
    public static final int T36=36;
    public static final int T35=35;
    public static final int T30=30;
    public static final int T32=32;
    public static final int T31=31;
    public static final int T49=49;
    public static final int T48=48;
    public static final int T100=100;
    public static final int T43=43;
    public static final int T42=42;
    public static final int T102=102;
    public static final int T41=41;
    public static final int T101=101;
    public static final int T40=40;
    public static final int T47=47;
    public static final int T46=46;
    public static final int RULE_ML_COMMENT=10;
    public static final int T45=45;
    public static final int T44=44;
    public static final int T109=109;
    public static final int T107=107;
    public static final int T108=108;
    public static final int T105=105;
    public static final int T106=106;
    public static final int T103=103;
    public static final int T104=104;
    public static final int T50=50;
    public static final int T59=59;
    public static final int T113=113;
    public static final int T52=52;
    public static final int T112=112;
    public static final int T51=51;
    public static final int T111=111;
    public static final int T54=54;
    public static final int T110=110;
    public static final int T53=53;
    public static final int T56=56;
    public static final int T55=55;
    public static final int T58=58;
    public static final int T57=57;
    public static final int T75=75;
    public static final int T76=76;
    public static final int T73=73;
    public static final int T74=74;
    public static final int T79=79;
    public static final int T77=77;
    public static final int T78=78;
    public static final int RULE_BVCONST=4;
    public static final int RULE_REALCONST=8;
    public static final int RULE_HEXCONST=6;
    public static final int T72=72;
    public static final int T71=71;
    public static final int T70=70;
    public static final int T62=62;
    public static final int T63=63;
    public static final int T64=64;
    public static final int T65=65;
    public static final int T66=66;
    public static final int T67=67;
    public static final int T68=68;
    public static final int T69=69;
    public static final int T61=61;
    public static final int T60=60;
    public static final int T99=99;
    public static final int T97=97;
    public static final int T98=98;
    public static final int T95=95;
    public static final int T96=96;
    public static final int RULE_OCTCONST=5;
    public static final int T94=94;
    public static final int Tokens=120;
    public static final int T93=93;
    public static final int RULE_SL_COMMENT=11;
    public static final int T92=92;
    public static final int T91=91;
    public static final int T90=90;
    public static final int T88=88;
    public static final int T89=89;
    public static final int T84=84;
    public static final int T85=85;
    public static final int T86=86;
    public static final int T87=87;
    public static final int T13=13;
    public static final int T14=14;
    public static final int RULE_WS=12;
    public static final int T15=15;
    public static final int T81=81;
    public static final int T16=16;
    public static final int T80=80;
    public static final int T17=17;
    public static final int T83=83;
    public static final int T18=18;
    public static final int T82=82;
    public static final int T19=19;
    public InternalQuartzLexer() {;} 
    public InternalQuartzLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g"; }

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:10:5: ( 'event' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:10:7: 'event'
            {
            match("event"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:11:5: ( 'mem' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:11:7: 'mem'
            {
            match("mem"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:12:5: ( 'bool' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:12:7: 'bool'
            {
            match("bool"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:13:5: ( 'real' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:13:7: 'real'
            {
            match("real"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14:5: ( 'bv' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14:7: 'bv'
            {
            match("bv"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:15:5: ( 'nat' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:15:7: 'nat'
            {
            match("nat"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:16:5: ( 'int' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:16:7: 'int'
            {
            match("int"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:17:5: ( '?' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:17:7: '?'
            {
            match('?'); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:18:5: ( '!' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:18:7: '!'
            {
            match('!'); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:19:5: ( 'mu' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:19:7: 'mu'
            {
            match("mu"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:20:5: ( 'nu' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:20:7: 'nu'
            {
            match("nu"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:21:5: ( '_' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:21:7: '_'
            {
            match('_'); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:22:5: ( 'instant' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:22:7: 'instant'
            {
            match("instant"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:23:5: ( 'inside' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:23:7: 'inside'
            {
            match("inside"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:24:5: ( 'terminate' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:24:7: 'terminate'
            {
            match("terminate"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:25:5: ( 'true' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:25:7: 'true'
            {
            match("true"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:26:5: ( 'false' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:26:7: 'false'
            {
            match("false"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:27:5: ( '||' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:27:7: '||'
            {
            match("||"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:28:5: ( '|||' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:28:7: '|||'
            {
            match("|||"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:29:5: ( '&&' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:29:7: '&&'
            {
            match("&&"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:30:5: ( '&&&' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:30:7: '&&&'
            {
            match("&&&"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:31:5: ( 'during' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:31:7: 'during'
            {
            match("during"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:32:5: ( 'final' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:32:7: 'final'
            {
            match("final"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:33:5: ( 'not' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:33:7: 'not'
            {
            match("not"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:34:5: ( '&' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:34:7: '&'
            {
            match('&'); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:35:5: ( 'and' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:35:7: 'and'
            {
            match("and"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:36:5: ( '|' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:36:7: '|'
            {
            match('|'); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:37:5: ( 'or' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:37:7: 'or'
            {
            match("or"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:38:5: ( 'package' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:38:7: 'package'
            {
            match("package"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:39:5: ( ';' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:39:7: ';'
            {
            match(';'); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:40:5: ( 'import' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:40:7: 'import'
            {
            match("import"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:41:5: ( '.' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:41:7: '.'
            {
            match('.'); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:42:5: ( 'macro' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:42:7: 'macro'
            {
            match("macro"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:43:5: ( '(' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:43:7: '('
            {
            match('('); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:44:5: ( ')' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:44:7: ')'
            {
            match(')'); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:45:5: ( '=' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:45:7: '='
            {
            match('='); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:46:5: ( 'module' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:46:7: 'module'
            {
            match("module"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:47:5: ( ',' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:47:7: ','
            {
            match(','); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:48:5: ( '{' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:48:7: '{'
            {
            match('{'); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:49:5: ( '}' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:49:7: '}'
            {
            match('}'); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:50:5: ( '[' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:50:7: '['
            {
            match('['); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:51:5: ( ']' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:51:7: ']'
            {
            match(']'); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:52:5: ( '+' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:52:7: '+'
            {
            match('+'); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:53:5: ( '-' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:53:7: '-'
            {
            match('-'); 

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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:54:5: ( 'abs' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:54:7: 'abs'
            {
            match("abs"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:55:5: ( 'sat' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:55:7: 'sat'
            {
            match("sat"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:56:5: ( 'der' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:56:7: 'der'
            {
            match("der"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:57:5: ( 'reverse' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:57:7: 'reverse'
            {
            match("reverse"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:58:5: ( '::' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:58:7: '::'
            {
            match("::"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:59:5: ( 'next' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:59:7: 'next'
            {
            match("next"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:60:5: ( 'nat2bv' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:60:7: 'nat2bv'
            {
            match("nat2bv"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:61:5: ( 'int2bv' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:61:7: 'int2bv'
            {
            match("int2bv"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:62:5: ( 'arr2bv' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:62:7: 'arr2bv'
            {
            match("arr2bv"); 


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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:63:5: ( 'tup2bv' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:63:7: 'tup2bv'
            {
            match("tup2bv"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T66

    // $ANTLR start T67
    public final void mT67() throws RecognitionException {
        try {
            int _type = T67;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:64:5: ( 'bv2nat' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:64:7: 'bv2nat'
            {
            match("bv2nat"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T67

    // $ANTLR start T68
    public final void mT68() throws RecognitionException {
        try {
            int _type = T68;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:65:5: ( 'bv2int' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:65:7: 'bv2int'
            {
            match("bv2int"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T68

    // $ANTLR start T69
    public final void mT69() throws RecognitionException {
        try {
            int _type = T69;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:66:5: ( 'nat2real' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:66:7: 'nat2real'
            {
            match("nat2real"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T69

    // $ANTLR start T70
    public final void mT70() throws RecognitionException {
        try {
            int _type = T70;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:67:5: ( 'int2real' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:67:7: 'int2real'
            {
            match("int2real"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T70

    // $ANTLR start T71
    public final void mT71() throws RecognitionException {
        try {
            int _type = T71;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:68:5: ( 'sin' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:68:7: 'sin'
            {
            match("sin"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T71

    // $ANTLR start T72
    public final void mT72() throws RecognitionException {
        try {
            int _type = T72;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:69:5: ( 'cos' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:69:7: 'cos'
            {
            match("cos"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T72

    // $ANTLR start T73
    public final void mT73() throws RecognitionException {
        try {
            int _type = T73;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:70:5: ( 'exp' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:70:7: 'exp'
            {
            match("exp"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T73

    // $ANTLR start T74
    public final void mT74() throws RecognitionException {
        try {
            int _type = T74;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:71:5: ( 'log' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:71:7: 'log'
            {
            match("log"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T74

    // $ANTLR start T75
    public final void mT75() throws RecognitionException {
        try {
            int _type = T75;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:72:5: ( 'sizeOf' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:72:7: 'sizeOf'
            {
            match("sizeOf"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T75

    // $ANTLR start T76
    public final void mT76() throws RecognitionException {
        try {
            int _type = T76;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:73:5: ( 'forall' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:73:7: 'forall'
            {
            match("forall"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T76

    // $ANTLR start T77
    public final void mT77() throws RecognitionException {
        try {
            int _type = T77;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:74:5: ( 'exists' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:74:7: 'exists'
            {
            match("exists"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T77

    // $ANTLR start T78
    public final void mT78() throws RecognitionException {
        try {
            int _type = T78;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:75:5: ( 'sum' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:75:7: 'sum'
            {
            match("sum"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T78

    // $ANTLR start T79
    public final void mT79() throws RecognitionException {
        try {
            int _type = T79;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:76:5: ( 'X' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:76:7: 'X'
            {
            match('X'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T79

    // $ANTLR start T80
    public final void mT80() throws RecognitionException {
        try {
            int _type = T80;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:77:5: ( 'G' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:77:7: 'G'
            {
            match('G'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T80

    // $ANTLR start T81
    public final void mT81() throws RecognitionException {
        try {
            int _type = T81;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:78:5: ( 'F' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:78:7: 'F'
            {
            match('F'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T81

    // $ANTLR start T82
    public final void mT82() throws RecognitionException {
        try {
            int _type = T82;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:79:5: ( 'PA' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:79:7: 'PA'
            {
            match("PA"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T82

    // $ANTLR start T83
    public final void mT83() throws RecognitionException {
        try {
            int _type = T83;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:80:5: ( 'PF' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:80:7: 'PF'
            {
            match("PF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T83

    // $ANTLR start T84
    public final void mT84() throws RecognitionException {
        try {
            int _type = T84;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:81:5: ( 'PSX' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:81:7: 'PSX'
            {
            match("PSX"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T84

    // $ANTLR start T85
    public final void mT85() throws RecognitionException {
        try {
            int _type = T85;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:82:5: ( 'PMX' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:82:7: 'PMX'
            {
            match("PMX"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T85

    // $ANTLR start T86
    public final void mT86() throws RecognitionException {
        try {
            int _type = T86;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:83:5: ( 'E' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:83:7: 'E'
            {
            match('E'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T86

    // $ANTLR start T87
    public final void mT87() throws RecognitionException {
        try {
            int _type = T87;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:84:5: ( 'A' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:84:7: 'A'
            {
            match('A'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T87

    // $ANTLR start T88
    public final void mT88() throws RecognitionException {
        try {
            int _type = T88;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:85:5: ( '[]' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:85:7: '[]'
            {
            match("[]"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T88

    // $ANTLR start T89
    public final void mT89() throws RecognitionException {
        try {
            int _type = T89;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:86:5: ( '<>' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:86:7: '<>'
            {
            match("<>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T89

    // $ANTLR start T90
    public final void mT90() throws RecognitionException {
        try {
            int _type = T90;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:87:5: ( '[:]' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:87:7: '[:]'
            {
            match("[:]"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T90

    // $ANTLR start T91
    public final void mT91() throws RecognitionException {
        try {
            int _type = T91;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:88:5: ( '<:>' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:88:7: '<:>'
            {
            match("<:>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T91

    // $ANTLR start T92
    public final void mT92() throws RecognitionException {
        try {
            int _type = T92;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:89:5: ( 'fixpoints' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:89:7: 'fixpoints'
            {
            match("fixpoints"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T92

    // $ANTLR start T93
    public final void mT93() throws RecognitionException {
        try {
            int _type = T93;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:90:5: ( 'in' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:90:7: 'in'
            {
            match("in"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T93

    // $ANTLR start T94
    public final void mT94() throws RecognitionException {
        try {
            int _type = T94;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:91:5: ( ':' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:91:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T94

    // $ANTLR start T95
    public final void mT95() throws RecognitionException {
        try {
            int _type = T95;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:92:5: ( 'emit' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:92:7: 'emit'
            {
            match("emit"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T95

    // $ANTLR start T96
    public final void mT96() throws RecognitionException {
        try {
            int _type = T96;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:93:5: ( '<-' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:93:7: '<-'
            {
            match("<-"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T96

    // $ANTLR start T97
    public final void mT97() throws RecognitionException {
        try {
            int _type = T97;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:94:5: ( 'assume' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:94:7: 'assume'
            {
            match("assume"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T97

    // $ANTLR start T98
    public final void mT98() throws RecognitionException {
        try {
            int _type = T98;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:95:5: ( 'assert' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:95:7: 'assert'
            {
            match("assert"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T98

    // $ANTLR start T99
    public final void mT99() throws RecognitionException {
        try {
            int _type = T99;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:96:5: ( 'do' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:96:7: 'do'
            {
            match("do"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T99

    // $ANTLR start T100
    public final void mT100() throws RecognitionException {
        try {
            int _type = T100;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:97:6: ( '..' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:97:8: '..'
            {
            match(".."); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T100

    // $ANTLR start T101
    public final void mT101() throws RecognitionException {
        try {
            int _type = T101;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:98:6: ( 'nothing' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:98:8: 'nothing'
            {
            match("nothing"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T101

    // $ANTLR start T102
    public final void mT102() throws RecognitionException {
        try {
            int _type = T102;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:99:6: ( 'weak' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:99:8: 'weak'
            {
            match("weak"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T102

    // $ANTLR start T103
    public final void mT103() throws RecognitionException {
        try {
            int _type = T103;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:100:6: ( 'immediate' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:100:8: 'immediate'
            {
            match("immediate"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T103

    // $ANTLR start T104
    public final void mT104() throws RecognitionException {
        try {
            int _type = T104;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:101:6: ( 'abort' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:101:8: 'abort'
            {
            match("abort"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T104

    // $ANTLR start T105
    public final void mT105() throws RecognitionException {
        try {
            int _type = T105;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:102:6: ( 'when' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:102:8: 'when'
            {
            match("when"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T105

    // $ANTLR start T106
    public final void mT106() throws RecognitionException {
        try {
            int _type = T106;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:103:6: ( 'abstract' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:103:8: 'abstract'
            {
            match("abstract"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T106

    // $ANTLR start T107
    public final void mT107() throws RecognitionException {
        try {
            int _type = T107;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:104:6: ( 'case' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:104:8: 'case'
            {
            match("case"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T107

    // $ANTLR start T108
    public final void mT108() throws RecognitionException {
        try {
            int _type = T108;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:105:6: ( 'default' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:105:8: 'default'
            {
            match("default"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T108

    // $ANTLR start T109
    public final void mT109() throws RecognitionException {
        try {
            int _type = T109;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:106:6: ( 'choose' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:106:8: 'choose'
            {
            match("choose"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T109

    // $ANTLR start T110
    public final void mT110() throws RecognitionException {
        try {
            int _type = T110;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:107:6: ( 'while' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:107:8: 'while'
            {
            match("while"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T110

    // $ANTLR start T111
    public final void mT111() throws RecognitionException {
        try {
            int _type = T111;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:108:6: ( 'for' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:108:8: 'for'
            {
            match("for"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T111

    // $ANTLR start T112
    public final void mT112() throws RecognitionException {
        try {
            int _type = T112;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:109:6: ( 'if' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:109:8: 'if'
            {
            match("if"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T112

    // $ANTLR start T113
    public final void mT113() throws RecognitionException {
        try {
            int _type = T113;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:110:6: ( 'else' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:110:8: 'else'
            {
            match("else"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T113

    // $ANTLR start T114
    public final void mT114() throws RecognitionException {
        try {
            int _type = T114;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:111:6: ( 'let' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:111:8: 'let'
            {
            match("let"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T114

    // $ANTLR start T115
    public final void mT115() throws RecognitionException {
        try {
            int _type = T115;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:112:6: ( 'loop' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:112:8: 'loop'
            {
            match("loop"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T115

    // $ANTLR start T116
    public final void mT116() throws RecognitionException {
        try {
            int _type = T116;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:113:6: ( 'pause' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:113:8: 'pause'
            {
            match("pause"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T116

    // $ANTLR start T117
    public final void mT117() throws RecognitionException {
        try {
            int _type = T117;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:114:6: ( 'halt' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:114:8: 'halt'
            {
            match("halt"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T117

    // $ANTLR start T118
    public final void mT118() throws RecognitionException {
        try {
            int _type = T118;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:115:6: ( 'every' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:115:8: 'every'
            {
            match("every"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T118

    // $ANTLR start T119
    public final void mT119() throws RecognitionException {
        try {
            int _type = T119;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:116:6: ( '.*' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:116:8: '.*'
            {
            match(".*"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T119

    // $ANTLR start RULE_BVCONST
    public final void mRULE_BVCONST() throws RecognitionException {
        try {
            int _type = RULE_BVCONST;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14693:14: ( '0b' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14693:16: '0b'
            {
            match("0b"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_BVCONST

    // $ANTLR start RULE_OCTCONST
    public final void mRULE_OCTCONST() throws RecognitionException {
        try {
            int _type = RULE_OCTCONST;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14695:15: ( '0o' ( '0' .. '7' )+ )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14695:17: '0o' ( '0' .. '7' )+
            {
            match("0o"); 

            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14695:22: ( '0' .. '7' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='7')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14695:23: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_OCTCONST

    // $ANTLR start RULE_HEXCONST
    public final void mRULE_HEXCONST() throws RecognitionException {
        try {
            int _type = RULE_HEXCONST;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14697:15: ( '0x' ( '0' .. '9' | 'A' .. 'F' )+ )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14697:17: '0x' ( '0' .. '9' | 'A' .. 'F' )+
            {
            match("0x"); 

            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14697:22: ( '0' .. '9' | 'A' .. 'F' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='F')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F') ) {
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
    // $ANTLR end RULE_HEXCONST

    // $ANTLR start RULE_NATCONST
    public final void mRULE_NATCONST() throws RecognitionException {
        try {
            int _type = RULE_NATCONST;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14699:15: ( ( '0' .. '9' )* )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14699:17: ( '0' .. '9' )*
            {
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14699:17: ( '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14699:18: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_NATCONST

    // $ANTLR start RULE_REALCONST
    public final void mRULE_REALCONST() throws RecognitionException {
        try {
            int _type = RULE_REALCONST;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14701:16: ( ( '+' | '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ ( 'e' ( '+' | '-' )? ( '0' .. '9' )+ )? )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14701:18: ( '+' | '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ ( 'e' ( '+' | '-' )? ( '0' .. '9' )+ )?
            {
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14701:18: ( '+' | '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='+'||LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14701:29: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14701:30: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            match('.'); 
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14701:45: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14701:46: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14701:57: ( 'e' ( '+' | '-' )? ( '0' .. '9' )+ )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='e') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14701:58: 'e' ( '+' | '-' )? ( '0' .. '9' )+
                    {
                    match('e'); 
                    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14701:62: ( '+' | '-' )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='+'||LA7_0=='-') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recover(mse);    throw mse;
                            }


                            }
                            break;

                    }

                    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14701:73: ( '0' .. '9' )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14701:74: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_REALCONST

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14703:9: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )* )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14703:11: ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14703:31: ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')||(LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='a' && LA11_0<='z')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14703:32: ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )
            	    {
            	    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14703:32: ( '_' )?
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0=='_') ) {
            	        alt10=1;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14703:32: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
            	    break loop11;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14705:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14705:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14705:24: ( options {greedy=false; } : . )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='*') ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1=='/') ) {
                        alt12=2;
                    }
                    else if ( ((LA12_1>='\u0000' && LA12_1<='.')||(LA12_1>='0' && LA12_1<='\uFFFE')) ) {
                        alt12=1;
                    }


                }
                else if ( ((LA12_0>='\u0000' && LA12_0<=')')||(LA12_0>='+' && LA12_0<='\uFFFE')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14705:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop12;
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

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14707:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14707:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14707:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFE')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14707:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop13;
                }
            } while (true);

            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14707:40: ( ( '\\r' )? '\\n' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14707:41: ( '\\r' )? '\\n'
                    {
                    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14707:41: ( '\\r' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\r') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14707:41: '\\r'
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
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14709:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14709:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:14709:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:
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
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    public void mTokens() throws RecognitionException {
        // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:8: ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | T62 | T63 | T64 | T65 | T66 | T67 | T68 | T69 | T70 | T71 | T72 | T73 | T74 | T75 | T76 | T77 | T78 | T79 | T80 | T81 | T82 | T83 | T84 | T85 | T86 | T87 | T88 | T89 | T90 | T91 | T92 | T93 | T94 | T95 | T96 | T97 | T98 | T99 | T100 | T101 | T102 | T103 | T104 | T105 | T106 | T107 | T108 | T109 | T110 | T111 | T112 | T113 | T114 | T115 | T116 | T117 | T118 | T119 | RULE_BVCONST | RULE_OCTCONST | RULE_HEXCONST | RULE_NATCONST | RULE_REALCONST | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS )
        int alt17=116;
        switch ( input.LA(1) ) {
        case 'e':
            {
            alt17=1;
            }
            break;
        case 'm':
            {
            alt17=2;
            }
            break;
        case 'b':
            {
            alt17=3;
            }
            break;
        case 'r':
            {
            alt17=4;
            }
            break;
        case 'n':
            {
            alt17=6;
            }
            break;
        case 'i':
            {
            alt17=7;
            }
            break;
        case '?':
            {
            alt17=8;
            }
            break;
        case '!':
            {
            alt17=9;
            }
            break;
        case '_':
            {
            alt17=12;
            }
            break;
        case 't':
            {
            alt17=15;
            }
            break;
        case 'f':
            {
            alt17=17;
            }
            break;
        case '|':
            {
            alt17=18;
            }
            break;
        case '&':
            {
            alt17=20;
            }
            break;
        case 'd':
            {
            alt17=22;
            }
            break;
        case 'a':
            {
            alt17=26;
            }
            break;
        case 'o':
            {
            alt17=28;
            }
            break;
        case 'p':
            {
            alt17=29;
            }
            break;
        case ';':
            {
            alt17=30;
            }
            break;
        case '.':
            {
            alt17=32;
            }
            break;
        case '(':
            {
            alt17=34;
            }
            break;
        case ')':
            {
            alt17=35;
            }
            break;
        case '=':
            {
            alt17=36;
            }
            break;
        case ',':
            {
            alt17=38;
            }
            break;
        case '{':
            {
            alt17=39;
            }
            break;
        case '}':
            {
            alt17=40;
            }
            break;
        case '[':
            {
            alt17=41;
            }
            break;
        case ']':
            {
            alt17=42;
            }
            break;
        case '+':
            {
            alt17=43;
            }
            break;
        case '-':
            {
            alt17=44;
            }
            break;
        case 's':
            {
            alt17=46;
            }
            break;
        case ':':
            {
            alt17=49;
            }
            break;
        case 'c':
            {
            alt17=60;
            }
            break;
        case 'l':
            {
            alt17=62;
            }
            break;
        case 'X':
            {
            alt17=67;
            }
            break;
        case 'G':
            {
            alt17=68;
            }
            break;
        case 'F':
            {
            alt17=69;
            }
            break;
        case 'P':
            {
            alt17=70;
            }
            break;
        case 'E':
            {
            alt17=74;
            }
            break;
        case 'A':
            {
            alt17=75;
            }
            break;
        case '<':
            {
            alt17=77;
            }
            break;
        case 'w':
            {
            alt17=90;
            }
            break;
        case 'h':
            {
            alt17=105;
            }
            break;
        case '0':
            {
            alt17=108;
            }
            break;
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
            alt17=111;
            }
            break;
        case 'B':
        case 'C':
        case 'D':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'Y':
        case 'Z':
        case 'g':
        case 'j':
        case 'k':
        case 'q':
        case 'u':
        case 'v':
        case 'x':
        case 'y':
        case 'z':
            {
            alt17=113;
            }
            break;
        case '/':
            {
            alt17=114;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt17=116;
            }
            break;
        default:
            alt17=111;}

        switch (alt17) {
            case 1 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:10: T13
                {
                mT13(); 

                }
                break;
            case 2 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:14: T14
                {
                mT14(); 

                }
                break;
            case 3 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:18: T15
                {
                mT15(); 

                }
                break;
            case 4 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:22: T16
                {
                mT16(); 

                }
                break;
            case 5 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:26: T17
                {
                mT17(); 

                }
                break;
            case 6 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:30: T18
                {
                mT18(); 

                }
                break;
            case 7 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:34: T19
                {
                mT19(); 

                }
                break;
            case 8 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:38: T20
                {
                mT20(); 

                }
                break;
            case 9 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:42: T21
                {
                mT21(); 

                }
                break;
            case 10 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:46: T22
                {
                mT22(); 

                }
                break;
            case 11 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:50: T23
                {
                mT23(); 

                }
                break;
            case 12 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:54: T24
                {
                mT24(); 

                }
                break;
            case 13 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:58: T25
                {
                mT25(); 

                }
                break;
            case 14 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:62: T26
                {
                mT26(); 

                }
                break;
            case 15 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:66: T27
                {
                mT27(); 

                }
                break;
            case 16 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:70: T28
                {
                mT28(); 

                }
                break;
            case 17 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:74: T29
                {
                mT29(); 

                }
                break;
            case 18 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:78: T30
                {
                mT30(); 

                }
                break;
            case 19 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:82: T31
                {
                mT31(); 

                }
                break;
            case 20 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:86: T32
                {
                mT32(); 

                }
                break;
            case 21 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:90: T33
                {
                mT33(); 

                }
                break;
            case 22 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:94: T34
                {
                mT34(); 

                }
                break;
            case 23 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:98: T35
                {
                mT35(); 

                }
                break;
            case 24 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:102: T36
                {
                mT36(); 

                }
                break;
            case 25 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:106: T37
                {
                mT37(); 

                }
                break;
            case 26 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:110: T38
                {
                mT38(); 

                }
                break;
            case 27 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:114: T39
                {
                mT39(); 

                }
                break;
            case 28 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:118: T40
                {
                mT40(); 

                }
                break;
            case 29 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:122: T41
                {
                mT41(); 

                }
                break;
            case 30 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:126: T42
                {
                mT42(); 

                }
                break;
            case 31 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:130: T43
                {
                mT43(); 

                }
                break;
            case 32 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:134: T44
                {
                mT44(); 

                }
                break;
            case 33 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:138: T45
                {
                mT45(); 

                }
                break;
            case 34 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:142: T46
                {
                mT46(); 

                }
                break;
            case 35 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:146: T47
                {
                mT47(); 

                }
                break;
            case 36 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:150: T48
                {
                mT48(); 

                }
                break;
            case 37 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:154: T49
                {
                mT49(); 

                }
                break;
            case 38 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:158: T50
                {
                mT50(); 

                }
                break;
            case 39 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:162: T51
                {
                mT51(); 

                }
                break;
            case 40 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:166: T52
                {
                mT52(); 

                }
                break;
            case 41 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:170: T53
                {
                mT53(); 

                }
                break;
            case 42 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:174: T54
                {
                mT54(); 

                }
                break;
            case 43 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:178: T55
                {
                mT55(); 

                }
                break;
            case 44 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:182: T56
                {
                mT56(); 

                }
                break;
            case 45 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:186: T57
                {
                mT57(); 

                }
                break;
            case 46 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:190: T58
                {
                mT58(); 

                }
                break;
            case 47 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:194: T59
                {
                mT59(); 

                }
                break;
            case 48 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:198: T60
                {
                mT60(); 

                }
                break;
            case 49 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:202: T61
                {
                mT61(); 

                }
                break;
            case 50 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:206: T62
                {
                mT62(); 

                }
                break;
            case 51 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:210: T63
                {
                mT63(); 

                }
                break;
            case 52 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:214: T64
                {
                mT64(); 

                }
                break;
            case 53 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:218: T65
                {
                mT65(); 

                }
                break;
            case 54 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:222: T66
                {
                mT66(); 

                }
                break;
            case 55 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:226: T67
                {
                mT67(); 

                }
                break;
            case 56 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:230: T68
                {
                mT68(); 

                }
                break;
            case 57 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:234: T69
                {
                mT69(); 

                }
                break;
            case 58 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:238: T70
                {
                mT70(); 

                }
                break;
            case 59 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:242: T71
                {
                mT71(); 

                }
                break;
            case 60 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:246: T72
                {
                mT72(); 

                }
                break;
            case 61 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:250: T73
                {
                mT73(); 

                }
                break;
            case 62 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:254: T74
                {
                mT74(); 

                }
                break;
            case 63 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:258: T75
                {
                mT75(); 

                }
                break;
            case 64 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:262: T76
                {
                mT76(); 

                }
                break;
            case 65 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:266: T77
                {
                mT77(); 

                }
                break;
            case 66 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:270: T78
                {
                mT78(); 

                }
                break;
            case 67 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:274: T79
                {
                mT79(); 

                }
                break;
            case 68 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:278: T80
                {
                mT80(); 

                }
                break;
            case 69 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:282: T81
                {
                mT81(); 

                }
                break;
            case 70 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:286: T82
                {
                mT82(); 

                }
                break;
            case 71 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:290: T83
                {
                mT83(); 

                }
                break;
            case 72 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:294: T84
                {
                mT84(); 

                }
                break;
            case 73 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:298: T85
                {
                mT85(); 

                }
                break;
            case 74 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:302: T86
                {
                mT86(); 

                }
                break;
            case 75 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:306: T87
                {
                mT87(); 

                }
                break;
            case 76 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:310: T88
                {
                mT88(); 

                }
                break;
            case 77 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:314: T89
                {
                mT89(); 

                }
                break;
            case 78 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:318: T90
                {
                mT90(); 

                }
                break;
            case 79 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:322: T91
                {
                mT91(); 

                }
                break;
            case 80 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:326: T92
                {
                mT92(); 

                }
                break;
            case 81 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:330: T93
                {
                mT93(); 

                }
                break;
            case 82 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:334: T94
                {
                mT94(); 

                }
                break;
            case 83 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:338: T95
                {
                mT95(); 

                }
                break;
            case 84 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:342: T96
                {
                mT96(); 

                }
                break;
            case 85 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:346: T97
                {
                mT97(); 

                }
                break;
            case 86 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:350: T98
                {
                mT98(); 

                }
                break;
            case 87 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:354: T99
                {
                mT99(); 

                }
                break;
            case 88 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:358: T100
                {
                mT100(); 

                }
                break;
            case 89 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:363: T101
                {
                mT101(); 

                }
                break;
            case 90 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:368: T102
                {
                mT102(); 

                }
                break;
            case 91 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:373: T103
                {
                mT103(); 

                }
                break;
            case 92 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:378: T104
                {
                mT104(); 

                }
                break;
            case 93 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:383: T105
                {
                mT105(); 

                }
                break;
            case 94 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:388: T106
                {
                mT106(); 

                }
                break;
            case 95 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:393: T107
                {
                mT107(); 

                }
                break;
            case 96 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:398: T108
                {
                mT108(); 

                }
                break;
            case 97 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:403: T109
                {
                mT109(); 

                }
                break;
            case 98 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:408: T110
                {
                mT110(); 

                }
                break;
            case 99 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:413: T111
                {
                mT111(); 

                }
                break;
            case 100 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:418: T112
                {
                mT112(); 

                }
                break;
            case 101 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:423: T113
                {
                mT113(); 

                }
                break;
            case 102 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:428: T114
                {
                mT114(); 

                }
                break;
            case 103 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:433: T115
                {
                mT115(); 

                }
                break;
            case 104 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:438: T116
                {
                mT116(); 

                }
                break;
            case 105 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:443: T117
                {
                mT117(); 

                }
                break;
            case 106 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:448: T118
                {
                mT118(); 

                }
                break;
            case 107 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:453: T119
                {
                mT119(); 

                }
                break;
            case 108 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:458: RULE_BVCONST
                {
                mRULE_BVCONST(); 

                }
                break;
            case 109 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:471: RULE_OCTCONST
                {
                mRULE_OCTCONST(); 

                }
                break;
            case 110 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:485: RULE_HEXCONST
                {
                mRULE_HEXCONST(); 

                }
                break;
            case 111 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:499: RULE_NATCONST
                {
                mRULE_NATCONST(); 

                }
                break;
            case 112 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:513: RULE_REALCONST
                {
                mRULE_REALCONST(); 

                }
                break;
            case 113 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:528: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 114 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:536: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 115 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:552: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 116 :
                // ../de.cau.cs.kieler.quartz.editor.ui/src-gen/de/cau/cs/kieler/quartz/editor/ui/contentassist/antlr/internal/InternalQuartz.g:1:568: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


 

}