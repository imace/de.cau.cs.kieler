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
	
	// ------------------------------------
	// XXX: use parseSignals() in SJEditor
	//private String[] signals;
	// ------------------------------------
	
	

	public void initialize() throws KiemInitializationException {
		comm = NXTCommunicator.getInstance();
		
		String s = comm.receiveMessage().toString();
		if( s.startsWith("[{SYNCHRONIZED}") ) {
			printConsole(s);
			
			// -------------------------------------------------------
			// XXX: use parseSignals() in SJEditor
			// remove leading '[{SYNCHRONIZED},\n{'
//			s = s.replaceAll("(?s-:.*\\x7B)", "");
//			// remove ending '}]'
//			s = s.replace("}]", "");
//			System.out.println(":::::::>>>>> signals = >" + s + "<");
//			signals = s.split(";");
			// -------------------------------------------------------
			
		} else {
			printConsole("ERROR while trying to synchronize with the NXT: " + s);
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
			msg = msg.substring(0, msg.length()-1);
		} catch (JSONException e) {
			printConsole("PRODUCER ERROR: " + e.getMessage());
        }
		comm.sendMessage("STEP\n" + msg);
		
		// --------------------------- observer -----------------------------
		StringBuffer buffer = comm.receiveMessage();
		System.out.println("====;;;;;;;==== RECEIVED MESSAGE BUFFER = >" + buffer.toString() + "<");
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
	// XXX: use parseSignals() in SJEditor
//	@Override
//    public JSONObject provideInitialVariables() {
//		
//        JSONObject returnObj = new JSONObject();
//        try {
//        	
//        	for(String s : signals) {
//        		System.out.println(":::::::>>>>> providing initial signal >" + s + "<");
//        		returnObj.accumulate(s, JSONSignalValues.newValue(false));
//        	}
//        	
//        } catch (JSONException e) {
//        	printConsole(e.getStackTrace().toString());
//        }
//        return returnObj;
//    }
	// ----------------------------------------------------------------------
	
	
	
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
