package de.cau.cs.kieler.core.expressions.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalExpressionsLexer extends Lexer {
    public static final int T21=21;
    public static final int RULE_ML_COMMENT=7;
    public static final int T14=14;
    public static final int T29=29;
    public static final int RULE_ID=5;
    public static final int T33=33;
    public static final int T22=22;
    public static final int T11=11;
    public static final int RULE_STRING=4;
    public static final int T12=12;
    public static final int T28=28;
    public static final int T23=23;
    public static final int T13=13;
    public static final int T20=20;
    public static final int T25=25;
    public static final int T18=18;
    public static final int RULE_WS=9;
    public static final int T26=26;
    public static final int T15=15;
    public static final int RULE_INT=6;
    public static final int EOF=-1;
    public static final int T32=32;
    public static final int T17=17;
    public static final int Tokens=34;
    public static final int T31=31;
    public static final int RULE_ANY_OTHER=10;
    public static final int T16=16;
    public static final int T27=27;
    public static final int RULE_SL_COMMENT=8;
    public static final int T30=30;
    public static final int T24=24;
    public static final int T19=19;
    public InternalExpressionsLexer() {;} 
    public InternalExpressionsLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:10:5: ( '(' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:10:7: '('
            {
            match('('); 

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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:11:5: ( ')' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:11:7: ')'
            {
            match(')'); 

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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:12:5: ( '-' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:12:7: '-'
            {
            match('-'); 

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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:13:5: ( '.' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:13:7: '.'
            {
            match('.'); 

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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:14:5: ( 'E' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:14:7: 'E'
            {
            match('E'); 

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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:15:5: ( 'e' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:15:7: 'e'
            {
            match('e'); 

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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:16:5: ( 'true' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:16:7: 'true'
            {
            match("true"); 


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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:17:5: ( 'false' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:17:7: 'false'
            {
            match("false"); 


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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:18:5: ( '=' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:18:7: '='
            {
            match('='); 

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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:19:5: ( '<' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:19:7: '<'
            {
            match('<'); 

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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:20:5: ( '<=' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:20:7: '<='
            {
            match("<="); 


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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:21:5: ( '>' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:21:7: '>'
            {
            match('>'); 

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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:22:5: ( '>=' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:22:7: '>='
            {
            match(">="); 


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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:23:5: ( '<>' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:23:7: '<>'
            {
            match("<>"); 


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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:24:5: ( 'pre' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:24:7: 'pre'
            {
            match("pre"); 


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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:25:5: ( 'or' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:25:7: 'or'
            {
            match("or"); 


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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:26:5: ( 'and' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:26:7: 'and'
            {
            match("and"); 


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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:27:5: ( 'not' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:27:7: 'not'
            {
            match("not"); 


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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:28:5: ( '+' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:28:7: '+'
            {
            match('+'); 

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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:29:5: ( '*' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:29:7: '*'
            {
            match('*'); 

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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:30:5: ( 'mod' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:30:7: 'mod'
            {
            match("mod"); 


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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:31:5: ( '/' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:31:7: '/'
            {
            match('/'); 

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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:32:5: ( '?' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:32:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2247:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2247:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2247:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2247:11: '^'
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

            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2247:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:
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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2249:10: ( ( '0' .. '9' )+ )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2249:12: ( '0' .. '9' )+
            {
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2249:12: ( '0' .. '9' )+
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
            	    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2249:13: '0' .. '9'
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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2251:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2251:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2251:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("2251:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2251:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2251:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2251:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2251:62: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2251:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2251:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2251:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2251:129: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2253:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2253:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2253:24: ( options {greedy=false; } : . )*
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
            	    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2253:52: .
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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2255:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2255:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2255:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2255:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2255:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2255:41: ( '\\r' )? '\\n'
                    {
                    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2255:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2255:41: '\\r'
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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2257:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2257:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2257:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:
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
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2259:16: ( . )
            // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:2259:18: .
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
        // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=30;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='(') ) {
            alt12 = mTokensHelper001();
        }
        else if ( (LA12_0==')') ) {
            alt12 = mTokensHelper002();
        }
        else if ( (LA12_0=='-') ) {
            alt12 = mTokensHelper003();
        }
        else if ( (LA12_0=='.') ) {
            alt12 = mTokensHelper004();
        }
        else if ( (LA12_0=='E') ) {
            alt12 = mTokensHelper005();
        }
        else if ( (LA12_0=='e') ) {
            alt12 = mTokensHelper006();
        }
        else if ( (LA12_0=='t') ) {
            alt12 = mTokensHelper007();
        }
        else if ( (LA12_0=='f') ) {
            alt12 = mTokensHelper008();
        }
        else if ( (LA12_0=='=') ) {
            alt12 = mTokensHelper009();
        }
        else if ( (LA12_0=='<') ) {
            alt12 = mTokensHelper010();
        }
        else if ( (LA12_0=='>') ) {
            alt12 = mTokensHelper011();
        }
        else if ( (LA12_0=='p') ) {
            alt12 = mTokensHelper012();
        }
        else if ( (LA12_0=='o') ) {
            alt12 = mTokensHelper013();
        }
        else if ( (LA12_0=='a') ) {
            alt12 = mTokensHelper014();
        }
        else if ( (LA12_0=='n') ) {
            alt12 = mTokensHelper015();
        }
        else if ( (LA12_0=='+') ) {
            alt12 = mTokensHelper016();
        }
        else if ( (LA12_0=='*') ) {
            alt12 = mTokensHelper017();
        }
        else if ( (LA12_0=='m') ) {
            alt12 = mTokensHelper018();
        }
        else if ( (LA12_0=='/') ) {
            alt12 = mTokensHelper019();
        }
        else if ( (LA12_0=='?') ) {
            alt12 = mTokensHelper020();
        }
        else if ( (LA12_0=='^') ) {
            alt12 = mTokensHelper021();
        }
        else if ( ((LA12_0>='A' && LA12_0<='D')||(LA12_0>='F' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='b' && LA12_0<='d')||(LA12_0>='g' && LA12_0<='l')||(LA12_0>='q' && LA12_0<='s')||(LA12_0>='u' && LA12_0<='z')) ) {
            alt12 = mTokensHelper022();
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12 = mTokensHelper023();
        }
        else if ( (LA12_0=='\"') ) {
            alt12 = mTokensHelper024();
        }
        else if ( (LA12_0=='\'') ) {
            alt12 = mTokensHelper025();
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12 = mTokensHelper026();
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||LA12_0==','||(LA12_0>=':' && LA12_0<=';')||LA12_0=='@'||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFE')) ) {
            alt12 = mTokensHelper027();
        }
        else {
            alt12 = mTokensHelper028();
        }
        switch (alt12) {
            case 1 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:102: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 25 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:110: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 26 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:119: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 27 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:131: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 28 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:147: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 29 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:163: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 30 :
                // ../de.cau.cs.kieler.core.expressions/src-gen/de/cau/cs/kieler/core/expressions/parser/antlr/internal/InternalExpressions.g:1:171: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        return 1;
    }

    private int mTokensHelper002() throws RecognitionException {
        return 2;
    }

    private int mTokensHelper003() throws RecognitionException {
        return 3;
    }

    private int mTokensHelper004() throws RecognitionException {
        return 4;
    }

    private int mTokensHelper005() throws RecognitionException {
        int LA12_5 = input.LA(2);

        if ( ((LA12_5>='0' && LA12_5<='9')||(LA12_5>='A' && LA12_5<='Z')||LA12_5=='_'||(LA12_5>='a' && LA12_5<='z')) ) {
            return 24;
        }
        else {
            return 5;}
    }

    private int mTokensHelper006() throws RecognitionException {
        int LA12_6 = input.LA(2);

        if ( ((LA12_6>='0' && LA12_6<='9')||(LA12_6>='A' && LA12_6<='Z')||LA12_6=='_'||(LA12_6>='a' && LA12_6<='z')) ) {
            return 24;
        }
        else {
            return 6;}
    }

    private int mTokensHelper007() throws RecognitionException {
        int LA12_7 = input.LA(2);

        if ( (LA12_7=='r') ) {
            int LA12_35 = input.LA(3);

            if ( (LA12_35=='u') ) {
                int LA12_57 = input.LA(4);

                if ( (LA12_57=='e') ) {
                    int LA12_64 = input.LA(5);

                    if ( ((LA12_64>='0' && LA12_64<='9')||(LA12_64>='A' && LA12_64<='Z')||LA12_64=='_'||(LA12_64>='a' && LA12_64<='z')) ) {
                        return 24;
                    }
                    else {
                        return 7;}
                }
                else {
                    return 24;}
            }
            else {
                return 24;}
        }
        else {
            return 24;}
    }

    private int mTokensHelper008() throws RecognitionException {
        int LA12_8 = input.LA(2);

        if ( (LA12_8=='a') ) {
            int LA12_36 = input.LA(3);

            if ( (LA12_36=='l') ) {
                int LA12_58 = input.LA(4);

                if ( (LA12_58=='s') ) {
                    int LA12_65 = input.LA(5);

                    if ( (LA12_65=='e') ) {
                        int LA12_71 = input.LA(6);

                        if ( ((LA12_71>='0' && LA12_71<='9')||(LA12_71>='A' && LA12_71<='Z')||LA12_71=='_'||(LA12_71>='a' && LA12_71<='z')) ) {
                            return 24;
                        }
                        else {
                            return 8;}
                    }
                    else {
                        return 24;}
                }
                else {
                    return 24;}
            }
            else {
                return 24;}
        }
        else {
            return 24;}
    }

    private int mTokensHelper009() throws RecognitionException {
        return 9;
    }

    private int mTokensHelper010() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '>':
            {
            return 14;
            }
        case '=':
            {
            return 11;
            }
        default:
            return 10;}

    }

    private int mTokensHelper011() throws RecognitionException {
        int LA12_11 = input.LA(2);

        if ( (LA12_11=='=') ) {
            return 13;
        }
        else {
            return 12;}
    }

    private int mTokensHelper012() throws RecognitionException {
        int LA12_12 = input.LA(2);

        if ( (LA12_12=='r') ) {
            int LA12_43 = input.LA(3);

            if ( (LA12_43=='e') ) {
                int LA12_59 = input.LA(4);

                if ( ((LA12_59>='0' && LA12_59<='9')||(LA12_59>='A' && LA12_59<='Z')||LA12_59=='_'||(LA12_59>='a' && LA12_59<='z')) ) {
                    return 24;
                }
                else {
                    return 15;}
            }
            else {
                return 24;}
        }
        else {
            return 24;}
    }

    private int mTokensHelper013() throws RecognitionException {
        int LA12_13 = input.LA(2);

        if ( (LA12_13=='r') ) {
            int LA12_44 = input.LA(3);

            if ( ((LA12_44>='0' && LA12_44<='9')||(LA12_44>='A' && LA12_44<='Z')||LA12_44=='_'||(LA12_44>='a' && LA12_44<='z')) ) {
                return 24;
            }
            else {
                return 16;}
        }
        else {
            return 24;}
    }

    private int mTokensHelper014() throws RecognitionException {
        int LA12_14 = input.LA(2);

        if ( (LA12_14=='n') ) {
            int LA12_45 = input.LA(3);

            if ( (LA12_45=='d') ) {
                int LA12_61 = input.LA(4);

                if ( ((LA12_61>='0' && LA12_61<='9')||(LA12_61>='A' && LA12_61<='Z')||LA12_61=='_'||(LA12_61>='a' && LA12_61<='z')) ) {
                    return 24;
                }
                else {
                    return 17;}
            }
            else {
                return 24;}
        }
        else {
            return 24;}
    }

    private int mTokensHelper015() throws RecognitionException {
        int LA12_15 = input.LA(2);

        if ( (LA12_15=='o') ) {
            int LA12_46 = input.LA(3);

            if ( (LA12_46=='t') ) {
                int LA12_62 = input.LA(4);

                if ( ((LA12_62>='0' && LA12_62<='9')||(LA12_62>='A' && LA12_62<='Z')||LA12_62=='_'||(LA12_62>='a' && LA12_62<='z')) ) {
                    return 24;
                }
                else {
                    return 18;}
            }
            else {
                return 24;}
        }
        else {
            return 24;}
    }

    private int mTokensHelper016() throws RecognitionException {
        return 19;
    }

    private int mTokensHelper017() throws RecognitionException {
        return 20;
    }

    private int mTokensHelper018() throws RecognitionException {
        int LA12_18 = input.LA(2);

        if ( (LA12_18=='o') ) {
            int LA12_49 = input.LA(3);

            if ( (LA12_49=='d') ) {
                int LA12_63 = input.LA(4);

                if ( ((LA12_63>='0' && LA12_63<='9')||(LA12_63>='A' && LA12_63<='Z')||LA12_63=='_'||(LA12_63>='a' && LA12_63<='z')) ) {
                    return 24;
                }
                else {
                    return 21;}
            }
            else {
                return 24;}
        }
        else {
            return 24;}
    }

    private int mTokensHelper019() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '/':
            {
            return 28;
            }
        case '*':
            {
            return 27;
            }
        default:
            return 22;}

    }

    private int mTokensHelper020() throws RecognitionException {
        return 23;
    }

    private int mTokensHelper021() throws RecognitionException {
        int LA12_21 = input.LA(2);

        if ( ((LA12_21>='A' && LA12_21<='Z')||LA12_21=='_'||(LA12_21>='a' && LA12_21<='z')) ) {
            return 24;
        }
        else {
            return 30;}
    }

    private int mTokensHelper022() throws RecognitionException {
        return 24;
    }

    private int mTokensHelper023() throws RecognitionException {
        return 25;
    }

    private int mTokensHelper024() throws RecognitionException {
        int LA12_24 = input.LA(2);

        if ( ((LA12_24>='\u0000' && LA12_24<='\uFFFE')) ) {
            return 26;
        }
        else {
            return 30;}
    }

    private int mTokensHelper025() throws RecognitionException {
        int LA12_25 = input.LA(2);

        if ( ((LA12_25>='\u0000' && LA12_25<='\uFFFE')) ) {
            return 26;
        }
        else {
            return 30;}
    }

    private int mTokensHelper026() throws RecognitionException {
        return 29;
    }

    private int mTokensHelper027() throws RecognitionException {
        return 30;
    }

    private int mTokensHelper028() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

        throw nvae;
    }



 

}