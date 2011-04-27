package de.cau.cs.kieler.klots.util;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;

import de.cau.cs.kieler.klots.KlotsPlugin;

public class RemotePrintReceiver /*extends Thread*/ {

	private static KlotsConsole console = KlotsConsole.getInstance();
	NXTCommunicator comm;
	
	private boolean broughtToFront = false;
	
	public RemotePrintReceiver(NXTCommunicator comm) {
		this.comm = comm;
	}
	
	
	public void start() {//run() {
		bringToFront();
		String line = comm.receiveMessageLine();
		while( !line.equals(KlotsConstants.END_OF_TRANSMISSION_COMMAND_KEY) ) {
			if( line.endsWith(KlotsConstants.MESSAGE_NEW_LINE) ) {
				console.print( line.replaceFirst(KlotsConstants.PRINT_TAG, "").replaceFirst(KlotsConstants.MESSAGE_NEW_LINE, "\n") );
			} else {
				console.print( line.replaceFirst(KlotsConstants.PRINT_TAG, "") );
			}
			line = comm.receiveMessageLine();
		}
		comm.closeTransmission(false);
	}
	
	
	public void destroy() {
		comm.closeTransmission(false);
	}
	
	
	
	/**
     * This method brings the Table view to the front.
     */
    public void bringToFront() {
        broughtToFront = false;
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                // bring view to the front (lazy loading)
                try {
                    IWorkbenchWindow window = KlotsPlugin.getDefault().getWorkbench()
                            .getActiveWorkbenchWindow();
                    IViewPart vP = window.getActivePage().showView("org.eclipse.ui.console.ConsoleView");
                    vP.setFocus();
                    // set done flag
                    broughtToFront = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        while (!broughtToFront) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
	
    
}
