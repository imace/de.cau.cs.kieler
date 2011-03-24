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

import de.cau.cs.kieler.klots.editor.InputDataPool;;

public class DataDistributor extends JSONObjectDataComponent implements
		IJSONObjectDataComponent {
	
	private static final String KLOTSCONSOLENAME = "Klots Console";
	NXTCommunicator comm;
	InputDataPool dataPool;
	

	@Override
	public void initialize() throws KiemInitializationException {
		dataPool = InputDataPool.getInstance();
		comm = NXTCommunicator.getInstance();
//		dataPool.setBuffer(comm.receiveMessage());
//		dataPool.setActionFlag(dataPool.START_ACTION);
		
		String s = comm.receiveMessage().toString();
		if( s.equals("[{SYNCHRONIZED}]") ) {
			printConsole(s);
			dataPool.setActionFlag(dataPool.START_ACTION);
		} else {
			printConsole("ERROR while trying to synchronize with the NXT: " + s);
		}
		
	}

	
	@Override
	public void wrapup() throws KiemInitializationException {
		comm.sendMessage("STOP");
		comm.closeTransmission();
		dataPool.setActionFlag(dataPool.STOP_ACTION);
	}

	
	@Override
	public boolean isProducer() {
		return true;
	}

	
	@Override
	public boolean isObserver() {
		return true;
	}

	
	@Override
	public JSONObject step(JSONObject jSONObject) throws KiemExecutionException {
		// --------------------------- producer -----------------------------
		String msg = "";
		try {
			String jSONKey = "";
			for(Iterator<?> iter = jSONObject.keys(); iter.hasNext(); ) {
				jSONKey = (String) iter.next();
				if( JSONSignalValues.isPresent(jSONObject.get(jSONKey)) ) {
					if( JSONSignalValues.isSignalValue(jSONObject.get(jSONKey)) ) {
						msg += jSONKey + "," + JSONSignalValues.getSignalValue(jSONObject.get(jSONKey)) + "\n";
					} else {
						msg += jSONKey + "\n";
					}
		        }
			}
		} catch (JSONException e) {
			printConsole(e.getStackTrace().toString());
        }
		comm.sendMessage("STEP\n" + msg);
		
		// --------------------------- observer -----------------------------
		StringBuffer buffer = comm.receiveMessage();
		dataPool.setBuffer(buffer);
		try {
			JSONArray received = new JSONArray(buffer.toString());
			JSONObject returnObj = new JSONObject();
			returnObj.accumulate("executionTrace", received);
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
			printConsole(e.getStackTrace().toString());
        }	
		return null;
	}
	
	
	@Override
    public JSONObject provideInitialVariables() {
        JSONObject returnObj = new JSONObject();
        try {
            returnObj.accumulate("a", JSONSignalValues.newValue(false));
            returnObj.accumulate("b", JSONSignalValues.newValue(false));
            returnObj.accumulate("r", JSONSignalValues.newValue(false));
            returnObj.accumulate("o", JSONSignalValues.newValue(false));
        } catch (JSONException e) {
        	printConsole(e.getStackTrace().toString());
        }
        return returnObj;
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
            if (DataDistributor.KLOTSCONSOLENAME.equals(existing[i].getName())) {
                maudeConsole = (MessageConsole) existing[i];
                found = true;
                break;
            }
        if (!found) {
            // if no console found, so create a new one
            maudeConsole = new MessageConsole(DataDistributor.KLOTSCONSOLENAME, null);
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
