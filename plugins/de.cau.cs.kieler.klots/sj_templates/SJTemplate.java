package <PACKAGE>;

import java.io.IOException;

import sj.EmbeddedRemoteConsole;
import sj.EmbeddedSJProgram;
import sj.EmbeddedSJProgramStarter;
import sj.Signal;
import <PACKAGE>.<CLASS>.StateLabel;
import static <PACKAGE>.<CLASS>.StateLabel.*;


public class <CLASS> extends EmbeddedSJProgram<StateLabel> {

    /**
     * The labels used for the different parts of the program.
     */
    enum StateLabel { /* DECLARE YOUR PROGRAM LABELS HERE, E.G. L1, L2,... */ }

    
    /**
     * The signals used by the program.
     */
    public Signal /* DECLARE YOUR PROGRAM SIGNALS HERE, E.G. S1, S2,... */ ;

    
    /**
     * Initializes a new instance of the program.
     */
    public <CLASS>() {
        super( /* INSERT START LABEL */ , /* INSERT START PRIORITY */ );
        
        /* INITIALIZE SIGNALS, I.E. FOR EACH DECLARED SIGNAL ADD LINE: */
        // <SIGNAL> = new Signal("<SIGNAL>");
        /* E.G. ADD: S1 = new Signal("S1") */
        
        addSignals( /* INSERT DECLARED SIGNALS HERE, E.G. S1, S2,... */ );
    }
    
    
    /**
     * Starts the program.
     */
    public static void main(String[] args) {
    	
    	/* UNCOMMENT NEXT LINE TO ENABLE REMOTE CONSOLE PRINT */
    	// EmbeddedRemoteConsole console = new EmbeddedRemoteConsole();
    	try {
    		EmbeddedSJProgramStarter.start(
    				new <CLASS>(),
    				/* INSERT PROGRAM'S NAME HERE, E.G. "MY_SJ_PROGRAM" */,
    				/* INSERT console IF REMOTE PRINT IS ENABLED, OR null OTHERWISE */ );
    	} catch (IOException e) {
    	}
    }
    

    
    /**
     * The heart method of the embedded SJ program.
     * tick() is executed each macrostep until program termination.
     */
    @Override
    public void tick() {
        while (!isTickDone()) {
            switch (state()) {
            
            // --------------------------------------------------------------
            // --------------------------------------------------------------
            
            
            /* WRITE YOUR CODE HERE */
            /* Your code should have the following structure: */
            /*
            case L1:
            	SJ instruction;
            	...
            	SJ instruction;
            	break;
            	
            ...
            	
            case Ln:
            	SJ instruction;
            	...
            	SJ instruction;
            	break;
            */
            
            
            // --------------------------------------------------------------
            // --------------------------------------------------------------

            } // end switch
        } // end while
    } // end tick
    
    
}