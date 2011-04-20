package de.cau.cs.kieler.klots;

import java.util.Iterator;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONSignalValues;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;

public class NXTDataDistributorWithKiVi extends JSONObjectDataComponent implements
		IJSONObjectDataComponent {
	
	private static final String KLOTSCONSOLENAME = "Klots Console";
	NXTCommunicator comm;
	

	public void initialize() throws KiemInitializationException {
		comm = NXTCommunicator.getInstance();
		// use NXTCommunicator.receiveMessageLine() to ensure plane old java remote print support
		String line = comm.receiveMessageLine();
		if( !line.startsWith("SYNCHRONIZED") && !line.startsWith(comm.PRINT_TAG) ) {
			printConsole("ERROR while trying to synchronize with the NXT: " + line);
		}
		while( !line.equals("EOT") ) {
			printConsole(line);
			line = comm.receiveMessageLine();
		}
	}

	
	public void wrapup() throws KiemInitializationException {
		comm.sendMessage("STOP");
		comm.closeTransmission();
	}

	
	public boolean isProducer() {
		return true;
	}

	
	public boolean isObserver() {
		return true;
	}

	
	public JSONObject step(JSONObject jSONObject) throws KiemExecutionException {
		
		// --------------------------- producer -----------------------------
		String msg = "";
		try {
			String jSONKey = "";
			for(Iterator<?> iter = jSONObject.keys(); iter.hasNext(); ) {
				jSONKey = (String) iter.next();
				if( JSONSignalValues.isPresent(jSONObject.get(jSONKey)) ) {
					if( JSONSignalValues.isSignalValue(jSONObject.get(jSONKey)) ) {
						msg += jSONKey + "," + JSONSignalValues.getSignalValue(jSONObject.get(jSONKey)) + ";";
					} else {
						msg += jSONKey + ";";
					}
		        }
			}
			if( msg.length() > 0 ) {
				msg = msg.substring(0, msg.length()-1);
			}
		} catch (JSONException e) {
			printConsole("PRODUCER ERROR: " + e.getMessage());
        }
		comm.sendMessage("STEP\n" + msg);
		
		// --------------------------- observer -----------------------------
		StringBuffer buffer = comm.receiveMessage();
		System.out.println("====;;;;;;;==== RECEIVED MESSAGE BUFFER = >" + buffer.toString() + "<");
		
		// remote console print processing
		int start = 0;
		int end = 0;
		while( start >= 0 ) {
			start = buffer.indexOf("{" + comm.PRINT_TAG, end);
			if( start >= 0 ) {
				end = buffer.indexOf("},", start);
				printConsole( "REMOTE PRINT: " + buffer.substring(1+start+comm.PRINT_TAG.length(), end) );
				buffer.replace(start, end+2, "");
				System.out.println("====;;;;;;;==== MESSAGE BUFFER AFTER PRINT = >" + buffer.toString() + "<");
				end = start;
			}
		}
		
		try {
			JSONArray received = new JSONArray(buffer.toString());
			JSONObject returnObj = new JSONObject();
			String s = buffer.toString();
			s = s.substring(1, s.length()-1);
			returnObj.put("executionTrace", received);
			
			JSONObject signals = received.getJSONObject(received.length()-2);
			if( signals.has("signals") ) {
				JSONObject tmp = new JSONObject();
				String key;
				JSONArray sig = signals.getJSONArray("signals");
				for(int i = 0; i < sig.length(); i++) {
					tmp = sig.getJSONObject(i);
					Iterator<?> iter = tmp.keys();
					key = (String) iter.next();
					returnObj.accumulate(key, tmp.get(key));
				}
			}
			return returnObj;
		} catch (JSONException e) {
			printConsole("OBSERVER ERROR: " + e.getMessage());
        }	
		return null;
	}
	
	
	
	
    // ----------------------------------------------------------------------
	// ----------------------------- KLOTS CONSOLE --------------------------
    // ----------------------------------------------------------------------

    /**
     * Clears the klots console.
     */
    protected void clearConsole() {
        printConsole(null);
    }

    /**
     * Prints to the klots console.
     * 
     * @param text
     *            the text
     */
    protected void printConsole(String text) {
        MessageConsole maudeConsole = null;
        boolean found = false;
        ConsolePlugin plugin = ConsolePlugin.getDefault();
        IConsoleManager conMan = plugin.getConsoleManager();
        IConsole[] existing = conMan.getConsoles();
        for (int i = 0; i < existing.length; i++)
            if (NXTDataDistributorWithKiVi.KLOTSCONSOLENAME.equals(existing[i].getName())) {
                maudeConsole = (MessageConsole) existing[i];
                found = true;
                break;
            }
        if (!found) {
            // if no console found, so create a new one
            maudeConsole = new MessageConsole(NXTDataDistributorWithKiVi.KLOTSCONSOLENAME, null);
            conMan.addConsoles(new IConsole[] { maudeConsole });
        }

        // now print to the klots console or clear it
        if (text != null) {
            MessageConsoleStream out = maudeConsole.newMessageStream();
            out.println(text);
        } else {
            maudeConsole.clearConsole();
        }
    }
	
}
