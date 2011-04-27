package de.cau.cs.kieler.klots.util;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class KlotsConsole {

	private static final String KLOTS_CONSOLE_NAME = "KLOTS Console";
	
	private MessageConsole klotsConsole = null;
	private static final KlotsConsole INSTANCE = new KlotsConsole();
	
	
	public KlotsConsole() {
        boolean found = false;
        ConsolePlugin plugin = ConsolePlugin.getDefault();
        IConsoleManager conMan = plugin.getConsoleManager();
        IConsole[] existing = conMan.getConsoles();
        for (int i = 0; i < existing.length; i++)
            if (KLOTS_CONSOLE_NAME.equals(existing[i].getName())) {
                klotsConsole = (MessageConsole) existing[i];
                found = true;
                break;
            }
        if (!found) {
            // if no console found, so create a new one
            klotsConsole = new MessageConsole(KLOTS_CONSOLE_NAME, null);
            conMan.addConsoles(new IConsole[] { klotsConsole });
        }
	}
	
	
	public static KlotsConsole getInstance() {
		return INSTANCE;
	}
	
	
    /**
     * Clears the klots console.
     */
    public void clear() {
        print(null);
    }

    
    public void println(String text) {
    	print(text + "\n");
    }
    
    
    /**
     * Prints to the klots console.
     * 
     * @param text
     *            the text
     */
    public void print(String text) {
        if (text != null) {
            MessageConsoleStream out = klotsConsole.newMessageStream();
            out.print(text);
        } else {
            klotsConsole.clearConsole();
        }
    }
	
}
