package de.cau.cs.kieler.klots.kiemdatacomponents;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONSignalValues;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;

import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.editor.KlotsEditor;
import de.cau.cs.kieler.klots.util.KlotsConsole;
import de.cau.cs.kieler.klots.util.KlotsConstants;

public class KlotsEditorNXTDataObserver extends JSONObjectDataComponent implements
		IJSONObjectDataComponent {
	
	private static KlotsConsole console = KlotsConsole.getInstance();
	KlotsEditor editor;
	

	public void initialize() throws KiemInitializationException {
		
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				IEditorPart e = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(e != null) {
					editor = (KlotsEditor) e;
				} else {
					console.println("INITIALIZATION ERROR: Could not find an active SJ editor!");
				}
			}
		});
		
		editor.useAsExecutionViewer(true);
		editor.initSJContent();
		
	}
	
	
	@Override
	public JSONObject provideInitialVariables() {
		
		if( editor == null ) {
			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
				public void run() {
					IEditorPart e = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
					if(e != null) {
						editor = (KlotsEditor) e;
					} else {
						console.println("INITIALIZATION ERROR: Could not find an active SJ editor!");
					}
				}
			});
		}
		
		String[] signals = editor.getSignals();
		JSONObject returnObj = new JSONObject();
		if( signals != null ) {
			try {
		      	for(String s : signals) {
		      		System.out.println(":::::::>>>>> providing initial signal >" + s + "<");
		      		returnObj.accumulate(s, JSONSignalValues.newValue(false));
		      	}
			} catch (JSONException e) {
		      	console.println(e.getStackTrace().toString());
			}
		}
		return returnObj;
		
	}

	
	public void wrapup() throws KiemInitializationException {
		editor.useAsExecutionViewer(false);
		editor.rollbackSJContent();
	}

	
	public boolean isProducer() {
		return false;
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
			try {
				console.println("HISTORY!");
				console.println( jSONObject.getJSONArray(KlotsConstants.JSON_EXECUTION_TRACE_TAG).toString(2) );
				editor.update(jSONObject.getJSONArray(KlotsConstants.JSON_EXECUTION_TRACE_TAG).toString(), true);
				editor.doResetMicroSteps();
			} catch (JSONException e) {
				console.println("HISTORY STEP ERROR: " + e.getMessage());
			}
			return null;
		} else {
			try {
				console.println("STEP DONE!");
				console.println( jSONObject.getJSONArray(KlotsConstants.JSON_EXECUTION_TRACE_TAG).toString(2) );
				editor.update(jSONObject.getJSONArray(KlotsConstants.JSON_EXECUTION_TRACE_TAG).toString(), false);
			} catch (JSONException e) {
				console.println("STEP ERROR: " + e.getMessage());
			}
		}
		
		return null;
	}
	
}