package de.cau.cs.kieler.klots;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONSignalValues;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;

import de.cau.cs.kieler.klots.editor.SJEditor;

public class NXTDataObserverWithKiVi extends JSONObjectDataComponent implements
		IJSONObjectDataComponent {
	
	private static final String KLOTSCONSOLENAME = "Klots Console";
	SJEditor editor;
	

	public void initialize() throws KiemInitializationException {
		
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
						editor = (SJEditor) e;
					} else {
						printConsole("INITIALIZATION ERROR: Could not find an active SJ editor!");
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
		      	printConsole(e.getStackTrace().toString());
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
				printConsole("HISTORY!");
				printConsole( jSONObject.getJSONArray(KlotsConstants.JSON_EXECUTION_TRACE_TAG).toString(1) );
				editor.update(jSONObject.getJSONArray(KlotsConstants.JSON_EXECUTION_TRACE_TAG).toString(), true);
				editor.doResetMicroSteps();
			} catch (JSONException e) {
				printConsole("HISTORY STEP ERROR: " + e.getMessage());
			}
			return null;
		} else {
			try {
				printConsole("STEP DONE!");
				printConsole( jSONObject.getJSONArray(KlotsConstants.JSON_EXECUTION_TRACE_TAG).toString(1) );
				editor.update(jSONObject.getJSONArray(KlotsConstants.JSON_EXECUTION_TRACE_TAG).toString(), false);
			} catch (JSONException e) {
				printConsole("STEP ERROR: " + e.getMessage());
			}
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
            if (NXTDataObserverWithKiVi.KLOTSCONSOLENAME.equals(existing[i].getName())) {
                maudeConsole = (MessageConsole) existing[i];
                found = true;
                break;
            }
        if (!found) {
            // if no console found, so create a new one
            maudeConsole = new MessageConsole(NXTDataObserverWithKiVi.KLOTSCONSOLENAME, null);
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
