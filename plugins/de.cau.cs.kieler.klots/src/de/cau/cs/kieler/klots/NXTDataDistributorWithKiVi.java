package de.cau.cs.kieler.klots;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONSignalValues;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;
import de.cau.cs.kieler.klots.util.KlotsConsole;
import de.cau.cs.kieler.klots.util.KlotsConstants;

public class NXTDataDistributorWithKiVi extends JSONObjectDataComponent implements
		IJSONObjectDataComponent {
	
	private static KlotsConsole console = KlotsConsole.getInstance();
	NXTCommunicator comm;
	

	public void initialize() throws KiemInitializationException {
		console.clear();
		comm = NXTCommunicator.getInstance();
		String msg = comm.receiveMessage().toString();
		if( msg.startsWith("[{" + KlotsConstants.SYNCHRONIZED_COMMAND_KEY) ) {
			console.println(msg);
		} else {
			console.println("ERROR while trying to synchronize with the NXT: " + msg);
		}
	}

	
	public void wrapup() throws KiemInitializationException {
		comm.sendMessage(KlotsConstants.STOP_COMMAND_KEY);
		comm.closeTransmission(true);
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
						msg += jSONKey + KlotsConstants.COMMA_STRING + JSONSignalValues.getSignalValue(jSONObject.get(jSONKey)) + KlotsConstants.SEMICOLON_STRING;
					} else {
						msg += jSONKey + KlotsConstants.SEMICOLON_STRING;
					}
		        }
			}
			if( msg.length() > 0 ) {
				msg = msg.substring(0, msg.length()-1);
			}
		} catch (JSONException e) {
			console.println("PRODUCER ERROR: " + e.getMessage());
        }
		comm.sendMessage(KlotsConstants.STEP_COMMAND_KEY + KlotsConstants.MESSAGE_LINE_DELIMITER + msg);
		
		// --------------------------- observer -----------------------------
		StringBuffer buffer = comm.receiveMessage();
		System.out.println("====;;;;;;;==== RECEIVED MESSAGE BUFFER = >" + buffer.toString() + "<");
		
		// remote console print processing
		int start = 0;
		int end = 0;
		while( start >= 0 ) {
			start = buffer.indexOf("{" + KlotsConstants.PRINT_TAG, end);
			if( start >= 0 ) {
				end = buffer.indexOf("},", start);
				console.println( "REMOTE PRINT: " + buffer.substring(1+start+KlotsConstants.PRINT_TAG.length(), end) );
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
			returnObj.put(KlotsConstants.JSON_EXECUTION_TRACE_TAG, received);
			
			JSONObject signals = received.getJSONObject(received.length()-2);
			if( signals.has(KlotsConstants.JSON_SIGNALS_TAG) ) {
				JSONObject tmp = new JSONObject();
				String key;
				JSONArray sig = signals.getJSONArray(KlotsConstants.JSON_SIGNALS_TAG);
				for(int i = 0; i < sig.length(); i++) {
					tmp = sig.getJSONObject(i);
					Iterator<?> iter = tmp.keys();
					key = (String) iter.next();
					returnObj.accumulate(key, tmp.get(key));
				}
			}
			return returnObj;
		} catch (JSONException e) {
			console.println("OBSERVER ERROR: " + e.getMessage());
        }	
		return null;
	}
	
}
