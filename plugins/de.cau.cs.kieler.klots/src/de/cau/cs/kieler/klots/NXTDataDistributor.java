package de.cau.cs.kieler.klots;

import java.util.Iterator;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
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

import de.cau.cs.kieler.klots.editor.SJEditor;

public class NXTDataDistributor extends JSONObjectDataComponent implements
		IJSONObjectDataComponent {
	
	private static final String KLOTSCONSOLENAME = "Klots Console";
	NXTCommunicator comm;
	SJEditor editor;
	

	public void initialize() throws KiemInitializationException {
		comm = NXTCommunicator.getInstance();
		
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				IEditorPart e = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(e != null) {
					editor = (SJEditor) e;
				} else {
					printConsole("INITIALIZATION ERROR: Could not find an active SJ editor!");
				}
			}
		});
		
		String s = comm.receiveMessage().toString();
		if( s.equals("[{SYNCHRONIZED}]") ) {
			printConsole(s);
			editor.useAsExecutionViewer(true);
		} else {
			printConsole("ERROR while trying to synchronize with the NXT: " + s);
		}
		
	}

	
	public void wrapup() throws KiemInitializationException {
		comm.sendMessage("STOP");
		comm.closeTransmission();
		editor.useAsExecutionViewer(false);
	}

	
	public boolean isProducer() {
		return true;
	}

	
	public boolean isObserver() {
		return true;
	}
	
	
	@Override
    public boolean isHistoryObserver() {
        return true;
    }

	
	public JSONObject step(JSONObject jSONObject) throws KiemExecutionException {
		
		if( this.isHistoryStep() ) {
			printConsole("HISTORY!");
			printConsole( ">>> jSONObject: >>> " + jSONObject.toString() );
			try {
				editor.update(jSONObject.getJSONArray("executionTrace").toString());
			} catch (JSONException e) {
				printConsole("HISTORY STEP ERROR: " + e.getMessage());
			}
			return null;
		}
		
		
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
			printConsole("PRODUCER ERROR: " + e.getMessage());
        }
		comm.sendMessage("STEP\n" + msg);
		
		// --------------------------- observer -----------------------------
		StringBuffer buffer = comm.receiveMessage();
		editor.update(buffer);
		try {
//			printConsole( ">>> buffer.toString(): >>> " + buffer.toString() );
			
			JSONArray received = new JSONArray(buffer.toString());
//			printConsole( ">>> received: >>> " + received.toString() );
			JSONObject returnObj = new JSONObject();
			String s = buffer.toString();
			s = s.substring(1, s.length()-1);
			returnObj.put( "executionTrace", received);
//			printConsole( ">>> returnObj.accumulate(buffer): >>> " + returnObj.toString() );
			
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
            if (NXTDataDistributor.KLOTSCONSOLENAME.equals(existing[i].getName())) {
                maudeConsole = (MessageConsole) existing[i];
                found = true;
                break;
            }
        if (!found) {
            // if no console found, so create a new one
            maudeConsole = new MessageConsole(NXTDataDistributor.KLOTSCONSOLENAME, null);
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