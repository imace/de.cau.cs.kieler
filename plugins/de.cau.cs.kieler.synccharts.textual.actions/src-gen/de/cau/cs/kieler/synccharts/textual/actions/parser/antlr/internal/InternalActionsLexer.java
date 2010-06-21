package de.cau.cs.kieler.synccharts.textual.actions.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalActionsLexer extends Lexer {
    public static final int RULE_ID=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int Tokens=37;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_STRING=6;
    public static final int RULE_INT=4;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int T34=34;
    public static final int RULE_WS=9;
    public static final int T15=15;
    public static final int T33=33;
    public static final int T16=16;
    public static final int T36=36;
    public static final int T17=17;
    public static final int T35=35;
    public static final int T18=18;
    public static final int T30=30;
    public static final int T19=19;
    public static final int T32=32;
    public static final int T31=31;
    public InternalActionsLexer() {;} 
    public InternalActionsLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:10:5: ( '#' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:10:7: '#'
            {
            match('#'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:11:5: ( '/' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:11:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:12:5: ( ',' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:12:7: ','
            {
            match(','); 

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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:13:5: ( '(' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:13:7: '('
            {
            match('('); 

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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:14:5: ( ')' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:14:7: ')'
            {
            match(')'); 

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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:15:5: ( ':=' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:15:7: ':='
            {
            match(":="); 


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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:16:5: ( '-' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:16:7: '-'
            {
            match('-'); 

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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:17:5: ( '.' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:17:7: '.'
            {
            match('.'); 

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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:18:5: ( 'E' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:18:7: 'E'
            {
            match('E'); 

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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:19:5: ( 'e' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:19:7: 'e'
            {
            match('e'); 

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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:20:5: ( 'true' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:20:7: 'true'
            {
            match("true"); 


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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:21:5: ( 'false' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:21:7: 'false'
            {
            match("false"); 


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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:22:5: ( '=' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:22:7: '='
            {
            match('='); 

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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:23:5: ( '<' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:23:7: '<'
            {
            match('<'); 

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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:24:5: ( '<=' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:24:7: '<='
            {
            match("<="); 


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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:25:5: ( '>' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:25:7: '>'
            {
            match('>'); 

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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:26:5: ( '>=' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:26:7: '>='
            {
            match(">="); 


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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:27:5: ( '<>' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:27:7: '<>'
            {
            match("<>"); 


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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:28:5: ( 'pre' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:28:7: 'pre'
            {
            match("pre"); 


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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:29:5: ( 'or' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:29:7: 'or'
            {
            match("or"); 


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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:30:5: ( 'and' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:30:7: 'and'
            {
            match("and"); 


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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:31:5: ( 'not' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:31:7: 'not'
            {
            match("not"); 


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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:32:5: ( '+' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:32:7: '+'
            {
            match('+'); 

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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:33:5: ( '*' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:33:7: '*'
            {
            match('*'); 

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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:34:5: ( 'mod' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:34:7: 'mod'
            {
            match("mod"); 


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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:35:5: ( '?' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:35:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2690:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2690:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2690:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2690:11: '^'
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

            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2690:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:
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

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2692:10: ( ( '0' .. '9' )+ )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2692:12: ( '0' .. '9' )+
            {
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2692:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2692:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2694:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2694:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2694:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2694:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2694:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2694:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFE')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2694:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2694:62: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2694:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2694:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFE')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2694:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2694:129: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop5;
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

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2696:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2696:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2696:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFE')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFE')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2696:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2698:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2698:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2698:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2698:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop8;
                }
            } while (true);

            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2698:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2698:41: ( '\\r' )? '\\n'
                    {
                    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2698:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2698:41: '\\r'
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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2700:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2700:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2700:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2702:16: ( . )
            // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:2702:18: .
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
        // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=33;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='#') ) {
            alt12=1;
        }
        else if ( (LA12_0=='/') ) {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt12=31;
                }
                break;
            case '*':
                {
                alt12=30;
                }
                break;
            default:
                alt12=2;}

        }
        else if ( (LA12_0==',') ) {
            alt12=3;
        }
        else if ( (LA12_0=='(') ) {
            alt12=4;
        }
        else if ( (LA12_0==')') ) {
            alt12=5;
        }
        else if ( (LA12_0==':') ) {
            int LA12_6 = input.LA(2);

            if ( (LA12_6=='=') ) {
                alt12=6;
            }
            else {
                alt12=33;}
        }
        else if ( (LA12_0=='-') ) {
            alt12=7;
        }
        else if ( (LA12_0=='.') ) {
            alt12=8;
        }
        else if ( (LA12_0=='E') ) {
            int LA12_9 = input.LA(2);

            if ( ((LA12_9>='0' && LA12_9<='9')||(LA12_9>='A' && LA12_9<='Z')||LA12_9=='_'||(LA12_9>='a' && LA12_9<='z')) ) {
                alt12=27;
            }
            else {
                alt12=9;}
        }
        else if ( (LA12_0=='e') ) {
            int LA12_10 = input.LA(2);

            if ( ((LA12_10>='0' && LA12_10<='9')||(LA12_10>='A' && LA12_10<='Z')||LA12_10=='_'||(LA12_10>='a' && LA12_10<='z')) ) {
                alt12=27;
            }
            else {
                alt12=10;}
        }
        else if ( (LA12_0=='t') ) {
            int LA12_11 = input.LA(2);

            if ( (LA12_11=='r') ) {
                int LA12_44 = input.LA(3);

                if ( (LA12_44=='u') ) {
                    int LA12_63 = input.LA(4);

                    if ( (LA12_63=='e') ) {
                        int LA12_70 = input.LA(5);

                        if ( ((LA12_70>='0' && LA12_70<='9')||(LA12_70>='A' && LA12_70<='Z')||LA12_70=='_'||(LA12_70>='a' && LA12_70<='z')) ) {
                            alt12=27;
                        }
                        else {
                            alt12=11;}
                    }
                    else {
                        alt12=27;}
                }
                else {
                    alt12=27;}
            }
            else {
                alt12=27;}
        }
        else if ( (LA12_0=='f') ) {
            int LA12_12 = input.LA(2);

            if ( (LA12_12=='a') ) {
                int LA12_45 = input.LA(3);

                if ( (LA12_45=='l') ) {
                    int LA12_64 = input.LA(4);

                    if ( (LA12_64=='s') ) {
                        int LA12_71 = input.LA(5);

                        if ( (LA12_71=='e') ) {
                            int LA12_77 = input.LA(6);

                            if ( ((LA12_77>='0' && LA12_77<='9')||(LA12_77>='A' && LA12_77<='Z')||LA12_77=='_'||(LA12_77>='a' && LA12_77<='z')) ) {
                                alt12=27;
                            }
                            else {
                                alt12=12;}
                        }
                        else {
                            alt12=27;}
                    }
                    else {
                        alt12=27;}
                }
                else {
                    alt12=27;}
            }
            else {
                alt12=27;}
        }
        else if ( (LA12_0=='=') ) {
            alt12=13;
        }
        else if ( (LA12_0=='<') ) {
            switch ( input.LA(2) ) {
            case '=':
                {
                alt12=15;
                }
                break;
            case '>':
                {
                alt12=18;
                }
                break;
            default:
                alt12=14;}

        }
        else if ( (LA12_0=='>') ) {
            int LA12_15 = input.LA(2);

            if ( (LA12_15=='=') ) {
                alt12=17;
            }
            else {
                alt12=16;}
        }
        else if ( (LA12_0=='p') ) {
            int LA12_16 = input.LA(2);

            if ( (LA12_16=='r') ) {
                int LA12_52 = input.LA(3);

                if ( (LA12_52=='e') ) {
                    int LA12_65 = input.LA(4);

                    if ( ((LA12_65>='0' && LA12_65<='9')||(LA12_65>='A' && LA12_65<='Z')||LA12_65=='_'||(LA12_65>='a' && LA12_65<='z')) ) {
                        alt12=27;
                    }
                    else {
                        alt12=19;}
                }
                else {
                    alt12=27;}
            }
            else {
                alt12=27;}
        }
        else if ( (LA12_0=='o') ) {
            int LA12_17 = input.LA(2);

            if ( (LA12_17=='r') ) {
                int LA12_53 = input.LA(3);

                if ( ((LA12_53>='0' && LA12_53<='9')||(LA12_53>='A' && LA12_53<='Z')||LA12_53=='_'||(LA12_53>='a' && LA12_53<='z')) ) {
                    alt12=27;
                }
                else {
                    alt12=20;}
            }
            else {
                alt12=27;}
        }
        else if ( (LA12_0=='a') ) {
            int LA12_18 = input.LA(2);

            if ( (LA12_18=='n') ) {
                int LA12_54 = input.LA(3);

                if ( (LA12_54=='d') ) {
                    int LA12_67 = input.LA(4);

                    if ( ((LA12_67>='0' && LA12_67<='9')||(LA12_67>='A' && LA12_67<='Z')||LA12_67=='_'||(LA12_67>='a' && LA12_67<='z')) ) {
                        alt12=27;
                    }
                    else {
                        alt12=21;}
                }
                else {
                    alt12=27;}
            }
            else {
                alt12=27;}
        }
        else if ( (LA12_0=='n') ) {
            int LA12_19 = input.LA(2);

            if ( (LA12_19=='o') ) {
                int LA12_55 = input.LA(3);

                if ( (LA12_55=='t') ) {
                    int LA12_68 = input.LA(4);

                    if ( ((LA12_68>='0' && LA12_68<='9')||(LA12_68>='A' && LA12_68<='Z')||LA12_68=='_'||(LA12_68>='a' && LA12_68<='z')) ) {
                        alt12=27;
                    }
                    else {
                        alt12=22;}
                }
                else {
                    alt12=27;}
            }
            else {
                alt12=27;}
        }
        else if ( (LA12_0=='+') ) {
            alt12=23;
        }
        else if ( (LA12_0=='*') ) {
            alt12=24;
        }
        else if ( (LA12_0=='m') ) {
            int LA12_22 = input.LA(2);

            if ( (LA12_22=='o') ) {
                int LA12_58 = input.LA(3);

                if ( (LA12_58=='d') ) {
                    int LA12_69 = input.LA(4);

                    if ( ((LA12_69>='0' && LA12_69<='9')||(LA12_69>='A' && LA12_69<='Z')||LA12_69=='_'||(LA12_69>='a' && LA12_69<='z')) ) {
                        alt12=27;
                    }
                    else {
                        alt12=25;}
                }
                else {
                    alt12=27;}
            }
            else {
                alt12=27;}
        }
        else if ( (LA12_0=='?') ) {
            alt12=26;
        }
        else if ( (LA12_0=='^') ) {
            int LA12_24 = input.LA(2);

            if ( ((LA12_24>='A' && LA12_24<='Z')||LA12_24=='_'||(LA12_24>='a' && LA12_24<='z')) ) {
                alt12=27;
            }
            else {
                alt12=33;}
        }
        else if ( ((LA12_0>='A' && LA12_0<='D')||(LA12_0>='F' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='b' && LA12_0<='d')||(LA12_0>='g' && LA12_0<='l')||(LA12_0>='q' && LA12_0<='s')||(LA12_0>='u' && LA12_0<='z')) ) {
            alt12=27;
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12=28;
        }
        else if ( (LA12_0=='\"') ) {
            int LA12_27 = input.LA(2);

            if ( ((LA12_27>='\u0000' && LA12_27<='\uFFFE')) ) {
                alt12=29;
            }
            else {
                alt12=33;}
        }
        else if ( (LA12_0=='\'') ) {
            int LA12_28 = input.LA(2);

            if ( ((LA12_28>='\u0000' && LA12_28<='\uFFFE')) ) {
                alt12=29;
            }
            else {
                alt12=33;}
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=32;
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='$' && LA12_0<='&')||LA12_0==';'||LA12_0=='@'||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFE')) ) {
            alt12=33;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

            throw nvae;
        }
        switch (alt12) {
            case 1 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:102: T34
                {
                mT34(); 

                }
                break;
            case 25 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:106: T35
                {
                mT35(); 

                }
                break;
            case 26 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:110: T36
                {
                mT36(); 

                }
                break;
            case 27 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:114: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 28 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:122: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 29 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:131: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 30 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:143: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 31 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:159: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 32 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:175: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 33 :
                // ../de.cau.cs.kieler.synccharts.textual.actions/src-gen/de/cau/cs/kieler/synccharts/textual/actions/parser/antlr/internal/InternalActions.g:1:183: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}